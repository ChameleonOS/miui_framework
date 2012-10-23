// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;


// Referenced classes of package android.renderscript:
//            BaseObj, RenderScript

public class Sampler extends BaseObj {
    public static class Builder {

        public Sampler create() {
            mRS.validate();
            Sampler sampler = new Sampler(mRS.nSamplerCreate(mMag.mID, mMin.mID, mWrapS.mID, mWrapT.mID, mWrapR.mID, mAniso), mRS);
            sampler.mMin = mMin;
            sampler.mMag = mMag;
            sampler.mWrapS = mWrapS;
            sampler.mWrapT = mWrapT;
            sampler.mWrapR = mWrapR;
            sampler.mAniso = mAniso;
            return sampler;
        }

        public void setAnisotropy(float f) {
            if(f >= 0.0F) {
                mAniso = f;
                return;
            } else {
                throw new IllegalArgumentException("Invalid value");
            }
        }

        public void setMagnification(Value value) {
            if(value == Value.NEAREST || value == Value.LINEAR) {
                mMag = value;
                return;
            } else {
                throw new IllegalArgumentException("Invalid value");
            }
        }

        public void setMinification(Value value) {
            if(value == Value.NEAREST || value == Value.LINEAR || value == Value.LINEAR_MIP_LINEAR || value == Value.LINEAR_MIP_NEAREST) {
                mMin = value;
                return;
            } else {
                throw new IllegalArgumentException("Invalid value");
            }
        }

        public void setWrapS(Value value) {
            if(value == Value.WRAP || value == Value.CLAMP) {
                mWrapS = value;
                return;
            } else {
                throw new IllegalArgumentException("Invalid value");
            }
        }

        public void setWrapT(Value value) {
            if(value == Value.WRAP || value == Value.CLAMP) {
                mWrapT = value;
                return;
            } else {
                throw new IllegalArgumentException("Invalid value");
            }
        }

        float mAniso;
        Value mMag;
        Value mMin;
        RenderScript mRS;
        Value mWrapR;
        Value mWrapS;
        Value mWrapT;

        public Builder(RenderScript renderscript) {
            mRS = renderscript;
            mMin = Value.NEAREST;
            mMag = Value.NEAREST;
            mWrapS = Value.WRAP;
            mWrapT = Value.WRAP;
            mWrapR = Value.WRAP;
            mAniso = 1.0F;
        }
    }

    public static final class Value extends Enum {

        public static Value valueOf(String s) {
            return (Value)Enum.valueOf(android/renderscript/Sampler$Value, s);
        }

        public static Value[] values() {
            return (Value[])$VALUES.clone();
        }

        private static final Value $VALUES[];
        public static final Value CLAMP;
        public static final Value LINEAR;
        public static final Value LINEAR_MIP_LINEAR;
        public static final Value LINEAR_MIP_NEAREST;
        public static final Value NEAREST;
        public static final Value WRAP;
        int mID;

        static  {
            NEAREST = new Value("NEAREST", 0, 0);
            LINEAR = new Value("LINEAR", 1, 1);
            LINEAR_MIP_LINEAR = new Value("LINEAR_MIP_LINEAR", 2, 2);
            LINEAR_MIP_NEAREST = new Value("LINEAR_MIP_NEAREST", 3, 5);
            WRAP = new Value("WRAP", 4, 3);
            CLAMP = new Value("CLAMP", 5, 4);
            Value avalue[] = new Value[6];
            avalue[0] = NEAREST;
            avalue[1] = LINEAR;
            avalue[2] = LINEAR_MIP_LINEAR;
            avalue[3] = LINEAR_MIP_NEAREST;
            avalue[4] = WRAP;
            avalue[5] = CLAMP;
            $VALUES = avalue;
        }

        private Value(String s, int i, int j) {
            super(s, i);
            mID = j;
        }
    }


    Sampler(int i, RenderScript renderscript) {
        super(i, renderscript);
    }

    public static Sampler CLAMP_LINEAR(RenderScript renderscript) {
        if(renderscript.mSampler_CLAMP_LINEAR == null) {
            Builder builder = new Builder(renderscript);
            builder.setMinification(Value.LINEAR);
            builder.setMagnification(Value.LINEAR);
            builder.setWrapS(Value.CLAMP);
            builder.setWrapT(Value.CLAMP);
            renderscript.mSampler_CLAMP_LINEAR = builder.create();
        }
        return renderscript.mSampler_CLAMP_LINEAR;
    }

    public static Sampler CLAMP_LINEAR_MIP_LINEAR(RenderScript renderscript) {
        if(renderscript.mSampler_CLAMP_LINEAR_MIP_LINEAR == null) {
            Builder builder = new Builder(renderscript);
            builder.setMinification(Value.LINEAR_MIP_LINEAR);
            builder.setMagnification(Value.LINEAR);
            builder.setWrapS(Value.CLAMP);
            builder.setWrapT(Value.CLAMP);
            renderscript.mSampler_CLAMP_LINEAR_MIP_LINEAR = builder.create();
        }
        return renderscript.mSampler_CLAMP_LINEAR_MIP_LINEAR;
    }

    public static Sampler CLAMP_NEAREST(RenderScript renderscript) {
        if(renderscript.mSampler_CLAMP_NEAREST == null) {
            Builder builder = new Builder(renderscript);
            builder.setMinification(Value.NEAREST);
            builder.setMagnification(Value.NEAREST);
            builder.setWrapS(Value.CLAMP);
            builder.setWrapT(Value.CLAMP);
            renderscript.mSampler_CLAMP_NEAREST = builder.create();
        }
        return renderscript.mSampler_CLAMP_NEAREST;
    }

    public static Sampler WRAP_LINEAR(RenderScript renderscript) {
        if(renderscript.mSampler_WRAP_LINEAR == null) {
            Builder builder = new Builder(renderscript);
            builder.setMinification(Value.LINEAR);
            builder.setMagnification(Value.LINEAR);
            builder.setWrapS(Value.WRAP);
            builder.setWrapT(Value.WRAP);
            renderscript.mSampler_WRAP_LINEAR = builder.create();
        }
        return renderscript.mSampler_WRAP_LINEAR;
    }

    public static Sampler WRAP_LINEAR_MIP_LINEAR(RenderScript renderscript) {
        if(renderscript.mSampler_WRAP_LINEAR_MIP_LINEAR == null) {
            Builder builder = new Builder(renderscript);
            builder.setMinification(Value.LINEAR_MIP_LINEAR);
            builder.setMagnification(Value.LINEAR);
            builder.setWrapS(Value.WRAP);
            builder.setWrapT(Value.WRAP);
            renderscript.mSampler_WRAP_LINEAR_MIP_LINEAR = builder.create();
        }
        return renderscript.mSampler_WRAP_LINEAR_MIP_LINEAR;
    }

    public static Sampler WRAP_NEAREST(RenderScript renderscript) {
        if(renderscript.mSampler_WRAP_NEAREST == null) {
            Builder builder = new Builder(renderscript);
            builder.setMinification(Value.NEAREST);
            builder.setMagnification(Value.NEAREST);
            builder.setWrapS(Value.WRAP);
            builder.setWrapT(Value.WRAP);
            renderscript.mSampler_WRAP_NEAREST = builder.create();
        }
        return renderscript.mSampler_WRAP_NEAREST;
    }

    public float getAnisotropy() {
        return mAniso;
    }

    public Value getMagnification() {
        return mMag;
    }

    public Value getMinification() {
        return mMin;
    }

    public Value getWrapS() {
        return mWrapS;
    }

    public Value getWrapT() {
        return mWrapT;
    }

    float mAniso;
    Value mMag;
    Value mMin;
    Value mWrapR;
    Value mWrapS;
    Value mWrapT;
}
