// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accessibilityservice;

import android.os.*;
import android.util.Log;
import android.view.accessibility.*;
import com.android.internal.util.Predicate;
import java.util.List;
import java.util.concurrent.TimeoutException;

// Referenced classes of package android.accessibilityservice:
//            AccessibilityServiceInfo

public class UiTestAutomationBridge {

    public UiTestAutomationBridge() {
        mConnectionId = -1;
    }

    private void ensureValidConnection(int i) {
        if(i == -1)
            throw new IllegalStateException("UiAutomationService not connected. Did you call #register()?");
        else
            return;
    }

    public void connect() {
        Object obj;
        long l;
        if(isConnected())
            throw new IllegalStateException("Already connected.");
        mHandlerThread = new HandlerThread("UiTestAutomationBridge");
        mHandlerThread.setDaemon(true);
        mHandlerThread.start();
        mListener = new AccessibilityService.IAccessibilityServiceClientWrapper(null, mHandlerThread.getLooper(), new AccessibilityService.Callbacks() {

            public void onAccessibilityEvent(AccessibilityEvent accessibilityevent) {
                Object obj1 = mLock;
                obj1;
                JVM INSTR monitorenter ;
_L6:
                mLastEvent = AccessibilityEvent.obtain(accessibilityevent);
                if(mWaitingForEventDelivery) goto _L2; else goto _L1
_L1:
                mLock.notifyAll();
_L4:
                UiTestAutomationBridge.this.onAccessibilityEvent(accessibilityevent);
                return;
_L2:
                Exception exception1;
                if(mUnprocessedEventAvailable)
                    break MISSING_BLOCK_LABEL_90;
                mUnprocessedEventAvailable = true;
                mLock.notifyAll();
                if(true) goto _L4; else goto _L3
_L3:
                JVM INSTR monitorexit ;
                throw exception1;
                try {
                    mLock.wait();
                }
                catch(InterruptedException interruptedexception1) { }
                finally {
                    obj1;
                }
                if(true) goto _L6; else goto _L5
_L5:
            }

            public boolean onGesture(int i) {
                return false;
            }

            public void onInterrupt() {
                UiTestAutomationBridge.this.onInterrupt();
            }

            public void onServiceConnected() {
            }

            public void onSetConnectionId(int i) {
                Object obj1 = mLock;
                obj1;
                JVM INSTR monitorenter ;
                mConnectionId = i;
                mLock.notifyAll();
                return;
            }

            final UiTestAutomationBridge this$0;

             {
                this$0 = UiTestAutomationBridge.this;
                super();
            }
        });
        IAccessibilityManager iaccessibilitymanager = android.view.accessibility.IAccessibilityManager.Stub.asInterface(ServiceManager.getService("accessibility"));
        AccessibilityServiceInfo accessibilityserviceinfo = new AccessibilityServiceInfo();
        accessibilityserviceinfo.eventTypes = -1;
        accessibilityserviceinfo.feedbackType = 16;
        accessibilityserviceinfo.flags = 2 | accessibilityserviceinfo.flags;
        try {
            iaccessibilitymanager.registerUiTestAutomationService(mListener, accessibilityserviceinfo);
        }
        catch(RemoteException remoteexception) {
            throw new IllegalStateException("Cound not register UiAutomationService.", remoteexception);
        }
        obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        l = SystemClock.uptimeMillis();
_L1:
        if(isConnected())
            return;
        Exception exception;
        long l1;
        l1 = 5000L - (SystemClock.uptimeMillis() - l);
        if(l1 <= 0L)
            throw new IllegalStateException("Cound not register UiAutomationService.");
        if(true)
            break MISSING_BLOCK_LABEL_196;
        JVM INSTR monitorexit ;
        throw exception;
        try {
            mLock.wait(l1);
        }
        catch(InterruptedException interruptedexception) { }
        finally {
            obj;
        }
          goto _L1
    }

    public void disconnect() {
        IAccessibilityManager iaccessibilitymanager;
        if(!isConnected())
            throw new IllegalStateException("Already disconnected.");
        mHandlerThread.quit();
        iaccessibilitymanager = android.view.accessibility.IAccessibilityManager.Stub.asInterface(ServiceManager.getService("accessibility"));
        iaccessibilitymanager.unregisterUiTestAutomationService(mListener);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e(LOG_TAG, "Error while unregistering UiTestAutomationService", remoteexception);
          goto _L1
    }

    public AccessibilityEvent executeCommandAndWaitForAccessibilityEvent(Runnable runnable, Predicate predicate, long l) throws TimeoutException, Exception {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        long l1;
        mWaitingForEventDelivery = true;
        mUnprocessedEventAvailable = false;
        if(mLastEvent != null) {
            mLastEvent.recycle();
            mLastEvent = null;
        }
        runnable.run();
        l1 = SystemClock.uptimeMillis();
_L2:
        Exception exception;
        long l2;
        if(mUnprocessedEventAvailable && predicate.apply(mLastEvent)) {
            mWaitingForEventDelivery = false;
            mUnprocessedEventAvailable = false;
            mLock.notifyAll();
            AccessibilityEvent accessibilityevent = mLastEvent;
            return accessibilityevent;
        }
        mWaitingForEventDelivery = true;
        mUnprocessedEventAvailable = false;
        mLock.notifyAll();
        l2 = l - (SystemClock.uptimeMillis() - l1);
        if(l2 <= 0L) {
            mWaitingForEventDelivery = false;
            mUnprocessedEventAvailable = false;
            mLock.notifyAll();
            throw new TimeoutException((new StringBuilder()).append("Expacted event not received within: ").append(l).append(" ms.").toString());
        }
        if(true)
            break MISSING_BLOCK_LABEL_189;
        JVM INSTR monitorexit ;
        throw exception;
        try {
            mLock.wait(l2);
        }
        catch(InterruptedException interruptedexception) { }
        finally {
            obj;
        }
        if(true) goto _L2; else goto _L1
_L1:
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfoByAccessibilityId(int i, long l) {
        ensureValidConnection(mConnectionId);
        return AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfoByAccessibilityId(mConnectionId, i, l, 7);
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfoByAccessibilityIdInActiveWindow(long l) {
        return findAccessibilityNodeInfoByAccessibilityId(-1, l);
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfoByViewId(int i, long l, int j) {
        int k = mConnectionId;
        ensureValidConnection(k);
        return AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfoByViewId(k, i, l, j);
    }

    public AccessibilityNodeInfo findAccessibilityNodeInfoByViewIdInActiveWindow(int i) {
        return findAccessibilityNodeInfoByViewId(-1, ROOT_NODE_ID, i);
    }

    public List findAccessibilityNodeInfosByText(int i, long l, String s) {
        int j = mConnectionId;
        ensureValidConnection(j);
        return AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfosByText(j, i, l, s);
    }

    public List findAccessibilityNodeInfosByTextInActiveWindow(String s) {
        return findAccessibilityNodeInfosByText(-1, ROOT_NODE_ID, s);
    }

    public AccessibilityEvent getLastAccessibilityEvent() {
        return mLastEvent;
    }

    public AccessibilityNodeInfo getRootAccessibilityNodeInfoInActiveWindow() {
        int i = mConnectionId;
        ensureValidConnection(i);
        return AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfoByAccessibilityId(i, -1, ROOT_NODE_ID, 4);
    }

    public boolean isConnected() {
        boolean flag;
        if(mConnectionId != -1)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityevent) {
    }

    public void onInterrupt() {
    }

    public boolean performAccessibilityAction(int i, long l, int j, Bundle bundle) {
        int k = mConnectionId;
        ensureValidConnection(k);
        return AccessibilityInteractionClient.getInstance().performAccessibilityAction(k, i, l, j, bundle);
    }

    public boolean performAccessibilityActionInActiveWindow(long l, int i, Bundle bundle) {
        return performAccessibilityAction(-1, l, i, bundle);
    }

    public void waitForIdle(long l, long l1) {
        long l2;
        long l3;
        Object obj;
        l2 = SystemClock.uptimeMillis();
        if(mLastEvent != null)
            l3 = mLastEvent.getEventTime();
        else
            l3 = SystemClock.uptimeMillis();
        obj = mLock;
        obj;
        JVM INSTR monitorenter ;
_L5:
        if(SystemClock.uptimeMillis() - l3 <= l) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Exception exception;
        if(mLastEvent != null)
            l3 = mLastEvent.getEventTime();
        if(l1 - (SystemClock.uptimeMillis() - l2) > 0L)
            break MISSING_BLOCK_LABEL_96;
        if(true) goto _L1; else goto _L3
_L3:
        JVM INSTR monitorexit ;
        throw exception;
        try {
            mLock.wait(l);
        }
        catch(InterruptedException interruptedexception) { }
        finally {
            obj;
        }
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static final int ACTIVE_WINDOW_ID = -1;
    private static final int FIND_ACCESSIBILITY_NODE_INFO_PREFETCH_FLAGS = 7;
    private static final String LOG_TAG = android/accessibilityservice/UiTestAutomationBridge.getSimpleName();
    public static final long ROOT_NODE_ID = 0L;
    private static final int TIMEOUT_REGISTER_SERVICE = 5000;
    public static final int UNDEFINED = -1;
    private volatile int mConnectionId;
    private HandlerThread mHandlerThread;
    private AccessibilityEvent mLastEvent;
    private AccessibilityService.IAccessibilityServiceClientWrapper mListener;
    private final Object mLock = new Object();
    private volatile boolean mUnprocessedEventAvailable;
    private volatile boolean mWaitingForEventDelivery;

    static  {
        ROOT_NODE_ID = AccessibilityNodeInfo.ROOT_NODE_ID;
    }



/*
    static AccessibilityEvent access$102(UiTestAutomationBridge uitestautomationbridge, AccessibilityEvent accessibilityevent) {
        uitestautomationbridge.mLastEvent = accessibilityevent;
        return accessibilityevent;
    }

*/




/*
    static boolean access$302(UiTestAutomationBridge uitestautomationbridge, boolean flag) {
        uitestautomationbridge.mUnprocessedEventAvailable = flag;
        return flag;
    }

*/


/*
    static int access$402(UiTestAutomationBridge uitestautomationbridge, int i) {
        uitestautomationbridge.mConnectionId = i;
        return i;
    }

*/
}
