// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.content.*;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.Semaphore;

// Referenced classes of package android.provider:
//            BaseColumns

public class SearchRecentSuggestions {
    private static class SuggestionColumns
        implements BaseColumns {

        public static final String DATE = "date";
        public static final String DISPLAY1 = "display1";
        public static final String DISPLAY2 = "display2";
        public static final String QUERY = "query";

        private SuggestionColumns() {
        }
    }


    public SearchRecentSuggestions(Context context, String s, int i) {
        if(TextUtils.isEmpty(s) || (i & 1) == 0)
            throw new IllegalArgumentException();
        boolean flag;
        if((i & 2) != 0)
            flag = true;
        else
            flag = false;
        mTwoLineDisplay = flag;
        mContext = context;
        mAuthority = new String(s);
        mSuggestionsUri = Uri.parse((new StringBuilder()).append("content://").append(mAuthority).append("/suggestions").toString());
    }

    private void saveRecentQueryBlocking(String s, String s1) {
        ContentResolver contentresolver = mContext.getContentResolver();
        long l = System.currentTimeMillis();
        try {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("display1", s);
            if(mTwoLineDisplay)
                contentvalues.put("display2", s1);
            contentvalues.put("query", s);
            contentvalues.put("date", Long.valueOf(l));
            contentresolver.insert(mSuggestionsUri, contentvalues);
        }
        catch(RuntimeException runtimeexception) {
            Log.e("SearchSuggestions", "saveRecentQuery", runtimeexception);
        }
        truncateHistory(contentresolver, 250);
    }

    public void clearHistory() {
        truncateHistory(mContext.getContentResolver(), 0);
    }

    public void saveRecentQuery(String s, String s1) {
        if(!TextUtils.isEmpty(s)) {
            if(!mTwoLineDisplay && !TextUtils.isEmpty(s1))
                throw new IllegalArgumentException();
            (new Thread(s1) {

                public void run() {
                    saveRecentQueryBlocking(queryString, line2);
                    SearchRecentSuggestions.sWritesInProgress.release();
                }

                final SearchRecentSuggestions this$0;
                final String val$line2;
                final String val$queryString;

             {
                this$0 = SearchRecentSuggestions.this;
                queryString = s1;
                line2 = s2;
                super(final_s);
            }
            }).start();
        }
    }

    protected void truncateHistory(ContentResolver contentresolver, int i) {
        String s;
        if(i < 0)
            throw new IllegalArgumentException();
        s = null;
        if(i <= 0)
            break MISSING_BLOCK_LABEL_46;
        s = (new StringBuilder()).append("_id IN (SELECT _id FROM suggestions ORDER BY date DESC LIMIT -1 OFFSET ").append(String.valueOf(i)).append(")").toString();
        contentresolver.delete(mSuggestionsUri, s, null);
_L1:
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.e("SearchSuggestions", "truncateHistory", runtimeexception);
          goto _L1
    }

    void waitForSave() {
        do
            sWritesInProgress.acquireUninterruptibly();
        while(sWritesInProgress.availablePermits() > 0);
    }

    private static final String LOG_TAG = "SearchSuggestions";
    private static final int MAX_HISTORY_COUNT = 250;
    public static final String QUERIES_PROJECTION_1LINE[];
    public static final String QUERIES_PROJECTION_2LINE[];
    public static final int QUERIES_PROJECTION_DATE_INDEX = 1;
    public static final int QUERIES_PROJECTION_DISPLAY1_INDEX = 3;
    public static final int QUERIES_PROJECTION_DISPLAY2_INDEX = 4;
    public static final int QUERIES_PROJECTION_QUERY_INDEX = 2;
    private static final Semaphore sWritesInProgress = new Semaphore(0);
    private final String mAuthority;
    private final Context mContext;
    private final Uri mSuggestionsUri;
    private final boolean mTwoLineDisplay;

    static  {
        String as[] = new String[4];
        as[0] = "_id";
        as[1] = "date";
        as[2] = "query";
        as[3] = "display1";
        QUERIES_PROJECTION_1LINE = as;
        String as1[] = new String[5];
        as1[0] = "_id";
        as1[1] = "date";
        as1[2] = "query";
        as1[3] = "display1";
        as1[4] = "display2";
        QUERIES_PROJECTION_2LINE = as1;
    }


}
