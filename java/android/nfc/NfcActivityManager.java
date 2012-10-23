// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.Window;
import java.util.*;

// Referenced classes of package android.nfc:
//            NfcEvent, NfcAdapter, INfcAdapter, NdefMessage

public final class NfcActivityManager extends INdefPushCallback.Stub
    implements android.app.Application.ActivityLifecycleCallbacks {
    class NfcActivityState {

        public void destroy() {
            unregisterApplication(activity.getApplication());
            resumed = false;
            activity = null;
            ndefMessage = null;
            ndefMessageCallback = null;
            onNdefPushCompleteCallback = null;
            uriCallback = null;
            uris = null;
        }

        public String toString() {
            StringBuilder stringbuilder = (new StringBuilder("[")).append(" ");
            stringbuilder.append(ndefMessage).append(" ").append(ndefMessageCallback).append(" ");
            stringbuilder.append(uriCallback).append(" ");
            if(uris != null) {
                Uri auri[] = uris;
                int i = auri.length;
                for(int j = 0; j < i; j++) {
                    Uri uri = auri[j];
                    stringbuilder.append(onNdefPushCompleteCallback).append(" ").append(uri).append("]");
                }

            }
            return stringbuilder.toString();
        }

        Activity activity;
        NdefMessage ndefMessage;
        NfcAdapter.CreateNdefMessageCallback ndefMessageCallback;
        NfcAdapter.OnNdefPushCompleteCallback onNdefPushCompleteCallback;
        boolean resumed;
        final NfcActivityManager this$0;
        NfcAdapter.CreateBeamUrisCallback uriCallback;
        Uri uris[];

        public NfcActivityState(Activity activity1) {
            this$0 = NfcActivityManager.this;
            super();
            resumed = false;
            ndefMessage = null;
            ndefMessageCallback = null;
            onNdefPushCompleteCallback = null;
            uriCallback = null;
            uris = null;
            if(activity1.getWindow().isDestroyed()) {
                throw new IllegalStateException("activity is already destroyed");
            } else {
                resumed = activity1.isResumed();
                activity = activity1;
                registerApplication(activity1.getApplication());
                return;
            }
        }
    }

    class NfcApplicationState {

        public void register() {
            refCount = 1 + refCount;
            if(refCount == 1)
                app.registerActivityLifecycleCallbacks(NfcActivityManager.this);
        }

        public void unregister() {
            refCount = -1 + refCount;
            if(refCount != 0) goto _L2; else goto _L1
_L1:
            app.unregisterActivityLifecycleCallbacks(NfcActivityManager.this);
_L4:
            return;
_L2:
            if(refCount < 0)
                Log.e("NFC", (new StringBuilder()).append("-ve refcount for ").append(app).toString());
            if(true) goto _L4; else goto _L3
_L3:
        }

        final Application app;
        int refCount;
        final NfcActivityManager this$0;

        public NfcApplicationState(Application application) {
            this$0 = NfcActivityManager.this;
            super();
            refCount = 0;
            app = application;
        }
    }


    public NfcActivityManager(NfcAdapter nfcadapter) {
        mAdapter = nfcadapter;
        mDefaultEvent = new NfcEvent(mAdapter);
    }

    public NdefMessage createMessage() {
        this;
        JVM INSTR monitorenter ;
        NfcActivityState nfcactivitystate;
        NdefMessage ndefmessage;
        nfcactivitystate = findResumedActivityState();
        if(nfcactivitystate != null)
            break MISSING_BLOCK_LABEL_19;
        ndefmessage = null;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_56;
        NfcAdapter.CreateNdefMessageCallback createndefmessagecallback;
        createndefmessagecallback = nfcactivitystate.ndefMessageCallback;
        ndefmessage = nfcactivitystate.ndefMessage;
        this;
        JVM INSTR monitorexit ;
        if(createndefmessagecallback != null)
            ndefmessage = createndefmessagecallback.createNdefMessage(mDefaultEvent);
        break MISSING_BLOCK_LABEL_56;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        return ndefmessage;
    }

    /**
     * @deprecated Method destroyActivityState is deprecated
     */

    void destroyActivityState(Activity activity) {
        this;
        JVM INSTR monitorenter ;
        NfcActivityState nfcactivitystate = findActivityState(activity);
        if(nfcactivitystate != null) {
            nfcactivitystate.destroy();
            mActivities.remove(nfcactivitystate);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method findActivityState is deprecated
     */

    NfcActivityState findActivityState(Activity activity) {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = mActivities.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        NfcActivityState nfcactivitystate;
        Activity activity1;
        nfcactivitystate = (NfcActivityState)iterator.next();
        activity1 = nfcactivitystate.activity;
        if(activity1 != activity) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return nfcactivitystate;
_L2:
        nfcactivitystate = null;
        if(true) goto _L3; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    NfcApplicationState findAppState(Application application) {
        Iterator iterator = mApps.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        NfcApplicationState nfcapplicationstate = (NfcApplicationState)iterator.next();
        if(nfcapplicationstate.app != application) goto _L4; else goto _L3
_L3:
        return nfcapplicationstate;
_L2:
        nfcapplicationstate = null;
        if(true) goto _L3; else goto _L5
_L5:
    }

    /**
     * @deprecated Method findResumedActivityState is deprecated
     */

    NfcActivityState findResumedActivityState() {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = mActivities.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        NfcActivityState nfcactivitystate;
        boolean flag;
        nfcactivitystate = (NfcActivityState)iterator.next();
        flag = nfcactivitystate.resumed;
        if(!flag) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return nfcactivitystate;
_L2:
        nfcactivitystate = null;
        if(true) goto _L3; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getActivityState is deprecated
     */

    NfcActivityState getActivityState(Activity activity) {
        this;
        JVM INSTR monitorenter ;
        NfcActivityState nfcactivitystate;
        nfcactivitystate = findActivityState(activity);
        if(nfcactivitystate == null) {
            nfcactivitystate = new NfcActivityState(activity);
            mActivities.add(nfcactivitystate);
        }
        this;
        JVM INSTR monitorexit ;
        return nfcactivitystate;
        Exception exception;
        exception;
        throw exception;
    }

    public Uri[] getUris() {
        this;
        JVM INSTR monitorenter ;
        NfcActivityState nfcactivitystate = findResumedActivityState();
        if(nfcactivitystate != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        Uri auri[] = null;
          goto _L3
_L2:
        NfcAdapter.CreateBeamUrisCallback createbeamuriscallback;
        auri = nfcactivitystate.uris;
        createbeamuriscallback = nfcactivitystate.uriCallback;
        this;
        JVM INSTR monitorexit ;
        if(createbeamuriscallback == null) goto _L3; else goto _L4
_L4:
        auri = createbeamuriscallback.createBeamUris(mDefaultEvent);
        if(auri == null) goto _L3; else goto _L5
_L5:
        Uri auri1[];
        int i;
        int j;
        auri1 = auri;
        i = auri1.length;
        j = 0;
_L6:
        Uri uri;
        if(j >= i)
            break; /* Loop/switch isn't completed */
        uri = auri1[j];
        if(uri == null) {
            Log.e("NFC", "Uri not allowed to be null.");
            auri = null;
            break; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_100;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        String s = uri.getScheme();
        if(s == null || !s.equalsIgnoreCase("file") && !s.equalsIgnoreCase("content")) {
            Log.e("NFC", "Uri needs to have either scheme file or scheme content");
            auri = null;
            break; /* Loop/switch isn't completed */
        }
        j++;
        if(true) goto _L6; else goto _L3
_L3:
        return auri;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        this;
        JVM INSTR monitorenter ;
        NfcActivityState nfcactivitystate = findActivityState(activity);
        if(DBG.booleanValue())
            Log.d("NFC", (new StringBuilder()).append("onDestroy() for ").append(activity).append(" ").append(nfcactivitystate).toString());
        if(nfcactivitystate != null)
            destroyActivityState(activity);
        return;
    }

    public void onActivityPaused(Activity activity) {
        this;
        JVM INSTR monitorenter ;
        NfcActivityState nfcactivitystate;
        nfcactivitystate = findActivityState(activity);
        if(DBG.booleanValue())
            Log.d("NFC", (new StringBuilder()).append("onPause() for ").append(activity).append(" ").append(nfcactivitystate).toString());
        if(nfcactivitystate != null)
            break MISSING_BLOCK_LABEL_60;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_80;
        nfcactivitystate.resumed = false;
        this;
        JVM INSTR monitorexit ;
        requestNfcServiceCallback(false);
        break MISSING_BLOCK_LABEL_80;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onActivityResumed(Activity activity) {
        this;
        JVM INSTR monitorenter ;
        NfcActivityState nfcactivitystate;
        nfcactivitystate = findActivityState(activity);
        if(DBG.booleanValue())
            Log.d("NFC", (new StringBuilder()).append("onResume() for ").append(activity).append(" ").append(nfcactivitystate).toString());
        if(nfcactivitystate != null)
            break MISSING_BLOCK_LABEL_60;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_80;
        nfcactivitystate.resumed = true;
        this;
        JVM INSTR monitorexit ;
        requestNfcServiceCallback(true);
        break MISSING_BLOCK_LABEL_80;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onNdefPushComplete() {
        this;
        JVM INSTR monitorenter ;
        NfcActivityState nfcactivitystate;
        nfcactivitystate = findResumedActivityState();
        if(nfcactivitystate != null)
            break MISSING_BLOCK_LABEL_16;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_45;
        NfcAdapter.OnNdefPushCompleteCallback onndefpushcompletecallback = nfcactivitystate.onNdefPushCompleteCallback;
        this;
        JVM INSTR monitorexit ;
        if(onndefpushcompletecallback != null)
            onndefpushcompletecallback.onNdefPushComplete(mDefaultEvent);
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void registerApplication(Application application) {
        NfcApplicationState nfcapplicationstate = findAppState(application);
        if(nfcapplicationstate == null) {
            nfcapplicationstate = new NfcApplicationState(application);
            mApps.add(nfcapplicationstate);
        }
        nfcapplicationstate.register();
    }

    void requestNfcServiceCallback(boolean flag) {
        INfcAdapter infcadapter = NfcAdapter.sService;
        if(!flag) goto _L2; else goto _L1
_L1:
        NfcActivityManager nfcactivitymanager = this;
_L3:
        infcadapter.setNdefPushCallback(nfcactivitymanager);
_L4:
        return;
_L2:
        nfcactivitymanager = null;
          goto _L3
        RemoteException remoteexception;
        remoteexception;
        mAdapter.attemptDeadServiceRecovery(remoteexception);
          goto _L4
    }

    public void setNdefPushContentUri(Activity activity, Uri auri[]) {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        NfcActivityState nfcactivitystate = getActivityState(activity);
        nfcactivitystate.uris = auri;
        flag = nfcactivitystate.resumed;
        this;
        JVM INSTR monitorexit ;
        if(flag)
            requestNfcServiceCallback(true);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setNdefPushContentUriCallback(Activity activity, NfcAdapter.CreateBeamUrisCallback createbeamuriscallback) {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        NfcActivityState nfcactivitystate = getActivityState(activity);
        nfcactivitystate.uriCallback = createbeamuriscallback;
        flag = nfcactivitystate.resumed;
        this;
        JVM INSTR monitorexit ;
        if(flag)
            requestNfcServiceCallback(true);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setNdefPushMessage(Activity activity, NdefMessage ndefmessage) {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        NfcActivityState nfcactivitystate = getActivityState(activity);
        nfcactivitystate.ndefMessage = ndefmessage;
        flag = nfcactivitystate.resumed;
        this;
        JVM INSTR monitorexit ;
        if(flag)
            requestNfcServiceCallback(true);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setNdefPushMessageCallback(Activity activity, NfcAdapter.CreateNdefMessageCallback createndefmessagecallback) {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        NfcActivityState nfcactivitystate = getActivityState(activity);
        nfcactivitystate.ndefMessageCallback = createndefmessagecallback;
        flag = nfcactivitystate.resumed;
        this;
        JVM INSTR monitorexit ;
        if(flag)
            requestNfcServiceCallback(true);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setOnNdefPushCompleteCallback(Activity activity, NfcAdapter.OnNdefPushCompleteCallback onndefpushcompletecallback) {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        NfcActivityState nfcactivitystate = getActivityState(activity);
        nfcactivitystate.onNdefPushCompleteCallback = onndefpushcompletecallback;
        flag = nfcactivitystate.resumed;
        this;
        JVM INSTR monitorexit ;
        if(flag)
            requestNfcServiceCallback(true);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void unregisterApplication(Application application) {
        NfcApplicationState nfcapplicationstate = findAppState(application);
        if(nfcapplicationstate == null)
            Log.e("NFC", (new StringBuilder()).append("app was not registered ").append(application).toString());
        else
            nfcapplicationstate.unregister();
    }

    static final Boolean DBG = Boolean.valueOf(false);
    static final String TAG = "NFC";
    final List mActivities = new LinkedList();
    final NfcAdapter mAdapter;
    final List mApps = new ArrayList(1);
    final NfcEvent mDefaultEvent;

}
