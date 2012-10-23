// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            MetricAffectingSpan

public abstract class CharacterStyle {
    private static class Passthrough extends CharacterStyle {

        public CharacterStyle getUnderlying() {
            return mStyle.getUnderlying();
        }

        public void updateDrawState(TextPaint textpaint) {
            mStyle.updateDrawState(textpaint);
        }

        private CharacterStyle mStyle;

        public Passthrough(CharacterStyle characterstyle) {
            mStyle = characterstyle;
        }
    }


    public CharacterStyle() {
    }

    public static CharacterStyle wrap(CharacterStyle characterstyle) {
        Object obj;
        if(characterstyle instanceof MetricAffectingSpan)
            obj = new MetricAffectingSpan.Passthrough((MetricAffectingSpan)characterstyle);
        else
            obj = new Passthrough(characterstyle);
        return ((CharacterStyle) (obj));
    }

    public CharacterStyle getUnderlying() {
        return this;
    }

    public abstract void updateDrawState(TextPaint textpaint);
}
