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
import android.util.Log;
import android.view.*;
import android.widget.*;
import java.util.*;

// Referenced classes of package android.accounts:
//            AccountManager, AuthenticatorDescription

public class ChooseAccountTypeActivity extends Activity {
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
            viewholder.text.setText(((AuthInfo)mInfos.get(i)).name);
            viewholder.icon.setImageDrawable(((AuthInfo)mInfos.get(i)).drawable);
            return view;
        }

        private ArrayList mInfos;
        private LayoutInflater mLayoutInflater;

        public AccountArrayAdapter(Context context, int i, ArrayList arraylist) {
            super(context, i, arraylist);
            mInfos = arraylist;
            mLayoutInflater = (LayoutInflater)context.getSystemService("layout_inflater");
        }
    }

    private static class ViewHolder {

        ImageView icon;
        TextView text;

        private ViewHolder() {
        }

    }

    private static class AuthInfo {

        final AuthenticatorDescription desc;
        final Drawable drawable;
        final String name;

        AuthInfo(AuthenticatorDescription authenticatordescription, String s, Drawable drawable1) {
            desc = authenticatordescription;
            name = s;
            drawable = drawable1;
        }
    }


    public ChooseAccountTypeActivity() {
        mTypeToAuthenticatorInfo = new HashMap();
    }

    private void buildTypeToAuthDescriptionMap() {
        AuthenticatorDescription aauthenticatordescription[];
        int i;
        int j;
        aauthenticatordescription = AccountManager.get(this).getAuthenticatorTypes();
        i = aauthenticatordescription.length;
        j = 0;
_L2:
        AuthenticatorDescription authenticatordescription;
        String s;
        Drawable drawable;
        if(j >= i)
            break; /* Loop/switch isn't completed */
        authenticatordescription = aauthenticatordescription[j];
        s = null;
        drawable = null;
        String s1;
        Context context = createPackageContext(authenticatordescription.packageName, 0);
        drawable = context.getResources().getDrawable(authenticatordescription.iconId);
        CharSequence charsequence = context.getResources().getText(authenticatordescription.labelId);
        if(charsequence != null)
            s = charsequence.toString();
        s1 = charsequence.toString();
        s = s1;
_L3:
        AuthInfo authinfo = new AuthInfo(authenticatordescription, s, drawable);
        mTypeToAuthenticatorInfo.put(authenticatordescription.type, authinfo);
        j++;
        if(true) goto _L2; else goto _L1
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if(Log.isLoggable("AccountChooser", 5))
            Log.w("AccountChooser", (new StringBuilder()).append("No icon name for account type ").append(authenticatordescription.type).toString());
          goto _L3
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        if(Log.isLoggable("AccountChooser", 5))
            Log.w("AccountChooser", (new StringBuilder()).append("No icon resource for account type ").append(authenticatordescription.type).toString());
          goto _L3
_L1:
    }

    private void setResultAndFinish(String s) {
        Bundle bundle = new Bundle();
        bundle.putString("accountType", s);
        setResult(-1, (new Intent()).putExtras(bundle));
        if(Log.isLoggable("AccountChooser", 2))
            Log.v("AccountChooser", (new StringBuilder()).append("ChooseAccountTypeActivity.setResultAndFinish: selected account type ").append(s).toString());
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if(Log.isLoggable("AccountChooser", 2))
            Log.v("AccountChooser", (new StringBuilder()).append("ChooseAccountTypeActivity.onCreate(savedInstanceState=").append(bundle).append(")").toString());
        HashSet hashset = null;
        String as[] = getIntent().getStringArrayExtra("allowableAccountTypes");
        if(as != null) {
            hashset = new HashSet(as.length);
            int i = as.length;
            for(int j = 0; j < i; j++)
                hashset.add(as[j]);

        }
        buildTypeToAuthDescriptionMap();
        mAuthenticatorInfosToDisplay = new ArrayList(mTypeToAuthenticatorInfo.size());
        Iterator iterator = mTypeToAuthenticatorInfo.entrySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s = (String)entry.getKey();
            AuthInfo authinfo = (AuthInfo)entry.getValue();
            if(hashset == null || hashset.contains(s))
                mAuthenticatorInfosToDisplay.add(authinfo);
        } while(true);
        if(mAuthenticatorInfosToDisplay.isEmpty()) {
            Bundle bundle1 = new Bundle();
            bundle1.putString("errorMessage", "no allowable account types");
            setResult(-1, (new Intent()).putExtras(bundle1));
            finish();
        } else
        if(mAuthenticatorInfosToDisplay.size() == 1) {
            setResultAndFinish(((AuthInfo)mAuthenticatorInfosToDisplay.get(0)).desc.type);
        } else {
            setContentView(0x1090033);
            ListView listview = (ListView)findViewById(0x102000a);
            listview.setAdapter(new AccountArrayAdapter(this, 0x1090003, mAuthenticatorInfosToDisplay));
            listview.setChoiceMode(0);
            listview.setTextFilterEnabled(false);
            listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView adapterview, View view, int k, long l) {
                    setResultAndFinish(((AuthInfo)mAuthenticatorInfosToDisplay.get(k)).desc.type);
                }

                final ChooseAccountTypeActivity this$0;

             {
                this$0 = ChooseAccountTypeActivity.this;
                super();
            }
            });
        }
    }

    private static final String TAG = "AccountChooser";
    private ArrayList mAuthenticatorInfosToDisplay;
    private HashMap mTypeToAuthenticatorInfo;


}
