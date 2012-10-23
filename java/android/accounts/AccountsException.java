// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;


public class AccountsException extends Exception {

    public AccountsException() {
    }

    public AccountsException(String s) {
        super(s);
    }

    public AccountsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public AccountsException(Throwable throwable) {
        super(throwable);
    }
}
