// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import java.io.OutputStream;
import java.nio.*;

// Referenced classes of package android.graphics:
//            Matrix, Canvas, Rect, RectF, 
//            Paint

public final class Bitmap
    implements Parcelable {
    private static class BitmapFinalizer {

        public void finalize() {
            super.finalize();
            Bitmap.nativeDestructor(mNativeBitmap);
_L2:
            return;
            Throwable throwable;
            throwable;
            Bitmap.nativeDestructor(mNativeBitmap);
            if(true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            Bitmap.nativeDestructor(mNativeBitmap);
            throw exception;
        }

        private final int mNativeBitmap;

        BitmapFinalizer(int i) {
            mNativeBitmap = i;
        }
    }

    public static final class CompressFormat extends Enum {

        public static CompressFormat valueOf(String s) {
            return (CompressFormat)Enum.valueOf(android/graphics/Bitmap$CompressFormat, s);
        }

        public static CompressFormat[] values() {
            return (CompressFormat[])$VALUES.clone();
        }

        private static final CompressFormat $VALUES[];
        public static final CompressFormat JPEG;
        public static final CompressFormat PNG;
        public static final CompressFormat WEBP;
        final int nativeInt;

        static  {
            JPEG = new CompressFormat("JPEG", 0, 0);
            PNG = new CompressFormat("PNG", 1, 1);
            WEBP = new CompressFormat("WEBP", 2, 2);
            CompressFormat acompressformat[] = new CompressFormat[3];
            acompressformat[0] = JPEG;
            acompressformat[1] = PNG;
            acompressformat[2] = WEBP;
            $VALUES = acompressformat;
        }

        private CompressFormat(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }

    public static final class Config extends Enum {

        static Config nativeToConfig(int i) {
            return sConfigs[i];
        }

        public static Config valueOf(String s) {
            return (Config)Enum.valueOf(android/graphics/Bitmap$Config, s);
        }

        public static Config[] values() {
            return (Config[])$VALUES.clone();
        }

        private static final Config $VALUES[];
        public static final Config ALPHA_8;
        public static final Config ARGB_4444;
        public static final Config ARGB_8888;
        public static final Config RGB_565;
        private static Config sConfigs[];
        final int nativeInt;

        static  {
            ALPHA_8 = new Config("ALPHA_8", 0, 2);
            RGB_565 = new Config("RGB_565", 1, 4);
            ARGB_4444 = new Config("ARGB_4444", 2, 5);
            ARGB_8888 = new Config("ARGB_8888", 3, 6);
            Config aconfig[] = new Config[4];
            aconfig[0] = ALPHA_8;
            aconfig[1] = RGB_565;
            aconfig[2] = ARGB_4444;
            aconfig[3] = ARGB_8888;
            $VALUES = aconfig;
            Config aconfig1[] = new Config[7];
            aconfig1[0] = null;
            aconfig1[1] = null;
            aconfig1[2] = ALPHA_8;
            aconfig1[3] = null;
            aconfig1[4] = RGB_565;
            aconfig1[5] = ARGB_4444;
            aconfig1[6] = ARGB_8888;
            sConfigs = aconfig1;
        }

        private Config(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }


    Bitmap(int i, byte abyte0[], boolean flag, byte abyte1[], int j) {
        this(i, abyte0, flag, abyte1, null, j);
    }

    Bitmap(int i, byte abyte0[], boolean flag, byte abyte1[], int ai[], int j) {
        mWidth = -1;
        mHeight = -1;
        int k = getDefaultDensity();
        sDefaultDensity = k;
        mDensity = k;
        if(i == 0)
            throw new RuntimeException("internal error: native bitmap is 0");
        mBuffer = abyte0;
        mNativeBitmap = i;
        mFinalizer = new BitmapFinalizer(i);
        mIsMutable = flag;
        mNinePatchChunk = abyte1;
        mLayoutBounds = ai;
        if(j >= 0)
            mDensity = j;
    }

    private void checkPixelAccess(int i, int j) {
        checkXYSign(i, j);
        if(i >= getWidth())
            throw new IllegalArgumentException("x must be < bitmap.width()");
        if(j >= getHeight())
            throw new IllegalArgumentException("y must be < bitmap.height()");
        else
            return;
    }

    private void checkPixelsAccess(int i, int j, int k, int l, int i1, int j1, int ai[]) {
        checkXYSign(i, j);
        if(k < 0)
            throw new IllegalArgumentException("width must be >= 0");
        if(l < 0)
            throw new IllegalArgumentException("height must be >= 0");
        if(i + k > getWidth())
            throw new IllegalArgumentException("x + width must be <= bitmap.width()");
        if(j + l > getHeight())
            throw new IllegalArgumentException("y + height must be <= bitmap.height()");
        if(Math.abs(j1) < k)
            throw new IllegalArgumentException("abs(stride) must be >= width");
        int k1 = i1 + j1 * (l - 1);
        int l1 = ai.length;
        if(i1 < 0 || i1 + k > l1 || k1 < 0 || k1 + k > l1)
            throw new ArrayIndexOutOfBoundsException();
        else
            return;
    }

    private void checkRecycled(String s) {
        if(mRecycled)
            throw new IllegalStateException(s);
        else
            return;
    }

    private static void checkWidthHeight(int i, int j) {
        if(i <= 0)
            throw new IllegalArgumentException("width must be > 0");
        if(j <= 0)
            throw new IllegalArgumentException("height must be > 0");
        else
            return;
    }

    private static void checkXYSign(int i, int j) {
        if(i < 0)
            throw new IllegalArgumentException("x must be >= 0");
        if(j < 0)
            throw new IllegalArgumentException("y must be >= 0");
        else
            return;
    }

    public static Bitmap createBitmap(int i, int j, Config config) {
        return createBitmap(i, j, config, true);
    }

    private static Bitmap createBitmap(int i, int j, Config config, boolean flag) {
        if(i <= 0 || j <= 0)
            throw new IllegalArgumentException("width and height must be > 0");
        Bitmap bitmap = nativeCreate(null, 0, i, i, j, config.nativeInt, true);
        if(config == Config.ARGB_8888 && !flag) {
            nativeErase(bitmap.mNativeBitmap, 0xff000000);
            nativeSetHasAlpha(bitmap.mNativeBitmap, flag);
        }
        return bitmap;
    }

    public static Bitmap createBitmap(Bitmap bitmap) {
        return createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public static Bitmap createBitmap(Bitmap bitmap, int i, int j, int k, int l) {
        return createBitmap(bitmap, i, j, k, l, null, false);
    }

    public static Bitmap createBitmap(Bitmap bitmap, int i, int j, int k, int l, Matrix matrix, boolean flag) {
        checkXYSign(i, j);
        checkWidthHeight(k, l);
        if(i + k > bitmap.getWidth())
            throw new IllegalArgumentException("x + width must be <= bitmap.width()");
        if(j + l > bitmap.getHeight())
            throw new IllegalArgumentException("y + height must be <= bitmap.height()");
        if(bitmap.isMutable() || i != 0 || j != 0 || k != bitmap.getWidth() || l != bitmap.getHeight() || matrix != null && !matrix.isIdentity()) goto _L2; else goto _L1
_L1:
        return bitmap;
_L2:
        Canvas canvas;
        Rect rect;
        RectF rectf;
        Config config;
        Config config1;
        canvas = new Canvas();
        rect = new Rect(i, j, i + k, j + l);
        rectf = new RectF(0.0F, 0.0F, k, l);
        config = Config.ARGB_8888;
        config1 = bitmap.getConfig();
        if(config1 == null) goto _L4; else goto _L3
_L3:
        class _cls2 {

            static final int $SwitchMap$android$graphics$Bitmap$Config[];

            static  {
                $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];
                NoSuchFieldError nosuchfielderror3;
                try {
                    $SwitchMap$android$graphics$Bitmap$Config[Config.RGB_565.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$android$graphics$Bitmap$Config[Config.ALPHA_8.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_4444.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_8888.ordinal()] = 4;
_L2:
                return;
                nosuchfielderror3;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls2..SwitchMap.android.graphics.Bitmap.Config[config1.ordinal()];
        JVM INSTR tableswitch 1 2: default 188
    //                   1 263
    //                   2 271;
           goto _L5 _L6 _L7
_L5:
        config = Config.ARGB_8888;
_L4:
        Bitmap bitmap1;
        Paint paint;
        if(matrix == null || matrix.isIdentity()) {
            bitmap1 = createBitmap(k, l, config, bitmap.hasAlpha());
            paint = null;
        } else {
            boolean flag1;
            RectF rectf1;
            int i1;
            int j1;
            boolean flag2;
            if(!matrix.rectStaysRect())
                flag1 = true;
            else
                flag1 = false;
            rectf1 = new RectF();
            matrix.mapRect(rectf1, rectf);
            i1 = Math.round(rectf1.width());
            j1 = Math.round(rectf1.height());
            if(flag1)
                config = Config.ARGB_8888;
            if(flag1 || bitmap.hasAlpha())
                flag2 = true;
            else
                flag2 = false;
            bitmap1 = createBitmap(i1, j1, config, flag2);
            canvas.translate(-rectf1.left, -rectf1.top);
            canvas.concat(matrix);
            paint = new Paint();
            paint.setFilterBitmap(flag);
            if(flag1)
                paint.setAntiAlias(true);
        }
        bitmap1.mDensity = bitmap.mDensity;
        canvas.setBitmap(bitmap1);
        canvas.drawBitmap(bitmap, rect, rectf, paint);
        canvas.setBitmap(null);
        bitmap = bitmap1;
        if(true) goto _L1; else goto _L6
_L6:
        config = Config.RGB_565;
          goto _L4
_L7:
        config = Config.ALPHA_8;
          goto _L4
    }

    public static Bitmap createBitmap(int ai[], int i, int j, int k, int l, Config config) {
        checkWidthHeight(k, l);
        if(Math.abs(j) < k)
            throw new IllegalArgumentException("abs(stride) must be >= width");
        int i1 = i + j * (l - 1);
        int j1 = ai.length;
        if(i < 0 || i + k > j1 || i1 < 0 || i1 + k > j1)
            throw new ArrayIndexOutOfBoundsException();
        if(k <= 0 || l <= 0)
            throw new IllegalArgumentException("width and height must be > 0");
        else
            return nativeCreate(ai, i, j, k, l, config.nativeInt, false);
    }

    public static Bitmap createBitmap(int ai[], int i, int j, Config config) {
        return createBitmap(ai, 0, i, i, j, config);
    }

    public static Bitmap createScaledBitmap(Bitmap bitmap, int i, int j, boolean flag) {
        android/graphics/Bitmap;
        JVM INSTR monitorenter ;
        Matrix matrix;
        matrix = sScaleMatrix;
        sScaleMatrix = null;
        android/graphics/Bitmap;
        JVM INSTR monitorexit ;
        int k;
        int l;
        if(matrix == null)
            matrix = new Matrix();
        k = bitmap.getWidth();
        l = bitmap.getHeight();
        matrix.setScale((float)i / (float)k, (float)j / (float)l);
        Bitmap bitmap1 = createBitmap(bitmap, 0, 0, k, l, matrix, flag);
        android/graphics/Bitmap;
        JVM INSTR monitorenter ;
        if(sScaleMatrix == null)
            sScaleMatrix = matrix;
        android/graphics/Bitmap;
        JVM INSTR monitorexit ;
        return bitmap1;
        Exception exception;
        exception;
        android/graphics/Bitmap;
        JVM INSTR monitorexit ;
        throw exception;
        Exception exception1;
        exception1;
        android/graphics/Bitmap;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    static int getDefaultDensity() {
        int i;
        if(sDefaultDensity >= 0) {
            i = sDefaultDensity;
        } else {
            sDefaultDensity = DisplayMetrics.DENSITY_DEVICE;
            i = sDefaultDensity;
        }
        return i;
    }

    private static native boolean nativeCompress(int i, int j, int k, OutputStream outputstream, byte abyte0[]);

    private static native int nativeConfig(int i);

    private static native Bitmap nativeCopy(int i, int j, boolean flag);

    private static native void nativeCopyPixelsFromBuffer(int i, Buffer buffer);

    private static native void nativeCopyPixelsToBuffer(int i, Buffer buffer);

    private static native Bitmap nativeCreate(int ai[], int i, int j, int k, int l, int i1, boolean flag);

    private static native Bitmap nativeCreateFromParcel(Parcel parcel);

    private static native void nativeDestructor(int i);

    private static native void nativeErase(int i, int j);

    private static native Bitmap nativeExtractAlpha(int i, int j, int ai[]);

    private static native int nativeGenerationId(int i);

    private static native int nativeGetPixel(int i, int j, int k);

    private static native void nativeGetPixels(int i, int ai[], int j, int k, int l, int i1, int j1, int k1);

    private static native boolean nativeHasAlpha(int i);

    private static native int nativeHeight(int i);

    private static native void nativePrepareToDraw(int i);

    private static native void nativeRecycle(int i);

    private static native int nativeRowBytes(int i);

    private static native boolean nativeSameAs(int i, int j);

    private static native void nativeSetHasAlpha(int i, boolean flag);

    private static native void nativeSetPixel(int i, int j, int k, int l);

    private static native void nativeSetPixels(int i, int ai[], int j, int k, int l, int i1, int j1, int k1);

    private static native int nativeWidth(int i);

    private static native boolean nativeWriteToParcel(int i, boolean flag, int j, Parcel parcel);

    public static int scaleFromDensity(int i, int j, int k) {
        if(j != 0 && j != k)
            i = (i * k + (j >> 1)) / j;
        return i;
    }

    public static void setDefaultDensity(int i) {
        sDefaultDensity = i;
    }

    public boolean compress(CompressFormat compressformat, int i, OutputStream outputstream) {
        checkRecycled("Can't compress a recycled bitmap");
        if(outputstream == null)
            throw new NullPointerException();
        if(i < 0 || i > 100)
            throw new IllegalArgumentException("quality must be 0..100");
        else
            return nativeCompress(mNativeBitmap, compressformat.nativeInt, i, outputstream, new byte[4096]);
    }

    public Bitmap copy(Config config, boolean flag) {
        checkRecycled("Can't copy a recycled bitmap");
        Bitmap bitmap = nativeCopy(mNativeBitmap, config.nativeInt, flag);
        if(bitmap != null)
            bitmap.mDensity = mDensity;
        return bitmap;
    }

    public void copyPixelsFromBuffer(Buffer buffer) {
        checkRecycled("copyPixelsFromBuffer called on recycled bitmap");
        int i = buffer.remaining();
        int j;
        if(buffer instanceof ByteBuffer)
            j = 0;
        else
        if(buffer instanceof ShortBuffer)
            j = 1;
        else
        if(buffer instanceof IntBuffer)
            j = 2;
        else
            throw new RuntimeException("unsupported Buffer subclass");
        if((long)i << j < (long)getByteCount()) {
            throw new RuntimeException("Buffer not large enough for pixels");
        } else {
            nativeCopyPixelsFromBuffer(mNativeBitmap, buffer);
            return;
        }
    }

    public void copyPixelsToBuffer(Buffer buffer) {
        int i = buffer.remaining();
        int j;
        long l;
        long l1;
        if(buffer instanceof ByteBuffer)
            j = 0;
        else
        if(buffer instanceof ShortBuffer)
            j = 1;
        else
        if(buffer instanceof IntBuffer)
            j = 2;
        else
            throw new RuntimeException("unsupported Buffer subclass");
        l = (long)i << j;
        l1 = getByteCount();
        if(l < l1) {
            throw new RuntimeException("Buffer not large enough for pixels");
        } else {
            nativeCopyPixelsToBuffer(mNativeBitmap, buffer);
            buffer.position((int)((long)buffer.position() + (l1 >> j)));
            return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void eraseColor(int i) {
        checkRecycled("Can't erase a recycled bitmap");
        if(!isMutable()) {
            throw new IllegalStateException("cannot erase immutable bitmaps");
        } else {
            nativeErase(mNativeBitmap, i);
            return;
        }
    }

    public Bitmap extractAlpha() {
        return extractAlpha(null, null);
    }

    public Bitmap extractAlpha(Paint paint, int ai[]) {
        checkRecycled("Can't extractAlpha on a recycled bitmap");
        int i;
        Bitmap bitmap;
        if(paint != null)
            i = paint.mNativePaint;
        else
            i = 0;
        bitmap = nativeExtractAlpha(mNativeBitmap, i, ai);
        if(bitmap == null) {
            throw new RuntimeException("Failed to extractAlpha on Bitmap");
        } else {
            bitmap.mDensity = mDensity;
            return bitmap;
        }
    }

    public final int getByteCount() {
        return getRowBytes() * getHeight();
    }

    public final Config getConfig() {
        return Config.nativeToConfig(nativeConfig(mNativeBitmap));
    }

    public int getDensity() {
        return mDensity;
    }

    public int getGenerationId() {
        return nativeGenerationId(mNativeBitmap);
    }

    public final int getHeight() {
        int i;
        if(mHeight == -1) {
            i = nativeHeight(mNativeBitmap);
            mHeight = i;
        } else {
            i = mHeight;
        }
        return i;
    }

    public int[] getLayoutBounds() {
        return mLayoutBounds;
    }

    public byte[] getNinePatchChunk() {
        return mNinePatchChunk;
    }

    public int getPixel(int i, int j) {
        checkRecycled("Can't call getPixel() on a recycled bitmap");
        checkPixelAccess(i, j);
        return nativeGetPixel(mNativeBitmap, i, j);
    }

    public void getPixels(int ai[], int i, int j, int k, int l, int i1, int j1) {
        checkRecycled("Can't call getPixels() on a recycled bitmap");
        if(i1 != 0 && j1 != 0) {
            checkPixelsAccess(k, l, i1, j1, i, j, ai);
            nativeGetPixels(mNativeBitmap, ai, i, j, k, l, i1, j1);
        }
    }

    public final int getRowBytes() {
        return nativeRowBytes(mNativeBitmap);
    }

    public int getScaledHeight(int i) {
        return scaleFromDensity(getHeight(), mDensity, i);
    }

    public int getScaledHeight(Canvas canvas) {
        return scaleFromDensity(getHeight(), mDensity, canvas.mDensity);
    }

    public int getScaledHeight(DisplayMetrics displaymetrics) {
        return scaleFromDensity(getHeight(), mDensity, displaymetrics.densityDpi);
    }

    public int getScaledWidth(int i) {
        return scaleFromDensity(getWidth(), mDensity, i);
    }

    public int getScaledWidth(Canvas canvas) {
        return scaleFromDensity(getWidth(), mDensity, canvas.mDensity);
    }

    public int getScaledWidth(DisplayMetrics displaymetrics) {
        return scaleFromDensity(getWidth(), mDensity, displaymetrics.densityDpi);
    }

    public final int getWidth() {
        int i;
        if(mWidth == -1) {
            i = nativeWidth(mNativeBitmap);
            mWidth = i;
        } else {
            i = mWidth;
        }
        return i;
    }

    public final boolean hasAlpha() {
        return nativeHasAlpha(mNativeBitmap);
    }

    public final boolean isMutable() {
        return mIsMutable;
    }

    public final boolean isRecycled() {
        return mRecycled;
    }

    final int ni() {
        return mNativeBitmap;
    }

    public void prepareToDraw() {
        nativePrepareToDraw(mNativeBitmap);
    }

    public void recycle() {
        if(!mRecycled) {
            mBuffer = null;
            nativeRecycle(mNativeBitmap);
            mNinePatchChunk = null;
            mRecycled = true;
        }
    }

    public boolean sameAs(Bitmap bitmap) {
        boolean flag;
        if(this == bitmap || bitmap != null && nativeSameAs(mNativeBitmap, bitmap.mNativeBitmap))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void setDensity(int i) {
        mDensity = i;
    }

    public void setHasAlpha(boolean flag) {
        nativeSetHasAlpha(mNativeBitmap, flag);
    }

    public void setLayoutBounds(int ai[]) {
        mLayoutBounds = ai;
    }

    public void setNinePatchChunk(byte abyte0[]) {
        mNinePatchChunk = abyte0;
    }

    public void setPixel(int i, int j, int k) {
        checkRecycled("Can't call setPixel() on a recycled bitmap");
        if(!isMutable()) {
            throw new IllegalStateException();
        } else {
            checkPixelAccess(i, j);
            nativeSetPixel(mNativeBitmap, i, j, k);
            return;
        }
    }

    public void setPixels(int ai[], int i, int j, int k, int l, int i1, int j1) {
        checkRecycled("Can't call setPixels() on a recycled bitmap");
        if(!isMutable())
            throw new IllegalStateException();
        if(i1 != 0 && j1 != 0) {
            checkPixelsAccess(k, l, i1, j1, i, j, ai);
            nativeSetPixels(mNativeBitmap, ai, i, j, k, l, i1, j1);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        checkRecycled("Can't parcel a recycled bitmap");
        if(!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, parcel))
            throw new RuntimeException("native writeToParcel failed");
        else
            return;
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Bitmap createFromParcel(Parcel parcel) {
            Bitmap bitmap = Bitmap.nativeCreateFromParcel(parcel);
            if(bitmap == null)
                throw new RuntimeException("Failed to unparcel Bitmap");
            else
                return bitmap;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Bitmap[] newArray(int i) {
            return new Bitmap[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int DENSITY_NONE = 0;
    private static final int WORKING_COMPRESS_STORAGE = 4096;
    private static volatile int sDefaultDensity = -1;
    private static volatile Matrix sScaleMatrix;
    public byte mBuffer[];
    int mDensity;
    private final BitmapFinalizer mFinalizer;
    private int mHeight;
    private final boolean mIsMutable;
    private int mLayoutBounds[];
    public final int mNativeBitmap;
    private byte mNinePatchChunk[];
    private boolean mRecycled;
    private int mWidth;



}
