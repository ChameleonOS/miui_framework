// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;


// Referenced classes of package android.renderscript:
//            BaseObj, RenderScript

public class ProgramStore extends BaseObj {
    public static class Builder {

        public ProgramStore create() {
            mRS.validate();
            ProgramStore programstore = new ProgramStore(mRS.nProgramStoreCreate(mColorMaskR, mColorMaskG, mColorMaskB, mColorMaskA, mDepthMask, mDither, mBlendSrc.mID, mBlendDst.mID, mDepthFunc.mID), mRS);
            programstore.mDepthFunc = mDepthFunc;
            programstore.mDepthMask = mDepthMask;
            programstore.mColorMaskR = mColorMaskR;
            programstore.mColorMaskG = mColorMaskG;
            programstore.mColorMaskB = mColorMaskB;
            programstore.mColorMaskA = mColorMaskA;
            programstore.mBlendSrc = mBlendSrc;
            programstore.mBlendDst = mBlendDst;
            programstore.mDither = mDither;
            return programstore;
        }

        public Builder setBlendFunc(BlendSrcFunc blendsrcfunc, BlendDstFunc blenddstfunc) {
            mBlendSrc = blendsrcfunc;
            mBlendDst = blenddstfunc;
            return this;
        }

        public Builder setColorMaskEnabled(boolean flag, boolean flag1, boolean flag2, boolean flag3) {
            mColorMaskR = flag;
            mColorMaskG = flag1;
            mColorMaskB = flag2;
            mColorMaskA = flag3;
            return this;
        }

        public Builder setDepthFunc(DepthFunc depthfunc) {
            mDepthFunc = depthfunc;
            return this;
        }

        public Builder setDepthMaskEnabled(boolean flag) {
            mDepthMask = flag;
            return this;
        }

        public Builder setDitherEnabled(boolean flag) {
            mDither = flag;
            return this;
        }

        BlendDstFunc mBlendDst;
        BlendSrcFunc mBlendSrc;
        boolean mColorMaskA;
        boolean mColorMaskB;
        boolean mColorMaskG;
        boolean mColorMaskR;
        DepthFunc mDepthFunc;
        boolean mDepthMask;
        boolean mDither;
        RenderScript mRS;

        public Builder(RenderScript renderscript) {
            mRS = renderscript;
            mDepthFunc = DepthFunc.ALWAYS;
            mDepthMask = false;
            mColorMaskR = true;
            mColorMaskG = true;
            mColorMaskB = true;
            mColorMaskA = true;
            mBlendSrc = BlendSrcFunc.ONE;
            mBlendDst = BlendDstFunc.ZERO;
        }
    }

    public static final class BlendDstFunc extends Enum {

        public static BlendDstFunc valueOf(String s) {
            return (BlendDstFunc)Enum.valueOf(android/renderscript/ProgramStore$BlendDstFunc, s);
        }

        public static BlendDstFunc[] values() {
            return (BlendDstFunc[])$VALUES.clone();
        }

        private static final BlendDstFunc $VALUES[];
        public static final BlendDstFunc DST_ALPHA;
        public static final BlendDstFunc ONE;
        public static final BlendDstFunc ONE_MINUS_DST_ALPHA;
        public static final BlendDstFunc ONE_MINUS_SRC_ALPHA;
        public static final BlendDstFunc ONE_MINUS_SRC_COLOR;
        public static final BlendDstFunc SRC_ALPHA;
        public static final BlendDstFunc SRC_COLOR;
        public static final BlendDstFunc ZERO;
        int mID;

        static  {
            ZERO = new BlendDstFunc("ZERO", 0, 0);
            ONE = new BlendDstFunc("ONE", 1, 1);
            SRC_COLOR = new BlendDstFunc("SRC_COLOR", 2, 2);
            ONE_MINUS_SRC_COLOR = new BlendDstFunc("ONE_MINUS_SRC_COLOR", 3, 3);
            SRC_ALPHA = new BlendDstFunc("SRC_ALPHA", 4, 4);
            ONE_MINUS_SRC_ALPHA = new BlendDstFunc("ONE_MINUS_SRC_ALPHA", 5, 5);
            DST_ALPHA = new BlendDstFunc("DST_ALPHA", 6, 6);
            ONE_MINUS_DST_ALPHA = new BlendDstFunc("ONE_MINUS_DST_ALPHA", 7, 7);
            BlendDstFunc ablenddstfunc[] = new BlendDstFunc[8];
            ablenddstfunc[0] = ZERO;
            ablenddstfunc[1] = ONE;
            ablenddstfunc[2] = SRC_COLOR;
            ablenddstfunc[3] = ONE_MINUS_SRC_COLOR;
            ablenddstfunc[4] = SRC_ALPHA;
            ablenddstfunc[5] = ONE_MINUS_SRC_ALPHA;
            ablenddstfunc[6] = DST_ALPHA;
            ablenddstfunc[7] = ONE_MINUS_DST_ALPHA;
            $VALUES = ablenddstfunc;
        }

        private BlendDstFunc(String s, int i, int j) {
            super(s, i);
            mID = j;
        }
    }

    public static final class BlendSrcFunc extends Enum {

        public static BlendSrcFunc valueOf(String s) {
            return (BlendSrcFunc)Enum.valueOf(android/renderscript/ProgramStore$BlendSrcFunc, s);
        }

        public static BlendSrcFunc[] values() {
            return (BlendSrcFunc[])$VALUES.clone();
        }

        private static final BlendSrcFunc $VALUES[];
        public static final BlendSrcFunc DST_ALPHA;
        public static final BlendSrcFunc DST_COLOR;
        public static final BlendSrcFunc ONE;
        public static final BlendSrcFunc ONE_MINUS_DST_ALPHA;
        public static final BlendSrcFunc ONE_MINUS_DST_COLOR;
        public static final BlendSrcFunc ONE_MINUS_SRC_ALPHA;
        public static final BlendSrcFunc SRC_ALPHA;
        public static final BlendSrcFunc SRC_ALPHA_SATURATE;
        public static final BlendSrcFunc ZERO;
        int mID;

        static  {
            ZERO = new BlendSrcFunc("ZERO", 0, 0);
            ONE = new BlendSrcFunc("ONE", 1, 1);
            DST_COLOR = new BlendSrcFunc("DST_COLOR", 2, 2);
            ONE_MINUS_DST_COLOR = new BlendSrcFunc("ONE_MINUS_DST_COLOR", 3, 3);
            SRC_ALPHA = new BlendSrcFunc("SRC_ALPHA", 4, 4);
            ONE_MINUS_SRC_ALPHA = new BlendSrcFunc("ONE_MINUS_SRC_ALPHA", 5, 5);
            DST_ALPHA = new BlendSrcFunc("DST_ALPHA", 6, 6);
            ONE_MINUS_DST_ALPHA = new BlendSrcFunc("ONE_MINUS_DST_ALPHA", 7, 7);
            SRC_ALPHA_SATURATE = new BlendSrcFunc("SRC_ALPHA_SATURATE", 8, 8);
            BlendSrcFunc ablendsrcfunc[] = new BlendSrcFunc[9];
            ablendsrcfunc[0] = ZERO;
            ablendsrcfunc[1] = ONE;
            ablendsrcfunc[2] = DST_COLOR;
            ablendsrcfunc[3] = ONE_MINUS_DST_COLOR;
            ablendsrcfunc[4] = SRC_ALPHA;
            ablendsrcfunc[5] = ONE_MINUS_SRC_ALPHA;
            ablendsrcfunc[6] = DST_ALPHA;
            ablendsrcfunc[7] = ONE_MINUS_DST_ALPHA;
            ablendsrcfunc[8] = SRC_ALPHA_SATURATE;
            $VALUES = ablendsrcfunc;
        }

        private BlendSrcFunc(String s, int i, int j) {
            super(s, i);
            mID = j;
        }
    }

    public static final class DepthFunc extends Enum {

        public static DepthFunc valueOf(String s) {
            return (DepthFunc)Enum.valueOf(android/renderscript/ProgramStore$DepthFunc, s);
        }

        public static DepthFunc[] values() {
            return (DepthFunc[])$VALUES.clone();
        }

        private static final DepthFunc $VALUES[];
        public static final DepthFunc ALWAYS;
        public static final DepthFunc EQUAL;
        public static final DepthFunc GREATER;
        public static final DepthFunc GREATER_OR_EQUAL;
        public static final DepthFunc LESS;
        public static final DepthFunc LESS_OR_EQUAL;
        public static final DepthFunc NOT_EQUAL;
        int mID;

        static  {
            ALWAYS = new DepthFunc("ALWAYS", 0, 0);
            LESS = new DepthFunc("LESS", 1, 1);
            LESS_OR_EQUAL = new DepthFunc("LESS_OR_EQUAL", 2, 2);
            GREATER = new DepthFunc("GREATER", 3, 3);
            GREATER_OR_EQUAL = new DepthFunc("GREATER_OR_EQUAL", 4, 4);
            EQUAL = new DepthFunc("EQUAL", 5, 5);
            NOT_EQUAL = new DepthFunc("NOT_EQUAL", 6, 6);
            DepthFunc adepthfunc[] = new DepthFunc[7];
            adepthfunc[0] = ALWAYS;
            adepthfunc[1] = LESS;
            adepthfunc[2] = LESS_OR_EQUAL;
            adepthfunc[3] = GREATER;
            adepthfunc[4] = GREATER_OR_EQUAL;
            adepthfunc[5] = EQUAL;
            adepthfunc[6] = NOT_EQUAL;
            $VALUES = adepthfunc;
        }

        private DepthFunc(String s, int i, int j) {
            super(s, i);
            mID = j;
        }
    }


    ProgramStore(int i, RenderScript renderscript) {
        super(i, renderscript);
    }

    public static ProgramStore BLEND_ALPHA_DEPTH_NONE(RenderScript renderscript) {
        if(renderscript.mProgramStore_BLEND_ALPHA_DEPTH_NO_DEPTH == null) {
            Builder builder = new Builder(renderscript);
            builder.setDepthFunc(DepthFunc.ALWAYS);
            builder.setBlendFunc(BlendSrcFunc.SRC_ALPHA, BlendDstFunc.ONE_MINUS_SRC_ALPHA);
            builder.setDitherEnabled(false);
            builder.setDepthMaskEnabled(false);
            renderscript.mProgramStore_BLEND_ALPHA_DEPTH_NO_DEPTH = builder.create();
        }
        return renderscript.mProgramStore_BLEND_ALPHA_DEPTH_NO_DEPTH;
    }

    public static ProgramStore BLEND_ALPHA_DEPTH_TEST(RenderScript renderscript) {
        if(renderscript.mProgramStore_BLEND_ALPHA_DEPTH_TEST == null) {
            Builder builder = new Builder(renderscript);
            builder.setDepthFunc(DepthFunc.LESS);
            builder.setBlendFunc(BlendSrcFunc.SRC_ALPHA, BlendDstFunc.ONE_MINUS_SRC_ALPHA);
            builder.setDitherEnabled(false);
            builder.setDepthMaskEnabled(true);
            renderscript.mProgramStore_BLEND_ALPHA_DEPTH_TEST = builder.create();
        }
        return renderscript.mProgramStore_BLEND_ALPHA_DEPTH_TEST;
    }

    public static ProgramStore BLEND_NONE_DEPTH_NONE(RenderScript renderscript) {
        if(renderscript.mProgramStore_BLEND_NONE_DEPTH_NO_DEPTH == null) {
            Builder builder = new Builder(renderscript);
            builder.setDepthFunc(DepthFunc.ALWAYS);
            builder.setBlendFunc(BlendSrcFunc.ONE, BlendDstFunc.ZERO);
            builder.setDitherEnabled(false);
            builder.setDepthMaskEnabled(false);
            renderscript.mProgramStore_BLEND_NONE_DEPTH_NO_DEPTH = builder.create();
        }
        return renderscript.mProgramStore_BLEND_NONE_DEPTH_NO_DEPTH;
    }

    public static ProgramStore BLEND_NONE_DEPTH_TEST(RenderScript renderscript) {
        if(renderscript.mProgramStore_BLEND_NONE_DEPTH_TEST == null) {
            Builder builder = new Builder(renderscript);
            builder.setDepthFunc(DepthFunc.LESS);
            builder.setBlendFunc(BlendSrcFunc.ONE, BlendDstFunc.ZERO);
            builder.setDitherEnabled(false);
            builder.setDepthMaskEnabled(true);
            renderscript.mProgramStore_BLEND_NONE_DEPTH_TEST = builder.create();
        }
        return renderscript.mProgramStore_BLEND_NONE_DEPTH_TEST;
    }

    public BlendDstFunc getBlendDstFunc() {
        return mBlendDst;
    }

    public BlendSrcFunc getBlendSrcFunc() {
        return mBlendSrc;
    }

    public DepthFunc getDepthFunc() {
        return mDepthFunc;
    }

    public boolean isColorMaskAlphaEnabled() {
        return mColorMaskA;
    }

    public boolean isColorMaskBlueEnabled() {
        return mColorMaskB;
    }

    public boolean isColorMaskGreenEnabled() {
        return mColorMaskG;
    }

    public boolean isColorMaskRedEnabled() {
        return mColorMaskR;
    }

    public boolean isDepthMaskEnabled() {
        return mDepthMask;
    }

    public boolean isDitherEnabled() {
        return mDither;
    }

    BlendDstFunc mBlendDst;
    BlendSrcFunc mBlendSrc;
    boolean mColorMaskA;
    boolean mColorMaskB;
    boolean mColorMaskG;
    boolean mColorMaskR;
    DepthFunc mDepthFunc;
    boolean mDepthMask;
    boolean mDither;
}
