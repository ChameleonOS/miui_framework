// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.net.*;
import libcore.io.OsConstants;

// Referenced classes of package android.os:
//            RemoteException, Parcel, IBinder

class CommonTimeUtils {

    public CommonTimeUtils(IBinder ibinder, String s) {
        mRemote = ibinder;
        mInterfaceDesc = s;
    }

    public int transactGetInt(int i, int j) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken(mInterfaceDesc);
        mRemote.transact(i, parcel, parcel1, 0);
        if(parcel1.readInt() != 0) goto _L2; else goto _L1
_L1:
        int l = parcel1.readInt();
        int k = l;
_L4:
        parcel1.recycle();
        parcel.recycle();
        return k;
_L2:
        k = j;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public long transactGetLong(int i, long l) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken(mInterfaceDesc);
        mRemote.transact(i, parcel, parcel1, 0);
        if(parcel1.readInt() != 0) goto _L2; else goto _L1
_L1:
        long l2 = parcel1.readLong();
        long l1 = l2;
_L4:
        parcel1.recycle();
        parcel.recycle();
        return l1;
_L2:
        l1 = l;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public InetSocketAddress transactGetSockaddr(int i) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        InetSocketAddress inetsocketaddress;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        inetsocketaddress = null;
        parcel.writeInterfaceToken(mInterfaceDesc);
        mRemote.transact(i, parcel, parcel1, 0);
        if(parcel1.readInt() != 0) goto _L2; else goto _L1
_L1:
        int j;
        String s;
        int k;
        j = 0;
        s = null;
        k = parcel1.readInt();
        if(OsConstants.AF_INET != k) goto _L4; else goto _L3
_L3:
        int l1 = parcel1.readInt();
        j = parcel1.readInt();
        Object aobj1[] = new Object[4];
        aobj1[0] = Integer.valueOf(0xff & l1 >> 24);
        aobj1[1] = Integer.valueOf(0xff & l1 >> 16);
        aobj1[2] = Integer.valueOf(0xff & l1 >> 8);
        aobj1[3] = Integer.valueOf(l1 & 0xff);
        s = String.format("%d.%d.%d.%d", aobj1);
_L6:
        if(s != null)
            inetsocketaddress = new InetSocketAddress(s, j);
_L2:
        parcel1.recycle();
        parcel.recycle();
        return inetsocketaddress;
_L4:
        if(OsConstants.AF_INET6 != k) goto _L6; else goto _L5
_L5:
        String s1;
        int l = parcel1.readInt();
        int i1 = parcel1.readInt();
        int j1 = parcel1.readInt();
        int k1 = parcel1.readInt();
        j = parcel1.readInt();
        parcel1.readInt();
        parcel1.readInt();
        Object aobj[] = new Object[8];
        aobj[0] = Integer.valueOf(0xffff & l >> 16);
        aobj[1] = Integer.valueOf(0xffff & l);
        aobj[2] = Integer.valueOf(0xffff & i1 >> 16);
        aobj[3] = Integer.valueOf(0xffff & i1);
        aobj[4] = Integer.valueOf(0xffff & j1 >> 16);
        aobj[5] = Integer.valueOf(0xffff & j1);
        aobj[6] = Integer.valueOf(0xffff & k1 >> 16);
        aobj[7] = Integer.valueOf(0xffff & k1);
        s1 = String.format("[%04X:%04X:%04X:%04X:%04X:%04X:%04X:%04X]", aobj);
        s = s1;
          goto _L6
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public String transactGetString(int i, String s) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken(mInterfaceDesc);
        mRemote.transact(i, parcel, parcel1, 0);
        if(parcel1.readInt() != 0) goto _L2; else goto _L1
_L1:
        String s2 = parcel1.readString();
        String s1 = s2;
_L4:
        parcel1.recycle();
        parcel.recycle();
        return s1;
_L2:
        s1 = s;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public int transactSetInt(int i, int j) {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int l;
        parcel.writeInterfaceToken(mInterfaceDesc);
        parcel.writeInt(j);
        mRemote.transact(i, parcel, parcel1, 0);
        l = parcel1.readInt();
        int k;
        k = l;
        parcel1.recycle();
        parcel.recycle();
_L2:
        return k;
        RemoteException remoteexception;
        remoteexception;
        k = -7;
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

    public int transactSetLong(int i, long l) {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int k;
        parcel.writeInterfaceToken(mInterfaceDesc);
        parcel.writeLong(l);
        mRemote.transact(i, parcel, parcel1, 0);
        k = parcel1.readInt();
        int j;
        j = k;
        parcel1.recycle();
        parcel.recycle();
_L2:
        return j;
        RemoteException remoteexception;
        remoteexception;
        j = -7;
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

    public int transactSetSockaddr(int i, InetSocketAddress inetsocketaddress) {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken(mInterfaceDesc);
        if(inetsocketaddress != null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(0);
_L3:
        int j1;
        mRemote.transact(i, parcel, parcel1, 0);
        j1 = parcel1.readInt();
        int j;
        j = j1;
        parcel1.recycle();
        parcel.recycle();
_L4:
        int k = j;
_L5:
        return k;
_L2:
        InetAddress inetaddress;
        byte abyte0[];
        int l;
        parcel.writeInt(1);
        inetaddress = inetsocketaddress.getAddress();
        abyte0 = inetaddress.getAddress();
        l = inetsocketaddress.getPort();
        if(!(inetaddress instanceof Inet4Address))
            break MISSING_BLOCK_LABEL_186;
        int k1 = (0xff & abyte0[0]) << 24 | (0xff & abyte0[1]) << 16 | (0xff & abyte0[2]) << 8 | 0xff & abyte0[3];
        parcel.writeInt(OsConstants.AF_INET);
        parcel.writeInt(k1);
        parcel.writeInt(l);
          goto _L3
        RemoteException remoteexception;
        remoteexception;
        j = -7;
        parcel1.recycle();
        parcel.recycle();
          goto _L4
        if(!(inetaddress instanceof Inet6Address))
            break MISSING_BLOCK_LABEL_328;
        Inet6Address inet6address = (Inet6Address)inetaddress;
        parcel.writeInt(OsConstants.AF_INET6);
        for(int i1 = 0; i1 < 4; i1++)
            parcel.writeInt((0xff & abyte0[0 + i1 * 4]) << 24 | (0xff & abyte0[1 + i1 * 4]) << 16 | (0xff & abyte0[2 + i1 * 4]) << 8 | 0xff & abyte0[3 + i1 * 4]);

        parcel.writeInt(l);
        parcel.writeInt(0);
        parcel.writeInt(inet6address.getScopeId());
          goto _L3
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        k = -4;
        parcel1.recycle();
        parcel.recycle();
          goto _L5
    }

    public int transactSetString(int i, String s) {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int k;
        parcel.writeInterfaceToken(mInterfaceDesc);
        parcel.writeString(s);
        mRemote.transact(i, parcel, parcel1, 0);
        k = parcel1.readInt();
        int j;
        j = k;
        parcel1.recycle();
        parcel.recycle();
_L2:
        return j;
        RemoteException remoteexception;
        remoteexception;
        j = -7;
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

    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -4;
    public static final int ERROR_DEAD_OBJECT = -7;
    public static final int SUCCESS;
    private String mInterfaceDesc;
    private IBinder mRemote;
}
