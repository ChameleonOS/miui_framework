// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import java.io.File;
import java.io.IOException;

// Referenced classes of package android.content.res:
//            ObbInfo

public class ObbScanner {

    private ObbScanner() {
    }

    public static ObbInfo getObbInfo(String s) throws IOException {
        if(s == null)
            throw new IllegalArgumentException("file path cannot be null");
        File file = new File(s);
        if(!file.exists()) {
            throw new IllegalArgumentException((new StringBuilder()).append("OBB file does not exist: ").append(s).toString());
        } else {
            String s1 = file.getCanonicalPath();
            ObbInfo obbinfo = new ObbInfo();
            obbinfo.filename = s1;
            getObbInfo_native(s1, obbinfo);
            return obbinfo;
        }
    }

    private static native void getObbInfo_native(String s, ObbInfo obbinfo) throws IOException;
}
