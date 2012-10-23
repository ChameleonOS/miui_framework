// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.accounts.Account;
import android.content.*;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Pair;

public class BrowserContract {
    public static final class Settings {

        public static boolean isSyncEnabled(Context context) {
            Cursor cursor = null;
            ContentResolver contentresolver = context.getContentResolver();
            Uri uri = CONTENT_URI;
            String as[] = new String[1];
            as[0] = "value";
            String as1[] = new String[1];
            as1[0] = "sync_enabled";
            cursor = contentresolver.query(uri, as, "key=?", as1, null);
            if(cursor == null) goto _L2; else goto _L1
_L1:
            boolean flag1 = cursor.moveToFirst();
            if(flag1) goto _L3; else goto _L2
_L2:
            boolean flag;
            if(cursor != null)
                cursor.close();
            flag = false;
_L5:
            return flag;
_L3:
            int i = cursor.getInt(0);
            if(i != 0)
                flag = true;
            else
                flag = false;
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

        public static void setSyncEnabled(Context context, boolean flag) {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("key", "sync_enabled");
            int i;
            if(flag)
                i = 1;
            else
                i = 0;
            contentvalues.put("value", Integer.valueOf(i));
            context.getContentResolver().insert(CONTENT_URI, contentvalues);
        }

        public static final Uri CONTENT_URI;
        public static final String KEY = "key";
        public static final String KEY_SYNC_ENABLED = "sync_enabled";
        public static final String VALUE = "value";

        static  {
            CONTENT_URI = Uri.withAppendedPath(BrowserContract.AUTHORITY_URI, "settings");
        }

        private Settings() {
        }
    }

    public static final class Combined
        implements CommonColumns, HistoryColumns, ImageColumns {

        public static final Uri CONTENT_URI;
        public static final String IS_BOOKMARK = "bookmark";

        static  {
            CONTENT_URI = Uri.withAppendedPath(BrowserContract.AUTHORITY_URI, "combined");
        }

        private Combined() {
        }
    }

    public static final class ImageMappings
        implements ImageMappingColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/image_mappings";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/image_mappings";
        public static final Uri CONTENT_URI;

        static  {
            CONTENT_URI = Uri.withAppendedPath(BrowserContract.AUTHORITY_URI, "image_mappings");
        }

        private ImageMappings() {
        }
    }

    public static final class Images
        implements ImageColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/images";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/images";
        public static final Uri CONTENT_URI;
        public static final String DATA = "data";
        public static final int IMAGE_TYPE_FAVICON = 1;
        public static final int IMAGE_TYPE_PRECOMPOSED_TOUCH_ICON = 2;
        public static final int IMAGE_TYPE_TOUCH_ICON = 4;
        public static final String TYPE = "type";
        public static final String URL = "url_key";

        static  {
            CONTENT_URI = Uri.withAppendedPath(BrowserContract.AUTHORITY_URI, "images");
        }

        private Images() {
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
            CONTENT_URI = Uri.withAppendedPath(BrowserContract.AUTHORITY_URI, "syncstate");
        }

        private SyncState() {
        }
    }

    public static final class Searches {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/searches";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/searches";
        public static final Uri CONTENT_URI;
        public static final String DATE = "date";
        public static final String SEARCH = "search";
        public static final String _ID = "_id";

        static  {
            CONTENT_URI = Uri.withAppendedPath(BrowserContract.AUTHORITY_URI, "searches");
        }

        private Searches() {
        }
    }

    public static final class History
        implements CommonColumns, HistoryColumns, ImageColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/browser-history";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/browser-history";
        public static final Uri CONTENT_URI;

        static  {
            CONTENT_URI = Uri.withAppendedPath(BrowserContract.AUTHORITY_URI, "history");
        }

        private History() {
        }
    }

    public static final class Accounts {

        public static final String ACCOUNT_NAME = "account_name";
        public static final String ACCOUNT_TYPE = "account_type";
        public static final Uri CONTENT_URI;
        public static final String ROOT_ID = "root_id";

        static  {
            CONTENT_URI = BrowserContract.AUTHORITY_URI.buildUpon().appendPath("accounts").build();
        }

        public Accounts() {
        }
    }

    public static final class Bookmarks
        implements CommonColumns, ImageColumns, SyncColumns {

        public static final Uri buildFolderUri(long l) {
            return ContentUris.withAppendedId(CONTENT_URI_DEFAULT_FOLDER, l);
        }

        public static final int BOOKMARK_TYPE_BOOKMARK = 1;
        public static final int BOOKMARK_TYPE_BOOKMARK_BAR_FOLDER = 3;
        public static final int BOOKMARK_TYPE_FOLDER = 2;
        public static final int BOOKMARK_TYPE_MOBILE_FOLDER = 5;
        public static final int BOOKMARK_TYPE_OTHER_FOLDER = 4;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/bookmark";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/bookmark";
        public static final Uri CONTENT_URI;
        public static final Uri CONTENT_URI_DEFAULT_FOLDER;
        public static final String INSERT_AFTER = "insert_after";
        public static final String INSERT_AFTER_SOURCE_ID = "insert_after_source";
        public static final String IS_DELETED = "deleted";
        public static final String IS_FOLDER = "folder";
        public static final String PARAM_ACCOUNT_NAME = "acct_name";
        public static final String PARAM_ACCOUNT_TYPE = "acct_type";
        public static final String PARENT = "parent";
        public static final String PARENT_SOURCE_ID = "parent_source";
        public static final String POSITION = "position";
        public static final String QUERY_PARAMETER_SHOW_DELETED = "show_deleted";
        public static final String TYPE = "type";

        static  {
            CONTENT_URI = Uri.withAppendedPath(BrowserContract.AUTHORITY_URI, "bookmarks");
            CONTENT_URI_DEFAULT_FOLDER = Uri.withAppendedPath(CONTENT_URI, "folder");
        }

        private Bookmarks() {
        }
    }

    static interface ImageMappingColumns {

        public static final String IMAGE_ID = "image_id";
        public static final String URL = "url";
    }

    static interface HistoryColumns {

        public static final String DATE_LAST_VISITED = "date";
        public static final String USER_ENTERED = "user_entered";
        public static final String VISITS = "visits";
    }

    static interface ImageColumns {

        public static final String FAVICON = "favicon";
        public static final String THUMBNAIL = "thumbnail";
        public static final String TOUCH_ICON = "touch_icon";
    }

    static interface CommonColumns {

        public static final String DATE_CREATED = "created";
        public static final String TITLE = "title";
        public static final String URL = "url";
        public static final String _ID = "_id";
    }

    static interface SyncColumns
        extends BaseSyncColumns {

        public static final String ACCOUNT_NAME = "account_name";
        public static final String ACCOUNT_TYPE = "account_type";
        public static final String DATE_MODIFIED = "modified";
        public static final String DIRTY = "dirty";
        public static final String SOURCE_ID = "sourceid";
        public static final String VERSION = "version";
    }

    public static final class ChromeSyncColumns {

        public static final String CLIENT_UNIQUE = "sync4";
        public static final String FOLDER_NAME_BOOKMARKS = "google_chrome_bookmarks";
        public static final String FOLDER_NAME_BOOKMARKS_BAR = "bookmark_bar";
        public static final String FOLDER_NAME_OTHER_BOOKMARKS = "other_bookmarks";
        public static final String FOLDER_NAME_ROOT = "google_chrome";
        public static final String SERVER_UNIQUE = "sync3";

        private ChromeSyncColumns() {
        }
    }

    static interface BaseSyncColumns {

        public static final String SYNC1 = "sync1";
        public static final String SYNC2 = "sync2";
        public static final String SYNC3 = "sync3";
        public static final String SYNC4 = "sync4";
        public static final String SYNC5 = "sync5";
    }


    public BrowserContract() {
    }

    public static final String AUTHORITY = "com.android.browser";
    public static final Uri AUTHORITY_URI = Uri.parse("content://com.android.browser");
    public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
    public static final String PARAM_LIMIT = "limit";

}
