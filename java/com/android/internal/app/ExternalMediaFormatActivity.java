// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.content.*;
import android.os.Bundle;
import android.util.Log;
import com.android.internal.os.storage.ExternalStorageFormatter;

// Referenced classes of package com.android.internal.app:
//            AlertActivity

public class ExternalMediaFormatActivity extends AlertActivity
    implements android.content.DialogInterface.OnClickListener {

    public ExternalMediaFormatActivity() {
        mStorageReceiver = new BroadcastReceiver() {

            public void onReceive(Context context, Intent intent) {
                String s = intent.getAction();
                Log.d("ExternalMediaFormatActivity", (new StringBuilder()).append("got action ").append(s).toString());
                if(s == "android.intent.action.MEDIA_REMOVED" || s == "android.intent.action.MEDIA_CHECKING" || s == "android.intent.action.MEDIA_MOUNTED" || s == "android.intent.action.MEDIA_SHARED")
                    finish();
            }

            final ExternalMediaFormatActivity this$0;

             {
                this$0 = ExternalMediaFormatActivity.this;
                super();
            }
        };
    }

    public void onClick(DialogInterface dialoginterface, int i) {
        if(i == -1) {
            Intent intent = new Intent("com.android.internal.os.storage.FORMAT_ONLY");
            intent.setComponent(ExternalStorageFormatter.COMPONENT_NAME);
            startService(intent);
        }
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("ExternalMediaFormatActivity", "onCreate!");
        AlertController.AlertParams alertparams = super.mAlertParams;
        alertparams.mIconId = 0x108008a;
        alertparams.mTitle = getString(0x1040441);
        alertparams.mMessage = getString(0x1040442);
        alertparams.mPositiveButtonText = getString(0x1040443);
        alertparams.mPositiveButtonListener = this;
        alertparams.mNegativeButtonText = getString(0x1040000);
        alertparams.mNegativeButtonListener = this;
        setupAlert();
    }

    protected void onPause() {
        super.onPause();
        unregisterReceiver(mStorageReceiver);
    }

    protected void onResume() {
        super.onResume();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentfilter.addAction("android.intent.action.MEDIA_CHECKING");
        intentfilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentfilter.addAction("android.intent.action.MEDIA_SHARED");
        registerReceiver(mStorageReceiver, intentfilter);
    }

    private static final int POSITIVE_BUTTON = -1;
    private BroadcastReceiver mStorageReceiver;
}
