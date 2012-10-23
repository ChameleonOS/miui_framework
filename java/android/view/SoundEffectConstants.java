// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;


public class SoundEffectConstants {

    private SoundEffectConstants() {
    }

    public static int getContantForFocusDirection(int i) {
        i;
        JVM INSTR lookupswitch 6: default 60
    //                   1: 84
    //                   2: 74
    //                   17: 79
    //                   33: 84
    //                   66: 70
    //                   130: 74;
           goto _L1 _L2 _L3 _L4 _L2 _L5 _L3
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
_L5:
        byte byte0 = 3;
_L7:
        return byte0;
_L3:
        byte0 = 4;
        continue; /* Loop/switch isn't completed */
_L4:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L2:
        byte0 = 2;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static final int CLICK = 0;
    public static final int NAVIGATION_DOWN = 4;
    public static final int NAVIGATION_LEFT = 1;
    public static final int NAVIGATION_RIGHT = 3;
    public static final int NAVIGATION_UP = 2;
}
