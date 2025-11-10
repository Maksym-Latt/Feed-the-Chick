package com.manacode.feedthechick.ui.main.root

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.manacode.feedthechick.ui.main.gamescreen.GameScreen
import com.manacode.feedthechick.ui.main.menuscreen.MainViewModel
import com.manacode.feedthechick.ui.main.menuscreen.MenuScreen

@Composable
fun AppRoot(
    vm: MainViewModel = hiltViewModel(),
) {
    val ui by vm.ui.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF4D9))
    ) {
        Crossfade(targetState = ui.screen, label = "root_screen") { screen ->
            when (screen) {
                MainViewModel.Screen.Menu ->
                    MenuScreen(
                        onStartGame = vm::startGame,
                        lastScore = ui.lastScore.takeIf { it > 0 }
                    )

                MainViewModel.Screen.Game ->
                    GameScreen(
                        onExitToMenu = vm::backToMenu
                    )
            }
        }
    }
}
