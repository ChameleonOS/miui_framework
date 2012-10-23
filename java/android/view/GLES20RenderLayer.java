// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.*;

// Referenced classes of package android.view:
//            GLES20Layer, GLES20Canvas, GLES20DisplayList, HardwareLayer, 
//            HardwareCanvas, DisplayList

class GLES20RenderLayer extends GLES20Layer {

    GLES20RenderLayer(int i, int j, boolean flag) {
        boolean flag1 = true;
        super(i, j, flag);
        int ai[] = new int[2];
        super.mLayer = GLES20Canvas.nCreateLayer(i, j, flag, ai);
        if(super.mLayer != 0) {
            mLayerWidth = ai[0];
            mLayerHeight = ai[flag1];
            int k = super.mLayer;
            if(flag)
                flag1 = false;
            mCanvas = new GLES20Canvas(k, flag1);
            super.mFinalizer = new GLES20Layer.Finalizer(super.mLayer);
        } else {
            mCanvas = null;
            super.mFinalizer = null;
        }
    }

    void end(Canvas canvas) {
        if(canvas instanceof GLES20Canvas)
            ((GLES20Canvas)canvas).resume();
    }

    HardwareCanvas getCanvas() {
        return mCanvas;
    }

    boolean isValid() {
        boolean flag;
        if(super.mLayer != 0 && mLayerWidth > 0 && mLayerHeight > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    void redraw(DisplayList displaylist, Rect rect) {
        GLES20Canvas.nUpdateRenderLayer(super.mLayer, mCanvas.getRenderer(), ((GLES20DisplayList)displaylist).getNativeDisplayList(), rect.left, rect.top, rect.right, rect.bottom);
    }

    void resize(int i, int j) {
        if(isValid() && i > 0 && j > 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        super.mWidth = i;
        super.mHeight = j;
        if(i != mLayerWidth || j != mLayerHeight) {
            int ai[] = new int[2];
            GLES20Canvas.nResizeLayer(super.mLayer, i, j, ai);
            mLayerWidth = ai[0];
            mLayerHeight = ai[1];
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    void setTransform(Matrix matrix) {
    }

    HardwareCanvas start(Canvas canvas) {
        if(canvas instanceof GLES20Canvas)
            ((GLES20Canvas)canvas).interrupt();
        return getCanvas();
    }

    private final GLES20Canvas mCanvas;
    private int mLayerHeight;
    private int mLayerWidth;
}
