// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.net.WebAddress;

// Referenced classes of package android.webkit:
//            WebViewFactory, WebViewFactoryProvider, MustOverrideException

public class CookieManager {

    protected CookieManager() {
    }

    public static boolean allowFileSchemeCookies() {
        return getInstance().allowFileSchemeCookiesImpl();
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static CookieManager getInstance() {
        android/webkit/CookieManager;
        JVM INSTR monitorenter ;
        CookieManager cookiemanager = WebViewFactory.getProvider().getCookieManager();
        android/webkit/CookieManager;
        JVM INSTR monitorexit ;
        return cookiemanager;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setAcceptFileSchemeCookies(boolean flag) {
        getInstance().setAcceptFileSchemeCookiesImpl(flag);
    }

    /**
     * @deprecated Method acceptCookie is deprecated
     */

    public boolean acceptCookie() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean allowFileSchemeCookiesImpl() {
        throw new MustOverrideException();
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    protected void flushCookieStore() {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method getCookie is deprecated
     */

    public String getCookie(WebAddress webaddress) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getCookie(String s) {
        throw new MustOverrideException();
    }

    public String getCookie(String s, boolean flag) {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method hasCookies is deprecated
     */

    public boolean hasCookies() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method hasCookies is deprecated
     */

    public boolean hasCookies(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void removeAllCookie() {
        throw new MustOverrideException();
    }

    public void removeExpiredCookie() {
        throw new MustOverrideException();
    }

    public void removeSessionCookie() {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method setAcceptCookie is deprecated
     */

    public void setAcceptCookie(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void setAcceptFileSchemeCookiesImpl(boolean flag) {
        throw new MustOverrideException();
    }

    public void setCookie(String s, String s1) {
        throw new MustOverrideException();
    }
}
