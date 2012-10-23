// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;

public class AudioManagerHelper {

    public AudioManagerHelper() {
    }

    public static void amendVibratePrefs(Context context) {
        amendVibratePrefsByRingerMode(context);
        amendVibratePrefsByVibrate(context, 1);
        amendVibratePrefsByVibrate(context, 0);
    }

    public static void amendVibratePrefsByRingerMode(Context context) {
        int i = ((AudioManager)context.getSystemService("audio")).getRingerMode();
        if(i != 0) goto _L2; else goto _L1
_L1:
        updatePrefIfChanged(context.getContentResolver(), "vibrate_in_silent", 0);
_L4:
        return;
_L2:
        if(i == 1)
            updatePrefIfChanged(context.getContentResolver(), "vibrate_in_silent", 1);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static void amendVibratePrefsByVibrate(Context context, int i) {
        ContentResolver contentresolver;
        String s;
        contentresolver = context.getContentResolver();
        AudioManager audiomanager = (AudioManager)context.getSystemService("audio");
        if(i == 0)
            s = "vibrate_ringer";
        else
            s = "vibrate_notification";
        audiomanager.getVibrateSetting(i);
        JVM INSTR tableswitch 0 2: default 56
    //                   0 64
    //                   1 96
    //                   2 113;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if(android.provider.Settings.System.getInt(contentresolver, "vibrate_in_silent", 1) == 1 || android.provider.Settings.System.getInt(contentresolver, "vibrate_in_normal", 0) == 1)
            updatePrefIfChanged(contentresolver, s, 0);
        continue; /* Loop/switch isn't completed */
_L3:
        updatePrefIfChanged(contentresolver, "vibrate_in_normal", 1);
        updatePrefIfChanged(contentresolver, s, 1);
        continue; /* Loop/switch isn't completed */
_L4:
        updatePrefIfChanged(contentresolver, "vibrate_in_silent", 1);
        updatePrefIfChanged(contentresolver, "vibrate_in_normal", 0);
        updatePrefIfChanged(contentresolver, s, 1);
        if(true) goto _L1; else goto _L5
_L5:
    }

    public static boolean isSilentEnabled(Context context) {
        boolean flag;
        if(((AudioManager)context.getSystemService("audio")).getRingerMode() != 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isVibrateEnabled(Context context) {
        boolean flag;
        AudioManager audiomanager;
        int i;
        flag = true;
        audiomanager = (AudioManager)context.getSystemService("audio");
        i = 0;
        audiomanager.getRingerMode();
        JVM INSTR tableswitch 0 2: default 44
    //                   0 77
    //                   1 82
    //                   2 87;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_87;
_L5:
        if(i == 0 || !miui.provider.ExtraSettings.System.isVibratePrefOn(context, "vibrate_ringer") && !miui.provider.ExtraSettings.System.isVibratePrefOn(context, "vibrate_notification") && !miui.provider.ExtraSettings.System.isVibratePrefOn(context, "vibrate_mms"))
            flag = false;
        return flag;
_L2:
        i = 0;
          goto _L5
_L3:
        i = 1;
          goto _L5
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "vibrate_in_normal", 0) == flag)
            i = ((flag) ? 1 : 0);
        else
            i = 0;
          goto _L5
    }

    public static void saveLastAudibleRingVolume(Context context, int i) {
        if(i > 0)
            android.provider.Settings.System.putInt(context.getContentResolver(), "last_audible_ring_volume", i);
    }

    public static void setRingerMode(Context context, int i) {
        AudioManager audiomanager = (AudioManager)context.getSystemService("audio");
        int j = audiomanager.getRingerMode();
        audiomanager.setRingerMode(i);
        if(i == 2 && j != 2) {
            int k = android.provider.Settings.System.getInt(context.getContentResolver(), "last_audible_ring_volume", 0);
            if(k > 0)
                audiomanager.setStreamVolume(2, k, 0);
        }
    }

    private static void setVibrateInternel(Context context, String s, int i, boolean flag, boolean flag1) {
        AudioManager audiomanager;
        boolean flag2;
        int j;
        audiomanager = (AudioManager)context.getSystemService("audio");
        flag2 = miui.provider.ExtraSettings.System.isVibratePrefOn(context, s);
        j = 0;
        if(!flag) goto _L2; else goto _L1
_L1:
        if(flag2)
            j = 1;
        else
            j = 0;
_L4:
        audiomanager.setVibrateSetting(i, j);
        return;
_L2:
        if(flag1)
            if(flag2)
                j = 2;
            else
                j = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean shouldVibrateForPref(Context context, String s) {
        int i;
        boolean flag;
        i = 1;
        flag = false;
        ((AudioManager)context.getSystemService("audio")).getRingerMode();
        JVM INSTR tableswitch 0 2: default 44
    //                   0 46
    //                   1 51
    //                   2 60;
           goto _L1 _L2 _L3 _L4
_L1:
        return flag;
_L2:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        flag = miui.provider.ExtraSettings.System.isVibratePrefOn(context, s);
        continue; /* Loop/switch isn't completed */
_L4:
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "vibrate_in_normal", 0) != i)
            i = 0;
        if(i != 0)
            flag = miui.provider.ExtraSettings.System.isVibratePrefOn(context, s);
        else
            flag = false;
        if(true) goto _L1; else goto _L5
_L5:
    }

    public static void toggleSilent(Context context) {
        boolean flag;
        if(!isSilentEnabled(context))
            flag = true;
        else
            flag = false;
        updateVibrateState(context, flag);
    }

    public static void toggleVibrate(Context context) {
        int i;
        int j;
        ContentResolver contentresolver;
        boolean flag;
        i = 1;
        AudioManager audiomanager = (AudioManager)context.getSystemService("audio");
        if(!isVibrateEnabled(context))
            j = i;
        else
            j = 0;
        contentresolver = context.getContentResolver();
        flag = false;
        audiomanager.getRingerMode();
        JVM INSTR tableswitch 0 2: default 60
    //                   0 72
    //                   1 72
    //                   2 96;
           goto _L1 _L2 _L2 _L3
_L1:
        updateVibrateState(context, flag);
        return;
_L2:
        if(j == 0)
            i = 0;
        android.provider.Settings.System.putInt(contentresolver, "vibrate_in_silent", i);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L3:
        if(j == 0)
            i = 0;
        android.provider.Settings.System.putInt(contentresolver, "vibrate_in_normal", i);
        if(true) goto _L1; else goto _L4
_L4:
    }

    private static void updatePrefIfChanged(ContentResolver contentresolver, String s, int i) {
        if(android.provider.Settings.System.getInt(contentresolver, s, -i) != i)
            android.provider.Settings.System.putInt(contentresolver, s, i);
    }

    public static void updateVibrateState(Context context, boolean flag) {
        ContentResolver contentresolver = context.getContentResolver();
        boolean flag1;
        boolean flag2;
        byte byte0;
        if(android.provider.Settings.System.getInt(contentresolver, "vibrate_in_silent", 1) == 1)
            flag1 = true;
        else
            flag1 = false;
        if(android.provider.Settings.System.getInt(contentresolver, "vibrate_in_normal", 0) == 1)
            flag2 = true;
        else
            flag2 = false;
        byte0 = 2;
        if(flag)
            if(flag1)
                byte0 = 1;
            else
                byte0 = 0;
        setRingerMode(context, byte0);
        setVibrateInternel(context, "vibrate_ringer", 0, flag2, flag1);
        setVibrateInternel(context, "vibrate_notification", 1, flag2, flag1);
    }
}
