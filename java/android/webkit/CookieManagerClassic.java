// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.net.ParseException;
import android.net.WebAddress;
import android.os.AsyncTask;
import android.util.Log;

// Referenced classes of package android.webkit:
//            CookieManager

class CookieManagerClassic extends CookieManager {

    private CookieManagerClassic() {
        mPendingCookieOperations = 0;
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static CookieManagerClassic getInstance() {
        android/webkit/CookieManagerClassic;
        JVM INSTR monitorenter ;
        CookieManagerClassic cookiemanagerclassic;
        if(sRef == null)
            sRef = new CookieManagerClassic();
        cookiemanagerclassic = sRef;
        android/webkit/CookieManagerClassic;
        JVM INSTR monitorexit ;
        return cookiemanagerclassic;
        Exception exception;
        exception;
        throw exception;
    }

    private static native boolean nativeAcceptCookie();

    private static native boolean nativeAcceptFileSchemeCookies();

    private static native void nativeFlushCookieStore();

    private static native String nativeGetCookie(String s, boolean flag);

    private static native boolean nativeHasCookies(boolean flag);

    private static native void nativeRemoveAllCookie();

    private static native void nativeRemoveExpiredCookie();

    private static native void nativeRemoveSessionCookie();

    private static native void nativeSetAcceptCookie(boolean flag);

    private static native void nativeSetAcceptFileSchemeCookies(boolean flag);

    private static native void nativeSetCookie(String s, String s1, boolean flag);

    /**
     * @deprecated Method signalCookieOperationsComplete is deprecated
     */

    private void signalCookieOperationsComplete() {
        this;
        JVM INSTR monitorenter ;
        mPendingCookieOperations = -1 + mPendingCookieOperations;
        if(!$assertionsDisabled && mPendingCookieOperations <= -1)
            throw new AssertionError();
        break MISSING_BLOCK_LABEL_41;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        notify();
        this;
        JVM INSTR monitorexit ;
    }

    /**
     * @deprecated Method signalCookieOperationsStart is deprecated
     */

    private void signalCookieOperationsStart() {
        this;
        JVM INSTR monitorenter ;
        mPendingCookieOperations = 1 + mPendingCookieOperations;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method acceptCookie is deprecated
     */

    public boolean acceptCookie() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = nativeAcceptCookie();
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    protected boolean allowFileSchemeCookiesImpl() {
        return nativeAcceptFileSchemeCookies();
    }

    protected void flushCookieStore() {
        nativeFlushCookieStore();
    }

    /**
     * @deprecated Method getCookie is deprecated
     */

    public String getCookie(WebAddress webaddress) {
        this;
        JVM INSTR monitorenter ;
        String s = nativeGetCookie(webaddress.toString(), false);
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public String getCookie(String s) {
        return getCookie(s, false);
    }

    public String getCookie(String s, boolean flag) {
        WebAddress webaddress = new WebAddress(s);
        String s1 = nativeGetCookie(webaddress.toString(), flag);
_L2:
        return s1;
        ParseException parseexception;
        parseexception;
        Log.e("webkit", (new StringBuilder()).append("Bad address: ").append(s).toString());
        s1 = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    /**
     * @deprecated Method hasCookies is deprecated
     */

    public boolean hasCookies() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = hasCookies(false);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method hasCookies is deprecated
     */

    public boolean hasCookies(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = nativeHasCookies(flag);
        this;
        JVM INSTR monitorexit ;
        return flag1;
        Exception exception;
        exception;
        throw exception;
    }

    public void removeAllCookie() {
        nativeRemoveAllCookie();
    }

    public void removeExpiredCookie() {
        nativeRemoveExpiredCookie();
    }

    public void removeSessionCookie() {
        signalCookieOperationsStart();
        (new AsyncTask() {

            protected volatile Object doInBackground(Object aobj[]) {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[]) {
                CookieManagerClassic.nativeRemoveSessionCookie();
                signalCookieOperationsComplete();
                return null;
            }

            final CookieManagerClassic this$0;

             {
                this$0 = CookieManagerClassic.this;
                super();
            }
        }).execute(new Void[0]);
    }

    /**
     * @deprecated Method setAcceptCookie is deprecated
     */

    public void setAcceptCookie(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        nativeSetAcceptCookie(flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void setAcceptFileSchemeCookiesImpl(boolean flag) {
        nativeSetAcceptFileSchemeCookies(flag);
    }

    public void setCookie(String s, String s1) {
        setCookie(s, s1, false);
    }

    void setCookie(String s, String s1, boolean flag) {
        WebAddress webaddress = new WebAddress(s);
        nativeSetCookie(webaddress.toString(), s1, flag);
_L2:
        return;
        ParseException parseexception;
        parseexception;
        Log.e("webkit", (new StringBuilder()).append("Bad address: ").append(s).toString());
        if(true) goto _L2; else goto _L1
_L1:
    }

    void waitForCookieOperationsToComplete() {
        this;
        JVM INSTR monitorenter ;
_L3:
        int i = mPendingCookieOperations;
        if(i <= 0) goto _L2; else goto _L1
_L1:
        Exception exception;
        try {
            wait();
        }
        catch(InterruptedException interruptedexception) { }
        finally {
            this;
        }
        if(true) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        throw exception;
    }

    static final boolean $assertionsDisabled = false;
    private static final String LOGTAG = "webkit";
    private static CookieManagerClassic sRef;
    private int mPendingCookieOperations;

    static  {
        boolean flag;
        if(!android/webkit/CookieManagerClassic.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }


}
