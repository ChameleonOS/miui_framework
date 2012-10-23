// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;

abstract class WebTextView {

    WebTextView() {
    }

    static String urlForAutoCompleteData(String s) {
        URL url = null;
        URL url1 = new URL(s);
        url = url1;
_L1:
        String s1;
        MalformedURLException malformedurlexception;
        if(url != null)
            s1 = (new StringBuilder()).append(url.getProtocol()).append("://").append(url.getHost()).append(url.getPath()).toString();
        else
            s1 = null;
        return s1;
        malformedurlexception;
        Log.e("WebTextView", (new StringBuilder()).append("Unable to parse URL ").append(null).toString());
          goto _L1
    }

    static final int EMAIL = 4;
    static final int FORM_NOT_AUTOFILLABLE = -1;
    private static final String LOGTAG = "WebTextView";
    static final int NORMAL_TEXT_FIELD = 0;
    static final int NUMBER = 5;
    static final int PASSWORD = 2;
    static final int SEARCH = 3;
    static final int TELEPHONE = 6;
    static final int TEXT_AREA = 1;
    static final int URL = 7;
}
