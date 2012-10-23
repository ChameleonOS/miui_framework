// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package android.view.animation:
//            Animation, Transformation

public class AlphaAnimation extends Animation {

    public AlphaAnimation(float f, float f1) {
        mFromAlpha = f;
        mToAlpha = f1;
    }

    public AlphaAnimation(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.AlphaAnimation);
        mFromAlpha = typedarray.getFloat(0, 1.0F);
        mToAlpha = typedarray.getFloat(1, 1.0F);
        typedarray.recycle();
    }

    protected void applyTransformation(float f, Transformation transformation) {
        float f1 = mFromAlpha;
        transformation.setAlpha(f1 + f * (mToAlpha - f1));
    }

    public boolean hasAlpha() {
        return true;
    }

    public boolean willChangeBounds() {
        return false;
    }

    public boolean willChangeTransformationMatrix() {
        return false;
    }

    private float mFromAlpha;
    private float mToAlpha;
}
