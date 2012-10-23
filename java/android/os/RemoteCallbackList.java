// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.util.*;

// Referenced classes of package android.os:
//            IInterface, IBinder, RemoteException

public class RemoteCallbackList {
    private final class Callback
        implements IBinder.DeathRecipient {

        public void binderDied() {
            synchronized(mCallbacks) {
                mCallbacks.remove(mCallback.asBinder());
            }
            onCallbackDied(mCallback, mCookie);
            return;
            exception;
            hashmap;
            JVM INSTR monitorexit ;
            throw exception;
        }

        final IInterface mCallback;
        final Object mCookie;
        final RemoteCallbackList this$0;

        Callback(IInterface iinterface, Object obj) {
            this$0 = RemoteCallbackList.this;
            super();
            mCallback = iinterface;
            mCookie = obj;
        }
    }


    public RemoteCallbackList() {
        mCallbacks = new HashMap();
        mBroadcastCount = -1;
        mKilled = false;
    }

    public int beginBroadcast() {
        HashMap hashmap = mCallbacks;
        hashmap;
        JVM INSTR monitorenter ;
        if(mBroadcastCount > 0)
            throw new IllegalStateException("beginBroadcast() called while already in a broadcast");
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        throw exception;
        int i;
        i = mCallbacks.size();
        mBroadcastCount = i;
        if(i > 0) goto _L2; else goto _L1
_L1:
        int j = 0;
        hashmap;
        JVM INSTR monitorexit ;
          goto _L3
_L2:
        Object aobj[] = mActiveBroadcast;
        if(aobj == null || aobj.length < i) {
            aobj = new Object[i];
            mActiveBroadcast = aobj;
        }
        Iterator iterator = mCallbacks.values().iterator();
        int k;
        for(j = 0; iterator.hasNext(); j = k) {
            Callback callback = (Callback)iterator.next();
            k = j + 1;
            aobj[j] = callback;
        }

        hashmap;
        JVM INSTR monitorexit ;
_L3:
        return j;
    }

    public void finishBroadcast() {
        if(mBroadcastCount < 0)
            throw new IllegalStateException("finishBroadcast() called outside of a broadcast");
        Object aobj[] = mActiveBroadcast;
        if(aobj != null) {
            int i = mBroadcastCount;
            for(int j = 0; j < i; j++)
                aobj[j] = null;

        }
        mBroadcastCount = -1;
    }

    public Object getBroadcastCookie(int i) {
        return ((Callback)mActiveBroadcast[i]).mCookie;
    }

    public IInterface getBroadcastItem(int i) {
        return ((Callback)mActiveBroadcast[i]).mCallback;
    }

    public void kill() {
        HashMap hashmap = mCallbacks;
        hashmap;
        JVM INSTR monitorenter ;
        Callback callback;
        for(Iterator iterator = mCallbacks.values().iterator(); iterator.hasNext(); callback.mCallback.asBinder().unlinkToDeath(callback, 0))
            callback = (Callback)iterator.next();

        break MISSING_BLOCK_LABEL_67;
        Exception exception;
        exception;
        throw exception;
        mCallbacks.clear();
        mKilled = true;
        hashmap;
        JVM INSTR monitorexit ;
    }

    public void onCallbackDied(IInterface iinterface) {
    }

    public void onCallbackDied(IInterface iinterface, Object obj) {
        onCallbackDied(iinterface);
    }

    public boolean register(IInterface iinterface) {
        return register(iinterface, null);
    }

    public boolean register(IInterface iinterface, Object obj) {
        boolean flag = false;
        HashMap hashmap = mCallbacks;
        hashmap;
        JVM INSTR monitorenter ;
        if(!mKilled) goto _L2; else goto _L1
_L2:
        IBinder ibinder = iinterface.asBinder();
        Callback callback = new Callback(iinterface, obj);
        ibinder.linkToDeath(callback, 0);
        mCallbacks.put(ibinder, callback);
        flag = true;
        hashmap;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
        RemoteException remoteexception;
        remoteexception;
        hashmap;
        JVM INSTR monitorexit ;
_L1:
        return flag;
    }

    public boolean unregister(IInterface iinterface) {
        boolean flag = false;
        HashMap hashmap = mCallbacks;
        hashmap;
        JVM INSTR monitorenter ;
        Callback callback = (Callback)mCallbacks.remove(iinterface.asBinder());
        if(callback != null) {
            callback.mCallback.asBinder().unlinkToDeath(callback, 0);
            flag = true;
        }
        return flag;
    }

    private Object mActiveBroadcast[];
    private int mBroadcastCount;
    HashMap mCallbacks;
    private boolean mKilled;
}
