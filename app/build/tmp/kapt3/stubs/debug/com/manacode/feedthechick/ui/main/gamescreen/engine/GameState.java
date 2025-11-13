package com.manacode.feedthechick.ui.main.gamescreen.engine;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0006H\u00c6\u0003J\t\u0010&\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0006H\u00c6\u0003J\t\u0010(\u001a\u00020\u0006H\u00c6\u0003J\t\u0010)\u001a\u00020\u000bH\u00c6\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J\t\u0010+\u001a\u00020\u0010H\u00c6\u0003Js\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010-\u001a\u00020\u00062\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001J\t\u00100\u001a\u000201H\u00d6\u0001R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!\u00a8\u00062"}, d2 = {"Lcom/manacode/feedthechick/ui/main/gamescreen/engine/GameState;", "", "score", "", "lives", "running", "", "showIntro", "showSettings", "showWin", "spawnDelay", "", "items", "", "Lcom/manacode/feedthechick/ui/main/gamescreen/engine/SpawnedItem;", "chickState", "Lcom/manacode/feedthechick/ui/main/gamescreen/engine/ChickState;", "nextItemId", "(IIZZZZJLjava/util/List;Lcom/manacode/feedthechick/ui/main/gamescreen/engine/ChickState;I)V", "getChickState", "()Lcom/manacode/feedthechick/ui/main/gamescreen/engine/ChickState;", "getItems", "()Ljava/util/List;", "getLives", "()I", "getNextItemId", "getRunning", "()Z", "getScore", "getShowIntro", "getShowSettings", "getShowWin", "getSpawnDelay", "()J", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class GameState {
    private final int score = 0;
    private final int lives = 0;
    private final boolean running = false;
    private final boolean showIntro = false;
    private final boolean showSettings = false;
    private final boolean showWin = false;
    private final long spawnDelay = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.manacode.feedthechick.ui.main.gamescreen.engine.SpawnedItem> items = null;
    @org.jetbrains.annotations.NotNull()
    private final com.manacode.feedthechick.ui.main.gamescreen.engine.ChickState chickState = null;
    private final int nextItemId = 0;
    
    public GameState(int score, int lives, boolean running, boolean showIntro, boolean showSettings, boolean showWin, long spawnDelay, @org.jetbrains.annotations.NotNull()
    java.util.List<com.manacode.feedthechick.ui.main.gamescreen.engine.SpawnedItem> items, @org.jetbrains.annotations.NotNull()
    com.manacode.feedthechick.ui.main.gamescreen.engine.ChickState chickState, int nextItemId) {
        super();
    }
    
    public final int getScore() {
        return 0;
    }
    
    public final int getLives() {
        return 0;
    }
    
    public final boolean getRunning() {
        return false;
    }
    
    public final boolean getShowIntro() {
        return false;
    }
    
    public final boolean getShowSettings() {
        return false;
    }
    
    public final boolean getShowWin() {
        return false;
    }
    
    public final long getSpawnDelay() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.manacode.feedthechick.ui.main.gamescreen.engine.SpawnedItem> getItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.manacode.feedthechick.ui.main.gamescreen.engine.ChickState getChickState() {
        return null;
    }
    
    public final int getNextItemId() {
        return 0;
    }
    
    public GameState() {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final long component7() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.manacode.feedthechick.ui.main.gamescreen.engine.SpawnedItem> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.manacode.feedthechick.ui.main.gamescreen.engine.ChickState component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.manacode.feedthechick.ui.main.gamescreen.engine.GameState copy(int score, int lives, boolean running, boolean showIntro, boolean showSettings, boolean showWin, long spawnDelay, @org.jetbrains.annotations.NotNull()
    java.util.List<com.manacode.feedthechick.ui.main.gamescreen.engine.SpawnedItem> items, @org.jetbrains.annotations.NotNull()
    com.manacode.feedthechick.ui.main.gamescreen.engine.ChickState chickState, int nextItemId) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}