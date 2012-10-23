// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accessibilityservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.*;
import android.util.Log;
import android.view.accessibility.*;
import com.android.internal.os.HandlerCaller;

// Referenced classes of package android.accessibilityservice:
//            IAccessibilityServiceConnection, AccessibilityServiceInfo

public abstract class AccessibilityService extends Service {
    static class IAccessibilityServiceClientWrapper extends IAccessibilityServiceClient.Stub
        implements com.android.internal.os.HandlerCaller.Callback {

        public void executeMessage(Message message) {
            message.what;
            JVM INSTR lookupswitch 4: default 48
        //                       10: 130
        //                       20: 118
        //                       30: 77
        //                       40: 205;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            Log.w("AccessibilityService", (new StringBuilder()).append("Unknown message type ").append(message.what).toString());
_L7:
            return;
_L4:
            AccessibilityEvent accessibilityevent = (AccessibilityEvent)message.obj;
            if(accessibilityevent != null) {
                AccessibilityInteractionClient.getInstance().onAccessibilityEvent(accessibilityevent);
                mCallback.onAccessibilityEvent(accessibilityevent);
                accessibilityevent.recycle();
            }
            continue; /* Loop/switch isn't completed */
_L3:
            mCallback.onInterrupt();
            continue; /* Loop/switch isn't completed */
_L2:
            int j = message.arg1;
            IAccessibilityServiceConnection iaccessibilityserviceconnection = (IAccessibilityServiceConnection)message.obj;
            if(iaccessibilityserviceconnection != null) {
                AccessibilityInteractionClient.getInstance().addConnection(j, iaccessibilityserviceconnection);
                mCallback.onSetConnectionId(j);
                mCallback.onServiceConnected();
            } else {
                AccessibilityInteractionClient.getInstance().removeConnection(j);
                mCallback.onSetConnectionId(-1);
            }
            continue; /* Loop/switch isn't completed */
_L5:
            int i = message.arg1;
            mCallback.onGesture(i);
            if(true) goto _L7; else goto _L6
_L6:
        }

        public void onAccessibilityEvent(AccessibilityEvent accessibilityevent) {
            Message message = mCaller.obtainMessageO(30, accessibilityevent);
            mCaller.sendMessage(message);
        }

        public void onGesture(int i) {
            Message message = mCaller.obtainMessageI(40, i);
            mCaller.sendMessage(message);
        }

        public void onInterrupt() {
            Message message = mCaller.obtainMessage(20);
            mCaller.sendMessage(message);
        }

        public void setConnection(IAccessibilityServiceConnection iaccessibilityserviceconnection, int i) {
            Message message = mCaller.obtainMessageIO(10, i, iaccessibilityserviceconnection);
            mCaller.sendMessage(message);
        }

        private static final int DO_ON_ACCESSIBILITY_EVENT = 30;
        private static final int DO_ON_GESTURE = 40;
        private static final int DO_ON_INTERRUPT = 20;
        private static final int DO_SET_SET_CONNECTION = 10;
        static final int NO_ID = -1;
        private final Callbacks mCallback;
        private final HandlerCaller mCaller;

        public IAccessibilityServiceClientWrapper(Context context, Looper looper, Callbacks callbacks) {
            mCallback = callbacks;
            mCaller = new HandlerCaller(context, looper, this);
        }
    }

    static interface Callbacks {

        public abstract void onAccessibilityEvent(AccessibilityEvent accessibilityevent);

        public abstract boolean onGesture(int i);

        public abstract void onInterrupt();

        public abstract void onServiceConnected();

        public abstract void onSetConnectionId(int i);
    }


    public AccessibilityService() {
    }

    private void sendServiceInfo() {
        IAccessibilityServiceConnection iaccessibilityserviceconnection;
        iaccessibilityserviceconnection = AccessibilityInteractionClient.getInstance().getConnection(mConnectionId);
        if(mInfo == null || iaccessibilityserviceconnection == null)
            break MISSING_BLOCK_LABEL_43;
        iaccessibilityserviceconnection.setServiceInfo(mInfo);
        mInfo = null;
        AccessibilityInteractionClient.getInstance().clearCache();
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.w("AccessibilityService", "Error while setting AccessibilityServiceInfo", remoteexception);
          goto _L1
    }

    public AccessibilityNodeInfo getRootInActiveWindow() {
        return AccessibilityInteractionClient.getInstance().getRootInActiveWindow(mConnectionId);
    }

    public final AccessibilityServiceInfo getServiceInfo() {
        IAccessibilityServiceConnection iaccessibilityserviceconnection = AccessibilityInteractionClient.getInstance().getConnection(mConnectionId);
        if(iaccessibilityserviceconnection == null) goto _L2; else goto _L1
_L1:
        AccessibilityServiceInfo accessibilityserviceinfo1 = iaccessibilityserviceconnection.getServiceInfo();
        AccessibilityServiceInfo accessibilityserviceinfo = accessibilityserviceinfo1;
_L4:
        return accessibilityserviceinfo;
        RemoteException remoteexception;
        remoteexception;
        Log.w("AccessibilityService", "Error while getting AccessibilityServiceInfo", remoteexception);
_L2:
        accessibilityserviceinfo = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public abstract void onAccessibilityEvent(AccessibilityEvent accessibilityevent);

    public final IBinder onBind(Intent intent) {
        return new IAccessibilityServiceClientWrapper(this, getMainLooper(), new Callbacks() {

            public void onAccessibilityEvent(AccessibilityEvent accessibilityevent) {
                AccessibilityService.this.onAccessibilityEvent(accessibilityevent);
            }

            public boolean onGesture(int i) {
                return AccessibilityService.this.onGesture(i);
            }

            public void onInterrupt() {
                AccessibilityService.this.onInterrupt();
            }

            public void onServiceConnected() {
                AccessibilityService.this.onServiceConnected();
            }

            public void onSetConnectionId(int i) {
                mConnectionId = i;
            }

            final AccessibilityService this$0;

             {
                this$0 = AccessibilityService.this;
                super();
            }
        });
    }

    protected boolean onGesture(int i) {
        return false;
    }

    public abstract void onInterrupt();

    protected void onServiceConnected() {
    }

    public final boolean performGlobalAction(int i) {
        IAccessibilityServiceConnection iaccessibilityserviceconnection = AccessibilityInteractionClient.getInstance().getConnection(mConnectionId);
        if(iaccessibilityserviceconnection == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = iaccessibilityserviceconnection.performGlobalAction(i);
        boolean flag = flag1;
_L4:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.w("AccessibilityService", "Error while calling performGlobalAction", remoteexception);
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final void setServiceInfo(AccessibilityServiceInfo accessibilityserviceinfo) {
        mInfo = accessibilityserviceinfo;
        sendServiceInfo();
    }

    public static final int GESTURE_SWIPE_DOWN = 2;
    public static final int GESTURE_SWIPE_DOWN_AND_LEFT = 15;
    public static final int GESTURE_SWIPE_DOWN_AND_RIGHT = 16;
    public static final int GESTURE_SWIPE_DOWN_AND_UP = 8;
    public static final int GESTURE_SWIPE_LEFT = 3;
    public static final int GESTURE_SWIPE_LEFT_AND_DOWN = 10;
    public static final int GESTURE_SWIPE_LEFT_AND_RIGHT = 5;
    public static final int GESTURE_SWIPE_LEFT_AND_UP = 9;
    public static final int GESTURE_SWIPE_RIGHT = 4;
    public static final int GESTURE_SWIPE_RIGHT_AND_DOWN = 12;
    public static final int GESTURE_SWIPE_RIGHT_AND_LEFT = 6;
    public static final int GESTURE_SWIPE_RIGHT_AND_UP = 11;
    public static final int GESTURE_SWIPE_UP = 1;
    public static final int GESTURE_SWIPE_UP_AND_DOWN = 7;
    public static final int GESTURE_SWIPE_UP_AND_LEFT = 13;
    public static final int GESTURE_SWIPE_UP_AND_RIGHT = 14;
    public static final int GLOBAL_ACTION_BACK = 1;
    public static final int GLOBAL_ACTION_HOME = 2;
    public static final int GLOBAL_ACTION_NOTIFICATIONS = 4;
    public static final int GLOBAL_ACTION_RECENTS = 3;
    private static final String LOG_TAG = "AccessibilityService";
    public static final String SERVICE_INTERFACE = "android.accessibilityservice.AccessibilityService";
    public static final String SERVICE_META_DATA = "android.accessibilityservice";
    private int mConnectionId;
    private AccessibilityServiceInfo mInfo;


/*
    static int access$002(AccessibilityService accessibilityservice, int i) {
        accessibilityservice.mConnectionId = i;
        return i;
    }

*/
}
