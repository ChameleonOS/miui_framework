// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.Matrix;

// Referenced classes of package android.view:
//            HardwareCanvas

public abstract class DisplayList {

    public DisplayList() {
    }

    public abstract void clear();

    public abstract void end();

    public abstract int getSize();

    public abstract void invalidate();

    public abstract boolean isValid();

    public abstract void offsetLeftRight(int i);

    public abstract void offsetTopBottom(int i);

    public abstract void setAlpha(float f);

    public abstract void setAnimationMatrix(Matrix matrix);

    public abstract void setBottom(int i);

    public abstract void setCaching(boolean flag);

    public abstract void setCameraDistance(float f);

    public abstract void setClipChildren(boolean flag);

    public abstract void setHasOverlappingRendering(boolean flag);

    public abstract void setLeft(int i);

    public abstract void setLeftTop(int i, int j);

    public abstract void setLeftTopRightBottom(int i, int j, int k, int l);

    public abstract void setPivotX(float f);

    public abstract void setPivotY(float f);

    public abstract void setRight(int i);

    public abstract void setRotation(float f);

    public abstract void setRotationX(float f);

    public abstract void setRotationY(float f);

    public abstract void setScaleX(float f);

    public abstract void setScaleY(float f);

    public abstract void setStaticMatrix(Matrix matrix);

    public abstract void setTop(int i);

    public abstract void setTransformationInfo(float f, float f1, float f2, float f3, float f4, float f5, float f6, 
            float f7);

    public abstract void setTranslationX(float f);

    public abstract void setTranslationY(float f);

    public abstract HardwareCanvas start();

    public static final int FLAG_CLIP_CHILDREN = 1;
    public static final int STATUS_DONE = 0;
    public static final int STATUS_DRAW = 1;
    public static final int STATUS_DREW = 4;
    public static final int STATUS_INVOKE = 2;
}
