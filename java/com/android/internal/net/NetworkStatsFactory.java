// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.net;

import android.net.NetworkStats;
import android.os.StrictMode;
import android.os.SystemClock;
import com.android.internal.util.ProcFileReader;
import com.android.server.NetworkManagementSocketTagger;
import java.io.*;
import libcore.io.IoUtils;

public class NetworkStatsFactory {

    public NetworkStatsFactory() {
        this(new File("/proc/"));
    }

    public NetworkStatsFactory(File file) {
        mStatsXtIfaceAll = new File(file, "net/xt_qtaguid/iface_stat_all");
        mStatsXtIfaceFmt = new File(file, "net/xt_qtaguid/iface_stat_fmt");
        mStatsXtUid = new File(file, "net/xt_qtaguid/stats");
    }

    public NetworkStats readNetworkStatsDetail() {
        return readNetworkStatsDetail(-1);
    }

    public NetworkStats readNetworkStatsDetail(int i) throws IllegalStateException {
        android.os.StrictMode.ThreadPolicy threadpolicy;
        NetworkStats networkstats;
        android.net.NetworkStats.Entry entry;
        int j;
        int k;
        Object obj;
        threadpolicy = StrictMode.allowThreadDiskReads();
        networkstats = new NetworkStats(SystemClock.elapsedRealtime(), 24);
        entry = new android.net.NetworkStats.Entry();
        j = 1;
        k = 1;
        obj = null;
        ProcFileReader procfilereader = new ProcFileReader(new FileInputStream(mStatsXtUid));
        procfilereader.finishLine();
_L4:
        if(!procfilereader.hasMoreData()) goto _L2; else goto _L1
_L1:
        j = procfilereader.nextInt();
        if(j != k + 1)
            throw new IllegalStateException((new StringBuilder()).append("inconsistent idx=").append(j).append(" after lastIdx=").append(k).toString());
          goto _L3
        NullPointerException nullpointerexception;
        nullpointerexception;
        obj = procfilereader;
_L8:
        throw new IllegalStateException((new StringBuilder()).append("problem parsing idx ").append(j).toString(), nullpointerexception);
        Exception exception;
        exception;
_L5:
        IoUtils.closeQuietly(((AutoCloseable) (obj)));
        StrictMode.setThreadPolicy(threadpolicy);
        throw exception;
_L3:
        k = j;
        entry.iface = procfilereader.nextString();
        entry.tag = NetworkManagementSocketTagger.kernelToTag(procfilereader.nextString());
        entry.uid = procfilereader.nextInt();
        entry.set = procfilereader.nextInt();
        entry.rxBytes = procfilereader.nextLong();
        entry.rxPackets = procfilereader.nextLong();
        entry.txBytes = procfilereader.nextLong();
        entry.txPackets = procfilereader.nextLong();
        if(i == -1 || i == entry.uid)
            networkstats.addValues(entry);
        procfilereader.finishLine();
          goto _L4
        NumberFormatException numberformatexception;
        numberformatexception;
        obj = procfilereader;
_L7:
        throw new IllegalStateException((new StringBuilder()).append("problem parsing idx ").append(j).toString(), numberformatexception);
_L2:
        IoUtils.closeQuietly(procfilereader);
        StrictMode.setThreadPolicy(threadpolicy);
        return networkstats;
        IOException ioexception;
        ioexception;
_L6:
        throw new IllegalStateException((new StringBuilder()).append("problem parsing idx ").append(j).toString(), ioexception);
        exception;
        obj = procfilereader;
          goto _L5
        ioexception;
        obj = procfilereader;
          goto _L6
        numberformatexception;
          goto _L7
        nullpointerexception;
          goto _L8
    }

    public NetworkStats readNetworkStatsSummaryDev() throws IllegalStateException {
        android.os.StrictMode.ThreadPolicy threadpolicy;
        NetworkStats networkstats;
        android.net.NetworkStats.Entry entry;
        Object obj;
        threadpolicy = StrictMode.allowThreadDiskReads();
        networkstats = new NetworkStats(SystemClock.elapsedRealtime(), 6);
        entry = new android.net.NetworkStats.Entry();
        obj = null;
        ProcFileReader procfilereader = new ProcFileReader(new FileInputStream(mStatsXtIfaceAll));
_L5:
        if(!procfilereader.hasMoreData()) goto _L2; else goto _L1
_L1:
        entry.iface = procfilereader.nextString();
        entry.uid = -1;
        entry.set = -1;
        entry.tag = 0;
        if(procfilereader.nextInt() == 0) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        entry.rxBytes = procfilereader.nextLong();
        entry.rxPackets = procfilereader.nextLong();
        entry.txBytes = procfilereader.nextLong();
        entry.txPackets = procfilereader.nextLong();
        if(flag) {
            entry.rxBytes = entry.rxBytes + procfilereader.nextLong();
            entry.rxPackets = entry.rxPackets + procfilereader.nextLong();
            entry.txBytes = entry.txBytes + procfilereader.nextLong();
            entry.txPackets = entry.txPackets + procfilereader.nextLong();
        }
        networkstats.addValues(entry);
        procfilereader.finishLine();
          goto _L5
        NullPointerException nullpointerexception;
        nullpointerexception;
        obj = procfilereader;
_L10:
        throw new IllegalStateException((new StringBuilder()).append("problem parsing stats: ").append(nullpointerexception).toString());
        Exception exception;
        exception;
_L7:
        IoUtils.closeQuietly(((AutoCloseable) (obj)));
        StrictMode.setThreadPolicy(threadpolicy);
        throw exception;
_L4:
        flag = false;
          goto _L6
_L2:
        IoUtils.closeQuietly(procfilereader);
        StrictMode.setThreadPolicy(threadpolicy);
        return networkstats;
        NumberFormatException numberformatexception;
        numberformatexception;
_L9:
        throw new IllegalStateException((new StringBuilder()).append("problem parsing stats: ").append(numberformatexception).toString());
_L8:
        IOException ioexception;
        throw new IllegalStateException((new StringBuilder()).append("problem parsing stats: ").append(ioexception).toString());
        exception;
        obj = procfilereader;
          goto _L7
        ioexception;
        obj = procfilereader;
          goto _L8
        numberformatexception;
        obj = procfilereader;
          goto _L9
        nullpointerexception;
          goto _L10
        ioexception;
          goto _L8
    }

    public NetworkStats readNetworkStatsSummaryXt() throws IllegalStateException {
        android.os.StrictMode.ThreadPolicy threadpolicy = StrictMode.allowThreadDiskReads();
        if(mStatsXtIfaceFmt.exists()) goto _L2; else goto _L1
_L1:
        NetworkStats networkstats = null;
_L4:
        return networkstats;
_L2:
        android.net.NetworkStats.Entry entry;
        Object obj;
        networkstats = new NetworkStats(SystemClock.elapsedRealtime(), 6);
        entry = new android.net.NetworkStats.Entry();
        obj = null;
        ProcFileReader procfilereader = new ProcFileReader(new FileInputStream(mStatsXtIfaceFmt));
        procfilereader.finishLine();
        for(; procfilereader.hasMoreData(); procfilereader.finishLine()) {
            entry.iface = procfilereader.nextString();
            entry.uid = -1;
            entry.set = -1;
            entry.tag = 0;
            entry.rxBytes = procfilereader.nextLong();
            entry.rxPackets = procfilereader.nextLong();
            entry.txBytes = procfilereader.nextLong();
            entry.txPackets = procfilereader.nextLong();
            networkstats.addValues(entry);
        }

          goto _L3
        NullPointerException nullpointerexception;
        nullpointerexception;
        obj = procfilereader;
_L8:
        throw new IllegalStateException((new StringBuilder()).append("problem parsing stats: ").append(nullpointerexception).toString());
        Exception exception;
        exception;
_L5:
        IoUtils.closeQuietly(((AutoCloseable) (obj)));
        StrictMode.setThreadPolicy(threadpolicy);
        throw exception;
_L3:
        IoUtils.closeQuietly(procfilereader);
        StrictMode.setThreadPolicy(threadpolicy);
          goto _L4
        NumberFormatException numberformatexception;
        numberformatexception;
_L7:
        throw new IllegalStateException((new StringBuilder()).append("problem parsing stats: ").append(numberformatexception).toString());
_L6:
        IOException ioexception;
        throw new IllegalStateException((new StringBuilder()).append("problem parsing stats: ").append(ioexception).toString());
        exception;
        obj = procfilereader;
          goto _L5
        ioexception;
        obj = procfilereader;
          goto _L6
        numberformatexception;
        obj = procfilereader;
          goto _L7
        nullpointerexception;
          goto _L8
        ioexception;
          goto _L6
    }

    private static final String TAG = "NetworkStatsFactory";
    private final File mStatsXtIfaceAll;
    private final File mStatsXtIfaceFmt;
    private final File mStatsXtUid;
}
