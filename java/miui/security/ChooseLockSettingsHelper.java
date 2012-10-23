// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.security;

import android.app.*;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package miui.security:
//            MiuiLockPatternUtils

public final class ChooseLockSettingsHelper {

    public ChooseLockSettingsHelper(Activity activity) {
        this(((Context) (activity)));
        mActivity = activity;
    }

    public ChooseLockSettingsHelper(Activity activity, Fragment fragment) {
        this(activity);
        mFragment = fragment;
    }

    public ChooseLockSettingsHelper(Context context) {
        mContext = context;
        mLockPatternUtils = new MiuiLockPatternUtils(mContext);
    }

    private boolean confirmPassword(int i) {
        if(mLockPatternUtils.isLockPasswordEnabled()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        Intent intent;
        intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.ConfirmLockPassword");
        if(i != -1024)
            break; /* Loop/switch isn't completed */
        intent.setFlags(0x10000000);
        mContext.startActivity(intent);
_L5:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
        if(mFragment != null)
            mFragment.startActivityForResult(intent, i);
        else
            mActivity.startActivityForResult(intent, i);
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    private boolean confirmPattern(int i, CharSequence charsequence, CharSequence charsequence1) {
        if(mLockPatternUtils.isLockPatternEnabled() && mLockPatternUtils.savedPatternExists()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        Intent intent;
        intent = new Intent();
        intent.putExtra("com.android.settings.ConfirmLockPattern.header", charsequence);
        intent.putExtra("com.android.settings.ConfirmLockPattern.footer", charsequence1);
        intent.setClassName("com.android.settings", "com.android.settings.ConfirmLockPattern");
        if(i != -1024)
            break; /* Loop/switch isn't completed */
        intent.setFlags(0x10000000);
        mContext.startActivity(intent);
_L5:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
        if(mFragment != null)
            mFragment.startActivityForResult(intent, i);
        else
            mActivity.startActivityForResult(intent, i);
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    public boolean isACLockEnabled() {
        boolean flag = true;
        if(flag != android.provider.Settings.Secure.getInt(mContext.getContentResolver(), "access_control_lock_enabled", 0) || !mLockPatternUtils.savedAccessControlExists())
            flag = false;
        return flag;
    }

    public boolean isPasswordForPrivacyModeEnabled() {
        boolean flag = true;
        if(flag != android.provider.Settings.Secure.getInt(mContext.getContentResolver(), "password_for_privacymode", 0))
            flag = false;
        return flag;
    }

    public boolean isPrivacyModeEnabled() {
        boolean flag = true;
        if(flag != android.provider.Settings.Secure.getInt(mContext.getContentResolver(), "privacy_mode_enabled", 0))
            flag = false;
        return flag;
    }

    public boolean launchConfirmationActivity(int i, CharSequence charsequence, CharSequence charsequence1) {
        if(mActivity != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = false;
        switch(mLockPatternUtils.getKeyguardStoredPasswordQuality()) {
        case 65536: 
            flag = confirmPattern(i, charsequence, charsequence1);
            break;

        case 131072: 
        case 262144: 
        case 327680: 
        case 393216: 
            flag = confirmPassword(i);
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean launchConfirmationActivity(CharSequence charsequence, CharSequence charsequence1) {
        boolean flag = false;
        mLockPatternUtils.getKeyguardStoredPasswordQuality();
        JVM INSTR lookupswitch 5: default 60
    //                   65536: 62
    //                   131072: 75
    //                   262144: 75
    //                   327680: 75
    //                   393216: 75;
           goto _L1 _L2 _L3 _L3 _L3 _L3
_L1:
        return flag;
_L2:
        flag = confirmPattern(-1024, charsequence, charsequence1);
        continue; /* Loop/switch isn't completed */
_L3:
        flag = confirmPassword(-1024);
        if(true) goto _L1; else goto _L4
_L4:
    }

    public void setACLockEnabled(boolean flag) {
        android.content.ContentResolver contentresolver = mContext.getContentResolver();
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        android.provider.Settings.Secure.putInt(contentresolver, "access_control_lock_enabled", i);
        if(!flag)
            mLockPatternUtils.saveACLockPattern(null);
    }

    public void setPasswordForPrivacyModeEnabled(boolean flag) {
        android.content.ContentResolver contentresolver = mContext.getContentResolver();
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        android.provider.Settings.Secure.putInt(contentresolver, "password_for_privacymode", i);
    }

    public void setPrivacyModeEnabled(boolean flag) {
        android.content.ContentResolver contentresolver = mContext.getContentResolver();
        int i;
        Intent intent;
        if(flag)
            i = 1;
        else
            i = 0;
        android.provider.Settings.Secure.putInt(contentresolver, "privacy_mode_enabled", i);
        intent = new Intent("android.intent.action.PRIVACY_MODE_CHANGED");
        intent.putExtra("privacy_mode_enabled", flag);
        mContext.sendBroadcast(intent);
        ((ActivityManager)mContext.getSystemService("activity")).forceStopPackage("com.android.gallery3d");
    }

    public MiuiLockPatternUtils utils() {
        return mLockPatternUtils;
    }

    public static final int DISABLE_ACCESS_CONTROL = 1;
    public static final int DISABLE_AC_FOR_PRIVACY_MODE = 3;
    public static final int DISABLE_PRIVACY_MODE = 4;
    public static final int ENABLE_AC_FOR_PRIVACY_MODE = 2;
    public static final String EXTRA_CONFIRM_PURPOSE = "confirm_purpose";
    public static final String EXTRA_KEY_PASSWORD = "password";
    public static final String FOOTER_TEXT = "com.android.settings.ConfirmLockPattern.footer";
    public static final String FOOTER_WRONG_TEXT = "com.android.settings.ConfirmLockPattern.footer_wrong";
    public static final String HEADER_TEXT = "com.android.settings.ConfirmLockPattern.header";
    public static final String HEADER_WRONG_TEXT = "com.android.settings.ConfirmLockPattern.header_wrong";
    private static final int NO_REQUEST_FOR_ACTIVITY_RESULT = -1024;
    private Activity mActivity;
    private Context mContext;
    private Fragment mFragment;
    private MiuiLockPatternUtils mLockPatternUtils;
}
