// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.Matrix;
import java.util.ArrayList;

// Referenced classes of package android.view:
//            DisplayList, GLES20RecordingCanvas, GLES20Canvas, HardwareCanvas

class GLES20DisplayList extends DisplayList {
    private static class DisplayListFinalizer {

        protected void finalize() throws Throwable {
            GLES20Canvas.destroyDisplayList(mNativeDisplayList);
            super.finalize();
            return;
            Exception exception;
            exception;
            super.finalize();
            throw exception;
        }

        final int mNativeDisplayList;

        public DisplayListFinalizer(int i) {
            mNativeDisplayList = i;
        }
    }


    GLES20DisplayList(String s) {
        mName = s;
    }

    private static native void nOffsetLeftRight(int i, int j);

    private static native void nOffsetTopBottom(int i, int j);

    private static native void nSetAlpha(int i, float f);

    private static native void nSetAnimationMatrix(int i, int j);

    private static native void nSetBottom(int i, int j);

    private static native void nSetCaching(int i, boolean flag);

    private static native void nSetCameraDistance(int i, float f);

    private static native void nSetClipChildren(int i, boolean flag);

    private static native void nSetHasOverlappingRendering(int i, boolean flag);

    private static native void nSetLeft(int i, int j);

    private static native void nSetLeftTop(int i, int j, int k);

    private static native void nSetLeftTopRightBottom(int i, int j, int k, int l, int i1);

    private static native void nSetPivotX(int i, float f);

    private static native void nSetPivotY(int i, float f);

    private static native void nSetRight(int i, int j);

    private static native void nSetRotation(int i, float f);

    private static native void nSetRotationX(int i, float f);

    private static native void nSetRotationY(int i, float f);

    private static native void nSetScaleX(int i, float f);

    private static native void nSetScaleY(int i, float f);

    private static native void nSetStaticMatrix(int i, int j);

    private static native void nSetTop(int i, int j);

    private static native void nSetTransformationInfo(int i, float f, float f1, float f2, float f3, float f4, float f5, float f6, 
            float f7);

    private static native void nSetTranslationX(int i, float f);

    private static native void nSetTranslationY(int i, float f);

    public void clear() {
        if(!mValid)
            mBitmaps.clear();
    }

    public void end() {
        if(mCanvas != null) {
            if(mFinalizer != null) {
                mCanvas.end(mFinalizer.mNativeDisplayList);
            } else {
                mFinalizer = new DisplayListFinalizer(mCanvas.end(0));
                GLES20Canvas.setDisplayListName(mFinalizer.mNativeDisplayList, mName);
            }
            mCanvas.recycle();
            mCanvas = null;
            mValid = true;
        }
    }

    int getNativeDisplayList() {
        if(!mValid || mFinalizer == null)
            throw new IllegalStateException("The display list is not valid.");
        else
            return mFinalizer.mNativeDisplayList;
    }

    public int getSize() {
        int i;
        if(mFinalizer == null)
            i = 0;
        else
            i = GLES20Canvas.getDisplayListSize(mFinalizer.mNativeDisplayList);
        return i;
    }

    boolean hasNativeDisplayList() {
        boolean flag;
        if(mValid && mFinalizer != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void invalidate() {
        if(mCanvas != null) {
            mCanvas.recycle();
            mCanvas = null;
        }
        mValid = false;
    }

    public boolean isValid() {
        return mValid;
    }

    public void offsetLeftRight(int i) {
        if(hasNativeDisplayList())
            nOffsetLeftRight(mFinalizer.mNativeDisplayList, i);
    }

    public void offsetTopBottom(int i) {
        if(hasNativeDisplayList())
            nOffsetTopBottom(mFinalizer.mNativeDisplayList, i);
    }

    public void setAlpha(float f) {
        if(hasNativeDisplayList())
            nSetAlpha(mFinalizer.mNativeDisplayList, f);
    }

    public void setAnimationMatrix(Matrix matrix) {
        if(hasNativeDisplayList()) {
            int i = mFinalizer.mNativeDisplayList;
            int j;
            if(matrix != null)
                j = matrix.native_instance;
            else
                j = 0;
            nSetAnimationMatrix(i, j);
        }
    }

    public void setBottom(int i) {
        if(hasNativeDisplayList())
            nSetBottom(mFinalizer.mNativeDisplayList, i);
    }

    public void setCaching(boolean flag) {
        if(hasNativeDisplayList())
            nSetCaching(mFinalizer.mNativeDisplayList, flag);
    }

    public void setCameraDistance(float f) {
        if(hasNativeDisplayList())
            nSetCameraDistance(mFinalizer.mNativeDisplayList, f);
    }

    public void setClipChildren(boolean flag) {
        if(hasNativeDisplayList())
            nSetClipChildren(mFinalizer.mNativeDisplayList, flag);
    }

    public void setHasOverlappingRendering(boolean flag) {
        if(hasNativeDisplayList())
            nSetHasOverlappingRendering(mFinalizer.mNativeDisplayList, flag);
    }

    public void setLeft(int i) {
        if(hasNativeDisplayList())
            nSetLeft(mFinalizer.mNativeDisplayList, i);
    }

    public void setLeftTop(int i, int j) {
        if(hasNativeDisplayList())
            nSetLeftTop(mFinalizer.mNativeDisplayList, i, j);
    }

    public void setLeftTopRightBottom(int i, int j, int k, int l) {
        if(hasNativeDisplayList())
            nSetLeftTopRightBottom(mFinalizer.mNativeDisplayList, i, j, k, l);
    }

    public void setPivotX(float f) {
        if(hasNativeDisplayList())
            nSetPivotX(mFinalizer.mNativeDisplayList, f);
    }

    public void setPivotY(float f) {
        if(hasNativeDisplayList())
            nSetPivotY(mFinalizer.mNativeDisplayList, f);
    }

    public void setRight(int i) {
        if(hasNativeDisplayList())
            nSetRight(mFinalizer.mNativeDisplayList, i);
    }

    public void setRotation(float f) {
        if(hasNativeDisplayList())
            nSetRotation(mFinalizer.mNativeDisplayList, f);
    }

    public void setRotationX(float f) {
        if(hasNativeDisplayList())
            nSetRotationX(mFinalizer.mNativeDisplayList, f);
    }

    public void setRotationY(float f) {
        if(hasNativeDisplayList())
            nSetRotationY(mFinalizer.mNativeDisplayList, f);
    }

    public void setScaleX(float f) {
        if(hasNativeDisplayList())
            nSetScaleX(mFinalizer.mNativeDisplayList, f);
    }

    public void setScaleY(float f) {
        if(hasNativeDisplayList())
            nSetScaleY(mFinalizer.mNativeDisplayList, f);
    }

    public void setStaticMatrix(Matrix matrix) {
        if(hasNativeDisplayList())
            nSetStaticMatrix(mFinalizer.mNativeDisplayList, matrix.native_instance);
    }

    public void setTop(int i) {
        if(hasNativeDisplayList())
            nSetTop(mFinalizer.mNativeDisplayList, i);
    }

    public void setTransformationInfo(float f, float f1, float f2, float f3, float f4, float f5, float f6, 
            float f7) {
        if(hasNativeDisplayList())
            nSetTransformationInfo(mFinalizer.mNativeDisplayList, f, f1, f2, f3, f4, f5, f6, f7);
    }

    public void setTranslationX(float f) {
        if(hasNativeDisplayList())
            nSetTranslationX(mFinalizer.mNativeDisplayList, f);
    }

    public void setTranslationY(float f) {
        if(hasNativeDisplayList())
            nSetTranslationY(mFinalizer.mNativeDisplayList, f);
    }

    public HardwareCanvas start() {
        if(mCanvas != null) {
            throw new IllegalStateException("Recording has already started");
        } else {
            mValid = false;
            mCanvas = GLES20RecordingCanvas.obtain(this);
            mCanvas.start();
            return mCanvas;
        }
    }

    final ArrayList mBitmaps = new ArrayList(5);
    private GLES20RecordingCanvas mCanvas;
    private DisplayListFinalizer mFinalizer;
    private final String mName;
    private boolean mValid;
}
