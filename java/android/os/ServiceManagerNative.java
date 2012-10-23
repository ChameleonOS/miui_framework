// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            Binder, IServiceManager, IBinder, ServiceManagerProxy, 
//            RemoteException, Parcel

public abstract class ServiceManagerNative extends Binder
    implements IServiceManager {

    public ServiceManagerNative() {
        attachInterface(this, "android.os.IServiceManager");
    }

    public static IServiceManager asInterface(IBinder ibinder) {
        if(ibinder != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((IServiceManager) (obj));
_L2:
        obj = (IServiceManager)ibinder.queryLocalInterface("android.os.IServiceManager");
        if(obj == null)
            obj = new ServiceManagerProxy(ibinder);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) {
        boolean flag = true;
        i;
        JVM INSTR tableswitch 1 6: default 44
    //                   1 50
    //                   2 71
    //                   3 92
    //                   4 134
    //                   5 44
    //                   6 151;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6
_L1:
        flag = false;
_L7:
        return flag;
_L2:
        parcel.enforceInterface("android.os.IServiceManager");
        parcel1.writeStrongBinder(getService(parcel.readString()));
          goto _L7
_L3:
        parcel.enforceInterface("android.os.IServiceManager");
        parcel1.writeStrongBinder(checkService(parcel.readString()));
          goto _L7
_L4:
        String s;
        IBinder ibinder;
        boolean flag1;
        parcel.enforceInterface("android.os.IServiceManager");
        s = parcel.readString();
        ibinder = parcel.readStrongBinder();
        if(parcel.readInt() == 0)
            break MISSING_BLOCK_LABEL_176;
        flag1 = flag;
_L8:
        addService(s, ibinder, flag1);
          goto _L7
_L5:
        parcel.enforceInterface("android.os.IServiceManager");
        parcel1.writeStringArray(listServices());
          goto _L7
_L6:
        parcel.enforceInterface("android.os.IServiceManager");
        setPermissionController(IPermissionController.Stub.asInterface(parcel.readStrongBinder()));
          goto _L7
        RemoteException remoteexception;
        remoteexception;
          goto _L1
        flag1 = false;
          goto _L8
    }
}
