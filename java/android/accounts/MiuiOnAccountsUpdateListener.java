// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.os.Bundle;

// Referenced classes of package android.accounts:
//            OnAccountsUpdateListener, Account

public interface MiuiOnAccountsUpdateListener
    extends OnAccountsUpdateListener {

    public abstract void onPreAccountUpdated(Account account, int i, Bundle bundle);
}
