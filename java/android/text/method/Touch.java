// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.text.*;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

// Referenced classes of package android.text.method:
//            MetaKeyKeyListener

public class Touch {
    private static class DragState
        implements NoCopySpan {

        public boolean mFarEnough;
        public int mScrollX;
        public int mScrollY;
        public boolean mUsed;
        public float mX;
        public float mY;

        public DragState(float f, float f1, int i, int j) {
            mX = f;
            mY = f1;
            mScrollX = i;
            mScrollY = j;
        }
    }


    private Touch() {
    }

    public static int getInitialScrollX(TextView textview, Spannable spannable) {
        DragState adragstate[] = (DragState[])spannable.getSpans(0, spannable.length(), android/text/method/Touch$DragState);
        int i;
        if(adragstate.length > 0)
            i = adragstate[0].mScrollX;
        else
            i = -1;
        return i;
    }

    public static int getInitialScrollY(TextView textview, Spannable spannable) {
        DragState adragstate[] = (DragState[])spannable.getSpans(0, spannable.length(), android/text/method/Touch$DragState);
        int i;
        if(adragstate.length > 0)
            i = adragstate[0].mScrollY;
        else
            i = -1;
        return i;
    }

    public static boolean onTouchEvent(TextView textview, Spannable spannable, MotionEvent motionevent) {
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 38
    //                   1 125
    //                   2 201;
           goto _L1 _L2 _L3 _L4
_L1:
        boolean flag1 = false;
_L5:
        return flag1;
_L2:
        DragState adragstate2[] = (DragState[])spannable.getSpans(0, spannable.length(), android/text/method/Touch$DragState);
        for(int i2 = 0; i2 < adragstate2.length; i2++)
            spannable.removeSpan(adragstate2[i2]);

        spannable.setSpan(new DragState(motionevent.getX(), motionevent.getY(), textview.getScrollX(), textview.getScrollY()), 0, 0, 17);
        flag1 = true;
          goto _L5
_L3:
        DragState adragstate1[] = (DragState[])spannable.getSpans(0, spannable.length(), android/text/method/Touch$DragState);
        for(int l1 = 0; l1 < adragstate1.length; l1++)
            spannable.removeSpan(adragstate1[l1]);

        if(adragstate1.length > 0 && adragstate1[0].mUsed)
            flag1 = true;
        else
            flag1 = false;
          goto _L5
_L4:
        DragState adragstate[] = (DragState[])spannable.getSpans(0, spannable.length(), android/text/method/Touch$DragState);
        if(adragstate.length <= 0) goto _L1; else goto _L6
_L6:
        if(!adragstate[0].mFarEnough) {
            int k1 = ViewConfiguration.get(textview.getContext()).getScaledTouchSlop();
            if(Math.abs(motionevent.getX() - adragstate[0].mX) >= (float)k1 || Math.abs(motionevent.getY() - adragstate[0].mY) >= (float)k1)
                adragstate[0].mFarEnough = true;
        }
        if(!adragstate[0].mFarEnough) goto _L1; else goto _L7
_L7:
        adragstate[0].mUsed = true;
        boolean flag;
        float f;
        float f1;
        int i;
        int j;
        int k;
        Layout layout;
        int l;
        int i1;
        int j1;
        if((1 & motionevent.getMetaState()) != 0 || MetaKeyKeyListener.getMetaState(spannable, 1) == 1 || MetaKeyKeyListener.getMetaState(spannable, 2048) != 0)
            flag = true;
        else
            flag = false;
        if(flag) {
            f = motionevent.getX() - adragstate[0].mX;
            f1 = motionevent.getY() - adragstate[0].mY;
        } else {
            f = adragstate[0].mX - motionevent.getX();
            f1 = adragstate[0].mY - motionevent.getY();
        }
        adragstate[0].mX = motionevent.getX();
        adragstate[0].mY = motionevent.getY();
        i = textview.getScrollX() + (int)f;
        j = textview.getScrollY() + (int)f1;
        k = textview.getTotalPaddingTop() + textview.getTotalPaddingBottom();
        layout = textview.getLayout();
        l = Math.max(Math.min(j, layout.getHeight() - (textview.getHeight() - k)), 0);
        i1 = textview.getScrollX();
        j1 = textview.getScrollY();
        scrollTo(textview, layout, i, l);
        if(i1 != textview.getScrollX() || j1 != textview.getScrollY())
            textview.cancelLongPress();
        flag1 = true;
          goto _L5
    }

    public static void scrollTo(TextView textview, Layout layout, int i, int j) {
        int k = textview.getTotalPaddingLeft() + textview.getTotalPaddingRight();
        int l = textview.getWidth() - k;
        int i1 = layout.getLineForVertical(j);
        android.text.Layout.Alignment alignment = layout.getParagraphAlignment(i1);
        boolean flag;
        int j1;
        int k1;
        if(layout.getParagraphDirection(i1) > 0)
            flag = true;
        else
            flag = false;
        if(textview.getHorizontallyScrolling()) {
            int j2 = textview.getTotalPaddingTop() + textview.getTotalPaddingBottom();
            int k2 = layout.getLineForVertical((j + textview.getHeight()) - j2);
            j1 = 0x7fffffff;
            k1 = 0;
            for(int l2 = i1; l2 <= k2; l2++) {
                j1 = (int)Math.min(j1, layout.getLineLeft(l2));
                k1 = (int)Math.max(k1, layout.getLineRight(l2));
            }

        } else {
            j1 = 0;
            k1 = l;
        }
        int l1 = k1 - j1;
        int i2;
        if(l1 < l) {
            if(alignment == android.text.Layout.Alignment.ALIGN_CENTER)
                i2 = j1 - (l - l1) / 2;
            else
            if(flag && alignment == android.text.Layout.Alignment.ALIGN_OPPOSITE || alignment == android.text.Layout.Alignment.ALIGN_RIGHT)
                i2 = j1 - (l - l1);
            else
                i2 = j1;
        } else {
            i2 = Math.max(Math.min(i, k1 - l), j1);
        }
        textview.scrollTo(i2, j);
    }
}
