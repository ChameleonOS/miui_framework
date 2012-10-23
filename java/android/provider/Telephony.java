// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package android.provider:
//            BaseColumns

public final class Telephony {
    public static final class Intents {

        public static final String EXTRA_PLMN = "plmn";
        public static final String EXTRA_SHOW_PLMN = "showPlmn";
        public static final String EXTRA_SHOW_SPN = "showSpn";
        public static final String EXTRA_SPN = "spn";
        public static final String SECRET_CODE_ACTION = "android.provider.Telephony.SECRET_CODE";
        public static final String SPN_STRINGS_UPDATED_ACTION = "android.provider.Telephony.SPN_STRINGS_UPDATED";

        private Intents() {
        }
    }

    public static final class CellBroadcasts
        implements BaseColumns {

        public static final String CID = "cid";
        public static final String CMAS_CATEGORY = "cmas_category";
        public static final String CMAS_CERTAINTY = "cmas_certainty";
        public static final String CMAS_MESSAGE_CLASS = "cmas_message_class";
        public static final String CMAS_RESPONSE_TYPE = "cmas_response_type";
        public static final String CMAS_SEVERITY = "cmas_severity";
        public static final String CMAS_URGENCY = "cmas_urgency";
        public static final Uri CONTENT_URI = Uri.parse("content://cellbroadcasts");
        public static final String DEFAULT_SORT_ORDER = "date DESC";
        public static final String DELIVERY_TIME = "date";
        public static final String ETWS_WARNING_TYPE = "etws_warning_type";
        public static final String GEOGRAPHICAL_SCOPE = "geo_scope";
        public static final String LAC = "lac";
        public static final String LANGUAGE_CODE = "language";
        public static final String MESSAGE_BODY = "body";
        public static final String MESSAGE_FORMAT = "format";
        public static final String MESSAGE_PRIORITY = "priority";
        public static final String MESSAGE_READ = "read";
        public static final String PLMN = "plmn";
        public static final String QUERY_COLUMNS[];
        public static final String SERIAL_NUMBER = "serial_number";
        public static final String SERVICE_CATEGORY = "service_category";
        public static final String V1_MESSAGE_CODE = "message_code";
        public static final String V1_MESSAGE_IDENTIFIER = "message_id";

        static  {
            String as[] = new String[20];
            as[0] = "_id";
            as[1] = "geo_scope";
            as[2] = "plmn";
            as[3] = "lac";
            as[4] = "cid";
            as[5] = "serial_number";
            as[6] = "service_category";
            as[7] = "language";
            as[8] = "body";
            as[9] = "date";
            as[10] = "read";
            as[11] = "format";
            as[12] = "priority";
            as[13] = "etws_warning_type";
            as[14] = "cmas_message_class";
            as[15] = "cmas_category";
            as[16] = "cmas_response_type";
            as[17] = "cmas_severity";
            as[18] = "cmas_urgency";
            as[19] = "cmas_certainty";
            QUERY_COLUMNS = as;
        }

        private CellBroadcasts() {
        }
    }

    public static final class Carriers
        implements BaseColumns {

        public static final String APN = "apn";
        public static final String AUTH_TYPE = "authtype";
        public static final String BEARER = "bearer";
        public static final String CARRIER_ENABLED = "carrier_enabled";
        public static final String CLASS = "class";
        public static final Uri CONTENT_URI = Uri.parse("content://telephony/carriers");
        public static final String CURRENT = "current";
        public static final String DEFAULT_SORT_ORDER = "name ASC";
        public static final String ENABLED = "enabled";
        public static final String INACTIVE_TIMER = "inactivetimer";
        public static final String MCC = "mcc";
        public static final String MMSC = "mmsc";
        public static final String MMSPORT = "mmsport";
        public static final String MMSPROXY = "mmsproxy";
        public static final String MNC = "mnc";
        public static final String NAME = "name";
        public static final String NUMERIC = "numeric";
        public static final String PASSWORD = "password";
        public static final String PORT = "port";
        public static final String PROTOCOL = "protocol";
        public static final String PROXY = "proxy";
        public static final String ROAMING_PROTOCOL = "roaming_protocol";
        public static final String SERVER = "server";
        public static final String TYPE = "type";
        public static final String USER = "user";


        public Carriers() {
        }
    }

    public static final class MmsSms
        implements BaseColumns {
        public static final class WordsTable {

            public static final String ID = "_id";
            public static final String INDEXED_TEXT = "index_text";
            public static final String SOURCE_ROW_ID = "source_id";
            public static final String TABLE_ID = "table_to_use";

            public WordsTable() {
            }
        }

        public static final class PendingMessages
            implements BaseColumns {

            public static final Uri CONTENT_URI;
            public static final String DUE_TIME = "due_time";
            public static final String ERROR_CODE = "err_code";
            public static final String ERROR_TYPE = "err_type";
            public static final String LAST_TRY = "last_try";
            public static final String MSG_ID = "msg_id";
            public static final String MSG_TYPE = "msg_type";
            public static final String PROTO_TYPE = "proto_type";
            public static final String RETRY_INDEX = "retry_index";

            static  {
                CONTENT_URI = Uri.withAppendedPath(MmsSms.CONTENT_URI, "pending");
            }

            public PendingMessages() {
            }
        }


        public static final Uri CONTENT_CONVERSATIONS_URI = Uri.parse("content://mms-sms/conversations");
        public static final Uri CONTENT_DRAFT_URI = Uri.parse("content://mms-sms/draft");
        public static final Uri CONTENT_FILTER_BYPHONE_URI = Uri.parse("content://mms-sms/messages/byphone");
        public static final Uri CONTENT_LOCKED_URI = Uri.parse("content://mms-sms/locked");
        public static final Uri CONTENT_UNDELIVERED_URI = Uri.parse("content://mms-sms/undelivered");
        public static final Uri CONTENT_URI = Uri.parse("content://mms-sms/");
        public static final int ERR_TYPE_GENERIC = 1;
        public static final int ERR_TYPE_GENERIC_PERMANENT = 10;
        public static final int ERR_TYPE_MMS_PROTO_PERMANENT = 12;
        public static final int ERR_TYPE_MMS_PROTO_TRANSIENT = 3;
        public static final int ERR_TYPE_SMS_PROTO_PERMANENT = 11;
        public static final int ERR_TYPE_SMS_PROTO_TRANSIENT = 2;
        public static final int ERR_TYPE_TRANSPORT_FAILURE = 4;
        public static final int MMS_PROTO = 1;
        public static final int NO_ERROR = 0;
        public static final Uri SEARCH_URI = Uri.parse("content://mms-sms/search");
        public static final int SMS_PROTO = 0;
        public static final String TYPE_DISCRIMINATOR_COLUMN = "transport_type";


        public MmsSms() {
        }
    }

    public static final class Mms
        implements BaseMmsColumns {
        public static final class Intents {

            public static final String CONTENT_CHANGED_ACTION = "android.intent.action.CONTENT_CHANGED";
            public static final String DELETED_CONTENTS = "deleted_contents";
            public static final String EXTRA_BCC = "bcc";
            public static final String EXTRA_CC = "cc";
            public static final String EXTRA_CONTENTS = "contents";
            public static final String EXTRA_SUBJECT = "subject";
            public static final String EXTRA_TYPES = "types";

            private Intents() {
            }
        }

        public static final class Rate {

            public static final Uri CONTENT_URI;
            public static final String SENT_TIME = "sent_time";

            static  {
                CONTENT_URI = Uri.withAppendedPath(Mms.CONTENT_URI, "rate");
            }

            public Rate() {
            }
        }

        public static final class Part
            implements BaseColumns {

            public static final String CHARSET = "chset";
            public static final String CONTENT_DISPOSITION = "cd";
            public static final String CONTENT_ID = "cid";
            public static final String CONTENT_LOCATION = "cl";
            public static final String CONTENT_TYPE = "ct";
            public static final String CT_START = "ctt_s";
            public static final String CT_TYPE = "ctt_t";
            public static final String FILENAME = "fn";
            public static final String MSG_ID = "mid";
            public static final String NAME = "name";
            public static final String SEQ = "seq";
            public static final String TEXT = "text";
            public static final String _DATA = "_data";

            public Part() {
            }
        }

        public static final class Addr
            implements BaseColumns {

            public static final String ADDRESS = "address";
            public static final String CHARSET = "charset";
            public static final String CONTACT_ID = "contact_id";
            public static final String MSG_ID = "msg_id";
            public static final String TYPE = "type";

            public Addr() {
            }
        }

        public static final class Outbox
            implements BaseMmsColumns {

            public static final Uri CONTENT_URI = Uri.parse("content://mms/outbox");
            public static final String DEFAULT_SORT_ORDER = "date DESC";


            public Outbox() {
            }
        }

        public static final class Draft
            implements BaseMmsColumns {

            public static final Uri CONTENT_URI = Uri.parse("content://mms/drafts");
            public static final String DEFAULT_SORT_ORDER = "date DESC";


            public Draft() {
            }
        }

        public static final class Sent
            implements BaseMmsColumns {

            public static final Uri CONTENT_URI = Uri.parse("content://mms/sent");
            public static final String DEFAULT_SORT_ORDER = "date DESC";


            public Sent() {
            }
        }

        public static final class Inbox
            implements BaseMmsColumns {

            public static final Uri CONTENT_URI = Uri.parse("content://mms/inbox");
            public static final String DEFAULT_SORT_ORDER = "date DESC";


            public Inbox() {
            }
        }


        public static String extractAddrSpec(String s) {
            Matcher matcher = NAME_ADDR_EMAIL_PATTERN.matcher(s);
            if(matcher.matches())
                s = matcher.group(2);
            return s;
        }

        public static final String getMessageBoxName(int i) {
            i;
            JVM INSTR tableswitch 0 4: default 36
        //                       0 63
        //                       1 68
        //                       2 74
        //                       3 80
        //                       4 86;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid message box: ").append(i).toString());
_L2:
            String s = "all";
_L8:
            return s;
_L3:
            s = "inbox";
            continue; /* Loop/switch isn't completed */
_L4:
            s = "sent";
            continue; /* Loop/switch isn't completed */
_L5:
            s = "drafts";
            continue; /* Loop/switch isn't completed */
_L6:
            s = "outbox";
            if(true) goto _L8; else goto _L7
_L7:
        }

        public static boolean isEmailAddress(String s) {
            boolean flag;
            if(TextUtils.isEmpty(s)) {
                flag = false;
            } else {
                String s1 = extractAddrSpec(s);
                flag = Patterns.EMAIL_ADDRESS.matcher(s1).matches();
            }
            return flag;
        }

        public static boolean isPhoneNumber(String s) {
            boolean flag;
            if(TextUtils.isEmpty(s))
                flag = false;
            else
                flag = Patterns.PHONE.matcher(s).matches();
            return flag;
        }

        public static final Cursor query(ContentResolver contentresolver, String as[]) {
            return contentresolver.query(CONTENT_URI, as, null, null, "date DESC");
        }

        public static final Cursor query(ContentResolver contentresolver, String as[], String s, String s1) {
            Uri uri = CONTENT_URI;
            String s2;
            if(s1 == null)
                s2 = "date DESC";
            else
                s2 = s1;
            return contentresolver.query(uri, as, s, null, s2);
        }

        public static final Uri CONTENT_URI;
        public static final String DEFAULT_SORT_ORDER = "date DESC";
        public static final Pattern NAME_ADDR_EMAIL_PATTERN = Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");
        public static final Pattern QUOTED_STRING_PATTERN = Pattern.compile("\\s*\"([^\"]*)\"\\s*");
        public static final Uri REPORT_REQUEST_URI;
        public static final Uri REPORT_STATUS_URI;

        static  {
            CONTENT_URI = Uri.parse("content://mms");
            REPORT_REQUEST_URI = Uri.withAppendedPath(CONTENT_URI, "report-request");
            REPORT_STATUS_URI = Uri.withAppendedPath(CONTENT_URI, "report-status");
        }

        public Mms() {
        }
    }

    public static final class Threads
        implements ThreadsColumns {

        public static long getOrCreateThreadId(Context context, String s) {
            HashSet hashset = new HashSet();
            hashset.add(s);
            return getOrCreateThreadId(context, ((Set) (hashset)));
        }

        public static long getOrCreateThreadId(Context context, Set set) {
            Uri uri;
            Cursor cursor;
            android.net.Uri.Builder builder = THREAD_ID_CONTENT_URI.buildUpon();
            String s;
            for(Iterator iterator = set.iterator(); iterator.hasNext(); builder.appendQueryParameter("recipient", s)) {
                s = (String)iterator.next();
                if(Mms.isEmailAddress(s))
                    s = Mms.extractAddrSpec(s);
            }

            uri = builder.build();
            cursor = SqliteWrapper.query(context, context.getContentResolver(), uri, ID_PROJECTION, null, null, null);
            if(cursor == null)
                break MISSING_BLOCK_LABEL_135;
            long l;
            if(!cursor.moveToFirst())
                break MISSING_BLOCK_LABEL_120;
            l = cursor.getLong(0);
            cursor.close();
            return l;
            Log.e("Telephony", "getOrCreateThreadId returned no rows!");
            cursor.close();
            Log.e("Telephony", (new StringBuilder()).append("getOrCreateThreadId failed with uri ").append(uri.toString()).toString());
            throw new IllegalArgumentException("Unable to find or allocate a thread ID.");
            Exception exception;
            exception;
            cursor.close();
            throw exception;
        }

        public static final int BROADCAST_THREAD = 1;
        public static final int COMMON_THREAD = 0;
        public static final Uri CONTENT_URI;
        private static final String ID_PROJECTION[];
        public static final Uri OBSOLETE_THREADS_URI;
        private static final String STANDARD_ENCODING = "UTF-8";
        private static final Uri THREAD_ID_CONTENT_URI = Uri.parse("content://mms-sms/threadID");

        static  {
            String as[] = new String[1];
            as[0] = "_id";
            ID_PROJECTION = as;
            CONTENT_URI = Uri.withAppendedPath(MmsSms.CONTENT_URI, "conversations");
            OBSOLETE_THREADS_URI = Uri.withAppendedPath(CONTENT_URI, "obsolete");
        }

        private Threads() {
        }
    }

    public static interface ThreadsColumns
        extends BaseColumns {

        public static final String DATE = "date";
        public static final String ERROR = "error";
        public static final String HAS_ATTACHMENT = "has_attachment";
        public static final String MESSAGE_COUNT = "message_count";
        public static final String READ = "read";
        public static final String RECIPIENT_IDS = "recipient_ids";
        public static final String SNIPPET = "snippet";
        public static final String SNIPPET_CHARSET = "snippet_cs";
        public static final String TYPE = "type";
    }

    public static interface CanonicalAddressesColumns
        extends BaseColumns {

        public static final String ADDRESS = "address";
    }

    public static interface BaseMmsColumns
        extends BaseColumns {

        public static final String ADAPTATION_ALLOWED = "adp_a";
        public static final String APPLIC_ID = "apl_id";
        public static final String AUX_APPLIC_ID = "aux_apl_id";
        public static final String BCC = "bcc";
        public static final String CANCEL_ID = "cl_id";
        public static final String CANCEL_STATUS = "cl_st";
        public static final String CC = "cc";
        public static final String CONTENT_CLASS = "ct_cls";
        public static final String CONTENT_LOCATION = "ct_l";
        public static final String CONTENT_TYPE = "ct_t";
        public static final String DATE = "date";
        public static final String DATE_SENT = "date_sent";
        public static final String DELIVERY_REPORT = "d_rpt";
        public static final String DELIVERY_TIME = "d_tm";
        public static final String DELIVERY_TIME_TOKEN = "d_tm_tok";
        public static final String DISTRIBUTION_INDICATOR = "d_ind";
        public static final String DRM_CONTENT = "drm_c";
        public static final String ELEMENT_DESCRIPTOR = "e_des";
        public static final String EXPIRY = "exp";
        public static final String FROM = "from";
        public static final String LIMIT = "limit";
        public static final String LOCKED = "locked";
        public static final String MBOX_QUOTAS = "mb_qt";
        public static final String MBOX_QUOTAS_TOKEN = "mb_qt_tok";
        public static final String MBOX_TOTALS = "mb_t";
        public static final String MBOX_TOTALS_TOKEN = "mb_t_tok";
        public static final String MESSAGE_BOX = "msg_box";
        public static final int MESSAGE_BOX_ALL = 0;
        public static final int MESSAGE_BOX_DRAFTS = 3;
        public static final int MESSAGE_BOX_INBOX = 1;
        public static final int MESSAGE_BOX_OUTBOX = 4;
        public static final int MESSAGE_BOX_SENT = 2;
        public static final String MESSAGE_CLASS = "m_cls";
        public static final String MESSAGE_COUNT = "m_cnt";
        public static final String MESSAGE_ID = "m_id";
        public static final String MESSAGE_SIZE = "m_size";
        public static final String MESSAGE_TYPE = "m_type";
        public static final String META_DATA = "meta_data";
        public static final String MMS_VERSION = "v";
        public static final String MM_FLAGS = "mm_flg";
        public static final String MM_FLAGS_TOKEN = "mm_flg_tok";
        public static final String MM_STATE = "mm_st";
        public static final String PREVIOUSLY_SENT_BY = "p_s_by";
        public static final String PREVIOUSLY_SENT_DATE = "p_s_d";
        public static final String PRIORITY = "pri";
        public static final String QUOTAS = "qt";
        public static final String READ = "read";
        public static final String READ_REPORT = "rr";
        public static final String READ_STATUS = "read_status";
        public static final String RECOMMENDED_RETRIEVAL_MODE = "r_r_mod";
        public static final String RECOMMENDED_RETRIEVAL_MODE_TEXT = "r_r_mod_txt";
        public static final String REPLACE_ID = "repl_id";
        public static final String REPLY_APPLIC_ID = "r_apl_id";
        public static final String REPLY_CHARGING = "r_chg";
        public static final String REPLY_CHARGING_DEADLINE = "r_chg_dl";
        public static final String REPLY_CHARGING_DEADLINE_TOKEN = "r_chg_dl_tok";
        public static final String REPLY_CHARGING_ID = "r_chg_id";
        public static final String REPLY_CHARGING_SIZE = "r_chg_sz";
        public static final String REPORT_ALLOWED = "rpt_a";
        public static final String RESPONSE_STATUS = "resp_st";
        public static final String RESPONSE_TEXT = "resp_txt";
        public static final String RETRIEVE_STATUS = "retr_st";
        public static final String RETRIEVE_TEXT = "retr_txt";
        public static final String RETRIEVE_TEXT_CHARSET = "retr_txt_cs";
        public static final String SEEN = "seen";
        public static final String SENDER_VISIBILITY = "s_vis";
        public static final String START = "start";
        public static final String STATUS = "st";
        public static final String STATUS_TEXT = "st_txt";
        public static final String STORE = "store";
        public static final String STORED = "stored";
        public static final String STORE_STATUS = "store_st";
        public static final String STORE_STATUS_TEXT = "store_st_txt";
        public static final String SUBJECT = "sub";
        public static final String SUBJECT_CHARSET = "sub_cs";
        public static final String THREAD_ID = "thread_id";
        public static final String TO = "to";
        public static final String TOTALS = "totals";
        public static final String TRANSACTION_ID = "tr_id";
    }

    public static final class Sms
        implements BaseColumns, TextBasedSmsColumns {
        public static final class Intents {

            public static SmsMessage[] getMessagesFromIntent(Intent intent) {
                Object aobj[] = (Object[])(Object[])intent.getSerializableExtra("pdus");
                String s = intent.getStringExtra("format");
                byte abyte0[][] = new byte[aobj.length][];
                for(int i = 0; i < aobj.length; i++)
                    abyte0[i] = (byte[])(byte[])aobj[i];

                byte abyte1[][] = new byte[abyte0.length][];
                int j = abyte1.length;
                SmsMessage asmsmessage[] = new SmsMessage[j];
                for(int k = 0; k < j; k++) {
                    abyte1[k] = abyte0[k];
                    asmsmessage[k] = SmsMessage.createFromPdu(abyte1[k], s);
                }

                return asmsmessage;
            }

            public static final String DATA_SMS_RECEIVED_ACTION = "android.intent.action.DATA_SMS_RECEIVED";
            public static final int RESULT_SMS_GENERIC_ERROR = 2;
            public static final int RESULT_SMS_HANDLED = 1;
            public static final int RESULT_SMS_OUT_OF_MEMORY = 3;
            public static final int RESULT_SMS_UNSUPPORTED = 4;
            public static final String SIM_FULL_ACTION = "android.provider.Telephony.SIM_FULL";
            public static final String SMS_CB_RECEIVED_ACTION = "android.provider.Telephony.SMS_CB_RECEIVED";
            public static final String SMS_EMERGENCY_CB_RECEIVED_ACTION = "android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED";
            public static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";
            public static final String SMS_REJECTED_ACTION = "android.provider.Telephony.SMS_REJECTED";
            public static final String SMS_SERVICE_CATEGORY_PROGRAM_DATA_RECEIVED_ACTION = "android.provider.Telephony.SMS_SERVICE_CATEGORY_PROGRAM_DATA_RECEIVED";
            public static final String WAP_PUSH_RECEIVED_ACTION = "android.provider.Telephony.WAP_PUSH_RECEIVED";

            public Intents() {
            }
        }

        public static final class Conversations
            implements BaseColumns, TextBasedSmsColumns {

            public static final Uri CONTENT_URI = Uri.parse("content://sms/conversations");
            public static final String DEFAULT_SORT_ORDER = "date DESC";
            public static final String MESSAGE_COUNT = "msg_count";
            public static final String SNIPPET = "snippet";


            public Conversations() {
            }
        }

        public static final class Outbox
            implements BaseColumns, TextBasedSmsColumns {

            public static Uri addMessage(ContentResolver contentresolver, String s, String s1, String s2, Long long1, boolean flag, long l) {
                return Sms.addMessageToUri(contentresolver, CONTENT_URI, s, s1, s2, long1, true, flag, l);
            }

            public static final Uri CONTENT_URI = Uri.parse("content://sms/outbox");
            public static final String DEFAULT_SORT_ORDER = "date DESC";


            public Outbox() {
            }
        }

        public static final class Draft
            implements BaseColumns, TextBasedSmsColumns {

            public static Uri addMessage(ContentResolver contentresolver, String s, String s1, String s2, Long long1) {
                return Sms.addMessageToUri(contentresolver, CONTENT_URI, s, s1, s2, long1, true, false);
            }

            public static boolean saveMessage(ContentResolver contentresolver, Uri uri, String s) {
                boolean flag = true;
                ContentValues contentvalues = new ContentValues(2);
                contentvalues.put("body", s);
                contentvalues.put("date", Long.valueOf(System.currentTimeMillis()));
                if(contentresolver.update(uri, contentvalues, null, null) != flag)
                    flag = false;
                return flag;
            }

            public static final Uri CONTENT_URI = Uri.parse("content://sms/draft");
            public static final String DEFAULT_SORT_ORDER = "date DESC";


            public Draft() {
            }
        }

        public static final class Sent
            implements BaseColumns, TextBasedSmsColumns {

            public static Uri addMessage(ContentResolver contentresolver, String s, String s1, String s2, Long long1) {
                return Sms.addMessageToUri(contentresolver, CONTENT_URI, s, s1, s2, long1, true, false);
            }

            public static final Uri CONTENT_URI = Uri.parse("content://sms/sent");
            public static final String DEFAULT_SORT_ORDER = "date DESC";


            public Sent() {
            }
        }

        public static final class Inbox
            implements BaseColumns, TextBasedSmsColumns {

            public static Uri addMessage(ContentResolver contentresolver, String s, String s1, String s2, Long long1, boolean flag) {
                return Sms.addMessageToUri(contentresolver, CONTENT_URI, s, s1, s2, long1, flag, false);
            }

            public static final Uri CONTENT_URI = Uri.parse("content://sms/inbox");
            public static final String DEFAULT_SORT_ORDER = "date DESC";


            public Inbox() {
            }
        }


        public static Uri addMessageToUri(ContentResolver contentresolver, Uri uri, String s, String s1, String s2, Long long1, boolean flag, boolean flag1) {
            return addMessageToUri(contentresolver, uri, s, s1, s2, long1, flag, flag1, -1L);
        }

        public static Uri addMessageToUri(ContentResolver contentresolver, Uri uri, String s, String s1, String s2, Long long1, boolean flag, boolean flag1, 
                long l) {
            ContentValues contentvalues = new ContentValues(7);
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
            return contentresolver.insert(uri, contentvalues);
        }

        public static boolean isOutgoingFolder(int i) {
            boolean flag;
            if(i == 5 || i == 4 || i == 2 || i == 6)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public static boolean moveMessageToFolder(Context context, Uri uri, int i, int j) {
            boolean flag = false;
            if(uri != null) goto _L2; else goto _L1
_L1:
            return flag;
_L2:
            boolean flag1;
            boolean flag2;
            flag1 = false;
            flag2 = false;
            i;
            JVM INSTR tableswitch 1 6: default 56
        //                       1 59
        //                       2 134
        //                       3 59
        //                       4 134
        //                       5 140
        //                       6 140;
               goto _L1 _L3 _L4 _L3 _L4 _L5 _L5
_L3:
            ContentValues contentvalues = new ContentValues(3);
            contentvalues.put("type", Integer.valueOf(i));
            boolean flag3;
            if(flag1)
                contentvalues.put("read", Integer.valueOf(0));
            else
            if(flag2)
                contentvalues.put("read", Integer.valueOf(1));
            contentvalues.put("error_code", Integer.valueOf(j));
            if(1 == SqliteWrapper.update(context, context.getContentResolver(), uri, contentvalues, null, null))
                flag3 = true;
            else
                flag3 = false;
            flag = flag3;
              goto _L1
_L4:
            flag2 = true;
              goto _L3
_L5:
            flag1 = true;
              goto _L3
        }

        public static final Cursor query(ContentResolver contentresolver, String as[]) {
            return contentresolver.query(CONTENT_URI, as, null, null, "date DESC");
        }

        public static final Cursor query(ContentResolver contentresolver, String as[], String s, String s1) {
            Uri uri = CONTENT_URI;
            String s2;
            if(s1 == null)
                s2 = "date DESC";
            else
                s2 = s1;
            return contentresolver.query(uri, as, s, null, s2);
        }

        public static final Uri CONTENT_URI = Uri.parse("content://sms");
        public static final String DEFAULT_SORT_ORDER = "date DESC";


        public Sms() {
        }
    }

    public static interface TextBasedSmsColumns {

        public static final String ADDRESS = "address";
        public static final String BODY = "body";
        public static final String DATE = "date";
        public static final String DATE_SENT = "date_sent";
        public static final String ERROR_CODE = "error_code";
        public static final String LOCKED = "locked";
        public static final int MESSAGE_TYPE_ALL = 0;
        public static final int MESSAGE_TYPE_DRAFT = 3;
        public static final int MESSAGE_TYPE_FAILED = 5;
        public static final int MESSAGE_TYPE_INBOX = 1;
        public static final int MESSAGE_TYPE_OUTBOX = 4;
        public static final int MESSAGE_TYPE_QUEUED = 6;
        public static final int MESSAGE_TYPE_SENT = 2;
        public static final String META_DATA = "meta_data";
        public static final String PERSON = "person";
        public static final String PERSON_ID = "person";
        public static final String PROTOCOL = "protocol";
        public static final String READ = "read";
        public static final String REPLY_PATH_PRESENT = "reply_path_present";
        public static final String SEEN = "seen";
        public static final String SERVICE_CENTER = "service_center";
        public static final String STATUS = "status";
        public static final int STATUS_COMPLETE = 0;
        public static final int STATUS_FAILED = 64;
        public static final int STATUS_NONE = -1;
        public static final int STATUS_PENDING = 32;
        public static final String SUBJECT = "subject";
        public static final String THREAD_ID = "thread_id";
        public static final String TYPE = "type";
    }


    public Telephony() {
    }

    private static final boolean DEBUG = true;
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "Telephony";
}
