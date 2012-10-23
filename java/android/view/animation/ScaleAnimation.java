// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.TypedValue;

// Referenced classes of package android.view.animation:
//            Animation, Transformation

public class ScaleAnimation extends Animation {

    public ScaleAnimation(float f, float f1, float f2, float f3) {
        mFromXType = 0;
        mToXType = 0;
        mFromYType = 0;
        mToYType = 0;
        mFromXData = 0;
        mToXData = 0;
        mFromYData = 0;
        mToYData = 0;
        mPivotXType = 0;
        mPivotYType = 0;
        mPivotXValue = 0.0F;
        mPivotYValue = 0.0F;
        mResources = null;
        mFromX = f;
        mToX = f1;
        mFromY = f2;
        mToY = f3;
        mPivotX = 0.0F;
        mPivotY = 0.0F;
    }

    public ScaleAnimation(float f, float f1, float f2, float f3, float f4, float f5) {
        mFromXType = 0;
        mToXType = 0;
        mFromYType = 0;
        mToYType = 0;
        mFromXData = 0;
        mToXData = 0;
        mFromYData = 0;
        mToYData = 0;
        mPivotXType = 0;
        mPivotYType = 0;
        mPivotXValue = 0.0F;
        mPivotYValue = 0.0F;
        mResources = null;
        mFromX = f;
        mToX = f1;
        mFromY = f2;
        mToY = f3;
        mPivotXType = 0;
        mPivotYType = 0;
        mPivotXValue = f4;
        mPivotYValue = f5;
        initializePivotPoint();
    }

    public ScaleAnimation(float f, float f1, float f2, float f3, int i, float f4, int j, 
            float f5) {
        mFromXType = 0;
        mToXType = 0;
        mFromYType = 0;
        mToYType = 0;
        mFromXData = 0;
        mToXData = 0;
        mFromYData = 0;
        mToYData = 0;
        mPivotXType = 0;
        mPivotYType = 0;
        mPivotXValue = 0.0F;
        mPivotYValue = 0.0F;
        mResources = null;
        mFromX = f;
        mToX = f1;
        mFromY = f2;
        mToY = f3;
        mPivotXValue = f4;
        mPivotXType = i;
        mPivotYValue = f5;
        mPivotYType = j;
        initializePivotPoint();
    }

    public ScaleAnimation(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mFromXType = 0;
        mToXType = 0;
        mFromYType = 0;
        mToYType = 0;
        mFromXData = 0;
        mToXData = 0;
        mFromYData = 0;
        mToYData = 0;
        mPivotXType = 0;
        mPivotYType = 0;
        mPivotXValue = 0.0F;
        mPivotYValue = 0.0F;
        mResources = context.getResources();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ScaleAnimation);
        TypedValue typedvalue = typedarray.peekValue(2);
        mFromX = 0.0F;
        TypedValue typedvalue1;
        TypedValue typedvalue2;
        TypedValue typedvalue3;
        Animation.Description description;
        Animation.Description description1;
        if(typedvalue != null)
            if(typedvalue.type == 4) {
                mFromX = typedvalue.getFloat();
            } else {
                mFromXType = typedvalue.type;
                mFromXData = typedvalue.data;
            }
        typedvalue1 = typedarray.peekValue(3);
        mToX = 0.0F;
        if(typedvalue1 != null)
            if(typedvalue1.type == 4) {
                mToX = typedvalue1.getFloat();
            } else {
                mToXType = typedvalue1.type;
                mToXData = typedvalue1.data;
            }
        typedvalue2 = typedarray.peekValue(4);
        mFromY = 0.0F;
        if(typedvalue2 != null)
            if(typedvalue2.type == 4) {
                mFromY = typedvalue2.getFloat();
            } else {
                mFromYType = typedvalue2.type;
                mFromYData = typedvalue2.data;
            }
        typedvalue3 = typedarray.peekValue(5);
        mToY = 0.0F;
        if(typedvalue3 != null)
            if(typedvalue3.type == 4) {
                mToY = typedvalue3.getFloat();
            } else {
                mToYType = typedvalue3.type;
                mToYData = typedvalue3.data;
            }
        description = Animation.Description.parseValue(typedarray.peekValue(0));
        mPivotXType = description.type;
        mPivotXValue = description.value;
        description1 = Animation.Description.parseValue(typedarray.peekValue(1));
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
        float f1 = 1.0F;
        float f2 = 1.0F;
        float f3 = getScaleFactor();
        if(mFromX != 1.0F || mToX != 1.0F)
            f1 = mFromX + f * (mToX - mFromX);
        if(mFromY != 1.0F || mToY != 1.0F)
            f2 = mFromY + f * (mToY - mFromY);
        if(mPivotX == 0.0F && mPivotY == 0.0F)
            transformation.getMatrix().setScale(f1, f2);
        else
            transformation.getMatrix().setScale(f1, f2, f3 * mPivotX, f3 * mPivotY);
    }

    public void initialize(int i, int j, int k, int l) {
        super.initialize(i, j, k, l);
        mFromX = resolveScale(mFromX, mFromXType, mFromXData, i, k);
        mToX = resolveScale(mToX, mToXType, mToXData, i, k);
        mFromY = resolveScale(mFromY, mFromYType, mFromYData, j, l);
        mToY = resolveScale(mToY, mToYType, mToYData, j, l);
        mPivotX = resolveSize(mPivotXType, mPivotXValue, i, k);
        mPivotY = resolveSize(mPivotYType, mPivotYValue, j, l);
    }

    float resolveScale(float f, int i, int j, int k, int l) {
        if(i != 6) goto _L2; else goto _L1
_L1:
        float f1 = TypedValue.complexToFraction(j, k, l);
_L5:
        if(k == 0)
            f = 1.0F;
        else
            f = f1 / (float)k;
_L4:
        return f;
_L2:
        if(i != 5) goto _L4; else goto _L3
_L3:
        f1 = TypedValue.complexToDimension(j, mResources.getDisplayMetrics());
          goto _L5
    }

    private float mFromX;
    private int mFromXData;
    private int mFromXType;
    private float mFromY;
    private int mFromYData;
    private int mFromYType;
    private float mPivotX;
    private int mPivotXType;
    private float mPivotXValue;
    private float mPivotY;
    private int mPivotYType;
    private float mPivotYValue;
    private final Resources mResources;
    private float mToX;
    private int mToXData;
    private int mToXType;
    private float mToY;
    private int mToYData;
    private int mToYType;
}
