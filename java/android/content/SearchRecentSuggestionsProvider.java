// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

// Referenced classes of package android.content:
//            ContentProvider, Context, ContentResolver, UriMatcher, 
//            ContentValues

public class SearchRecentSuggestionsProvider extends ContentProvider {
    private static class DatabaseHelper extends SQLiteOpenHelper {

        public void onCreate(SQLiteDatabase sqlitedatabase) {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("CREATE TABLE suggestions (_id INTEGER PRIMARY KEY,display1 TEXT UNIQUE ON CONFLICT REPLACE");
            if((2 & mNewVersion) != 0)
                stringbuilder.append(",display2 TEXT");
            stringbuilder.append(",query TEXT,date LONG);");
            sqlitedatabase.execSQL(stringbuilder.toString());
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j) {
            Log.w("SuggestionsProvider", (new StringBuilder()).append("Upgrading database from version ").append(i).append(" to ").append(j).append(", which will destroy all old data").toString());
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS suggestions");
            onCreate(sqlitedatabase);
        }

        private int mNewVersion;

        public DatabaseHelper(Context context, int i) {
            super(context, "suggestions.db", null, i);
            mNewVersion = i;
        }
    }


    public SearchRecentSuggestionsProvider() {
    }

    public int delete(Uri uri, String s, String as[]) {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        if(uri.getPathSegments().size() != 1)
            throw new IllegalArgumentException("Unknown Uri");
        if(((String)uri.getPathSegments().get(0)).equals("suggestions")) {
            int i = sqlitedatabase.delete("suggestions", s, as);
            getContext().getContentResolver().notifyChange(uri, null);
            return i;
        } else {
            throw new IllegalArgumentException("Unknown Uri");
        }
    }

    public String getType(Uri uri) {
        if(mUriMatcher.match(uri) != 1) goto _L2; else goto _L1
_L1:
        String s = "vnd.android.cursor.dir/vnd.android.search.suggest";
_L4:
        return s;
_L2:
        int i = uri.getPathSegments().size();
        if(i < 1 || !((String)uri.getPathSegments().get(0)).equals("suggestions"))
            break; /* Loop/switch isn't completed */
        if(i == 1) {
            s = "vnd.android.cursor.dir/suggestion";
            continue; /* Loop/switch isn't completed */
        }
        if(i != 2)
            break; /* Loop/switch isn't completed */
        s = "vnd.android.cursor.item/suggestion";
        if(true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException("Unknown Uri");
    }

    public Uri insert(Uri uri, ContentValues contentvalues) {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        int i = uri.getPathSegments().size();
        if(i < 1)
            throw new IllegalArgumentException("Unknown Uri");
        long l = -1L;
        String s = (String)uri.getPathSegments().get(0);
        Uri uri1 = null;
        if(s.equals("suggestions") && i == 1) {
            l = sqlitedatabase.insert("suggestions", "query", contentvalues);
            if(l > 0L)
                uri1 = Uri.withAppendedPath(mSuggestionsUri, String.valueOf(l));
        }
        if(l < 0L) {
            throw new IllegalArgumentException("Unknown Uri");
        } else {
            getContext().getContentResolver().notifyChange(uri1, null);
            return uri1;
        }
    }

    public boolean onCreate() {
        if(mAuthority == null || mMode == 0) {
            throw new IllegalArgumentException("Provider not configured");
        } else {
            int i = 512 + mMode;
            mOpenHelper = new DatabaseHelper(getContext(), i);
            return true;
        }
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1) {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getReadableDatabase();
        Cursor cursor;
        if(mUriMatcher.match(uri) == 1) {
            String as3[];
            String s4;
            ContentResolver contentresolver1;
            if(TextUtils.isEmpty(as1[0])) {
                s4 = null;
                as3 = null;
            } else {
                String s3 = (new StringBuilder()).append("%").append(as1[0]).append("%").toString();
                if(mTwoLineDisplay) {
                    as3 = new String[2];
                    as3[0] = s3;
                    as3[1] = s3;
                } else {
                    as3 = new String[1];
                    as3[0] = s3;
                }
                s4 = mSuggestSuggestionClause;
            }
            cursor = sqlitedatabase.query("suggestions", mSuggestionProjection, s4, as3, null, null, "date DESC", null);
            contentresolver1 = getContext().getContentResolver();
            cursor.setNotificationUri(contentresolver1, uri);
        } else {
            int i = uri.getPathSegments().size();
            if(i != 1 && i != 2)
                throw new IllegalArgumentException("Unknown Uri");
            String s2 = (String)uri.getPathSegments().get(0);
            if(!s2.equals("suggestions"))
                throw new IllegalArgumentException("Unknown Uri");
            String as2[] = null;
            if(as != null && as.length > 0) {
                as2 = new String[1 + as.length];
                System.arraycopy(as, 0, as2, 0, as.length);
                as2[as.length] = "_id AS _id";
            }
            StringBuilder stringbuilder = new StringBuilder(256);
            if(i == 2)
                stringbuilder.append("(_id = ").append((String)uri.getPathSegments().get(1)).append(")");
            if(s != null && s.length() > 0) {
                if(stringbuilder.length() > 0)
                    stringbuilder.append(" AND ");
                stringbuilder.append('(');
                stringbuilder.append(s);
                stringbuilder.append(')');
            }
            cursor = sqlitedatabase.query(s2, as2, stringbuilder.toString(), as1, null, null, s1, null);
            ContentResolver contentresolver = getContext().getContentResolver();
            cursor.setNotificationUri(contentresolver, uri);
        }
        return cursor;
    }

    protected void setupSuggestions(String s, int i) {
        if(TextUtils.isEmpty(s) || (i & 1) == 0)
            throw new IllegalArgumentException();
        boolean flag;
        if((i & 2) != 0)
            flag = true;
        else
            flag = false;
        mTwoLineDisplay = flag;
        mAuthority = new String(s);
        mMode = i;
        mSuggestionsUri = Uri.parse((new StringBuilder()).append("content://").append(mAuthority).append("/suggestions").toString());
        mUriMatcher = new UriMatcher(-1);
        mUriMatcher.addURI(mAuthority, "search_suggest_query", 1);
        if(mTwoLineDisplay) {
            mSuggestSuggestionClause = "display1 LIKE ? OR display2 LIKE ?";
            String as1[] = new String[6];
            as1[0] = "0 AS suggest_format";
            as1[1] = "'android.resource://system/17301578' AS suggest_icon_1";
            as1[2] = "display1 AS suggest_text_1";
            as1[3] = "display2 AS suggest_text_2";
            as1[4] = "query AS suggest_intent_query";
            as1[5] = "_id";
            mSuggestionProjection = as1;
        } else {
            mSuggestSuggestionClause = "display1 LIKE ?";
            String as[] = new String[5];
            as[0] = "0 AS suggest_format";
            as[1] = "'android.resource://system/17301578' AS suggest_icon_1";
            as[2] = "display1 AS suggest_text_1";
            as[3] = "query AS suggest_intent_query";
            as[4] = "_id";
            mSuggestionProjection = as;
        }
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[]) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public static final int DATABASE_MODE_2LINES = 2;
    public static final int DATABASE_MODE_QUERIES = 1;
    private static final int DATABASE_VERSION = 512;
    private static final String NULL_COLUMN = "query";
    private static final String ORDER_BY = "date DESC";
    private static final String TAG = "SuggestionsProvider";
    private static final int URI_MATCH_SUGGEST = 1;
    private static final String sDatabaseName = "suggestions.db";
    private static final String sSuggestions = "suggestions";
    private String mAuthority;
    private int mMode;
    private SQLiteOpenHelper mOpenHelper;
    private String mSuggestSuggestionClause;
    private String mSuggestionProjection[];
    private Uri mSuggestionsUri;
    private boolean mTwoLineDisplay;
    private UriMatcher mUriMatcher;
}
