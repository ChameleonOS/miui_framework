// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import java.io.PrintWriter;

// Referenced classes of package android.graphics:
//            RectF

public class Matrix {
    public static final class ScaleToFit extends Enum {

        public static ScaleToFit valueOf(String s) {
            return (ScaleToFit)Enum.valueOf(android/graphics/Matrix$ScaleToFit, s);
        }

        public static ScaleToFit[] values() {
            return (ScaleToFit[])$VALUES.clone();
        }

        private static final ScaleToFit $VALUES[];
        public static final ScaleToFit CENTER;
        public static final ScaleToFit END;
        public static final ScaleToFit FILL;
        public static final ScaleToFit START;
        final int nativeInt;

        static  {
            FILL = new ScaleToFit("FILL", 0, 0);
            START = new ScaleToFit("START", 1, 1);
            CENTER = new ScaleToFit("CENTER", 2, 2);
            END = new ScaleToFit("END", 3, 3);
            ScaleToFit ascaletofit[] = new ScaleToFit[4];
            ascaletofit[0] = FILL;
            ascaletofit[1] = START;
            ascaletofit[2] = CENTER;
            ascaletofit[3] = END;
            $VALUES = ascaletofit;
        }

        private ScaleToFit(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }


    public Matrix() {
        native_instance = native_create(0);
    }

    public Matrix(Matrix matrix) {
        int i;
        if(matrix != null)
            i = matrix.native_instance;
        else
            i = 0;
        native_instance = native_create(i);
    }

    private static void checkPointArrays(float af[], int i, float af1[], int j, int k) {
        int l = i + (k << 1);
        int i1 = j + (k << 1);
        if((i1 | (l | (j | (k | i)))) < 0 || l > af.length || i1 > af1.length)
            throw new ArrayIndexOutOfBoundsException();
        else
            return;
    }

    private static native void finalizer(int i);

    private static native int native_create(int i);

    private static native boolean native_equals(int i, int j);

    private static native void native_getValues(int i, float af[]);

    private static native boolean native_invert(int i, int j);

    private static native boolean native_isIdentity(int i);

    private static native void native_mapPoints(int i, float af[], int j, float af1[], int k, int l, boolean flag);

    private static native float native_mapRadius(int i, float f);

    private static native boolean native_mapRect(int i, RectF rectf, RectF rectf1);

    private static native boolean native_postConcat(int i, int j);

    private static native boolean native_postRotate(int i, float f);

    private static native boolean native_postRotate(int i, float f, float f1, float f2);

    private static native boolean native_postScale(int i, float f, float f1);

    private static native boolean native_postScale(int i, float f, float f1, float f2, float f3);

    private static native boolean native_postSkew(int i, float f, float f1);

    private static native boolean native_postSkew(int i, float f, float f1, float f2, float f3);

    private static native boolean native_postTranslate(int i, float f, float f1);

    private static native boolean native_preConcat(int i, int j);

    private static native boolean native_preRotate(int i, float f);

    private static native boolean native_preRotate(int i, float f, float f1, float f2);

    private static native boolean native_preScale(int i, float f, float f1);

    private static native boolean native_preScale(int i, float f, float f1, float f2, float f3);

    private static native boolean native_preSkew(int i, float f, float f1);

    private static native boolean native_preSkew(int i, float f, float f1, float f2, float f3);

    private static native boolean native_preTranslate(int i, float f, float f1);

    private static native boolean native_rectStaysRect(int i);

    private static native void native_reset(int i);

    private static native void native_set(int i, int j);

    private static native boolean native_setConcat(int i, int j, int k);

    private static native boolean native_setPolyToPoly(int i, float af[], int j, float af1[], int k, int l);

    private static native boolean native_setRectToRect(int i, RectF rectf, RectF rectf1, int j);

    private static native void native_setRotate(int i, float f);

    private static native void native_setRotate(int i, float f, float f1, float f2);

    private static native void native_setScale(int i, float f, float f1);

    private static native void native_setScale(int i, float f, float f1, float f2, float f3);

    private static native void native_setSinCos(int i, float f, float f1);

    private static native void native_setSinCos(int i, float f, float f1, float f2, float f3);

    private static native void native_setSkew(int i, float f, float f1);

    private static native void native_setSkew(int i, float f, float f1, float f2, float f3);

    private static native void native_setTranslate(int i, float f, float f1);

    private static native void native_setValues(int i, float af[]);

    public boolean equals(Object obj) {
        boolean flag;
        if(obj != null && (obj instanceof Matrix) && native_equals(native_instance, ((Matrix)obj).native_instance))
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected void finalize() throws Throwable {
        finalizer(native_instance);
    }

    public void getValues(float af[]) {
        if(af.length < 9) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            native_getValues(native_instance, af);
            return;
        }
    }

    public boolean invert(Matrix matrix) {
        return native_invert(native_instance, matrix.native_instance);
    }

    public boolean isIdentity() {
        return native_isIdentity(native_instance);
    }

    public void mapPoints(float af[]) {
        mapPoints(af, 0, af, 0, af.length >> 1);
    }

    public void mapPoints(float af[], int i, float af1[], int j, int k) {
        checkPointArrays(af1, j, af, i, k);
        native_mapPoints(native_instance, af, i, af1, j, k, true);
    }

    public void mapPoints(float af[], float af1[]) {
        if(af.length != af1.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            mapPoints(af, 0, af1, 0, af.length >> 1);
            return;
        }
    }

    public float mapRadius(float f) {
        return native_mapRadius(native_instance, f);
    }

    public boolean mapRect(RectF rectf) {
        return mapRect(rectf, rectf);
    }

    public boolean mapRect(RectF rectf, RectF rectf1) {
        if(rectf == null || rectf1 == null)
            throw new NullPointerException();
        else
            return native_mapRect(native_instance, rectf, rectf1);
    }

    public void mapVectors(float af[]) {
        mapVectors(af, 0, af, 0, af.length >> 1);
    }

    public void mapVectors(float af[], int i, float af1[], int j, int k) {
        checkPointArrays(af1, j, af, i, k);
        native_mapPoints(native_instance, af, i, af1, j, k, false);
    }

    public void mapVectors(float af[], float af1[]) {
        if(af.length != af1.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            mapVectors(af, 0, af1, 0, af.length >> 1);
            return;
        }
    }

    final int ni() {
        return native_instance;
    }

    public boolean postConcat(Matrix matrix) {
        return native_postConcat(native_instance, matrix.native_instance);
    }

    public boolean postRotate(float f) {
        return native_postRotate(native_instance, f);
    }

    public boolean postRotate(float f, float f1, float f2) {
        return native_postRotate(native_instance, f, f1, f2);
    }

    public boolean postScale(float f, float f1) {
        return native_postScale(native_instance, f, f1);
    }

    public boolean postScale(float f, float f1, float f2, float f3) {
        return native_postScale(native_instance, f, f1, f2, f3);
    }

    public boolean postSkew(float f, float f1) {
        return native_postSkew(native_instance, f, f1);
    }

    public boolean postSkew(float f, float f1, float f2, float f3) {
        return native_postSkew(native_instance, f, f1, f2, f3);
    }

    public boolean postTranslate(float f, float f1) {
        return native_postTranslate(native_instance, f, f1);
    }

    public boolean preConcat(Matrix matrix) {
        return native_preConcat(native_instance, matrix.native_instance);
    }

    public boolean preRotate(float f) {
        return native_preRotate(native_instance, f);
    }

    public boolean preRotate(float f, float f1, float f2) {
        return native_preRotate(native_instance, f, f1, f2);
    }

    public boolean preScale(float f, float f1) {
        return native_preScale(native_instance, f, f1);
    }

    public boolean preScale(float f, float f1, float f2, float f3) {
        return native_preScale(native_instance, f, f1, f2, f3);
    }

    public boolean preSkew(float f, float f1) {
        return native_preSkew(native_instance, f, f1);
    }

    public boolean preSkew(float f, float f1, float f2, float f3) {
        return native_preSkew(native_instance, f, f1, f2, f3);
    }

    public boolean preTranslate(float f, float f1) {
        return native_preTranslate(native_instance, f, f1);
    }

    public void printShortString(PrintWriter printwriter) {
        float af[] = new float[9];
        getValues(af);
        printwriter.print('[');
        printwriter.print(af[0]);
        printwriter.print(", ");
        printwriter.print(af[1]);
        printwriter.print(", ");
        printwriter.print(af[2]);
        printwriter.print("][");
        printwriter.print(af[3]);
        printwriter.print(", ");
        printwriter.print(af[4]);
        printwriter.print(", ");
        printwriter.print(af[5]);
        printwriter.print("][");
        printwriter.print(af[6]);
        printwriter.print(", ");
        printwriter.print(af[7]);
        printwriter.print(", ");
        printwriter.print(af[8]);
        printwriter.print(']');
    }

    public boolean rectStaysRect() {
        return native_rectStaysRect(native_instance);
    }

    public void reset() {
        native_reset(native_instance);
    }

    public void set(Matrix matrix) {
        if(matrix == null)
            reset();
        else
            native_set(native_instance, matrix.native_instance);
    }

    public boolean setConcat(Matrix matrix, Matrix matrix1) {
        return native_setConcat(native_instance, matrix.native_instance, matrix1.native_instance);
    }

    public boolean setPolyToPoly(float af[], int i, float af1[], int j, int k) {
        if(k > 4) {
            throw new IllegalArgumentException();
        } else {
            checkPointArrays(af, i, af1, j, k);
            return native_setPolyToPoly(native_instance, af, i, af1, j, k);
        }
    }

    public boolean setRectToRect(RectF rectf, RectF rectf1, ScaleToFit scaletofit) {
        if(rectf1 == null || rectf == null)
            throw new NullPointerException();
        else
            return native_setRectToRect(native_instance, rectf, rectf1, scaletofit.nativeInt);
    }

    public void setRotate(float f) {
        native_setRotate(native_instance, f);
    }

    public void setRotate(float f, float f1, float f2) {
        native_setRotate(native_instance, f, f1, f2);
    }

    public void setScale(float f, float f1) {
        native_setScale(native_instance, f, f1);
    }

    public void setScale(float f, float f1, float f2, float f3) {
        native_setScale(native_instance, f, f1, f2, f3);
    }

    public void setSinCos(float f, float f1) {
        native_setSinCos(native_instance, f, f1);
    }

    public void setSinCos(float f, float f1, float f2, float f3) {
        native_setSinCos(native_instance, f, f1, f2, f3);
    }

    public void setSkew(float f, float f1) {
        native_setSkew(native_instance, f, f1);
    }

    public void setSkew(float f, float f1, float f2, float f3) {
        native_setSkew(native_instance, f, f1, f2, f3);
    }

    public void setTranslate(float f, float f1) {
        native_setTranslate(native_instance, f, f1);
    }

    public void setValues(float af[]) {
        if(af.length < 9) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            native_setValues(native_instance, af);
            return;
        }
    }

    public String toShortString() {
        StringBuilder stringbuilder = new StringBuilder(64);
        toShortString(stringbuilder);
        return stringbuilder.toString();
    }

    public void toShortString(StringBuilder stringbuilder) {
        float af[] = new float[9];
        getValues(af);
        stringbuilder.append('[');
        stringbuilder.append(af[0]);
        stringbuilder.append(", ");
        stringbuilder.append(af[1]);
        stringbuilder.append(", ");
        stringbuilder.append(af[2]);
        stringbuilder.append("][");
        stringbuilder.append(af[3]);
        stringbuilder.append(", ");
        stringbuilder.append(af[4]);
        stringbuilder.append(", ");
        stringbuilder.append(af[5]);
        stringbuilder.append("][");
        stringbuilder.append(af[6]);
        stringbuilder.append(", ");
        stringbuilder.append(af[7]);
        stringbuilder.append(", ");
        stringbuilder.append(af[8]);
        stringbuilder.append(']');
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append("Matrix{");
        toShortString(stringbuilder);
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public static Matrix IDENTITY_MATRIX = new Matrix() {

        void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        public boolean postRotate(float f) {
            oops();
            return false;
        }

        public boolean postRotate(float f, float f1, float f2) {
            oops();
            return false;
        }

        public boolean postScale(float f, float f1) {
            oops();
            return false;
        }

        public boolean postScale(float f, float f1, float f2, float f3) {
            oops();
            return false;
        }

        public boolean postSkew(float f, float f1) {
            oops();
            return false;
        }

        public boolean postSkew(float f, float f1, float f2, float f3) {
            oops();
            return false;
        }

        public boolean postTranslate(float f, float f1) {
            oops();
            return false;
        }

        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        public boolean preRotate(float f) {
            oops();
            return false;
        }

        public boolean preRotate(float f, float f1, float f2) {
            oops();
            return false;
        }

        public boolean preScale(float f, float f1) {
            oops();
            return false;
        }

        public boolean preScale(float f, float f1, float f2, float f3) {
            oops();
            return false;
        }

        public boolean preSkew(float f, float f1) {
            oops();
            return false;
        }

        public boolean preSkew(float f, float f1, float f2, float f3) {
            oops();
            return false;
        }

        public boolean preTranslate(float f, float f1) {
            oops();
            return false;
        }

        public void reset() {
            oops();
        }

        public void set(Matrix matrix) {
            oops();
        }

        public boolean setConcat(Matrix matrix, Matrix matrix1) {
            oops();
            return false;
        }

        public boolean setPolyToPoly(float af[], int i, float af1[], int j, int k) {
            oops();
            return false;
        }

        public boolean setRectToRect(RectF rectf, RectF rectf1, ScaleToFit scaletofit) {
            oops();
            return false;
        }

        public void setRotate(float f) {
            oops();
        }

        public void setRotate(float f, float f1, float f2) {
            oops();
        }

        public void setScale(float f, float f1) {
            oops();
        }

        public void setScale(float f, float f1, float f2, float f3) {
            oops();
        }

        public void setSinCos(float f, float f1) {
            oops();
        }

        public void setSinCos(float f, float f1, float f2, float f3) {
            oops();
        }

        public void setSkew(float f, float f1) {
            oops();
        }

        public void setSkew(float f, float f1, float f2, float f3) {
            oops();
        }

        public void setTranslate(float f, float f1) {
            oops();
        }

        public void setValues(float af[]) {
            oops();
        }

    };
    public static final int MPERSP_0 = 6;
    public static final int MPERSP_1 = 7;
    public static final int MPERSP_2 = 8;
    public static final int MSCALE_X = 0;
    public static final int MSCALE_Y = 4;
    public static final int MSKEW_X = 1;
    public static final int MSKEW_Y = 3;
    public static final int MTRANS_X = 2;
    public static final int MTRANS_Y = 5;
    public int native_instance;

}
