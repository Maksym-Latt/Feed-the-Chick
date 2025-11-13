package com.manacode.feedthechick.ui.main.gamescreen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0010J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u001a\u0010\u0019\u001a\u00020\u00102\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00100\u001bJ\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001e\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001cJ\u0006\u0010\"\u001a\u00020\u0010J\b\u0010#\u001a\u00020\u0010H\u0002J\u0006\u0010$\u001a\u00020\u0010J\u0006\u0010%\u001a\u00020\u0010J\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006*"}, d2 = {"Lcom/manacode/feedthechick/ui/main/gamescreen/GameViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "engine", "Lcom/manacode/feedthechick/ui/main/gamescreen/engine/GameEngine;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/manacode/feedthechick/ui/main/gamescreen/engine/GameEvent;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "firstLaunch", "", "spawnJob", "Lkotlinx/coroutines/Job;", "spawnTickHolder", "Lkotlin/Function0;", "", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/manacode/feedthechick/ui/main/gamescreen/engine/GameState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "acknowledgeChickIdle", "bindSpawner", "spawnTick", "closeSettingsToHome", "onExit", "Lkotlin/Function1;", "", "pauseAndOpenSettings", "registerMistake", "registerSuccess", "removeItem", "id", "reset", "restartSpawnLoop", "resumeFromSettings", "showIntroOnEnter", "viewport", "Lcom/manacode/feedthechick/ui/main/gamescreen/engine/Viewport;", "density", "Landroidx/compose/ui/unit/Density;", "app_debug"})
public final class GameViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.manacode.feedthechick.ui.main.gamescreen.engine.GameEngine engine = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.manacode.feedthechick.ui.main.gamescreen.engine.GameState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.manacode.feedthechick.ui.main.gamescreen.engine.GameEvent> events = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job spawnJob;
    private boolean firstLaunch = true;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> spawnTickHolder;
    
    public GameViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.manacode.feedthechick.ui.main.gamescreen.engine.GameState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.SharedFlow<com.manacode.feedthechick.ui.main.gamescreen.engine.GameEvent> getEvents() {
        return null;
    }
    
    public final void reset() {
    }
    
    public final void pauseAndOpenSettings() {
    }
    
    public final void resumeFromSettings() {
    }
    
    public final void closeSettingsToHome(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onExit) {
    }
    
    public final void showIntroOnEnter() {
    }
    
    public final void registerSuccess() {
    }
    
    public final void registerMistake() {
    }
    
    public final void removeItem(int id) {
    }
    
    public final void acknowledgeChickIdle() {
    }
    
    public final void spawnTick(@org.jetbrains.annotations.NotNull()
    com.manacode.feedthechick.ui.main.gamescreen.engine.Viewport viewport, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.unit.Density density) {
    }
    
    private final void restartSpawnLoop() {
    }
    
    public final void bindSpawner(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> spawnTick) {
    }
}