// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.app.Activity;
import android.app.IUiModeManager;
import android.os.*;
import android.util.Log;

public class DisableCarModeActivity extends Activity {

    public DisableCarModeActivity() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            android.app.IUiModeManager.Stub.asInterface(ServiceManager.getService("uimode")).disableCarMode(1);
        }
        catch(RemoteException remoteexception) {
            Log.e("DisableCarModeActivity", "Failed to disable car mode", remoteexception);
        }
        finish();
    }

    private static final String TAG = "DisableCarModeActivity";
}
