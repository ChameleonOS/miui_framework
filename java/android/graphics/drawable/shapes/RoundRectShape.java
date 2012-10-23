// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable.shapes;

import android.graphics.*;

// Referenced classes of package android.graphics.drawable.shapes:
//            RectShape, Shape

public class RoundRectShape extends RectShape {

    public RoundRectShape(float af[], RectF rectf, float af1[]) {
        if(af != null && af.length < 8)
            throw new ArrayIndexOutOfBoundsException("outer radii must have >= 8 values");
        if(af1 != null && af1.length < 8)
            throw new ArrayIndexOutOfBoundsException("inner radii must have >= 8 values");
        mOuterRadii = af;
        mInset = rectf;
        mInnerRadii = af1;
        if(rectf != null)
            mInnerRect = new RectF();
        mPath = new Path();
    }

    public volatile RectShape clone() throws CloneNotSupportedException {
        return clone();
    }

    public RoundRectShape clone() throws CloneNotSupportedException {
        RoundRectShape roundrectshape = (RoundRectShape)super.clone();
        float af[];
        float af1[];
        if(mOuterRadii != null)
            af = (float[])mOuterRadii.clone();
        else
            af = null;
        roundrectshape.mOuterRadii = af;
        if(mInnerRadii != null)
            af1 = (float[])mInnerRadii.clone();
        else
            af1 = null;
        roundrectshape.mInnerRadii = af1;
        roundrectshape.mInset = new RectF(mInset);
        roundrectshape.mInnerRect = new RectF(mInnerRect);
        roundrectshape.mPath = new Path(mPath);
        return roundrectshape;
    }

    public volatile Shape clone() throws CloneNotSupportedException {
        return clone();
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public void draw(Canvas canvas, Paint paint) {
        canvas.drawPath(mPath, paint);
    }

    protected void onResize(float f, float f1) {
        super.onResize(f, f1);
        RectF rectf = rect();
        mPath.reset();
        if(mOuterRadii != null)
            mPath.addRoundRect(rectf, mOuterRadii, android.graphics.Path.Direction.CW);
        else
            mPath.addRect(rectf, android.graphics.Path.Direction.CW);
        if(mInnerRect != null) {
            mInnerRect.set(rectf.left + mInset.left, rectf.top + mInset.top, rectf.right - mInset.right, rectf.bottom - mInset.bottom);
            if(mInnerRect.width() < f && mInnerRect.height() < f1)
                if(mInnerRadii != null)
                    mPath.addRoundRect(mInnerRect, mInnerRadii, android.graphics.Path.Direction.CCW);
                else
                    mPath.addRect(mInnerRect, android.graphics.Path.Direction.CCW);
        }
    }

    private float mInnerRadii[];
    private RectF mInnerRect;
    private RectF mInset;
    private float mOuterRadii[];
    private Path mPath;
}
