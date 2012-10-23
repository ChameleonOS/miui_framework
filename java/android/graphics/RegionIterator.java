// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;


// Referenced classes of package android.graphics:
//            Region, Rect

public class RegionIterator {

    public RegionIterator(Region region) {
        mNativeIter = nativeConstructor(region.ni());
    }

    private static native int nativeConstructor(int i);

    private static native void nativeDestructor(int i);

    private static native boolean nativeNext(int i, Rect rect);

    protected void finalize() throws Throwable {
        nativeDestructor(mNativeIter);
    }

    public final boolean next(Rect rect) {
        if(rect == null)
            throw new NullPointerException("The Rect must be provided");
        else
            return nativeNext(mNativeIter, rect);
    }

    private final int mNativeIter;
}
