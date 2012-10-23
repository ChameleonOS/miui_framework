// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.Gravity;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            Drawable

public class ScaleDrawable extends Drawable
    implements Drawable.Callback {
    static final class ScaleState extends Drawable.ConstantState {

        boolean canConstantState() {
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
            return new ScaleDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new ScaleDrawable(this, resources);
        }

        private boolean mCanConstantState;
        int mChangingConfigurations;
        private boolean mCheckedConstantState;
        Drawable mDrawable;
        int mGravity;
        float mScaleHeight;
        float mScaleWidth;
        boolean mUseIntrinsicSizeAsMin;

        ScaleState(ScaleState scalestate, ScaleDrawable scaledrawable, Resources resources) {
            if(scalestate != null) {
                if(resources != null)
                    mDrawable = scalestate.mDrawable.getConstantState().newDrawable(resources);
                else
                    mDrawable = scalestate.mDrawable.getConstantState().newDrawable();
                mDrawable.setCallback(scaledrawable);
                mScaleWidth = scalestate.mScaleWidth;
                mScaleHeight = scalestate.mScaleHeight;
                mGravity = scalestate.mGravity;
                mUseIntrinsicSizeAsMin = scalestate.mUseIntrinsicSizeAsMin;
                mCanConstantState = true;
                mCheckedConstantState = true;
            }
        }
    }


    ScaleDrawable() {
        this(null, null);
    }

    public ScaleDrawable(Drawable drawable, int i, float f, float f1) {
        this(null, null);
        mScaleState.mDrawable = drawable;
        mScaleState.mGravity = i;
        mScaleState.mScaleWidth = f;
        mScaleState.mScaleHeight = f1;
        if(drawable != null)
            drawable.setCallback(this);
    }

    private ScaleDrawable(ScaleState scalestate, Resources resources) {
        mTmpRect = new Rect();
        mScaleState = new ScaleState(scalestate, this, resources);
    }


    private static float getPercent(TypedArray typedarray, int i) {
        String s = typedarray.getString(i);
        float f;
        if(s != null && s.endsWith("%"))
            f = Float.parseFloat(s.substring(0, -1 + s.length())) / 100F;
        else
            f = -1F;
        return f;
    }

    public void draw(Canvas canvas) {
        if(mScaleState.mDrawable.getLevel() != 0)
            mScaleState.mDrawable.draw(canvas);
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mScaleState.mChangingConfigurations | mScaleState.mDrawable.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        ScaleState scalestate;
        if(mScaleState.canConstantState()) {
            mScaleState.mChangingConfigurations = getChangingConfigurations();
            scalestate = mScaleState;
        } else {
            scalestate = null;
        }
        return scalestate;
    }

    public Drawable getDrawable() {
        return mScaleState.mDrawable;
    }

    public int getIntrinsicHeight() {
        return mScaleState.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return mScaleState.mDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        return mScaleState.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return mScaleState.mDrawable.getPadding(rect);
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlpullparser, attributeset);
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.ScaleDrawable);
        float f = getPercent(typedarray, 1);
        float f1 = getPercent(typedarray, 2);
        int i = typedarray.getInt(3, 3);
        boolean flag = typedarray.getBoolean(4, false);
        Drawable drawable = typedarray.getDrawable(0);
        typedarray.recycle();
        int j = xmlpullparser.getDepth();
        do {
            int k = xmlpullparser.next();
            if(k == 1 || k == 3 && xmlpullparser.getDepth() <= j)
                break;
            if(k == 2)
                drawable = Drawable.createFromXmlInner(resources, xmlpullparser, attributeset);
        } while(true);
        if(drawable == null)
            throw new IllegalArgumentException("No drawable specified for <scale>");
        mScaleState.mDrawable = drawable;
        mScaleState.mScaleWidth = f;
        mScaleState.mScaleHeight = f1;
        mScaleState.mGravity = i;
        mScaleState.mUseIntrinsicSizeAsMin = flag;
        if(drawable != null)
            drawable.setCallback(this);
    }

    public void invalidateDrawable(Drawable drawable) {
        if(getCallback() != null)
            getCallback().invalidateDrawable(this);
    }

    public boolean isStateful() {
        return mScaleState.mDrawable.isStateful();
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            mScaleState.mDrawable.mutate();
            mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        Rect rect1 = mTmpRect;
        boolean flag = mScaleState.mUseIntrinsicSizeAsMin;
        int i = getLevel();
        int j = rect.width();
        if(mScaleState.mScaleWidth > 0.0F) {
            int k;
            int l;
            int j1;
            if(flag)
                j1 = mScaleState.mDrawable.getIntrinsicWidth();
            else
                j1 = 0;
            j -= (int)(((float)((j - j1) * (10000 - i)) * mScaleState.mScaleWidth) / 10000F);
        }
        k = rect.height();
        if(mScaleState.mScaleHeight > 0.0F) {
            int i1;
            if(flag)
                i1 = mScaleState.mDrawable.getIntrinsicHeight();
            else
                i1 = 0;
            k -= (int)(((float)((k - i1) * (10000 - i)) * mScaleState.mScaleHeight) / 10000F);
        }
        l = getResolvedLayoutDirectionSelf();
        Gravity.apply(mScaleState.mGravity, j, k, rect, rect1, l);
        if(j > 0 && k > 0)
            mScaleState.mDrawable.setBounds(rect1.left, rect1.top, rect1.right, rect1.bottom);
    }

    protected boolean onLevelChange(int i) {
        mScaleState.mDrawable.setLevel(i);
        onBoundsChange(getBounds());
        invalidateSelf();
        return true;
    }

    protected boolean onStateChange(int ai[]) {
        boolean flag = mScaleState.mDrawable.setState(ai);
        onBoundsChange(getBounds());
        return flag;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        if(getCallback() != null)
            getCallback().scheduleDrawable(this, runnable, l);
    }

    public void setAlpha(int i) {
        mScaleState.mDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter) {
        mScaleState.mDrawable.setColorFilter(colorfilter);
    }

    public boolean setVisible(boolean flag, boolean flag1) {
        mScaleState.mDrawable.setVisible(flag, flag1);
        return super.setVisible(flag, flag1);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if(getCallback() != null)
            getCallback().unscheduleDrawable(this, runnable);
    }

    private boolean mMutated;
    private ScaleState mScaleState;
    private final Rect mTmpRect;
}
