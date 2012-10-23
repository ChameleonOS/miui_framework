// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.*;
import android.content.res.Configuration;
import android.hardware.input.InputManager;
import android.os.*;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.app:
//            Application, ActivityThread, Activity, IApplicationThread, 
//            ActivityManagerNative, IActivityManager, Fragment, IInstrumentationWatcher

public class Instrumentation {
    private static final class Idler
        implements android.os.MessageQueue.IdleHandler {

        public final boolean queueIdle() {
            if(mCallback != null)
                mCallback.run();
            this;
            JVM INSTR monitorenter ;
            mIdle = true;
            notifyAll();
            return false;
        }

        public void waitForIdle() {
            this;
            JVM INSTR monitorenter ;
_L3:
            boolean flag = mIdle;
            if(flag) goto _L2; else goto _L1
_L1:
            Exception exception;
            try {
                wait();
            }
            catch(InterruptedException interruptedexception) { }
            finally {
                this;
            }
            if(true) goto _L3; else goto _L2
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
            throw exception;
        }

        private final Runnable mCallback;
        private boolean mIdle;

        public Idler(Runnable runnable) {
            mCallback = runnable;
            mIdle = false;
        }
    }

    private final class ActivityGoing
        implements android.os.MessageQueue.IdleHandler {

        public final boolean queueIdle() {
            Object obj = mSync;
            obj;
            JVM INSTR monitorenter ;
            mWaitingActivities.remove(mWaiter);
            mSync.notifyAll();
            return false;
        }

        private final ActivityWaiter mWaiter;
        final Instrumentation this$0;

        public ActivityGoing(ActivityWaiter activitywaiter) {
            this$0 = Instrumentation.this;
            super();
            mWaiter = activitywaiter;
        }
    }

    private static final class ActivityWaiter {

        public Activity activity;
        public final Intent intent;

        public ActivityWaiter(Intent intent1) {
            intent = intent1;
        }
    }

    private static final class SyncRunnable
        implements Runnable {

        public void run() {
            mTarget.run();
            this;
            JVM INSTR monitorenter ;
            mComplete = true;
            notifyAll();
            return;
        }

        public void waitForComplete() {
            this;
            JVM INSTR monitorenter ;
_L3:
            boolean flag = mComplete;
            if(flag) goto _L2; else goto _L1
_L1:
            Exception exception;
            try {
                wait();
            }
            catch(InterruptedException interruptedexception) { }
            finally {
                this;
            }
            if(true) goto _L3; else goto _L2
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
            throw exception;
        }

        private boolean mComplete;
        private final Runnable mTarget;

        public SyncRunnable(Runnable runnable) {
            mTarget = runnable;
        }
    }

    private static final class EmptyRunnable
        implements Runnable {

        public void run() {
        }

        private EmptyRunnable() {
        }

    }

    private final class InstrumentationThread extends Thread {

        public void run() {
            ActivityManagerNative.getDefault();
            try {
                Process.setThreadPriority(-8);
            }
            catch(RuntimeException runtimeexception) {
                Log.w("Instrumentation", (new StringBuilder()).append("Exception setting priority of instrumentation thread ").append(Process.myTid()).toString(), runtimeexception);
            }
            if(mAutomaticPerformanceSnapshots)
                startPerformanceSnapshot();
            onStart();
        }

        final Instrumentation this$0;

        public InstrumentationThread(String s) {
            this$0 = Instrumentation.this;
            super(s);
        }
    }

    public static final class ActivityResult {

        public int getResultCode() {
            return mResultCode;
        }

        public Intent getResultData() {
            return mResultData;
        }

        private final int mResultCode;
        private final Intent mResultData;

        public ActivityResult(int i, Intent intent) {
            mResultCode = i;
            mResultData = intent;
        }
    }

    public static class ActivityMonitor {

        public final IntentFilter getFilter() {
            return mWhich;
        }

        public final int getHits() {
            return mHits;
        }

        public final Activity getLastActivity() {
            return mLastActivity;
        }

        public final ActivityResult getResult() {
            return mResult;
        }

        public final boolean isBlocking() {
            return mBlock;
        }

        final boolean match(Context context, Activity activity, Intent intent) {
            boolean flag = false;
            this;
            JVM INSTR monitorenter ;
            String s;
            if(mWhich != null && mWhich.match(context.getContentResolver(), intent, true, "Instrumentation") < 0)
                break MISSING_BLOCK_LABEL_124;
            if(mClass == null)
                break MISSING_BLOCK_LABEL_106;
            s = null;
            if(activity == null) goto _L2; else goto _L1
_L1:
            s = activity.getClass().getName();
_L4:
            if(s == null || !mClass.equals(s))
                break MISSING_BLOCK_LABEL_124;
            break MISSING_BLOCK_LABEL_106;
            Exception exception;
            exception;
            throw exception;
_L2:
            if(intent.getComponent() == null) goto _L4; else goto _L3
_L3:
            s = intent.getComponent().getClassName();
              goto _L4
            if(activity != null) {
                mLastActivity = activity;
                notifyAll();
            }
            this;
            JVM INSTR monitorexit ;
            flag = true;
            return flag;
        }

        public final Activity waitForActivity() {
            this;
            JVM INSTR monitorenter ;
_L3:
            Activity activity = mLastActivity;
            if(activity != null) goto _L2; else goto _L1
_L1:
            Exception exception;
            try {
                wait();
            }
            catch(InterruptedException interruptedexception) { }
            finally {
                this;
            }
            if(true) goto _L3; else goto _L2
_L2:
            Activity activity1 = mLastActivity;
            mLastActivity = null;
            return activity1;
            throw exception;
        }

        public final Activity waitForActivityWithTimeout(long l) {
            Activity activity = null;
            this;
            JVM INSTR monitorenter ;
            Activity activity1 = mLastActivity;
            Exception exception;
            if(activity1 == null)
                try {
                    wait(l);
                }
                catch(InterruptedException interruptedexception) { }
                finally {
                    this;
                }
            if(mLastActivity == null)
                break MISSING_BLOCK_LABEL_59;
            activity = mLastActivity;
            mLastActivity = null;
            if(true)
                break MISSING_BLOCK_LABEL_59;
            JVM INSTR monitorexit ;
            throw exception;
            return activity;
        }

        private final boolean mBlock;
        private final String mClass;
        int mHits;
        Activity mLastActivity;
        private final ActivityResult mResult;
        private final IntentFilter mWhich;

        public ActivityMonitor(IntentFilter intentfilter, ActivityResult activityresult, boolean flag) {
            mHits = 0;
            mLastActivity = null;
            mWhich = intentfilter;
            mClass = null;
            mResult = activityresult;
            mBlock = flag;
        }

        public ActivityMonitor(String s, ActivityResult activityresult, boolean flag) {
            mHits = 0;
            mLastActivity = null;
            mWhich = null;
            mClass = s;
            mResult = activityresult;
            mBlock = flag;
        }
    }


    public Instrumentation() {
        mThread = null;
        mMessageQueue = null;
        mAutomaticPerformanceSnapshots = false;
        mPerfMetrics = new Bundle();
    }

    private void addValue(String s, int i, Bundle bundle) {
        if(bundle.containsKey(s)) {
            ArrayList arraylist1 = bundle.getIntegerArrayList(s);
            if(arraylist1 != null)
                arraylist1.add(Integer.valueOf(i));
        } else {
            ArrayList arraylist = new ArrayList();
            arraylist.add(Integer.valueOf(i));
            bundle.putIntegerArrayList(s, arraylist);
        }
    }

    static void checkStartActivityResult(int i, Object obj) {
        if(i >= 0)
            return;
        switch(i) {
        default:
            throw new AndroidRuntimeException((new StringBuilder()).append("Unknown error code ").append(i).append(" when starting ").append(obj).toString());

        case -2: 
        case -1: 
            if((obj instanceof Intent) && ((Intent)obj).getComponent() != null)
                throw new ActivityNotFoundException((new StringBuilder()).append("Unable to find explicit activity class ").append(((Intent)obj).getComponent().toShortString()).append("; have you declared this activity in your AndroidManifest.xml?").toString());
            else
                throw new ActivityNotFoundException((new StringBuilder()).append("No Activity found to handle ").append(obj).toString());

        case -4: 
            throw new SecurityException((new StringBuilder()).append("Not allowed to start activity ").append(obj).toString());

        case -3: 
            throw new AndroidRuntimeException("FORWARD_RESULT_FLAG used while also requesting a result");

        case -5: 
            throw new IllegalArgumentException("PendingIntent is not an activity");
        }
    }

    public static Application newApplication(Class class1, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Application application = (Application)class1.newInstance();
        application.attach(context);
        return application;
    }

    private final void validateNotAppThread() {
        if(ActivityThread.currentActivityThread() != null)
            throw new RuntimeException("This method can not be called from the main application thread");
        else
            return;
    }

    public ActivityMonitor addMonitor(IntentFilter intentfilter, ActivityResult activityresult, boolean flag) {
        ActivityMonitor activitymonitor = new ActivityMonitor(intentfilter, activityresult, flag);
        addMonitor(activitymonitor);
        return activitymonitor;
    }

    public ActivityMonitor addMonitor(String s, ActivityResult activityresult, boolean flag) {
        ActivityMonitor activitymonitor = new ActivityMonitor(s, activityresult, flag);
        addMonitor(activitymonitor);
        return activitymonitor;
    }

    public void addMonitor(ActivityMonitor activitymonitor) {
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        if(mActivityMonitors == null)
            mActivityMonitors = new ArrayList();
        mActivityMonitors.add(activitymonitor);
        return;
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        if(mWaitingActivities == null)
            break MISSING_BLOCK_LABEL_96;
        Object obj1 = mSync;
        obj1;
        JVM INSTR monitorenter ;
        int k;
        k = mWaitingActivities.size();
        Object obj;
        Exception exception;
        int i;
        int j;
        Exception exception1;
        for(int l = 0; l < k; l++) {
            ActivityWaiter activitywaiter = (ActivityWaiter)mWaitingActivities.get(l);
            if(activitywaiter.intent.filterEquals(activity.getIntent())) {
                activitywaiter.activity = activity;
                mMessageQueue.addIdleHandler(new ActivityGoing(activitywaiter));
            }
            break MISSING_BLOCK_LABEL_187;
        }

        activity.performCreate(bundle);
        if(mActivityMonitors == null)
            break MISSING_BLOCK_LABEL_193;
        obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        i = mActivityMonitors.size();
        j = 0;
_L1:
        if(j >= i)
            break MISSING_BLOCK_LABEL_175;
        ((ActivityMonitor)mActivityMonitors.get(j)).match(activity, activity, activity.getIntent());
        j++;
          goto _L1
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_193;
        exception;
        throw exception;
    }

    public void callActivityOnDestroy(Activity activity) {
        activity.performDestroy();
        if(mActivityMonitors == null)
            break MISSING_BLOCK_LABEL_79;
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        int i = mActivityMonitors.size();
        for(int j = 0; j < i; j++)
            ((ActivityMonitor)mActivityMonitors.get(j)).match(activity, activity, activity.getIntent());

    }

    public void callActivityOnNewIntent(Activity activity, Intent intent) {
        activity.onNewIntent(intent);
    }

    public void callActivityOnPause(Activity activity) {
        activity.performPause();
    }

    public void callActivityOnPostCreate(Activity activity, Bundle bundle) {
        activity.onPostCreate(bundle);
    }

    public void callActivityOnRestart(Activity activity) {
        activity.onRestart();
    }

    public void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle) {
        activity.performRestoreInstanceState(bundle);
    }

    public void callActivityOnResume(Activity activity) {
        activity.mResumed = true;
        activity.onResume();
        if(mActivityMonitors == null)
            break MISSING_BLOCK_LABEL_84;
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        int i = mActivityMonitors.size();
        for(int j = 0; j < i; j++)
            ((ActivityMonitor)mActivityMonitors.get(j)).match(activity, activity, activity.getIntent());

    }

    public void callActivityOnSaveInstanceState(Activity activity, Bundle bundle) {
        activity.performSaveInstanceState(bundle);
    }

    public void callActivityOnStart(Activity activity) {
        activity.onStart();
    }

    public void callActivityOnStop(Activity activity) {
        activity.onStop();
    }

    public void callActivityOnUserLeaving(Activity activity) {
        activity.performUserLeaving();
    }

    public void callApplicationOnCreate(Application application) {
        application.onCreate();
    }

    public boolean checkMonitorHit(ActivityMonitor activitymonitor, int i) {
        waitForIdleSync();
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if(activitymonitor.getHits() < i) {
            flag = false;
        } else {
            mActivityMonitors.remove(activitymonitor);
            flag = true;
        }
        return flag;
    }

    public void endPerformanceSnapshot() {
        if(!isProfiling())
            mPerfMetrics = mPerformanceCollector.endSnapshot();
    }

    public void execStartActivities(Context context, IBinder ibinder, IBinder ibinder1, Activity activity, Intent aintent[], Bundle bundle) {
        IApplicationThread iapplicationthread = (IApplicationThread)ibinder;
        if(mActivityMonitors == null) goto _L2; else goto _L1
_L1:
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        int j;
        int k;
        j = mActivityMonitors.size();
        k = 0;
_L6:
        if(k >= j) goto _L2; else goto _L3
_L3:
        ActivityMonitor activitymonitor;
        activitymonitor = (ActivityMonitor)mActivityMonitors.get(k);
        if(!activitymonitor.match(context, null, aintent[0]))
            break MISSING_BLOCK_LABEL_191;
        activitymonitor.mHits = 1 + activitymonitor.mHits;
        if(!activitymonitor.isBlocking()) goto _L2; else goto _L4
_L2:
        String as[];
        int i;
        as = new String[aintent.length];
        i = 0;
_L5:
        if(i >= aintent.length)
            break MISSING_BLOCK_LABEL_161;
        aintent[i].setAllowFds(false);
        as[i] = aintent[i].resolveTypeIfNeeded(context.getContentResolver());
        i++;
          goto _L5
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        try {
            checkStartActivityResult(ActivityManagerNative.getDefault().startActivities(iapplicationthread, aintent, as, ibinder1, bundle), aintent[0]);
        }
        catch(RemoteException remoteexception) { }
_L4:
        return;
        k++;
          goto _L6
    }

    public ActivityResult execStartActivity(Context context, IBinder ibinder, IBinder ibinder1, Activity activity, Intent intent, int i, Bundle bundle) {
        IApplicationThread iapplicationthread = (IApplicationThread)ibinder;
        if(mActivityMonitors == null) goto _L2; else goto _L1
_L1:
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        int j;
        int k;
        j = mActivityMonitors.size();
        k = 0;
_L14:
        if(k >= j) goto _L2; else goto _L3
_L3:
        ActivityMonitor activitymonitor = (ActivityMonitor)mActivityMonitors.get(k);
        if(!activitymonitor.match(context, null, intent)) goto _L5; else goto _L4
_L4:
        activitymonitor.mHits = 1 + activitymonitor.mHits;
        if(!activitymonitor.isBlocking()) goto _L2; else goto _L6
_L6:
        if(i < 0) goto _L8; else goto _L7
_L7:
        ActivityResult activityresult = activitymonitor.getResult();
          goto _L9
_L2:
        IActivityManager iactivitymanager;
        String s;
        intent.setAllowFds(false);
        intent.migrateExtraStreamToClipData();
        iactivitymanager = ActivityManagerNative.getDefault();
        s = intent.resolveTypeIfNeeded(context.getContentResolver());
        if(activity == null) goto _L11; else goto _L10
_L10:
        String s1 = activity.mEmbeddedID;
_L13:
        checkStartActivityResult(iactivitymanager.startActivity(iapplicationthread, intent, s, ibinder1, s1, i, 0, null, null, bundle), intent);
_L12:
        activityresult = null;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L11:
        s1 = null;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L12; else goto _L9
_L9:
        return activityresult;
        if(true) goto _L13; else goto _L8
_L8:
        activityresult = null;
        if(true) goto _L9; else goto _L5
_L5:
        k++;
          goto _L14
    }

    public ActivityResult execStartActivity(Context context, IBinder ibinder, IBinder ibinder1, Fragment fragment, Intent intent, int i, Bundle bundle) {
        IApplicationThread iapplicationthread = (IApplicationThread)ibinder;
        if(mActivityMonitors == null) goto _L2; else goto _L1
_L1:
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        int j;
        int k;
        j = mActivityMonitors.size();
        k = 0;
_L14:
        if(k >= j) goto _L2; else goto _L3
_L3:
        ActivityMonitor activitymonitor = (ActivityMonitor)mActivityMonitors.get(k);
        if(!activitymonitor.match(context, null, intent)) goto _L5; else goto _L4
_L4:
        activitymonitor.mHits = 1 + activitymonitor.mHits;
        if(!activitymonitor.isBlocking()) goto _L2; else goto _L6
_L6:
        if(i < 0) goto _L8; else goto _L7
_L7:
        ActivityResult activityresult = activitymonitor.getResult();
          goto _L9
_L2:
        IActivityManager iactivitymanager;
        String s;
        intent.setAllowFds(false);
        intent.migrateExtraStreamToClipData();
        iactivitymanager = ActivityManagerNative.getDefault();
        s = intent.resolveTypeIfNeeded(context.getContentResolver());
        if(fragment == null) goto _L11; else goto _L10
_L10:
        String s1 = fragment.mWho;
_L13:
        checkStartActivityResult(iactivitymanager.startActivity(iapplicationthread, intent, s, ibinder1, s1, i, 0, null, null, bundle), intent);
_L12:
        activityresult = null;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L11:
        s1 = null;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L12; else goto _L9
_L9:
        return activityresult;
        if(true) goto _L13; else goto _L8
_L8:
        activityresult = null;
        if(true) goto _L9; else goto _L5
_L5:
        k++;
          goto _L14
    }

    public void finish(int i, Bundle bundle) {
        if(mAutomaticPerformanceSnapshots)
            endPerformanceSnapshot();
        if(mPerfMetrics != null)
            bundle.putAll(mPerfMetrics);
        mThread.finishInstrumentation(i, bundle);
    }

    public Bundle getAllocCounts() {
        Bundle bundle = new Bundle();
        bundle.putLong("global_alloc_count", Debug.getGlobalAllocCount());
        bundle.putLong("global_alloc_size", Debug.getGlobalAllocSize());
        bundle.putLong("global_freed_count", Debug.getGlobalFreedCount());
        bundle.putLong("global_freed_size", Debug.getGlobalFreedSize());
        bundle.putLong("gc_invocation_count", Debug.getGlobalGcInvocationCount());
        return bundle;
    }

    public Bundle getBinderCounts() {
        Bundle bundle = new Bundle();
        bundle.putLong("sent_transactions", Debug.getBinderSentTransactions());
        bundle.putLong("received_transactions", Debug.getBinderReceivedTransactions());
        return bundle;
    }

    public ComponentName getComponentName() {
        return mComponent;
    }

    public Context getContext() {
        return mInstrContext;
    }

    public Context getTargetContext() {
        return mAppContext;
    }

    final void init(ActivityThread activitythread, Context context, Context context1, ComponentName componentname, IInstrumentationWatcher iinstrumentationwatcher) {
        mThread = activitythread;
        mThread.getLooper();
        mMessageQueue = Looper.myQueue();
        mInstrContext = context;
        mAppContext = context1;
        mComponent = componentname;
        mWatcher = iinstrumentationwatcher;
    }

    public boolean invokeContextMenuAction(Activity activity, int i, int j) {
        boolean flag;
        flag = false;
        validateNotAppThread();
        sendKeySync(new KeyEvent(0, 23));
        waitForIdleSync();
        Thread.sleep(ViewConfiguration.getLongPressTimeout());
        sendKeySync(new KeyEvent(1, 23));
        waitForIdleSync();
        _cls1ContextMenuRunnable _lcls1contextmenurunnable = new _cls1ContextMenuRunnable(activity, i, j);
        runOnMainSync(_lcls1contextmenurunnable);
        flag = _lcls1contextmenurunnable.returnValue;
_L2:
        return flag;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.e("Instrumentation", "Could not sleep for long press timeout", interruptedexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean invokeMenuActionSync(Activity activity, int i, int j) {
        _cls1MenuRunnable _lcls1menurunnable = new _cls1MenuRunnable(activity, i, j);
        runOnMainSync(_lcls1menurunnable);
        return _lcls1menurunnable.returnValue;
    }

    public boolean isProfiling() {
        return mThread.isProfiling();
    }

    public Activity newActivity(Class class1, Context context, IBinder ibinder, Application application, Intent intent, ActivityInfo activityinfo, CharSequence charsequence, 
            Activity activity, String s, Object obj) throws InstantiationException, IllegalAccessException {
        Activity activity1 = (Activity)class1.newInstance();
        activity1.attach(context, null, this, ibinder, application, intent, activityinfo, charsequence, activity, s, (Activity.NonConfigurationInstances)obj, new Configuration());
        return activity1;
    }

    public Activity newActivity(ClassLoader classloader, String s, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Activity)classloader.loadClass(s).newInstance();
    }

    public Application newApplication(ClassLoader classloader, String s, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return newApplication(classloader.loadClass(s), context);
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public boolean onException(Object obj, Throwable throwable) {
        return false;
    }

    public void onStart() {
    }

    public void removeMonitor(ActivityMonitor activitymonitor) {
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        mActivityMonitors.remove(activitymonitor);
        return;
    }

    public void runOnMainSync(Runnable runnable) {
        validateNotAppThread();
        SyncRunnable syncrunnable = new SyncRunnable(runnable);
        mThread.getHandler().post(syncrunnable);
        syncrunnable.waitForComplete();
    }

    public void sendCharacterSync(int i) {
        sendKeySync(new KeyEvent(0, i));
        sendKeySync(new KeyEvent(1, i));
    }

    public void sendKeyDownUpSync(int i) {
        sendKeySync(new KeyEvent(0, i));
        sendKeySync(new KeyEvent(1, i));
    }

    public void sendKeySync(KeyEvent keyevent) {
        validateNotAppThread();
        long l = keyevent.getDownTime();
        long l1 = keyevent.getEventTime();
        int i = keyevent.getAction();
        int j = keyevent.getKeyCode();
        int k = keyevent.getRepeatCount();
        int i1 = keyevent.getMetaState();
        int j1 = keyevent.getDeviceId();
        int k1 = keyevent.getScanCode();
        int i2 = keyevent.getSource();
        int j2 = keyevent.getFlags();
        if(i2 == 0)
            i2 = 257;
        if(l1 == 0L)
            l1 = SystemClock.uptimeMillis();
        if(l == 0L)
            l = l1;
        KeyEvent keyevent1 = new KeyEvent(l, l1, i, j, k, i1, j1, k1, j2 | 8, i2);
        InputManager.getInstance().injectInputEvent(keyevent1, 2);
    }

    public void sendPointerSync(MotionEvent motionevent) {
        validateNotAppThread();
        if((2 & motionevent.getSource()) == 0)
            motionevent.setSource(4098);
        InputManager.getInstance().injectInputEvent(motionevent, 2);
    }

    public void sendStatus(int i, Bundle bundle) {
        if(mWatcher == null)
            break MISSING_BLOCK_LABEL_22;
        mWatcher.instrumentationStatus(mComponent, i, bundle);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        mWatcher = null;
          goto _L1
    }

    public void sendStringSync(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        KeyEvent akeyevent[];
        return;
_L2:
        if((akeyevent = KeyCharacterMap.load(-1).getEvents(s.toCharArray())) != null) {
            int i = 0;
            while(i < akeyevent.length)  {
                sendKeySync(KeyEvent.changeTimeRepeat(akeyevent[i], SystemClock.uptimeMillis(), 0));
                i++;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void sendTrackballEventSync(MotionEvent motionevent) {
        validateNotAppThread();
        if((4 & motionevent.getSource()) == 0)
            motionevent.setSource(0x10004);
        InputManager.getInstance().injectInputEvent(motionevent, 2);
    }

    public void setAutomaticPerformanceSnapshots() {
        mAutomaticPerformanceSnapshots = true;
        mPerformanceCollector = new PerformanceCollector();
    }

    public void setInTouchMode(boolean flag) {
        android.view.IWindowManager.Stub.asInterface(ServiceManager.getService("window")).setInTouchMode(flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void start() {
        if(mRunner != null) {
            throw new RuntimeException("Instrumentation already started");
        } else {
            mRunner = new InstrumentationThread((new StringBuilder()).append("Instr: ").append(getClass().getName()).toString());
            mRunner.start();
            return;
        }
    }

    public Activity startActivitySync(Intent intent) {
        validateNotAppThread();
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        Intent intent1 = new Intent(intent);
        ActivityInfo activityinfo;
        activityinfo = intent1.resolveActivityInfo(getTargetContext().getPackageManager(), 0);
        if(activityinfo == null)
            throw new RuntimeException((new StringBuilder()).append("Unable to resolve activity for: ").append(intent1).toString());
          goto _L1
        Exception exception;
        exception;
_L3:
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        ActivityWaiter activitywaiter;
        String s = mThread.getProcessName();
        if(!((ComponentInfo) (activityinfo)).processName.equals(s))
            throw new RuntimeException((new StringBuilder()).append("Intent in process ").append(s).append(" resolved to different process ").append(((ComponentInfo) (activityinfo)).processName).append(": ").append(intent1).toString());
        intent1.setComponent(new ComponentName(((PackageItemInfo) (((ComponentInfo) (activityinfo)).applicationInfo)).packageName, ((PackageItemInfo) (activityinfo)).name));
        activitywaiter = new ActivityWaiter(intent1);
        if(mWaitingActivities == null)
            mWaitingActivities = new ArrayList();
        mWaitingActivities.add(activitywaiter);
        getTargetContext().startActivity(intent1);
        Activity activity;
        do
            try {
                mSync.wait();
            }
            catch(InterruptedException interruptedexception) { }
        while(mWaitingActivities.contains(activitywaiter));
        activity = activitywaiter.activity;
        obj;
        JVM INSTR monitorexit ;
        return activity;
        exception;
        if(true) goto _L3; else goto _L2
_L2:
    }

    public void startAllocCounting() {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        Debug.resetAllCounts();
        Debug.startAllocCounting();
    }

    public void startPerformanceSnapshot() {
        if(!isProfiling())
            mPerformanceCollector.beginSnapshot(null);
    }

    public void startProfiling() {
        if(mThread.isProfiling()) {
            File file = new File(mThread.getProfileFilePath());
            file.getParentFile().mkdirs();
            Debug.startMethodTracing(file.toString(), 0x800000);
        }
    }

    public void stopAllocCounting() {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        Debug.stopAllocCounting();
    }

    public void stopProfiling() {
        if(mThread.isProfiling())
            Debug.stopMethodTracing();
    }

    public void waitForIdle(Runnable runnable) {
        mMessageQueue.addIdleHandler(new Idler(runnable));
        mThread.getHandler().post(new EmptyRunnable());
    }

    public void waitForIdleSync() {
        validateNotAppThread();
        Idler idler = new Idler(null);
        mMessageQueue.addIdleHandler(idler);
        mThread.getHandler().post(new EmptyRunnable());
        idler.waitForIdle();
    }

    public Activity waitForMonitor(ActivityMonitor activitymonitor) {
        Activity activity = activitymonitor.waitForActivity();
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        mActivityMonitors.remove(activitymonitor);
        return activity;
    }

    public Activity waitForMonitorWithTimeout(ActivityMonitor activitymonitor, long l) {
        Activity activity = activitymonitor.waitForActivityWithTimeout(l);
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        mActivityMonitors.remove(activitymonitor);
        return activity;
    }

    public static final String REPORT_KEY_IDENTIFIER = "id";
    public static final String REPORT_KEY_STREAMRESULT = "stream";
    private static final String TAG = "Instrumentation";
    private List mActivityMonitors;
    private Context mAppContext;
    private boolean mAutomaticPerformanceSnapshots;
    private ComponentName mComponent;
    private Context mInstrContext;
    private MessageQueue mMessageQueue;
    private Bundle mPerfMetrics;
    private PerformanceCollector mPerformanceCollector;
    private Thread mRunner;
    private final Object mSync = new Object();
    private ActivityThread mThread;
    private List mWaitingActivities;
    private IInstrumentationWatcher mWatcher;




    private class _cls1ContextMenuRunnable
        implements Runnable {

        public void run() {
            returnValue = activity.getWindow().performContextMenuIdentifierAction(identifier, flags);
        }

        private final Activity activity;
        private final int flags;
        private final int identifier;
        boolean returnValue;
        final Instrumentation this$0;

        public _cls1ContextMenuRunnable(Activity activity1, int i, int j) {
            this$0 = Instrumentation.this;
            super();
            activity = activity1;
            identifier = i;
            flags = j;
        }
    }


    private class _cls1MenuRunnable
        implements Runnable {

        public void run() {
            returnValue = activity.getWindow().performPanelIdentifierAction(0, identifier, flags);
        }

        private final Activity activity;
        private final int flags;
        private final int identifier;
        boolean returnValue;
        final Instrumentation this$0;

        public _cls1MenuRunnable(Activity activity1, int i, int j) {
            this$0 = Instrumentation.this;
            super();
            activity = activity1;
            identifier = i;
            flags = j;
        }
    }

}
