// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;


public class ParseException extends RuntimeException {

    ParseException(String s) {
        response = s;
    }

    public String response;
}
