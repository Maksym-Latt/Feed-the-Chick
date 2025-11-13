package com.manacode.feedthechick.ui.main.settings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/manacode/feedthechick/ui/main/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/manacode/feedthechick/data/settings/SettingsRepository;", "audio", "Lcom/manacode/feedthechick/audio/AudioController;", "(Lcom/manacode/feedthechick/data/settings/SettingsRepository;Lcom/manacode/feedthechick/audio/AudioController;)V", "_ui", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/manacode/feedthechick/ui/main/settings/SettingsUiState;", "ui", "Lkotlinx/coroutines/flow/StateFlow;", "getUi", "()Lkotlinx/coroutines/flow/StateFlow;", "setMusicVolume", "", "value", "", "setSoundVolume", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.manacode.feedthechick.data.settings.SettingsRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.manacode.feedthechick.audio.AudioController audio = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.manacode.feedthechick.ui.main.settings.SettingsUiState> _ui = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.manacode.feedthechick.ui.main.settings.SettingsUiState> ui = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.manacode.feedthechick.data.settings.SettingsRepository repo, @org.jetbrains.annotations.NotNull()
    com.manacode.feedthechick.audio.AudioController audio) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.manacode.feedthechick.ui.main.settings.SettingsUiState> getUi() {
        return null;
    }
    
    public final void setMusicVolume(int value) {
    }
    
    public final void setSoundVolume(int value) {
    }
}