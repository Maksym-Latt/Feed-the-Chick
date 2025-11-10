package com.manacode.feedthechick

import com.manacode.eggmagnet.ui.main.gamescreen.GameSettingsOverlay
import com.manacode.eggmagnet.ui.main.gamescreen.GameStartOverlay
import com.manacode.eggmagnet.ui.main.gamescreen.LoseOverlay
import com.manacode.eggmagnet.ui.main.gamescreen.WinOverlay

..ui.main.gamescreen

import android.R.attr.translationX
import android.R.attr.translationY
import android.app.Activity
import android.graphics.RectF
import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.manacode.eggmagnet.audio.rememberAudioController
import com.manacode.eggmagnet.ui.main.component.GradientOutlinedText
import com.manacode.eggmagnet.ui.main.component.GradientOutlinedTextShort
import com.manacode.eggmagnet.ui.main.component.SecondaryIconButton
import kotlin.random.Random

@Composable
fun GameScreen(
    onExitToMenu: () -> Unit,
    onExitToMenuWithMagnetShop: () -> Unit,
    playerVm: PlayerViewModel = hiltViewModel()
) {
    val p by playerVm.ui.collectAsStateWithLifecycle()

    // битмапы
    val ctx = LocalContext.current
    val activity = ctx as? Activity

    val audio = rememberAudioController()

    @Composable
    fun ib(@DrawableRes id: Int) = remember(id) { ImageBitmap.imageResource(ctx.resources, id) }
    val bgBm = ib(R.drawable.bg_game)
    val eggBm = ib(R.drawable.item_egg)
    val rockBm = ib(R.drawable.item_rock)
    val playerBm = p.playerSkinRes?.let { ib(it) }

    // верхний state экрана
    var running by remember { mutableStateOf(false) }   // старт/пауза/стоп
    var paused by remember { mutableStateOf(false) }
    var score by remember { mutableIntStateOf(0) }
    var target by remember { mutableIntStateOf(p.required) }
    var resetKey by remember { mutableIntStateOf(0) }
    var isWin by remember { mutableStateOf(false) }
    var isLose by remember { mutableStateOf(false) }

    LifecycleEventEffect(Lifecycle.Event.ON_PAUSE) {
        if (running && !paused && !isWin && !isLose) {
            paused = true
        }
    }

    BackHandler(enabled = true) {
        when {
            running && !paused && !isWin && !isLose -> paused = true
            paused && running && !isWin && !isLose -> activity?.moveTaskToBack(true)
            else -> onExitToMenu()
        }
    }

    // ======= СЛОИ =======
    Box(Modifier.fillMaxSize()) {

        // 1) сам движок (тонкий)
        GameEngineCanvas(

        )

        // 2) HUD
        Column(
            Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(top = 8.dp)
        ) {

        }

        // 3) Оверлеи
        if (!running) {
            GameStartOverlay(
                onStart = {
                    isWin = false; score = 0; target = p.required; resetKey++
                    running = true; paused = false
                }
            )
        } else if (paused && !isWin && !isLose) {
            GameSettingsOverlay(
                onResume = { paused = false },
                onRetry = {
                    resetKey++; score = 0; isWin = false; paused = false
                },
                onHome = {
                    running = false; paused = false; isWin = false
                    onExitToMenu()
                }
            )
        } else if (isWin) {
            WinOverlay(
                totalPoints = p.points,
                gainedPoints = score,
                onOpenMagnetShop = {
                    running = false; isWin = false
                    onExitToMenuWithMagnetShop()
                },
                onPlayAgain = {
                    resetKey++; score = 0; isWin = false; paused = false
                    target = playerVm.ui.value.required
                },
                onMenu = {
                    running = false; isWin = false
                    onExitToMenu()
                }
            )
        } else if (isLose) {
            LoseOverlay(
                totalPoints = p.points,
                gainedPoints = 0,
                onOpenMagnetShop = {
                    running = false; isLose = false; isWin = false
                    onExitToMenuWithMagnetShop()
                },
                onPlayAgain = {
                    resetKey++; score = 0; isLose = false; isWin = false; paused = false
                    target = playerVm.ui.value.required
                },
                onMenu = {
                    running = false; isLose = false
                    onExitToMenu()
                }
            )
        }
    }
}