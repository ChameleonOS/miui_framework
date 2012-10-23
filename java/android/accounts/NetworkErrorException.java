// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;


// Referenced classes of package android.accounts:
//            AccountsException

public class NetworkErrorException extends AccountsException {

    public NetworkErrorException() {
    }

    public NetworkErrorException(String s) {
        super(s);
    }

    public NetworkErrorException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NetworkErrorException(Throwable throwable) {
        super(throwable);
    }
}
