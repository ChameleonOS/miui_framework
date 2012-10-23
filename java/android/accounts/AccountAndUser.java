// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;


// Referenced classes of package android.accounts:
//            Account

public class AccountAndUser {

    public AccountAndUser(Account account1, int i) {
        account = account1;
        userId = i;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(this != obj) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(!(obj instanceof AccountAndUser)) {
            flag = false;
        } else {
            AccountAndUser accountanduser = (AccountAndUser)obj;
            if(!account.equals(accountanduser.account) || userId != accountanduser.userId)
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int hashCode() {
        return account.hashCode() + userId;
    }

    public String toString() {
        return (new StringBuilder()).append(account.toString()).append(" u").append(userId).toString();
    }

    public Account account;
    public int userId;
}
