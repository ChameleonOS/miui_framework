// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.ddm.DdmRegister;
import android.os.*;
import android.util.Slog;
import com.android.internal.logging.AndroidConfig;
import com.android.server.NetworkManagementSocketTagger;
import dalvik.system.VMRuntime;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.TimeZone;
import java.util.logging.LogManager;
import org.apache.harmony.luni.internal.util.TimezoneGetter;

// Referenced classes of package com.android.internal.os:
//            AndroidPrintStream

public class RuntimeInit {
    static class Arguments {

        private void parseArgs(String as[]) throws IllegalArgumentException {
            int i = 0;
_L7:
            if(i >= as.length) goto _L2; else goto _L1
_L1:
            String s = as[i];
            if(!s.equals("--")) goto _L4; else goto _L3
_L3:
            i++;
_L2:
            if(i == as.length) {
                throw new IllegalArgumentException("Missing classname argument to RuntimeInit!");
            } else {
                int j = i + 1;
                startClass = as[i];
                startArgs = new String[as.length - j];
                System.arraycopy(as, j, startArgs, 0, startArgs.length);
                return;
            }
_L4:
            if(!s.startsWith("--")) goto _L2; else goto _L5
_L5:
            i++;
            if(true) goto _L7; else goto _L6
_L6:
        }

        String startArgs[];
        String startClass;

        Arguments(String as[]) throws IllegalArgumentException {
            parseArgs(as);
        }
    }

    private static class UncaughtHandler
        implements Thread.UncaughtExceptionHandler {

        public void uncaughtException(Thread thread, Throwable throwable) {
            boolean flag = RuntimeInit.mCrashing;
            if(!flag) goto _L2; else goto _L1
_L1:
            Process.killProcess(Process.myPid());
            System.exit(10);
_L8:
            return;
_L2:
            RuntimeInit.mCrashing = true;
            if(RuntimeInit.mApplicationObject != null) goto _L4; else goto _L3
_L3:
            Slog.e("AndroidRuntime", (new StringBuilder()).append("*** FATAL EXCEPTION IN SYSTEM PROCESS: ").append(thread.getName()).toString(), throwable);
_L6:
            ActivityManagerNative.getDefault().handleApplicationCrash(RuntimeInit.mApplicationObject, new android.app.ApplicationErrorReport.CrashInfo(throwable));
            Process.killProcess(Process.myPid());
            System.exit(10);
              goto _L5
_L4:
            Slog.e("AndroidRuntime", (new StringBuilder()).append("FATAL EXCEPTION: ").append(thread.getName()).toString(), throwable);
              goto _L6
            Throwable throwable1;
            throwable1;
            Exception exception;
            try {
                Slog.e("AndroidRuntime", "Error reporting crash", throwable1);
            }
            catch(Throwable throwable2) { }
            finally {
                Process.killProcess(Process.myPid());
            }
            Process.killProcess(Process.myPid());
            System.exit(10);
_L5:
            if(true) goto _L8; else goto _L7
_L7:
            System.exit(10);
            throw exception;
        }

        private UncaughtHandler() {
        }

    }

    static class Injector {

        static String appendMiuiVersion(StringBuilder stringbuilder, String s) {
            String s1 = android.os.Build.VERSION.INCREMENTAL;
            if(s1.length() > 0) {
                stringbuilder.append(" MIUI/");
                stringbuilder.append(s1);
            }
            return "";
        }

        Injector() {
        }
    }


    public RuntimeInit() {
    }

    private static void applicationInit(int i, String as[]) throws ZygoteInit.MethodAndArgsCaller {
        nativeSetExitWithoutCleanup(true);
        VMRuntime.getRuntime().setTargetHeapUtilization(0.75F);
        VMRuntime.getRuntime().setTargetSdkVersion(i);
        Arguments arguments = new Arguments(as);
        invokeStaticMain(arguments.startClass, arguments.startArgs);
_L2:
        return;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Slog.e("AndroidRuntime", illegalargumentexception.getMessage());
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static String callGetDefaultUserAgent() {
        return getDefaultUserAgent();
    }

    private static final void commonInit() {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtHandler());
        TimezoneGetter.setInstance(new TimezoneGetter() {

            public String getId() {
                return SystemProperties.get("persist.sys.timezone");
            }

        });
        TimeZone.setDefault(null);
        LogManager.getLogManager().reset();
        new AndroidConfig();
        System.setProperty("http.agent", getDefaultUserAgent());
        NetworkManagementSocketTagger.install();
        if(SystemProperties.get("ro.kernel.android.tracing").equals("1")) {
            Slog.i("AndroidRuntime", "NOTE: emulator trace profiling enabled");
            Debug.enableEmulatorTraceOutput();
        }
        initialized = true;
    }

    public static final IBinder getApplicationObject() {
        return mApplicationObject;
    }

    private static String getDefaultUserAgent() {
        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append("Dalvik/");
        stringbuilder.append(System.getProperty("java.vm.version"));
        stringbuilder.append(" (Linux; U; Android ");
        String s = android.os.Build.VERSION.RELEASE;
        String s1;
        if(s.length() <= 0)
            s = "1.0";
        stringbuilder.append(s);
        if("REL".equals(android.os.Build.VERSION.CODENAME)) {
            String s2 = Build.MODEL;
            if(s2.length() > 0) {
                stringbuilder.append("; ");
                stringbuilder.append(s2);
            }
        }
        s1 = Injector.appendMiuiVersion(stringbuilder, Build.ID);
        if(s1.length() > 0) {
            stringbuilder.append(" Build/");
            stringbuilder.append(s1);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    private static void invokeStaticMain(String s, String as[]) throws ZygoteInit.MethodAndArgsCaller {
        Class class1;
        Method method;
        int i;
        try {
            class1 = Class.forName(s);
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
            throw new ZygoteInit.MethodAndArgsCaller(method, as);
    }

    public static final void main(String args[]) {
        if(args.length == 2 && args[1].equals("application"))
            redirectLogStreams();
        commonInit();
        nativeFinishInit();
    }

    private static final native void nativeFinishInit();

    private static final native void nativeSetExitWithoutCleanup(boolean flag);

    private static final native void nativeZygoteInit();

    public static void redirectLogStreams() {
        System.out.close();
        System.setOut(new AndroidPrintStream(4, "System.out"));
        System.err.close();
        System.setErr(new AndroidPrintStream(5, "System.err"));
    }

    public static final void setApplicationObject(IBinder ibinder) {
        mApplicationObject = ibinder;
    }

    public static void wrapperInit(int i, String as[]) throws ZygoteInit.MethodAndArgsCaller {
        applicationInit(i, as);
    }

    public static void wtf(String s, Throwable throwable) {
        if(ActivityManagerNative.getDefault().handleApplicationWtf(mApplicationObject, s, new android.app.ApplicationErrorReport.CrashInfo(throwable))) {
            Process.killProcess(Process.myPid());
            System.exit(10);
        }
_L1:
        return;
        Throwable throwable1;
        throwable1;
        Slog.e("AndroidRuntime", "Error reporting WTF", throwable1);
          goto _L1
    }

    public static final void zygoteInit(int i, String as[]) throws ZygoteInit.MethodAndArgsCaller {
        redirectLogStreams();
        commonInit();
        nativeZygoteInit();
        applicationInit(i, as);
    }

    private static final boolean DEBUG = false;
    private static final String TAG = "AndroidRuntime";
    private static boolean initialized;
    private static IBinder mApplicationObject;
    private static volatile boolean mCrashing = false;

    static  {
        DdmRegister.registerHandlers();
    }



/*
    static boolean access$002(boolean flag) {
        mCrashing = flag;
        return flag;
    }

*/

}
