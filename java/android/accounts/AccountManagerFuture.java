// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package android.accounts:
//            OperationCanceledException, AuthenticatorException

public interface AccountManagerFuture {

    public abstract boolean cancel(boolean flag);

    public abstract Object getResult() throws OperationCanceledException, IOException, AuthenticatorException;

    public abstract Object getResult(long l, TimeUnit timeunit) throws OperationCanceledException, IOException, AuthenticatorException;

    public abstract boolean isCancelled();

    public abstract boolean isDone();
}
