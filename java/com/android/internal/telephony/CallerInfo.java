// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Country;
import android.location.CountryDetector;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import java.util.Locale;
import miui.telephony.ExtraCallerInfo;

public class CallerInfo {

    public CallerInfo() {
        extra = new ExtraCallerInfo();
        mIsEmergency = false;
        mIsVoiceMail = false;
    }

    static CallerInfo doSecondaryLookupIfNecessary(Context context, String s, CallerInfo callerinfo) {
        if(!callerinfo.contactExists && PhoneNumberUtils.isUriNumber(s)) {
            String s1 = PhoneNumberUtils.getUsernameFromUriNumber(s);
            if(PhoneNumberUtils.isGlobalPhoneNumber(s1))
                callerinfo = getCallerInfo(context, Uri.withAppendedPath(android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(s1)));
        }
        return callerinfo;
    }

    public static String getCallerId(Context context, String s) {
        CallerInfo callerinfo = getCallerInfo(context, s);
        String s1 = null;
        if(callerinfo != null) {
            String s2 = callerinfo.name;
            if(!TextUtils.isEmpty(s2))
                s1 = s2;
            else
                s1 = s;
        }
        return s1;
    }

    public static CallerInfo getCallerInfo(Context context, Uri uri) {
        return getCallerInfo(context, uri, context.getContentResolver().query(uri, null, null, null, null));
    }

    public static CallerInfo getCallerInfo(Context context, Uri uri, Cursor cursor) {
        CallerInfo callerinfo = new CallerInfo();
        callerinfo.photoResource = 0;
        callerinfo.phoneLabel = null;
        callerinfo.numberType = 0;
        callerinfo.numberLabel = null;
        callerinfo.cachedPhoto = null;
        callerinfo.isCachedPhotoCurrent = false;
        callerinfo.contactExists = false;
        if(VDBG)
            Log.v("CallerInfo", "getCallerInfo() based on cursor...");
        if(cursor != null) {
            if(cursor.moveToFirst()) {
                int i = cursor.getColumnIndex("display_name");
                if(i != -1)
                    callerinfo.name = cursor.getString(i);
                int j = miui.telephony.CallerInfo.getColumnIndex(uri, "number", cursor);
                if(j != -1)
                    callerinfo.phoneNumber = cursor.getString(j);
                int k = miui.telephony.CallerInfo.getColumnIndex(uri, "normalized_number", cursor);
                if(k != -1)
                    callerinfo.normalizedNumber = cursor.getString(k);
                int l = miui.telephony.CallerInfo.getColumnIndex(uri, "label", cursor);
                if(l != -1) {
                    int l1 = miui.telephony.CallerInfo.getColumnIndex(uri, "type", cursor);
                    if(l1 != -1) {
                        callerinfo.numberType = cursor.getInt(l1);
                        callerinfo.numberLabel = cursor.getString(l);
                        callerinfo.phoneLabel = android.provider.ContactsContract.CommonDataKinds.Phone.getDisplayLabel(context, callerinfo.numberType, callerinfo.numberLabel).toString();
                    }
                }
                int i1 = getColumnIndexForPersonId(uri, cursor);
                int j1;
                int k1;
                boolean flag;
                if(i1 != -1) {
                    callerinfo.person_id = cursor.getLong(i1);
                    if(VDBG)
                        Log.v("CallerInfo", (new StringBuilder()).append("==> got info.person_id: ").append(callerinfo.person_id).toString());
                } else {
                    Log.w("CallerInfo", (new StringBuilder()).append("Couldn't find person_id column for ").append(uri).toString());
                }
                j1 = cursor.getColumnIndex("custom_ringtone");
                if(j1 != -1 && cursor.getString(j1) != null)
                    callerinfo.contactRingtoneUri = Uri.parse(cursor.getString(j1));
                else
                    callerinfo.contactRingtoneUri = null;
                k1 = cursor.getColumnIndex("send_to_voicemail");
                if(k1 != -1 && cursor.getInt(k1) == 1)
                    flag = true;
                else
                    flag = false;
                callerinfo.shouldSendToVoicemail = flag;
                callerinfo.contactExists = true;
                callerinfo.extra = ExtraCallerInfo.getExtraCallerInfo(context, callerinfo, cursor);
            }
            cursor.close();
        }
        callerinfo.needUpdate = false;
        callerinfo.name = normalize(callerinfo.name);
        callerinfo.contactRefUri = uri;
        return callerinfo;
    }

    public static CallerInfo getCallerInfo(Context context, String s) {
        if(VDBG)
            Log.v("CallerInfo", "getCallerInfo() based on number...");
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        CallerInfo callerinfo = null;
_L4:
        return callerinfo;
_L2:
        if(PhoneNumberUtils.isLocalEmergencyNumber(s, context))
            callerinfo = (new CallerInfo()).markAsEmergency(context);
        else
        if(PhoneNumberUtils.isVoiceMailNumber(s)) {
            callerinfo = (new CallerInfo()).markAsVoiceMail();
        } else {
            callerinfo = doSecondaryLookupIfNecessary(context, s, getCallerInfo(context, Uri.withAppendedPath(android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(s))));
            if(TextUtils.isEmpty(callerinfo.phoneNumber))
                callerinfo.phoneNumber = s;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static int getColumnIndexForPersonId(Uri uri, Cursor cursor) {
        if(VDBG)
            Log.v("CallerInfo", (new StringBuilder()).append("- getColumnIndexForPersonId: contactRef URI = '").append(uri).append("'...").toString());
        String s = uri.toString();
        String s1 = null;
        int i;
        if(s.startsWith("content://com.android.contacts/data/phones")) {
            if(VDBG)
                Log.v("CallerInfo", "'data/phones' URI; using RawContacts.CONTACT_ID");
            s1 = "contact_id";
        } else
        if(s.startsWith("content://com.android.contacts/data")) {
            if(VDBG)
                Log.v("CallerInfo", "'data' URI; using Data.CONTACT_ID");
            s1 = "contact_id";
        } else
        if(s.startsWith("content://com.android.contacts/phone_lookup")) {
            if(VDBG)
                Log.v("CallerInfo", "'phone_lookup' URI; using PhoneLookup._ID");
            s1 = "_id";
        } else {
            Log.w("CallerInfo", (new StringBuilder()).append("Unexpected prefix for contactRef '").append(s).append("'").toString());
        }
        if(s1 != null)
            i = cursor.getColumnIndex(s1);
        else
            i = -1;
        if(VDBG)
            Log.v("CallerInfo", (new StringBuilder()).append("==> Using column '").append(s1).append("' (columnIndex = ").append(i).append(") for person_id lookup...").toString());
        return i;
    }

    private static String getCurrentCountryIso(Context context, Locale locale) {
        CountryDetector countrydetector = (CountryDetector)context.getSystemService("country_detector");
        String s;
        if(countrydetector != null) {
            s = countrydetector.detectCountry().getCountryIso();
        } else {
            s = locale.getCountry();
            Log.w("CallerInfo", (new StringBuilder()).append("No CountryDetector; falling back to countryIso based on locale: ").append(s).toString());
        }
        return s;
    }

    private static String getGeoDescription(Context context, String s) {
        String s1;
        s1 = null;
        if(VDBG)
            Log.v("CallerInfo", (new StringBuilder()).append("getGeoDescription('").append(s).append("')...").toString());
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return s1;
_L2:
        PhoneNumberUtil phonenumberutil = PhoneNumberUtil.getInstance();
        PhoneNumberOfflineGeocoder phonenumberofflinegeocoder = PhoneNumberOfflineGeocoder.getInstance();
        Locale locale = context.getResources().getConfiguration().locale;
        String s2 = getCurrentCountryIso(context, locale);
        com.android.i18n.phonenumbers.Phonenumber.PhoneNumber phonenumber = null;
        try {
            if(VDBG)
                Log.v("CallerInfo", (new StringBuilder()).append("parsing '").append(s).append("' for countryIso '").append(s2).append("'...").toString());
            phonenumber = phonenumberutil.parse(s, s2);
            if(VDBG)
                Log.v("CallerInfo", (new StringBuilder()).append("- parsed number: ").append(phonenumber).toString());
        }
        catch(NumberParseException numberparseexception) {
            Log.w("CallerInfo", (new StringBuilder()).append("getGeoDescription: NumberParseException for incoming number '").append(s).append("'").toString());
        }
        if(phonenumber != null) {
            s1 = phonenumberofflinegeocoder.getDescriptionForNumber(phonenumber, locale);
            if(VDBG)
                Log.v("CallerInfo", (new StringBuilder()).append("- got description: '").append(s1).append("'").toString());
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static String normalize(String s) {
        if(s != null && s.length() <= 0)
            s = null;
        return s;
    }

    public boolean isEmergencyNumber() {
        return mIsEmergency;
    }

    public boolean isVoiceMailNumber() {
        return mIsVoiceMail;
    }

    CallerInfo markAsEmergency(Context context) {
        phoneNumber = context.getString(0x10402f5);
        photoResource = 0x1080451;
        mIsEmergency = true;
        return this;
    }

    CallerInfo markAsVoiceMail() {
        mIsVoiceMail = true;
        try {
            phoneNumber = TelephonyManager.getDefault().getVoiceMailAlphaTag();
        }
        catch(SecurityException securityexception) {
            Log.e("CallerInfo", "Cannot access VoiceMail.", securityexception);
        }
        return this;
    }

    public String toString() {
        StringBuilder stringbuilder = (new StringBuilder(128)).append((new StringBuilder()).append(super.toString()).append(" { ").toString());
        StringBuilder stringbuilder1 = (new StringBuilder()).append("name ");
        String s;
        StringBuilder stringbuilder2;
        StringBuilder stringbuilder3;
        String s1;
        if(name == null)
            s = "null";
        else
            s = "non-null";
        stringbuilder2 = stringbuilder.append(stringbuilder1.append(s).toString());
        stringbuilder3 = (new StringBuilder()).append(", phoneNumber ");
        if(phoneNumber == null)
            s1 = "null";
        else
            s1 = "non-null";
        return stringbuilder2.append(stringbuilder3.append(s1).toString()).append(" }").toString();
    }

    public void updateGeoDescription(Context context, String s) {
        String s1;
        if(TextUtils.isEmpty(phoneNumber))
            s1 = s;
        else
            s1 = phoneNumber;
        geoDescription = getGeoDescription(context, s1);
    }

    public static final String PAYPHONE_NUMBER = "-3";
    public static final String PRIVATE_NUMBER = "-2";
    private static final String TAG = "CallerInfo";
    public static final String UNKNOWN_NUMBER = "-1";
    private static final boolean VDBG = Log.isLoggable("CallerInfo", 2);
    public Drawable cachedPhoto;
    public Bitmap cachedPhotoIcon;
    public String cnapName;
    public boolean contactExists;
    public Uri contactRefUri;
    public Uri contactRingtoneUri;
    public ExtraCallerInfo extra;
    public String geoDescription;
    public boolean isCachedPhotoCurrent;
    private boolean mIsEmergency;
    private boolean mIsVoiceMail;
    public String name;
    public int namePresentation;
    public boolean needUpdate;
    public String normalizedNumber;
    public String numberLabel;
    public int numberPresentation;
    public int numberType;
    public long person_id;
    public String phoneLabel;
    public String phoneNumber;
    public int photoResource;
    public boolean shouldSendToVoicemail;

}
