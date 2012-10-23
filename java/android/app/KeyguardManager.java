// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.*;
import android.view.IWindowManager;

public class KeyguardManager {
    public static interface OnKeyguardExitResult {

        public abstract void onKeyguardExitResult(boolean flag);
    }

    public class KeyguardLock {

        public void disableKeyguard() {
            mWM.disableKeyguard(mToken, mTag);
_L2:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public void reenableKeyguard() {
            mWM.reenableKeyguard(mToken);
_L2:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        private String mTag;
        private IBinder mToken;
        final KeyguardManager this$0;

        KeyguardLock(String s) {
            this$0 = KeyguardManager.this;
            super();
            mToken = new Binder();
            mTag = s;
        }
    }


    KeyguardManager() {
        mWM = android.view.IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
    }

    public void exitKeyguardSecurely(final OnKeyguardExitResult callback) {
        mWM.exitKeyguardSecurely(new android.view.IOnKeyguardExitResult.Stub() {

            public void onKeyguardExitResult(boolean flag) throws RemoteException {
                callback.onKeyguardExitResult(flag);
            }

            final KeyguardManager this$0;
            final OnKeyguardExitResult val$callback;

             {
                this$0 = KeyguardManager.this;
                callback = onkeyguardexitresult;
                super();
            }
        });
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean inKeyguardRestrictedInputMode() {
        boolean flag1 = mWM.inKeyguardRestrictedInputMode();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isKeyguardLocked() {
        boolean flag1 = mWM.isKeyguardLocked();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isKeyguardSecure() {
        boolean flag1 = mWM.isKeyguardSecure();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public KeyguardLock newKeyguardLock(String s) {
        return new KeyguardLock(s);
    }

    private IWindowManager mWM;

}
