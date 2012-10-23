// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.net.Credentials;
import android.net.LocalSocket;
import android.os.Process;
import android.os.SystemProperties;
import android.util.Log;
import dalvik.system.PathClassLoader;
import dalvik.system.Zygote;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import libcore.io.*;

// Referenced classes of package com.android.internal.os:
//            ZygoteSecurityException, ZygoteInit, WrapperInit, RuntimeInit

class ZygoteConnection {
    static class Arguments {

        private void parseArgs(String as[]) throws IllegalArgumentException {
            int i = 0;
_L5:
            if(i >= as.length) goto _L2; else goto _L1
_L1:
            String s = as[i];
            if(!s.equals("--")) goto _L4; else goto _L3
_L3:
            i++;
_L2:
            if(runtimeInit && classpath != null) {
                throw new IllegalArgumentException("--runtime-init and -classpath are incompatible");
            } else {
                remainingArgs = new String[as.length - i];
                System.arraycopy(as, i, remainingArgs, 0, remainingArgs.length);
                return;
            }
_L4:
            if(s.startsWith("--setuid=")) {
                if(uidSpecified)
                    throw new IllegalArgumentException("Duplicate arg specified");
                uidSpecified = true;
                uid = Integer.parseInt(s.substring(1 + s.indexOf('=')));
            } else
            if(s.startsWith("--setgid=")) {
                if(gidSpecified)
                    throw new IllegalArgumentException("Duplicate arg specified");
                gidSpecified = true;
                gid = Integer.parseInt(s.substring(1 + s.indexOf('=')));
            } else
            if(s.startsWith("--target-sdk-version=")) {
                if(targetSdkVersionSpecified)
                    throw new IllegalArgumentException("Duplicate target-sdk-version specified");
                targetSdkVersionSpecified = true;
                targetSdkVersion = Integer.parseInt(s.substring(1 + s.indexOf('=')));
            } else
            if(s.equals("--enable-debugger"))
                debugFlags = 1 | debugFlags;
            else
            if(s.equals("--enable-safemode"))
                debugFlags = 8 | debugFlags;
            else
            if(s.equals("--enable-checkjni"))
                debugFlags = 2 | debugFlags;
            else
            if(s.equals("--enable-jni-logging"))
                debugFlags = 0x10 | debugFlags;
            else
            if(s.equals("--enable-assert"))
                debugFlags = 4 | debugFlags;
            else
            if(s.equals("--peer-wait"))
                peerWait = true;
            else
            if(s.equals("--runtime-init"))
                runtimeInit = true;
            else
            if(s.startsWith("--capabilities=")) {
                if(capabilitiesSpecified)
                    throw new IllegalArgumentException("Duplicate arg specified");
                capabilitiesSpecified = true;
                String as3[] = s.substring(1 + s.indexOf('=')).split(",", 2);
                if(as3.length == 1) {
                    effectiveCapabilities = Long.decode(as3[0]).longValue();
                    permittedCapabilities = effectiveCapabilities;
                } else {
                    permittedCapabilities = Long.decode(as3[0]).longValue();
                    effectiveCapabilities = Long.decode(as3[1]).longValue();
                }
            } else
            if(s.startsWith("--rlimit=")) {
                String as2[] = s.substring(1 + s.indexOf('=')).split(",");
                if(as2.length != 3)
                    throw new IllegalArgumentException("--rlimit= should have 3 comma-delimited ints");
                int ai[] = new int[as2.length];
                for(int k = 0; k < as2.length; k++)
                    ai[k] = Integer.parseInt(as2[k]);

                if(rlimits == null)
                    rlimits = new ArrayList();
                rlimits.add(ai);
            } else
            if(s.equals("-classpath")) {
                if(classpath != null)
                    throw new IllegalArgumentException("Duplicate arg specified");
                i++;
                try {
                    classpath = as[i];
                }
                catch(IndexOutOfBoundsException indexoutofboundsexception1) {
                    throw new IllegalArgumentException("-classpath requires argument");
                }
            } else
            if(s.startsWith("--setgroups=")) {
                if(gids != null)
                    throw new IllegalArgumentException("Duplicate arg specified");
                String as1[] = s.substring(1 + s.indexOf('=')).split(",");
                gids = new int[as1.length];
                int j = -1 + as1.length;
                while(j >= 0)  {
                    gids[j] = Integer.parseInt(as1[j]);
                    j--;
                }
            } else {
                if(!s.equals("--invoke-with"))
                    continue; /* Loop/switch isn't completed */
                if(invokeWith != null)
                    throw new IllegalArgumentException("Duplicate arg specified");
                i++;
                try {
                    invokeWith = as[i];
                }
                catch(IndexOutOfBoundsException indexoutofboundsexception) {
                    throw new IllegalArgumentException("--invoke-with requires argument");
                }
            }
_L7:
            i++;
              goto _L5
            if(!s.startsWith("--nice-name=")) goto _L2; else goto _L6
_L6:
            if(niceName != null)
                throw new IllegalArgumentException("Duplicate arg specified");
            niceName = s.substring(1 + s.indexOf('='));
              goto _L7
        }

        boolean capabilitiesSpecified;
        String classpath;
        int debugFlags;
        long effectiveCapabilities;
        int gid;
        boolean gidSpecified;
        int gids[];
        String invokeWith;
        String niceName;
        boolean peerWait;
        long permittedCapabilities;
        String remainingArgs[];
        ArrayList rlimits;
        boolean runtimeInit;
        int targetSdkVersion;
        boolean targetSdkVersionSpecified;
        int uid;
        boolean uidSpecified;

        Arguments(String as[]) throws IllegalArgumentException {
            uid = 0;
            gid = 0;
            parseArgs(as);
        }
    }


    ZygoteConnection(LocalSocket localsocket) throws IOException {
        mSocket = localsocket;
        mSocketOutStream = new DataOutputStream(localsocket.getOutputStream());
        mSocketReader = new BufferedReader(new InputStreamReader(localsocket.getInputStream()), 256);
        mSocket.setSoTimeout(1000);
        try {
            peer = mSocket.getPeerCredentials();
            return;
        }
        catch(IOException ioexception) {
            Log.e("Zygote", "Cannot read peer credentials", ioexception);
            throw ioexception;
        }
    }

    private static void applyCapabilitiesSecurityPolicy(Arguments arguments, Credentials credentials) throws ZygoteSecurityException {
        if((arguments.permittedCapabilities != 0L || arguments.effectiveCapabilities != 0L) && credentials.getUid() != 0) {
            long l;
            try {
                l = ZygoteInit.capgetPermitted(credentials.getPid());
            }
            catch(IOException ioexception) {
                throw new ZygoteSecurityException("Error retrieving peer's capabilities.");
            }
            if(((-1L ^ arguments.permittedCapabilities) & arguments.effectiveCapabilities) != 0L)
                throw new ZygoteSecurityException("Effective capabilities cannot be superset of  permitted capabilities");
            if((~l & arguments.permittedCapabilities) != 0L)
                throw new ZygoteSecurityException("Peer specified unpermitted capabilities");
        }
    }

    public static void applyDebuggerSystemProperty(Arguments arguments) {
        if("1".equals(SystemProperties.get("ro.debuggable")))
            arguments.debugFlags = 1 | arguments.debugFlags;
    }

    private static void applyInvokeWithSecurityPolicy(Arguments arguments, Credentials credentials) throws ZygoteSecurityException {
        int i = credentials.getUid();
        if(arguments.invokeWith != null && i != 0)
            throw new ZygoteSecurityException("Peer is not permitted to specify an explicit invoke-with wrapper command");
        else
            return;
    }

    public static void applyInvokeWithSystemProperty(Arguments arguments) {
        if(arguments.invokeWith == null && arguments.niceName != null && arguments.niceName != null) {
            String s = (new StringBuilder()).append("wrap.").append(arguments.niceName).toString();
            if(s.length() > 31)
                s = s.substring(0, 31);
            arguments.invokeWith = SystemProperties.get(s);
            if(arguments.invokeWith != null && arguments.invokeWith.length() == 0)
                arguments.invokeWith = null;
        }
    }

    private static void applyRlimitSecurityPolicy(Arguments arguments, Credentials credentials) throws ZygoteSecurityException {
        int i = credentials.getUid();
        if(i != 0 && i != 1000 && arguments.rlimits != null)
            throw new ZygoteSecurityException("This UID may not specify rlimits.");
        else
            return;
    }

    private static void applyUidSecurityPolicy(Arguments arguments, Credentials credentials) throws ZygoteSecurityException {
        int i = credentials.getUid();
        if(i != 0) goto _L2; else goto _L1
_L1:
        if(!arguments.uidSpecified) {
            arguments.uid = credentials.getUid();
            arguments.uidSpecified = true;
        }
        if(!arguments.gidSpecified) {
            arguments.gid = credentials.getGid();
            arguments.gidSpecified = true;
        }
        return;
_L2:
        if(i != 1000)
            continue; /* Loop/switch isn't completed */
        String s = SystemProperties.get("ro.factorytest");
        boolean flag;
        if(!s.equals("1") && !s.equals("2"))
            flag = true;
        else
            flag = false;
        if(!flag || !arguments.uidSpecified || arguments.uid >= 1000) goto _L1; else goto _L3
_L3:
        throw new ZygoteSecurityException("System UID may not launch process with UID < 1000");
        if(!arguments.uidSpecified && !arguments.gidSpecified && arguments.gids == null) goto _L1; else goto _L4
_L4:
        throw new ZygoteSecurityException("App UIDs may not specify uid's or gid's");
    }

    private void handleChildProc(Arguments arguments, FileDescriptor afiledescriptor[], FileDescriptor filedescriptor, PrintStream printstream) throws ZygoteInit.MethodAndArgsCaller {
        int i;
        int j;
        if(arguments.peerWait) {
            try {
                ZygoteInit.setCloseOnExec(mSocket.getFileDescriptor(), true);
                sPeerWaitSocket = mSocket;
            }
            catch(IOException ioexception1) {
                Log.e("Zygote", "Zygote Child: error setting peer wait socket to be close-on-exec", ioexception1);
            }
        } else {
            closeSocket();
            ZygoteInit.closeServerSocket();
        }
        if(afiledescriptor == null)
            break MISSING_BLOCK_LABEL_99;
        ZygoteInit.reopenStdio(afiledescriptor[0], afiledescriptor[1], afiledescriptor[2]);
        i = afiledescriptor.length;
        j = 0;
_L1:
        if(j >= i)
            break MISSING_BLOCK_LABEL_94;
        IoUtils.closeQuietly(afiledescriptor[j]);
        j++;
          goto _L1
        try {
            printstream = System.err;
        }
        catch(IOException ioexception) {
            Log.e("Zygote", "Error reopening stdio", ioexception);
        }
        if(arguments.niceName != null)
            Process.setArgV0(arguments.niceName);
        if(!arguments.runtimeInit) goto _L3; else goto _L2
_L2:
        if(arguments.invokeWith != null)
            WrapperInit.execApplication(arguments.invokeWith, arguments.niceName, arguments.targetSdkVersion, filedescriptor, arguments.remainingArgs);
        else
            RuntimeInit.zygoteInit(arguments.targetSdkVersion, arguments.remainingArgs);
_L5:
        return;
_L3:
        String s = arguments.remainingArgs[0];
        String as[] = new String[-1 + arguments.remainingArgs.length];
        System.arraycopy(arguments.remainingArgs, 1, as, 0, as.length);
        ArrayIndexOutOfBoundsException arrayindexoutofboundsexception;
        if(arguments.invokeWith != null) {
            WrapperInit.execStandalone(arguments.invokeWith, arguments.classpath, s, as);
        } else {
            Object obj;
            if(arguments.classpath != null)
                obj = new PathClassLoader(arguments.classpath, ClassLoader.getSystemClassLoader());
            else
                obj = ClassLoader.getSystemClassLoader();
            try {
                ZygoteInit.invokeStaticMain(((ClassLoader) (obj)), s, as);
            }
            catch(RuntimeException runtimeexception) {
                logAndPrintError(printstream, "Error starting.", runtimeexception);
            }
        }
        continue; /* Loop/switch isn't completed */
        arrayindexoutofboundsexception;
        logAndPrintError(printstream, "Missing required class name argument", null);
        if(true) goto _L5; else goto _L4
_L4:
    }

    private boolean handleParentProc(int i, FileDescriptor afiledescriptor[], FileDescriptor filedescriptor, Arguments arguments) {
        boolean flag;
        DataInputStream datainputstream;
        int j;
        if(i > 0)
            setChildPgid(i);
        if(afiledescriptor != null) {
            int i1 = afiledescriptor.length;
            for(int j1 = 0; j1 < i1; j1++)
                IoUtils.closeQuietly(afiledescriptor[j1]);

        }
        flag = false;
        if(filedescriptor == null || i <= 0)
            break MISSING_BLOCK_LABEL_192;
        datainputstream = new DataInputStream(new FileInputStream(filedescriptor));
        j = -1;
        int l = datainputstream.readInt();
        j = l;
        IOException ioexception;
        boolean flag1;
        IOException ioexception1;
        Exception exception;
        IOException ioexception3;
        IOException ioexception4;
        int k;
        try {
            datainputstream.close();
        }
        catch(IOException ioexception5) { }
        if(j <= 0)
            break MISSING_BLOCK_LABEL_192;
        for(k = j; k > 0 && k != i; k = Process.getParentPid(k));
        break; /* Loop/switch isn't completed */
        ioexception3;
        Log.w("Zygote", "Error reading pid from wrapped process, child may have died", ioexception3);
        try {
            datainputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch(IOException ioexception4) { }
        if(true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_88;
        exception;
        try {
            datainputstream.close();
        }
        catch(IOException ioexception2) { }
        throw exception;
_L1:
        if(k > 0) {
            Log.i("Zygote", (new StringBuilder()).append("Wrapped process has pid ").append(j).toString());
            i = j;
            flag = true;
        } else {
            Log.w("Zygote", (new StringBuilder()).append("Wrapped process reported a pid that is not a child of the process that we forked: childPid=").append(i).append(" innerPid=").append(j).toString());
        }
label0:
        {
            try {
                mSocketOutStream.writeInt(i);
                mSocketOutStream.writeBoolean(flag);
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception) {
                Log.e("Zygote", "Error reading from command socket", ioexception);
                flag1 = true;
                if(false)
                    ;
                else
                    break label0;
            }
            if(arguments.peerWait) {
                try {
                    mSocket.close();
                }
                // Misplaced declaration of an exception variable
                catch(IOException ioexception1) {
                    Log.e("Zygote", "Zygote: error closing sockets", ioexception1);
                }
                flag1 = true;
            } else {
                flag1 = false;
            }
        }
        return flag1;
    }

    private static void logAndPrintError(PrintStream printstream, String s, Throwable throwable) {
        Log.e("Zygote", s, throwable);
        if(printstream != null) {
            StringBuilder stringbuilder = (new StringBuilder()).append(s);
            if(throwable == null)
                throwable = "";
            printstream.println(stringbuilder.append(throwable).toString());
        }
    }

    private String[] readArgumentList() throws IOException {
        String as[];
label0:
        {
            int i;
            try {
                String s = mSocketReader.readLine();
                if(s == null) {
                    as = null;
                    break label0;
                }
                i = Integer.parseInt(s);
            }
            catch(NumberFormatException numberformatexception) {
                Log.e("Zygote", "invalid Zygote wire format: non-int at argc");
                throw new IOException("invalid wire format");
            }
            if(i > 1024)
                throw new IOException("max arg count exceeded");
            as = new String[i];
            for(int j = 0; j < i; j++) {
                as[j] = mSocketReader.readLine();
                if(as[j] == null)
                    throw new IOException("truncated request");
            }

        }
        return as;
    }

    private void setChildPgid(int i) {
        ZygoteInit.setpgid(i, ZygoteInit.getpgid(peer.getPid()));
_L1:
        return;
        IOException ioexception;
        ioexception;
        Log.i("Zygote", "Zygote: setpgid failed. This is normal if peer is not in our session");
          goto _L1
    }

    void closeSocket() {
        mSocket.close();
_L1:
        return;
        IOException ioexception;
        ioexception;
        Log.e("Zygote", "Exception while closing command socket in parent", ioexception);
          goto _L1
    }

    FileDescriptor getFileDesciptor() {
        return mSocket.getFileDescriptor();
    }

    void run() throws ZygoteInit.MethodAndArgsCaller {
        int i = 10;
        do
            if(i <= 0) {
                ZygoteInit.gc();
                i = 10;
            } else {
                i--;
            }
        while(!runOnce());
    }

    boolean runOnce() throws ZygoteInit.MethodAndArgsCaller {
        Arguments arguments = null;
        String as[];
        FileDescriptor afiledescriptor[];
        as = readArgumentList();
        afiledescriptor = mSocket.getAncillaryFileDescriptors();
        if(as != null) goto _L2; else goto _L1
_L1:
        boolean flag;
        closeSocket();
        flag = true;
_L3:
        return flag;
        IOException ioexception;
        ioexception;
        Log.w("Zygote", (new StringBuilder()).append("IOException on command socket ").append(ioexception.getMessage()).toString());
        closeSocket();
        flag = true;
          goto _L3
_L2:
        PrintStream printstream;
        int i;
        FileDescriptor filedescriptor;
        FileDescriptor filedescriptor1;
        printstream = null;
        if(afiledescriptor != null && afiledescriptor.length >= 3)
            printstream = new PrintStream(new FileOutputStream(afiledescriptor[2]));
        i = -1;
        filedescriptor = null;
        filedescriptor1 = null;
        Arguments arguments1 = new Arguments(as);
        int j;
        applyUidSecurityPolicy(arguments1, peer);
        applyRlimitSecurityPolicy(arguments1, peer);
        applyCapabilitiesSecurityPolicy(arguments1, peer);
        applyInvokeWithSecurityPolicy(arguments1, peer);
        applyDebuggerSystemProperty(arguments1);
        applyInvokeWithSystemProperty(arguments1);
        int ai[][] = (int[][])null;
        if(arguments1.rlimits != null)
            ai = (int[][])arguments1.rlimits.toArray(intArray2d);
        if(arguments1.runtimeInit && arguments1.invokeWith != null) {
            FileDescriptor afiledescriptor1[] = Libcore.os.pipe();
            filedescriptor = afiledescriptor1[1];
            filedescriptor1 = afiledescriptor1[0];
            ZygoteInit.setCloseOnExec(filedescriptor1, true);
        }
        j = Zygote.forkAndSpecialize(arguments1.uid, arguments1.gid, arguments1.gids, arguments1.debugFlags, ai);
        i = j;
        arguments = arguments1;
_L6:
        if(i != 0) goto _L5; else goto _L4
_L4:
        IoUtils.closeQuietly(filedescriptor1);
        filedescriptor1 = null;
        handleChildProc(arguments, afiledescriptor, filedescriptor, printstream);
        flag = true;
        IoUtils.closeQuietly(filedescriptor);
        IoUtils.closeQuietly(null);
          goto _L3
        IOException ioexception1;
        ioexception1;
_L10:
        logAndPrintError(printstream, "Exception creating pipe", ioexception1);
          goto _L6
        ErrnoException errnoexception;
        errnoexception;
_L9:
        logAndPrintError(printstream, "Exception creating pipe", errnoexception);
          goto _L6
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
_L8:
        logAndPrintError(printstream, "Invalid zygote arguments", illegalargumentexception);
          goto _L6
        ZygoteSecurityException zygotesecurityexception;
        zygotesecurityexception;
_L7:
        logAndPrintError(printstream, "Zygote security policy prevents request: ", zygotesecurityexception);
          goto _L6
_L5:
        boolean flag1;
        IoUtils.closeQuietly(filedescriptor);
        filedescriptor = null;
        flag1 = handleParentProc(i, afiledescriptor, filedescriptor1, arguments);
        flag = flag1;
        IoUtils.closeQuietly(null);
        IoUtils.closeQuietly(filedescriptor1);
          goto _L3
        Exception exception;
        exception;
        IoUtils.closeQuietly(filedescriptor);
        IoUtils.closeQuietly(filedescriptor1);
        throw exception;
        zygotesecurityexception;
        arguments = arguments1;
          goto _L7
        illegalargumentexception;
        arguments = arguments1;
          goto _L8
        errnoexception;
        arguments = arguments1;
          goto _L9
        ioexception1;
        arguments = arguments1;
          goto _L10
    }

    private static final int CONNECTION_TIMEOUT_MILLIS = 1000;
    private static final int MAX_ZYGOTE_ARGC = 1024;
    private static final String TAG = "Zygote";
    private static final int intArray2d[][];
    private static LocalSocket sPeerWaitSocket = null;
    private final LocalSocket mSocket;
    private final DataOutputStream mSocketOutStream;
    private final BufferedReader mSocketReader;
    private final Credentials peer;

    static  {
        int ai[] = new int[2];
        ai[0] = 0;
        ai[1] = 0;
        intArray2d = (int[][])Array.newInstance(Integer.TYPE, ai);
    }
}
