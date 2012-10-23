// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.nsd;

import android.content.Context;
import android.os.*;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.util.AsyncChannel;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package android.net.nsd:
//            INsdManager, NsdServiceInfo

public final class NsdManager {
    private class ServiceHandler extends Handler {

        public void handleMessage(Message message) {
            Object obj;
            boolean flag;
            obj = getListener(message.arg2);
            flag = true;
            message.what;
            JVM INSTR lookupswitch 15: default 148
        //                       69632: 189
        //                       69634: 173
        //                       69636: 214
        //                       393218: 225
        //                       393219: 253
        //                       393220: 283
        //                       393221: 304
        //                       393223: 325
        //                       393224: 355
        //                       393226: 381
        //                       393227: 408
        //                       393229: 429
        //                       393230: 456
        //                       393235: 479
        //                       393236: 506;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L3:
            break; /* Loop/switch isn't completed */
_L1:
            Log.d("NsdManager", (new StringBuilder()).append("Ignored ").append(message).toString());
_L18:
            if(flag)
                removeListener(message.arg2);
            return;
_L2:
            mAsyncChannel.sendMessage(0x11001);
            mConnected.countDown();
            continue; /* Loop/switch isn't completed */
_L4:
            Log.e("NsdManager", "Channel lost");
            continue; /* Loop/switch isn't completed */
_L5:
            String s = ((NsdServiceInfo)message.obj).getServiceType();
            ((DiscoveryListener)obj).onDiscoveryStarted(s);
            flag = false;
            continue; /* Loop/switch isn't completed */
_L6:
            ((DiscoveryListener)obj).onStartDiscoveryFailed(getNsdService(message.arg2).getServiceType(), message.arg1);
            continue; /* Loop/switch isn't completed */
_L7:
            ((DiscoveryListener)obj).onServiceFound((NsdServiceInfo)message.obj);
            flag = false;
            continue; /* Loop/switch isn't completed */
_L8:
            ((DiscoveryListener)obj).onServiceLost((NsdServiceInfo)message.obj);
            flag = false;
            continue; /* Loop/switch isn't completed */
_L9:
            ((DiscoveryListener)obj).onStopDiscoveryFailed(getNsdService(message.arg2).getServiceType(), message.arg1);
            continue; /* Loop/switch isn't completed */
_L10:
            ((DiscoveryListener)obj).onDiscoveryStopped(getNsdService(message.arg2).getServiceType());
            continue; /* Loop/switch isn't completed */
_L11:
            ((RegistrationListener)obj).onRegistrationFailed(getNsdService(message.arg2), message.arg1);
            continue; /* Loop/switch isn't completed */
_L12:
            ((RegistrationListener)obj).onServiceRegistered((NsdServiceInfo)message.obj);
            flag = false;
            continue; /* Loop/switch isn't completed */
_L13:
            ((RegistrationListener)obj).onUnregistrationFailed(getNsdService(message.arg2), message.arg1);
            continue; /* Loop/switch isn't completed */
_L14:
            ((RegistrationListener)obj).onServiceUnregistered(getNsdService(message.arg2));
            continue; /* Loop/switch isn't completed */
_L15:
            ((ResolveListener)obj).onResolveFailed(getNsdService(message.arg2), message.arg1);
            continue; /* Loop/switch isn't completed */
_L16:
            ((ResolveListener)obj).onServiceResolved((NsdServiceInfo)message.obj);
            if(true) goto _L18; else goto _L17
_L17:
        }

        final NsdManager this$0;

        ServiceHandler(Looper looper) {
            this$0 = NsdManager.this;
            super(looper);
        }
    }

    public static interface ResolveListener {

        public abstract void onResolveFailed(NsdServiceInfo nsdserviceinfo, int i);

        public abstract void onServiceResolved(NsdServiceInfo nsdserviceinfo);
    }

    public static interface RegistrationListener {

        public abstract void onRegistrationFailed(NsdServiceInfo nsdserviceinfo, int i);

        public abstract void onServiceRegistered(NsdServiceInfo nsdserviceinfo);

        public abstract void onServiceUnregistered(NsdServiceInfo nsdserviceinfo);

        public abstract void onUnregistrationFailed(NsdServiceInfo nsdserviceinfo, int i);
    }

    public static interface DiscoveryListener {

        public abstract void onDiscoveryStarted(String s);

        public abstract void onDiscoveryStopped(String s);

        public abstract void onServiceFound(NsdServiceInfo nsdserviceinfo);

        public abstract void onServiceLost(NsdServiceInfo nsdserviceinfo);

        public abstract void onStartDiscoveryFailed(String s, int i);

        public abstract void onStopDiscoveryFailed(String s, int i);
    }


    public NsdManager(Context context, INsdManager insdmanager) {
        mListenerKey = 1;
        mService = insdmanager;
        mContext = context;
        init();
    }

    private Object getListener(int i) {
        if(i != 0) goto _L2; else goto _L1
_L1:
        Object obj1 = null;
_L4:
        return obj1;
_L2:
        Object obj = mMapLock;
        obj;
        JVM INSTR monitorenter ;
        obj1 = mListenerMap.get(i);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private int getListenerKey(Object obj) {
        Object obj1 = mMapLock;
        obj1;
        JVM INSTR monitorenter ;
        int i = mListenerMap.indexOfValue(obj);
        int j;
        if(i != -1)
            j = mListenerMap.keyAt(i);
        else
            j = 0;
        return j;
    }

    private Messenger getMessenger() {
        Messenger messenger1 = mService.getMessenger();
        Messenger messenger = messenger1;
_L2:
        return messenger;
        RemoteException remoteexception;
        remoteexception;
        messenger = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private NsdServiceInfo getNsdService(int i) {
        Object obj = mMapLock;
        obj;
        JVM INSTR monitorenter ;
        NsdServiceInfo nsdserviceinfo = (NsdServiceInfo)mServiceMap.get(i);
        return nsdserviceinfo;
    }

    private void init() {
        Messenger messenger = getMessenger();
        if(messenger == null)
            throw new RuntimeException("Failed to initialize");
        HandlerThread handlerthread = new HandlerThread("NsdManager");
        handlerthread.start();
        mHandler = new ServiceHandler(handlerthread.getLooper());
        mAsyncChannel.connect(mContext, mHandler, messenger);
        mConnected.await();
_L1:
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.e("NsdManager", "interrupted wait at init");
          goto _L1
    }

    private int putListener(Object obj, NsdServiceInfo nsdserviceinfo) {
        if(obj != null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        return i;
_L2:
        Object obj1 = mMapLock;
        obj1;
        JVM INSTR monitorenter ;
        do {
            i = mListenerKey;
            mListenerKey = i + 1;
        } while(i == 0);
        mListenerMap.put(i, obj);
        mServiceMap.put(i, nsdserviceinfo);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void removeListener(int i) {
        if(i != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = mMapLock;
        obj;
        JVM INSTR monitorenter ;
        mListenerMap.remove(i);
        mServiceMap.remove(i);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void discoverServices(String s, int i, DiscoveryListener discoverylistener) {
        if(discoverylistener == null)
            throw new IllegalArgumentException("listener cannot be null");
        if(TextUtils.isEmpty(s))
            throw new IllegalArgumentException("Service type cannot be empty");
        if(i != 1) {
            throw new IllegalArgumentException("Unsupported protocol");
        } else {
            NsdServiceInfo nsdserviceinfo = new NsdServiceInfo();
            nsdserviceinfo.setServiceType(s);
            mAsyncChannel.sendMessage(0x60001, 0, putListener(discoverylistener, nsdserviceinfo), nsdserviceinfo);
            return;
        }
    }

    public void registerService(NsdServiceInfo nsdserviceinfo, int i, RegistrationListener registrationlistener) {
        if(TextUtils.isEmpty(nsdserviceinfo.getServiceName()) || TextUtils.isEmpty(nsdserviceinfo.getServiceType()))
            throw new IllegalArgumentException("Service name or type cannot be empty");
        if(nsdserviceinfo.getPort() <= 0)
            throw new IllegalArgumentException("Invalid port number");
        if(registrationlistener == null)
            throw new IllegalArgumentException("listener cannot be null");
        if(i != 1) {
            throw new IllegalArgumentException("Unsupported protocol");
        } else {
            mAsyncChannel.sendMessage(0x60009, 0, putListener(registrationlistener, nsdserviceinfo), nsdserviceinfo);
            return;
        }
    }

    public void resolveService(NsdServiceInfo nsdserviceinfo, ResolveListener resolvelistener) {
        if(TextUtils.isEmpty(nsdserviceinfo.getServiceName()) || TextUtils.isEmpty(nsdserviceinfo.getServiceType()))
            throw new IllegalArgumentException("Service name or type cannot be empty");
        if(resolvelistener == null) {
            throw new IllegalArgumentException("listener cannot be null");
        } else {
            mAsyncChannel.sendMessage(0x60012, 0, putListener(resolvelistener, nsdserviceinfo), nsdserviceinfo);
            return;
        }
    }

    public void setEnabled(boolean flag) {
        mService.setEnabled(flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void stopServiceDiscovery(DiscoveryListener discoverylistener) {
        int i = getListenerKey(discoverylistener);
        if(i == 0)
            throw new IllegalArgumentException("service discovery not active on listener");
        if(discoverylistener == null) {
            throw new IllegalArgumentException("listener cannot be null");
        } else {
            mAsyncChannel.sendMessage(0x60006, 0, i);
            return;
        }
    }

    public void unregisterService(RegistrationListener registrationlistener) {
        int i = getListenerKey(registrationlistener);
        if(i == 0)
            throw new IllegalArgumentException("listener not registered");
        if(registrationlistener == null) {
            throw new IllegalArgumentException("listener cannot be null");
        } else {
            mAsyncChannel.sendMessage(0x6000c, 0, i);
            return;
        }
    }

    public static final String ACTION_NSD_STATE_CHANGED = "android.net.nsd.STATE_CHANGED";
    private static final int BASE = 0x60000;
    public static final int DISABLE = 0x60019;
    public static final int DISCOVER_SERVICES = 0x60001;
    public static final int DISCOVER_SERVICES_FAILED = 0x60003;
    public static final int DISCOVER_SERVICES_STARTED = 0x60002;
    public static final int ENABLE = 0x60018;
    public static final String EXTRA_NSD_STATE = "nsd_state";
    public static final int FAILURE_ALREADY_ACTIVE = 3;
    public static final int FAILURE_INTERNAL_ERROR = 0;
    public static final int FAILURE_MAX_LIMIT = 4;
    private static final int INVALID_LISTENER_KEY = 0;
    public static final int NATIVE_DAEMON_EVENT = 0x6001a;
    public static final int NSD_STATE_DISABLED = 1;
    public static final int NSD_STATE_ENABLED = 2;
    public static final int PROTOCOL_DNS_SD = 1;
    public static final int REGISTER_SERVICE = 0x60009;
    public static final int REGISTER_SERVICE_FAILED = 0x6000a;
    public static final int REGISTER_SERVICE_SUCCEEDED = 0x6000b;
    public static final int RESOLVE_SERVICE = 0x60012;
    public static final int RESOLVE_SERVICE_FAILED = 0x60013;
    public static final int RESOLVE_SERVICE_SUCCEEDED = 0x60014;
    public static final int SERVICE_FOUND = 0x60004;
    public static final int SERVICE_LOST = 0x60005;
    public static final int STOP_DISCOVERY = 0x60006;
    public static final int STOP_DISCOVERY_FAILED = 0x60007;
    public static final int STOP_DISCOVERY_SUCCEEDED = 0x60008;
    private static final String TAG = "NsdManager";
    public static final int UNREGISTER_SERVICE = 0x6000c;
    public static final int UNREGISTER_SERVICE_FAILED = 0x6000d;
    public static final int UNREGISTER_SERVICE_SUCCEEDED = 0x6000e;
    private final AsyncChannel mAsyncChannel = new AsyncChannel();
    private final CountDownLatch mConnected = new CountDownLatch(1);
    private Context mContext;
    private ServiceHandler mHandler;
    private int mListenerKey;
    private final SparseArray mListenerMap = new SparseArray();
    private final Object mMapLock = new Object();
    INsdManager mService;
    private final SparseArray mServiceMap = new SparseArray();





}
