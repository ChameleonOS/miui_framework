// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemProperties;
import android.util.Log;
import dalvik.system.profiler.BinaryHprofWriter;
import dalvik.system.profiler.SamplingProfiler;
import java.io.*;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import libcore.io.IoUtils;

public class SamplingProfilerIntegration {

    public SamplingProfilerIntegration() {
    }

    private static void generateSnapshotHeader(String s, PackageInfo packageinfo, PrintStream printstream) {
        printstream.println("Version: 3");
        printstream.println((new StringBuilder()).append("Process: ").append(s).toString());
        if(packageinfo != null) {
            printstream.println((new StringBuilder()).append("Package: ").append(packageinfo.packageName).toString());
            printstream.println((new StringBuilder()).append("Package-Version: ").append(packageinfo.versionCode).toString());
        }
        printstream.println((new StringBuilder()).append("Build: ").append(Build.FINGERPRINT).toString());
        printstream.println();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void start() {
        if(enabled)
            if(samplingProfiler != null) {
                Log.e("SamplingProfilerIntegration", (new StringBuilder()).append("SamplingProfilerIntegration already started at ").append(new Date(startMillis)).toString());
            } else {
                dalvik.system.profiler.SamplingProfiler.ThreadSet threadset = SamplingProfiler.newThreadGroupTheadSet(Thread.currentThread().getThreadGroup());
                samplingProfiler = new SamplingProfiler(samplingProfilerDepth, threadset);
                samplingProfiler.start(samplingProfilerMilliseconds);
                startMillis = System.currentTimeMillis();
            }
    }

    public static void writeSnapshot(final String processName, final PackageInfo packageInfo) {
        if(enabled) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(samplingProfiler == null)
            Log.e("SamplingProfilerIntegration", "SamplingProfilerIntegration is not started");
        else
        if(pending.compareAndSet(false, true))
            snapshotWriter.execute(new Runnable() {

                public void run() {
                    SamplingProfilerIntegration.writeSnapshotFile(processName, packageInfo);
                    SamplingProfilerIntegration.pending.set(false);
                    return;
                    Exception exception;
                    exception;
                    SamplingProfilerIntegration.pending.set(false);
                    throw exception;
                }

                final PackageInfo val$packageInfo;
                final String val$processName;

             {
                processName = s;
                packageInfo = packageinfo;
                super();
            }
            });
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static void writeSnapshotFile(String s, PackageInfo packageinfo) {
        if(enabled) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s1;
        String s2;
        long l;
        Object obj;
        samplingProfiler.stop();
        s1 = s.replaceAll(":", ".");
        s2 = (new StringBuilder()).append("/data/snapshots/").append(s1).append("-").append(startMillis).append(".snapshot").toString();
        l = System.currentTimeMillis();
        obj = null;
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(s2));
        PrintStream printstream = new PrintStream(bufferedoutputstream);
        generateSnapshotHeader(s1, packageinfo, printstream);
        if(printstream.checkError())
            throw new IOException();
          goto _L3
        IOException ioexception;
        ioexception;
        obj = bufferedoutputstream;
_L6:
        Log.e("SamplingProfilerIntegration", (new StringBuilder()).append("Error writing snapshot to ").append(s2).toString(), ioexception);
        IoUtils.closeQuietly(((AutoCloseable) (obj)));
          goto _L1
_L3:
        BinaryHprofWriter.write(samplingProfiler.getHprofData(), bufferedoutputstream);
        IoUtils.closeQuietly(bufferedoutputstream);
        (new File(s2)).setReadable(true, false);
        long l1 = System.currentTimeMillis() - l;
        Log.i("SamplingProfilerIntegration", (new StringBuilder()).append("Wrote snapshot ").append(s2).append(" in ").append(l1).append("ms.").toString());
        samplingProfiler.start(samplingProfilerMilliseconds);
          goto _L1
        Exception exception;
        exception;
_L5:
        IoUtils.closeQuietly(((AutoCloseable) (obj)));
        throw exception;
        exception;
        obj = bufferedoutputstream;
        if(true) goto _L5; else goto _L4
_L4:
        ioexception;
          goto _L6
    }

    public static void writeZygoteSnapshot() {
        if(enabled) {
            writeSnapshotFile("zygote", null);
            samplingProfiler.shutdown();
            samplingProfiler = null;
            startMillis = 0L;
        }
    }

    public static final String SNAPSHOT_DIR = "/data/snapshots";
    private static final String TAG = "SamplingProfilerIntegration";
    private static final boolean enabled;
    private static final AtomicBoolean pending = new AtomicBoolean(false);
    private static SamplingProfiler samplingProfiler;
    private static final int samplingProfilerDepth = SystemProperties.getInt("persist.sys.profiler_depth", 4);
    private static final int samplingProfilerMilliseconds;
    private static final Executor snapshotWriter;
    private static long startMillis;

    static  {
        samplingProfilerMilliseconds = SystemProperties.getInt("persist.sys.profiler_ms", 0);
        if(samplingProfilerMilliseconds > 0) {
            File file = new File("/data/snapshots");
            file.mkdirs();
            file.setWritable(true, false);
            file.setExecutable(true, false);
            if(file.isDirectory()) {
                snapshotWriter = Executors.newSingleThreadExecutor(new ThreadFactory() {

                    public Thread newThread(Runnable runnable) {
                        return new Thread(runnable, "SamplingProfilerIntegration");
                    }

                });
                enabled = true;
                Log.i("SamplingProfilerIntegration", (new StringBuilder()).append("Profiling enabled. Sampling interval ms: ").append(samplingProfilerMilliseconds).toString());
            } else {
                snapshotWriter = null;
                enabled = true;
                Log.w("SamplingProfilerIntegration", "Profiling setup failed. Could not create /data/snapshots");
            }
        } else {
            snapshotWriter = null;
            enabled = false;
            Log.i("SamplingProfilerIntegration", "Profiling disabled.");
        }
    }


}
