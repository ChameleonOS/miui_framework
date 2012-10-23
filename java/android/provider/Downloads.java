// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;

// Referenced classes of package android.provider:
//            BaseColumns

public final class Downloads {
    public static final class Impl
        implements BaseColumns {
        public static class RequestHeaders {

            public static final String COLUMN_DOWNLOAD_ID = "download_id";
            public static final String COLUMN_HEADER = "header";
            public static final String COLUMN_VALUE = "value";
            public static final String HEADERS_DB_TABLE = "request_headers";
            public static final String INSERT_KEY_PREFIX = "http_header_";
            public static final String URI_SEGMENT = "headers";

            public RequestHeaders() {
            }
        }


        public static boolean isNotificationToBeDisplayed(int i) {
            boolean flag = true;
            if(i != flag && i != 3)
                flag = false;
            return flag;
        }

        public static boolean isStatusClientError(int i) {
            boolean flag;
            if(i >= 400 && i < 500)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public static boolean isStatusCompleted(int i) {
            boolean flag;
            if(i >= 200 && i < 300 || i >= 400 && i < 600)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public static boolean isStatusError(int i) {
            boolean flag;
            if(i >= 400 && i < 600)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public static boolean isStatusInformational(int i) {
            boolean flag;
            if(i >= 100 && i < 200)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public static boolean isStatusServerError(int i) {
            boolean flag;
            if(i >= 500 && i < 600)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public static boolean isStatusSuccess(int i) {
            boolean flag;
            if(i >= 200 && i < 300)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public static String statusToString(int i) {
            i;
            JVM INSTR lookupswitch 24: default 204
        //                       190: 211
        //                       192: 218
        //                       193: 225
        //                       194: 232
        //                       195: 239
        //                       196: 246
        //                       198: 253
        //                       199: 260
        //                       200: 267
        //                       400: 274
        //                       406: 281
        //                       411: 288
        //                       412: 295
        //                       488: 302
        //                       489: 309
        //                       490: 316
        //                       491: 323
        //                       492: 330
        //                       493: 337
        //                       494: 344
        //                       495: 351
        //                       496: 358
        //                       497: 365
        //                       498: 372;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25
_L1:
            String s = Integer.toString(i);
_L27:
            return s;
_L2:
            s = "PENDING";
            continue; /* Loop/switch isn't completed */
_L3:
            s = "RUNNING";
            continue; /* Loop/switch isn't completed */
_L4:
            s = "PAUSED_BY_APP";
            continue; /* Loop/switch isn't completed */
_L5:
            s = "WAITING_TO_RETRY";
            continue; /* Loop/switch isn't completed */
_L6:
            s = "WAITING_FOR_NETWORK";
            continue; /* Loop/switch isn't completed */
_L7:
            s = "QUEUED_FOR_WIFI";
            continue; /* Loop/switch isn't completed */
_L8:
            s = "INSUFFICIENT_SPACE_ERROR";
            continue; /* Loop/switch isn't completed */
_L9:
            s = "DEVICE_NOT_FOUND_ERROR";
            continue; /* Loop/switch isn't completed */
_L10:
            s = "SUCCESS";
            continue; /* Loop/switch isn't completed */
_L11:
            s = "BAD_REQUEST";
            continue; /* Loop/switch isn't completed */
_L12:
            s = "NOT_ACCEPTABLE";
            continue; /* Loop/switch isn't completed */
_L13:
            s = "LENGTH_REQUIRED";
            continue; /* Loop/switch isn't completed */
_L14:
            s = "PRECONDITION_FAILED";
            continue; /* Loop/switch isn't completed */
_L15:
            s = "FILE_ALREADY_EXISTS_ERROR";
            continue; /* Loop/switch isn't completed */
_L16:
            s = "CANNOT_RESUME";
            continue; /* Loop/switch isn't completed */
_L17:
            s = "CANCELED";
            continue; /* Loop/switch isn't completed */
_L18:
            s = "UNKNOWN_ERROR";
            continue; /* Loop/switch isn't completed */
_L19:
            s = "FILE_ERROR";
            continue; /* Loop/switch isn't completed */
_L20:
            s = "UNHANDLED_REDIRECT";
            continue; /* Loop/switch isn't completed */
_L21:
            s = "UNHANDLED_HTTP_CODE";
            continue; /* Loop/switch isn't completed */
_L22:
            s = "HTTP_DATA_ERROR";
            continue; /* Loop/switch isn't completed */
_L23:
            s = "HTTP_EXCEPTION";
            continue; /* Loop/switch isn't completed */
_L24:
            s = "TOO_MANY_REDIRECTS";
            continue; /* Loop/switch isn't completed */
_L25:
            s = "BLOCKED";
            if(true) goto _L27; else goto _L26
_L26:
        }

        public static final String ACTION_DOWNLOAD_COMPLETED = "android.intent.action.DOWNLOAD_COMPLETED";
        public static final String ACTION_NOTIFICATION_CLICKED = "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
        public static final Uri ALL_DOWNLOADS_CONTENT_URI = Uri.parse("content://downloads/all_downloads");
        public static final String COLUMN_ALLOWED_NETWORK_TYPES = "allowed_network_types";
        public static final String COLUMN_ALLOW_METERED = "allow_metered";
        public static final String COLUMN_ALLOW_ROAMING = "allow_roaming";
        public static final String COLUMN_APP_DATA = "entity";
        public static final String COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT = "bypass_recommended_size_limit";
        public static final String COLUMN_CONTROL = "control";
        public static final String COLUMN_COOKIE_DATA = "cookiedata";
        public static final String COLUMN_CURRENT_BYTES = "current_bytes";
        public static final String COLUMN_DELETED = "deleted";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_DESTINATION = "destination";
        public static final String COLUMN_ERROR_MSG = "errorMsg";
        public static final String COLUMN_FILE_NAME_HINT = "hint";
        public static final String COLUMN_IS_PUBLIC_API = "is_public_api";
        public static final String COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI = "is_visible_in_downloads_ui";
        public static final String COLUMN_LAST_MODIFICATION = "lastmod";
        public static final String COLUMN_LAST_UPDATESRC = "lastUpdateSrc";
        public static final String COLUMN_MEDIAPROVIDER_URI = "mediaprovider_uri";
        public static final String COLUMN_MEDIA_SCANNED = "scanned";
        public static final String COLUMN_MIME_TYPE = "mimetype";
        public static final String COLUMN_NOTIFICATION_CLASS = "notificationclass";
        public static final String COLUMN_NOTIFICATION_EXTRAS = "notificationextras";
        public static final String COLUMN_NOTIFICATION_PACKAGE = "notificationpackage";
        public static final String COLUMN_NO_INTEGRITY = "no_integrity";
        public static final String COLUMN_OTHER_UID = "otheruid";
        public static final String COLUMN_REFERER = "referer";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TOTAL_BYTES = "total_bytes";
        public static final String COLUMN_URI = "uri";
        public static final String COLUMN_USER_AGENT = "useragent";
        public static final String COLUMN_VISIBILITY = "visibility";
        public static final Uri CONTENT_URI = Uri.parse("content://downloads/my_downloads");
        public static final int CONTROL_PAUSED = 1;
        public static final int CONTROL_RUN = 0;
        public static final int DESTINATION_CACHE_PARTITION = 1;
        public static final int DESTINATION_CACHE_PARTITION_NOROAMING = 3;
        public static final int DESTINATION_CACHE_PARTITION_PURGEABLE = 2;
        public static final int DESTINATION_EXTERNAL = 0;
        public static final int DESTINATION_FILE_URI = 4;
        public static final int DESTINATION_NON_DOWNLOADMANAGER_DOWNLOAD = 6;
        public static final int DESTINATION_SYSTEMCACHE_PARTITION = 5;
        public static final int LAST_UPDATESRC_DONT_NOTIFY_DOWNLOADSVC = 1;
        public static final int LAST_UPDATESRC_NOT_RELEVANT = 0;
        public static final int MIN_ARTIFICIAL_ERROR_STATUS = 488;
        public static final String PERMISSION_ACCESS = "android.permission.ACCESS_DOWNLOAD_MANAGER";
        public static final String PERMISSION_ACCESS_ADVANCED = "android.permission.ACCESS_DOWNLOAD_MANAGER_ADVANCED";
        public static final String PERMISSION_ACCESS_ALL = "android.permission.ACCESS_ALL_DOWNLOADS";
        public static final String PERMISSION_CACHE = "android.permission.ACCESS_CACHE_FILESYSTEM";
        public static final String PERMISSION_CACHE_NON_PURGEABLE = "android.permission.DOWNLOAD_CACHE_NON_PURGEABLE";
        public static final String PERMISSION_NO_NOTIFICATION = "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
        public static final String PERMISSION_SEND_INTENTS = "android.permission.SEND_DOWNLOAD_COMPLETED_INTENTS";
        public static final Uri PUBLICLY_ACCESSIBLE_DOWNLOADS_URI = Uri.parse("content://downloads/public_downloads");
        public static final String PUBLICLY_ACCESSIBLE_DOWNLOADS_URI_SEGMENT = "public_downloads";
        public static final int STATUS_BAD_REQUEST = 400;
        public static final int STATUS_BLOCKED = 498;
        public static final int STATUS_CANCELED = 490;
        public static final int STATUS_CANNOT_RESUME = 489;
        public static final int STATUS_DEVICE_NOT_FOUND_ERROR = 199;
        public static final int STATUS_FILE_ALREADY_EXISTS_ERROR = 488;
        public static final int STATUS_FILE_ERROR = 492;
        public static final int STATUS_HTTP_DATA_ERROR = 495;
        public static final int STATUS_HTTP_EXCEPTION = 496;
        public static final int STATUS_INSUFFICIENT_SPACE_ERROR = 198;
        public static final int STATUS_LENGTH_REQUIRED = 411;
        public static final int STATUS_NOT_ACCEPTABLE = 406;
        public static final int STATUS_PAUSED_BY_APP = 193;
        public static final int STATUS_PENDING = 190;
        public static final int STATUS_PRECONDITION_FAILED = 412;
        public static final int STATUS_QUEUED_FOR_WIFI = 196;
        public static final int STATUS_RUNNING = 192;
        public static final int STATUS_SUCCESS = 200;
        public static final int STATUS_TOO_MANY_REDIRECTS = 497;
        public static final int STATUS_UNHANDLED_HTTP_CODE = 494;
        public static final int STATUS_UNHANDLED_REDIRECT = 493;
        public static final int STATUS_UNKNOWN_ERROR = 491;
        public static final int STATUS_WAITING_FOR_NETWORK = 195;
        public static final int STATUS_WAITING_TO_RETRY = 194;
        public static final int VISIBILITY_HIDDEN = 2;
        public static final int VISIBILITY_VISIBLE = 0;
        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
        public static final String _DATA = "_data";


        private Impl() {
        }
    }


    private Downloads() {
    }

    public static final void removeAllDownloadsByPackage(Context context, String s, String s1) {
        ContentResolver contentresolver = context.getContentResolver();
        Uri uri = Impl.CONTENT_URI;
        String as[] = new String[2];
        as[0] = s;
        as[1] = s1;
        contentresolver.delete(uri, "notificationpackage=? AND notificationclass=?", as);
    }

    private static final String QUERY_WHERE_CLAUSE = "notificationpackage=? AND notificationclass=?";
}
