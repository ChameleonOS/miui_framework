// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.graphics.Rect;
import android.text.*;
import android.view.*;
import android.widget.TextView;

// Referenced classes of package android.text.method:
//            BaseMovementMethod, MovementMethod, MetaKeyKeyListener, WordIterator, 
//            Touch

public class ArrowKeyMovementMethod extends BaseMovementMethod
    implements MovementMethod {

    public ArrowKeyMovementMethod() {
    }

    private static int getCurrentLineTop(Spannable spannable, Layout layout) {
        return layout.getLineTop(layout.getLineForOffset(Selection.getSelectionEnd(spannable)));
    }

    public static MovementMethod getInstance() {
        if(sInstance == null)
            sInstance = new ArrowKeyMovementMethod();
        return sInstance;
    }

    private static int getPageHeight(TextView textview) {
        Rect rect = new Rect();
        int i;
        if(textview.getGlobalVisibleRect(rect))
            i = rect.height();
        else
            i = 0;
        return i;
    }

    private static boolean isSelecting(Spannable spannable) {
        boolean flag = true;
        if(MetaKeyKeyListener.getMetaState(spannable, flag) != flag && MetaKeyKeyListener.getMetaState(spannable, 2048) == 0)
            flag = false;
        return flag;
    }

    protected boolean bottom(TextView textview, Spannable spannable) {
        if(isSelecting(spannable))
            Selection.extendSelection(spannable, spannable.length());
        else
            Selection.setSelection(spannable, spannable.length());
        return true;
    }

    public boolean canSelectArbitrarily() {
        return true;
    }

    protected boolean down(TextView textview, Spannable spannable) {
        Layout layout = textview.getLayout();
        boolean flag;
        if(isSelecting(spannable))
            flag = Selection.extendDown(spannable, layout);
        else
            flag = Selection.moveDown(spannable, layout);
        return flag;
    }

    protected boolean end(TextView textview, Spannable spannable) {
        return lineEnd(textview, spannable);
    }

    protected boolean handleMovementKey(TextView textview, Spannable spannable, int i, int j, KeyEvent keyevent) {
        i;
        JVM INSTR tableswitch 23 23: default 20
    //                   23 36;
           goto _L1 _L2
_L1:
        boolean flag = super.handleMovementKey(textview, spannable, i, j, keyevent);
_L4:
        return flag;
_L2:
        if(!KeyEvent.metaStateHasNoModifiers(j) || keyevent.getAction() != 0 || keyevent.getRepeatCount() != 0 || MetaKeyKeyListener.getMetaState(spannable, 2048) == 0)
            continue; /* Loop/switch isn't completed */
        flag = textview.showContextMenu();
        if(true) goto _L4; else goto _L3
_L3:
        if(true) goto _L1; else goto _L5
_L5:
    }

    protected boolean home(TextView textview, Spannable spannable) {
        return lineStart(textview, spannable);
    }

    public void initialize(TextView textview, Spannable spannable) {
        Selection.setSelection(spannable, 0);
    }

    protected boolean left(TextView textview, Spannable spannable) {
        Layout layout = textview.getLayout();
        boolean flag;
        if(isSelecting(spannable))
            flag = Selection.extendLeft(spannable, layout);
        else
            flag = Selection.moveLeft(spannable, layout);
        return flag;
    }

    protected boolean leftWord(TextView textview, Spannable spannable) {
        int i = textview.getSelectionEnd();
        WordIterator worditerator = textview.getWordIterator();
        worditerator.setCharSequence(spannable, i, i);
        return Selection.moveToPreceding(spannable, worditerator, isSelecting(spannable));
    }

    protected boolean lineEnd(TextView textview, Spannable spannable) {
        Layout layout = textview.getLayout();
        boolean flag;
        if(isSelecting(spannable))
            flag = Selection.extendToRightEdge(spannable, layout);
        else
            flag = Selection.moveToRightEdge(spannable, layout);
        return flag;
    }

    protected boolean lineStart(TextView textview, Spannable spannable) {
        Layout layout = textview.getLayout();
        boolean flag;
        if(isSelecting(spannable))
            flag = Selection.extendToLeftEdge(spannable, layout);
        else
            flag = Selection.moveToLeftEdge(spannable, layout);
        return flag;
    }

    public void onTakeFocus(TextView textview, Spannable spannable, int i) {
        if((i & 0x82) != 0) {
            if(textview.getLayout() == null)
                Selection.setSelection(spannable, spannable.length());
        } else {
            Selection.setSelection(spannable, spannable.length());
        }
    }

    public boolean onTouchEvent(TextView textview, Spannable spannable, MotionEvent motionevent) {
        int i;
        int j;
        int k;
        boolean flag;
        i = -1;
        j = -1;
        k = motionevent.getAction();
        if(k == 1) {
            i = Touch.getInitialScrollX(textview, spannable);
            j = Touch.getInitialScrollY(textview, spannable);
        }
        flag = Touch.onTouchEvent(textview, spannable, motionevent);
        if(!textview.isFocused() || textview.didTouchFocusSelect()) goto _L2; else goto _L1
_L1:
        if(k != 0) goto _L4; else goto _L3
_L3:
        if(isSelecting(spannable)) {
            int i1 = textview.getOffsetForPosition(motionevent.getX(), motionevent.getY());
            spannable.setSpan(LAST_TAP_DOWN, i1, i1, 34);
            textview.getParent().requestDisallowInterceptTouchEvent(true);
        }
_L2:
        return flag;
_L4:
        if(k == 2) {
            if(isSelecting(spannable) && flag) {
                textview.cancelLongPress();
                Selection.extendSelection(spannable, textview.getOffsetForPosition(motionevent.getX(), motionevent.getY()));
                flag = true;
            }
        } else
        if(k == 1)
            if(j >= 0 && j != textview.getScrollY() || i >= 0 && i != textview.getScrollX()) {
                textview.moveCursorToVisibleOffset();
                flag = true;
            } else {
                int l = textview.getOffsetForPosition(motionevent.getX(), motionevent.getY());
                if(isSelecting(spannable)) {
                    spannable.removeSpan(LAST_TAP_DOWN);
                    Selection.extendSelection(spannable, l);
                }
                MetaKeyKeyListener.adjustMetaAfterKeypress(spannable);
                MetaKeyKeyListener.resetLockedMeta(spannable);
                flag = true;
            }
        if(true) goto _L2; else goto _L5
_L5:
    }

    protected boolean pageDown(TextView textview, Spannable spannable) {
        Layout layout;
        boolean flag;
        int i;
        boolean flag1;
        layout = textview.getLayout();
        flag = isSelecting(spannable);
        i = getCurrentLineTop(spannable, layout) + getPageHeight(textview);
        flag1 = false;
_L3:
        int j = Selection.getSelectionEnd(spannable);
        if(flag)
            Selection.extendDown(spannable, layout);
        else
            Selection.moveDown(spannable, layout);
        if(Selection.getSelectionEnd(spannable) != j) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        flag1 = true;
        if(getCurrentLineTop(spannable, layout) < i) goto _L3; else goto _L1
    }

    protected boolean pageUp(TextView textview, Spannable spannable) {
        Layout layout;
        boolean flag;
        int i;
        boolean flag1;
        layout = textview.getLayout();
        flag = isSelecting(spannable);
        i = getCurrentLineTop(spannable, layout) - getPageHeight(textview);
        flag1 = false;
_L3:
        int j = Selection.getSelectionEnd(spannable);
        if(flag)
            Selection.extendUp(spannable, layout);
        else
            Selection.moveUp(spannable, layout);
        if(Selection.getSelectionEnd(spannable) != j) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        flag1 = true;
        if(getCurrentLineTop(spannable, layout) > i) goto _L3; else goto _L1
    }

    protected boolean right(TextView textview, Spannable spannable) {
        Layout layout = textview.getLayout();
        boolean flag;
        if(isSelecting(spannable))
            flag = Selection.extendRight(spannable, layout);
        else
            flag = Selection.moveRight(spannable, layout);
        return flag;
    }

    protected boolean rightWord(TextView textview, Spannable spannable) {
        int i = textview.getSelectionEnd();
        WordIterator worditerator = textview.getWordIterator();
        worditerator.setCharSequence(spannable, i, i);
        return Selection.moveToFollowing(spannable, worditerator, isSelecting(spannable));
    }

    protected boolean top(TextView textview, Spannable spannable) {
        if(isSelecting(spannable))
            Selection.extendSelection(spannable, 0);
        else
            Selection.setSelection(spannable, 0);
        return true;
    }

    protected boolean up(TextView textview, Spannable spannable) {
        Layout layout = textview.getLayout();
        boolean flag;
        if(isSelecting(spannable))
            flag = Selection.extendUp(spannable, layout);
        else
            flag = Selection.moveUp(spannable, layout);
        return flag;
    }

    private static final Object LAST_TAP_DOWN = new Object();
    private static ArrowKeyMovementMethod sInstance;

}
