// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.util.ArrayList;

// Referenced classes of package android.os:
//            IServiceManager, RemoteException, Parcel, IBinder, 
//            IPermissionController

class ServiceManagerProxy
    implements IServiceManager {

    public ServiceManagerProxy(IBinder ibinder) {
        mRemote = ibinder;
    }

    public void addService(String s, IBinder ibinder, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.os.IServiceManager");
        parcel.writeString(s);
        parcel.writeStrongBinder(ibinder);
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(3, parcel, parcel1, 0);
        parcel1.recycle();
        parcel.recycle();
    }

    public IBinder asBinder() {
        return mRemote;
    }

    public IBinder checkService(String s) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.os.IServiceManager");
        parcel.writeString(s);
        mRemote.transact(2, parcel, parcel1, 0);
        IBinder ibinder = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return ibinder;
    }

    public IBinder getService(String s) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.os.IServiceManager");
        parcel.writeString(s);
        mRemote.transact(1, parcel, parcel1, 0);
        IBinder ibinder = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return ibinder;
    }

    public String[] listServices() throws RemoteException {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        i = 0;
_L4:
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.os.IServiceManager");
        parcel.writeInt(i);
        i++;
        boolean flag = mRemote.transact(4, parcel, parcel1, 0);
        if(flag)
            break MISSING_BLOCK_LABEL_78;
_L2:
        String as[] = new String[arraylist.size()];
        arraylist.toArray(as);
        return as;
        RuntimeException runtimeexception;
        runtimeexception;
        if(true) goto _L2; else goto _L1
_L1:
        arraylist.add(parcel1.readString());
        parcel1.recycle();
        parcel.recycle();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setPermissionController(IPermissionController ipermissioncontroller) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.os.IServiceManager");
        parcel.writeStrongBinder(ipermissioncontroller.asBinder());
        mRemote.transact(6, parcel, parcel1, 0);
        parcel1.recycle();
        parcel.recycle();
    }

    private IBinder mRemote;
}
