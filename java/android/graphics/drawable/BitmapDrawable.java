// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.*;
import android.view.Gravity;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            Drawable

public class BitmapDrawable extends Drawable {
    static final class BitmapState extends Drawable.ConstantState {

        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        public Drawable newDrawable() {
            return new BitmapDrawable(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new BitmapDrawable(this, resources);
        }

        Bitmap mBitmap;
        int mChangingConfigurations;
        int mGravity;
        Paint mPaint;
        boolean mRebuildShader;
        int mTargetDensity;
        android.graphics.Shader.TileMode mTileModeX;
        android.graphics.Shader.TileMode mTileModeY;

        BitmapState(Bitmap bitmap) {
            mGravity = 119;
            mPaint = new Paint(6);
            mTileModeX = null;
            mTileModeY = null;
            mTargetDensity = 160;
            mBitmap = bitmap;
        }

        BitmapState(BitmapState bitmapstate) {
            this(bitmapstate.mBitmap);
            mChangingConfigurations = bitmapstate.mChangingConfigurations;
            mGravity = bitmapstate.mGravity;
            mTileModeX = bitmapstate.mTileModeX;
            mTileModeY = bitmapstate.mTileModeY;
            mTargetDensity = bitmapstate.mTargetDensity;
            mPaint = new Paint(bitmapstate.mPaint);
            mRebuildShader = bitmapstate.mRebuildShader;
        }
    }


    public BitmapDrawable() {
        mDstRect = new Rect();
        mBitmapState = new BitmapState((Bitmap)null);
    }

    public BitmapDrawable(Resources resources) {
        mDstRect = new Rect();
        mBitmapState = new BitmapState((Bitmap)null);
        mBitmapState.mTargetDensity = mTargetDensity;
    }

    public BitmapDrawable(Resources resources, Bitmap bitmap) {
        this(new BitmapState(bitmap), resources);
        mBitmapState.mTargetDensity = mTargetDensity;
    }

    public BitmapDrawable(Resources resources, InputStream inputstream) {
        this(new BitmapState(BitmapFactory.decodeStream(inputstream)), ((Resources) (null)));
        mBitmapState.mTargetDensity = mTargetDensity;
        if(mBitmap == null)
            Log.w("BitmapDrawable", (new StringBuilder()).append("BitmapDrawable cannot decode ").append(inputstream).toString());
    }

    public BitmapDrawable(Resources resources, String s) {
        this(new BitmapState(BitmapFactory.decodeFile(s)), ((Resources) (null)));
        mBitmapState.mTargetDensity = mTargetDensity;
        if(mBitmap == null)
            Log.w("BitmapDrawable", (new StringBuilder()).append("BitmapDrawable cannot decode ").append(s).toString());
    }

    public BitmapDrawable(Bitmap bitmap) {
        this(new BitmapState(bitmap), ((Resources) (null)));
    }

    private BitmapDrawable(BitmapState bitmapstate, Resources resources) {
        mDstRect = new Rect();
        mBitmapState = bitmapstate;
        Bitmap bitmap;
        if(resources != null)
            mTargetDensity = resources.getDisplayMetrics().densityDpi;
        else
            mTargetDensity = bitmapstate.mTargetDensity;
        if(bitmapstate != null)
            bitmap = bitmapstate.mBitmap;
        else
            bitmap = null;
        setBitmap(bitmap);
    }


    public BitmapDrawable(InputStream inputstream) {
        this(new BitmapState(BitmapFactory.decodeStream(inputstream)), ((Resources) (null)));
        if(mBitmap == null)
            Log.w("BitmapDrawable", (new StringBuilder()).append("BitmapDrawable cannot decode ").append(inputstream).toString());
    }

    public BitmapDrawable(String s) {
        this(new BitmapState(BitmapFactory.decodeFile(s)), ((Resources) (null)));
        if(mBitmap == null)
            Log.w("BitmapDrawable", (new StringBuilder()).append("BitmapDrawable cannot decode ").append(s).toString());
    }

    private void computeBitmapSize() {
        mBitmapWidth = mBitmap.getScaledWidth(mTargetDensity);
        mBitmapHeight = mBitmap.getScaledHeight(mTargetDensity);
    }

    private void setBitmap(Bitmap bitmap) {
        if(bitmap != mBitmap) {
            mBitmap = bitmap;
            if(bitmap != null) {
                computeBitmapSize();
            } else {
                mBitmapHeight = -1;
                mBitmapWidth = -1;
            }
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = mBitmap;
        if(bitmap != null) {
            BitmapState bitmapstate = mBitmapState;
            if(bitmapstate.mRebuildShader) {
                android.graphics.Shader.TileMode tilemode = bitmapstate.mTileModeX;
                android.graphics.Shader.TileMode tilemode1 = bitmapstate.mTileModeY;
                int i;
                if(tilemode == null && tilemode1 == null) {
                    bitmapstate.mPaint.setShader(null);
                } else {
                    Paint paint = bitmapstate.mPaint;
                    if(tilemode == null)
                        tilemode = android.graphics.Shader.TileMode.CLAMP;
                    if(tilemode1 == null)
                        tilemode1 = android.graphics.Shader.TileMode.CLAMP;
                    paint.setShader(new BitmapShader(bitmap, tilemode, tilemode1));
                }
                bitmapstate.mRebuildShader = false;
                copyBounds(mDstRect);
            }
            if(bitmapstate.mPaint.getShader() == null) {
                if(mApplyGravity) {
                    i = getResolvedLayoutDirectionSelf();
                    Gravity.apply(bitmapstate.mGravity, mBitmapWidth, mBitmapHeight, getBounds(), mDstRect, i);
                    mApplyGravity = false;
                }
                canvas.drawBitmap(bitmap, null, mDstRect, bitmapstate.mPaint);
            } else {
                if(mApplyGravity) {
                    copyBounds(mDstRect);
                    mApplyGravity = false;
                }
                canvas.drawRect(mDstRect, bitmapstate.mPaint);
            }
        }
    }

    public final Bitmap getBitmap() {
        return mBitmap;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mBitmapState.mChangingConfigurations;
    }

    public final Drawable.ConstantState getConstantState() {
        mBitmapState.mChangingConfigurations = getChangingConfigurations();
        return mBitmapState;
    }

    public int getGravity() {
        return mBitmapState.mGravity;
    }

    public int getIntrinsicHeight() {
        return mBitmapHeight;
    }

    public int getIntrinsicWidth() {
        return mBitmapWidth;
    }

    public int getOpacity() {
        byte byte0 = -3;
        if(mBitmapState.mGravity == 119) goto _L2; else goto _L1
_L1:
        return byte0;
_L2:
        Bitmap bitmap = mBitmap;
        if(bitmap != null && !bitmap.hasAlpha() && mBitmapState.mPaint.getAlpha() >= 255)
            byte0 = -1;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public final Paint getPaint() {
        return mBitmapState.mPaint;
    }

    public android.graphics.Shader.TileMode getTileModeX() {
        return mBitmapState.mTileModeX;
    }

    public android.graphics.Shader.TileMode getTileModeY() {
        return mBitmapState.mTileModeY;
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        TypedArray typedarray;
        int j;
        super.inflate(resources, xmlpullparser, attributeset);
        typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.BitmapDrawable);
        int i = typedarray.getResourceId(1, 0);
        if(i == 0)
            throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <bitmap> requires a valid src attribute").toString());
        Bitmap bitmap = BitmapFactory.decodeResource(resources, i);
        if(bitmap == null)
            throw new XmlPullParserException((new StringBuilder()).append(xmlpullparser.getPositionDescription()).append(": <bitmap> requires a valid src attribute").toString());
        mBitmapState.mBitmap = bitmap;
        setBitmap(bitmap);
        setTargetDensity(resources.getDisplayMetrics());
        Paint paint = mBitmapState.mPaint;
        paint.setAntiAlias(typedarray.getBoolean(2, paint.isAntiAlias()));
        paint.setFilterBitmap(typedarray.getBoolean(3, paint.isFilterBitmap()));
        paint.setDither(typedarray.getBoolean(4, paint.isDither()));
        setGravity(typedarray.getInt(0, 119));
        j = typedarray.getInt(5, -1);
        if(j == -1) goto _L2; else goto _L1
_L1:
        j;
        JVM INSTR tableswitch 0 2: default 244
    //                   0 250
    //                   1 263
    //                   2 276;
           goto _L2 _L3 _L4 _L5
_L2:
        typedarray.recycle();
        return;
_L3:
        setTileModeXY(android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        continue; /* Loop/switch isn't completed */
_L4:
        setTileModeXY(android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.REPEAT);
        continue; /* Loop/switch isn't completed */
_L5:
        setTileModeXY(android.graphics.Shader.TileMode.MIRROR, android.graphics.Shader.TileMode.MIRROR);
        if(true) goto _L2; else goto _L6
_L6:
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            mBitmapState = new BitmapState(mBitmapState);
            mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        mApplyGravity = true;
    }

    public void setAlpha(int i) {
        if(i != mBitmapState.mPaint.getAlpha()) {
            mBitmapState.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean flag) {
        mBitmapState.mPaint.setAntiAlias(flag);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorfilter) {
        mBitmapState.mPaint.setColorFilter(colorfilter);
        invalidateSelf();
    }

    public void setDither(boolean flag) {
        mBitmapState.mPaint.setDither(flag);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean flag) {
        mBitmapState.mPaint.setFilterBitmap(flag);
        invalidateSelf();
    }

    public void setGravity(int i) {
        if(mBitmapState.mGravity != i) {
            mBitmapState.mGravity = i;
            mApplyGravity = true;
            invalidateSelf();
        }
    }

    public void setTargetDensity(int i) {
        if(mTargetDensity != i) {
            if(i == 0)
                i = 160;
            mTargetDensity = i;
            if(mBitmap != null)
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

    public void setTileModeX(android.graphics.Shader.TileMode tilemode) {
        setTileModeXY(tilemode, mBitmapState.mTileModeY);
    }

    public void setTileModeXY(android.graphics.Shader.TileMode tilemode, android.graphics.Shader.TileMode tilemode1) {
        BitmapState bitmapstate = mBitmapState;
        if(bitmapstate.mTileModeX != tilemode || bitmapstate.mTileModeY != tilemode1) {
            bitmapstate.mTileModeX = tilemode;
            bitmapstate.mTileModeY = tilemode1;
            bitmapstate.mRebuildShader = true;
            invalidateSelf();
        }
    }

    public final void setTileModeY(android.graphics.Shader.TileMode tilemode) {
        setTileModeXY(mBitmapState.mTileModeX, tilemode);
    }

    private static final int DEFAULT_PAINT_FLAGS = 6;
    private boolean mApplyGravity;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private BitmapState mBitmapState;
    private int mBitmapWidth;
    private final Rect mDstRect;
    private boolean mMutated;
    private int mTargetDensity;
}
