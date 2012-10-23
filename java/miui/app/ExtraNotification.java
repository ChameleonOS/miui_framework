// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.app;


public class ExtraNotification {

    public ExtraNotification() {
    }

    public static int[] getLedPwmOffOn(int i) {
        int ai[] = new int[2];
        ai[0] = 3 * (i / 4);
        ai[1] = i - ai[0];
        return ai;
    }
}
