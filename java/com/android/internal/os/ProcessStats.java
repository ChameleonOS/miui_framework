// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.os.*;
import android.util.Slog;
import java.io.*;
import java.util.*;

public class ProcessStats {
    public static class Stats {

        public boolean active;
        public boolean added;
        public String baseName;
        public long base_majfaults;
        public long base_minfaults;
        public long base_stime;
        public long base_uptime;
        public long base_utime;
        final String cmdlineFile;
        public boolean interesting;
        public String name;
        public int nameWidth;
        public final int pid;
        public int rel_majfaults;
        public int rel_minfaults;
        public int rel_stime;
        public long rel_uptime;
        public int rel_utime;
        public boolean removed;
        final String statFile;
        final ArrayList threadStats;
        final String threadsDir;
        public boolean working;
        final ArrayList workingThreads;

        Stats(int i, int j, boolean flag) {
            pid = i;
            if(j < 0) {
                File file = new File("/proc", Integer.toString(pid));
                statFile = (new File(file, "stat")).toString();
                cmdlineFile = (new File(file, "cmdline")).toString();
                threadsDir = (new File(file, "task")).toString();
                if(flag) {
                    threadStats = new ArrayList();
                    workingThreads = new ArrayList();
                } else {
                    threadStats = null;
                    workingThreads = null;
                }
            } else {
                statFile = (new File(new File(new File(new File("/proc", Integer.toString(j)), "task"), Integer.toString(pid)), "stat")).toString();
                cmdlineFile = null;
                threadsDir = null;
                threadStats = null;
                workingThreads = null;
            }
        }
    }


    public ProcessStats(boolean flag) {
        mLoad1 = 0.0F;
        mLoad5 = 0.0F;
        mLoad15 = 0.0F;
        mFirst = true;
        mBuffer = new byte[256];
        mIncludeThreads = flag;
    }

    private int[] collectStats(String s, int i, boolean flag, int ai[], ArrayList arraylist) {
        int ai1[];
        int k;
        int l;
        int i1;
        int j1;
        ai1 = Process.getPids(s, ai);
        int j;
        Stats stats;
        if(ai1 == null)
            j = 0;
        else
            j = ai1.length;
        k = arraylist.size();
        l = 0;
        i1 = 0;
_L2:
        Stats stats1;
label0:
        {
            if(i1 < j) {
                j1 = ai1[i1];
                if(j1 >= 0)
                    break label0;
            }
            for(; l < k; k--) {
                stats = (Stats)arraylist.get(l);
                stats.rel_utime = 0;
                stats.rel_stime = 0;
                stats.rel_minfaults = 0;
                stats.rel_majfaults = 0;
                stats.removed = true;
                stats.working = true;
                arraylist.remove(l);
            }

            break MISSING_BLOCK_LABEL_899;
        }
        if(l < k)
            stats1 = (Stats)arraylist.get(l);
        else
            stats1 = null;
        if(stats1 == null || stats1.pid != j1)
            break; /* Loop/switch isn't completed */
        stats1.added = false;
        stats1.working = false;
        l++;
        if(stats1.interesting) {
            long l1 = SystemClock.uptimeMillis();
            long al1[] = mProcessStatsData;
            if(Process.readProcFile(stats1.statFile.toString(), PROCESS_STATS_FORMAT, null, al1, null)) {
                long l2 = al1[0];
                long l3 = al1[1];
                long l4 = al1[2];
                long l5 = al1[3];
                if(l4 == stats1.base_utime && l5 == stats1.base_stime) {
                    stats1.rel_utime = 0;
                    stats1.rel_stime = 0;
                    stats1.rel_minfaults = 0;
                    stats1.rel_majfaults = 0;
                    if(stats1.active)
                        stats1.active = false;
                } else {
                    if(!stats1.active)
                        stats1.active = true;
                    if(i < 0) {
                        String s1 = stats1.cmdlineFile;
                        getName(stats1, s1);
                        if(stats1.threadStats != null)
                            mCurThreadPids = collectStats(stats1.threadsDir, j1, false, mCurThreadPids, stats1.threadStats);
                    }
                    long l6 = l1 - stats1.base_uptime;
                    stats1.rel_uptime = l6;
                    stats1.base_uptime = l1;
                    int k1 = (int)(l4 - stats1.base_utime);
                    stats1.rel_utime = k1;
                    int i2 = (int)(l5 - stats1.base_stime);
                    stats1.rel_stime = i2;
                    stats1.base_utime = l4;
                    stats1.base_stime = l5;
                    int j2 = (int)(l2 - stats1.base_minfaults);
                    stats1.rel_minfaults = j2;
                    int k2 = (int)(l3 - stats1.base_majfaults);
                    stats1.rel_majfaults = k2;
                    stats1.base_minfaults = l2;
                    stats1.base_majfaults = l3;
                    stats1.working = true;
                }
            }
        }
_L3:
        i1++;
        if(true) goto _L2; else goto _L1
_L1:
        if(stats1 == null || stats1.pid > j1) {
            Stats stats2 = new Stats(j1, i, mIncludeThreads);
            arraylist.add(l, stats2);
            l++;
            k++;
            String as[] = mProcessFullStatsStringData;
            long al[] = mProcessFullStatsData;
            stats2.base_uptime = SystemClock.uptimeMillis();
            if(Process.readProcFile(stats2.statFile.toString(), PROCESS_FULL_STATS_FORMAT, as, al, null)) {
                stats2.interesting = true;
                stats2.baseName = as[0];
                stats2.base_minfaults = al[1];
                stats2.base_majfaults = al[2];
                stats2.base_utime = al[3];
                stats2.base_stime = al[4];
            } else {
                Slog.w("ProcessStats", (new StringBuilder()).append("Skipping unknown process pid ").append(j1).toString());
                stats2.baseName = "<unknown>";
                stats2.base_stime = 0L;
                stats2.base_utime = 0L;
                stats2.base_majfaults = 0L;
                stats2.base_minfaults = 0L;
            }
            if(i < 0) {
                getName(stats2, stats2.cmdlineFile);
                if(stats2.threadStats != null)
                    mCurThreadPids = collectStats(stats2.threadsDir, j1, true, mCurThreadPids, stats2.threadStats);
            } else
            if(stats2.interesting) {
                stats2.name = stats2.baseName;
                stats2.nameWidth = onMeasureProcessName(stats2.name);
            }
            stats2.rel_utime = 0;
            stats2.rel_stime = 0;
            stats2.rel_minfaults = 0;
            stats2.rel_majfaults = 0;
            stats2.added = true;
            if(!flag && stats2.interesting)
                stats2.working = true;
        } else {
            stats1.rel_utime = 0;
            stats1.rel_stime = 0;
            stats1.rel_minfaults = 0;
            stats1.rel_majfaults = 0;
            stats1.removed = true;
            stats1.working = true;
            arraylist.remove(l);
            k--;
            i1--;
        }
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
        return ai1;
    }

    private long[] getCpuSpeedTimes(long al[]) {
        long al1[];
        long al2[];
        int i;
        String s;
        al1 = al;
        al2 = mCpuSpeeds;
        if(al == null) {
            al1 = new long[20];
            al2 = new long[20];
        }
        i = 0;
        s = readFile("/sys/devices/system/cpu/cpu0/cpufreq/stats/time_in_state", '\0');
        if(s == null) goto _L2; else goto _L1
_L1:
        StringTokenizer stringtokenizer = new StringTokenizer(s, "\n ");
_L5:
        if(!stringtokenizer.hasMoreElements()) goto _L2; else goto _L3
_L3:
        String s1 = stringtokenizer.nextToken();
        al2[i] = Long.parseLong(s1);
        al1[i] = Long.parseLong(stringtokenizer.nextToken());
        if(++i != 20)
            continue; /* Loop/switch isn't completed */
_L2:
        if(al == null) {
            al = new long[i];
            mCpuSpeeds = new long[i];
            System.arraycopy(al2, 0, mCpuSpeeds, 0, i);
            System.arraycopy(al1, 0, al, 0, i);
        }
        return al;
        NumberFormatException numberformatexception;
        numberformatexception;
        Slog.i("ProcessStats", "Unable to parse time_in_state");
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void getName(Stats stats, String s) {
        String s1 = stats.name;
        if(stats.name == null || stats.name.equals("app_process") || stats.name.equals("<pre-initialized>")) {
            String s2 = readFile(s, '\0');
            if(s2 != null && s2.length() > 1) {
                s1 = s2;
                int i = s1.lastIndexOf("/");
                if(i > 0 && i < -1 + s1.length())
                    s1 = s1.substring(i + 1);
            }
            if(s1 == null)
                s1 = stats.baseName;
        }
        if(stats.name == null || !s1.equals(stats.name)) {
            stats.name = s1;
            stats.nameWidth = onMeasureProcessName(stats.name);
        }
    }

    private void printProcessCPU(PrintWriter printwriter, String s, int i, String s1, int j, int k, int l, 
            int i1, int j1, int k1, int l1, int i2) {
        printwriter.print(s);
        if(j == 0)
            j = 1;
        printRatio(printwriter, k1 + (j1 + (i1 + (k + l))), j);
        printwriter.print("% ");
        if(i >= 0) {
            printwriter.print(i);
            printwriter.print("/");
        }
        printwriter.print(s1);
        printwriter.print(": ");
        printRatio(printwriter, k, j);
        printwriter.print("% user + ");
        printRatio(printwriter, l, j);
        printwriter.print("% kernel");
        if(i1 > 0) {
            printwriter.print(" + ");
            printRatio(printwriter, i1, j);
            printwriter.print("% iowait");
        }
        if(j1 > 0) {
            printwriter.print(" + ");
            printRatio(printwriter, j1, j);
            printwriter.print("% irq");
        }
        if(k1 > 0) {
            printwriter.print(" + ");
            printRatio(printwriter, k1, j);
            printwriter.print("% softirq");
        }
        if(l1 > 0 || i2 > 0) {
            printwriter.print(" / faults:");
            if(l1 > 0) {
                printwriter.print(" ");
                printwriter.print(l1);
                printwriter.print(" minor");
            }
            if(i2 > 0) {
                printwriter.print(" ");
                printwriter.print(i2);
                printwriter.print(" major");
            }
        }
        printwriter.println();
    }

    private void printRatio(PrintWriter printwriter, long l, long l1) {
        long l2 = (1000L * l) / l1;
        long l3 = l2 / 10L;
        printwriter.print(l3);
        if(l3 < 10L) {
            long l4 = l2 - l3 * 10L;
            if(l4 != 0L) {
                printwriter.print('.');
                printwriter.print(l4);
            }
        }
    }

    private String readFile(String s, char c) {
        android.os.StrictMode.ThreadPolicy threadpolicy;
        FileInputStream fileinputstream;
        threadpolicy = StrictMode.allowThreadDiskReads();
        fileinputstream = null;
        FileInputStream fileinputstream1 = new FileInputStream(s);
        int i;
        i = fileinputstream1.read(mBuffer);
        fileinputstream1.close();
        if(i <= 0) goto _L2; else goto _L1
_L1:
        int j = 0;
_L12:
        if(j < i && mBuffer[j] != c) goto _L4; else goto _L3
_L3:
        String s1 = new String(mBuffer, 0, j);
        Exception exception;
        IOException ioexception6;
        FileNotFoundException filenotfoundexception1;
        if(fileinputstream1 != null)
            try {
                fileinputstream1.close();
            }
            catch(IOException ioexception5) { }
        StrictMode.setThreadPolicy(threadpolicy);
        return s1;
_L4:
        j++;
        continue; /* Loop/switch isn't completed */
_L2:
        if(fileinputstream1 != null)
            try {
                fileinputstream1.close();
            }
            catch(IOException ioexception4) { }
        StrictMode.setThreadPolicy(threadpolicy);
        s1 = null;
        if(true)
            break MISSING_BLOCK_LABEL_89;
        filenotfoundexception1;
_L10:
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception) { }
        StrictMode.setThreadPolicy(threadpolicy);
        break MISSING_BLOCK_LABEL_112;
        ioexception6;
_L8:
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception2) { }
        StrictMode.setThreadPolicy(threadpolicy);
        break MISSING_BLOCK_LABEL_112;
        exception;
_L6:
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception3) { }
        StrictMode.setThreadPolicy(threadpolicy);
        throw exception;
        exception;
        fileinputstream = fileinputstream1;
        if(true) goto _L6; else goto _L5
_L5:
        IOException ioexception1;
        ioexception1;
        fileinputstream = fileinputstream1;
        if(true) goto _L8; else goto _L7
_L7:
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        fileinputstream = fileinputstream1;
        if(true) goto _L10; else goto _L9
_L9:
        if(true) goto _L12; else goto _L11
_L11:
    }

    final void buildWorkingProcs() {
        if(!mWorkingProcsSorted) {
            mWorkingProcs.clear();
            int i = mProcStats.size();
            for(int j = 0; j < i; j++) {
                Stats stats = (Stats)mProcStats.get(j);
                if(!stats.working)
                    continue;
                mWorkingProcs.add(stats);
                if(stats.threadStats == null || stats.threadStats.size() <= 1)
                    continue;
                stats.workingThreads.clear();
                int k = stats.threadStats.size();
                for(int l = 0; l < k; l++) {
                    Stats stats1 = (Stats)stats.threadStats.get(l);
                    if(stats1.working)
                        stats.workingThreads.add(stats1);
                }

                Collections.sort(stats.workingThreads, sLoadComparator);
            }

            Collections.sort(mWorkingProcs, sLoadComparator);
            mWorkingProcsSorted = true;
        }
    }

    public final int countStats() {
        return mProcStats.size();
    }

    public final int countWorkingStats() {
        buildWorkingProcs();
        return mWorkingProcs.size();
    }

    public long getCpuTimeForPid(int i) {
        String s = (new StringBuilder()).append("/proc/").append(i).append("/stat").toString();
        long al[] = mSinglePidStatsData;
        long l;
        if(Process.readProcFile(s, PROCESS_STATS_FORMAT, null, al, null))
            l = al[2] + al[3];
        else
            l = 0L;
        return l;
    }

    public long[] getLastCpuSpeedTimes() {
        if(mCpuSpeedTimes == null) {
            mCpuSpeedTimes = getCpuSpeedTimes(null);
            mRelCpuSpeedTimes = new long[mCpuSpeedTimes.length];
            for(int j = 0; j < mCpuSpeedTimes.length; j++)
                mRelCpuSpeedTimes[j] = 1L;

        } else {
            getCpuSpeedTimes(mRelCpuSpeedTimes);
            for(int i = 0; i < mCpuSpeedTimes.length; i++) {
                long l = mRelCpuSpeedTimes[i];
                long al[] = mRelCpuSpeedTimes;
                al[i] = al[i] - mCpuSpeedTimes[i];
                mCpuSpeedTimes[i] = l;
            }

        }
        return mRelCpuSpeedTimes;
    }

    public final int getLastIdleTime() {
        return mRelIdleTime;
    }

    public final int getLastIoWaitTime() {
        return mRelIoWaitTime;
    }

    public final int getLastIrqTime() {
        return mRelIrqTime;
    }

    public final int getLastSoftIrqTime() {
        return mRelSoftIrqTime;
    }

    public final int getLastSystemTime() {
        return mRelSystemTime;
    }

    public final int getLastUserTime() {
        return mRelUserTime;
    }

    public final Stats getStats(int i) {
        return (Stats)mProcStats.get(i);
    }

    public final float getTotalCpuPercent() {
        int i = mRelUserTime + mRelSystemTime + mRelIrqTime + mRelIdleTime;
        float f;
        if(i <= 0)
            f = 0.0F;
        else
            f = (100F * (float)(mRelUserTime + mRelSystemTime + mRelIrqTime)) / (float)i;
        return f;
    }

    public final Stats getWorkingStats(int i) {
        return (Stats)mWorkingProcs.get(i);
    }

    public void init() {
        mFirst = true;
        update();
    }

    public void onLoadChanged(float f, float f1, float f2) {
    }

    public int onMeasureProcessName(String s) {
        return 0;
    }

    public final String printCurrentLoad() {
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        printwriter.print("Load: ");
        printwriter.print(mLoad1);
        printwriter.print(" / ");
        printwriter.print(mLoad5);
        printwriter.print(" / ");
        printwriter.println(mLoad15);
        return stringwriter.toString();
    }

    public final String printCurrentState(long l) {
        StringWriter stringwriter;
        PrintWriter printwriter;
        int i;
        int k;
        Stats stats1;
        String s1;
        buildWorkingProcs();
        stringwriter = new StringWriter();
        printwriter = new PrintWriter(stringwriter);
        printwriter.print("CPU usage from ");
        long l1;
        long l2;
        long l3;
        int j;
        int i1;
        int j1;
        if(l > mLastSampleTime) {
            printwriter.print(l - mLastSampleTime);
            printwriter.print("ms to ");
            printwriter.print(l - mCurrentSampleTime);
            printwriter.print("ms ago");
        } else {
            printwriter.print(mLastSampleTime - l);
            printwriter.print("ms to ");
            printwriter.print(mCurrentSampleTime - l);
            printwriter.print("ms later");
        }
        l1 = mCurrentSampleTime - mLastSampleTime;
        l2 = mCurrentSampleRealTime - mLastSampleRealTime;
        if(l2 > 0L)
            l3 = (100L * l1) / l2;
        else
            l3 = 0L;
        if(l3 != 100L) {
            printwriter.print(" with ");
            printwriter.print(l3);
            printwriter.print("% awake");
        }
        printwriter.println(":");
        i = mRelUserTime + mRelSystemTime + mRelIoWaitTime + mRelIrqTime + mRelSoftIrqTime + mRelIdleTime;
        j = mWorkingProcs.size();
        k = 0;
_L9:
        if(k >= j) goto _L2; else goto _L1
_L1:
        Stats stats = (Stats)mWorkingProcs.get(k);
        String s;
        if(stats.added)
            s = " +";
        else
        if(stats.removed)
            s = " -";
        else
            s = "  ";
        printProcessCPU(printwriter, s, stats.pid, stats.name, (int)(5L + stats.rel_uptime) / 10, stats.rel_utime, stats.rel_stime, 0, 0, 0, stats.rel_minfaults, stats.rel_majfaults);
        if(stats.removed || stats.workingThreads == null)
            continue; /* Loop/switch isn't completed */
        i1 = stats.workingThreads.size();
        j1 = 0;
_L8:
        if(j1 >= i1)
            continue; /* Loop/switch isn't completed */
        stats1 = (Stats)stats.workingThreads.get(j1);
        if(!stats1.added)
            break; /* Loop/switch isn't completed */
        s1 = "   +";
_L6:
        printProcessCPU(printwriter, s1, stats1.pid, stats1.name, (int)(5L + stats.rel_uptime) / 10, stats1.rel_utime, stats1.rel_stime, 0, 0, 0, 0, 0);
        j1++;
        if(true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_317;
_L3:
        if(stats1.removed)
            s1 = "   -";
        else
            s1 = "    ";
        if(true) goto _L6; else goto _L5
_L5:
        if(true) goto _L8; else goto _L7
_L7:
        k++;
          goto _L9
_L2:
        printProcessCPU(printwriter, "", -1, "TOTAL", i, mRelUserTime, mRelSystemTime, mRelIoWaitTime, mRelIrqTime, mRelSoftIrqTime, 0, 0);
        return stringwriter.toString();
    }

    public void update() {
        mLastSampleTime = mCurrentSampleTime;
        mCurrentSampleTime = SystemClock.uptimeMillis();
        mLastSampleRealTime = mCurrentSampleRealTime;
        mCurrentSampleRealTime = SystemClock.elapsedRealtime();
        long al[] = mSystemCpuData;
        if(Process.readProcFile("/proc/stat", SYSTEM_CPU_FORMAT, null, al, null)) {
            long l = al[0] + al[1];
            long l1 = al[2];
            long l2 = al[3];
            long l3 = al[4];
            long l4 = al[5];
            long l5 = al[6];
            mRelUserTime = (int)(l - mBaseUserTime);
            mRelSystemTime = (int)(l1 - mBaseSystemTime);
            mRelIoWaitTime = (int)(l3 - mBaseIoWaitTime);
            mRelIrqTime = (int)(l4 - mBaseIrqTime);
            mRelSoftIrqTime = (int)(l5 - mBaseSoftIrqTime);
            mRelIdleTime = (int)(l2 - mBaseIdleTime);
            mBaseUserTime = l;
            mBaseSystemTime = l1;
            mBaseIoWaitTime = l3;
            mBaseIrqTime = l4;
            mBaseSoftIrqTime = l5;
            mBaseIdleTime = l2;
        }
        mCurPids = collectStats("/proc", -1, mFirst, mCurPids, mProcStats);
        float af[] = mLoadAverageData;
        if(Process.readProcFile("/proc/loadavg", LOAD_AVERAGE_FORMAT, null, null, af)) {
            float f = af[0];
            float f1 = af[1];
            float f2 = af[2];
            if(f != mLoad1 || f1 != mLoad5 || f2 != mLoad15) {
                mLoad1 = f;
                mLoad5 = f1;
                mLoad15 = f2;
                onLoadChanged(f, f1, f2);
            }
        }
        mWorkingProcsSorted = false;
        mFirst = false;
    }

    private static final boolean DEBUG = false;
    private static final int LOAD_AVERAGE_FORMAT[];
    private static final int PROCESS_FULL_STATS_FORMAT[];
    static final int PROCESS_FULL_STAT_MAJOR_FAULTS = 2;
    static final int PROCESS_FULL_STAT_MINOR_FAULTS = 1;
    static final int PROCESS_FULL_STAT_STIME = 4;
    static final int PROCESS_FULL_STAT_UTIME = 3;
    static final int PROCESS_FULL_STAT_VSIZE = 5;
    private static final int PROCESS_STATS_FORMAT[];
    static final int PROCESS_STAT_MAJOR_FAULTS = 1;
    static final int PROCESS_STAT_MINOR_FAULTS = 0;
    static final int PROCESS_STAT_STIME = 3;
    static final int PROCESS_STAT_UTIME = 2;
    private static final int SYSTEM_CPU_FORMAT[];
    private static final String TAG = "ProcessStats";
    private static final boolean localLOGV;
    private static final Comparator sLoadComparator = new Comparator() {

        public final int compare(Stats stats, Stats stats1) {
            byte byte0;
            int i;
            int j;
            byte0 = -1;
            i = stats.rel_utime + stats.rel_stime;
            j = stats1.rel_utime + stats1.rel_stime;
            if(i == j) goto _L2; else goto _L1
_L1:
            if(i <= j)
                byte0 = 1;
_L4:
            return byte0;
_L2:
            if(stats.added != stats1.added) {
                if(!stats.added)
                    byte0 = 1;
            } else
            if(stats.removed != stats1.removed) {
                if(!stats.added)
                    byte0 = 1;
            } else {
                byte0 = 0;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public volatile int compare(Object obj, Object obj1) {
            return compare((Stats)obj, (Stats)obj1);
        }

    };
    private long mBaseIdleTime;
    private long mBaseIoWaitTime;
    private long mBaseIrqTime;
    private long mBaseSoftIrqTime;
    private long mBaseSystemTime;
    private long mBaseUserTime;
    private byte mBuffer[];
    private long mCpuSpeedTimes[];
    private long mCpuSpeeds[];
    private int mCurPids[];
    private int mCurThreadPids[];
    private long mCurrentSampleRealTime;
    private long mCurrentSampleTime;
    private boolean mFirst;
    private final boolean mIncludeThreads;
    private long mLastSampleRealTime;
    private long mLastSampleTime;
    private float mLoad1;
    private float mLoad15;
    private float mLoad5;
    private final float mLoadAverageData[] = new float[3];
    private final ArrayList mProcStats = new ArrayList();
    private final long mProcessFullStatsData[] = new long[6];
    private final String mProcessFullStatsStringData[] = new String[6];
    private final long mProcessStatsData[] = new long[4];
    private long mRelCpuSpeedTimes[];
    private int mRelIdleTime;
    private int mRelIoWaitTime;
    private int mRelIrqTime;
    private int mRelSoftIrqTime;
    private int mRelSystemTime;
    private int mRelUserTime;
    private final long mSinglePidStatsData[] = new long[4];
    private final long mSystemCpuData[] = new long[7];
    private final ArrayList mWorkingProcs = new ArrayList();
    private boolean mWorkingProcsSorted;

    static  {
        int ai[] = new int[15];
        ai[0] = 32;
        ai[1] = 544;
        ai[2] = 32;
        ai[3] = 32;
        ai[4] = 32;
        ai[5] = 32;
        ai[6] = 32;
        ai[7] = 32;
        ai[8] = 32;
        ai[9] = 8224;
        ai[10] = 32;
        ai[11] = 8224;
        ai[12] = 32;
        ai[13] = 8224;
        ai[14] = 8224;
        PROCESS_STATS_FORMAT = ai;
        int ai1[] = new int[22];
        ai1[0] = 32;
        ai1[1] = 4640;
        ai1[2] = 32;
        ai1[3] = 32;
        ai1[4] = 32;
        ai1[5] = 32;
        ai1[6] = 32;
        ai1[7] = 32;
        ai1[8] = 32;
        ai1[9] = 8224;
        ai1[10] = 32;
        ai1[11] = 8224;
        ai1[12] = 32;
        ai1[13] = 8224;
        ai1[14] = 8224;
        ai1[15] = 32;
        ai1[16] = 32;
        ai1[17] = 32;
        ai1[18] = 32;
        ai1[19] = 32;
        ai1[20] = 32;
        ai1[21] = 8224;
        PROCESS_FULL_STATS_FORMAT = ai1;
        int ai2[] = new int[8];
        ai2[0] = 288;
        ai2[1] = 8224;
        ai2[2] = 8224;
        ai2[3] = 8224;
        ai2[4] = 8224;
        ai2[5] = 8224;
        ai2[6] = 8224;
        ai2[7] = 8224;
        SYSTEM_CPU_FORMAT = ai2;
        int ai3[] = new int[3];
        ai3[0] = 16416;
        ai3[1] = 16416;
        ai3[2] = 16416;
        LOAD_AVERAGE_FORMAT = ai3;
    }
}
