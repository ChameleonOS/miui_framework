// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os.storage;

import android.os.*;
import android.util.Log;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.os.storage:
//            IMountService, StorageVolume, OnObbStateChangeListener, StorageEventListener

public class StorageManager {
    private class ListenerDelegate {

        StorageEventListener getListener() {
            return mStorageEventListener;
        }

        void sendShareAvailabilityChanged(boolean flag) {
            UmsConnectionChangedStorageEvent umsconnectionchangedstorageevent = new UmsConnectionChangedStorageEvent(flag);
            mHandler.sendMessage(umsconnectionchangedstorageevent.getMessage());
        }

        void sendStorageStateChanged(String s, String s1, String s2) {
            StorageStateChangedStorageEvent storagestatechangedstorageevent = new StorageStateChangedStorageEvent(s, s1, s2);
            mHandler.sendMessage(storagestatechangedstorageevent.getMessage());
        }

        private final Handler mHandler;
        final StorageEventListener mStorageEventListener;
        final StorageManager this$0;

        ListenerDelegate(StorageEventListener storageeventlistener) {
            this$0 = StorageManager.this;
            super();
            mStorageEventListener = storageeventlistener;
            mHandler = new Handler(StorageManager.this) {

                public void handleMessage(Message message) {
                    StorageEvent storageevent = (StorageEvent)message.obj;
                    if(message.what == 1) {
                        UmsConnectionChangedStorageEvent umsconnectionchangedstorageevent = (UmsConnectionChangedStorageEvent)storageevent;
                        mStorageEventListener.onUsbMassStorageConnectionChanged(umsconnectionchangedstorageevent.available);
                    } else
                    if(message.what == 2) {
                        StorageStateChangedStorageEvent storagestatechangedstorageevent = (StorageStateChangedStorageEvent)storageevent;
                        mStorageEventListener.onStorageStateChanged(storagestatechangedstorageevent.path, storagestatechangedstorageevent.oldState, storagestatechangedstorageevent.newState);
                    } else {
                        Log.e("StorageManager", (new StringBuilder()).append("Unsupported event ").append(message.what).toString());
                    }
                }

                final ListenerDelegate this$1;
                final StorageManager val$this$0;

                 {
                    this$1 = ListenerDelegate.this;
                    this$0 = storagemanager;
                    super(final_looper);
                }
            };
        }
    }

    private class StorageStateChangedStorageEvent extends StorageEvent {

        public String newState;
        public String oldState;
        public String path;
        final StorageManager this$0;

        public StorageStateChangedStorageEvent(String s, String s1, String s2) {
            this$0 = StorageManager.this;
            super(2);
            path = s;
            oldState = s1;
            newState = s2;
        }
    }

    private class UmsConnectionChangedStorageEvent extends StorageEvent {

        public boolean available;
        final StorageManager this$0;

        public UmsConnectionChangedStorageEvent(boolean flag) {
            this$0 = StorageManager.this;
            super(1);
            available = flag;
        }
    }

    private class StorageEvent {

        public Message getMessage() {
            return mMessage;
        }

        static final int EVENT_OBB_STATE_CHANGED = 3;
        static final int EVENT_STORAGE_STATE_CHANGED = 2;
        static final int EVENT_UMS_CONNECTION_CHANGED = 1;
        private Message mMessage;
        final StorageManager this$0;

        public StorageEvent(int i) {
            this$0 = StorageManager.this;
            super();
            mMessage = Message.obtain();
            mMessage.what = i;
            mMessage.obj = this;
        }
    }

    private class ObbStateChangedStorageEvent extends StorageEvent {

        public final String path;
        public final int state;
        final StorageManager this$0;

        public ObbStateChangedStorageEvent(String s, int i) {
            this$0 = StorageManager.this;
            super(3);
            path = s;
            state = i;
        }
    }

    private class ObbListenerDelegate {

        OnObbStateChangeListener getListener() {
            OnObbStateChangeListener onobbstatechangelistener;
            if(mObbEventListenerRef == null)
                onobbstatechangelistener = null;
            else
                onobbstatechangelistener = (OnObbStateChangeListener)mObbEventListenerRef.get();
            return onobbstatechangelistener;
        }

        void sendObbStateChanged(String s, int i) {
            ObbStateChangedStorageEvent obbstatechangedstorageevent = new ObbStateChangedStorageEvent(s, i);
            mHandler.sendMessage(obbstatechangedstorageevent.getMessage());
        }

        private final Handler mHandler;
        private final WeakReference mObbEventListenerRef;
        private final int nonce;
        final StorageManager this$0;


        ObbListenerDelegate(OnObbStateChangeListener onobbstatechangelistener) {
            this$0 = StorageManager.this;
            super();
            nonce = getNextNonce();
            mObbEventListenerRef = new WeakReference(onobbstatechangelistener);
            mHandler = new Handler(StorageManager.this) {

                public void handleMessage(Message message) {
                    OnObbStateChangeListener onobbstatechangelistener1 = getListener();
                    if(onobbstatechangelistener1 != null) {
                        StorageEvent storageevent = (StorageEvent)message.obj;
                        if(message.what == 3) {
                            ObbStateChangedStorageEvent obbstatechangedstorageevent = (ObbStateChangedStorageEvent)storageevent;
                            onobbstatechangelistener1.onObbStateChange(obbstatechangedstorageevent.path, obbstatechangedstorageevent.state);
                        } else {
                            Log.e("StorageManager", (new StringBuilder()).append("Unsupported event ").append(message.what).toString());
                        }
                    }
                }

                final ObbListenerDelegate this$1;
                final StorageManager val$this$0;

                 {
                    this$1 = ObbListenerDelegate.this;
                    this$0 = storagemanager;
                    super(final_looper);
                }
            };
        }
    }

    private class ObbActionListener extends IObbActionListener.Stub {

        public int addListener(OnObbStateChangeListener onobbstatechangelistener) {
            ObbListenerDelegate obblistenerdelegate = new ObbListenerDelegate(onobbstatechangelistener);
            synchronized(mListeners) {
                mListeners.put(obblistenerdelegate.nonce, obblistenerdelegate);
            }
            return obblistenerdelegate.nonce;
            exception;
            sparsearray;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onObbResult(String s, int i, int j) {
            ObbListenerDelegate obblistenerdelegate;
            synchronized(mListeners) {
                obblistenerdelegate = (ObbListenerDelegate)mListeners.get(i);
                if(obblistenerdelegate != null)
                    mListeners.remove(i);
            }
            if(obblistenerdelegate != null)
                obblistenerdelegate.sendObbStateChanged(s, j);
            return;
            exception;
            sparsearray;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private SparseArray mListeners;
        final StorageManager this$0;

        private ObbActionListener() {
            this$0 = StorageManager.this;
            super();
            mListeners = new SparseArray();
        }

    }

    private class MountServiceBinderListener extends IMountServiceListener.Stub {

        public void onStorageStateChanged(String s, String s1, String s2) {
            int i = mListeners.size();
            for(int j = 0; j < i; j++)
                ((ListenerDelegate)mListeners.get(j)).sendStorageStateChanged(s, s1, s2);

        }

        public void onUsbMassStorageConnectionChanged(boolean flag) {
            int i = mListeners.size();
            for(int j = 0; j < i; j++)
                ((ListenerDelegate)mListeners.get(j)).sendShareAvailabilityChanged(flag);

        }

        final StorageManager this$0;

        private MountServiceBinderListener() {
            this$0 = StorageManager.this;
            super();
        }

    }


    public StorageManager(Looper looper) throws RemoteException {
        mListeners = new ArrayList();
        mMountService = IMountService.Stub.asInterface(ServiceManager.getService("mount"));
        if(mMountService == null) {
            Log.e("StorageManager", "Unable to connect to mount service! - is it running yet?");
        } else {
            mTgtLooper = looper;
            mBinderListener = new MountServiceBinderListener();
            mMountService.registerListener(mBinderListener);
        }
    }

    private int getNextNonce() {
        return mNextNonce.getAndIncrement();
    }

    public void disableUsbMassStorage() {
        mMountService.setUsbMassStorageEnabled(false);
_L1:
        return;
        Exception exception;
        exception;
        Log.e("StorageManager", "Failed to disable UMS", exception);
          goto _L1
    }

    public void enableUsbMassStorage() {
        mMountService.setUsbMassStorageEnabled(true);
_L1:
        return;
        Exception exception;
        exception;
        Log.e("StorageManager", "Failed to enable UMS", exception);
          goto _L1
    }

    public String getMountedObbPath(String s) {
        if(s == null)
            throw new IllegalArgumentException("filename cannot be null");
        String s2 = mMountService.getMountedObbPath(s);
        String s1 = s2;
_L2:
        return s1;
        RemoteException remoteexception;
        remoteexception;
        Log.e("StorageManager", "Failed to find mounted path for OBB", remoteexception);
        s1 = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public StorageVolume[] getVolumeList() {
        if(mMountService != null) goto _L2; else goto _L1
_L1:
        StorageVolume astoragevolume[] = new StorageVolume[0];
_L5:
        return astoragevolume;
_L2:
        android.os.Parcelable aparcelable[];
        int i;
        int j;
        aparcelable = mMountService.getVolumeList();
        if(aparcelable == null) {
            astoragevolume = new StorageVolume[0];
            continue; /* Loop/switch isn't completed */
        }
        i = aparcelable.length;
        astoragevolume = new StorageVolume[i];
        j = 0;
_L3:
        if(j >= i)
            continue; /* Loop/switch isn't completed */
        astoragevolume[j] = (StorageVolume)aparcelable[j];
        j++;
          goto _L3
        RemoteException remoteexception;
        remoteexception;
        Log.e("StorageManager", "Failed to get volume list", remoteexception);
        astoragevolume = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public String[] getVolumePaths() {
        StorageVolume astoragevolume[] = getVolumeList();
        String as[];
        if(astoragevolume == null) {
            as = null;
        } else {
            int i = astoragevolume.length;
            as = new String[i];
            int j = 0;
            while(j < i)  {
                as[j] = astoragevolume[j].getPath();
                j++;
            }
        }
        return as;
    }

    public String getVolumeState(String s) {
        if(mMountService != null) goto _L2; else goto _L1
_L1:
        String s1 = "removed";
_L4:
        return s1;
_L2:
        String s2 = mMountService.getVolumeState(s);
        s1 = s2;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("StorageManager", "Failed to get volume state", remoteexception);
        s1 = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean isObbMounted(String s) {
        if(s == null)
            throw new IllegalArgumentException("filename cannot be null");
        boolean flag1 = mMountService.isObbMounted(s);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("StorageManager", "Failed to check if OBB is mounted", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isUsbMassStorageConnected() {
        boolean flag1 = mMountService.isUsbMassStorageConnected();
        boolean flag = flag1;
_L2:
        return flag;
        Exception exception;
        exception;
        Log.e("StorageManager", "Failed to get UMS connection state", exception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isUsbMassStorageEnabled() {
        boolean flag1 = mMountService.isUsbMassStorageEnabled();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("StorageManager", "Failed to get UMS enable state", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean mountObb(String s, String s1, OnObbStateChangeListener onobbstatechangelistener) {
        if(s == null)
            throw new IllegalArgumentException("filename cannot be null");
        if(onobbstatechangelistener == null)
            throw new IllegalArgumentException("listener cannot be null");
        int i = mObbActionListener.addListener(onobbstatechangelistener);
        mMountService.mountObb(s, s1, mObbActionListener, i);
        boolean flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("StorageManager", "Failed to mount OBB", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void registerListener(StorageEventListener storageeventlistener) {
        if(storageeventlistener != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        List list = mListeners;
        list;
        JVM INSTR monitorenter ;
        mListeners.add(new ListenerDelegate(storageeventlistener));
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean unmountObb(String s, boolean flag, OnObbStateChangeListener onobbstatechangelistener) {
        if(s == null)
            throw new IllegalArgumentException("filename cannot be null");
        if(onobbstatechangelistener == null)
            throw new IllegalArgumentException("listener cannot be null");
        int i = mObbActionListener.addListener(onobbstatechangelistener);
        mMountService.unmountObb(s, flag, mObbActionListener, i);
        boolean flag1 = true;
_L2:
        return flag1;
        RemoteException remoteexception;
        remoteexception;
        Log.e("StorageManager", "Failed to mount OBB", remoteexception);
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void unregisterListener(StorageEventListener storageeventlistener) {
        if(storageeventlistener != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        List list = mListeners;
        list;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = mListeners.size();
        j = 0;
_L7:
        if(j >= i) goto _L4; else goto _L3
_L3:
        if(((ListenerDelegate)mListeners.get(j)).getListener() != storageeventlistener) goto _L6; else goto _L5
_L5:
        mListeners.remove(j);
_L4:
        list;
        JVM INSTR monitorexit ;
          goto _L1
_L6:
        j++;
          goto _L7
    }

    private static final String TAG = "StorageManager";
    private MountServiceBinderListener mBinderListener;
    private List mListeners;
    private IMountService mMountService;
    private final AtomicInteger mNextNonce = new AtomicInteger(0);
    private final ObbActionListener mObbActionListener = new ObbActionListener();
    Looper mTgtLooper;


}
