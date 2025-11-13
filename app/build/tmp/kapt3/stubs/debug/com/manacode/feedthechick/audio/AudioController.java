package com.manacode.feedthechick.audio;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u0003H&\u00a8\u0006\u000f"}, d2 = {"Lcom/manacode/feedthechick/audio/AudioController;", "", "pauseMusic", "", "playGameFeed", "playGameLose", "playGameMusic", "playGameWin", "playMenuMusic", "resumeMusic", "setMusicVolume", "percent", "", "setSoundVolume", "stopMusic", "app_debug"})
public abstract interface AudioController {
    
    public abstract void playMenuMusic();
    
    public abstract void playGameMusic();
    
    public abstract void stopMusic();
    
    public abstract void pauseMusic();
    
    public abstract void resumeMusic();
    
    public abstract void setMusicVolume(int percent);
    
    public abstract void setSoundVolume(int percent);
    
    public abstract void playGameFeed();
    
    public abstract void playGameWin();
    
    public abstract void playGameLose();
}