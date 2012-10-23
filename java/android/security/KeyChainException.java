// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.security;


public class KeyChainException extends Exception {

    public KeyChainException() {
    }

    public KeyChainException(String s) {
        super(s);
    }

    public KeyChainException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public KeyChainException(Throwable throwable) {
        String s;
        if(throwable == null)
            s = null;
        else
            s = throwable.toString();
        super(s, throwable);
    }
}
