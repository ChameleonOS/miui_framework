// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.os.Handler;
import android.os.Message;
import java.util.*;

// Referenced classes of package android.webkit:
//            GeolocationPermissions, ValueCallback

final class GeolocationPermissionsClassic extends GeolocationPermissions {

    GeolocationPermissionsClassic() {
    }

    public static GeolocationPermissionsClassic getInstance() {
        if(sInstance == null)
            sInstance = new GeolocationPermissionsClassic();
        return sInstance;
    }

    private static native void nativeAllow(String s);

    private static native void nativeClear(String s);

    private static native void nativeClearAll();

    private static native boolean nativeGetAllowed(String s);

    private static native Set nativeGetOrigins();

    /**
     * @deprecated Method postMessage is deprecated
     */

    private void postMessage(Message message) {
        this;
        JVM INSTR monitorenter ;
        if(mHandler != null) goto _L2; else goto _L1
_L1:
        if(mQueuedMessages == null)
            mQueuedMessages = new Vector();
        mQueuedMessages.add(message);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mHandler.sendMessage(message);
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void postUIMessage(Message message) {
        if(mUIHandler != null)
            mUIHandler.sendMessage(message);
    }

    public void allow(String s) {
        postMessage(Message.obtain(null, 3, s));
    }

    public void clear(String s) {
        postMessage(Message.obtain(null, 2, s));
    }

    public void clearAll() {
        postMessage(Message.obtain(null, 4));
    }

    /**
     * @deprecated Method createHandler is deprecated
     */

    public void createHandler() {
        this;
        JVM INSTR monitorenter ;
        if(mHandler != null)
            break MISSING_BLOCK_LABEL_70;
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                message.what;
                JVM INSTR tableswitch 0 4: default 40
            //                           0 41
            //                           1 105
            //                           2 197
            //                           3 210
            //                           4 223;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
                return;
_L2:
                Set set = GeolocationPermissionsClassic.nativeGetOrigins();
                ValueCallback valuecallback1 = (ValueCallback)message.obj;
                HashMap hashmap1 = new HashMap();
                hashmap1.put("callback", valuecallback1);
                hashmap1.put("origins", set);
                postUIMessage(Message.obtain(null, 0, hashmap1));
                continue; /* Loop/switch isn't completed */
_L3:
                Map map = (Map)message.obj;
                String s = (String)map.get("origin");
                ValueCallback valuecallback = (ValueCallback)map.get("callback");
                boolean flag = GeolocationPermissionsClassic.nativeGetAllowed(s);
                HashMap hashmap = new HashMap();
                hashmap.put("callback", valuecallback);
                hashmap.put("allowed", Boolean.valueOf(flag));
                postUIMessage(Message.obtain(null, 1, hashmap));
                continue; /* Loop/switch isn't completed */
_L4:
                GeolocationPermissionsClassic.nativeClear((String)message.obj);
                continue; /* Loop/switch isn't completed */
_L5:
                GeolocationPermissionsClassic.nativeAllow((String)message.obj);
                continue; /* Loop/switch isn't completed */
_L6:
                GeolocationPermissionsClassic.nativeClearAll();
                if(true) goto _L1; else goto _L7
_L7:
            }

            final GeolocationPermissionsClassic this$0;

             {
                this$0 = GeolocationPermissionsClassic.this;
                super();
            }
        };
        if(mQueuedMessages == null)
            break MISSING_BLOCK_LABEL_70;
        for(; !mQueuedMessages.isEmpty(); mHandler.sendMessage((Message)mQueuedMessages.remove(0)));
        break MISSING_BLOCK_LABEL_65;
        Exception exception;
        exception;
        throw exception;
        mQueuedMessages = null;
        this;
        JVM INSTR monitorexit ;
    }

    public void createUIHandler() {
        if(mUIHandler == null)
            mUIHandler = new Handler() {

                public void handleMessage(Message message) {
                    message.what;
                    JVM INSTR tableswitch 0 1: default 28
                //                               0 29
                //                               1 74;
                       goto _L1 _L2 _L3
_L1:
                    return;
_L2:
                    Map map1 = (Map)message.obj;
                    Set set = (Set)map1.get("origins");
                    ((ValueCallback)map1.get("callback")).onReceiveValue(set);
                    continue; /* Loop/switch isn't completed */
_L3:
                    Map map = (Map)message.obj;
                    Boolean boolean1 = (Boolean)map.get("allowed");
                    ((ValueCallback)map.get("callback")).onReceiveValue(boolean1);
                    if(true) goto _L1; else goto _L4
_L4:
                }

                final GeolocationPermissionsClassic this$0;

             {
                this$0 = GeolocationPermissionsClassic.this;
                super();
            }
            };
    }

    public void getAllowed(String s, ValueCallback valuecallback) {
        if(valuecallback != null)
            if(s == null)
                valuecallback.onReceiveValue(null);
            else
            if("WebViewCoreThread".equals(Thread.currentThread().getName())) {
                valuecallback.onReceiveValue(Boolean.valueOf(nativeGetAllowed(s)));
            } else {
                HashMap hashmap = new HashMap();
                hashmap.put("origin", s);
                hashmap.put("callback", valuecallback);
                postMessage(Message.obtain(null, 1, hashmap));
            }
    }

    public void getOrigins(ValueCallback valuecallback) {
        if(valuecallback != null)
            if("WebViewCoreThread".equals(Thread.currentThread().getName()))
                valuecallback.onReceiveValue(nativeGetOrigins());
            else
                postMessage(Message.obtain(null, 0, valuecallback));
    }

    static final int ALLOW = 3;
    private static final String ALLOWED = "allowed";
    private static final String CALLBACK = "callback";
    static final int CLEAR = 2;
    static final int CLEAR_ALL = 4;
    static final int GET_ALLOWED = 1;
    static final int GET_ORIGINS = 0;
    private static final String ORIGIN = "origin";
    private static final String ORIGINS = "origins";
    static final int RETURN_ALLOWED = 1;
    static final int RETURN_ORIGINS;
    private static GeolocationPermissionsClassic sInstance;
    private Handler mHandler;
    private Vector mQueuedMessages;
    private Handler mUIHandler;






}
