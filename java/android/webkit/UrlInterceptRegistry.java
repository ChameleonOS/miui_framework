// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import java.util.*;

// Referenced classes of package android.webkit:
//            UrlInterceptHandler, PluginData

public final class UrlInterceptRegistry {

    public UrlInterceptRegistry() {
    }

    /**
     * @deprecated Method getHandlers is deprecated
     */

    private static LinkedList getHandlers() {
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorenter ;
        LinkedList linkedlist;
        if(mHandlerList == null)
            mHandlerList = new LinkedList();
        linkedlist = mHandlerList;
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorexit ;
        return linkedlist;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getPluginData is deprecated
     */

    public static PluginData getPluginData(String s, Map map) {
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorenter ;
        boolean flag = urlInterceptDisabled();
        if(!flag) goto _L2; else goto _L1
_L1:
        PluginData plugindata = null;
_L5:
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorexit ;
        return plugindata;
_L2:
        java.util.ListIterator listiterator = getHandlers().listIterator();
_L3:
        PluginData plugindata1;
        if(!listiterator.hasNext())
            break MISSING_BLOCK_LABEL_69;
        plugindata1 = ((UrlInterceptHandler)listiterator.next()).getPluginData(s, map);
        plugindata = plugindata1;
        if(plugindata != null)
            continue; /* Loop/switch isn't completed */
          goto _L3
        plugindata = null;
        if(true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getSurrogate is deprecated
     */

    public static CacheManager.CacheResult getSurrogate(String s, Map map) {
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorenter ;
        boolean flag = urlInterceptDisabled();
        if(!flag) goto _L2; else goto _L1
_L1:
        CacheManager.CacheResult cacheresult = null;
_L5:
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorexit ;
        return cacheresult;
_L2:
        java.util.ListIterator listiterator = getHandlers().listIterator();
_L3:
        CacheManager.CacheResult cacheresult1;
        if(!listiterator.hasNext())
            break MISSING_BLOCK_LABEL_69;
        cacheresult1 = ((UrlInterceptHandler)listiterator.next()).service(s, map);
        cacheresult = cacheresult1;
        if(cacheresult != null)
            continue; /* Loop/switch isn't completed */
          goto _L3
        cacheresult = null;
        if(true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method registerHandler is deprecated
     */

    public static boolean registerHandler(UrlInterceptHandler urlintercepthandler) {
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorenter ;
        if(getHandlers().contains(urlintercepthandler)) goto _L2; else goto _L1
_L1:
        getHandlers().addFirst(urlintercepthandler);
        boolean flag = true;
_L4:
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setUrlInterceptDisabled is deprecated
     */

    public static void setUrlInterceptDisabled(boolean flag) {
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorenter ;
        mDisabled = flag;
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method unregisterHandler is deprecated
     */

    public static boolean unregisterHandler(UrlInterceptHandler urlintercepthandler) {
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorenter ;
        boolean flag = getHandlers().remove(urlintercepthandler);
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method urlInterceptDisabled is deprecated
     */

    public static boolean urlInterceptDisabled() {
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorenter ;
        boolean flag = mDisabled;
        android/webkit/UrlInterceptRegistry;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    private static final String LOGTAG = "intercept";
    private static boolean mDisabled = false;
    private static LinkedList mHandlerList;

}
