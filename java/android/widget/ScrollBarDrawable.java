// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.graphics.*;
import android.graphics.drawable.Drawable;

public class ScrollBarDrawable extends Drawable {

    public ScrollBarDrawable() {
    }

    public void draw(Canvas canvas) {
        boolean flag;
        int i;
        int j;
        boolean flag1;
        boolean flag2;
        Rect rect;
        flag = mVertical;
        i = mExtent;
        j = mRange;
        flag1 = true;
        flag2 = true;
        if(i <= 0 || j <= i) {
            if(flag)
                flag1 = mAlwaysDrawVerticalTrack;
            else
                flag1 = mAlwaysDrawHorizontalTrack;
            flag2 = false;
        }
        rect = getBounds();
        if(!canvas.quickReject(rect.left, rect.top, rect.right, rect.bottom, android.graphics.Canvas.EdgeType.AA)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(flag1)
            drawTrack(canvas, rect, flag);
        if(flag2) {
            int k;
            int l;
            int i1;
            int j1;
            int k1;
            if(flag)
                k = rect.height();
            else
                k = rect.width();
            if(flag)
                l = rect.width();
            else
                l = rect.height();
            i1 = Math.round(((float)k * (float)i) / (float)j);
            j1 = Math.round(((float)(k - i1) * (float)mOffset) / (float)(j - i));
            k1 = l * 2;
            if(i1 < k1)
                i1 = k1;
            if(j1 + i1 > k)
                j1 = k - i1;
            drawThumb(canvas, rect, j1, i1, flag);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected void drawThumb(Canvas canvas, Rect rect, int i, int j, boolean flag) {
        Rect rect1 = mTempBounds;
        boolean flag1;
        if(mRangeChanged || mChanged)
            flag1 = true;
        else
            flag1 = false;
        if(flag1)
            if(flag)
                rect1.set(rect.left, i + rect.top, rect.right, j + (i + rect.top));
            else
                rect1.set(i + rect.left, rect.top, j + (i + rect.left), rect.bottom);
        if(flag) {
            Drawable drawable1 = mVerticalThumb;
            if(flag1)
                drawable1.setBounds(rect1);
            drawable1.draw(canvas);
        } else {
            Drawable drawable = mHorizontalThumb;
            if(flag1)
                drawable.setBounds(rect1);
            drawable.draw(canvas);
        }
    }

    protected void drawTrack(Canvas canvas, Rect rect, boolean flag) {
        Drawable drawable;
        if(flag)
            drawable = mVerticalTrack;
        else
            drawable = mHorizontalTrack;
        if(drawable != null) {
            if(mChanged)
                drawable.setBounds(rect);
            drawable.draw(canvas);
        }
    }

    public boolean getAlwaysDrawHorizontalTrack() {
        return mAlwaysDrawHorizontalTrack;
    }

    public boolean getAlwaysDrawVerticalTrack() {
        return mAlwaysDrawVerticalTrack;
    }

    public int getOpacity() {
        return -3;
    }

    public int getSize(boolean flag) {
        int i;
        if(flag) {
            Drawable drawable1;
            if(mVerticalTrack != null)
                drawable1 = mVerticalTrack;
            else
                drawable1 = mVerticalThumb;
            i = drawable1.getIntrinsicWidth();
        } else {
            Drawable drawable;
            if(mHorizontalTrack != null)
                drawable = mHorizontalTrack;
            else
                drawable = mHorizontalThumb;
            i = drawable.getIntrinsicHeight();
        }
        return i;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        mChanged = true;
    }

    public void setAlpha(int i) {
        if(mVerticalTrack != null)
            mVerticalTrack.setAlpha(i);
        mVerticalThumb.setAlpha(i);
        if(mHorizontalTrack != null)
            mHorizontalTrack.setAlpha(i);
        mHorizontalThumb.setAlpha(i);
    }

    public void setAlwaysDrawHorizontalTrack(boolean flag) {
        mAlwaysDrawHorizontalTrack = flag;
    }

    public void setAlwaysDrawVerticalTrack(boolean flag) {
        mAlwaysDrawVerticalTrack = flag;
    }

    public void setColorFilter(ColorFilter colorfilter) {
        if(mVerticalTrack != null)
            mVerticalTrack.setColorFilter(colorfilter);
        mVerticalThumb.setColorFilter(colorfilter);
        if(mHorizontalTrack != null)
            mHorizontalTrack.setColorFilter(colorfilter);
        mHorizontalThumb.setColorFilter(colorfilter);
    }

    public void setHorizontalThumbDrawable(Drawable drawable) {
        if(drawable != null)
            mHorizontalThumb = drawable;
    }

    public void setHorizontalTrackDrawable(Drawable drawable) {
        mHorizontalTrack = drawable;
    }

    public void setParameters(int i, int j, int k, boolean flag) {
        if(mVertical != flag)
            mChanged = true;
        if(mRange != i || mOffset != j || mExtent != k)
            mRangeChanged = true;
        mRange = i;
        mOffset = j;
        mExtent = k;
        mVertical = flag;
    }

    public void setVerticalThumbDrawable(Drawable drawable) {
        if(drawable != null)
            mVerticalThumb = drawable;
    }

    public void setVerticalTrackDrawable(Drawable drawable) {
        mVerticalTrack = drawable;
    }

    public String toString() {
        StringBuilder stringbuilder = (new StringBuilder()).append("ScrollBarDrawable: range=").append(mRange).append(" offset=").append(mOffset).append(" extent=").append(mExtent);
        String s;
        if(mVertical)
            s = " V";
        else
            s = " H";
        return stringbuilder.append(s).toString();
    }

    private boolean mAlwaysDrawHorizontalTrack;
    private boolean mAlwaysDrawVerticalTrack;
    private boolean mChanged;
    private int mExtent;
    private Drawable mHorizontalThumb;
    private Drawable mHorizontalTrack;
    private int mOffset;
    private int mRange;
    private boolean mRangeChanged;
    private final Rect mTempBounds = new Rect();
    private boolean mVertical;
    private Drawable mVerticalThumb;
    private Drawable mVerticalTrack;
}
