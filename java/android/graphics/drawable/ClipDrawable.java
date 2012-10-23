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

public class ClipDrawable extends Drawable
    implements Drawable.Callback {
    static final class ClipState extends Drawable.ConstantState {

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
            return new ClipDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new ClipDrawable(this, resources);
        }

        private boolean mCanConstantState;
        int mChangingConfigurations;
        private boolean mCheckedConstantState;
        Drawable mDrawable;
        int mGravity;
        int mOrientation;

        ClipState(ClipState clipstate, ClipDrawable clipdrawable, Resources resources) {
            if(clipstate != null) {
                if(resources != null)
                    mDrawable = clipstate.mDrawable.getConstantState().newDrawable(resources);
                else
                    mDrawable = clipstate.mDrawable.getConstantState().newDrawable();
                mDrawable.setCallback(clipdrawable);
                mOrientation = clipstate.mOrientation;
                mGravity = clipstate.mGravity;
                mCanConstantState = true;
                mCheckedConstantState = true;
            }
        }
    }


    ClipDrawable() {
        this(null, null);
    }

    private ClipDrawable(ClipState clipstate, Resources resources) {
        mTmpRect = new Rect();
        mClipState = new ClipState(clipstate, this, resources);
    }


    public ClipDrawable(Drawable drawable, int i, int j) {
        this(null, null);
        mClipState.mDrawable = drawable;
        mClipState.mGravity = i;
        mClipState.mOrientation = j;
        if(drawable != null)
            drawable.setCallback(this);
    }

    public void draw(Canvas canvas) {
        if(mClipState.mDrawable.getLevel() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Rect rect = mTmpRect;
        Rect rect1 = getBounds();
        int i = getLevel();
        int j = rect1.width();
        if((1 & mClipState.mOrientation) != 0)
            j -= ((j + 0) * (10000 - i)) / 10000;
        int k = rect1.height();
        if((2 & mClipState.mOrientation) != 0)
            k -= ((k + 0) * (10000 - i)) / 10000;
        int l = getResolvedLayoutDirectionSelf();
        Gravity.apply(mClipState.mGravity, j, k, rect1, rect, l);
        if(j > 0 && k > 0) {
            canvas.save();
            canvas.clipRect(rect);
            mClipState.mDrawable.draw(canvas);
            canvas.restore();
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mClipState.mChangingConfigurations | mClipState.mDrawable.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        ClipState clipstate;
        if(mClipState.canConstantState()) {
            mClipState.mChangingConfigurations = getChangingConfigurations();
            clipstate = mClipState;
        } else {
            clipstate = null;
        }
        return clipstate;
    }

    public int getIntrinsicHeight() {
        return mClipState.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return mClipState.mDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        return mClipState.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return mClipState.mDrawable.getPadding(rect);
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlpullparser, attributeset);
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.ClipDrawable);
        int i = typedarray.getInt(2, 1);
        int j = typedarray.getInt(0, 3);
        Drawable drawable = typedarray.getDrawable(1);
        typedarray.recycle();
        int k = xmlpullparser.getDepth();
        do {
            int l = xmlpullparser.next();
            if(l == 1 || l == 3 && xmlpullparser.getDepth() <= k)
                break;
            if(l == 2)
                drawable = Drawable.createFromXmlInner(resources, xmlpullparser, attributeset);
        } while(true);
        if(drawable == null) {
            throw new IllegalArgumentException("No drawable specified for <clip>");
        } else {
            mClipState.mDrawable = drawable;
            mClipState.mOrientation = i;
            mClipState.mGravity = j;
            drawable.setCallback(this);
            return;
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.invalidateDrawable(this);
    }

    public boolean isStateful() {
        return mClipState.mDrawable.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        mClipState.mDrawable.setBounds(rect);
    }

    protected boolean onLevelChange(int i) {
        mClipState.mDrawable.setLevel(i);
        invalidateSelf();
        return true;
    }

    protected boolean onStateChange(int ai[]) {
        return mClipState.mDrawable.setState(ai);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.scheduleDrawable(this, runnable, l);
    }

    public void setAlpha(int i) {
        mClipState.mDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter) {
        mClipState.mDrawable.setColorFilter(colorfilter);
    }

    public boolean setVisible(boolean flag, boolean flag1) {
        mClipState.mDrawable.setVisible(flag, flag1);
        return super.setVisible(flag, flag1);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if(callback != null)
            callback.unscheduleDrawable(this, runnable);
    }

    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    private ClipState mClipState;
    private final Rect mTmpRect;
}
