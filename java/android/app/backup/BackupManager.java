// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.content.Context;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

// Referenced classes of package android.app.backup:
//            IBackupManager, RestoreSession, RestoreObserver

public class BackupManager {

    public BackupManager(Context context) {
        mContext = context;
    }

    private static void checkServiceBinder() {
        if(sService == null)
            sService = IBackupManager.Stub.asInterface(ServiceManager.getService("backup"));
    }

    public static void dataChanged(String s) {
        checkServiceBinder();
        if(sService == null)
            break MISSING_BLOCK_LABEL_18;
        sService.dataChanged(s);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.d("BackupManager", "dataChanged(pkg) couldn't connect");
          goto _L1
    }

    public RestoreSession beginRestoreSession() {
        RestoreSession restoresession;
        restoresession = null;
        checkServiceBinder();
        if(sService == null)
            break MISSING_BLOCK_LABEL_46;
        RestoreSession restoresession1;
        IRestoreSession irestoresession = sService.beginRestoreSession(null, null);
        if(irestoresession == null)
            break MISSING_BLOCK_LABEL_46;
        restoresession1 = new RestoreSession(mContext, irestoresession);
        restoresession = restoresession1;
_L2:
        return restoresession;
        RemoteException remoteexception;
        remoteexception;
        Log.w("BackupManager", "beginRestoreSession() couldn't connect");
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void dataChanged() {
        checkServiceBinder();
        if(sService == null)
            break MISSING_BLOCK_LABEL_24;
        sService.dataChanged(mContext.getPackageName());
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.d("BackupManager", "dataChanged() couldn't connect");
          goto _L1
    }

    public int requestRestore(RestoreObserver restoreobserver) {
        int i;
        RestoreSession restoresession;
        i = -1;
        checkServiceBinder();
        if(sService == null)
            break MISSING_BLOCK_LABEL_81;
        restoresession = null;
        RestoreSession restoresession1;
        IRestoreSession irestoresession = sService.beginRestoreSession(mContext.getPackageName(), null);
        if(irestoresession == null)
            break MISSING_BLOCK_LABEL_73;
        restoresession1 = new RestoreSession(mContext, irestoresession);
        int j = restoresession1.restorePackage(mContext.getPackageName(), restoreobserver);
        i = j;
        restoresession = restoresession1;
        if(restoresession != null)
            restoresession.endRestoreSession();
_L1:
        return i;
        RemoteException remoteexception;
        remoteexception;
_L4:
        Log.w("BackupManager", "restoreSelf() unable to contact service");
        if(restoresession != null)
            restoresession.endRestoreSession();
          goto _L1
        Exception exception;
        exception;
_L3:
        if(restoresession != null)
            restoresession.endRestoreSession();
        throw exception;
        exception;
        restoresession = restoresession1;
        if(true) goto _L3; else goto _L2
_L2:
        RemoteException remoteexception1;
        remoteexception1;
        restoresession = restoresession1;
          goto _L4
    }

    private static final String TAG = "BackupManager";
    private static IBackupManager sService;
    private Context mContext;
}
