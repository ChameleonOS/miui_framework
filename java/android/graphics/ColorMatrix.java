// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.util.FloatMath;

public class ColorMatrix {

    public ColorMatrix() {
        mArray = new float[20];
        reset();
    }

    public ColorMatrix(ColorMatrix colormatrix) {
        mArray = new float[20];
        System.arraycopy(colormatrix.mArray, 0, mArray, 0, 20);
    }

    public ColorMatrix(float af[]) {
        mArray = new float[20];
        System.arraycopy(af, 0, mArray, 0, 20);
    }

    public final float[] getArray() {
        return mArray;
    }

    public void postConcat(ColorMatrix colormatrix) {
        setConcat(colormatrix, this);
    }

    public void preConcat(ColorMatrix colormatrix) {
        setConcat(this, colormatrix);
    }

    public void reset() {
        float af[] = mArray;
        for(int i = 19; i > 0; i--)
            af[i] = 0.0F;

        af[18] = 1.0F;
        af[12] = 1.0F;
        af[6] = 1.0F;
        af[0] = 1.0F;
    }

    public void set(ColorMatrix colormatrix) {
        System.arraycopy(colormatrix.mArray, 0, mArray, 0, 20);
    }

    public void set(float af[]) {
        System.arraycopy(af, 0, mArray, 0, 20);
    }

    public void setConcat(ColorMatrix colormatrix, ColorMatrix colormatrix1) {
        float af[];
        float af1[];
        float af2[];
        int i;
        if(colormatrix == this || colormatrix1 == this)
            af = new float[20];
        else
            af = mArray;
        af1 = colormatrix.mArray;
        af2 = colormatrix1.mArray;
        i = 0;
        for(int j = 0; j < 20; j += 5) {
            int k = 0;
            int l;
            int i1;
            for(l = i; k < 4; l = i1) {
                i1 = l + 1;
                af[l] = af1[j + 0] * af2[k + 0] + af1[j + 1] * af2[k + 5] + af1[j + 2] * af2[k + 10] + af1[j + 3] * af2[k + 15];
                k++;
            }

            i = l + 1;
            af[l] = af1[j + 0] * af2[4] + af1[j + 1] * af2[9] + af1[j + 2] * af2[14] + af1[j + 3] * af2[19] + af1[j + 4];
        }

        if(af != mArray)
            System.arraycopy(af, 0, mArray, 0, 20);
    }

    public void setRGB2YUV() {
        reset();
        float af[] = mArray;
        af[0] = 0.299F;
        af[1] = 0.587F;
        af[2] = 0.114F;
        af[5] = -0.16874F;
        af[6] = -0.33126F;
        af[7] = 0.5F;
        af[10] = 0.5F;
        af[11] = -0.41869F;
        af[12] = -0.08131F;
    }

    public void setRotate(int i, float f) {
        float f2;
        float f3;
        reset();
        float f1 = (3.141593F * f) / 180F;
        f2 = FloatMath.cos(f1);
        f3 = FloatMath.sin(f1);
        i;
        JVM INSTR tableswitch 0 2: default 52
    //                   0 60
    //                   1 102
    //                   2 144;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new RuntimeException();
_L2:
        float af2[] = mArray;
        mArray[12] = f2;
        af2[6] = f2;
        mArray[7] = f3;
        mArray[11] = -f3;
_L6:
        return;
_L3:
        float af1[] = mArray;
        mArray[12] = f2;
        af1[0] = f2;
        mArray[2] = -f3;
        mArray[10] = f3;
        continue; /* Loop/switch isn't completed */
_L4:
        float af[] = mArray;
        mArray[6] = f2;
        af[0] = f2;
        mArray[1] = f3;
        mArray[5] = -f3;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void setSaturation(float f) {
        reset();
        float af[] = mArray;
        float f1 = 1.0F - f;
        float f2 = 0.213F * f1;
        float f3 = 0.715F * f1;
        float f4 = 0.072F * f1;
        af[0] = f2 + f;
        af[1] = f3;
        af[2] = f4;
        af[5] = f2;
        af[6] = f3 + f;
        af[7] = f4;
        af[10] = f2;
        af[11] = f3;
        af[12] = f4 + f;
    }

    public void setScale(float f, float f1, float f2, float f3) {
        float af[] = mArray;
        for(int i = 19; i > 0; i--)
            af[i] = 0.0F;

        af[0] = f;
        af[6] = f1;
        af[12] = f2;
        af[18] = f3;
    }

    public void setYUV2RGB() {
        reset();
        float af[] = mArray;
        af[2] = 1.402F;
        af[5] = 1.0F;
        af[6] = -0.34414F;
        af[7] = -0.71414F;
        af[10] = 1.0F;
        af[11] = 1.772F;
        af[12] = 0.0F;
    }

    private final float mArray[];
}
