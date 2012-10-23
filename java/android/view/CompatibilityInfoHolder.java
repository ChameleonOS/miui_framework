// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.res.CompatibilityInfo;

public class CompatibilityInfoHolder {

    public CompatibilityInfoHolder() {
        mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    }

    public CompatibilityInfo get() {
        return mCompatInfo;
    }

    public CompatibilityInfo getIfNeeded() {
        CompatibilityInfo compatibilityinfo = mCompatInfo;
        if(compatibilityinfo == null || compatibilityinfo == CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO)
            compatibilityinfo = null;
        return compatibilityinfo;
    }

    public void set(CompatibilityInfo compatibilityinfo) {
        if(compatibilityinfo != null && (compatibilityinfo.isScalingRequired() || !compatibilityinfo.supportsScreen()))
            mCompatInfo = compatibilityinfo;
        else
            mCompatInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    }

    private volatile CompatibilityInfo mCompatInfo;
}
