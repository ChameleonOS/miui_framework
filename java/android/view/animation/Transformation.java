// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.animation;

import android.graphics.Matrix;
import java.io.PrintWriter;

public class Transformation {

    public Transformation() {
        clear();
    }

    public void clear() {
        if(mMatrix == null)
            mMatrix = new Matrix();
        else
            mMatrix.reset();
        mAlpha = 1.0F;
        mTransformationType = TYPE_BOTH;
    }

    public void compose(Transformation transformation) {
        mAlpha = mAlpha * transformation.getAlpha();
        mMatrix.preConcat(transformation.getMatrix());
    }

    public float getAlpha() {
        return mAlpha;
    }

    public Matrix getMatrix() {
        return mMatrix;
    }

    public int getTransformationType() {
        return mTransformationType;
    }

    public void postCompose(Transformation transformation) {
        mAlpha = mAlpha * transformation.getAlpha();
        mMatrix.postConcat(transformation.getMatrix());
    }

    public void printShortString(PrintWriter printwriter) {
        printwriter.print("{alpha=");
        printwriter.print(mAlpha);
        printwriter.print(" matrix=");
        mMatrix.printShortString(printwriter);
        printwriter.print('}');
    }

    public void set(Transformation transformation) {
        mAlpha = transformation.getAlpha();
        mMatrix.set(transformation.getMatrix());
        mTransformationType = transformation.getTransformationType();
    }

    public void setAlpha(float f) {
        mAlpha = f;
    }

    public void setTransformationType(int i) {
        mTransformationType = i;
    }

    public String toShortString() {
        StringBuilder stringbuilder = new StringBuilder(64);
        toShortString(stringbuilder);
        return stringbuilder.toString();
    }

    public void toShortString(StringBuilder stringbuilder) {
        stringbuilder.append("{alpha=");
        stringbuilder.append(mAlpha);
        stringbuilder.append(" matrix=");
        mMatrix.toShortString(stringbuilder);
        stringbuilder.append('}');
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append("Transformation");
        toShortString(stringbuilder);
        return stringbuilder.toString();
    }

    public static int TYPE_ALPHA;
    public static int TYPE_BOTH;
    public static int TYPE_IDENTITY = 0;
    public static int TYPE_MATRIX;
    protected float mAlpha;
    protected Matrix mMatrix;
    protected int mTransformationType;

    static  {
        TYPE_ALPHA = 1;
        TYPE_MATRIX = 2;
        TYPE_BOTH = TYPE_ALPHA | TYPE_MATRIX;
    }
}
