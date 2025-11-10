package com.manacode.feedthechick

import com.manacode.eggmagnet.ui.main.menuscreen.MainViewModel
import com.manacode.eggmagnet.ui.main.menuscreen.MenuScreen
import com.manacode.eggmagnet.ui.main.menuscreen.PrivacyOverlay
import com.manacode.eggmagnet.ui.main.menuscreen.SettingsOverlay
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue

@Composable
fun AppRoot(
    vm: MainViewModel = hiltViewModel()
) {
    val ui by vm.ui.collectAsStateWithLifecycle()

    BackHandler(enabled = true) {
        if (!vm.onBackPressed()) {
            // no-op
        }
    }

    Box(Modifier.fillMaxSize().background(Color.Black)) {
        AnimatedContent(
            targetState = ui.screen,
            label = "screen",
            transitionSpec = { fadeIn() togetherWith fadeOut() }
        ) { screen ->
            when (screen) {
                MainViewModel.Screen.Menu -> MenuScreen(
                    onStartGame = vm::startGame,
                    onOpenSettings = vm::openSettings,
                )
                MainViewModel.Screen.Game -> GameScreen(
                    onExitToMenu = vm::backFromGameToMenu,
                )
            }
        }

        if (ui.screen == MainViewModel.Screen.Menu && ui.menuOverlay != MainViewModel.MenuOverlay.None) {
            when (ui.menuOverlay) {
                MainViewModel.MenuOverlay.Settings ->
                    SettingsOverlay(
                        onClose = vm::closeOverlay,
                        onPrivacy = vm::openPrivacy
                    )

                MainViewModel.MenuOverlay.Privacy ->
                    PrivacyOverlay(onClose = vm::closeOverlay)

                MainViewModel.MenuOverlay.None -> Unit
            }
        }
    }
}