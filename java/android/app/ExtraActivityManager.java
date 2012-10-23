// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

// Referenced classes of package android.app:
//            ActivityManager

public class ExtraActivityManager {

    public ExtraActivityManager() {
    }

    public static boolean isHighEndGfx(Display display) {
        boolean flag;
        if("crespo".equals(Build.DEVICE))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean useHardwareAccelerationOnKeyguard(Context context) {
        return ActivityManager.isHighEndGfx(((WindowManager)context.getSystemService("window")).getDefaultDisplay());
    }
}
