// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DownloadManager {
    static class CursorTranslator extends CursorWrapper {

        private long getErrorCode(int i) {
            if((400 > i || i >= 488) && (500 > i || i >= 600)) goto _L2; else goto _L1
_L1:
            long l = i;
_L4:
            return l;
_L2:
            switch(i) {
            default:
                l = 1000L;
                break;

            case 492: 
                l = 1001L;
                break;

            case 493: 
            case 494: 
                l = 1002L;
                break;

            case 495: 
                l = 1004L;
                break;

            case 497: 
                l = 1005L;
                break;

            case 198: 
                l = 1006L;
                break;

            case 199: 
                l = 1007L;
                break;

            case 489: 
                l = 1008L;
                break;

            case 488: 
                l = 1009L;
                break;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private String getLocalUri() {
            long l = getLong(getColumnIndex("destination"));
            String s1;
            if(l == 4L || l == 0L || l == 6L) {
                String s = getString(getColumnIndex("local_filename"));
                if(s == null)
                    s1 = null;
                else
                    s1 = Uri.fromFile(new File(s)).toString();
            } else {
                long l1 = getLong(getColumnIndex("_id"));
                s1 = ContentUris.withAppendedId(mBaseUri, l1).toString();
            }
            return s1;
        }

        private long getPausedReason(int i) {
            i;
            JVM INSTR tableswitch 194 196: default 28
        //                       194 35
        //                       195 40
        //                       196 47;
               goto _L1 _L2 _L3 _L4
_L1:
            long l = Injector.getPausedReason(i);
_L6:
            return l;
_L2:
            l = 1L;
            continue; /* Loop/switch isn't completed */
_L3:
            l = 2L;
            continue; /* Loop/switch isn't completed */
_L4:
            l = 3L;
            if(true) goto _L6; else goto _L5
_L5:
        }

        private long getReason(int i) {
            translateStatus(i);
            JVM INSTR lookupswitch 2: default 32
        //                       4: 45
        //                       16: 36;
               goto _L1 _L2 _L3
_L1:
            long l = 0L;
_L5:
            return l;
_L3:
            l = getErrorCode(i);
            continue; /* Loop/switch isn't completed */
_L2:
            l = getPausedReason(i);
            if(true) goto _L5; else goto _L4
_L4:
        }

        static int translateStatus(int i) {
            i;
            JVM INSTR tableswitch 190 200: default 60
        //                       190 81
        //                       191 60
        //                       192 85
        //                       193 90
        //                       194 90
        //                       195 90
        //                       196 90
        //                       197 60
        //                       198 60
        //                       199 60
        //                       200 95;
               goto _L1 _L2 _L1 _L3 _L4 _L4 _L4 _L4 _L1 _L1 _L1 _L5
_L1:
            int j;
            if(!$assertionsDisabled && !android.provider.Downloads.Impl.isStatusError(i))
                throw new AssertionError();
            j = 16;
              goto _L6
_L2:
            j = 1;
_L8:
            return j;
_L3:
            j = 2;
            continue; /* Loop/switch isn't completed */
_L4:
            j = 4;
            continue; /* Loop/switch isn't completed */
_L5:
            j = 8;
            continue; /* Loop/switch isn't completed */
_L6:
            if(true) goto _L8; else goto _L7
_L7:
        }

        String callGetLocalUri() {
            return getLocalUri();
        }

        public int getInt(int i) {
            return (int)getLong(i);
        }

        public long getLong(int i) {
            long l;
            if(getColumnName(i).equals("reason"))
                l = getReason(super.getInt(getColumnIndex("status")));
            else
            if(getColumnName(i).equals("status"))
                l = translateStatus(super.getInt(getColumnIndex("status")));
            else
                l = super.getLong(i);
            return l;
        }

        public String getString(int i) {
            String s;
            if(getColumnName(i).equals("local_uri"))
                s = Injector.getLocalUri(this);
            else
                s = super.getString(i);
            return s;
        }

        static final boolean $assertionsDisabled;
        private Uri mBaseUri;

        static  {
            boolean flag;
            if(!android/app/DownloadManager.desiredAssertionStatus())
                flag = true;
            else
                flag = false;
            $assertionsDisabled = flag;
        }

        public CursorTranslator(Cursor cursor, Uri uri) {
            super(cursor);
            mBaseUri = uri;
        }
    }

    public static class Query {

        private String joinStrings(String s, Iterable iterable) {
            StringBuilder stringbuilder = new StringBuilder();
            boolean flag = true;
            for(Iterator iterator = iterable.iterator(); iterator.hasNext();) {
                String s1 = (String)iterator.next();
                if(!flag)
                    stringbuilder.append(s);
                stringbuilder.append(s1);
                flag = false;
            }

            return stringbuilder.toString();
        }

        private String statusClause(String s, int i) {
            return (new StringBuilder()).append("status").append(s).append("'").append(i).append("'").toString();
        }

        void addExtraSelectionParts(List list) {
        }

        public Query orderBy(String s, int i) {
            if(i != 1 && i != 2)
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid direction: ").append(i).toString());
            if(s.equals("last_modified_timestamp"))
                mOrderByColumn = "lastmod";
            else
            if(s.equals("total_size"))
                mOrderByColumn = "total_bytes";
            else
                throw new IllegalArgumentException((new StringBuilder()).append("Cannot order by ").append(s).toString());
            mOrderDirection = i;
            return this;
        }

        Cursor runQuery(ContentResolver contentresolver, String as[], Uri uri) {
            ArrayList arraylist = new ArrayList();
            String as1[] = null;
            if(mIds != null) {
                arraylist.add(DownloadManager.getWhereClauseForIds(mIds));
                as1 = DownloadManager.getWhereArgsForIds(mIds);
            }
            if(mStatusFlags != null) {
                ArrayList arraylist1 = new ArrayList();
                if((1 & mStatusFlags.intValue()) != 0)
                    arraylist1.add(statusClause("=", 190));
                if((2 & mStatusFlags.intValue()) != 0)
                    arraylist1.add(statusClause("=", 192));
                if((4 & mStatusFlags.intValue()) != 0) {
                    arraylist1.add(statusClause("=", 193));
                    arraylist1.add(statusClause("=", 194));
                    arraylist1.add(statusClause("=", 195));
                    arraylist1.add(statusClause("=", 196));
                }
                if((8 & mStatusFlags.intValue()) != 0)
                    arraylist1.add(statusClause("=", 200));
                if((0x10 & mStatusFlags.intValue()) != 0)
                    arraylist1.add((new StringBuilder()).append("(").append(statusClause(">=", 400)).append(" AND ").append(statusClause("<", 600)).append(")").toString());
                arraylist.add(Injector.addParens(joinStrings(" OR ", arraylist1)));
            }
            if(mOnlyIncludeVisibleInDownloadsUi)
                arraylist.add("is_visible_in_downloads_ui != '0'");
            addExtraSelectionParts(arraylist);
            arraylist.add("deleted != '1'");
            String s = joinStrings(" AND ", arraylist);
            String s1;
            if(mOrderDirection == 1)
                s1 = "ASC";
            else
                s1 = "DESC";
            return contentresolver.query(uri, as, s, as1, (new StringBuilder()).append(mOrderByColumn).append(" ").append(s1).toString());
        }

        public transient Query setFilterById(long al[]) {
            mIds = al;
            return this;
        }

        public Query setFilterByStatus(int i) {
            mStatusFlags = Integer.valueOf(i);
            return this;
        }

        public Query setOnlyIncludeVisibleInDownloadsUi(boolean flag) {
            mOnlyIncludeVisibleInDownloadsUi = flag;
            return this;
        }

        void setOrderByColumn(String s) {
            mOrderByColumn = s;
        }

        void setOrderDirection(int i) {
            mOrderDirection = i;
        }

        public static final int ORDER_ASCENDING = 1;
        public static final int ORDER_DESCENDING = 2;
        private long mIds[];
        private boolean mOnlyIncludeVisibleInDownloadsUi;
        private String mOrderByColumn;
        private int mOrderDirection;
        private Integer mStatusFlags;

        public Query() {
            mIds = null;
            mStatusFlags = null;
            mOrderByColumn = "lastmod";
            mOrderDirection = 2;
            mOnlyIncludeVisibleInDownloadsUi = false;
        }
    }

    public static class Request {

        private void encodeHttpHeaders(ContentValues contentvalues) {
            int i = 0;
            for(Iterator iterator = mRequestHeaders.iterator(); iterator.hasNext();) {
                Pair pair = (Pair)iterator.next();
                String s = (new StringBuilder()).append((String)pair.first).append(": ").append((String)pair.second).toString();
                contentvalues.put((new StringBuilder()).append("http_header_").append(i).toString(), s);
                i++;
            }

        }

        private void putIfNonNull(ContentValues contentvalues, String s, Object obj) {
            if(obj != null)
                contentvalues.put(s, obj.toString());
        }

        private void setDestinationFromBase(File file, String s) {
            if(s == null) {
                throw new NullPointerException("subPath cannot be null");
            } else {
                mDestinationUri = Uri.withAppendedPath(Uri.fromFile(file), s);
                return;
            }
        }

        public Request addRequestHeader(String s, String s1) {
            if(s == null)
                throw new NullPointerException("header cannot be null");
            if(s.contains(":"))
                throw new IllegalArgumentException("header may not contain ':'");
            if(s1 == null)
                s1 = "";
            mRequestHeaders.add(Pair.create(s, s1));
            return this;
        }

        public void allowScanningByMediaScanner() {
            mScannable = true;
        }

        public Request setAllowedNetworkTypes(int i) {
            mAllowedNetworkTypes = i;
            return this;
        }

        public Request setAllowedOverMetered(boolean flag) {
            mMeteredAllowed = flag;
            return this;
        }

        public Request setAllowedOverRoaming(boolean flag) {
            mRoamingAllowed = flag;
            return this;
        }

        public Request setDescription(CharSequence charsequence) {
            mDescription = charsequence;
            return this;
        }

        public Request setDestinationInExternalFilesDir(Context context, String s, String s1) {
            setDestinationFromBase(context.getExternalFilesDir(s), s1);
            return this;
        }

        public Request setDestinationInExternalPublicDir(String s, String s1) {
            File file = Environment.getExternalStoragePublicDirectory(s);
            if(file.exists()) {
                if(!file.isDirectory())
                    throw new IllegalStateException((new StringBuilder()).append(file.getAbsolutePath()).append(" already exists and is not a directory").toString());
            } else
            if(!file.mkdir())
                throw new IllegalStateException((new StringBuilder()).append("Unable to create directory: ").append(file.getAbsolutePath()).toString());
            setDestinationFromBase(file, s1);
            return this;
        }

        public Request setDestinationToSystemCache() {
            mUseSystemCache = true;
            return this;
        }

        public Request setDestinationUri(Uri uri) {
            mDestinationUri = uri;
            return this;
        }

        public Request setMimeType(String s) {
            mMimeType = s;
            return this;
        }

        public Request setNotificationVisibility(int i) {
            mNotificationVisibility = i;
            return this;
        }

        public Request setShowRunningNotification(boolean flag) {
            Request request;
            if(flag)
                request = setNotificationVisibility(0);
            else
                request = setNotificationVisibility(2);
            return request;
        }

        public Request setTitle(CharSequence charsequence) {
            mTitle = charsequence;
            return this;
        }

        public Request setVisibleInDownloadsUi(boolean flag) {
            mIsVisibleInDownloadsUi = flag;
            return this;
        }

        ContentValues toContentValues(String s) {
            byte byte0 = 2;
            ContentValues contentvalues = new ContentValues();
            if(!$assertionsDisabled && mUri == null)
                throw new AssertionError();
            contentvalues.put("uri", mUri.toString());
            contentvalues.put("is_public_api", Boolean.valueOf(true));
            contentvalues.put("notificationpackage", s);
            if(mDestinationUri != null) {
                contentvalues.put("destination", Integer.valueOf(4));
                contentvalues.put("hint", mDestinationUri.toString());
            } else {
                byte byte1;
                if(mUseSystemCache)
                    byte1 = 5;
                else
                    byte1 = byte0;
                contentvalues.put("destination", Integer.valueOf(byte1));
            }
            if(mScannable)
                byte0 = 0;
            contentvalues.put("scanned", Integer.valueOf(byte0));
            if(!mRequestHeaders.isEmpty())
                encodeHttpHeaders(contentvalues);
            putIfNonNull(contentvalues, "title", mTitle);
            putIfNonNull(contentvalues, "description", mDescription);
            putIfNonNull(contentvalues, "mimetype", mMimeType);
            contentvalues.put("visibility", Integer.valueOf(mNotificationVisibility));
            contentvalues.put("allowed_network_types", Integer.valueOf(mAllowedNetworkTypes));
            contentvalues.put("allow_roaming", Boolean.valueOf(mRoamingAllowed));
            contentvalues.put("allow_metered", Boolean.valueOf(mMeteredAllowed));
            contentvalues.put("is_visible_in_downloads_ui", Boolean.valueOf(mIsVisibleInDownloadsUi));
            return contentvalues;
        }

        static final boolean $assertionsDisabled = false;
        public static final int NETWORK_MOBILE = 1;
        public static final int NETWORK_WIFI = 2;
        private static final int SCANNABLE_VALUE_NO = 2;
        private static final int SCANNABLE_VALUE_YES = 0;
        public static final int VISIBILITY_HIDDEN = 2;
        public static final int VISIBILITY_VISIBLE = 0;
        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
        public static final int VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION = 3;
        private int mAllowedNetworkTypes;
        private CharSequence mDescription;
        private Uri mDestinationUri;
        private boolean mIsVisibleInDownloadsUi;
        private boolean mMeteredAllowed;
        private String mMimeType;
        private int mNotificationVisibility;
        private List mRequestHeaders;
        private boolean mRoamingAllowed;
        private boolean mScannable;
        private CharSequence mTitle;
        private Uri mUri;
        private boolean mUseSystemCache;

        static  {
            boolean flag;
            if(!android/app/DownloadManager.desiredAssertionStatus())
                flag = true;
            else
                flag = false;
            $assertionsDisabled = flag;
        }

        public Request(Uri uri) {
            mRequestHeaders = new ArrayList();
            mAllowedNetworkTypes = -1;
            mRoamingAllowed = true;
            mMeteredAllowed = true;
            mIsVisibleInDownloadsUi = true;
            mScannable = false;
            mUseSystemCache = false;
            mNotificationVisibility = 0;
            if(uri == null)
                throw new NullPointerException();
            String s = uri.getScheme();
            if(s == null || !s.equals("http") && !s.equals("https")) {
                throw new IllegalArgumentException((new StringBuilder()).append("Can only download HTTP/HTTPS URIs: ").append(uri).toString());
            } else {
                mUri = uri;
                return;
            }
        }

        Request(String s) {
            mRequestHeaders = new ArrayList();
            mAllowedNetworkTypes = -1;
            mRoamingAllowed = true;
            mMeteredAllowed = true;
            mIsVisibleInDownloadsUi = true;
            mScannable = false;
            mUseSystemCache = false;
            mNotificationVisibility = 0;
            mUri = Uri.parse(s);
        }
    }

    static class Injector {

        static String addParens(String s) {
            return (new StringBuilder()).append("(").append(s).append(")").toString();
        }

        static String getLocalUri(CursorTranslator cursortranslator) {
            String s;
            if(cursortranslator.getLong(cursortranslator.getColumnIndex("destination")) == 4L)
                s = cursortranslator.getString(cursortranslator.getColumnIndex("hint"));
            else
                s = cursortranslator.callGetLocalUri();
            return s;
        }

        public static long getPausedReason(int i) {
            long l;
            if(i == 193)
                l = 5L;
            else
                l = 4L;
            return l;
        }

        Injector() {
        }
    }


    public DownloadManager(ContentResolver contentresolver, String s) {
        mBaseUri = android.provider.Downloads.Impl.CONTENT_URI;
        mResolver = contentresolver;
        mPackageName = s;
    }

    public static long getActiveNetworkWarningBytes(Context context) {
        return -1L;
    }

    public static Long getMaxBytesOverMobile(Context context) {
        Long long2 = Long.valueOf(android.provider.Settings.Secure.getLong(context.getContentResolver(), "download_manager_max_bytes_over_mobile"));
        Long long1 = long2;
_L2:
        return long1;
        android.provider.Settings.SettingNotFoundException settingnotfoundexception;
        settingnotfoundexception;
        long1 = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static Long getRecommendedMaxBytesOverMobile(Context context) {
        Long long2 = Long.valueOf(android.provider.Settings.Secure.getLong(context.getContentResolver(), "download_manager_recommended_max_bytes_over_mobile"));
        Long long1 = long2;
_L2:
        return long1;
        android.provider.Settings.SettingNotFoundException settingnotfoundexception;
        settingnotfoundexception;
        long1 = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    static String[] getWhereArgsForIds(long al[]) {
        String as[] = new String[al.length];
        for(int i = 0; i < al.length; i++)
            as[i] = Long.toString(al[i]);

        return as;
    }

    static String getWhereClauseForIds(long al[]) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("(");
        for(int i = 0; i < al.length; i++) {
            if(i > 0)
                stringbuilder.append("OR ");
            stringbuilder.append("_id");
            stringbuilder.append(" = ? ");
        }

        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public static boolean isActiveNetworkExpensive(Context context) {
        return false;
    }

    private static void validateArgumentIsNonEmpty(String s, String s1) {
        if(TextUtils.isEmpty(s1))
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" can't be null").toString());
        else
            return;
    }

    public long addCompletedDownload(String s, String s1, boolean flag, String s2, String s3, long l, 
            boolean flag1) {
        byte byte0 = 2;
        validateArgumentIsNonEmpty("title", s);
        validateArgumentIsNonEmpty("description", s1);
        validateArgumentIsNonEmpty("path", s3);
        validateArgumentIsNonEmpty("mimeType", s2);
        if(l < 0L)
            throw new IllegalArgumentException(" invalid value for param: totalBytes");
        ContentValues contentvalues = (new Request("non-dwnldmngr-download-dont-retry2download")).setTitle(s).setDescription(s1).setMimeType(s2).toContentValues(null);
        contentvalues.put("destination", Integer.valueOf(6));
        contentvalues.put("_data", s3);
        contentvalues.put("status", Integer.valueOf(200));
        contentvalues.put("total_bytes", Long.valueOf(l));
        int i;
        Uri uri;
        long l1;
        if(flag)
            i = 0;
        else
            i = byte0;
        contentvalues.put("scanned", Integer.valueOf(i));
        if(flag1)
            byte0 = 3;
        contentvalues.put("visibility", Integer.valueOf(byte0));
        uri = mResolver.insert(android.provider.Downloads.Impl.CONTENT_URI, contentvalues);
        if(uri == null)
            l1 = -1L;
        else
            l1 = Long.parseLong(uri.getLastPathSegment());
        return l1;
    }

    public long enqueue(Request request) {
        ContentValues contentvalues = request.toContentValues(mPackageName);
        return Long.parseLong(mResolver.insert(android.provider.Downloads.Impl.CONTENT_URI, contentvalues).getLastPathSegment());
    }

    Uri getBaseUri() {
        return mBaseUri;
    }

    Uri getDownloadUri(long l) {
        return ContentUris.withAppendedId(mBaseUri, l);
    }

    public String getMimeTypeForDownloadedFile(long l) {
        String s;
        Query query2;
        Cursor cursor;
        s = null;
        Query query1 = new Query();
        long al[] = new long[1];
        al[0] = l;
        query2 = query1.setFilterById(al);
        cursor = null;
        Cursor cursor1 = query(query2);
        cursor = cursor1;
        if(cursor != null) goto _L2; else goto _L1
_L1:
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
_L4:
        return s;
_L2:
        String s1;
        if(!cursor.moveToFirst())
            continue; /* Loop/switch isn't completed */
        s1 = cursor.getString(cursor.getColumnIndexOrThrow("media_type"));
        s = s1;
        if(cursor == null) goto _L4; else goto _L5
_L5:
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
        if(cursor == null) goto _L4; else goto _L3
    }

    public Uri getUriForDownloadedFile(long l) {
        Uri uri;
        Query query2;
        Cursor cursor;
        uri = null;
        Query query1 = new Query();
        long al[] = new long[1];
        al[0] = l;
        query2 = query1.setFilterById(al);
        cursor = null;
        Cursor cursor1 = query(query2);
        cursor = cursor1;
        if(cursor != null) goto _L2; else goto _L1
_L1:
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
_L4:
        return uri;
_L2:
label0:
        {
            if(!cursor.moveToFirst() || 8 != cursor.getInt(cursor.getColumnIndexOrThrow("status")))
                continue; /* Loop/switch isn't completed */
            int i = cursor.getInt(cursor.getColumnIndexOrThrow("destination"));
            if(i != 1 && i != 5 && i != 3 && i != 2)
                break label0;
            uri = ContentUris.withAppendedId(android.provider.Downloads.Impl.CONTENT_URI, l);
            if(cursor != null)
                break; /* Loop/switch isn't completed */
        }
          goto _L4
        Uri uri1 = Uri.fromFile(new File(cursor.getString(cursor.getColumnIndexOrThrow("local_filename"))));
        uri = uri1;
        if(cursor == null) goto _L4; else goto _L5
_L5:
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
        if(cursor == null) goto _L4; else goto _L3
    }

    public transient int markRowDeleted(long al[]) {
        if(al == null || al.length == 0)
            throw new IllegalArgumentException("input param 'ids' can't be null");
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("deleted", Integer.valueOf(1));
        int i;
        if(al.length == 1)
            i = mResolver.update(ContentUris.withAppendedId(mBaseUri, al[0]), contentvalues, null, null);
        else
            i = mResolver.update(mBaseUri, contentvalues, getWhereClauseForIds(al), getWhereArgsForIds(al));
        return i;
    }

    public ParcelFileDescriptor openDownloadedFile(long l) throws FileNotFoundException {
        return mResolver.openFileDescriptor(getDownloadUri(l), "r");
    }

    public Cursor query(Query query1) {
        Cursor cursor = query1.runQuery(mResolver, UNDERLYING_COLUMNS, mBaseUri);
        Object obj;
        if(cursor == null)
            obj = null;
        else
            obj = new CursorTranslator(cursor, mBaseUri);
        return ((Cursor) (obj));
    }

    public transient int remove(long al[]) {
        return markRowDeleted(al);
    }

    public transient void restartDownload(long al[]) {
        Cursor cursor = query((new Query()).setFilterById(al));
        cursor.moveToFirst();
_L1:
        if(cursor.isAfterLast())
            break MISSING_BLOCK_LABEL_122;
        int i = cursor.getInt(cursor.getColumnIndex("status"));
        if(i != 8 && i != 16)
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot restart incomplete download: ").append(cursor.getLong(cursor.getColumnIndex("_id"))).toString());
        break MISSING_BLOCK_LABEL_112;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
        cursor.moveToNext();
          goto _L1
        cursor.close();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("current_bytes", Integer.valueOf(0));
        contentvalues.put("total_bytes", Integer.valueOf(-1));
        contentvalues.putNull("_data");
        contentvalues.put("status", Integer.valueOf(190));
        mResolver.update(mBaseUri, contentvalues, getWhereClauseForIds(al), getWhereArgsForIds(al));
        return;
    }

    public void setAccessAllDownloads(boolean flag) {
        if(flag)
            mBaseUri = android.provider.Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI;
        else
            mBaseUri = android.provider.Downloads.Impl.CONTENT_URI;
    }

    public static final String ACTION_DOWNLOAD_COMPLETE = "android.intent.action.DOWNLOAD_COMPLETE";
    public static final String ACTION_NOTIFICATION_CLICKED = "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
    public static final String ACTION_VIEW_DOWNLOADS = "android.intent.action.VIEW_DOWNLOADS";
    public static final String COLUMN_BYTES_DOWNLOADED_SO_FAR = "bytes_so_far";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LAST_MODIFIED_TIMESTAMP = "last_modified_timestamp";
    public static final String COLUMN_LOCAL_FILENAME = "local_filename";
    public static final String COLUMN_LOCAL_URI = "local_uri";
    public static final String COLUMN_MEDIAPROVIDER_URI = "mediaprovider_uri";
    public static final String COLUMN_MEDIA_TYPE = "media_type";
    public static final String COLUMN_REASON = "reason";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_TOTAL_SIZE_BYTES = "total_size";
    public static final String COLUMN_URI = "uri";
    public static final int ERROR_BLOCKED = 1010;
    public static final int ERROR_CANNOT_RESUME = 1008;
    public static final int ERROR_DEVICE_NOT_FOUND = 1007;
    public static final int ERROR_FILE_ALREADY_EXISTS = 1009;
    public static final int ERROR_FILE_ERROR = 1001;
    public static final int ERROR_HTTP_DATA_ERROR = 1004;
    public static final int ERROR_INSUFFICIENT_SPACE = 1006;
    public static final int ERROR_TOO_MANY_REDIRECTS = 1005;
    public static final int ERROR_UNHANDLED_HTTP_CODE = 1002;
    public static final int ERROR_UNKNOWN = 1000;
    public static final String EXTRA_DOWNLOAD_ID = "extra_download_id";
    public static final String EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS = "extra_click_download_ids";
    public static final String INTENT_EXTRAS_SORT_BY_SIZE = "android.app.DownloadManager.extra_sortBySize";
    private static final String NON_DOWNLOADMANAGER_DOWNLOAD = "non-dwnldmngr-download-dont-retry2download";
    public static final int PAUSED_QUEUED_FOR_WIFI = 3;
    public static final int PAUSED_UNKNOWN = 4;
    public static final int PAUSED_WAITING_FOR_NETWORK = 2;
    public static final int PAUSED_WAITING_TO_RETRY = 1;
    public static final int STATUS_FAILED = 16;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_PENDING = 1;
    public static final int STATUS_RUNNING = 2;
    public static final int STATUS_SUCCESSFUL = 8;
    public static final String UNDERLYING_COLUMNS[];
    private Uri mBaseUri;
    private String mPackageName;
    private ContentResolver mResolver;

    static  {
        String as[] = new String[15];
        as[0] = "_id";
        as[1] = "_data AS local_filename";
        as[2] = "mediaprovider_uri";
        as[3] = "destination";
        as[4] = "title";
        as[5] = "description";
        as[6] = "uri";
        as[7] = "status";
        as[8] = "hint";
        as[9] = "mimetype AS media_type";
        as[10] = "total_bytes AS total_size";
        as[11] = "lastmod AS last_modified_timestamp";
        as[12] = "current_bytes AS bytes_so_far";
        as[13] = "'placeholder' AS local_uri";
        as[14] = "'placeholder' AS reason";
        UNDERLYING_COLUMNS = as;
    }
}
