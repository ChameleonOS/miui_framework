// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

// Referenced classes of package android.app:
//            IUiModeManager

public class UiModeManager {

    UiModeManager() {
        mService = IUiModeManager.Stub.asInterface(ServiceManager.getService("uimode"));
    }

    public void disableCarMode(int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_17;
        mService.disableCarMode(i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UiModeManager", "disableCarMode: RemoteException", remoteexception);
          goto _L1
    }

    public void enableCarMode(int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_17;
        mService.enableCarMode(i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UiModeManager", "disableCarMode: RemoteException", remoteexception);
          goto _L1
    }

    public int getCurrentModeType() {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getCurrentModeType();
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UiModeManager", "getCurrentModeType: RemoteException", remoteexception);
_L2:
        i = 1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getNightMode() {
        if(mService == null) goto _L2; else goto _L1
_L1:
        int j = mService.getNightMode();
        int i = j;
_L4:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UiModeManager", "getNightMode: RemoteException", remoteexception);
_L2:
        i = -1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setNightMode(int i) {
        if(mService == null)
            break MISSING_BLOCK_LABEL_17;
        mService.setNightMode(i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("UiModeManager", "setNightMode: RemoteException", remoteexception);
          goto _L1
    }

    public static String ACTION_ENTER_CAR_MODE = "android.app.action.ENTER_CAR_MODE";
    public static String ACTION_ENTER_DESK_MODE = "android.app.action.ENTER_DESK_MODE";
    public static String ACTION_EXIT_CAR_MODE = "android.app.action.EXIT_CAR_MODE";
    public static String ACTION_EXIT_DESK_MODE = "android.app.action.EXIT_DESK_MODE";
    public static final int DISABLE_CAR_MODE_GO_HOME = 1;
    public static final int ENABLE_CAR_MODE_GO_CAR_HOME = 1;
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_YES = 2;
    private static final String TAG = "UiModeManager";
    private IUiModeManager mService;

}
