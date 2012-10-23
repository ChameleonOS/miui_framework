// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            ViewSwitcher, TextView

public class TextSwitcher extends ViewSwitcher {

    public TextSwitcher(Context context) {
        super(context);
    }

    public TextSwitcher(Context context, AttributeSet attributeset) {
        super(context, attributeset);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams) {
        if(!(view instanceof TextView)) {
            throw new IllegalArgumentException("TextSwitcher children must be instances of TextView");
        } else {
            super.addView(view, i, layoutparams);
            return;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/TextSwitcher.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/TextSwitcher.getName());
    }

    public void setCurrentText(CharSequence charsequence) {
        ((TextView)getCurrentView()).setText(charsequence);
    }

    public void setText(CharSequence charsequence) {
        ((TextView)getNextView()).setText(charsequence);
        showNext();
    }
}
