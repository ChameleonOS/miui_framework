// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.location;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import com.android.internal.app.NetInitiatedActivity;
import com.android.internal.telephony.GsmAlphabet;
import java.io.UnsupportedEncodingException;

public class GpsNetInitiatedHandler {
    public static class GpsNiResponse {

        Bundle extras;
        int userResponse;

        public GpsNiResponse() {
        }
    }

    public static class GpsNiNotification {

        public int defaultResponse;
        public Bundle extras;
        public boolean needNotify;
        public boolean needVerify;
        public int niType;
        public int notificationId;
        public boolean privacyOverride;
        public String requestorId;
        public int requestorIdEncoding;
        public String text;
        public int textEncoding;
        public int timeout;

        public GpsNiNotification() {
        }
    }


    public GpsNetInitiatedHandler(Context context) {
        mPlaySounds = false;
        visible = true;
        mPopupImmediately = true;
        mContext = context;
        mLocationManager = (LocationManager)context.getSystemService("location");
    }

    static String decodeGSMPackedString(byte abyte0[]) {
        int i = abyte0.length;
        int j = (i * 8) / 7;
        if(i % 7 == 0 && i > 0 && abyte0[i - 1] >> 1 == 0)
            j--;
        String s = GsmAlphabet.gsm7BitPackedToString(abyte0, 0, j);
        if(s == null) {
            Log.e("GpsNetInitiatedHandler", "Decoding of GSM packed string failed");
            s = "";
        }
        return s;
    }

    private static String decodeString(String s, boolean flag, int i) {
        String s1;
        byte abyte0[];
        s1 = s;
        abyte0 = stringToByteArray(s, flag);
        i;
        JVM INSTR tableswitch -1 3: default 44
    //                   -1 112
    //                   0 80
    //                   1 85
    //                   2 94
    //                   3 103;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        Log.e("GpsNetInitiatedHandler", (new StringBuilder()).append("Unknown encoding ").append(i).append(" for NI text ").append(s).toString());
_L8:
        return s1;
_L3:
        s1 = s;
        continue; /* Loop/switch isn't completed */
_L4:
        s1 = decodeGSMPackedString(abyte0);
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = decodeUTF8String(abyte0);
        continue; /* Loop/switch isn't completed */
_L6:
        s1 = decodeUCS2String(abyte0);
        continue; /* Loop/switch isn't completed */
_L2:
        s1 = s;
        if(true) goto _L8; else goto _L7
_L7:
    }

    static String decodeUCS2String(byte abyte0[]) {
        String s;
        try {
            s = new String(abyte0, "UTF-16");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new AssertionError();
        }
        return s;
    }

    static String decodeUTF8String(byte abyte0[]) {
        String s;
        try {
            s = new String(abyte0, "UTF-8");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new AssertionError();
        }
        return s;
    }

    private static String getDialogMessage(GpsNiNotification gpsninotification, Context context) {
        return getNotifMessage(gpsninotification, context);
    }

    public static String getDialogTitle(GpsNiNotification gpsninotification, Context context) {
        return getNotifTitle(gpsninotification, context);
    }

    private Intent getDlgIntent(GpsNiNotification gpsninotification) {
        Intent intent = new Intent();
        String s = getDialogTitle(gpsninotification, mContext);
        String s1 = getDialogMessage(gpsninotification, mContext);
        intent.setFlags(0x10000000);
        intent.setClass(mContext, com/android/internal/app/NetInitiatedActivity);
        intent.putExtra("notif_id", gpsninotification.notificationId);
        intent.putExtra("title", s);
        intent.putExtra("message", s1);
        intent.putExtra("timeout", gpsninotification.timeout);
        intent.putExtra("default_resp", gpsninotification.defaultResponse);
        Log.d("GpsNetInitiatedHandler", (new StringBuilder()).append("generateIntent, title: ").append(s).append(", message: ").append(s1).append(", timeout: ").append(gpsninotification.timeout).toString());
        return intent;
    }

    private static String getNotifMessage(GpsNiNotification gpsninotification, Context context) {
        String s = context.getString(0x104049e);
        Object aobj[] = new Object[2];
        aobj[0] = decodeString(gpsninotification.requestorId, mIsHexInput, gpsninotification.requestorIdEncoding);
        aobj[1] = decodeString(gpsninotification.text, mIsHexInput, gpsninotification.textEncoding);
        return String.format(s, aobj);
    }

    private static String getNotifTicker(GpsNiNotification gpsninotification, Context context) {
        String s = context.getString(0x104049c);
        Object aobj[] = new Object[2];
        aobj[0] = decodeString(gpsninotification.requestorId, mIsHexInput, gpsninotification.requestorIdEncoding);
        aobj[1] = decodeString(gpsninotification.text, mIsHexInput, gpsninotification.textEncoding);
        return String.format(s, aobj);
    }

    private static String getNotifTitle(GpsNiNotification gpsninotification, Context context) {
        return String.format(context.getString(0x104049d), new Object[0]);
    }

    private void openNiDialog(GpsNiNotification gpsninotification) {
        Intent intent = getDlgIntent(gpsninotification);
        Log.d("GpsNetInitiatedHandler", (new StringBuilder()).append("openNiDialog, notifyId: ").append(gpsninotification.notificationId).append(", requestorId: ").append(gpsninotification.requestorId).append(", text: ").append(gpsninotification.text).toString());
        mContext.startActivity(intent);
    }

    /**
     * @deprecated Method setNiNotification is deprecated
     */

    private void setNiNotification(GpsNiNotification gpsninotification) {
        this;
        JVM INSTR monitorenter ;
        NotificationManager notificationmanager = (NotificationManager)mContext.getSystemService("notification");
        if(notificationmanager != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        String s;
        String s1;
        s = getNotifTitle(gpsninotification, mContext);
        s1 = getNotifMessage(gpsninotification, mContext);
        Log.d("GpsNetInitiatedHandler", (new StringBuilder()).append("setNiNotification, notifyId: ").append(gpsninotification.notificationId).append(", title: ").append(s).append(", message: ").append(s1).toString());
        if(mNiNotification == null) {
            mNiNotification = new Notification();
            mNiNotification.icon = 0x1080540;
            mNiNotification.when = 0L;
        }
        if(!mPlaySounds) goto _L4; else goto _L3
_L3:
        Notification notification1 = mNiNotification;
        notification1.defaults = 1 | notification1.defaults;
_L5:
        Intent intent;
        mNiNotification.flags = 18;
        mNiNotification.tickerText = getNotifTicker(gpsninotification, mContext);
        if(mPopupImmediately)
            break MISSING_BLOCK_LABEL_271;
        intent = getDlgIntent(gpsninotification);
_L6:
        PendingIntent pendingintent = PendingIntent.getBroadcast(mContext, 0, intent, 0);
        mNiNotification.setLatestEventInfo(mContext, s, s1, pendingintent);
        if(!visible)
            break MISSING_BLOCK_LABEL_283;
        notificationmanager.notify(gpsninotification.notificationId, mNiNotification);
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L4:
        Notification notification = mNiNotification;
        notification.defaults = -2 & notification.defaults;
          goto _L5
        intent = new Intent();
          goto _L6
        notificationmanager.cancel(gpsninotification.notificationId);
          goto _L1
    }

    static byte[] stringToByteArray(String s, boolean flag) {
        int i;
        byte abyte0[];
        if(flag)
            i = s.length() / 2;
        else
            i = s.length();
        abyte0 = new byte[i];
        if(flag) {
            for(int k = 0; k < i; k++)
                abyte0[k] = (byte)Integer.parseInt(s.substring(k * 2, 2 + k * 2), 16);

        } else {
            for(int j = 0; j < i; j++)
                abyte0[j] = (byte)s.charAt(j);

        }
        return abyte0;
    }

    public void handleNiNotification(GpsNiNotification gpsninotification) {
        Log.d("GpsNetInitiatedHandler", (new StringBuilder()).append("handleNiNotification notificationId: ").append(gpsninotification.notificationId).append(" requestorId: ").append(gpsninotification.requestorId).append(" text: ").append(gpsninotification.text).toString());
        if(gpsninotification.needNotify && gpsninotification.needVerify && mPopupImmediately)
            openNiDialog(gpsninotification);
        if(gpsninotification.needNotify && !gpsninotification.needVerify || gpsninotification.needNotify && gpsninotification.needVerify && !mPopupImmediately)
            setNiNotification(gpsninotification);
        if(gpsninotification.needNotify && !gpsninotification.needVerify || !gpsninotification.needNotify && !gpsninotification.needVerify || gpsninotification.privacyOverride)
            mLocationManager.sendNiResponse(gpsninotification.notificationId, 1);
    }

    public static final String ACTION_NI_VERIFY = "android.intent.action.NETWORK_INITIATED_VERIFY";
    private static final boolean DEBUG = true;
    public static final int GPS_ENC_NONE = 0;
    public static final int GPS_ENC_SUPL_GSM_DEFAULT = 1;
    public static final int GPS_ENC_SUPL_UCS2 = 3;
    public static final int GPS_ENC_SUPL_UTF8 = 2;
    public static final int GPS_ENC_UNKNOWN = -1;
    public static final int GPS_NI_NEED_NOTIFY = 1;
    public static final int GPS_NI_NEED_VERIFY = 2;
    public static final int GPS_NI_PRIVACY_OVERRIDE = 4;
    public static final int GPS_NI_RESPONSE_ACCEPT = 1;
    public static final int GPS_NI_RESPONSE_DENY = 2;
    public static final int GPS_NI_RESPONSE_NORESP = 3;
    public static final int GPS_NI_TYPE_UMTS_CTRL_PLANE = 3;
    public static final int GPS_NI_TYPE_UMTS_SUPL = 2;
    public static final int GPS_NI_TYPE_VOICE = 1;
    public static final String NI_EXTRA_CMD_NOTIF_ID = "notif_id";
    public static final String NI_EXTRA_CMD_RESPONSE = "response";
    public static final String NI_INTENT_KEY_DEFAULT_RESPONSE = "default_resp";
    public static final String NI_INTENT_KEY_MESSAGE = "message";
    public static final String NI_INTENT_KEY_NOTIF_ID = "notif_id";
    public static final String NI_INTENT_KEY_TIMEOUT = "timeout";
    public static final String NI_INTENT_KEY_TITLE = "title";
    public static final String NI_RESPONSE_EXTRA_CMD = "send_ni_response";
    private static final String TAG = "GpsNetInitiatedHandler";
    private static final boolean VERBOSE;
    private static boolean mIsHexInput = true;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private Notification mNiNotification;
    private boolean mPlaySounds;
    private boolean mPopupImmediately;
    private boolean visible;

}
