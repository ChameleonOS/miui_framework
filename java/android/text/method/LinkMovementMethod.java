// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.text.*;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

// Referenced classes of package android.text.method:
//            ScrollingMovementMethod, MovementMethod

public class LinkMovementMethod extends ScrollingMovementMethod {

    public LinkMovementMethod() {
    }

    private boolean action(int i, TextView textview, Spannable spannable) {
        ClickableSpan aclickablespan[];
        int k2;
        int l2;
        Layout layout = textview.getLayout();
        int j = textview.getTotalPaddingTop() + textview.getTotalPaddingBottom();
        int k = textview.getScrollY();
        int l = (k + textview.getHeight()) - j;
        int i1 = layout.getLineForVertical(k);
        int j1 = layout.getLineForVertical(l);
        int k1 = layout.getLineStart(i1);
        int l1 = layout.getLineEnd(j1);
        aclickablespan = (ClickableSpan[])spannable.getSpans(k1, l1, android/text/style/ClickableSpan);
        int i2 = Selection.getSelectionStart(spannable);
        int j2 = Selection.getSelectionEnd(spannable);
        k2 = Math.min(i2, j2);
        l2 = Math.max(i2, j2);
        if(k2 < 0 && spannable.getSpanStart(FROM_BELOW) >= 0) {
            l2 = spannable.length();
            k2 = l2;
        }
        if(k2 > l1) {
            l2 = 0x7fffffff;
            k2 = l2;
        }
        if(l2 < k1) {
            l2 = -1;
            k2 = l2;
        }
        i;
        JVM INSTR tableswitch 1 3: default 204
    //                   1 210
    //                   2 264
    //                   3 359;
           goto _L1 _L2 _L3 _L4
_L1:
        boolean flag = false;
_L7:
        return flag;
_L2:
        if(k2 != l2) goto _L6; else goto _L5
_L5:
        flag = false;
          goto _L7
_L6:
        ClickableSpan aclickablespan1[] = (ClickableSpan[])spannable.getSpans(k2, l2, android/text/style/ClickableSpan);
        if(aclickablespan1.length == 1) goto _L9; else goto _L8
_L8:
        flag = false;
          goto _L7
_L9:
        aclickablespan1[0].onClick(textview);
          goto _L1
_L3:
        int i4;
        int j4;
        i4 = -1;
        j4 = -1;
        for(int k4 = 0; k4 < aclickablespan.length; k4++) {
            int l4 = spannable.getSpanEnd(aclickablespan[k4]);
            if((l4 < l2 || k2 == l2) && l4 > j4) {
                i4 = spannable.getSpanStart(aclickablespan[k4]);
                j4 = l4;
            }
        }

        if(i4 < 0) goto _L1; else goto _L10
_L10:
        Selection.setSelection(spannable, j4, i4);
        flag = true;
          goto _L7
_L4:
        int i3;
        int j3;
        i3 = 0x7fffffff;
        j3 = 0x7fffffff;
        for(int k3 = 0; k3 < aclickablespan.length; k3++) {
            int l3 = spannable.getSpanStart(aclickablespan[k3]);
            if((l3 > k2 || k2 == l2) && l3 < i3) {
                i3 = l3;
                j3 = spannable.getSpanEnd(aclickablespan[k3]);
            }
        }

        if(j3 >= 0x7fffffff) goto _L1; else goto _L11
_L11:
        Selection.setSelection(spannable, i3, j3);
        flag = true;
          goto _L7
    }

    public static MovementMethod getInstance() {
        if(sInstance == null)
            sInstance = new LinkMovementMethod();
        return sInstance;
    }

    protected boolean down(TextView textview, Spannable spannable) {
        boolean flag;
        if(action(3, textview, spannable))
            flag = true;
        else
            flag = super.down(textview, spannable);
        return flag;
    }

    protected boolean handleMovementKey(TextView textview, Spannable spannable, int i, int j, KeyEvent keyevent) {
        boolean flag = true;
        i;
        JVM INSTR lookupswitch 2: default 32
    //                   23: 48
    //                   66: 48;
           goto _L1 _L2 _L2
_L1:
        flag = super.handleMovementKey(textview, spannable, i, j, keyevent);
_L3:
        return flag;
_L2:
        if(!KeyEvent.metaStateHasNoModifiers(j) || keyevent.getAction() != 0 || keyevent.getRepeatCount() != 0 || !action(flag, textview, spannable)) goto _L1; else goto _L3
    }

    public void initialize(TextView textview, Spannable spannable) {
        Selection.removeSelection(spannable);
        spannable.removeSpan(FROM_BELOW);
    }

    protected boolean left(TextView textview, Spannable spannable) {
        boolean flag;
        if(action(2, textview, spannable))
            flag = true;
        else
            flag = super.left(textview, spannable);
        return flag;
    }

    public void onTakeFocus(TextView textview, Spannable spannable, int i) {
        Selection.removeSelection(spannable);
        if((i & 1) != 0)
            spannable.setSpan(FROM_BELOW, 0, 0, 34);
        else
            spannable.removeSpan(FROM_BELOW);
    }

    public boolean onTouchEvent(TextView textview, Spannable spannable, MotionEvent motionevent) {
        boolean flag;
        int i;
        flag = true;
        i = motionevent.getAction();
        if(i != flag && i != 0) goto _L2; else goto _L1
_L1:
        ClickableSpan aclickablespan[];
        int j = (int)motionevent.getX();
        int k = (int)motionevent.getY();
        int l = j - textview.getTotalPaddingLeft();
        int i1 = k - textview.getTotalPaddingTop();
        int j1 = l + textview.getScrollX();
        int k1 = i1 + textview.getScrollY();
        Layout layout = textview.getLayout();
        int l1 = layout.getOffsetForHorizontal(layout.getLineForVertical(k1), j1);
        aclickablespan = (ClickableSpan[])spannable.getSpans(l1, l1, android/text/style/ClickableSpan);
        if(aclickablespan.length == 0) goto _L4; else goto _L3
_L3:
        if(i != flag) goto _L6; else goto _L5
_L5:
        aclickablespan[0].onClick(textview);
_L8:
        return flag;
_L6:
        if(i == 0)
            Selection.setSelection(spannable, spannable.getSpanStart(aclickablespan[0]), spannable.getSpanEnd(aclickablespan[0]));
        continue; /* Loop/switch isn't completed */
_L4:
        Selection.removeSelection(spannable);
_L2:
        flag = super.onTouchEvent(textview, spannable, motionevent);
        if(true) goto _L8; else goto _L7
_L7:
    }

    protected boolean right(TextView textview, Spannable spannable) {
        boolean flag;
        if(action(3, textview, spannable))
            flag = true;
        else
            flag = super.right(textview, spannable);
        return flag;
    }

    protected boolean up(TextView textview, Spannable spannable) {
        boolean flag;
        if(action(2, textview, spannable))
            flag = true;
        else
            flag = super.up(textview, spannable);
        return flag;
    }

    private static final int CLICK = 1;
    private static final int DOWN = 3;
    private static Object FROM_BELOW = new android.text.NoCopySpan.Concrete();
    private static final int UP = 2;
    private static LinkMovementMethod sInstance;

}
