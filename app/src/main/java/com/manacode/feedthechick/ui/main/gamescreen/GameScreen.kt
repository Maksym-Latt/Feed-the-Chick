package com.manacode.feedthechick.ui.main.gamescreen

import android.media.AudioManager
import android.media.ToneGenerator
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.key
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.Dp
import com.manacode.feedthechick.R
import com.manacode.feedthechick.ui.main.component.GradientOutlinedTextShort
import com.manacode.feedthechick.ui.main.component.SecondaryIconButton
import com.manacode.feedthechick.ui.main.gamescreen.engine.ChickState
import com.manacode.feedthechick.ui.main.gamescreen.engine.GameEvent
import com.manacode.feedthechick.ui.main.gamescreen.engine.ItemType
import com.manacode.feedthechick.ui.main.gamescreen.engine.SpawnedItem
import com.manacode.feedthechick.ui.main.gamescreen.engine.Viewport
import com.manacode.feedthechick.ui.main.gamescreen.overlay.GameSettingsOverlay
import com.manacode.feedthechick.ui.main.gamescreen.overlay.IntroOverlay
import com.manacode.feedthechick.ui.main.gamescreen.overlay.WinOverlay
import kotlinx.coroutines.delay
import kotlin.math.roundToInt
import kotlin.random.Random

// ----------------------- Composable -----------------------
@Composable
fun GameScreen(
    onExitToMenu: (Int) -> Unit,
    viewModel: GameViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    // ----------------------- Audio -----------------------
    val toneGenerator = remember { android.media.ToneGenerator(android.media.AudioManager.STREAM_MUSIC, 70) }
    DisposableEffect(Unit) { onDispose { toneGenerator.release() } }
    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                GameEvent.Cluck -> toneGenerator.startTone(android.media.ToneGenerator.TONE_PROP_BEEP2, 150)
            }
        }
    }

    // ----------------------- State -----------------------
    val state by viewModel.state.collectAsState()

    LaunchedEffect(state.chickState) {
        if (state.chickState != ChickState.Idle) {
            delay(1000)
            viewModel.acknowledgeChickIdle()
        }
    }

    // ----------------------- Layout -----------------------
    Surface(color = MaterialTheme.colorScheme.background) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

            val density = LocalDensity.current
            val fieldWidth = maxWidth
            val fieldHeight = maxHeight
            val fieldWidthPx = with(density) { fieldWidth.toPx() }
            val fieldHeightPx = with(density) { fieldHeight.toPx() }

            var mouthBounds by remember { mutableStateOf<Rect?>(null) }

            LaunchedEffect(fieldWidthPx, fieldHeightPx) {
                viewModel.bindSpawner(
                    spawnTick = {
                        val vp = Viewport(
                            widthPx = fieldWidthPx,
                            heightPx = fieldHeightPx,
                            horizontalPaddingPx = with(density) { 24.dp.toPx() },
                            verticalPaddingPx = with(density) { 24.dp.toPx() },
                            verticalLimitRatio = 0.7f
                        )
                        viewModel.spawnTick(vp, density)
                    }
                )
            }

            Image(
                painter = painterResource(id = R.drawable.bg_game),
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                SecondaryIconButton(
                    onClick = { viewModel.pauseAndOpenSettings() },
                    modifier = Modifier.size(62.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize(0.8f)
                    )
                }
                Scoreboard(
                    score = state.score,
                    lives = state.lives,
                    modifier = Modifier.wrapContentWidth(Alignment.End)
                )
            }

            Chick(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 40.dp)
                    .size(fieldWidth * 0.7f),
                state = state.chickState,
                onMouthMeasured = { mouthBounds = it }
            )

            state.items.forEach { item ->
                key(item.id) {
                    DraggableItem(
                        item = item,
                        onReleased = { released, center ->
                            viewModel.removeItem(released.id)
                            val mouth = mouthBounds
                            if (mouth != null && mouth.contains(center)) {
                                if (released.type == ItemType.Seed) viewModel.registerSuccess()
                                else viewModel.registerMistake()
                            } else {
                                if (released.type == ItemType.Seed) viewModel.registerMistake()
                            }
                        }
                    )
                }
            }

            AnimatedVisibility(
                visible = state.showIntro,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.zIndex(10f)
            ) {
                IntroOverlay(onStart = { viewModel.reset() })
            }

            AnimatedVisibility(
                visible = state.showSettings,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.zIndex(15f)
            ) {
                GameSettingsOverlay(
                    onResume = { viewModel.resumeFromSettings() },
                    onRetry = { viewModel.reset() },
                    onHome = { viewModel.closeSettingsToHome(onExitToMenu) }
                )
            }

            AnimatedVisibility(
                visible = state.showWin,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.zIndex(20f)
            ) {
                WinOverlay(
                    score = state.score,
                    onSupport = { /* открыть донат/поддержку */ },
                    onHome = { onExitToMenu(state.score) }
                )
            }
        }
    }
}


@Composable
fun Scoreboard(
    score: Int,
    lives: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.End
    ) {
        GradientOutlinedTextShort(
            text = "Corn fed: $score",
            fontSize = 28.sp,
            gradientColors = listOf(Color(0xFFFFF4C2), Color(0xFFFFC66E)),
            textAlign = TextAlign.End,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            repeat(3) { index ->
                val filled = index < lives
                Image(
                    painter = painterResource(id = R.drawable.item_egg),
                    contentDescription = null,
                    modifier = Modifier
                        .size(44.dp)
                        .graphicsLayer(alpha = if (filled) 1f else 0.35f),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

// ----------------------- Chick -----------------------
@Composable
fun Chick(
    modifier: Modifier,
    state: ChickState,
    onMouthMeasured: (Rect) -> Unit,
) {
    val density = LocalDensity.current
    val imageRes = when (state) {
        ChickState.Idle -> R.drawable.chicken_idle
        ChickState.Happy -> R.drawable.chicken_happy
        ChickState.Cry -> R.drawable.chicken_cry
    }
    Box(
        modifier = modifier.onGloballyPositioned { layout ->
            val bounds = layout.boundsInRoot()
            val extra = with(density) { 16.dp.toPx() }
            val expanded = Rect(
                left = bounds.left - extra,
                top = bounds.top - extra,
                right = bounds.right + extra,
                bottom = bounds.bottom + extra
            )
            onMouthMeasured(expanded)
        }
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

// ----------------------- DraggableItem -----------------------
@Composable
fun DraggableItem(
    item: SpawnedItem,
    onReleased: (SpawnedItem, Offset) -> Unit,
) {
    var offset by remember(item.id) { mutableStateOf(item.startOffset) }
    var isDragging by remember(item.id) { mutableStateOf(false) }
    val scale by animateFloatAsState(if (isDragging) 1.12f else 1f, label = "drag-scale")

    val dragModifier = Modifier
        .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
        .graphicsLayer { scaleX = scale; scaleY = scale }
        .size(item.size)
        .zIndex(if (isDragging) 2f else 1f)
        .pointerInput(item.id) {
            detectDragGestures(
                onDragStart = { isDragging = true },
                onDrag = { change, dragAmount ->
                    change.consume()
                    offset += dragAmount
                },
                onDragEnd = {
                    isDragging = false
                    onReleased(item, offset + Offset(item.sizePx / 2f, item.sizePx / 2f))
                },
                onDragCancel = {
                    isDragging = false
                    offset = item.startOffset
                }
            )
        }

    Image(
        painter = painterResource(id = item.type.drawableRes),
        contentDescription = item.type.contentDescription,
        modifier = dragModifier.graphicsLayer { alpha = if (isDragging) 0.85f else 1f },
        contentScale = ContentScale.Fit
    )
}
