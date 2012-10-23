// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.*;
import android.widget.*;
import java.util.HashMap;

// Referenced classes of package android.accounts:
//            AccountManager, AuthenticatorDescription, AccountManagerResponse, Account

public class ChooseAccountActivity extends Activity {
    private static class AccountArrayAdapter extends ArrayAdapter {

        public View getView(int i, View view, ViewGroup viewgroup) {
            ViewHolder viewholder;
            if(view == null) {
                view = mLayoutInflater.inflate(0x1090032, null);
                viewholder = new ViewHolder();
                viewholder.text = (TextView)view.findViewById(0x102026b);
                viewholder.icon = (ImageView)view.findViewById(0x102026a);
                view.setTag(viewholder);
            } else {
                viewholder = (ViewHolder)view.getTag();
            }
            viewholder.text.setText(mInfos[i].name);
            viewholder.icon.setImageDrawable(mInfos[i].drawable);
            return view;
        }

        private AccountInfo mInfos[];
        private LayoutInflater mLayoutInflater;

        public AccountArrayAdapter(Context context, int i, AccountInfo aaccountinfo[]) {
            super(context, i, aaccountinfo);
            mInfos = aaccountinfo;
            mLayoutInflater = (LayoutInflater)context.getSystemService("layout_inflater");
        }
    }

    private static class ViewHolder {

        ImageView icon;
        TextView text;

        private ViewHolder() {
        }

    }

    private static class AccountInfo {

        final Drawable drawable;
        final String name;

        AccountInfo(String s, Drawable drawable1) {
            name = s;
            drawable = drawable1;
        }
    }


    public ChooseAccountActivity() {
        mAccounts = null;
        mAccountManagerResponse = null;
        mTypeToAuthDescription = new HashMap();
    }

    private void getAuthDescriptions() {
        AuthenticatorDescription aauthenticatordescription[] = AccountManager.get(this).getAuthenticatorTypes();
        int i = aauthenticatordescription.length;
        for(int j = 0; j < i; j++) {
            AuthenticatorDescription authenticatordescription = aauthenticatordescription[j];
            mTypeToAuthDescription.put(authenticatordescription.type, authenticatordescription);
        }

    }

    private Drawable getDrawableForType(String s) {
        Drawable drawable;
        drawable = null;
        if(!mTypeToAuthDescription.containsKey(s))
            break MISSING_BLOCK_LABEL_52;
        Drawable drawable1;
        AuthenticatorDescription authenticatordescription = (AuthenticatorDescription)mTypeToAuthDescription.get(s);
        drawable1 = createPackageContext(authenticatordescription.packageName, 0).getResources().getDrawable(authenticatordescription.iconId);
        drawable = drawable1;
_L2:
        return drawable;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if(Log.isLoggable("AccountManager", 5))
            Log.w("AccountManager", (new StringBuilder()).append("No icon name for account type ").append(s).toString());
        continue; /* Loop/switch isn't completed */
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        if(Log.isLoggable("AccountManager", 5))
            Log.w("AccountManager", (new StringBuilder()).append("No icon resource for account type ").append(s).toString());
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void finish() {
        if(mAccountManagerResponse != null)
            if(mResult != null)
                mAccountManagerResponse.onResult(mResult);
            else
                mAccountManagerResponse.onError(4, "canceled");
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mAccounts = getIntent().getParcelableArrayExtra("accounts");
        mAccountManagerResponse = (AccountManagerResponse)getIntent().getParcelableExtra("accountManagerResponse");
        if(mAccounts == null) {
            setResult(0);
            finish();
        } else {
            getAuthDescriptions();
            AccountInfo aaccountinfo[] = new AccountInfo[mAccounts.length];
            for(int i = 0; i < mAccounts.length; i++)
                aaccountinfo[i] = new AccountInfo(((Account)mAccounts[i]).name, getDrawableForType(((Account)mAccounts[i]).type));

            setContentView(0x1090031);
            ListView listview = (ListView)findViewById(0x102000a);
            listview.setAdapter(new AccountArrayAdapter(this, 0x1090003, aaccountinfo));
            listview.setChoiceMode(1);
            listview.setTextFilterEnabled(true);
            listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView adapterview, View view, int j, long l) {
                    onListItemClick((ListView)adapterview, view, j, l);
                }

                final ChooseAccountActivity this$0;

             {
                this$0 = ChooseAccountActivity.this;
                super();
            }
            });
        }
    }

    protected void onListItemClick(ListView listview, View view, int i, long l) {
        Account account = (Account)mAccounts[i];
        Log.d("AccountManager", (new StringBuilder()).append("selected account ").append(account).toString());
        Bundle bundle = new Bundle();
        bundle.putString("authAccount", account.name);
        bundle.putString("accountType", account.type);
        mResult = bundle;
        finish();
    }

    private static final String TAG = "AccountManager";
    private AccountManagerResponse mAccountManagerResponse;
    private Parcelable mAccounts[];
    private Bundle mResult;
    private HashMap mTypeToAuthDescription;
}
