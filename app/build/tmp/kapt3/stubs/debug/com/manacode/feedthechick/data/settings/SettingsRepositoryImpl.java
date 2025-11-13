package com.manacode.feedthechick.data.settings;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/manacode/feedthechick/data/settings/SettingsRepositoryImpl;", "Lcom/manacode/feedthechick/data/settings/SettingsRepository;", "prefs", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getMusicVolume", "", "getSoundVolume", "setMusicVolume", "", "value", "setSoundVolume", "Companion", "app_debug"})
public final class SettingsRepositoryImpl implements com.manacode.feedthechick.data.settings.SettingsRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public static final java.lang.String KEY_MUSIC = "music_volume";
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public static final java.lang.String KEY_SOUND = "sound_volume";
    @java.lang.Deprecated()
    public static final int DEF_MUSIC = 70;
    @java.lang.Deprecated()
    public static final int DEF_SOUND = 80;
    @org.jetbrains.annotations.NotNull()
    private static final com.manacode.feedthechick.data.settings.SettingsRepositoryImpl.Companion Companion = null;
    
    @javax.inject.Inject()
    public SettingsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences prefs) {
        super();
    }
    
    @java.lang.Override()
    public int getMusicVolume() {
        return 0;
    }
    
    @java.lang.Override()
    public int getSoundVolume() {
        return 0;
    }
    
    @java.lang.Override()
    public void setMusicVolume(int value) {
    }
    
    @java.lang.Override()
    public void setSoundVolume(int value) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/manacode/feedthechick/data/settings/SettingsRepositoryImpl$Companion;", "", "()V", "DEF_MUSIC", "", "DEF_SOUND", "KEY_MUSIC", "", "KEY_SOUND", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}