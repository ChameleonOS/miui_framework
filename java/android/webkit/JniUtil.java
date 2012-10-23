// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.InputStream;

class JniUtil {

    private JniUtil() {
    }

    private static boolean canSatisfyMemoryAllocation(long l) {
        checkInitialized();
        ActivityManager activitymanager = (ActivityManager)sContext.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        activitymanager.getMemoryInfo(memoryinfo);
        long l1 = memoryinfo.availMem - memoryinfo.threshold;
        boolean flag;
        if(!memoryinfo.lowMemory && l < l1)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static void checkInitialized() {
        if(sContext == null)
            throw new IllegalStateException("Call CookieSyncManager::createInstance() or create a webview before using this class");
        else
            return;
    }

    /**
     * @deprecated Method contentUrlSize is deprecated
     */

    private static long contentUrlSize(String s) {
        android/webkit/JniUtil;
        JVM INSTR monitorenter ;
        boolean flag = s.startsWith("content:");
        if(!flag) goto _L2; else goto _L1
_L1:
        InputStream inputstream;
        byte abyte0[];
        int i = s.lastIndexOf('?');
        if(i != -1)
            s = s.substring(0, i);
        Uri uri = Uri.parse(s);
        inputstream = sContext.getContentResolver().openInputStream(uri);
        abyte0 = new byte[1024];
        long l = 0L;
_L4:
        int j = inputstream.read(abyte0);
        if(j == -1)
            break; /* Loop/switch isn't completed */
        l += j;
        if(true) goto _L4; else goto _L3
_L3:
        inputstream.close();
_L6:
        android/webkit/JniUtil;
        JVM INSTR monitorexit ;
        return l;
        Exception exception2;
        exception2;
        Exception exception;
        try {
            inputstream.close();
            throw exception2;
        }
        catch(Exception exception1) { }
        finally {
            android/webkit/JniUtil;
        }
        Log.e("webkit", (new StringBuilder()).append("Exception: ").append(s).toString());
        l = 0L;
        continue; /* Loop/switch isn't completed */
_L2:
        l = 0L;
        if(true) goto _L6; else goto _L5
_L5:
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method contentUrlStream is deprecated
     */

    private static InputStream contentUrlStream(String s) {
        InputStream inputstream = null;
        android/webkit/JniUtil;
        JVM INSTR monitorenter ;
        boolean flag = s.startsWith("content:");
        if(!flag)
            break MISSING_BLOCK_LABEL_61;
        InputStream inputstream1;
        int i = s.lastIndexOf('?');
        if(i != -1)
            s = s.substring(0, i);
        Uri uri = Uri.parse(s);
        inputstream1 = sContext.getContentResolver().openInputStream(uri);
        inputstream = inputstream1;
_L2:
        android/webkit/JniUtil;
        JVM INSTR monitorexit ;
        return inputstream;
        Exception exception1;
        exception1;
        Log.e("webkit", (new StringBuilder()).append("Exception: ").append(s).toString());
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getAutofillQueryUrl is deprecated
     */

    private static String getAutofillQueryUrl() {
        android/webkit/JniUtil;
        JVM INSTR monitorenter ;
        String s;
        checkInitialized();
        s = android.provider.Settings.Secure.getString(sContext.getContentResolver(), "web_autofill_query_url");
        android/webkit/JniUtil;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getCacheDirectory is deprecated
     */

    private static String getCacheDirectory() {
        android/webkit/JniUtil;
        JVM INSTR monitorenter ;
        File file;
        checkInitialized();
        if(sCacheDirectory == null) {
            file = sContext.getCacheDir();
            if(file != null)
                break MISSING_BLOCK_LABEL_37;
            sCacheDirectory = "";
        }
_L1:
        String s = sCacheDirectory;
        android/webkit/JniUtil;
        JVM INSTR monitorexit ;
        return s;
        sCacheDirectory = file.getAbsolutePath();
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getContext is deprecated
     */

    protected static Context getContext() {
        android/webkit/JniUtil;
        JVM INSTR monitorenter ;
        Context context = sContext;
        android/webkit/JniUtil;
        JVM INSTR monitorexit ;
        return context;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getDatabaseDirectory is deprecated
     */

    private static String getDatabaseDirectory() {
        android/webkit/JniUtil;
        JVM INSTR monitorenter ;
        String s;
        checkInitialized();
        if(sDatabaseDirectory == null)
            sDatabaseDirectory = sContext.getDatabasePath("dummy").getParent();
        s = sDatabaseDirectory;
        android/webkit/JniUtil;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getPackageName is deprecated
     */

    private static String getPackageName() {
        android/webkit/JniUtil;
        JVM INSTR monitorenter ;
        String s;
        checkInitialized();
        s = sContext.getPackageName();
        android/webkit/JniUtil;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setContext is deprecated
     */

    protected static void setContext(Context context) {
        android/webkit/JniUtil;
        JVM INSTR monitorenter ;
        Context context1 = sContext;
        if(context1 == null) goto _L2; else goto _L1
_L1:
        android/webkit/JniUtil;
        JVM INSTR monitorexit ;
        return;
_L2:
        sContext = context.getApplicationContext();
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static final String ANDROID_CONTENT = "content:";
    private static final String LOGTAG = "webkit";
    private static String sCacheDirectory;
    private static Context sContext;
    private static String sDatabaseDirectory;

    static  {
        System.loadLibrary("webcore");
        System.loadLibrary("chromium_net");
    }
}
