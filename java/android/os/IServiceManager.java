// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            IInterface, RemoteException, IBinder, IPermissionController

public interface IServiceManager
    extends IInterface {

    public abstract void addService(String s, IBinder ibinder, boolean flag) throws RemoteException;

    public abstract IBinder checkService(String s) throws RemoteException;

    public abstract IBinder getService(String s) throws RemoteException;

    public abstract String[] listServices() throws RemoteException;

    public abstract void setPermissionController(IPermissionController ipermissioncontroller) throws RemoteException;

    public static final int ADD_SERVICE_TRANSACTION = 3;
    public static final int CHECK_SERVICES_TRANSACTION = 5;
    public static final int CHECK_SERVICE_TRANSACTION = 2;
    public static final int GET_SERVICE_TRANSACTION = 1;
    public static final int LIST_SERVICES_TRANSACTION = 4;
    public static final int SET_PERMISSION_CONTROLLER_TRANSACTION = 6;
    public static final String descriptor = "android.os.IServiceManager";
}
