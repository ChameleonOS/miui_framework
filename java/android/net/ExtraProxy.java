// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.text.TextUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.apache.http.HttpHost;

public final class ExtraProxy {

    public ExtraProxy() {
    }

    public static final HttpHost getPreferredHttpHost(InetSocketAddress inetsocketaddress) {
        String s = null;
        if(inetsocketaddress.getAddress() != null)
            s = inetsocketaddress.getAddress().getHostAddress();
        if(TextUtils.isEmpty(s))
            s = inetsocketaddress.getHostName();
        return new HttpHost(s, inetsocketaddress.getPort(), "http");
    }
}
