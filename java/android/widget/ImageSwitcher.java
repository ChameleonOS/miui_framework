// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            ViewSwitcher, ImageView

public class ImageSwitcher extends ViewSwitcher {

    public ImageSwitcher(Context context) {
        super(context);
    }

    public ImageSwitcher(Context context, AttributeSet attributeset) {
        super(context, attributeset);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/ImageSwitcher.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/ImageSwitcher.getName());
    }

    public void setImageDrawable(Drawable drawable) {
        ((ImageView)getNextView()).setImageDrawable(drawable);
        showNext();
    }

    public void setImageResource(int i) {
        ((ImageView)getNextView()).setImageResource(i);
        showNext();
    }

    public void setImageURI(Uri uri) {
        ((ImageView)getNextView()).setImageURI(uri);
        showNext();
    }
}
