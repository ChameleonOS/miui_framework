// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class MarqueeTextView extends TextView {

    public MarqueeTextView(Context context) {
        super(context);
    }

    public MarqueeTextView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
    }

    public MarqueeTextView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
    }

    public boolean isFocused() {
        return true;
    }

    public void setEllipsize(android.text.TextUtils.TruncateAt truncateat) {
        super.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
    }
}
