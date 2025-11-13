package com.manacode.feedthechick.ui.main.gamescreen.engine;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00140\u0017J\u001a\u0010\u0018\u001a\u00020\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00140\u0017J\u0006\u0010\u0019\u001a\u00020\u0014J\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u0014J\u0006\u0010\u001f\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020\u0014J\u0016\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/manacode/feedthechick/ui/main/gamescreen/engine/GameEngine;", "", "()V", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/manacode/feedthechick/ui/main/gamescreen/engine/GameEvent;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/manacode/feedthechick/ui/main/gamescreen/engine/GameState;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "maxItems", "", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "acknowledgeChickIdle", "", "closeSettingsToHome", "onExit", "Lkotlin/Function1;", "onBackPressed", "pauseAndOpenSettings", "registerMistake", "registerSuccess", "removeItem", "id", "reset", "resumeFromSettings", "showIntroOnEnter", "spawnTick", "viewport", "Lcom/manacode/feedthechick/ui/main/gamescreen/engine/Viewport;", "density", "Landroidx/compose/ui/unit/Density;", "app_debug"})
public final class GameEngine {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.manacode.feedthechick.ui.main.gamescreen.engine.GameState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.manacode.feedthechick.ui.main.gamescreen.engine.GameState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.manacode.feedthechick.ui.main.gamescreen.engine.GameEvent> _events = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.SharedFlow<com.manacode.feedthechick.ui.main.gamescreen.engine.GameEvent> events = null;
    private final int maxItems = 8;
    
    public GameEngine() {
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
    
    public final void showIntroOnEnter() {
    }
    
    public final void pauseAndOpenSettings() {
    }
    
    public final void resumeFromSettings() {
    }
    
    public final void closeSettingsToHome(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onExit) {
    }
    
    public final void onBackPressed(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onExit) {
    }
    
    public final void registerSuccess() {
    }
    
    public final void registerMistake() {
    }
    
    public final void acknowledgeChickIdle() {
    }
    
    public final void removeItem(int id) {
    }
    
    public final void spawnTick(@org.jetbrains.annotations.NotNull()
    com.manacode.feedthechick.ui.main.gamescreen.engine.Viewport viewport, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.unit.Density density) {
    }
}