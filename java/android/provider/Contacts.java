// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.content.*;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Referenced classes of package android.provider:
//            BaseColumns, SyncConstValue

public class Contacts {
    public static final class Intents {
        public static final class Insert {

            public static final String ACTION = "android.intent.action.INSERT";
            public static final String COMPANY = "company";
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


        public static final String ATTACH_IMAGE = "com.android.contacts.action.ATTACH_IMAGE";
        public static final String EXTRA_CREATE_DESCRIPTION = "com.android.contacts.action.CREATE_DESCRIPTION";
        public static final String EXTRA_FORCE_CREATE = "com.android.contacts.action.FORCE_CREATE";
        public static final String EXTRA_TARGET_RECT = "target_rect";
        public static final String SEARCH_SUGGESTION_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_CLICKED";
        public static final String SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED";
        public static final String SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED = "android.provider.Contacts.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED";
        public static final String SHOW_OR_CREATE_CONTACT = "com.android.contacts.action.SHOW_OR_CREATE_CONTACT";

        public Intents() {
        }
    }

    public static final class Extensions
        implements BaseColumns, ExtensionsColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_extensions";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact_extensions";
        public static final Uri CONTENT_URI = Uri.parse("content://contacts/extensions");
        public static final String DEFAULT_SORT_ORDER = "person, name ASC";
        public static final String PERSON_ID = "person";


        private Extensions() {
        }
    }

    public static interface ExtensionsColumns {

        public static final String NAME = "name";
        public static final String VALUE = "value";
    }

    public static final class Photos
        implements BaseColumns, PhotosColumns, SyncConstValue {

        public static final String CONTENT_DIRECTORY = "photo";
        public static final Uri CONTENT_URI = Uri.parse("content://contacts/photos");
        public static final String DEFAULT_SORT_ORDER = "person ASC";


        private Photos() {
        }
    }

    public static interface PhotosColumns {

        public static final String DATA = "data";
        public static final String DOWNLOAD_REQUIRED = "download_required";
        public static final String EXISTS_ON_SERVER = "exists_on_server";
        public static final String LOCAL_VERSION = "local_version";
        public static final String PERSON_ID = "person";
        public static final String SYNC_ERROR = "sync_error";
    }

    public static final class Organizations
        implements BaseColumns, OrganizationColumns {

        public static final CharSequence getDisplayLabel(Context context, int i, CharSequence charsequence) {
            Object obj = "";
            if(i == 0) goto _L2; else goto _L1
_L1:
            CharSequence acharsequence[] = context.getResources().getTextArray(0x1070002);
            int j = i - 1;
            try {
                obj = acharsequence[j];
            }
            catch(ArrayIndexOutOfBoundsException arrayindexoutofboundsexception) {
                obj = acharsequence[0];
            }
_L4:
            return ((CharSequence) (obj));
_L2:
            if(!TextUtils.isEmpty(charsequence))
                obj = charsequence;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public static final String CONTENT_DIRECTORY = "organizations";
        public static final Uri CONTENT_URI = Uri.parse("content://contacts/organizations");
        public static final String DEFAULT_SORT_ORDER = "company, title, isprimary ASC";


        private Organizations() {
        }
    }

    public static interface OrganizationColumns {

        public static final String COMPANY = "company";
        public static final String ISPRIMARY = "isprimary";
        public static final String LABEL = "label";
        public static final String PERSON_ID = "person";
        public static final String TITLE = "title";
        public static final String TYPE = "type";
        public static final int TYPE_CUSTOM = 0;
        public static final int TYPE_OTHER = 2;
        public static final int TYPE_WORK = 1;
    }

    public static final class Presence
        implements BaseColumns, PresenceColumns, PeopleColumns {

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

        public static final void setPresenceIcon(ImageView imageview, int i) {
            imageview.setImageResource(getPresenceIconResourceId(i));
        }

        public static final Uri CONTENT_URI = Uri.parse("content://contacts/presence");
        public static final String PERSON_ID = "person";


        public Presence() {
        }
    }

    public static interface PresenceColumns {

        public static final int AVAILABLE = 5;
        public static final int AWAY = 2;
        public static final int DO_NOT_DISTURB = 4;
        public static final int IDLE = 3;
        public static final String IM_ACCOUNT = "im_account";
        public static final String IM_HANDLE = "im_handle";
        public static final String IM_PROTOCOL = "im_protocol";
        public static final int INVISIBLE = 1;
        public static final int OFFLINE = 0;
        public static final String PRESENCE_CUSTOM_STATUS = "status";
        public static final String PRESENCE_STATUS = "mode";
        public static final String PRIORITY = "priority";
    }

    public static final class ContactMethods
        implements BaseColumns, ContactMethodsColumns, PeopleColumns {
        static interface ProviderNames {

            public static final String AIM = "AIM";
            public static final String GTALK = "GTalk";
            public static final String ICQ = "ICQ";
            public static final String JABBER = "JABBER";
            public static final String MSN = "MSN";
            public static final String QQ = "QQ";
            public static final String SKYPE = "SKYPE";
            public static final String XMPP = "XMPP";
            public static final String YAHOO = "Yahoo";
        }


        public static Object decodeImProtocol(String s) {
            Object obj;
            if(s == null)
                obj = null;
            else
            if(s.startsWith("pre:"))
                obj = Integer.valueOf(Integer.parseInt(s.substring(4)));
            else
            if(s.startsWith("custom:"))
                obj = s.substring(7);
            else
                throw new IllegalArgumentException((new StringBuilder()).append("the value is not a valid encoded protocol, ").append(s).toString());
            return obj;
        }

        public static String encodeCustomImProtocol(String s) {
            return (new StringBuilder()).append("custom:").append(s).toString();
        }

        public static String encodePredefinedImProtocol(int i) {
            return (new StringBuilder()).append("pre:").append(i).toString();
        }

        public static final CharSequence getDisplayLabel(Context context, int i, int j, CharSequence charsequence) {
            Object obj = "";
            i;
            JVM INSTR tableswitch 1 2: default 28
        //                       1 39
        //                       2 93;
               goto _L1 _L2 _L3
_L1:
            obj = context.getString(0x104000f);
_L5:
            return ((CharSequence) (obj));
_L2:
            if(j != 0) {
                CharSequence acharsequence1[] = context.getResources().getTextArray(0x1070000);
                int l = j - 1;
                try {
                    obj = acharsequence1[l];
                }
                catch(ArrayIndexOutOfBoundsException arrayindexoutofboundsexception1) {
                    obj = acharsequence1[0];
                }
            } else
            if(!TextUtils.isEmpty(charsequence))
                obj = charsequence;
            continue; /* Loop/switch isn't completed */
_L3:
            if(j != 0) {
                CharSequence acharsequence[] = context.getResources().getTextArray(0x1070004);
                int k = j - 1;
                try {
                    obj = acharsequence[k];
                }
                catch(ArrayIndexOutOfBoundsException arrayindexoutofboundsexception) {
                    obj = acharsequence[0];
                }
            } else
            if(!TextUtils.isEmpty(charsequence))
                obj = charsequence;
            if(true) goto _L5; else goto _L4
_L4:
        }

        public static String lookupProviderNameFromId(int i) {
            i;
            JVM INSTR tableswitch 0 7: default 48
        //                       0 58
        //                       1 64
        //                       2 70
        //                       3 88
        //                       4 94
        //                       5 52
        //                       6 76
        //                       7 82;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
            String s = null;
_L11:
            return s;
_L7:
            s = "GTalk";
            continue; /* Loop/switch isn't completed */
_L2:
            s = "AIM";
            continue; /* Loop/switch isn't completed */
_L3:
            s = "MSN";
            continue; /* Loop/switch isn't completed */
_L4:
            s = "Yahoo";
            continue; /* Loop/switch isn't completed */
_L8:
            s = "ICQ";
            continue; /* Loop/switch isn't completed */
_L9:
            s = "JABBER";
            continue; /* Loop/switch isn't completed */
_L5:
            s = "SKYPE";
            continue; /* Loop/switch isn't completed */
_L6:
            s = "QQ";
            if(true) goto _L11; else goto _L10
_L10:
        }

        public void addPostalLocation(Context context, long l, double d, double d1) {
            ContentResolver contentresolver = context.getContentResolver();
            ContentValues contentvalues = new ContentValues(2);
            contentvalues.put("data", Double.valueOf(d));
            contentvalues.put("aux_data", Double.valueOf(d1));
            long l1 = ContentUris.parseId(contentresolver.insert(CONTENT_URI, contentvalues));
            contentvalues.clear();
            contentvalues.put("aux_data", Long.valueOf(l1));
            contentresolver.update(ContentUris.withAppendedId(CONTENT_URI, l), contentvalues, null, null);
        }

        public static final String CONTENT_EMAIL_ITEM_TYPE = "vnd.android.cursor.item/email";
        public static final String CONTENT_EMAIL_TYPE = "vnd.android.cursor.dir/email";
        public static final Uri CONTENT_EMAIL_URI = Uri.parse("content://contacts/contact_methods/email");
        public static final String CONTENT_IM_ITEM_TYPE = "vnd.android.cursor.item/jabber-im";
        public static final String CONTENT_POSTAL_ITEM_TYPE = "vnd.android.cursor.item/postal-address";
        public static final String CONTENT_POSTAL_TYPE = "vnd.android.cursor.dir/postal-address";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact-methods";
        public static final Uri CONTENT_URI = Uri.parse("content://contacts/contact_methods");
        public static final String DEFAULT_SORT_ORDER = "name ASC";
        public static final String PERSON_ID = "person";
        public static final String POSTAL_LOCATION_LATITUDE = "data";
        public static final String POSTAL_LOCATION_LONGITUDE = "aux_data";
        public static final int PROTOCOL_AIM = 0;
        public static final int PROTOCOL_GOOGLE_TALK = 5;
        public static final int PROTOCOL_ICQ = 6;
        public static final int PROTOCOL_JABBER = 7;
        public static final int PROTOCOL_MSN = 1;
        public static final int PROTOCOL_QQ = 4;
        public static final int PROTOCOL_SKYPE = 3;
        public static final int PROTOCOL_YAHOO = 2;


        private ContactMethods() {
        }
    }

    public static interface ContactMethodsColumns {

        public static final String AUX_DATA = "aux_data";
        public static final String DATA = "data";
        public static final String ISPRIMARY = "isprimary";
        public static final String KIND = "kind";
        public static final String LABEL = "label";
        public static final int MOBILE_EMAIL_TYPE_INDEX = 2;
        public static final String MOBILE_EMAIL_TYPE_NAME = "_AUTO_CELL";
        public static final String TYPE = "type";
        public static final int TYPE_CUSTOM = 0;
        public static final int TYPE_HOME = 1;
        public static final int TYPE_OTHER = 3;
        public static final int TYPE_WORK = 2;
    }

    public static final class GroupMembership
        implements BaseColumns, GroupsColumns {

        public static final String CONTENT_DIRECTORY = "groupmembership";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contactsgroupmembership";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contactsgroupmembership";
        public static final Uri CONTENT_URI = Uri.parse("content://contacts/groupmembership");
        public static final String DEFAULT_SORT_ORDER = "group_id ASC";
        public static final String GROUP_ID = "group_id";
        public static final String GROUP_SYNC_ACCOUNT = "group_sync_account";
        public static final String GROUP_SYNC_ACCOUNT_TYPE = "group_sync_account_type";
        public static final String GROUP_SYNC_ID = "group_sync_id";
        public static final String PERSON_ID = "person";
        public static final Uri RAW_CONTENT_URI = Uri.parse("content://contacts/groupmembershipraw");


        private GroupMembership() {
        }
    }

    public static final class Phones
        implements BaseColumns, PhonesColumns, PeopleColumns {

        public static final CharSequence getDisplayLabel(Context context, int i, CharSequence charsequence) {
            return getDisplayLabel(context, i, charsequence, null);
        }

        public static final CharSequence getDisplayLabel(Context context, int i, CharSequence charsequence, CharSequence acharsequence[]) {
            Object obj = "";
            if(i == 0) goto _L2; else goto _L1
_L1:
            CharSequence acharsequence1[];
            int j;
            if(acharsequence != null)
                acharsequence1 = acharsequence;
            else
                acharsequence1 = context.getResources().getTextArray(0x1070003);
            j = i - 1;
            try {
                obj = acharsequence1[j];
            }
            catch(ArrayIndexOutOfBoundsException arrayindexoutofboundsexception) {
                obj = acharsequence1[0];
            }
_L4:
            return ((CharSequence) (obj));
_L2:
            if(!TextUtils.isEmpty(charsequence))
                obj = charsequence;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public static final Uri CONTENT_FILTER_URL = Uri.parse("content://contacts/phones/filter");
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone";
        public static final Uri CONTENT_URI = Uri.parse("content://contacts/phones");
        public static final String DEFAULT_SORT_ORDER = "name ASC";
        public static final String PERSON_ID = "person";


        private Phones() {
        }
    }

    public static interface PhonesColumns {

        public static final String ISPRIMARY = "isprimary";
        public static final String LABEL = "label";
        public static final String NUMBER = "number";
        public static final String NUMBER_KEY = "number_key";
        public static final String TYPE = "type";
        public static final int TYPE_CUSTOM = 0;
        public static final int TYPE_FAX_HOME = 5;
        public static final int TYPE_FAX_WORK = 4;
        public static final int TYPE_HOME = 1;
        public static final int TYPE_MOBILE = 2;
        public static final int TYPE_OTHER = 7;
        public static final int TYPE_PAGER = 6;
        public static final int TYPE_WORK = 3;
    }

    public static final class Groups
        implements BaseColumns, SyncConstValue, GroupsColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contactsgroup";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contactsgroup";
        public static final Uri CONTENT_URI = Uri.parse("content://contacts/groups");
        public static final String DEFAULT_SORT_ORDER = "name ASC";
        public static final Uri DELETED_CONTENT_URI = Uri.parse("content://contacts/deleted_groups");
        public static final String GROUP_ANDROID_STARRED = "Starred in Android";
        public static final String GROUP_MY_CONTACTS = "Contacts";


        private Groups() {
        }
    }

    public static interface GroupsColumns {

        public static final String NAME = "name";
        public static final String NOTES = "notes";
        public static final String SHOULD_SYNC = "should_sync";
        public static final String SYSTEM_ID = "system_id";
    }

    public static final class People
        implements BaseColumns, SyncConstValue, PeopleColumns, PhonesColumns, PresenceColumns {
        public static class Extensions
            implements BaseColumns, ExtensionsColumns {

            public static final String CONTENT_DIRECTORY = "extensions";
            public static final String DEFAULT_SORT_ORDER = "name ASC";
            public static final String PERSON_ID = "person";

            private Extensions() {
            }
        }

        public static final class ContactMethods
            implements BaseColumns, ContactMethodsColumns, PeopleColumns {

            public static final String CONTENT_DIRECTORY = "contact_methods";
            public static final String DEFAULT_SORT_ORDER = "data ASC";

            private ContactMethods() {
            }
        }

        public static final class Phones
            implements BaseColumns, PhonesColumns, PeopleColumns {

            public static final String CONTENT_DIRECTORY = "phones";
            public static final String DEFAULT_SORT_ORDER = "number ASC";

            private Phones() {
            }
        }


        public static Uri addToGroup(ContentResolver contentresolver, long l, long l1) {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("person", Long.valueOf(l));
            contentvalues.put("group_id", Long.valueOf(l1));
            return contentresolver.insert(GroupMembership.CONTENT_URI, contentvalues);
        }

        public static Uri addToGroup(ContentResolver contentresolver, long l, String s) {
            long l1;
            Cursor cursor;
            l1 = 0L;
            Uri uri = Groups.CONTENT_URI;
            String as[] = GROUPS_PROJECTION;
            String as1[] = new String[1];
            as1[0] = s;
            cursor = contentresolver.query(uri, as, "name=?", as1, null);
            if(cursor == null)
                break MISSING_BLOCK_LABEL_75;
            long l2;
            if(!cursor.moveToFirst())
                break MISSING_BLOCK_LABEL_68;
            l2 = cursor.getLong(0);
            l1 = l2;
            cursor.close();
            Exception exception;
            if(l1 == 0L)
                throw new IllegalStateException("Failed to find the My Contacts group");
            else
                return addToGroup(contentresolver, l, l1);
            exception;
            cursor.close();
            throw exception;
        }

        public static Uri addToMyContactsGroup(ContentResolver contentresolver, long l) {
            long l1 = tryGetMyContactsGroupId(contentresolver);
            if(l1 == 0L)
                throw new IllegalStateException("Failed to find the My Contacts group");
            else
                return addToGroup(contentresolver, l, l1);
        }

        public static Uri createPersonInMyContactsGroup(ContentResolver contentresolver, ContentValues contentvalues) {
            Uri uri = contentresolver.insert(CONTENT_URI, contentvalues);
            if(uri != null) goto _L2; else goto _L1
_L1:
            Log.e("Contacts", "Failed to create the contact");
            uri = null;
_L4:
            return uri;
_L2:
            if(addToMyContactsGroup(contentresolver, ContentUris.parseId(uri)) == null) {
                contentresolver.delete(uri, null, null);
                uri = null;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public static Bitmap loadContactPhoto(Context context, Uri uri, int i, android.graphics.BitmapFactory.Options options) {
            Bitmap bitmap = null;
            if(uri != null) goto _L2; else goto _L1
_L1:
            bitmap = loadPlaceholderPhoto(i, context, options);
_L4:
            return bitmap;
_L2:
            InputStream inputstream = openContactPhotoInputStream(context.getContentResolver(), uri);
            if(inputstream != null)
                bitmap = BitmapFactory.decodeStream(inputstream, null, options);
            if(bitmap == null)
                bitmap = loadPlaceholderPhoto(i, context, options);
            if(true) goto _L4; else goto _L3
_L3:
        }

        private static Bitmap loadPlaceholderPhoto(int i, Context context, android.graphics.BitmapFactory.Options options) {
            Bitmap bitmap;
            if(i == 0)
                bitmap = null;
            else
                bitmap = BitmapFactory.decodeResource(context.getResources(), i, options);
            return bitmap;
        }

        public static void markAsContacted(ContentResolver contentresolver, long l) {
            Uri uri = Uri.withAppendedPath(ContentUris.withAppendedId(CONTENT_URI, l), "update_contact_time");
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("last_time_contacted", Long.valueOf(System.currentTimeMillis()));
            contentresolver.update(uri, contentvalues, null, null);
        }

        public static InputStream openContactPhotoInputStream(ContentResolver contentresolver, Uri uri) {
            Object obj;
            Cursor cursor;
            obj = null;
            Uri uri1 = Uri.withAppendedPath(uri, "photo");
            String as[] = new String[1];
            as[0] = "data";
            cursor = contentresolver.query(uri1, as, null, null, null);
            if(cursor == null) goto _L2; else goto _L1
_L1:
            boolean flag = cursor.moveToNext();
            if(flag) goto _L3; else goto _L2
_L2:
            if(cursor != null)
                cursor.close();
_L5:
            return ((InputStream) (obj));
_L3:
            byte abyte0[] = cursor.getBlob(0);
            if(abyte0 == null) {
                if(cursor != null)
                    cursor.close();
                continue; /* Loop/switch isn't completed */
            }
            obj = new ByteArrayInputStream(abyte0);
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

        public static Cursor queryGroups(ContentResolver contentresolver, long l) {
            Uri uri = GroupMembership.CONTENT_URI;
            String as[] = new String[1];
            as[0] = String.valueOf(l);
            return contentresolver.query(uri, null, "person=?", as, "name ASC");
        }

        public static void setPhotoData(ContentResolver contentresolver, Uri uri, byte abyte0[]) {
            Uri uri1 = Uri.withAppendedPath(uri, "photo");
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("data", abyte0);
            contentresolver.update(uri1, contentvalues, null, null);
        }

        public static long tryGetMyContactsGroupId(ContentResolver contentresolver) {
            Cursor cursor = contentresolver.query(Groups.CONTENT_URI, GROUPS_PROJECTION, "system_id='Contacts'", null, null);
            if(cursor == null) goto _L2; else goto _L1
_L1:
            if(!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
            long l1 = cursor.getLong(0);
            long l;
            l = l1;
            cursor.close();
_L6:
            return l;
_L4:
            cursor.close();
_L2:
            l = 0L;
            if(true) goto _L6; else goto _L5
_L5:
            Exception exception;
            exception;
            cursor.close();
            throw exception;
        }

        public static final Uri CONTENT_FILTER_URI = Uri.parse("content://contacts/people/filter");
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/person";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/person";
        public static final Uri CONTENT_URI = Uri.parse("content://contacts/people");
        public static final String DEFAULT_SORT_ORDER = "name ASC";
        public static final Uri DELETED_CONTENT_URI = Uri.parse("content://contacts/deleted_people");
        private static final String GROUPS_PROJECTION[];
        public static final String PRIMARY_EMAIL_ID = "primary_email";
        public static final String PRIMARY_ORGANIZATION_ID = "primary_organization";
        public static final String PRIMARY_PHONE_ID = "primary_phone";
        public static final Uri WITH_EMAIL_OR_IM_FILTER_URI = Uri.parse("content://contacts/people/with_email_or_im_filter");

        static  {
            String as[] = new String[1];
            as[0] = "_id";
            GROUPS_PROJECTION = as;
        }

        private People() {
        }
    }

    public static interface PeopleColumns {

        public static final String CUSTOM_RINGTONE = "custom_ringtone";
        public static final String DISPLAY_NAME = "display_name";
        public static final String LAST_TIME_CONTACTED = "last_time_contacted";
        public static final String NAME = "name";
        public static final String NOTES = "notes";
        public static final String PHONETIC_NAME = "phonetic_name";
        public static final String PHOTO_VERSION = "photo_version";
        public static final String SEND_TO_VOICEMAIL = "send_to_voicemail";
        public static final String SORT_STRING = "sort_string";
        public static final String STARRED = "starred";
        public static final String TIMES_CONTACTED = "times_contacted";
    }

    public static final class Settings
        implements BaseColumns, SettingsColumns {

        public static String getSetting(ContentResolver contentresolver, String s, String s1) {
            String s2;
            Cursor cursor;
            s2 = null;
            String as[] = new String[1];
            as[0] = s1;
            Uri uri = CONTENT_URI;
            String as1[] = new String[1];
            as1[0] = "value";
            cursor = contentresolver.query(uri, as1, "key=?", as, null);
            boolean flag = cursor.moveToNext();
            if(flag) goto _L2; else goto _L1
_L1:
            cursor.close();
_L4:
            return s2;
_L2:
            String s3 = cursor.getString(0);
            s2 = s3;
            cursor.close();
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            cursor.close();
            throw exception;
        }

        public static void setSetting(ContentResolver contentresolver, String s, String s1, String s2) {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("key", s1);
            contentvalues.put("value", s2);
            contentresolver.update(CONTENT_URI, contentvalues, null, null);
        }

        public static final String CONTENT_DIRECTORY = "settings";
        public static final Uri CONTENT_URI = Uri.parse("content://contacts/settings");
        public static final String DEFAULT_SORT_ORDER = "key ASC";
        public static final String SYNC_EVERYTHING = "syncEverything";


        private Settings() {
        }
    }

    public static interface SettingsColumns {

        public static final String KEY = "key";
        public static final String VALUE = "value";
        public static final String _SYNC_ACCOUNT = "_sync_account";
        public static final String _SYNC_ACCOUNT_TYPE = "_sync_account_type";
    }


    private Contacts() {
    }

    public static final String AUTHORITY = "contacts";
    public static final Uri CONTENT_URI = Uri.parse("content://contacts");
    public static final int KIND_EMAIL = 1;
    public static final int KIND_IM = 3;
    public static final int KIND_ORGANIZATION = 4;
    public static final int KIND_PHONE = 5;
    public static final int KIND_POSTAL = 2;
    private static final String TAG = "Contacts";

}
