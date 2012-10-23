// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;


// Referenced classes of package android.renderscript:
//            BaseObj, Allocation, RenderScript

public class Path extends BaseObj {
    public static final class Primitive extends Enum {

        public static Primitive valueOf(String s) {
            return (Primitive)Enum.valueOf(android/renderscript/Path$Primitive, s);
        }

        public static Primitive[] values() {
            return (Primitive[])$VALUES.clone();
        }

        private static final Primitive $VALUES[];
        public static final Primitive CUBIC_BEZIER;
        public static final Primitive QUADRATIC_BEZIER;
        int mID;

        static  {
            QUADRATIC_BEZIER = new Primitive("QUADRATIC_BEZIER", 0, 0);
            CUBIC_BEZIER = new Primitive("CUBIC_BEZIER", 1, 1);
            Primitive aprimitive[] = new Primitive[2];
            aprimitive[0] = QUADRATIC_BEZIER;
            aprimitive[1] = CUBIC_BEZIER;
            $VALUES = aprimitive;
        }

        private Primitive(String s, int i, int j) {
            super(s, i);
            mID = j;
        }
    }


    Path(int i, RenderScript renderscript, Primitive primitive, Allocation allocation, Allocation allocation1, float f) {
        super(i, renderscript);
        mVertexBuffer = allocation;
        mLoopBuffer = allocation1;
        mPrimitive = primitive;
        mQuality = f;
    }

    public static Path createDynamicPath(RenderScript renderscript, Primitive primitive, float f, Allocation allocation) {
        return null;
    }

    public static Path createDynamicPath(RenderScript renderscript, Primitive primitive, float f, Allocation allocation, Allocation allocation1) {
        return null;
    }

    public static Path createStaticPath(RenderScript renderscript, Primitive primitive, float f, Allocation allocation) {
        return new Path(renderscript.nPathCreate(primitive.mID, false, allocation.getID(renderscript), 0, f), renderscript, primitive, null, null, f);
    }

    public static Path createStaticPath(RenderScript renderscript, Primitive primitive, float f, Allocation allocation, Allocation allocation1) {
        return null;
    }

    public Allocation getLoopAllocation() {
        return mLoopBuffer;
    }

    public Primitive getPrimitive() {
        return mPrimitive;
    }

    public Allocation getVertexAllocation() {
        return mVertexBuffer;
    }

    void updateFromNative() {
    }

    boolean mCoverageToAlpha;
    Allocation mLoopBuffer;
    Primitive mPrimitive;
    float mQuality;
    Allocation mVertexBuffer;
}
