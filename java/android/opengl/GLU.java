// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package android.opengl:
//            Matrix

public class GLU {

    public GLU() {
    }

    public static String gluErrorString(int i) {
        i;
        JVM INSTR lookupswitch 7: default 68
    //                   0: 72
    //                   1280: 78
    //                   1281: 84
    //                   1282: 90
    //                   1283: 96
    //                   1284: 102
    //                   1285: 108;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        String s = null;
_L10:
        return s;
_L2:
        s = "no error";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "invalid enum";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "invalid value";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "invalid operation";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "stack overflow";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "stack underflow";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "out of memory";
        if(true) goto _L10; else goto _L9
_L9:
    }

    public static void gluLookAt(GL10 gl10, float f, float f1, float f2, float f3, float f4, float f5, float f6, 
            float f7, float f8) {
        float af[] = sScratch;
        af;
        JVM INSTR monitorenter ;
        Matrix.setLookAtM(af, 0, f, f1, f2, f3, f4, f5, f6, f7, f8);
        gl10.glMultMatrixf(af, 0);
        return;
    }

    public static void gluOrtho2D(GL10 gl10, float f, float f1, float f2, float f3) {
        gl10.glOrthof(f, f1, f2, f3, -1F, 1.0F);
    }

    public static void gluPerspective(GL10 gl10, float f, float f1, float f2, float f3) {
        float f4 = f2 * (float)Math.tan(0.0087266462599716477D * (double)f);
        float f5 = -f4;
        gl10.glFrustumf(f5 * f1, f4 * f1, f5, f4, f2, f3);
    }

    public static int gluProject(float f, float f1, float f2, float af[], int i, float af1[], int j, int ai[], 
            int k, float af2[], int l) {
        float af3[] = sScratch;
        af3;
        JVM INSTR monitorenter ;
        Matrix.multiplyMM(af3, 0, af1, j, af, i);
        af3[16] = f;
        af3[17] = f1;
        af3[18] = f2;
        af3[19] = 1.0F;
        Matrix.multiplyMV(af3, 20, af3, 0, af3, 16);
        float f3 = af3[23];
        int i1;
        if(f3 == 0.0F) {
            i1 = 0;
        } else {
            float f4 = 1.0F / f3;
            af2[l] = (float)ai[k] + 0.5F * ((float)ai[k + 2] * (1.0F + f4 * af3[20]));
            af2[l + 1] = (float)ai[k + 1] + 0.5F * ((float)ai[k + 3] * (1.0F + f4 * af3[21]));
            af2[l + 2] = 0.5F * (1.0F + f4 * af3[22]);
            i1 = 1;
        }
        return i1;
    }

    public static int gluUnProject(float f, float f1, float f2, float af[], int i, float af1[], int j, int ai[], 
            int k, float af2[], int l) {
        float af3[] = sScratch;
        af3;
        JVM INSTR monitorenter ;
        Matrix.multiplyMM(af3, 0, af1, j, af, i);
        int i1;
        if(!Matrix.invertM(af3, 16, af3, 0)) {
            i1 = 0;
        } else {
            af3[0] = (2.0F * (f - (float)ai[k + 0])) / (float)ai[k + 2] - 1.0F;
            af3[1] = (2.0F * (f1 - (float)ai[k + 1])) / (float)ai[k + 3] - 1.0F;
            af3[2] = 2.0F * f2 - 1.0F;
            af3[3] = 1.0F;
            Matrix.multiplyMV(af2, l, af3, 16, af3, 0);
            i1 = 1;
        }
        return i1;
    }

    private static final float sScratch[] = new float[32];

}
