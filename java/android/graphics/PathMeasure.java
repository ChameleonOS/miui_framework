// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Path, Matrix

public class PathMeasure {

    public PathMeasure() {
        mPath = null;
        native_instance = native_create(0, false);
    }

    public PathMeasure(Path path, boolean flag) {
        mPath = path;
        int i;
        if(path != null)
            i = path.ni();
        else
            i = 0;
        native_instance = native_create(i, flag);
    }

    private static native int native_create(int i, boolean flag);

    private static native void native_destroy(int i);

    private static native float native_getLength(int i);

    private static native boolean native_getMatrix(int i, float f, int j, int k);

    private static native boolean native_getPosTan(int i, float f, float af[], float af1[]);

    private static native boolean native_getSegment(int i, float f, float f1, int j, boolean flag);

    private static native boolean native_isClosed(int i);

    private static native boolean native_nextContour(int i);

    private static native void native_setPath(int i, int j, boolean flag);

    protected void finalize() throws Throwable {
        native_destroy(native_instance);
    }

    public float getLength() {
        return native_getLength(native_instance);
    }

    public boolean getMatrix(float f, Matrix matrix, int i) {
        return native_getMatrix(native_instance, f, matrix.native_instance, i);
    }

    public boolean getPosTan(float f, float af[], float af1[]) {
        if(af != null && af.length < 2 || af1 != null && af1.length < 2)
            throw new ArrayIndexOutOfBoundsException();
        else
            return native_getPosTan(native_instance, f, af, af1);
    }

    public boolean getSegment(float f, float f1, Path path, boolean flag) {
        return native_getSegment(native_instance, f, f1, path.ni(), flag);
    }

    public boolean isClosed() {
        return native_isClosed(native_instance);
    }

    public boolean nextContour() {
        return native_nextContour(native_instance);
    }

    public void setPath(Path path, boolean flag) {
        mPath = path;
        int i = native_instance;
        int j;
        if(path != null)
            j = path.ni();
        else
            j = 0;
        native_setPath(i, j, flag);
    }

    public static final int POSITION_MATRIX_FLAG = 1;
    public static final int TANGENT_MATRIX_FLAG = 2;
    private Path mPath;
    private final int native_instance;
}
