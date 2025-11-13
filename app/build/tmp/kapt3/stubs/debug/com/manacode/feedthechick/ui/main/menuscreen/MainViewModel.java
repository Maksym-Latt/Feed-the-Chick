package com.manacode.feedthechick.ui.main.menuscreen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/manacode/feedthechick/ui/main/menuscreen/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_ui", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/manacode/feedthechick/ui/main/menuscreen/MainViewModel$UiState;", "ui", "Lkotlinx/coroutines/flow/StateFlow;", "getUi", "()Lkotlinx/coroutines/flow/StateFlow;", "backToMenu", "", "score", "", "startGame", "Screen", "UiState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.manacode.feedthechick.ui.main.menuscreen.MainViewModel.UiState> _ui = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.manacode.feedthechick.ui.main.menuscreen.MainViewModel.UiState> ui = null;
    
    @javax.inject.Inject()
    public MainViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.manacode.feedthechick.ui.main.menuscreen.MainViewModel.UiState> getUi() {
        return null;
    }
    
    public final void startGame() {
    }
    
    public final void backToMenu(int score) {
    }
    
    public final void backToMenu() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/manacode/feedthechick/ui/main/menuscreen/MainViewModel$Screen;", "", "(Ljava/lang/String;I)V", "Menu", "Game", "app_debug"})
    public static enum Screen {
        /*public static final*/ Menu /* = new Menu() */,
        /*public static final*/ Game /* = new Game() */;
        
        Screen() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.manacode.feedthechick.ui.main.menuscreen.MainViewModel.Screen> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/manacode/feedthechick/ui/main/menuscreen/MainViewModel$UiState;", "", "screen", "Lcom/manacode/feedthechick/ui/main/menuscreen/MainViewModel$Screen;", "lastScore", "", "(Lcom/manacode/feedthechick/ui/main/menuscreen/MainViewModel$Screen;I)V", "getLastScore", "()I", "getScreen", "()Lcom/manacode/feedthechick/ui/main/menuscreen/MainViewModel$Screen;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class UiState {
        @org.jetbrains.annotations.NotNull()
        private final com.manacode.feedthechick.ui.main.menuscreen.MainViewModel.Screen screen = null;
        private final int lastScore = 0;
        
        public UiState(@org.jetbrains.annotations.NotNull()
        com.manacode.feedthechick.ui.main.menuscreen.MainViewModel.Screen screen, int lastScore) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.manacode.feedthechick.ui.main.menuscreen.MainViewModel.Screen getScreen() {
            return null;
        }
        
        public final int getLastScore() {
            return 0;
        }
        
        public UiState() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.manacode.feedthechick.ui.main.menuscreen.MainViewModel.Screen component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.manacode.feedthechick.ui.main.menuscreen.MainViewModel.UiState copy(@org.jetbrains.annotations.NotNull()
        com.manacode.feedthechick.ui.main.menuscreen.MainViewModel.Screen screen, int lastScore) {
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
}