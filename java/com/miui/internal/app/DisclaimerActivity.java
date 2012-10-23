// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.miui.internal.app;

import android.app.ActivityManager;
import android.content.*;
import android.os.Bundle;
import android.text.*;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.android.internal.app.AlertActivity;
import java.util.HashSet;

// Referenced classes of package com.miui.internal.app:
//            MiuiLicenseActivity

public class DisclaimerActivity extends AlertActivity
    implements android.content.DialogInterface.OnClickListener {
    class IntentSpan extends ClickableSpan {

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.MIUI_LICENSE");
            intent.putExtra(MiuiLicenseActivity.EXTRA_MIUI_DOC_URL, mUrl);
            startActivity(intent);
        }

        public void updateDrawState(TextPaint textpaint) {
            textpaint.setUnderlineText(true);
            textpaint.setColor(0xff0000ff);
        }

        private String mUrl;
        final DisclaimerActivity this$0;

        public IntentSpan(String s) {
            this$0 = DisclaimerActivity.this;
            super();
            mUrl = s;
        }
    }


    public DisclaimerActivity() {
    }

    private void forceStopPackage() {
        if(!TextUtils.isEmpty(mStopPackageName))
            ((ActivityManager)getSystemService("activity")).forceStopPackage(mStopPackageName);
    }

    public static boolean requestApproval(Context context, String s) {
        boolean flag = true;
        if(TextUtils.isEmpty(s) || !mPredefinePackages.contains(s) || android.provider.Settings.System.getInt(context.getContentResolver(), "confirm_miui_disclaimer", 0) == flag)
            flag = false;
        return flag;
    }

    public void onBackPressed() {
        setResult(0);
        forceStopPackage();
        finish();
        super.onBackPressed();
    }

    public void onClick(DialogInterface dialoginterface, int i) {
        if(i != -1) goto _L2; else goto _L1
_L1:
        android.provider.Settings.System.putInt(getContentResolver(), "confirm_miui_disclaimer", 1);
        setResult(1);
_L4:
        finish();
        return;
_L2:
        if(i == -2) {
            forceStopPackage();
            setResult(0);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(0x106000d);
        mStopPackageName = getIntent().getStringExtra("stop_package_name");
        String s = getString(0x60c0033);
        String s1 = getString(0x60c0034);
        String s2 = getString(0x60c0035);
        String s3 = getString(0x60c0036);
        String s4 = getString(0x60c0037);
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        spannablestringbuilder.append((new StringBuilder()).append(s).append(s1).append(s2).append(s3).append(s4).toString());
        spannablestringbuilder.setSpan(new IntentSpan(MiuiLicenseActivity.URL_MIUI_USER_AGREEMENT), s.length(), s.length() + s1.length(), 33);
        spannablestringbuilder.setSpan(new IntentSpan(MiuiLicenseActivity.URL_MIUI_PRIVACY_POLICY), s.length() + s1.length() + s2.length(), s.length() + s1.length() + s2.length() + s3.length(), 33);
        com.android.internal.app.AlertController.AlertParams alertparams = super.mAlertParams;
        alertparams.mIconId = 0x108009b;
        alertparams.mMessage = spannablestringbuilder;
        alertparams.mPositiveButtonText = getString(0x104000a);
        alertparams.mPositiveButtonListener = this;
        alertparams.mNegativeButtonText = getString(0x1040000);
        alertparams.mNegativeButtonListener = this;
        setupAlert();
        ((TextView)getWindow().findViewById(0x102000b)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static final String STOP_PACKAGE_NAME = "stop_package_name";
    private static HashSet mPredefinePackages;
    static final String sPredefinedPackage[];
    public String mStopPackageName;

    static  {
        String as[] = new String[4];
        as[0] = "com.miui.player";
        as[1] = "com.xiaomi.market";
        as[2] = "com.miui.backup";
        as[3] = "com.android.updater";
        sPredefinedPackage = as;
        mPredefinePackages = new HashSet(sPredefinedPackage.length);
        String as1[] = sPredefinedPackage;
        int i = as1.length;
        for(int j = 0; j < i; j++) {
            String s = as1[j];
            mPredefinePackages.add(s);
        }

    }
}
