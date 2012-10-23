// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.accounts.Account;
import android.accounts.AccountAndUser;
import android.database.Cursor;
import android.database.sqlite.*;
import android.os.*;
import android.util.*;
import com.android.internal.os.AtomicFile;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FastXmlSerializer;
import java.io.*;
import java.util.*;
import org.xmlpull.v1.*;

// Referenced classes of package android.content:
//            Intent, SyncStatusInfo, Context, ISyncStatusObserver, 
//            ContentResolver, SyncOperation, SyncInfo, SyncQueue, 
//            PeriodicSync

public class SyncStorageEngine extends Handler {
    static interface OnSyncRequestListener {

        public abstract void onSyncRequest(Account account, int i, String s, Bundle bundle);
    }

    public static class DayStats {

        public final int day;
        public int failureCount;
        public long failureTime;
        public int successCount;
        public long successTime;

        public DayStats(int i) {
            day = i;
        }
    }

    public static class SyncHistoryItem {

        int authorityId;
        long downstreamActivity;
        long elapsedTime;
        int event;
        long eventTime;
        int historyId;
        boolean initialization;
        String mesg;
        int source;
        long upstreamActivity;

        public SyncHistoryItem() {
        }
    }

    public static class AuthorityInfo {

        final Account account;
        final String authority;
        long backoffDelay;
        long backoffTime;
        long delayUntil;
        boolean enabled;
        final int ident;
        final ArrayList periodicSyncs;
        int syncable;
        final int userId;

        AuthorityInfo(Account account1, int i, String s, int j) {
            account = account1;
            userId = i;
            authority = s;
            ident = j;
            enabled = false;
            syncable = -1;
            backoffTime = -1L;
            backoffDelay = -1L;
            periodicSyncs = new ArrayList();
            periodicSyncs.add(Pair.create(new Bundle(), Long.valueOf(0x15180L)));
        }

        AuthorityInfo(AuthorityInfo authorityinfo) {
            account = authorityinfo.account;
            userId = authorityinfo.userId;
            authority = authorityinfo.authority;
            ident = authorityinfo.ident;
            enabled = authorityinfo.enabled;
            syncable = authorityinfo.syncable;
            backoffTime = authorityinfo.backoffTime;
            backoffDelay = authorityinfo.backoffDelay;
            delayUntil = authorityinfo.delayUntil;
            periodicSyncs = new ArrayList();
            Pair pair;
            for(Iterator iterator = authorityinfo.periodicSyncs.iterator(); iterator.hasNext(); periodicSyncs.add(Pair.create(new Bundle((Bundle)pair.first), pair.second)))
                pair = (Pair)iterator.next();

        }
    }

    static class AccountInfo {

        final AccountAndUser accountAndUser;
        final HashMap authorities = new HashMap();

        AccountInfo(AccountAndUser accountanduser) {
            accountAndUser = accountanduser;
        }
    }

    public static class PendingOperation {

        final Account account;
        final String authority;
        int authorityId;
        final boolean expedited;
        final Bundle extras;
        byte flatExtras[];
        final int syncSource;
        final int userId;

        PendingOperation(Account account1, int i, int j, String s, Bundle bundle, boolean flag) {
            account = account1;
            userId = i;
            syncSource = j;
            authority = s;
            if(bundle != null)
                bundle = new Bundle(bundle);
            extras = bundle;
            expedited = flag;
            authorityId = -1;
        }

        PendingOperation(PendingOperation pendingoperation) {
            account = pendingoperation.account;
            userId = pendingoperation.userId;
            syncSource = pendingoperation.syncSource;
            authority = pendingoperation.authority;
            extras = pendingoperation.extras;
            authorityId = pendingoperation.authorityId;
            expedited = pendingoperation.expedited;
        }
    }


    private SyncStorageEngine(Context context, File file) {
        mNextAuthorityId = 0;
        mNumPendingFinished = 0;
        mNextHistoryId = 0;
        mMasterSyncAutomatically = new SparseArray();
        mContext = context;
        sSyncStorageEngine = this;
        File file1 = new File(new File(file, "system"), "sync");
        file1.mkdirs();
        mAccountInfoFile = new AtomicFile(new File(file1, "accounts.xml"));
        mStatusFile = new AtomicFile(new File(file1, "status.bin"));
        mPendingFile = new AtomicFile(new File(file1, "pending.bin"));
        mStatisticsFile = new AtomicFile(new File(file1, "stats.bin"));
        readAccountInfoLocked();
        readStatusLocked();
        readPendingOperationsLocked();
        readStatisticsLocked();
        readAndDeleteLegacyAccountInfoLocked();
        writeAccountInfoLocked();
        writeStatusLocked();
        writePendingOperationsLocked();
        writeStatisticsLocked();
    }

    private void appendPendingOperationLocked(PendingOperation pendingoperation) {
        FileOutputStream fileoutputstream = mPendingFile.openAppend();
        Parcel parcel = Parcel.obtain();
        writePendingOperationLocked(pendingoperation, parcel);
        fileoutputstream.write(parcel.marshall());
        parcel.recycle();
        fileoutputstream.close();
_L1:
        return;
        IOException ioexception;
        ioexception;
        writePendingOperationsLocked();
          goto _L1
        IOException ioexception2;
        ioexception2;
        Log.w("SyncManager", "Error writing pending operations", ioexception2);
        try {
            fileoutputstream.close();
        }
        catch(IOException ioexception3) { }
          goto _L1
        Exception exception;
        exception;
        try {
            fileoutputstream.close();
        }
        catch(IOException ioexception1) { }
        throw exception;
    }

    public static boolean equals(Bundle bundle, Bundle bundle1) {
        boolean flag = false;
        if(bundle.size() == bundle1.size()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(bundle.isEmpty()) {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        for(Iterator iterator = bundle.keySet().iterator(); iterator.hasNext();) {
            String s = (String)iterator.next();
            if(!bundle1.containsKey(s) || !bundle.get(s).equals(bundle1.get(s)))
                continue; /* Loop/switch isn't completed */
        }

        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static byte[] flattenBundle(Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        byte abyte0[];
        bundle.writeToParcel(parcel, 0);
        abyte0 = parcel.marshall();
        parcel.recycle();
        return abyte0;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    private AuthorityInfo getAuthorityLocked(Account account, int i, String s, String s1) {
        AccountAndUser accountanduser;
        AccountInfo accountinfo;
        accountanduser = new AccountAndUser(account, i);
        accountinfo = (AccountInfo)mAccounts.get(accountanduser);
        if(accountinfo != null) goto _L2; else goto _L1
_L1:
        AuthorityInfo authorityinfo;
        if(s1 != null && Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append(s1).append(": unknown account ").append(accountanduser).toString());
        authorityinfo = null;
_L4:
        return authorityinfo;
_L2:
        authorityinfo = (AuthorityInfo)accountinfo.authorities.get(s);
        if(authorityinfo == null) {
            if(s1 != null && Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", (new StringBuilder()).append(s1).append(": unknown authority ").append(s).toString());
            authorityinfo = null;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private int getCurrentDayLocked() {
        mCal.setTimeInMillis(System.currentTimeMillis());
        int i = mCal.get(6);
        if(mYear != mCal.get(1)) {
            mYear = mCal.get(1);
            mCal.clear();
            mCal.set(1, mYear);
            mYearInDays = (int)(mCal.getTimeInMillis() / 0x5265c00L);
        }
        return i + mYearInDays;
    }

    static int getIntColumn(Cursor cursor, String s) {
        return cursor.getInt(cursor.getColumnIndex(s));
    }

    static long getLongColumn(Cursor cursor, String s) {
        return cursor.getLong(cursor.getColumnIndex(s));
    }

    private AuthorityInfo getOrCreateAuthorityLocked(Account account, int i, String s, int j, boolean flag) {
        AccountAndUser accountanduser = new AccountAndUser(account, i);
        AccountInfo accountinfo = (AccountInfo)mAccounts.get(accountanduser);
        if(accountinfo == null) {
            accountinfo = new AccountInfo(accountanduser);
            mAccounts.put(accountanduser, accountinfo);
        }
        AuthorityInfo authorityinfo = (AuthorityInfo)accountinfo.authorities.get(s);
        if(authorityinfo == null) {
            if(j < 0) {
                j = mNextAuthorityId;
                mNextAuthorityId = 1 + mNextAuthorityId;
                flag = true;
            }
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", (new StringBuilder()).append("created a new AuthorityInfo for ").append(account).append(", user ").append(i).append(", provider ").append(s).toString());
            authorityinfo = new AuthorityInfo(account, i, s, j);
            accountinfo.authorities.put(s, authorityinfo);
            mAuthorities.put(j, authorityinfo);
            if(flag)
                writeAccountInfoLocked();
        }
        return authorityinfo;
    }

    private SyncStatusInfo getOrCreateSyncStatusLocked(int i) {
        SyncStatusInfo syncstatusinfo = (SyncStatusInfo)mSyncStatus.get(i);
        if(syncstatusinfo == null) {
            syncstatusinfo = new SyncStatusInfo(i);
            mSyncStatus.put(i, syncstatusinfo);
        }
        return syncstatusinfo;
    }

    public static SyncStorageEngine getSingleton() {
        if(sSyncStorageEngine == null)
            throw new IllegalStateException("not initialized");
        else
            return sSyncStorageEngine;
    }

    public static void init(Context context) {
        if(sSyncStorageEngine == null)
            sSyncStorageEngine = new SyncStorageEngine(context, Environment.getSecureDataDirectory());
    }

    private boolean maybeMigrateSettingsForRenamedAuthorities() {
        boolean flag = false;
        ArrayList arraylist = new ArrayList();
        int i = mAuthorities.size();
        int j = 0;
        while(j < i)  {
            AuthorityInfo authorityinfo1 = (AuthorityInfo)mAuthorities.valueAt(j);
            String s = (String)sAuthorityRenames.get(authorityinfo1.authority);
            if(s != null) {
                arraylist.add(authorityinfo1);
                if(authorityinfo1.enabled && getAuthorityLocked(authorityinfo1.account, authorityinfo1.userId, s, "cleanup") == null) {
                    getOrCreateAuthorityLocked(authorityinfo1.account, authorityinfo1.userId, s, -1, false).enabled = true;
                    flag = true;
                }
            }
            j++;
        }
        for(Iterator iterator = arraylist.iterator(); iterator.hasNext();) {
            AuthorityInfo authorityinfo = (AuthorityInfo)iterator.next();
            removeAuthorityLocked(authorityinfo.account, authorityinfo.userId, authorityinfo.authority, false);
            flag = true;
        }

        return flag;
    }

    public static SyncStorageEngine newTestInstance(Context context) {
        return new SyncStorageEngine(context, context.getFilesDir());
    }

    private AuthorityInfo parseAuthority(XmlPullParser xmlpullparser, int i) {
        AuthorityInfo authorityinfo;
        int j;
        authorityinfo = null;
        j = -1;
        int i1 = Integer.parseInt(xmlpullparser.getAttributeValue(null, "id"));
        j = i1;
_L1:
        if(j >= 0) {
            String s = xmlpullparser.getAttributeValue(null, "authority");
            String s1 = xmlpullparser.getAttributeValue(null, "enabled");
            String s2 = xmlpullparser.getAttributeValue(null, "syncable");
            String s3 = xmlpullparser.getAttributeValue(null, "account");
            String s4 = xmlpullparser.getAttributeValue(null, "type");
            String s5 = xmlpullparser.getAttributeValue(null, "user");
            int k;
            if(s5 == null)
                k = 0;
            else
                k = Integer.parseInt(s5);
            if(s4 == null) {
                s4 = "com.google";
                s2 = "unknown";
            }
            authorityinfo = (AuthorityInfo)mAuthorities.get(j);
            if(authorityinfo == null) {
                authorityinfo = getOrCreateAuthorityLocked(new Account(s3, s4), k, s, j, false);
                if(i > 0)
                    authorityinfo.periodicSyncs.clear();
            }
            if(authorityinfo != null) {
                NullPointerException nullpointerexception;
                boolean flag;
                NumberFormatException numberformatexception;
                if(s1 == null || Boolean.parseBoolean(s1))
                    flag = true;
                else
                    flag = false;
                authorityinfo.enabled = flag;
                if("unknown".equals(s2)) {
                    authorityinfo.syncable = -1;
                } else {
                    int l;
                    if(s2 == null || Boolean.parseBoolean(s2))
                        l = 1;
                    else
                        l = 0;
                    authorityinfo.syncable = l;
                }
            } else {
                Log.w("SyncManager", (new StringBuilder()).append("Failure adding authority: account=").append(s3).append(" auth=").append(s).append(" enabled=").append(s1).append(" syncable=").append(s2).toString());
            }
        }
        return authorityinfo;
        numberformatexception;
        Log.e("SyncManager", "error parsing the id of the authority", numberformatexception);
          goto _L1
        nullpointerexception;
        Log.e("SyncManager", "the id of the authority is null", nullpointerexception);
          goto _L1
    }

    private void parseExtra(XmlPullParser xmlpullparser, Pair pair) {
        Bundle bundle;
        String s;
        String s1;
        String s2;
        String s3;
        bundle = (Bundle)pair.first;
        s = xmlpullparser.getAttributeValue(null, "name");
        s1 = xmlpullparser.getAttributeValue(null, "type");
        s2 = xmlpullparser.getAttributeValue(null, "value1");
        s3 = xmlpullparser.getAttributeValue(null, "value2");
        try {
            if("long".equals(s1)) {
                bundle.putLong(s, Long.parseLong(s2));
                break MISSING_BLOCK_LABEL_263;
            }
            if("integer".equals(s1)) {
                bundle.putInt(s, Integer.parseInt(s2));
                break MISSING_BLOCK_LABEL_263;
            }
        }
        catch(NumberFormatException numberformatexception) {
            Log.e("SyncManager", "error parsing bundle value", numberformatexception);
            break MISSING_BLOCK_LABEL_263;
        }
        catch(NullPointerException nullpointerexception) {
            Log.e("SyncManager", "error parsing bundle value", nullpointerexception);
            break MISSING_BLOCK_LABEL_263;
        }
        if("double".equals(s1)) {
            bundle.putDouble(s, Double.parseDouble(s2));
            break MISSING_BLOCK_LABEL_263;
        }
        if("float".equals(s1))
            bundle.putFloat(s, Float.parseFloat(s2));
        else
        if("boolean".equals(s1))
            bundle.putBoolean(s, Boolean.parseBoolean(s2));
        else
        if("string".equals(s1))
            bundle.putString(s, s2);
        else
        if("account".equals(s1))
            bundle.putParcelable(s, new Account(s2, s3));
    }

    private void parseListenForTickles(XmlPullParser xmlpullparser) {
        String s;
        int i;
        s = xmlpullparser.getAttributeValue(null, "user");
        i = 0;
        int j = Integer.parseInt(s);
        i = j;
_L1:
        String s1 = xmlpullparser.getAttributeValue(null, "enabled");
        NullPointerException nullpointerexception;
        boolean flag;
        NumberFormatException numberformatexception;
        if(s1 == null || Boolean.parseBoolean(s1))
            flag = true;
        else
            flag = false;
        mMasterSyncAutomatically.put(i, Boolean.valueOf(flag));
        return;
        numberformatexception;
        Log.e("SyncManager", "error parsing the user for listen-for-tickles", numberformatexception);
          goto _L1
        nullpointerexception;
        Log.e("SyncManager", "the user in listen-for-tickles is null", nullpointerexception);
          goto _L1
    }

    private Pair parsePeriodicSync(XmlPullParser xmlpullparser, AuthorityInfo authorityinfo) {
        Pair pair;
        Bundle bundle;
        String s;
        pair = null;
        bundle = new Bundle();
        s = xmlpullparser.getAttributeValue(null, "period");
        long l = Long.parseLong(s);
        pair = Pair.create(bundle, Long.valueOf(l));
        authorityinfo.periodicSyncs.add(pair);
_L2:
        return pair;
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.e("SyncManager", "error parsing the period of a periodic sync", numberformatexception);
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        Log.e("SyncManager", "the period of a periodic sync is null", nullpointerexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void readAccountInfoLocked() {
        int i;
        FileInputStream fileinputstream;
        i = -1;
        fileinputstream = null;
        XmlPullParser xmlpullparser;
        fileinputstream = mAccountInfoFile.openRead();
        xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(fileinputstream, null);
        for(int j = xmlpullparser.getEventType(); j != 2; j = xmlpullparser.next());
        if(!"accounts".equals(xmlpullparser.getName())) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        s = xmlpullparser.getAttributeValue(null, "listen-for-tickles");
        s1 = xmlpullparser.getAttributeValue(null, "version");
        if(s1 != null) goto _L4; else goto _L3
_L3:
        int k = 0;
_L16:
        String s2 = xmlpullparser.getAttributeValue(null, "nextAuthorityId");
        if(s2 != null) goto _L6; else goto _L5
_L5:
        int i2 = 0;
_L17:
        String s3;
        SparseArray sparsearray;
        boolean flag;
        int l;
        AuthorityInfo authorityinfo;
        Pair pair;
        int i1;
        String s4;
        int k1;
        try {
            mNextAuthorityId = Math.max(mNextAuthorityId, i2);
        }
        catch(NumberFormatException numberformatexception1) { }
        s3 = xmlpullparser.getAttributeValue(null, "offsetInSeconds");
        if(s3 != null) goto _L8; else goto _L7
_L7:
        k1 = 0;
_L18:
        mSyncRandomOffset = k1;
_L19:
        if(mSyncRandomOffset == 0)
            mSyncRandomOffset = (new Random(System.currentTimeMillis())).nextInt(0x15180);
        sparsearray = mMasterSyncAutomatically;
        if(s != null && !Boolean.parseBoolean(s))
            flag = false;
        else
            flag = true;
        sparsearray.put(0, Boolean.valueOf(flag));
        l = xmlpullparser.next();
        authorityinfo = null;
        pair = null;
_L15:
        if(l != 2) goto _L10; else goto _L9
_L9:
        s4 = xmlpullparser.getName();
        if(xmlpullparser.getDepth() != 2) goto _L12; else goto _L11
_L11:
        if(!"authority".equals(s4)) goto _L14; else goto _L13
_L13:
        authorityinfo = parseAuthority(xmlpullparser, k);
        pair = null;
        if(authorityinfo.ident > i)
            i = authorityinfo.ident;
_L10:
        i1 = xmlpullparser.next();
        l = i1;
        if(l != 1) goto _L15; else goto _L2
_L2:
        mNextAuthorityId = Math.max(i + 1, mNextAuthorityId);
        Exception exception;
        IOException ioexception;
        IOException ioexception1;
        IOException ioexception2;
        XmlPullParserException xmlpullparserexception;
        NumberFormatException numberformatexception;
        NumberFormatException numberformatexception2;
        int j1;
        int l1;
        int j2;
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception3) { }
        maybeMigrateSettingsForRenamedAuthorities();
        return;
_L4:
        j2 = Integer.parseInt(s1);
        k = j2;
          goto _L16
        numberformatexception;
        k = 0;
          goto _L16
_L6:
        l1 = Integer.parseInt(s2);
        i2 = l1;
          goto _L17
_L8:
        j1 = Integer.parseInt(s3);
        k1 = j1;
          goto _L18
        numberformatexception2;
        mSyncRandomOffset = 0;
          goto _L19
        xmlpullparserexception;
        Log.w("SyncManager", "Error reading accounts", xmlpullparserexception);
        mNextAuthorityId = Math.max(i + 1, mNextAuthorityId);
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception2) { }
        break MISSING_BLOCK_LABEL_348;
_L14:
        if(!"listenForTickles".equals(s4)) goto _L10; else goto _L20
_L20:
        parseListenForTickles(xmlpullparser);
          goto _L10
        ioexception1;
        if(fileinputstream != null)
            break MISSING_BLOCK_LABEL_620;
        Log.i("SyncManager", "No initial accounts");
_L21:
        mNextAuthorityId = Math.max(i + 1, mNextAuthorityId);
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_348;
        fileinputstream.close();
        break MISSING_BLOCK_LABEL_348;
_L12:
        if(xmlpullparser.getDepth() == 3) {
            if("periodicSync".equals(s4) && authorityinfo != null)
                pair = parsePeriodicSync(xmlpullparser, authorityinfo);
        } else
        if(xmlpullparser.getDepth() == 4 && pair != null && "extra".equals(s4))
            parseExtra(xmlpullparser, pair);
          goto _L10
        exception;
        mNextAuthorityId = Math.max(i + 1, mNextAuthorityId);
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception) { }
        throw exception;
        Log.w("SyncManager", "Error reading accounts", ioexception1);
          goto _L21
    }

    private void readAndDeleteLegacyAccountInfoLocked() {
        File file = mContext.getDatabasePath("syncmanager.db");
        if(file.exists()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        SQLiteDatabase sqlitedatabase;
        s = file.getPath();
        sqlitedatabase = null;
        SQLiteDatabase sqlitedatabase1 = SQLiteDatabase.openDatabase(s, null, 1);
        sqlitedatabase = sqlitedatabase1;
_L4:
        if(sqlitedatabase != null) {
            boolean flag;
            SQLiteQueryBuilder sqlitequerybuilder;
            HashMap hashmap;
            Cursor cursor;
            if(sqlitedatabase.getVersion() >= 11)
                flag = true;
            else
                flag = false;
            sqlitequerybuilder = new SQLiteQueryBuilder();
            sqlitequerybuilder.setTables("stats, status");
            hashmap = new HashMap();
            hashmap.put("_id", "status._id as _id");
            hashmap.put("account", "stats.account as account");
            if(flag)
                hashmap.put("account_type", "stats.account_type as account_type");
            hashmap.put("authority", "stats.authority as authority");
            hashmap.put("totalElapsedTime", "totalElapsedTime");
            hashmap.put("numSyncs", "numSyncs");
            hashmap.put("numSourceLocal", "numSourceLocal");
            hashmap.put("numSourcePoll", "numSourcePoll");
            hashmap.put("numSourceServer", "numSourceServer");
            hashmap.put("numSourceUser", "numSourceUser");
            hashmap.put("lastSuccessSource", "lastSuccessSource");
            hashmap.put("lastSuccessTime", "lastSuccessTime");
            hashmap.put("lastFailureSource", "lastFailureSource");
            hashmap.put("lastFailureTime", "lastFailureTime");
            hashmap.put("lastFailureMesg", "lastFailureMesg");
            hashmap.put("pending", "pending");
            sqlitequerybuilder.setProjectionMap(hashmap);
            sqlitequerybuilder.appendWhere("stats._id = status.stats_id");
            cursor = sqlitequerybuilder.query(sqlitedatabase, null, null, null, null, null, null);
            do {
                if(!cursor.moveToNext())
                    break;
                String s4 = cursor.getString(cursor.getColumnIndex("account"));
                String s5;
                String s6;
                AuthorityInfo authorityinfo1;
                int j;
                boolean flag3;
                SyncStatusInfo syncstatusinfo;
                long l;
                int k;
                int i1;
                int j1;
                int k1;
                int l1;
                int i2;
                long l2;
                int j2;
                long l3;
                String s7;
                boolean flag4;
                if(flag)
                    s5 = cursor.getString(cursor.getColumnIndex("account_type"));
                else
                    s5 = null;
                if(s5 == null)
                    s5 = "com.google";
                s6 = cursor.getString(cursor.getColumnIndex("authority"));
                authorityinfo1 = getOrCreateAuthorityLocked(new Account(s4, s5), 0, s6, -1, false);
                if(authorityinfo1 == null)
                    continue;
                j = mSyncStatus.size();
                flag3 = false;
                syncstatusinfo = null;
                do {
                    if(j <= 0)
                        break;
                    j--;
                    syncstatusinfo = (SyncStatusInfo)mSyncStatus.valueAt(j);
                    if(syncstatusinfo.authorityId != authorityinfo1.ident)
                        continue;
                    flag3 = true;
                    break;
                } while(true);
                if(!flag3) {
                    int k2 = authorityinfo1.ident;
                    syncstatusinfo = new SyncStatusInfo(k2);
                    mSyncStatus.put(authorityinfo1.ident, syncstatusinfo);
                }
                l = getLongColumn(cursor, "totalElapsedTime");
                syncstatusinfo.totalElapsedTime = l;
                k = getIntColumn(cursor, "numSyncs");
                syncstatusinfo.numSyncs = k;
                i1 = getIntColumn(cursor, "numSourceLocal");
                syncstatusinfo.numSourceLocal = i1;
                j1 = getIntColumn(cursor, "numSourcePoll");
                syncstatusinfo.numSourcePoll = j1;
                k1 = getIntColumn(cursor, "numSourceServer");
                syncstatusinfo.numSourceServer = k1;
                l1 = getIntColumn(cursor, "numSourceUser");
                syncstatusinfo.numSourceUser = l1;
                syncstatusinfo.numSourcePeriodic = 0;
                i2 = getIntColumn(cursor, "lastSuccessSource");
                syncstatusinfo.lastSuccessSource = i2;
                l2 = getLongColumn(cursor, "lastSuccessTime");
                syncstatusinfo.lastSuccessTime = l2;
                j2 = getIntColumn(cursor, "lastFailureSource");
                syncstatusinfo.lastFailureSource = j2;
                l3 = getLongColumn(cursor, "lastFailureTime");
                syncstatusinfo.lastFailureTime = l3;
                s7 = cursor.getString(cursor.getColumnIndex("lastFailureMesg"));
                syncstatusinfo.lastFailureMesg = s7;
                if(getIntColumn(cursor, "pending") != 0)
                    flag4 = true;
                else
                    flag4 = false;
                syncstatusinfo.pending = flag4;
            } while(true);
            cursor.close();
            SQLiteQueryBuilder sqlitequerybuilder1 = new SQLiteQueryBuilder();
            sqlitequerybuilder1.setTables("settings");
            Cursor cursor1;
label0:
            do {
                String s1;
                String s2;
label1:
                do {
                    for(cursor1 = sqlitequerybuilder1.query(sqlitedatabase, null, null, null, null, null, null); cursor1.moveToNext();) {
                        s1 = cursor1.getString(cursor1.getColumnIndex("name"));
                        s2 = cursor1.getString(cursor1.getColumnIndex("value"));
                        if(s1 != null) {
                            if(!s1.equals("listen_for_tickles"))
                                continue label1;
                            boolean flag2;
                            if(s2 == null || Boolean.parseBoolean(s2))
                                flag2 = true;
                            else
                                flag2 = false;
                            setMasterSyncAutomatically(flag2, 0);
                        }
                    }

                    break label0;
                } while(!s1.startsWith("sync_provider_"));
                String s3 = s1.substring("sync_provider_".length(), s1.length());
                int i = mAuthorities.size();
                while(i > 0)  {
                    i--;
                    AuthorityInfo authorityinfo = (AuthorityInfo)mAuthorities.valueAt(i);
                    if(authorityinfo.authority.equals(s3)) {
                        boolean flag1;
                        if(s2 == null || Boolean.parseBoolean(s2))
                            flag1 = true;
                        else
                            flag1 = false;
                        authorityinfo.enabled = flag1;
                        authorityinfo.syncable = 1;
                    }
                }
            } while(true);
            cursor1.close();
            sqlitedatabase.close();
            (new File(s)).delete();
        }
        if(true) goto _L1; else goto _L3
_L3:
        SQLiteException sqliteexception;
        sqliteexception;
          goto _L4
    }

    private void readPendingOperationsLocked() {
        Parcel parcel;
        int i;
        byte abyte0[] = mPendingFile.readFully();
        parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        i = parcel.dataSize();
_L14:
        if(parcel.dataPosition() >= i) goto _L2; else goto _L1
_L1:
        int j = parcel.readInt();
        if(j == 2 || j == 1) goto _L4; else goto _L3
_L3:
        Log.w("SyncManager", (new StringBuilder()).append("Unknown pending operation version ").append(j).append("; dropping all ops").toString());
          goto _L2
_L4:
        int k;
        int l;
        byte abyte1[];
        k = parcel.readInt();
        l = parcel.readInt();
        abyte1 = parcel.createByteArray();
        if(j != 2) goto _L6; else goto _L5
_L5:
        if(parcel.readInt() == 0) goto _L8; else goto _L7
_L7:
        boolean flag = true;
_L11:
        AuthorityInfo authorityinfo;
        authorityinfo = (AuthorityInfo)mAuthorities.get(k);
        if(authorityinfo == null)
            continue; /* Loop/switch isn't completed */
        if(abyte1 == null) goto _L10; else goto _L9
_L9:
        Bundle bundle = unflattenBundle(abyte1);
_L12:
        PendingOperation pendingoperation = new PendingOperation(authorityinfo.account, authorityinfo.userId, l, authorityinfo.authority, bundle, flag);
        pendingoperation.authorityId = k;
        pendingoperation.flatExtras = abyte1;
        mPendingOperations.add(pendingoperation);
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        Log.i("SyncManager", "No initial pending operations");
          goto _L2
_L8:
        flag = false;
          goto _L11
_L6:
        flag = false;
          goto _L11
_L10:
        bundle = new Bundle();
          goto _L12
_L2:
        return;
        if(true) goto _L14; else goto _L13
_L13:
    }

    private void readStatisticsLocked() {
label0:
        {
            byte abyte0[] = mStatisticsFile.readFully();
            Parcel parcel = Parcel.obtain();
            parcel.unmarshall(abyte0, 0, abyte0.length);
            parcel.setDataPosition(0);
            int i = 0;
            int j;
            do {
                j = parcel.readInt();
                if(j == 0)
                    break label0;
                if(j != 101 && j != 100)
                    break;
                int k = parcel.readInt();
                if(j == 100)
                    k = 14245 + (k - 2009);
                DayStats daystats = new DayStats(k);
                daystats.successCount = parcel.readInt();
                daystats.successTime = parcel.readLong();
                daystats.failureCount = parcel.readInt();
                daystats.failureTime = parcel.readLong();
                if(i < mDayStats.length) {
                    mDayStats[i] = daystats;
                    i++;
                }
            } while(true);
            Log.w("SyncManager", (new StringBuilder()).append("Unknown stats token: ").append(j).toString());
        }
_L1:
        return;
        IOException ioexception;
        ioexception;
        Log.i("SyncManager", "No initial statistics");
          goto _L1
    }

    private void readStatusLocked() {
        Parcel parcel;
        byte abyte0[] = mStatusFile.readFully();
        parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
_L5:
        int i = parcel.readInt();
        if(i == 0) goto _L2; else goto _L1
_L1:
        if(i != 100) goto _L4; else goto _L3
_L3:
        IOException ioexception;
        SyncStatusInfo syncstatusinfo = new SyncStatusInfo(parcel);
        if(mAuthorities.indexOfKey(syncstatusinfo.authorityId) >= 0) {
            syncstatusinfo.pending = false;
            mSyncStatus.put(syncstatusinfo.authorityId, syncstatusinfo);
        }
          goto _L5
_L2:
        return;
_L4:
        try {
            Log.w("SyncManager", (new StringBuilder()).append("Unknown status token: ").append(i).toString());
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception) {
            Log.i("SyncManager", "No initial status");
        }
        if(true) goto _L2; else goto _L6
_L6:
    }

    private void removeAuthorityLocked(Account account, int i, String s, boolean flag) {
        AccountInfo accountinfo = (AccountInfo)mAccounts.get(new AccountAndUser(account, i));
        if(accountinfo != null) {
            AuthorityInfo authorityinfo = (AuthorityInfo)accountinfo.authorities.remove(s);
            if(authorityinfo != null) {
                mAuthorities.remove(authorityinfo.ident);
                if(flag)
                    writeAccountInfoLocked();
            }
        }
    }

    private void reportChange(int i) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        int j = mChangeListeners.beginBroadcast();
        int k;
        ArrayList arraylist;
        k = j;
        arraylist = null;
_L4:
        if(k <= 0) goto _L2; else goto _L1
_L1:
        k--;
        if((i & ((Integer)mChangeListeners.getBroadcastCookie(k)).intValue()) == 0) goto _L4; else goto _L3
_L3:
        if(arraylist != null) goto _L6; else goto _L5
_L5:
        ArrayList arraylist1 = new ArrayList(k);
_L9:
        arraylist1.add(mChangeListeners.getBroadcastItem(k));
        arraylist = arraylist1;
          goto _L4
_L2:
        mChangeListeners.finishBroadcast();
        sparsearray;
        JVM INSTR monitorexit ;
          goto _L7
        Exception exception;
        exception;
_L8:
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception;
_L7:
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("reportChange ").append(i).append(" to: ").append(arraylist).toString());
        if(arraylist != null) {
            for(int l = arraylist.size(); l > 0;) {
                l--;
                try {
                    ((ISyncStatusObserver)arraylist.get(l)).onStatusChanged(i);
                }
                catch(RemoteException remoteexception) { }
            }

        }
        return;
        exception;
        arraylist;
        if(true) goto _L8; else goto _L6
_L6:
        arraylist1 = arraylist;
          goto _L9
    }

    private void requestSync(Account account, int i, String s, Bundle bundle) {
        if(Process.myUid() == 1000 && mSyncRequestListener != null)
            mSyncRequestListener.onSyncRequest(account, i, s, bundle);
        else
            ContentResolver.requestSync(account, s, bundle);
    }

    private static Bundle unflattenBundle(byte abyte0[]) {
        Parcel parcel = Parcel.obtain();
        Bundle bundle1;
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        bundle1 = parcel.readBundle();
        Bundle bundle = bundle1;
_L2:
        parcel.recycle();
        return bundle;
        RuntimeException runtimeexception;
        runtimeexception;
        bundle = new Bundle();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    private void updateOrRemovePeriodicSync(Account account, int i, String s, Bundle bundle, long l, boolean flag) {
        if(l <= 0L)
            l = 0L;
        if(bundle == null)
            bundle = new Bundle();
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("addOrRemovePeriodicSync: ").append(account).append(", user ").append(i).append(", provider ").append(s).append(" -> period ").append(l).append(", extras ").append(bundle).toString());
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        AuthorityInfo authorityinfo = getOrCreateAuthorityLocked(account, i, s, -1, false);
        if(!flag) goto _L2; else goto _L1
_L1:
        boolean flag2;
        int k;
        int i1;
        flag2 = false;
        k = 0;
        i1 = authorityinfo.periodicSyncs.size();
_L10:
        if(k >= i1) goto _L4; else goto _L3
_L3:
        Pair pair = (Pair)authorityinfo.periodicSyncs.get(k);
        if(!equals((Bundle)pair.first, bundle)) goto _L6; else goto _L5
_L5:
        long l1 = ((Long)pair.second).longValue();
        if(l1 != l) goto _L8; else goto _L7
_L7:
        writeAccountInfoLocked();
        writeStatusLocked();
        sparsearray;
        JVM INSTR monitorexit ;
_L9:
        return;
_L8:
        ArrayList arraylist1 = authorityinfo.periodicSyncs;
        Long long2 = Long.valueOf(l);
        arraylist1.set(k, Pair.create(bundle, long2));
        flag2 = true;
_L4:
        if(!flag2) {
            ArrayList arraylist = authorityinfo.periodicSyncs;
            Long long1 = Long.valueOf(l);
            arraylist.add(Pair.create(bundle, long1));
            getOrCreateSyncStatusLocked(authorityinfo.ident).setPeriodicSyncTime(-1 + authorityinfo.periodicSyncs.size(), 0L);
        }
_L14:
        writeAccountInfoLocked();
        writeStatusLocked();
        sparsearray;
        JVM INSTR monitorexit ;
        reportChange(1);
          goto _L9
_L6:
        k++;
          goto _L10
_L2:
        SyncStatusInfo syncstatusinfo;
        boolean flag1;
        Iterator iterator;
        int j;
        syncstatusinfo = (SyncStatusInfo)mSyncStatus.get(authorityinfo.ident);
        flag1 = false;
        iterator = authorityinfo.periodicSyncs.iterator();
        j = 0;
_L12:
        do {
            if(!iterator.hasNext())
                continue; /* Loop/switch isn't completed */
            if(!equals((Bundle)((Pair)iterator.next()).first, bundle))
                break MISSING_BLOCK_LABEL_440;
            iterator.remove();
            flag1 = true;
            if(syncstatusinfo != null)
                syncstatusinfo.removePeriodicSyncTime(j);
        } while(true);
        Exception exception;
        exception;
        writeAccountInfoLocked();
        writeStatusLocked();
        throw exception;
        Exception exception1;
        exception1;
        throw exception1;
        j++;
        if(true) goto _L12; else goto _L11
_L11:
        if(flag1) goto _L14; else goto _L13
_L13:
        writeAccountInfoLocked();
        writeStatusLocked();
        sparsearray;
        JVM INSTR monitorexit ;
          goto _L9
    }

    private void writeAccountInfoLocked() {
        FileOutputStream fileoutputstream = null;
        FastXmlSerializer fastxmlserializer;
        int k;
        int l;
        fileoutputstream = mAccountInfoFile.startWrite();
        fastxmlserializer = new FastXmlSerializer();
        fastxmlserializer.setOutput(fileoutputstream, "utf-8");
        fastxmlserializer.startDocument(null, Boolean.valueOf(true));
        fastxmlserializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        fastxmlserializer.startTag(null, "accounts");
        fastxmlserializer.attribute(null, "version", Integer.toString(2));
        fastxmlserializer.attribute(null, "nextAuthorityId", Integer.toString(mNextAuthorityId));
        fastxmlserializer.attribute(null, "offsetInSeconds", Integer.toString(mSyncRandomOffset));
        int i = mMasterSyncAutomatically.size();
        for(int j = 0; j < i; j++) {
            int i1 = mMasterSyncAutomatically.keyAt(j);
            Boolean boolean1 = (Boolean)mMasterSyncAutomatically.valueAt(j);
            fastxmlserializer.startTag(null, "listenForTickles");
            fastxmlserializer.attribute(null, "user", Integer.toString(i1));
            fastxmlserializer.attribute(null, "enabled", Boolean.toString(boolean1.booleanValue()));
            fastxmlserializer.endTag(null, "listenForTickles");
        }

        k = mAuthorities.size();
        l = 0;
_L15:
        if(l >= k) goto _L2; else goto _L1
_L1:
        AuthorityInfo authorityinfo;
        authorityinfo = (AuthorityInfo)mAuthorities.valueAt(l);
        fastxmlserializer.startTag(null, "authority");
        fastxmlserializer.attribute(null, "id", Integer.toString(authorityinfo.ident));
        fastxmlserializer.attribute(null, "account", authorityinfo.account.name);
        fastxmlserializer.attribute(null, "user", Integer.toString(authorityinfo.userId));
        fastxmlserializer.attribute(null, "type", authorityinfo.account.type);
        fastxmlserializer.attribute(null, "authority", authorityinfo.authority);
        fastxmlserializer.attribute(null, "enabled", Boolean.toString(authorityinfo.enabled));
        if(authorityinfo.syncable >= 0) goto _L4; else goto _L3
_L3:
        fastxmlserializer.attribute(null, "syncable", "unknown");
_L12:
        Iterator iterator = authorityinfo.periodicSyncs.iterator();
_L14:
        if(!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        Bundle bundle;
        Iterator iterator1;
        Pair pair = (Pair)iterator.next();
        fastxmlserializer.startTag(null, "periodicSync");
        fastxmlserializer.attribute(null, "period", Long.toString(((Long)pair.second).longValue()));
        bundle = (Bundle)pair.first;
        iterator1 = bundle.keySet().iterator();
_L11:
        if(!iterator1.hasNext()) goto _L8; else goto _L7
_L7:
        Object obj;
        String s = (String)iterator1.next();
        fastxmlserializer.startTag(null, "extra");
        fastxmlserializer.attribute(null, "name", s);
        obj = bundle.get(s);
        if(!(obj instanceof Long)) goto _L10; else goto _L9
_L9:
        fastxmlserializer.attribute(null, "type", "long");
        fastxmlserializer.attribute(null, "value1", obj.toString());
_L13:
        fastxmlserializer.endTag(null, "extra");
          goto _L11
        IOException ioexception;
        ioexception;
        Log.w("SyncManager", "Error writing accounts", ioexception);
        if(fileoutputstream != null)
            mAccountInfoFile.failWrite(fileoutputstream);
_L16:
        return;
_L4:
        boolean flag;
        if(authorityinfo.syncable == 0)
            break MISSING_BLOCK_LABEL_1010;
        flag = true;
_L17:
        fastxmlserializer.attribute(null, "syncable", Boolean.toString(flag));
          goto _L12
_L10:
        if(obj instanceof Integer) {
            fastxmlserializer.attribute(null, "type", "integer");
            fastxmlserializer.attribute(null, "value1", obj.toString());
        } else
        if(obj instanceof Boolean) {
            fastxmlserializer.attribute(null, "type", "boolean");
            fastxmlserializer.attribute(null, "value1", obj.toString());
        } else
        if(obj instanceof Float) {
            fastxmlserializer.attribute(null, "type", "float");
            fastxmlserializer.attribute(null, "value1", obj.toString());
        } else
        if(obj instanceof Double) {
            fastxmlserializer.attribute(null, "type", "double");
            fastxmlserializer.attribute(null, "value1", obj.toString());
        } else
        if(obj instanceof String) {
            fastxmlserializer.attribute(null, "type", "string");
            fastxmlserializer.attribute(null, "value1", obj.toString());
        } else
        if(obj instanceof Account) {
            fastxmlserializer.attribute(null, "type", "account");
            fastxmlserializer.attribute(null, "value1", ((Account)obj).name);
            fastxmlserializer.attribute(null, "value2", ((Account)obj).type);
        }
          goto _L13
_L8:
        fastxmlserializer.endTag(null, "periodicSync");
          goto _L14
_L6:
        fastxmlserializer.endTag(null, "authority");
        l++;
          goto _L15
_L2:
        fastxmlserializer.endTag(null, "accounts");
        fastxmlserializer.endDocument();
        mAccountInfoFile.finishWrite(fileoutputstream);
          goto _L16
        flag = false;
          goto _L17
    }

    private void writePendingOperationLocked(PendingOperation pendingoperation, Parcel parcel) {
        parcel.writeInt(2);
        parcel.writeInt(pendingoperation.authorityId);
        parcel.writeInt(pendingoperation.syncSource);
        if(pendingoperation.flatExtras == null && pendingoperation.extras != null)
            pendingoperation.flatExtras = flattenBundle(pendingoperation.extras);
        parcel.writeByteArray(pendingoperation.flatExtras);
        int i;
        if(pendingoperation.expedited)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
    }

    private void writePendingOperationsLocked() {
        int i;
        FileOutputStream fileoutputstream;
        i = mPendingOperations.size();
        fileoutputstream = null;
        if(i != 0)
            break MISSING_BLOCK_LABEL_24;
        mPendingFile.truncate();
        break MISSING_BLOCK_LABEL_118;
        fileoutputstream = mPendingFile.startWrite();
        Parcel parcel = Parcel.obtain();
        for(int j = 0; j < i; j++)
            writePendingOperationLocked((PendingOperation)mPendingOperations.get(j), parcel);

        fileoutputstream.write(parcel.marshall());
        parcel.recycle();
        mPendingFile.finishWrite(fileoutputstream);
        break MISSING_BLOCK_LABEL_118;
        IOException ioexception;
        ioexception;
        Log.w("SyncManager", "Error writing pending operations", ioexception);
        if(fileoutputstream != null)
            mPendingFile.failWrite(fileoutputstream);
    }

    private void writeStatisticsLocked() {
        FileOutputStream fileoutputstream;
        removeMessages(2);
        fileoutputstream = null;
        Parcel parcel;
        int i;
        int j;
        fileoutputstream = mStatisticsFile.startWrite();
        parcel = Parcel.obtain();
        i = mDayStats.length;
        j = 0;
_L4:
        if(j >= i) goto _L2; else goto _L1
_L1:
        DayStats daystats = mDayStats[j];
        if(daystats != null) goto _L3; else goto _L2
_L2:
        parcel.writeInt(0);
        fileoutputstream.write(parcel.marshall());
        parcel.recycle();
        mStatisticsFile.finishWrite(fileoutputstream);
        break MISSING_BLOCK_LABEL_168;
_L3:
        parcel.writeInt(101);
        parcel.writeInt(daystats.day);
        parcel.writeInt(daystats.successCount);
        parcel.writeLong(daystats.successTime);
        parcel.writeInt(daystats.failureCount);
        parcel.writeLong(daystats.failureTime);
        j++;
          goto _L4
        IOException ioexception;
        ioexception;
        Log.w("SyncManager", "Error writing stats", ioexception);
        if(fileoutputstream != null)
            mStatisticsFile.failWrite(fileoutputstream);
    }

    private void writeStatusLocked() {
        FileOutputStream fileoutputstream;
        removeMessages(1);
        fileoutputstream = null;
        fileoutputstream = mStatusFile.startWrite();
        Parcel parcel = Parcel.obtain();
        int i = mSyncStatus.size();
        for(int j = 0; j < i; j++) {
            SyncStatusInfo syncstatusinfo = (SyncStatusInfo)mSyncStatus.valueAt(j);
            parcel.writeInt(100);
            syncstatusinfo.writeToParcel(parcel, 0);
        }

        parcel.writeInt(0);
        fileoutputstream.write(parcel.marshall());
        parcel.recycle();
        mStatusFile.finishWrite(fileoutputstream);
_L1:
        return;
        IOException ioexception;
        ioexception;
        Log.w("SyncManager", "Error writing status", ioexception);
        if(fileoutputstream != null)
            mStatusFile.failWrite(fileoutputstream);
          goto _L1
    }

    public SyncInfo addActiveSync(SyncManager.ActiveSyncContext activesynccontext) {
        SyncInfo syncinfo;
        synchronized(mAuthorities) {
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", (new StringBuilder()).append("setActiveSync: account=").append(activesynccontext.mSyncOperation.account).append(" auth=").append(activesynccontext.mSyncOperation.authority).append(" src=").append(activesynccontext.mSyncOperation.syncSource).append(" extras=").append(activesynccontext.mSyncOperation.extras).toString());
            AuthorityInfo authorityinfo = getOrCreateAuthorityLocked(activesynccontext.mSyncOperation.account, activesynccontext.mSyncOperation.userId, activesynccontext.mSyncOperation.authority, -1, true);
            syncinfo = new SyncInfo(authorityinfo.ident, authorityinfo.account, authorityinfo.authority, activesynccontext.mStartTime);
            getCurrentSyncs(authorityinfo.userId).add(syncinfo);
        }
        reportActiveChange();
        return syncinfo;
        exception;
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void addPeriodicSync(Account account, int i, String s, Bundle bundle, long l) {
        updateOrRemovePeriodicSync(account, i, s, bundle, l, true);
    }

    public void addStatusChangeListener(int i, ISyncStatusObserver isyncstatusobserver) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        mChangeListeners.register(isyncstatusobserver, Integer.valueOf(i));
        return;
    }

    public void clearAllBackoffs(SyncQueue syncqueue) {
        boolean flag = false;
        synchronized(mAuthorities) {
            for(Iterator iterator = mAccounts.values().iterator(); iterator.hasNext();) {
                AccountInfo accountinfo = (AccountInfo)iterator.next();
                Iterator iterator1 = accountinfo.authorities.values().iterator();
                while(iterator1.hasNext())  {
                    AuthorityInfo authorityinfo = (AuthorityInfo)iterator1.next();
                    if(authorityinfo.backoffTime != -1L || authorityinfo.backoffDelay != -1L) {
                        if(Log.isLoggable("SyncManager", 2))
                            Log.v("SyncManager", (new StringBuilder()).append("clearAllBackoffs: authority:").append(authorityinfo.authority).append(" account:").append(accountinfo.accountAndUser.account.name).append(" user:").append(accountinfo.accountAndUser.userId).append(" backoffTime was: ").append(authorityinfo.backoffTime).append(" backoffDelay was: ").append(authorityinfo.backoffDelay).toString());
                        authorityinfo.backoffTime = -1L;
                        authorityinfo.backoffDelay = -1L;
                        syncqueue.onBackoffChanged(accountinfo.accountAndUser.account, accountinfo.accountAndUser.userId, authorityinfo.authority, 0L);
                        flag = true;
                    }
                }
            }

        }
        if(flag)
            reportChange(1);
        return;
        exception;
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clearAndReadState() {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        mAuthorities.clear();
        mAccounts.clear();
        mPendingOperations.clear();
        mSyncStatus.clear();
        mSyncHistory.clear();
        readAccountInfoLocked();
        readStatusLocked();
        readPendingOperationsLocked();
        readStatisticsLocked();
        readAndDeleteLegacyAccountInfoLocked();
        writeAccountInfoLocked();
        writeStatusLocked();
        writePendingOperationsLocked();
        writeStatisticsLocked();
        return;
    }

    public boolean deleteFromPending(PendingOperation pendingoperation) {
        boolean flag = false;
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("deleteFromPending: account=").append(pendingoperation.account).append(" user=").append(pendingoperation.userId).append(" auth=").append(pendingoperation.authority).append(" src=").append(pendingoperation.syncSource).append(" extras=").append(pendingoperation.extras).toString());
        if(!mPendingOperations.remove(pendingoperation)) goto _L2; else goto _L1
_L1:
        if(mPendingOperations.size() != 0 && mNumPendingFinished < 4) goto _L4; else goto _L3
_L3:
        writePendingOperationsLocked();
        mNumPendingFinished = 0;
_L9:
        AuthorityInfo authorityinfo;
        int i;
        boolean flag1;
        int j;
        authorityinfo = getAuthorityLocked(pendingoperation.account, pendingoperation.userId, pendingoperation.authority, "deleteFromPending");
        if(authorityinfo == null)
            break MISSING_BLOCK_LABEL_354;
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("removing - ").append(authorityinfo).toString());
        i = mPendingOperations.size();
        flag1 = false;
        j = 0;
_L10:
        if(j >= i) goto _L6; else goto _L5
_L5:
        PendingOperation pendingoperation1 = (PendingOperation)mPendingOperations.get(j);
        if(!pendingoperation1.account.equals(pendingoperation.account) || !pendingoperation1.authority.equals(pendingoperation.authority) || pendingoperation1.userId != pendingoperation.userId) goto _L8; else goto _L7
_L7:
        flag1 = true;
_L6:
        if(!flag1) {
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", "no more pending!");
            getOrCreateSyncStatusLocked(authorityinfo.ident).pending = false;
        }
        break MISSING_BLOCK_LABEL_354;
_L2:
        reportChange(2);
        return flag;
_L4:
        mNumPendingFinished = 1 + mNumPendingFinished;
          goto _L9
        Exception exception;
        exception;
        throw exception;
_L8:
        j++;
          goto _L10
        flag = true;
          goto _L2
    }

    public void doDatabaseCleanup(Account aaccount[], int i) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        SparseArray sparsearray1;
        Iterator iterator;
        if(Log.isLoggable("SyncManager", 2))
            Log.w("SyncManager", "Updating for new accounts...");
        sparsearray1 = new SparseArray();
        iterator = mAccounts.values().iterator();
_L1:
        AccountInfo accountinfo;
        do {
            if(!iterator.hasNext())
                break MISSING_BLOCK_LABEL_205;
            accountinfo = (AccountInfo)iterator.next();
        } while(ArrayUtils.contains(aaccount, accountinfo.accountAndUser.account) || accountinfo.accountAndUser.userId != i);
        if(Log.isLoggable("SyncManager", 2))
            Log.w("SyncManager", (new StringBuilder()).append("Account removed: ").append(accountinfo.accountAndUser).toString());
        AuthorityInfo authorityinfo;
        for(Iterator iterator1 = accountinfo.authorities.values().iterator(); iterator1.hasNext(); sparsearray1.put(authorityinfo.ident, authorityinfo))
            authorityinfo = (AuthorityInfo)iterator1.next();

        break MISSING_BLOCK_LABEL_195;
        Exception exception;
        exception;
        throw exception;
        iterator.remove();
          goto _L1
        int j = sparsearray1.size();
        if(j > 0) {
            while(j > 0)  {
                j--;
                int k = sparsearray1.keyAt(j);
                mAuthorities.remove(k);
                int l = mSyncStatus.size();
                do {
                    if(l <= 0)
                        break;
                    l--;
                    if(mSyncStatus.keyAt(l) == k)
                        mSyncStatus.remove(mSyncStatus.keyAt(l));
                } while(true);
                int i1 = mSyncHistory.size();
                while(i1 > 0)  {
                    i1--;
                    if(((SyncHistoryItem)mSyncHistory.get(i1)).authorityId == k)
                        mSyncHistory.remove(i1);
                }
            }
            writeAccountInfoLocked();
            writeStatusLocked();
            writePendingOperationsLocked();
            writeStatisticsLocked();
        }
        sparsearray;
        JVM INSTR monitorexit ;
    }

    public ArrayList getAuthorities() {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        int i = mAuthorities.size();
        ArrayList arraylist = new ArrayList(i);
        for(int j = 0; j < i; j++)
            arraylist.add(new AuthorityInfo((AuthorityInfo)mAuthorities.valueAt(j)));

        return arraylist;
    }

    public AuthorityInfo getAuthority(int i) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        AuthorityInfo authorityinfo = (AuthorityInfo)mAuthorities.get(i);
        return authorityinfo;
    }

    public Pair getBackoff(Account account, int i, String s) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        AuthorityInfo authorityinfo = getAuthorityLocked(account, i, s, "getBackoff");
        Pair pair;
        if(authorityinfo == null || authorityinfo.backoffTime < 0L)
            pair = null;
        else
            pair = Pair.create(Long.valueOf(authorityinfo.backoffTime), Long.valueOf(authorityinfo.backoffDelay));
        return pair;
    }

    public List getCurrentSyncs(int i) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        ArrayList arraylist = (ArrayList)mCurrentSyncs.get(i);
        if(arraylist == null) {
            arraylist = new ArrayList();
            mCurrentSyncs.put(i, arraylist);
        }
        return arraylist;
    }

    public DayStats[] getDayStatistics() {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        DayStats adaystats[] = new DayStats[mDayStats.length];
        System.arraycopy(mDayStats, 0, adaystats, 0, adaystats.length);
        return adaystats;
    }

    public long getDelayUntilTime(Account account, int i, String s) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        AuthorityInfo authorityinfo = getAuthorityLocked(account, i, s, "getDelayUntil");
        long l;
        if(authorityinfo == null)
            l = 0L;
        else
            l = authorityinfo.delayUntil;
        return l;
    }

    public int getIsSyncable(Account account, int i, String s) {
        int j = -1;
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        if(account == null) goto _L2; else goto _L1
_L1:
        AuthorityInfo authorityinfo1 = getAuthorityLocked(account, i, s, "getIsSyncable");
        if(authorityinfo1 != null)
            j = authorityinfo1.syncable;
          goto _L3
        Exception exception;
        exception;
        throw exception;
_L2:
        int k = mAuthorities.size();
_L7:
        if(k <= 0) goto _L5; else goto _L4
_L4:
        AuthorityInfo authorityinfo;
        k--;
        authorityinfo = (AuthorityInfo)mAuthorities.valueAt(k);
        if(!authorityinfo.authority.equals(s)) goto _L7; else goto _L6
_L6:
        j = authorityinfo.syncable;
        sparsearray;
        JVM INSTR monitorexit ;
          goto _L3
_L5:
        sparsearray;
        JVM INSTR monitorexit ;
_L3:
        return j;
    }

    public boolean getMasterSyncAutomatically(int i) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        Boolean boolean1 = (Boolean)mMasterSyncAutomatically.get(i);
        boolean flag;
        if(boolean1 == null)
            flag = true;
        else
            flag = boolean1.booleanValue();
        return flag;
    }

    public AuthorityInfo getOrCreateAuthority(Account account, int i, String s) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        AuthorityInfo authorityinfo = getOrCreateAuthorityLocked(account, i, s, -1, true);
        return authorityinfo;
    }

    public SyncStatusInfo getOrCreateSyncStatus(AuthorityInfo authorityinfo) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        SyncStatusInfo syncstatusinfo = getOrCreateSyncStatusLocked(authorityinfo.ident);
        return syncstatusinfo;
    }

    public int getPendingOperationCount() {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        int i = mPendingOperations.size();
        return i;
    }

    public ArrayList getPendingOperations() {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(mPendingOperations);
        return arraylist;
    }

    public List getPeriodicSyncs(Account account, int i, String s) {
        ArrayList arraylist = new ArrayList();
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        AuthorityInfo authorityinfo = getAuthorityLocked(account, i, s, "getPeriodicSyncs");
        if(authorityinfo != null) {
            Pair pair;
            for(Iterator iterator = authorityinfo.periodicSyncs.iterator(); iterator.hasNext(); arraylist.add(new PeriodicSync(account, s, (Bundle)pair.first, ((Long)pair.second).longValue())))
                pair = (Pair)iterator.next();

        }
        break MISSING_BLOCK_LABEL_112;
        Exception exception;
        exception;
        throw exception;
        sparsearray;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    public SyncStatusInfo getStatusByAccountAndAuthority(Account account, int i, String s) {
        if(account == null || s == null)
            throw new IllegalArgumentException();
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        int j = mSyncStatus.size();
        int k = 0;
        do {
label0:
            {
                SyncStatusInfo syncstatusinfo;
                if(k < j) {
                    syncstatusinfo = (SyncStatusInfo)mSyncStatus.valueAt(k);
                    AuthorityInfo authorityinfo = (AuthorityInfo)mAuthorities.get(syncstatusinfo.authorityId);
                    if(authorityinfo == null || !authorityinfo.authority.equals(s) || authorityinfo.userId != i || !account.equals(authorityinfo.account))
                        break label0;
                } else {
                    syncstatusinfo = null;
                }
                return syncstatusinfo;
            }
            k++;
        } while(true);
    }

    public boolean getSyncAutomatically(Account account, int i, String s) {
        boolean flag = true;
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        if(account != null) {
            AuthorityInfo authorityinfo1 = getAuthorityLocked(account, i, s, "getSyncAutomatically");
            Exception exception;
            int j;
            AuthorityInfo authorityinfo;
            if(authorityinfo1 == null || !authorityinfo1.enabled)
                flag = false;
            break MISSING_BLOCK_LABEL_127;
        }
        j = mAuthorities.size();
        do {
            if(j <= 0)
                break MISSING_BLOCK_LABEL_121;
            j--;
            authorityinfo = (AuthorityInfo)mAuthorities.valueAt(j);
        } while(!authorityinfo.authority.equals(s) || authorityinfo.userId != i || !authorityinfo.enabled);
        break MISSING_BLOCK_LABEL_127;
        exception;
        throw exception;
        sparsearray;
        JVM INSTR monitorexit ;
        flag = false;
        return flag;
    }

    public ArrayList getSyncHistory() {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        int i = mSyncHistory.size();
        ArrayList arraylist = new ArrayList(i);
        for(int j = 0; j < i; j++)
            arraylist.add(mSyncHistory.get(j));

        return arraylist;
    }

    public int getSyncRandomOffset() {
        return mSyncRandomOffset;
    }

    public ArrayList getSyncStatus() {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        int i = mSyncStatus.size();
        ArrayList arraylist = new ArrayList(i);
        for(int j = 0; j < i; j++)
            arraylist.add(mSyncStatus.valueAt(j));

        return arraylist;
    }

    public void handleMessage(Message message) {
        if(message.what != 1)
            break MISSING_BLOCK_LABEL_35;
        SparseArray sparsearray1 = mAuthorities;
        sparsearray1;
        JVM INSTR monitorenter ;
        writeStatusLocked();
        break MISSING_BLOCK_LABEL_64;
        if(message.what != 2)
            break MISSING_BLOCK_LABEL_64;
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        writeStatisticsLocked();
    }

    public PendingOperation insertIntoPending(PendingOperation pendingoperation) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        AuthorityInfo authorityinfo;
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("insertIntoPending: account=").append(pendingoperation.account).append(" user=").append(pendingoperation.userId).append(" auth=").append(pendingoperation.authority).append(" src=").append(pendingoperation.syncSource).append(" extras=").append(pendingoperation.extras).toString());
        authorityinfo = getOrCreateAuthorityLocked(pendingoperation.account, pendingoperation.userId, pendingoperation.authority, -1, true);
        if(authorityinfo != null) goto _L2; else goto _L1
_L1:
        PendingOperation pendingoperation1 = null;
          goto _L3
_L2:
        pendingoperation1 = new PendingOperation(pendingoperation);
        pendingoperation1.authorityId = authorityinfo.ident;
        mPendingOperations.add(pendingoperation1);
        appendPendingOperationLocked(pendingoperation1);
        getOrCreateSyncStatusLocked(authorityinfo.ident).pending = true;
        sparsearray;
        JVM INSTR monitorexit ;
        reportChange(2);
        pendingoperation1;
          goto _L3
        Exception exception;
        exception;
_L4:
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        pendingoperation1;
        if(true) goto _L4; else goto _L3
_L3:
        return pendingoperation1;
    }

    public long insertStartSyncEvent(Account account, int i, String s, long l, int j, boolean flag) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        SyncHistoryItem synchistoryitem;
        long l1;
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("insertStartSyncEvent: account=").append(account).append("user=").append(i).append(" auth=").append(s).append(" source=").append(j).toString());
        AuthorityInfo authorityinfo = getAuthorityLocked(account, i, s, "insertStartSyncEvent");
        if(authorityinfo == null) {
            l1 = -1L;
            break MISSING_BLOCK_LABEL_286;
        }
        synchistoryitem = new SyncHistoryItem();
        synchistoryitem.initialization = flag;
        synchistoryitem.authorityId = authorityinfo.ident;
        int k = mNextHistoryId;
        mNextHistoryId = k + 1;
        synchistoryitem.historyId = k;
        if(mNextHistoryId < 0)
            mNextHistoryId = 0;
        synchistoryitem.eventTime = l;
        synchistoryitem.source = j;
        synchistoryitem.event = 0;
        mSyncHistory.add(0, synchistoryitem);
        for(; mSyncHistory.size() > 100; mSyncHistory.remove(-1 + mSyncHistory.size()));
        break MISSING_BLOCK_LABEL_233;
        Exception exception;
        exception;
        throw exception;
        l1 = synchistoryitem.historyId;
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("returning historyId ").append(l1).toString());
        sparsearray;
        JVM INSTR monitorexit ;
        reportChange(8);
        return l1;
    }

    public boolean isSyncActive(Account account, int i, String s) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        boolean flag;
label0:
        {
            for(Iterator iterator = getCurrentSyncs(i).iterator(); iterator.hasNext();) {
                AuthorityInfo authorityinfo = getAuthority(((SyncInfo)iterator.next()).authorityId);
                if(authorityinfo != null && authorityinfo.account.equals(account) && authorityinfo.authority.equals(s) && authorityinfo.userId == i) {
                    flag = true;
                    break label0;
                }
            }

            flag = false;
        }
        return flag;
    }

    public boolean isSyncPending(Account account, int i, String s) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        int j = mSyncStatus.size();
        int k = 0;
        boolean flag;
        do {
            if(k < j) {
                SyncStatusInfo syncstatusinfo = (SyncStatusInfo)mSyncStatus.valueAt(k);
                AuthorityInfo authorityinfo = (AuthorityInfo)mAuthorities.get(syncstatusinfo.authorityId);
                if(authorityinfo != null && i == authorityinfo.userId && (account == null || authorityinfo.account.equals(account)) && authorityinfo.authority.equals(s) && syncstatusinfo.pending) {
                    flag = true;
                    break;
                }
            } else {
                flag = false;
                break;
            }
            k++;
        } while(true);
        return flag;
    }

    public void removeActiveSync(SyncInfo syncinfo, int i) {
        synchronized(mAuthorities) {
            if(Log.isLoggable("SyncManager", 2))
                Log.v("SyncManager", (new StringBuilder()).append("removeActiveSync: account=").append(syncinfo.account).append(" user=").append(i).append(" auth=").append(syncinfo.authority).toString());
            getCurrentSyncs(i).remove(syncinfo);
        }
        reportActiveChange();
        return;
        exception;
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void removeAuthority(Account account, int i, String s) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        removeAuthorityLocked(account, i, s, true);
        return;
    }

    public void removePeriodicSync(Account account, int i, String s, Bundle bundle) {
        updateOrRemovePeriodicSync(account, i, s, bundle, 0L, false);
    }

    public void removeStatusChangeListener(ISyncStatusObserver isyncstatusobserver) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        mChangeListeners.unregister(isyncstatusobserver);
        return;
    }

    public void reportActiveChange() {
        reportChange(4);
    }

    public void setBackoff(Account account, int i, String s, long l, long l1) {
        boolean flag;
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("setBackoff: ").append(account).append(", provider ").append(s).append(", user ").append(i).append(" -> nextSyncTime ").append(l).append(", nextDelay ").append(l1).toString());
        flag = false;
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        if(account != null && s != null)
            break MISSING_BLOCK_LABEL_259;
        for(Iterator iterator = mAccounts.values().iterator(); iterator.hasNext();) {
            AccountInfo accountinfo = (AccountInfo)iterator.next();
            if(account == null || account.equals(accountinfo.accountAndUser.account) || i == accountinfo.accountAndUser.userId) {
                Iterator iterator1 = accountinfo.authorities.values().iterator();
                while(iterator1.hasNext())  {
                    AuthorityInfo authorityinfo = (AuthorityInfo)iterator1.next();
                    if((s == null || s.equals(authorityinfo.authority)) && (authorityinfo.backoffTime != l || authorityinfo.backoffDelay != l1)) {
                        authorityinfo.backoffTime = l;
                        authorityinfo.backoffDelay = l1;
                        flag = true;
                    }
                }
            }
        }

        break MISSING_BLOCK_LABEL_316;
        AuthorityInfo authorityinfo1;
        authorityinfo1 = getOrCreateAuthorityLocked(account, i, s, -1, true);
        if(authorityinfo1.backoffTime != l || authorityinfo1.backoffDelay != l1)
            break MISSING_BLOCK_LABEL_299;
        sparsearray;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_340;
        authorityinfo1.backoffTime = l;
        authorityinfo1.backoffDelay = l1;
        flag = true;
        sparsearray;
        JVM INSTR monitorexit ;
        if(flag)
            reportChange(1);
        break MISSING_BLOCK_LABEL_340;
        Exception exception;
        exception;
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setDelayUntilTime(Account account, int i, String s, long l) {
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("setDelayUntil: ").append(account).append(", provider ").append(s).append(", user ").append(i).append(" -> delayUntil ").append(l).toString());
        synchronized(mAuthorities) {
            AuthorityInfo authorityinfo = getOrCreateAuthorityLocked(account, i, s, -1, true);
            if(authorityinfo.delayUntil == l)
                break MISSING_BLOCK_LABEL_130;
            authorityinfo.delayUntil = l;
        }
        reportChange(1);
          goto _L1
        exception;
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
    }

    public void setIsSyncable(Account account, int i, String s, int j) {
        if(j <= 1) goto _L2; else goto _L1
_L1:
        j = 1;
_L5:
        Log.d("SyncManager", (new StringBuilder()).append("setIsSyncable: ").append(account).append(", provider ").append(s).append(", user ").append(i).append(" -> ").append(j).toString());
        synchronized(mAuthorities) {
            AuthorityInfo authorityinfo = getOrCreateAuthorityLocked(account, i, s, -1, false);
            if(authorityinfo.syncable == j) {
                Log.d("SyncManager", (new StringBuilder()).append("setIsSyncable: already set to ").append(j).append(", doing nothing").toString());
                break MISSING_BLOCK_LABEL_185;
            }
            authorityinfo.syncable = j;
            writeAccountInfoLocked();
        }
        if(j > 0)
            requestSync(account, i, s, new Bundle());
        reportChange(1);
          goto _L3
        exception;
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception;
_L3:
        return;
_L2:
        if(j < -1)
            j = -1;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void setMasterSyncAutomatically(boolean flag, int i) {
        synchronized(mAuthorities) {
            Boolean boolean1 = (Boolean)mMasterSyncAutomatically.get(i);
            if(boolean1 != null && boolean1.booleanValue() == flag)
                break MISSING_BLOCK_LABEL_100;
            mMasterSyncAutomatically.put(i, Boolean.valueOf(flag));
            writeAccountInfoLocked();
        }
        if(flag)
            requestSync(null, i, null, new Bundle());
        reportChange(1);
        mContext.sendBroadcast(SYNC_CONNECTION_SETTING_CHANGED_INTENT);
          goto _L1
        exception;
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
    }

    protected void setOnSyncRequestListener(OnSyncRequestListener onsyncrequestlistener) {
        if(mSyncRequestListener == null)
            mSyncRequestListener = onsyncrequestlistener;
    }

    public void setSyncAutomatically(Account account, int i, String s, boolean flag) {
        Log.d("SyncManager", (new StringBuilder()).append("setSyncAutomatically:  provider ").append(s).append(", user ").append(i).append(" -> ").append(flag).toString());
        synchronized(mAuthorities) {
            AuthorityInfo authorityinfo = getOrCreateAuthorityLocked(account, i, s, -1, false);
            if(authorityinfo.enabled == flag) {
                Log.d("SyncManager", (new StringBuilder()).append("setSyncAutomatically: already set to ").append(flag).append(", doing nothing").toString());
                break MISSING_BLOCK_LABEL_166;
            }
            authorityinfo.enabled = flag;
            writeAccountInfoLocked();
        }
        if(flag)
            requestSync(account, i, s, new Bundle());
        reportChange(1);
          goto _L1
        exception;
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
    }

    public void stopSyncEvent(long l, long l1, String s, long l2, 
            long l3) {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        SyncHistoryItem synchistoryitem;
        int i;
        if(Log.isLoggable("SyncManager", 2))
            Log.v("SyncManager", (new StringBuilder()).append("stopSyncEvent: historyId=").append(l).toString());
        synchistoryitem = null;
        i = mSyncHistory.size();
_L22:
        if(i > 0) {
            i--;
            synchistoryitem = (SyncHistoryItem)mSyncHistory.get(i);
            if((long)synchistoryitem.historyId != l)
                break MISSING_BLOCK_LABEL_705;
        }
        if(synchistoryitem != null) goto _L2; else goto _L1
_L1:
        Log.w("SyncManager", (new StringBuilder()).append("stopSyncEvent: no history for id ").append(l).toString());
          goto _L3
_L2:
        SyncStatusInfo syncstatusinfo;
        synchistoryitem.elapsedTime = l1;
        synchistoryitem.event = 1;
        synchistoryitem.mesg = s;
        synchistoryitem.downstreamActivity = l2;
        synchistoryitem.upstreamActivity = l3;
        syncstatusinfo = getOrCreateSyncStatusLocked(synchistoryitem.authorityId);
        syncstatusinfo.numSyncs = 1 + syncstatusinfo.numSyncs;
        syncstatusinfo.totalElapsedTime = l1 + syncstatusinfo.totalElapsedTime;
        synchistoryitem.source;
        JVM INSTR tableswitch 0 4: default 232
    //                   0 467
    //                   1 414
    //                   2 437
    //                   3 452
    //                   4 482;
           goto _L4 _L5 _L6 _L7 _L8 _L9
_L4:
        boolean flag;
        int j;
        flag = false;
        j = getCurrentDayLocked();
        if(mDayStats[0] != null) goto _L11; else goto _L10
_L10:
        mDayStats[0] = new DayStats(j);
_L18:
        DayStats daystats;
        long l4;
        boolean flag1;
        daystats = mDayStats[0];
        l4 = l1 + synchistoryitem.eventTime;
        flag1 = false;
        if(!"success".equals(s)) goto _L13; else goto _L12
_L12:
        Exception exception;
        if(syncstatusinfo.lastSuccessTime == 0L || syncstatusinfo.lastFailureTime != 0L)
            flag1 = true;
        syncstatusinfo.lastSuccessTime = l4;
        syncstatusinfo.lastSuccessSource = synchistoryitem.source;
        syncstatusinfo.lastFailureTime = 0L;
        syncstatusinfo.lastFailureSource = -1;
        syncstatusinfo.lastFailureMesg = null;
        syncstatusinfo.initialFailureTime = 0L;
        daystats.successCount = 1 + daystats.successCount;
        daystats.successTime = l1 + daystats.successTime;
_L19:
        if(!flag1) goto _L15; else goto _L14
_L14:
        writeStatusLocked();
_L20:
        if(!flag) goto _L17; else goto _L16
_L16:
        writeStatisticsLocked();
_L21:
        reportChange(8);
          goto _L3
_L6:
        syncstatusinfo.numSourceLocal = 1 + syncstatusinfo.numSourceLocal;
          goto _L4
        exception;
        throw exception;
_L7:
        syncstatusinfo.numSourcePoll = 1 + syncstatusinfo.numSourcePoll;
          goto _L4
_L8:
        syncstatusinfo.numSourceUser = 1 + syncstatusinfo.numSourceUser;
          goto _L4
_L5:
        syncstatusinfo.numSourceServer = 1 + syncstatusinfo.numSourceServer;
          goto _L4
_L9:
        syncstatusinfo.numSourcePeriodic = 1 + syncstatusinfo.numSourcePeriodic;
          goto _L4
_L11:
        if(j != mDayStats[0].day) {
            System.arraycopy(mDayStats, 0, mDayStats, 1, -1 + mDayStats.length);
            mDayStats[0] = new DayStats(j);
            flag = true;
        } else
        if(mDayStats[0] != null);
          goto _L18
_L13:
        if(!"canceled".equals(s)) {
            if(syncstatusinfo.lastFailureTime == 0L)
                flag1 = true;
            syncstatusinfo.lastFailureTime = l4;
            syncstatusinfo.lastFailureSource = synchistoryitem.source;
            syncstatusinfo.lastFailureMesg = s;
            if(syncstatusinfo.initialFailureTime == 0L)
                syncstatusinfo.initialFailureTime = l4;
            daystats.failureCount = 1 + daystats.failureCount;
            daystats.failureTime = l1 + daystats.failureTime;
        }
          goto _L19
_L15:
        if(!hasMessages(1))
            sendMessageDelayed(obtainMessage(1), 0x927c0L);
          goto _L20
_L17:
        if(!hasMessages(2))
            sendMessageDelayed(obtainMessage(2), 0x1b7740L);
          goto _L21
_L3:
        return;
        synchistoryitem = null;
          goto _L22
    }

    public void writeAllState() {
        SparseArray sparsearray = mAuthorities;
        sparsearray;
        JVM INSTR monitorenter ;
        if(mNumPendingFinished > 0)
            writePendingOperationsLocked();
        writeStatusLocked();
        writeStatisticsLocked();
        return;
    }

    private static final int ACCOUNTS_VERSION = 2;
    private static final boolean DEBUG_FILE = false;
    private static final long DEFAULT_POLL_FREQUENCY_SECONDS = 0x15180L;
    public static final String EVENTS[];
    public static final int EVENT_START = 0;
    public static final int EVENT_STOP = 1;
    public static final int MAX_HISTORY = 100;
    public static final String MESG_CANCELED = "canceled";
    public static final String MESG_SUCCESS = "success";
    static final long MILLIS_IN_4WEEKS = 0x90321000L;
    private static final int MSG_WRITE_STATISTICS = 2;
    private static final int MSG_WRITE_STATUS = 1;
    public static final long NOT_IN_BACKOFF_MODE = -1L;
    private static final int PENDING_FINISH_TO_WRITE = 4;
    public static final int PENDING_OPERATION_VERSION = 2;
    public static final String SOURCES[];
    public static final int SOURCE_LOCAL = 1;
    public static final int SOURCE_PERIODIC = 4;
    public static final int SOURCE_POLL = 2;
    public static final int SOURCE_SERVER = 0;
    public static final int SOURCE_USER = 3;
    public static final int STATISTICS_FILE_END = 0;
    public static final int STATISTICS_FILE_ITEM = 101;
    public static final int STATISTICS_FILE_ITEM_OLD = 100;
    public static final int STATUS_FILE_END = 0;
    public static final int STATUS_FILE_ITEM = 100;
    public static final Intent SYNC_CONNECTION_SETTING_CHANGED_INTENT = new Intent("com.android.sync.SYNC_CONN_STATUS_CHANGED");
    private static final boolean SYNC_ENABLED_DEFAULT = false;
    private static final String TAG = "SyncManager";
    private static final long WRITE_STATISTICS_DELAY = 0x1b7740L;
    private static final long WRITE_STATUS_DELAY = 0x927c0L;
    private static final String XML_ATTR_ENABLED = "enabled";
    private static final String XML_ATTR_LISTEN_FOR_TICKLES = "listen-for-tickles";
    private static final String XML_ATTR_NEXT_AUTHORITY_ID = "nextAuthorityId";
    private static final String XML_ATTR_SYNC_RANDOM_OFFSET = "offsetInSeconds";
    private static final String XML_ATTR_USER = "user";
    private static final String XML_TAG_LISTEN_FOR_TICKLES = "listenForTickles";
    private static HashMap sAuthorityRenames;
    private static volatile SyncStorageEngine sSyncStorageEngine = null;
    private final AtomicFile mAccountInfoFile;
    private final HashMap mAccounts = new HashMap();
    private final SparseArray mAuthorities = new SparseArray();
    private final Calendar mCal = Calendar.getInstance(TimeZone.getTimeZone("GMT+0"));
    private final RemoteCallbackList mChangeListeners = new RemoteCallbackList();
    private final Context mContext;
    private final SparseArray mCurrentSyncs = new SparseArray();
    private final DayStats mDayStats[] = new DayStats[28];
    private SparseArray mMasterSyncAutomatically;
    private int mNextAuthorityId;
    private int mNextHistoryId;
    private int mNumPendingFinished;
    private final AtomicFile mPendingFile;
    private final ArrayList mPendingOperations = new ArrayList();
    private final AtomicFile mStatisticsFile;
    private final AtomicFile mStatusFile;
    private final ArrayList mSyncHistory = new ArrayList();
    private int mSyncRandomOffset;
    private OnSyncRequestListener mSyncRequestListener;
    private final SparseArray mSyncStatus = new SparseArray();
    private int mYear;
    private int mYearInDays;

    static  {
        String as[] = new String[2];
        as[0] = "START";
        as[1] = "STOP";
        EVENTS = as;
        String as1[] = new String[5];
        as1[0] = "SERVER";
        as1[1] = "LOCAL";
        as1[2] = "POLL";
        as1[3] = "USER";
        as1[4] = "PERIODIC";
        SOURCES = as1;
        sAuthorityRenames = new HashMap();
        sAuthorityRenames.put("contacts", "com.android.contacts");
        sAuthorityRenames.put("calendar", "com.android.calendar");
    }
}
