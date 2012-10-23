// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import org.apache.harmony.xnet.provider.jsse.FileClientSessionCache;
import org.apache.harmony.xnet.provider.jsse.SSLClientSessionCache;

public final class SSLSessionCache {

    public SSLSessionCache(Context context) {
        File file;
        SSLClientSessionCache sslclientsessioncache;
        file = context.getDir("sslcache", 0);
        sslclientsessioncache = null;
        SSLClientSessionCache sslclientsessioncache1 = FileClientSessionCache.usingDirectory(file);
        sslclientsessioncache = sslclientsessioncache1;
_L2:
        mSessionCache = sslclientsessioncache;
        return;
        IOException ioexception;
        ioexception;
        Log.w("SSLSessionCache", (new StringBuilder()).append("Unable to create SSL session cache in ").append(file).toString(), ioexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public SSLSessionCache(File file) throws IOException {
        mSessionCache = FileClientSessionCache.usingDirectory(file);
    }

    private static final String TAG = "SSLSessionCache";
    final SSLClientSessionCache mSessionCache;
}
