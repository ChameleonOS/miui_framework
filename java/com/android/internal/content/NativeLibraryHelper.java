// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.content;

import android.os.Build;
import android.util.Slog;
import java.io.File;

public class NativeLibraryHelper {

    public NativeLibraryHelper() {
    }

    public static int copyNativeBinariesIfNeededLI(File file, File file1) {
        String s = Build.CPU_ABI;
        String s1 = Build.CPU_ABI2;
        return nativeCopyNativeBinaries(file.getPath(), file1.getPath(), s, s1);
    }

    private static native int nativeCopyNativeBinaries(String s, String s1, String s2, String s3);

    private static native long nativeSumNativeBinaries(String s, String s1, String s2);

    public static boolean removeNativeBinariesFromDirLI(File file) {
        boolean flag = false;
        if(file.exists()) {
            File afile[] = file.listFiles();
            if(afile != null) {
                int i = 0;
                while(i < afile.length)  {
                    if(!afile[i].delete())
                        Slog.w("NativeHelper", (new StringBuilder()).append("Could not delete native binary: ").append(afile[i].getPath()).toString());
                    else
                        flag = true;
                    i++;
                }
            }
        }
        return flag;
    }

    public static boolean removeNativeBinariesLI(String s) {
        return removeNativeBinariesFromDirLI(new File(s));
    }

    public static long sumNativeBinariesLI(File file) {
        String s = Build.CPU_ABI;
        String s1 = Build.CPU_ABI2;
        return nativeSumNativeBinaries(file.getPath(), s, s1);
    }

    private static final boolean DEBUG_NATIVE = false;
    private static final String TAG = "NativeHelper";
}
