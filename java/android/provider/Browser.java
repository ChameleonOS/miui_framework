// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.content.*;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebIconDatabase;

// Referenced classes of package android.provider:
//            BaseColumns

public class Browser {
    public static class SearchColumns
        implements BaseColumns {

        public static final String DATE = "date";
        public static final String SEARCH = "search";
        public static final String URL = "url";

        public SearchColumns() {
        }
    }

    public static class BookmarkColumns
        implements BaseColumns {

        public static final String BOOKMARK = "bookmark";
        public static final String CREATED = "created";
        public static final String DATE = "date";
        public static final String FAVICON = "favicon";
        public static final String THUMBNAIL = "thumbnail";
        public static final String TITLE = "title";
        public static final String TOUCH_ICON = "touch_icon";
        public static final String URL = "url";
        public static final String USER_ENTERED = "user_entered";
        public static final String VISITS = "visits";

        public BookmarkColumns() {
        }
    }


    public Browser() {
    }

    private static final void addOrUrlEquals(StringBuilder stringbuilder) {
        stringbuilder.append(" OR url = ");
    }

    public static final void addSearchUrl(ContentResolver contentresolver, String s) {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("search", s);
        contentvalues.put("date", Long.valueOf(System.currentTimeMillis()));
        contentresolver.insert(BrowserContract.Searches.CONTENT_URI, contentvalues);
    }

    public static final boolean canClearHistory(ContentResolver contentresolver) {
        Cursor cursor;
        boolean flag;
        cursor = null;
        flag = false;
        int i;
        Uri uri = BrowserContract.History.CONTENT_URI;
        String as[] = new String[2];
        as[0] = "_id";
        as[1] = "visits";
        cursor = contentresolver.query(uri, as, null, null, null);
        i = cursor.getCount();
        if(i > 0)
            flag = true;
        else
            flag = false;
        if(cursor != null)
            cursor.close();
_L2:
        return flag;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e("browser", "canClearHistory", illegalstateexception);
        if(cursor != null)
            cursor.close();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
    }

    public static final void clearHistory(ContentResolver contentresolver) {
        deleteHistoryWhere(contentresolver, null);
    }

    public static final void clearSearches(ContentResolver contentresolver) {
        contentresolver.delete(BrowserContract.Searches.CONTENT_URI, null, null);
_L1:
        return;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e("browser", "clearSearches", illegalstateexception);
          goto _L1
    }

    public static final void deleteFromHistory(ContentResolver contentresolver, String s) {
        Uri uri = BrowserContract.History.CONTENT_URI;
        String as[] = new String[1];
        as[0] = s;
        contentresolver.delete(uri, "url=?", as);
    }

    public static final void deleteHistoryTimeFrame(ContentResolver contentresolver, long l, long l1) {
        if(-1L != l) goto _L2; else goto _L1
_L1:
        if(-1L != l1) goto _L4; else goto _L3
_L3:
        clearHistory(contentresolver);
_L5:
        return;
_L4:
        String s = (new StringBuilder()).append("date").append(" < ").append(Long.toString(l1)).toString();
_L6:
        deleteHistoryWhere(contentresolver, s);
        if(true) goto _L5; else goto _L2
_L2:
        if(-1L == l1)
            s = (new StringBuilder()).append("date").append(" >= ").append(Long.toString(l)).toString();
        else
            s = (new StringBuilder()).append("date").append(" >= ").append(Long.toString(l)).append(" AND ").append("date").append(" < ").append(Long.toString(l1)).toString();
          goto _L6
    }

    private static final void deleteHistoryWhere(ContentResolver contentresolver, String s) {
        Cursor cursor = null;
        Uri uri = BrowserContract.History.CONTENT_URI;
        String as[] = new String[1];
        as[0] = "url";
        cursor = contentresolver.query(uri, as, s, null, null);
        if(cursor.moveToFirst()) {
            WebIconDatabase webicondatabase = WebIconDatabase.getInstance();
            do
                webicondatabase.releaseIconForPageUrl(cursor.getString(0));
            while(cursor.moveToNext());
            contentresolver.delete(BrowserContract.History.CONTENT_URI, s, null);
        }
        if(cursor != null)
            cursor.close();
_L2:
        return;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e("browser", "deleteHistoryWhere", illegalstateexception);
        if(cursor != null)
            cursor.close();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
    }

    public static final Cursor getAllBookmarks(ContentResolver contentresolver) throws IllegalStateException {
        Uri uri = BrowserContract.Bookmarks.CONTENT_URI;
        String as[] = new String[1];
        as[0] = "url";
        return contentresolver.query(uri, as, "folder = 0", null, null);
    }

    public static final Cursor getAllVisitedUrls(ContentResolver contentresolver) throws IllegalStateException {
        Uri uri = BrowserContract.Combined.CONTENT_URI;
        String as[] = new String[1];
        as[0] = "url";
        return contentresolver.query(uri, as, null, null, "created ASC");
    }

    public static final String[] getVisitedHistory(ContentResolver contentresolver) {
        Cursor cursor = null;
        String as2[] = new String[1];
        as2[0] = "url";
        cursor = contentresolver.query(BrowserContract.History.CONTENT_URI, as2, "visits > 0", null, null);
        if(cursor != null) goto _L2; else goto _L1
_L1:
        String as1[] = new String[0];
        if(cursor != null)
            cursor.close();
_L5:
        return as1;
_L2:
        String as[];
        int i;
        as = new String[cursor.getCount()];
        i = 0;
_L3:
        if(!cursor.moveToNext())
            break MISSING_BLOCK_LABEL_93;
        as[i] = cursor.getString(0);
        i++;
          goto _L3
        if(cursor != null)
            cursor.close();
_L6:
        as1 = as;
        if(true) goto _L5; else goto _L4
_L4:
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e("browser", "getVisitedHistory", illegalstateexception);
        as = new String[0];
        if(cursor != null)
            cursor.close();
          goto _L6
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
    }

    private static final Cursor getVisitedLike(ContentResolver contentresolver, String s) {
        boolean flag = false;
        String s1 = s;
        StringBuilder stringbuilder;
        Uri uri;
        String as[];
        if(s1.startsWith("http://"))
            s1 = s1.substring(7);
        else
        if(s1.startsWith("https://")) {
            s1 = s1.substring(8);
            flag = true;
        }
        if(s1.startsWith("www."))
            s1 = s1.substring(4);
        if(flag) {
            stringbuilder = new StringBuilder("url = ");
            DatabaseUtils.appendEscapedSQLString(stringbuilder, (new StringBuilder()).append("https://").append(s1).toString());
            addOrUrlEquals(stringbuilder);
            DatabaseUtils.appendEscapedSQLString(stringbuilder, (new StringBuilder()).append("https://www.").append(s1).toString());
        } else {
            stringbuilder = new StringBuilder("url = ");
            DatabaseUtils.appendEscapedSQLString(stringbuilder, s1);
            addOrUrlEquals(stringbuilder);
            String s2 = (new StringBuilder()).append("www.").append(s1).toString();
            DatabaseUtils.appendEscapedSQLString(stringbuilder, s2);
            addOrUrlEquals(stringbuilder);
            DatabaseUtils.appendEscapedSQLString(stringbuilder, (new StringBuilder()).append("http://").append(s1).toString());
            addOrUrlEquals(stringbuilder);
            DatabaseUtils.appendEscapedSQLString(stringbuilder, (new StringBuilder()).append("http://").append(s2).toString());
        }
        uri = BrowserContract.History.CONTENT_URI;
        as = new String[2];
        as[0] = "_id";
        as[1] = "visits";
        return contentresolver.query(uri, as, stringbuilder.toString(), null, null);
    }

    public static final void requestAllIcons(ContentResolver contentresolver, String s, android.webkit.WebIconDatabase.IconListener iconlistener) {
        WebIconDatabase.getInstance().bulkRequestIconForPageUrl(contentresolver, s, iconlistener);
    }

    public static final void saveBookmark(Context context, String s, String s1) {
        Intent intent = new Intent("android.intent.action.INSERT", BOOKMARKS_URI);
        intent.putExtra("title", s);
        intent.putExtra("url", s1);
        context.startActivity(intent);
    }

    public static final void sendString(Context context, String s) {
        sendString(context, s, context.getString(0x10403ef));
    }

    public static final void sendString(Context context, String s, String s1) {
        Intent intent;
        intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", s);
        Intent intent1 = Intent.createChooser(intent, s1);
        intent1.setFlags(0x10000000);
        context.startActivity(intent1);
_L2:
        return;
        ActivityNotFoundException activitynotfoundexception;
        activitynotfoundexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final void truncateHistory(ContentResolver contentresolver) {
        Cursor cursor = null;
        Uri uri = BrowserContract.History.CONTENT_URI;
        String as[] = new String[3];
        as[0] = "_id";
        as[1] = "url";
        as[2] = "date";
        cursor = contentresolver.query(uri, as, null, null, "date ASC");
        if(!cursor.moveToFirst() || cursor.getCount() < 250) goto _L2; else goto _L1
_L1:
        WebIconDatabase webicondatabase;
        int i;
        webicondatabase = WebIconDatabase.getInstance();
        i = 0;
_L5:
        if(i >= 5) goto _L2; else goto _L3
_L3:
        boolean flag;
        contentresolver.delete(ContentUris.withAppendedId(BrowserContract.History.CONTENT_URI, cursor.getLong(0)), null, null);
        webicondatabase.releaseIconForPageUrl(cursor.getString(1));
        flag = cursor.moveToNext();
        if(flag) goto _L4; else goto _L2
_L2:
        if(cursor != null)
            cursor.close();
_L6:
        return;
_L4:
        i++;
          goto _L5
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e("browser", "truncateHistory", illegalstateexception);
        if(cursor != null)
            cursor.close();
          goto _L6
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
          goto _L5
    }

    public static final void updateVisitedHistory(ContentResolver contentresolver, String s, boolean flag) {
        long l;
        Cursor cursor;
        l = System.currentTimeMillis();
        cursor = null;
        cursor = getVisitedLike(contentresolver, s);
        if(!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        ContentValues contentvalues = new ContentValues();
        if(!flag) goto _L4; else goto _L3
_L3:
        contentvalues.put("visits", Integer.valueOf(1 + cursor.getInt(1)));
_L5:
        contentvalues.put("date", Long.valueOf(l));
        contentresolver.update(ContentUris.withAppendedId(BrowserContract.History.CONTENT_URI, cursor.getLong(0)), contentvalues, null, null);
_L7:
        if(cursor != null)
            cursor.close();
_L6:
        return;
_L4:
        contentvalues.put("user_entered", Integer.valueOf(1));
          goto _L5
        IllegalStateException illegalstateexception;
        illegalstateexception;
        Log.e("browser", "updateVisitedHistory", illegalstateexception);
        if(cursor != null)
            cursor.close();
          goto _L6
_L2:
        ContentValues contentvalues1;
        int i;
        int j;
        truncateHistory(contentresolver);
        contentvalues1 = new ContentValues();
        if(!flag)
            break MISSING_BLOCK_LABEL_262;
        i = 1;
        j = 0;
_L8:
        contentvalues1.put("url", s);
        contentvalues1.put("visits", Integer.valueOf(i));
        contentvalues1.put("date", Long.valueOf(l));
        contentvalues1.put("title", s);
        contentvalues1.put("created", Integer.valueOf(0));
        contentvalues1.put("user_entered", Integer.valueOf(j));
        contentresolver.insert(BrowserContract.History.CONTENT_URI, contentvalues1);
          goto _L7
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
        i = 0;
        j = 1;
          goto _L8
    }

    public static final Uri BOOKMARKS_URI = Uri.parse("content://browser/bookmarks");
    public static final String EXTRA_APPLICATION_ID = "com.android.browser.application_id";
    public static final String EXTRA_CREATE_NEW_TAB = "create_new_tab";
    public static final String EXTRA_HEADERS = "com.android.browser.headers";
    public static final String EXTRA_SHARE_FAVICON = "share_favicon";
    public static final String EXTRA_SHARE_SCREENSHOT = "share_screenshot";
    public static final String HISTORY_PROJECTION[];
    public static final int HISTORY_PROJECTION_BOOKMARK_INDEX = 4;
    public static final int HISTORY_PROJECTION_DATE_INDEX = 3;
    public static final int HISTORY_PROJECTION_FAVICON_INDEX = 6;
    public static final int HISTORY_PROJECTION_ID_INDEX = 0;
    public static final int HISTORY_PROJECTION_THUMBNAIL_INDEX = 7;
    public static final int HISTORY_PROJECTION_TITLE_INDEX = 5;
    public static final int HISTORY_PROJECTION_TOUCH_ICON_INDEX = 8;
    public static final int HISTORY_PROJECTION_URL_INDEX = 1;
    public static final int HISTORY_PROJECTION_VISITS_INDEX = 2;
    public static final String INITIAL_ZOOM_LEVEL = "browser.initialZoomLevel";
    private static final String LOGTAG = "browser";
    private static final int MAX_HISTORY_COUNT = 250;
    public static final String SEARCHES_PROJECTION[];
    public static final int SEARCHES_PROJECTION_DATE_INDEX = 2;
    public static final int SEARCHES_PROJECTION_SEARCH_INDEX = 1;
    public static final Uri SEARCHES_URI = Uri.parse("content://browser/searches");
    public static final String TRUNCATE_HISTORY_PROJECTION[];
    public static final int TRUNCATE_HISTORY_PROJECTION_ID_INDEX = 0;
    public static final int TRUNCATE_N_OLDEST = 5;

    static  {
        String as[] = new String[10];
        as[0] = "_id";
        as[1] = "url";
        as[2] = "visits";
        as[3] = "date";
        as[4] = "bookmark";
        as[5] = "title";
        as[6] = "favicon";
        as[7] = "thumbnail";
        as[8] = "touch_icon";
        as[9] = "user_entered";
        HISTORY_PROJECTION = as;
        String as1[] = new String[2];
        as1[0] = "_id";
        as1[1] = "date";
        TRUNCATE_HISTORY_PROJECTION = as1;
        String as2[] = new String[3];
        as2[0] = "_id";
        as2[1] = "search";
        as2[2] = "date";
        SEARCHES_PROJECTION = as2;
    }
}
