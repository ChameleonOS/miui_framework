// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.content.Context;
import android.os.*;
import com.android.server.NetworkManagementSocketTagger;
import dalvik.system.SocketTagger;
import java.net.Socket;
import java.net.SocketException;

// Referenced classes of package android.net:
//            INetworkStatsSession, INetworkStatsService, NetworkStats

public class TrafficStats {

    public TrafficStats() {
    }

    public static void clearThreadStatsTag() {
        NetworkManagementSocketTagger.setThreadSocketStatsTag(-1);
    }

    public static void clearThreadStatsUid() {
        NetworkManagementSocketTagger.setThreadSocketStatsUid(-1);
    }

    public static void closeQuietly(INetworkStatsSession inetworkstatssession) {
        if(inetworkstatssession == null)
            break MISSING_BLOCK_LABEL_10;
        inetworkstatssession.close();
_L2:
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        throw runtimeexception;
        Exception exception;
        exception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static NetworkStats getDataLayerSnapshotForUid(Context context) {
        int i = Process.myUid();
        NetworkStats networkstats;
        try {
            networkstats = getStatsService().getDataLayerSnapshotForUid(i);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
        return networkstats;
    }

    private static String[] getMobileIfaces() {
        String as[];
        try {
            as = getStatsService().getMobileIfaces();
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
        return as;
    }

    public static long getMobileRxBytes() {
        long l = 0L;
        String as[] = getMobileIfaces();
        int i = as.length;
        for(int j = 0; j < i; j++)
            l += getRxBytes(as[j]);

        return l;
    }

    public static long getMobileRxPackets() {
        long l = 0L;
        String as[] = getMobileIfaces();
        int i = as.length;
        for(int j = 0; j < i; j++)
            l += getRxPackets(as[j]);

        return l;
    }

    public static long getMobileTxBytes() {
        long l = 0L;
        String as[] = getMobileIfaces();
        int i = as.length;
        for(int j = 0; j < i; j++)
            l += getTxBytes(as[j]);

        return l;
    }

    public static long getMobileTxPackets() {
        long l = 0L;
        String as[] = getMobileIfaces();
        int i = as.length;
        for(int j = 0; j < i; j++)
            l += getTxPackets(as[j]);

        return l;
    }

    public static long getRxBytes(String s) {
        return nativeGetIfaceStat(s, 0);
    }

    public static long getRxPackets(String s) {
        return nativeGetIfaceStat(s, 1);
    }

    /**
     * @deprecated Method getStatsService is deprecated
     */

    private static INetworkStatsService getStatsService() {
        android/net/TrafficStats;
        JVM INSTR monitorenter ;
        INetworkStatsService inetworkstatsservice;
        if(sStatsService == null)
            sStatsService = INetworkStatsService.Stub.asInterface(ServiceManager.getService("netstats"));
        inetworkstatsservice = sStatsService;
        android/net/TrafficStats;
        JVM INSTR monitorexit ;
        return inetworkstatsservice;
        Exception exception;
        exception;
        throw exception;
    }

    public static int getThreadStatsTag() {
        return NetworkManagementSocketTagger.getThreadSocketStatsTag();
    }

    public static long getTotalRxBytes() {
        return nativeGetTotalStat(0);
    }

    public static long getTotalRxPackets() {
        return nativeGetTotalStat(1);
    }

    public static long getTotalTxBytes() {
        return nativeGetTotalStat(2);
    }

    public static long getTotalTxPackets() {
        return nativeGetTotalStat(3);
    }

    public static long getTxBytes(String s) {
        return nativeGetIfaceStat(s, 2);
    }

    public static long getTxPackets(String s) {
        return nativeGetIfaceStat(s, 3);
    }

    public static native long getUidRxBytes(int i);

    public static native long getUidRxPackets(int i);

    public static native long getUidTcpRxBytes(int i);

    public static native long getUidTcpRxSegments(int i);

    public static native long getUidTcpTxBytes(int i);

    public static native long getUidTcpTxSegments(int i);

    public static native long getUidTxBytes(int i);

    public static native long getUidTxPackets(int i);

    public static native long getUidUdpRxBytes(int i);

    public static native long getUidUdpRxPackets(int i);

    public static native long getUidUdpTxBytes(int i);

    public static native long getUidUdpTxPackets(int i);

    public static void incrementOperationCount(int i) {
        incrementOperationCount(getThreadStatsTag(), i);
    }

    public static void incrementOperationCount(int i, int j) {
        int k = Process.myUid();
        try {
            getStatsService().incrementOperationCount(k, i, j);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException(remoteexception);
        }
    }

    private static native long nativeGetIfaceStat(String s, int i);

    private static native long nativeGetTotalStat(int i);

    public static void setThreadStatsTag(int i) {
        NetworkManagementSocketTagger.setThreadSocketStatsTag(i);
    }

    public static void setThreadStatsUid(int i) {
        NetworkManagementSocketTagger.setThreadSocketStatsUid(i);
    }

    public static void startDataProfiling(Context context) {
        Object obj = sProfilingLock;
        obj;
        JVM INSTR monitorenter ;
        if(sActiveProfilingStart != null)
            throw new IllegalStateException("already profiling data");
        break MISSING_BLOCK_LABEL_27;
        Exception exception;
        exception;
        throw exception;
        sActiveProfilingStart = getDataLayerSnapshotForUid(context);
        obj;
        JVM INSTR monitorexit ;
    }

    public static NetworkStats stopDataProfiling(Context context) {
        Object obj = sProfilingLock;
        obj;
        JVM INSTR monitorenter ;
        if(sActiveProfilingStart == null)
            throw new IllegalStateException("not profiling data");
        break MISSING_BLOCK_LABEL_27;
        Exception exception;
        exception;
        throw exception;
        NetworkStats networkstats;
        networkstats = NetworkStats.subtract(getDataLayerSnapshotForUid(context), sActiveProfilingStart, null, null);
        sActiveProfilingStart = null;
        obj;
        JVM INSTR monitorexit ;
        return networkstats;
    }

    public static void tagSocket(Socket socket) throws SocketException {
        SocketTagger.get().tag(socket);
    }

    public static void untagSocket(Socket socket) throws SocketException {
        SocketTagger.get().untag(socket);
    }

    public static final long GB_IN_BYTES = 0x40000000L;
    public static final long KB_IN_BYTES = 1024L;
    public static final long MB_IN_BYTES = 0x100000L;
    public static final int TAG_SYSTEM_BACKUP = -253;
    public static final int TAG_SYSTEM_DOWNLOAD = -255;
    public static final int TAG_SYSTEM_MEDIA = -254;
    private static final int TYPE_RX_BYTES = 0;
    private static final int TYPE_RX_PACKETS = 1;
    private static final int TYPE_TX_BYTES = 2;
    private static final int TYPE_TX_PACKETS = 3;
    public static final int UID_REMOVED = -4;
    public static final int UID_TETHERING = -5;
    public static final int UNSUPPORTED = -1;
    private static NetworkStats sActiveProfilingStart;
    private static Object sProfilingLock = new Object();
    private static INetworkStatsService sStatsService;

}
