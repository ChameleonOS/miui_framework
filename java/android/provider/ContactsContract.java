// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.accounts.Account;
import android.app.Activity;
import android.content.*;
import android.content.res.*;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Rect;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package android.provider:
//            BaseColumns

public final class ContactsContract {
    public static final class Intents {
        public static final class Insert {

            public static final String ACCOUNT = "com.android.contacts.extra.ACCOUNT";
            public static final String ACTION = "android.intent.action.INSERT";
            public static final String COMPANY = "company";
            public static final String DATA = "data";
            public static final String DATA_SET = "com.android.contacts.extra.DATA_SET";
            public static final String EMAIL = "email";
            public static final String EMAIL_ISPRIMARY = "email_isprimary";
            public static final String EMAIL_TYPE = "email_type";
            public static final String FULL_MODE = "full_mode";
            public static final String IM_HANDLE = "im_handle";
            public static final String IM_ISPRIMARY = "im_isprimary";
            public static final String IM_PROTOCOL = "im_protocol";
            public static final String JOB_TITLE = "job_title";
            public static final String NAME = "name";
            public static final String NOTES = "notes";
            public static final String PHONE = "phone";
            public static final String PHONETIC_NAME = "phonetic_name";
            public static final String PHONE_ISPRIMARY = "phone_isprimary";
            public static final String PHONE_TYPE = "phone_type";
            public static final String POSTAL = "postal";
            public static final String POSTAL_ISPRIMARY = "postal_isprimary";
            public static final String POSTAL_TYPE = "postal_type";
            public static final String SECONDARY_EMAIL = "secondary_email";
            public static final String SECONDARY_EMAIL_TYPE = "secondary_email_type";
            public static final String SECONDARY_PHONE = "secondary_phone";
            public static final String SECONDARY_PHONE_TYPE = "secondary_phone_type";
            public static final String TERTIARY_EMAIL = "tertiary_email";
            public static final String TERTIARY_EMAIL_TYPE = "tertiary_email_type";
            public static final String TERTIARY_PHONE = "tertiary_phone";
            public static final String TERTIARY_PHONE_TYPE = "tertiary_phone_type";

            public Insert() {
            }
        }

        public static final class UI {

            public static final String FILTER_CONTACTS_ACTION = "com.android.contacts.action.FILTER_CONTACTS";
            public static final String FILTER_TEXT_EXTRA_KEY = "com.android.contacts.extra.FILTER_TEXT";
            public static final String GROUP_NAME_EXTRA_KEY = "com.android.contacts.extra.GROUP";
            public static final String LIST_ALL_CONTACTS_ACTION = "com.android.contacts.action.LIST_ALL_CONTACTS";
            public static final String LIST_CONTACTS_WITH_PHONES_ACTION = "com.android.contacts.action.LIST_CONTACTS_WITH_PHONES";
            public static final String LIST_DEFAULT = "com.android.contacts.action.LIST_DEFAULT";
            public static final String LIST_FREQUENT_ACTION = "com.android.contacts.action.LIST_FREQUENT";
            public static final String LIST_GROUP_ACTION = "com.android.contacts.action.LIST_GROUP";
            public static final String LIST_STARRED_ACTION = "com.android.contacts.action.LIST_STARRED";
            public static final String LIST_STREQUENT_ACTION = "com.android.contacts.action.LIST_STREQUENT";
            public static final String TITLE_EXTRA_KEY = "com.android.contacts.extra.TITLE_EXTRA";

            public UI() {
            }
        }


        public static final String ACTION_GET_MULTIPLE_PHONES = "com.android.contacts.action.GET_MULTIPLE_PHONES";
        public static final String ATTACH_IMAGE = "com.android.contacts.action.ATTACH_IMAGE";
        public static final String EXTRA_CREATE_DESCRIPTION = "com.android.contacts.action.CREATE_DESCRIPTION";
        public static final String EXTRA_EXCLUDE_MIMES = "exclude_mimes";
        public static final String EXTRA_FORCE_CREATE = "com.android.contacts.action.FORCE_CREATE";
        public static final String EXTRA_MODE = "mode";
        public static final String EXTRA_PHONE_URIS = "com.android.contacts.extra.PHONE_URIS";
        public static final String EXTRA_TARGET_RECT = "target_rect";
        public static final String INVITE_CONTACT = "com.android.contacts.action.INVITE_CONTACT";
        public static final int MODE_LARGE = 3;
        public static final int MODE_MEDIUM = 2;
        public static final int MODE_SMALL = 1;
        public static final String SEARCH_SUGGESTION_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_CLICKED";
        public static final String SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED";
        public static final String SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED";
        public static final String SHOW_OR_CREATE_CONTACT = "com.android.contacts.action.SHOW_OR_CREATE_CONTACT";

        public Intents() {
        }
    }

    public static final class DisplayPhoto {

        public static final Uri CONTENT_MAX_DIMENSIONS_URI;
        public static final Uri CONTENT_URI;
        public static final String DISPLAY_MAX_DIM = "display_max_dim";
        public static final String THUMBNAIL_MAX_DIM = "thumbnail_max_dim";

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");
            CONTENT_MAX_DIMENSIONS_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "photo_dimensions");
        }

        private DisplayPhoto() {
        }
    }

    public static final class QuickContact {

        public static void showQuickContact(Context context, Rect rect, Uri uri, int i, String as[]) {
            Context context1;
            for(context1 = context; (context1 instanceof ContextWrapper) && !(context1 instanceof Activity); context1 = ((ContextWrapper)context1).getBaseContext());
            int j;
            Intent intent;
            if(context1 instanceof Activity)
                j = 0x80000;
            else
                j = 0x10008000;
            intent = (new Intent("com.android.contacts.action.QUICK_CONTACT")).addFlags(j);
            intent.setData(uri);
            intent.setSourceBounds(rect);
            intent.putExtra("mode", i);
            intent.putExtra("exclude_mimes", as);
            context.startActivity(intent);
        }

        public static void showQuickContact(Context context, View view, Uri uri, int i, String as[]) {
            float f = context.getResources().getCompatibilityInfo().applicationScale;
            int ai[] = new int[2];
            view.getLocationOnScreen(ai);
            Rect rect = new Rect();
            rect.left = (int)(0.5F + f * (float)ai[0]);
            rect.top = (int)(0.5F + f * (float)ai[1]);
            rect.right = (int)(0.5F + f * (float)(ai[0] + view.getWidth()));
            rect.bottom = (int)(0.5F + f * (float)(ai[1] + view.getHeight()));
            showQuickContact(context, rect, uri, i, as);
        }

        public static final String ACTION_QUICK_CONTACT = "com.android.contacts.action.QUICK_CONTACT";
        public static final String EXTRA_EXCLUDE_MIMES = "exclude_mimes";
        public static final String EXTRA_MODE = "mode";
        public static final String EXTRA_TARGET_RECT = "target_rect";
        public static final int MODE_LARGE = 3;
        public static final int MODE_MEDIUM = 2;
        public static final int MODE_SMALL = 1;

        public QuickContact() {
        }
    }

    public static final class DataUsageFeedback {

        public static final Uri DELETE_USAGE_URI;
        public static final Uri FEEDBACK_URI;
        public static final String USAGE_TYPE = "type";
        public static final String USAGE_TYPE_CALL = "call";
        public static final String USAGE_TYPE_LONG_TEXT = "long_text";
        public static final String USAGE_TYPE_SHORT_TEXT = "short_text";

        static  {
            FEEDBACK_URI = Uri.withAppendedPath(Data.CONTENT_URI, "usagefeedback");
            DELETE_USAGE_URI = Uri.withAppendedPath(Contacts.CONTENT_URI, "delete_usage");
        }

        public DataUsageFeedback() {
        }
    }

    public static final class ProviderStatus {

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/provider_status";
        public static final Uri CONTENT_URI;
        public static final String DATA1 = "data1";
        public static final String STATUS = "status";
        public static final int STATUS_CHANGING_LOCALE = 3;
        public static final int STATUS_NORMAL = 0;
        public static final int STATUS_NO_ACCOUNTS_NO_CONTACTS = 4;
        public static final int STATUS_UPGRADE_OUT_OF_MEMORY = 2;
        public static final int STATUS_UPGRADING = 1;

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "provider_status");
        }

        private ProviderStatus() {
        }
    }

    public static final class Settings
        implements SettingsColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/setting";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/setting";
        public static final Uri CONTENT_URI;

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "settings");
        }

        private Settings() {
        }
    }

    protected static interface SettingsColumns {

        public static final String ACCOUNT_NAME = "account_name";
        public static final String ACCOUNT_TYPE = "account_type";
        public static final String ANY_UNSYNCED = "any_unsynced";
        public static final String DATA_SET = "data_set";
        public static final String SHOULD_SYNC = "should_sync";
        public static final String UNGROUPED_COUNT = "summ_count";
        public static final String UNGROUPED_VISIBLE = "ungrouped_visible";
        public static final String UNGROUPED_WITH_PHONES = "summ_phones";
    }

    public static final class AggregationExceptions
        implements BaseColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/aggregation_exception";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/aggregation_exception";
        public static final Uri CONTENT_URI;
        public static final String RAW_CONTACT_ID1 = "raw_contact_id1";
        public static final String RAW_CONTACT_ID2 = "raw_contact_id2";
        public static final String TYPE = "type";
        public static final int TYPE_AUTOMATIC = 0;
        public static final int TYPE_KEEP_SEPARATE = 2;
        public static final int TYPE_KEEP_TOGETHER = 1;

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "aggregation_exceptions");
        }

        private AggregationExceptions() {
        }
    }

    public static final class Groups
        implements BaseColumns, GroupsColumns, SyncColumns {
        private static class EntityIteratorImpl extends CursorEntityIterator {

            public android.content.Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                ContentValues contentvalues = new ContentValues();
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "_id");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "account_name");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "account_type");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "dirty");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "version");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sourceid");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "res_package");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "title");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "title_res");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "group_visible");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync1");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync2");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync3");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync4");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "system_id");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "deleted");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "notes");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "should_sync");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "favorites");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "auto_add");
                cursor.moveToNext();
                return new android.content.Entity(contentvalues);
            }

            public EntityIteratorImpl(Cursor cursor) {
                super(cursor);
            }
        }


        public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/group";
        public static final Uri CONTENT_SUMMARY_URI;
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/group";
        public static final Uri CONTENT_URI;

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "groups");
            CONTENT_SUMMARY_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "groups_summary");
        }

        private Groups() {
        }
    }

    protected static interface GroupsColumns {

        public static final String ACCOUNT_TYPE_AND_DATA_SET = "account_type_and_data_set";
        public static final String AUTO_ADD = "auto_add";
        public static final String DATA_SET = "data_set";
        public static final String DELETED = "deleted";
        public static final String FAVORITES = "favorites";
        public static final String GROUP_IS_READ_ONLY = "group_is_read_only";
        public static final String GROUP_VISIBLE = "group_visible";
        public static final String NOTES = "notes";
        public static final String PARAM_RETURN_GROUP_COUNT_PER_ACCOUNT = "return_group_count_per_account";
        public static final String RES_PACKAGE = "res_package";
        public static final String SHOULD_SYNC = "should_sync";
        public static final String SUMMARY_COUNT = "summ_count";
        public static final String SUMMARY_GROUP_COUNT_PER_ACCOUNT = "group_count_per_account";
        public static final String SUMMARY_WITH_PHONES = "summ_phones";
        public static final String SYSTEM_ID = "system_id";
        public static final String TITLE = "title";
        public static final String TITLE_RES = "title_res";
    }

    public static final class CommonDataKinds {
        public static final class Callable
            implements DataColumnsWithJoins, CommonColumns {

            public static final Uri CONTENT_FILTER_URI;
            public static final Uri CONTENT_URI;

            static  {
                CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI, "callables");
                CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI, "filter");
            }

            public Callable() {
            }
        }

        public static final class Identity
            implements DataColumnsWithJoins {

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/identity";
            public static final String IDENTITY = "data1";
            public static final String NAMESPACE = "data2";

            private Identity() {
            }
        }

        public static final class SipAddress
            implements DataColumnsWithJoins, CommonColumns {

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charsequence) {
                if(i != 0 || TextUtils.isEmpty(charsequence))
                    charsequence = resources.getText(getTypeLabelResource(i));
                return charsequence;
            }

            public static final int getTypeLabelResource(int i) {
                i;
                JVM INSTR tableswitch 1 3: default 28
            //                           1 33
            //                           2 39
            //                           3 45;
                   goto _L1 _L2 _L3 _L4
_L1:
                int j = 0x10402e8;
_L6:
                return j;
_L2:
                j = 0x10402e9;
                continue; /* Loop/switch isn't completed */
_L3:
                j = 0x10402ea;
                continue; /* Loop/switch isn't completed */
_L4:
                j = 0x10402eb;
                if(true) goto _L6; else goto _L5
_L5:
            }

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/sip_address";
            public static final String SIP_ADDRESS = "data1";
            public static final int TYPE_HOME = 1;
            public static final int TYPE_OTHER = 3;
            public static final int TYPE_WORK = 2;

            private SipAddress() {
            }
        }

        public static final class Website
            implements DataColumnsWithJoins, CommonColumns {

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/website";
            public static final int TYPE_BLOG = 2;
            public static final int TYPE_FTP = 6;
            public static final int TYPE_HOME = 4;
            public static final int TYPE_HOMEPAGE = 1;
            public static final int TYPE_OTHER = 7;
            public static final int TYPE_PROFILE = 3;
            public static final int TYPE_WORK = 5;
            public static final String URL = "data1";

            private Website() {
            }
        }

        public static final class GroupMembership
            implements DataColumnsWithJoins {

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/group_membership";
            public static final String GROUP_ROW_ID = "data1";
            public static final String GROUP_SOURCE_ID = "group_sourceid";

            private GroupMembership() {
            }
        }

        public static final class Note
            implements DataColumnsWithJoins {

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/note";
            public static final String NOTE = "data1";

            private Note() {
            }
        }

        public static final class Photo
            implements DataColumnsWithJoins {

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/photo";
            public static final String PHOTO = "data15";
            public static final String PHOTO_FILE_ID = "data14";

            private Photo() {
            }
        }

        public static final class Event
            implements DataColumnsWithJoins, CommonColumns {

            public static int getTypeResource(Integer integer) {
                int i = 0x10402be;
                if(integer != null) goto _L2; else goto _L1
_L1:
                return i;
_L2:
                switch(integer.intValue()) {
                default:
                    i = 0x10402bb;
                    break;

                case 1: // '\001'
                    i = 0x10402bd;
                    break;

                case 3: // '\003'
                    i = 0x10402bc;
                    break;

                case 2: // '\002'
                    break;
                }
                if(true) goto _L1; else goto _L3
_L3:
            }

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_event";
            public static final String START_DATE = "data1";
            public static final int TYPE_ANNIVERSARY = 1;
            public static final int TYPE_BIRTHDAY = 3;
            public static final int TYPE_OTHER = 2;

            private Event() {
            }
        }

        public static final class Relation
            implements DataColumnsWithJoins, CommonColumns {

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charsequence) {
                if(i != 0 || TextUtils.isEmpty(charsequence))
                    charsequence = resources.getText(getTypeLabelResource(i));
                return charsequence;
            }

            public static final int getTypeLabelResource(int i) {
                i;
                JVM INSTR tableswitch 1 14: default 72
            //                           1 77
            //                           2 83
            //                           3 89
            //                           4 95
            //                           5 101
            //                           6 107
            //                           7 113
            //                           8 119
            //                           9 125
            //                           10 131
            //                           11 137
            //                           12 143
            //                           13 149
            //                           14 155;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
                int j = 0x10402d8;
_L17:
                return j;
_L2:
                j = 0x10402da;
                continue; /* Loop/switch isn't completed */
_L3:
                j = 0x10402db;
                continue; /* Loop/switch isn't completed */
_L4:
                j = 0x10402dc;
                continue; /* Loop/switch isn't completed */
_L5:
                j = 0x10402dd;
                continue; /* Loop/switch isn't completed */
_L6:
                j = 0x10402de;
                continue; /* Loop/switch isn't completed */
_L7:
                j = 0x10402df;
                continue; /* Loop/switch isn't completed */
_L8:
                j = 0x10402e0;
                continue; /* Loop/switch isn't completed */
_L9:
                j = 0x10402e1;
                continue; /* Loop/switch isn't completed */
_L10:
                j = 0x10402e2;
                continue; /* Loop/switch isn't completed */
_L11:
                j = 0x10402e3;
                continue; /* Loop/switch isn't completed */
_L12:
                j = 0x10402e4;
                continue; /* Loop/switch isn't completed */
_L13:
                j = 0x10402e5;
                continue; /* Loop/switch isn't completed */
_L14:
                j = 0x10402e6;
                continue; /* Loop/switch isn't completed */
_L15:
                j = 0x10402e7;
                if(true) goto _L17; else goto _L16
_L16:
            }

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/relation";
            public static final String NAME = "data1";
            public static final int TYPE_ASSISTANT = 1;
            public static final int TYPE_BROTHER = 2;
            public static final int TYPE_CHILD = 3;
            public static final int TYPE_DOMESTIC_PARTNER = 4;
            public static final int TYPE_FATHER = 5;
            public static final int TYPE_FRIEND = 6;
            public static final int TYPE_MANAGER = 7;
            public static final int TYPE_MOTHER = 8;
            public static final int TYPE_PARENT = 9;
            public static final int TYPE_PARTNER = 10;
            public static final int TYPE_REFERRED_BY = 11;
            public static final int TYPE_RELATIVE = 12;
            public static final int TYPE_SISTER = 13;
            public static final int TYPE_SPOUSE = 14;

            private Relation() {
            }
        }

        public static final class Organization
            implements DataColumnsWithJoins, CommonColumns {

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charsequence) {
                if(i != 0 || TextUtils.isEmpty(charsequence))
                    charsequence = resources.getText(getTypeLabelResource(i));
                return charsequence;
            }

            public static final int getTypeLabelResource(int i) {
                i;
                JVM INSTR tableswitch 1 2: default 24
            //                           1 29
            //                           2 35;
                   goto _L1 _L2 _L3
_L1:
                int j = 0x10402d8;
_L5:
                return j;
_L2:
                j = 0x10402d6;
                continue; /* Loop/switch isn't completed */
_L3:
                j = 0x10402d7;
                if(true) goto _L5; else goto _L4
_L4:
            }

            public static final String COMPANY = "data1";
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/organization";
            public static final String DEPARTMENT = "data5";
            public static final String JOB_DESCRIPTION = "data6";
            public static final String OFFICE_LOCATION = "data9";
            public static final String PHONETIC_NAME = "data8";
            public static final String PHONETIC_NAME_STYLE = "data10";
            public static final String SYMBOL = "data7";
            public static final String TITLE = "data4";
            public static final int TYPE_OTHER = 2;
            public static final int TYPE_WORK = 1;

            private Organization() {
            }
        }

        public static final class Im
            implements DataColumnsWithJoins, CommonColumns {

            public static final CharSequence getProtocolLabel(Resources resources, int i, CharSequence charsequence) {
                if(i != -1 || TextUtils.isEmpty(charsequence))
                    charsequence = resources.getText(getProtocolLabelResource(i));
                return charsequence;
            }

            public static final int getProtocolLabelResource(int i) {
                i;
                JVM INSTR tableswitch 0 8: default 52
            //                           0 57
            //                           1 63
            //                           2 69
            //                           3 75
            //                           4 81
            //                           5 87
            //                           6 93
            //                           7 99
            //                           8 105;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
                int j = 0x10402cc;
_L12:
                return j;
_L2:
                j = 0x10402cd;
                continue; /* Loop/switch isn't completed */
_L3:
                j = 0x10402ce;
                continue; /* Loop/switch isn't completed */
_L4:
                j = 0x10402cf;
                continue; /* Loop/switch isn't completed */
_L5:
                j = 0x10402d0;
                continue; /* Loop/switch isn't completed */
_L6:
                j = 0x10402d1;
                continue; /* Loop/switch isn't completed */
_L7:
                j = 0x10402d2;
                continue; /* Loop/switch isn't completed */
_L8:
                j = 0x10402d3;
                continue; /* Loop/switch isn't completed */
_L9:
                j = 0x10402d4;
                continue; /* Loop/switch isn't completed */
_L10:
                j = 0x10402d5;
                if(true) goto _L12; else goto _L11
_L11:
            }

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charsequence) {
                if(i != 0 || TextUtils.isEmpty(charsequence))
                    charsequence = resources.getText(getTypeLabelResource(i));
                return charsequence;
            }

            public static final int getTypeLabelResource(int i) {
                i;
                JVM INSTR tableswitch 1 3: default 28
            //                           1 33
            //                           2 39
            //                           3 45;
                   goto _L1 _L2 _L3 _L4
_L1:
                int j = 0x10402c8;
_L6:
                return j;
_L2:
                j = 0x10402c9;
                continue; /* Loop/switch isn't completed */
_L3:
                j = 0x10402ca;
                continue; /* Loop/switch isn't completed */
_L4:
                j = 0x10402cb;
                if(true) goto _L6; else goto _L5
_L5:
            }

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/im";
            public static final String CUSTOM_PROTOCOL = "data6";
            public static final String PROTOCOL = "data5";
            public static final int PROTOCOL_AIM = 0;
            public static final int PROTOCOL_CUSTOM = -1;
            public static final int PROTOCOL_GOOGLE_TALK = 5;
            public static final int PROTOCOL_ICQ = 6;
            public static final int PROTOCOL_JABBER = 7;
            public static final int PROTOCOL_MSN = 1;
            public static final int PROTOCOL_NETMEETING = 8;
            public static final int PROTOCOL_QQ = 4;
            public static final int PROTOCOL_SKYPE = 3;
            public static final int PROTOCOL_YAHOO = 2;
            public static final int TYPE_HOME = 1;
            public static final int TYPE_OTHER = 3;
            public static final int TYPE_WORK = 2;

            private Im() {
            }
        }

        public static final class StructuredPostal
            implements DataColumnsWithJoins, CommonColumns {

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charsequence) {
                if(i != 0 || TextUtils.isEmpty(charsequence))
                    charsequence = resources.getText(getTypeLabelResource(i));
                return charsequence;
            }

            public static final int getTypeLabelResource(int i) {
                i;
                JVM INSTR tableswitch 1 3: default 28
            //                           1 33
            //                           2 39
            //                           3 45;
                   goto _L1 _L2 _L3 _L4
_L1:
                int j = 0x10402c4;
_L6:
                return j;
_L2:
                j = 0x10402c5;
                continue; /* Loop/switch isn't completed */
_L3:
                j = 0x10402c6;
                continue; /* Loop/switch isn't completed */
_L4:
                j = 0x10402c7;
                if(true) goto _L6; else goto _L5
_L5:
            }

            public static final String CITY = "data7";
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/postal-address_v2";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/postal-address_v2";
            public static final Uri CONTENT_URI;
            public static final String COUNTRY = "data10";
            public static final String FORMATTED_ADDRESS = "data1";
            public static final String NEIGHBORHOOD = "data6";
            public static final String POBOX = "data5";
            public static final String POSTCODE = "data9";
            public static final String REGION = "data8";
            public static final String STREET = "data4";
            public static final int TYPE_HOME = 1;
            public static final int TYPE_OTHER = 3;
            public static final int TYPE_WORK = 2;

            static  {
                CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI, "postals");
            }

            private StructuredPostal() {
            }
        }

        public static final class Email
            implements DataColumnsWithJoins, CommonColumns {

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charsequence) {
                if(i != 0 || TextUtils.isEmpty(charsequence))
                    charsequence = resources.getText(getTypeLabelResource(i));
                return charsequence;
            }

            public static final int getTypeLabelResource(int i) {
                i;
                JVM INSTR tableswitch 1 4: default 32
            //                           1 37
            //                           2 43
            //                           3 49
            //                           4 55;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                int j = 0x10402bf;
_L7:
                return j;
_L2:
                j = 0x10402c0;
                continue; /* Loop/switch isn't completed */
_L3:
                j = 0x10402c1;
                continue; /* Loop/switch isn't completed */
_L4:
                j = 0x10402c2;
                continue; /* Loop/switch isn't completed */
_L5:
                j = 0x10402c3;
                if(true) goto _L7; else goto _L6
_L6:
            }

            public static final String ADDRESS = "data1";
            public static final Uri CONTENT_FILTER_URI;
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/email_v2";
            public static final Uri CONTENT_LOOKUP_URI;
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/email_v2";
            public static final Uri CONTENT_URI;
            public static final String DISPLAY_NAME = "data4";
            public static final int TYPE_HOME = 1;
            public static final int TYPE_MOBILE = 4;
            public static final int TYPE_OTHER = 3;
            public static final int TYPE_WORK = 2;

            static  {
                CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI, "emails");
                CONTENT_LOOKUP_URI = Uri.withAppendedPath(CONTENT_URI, "lookup");
                CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI, "filter");
            }

            private Email() {
            }
        }

        public static final class Phone
            implements DataColumnsWithJoins, CommonColumns {

            public static final CharSequence getDisplayLabel(Context context, int i, CharSequence charsequence) {
                return getTypeLabel(context.getResources(), i, charsequence);
            }

            public static final CharSequence getDisplayLabel(Context context, int i, CharSequence charsequence, CharSequence acharsequence[]) {
                return getTypeLabel(context.getResources(), i, charsequence);
            }

            public static final CharSequence getTypeLabel(Resources resources, int i, CharSequence charsequence) {
                if(i != 0 && i != 19 || TextUtils.isEmpty(charsequence))
                    charsequence = resources.getText(getTypeLabelResource(i));
                return charsequence;
            }

            public static final int getTypeLabelResource(int i) {
                i;
                JVM INSTR tableswitch 1 20: default 96
            //                           1 101
            //                           2 107
            //                           3 113
            //                           4 119
            //                           5 125
            //                           6 131
            //                           7 137
            //                           8 143
            //                           9 149
            //                           10 155
            //                           11 161
            //                           12 167
            //                           13 173
            //                           14 179
            //                           15 185
            //                           16 191
            //                           17 197
            //                           18 203
            //                           19 209
            //                           20 215;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L1:
                int j = 0x10402a6;
_L23:
                return j;
_L2:
                j = 0x10402a7;
                continue; /* Loop/switch isn't completed */
_L3:
                j = 0x10402a8;
                continue; /* Loop/switch isn't completed */
_L4:
                j = 0x10402a9;
                continue; /* Loop/switch isn't completed */
_L5:
                j = 0x10402aa;
                continue; /* Loop/switch isn't completed */
_L6:
                j = 0x10402ab;
                continue; /* Loop/switch isn't completed */
_L7:
                j = 0x10402ac;
                continue; /* Loop/switch isn't completed */
_L8:
                j = 0x10402ad;
                continue; /* Loop/switch isn't completed */
_L9:
                j = 0x10402ae;
                continue; /* Loop/switch isn't completed */
_L10:
                j = 0x10402af;
                continue; /* Loop/switch isn't completed */
_L11:
                j = 0x10402b0;
                continue; /* Loop/switch isn't completed */
_L12:
                j = 0x10402b1;
                continue; /* Loop/switch isn't completed */
_L13:
                j = 0x10402b2;
                continue; /* Loop/switch isn't completed */
_L14:
                j = 0x10402b3;
                continue; /* Loop/switch isn't completed */
_L15:
                j = 0x10402b4;
                continue; /* Loop/switch isn't completed */
_L16:
                j = 0x10402b5;
                continue; /* Loop/switch isn't completed */
_L17:
                j = 0x10402b6;
                continue; /* Loop/switch isn't completed */
_L18:
                j = 0x10402b7;
                continue; /* Loop/switch isn't completed */
_L19:
                j = 0x10402b8;
                continue; /* Loop/switch isn't completed */
_L20:
                j = 0x10402b9;
                continue; /* Loop/switch isn't completed */
_L21:
                j = 0x10402ba;
                if(true) goto _L23; else goto _L22
_L22:
            }

            public static final Uri CONTENT_FILTER_URI;
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone_v2";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_v2";
            public static final Uri CONTENT_URI;
            public static final String NORMALIZED_NUMBER = "data4";
            public static final String NUMBER = "data1";
            public static final String SEARCH_DISPLAY_NAME_KEY = "search_display_name";
            public static final String SEARCH_PHONE_NUMBER_KEY = "search_phone_number";
            public static final int TYPE_ASSISTANT = 19;
            public static final int TYPE_CALLBACK = 8;
            public static final int TYPE_CAR = 9;
            public static final int TYPE_COMPANY_MAIN = 10;
            public static final int TYPE_FAX_HOME = 5;
            public static final int TYPE_FAX_WORK = 4;
            public static final int TYPE_HOME = 1;
            public static final int TYPE_ISDN = 11;
            public static final int TYPE_MAIN = 12;
            public static final int TYPE_MMS = 20;
            public static final int TYPE_MOBILE = 2;
            public static final int TYPE_OTHER = 7;
            public static final int TYPE_OTHER_FAX = 13;
            public static final int TYPE_PAGER = 6;
            public static final int TYPE_RADIO = 14;
            public static final int TYPE_TELEX = 15;
            public static final int TYPE_TTY_TDD = 16;
            public static final int TYPE_WORK = 3;
            public static final int TYPE_WORK_MOBILE = 17;
            public static final int TYPE_WORK_PAGER = 18;

            static  {
                CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI, "phones");
                CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI, "filter");
            }

            private Phone() {
            }
        }

        public static final class Nickname
            implements DataColumnsWithJoins, CommonColumns {

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/nickname";
            public static final String NAME = "data1";
            public static final int TYPE_DEFAULT = 1;
            public static final int TYPE_INITIALS = 5;
            public static final int TYPE_MAIDEN_NAME = 3;
            public static final int TYPE_MAINDEN_NAME = 3;
            public static final int TYPE_OTHER_NAME = 2;
            public static final int TYPE_SHORT_NAME = 4;

            private Nickname() {
            }
        }

        public static final class StructuredName
            implements DataColumnsWithJoins {

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/name";
            public static final String DISPLAY_NAME = "data1";
            public static final String FAMILY_NAME = "data3";
            public static final String FULL_NAME_STYLE = "data10";
            public static final String GIVEN_NAME = "data2";
            public static final String MIDDLE_NAME = "data5";
            public static final String PHONETIC_FAMILY_NAME = "data9";
            public static final String PHONETIC_GIVEN_NAME = "data7";
            public static final String PHONETIC_MIDDLE_NAME = "data8";
            public static final String PHONETIC_NAME_STYLE = "data11";
            public static final String PREFIX = "data4";
            public static final String SUFFIX = "data6";

            private StructuredName() {
            }
        }

        protected static interface CommonColumns
            extends BaseTypes {

            public static final String DATA = "data1";
            public static final String LABEL = "data3";
            public static final String TYPE = "data2";
        }

        public static interface BaseTypes {

            public static final int TYPE_CUSTOM;
        }


        public static final String PACKAGE_COMMON = "common";

        private CommonDataKinds() {
        }
    }

    public static class SearchSnippetColumns {

        public static final String DEFERRED_SNIPPETING_KEY = "deferred_snippeting";
        public static final String SNIPPET = "snippet";
        public static final String SNIPPET_ARGS_PARAM_KEY = "snippet_args";

        public SearchSnippetColumns() {
        }
    }

    public static final class Presence extends StatusUpdates {

        public Presence() {
        }
    }

    public static class StatusUpdates
        implements StatusColumns, PresenceColumns {

        public static final int getPresenceIconResourceId(int i) {
            i;
            JVM INSTR tableswitch 1 5: default 36
        //                       1 59
        //                       2 47
        //                       3 47
        //                       4 53
        //                       5 41;
               goto _L1 _L2 _L3 _L3 _L4 _L5
_L1:
            int j = 0x108006a;
_L7:
            return j;
_L5:
            j = 0x108006b;
            continue; /* Loop/switch isn't completed */
_L3:
            j = 0x1080067;
            continue; /* Loop/switch isn't completed */
_L4:
            j = 0x1080068;
            continue; /* Loop/switch isn't completed */
_L2:
            j = 0x1080069;
            if(true) goto _L7; else goto _L6
_L6:
        }

        public static final int getPresencePrecedence(int i) {
            return i;
        }

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/status-update";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/status-update";
        public static final Uri CONTENT_URI;
        public static final Uri PROFILE_CONTENT_URI;

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "status_updates");
            PROFILE_CONTENT_URI = Uri.withAppendedPath(Profile.CONTENT_URI, "status_updates");
        }

        private StatusUpdates() {
        }

    }

    protected static interface PresenceColumns {

        public static final String CUSTOM_PROTOCOL = "custom_protocol";
        public static final String DATA_ID = "presence_data_id";
        public static final String IM_ACCOUNT = "im_account";
        public static final String IM_HANDLE = "im_handle";
        public static final String PROTOCOL = "protocol";
    }

    public static final class PhoneLookup
        implements BaseColumns, PhoneLookupColumns, ContactsColumns, ContactOptionsColumns {

        public static final Uri CONTENT_FILTER_URI;
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_lookup";
        public static final String QUERY_PARAMETER_SIP_ADDRESS = "sip";

        static  {
            CONTENT_FILTER_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "phone_lookup");
        }

        private PhoneLookup() {
        }
    }

    protected static interface PhoneLookupColumns {

        public static final String LABEL = "label";
        public static final String NORMALIZED_NUMBER = "normalized_number";
        public static final String NUMBER = "number";
        public static final String TYPE = "type";
    }

    public static final class RawContactsEntity
        implements BaseColumns, DataColumns, RawContactsColumns {

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact_entity";
        public static final Uri CONTENT_URI;
        public static final String DATA_ID = "data_id";
        public static final String FOR_EXPORT_ONLY = "for_export_only";
        public static final Uri PROFILE_CONTENT_URI;

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "raw_contact_entities");
            PROFILE_CONTENT_URI = Uri.withAppendedPath(Profile.CONTENT_URI, "raw_contact_entities");
        }

        private RawContactsEntity() {
        }
    }

    public static final class Data
        implements DataColumnsWithJoins {

        public static Uri getContactLookupUri(ContentResolver contentresolver, Uri uri) {
            Cursor cursor;
            Uri uri1;
            String as[] = new String[2];
            as[0] = "contact_id";
            as[1] = "lookup";
            cursor = contentresolver.query(uri, as, null, null, null);
            uri1 = null;
            if(cursor == null) goto _L2; else goto _L1
_L1:
            if(!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
            Uri uri2 = Contacts.getLookupUri(cursor.getLong(0), cursor.getString(1));
            uri1 = uri2;
            if(cursor != null)
                cursor.close();
_L5:
            return uri1;
_L2:
            if(cursor != null)
                cursor.close();
            if(true) goto _L5; else goto _L4
_L4:
            Exception exception;
            exception;
            if(cursor != null)
                cursor.close();
            throw exception;
        }

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/data";
        public static final Uri CONTENT_URI;

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "data");
        }

        private Data() {
        }
    }

    protected static interface DataColumnsWithJoins
        extends BaseColumns, DataColumns, StatusColumns, RawContactsColumns, ContactsColumns, ContactNameColumns, ContactOptionsColumns, ContactStatusColumns {
    }

    protected static interface DataColumns {

        public static final String DATA1 = "data1";
        public static final String DATA10 = "data10";
        public static final String DATA11 = "data11";
        public static final String DATA12 = "data12";
        public static final String DATA13 = "data13";
        public static final String DATA14 = "data14";
        public static final String DATA15 = "data15";
        public static final String DATA2 = "data2";
        public static final String DATA3 = "data3";
        public static final String DATA4 = "data4";
        public static final String DATA5 = "data5";
        public static final String DATA6 = "data6";
        public static final String DATA7 = "data7";
        public static final String DATA8 = "data8";
        public static final String DATA9 = "data9";
        public static final String DATA_VERSION = "data_version";
        public static final String IS_PRIMARY = "is_primary";
        public static final String IS_READ_ONLY = "is_read_only";
        public static final String IS_SUPER_PRIMARY = "is_super_primary";
        public static final String MIMETYPE = "mimetype";
        public static final String RAW_CONTACT_ID = "raw_contact_id";
        public static final String RES_PACKAGE = "res_package";
        public static final String SYNC1 = "data_sync1";
        public static final String SYNC2 = "data_sync2";
        public static final String SYNC3 = "data_sync3";
        public static final String SYNC4 = "data_sync4";
    }

    protected static interface PhotoFilesColumns {

        public static final String FILESIZE = "filesize";
        public static final String HEIGHT = "height";
        public static final String WIDTH = "width";
    }

    public static final class PhotoFiles
        implements BaseColumns, PhotoFilesColumns {

        private PhotoFiles() {
        }
    }

    protected static interface StreamItemPhotosColumns {

        public static final String PHOTO_FILE_ID = "photo_file_id";
        public static final String PHOTO_URI = "photo_uri";
        public static final String SORT_INDEX = "sort_index";
        public static final String STREAM_ITEM_ID = "stream_item_id";
        public static final String SYNC1 = "stream_item_photo_sync1";
        public static final String SYNC2 = "stream_item_photo_sync2";
        public static final String SYNC3 = "stream_item_photo_sync3";
        public static final String SYNC4 = "stream_item_photo_sync4";
    }

    public static final class StreamItemPhotos
        implements BaseColumns, StreamItemPhotosColumns {

        public static final String PHOTO = "photo";

        private StreamItemPhotos() {
        }
    }

    protected static interface StreamItemsColumns {

        public static final String ACCOUNT_NAME = "account_name";
        public static final String ACCOUNT_TYPE = "account_type";
        public static final String COMMENTS = "comments";
        public static final String CONTACT_ID = "contact_id";
        public static final String CONTACT_LOOKUP_KEY = "contact_lookup";
        public static final String DATA_SET = "data_set";
        public static final String RAW_CONTACT_ID = "raw_contact_id";
        public static final String RAW_CONTACT_SOURCE_ID = "raw_contact_source_id";
        public static final String RES_ICON = "icon";
        public static final String RES_LABEL = "label";
        public static final String RES_PACKAGE = "res_package";
        public static final String SYNC1 = "stream_item_sync1";
        public static final String SYNC2 = "stream_item_sync2";
        public static final String SYNC3 = "stream_item_sync3";
        public static final String SYNC4 = "stream_item_sync4";
        public static final String TEXT = "text";
        public static final String TIMESTAMP = "timestamp";
    }

    public static final class StreamItems
        implements BaseColumns, StreamItemsColumns {
        public static final class StreamItemPhotos
            implements BaseColumns, StreamItemPhotosColumns {

            public static final String CONTENT_DIRECTORY = "photo";
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/stream_item_photo";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item_photo";

            private StreamItemPhotos() {
            }
        }


        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/stream_item";
        public static final Uri CONTENT_LIMIT_URI;
        public static final Uri CONTENT_PHOTO_URI;
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item";
        public static final Uri CONTENT_URI;
        public static final String MAX_ITEMS = "max_items";

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "stream_items");
            CONTENT_PHOTO_URI = Uri.withAppendedPath(CONTENT_URI, "photo");
            CONTENT_LIMIT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "stream_items_limit");
        }

        private StreamItems() {
        }
    }

    protected static interface StatusColumns {

        public static final int AVAILABLE = 5;
        public static final int AWAY = 2;
        public static final int CAPABILITY_HAS_CAMERA = 4;
        public static final int CAPABILITY_HAS_VIDEO = 2;
        public static final int CAPABILITY_HAS_VOICE = 1;
        public static final String CHAT_CAPABILITY = "chat_capability";
        public static final int DO_NOT_DISTURB = 4;
        public static final int IDLE = 3;
        public static final int INVISIBLE = 1;
        public static final int OFFLINE = 0;
        public static final String PRESENCE = "mode";
        public static final String PRESENCE_CUSTOM_STATUS = "status";
        public static final String PRESENCE_STATUS = "mode";
        public static final String STATUS = "status";
        public static final String STATUS_ICON = "status_icon";
        public static final String STATUS_LABEL = "status_label";
        public static final String STATUS_RES_PACKAGE = "status_res_package";
        public static final String STATUS_TIMESTAMP = "status_ts";
    }

    public static final class RawContacts
        implements BaseColumns, RawContactsColumns, ContactOptionsColumns, ContactNameColumns, SyncColumns {
        private static class EntityIteratorImpl extends CursorEntityIterator {

            public android.content.Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                int i;
                long l;
                android.content.Entity entity;
                i = cursor.getColumnIndexOrThrow("_id");
                l = cursor.getLong(i);
                ContentValues contentvalues = new ContentValues();
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "account_name");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "account_type");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "data_set");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "_id");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "dirty");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "version");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sourceid");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync1");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync2");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync3");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues, "sync4");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "deleted");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "contact_id");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues, "starred");
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, contentvalues, "name_verified");
                entity = new android.content.Entity(contentvalues);
_L7:
                if(l == cursor.getLong(i)) goto _L2; else goto _L1
_L1:
                return entity;
_L2:
                ContentValues contentvalues1;
                String as[];
                int j;
                int k;
                contentvalues1 = new ContentValues();
                contentvalues1.put("_id", Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow("data_id"))));
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues1, "res_package");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues1, "mimetype");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues1, "is_primary");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues1, "is_super_primary");
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, contentvalues1, "data_version");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues1, "group_sourceid");
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, contentvalues1, "data_version");
                as = DATA_KEYS;
                j = as.length;
                k = 0;
_L4:
                String s;
                int i1;
                if(k >= j)
                    break MISSING_BLOCK_LABEL_389;
                s = as[k];
                i1 = cursor.getColumnIndexOrThrow(s);
                switch(cursor.getType(i1)) {
                default:
                    throw new IllegalStateException("Invalid or unhandled data type");

                case 0: // '\0'
                    break;

                case 4: // '\004'
                    break; /* Loop/switch isn't completed */

                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                    contentvalues1.put(s, cursor.getString(i1));
                    break;
                }
_L5:
                k++;
                if(true) goto _L4; else goto _L3
_L3:
                contentvalues1.put(s, cursor.getBlob(i1));
                  goto _L5
                if(true) goto _L4; else goto _L6
_L6:
                entity.addSubValue(Data.CONTENT_URI, contentvalues1);
                if(cursor.moveToNext()) goto _L7; else goto _L1
            }

            private static final String DATA_KEYS[];

            static  {
                String as[] = new String[19];
                as[0] = "data1";
                as[1] = "data2";
                as[2] = "data3";
                as[3] = "data4";
                as[4] = "data5";
                as[5] = "data6";
                as[6] = "data7";
                as[7] = "data8";
                as[8] = "data9";
                as[9] = "data10";
                as[10] = "data11";
                as[11] = "data12";
                as[12] = "data13";
                as[13] = "data14";
                as[14] = "data15";
                as[15] = "data_sync1";
                as[16] = "data_sync2";
                as[17] = "data_sync3";
                as[18] = "data_sync4";
                DATA_KEYS = as;
            }

            public EntityIteratorImpl(Cursor cursor) {
                super(cursor);
            }
        }

        public static final class DisplayPhoto {

            public static final String CONTENT_DIRECTORY = "display_photo";

            private DisplayPhoto() {
            }
        }

        public static final class StreamItems
            implements BaseColumns, StreamItemsColumns {

            public static final String CONTENT_DIRECTORY = "stream_items";

            private StreamItems() {
            }
        }

        public static final class Entity
            implements BaseColumns, DataColumns {

            public static final String CONTENT_DIRECTORY = "entity";
            public static final String DATA_ID = "data_id";

            private Entity() {
            }
        }

        public static final class Data
            implements BaseColumns, DataColumns {

            public static final String CONTENT_DIRECTORY = "data";

            private Data() {
            }
        }


        public static Uri getContactLookupUri(ContentResolver contentresolver, Uri uri) {
            Cursor cursor;
            Uri uri2;
            Uri uri1 = Uri.withAppendedPath(uri, "data");
            String as[] = new String[2];
            as[0] = "contact_id";
            as[1] = "lookup";
            cursor = contentresolver.query(uri1, as, null, null, null);
            uri2 = null;
            if(cursor == null) goto _L2; else goto _L1
_L1:
            if(!cursor.moveToFirst()) goto _L2; else goto _L3
_L3:
            Uri uri3 = Contacts.getLookupUri(cursor.getLong(0), cursor.getString(1));
            uri2 = uri3;
            if(cursor != null)
                cursor.close();
_L5:
            return uri2;
_L2:
            if(cursor != null)
                cursor.close();
            if(true) goto _L5; else goto _L4
_L4:
            Exception exception;
            exception;
            if(cursor != null)
                cursor.close();
            throw exception;
        }

        public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }

        public static final int AGGREGATION_MODE_DEFAULT = 0;
        public static final int AGGREGATION_MODE_DISABLED = 3;
        public static final int AGGREGATION_MODE_IMMEDIATE = 1;
        public static final int AGGREGATION_MODE_SUSPENDED = 2;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/raw_contact";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact";
        public static final Uri CONTENT_URI;

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "raw_contacts");
        }

        private RawContacts() {
        }
    }

    protected static interface RawContactsColumns {

        public static final String ACCOUNT_TYPE_AND_DATA_SET = "account_type_and_data_set";
        public static final String AGGREGATION_MODE = "aggregation_mode";
        public static final String CONTACT_ID = "contact_id";
        public static final String DATA_SET = "data_set";
        public static final String DELETED = "deleted";
        public static final String NAME_VERIFIED = "name_verified";
        public static final String RAW_CONTACT_IS_READ_ONLY = "raw_contact_is_read_only";
        public static final String RAW_CONTACT_IS_USER_PROFILE = "raw_contact_is_user_profile";
    }

    public static final class Profile
        implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactNameColumns, ContactStatusColumns {

        public static final Uri CONTENT_RAW_CONTACTS_URI;
        public static final Uri CONTENT_URI;
        public static final Uri CONTENT_VCARD_URI;
        public static final long MIN_ID = 0x7fffffff80000000L;

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "profile");
            CONTENT_VCARD_URI = Uri.withAppendedPath(CONTENT_URI, "as_vcard");
            CONTENT_RAW_CONTACTS_URI = Uri.withAppendedPath(CONTENT_URI, "raw_contacts");
        }

        private Profile() {
        }
    }

    public static class Contacts
        implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactNameColumns, ContactStatusColumns {
        public static final class Photo
            implements BaseColumns, DataColumnsWithJoins {

            public static final String CONTENT_DIRECTORY = "photo";
            public static final String DISPLAY_PHOTO = "display_photo";
            public static final String PHOTO = "data15";
            public static final String PHOTO_FILE_ID = "data14";

            private Photo() {
            }
        }

        public static final class AggregationSuggestions
            implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactStatusColumns {
            public static final class Builder {

                public Builder addParameter(String s, String s1) {
                    if(!TextUtils.isEmpty(s1)) {
                        mKinds.add(s);
                        mValues.add(s1);
                    }
                    return this;
                }

                public Uri build() {
                    android.net.Uri.Builder builder1 = Contacts.CONTENT_URI.buildUpon();
                    builder1.appendEncodedPath(String.valueOf(mContactId));
                    builder1.appendPath("suggestions");
                    if(mLimit != 0)
                        builder1.appendQueryParameter("limit", String.valueOf(mLimit));
                    int i = mKinds.size();
                    for(int j = 0; j < i; j++)
                        builder1.appendQueryParameter("query", (new StringBuilder()).append((String)mKinds.get(j)).append(":").append((String)mValues.get(j)).toString());

                    return builder1.build();
                }

                public Builder setContactId(long l) {
                    mContactId = l;
                    return this;
                }

                public Builder setLimit(int i) {
                    mLimit = i;
                    return this;
                }

                private long mContactId;
                private ArrayList mKinds;
                private int mLimit;
                private ArrayList mValues;

                public Builder() {
                    mKinds = new ArrayList();
                    mValues = new ArrayList();
                }
            }


            public static final Builder builder() {
                return new Builder();
            }

            public static final String CONTENT_DIRECTORY = "suggestions";
            public static final String PARAMETER_MATCH_EMAIL = "email";
            public static final String PARAMETER_MATCH_NAME = "name";
            public static final String PARAMETER_MATCH_NICKNAME = "nickname";
            public static final String PARAMETER_MATCH_PHONE = "phone";

            private AggregationSuggestions() {
            }
        }

        public static final class StreamItems
            implements StreamItemsColumns {

            public static final String CONTENT_DIRECTORY = "stream_items";

            private StreamItems() {
            }
        }

        public static final class Entity
            implements BaseColumns, ContactsColumns, ContactNameColumns, RawContactsColumns, BaseSyncColumns, SyncColumns, DataColumns, StatusColumns, ContactOptionsColumns, ContactStatusColumns {

            public static final String CONTENT_DIRECTORY = "entities";
            public static final String DATA_ID = "data_id";
            public static final String RAW_CONTACT_ID = "raw_contact_id";

            private Entity() {
            }
        }

        public static final class Data
            implements BaseColumns, DataColumns {

            public static final String CONTENT_DIRECTORY = "data";

            private Data() {
            }
        }


        public static Uri getLookupUri(long l, String s) {
            return ContentUris.withAppendedId(Uri.withAppendedPath(CONTENT_LOOKUP_URI, s), l);
        }

        public static Uri getLookupUri(ContentResolver contentresolver, Uri uri) {
            Uri uri1;
            Cursor cursor;
            uri1 = null;
            String as[] = new String[2];
            as[0] = "lookup";
            as[1] = "_id";
            cursor = contentresolver.query(uri, as, null, null, null);
            if(cursor != null) goto _L2; else goto _L1
_L1:
            return uri1;
_L2:
            Uri uri2;
            if(!cursor.moveToFirst())
                break MISSING_BLOCK_LABEL_83;
            String s = cursor.getString(0);
            uri2 = getLookupUri(cursor.getLong(1), s);
            uri1 = uri2;
            cursor.close();
            continue; /* Loop/switch isn't completed */
            cursor.close();
            if(true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            cursor.close();
            throw exception;
        }

        public static Uri lookupContact(ContentResolver contentresolver, Uri uri) {
            Uri uri1 = null;
            if(uri != null) goto _L2; else goto _L1
_L1:
            return uri1;
_L2:
            Cursor cursor;
            String as[] = new String[1];
            as[0] = "_id";
            cursor = contentresolver.query(uri, as, null, null, null);
            if(cursor == null)
                continue; /* Loop/switch isn't completed */
            Uri uri2;
            if(!cursor.moveToFirst())
                break MISSING_BLOCK_LABEL_77;
            long l = cursor.getLong(0);
            uri2 = ContentUris.withAppendedId(CONTENT_URI, l);
            uri1 = uri2;
            cursor.close();
            continue; /* Loop/switch isn't completed */
            cursor.close();
            if(true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            cursor.close();
            throw exception;
        }

        public static void markAsContacted(ContentResolver contentresolver, long l) {
            Uri uri = ContentUris.withAppendedId(CONTENT_URI, l);
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("last_time_contacted", Long.valueOf(System.currentTimeMillis()));
            contentresolver.update(uri, contentvalues, null, null);
        }

        public static InputStream openContactPhotoInputStream(ContentResolver contentresolver, Uri uri) {
            return openContactPhotoInputStream(contentresolver, uri, false);
        }

        public static InputStream openContactPhotoInputStream(ContentResolver contentresolver, Uri uri, boolean flag) {
            Object obj = null;
            if(!flag) goto _L2; else goto _L1
_L1:
            Uri uri2 = Uri.withAppendedPath(uri, "display_photo");
            java.io.FileInputStream fileinputstream = contentresolver.openAssetFileDescriptor(uri2, "r").createInputStream();
            obj = fileinputstream;
_L4:
            return ((InputStream) (obj));
            IOException ioexception;
            ioexception;
_L2:
            Cursor cursor;
            Uri uri1 = Uri.withAppendedPath(uri, "photo");
            if(uri1 == null)
                continue; /* Loop/switch isn't completed */
            String as[] = new String[1];
            as[0] = "data15";
            cursor = contentresolver.query(uri1, as, null, null, null);
            if(cursor == null)
                break MISSING_BLOCK_LABEL_91;
            boolean flag1 = cursor.moveToNext();
            if(flag1)
                break MISSING_BLOCK_LABEL_106;
            if(cursor != null)
                cursor.close();
            continue; /* Loop/switch isn't completed */
            byte abyte0[] = cursor.getBlob(0);
            if(abyte0 == null) {
                if(cursor != null)
                    cursor.close();
                continue; /* Loop/switch isn't completed */
            }
            obj = new ByteArrayInputStream(abyte0);
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

        public static final Uri CONTENT_FILTER_URI;
        public static final Uri CONTENT_FREQUENT_URI;
        public static final Uri CONTENT_GROUP_URI;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact";
        public static final Uri CONTENT_LOOKUP_URI;
        public static final Uri CONTENT_MULTI_VCARD_URI;
        public static final Uri CONTENT_STREQUENT_FILTER_URI;
        public static final Uri CONTENT_STREQUENT_URI;
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact";
        public static final Uri CONTENT_URI;
        public static final String CONTENT_VCARD_TYPE = "text/x-vcard";
        public static final Uri CONTENT_VCARD_URI;
        public static final String QUERY_PARAMETER_VCARD_NO_PHOTO = "nophoto";

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "contacts");
            CONTENT_LOOKUP_URI = Uri.withAppendedPath(CONTENT_URI, "lookup");
            CONTENT_VCARD_URI = Uri.withAppendedPath(CONTENT_URI, "as_vcard");
            CONTENT_MULTI_VCARD_URI = Uri.withAppendedPath(CONTENT_URI, "as_multi_vcard");
            CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI, "filter");
            CONTENT_STREQUENT_URI = Uri.withAppendedPath(CONTENT_URI, "strequent");
            CONTENT_FREQUENT_URI = Uri.withAppendedPath(CONTENT_URI, "frequent");
            CONTENT_STREQUENT_FILTER_URI = Uri.withAppendedPath(CONTENT_STREQUENT_URI, "filter");
            CONTENT_GROUP_URI = Uri.withAppendedPath(CONTENT_URI, "group");
        }

        private Contacts() {
        }
    }

    public static final class ContactCounts {

        public static final String ADDRESS_BOOK_INDEX_EXTRAS = "address_book_index_extras";
        public static final String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "address_book_index_counts";
        public static final String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "address_book_index_titles";

        public ContactCounts() {
        }
    }

    protected static interface ContactNameColumns {

        public static final String DISPLAY_NAME_ALTERNATIVE = "display_name_alt";
        public static final String DISPLAY_NAME_PRIMARY = "display_name";
        public static final String DISPLAY_NAME_SOURCE = "display_name_source";
        public static final String PHONETIC_NAME = "phonetic_name";
        public static final String PHONETIC_NAME_STYLE = "phonetic_name_style";
        public static final String SORT_KEY_ALTERNATIVE = "sort_key_alt";
        public static final String SORT_KEY_PRIMARY = "sort_key";
    }

    public static interface DisplayNameSources {

        public static final int EMAIL = 10;
        public static final int NICKNAME = 35;
        public static final int ORGANIZATION = 30;
        public static final int PHONE = 20;
        public static final int STRUCTURED_NAME = 40;
        public static final int UNDEFINED;
    }

    public static interface PhoneticNameStyle {

        public static final int JAPANESE = 4;
        public static final int KOREAN = 5;
        public static final int PINYIN = 3;
        public static final int UNDEFINED;
    }

    public static interface FullNameStyle {

        public static final int CHINESE = 3;
        public static final int CJK = 2;
        public static final int JAPANESE = 4;
        public static final int KOREAN = 5;
        public static final int UNDEFINED = 0;
        public static final int WESTERN = 1;
    }

    protected static interface ContactStatusColumns {

        public static final String CONTACT_CHAT_CAPABILITY = "contact_chat_capability";
        public static final String CONTACT_PRESENCE = "contact_presence";
        public static final String CONTACT_STATUS = "contact_status";
        public static final String CONTACT_STATUS_ICON = "contact_status_icon";
        public static final String CONTACT_STATUS_LABEL = "contact_status_label";
        public static final String CONTACT_STATUS_RES_PACKAGE = "contact_status_res_package";
        public static final String CONTACT_STATUS_TIMESTAMP = "contact_status_ts";
    }

    protected static interface ContactsColumns {

        public static final String DISPLAY_NAME = "display_name";
        public static final String HAS_PHONE_NUMBER = "has_phone_number";
        public static final String IN_VISIBLE_GROUP = "in_visible_group";
        public static final String IS_USER_PROFILE = "is_user_profile";
        public static final String LOOKUP_KEY = "lookup";
        public static final String NAME_RAW_CONTACT_ID = "name_raw_contact_id";
        public static final String PHOTO_FILE_ID = "photo_file_id";
        public static final String PHOTO_ID = "photo_id";
        public static final String PHOTO_THUMBNAIL_URI = "photo_thumb_uri";
        public static final String PHOTO_URI = "photo_uri";
    }

    protected static interface ContactOptionsColumns {

        public static final String CUSTOM_RINGTONE = "custom_ringtone";
        public static final String LAST_TIME_CONTACTED = "last_time_contacted";
        public static final String SEND_TO_VOICEMAIL = "send_to_voicemail";
        public static final String STARRED = "starred";
        public static final String TIMES_CONTACTED = "times_contacted";
    }

    protected static interface SyncColumns
        extends BaseSyncColumns {

        public static final String ACCOUNT_NAME = "account_name";
        public static final String ACCOUNT_TYPE = "account_type";
        public static final String DIRTY = "dirty";
        public static final String SOURCE_ID = "sourceid";
        public static final String VERSION = "version";
    }

    protected static interface BaseSyncColumns {

        public static final String SYNC1 = "sync1";
        public static final String SYNC2 = "sync2";
        public static final String SYNC3 = "sync3";
        public static final String SYNC4 = "sync4";
    }

    public static final class ProfileSyncState
        implements SyncStateContract.Columns {

        public static byte[] get(ContentProviderClient contentproviderclient, Account account) throws RemoteException {
            return SyncStateContract.Helpers.get(contentproviderclient, CONTENT_URI, account);
        }

        public static Pair getWithUri(ContentProviderClient contentproviderclient, Account account) throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(contentproviderclient, CONTENT_URI, account);
        }

        public static ContentProviderOperation newSetOperation(Account account, byte abyte0[]) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, abyte0);
        }

        public static void set(ContentProviderClient contentproviderclient, Account account, byte abyte0[]) throws RemoteException {
            SyncStateContract.Helpers.set(contentproviderclient, CONTENT_URI, account, abyte0);
        }

        public static final String CONTENT_DIRECTORY = "syncstate";
        public static final Uri CONTENT_URI;

        static  {
            CONTENT_URI = Uri.withAppendedPath(Profile.CONTENT_URI, "syncstate");
        }

        private ProfileSyncState() {
        }
    }

    public static final class SyncState
        implements SyncStateContract.Columns {

        public static byte[] get(ContentProviderClient contentproviderclient, Account account) throws RemoteException {
            return SyncStateContract.Helpers.get(contentproviderclient, CONTENT_URI, account);
        }

        public static Pair getWithUri(ContentProviderClient contentproviderclient, Account account) throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(contentproviderclient, CONTENT_URI, account);
        }

        public static ContentProviderOperation newSetOperation(Account account, byte abyte0[]) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, abyte0);
        }

        public static void set(ContentProviderClient contentproviderclient, Account account, byte abyte0[]) throws RemoteException {
            SyncStateContract.Helpers.set(contentproviderclient, CONTENT_URI, account, abyte0);
        }

        public static final String CONTENT_DIRECTORY = "syncstate";
        public static final Uri CONTENT_URI;

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "syncstate");
        }

        private SyncState() {
        }
    }

    public static interface SyncStateColumns
        extends SyncStateContract.Columns {
    }

    public static final class Directory
        implements BaseColumns {

        public static void notifyDirectoryChange(ContentResolver contentresolver) {
            ContentValues contentvalues = new ContentValues();
            contentresolver.update(CONTENT_URI, contentvalues, null, null);
        }

        public static final String ACCOUNT_NAME = "accountName";
        public static final String ACCOUNT_TYPE = "accountType";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_directory";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact_directories";
        public static final Uri CONTENT_URI;
        public static final long DEFAULT = 0L;
        public static final String DIRECTORY_AUTHORITY = "authority";
        public static final String DISPLAY_NAME = "displayName";
        public static final String EXPORT_SUPPORT = "exportSupport";
        public static final int EXPORT_SUPPORT_ANY_ACCOUNT = 2;
        public static final int EXPORT_SUPPORT_NONE = 0;
        public static final int EXPORT_SUPPORT_SAME_ACCOUNT_ONLY = 1;
        public static final long LOCAL_INVISIBLE = 1L;
        public static final String PACKAGE_NAME = "packageName";
        public static final String PHOTO_SUPPORT = "photoSupport";
        public static final int PHOTO_SUPPORT_FULL = 3;
        public static final int PHOTO_SUPPORT_FULL_SIZE_ONLY = 2;
        public static final int PHOTO_SUPPORT_NONE = 0;
        public static final int PHOTO_SUPPORT_THUMBNAIL_ONLY = 1;
        public static final String SHORTCUT_SUPPORT = "shortcutSupport";
        public static final int SHORTCUT_SUPPORT_DATA_ITEMS_ONLY = 1;
        public static final int SHORTCUT_SUPPORT_FULL = 2;
        public static final int SHORTCUT_SUPPORT_NONE = 0;
        public static final String TYPE_RESOURCE_ID = "typeResourceId";

        static  {
            CONTENT_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "directories");
        }

        private Directory() {
        }
    }

    public static final class Preferences {

        public static final String DISPLAY_ORDER = "android.contacts.DISPLAY_ORDER";
        public static final int DISPLAY_ORDER_ALTERNATIVE = 2;
        public static final int DISPLAY_ORDER_PRIMARY = 1;
        public static final String SORT_ORDER = "android.contacts.SORT_ORDER";
        public static final int SORT_ORDER_ALTERNATIVE = 2;
        public static final int SORT_ORDER_PRIMARY = 1;

        public Preferences() {
        }
    }

    public static final class Authorization {

        public static final String AUTHORIZATION_METHOD = "authorize";
        public static final String KEY_AUTHORIZED_URI = "authorized_uri";
        public static final String KEY_URI_TO_AUTHORIZE = "uri_to_authorize";

        public Authorization() {
        }
    }


    public ContactsContract() {
    }

    public static boolean isProfileId(long l) {
        boolean flag;
        if(l >= 0x7fffffff80000000L)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static String snippetize(String s, String s1, String s2, char c, char c1, String s3, int i) {
        String s4;
        String s5;
        if(s2 != null)
            s4 = s2.toLowerCase();
        else
            s4 = null;
        if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s1) && s.toLowerCase().contains(s4)) goto _L2; else goto _L1
_L1:
        s5 = null;
_L4:
        return s5;
_L2:
        String s6;
        ArrayList arraylist;
        ArrayList arraylist1;
        if(s1 != null)
            s6 = s1.toLowerCase();
        else
            s6 = "";
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        split(s6.trim(), arraylist, arraylist1);
        for(Iterator iterator = arraylist.iterator(); iterator.hasNext();)
            if(((String)iterator.next()).startsWith(s4)) {
                s5 = null;
                continue; /* Loop/switch isn't completed */
            }

        String as[] = s.split("\n");
        int j = as.length;
        for(int k = 0; k < j; k++) {
            String s7 = as[k];
            if(!s7.toLowerCase().contains(s4))
                continue;
            ArrayList arraylist2 = new ArrayList();
            ArrayList arraylist3 = new ArrayList();
            split(s7.trim(), arraylist2, arraylist3);
            ArrayList arraylist4 = new ArrayList();
            int l = -1;
            int i1 = -1;
            int j1 = 0;
            while(j1 < arraylist2.size())  {
                String s10 = (String)arraylist2.get(j1);
                if(s10.toLowerCase().startsWith(s4)) {
                    arraylist4.add((new StringBuilder()).append(c).append(s10).append(c1).toString());
                    if(l == -1) {
                        l = Math.max(0, j1 - (int)Math.floor((double)Math.abs(i) / 2D));
                        i1 = Math.min(arraylist2.size(), l + Math.abs(i));
                    }
                } else {
                    arraylist4.add(s10);
                }
                j1++;
            }
            if(l <= -1)
                continue;
            StringBuilder stringbuilder = new StringBuilder();
            if(l > 0)
                stringbuilder.append(s3);
            for(int k1 = l; k1 < i1; k1++) {
                String s8 = (String)arraylist4.get(k1);
                String s9 = (String)arraylist2.get(k1);
                stringbuilder.append(s8);
                if(k1 < i1 - 1)
                    stringbuilder.append(s7.substring(((Integer)arraylist3.get(k1)).intValue() + s9.length(), ((Integer)arraylist3.get(k1 + 1)).intValue()));
            }

            if(i1 < arraylist2.size())
                stringbuilder.append(s3);
            s5 = stringbuilder.toString();
            continue; /* Loop/switch isn't completed */
        }

        s5 = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static void split(String s, List list, List list1) {
        for(Matcher matcher = SPLIT_PATTERN.matcher(s); matcher.find(); list1.add(Integer.valueOf(matcher.start())))
            list.add(matcher.group());

    }

    public static final String AUTHORITY = "com.android.contacts";
    public static final Uri AUTHORITY_URI = Uri.parse("content://com.android.contacts");
    public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
    public static final String DEFERRED_SNIPPETING = "deferred_snippeting";
    public static final String DEFERRED_SNIPPETING_QUERY = "deferred_snippeting_query";
    public static final String DIRECTORY_PARAM_KEY = "directory";
    public static final String LIMIT_PARAM_KEY = "limit";
    public static final String PRIMARY_ACCOUNT_NAME = "name_for_primary_account";
    public static final String PRIMARY_ACCOUNT_TYPE = "type_for_primary_account";
    public static final String REMOVE_DUPLICATE_ENTRIES = "remove_duplicate_entries";
    private static Pattern SPLIT_PATTERN = Pattern.compile("([\\w-\\.]+)@((?:[\\w]+\\.)+)([a-zA-Z]{2,4})|[\\w]+");
    public static final String STREQUENT_PHONE_ONLY = "strequent_phone_only";

}
