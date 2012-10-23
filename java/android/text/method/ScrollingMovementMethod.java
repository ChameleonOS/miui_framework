// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import android.widget.TextView;

// Referenced classes of package android.text.method:
//            BaseMovementMethod, MovementMethod, Touch

public class ScrollingMovementMethod extends BaseMovementMethod
    implements MovementMethod {

    public ScrollingMovementMethod() {
    }

    public static MovementMethod getInstance() {
        if(sInstance == null)
            sInstance = new ScrollingMovementMethod();
        return sInstance;
    }

    protected boolean bottom(TextView textview, Spannable spannable) {
        return scrollBottom(textview, spannable);
    }

    protected boolean down(TextView textview, Spannable spannable) {
        return scrollDown(textview, spannable, 1);
    }

    protected boolean end(TextView textview, Spannable spannable) {
        return bottom(textview, spannable);
    }

    protected boolean home(TextView textview, Spannable spannable) {
        return top(textview, spannable);
    }

    protected boolean left(TextView textview, Spannable spannable) {
        return scrollLeft(textview, spannable, 1);
    }

    protected boolean lineEnd(TextView textview, Spannable spannable) {
        return scrollLineEnd(textview, spannable);
    }

    protected boolean lineStart(TextView textview, Spannable spannable) {
        return scrollLineStart(textview, spannable);
    }

    public void onTakeFocus(TextView textview, Spannable spannable, int i) {
        Layout layout = textview.getLayout();
        if(layout != null && (i & 2) != 0)
            textview.scrollTo(textview.getScrollX(), layout.getLineTop(0));
        if(layout != null && (i & 1) != 0) {
            int j = textview.getTotalPaddingTop() + textview.getTotalPaddingBottom();
            int k = -1 + layout.getLineCount();
            textview.scrollTo(textview.getScrollX(), layout.getLineTop(k + 1) - (textview.getHeight() - j));
        }
    }

    public boolean onTouchEvent(TextView textview, Spannable spannable, MotionEvent motionevent) {
        return Touch.onTouchEvent(textview, spannable, motionevent);
    }

    protected boolean pageDown(TextView textview, Spannable spannable) {
        return scrollPageDown(textview, spannable);
    }

    protected boolean pageUp(TextView textview, Spannable spannable) {
        return scrollPageUp(textview, spannable);
    }

    protected boolean right(TextView textview, Spannable spannable) {
        return scrollRight(textview, spannable, 1);
    }

    protected boolean top(TextView textview, Spannable spannable) {
        return scrollTop(textview, spannable);
    }

    protected boolean up(TextView textview, Spannable spannable) {
        return scrollUp(textview, spannable, 1);
    }

    private static ScrollingMovementMethod sInstance;
}
