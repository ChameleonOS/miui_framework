// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.content.Context;
import android.os.*;
import android.util.Log;
import java.util.Arrays;

// Referenced classes of package android.accounts:
//            NetworkErrorException, IAccountAuthenticatorResponse, AccountAuthenticatorResponse, Account, 
//            AccountManager

public abstract class AbstractAccountAuthenticator {
    private class Transport extends IAccountAuthenticator.Stub {

        public void addAccount(IAccountAuthenticatorResponse iaccountauthenticatorresponse, String s, String s1, String as[], Bundle bundle) throws RemoteException {
            if(Log.isLoggable("AccountAuthenticator", 2)) {
                StringBuilder stringbuilder = (new StringBuilder()).append("addAccount: accountType ").append(s).append(", authTokenType ").append(s1).append(", features ");
                Bundle bundle1;
                String s2;
                if(as == null)
                    s2 = "[]";
                else
                    s2 = Arrays.toString(as);
                Log.v("AccountAuthenticator", stringbuilder.append(s2).toString());
            }
            checkBinderPermission();
            bundle1 = AbstractAccountAuthenticator.this.addAccount(new AccountAuthenticatorResponse(iaccountauthenticatorresponse), s, s1, as, bundle);
            if(Log.isLoggable("AccountAuthenticator", 2)) {
                bundle1.keySet();
                Log.v("AccountAuthenticator", (new StringBuilder()).append("addAccount: result ").append(AccountManager.sanitizeResult(bundle1)).toString());
            }
            if(bundle1 != null)
                iaccountauthenticatorresponse.onResult(bundle1);
_L1:
            return;
            Exception exception;
            exception;
            handleException(iaccountauthenticatorresponse, "addAccount", s, exception);
              goto _L1
        }

        public void confirmCredentials(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account, Bundle bundle) throws RemoteException {
            if(Log.isLoggable("AccountAuthenticator", 2))
                Log.v("AccountAuthenticator", (new StringBuilder()).append("confirmCredentials: ").append(account).toString());
            checkBinderPermission();
            Bundle bundle1 = AbstractAccountAuthenticator.this.confirmCredentials(new AccountAuthenticatorResponse(iaccountauthenticatorresponse), account, bundle);
            if(Log.isLoggable("AccountAuthenticator", 2)) {
                bundle1.keySet();
                Log.v("AccountAuthenticator", (new StringBuilder()).append("confirmCredentials: result ").append(AccountManager.sanitizeResult(bundle1)).toString());
            }
            if(bundle1 != null)
                iaccountauthenticatorresponse.onResult(bundle1);
_L1:
            return;
            Exception exception;
            exception;
            handleException(iaccountauthenticatorresponse, "confirmCredentials", account.toString(), exception);
              goto _L1
        }

        public void editProperties(IAccountAuthenticatorResponse iaccountauthenticatorresponse, String s) throws RemoteException {
            checkBinderPermission();
            Bundle bundle = AbstractAccountAuthenticator.this.editProperties(new AccountAuthenticatorResponse(iaccountauthenticatorresponse), s);
            if(bundle != null)
                iaccountauthenticatorresponse.onResult(bundle);
_L1:
            return;
            Exception exception;
            exception;
            handleException(iaccountauthenticatorresponse, "editProperties", s, exception);
              goto _L1
        }

        public void getAccountRemovalAllowed(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account) throws RemoteException {
            checkBinderPermission();
            Bundle bundle = AbstractAccountAuthenticator.this.getAccountRemovalAllowed(new AccountAuthenticatorResponse(iaccountauthenticatorresponse), account);
            if(bundle != null)
                iaccountauthenticatorresponse.onResult(bundle);
_L1:
            return;
            Exception exception;
            exception;
            handleException(iaccountauthenticatorresponse, "getAccountRemovalAllowed", account.toString(), exception);
              goto _L1
        }

        public void getAuthToken(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account, String s, Bundle bundle) throws RemoteException {
            if(Log.isLoggable("AccountAuthenticator", 2))
                Log.v("AccountAuthenticator", (new StringBuilder()).append("getAuthToken: ").append(account).append(", authTokenType ").append(s).toString());
            checkBinderPermission();
            Bundle bundle1 = AbstractAccountAuthenticator.this.getAuthToken(new AccountAuthenticatorResponse(iaccountauthenticatorresponse), account, s, bundle);
            if(Log.isLoggable("AccountAuthenticator", 2)) {
                bundle1.keySet();
                Log.v("AccountAuthenticator", (new StringBuilder()).append("getAuthToken: result ").append(AccountManager.sanitizeResult(bundle1)).toString());
            }
            if(bundle1 != null)
                iaccountauthenticatorresponse.onResult(bundle1);
_L1:
            return;
            Exception exception;
            exception;
            handleException(iaccountauthenticatorresponse, "getAuthToken", (new StringBuilder()).append(account.toString()).append(",").append(s).toString(), exception);
              goto _L1
        }

        public void getAuthTokenLabel(IAccountAuthenticatorResponse iaccountauthenticatorresponse, String s) throws RemoteException {
            if(Log.isLoggable("AccountAuthenticator", 2))
                Log.v("AccountAuthenticator", (new StringBuilder()).append("getAuthTokenLabel: authTokenType ").append(s).toString());
            checkBinderPermission();
            Bundle bundle = new Bundle();
            bundle.putString("authTokenLabelKey", AbstractAccountAuthenticator.this.getAuthTokenLabel(s));
            if(Log.isLoggable("AccountAuthenticator", 2)) {
                bundle.keySet();
                Log.v("AccountAuthenticator", (new StringBuilder()).append("getAuthTokenLabel: result ").append(AccountManager.sanitizeResult(bundle)).toString());
            }
            iaccountauthenticatorresponse.onResult(bundle);
_L1:
            return;
            Exception exception;
            exception;
            handleException(iaccountauthenticatorresponse, "getAuthTokenLabel", s, exception);
              goto _L1
        }

        public void hasFeatures(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account, String as[]) throws RemoteException {
            checkBinderPermission();
            Bundle bundle = AbstractAccountAuthenticator.this.hasFeatures(new AccountAuthenticatorResponse(iaccountauthenticatorresponse), account, as);
            if(bundle != null)
                iaccountauthenticatorresponse.onResult(bundle);
_L1:
            return;
            Exception exception;
            exception;
            handleException(iaccountauthenticatorresponse, "hasFeatures", account.toString(), exception);
              goto _L1
        }

        public void updateCredentials(IAccountAuthenticatorResponse iaccountauthenticatorresponse, Account account, String s, Bundle bundle) throws RemoteException {
            if(Log.isLoggable("AccountAuthenticator", 2))
                Log.v("AccountAuthenticator", (new StringBuilder()).append("updateCredentials: ").append(account).append(", authTokenType ").append(s).toString());
            checkBinderPermission();
            Bundle bundle1 = AbstractAccountAuthenticator.this.updateCredentials(new AccountAuthenticatorResponse(iaccountauthenticatorresponse), account, s, bundle);
            if(Log.isLoggable("AccountAuthenticator", 2)) {
                bundle1.keySet();
                Log.v("AccountAuthenticator", (new StringBuilder()).append("updateCredentials: result ").append(AccountManager.sanitizeResult(bundle1)).toString());
            }
            if(bundle1 != null)
                iaccountauthenticatorresponse.onResult(bundle1);
_L1:
            return;
            Exception exception;
            exception;
            handleException(iaccountauthenticatorresponse, "updateCredentials", (new StringBuilder()).append(account.toString()).append(",").append(s).toString(), exception);
              goto _L1
        }

        final AbstractAccountAuthenticator this$0;

        private Transport() {
            this$0 = AbstractAccountAuthenticator.this;
            super();
        }

    }


    public AbstractAccountAuthenticator(Context context) {
        mTransport = new Transport();
        mContext = context;
    }

    private void checkBinderPermission() {
        int i = Binder.getCallingUid();
        if(mContext.checkCallingOrSelfPermission("android.permission.ACCOUNT_MANAGER") != 0)
            throw new SecurityException((new StringBuilder()).append("caller uid ").append(i).append(" lacks ").append("android.permission.ACCOUNT_MANAGER").toString());
        else
            return;
    }

    private void handleException(IAccountAuthenticatorResponse iaccountauthenticatorresponse, String s, String s1, Exception exception) throws RemoteException {
        if(exception instanceof NetworkErrorException) {
            if(Log.isLoggable("AccountAuthenticator", 2))
                Log.v("AccountAuthenticator", (new StringBuilder()).append(s).append("(").append(s1).append(")").toString(), exception);
            iaccountauthenticatorresponse.onError(3, exception.getMessage());
        } else
        if(exception instanceof UnsupportedOperationException) {
            if(Log.isLoggable("AccountAuthenticator", 2))
                Log.v("AccountAuthenticator", (new StringBuilder()).append(s).append("(").append(s1).append(")").toString(), exception);
            iaccountauthenticatorresponse.onError(6, (new StringBuilder()).append(s).append(" not supported").toString());
        } else
        if(exception instanceof IllegalArgumentException) {
            if(Log.isLoggable("AccountAuthenticator", 2))
                Log.v("AccountAuthenticator", (new StringBuilder()).append(s).append("(").append(s1).append(")").toString(), exception);
            iaccountauthenticatorresponse.onError(7, (new StringBuilder()).append(s).append(" not supported").toString());
        } else {
            Log.w("AccountAuthenticator", (new StringBuilder()).append(s).append("(").append(s1).append(")").toString(), exception);
            iaccountauthenticatorresponse.onError(1, (new StringBuilder()).append(s).append(" failed").toString());
        }
    }

    public abstract Bundle addAccount(AccountAuthenticatorResponse accountauthenticatorresponse, String s, String s1, String as[], Bundle bundle) throws NetworkErrorException;

    public abstract Bundle confirmCredentials(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, Bundle bundle) throws NetworkErrorException;

    public abstract Bundle editProperties(AccountAuthenticatorResponse accountauthenticatorresponse, String s);

    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse accountauthenticatorresponse, Account account) throws NetworkErrorException {
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", true);
        return bundle;
    }

    public abstract Bundle getAuthToken(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String s, Bundle bundle) throws NetworkErrorException;

    public abstract String getAuthTokenLabel(String s);

    public final IBinder getIBinder() {
        return mTransport.asBinder();
    }

    public abstract Bundle hasFeatures(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String as[]) throws NetworkErrorException;

    public abstract Bundle updateCredentials(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String s, Bundle bundle) throws NetworkErrorException;

    private static final String TAG = "AccountAuthenticator";
    private final Context mContext;
    private Transport mTransport;


}
