// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.animation;

import android.animation.TimeInterpolator;

public class DampingInterpolator
    implements TimeInterpolator {

    public DampingInterpolator(float f) {
        mFactor = f;
        mAtanValue = Math.atan(mFactor);
    }

    public float getInterpolation(float f) {
        return (float)(Math.atan(f * mFactor) / mAtanValue);
    }

    private final double mAtanValue;
    private final float mFactor;
}
