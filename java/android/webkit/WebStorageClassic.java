// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.os.Handler;
import android.os.Message;
import java.util.*;

// Referenced classes of package android.webkit:
//            WebStorage, ValueCallback

public class WebStorageClassic extends WebStorage {

    WebStorageClassic() {
        mHandler = null;
        mUIHandler = null;
    }

    public static WebStorageClassic getInstance() {
        if(sWebStorage == null)
            sWebStorage = new WebStorageClassic();
        return sWebStorage;
    }

    private static native void nativeDeleteAllData();

    private static native void nativeDeleteOrigin(String s);

    private static native Set nativeGetOrigins();

    private static native long nativeGetQuotaForOrigin(String s);

    private static native long nativeGetUsageForOrigin(String s);

    private static native void nativeSetAppCacheMaximumSize(long l);

    private static native void nativeSetQuotaForOrigin(String s, long l);

    /**
     * @deprecated Method postMessage is deprecated
     */

    private void postMessage(Message message) {
        this;
        JVM INSTR monitorenter ;
        if(mHandler != null)
            mHandler.sendMessage(message);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void postUIMessage(Message message) {
        if(mUIHandler != null)
            mUIHandler.sendMessage(message);
    }

    private void syncValues() {
        Set set = nativeGetOrigins();
        mOrigins = new HashMap();
        String s;
        WebStorage.Origin origin;
        for(Iterator iterator = set.iterator(); iterator.hasNext(); mOrigins.put(s, origin)) {
            s = (String)iterator.next();
            origin = new WebStorage.Origin(s, nativeGetQuotaForOrigin(s), nativeGetUsageForOrigin(s));
        }

    }

    /**
     * @deprecated Method createHandler is deprecated
     */

    public void createHandler() {
        this;
        JVM INSTR monitorenter ;
        if(mHandler == null)
            mHandler = new Handler() {

                public void handleMessage(Message message) {
                    message.what;
                    JVM INSTR tableswitch 0 6: default 48
                //                               0 429
                //                               1 49
                //                               2 74
                //                               3 90
                //                               4 96
                //                               5 178
                //                               6 306;
                       goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
                    return;
_L3:
                    WebStorage.Origin origin2 = (WebStorage.Origin)message.obj;
                    WebStorageClassic.nativeSetQuotaForOrigin(origin2.getOrigin(), origin2.getQuota());
                    continue; /* Loop/switch isn't completed */
_L4:
                    WebStorageClassic.nativeDeleteOrigin(((WebStorage.Origin)message.obj).getOrigin());
                    continue; /* Loop/switch isn't completed */
_L5:
                    WebStorageClassic.nativeDeleteAllData();
                    continue; /* Loop/switch isn't completed */
_L6:
                    syncValues();
                    ValueCallback valuecallback2 = (ValueCallback)message.obj;
                    HashMap hashmap2 = new HashMap(mOrigins);
                    HashMap hashmap3 = new HashMap();
                    hashmap3.put("callback", valuecallback2);
                    hashmap3.put("origins", hashmap2);
                    postUIMessage(Message.obtain(null, 0, hashmap3));
                    continue; /* Loop/switch isn't completed */
_L7:
                    syncValues();
                    Map map1 = (Map)message.obj;
                    String s1 = (String)map1.get("origin");
                    ValueCallback valuecallback1 = (ValueCallback)map1.get("callback");
                    WebStorage.Origin origin1 = (WebStorage.Origin)mOrigins.get(s1);
                    HashMap hashmap1 = new HashMap();
                    hashmap1.put("callback", valuecallback1);
                    if(origin1 != null)
                        hashmap1.put("usage", new Long(origin1.getUsage()));
                    postUIMessage(Message.obtain(null, 1, hashmap1));
                    continue; /* Loop/switch isn't completed */
_L8:
                    syncValues();
                    Map map = (Map)message.obj;
                    String s = (String)map.get("origin");
                    ValueCallback valuecallback = (ValueCallback)map.get("callback");
                    WebStorage.Origin origin = (WebStorage.Origin)mOrigins.get(s);
                    HashMap hashmap = new HashMap();
                    hashmap.put("callback", valuecallback);
                    if(origin != null)
                        hashmap.put("quota", new Long(origin.getQuota()));
                    postUIMessage(Message.obtain(null, 2, hashmap));
                    continue; /* Loop/switch isn't completed */
_L2:
                    syncValues();
                    if(true) goto _L1; else goto _L9
_L9:
                }

                final WebStorageClassic this$0;

             {
                this$0 = WebStorageClassic.this;
                super();
            }
            };
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void createUIHandler() {
        if(mUIHandler == null)
            mUIHandler = new Handler() {

                public void handleMessage(Message message) {
                    message.what;
                    JVM INSTR tableswitch 0 2: default 32
                //                               0 33
                //                               1 78
                //                               2 116;
                       goto _L1 _L2 _L3 _L4
_L1:
                    return;
_L2:
                    Map map2 = (Map)message.obj;
                    Map map3 = (Map)map2.get("origins");
                    ((ValueCallback)map2.get("callback")).onReceiveValue(map3);
                    continue; /* Loop/switch isn't completed */
_L3:
                    Map map1 = (Map)message.obj;
                    ((ValueCallback)map1.get("callback")).onReceiveValue((Long)map1.get("usage"));
                    continue; /* Loop/switch isn't completed */
_L4:
                    Map map = (Map)message.obj;
                    ((ValueCallback)map.get("callback")).onReceiveValue((Long)map.get("quota"));
                    if(true) goto _L1; else goto _L5
_L5:
                }

                final WebStorageClassic this$0;

             {
                this$0 = WebStorageClassic.this;
                super();
            }
            };
    }

    public void deleteAllData() {
        if("WebViewCoreThread".equals(Thread.currentThread().getName()))
            nativeDeleteAllData();
        else
            postMessage(Message.obtain(null, 3));
    }

    public void deleteOrigin(String s) {
        if(s != null)
            if("WebViewCoreThread".equals(Thread.currentThread().getName()))
                nativeDeleteOrigin(s);
            else
                postMessage(Message.obtain(null, 2, new WebStorage.Origin(s)));
    }

    public void getOrigins(ValueCallback valuecallback) {
        if(valuecallback != null)
            if("WebViewCoreThread".equals(Thread.currentThread().getName())) {
                syncValues();
                valuecallback.onReceiveValue(mOrigins);
            } else {
                postMessage(Message.obtain(null, 4, valuecallback));
            }
    }

    Collection getOriginsSync() {
        Collection collection;
        if("WebViewCoreThread".equals(Thread.currentThread().getName())) {
            update();
            collection = mOrigins.values();
        } else {
            collection = null;
        }
        return collection;
    }

    public void getQuotaForOrigin(String s, ValueCallback valuecallback) {
        if(valuecallback != null)
            if(s == null)
                valuecallback.onReceiveValue(null);
            else
            if("WebViewCoreThread".equals(Thread.currentThread().getName())) {
                syncValues();
                valuecallback.onReceiveValue(new Long(((WebStorage.Origin)mOrigins.get(s)).getUsage()));
            } else {
                HashMap hashmap = new HashMap();
                hashmap.put("origin", s);
                hashmap.put("callback", valuecallback);
                postMessage(Message.obtain(null, 6, hashmap));
            }
    }

    public void getUsageForOrigin(String s, ValueCallback valuecallback) {
        if(valuecallback != null)
            if(s == null)
                valuecallback.onReceiveValue(null);
            else
            if("WebViewCoreThread".equals(Thread.currentThread().getName())) {
                syncValues();
                valuecallback.onReceiveValue(new Long(((WebStorage.Origin)mOrigins.get(s)).getUsage()));
            } else {
                HashMap hashmap = new HashMap();
                hashmap.put("origin", s);
                hashmap.put("callback", valuecallback);
                postMessage(Message.obtain(null, 5, hashmap));
            }
    }

    public void setAppCacheMaximumSize(long l) {
        nativeSetAppCacheMaximumSize(l);
    }

    public void setQuotaForOrigin(String s, long l) {
        if(s != null)
            if("WebViewCoreThread".equals(Thread.currentThread().getName()))
                nativeSetQuotaForOrigin(s, l);
            else
                postMessage(Message.obtain(null, 1, new WebStorage.Origin(s, l)));
    }

    public void update() {
        if("WebViewCoreThread".equals(Thread.currentThread().getName()))
            syncValues();
        else
            postMessage(Message.obtain(null, 0));
    }

    private static final String CALLBACK = "callback";
    static final int DELETE_ALL = 3;
    static final int DELETE_ORIGIN = 2;
    static final int GET_ORIGINS = 4;
    static final int GET_QUOTA_ORIGIN = 6;
    static final int GET_USAGE_ORIGIN = 5;
    private static final String ORIGIN = "origin";
    private static final String ORIGINS = "origins";
    private static final String QUOTA = "quota";
    static final int RETURN_ORIGINS = 0;
    static final int RETURN_QUOTA_ORIGIN = 2;
    static final int RETURN_USAGE_ORIGIN = 1;
    static final int SET_QUOTA_ORIGIN = 1;
    static final int UPDATE = 0;
    private static final String USAGE = "usage";
    private static WebStorageClassic sWebStorage;
    private Handler mHandler;
    private Map mOrigins;
    private Handler mUIHandler;






}
