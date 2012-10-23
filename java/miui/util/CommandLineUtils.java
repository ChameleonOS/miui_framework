// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.text.TextUtils;
import java.io.InputStream;

public class CommandLineUtils {

    private CommandLineUtils() {
    }

    public static String addQuoteMark(String s) {
        if(!TextUtils.isEmpty(s) && s.charAt(0) != '"' && !s.contains("*"))
            s = (new StringBuilder()).append("\"").append(s).append("\"").toString();
        return s;
    }

    public static boolean chmod(String s, String s1, String s2) {
        Object aobj[] = new Object[2];
        aobj[0] = s1;
        aobj[1] = addQuoteMark(s);
        return run(s2, "busybox chmod %s %s", aobj);
    }

    public static boolean chown(String s, String s1, String s2, String s3) {
        Object aobj[] = new Object[3];
        aobj[0] = s1;
        aobj[1] = s2;
        aobj[2] = addQuoteMark(s);
        return run(s3, "busybox chown %s.%s %s", aobj);
    }

    public static boolean cp(String s, String s1, String s2) {
        Object aobj[] = new Object[2];
        aobj[0] = addQuoteMark(s);
        aobj[1] = addQuoteMark(s1);
        return run(s2, "busybox cp -rf %s %s", aobj);
    }

    public static boolean mkdir(String s, String s1) {
        Object aobj[] = new Object[1];
        aobj[0] = addQuoteMark(s);
        return run(s1, "busybox mkdir -p %s", aobj);
    }

    public static boolean mv(String s, String s1, String s2) {
        Object aobj[] = new Object[2];
        aobj[0] = addQuoteMark(s);
        aobj[1] = addQuoteMark(s1);
        return run(s2, "busybox mv -f %s %s", aobj);
    }

    public static boolean rm(String s, String s1) {
        Object aobj[] = new Object[1];
        aobj[0] = addQuoteMark(s);
        return run(s1, "busybox rm -r %s", aobj);
    }

    public static transient boolean run(String s, String s1, Object aobj[]) {
        return run(false, s, s1, aobj);
    }

    public static transient boolean run(boolean flag, String s, String s1, Object aobj[]) {
        String s2;
        boolean flag1;
        if(aobj.length > 0)
            s2 = String.format(s1, aobj);
        else
            s2 = s1;
        if(TextUtils.isEmpty(s)) {
            String as1[] = new String[3];
            as1[0] = "sh";
            as1[1] = "-c";
            as1[2] = s2;
            flag1 = runInner(flag, as1);
        } else {
            String as[] = new String[3];
            as[0] = "/system/xbin/invoke-as";
            Object aobj1[] = new Object[1];
            aobj1[0] = s;
            as[1] = String.format("-u %s", aobj1);
            as[2] = s2;
            flag1 = runInner(flag, as);
        }
        return flag1;
    }

    public static transient InputStream runAndOutput(String s, String s1, Object aobj[]) {
        String s2;
        InputStream inputstream;
        if(aobj.length > 0)
            s2 = String.format(s1, aobj);
        else
            s2 = s1;
        if(TextUtils.isEmpty(s)) {
            String as1[] = new String[3];
            as1[0] = "sh";
            as1[1] = "-c";
            as1[2] = s2;
            inputstream = runAndOutputInner(as1);
        } else {
            String as[] = new String[3];
            as[0] = "/system/xbin/invoke-as";
            Object aobj1[] = new Object[1];
            aobj1[0] = s;
            as[1] = String.format("-u %s", aobj1);
            as[2] = s2;
            inputstream = runAndOutputInner(as);
        }
        return inputstream;
    }

    private static transient InputStream runAndOutputInner(String as[]) {
        InputStream inputstream = null;
        Process process;
        synchronized(sLock) {
            process = Runtime.getRuntime().exec(as);
        }
        inputstream = process.getInputStream();
        if(process.waitFor() == 0)
            break MISSING_BLOCK_LABEL_39;
        inputstream.close();
        inputstream = null;
_L2:
        return inputstream;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        try {
            throw exception1;
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static transient boolean runInner(boolean flag, String as[]) {
        boolean flag1 = true;
        Process process;
        synchronized(sLock) {
            process = Runtime.getRuntime().exec(as);
        }
        if(flag)
            break MISSING_BLOCK_LABEL_40;
        int i = process.waitFor();
        if(i != 0)
            flag1 = false;
_L2:
        return flag1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        try {
            throw exception1;
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static boolean symlink(String s, String s1, String s2) {
        Object aobj[] = new Object[2];
        aobj[0] = addQuoteMark(s);
        aobj[1] = addQuoteMark(s1);
        return run(s2, "busybox ln -sf %s %s", aobj);
    }

    static Object sLock = new Object();

}
