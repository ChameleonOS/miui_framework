// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.Bitmap;

// Referenced classes of package android.view:
//            HardwareLayer, GLES20Canvas

abstract class GLES20Layer extends HardwareLayer {
    static class Finalizer {

        void destroy() {
            GLES20Canvas.nDestroyLayer(mLayerId);
            mLayerId = 0;
        }

        protected void finalize() throws Throwable {
            if(mLayerId != 0)
                GLES20Canvas.nDestroyLayerDeferred(mLayerId);
            super.finalize();
            return;
            Exception exception;
            exception;
            super.finalize();
            throw exception;
        }

        private int mLayerId;

        public Finalizer(int i) {
            mLayerId = i;
        }
    }


    GLES20Layer() {
    }

    GLES20Layer(int i, int j, boolean flag) {
        super(i, j, flag);
    }

    boolean copyInto(Bitmap bitmap) {
        return GLES20Canvas.nCopyLayer(mLayer, bitmap.mNativeBitmap);
    }

    void destroy() {
        if(mFinalizer != null) {
            mFinalizer.destroy();
            mFinalizer = null;
        }
        mLayer = 0;
    }

    void flush() {
        if(mLayer != 0)
            GLES20Canvas.nFlushLayer(mLayer);
    }

    public int getLayer() {
        return mLayer;
    }

    void update(int i, int j, boolean flag) {
        super.update(i, j, flag);
    }

    Finalizer mFinalizer;
    int mLayer;
}
