// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.os.*;
import android.util.Log;
import android.view.IWindow;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package android.view.accessibility:
//            IAccessibilityManager, IAccessibilityManagerClient, AccessibilityEvent, IAccessibilityInteractionConnection

public final class AccessibilityManager {
    class MyHandler extends Handler {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 10 10: default 24
        //                       10 53;
               goto _L1 _L2
_L1:
            Log.w("AccessibilityManager", (new StringBuilder()).append("Unknown message type: ").append(message.what).toString());
_L4:
            return;
_L2:
            setState(message.arg1);
            if(true) goto _L4; else goto _L3
_L3:
        }

        final AccessibilityManager this$0;

        MyHandler(Looper looper) {
            this$0 = AccessibilityManager.this;
            super(looper);
        }
    }

    public static interface AccessibilityStateChangeListener {

        public abstract void onAccessibilityStateChanged(boolean flag);
    }


    public AccessibilityManager(Context context, IAccessibilityManager iaccessibilitymanager) {
        mAccessibilityStateChangeListeners = new CopyOnWriteArrayList();
        mClient = new IAccessibilityManagerClient.Stub() {

            public void setState(int i) {
                mHandler.obtainMessage(10, i, 0).sendToTarget();
            }

            final AccessibilityManager this$0;

             {
                this$0 = AccessibilityManager.this;
                super();
            }
        };
        mHandler = new MyHandler(context.getMainLooper());
        mService = iaccessibilitymanager;
        setState(mService.addClient(mClient));
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("AccessibilityManager", "AccessibilityManagerService is dead", remoteexception);
          goto _L1
    }

    public static AccessibilityManager getInstance(Context context) {
        synchronized(sInstanceSync) {
            if(sInstance == null)
                sInstance = new AccessibilityManager(context, IAccessibilityManager.Stub.asInterface(ServiceManager.getService("accessibility")));
        }
        return sInstance;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void notifyAccessibilityStateChanged() {
        int i = mAccessibilityStateChangeListeners.size();
        for(int j = 0; j < i; j++)
            ((AccessibilityStateChangeListener)mAccessibilityStateChangeListeners.get(j)).onAccessibilityStateChanged(mIsEnabled);

    }

    private void setAccessibilityState(boolean flag) {
        Handler handler = mHandler;
        handler;
        JVM INSTR monitorenter ;
        if(flag != mIsEnabled) {
            mIsEnabled = flag;
            notifyAccessibilityStateChanged();
        }
        return;
    }

    private void setState(int i) {
        boolean flag = true;
        boolean flag1;
        if((i & 1) != 0)
            flag1 = flag;
        else
            flag1 = false;
        setAccessibilityState(flag1);
        if((i & 2) == 0)
            flag = false;
        mIsTouchExplorationEnabled = flag;
    }

    public int addAccessibilityInteractionConnection(IWindow iwindow, IAccessibilityInteractionConnection iaccessibilityinteractionconnection) {
        int j = mService.addAccessibilityInteractionConnection(iwindow, iaccessibilityinteractionconnection);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("AccessibilityManager", "Error while adding an accessibility interaction connection. ", remoteexception);
        i = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean addAccessibilityStateChangeListener(AccessibilityStateChangeListener accessibilitystatechangelistener) {
        return mAccessibilityStateChangeListeners.add(accessibilitystatechangelistener);
    }

    public List getAccessibilityServiceList() {
        List list = getInstalledAccessibilityServiceList();
        ArrayList arraylist = new ArrayList();
        int i = list.size();
        for(int j = 0; j < i; j++)
            arraylist.add(((AccessibilityServiceInfo)list.get(j)).getResolveInfo().serviceInfo);

        return Collections.unmodifiableList(arraylist);
    }

    public IAccessibilityManagerClient getClient() {
        return (IAccessibilityManagerClient)mClient.asBinder();
    }

    public List getEnabledAccessibilityServiceList(int i) {
        List list = null;
        List list1 = mService.getEnabledAccessibilityServiceList(i);
        list = list1;
_L2:
        return Collections.unmodifiableList(list);
        RemoteException remoteexception;
        remoteexception;
        Log.e("AccessibilityManager", "Error while obtaining the installed AccessibilityServices. ", remoteexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public List getInstalledAccessibilityServiceList() {
        List list = null;
        List list1 = mService.getInstalledAccessibilityServiceList();
        list = list1;
_L2:
        return Collections.unmodifiableList(list);
        RemoteException remoteexception;
        remoteexception;
        Log.e("AccessibilityManager", "Error while obtaining the installed AccessibilityServices. ", remoteexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void interrupt() {
        if(!mIsEnabled)
            throw new IllegalStateException("Accessibility off. Did you forget to check that?");
        mService.interrupt();
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("AccessibilityManager", "Error while requesting interrupt from all services. ", remoteexception);
          goto _L1
    }

    public boolean isEnabled() {
        Handler handler = mHandler;
        handler;
        JVM INSTR monitorenter ;
        boolean flag = mIsEnabled;
        return flag;
    }

    public boolean isTouchExplorationEnabled() {
        Handler handler = mHandler;
        handler;
        JVM INSTR monitorenter ;
        boolean flag = mIsTouchExplorationEnabled;
        return flag;
    }

    public void removeAccessibilityInteractionConnection(IWindow iwindow) {
        mService.removeAccessibilityInteractionConnection(iwindow);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("AccessibilityManager", "Error while removing an accessibility interaction connection. ", remoteexception);
          goto _L1
    }

    public boolean removeAccessibilityStateChangeListener(AccessibilityStateChangeListener accessibilitystatechangelistener) {
        return mAccessibilityStateChangeListeners.remove(accessibilitystatechangelistener);
    }

    public void sendAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        boolean flag;
        if(!mIsEnabled)
            throw new IllegalStateException("Accessibility off. Did you forget to check that?");
        flag = false;
        accessibilityevent.setEventTime(SystemClock.uptimeMillis());
        long l = Binder.clearCallingIdentity();
        flag = mService.sendAccessibilityEvent(accessibilityevent);
        Binder.restoreCallingIdentity(l);
        if(!flag) goto _L2; else goto _L1
_L1:
        accessibilityevent.recycle();
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("AccessibilityManager", (new StringBuilder()).append("Error during sending ").append(accessibilityevent).append(" ").toString(), remoteexception);
        if(!flag) goto _L2; else goto _L1
        Exception exception;
        exception;
        if(flag)
            accessibilityevent.recycle();
        throw exception;
    }

    private static final boolean DEBUG = false;
    private static final int DO_SET_STATE = 10;
    private static final String LOG_TAG = "AccessibilityManager";
    public static final int STATE_FLAG_ACCESSIBILITY_ENABLED = 1;
    public static final int STATE_FLAG_TOUCH_EXPLORATION_ENABLED = 2;
    private static AccessibilityManager sInstance;
    static final Object sInstanceSync = new Object();
    final CopyOnWriteArrayList mAccessibilityStateChangeListeners;
    final IAccessibilityManagerClient.Stub mClient;
    final Handler mHandler;
    boolean mIsEnabled;
    boolean mIsTouchExplorationEnabled;
    final IAccessibilityManager mService;


}
