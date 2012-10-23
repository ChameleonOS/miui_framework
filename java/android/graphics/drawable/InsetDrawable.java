// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            Drawable

public class InsetDrawable extends Drawable
    implements Drawable.Callback {
    static final class InsetState extends Drawable.ConstantState {

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
            return new InsetDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new InsetDrawable(this, resources);
        }

        boolean mCanConstantState;
        int mChangingConfigurations;
        boolean mCheckedConstantState;
        Drawable mDrawable;
        int mInsetBottom;
        int mInsetLeft;
        int mInsetRight;
        int mInsetTop;

        InsetState(InsetState insetstate, InsetDrawable insetdrawable, Resources resources) {
            if(insetstate != null) {
                if(resources != null)
                    mDrawable = insetstate.mDrawable.getConstantState().newDrawable(resources);
                else
                    mDrawable = insetstate.mDrawable.getConstantState().newDrawable();
                mDrawable.setCallback(insetdrawable);
                mInsetLeft = insetstate.mInsetLeft;
                mInsetTop = insetstate.mInsetTop;
                mInsetRight = insetstate.mInsetRight;
                mInsetBottom = insetstate.mInsetBottom;
                mCanConstantState = true;
                mCheckedConstantState = true;
            }
        }
    }


    InsetDrawable() {
        this(((InsetState) (null)), ((Resources) (null)));
    }

    public InsetDrawable(Drawable drawable, int i) {
        this(drawable, i, i, i, i);
    }

    public InsetDrawable(Drawable drawable, int i, int j, int k, int l) {
        this(((InsetState) (null)), ((Resources) (null)));
        mInsetState.mDrawable = drawable;
        mInsetState.mInsetLeft = i;
        mInsetState.mInsetTop = j;
        mInsetState.mInsetRight = k;
        mInsetState.mInsetBottom = l;
        if(drawable != null)
            drawable.setCallback(this);
    }

    private InsetDrawable(InsetState insetstate, Resources resources) {
        mTmpRect = new Rect();
        mInsetState = new InsetState(insetstate, this, resources);
    }


    public void draw(Canvas canvas) {
        mInsetState.mDrawable.draw(canvas);
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mInsetState.mChangingConfigurations | mInsetState.mDrawable.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        InsetState insetstate;
        if(mInsetState.canConstantState()) {
            mInsetState.mChangingConfigurations = getChangingConfigurations();
            insetstate = mInsetState;
        } else {
            insetstate = null;
        }
        return insetstate;
    }

    public int getIntrinsicHeight() {
        return mInsetState.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return mInsetState.mDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        return mInsetState.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        boolean flag = mInsetState.mDrawable.getPadding(rect);
        rect.left = rect.left + mInsetState.mInsetLeft;
        rect.right = rect.right + mInsetState.mInsetRight;
        rect.top = rect.top + mInsetState.mInsetTop;
        rect.bottom = rect.bottom + mInsetState.mInsetBottom;
        boolean flag1;
        if(flag || (mInsetState.mInsetLeft | mInsetState.mInsetRight | mInsetState.mInsetTop | mInsetState.mInsetBottom) != 0)
            flag1 = true;
        else
            flag1 = false;
        return flag1;
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.InsetDrawable);
        super.inflateWithAttributes(resources, xmlpullparser, typedarray, 0);
        int i = typedarray.getResourceId(1, 0);
        int j = typedarray.getDimensionPixelOffset(2, 0);
        int k = typedarray.getDimensionPixelOffset(4, 0);
        int l = typedarray.getDimensionPixelOffset(3, 0);
        int i1 = typedarray.getDimensionPixelOffset(5, 0);
        typedarray.recycle();
        Drawable drawable;
        if(i != 0) {
            drawable = resources.getDrawable(i);
        } else {
            int j1;
            do
                j1 = xmlpullparser.next();
            while(j1 == 4);
            if(j1 != 2)
                throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <inset> tag requires a 'drawable' attribute or ").append("child tag defining a drawable").toString());
            drawable = Drawable.createFromXmlInner(resources, xmlpullparser, attributeset);
        }
        if(drawable == null)
            Log.w("drawable", "No drawable specified for <inset>");
        mInsetState.mDrawable = drawable;
        mInsetState.mInsetLeft = j;
        mInsetState.mInsetRight = l;
        mInsetState.mInsetTop = k;
        mInsetState.mInsetBottom = i1;
        if(drawable != null)
            drawable.setCallback(this);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.invalidateDrawable(this);
    }

    public boolean isStateful() {
        return mInsetState.mDrawable.isStateful();
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            mInsetState.mDrawable.mutate();
            mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        Rect rect1 = mTmpRect;
        rect1.set(rect);
        rect1.left = rect1.left + mInsetState.mInsetLeft;
        rect1.top = rect1.top + mInsetState.mInsetTop;
        rect1.right = rect1.right - mInsetState.mInsetRight;
        rect1.bottom = rect1.bottom - mInsetState.mInsetBottom;
        mInsetState.mDrawable.setBounds(rect1.left, rect1.top, rect1.right, rect1.bottom);
    }

    protected boolean onStateChange(int ai[]) {
        boolean flag = mInsetState.mDrawable.setState(ai);
        onBoundsChange(getBounds());
        return flag;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.scheduleDrawable(this, runnable, l);
    }

    public void setAlpha(int i) {
        mInsetState.mDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter) {
        mInsetState.mDrawable.setColorFilter(colorfilter);
    }

    public boolean setVisible(boolean flag, boolean flag1) {
        mInsetState.mDrawable.setVisible(flag, flag1);
        return super.setVisible(flag, flag1);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.unscheduleDrawable(this, runnable);
    }

    private InsetState mInsetState;
    private boolean mMutated;
    private final Rect mTmpRect;
}
