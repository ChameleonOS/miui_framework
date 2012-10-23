// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.server;

import android.os.SystemProperties;
import android.util.Log;
import android.util.Slog;
import dalvik.system.SocketTagger;
import java.io.FileDescriptor;
import java.net.SocketException;

public final class NetworkManagementSocketTagger extends SocketTagger {
    public static class SocketTags {

        public int statsTag;
        public int statsUid;

        public SocketTags() {
            statsTag = -1;
            statsUid = -1;
        }
    }


    public NetworkManagementSocketTagger() {
    }

    public static int getThreadSocketStatsTag() {
        return ((SocketTags)threadSocketTags.get()).statsTag;
    }

    public static void install() {
        SocketTagger.set(new NetworkManagementSocketTagger());
    }

    public static int kernelToTag(String s) {
        int i = 0;
        int j = s.length();
        if(j > 10)
            i = Long.decode(s.substring(0, j - 8)).intValue();
        return i;
    }

    private static native int native_deleteTagData(int i, int j);

    private static native int native_setCounterSet(int i, int j);

    private static native int native_tagSocketFd(FileDescriptor filedescriptor, int i, int j);

    private static native int native_untagSocketFd(FileDescriptor filedescriptor);

    public static void resetKernelUidStats(int i) {
        if(SystemProperties.getBoolean("net.qtaguid_enabled", false)) {
            int j = native_deleteTagData(0, i);
            if(j < 0)
                Slog.w("NetworkManagementSocketTagger", (new StringBuilder()).append("problem clearing counters for uid ").append(i).append(" : errno ").append(j).toString());
        }
    }

    public static void setKernelCounterSet(int i, int j) {
        if(SystemProperties.getBoolean("net.qtaguid_enabled", false)) {
            int k = native_setCounterSet(j, i);
            if(k < 0)
                Log.w("NetworkManagementSocketTagger", (new StringBuilder()).append("setKernelCountSet(").append(i).append(", ").append(j).append(") failed with errno ").append(k).toString());
        }
    }

    public static void setThreadSocketStatsTag(int i) {
        ((SocketTags)threadSocketTags.get()).statsTag = i;
    }

    public static void setThreadSocketStatsUid(int i) {
        ((SocketTags)threadSocketTags.get()).statsUid = i;
    }

    private void tagSocketFd(FileDescriptor filedescriptor, int i, int j) {
_L2:
        return;
        if(i == -1 && j == -1 || !SystemProperties.getBoolean("net.qtaguid_enabled", false)) goto _L2; else goto _L1
_L1:
        int k = native_tagSocketFd(filedescriptor, i, j);
        if(k < 0)
            Log.i("NetworkManagementSocketTagger", (new StringBuilder()).append("tagSocketFd(").append(filedescriptor.getInt$()).append(", ").append(i).append(", ").append(j).append(") failed with errno").append(k).toString());
        if(true) goto _L2; else goto _L3
_L3:
    }

    private void unTagSocketFd(FileDescriptor filedescriptor) {
        SocketTags sockettags;
        sockettags = (SocketTags)threadSocketTags.get();
        break MISSING_BLOCK_LABEL_10;
        while(true)  {
            do
                return;
            while(sockettags.statsTag == -1 && sockettags.statsUid == -1 || !SystemProperties.getBoolean("net.qtaguid_enabled", false));
            int i = native_untagSocketFd(filedescriptor);
            if(i < 0)
                Log.w("NetworkManagementSocketTagger", (new StringBuilder()).append("untagSocket(").append(filedescriptor.getInt$()).append(") failed with errno ").append(i).toString());
        }
    }

    public void tag(FileDescriptor filedescriptor) throws SocketException {
        SocketTags sockettags = (SocketTags)threadSocketTags.get();
        tagSocketFd(filedescriptor, sockettags.statsTag, sockettags.statsUid);
    }

    public void untag(FileDescriptor filedescriptor) throws SocketException {
        unTagSocketFd(filedescriptor);
    }

    private static final boolean LOGD = false;
    public static final String PROP_QTAGUID_ENABLED = "net.qtaguid_enabled";
    private static final String TAG = "NetworkManagementSocketTagger";
    private static ThreadLocal threadSocketTags = new ThreadLocal() {

        protected SocketTags initialValue() {
            return new SocketTags();
        }

        protected volatile Object initialValue() {
            return initialValue();
        }

    };

}
