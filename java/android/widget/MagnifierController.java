// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewParent;

// Referenced classes of package android.widget:
//            Editor, TextView, MiuiCursorController

public class MagnifierController {

    public MagnifierController(Context context, Editor editor) {
        mOffset = -1;
        Log.i("MiuiMagnifierController", "MagnifierController is created");
        mEditor = editor;
        mTextView = editor.textview();
        mShowing = false;
    }

    private void hide() {
        mShowing = false;
        if(mTextView.getParent() != null)
            mTextView.getParent().requestDisallowInterceptTouchEvent(false);
        mEditor.makeBlink();
    }

    public static boolean isMagnifierEnabled(Context context) {
        return true;
    }

    private void showMagnifier() {
        mEditor.stopBlink();
        mTextView.getContext().sendBroadcast(new Intent("android.intent.action.SHOW_MAGNIFIER"));
    }

    private void updatePosition(boolean flag) {
        int i = mTextView.getOffsetForPosition(mLongClickX, mLongClickY);
        if(i != mOffset) {
            mEditor.setTextSelection(i);
            mOffset = i;
            showMagnifier();
        }
    }

    public boolean isShowing() {
        return mShowing;
    }

    public void onParentChanged() {
        if(mShowing)
            showMagnifier();
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag;
        flag = false;
        mLongClickX = (int)motionevent.getX();
        mLongClickY = (int)motionevent.getY();
        if(!isShowing()) goto _L2; else goto _L1
_L1:
        motionevent.getActionMasked();
        JVM INSTR tableswitch 1 3: default 56
    //                   1 81
    //                   2 71
    //                   3 81;
           goto _L3 _L4 _L5 _L4
_L3:
        mEditor.getInsertionController().onHandleTouchEvent(null, motionevent);
_L2:
        return flag;
_L5:
        updatePosition(false);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L4:
        hide();
        flag = false;
        if(true) goto _L3; else goto _L6
_L6:
    }

    public void show() {
        mShowing = true;
        if(mTextView.getParent() != null)
            mTextView.getParent().requestDisallowInterceptTouchEvent(true);
        showMagnifier();
    }

    public static final String LOG_TAG = "MiuiMagnifierController";
    private final Editor mEditor;
    private int mLongClickX;
    private int mLongClickY;
    private int mOffset;
    private boolean mShowing;
    private final TextView mTextView;
}
