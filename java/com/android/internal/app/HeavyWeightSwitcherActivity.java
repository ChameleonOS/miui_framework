// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.app.*;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class HeavyWeightSwitcherActivity extends Activity {

    public HeavyWeightSwitcherActivity() {
        mSwitchOldListener = new android.view.View.OnClickListener() {

            public void onClick(View view) {
                try {
                    ActivityManagerNative.getDefault().moveTaskToFront(mCurTask, 0, null);
                }
                catch(RemoteException remoteexception) { }
                finish();
            }

            final HeavyWeightSwitcherActivity this$0;

             {
                this$0 = HeavyWeightSwitcherActivity.this;
                super();
            }
        };
        mSwitchNewListener = new android.view.View.OnClickListener() {

            public void onClick(View view) {
                try {
                    ActivityManagerNative.getDefault().finishHeavyWeightApp();
                }
                catch(RemoteException remoteexception) { }
                if(!mHasResult) goto _L2; else goto _L1
_L1:
                startIntentSenderForResult(mStartIntent, -1, null, 0x2000000, 0x2000000, 0);
_L4:
                finish();
                return;
_L2:
                try {
                    startIntentSenderForResult(mStartIntent, -1, null, 0, 0, 0);
                }
                catch(android.content.IntentSender.SendIntentException sendintentexception) {
                    Log.w("HeavyWeightSwitcherActivity", "Failure starting", sendintentexception);
                }
                if(true) goto _L4; else goto _L3
_L3:
            }

            final HeavyWeightSwitcherActivity this$0;

             {
                this$0 = HeavyWeightSwitcherActivity.this;
                super();
            }
        };
        mCancelListener = new android.view.View.OnClickListener() {

            public void onClick(View view) {
                finish();
            }

            final HeavyWeightSwitcherActivity this$0;

             {
                this$0 = HeavyWeightSwitcherActivity.this;
                super();
            }
        };
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(3);
        mStartIntent = (IntentSender)getIntent().getParcelableExtra("intent");
        mHasResult = getIntent().getBooleanExtra("has_result", false);
        mCurApp = getIntent().getStringExtra("cur_app");
        mCurTask = getIntent().getIntExtra("cur_task", 0);
        mNewApp = getIntent().getStringExtra("new_app");
        setContentView(0x1090044);
        setIconAndText(0x1020284, 0x1020285, 0x1020286, mCurApp, 0x10403eb, 0x10403ec);
        setIconAndText(0x1020288, 0x1020289, 0x102028a, mNewApp, 0x10403ed, 0x10403ee);
        findViewById(0x1020283).setOnClickListener(mSwitchOldListener);
        findViewById(0x1020287).setOnClickListener(mSwitchNewListener);
        findViewById(0x1020269).setOnClickListener(mCancelListener);
        TypedValue typedvalue = new TypedValue();
        getTheme().resolveAttribute(0x1010355, typedvalue, true);
        getWindow().setFeatureDrawableResource(3, typedvalue.resourceId);
    }

    void setDrawable(int i, Drawable drawable) {
        if(drawable != null)
            ((ImageView)findViewById(i)).setImageDrawable(drawable);
    }

    void setIconAndText(int i, int j, int k, String s, int l, int i1) {
        Object obj;
        Drawable drawable;
        obj = "";
        drawable = null;
        if(mCurApp == null)
            break MISSING_BLOCK_LABEL_52;
        Drawable drawable1;
        ApplicationInfo applicationinfo = getPackageManager().getApplicationInfo(s, 0);
        obj = applicationinfo.loadLabel(getPackageManager());
        drawable1 = applicationinfo.loadIcon(getPackageManager());
        drawable = drawable1;
_L2:
        setDrawable(i, drawable);
        Object aobj[] = new Object[1];
        aobj[0] = obj;
        setText(j, getString(l, aobj));
        setText(k, getText(i1));
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    void setText(int i, CharSequence charsequence) {
        ((TextView)findViewById(i)).setText(charsequence);
    }

    public static final String KEY_CUR_APP = "cur_app";
    public static final String KEY_CUR_TASK = "cur_task";
    public static final String KEY_HAS_RESULT = "has_result";
    public static final String KEY_INTENT = "intent";
    public static final String KEY_NEW_APP = "new_app";
    private android.view.View.OnClickListener mCancelListener;
    String mCurApp;
    int mCurTask;
    boolean mHasResult;
    String mNewApp;
    IntentSender mStartIntent;
    private android.view.View.OnClickListener mSwitchNewListener;
    private android.view.View.OnClickListener mSwitchOldListener;
}
