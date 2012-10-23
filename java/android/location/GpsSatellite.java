// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;


public final class GpsSatellite {

    GpsSatellite(int i) {
        mPrn = i;
    }

    public float getAzimuth() {
        return mAzimuth;
    }

    public float getElevation() {
        return mElevation;
    }

    public int getPrn() {
        return mPrn;
    }

    public float getSnr() {
        return mSnr;
    }

    public boolean hasAlmanac() {
        return mHasAlmanac;
    }

    public boolean hasEphemeris() {
        return mHasEphemeris;
    }

    void setStatus(GpsSatellite gpssatellite) {
        mValid = gpssatellite.mValid;
        mHasEphemeris = gpssatellite.mHasEphemeris;
        mHasAlmanac = gpssatellite.mHasAlmanac;
        mUsedInFix = gpssatellite.mUsedInFix;
        mSnr = gpssatellite.mSnr;
        mElevation = gpssatellite.mElevation;
        mAzimuth = gpssatellite.mAzimuth;
    }

    public boolean usedInFix() {
        return mUsedInFix;
    }

    float mAzimuth;
    float mElevation;
    boolean mHasAlmanac;
    boolean mHasEphemeris;
    int mPrn;
    float mSnr;
    boolean mUsedInFix;
    boolean mValid;
}
