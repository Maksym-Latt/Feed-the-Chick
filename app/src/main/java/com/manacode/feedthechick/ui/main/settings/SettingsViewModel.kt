package com.manacode.feedthechick.ui.main.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manacode.feedthechick.audio.AudioController
import com.manacode.feedthechick.data.settings.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repo: SettingsRepository,
    private val audio: AudioController
) : ViewModel() {

    private companion object {
        const val DEFAULT_MUSIC_VOLUME = 70
        const val DEFAULT_SOUND_VOLUME = 80
    }

    private val _ui = MutableStateFlow(SettingsUiState())
    val ui: StateFlow<SettingsUiState> = _ui

    private var lastMusicVolume = DEFAULT_MUSIC_VOLUME
    private var lastSoundVolume = DEFAULT_SOUND_VOLUME

    init {
        val music = repo.getMusicVolume()
        val sound = repo.getSoundVolume()
        _ui.value = SettingsUiState(
            musicVolume = music,
            soundVolume = sound
        )
        audio.setMusicVolume(music)
        audio.setSoundVolume(sound)

        if (music > 0) {
            lastMusicVolume = music
        }
        if (sound > 0) {
            lastSoundVolume = sound
        }
    }

    fun setMusicVolume(value: Int) {
        val v = value.coerceIn(0, 100)
        _ui.value = _ui.value.copy(musicVolume = v)
        viewModelScope.launch { repo.setMusicVolume(v) }
        audio.setMusicVolume(v)
        if (v > 0) {
            lastMusicVolume = v
        }
    }

    fun setSoundVolume(value: Int) {
        val v = value.coerceIn(0, 100)
        _ui.value = _ui.value.copy(soundVolume = v)
        viewModelScope.launch { repo.setSoundVolume(v) }
        audio.setSoundVolume(v)
        if (v > 0) {
            lastSoundVolume = v
        }
    }

    fun setMusicEnabled(enabled: Boolean) {
        if (enabled) {
            val target = lastMusicVolume.takeIf { it > 0 } ?: DEFAULT_MUSIC_VOLUME
            setMusicVolume(target)
        } else {
            lastMusicVolume = _ui.value.musicVolume.takeIf { it > 0 } ?: lastMusicVolume
            setMusicVolume(0)
        }
    }

    fun setSoundEnabled(enabled: Boolean) {
        if (enabled) {
            val target = lastSoundVolume.takeIf { it > 0 } ?: DEFAULT_SOUND_VOLUME
            setSoundVolume(target)
        } else {
            lastSoundVolume = _ui.value.soundVolume.takeIf { it > 0 } ?: lastSoundVolume
            setSoundVolume(0)
        }
    }
}
