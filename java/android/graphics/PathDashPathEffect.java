// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            PathEffect, Path

public class PathDashPathEffect extends PathEffect {
    public static final class Style extends Enum {

        public static Style valueOf(String s) {
            return (Style)Enum.valueOf(android/graphics/PathDashPathEffect$Style, s);
        }

        public static Style[] values() {
            return (Style[])$VALUES.clone();
        }

        private static final Style $VALUES[];
        public static final Style MORPH;
        public static final Style ROTATE;
        public static final Style TRANSLATE;
        int native_style;

        static  {
            TRANSLATE = new Style("TRANSLATE", 0, 0);
            ROTATE = new Style("ROTATE", 1, 1);
            MORPH = new Style("MORPH", 2, 2);
            Style astyle[] = new Style[3];
            astyle[0] = TRANSLATE;
            astyle[1] = ROTATE;
            astyle[2] = MORPH;
            $VALUES = astyle;
        }

        private Style(String s, int i, int j) {
            super(s, i);
            native_style = j;
        }
    }


    public PathDashPathEffect(Path path, float f, float f1, Style style) {
        super.native_instance = nativeCreate(path.ni(), f, f1, style.native_style);
    }

    private static native int nativeCreate(int i, float f, float f1, int j);
}
