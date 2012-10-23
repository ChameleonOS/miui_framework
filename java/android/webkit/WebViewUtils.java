// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.net.Uri;
import android.text.TextUtils;

public class WebViewUtils {

    public WebViewUtils() {
    }

    public static String processUrl(String s) {
_L2:
        return s;
        if(s == null || !s.toLowerCase().contains("baidu.com")) goto _L2; else goto _L1
_L1:
        if(s.equalsIgnoreCase("http://baidu.com/")) {
            s = "http://m.baidu.com/?from=1269a";
            continue; /* Loop/switch isn't completed */
        }
        String s1;
        Uri uri = Uri.parse(s);
        if(uri == null || uri.getAuthority() == null || !uri.getAuthority().equalsIgnoreCase("m.baidu.com") && !uri.getAuthority().equalsIgnoreCase("baidu.com") || !TextUtils.isEmpty(uri.getQueryParameter("from")))
            continue; /* Loop/switch isn't completed */
        android.net.Uri.Builder builder = uri.buildUpon();
        builder.appendQueryParameter("from", "1269a");
        s1 = builder.toString();
        s = s1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if(true) goto _L2; else goto _L3
_L3:
    }
}
