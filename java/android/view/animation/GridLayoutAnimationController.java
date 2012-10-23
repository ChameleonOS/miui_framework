// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import java.util.Random;

// Referenced classes of package android.view.animation:
//            LayoutAnimationController, Animation, LinearInterpolator, Interpolator

public class GridLayoutAnimationController extends LayoutAnimationController {
    public static class AnimationParameters extends LayoutAnimationController.AnimationParameters {

        public int column;
        public int columnsCount;
        public int row;
        public int rowsCount;

        public AnimationParameters() {
        }
    }


    public GridLayoutAnimationController(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.GridLayoutAnimation);
        mColumnDelay = Animation.Description.parseValue(typedarray.peekValue(0)).value;
        mRowDelay = Animation.Description.parseValue(typedarray.peekValue(1)).value;
        mDirection = typedarray.getInt(2, 0);
        mDirectionPriority = typedarray.getInt(3, 0);
        typedarray.recycle();
    }

    public GridLayoutAnimationController(Animation animation) {
        this(animation, 0.5F, 0.5F);
    }

    public GridLayoutAnimationController(Animation animation, float f, float f1) {
        super(animation);
        mColumnDelay = f;
        mRowDelay = f1;
    }

    private int getTransformedColumnIndex(AnimationParameters animationparameters) {
        getOrder();
        JVM INSTR tableswitch 1 2: default 28
    //                   1 55
    //                   2 71;
           goto _L1 _L2 _L3
_L1:
        int i = animationparameters.column;
_L5:
        if((1 & mDirection) == 1)
            i = (-1 + animationparameters.columnsCount) - i;
        return i;
_L2:
        i = (-1 + animationparameters.columnsCount) - animationparameters.column;
        continue; /* Loop/switch isn't completed */
_L3:
        if(super.mRandomizer == null)
            super.mRandomizer = new Random();
        i = (int)((float)animationparameters.columnsCount * super.mRandomizer.nextFloat());
        if(true) goto _L5; else goto _L4
_L4:
    }

    private int getTransformedRowIndex(AnimationParameters animationparameters) {
        getOrder();
        JVM INSTR tableswitch 1 2: default 28
    //                   1 55
    //                   2 71;
           goto _L1 _L2 _L3
_L1:
        int i = animationparameters.row;
_L5:
        if((2 & mDirection) == 2)
            i = (-1 + animationparameters.rowsCount) - i;
        return i;
_L2:
        i = (-1 + animationparameters.rowsCount) - animationparameters.row;
        continue; /* Loop/switch isn't completed */
_L3:
        if(super.mRandomizer == null)
            super.mRandomizer = new Random();
        i = (int)((float)animationparameters.rowsCount * super.mRandomizer.nextFloat());
        if(true) goto _L5; else goto _L4
_L4:
    }

    public float getColumnDelay() {
        return mColumnDelay;
    }

    protected long getDelayForView(View view) {
        AnimationParameters animationparameters = (AnimationParameters)view.getLayoutParams().layoutAnimationParameters;
        if(animationparameters != null) goto _L2; else goto _L1
_L1:
        long l3 = 0L;
_L4:
        return l3;
_L2:
        int i;
        int j;
        int k;
        int l;
        float f;
        float f1;
        long l2;
        float f2;
        i = getTransformedColumnIndex(animationparameters);
        j = getTransformedRowIndex(animationparameters);
        k = animationparameters.rowsCount;
        l = animationparameters.columnsCount;
        long l1 = super.mAnimation.getDuration();
        f = mColumnDelay * (float)l1;
        f1 = mRowDelay * (float)l1;
        if(super.mInterpolator == null)
            super.mInterpolator = new LinearInterpolator();
        switch(mDirectionPriority) {
        default:
            l2 = (long)(f * (float)i + f1 * (float)j);
            f2 = f * (float)l + f1 * (float)k;
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_217;
        }
_L5:
        float f3 = (float)l2 / f2;
        l3 = (long)(f2 * super.mInterpolator.getInterpolation(f3));
        if(true) goto _L4; else goto _L3
_L3:
        l2 = (long)(f1 * (float)j + f1 * (float)(i * k));
        f2 = f1 * (float)k + f1 * (float)(l * k);
          goto _L5
        l2 = (long)(f * (float)i + f * (float)(j * l));
        f2 = f * (float)l + f * (float)(k * l);
          goto _L5
    }

    public int getDirection() {
        return mDirection;
    }

    public int getDirectionPriority() {
        return mDirectionPriority;
    }

    public float getRowDelay() {
        return mRowDelay;
    }

    public void setColumnDelay(float f) {
        mColumnDelay = f;
    }

    public void setDirection(int i) {
        mDirection = i;
    }

    public void setDirectionPriority(int i) {
        mDirectionPriority = i;
    }

    public void setRowDelay(float f) {
        mRowDelay = f;
    }

    public boolean willOverlap() {
        boolean flag;
        if(mColumnDelay < 1.0F || mRowDelay < 1.0F)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final int DIRECTION_BOTTOM_TO_TOP = 2;
    public static final int DIRECTION_HORIZONTAL_MASK = 1;
    public static final int DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int DIRECTION_TOP_TO_BOTTOM = 0;
    public static final int DIRECTION_VERTICAL_MASK = 2;
    public static final int PRIORITY_COLUMN = 1;
    public static final int PRIORITY_NONE = 0;
    public static final int PRIORITY_ROW = 2;
    private float mColumnDelay;
    private int mDirection;
    private int mDirectionPriority;
    private float mRowDelay;
}
