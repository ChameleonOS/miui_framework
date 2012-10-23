// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


public class PorterDuff {
    public static final class Mode extends Enum {

        public static Mode valueOf(String s) {
            return (Mode)Enum.valueOf(android/graphics/PorterDuff$Mode, s);
        }

        public static Mode[] values() {
            return (Mode[])$VALUES.clone();
        }

        private static final Mode $VALUES[];
        public static final Mode ADD;
        public static final Mode CLEAR;
        public static final Mode DARKEN;
        public static final Mode DST;
        public static final Mode DST_ATOP;
        public static final Mode DST_IN;
        public static final Mode DST_OUT;
        public static final Mode DST_OVER;
        public static final Mode LIGHTEN;
        public static final Mode MULTIPLY;
        public static final Mode OVERLAY;
        public static final Mode SCREEN;
        public static final Mode SRC;
        public static final Mode SRC_ATOP;
        public static final Mode SRC_IN;
        public static final Mode SRC_OUT;
        public static final Mode SRC_OVER;
        public static final Mode XOR;
        public final int nativeInt;

        static  {
            CLEAR = new Mode("CLEAR", 0, 0);
            SRC = new Mode("SRC", 1, 1);
            DST = new Mode("DST", 2, 2);
            SRC_OVER = new Mode("SRC_OVER", 3, 3);
            DST_OVER = new Mode("DST_OVER", 4, 4);
            SRC_IN = new Mode("SRC_IN", 5, 5);
            DST_IN = new Mode("DST_IN", 6, 6);
            SRC_OUT = new Mode("SRC_OUT", 7, 7);
            DST_OUT = new Mode("DST_OUT", 8, 8);
            SRC_ATOP = new Mode("SRC_ATOP", 9, 9);
            DST_ATOP = new Mode("DST_ATOP", 10, 10);
            XOR = new Mode("XOR", 11, 11);
            DARKEN = new Mode("DARKEN", 12, 12);
            LIGHTEN = new Mode("LIGHTEN", 13, 13);
            MULTIPLY = new Mode("MULTIPLY", 14, 14);
            SCREEN = new Mode("SCREEN", 15, 15);
            ADD = new Mode("ADD", 16, 16);
            OVERLAY = new Mode("OVERLAY", 17, 17);
            Mode amode[] = new Mode[18];
            amode[0] = CLEAR;
            amode[1] = SRC;
            amode[2] = DST;
            amode[3] = SRC_OVER;
            amode[4] = DST_OVER;
            amode[5] = SRC_IN;
            amode[6] = DST_IN;
            amode[7] = SRC_OUT;
            amode[8] = DST_OUT;
            amode[9] = SRC_ATOP;
            amode[10] = DST_ATOP;
            amode[11] = XOR;
            amode[12] = DARKEN;
            amode[13] = LIGHTEN;
            amode[14] = MULTIPLY;
            amode[15] = SCREEN;
            amode[16] = ADD;
            amode[17] = OVERLAY;
            $VALUES = amode;
        }

        private Mode(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }


    public PorterDuff() {
    }
}
