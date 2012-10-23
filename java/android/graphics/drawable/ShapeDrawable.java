// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            Drawable

public class ShapeDrawable extends Drawable {
    public static abstract class ShaderFactory {

        public abstract Shader resize(int i, int j);

        public ShaderFactory() {
        }
    }

    static final class ShapeState extends Drawable.ConstantState {

        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        public Drawable newDrawable() {
            return new ShapeDrawable(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new ShapeDrawable(this);
        }

        int mAlpha;
        int mChangingConfigurations;
        int mIntrinsicHeight;
        int mIntrinsicWidth;
        Rect mPadding;
        Paint mPaint;
        ShaderFactory mShaderFactory;
        Shape mShape;

        ShapeState(ShapeState shapestate) {
            mAlpha = 255;
            if(shapestate != null) {
                mPaint = shapestate.mPaint;
                mShape = shapestate.mShape;
                mPadding = shapestate.mPadding;
                mIntrinsicWidth = shapestate.mIntrinsicWidth;
                mIntrinsicHeight = shapestate.mIntrinsicHeight;
                mAlpha = shapestate.mAlpha;
                mShaderFactory = shapestate.mShaderFactory;
            } else {
                mPaint = new Paint(1);
            }
        }
    }


    public ShapeDrawable() {
        this((ShapeState)null);
    }

    private ShapeDrawable(ShapeState shapestate) {
        mShapeState = new ShapeState(shapestate);
    }


    public ShapeDrawable(Shape shape) {
        this((ShapeState)null);
        mShapeState.mShape = shape;
    }

    private static int modulateAlpha(int i, int j) {
        return i * (j + (j >>> 7)) >>> 8;
    }

    private void updateShape() {
        if(mShapeState.mShape != null) {
            Rect rect = getBounds();
            int i = rect.width();
            int j = rect.height();
            mShapeState.mShape.resize(i, j);
            if(mShapeState.mShaderFactory != null)
                mShapeState.mPaint.setShader(mShapeState.mShaderFactory.resize(i, j));
        }
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect rect = getBounds();
        Paint paint = mShapeState.mPaint;
        int i = paint.getAlpha();
        paint.setAlpha(modulateAlpha(i, mShapeState.mAlpha));
        if(mShapeState.mShape != null) {
            int j = canvas.save();
            canvas.translate(rect.left, rect.top);
            onDraw(mShapeState.mShape, canvas, paint);
            canvas.restoreToCount(j);
        } else {
            canvas.drawRect(rect, paint);
        }
        paint.setAlpha(i);
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mShapeState.mChangingConfigurations;
    }

    public Drawable.ConstantState getConstantState() {
        mShapeState.mChangingConfigurations = getChangingConfigurations();
        return mShapeState;
    }

    public int getIntrinsicHeight() {
        return mShapeState.mIntrinsicHeight;
    }

    public int getIntrinsicWidth() {
        return mShapeState.mIntrinsicWidth;
    }

    public int getOpacity() {
        if(mShapeState.mShape != null) goto _L2; else goto _L1
_L1:
        Paint paint = mShapeState.mPaint;
        if(paint.getXfermode() != null) goto _L2; else goto _L3
_L3:
        int i = paint.getAlpha();
        if(i != 0) goto _L5; else goto _L4
_L4:
        byte byte0 = -2;
_L7:
        return byte0;
_L5:
        if(i == 255) {
            byte0 = -1;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        byte0 = -3;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public boolean getPadding(Rect rect) {
        boolean flag;
        if(mShapeState.mPadding != null) {
            rect.set(mShapeState.mPadding);
            flag = true;
        } else {
            flag = super.getPadding(rect);
        }
        return flag;
    }

    public Paint getPaint() {
        return mShapeState.mPaint;
    }

    public ShaderFactory getShaderFactory() {
        return mShapeState.mShaderFactory;
    }

    public Shape getShape() {
        return mShapeState.mShape;
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlpullparser, attributeset);
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.ShapeDrawable);
        int i = typedarray.getColor(3, mShapeState.mPaint.getColor());
        mShapeState.mPaint.setColor(i);
        boolean flag = typedarray.getBoolean(0, false);
        mShapeState.mPaint.setDither(flag);
        setIntrinsicWidth((int)typedarray.getDimension(2, 0.0F));
        setIntrinsicHeight((int)typedarray.getDimension(1, 0.0F));
        typedarray.recycle();
        int j = xmlpullparser.getDepth();
        do {
            int k = xmlpullparser.next();
            if(k == 1 || k == 3 && xmlpullparser.getDepth() <= j)
                break;
            if(k == 2) {
                String s = xmlpullparser.getName();
                if(!inflateTag(s, resources, xmlpullparser, attributeset))
                    Log.w("drawable", (new StringBuilder()).append("Unknown element: ").append(s).append(" for ShapeDrawable ").append(this).toString());
            }
        } while(true);
    }

    protected boolean inflateTag(String s, Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) {
        boolean flag = true;
        if("padding".equals(s)) {
            TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.ShapeDrawablePadding);
            setPadding(typedarray.getDimensionPixelOffset(0, 0), typedarray.getDimensionPixelOffset(flag, 0), typedarray.getDimensionPixelOffset(2, 0), typedarray.getDimensionPixelOffset(3, 0));
            typedarray.recycle();
        } else {
            flag = false;
        }
        return flag;
    }

    public Drawable mutate() {
        if(mMutated || super.mutate() != this)
            break MISSING_BLOCK_LABEL_79;
        mShapeState.mPaint = new Paint(mShapeState.mPaint);
        mShapeState.mPadding = new Rect(mShapeState.mPadding);
        mShapeState.mShape = mShapeState.mShape.clone();
        mMutated = true;
_L2:
        return this;
        CloneNotSupportedException clonenotsupportedexception;
        clonenotsupportedexception;
        this = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        updateShape();
    }

    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        shape.draw(canvas, paint);
    }

    public void setAlpha(int i) {
        mShapeState.mAlpha = i;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorfilter) {
        mShapeState.mPaint.setColorFilter(colorfilter);
        invalidateSelf();
    }

    public void setDither(boolean flag) {
        mShapeState.mPaint.setDither(flag);
        invalidateSelf();
    }

    public void setIntrinsicHeight(int i) {
        mShapeState.mIntrinsicHeight = i;
        invalidateSelf();
    }

    public void setIntrinsicWidth(int i) {
        mShapeState.mIntrinsicWidth = i;
        invalidateSelf();
    }

    public void setPadding(int i, int j, int k, int l) {
        if((l | (k | (i | j))) == 0) {
            mShapeState.mPadding = null;
        } else {
            if(mShapeState.mPadding == null)
                mShapeState.mPadding = new Rect();
            mShapeState.mPadding.set(i, j, k, l);
        }
        invalidateSelf();
    }

    public void setPadding(Rect rect) {
        if(rect == null) {
            mShapeState.mPadding = null;
        } else {
            if(mShapeState.mPadding == null)
                mShapeState.mPadding = new Rect();
            mShapeState.mPadding.set(rect);
        }
        invalidateSelf();
    }

    public void setShaderFactory(ShaderFactory shaderfactory) {
        mShapeState.mShaderFactory = shaderfactory;
    }

    public void setShape(Shape shape) {
        mShapeState.mShape = shape;
        updateShape();
    }

    private boolean mMutated;
    private ShapeState mShapeState;
}
