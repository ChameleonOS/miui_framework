// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;

// Referenced classes of package android.view.animation:
//            Animation, Transformation

public class TranslateAnimation extends Animation {

    public TranslateAnimation(float f, float f1, float f2, float f3) {
        mFromXType = 0;
        mToXType = 0;
        mFromYType = 0;
        mToYType = 0;
        mFromXValue = 0.0F;
        mToXValue = 0.0F;
        mFromYValue = 0.0F;
        mToYValue = 0.0F;
        mFromXValue = f;
        mToXValue = f1;
        mFromYValue = f2;
        mToYValue = f3;
        mFromXType = 0;
        mToXType = 0;
        mFromYType = 0;
        mToYType = 0;
    }

    public TranslateAnimation(int i, float f, int j, float f1, int k, float f2, int l, 
            float f3) {
        mFromXType = 0;
        mToXType = 0;
        mFromYType = 0;
        mToYType = 0;
        mFromXValue = 0.0F;
        mToXValue = 0.0F;
        mFromYValue = 0.0F;
        mToYValue = 0.0F;
        mFromXValue = f;
        mToXValue = f1;
        mFromYValue = f2;
        mToYValue = f3;
        mFromXType = i;
        mToXType = j;
        mFromYType = k;
        mToYType = l;
    }

    public TranslateAnimation(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mFromXType = 0;
        mToXType = 0;
        mFromYType = 0;
        mToYType = 0;
        mFromXValue = 0.0F;
        mToXValue = 0.0F;
        mFromYValue = 0.0F;
        mToYValue = 0.0F;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.TranslateAnimation);
        Animation.Description description = Animation.Description.parseValue(typedarray.peekValue(0));
        mFromXType = description.type;
        mFromXValue = description.value;
        Animation.Description description1 = Animation.Description.parseValue(typedarray.peekValue(1));
        mToXType = description1.type;
        mToXValue = description1.value;
        Animation.Description description2 = Animation.Description.parseValue(typedarray.peekValue(2));
        mFromYType = description2.type;
        mFromYValue = description2.value;
        Animation.Description description3 = Animation.Description.parseValue(typedarray.peekValue(3));
        mToYType = description3.type;
        mToYValue = description3.value;
        typedarray.recycle();
    }

    protected void applyTransformation(float f, Transformation transformation) {
        float f1 = mFromXDelta;
        float f2 = mFromYDelta;
        if(mFromXDelta != mToXDelta)
            f1 = mFromXDelta + f * (mToXDelta - mFromXDelta);
        if(mFromYDelta != mToYDelta)
            f2 = mFromYDelta + f * (mToYDelta - mFromYDelta);
        transformation.getMatrix().setTranslate(f1, f2);
    }

    public void initialize(int i, int j, int k, int l) {
        super.initialize(i, j, k, l);
        mFromXDelta = resolveSize(mFromXType, mFromXValue, i, k);
        mToXDelta = resolveSize(mToXType, mToXValue, i, k);
        mFromYDelta = resolveSize(mFromYType, mFromYValue, j, l);
        mToYDelta = resolveSize(mToYType, mToYValue, j, l);
    }

    private float mFromXDelta;
    private int mFromXType;
    private float mFromXValue;
    private float mFromYDelta;
    private int mFromYType;
    private float mFromYValue;
    private float mToXDelta;
    private int mToXType;
    private float mToXValue;
    private float mToYDelta;
    private int mToYType;
    private float mToYValue;
}
