// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;

import android.app.*;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.net.Uri;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.util.HashMap;

// Referenced classes of package android.nfc:
//            NfcActivityManager, NfcManager, INfcAdapter, TechListParcel, 
//            INfcTag, Tag, NdefMessage, INfcAdapterExtras, 
//            NfcEvent

public final class NfcAdapter {
    public static interface CreateBeamUrisCallback {

        public abstract Uri[] createBeamUris(NfcEvent nfcevent);
    }

    public static interface CreateNdefMessageCallback {

        public abstract NdefMessage createNdefMessage(NfcEvent nfcevent);
    }

    public static interface OnNdefPushCompleteCallback {

        public abstract void onNdefPushComplete(NfcEvent nfcevent);
    }


    NfcAdapter(Context context) {
        mForegroundDispatchListener = new OnActivityPausedListener() {

            public void onPaused(Activity activity) {
                disableForegroundDispatchInternal(activity, true);
            }

            final NfcAdapter this$0;

             {
                this$0 = NfcAdapter.this;
                super();
            }
        };
        mContext = context;
    }

    public static NfcAdapter getDefaultAdapter() {
        Log.w("NFC", "WARNING: NfcAdapter.getDefaultAdapter() is deprecated, use NfcAdapter.getDefaultAdapter(Context) instead", new Exception());
        return getNfcAdapter(null);
    }

    public static NfcAdapter getDefaultAdapter(Context context) {
        if(context == null)
            throw new IllegalArgumentException("context cannot be null");
        Context context1 = context.getApplicationContext();
        if(context1 == null)
            throw new IllegalArgumentException("context not associated with any application (using a mock context?)");
        NfcManager nfcmanager = (NfcManager)context1.getSystemService("nfc");
        NfcAdapter nfcadapter;
        if(nfcmanager == null)
            nfcadapter = null;
        else
            nfcadapter = nfcmanager.getDefaultAdapter();
        return nfcadapter;
    }

    /**
     * @deprecated Method getNfcAdapter is deprecated
     */

    public static NfcAdapter getNfcAdapter(Context context) {
        android/nfc/NfcAdapter;
        JVM INSTR monitorenter ;
        if(sIsInitialized)
            break MISSING_BLOCK_LABEL_80;
        if(!hasNfcFeature()) {
            Log.v("NFC", "this device does not have NFC support");
            throw new UnsupportedOperationException();
        }
        break MISSING_BLOCK_LABEL_37;
        Exception exception;
        exception;
        android/nfc/NfcAdapter;
        JVM INSTR monitorexit ;
        throw exception;
        sService = getServiceInterface();
        if(sService == null) {
            Log.e("NFC", "could not retrieve NFC service");
            throw new UnsupportedOperationException();
        }
        sTagService = sService.getNfcTagInterface();
        sIsInitialized = true;
        NfcAdapter nfcadapter;
        if(context != null)
            break MISSING_BLOCK_LABEL_128;
        if(sNullContextNfcAdapter == null)
            sNullContextNfcAdapter = new NfcAdapter(null);
        nfcadapter = sNullContextNfcAdapter;
_L1:
        android/nfc/NfcAdapter;
        JVM INSTR monitorexit ;
        return nfcadapter;
        RemoteException remoteexception;
        remoteexception;
        Log.e("NFC", "could not retrieve NFC Tag service");
        throw new UnsupportedOperationException();
        nfcadapter = (NfcAdapter)sNfcAdapters.get(context);
        if(nfcadapter == null) {
            nfcadapter = new NfcAdapter(context);
            sNfcAdapters.put(context, nfcadapter);
        }
          goto _L1
    }

    private static INfcAdapter getServiceInterface() {
        android.os.IBinder ibinder = ServiceManager.getService("nfc");
        INfcAdapter infcadapter;
        if(ibinder == null)
            infcadapter = null;
        else
            infcadapter = INfcAdapter.Stub.asInterface(ibinder);
        return infcadapter;
    }

    private static boolean hasNfcFeature() {
        boolean flag;
        IPackageManager ipackagemanager;
        flag = false;
        ipackagemanager = ActivityThread.getPackageManager();
        if(ipackagemanager != null) goto _L2; else goto _L1
_L1:
        Log.e("NFC", "Cannot get package manager, assuming no NFC feature");
_L4:
        return flag;
_L2:
        boolean flag1 = ipackagemanager.hasSystemFeature("android.hardware.nfc");
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("NFC", "Package manager query failed, assuming no NFC feature", remoteexception);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void attemptDeadServiceRecovery(Exception exception) {
        Log.e("NFC", "NFC service dead - attempting to recover", exception);
        INfcAdapter infcadapter = getServiceInterface();
        if(infcadapter == null) {
            Log.e("NFC", "could not retrieve NFC service during service recovery");
        } else {
            sService = infcadapter;
            try {
                sTagService = infcadapter.getNfcTagInterface();
            }
            catch(RemoteException remoteexception) {
                Log.e("NFC", "could not retrieve NFC tag service during service recovery");
            }
        }
    }

    public boolean disable() {
        boolean flag1 = sService.disable(true);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        attemptDeadServiceRecovery(remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void disableForegroundDispatch(Activity activity) {
        ActivityThread.currentActivityThread().unregisterOnActivityPausedListener(activity, mForegroundDispatchListener);
        disableForegroundDispatchInternal(activity, false);
    }

    void disableForegroundDispatchInternal(Activity activity, boolean flag) {
        try {
            sService.setForegroundDispatch(null, null, null);
            if(!flag && !activity.isResumed())
                throw new IllegalStateException("You must disable foreground dispatching while your activity is still resumed");
        }
        catch(RemoteException remoteexception) {
            attemptDeadServiceRecovery(remoteexception);
        }
    }

    public void disableForegroundNdefPush(Activity activity) {
        if(activity == null) {
            throw new NullPointerException();
        } else {
            enforceResumed(activity);
            mNfcActivityManager.setNdefPushMessage(activity, null);
            mNfcActivityManager.setNdefPushMessageCallback(activity, null);
            mNfcActivityManager.setOnNdefPushCompleteCallback(activity, null);
            return;
        }
    }

    public boolean disableNdefPush() {
        boolean flag1 = sService.disableNdefPush();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        attemptDeadServiceRecovery(remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void dispatch(Tag tag) {
        if(tag == null)
            throw new NullPointerException("tag cannot be null");
        sService.dispatch(tag);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        attemptDeadServiceRecovery(remoteexception);
          goto _L1
    }

    public boolean enable() {
        boolean flag1 = sService.enable();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        attemptDeadServiceRecovery(remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void enableForegroundDispatch(Activity activity, PendingIntent pendingintent, IntentFilter aintentfilter[], String as[][]) {
        TechListParcel techlistparcel;
        if(activity == null || pendingintent == null)
            throw new NullPointerException();
        if(!activity.isResumed())
            throw new IllegalStateException("Foreground dispatch can only be enabled when your activity is resumed");
        techlistparcel = null;
        if(as == null)
            break MISSING_BLOCK_LABEL_59;
        if(as.length > 0)
            techlistparcel = new TechListParcel(as);
        ActivityThread.currentActivityThread().registerOnActivityPausedListener(activity, mForegroundDispatchListener);
        sService.setForegroundDispatch(pendingintent, aintentfilter, techlistparcel);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        attemptDeadServiceRecovery(remoteexception);
          goto _L1
    }

    public void enableForegroundNdefPush(Activity activity, NdefMessage ndefmessage) {
        if(activity == null || ndefmessage == null) {
            throw new NullPointerException();
        } else {
            enforceResumed(activity);
            mNfcActivityManager.setNdefPushMessage(activity, ndefmessage);
            return;
        }
    }

    public boolean enableNdefPush() {
        boolean flag1 = sService.enableNdefPush();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        attemptDeadServiceRecovery(remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    void enforceResumed(Activity activity) {
        if(!activity.isResumed())
            throw new IllegalStateException("API cannot be called while activity is paused");
        else
            return;
    }

    public int getAdapterState() {
        int j = sService.getState();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        attemptDeadServiceRecovery(remoteexception);
        i = 1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public Context getContext() {
        return mContext;
    }

    public INfcAdapterExtras getNfcAdapterExtrasInterface() {
        if(mContext == null)
            throw new UnsupportedOperationException("You need a context on NfcAdapter to use the  NFC extras APIs");
        INfcAdapterExtras infcadapterextras1 = sService.getNfcAdapterExtrasInterface(mContext.getPackageName());
        INfcAdapterExtras infcadapterextras = infcadapterextras1;
_L2:
        return infcadapterextras;
        RemoteException remoteexception;
        remoteexception;
        attemptDeadServiceRecovery(remoteexception);
        infcadapterextras = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    int getSdkVersion() {
        int i;
        if(mContext == null)
            i = 9;
        else
            i = mContext.getApplicationInfo().targetSdkVersion;
        return i;
    }

    public INfcAdapter getService() {
        isEnabled();
        return sService;
    }

    public INfcTag getTagService() {
        isEnabled();
        return sTagService;
    }

    public boolean isEnabled() {
        boolean flag = false;
        int i = sService.getState();
        if(i == 3)
            flag = true;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        attemptDeadServiceRecovery(remoteexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isNdefPushEnabled() {
        boolean flag1 = sService.isNdefPushEnabled();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        attemptDeadServiceRecovery(remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setBeamPushUris(Uri auri[], Activity activity) {
        if(activity == null)
            throw new NullPointerException("activity cannot be null");
        if(auri != null) {
            int i = auri.length;
            for(int j = 0; j < i; j++) {
                Uri uri = auri[j];
                if(uri == null)
                    throw new NullPointerException("Uri not allowed to be null");
                String s = uri.getScheme();
                if(s == null || !s.equalsIgnoreCase("file") && !s.equalsIgnoreCase("content"))
                    throw new IllegalArgumentException("URI needs to have either scheme file or scheme content");
            }

        }
        mNfcActivityManager.setNdefPushContentUri(activity, auri);
    }

    public void setBeamPushUrisCallback(CreateBeamUrisCallback createbeamuriscallback, Activity activity) {
        if(activity == null) {
            throw new NullPointerException("activity cannot be null");
        } else {
            mNfcActivityManager.setNdefPushContentUriCallback(activity, createbeamuriscallback);
            return;
        }
    }

    public transient void setNdefPushMessage(NdefMessage ndefmessage, Activity activity, Activity aactivity[]) {
        int i = getSdkVersion();
        if(activity != null) goto _L2; else goto _L1
_L1:
        throw new NullPointerException("activity cannot be null");
        IllegalStateException illegalstateexception;
        illegalstateexception;
        if(i >= 16)
            break MISSING_BLOCK_LABEL_103;
        Log.e("NFC", "Cannot call API with Activity that has already been destroyed", illegalstateexception);
_L6:
        return;
_L2:
        int j;
        int k;
        mNfcActivityManager.setNdefPushMessage(activity, ndefmessage);
        j = aactivity.length;
        k = 0;
_L4:
        if(k >= j)
            break; /* Loop/switch isn't completed */
        Activity activity1 = aactivity[k];
        if(activity1 == null)
            throw new NullPointerException("activities cannot contain null");
        mNfcActivityManager.setNdefPushMessage(activity1, ndefmessage);
        k++;
        if(true) goto _L4; else goto _L3
_L3:
        if(true) goto _L6; else goto _L5
_L5:
        throw illegalstateexception;
    }

    public transient void setNdefPushMessageCallback(CreateNdefMessageCallback createndefmessagecallback, Activity activity, Activity aactivity[]) {
        int i = getSdkVersion();
        if(activity != null) goto _L2; else goto _L1
_L1:
        throw new NullPointerException("activity cannot be null");
        IllegalStateException illegalstateexception;
        illegalstateexception;
        if(i >= 16)
            break MISSING_BLOCK_LABEL_103;
        Log.e("NFC", "Cannot call API with Activity that has already been destroyed", illegalstateexception);
_L6:
        return;
_L2:
        int j;
        int k;
        mNfcActivityManager.setNdefPushMessageCallback(activity, createndefmessagecallback);
        j = aactivity.length;
        k = 0;
_L4:
        if(k >= j)
            break; /* Loop/switch isn't completed */
        Activity activity1 = aactivity[k];
        if(activity1 == null)
            throw new NullPointerException("activities cannot contain null");
        mNfcActivityManager.setNdefPushMessageCallback(activity1, createndefmessagecallback);
        k++;
        if(true) goto _L4; else goto _L3
_L3:
        if(true) goto _L6; else goto _L5
_L5:
        throw illegalstateexception;
    }

    public transient void setOnNdefPushCompleteCallback(OnNdefPushCompleteCallback onndefpushcompletecallback, Activity activity, Activity aactivity[]) {
        int i = getSdkVersion();
        if(activity != null) goto _L2; else goto _L1
_L1:
        throw new NullPointerException("activity cannot be null");
        IllegalStateException illegalstateexception;
        illegalstateexception;
        if(i >= 16)
            break MISSING_BLOCK_LABEL_103;
        Log.e("NFC", "Cannot call API with Activity that has already been destroyed", illegalstateexception);
_L6:
        return;
_L2:
        int j;
        int k;
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity, onndefpushcompletecallback);
        j = aactivity.length;
        k = 0;
_L4:
        if(k >= j)
            break; /* Loop/switch isn't completed */
        Activity activity1 = aactivity[k];
        if(activity1 == null)
            throw new NullPointerException("activities cannot contain null");
        mNfcActivityManager.setOnNdefPushCompleteCallback(activity1, onndefpushcompletecallback);
        k++;
        if(true) goto _L4; else goto _L3
_L3:
        if(true) goto _L6; else goto _L5
_L5:
        throw illegalstateexception;
    }

    public void setP2pModes(int i, int j) {
        sService.setP2pModes(i, j);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        attemptDeadServiceRecovery(remoteexception);
          goto _L1
    }

    public static final String ACTION_ADAPTER_STATE_CHANGED = "android.nfc.action.ADAPTER_STATE_CHANGED";
    public static final String ACTION_HANDOVER_TRANSFER_DONE = "android.nfc.action.HANDOVER_TRANSFER_DONE";
    public static final String ACTION_HANDOVER_TRANSFER_STARTED = "android.nfc.action.HANDOVER_TRANSFER_STARTED";
    public static final String ACTION_NDEF_DISCOVERED = "android.nfc.action.NDEF_DISCOVERED";
    public static final String ACTION_TAG_DISCOVERED = "android.nfc.action.TAG_DISCOVERED";
    public static final String ACTION_TAG_LEFT_FIELD = "android.nfc.action.TAG_LOST";
    public static final String ACTION_TECH_DISCOVERED = "android.nfc.action.TECH_DISCOVERED";
    public static final String EXTRA_ADAPTER_STATE = "android.nfc.extra.ADAPTER_STATE";
    public static final String EXTRA_HANDOVER_TRANSFER_STATUS = "android.nfc.extra.HANDOVER_TRANSFER_STATUS";
    public static final String EXTRA_HANDOVER_TRANSFER_URI = "android.nfc.extra.HANDOVER_TRANSFER_URI";
    public static final String EXTRA_ID = "android.nfc.extra.ID";
    public static final String EXTRA_NDEF_MESSAGES = "android.nfc.extra.NDEF_MESSAGES";
    public static final String EXTRA_TAG = "android.nfc.extra.TAG";
    public static final int HANDOVER_TRANSFER_STATUS_FAILURE = 1;
    public static final int HANDOVER_TRANSFER_STATUS_SUCCESS = 0;
    public static final int STATE_OFF = 1;
    public static final int STATE_ON = 3;
    public static final int STATE_TURNING_OFF = 4;
    public static final int STATE_TURNING_ON = 2;
    static final String TAG = "NFC";
    static boolean sIsInitialized = false;
    static HashMap sNfcAdapters = new HashMap();
    static NfcAdapter sNullContextNfcAdapter;
    static INfcAdapter sService;
    static INfcTag sTagService;
    final Context mContext;
    OnActivityPausedListener mForegroundDispatchListener;
    final NfcActivityManager mNfcActivityManager = new NfcActivityManager(this);

}
