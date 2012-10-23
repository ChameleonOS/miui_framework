// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.graphics:
//            Rect, Path

public class Region
    implements Parcelable {
    public static final class Op extends Enum {

        public static Op valueOf(String s) {
            return (Op)Enum.valueOf(android/graphics/Region$Op, s);
        }

        public static Op[] values() {
            return (Op[])$VALUES.clone();
        }

        private static final Op $VALUES[];
        public static final Op DIFFERENCE;
        public static final Op INTERSECT;
        public static final Op REPLACE;
        public static final Op REVERSE_DIFFERENCE;
        public static final Op UNION;
        public static final Op XOR;
        public final int nativeInt;

        static  {
            DIFFERENCE = new Op("DIFFERENCE", 0, 0);
            INTERSECT = new Op("INTERSECT", 1, 1);
            UNION = new Op("UNION", 2, 2);
            XOR = new Op("XOR", 3, 3);
            REVERSE_DIFFERENCE = new Op("REVERSE_DIFFERENCE", 4, 4);
            REPLACE = new Op("REPLACE", 5, 5);
            Op aop[] = new Op[6];
            aop[0] = DIFFERENCE;
            aop[1] = INTERSECT;
            aop[2] = UNION;
            aop[3] = XOR;
            aop[4] = REVERSE_DIFFERENCE;
            aop[5] = REPLACE;
            $VALUES = aop;
        }

        private Op(String s, int i, int j) {
            super(s, i);
            nativeInt = j;
        }
    }


    public Region() {
        this(nativeConstructor());
    }

    Region(int i) {
        if(i == 0) {
            throw new RuntimeException();
        } else {
            mNativeRegion = i;
            return;
        }
    }

    private Region(int i, int j) {
        this(i);
    }

    public Region(int i, int j, int k, int l) {
        mNativeRegion = nativeConstructor();
        nativeSetRect(mNativeRegion, i, j, k, l);
    }

    public Region(Rect rect) {
        mNativeRegion = nativeConstructor();
        nativeSetRect(mNativeRegion, rect.left, rect.top, rect.right, rect.bottom);
    }

    public Region(Region region) {
        this(nativeConstructor());
        nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    private static native int nativeConstructor();

    private static native int nativeCreateFromParcel(Parcel parcel);

    private static native void nativeDestructor(int i);

    private static native boolean nativeEquals(int i, int j);

    private static native boolean nativeGetBoundaryPath(int i, int j);

    private static native boolean nativeGetBounds(int i, Rect rect);

    private static native boolean nativeOp(int i, int j, int k, int l);

    private static native boolean nativeOp(int i, int j, int k, int l, int i1, int j1);

    private static native boolean nativeOp(int i, Rect rect, int j, int k);

    private static native boolean nativeSetPath(int i, int j, int k);

    private static native boolean nativeSetRect(int i, int j, int k, int l, int i1);

    private static native boolean nativeSetRegion(int i, int j);

    private static native String nativeToString(int i);

    private static native boolean nativeWriteToParcel(int i, Parcel parcel);

    public native boolean contains(int i, int j);

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(obj == null || !(obj instanceof Region)) {
            flag = false;
        } else {
            Region region = (Region)obj;
            flag = nativeEquals(mNativeRegion, region.mNativeRegion);
        }
        return flag;
    }

    protected void finalize() throws Throwable {
        nativeDestructor(mNativeRegion);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public Path getBoundaryPath() {
        Path path = new Path();
        nativeGetBoundaryPath(mNativeRegion, path.ni());
        return path;
    }

    public boolean getBoundaryPath(Path path) {
        return nativeGetBoundaryPath(mNativeRegion, path.ni());
    }

    public Rect getBounds() {
        Rect rect = new Rect();
        nativeGetBounds(mNativeRegion, rect);
        return rect;
    }

    public boolean getBounds(Rect rect) {
        if(rect == null)
            throw new NullPointerException();
        else
            return nativeGetBounds(mNativeRegion, rect);
    }

    public native boolean isComplex();

    public native boolean isEmpty();

    public native boolean isRect();

    final int ni() {
        return mNativeRegion;
    }

    public boolean op(int i, int j, int k, int l, Op op1) {
        return nativeOp(mNativeRegion, i, j, k, l, op1.nativeInt);
    }

    public boolean op(Rect rect, Op op1) {
        return nativeOp(mNativeRegion, rect.left, rect.top, rect.right, rect.bottom, op1.nativeInt);
    }

    public boolean op(Rect rect, Region region, Op op1) {
        return nativeOp(mNativeRegion, rect, region.mNativeRegion, op1.nativeInt);
    }

    public boolean op(Region region, Op op1) {
        return op(this, region, op1);
    }

    public boolean op(Region region, Region region1, Op op1) {
        return nativeOp(mNativeRegion, region.mNativeRegion, region1.mNativeRegion, op1.nativeInt);
    }

    public native boolean quickContains(int i, int j, int k, int l);

    public boolean quickContains(Rect rect) {
        return quickContains(rect.left, rect.top, rect.right, rect.bottom);
    }

    public native boolean quickReject(int i, int j, int k, int l);

    public boolean quickReject(Rect rect) {
        return quickReject(rect.left, rect.top, rect.right, rect.bottom);
    }

    public native boolean quickReject(Region region);

    public void scale(float f) {
        scale(f, null);
    }

    public native void scale(float f, Region region);

    public boolean set(int i, int j, int k, int l) {
        return nativeSetRect(mNativeRegion, i, j, k, l);
    }

    public boolean set(Rect rect) {
        return nativeSetRect(mNativeRegion, rect.left, rect.top, rect.right, rect.bottom);
    }

    public boolean set(Region region) {
        return nativeSetRegion(mNativeRegion, region.mNativeRegion);
    }

    public void setEmpty() {
        nativeSetRect(mNativeRegion, 0, 0, 0, 0);
    }

    public boolean setPath(Path path, Region region) {
        return nativeSetPath(mNativeRegion, path.ni(), region.mNativeRegion);
    }

    public String toString() {
        return nativeToString(mNativeRegion);
    }

    public void translate(int i, int j) {
        translate(i, j, null);
    }

    public native void translate(int i, int j, Region region);

    public final boolean union(Rect rect) {
        return op(rect, Op.UNION);
    }

    public void writeToParcel(Parcel parcel, int i) {
        if(!nativeWriteToParcel(mNativeRegion, parcel))
            throw new RuntimeException();
        else
            return;
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Region createFromParcel(Parcel parcel) {
            int i = Region.nativeCreateFromParcel(parcel);
            if(i == 0)
                throw new RuntimeException();
            else
                return new Region(i);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Region[] newArray(int i) {
            return new Region[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public final int mNativeRegion;


}
