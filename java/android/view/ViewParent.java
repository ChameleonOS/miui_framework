// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.view:
//            View, ContextMenu, ActionMode

public interface ViewParent {

    public abstract void bringChildToFront(View view);

    public abstract void childAccessibilityStateChanged(View view);

    public abstract void childDrawableStateChanged(View view);

    public abstract void childHasTransientStateChanged(View view, boolean flag);

    public abstract void clearChildFocus(View view);

    public abstract void createContextMenu(ContextMenu contextmenu);

    public abstract View findViewToTakeAccessibilityFocusFromHover(View view, View view1);

    public abstract View focusSearch(View view, int i);

    public abstract void focusableViewAvailable(View view);

    public abstract boolean getChildVisibleRect(View view, Rect rect, Point point);

    public abstract ViewParent getParent();

    public abstract ViewParent getParentForAccessibility();

    public abstract void invalidateChild(View view, Rect rect);

    public abstract ViewParent invalidateChildInParent(int ai[], Rect rect);

    public abstract boolean isLayoutRequested();

    public abstract void recomputeViewAttributes(View view);

    public abstract void requestChildFocus(View view, View view1);

    public abstract boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag);

    public abstract void requestDisallowInterceptTouchEvent(boolean flag);

    public abstract void requestFitSystemWindows();

    public abstract void requestLayout();

    public abstract boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityevent);

    public abstract void requestTransparentRegion(View view);

    public abstract boolean showContextMenuForChild(View view);

    public abstract ActionMode startActionModeForChild(View view, ActionMode.Callback callback);
}
