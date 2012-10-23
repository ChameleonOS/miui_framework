// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.net.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package android.webkit:
//            MimeTypeMap

public final class URLUtil {

    public URLUtil() {
    }

    public static String composeSearchUrl(String s, String s1, String s2) {
        String s3;
        int i;
        s3 = null;
        i = s1.indexOf(s2);
        if(i >= 0) goto _L2; else goto _L1
_L1:
        return s3;
_L2:
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        stringbuilder.append(s1.substring(0, i));
        stringbuilder.append(URLEncoder.encode(s, "utf-8"));
        stringbuilder.append(s1.substring(i + s2.length()));
        s3 = stringbuilder.toString();
        continue; /* Loop/switch isn't completed */
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static byte[] decode(byte abyte0[]) throws IllegalArgumentException {
        if(abyte0.length != 0) goto _L2; else goto _L1
_L1:
        byte abyte2[] = new byte[0];
_L4:
        return abyte2;
_L2:
        byte abyte1[];
        int i;
label0:
        {
            abyte1 = new byte[abyte0.length];
            i = 0;
            int j = 0;
            do {
                if(j >= abyte0.length)
                    break label0;
                byte byte0 = abyte0[j];
                if(byte0 == 37) {
                    if(abyte0.length - j <= 2)
                        break;
                    byte0 = (byte)(16 * parseHex(abyte0[j + 1]) + parseHex(abyte0[j + 2]));
                    j += 2;
                }
                int k = i + 1;
                abyte1[i] = byte0;
                j++;
                i = k;
            } while(true);
            throw new IllegalArgumentException("Invalid format");
        }
        abyte2 = new byte[i];
        System.arraycopy(abyte1, 0, abyte2, 0, i);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final String guessFileName(String s, String s1, String s2) {
        String s3 = null;
        String s4 = null;
        if(true && s1 != null) {
            s3 = parseContentDisposition(s1);
            if(s3 != null) {
                int i1 = 1 + s3.lastIndexOf('/');
                if(i1 > 0)
                    s3 = s3.substring(i1);
            }
        }
        if(s3 == null) {
            String s6 = Uri.decode(s);
            if(s6 != null) {
                int k = s6.indexOf('?');
                if(k > 0)
                    s6 = s6.substring(0, k);
                if(!s6.endsWith("/")) {
                    int l = 1 + s6.lastIndexOf('/');
                    if(l > 0)
                        s3 = s6.substring(l);
                }
            }
        }
        if(s3 == null)
            s3 = "downloadfile";
        int i = s3.indexOf('.');
        if(i < 0) {
            if(s2 != null) {
                s4 = MimeTypeMap.getSingleton().getExtensionFromMimeType(s2);
                if(s4 != null)
                    s4 = (new StringBuilder()).append(".").append(s4).toString();
            }
            if(s4 == null)
                if(s2 != null && s2.toLowerCase().startsWith("text/")) {
                    if(s2.equalsIgnoreCase("text/html"))
                        s4 = ".html";
                    else
                        s4 = ".txt";
                } else {
                    s4 = ".bin";
                }
        } else {
            if(s2 != null) {
                int j = s3.lastIndexOf('.');
                String s5 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s3.substring(j + 1));
                if(s5 != null && !s5.equalsIgnoreCase(s2)) {
                    s4 = MimeTypeMap.getSingleton().getExtensionFromMimeType(s2);
                    if(s4 != null)
                        s4 = (new StringBuilder()).append(".").append(s4).toString();
                }
            }
            if(s4 == null)
                s4 = s3.substring(i);
            s3 = s3.substring(0, i);
        }
        return (new StringBuilder()).append(s3).append(s4).toString();
    }

    public static String guessUrl(String s) {
        String s1;
        s1 = s;
        break MISSING_BLOCK_LABEL_2;
_L2:
        do
            return s;
        while(s.length() == 0 || s.startsWith("about:") || s.startsWith("data:") || s.startsWith("file:") || s.startsWith("javascript:"));
        if(s.endsWith("."))
            s = s.substring(0, -1 + s.length());
        WebAddress webaddress = new WebAddress(s);
        if(webaddress.getHost().indexOf('.') == -1)
            webaddress.setHost((new StringBuilder()).append("www.").append(webaddress.getHost()).append(".com").toString());
        s = webaddress.toString();
        continue; /* Loop/switch isn't completed */
        ParseException parseexception;
        parseexception;
        s = s1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static boolean isAboutUrl(String s) {
        boolean flag;
        if(s != null && s.startsWith("about:"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isAssetUrl(String s) {
        boolean flag;
        if(s != null && s.startsWith("file:///android_asset/"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isContentUrl(String s) {
        boolean flag;
        if(s != null && s.startsWith("content:"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isCookielessProxyUrl(String s) {
        boolean flag;
        if(s != null && s.startsWith("file:///cookieless_proxy/"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isDataUrl(String s) {
        boolean flag;
        if(s != null && s.startsWith("data:"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isFileUrl(String s) {
        boolean flag;
        if(s != null && s.startsWith("file://") && !s.startsWith("file:///android_asset/") && !s.startsWith("file:///cookieless_proxy/"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isHttpUrl(String s) {
        boolean flag = false;
        if(s != null && s.length() > 6 && s.substring(0, 7).equalsIgnoreCase("http://"))
            flag = true;
        return flag;
    }

    public static boolean isHttpsUrl(String s) {
        boolean flag = false;
        if(s != null && s.length() > 7 && s.substring(0, 8).equalsIgnoreCase("https://"))
            flag = true;
        return flag;
    }

    public static boolean isJavaScriptUrl(String s) {
        boolean flag;
        if(s != null && s.startsWith("javascript:"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isNetworkUrl(String s) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(s != null && s.length() != 0 && (isHttpUrl(s) || isHttpsUrl(s)))
            flag = true;
        return flag;
    }

    public static boolean isResourceUrl(String s) {
        boolean flag;
        if(s != null && s.startsWith("file:///android_res/"))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isValidUrl(String s) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(s != null && s.length() != 0 && (isAssetUrl(s) || isResourceUrl(s) || isFileUrl(s) || isAboutUrl(s) || isHttpUrl(s) || isHttpsUrl(s) || isJavaScriptUrl(s) || isContentUrl(s)))
            flag = true;
        return flag;
    }

    static String parseContentDisposition(String s) {
        Matcher matcher = CONTENT_DISPOSITION_PATTERN.matcher(s);
        if(!matcher.find()) goto _L2; else goto _L1
_L1:
        String s2 = matcher.group(2);
        String s1 = s2;
_L4:
        return s1;
        IllegalStateException illegalstateexception;
        illegalstateexception;
_L2:
        s1 = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static int parseHex(byte byte0) {
        int i;
        if(byte0 >= 48 && byte0 <= 57)
            i = byte0 - 48;
        else
        if(byte0 >= 65 && byte0 <= 70)
            i = 10 + (byte0 - 65);
        else
        if(byte0 >= 97 && byte0 <= 102)
            i = 10 + (byte0 - 97);
        else
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid hex char '").append(byte0).append("'").toString());
        return i;
    }

    public static String stripAnchor(String s) {
        int i = s.indexOf('#');
        if(i != -1)
            s = s.substring(0, i);
        return s;
    }

    static boolean verifyURLEncoding(String s) {
        boolean flag;
        int i;
        flag = false;
        i = s.length();
        if(i != 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int j = s.indexOf('%');
        do {
            if(j < 0 || j >= i)
                break;
            if(j >= i - 2)
                continue; /* Loop/switch isn't completed */
            int k = j + 1;
            int l;
            try {
                parseHex((byte)s.charAt(k));
                l = k + 1;
                parseHex((byte)s.charAt(l));
            }
            catch(IllegalArgumentException illegalargumentexception) {
                continue; /* Loop/switch isn't completed */
            }
            j = s.indexOf('%', l + 1);
        } while(true);
        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    static final String ASSET_BASE = "file:///android_asset/";
    static final String CONTENT_BASE = "content:";
    private static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);
    static final String FILE_BASE = "file://";
    private static final String LOGTAG = "webkit";
    static final String PROXY_BASE = "file:///cookieless_proxy/";
    static final String RESOURCE_BASE = "file:///android_res/";

}
