// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.IOException;

// Referenced classes of package android.accounts:
//            AccountManager, AuthenticatorDescription, Account, AccountAuthenticatorResponse, 
//            AccountManagerCallback, OperationCanceledException, AuthenticatorException, AccountManagerFuture

public class GrantCredentialsPermissionActivity extends Activity
    implements android.view.View.OnClickListener {

    public GrantCredentialsPermissionActivity() {
        mResultBundle = null;
    }

    private String getAccountLabel(Account account) {
        AuthenticatorDescription aauthenticatordescription[];
        int i;
        int j;
        aauthenticatordescription = AccountManager.get(this).getAuthenticatorTypes();
        i = 0;
        j = aauthenticatordescription.length;
_L4:
        AuthenticatorDescription authenticatordescription;
        if(i >= j)
            break MISSING_BLOCK_LABEL_95;
        authenticatordescription = aauthenticatordescription[i];
        if(!authenticatordescription.type.equals(account.type)) goto _L2; else goto _L1
_L1:
        String s1 = createPackageContext(authenticatordescription.packageName, 0).getString(authenticatordescription.labelId);
        String s = s1;
_L3:
        return s;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        s = account.type;
          goto _L3
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        s = account.type;
          goto _L3
_L2:
        i++;
          goto _L4
        s = account.type;
          goto _L3
    }

    private View newPackageView(String s) {
        View view = mInflater.inflate(0x109007b, null);
        ((TextView)view.findViewById(0x10202fa)).setText(s);
        return view;
    }

    public void finish() {
        AccountAuthenticatorResponse accountauthenticatorresponse = (AccountAuthenticatorResponse)getIntent().getParcelableExtra("response");
        if(accountauthenticatorresponse != null)
            if(mResultBundle != null)
                accountauthenticatorresponse.onResult(mResultBundle);
            else
                accountauthenticatorresponse.onError(4, "canceled");
        super.finish();
    }

    public void onClick(View view) {
        view.getId();
        JVM INSTR tableswitch 16908929 16908930: default 28
    //                   16908929 87
    //                   16908930 33;
           goto _L1 _L2 _L3
_L1:
        finish();
        return;
_L3:
        AccountManager.get(this).updateAppPermission(mAccount, mAuthTokenType, mUid, true);
        Intent intent = new Intent();
        intent.putExtra("retry", true);
        setResult(-1, intent);
        setAccountAuthenticatorResult(intent.getExtras());
        continue; /* Loop/switch isn't completed */
_L2:
        AccountManager.get(this).updateAppPermission(mAccount, mAuthTokenType, mUid, false);
        setResult(0);
        if(true) goto _L1; else goto _L4
_L4:
    }

    protected void onCreate(Bundle bundle) {
        Bundle bundle1;
        super.onCreate(bundle);
        setContentView(0x1090043);
        setTitle(0x1040470);
        mInflater = (LayoutInflater)getSystemService("layout_inflater");
        bundle1 = getIntent().getExtras();
        if(bundle1 != null) goto _L2; else goto _L1
_L1:
        setResult(0);
        finish();
_L8:
        return;
_L2:
        String s;
        String s1;
        String s2;
        mAccount = (Account)bundle1.getParcelable("account");
        mAuthTokenType = bundle1.getString("authTokenType");
        mUid = bundle1.getInt("uid");
        PackageManager packagemanager = getPackageManager();
        String as[] = packagemanager.getPackagesForUid(mUid);
        if(mAccount == null || mAuthTokenType == null || as == null) {
            setResult(0);
            finish();
            continue; /* Loop/switch isn't completed */
        }
        final TextView authTokenTypeView;
        AccountManagerCallback accountmanagercallback;
        LinearLayout linearlayout;
        int i;
        int j;
        String s3;
        try {
            s = getAccountLabel(mAccount);
        }
        catch(IllegalArgumentException illegalargumentexception) {
            setResult(0);
            finish();
            continue; /* Loop/switch isn't completed */
        }
        authTokenTypeView = (TextView)findViewById(0x102027e);
        authTokenTypeView.setVisibility(8);
        accountmanagercallback = new AccountManagerCallback() {

            public void run(AccountManagerFuture accountmanagerfuture) {
                final String authTokenLabel = (String)accountmanagerfuture.getResult();
                if(!TextUtils.isEmpty(authTokenLabel))
                    runOnUiThread(new Runnable() {

                        public void run() {
                            if(!isFinishing()) {
                                authTokenTypeView.setText(authTokenLabel);
                                authTokenTypeView.setVisibility(0);
                            }
                        }

                        final _cls1 this$1;
                        final String val$authTokenLabel;

                     {
                        this$1 = _cls1.this;
                        authTokenLabel = s;
                        super();
                    }
                    });
_L2:
                return;
                AuthenticatorException authenticatorexception;
                authenticatorexception;
                continue; /* Loop/switch isn't completed */
                IOException ioexception;
                ioexception;
                continue; /* Loop/switch isn't completed */
                OperationCanceledException operationcanceledexception;
                operationcanceledexception;
                if(true) goto _L2; else goto _L1
_L1:
            }

            final GrantCredentialsPermissionActivity this$0;
            final TextView val$authTokenTypeView;

             {
                this$0 = GrantCredentialsPermissionActivity.this;
                authTokenTypeView = textview;
                super();
            }
        };
        AccountManager.get(this).getAuthTokenLabel(mAccount.type, mAuthTokenType, accountmanagercallback, null);
        findViewById(0x1020282).setOnClickListener(this);
        findViewById(0x1020281).setOnClickListener(this);
        linearlayout = (LinearLayout)findViewById(0x102027a);
        i = as.length;
        j = 0;
        if(j >= i)
            break; /* Loop/switch isn't completed */
        s1 = as[j];
        s3 = packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(s1, 0)).toString();
        s2 = s3;
_L6:
        linearlayout.addView(newPackageView(s2));
        j++;
        if(true) goto _L4; else goto _L3
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_232;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        s2 = s1;
        if(true) goto _L6; else goto _L5
_L5:
        ((TextView)findViewById(0x102027d)).setText(mAccount.name);
        ((TextView)findViewById(0x102027c)).setText(s);
        if(true) goto _L8; else goto _L7
_L7:
    }

    public final void setAccountAuthenticatorResult(Bundle bundle) {
        mResultBundle = bundle;
    }

    public static final String EXTRAS_ACCOUNT = "account";
    public static final String EXTRAS_ACCOUNT_TYPE_LABEL = "accountTypeLabel";
    public static final String EXTRAS_AUTH_TOKEN_LABEL = "authTokenLabel";
    public static final String EXTRAS_AUTH_TOKEN_TYPE = "authTokenType";
    public static final String EXTRAS_PACKAGES = "application";
    public static final String EXTRAS_REQUESTING_UID = "uid";
    public static final String EXTRAS_RESPONSE = "response";
    private Account mAccount;
    private String mAuthTokenType;
    protected LayoutInflater mInflater;
    private Bundle mResultBundle;
    private int mUid;
}
