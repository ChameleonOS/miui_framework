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
//            ViewAnimator

public class ViewSwitcher extends ViewAnimator {
    public static interface ViewFactory {

        public abstract View makeView();
    }


    public ViewSwitcher(Context context) {
        super(context);
    }

    public ViewSwitcher(Context context, AttributeSet attributeset) {
        super(context, attributeset);
    }

    private View obtainView() {
        View view = mFactory.makeView();
        FrameLayout.LayoutParams layoutparams = (FrameLayout.LayoutParams)view.getLayoutParams();
        if(layoutparams == null)
            layoutparams = new FrameLayout.LayoutParams(-1, -2);
        addView(view, layoutparams);
        return view;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams) {
        if(getChildCount() >= 2) {
            throw new IllegalStateException("Can't add more than 2 views to a ViewSwitcher");
        } else {
            super.addView(view, i, layoutparams);
            return;
        }
    }

    public View getNextView() {
        int i;
        if(super.mWhichChild == 0)
            i = 1;
        else
            i = 0;
        return getChildAt(i);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/ViewSwitcher.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/ViewSwitcher.getName());
    }

    public void reset() {
        super.mFirstTime = true;
        View view = getChildAt(0);
        if(view != null)
            view.setVisibility(8);
        View view1 = getChildAt(1);
        if(view1 != null)
            view1.setVisibility(8);
    }

    public void setFactory(ViewFactory viewfactory) {
        mFactory = viewfactory;
        obtainView();
        obtainView();
    }

    ViewFactory mFactory;
}
