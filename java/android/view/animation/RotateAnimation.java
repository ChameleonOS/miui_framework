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

public class RotateAnimation extends Animation {

    public RotateAnimation(float f, float f1) {
        mPivotXType = 0;
        mPivotYType = 0;
        mPivotXValue = 0.0F;
        mPivotYValue = 0.0F;
        mFromDegrees = f;
        mToDegrees = f1;
        mPivotX = 0.0F;
        mPivotY = 0.0F;
    }

    public RotateAnimation(float f, float f1, float f2, float f3) {
        mPivotXType = 0;
        mPivotYType = 0;
        mPivotXValue = 0.0F;
        mPivotYValue = 0.0F;
        mFromDegrees = f;
        mToDegrees = f1;
        mPivotXType = 0;
        mPivotYType = 0;
        mPivotXValue = f2;
        mPivotYValue = f3;
        initializePivotPoint();
    }

    public RotateAnimation(float f, float f1, int i, float f2, int j, float f3) {
        mPivotXType = 0;
        mPivotYType = 0;
        mPivotXValue = 0.0F;
        mPivotYValue = 0.0F;
        mFromDegrees = f;
        mToDegrees = f1;
        mPivotXValue = f2;
        mPivotXType = i;
        mPivotYValue = f3;
        mPivotYType = j;
        initializePivotPoint();
    }

    public RotateAnimation(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mPivotXType = 0;
        mPivotYType = 0;
        mPivotXValue = 0.0F;
        mPivotYValue = 0.0F;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.RotateAnimation);
        mFromDegrees = typedarray.getFloat(0, 0.0F);
        mToDegrees = typedarray.getFloat(1, 0.0F);
        Animation.Description description = Animation.Description.parseValue(typedarray.peekValue(2));
        mPivotXType = description.type;
        mPivotXValue = description.value;
        Animation.Description description1 = Animation.Description.parseValue(typedarray.peekValue(3));
        mPivotYType = description1.type;
        mPivotYValue = description1.value;
        typedarray.recycle();
        initializePivotPoint();
    }

    private void initializePivotPoint() {
        if(mPivotXType == 0)
            mPivotX = mPivotXValue;
        if(mPivotYType == 0)
            mPivotY = mPivotYValue;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        float f1 = mFromDegrees + f * (mToDegrees - mFromDegrees);
        float f2 = getScaleFactor();
        if(mPivotX == 0.0F && mPivotY == 0.0F)
            transformation.getMatrix().setRotate(f1);
        else
            transformation.getMatrix().setRotate(f1, f2 * mPivotX, f2 * mPivotY);
    }

    public void initialize(int i, int j, int k, int l) {
        super.initialize(i, j, k, l);
        mPivotX = resolveSize(mPivotXType, mPivotXValue, i, k);
        mPivotY = resolveSize(mPivotYType, mPivotYValue, j, l);
    }

    private float mFromDegrees;
    private float mPivotX;
    private int mPivotXType;
    private float mPivotXValue;
    private float mPivotY;
    private int mPivotYType;
    private float mPivotYValue;
    private float mToDegrees;
}
