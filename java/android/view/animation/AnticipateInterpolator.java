// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package android.view.animation:
//            Interpolator

public class AnticipateInterpolator
    implements Interpolator {

    public AnticipateInterpolator() {
        mTension = 2.0F;
    }

    public AnticipateInterpolator(float f) {
        mTension = f;
    }

    public AnticipateInterpolator(Context context, AttributeSet attributeset) {
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.AnticipateInterpolator);
        mTension = typedarray.getFloat(0, 2.0F);
        typedarray.recycle();
    }

    public float getInterpolation(float f) {
        return f * f * (f * (1.0F + mTension) - mTension);
    }

    private final float mTension;
}
