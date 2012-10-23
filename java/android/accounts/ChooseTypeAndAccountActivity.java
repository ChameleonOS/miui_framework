// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.*;
import java.io.IOException;
import java.util.*;

// Referenced classes of package android.accounts:
//            AccountManagerCallback, Account, ChooseAccountTypeActivity, AccountManager, 
//            AuthenticatorDescription, OperationCanceledException, AuthenticatorException, AccountManagerFuture

public class ChooseTypeAndAccountActivity extends Activity
    implements AccountManagerCallback {

    public ChooseTypeAndAccountActivity() {
        mPendingRequest = 0;
        mExistingAccounts = null;
    }

    private void onAccountSelected(Account account) {
        Log.d("AccountChooser", (new StringBuilder()).append("selected account ").append(account).toString());
        setResultAndFinish(account.name, account.type);
    }

    private void setResultAndFinish(String s, String s1) {
        Bundle bundle = new Bundle();
        bundle.putString("authAccount", s);
        bundle.putString("accountType", s1);
        setResult(-1, (new Intent()).putExtras(bundle));
        if(Log.isLoggable("AccountChooser", 2))
            Log.v("AccountChooser", (new StringBuilder()).append("ChooseTypeAndAccountActivity.setResultAndFinish: selected account ").append(s).append(", ").append(s1).toString());
        finish();
    }

    private void startChooseAccountTypeActivity() {
        if(Log.isLoggable("AccountChooser", 2))
            Log.v("AccountChooser", "ChooseAccountTypeActivity.startChooseAccountTypeActivity()");
        Intent intent = new Intent(this, android/accounts/ChooseAccountTypeActivity);
        intent.setFlags(0x80000);
        intent.putExtra("allowableAccountTypes", getIntent().getStringArrayExtra("allowableAccountTypes"));
        intent.putExtra("addAccountOptions", getIntent().getBundleExtra("addAccountOptions"));
        intent.putExtra("addAccountRequiredFeatures", getIntent().getStringArrayExtra("addAccountRequiredFeatures"));
        intent.putExtra("authTokenType", getIntent().getStringExtra("authTokenType"));
        startActivityForResult(intent, 1);
        mPendingRequest = 1;
    }

    protected void onActivityResult(int i, int j, Intent intent) {
        if(Log.isLoggable("AccountChooser", 2)) {
            if(intent != null && intent.getExtras() != null)
                intent.getExtras().keySet();
            Bundle bundle;
            if(intent != null)
                bundle = intent.getExtras();
            else
                bundle = null;
            Log.v("AccountChooser", (new StringBuilder()).append("ChooseTypeAndAccountActivity.onActivityResult(reqCode=").append(i).append(", resCode=").append(j).append(", extras=").append(bundle).append(")").toString());
        }
        mPendingRequest = 0;
        if(j != 0) goto _L2; else goto _L1
_L1:
        if(mAccounts.isEmpty()) {
            setResult(0);
            finish();
        }
_L7:
        return;
_L2:
        if(j != -1) goto _L4; else goto _L3
_L3:
        if(i != 1) goto _L6; else goto _L5
_L5:
label0:
        {
            if(intent == null)
                break label0;
            String s2 = intent.getStringExtra("accountType");
            if(s2 == null)
                break label0;
            runAddAccountForAuthenticator(s2);
        }
          goto _L7
        Log.d("AccountChooser", "ChooseTypeAndAccountActivity.onActivityResult: unable to find account type, pretending the request was canceled");
_L9:
        Log.d("AccountChooser", "ChooseTypeAndAccountActivity.onActivityResult: unable to find added account, pretending the request was canceled");
_L4:
        if(Log.isLoggable("AccountChooser", 2))
            Log.v("AccountChooser", "ChooseTypeAndAccountActivity.onActivityResult: canceled");
        setResult(0);
        finish();
          goto _L7
_L6:
        if(i != 2) goto _L9; else goto _L8
_L8:
        String s;
        String s1;
        Account aaccount[];
        HashSet hashset;
        int i1;
        int j1;
        s = null;
        s1 = null;
        if(intent != null) {
            s = intent.getStringExtra("authAccount");
            s1 = intent.getStringExtra("accountType");
        }
        if(s != null && s1 != null)
            continue; /* Loop/switch isn't completed */
        aaccount = AccountManager.get(this).getAccounts();
        hashset = new HashSet();
        Parcelable aparcelable[] = mExistingAccounts;
        int k = aparcelable.length;
        for(int l = 0; l < k; l++)
            hashset.add((Account)aparcelable[l]);

        i1 = aaccount.length;
        j1 = 0;
_L11:
        if(j1 >= i1)
            continue; /* Loop/switch isn't completed */
        Account account = aaccount[j1];
        if(hashset.contains(account))
            break MISSING_BLOCK_LABEL_375;
        s = account.name;
        s1 = account.type;
        if(s == null && s1 == null) goto _L9; else goto _L10
_L10:
        setResultAndFinish(s, s1);
          goto _L7
        j1++;
          goto _L11
    }

    public void onCancelButtonClicked(View view) {
        onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        AccountManager accountmanager;
        Intent intent;
        String s;
        boolean flag;
        super.onCreate(bundle);
        if(Log.isLoggable("AccountChooser", 2))
            Log.v("AccountChooser", (new StringBuilder()).append("ChooseTypeAndAccountActivity.onCreate(savedInstanceState=").append(bundle).append(")").toString());
        accountmanager = AccountManager.get(this);
        intent = getIntent();
        s = null;
        flag = false;
        if(bundle == null) goto _L2; else goto _L1
_L1:
        mPendingRequest = bundle.getInt("pendingRequest");
        mExistingAccounts = bundle.getParcelableArray("existingAccounts");
        s = bundle.getString("selectedAccountName");
        flag = bundle.getBoolean("selectedAddAccount", false);
_L4:
        if(Log.isLoggable("AccountChooser", 2))
            Log.v("AccountChooser", (new StringBuilder()).append("selected account name is ").append(s).toString());
        HashMap hashmap = new HashMap();
        AuthenticatorDescription aauthenticatordescription[] = accountmanager.getAuthenticatorTypes();
        int i = aauthenticatordescription.length;
        for(int j = 0; j < i; j++) {
            AuthenticatorDescription authenticatordescription = aauthenticatordescription[j];
            hashmap.put(authenticatordescription.type, authenticatordescription);
        }

        break; /* Loop/switch isn't completed */
_L2:
        mPendingRequest = 0;
        mExistingAccounts = null;
        Account account = (Account)intent.getParcelableExtra("selectedAccount");
        if(account != null)
            s = account.name;
        if(true) goto _L4; else goto _L3
_L3:
        HashSet hashset;
        HashSet hashset1;
        Account aaccount[];
        int k;
        int l;
        hashset = null;
        ArrayList arraylist = intent.getParcelableArrayListExtra("allowableAccounts");
        if(arraylist != null) {
            int k2 = arraylist.size();
            hashset = new HashSet(k2);
            Account account3;
            for(Iterator iterator1 = arraylist.iterator(); iterator1.hasNext(); hashset.add(account3))
                account3 = (Account)(Parcelable)iterator1.next();

        }
        hashset1 = null;
        String as[] = intent.getStringArrayExtra("allowableAccountTypes");
        if(as != null) {
            int j1 = as.length;
            hashset1 = new HashSet(j1);
            HashSet hashset2 = new HashSet(as.length);
            int k1 = as.length;
            for(int l1 = 0; l1 < k1; l1++)
                hashset2.add(as[l1]);

            AuthenticatorDescription aauthenticatordescription1[] = AccountManager.get(this).getAuthenticatorTypes();
            HashSet hashset3 = new HashSet(aauthenticatordescription1.length);
            int i2 = aauthenticatordescription1.length;
            for(int j2 = 0; j2 < i2; j2++)
                hashset3.add(aauthenticatordescription1[j2].type);

            Iterator iterator = hashset2.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                String s3 = (String)iterator.next();
                if(hashset3.contains(s3))
                    hashset1.add(s3);
            } while(true);
        }
        aaccount = accountmanager.getAccounts();
        mAccounts = new ArrayList(aaccount.length);
        mSelectedItemIndex = -1;
        k = aaccount.length;
        l = 0;
_L6:
        Account account2;
        if(l >= k)
            break MISSING_BLOCK_LABEL_633;
        account2 = aaccount[l];
        if(hashset == null || hashset.contains(account2))
            break; /* Loop/switch isn't completed */
_L9:
        l++;
        if(true) goto _L6; else goto _L5
_L5:
        if(hashset1 == null) goto _L8; else goto _L7
_L7:
        String s2 = account2.type;
        if(!hashset1.contains(s2)) goto _L9; else goto _L8
_L8:
        if(account2.name.equals(s))
            mSelectedItemIndex = mAccounts.size();
        mAccounts.add(account2);
          goto _L9
        if(mPendingRequest != 0) goto _L11; else goto _L10
_L10:
        if(!mAccounts.isEmpty()) goto _L13; else goto _L12
_L12:
        if(hashset1.size() == 1)
            runAddAccountForAuthenticator((String)hashset1.iterator().next());
        else
            startChooseAccountTypeActivity();
_L15:
        return;
_L13:
        if(!intent.getBooleanExtra("alwaysPromptForAccount", false) && mAccounts.size() == 1) {
            Account account1 = (Account)mAccounts.get(0);
            setResultAndFinish(account1.name, account1.type);
            continue; /* Loop/switch isn't completed */
        }
_L11:
        setContentView(0x1090034);
        String s1 = intent.getStringExtra("descriptionTextOverride");
        TextView textview = (TextView)findViewById(0x102026c);
        String as1[];
        if(!TextUtils.isEmpty(s1))
            textview.setText(s1);
        else
            textview.setVisibility(8);
        as1 = new String[1 + mAccounts.size()];
        for(int i1 = 0; i1 < mAccounts.size(); i1++)
            as1[i1] = ((Account)mAccounts.get(i1)).name;

        as1[mAccounts.size()] = getResources().getString(0x10404a8);
        ListView listview = (ListView)findViewById(0x102000a);
        ArrayAdapter arrayadapter = new ArrayAdapter(this, 0x109000f, as1);
        listview.setAdapter(arrayadapter);
        listview.setChoiceMode(1);
        listview.setItemsCanFocus(false);
        android.widget.AdapterView.OnItemClickListener onitemclicklistener = new android.widget.AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterview, View view, int l2, long l3) {
                mSelectedItemIndex = l2;
                mOkButton.setEnabled(true);
            }

            final ChooseTypeAndAccountActivity this$0;

             {
                this$0 = ChooseTypeAndAccountActivity.this;
                super();
            }
        };
        listview.setOnItemClickListener(onitemclicklistener);
        if(flag)
            mSelectedItemIndex = mAccounts.size();
        if(mSelectedItemIndex != -1) {
            listview.setItemChecked(mSelectedItemIndex, true);
            if(Log.isLoggable("AccountChooser", 2))
                Log.v("AccountChooser", (new StringBuilder()).append("List item ").append(mSelectedItemIndex).append(" should be selected").toString());
        }
        mOkButton = (Button)findViewById(0x102001a);
        Button button = mOkButton;
        boolean flag1;
        if(mSelectedItemIndex != -1)
            flag1 = true;
        else
            flag1 = false;
        button.setEnabled(flag1);
        if(true) goto _L15; else goto _L14
_L14:
    }

    protected void onDestroy() {
        if(Log.isLoggable("AccountChooser", 2))
            Log.v("AccountChooser", "ChooseTypeAndAccountActivity.onDestroy()");
        super.onDestroy();
    }

    public void onOkButtonClicked(View view) {
        if(mSelectedItemIndex != mAccounts.size()) goto _L2; else goto _L1
_L1:
        startChooseAccountTypeActivity();
_L4:
        return;
_L2:
        if(mSelectedItemIndex != -1)
            onAccountSelected((Account)mAccounts.get(mSelectedItemIndex));
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("pendingRequest", mPendingRequest);
        if(mPendingRequest == 2)
            bundle.putParcelableArray("existingAccounts", mExistingAccounts);
        if(mSelectedItemIndex != -1)
            if(mSelectedItemIndex == mAccounts.size()) {
                bundle.putBoolean("selectedAddAccount", true);
            } else {
                bundle.putBoolean("selectedAddAccount", false);
                bundle.putString("selectedAccountName", ((Account)mAccounts.get(mSelectedItemIndex)).name);
            }
    }

    public void run(AccountManagerFuture accountmanagerfuture) {
        Intent intent = (Intent)((Bundle)accountmanagerfuture.getResult()).getParcelable("intent");
        if(intent == null)
            break MISSING_BLOCK_LABEL_80;
        mPendingRequest = 2;
        mExistingAccounts = AccountManager.get(this).getAccounts();
        intent.setFlags(0xefffffff & intent.getFlags());
        startActivityForResult(intent, 2);
_L1:
        return;
        OperationCanceledException operationcanceledexception;
        operationcanceledexception;
        setResult(0);
        finish();
          goto _L1
        AuthenticatorException authenticatorexception;
        authenticatorexception;
_L2:
        Bundle bundle = new Bundle();
        bundle.putString("errorMessage", "error communicating with server");
        setResult(-1, (new Intent()).putExtras(bundle));
        finish();
          goto _L1
        IOException ioexception;
        ioexception;
          goto _L2
    }

    protected void runAddAccountForAuthenticator(String s) {
        if(Log.isLoggable("AccountChooser", 2))
            Log.v("AccountChooser", (new StringBuilder()).append("runAddAccountForAuthenticator: ").append(s).toString());
        Bundle bundle = getIntent().getBundleExtra("addAccountOptions");
        String as[] = getIntent().getStringArrayExtra("addAccountRequiredFeatures");
        String s1 = getIntent().getStringExtra("authTokenType");
        AccountManager.get(this).addAccount(s, s1, as, bundle, null, this, null);
    }

    public static final String EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING = "authTokenType";
    public static final String EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE = "addAccountOptions";
    public static final String EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY = "addAccountRequiredFeatures";
    public static final String EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST = "allowableAccounts";
    public static final String EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY = "allowableAccountTypes";
    public static final String EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT = "alwaysPromptForAccount";
    public static final String EXTRA_DESCRIPTION_TEXT_OVERRIDE = "descriptionTextOverride";
    public static final String EXTRA_SELECTED_ACCOUNT = "selectedAccount";
    private static final String KEY_INSTANCE_STATE_EXISTING_ACCOUNTS = "existingAccounts";
    private static final String KEY_INSTANCE_STATE_PENDING_REQUEST = "pendingRequest";
    private static final String KEY_INSTANCE_STATE_SELECTED_ACCOUNT_NAME = "selectedAccountName";
    private static final String KEY_INSTANCE_STATE_SELECTED_ADD_ACCOUNT = "selectedAddAccount";
    public static final int REQUEST_ADD_ACCOUNT = 2;
    public static final int REQUEST_CHOOSE_TYPE = 1;
    public static final int REQUEST_NULL = 0;
    private static final int SELECTED_ITEM_NONE = -1;
    private static final String TAG = "AccountChooser";
    private ArrayList mAccounts;
    private Parcelable mExistingAccounts[];
    private Button mOkButton;
    private int mPendingRequest;
    private int mSelectedItemIndex;


/*
    static int access$002(ChooseTypeAndAccountActivity choosetypeandaccountactivity, int i) {
        choosetypeandaccountactivity.mSelectedItemIndex = i;
        return i;
    }

*/

}
