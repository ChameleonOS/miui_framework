// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.sip;


public class SipException extends Exception {

    public SipException() {
    }

    public SipException(String s) {
        super(s);
    }

    public SipException(String s, Throwable throwable) {
        if((throwable instanceof javax.sip.SipException) && throwable.getCause() != null)
            throwable = throwable.getCause();
        super(s, throwable);
    }
}
