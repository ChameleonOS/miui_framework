// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;

// Referenced classes of package android.webkit:
//            WebSyncManager, JniUtil, CookieManager

public final class CookieSyncManager extends WebSyncManager {

    private CookieSyncManager(Context context) {
        super(context, "CookieSyncManager");
    }

    private static void checkInstanceIsCreated() {
        if(sRef == null)
            throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        else
            return;
    }

    /**
     * @deprecated Method createInstance is deprecated
     */

    public static CookieSyncManager createInstance(Context context) {
        android/webkit/CookieSyncManager;
        JVM INSTR monitorenter ;
        if(context != null)
            break MISSING_BLOCK_LABEL_23;
        throw new IllegalArgumentException("Invalid context argument");
        Exception exception;
        exception;
        android/webkit/CookieSyncManager;
        JVM INSTR monitorexit ;
        throw exception;
        CookieSyncManager cookiesyncmanager;
        JniUtil.setContext(context);
        Context context1 = context.getApplicationContext();
        if(sRef == null)
            sRef = new CookieSyncManager(context1);
        cookiesyncmanager = sRef;
        android/webkit/CookieSyncManager;
        JVM INSTR monitorexit ;
        return cookiesyncmanager;
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static CookieSyncManager getInstance() {
        android/webkit/CookieSyncManager;
        JVM INSTR monitorenter ;
        CookieSyncManager cookiesyncmanager;
        checkInstanceIsCreated();
        cookiesyncmanager = sRef;
        android/webkit/CookieSyncManager;
        JVM INSTR monitorexit ;
        return cookiesyncmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile void resetSync() {
        super.resetSync();
    }

    public volatile void run() {
        super.run();
    }

    public volatile void startSync() {
        super.startSync();
    }

    public volatile void stopSync() {
        super.stopSync();
    }

    public volatile void sync() {
        super.sync();
    }

    protected void syncFromRamToFlash() {
        CookieManager cookiemanager = CookieManager.getInstance();
        if(cookiemanager.acceptCookie())
            cookiemanager.flushCookieStore();
    }

    private static CookieSyncManager sRef;
}
