// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import miui.util.CommandLineUtils;

public class ExtraRingtoneManager {
    static class RingtoneItem {

        Uri mActualDefaultRingtoneUri;
        Uri mDefaultRingtoneUri;
        int mRingtoneType;
        String mSettingType;

        public RingtoneItem(int i, Uri uri, Uri uri1, String s) {
            mRingtoneType = i;
            mActualDefaultRingtoneUri = uri;
            mDefaultRingtoneUri = uri1;
            mSettingType = s;
        }
    }


    private ExtraRingtoneManager() {
    }

    private static void addRingtoneItem(int i, String s, Uri uri, String s1) {
        RingtoneItem ringtoneitem = new RingtoneItem(i, Uri.withAppendedPath(ACTUAL_DEFAULT_RINGTONE_BASE_URI, s), uri, s1);
        sRingtoneList.add(ringtoneitem);
    }

    public static void copyRingtone(String s, int i) {
        if(!TextUtils.isEmpty(s)) {
            String s1 = ACTUAL_DEFAULT_RINGTONE_BASE_URI.getPath();
            if(!(new File(s1)).exists())
                CommandLineUtils.mkdir(s1, "root");
            CommandLineUtils.chmod(s1, "755", "root");
            String s2 = getDefaultRingtoneUri(i).getPath();
            CommandLineUtils.cp(s, s2, "root");
            CommandLineUtils.chmod(s2, "644", "root");
        }
    }

    public static Uri getDefaultRingtoneUri(int i) {
        Iterator iterator = sRingtoneList.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        RingtoneItem ringtoneitem = (RingtoneItem)iterator.next();
        if((i & ringtoneitem.mRingtoneType) == 0) goto _L4; else goto _L3
_L3:
        Uri uri = ringtoneitem.mActualDefaultRingtoneUri;
_L6:
        return uri;
_L2:
        uri = null;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static Uri getRingtoneUri(Context context, int i) {
        Uri uri;
        String s;
        uri = null;
        s = getSettingForType(i);
        if(s != null) goto _L2; else goto _L1
_L1:
        return uri;
_L2:
        String s1 = android.provider.Settings.System.getString(context.getContentResolver(), s);
        if(s1 != null)
            uri = Uri.parse(s1);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static String getSettingForType(int i) {
        Iterator iterator = sRingtoneList.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        RingtoneItem ringtoneitem = (RingtoneItem)iterator.next();
        if((i & ringtoneitem.mRingtoneType) == 0) goto _L4; else goto _L3
_L3:
        String s = ringtoneitem.mSettingType;
_L6:
        return s;
_L2:
        s = null;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static Uri getUriForExtraCases(Uri uri, int i) {
        if(isExtraCases(uri)) {
            Uri uri1 = getDefaultRingtoneUri(i);
            if((new File(uri1.getPath())).exists())
                uri = uri1;
        }
        return uri;
    }

    public static boolean isExtraCases(Uri uri) {
        return "file".equals(uri.getScheme());
    }

    public static Uri resolveDefaultRingtoneUri(Context context, int i, Uri uri) {
        if(uri != null) goto _L2; else goto _L1
_L1:
        Uri uri1 = uri;
_L4:
        return uri1;
_L2:
        String s;
        s = "";
        if(!"media".equals(uri.getAuthority()))
            break; /* Loop/switch isn't completed */
        s = resolveRingtonePath(context, uri);
        uri = Uri.fromFile(new File(s));
_L6:
        copyRingtone(s, i);
        uri1 = uri;
        if(true) goto _L4; else goto _L3
_L3:
        if(!"file".equals(uri.getScheme())) goto _L6; else goto _L5
_L5:
        s = uri.getPath();
          goto _L6
    }

    public static String resolveRingtonePath(Context context, Uri uri) {
        ContentResolver contentresolver = context.getContentResolver();
        String as[] = new String[1];
        as[0] = "_data";
        Cursor cursor = contentresolver.query(uri, as, null, null, null);
        String s = null;
        if(cursor != null && cursor.moveToFirst()) {
            s = cursor.getString(0);
            cursor.close();
        }
        return s;
    }

    public static void setRingtoneUri(Context context, int i, Uri uri) {
        String s = getSettingForType(i);
        if(s != null) {
            ContentResolver contentresolver = context.getContentResolver();
            String s1;
            if(uri != null)
                s1 = uri.toString();
            else
                s1 = null;
            android.provider.Settings.System.putString(contentresolver, s, s1);
        }
    }

    private static final Uri ACTUAL_DEFAULT_RINGTONE_BASE_URI = Uri.parse("file:///data/system/ringtones");
    private static final String TARGET_USER = "root";
    public static final int TYPE_MUSIC = 32;
    public static final int TYPE_SMS_DELIVERED_SOUND = 8;
    public static final int TYPE_SMS_RECEIVED_SOUND = 16;
    private static ArrayList sRingtoneList = new ArrayList();

    static  {
        addRingtoneItem(1, "ringtone.mp3", android.provider.Settings.System.DEFAULT_RINGTONE_URI, "ringtone");
        addRingtoneItem(2, "notification.mp3", android.provider.Settings.System.DEFAULT_NOTIFICATION_URI, "notification_sound");
        addRingtoneItem(4, "alarm.mp3", android.provider.Settings.System.DEFAULT_ALARM_ALERT_URI, "alarm_alert");
        addRingtoneItem(8, "sms_delivered_sound.mp3", miui.provider.ExtraSettings.System.DEFAULT_SMS_DELIVERED_RINGTONE_URI, "sms_delivered_sound");
        addRingtoneItem(16, "sms_received_sound.mp3", miui.provider.ExtraSettings.System.DEFAULT_SMS_RECEIVED_RINGTONE_URI, "sms_received_sound");
    }
}
