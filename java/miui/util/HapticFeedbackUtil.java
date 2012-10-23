// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.*;
import android.text.TextUtils;
import android.util.Log;

// Referenced classes of package miui.util:
//            ResourceMapper

public class HapticFeedbackUtil {
    class SettingsObserver extends ContentObserver {

        void observe() {
            mContext.getContentResolver().registerContentObserver(android.provider.Settings.System.getUriFor("haptic_feedback_level"), false, this);
            updateSettings();
        }

        public void onChange(boolean flag) {
            updateSettings();
        }

        final HapticFeedbackUtil this$0;

        SettingsObserver(Handler handler) {
            this$0 = HapticFeedbackUtil.this;
            super(handler);
        }
    }


    public HapticFeedbackUtil(Context context, boolean flag) {
        mContext = context;
        mVibrator = new SystemVibrator();
        if(flag)
            updateSettings();
        else
            (new SettingsObserver(new Handler())).observe();
    }

    private static long[] getLongIntArray(Resources resources, int i) {
        int ai[] = resources.getIntArray(i);
        long al[];
        if(ai == null) {
            al = null;
        } else {
            al = new long[ai.length];
            int j = 0;
            while(j < ai.length)  {
                al[j] = ai[j];
                j++;
            }
        }
        return al;
    }

    private long[] loadHaptic(String s, int i) {
        String s1 = SystemProperties.get(s);
        long al[];
        if(TextUtils.isEmpty(s1))
            al = getLongIntArray(mContext.getResources(), i);
        else
            al = stringToLongArray(s1);
        return al;
    }

    private long[] stringToLongArray(String s) {
        long al[];
        if(s == null) {
            al = new long[1];
            al[0] = 0L;
        } else {
            String as[] = s.split(",");
            int i = as.length;
            al = new long[i];
            int j = 0;
            while(j < i)  {
                al[j] = Long.parseLong(as[j].trim());
                j++;
            }
        }
        return al;
    }

    public boolean isSupportedEffect(int i) {
        boolean flag;
        if(i <= 3)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean performHapticFeedback(int i, boolean flag) {
        boolean flag1;
        flag1 = false;
        boolean flag2;
        if(android.provider.Settings.System.getInt(mContext.getContentResolver(), "haptic_feedback_enabled", 0) == 0)
            flag2 = true;
        else
            flag2 = false;
        if(flag || !flag2) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        i;
        JVM INSTR tableswitch 0 3: default 68
    //                   0 71
    //                   1 99
    //                   2 117
    //                   3 108;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        continue; /* Loop/switch isn't completed */
_L4:
        long al[] = mLongPressVibePattern;
_L9:
        if(al != null && al.length != 0)
            break; /* Loop/switch isn't completed */
        Log.w("HapticFeedbackUtil", "vibrate: null or empty pattern");
        continue; /* Loop/switch isn't completed */
_L5:
        al = mVirtualKeyVibePattern;
        continue; /* Loop/switch isn't completed */
_L7:
        al = mKeyboardTapVibePattern;
        continue; /* Loop/switch isn't completed */
_L6:
        al = mVirtualKeyUpVibePattern;
        if(true) goto _L9; else goto _L8
_L8:
        if(!mVibrateEx)
            break; /* Loop/switch isn't completed */
        byte abyte0[] = new byte[al.length];
        for(int j = 0; j < al.length; j++)
            abyte0[j] = (byte)(int)al[j];

        mVibrator.vibrateEx(abyte0);
_L11:
        flag1 = true;
        if(true) goto _L1; else goto _L10
_L10:
        if(al.length == 1)
            mVibrator.vibrate(al[0]);
        else
            mVibrator.vibrate(al, -1);
          goto _L11
        if(true) goto _L1; else goto _L12
_L12:
    }

    public void updateSettings() {
        int i = Math.min(2, Math.max(0, android.provider.Settings.System.getInt(mContext.getContentResolver(), "haptic_feedback_level", 1)));
        mLongPressVibePattern = loadHaptic(LONG_PRESS_PATTERN_PROPERTY[i], ResourceMapper.resolveReference(mContext, 0x6060008));
        mVirtualKeyVibePattern = loadHaptic(VIRTUAL_DOWN_PATTERN_PROPERTY[i], ResourceMapper.resolveReference(mContext, 0x6060004));
        mKeyboardTapVibePattern = loadHaptic(KEYBOARD_TAP_PATTERN_PROPERTY[i], ResourceMapper.resolveReference(mContext, 0x6060009));
        mVirtualKeyUpVibePattern = loadHaptic(VIRTUAL_UP_PATTERN_PROPERTY[i], 0x6060002);
    }

    private static final String KEYBOARD_TAP_PATTERN_PROPERTY[];
    private static final String KEY_VIBRATE_EX_ENABLED = "ro.haptic.vibrate_ex.enabled";
    private static final String LONG_PRESS_PATTERN_PROPERTY[];
    private static final String TAG = "HapticFeedbackUtil";
    private static final String VIRTUAL_DOWN_PATTERN_PROPERTY[];
    private static final String VIRTUAL_UP_PATTERN_PROPERTY[];
    private final Context mContext;
    private long mKeyboardTapVibePattern[];
    private long mLongPressVibePattern[];
    private final boolean mVibrateEx = SystemProperties.getBoolean("ro.haptic.vibrate_ex.enabled", false);
    private Vibrator mVibrator;
    private long mVirtualKeyUpVibePattern[];
    private long mVirtualKeyVibePattern[];

    static  {
        String as[] = new String[3];
        as[0] = "sys.haptic.long.weak";
        as[1] = "sys.haptic.long.normal";
        as[2] = "sys.haptic.long.strong";
        LONG_PRESS_PATTERN_PROPERTY = as;
        String as1[] = new String[3];
        as1[0] = "sys.haptic.tap.weak";
        as1[1] = "sys.haptic.tap.normal";
        as1[2] = "sys.haptic.tap.strong";
        KEYBOARD_TAP_PATTERN_PROPERTY = as1;
        String as2[] = new String[3];
        as2[0] = "sys.haptic.down.weak";
        as2[1] = "sys.haptic.down.normal";
        as2[2] = "sys.haptic.down.strong";
        VIRTUAL_DOWN_PATTERN_PROPERTY = as2;
        String as3[] = new String[3];
        as3[0] = "sys.haptic.up.weak";
        as3[1] = "sys.haptic.up.normal";
        as3[2] = "sys.haptic.up.strong";
        VIRTUAL_UP_PATTERN_PROPERTY = as3;
    }

}
