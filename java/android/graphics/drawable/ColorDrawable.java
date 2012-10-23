// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            Drawable

public class ColorDrawable extends Drawable {
    static final class ColorState extends Drawable.ConstantState {

        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        public Drawable newDrawable() {
            return new ColorDrawable(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new ColorDrawable(this);
        }

        int mBaseColor;
        int mChangingConfigurations;
        int mUseColor;

        ColorState(ColorState colorstate) {
            if(colorstate != null) {
                mBaseColor = colorstate.mBaseColor;
                mUseColor = colorstate.mUseColor;
            }
        }
    }


    public ColorDrawable() {
        this(((ColorState) (null)));
    }

    public ColorDrawable(int i) {
        this(((ColorState) (null)));
        setColor(i);
    }

    private ColorDrawable(ColorState colorstate) {
        mPaint = new Paint();
        mState = new ColorState(colorstate);
    }


    public void draw(Canvas canvas) {
        if(mState.mUseColor >>> 24 != 0) {
            mPaint.setColor(mState.mUseColor);
            canvas.drawRect(getBounds(), mPaint);
        }
    }

    public int getAlpha() {
        return mState.mUseColor >>> 24;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mState.mChangingConfigurations;
    }

    public int getColor() {
        return mState.mUseColor;
    }

    public Drawable.ConstantState getConstantState() {
        mState.mChangingConfigurations = getChangingConfigurations();
        return mState;
    }

    public int getOpacity() {
        mState.mUseColor >>> 24;
        JVM INSTR lookupswitch 2: default 36
    //                   0: 47
    //                   255: 41;
           goto _L1 _L2 _L3
_L1:
        byte byte0 = -3;
_L5:
        return byte0;
_L3:
        byte0 = -1;
        continue; /* Loop/switch isn't completed */
_L2:
        byte0 = -2;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlpullparser, attributeset);
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.ColorDrawable);
        int i = typedarray.getColor(0, mState.mBaseColor);
        ColorState colorstate = mState;
        mState.mUseColor = i;
        colorstate.mBaseColor = i;
        typedarray.recycle();
    }

    public void setAlpha(int i) {
        int j = (i + (i >> 7)) * (mState.mBaseColor >>> 24) >> 8;
        int k = mState.mUseColor;
        mState.mUseColor = (mState.mBaseColor << 8) >>> 8 | j << 24;
        if(k != mState.mUseColor)
            invalidateSelf();
    }

    public void setColor(int i) {
        if(mState.mBaseColor != i || mState.mUseColor != i) {
            invalidateSelf();
            ColorState colorstate = mState;
            mState.mUseColor = i;
            colorstate.mBaseColor = i;
        }
    }

    public void setColorFilter(ColorFilter colorfilter) {
    }

    private final Paint mPaint;
    private ColorState mState;
}
