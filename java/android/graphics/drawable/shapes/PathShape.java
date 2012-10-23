// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable.shapes;

import android.graphics.*;

// Referenced classes of package android.graphics.drawable.shapes:
//            Shape

public class PathShape extends Shape {

    public PathShape(Path path, float f, float f1) {
        mPath = path;
        mStdWidth = f;
        mStdHeight = f1;
    }

    public PathShape clone() throws CloneNotSupportedException {
        PathShape pathshape = (PathShape)super.clone();
        pathshape.mPath = new Path(mPath);
        return pathshape;
    }

    public volatile Shape clone() throws CloneNotSupportedException {
        return clone();
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.scale(mScaleX, mScaleY);
        canvas.drawPath(mPath, paint);
        canvas.restore();
    }

    protected void onResize(float f, float f1) {
        mScaleX = f / mStdWidth;
        mScaleY = f1 / mStdHeight;
    }

    private Path mPath;
    private float mScaleX;
    private float mScaleY;
    private float mStdHeight;
    private float mStdWidth;
}
