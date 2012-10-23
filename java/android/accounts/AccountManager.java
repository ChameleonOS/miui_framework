// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.accounts;

import android.app.Activity;
import android.content.*;
import android.content.pm.ApplicationInfo;
import android.database.SQLException;
import android.os.*;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.collect.Maps;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

// Referenced classes of package android.accounts:
//            AuthenticatorException, Account, IAccountManager, OperationCanceledException, 
//            AccountManagerFuture, OnAccountsUpdateListener, AccountManagerCallback, AuthenticatorDescription, 
//            IAccountManagerResponse, AccountManagerResponse

public class AccountManager {
    private class GetAuthTokenByTypeAndFeaturesTask extends AmsTask
        implements AccountManagerCallback {

        public void doWork() throws RemoteException {
            getAccountsByTypeAndFeatures(mAccountType, mFeatures, new AccountManagerCallback() {

                public void run(AccountManagerFuture accountmanagerfuture) {
                    Account aaccount[] = (Account[])accountmanagerfuture.getResult();
                    mNumAccounts = aaccount.length;
                    AuthenticatorException authenticatorexception;
                    IOException ioexception;
                    OperationCanceledException operationcanceledexception;
                    if(aaccount.length == 0) {
                        if(mActivity != null) {
                            mFuture = addAccount(mAccountType, mAuthTokenType, mFeatures, mAddAccountOptions, mActivity, mMyCallback, mHandler);
                        } else {
                            Bundle bundle1 = new Bundle();
                            bundle1.putString("authAccount", null);
                            bundle1.putString("accountType", null);
                            bundle1.putString("authtoken", null);
                            try {
                                mResponse.onResult(bundle1);
                            }
                            catch(RemoteException remoteexception1) { }
                        }
                    } else
                    if(aaccount.length == 1) {
                        if(mActivity == null)
                            mFuture = getAuthToken(aaccount[0], mAuthTokenType, false, mMyCallback, mHandler);
                        else
                            mFuture = getAuthToken(aaccount[0], mAuthTokenType, mLoginOptions, mActivity, mMyCallback, mHandler);
                    } else
                    if(mActivity != null) {
                        IAccountManagerResponse.Stub stub = new IAccountManagerResponse.Stub() {

                            public void onError(int i, String s) throws RemoteException {
                                mResponse.onError(i, s);
                            }

                            public void onResult(Bundle bundle2) throws RemoteException {
                                Account account = new Account(bundle2.getString("authAccount"), bundle2.getString("accountType"));
                                mFuture = getAuthToken(account, mAuthTokenType, mLoginOptions, mActivity, mMyCallback, mHandler);
                            }

                            final _cls1 this$2;

                         {
                            this$2 = _cls1.this;
                            super();
                        }
                        };
                        Intent intent = new Intent();
                        intent.setClassName("android", "android.accounts.ChooseAccountActivity");
                        intent.putExtra("accounts", aaccount);
                        intent.putExtra("accountManagerResponse", new AccountManagerResponse(stub));
                        mActivity.startActivity(intent);
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("accounts", null);
                        try {
                            mResponse.onResult(bundle);
                        }
                        catch(RemoteException remoteexception) { }
                    }
                    return;
                    operationcanceledexception;
                    setException(operationcanceledexception);
                    continue; /* Loop/switch isn't completed */
                    ioexception;
                    setException(ioexception);
                    continue; /* Loop/switch isn't completed */
                    authenticatorexception;
                    setException(authenticatorexception);
                    if(true) goto _L2; else goto _L1
_L1:
                    break MISSING_BLOCK_LABEL_142;
_L2:
                    break MISSING_BLOCK_LABEL_104;
                }

                final GetAuthTokenByTypeAndFeaturesTask this$1;

                 {
                    this$1 = GetAuthTokenByTypeAndFeaturesTask.this;
                    super();
                }
            }, super.mHandler);
        }

        public void run(AccountManagerFuture accountmanagerfuture) {
label0:
            {
                Bundle bundle = (Bundle)accountmanagerfuture.getResult();
                OperationCanceledException operationcanceledexception;
                if(mNumAccounts == 0) {
                    String s = bundle.getString("authAccount");
                    String s1 = bundle.getString("accountType");
                    if(TextUtils.isEmpty(s) || TextUtils.isEmpty(s1)) {
                        setException(new AuthenticatorException("account not in result"));
                    } else {
                        Account account = new Account(s, s1);
                        mNumAccounts = 1;
                        getAuthToken(account, mAuthTokenType, null, super.mActivity, mMyCallback, super.mHandler);
                    }
                    break label0;
                }
                try {
                    set(bundle);
                }
                // Misplaced declaration of an exception variable
                catch(OperationCanceledException operationcanceledexception) {
                    cancel(true);
                }
                catch(IOException ioexception) {
                    setException(ioexception);
                }
                catch(AuthenticatorException authenticatorexception) {
                    setException(authenticatorexception);
                }
            }
        }

        final String mAccountType;
        final Bundle mAddAccountOptions;
        final String mAuthTokenType;
        final String mFeatures[];
        volatile AccountManagerFuture mFuture;
        final Bundle mLoginOptions;
        final AccountManagerCallback mMyCallback;
        private volatile int mNumAccounts;
        final AccountManager this$0;




/*
        static int access$1202(GetAuthTokenByTypeAndFeaturesTask getauthtokenbytypeandfeaturestask, int i) {
            getauthtokenbytypeandfeaturestask.mNumAccounts = i;
            return i;
        }

*/


        GetAuthTokenByTypeAndFeaturesTask(String s, String s1, String as[], Activity activity, Bundle bundle, Bundle bundle1, 
                AccountManagerCallback accountmanagercallback, Handler handler) {
            this$0 = AccountManager.this;
            super(activity, handler, accountmanagercallback);
            mFuture = null;
            mNumAccounts = 0;
            if(s == null) {
                throw new IllegalArgumentException("account type is null");
            } else {
                mAccountType = s;
                mAuthTokenType = s1;
                mFeatures = as;
                mAddAccountOptions = bundle;
                mLoginOptions = bundle1;
                mMyCallback = this;
                return;
            }
        }
    }

    private abstract class Future2Task extends BaseFutureTask
        implements AccountManagerFuture {

        private Object internalGetResult(Long long1, TimeUnit timeunit) throws OperationCanceledException, IOException, AuthenticatorException {
            if(!isDone())
                ensureNotOnMainThread();
            if(long1 != null) goto _L2; else goto _L1
_L1:
            Object obj2 = get();
            Object obj1 = obj2;
_L4:
            cancel(true);
            return obj1;
_L2:
            Exception exception;
            ExecutionException executionexception;
            Throwable throwable;
            long l;
            Object obj;
            TimeoutException timeoutexception2;
            CancellationException cancellationexception2;
            try {
                l = long1.longValue();
            }
            catch(TimeoutException timeoutexception) {
                continue; /* Loop/switch isn't completed */
            }
            catch(CancellationException cancellationexception) {
                continue; /* Loop/switch isn't completed */
            }
            try {
                obj = get(l, timeunit);
            }
            catch(TimeoutException timeoutexception1) {
                continue; /* Loop/switch isn't completed */
            }
            catch(CancellationException cancellationexception1) {
                continue; /* Loop/switch isn't completed */
            }
            obj1 = obj;
            if(true) goto _L4; else goto _L3
_L3:
            executionexception;
            throwable = executionexception.getCause();
            if(throwable instanceof IOException)
                throw (IOException)throwable;
            break MISSING_BLOCK_LABEL_93;
            exception;
            cancel(true);
            throw exception;
            if(throwable instanceof UnsupportedOperationException)
                throw new AuthenticatorException(throwable);
            if(throwable instanceof AuthenticatorException)
                throw (AuthenticatorException)throwable;
            if(throwable instanceof RuntimeException)
                throw (RuntimeException)throwable;
            if(throwable instanceof Error)
                throw (Error)throwable;
            else
                throw new IllegalStateException(throwable);
            cancellationexception2;
_L6:
            cancel(true);
            throw new OperationCanceledException();
            timeoutexception2;
            continue; /* Loop/switch isn't completed */
            InterruptedException interruptedexception;
            interruptedexception;
            if(true) goto _L6; else goto _L5
_L5:
        }

        protected void done() {
            if(mCallback != null)
                postRunnableToHandler(new Runnable() {

                    public void run() {
                        mCallback.run(Future2Task.this);
                    }

                    final Future2Task this$1;

                 {
                    this$1 = Future2Task.this;
                    super();
                }
                });
        }

        public Object getResult() throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(null, null);
        }

        public Object getResult(long l, TimeUnit timeunit) throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(Long.valueOf(l), timeunit);
        }

        public Future2Task start() {
            startTask();
            return this;
        }

        final AccountManagerCallback mCallback;
        final AccountManager this$0;

        public Future2Task(Handler handler, AccountManagerCallback accountmanagercallback) {
            this$0 = AccountManager.this;
            super(handler);
            mCallback = accountmanagercallback;
        }
    }

    private abstract class BaseFutureTask extends FutureTask {
        protected class Response extends IAccountManagerResponse.Stub {

            public void onError(int i, String s) {
                if(i == 4)
                    cancel(true);
                else
                    setException(convertErrorToException(i, s));
            }

            public void onResult(Bundle bundle) {
label0:
                {
                    try {
                        Object obj = bundleToResult(bundle);
                        if(obj != null)
                            set(obj);
                        break label0;
                    }
                    catch(ClassCastException classcastexception) { }
                    catch(AuthenticatorException authenticatorexception) { }
                    onError(5, "no result in response");
                }
            }

            final BaseFutureTask this$1;

            protected Response() {
                this$1 = BaseFutureTask.this;
                super();
            }
        }


        public abstract Object bundleToResult(Bundle bundle) throws AuthenticatorException;

        public abstract void doWork() throws RemoteException;

        protected void postRunnableToHandler(Runnable runnable) {
            Handler handler;
            if(mHandler == null)
                handler = mMainHandler;
            else
                handler = mHandler;
            handler.post(runnable);
        }

        protected void startTask() {
            doWork();
_L1:
            return;
            RemoteException remoteexception;
            remoteexception;
            setException(remoteexception);
              goto _L1
        }

        final Handler mHandler;
        public final IAccountManagerResponse mResponse = new Response();
        final AccountManager this$0;



        public BaseFutureTask(Handler handler) {
            this.this$0 = AccountManager.this;
            super(new Callable() {

                public Object call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }

                final AccountManager val$this$0;

                 {
                    this$0 = accountmanager;
                    super();
                }
            });
            mHandler = handler;
        }
    }

    private abstract class AmsTask extends FutureTask
        implements AccountManagerFuture {
        private class Response extends IAccountManagerResponse.Stub {

            public void onError(int i, String s) {
                if(i == 4)
                    cancel(true);
                else
                    setException(convertErrorToException(i, s));
            }

            public void onResult(Bundle bundle) {
                Intent intent = (Intent)bundle.getParcelable("intent");
                if(intent != null && mActivity != null)
                    mActivity.startActivity(intent);
                else
                if(bundle.getBoolean("retry"))
                    try {
                        doWork();
                    }
                    catch(RemoteException remoteexception) { }
                else
                    set(bundle);
            }

            final AmsTask this$1;

            private Response() {
                this$1 = AmsTask.this;
                super();
            }

        }


        private Bundle internalGetResult(Long long1, TimeUnit timeunit) throws OperationCanceledException, IOException, AuthenticatorException {
            if(!isDone())
                ensureNotOnMainThread();
            if(long1 != null) goto _L2; else goto _L1
_L1:
            Object obj1 = get();
            Bundle bundle;
            try {
                bundle = (Bundle)obj1;
            }
            catch(InterruptedException interruptedexception4) {
                continue; /* Loop/switch isn't completed */
            }
_L4:
            cancel(true);
            return bundle;
_L2:
            ExecutionException executionexception;
            Throwable throwable;
            Exception exception;
            CancellationException cancellationexception;
            long l;
            Object obj;
            InterruptedException interruptedexception3;
            try {
                l = long1.longValue();
            }
            catch(InterruptedException interruptedexception) {
                continue; /* Loop/switch isn't completed */
            }
            try {
                obj = get(l, timeunit);
            }
            catch(InterruptedException interruptedexception1) {
                continue; /* Loop/switch isn't completed */
            }
            try {
                bundle = (Bundle)obj;
            }
            catch(InterruptedException interruptedexception2) {
                continue; /* Loop/switch isn't completed */
            }
            if(true) goto _L4; else goto _L3
_L3:
            cancellationexception;
            throw new OperationCanceledException();
            exception;
            cancel(true);
            throw exception;
            executionexception;
            throwable = executionexception.getCause();
            if(throwable instanceof IOException)
                throw (IOException)throwable;
            if(throwable instanceof UnsupportedOperationException)
                throw new AuthenticatorException(throwable);
            if(throwable instanceof AuthenticatorException)
                throw (AuthenticatorException)throwable;
            if(throwable instanceof RuntimeException)
                throw (RuntimeException)throwable;
            if(throwable instanceof Error)
                throw (Error)throwable;
            else
                throw new IllegalStateException(throwable);
            interruptedexception3;
_L6:
            cancel(true);
            throw new OperationCanceledException();
            TimeoutException timeoutexception;
            timeoutexception;
            if(true) goto _L6; else goto _L5
_L5:
        }

        public abstract void doWork() throws RemoteException;

        protected void done() {
            if(mCallback != null)
                postToHandler(mHandler, mCallback, this);
        }

        public Bundle getResult() throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(null, null);
        }

        public Bundle getResult(long l, TimeUnit timeunit) throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(Long.valueOf(l), timeunit);
        }

        public volatile Object getResult() throws OperationCanceledException, IOException, AuthenticatorException {
            return getResult();
        }

        public volatile Object getResult(long l, TimeUnit timeunit) throws OperationCanceledException, IOException, AuthenticatorException {
            return getResult(l, timeunit);
        }

        protected void set(Bundle bundle) {
            if(bundle == null)
                Log.e("AccountManager", "the bundle must not be null", new Exception());
            super.set(bundle);
        }

        protected volatile void set(Object obj) {
            set((Bundle)obj);
        }

        public final AccountManagerFuture start() {
            try {
                doWork();
            }
            catch(RemoteException remoteexception) {
                setException(remoteexception);
            }
            return this;
        }

        final Activity mActivity;
        final AccountManagerCallback mCallback;
        final Handler mHandler;
        final IAccountManagerResponse mResponse = new Response();
        final AccountManager this$0;


        public AmsTask(Activity activity, Handler handler, AccountManagerCallback accountmanagercallback) {
            this.this$0 = AccountManager.this;
            super(new Callable() {

                public Bundle call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }

                public volatile Object call() throws Exception {
                    return call();
                }

                final AccountManager val$this$0;

                 {
                    this$0 = accountmanager;
                    super();
                }
            });
            mHandler = handler;
            mCallback = accountmanagercallback;
            mActivity = activity;
        }
    }


    public AccountManager(Context context, IAccountManager iaccountmanager) {
        mAccountsUpdatedListeners = Maps.newHashMap();
        mAccountsChangedBroadcastReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent) {
                Account aaccount[] = getAccounts();
                HashMap hashmap = mAccountsUpdatedListeners;
                hashmap;
                JVM INSTR monitorenter ;
                java.util.Map.Entry entry;
                for(Iterator iterator = mAccountsUpdatedListeners.entrySet().iterator(); iterator.hasNext(); postToHandler((Handler)entry.getValue(), (OnAccountsUpdateListener)entry.getKey(), aaccount))
                    entry = (java.util.Map.Entry)iterator.next();

                break MISSING_BLOCK_LABEL_98;
                Exception exception;
                exception;
                throw exception;
                hashmap;
                JVM INSTR monitorexit ;
            }

            final AccountManager this$0;

             {
                this$0 = AccountManager.this;
                super();
            }
        };
        mContext = context;
        mService = iaccountmanager;
        mMainHandler = new Handler(mContext.getMainLooper());
    }

    public AccountManager(Context context, IAccountManager iaccountmanager, Handler handler) {
        mAccountsUpdatedListeners = Maps.newHashMap();
        mAccountsChangedBroadcastReceiver = new _cls13();
        mContext = context;
        mService = iaccountmanager;
        mMainHandler = handler;
    }

    private Exception convertErrorToException(int i, String s) {
        Object obj;
        if(i == 3)
            obj = new IOException(s);
        else
        if(i == 6)
            obj = new UnsupportedOperationException(s);
        else
        if(i == 5)
            obj = new AuthenticatorException(s);
        else
        if(i == 7)
            obj = new IllegalArgumentException(s);
        else
            obj = new AuthenticatorException(s);
        return ((Exception) (obj));
    }

    private void ensureNotOnMainThread() {
        Looper looper = Looper.myLooper();
        if(looper != null && looper == mContext.getMainLooper()) {
            IllegalStateException illegalstateexception = new IllegalStateException("calling this from your main thread can lead to deadlock");
            Log.e("AccountManager", "calling this from your main thread can lead to deadlock and/or ANRs", illegalstateexception);
            if(mContext.getApplicationInfo().targetSdkVersion >= 8)
                throw illegalstateexception;
        }
    }

    public static AccountManager get(Context context) {
        if(context == null)
            throw new IllegalArgumentException("context is null");
        else
            return (AccountManager)context.getSystemService("account");
    }

    public static Intent newChooseAccountIntent(Account account, ArrayList arraylist, String as[], boolean flag, String s, String s1, String as1[], Bundle bundle) {
        Intent intent = new Intent();
        intent.setClassName("android", "android.accounts.ChooseTypeAndAccountActivity");
        intent.putExtra("allowableAccounts", arraylist);
        intent.putExtra("allowableAccountTypes", as);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", account);
        intent.putExtra("alwaysPromptForAccount", flag);
        intent.putExtra("descriptionTextOverride", s);
        intent.putExtra("authTokenType", s1);
        intent.putExtra("addAccountRequiredFeatures", as1);
        return intent;
    }

    private void postToHandler(Handler handler, final AccountManagerCallback callback, final AccountManagerFuture future) {
        if(handler == null)
            handler = mMainHandler;
        handler.post(new Runnable() {

            public void run() {
                callback.run(future);
            }

            final AccountManager this$0;
            final AccountManagerCallback val$callback;
            final AccountManagerFuture val$future;

             {
                this$0 = AccountManager.this;
                callback = accountmanagercallback;
                future = accountmanagerfuture;
                super();
            }
        });
    }

    private void postToHandler(Handler handler, final OnAccountsUpdateListener listener, Account aaccount[]) {
        final Account accountsCopy[] = new Account[aaccount.length];
        System.arraycopy(aaccount, 0, accountsCopy, 0, accountsCopy.length);
        if(handler == null)
            handler = mMainHandler;
        handler.post(new Runnable() {

            public void run() {
                listener.onAccountsUpdated(accountsCopy);
_L1:
                return;
                SQLException sqlexception;
                sqlexception;
                Log.e("AccountManager", "Can't update accounts", sqlexception);
                  goto _L1
            }

            final AccountManager this$0;
            final Account val$accountsCopy[];
            final OnAccountsUpdateListener val$listener;

             {
                this$0 = AccountManager.this;
                listener = onaccountsupdatelistener;
                accountsCopy = aaccount;
                super();
            }
        });
    }

    public static Bundle sanitizeResult(Bundle bundle) {
        Bundle bundle1;
        if(bundle != null && bundle.containsKey("authtoken") && !TextUtils.isEmpty(bundle.getString("authtoken"))) {
            bundle1 = new Bundle(bundle);
            bundle1.putString("authtoken", "<omitted for logging purposes>");
        } else {
            bundle1 = bundle;
        }
        return bundle1;
    }

    public AccountManagerFuture addAccount(final String accountType, final String authTokenType, String as[], Bundle bundle, final Activity final_activity1, final AccountManagerCallback final_accountmanagercallback, final Handler final_handler) {
        if(accountType == null)
            throw new IllegalArgumentException("accountType is null");
        Bundle bundle1 = new Bundle();
        if(bundle != null)
            bundle1.putAll(bundle);
        bundle1.putString("androidPackageName", mContext.getPackageName());
        return (new AmsTask(as, final_activity1, bundle1) {

            public void doWork() throws RemoteException {
                IAccountManager iaccountmanager = mService;
                IAccountManagerResponse iaccountmanagerresponse = super.mResponse;
                String s = accountType;
                String s1 = authTokenType;
                String as1[] = requiredFeatures;
                boolean flag;
                if(activity != null)
                    flag = true;
                else
                    flag = false;
                iaccountmanager.addAcount(iaccountmanagerresponse, s, s1, as1, flag, optionsIn);
            }

            final AccountManager this$0;
            final String val$accountType;
            final Activity val$activity;
            final String val$authTokenType;
            final Bundle val$optionsIn;
            final String val$requiredFeatures[];

             {
                this$0 = AccountManager.this;
                accountType = s;
                authTokenType = s1;
                requiredFeatures = as;
                activity = activity2;
                optionsIn = bundle;
                super(final_activity1, final_handler, final_accountmanagercallback);
            }
        }).start();
    }

    public boolean addAccountExplicitly(Account account, String s, Bundle bundle) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        boolean flag;
        try {
            flag = mService.addAccount(account, s, bundle);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
        return flag;
    }

    public void addOnAccountsUpdatedListener(OnAccountsUpdateListener onaccountsupdatelistener, Handler handler, boolean flag) {
        if(onaccountsupdatelistener == null)
            throw new IllegalArgumentException("the listener is null");
        HashMap hashmap = mAccountsUpdatedListeners;
        hashmap;
        JVM INSTR monitorenter ;
        if(mAccountsUpdatedListeners.containsKey(onaccountsupdatelistener))
            throw new IllegalStateException("this listener is already added");
        break MISSING_BLOCK_LABEL_54;
        Exception exception;
        exception;
        throw exception;
        boolean flag1 = mAccountsUpdatedListeners.isEmpty();
        mAccountsUpdatedListeners.put(onaccountsupdatelistener, handler);
        if(flag1) {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.accounts.LOGIN_ACCOUNTS_CHANGED");
            intentfilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
            mContext.registerReceiver(mAccountsChangedBroadcastReceiver, intentfilter);
        }
        hashmap;
        JVM INSTR monitorexit ;
        if(flag)
            postToHandler(handler, onaccountsupdatelistener, getAccounts());
        return;
    }

    public String blockingGetAuthToken(Account account, String s, boolean flag) throws OperationCanceledException, IOException, AuthenticatorException {
        String s1 = null;
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(s == null)
            throw new IllegalArgumentException("authTokenType is null");
        Bundle bundle = (Bundle)getAuthToken(account, s, flag, null, null).getResult();
        if(bundle == null)
            Log.e("AccountManager", (new StringBuilder()).append("blockingGetAuthToken: null was returned from getResult() for ").append(account).append(", authTokenType ").append(s).toString());
        else
            s1 = bundle.getString("authtoken");
        return s1;
    }

    public void clearPassword(Account account) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        try {
            mService.clearPassword(account);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public AccountManagerFuture confirmCredentials(Account account, Bundle bundle, final Activity final_activity1, final AccountManagerCallback final_accountmanagercallback, final Handler final_handler) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        else
            return (new AmsTask(account, bundle, final_activity1) {

                public void doWork() throws RemoteException {
                    IAccountManager iaccountmanager = mService;
                    IAccountManagerResponse iaccountmanagerresponse = super.mResponse;
                    Account account1 = account;
                    Bundle bundle1 = options;
                    boolean flag;
                    if(activity != null)
                        flag = true;
                    else
                        flag = false;
                    iaccountmanager.confirmCredentials(iaccountmanagerresponse, account1, bundle1, flag);
                }

                final AccountManager this$0;
                final Account val$account;
                final Activity val$activity;
                final Bundle val$options;

             {
                this$0 = AccountManager.this;
                account = account1;
                options = bundle;
                activity = activity2;
                super(final_activity1, final_handler, final_accountmanagercallback);
            }
            }).start();
    }

    public AccountManagerFuture editProperties(String s, final Activity final_activity1, AccountManagerCallback accountmanagercallback, final Handler final_handler) {
        if(s == null)
            throw new IllegalArgumentException("accountType is null");
        else
            return (new AmsTask(accountmanagercallback, s, final_activity1) {

                public void doWork() throws RemoteException {
                    IAccountManager iaccountmanager = mService;
                    IAccountManagerResponse iaccountmanagerresponse = super.mResponse;
                    String s1 = accountType;
                    boolean flag;
                    if(activity != null)
                        flag = true;
                    else
                        flag = false;
                    iaccountmanager.editProperties(iaccountmanagerresponse, s1, flag);
                }

                final AccountManager this$0;
                final String val$accountType;
                final Activity val$activity;

             {
                this$0 = AccountManager.this;
                accountType = s;
                activity = activity2;
                super(final_activity1, final_handler, accountmanagercallback);
            }
            }).start();
    }

    public Account[] getAccounts() {
        Account aaccount[];
        try {
            aaccount = mService.getAccounts(null);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
        return aaccount;
    }

    public Account[] getAccountsByType(String s) {
        Account aaccount[];
        try {
            aaccount = mService.getAccounts(s);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
        return aaccount;
    }

    public AccountManagerFuture getAccountsByTypeAndFeatures(String s, String as[], final AccountManagerCallback final_accountmanagercallback, final Handler final_handler) {
        if(s == null)
            throw new IllegalArgumentException("type is null");
        else
            return (new Future2Task(s, as) {

                public volatile Object bundleToResult(Bundle bundle) throws AuthenticatorException {
                    return bundleToResult(bundle);
                }

                public Account[] bundleToResult(Bundle bundle) throws AuthenticatorException {
                    if(!bundle.containsKey("accounts"))
                        throw new AuthenticatorException("no result in response");
                    android.os.Parcelable aparcelable[] = bundle.getParcelableArray("accounts");
                    Account aaccount[] = new Account[aparcelable.length];
                    for(int i = 0; i < aparcelable.length; i++)
                        aaccount[i] = (Account)aparcelable[i];

                    return aaccount;
                }

                public void doWork() throws RemoteException {
                    mService.getAccountsByFeatures(super.mResponse, type, features);
                }

                final AccountManager this$0;
                final String val$features[];
                final String val$type;

             {
                this$0 = AccountManager.this;
                type = s;
                features = as;
                super(final_handler, final_accountmanagercallback);
            }
            }).start();
    }

    public AccountManagerFuture getAuthToken(Account account, String s, Bundle bundle, final Activity final_activity, final AccountManagerCallback final_accountmanagercallback, final Handler final_handler) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(s == null)
            throw new IllegalArgumentException("authTokenType is null");
        Bundle bundle1 = new Bundle();
        if(bundle != null)
            bundle1.putAll(bundle);
        bundle1.putString("androidPackageName", mContext.getPackageName());
        return (new AmsTask(account, s, bundle1) {

            public void doWork() throws RemoteException {
                mService.getAuthToken(super.mResponse, account, authTokenType, false, true, optionsIn);
            }

            final AccountManager this$0;
            final Account val$account;
            final String val$authTokenType;
            final Bundle val$optionsIn;

             {
                this$0 = AccountManager.this;
                account = account1;
                authTokenType = s;
                optionsIn = bundle;
                super(final_activity, final_handler, final_accountmanagercallback);
            }
        }).start();
    }

    public AccountManagerFuture getAuthToken(Account account, String s, Bundle bundle, boolean flag, AccountManagerCallback accountmanagercallback, Handler handler) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(s == null)
            throw new IllegalArgumentException("authTokenType is null");
        Bundle bundle1 = new Bundle();
        if(bundle != null)
            bundle1.putAll(bundle);
        bundle1.putString("androidPackageName", mContext.getPackageName());
        return (new AmsTask(s, flag, bundle1) {

            public void doWork() throws RemoteException {
                mService.getAuthToken(super.mResponse, account, authTokenType, notifyAuthFailure, false, optionsIn);
            }

            final AccountManager this$0;
            final Account val$account;
            final String val$authTokenType;
            final boolean val$notifyAuthFailure;
            final Bundle val$optionsIn;

             {
                this$0 = AccountManager.this;
                account = account1;
                authTokenType = s;
                notifyAuthFailure = flag;
                optionsIn = bundle;
                super(final_activity, final_handler, final_accountmanagercallback);
            }
        }).start();
    }

    public AccountManagerFuture getAuthToken(Account account, String s, boolean flag, AccountManagerCallback accountmanagercallback, Handler handler) {
        return getAuthToken(account, s, null, flag, accountmanagercallback, handler);
    }

    public AccountManagerFuture getAuthTokenByFeatures(String s, String s1, String as[], Activity activity, Bundle bundle, Bundle bundle1, AccountManagerCallback accountmanagercallback, 
            Handler handler) {
        if(s == null)
            throw new IllegalArgumentException("account type is null");
        if(s1 == null) {
            throw new IllegalArgumentException("authTokenType is null");
        } else {
            GetAuthTokenByTypeAndFeaturesTask getauthtokenbytypeandfeaturestask = new GetAuthTokenByTypeAndFeaturesTask(s, s1, as, activity, bundle, bundle1, accountmanagercallback, handler);
            getauthtokenbytypeandfeaturestask.start();
            return getauthtokenbytypeandfeaturestask;
        }
    }

    public AccountManagerFuture getAuthTokenLabel(String s, String s1, final AccountManagerCallback final_accountmanagercallback, final Handler final_handler) {
        if(s == null)
            throw new IllegalArgumentException("accountType is null");
        if(s1 == null)
            throw new IllegalArgumentException("authTokenType is null");
        else
            return (new Future2Task(s, s1) {

                public volatile Object bundleToResult(Bundle bundle) throws AuthenticatorException {
                    return bundleToResult(bundle);
                }

                public String bundleToResult(Bundle bundle) throws AuthenticatorException {
                    if(!bundle.containsKey("authTokenLabelKey"))
                        throw new AuthenticatorException("no result in response");
                    else
                        return bundle.getString("authTokenLabelKey");
                }

                public void doWork() throws RemoteException {
                    mService.getAuthTokenLabel(super.mResponse, accountType, authTokenType);
                }

                final AccountManager this$0;
                final String val$accountType;
                final String val$authTokenType;

             {
                this$0 = AccountManager.this;
                accountType = s;
                authTokenType = s1;
                super(final_handler, final_accountmanagercallback);
            }
            }).start();
    }

    public AuthenticatorDescription[] getAuthenticatorTypes() {
        AuthenticatorDescription aauthenticatordescription[];
        try {
            aauthenticatordescription = mService.getAuthenticatorTypes();
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
        return aauthenticatordescription;
    }

    public String getPassword(Account account) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        String s;
        try {
            s = mService.getPassword(account);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
        return s;
    }

    public String getUserData(Account account, String s) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(s == null)
            throw new IllegalArgumentException("key is null");
        String s1;
        try {
            s1 = mService.getUserData(account, s);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
        return s1;
    }

    public AccountManagerFuture hasFeatures(Account account, String as[], final AccountManagerCallback final_accountmanagercallback, final Handler final_handler) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(as == null)
            throw new IllegalArgumentException("features is null");
        else
            return (new Future2Task(account, as) {

                public Boolean bundleToResult(Bundle bundle) throws AuthenticatorException {
                    if(!bundle.containsKey("booleanResult"))
                        throw new AuthenticatorException("no result in response");
                    else
                        return Boolean.valueOf(bundle.getBoolean("booleanResult"));
                }

                public volatile Object bundleToResult(Bundle bundle) throws AuthenticatorException {
                    return bundleToResult(bundle);
                }

                public void doWork() throws RemoteException {
                    mService.hasFeatures(super.mResponse, account, features);
                }

                final AccountManager this$0;
                final Account val$account;
                final String val$features[];

             {
                this$0 = AccountManager.this;
                account = account1;
                features = as;
                super(final_handler, final_accountmanagercallback);
            }
            }).start();
    }

    public void invalidateAuthToken(String s, String s1) {
        if(s == null)
            throw new IllegalArgumentException("accountType is null");
        if(s1 == null)
            break MISSING_BLOCK_LABEL_30;
        mService.invalidateAuthToken(s, s1);
        return;
        RemoteException remoteexception;
        remoteexception;
        throw new RuntimeException(remoteexception);
    }

    public String peekAuthToken(Account account, String s) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(s == null)
            throw new IllegalArgumentException("authTokenType is null");
        String s1;
        try {
            s1 = mService.peekAuthToken(account, s);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
        return s1;
    }

    public AccountManagerFuture removeAccount(Account account, AccountManagerCallback accountmanagercallback, final Handler final_handler) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        else
            return (new Future2Task(accountmanagercallback, account) {

                public Boolean bundleToResult(Bundle bundle) throws AuthenticatorException {
                    if(!bundle.containsKey("booleanResult"))
                        throw new AuthenticatorException("no result in response");
                    else
                        return Boolean.valueOf(bundle.getBoolean("booleanResult"));
                }

                public volatile Object bundleToResult(Bundle bundle) throws AuthenticatorException {
                    return bundleToResult(bundle);
                }

                public void doWork() throws RemoteException {
                    mService.removeAccount(super.mResponse, account);
                }

                final AccountManager this$0;
                final Account val$account;

             {
                this$0 = AccountManager.this;
                account = account1;
                super(final_handler, accountmanagercallback);
            }
            }).start();
    }

    public void removeOnAccountsUpdatedListener(OnAccountsUpdateListener onaccountsupdatelistener) {
        if(onaccountsupdatelistener == null)
            throw new IllegalArgumentException("listener is null");
        HashMap hashmap = mAccountsUpdatedListeners;
        hashmap;
        JVM INSTR monitorenter ;
        if(!mAccountsUpdatedListeners.containsKey(onaccountsupdatelistener)) {
            Log.e("AccountManager", "Listener was not previously added");
        } else {
            mAccountsUpdatedListeners.remove(onaccountsupdatelistener);
            if(mAccountsUpdatedListeners.isEmpty())
                mContext.unregisterReceiver(mAccountsChangedBroadcastReceiver);
        }
        return;
    }

    public void setAuthToken(Account account, String s, String s1) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(s == null)
            throw new IllegalArgumentException("authTokenType is null");
        try {
            mService.setAuthToken(account, s, s1);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void setPassword(Account account, String s) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        try {
            mService.setPassword(account, s);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void setUserData(Account account, String s, String s1) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        if(s == null)
            throw new IllegalArgumentException("key is null");
        try {
            mService.setUserData(account, s, s1);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public void updateAppPermission(Account account, String s, int i, boolean flag) {
        try {
            mService.updateAppPermission(account, s, i, flag);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    public AccountManagerFuture updateCredentials(final Account account, String s, Bundle bundle, final Activity final_activity1, final AccountManagerCallback final_accountmanagercallback, final Handler final_handler) {
        if(account == null)
            throw new IllegalArgumentException("account is null");
        else
            return (new AmsTask(s, final_activity1, bundle) {

                public void doWork() throws RemoteException {
                    IAccountManager iaccountmanager = mService;
                    IAccountManagerResponse iaccountmanagerresponse = super.mResponse;
                    Account account1 = account;
                    String s1 = authTokenType;
                    boolean flag;
                    if(activity != null)
                        flag = true;
                    else
                        flag = false;
                    iaccountmanager.updateCredentials(iaccountmanagerresponse, account1, s1, flag, options);
                }

                final AccountManager this$0;
                final Account val$account;
                final Activity val$activity;
                final String val$authTokenType;
                final Bundle val$options;

             {
                this$0 = AccountManager.this;
                account = account1;
                authTokenType = s;
                activity = activity2;
                options = bundle;
                super(final_activity1, final_handler, final_accountmanagercallback);
            }
            }).start();
    }

    public static final String ACTION_AUTHENTICATOR_INTENT = "android.accounts.AccountAuthenticator";
    public static final String AUTHENTICATOR_ATTRIBUTES_NAME = "account-authenticator";
    public static final String AUTHENTICATOR_META_DATA_NAME = "android.accounts.AccountAuthenticator";
    public static final int ERROR_CODE_BAD_ARGUMENTS = 7;
    public static final int ERROR_CODE_BAD_REQUEST = 8;
    public static final int ERROR_CODE_CANCELED = 4;
    public static final int ERROR_CODE_INVALID_RESPONSE = 5;
    public static final int ERROR_CODE_NETWORK_ERROR = 3;
    public static final int ERROR_CODE_REMOTE_EXCEPTION = 1;
    public static final int ERROR_CODE_UNSUPPORTED_OPERATION = 6;
    public static final String KEY_ACCOUNTS = "accounts";
    public static final String KEY_ACCOUNT_AUTHENTICATOR_RESPONSE = "accountAuthenticatorResponse";
    public static final String KEY_ACCOUNT_MANAGER_RESPONSE = "accountManagerResponse";
    public static final String KEY_ACCOUNT_NAME = "authAccount";
    public static final String KEY_ACCOUNT_TYPE = "accountType";
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    public static final String KEY_AUTHENTICATOR_TYPES = "authenticator_types";
    public static final String KEY_AUTHTOKEN = "authtoken";
    public static final String KEY_AUTH_FAILED_MESSAGE = "authFailedMessage";
    public static final String KEY_AUTH_TOKEN_LABEL = "authTokenLabelKey";
    public static final String KEY_BOOLEAN_RESULT = "booleanResult";
    public static final String KEY_CALLER_PID = "callerPid";
    public static final String KEY_CALLER_UID = "callerUid";
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_ERROR_MESSAGE = "errorMessage";
    public static final String KEY_INTENT = "intent";
    public static final String KEY_NOTIFY_ON_FAILURE = "notifyOnAuthFailure";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_USERDATA = "userdata";
    public static final String LOGIN_ACCOUNTS_CHANGED_ACTION = "android.accounts.LOGIN_ACCOUNTS_CHANGED";
    private static final String TAG = "AccountManager";
    private final BroadcastReceiver mAccountsChangedBroadcastReceiver;
    private final HashMap mAccountsUpdatedListeners;
    private final Context mContext;
    private final Handler mMainHandler;
    private final IAccountManager mService;







}
