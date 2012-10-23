// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.accounts.Account;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

// Referenced classes of package android.content:
//            ContentResolver, Intent

public class SyncActivityTooManyDeletes extends Activity
    implements android.widget.AdapterView.OnItemClickListener {

    public SyncActivityTooManyDeletes() {
    }

    private void startSyncReallyDelete() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("deletions_override", true);
        bundle.putBoolean("force", true);
        bundle.putBoolean("expedited", true);
        bundle.putBoolean("upload", true);
        ContentResolver.requestSync(mAccount, mAuthority, bundle);
    }

    private void startSyncUndoDeletes() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("discard_deletions", true);
        bundle.putBoolean("force", true);
        bundle.putBoolean("expedited", true);
        bundle.putBoolean("upload", true);
        ContentResolver.requestSync(mAccount, mAuthority, bundle);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle1 = getIntent().getExtras();
        if(bundle1 == null) {
            finish();
        } else {
            mNumDeletes = bundle1.getLong("numDeletes");
            mAccount = (Account)bundle1.getParcelable("account");
            mAuthority = bundle1.getString("authority");
            mProvider = bundle1.getString("provider");
            CharSequence acharsequence[] = new CharSequence[3];
            acharsequence[0] = getResources().getText(0x10404a3);
            acharsequence[1] = getResources().getText(0x10404a4);
            acharsequence[2] = getResources().getText(0x10404a5);
            ArrayAdapter arrayadapter = new ArrayAdapter(this, 0x1090003, 0x1020014, acharsequence);
            ListView listview = new ListView(this);
            listview.setAdapter(arrayadapter);
            listview.setItemsCanFocus(true);
            listview.setOnItemClickListener(this);
            TextView textview = new TextView(this);
            String s = getResources().getText(0x10404a2).toString();
            Object aobj[] = new Object[3];
            aobj[0] = Long.valueOf(mNumDeletes);
            aobj[1] = mProvider;
            aobj[2] = mAccount.name;
            textview.setText(String.format(s, aobj));
            LinearLayout linearlayout = new LinearLayout(this);
            linearlayout.setOrientation(1);
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2, 0.0F);
            linearlayout.addView(textview, layoutparams);
            linearlayout.addView(listview, layoutparams);
            setContentView(linearlayout);
        }
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l) {
        if(i != 0) goto _L2; else goto _L1
_L1:
        startSyncReallyDelete();
_L4:
        finish();
        return;
_L2:
        if(i == 1)
            startSyncUndoDeletes();
        if(true) goto _L4; else goto _L3
_L3:
    }

    private Account mAccount;
    private String mAuthority;
    private long mNumDeletes;
    private String mProvider;
}
