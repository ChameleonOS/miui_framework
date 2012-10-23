// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


public interface LocalPowerManager {

    public abstract void enableUserActivity(boolean flag);

    public abstract void goToSleep(long l);

    public abstract boolean isScreenOn();

    public abstract void setButtonBrightnessOverride(int i);

    public abstract void setKeyboardVisibility(boolean flag);

    public abstract void setScreenBrightnessOverride(int i);

    public abstract void userActivity(long l, boolean flag, int i);

    public static final int BUTTON_EVENT = 1;
    public static final int OTHER_EVENT = 0;
    public static final int POKE_LOCK_IGNORE_TOUCH_EVENTS = 1;
    public static final int POKE_LOCK_MEDIUM_TIMEOUT = 4;
    public static final int POKE_LOCK_SHORT_TIMEOUT = 2;
    public static final int POKE_LOCK_TIMEOUT_MASK = 6;
    public static final int TOUCH_EVENT = 2;
}
