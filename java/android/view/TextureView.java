// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.graphics.*;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;

// Referenced classes of package android.view:
//            View, HardwareLayer, HardwareRenderer

public class TextureView extends View {
    public static interface SurfaceTextureListener {

        public abstract void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i, int j);

        public abstract boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture);

        public abstract void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i, int j);

        public abstract void onSurfaceTextureUpdated(SurfaceTexture surfacetexture);
    }


    public TextureView(Context context) {
        super(context);
        mOpaque = true;
        mMatrix = new Matrix();
        mLock = new Object[0];
        mNativeWindowLock = new Object[0];
        init();
    }

    public TextureView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mOpaque = true;
        mMatrix = new Matrix();
        mLock = new Object[0];
        mNativeWindowLock = new Object[0];
        init();
    }

    public TextureView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mOpaque = true;
        mMatrix = new Matrix();
        mLock = new Object[0];
        mNativeWindowLock = new Object[0];
        init();
    }

    private void applyTransformMatrix() {
        if(mMatrixChanged && mLayer != null) {
            mLayer.setTransform(mMatrix);
            mMatrixChanged = false;
        }
    }

    private void applyUpdate() {
        if(mLayer != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
label0:
        {
            synchronized(mLock) {
                if(!mUpdateLayer)
                    break label0;
                mUpdateLayer = false;
            }
            mLayer.update(getWidth(), getHeight(), mOpaque);
            if(mListener != null)
                mListener.onSurfaceTextureUpdated(mSurface);
            continue; /* Loop/switch isn't completed */
        }
        if(true) goto _L1; else goto _L3
_L3:
        exception;
        throw exception;
    }

    private void destroySurface() {
        if(mLayer != null) {
            mSurface.detachFromGLContext();
            boolean flag = true;
            if(mListener != null)
                flag = mListener.onSurfaceTextureDestroyed(mSurface);
            synchronized(mNativeWindowLock) {
                nDestroyNativeWindow();
            }
            mLayer.destroy();
            if(flag)
                mSurface.release();
            mSurface = null;
            mLayer = null;
        }
        return;
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void init() {
        super.mLayerPaint = new Paint();
    }

    private native void nCreateNativeWindow(SurfaceTexture surfacetexture);

    private native void nDestroyNativeWindow();

    private static native void nLockCanvas(int i, Canvas canvas, Rect rect);

    private static native void nSetDefaultBufferSize(SurfaceTexture surfacetexture, int i, int j);

    private static native void nUnlockCanvasAndPost(int i, Canvas canvas);

    private void updateLayer() {
        mUpdateLayer = true;
        invalidate();
    }

    public void buildLayer() {
    }

    protected void destroyHardwareResources() {
        super.destroyHardwareResources();
        destroySurface();
        invalidateParentCaches();
        invalidate(true);
    }

    boolean destroyLayer(boolean flag) {
        return false;
    }

    public final void draw(Canvas canvas) {
        applyUpdate();
        applyTransformMatrix();
    }

    public Bitmap getBitmap() {
        return getBitmap(getWidth(), getHeight());
    }

    public Bitmap getBitmap(int i, int j) {
        Bitmap bitmap;
        if(isAvailable() && i > 0 && j > 0)
            bitmap = getBitmap(Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888));
        else
            bitmap = null;
        return bitmap;
    }

    public Bitmap getBitmap(Bitmap bitmap) {
        if(bitmap != null && isAvailable()) {
            View.AttachInfo attachinfo = super.mAttachInfo;
            if(attachinfo != null && attachinfo.mHardwareRenderer != null && attachinfo.mHardwareRenderer.isEnabled() && !attachinfo.mHardwareRenderer.validate())
                throw new IllegalStateException("Could not acquire hardware rendering context");
            applyUpdate();
            applyTransformMatrix();
            if(mLayer == null && mUpdateSurface)
                getHardwareLayer();
            if(mLayer != null)
                mLayer.copyInto(bitmap);
        }
        return bitmap;
    }

    HardwareLayer getHardwareLayer() {
        if(mLayer != null) goto _L2; else goto _L1
_L1:
        if(super.mAttachInfo != null && super.mAttachInfo.mHardwareRenderer != null) goto _L4; else goto _L3
_L3:
        HardwareLayer hardwarelayer = null;
_L6:
        return hardwarelayer;
_L4:
        mLayer = super.mAttachInfo.mHardwareRenderer.createHardwareLayer(mOpaque);
        if(!mUpdateSurface)
            mSurface = super.mAttachInfo.mHardwareRenderer.createSurfaceTexture(mLayer);
        nSetDefaultBufferSize(mSurface, getWidth(), getHeight());
        nCreateNativeWindow(mSurface);
        mUpdateListener = new android.graphics.SurfaceTexture.OnFrameAvailableListener() {

            public void onFrameAvailable(SurfaceTexture surfacetexture) {
                synchronized(mLock) {
                    mUpdateLayer = true;
                }
                if(Looper.myLooper() == Looper.getMainLooper())
                    invalidate();
                else
                    postInvalidate();
                return;
                exception1;
                aobj1;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            final TextureView this$0;

             {
                this$0 = TextureView.this;
                super();
            }
        };
        mSurface.setOnFrameAvailableListener(mUpdateListener);
        if(mListener != null && !mUpdateSurface)
            mListener.onSurfaceTextureAvailable(mSurface, getWidth(), getHeight());
_L2:
        if(mUpdateSurface) {
            mUpdateSurface = false;
            synchronized(mLock) {
                mUpdateLayer = true;
            }
            mMatrixChanged = true;
            super.mAttachInfo.mHardwareRenderer.setSurfaceTexture(mLayer, mSurface);
            nSetDefaultBufferSize(mSurface, getWidth(), getHeight());
        }
        applyUpdate();
        applyTransformMatrix();
        hardwarelayer = mLayer;
        if(true) goto _L6; else goto _L5
_L5:
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getLayerType() {
        return 2;
    }

    public SurfaceTexture getSurfaceTexture() {
        return mSurface;
    }

    public SurfaceTextureListener getSurfaceTextureListener() {
        return mListener;
    }

    public Matrix getTransform(Matrix matrix) {
        if(matrix == null)
            matrix = new Matrix();
        matrix.set(mMatrix);
        return matrix;
    }

    boolean hasStaticLayer() {
        return true;
    }

    public boolean isAvailable() {
        boolean flag;
        if(mSurface != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isOpaque() {
        return mOpaque;
    }

    public Canvas lockCanvas() {
        return lockCanvas(null);
    }

    public Canvas lockCanvas(Rect rect) {
        Canvas canvas;
        if(!isAvailable()) {
            canvas = null;
        } else {
            if(mCanvas == null)
                mCanvas = new Canvas();
            synchronized(mNativeWindowLock) {
                nLockCanvas(mNativeWindow, mCanvas, rect);
            }
            mSaveCount = mCanvas.save();
            canvas = mCanvas;
        }
        return canvas;
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(!isHardwareAccelerated())
            Log.w("TextureView", "A TextureView or a subclass can only be used with hardware acceleration enabled.");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mLayer != null && super.mAttachInfo != null && super.mAttachInfo.mHardwareRenderer != null && !super.mAttachInfo.mHardwareRenderer.safelyRun(new Runnable() {

        public void run() {
            destroySurface();
        }

        final TextureView this$0;

             {
                this$0 = TextureView.this;
                super();
            }
    }))
            Log.w("TextureView", (new StringBuilder()).append("TextureView was not able to destroy its surface: ").append(this).toString());
    }

    protected final void onDraw(Canvas canvas) {
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        super.onSizeChanged(i, j, k, l);
        if(mSurface != null) {
            nSetDefaultBufferSize(mSurface, getWidth(), getHeight());
            if(mListener != null)
                mListener.onSurfaceTextureSizeChanged(mSurface, getWidth(), getHeight());
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if(mSurface != null)
            if(i == 0) {
                mSurface.setOnFrameAvailableListener(mUpdateListener);
                updateLayer();
            } else {
                mSurface.setOnFrameAvailableListener(null);
            }
    }

    public void setLayerType(int i, Paint paint) {
        if(paint != super.mLayerPaint) {
            super.mLayerPaint = paint;
            invalidate();
        }
    }

    public void setOpaque(boolean flag) {
        if(flag != mOpaque) {
            mOpaque = flag;
            if(mLayer != null)
                updateLayer();
        }
    }

    public void setSurfaceTexture(SurfaceTexture surfacetexture) {
        if(surfacetexture == null)
            throw new NullPointerException("surfaceTexture must not be null");
        if(mSurface != null)
            mSurface.release();
        mSurface = surfacetexture;
        mUpdateSurface = true;
        invalidateParentIfNeeded();
    }

    public void setSurfaceTextureListener(SurfaceTextureListener surfacetexturelistener) {
        mListener = surfacetexturelistener;
    }

    public void setTransform(Matrix matrix) {
        mMatrix.set(matrix);
        mMatrixChanged = true;
        invalidateParentIfNeeded();
    }

    public void unlockCanvasAndPost(Canvas canvas) {
        if(mCanvas == null || canvas != mCanvas)
            break MISSING_BLOCK_LABEL_56;
        canvas.restoreToCount(mSaveCount);
        mSaveCount = 0;
        Object aobj[] = mNativeWindowLock;
        aobj;
        JVM INSTR monitorenter ;
        nUnlockCanvasAndPost(mNativeWindow, mCanvas);
    }

    private static final String LOG_TAG = "TextureView";
    private Canvas mCanvas;
    private HardwareLayer mLayer;
    private SurfaceTextureListener mListener;
    private final Object mLock[];
    private final Matrix mMatrix;
    private boolean mMatrixChanged;
    private int mNativeWindow;
    private final Object mNativeWindowLock[];
    private boolean mOpaque;
    private int mSaveCount;
    private SurfaceTexture mSurface;
    private boolean mUpdateLayer;
    private android.graphics.SurfaceTexture.OnFrameAvailableListener mUpdateListener;
    private boolean mUpdateSurface;




/*
    static boolean access$202(TextureView textureview, boolean flag) {
        textureview.mUpdateLayer = flag;
        return flag;
    }

*/
}
