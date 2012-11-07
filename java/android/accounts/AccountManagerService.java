// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.*;
import android.text.TextUtils;
import android.util.*;
import com.android.internal.util.IndentingPrintWriter;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import miui.content.pm.ExtraPackageManager;

// Referenced classes of package android.accounts:
//            Account, AccountAuthenticatorCache, IAccountAuthenticatorCache, GrantCredentialsPermissionActivity, 
//            AuthenticatorDescription, IAccountManagerResponse, AccountAndUser, AccountAuthenticatorResponse, 
//            IAccountAuthenticator

public class AccountManagerService extends IAccountManager.Stub
    implements RegisteredServicesCacheListener {
    static class DatabaseHelper extends SQLiteOpenHelper {

        private void createAccountsDeletionTrigger(SQLiteDatabase sqlitedatabase) {
            sqlitedatabase.execSQL(" CREATE TRIGGER accountsDelete DELETE ON accounts BEGIN   DELETE FROM authtokens     WHERE accounts_id=OLD._id ;   DELETE FROM extras     WHERE accounts_id=OLD._id ;   DELETE FROM grants     WHERE accounts_id=OLD._id ; END");
        }

        private void createGrantsTable(SQLiteDatabase sqlitedatabase) {
            sqlitedatabase.execSQL("CREATE TABLE grants (  accounts_id INTEGER NOT NULL, auth_token_type STRING NOT NULL,  uid INTEGER NOT NULL,  UNIQUE (accounts_id,auth_token_type,uid))");
        }

        public void onCreate(SQLiteDatabase sqlitedatabase) {
            sqlitedatabase.execSQL("CREATE TABLE accounts ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, type TEXT NOT NULL, password TEXT, UNIQUE(name,type))");
            sqlitedatabase.execSQL("CREATE TABLE authtokens (  _id INTEGER PRIMARY KEY AUTOINCREMENT,  accounts_id INTEGER NOT NULL, type TEXT NOT NULL,  authtoken TEXT,  UNIQUE (accounts_id,type))");
            createGrantsTable(sqlitedatabase);
            sqlitedatabase.execSQL("CREATE TABLE extras ( _id INTEGER PRIMARY KEY AUTOINCREMENT, accounts_id INTEGER, key TEXT NOT NULL, value TEXT, UNIQUE(accounts_id,key))");
            sqlitedatabase.execSQL("CREATE TABLE meta ( key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            createAccountsDeletionTrigger(sqlitedatabase);
        }

        public void onOpen(SQLiteDatabase sqlitedatabase) {
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", "opened database accounts.db");
        }

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j) {
            Log.e("AccountManagerService", (new StringBuilder()).append("upgrade from version ").append(i).append(" to version ").append(j).toString());
            if(i == 1)
                i++;
            if(i == 2) {
                createGrantsTable(sqlitedatabase);
                sqlitedatabase.execSQL("DROP TRIGGER accountsDelete");
                createAccountsDeletionTrigger(sqlitedatabase);
                i++;
            }
            if(i == 3) {
                sqlitedatabase.execSQL("UPDATE accounts SET type = 'com.google' WHERE type == 'com.google.GAIA'");
                int _tmp = i + 1;
            }
        }

        public DatabaseHelper(Context context, int i) {
            super(context, AccountManagerService.getDatabaseName(i), null, 4);
        }
    }

    private class MessageHandler extends Handler {

        public void handleMessage(Message message) {
            switch(message.what) {
            default:
                throw new IllegalStateException((new StringBuilder()).append("unhandled message: ").append(message.what).toString());

            case 3: // '\003'
                ((Session)message.obj).onTimedOut();
                break;
            }
        }

        final AccountManagerService this$0;

        MessageHandler(Looper looper) {
            this$0 = AccountManagerService.this;
            super(looper);
        }
    }

    private abstract class Session extends IAccountAuthenticatorResponse.Stub
        implements android.os.IBinder.DeathRecipient, ServiceConnection {

        private boolean bindToAuthenticator(String s) {
            boolean flag;
            android.content.pm.RegisteredServicesCache.ServiceInfo serviceinfo;
            flag = false;
            serviceinfo = mAuthenticatorCache.getServiceInfo(AuthenticatorDescription.newKey(s));
            if(serviceinfo != null) goto _L2; else goto _L1
_L1:
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", (new StringBuilder()).append("there is no authenticator for ").append(s).append(", bailing out").toString());
_L4:
            return flag;
_L2:
            Intent intent = new Intent();
            intent.setAction("android.accounts.AccountAuthenticator");
            intent.setComponent(serviceinfo.componentName);
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", (new StringBuilder()).append("performing bindService to ").append(serviceinfo.componentName).toString());
            if(!mContext.bindService(intent, this, 1, mAccounts.userId)) {
                if(Log.isLoggable("AccountManagerService", 2))
                    Log.v("AccountManagerService", (new StringBuilder()).append("bindService to ").append(serviceinfo.componentName).append(" failed").toString());
            } else {
                flag = true;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        private void close() {
            synchronized(mSessions) {
                if(mSessions.remove(toString()) == null)
                    break MISSING_BLOCK_LABEL_79;
            }
            if(mResponse != null) {
                mResponse.asBinder().unlinkToDeath(this, 0);
                mResponse = null;
            }
            cancelTimeout();
            unbind();
              goto _L1
            exception;
            linkedhashmap;
            JVM INSTR monitorexit ;
            throw exception;
_L1:
        }

        private void unbind() {
            if(mAuthenticator != null) {
                mAuthenticator = null;
                mContext.unbindService(this);
            }
        }

        void bind() {
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", (new StringBuilder()).append("initiating bind to authenticator type ").append(mAccountType).toString());
            if(!bindToAuthenticator(mAccountType)) {
                Log.d("AccountManagerService", (new StringBuilder()).append("bind attempt failed for ").append(toDebugString()).toString());
                onError(1, "bind failure");
            }
        }

        public void binderDied() {
            mResponse = null;
            close();
        }

        public void cancelTimeout() {
            mMessageHandler.removeMessages(3, this);
        }

        IAccountManagerResponse getResponseAndClose() {
            IAccountManagerResponse iaccountmanagerresponse;
            if(mResponse == null) {
                iaccountmanagerresponse = null;
            } else {
                iaccountmanagerresponse = mResponse;
                close();
            }
            return iaccountmanagerresponse;
        }

        public void onError(int i, String s) {
            IAccountManagerResponse iaccountmanagerresponse;
            mNumErrors = 1 + mNumErrors;
            iaccountmanagerresponse = getResponseAndClose();
            if(iaccountmanagerresponse == null)
                break MISSING_BLOCK_LABEL_98;
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", (new StringBuilder()).append(getClass().getSimpleName()).append(" calling onError() on response ").append(iaccountmanagerresponse).toString());
            iaccountmanagerresponse.onError(i, s);
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", "Session.onError: caught RemoteException while responding", remoteexception);
              goto _L1
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", "Session.onError: already closed");
              goto _L1
        }

        public void onRequestContinued() {
            mNumRequestContinued = 1 + mNumRequestContinued;
        }

        public void onResult(Bundle bundle) {
            IAccountManagerResponse iaccountmanagerresponse;
            mNumResults = 1 + mNumResults;
            if(bundle != null && !TextUtils.isEmpty(bundle.getString("authtoken"))) {
                String s = bundle.getString("authAccount");
                String s1 = bundle.getString("accountType");
                if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) {
                    Account account = new Account(s, s1);
                    cancelNotification(getSigninRequiredNotificationId(mAccounts, account).intValue());
                }
            }
            if(mExpectActivityLaunch && bundle != null && bundle.containsKey("intent"))
                iaccountmanagerresponse = mResponse;
            else
                iaccountmanagerresponse = getResponseAndClose();
            if(iaccountmanagerresponse == null)
                break MISSING_BLOCK_LABEL_186;
            if(bundle != null)
                break MISSING_BLOCK_LABEL_195;
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", (new StringBuilder()).append(getClass().getSimpleName()).append(" calling onError() on response ").append(iaccountmanagerresponse).toString());
            iaccountmanagerresponse.onError(5, "null bundle returned");
_L1:
            return;
            try {
                if(mStripAuthTokenFromResult)
                    bundle.remove("authtoken");
                if(Log.isLoggable("AccountManagerService", 2))
                    Log.v("AccountManagerService", (new StringBuilder()).append(getClass().getSimpleName()).append(" calling onResult() on response ").append(iaccountmanagerresponse).toString());
                iaccountmanagerresponse.onResult(bundle);
            }
            catch(RemoteException remoteexception) {
                if(Log.isLoggable("AccountManagerService", 2))
                    Log.v("AccountManagerService", "failure while notifying response", remoteexception);
            }
              goto _L1
        }

        public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
            mAuthenticator = IAccountAuthenticator.Stub.asInterface(ibinder);
            run();
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            onError(1, "remote exception");
              goto _L1
        }

        public void onServiceDisconnected(ComponentName componentname) {
            IAccountManagerResponse iaccountmanagerresponse;
            mAuthenticator = null;
            iaccountmanagerresponse = getResponseAndClose();
            if(iaccountmanagerresponse == null)
                break MISSING_BLOCK_LABEL_24;
            iaccountmanagerresponse.onError(1, "disconnected");
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", "Session.onServiceDisconnected: caught RemoteException while responding", remoteexception);
              goto _L1
        }

        public void onTimedOut() {
            IAccountManagerResponse iaccountmanagerresponse;
            iaccountmanagerresponse = getResponseAndClose();
            if(iaccountmanagerresponse == null)
                break MISSING_BLOCK_LABEL_19;
            iaccountmanagerresponse.onError(1, "timeout");
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", "Session.onTimedOut: caught RemoteException while responding", remoteexception);
              goto _L1
        }

        public abstract void run() throws RemoteException;

        public void scheduleTimeout() {
            mMessageHandler.sendMessageDelayed(mMessageHandler.obtainMessage(3, this), 60000L);
        }

        protected String toDebugString() {
            return toDebugString(SystemClock.elapsedRealtime());
        }

        protected String toDebugString(long l) {
            StringBuilder stringbuilder = (new StringBuilder()).append("Session: expectLaunch ").append(mExpectActivityLaunch).append(", connected ");
            boolean flag;
            if(mAuthenticator != null)
                flag = true;
            else
                flag = false;
            return stringbuilder.append(flag).append(", stats (").append(mNumResults).append("/").append(mNumRequestContinued).append("/").append(mNumErrors).append(")").append(", lifetime ").append((double)(l - mCreationTime) / 1000D).toString();
        }

        final String mAccountType;
        protected final UserAccounts mAccounts;
        IAccountAuthenticator mAuthenticator;
        final long mCreationTime;
        final boolean mExpectActivityLaunch;
        private int mNumErrors;
        private int mNumRequestContinued;
        public int mNumResults;
        IAccountManagerResponse mResponse;
        private final boolean mStripAuthTokenFromResult;
        final AccountManagerService this$0;

        public Session(UserAccounts useraccounts, IAccountManagerResponse iaccountmanagerresponse, String s, boolean flag, boolean flag1) {
            this$0 = AccountManagerService.this;
            super();
            mNumResults = 0;
            mNumRequestContinued = 0;
            mNumErrors = 0;
            mAuthenticator = null;
            if(iaccountmanagerresponse == null)
                throw new IllegalArgumentException("response is null");
            if(s == null)
                throw new IllegalArgumentException("accountType is null");
            mAccounts = useraccounts;
            mStripAuthTokenFromResult = flag1;
            mResponse = iaccountmanagerresponse;
            mAccountType = s;
            mExpectActivityLaunch = flag;
            mCreationTime = SystemClock.elapsedRealtime();
            synchronized(mSessions) {
                mSessions.put(toString(), this);
            }
            iaccountmanagerresponse.asBinder().linkToDeath(this, 0);
_L1:
            return;
            exception;
            linkedhashmap;
            JVM INSTR monitorexit ;
            throw exception;
            RemoteException remoteexception;
            remoteexception;
            mResponse = null;
            binderDied();
              goto _L1
        }
    }

    private class GetAccountsByTypeAndFeatureSession extends Session {

        public void checkAccount() {
            if(mCurrentAccount < mAccountsOfType.length) goto _L2; else goto _L1
_L1:
            sendResult();
_L4:
            return;
_L2:
            IAccountAuthenticator iaccountauthenticator = super.mAuthenticator;
            if(iaccountauthenticator == null) {
                if(Log.isLoggable("AccountManagerService", 2))
                    Log.v("AccountManagerService", (new StringBuilder()).append("checkAccount: aborting session since we are no longer connected to the authenticator, ").append(toDebugString()).toString());
            } else {
                try {
                    iaccountauthenticator.hasFeatures(this, mAccountsOfType[mCurrentAccount], mFeatures);
                }
                catch(RemoteException remoteexception) {
                    onError(1, "remote exception");
                }
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void onResult(Bundle bundle) {
            super.mNumResults = 1 + super.mNumResults;
            if(bundle == null) {
                onError(5, "null bundle");
            } else {
                if(bundle.getBoolean("booleanResult", false))
                    mAccountsWithFeatures.add(mAccountsOfType[mCurrentAccount]);
                mCurrentAccount = 1 + mCurrentAccount;
                checkAccount();
            }
        }

        public void run() throws RemoteException {
            synchronized(super.mAccounts.cacheLock) {
                mAccountsOfType = getAccountsFromCacheLocked(super.mAccounts, super.mAccountType);
            }
            mAccountsWithFeatures = new ArrayList(mAccountsOfType.length);
            mCurrentAccount = 0;
            checkAccount();
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void sendResult() {
            IAccountManagerResponse iaccountmanagerresponse;
            iaccountmanagerresponse = getResponseAndClose();
            if(iaccountmanagerresponse == null)
                break MISSING_BLOCK_LABEL_125;
            Account aaccount[] = new Account[mAccountsWithFeatures.size()];
            for(int i = 0; i < aaccount.length; i++)
                aaccount[i] = (Account)mAccountsWithFeatures.get(i);

            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", (new StringBuilder()).append(getClass().getSimpleName()).append(" calling onResult() on response ").append(iaccountmanagerresponse).toString());
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("accounts", aaccount);
            iaccountmanagerresponse.onResult(bundle);
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", "failure while notifying response", remoteexception);
              goto _L1
        }

        protected String toDebugString(long l) {
            StringBuilder stringbuilder = (new StringBuilder()).append(super.toDebugString(l)).append(", getAccountsByTypeAndFeatures").append(", ");
            String s;
            if(mFeatures != null)
                s = TextUtils.join(",", mFeatures);
            else
                s = null;
            return stringbuilder.append(s).toString();
        }

        private volatile Account mAccountsOfType[];
        private volatile ArrayList mAccountsWithFeatures;
        private volatile int mCurrentAccount;
        private final String mFeatures[];
        final AccountManagerService this$0;

        public GetAccountsByTypeAndFeatureSession(UserAccounts useraccounts, IAccountManagerResponse iaccountmanagerresponse, String s, String as[]) {
            this$0 = AccountManagerService.this;
            super(useraccounts, iaccountmanagerresponse, s, false, true);
            mAccountsOfType = null;
            mAccountsWithFeatures = null;
            mCurrentAccount = 0;
            mFeatures = as;
        }
    }

    private class RemoveAccountSession extends Session {

        public void onResult(Bundle bundle) {
            if(bundle != null && bundle.containsKey("booleanResult") && !bundle.containsKey("intent")) {
                boolean flag = bundle.getBoolean("booleanResult");
                if(flag)
                    removeAccountInternal(super.mAccounts, mAccount);
                IAccountManagerResponse iaccountmanagerresponse = getResponseAndClose();
                if(iaccountmanagerresponse != null) {
                    if(Log.isLoggable("AccountManagerService", 2))
                        Log.v("AccountManagerService", (new StringBuilder()).append(getClass().getSimpleName()).append(" calling onResult() on response ").append(iaccountmanagerresponse).toString());
                    Bundle bundle1 = new Bundle();
                    bundle1.putBoolean("booleanResult", flag);
                    try {
                        iaccountmanagerresponse.onResult(bundle1);
                    }
                    catch(RemoteException remoteexception) { }
                }
            }
            super.onResult(bundle);
        }

        public void run() throws RemoteException {
            super.mAuthenticator.getAccountRemovalAllowed(this, mAccount);
        }

        protected String toDebugString(long l) {
            return (new StringBuilder()).append(super.toDebugString(l)).append(", removeAccount").append(", account ").append(mAccount).toString();
        }

        final Account mAccount;
        final AccountManagerService this$0;

        public RemoveAccountSession(UserAccounts useraccounts, IAccountManagerResponse iaccountmanagerresponse, Account account) {
            this$0 = AccountManagerService.this;
            super(useraccounts, iaccountmanagerresponse, account.type, false, true);
            mAccount = account;
        }
    }

    private class TestFeaturesSession extends Session {

        public void onResult(Bundle bundle) {
            IAccountManagerResponse iaccountmanagerresponse;
            iaccountmanagerresponse = getResponseAndClose();
            if(iaccountmanagerresponse == null)
                break MISSING_BLOCK_LABEL_122;
            if(bundle != null)
                break MISSING_BLOCK_LABEL_25;
            iaccountmanagerresponse.onError(5, "null bundle");
            break MISSING_BLOCK_LABEL_122;
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", (new StringBuilder()).append(getClass().getSimpleName()).append(" calling onResult() on response ").append(iaccountmanagerresponse).toString());
            Bundle bundle1 = new Bundle();
            bundle1.putBoolean("booleanResult", bundle.getBoolean("booleanResult", false));
            iaccountmanagerresponse.onResult(bundle1);
            break MISSING_BLOCK_LABEL_122;
            RemoteException remoteexception;
            remoteexception;
            if(Log.isLoggable("AccountManagerService", 2))
                Log.v("AccountManagerService", "failure while notifying response", remoteexception);
        }

        public void run() throws RemoteException {
            super.mAuthenticator.hasFeatures(this, mAccount, mFeatures);
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            onError(1, "remote exception");
              goto _L1
        }

        protected String toDebugString(long l) {
            StringBuilder stringbuilder = (new StringBuilder()).append(super.toDebugString(l)).append(", hasFeatures").append(", ").append(mAccount).append(", ");
            String s;
            if(mFeatures != null)
                s = TextUtils.join(",", mFeatures);
            else
                s = null;
            return stringbuilder.append(s).toString();
        }

        private final Account mAccount;
        private final String mFeatures[];
        final AccountManagerService this$0;

        public TestFeaturesSession(UserAccounts useraccounts, IAccountManagerResponse iaccountmanagerresponse, Account account, String as[]) {
            this$0 = AccountManagerService.this;
            super(useraccounts, iaccountmanagerresponse, account.type, false, true);
            mFeatures = as;
            mAccount = account;
        }
    }

    static class UserAccounts {

        private final HashMap accountCache;
        private HashMap authTokenCache;
        private final Object cacheLock;
        private final HashMap credentialsPermissionNotificationIds;
        private final DatabaseHelper openHelper;
        private final HashMap signinRequiredNotificationIds;
        private HashMap userDataCache;
        private final int userId;









        UserAccounts(Context context, int i) {
            credentialsPermissionNotificationIds = new HashMap();
            signinRequiredNotificationIds = new HashMap();
            cacheLock = new Object();
            accountCache = new LinkedHashMap();
            userDataCache = new HashMap();
            authTokenCache = new HashMap();
            userId = i;
            Object obj = cacheLock;
            obj;
            JVM INSTR monitorenter ;
            openHelper = new DatabaseHelper(context, i);
            return;
        }
    }

    static class Injector {

        static int checkSignatures(PackageManager packagemanager, int i, int j, String s) {
            int k;
            if(ExtraPackageManager.isTrustedAccountSignature(packagemanager, s, i, j))
                k = 0;
            else
                k = -3;
            return k;
        }

        Injector() {
        }
    }


    public AccountManagerService(Context context) {
        this(context, context.getPackageManager(), ((IAccountAuthenticatorCache) (new AccountAuthenticatorCache(context))));
    }

    public AccountManagerService(Context context, PackageManager packagemanager, IAccountAuthenticatorCache iaccountauthenticatorcache) {
        mSessions = new LinkedHashMap();
        mNotificationIds = new AtomicInteger(1);
        mUsers = new SparseArray();
        mContext = context;
        mPackageManager = packagemanager;
        mMessageThread = new HandlerThread("AccountManagerService");
        mMessageThread.start();
        mMessageHandler = new MessageHandler(mMessageThread.getLooper());
        mAuthenticatorCache = iaccountauthenticatorcache;
        mAuthenticatorCache.setListener(this, null);
        sThis.set(this);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentfilter.addDataScheme("package");
        mContext.registerReceiver(new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                purgeOldGrantsAll();
            }

            final AccountManagerService this$0;

             {
                this$0 = AccountManagerService.this;
                super();
            }
        }, intentfilter);
        IntentFilter intentfilter1 = new IntentFilter();
        intentfilter1.addAction("android.intent.action.USER_REMOVED");
        mContext.registerReceiver(new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                onUserRemoved(intent);
            }

            final AccountManagerService this$0;

             {
                this$0 = AccountManagerService.this;
                super();
            }
        }, intentfilter1);
    }

    private boolean addAccountInternal(UserAccounts useraccounts, Account account, String s, Bundle bundle) {
        if(account != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L3:
        return flag;
_L2:
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = useraccounts.openHelper.getWritableDatabase();
        sqlitedatabase.beginTransaction();
        String as[] = new String[2];
        as[0] = account.name;
        as[1] = account.type;
        if(DatabaseUtils.longForQuery(sqlitedatabase, "select count(*) from accounts WHERE name=? AND type=?", as) <= 0L)
            break MISSING_BLOCK_LABEL_124;
        Log.w("AccountManagerService", (new StringBuilder()).append("insertAccountIntoDatabase: ").append(account).append(", skipping since the account already exists").toString());
        flag = false;
        sqlitedatabase.endTransaction();
        obj;
        JVM INSTR monitorexit ;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        long l;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("name", account.name);
        contentvalues.put("type", account.type);
        contentvalues.put("password", s);
        l = sqlitedatabase.insert("accounts", "name", contentvalues);
        if(l >= 0L) goto _L5; else goto _L4
_L4:
        Log.w("AccountManagerService", (new StringBuilder()).append("insertAccountIntoDatabase: ").append(account).append(", skipping the DB insert failed").toString());
        flag = false;
        sqlitedatabase.endTransaction();
        obj;
        JVM INSTR monitorexit ;
          goto _L3
_L5:
        if(bundle == null) goto _L7; else goto _L6
_L6:
        Iterator iterator = bundle.keySet().iterator();
_L10:
        if(!iterator.hasNext()) goto _L7; else goto _L8
_L8:
        String s1 = (String)iterator.next();
        if(insertExtraLocked(sqlitedatabase, l, s1, bundle.getString(s1)) >= 0L) goto _L10; else goto _L9
_L9:
        Log.w("AccountManagerService", (new StringBuilder()).append("insertAccountIntoDatabase: ").append(account).append(", skipping since insertExtra failed for key ").append(s1).toString());
        flag = false;
        sqlitedatabase.endTransaction();
        obj;
        JVM INSTR monitorexit ;
          goto _L3
_L7:
        sqlitedatabase.setTransactionSuccessful();
        insertAccountIntoCacheLocked(useraccounts, account);
        sqlitedatabase.endTransaction();
        sendAccountsChangedBroadcast(useraccounts.userId);
        flag = true;
        obj;
        JVM INSTR monitorexit ;
          goto _L3
        Exception exception1;
        exception1;
        sqlitedatabase.endTransaction();
        throw exception1;
    }

    private void checkAuthenticateAccountsPermission(Account account) {
        String as[] = new String[1];
        as[0] = "android.permission.AUTHENTICATE_ACCOUNTS";
        checkBinderPermission(as);
        checkCallingUidAgainstAuthenticator(account);
    }

    private transient void checkBinderPermission(String as[]) {
        int i = Binder.getCallingUid();
        int j = as.length;
        for(int k = 0; k < j; k++) {
            String s1 = as[k];
            if(mContext.checkCallingOrSelfPermission(s1) == 0) {
                if(Log.isLoggable("AccountManagerService", 2))
                    Log.v("AccountManagerService", (new StringBuilder()).append("  caller uid ").append(i).append(" has ").append(s1).toString());
                return;
            }
        }

        String s = (new StringBuilder()).append("caller uid ").append(i).append(" lacks any of ").append(TextUtils.join(",", as)).toString();
        Log.w("AccountManagerService", (new StringBuilder()).append("  ").append(s).toString());
        throw new SecurityException(s);
    }

    private void checkCallingUidAgainstAuthenticator(Account account) {
        int i = Binder.getCallingUid();
        if(account == null || !hasAuthenticatorUid(account.type, i)) {
            String s = (new StringBuilder()).append("caller uid ").append(i).append(" is different than the authenticator's uid").toString();
            Log.w("AccountManagerService", s);
            throw new SecurityException(s);
        }
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("caller uid ").append(i).append(" is the same as the authenticator's uid").toString());
    }

    private void checkManageAccountsOrUseCredentialsPermissions() {
        String as[] = new String[2];
        as[0] = "android.permission.MANAGE_ACCOUNTS";
        as[1] = "android.permission.USE_CREDENTIALS";
        checkBinderPermission(as);
    }

    private void checkManageAccountsPermission() {
        String as[] = new String[1];
        as[0] = "android.permission.MANAGE_ACCOUNTS";
        checkBinderPermission(as);
    }

    private void checkReadAccountsPermission() {
        String as[] = new String[1];
        as[0] = "android.permission.GET_ACCOUNTS";
        checkBinderPermission(as);
    }

    private void createNoCredentialsPermissionNotification(Account account, Intent intent) {
        int i = intent.getIntExtra("uid", -1);
        String s = intent.getStringExtra("authTokenType");
        intent.getStringExtra("authTokenLabel");
        Notification notification = new Notification(0x108008a, null, 0L);
        Context context = mContext;
        Object aobj[] = new Object[1];
        aobj[0] = account.name;
        String s1 = context.getString(0x1040474, aobj);
        int j = s1.indexOf('\n');
        String s2 = s1;
        String s3 = "";
        if(j > 0) {
            s2 = s1.substring(0, j);
            s3 = s1.substring(j + 1);
        }
        notification.setLatestEventInfo(mContext, s2, s3, PendingIntent.getActivity(mContext, 0, intent, 0x10000000));
        installNotification(getCredentialPermissionNotificationId(account, s, i).intValue(), notification);
    }

    private void doNotification(UserAccounts useraccounts, Account account, CharSequence charsequence, Intent intent) {
        long l = clearCallingIdentity();
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("doNotification: ").append(charsequence).append(" intent:").append(intent).toString());
        if(intent.getComponent() == null || !android/accounts/GrantCredentialsPermissionActivity.getName().equals(intent.getComponent().getClassName())) goto _L2; else goto _L1
_L1:
        createNoCredentialsPermissionNotification(account, intent);
_L4:
        restoreCallingIdentity(l);
        return;
_L2:
        Integer integer = getSigninRequiredNotificationId(useraccounts, account);
        intent.addCategory(String.valueOf(integer));
        Notification notification = new Notification(0x108008a, null, 0L);
        String s = mContext.getText(0x104011f).toString();
        Context context = mContext;
        Object aobj[] = new Object[1];
        aobj[0] = account.name;
        notification.setLatestEventInfo(context, String.format(s, aobj), charsequence, PendingIntent.getActivity(mContext, 0, intent, 0x10000000));
        installNotification(integer.intValue(), notification);
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    private void dumpUser(UserAccounts useraccounts, FileDescriptor filedescriptor, PrintWriter printwriter, String as[], boolean flag) {
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = useraccounts.openHelper.getReadableDatabase();
        if(!flag) goto _L2; else goto _L1
_L1:
        Cursor cursor = sqlitedatabase.query("accounts", ACCOUNT_TYPE_COUNT_PROJECTION, null, null, "type", null, null);
        while(cursor.moveToNext()) 
            printwriter.println((new StringBuilder()).append(cursor.getString(0)).append(",").append(cursor.getString(1)).toString());
          goto _L3
        Exception exception2;
        exception2;
        if(cursor != null)
            cursor.close();
        throw exception2;
        Exception exception;
        exception;
        throw exception;
_L2:
        Account aaccount[] = getAccountsFromCacheLocked(useraccounts, null);
        printwriter.println((new StringBuilder()).append("Accounts: ").append(aaccount.length).toString());
        int i = aaccount.length;
        for(int j = 0; j < i; j++) {
            Account account = aaccount[j];
            printwriter.println((new StringBuilder()).append("  ").append(account).toString());
        }

        printwriter.println();
        LinkedHashMap linkedhashmap = mSessions;
        linkedhashmap;
        JVM INSTR monitorenter ;
        long l = SystemClock.elapsedRealtime();
        printwriter.println((new StringBuilder()).append("Active Sessions: ").append(mSessions.size()).toString());
        Session session;
        for(Iterator iterator = mSessions.values().iterator(); iterator.hasNext(); printwriter.println((new StringBuilder()).append("  ").append(session.toDebugString(l)).toString()))
            session = (Session)iterator.next();

        break MISSING_BLOCK_LABEL_333;
        Exception exception1;
        exception1;
        throw exception1;
        linkedhashmap;
        JVM INSTR monitorexit ;
        printwriter.println();
        mAuthenticatorCache.dump(filedescriptor, printwriter, as);
_L5:
        obj;
        JVM INSTR monitorexit ;
        return;
_L3:
        if(cursor != null)
            cursor.close();
        if(true) goto _L5; else goto _L4
_L4:
    }

    private long getAccountIdLocked(SQLiteDatabase sqlitedatabase, Account account) {
        Cursor cursor;
        String as[] = new String[1];
        as[0] = "_id";
        String as1[] = new String[2];
        as1[0] = account.name;
        as1[1] = account.type;
        cursor = sqlitedatabase.query("accounts", as, "name=? AND type=?", as1, null, null, null);
        if(!cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        long l1 = cursor.getLong(0);
        long l = l1;
_L4:
        cursor.close();
        return l;
_L2:
        l = -1L;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    private List getAllUsers() {
        List list1 = AppGlobals.getPackageManager().getUsers();
        List list = list1;
_L2:
        return list;
        RemoteException remoteexception;
        remoteexception;
        list = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private Integer getCredentialPermissionNotificationId(Account account, String s, int i) {
        UserAccounts useraccounts = getUserAccounts(UserId.getUserId(i));
        HashMap hashmap = useraccounts.credentialsPermissionNotificationIds;
        hashmap;
        JVM INSTR monitorenter ;
        Pair pair = new Pair(new Pair(account, s), Integer.valueOf(i));
        Integer integer = (Integer)useraccounts.credentialsPermissionNotificationIds.get(pair);
        if(integer == null) {
            integer = Integer.valueOf(mNotificationIds.incrementAndGet());
            useraccounts.credentialsPermissionNotificationIds.put(pair, integer);
        }
        return integer;
    }

    private static String getDatabaseName(int i) {
        File file = Environment.getSystemSecureDirectory();
        File file1 = new File(file, (new StringBuilder()).append("users/").append(i).append("/").append("accounts.db").toString());
        if(i == 0) {
            File file2 = new File(file, "accounts.db");
            if(file2.exists() && !file1.exists()) {
                File file3 = new File(file, (new StringBuilder()).append("users/").append(i).toString());
                if(!file3.exists() && !file3.mkdirs())
                    throw new IllegalStateException((new StringBuilder()).append("User dir cannot be created: ").append(file3).toString());
                if(!file2.renameTo(file1))
                    throw new IllegalStateException((new StringBuilder()).append("User dir cannot be migrated: ").append(file1).toString());
            }
        }
        return file1.getPath();
    }

    private long getExtrasIdLocked(SQLiteDatabase sqlitedatabase, long l, String s) {
        Cursor cursor;
        String as[] = new String[1];
        as[0] = "_id";
        String s1 = (new StringBuilder()).append("accounts_id=").append(l).append(" AND ").append("key").append("=?").toString();
        String as1[] = new String[1];
        as1[0] = s;
        cursor = sqlitedatabase.query("extras", as, s1, as1, null, null, null);
        if(!cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        long l2 = cursor.getLong(0);
        long l1 = l2;
_L4:
        cursor.close();
        return l1;
_L2:
        l1 = -1L;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    private Integer getSigninRequiredNotificationId(UserAccounts useraccounts, Account account) {
        HashMap hashmap = useraccounts.signinRequiredNotificationIds;
        hashmap;
        JVM INSTR monitorenter ;
        Integer integer = (Integer)useraccounts.signinRequiredNotificationIds.get(account);
        if(integer == null) {
            integer = Integer.valueOf(mNotificationIds.incrementAndGet());
            useraccounts.signinRequiredNotificationIds.put(account, integer);
        }
        return integer;
    }

    public static AccountManagerService getSingleton() {
        return (AccountManagerService)sThis.get();
    }

    private UserAccounts getUserAccountsForCaller() {
        return getUserAccounts(UserId.getCallingUserId());
    }

    private void grantAppPermission(Account account, String s, int i) {
        if(account != null && s != null) goto _L2; else goto _L1
_L1:
        Log.e("AccountManagerService", "grantAppPermission: called with invalid arguments", new Exception());
_L4:
        return;
_L2:
        UserAccounts useraccounts = getUserAccounts(UserId.getUserId(i));
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = useraccounts.openHelper.getWritableDatabase();
        sqlitedatabase.beginTransaction();
        long l = getAccountIdLocked(sqlitedatabase, account);
        if(l >= 0L) {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("accounts_id", Long.valueOf(l));
            contentvalues.put("auth_token_type", s);
            contentvalues.put("uid", Integer.valueOf(i));
            sqlitedatabase.insert("grants", "accounts_id", contentvalues);
            sqlitedatabase.setTransactionSuccessful();
        }
        sqlitedatabase.endTransaction();
        cancelNotification(getCredentialPermissionNotificationId(account, s, i).intValue());
        obj;
        JVM INSTR monitorexit ;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
        Exception exception1;
        exception1;
        sqlitedatabase.endTransaction();
        throw exception1;
    }

    private boolean hasAuthenticatorUid(String s, int i) {
        Iterator iterator = mAuthenticatorCache.getAllServices().iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        android.content.pm.RegisteredServicesCache.ServiceInfo serviceinfo = (android.content.pm.RegisteredServicesCache.ServiceInfo)iterator.next();
        if(!((AuthenticatorDescription)serviceinfo.type).type.equals(s)) goto _L4; else goto _L3
_L3:
        boolean flag;
        if(serviceinfo.uid == i || Injector.checkSignatures(mPackageManager, serviceinfo.uid, i, s) == 0)
            flag = true;
        else
            flag = false;
_L6:
        return flag;
_L2:
        flag = false;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private boolean hasExplicitlyGrantedPermission(Account account, String s, int i) {
        boolean flag = false;
        if(i != 1000) goto _L2; else goto _L1
_L1:
        flag = true;
_L4:
        return flag;
_L2:
        UserAccounts useraccounts = getUserAccountsForCaller();
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = useraccounts.openHelper.getReadableDatabase();
        String as[] = new String[4];
        as[0] = String.valueOf(i);
        as[1] = s;
        as[2] = account.name;
        as[3] = account.type;
        if(DatabaseUtils.longForQuery(sqlitedatabase, "SELECT COUNT(*) FROM grants, accounts WHERE accounts_id=_id AND uid=? AND auth_token_type=? AND name=? AND type=?", as) != 0L)
            flag = true;
        if(!flag && ActivityManager.isRunningInTestHarness()) {
            Log.d("AccountManagerService", (new StringBuilder()).append("no credentials permission for usage of ").append(account).append(", ").append(s).append(" by uid ").append(i).append(" but ignoring since device is in test harness.").toString());
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean inSystemImage(int i) {
        boolean flag;
        String as[];
        int j;
        int k;
        flag = false;
        as = mPackageManager.getPackagesForUid(i);
        j = as.length;
        k = 0;
_L4:
        String s;
        if(k >= j)
            break MISSING_BLOCK_LABEL_67;
        s = as[k];
        int l;
        PackageInfo packageinfo = mPackageManager.getPackageInfo(s, 0);
        if(packageinfo == null)
            break MISSING_BLOCK_LABEL_74;
        l = packageinfo.applicationInfo.flags;
        if((l & 1) == 0)
            break MISSING_BLOCK_LABEL_74;
        flag = true;
_L2:
        return flag;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if(true) goto _L2; else goto _L1
_L1:
        k++;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private UserAccounts initUser(int i) {
        SparseArray sparsearray = mUsers;
        sparsearray;
        JVM INSTR monitorenter ;
        UserAccounts useraccounts = (UserAccounts)mUsers.get(i);
        if(useraccounts == null) {
            useraccounts = new UserAccounts(mContext, i);
            mUsers.append(i, useraccounts);
            purgeOldGrants(useraccounts);
            validateAccountsAndPopulateCache(useraccounts);
        }
        return useraccounts;
    }

    private void insertAccountIntoCacheLocked(UserAccounts useraccounts, Account account) {
        Account aaccount[] = (Account[])useraccounts.accountCache.get(account.type);
        int i;
        Account aaccount1[];
        if(aaccount != null)
            i = aaccount.length;
        else
            i = 0;
        aaccount1 = new Account[i + 1];
        if(aaccount != null)
            System.arraycopy(aaccount, 0, aaccount1, 0, i);
        aaccount1[i] = account;
        useraccounts.accountCache.put(account.type, aaccount1);
    }

    private long insertExtraLocked(SQLiteDatabase sqlitedatabase, long l, String s, String s1) {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("key", s);
        contentvalues.put("accounts_id", Long.valueOf(l));
        contentvalues.put("value", s1);
        return sqlitedatabase.insert("extras", "key", contentvalues);
    }

    private void invalidateAuthTokenLocked(UserAccounts useraccounts, SQLiteDatabase sqlitedatabase, String s, String s1) {
        if(s1 != null && s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Cursor cursor;
        String as[] = new String[2];
        as[0] = s1;
        as[1] = s;
        cursor = sqlitedatabase.rawQuery("SELECT authtokens._id, accounts.name, authtokens.type FROM accounts JOIN authtokens ON accounts._id = accounts_id WHERE authtoken = ? AND accounts.type = ?", as);
        while(cursor.moveToNext())  {
            long l = cursor.getLong(0);
            String s2 = cursor.getString(1);
            String s3 = cursor.getString(2);
            sqlitedatabase.delete("authtokens", (new StringBuilder()).append("_id=").append(l).toString(), null);
            writeAuthTokenIntoCacheLocked(useraccounts, sqlitedatabase, new Account(s2, s), s3, null);
        }
        break MISSING_BLOCK_LABEL_141;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
        cursor.close();
        if(true) goto _L1; else goto _L3
_L3:
    }

    private Intent newGrantCredentialsPermissionIntent(Account account, int i, AccountAuthenticatorResponse accountauthenticatorresponse, String s, String s1) {
        Intent intent = new Intent(mContext, android/accounts/GrantCredentialsPermissionActivity);
        intent.setFlags(0x10000000);
        intent.addCategory(String.valueOf(getCredentialPermissionNotificationId(account, s, i)));
        intent.putExtra("account", account);
        intent.putExtra("authTokenType", s);
        intent.putExtra("response", accountauthenticatorresponse);
        intent.putExtra("uid", i);
        return intent;
    }

    private void onResult(IAccountManagerResponse iaccountmanagerresponse, Bundle bundle) {
        if(bundle == null)
            Log.e("AccountManagerService", "the result is unexpectedly null", new Exception());
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append(getClass().getSimpleName()).append(" calling onResult() on response ").append(iaccountmanagerresponse).toString());
        iaccountmanagerresponse.onResult(bundle);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", "failure while notifying response", remoteexception);
          goto _L1
    }

    private void onUserRemoved(Intent intent) {
        int i = intent.getIntExtra("android.intent.extra.user_id", -1);
        if(i >= 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        UserAccounts useraccounts;
        synchronized(mUsers) {
            useraccounts = (UserAccounts)mUsers.get(i);
            mUsers.remove(i);
        }
        if(useraccounts == null) {
            (new File(getDatabaseName(i))).delete();
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_76;
        exception;
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        useraccounts.openHelper.close();
        (new File(getDatabaseName(i))).delete();
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean permissionIsGranted(Account account, String s, int i) {
        boolean flag = false;
        boolean flag1 = inSystemImage(i);
        boolean flag2;
        boolean flag3;
        if(account != null && hasAuthenticatorUid(account.type, i))
            flag2 = true;
        else
            flag2 = false;
        if(account != null && hasExplicitlyGrantedPermission(account, s, i))
            flag3 = true;
        else
            flag3 = false;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("checkGrantsOrCallingUidAgainstAuthenticator: caller uid ").append(i).append(", ").append(account).append(": is authenticator? ").append(flag2).append(", has explicit permission? ").append(flag3).toString());
        if(flag2 || flag3 || flag1)
            flag = true;
        return flag;
    }

    private void purgeOldGrants(UserAccounts useraccounts) {
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        Cursor cursor;
        sqlitedatabase = useraccounts.openHelper.getWritableDatabase();
        String as[] = new String[1];
        as[0] = "uid";
        cursor = sqlitedatabase.query("grants", as, null, null, "uid", null, null);
_L7:
        if(!cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        int i = cursor.getInt(0);
        if(mPackageManager.getPackagesForUid(i) == null) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L5:
        if(!flag) {
            Log.d("AccountManagerService", (new StringBuilder()).append("deleting grants for UID ").append(i).append(" because its package is no longer installed").toString());
            String as1[] = new String[1];
            as1[0] = Integer.toString(i);
            sqlitedatabase.delete("grants", "uid=?", as1);
        }
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        cursor.close();
        throw exception1;
        Exception exception;
        exception;
        throw exception;
_L4:
        flag = false;
        if(true) goto _L5; else goto _L2
_L2:
        cursor.close();
        obj;
        JVM INSTR monitorexit ;
        return;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private void purgeOldGrantsAll() {
        SparseArray sparsearray = mUsers;
        sparsearray;
        JVM INSTR monitorenter ;
        for(int i = 0; i < mUsers.size(); i++)
            purgeOldGrants((UserAccounts)mUsers.valueAt(i));

        return;
    }

    private String readPasswordInternal(UserAccounts useraccounts, Account account) {
        if(account != null) goto _L2; else goto _L1
_L1:
        String s = null;
_L3:
        return s;
_L2:
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        Cursor cursor;
        SQLiteDatabase sqlitedatabase = useraccounts.openHelper.getReadableDatabase();
        String as[] = new String[1];
        as[0] = "password";
        String as1[] = new String[2];
        as1[0] = account.name;
        as1[1] = account.type;
        cursor = sqlitedatabase.query("accounts", as, "name=? AND type=?", as1, null, null, null);
        String s1;
        if(!cursor.moveToNext())
            break MISSING_BLOCK_LABEL_122;
        s1 = cursor.getString(0);
        s = s1;
        cursor.close();
        obj;
        JVM INSTR monitorexit ;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        cursor.close();
        obj;
        JVM INSTR monitorexit ;
        s = null;
          goto _L3
        Exception exception1;
        exception1;
        cursor.close();
        throw exception1;
    }

    private void removeAccountFromCacheLocked(UserAccounts useraccounts, Account account) {
        Account aaccount[] = (Account[])useraccounts.accountCache.get(account.type);
        if(aaccount != null) {
            ArrayList arraylist = new ArrayList();
            int i = aaccount.length;
            for(int j = 0; j < i; j++) {
                Account account1 = aaccount[j];
                if(!account1.equals(account))
                    arraylist.add(account1);
            }

            if(arraylist.isEmpty()) {
                useraccounts.accountCache.remove(account.type);
            } else {
                Account aaccount1[] = (Account[])arraylist.toArray(new Account[arraylist.size()]);
                useraccounts.accountCache.put(account.type, aaccount1);
            }
        }
        useraccounts.userDataCache.remove(account);
        useraccounts.authTokenCache.remove(account);
    }

    private void removeAccountInternal(UserAccounts useraccounts, Account account) {
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase = useraccounts.openHelper.getWritableDatabase();
        String as[] = new String[2];
        as[0] = account.name;
        as[1] = account.type;
        sqlitedatabase.delete("accounts", "name=? AND type=?", as);
        removeAccountFromCacheLocked(useraccounts, account);
        sendAccountsChangedBroadcast(useraccounts.userId);
        return;
    }

    private void revokeAppPermission(Account account, String s, int i) {
        if(account != null && s != null) goto _L2; else goto _L1
_L1:
        Log.e("AccountManagerService", "revokeAppPermission: called with invalid arguments", new Exception());
_L4:
        return;
_L2:
        UserAccounts useraccounts = getUserAccounts(UserId.getUserId(i));
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = useraccounts.openHelper.getWritableDatabase();
        sqlitedatabase.beginTransaction();
        long l = getAccountIdLocked(sqlitedatabase, account);
        if(l >= 0L) {
            String as[] = new String[3];
            as[0] = String.valueOf(l);
            as[1] = s;
            as[2] = String.valueOf(i);
            sqlitedatabase.delete("grants", "accounts_id=? AND auth_token_type=? AND uid=?", as);
            sqlitedatabase.setTransactionSuccessful();
        }
        sqlitedatabase.endTransaction();
        cancelNotification(getCredentialPermissionNotificationId(account, s, i).intValue());
        obj;
        JVM INSTR monitorexit ;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
        Exception exception1;
        exception1;
        sqlitedatabase.endTransaction();
        throw exception1;
    }

    private boolean saveAuthTokenToDatabase(UserAccounts useraccounts, Account account, String s, String s1) {
        if(account != null && s != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L3:
        return flag;
_L2:
        cancelNotification(getSigninRequiredNotificationId(useraccounts, account).intValue());
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = useraccounts.openHelper.getWritableDatabase();
        sqlitedatabase.beginTransaction();
        long l = getAccountIdLocked(sqlitedatabase, account);
        if(l >= 0L)
            break MISSING_BLOCK_LABEL_88;
        flag = false;
        sqlitedatabase.endTransaction();
          goto _L3
        Exception exception;
        exception;
        throw exception;
        ContentValues contentvalues;
        String s2 = (new StringBuilder()).append("accounts_id=").append(l).append(" AND ").append("type").append("=?").toString();
        String as[] = new String[1];
        as[0] = s;
        sqlitedatabase.delete("authtokens", s2, as);
        contentvalues = new ContentValues();
        contentvalues.put("accounts_id", Long.valueOf(l));
        contentvalues.put("type", s);
        contentvalues.put("authtoken", s1);
        if(sqlitedatabase.insert("authtokens", "authtoken", contentvalues) < 0L) goto _L5; else goto _L4
_L4:
        sqlitedatabase.setTransactionSuccessful();
        writeAuthTokenIntoCacheLocked(useraccounts, sqlitedatabase, account, s, s1);
        flag = true;
        sqlitedatabase.endTransaction();
        obj;
        JVM INSTR monitorexit ;
          goto _L3
_L5:
        flag = false;
        sqlitedatabase.endTransaction();
        obj;
        JVM INSTR monitorexit ;
          goto _L3
        Exception exception1;
        exception1;
        sqlitedatabase.endTransaction();
        throw exception1;
    }

    private static boolean scanArgs(String as[], String s) {
        int i;
        int j;
        if(as == null)
            break MISSING_BLOCK_LABEL_37;
        i = as.length;
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_37;
        if(!s.equals(as[j])) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = false;
          goto _L4
    }

    private void sendAccountsChangedBroadcast(int i) {
        Log.i("AccountManagerService", (new StringBuilder()).append("the accounts changed, sending broadcast of ").append(ACCOUNTS_CHANGED_INTENT.getAction()).toString());
        mContext.sendBroadcast(ACCOUNTS_CHANGED_INTENT, i);
    }

    private void setPasswordInternal(UserAccounts useraccounts, Account account, String s) {
        if(account != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = useraccounts.openHelper.getWritableDatabase();
        sqlitedatabase.beginTransaction();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("password", s);
        long l = getAccountIdLocked(sqlitedatabase, account);
        if(l >= 0L) {
            String as[] = new String[1];
            as[0] = String.valueOf(l);
            sqlitedatabase.update("accounts", contentvalues, "_id=?", as);
            sqlitedatabase.delete("authtokens", "accounts_id=?", as);
            useraccounts.authTokenCache.remove(account);
            sqlitedatabase.setTransactionSuccessful();
        }
        sqlitedatabase.endTransaction();
        sendAccountsChangedBroadcast(useraccounts.userId);
        obj;
        JVM INSTR monitorexit ;
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
        Exception exception1;
        exception1;
        sqlitedatabase.endTransaction();
        throw exception1;
    }

    private void setUserdataInternal(UserAccounts useraccounts, Account account, String s, String s1) {
        if(account != null && s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = useraccounts.openHelper.getWritableDatabase();
        sqlitedatabase.beginTransaction();
        long l = getAccountIdLocked(sqlitedatabase, account);
        if(l >= 0L)
            break MISSING_BLOCK_LABEL_67;
        sqlitedatabase.endTransaction();
          goto _L1
        Exception exception;
        exception;
        throw exception;
        long l1 = getExtrasIdLocked(sqlitedatabase, l, s);
        if(l1 >= 0L) goto _L4; else goto _L3
_L3:
        long l2 = insertExtraLocked(sqlitedatabase, l, s, s1);
        if(l2 >= 0L) goto _L6; else goto _L5
_L5:
        sqlitedatabase.endTransaction();
        obj;
        JVM INSTR monitorexit ;
          goto _L1
_L4:
        int i;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("value", s1);
        i = sqlitedatabase.update("extras", contentvalues, (new StringBuilder()).append("_id=").append(l1).toString(), null);
        if(1 == i) goto _L6; else goto _L7
_L7:
        sqlitedatabase.endTransaction();
        obj;
        JVM INSTR monitorexit ;
          goto _L1
_L6:
        writeUserDataIntoCacheLocked(useraccounts, sqlitedatabase, account, s, s1);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception1;
        exception1;
        sqlitedatabase.endTransaction();
        throw exception1;
    }

    private static final String stringArrayToString(String as[]) {
        String s;
        if(as != null)
            s = (new StringBuilder()).append("[").append(TextUtils.join(",", as)).append("]").toString();
        else
            s = null;
        return s;
    }

    private void validateAccountsAndPopulateCache(UserAccounts useraccounts) {
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        boolean flag;
        Cursor cursor;
        sqlitedatabase = useraccounts.openHelper.getWritableDatabase();
        flag = false;
        String as[] = new String[3];
        as[0] = "_id";
        as[1] = "type";
        as[2] = "name";
        cursor = sqlitedatabase.query("accounts", as, null, null, null, null, null);
        LinkedHashMap linkedhashmap;
        useraccounts.accountCache.clear();
        linkedhashmap = new LinkedHashMap();
_L1:
        String s1;
        String s2;
        do {
            if(!cursor.moveToNext())
                break MISSING_BLOCK_LABEL_322;
            long l = cursor.getLong(0);
            s1 = cursor.getString(1);
            s2 = cursor.getString(2);
            if(mAuthenticatorCache.getServiceInfo(AuthenticatorDescription.newKey(s1)) != null)
                break MISSING_BLOCK_LABEL_275;
            Log.d("AccountManagerService", (new StringBuilder()).append("deleting account ").append(s2).append(" because type ").append(s1).append(" no longer has a registered authenticator").toString());
            sqlitedatabase.delete("accounts", (new StringBuilder()).append("_id=").append(l).toString(), null);
            flag = true;
            Account account = new Account(s2, s1);
            useraccounts.userDataCache.remove(account);
            useraccounts.authTokenCache.remove(account);
        } while(true);
        Exception exception1;
        exception1;
        cursor.close();
        if(flag)
            sendAccountsChangedBroadcast(useraccounts.userId);
        throw exception1;
        Exception exception;
        exception;
        throw exception;
        ArrayList arraylist1 = (ArrayList)linkedhashmap.get(s1);
        if(arraylist1 == null) {
            arraylist1 = new ArrayList();
            linkedhashmap.put(s1, arraylist1);
        }
        arraylist1.add(s2);
          goto _L1
        String s;
        Account aaccount[];
        for(Iterator iterator = linkedhashmap.entrySet().iterator(); iterator.hasNext(); useraccounts.accountCache.put(s, aaccount)) {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            s = (String)entry.getKey();
            ArrayList arraylist = (ArrayList)entry.getValue();
            aaccount = new Account[arraylist.size()];
            int i = 0;
            for(Iterator iterator1 = arraylist.iterator(); iterator1.hasNext();) {
                aaccount[i] = new Account((String)iterator1.next(), s);
                i++;
            }

        }

        cursor.close();
        if(flag)
            sendAccountsChangedBroadcast(useraccounts.userId);
        obj;
        JVM INSTR monitorexit ;
    }

    public boolean addAccount(Account account, String s, Bundle bundle) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("addAccount: ").append(account).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(account == null)
            throw new IllegalArgumentException("account is null");
        checkAuthenticateAccountsPermission(account);
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        boolean flag = addAccountInternal(useraccounts, account, s, bundle);
        restoreCallingIdentity(l);
        return flag;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void addAcount(final IAccountManagerResponse final_iaccountmanagerresponse, final String final_s, String s, String as[], final boolean final_flag, Bundle bundle) {
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("addAccount: accountType ").append(final_s).append(", response ").append(final_iaccountmanagerresponse).append(", authTokenType ").append(s).append(", requiredFeatures ").append(stringArrayToString(as)).append(", expectActivityLaunch ").append(final_flag).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(final_iaccountmanagerresponse == null)
            throw new IllegalArgumentException("response is null");
        if(final_s == null)
            throw new IllegalArgumentException("accountType is null");
        checkManageAccountsPermission();
        final UserAccounts final_useraccounts = getUserAccountsForCaller();
        int i = Binder.getCallingPid();
        int j = Binder.getCallingUid();
        Bundle bundle1;
        if(bundle == null)
            bundle1 = new Bundle();
        else
            bundle1 = bundle;
        bundle1.putInt("callerUid", j);
        bundle1.putInt("callerPid", i);
        l = clearCallingIdentity();
        (new Session(true, s, as, bundle1, final_s) {

            public void run() throws RemoteException {
                super.mAuthenticator.addAccount(this, super.mAccountType, authTokenType, requiredFeatures, options);
            }

            protected String toDebugString(long l1) {
                StringBuilder stringbuilder = (new StringBuilder()).append(super.toDebugString(l1)).append(", addAccount").append(", accountType ").append(accountType).append(", requiredFeatures ");
                String s1;
                if(requiredFeatures != null)
                    s1 = TextUtils.join(",", requiredFeatures);
                else
                    s1 = null;
                return stringbuilder.append(s1).toString();
            }

            final AccountManagerService this$0;
            final String val$accountType;
            final String val$authTokenType;
            final Bundle val$options;
            final String val$requiredFeatures[];

             {
                this$0 = AccountManagerService.this;
                authTokenType = s1;
                requiredFeatures = as;
                options = bundle;
                accountType = s2;
                super(final_useraccounts, final_iaccountmanagerresponse, final_s, final_flag, flag1);
            }
        }).bind();
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    protected void cancelNotification(int i) {
        long l = clearCallingIdentity();
        ((NotificationManager)mContext.getSystemService("notification")).cancel(i);
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void clearPassword(Account account) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("clearPassword: ").append(account).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(account == null)
            throw new IllegalArgumentException("account is null");
        checkManageAccountsPermission();
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        setPasswordInternal(useraccounts, account, null);
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void confirmCredentials(final IAccountManagerResponse final_iaccountmanagerresponse, Account account, Bundle bundle, boolean flag) {
        final UserAccounts final_useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("confirmCredentials: ").append(account).append(", response ").append(final_iaccountmanagerresponse).append(", expectActivityLaunch ").append(flag).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(final_iaccountmanagerresponse == null)
            throw new IllegalArgumentException("response is null");
        if(account == null)
            throw new IllegalArgumentException("account is null");
        checkManageAccountsPermission();
        final_useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        (new Session(account.type, flag, true, account, bundle) {

            public void run() throws RemoteException {
                super.mAuthenticator.confirmCredentials(this, account, options);
            }

            protected String toDebugString(long l1) {
                return (new StringBuilder()).append(super.toDebugString(l1)).append(", confirmCredentials").append(", ").append(account).toString();
            }

            final AccountManagerService this$0;
            final Account val$account;
            final Bundle val$options;

             {
                this$0 = AccountManagerService.this;
                account = account1;
                options = bundle;
                super(final_useraccounts, final_iaccountmanagerresponse, s, flag, flag1);
            }
        }).bind();
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    protected void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        if(mContext.checkCallingOrSelfPermission("android.permission.DUMP") != 0) {
            printwriter.println((new StringBuilder()).append("Permission Denial: can't dump AccountsManager from from pid=").append(Binder.getCallingPid()).append(", uid=").append(Binder.getCallingUid()).append(" without permission ").append("android.permission.DUMP").toString());
        } else {
            boolean flag;
            IndentingPrintWriter indentingprintwriter;
            int i;
            int j;
            if(scanArgs(as, "--checkin") || scanArgs(as, "-c"))
                flag = true;
            else
                flag = false;
            indentingprintwriter = new IndentingPrintWriter(printwriter, "  ");
            i = mUsers.size();
            j = 0;
            while(j < i)  {
                indentingprintwriter.println((new StringBuilder()).append("User ").append(mUsers.keyAt(j)).append(":").toString());
                ((IndentingPrintWriter)indentingprintwriter).increaseIndent();
                dumpUser((UserAccounts)mUsers.valueAt(j), filedescriptor, indentingprintwriter, as, flag);
                ((IndentingPrintWriter)indentingprintwriter).decreaseIndent();
                if(j < i - 1)
                    indentingprintwriter.println();
                j++;
            }
        }
    }

    public void editProperties(IAccountManagerResponse iaccountmanagerresponse, String s, boolean flag) {
        final UserAccounts final_useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("editProperties: accountType ").append(s).append(", response ").append(iaccountmanagerresponse).append(", expectActivityLaunch ").append(flag).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(iaccountmanagerresponse == null)
            throw new IllegalArgumentException("response is null");
        if(s == null)
            throw new IllegalArgumentException("accountType is null");
        checkManageAccountsPermission();
        final_useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        (new Session(iaccountmanagerresponse, s, flag, true, s) {

            public void run() throws RemoteException {
                super.mAuthenticator.editProperties(this, super.mAccountType);
            }

            protected String toDebugString(long l1) {
                return (new StringBuilder()).append(super.toDebugString(l1)).append(", editProperties").append(", accountType ").append(accountType).toString();
            }

            final AccountManagerService this$0;
            final String val$accountType;

             {
                this$0 = AccountManagerService.this;
                accountType = s1;
                super(final_useraccounts, iaccountmanagerresponse, s, flag, flag1);
            }
        }).bind();
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    String getAccountLabel(String s) {
        android.content.pm.RegisteredServicesCache.ServiceInfo serviceinfo = mAuthenticatorCache.getServiceInfo(AuthenticatorDescription.newKey(s));
        if(serviceinfo == null)
            throw new IllegalArgumentException((new StringBuilder()).append("unknown account type: ").append(s).toString());
        Context context;
        String s1;
        try {
            context = mContext.createPackageContext(((AuthenticatorDescription)serviceinfo.type).packageName, 0);
        }
        catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
            throw new IllegalArgumentException((new StringBuilder()).append("unknown account type: ").append(s).toString());
        }
        try {
            s1 = context.getString(((AuthenticatorDescription)serviceinfo.type).labelId);
        }
        catch(android.content.res.Resources.NotFoundException notfoundexception) {
            throw new IllegalArgumentException((new StringBuilder()).append("unknown account type: ").append(s).toString());
        }
        return s1;
    }

    public Account[] getAccounts(int i) {
        UserAccounts useraccounts;
        long l;
        checkReadAccountsPermission();
        useraccounts = getUserAccounts(i);
        l = clearCallingIdentity();
        Account aaccount[];
        synchronized(useraccounts.cacheLock) {
            aaccount = getAccountsFromCacheLocked(useraccounts, null);
        }
        restoreCallingIdentity(l);
        return aaccount;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public Account[] getAccounts(String s) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("getAccounts: accountType ").append(s).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        checkReadAccountsPermission();
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        Account aaccount[];
        synchronized(useraccounts.cacheLock) {
            aaccount = getAccountsFromCacheLocked(useraccounts, s);
        }
        restoreCallingIdentity(l);
        return aaccount;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void getAccountsByFeatures(IAccountManagerResponse iaccountmanagerresponse, String s, String as[]) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("getAccounts: accountType ").append(s).append(", response ").append(iaccountmanagerresponse).append(", features ").append(stringArrayToString(as)).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(iaccountmanagerresponse == null)
            throw new IllegalArgumentException("response is null");
        if(s == null)
            throw new IllegalArgumentException("accountType is null");
        checkReadAccountsPermission();
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        if(as == null)
            break MISSING_BLOCK_LABEL_136;
        if(as.length != 0)
            break MISSING_BLOCK_LABEL_207;
        Account aaccount[];
        synchronized(useraccounts.cacheLock) {
            aaccount = getAccountsFromCacheLocked(useraccounts, s);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArray("accounts", aaccount);
        onResult(iaccountmanagerresponse, bundle);
_L1:
        restoreCallingIdentity(l);
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
        (new GetAccountsByTypeAndFeatureSession(useraccounts, iaccountmanagerresponse, s, as)).bind();
          goto _L1
    }

    protected Account[] getAccountsFromCacheLocked(UserAccounts useraccounts, String s) {
        Account aaccount1[];
        if(s != null) {
            Account aaccount3[] = (Account[])useraccounts.accountCache.get(s);
            if(aaccount3 == null)
                aaccount1 = EMPTY_ACCOUNT_ARRAY;
            else
                aaccount1 = (Account[])Arrays.copyOf(aaccount3, aaccount3.length);
        } else {
            int i = 0;
            for(Iterator iterator = useraccounts.accountCache.values().iterator(); iterator.hasNext();)
                i += ((Account[])iterator.next()).length;

            if(i == 0) {
                aaccount1 = EMPTY_ACCOUNT_ARRAY;
            } else {
                Account aaccount[] = new Account[i];
                int j = 0;
                for(Iterator iterator1 = useraccounts.accountCache.values().iterator(); iterator1.hasNext();) {
                    Account aaccount2[] = (Account[])iterator1.next();
                    System.arraycopy(aaccount2, 0, aaccount, j, aaccount2.length);
                    j += aaccount2.length;
                }

                aaccount1 = aaccount;
            }
        }
        return aaccount1;
    }

    public AccountAndUser[] getAllAccounts() {
        ArrayList arraylist;
        List list;
        arraylist = new ArrayList();
        list = getAllUsers();
        if(list != null) goto _L2; else goto _L1
_L1:
        AccountAndUser aaccountanduser[] = new AccountAndUser[0];
_L5:
        return aaccountanduser;
_L2:
        SparseArray sparsearray = mUsers;
        sparsearray;
        JVM INSTR monitorenter ;
        Iterator iterator = list.iterator();
_L3:
        UserInfo userinfo;
        UserAccounts useraccounts;
        do {
            if(!iterator.hasNext())
                break MISSING_BLOCK_LABEL_158;
            userinfo = (UserInfo)iterator.next();
            useraccounts = getUserAccounts(userinfo.id);
        } while(useraccounts == null);
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        Account aaccount[] = getAccountsFromCacheLocked(useraccounts, null);
        for(int i = 0; i < aaccount.length; i++)
            arraylist.add(new AccountAndUser(aaccount[i], userinfo.id));

        obj;
        JVM INSTR monitorexit ;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        sparsearray;
        JVM INSTR monitorexit ;
        aaccountanduser = (AccountAndUser[])arraylist.toArray(new AccountAndUser[arraylist.size()]);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void getAuthToken(final IAccountManagerResponse final_iaccountmanagerresponse, Account account, String s, boolean flag, boolean flag1, Bundle bundle) {
        final UserAccounts final_useraccounts;
        boolean flag2;
        int i;
        boolean flag3;
        Bundle bundle1;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("getAuthToken: ").append(account).append(", response ").append(final_iaccountmanagerresponse).append(", authTokenType ").append(s).append(", notifyOnAuthFailure ").append(flag).append(", expectActivityLaunch ").append(flag1).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(final_iaccountmanagerresponse == null)
            throw new IllegalArgumentException("response is null");
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(s == null)
            throw new IllegalArgumentException("authTokenType is null");
        String as[] = new String[1];
        as[0] = "android.permission.USE_CREDENTIALS";
        checkBinderPermission(as);
        final_useraccounts = getUserAccountsForCaller();
        android.content.pm.RegisteredServicesCache.ServiceInfo serviceinfo = mAuthenticatorCache.getServiceInfo(AuthenticatorDescription.newKey(account.type));
        String s1;
        Bundle bundle2;
        if(serviceinfo != null && ((AuthenticatorDescription)serviceinfo.type).customTokens)
            flag2 = true;
        else
            flag2 = false;
        i = Binder.getCallingUid();
        if(flag2 || permissionIsGranted(account, s, i))
            flag3 = true;
        else
            flag3 = false;
        if(bundle == null)
            bundle1 = new Bundle();
        else
            bundle1 = bundle;
        bundle1.putInt("callerUid", i);
        bundle1.putInt("callerPid", Binder.getCallingPid());
        if(flag)
            bundle1.putBoolean("notifyOnAuthFailure", true);
        l = clearCallingIdentity();
        if(flag2 || !flag3) goto _L2; else goto _L1
_L1:
        s1 = readAuthTokenInternal(final_useraccounts, account, s);
        if(s1 == null) goto _L2; else goto _L3
_L3:
        bundle2 = new Bundle();
        bundle2.putString("authtoken", s1);
        bundle2.putString("authAccount", account.name);
        bundle2.putString("accountType", account.type);
        onResult(final_iaccountmanagerresponse, bundle2);
_L5:
        restoreCallingIdentity(l);
        return;
_L2:
        (new Session(s, flag, flag3, i, flag2) {

            public void onResult(Bundle bundle3) {
                if(bundle3 == null) goto _L2; else goto _L1
_L1:
                if(!bundle3.containsKey("authTokenLabelKey")) goto _L4; else goto _L3
_L3:
                Intent intent1 = newGrantCredentialsPermissionIntent(account, callerUid, new AccountAuthenticatorResponse(this), authTokenType, bundle3.getString("authTokenLabelKey"));
                Bundle bundle4 = new Bundle();
                bundle4.putParcelable("intent", intent1);
                onResult(bundle4);
_L6:
                return;
_L4:
                String s2 = bundle3.getString("authtoken");
                if(s2 != null) {
                    String s3 = bundle3.getString("authAccount");
                    String s4 = bundle3.getString("accountType");
                    if(TextUtils.isEmpty(s4) || TextUtils.isEmpty(s3)) {
                        onError(5, "the type and name should not be empty");
                        continue; /* Loop/switch isn't completed */
                    }
                    if(!customTokens)
                        saveAuthTokenToDatabase(super.mAccounts, new Account(s3, s4), authTokenType, s2);
                }
                Intent intent = (Intent)bundle3.getParcelable("intent");
                if(intent != null && notifyOnAuthFailure && !customTokens)
                    doNotification(super.mAccounts, account, bundle3.getString("authFailedMessage"), intent);
_L2:
                super.onResult(bundle3);
                if(true) goto _L6; else goto _L5
_L5:
            }

            public void run() throws RemoteException {
                if(!permissionGranted)
                    super.mAuthenticator.getAuthTokenLabel(this, authTokenType);
                else
                    super.mAuthenticator.getAuthToken(this, account, authTokenType, loginOptions);
            }

            protected String toDebugString(long l1) {
                if(loginOptions != null)
                    loginOptions.keySet();
                return (new StringBuilder()).append(super.toDebugString(l1)).append(", getAuthToken").append(", ").append(account).append(", authTokenType ").append(authTokenType).append(", loginOptions ").append(loginOptions).append(", notifyOnAuthFailure ").append(notifyOnAuthFailure).toString();
            }

            final AccountManagerService this$0;
            final Account val$account;
            final String val$authTokenType;
            final int val$callerUid;
            final boolean val$customTokens;
            final Bundle val$loginOptions;
            final boolean val$notifyOnAuthFailure;
            final boolean val$permissionGranted;

             {
                this$0 = AccountManagerService.this;
                loginOptions = bundle;
                account = account1;
                authTokenType = s1;
                notifyOnAuthFailure = flag2;
                permissionGranted = flag3;
                callerUid = i;
                customTokens = flag4;
                super(final_useraccounts, final_iaccountmanagerresponse, final_s, final_flag, final_flag1);
            }
        }).bind();
        if(true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void getAuthTokenLabel(final IAccountManagerResponse final_iaccountmanagerresponse, String s, String s1) throws RemoteException {
        final UserAccounts final_useraccounts;
        long l;
        if(s == null)
            throw new IllegalArgumentException("accountType is null");
        if(s1 == null)
            throw new IllegalArgumentException("authTokenType is null");
        int i = getCallingUid();
        clearCallingIdentity();
        if(i != 1000)
            throw new SecurityException("can only call from system");
        final_useraccounts = getUserAccounts(UserId.getUserId(i));
        l = clearCallingIdentity();
        (new Session(s, false, false, s, s1) {

            public void onResult(Bundle bundle) {
                if(bundle != null) {
                    String s2 = bundle.getString("authTokenLabelKey");
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("authTokenLabelKey", s2);
                    super.onResult(bundle1);
                } else {
                    super.onResult(bundle);
                }
            }

            public void run() throws RemoteException {
                super.mAuthenticator.getAuthTokenLabel(this, authTokenType);
            }

            protected String toDebugString(long l1) {
                return (new StringBuilder()).append(super.toDebugString(l1)).append(", getAuthTokenLabel").append(", ").append(accountType).append(", authTokenType ").append(authTokenType).toString();
            }

            final AccountManagerService this$0;
            final String val$accountType;
            final String val$authTokenType;

             {
                this$0 = AccountManagerService.this;
                accountType = s1;
                authTokenType = s2;
                super(final_useraccounts, final_iaccountmanagerresponse, s, flag, flag1);
            }
        }).bind();
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public AuthenticatorDescription[] getAuthenticatorTypes() {
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("getAuthenticatorTypes: caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        l = clearCallingIdentity();
        AuthenticatorDescription aauthenticatordescription[];
        int i;
        Iterator iterator;
        Collection collection = mAuthenticatorCache.getAllServices();
        aauthenticatordescription = new AuthenticatorDescription[collection.size()];
        i = 0;
        iterator = collection.iterator();
_L1:
        if(!iterator.hasNext())
            break MISSING_BLOCK_LABEL_132;
        aauthenticatordescription[i] = (AuthenticatorDescription)((android.content.pm.RegisteredServicesCache.ServiceInfo)iterator.next()).type;
        i++;
          goto _L1
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
        restoreCallingIdentity(l);
        return aauthenticatordescription;
    }

    public String getPassword(Account account) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("getPassword: ").append(account).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(account == null)
            throw new IllegalArgumentException("account is null");
        checkAuthenticateAccountsPermission(account);
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        String s = readPasswordInternal(useraccounts, account);
        restoreCallingIdentity(l);
        return s;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    protected UserAccounts getUserAccounts(int i) {
        SparseArray sparsearray = mUsers;
        sparsearray;
        JVM INSTR monitorenter ;
        UserAccounts useraccounts = (UserAccounts)mUsers.get(i);
        if(useraccounts == null) {
            useraccounts = initUser(i);
            mUsers.append(i, useraccounts);
        }
        return useraccounts;
    }

    public String getUserData(Account account, String s) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("getUserData: ").append(account).append(", key ").append(s).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(s == null)
            throw new IllegalArgumentException("key is null");
        checkAuthenticateAccountsPermission(account);
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        String s1 = readUserDataInternal(useraccounts, account, s);
        restoreCallingIdentity(l);
        return s1;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void hasFeatures(IAccountManagerResponse iaccountmanagerresponse, Account account, String as[]) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("hasFeatures: ").append(account).append(", response ").append(iaccountmanagerresponse).append(", features ").append(stringArrayToString(as)).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(iaccountmanagerresponse == null)
            throw new IllegalArgumentException("response is null");
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(as == null)
            throw new IllegalArgumentException("features is null");
        checkReadAccountsPermission();
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        (new TestFeaturesSession(useraccounts, iaccountmanagerresponse, account, as)).bind();
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    protected void installNotification(int i, Notification notification) {
        ((NotificationManager)mContext.getSystemService("notification")).notify(i, notification);
    }

    public void invalidateAuthToken(String s, String s1) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("invalidateAuthToken: accountType ").append(s).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(s == null)
            throw new IllegalArgumentException("accountType is null");
        if(s1 == null)
            throw new IllegalArgumentException("authToken is null");
        checkManageAccountsOrUseCredentialsPermissions();
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = useraccounts.openHelper.getWritableDatabase();
        sqlitedatabase.beginTransaction();
        invalidateAuthTokenLocked(useraccounts, sqlitedatabase, s, s1);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        obj;
        JVM INSTR monitorexit ;
        restoreCallingIdentity(l);
        return;
        Exception exception2;
        exception2;
        sqlitedatabase.endTransaction();
        throw exception2;
        Exception exception1;
        exception1;
        throw exception1;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public IBinder onBind(Intent intent) {
        return asBinder();
    }

    public void onServiceChanged(AuthenticatorDescription authenticatordescription, boolean flag) {
        List list = getAllUsers();
        if(list == null) {
            validateAccountsAndPopulateCache(getUserAccountsForCaller());
        } else {
            Iterator iterator = list.iterator();
            while(iterator.hasNext()) 
                validateAccountsAndPopulateCache(getUserAccounts(((UserInfo)iterator.next()).id));
        }
    }

    public volatile void onServiceChanged(Object obj, boolean flag) {
        onServiceChanged((AuthenticatorDescription)obj, flag);
    }

    public String peekAuthToken(Account account, String s) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("peekAuthToken: ").append(account).append(", authTokenType ").append(s).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(s == null)
            throw new IllegalArgumentException("authTokenType is null");
        checkAuthenticateAccountsPermission(account);
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        String s1 = readAuthTokenInternal(useraccounts, account, s);
        restoreCallingIdentity(l);
        return s1;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    protected String readAuthTokenInternal(UserAccounts useraccounts, Account account, String s) {
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        HashMap hashmap = (HashMap)useraccounts.authTokenCache.get(account);
        if(hashmap == null) {
            hashmap = readAuthTokensForAccountFromDatabaseLocked(useraccounts.openHelper.getReadableDatabase(), account);
            useraccounts.authTokenCache.put(account, hashmap);
        }
        String s1 = (String)hashmap.get(s);
        return s1;
    }

    protected HashMap readAuthTokensForAccountFromDatabaseLocked(SQLiteDatabase sqlitedatabase, Account account) {
        HashMap hashmap;
        Cursor cursor;
        hashmap = new HashMap();
        String as[] = COLUMNS_AUTHTOKENS_TYPE_AND_AUTHTOKEN;
        String as1[] = new String[2];
        as1[0] = account.name;
        as1[1] = account.type;
        cursor = sqlitedatabase.query("authtokens", as, "accounts_id=(select _id FROM accounts WHERE name=? AND type=?)", as1, null, null, null);
        while(cursor.moveToNext()) 
            hashmap.put(cursor.getString(0), cursor.getString(1));
        break MISSING_BLOCK_LABEL_98;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
        cursor.close();
        return hashmap;
    }

    protected HashMap readUserDataForAccountFromDatabaseLocked(SQLiteDatabase sqlitedatabase, Account account) {
        HashMap hashmap;
        Cursor cursor;
        hashmap = new HashMap();
        String as[] = COLUMNS_EXTRAS_KEY_AND_VALUE;
        String as1[] = new String[2];
        as1[0] = account.name;
        as1[1] = account.type;
        cursor = sqlitedatabase.query("extras", as, "accounts_id=(select _id FROM accounts WHERE name=? AND type=?)", as1, null, null, null);
        while(cursor.moveToNext()) 
            hashmap.put(cursor.getString(0), cursor.getString(1));
        break MISSING_BLOCK_LABEL_98;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
        cursor.close();
        return hashmap;
    }

    protected String readUserDataInternal(UserAccounts useraccounts, Account account, String s) {
        Object obj = useraccounts.cacheLock;
        obj;
        JVM INSTR monitorenter ;
        HashMap hashmap = (HashMap)useraccounts.userDataCache.get(account);
        if(hashmap == null) {
            hashmap = readUserDataForAccountFromDatabaseLocked(useraccounts.openHelper.getReadableDatabase(), account);
            useraccounts.userDataCache.put(account, hashmap);
        }
        String s1 = (String)hashmap.get(s);
        return s1;
    }

    public void removeAccount(IAccountManagerResponse iaccountmanagerresponse, Account account) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("removeAccount: ").append(account).append(", response ").append(iaccountmanagerresponse).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(iaccountmanagerresponse == null)
            throw new IllegalArgumentException("response is null");
        if(account == null)
            throw new IllegalArgumentException("account is null");
        checkManageAccountsPermission();
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        cancelNotification(getSigninRequiredNotificationId(useraccounts, account).intValue());
        HashMap hashmap = useraccounts.credentialsPermissionNotificationIds;
        hashmap;
        JVM INSTR monitorenter ;
        Iterator iterator = useraccounts.credentialsPermissionNotificationIds.keySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            Pair pair = (Pair)iterator.next();
            if(account.equals(((Pair)pair.first).first))
                cancelNotification(((Integer)useraccounts.credentialsPermissionNotificationIds.get(pair)).intValue());
        } while(true);
        break MISSING_BLOCK_LABEL_219;
        Exception exception;
        exception;
        throw exception;
        hashmap;
        JVM INSTR monitorexit ;
        (new RemoveAccountSession(useraccounts, iaccountmanagerresponse, account)).bind();
        restoreCallingIdentity(l);
        return;
        Exception exception1;
        exception1;
        restoreCallingIdentity(l);
        throw exception1;
    }

    protected void removeAccountInternal(Account account) {
        removeAccountInternal(getUserAccountsForCaller(), account);
    }

    public void setAuthToken(Account account, String s, String s1) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("setAuthToken: ").append(account).append(", authTokenType ").append(s).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(s == null)
            throw new IllegalArgumentException("authTokenType is null");
        checkAuthenticateAccountsPermission(account);
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        saveAuthTokenToDatabase(useraccounts, account, s, s1);
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void setPassword(Account account, String s) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("setAuthToken: ").append(account).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(account == null)
            throw new IllegalArgumentException("account is null");
        checkAuthenticateAccountsPermission(account);
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        setPasswordInternal(useraccounts, account, s);
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void setUserData(Account account, String s, String s1) {
        UserAccounts useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("setUserData: ").append(account).append(", key ").append(s).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(s == null)
            throw new IllegalArgumentException("key is null");
        if(account == null)
            throw new IllegalArgumentException("account is null");
        checkAuthenticateAccountsPermission(account);
        useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        setUserdataInternal(useraccounts, account, s, s1);
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    public void systemReady() {
        mAuthenticatorCache.generateServicesMap();
        initUser(0);
    }

    public void updateAppPermission(Account account, String s, int i, boolean flag) throws RemoteException {
        if(getCallingUid() != 1000)
            throw new SecurityException();
        if(flag)
            grantAppPermission(account, s, i);
        else
            revokeAppPermission(account, s, i);
    }

    public void updateCredentials(final IAccountManagerResponse final_iaccountmanagerresponse, Account account, String s, boolean flag, Bundle bundle) {
        final UserAccounts final_useraccounts;
        long l;
        if(Log.isLoggable("AccountManagerService", 2))
            Log.v("AccountManagerService", (new StringBuilder()).append("updateCredentials: ").append(account).append(", response ").append(final_iaccountmanagerresponse).append(", authTokenType ").append(s).append(", expectActivityLaunch ").append(flag).append(", caller's uid ").append(Binder.getCallingUid()).append(", pid ").append(Binder.getCallingPid()).toString());
        if(final_iaccountmanagerresponse == null)
            throw new IllegalArgumentException("response is null");
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(s == null)
            throw new IllegalArgumentException("authTokenType is null");
        checkManageAccountsPermission();
        final_useraccounts = getUserAccountsForCaller();
        l = clearCallingIdentity();
        (new Session(flag, true, account, s, bundle) {

            public void run() throws RemoteException {
                super.mAuthenticator.updateCredentials(this, account, authTokenType, loginOptions);
            }

            protected String toDebugString(long l1) {
                if(loginOptions != null)
                    loginOptions.keySet();
                return (new StringBuilder()).append(super.toDebugString(l1)).append(", updateCredentials").append(", ").append(account).append(", authTokenType ").append(authTokenType).append(", loginOptions ").append(loginOptions).toString();
            }

            final AccountManagerService this$0;
            final Account val$account;
            final String val$authTokenType;
            final Bundle val$loginOptions;

             {
                this$0 = AccountManagerService.this;
                account = account1;
                authTokenType = s1;
                loginOptions = bundle;
                super(final_useraccounts, final_iaccountmanagerresponse, final_s, flag, flag1);
            }
        }).bind();
        restoreCallingIdentity(l);
        return;
        Exception exception;
        exception;
        restoreCallingIdentity(l);
        throw exception;
    }

    protected void writeAuthTokenIntoCacheLocked(UserAccounts useraccounts, SQLiteDatabase sqlitedatabase, Account account, String s, String s1) {
        HashMap hashmap = (HashMap)useraccounts.authTokenCache.get(account);
        if(hashmap == null) {
            hashmap = readAuthTokensForAccountFromDatabaseLocked(sqlitedatabase, account);
            useraccounts.authTokenCache.put(account, hashmap);
        }
        if(s1 == null)
            hashmap.remove(s);
        else
            hashmap.put(s, s1);
    }

    protected void writeUserDataIntoCacheLocked(UserAccounts useraccounts, SQLiteDatabase sqlitedatabase, Account account, String s, String s1) {
        HashMap hashmap = (HashMap)useraccounts.userDataCache.get(account);
        if(hashmap == null) {
            hashmap = readUserDataForAccountFromDatabaseLocked(sqlitedatabase, account);
            useraccounts.userDataCache.put(account, hashmap);
        }
        if(s1 == null)
            hashmap.remove(s);
        else
            hashmap.put(s, s1);
    }

    private static final Intent ACCOUNTS_CHANGED_INTENT;
    private static final String ACCOUNTS_ID = "_id";
    private static final String ACCOUNTS_NAME = "name";
    private static final String ACCOUNTS_PASSWORD = "password";
    private static final String ACCOUNTS_TYPE = "type";
    private static final String ACCOUNTS_TYPE_COUNT = "count(type)";
    private static final String ACCOUNT_TYPE_COUNT_PROJECTION[];
    private static final String AUTHTOKENS_ACCOUNTS_ID = "accounts_id";
    private static final String AUTHTOKENS_AUTHTOKEN = "authtoken";
    private static final String AUTHTOKENS_ID = "_id";
    private static final String AUTHTOKENS_TYPE = "type";
    private static final String COLUMNS_AUTHTOKENS_TYPE_AND_AUTHTOKEN[];
    private static final String COLUMNS_EXTRAS_KEY_AND_VALUE[];
    private static final String COUNT_OF_MATCHING_GRANTS = "SELECT COUNT(*) FROM grants, accounts WHERE accounts_id=_id AND uid=? AND auth_token_type=? AND name=? AND type=?";
    private static final String DATABASE_NAME = "accounts.db";
    private static final int DATABASE_VERSION = 4;
    private static final Account EMPTY_ACCOUNT_ARRAY[] = new Account[0];
    private static final String EXTRAS_ACCOUNTS_ID = "accounts_id";
    private static final String EXTRAS_ID = "_id";
    private static final String EXTRAS_KEY = "key";
    private static final String EXTRAS_VALUE = "value";
    private static final String GRANTS_ACCOUNTS_ID = "accounts_id";
    private static final String GRANTS_AUTH_TOKEN_TYPE = "auth_token_type";
    private static final String GRANTS_GRANTEE_UID = "uid";
    private static final int MESSAGE_TIMED_OUT = 3;
    private static final String META_KEY = "key";
    private static final String META_VALUE = "value";
    private static final String SELECTION_AUTHTOKENS_BY_ACCOUNT = "accounts_id=(select _id FROM accounts WHERE name=? AND type=?)";
    private static final String SELECTION_USERDATA_BY_ACCOUNT = "accounts_id=(select _id FROM accounts WHERE name=? AND type=?)";
    private static final String TABLE_ACCOUNTS = "accounts";
    private static final String TABLE_AUTHTOKENS = "authtokens";
    private static final String TABLE_EXTRAS = "extras";
    private static final String TABLE_GRANTS = "grants";
    private static final String TABLE_META = "meta";
    private static final String TAG = "AccountManagerService";
    private static final int TIMEOUT_DELAY_MS = 60000;
    private static AtomicReference sThis = new AtomicReference();
    private final IAccountAuthenticatorCache mAuthenticatorCache;
    private final Context mContext;
    private final MessageHandler mMessageHandler;
    private HandlerThread mMessageThread;
    private final AtomicInteger mNotificationIds;
    private final PackageManager mPackageManager;
    private final LinkedHashMap mSessions;
    private final SparseArray mUsers;

    static  {
        String as[] = new String[2];
        as[0] = "type";
        as[1] = "count(type)";
        ACCOUNT_TYPE_COUNT_PROJECTION = as;
        String as1[] = new String[2];
        as1[0] = "type";
        as1[1] = "authtoken";
        COLUMNS_AUTHTOKENS_TYPE_AND_AUTHTOKEN = as1;
        String as2[] = new String[2];
        as2[0] = "key";
        as2[1] = "value";
        COLUMNS_EXTRAS_KEY_AND_VALUE = as2;
        ACCOUNTS_CHANGED_INTENT = new Intent("android.accounts.LOGIN_ACCOUNTS_CHANGED");
        ACCOUNTS_CHANGED_INTENT.setFlags(0x8000000);
    }












}
