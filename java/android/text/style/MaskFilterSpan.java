// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.graphics.MaskFilter;
import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            CharacterStyle, UpdateAppearance

public class MaskFilterSpan extends CharacterStyle
    implements UpdateAppearance {

    public MaskFilterSpan(MaskFilter maskfilter) {
        mFilter = maskfilter;
    }

    public MaskFilter getMaskFilter() {
        return mFilter;
    }

    public void updateDrawState(TextPaint textpaint) {
        textpaint.setMaskFilter(mFilter);
    }

    private MaskFilter mFilter;
}
