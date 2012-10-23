// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.view.HardwareRenderer;

// Referenced classes of package android.graphics:
//            Region, Matrix, RectF

public class Path {
    public static final class Direction extends Enum {

        public static Direction valueOf(String s) {
            return (Direction)Enum.valueOf(android/graphics/Path$Direction, s);
        }

        public static Direction[] values() {
            return (Direction[])$VALUES.clone();
        }

        private static final Direction $VALUES[];
        public static final Direction CCW;
        public static final Direction CW;
        final int nativeInt;

        static  {
            CW = new Direction("CW", 0, 0);
            CCW = new Direction("CCW", 1, 1);
            Direction adirection[] = new Direction[2];
            adirection[0] = CW;
            adirection[1] = CCW;
            $VALUES = adirection;
        }

        private Direction(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }

    public static final class FillType extends Enum {

        public static FillType valueOf(String s) {
            return (FillType)Enum.valueOf(android/graphics/Path$FillType, s);
        }

        public static FillType[] values() {
            return (FillType[])$VALUES.clone();
        }

        private static final FillType $VALUES[];
        public static final FillType EVEN_ODD;
        public static final FillType INVERSE_EVEN_ODD;
        public static final FillType INVERSE_WINDING;
        public static final FillType WINDING;
        final int nativeInt;

        static  {
            WINDING = new FillType("WINDING", 0, 0);
            EVEN_ODD = new FillType("EVEN_ODD", 1, 1);
            INVERSE_WINDING = new FillType("INVERSE_WINDING", 2, 2);
            INVERSE_EVEN_ODD = new FillType("INVERSE_EVEN_ODD", 3, 3);
            FillType afilltype[] = new FillType[4];
            afilltype[0] = WINDING;
            afilltype[1] = EVEN_ODD;
            afilltype[2] = INVERSE_WINDING;
            afilltype[3] = INVERSE_EVEN_ODD;
            $VALUES = afilltype;
        }

        private FillType(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }


    public Path() {
        isSimplePath = true;
        mLastDirection = null;
        mNativePath = init1();
        mDetectSimplePaths = HardwareRenderer.isAvailable();
    }

    public Path(Path path) {
        isSimplePath = true;
        mLastDirection = null;
        int i = 0;
        if(path != null)
            i = path.mNativePath;
        mNativePath = init2(i);
        mDetectSimplePaths = HardwareRenderer.isAvailable();
    }

    private void detectSimplePath(float f, float f1, float f2, float f3, Direction direction) {
        if(mDetectSimplePaths) {
            if(mLastDirection == null)
                mLastDirection = direction;
            if(mLastDirection != direction) {
                isSimplePath = false;
            } else {
                if(rects == null)
                    rects = new Region();
                rects.op((int)f, (int)f1, (int)f2, (int)f3, Region.Op.UNION);
            }
        }
    }

    private static native void finalizer(int i);

    private static native int init1();

    private static native int init2(int i);

    private static native void native_addArc(int i, RectF rectf, float f, float f1);

    private static native void native_addCircle(int i, float f, float f1, float f2, int j);

    private static native void native_addOval(int i, RectF rectf, int j);

    private static native void native_addPath(int i, int j);

    private static native void native_addPath(int i, int j, float f, float f1);

    private static native void native_addPath(int i, int j, int k);

    private static native void native_addRect(int i, float f, float f1, float f2, float f3, int j);

    private static native void native_addRect(int i, RectF rectf, int j);

    private static native void native_addRoundRect(int i, RectF rectf, float f, float f1, int j);

    private static native void native_addRoundRect(int i, RectF rectf, float af[], int j);

    private static native void native_arcTo(int i, RectF rectf, float f, float f1, boolean flag);

    private static native void native_close(int i);

    private static native void native_computeBounds(int i, RectF rectf);

    private static native void native_cubicTo(int i, float f, float f1, float f2, float f3, float f4, float f5);

    private static native int native_getFillType(int i);

    private static native void native_incReserve(int i, int j);

    private static native boolean native_isEmpty(int i);

    private static native boolean native_isRect(int i, RectF rectf);

    private static native void native_lineTo(int i, float f, float f1);

    private static native void native_moveTo(int i, float f, float f1);

    private static native void native_offset(int i, float f, float f1);

    private static native void native_offset(int i, float f, float f1, int j);

    private static native void native_quadTo(int i, float f, float f1, float f2, float f3);

    private static native void native_rCubicTo(int i, float f, float f1, float f2, float f3, float f4, float f5);

    private static native void native_rLineTo(int i, float f, float f1);

    private static native void native_rMoveTo(int i, float f, float f1);

    private static native void native_rQuadTo(int i, float f, float f1, float f2, float f3);

    private static native void native_reset(int i);

    private static native void native_rewind(int i);

    private static native void native_set(int i, int j);

    private static native void native_setFillType(int i, int j);

    private static native void native_setLastPoint(int i, float f, float f1);

    private static native void native_transform(int i, int j);

    private static native void native_transform(int i, int j, int k);

    public void addArc(RectF rectf, float f, float f1) {
        if(rectf == null) {
            throw new NullPointerException("need oval parameter");
        } else {
            isSimplePath = false;
            native_addArc(mNativePath, rectf, f, f1);
            return;
        }
    }

    public void addCircle(float f, float f1, float f2, Direction direction) {
        isSimplePath = false;
        native_addCircle(mNativePath, f, f1, f2, direction.nativeInt);
    }

    public void addOval(RectF rectf, Direction direction) {
        if(rectf == null) {
            throw new NullPointerException("need oval parameter");
        } else {
            isSimplePath = false;
            native_addOval(mNativePath, rectf, direction.nativeInt);
            return;
        }
    }

    public void addPath(Path path) {
        isSimplePath = false;
        native_addPath(mNativePath, path.mNativePath);
    }

    public void addPath(Path path, float f, float f1) {
        isSimplePath = false;
        native_addPath(mNativePath, path.mNativePath, f, f1);
    }

    public void addPath(Path path, Matrix matrix) {
        if(!path.isSimplePath)
            isSimplePath = false;
        native_addPath(mNativePath, path.mNativePath, matrix.native_instance);
    }

    public void addRect(float f, float f1, float f2, float f3, Direction direction) {
        detectSimplePath(f, f1, f2, f3, direction);
        native_addRect(mNativePath, f, f1, f2, f3, direction.nativeInt);
    }

    public void addRect(RectF rectf, Direction direction) {
        if(rectf == null) {
            throw new NullPointerException("need rect parameter");
        } else {
            detectSimplePath(rectf.left, rectf.top, rectf.right, rectf.bottom, direction);
            native_addRect(mNativePath, rectf, direction.nativeInt);
            return;
        }
    }

    public void addRoundRect(RectF rectf, float f, float f1, Direction direction) {
        if(rectf == null) {
            throw new NullPointerException("need rect parameter");
        } else {
            isSimplePath = false;
            native_addRoundRect(mNativePath, rectf, f, f1, direction.nativeInt);
            return;
        }
    }

    public void addRoundRect(RectF rectf, float af[], Direction direction) {
        if(rectf == null)
            throw new NullPointerException("need rect parameter");
        if(af.length < 8) {
            throw new ArrayIndexOutOfBoundsException("radii[] needs 8 values");
        } else {
            isSimplePath = false;
            native_addRoundRect(mNativePath, rectf, af, direction.nativeInt);
            return;
        }
    }

    public void arcTo(RectF rectf, float f, float f1) {
        isSimplePath = false;
        native_arcTo(mNativePath, rectf, f, f1, false);
    }

    public void arcTo(RectF rectf, float f, float f1, boolean flag) {
        isSimplePath = false;
        native_arcTo(mNativePath, rectf, f, f1, flag);
    }

    public void close() {
        isSimplePath = false;
        native_close(mNativePath);
    }

    public void computeBounds(RectF rectf, boolean flag) {
        native_computeBounds(mNativePath, rectf);
    }

    public void cubicTo(float f, float f1, float f2, float f3, float f4, float f5) {
        isSimplePath = false;
        native_cubicTo(mNativePath, f, f1, f2, f3, f4, f5);
    }

    protected void finalize() throws Throwable {
        finalizer(mNativePath);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public FillType getFillType() {
        return sFillTypeArray[native_getFillType(mNativePath)];
    }

    public void incReserve(int i) {
        native_incReserve(mNativePath, i);
    }

    public boolean isEmpty() {
        return native_isEmpty(mNativePath);
    }

    public boolean isInverseFillType() {
        boolean flag;
        if((2 & native_getFillType(mNativePath)) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isRect(RectF rectf) {
        return native_isRect(mNativePath, rectf);
    }

    public void lineTo(float f, float f1) {
        isSimplePath = false;
        native_lineTo(mNativePath, f, f1);
    }

    public void moveTo(float f, float f1) {
        native_moveTo(mNativePath, f, f1);
    }

    final int ni() {
        return mNativePath;
    }

    public void offset(float f, float f1) {
        native_offset(mNativePath, f, f1);
    }

    public void offset(float f, float f1, Path path) {
        int i = 0;
        if(path != null)
            i = path.mNativePath;
        native_offset(mNativePath, f, f1, i);
    }

    public void quadTo(float f, float f1, float f2, float f3) {
        isSimplePath = false;
        native_quadTo(mNativePath, f, f1, f2, f3);
    }

    public void rCubicTo(float f, float f1, float f2, float f3, float f4, float f5) {
        isSimplePath = false;
        native_rCubicTo(mNativePath, f, f1, f2, f3, f4, f5);
    }

    public void rLineTo(float f, float f1) {
        isSimplePath = false;
        native_rLineTo(mNativePath, f, f1);
    }

    public void rMoveTo(float f, float f1) {
        native_rMoveTo(mNativePath, f, f1);
    }

    public void rQuadTo(float f, float f1, float f2, float f3) {
        isSimplePath = false;
        native_rQuadTo(mNativePath, f, f1, f2, f3);
    }

    public void reset() {
        isSimplePath = true;
        if(mDetectSimplePaths) {
            mLastDirection = null;
            if(rects != null)
                rects.setEmpty();
        }
        native_reset(mNativePath);
    }

    public void rewind() {
        isSimplePath = true;
        if(mDetectSimplePaths) {
            mLastDirection = null;
            if(rects != null)
                rects.setEmpty();
        }
        native_rewind(mNativePath);
    }

    public void set(Path path) {
        if(this != path) {
            isSimplePath = path.isSimplePath;
            native_set(mNativePath, path.mNativePath);
        }
    }

    public void setFillType(FillType filltype) {
        native_setFillType(mNativePath, filltype.nativeInt);
    }

    public void setLastPoint(float f, float f1) {
        isSimplePath = false;
        native_setLastPoint(mNativePath, f, f1);
    }

    public void toggleInverseFillType() {
        int i = 2 ^ native_getFillType(mNativePath);
        native_setFillType(mNativePath, i);
    }

    public void transform(Matrix matrix) {
        native_transform(mNativePath, matrix.native_instance);
    }

    public void transform(Matrix matrix, Path path) {
        int i = 0;
        if(path != null)
            i = path.mNativePath;
        native_transform(mNativePath, matrix.native_instance, i);
    }

    static final FillType sFillTypeArray[];
    public boolean isSimplePath;
    private boolean mDetectSimplePaths;
    private Direction mLastDirection;
    public final int mNativePath;
    public Region rects;

    static  {
        FillType afilltype[] = new FillType[4];
        afilltype[0] = FillType.WINDING;
        afilltype[1] = FillType.EVEN_ODD;
        afilltype[2] = FillType.INVERSE_WINDING;
        afilltype[3] = FillType.INVERSE_EVEN_ODD;
        sFillTypeArray = afilltype;
    }
}
