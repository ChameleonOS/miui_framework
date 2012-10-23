// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.text.*;
import java.util.Locale;

// Referenced classes of package android.graphics:
//            TemporaryBuffer, Path, ColorFilter, MaskFilter, 
//            PathEffect, Rasterizer, Shader, Typeface, 
//            Xfermode, Rect

public class Paint {
    public static class FontMetricsInt {

        public String toString() {
            return (new StringBuilder()).append("FontMetricsInt: top=").append(top).append(" ascent=").append(ascent).append(" descent=").append(descent).append(" bottom=").append(bottom).append(" leading=").append(leading).toString();
        }

        public int ascent;
        public int bottom;
        public int descent;
        public int leading;
        public int top;

        public FontMetricsInt() {
        }
    }

    public static class FontMetrics {

        public float ascent;
        public float bottom;
        public float descent;
        public float leading;
        public float top;

        public FontMetrics() {
        }
    }

    public static final class Align extends Enum {

        public static Align valueOf(String s) {
            return (Align)Enum.valueOf(android/graphics/Paint$Align, s);
        }

        public static Align[] values() {
            return (Align[])$VALUES.clone();
        }

        private static final Align $VALUES[];
        public static final Align CENTER;
        public static final Align LEFT;
        public static final Align RIGHT;
        final int nativeInt;

        static  {
            LEFT = new Align("LEFT", 0, 0);
            CENTER = new Align("CENTER", 1, 1);
            RIGHT = new Align("RIGHT", 2, 2);
            Align aalign[] = new Align[3];
            aalign[0] = LEFT;
            aalign[1] = CENTER;
            aalign[2] = RIGHT;
            $VALUES = aalign;
        }

        private Align(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }

    public static final class Join extends Enum {

        public static Join valueOf(String s) {
            return (Join)Enum.valueOf(android/graphics/Paint$Join, s);
        }

        public static Join[] values() {
            return (Join[])$VALUES.clone();
        }

        private static final Join $VALUES[];
        public static final Join BEVEL;
        public static final Join MITER;
        public static final Join ROUND;
        final int nativeInt;

        static  {
            MITER = new Join("MITER", 0, 0);
            ROUND = new Join("ROUND", 1, 1);
            BEVEL = new Join("BEVEL", 2, 2);
            Join ajoin[] = new Join[3];
            ajoin[0] = MITER;
            ajoin[1] = ROUND;
            ajoin[2] = BEVEL;
            $VALUES = ajoin;
        }

        private Join(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }

    public static final class Cap extends Enum {

        public static Cap valueOf(String s) {
            return (Cap)Enum.valueOf(android/graphics/Paint$Cap, s);
        }

        public static Cap[] values() {
            return (Cap[])$VALUES.clone();
        }

        private static final Cap $VALUES[];
        public static final Cap BUTT;
        public static final Cap ROUND;
        public static final Cap SQUARE;
        final int nativeInt;

        static  {
            BUTT = new Cap("BUTT", 0, 0);
            ROUND = new Cap("ROUND", 1, 1);
            SQUARE = new Cap("SQUARE", 2, 2);
            Cap acap[] = new Cap[3];
            acap[0] = BUTT;
            acap[1] = ROUND;
            acap[2] = SQUARE;
            $VALUES = acap;
        }

        private Cap(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }

    public static final class Style extends Enum {

        public static Style valueOf(String s) {
            return (Style)Enum.valueOf(android/graphics/Paint$Style, s);
        }

        public static Style[] values() {
            return (Style[])$VALUES.clone();
        }

        private static final Style $VALUES[];
        public static final Style FILL;
        public static final Style FILL_AND_STROKE;
        public static final Style STROKE;
        final int nativeInt;

        static  {
            FILL = new Style("FILL", 0, 0);
            STROKE = new Style("STROKE", 1, 1);
            FILL_AND_STROKE = new Style("FILL_AND_STROKE", 2, 2);
            Style astyle[] = new Style[3];
            astyle[0] = FILL;
            astyle[1] = STROKE;
            astyle[2] = FILL_AND_STROKE;
            $VALUES = astyle;
        }

        private Style(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }


    public Paint() {
        this(0);
    }

    public Paint(int i) {
        mBidiFlags = 2;
        mNativePaint = native_init();
        setFlags(i | 0x100);
        mInvCompatScaling = 1.0F;
        mCompatScaling = 1.0F;
        setTextLocale(Locale.getDefault());
    }

    public Paint(Paint paint) {
        mBidiFlags = 2;
        mNativePaint = native_initWithPaint(paint.mNativePaint);
        setClassVariablesFrom(paint);
    }

    private static native void finalizer(int i);

    private native void nSetShadowLayer(float f, float f1, float f2, int i);

    private static native void nativeGetCharArrayBounds(int i, char ac[], int j, int k, Rect rect);

    private static native void nativeGetStringBounds(int i, String s, int j, int k, Rect rect);

    private native int native_breakText(String s, boolean flag, float f, float af[]);

    private native int native_breakText(char ac[], int i, int j, float f, float af[]);

    private static native boolean native_getFillPath(int i, int j, int k);

    private static native int native_getStrokeCap(int i);

    private static native int native_getStrokeJoin(int i);

    private static native int native_getStyle(int i);

    private static native int native_getTextAlign(int i);

    private static native int native_getTextGlyphs(int i, String s, int j, int k, int l, int i1, int j1, char ac[]);

    private static native void native_getTextPath(int i, int j, String s, int k, int l, float f, float f1, int i1);

    private static native void native_getTextPath(int i, int j, char ac[], int k, int l, float f, float f1, int i1);

    private static native float native_getTextRunAdvances(int i, String s, int j, int k, int l, int i1, int j1, float af[], 
            int k1, int l1);

    private static native float native_getTextRunAdvances(int i, char ac[], int j, int k, int l, int i1, int j1, float af[], 
            int k1, int l1);

    private native int native_getTextRunCursor(int i, String s, int j, int k, int l, int i1, int j1);

    private native int native_getTextRunCursor(int i, char ac[], int j, int k, int l, int i1, int j1);

    private static native int native_getTextWidths(int i, String s, int j, int k, float af[]);

    private static native int native_getTextWidths(int i, char ac[], int j, int k, float af[]);

    private static native int native_init();

    private static native int native_initWithPaint(int i);

    private native float native_measureText(String s);

    private native float native_measureText(String s, int i, int j);

    private native float native_measureText(char ac[], int i, int j);

    private static native void native_reset(int i);

    private static native void native_set(int i, int j);

    private static native int native_setColorFilter(int i, int j);

    private static native int native_setMaskFilter(int i, int j);

    private static native int native_setPathEffect(int i, int j);

    private static native int native_setRasterizer(int i, int j);

    private static native int native_setShader(int i, int j);

    private static native void native_setStrokeCap(int i, int j);

    private static native void native_setStrokeJoin(int i, int j);

    private static native void native_setStyle(int i, int j);

    private static native void native_setTextAlign(int i, int j);

    private static native void native_setTextLocale(int i, String s);

    private static native int native_setTypeface(int i, int j);

    private static native int native_setXfermode(int i, int j);

    private void setClassVariablesFrom(Paint paint) {
        mColorFilter = paint.mColorFilter;
        mMaskFilter = paint.mMaskFilter;
        mPathEffect = paint.mPathEffect;
        mRasterizer = paint.mRasterizer;
        mShader = paint.mShader;
        mTypeface = paint.mTypeface;
        mXfermode = paint.mXfermode;
        mHasCompatScaling = paint.mHasCompatScaling;
        mCompatScaling = paint.mCompatScaling;
        mInvCompatScaling = paint.mInvCompatScaling;
        hasShadow = paint.hasShadow;
        shadowDx = paint.shadowDx;
        shadowDy = paint.shadowDy;
        shadowRadius = paint.shadowRadius;
        shadowColor = paint.shadowColor;
        mBidiFlags = paint.mBidiFlags;
        mLocale = paint.mLocale;
    }

    public native float ascent();

    public int breakText(CharSequence charsequence, int i, int j, boolean flag, float f, float af[]) {
        if(charsequence == null)
            throw new IllegalArgumentException("text cannot be null");
        if((i | j | j - i | charsequence.length() - j) < 0)
            throw new IndexOutOfBoundsException();
        int k;
        if(charsequence.length() == 0 || i == j)
            k = 0;
        else
        if(i == 0 && (charsequence instanceof String) && j == charsequence.length()) {
            k = breakText((String)charsequence, flag, f, af);
        } else {
            char ac[] = TemporaryBuffer.obtain(j - i);
            TextUtils.getChars(charsequence, i, j, ac, 0);
            if(flag)
                k = breakText(ac, 0, j - i, f, af);
            else
                k = breakText(ac, 0, -(j - i), f, af);
            TemporaryBuffer.recycle(ac);
        }
        return k;
    }

    public int breakText(String s, boolean flag, float f, float af[]) {
        if(s == null)
            throw new IllegalArgumentException("text cannot be null");
        if(s.length() != 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        return i;
_L2:
        if(!mHasCompatScaling) {
            i = native_breakText(s, flag, f, af);
        } else {
            float f1 = getTextSize();
            setTextSize(f1 * mCompatScaling);
            i = native_breakText(s, flag, f * mCompatScaling, af);
            setTextSize(f1);
            if(af != null)
                af[0] = af[0] * mInvCompatScaling;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int breakText(char ac[], int i, int j, float f, float af[]) {
        if(ac == null)
            throw new IllegalArgumentException("text cannot be null");
        if(i < 0 || ac.length - i < Math.abs(j))
            throw new ArrayIndexOutOfBoundsException();
        if(ac.length != 0 && j != 0) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        if(!mHasCompatScaling) {
            k = native_breakText(ac, i, j, f, af);
        } else {
            float f1 = getTextSize();
            setTextSize(f1 * mCompatScaling);
            k = native_breakText(ac, i, j, f * mCompatScaling, af);
            setTextSize(f1);
            if(af != null)
                af[0] = af[0] * mInvCompatScaling;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void clearShadowLayer() {
        hasShadow = false;
        nSetShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }

    public native float descent();

    protected void finalize() throws Throwable {
        finalizer(mNativePaint);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public native int getAlpha();

    public int getBidiFlags() {
        return mBidiFlags;
    }

    public native int getColor();

    public ColorFilter getColorFilter() {
        return mColorFilter;
    }

    public boolean getFillPath(Path path, Path path1) {
        return native_getFillPath(mNativePaint, path.ni(), path1.ni());
    }

    public native int getFlags();

    public native float getFontMetrics(FontMetrics fontmetrics);

    public FontMetrics getFontMetrics() {
        FontMetrics fontmetrics = new FontMetrics();
        getFontMetrics(fontmetrics);
        return fontmetrics;
    }

    public native int getFontMetricsInt(FontMetricsInt fontmetricsint);

    public FontMetricsInt getFontMetricsInt() {
        FontMetricsInt fontmetricsint = new FontMetricsInt();
        getFontMetricsInt(fontmetricsint);
        return fontmetricsint;
    }

    public float getFontSpacing() {
        return getFontMetrics(null);
    }

    public native int getHinting();

    public MaskFilter getMaskFilter() {
        return mMaskFilter;
    }

    public PathEffect getPathEffect() {
        return mPathEffect;
    }

    public Rasterizer getRasterizer() {
        return mRasterizer;
    }

    public Shader getShader() {
        return mShader;
    }

    public Cap getStrokeCap() {
        return sCapArray[native_getStrokeCap(mNativePaint)];
    }

    public Join getStrokeJoin() {
        return sJoinArray[native_getStrokeJoin(mNativePaint)];
    }

    public native float getStrokeMiter();

    public native float getStrokeWidth();

    public Style getStyle() {
        return sStyleArray[native_getStyle(mNativePaint)];
    }

    public Align getTextAlign() {
        return sAlignArray[native_getTextAlign(mNativePaint)];
    }

    public void getTextBounds(String s, int i, int j, Rect rect) {
        if((i | j | j - i | s.length() - j) < 0)
            throw new IndexOutOfBoundsException();
        if(rect == null) {
            throw new NullPointerException("need bounds Rect");
        } else {
            nativeGetStringBounds(mNativePaint, s, i, j, rect);
            return;
        }
    }

    public void getTextBounds(char ac[], int i, int j, Rect rect) {
        if((i | j) < 0 || i + j > ac.length)
            throw new ArrayIndexOutOfBoundsException();
        if(rect == null) {
            throw new NullPointerException("need bounds Rect");
        } else {
            nativeGetCharArrayBounds(mNativePaint, ac, i, j, rect);
            return;
        }
    }

    public int getTextGlyphs(String s, int i, int j, int k, int l, int i1, char ac[]) {
        if(s == null)
            throw new IllegalArgumentException("text cannot be null");
        if(i1 != 0 && i1 != 1)
            throw new IllegalArgumentException((new StringBuilder()).append("unknown flags value: ").append(i1).toString());
        if((l | (k | (i | j)) | j - i | i - k | l - j | s.length() - j | s.length() - l) < 0)
            throw new IndexOutOfBoundsException();
        if(j - i > ac.length)
            throw new ArrayIndexOutOfBoundsException();
        else
            return native_getTextGlyphs(mNativePaint, s, i, j, k, l, i1, ac);
    }

    public Locale getTextLocale() {
        return mLocale;
    }

    public void getTextPath(String s, int i, int j, float f, float f1, Path path) {
        if((i | j | j - i | s.length() - j) < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            native_getTextPath(mNativePaint, mBidiFlags, s, i, j, f, f1, path.ni());
            return;
        }
    }

    public void getTextPath(char ac[], int i, int j, float f, float f1, Path path) {
        if((i | j) < 0 || i + j > ac.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            native_getTextPath(mNativePaint, mBidiFlags, ac, i, j, f, f1, path.ni());
            return;
        }
    }

    public float getTextRunAdvances(CharSequence charsequence, int i, int j, int k, int l, int i1, float af[], 
            int j1) {
        return getTextRunAdvances(charsequence, i, j, k, l, i1, af, j1, 0);
    }

    public float getTextRunAdvances(CharSequence charsequence, int i, int j, int k, int l, int i1, float af[], 
            int j1, int k1) {
        if(charsequence == null)
            throw new IllegalArgumentException("text cannot be null");
        int l1 = j1 | (l | (k | (i | j))) | j - i | i - k | l - j | charsequence.length() - l;
        int i2;
        if(af == null)
            i2 = 0;
        else
            i2 = af.length - j1 - (j - i);
        if((i2 | l1) < 0)
            throw new IndexOutOfBoundsException();
        float f;
        if(charsequence instanceof String)
            f = getTextRunAdvances((String)charsequence, i, j, k, l, i1, af, j1, k1);
        else
        if((charsequence instanceof SpannedString) || (charsequence instanceof SpannableString))
            f = getTextRunAdvances(charsequence.toString(), i, j, k, l, i1, af, j1, k1);
        else
        if(charsequence instanceof GraphicsOperations)
            f = ((GraphicsOperations)charsequence).getTextRunAdvances(i, j, k, l, i1, af, j1, this);
        else
        if(charsequence.length() == 0 || j == i) {
            f = 0.0F;
        } else {
            int j2 = l - k;
            int k2 = j - i;
            char ac[] = TemporaryBuffer.obtain(j2);
            TextUtils.getChars(charsequence, k, l, ac, 0);
            f = getTextRunAdvances(ac, i - k, k2, 0, j2, i1, af, j1, k1);
            TemporaryBuffer.recycle(ac);
        }
        return f;
    }

    public float getTextRunAdvances(String s, int i, int j, int k, int l, int i1, float af[], 
            int j1) {
        return getTextRunAdvances(s, i, j, k, l, i1, af, j1, 0);
    }

    public float getTextRunAdvances(String s, int i, int j, int k, int l, int i1, float af[], 
            int j1, int k1) {
        if(s == null)
            throw new IllegalArgumentException("text cannot be null");
        if(i1 != 0 && i1 != 1)
            throw new IllegalArgumentException((new StringBuilder()).append("unknown flags value: ").append(i1).toString());
        int l1 = j1 | (l | (k | (i | j))) | j - i | i - k | l - j | s.length() - l;
        int i2;
        if(af == null)
            i2 = 0;
        else
            i2 = af.length - j1 - (j - i);
        if((i2 | l1) < 0)
            throw new IndexOutOfBoundsException();
        float f;
        if(s.length() == 0 || i == j)
            f = 0.0F;
        else
        if(!mHasCompatScaling) {
            f = native_getTextRunAdvances(mNativePaint, s, i, j, k, l, i1, af, j1, k1);
        } else {
            float f1 = getTextSize();
            setTextSize(f1 * mCompatScaling);
            float f2 = native_getTextRunAdvances(mNativePaint, s, i, j, k, l, i1, af, j1, k1);
            setTextSize(f1);
            if(af != null) {
                int j2 = j1;
                for(int k2 = j2 + (j - i); j2 < k2; j2++)
                    af[j2] = af[j2] * mInvCompatScaling;

            }
            f = f2 * mInvCompatScaling;
        }
        return f;
    }

    public float getTextRunAdvances(char ac[], int i, int j, int k, int l, int i1, float af[], 
            int j1) {
        return getTextRunAdvances(ac, i, j, k, l, i1, af, j1, 0);
    }

    public float getTextRunAdvances(char ac[], int i, int j, int k, int l, int i1, float af[], 
            int j1, int k1) {
        if(ac == null)
            throw new IllegalArgumentException("text cannot be null");
        if(i1 != 0 && i1 != 1)
            throw new IllegalArgumentException((new StringBuilder()).append("unknown flags value: ").append(i1).toString());
        int l1 = j1 | (l | (k | (i | j))) | i - k | l - j | (k + l) - (i + j) | ac.length - (k + l);
        int i2;
        if(af == null)
            i2 = 0;
        else
            i2 = af.length - (j1 + j);
        if((i2 | l1) < 0)
            throw new IndexOutOfBoundsException();
        float f;
        if(ac.length == 0 || j == 0)
            f = 0.0F;
        else
        if(!mHasCompatScaling) {
            f = native_getTextRunAdvances(mNativePaint, ac, i, j, k, l, i1, af, j1, k1);
        } else {
            float f1 = getTextSize();
            setTextSize(f1 * mCompatScaling);
            float f2 = native_getTextRunAdvances(mNativePaint, ac, i, j, k, l, i1, af, j1, k1);
            setTextSize(f1);
            if(af != null) {
                int j2 = j1;
                for(int k2 = j2 + j; j2 < k2; j2++)
                    af[j2] = af[j2] * mInvCompatScaling;

            }
            f = f2 * mInvCompatScaling;
        }
        return f;
    }

    public int getTextRunCursor(CharSequence charsequence, int i, int j, int k, int l, int i1) {
        int j1;
        if((charsequence instanceof String) || (charsequence instanceof SpannedString) || (charsequence instanceof SpannableString))
            j1 = getTextRunCursor(charsequence.toString(), i, j, k, l, i1);
        else
        if(charsequence instanceof GraphicsOperations) {
            j1 = ((GraphicsOperations)charsequence).getTextRunCursor(i, j, k, l, i1, this);
        } else {
            int k1 = j - i;
            char ac[] = TemporaryBuffer.obtain(k1);
            TextUtils.getChars(charsequence, i, j, ac, 0);
            j1 = getTextRunCursor(ac, 0, k1, k, l - i, i1);
            TemporaryBuffer.recycle(ac);
        }
        return j1;
    }

    public int getTextRunCursor(String s, int i, int j, int k, int l, int i1) {
        if((i1 | (l | (i | j) | j - i | l - i | j - l | s.length() - j)) < 0 || i1 > 4)
            throw new IndexOutOfBoundsException();
        else
            return native_getTextRunCursor(mNativePaint, s, i, j, k, l, i1);
    }

    public int getTextRunCursor(char ac[], int i, int j, int k, int l, int i1) {
        int j1 = i + j;
        if((i1 | (l | (i | j1) | j1 - i | l - i | j1 - l | ac.length - j1)) < 0 || i1 > 4)
            throw new IndexOutOfBoundsException();
        else
            return native_getTextRunCursor(mNativePaint, ac, i, j, k, l, i1);
    }

    public native float getTextScaleX();

    public native float getTextSize();

    public native float getTextSkewX();

    public int getTextWidths(CharSequence charsequence, int i, int j, float af[]) {
        int k = 0;
        if(charsequence == null)
            throw new IllegalArgumentException("text cannot be null");
        if((i | j | j - i | charsequence.length() - j) < 0)
            throw new IndexOutOfBoundsException();
        if(j - i > af.length)
            throw new ArrayIndexOutOfBoundsException();
        if(charsequence.length() != 0 && i != j)
            if(charsequence instanceof String)
                k = getTextWidths((String)charsequence, i, j, af);
            else
            if((charsequence instanceof SpannedString) || (charsequence instanceof SpannableString))
                k = getTextWidths(charsequence.toString(), i, j, af);
            else
            if(charsequence instanceof GraphicsOperations) {
                k = ((GraphicsOperations)charsequence).getTextWidths(i, j, af, this);
            } else {
                char ac[] = TemporaryBuffer.obtain(j - i);
                TextUtils.getChars(charsequence, i, j, ac, 0);
                k = getTextWidths(ac, 0, j - i, af);
                TemporaryBuffer.recycle(ac);
            }
        return k;
    }

    public int getTextWidths(String s, int i, int j, float af[]) {
        if(s == null)
            throw new IllegalArgumentException("text cannot be null");
        if((i | j | j - i | s.length() - j) < 0)
            throw new IndexOutOfBoundsException();
        if(j - i > af.length)
            throw new ArrayIndexOutOfBoundsException();
        if(s.length() != 0 && i != j) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        if(mHasCompatScaling)
            break; /* Loop/switch isn't completed */
        k = native_getTextWidths(mNativePaint, s, i, j, af);
        if(true) goto _L4; else goto _L3
_L3:
        float f = getTextSize();
        setTextSize(f * mCompatScaling);
        k = native_getTextWidths(mNativePaint, s, i, j, af);
        setTextSize(f);
        int l = 0;
        while(l < k)  {
            af[l] = af[l] * mInvCompatScaling;
            l++;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    public int getTextWidths(String s, float af[]) {
        return getTextWidths(s, 0, s.length(), af);
    }

    public int getTextWidths(char ac[], int i, int j, float af[]) {
        if(ac == null)
            throw new IllegalArgumentException("text cannot be null");
        if((i | j) < 0 || i + j > ac.length || j > af.length)
            throw new ArrayIndexOutOfBoundsException();
        if(ac.length != 0 && j != 0) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        if(mHasCompatScaling)
            break; /* Loop/switch isn't completed */
        k = native_getTextWidths(mNativePaint, ac, i, j, af);
        if(true) goto _L4; else goto _L3
_L3:
        float f = getTextSize();
        setTextSize(f * mCompatScaling);
        k = native_getTextWidths(mNativePaint, ac, i, j, af);
        setTextSize(f);
        int l = 0;
        while(l < k)  {
            af[l] = af[l] * mInvCompatScaling;
            l++;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    public Typeface getTypeface() {
        return mTypeface;
    }

    public Xfermode getXfermode() {
        return mXfermode;
    }

    public final boolean isAntiAlias() {
        boolean flag;
        if((1 & getFlags()) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isDither() {
        boolean flag;
        if((4 & getFlags()) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isFakeBoldText() {
        boolean flag;
        if((0x20 & getFlags()) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isFilterBitmap() {
        boolean flag;
        if((2 & getFlags()) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isLinearText() {
        boolean flag;
        if((0x40 & getFlags()) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isStrikeThruText() {
        boolean flag;
        if((0x10 & getFlags()) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isSubpixelText() {
        boolean flag;
        if((0x80 & getFlags()) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isUnderlineText() {
        boolean flag;
        if((8 & getFlags()) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public float measureText(CharSequence charsequence, int i, int j) {
        if(charsequence == null)
            throw new IllegalArgumentException("text cannot be null");
        if((i | j | j - i | charsequence.length() - j) < 0)
            throw new IndexOutOfBoundsException();
        float f;
        if(charsequence.length() == 0 || i == j)
            f = 0.0F;
        else
        if(charsequence instanceof String)
            f = measureText((String)charsequence, i, j);
        else
        if((charsequence instanceof SpannedString) || (charsequence instanceof SpannableString))
            f = measureText(charsequence.toString(), i, j);
        else
        if(charsequence instanceof GraphicsOperations) {
            f = ((GraphicsOperations)charsequence).measureText(i, j, this);
        } else {
            char ac[] = TemporaryBuffer.obtain(j - i);
            TextUtils.getChars(charsequence, i, j, ac, 0);
            f = measureText(ac, 0, j - i);
            TemporaryBuffer.recycle(ac);
        }
        return f;
    }

    public float measureText(String s) {
        if(s == null)
            throw new IllegalArgumentException("text cannot be null");
        float f2;
        if(s.length() == 0)
            f2 = 0.0F;
        else
        if(!mHasCompatScaling) {
            f2 = native_measureText(s);
        } else {
            float f = getTextSize();
            setTextSize(f * mCompatScaling);
            float f1 = native_measureText(s);
            setTextSize(f);
            f2 = f1 * mInvCompatScaling;
        }
        return f2;
    }

    public float measureText(String s, int i, int j) {
        if(s == null)
            throw new IllegalArgumentException("text cannot be null");
        if((i | j | j - i | s.length() - j) < 0)
            throw new IndexOutOfBoundsException();
        float f;
        if(s.length() == 0 || i == j)
            f = 0.0F;
        else
        if(!mHasCompatScaling) {
            f = native_measureText(s, i, j);
        } else {
            float f1 = getTextSize();
            setTextSize(f1 * mCompatScaling);
            float f2 = native_measureText(s, i, j);
            setTextSize(f1);
            f = f2 * mInvCompatScaling;
        }
        return f;
    }

    public float measureText(char ac[], int i, int j) {
        if(ac == null)
            throw new IllegalArgumentException("text cannot be null");
        if((i | j) < 0 || i + j > ac.length)
            throw new ArrayIndexOutOfBoundsException();
        float f;
        if(ac.length == 0 || j == 0)
            f = 0.0F;
        else
        if(!mHasCompatScaling) {
            f = native_measureText(ac, i, j);
        } else {
            float f1 = getTextSize();
            setTextSize(f1 * mCompatScaling);
            float f2 = native_measureText(ac, i, j);
            setTextSize(f1);
            f = f2 * mInvCompatScaling;
        }
        return f;
    }

    public void reset() {
        native_reset(mNativePaint);
        setFlags(256);
        mHasCompatScaling = false;
        mInvCompatScaling = 1.0F;
        mCompatScaling = 1.0F;
        mBidiFlags = 2;
        setTextLocale(Locale.getDefault());
    }

    public void set(Paint paint) {
        if(this != paint) {
            native_set(mNativePaint, paint.mNativePaint);
            setClassVariablesFrom(paint);
        }
    }

    public void setARGB(int i, int j, int k, int l) {
        setColor(l | (i << 24 | j << 16 | k << 8));
    }

    public native void setAlpha(int i);

    public native void setAntiAlias(boolean flag);

    public void setBidiFlags(int i) {
        int j = i & 7;
        if(j > 5) {
            throw new IllegalArgumentException((new StringBuilder()).append("unknown bidi flag: ").append(j).toString());
        } else {
            mBidiFlags = j;
            return;
        }
    }

    public native void setColor(int i);

    public ColorFilter setColorFilter(ColorFilter colorfilter) {
        int i = 0;
        if(colorfilter != null)
            i = colorfilter.native_instance;
        native_setColorFilter(mNativePaint, i);
        mColorFilter = colorfilter;
        return colorfilter;
    }

    public void setCompatibilityScaling(float f) {
        if((double)f == 1.0D) {
            mHasCompatScaling = false;
            mInvCompatScaling = 1.0F;
            mCompatScaling = 1.0F;
        } else {
            mHasCompatScaling = true;
            mCompatScaling = f;
            mInvCompatScaling = 1.0F / f;
        }
    }

    public native void setDither(boolean flag);

    public native void setFakeBoldText(boolean flag);

    public native void setFilterBitmap(boolean flag);

    public native void setFlags(int i);

    public native void setHinting(int i);

    public native void setLinearText(boolean flag);

    public MaskFilter setMaskFilter(MaskFilter maskfilter) {
        int i = 0;
        if(maskfilter != null)
            i = maskfilter.native_instance;
        native_setMaskFilter(mNativePaint, i);
        mMaskFilter = maskfilter;
        return maskfilter;
    }

    public PathEffect setPathEffect(PathEffect patheffect) {
        int i = 0;
        if(patheffect != null)
            i = patheffect.native_instance;
        native_setPathEffect(mNativePaint, i);
        mPathEffect = patheffect;
        return patheffect;
    }

    public Rasterizer setRasterizer(Rasterizer rasterizer) {
        int i = 0;
        if(rasterizer != null)
            i = rasterizer.native_instance;
        native_setRasterizer(mNativePaint, i);
        mRasterizer = rasterizer;
        return rasterizer;
    }

    public Shader setShader(Shader shader) {
        int i = 0;
        if(shader != null)
            i = shader.native_instance;
        native_setShader(mNativePaint, i);
        mShader = shader;
        return shader;
    }

    public void setShadowLayer(float f, float f1, float f2, int i) {
        boolean flag;
        if(f > 0.0F)
            flag = true;
        else
            flag = false;
        hasShadow = flag;
        shadowRadius = f;
        shadowDx = f1;
        shadowDy = f2;
        shadowColor = i;
        nSetShadowLayer(f, f1, f2, i);
    }

    public native void setStrikeThruText(boolean flag);

    public void setStrokeCap(Cap cap) {
        native_setStrokeCap(mNativePaint, cap.nativeInt);
    }

    public void setStrokeJoin(Join join) {
        native_setStrokeJoin(mNativePaint, join.nativeInt);
    }

    public native void setStrokeMiter(float f);

    public native void setStrokeWidth(float f);

    public void setStyle(Style style) {
        native_setStyle(mNativePaint, style.nativeInt);
    }

    public native void setSubpixelText(boolean flag);

    public void setTextAlign(Align align) {
        native_setTextAlign(mNativePaint, align.nativeInt);
    }

    public void setTextLocale(Locale locale) {
        if(locale == null)
            throw new IllegalArgumentException("locale cannot be null");
        if(!locale.equals(mLocale)) {
            mLocale = locale;
            native_setTextLocale(mNativePaint, locale.toString());
        }
    }

    public native void setTextScaleX(float f);

    public native void setTextSize(float f);

    public native void setTextSkewX(float f);

    public Typeface setTypeface(Typeface typeface) {
        int i = 0;
        if(typeface != null)
            i = typeface.native_instance;
        native_setTypeface(mNativePaint, i);
        mTypeface = typeface;
        return typeface;
    }

    public native void setUnderlineText(boolean flag);

    public Xfermode setXfermode(Xfermode xfermode) {
        int i = 0;
        if(xfermode != null)
            i = xfermode.native_instance;
        native_setXfermode(mNativePaint, i);
        mXfermode = xfermode;
        return xfermode;
    }

    public static final int ANTI_ALIAS_FLAG = 1;
    public static final int BIDI_DEFAULT_LTR = 2;
    public static final int BIDI_DEFAULT_RTL = 3;
    private static final int BIDI_FLAG_MASK = 7;
    public static final int BIDI_FORCE_LTR = 4;
    public static final int BIDI_FORCE_RTL = 5;
    public static final int BIDI_LTR = 0;
    private static final int BIDI_MAX_FLAG_VALUE = 5;
    public static final int BIDI_RTL = 1;
    public static final int CURSOR_AFTER = 0;
    public static final int CURSOR_AT = 4;
    public static final int CURSOR_AT_OR_AFTER = 1;
    public static final int CURSOR_AT_OR_BEFORE = 3;
    public static final int CURSOR_BEFORE = 2;
    private static final int CURSOR_OPT_MAX_VALUE = 4;
    static final int DEFAULT_PAINT_FLAGS = 256;
    public static final int DEV_KERN_TEXT_FLAG = 256;
    public static final int DIRECTION_LTR = 0;
    public static final int DIRECTION_RTL = 1;
    public static final int DITHER_FLAG = 4;
    public static final int FAKE_BOLD_TEXT_FLAG = 32;
    public static final int FILTER_BITMAP_FLAG = 2;
    public static final int HINTING_OFF = 0;
    public static final int HINTING_ON = 1;
    public static final int LINEAR_TEXT_FLAG = 64;
    public static final int STRIKE_THRU_TEXT_FLAG = 16;
    public static final int SUBPIXEL_TEXT_FLAG = 128;
    public static final int UNDERLINE_TEXT_FLAG = 8;
    static final Align sAlignArray[];
    static final Cap sCapArray[];
    static final Join sJoinArray[];
    static final Style sStyleArray[];
    public boolean hasShadow;
    public int mBidiFlags;
    private ColorFilter mColorFilter;
    private float mCompatScaling;
    private boolean mHasCompatScaling;
    private float mInvCompatScaling;
    private Locale mLocale;
    private MaskFilter mMaskFilter;
    public int mNativePaint;
    private PathEffect mPathEffect;
    private Rasterizer mRasterizer;
    private Shader mShader;
    private Typeface mTypeface;
    private Xfermode mXfermode;
    public int shadowColor;
    public float shadowDx;
    public float shadowDy;
    public float shadowRadius;

    static  {
        Style astyle[] = new Style[3];
        astyle[0] = Style.FILL;
        astyle[1] = Style.STROKE;
        astyle[2] = Style.FILL_AND_STROKE;
        sStyleArray = astyle;
        Cap acap[] = new Cap[3];
        acap[0] = Cap.BUTT;
        acap[1] = Cap.ROUND;
        acap[2] = Cap.SQUARE;
        sCapArray = acap;
        Join ajoin[] = new Join[3];
        ajoin[0] = Join.MITER;
        ajoin[1] = Join.ROUND;
        ajoin[2] = Join.BEVEL;
        sJoinArray = ajoin;
        Align aalign[] = new Align[3];
        aalign[0] = Align.LEFT;
        aalign[1] = Align.CENTER;
        aalign[2] = Align.RIGHT;
        sAlignArray = aalign;
    }
}
