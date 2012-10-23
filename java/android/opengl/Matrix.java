// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;


public class Matrix {

    public Matrix() {
    }

    public static void frustumM(float af[], int i, float f, float f1, float f2, float f3, float f4, float f5) {
        if(f == f1)
            throw new IllegalArgumentException("left == right");
        if(f3 == f2)
            throw new IllegalArgumentException("top == bottom");
        if(f4 == f5)
            throw new IllegalArgumentException("near == far");
        if(f4 <= 0.0F)
            throw new IllegalArgumentException("near <= 0.0f");
        if(f5 <= 0.0F) {
            throw new IllegalArgumentException("far <= 0.0f");
        } else {
            float f6 = 1.0F / (f1 - f);
            float f7 = 1.0F / (f3 - f2);
            float f8 = 1.0F / (f4 - f5);
            float f9 = 2.0F * (f4 * f6);
            float f10 = 2.0F * (f4 * f7);
            float f11 = 2.0F * (f6 * (f1 + f));
            float f12 = f7 * (f3 + f2);
            float f13 = f8 * (f5 + f4);
            float f14 = 2.0F * (f8 * (f5 * f4));
            af[i + 0] = f9;
            af[i + 5] = f10;
            af[i + 8] = f11;
            af[i + 9] = f12;
            af[i + 10] = f13;
            af[i + 14] = f14;
            af[i + 11] = -1F;
            af[i + 1] = 0.0F;
            af[i + 2] = 0.0F;
            af[i + 3] = 0.0F;
            af[i + 4] = 0.0F;
            af[i + 6] = 0.0F;
            af[i + 7] = 0.0F;
            af[i + 12] = 0.0F;
            af[i + 13] = 0.0F;
            af[i + 15] = 0.0F;
            return;
        }
    }

    public static boolean invertM(float af[], int i, float af1[], int j) {
        float f = af1[j + 0];
        float f1 = af1[j + 1];
        float f2 = af1[j + 2];
        float f3 = af1[j + 3];
        float f4 = af1[j + 4];
        float f5 = af1[j + 5];
        float f6 = af1[j + 6];
        float f7 = af1[j + 7];
        float f8 = af1[j + 8];
        float f9 = af1[j + 9];
        float f10 = af1[j + 10];
        float f11 = af1[j + 11];
        float f12 = af1[j + 12];
        float f13 = af1[j + 13];
        float f14 = af1[j + 14];
        float f15 = af1[j + 15];
        float f16 = f10 * f15;
        float f17 = f14 * f11;
        float f18 = f6 * f15;
        float f19 = f14 * f7;
        float f20 = f6 * f11;
        float f21 = f10 * f7;
        float f22 = f2 * f15;
        float f23 = f14 * f3;
        float f24 = f2 * f11;
        float f25 = f10 * f3;
        float f26 = f2 * f7;
        float f27 = f6 * f3;
        float f28 = (f16 * f5 + f19 * f9 + f20 * f13) - (f17 * f5 + f18 * f9 + f21 * f13);
        float f29 = (f17 * f1 + f22 * f9 + f25 * f13) - (f16 * f1 + f23 * f9 + f24 * f13);
        float f30 = (f18 * f1 + f23 * f5 + f26 * f13) - (f19 * f1 + f22 * f5 + f27 * f13);
        float f31 = (f21 * f1 + f24 * f5 + f27 * f9) - (f20 * f1 + f25 * f5 + f26 * f9);
        float f32 = (f17 * f4 + f18 * f8 + f21 * f12) - (f16 * f4 + f19 * f8 + f20 * f12);
        float f33 = (f16 * f + f23 * f8 + f24 * f12) - (f17 * f + f22 * f8 + f25 * f12);
        float f34 = (f19 * f + f22 * f4 + f27 * f12) - (f18 * f + f23 * f4 + f26 * f12);
        float f35 = (f20 * f + f25 * f4 + f26 * f8) - (f21 * f + f24 * f4 + f27 * f8);
        float f36 = f8 * f13;
        float f37 = f12 * f9;
        float f38 = f4 * f13;
        float f39 = f12 * f5;
        float f40 = f4 * f9;
        float f41 = f8 * f5;
        float f42 = f * f13;
        float f43 = f12 * f1;
        float f44 = f * f9;
        float f45 = f8 * f1;
        float f46 = f * f5;
        float f47 = f4 * f1;
        float f48 = (f36 * f7 + f39 * f11 + f40 * f15) - (f37 * f7 + f38 * f11 + f41 * f15);
        float f49 = (f37 * f3 + f42 * f11 + f45 * f15) - (f36 * f3 + f43 * f11 + f44 * f15);
        float f50 = (f38 * f3 + f43 * f7 + f46 * f15) - (f39 * f3 + f42 * f7 + f47 * f15);
        float f51 = (f41 * f3 + f44 * f7 + f47 * f11) - (f40 * f3 + f45 * f7 + f46 * f11);
        float f52 = (f38 * f10 + f41 * f14 + f37 * f6) - (f40 * f14 + f36 * f6 + f39 * f10);
        float f53 = (f44 * f14 + f36 * f2 + f43 * f10) - (f42 * f10 + f45 * f14 + f37 * f2);
        float f54 = (f42 * f6 + f47 * f14 + f39 * f2) - (f46 * f14 + f38 * f2 + f43 * f6);
        float f55 = (f46 * f10 + f40 * f2 + f45 * f6) - (f44 * f6 + f47 * f10 + f41 * f2);
        float f56 = f * f28 + f4 * f29 + f8 * f30 + f12 * f31;
        boolean flag;
        if(f56 == 0.0F) {
            flag = false;
        } else {
            float f57 = 1.0F / f56;
            af[i] = f28 * f57;
            af[i + 1] = f29 * f57;
            af[i + 2] = f30 * f57;
            af[i + 3] = f31 * f57;
            af[i + 4] = f32 * f57;
            af[i + 5] = f33 * f57;
            af[i + 6] = f34 * f57;
            af[i + 7] = f35 * f57;
            af[i + 8] = f48 * f57;
            af[i + 9] = f49 * f57;
            af[i + 10] = f50 * f57;
            af[i + 11] = f51 * f57;
            af[i + 12] = f52 * f57;
            af[i + 13] = f53 * f57;
            af[i + 14] = f54 * f57;
            af[i + 15] = f55 * f57;
            flag = true;
        }
        return flag;
    }

    public static float length(float f, float f1, float f2) {
        return (float)Math.sqrt(f * f + f1 * f1 + f2 * f2);
    }

    public static native void multiplyMM(float af[], int i, float af1[], int j, float af2[], int k);

    public static native void multiplyMV(float af[], int i, float af1[], int j, float af2[], int k);

    public static void orthoM(float af[], int i, float f, float f1, float f2, float f3, float f4, float f5) {
        if(f == f1)
            throw new IllegalArgumentException("left == right");
        if(f2 == f3)
            throw new IllegalArgumentException("bottom == top");
        if(f4 == f5) {
            throw new IllegalArgumentException("near == far");
        } else {
            float f6 = 1.0F / (f1 - f);
            float f7 = 1.0F / (f3 - f2);
            float f8 = 1.0F / (f5 - f4);
            float f9 = 2.0F * f6;
            float f10 = 2.0F * f7;
            float f11 = -2F * f8;
            float f12 = f6 * -(f1 + f);
            float f13 = f7 * -(f3 + f2);
            float f14 = f8 * -(f5 + f4);
            af[i + 0] = f9;
            af[i + 5] = f10;
            af[i + 10] = f11;
            af[i + 12] = f12;
            af[i + 13] = f13;
            af[i + 14] = f14;
            af[i + 15] = 1.0F;
            af[i + 1] = 0.0F;
            af[i + 2] = 0.0F;
            af[i + 3] = 0.0F;
            af[i + 4] = 0.0F;
            af[i + 6] = 0.0F;
            af[i + 7] = 0.0F;
            af[i + 8] = 0.0F;
            af[i + 9] = 0.0F;
            af[i + 11] = 0.0F;
            return;
        }
    }

    public static void perspectiveM(float af[], int i, float f, float f1, float f2, float f3) {
        float f4 = 1.0F / (float)Math.tan(0.0087266462599716477D * (double)f);
        float f5 = 1.0F / (f2 - f3);
        af[i + 0] = f4 / f1;
        af[i + 1] = 0.0F;
        af[i + 2] = 0.0F;
        af[i + 3] = 0.0F;
        af[i + 4] = 0.0F;
        af[i + 5] = f4;
        af[i + 6] = 0.0F;
        af[i + 7] = 0.0F;
        af[i + 8] = 0.0F;
        af[i + 9] = 0.0F;
        af[i + 10] = f5 * (f3 + f2);
        af[i + 11] = -1F;
        af[i + 12] = 0.0F;
        af[i + 13] = 0.0F;
        af[i + 14] = f5 * (f2 * (2.0F * f3));
        af[i + 15] = 0.0F;
    }

    public static void rotateM(float af[], int i, float f, float f1, float f2, float f3) {
        float af1[] = sTemp;
        af1;
        JVM INSTR monitorenter ;
        setRotateM(sTemp, 0, f, f1, f2, f3);
        multiplyMM(sTemp, 16, af, i, sTemp, 0);
        System.arraycopy(sTemp, 16, af, i, 16);
        return;
    }

    public static void rotateM(float af[], int i, float af1[], int j, float f, float f1, float f2, float f3) {
        float af2[] = sTemp;
        af2;
        JVM INSTR monitorenter ;
        setRotateM(sTemp, 0, f, f1, f2, f3);
        multiplyMM(af, i, af1, j, sTemp, 0);
        return;
    }

    public static void scaleM(float af[], int i, float f, float f1, float f2) {
        for(int j = 0; j < 4; j++) {
            int k = i + j;
            af[k] = f * af[k];
            int l = k + 4;
            af[l] = f1 * af[l];
            int i1 = k + 8;
            af[i1] = f2 * af[i1];
        }

    }

    public static void scaleM(float af[], int i, float af1[], int j, float f, float f1, float f2) {
        for(int k = 0; k < 4; k++) {
            int l = i + k;
            int i1 = j + k;
            af[l] = f * af1[i1];
            af[l + 4] = f1 * af1[i1 + 4];
            af[l + 8] = f2 * af1[i1 + 8];
            af[l + 12] = af1[i1 + 12];
        }

    }

    public static void setIdentityM(float af[], int i) {
        for(int j = 0; j < 16; j++)
            af[i + j] = 0.0F;

        for(int k = 0; k < 16; k += 5)
            af[i + k] = 1.0F;

    }

    public static void setLookAtM(float af[], int i, float f, float f1, float f2, float f3, float f4, float f5, 
            float f6, float f7, float f8) {
        float f9 = f3 - f;
        float f10 = f4 - f1;
        float f11 = f5 - f2;
        float f12 = 1.0F / length(f9, f10, f11);
        float f13 = f9 * f12;
        float f14 = f10 * f12;
        float f15 = f11 * f12;
        float f16 = f14 * f8 - f15 * f7;
        float f17 = f15 * f6 - f13 * f8;
        float f18 = f13 * f7 - f14 * f6;
        float f19 = 1.0F / length(f16, f17, f18);
        float f20 = f16 * f19;
        float f21 = f17 * f19;
        float f22 = f18 * f19;
        float f23 = f21 * f15 - f22 * f14;
        float f24 = f22 * f13 - f20 * f15;
        float f25 = f20 * f14 - f21 * f13;
        af[i + 0] = f20;
        af[i + 1] = f23;
        af[i + 2] = -f13;
        af[i + 3] = 0.0F;
        af[i + 4] = f21;
        af[i + 5] = f24;
        af[i + 6] = -f14;
        af[i + 7] = 0.0F;
        af[i + 8] = f22;
        af[i + 9] = f25;
        af[i + 10] = -f15;
        af[i + 11] = 0.0F;
        af[i + 12] = 0.0F;
        af[i + 13] = 0.0F;
        af[i + 14] = 0.0F;
        af[i + 15] = 1.0F;
        translateM(af, i, -f, -f1, -f2);
    }

    public static void setRotateEulerM(float af[], int i, float f, float f1, float f2) {
        float f3 = f * 0.01745329F;
        float f4 = f1 * 0.01745329F;
        float f5 = f2 * 0.01745329F;
        float f6 = (float)Math.cos(f3);
        float f7 = (float)Math.sin(f3);
        float f8 = (float)Math.cos(f4);
        float f9 = (float)Math.sin(f4);
        float f10 = (float)Math.cos(f5);
        float f11 = (float)Math.sin(f5);
        float f12 = f6 * f9;
        float f13 = f7 * f9;
        af[i + 0] = f8 * f10;
        af[i + 1] = f11 * -f8;
        af[i + 2] = f9;
        af[i + 3] = 0.0F;
        af[i + 4] = f12 * f10 + f6 * f11;
        af[i + 5] = f11 * -f12 + f6 * f10;
        af[i + 6] = f8 * -f7;
        af[i + 7] = 0.0F;
        af[i + 8] = f10 * -f13 + f7 * f11;
        af[i + 9] = f13 * f11 + f7 * f10;
        af[i + 10] = f6 * f8;
        af[i + 11] = 0.0F;
        af[i + 12] = 0.0F;
        af[i + 13] = 0.0F;
        af[i + 14] = 0.0F;
        af[i + 15] = 1.0F;
    }

    public static void setRotateM(float af[], int i, float f, float f1, float f2, float f3) {
        af[i + 3] = 0.0F;
        af[i + 7] = 0.0F;
        af[i + 11] = 0.0F;
        af[i + 12] = 0.0F;
        af[i + 13] = 0.0F;
        af[i + 14] = 0.0F;
        af[i + 15] = 1.0F;
        float f4 = f * 0.01745329F;
        float f5 = (float)Math.sin(f4);
        float f6 = (float)Math.cos(f4);
        if(1.0F == f1 && 0.0F == f2 && 0.0F == f3) {
            af[i + 5] = f6;
            af[i + 10] = f6;
            af[i + 6] = f5;
            af[i + 9] = -f5;
            af[i + 1] = 0.0F;
            af[i + 2] = 0.0F;
            af[i + 4] = 0.0F;
            af[i + 8] = 0.0F;
            af[i + 0] = 1.0F;
        } else
        if(0.0F == f1 && 1.0F == f2 && 0.0F == f3) {
            af[i + 0] = f6;
            af[i + 10] = f6;
            af[i + 8] = f5;
            af[i + 2] = -f5;
            af[i + 1] = 0.0F;
            af[i + 4] = 0.0F;
            af[i + 6] = 0.0F;
            af[i + 9] = 0.0F;
            af[i + 5] = 1.0F;
        } else
        if(0.0F == f1 && 0.0F == f2 && 1.0F == f3) {
            af[i + 0] = f6;
            af[i + 5] = f6;
            af[i + 1] = f5;
            af[i + 4] = -f5;
            af[i + 2] = 0.0F;
            af[i + 6] = 0.0F;
            af[i + 8] = 0.0F;
            af[i + 9] = 0.0F;
            af[i + 10] = 1.0F;
        } else {
            float f7 = length(f1, f2, f3);
            if(1.0F != f7) {
                float f15 = 1.0F / f7;
                f1 *= f15;
                f2 *= f15;
                f3 *= f15;
            }
            float f8 = 1.0F - f6;
            float f9 = f1 * f2;
            float f10 = f2 * f3;
            float f11 = f3 * f1;
            float f12 = f1 * f5;
            float f13 = f2 * f5;
            float f14 = f3 * f5;
            af[i + 0] = f6 + f8 * (f1 * f1);
            af[i + 4] = f9 * f8 - f14;
            af[i + 8] = f13 + f11 * f8;
            af[i + 1] = f14 + f9 * f8;
            af[i + 5] = f6 + f8 * (f2 * f2);
            af[i + 9] = f10 * f8 - f12;
            af[i + 2] = f11 * f8 - f13;
            af[i + 6] = f12 + f10 * f8;
            af[i + 10] = f6 + f8 * (f3 * f3);
        }
    }

    public static void translateM(float af[], int i, float f, float f1, float f2) {
        for(int j = 0; j < 4; j++) {
            int k = i + j;
            int l = k + 12;
            af[l] = af[l] + (f * af[k] + f1 * af[k + 4] + f2 * af[k + 8]);
        }

    }

    public static void translateM(float af[], int i, float af1[], int j, float f, float f1, float f2) {
        for(int k = 0; k < 12; k++)
            af[i + k] = af1[j + k];

        for(int l = 0; l < 4; l++) {
            int i1 = i + l;
            int j1 = j + l;
            af[i1 + 12] = f * af1[j1] + f1 * af1[j1 + 4] + f2 * af1[j1 + 8] + af1[j1 + 12];
        }

    }

    public static void transposeM(float af[], int i, float af1[], int j) {
        for(int k = 0; k < 4; k++) {
            int l = j + k * 4;
            af[k + i] = af1[l];
            af[i + (k + 4)] = af1[l + 1];
            af[i + (k + 8)] = af1[l + 2];
            af[i + (k + 12)] = af1[l + 3];
        }

    }

    private static final float sTemp[] = new float[32];

}
