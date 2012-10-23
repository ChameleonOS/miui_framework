// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Matrix

public class Shader {
    public static final class TileMode extends Enum {

        public static TileMode valueOf(String s) {
            return (TileMode)Enum.valueOf(android/graphics/Shader$TileMode, s);
        }

        public static TileMode[] values() {
            return (TileMode[])$VALUES.clone();
        }

        private static final TileMode $VALUES[];
        public static final TileMode CLAMP;
        public static final TileMode MIRROR;
        public static final TileMode REPEAT;
        final int nativeInt;

        static  {
            CLAMP = new TileMode("CLAMP", 0, 0);
            REPEAT = new TileMode("REPEAT", 1, 1);
            MIRROR = new TileMode("MIRROR", 2, 2);
            TileMode atilemode[] = new TileMode[3];
            atilemode[0] = CLAMP;
            atilemode[1] = REPEAT;
            atilemode[2] = MIRROR;
            $VALUES = atilemode;
        }

        private TileMode(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }


    public Shader() {
    }

    private static native void nativeDestructor(int i, int j);

    private static native void nativeSetLocalMatrix(int i, int j, int k);

    protected void finalize() throws Throwable {
        super.finalize();
        nativeDestructor(native_instance, native_shader);
        return;
        Exception exception;
        exception;
        nativeDestructor(native_instance, native_shader);
        throw exception;
    }

    public boolean getLocalMatrix(Matrix matrix) {
        boolean flag = false;
        if(mLocalMatrix != null) {
            matrix.set(mLocalMatrix);
            if(!mLocalMatrix.isIdentity())
                flag = true;
        }
        return flag;
    }

    public void setLocalMatrix(Matrix matrix) {
        mLocalMatrix = matrix;
        int i = native_instance;
        int j = native_shader;
        int k;
        if(matrix == null)
            k = 0;
        else
            k = matrix.native_instance;
        nativeSetLocalMatrix(i, j, k);
    }

    private Matrix mLocalMatrix;
    public int native_instance;
    public int native_shader;
}
