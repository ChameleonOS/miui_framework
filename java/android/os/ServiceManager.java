// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.Log;
import com.android.internal.os.BinderInternal;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.os:
//            RemoteException, IServiceManager, IBinder, ServiceManagerNative

public final class ServiceManager {

    public ServiceManager() {
    }

    public static void addService(String s, IBinder ibinder) {
        getIServiceManager().addService(s, ibinder, false);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("ServiceManager", "error in addService", remoteexception);
          goto _L1
    }

    public static void addService(String s, IBinder ibinder, boolean flag) {
        getIServiceManager().addService(s, ibinder, flag);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("ServiceManager", "error in addService", remoteexception);
          goto _L1
    }

    public static IBinder checkService(String s) {
        IBinder ibinder;
        IBinder ibinder1;
        ibinder = (IBinder)sCache.get(s);
        if(ibinder != null)
            break MISSING_BLOCK_LABEL_47;
        ibinder1 = getIServiceManager().checkService(s);
        ibinder = ibinder1;
        break MISSING_BLOCK_LABEL_47;
        RemoteException remoteexception;
        remoteexception;
        Log.e("ServiceManager", "error in checkService", remoteexception);
        ibinder = null;
        return ibinder;
    }

    private static IServiceManager getIServiceManager() {
        IServiceManager iservicemanager;
        if(sServiceManager != null) {
            iservicemanager = sServiceManager;
        } else {
            sServiceManager = ServiceManagerNative.asInterface(BinderInternal.getContextObject());
            iservicemanager = sServiceManager;
        }
        return iservicemanager;
    }

    public static IBinder getService(String s) {
        IBinder ibinder;
        IBinder ibinder1;
        ibinder = (IBinder)sCache.get(s);
        if(ibinder != null)
            break MISSING_BLOCK_LABEL_47;
        ibinder1 = getIServiceManager().getService(s);
        ibinder = ibinder1;
        break MISSING_BLOCK_LABEL_47;
        RemoteException remoteexception;
        remoteexception;
        Log.e("ServiceManager", "error in getService", remoteexception);
        ibinder = null;
        return ibinder;
    }

    public static void initServiceCache(Map map) {
        if(sCache.size() != 0) {
            throw new IllegalStateException("setServiceCache may only be called once");
        } else {
            sCache.putAll(map);
            return;
        }
    }

    public static String[] listServices() throws RemoteException {
        String as1[] = getIServiceManager().listServices();
        String as[] = as1;
_L2:
        return as;
        RemoteException remoteexception;
        remoteexception;
        Log.e("ServiceManager", "error in listServices", remoteexception);
        as = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final String TAG = "ServiceManager";
    private static HashMap sCache = new HashMap();
    private static IServiceManager sServiceManager;

}
