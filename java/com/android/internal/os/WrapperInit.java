// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.os.Process;
import android.util.Slog;
import dalvik.system.Zygote;
import java.io.*;
import libcore.io.IoUtils;

// Referenced classes of package com.android.internal.os:
//            ZygoteInit, RuntimeInit

public class WrapperInit {

    private WrapperInit() {
    }

    public static void execApplication(String s, String s1, int i, FileDescriptor filedescriptor, String as[]) {
        StringBuilder stringbuilder = new StringBuilder(s);
        stringbuilder.append(" /system/bin/app_process /system/bin --application");
        if(s1 != null)
            stringbuilder.append(" '--nice-name=").append(s1).append("'");
        stringbuilder.append(" com.android.internal.os.WrapperInit ");
        int j;
        if(filedescriptor != null)
            j = filedescriptor.getInt$();
        else
            j = 0;
        stringbuilder.append(j);
        stringbuilder.append(' ');
        stringbuilder.append(i);
        Zygote.appendQuotedShellArgs(stringbuilder, as);
        Zygote.execShell(stringbuilder.toString());
    }

    public static void execStandalone(String s, String s1, String s2, String as[]) {
        StringBuilder stringbuilder = new StringBuilder(s);
        stringbuilder.append(" /system/bin/dalvikvm -classpath '").append(s1);
        stringbuilder.append("' ").append(s2);
        Zygote.appendQuotedShellArgs(stringbuilder, as);
        Zygote.execShell(stringbuilder.toString());
    }

    public static void main(String args[]) {
        int i;
        int j;
        i = Integer.parseInt(args[0], 10);
        j = Integer.parseInt(args[1], 10);
        if(i == 0)
            break MISSING_BLOCK_LABEL_64;
        String args1[];
        try {
            FileDescriptor filedescriptor = ZygoteInit.createFileDescriptor(i);
            DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(filedescriptor));
            dataoutputstream.writeInt(Process.myPid());
            dataoutputstream.close();
            IoUtils.closeQuietly(filedescriptor);
        }
        catch(IOException ioexception) {
            Slog.d("AndroidRuntime", "Could not write pid of wrapped process to Zygote pipe.", ioexception);
        }
        ZygoteInit.preload();
        args1 = new String[-2 + args.length];
        System.arraycopy(args, 2, args1, 0, args1.length);
        RuntimeInit.wrapperInit(j, args1);
        break MISSING_BLOCK_LABEL_117;
        ZygoteInit.MethodAndArgsCaller methodandargscaller;
        methodandargscaller;
        methodandargscaller.run();
    }

    private static final String TAG = "AndroidRuntime";
}
