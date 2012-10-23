// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.*;
import android.os.*;
import android.util.Log;

// Referenced classes of package android.view:
//            SurfaceSession

public class Surface
    implements Parcelable {
    private class CompatibleCanvas extends Canvas {

        public int getHeight() {
            int i = super.getHeight();
            if(mCompatibilityTranslator != null)
                i = (int)(0.5F + (float)i * mCompatibilityTranslator.applicationInvertedScale);
            return i;
        }

        public void getMatrix(Matrix matrix) {
            super.getMatrix(matrix);
            if(mOrigMatrix == null)
                mOrigMatrix = new Matrix();
            mOrigMatrix.set(matrix);
        }

        public int getWidth() {
            int i = super.getWidth();
            if(mCompatibilityTranslator != null)
                i = (int)(0.5F + (float)i * mCompatibilityTranslator.applicationInvertedScale);
            return i;
        }

        public void setMatrix(Matrix matrix) {
            if(mCompatibleMatrix == null || mOrigMatrix == null || mOrigMatrix.equals(matrix)) {
                super.setMatrix(matrix);
            } else {
                Matrix matrix1 = new Matrix(mCompatibleMatrix);
                matrix1.preConcat(matrix);
                super.setMatrix(matrix1);
            }
        }

        private Matrix mOrigMatrix;
        final Surface this$0;

        private CompatibleCanvas() {
            this$0 = Surface.this;
            super();
            mOrigMatrix = null;
        }

    }

    public static class OutOfResourcesException extends Exception {

        public OutOfResourcesException() {
        }

        public OutOfResourcesException(String s) {
            super(s);
        }
    }


    public Surface() {
        checkHeadless();
        mCanvas = new CompatibleCanvas();
    }

    public Surface(SurfaceTexture surfacetexture) {
        checkHeadless();
        mCanvas = new CompatibleCanvas();
        initFromSurfaceTexture(surfacetexture);
    }

    private Surface(Parcel parcel) throws OutOfResourcesException {
        init(parcel);
    }


    public Surface(SurfaceSession surfacesession, int i, int j, int k, int l, int i1, int j1) throws OutOfResourcesException {
        checkHeadless();
        mCanvas = new CompatibleCanvas();
        init(surfacesession, i, null, j, k, l, i1, j1);
    }

    public Surface(SurfaceSession surfacesession, int i, String s, int j, int k, int l, int i1, 
            int j1) throws OutOfResourcesException {
        checkHeadless();
        mCanvas = new CompatibleCanvas();
        init(surfacesession, i, s, j, k, l, i1, j1);
        mName = s;
    }

    private static void checkHeadless() {
        if(headless)
            throw new UnsupportedOperationException("Device is headless");
        else
            return;
    }

    public static native void closeTransaction();

    public static native void freezeDisplay(int i);

    private native int getIdentity();

    private native void init(Parcel parcel);

    private native void init(SurfaceSession surfacesession, int i, String s, int j, int k, int l, int i1, 
            int j1) throws OutOfResourcesException;

    private native void initFromSurfaceTexture(SurfaceTexture surfacetexture);

    private native Canvas lockCanvasNative(Rect rect);

    private static native void nativeClassInit();

    public static native void openTransaction();

    public static native Bitmap screenshot(int i, int j);

    public static native Bitmap screenshot(int i, int j, int k, int l);

    public static void setOrientation(int i, int j) {
        setOrientation(i, j, 0);
    }

    public static native void setOrientation(int i, int j, int k);

    public static native void unfreezeDisplay(int i);

    public native void copyFrom(Surface surface);

    public int describeContents() {
        return 0;
    }

    public native void destroy();

    protected void finalize() throws Throwable {
        super.finalize();
        if(mNativeSurface != 0 || mSurfaceControl != 0)
            Log.w("Surface", (new StringBuilder()).append("Surface.finalize() has work. You should have called release() (").append(mNativeSurface).append(", ").append(mSurfaceControl).append(")").toString());
        release();
        return;
        Exception exception;
        exception;
        if(mNativeSurface != 0 || mSurfaceControl != 0)
            Log.w("Surface", (new StringBuilder()).append("Surface.finalize() has work. You should have called release() (").append(mNativeSurface).append(", ").append(mSurfaceControl).append(")").toString());
        release();
        throw exception;
    }

    public native void freeze();

    public int getGenerationId() {
        return mSurfaceGenerationId;
    }

    public native void hide();

    public native boolean isConsumerRunningBehind();

    public native boolean isValid();

    public Canvas lockCanvas(Rect rect) throws OutOfResourcesException, IllegalArgumentException {
        return lockCanvasNative(rect);
    }

    public native void readFromParcel(Parcel parcel);

    public native void release();

    public native void setAlpha(float f);

    void setCompatibilityTranslator(android.content.res.CompatibilityInfo.Translator translator) {
        if(translator != null) {
            float f = translator.applicationScale;
            mCompatibleMatrix = new Matrix();
            mCompatibleMatrix.setScale(f, f);
        }
    }

    public native void setFlags(int i, int j);

    public native void setFreezeTint(int i);

    public native void setLayer(int i);

    public native void setMatrix(float f, float f1, float f2, float f3);

    public native void setPosition(float f, float f1);

    public void setPosition(int i, int j) {
        setPosition(i, j);
    }

    public native void setSize(int i, int j);

    public native void setTransparentRegionHint(Region region);

    public native void setWindowCrop(Rect rect);

    public native void show();

    public String toString() {
        return (new StringBuilder()).append("Surface(name=").append(mName).append(", identity=").append(getIdentity()).append(")").toString();
    }

    public native void transferFrom(Surface surface);

    public native void unfreeze();

    public native void unlockCanvas(Canvas canvas);

    public native void unlockCanvasAndPost(Canvas canvas);

    public native void writeToParcel(Parcel parcel, int i);

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Surface createFromParcel(Parcel parcel) {
            Surface surface;
            try {
                surface = new Surface(parcel);
            }
            catch(Exception exception) {
                Log.e("Surface", "Exception creating surface from parcel", exception);
                surface = null;
            }
            return surface;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Surface[] newArray(int i) {
            return new Surface[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final boolean DEBUG_RELEASE = false;
    public static final int FX_SURFACE_BLUR = 0x10000;
    public static final int FX_SURFACE_DIM = 0x20000;
    public static final int FX_SURFACE_MASK = 0xf0000;
    public static final int FX_SURFACE_NORMAL = 0;
    public static final int FX_SURFACE_SCREENSHOT = 0x30000;
    public static final int HIDDEN = 4;
    private static final String LOG_TAG = "Surface";
    public static final int NON_PREMULTIPLIED = 256;
    public static final int OPAQUE = 1024;
    public static final int PROTECTED_APP = 2048;
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    public static final int SECURE = 128;
    public static final int SURFACE_DITHER = 4;
    public static final int SURFACE_FROZEN = 2;
    public static final int SURFACE_HIDDEN = 1;
    private static final boolean headless = "1".equals(SystemProperties.get("ro.config.headless", "0"));
    private Canvas mCanvas;
    private android.content.res.CompatibilityInfo.Translator mCompatibilityTranslator;
    private Matrix mCompatibleMatrix;
    private Exception mCreationStack;
    private String mName;
    private int mNativeSurface;
    private int mSaveCount;
    private int mSurfaceControl;
    private int mSurfaceGenerationId;

    static  {
        nativeClassInit();
    }


}
