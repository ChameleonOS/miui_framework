// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package android.view.animation:
//            Interpolator

public class OvershootInterpolator
    implements Interpolator {

    public OvershootInterpolator() {
        mTension = 2.0F;
    }

    public OvershootInterpolator(float f) {
        mTension = f;
    }

    public OvershootInterpolator(Context context, AttributeSet attributeset) {
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.OvershootInterpolator);
        mTension = typedarray.getFloat(0, 2.0F);
        typedarray.recycle();
    }

    public float getInterpolation(float f) {
        float f1 = f - 1.0F;
        return 1.0F + f1 * f1 * (f1 * (1.0F + mTension) + mTension);
    }

    private final float mTension;
}
