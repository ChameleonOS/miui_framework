// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.net.Uri;

// Referenced classes of package android.provider:
//            BaseColumns

public class SocialContract {
    public static final class Activities
        implements BaseColumns, ActivitiesColumns {

        public static final Uri CONTENT_AUTHORED_BY_URI;
        public static final Uri CONTENT_CONTACT_STATUS_URI;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/activity";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/activity";
        public static final Uri CONTENT_URI;

        static  {
            CONTENT_URI = Uri.withAppendedPath(SocialContract.AUTHORITY_URI, "activities");
            CONTENT_AUTHORED_BY_URI = Uri.withAppendedPath(CONTENT_URI, "authored_by");
            CONTENT_CONTACT_STATUS_URI = Uri.withAppendedPath(SocialContract.AUTHORITY_URI, "contact_status");
        }

        private Activities() {
        }
    }

    private static interface ActivitiesColumns {

        public static final String AUTHOR_CONTACT_ID = "author_contact_id";
        public static final String IN_REPLY_TO = "in_reply_to";
        public static final String LINK = "link";
        public static final String MIMETYPE = "mimetype";
        public static final String PUBLISHED = "published";
        public static final String RAW_ID = "raw_id";
        public static final String RES_PACKAGE = "res_package";
        public static final String SUMMARY = "summary";
        public static final String TARGET_CONTACT_ID = "target_contact_id";
        public static final String THREAD_PUBLISHED = "thread_published";
        public static final String THUMBNAIL = "thumbnail";
        public static final String TITLE = "title";
    }


    public SocialContract() {
    }

    public static final String AUTHORITY = "com.android.social";
    public static final Uri AUTHORITY_URI = Uri.parse("content://com.android.social");

}
