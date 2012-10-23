// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.animation;

import java.util.ArrayList;

// Referenced classes of package android.animation:
//            KeyframeSet, Keyframe, TimeInterpolator, TypeEvaluator

class FloatKeyframeSet extends KeyframeSet {

    public transient FloatKeyframeSet(Keyframe.FloatKeyframe afloatkeyframe[]) {
        super(afloatkeyframe);
        firstTime = true;
    }

    public FloatKeyframeSet clone() {
        ArrayList arraylist = super.mKeyframes;
        int i = super.mKeyframes.size();
        Keyframe.FloatKeyframe afloatkeyframe[] = new Keyframe.FloatKeyframe[i];
        for(int j = 0; j < i; j++)
            afloatkeyframe[j] = (Keyframe.FloatKeyframe)((Keyframe)arraylist.get(j)).clone();

        return new FloatKeyframeSet(afloatkeyframe);
    }

    public volatile KeyframeSet clone() {
        return clone();
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public float getFloatValue(float f) {
        if(super.mNumKeyframes != 2) goto _L2; else goto _L1
_L1:
        float f1;
        if(firstTime) {
            firstTime = false;
            firstValue = ((Keyframe.FloatKeyframe)super.mKeyframes.get(0)).getFloatValue();
            lastValue = ((Keyframe.FloatKeyframe)super.mKeyframes.get(1)).getFloatValue();
            deltaValue = lastValue - firstValue;
        }
        if(super.mInterpolator != null)
            f = super.mInterpolator.getInterpolation(f);
        if(super.mEvaluator == null)
            f1 = firstValue + f * deltaValue;
        else
            f1 = ((Number)super.mEvaluator.evaluate(f, Float.valueOf(firstValue), Float.valueOf(lastValue))).floatValue();
_L4:
        return f1;
_L2:
        if(f <= 0.0F) {
            Keyframe.FloatKeyframe floatkeyframe4 = (Keyframe.FloatKeyframe)super.mKeyframes.get(0);
            Keyframe.FloatKeyframe floatkeyframe5 = (Keyframe.FloatKeyframe)super.mKeyframes.get(1);
            float f10 = floatkeyframe4.getFloatValue();
            float f11 = floatkeyframe5.getFloatValue();
            float f12 = floatkeyframe4.getFraction();
            float f13 = floatkeyframe5.getFraction();
            TimeInterpolator timeinterpolator2 = floatkeyframe5.getInterpolator();
            if(timeinterpolator2 != null)
                f = timeinterpolator2.getInterpolation(f);
            float f14 = (f - f12) / (f13 - f12);
            if(super.mEvaluator == null)
                f1 = f10 + f14 * (f11 - f10);
            else
                f1 = ((Number)super.mEvaluator.evaluate(f14, Float.valueOf(f10), Float.valueOf(f11))).floatValue();
            continue; /* Loop/switch isn't completed */
        }
        if(f >= 1.0F) {
            Keyframe.FloatKeyframe floatkeyframe2 = (Keyframe.FloatKeyframe)super.mKeyframes.get(-2 + super.mNumKeyframes);
            Keyframe.FloatKeyframe floatkeyframe3 = (Keyframe.FloatKeyframe)super.mKeyframes.get(-1 + super.mNumKeyframes);
            float f5 = floatkeyframe2.getFloatValue();
            float f6 = floatkeyframe3.getFloatValue();
            float f7 = floatkeyframe2.getFraction();
            float f8 = floatkeyframe3.getFraction();
            TimeInterpolator timeinterpolator1 = floatkeyframe3.getInterpolator();
            if(timeinterpolator1 != null)
                f = timeinterpolator1.getInterpolation(f);
            float f9 = (f - f7) / (f8 - f7);
            if(super.mEvaluator == null)
                f1 = f5 + f9 * (f6 - f5);
            else
                f1 = ((Number)super.mEvaluator.evaluate(f9, Float.valueOf(f5), Float.valueOf(f6))).floatValue();
            continue; /* Loop/switch isn't completed */
        }
        Keyframe.FloatKeyframe floatkeyframe = (Keyframe.FloatKeyframe)super.mKeyframes.get(0);
        int i = 1;
        do {
            if(i >= super.mNumKeyframes)
                break;
            Keyframe.FloatKeyframe floatkeyframe1 = (Keyframe.FloatKeyframe)super.mKeyframes.get(i);
            if(f < floatkeyframe1.getFraction()) {
                TimeInterpolator timeinterpolator = floatkeyframe1.getInterpolator();
                if(timeinterpolator != null)
                    f = timeinterpolator.getInterpolation(f);
                float f2 = (f - floatkeyframe.getFraction()) / (floatkeyframe1.getFraction() - floatkeyframe.getFraction());
                float f3 = floatkeyframe.getFloatValue();
                float f4 = floatkeyframe1.getFloatValue();
                if(super.mEvaluator == null)
                    f1 = f3 + f2 * (f4 - f3);
                else
                    f1 = ((Number)super.mEvaluator.evaluate(f2, Float.valueOf(f3), Float.valueOf(f4))).floatValue();
                continue; /* Loop/switch isn't completed */
            }
            floatkeyframe = floatkeyframe1;
            i++;
        } while(true);
        f1 = ((Number)((Keyframe)super.mKeyframes.get(-1 + super.mNumKeyframes)).getValue()).floatValue();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Object getValue(float f) {
        return Float.valueOf(getFloatValue(f));
    }

    private float deltaValue;
    private boolean firstTime;
    private float firstValue;
    private float lastValue;
}
