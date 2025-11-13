package com.manacode.feedthechick.ui.main.gamescreen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a*\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\rH\u0007\u001a&\u0010\u000f\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007\u001a(\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a\"\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0016\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0011\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006 "}, d2 = {"Chick", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lcom/manacode/feedthechick/ui/main/gamescreen/engine/ChickState;", "onMouthMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Rect;", "DraggableItem", "item", "Lcom/manacode/feedthechick/ui/main/gamescreen/engine/SpawnedItem;", "onReleased", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "GameScreen", "onExitToMenu", "", "viewModel", "Lcom/manacode/feedthechick/ui/main/gamescreen/GameViewModel;", "LostLifeBurst", "at", "onFinished", "Lkotlin/Function0;", "LostLifeBurst-3MmeM6k", "(JLkotlin/jvm/functions/Function0;)V", "Scoreboard", "score", "lives", "shareScore", "context", "Landroid/content/Context;", "app_debug"})
public final class GameScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void GameScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onExitToMenu, @org.jetbrains.annotations.NotNull()
    com.manacode.feedthechick.ui.main.gamescreen.GameViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void Scoreboard(int score, int lives, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void Chick(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.manacode.feedthechick.ui.main.gamescreen.engine.ChickState state, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Rect, kotlin.Unit> onMouthMeasured) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DraggableItem(@org.jetbrains.annotations.NotNull()
    com.manacode.feedthechick.ui.main.gamescreen.engine.SpawnedItem item, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.manacode.feedthechick.ui.main.gamescreen.engine.SpawnedItem, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> onReleased) {
    }
    
    public static final void shareScore(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int score) {
    }
}