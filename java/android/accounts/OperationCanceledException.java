// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;


// Referenced classes of package android.accounts:
//            AccountsException

public class OperationCanceledException extends AccountsException {

    public OperationCanceledException() {
    }

    public OperationCanceledException(String s) {
        super(s);
    }

    public OperationCanceledException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public OperationCanceledException(Throwable throwable) {
        super(throwable);
    }
}
