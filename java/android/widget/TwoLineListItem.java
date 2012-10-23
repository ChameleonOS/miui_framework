// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            RelativeLayout, TextView

public class TwoLineListItem extends RelativeLayout {

    public TwoLineListItem(Context context) {
        this(context, null, 0);
    }

    public TwoLineListItem(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public TwoLineListItem(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.TwoLineListItem, i, 0).recycle();
    }

    public TextView getText1() {
        return mText1;
    }

    public TextView getText2() {
        return mText2;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        mText1 = (TextView)findViewById(0x1020014);
        mText2 = (TextView)findViewById(0x1020015);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/TwoLineListItem.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/TwoLineListItem.getName());
    }

    private TextView mText1;
    private TextView mText2;
}
