// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.text.*;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

// Referenced classes of package android.text.method:
//            MovementMethod, MetaKeyKeyListener, Touch

public class BaseMovementMethod
    implements MovementMethod {

    public BaseMovementMethod() {
    }

    private int getBottomLine(TextView textview) {
        return textview.getLayout().getLineForVertical(textview.getScrollY() + getInnerHeight(textview));
    }

    private int getCharacterWidth(TextView textview) {
        return (int)Math.ceil(textview.getPaint().getFontSpacing());
    }

    private int getInnerHeight(TextView textview) {
        return textview.getHeight() - textview.getTotalPaddingTop() - textview.getTotalPaddingBottom();
    }

    private int getInnerWidth(TextView textview) {
        return textview.getWidth() - textview.getTotalPaddingLeft() - textview.getTotalPaddingRight();
    }

    private int getScrollBoundsLeft(TextView textview) {
        Layout layout = textview.getLayout();
        int i = getTopLine(textview);
        int j = getBottomLine(textview);
        int k;
        if(i > j) {
            k = 0;
        } else {
            k = 0x7fffffff;
            int l = i;
            while(l <= j)  {
                int i1 = (int)Math.floor(layout.getLineLeft(l));
                if(i1 < k)
                    k = i1;
                l++;
            }
        }
        return k;
    }

    private int getScrollBoundsRight(TextView textview) {
        Layout layout = textview.getLayout();
        int i = getTopLine(textview);
        int j = getBottomLine(textview);
        int k;
        if(i > j) {
            k = 0;
        } else {
            k = 0x80000000;
            int l = i;
            while(l <= j)  {
                int i1 = (int)Math.ceil(layout.getLineRight(l));
                if(i1 > k)
                    k = i1;
                l++;
            }
        }
        return k;
    }

    private int getTopLine(TextView textview) {
        return textview.getLayout().getLineForVertical(textview.getScrollY());
    }

    protected boolean bottom(TextView textview, Spannable spannable) {
        return false;
    }

    public boolean canSelectArbitrarily() {
        return false;
    }

    protected boolean down(TextView textview, Spannable spannable) {
        return false;
    }

    protected boolean end(TextView textview, Spannable spannable) {
        return false;
    }

    protected int getMovementMetaState(Spannable spannable, KeyEvent keyevent) {
        return 0xffffff3e & KeyEvent.normalizeMetaState(0xfffff9ff & (keyevent.getMetaState() | MetaKeyKeyListener.getMetaState(spannable)));
    }

    protected boolean handleMovementKey(TextView textview, Spannable spannable, int i, int j, KeyEvent keyevent) {
        i;
        JVM INSTR lookupswitch 8: default 76
    //                   19: 204
    //                   20: 243
    //                   21: 82
    //                   22: 143
    //                   92: 282
    //                   93: 321
    //                   122: 360
    //                   123: 401;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        boolean flag = false;
_L10:
        return flag;
_L4:
        if(KeyEvent.metaStateHasNoModifiers(j)) {
            flag = left(textview, spannable);
        } else {
            if(!KeyEvent.metaStateHasModifiers(j, 4096))
                continue; /* Loop/switch isn't completed */
            flag = leftWord(textview, spannable);
        }
          goto _L10
        if(!KeyEvent.metaStateHasModifiers(j, 2)) goto _L1; else goto _L11
_L11:
        flag = lineStart(textview, spannable);
          goto _L10
_L5:
        if(KeyEvent.metaStateHasNoModifiers(j)) {
            flag = right(textview, spannable);
        } else {
            if(!KeyEvent.metaStateHasModifiers(j, 4096))
                continue; /* Loop/switch isn't completed */
            flag = rightWord(textview, spannable);
        }
          goto _L10
        if(!KeyEvent.metaStateHasModifiers(j, 2)) goto _L1; else goto _L12
_L12:
        flag = lineEnd(textview, spannable);
          goto _L10
_L2:
        if(!KeyEvent.metaStateHasNoModifiers(j))
            continue; /* Loop/switch isn't completed */
        flag = up(textview, spannable);
          goto _L10
        if(!KeyEvent.metaStateHasModifiers(j, 2)) goto _L1; else goto _L13
_L13:
        flag = top(textview, spannable);
          goto _L10
_L3:
        if(!KeyEvent.metaStateHasNoModifiers(j))
            continue; /* Loop/switch isn't completed */
        flag = down(textview, spannable);
          goto _L10
        if(!KeyEvent.metaStateHasModifiers(j, 2)) goto _L1; else goto _L14
_L14:
        flag = bottom(textview, spannable);
          goto _L10
_L6:
        if(!KeyEvent.metaStateHasNoModifiers(j))
            continue; /* Loop/switch isn't completed */
        flag = pageUp(textview, spannable);
          goto _L10
        if(!KeyEvent.metaStateHasModifiers(j, 2)) goto _L1; else goto _L15
_L15:
        flag = top(textview, spannable);
          goto _L10
_L7:
        if(!KeyEvent.metaStateHasNoModifiers(j))
            continue; /* Loop/switch isn't completed */
        flag = pageDown(textview, spannable);
          goto _L10
        if(!KeyEvent.metaStateHasModifiers(j, 2)) goto _L1; else goto _L16
_L16:
        flag = bottom(textview, spannable);
          goto _L10
_L8:
        if(!KeyEvent.metaStateHasNoModifiers(j))
            continue; /* Loop/switch isn't completed */
        flag = home(textview, spannable);
          goto _L10
        if(!KeyEvent.metaStateHasModifiers(j, 4096)) goto _L1; else goto _L17
_L17:
        flag = top(textview, spannable);
          goto _L10
_L9:
        if(!KeyEvent.metaStateHasNoModifiers(j))
            continue; /* Loop/switch isn't completed */
        flag = end(textview, spannable);
          goto _L10
        if(!KeyEvent.metaStateHasModifiers(j, 4096)) goto _L1; else goto _L18
_L18:
        flag = bottom(textview, spannable);
          goto _L10
    }

    protected boolean home(TextView textview, Spannable spannable) {
        return false;
    }

    public void initialize(TextView textview, Spannable spannable) {
    }

    protected boolean left(TextView textview, Spannable spannable) {
        return false;
    }

    protected boolean leftWord(TextView textview, Spannable spannable) {
        return false;
    }

    protected boolean lineEnd(TextView textview, Spannable spannable) {
        return false;
    }

    protected boolean lineStart(TextView textview, Spannable spannable) {
        return false;
    }

    public boolean onGenericMotionEvent(TextView textview, Spannable spannable, MotionEvent motionevent) {
        if((2 & motionevent.getSource()) == 0) goto _L2; else goto _L1
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 8 8: default 32
    //                   8 38;
           goto _L2 _L3
_L2:
        boolean flag = false;
_L9:
        return flag;
_L3:
        float f;
        float f1;
        if((1 & motionevent.getMetaState()) != 0) {
            f = 0.0F;
            f1 = motionevent.getAxisValue(9);
        } else {
            f = -motionevent.getAxisValue(9);
            f1 = motionevent.getAxisValue(10);
        }
        flag = false;
        if(f1 >= 0.0F) goto _L5; else goto _L4
_L4:
        flag = false | scrollLeft(textview, spannable, (int)Math.ceil(-f1));
_L7:
        if(f >= 0.0F)
            break; /* Loop/switch isn't completed */
        flag |= scrollUp(textview, spannable, (int)Math.ceil(-f));
        continue; /* Loop/switch isn't completed */
_L5:
        if(f1 > 0.0F)
            flag = false | scrollRight(textview, spannable, (int)Math.ceil(f1));
        if(true) goto _L7; else goto _L6
_L6:
        if(f > 0.0F)
            flag |= scrollDown(textview, spannable, (int)Math.ceil(f));
        if(true) goto _L9; else goto _L8
_L8:
    }

    public boolean onKeyDown(TextView textview, Spannable spannable, int i, KeyEvent keyevent) {
        boolean flag = handleMovementKey(textview, spannable, i, getMovementMetaState(spannable, keyevent), keyevent);
        if(flag) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(spannable);
            MetaKeyKeyListener.resetLockedMeta(spannable);
        }
        return flag;
    }

    public boolean onKeyOther(TextView textview, Spannable spannable, KeyEvent keyevent) {
        int i;
        int j;
        boolean flag;
        int k;
        int l;
        i = getMovementMetaState(spannable, keyevent);
        j = keyevent.getKeyCode();
        if(j == 0 || keyevent.getAction() != 2)
            break MISSING_BLOCK_LABEL_85;
        k = keyevent.getRepeatCount();
        flag = false;
        l = 0;
_L3:
        if(l < k && handleMovementKey(textview, spannable, j, i, keyevent)) goto _L2; else goto _L1
_L1:
        if(flag) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(spannable);
            MetaKeyKeyListener.resetLockedMeta(spannable);
        }
_L4:
        return flag;
_L2:
        flag = true;
        l++;
          goto _L3
        flag = false;
          goto _L4
    }

    public boolean onKeyUp(TextView textview, Spannable spannable, int i, KeyEvent keyevent) {
        return false;
    }

    public void onTakeFocus(TextView textview, Spannable spannable, int i) {
    }

    public boolean onTouchEvent(TextView textview, Spannable spannable, MotionEvent motionevent) {
        return false;
    }

    public boolean onTrackballEvent(TextView textview, Spannable spannable, MotionEvent motionevent) {
        return false;
    }

    protected boolean pageDown(TextView textview, Spannable spannable) {
        return false;
    }

    protected boolean pageUp(TextView textview, Spannable spannable) {
        return false;
    }

    protected boolean right(TextView textview, Spannable spannable) {
        return false;
    }

    protected boolean rightWord(TextView textview, Spannable spannable) {
        return false;
    }

    protected boolean scrollBottom(TextView textview, Spannable spannable) {
        Layout layout = textview.getLayout();
        int i = layout.getLineCount();
        boolean flag;
        if(getBottomLine(textview) <= i - 1) {
            Touch.scrollTo(textview, layout, textview.getScrollX(), layout.getLineTop(i) - getInnerHeight(textview));
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean scrollDown(TextView textview, Spannable spannable, int i) {
        Layout layout = textview.getLayout();
        int j = getInnerHeight(textview);
        int k = j + textview.getScrollY();
        int l = layout.getLineForVertical(k);
        if(layout.getLineTop(l + 1) < k + 1)
            l++;
        int i1 = -1 + layout.getLineCount();
        boolean flag;
        if(l <= i1) {
            int j1 = Math.min(-1 + (l + i), i1);
            Touch.scrollTo(textview, layout, textview.getScrollX(), layout.getLineTop(j1 + 1) - j);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean scrollLeft(TextView textview, Spannable spannable, int i) {
        int j = getScrollBoundsLeft(textview);
        int k = textview.getScrollX();
        boolean flag;
        if(k > j) {
            textview.scrollTo(Math.max(k - i * getCharacterWidth(textview), j), textview.getScrollY());
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean scrollLineEnd(TextView textview, Spannable spannable) {
        int i = getScrollBoundsRight(textview) - getInnerWidth(textview);
        boolean flag;
        if(textview.getScrollX() < i) {
            textview.scrollTo(i, textview.getScrollY());
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean scrollLineStart(TextView textview, Spannable spannable) {
        int i = getScrollBoundsLeft(textview);
        boolean flag;
        if(textview.getScrollX() > i) {
            textview.scrollTo(i, textview.getScrollY());
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean scrollPageDown(TextView textview, Spannable spannable) {
        Layout layout = textview.getLayout();
        int i = getInnerHeight(textview);
        int j = layout.getLineForVertical(i + (i + textview.getScrollY()));
        boolean flag;
        if(j <= -1 + layout.getLineCount()) {
            Touch.scrollTo(textview, layout, textview.getScrollX(), layout.getLineTop(j + 1) - i);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean scrollPageUp(TextView textview, Spannable spannable) {
        Layout layout = textview.getLayout();
        int i = layout.getLineForVertical(textview.getScrollY() - getInnerHeight(textview));
        boolean flag;
        if(i >= 0) {
            Touch.scrollTo(textview, layout, textview.getScrollX(), layout.getLineTop(i));
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean scrollRight(TextView textview, Spannable spannable, int i) {
        int j = getScrollBoundsRight(textview) - getInnerWidth(textview);
        int k = textview.getScrollX();
        boolean flag;
        if(k < j) {
            textview.scrollTo(Math.min(k + i * getCharacterWidth(textview), j), textview.getScrollY());
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected boolean scrollTop(TextView textview, Spannable spannable) {
        boolean flag = false;
        Layout layout = textview.getLayout();
        if(getTopLine(textview) >= 0) {
            Touch.scrollTo(textview, layout, textview.getScrollX(), layout.getLineTop(0));
            flag = true;
        }
        return flag;
    }

    protected boolean scrollUp(TextView textview, Spannable spannable, int i) {
        boolean flag = false;
        Layout layout = textview.getLayout();
        int j = textview.getScrollY();
        int k = layout.getLineForVertical(j);
        if(layout.getLineTop(k) == j)
            k--;
        if(k >= 0) {
            int l = Math.max(1 + (k - i), 0);
            Touch.scrollTo(textview, layout, textview.getScrollX(), layout.getLineTop(l));
            flag = true;
        }
        return flag;
    }

    protected boolean top(TextView textview, Spannable spannable) {
        return false;
    }

    protected boolean up(TextView textview, Spannable spannable) {
        return false;
    }
}
