// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import javax.net.ssl.SSLException;

class SSLConnectionClosedByUserException extends SSLException {

    public SSLConnectionClosedByUserException(String s) {
        super(s);
    }
}
