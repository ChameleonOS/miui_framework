// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.*;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            Drawable

public class RotateDrawable extends Drawable
    implements Drawable.Callback {
    static final class RotateState extends Drawable.ConstantState {

        public boolean canConstantState() {
            if(!mCheckedConstantState) {
                boolean flag;
                if(mDrawable.getConstantState() != null)
                    flag = true;
                else
                    flag = false;
                mCanConstantState = flag;
                mCheckedConstantState = true;
            }
            return mCanConstantState;
        }

        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        public Drawable newDrawable() {
            return new RotateDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new RotateDrawable(this, resources);
        }

        private boolean mCanConstantState;
        int mChangingConfigurations;
        private boolean mCheckedConstantState;
        float mCurrentDegrees;
        Drawable mDrawable;
        float mFromDegrees;
        float mPivotX;
        boolean mPivotXRel;
        float mPivotY;
        boolean mPivotYRel;
        float mToDegrees;

        public RotateState(RotateState rotatestate, RotateDrawable rotatedrawable, Resources resources) {
            if(rotatestate != null) {
                float f;
                if(resources != null)
                    mDrawable = rotatestate.mDrawable.getConstantState().newDrawable(resources);
                else
                    mDrawable = rotatestate.mDrawable.getConstantState().newDrawable();
                mDrawable.setCallback(rotatedrawable);
                mPivotXRel = rotatestate.mPivotXRel;
                mPivotX = rotatestate.mPivotX;
                mPivotYRel = rotatestate.mPivotYRel;
                mPivotY = rotatestate.mPivotY;
                f = rotatestate.mFromDegrees;
                mCurrentDegrees = f;
                mFromDegrees = f;
                mToDegrees = rotatestate.mToDegrees;
                mCheckedConstantState = true;
                mCanConstantState = true;
            }
        }
    }


    public RotateDrawable() {
        this(null, null);
    }

    private RotateDrawable(RotateState rotatestate, Resources resources) {
        mState = new RotateState(rotatestate, this, resources);
    }


    public void draw(Canvas canvas) {
        int i = canvas.save();
        Rect rect = mState.mDrawable.getBounds();
        int j = rect.right - rect.left;
        int k = rect.bottom - rect.top;
        RotateState rotatestate = mState;
        float f;
        float f1;
        if(rotatestate.mPivotXRel)
            f = (float)j * rotatestate.mPivotX;
        else
            f = rotatestate.mPivotX;
        if(rotatestate.mPivotYRel)
            f1 = (float)k * rotatestate.mPivotY;
        else
            f1 = rotatestate.mPivotY;
        canvas.rotate(rotatestate.mCurrentDegrees, f + (float)rect.left, f1 + (float)rect.top);
        rotatestate.mDrawable.draw(canvas);
        canvas.restoreToCount(i);
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mState.mChangingConfigurations | mState.mDrawable.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        RotateState rotatestate;
        if(mState.canConstantState()) {
            mState.mChangingConfigurations = getChangingConfigurations();
            rotatestate = mState;
        } else {
            rotatestate = null;
        }
        return rotatestate;
    }

    public Drawable getDrawable() {
        return mState.mDrawable;
    }

    public int getIntrinsicHeight() {
        return mState.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return mState.mDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        return mState.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return mState.mDrawable.getPadding(rect);
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.RotateDrawable);
        super.inflateWithAttributes(resources, xmlpullparser, typedarray, 0);
        TypedValue typedvalue = typedarray.peekValue(4);
        boolean flag;
        float f;
        TypedValue typedvalue1;
        boolean flag1;
        float f1;
        float f2;
        float f3;
        int i;
        Drawable drawable;
        int j;
        if(typedvalue == null) {
            flag = true;
            f = 0.5F;
        } else {
            if(typedvalue.type == 6)
                flag = true;
            else
                flag = false;
            if(flag)
                f = typedvalue.getFraction(1.0F, 1.0F);
            else
                f = typedvalue.getFloat();
        }
        typedvalue1 = typedarray.peekValue(5);
        if(typedvalue1 == null) {
            flag1 = true;
            f1 = 0.5F;
        } else {
            if(typedvalue1.type == 6)
                flag1 = true;
            else
                flag1 = false;
            if(flag1)
                f1 = typedvalue1.getFraction(1.0F, 1.0F);
            else
                f1 = typedvalue1.getFloat();
        }
        f2 = typedarray.getFloat(2, 0.0F);
        f3 = typedarray.getFloat(3, 360F);
        i = typedarray.getResourceId(1, 0);
        drawable = null;
        if(i > 0)
            drawable = resources.getDrawable(i);
        typedarray.recycle();
        j = xmlpullparser.getDepth();
        do {
            int k = xmlpullparser.next();
            if(k == 1 || k == 3 && xmlpullparser.getDepth() <= j)
                break;
            if(k == 2) {
                drawable = Drawable.createFromXmlInner(resources, xmlpullparser, attributeset);
                if(drawable == null)
                    Log.w("drawable", (new StringBuilder()).append("Bad element under <rotate>: ").append(xmlpullparser.getName()).toString());
            }
        } while(true);
        if(drawable == null)
            Log.w("drawable", "No drawable specified for <rotate>");
        mState.mDrawable = drawable;
        mState.mPivotXRel = flag;
        mState.mPivotX = f;
        mState.mPivotYRel = flag1;
        mState.mPivotY = f1;
        RotateState rotatestate = mState;
        mState.mCurrentDegrees = f2;
        rotatestate.mFromDegrees = f2;
        mState.mToDegrees = f3;
        if(drawable != null)
            drawable.setCallback(this);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.invalidateDrawable(this);
    }

    public boolean isStateful() {
        return mState.mDrawable.isStateful();
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            mState.mDrawable.mutate();
            mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        mState.mDrawable.setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    protected boolean onLevelChange(int i) {
        mState.mDrawable.setLevel(i);
        onBoundsChange(getBounds());
        mState.mCurrentDegrees = mState.mFromDegrees + (mState.mToDegrees - mState.mFromDegrees) * ((float)i / 10000F);
        invalidateSelf();
        return true;
    }

    protected boolean onStateChange(int ai[]) {
        boolean flag = mState.mDrawable.setState(ai);
        onBoundsChange(getBounds());
        return flag;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.scheduleDrawable(this, runnable, l);
    }

    public void setAlpha(int i) {
        mState.mDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter) {
        mState.mDrawable.setColorFilter(colorfilter);
    }

    public boolean setVisible(boolean flag, boolean flag1) {
        mState.mDrawable.setVisible(flag, flag1);
        return super.setVisible(flag, flag1);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.unscheduleDrawable(this, runnable);
    }

    private static final float MAX_LEVEL = 10000F;
    private boolean mMutated;
    private RotateState mState;
}
