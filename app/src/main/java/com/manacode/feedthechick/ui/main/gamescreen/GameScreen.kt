package com.manacode.feedthechick.ui.main.gamescreen

import android.media.AudioManager
import android.media.ToneGenerator
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.manacode.feedthechick.ui.main.component.FarmBackground
import com.manacode.feedthechick.ui.main.component.GradientOutlinedText
import com.manacode.feedthechick.ui.main.component.OrangePrimaryButton
import com.manacode.feedthechick.ui.main.component.SecondaryIconButton
import com.manacode.feedthechick.ui.main.component.StartPrimaryButton
import kotlinx.coroutines.delay
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun GameScreen(
    onExitToMenu: (Int) -> Unit,
) {
    var score by remember { mutableIntStateOf(0) }
    var lives by remember { mutableIntStateOf(3) }
    var running by remember { mutableStateOf(false) }
    var showIntro by remember { mutableStateOf(true) }
    var showGameOver by remember { mutableStateOf(false) }
    var spawnDelay by remember { mutableLongStateOf(1600L) }
    val items = remember { mutableStateListOf<SpawnedItem>() }
    var nextItemId by remember { mutableIntStateOf(0) }
    var resetKey by remember { mutableIntStateOf(0) }

    val toneGenerator = remember {
        ToneGenerator(AudioManager.STREAM_MUSIC, 70)
    }
    DisposableEffect(Unit) {
        onDispose { toneGenerator.release() }
    }

    fun playCluck() {
        toneGenerator.startTone(ToneGenerator.TONE_PROP_BEEP2, 150)
    }

    fun resetGame() {
        items.clear()
        lives = 3
        score = 0
        spawnDelay = 1600L
        showIntro = false
        showGameOver = false
        running = true
        resetKey++
    }

    fun finishGame() {
        running = false
        showGameOver = true
        items.clear()
    }

    fun registerMistake() {
        lives = (lives - 1).coerceAtLeast(0)
        if (lives <= 0) {
            finishGame()
        }
    }

    fun registerSuccess() {
        score += 1
        spawnDelay = maxOf(520L, (spawnDelay * 0.92f).toLong())
        playCluck()
    }

    BackHandler(enabled = true) {
        running = false
        onExitToMenu(score)
    }

    Surface(color = MaterialTheme.colorScheme.background) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val density = LocalDensity.current
            val fieldHeight = maxHeight
            val fieldWidth = maxWidth
            val fieldWidthPx = with(density) { fieldWidth.toPx() }
            val fieldHeightPx = with(density) { fieldHeight.toPx() }
            val maxItems = 6

            var mouthBounds by remember { mutableStateOf<Rect?>(null) }

            fun spawnItem() {
                if (!running) return
                val type = ItemType.random()
                val size = type.size
                val sizePx = with(density) { size.toPx() }
                val horizontalPadding = with(density) { 36.dp.toPx() }
                val verticalLimit = fieldHeightPx * 0.55f
                val xRange = (fieldWidthPx - horizontalPadding * 2 - sizePx).coerceAtLeast(0f)
                val yRange = (verticalLimit - horizontalPadding - sizePx).coerceAtLeast(0f)
                val startX = horizontalPadding + Random.nextFloat() * xRange
                val startY = horizontalPadding + Random.nextFloat() * yRange
                val item = SpawnedItem(
                    id = nextItemId++,
                    type = type,
                    size = size,
                    sizePx = sizePx,
                    startOffset = Offset(startX, startY),
                    spawnedAt = System.currentTimeMillis()
                )
                items.add(item)
                if (items.size > maxItems) {
                    val removed = items.removeAt(0)
                    if (removed.type == ItemType.Seed) {
                        registerMistake()
                    }
                }
            }

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

            FarmBackground(modifier = Modifier.matchParentSize())

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SecondaryIconButton(onClick = {
                    val finalScore = score
                    running = false
                    items.clear()
                    showGameOver = false
                    onExitToMenu(finalScore)
                }) {
                    Icon(Icons.Default.Home, contentDescription = null, tint = Color.White)
                }

                Scoreboard(
                    score = score,
                    lives = lives,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 24.dp)
                )

                SecondaryIconButton(onClick = { resetGame() }) {
                    Icon(Icons.Default.Refresh, contentDescription = null, tint = Color.White)
                }
            }

            Chick(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 40.dp)
                    .size(fieldWidth * 0.7f),
                onMouthMeasured = { layoutBounds ->
                    val horizontalPadding = with(density) { 32.dp.toPx() }
                    val verticalPadding = with(density) { 20.dp.toPx() }
                    mouthBounds = layoutBounds.expand(horizontalPadding, verticalPadding)
                }
            )

            items.forEach { item ->
                key(item.id) {
                    DraggableItem(
                        item = item,
                        onReleased = { releasedItem, centerPoint ->
                            items.removeAll { it.id == releasedItem.id }
                            val mouth = mouthBounds
                            if (mouth != null && mouth.contains(centerPoint)) {
                                if (releasedItem.type == ItemType.Seed) {
                                    registerSuccess()
                                } else {
                                    registerMistake()
                                }
                            } else {
                                if (releasedItem.type == ItemType.Seed) {
                                    registerMistake()
                                }
                            }
                            if (!running && !showGameOver) {
                                finishGame()
                            }
                        }
                    )
                }
            }

            AnimatedVisibility(
                visible = showIntro,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                IntroOverlay(onStart = { resetGame() })
            }

            AnimatedVisibility(
                visible = showGameOver,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                GameOverOverlay(
                    score = score,
                    onRetry = { resetGame() },
                    onExit = {
                        running = false
                        onExitToMenu(score)
                    }
                )
            }
        }
    }
}

private data class SpawnedItem(
    val id: Int,
    val type: ItemType,
    val size: androidx.compose.ui.unit.Dp,
    val sizePx: Float,
    val startOffset: Offset,
    val spawnedAt: Long,
)

private enum class ItemType(val size: androidx.compose.ui.unit.Dp) {
    Seed(54.dp),
    Rock(60.dp),
    Frog(66.dp);

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

private fun Rect.expand(horizontal: Float, vertical: Float): Rect {
    val hx = horizontal.coerceAtLeast(0f)
    val vy = vertical.coerceAtLeast(0f)
    return Rect(left - hx, top - vy, right + hx, bottom + vy)
}

@Composable
private fun Scoreboard(score: Int, lives: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GradientOutlinedText(
            text = "Seeds Fed: $score",
            fontSize = 28.sp,
            gradientColors = listOf(Color(0xFFFFF3C1), Color(0xFFFFC86B))
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            repeat(3) { index ->
                EggIcon(filled = index < lives)
            }
        }
    }
}

@Composable
private fun EggIcon(filled: Boolean) {
    Box(
        modifier = Modifier
            .size(30.dp, 40.dp)
            .shadow(8.dp, shape = CircleShape, clip = false)
            .clip(CircleShape)
            .background(if (filled) Color(0xFFFFF6DB) else Color(0x55FFFFFF)),
        contentAlignment = Alignment.BottomCenter
    ) {
        if (filled) {
            Box(
                modifier = Modifier
                    .size(16.dp, 8.dp)
                    .offset(y = (-4).dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFFD180))
            )
        }
    }
}

@Composable
private fun Chick(
    modifier: Modifier,
    onMouthMeasured: (Rect) -> Unit,
) {
    Box(modifier = modifier) {
        androidx.compose.foundation.Canvas(modifier = Modifier.matchParentSize()) {
            val bodyCenter = Offset(size.width / 2f, size.height * 0.6f)
            val bodyRadius = size.minDimension * 0.35f
            drawCircle(color = Color(0xFFFFE173), radius = bodyRadius, center = bodyCenter)
            val headRadius = size.minDimension * 0.26f
            drawCircle(color = Color(0xFFFFEB8A), radius = headRadius, center = Offset(size.width / 2f, size.height * 0.37f))
            drawCircle(color = Color(0xFFFFF7C8), radius = headRadius * 0.4f, center = Offset(size.width * 0.45f, size.height * 0.32f))
            drawCircle(color = Color(0xFFFFF7C8), radius = headRadius * 0.4f, center = Offset(size.width * 0.55f, size.height * 0.32f))
            drawCircle(color = Color.Black.copy(alpha = 0.8f), radius = headRadius * 0.14f, center = Offset(size.width * 0.45f, size.height * 0.32f))
            drawCircle(color = Color.Black.copy(alpha = 0.8f), radius = headRadius * 0.14f, center = Offset(size.width * 0.55f, size.height * 0.32f))
            drawCircle(color = Color.White.copy(alpha = 0.8f), radius = headRadius * 0.05f, center = Offset(size.width * 0.47f, size.height * 0.30f))
            drawCircle(color = Color.White.copy(alpha = 0.8f), radius = headRadius * 0.05f, center = Offset(size.width * 0.57f, size.height * 0.30f))
            drawCircle(color = Color(0xFFFFE173).copy(alpha = 0.85f), radius = bodyRadius * 0.7f, center = Offset(size.width * 0.33f, size.height * 0.65f))
            drawCircle(color = Color(0xFFFFE173).copy(alpha = 0.85f), radius = bodyRadius * 0.7f, center = Offset(size.width * 0.67f, size.height * 0.65f))
            drawCircle(color = Color(0xFFFFF3B0), radius = size.minDimension * 0.12f, center = Offset(size.width * 0.35f, size.height * 0.43f))
            drawCircle(color = Color(0xFFFFF3B0), radius = size.minDimension * 0.12f, center = Offset(size.width * 0.65f, size.height * 0.43f))
        }

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 12.dp)
                .size(width = 140.dp, height = 62.dp)
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(40.dp))
                .background(Color(0xFFFFA726))
                .onGloballyPositioned { layout -> onMouthMeasured(layout.boundsInRoot()) }
        )

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 12.dp)
                .size(width = 90.dp, height = 32.dp)
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(18.dp))
                .background(Color(0xFFFFCC80))
        )
    }
}

@Composable
private fun DraggableItem(
    item: SpawnedItem,
    onReleased: (SpawnedItem, Offset) -> Unit,
) {
    val density = LocalDensity.current
    var offset by remember(item.id) { mutableStateOf(item.startOffset) }
    var isDragging by remember(item.id) { mutableStateOf(false) }
    val sizePx = item.sizePx
    val scale by animateFloatAsState(if (isDragging) 1.12f else 1f, label = "drag-scale")

    val dragModifier = Modifier
        .offset {
            IntOffset(offset.x.roundToInt(), offset.y.roundToInt())
        }
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .size(item.size)
        .zIndex(if (isDragging) 2f else 1f)
        .pointerInput(item.id) {
            detectDragGestures(
                onDragStart = {
                    isDragging = true
                },
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

    Box(modifier = dragModifier) {
        when (item.type) {
            ItemType.Seed -> SeedItem(isDragging)
            ItemType.Rock -> RockItem(isDragging)
            ItemType.Frog -> FrogItem(isDragging)
        }
    }
}

@Composable
private fun SeedItem(isDragging: Boolean) {
    val baseColor = if (isDragging) Color(0xFFFFD54F) else Color(0xFFFFE082)
    androidx.compose.foundation.Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(color = baseColor)
        drawCircle(color = Color(0xFFFFC107), radius = size.minDimension / 2.6f, center = Offset(size.width * 0.45f, size.height * 0.42f))
    }
}

@Composable
private fun RockItem(isDragging: Boolean) {
    androidx.compose.foundation.Canvas(modifier = Modifier.fillMaxSize()) {
        val rockColor = if (isDragging) Color(0xFF8D6E63) else Color(0xFF9E8E89)
        drawRoundRect(color = rockColor, cornerRadius = androidx.compose.ui.geometry.CornerRadius(32f, 32f))
        drawRect(color = Color(0xFFBCAAA4), topLeft = Offset(size.width * 0.2f, size.height * 0.2f), size = Size(size.width * 0.35f, size.height * 0.25f))
    }
}

@Composable
private fun FrogItem(isDragging: Boolean) {
    androidx.compose.foundation.Canvas(modifier = Modifier.fillMaxSize()) {
        val bodyColor = if (isDragging) Color(0xFF81C784) else Color(0xFFA5D6A7)
        drawRoundRect(color = bodyColor, cornerRadius = androidx.compose.ui.geometry.CornerRadius(size.minDimension / 2, size.minDimension / 2))
        val eyeRadius = size.minDimension * 0.15f
        drawCircle(color = Color.White, radius = eyeRadius, center = Offset(size.width * 0.3f, size.height * 0.3f))
        drawCircle(color = Color.White, radius = eyeRadius, center = Offset(size.width * 0.7f, size.height * 0.3f))
        drawCircle(color = Color.Black, radius = eyeRadius * 0.4f, center = Offset(size.width * 0.3f, size.height * 0.3f))
        drawCircle(color = Color.Black, radius = eyeRadius * 0.4f, center = Offset(size.width * 0.7f, size.height * 0.3f))
        drawOval(color = Color(0xFF66BB6A), topLeft = Offset(size.width * 0.25f, size.height * 0.6f), size = Size(size.width * 0.5f, size.height * 0.3f))
    }
}

@Composable
private fun IntroOverlay(onStart: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xAA2C1505)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .background(Color(0xFFFFF4D2), shape = androidx.compose.foundation.shape.RoundedCornerShape(28.dp))
                .padding(horizontal = 32.dp, vertical = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GradientOutlinedText(
                text = "Нагодуй курча!",
                fontSize = 30.sp,
                gradientColors = listOf(Color(0xFFFFF7C1), Color(0xFFFFC86B))
            )
            Text(
                text = "Перетягни зернятка у дзьобик і не дай курчаті з'їсти каміння чи жаб.",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFF704117),
                    textAlign = TextAlign.Center,
                    lineHeight = 22.sp
                ),
                textAlign = TextAlign.Center
            )
            StartPrimaryButton(text = "Start", onClick = onStart)
        }
    }
}

@Composable
private fun GameOverOverlay(score: Int, onRetry: () -> Unit, onExit: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xAA2C1505)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .background(Color(0xFFFFF4D2), shape = androidx.compose.foundation.shape.RoundedCornerShape(28.dp))
                .padding(horizontal = 32.dp, vertical = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GradientOutlinedText(
                text = "You Fed $score seeds!",
                fontSize = 30.sp,
                gradientColors = listOf(Color(0xFFFFF7C1), Color(0xFFFFC86B))
            )
            Text(
                text = "Хочеш спробувати ще раз?",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFF704117))
            )
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                OrangePrimaryButton(text = "Retry", onClick = onRetry)
                OrangePrimaryButton(text = "Меню", onClick = onExit)
            }
        }
    }
}
