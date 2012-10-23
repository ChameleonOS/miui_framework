// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import android.content.Context;
import android.os.*;
import android.util.Log;

// Referenced classes of package android.app.backup:
//            IRestoreSession, RestoreObserver, RestoreSet

public class RestoreSession {
    private class RestoreObserverWrapper extends IRestoreObserver.Stub {

        public void onUpdate(int i, String s) {
            mHandler.sendMessage(mHandler.obtainMessage(2, i, 0, s));
        }

        public void restoreFinished(int i) {
            mHandler.sendMessage(mHandler.obtainMessage(3, i, 0));
        }

        public void restoreSetsAvailable(RestoreSet arestoreset[]) {
            mHandler.sendMessage(mHandler.obtainMessage(4, arestoreset));
        }

        public void restoreStarting(int i) {
            mHandler.sendMessage(mHandler.obtainMessage(1, i, 0));
        }

        static final int MSG_RESTORE_FINISHED = 3;
        static final int MSG_RESTORE_SETS_AVAILABLE = 4;
        static final int MSG_RESTORE_STARTING = 1;
        static final int MSG_UPDATE = 2;
        final RestoreObserver mAppObserver;
        final Handler mHandler;
        final RestoreSession this$0;

        RestoreObserverWrapper(Context context, RestoreObserver restoreobserver) {
            this$0 = RestoreSession.this;
            super();
            mHandler = new Handler(RestoreSession.this) {

                public void handleMessage(Message message) {
                    message.what;
                    JVM INSTR tableswitch 1 4: default 36
                //                               1 37
                //                               2 54
                //                               3 78
                //                               4 95;
                       goto _L1 _L2 _L3 _L4 _L5
_L1:
                    return;
_L2:
                    mAppObserver.restoreStarting(message.arg1);
                    continue; /* Loop/switch isn't completed */
_L3:
                    mAppObserver.onUpdate(message.arg1, (String)message.obj);
                    continue; /* Loop/switch isn't completed */
_L4:
                    mAppObserver.restoreFinished(message.arg1);
                    continue; /* Loop/switch isn't completed */
_L5:
                    mAppObserver.restoreSetsAvailable((RestoreSet[])(RestoreSet[])message.obj);
                    if(true) goto _L1; else goto _L6
_L6:
                }

                final RestoreObserverWrapper this$1;
                final RestoreSession val$this$0;

                 {
                    this$1 = RestoreObserverWrapper.this;
                    this$0 = restoresession;
                    super(final_looper);
                }
            };
            mAppObserver = restoreobserver;
        }
    }


    RestoreSession(Context context, IRestoreSession irestoresession) {
        mObserver = null;
        mContext = context;
        mBinder = irestoresession;
    }

    public void endRestoreSession() {
        mBinder.endRestoreSession();
_L2:
        mBinder = null;
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.d("RestoreSession", "Can't contact server to get available sets");
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        mBinder = null;
        throw exception;
    }

    public int getAvailableRestoreSets(RestoreObserver restoreobserver) {
        int i;
        RestoreObserverWrapper restoreobserverwrapper;
        i = -1;
        restoreobserverwrapper = new RestoreObserverWrapper(mContext, restoreobserver);
        int j = mBinder.getAvailableRestoreSets(restoreobserverwrapper);
        i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.d("RestoreSession", "Can't contact server to get available sets");
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int restoreAll(long l, RestoreObserver restoreobserver) {
        int i = -1;
        if(mObserver == null) goto _L2; else goto _L1
_L1:
        int j;
        Log.d("RestoreSession", "restoreAll() called during active restore");
        j = -1;
_L4:
        return j;
_L2:
        mObserver = new RestoreObserverWrapper(mContext, restoreobserver);
        int k = mBinder.restoreAll(l, mObserver);
        i = k;
_L5:
        j = i;
        if(true) goto _L4; else goto _L3
_L3:
        RemoteException remoteexception;
        remoteexception;
        Log.d("RestoreSession", "Can't contact server to restore");
          goto _L5
    }

    public int restorePackage(String s, RestoreObserver restoreobserver) {
        int i = -1;
        if(mObserver == null) goto _L2; else goto _L1
_L1:
        int j;
        Log.d("RestoreSession", "restorePackage() called during active restore");
        j = -1;
_L4:
        return j;
_L2:
        mObserver = new RestoreObserverWrapper(mContext, restoreobserver);
        int k = mBinder.restorePackage(s, mObserver);
        i = k;
_L5:
        j = i;
        if(true) goto _L4; else goto _L3
_L3:
        RemoteException remoteexception;
        remoteexception;
        Log.d("RestoreSession", "Can't contact server to restore package");
          goto _L5
    }

    public int restoreSome(long l, RestoreObserver restoreobserver, String as[]) {
        int i = -1;
        if(mObserver == null) goto _L2; else goto _L1
_L1:
        int j;
        Log.d("RestoreSession", "restoreAll() called during active restore");
        j = -1;
_L4:
        return j;
_L2:
        mObserver = new RestoreObserverWrapper(mContext, restoreobserver);
        int k = mBinder.restoreSome(l, mObserver, as);
        i = k;
_L5:
        j = i;
        if(true) goto _L4; else goto _L3
_L3:
        RemoteException remoteexception;
        remoteexception;
        Log.d("RestoreSession", "Can't contact server to restore packages");
          goto _L5
    }

    static final String TAG = "RestoreSession";
    IRestoreSession mBinder;
    final Context mContext;
    RestoreObserverWrapper mObserver;
}
