package com.manacode.feedthechick.data.settings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/manacode/feedthechick/data/settings/SettingsRepository;", "", "getMusicVolume", "", "getSoundVolume", "setMusicVolume", "", "value", "setSoundVolume", "app_debug"})
public abstract interface SettingsRepository {
    
    public abstract int getMusicVolume();
    
    public abstract int getSoundVolume();
    
    public abstract void setMusicVolume(int value);
    
    public abstract void setSoundVolume(int value);
}