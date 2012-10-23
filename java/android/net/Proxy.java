// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.content.Context;
import android.text.TextUtils;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package android.net:
//            ExtraProxy, ConnectivityManager, ProxyProperties, NetworkUtils

public final class Proxy {
    static class AndroidProxySelectorRoutePlanner extends ProxySelectorRoutePlanner {

        protected java.net.Proxy chooseProxy(List list, HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext) {
            return Proxy.getProxy(mContext, httphost.getHostName());
        }

        protected HttpHost determineProxy(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext) {
            return Proxy.getPreferredHttpHost(mContext, httphost.getHostName());
        }

        public HttpRoute determineRoute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext) {
            HttpHost httphost1 = Proxy.getPreferredHttpHost(mContext, httphost.getHostName());
            HttpRoute httproute;
            if(httphost1 == null)
                httproute = new HttpRoute(httphost);
            else
                httproute = new HttpRoute(httphost, null, httphost1, false);
            return httproute;
        }

        private Context mContext;

        public AndroidProxySelectorRoutePlanner(SchemeRegistry schemeregistry, ProxySelector proxyselector, Context context) {
            super(schemeregistry, proxyselector);
            mContext = context;
        }
    }


    public Proxy() {
    }

    public static final HttpRoutePlanner getAndroidProxySelectorRoutePlanner(Context context) {
        return new AndroidProxySelectorRoutePlanner(new SchemeRegistry(), ProxySelector.getDefault(), context);
    }

    public static final String getDefaultHost() {
        String s = System.getProperty("http.proxyHost");
        if(TextUtils.isEmpty(s))
            s = null;
        return s;
    }

    public static final int getDefaultPort() {
        int i = -1;
        if(getDefaultHost() != null) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        int j = Integer.parseInt(System.getProperty("http.proxyPort"));
        i = j;
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static final String getHost(Context context) {
        java.net.Proxy proxy = getProxy(context, null);
        if(proxy != java.net.Proxy.NO_PROXY) goto _L2; else goto _L1
_L1:
        String s = null;
_L4:
        return s;
_L2:
        String s1 = ((InetSocketAddress)(InetSocketAddress)proxy.address()).getHostName();
        s = s1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        s = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final int getPort(Context context) {
        java.net.Proxy proxy = getProxy(context, null);
        if(proxy != java.net.Proxy.NO_PROXY) goto _L2; else goto _L1
_L1:
        int i = -1;
_L4:
        return i;
_L2:
        int j = ((InetSocketAddress)(InetSocketAddress)proxy.address()).getPort();
        i = j;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        i = -1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final HttpHost getPreferredHttpHost(Context context, String s) {
        java.net.Proxy proxy = getProxy(context, s);
        HttpHost httphost;
        if(proxy.equals(java.net.Proxy.NO_PROXY))
            httphost = null;
        else
            httphost = ExtraProxy.getPreferredHttpHost((InetSocketAddress)proxy.address());
        return httphost;
    }

    public static final java.net.Proxy getProxy(Context context, String s) {
        String s1;
        s1 = "";
        if(s != null)
            s1 = URI.create(s).getHost();
        if(isLocalHost(s1)) goto _L2; else goto _L1
_L1:
        if(sConnectivityManager == null)
            sConnectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        if(sConnectivityManager != null) goto _L4; else goto _L3
_L3:
        java.net.Proxy proxy = java.net.Proxy.NO_PROXY;
_L6:
        return proxy;
_L4:
        ProxyProperties proxyproperties = sConnectivityManager.getProxy();
        if(proxyproperties != null && !proxyproperties.isExcluded(s1)) {
            proxy = proxyproperties.makeProxy();
            continue; /* Loop/switch isn't completed */
        }
_L2:
        proxy = java.net.Proxy.NO_PROXY;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static final boolean isLocalHost(String s) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
_L2:
        do
            return flag;
        while(s == null || s == null);
        boolean flag1;
        if(s.equalsIgnoreCase("localhost")) {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        flag1 = NetworkUtils.numericToInetAddress(s).isLoopbackAddress();
        if(flag1)
            flag = true;
        continue; /* Loop/switch isn't completed */
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final void setHttpProxySystemProperty(ProxyProperties proxyproperties) {
        String s = null;
        String s1 = null;
        String s2 = null;
        if(proxyproperties != null) {
            s = proxyproperties.getHost();
            s1 = Integer.toString(proxyproperties.getPort());
            s2 = proxyproperties.getExclusionList();
        }
        setHttpProxySystemProperty(s, s1, s2);
    }

    public static final void setHttpProxySystemProperty(String s, String s1, String s2) {
        if(s2 != null)
            s2 = s2.replace(",", "|");
        if(s != null) {
            System.setProperty("http.proxyHost", s);
            System.setProperty("https.proxyHost", s);
        } else {
            System.clearProperty("http.proxyHost");
            System.clearProperty("https.proxyHost");
        }
        if(s1 != null) {
            System.setProperty("http.proxyPort", s1);
            System.setProperty("https.proxyPort", s1);
        } else {
            System.clearProperty("http.proxyPort");
            System.clearProperty("https.proxyPort");
        }
        if(s2 != null) {
            System.setProperty("http.nonProxyHosts", s2);
            System.setProperty("https.nonProxyHosts", s2);
        } else {
            System.clearProperty("http.nonProxyHosts");
            System.clearProperty("https.nonProxyHosts");
        }
    }

    public static void validate(String s, String s1, String s2) {
        Matcher matcher = HOSTNAME_PATTERN.matcher(s);
        Matcher matcher1 = EXCLLIST_PATTERN.matcher(s2);
        if(!matcher.matches())
            throw new IllegalArgumentException();
        if(!matcher1.matches())
            throw new IllegalArgumentException();
        if(s.length() > 0 && s1.length() == 0)
            throw new IllegalArgumentException();
        if(s1.length() > 0) {
            if(s.length() == 0)
                throw new IllegalArgumentException();
            int i;
            try {
                i = Integer.parseInt(s1);
            }
            catch(NumberFormatException numberformatexception) {
                throw new IllegalArgumentException();
            }
            if(i <= 0 || i > 65535)
                throw new IllegalArgumentException();
        }
    }

    private static final boolean DEBUG = false;
    private static final Pattern EXCLLIST_PATTERN = Pattern.compile("$|^(.?[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*(\\.[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*)*)+(,(.?[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*(\\.[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*)*))*$");
    private static final String EXCLLIST_REGEXP = "$|^(.?[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*(\\.[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*)*)+(,(.?[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*(\\.[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*)*))*$";
    public static final String EXTRA_PROXY_INFO = "proxy";
    private static final Pattern HOSTNAME_PATTERN = Pattern.compile("^$|^[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*(\\.[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*)*$");
    private static final String HOSTNAME_REGEXP = "^$|^[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*(\\.[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*)*$";
    private static final String NAME_IP_REGEX = "[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*(\\.[a-zA-Z0-9]+(\\-[a-zA-Z0-9]+)*)*";
    public static final String PROXY_CHANGE_ACTION = "android.intent.action.PROXY_CHANGE";
    private static final String TAG = "Proxy";
    private static ConnectivityManager sConnectivityManager = null;

}
