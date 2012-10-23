// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.accounts;

import android.accounts.*;
import android.content.*;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.collect.Maps;
import java.util.*;

public class ExtraAccountManager {

    private ExtraAccountManager(Context context) {
        mContext = context;
        mAccountManager = AccountManager.get(mContext);
        mMainHandler = new Handler(mContext.getMainLooper());
    }

    public static ExtraAccountManager getInstance(Context context) {
        if(mInstance == null)
            mInstance = new ExtraAccountManager(context);
        return mInstance;
    }

    private void postToHandler(Handler handler, final MiuiOnAccountsUpdateListener listener, final Account account, final int type, final Bundle extra) {
        if(handler == null)
            handler = mMainHandler;
        handler.post(new Runnable() {

            public void run() {
                listener.onPreAccountUpdated(account, type, extra);
_L1:
                return;
                SQLException sqlexception;
                sqlexception;
                Log.e("ExtraAccountManager", "Can't update accounts", sqlexception);
                  goto _L1
            }

            final ExtraAccountManager this$0;
            final Account val$account;
            final Bundle val$extra;
            final MiuiOnAccountsUpdateListener val$listener;
            final int val$type;

             {
                this$0 = ExtraAccountManager.this;
                listener = miuionaccountsupdatelistener;
                account = account1;
                type = i;
                extra = bundle;
                super();
            }
        });
    }

    private void postToHandler(Handler handler, final MiuiOnAccountsUpdateListener listener, Account aaccount[]) {
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
                Log.e("ExtraAccountManager", "Can't update accounts", sqlexception);
                  goto _L1
            }

            final ExtraAccountManager this$0;
            final Account val$accountsCopy[];
            final MiuiOnAccountsUpdateListener val$listener;

             {
                this$0 = ExtraAccountManager.this;
                listener = miuionaccountsupdatelistener;
                accountsCopy = aaccount;
                super();
            }
        });
    }

    public void addOnAccountsUpdatedListener(MiuiOnAccountsUpdateListener miuionaccountsupdatelistener, Handler handler, boolean flag) {
        if(miuionaccountsupdatelistener == null)
            throw new IllegalArgumentException("the listener is null");
        HashMap hashmap = mMiuiAccountsUpdatedListeners;
        hashmap;
        JVM INSTR monitorenter ;
        if(mMiuiAccountsUpdatedListeners.containsKey(miuionaccountsupdatelistener))
            throw new IllegalStateException("this listener is already added");
        break MISSING_BLOCK_LABEL_52;
        Exception exception;
        exception;
        throw exception;
        boolean flag1 = mMiuiAccountsUpdatedListeners.isEmpty();
        mMiuiAccountsUpdatedListeners.put(miuionaccountsupdatelistener, handler);
        if(flag1) {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.accounts.LOGIN_ACCOUNTS_CHANGED");
            intentfilter.addAction("android.accounts.LOGIN_ACCOUNTS_PRE_CHANGED");
            intentfilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
            mContext.registerReceiver(mAccountsChangedBroadcastReceiver, intentfilter);
        }
        hashmap;
        JVM INSTR monitorexit ;
        if(flag)
            postToHandler(handler, miuionaccountsupdatelistener, mAccountManager.getAccounts());
        return;
    }

    public void removeOnAccountsUpdatedListener(MiuiOnAccountsUpdateListener miuionaccountsupdatelistener) {
        if(miuionaccountsupdatelistener == null)
            throw new IllegalArgumentException("listener is null");
        HashMap hashmap = mMiuiAccountsUpdatedListeners;
        hashmap;
        JVM INSTR monitorenter ;
        if(!mMiuiAccountsUpdatedListeners.containsKey(miuionaccountsupdatelistener)) {
            Log.e("ExtraAccountManager", "Listener was not previously added");
        } else {
            mMiuiAccountsUpdatedListeners.remove(miuionaccountsupdatelistener);
            if(mMiuiAccountsUpdatedListeners.isEmpty())
                mContext.unregisterReceiver(mAccountsChangedBroadcastReceiver);
        }
        return;
    }

    public static final String EXTRA_ACCOUNT = "extra_account";
    public static final String EXTRA_BUNDLE = "extra_bundle";
    public static final String EXTRA_UPDATE_TYPE = "extra_update_type";
    public static final String EXTRA_WIPE_DATA = "extra_wipe_data";
    public static final String LOGIN_ACCOUNTS_PRE_CHANGED_ACTION = "android.accounts.LOGIN_ACCOUNTS_PRE_CHANGED";
    private static final String TAG = "ExtraAccountManager";
    public static final int TYPE_ADD = 2;
    public static final int TYPE_REMOVE = 1;
    private static ExtraAccountManager mInstance;
    private AccountManager mAccountManager;
    private final BroadcastReceiver mAccountsChangedBroadcastReceiver = new BroadcastReceiver() {

        public void onReceive(Context context1, Intent intent) {
            if(!"android.accounts.LOGIN_ACCOUNTS_PRE_CHANGED".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
            Account account;
            Bundle bundle;
            int i;
            account = (Account)intent.getParcelableExtra("extra_account");
            bundle = (Bundle)intent.getParcelableExtra("extra_bundle");
            i = intent.getIntExtra("extra_update_type", -1);
            if(account == null || i <= 0) goto _L4; else goto _L3
_L3:
            HashMap hashmap1 = mMiuiAccountsUpdatedListeners;
            hashmap1;
            JVM INSTR monitorenter ;
            java.util.Map.Entry entry1;
            for(Iterator iterator1 = mMiuiAccountsUpdatedListeners.entrySet().iterator(); iterator1.hasNext(); postToHandler((Handler)entry1.getValue(), (MiuiOnAccountsUpdateListener)entry1.getKey(), account, i, bundle))
                entry1 = (java.util.Map.Entry)iterator1.next();

            break MISSING_BLOCK_LABEL_149;
            Exception exception1;
            exception1;
            throw exception1;
            hashmap1;
            JVM INSTR monitorexit ;
_L5:
            return;
_L4:
            Log.w("ExtraAccountManager", "account changed, but no account or type");
              goto _L5
_L2:
            Account aaccount[] = mAccountManager.getAccounts();
            HashMap hashmap = mMiuiAccountsUpdatedListeners;
            hashmap;
            JVM INSTR monitorenter ;
            java.util.Map.Entry entry;
            for(Iterator iterator = mMiuiAccountsUpdatedListeners.entrySet().iterator(); iterator.hasNext(); postToHandler((Handler)entry.getValue(), (MiuiOnAccountsUpdateListener)entry.getKey(), aaccount))
                entry = (java.util.Map.Entry)iterator.next();

            break MISSING_BLOCK_LABEL_265;
            Exception exception;
            exception;
            throw exception;
            hashmap;
            JVM INSTR monitorexit ;
              goto _L5
        }

        final ExtraAccountManager this$0;

             {
                this$0 = ExtraAccountManager.this;
                super();
            }
    };
    private Context mContext;
    private Handler mMainHandler;
    private final HashMap mMiuiAccountsUpdatedListeners = Maps.newHashMap();




}
