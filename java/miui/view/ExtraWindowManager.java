// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.view;


public class ExtraWindowManager {
    public static class LayoutParams extends android.view.WindowManager.LayoutParams {

        public static final int PRIVATE_FLAG_LOCKSCREEN_DISPALY_DESKTOP = 0x40000000;
        public static final int PRIVATE_FLAG_TRANSPARENT_STATUS_BAR = 0x80000000;

        public LayoutParams() {
        }
    }


    public ExtraWindowManager() {
    }
}
