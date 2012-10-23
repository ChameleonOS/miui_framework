// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable.shapes;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Shape
    implements Cloneable {

    public Shape() {
    }

    public Shape clone() throws CloneNotSupportedException {
        return (Shape)super.clone();
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public abstract void draw(Canvas canvas, Paint paint);

    public final float getHeight() {
        return mHeight;
    }

    public final float getWidth() {
        return mWidth;
    }

    public boolean hasAlpha() {
        return true;
    }

    protected void onResize(float f, float f1) {
    }

    public final void resize(float f, float f1) {
        if(f < 0.0F)
            f = 0.0F;
        if(f1 < 0.0F)
            f1 = 0.0F;
        if(mWidth != f || mHeight != f1) {
            mWidth = f;
            mHeight = f1;
            onResize(f, f1);
        }
    }

    private float mHeight;
    private float mWidth;
}
