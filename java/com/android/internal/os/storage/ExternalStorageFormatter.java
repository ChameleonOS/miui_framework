// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os.storage;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.*;
import android.os.*;
import android.os.storage.*;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
import java.io.File;

public class ExternalStorageFormatter extends Service
    implements android.content.DialogInterface.OnCancelListener {

    public ExternalStorageFormatter() {
        mMountService = null;
        mStorageManager = null;
        mProgressDialog = null;
        mFactoryReset = false;
        mAlwaysReset = false;
        mStorageListener = new StorageEventListener() {

            public void onStorageStateChanged(String s, String s1, String s2) {
                Log.i("ExternalStorageFormatter", (new StringBuilder()).append("Received storage state changed notification that ").append(s).append(" changed state from ").append(s1).append(" to ").append(s2).toString());
                updateProgressState();
            }

            final ExternalStorageFormatter this$0;

             {
                this$0 = ExternalStorageFormatter.this;
                super();
            }
        };
    }

    void fail(int i) {
        Toast.makeText(this, i, 1).show();
        if(mAlwaysReset)
            sendBroadcast(new Intent("android.intent.action.MASTER_CLEAR"));
        stopSelf();
    }

    IMountService getMountService() {
        if(mMountService == null) {
            IBinder ibinder = ServiceManager.getService("mount");
            if(ibinder != null)
                mMountService = android.os.storage.IMountService.Stub.asInterface(ibinder);
            else
                Log.e("ExternalStorageFormatter", "Can't get mount service");
        }
        return mMountService;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCancel(DialogInterface dialoginterface) {
        IMountService imountservice = getMountService();
        String s;
        if(mStorageVolume == null)
            s = Environment.getExternalStorageDirectory().toString();
        else
            s = mStorageVolume.getPath();
        try {
            imountservice.mountVolume(s);
        }
        catch(RemoteException remoteexception) {
            Log.w("ExternalStorageFormatter", "Failed talking with mount service", remoteexception);
        }
        stopSelf();
    }

    public void onCreate() {
        super.onCreate();
        if(mStorageManager == null) {
            mStorageManager = (StorageManager)getSystemService("storage");
            mStorageManager.registerListener(mStorageListener);
        }
        mWakeLock = ((PowerManager)getSystemService("power")).newWakeLock(1, "ExternalStorageFormatter");
        mWakeLock.acquire();
    }

    public void onDestroy() {
        if(mStorageManager != null)
            mStorageManager.unregisterListener(mStorageListener);
        if(mProgressDialog != null)
            mProgressDialog.dismiss();
        mWakeLock.release();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j) {
        if("com.android.internal.os.storage.FORMAT_AND_FACTORY_RESET".equals(intent.getAction()))
            mFactoryReset = true;
        if(intent.getBooleanExtra("always_reset", false))
            mAlwaysReset = true;
        mStorageVolume = (StorageVolume)intent.getParcelableExtra("storage_volume");
        if(mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCancelable(true);
            mProgressDialog.getWindow().setType(2003);
            if(!mAlwaysReset)
                mProgressDialog.setOnCancelListener(this);
            updateProgressState();
            mProgressDialog.show();
        }
        return 3;
    }

    public void updateProgressDialog(int i) {
        if(mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCancelable(false);
            mProgressDialog.getWindow().setType(2003);
            mProgressDialog.show();
        }
        mProgressDialog.setMessage(getText(i));
    }

    void updateProgressState() {
        String s;
        IMountService imountservice;
        String s1;
        if(mStorageVolume == null)
            s = Environment.getExternalStorageState();
        else
            s = mStorageManager.getVolumeState(mStorageVolume.getPath());
        if(!"mounted".equals(s) && !"mounted_ro".equals(s))
            break MISSING_BLOCK_LABEL_114;
        updateProgressDialog(0x1040491);
        imountservice = getMountService();
        if(mStorageVolume == null)
            s1 = Environment.getExternalStorageDirectory().toString();
        else
            s1 = mStorageVolume.getPath();
        imountservice.unmountVolume(s1, true, mFactoryReset);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w("ExternalStorageFormatter", "Failed talking with mount service", remoteexception);
          goto _L1
        if("nofs".equals(s) || "unmounted".equals(s) || "unmountable".equals(s)) {
            updateProgressDialog(0x1040492);
            final IMountService mountService = getMountService();
            final String extStoragePath;
            if(mStorageVolume == null)
                extStoragePath = Environment.getExternalStorageDirectory().toString();
            else
                extStoragePath = mStorageVolume.getPath();
            if(mountService != null)
                (new Thread() {

                    public void run() {
                        boolean flag = false;
                        mountService.formatVolume(extStoragePath);
                        flag = true;
_L1:
                        Exception exception;
                        if(flag && mFactoryReset) {
                            sendBroadcast(new Intent("android.intent.action.MASTER_CLEAR"));
                            stopSelf();
                        } else {
                            if(!flag && mAlwaysReset)
                                sendBroadcast(new Intent("android.intent.action.MASTER_CLEAR"));
                            else
                                try {
                                    mountService.mountVolume(extStoragePath);
                                }
                                catch(RemoteException remoteexception1) {
                                    Log.w("ExternalStorageFormatter", "Failed talking with mount service", remoteexception1);
                                }
                            stopSelf();
                        }
                        return;
                        exception;
                        Toast.makeText(ExternalStorageFormatter.this, 0x1040493, 1).show();
                          goto _L1
                    }

                    final ExternalStorageFormatter this$0;
                    final String val$extStoragePath;
                    final IMountService val$mountService;

             {
                this$0 = ExternalStorageFormatter.this;
                mountService = imountservice;
                extStoragePath = s;
                super();
            }
                }).start();
            else
                Log.w("ExternalStorageFormatter", "Unable to locate IMountService");
        } else
        if("bad_removal".equals(s))
            fail(0x1040494);
        else
        if("checking".equals(s))
            fail(0x1040495);
        else
        if("removed".equals(s))
            fail(0x1040496);
        else
        if("shared".equals(s)) {
            fail(0x1040497);
        } else {
            fail(0x1040498);
            Log.w("ExternalStorageFormatter", (new StringBuilder()).append("Unknown storage state: ").append(s).toString());
            stopSelf();
        }
          goto _L1
    }

    public static final ComponentName COMPONENT_NAME = new ComponentName("android", com/android/internal/os/storage/ExternalStorageFormatter.getName());
    public static final String EXTRA_ALWAYS_RESET = "always_reset";
    public static final String FORMAT_AND_FACTORY_RESET = "com.android.internal.os.storage.FORMAT_AND_FACTORY_RESET";
    public static final String FORMAT_ONLY = "com.android.internal.os.storage.FORMAT_ONLY";
    static final String TAG = "ExternalStorageFormatter";
    private boolean mAlwaysReset;
    private boolean mFactoryReset;
    private IMountService mMountService;
    private ProgressDialog mProgressDialog;
    StorageEventListener mStorageListener;
    private StorageManager mStorageManager;
    private StorageVolume mStorageVolume;
    private android.os.PowerManager.WakeLock mWakeLock;



}
