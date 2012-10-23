// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.provider;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.mms.pdu.*;
import java.util.Calendar;

// Referenced classes of package miui.provider:
//            MiCloudSmsCmd, ExtraGuard

public final class ExtraTelephony {
    public static final class FirewallLog
        implements BaseColumns {

        public static final int BLOCK_BY_BL = 1;
        public static final int BLOCK_BY_WL = 2;
        public static final int BLOCK_FILTER = 3;
        public static final int BLOCK_NONE = 0;
        public static final int BLOCK_PRVIATE_CALL = 4;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/firewall-log";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/firewall-log";
        public static final Uri CONTENT_URI = Uri.parse("content://firewall/log");
        public static final Uri CONTENT_URI_LOG_CONVERSATION = Uri.parse("content://firewall/logconversation");
        public static final String DATA1 = "data1";
        public static final String DATA2 = "data2";
        public static final String DATE = "date";
        public static final String NUMBER = "number";
        public static final String READ = "read";
        public static final String REASON = "reason";
        public static final int REASON_BL_DELMMS = 6;
        public static final int REASON_BL_DELSMS = 4;
        public static final int REASON_BL_HANGUP = 1;
        public static final int REASON_BL_MUTE = 2;
        public static final int REASON_BL_MUTEMMS = 5;
        public static final int REASON_BL_MUTESMS = 3;
        public static final int REASON_FILTER_SMS = 0x10000;
        public static final int REASON_IMPORT_SMS = 0x20000;
        public static final int REASON_NONE = 0;
        public static final int REASON_PRIVATE_CALL_HANGUP = 7;
        public static final int REASON_WL_DELMMS = 262;
        public static final int REASON_WL_DELSMS = 260;
        public static final int REASON_WL_FLAG = 256;
        public static final int REASON_WL_HANGUP = 257;
        public static final int REASON_WL_MUTE = 258;
        public static final int REASON_WL_MUTEMMS = 261;
        public static final int REASON_WL_MUTESMS = 259;
        public static final String TYPE = "type";
        public static final int TYPE_CALL = 1;
        public static final int TYPE_MMS = 3;
        public static final int TYPE_SMS = 2;
        public static final int TYPE_UNKNOWN;


        public FirewallLog() {
        }
    }

    public static final class Keyword
        implements BaseColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/firewall-keyword";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/firewall-keyword";
        public static final Uri CONTENT_URI = Uri.parse("content://firewall/keyword");
        public static final String DATA = "data";


        public Keyword() {
        }
    }

    public static final class Whitelist
        implements BaseColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/firewall-whitelist";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/firewall-whitelist";
        public static final Uri CONTENT_URI = Uri.parse("content://firewall/whitelist");
        public static final String NOTES = "notes";


        public Whitelist() {
        }
    }

    public static final class Blacklist
        implements BaseColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/firewall-blacklist";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/firewall-blacklist";
        public static final Uri CONTENT_URI = Uri.parse("content://firewall/blacklist");
        public static final String NOTES = "notes";


        public Blacklist() {
        }
    }

    public static final class SimCards {

        public static final String BIND_ID = "bind_id";
        public static final Uri CONTENT_URI = Uri.parse("content://mms-sms/sim-cards");
        public static final String IMSI = "imsi";
        public static final String MARKER1 = "marker1";
        public static final String MARKER2 = "marker2";
        public static final String NUMBER = "number";
        public static final String SLOT = "slot";
        public static final String _ID = "_id";


        public SimCards() {
        }
    }

    public static final class SmsPhrase {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/smsphrase";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/smsphrase";

        public SmsPhrase() {
        }
    }

    public static final class MmsSms {

        public static final Uri CONTENT_ALL_LOCKED_URI = Uri.parse("content://mms-sms/locked/all");
        public static final Uri CONTENT_EXPIRED_URI = Uri.parse("content://mms-sms/expired");
        public static final Uri CONTENT_PREVIEW_URI = Uri.parse("content://mms-sms/message/preview");
        public static final Uri CONTENT_RECENT_RECIPIENTS_URI = Uri.parse("content://mms-sms/recent-recipients");
        public static final String INSERT_PATH_IGNORED = "ignored";
        public static final String INSERT_PATH_INSERTED = "inserted";
        public static final String INSERT_PATH_RESTORED = "restored";
        public static final String INSERT_PATH_UPDATED = "updated";
        public static final int PREVIEW_ADDRESS_COLUMN_INDEX = 1;
        public static final int PREVIEW_BODY_COLUMN_INDEX = 4;
        public static final int PREVIEW_CHARSET_COLUMN_INDEX = 5;
        public static final int PREVIEW_DATE_COLUMN_INDEX = 2;
        public static final int PREVIEW_ID_COLUMN_INDEX = 0;
        public static final int PREVIEW_THREAD_ID_COLUMN_INDEX = 6;
        public static final int PREVIEW_TYPE_COLUMN_INDEX = 3;
        public static final int SYNC_STATE_DIRTY = 0;
        public static final int SYNC_STATE_SYNCED = 2;
        public static final int SYNC_STATE_SYNCING = 1;


        public MmsSms() {
        }
    }

    public static final class Threads
        implements ThreadsColumns {
        public static final class Intents {

            public static final String THREADS_OBSOLETED_ACTION = "android.intent.action.SMS_THREADS_OBSOLETED_ACTION";

            public Intents() {
            }
        }


        public Threads() {
        }
    }

    public static interface ThreadsColumns {

        public static final String HAS_DRAFT = "has_draft";
        public static final String UNREAD_COUNT = "unread_count";
    }

    public static final class Mx {

        public static final int TYPE_COMMON = 0;
        public static final int TYPE_DELIVERED = 17;
        public static final int TYPE_INCOMING = 0x10001;
        public static final int TYPE_PENDING = 1;
        public static final int TYPE_READ = 256;
        public static final int TYPE_SENT = 16;

        public Mx() {
        }
    }

    public static final class Mms {

        public static final String ACCOUNT = "account";
        public static final String ADDRESSES = "addresses";
        public static final String BIND_ID = "bind_id";
        public static final String DATE_FULL = "date_full";
        public static final String DATE_MS_PART = "date_ms_part";
        public static final String DELETED = "deleted";
        public static final String FILE_ID = "file_id";
        public static final String MARKER = "marker";
        public static final String MX_ID = "mx_id";
        public static final String MX_STATUS = "mx_status";
        public static final String NEED_DOWNLOAD = "need_download";
        public static final String SOURCE = "source";
        public static final String SYNC_STATE = "sync_state";
        public static final String TIMED = "timed";

        public Mms() {
        }
    }

    public static final class Sms
        implements TextBasedSmsColumns {
        public static final class Intents {

            public static final String DISMISS_NEW_MESSAGE_NOTIFICATION_ACTION = "android.provider.Telephony.DISMISS_NEW_MESSAGE_NOTIFICATION";

            public Intents() {
            }
        }


        public static Uri addMiMessageToUri(ContentResolver contentresolver, Uri uri, String s, String s1, String s2, Long long1, boolean flag, boolean flag1, 
                long l) {
            ContentValues contentvalues = new ContentValues(10);
            contentvalues.put("address", s);
            if(long1 != null)
                contentvalues.put("date", long1);
            Integer integer;
            if(flag)
                integer = Integer.valueOf(1);
            else
                integer = Integer.valueOf(0);
            contentvalues.put("read", integer);
            contentvalues.put("subject", s2);
            contentvalues.put("body", s1);
            if(flag1)
                contentvalues.put("status", Integer.valueOf(32));
            if(l != -1L)
                contentvalues.put("thread_id", Long.valueOf(l));
            contentvalues.put("mx_status", Integer.valueOf(1));
            return contentresolver.insert(uri, contentvalues);
        }

        public static boolean moveMessageToFolder(Context context, Uri uri, int i, int j, Long long1, Integer integer, int k) {
            return moveMessageToFolder(context, uri, i, j, long1, integer, k, null);
        }

        public static boolean moveMessageToFolder(Context context, Uri uri, int i, int j, Long long1, Integer integer, int k, Long long2) {
            if(uri != null) goto _L2; else goto _L1
_L1:
            boolean flag2 = false;
_L8:
            return flag2;
_L2:
            boolean flag;
            boolean flag1;
            flag = false;
            flag1 = false;
            i;
            JVM INSTR tableswitch 1 6: default 56
        //                       1 65
        //                       2 62
        //                       3 65
        //                       4 62
        //                       5 189
        //                       6 189;
               goto _L3 _L4 _L5 _L4 _L5 _L6 _L6
_L4:
            break; /* Loop/switch isn't completed */
_L3:
            flag2 = false;
              goto _L7
_L5:
            flag1 = true;
_L9:
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("type", Integer.valueOf(i));
            if(flag)
                contentvalues.put("read", Integer.valueOf(0));
            else
            if(flag1)
                contentvalues.put("read", Integer.valueOf(1));
            if(long1 != null)
                contentvalues.put("out_time", long1);
            if(integer != null)
                contentvalues.put("status", integer);
            contentvalues.put("error_code", Integer.valueOf(j));
            contentvalues.put("mx_status", Integer.valueOf(k));
            if(long2 != null)
                contentvalues.put("mx_id", long2);
            if(1 == SqliteWrapper.update(context, context.getContentResolver(), uri, contentvalues, null, null))
                flag2 = true;
            else
                flag2 = false;
_L7:
            if(true) goto _L8; else goto _L6
_L6:
            flag = true;
              goto _L9
        }

        public static final String ACCOUNT = "account";
        public static final String ADDRESSES = "addresses";
        public static final String BIND_ID = "bind_id";
        public static final String DELETED = "deleted";
        public static final String MARKER = "marker";
        public static final String MX_ID = "mx_id";
        public static final String MX_STATUS = "mx_status";
        public static final String OUT_TIME = "out_time";
        public static final String SOURCE = "source";
        public static final String SYNC_STATE = "sync_state";
        public static final String TIMED = "timed";

        public Sms() {
        }
    }

    public static interface TextBasedSmsColumns {

        public static final int MESSAGE_TYPE_INVALID = 7;
    }


    public ExtraTelephony() {
    }

    public static boolean checkFirewallForMessage(Context context, String s, String s1) {
        boolean flag;
        boolean flag1;
        int i;
        flag = true;
        flag1 = false;
        i = 0;
        int j;
        j = shouldBlockByFirewall(context, s, s1.toString());
        if(j != flag)
            break MISSING_BLOCK_LABEL_194;
        flag1 = true;
        i = 4;
_L9:
        if(!flag1 || getSmsAct(context) != 2 && i != 0x10000) goto _L2; else goto _L1
_L1:
        if(i != 4) goto _L4; else goto _L3
_L3:
        Log.d("ExtraTelephony", "\u76F4\u63A5\u5220\u9664\u9ED1\u540D\u5355\u6210\u5458\u77ED\u4FE1.");
_L8:
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("number", s);
        contentvalues.put("date", Long.valueOf(System.currentTimeMillis()));
        contentvalues.put("type", Integer.valueOf(2));
        contentvalues.put("data1", s1.toString());
        contentvalues.put("reason", Integer.valueOf(i));
        context.getContentResolver().insert(FirewallLog.CONTENT_URI, contentvalues);
          goto _L5
_L4:
        if(i != 260) goto _L7; else goto _L6
_L6:
        Log.d("ExtraTelephony", "\u76F4\u63A5\u5220\u9664\u767D\u540D\u5355\u6210\u5458\u77ED\u4FE1.");
          goto _L8
        Exception exception;
        exception;
        Log.e("ExtraTelephony", "\u9632\u6253\u6270\u53D1\u751F\u5F02\u5E38", exception);
_L2:
        flag = false;
          goto _L5
_L7:
        Log.d("ExtraTelephony", "\u77ED\u4FE1\u88AB\u8FC7\u6EE4.");
          goto _L8
_L5:
        return flag;
        if(j == 2) {
            flag1 = true;
            i = 260;
        } else
        if(j == 3) {
            flag1 = true;
            i = 0x10000;
        }
          goto _L9
    }

    public static boolean checkFirewallForSms(Context context, byte abyte0[][]) {
        boolean flag = true;
        if(abyte0 == null) goto _L2; else goto _L1
_L1:
        int i = abyte0.length;
        if(i < flag) goto _L2; else goto _L3
_L3:
        String s = SmsMessage.createFromPdu(abyte0[0]).getOriginatingAddress();
        StringBuilder stringbuilder;
        int j;
        stringbuilder = new StringBuilder();
        j = 0;
_L6:
        int k = abyte0.length;
        if(j >= k) goto _L5; else goto _L4
_L4:
        stringbuilder.append(SmsMessage.createFromPdu(abyte0[j]).getDisplayMessageBody());
_L9:
        j++;
          goto _L6
        NullPointerException nullpointerexception;
        nullpointerexception;
        flag = false;
_L8:
        return flag;
_L5:
        boolean flag1;
        if(MiCloudSmsCmd.checkSmsCmd(context, s, stringbuilder.toString()))
            continue; /* Loop/switch isn't completed */
        flag1 = checkFirewallForMessage(context, s, stringbuilder.toString());
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        Log.e("ExtraTelephony", "\u9632\u6253\u6270\u53D1\u751F\u5F02\u5E38", exception);
_L2:
        flag = false;
        if(true) goto _L8; else goto _L7
_L7:
        NullPointerException nullpointerexception1;
        nullpointerexception1;
          goto _L9
    }

    public static boolean checkFirewallForWapPush(Context context, byte abyte0[]) {
        if(abyte0 == null) goto _L2; else goto _L1
_L1:
        GenericPdu genericpdu = (new PduParser(abyte0)).parse();
        if(genericpdu != null) goto _L4; else goto _L3
_L3:
        boolean flag = false;
          goto _L5
_L4:
        EncodedStringValue encodedstringvalue = genericpdu.getFrom();
        if(encodedstringvalue != null) goto _L7; else goto _L6
_L6:
        flag = false;
          goto _L5
_L7:
        String s;
        boolean flag1;
        char c;
        int i;
        s = PduPersister.toIsoString(encodedstringvalue.getTextString());
        flag1 = false;
        c = '\0';
        i = shouldBlockByFirewall(context, s);
        if(i != 1)
            break MISSING_BLOCK_LABEL_250;
        flag1 = true;
        c = '\006';
_L12:
        if(!flag1 || getSmsAct(context) != 2) goto _L2; else goto _L8
_L8:
        if(c != 6) goto _L10; else goto _L9
_L9:
        Log.d("ExtraTelephony", "\u76F4\u63A5\u5220\u9664\u9ED1\u540D\u5355\u6210\u5458\u5F69\u4FE1.");
_L11:
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("number", s);
        contentvalues.put("date", Long.valueOf(System.currentTimeMillis()));
        contentvalues.put("type", Integer.valueOf(3));
        contentvalues.put("data1", (new StringBuilder()).append("<").append(context.getString(0x60c016d)).append(">").toString());
        contentvalues.put("reason", Integer.valueOf(c));
        context.getContentResolver().insert(FirewallLog.CONTENT_URI, contentvalues);
        flag = true;
        break; /* Loop/switch isn't completed */
_L10:
        if(c == 262)
            Log.d("ExtraTelephony", "\u76F4\u63A5\u5220\u9664\u767D\u540D\u5355\u6210\u5458\u5F69\u4FE1.");
        if(true) goto _L11; else goto _L5
        Exception exception;
        exception;
        Log.e("ExtraTelephony", "\u9632\u6253\u6270\u53D1\u751F\u5F02\u5E38", exception);
_L2:
        flag = false;
_L5:
        return flag;
        if(i == 2) {
            flag1 = true;
            c = '\u0106';
        }
          goto _L12
    }

    public static int getCallAct(Context context) {
        if(context == null)
            throw new IllegalArgumentException("context should not be null!");
        else
            return android.provider.Settings.System.getInt(context.getContentResolver(), "firewall_call_act", 0);
    }

    public static int getSmsAct(Context context) {
        if(context == null)
            throw new IllegalArgumentException("context should not be null!");
        else
            return android.provider.Settings.System.getInt(context.getContentResolver(), "firewall_sms_act", 2);
    }

    public static boolean isAntiPrivateEnabled(Context context) {
        boolean flag = false;
        if(context == null)
            throw new IllegalArgumentException("context should not be null!");
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "anti_private_call", 0) != 0)
            flag = true;
        return flag;
    }

    public static boolean isAntiStrangerEnabled(Context context) {
        boolean flag = true;
        if(context == null)
            throw new IllegalArgumentException("context should not be null!");
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "anti_stranger_call", flag) == 0)
            flag = false;
        return flag;
    }

    private static boolean isBlacklistEnabled(Context context) {
        boolean flag = true;
        if(context == null)
            throw new IllegalArgumentException("context should not be null!");
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "blacklist_enabled", flag) == 0)
            flag = false;
        return flag;
    }

    public static boolean isCallLogNumber(Context context, String s) {
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        miui.telephony.PhoneNumberUtils.PhoneNumber phonenumber = miui.telephony.PhoneNumberUtils.PhoneNumber.parse(s);
        String s1 = (new StringBuilder()).append("number='").append(phonenumber.getNormalizedNumber(false, false)).append("'").toString();
        ContentResolver contentresolver = context.getContentResolver();
        Uri uri = android.provider.CallLog.Calls.CONTENT_URI;
        String as[] = new String[1];
        as[0] = "type";
        Cursor cursor = contentresolver.query(uri, as, s1, null, null);
        flag = false;
        if(cursor == null)
            continue; /* Loop/switch isn't completed */
        do {
            if(!cursor.moveToNext())
                break;
            if(cursor.getInt(0) == 3)
                continue;
            flag = true;
            break;
        } while(true);
        cursor.close();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean isFilterSmsEnabled(Context context) {
        boolean flag = true;
        if(context == null)
            throw new IllegalArgumentException("context should not be null!");
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "filter_stranger_sms", flag) == 0)
            flag = false;
        return flag;
    }

    public static boolean isFirewallEnabled(Context context) {
        boolean flag = true;
        if(context == null)
            throw new IllegalArgumentException("context should not be null!");
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "firewall_enabled", flag) == 0)
            flag = false;
        return flag;
    }

    private static boolean isInBlacklist(Context context, String s) {
        if(context == null)
            throw new IllegalArgumentException("context should not be null!");
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        Cursor cursor = context.getContentResolver().query(Uri.withAppendedPath(Blacklist.CONTENT_URI, s), null, null, null, null);
        if(cursor != null && cursor.moveToFirst())
            flag = true;
        else
            flag = false;
        if(cursor != null)
            cursor.close();
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static boolean isInFirewallTimeLimit(Context context) {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = false;
        if(context == null)
            throw new IllegalArgumentException("context should not be null!");
        boolean flag2;
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "firewall_time_limit_enabled", 0) != 0)
            flag2 = flag;
        else
            flag2 = false;
        if(flag2) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = android.provider.Settings.System.getInt(context.getContentResolver(), "firewall_start_time", 0);
        int j = android.provider.Settings.System.getInt(context.getContentResolver(), "firewall_end_time", 420);
        if(i == j) {
            flag = false;
        } else {
            Calendar calendar = Calendar.getInstance();
            int k = 60 * calendar.get(11) + calendar.get(12);
            if(i < j) {
                if(i > k || k > j)
                    flag = false;
            } else {
                if(k >= i || k <= j)
                    flag1 = flag;
                flag = flag1;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static boolean isInWhitelist(Context context, String s) {
        if(context == null)
            throw new IllegalArgumentException("context should not be null!");
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        Cursor cursor = context.getContentResolver().query(Uri.withAppendedPath(Whitelist.CONTENT_URI, s), null, null, null, null);
        flag = false;
        if(cursor != null && cursor.moveToFirst())
            flag = true;
        if(cursor != null)
            cursor.close();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean isSkipInCallLogForFirewall(Context context) {
        boolean flag = true;
        if(context == null)
            throw new IllegalArgumentException("context should not be null!");
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "firewall_hide_calllog", flag) == 0)
            flag = false;
        return flag;
    }

    private static boolean isStranger(Context context, String s) {
        boolean flag = true;
        Cursor cursor = context.getContentResolver().query(Uri.withAppendedPath(android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI, s), COLUMNS, null, null, null);
        if(cursor != null) {
            if(cursor.moveToFirst() && !TextUtils.isEmpty(cursor.getString(0)))
                flag = false;
            cursor.close();
        }
        return flag;
    }

    private static boolean isWhitelistEnabled(Context context) {
        boolean flag = true;
        if(context == null)
            throw new IllegalArgumentException("context should not be null!");
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "whitelist_enabled", flag) == 0)
            flag = false;
        return flag;
    }

    public static int shouldBlockByFirewall(Context context, String s) {
        return shouldBlockByFirewall(context, s, true, true);
    }

    public static int shouldBlockByFirewall(Context context, String s, String s1) {
        int i = shouldBlockByFirewall(context, s, true, true);
        if(i == 0)
            i = shouldFilter(context, s, s1);
        return i;
    }

    public static int shouldBlockByFirewall(Context context, String s, boolean flag) {
        return shouldBlockByFirewall(context, s, flag, false);
    }

    private static int shouldBlockByFirewall(Context context, String s, boolean flag, boolean flag1) {
        int i;
        i = 0;
        break MISSING_BLOCK_LABEL_3;
        while(true)  {
            do
                return i;
            while(!isFirewallEnabled(context) || !isInFirewallTimeLimit(context));
            if(isBlacklistEnabled(context) && isInBlacklist(context, s))
                i = 1;
            else
            if(!isWhitelistEnabled(context) || !isInWhitelist(context, s)) {
                int j = android.provider.Settings.System.getInt(context.getContentResolver(), "incoming_call_limit_setting", 0);
                if(j == 3)
                    i = 2;
                else
                if(j == 1)
                    if(TextUtils.isEmpty(s)) {
                        i = 2;
                    } else {
                        if(flag1)
                            flag = isStranger(context, s);
                        if(flag)
                            i = 2;
                    }
            }
        }
    }

    private static int shouldFilter(Context context, String s, String s1) {
        int i;
        i = 0;
        break MISSING_BLOCK_LABEL_2;
        while(true)  {
            do
                return i;
            while(TextUtils.isEmpty(s1) || !isFilterSmsEnabled(context) || !isStranger(context, s) || isInWhitelist(context, s) || isCallLogNumber(context, s));
            Cursor cursor = context.getContentResolver().query(Keyword.CONTENT_URI, KEYWORD_COLUMNS, null, null, null);
            boolean flag = false;
            if(cursor != null) {
                do {
                    if(!cursor.moveToNext())
                        break;
                    String s2 = cursor.getString(0).trim();
                    if(TextUtils.isEmpty(s2) || !s1.contains(s2))
                        continue;
                    flag = true;
                    break;
                } while(true);
                cursor.close();
            }
            if(!flag)
                flag = ExtraGuard.checkSms(context, s, s1);
            byte byte0;
            if(flag)
                byte0 = 3;
            else
                byte0 = 0;
            i = byte0;
        }
    }

    public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
    public static final String CHECK_DUPLICATION = "check_duplication";
    private static final String COLUMNS[];
    private static final int DATA_COLUMN = 0;
    public static final String DIRTY_QUERY_LIMIT = "dirty_query_limit";
    private static final String KEYWORD_COLUMNS[];
    private static final int NAME_COLUMN = 0;
    public static final String NEED_FULL_INSERT_URI = "need_full_insert_uri";
    private static final int STARRED_COLUMN = 1;
    private static final String TAG = "ExtraTelephony";

    static  {
        String as[] = new String[2];
        as[0] = "display_name";
        as[1] = "starred";
        COLUMNS = as;
        String as1[] = new String[1];
        as1[0] = "data";
        KEYWORD_COLUMNS = as1;
    }
}
