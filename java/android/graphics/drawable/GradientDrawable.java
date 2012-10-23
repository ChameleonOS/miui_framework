// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.*;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.graphics.drawable:
//            Drawable

public class GradientDrawable extends Drawable {
    static final class GradientState extends Drawable.ConstantState {

        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        public Drawable newDrawable() {
            return new GradientDrawable(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new GradientDrawable(this);
        }

        public void setColors(int ai[]) {
            mHasSolidColor = false;
            mColors = ai;
        }

        public void setCornerRadii(float af[]) {
            mRadiusArray = af;
            if(af == null)
                mRadius = 0.0F;
        }

        public void setCornerRadius(float f) {
            if(f < 0.0F)
                f = 0.0F;
            mRadius = f;
            mRadiusArray = null;
        }

        public void setGradientCenter(float f, float f1) {
            mCenterX = f;
            mCenterY = f1;
        }

        public void setGradientRadius(float f) {
            mGradientRadius = f;
        }

        public void setGradientType(int i) {
            mGradient = i;
        }

        public void setShape(int i) {
            mShape = i;
        }

        public void setSize(int i, int j) {
            mWidth = i;
            mHeight = j;
        }

        public void setSolidColor(int i) {
            mHasSolidColor = true;
            mSolidColor = i;
            mColors = null;
        }

        public void setStroke(int i, int j) {
            mStrokeWidth = i;
            mStrokeColor = j;
        }

        public void setStroke(int i, int j, float f, float f1) {
            mStrokeWidth = i;
            mStrokeColor = j;
            mStrokeDashWidth = f;
            mStrokeDashGap = f1;
        }

        private float mCenterX;
        private float mCenterY;
        public int mChangingConfigurations;
        public int mColors[];
        public int mGradient;
        private float mGradientRadius;
        public boolean mHasSolidColor;
        public int mHeight;
        public int mInnerRadius;
        public float mInnerRadiusRatio;
        public Orientation mOrientation;
        public Rect mPadding;
        public float mPositions[];
        public float mRadius;
        public float mRadiusArray[];
        public int mShape;
        public int mSolidColor;
        public int mStrokeColor;
        public float mStrokeDashGap;
        public float mStrokeDashWidth;
        public int mStrokeWidth;
        public int mTempColors[];
        public float mTempPositions[];
        public int mThickness;
        public float mThicknessRatio;
        private boolean mUseLevel;
        private boolean mUseLevelForShape;
        public int mWidth;



/*
        static boolean access$002(GradientState gradientstate, boolean flag) {
            gradientstate.mUseLevel = flag;
            return flag;
        }

*/



/*
        static boolean access$102(GradientState gradientstate, boolean flag) {
            gradientstate.mUseLevelForShape = flag;
            return flag;
        }

*/



/*
        static float access$202(GradientState gradientstate, float f) {
            gradientstate.mCenterX = f;
            return f;
        }

*/



/*
        static float access$302(GradientState gradientstate, float f) {
            gradientstate.mCenterY = f;
            return f;
        }

*/



/*
        static float access$402(GradientState gradientstate, float f) {
            gradientstate.mGradientRadius = f;
            return f;
        }

*/

        public GradientState(GradientState gradientstate) {
            mShape = 0;
            mGradient = 0;
            mStrokeWidth = -1;
            mWidth = -1;
            mHeight = -1;
            mCenterX = 0.5F;
            mCenterY = 0.5F;
            mGradientRadius = 0.5F;
            mChangingConfigurations = gradientstate.mChangingConfigurations;
            mShape = gradientstate.mShape;
            mGradient = gradientstate.mGradient;
            mOrientation = gradientstate.mOrientation;
            if(gradientstate.mColors != null)
                mColors = (int[])gradientstate.mColors.clone();
            if(gradientstate.mPositions != null)
                mPositions = (float[])gradientstate.mPositions.clone();
            mHasSolidColor = gradientstate.mHasSolidColor;
            mSolidColor = gradientstate.mSolidColor;
            mStrokeWidth = gradientstate.mStrokeWidth;
            mStrokeColor = gradientstate.mStrokeColor;
            mStrokeDashWidth = gradientstate.mStrokeDashWidth;
            mStrokeDashGap = gradientstate.mStrokeDashGap;
            mRadius = gradientstate.mRadius;
            if(gradientstate.mRadiusArray != null)
                mRadiusArray = (float[])gradientstate.mRadiusArray.clone();
            if(gradientstate.mPadding != null)
                mPadding = new Rect(gradientstate.mPadding);
            mWidth = gradientstate.mWidth;
            mHeight = gradientstate.mHeight;
            mInnerRadiusRatio = gradientstate.mInnerRadiusRatio;
            mThicknessRatio = gradientstate.mThicknessRatio;
            mInnerRadius = gradientstate.mInnerRadius;
            mThickness = gradientstate.mThickness;
            mCenterX = gradientstate.mCenterX;
            mCenterY = gradientstate.mCenterY;
            mGradientRadius = gradientstate.mGradientRadius;
            mUseLevel = gradientstate.mUseLevel;
            mUseLevelForShape = gradientstate.mUseLevelForShape;
        }

        GradientState(Orientation orientation, int ai[]) {
            mShape = 0;
            mGradient = 0;
            mStrokeWidth = -1;
            mWidth = -1;
            mHeight = -1;
            mCenterX = 0.5F;
            mCenterY = 0.5F;
            mGradientRadius = 0.5F;
            mOrientation = orientation;
            mColors = ai;
        }
    }

    public static final class Orientation extends Enum {

        public static Orientation valueOf(String s) {
            return (Orientation)Enum.valueOf(android/graphics/drawable/GradientDrawable$Orientation, s);
        }

        public static Orientation[] values() {
            return (Orientation[])$VALUES.clone();
        }

        private static final Orientation $VALUES[];
        public static final Orientation BL_TR;
        public static final Orientation BOTTOM_TOP;
        public static final Orientation BR_TL;
        public static final Orientation LEFT_RIGHT;
        public static final Orientation RIGHT_LEFT;
        public static final Orientation TL_BR;
        public static final Orientation TOP_BOTTOM;
        public static final Orientation TR_BL;

        static  {
            TOP_BOTTOM = new Orientation("TOP_BOTTOM", 0);
            TR_BL = new Orientation("TR_BL", 1);
            RIGHT_LEFT = new Orientation("RIGHT_LEFT", 2);
            BR_TL = new Orientation("BR_TL", 3);
            BOTTOM_TOP = new Orientation("BOTTOM_TOP", 4);
            BL_TR = new Orientation("BL_TR", 5);
            LEFT_RIGHT = new Orientation("LEFT_RIGHT", 6);
            TL_BR = new Orientation("TL_BR", 7);
            Orientation aorientation[] = new Orientation[8];
            aorientation[0] = TOP_BOTTOM;
            aorientation[1] = TR_BL;
            aorientation[2] = RIGHT_LEFT;
            aorientation[3] = BR_TL;
            aorientation[4] = BOTTOM_TOP;
            aorientation[5] = BL_TR;
            aorientation[6] = LEFT_RIGHT;
            aorientation[7] = TL_BR;
            $VALUES = aorientation;
        }

        private Orientation(String s, int i) {
            super(s, i);
        }
    }


    public GradientDrawable() {
        this(new GradientState(Orientation.TOP_BOTTOM, null));
    }

    private GradientDrawable(GradientState gradientstate) {
        mFillPaint = new Paint(1);
        mAlpha = 255;
        mPath = new Path();
        mRect = new RectF();
        mPathIsDirty = true;
        mGradientState = gradientstate;
        initializeWithState(gradientstate);
        mRectIsDirty = true;
    }


    public GradientDrawable(Orientation orientation, int ai[]) {
        this(new GradientState(orientation, ai));
    }

    private Path buildRing(GradientState gradientstate) {
        Path path;
        if(mRingPath != null && (!gradientstate.mUseLevelForShape || !mPathIsDirty)) {
            path = mRingPath;
        } else {
            mPathIsDirty = false;
            float f;
            RectF rectf;
            float f1;
            float f2;
            float f3;
            float f4;
            RectF rectf1;
            RectF rectf2;
            if(gradientstate.mUseLevelForShape)
                f = (360F * (float)getLevel()) / 10000F;
            else
                f = 360F;
            rectf = new RectF(mRect);
            f1 = rectf.width() / 2.0F;
            f2 = rectf.height() / 2.0F;
            if(gradientstate.mThickness != -1)
                f3 = gradientstate.mThickness;
            else
                f3 = rectf.width() / gradientstate.mThicknessRatio;
            if(gradientstate.mInnerRadius != -1)
                f4 = gradientstate.mInnerRadius;
            else
                f4 = rectf.width() / gradientstate.mInnerRadiusRatio;
            rectf1 = new RectF(rectf);
            rectf1.inset(f1 - f4, f2 - f4);
            rectf2 = new RectF(rectf1);
            rectf2.inset(-f3, -f3);
            if(mRingPath == null)
                mRingPath = new Path();
            else
                mRingPath.reset();
            path = mRingPath;
            if(f < 360F && f > -360F) {
                path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
                path.moveTo(f1 + f4, f2);
                path.lineTo(f3 + (f1 + f4), f2);
                path.arcTo(rectf2, 0.0F, f, false);
                path.arcTo(rectf1, f, -f, false);
                path.close();
            } else {
                path.addOval(rectf2, android.graphics.Path.Direction.CW);
                path.addOval(rectf1, android.graphics.Path.Direction.CCW);
            }
        }
        return path;
    }

    private boolean ensureValidRect() {
        if(!mRectIsDirty) goto _L2; else goto _L1
_L1:
        GradientState gradientstate;
        int ai[];
        mRectIsDirty = false;
        Rect rect = getBounds();
        float f = 0.0F;
        if(mStrokePaint != null)
            f = 0.5F * mStrokePaint.getStrokeWidth();
        gradientstate = mGradientState;
        mRect.set(f + (float)rect.left, f + (float)rect.top, (float)rect.right - f, (float)rect.bottom - f);
        ai = gradientstate.mColors;
        if(ai == null) goto _L2; else goto _L3
_L3:
        RectF rectf;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        rectf = mRect;
        if(gradientstate.mGradient != 0)
            break MISSING_BLOCK_LABEL_498;
        class _cls1 {

            static final int $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[];

            static  {
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation = new int[Orientation.values().length];
                NoSuchFieldError nosuchfielderror6;
                try {
                    $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.TOP_BOTTOM.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.TR_BL.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.RIGHT_LEFT.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.BR_TL.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.BOTTOM_TOP.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.BL_TR.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$android$graphics$drawable$GradientDrawable$Orientation[Orientation.LEFT_RIGHT.ordinal()] = 7;
_L2:
                return;
                nosuchfielderror6;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        if(gradientstate.mUseLevel)
            f8 = (float)getLevel() / 10000F;
        else
            f8 = 1.0F;
        _cls1..SwitchMap.android.graphics.drawable.GradientDrawable.Orientation[gradientstate.mOrientation.ordinal()];
        JVM INSTR tableswitch 1 7: default 176
    //                   1 263
    //                   2 294
    //                   3 331
    //                   4 362
    //                   5 399
    //                   6 430
    //                   7 467;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L4:
        f9 = rectf.left;
        f10 = rectf.top;
        f11 = f8 * rectf.right;
        f12 = f8 * rectf.bottom;
_L12:
        mFillPaint.setShader(new LinearGradient(f9, f10, f11, f12, ai, gradientstate.mPositions, android.graphics.Shader.TileMode.CLAMP));
_L2:
        boolean flag;
        float f1;
        float f2;
        int ai1[];
        float af[];
        int i;
        float f3;
        float f4;
        int j;
        float f5;
        float f6;
        float f7;
        if(!mRect.isEmpty())
            flag = true;
        else
            flag = false;
        return flag;
_L5:
        f9 = rectf.left;
        f10 = rectf.top;
        f11 = f9;
        f12 = f8 * rectf.bottom;
          goto _L12
_L6:
        f9 = rectf.right;
        f10 = rectf.top;
        f11 = f8 * rectf.left;
        f12 = f8 * rectf.bottom;
          goto _L12
_L7:
        f9 = rectf.right;
        f10 = rectf.top;
        f11 = f8 * rectf.left;
        f12 = f10;
          goto _L12
_L8:
        f9 = rectf.right;
        f10 = rectf.bottom;
        f11 = f8 * rectf.left;
        f12 = f8 * rectf.top;
          goto _L12
_L9:
        f9 = rectf.left;
        f10 = rectf.bottom;
        f11 = f9;
        f12 = f8 * rectf.top;
          goto _L12
_L10:
        f9 = rectf.left;
        f10 = rectf.bottom;
        f11 = f8 * rectf.right;
        f12 = f8 * rectf.top;
          goto _L12
_L11:
        f9 = rectf.left;
        f10 = rectf.top;
        f11 = f8 * rectf.right;
        f12 = f10;
          goto _L12
        if(gradientstate.mGradient == 1) {
            f5 = rectf.left + (rectf.right - rectf.left) * gradientstate.mCenterX;
            f6 = rectf.top + (rectf.bottom - rectf.top) * gradientstate.mCenterY;
            if(gradientstate.mUseLevel)
                f7 = (float)getLevel() / 10000F;
            else
                f7 = 1.0F;
            mFillPaint.setShader(new RadialGradient(f5, f6, f7 * gradientstate.mGradientRadius, ai, null, android.graphics.Shader.TileMode.CLAMP));
        } else
        if(gradientstate.mGradient == 2) {
            f1 = rectf.left + (rectf.right - rectf.left) * gradientstate.mCenterX;
            f2 = rectf.top + (rectf.bottom - rectf.top) * gradientstate.mCenterY;
            ai1 = ai;
            af = null;
            if(gradientstate.mUseLevel) {
                ai1 = gradientstate.mTempColors;
                i = ai.length;
                if(ai1 == null || ai1.length != i + 1) {
                    ai1 = new int[i + 1];
                    gradientstate.mTempColors = ai1;
                }
                System.arraycopy(ai, 0, ai1, 0, i);
                ai1[i] = ai[i - 1];
                af = gradientstate.mTempPositions;
                f3 = 1.0F / (float)(i - 1);
                if(af == null || af.length != i + 1) {
                    af = new float[i + 1];
                    gradientstate.mTempPositions = af;
                }
                f4 = (float)getLevel() / 10000F;
                for(j = 0; j < i; j++)
                    af[j] = f4 * (f3 * (float)j);

                af[i] = 1.0F;
            }
            mFillPaint.setShader(new SweepGradient(f1, f2, ai1, af));
        }
          goto _L2
    }

    private static float getFloatOrFraction(TypedArray typedarray, int i, float f) {
        TypedValue typedvalue = typedarray.peekValue(i);
        float f1 = f;
        if(typedvalue != null) {
            boolean flag;
            if(typedvalue.type == 6)
                flag = true;
            else
                flag = false;
            if(flag)
                f1 = typedvalue.getFraction(1.0F, 1.0F);
            else
                f1 = typedvalue.getFloat();
        }
        return f1;
    }

    private void initializeWithState(GradientState gradientstate) {
        if(gradientstate.mHasSolidColor)
            mFillPaint.setColor(gradientstate.mSolidColor);
        mPadding = gradientstate.mPadding;
        if(gradientstate.mStrokeWidth >= 0) {
            mStrokePaint = new Paint(1);
            mStrokePaint.setStyle(android.graphics.Paint.Style.STROKE);
            mStrokePaint.setStrokeWidth(gradientstate.mStrokeWidth);
            mStrokePaint.setColor(gradientstate.mStrokeColor);
            if(gradientstate.mStrokeDashWidth != 0.0F) {
                float af[] = new float[2];
                af[0] = gradientstate.mStrokeDashWidth;
                af[1] = gradientstate.mStrokeDashGap;
                DashPathEffect dashpatheffect = new DashPathEffect(af, 0.0F);
                mStrokePaint.setPathEffect(dashpatheffect);
            }
        }
    }

    private int modulateAlpha(int i) {
        return i * (mAlpha + (mAlpha >> 7)) >> 8;
    }

    public void draw(Canvas canvas) {
        if(ensureValidRect()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int j;
        boolean flag;
        GradientState gradientstate;
        i = mFillPaint.getAlpha();
        int k;
        int l;
        boolean flag1;
        boolean flag2;
        if(mStrokePaint != null)
            j = mStrokePaint.getAlpha();
        else
            j = 0;
        k = modulateAlpha(i);
        l = modulateAlpha(j);
        if(l > 0 && mStrokePaint.getStrokeWidth() > 0.0F)
            flag = true;
        else
            flag = false;
        if(k > 0)
            flag1 = true;
        else
            flag1 = false;
        gradientstate = mGradientState;
        if(flag && flag1 && gradientstate.mShape != 2 && l < 255 && (mAlpha < 255 || mColorFilter != null))
            flag2 = true;
        else
            flag2 = false;
        if(flag2) {
            if(mLayerPaint == null)
                mLayerPaint = new Paint();
            mLayerPaint.setDither(mDither);
            mLayerPaint.setAlpha(mAlpha);
            mLayerPaint.setColorFilter(mColorFilter);
            float f3 = mStrokePaint.getStrokeWidth();
            canvas.saveLayer(mRect.left - f3, mRect.top - f3, f3 + mRect.right, f3 + mRect.bottom, mLayerPaint, 4);
            mFillPaint.setColorFilter(null);
            mStrokePaint.setColorFilter(null);
        } else {
            mFillPaint.setAlpha(k);
            mFillPaint.setDither(mDither);
            mFillPaint.setColorFilter(mColorFilter);
            if(flag) {
                mStrokePaint.setAlpha(l);
                mStrokePaint.setDither(mDither);
                mStrokePaint.setColorFilter(mColorFilter);
            }
        }
        gradientstate.mShape;
        JVM INSTR tableswitch 0 3: default 296
    //                   0 403
    //                   1 632
    //                   2 664
    //                   3 702;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_702;
_L8:
        Path path;
        RectF rectf;
        float f;
        float f1;
        float f2;
        RectF rectf1;
        Paint paint;
        RectF rectf2;
        Paint paint1;
        if(flag2) {
            canvas.restore();
        } else {
            mFillPaint.setAlpha(i);
            if(flag)
                mStrokePaint.setAlpha(j);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if(gradientstate.mRadiusArray != null) {
            if(mPathIsDirty || mRectIsDirty) {
                mPath.reset();
                mPath.addRoundRect(mRect, gradientstate.mRadiusArray, android.graphics.Path.Direction.CW);
                mRectIsDirty = false;
                mPathIsDirty = false;
            }
            canvas.drawPath(mPath, mFillPaint);
            if(flag)
                canvas.drawPath(mPath, mStrokePaint);
        } else
        if(gradientstate.mRadius > 0.0F) {
            f1 = gradientstate.mRadius;
            f2 = 0.5F * Math.min(mRect.width(), mRect.height());
            if(f1 > f2)
                f1 = f2;
            rectf1 = mRect;
            paint = mFillPaint;
            canvas.drawRoundRect(rectf1, f1, f1, paint);
            if(flag) {
                rectf2 = mRect;
                paint1 = mStrokePaint;
                canvas.drawRoundRect(rectf2, f1, f1, paint1);
            }
        } else {
            canvas.drawRect(mRect, mFillPaint);
            if(flag)
                canvas.drawRect(mRect, mStrokePaint);
        }
          goto _L8
_L5:
        canvas.drawOval(mRect, mFillPaint);
        if(flag)
            canvas.drawOval(mRect, mStrokePaint);
          goto _L8
_L6:
        rectf = mRect;
        f = rectf.centerY();
        canvas.drawLine(rectf.left, f, rectf.right, f, mStrokePaint);
          goto _L8
        path = buildRing(gradientstate);
        canvas.drawPath(path, mFillPaint);
        if(flag)
            canvas.drawPath(path, mStrokePaint);
          goto _L8
        if(true) goto _L1; else goto _L9
_L9:
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mGradientState.mChangingConfigurations;
    }

    public Drawable.ConstantState getConstantState() {
        mGradientState.mChangingConfigurations = getChangingConfigurations();
        return mGradientState;
    }

    public int getIntrinsicHeight() {
        return mGradientState.mHeight;
    }

    public int getIntrinsicWidth() {
        return mGradientState.mWidth;
    }

    public int getOpacity() {
        return -3;
    }

    public Orientation getOrientation() {
        return mGradientState.mOrientation;
    }

    public boolean getPadding(Rect rect) {
        boolean flag;
        if(mPadding != null) {
            rect.set(mPadding);
            flag = true;
        } else {
            flag = super.getPadding(rect);
        }
        return flag;
    }

    public void inflate(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        GradientState gradientstate;
        int j;
        gradientstate = mGradientState;
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.GradientDrawable);
        super.inflateWithAttributes(resources, xmlpullparser, typedarray, 1);
        int i = typedarray.getInt(2, 0);
        boolean flag = typedarray.getBoolean(0, false);
        if(i == 3) {
            gradientstate.mInnerRadius = typedarray.getDimensionPixelSize(6, -1);
            if(gradientstate.mInnerRadius == -1)
                gradientstate.mInnerRadiusRatio = typedarray.getFloat(3, 3F);
            gradientstate.mThickness = typedarray.getDimensionPixelSize(7, -1);
            if(gradientstate.mThickness == -1)
                gradientstate.mThicknessRatio = typedarray.getFloat(4, 9F);
            gradientstate.mUseLevelForShape = typedarray.getBoolean(5, true);
        }
        typedarray.recycle();
        setShape(i);
        setDither(flag);
        j = 1 + xmlpullparser.getDepth();
_L14:
        String s;
        TypedArray typedarray5;
        int i3;
        boolean flag1;
        int j3;
        int k3;
        int l3;
        int k = xmlpullparser.next();
        if(k == 1)
            break; /* Loop/switch isn't completed */
        int l = xmlpullparser.getDepth();
        if(l < j && k == 3)
            break; /* Loop/switch isn't completed */
        if(k != 2 || l > j)
            continue; /* Loop/switch isn't completed */
        s = xmlpullparser.getName();
        if(s.equals("size")) {
            TypedArray typedarray6 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.GradientDrawableSize);
            int j4 = typedarray6.getDimensionPixelSize(1, -1);
            int k4 = typedarray6.getDimensionPixelSize(0, -1);
            typedarray6.recycle();
            setSize(j4, k4);
            continue; /* Loop/switch isn't completed */
        }
        if(!s.equals("gradient"))
            break MISSING_BLOCK_LABEL_878;
        typedarray5 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.GradientDrawableGradient);
        i3 = typedarray5.getColor(0, 0);
        flag1 = typedarray5.hasValue(8);
        j3 = typedarray5.getColor(8, 0);
        k3 = typedarray5.getColor(1, 0);
        l3 = typedarray5.getInt(4, 0);
        gradientstate.mCenterX = getFloatOrFraction(typedarray5, 5, 0.5F);
        gradientstate.mCenterY = getFloatOrFraction(typedarray5, 6, 0.5F);
        gradientstate.mUseLevel = typedarray5.getBoolean(2, false);
        gradientstate.mGradient = l3;
        if(l3 != 0) goto _L2; else goto _L1
_L1:
        int i4;
        i4 = (int)typedarray5.getFloat(3, 0.0F) % 360;
        if(i4 % 45 != 0)
            throw new XmlPullParserException((new StringBuilder()).append(typedarray5.getPositionDescription()).append("<gradient> tag requires 'angle' attribute to ").append("be a multiple of 45").toString());
        i4;
        JVM INSTR lookupswitch 8: default 536
    //                   0: 639
    //                   45: 650
    //                   90: 661
    //                   135: 672
    //                   180: 683
    //                   225: 694
    //                   270: 705
    //                   315: 716;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
        typedarray5.recycle();
        if(flag1) {
            gradientstate.mColors = new int[3];
            gradientstate.mColors[0] = i3;
            gradientstate.mColors[1] = j3;
            gradientstate.mColors[2] = k3;
            gradientstate.mPositions = new float[3];
            gradientstate.mPositions[0] = 0.0F;
            float af1[] = gradientstate.mPositions;
            TypedValue typedvalue;
            float f1;
            boolean flag2;
            float f2;
            if(gradientstate.mCenterX != 0.5F)
                f1 = gradientstate.mCenterX;
            else
                f1 = gradientstate.mCenterY;
            af1[1] = f1;
            gradientstate.mPositions[2] = 1.0F;
        } else {
            gradientstate.mColors = new int[2];
            gradientstate.mColors[0] = i3;
            gradientstate.mColors[1] = k3;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        gradientstate.mOrientation = Orientation.LEFT_RIGHT;
          goto _L3
_L5:
        gradientstate.mOrientation = Orientation.BL_TR;
          goto _L3
_L6:
        gradientstate.mOrientation = Orientation.BOTTOM_TOP;
          goto _L3
_L7:
        gradientstate.mOrientation = Orientation.BR_TL;
          goto _L3
_L8:
        gradientstate.mOrientation = Orientation.RIGHT_LEFT;
          goto _L3
_L9:
        gradientstate.mOrientation = Orientation.TR_BL;
          goto _L3
_L10:
        gradientstate.mOrientation = Orientation.TOP_BOTTOM;
          goto _L3
_L11:
        gradientstate.mOrientation = Orientation.TL_BR;
          goto _L3
_L2:
        typedvalue = typedarray5.peekValue(7);
        if(typedvalue == null)
            continue; /* Loop/switch isn't completed */
        if(typedvalue.type == 6)
            flag2 = true;
        else
            flag2 = false;
        if(flag2)
            f2 = typedvalue.getFraction(1.0F, 1.0F);
        else
            f2 = typedvalue.getFloat();
        gradientstate.mGradientRadius = f2;
          goto _L3
        if(l3 != 1) goto _L3; else goto _L12
_L12:
        throw new XmlPullParserException((new StringBuilder()).append(typedarray5.getPositionDescription()).append("<gradient> tag requires 'gradientRadius' ").append("attribute with radial type").toString());
        if(s.equals("solid")) {
            TypedArray typedarray4 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.GradientDrawableSolid);
            int l2 = typedarray4.getColor(0, 0);
            typedarray4.recycle();
            setColor(l2);
        } else
        if(s.equals("stroke")) {
            TypedArray typedarray3 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.GradientDrawableStroke);
            int j2 = typedarray3.getDimensionPixelSize(0, 0);
            int k2 = typedarray3.getColor(1, 0);
            float f = typedarray3.getDimension(2, 0.0F);
            if(f != 0.0F)
                setStroke(j2, k2, f, typedarray3.getDimension(3, 0.0F));
            else
                setStroke(j2, k2);
            typedarray3.recycle();
        } else
        if(s.equals("corners")) {
            TypedArray typedarray2 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.DrawableCorners);
            int i1 = typedarray2.getDimensionPixelSize(0, 0);
            setCornerRadius(i1);
            int j1 = typedarray2.getDimensionPixelSize(1, i1);
            int k1 = typedarray2.getDimensionPixelSize(2, i1);
            int l1 = typedarray2.getDimensionPixelSize(3, i1);
            int i2 = typedarray2.getDimensionPixelSize(4, i1);
            if(j1 != i1 || k1 != i1 || l1 != i1 || i2 != i1) {
                float af[] = new float[8];
                af[0] = j1;
                af[1] = j1;
                af[2] = k1;
                af[3] = k1;
                af[4] = i2;
                af[5] = i2;
                af[6] = l1;
                af[7] = l1;
                setCornerRadii(af);
            }
            typedarray2.recycle();
        } else
        if(s.equals("padding")) {
            TypedArray typedarray1 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.GradientDrawablePadding);
            mPadding = new Rect(typedarray1.getDimensionPixelOffset(0, 0), typedarray1.getDimensionPixelOffset(1, 0), typedarray1.getDimensionPixelOffset(2, 0), typedarray1.getDimensionPixelOffset(3, 0));
            typedarray1.recycle();
            mGradientState.mPadding = mPadding;
        } else {
            Log.w("drawable", (new StringBuilder()).append("Bad element under <shape>: ").append(s).toString());
        }
        if(true) goto _L14; else goto _L13
_L13:
    }

    public Drawable mutate() {
        if(!mMutated && super.mutate() == this) {
            mGradientState = new GradientState(mGradientState);
            initializeWithState(mGradientState);
            mMutated = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        mRingPath = null;
        mPathIsDirty = true;
        mRectIsDirty = true;
    }

    protected boolean onLevelChange(int i) {
        super.onLevelChange(i);
        mRectIsDirty = true;
        mPathIsDirty = true;
        invalidateSelf();
        return true;
    }

    public void setAlpha(int i) {
        if(i != mAlpha) {
            mAlpha = i;
            invalidateSelf();
        }
    }

    public void setColor(int i) {
        mGradientState.setSolidColor(i);
        mFillPaint.setColor(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorfilter) {
        if(colorfilter != mColorFilter) {
            mColorFilter = colorfilter;
            invalidateSelf();
        }
    }

    public void setColors(int ai[]) {
        mGradientState.setColors(ai);
        mRectIsDirty = true;
        invalidateSelf();
    }

    public void setCornerRadii(float af[]) {
        mGradientState.setCornerRadii(af);
        mPathIsDirty = true;
        invalidateSelf();
    }

    public void setCornerRadius(float f) {
        mGradientState.setCornerRadius(f);
        mPathIsDirty = true;
        invalidateSelf();
    }

    public void setDither(boolean flag) {
        if(flag != mDither) {
            mDither = flag;
            invalidateSelf();
        }
    }

    public void setGradientCenter(float f, float f1) {
        mGradientState.setGradientCenter(f, f1);
        mRectIsDirty = true;
        invalidateSelf();
    }

    public void setGradientRadius(float f) {
        mGradientState.setGradientRadius(f);
        mRectIsDirty = true;
        invalidateSelf();
    }

    public void setGradientType(int i) {
        mGradientState.setGradientType(i);
        mRectIsDirty = true;
        invalidateSelf();
    }

    public void setOrientation(Orientation orientation) {
        mGradientState.mOrientation = orientation;
        mRectIsDirty = true;
        invalidateSelf();
    }

    public void setShape(int i) {
        mRingPath = null;
        mPathIsDirty = true;
        mGradientState.setShape(i);
        invalidateSelf();
    }

    public void setSize(int i, int j) {
        mGradientState.setSize(i, j);
        mPathIsDirty = true;
        invalidateSelf();
    }

    public void setStroke(int i, int j) {
        setStroke(i, j, 0.0F, 0.0F);
    }

    public void setStroke(int i, int j, float f, float f1) {
        mGradientState.setStroke(i, j, f, f1);
        if(mStrokePaint == null) {
            mStrokePaint = new Paint(1);
            mStrokePaint.setStyle(android.graphics.Paint.Style.STROKE);
        }
        mStrokePaint.setStrokeWidth(i);
        mStrokePaint.setColor(j);
        DashPathEffect dashpatheffect = null;
        if(f > 0.0F) {
            float af[] = new float[2];
            af[0] = f;
            af[1] = f1;
            dashpatheffect = new DashPathEffect(af, 0.0F);
        }
        mStrokePaint.setPathEffect(dashpatheffect);
        invalidateSelf();
    }

    public void setUseLevel(boolean flag) {
        mGradientState.mUseLevel = flag;
        mRectIsDirty = true;
        invalidateSelf();
    }

    public static final int LINE = 2;
    public static final int LINEAR_GRADIENT = 0;
    public static final int OVAL = 1;
    public static final int RADIAL_GRADIENT = 1;
    public static final int RECTANGLE = 0;
    public static final int RING = 3;
    public static final int SWEEP_GRADIENT = 2;
    private int mAlpha;
    private ColorFilter mColorFilter;
    private boolean mDither;
    private final Paint mFillPaint;
    private GradientState mGradientState;
    private Paint mLayerPaint;
    private boolean mMutated;
    private Rect mPadding;
    private final Path mPath;
    private boolean mPathIsDirty;
    private final RectF mRect;
    private boolean mRectIsDirty;
    private Path mRingPath;
    private Paint mStrokePaint;
}
