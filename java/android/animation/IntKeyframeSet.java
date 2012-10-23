// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.animation;

import java.util.ArrayList;

// Referenced classes of package android.animation:
//            KeyframeSet, Keyframe, TimeInterpolator, TypeEvaluator

class IntKeyframeSet extends KeyframeSet {

    public transient IntKeyframeSet(Keyframe.IntKeyframe aintkeyframe[]) {
        super(aintkeyframe);
        firstTime = true;
    }

    public IntKeyframeSet clone() {
        ArrayList arraylist = super.mKeyframes;
        int i = super.mKeyframes.size();
        Keyframe.IntKeyframe aintkeyframe[] = new Keyframe.IntKeyframe[i];
        for(int j = 0; j < i; j++)
            aintkeyframe[j] = (Keyframe.IntKeyframe)((Keyframe)arraylist.get(j)).clone();

        return new IntKeyframeSet(aintkeyframe);
    }

    public volatile KeyframeSet clone() {
        return clone();
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public int getIntValue(float f) {
        if(super.mNumKeyframes != 2) goto _L2; else goto _L1
_L1:
        int j;
        if(firstTime) {
            firstTime = false;
            firstValue = ((Keyframe.IntKeyframe)super.mKeyframes.get(0)).getIntValue();
            lastValue = ((Keyframe.IntKeyframe)super.mKeyframes.get(1)).getIntValue();
            deltaValue = lastValue - firstValue;
        }
        if(super.mInterpolator != null)
            f = super.mInterpolator.getInterpolation(f);
        if(super.mEvaluator == null)
            j = firstValue + (int)(f * (float)deltaValue);
        else
            j = ((Number)super.mEvaluator.evaluate(f, Integer.valueOf(firstValue), Integer.valueOf(lastValue))).intValue();
_L4:
        return j;
_L2:
        if(f <= 0.0F) {
            Keyframe.IntKeyframe intkeyframe4 = (Keyframe.IntKeyframe)super.mKeyframes.get(0);
            Keyframe.IntKeyframe intkeyframe5 = (Keyframe.IntKeyframe)super.mKeyframes.get(1);
            int k1 = intkeyframe4.getIntValue();
            int l1 = intkeyframe5.getIntValue();
            float f5 = intkeyframe4.getFraction();
            float f6 = intkeyframe5.getFraction();
            TimeInterpolator timeinterpolator2 = intkeyframe5.getInterpolator();
            if(timeinterpolator2 != null)
                f = timeinterpolator2.getInterpolation(f);
            float f7 = (f - f5) / (f6 - f5);
            if(super.mEvaluator == null)
                j = k1 + (int)(f7 * (float)(l1 - k1));
            else
                j = ((Number)super.mEvaluator.evaluate(f7, Integer.valueOf(k1), Integer.valueOf(l1))).intValue();
            continue; /* Loop/switch isn't completed */
        }
        if(f >= 1.0F) {
            Keyframe.IntKeyframe intkeyframe2 = (Keyframe.IntKeyframe)super.mKeyframes.get(-2 + super.mNumKeyframes);
            Keyframe.IntKeyframe intkeyframe3 = (Keyframe.IntKeyframe)super.mKeyframes.get(-1 + super.mNumKeyframes);
            int i1 = intkeyframe2.getIntValue();
            int j1 = intkeyframe3.getIntValue();
            float f2 = intkeyframe2.getFraction();
            float f3 = intkeyframe3.getFraction();
            TimeInterpolator timeinterpolator1 = intkeyframe3.getInterpolator();
            if(timeinterpolator1 != null)
                f = timeinterpolator1.getInterpolation(f);
            float f4 = (f - f2) / (f3 - f2);
            if(super.mEvaluator == null)
                j = i1 + (int)(f4 * (float)(j1 - i1));
            else
                j = ((Number)super.mEvaluator.evaluate(f4, Integer.valueOf(i1), Integer.valueOf(j1))).intValue();
            continue; /* Loop/switch isn't completed */
        }
        Keyframe.IntKeyframe intkeyframe = (Keyframe.IntKeyframe)super.mKeyframes.get(0);
        int i = 1;
        do {
            if(i >= super.mNumKeyframes)
                break;
            Keyframe.IntKeyframe intkeyframe1 = (Keyframe.IntKeyframe)super.mKeyframes.get(i);
            if(f < intkeyframe1.getFraction()) {
                TimeInterpolator timeinterpolator = intkeyframe1.getInterpolator();
                if(timeinterpolator != null)
                    f = timeinterpolator.getInterpolation(f);
                float f1 = (f - intkeyframe.getFraction()) / (intkeyframe1.getFraction() - intkeyframe.getFraction());
                int k = intkeyframe.getIntValue();
                int l = intkeyframe1.getIntValue();
                if(super.mEvaluator == null)
                    j = k + (int)(f1 * (float)(l - k));
                else
                    j = ((Number)super.mEvaluator.evaluate(f1, Integer.valueOf(k), Integer.valueOf(l))).intValue();
                continue; /* Loop/switch isn't completed */
            }
            intkeyframe = intkeyframe1;
            i++;
        } while(true);
        j = ((Number)((Keyframe)super.mKeyframes.get(-1 + super.mNumKeyframes)).getValue()).intValue();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Object getValue(float f) {
        return Integer.valueOf(getIntValue(f));
    }

    private int deltaValue;
    private boolean firstTime;
    private int firstValue;
    private int lastValue;
}
