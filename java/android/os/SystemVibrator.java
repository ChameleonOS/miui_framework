// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.Log;

// Referenced classes of package android.os:
//            Vibrator, Binder, ServiceManager, RemoteException, 
//            IVibratorService

public class SystemVibrator extends Vibrator {

    public SystemVibrator() {
    }

    public void cancel() {
        if(mService != null)
            try {
                mService.cancelVibrate(mToken);
            }
            catch(RemoteException remoteexception) {
                Log.w("Vibrator", "Failed to cancel vibration.", remoteexception);
            }
    }

    public boolean hasVibrator() {
        boolean flag = false;
        if(mService != null) goto _L2; else goto _L1
_L1:
        Log.w("Vibrator", "Failed to vibrate; no vibrator service.");
_L4:
        return flag;
_L2:
        boolean flag1 = mService.hasVibrator();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void vibrate(long l) {
        if(mService == null)
            Log.w("Vibrator", "Failed to vibrate; no vibrator service.");
        else
            try {
                mService.vibrate(l, mToken);
            }
            catch(RemoteException remoteexception) {
                Log.w("Vibrator", "Failed to vibrate.", remoteexception);
            }
    }

    public void vibrate(long al[], int i) {
        if(mService == null)
            Log.w("Vibrator", "Failed to vibrate; no vibrator service.");
        else
        if(i < al.length)
            try {
                mService.vibratePattern(al, i, mToken);
            }
            catch(RemoteException remoteexception) {
                Log.w("Vibrator", "Failed to vibrate.", remoteexception);
            }
        else
            throw new ArrayIndexOutOfBoundsException();
    }

    private static final String TAG = "Vibrator";
    private final IVibratorService mService = IVibratorService.Stub.asInterface(ServiceManager.getService("vibrator"));
    private final Binder mToken = new Binder();
}
