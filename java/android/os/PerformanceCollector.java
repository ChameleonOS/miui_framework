// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.util.*;

// Referenced classes of package android.os:
//            Process, SystemClock, Debug, Bundle

public class PerformanceCollector {
    public static interface PerformanceResultsWriter {

        public abstract void writeBeginSnapshot(String s);

        public abstract void writeEndSnapshot(Bundle bundle);

        public abstract void writeMeasurement(String s, float f);

        public abstract void writeMeasurement(String s, long l);

        public abstract void writeMeasurement(String s, String s1);

        public abstract void writeStartTiming(String s);

        public abstract void writeStopTiming(Bundle bundle);
    }


    public PerformanceCollector() {
    }

    public PerformanceCollector(PerformanceResultsWriter performanceresultswriter) {
        setPerformanceResultsWriter(performanceresultswriter);
    }

    private void endPerformanceSnapshot() {
        mSnapshotCpuTime = Process.getElapsedCpuTime() - mSnapshotCpuTime;
        mSnapshotExecTime = SystemClock.uptimeMillis() - mSnapshotExecTime;
        stopAllocCounting();
        long l = Debug.getNativeHeapSize() / 1024L;
        long l1 = Debug.getNativeHeapAllocatedSize() / 1024L;
        long l2 = Debug.getNativeHeapFreeSize() / 1024L;
        Debug.MemoryInfo memoryinfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryinfo);
        Runtime runtime = Runtime.getRuntime();
        long l3 = runtime.totalMemory() / 1024L;
        long l4 = runtime.freeMemory() / 1024L;
        long l5 = l3 - l4;
        Bundle bundle = getBinderCounts();
        String s1;
        for(Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); mPerfSnapshot.putLong(s1, bundle.getLong(s1)))
            s1 = (String)iterator.next();

        Bundle bundle1 = getAllocCounts();
        String s;
        for(Iterator iterator1 = bundle1.keySet().iterator(); iterator1.hasNext(); mPerfSnapshot.putLong(s, bundle1.getLong(s)))
            s = (String)iterator1.next();

        mPerfSnapshot.putLong("execution_time", mSnapshotExecTime);
        mPerfSnapshot.putLong("cpu_time", mSnapshotCpuTime);
        mPerfSnapshot.putLong("native_size", l);
        mPerfSnapshot.putLong("native_allocated", l1);
        mPerfSnapshot.putLong("native_free", l2);
        mPerfSnapshot.putLong("native_pss", memoryinfo.nativePss);
        mPerfSnapshot.putLong("native_private_dirty", memoryinfo.nativePrivateDirty);
        mPerfSnapshot.putLong("native_shared_dirty", memoryinfo.nativeSharedDirty);
        mPerfSnapshot.putLong("java_size", l3);
        mPerfSnapshot.putLong("java_allocated", l5);
        mPerfSnapshot.putLong("java_free", l4);
        mPerfSnapshot.putLong("java_pss", memoryinfo.dalvikPss);
        mPerfSnapshot.putLong("java_private_dirty", memoryinfo.dalvikPrivateDirty);
        mPerfSnapshot.putLong("java_shared_dirty", memoryinfo.dalvikSharedDirty);
        mPerfSnapshot.putLong("other_pss", memoryinfo.otherPss);
        mPerfSnapshot.putLong("other_private_dirty", memoryinfo.otherPrivateDirty);
        mPerfSnapshot.putLong("other_shared_dirty", memoryinfo.otherSharedDirty);
    }

    private static Bundle getAllocCounts() {
        Bundle bundle = new Bundle();
        bundle.putLong("global_alloc_count", Debug.getGlobalAllocCount());
        bundle.putLong("global_alloc_size", Debug.getGlobalAllocSize());
        bundle.putLong("global_freed_count", Debug.getGlobalFreedCount());
        bundle.putLong("global_freed_size", Debug.getGlobalFreedSize());
        bundle.putLong("gc_invocation_count", Debug.getGlobalGcInvocationCount());
        return bundle;
    }

    private static Bundle getBinderCounts() {
        Bundle bundle = new Bundle();
        bundle.putLong("sent_transactions", Debug.getBinderSentTransactions());
        bundle.putLong("received_transactions", Debug.getBinderReceivedTransactions());
        return bundle;
    }

    private static void startAllocCounting() {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        Debug.resetAllCounts();
        Debug.startAllocCounting();
    }

    private void startPerformanceSnapshot() {
        mPerfSnapshot = new Bundle();
        Bundle bundle = getBinderCounts();
        String s;
        for(Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); mPerfSnapshot.putLong((new StringBuilder()).append("pre_").append(s).toString(), bundle.getLong(s)))
            s = (String)iterator.next();

        startAllocCounting();
        mSnapshotExecTime = SystemClock.uptimeMillis();
        mSnapshotCpuTime = Process.getElapsedCpuTime();
    }

    private static void stopAllocCounting() {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        Debug.stopAllocCounting();
    }

    public Bundle addIteration(String s) {
        mCpuTime = Process.getElapsedCpuTime() - mCpuTime;
        mExecTime = SystemClock.uptimeMillis() - mExecTime;
        Bundle bundle = new Bundle();
        bundle.putString("label", s);
        bundle.putLong("execution_time", mExecTime);
        bundle.putLong("cpu_time", mCpuTime);
        mPerfMeasurement.getParcelableArrayList("iterations").add(bundle);
        mExecTime = SystemClock.uptimeMillis();
        mCpuTime = Process.getElapsedCpuTime();
        return bundle;
    }

    public void addMeasurement(String s, float f) {
        if(mPerfWriter != null)
            mPerfWriter.writeMeasurement(s, f);
    }

    public void addMeasurement(String s, long l) {
        if(mPerfWriter != null)
            mPerfWriter.writeMeasurement(s, l);
    }

    public void addMeasurement(String s, String s1) {
        if(mPerfWriter != null)
            mPerfWriter.writeMeasurement(s, s1);
    }

    public void beginSnapshot(String s) {
        if(mPerfWriter != null)
            mPerfWriter.writeBeginSnapshot(s);
        startPerformanceSnapshot();
    }

    public Bundle endSnapshot() {
        endPerformanceSnapshot();
        if(mPerfWriter != null)
            mPerfWriter.writeEndSnapshot(mPerfSnapshot);
        return mPerfSnapshot;
    }

    public void setPerformanceResultsWriter(PerformanceResultsWriter performanceresultswriter) {
        mPerfWriter = performanceresultswriter;
    }

    public void startTiming(String s) {
        if(mPerfWriter != null)
            mPerfWriter.writeStartTiming(s);
        mPerfMeasurement = new Bundle();
        mPerfMeasurement.putParcelableArrayList("iterations", new ArrayList());
        mExecTime = SystemClock.uptimeMillis();
        mCpuTime = Process.getElapsedCpuTime();
    }

    public Bundle stopTiming(String s) {
        addIteration(s);
        if(mPerfWriter != null)
            mPerfWriter.writeStopTiming(mPerfMeasurement);
        return mPerfMeasurement;
    }

    public static final String METRIC_KEY_CPU_TIME = "cpu_time";
    public static final String METRIC_KEY_EXECUTION_TIME = "execution_time";
    public static final String METRIC_KEY_GC_INVOCATION_COUNT = "gc_invocation_count";
    public static final String METRIC_KEY_GLOBAL_ALLOC_COUNT = "global_alloc_count";
    public static final String METRIC_KEY_GLOBAL_ALLOC_SIZE = "global_alloc_size";
    public static final String METRIC_KEY_GLOBAL_FREED_COUNT = "global_freed_count";
    public static final String METRIC_KEY_GLOBAL_FREED_SIZE = "global_freed_size";
    public static final String METRIC_KEY_ITERATIONS = "iterations";
    public static final String METRIC_KEY_JAVA_ALLOCATED = "java_allocated";
    public static final String METRIC_KEY_JAVA_FREE = "java_free";
    public static final String METRIC_KEY_JAVA_PRIVATE_DIRTY = "java_private_dirty";
    public static final String METRIC_KEY_JAVA_PSS = "java_pss";
    public static final String METRIC_KEY_JAVA_SHARED_DIRTY = "java_shared_dirty";
    public static final String METRIC_KEY_JAVA_SIZE = "java_size";
    public static final String METRIC_KEY_LABEL = "label";
    public static final String METRIC_KEY_NATIVE_ALLOCATED = "native_allocated";
    public static final String METRIC_KEY_NATIVE_FREE = "native_free";
    public static final String METRIC_KEY_NATIVE_PRIVATE_DIRTY = "native_private_dirty";
    public static final String METRIC_KEY_NATIVE_PSS = "native_pss";
    public static final String METRIC_KEY_NATIVE_SHARED_DIRTY = "native_shared_dirty";
    public static final String METRIC_KEY_NATIVE_SIZE = "native_size";
    public static final String METRIC_KEY_OTHER_PRIVATE_DIRTY = "other_private_dirty";
    public static final String METRIC_KEY_OTHER_PSS = "other_pss";
    public static final String METRIC_KEY_OTHER_SHARED_DIRTY = "other_shared_dirty";
    public static final String METRIC_KEY_PRE_RECEIVED_TRANSACTIONS = "pre_received_transactions";
    public static final String METRIC_KEY_PRE_SENT_TRANSACTIONS = "pre_sent_transactions";
    public static final String METRIC_KEY_RECEIVED_TRANSACTIONS = "received_transactions";
    public static final String METRIC_KEY_SENT_TRANSACTIONS = "sent_transactions";
    private long mCpuTime;
    private long mExecTime;
    private Bundle mPerfMeasurement;
    private Bundle mPerfSnapshot;
    private PerformanceResultsWriter mPerfWriter;
    private long mSnapshotCpuTime;
    private long mSnapshotExecTime;
}
