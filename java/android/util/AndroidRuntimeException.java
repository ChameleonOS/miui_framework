// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


public class AndroidRuntimeException extends RuntimeException {

    public AndroidRuntimeException() {
    }

    public AndroidRuntimeException(Exception exception) {
        super(exception);
    }

    public AndroidRuntimeException(String s) {
        super(s);
    }

    public AndroidRuntimeException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
