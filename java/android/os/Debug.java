// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.Log;
import com.android.internal.util.TypedProperties;
import dalvik.bytecode.OpcodeInfo;
import dalvik.system.VMDebug;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import org.apache.harmony.dalvik.ddmc.*;

// Referenced classes of package android.os:
//            Environment, RemoteException, ServiceManager, IBinder, 
//            Parcelable, Parcel

public final class Debug {
    public static interface DebugProperty
        extends Annotation {
    }

    public static class InstructionCount {

        public boolean collect() {
            VMDebug.stopInstructionCounting();
            VMDebug.getInstructionCount(mCounts);
            boolean flag = true;
_L2:
            return flag;
            UnsupportedOperationException unsupportedoperationexception;
            unsupportedoperationexception;
            flag = false;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public int globalMethodInvocations() {
            int i = 0;
            for(int j = 0; j < NUM_INSTR; j++)
                if(OpcodeInfo.isInvoke(j))
                    i += mCounts[j];

            return i;
        }

        public int globalTotal() {
            int i = 0;
            for(int j = 0; j < NUM_INSTR; j++)
                i += mCounts[j];

            return i;
        }

        public boolean resetAndStart() {
            VMDebug.startInstructionCounting();
            VMDebug.resetInstructionCount();
            boolean flag = true;
_L2:
            return flag;
            UnsupportedOperationException unsupportedoperationexception;
            unsupportedoperationexception;
            flag = false;
            if(true) goto _L2; else goto _L1
_L1:
        }

        private static final int NUM_INSTR;
        private int mCounts[];

        static  {
            NUM_INSTR = 1 + OpcodeInfo.MAXIMUM_PACKED_VALUE;
        }

        public InstructionCount() {
            mCounts = new int[NUM_INSTR];
        }
    }

    public static class MemoryInfo
        implements Parcelable {

        public static String getOtherLabel(int i) {
            i;
            JVM INSTR tableswitch 0 8: default 52
        //                       0 57
        //                       1 63
        //                       2 69
        //                       3 75
        //                       4 81
        //                       5 87
        //                       6 93
        //                       7 99
        //                       8 105;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
            String s = "????";
_L12:
            return s;
_L2:
            s = "Cursor";
            continue; /* Loop/switch isn't completed */
_L3:
            s = "Ashmem";
            continue; /* Loop/switch isn't completed */
_L4:
            s = "Other dev";
            continue; /* Loop/switch isn't completed */
_L5:
            s = ".so mmap";
            continue; /* Loop/switch isn't completed */
_L6:
            s = ".jar mmap";
            continue; /* Loop/switch isn't completed */
_L7:
            s = ".apk mmap";
            continue; /* Loop/switch isn't completed */
_L8:
            s = ".ttf mmap";
            continue; /* Loop/switch isn't completed */
_L9:
            s = ".dex mmap";
            continue; /* Loop/switch isn't completed */
_L10:
            s = "Other mmap";
            if(true) goto _L12; else goto _L11
_L11:
        }

        public int describeContents() {
            return 0;
        }

        public int getOtherPrivateDirty(int i) {
            return otherStats[1 + i * 3];
        }

        public int getOtherPss(int i) {
            return otherStats[i * 3];
        }

        public int getOtherSharedDirty(int i) {
            return otherStats[2 + i * 3];
        }

        public int getTotalPrivateDirty() {
            return dalvikPrivateDirty + nativePrivateDirty + otherPrivateDirty;
        }

        public int getTotalPss() {
            return dalvikPss + nativePss + otherPss;
        }

        public int getTotalSharedDirty() {
            return dalvikSharedDirty + nativeSharedDirty + otherSharedDirty;
        }

        public void readFromParcel(Parcel parcel) {
            dalvikPss = parcel.readInt();
            dalvikPrivateDirty = parcel.readInt();
            dalvikSharedDirty = parcel.readInt();
            nativePss = parcel.readInt();
            nativePrivateDirty = parcel.readInt();
            nativeSharedDirty = parcel.readInt();
            otherPss = parcel.readInt();
            otherPrivateDirty = parcel.readInt();
            otherSharedDirty = parcel.readInt();
            otherStats = parcel.createIntArray();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(dalvikPss);
            parcel.writeInt(dalvikPrivateDirty);
            parcel.writeInt(dalvikSharedDirty);
            parcel.writeInt(nativePss);
            parcel.writeInt(nativePrivateDirty);
            parcel.writeInt(nativeSharedDirty);
            parcel.writeInt(otherPss);
            parcel.writeInt(otherPrivateDirty);
            parcel.writeInt(otherSharedDirty);
            parcel.writeIntArray(otherStats);
        }

        public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

            public MemoryInfo createFromParcel(Parcel parcel) {
                return new MemoryInfo(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public MemoryInfo[] newArray(int i) {
                return new MemoryInfo[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public static final int NUM_OTHER_STATS = 9;
        public int dalvikPrivateDirty;
        public int dalvikPss;
        public int dalvikSharedDirty;
        public int nativePrivateDirty;
        public int nativePss;
        public int nativeSharedDirty;
        public int otherPrivateDirty;
        public int otherPss;
        public int otherSharedDirty;
        private int otherStats[];


        public MemoryInfo() {
            otherStats = new int[27];
        }

        private MemoryInfo(Parcel parcel) {
            otherStats = new int[27];
            readFromParcel(parcel);
        }

    }


    private Debug() {
    }

    public static final boolean cacheRegisterMap(String s) {
        return VMDebug.cacheRegisterMap(s);
    }

    public static void changeDebugPort(int i) {
    }

    public static long countInstancesOfClass(Class class1) {
        return VMDebug.countInstancesOfClass(class1, true);
    }

    public static void dumpHprofData(String s) throws IOException {
        VMDebug.dumpHprofData(s);
    }

    public static void dumpHprofData(String s, FileDescriptor filedescriptor) throws IOException {
        VMDebug.dumpHprofData(s, filedescriptor);
    }

    public static void dumpHprofDataDdms() {
        VMDebug.dumpHprofDataDdms();
    }

    public static native void dumpNativeBacktraceToFile(int i, String s);

    public static native void dumpNativeHeap(FileDescriptor filedescriptor);

    public static final void dumpReferenceTables() {
        VMDebug.dumpReferenceTables();
    }

    public static boolean dumpService(String s, FileDescriptor filedescriptor, String as[]) {
        boolean flag;
        IBinder ibinder;
        flag = false;
        ibinder = ServiceManager.getService(s);
        if(ibinder != null) goto _L2; else goto _L1
_L1:
        Log.e("Debug", (new StringBuilder()).append("Can't find service to dump: ").append(s).toString());
_L4:
        return flag;
_L2:
        ibinder.dump(filedescriptor, as);
        flag = true;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("Debug", (new StringBuilder()).append("Can't dump service: ").append(s).toString(), remoteexception);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static void enableEmulatorTraceOutput() {
        VMDebug.startEmulatorTracing();
    }

    private static boolean fieldTypeMatches(Field field, Class class1) {
        boolean flag;
        Class class2;
        flag = false;
        class2 = field.getType();
        if(class2 != class1) goto _L2; else goto _L1
_L1:
        flag = true;
_L4:
        return flag;
_L2:
        Field field1;
        Class class3;
        try {
            field1 = class1.getField("TYPE");
        }
        catch(NoSuchFieldException nosuchfieldexception) {
            continue; /* Loop/switch isn't completed */
        }
        class3 = (Class)field1.get(null);
        boolean flag1;
        if(class2 == class3)
            flag1 = true;
        else
            flag1 = false;
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final native int getBinderDeathObjectCount();

    public static final native int getBinderLocalObjectCount();

    public static final native int getBinderProxyObjectCount();

    public static native int getBinderReceivedTransactions();

    public static native int getBinderSentTransactions();

    public static String getCaller() {
        return getCaller(Thread.currentThread().getStackTrace(), 0);
    }

    private static String getCaller(StackTraceElement astacktraceelement[], int i) {
        String s;
        if(i + 4 >= astacktraceelement.length) {
            s = "<bottom of call stack>";
        } else {
            StackTraceElement stacktraceelement = astacktraceelement[i + 4];
            s = (new StringBuilder()).append(stacktraceelement.getClassName()).append(".").append(stacktraceelement.getMethodName()).append(":").append(stacktraceelement.getLineNumber()).toString();
        }
        return s;
    }

    public static String getCallers(int i) {
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        StringBuffer stringbuffer = new StringBuffer();
        for(int j = 0; j < i; j++)
            stringbuffer.append(getCaller(astacktraceelement, j)).append(" ");

        return stringbuffer.toString();
    }

    public static int getGlobalAllocCount() {
        return VMDebug.getAllocCount(1);
    }

    public static int getGlobalAllocSize() {
        return VMDebug.getAllocCount(2);
    }

    public static int getGlobalClassInitCount() {
        return VMDebug.getAllocCount(32);
    }

    public static int getGlobalClassInitTime() {
        return VMDebug.getAllocCount(64);
    }

    public static int getGlobalExternalAllocCount() {
        return 0;
    }

    public static int getGlobalExternalAllocSize() {
        return 0;
    }

    public static int getGlobalExternalFreedCount() {
        return 0;
    }

    public static int getGlobalExternalFreedSize() {
        return 0;
    }

    public static int getGlobalFreedCount() {
        return VMDebug.getAllocCount(4);
    }

    public static int getGlobalFreedSize() {
        return VMDebug.getAllocCount(8);
    }

    public static int getGlobalGcInvocationCount() {
        return VMDebug.getAllocCount(16);
    }

    public static int getLoadedClassCount() {
        return VMDebug.getLoadedClassCount();
    }

    public static native void getMemoryInfo(int i, MemoryInfo memoryinfo);

    public static native void getMemoryInfo(MemoryInfo memoryinfo);

    public static native long getNativeHeapAllocatedSize();

    public static native long getNativeHeapFreeSize();

    public static native long getNativeHeapSize();

    public static native long getPss();

    public static native long getPss(int i);

    public static int getThreadAllocCount() {
        return VMDebug.getAllocCount(0x10000);
    }

    public static int getThreadAllocSize() {
        return VMDebug.getAllocCount(0x20000);
    }

    public static int getThreadExternalAllocCount() {
        return 0;
    }

    public static int getThreadExternalAllocSize() {
        return 0;
    }

    public static int getThreadGcInvocationCount() {
        return VMDebug.getAllocCount(0x100000);
    }

    public static String[] getVmFeatureList() {
        return VMDebug.getVmFeatureList();
    }

    public static boolean isDebuggerConnected() {
        return VMDebug.isDebuggerConnected();
    }

    public static boolean isMethodTracingActive() {
        return VMDebug.isMethodTracingActive();
    }

    private static void modifyFieldIfSet(Field field, TypedProperties typedproperties, String s) {
        int i;
        if(field.getType() != java/lang/String)
            break MISSING_BLOCK_LABEL_178;
        i = typedproperties.getStringInfo(s);
        i;
        JVM INSTR tableswitch -2 1: default 48
    //                   -2 126
    //                   -1 93
    //                   0 87
    //                   1 178;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_178;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalStateException((new StringBuilder()).append("Unexpected getStringInfo(").append(s).append(") return value ").append(i).toString());
_L4:
        field.set(null, null);
_L6:
        return;
        IllegalAccessException illegalaccessexception1;
        illegalaccessexception1;
        throw new IllegalArgumentException((new StringBuilder()).append("Cannot set field for ").append(s).toString(), illegalaccessexception1);
_L2:
        throw new IllegalArgumentException((new StringBuilder()).append("Type of ").append(s).append(" ").append(" does not match field type (").append(field.getType()).append(")").toString());
        Object obj = typedproperties.get(s);
        if(obj != null) {
            if(!fieldTypeMatches(field, obj.getClass()))
                throw new IllegalArgumentException((new StringBuilder()).append("Type of ").append(s).append(" (").append(obj.getClass()).append(") ").append(" does not match field type (").append(field.getType()).append(")").toString());
            try {
                field.set(null, obj);
            }
            catch(IllegalAccessException illegalaccessexception) {
                throw new IllegalArgumentException((new StringBuilder()).append("Cannot set field for ").append(s).toString(), illegalaccessexception);
            }
        }
          goto _L6
    }

    public static void printLoadedClasses(int i) {
        VMDebug.printLoadedClasses(i);
    }

    public static void resetAllCounts() {
        VMDebug.resetAllocCount(-1);
    }

    public static void resetGlobalAllocCount() {
        VMDebug.resetAllocCount(1);
    }

    public static void resetGlobalAllocSize() {
        VMDebug.resetAllocCount(2);
    }

    public static void resetGlobalClassInitCount() {
        VMDebug.resetAllocCount(32);
    }

    public static void resetGlobalClassInitTime() {
        VMDebug.resetAllocCount(64);
    }

    public static void resetGlobalExternalAllocCount() {
    }

    public static void resetGlobalExternalAllocSize() {
    }

    public static void resetGlobalExternalFreedCount() {
    }

    public static void resetGlobalExternalFreedSize() {
    }

    public static void resetGlobalFreedCount() {
        VMDebug.resetAllocCount(4);
    }

    public static void resetGlobalFreedSize() {
        VMDebug.resetAllocCount(8);
    }

    public static void resetGlobalGcInvocationCount() {
        VMDebug.resetAllocCount(16);
    }

    public static void resetThreadAllocCount() {
        VMDebug.resetAllocCount(0x10000);
    }

    public static void resetThreadAllocSize() {
        VMDebug.resetAllocCount(0x20000);
    }

    public static void resetThreadExternalAllocCount() {
    }

    public static void resetThreadExternalAllocSize() {
    }

    public static void resetThreadGcInvocationCount() {
        VMDebug.resetAllocCount(0x100000);
    }

    public static int setAllocationLimit(int i) {
        return -1;
    }

    public static void setFieldsOn(Class class1) {
        setFieldsOn(class1, false);
    }

    public static void setFieldsOn(Class class1, boolean flag) {
        StringBuilder stringbuilder = (new StringBuilder()).append("setFieldsOn(");
        String s;
        if(class1 == null)
            s = "null";
        else
            s = class1.getName();
        Log.wtf("Debug", stringbuilder.append(s).append(") called in non-DEBUG build").toString());
    }

    public static int setGlobalAllocationLimit(int i) {
        return -1;
    }

    public static void startAllocCounting() {
        VMDebug.startAllocCounting();
    }

    public static void startMethodTracing() {
        VMDebug.startMethodTracing(DEFAULT_TRACE_FILE_PATH, 0, 0);
    }

    public static void startMethodTracing(String s) {
        startMethodTracing(s, 0, 0);
    }

    public static void startMethodTracing(String s, int i) {
        startMethodTracing(s, i, 0);
    }

    public static void startMethodTracing(String s, int i, int j) {
        String s1 = s;
        if(s1.charAt(0) != '/')
            s1 = (new StringBuilder()).append(DEFAULT_TRACE_PATH_PREFIX).append(s1).toString();
        if(!s1.endsWith(".trace"))
            s1 = (new StringBuilder()).append(s1).append(".trace").toString();
        VMDebug.startMethodTracing(s1, i, j);
    }

    public static void startMethodTracing(String s, FileDescriptor filedescriptor, int i, int j) {
        VMDebug.startMethodTracing(s, filedescriptor, i, j);
    }

    public static void startMethodTracingDdms(int i, int j) {
        VMDebug.startMethodTracingDdms(i, j);
    }

    public static void startNativeTracing() {
        PrintWriter printwriter = null;
        PrintWriter printwriter1 = new PrintWriter(new OutputStreamWriter(new FileOutputStream("/sys/qemu_trace/state")));
        printwriter1.println("1");
        if(printwriter1 != null)
            printwriter1.close();
_L2:
        VMDebug.startEmulatorTracing();
        return;
        Exception exception2;
        exception2;
_L5:
        if(printwriter != null)
            printwriter.close();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception1;
        exception1;
_L4:
        if(printwriter != null)
            printwriter.close();
        throw exception1;
        exception1;
        printwriter = printwriter1;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        printwriter = printwriter1;
          goto _L5
    }

    public static void stopAllocCounting() {
        VMDebug.stopAllocCounting();
    }

    public static void stopMethodTracing() {
        VMDebug.stopMethodTracing();
    }

    public static void stopNativeTracing() {
        PrintWriter printwriter;
        VMDebug.stopEmulatorTracing();
        printwriter = null;
        PrintWriter printwriter1 = new PrintWriter(new OutputStreamWriter(new FileOutputStream("/sys/qemu_trace/state")));
        printwriter1.println("0");
        if(printwriter1 != null)
            printwriter1.close();
_L2:
        return;
        Exception exception2;
        exception2;
_L5:
        if(printwriter != null)
            printwriter.close();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception1;
        exception1;
_L4:
        if(printwriter != null)
            printwriter.close();
        throw exception1;
        exception1;
        printwriter = printwriter1;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        printwriter = printwriter1;
          goto _L5
    }

    public static long threadCpuTimeNanos() {
        return VMDebug.threadCpuTimeNanos();
    }

    public static void waitForDebugger() {
_L2:
        return;
        if(!VMDebug.isDebuggingEnabled() || isDebuggerConnected()) goto _L2; else goto _L1
_L1:
        System.out.println("Sending WAIT chunk");
        byte abyte0[] = new byte[1];
        abyte0[0] = 0;
        DdmServer.sendChunk(new Chunk(ChunkHandler.type("WAIT"), abyte0, 0, 1));
        mWaiting = true;
        while(!isDebuggerConnected()) 
            try {
                Thread.sleep(200L);
            }
            catch(InterruptedException interruptedexception1) { }
        mWaiting = false;
        System.out.println("Debugger has connected");
        long l;
        do {
            l = VMDebug.lastDebuggerActivity();
            if(l < 0L) {
                System.out.println("debugger detached?");
                continue; /* Loop/switch isn't completed */
            }
            if(l >= 1300L)
                break;
            System.out.println("waiting for debugger to settle...");
            try {
                Thread.sleep(200L);
            }
            catch(InterruptedException interruptedexception) { }
        } while(true);
        System.out.println((new StringBuilder()).append("debugger has settled (").append(l).append(")").toString());
        if(true) goto _L2; else goto _L3
_L3:
    }

    public static boolean waitingForDebugger() {
        return mWaiting;
    }

    private static final String DEFAULT_TRACE_BODY = "dmtrace";
    private static final String DEFAULT_TRACE_EXTENSION = ".trace";
    private static final String DEFAULT_TRACE_FILE_PATH = (new StringBuilder()).append(DEFAULT_TRACE_PATH_PREFIX).append("dmtrace").append(".trace").toString();
    private static final String DEFAULT_TRACE_PATH_PREFIX = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").toString();
    private static final int MIN_DEBUGGER_IDLE = 1300;
    public static final int SHOW_CLASSLOADER = 2;
    public static final int SHOW_FULL_DETAIL = 1;
    public static final int SHOW_INITIALIZED = 4;
    private static final int SPIN_DELAY = 200;
    private static final String SYSFS_QEMU_TRACE_STATE = "/sys/qemu_trace/state";
    private static final String TAG = "Debug";
    public static final int TRACE_COUNT_ALLOCS = 1;
    private static final TypedProperties debugProperties = null;
    private static volatile boolean mWaiting = false;

}
