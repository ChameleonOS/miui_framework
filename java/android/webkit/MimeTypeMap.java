// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.text.TextUtils;
import java.util.regex.Pattern;
import libcore.net.MimeUtils;

// Referenced classes of package android.webkit:
//            URLUtil

public class MimeTypeMap {

    private MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String s) {
        if(TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        String s1;
        int i = s.lastIndexOf('#');
        if(i > 0)
            s = s.substring(0, i);
        int j = s.lastIndexOf('?');
        if(j > 0)
            s = s.substring(0, j);
        int k = s.lastIndexOf('/');
        String s2;
        int l;
        if(k >= 0)
            s2 = s.substring(k + 1);
        else
            s2 = s;
        if(s2.isEmpty() || !Pattern.matches("[a-zA-Z_0-9\\.\\-\\(\\)\\%]+", s2)) goto _L2; else goto _L3
_L3:
        l = s2.lastIndexOf('.');
        if(l < 0) goto _L2; else goto _L4
_L4:
        s1 = s2.substring(l + 1);
_L6:
        return s1;
_L2:
        s1 = "";
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static MimeTypeMap getSingleton() {
        return sMimeTypeMap;
    }

    private static String mimeTypeFromExtension(String s) {
        return MimeUtils.guessMimeTypeFromExtension(s);
    }

    public String getExtensionFromMimeType(String s) {
        return MimeUtils.guessExtensionFromMimeType(s);
    }

    public String getMimeTypeFromExtension(String s) {
        return MimeUtils.guessMimeTypeFromExtension(s);
    }

    public boolean hasExtension(String s) {
        return MimeUtils.hasExtension(s);
    }

    public boolean hasMimeType(String s) {
        return MimeUtils.hasMimeType(s);
    }

    String remapGenericMimeType(String s, String s1, String s2) {
        if(!"text/plain".equals(s) && !"application/octet-stream".equals(s)) goto _L2; else goto _L1
_L1:
        String s3 = null;
        if(s2 != null)
            s3 = URLUtil.parseContentDisposition(s2);
        if(s3 != null)
            s1 = s3;
        String s4 = getMimeTypeFromExtension(getFileExtensionFromUrl(s1));
        if(s4 != null)
            s = s4;
_L4:
        return s;
_L2:
        if("text/vnd.wap.wml".equals(s))
            s = "text/plain";
        else
        if("application/vnd.wap.xhtml+xml".equals(s))
            s = "application/xhtml+xml";
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final MimeTypeMap sMimeTypeMap = new MimeTypeMap();

}
