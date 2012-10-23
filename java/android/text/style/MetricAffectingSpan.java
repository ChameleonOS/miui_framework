// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            CharacterStyle, UpdateLayout

public abstract class MetricAffectingSpan extends CharacterStyle
    implements UpdateLayout {
    static class Passthrough extends MetricAffectingSpan {

        public volatile CharacterStyle getUnderlying() {
            return getUnderlying();
        }

        public MetricAffectingSpan getUnderlying() {
            return mStyle.getUnderlying();
        }

        public void updateDrawState(TextPaint textpaint) {
            mStyle.updateDrawState(textpaint);
        }

        public void updateMeasureState(TextPaint textpaint) {
            mStyle.updateMeasureState(textpaint);
        }

        private MetricAffectingSpan mStyle;

        public Passthrough(MetricAffectingSpan metricaffectingspan) {
            mStyle = metricaffectingspan;
        }
    }


    public MetricAffectingSpan() {
    }

    public volatile CharacterStyle getUnderlying() {
        return getUnderlying();
    }

    public MetricAffectingSpan getUnderlying() {
        return this;
    }

    public abstract void updateMeasureState(TextPaint textpaint);
}
