// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.*;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            Drawable

public class NinePatchDrawable extends Drawable {
    private static final class NinePatchState extends Drawable.ConstantState {

        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        public Drawable newDrawable() {
            return new NinePatchDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new NinePatchDrawable(this, resources);
        }

        int mChangingConfigurations;
        final boolean mDither;
        final Insets mLayoutInsets;
        final NinePatch mNinePatch;
        final Rect mPadding;
        int mTargetDensity;

        NinePatchState(NinePatch ninepatch, Rect rect) {
            this(ninepatch, rect, new Rect(), true);
        }

        NinePatchState(NinePatch ninepatch, Rect rect, Rect rect1) {
            this(ninepatch, rect, rect1, true);
        }

        NinePatchState(NinePatch ninepatch, Rect rect, Rect rect1, boolean flag) {
            mTargetDensity = 160;
            mNinePatch = ninepatch;
            mPadding = rect;
            mLayoutInsets = Insets.of(rect1);
            mDither = flag;
        }

        NinePatchState(NinePatchState ninepatchstate) {
            mTargetDensity = 160;
            mNinePatch = new NinePatch(ninepatchstate.mNinePatch);
            mPadding = ninepatchstate.mPadding;
            mLayoutInsets = ninepatchstate.mLayoutInsets;
            mDither = ninepatchstate.mDither;
            mChangingConfigurations = ninepatchstate.mChangingConfigurations;
            mTargetDensity = ninepatchstate.mTargetDensity;
        }
    }


    NinePatchDrawable() {
        mLayoutInsets = Insets.NONE;
        mTargetDensity = 160;
    }

    public NinePatchDrawable(Resources resources, Bitmap bitmap, byte abyte0[], Rect rect, Rect rect1, String s) {
        this(new NinePatchState(new NinePatch(bitmap, abyte0, s), rect, rect1), resources);
        mNinePatchState.mTargetDensity = mTargetDensity;
    }

    public NinePatchDrawable(Resources resources, Bitmap bitmap, byte abyte0[], Rect rect, String s) {
        this(new NinePatchState(new NinePatch(bitmap, abyte0, s), rect), resources);
        mNinePatchState.mTargetDensity = mTargetDensity;
    }

    public NinePatchDrawable(Resources resources, NinePatch ninepatch) {
        this(new NinePatchState(ninepatch, new Rect()), resources);
        mNinePatchState.mTargetDensity = mTargetDensity;
    }

    public NinePatchDrawable(Bitmap bitmap, byte abyte0[], Rect rect, String s) {
        this(new NinePatchState(new NinePatch(bitmap, abyte0, s), rect), ((Resources) (null)));
    }

    public NinePatchDrawable(NinePatch ninepatch) {
        this(new NinePatchState(ninepatch, new Rect()), ((Resources) (null)));
    }

    private NinePatchDrawable(NinePatchState ninepatchstate, Resources resources) {
        mLayoutInsets = Insets.NONE;
        mTargetDensity = 160;
        setNinePatchState(ninepatchstate, resources);
    }


    private void computeBitmapSize() {
        int i = mNinePatch.getDensity();
        int j = mTargetDensity;
        if(i == j) {
            mBitmapWidth = mNinePatch.getWidth();
            mBitmapHeight = mNinePatch.getHeight();
            mLayoutInsets = mNinePatchState.mLayoutInsets;
            mPadding = mNinePatchState.mPadding;
        } else {
            mBitmapWidth = Bitmap.scaleFromDensity(mNinePatch.getWidth(), i, j);
            mBitmapHeight = Bitmap.scaleFromDensity(mNinePatch.getHeight(), i, j);
            if(mNinePatchState.mPadding != null && mPadding != null) {
                Rect rect = mPadding;
                Rect rect1 = mNinePatchState.mPadding;
                if(rect == rect1) {
                    rect = new Rect(rect1);
                    mPadding = rect;
                }
                rect.left = Bitmap.scaleFromDensity(rect1.left, i, j);
                rect.top = Bitmap.scaleFromDensity(rect1.top, i, j);
                rect.right = Bitmap.scaleFromDensity(rect1.right, i, j);
                rect.bottom = Bitmap.scaleFromDensity(rect1.bottom, i, j);
            }
            mLayoutInsets = scaleFromDensity(mNinePatchState.mLayoutInsets, i, j);
        }
    }

    private Insets scaleFromDensity(Insets insets, int i, int j) {
        return Insets.of(Bitmap.scaleFromDensity(insets.left, i, j), Bitmap.scaleFromDensity(insets.top, i, j), Bitmap.scaleFromDensity(insets.right, i, j), Bitmap.scaleFromDensity(insets.bottom, i, j));
    }

    private void setNinePatchState(NinePatchState ninepatchstate, Resources resources) {
        mNinePatchState = ninepatchstate;
        mNinePatch = ninepatchstate.mNinePatch;
        mPadding = ninepatchstate.mPadding;
        int i;
        if(resources != null)
            i = resources.getDisplayMetrics().densityDpi;
        else
            i = ninepatchstate.mTargetDensity;
        mTargetDensity = i;
        if(!ninepatchstate.mDither)
            setDither(ninepatchstate.mDither);
        if(mNinePatch != null)
            computeBitmapSize();
    }

    public void draw(Canvas canvas) {
        mNinePatch.draw(canvas, getBounds(), mPaint);
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mNinePatchState.mChangingConfigurations;
    }

    public Drawable.ConstantState getConstantState() {
        mNinePatchState.mChangingConfigurations = getChangingConfigurations();
        return mNinePatchState;
    }

    public int getIntrinsicHeight() {
        return mBitmapHeight;
    }

    public int getIntrinsicWidth() {
        return mBitmapWidth;
    }

    public Insets getLayoutInsets() {
        return mLayoutInsets;
    }

    public int getMinimumHeight() {
        return mBitmapHeight;
    }

    public int getMinimumWidth() {
        return mBitmapWidth;
    }

    public int getOpacity() {
        byte byte0;
        if(mNinePatch.hasAlpha() || mPaint != null && mPaint.getAlpha() < 255)
            byte0 = -3;
        else
            byte0 = -1;
        return byte0;
    }

    public boolean getPadding(Rect rect) {
        rect.set(mPadding);
        return true;
    }

    public Paint getPaint() {
        if(mPaint == null) {
            mPaint = new Paint();
            mPaint.setDither(true);
        }
        return mPaint;
    }

    public Region getTransparentRegion() {
        return mNinePatch.getTransparentRegion(getBounds());
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlpullparser, attributeset);
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.NinePatchDrawable);
        int i = typedarray.getResourceId(0, 0);
        if(i == 0)
            throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <nine-patch> requires a valid src attribute").toString());
        boolean flag = typedarray.getBoolean(1, true);
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        if(flag)
            options.inDither = false;
        options.inScreenDensity = DisplayMetrics.DENSITY_DEVICE;
        Rect rect = new Rect();
        Rect rect1 = new Rect();
        Bitmap bitmap = null;
        try {
            TypedValue typedvalue = new TypedValue();
            InputStream inputstream = resources.openRawResource(i, typedvalue);
            bitmap = BitmapFactory.decodeResourceStream(resources, typedvalue, inputstream, rect, options);
            inputstream.close();
        }
        catch(IOException ioexception) { }
        if(bitmap == null)
            throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <nine-patch> requires a valid src attribute").toString());
        if(bitmap.getNinePatchChunk() == null) {
            throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <nine-patch> requires a valid 9-patch source image").toString());
        } else {
            setNinePatchState(new NinePatchState(new NinePatch(bitmap, bitmap.getNinePatchChunk(), "XML 9-patch"), rect, rect1, flag), resources);
            mNinePatchState.mTargetDensity = mTargetDensity;
            typedarray.recycle();
            return;
        }
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            mNinePatchState = new NinePatchState(mNinePatchState);
            mNinePatch = mNinePatchState.mNinePatch;
            mMutated = true;
        }
        return this;
    }

    public void setAlpha(int i) {
        if(mPaint != null || i != 255) {
            getPaint().setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorfilter) {
        if(mPaint != null || colorfilter != null) {
            getPaint().setColorFilter(colorfilter);
            invalidateSelf();
        }
    }

    public void setDither(boolean flag) {
        if(mPaint != null || !flag) {
            getPaint().setDither(flag);
            invalidateSelf();
        }
    }

    public void setFilterBitmap(boolean flag) {
        getPaint().setFilterBitmap(flag);
        invalidateSelf();
    }

    public void setTargetDensity(int i) {
        if(i != mTargetDensity) {
            if(i == 0)
                i = 160;
            mTargetDensity = i;
            if(mNinePatch != null)
                computeBitmapSize();
            invalidateSelf();
        }
    }

    public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void setTargetDensity(DisplayMetrics displaymetrics) {
        setTargetDensity(displaymetrics.densityDpi);
    }

    private static final boolean DEFAULT_DITHER = true;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private Insets mLayoutInsets;
    private boolean mMutated;
    private NinePatch mNinePatch;
    private NinePatchState mNinePatchState;
    private Rect mPadding;
    private Paint mPaint;
    private int mTargetDensity;
}
