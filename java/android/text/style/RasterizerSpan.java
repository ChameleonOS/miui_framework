// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.graphics.Rasterizer;
import android.text.TextPaint;

// Referenced classes of package android.text.style:
//            CharacterStyle, UpdateAppearance

public class RasterizerSpan extends CharacterStyle
    implements UpdateAppearance {

    public RasterizerSpan(Rasterizer rasterizer) {
        mRasterizer = rasterizer;
    }

    public Rasterizer getRasterizer() {
        return mRasterizer;
    }

    public void updateDrawState(TextPaint textpaint) {
        textpaint.setRasterizer(mRasterizer);
    }

    private Rasterizer mRasterizer;
}
