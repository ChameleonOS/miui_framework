// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.net.InetSocketAddress;
import java.util.NoSuchElementException;

// Referenced classes of package android.os:
//            RemoteException, ServiceManager, IBinder, CommonTimeUtils, 
//            Parcel

public class CommonTimeConfig {
    public static interface OnServerDiedListener {

        public abstract void onServerDied();
    }


    public CommonTimeConfig() throws RemoteException {
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

            final CommonTimeConfig this$0;

             {
                this$0 = CommonTimeConfig.this;
                super();
            }
        };
        mRemote = ServiceManager.getService("common_time.config");
        if(mRemote == null) {
            throw new RemoteException();
        } else {
            mInterfaceDesc = mRemote.getInterfaceDescriptor();
            mUtils = new CommonTimeUtils(mRemote, mInterfaceDesc);
            mRemote.linkToDeath(mDeathHandler, 0);
            return;
        }
    }

    private boolean checkDeadServer() {
        boolean flag;
        if(mRemote == null || mUtils == null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static CommonTimeConfig create() {
        CommonTimeConfig commontimeconfig;
        try {
            commontimeconfig = new CommonTimeConfig();
        }
        catch(RemoteException remoteexception) {
            commontimeconfig = null;
        }
        return commontimeconfig;
    }

    private void throwOnDeadServer() throws RemoteException {
        if(checkDeadServer())
            throw new RemoteException();
        else
            return;
    }

    protected void finalize() throws Throwable {
        release();
    }

    public int forceNetworklessMasterMode() {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int j;
        parcel.writeInterfaceToken(mInterfaceDesc);
        mRemote.transact(17, parcel, parcel1, 0);
        j = parcel1.readInt();
        int i;
        i = j;
        parcel1.recycle();
        parcel.recycle();
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        i = -7;
        parcel1.recycle();
        parcel.recycle();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean getAutoDisable() throws RemoteException {
        boolean flag = true;
        throwOnDeadServer();
        if(flag != mUtils.transactGetInt(15, flag))
            flag = false;
        return flag;
    }

    public int getClientSyncInterval() throws RemoteException {
        throwOnDeadServer();
        return mUtils.transactGetInt(11, -1);
    }

    public String getInterfaceBinding() throws RemoteException {
        throwOnDeadServer();
        String s = mUtils.transactGetString(7, null);
        if(s != null && s.length() == 0)
            s = null;
        return s;
    }

    public int getMasterAnnounceInterval() throws RemoteException {
        throwOnDeadServer();
        return mUtils.transactGetInt(9, -1);
    }

    public InetSocketAddress getMasterElectionEndpoint() throws RemoteException {
        throwOnDeadServer();
        return mUtils.transactGetSockaddr(3);
    }

    public long getMasterElectionGroupId() throws RemoteException {
        throwOnDeadServer();
        return mUtils.transactGetLong(5, -1L);
    }

    public byte getMasterElectionPriority() throws RemoteException {
        throwOnDeadServer();
        return (byte)mUtils.transactGetInt(1, -1);
    }

    public int getPanicThreshold() throws RemoteException {
        throwOnDeadServer();
        return mUtils.transactGetInt(13, -1);
    }

    public void release() {
        if(mRemote != null) {
            try {
                mRemote.unlinkToDeath(mDeathHandler, 0);
            }
            catch(NoSuchElementException nosuchelementexception) { }
            mRemote = null;
        }
        mUtils = null;
    }

    public int setAutoDisable(boolean flag) {
        int j;
        if(checkDeadServer()) {
            j = -7;
        } else {
            CommonTimeUtils commontimeutils = mUtils;
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            j = commontimeutils.transactSetInt(16, i);
        }
        return j;
    }

    public int setClientSyncInterval(int i) {
        int j;
        if(checkDeadServer())
            j = -7;
        else
            j = mUtils.transactSetInt(12, i);
        return j;
    }

    public int setMasterAnnounceInterval(int i) {
        int j;
        if(checkDeadServer())
            j = -7;
        else
            j = mUtils.transactSetInt(10, i);
        return j;
    }

    public int setMasterElectionEndpoint(InetSocketAddress inetsocketaddress) {
        int i;
        if(checkDeadServer())
            i = -7;
        else
            i = mUtils.transactSetSockaddr(4, inetsocketaddress);
        return i;
    }

    public int setMasterElectionGroupId(long l) {
        int i;
        if(checkDeadServer())
            i = -7;
        else
            i = mUtils.transactSetLong(6, l);
        return i;
    }

    public int setMasterElectionPriority(byte byte0) {
        int i;
        if(checkDeadServer())
            i = -7;
        else
            i = mUtils.transactSetInt(2, byte0);
        return i;
    }

    public int setNetworkBinding(String s) {
        int i;
        if(checkDeadServer()) {
            i = -7;
        } else {
            CommonTimeUtils commontimeutils = mUtils;
            if(s == null)
                s = "";
            i = commontimeutils.transactSetString(8, s);
        }
        return i;
    }

    public int setPanicThreshold(int i) {
        int j;
        if(checkDeadServer())
            j = -7;
        else
            j = mUtils.transactSetInt(14, i);
        return j;
    }

    public void setServerDiedListener(OnServerDiedListener onserverdiedlistener) {
        Object obj = mListenerLock;
        obj;
        JVM INSTR monitorenter ;
        mServerDiedListener = onserverdiedlistener;
        return;
    }

    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -4;
    public static final int ERROR_DEAD_OBJECT = -7;
    public static final long INVALID_GROUP_ID = -1L;
    private static final int METHOD_FORCE_NETWORKLESS_MASTER_MODE = 17;
    private static final int METHOD_GET_AUTO_DISABLE = 15;
    private static final int METHOD_GET_CLIENT_SYNC_INTERVAL = 11;
    private static final int METHOD_GET_INTERFACE_BINDING = 7;
    private static final int METHOD_GET_MASTER_ANNOUNCE_INTERVAL = 9;
    private static final int METHOD_GET_MASTER_ELECTION_ENDPOINT = 3;
    private static final int METHOD_GET_MASTER_ELECTION_GROUP_ID = 5;
    private static final int METHOD_GET_MASTER_ELECTION_PRIORITY = 1;
    private static final int METHOD_GET_PANIC_THRESHOLD = 13;
    private static final int METHOD_SET_AUTO_DISABLE = 16;
    private static final int METHOD_SET_CLIENT_SYNC_INTERVAL = 12;
    private static final int METHOD_SET_INTERFACE_BINDING = 8;
    private static final int METHOD_SET_MASTER_ANNOUNCE_INTERVAL = 10;
    private static final int METHOD_SET_MASTER_ELECTION_ENDPOINT = 4;
    private static final int METHOD_SET_MASTER_ELECTION_GROUP_ID = 6;
    private static final int METHOD_SET_MASTER_ELECTION_PRIORITY = 2;
    private static final int METHOD_SET_PANIC_THRESHOLD = 14;
    public static final String SERVICE_NAME = "common_time.config";
    public static final int SUCCESS;
    private IBinder.DeathRecipient mDeathHandler;
    private String mInterfaceDesc;
    private final Object mListenerLock = new Object();
    private IBinder mRemote;
    private OnServerDiedListener mServerDiedListener;
    private CommonTimeUtils mUtils;


}
