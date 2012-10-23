// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.style;

import android.text.TextPaint;
import android.view.View;

// Referenced classes of package android.text.style:
//            CharacterStyle, UpdateAppearance

public abstract class ClickableSpan extends CharacterStyle
    implements UpdateAppearance {

    public ClickableSpan() {
    }

    public abstract void onClick(View view);

    public void updateDrawState(TextPaint textpaint) {
        textpaint.setColor(textpaint.linkColor);
        textpaint.setUnderlineText(true);
    }
}
