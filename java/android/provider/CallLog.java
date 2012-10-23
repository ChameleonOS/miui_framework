// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.content.*;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.android.internal.telephony.CallerInfo;
import com.android.internal.telephony.Connection;

// Referenced classes of package android.provider:
//            BaseColumns

public class CallLog {
    public static class Calls
        implements BaseColumns {

        public static Uri addCall(CallerInfo callerinfo, Context context, String s, int i, int j, long l, int k) {
            ContentResolver contentresolver = context.getContentResolver();
            if(i != Connection.PRESENTATION_RESTRICTED) goto _L2; else goto _L1
_L1:
            s = "-2";
            if(callerinfo != null)
                callerinfo.name = "";
_L4:
            Cursor cursor;
            ContentValues contentvalues = getExtraCallLogValues();
            contentvalues.put("number", s);
            contentvalues.put("type", Integer.valueOf(j));
            contentvalues.put("date", Long.valueOf(l));
            contentvalues.put("duration", Long.valueOf(k));
            contentvalues.put("new", Integer.valueOf(1));
            if(j == 3)
                contentvalues.put("is_read", Integer.valueOf(0));
            if(callerinfo != null) {
                contentvalues.put("name", callerinfo.name);
                contentvalues.put("numbertype", Integer.valueOf(callerinfo.numberType));
                contentvalues.put("numberlabel", callerinfo.numberLabel);
            }
            if(callerinfo == null || callerinfo.person_id <= 0L)
                break MISSING_BLOCK_LABEL_300;
            if(callerinfo.normalizedNumber != null) {
                String s2 = callerinfo.normalizedNumber;
                Uri uri1 = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                String as2[] = new String[1];
                as2[0] = "_id";
                String as3[] = new String[2];
                as3[0] = String.valueOf(callerinfo.person_id);
                as3[1] = s2;
                cursor = contentresolver.query(uri1, as2, "contact_id =? AND data4 =?", as3, null);
            } else {
                String s1;
                Uri uri;
                String as[];
                String as1[];
                if(callerinfo.phoneNumber != null)
                    s1 = callerinfo.phoneNumber;
                else
                    s1 = s;
                uri = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Callable.CONTENT_FILTER_URI, Uri.encode(s1));
                as = new String[1];
                as[0] = "_id";
                as1 = new String[1];
                as1[0] = String.valueOf(callerinfo.person_id);
                cursor = contentresolver.query(uri, as, "contact_id =?", as1, null);
            }
            if(cursor == null)
                break MISSING_BLOCK_LABEL_300;
            if(cursor.getCount() > 0 && cursor.moveToFirst())
                contentresolver.update(ContactsContract.DataUsageFeedback.FEEDBACK_URI.buildUpon().appendPath(cursor.getString(0)).appendQueryParameter("type", "call").build(), new ContentValues(), null, null);
            cursor.close();
            return contentresolver.insert(CONTENT_URI, contentvalues);
_L2:
            if(i == Connection.PRESENTATION_PAYPHONE) {
                s = "-3";
                if(callerinfo != null)
                    callerinfo.name = "";
            } else
            if(TextUtils.isEmpty(s) || i == Connection.PRESENTATION_UNKNOWN) {
                s = "-1";
                if(callerinfo != null)
                    callerinfo.name = "";
            }
            continue; /* Loop/switch isn't completed */
            Exception exception;
            exception;
            cursor.close();
            throw exception;
            if(true) goto _L4; else goto _L3
_L3:
        }

        private static ContentValues getExtraCallLogValues() {
            ContentValues contentvalues;
            if(sExtraCallLogValues == null) {
                contentvalues = new ContentValues(5);
            } else {
                contentvalues = sExtraCallLogValues;
                sExtraCallLogValues = null;
            }
            return contentvalues;
        }

        public static String getLastOutgoingCall(Context context) {
            ContentResolver contentresolver;
            Cursor cursor;
            contentresolver = context.getContentResolver();
            cursor = null;
            Uri uri = CONTENT_URI;
            String as[] = new String[1];
            as[0] = "number";
            cursor = contentresolver.query(uri, as, "type = 2", null, "date DESC LIMIT 1");
            if(cursor != null && cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
            String s = "";
            if(cursor != null)
                cursor.close();
_L4:
            return s;
_L2:
            String s1 = cursor.getString(0);
            s = s1;
            if(cursor != null)
                cursor.close();
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            if(cursor != null)
                cursor.close();
            throw exception;
        }

        private static void removeExpiredEntries(Context context) {
            context.getContentResolver().delete(CONTENT_URI, "_id IN (SELECT _id FROM calls ORDER BY date DESC LIMIT -1 OFFSET 500)", null);
        }

        public static void setExtraCallLogValues(ContentValues contentvalues) {
            sExtraCallLogValues = contentvalues;
        }

        public static final String ALLOW_VOICEMAILS_PARAM_KEY = "allow_voicemails";
        public static final String CACHED_FORMATTED_NUMBER = "formatted_number";
        public static final String CACHED_LOOKUP_URI = "lookup_uri";
        public static final String CACHED_MATCHED_NUMBER = "matched_number";
        public static final String CACHED_NAME = "name";
        public static final String CACHED_NORMALIZED_NUMBER = "normalized_number";
        public static final String CACHED_NUMBER_LABEL = "numberlabel";
        public static final String CACHED_NUMBER_TYPE = "numbertype";
        public static final String CACHED_PHOTO_ID = "photo_id";
        public static final Uri CONTENT_FILTER_URI = Uri.parse("content://call_log/calls/filter");
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/calls";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/calls";
        public static final Uri CONTENT_URI;
        public static final Uri CONTENT_URI_WITH_VOICEMAIL;
        public static final String COUNTRY_ISO = "countryiso";
        public static final String DATE = "date";
        public static final String DEFAULT_SORT_ORDER = "date DESC";
        public static final String DURATION = "duration";
        public static final String GEOCODED_LOCATION = "geocoded_location";
        public static final int INCOMING_TYPE = 1;
        public static final String IS_READ = "is_read";
        public static final int MISSED_TYPE = 3;
        public static final String NEW = "new";
        public static final String NUMBER = "number";
        public static final int OUTGOING_TYPE = 2;
        public static final String TYPE = "type";
        public static final int VOICEMAIL_TYPE = 4;
        public static final String VOICEMAIL_URI = "voicemail_uri";
        private static ContentValues sExtraCallLogValues = null;

        static  {
            CONTENT_URI = Uri.parse("content://call_log/calls");
            CONTENT_URI_WITH_VOICEMAIL = CONTENT_URI.buildUpon().appendQueryParameter("allow_voicemails", "true").build();
        }

        public Calls() {
        }
    }


    public CallLog() {
    }

    public static final String AUTHORITY = "call_log";
    public static final Uri CONTENT_URI = Uri.parse("content://call_log");

}
