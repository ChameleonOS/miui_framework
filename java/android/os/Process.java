// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.util.Log;
import java.io.*;
import java.util.ArrayList;

// Referenced classes of package android.os:
//            UserId, ZygoteStartFailedEx

public class Process {
    public static final class ProcessStartResult {

        public int pid;
        public boolean usingWrapper;

        public ProcessStartResult() {
        }
    }


    public Process() {
    }

    public static final native long getElapsedCpuTime();

    public static final native long getFreeMemory();

    public static final native int getGidForName(String s);

    public static final int getParentPid(int i) {
        String as[] = new String[1];
        as[0] = "PPid:";
        long al[] = new long[1];
        al[0] = -1L;
        readProcLines((new StringBuilder()).append("/proc/").append(i).append("/status").toString(), as, al);
        return (int)al[0];
    }

    public static final native int[] getPids(String s, int ai[]);

    public static final native int[] getPidsForCommands(String as[]);

    public static final native long getPss(int i);

    public static final int getThreadGroupLeader(int i) {
        String as[] = new String[1];
        as[0] = "Tgid:";
        long al[] = new long[1];
        al[0] = -1L;
        readProcLines((new StringBuilder()).append("/proc/").append(i).append("/status").toString(), as, al);
        return (int)al[0];
    }

    public static final native int getThreadPriority(int i) throws IllegalArgumentException;

    public static final native long getTotalMemory();

    public static final native int getUidForName(String s);

    public static final int getUidForPid(int i) {
        String as[] = new String[1];
        as[0] = "Uid:";
        long al[] = new long[1];
        al[0] = -1L;
        readProcLines((new StringBuilder()).append("/proc/").append(i).append("/status").toString(), as, al);
        return (int)al[0];
    }

    public static final boolean isIsolated() {
        int i = UserId.getAppId(myUid());
        boolean flag;
        if(i >= 0x182b8 && i <= 0x1869f)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final void killProcess(int i) {
        sendSignal(i, 9);
    }

    public static final void killProcessQuiet(int i) {
        sendSignalQuiet(i, 9);
    }

    public static final native int myPid();

    public static final native int myTid();

    public static final native int myUid();

    private static void openZygoteSocketIfNeeded() throws ZygoteStartFailedEx {
        int j;
        int i;
        if(sPreviousZygoteOpenFailed)
            i = 0;
        else
            i = 10;
        j = 0;
_L2:
        if(sZygoteSocket != null || j >= i + 1)
            break MISSING_BLOCK_LABEL_124;
        IOException ioexception;
        IOException ioexception1;
        if(j > 0)
            try {
                Log.i("Zygote", "Zygote not up yet, sleeping...");
                Thread.sleep(500L);
            }
            catch(InterruptedException interruptedexception) { }
        sZygoteSocket = new LocalSocket();
        sZygoteSocket.connect(new LocalSocketAddress("zygote", android.net.LocalSocketAddress.Namespace.RESERVED));
        sZygoteInputStream = new DataInputStream(sZygoteSocket.getInputStream());
        sZygoteWriter = new BufferedWriter(new OutputStreamWriter(sZygoteSocket.getOutputStream()), 256);
        Log.i("Zygote", "Process: zygote socket opened");
        sPreviousZygoteOpenFailed = false;
        if(sZygoteSocket == null) {
            sPreviousZygoteOpenFailed = true;
            throw new ZygoteStartFailedEx("connect failed");
        } else {
            return;
        }
        ioexception;
        if(sZygoteSocket != null)
            try {
                sZygoteSocket.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception1) {
                Log.e("Process", "I/O exception on close after exception", ioexception1);
            }
        sZygoteSocket = null;
        j++;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final native boolean parseProcLine(byte abyte0[], int i, int j, int ai[], String as[], long al[], float af[]);

    public static final native boolean readProcFile(String s, int ai[], String as[], long al[], float af[]);

    public static final native void readProcLines(String s, String as[], long al[]);

    public static final native void sendSignal(int i, int j);

    public static final native void sendSignalQuiet(int i, int j);

    public static final native void setArgV0(String s);

    public static final native void setCanSelfBackground(boolean flag);

    public static final native int setGid(int i);

    public static final native boolean setOomAdj(int i, int j);

    public static final native void setProcessGroup(int i, int j) throws IllegalArgumentException, SecurityException;

    public static final native void setThreadGroup(int i, int j) throws IllegalArgumentException, SecurityException;

    public static final native void setThreadPriority(int i) throws IllegalArgumentException, SecurityException;

    public static final native void setThreadPriority(int i, int j) throws IllegalArgumentException, SecurityException;

    public static final native void setThreadScheduler(int i, int j, int k) throws IllegalArgumentException;

    public static final native int setUid(int i);

    public static final ProcessStartResult start(String s, String s1, int i, int j, int ai[], int k, int l, String as[]) {
        ProcessStartResult processstartresult;
        try {
            processstartresult = startViaZygote(s, s1, i, j, ai, k, l, as);
        }
        catch(ZygoteStartFailedEx zygotestartfailedex) {
            Log.e("Process", "Starting VM process through Zygote failed");
            throw new RuntimeException("Starting VM process through Zygote failed", zygotestartfailedex);
        }
        return processstartresult;
    }

    private static ProcessStartResult startViaZygote(String s, String s1, int i, int j, int ai[], int k, int l, String as[]) throws ZygoteStartFailedEx {
        android/os/Process;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList();
        arraylist.add("--runtime-init");
        arraylist.add((new StringBuilder()).append("--setuid=").append(i).toString());
        arraylist.add((new StringBuilder()).append("--setgid=").append(j).toString());
        if((k & 0x10) != 0)
            arraylist.add("--enable-jni-logging");
        if((k & 8) != 0)
            arraylist.add("--enable-safemode");
        if((k & 1) != 0)
            arraylist.add("--enable-debugger");
        if((k & 2) != 0)
            arraylist.add("--enable-checkjni");
        if((k & 4) != 0)
            arraylist.add("--enable-assert");
        arraylist.add((new StringBuilder()).append("--target-sdk-version=").append(l).toString());
        if(ai != null && ai.length > 0) {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("--setgroups=");
            int k1 = ai.length;
            for(int l1 = 0; l1 < k1; l1++) {
                if(l1 != 0)
                    stringbuilder.append(',');
                stringbuilder.append(ai[l1]);
            }

            arraylist.add(stringbuilder.toString());
        }
        if(s1 != null)
            arraylist.add((new StringBuilder()).append("--nice-name=").append(s1).toString());
        arraylist.add(s);
        if(as != null) {
            int i1 = as.length;
            for(int j1 = 0; j1 < i1; j1++)
                arraylist.add(as[j1]);

        }
        ProcessStartResult processstartresult = zygoteSendArgsAndGetResult(arraylist);
        return processstartresult;
    }

    public static final boolean supportsProcesses() {
        return true;
    }

    private static ProcessStartResult zygoteSendArgsAndGetResult(ArrayList arraylist) throws ZygoteStartFailedEx {
        openZygoteSocketIfNeeded();
        int i;
        int j;
        sZygoteWriter.write(Integer.toString(arraylist.size()));
        sZygoteWriter.newLine();
        i = arraylist.size();
        j = 0;
_L1:
        String s;
        if(j >= i)
            break MISSING_BLOCK_LABEL_116;
        s = (String)arraylist.get(j);
        if(s.indexOf('\n') >= 0)
            throw new ZygoteStartFailedEx("embedded newlines not allowed");
        break MISSING_BLOCK_LABEL_96;
        IOException ioexception;
        ioexception;
        ProcessStartResult processstartresult;
        try {
            if(sZygoteSocket != null)
                sZygoteSocket.close();
        }
        catch(IOException ioexception1) {
            Log.e("Process", "I/O exception on routine close", ioexception1);
        }
        sZygoteSocket = null;
        throw new ZygoteStartFailedEx(ioexception);
        sZygoteWriter.write(s);
        sZygoteWriter.newLine();
        j++;
          goto _L1
        sZygoteWriter.flush();
        processstartresult = new ProcessStartResult();
        processstartresult.pid = sZygoteInputStream.readInt();
        if(processstartresult.pid < 0)
            throw new ZygoteStartFailedEx("fork() failed");
        processstartresult.usingWrapper = sZygoteInputStream.readBoolean();
        return processstartresult;
    }

    public static final String ANDROID_SHARED_MEDIA = "com.android.process.media";
    public static final int BLUETOOTH_GID = 2000;
    public static final int DRM_UID = 1019;
    public static final int FIRST_APPLICATION_UID = 10000;
    public static final int FIRST_ISOLATED_UID = 0x182b8;
    public static final String GOOGLE_SHARED_APP_CONTENT = "com.google.process.content";
    public static final int LAST_APPLICATION_UID = 19999;
    public static final int LAST_ISOLATED_UID = 0x1869f;
    private static final String LOG_TAG = "Process";
    public static final int LOG_UID = 1007;
    public static final int MEDIA_RW_GID = 1023;
    public static final int MEDIA_UID = 1013;
    public static final int NFC_UID = 1027;
    public static final int PHONE_UID = 1001;
    public static final int PROC_COMBINE = 256;
    public static final int PROC_OUT_FLOAT = 16384;
    public static final int PROC_OUT_LONG = 8192;
    public static final int PROC_OUT_STRING = 4096;
    public static final int PROC_PARENS = 512;
    public static final int PROC_SPACE_TERM = 32;
    public static final int PROC_TAB_TERM = 9;
    public static final int PROC_TERM_MASK = 255;
    public static final int PROC_ZERO_TERM = 0;
    public static final int SCHED_BATCH = 3;
    public static final int SCHED_FIFO = 1;
    public static final int SCHED_IDLE = 5;
    public static final int SCHED_OTHER = 0;
    public static final int SCHED_RR = 2;
    public static final int SDCARD_RW_GID = 1015;
    public static final int SHELL_UID = 2000;
    public static final int SIGNAL_KILL = 9;
    public static final int SIGNAL_QUIT = 3;
    public static final int SIGNAL_USR1 = 10;
    public static final int SYSTEM_UID = 1000;
    public static final int THREAD_GROUP_AUDIO_APP = 3;
    public static final int THREAD_GROUP_AUDIO_SYS = 4;
    public static final int THREAD_GROUP_BG_NONINTERACTIVE = 0;
    public static final int THREAD_GROUP_DEFAULT = -1;
    private static final int THREAD_GROUP_FOREGROUND = 1;
    public static final int THREAD_GROUP_SYSTEM = 2;
    public static final int THREAD_PRIORITY_AUDIO = -16;
    public static final int THREAD_PRIORITY_BACKGROUND = 10;
    public static final int THREAD_PRIORITY_DEFAULT = 0;
    public static final int THREAD_PRIORITY_DISPLAY = -4;
    public static final int THREAD_PRIORITY_FOREGROUND = -2;
    public static final int THREAD_PRIORITY_LESS_FAVORABLE = 1;
    public static final int THREAD_PRIORITY_LOWEST = 19;
    public static final int THREAD_PRIORITY_MORE_FAVORABLE = -1;
    public static final int THREAD_PRIORITY_URGENT_AUDIO = -19;
    public static final int THREAD_PRIORITY_URGENT_DISPLAY = -8;
    public static final int VPN_UID = 1016;
    public static final int WIFI_UID = 1010;
    static final int ZYGOTE_RETRY_MILLIS = 500;
    private static final String ZYGOTE_SOCKET = "zygote";
    static boolean sPreviousZygoteOpenFailed;
    static DataInputStream sZygoteInputStream;
    static LocalSocket sZygoteSocket;
    static BufferedWriter sZygoteWriter;
}
