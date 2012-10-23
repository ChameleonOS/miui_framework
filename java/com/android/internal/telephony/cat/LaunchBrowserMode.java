// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


public final class LaunchBrowserMode extends Enum {

    private LaunchBrowserMode(String s, int i) {
        super(s, i);
    }

    public static LaunchBrowserMode valueOf(String s) {
        return (LaunchBrowserMode)Enum.valueOf(com/android/internal/telephony/cat/LaunchBrowserMode, s);
    }

    public static LaunchBrowserMode[] values() {
        return (LaunchBrowserMode[])$VALUES.clone();
    }

    private static final LaunchBrowserMode $VALUES[];
    public static final LaunchBrowserMode LAUNCH_IF_NOT_ALREADY_LAUNCHED;
    public static final LaunchBrowserMode LAUNCH_NEW_BROWSER;
    public static final LaunchBrowserMode USE_EXISTING_BROWSER;

    static  {
        LAUNCH_IF_NOT_ALREADY_LAUNCHED = new LaunchBrowserMode("LAUNCH_IF_NOT_ALREADY_LAUNCHED", 0);
        USE_EXISTING_BROWSER = new LaunchBrowserMode("USE_EXISTING_BROWSER", 1);
        LAUNCH_NEW_BROWSER = new LaunchBrowserMode("LAUNCH_NEW_BROWSER", 2);
        LaunchBrowserMode alaunchbrowsermode[] = new LaunchBrowserMode[3];
        alaunchbrowsermode[0] = LAUNCH_IF_NOT_ALREADY_LAUNCHED;
        alaunchbrowsermode[1] = USE_EXISTING_BROWSER;
        alaunchbrowsermode[2] = LAUNCH_NEW_BROWSER;
        $VALUES = alaunchbrowsermode;
    }
}
