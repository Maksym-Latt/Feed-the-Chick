package com.manacode.feedthechick.ui.main.gamescreen.engine;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\u0014"}, d2 = {"Lcom/manacode/feedthechick/ui/main/gamescreen/engine/ItemType;", "", "size", "Landroidx/compose/ui/unit/Dp;", "drawableRes", "", "contentDescription", "", "(Ljava/lang/String;IFILjava/lang/String;)V", "getContentDescription", "()Ljava/lang/String;", "getDrawableRes", "()I", "getSize-D9Ej5fM", "()F", "F", "Seed", "Rock", "Frog", "Companion", "app_debug"})
public enum ItemType {
    /*public static final*/ Seed /* = new Seed(0.0F, 0, null) */,
    /*public static final*/ Rock /* = new Rock(0.0F, 0, null) */,
    /*public static final*/ Frog /* = new Frog(0.0F, 0, null) */;
    private final float size = 0.0F;
    private final int drawableRes = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contentDescription = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.manacode.feedthechick.ui.main.gamescreen.engine.ItemType.Companion Companion = null;
    
    ItemType(float size, int drawableRes, java.lang.String contentDescription) {
    }
    
    public final int getDrawableRes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContentDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.manacode.feedthechick.ui.main.gamescreen.engine.ItemType> getEntries() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/manacode/feedthechick/ui/main/gamescreen/engine/ItemType$Companion;", "", "()V", "random", "Lcom/manacode/feedthechick/ui/main/gamescreen/engine/ItemType;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.manacode.feedthechick.ui.main.gamescreen.engine.ItemType random() {
            return null;
        }
    }
}