// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;


public class Matrix4f {

    public Matrix4f() {
        mMat = new float[16];
        loadIdentity();
    }

    public Matrix4f(float af[]) {
        mMat = new float[16];
        System.arraycopy(af, 0, mMat, 0, mMat.length);
    }

    private float computeCofactor(int i, int j) {
        int k = (i + 1) % 4;
        int l = (i + 2) % 4;
        int i1 = (i + 3) % 4;
        int j1 = (j + 1) % 4;
        int k1 = (j + 2) % 4;
        int l1 = (j + 3) % 4;
        float f = (mMat[k + j1 * 4] * (mMat[l + k1 * 4] * mMat[i1 + l1 * 4] - mMat[l + l1 * 4] * mMat[i1 + k1 * 4]) - mMat[k + k1 * 4] * (mMat[l + j1 * 4] * mMat[i1 + l1 * 4] - mMat[l + l1 * 4] * mMat[i1 + j1 * 4])) + mMat[k + l1 * 4] * (mMat[l + j1 * 4] * mMat[i1 + k1 * 4] - mMat[l + k1 * 4] * mMat[i1 + j1 * 4]);
        float f1;
        if((1 & i + j) != 0)
            f1 = -f;
        else
            f1 = f;
        return f1;
    }

    public float get(int i, int j) {
        return mMat[j + i * 4];
    }

    public float[] getArray() {
        return mMat;
    }

    public boolean inverse() {
        boolean flag = false;
        Matrix4f matrix4f = new Matrix4f();
        for(int i = 0; i < 4; i++) {
            for(int k = 0; k < 4; k++)
                matrix4f.mMat[k + i * 4] = computeCofactor(i, k);

        }

        float f = mMat[0] * matrix4f.mMat[0] + mMat[4] * matrix4f.mMat[1] + mMat[8] * matrix4f.mMat[2] + mMat[12] * matrix4f.mMat[3];
        if((double)Math.abs(f) >= 9.9999999999999995E-07D) {
            float f1 = 1.0F / f;
            for(int j = 0; j < 16; j++)
                mMat[j] = f1 * matrix4f.mMat[j];

            flag = true;
        }
        return flag;
    }

    public boolean inverseTranspose() {
        boolean flag = false;
        Matrix4f matrix4f = new Matrix4f();
        for(int i = 0; i < 4; i++) {
            for(int k = 0; k < 4; k++)
                matrix4f.mMat[i + k * 4] = computeCofactor(i, k);

        }

        float f = mMat[0] * matrix4f.mMat[0] + mMat[4] * matrix4f.mMat[4] + mMat[8] * matrix4f.mMat[8] + mMat[12] * matrix4f.mMat[12];
        if((double)Math.abs(f) >= 9.9999999999999995E-07D) {
            float f1 = 1.0F / f;
            for(int j = 0; j < 16; j++)
                mMat[j] = f1 * matrix4f.mMat[j];

            flag = true;
        }
        return flag;
    }

    public void load(Matrix4f matrix4f) {
        System.arraycopy(matrix4f.getArray(), 0, mMat, 0, mMat.length);
    }

    public void loadFrustum(float f, float f1, float f2, float f3, float f4, float f5) {
        loadIdentity();
        mMat[0] = (2.0F * f4) / (f1 - f);
        mMat[5] = (2.0F * f4) / (f3 - f2);
        mMat[8] = (f1 + f) / (f1 - f);
        mMat[9] = (f3 + f2) / (f3 - f2);
        mMat[10] = -(f5 + f4) / (f5 - f4);
        mMat[11] = -1F;
        mMat[14] = (f4 * (-2F * f5)) / (f5 - f4);
        mMat[15] = 0.0F;
    }

    public void loadIdentity() {
        mMat[0] = 1.0F;
        mMat[1] = 0.0F;
        mMat[2] = 0.0F;
        mMat[3] = 0.0F;
        mMat[4] = 0.0F;
        mMat[5] = 1.0F;
        mMat[6] = 0.0F;
        mMat[7] = 0.0F;
        mMat[8] = 0.0F;
        mMat[9] = 0.0F;
        mMat[10] = 1.0F;
        mMat[11] = 0.0F;
        mMat[12] = 0.0F;
        mMat[13] = 0.0F;
        mMat[14] = 0.0F;
        mMat[15] = 1.0F;
    }

    public void loadMultiply(Matrix4f matrix4f, Matrix4f matrix4f1) {
        for(int i = 0; i < 4; i++) {
            float f = 0.0F;
            float f1 = 0.0F;
            float f2 = 0.0F;
            float f3 = 0.0F;
            for(int j = 0; j < 4; j++) {
                float f4 = matrix4f1.get(i, j);
                f += f4 * matrix4f.get(j, 0);
                f1 += f4 * matrix4f.get(j, 1);
                f2 += f4 * matrix4f.get(j, 2);
                f3 += f4 * matrix4f.get(j, 3);
            }

            set(i, 0, f);
            set(i, 1, f1);
            set(i, 2, f2);
            set(i, 3, f3);
        }

    }

    public void loadOrtho(float f, float f1, float f2, float f3, float f4, float f5) {
        loadIdentity();
        mMat[0] = 2.0F / (f1 - f);
        mMat[5] = 2.0F / (f3 - f2);
        mMat[10] = -2F / (f5 - f4);
        mMat[12] = -(f1 + f) / (f1 - f);
        mMat[13] = -(f3 + f2) / (f3 - f2);
        mMat[14] = -(f5 + f4) / (f5 - f4);
    }

    public void loadOrthoWindow(int i, int j) {
        loadOrtho(0.0F, i, j, 0.0F, -1F, 1.0F);
    }

    public void loadPerspective(float f, float f1, float f2, float f3) {
        float f4 = f2 * (float)Math.tan((float)((3.1415926535897931D * (double)f) / 360D));
        float f5 = -f4;
        loadFrustum(f5 * f1, f4 * f1, f5, f4, f2, f3);
    }

    public void loadProjectionNormalized(int i, int j) {
        Matrix4f matrix4f = new Matrix4f();
        Matrix4f matrix4f1 = new Matrix4f();
        if(i > j) {
            float f1 = (float)i / (float)j;
            matrix4f.loadFrustum(-f1, f1, -1F, 1.0F, 1.0F, 100F);
        } else {
            float f = (float)j / (float)i;
            matrix4f.loadFrustum(-1F, 1.0F, -f, f, 1.0F, 100F);
        }
        matrix4f1.loadRotate(180F, 0.0F, 1.0F, 0.0F);
        matrix4f.loadMultiply(matrix4f, matrix4f1);
        matrix4f1.loadScale(-2F, 2.0F, 1.0F);
        matrix4f.loadMultiply(matrix4f, matrix4f1);
        matrix4f1.loadTranslate(0.0F, 0.0F, 2.0F);
        matrix4f.loadMultiply(matrix4f, matrix4f1);
        load(matrix4f);
    }

    public void loadRotate(float f, float f1, float f2, float f3) {
        mMat[3] = 0.0F;
        mMat[7] = 0.0F;
        mMat[11] = 0.0F;
        mMat[12] = 0.0F;
        mMat[13] = 0.0F;
        mMat[14] = 0.0F;
        mMat[15] = 1.0F;
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
        mMat[4] = f9 * f8 - f14;
        mMat[8] = f13 + f11 * f8;
        mMat[1] = f14 + f9 * f8;
        mMat[5] = f5 + f8 * (f2 * f2);
        mMat[9] = f10 * f8 - f12;
        mMat[2] = f11 * f8 - f13;
        mMat[6] = f12 + f10 * f8;
        mMat[10] = f5 + f8 * (f3 * f3);
    }

    public void loadScale(float f, float f1, float f2) {
        loadIdentity();
        mMat[0] = f;
        mMat[5] = f1;
        mMat[10] = f2;
    }

    public void loadTranslate(float f, float f1, float f2) {
        loadIdentity();
        mMat[12] = f;
        mMat[13] = f1;
        mMat[14] = f2;
    }

    public void multiply(Matrix4f matrix4f) {
        Matrix4f matrix4f1 = new Matrix4f();
        matrix4f1.loadMultiply(this, matrix4f);
        load(matrix4f1);
    }

    public void rotate(float f, float f1, float f2, float f3) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.loadRotate(f, f1, f2, f3);
        multiply(matrix4f);
    }

    public void scale(float f, float f1, float f2) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.loadScale(f, f1, f2);
        multiply(matrix4f);
    }

    public void set(int i, int j, float f) {
        mMat[j + i * 4] = f;
    }

    public void translate(float f, float f1, float f2) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.loadTranslate(f, f1, f2);
        multiply(matrix4f);
    }

    public void transpose() {
        for(int i = 0; i < 3; i++) {
            for(int j = i + 1; j < 4; j++) {
                float f = mMat[j + i * 4];
                mMat[j + i * 4] = mMat[i + j * 4];
                mMat[i + j * 4] = f;
            }

        }

    }

    final float mMat[];
}
