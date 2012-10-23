// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.animation.ValueAnimator;
import android.app.*;
import android.content.Intent;
import android.util.*;
import android.view.IWindowManager;
import com.android.internal.os.RuntimeInit;
import dalvik.system.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.os:
//            Build, Process, SystemProperties, SystemClock, 
//            RemoteException, Parcel, Binder, Looper, 
//            MessageQueue, Handler, NetworkOnMainThreadException, ServiceManager

public final class StrictMode {
    private static final class InstanceTracker {

        public static int getInstanceCount(Class class1) {
            HashMap hashmap = sInstanceCounts;
            hashmap;
            JVM INSTR monitorenter ;
            Integer integer = (Integer)sInstanceCounts.get(class1);
            int i;
            if(integer != null)
                i = integer.intValue();
            else
                i = 0;
            return i;
        }

        protected void finalize() throws Throwable {
            HashMap hashmap = sInstanceCounts;
            hashmap;
            JVM INSTR monitorenter ;
            Integer integer = (Integer)sInstanceCounts.get(mKlass);
            if(integer != null) {
                int i = -1 + integer.intValue();
                if(i <= 0)
                    break MISSING_BLOCK_LABEL_64;
                sInstanceCounts.put(mKlass, Integer.valueOf(i));
            }
_L2:
            super.finalize();
            return;
            sInstanceCounts.remove(mKlass);
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception1;
            exception1;
            throw exception1;
            Exception exception;
            exception;
            super.finalize();
            throw exception;
        }

        private static final HashMap sInstanceCounts = new HashMap();
        private final Class mKlass;


        public InstanceTracker(Object obj) {
            mKlass = obj.getClass();
            HashMap hashmap = sInstanceCounts;
            hashmap;
            JVM INSTR monitorenter ;
            Integer integer = (Integer)sInstanceCounts.get(mKlass);
            int i;
            if(integer != null)
                i = 1 + integer.intValue();
            else
                i = 1;
            sInstanceCounts.put(mKlass, Integer.valueOf(i));
            return;
        }
    }

    private static class InstanceCountViolation extends Throwable {

        private static final StackTraceElement FAKE_STACK[];
        final Class mClass;
        final long mInstances;
        final int mLimit;

        static  {
            StackTraceElement astacktraceelement[] = new StackTraceElement[1];
            astacktraceelement[0] = new StackTraceElement("android.os.StrictMode", "setClassInstanceLimit", "StrictMode.java", 1);
            FAKE_STACK = astacktraceelement;
        }

        public InstanceCountViolation(Class class1, long l, int i) {
            super((new StringBuilder()).append(class1.toString()).append("; instances=").append(l).append("; limit=").append(i).toString());
            setStackTrace(FAKE_STACK);
            mClass = class1;
            mInstances = l;
            mLimit = i;
        }
    }

    public static class ViolationInfo {

        public void dump(Printer printer, String s) {
            crashInfo.dump(printer, s);
            printer.println((new StringBuilder()).append(s).append("policy: ").append(policy).toString());
            if(durationMillis != -1)
                printer.println((new StringBuilder()).append(s).append("durationMillis: ").append(durationMillis).toString());
            if(numInstances != -1L)
                printer.println((new StringBuilder()).append(s).append("numInstances: ").append(numInstances).toString());
            if(violationNumThisLoop != 0)
                printer.println((new StringBuilder()).append(s).append("violationNumThisLoop: ").append(violationNumThisLoop).toString());
            if(numAnimationsRunning != 0)
                printer.println((new StringBuilder()).append(s).append("numAnimationsRunning: ").append(numAnimationsRunning).toString());
            printer.println((new StringBuilder()).append(s).append("violationUptimeMillis: ").append(violationUptimeMillis).toString());
            if(broadcastIntentAction != null)
                printer.println((new StringBuilder()).append(s).append("broadcastIntentAction: ").append(broadcastIntentAction).toString());
            if(tags != null) {
                String as[] = tags;
                int i = as.length;
                int j = 0;
                int l;
                for(int k = 0; j < i; k = l) {
                    String s1 = as[j];
                    StringBuilder stringbuilder = (new StringBuilder()).append(s).append("tag[");
                    l = k + 1;
                    printer.println(stringbuilder.append(k).append("]: ").append(s1).toString());
                    j++;
                }

            }
        }

        public int hashCode() {
            int i = 629 + crashInfo.stackTrace.hashCode();
            if(numAnimationsRunning != 0)
                i *= 37;
            if(broadcastIntentAction != null)
                i = i * 37 + broadcastIntentAction.hashCode();
            if(tags != null) {
                String as[] = tags;
                int j = as.length;
                for(int k = 0; k < j; k++) {
                    String s = as[k];
                    i = i * 37 + s.hashCode();
                }

            }
            return i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            crashInfo.writeToParcel(parcel, i);
            parcel.writeInt(policy);
            parcel.writeInt(durationMillis);
            parcel.writeInt(violationNumThisLoop);
            parcel.writeInt(numAnimationsRunning);
            parcel.writeLong(violationUptimeMillis);
            parcel.writeLong(numInstances);
            parcel.writeString(broadcastIntentAction);
            parcel.writeStringArray(tags);
        }

        public String broadcastIntentAction;
        public final android.app.ApplicationErrorReport.CrashInfo crashInfo;
        public int durationMillis;
        public int numAnimationsRunning;
        public long numInstances;
        public final int policy;
        public String tags[];
        public int violationNumThisLoop;
        public long violationUptimeMillis;

        public ViolationInfo() {
            durationMillis = -1;
            numAnimationsRunning = 0;
            numInstances = -1L;
            crashInfo = null;
            policy = 0;
        }

        public ViolationInfo(Parcel parcel) {
            this(parcel, false);
        }

        public ViolationInfo(Parcel parcel, boolean flag) {
            durationMillis = -1;
            numAnimationsRunning = 0;
            numInstances = -1L;
            crashInfo = new android.app.ApplicationErrorReport.CrashInfo(parcel);
            int i = parcel.readInt();
            if(flag)
                policy = i & 0xfffffeff;
            else
                policy = i;
            durationMillis = parcel.readInt();
            violationNumThisLoop = parcel.readInt();
            numAnimationsRunning = parcel.readInt();
            violationUptimeMillis = parcel.readLong();
            numInstances = parcel.readLong();
            broadcastIntentAction = parcel.readString();
            tags = parcel.readStringArray();
        }

        public ViolationInfo(Throwable throwable, int i) {
            ThreadSpanState threadspanstate;
            durationMillis = -1;
            numAnimationsRunning = 0;
            numInstances = -1L;
            crashInfo = new android.app.ApplicationErrorReport.CrashInfo(throwable);
            violationUptimeMillis = SystemClock.uptimeMillis();
            policy = i;
            numAnimationsRunning = ValueAnimator.getCurrentAnimationsCount();
            Intent intent = ActivityThread.getIntentBeingBroadcast();
            if(intent != null)
                broadcastIntentAction = intent.getAction();
            threadspanstate = (ThreadSpanState)StrictMode.sThisThreadSpanState.get();
            if(throwable instanceof InstanceCountViolation)
                numInstances = ((InstanceCountViolation)throwable).mInstances;
            threadspanstate;
            JVM INSTR monitorenter ;
            int j = threadspanstate.mActiveSize;
            if(j > 20)
                j = 20;
            if(j != 0) {
                tags = new String[j];
                Span span = threadspanstate.mActiveHead;
                for(int k = 0; span != null && k < j; span = span.mNext) {
                    tags[k] = span.mName;
                    k++;
                }

            }
            return;
        }
    }

    private static class ThreadSpanState {

        public Span mActiveHead;
        public int mActiveSize;
        public Span mFreeListHead;
        public int mFreeListSize;

        private ThreadSpanState() {
        }

    }

    public static class Span {

        public void finish() {
            ThreadSpanState threadspanstate = mContainerState;
            threadspanstate;
            JVM INSTR monitorenter ;
            if(mName != null) {
                if(mPrev != null)
                    mPrev.mNext = mNext;
                if(mNext != null)
                    mNext.mPrev = mPrev;
                if(threadspanstate.mActiveHead == this)
                    threadspanstate.mActiveHead = mNext;
                threadspanstate.mActiveSize = -1 + threadspanstate.mActiveSize;
                if(StrictMode.LOG_V)
                    Log.d("StrictMode", (new StringBuilder()).append("Span finished=").append(mName).append("; size=").append(threadspanstate.mActiveSize).toString());
                mCreateMillis = -1L;
                mName = null;
                mPrev = null;
                mNext = null;
                if(threadspanstate.mFreeListSize < 5) {
                    mNext = threadspanstate.mFreeListHead;
                    threadspanstate.mFreeListHead = this;
                    threadspanstate.mFreeListSize = 1 + threadspanstate.mFreeListSize;
                }
            }
            return;
        }

        private final ThreadSpanState mContainerState;
        private long mCreateMillis;
        private String mName;
        private Span mNext;
        private Span mPrev;



/*
        static Span access$1802(Span span, Span span1) {
            span.mNext = span1;
            return span1;
        }

*/



/*
        static String access$1902(Span span, String s) {
            span.mName = s;
            return s;
        }

*/


/*
        static long access$2002(Span span, long l) {
            span.mCreateMillis = l;
            return l;
        }

*/


/*
        static Span access$2102(Span span, Span span1) {
            span.mPrev = span1;
            return span1;
        }

*/

        protected Span() {
            mContainerState = null;
        }

        Span(ThreadSpanState threadspanstate) {
            mContainerState = threadspanstate;
        }
    }

    private static class LogStackTrace extends Exception {

        private LogStackTrace() {
        }

    }

    private static class AndroidCloseGuardReporter
        implements dalvik.system.CloseGuard.Reporter {

        public void report(String s, Throwable throwable) {
            StrictMode.onVmPolicyViolation(s, throwable);
        }

        private AndroidCloseGuardReporter() {
        }

    }

    private static class AndroidBlockGuardPolicy
        implements dalvik.system.BlockGuard.Policy {

        public int getPolicyMask() {
            return mPolicyMask;
        }

        void handleViolation(ViolationInfo violationinfo) {
            if(violationinfo != null && violationinfo.crashInfo != null && violationinfo.crashInfo.stackTrace != null) goto _L2; else goto _L1
_L1:
            Log.wtf("StrictMode", "unexpected null stacktrace");
_L12:
            return;
_L2:
            ArrayList arraylist;
            if(StrictMode.LOG_V)
                Log.d("StrictMode", (new StringBuilder()).append("handleViolation; policy=").append(violationinfo.policy).toString());
            if((0x100 & violationinfo.policy) == 0)
                break MISSING_BLOCK_LABEL_184;
            arraylist = (ArrayList)StrictMode.gatheredViolations.get();
            if(arraylist != null) goto _L4; else goto _L3
_L3:
            arraylist = new ArrayList(1);
            StrictMode.gatheredViolations.set(arraylist);
_L6:
            Iterator iterator = arraylist.iterator();
            ViolationInfo violationinfo1;
            do {
                if(!iterator.hasNext())
                    break MISSING_BLOCK_LABEL_174;
                violationinfo1 = (ViolationInfo)iterator.next();
            } while(!violationinfo.crashInfo.stackTrace.equals(violationinfo1.crashInfo.stackTrace));
            break; /* Loop/switch isn't completed */
_L4:
            if(arraylist.size() < 5) goto _L6; else goto _L5
_L5:
            continue; /* Loop/switch isn't completed */
            arraylist.add(violationinfo);
            continue; /* Loop/switch isn't completed */
            int j;
            int k;
            Integer integer = Integer.valueOf(violationinfo.hashCode());
            long l = 0L;
            if(mLastViolationTime.containsKey(integer))
                l = ((Long)mLastViolationTime.get(integer)).longValue();
            long l1 = SystemClock.uptimeMillis();
            mLastViolationTime.put(integer, Long.valueOf(l1));
            long l2;
            int i;
            if(l == 0L)
                l2 = 0x7fffffffffffffffL;
            else
                l2 = l1 - l;
            if((0x10 & violationinfo.policy) != 0 && l2 > 1000L)
                if(violationinfo.durationMillis != -1)
                    Log.d("StrictMode", (new StringBuilder()).append("StrictMode policy violation; ~duration=").append(violationinfo.durationMillis).append(" ms: ").append(violationinfo.crashInfo.stackTrace).toString());
                else
                    Log.d("StrictMode", (new StringBuilder()).append("StrictMode policy violation: ").append(violationinfo.crashInfo.stackTrace).toString());
            i = 0;
            if((0x20 & violationinfo.policy) != 0 && l2 > 30000L)
                i = 0 | 0x20;
            if((0x80 & violationinfo.policy) != 0 && l == 0L)
                i = 0x80 | i;
            if(i == 0) goto _L8; else goto _L7
_L7:
            j = i | StrictMode.parseViolationFromMessage(violationinfo.crashInfo.exceptionMessage);
            k = StrictMode.getThreadPolicyMask();
            boolean flag;
            if((0xbf0 & violationinfo.policy) == 128)
                flag = true;
            else
                flag = false;
            if(flag) {
                StrictMode.dropboxViolationAsync(j, violationinfo);
                continue; /* Loop/switch isn't completed */
            }
            StrictMode.setThreadPolicyMask(0);
            ActivityManagerNative.getDefault().handleApplicationStrictModeViolation(RuntimeInit.getApplicationObject(), j, violationinfo);
_L10:
            StrictMode.setThreadPolicyMask(k);
_L8:
            if((0x40 & violationinfo.policy) != 0)
                StrictMode.executeDeathPenalty(violationinfo);
            continue; /* Loop/switch isn't completed */
            RemoteException remoteexception;
            remoteexception;
            Log.e("StrictMode", "RemoteException trying to handle StrictMode violation", remoteexception);
            if(true) goto _L10; else goto _L9
_L9:
            Exception exception;
            exception;
            StrictMode.setThreadPolicyMask(k);
            throw exception;
            if(true) goto _L12; else goto _L11
_L11:
        }

        void handleViolationWithTimingAttempt(ViolationInfo violationinfo) {
            if(Looper.myLooper() != null && (0xbf0 & violationinfo.policy) != 64) goto _L2; else goto _L1
_L1:
            violationinfo.durationMillis = -1;
            handleViolation(violationinfo);
_L4:
            return;
_L2:
            final ArrayList records = (ArrayList)StrictMode.violationsBeingTimed.get();
            if(records.size() < 10) {
                records.add(violationinfo);
                if(records.size() <= 1) {
                    final IWindowManager windowManager;
                    if((0x800 & violationinfo.policy) != 0)
                        windowManager = (IWindowManager)StrictMode.sWindowManager.get();
                    else
                        windowManager = null;
                    if(windowManager != null)
                        try {
                            windowManager.showStrictModeViolation(true);
                        }
                        catch(RemoteException remoteexception) { }
                    ((Handler)StrictMode.threadHandler.get()).postAtFrontOfQueue(new Runnable() {

                        public void run() {
                            long l = SystemClock.uptimeMillis();
                            int i;
                            if(windowManager != null)
                                try {
                                    windowManager.showStrictModeViolation(false);
                                }
                                catch(RemoteException remoteexception1) { }
                            for(i = 0; i < records.size(); i++) {
                                ViolationInfo violationinfo1 = (ViolationInfo)records.get(i);
                                violationinfo1.violationNumThisLoop = i + 1;
                                violationinfo1.durationMillis = (int)(l - violationinfo1.violationUptimeMillis);
                                handleViolation(violationinfo1);
                            }

                            records.clear();
                        }

                        final AndroidBlockGuardPolicy this$0;
                        final ArrayList val$records;
                        final IWindowManager val$windowManager;

                 {
                    this$0 = AndroidBlockGuardPolicy.this;
                    windowManager = iwindowmanager;
                    records = arraylist;
                    super();
                }
                    });
                }
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        void onCustomSlowCall(String s) {
            if((8 & mPolicyMask) != 0 && !StrictMode.tooManyViolationsThisLoop()) {
                StrictModeCustomViolation strictmodecustomviolation = new StrictModeCustomViolation(mPolicyMask, s);
                strictmodecustomviolation.fillInStackTrace();
                startHandlingViolationException(strictmodecustomviolation);
            }
        }

        public void onNetwork() {
            if((4 & mPolicyMask) != 0) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if((0x200 & mPolicyMask) != 0)
                throw new NetworkOnMainThreadException();
            if(!StrictMode.tooManyViolationsThisLoop()) {
                StrictModeNetworkViolation strictmodenetworkviolation = new StrictModeNetworkViolation(mPolicyMask);
                strictmodenetworkviolation.fillInStackTrace();
                startHandlingViolationException(strictmodenetworkviolation);
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void onReadFromDisk() {
            if((2 & mPolicyMask) != 0 && !StrictMode.tooManyViolationsThisLoop()) {
                StrictModeDiskReadViolation strictmodediskreadviolation = new StrictModeDiskReadViolation(mPolicyMask);
                strictmodediskreadviolation.fillInStackTrace();
                startHandlingViolationException(strictmodediskreadviolation);
            }
        }

        public void onWriteToDisk() {
            if((1 & mPolicyMask) != 0 && !StrictMode.tooManyViolationsThisLoop()) {
                StrictModeDiskWriteViolation strictmodediskwriteviolation = new StrictModeDiskWriteViolation(mPolicyMask);
                strictmodediskwriteviolation.fillInStackTrace();
                startHandlingViolationException(strictmodediskwriteviolation);
            }
        }

        public void setPolicyMask(int i) {
            mPolicyMask = i;
        }

        void startHandlingViolationException(dalvik.system.BlockGuard.BlockGuardPolicyException blockguardpolicyexception) {
            ViolationInfo violationinfo = new ViolationInfo(blockguardpolicyexception, blockguardpolicyexception.getPolicy());
            violationinfo.violationUptimeMillis = SystemClock.uptimeMillis();
            handleViolationWithTimingAttempt(violationinfo);
        }

        public String toString() {
            return (new StringBuilder()).append("AndroidBlockGuardPolicy; mPolicyMask=").append(mPolicyMask).toString();
        }

        private final HashMap mLastViolationTime = new HashMap();
        private int mPolicyMask;

        public AndroidBlockGuardPolicy(int i) {
            mPolicyMask = i;
        }
    }

    private static class StrictModeCustomViolation extends StrictModeViolation {

        public StrictModeCustomViolation(int i, String s) {
            super(i, 8, s);
        }
    }

    private static class StrictModeDiskWriteViolation extends StrictModeViolation {

        public StrictModeDiskWriteViolation(int i) {
            super(i, 1, null);
        }
    }

    private static class StrictModeDiskReadViolation extends StrictModeViolation {

        public StrictModeDiskReadViolation(int i) {
            super(i, 2, null);
        }
    }

    public static class StrictModeNetworkViolation extends StrictModeViolation {

        public StrictModeNetworkViolation(int i) {
            super(i, 4, null);
        }
    }

    public static class StrictModeViolation extends dalvik.system.BlockGuard.BlockGuardPolicyException {

        public StrictModeViolation(int i, int j, String s) {
            super(i, j, s);
        }
    }

    public static final class VmPolicy {
        public static final class Builder {

            private Builder enable(int i) {
                mMask = i | mMask;
                return this;
            }

            public VmPolicy build() {
                if(mMask != 0 && (0xf0 & mMask) == 0)
                    penaltyLog();
                int i = mMask;
                HashMap hashmap;
                if(mClassInstanceLimit != null)
                    hashmap = mClassInstanceLimit;
                else
                    hashmap = StrictMode.EMPTY_CLASS_LIMIT_MAP;
                return new VmPolicy(i, hashmap);
            }

            public Builder detectActivityLeaks() {
                return enable(2048);
            }

            public Builder detectAll() {
                return enable(11776);
            }

            public Builder detectLeakedClosableObjects() {
                return enable(1024);
            }

            public Builder detectLeakedRegistrationObjects() {
                return enable(8192);
            }

            public Builder detectLeakedSqlLiteObjects() {
                return enable(512);
            }

            public Builder penaltyDeath() {
                return enable(64);
            }

            public Builder penaltyDropBox() {
                return enable(128);
            }

            public Builder penaltyLog() {
                return enable(16);
            }

            public Builder setClassInstanceLimit(Class class1, int i) {
                if(class1 == null)
                    throw new NullPointerException("klass == null");
                if(!mClassInstanceLimitNeedCow) goto _L2; else goto _L1
_L1:
                if(!mClassInstanceLimit.containsKey(class1) || ((Integer)mClassInstanceLimit.get(class1)).intValue() != i) goto _L4; else goto _L3
_L3:
                return this;
_L4:
                mClassInstanceLimitNeedCow = false;
                mClassInstanceLimit = (HashMap)mClassInstanceLimit.clone();
_L5:
                mMask = 0x1000 | mMask;
                mClassInstanceLimit.put(class1, Integer.valueOf(i));
                if(true) goto _L3; else goto _L2
_L2:
                if(mClassInstanceLimit == null)
                    mClassInstanceLimit = new HashMap();
                  goto _L5
            }

            private HashMap mClassInstanceLimit;
            private boolean mClassInstanceLimitNeedCow;
            private int mMask;

            public Builder() {
                mClassInstanceLimitNeedCow = false;
                mMask = 0;
            }

            public Builder(VmPolicy vmpolicy) {
                mClassInstanceLimitNeedCow = false;
                mMask = vmpolicy.mask;
                mClassInstanceLimitNeedCow = true;
                mClassInstanceLimit = vmpolicy.classInstanceLimit;
            }
        }


        public String toString() {
            return (new StringBuilder()).append("[StrictMode.VmPolicy; mask=").append(mask).append("]").toString();
        }

        public static final VmPolicy LAX = new VmPolicy(0, StrictMode.EMPTY_CLASS_LIMIT_MAP);
        final HashMap classInstanceLimit;
        final int mask;


        private VmPolicy(int i, HashMap hashmap) {
            if(hashmap == null) {
                throw new NullPointerException("classInstanceLimit == null");
            } else {
                mask = i;
                classInstanceLimit = hashmap;
                return;
            }
        }

    }

    public static final class ThreadPolicy {
        public static final class Builder {

            private Builder disable(int i) {
                mMask = mMask & ~i;
                return this;
            }

            private Builder enable(int i) {
                mMask = i | mMask;
                return this;
            }

            public ThreadPolicy build() {
                if(mMask != 0 && (0xf0 & mMask) == 0)
                    penaltyLog();
                return new ThreadPolicy(mMask);
            }

            public Builder detectAll() {
                return enable(15);
            }

            public Builder detectCustomSlowCalls() {
                return enable(8);
            }

            public Builder detectDiskReads() {
                return enable(2);
            }

            public Builder detectDiskWrites() {
                return enable(1);
            }

            public Builder detectNetwork() {
                return enable(4);
            }

            public Builder penaltyDeath() {
                return enable(64);
            }

            public Builder penaltyDeathOnNetwork() {
                return enable(512);
            }

            public Builder penaltyDialog() {
                return enable(32);
            }

            public Builder penaltyDropBox() {
                return enable(128);
            }

            public Builder penaltyFlashScreen() {
                return enable(2048);
            }

            public Builder penaltyLog() {
                return enable(16);
            }

            public Builder permitAll() {
                return disable(15);
            }

            public Builder permitCustomSlowCalls() {
                return enable(8);
            }

            public Builder permitDiskReads() {
                return disable(2);
            }

            public Builder permitDiskWrites() {
                return disable(1);
            }

            public Builder permitNetwork() {
                return disable(4);
            }

            private int mMask;

            public Builder() {
                mMask = 0;
                mMask = 0;
            }

            public Builder(ThreadPolicy threadpolicy) {
                mMask = 0;
                mMask = threadpolicy.mask;
            }
        }


        public String toString() {
            return (new StringBuilder()).append("[StrictMode.ThreadPolicy; mask=").append(mask).append("]").toString();
        }

        public static final ThreadPolicy LAX = new ThreadPolicy(0);
        final int mask;


        private ThreadPolicy(int i) {
            mask = i;
        }

    }


    private StrictMode() {
    }

    public static ThreadPolicy allowThreadDiskReads() {
        int i = getThreadPolicyMask();
        int j = i & -3;
        if(j != i)
            setThreadPolicyMask(j);
        return new ThreadPolicy(i);
    }

    public static ThreadPolicy allowThreadDiskWrites() {
        int i = getThreadPolicyMask();
        int j = i & -4;
        if(j != i)
            setThreadPolicyMask(j);
        return new ThreadPolicy(i);
    }

    private static boolean amTheSystemServerProcess() {
        boolean flag = false;
        if(Process.myUid() == 1000) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        Throwable throwable = new Throwable();
        throwable.fillInStackTrace();
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        int i = astacktraceelement.length;
        int j = 0;
        do {
            if(j < i) {
label0:
                {
                    String s = astacktraceelement[j].getClassName();
                    if(s == null || !s.startsWith("com.android.server."))
                        break label0;
                    flag = true;
                }
            }
            if(true)
                continue;
            j++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    static void clearGatheredViolations() {
        gatheredViolations.set(null);
    }

    public static void conditionallyCheckInstanceCounts() {
        VmPolicy vmpolicy = getVmPolicy();
        if(vmpolicy.classInstanceLimit.size() != 0) {
            Runtime.getRuntime().gc();
            Iterator iterator = vmpolicy.classInstanceLimit.entrySet().iterator();
            while(iterator.hasNext())  {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                Class class1 = (Class)entry.getKey();
                int i = ((Integer)entry.getValue()).intValue();
                long l = VMDebug.countInstancesOfClass(class1, false);
                if(l > (long)i) {
                    InstanceCountViolation instancecountviolation = new InstanceCountViolation(class1, l, i);
                    onVmPolicyViolation(instancecountviolation.getMessage(), instancecountviolation);
                }
            }
        }
    }

    public static boolean conditionallyEnableDebugLogging() {
        boolean flag;
        boolean flag1;
        flag = false;
        boolean flag2;
        if(SystemProperties.getBoolean("persist.sys.strictmode.visual", false) && !amTheSystemServerProcess())
            flag1 = true;
        else
            flag1 = false;
        flag2 = SystemProperties.getBoolean("persist.sys.strictmode.disable", false);
        if(flag1 || !IS_USER_BUILD && !flag2) goto _L2; else goto _L1
_L1:
        setCloseGuardEnabled(false);
_L4:
        return flag;
_L2:
        if(IS_ENG_BUILD)
            flag1 = true;
        int i = 7;
        if(!IS_USER_BUILD)
            i |= 0x80;
        if(flag1)
            i |= 0x800;
        setThreadPolicyMask(i);
        if(!IS_USER_BUILD)
            break; /* Loop/switch isn't completed */
        setCloseGuardEnabled(false);
_L5:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
        VmPolicy.Builder builder = (new VmPolicy.Builder()).detectAll().penaltyDropBox();
        if(IS_ENG_BUILD)
            builder.penaltyLog();
        setVmPolicy(builder.build());
        setCloseGuardEnabled(vmClosableObjectLeaksEnabled());
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    public static void decrementExpectedActivityCount(Class class1) {
        if(class1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android/os/StrictMode;
        JVM INSTR monitorenter ;
        if((0x800 & sVmPolicy.mask) != 0) goto _L3; else goto _L1
_L3:
        break MISSING_BLOCK_LABEL_33;
        Exception exception;
        exception;
        throw exception;
        Integer integer;
        integer = (Integer)sExpectedActivityInstanceCount.get(class1);
        if(integer == null || integer.intValue() == 0)
            break MISSING_BLOCK_LABEL_162;
          goto _L4
_L7:
        int i;
        if(i != 0) goto _L6; else goto _L5
_L5:
        sExpectedActivityInstanceCount.remove(class1);
_L8:
        int j = i + 1;
        android/os/StrictMode;
        JVM INSTR monitorexit ;
        if(InstanceTracker.getInstanceCount(class1) > j) {
            Runtime.getRuntime().gc();
            long l = VMDebug.countInstancesOfClass(class1, false);
            if(l > (long)j) {
                InstanceCountViolation instancecountviolation = new InstanceCountViolation(class1, l, j);
                onVmPolicyViolation(instancecountviolation.getMessage(), instancecountviolation);
            }
        }
          goto _L1
_L4:
        i = -1 + integer.intValue();
          goto _L7
_L6:
        sExpectedActivityInstanceCount.put(class1, Integer.valueOf(i));
          goto _L8
        i = 0;
          goto _L7
    }

    private static void dropboxViolationAsync(int i, ViolationInfo violationinfo) {
        int j = sDropboxCallsInFlight.incrementAndGet();
        if(j > 20) {
            sDropboxCallsInFlight.decrementAndGet();
        } else {
            if(LOG_V)
                Log.d("StrictMode", (new StringBuilder()).append("Dropboxing async; in-flight=").append(j).toString());
            (new Thread(violationinfo) {

                public void run() {
                    Process.setThreadPriority(10);
                    IActivityManager iactivitymanager = ActivityManagerNative.getDefault();
                    if(iactivitymanager != null) goto _L2; else goto _L1
_L1:
                    Log.d("StrictMode", "No activity manager; failed to Dropbox violation.");
_L4:
                    int k = StrictMode.sDropboxCallsInFlight.decrementAndGet();
                    if(StrictMode.LOG_V)
                        Log.d("StrictMode", (new StringBuilder()).append("Dropbox complete; in-flight=").append(k).toString());
                    return;
_L2:
                    try {
                        iactivitymanager.handleApplicationStrictModeViolation(RuntimeInit.getApplicationObject(), violationMaskSubset, info);
                    }
                    catch(RemoteException remoteexception) {
                        Log.e("StrictMode", "RemoteException handling StrictMode violation", remoteexception);
                    }
                    if(true) goto _L4; else goto _L3
_L3:
                }

                final ViolationInfo val$info;
                final int val$violationMaskSubset;

             {
                violationMaskSubset = i;
                info = violationinfo;
                super(final_s);
            }
            }).start();
        }
    }

    public static void enableDeathOnNetwork() {
        setThreadPolicyMask(0x200 | (4 | getThreadPolicyMask()));
    }

    public static void enableDefaults() {
        setThreadPolicy((new ThreadPolicy.Builder()).detectAll().penaltyLog().build());
        setVmPolicy((new VmPolicy.Builder()).detectAll().penaltyLog().build());
    }

    public static Span enterCriticalSpan(String s) {
        if(!IS_USER_BUILD) goto _L2; else goto _L1
_L1:
        Span span1 = NO_OP_SPAN;
_L4:
        return span1;
_L2:
        if(s == null || s.isEmpty())
            throw new IllegalArgumentException("name must be non-null and non-empty");
        ThreadSpanState threadspanstate = (ThreadSpanState)sThisThreadSpanState.get();
        threadspanstate;
        JVM INSTR monitorenter ;
        if(threadspanstate.mFreeListHead == null)
            break; /* Loop/switch isn't completed */
        span1 = threadspanstate.mFreeListHead;
        threadspanstate.mFreeListHead = span1.mNext;
        threadspanstate.mFreeListSize = -1 + threadspanstate.mFreeListSize;
_L5:
        span1.mName = s;
        span1.mCreateMillis = SystemClock.uptimeMillis();
        span1.mNext = threadspanstate.mActiveHead;
        span1.mPrev = null;
        threadspanstate.mActiveHead = span1;
        threadspanstate.mActiveSize = 1 + threadspanstate.mActiveSize;
        if(span1.mNext != null)
            span1.mNext.mPrev = span1;
        if(LOG_V)
            Log.d("StrictMode", (new StringBuilder()).append("Span enter=").append(s).append("; size=").append(threadspanstate.mActiveSize).toString());
        if(true) goto _L4; else goto _L3
        Exception exception;
        exception;
        throw exception;
_L3:
        Span span = new Span(threadspanstate);
        span1 = span;
          goto _L5
    }

    private static void executeDeathPenalty(ViolationInfo violationinfo) {
        int i = parseViolationFromMessage(violationinfo.crashInfo.exceptionMessage);
        throw new StrictModeViolation(violationinfo.policy, i, null);
    }

    public static ThreadPolicy getThreadPolicy() {
        return new ThreadPolicy(getThreadPolicyMask());
    }

    public static int getThreadPolicyMask() {
        return BlockGuard.getThreadPolicy().getPolicyMask();
    }

    public static VmPolicy getVmPolicy() {
        android/os/StrictMode;
        JVM INSTR monitorenter ;
        VmPolicy vmpolicy = sVmPolicy;
        return vmpolicy;
    }

    static boolean hasGatheredViolations() {
        boolean flag;
        if(gatheredViolations.get() != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static void incrementExpectedActivityCount(Class class1) {
        if(class1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android/os/StrictMode;
        JVM INSTR monitorenter ;
        if((0x800 & sVmPolicy.mask) != 0) goto _L3; else goto _L1
_L3:
        break MISSING_BLOCK_LABEL_33;
        Exception exception;
        exception;
        throw exception;
        Integer integer = (Integer)sExpectedActivityInstanceCount.get(class1);
        if(integer != null) goto _L5; else goto _L4
_L4:
        int j = 1;
_L6:
        Integer integer1 = Integer.valueOf(j);
        sExpectedActivityInstanceCount.put(class1, integer1);
        android/os/StrictMode;
        JVM INSTR monitorexit ;
          goto _L1
_L5:
        int i = integer.intValue();
        j = i + 1;
          goto _L6
    }

    public static void noteDiskRead() {
        dalvik.system.BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if(policy instanceof AndroidBlockGuardPolicy)
            ((AndroidBlockGuardPolicy)policy).onReadFromDisk();
    }

    public static void noteDiskWrite() {
        dalvik.system.BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if(policy instanceof AndroidBlockGuardPolicy)
            ((AndroidBlockGuardPolicy)policy).onWriteToDisk();
    }

    public static void noteSlowCall(String s) {
        dalvik.system.BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
        if(policy instanceof AndroidBlockGuardPolicy)
            ((AndroidBlockGuardPolicy)policy).onCustomSlowCall(s);
    }

    private static void onBinderStrictModePolicyChange(int i) {
        setBlockGuardPolicy(i);
    }

    public static void onIntentReceiverLeaked(Throwable throwable) {
        onVmPolicyViolation(null, throwable);
    }

    public static void onServiceConnectionLeaked(Throwable throwable) {
        onVmPolicyViolation(null, throwable);
    }

    public static void onSqliteObjectLeaked(String s, Throwable throwable) {
        onVmPolicyViolation(s, throwable);
    }

    public static void onVmPolicyViolation(String s, Throwable throwable) {
        boolean flag;
        boolean flag1;
        ViolationInfo violationinfo;
        long l1;
        int i;
        boolean flag2;
        Integer integer;
        long l;
        long l2;
        if((0x80 & sVmPolicyMask) != 0)
            flag = true;
        else
            flag = false;
        if((0x40 & sVmPolicyMask) != 0)
            flag1 = true;
        else
            flag1 = false;
        if((0x10 & sVmPolicyMask) != 0)
            flag2 = true;
        else
            flag2 = false;
        violationinfo = new ViolationInfo(throwable, sVmPolicyMask);
        violationinfo.numAnimationsRunning = 0;
        violationinfo.tags = null;
        violationinfo.broadcastIntentAction = null;
        integer = Integer.valueOf(violationinfo.hashCode());
        l = SystemClock.uptimeMillis();
        l1 = 0L;
        l2 = 0x7fffffffffffffffL;
        synchronized(sLastVmViolationTime) {
            if(sLastVmViolationTime.containsKey(integer)) {
                l1 = ((Long)sLastVmViolationTime.get(integer)).longValue();
                l2 = l - l1;
            }
            if(l2 > 1000L)
                sLastVmViolationTime.put(integer, Long.valueOf(l));
        }
        if(flag2 && l2 > 1000L)
            Log.e("StrictMode", s, throwable);
        i = 0x80 | 0x3e00 & sVmPolicyMask;
        if(!flag || flag1) goto _L2; else goto _L1
_L1:
        dropboxViolationAsync(i, violationinfo);
_L8:
        return;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if(!flag || l1 != 0L) goto _L4; else goto _L3
_L3:
        int j = getThreadPolicyMask();
        setThreadPolicyMask(0);
        ActivityManagerNative.getDefault().handleApplicationStrictModeViolation(RuntimeInit.getApplicationObject(), i, violationinfo);
_L6:
        setThreadPolicyMask(j);
_L4:
        if(flag1) {
            System.err.println("StrictMode VmPolicy violation with POLICY_DEATH; shutting down.");
            Process.killProcess(Process.myPid());
            System.exit(10);
        }
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("StrictMode", "RemoteException trying to handle StrictMode violation", remoteexception);
        if(true) goto _L6; else goto _L5
_L5:
        Exception exception1;
        exception1;
        setThreadPolicyMask(j);
        throw exception1;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public static void onWebViewMethodCalledOnWrongThread(Throwable throwable) {
        onVmPolicyViolation(null, throwable);
    }

    private static int parsePolicyFromMessage(String s) {
        int i = 0;
        if(s != null && s.startsWith("policy=")) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        String s1;
        int j = s.indexOf(' ');
        if(j == -1)
            continue; /* Loop/switch isn't completed */
        s1 = s.substring(7, j);
        int k = Integer.valueOf(s1).intValue();
        i = k;
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static int parseViolationFromMessage(String s) {
        int i = 0;
        if(s != null) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        String s1;
        int j = s.indexOf("violation=");
        if(j == -1)
            continue; /* Loop/switch isn't completed */
        int k = j + "violation=".length();
        int l = s.indexOf(' ', k);
        if(l == -1)
            l = s.length();
        s1 = s.substring(k, l);
        int i1 = Integer.valueOf(s1).intValue();
        i = i1;
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    static void readAndHandleBinderCallViolations(Parcel parcel) {
        StringWriter stringwriter = new StringWriter();
        (new LogStackTrace()).printStackTrace(new PrintWriter(stringwriter));
        String s = stringwriter.toString();
        boolean flag;
        int i;
        int j;
        if((0x100 & getThreadPolicyMask()) != 0)
            flag = true;
        else
            flag = false;
        i = parcel.readInt();
        j = 0;
        while(j < i)  {
            if(LOG_V)
                Log.d("StrictMode", (new StringBuilder()).append("strict mode violation stacks read from binder call.  i=").append(j).toString());
            boolean flag1;
            ViolationInfo violationinfo;
            StringBuilder stringbuilder;
            android.app.ApplicationErrorReport.CrashInfo crashinfo;
            dalvik.system.BlockGuard.Policy policy;
            if(!flag)
                flag1 = true;
            else
                flag1 = false;
            violationinfo = new ViolationInfo(parcel, flag1);
            stringbuilder = new StringBuilder();
            crashinfo = violationinfo.crashInfo;
            crashinfo.stackTrace = stringbuilder.append(crashinfo.stackTrace).append("# via Binder call with stack:\n").append(s).toString();
            policy = BlockGuard.getThreadPolicy();
            if(policy instanceof AndroidBlockGuardPolicy)
                ((AndroidBlockGuardPolicy)policy).handleViolationWithTimingAttempt(violationinfo);
            j++;
        }
    }

    private static void setBlockGuardPolicy(int i) {
        if(i == 0) {
            BlockGuard.setThreadPolicy(BlockGuard.LAX_POLICY);
        } else {
            dalvik.system.BlockGuard.Policy policy = BlockGuard.getThreadPolicy();
            if(!(policy instanceof AndroidBlockGuardPolicy))
                BlockGuard.setThreadPolicy(new AndroidBlockGuardPolicy(i));
            else
                ((AndroidBlockGuardPolicy)policy).setPolicyMask(i);
        }
    }

    private static void setCloseGuardEnabled(boolean flag) {
        if(!(CloseGuard.getReporter() instanceof AndroidCloseGuardReporter))
            CloseGuard.setReporter(new AndroidCloseGuardReporter());
        CloseGuard.setEnabled(flag);
    }

    public static void setThreadPolicy(ThreadPolicy threadpolicy) {
        setThreadPolicyMask(threadpolicy.mask);
    }

    private static void setThreadPolicyMask(int i) {
        setBlockGuardPolicy(i);
        Binder.setThreadStrictModePolicy(i);
    }

    public static void setVmPolicy(VmPolicy vmpolicy) {
        android/os/StrictMode;
        JVM INSTR monitorenter ;
        Looper looper;
        sVmPolicy = vmpolicy;
        sVmPolicyMask = vmpolicy.mask;
        setCloseGuardEnabled(vmClosableObjectLeaksEnabled());
        looper = Looper.getMainLooper();
        if(looper == null) goto _L2; else goto _L1
_L1:
        MessageQueue messagequeue = looper.mQueue;
        if(vmpolicy.classInstanceLimit.size() != 0 && (0xd0 & sVmPolicyMask) != 0) goto _L4; else goto _L3
_L3:
        messagequeue.removeIdleHandler(sProcessIdleHandler);
        sIsIdlerRegistered = false;
_L2:
        android/os/StrictMode;
        JVM INSTR monitorexit ;
        return;
_L4:
        if(!sIsIdlerRegistered) {
            messagequeue.addIdleHandler(sProcessIdleHandler);
            sIsIdlerRegistered = true;
        }
        if(true) goto _L2; else goto _L5
_L5:
    }

    private static boolean tooManyViolationsThisLoop() {
        boolean flag;
        if(((ArrayList)violationsBeingTimed.get()).size() >= 10)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static Object trackActivity(Object obj) {
        return new InstanceTracker(obj);
    }

    public static boolean vmClosableObjectLeaksEnabled() {
        boolean flag;
        if((0x400 & sVmPolicyMask) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean vmRegistrationLeaksEnabled() {
        boolean flag;
        if((0x2000 & sVmPolicyMask) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean vmSqliteObjectLeaksEnabled() {
        boolean flag;
        if((0x200 & sVmPolicyMask) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    static void writeGatheredViolationsToParcel(Parcel parcel) {
        ArrayList arraylist = (ArrayList)gatheredViolations.get();
        if(arraylist == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(arraylist.size());
            for(int i = 0; i < arraylist.size(); i++)
                ((ViolationInfo)arraylist.get(i)).writeToParcel(parcel, 0);

            if(LOG_V)
                Log.d("StrictMode", (new StringBuilder()).append("wrote violations to response parcel; num=").append(arraylist.size()).toString());
            arraylist.clear();
        }
        gatheredViolations.set(null);
    }

    private static final int ALL_THREAD_DETECT_BITS = 15;
    private static final int ALL_VM_DETECT_BITS = 15872;
    public static final int DETECT_CUSTOM = 8;
    public static final int DETECT_DISK_READ = 2;
    public static final int DETECT_DISK_WRITE = 1;
    public static final int DETECT_NETWORK = 4;
    public static final int DETECT_VM_ACTIVITY_LEAKS = 2048;
    public static final int DETECT_VM_CLOSABLE_LEAKS = 1024;
    public static final int DETECT_VM_CURSOR_LEAKS = 512;
    private static final int DETECT_VM_INSTANCE_LEAKS = 4096;
    public static final int DETECT_VM_REGISTRATION_LEAKS = 8192;
    public static final String DISABLE_PROPERTY = "persist.sys.strictmode.disable";
    private static final HashMap EMPTY_CLASS_LIMIT_MAP = new HashMap();
    private static final boolean IS_ENG_BUILD = false;
    private static final boolean IS_USER_BUILD = false;
    private static final boolean LOG_V = false;
    private static final int MAX_OFFENSES_PER_LOOP = 10;
    private static final int MAX_SPAN_TAGS = 20;
    private static final long MIN_DIALOG_INTERVAL_MS = 30000L;
    private static final long MIN_LOG_INTERVAL_MS = 1000L;
    private static final Span NO_OP_SPAN = new Span() {

        public void finish() {
        }

    };
    public static final int PENALTY_DEATH = 64;
    public static final int PENALTY_DEATH_ON_NETWORK = 512;
    public static final int PENALTY_DIALOG = 32;
    public static final int PENALTY_DROPBOX = 128;
    public static final int PENALTY_FLASH = 2048;
    public static final int PENALTY_GATHER = 256;
    public static final int PENALTY_LOG = 16;
    private static final String TAG = "StrictMode";
    private static final int THREAD_PENALTY_MASK = 3056;
    public static final String VISUAL_PROPERTY = "persist.sys.strictmode.visual";
    private static final int VM_PENALTY_MASK = 208;
    private static final ThreadLocal gatheredViolations = new ThreadLocal() {

        protected volatile Object initialValue() {
            return initialValue();
        }

        protected ArrayList initialValue() {
            return null;
        }

    };
    private static final AtomicInteger sDropboxCallsInFlight = new AtomicInteger(0);
    private static final HashMap sExpectedActivityInstanceCount = new HashMap();
    private static boolean sIsIdlerRegistered = false;
    private static long sLastInstanceCountCheckMillis = 0L;
    private static final HashMap sLastVmViolationTime = new HashMap();
    private static final MessageQueue.IdleHandler sProcessIdleHandler = new MessageQueue.IdleHandler() {

        public boolean queueIdle() {
            long l = SystemClock.uptimeMillis();
            if(l - StrictMode.sLastInstanceCountCheckMillis > 30000L) {
                StrictMode.sLastInstanceCountCheckMillis = l;
                StrictMode.conditionallyCheckInstanceCounts();
            }
            return true;
        }

    };
    private static final ThreadLocal sThisThreadSpanState = new ThreadLocal() {

        protected ThreadSpanState initialValue() {
            return new ThreadSpanState();
        }

        protected volatile Object initialValue() {
            return initialValue();
        }

    };
    private static volatile VmPolicy sVmPolicy;
    private static volatile int sVmPolicyMask = 0;
    private static Singleton sWindowManager = new Singleton() {

        protected IWindowManager create() {
            return android.view.IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
        }

        protected volatile Object create() {
            return create();
        }

    };
    private static final ThreadLocal threadHandler = new ThreadLocal() {

        protected Handler initialValue() {
            return new Handler();
        }

        protected volatile Object initialValue() {
            return initialValue();
        }

    };
    private static final ThreadLocal violationsBeingTimed = new ThreadLocal() {

        protected volatile Object initialValue() {
            return initialValue();
        }

        protected ArrayList initialValue() {
            return new ArrayList();
        }

    };

    static  {
        LOG_V = Log.isLoggable("StrictMode", 2);
        boolean flag;
        if("user".equals(Build.TYPE) || "userdebug".equals(Build.TYPE))
            flag = true;
        else
            flag = false;
        IS_USER_BUILD = flag;
        IS_ENG_BUILD = "eng".equals(Build.TYPE);
        sVmPolicy = VmPolicy.LAX;
    }









/*
    static long access$1502(long l) {
        sLastInstanceCountCheckMillis = l;
        return l;
    }

*/







}
