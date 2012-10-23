// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            MaskFilter

public class BlurMaskFilter extends MaskFilter {
    public static final class Blur extends Enum {

        public static Blur valueOf(String s) {
            return (Blur)Enum.valueOf(android/graphics/BlurMaskFilter$Blur, s);
        }

        public static Blur[] values() {
            return (Blur[])$VALUES.clone();
        }

        private static final Blur $VALUES[];
        public static final Blur INNER;
        public static final Blur NORMAL;
        public static final Blur OUTER;
        public static final Blur SOLID;
        final int native_int;

        static  {
            NORMAL = new Blur("NORMAL", 0, 0);
            SOLID = new Blur("SOLID", 1, 1);
            OUTER = new Blur("OUTER", 2, 2);
            INNER = new Blur("INNER", 3, 3);
            Blur ablur[] = new Blur[4];
            ablur[0] = NORMAL;
            ablur[1] = SOLID;
            ablur[2] = OUTER;
            ablur[3] = INNER;
            $VALUES = ablur;
        }

        private Blur(String s, int i, int j) {
            super(s, i);
            native_int = j;
        }
    }


    public BlurMaskFilter(float f, Blur blur) {
        super.native_instance = nativeConstructor(f, blur.native_int);
    }

    private static native int nativeConstructor(float f, int i);
}
