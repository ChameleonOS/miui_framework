// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.os;

import android.os.FileUtils;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

public class ExtraFileUtils {

    private ExtraFileUtils() {
    }

    public static void addNoMedia(String s) {
        File file;
        file = new File(s);
        if(!file.isDirectory())
            break MISSING_BLOCK_LABEL_30;
        (new File(file, ".nomedia")).createNewFile();
_L2:
        return;
        IOException ioexception;
        ioexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static boolean deleteDir(File file) {
        boolean flag = true;
        if(!file.isDirectory()) goto _L2; else goto _L1
_L1:
        String as[] = file.list();
        if(as != null) goto _L4; else goto _L3
_L3:
        boolean flag1 = false;
_L6:
        return flag1;
_L4:
        for(int i = 0; i < as.length; i++)
            if(!deleteDir(new File(file, as[i])))
                flag = false;

_L2:
        if(!file.delete())
            flag = false;
        flag1 = flag;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static String getExtension(File file) {
        String s;
        if(file == null)
            s = "";
        else
            s = getExtension(file.getName());
        return s;
    }

    public static String getExtension(String s) {
        String s1;
        if(TextUtils.isEmpty(s)) {
            s1 = "";
        } else {
            int i = s.lastIndexOf(".");
            if(i > -1)
                s1 = s.substring(i + 1);
            else
                s1 = "";
        }
        return s1;
    }

    public static String getFileName(String s) {
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s = "";
_L4:
        return s;
_L2:
        int i = s.lastIndexOf(File.separator);
        if(i > -1)
            s = s.substring(i + 1);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String getFileTitle(File file) {
        String s;
        if(file == null)
            s = "";
        else
            s = getFileTitle(file.getName());
        return s;
    }

    public static String getFileTitle(String s) {
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s = "";
_L4:
        return s;
_L2:
        int i = s.lastIndexOf(".");
        if(i > -1)
            s = s.substring(0, i);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String getParentFolderPath(String s) {
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s = "";
_L4:
        return s;
_L2:
        int i = s.lastIndexOf(File.separator);
        if(i > -1)
            s = s.substring(0, i);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean mkdirs(File file, int i, int j, int k) {
        boolean flag = false;
        if(!file.exists()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        String s = file.getParent();
        if(s != null)
            mkdirs(new File(s), i, j, k);
        if(file.mkdir()) {
            FileUtils.setPermissions(file.getPath(), i, j, k);
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static String standardizeFolderPath(String s) {
        if(!s.endsWith(File.separator))
            s = (new StringBuilder()).append(s).append(File.separator).toString();
        return s;
    }
}
