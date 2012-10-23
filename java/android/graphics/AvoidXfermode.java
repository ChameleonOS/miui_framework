// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Xfermode

public class AvoidXfermode extends Xfermode {
    public static final class Mode extends Enum {

        public static Mode valueOf(String s) {
            return (Mode)Enum.valueOf(android/graphics/AvoidXfermode$Mode, s);
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        private static final Mode $VALUES[];
        public static final Mode AVOID;
        public static final Mode TARGET;
        final int nativeInt;

        static  {
            AVOID = new Mode("AVOID", 0, 0);
            TARGET = new Mode("TARGET", 1, 1);
            Mode amode[] = new Mode[2];
            amode[0] = AVOID;
            amode[1] = TARGET;
            $VALUES = amode;
        }

        private Mode(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }


    public AvoidXfermode(int i, int j, Mode mode) {
        if(j < 0 || j > 255) {
            throw new IllegalArgumentException("tolerance must be 0..255");
        } else {
            super.native_instance = nativeCreate(i, j, mode.nativeInt);
            return;
        }
    }

    private static native int nativeCreate(int i, int j, int k);
}
