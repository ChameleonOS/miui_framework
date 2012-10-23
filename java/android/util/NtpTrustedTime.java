// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import android.content.Context;
import android.content.res.Resources;
import android.net.SntpClient;
import android.os.SystemClock;

// Referenced classes of package android.util:
//            TrustedTime

public class NtpTrustedTime
    implements TrustedTime {

    private NtpTrustedTime(String s, long l) {
        mServer = s;
        mTimeout = l;
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static NtpTrustedTime getInstance(Context context) {
        android/util/NtpTrustedTime;
        JVM INSTR monitorenter ;
        if(sSingleton != null) goto _L2; else goto _L1
_L1:
        String s;
        long l1;
        String s2;
        Resources resources = context.getResources();
        android.content.ContentResolver contentresolver = context.getContentResolver();
        s = resources.getString(0x1040026);
        long l = resources.getInteger(0x10e0030);
        String s1 = android.provider.Settings.Secure.getString(contentresolver, "ntp_server");
        l1 = android.provider.Settings.Secure.getLong(contentresolver, "ntp_timeout", l);
        if(s1 == null)
            break MISSING_BLOCK_LABEL_89;
        s2 = s1;
_L3:
        sSingleton = new NtpTrustedTime(s2, l1);
_L2:
        NtpTrustedTime ntptrustedtime = sSingleton;
        android/util/NtpTrustedTime;
        JVM INSTR monitorexit ;
        return ntptrustedtime;
        s2 = s;
          goto _L3
        Exception exception;
        exception;
        throw exception;
    }

    public long currentTimeMillis() {
        if(!mHasCache)
            throw new IllegalStateException("Missing authoritative time source");
        else
            return mCachedNtpTime + getCacheAge();
    }

    public boolean forceRefresh() {
        boolean flag = false;
        if(mServer != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        SntpClient sntpclient = new SntpClient();
        if(sntpclient.requestTime(mServer, (int)mTimeout)) {
            mHasCache = true;
            mCachedNtpTime = sntpclient.getNtpTime();
            mCachedNtpElapsedRealtime = sntpclient.getNtpTimeReference();
            mCachedNtpCertainty = sntpclient.getRoundTripTime() / 2L;
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public long getCacheAge() {
        long l;
        if(mHasCache)
            l = SystemClock.elapsedRealtime() - mCachedNtpElapsedRealtime;
        else
            l = 0x7fffffffffffffffL;
        return l;
    }

    public long getCacheCertainty() {
        long l;
        if(mHasCache)
            l = mCachedNtpCertainty;
        else
            l = 0x7fffffffffffffffL;
        return l;
    }

    public long getCachedNtpTime() {
        return mCachedNtpTime;
    }

    public long getCachedNtpTimeReference() {
        return mCachedNtpElapsedRealtime;
    }

    public boolean hasCache() {
        return mHasCache;
    }

    private static final boolean LOGD = false;
    private static final String TAG = "NtpTrustedTime";
    private static NtpTrustedTime sSingleton;
    private long mCachedNtpCertainty;
    private long mCachedNtpElapsedRealtime;
    private long mCachedNtpTime;
    private boolean mHasCache;
    private final String mServer;
    private final long mTimeout;
}
