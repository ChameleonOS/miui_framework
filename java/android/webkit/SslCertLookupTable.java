// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.net.http.SslError;
import android.os.Bundle;
import java.net.MalformedURLException;
import java.net.URL;

final class SslCertLookupTable {

    private SslCertLookupTable() {
    }

    public static SslCertLookupTable getInstance() {
        if(sTable == null)
            sTable = new SslCertLookupTable();
        return sTable;
    }

    public void clear() {
        table.clear();
    }

    public boolean isAllowed(SslError sslerror) {
        boolean flag = false;
        String s = (new URL(sslerror.getUrl())).getHost();
        if(table.containsKey(s) && sslerror.getPrimaryError() <= table.getInt(s))
            flag = true;
_L2:
        return flag;
        MalformedURLException malformedurlexception;
        malformedurlexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setIsAllowed(SslError sslerror) {
        String s = (new URL(sslerror.getUrl())).getHost();
        table.putInt(s, sslerror.getPrimaryError());
_L2:
        return;
        MalformedURLException malformedurlexception;
        malformedurlexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static SslCertLookupTable sTable;
    private final Bundle table = new Bundle();
}
