// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;


public class SQLException extends RuntimeException {

    public SQLException() {
    }

    public SQLException(String s) {
        super(s);
    }

    public SQLException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
