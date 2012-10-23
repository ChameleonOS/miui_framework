// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.LocalServerSocket;
import android.os.*;
import android.util.EventLog;
import android.util.Log;
import dalvik.system.VMRuntime;
import dalvik.system.Zygote;
import java.io.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import libcore.io.IoUtils;

// Referenced classes of package com.android.internal.os:
//            ZygoteConnection, WrapperInit, RuntimeInit, SamplingProfilerIntegration

public class ZygoteInit {
    public static class MethodAndArgsCaller extends Exception
        implements Runnable {

        public void run() {
            try {
                Method method = mMethod;
                Object aobj[] = new Object[1];
                aobj[0] = mArgs;
                method.invoke(null, aobj);
                return;
            }
            catch(IllegalAccessException illegalaccessexception) {
                throw new RuntimeException(illegalaccessexception);
            }
            catch(InvocationTargetException invocationtargetexception) {
                Throwable throwable = invocationtargetexception.getCause();
                if(throwable instanceof RuntimeException)
                    throw (RuntimeException)throwable;
                if(throwable instanceof Error)
                    throw (Error)throwable;
                else
                    throw new RuntimeException(invocationtargetexception);
            }
        }

        private final String mArgs[];
        private final Method mMethod;

        public MethodAndArgsCaller(Method method, String as[]) {
            mMethod = method;
            mArgs = as;
        }
    }


    private ZygoteInit() {
    }

    private static ZygoteConnection acceptCommandPeer() {
        ZygoteConnection zygoteconnection;
        try {
            zygoteconnection = new ZygoteConnection(sServerSocket.accept());
        }
        catch(IOException ioexception) {
            throw new RuntimeException("IOException during accept()", ioexception);
        }
        return zygoteconnection;
    }

    static native long capgetPermitted(int i) throws IOException;

    static void closeServerSocket() {
        try {
            if(sServerSocket != null)
                sServerSocket.close();
        }
        catch(IOException ioexception) {
            Log.e("Zygote", "Zygote:  error closing sockets", ioexception);
        }
        sServerSocket = null;
    }

    static native FileDescriptor createFileDescriptor(int i) throws IOException;

    static void gc() {
        VMRuntime vmruntime = VMRuntime.getRuntime();
        System.gc();
        vmruntime.runFinalizationSync();
        System.gc();
        vmruntime.runFinalizationSync();
        System.gc();
        vmruntime.runFinalizationSync();
    }

    static native int getpgid(int i) throws IOException;

    private static void handleSystemServerProcess(ZygoteConnection.Arguments arguments) throws MethodAndArgsCaller {
        closeServerSocket();
        FileUtils.setUMask(63);
        if(arguments.niceName != null)
            Process.setArgV0(arguments.niceName);
        if(arguments.invokeWith != null)
            WrapperInit.execApplication(arguments.invokeWith, arguments.niceName, arguments.targetSdkVersion, null, arguments.remainingArgs);
        else
            RuntimeInit.zygoteInit(arguments.targetSdkVersion, arguments.remainingArgs);
    }

    static void invokeStaticMain(ClassLoader classloader, String s, String as[]) throws MethodAndArgsCaller {
        Class class1;
        Method method;
        int i;
        try {
            class1 = classloader.loadClass(s);
        }
        catch(ClassNotFoundException classnotfoundexception) {
            throw new RuntimeException((new StringBuilder()).append("Missing class when invoking static main ").append(s).toString(), classnotfoundexception);
        }
        try {
            Class aclass[] = new Class[1];
            aclass[0] = [Ljava/lang/String;;
            method = class1.getMethod("main", aclass);
        }
        catch(NoSuchMethodException nosuchmethodexception) {
            throw new RuntimeException((new StringBuilder()).append("Missing static main on ").append(s).toString(), nosuchmethodexception);
        }
        catch(SecurityException securityexception) {
            throw new RuntimeException((new StringBuilder()).append("Problem getting static main on ").append(s).toString(), securityexception);
        }
        i = method.getModifiers();
        if(!Modifier.isStatic(i) || !Modifier.isPublic(i))
            throw new RuntimeException((new StringBuilder()).append("Main method is not public and static on ").append(s).toString());
        else
            throw new MethodAndArgsCaller(method, as);
    }

    public static void main(String args[]) {
        SamplingProfilerIntegration.start();
        registerZygoteSocket();
        EventLog.writeEvent(3020, SystemClock.uptimeMillis());
        preload();
        EventLog.writeEvent(3030, SystemClock.uptimeMillis());
        SamplingProfilerIntegration.writeZygoteSnapshot();
        gc();
        if(args.length != 2)
            throw new RuntimeException((new StringBuilder()).append(args[0]).append(" <\"start-system-server\"|\"\" for startSystemServer>").toString());
          goto _L1
        MethodAndArgsCaller methodandargscaller;
        methodandargscaller;
        methodandargscaller.run();
_L4:
        return;
_L1:
        if(!args[1].equals("start-system-server")) goto _L3; else goto _L2
_L2:
        startSystemServer();
_L6:
        Log.i("Zygote", "Accepting command socket connections");
        runSelectLoopMode();
        closeServerSocket();
          goto _L4
        RuntimeException runtimeexception;
        runtimeexception;
        Log.e("Zygote", "Zygote died with exception", runtimeexception);
        closeServerSocket();
        throw runtimeexception;
_L3:
        if(args[1].equals("")) goto _L6; else goto _L5
_L5:
        throw new RuntimeException((new StringBuilder()).append(args[0]).append(" <\"start-system-server\"|\"\" for startSystemServer>").toString());
          goto _L4
    }

    static void preload() {
        preloadClasses();
        preloadResources();
    }

    private static void preloadClasses() {
        VMRuntime vmruntime;
        java.io.InputStream inputstream;
        vmruntime = VMRuntime.getRuntime();
        inputstream = ClassLoader.getSystemClassLoader().getResourceAsStream("preloaded-classes");
        if(inputstream != null) goto _L2; else goto _L1
_L1:
        Log.e("Zygote", "Couldn't find preloaded-classes.");
_L5:
        return;
_L2:
        long l;
        float f;
        Log.i("Zygote", "Preloading classes...");
        l = SystemClock.uptimeMillis();
        setEffectiveGroup(9999);
        setEffectiveUser(9999);
        f = vmruntime.getTargetHeapUtilization();
        vmruntime.setTargetHeapUtilization(0.8F);
        System.gc();
        vmruntime.runFinalizationSync();
        Debug.startAllocCounting();
        BufferedReader bufferedreader;
        int i;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream), 256);
        i = 0;
_L3:
        String s1;
        boolean flag;
        do {
            do {
                String s = bufferedreader.readLine();
                if(s == null)
                    break MISSING_BLOCK_LABEL_346;
                s1 = s.trim();
            } while(s1.startsWith("#"));
            flag = s1.equals("");
        } while(flag);
        Class.forName(s1);
        if(Debug.getGlobalAllocSize() > 50000) {
            System.gc();
            vmruntime.runFinalizationSync();
            Debug.resetGlobalAllocSize();
        }
        i++;
          goto _L3
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        Log.w("Zygote", (new StringBuilder()).append("Class not found for preloading: ").append(s1).toString());
          goto _L3
        IOException ioexception;
        ioexception;
        Log.e("Zygote", "Error reading preloaded-classes.", ioexception);
        IoUtils.closeQuietly(inputstream);
        vmruntime.setTargetHeapUtilization(f);
        Debug.stopAllocCounting();
        setEffectiveUser(0);
        setEffectiveGroup(0);
        continue; /* Loop/switch isn't completed */
        Throwable throwable;
        throwable;
        Log.e("Zygote", (new StringBuilder()).append("Error preloading ").append(s1).append(".").toString(), throwable);
        if(throwable instanceof Error)
            throw (Error)throwable;
        break MISSING_BLOCK_LABEL_322;
        Exception exception;
        exception;
        IoUtils.closeQuietly(inputstream);
        vmruntime.setTargetHeapUtilization(f);
        Debug.stopAllocCounting();
        setEffectiveUser(0);
        setEffectiveGroup(0);
        throw exception;
        if(throwable instanceof RuntimeException)
            throw (RuntimeException)throwable;
        else
            throw new RuntimeException(throwable);
        Log.i("Zygote", (new StringBuilder()).append("...preloaded ").append(i).append(" classes in ").append(SystemClock.uptimeMillis() - l).append("ms.").toString());
        IoUtils.closeQuietly(inputstream);
        vmruntime.setTargetHeapUtilization(f);
        Debug.stopAllocCounting();
        setEffectiveUser(0);
        setEffectiveGroup(0);
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static int preloadColorStateLists(VMRuntime vmruntime, TypedArray typedarray) {
        int i = typedarray.length();
        for(int j = 0; j < i; j++) {
            if(Debug.getGlobalAllocSize() > 50000) {
                System.gc();
                vmruntime.runFinalizationSync();
                Debug.resetGlobalAllocSize();
            }
            int k = typedarray.getResourceId(j, 0);
            if(k != 0)
                mResources.getColorStateList(k);
        }

        return i;
    }

    private static int preloadDrawables(VMRuntime vmruntime, TypedArray typedarray) {
        int i = typedarray.length();
        for(int j = 0; j < i; j++) {
            if(Debug.getGlobalAllocSize() > 50000) {
                System.gc();
                vmruntime.runFinalizationSync();
                Debug.resetGlobalAllocSize();
            }
            int k = typedarray.getResourceId(j, 0);
            if(k != 0 && (0xbfffffff & mResources.getDrawable(k).getChangingConfigurations()) != 0)
                Log.w("Zygote", (new StringBuilder()).append("Preloaded drawable resource #0x").append(Integer.toHexString(k)).append(" (").append(typedarray.getString(j)).append(") that varies with configuration!!").toString());
        }

        return i;
    }

    private static void preloadResources() {
        VMRuntime vmruntime;
        vmruntime = VMRuntime.getRuntime();
        Debug.startAllocCounting();
        System.gc();
        vmruntime.runFinalizationSync();
        mResources = Resources.getSystem();
        mResources.startPreloading();
        Log.i("Zygote", "Preloading resources...");
        long l = SystemClock.uptimeMillis();
        TypedArray typedarray = mResources.obtainTypedArray(0x1070005);
        int i = preloadDrawables(vmruntime, typedarray);
        typedarray.recycle();
        Log.i("Zygote", (new StringBuilder()).append("...preloaded ").append(i).append(" resources in ").append(SystemClock.uptimeMillis() - l).append("ms.").toString());
        long l1 = SystemClock.uptimeMillis();
        TypedArray typedarray1 = mResources.obtainTypedArray(0x1070006);
        int j = preloadColorStateLists(vmruntime, typedarray1);
        typedarray1.recycle();
        Log.i("Zygote", (new StringBuilder()).append("...preloaded ").append(j).append(" resources in ").append(SystemClock.uptimeMillis() - l1).append("ms.").toString());
        mResources.finishPreloading();
        Debug.stopAllocCounting();
_L2:
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("Zygote", "Failure preloading resources", runtimeexception);
        Debug.stopAllocCounting();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        Debug.stopAllocCounting();
        throw exception;
    }

    private static void registerZygoteSocket() {
        int i;
        if(sServerSocket != null)
            break MISSING_BLOCK_LABEL_29;
        try {
            i = Integer.parseInt(System.getenv("ANDROID_SOCKET_zygote"));
        }
        catch(RuntimeException runtimeexception) {
            throw new RuntimeException("ANDROID_SOCKET_zygote unset or invalid", runtimeexception);
        }
        sServerSocket = new LocalServerSocket(createFileDescriptor(i));
        return;
        IOException ioexception;
        ioexception;
        throw new RuntimeException((new StringBuilder()).append("Error binding to local socket '").append(i).append("'").toString(), ioexception);
    }

    static native void reopenStdio(FileDescriptor filedescriptor, FileDescriptor filedescriptor1, FileDescriptor filedescriptor2) throws IOException;

    private static void runForkMode() throws MethodAndArgsCaller {
_L4:
        ZygoteConnection zygoteconnection;
        int i;
        zygoteconnection = acceptCommandPeer();
        i = Zygote.fork();
        if(i != 0)
            break MISSING_BLOCK_LABEL_52;
        sServerSocket.close();
        sServerSocket = null;
_L2:
        zygoteconnection.run();
        return;
        IOException ioexception;
        ioexception;
        Log.e("Zygote", "Zygote Child: error closing sockets", ioexception);
        sServerSocket = null;
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        sServerSocket = null;
        throw exception;
        if(i > 0)
            zygoteconnection.closeSocket();
        else
            throw new RuntimeException("Error invoking fork()");
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static void runSelectLoopMode() throws MethodAndArgsCaller {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        FileDescriptor afiledescriptor[] = new FileDescriptor[4];
        arraylist.add(sServerSocket.getFileDescriptor());
        arraylist1.add(null);
        int i = 10;
        do {
            int j;
            if(i <= 0) {
                gc();
                i = 10;
            } else {
                i--;
            }
            try {
                afiledescriptor = (FileDescriptor[])arraylist.toArray(afiledescriptor);
                j = selectReadable(afiledescriptor);
            }
            catch(IOException ioexception) {
                throw new RuntimeException("Error in select()", ioexception);
            }
            if(j < 0)
                throw new RuntimeException("Error in select()");
            if(j == 0) {
                ZygoteConnection zygoteconnection = acceptCommandPeer();
                arraylist1.add(zygoteconnection);
                arraylist.add(zygoteconnection.getFileDesciptor());
            } else
            if(((ZygoteConnection)arraylist1.get(j)).runOnce()) {
                arraylist1.remove(j);
                arraylist.remove(j);
            }
        } while(true);
    }

    static native int selectReadable(FileDescriptor afiledescriptor[]) throws IOException;

    static native void setCapabilities(long l, long l1) throws IOException;

    static native void setCloseOnExec(FileDescriptor filedescriptor, boolean flag) throws IOException;

    private static void setEffectiveGroup(int i) {
        int j = setregid(0, i);
        if(j != 0)
            Log.e("Zygote", (new StringBuilder()).append("setregid() failed. errno: ").append(j).toString());
    }

    private static void setEffectiveUser(int i) {
        int j = setreuid(0, i);
        if(j != 0)
            Log.e("Zygote", (new StringBuilder()).append("setreuid() failed. errno: ").append(j).toString());
    }

    static native int setpgid(int i, int j);

    static native int setregid(int i, int j);

    static native int setreuid(int i, int j);

    private static boolean startSystemServer() throws MethodAndArgsCaller, RuntimeException {
        String as[];
        as = new String[7];
        as[0] = "--setuid=1000";
        as[1] = "--setgid=1000";
        as[2] = "--setgroups=1001,1002,1003,1004,1005,1006,1007,1008,1009,1010,1018,3001,3002,3003,3006,3007";
        as[3] = "--capabilities=130104352,130104352";
        as[4] = "--runtime-init";
        as[5] = "--nice-name=system_server";
        as[6] = "com.android.server.SystemServer";
        ZygoteConnection.Arguments arguments = new ZygoteConnection.Arguments(as);
        int i;
        ZygoteConnection.applyDebuggerSystemProperty(arguments);
        ZygoteConnection.applyInvokeWithSystemProperty(arguments);
        i = Zygote.forkSystemServer(arguments.uid, arguments.gid, arguments.gids, arguments.debugFlags, (int[][])null, arguments.permittedCapabilities, arguments.effectiveCapabilities);
        if(i == 0)
            handleSystemServerProcess(arguments);
        return true;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
_L2:
        throw new RuntimeException(illegalargumentexception);
        illegalargumentexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final String ANDROID_SOCKET_ENV = "ANDROID_SOCKET_zygote";
    static final int GC_LOOP_COUNT = 10;
    private static final int LOG_BOOT_PROGRESS_PRELOAD_END = 3030;
    private static final int LOG_BOOT_PROGRESS_PRELOAD_START = 3020;
    private static final String PRELOADED_CLASSES = "preloaded-classes";
    private static final int PRELOAD_GC_THRESHOLD = 50000;
    private static final boolean PRELOAD_RESOURCES = true;
    private static final int ROOT_GID = 0;
    private static final int ROOT_UID = 0;
    private static final String TAG = "Zygote";
    private static final int UNPRIVILEGED_GID = 9999;
    private static final int UNPRIVILEGED_UID = 9999;
    public static final String USAGE_STRING = " <\"start-system-server\"|\"\" for startSystemServer>";
    private static final boolean ZYGOTE_FORK_MODE;
    private static Resources mResources;
    private static LocalServerSocket sServerSocket;
}
