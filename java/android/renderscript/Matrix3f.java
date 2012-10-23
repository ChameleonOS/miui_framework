// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;


public class Matrix3f {

    public Matrix3f() {
        mMat = new float[9];
        loadIdentity();
    }

    public Matrix3f(float af[]) {
        mMat = new float[9];
        System.arraycopy(af, 0, mMat, 0, mMat.length);
    }

    public float get(int i, int j) {
        return mMat[j + i * 3];
    }

    public float[] getArray() {
        return mMat;
    }

    public void load(Matrix3f matrix3f) {
        System.arraycopy(matrix3f.getArray(), 0, mMat, 0, mMat.length);
    }

    public void loadIdentity() {
        mMat[0] = 1.0F;
        mMat[1] = 0.0F;
        mMat[2] = 0.0F;
        mMat[3] = 0.0F;
        mMat[4] = 1.0F;
        mMat[5] = 0.0F;
        mMat[6] = 0.0F;
        mMat[7] = 0.0F;
        mMat[8] = 1.0F;
    }

    public void loadMultiply(Matrix3f matrix3f, Matrix3f matrix3f1) {
        for(int i = 0; i < 3; i++) {
            float f = 0.0F;
            float f1 = 0.0F;
            float f2 = 0.0F;
            for(int j = 0; j < 3; j++) {
                float f3 = matrix3f1.get(i, j);
                f += f3 * matrix3f.get(j, 0);
                f1 += f3 * matrix3f.get(j, 1);
                f2 += f3 * matrix3f.get(j, 2);
            }

            set(i, 0, f);
            set(i, 1, f1);
            set(i, 2, f2);
        }

    }

    public void loadRotate(float f) {
        loadIdentity();
        float f1 = f * 0.01745329F;
        float f2 = (float)Math.cos(f1);
        float f3 = (float)Math.sin(f1);
        mMat[0] = f2;
        mMat[1] = -f3;
        mMat[3] = f3;
        mMat[4] = f2;
    }

    public void loadRotate(float f, float f1, float f2, float f3) {
        float f4 = f * 0.01745329F;
        float f5 = (float)Math.cos(f4);
        float f6 = (float)Math.sin(f4);
        float f7 = (float)Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
        if(f7 == 1.0F) {
            float f15 = 1.0F / f7;
            f1 *= f15;
            f2 *= f15;
            f3 *= f15;
        }
        float f8 = 1.0F - f5;
        float f9 = f1 * f2;
        float f10 = f2 * f3;
        float f11 = f3 * f1;
        float f12 = f1 * f6;
        float f13 = f2 * f6;
        float f14 = f3 * f6;
        mMat[0] = f5 + f8 * (f1 * f1);
        mMat[3] = f9 * f8 - f14;
        mMat[6] = f13 + f11 * f8;
        mMat[1] = f14 + f9 * f8;
        mMat[4] = f5 + f8 * (f2 * f2);
        mMat[9] = f10 * f8 - f12;
        mMat[2] = f11 * f8 - f13;
        mMat[6] = f12 + f10 * f8;
        mMat[8] = f5 + f8 * (f3 * f3);
    }

    public void loadScale(float f, float f1) {
        loadIdentity();
        mMat[0] = f;
        mMat[4] = f1;
    }

    public void loadScale(float f, float f1, float f2) {
        loadIdentity();
        mMat[0] = f;
        mMat[4] = f1;
        mMat[8] = f2;
    }

    public void loadTranslate(float f, float f1) {
        loadIdentity();
        mMat[6] = f;
        mMat[7] = f1;
    }

    public void multiply(Matrix3f matrix3f) {
        Matrix3f matrix3f1 = new Matrix3f();
        matrix3f1.loadMultiply(this, matrix3f);
        load(matrix3f1);
    }

    public void rotate(float f) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadRotate(f);
        multiply(matrix3f);
    }

    public void rotate(float f, float f1, float f2, float f3) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadRotate(f, f1, f2, f3);
        multiply(matrix3f);
    }

    public void scale(float f, float f1) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadScale(f, f1);
        multiply(matrix3f);
    }

    public void scale(float f, float f1, float f2) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadScale(f, f1, f2);
        multiply(matrix3f);
    }

    public void set(int i, int j, float f) {
        mMat[j + i * 3] = f;
    }

    public void translate(float f, float f1) {
        Matrix3f matrix3f = new Matrix3f();
        matrix3f.loadTranslate(f, f1);
        multiply(matrix3f);
    }

    public void transpose() {
        for(int i = 0; i < 2; i++) {
            for(int j = i + 1; j < 3; j++) {
                float f = mMat[j + i * 3];
                mMat[j + i * 3] = mMat[i + j * 3];
                mMat[i + j * 3] = f;
            }

        }

    }

    final float mMat[];
}
