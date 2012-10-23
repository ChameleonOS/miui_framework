// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.app.*;
import android.os.*;
import android.util.Log;
import java.util.concurrent.ExecutorService;

// Referenced classes of package android.content:
//            Intent, Context

public abstract class BroadcastReceiver {
    public static class PendingResult {

        public final void abortBroadcast() {
            checkSynchronousHint();
            mAbortBroadcast = true;
        }

        void checkSynchronousHint() {
            if(!mOrderedHint && !mInitialStickyHint) {
                RuntimeException runtimeexception = new RuntimeException("BroadcastReceiver trying to return result during a non-ordered broadcast");
                runtimeexception.fillInStackTrace();
                Log.e("BroadcastReceiver", runtimeexception.getMessage(), runtimeexception);
            }
        }

        public final void clearAbortBroadcast() {
            mAbortBroadcast = false;
        }

        public final void finish() {
            if(mType != 0) goto _L2; else goto _L1
_L1:
            final IActivityManager mgr = ActivityManagerNative.getDefault();
            if(QueuedWork.hasPendingWork())
                QueuedWork.singleThreadExecutor().execute(new Runnable() {

                    public void run() {
                        sendFinished(mgr);
                    }

                    final PendingResult this$0;
                    final IActivityManager val$mgr;

                 {
                    this$0 = PendingResult.this;
                    mgr = iactivitymanager;
                    super();
                }
                });
            else
                sendFinished(mgr);
_L4:
            return;
_L2:
            if(mOrderedHint && mType != 2)
                sendFinished(ActivityManagerNative.getDefault());
            if(true) goto _L4; else goto _L3
_L3:
        }

        public final boolean getAbortBroadcast() {
            return mAbortBroadcast;
        }

        public final int getResultCode() {
            return mResultCode;
        }

        public final String getResultData() {
            return mResultData;
        }

        public final Bundle getResultExtras(boolean flag) {
            Bundle bundle = mResultExtras;
            Bundle bundle1;
            if(!flag) {
                bundle1 = bundle;
            } else {
                if(bundle == null) {
                    bundle = new Bundle();
                    mResultExtras = bundle;
                }
                bundle1 = bundle;
            }
            return bundle1;
        }

        public void sendFinished(IActivityManager iactivitymanager) {
            this;
            JVM INSTR monitorenter ;
            Exception exception;
            if(mFinished)
                throw new IllegalStateException("Broadcast already finished");
            if(true)
                break MISSING_BLOCK_LABEL_24;
            JVM INSTR monitorexit ;
            throw exception;
            mFinished = true;
            if(mResultExtras != null)
                mResultExtras.setAllowFds(false);
            if(!mOrderedHint)
                break MISSING_BLOCK_LABEL_81;
            iactivitymanager.finishReceiver(mToken, mResultCode, mResultData, mResultExtras, mAbortBroadcast);
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
            try {
                iactivitymanager.finishReceiver(mToken, 0, null, null, false);
            }
            catch(RemoteException remoteexception) { }
            finally {
                this;
            }
              goto _L1
        }

        public void setExtrasClassLoader(ClassLoader classloader) {
            if(mResultExtras != null)
                mResultExtras.setClassLoader(classloader);
        }

        public final void setResult(int i, String s, Bundle bundle) {
            checkSynchronousHint();
            mResultCode = i;
            mResultData = s;
            mResultExtras = bundle;
        }

        public final void setResultCode(int i) {
            checkSynchronousHint();
            mResultCode = i;
        }

        public final void setResultData(String s) {
            checkSynchronousHint();
            mResultData = s;
        }

        public final void setResultExtras(Bundle bundle) {
            checkSynchronousHint();
            mResultExtras = bundle;
        }

        public static final int TYPE_COMPONENT = 0;
        public static final int TYPE_REGISTERED = 1;
        public static final int TYPE_UNREGISTERED = 2;
        boolean mAbortBroadcast;
        boolean mFinished;
        final boolean mInitialStickyHint;
        final boolean mOrderedHint;
        int mResultCode;
        String mResultData;
        Bundle mResultExtras;
        final IBinder mToken;
        final int mType;

        public PendingResult(int i, String s, Bundle bundle, int j, boolean flag, boolean flag1, IBinder ibinder) {
            mResultCode = i;
            mResultData = s;
            mResultExtras = bundle;
            mType = j;
            mOrderedHint = flag;
            mInitialStickyHint = flag1;
            mToken = ibinder;
        }
    }


    public BroadcastReceiver() {
    }

    public final void abortBroadcast() {
        checkSynchronousHint();
        mPendingResult.mAbortBroadcast = true;
    }

    void checkSynchronousHint() {
        if(mPendingResult == null)
            throw new IllegalStateException("Call while result is not pending");
        if(!mPendingResult.mOrderedHint && !mPendingResult.mInitialStickyHint) {
            RuntimeException runtimeexception = new RuntimeException("BroadcastReceiver trying to return result during a non-ordered broadcast");
            runtimeexception.fillInStackTrace();
            Log.e("BroadcastReceiver", runtimeexception.getMessage(), runtimeexception);
        }
    }

    public final void clearAbortBroadcast() {
        if(mPendingResult != null)
            mPendingResult.mAbortBroadcast = false;
    }

    public final boolean getAbortBroadcast() {
        boolean flag;
        if(mPendingResult != null)
            flag = mPendingResult.mAbortBroadcast;
        else
            flag = false;
        return flag;
    }

    public final boolean getDebugUnregister() {
        return mDebugUnregister;
    }

    public final PendingResult getPendingResult() {
        return mPendingResult;
    }

    public final int getResultCode() {
        int i;
        if(mPendingResult != null)
            i = mPendingResult.mResultCode;
        else
            i = 0;
        return i;
    }

    public final String getResultData() {
        String s;
        if(mPendingResult != null)
            s = mPendingResult.mResultData;
        else
            s = null;
        return s;
    }

    public final Bundle getResultExtras(boolean flag) {
        if(mPendingResult != null) goto _L2; else goto _L1
_L1:
        Bundle bundle = null;
_L4:
        return bundle;
_L2:
        bundle = mPendingResult.mResultExtras;
        if(flag && bundle == null) {
            PendingResult pendingresult = mPendingResult;
            bundle = new Bundle();
            pendingresult.mResultExtras = bundle;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final PendingResult goAsync() {
        PendingResult pendingresult = mPendingResult;
        mPendingResult = null;
        return pendingresult;
    }

    public final boolean isInitialStickyBroadcast() {
        boolean flag;
        if(mPendingResult != null)
            flag = mPendingResult.mInitialStickyHint;
        else
            flag = false;
        return flag;
    }

    public final boolean isOrderedBroadcast() {
        boolean flag;
        if(mPendingResult != null)
            flag = mPendingResult.mOrderedHint;
        else
            flag = false;
        return flag;
    }

    public abstract void onReceive(Context context, Intent intent);

    public IBinder peekService(Context context, Intent intent) {
        IActivityManager iactivitymanager;
        IBinder ibinder;
        iactivitymanager = ActivityManagerNative.getDefault();
        ibinder = null;
        IBinder ibinder1;
        intent.setAllowFds(false);
        ibinder1 = iactivitymanager.peekService(intent, intent.resolveTypeIfNeeded(context.getContentResolver()));
        ibinder = ibinder1;
_L2:
        return ibinder;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public final void setDebugUnregister(boolean flag) {
        mDebugUnregister = flag;
    }

    public final void setOrderedHint(boolean flag) {
    }

    public final void setPendingResult(PendingResult pendingresult) {
        mPendingResult = pendingresult;
    }

    public final void setResult(int i, String s, Bundle bundle) {
        checkSynchronousHint();
        mPendingResult.mResultCode = i;
        mPendingResult.mResultData = s;
        mPendingResult.mResultExtras = bundle;
    }

    public final void setResultCode(int i) {
        checkSynchronousHint();
        mPendingResult.mResultCode = i;
    }

    public final void setResultData(String s) {
        checkSynchronousHint();
        mPendingResult.mResultData = s;
    }

    public final void setResultExtras(Bundle bundle) {
        checkSynchronousHint();
        mPendingResult.mResultExtras = bundle;
    }

    private boolean mDebugUnregister;
    private PendingResult mPendingResult;
}
