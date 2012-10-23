// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.net.InetSocketAddress;
import java.util.NoSuchElementException;

// Referenced classes of package android.os:
//            RemoteException, ServiceManager, IBinder, CommonTimeUtils, 
//            Parcel, Binder

public class CommonClock {
    private class TimelineChangedListener extends Binder {

        protected boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR tableswitch 1 1: default 20
        //                       1 34;
               goto _L1 _L2
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L4:
            return flag;
_L2:
            long l;
            parcel.enforceInterface("android.os.ICommonClockListener");
            l = parcel.readLong();
            Object obj = mListenerLock;
            obj;
            JVM INSTR monitorenter ;
            if(mTimelineChangedListener != null)
                mTimelineChangedListener.onTimelineChanged(l);
            flag = true;
            if(true) goto _L4; else goto _L3
_L3:
        }

        private static final String DESCRIPTOR = "android.os.ICommonClockListener";
        final CommonClock this$0;

        private TimelineChangedListener() {
            this$0 = CommonClock.this;
            super();
        }

    }

    public static interface OnServerDiedListener {

        public abstract void onServerDied();
    }

    public static interface OnTimelineChangedListener {

        public abstract void onTimelineChanged(long l);
    }


    public CommonClock() throws RemoteException {
        mTimelineChangedListener = null;
        mServerDiedListener = null;
        mRemote = null;
        mInterfaceDesc = "";
        mDeathHandler = new IBinder.DeathRecipient() {

            public void binderDied() {
                Object obj = mListenerLock;
                obj;
                JVM INSTR monitorenter ;
                if(mServerDiedListener != null)
                    mServerDiedListener.onServerDied();
                return;
            }

            final CommonClock this$0;

             {
                this$0 = CommonClock.this;
                super();
            }
        };
        mCallbackTgt = null;
        mRemote = ServiceManager.getService("common_time.clock");
        if(mRemote == null) {
            throw new RemoteException();
        } else {
            mInterfaceDesc = mRemote.getInterfaceDescriptor();
            mUtils = new CommonTimeUtils(mRemote, mInterfaceDesc);
            mRemote.linkToDeath(mDeathHandler, 0);
            registerTimelineChangeListener();
            return;
        }
    }

    public static CommonClock create() {
        CommonClock commonclock;
        try {
            commonclock = new CommonClock();
        }
        catch(RemoteException remoteexception) {
            commonclock = null;
        }
        return commonclock;
    }

    private void registerTimelineChangeListener() throws RemoteException {
        if(mCallbackTgt == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        mCallbackTgt = new TimelineChangedListener();
        int i;
        parcel.writeInterfaceToken(mInterfaceDesc);
        parcel.writeStrongBinder(mCallbackTgt);
        mRemote.transact(12, parcel, parcel1, 0);
        i = parcel1.readInt();
        boolean flag;
        if(i == 0)
            flag = true;
        else
            flag = false;
        parcel1.recycle();
        parcel.recycle();
_L4:
        if(!flag) {
            mCallbackTgt = null;
            mRemote = null;
            mUtils = null;
        }
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        parcel1.recycle();
        parcel.recycle();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        if(true) goto _L1; else goto _L5
_L5:
    }

    private void throwOnDeadServer() throws RemoteException {
        if(mRemote == null || mUtils == null)
            throw new RemoteException();
        else
            return;
    }

    private void unregisterTimelineChangeListener() {
        if(mCallbackTgt != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken(mInterfaceDesc);
        parcel.writeStrongBinder(mCallbackTgt);
        mRemote.transact(13, parcel, parcel1, 0);
        parcel1.recycle();
        parcel.recycle();
        mCallbackTgt = null;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        parcel1.recycle();
        parcel.recycle();
        mCallbackTgt = null;
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        mCallbackTgt = null;
        throw exception;
    }

    protected void finalize() throws Throwable {
        release();
    }

    public int getEstimatedError() throws RemoteException {
        throwOnDeadServer();
        return mUtils.transactGetInt(8, 0x7fffffff);
    }

    public InetSocketAddress getMasterAddr() throws RemoteException {
        throwOnDeadServer();
        return mUtils.transactGetSockaddr(11);
    }

    public int getState() throws RemoteException {
        throwOnDeadServer();
        return mUtils.transactGetInt(10, -1);
    }

    public long getTime() throws RemoteException {
        throwOnDeadServer();
        return mUtils.transactGetLong(4, -1L);
    }

    public long getTimelineId() throws RemoteException {
        throwOnDeadServer();
        return mUtils.transactGetLong(9, 0L);
    }

    public void release() {
        unregisterTimelineChangeListener();
        if(mRemote != null) {
            try {
                mRemote.unlinkToDeath(mDeathHandler, 0);
            }
            catch(NoSuchElementException nosuchelementexception) { }
            mRemote = null;
        }
        mUtils = null;
    }

    public void setServerDiedListener(OnServerDiedListener onserverdiedlistener) {
        Object obj = mListenerLock;
        obj;
        JVM INSTR monitorenter ;
        mServerDiedListener = onserverdiedlistener;
        return;
    }

    public void setTimelineChangedListener(OnTimelineChangedListener ontimelinechangedlistener) {
        Object obj = mListenerLock;
        obj;
        JVM INSTR monitorenter ;
        mTimelineChangedListener = ontimelinechangedlistener;
        return;
    }

    public static final int ERROR_ESTIMATE_UNKNOWN = 0x7fffffff;
    public static final long INVALID_TIMELINE_ID = 0L;
    private static final int METHOD_CBK_ON_TIMELINE_CHANGED = 1;
    private static final int METHOD_COMMON_TIME_TO_LOCAL_TIME = 2;
    private static final int METHOD_GET_COMMON_FREQ = 5;
    private static final int METHOD_GET_COMMON_TIME = 4;
    private static final int METHOD_GET_ESTIMATED_ERROR = 8;
    private static final int METHOD_GET_LOCAL_FREQ = 7;
    private static final int METHOD_GET_LOCAL_TIME = 6;
    private static final int METHOD_GET_MASTER_ADDRESS = 11;
    private static final int METHOD_GET_STATE = 10;
    private static final int METHOD_GET_TIMELINE_ID = 9;
    private static final int METHOD_IS_COMMON_TIME_VALID = 1;
    private static final int METHOD_LOCAL_TIME_TO_COMMON_TIME = 3;
    private static final int METHOD_REGISTER_LISTENER = 12;
    private static final int METHOD_UNREGISTER_LISTENER = 13;
    public static final String SERVICE_NAME = "common_time.clock";
    public static final int STATE_CLIENT = 1;
    public static final int STATE_INITIAL = 0;
    public static final int STATE_INVALID = -1;
    public static final int STATE_MASTER = 2;
    public static final int STATE_RONIN = 3;
    public static final int STATE_WAIT_FOR_ELECTION = 4;
    public static final long TIME_NOT_SYNCED = -1L;
    private TimelineChangedListener mCallbackTgt;
    private IBinder.DeathRecipient mDeathHandler;
    private String mInterfaceDesc;
    private final Object mListenerLock = new Object();
    private IBinder mRemote;
    private OnServerDiedListener mServerDiedListener;
    private OnTimelineChangedListener mTimelineChangedListener;
    private CommonTimeUtils mUtils;



}
