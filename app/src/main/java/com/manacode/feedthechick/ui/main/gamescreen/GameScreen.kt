package com.manacode.feedthechick.ui.main.gamescreen

import android.media.AudioManager
import android.media.ToneGenerator
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import com.manacode.feedthechick.R
import com.manacode.feedthechick.ui.main.component.GradientOutlinedText
import com.manacode.feedthechick.ui.main.component.GradientOutlinedTextShort
import com.manacode.feedthechick.ui.main.component.SecondaryIconButton
import com.manacode.feedthechick.ui.main.component.StartPrimaryButton
import kotlinx.coroutines.delay
import kotlin.math.roundToInt
import kotlin.random.Random
private const val INITIAL_SPAWN_DELAY = 1600L
private const val MIN_SPAWN_DELAY = 520L

@Composable
fun GameScreen(
    onExitToMenu: (Int) -> Unit,
) {

    // ----------------------- State -----------------------
    var score by remember { mutableIntStateOf(0) }
    var lives by remember { mutableIntStateOf(3) }
    var running by remember { mutableStateOf(false) }
    var showIntro by remember { mutableStateOf(true) }
    var showSettingsOverlay by remember { mutableStateOf(false) }
    var showWinOverlay by remember { mutableStateOf(false) }
    var spawnDelay by remember { mutableLongStateOf(INITIAL_SPAWN_DELAY) }
    val items = remember { mutableStateListOf<SpawnedItem>() }
    var nextItemId by remember { mutableIntStateOf(0) }
    var resetKey by remember { mutableIntStateOf(0) }
    var chickState by remember { mutableStateOf(ChickState.Idle) }

    val toneGenerator = remember { ToneGenerator(AudioManager.STREAM_MUSIC, 70) }
    DisposableEffect(Unit) { onDispose { toneGenerator.release() } }

    fun playCluck() { toneGenerator.startTone(ToneGenerator.TONE_PROP_BEEP2, 150) }

    LaunchedEffect(chickState) {
        if (chickState != ChickState.Idle) {
            delay(1000)
            chickState = ChickState.Idle
        }
    }

    fun resetGame() {
        items.clear()
        lives = 3
        score = 0
        spawnDelay = INITIAL_SPAWN_DELAY
        showIntro = false
        showSettingsOverlay = false
        showWinOverlay = false
        running = true
        resetKey++
        chickState = ChickState.Idle
    }

    fun registerMistake() {
        lives = (lives - 1).coerceAtLeast(0)
        chickState = ChickState.Cry
        if (lives <= 0) {
            running = false
            items.clear()
            showSettingsOverlay = false
            showWinOverlay = true
            showIntro = false
        }
    }

    fun registerSuccess() {
        score += 1
        spawnDelay = maxOf(MIN_SPAWN_DELAY, (spawnDelay * 0.92f).toLong())
        playCluck()
        chickState = ChickState.Happy
    }

    BackHandler(enabled = true) {
        when {
            showSettingsOverlay -> {
                showSettingsOverlay = false
                if (!showIntro && !showWinOverlay) running = true
            }
            showWinOverlay -> {
            }
            else -> {
                running = false
                onExitToMenu(score)
            }
        }
    }


    // ----------------------- Layout -----------------------
    Surface(color = MaterialTheme.colorScheme.background) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

            val density = LocalDensity.current
            val fieldHeight = maxHeight
            val fieldWidth = maxWidth
            val fieldWidthPx = with(density) { fieldWidth.toPx() }
            val fieldHeightPx = with(density) { fieldHeight.toPx() }
            val maxItems = 8
            var mouthBounds by remember { mutableStateOf<Rect?>(null) }

            // ----------------------- Spawn -----------------------
            fun spawnItem() {
                if (!running) return
                val type = ItemType.random()
                val size = type.size
                val sizePx = with(density) { size.toPx() }
                val horizontalPadding = with(density) { 24.dp.toPx() }
                val verticalPadding = with(density) { 24.dp.toPx() }
                val verticalLimit = fieldHeightPx * 0.7f
                val xRange = (fieldWidthPx - horizontalPadding * 2 - sizePx).coerceAtLeast(0f)
                val yRange = (verticalLimit - verticalPadding - sizePx).coerceAtLeast(0f)
                if (xRange <= 0f || yRange <= 0f) return

                val spacing = with(density) { 12.dp.toPx() }
                var placedItem: SpawnedItem? = null

                repeat(24) {
                    val startX = horizontalPadding + Random.nextFloat() * xRange
                    val startY = verticalPadding + Random.nextFloat() * yRange
                    val candidateRect = Rect(
                        left = startX - spacing,
                        top = startY - spacing,
                        right = startX + sizePx + spacing,
                        bottom = startY + sizePx + spacing
                    )
                    val overlapsExisting = items.any { existing ->
                        candidateRect.overlaps(existing.bounds(spacing))
                    }
                    if (!overlapsExisting) {
                        placedItem = SpawnedItem(
                            id = nextItemId++,
                            type = type,
                            size = size,
                            sizePx = sizePx,
                            startOffset = Offset(startX, startY),
                            spawnedAt = System.currentTimeMillis()
                        )
                        return@repeat
                    }
                }

                val newItem = placedItem ?: return
                items.add(newItem)

                if (items.size > maxItems) {
                    val removed = items.removeAt(0)
                    if (removed.type == ItemType.Seed) registerMistake()
                }
            }

            // ----------------------- Spawn loop -----------------------
            LaunchedEffect(running, resetKey) {
                if (!running) return@LaunchedEffect
                spawnItem()
                while (running) {
                    val delayMillis = spawnDelay
                    delay(delayMillis)
                    if (!running) break
                    spawnItem()
                }
            }

            // ----------------------- Background -----------------------
            Image(
                painter = painterResource(id = R.drawable.bg_game),
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )

            // ----------------------- Header -----------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                SecondaryIconButton(
                    onClick = {
                        running = false
                        showSettingsOverlay = true
                    },
                    modifier = Modifier.size(52.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize(0.8f)
                    )
                }

                Scoreboard(
                    score = score,
                    lives = lives,
                    modifier = Modifier.wrapContentWidth(Alignment.End)
                )
            }

            // ----------------------- Chicken -----------------------
            Chick(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 40.dp)
                    .size(fieldWidth * 0.7f),
                state = chickState,
                onMouthMeasured = { mouthBounds = it }
            )

            // ----------------------- Items -----------------------
            items.forEach { item ->
                key(item.id) {
                    DraggableItem(
                        item = item,
                        onReleased = { releasedItem, centerPoint ->
                            items.removeAll { it.id == releasedItem.id }
                            val mouth = mouthBounds
                            if (mouth != null && mouth.contains(centerPoint)) {
                                if (releasedItem.type == ItemType.Seed) registerSuccess()
                                else registerMistake()
                            } else {
                                if (releasedItem.type == ItemType.Seed) registerMistake()
                            }
                        }
                    )
                }
            }

            // ----------------------- Intro -----------------------
            AnimatedVisibility(
                visible = showIntro,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.zIndex(10f)
            ) {
                IntroOverlay(onStart = { resetGame() })
            }

            // ----------------------- Settings -----------------------
            AnimatedVisibility(
                visible = showSettingsOverlay,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.zIndex(15f)
            ) {
                GameSettingsOverlay(
                    onResume = {
                        showSettingsOverlay = false
                        if (!showIntro && !showWinOverlay) running = true
                    },
                    onRetry = {
                        showSettingsOverlay = false
                        resetGame()
                    },
                    onHome = {
                        showSettingsOverlay = false
                        running = false
                        onExitToMenu(score)
                    }
                )
            }

            // ----------------------- Win Overlay -----------------------
            AnimatedVisibility(
                visible = showWinOverlay,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.zIndex(20f)
            ) {
                WinOverlay(
                    score = score,
                    onRetry = {
                        showWinOverlay = false
                        resetGame()
                    },
                    onHome = {
                        showWinOverlay = false
                        running = false
                        onExitToMenu(score)
                    }
                )
            }
        }
    }
}

// ----------------------- SpawnedItem model -----------------------
private data class SpawnedItem(
    val id: Int,
    val type: ItemType,
    val size: Dp,
    val sizePx: Float,
    val startOffset: Offset,
    val spawnedAt: Long,
)

private fun SpawnedItem.bounds(extra: Float = 0f): Rect {
    return Rect(
        left = startOffset.x - extra,
        top = startOffset.y - extra,
        right = startOffset.x + sizePx + extra,
        bottom = startOffset.y + sizePx + extra
    )
}

// ----------------------- Types -----------------------
private enum class ItemType(
    val size: Dp,
    @DrawableRes val drawableRes: Int,
    val contentDescription: String,
) {
    Seed(72.dp, R.drawable.item_gold_corn, "Golden corn"),
    Rock(72.dp, R.drawable.item_stone, "Stone"),
    Frog(86.dp, R.drawable.item_frog, "Frog");

    companion object {
        fun random(): ItemType {
            val roll = Random.nextFloat()
            return when {
                roll < 0.6f -> Seed
                roll < 0.8f -> Rock
                else -> Frog
            }
        }
    }
}

private enum class ChickState { Idle, Happy, Cry }

// ----------------------- Scoreboard -----------------------
@Composable
private fun Scoreboard(
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

// ----------------------- Chicken -----------------------
@Composable
private fun Chick(
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
            contentDescription = "Chicken",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

// ----------------------- DraggableItem -----------------------
@Composable
private fun DraggableItem(
    item: SpawnedItem,
    onReleased: (SpawnedItem, Offset) -> Unit,
) {
    var offset by remember(item.id) { mutableStateOf(item.startOffset) }
    var isDragging by remember(item.id) { mutableStateOf(false) }
    val sizePx = item.sizePx
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
                    onReleased(item, offset + Offset(sizePx / 2f, sizePx / 2f))
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
