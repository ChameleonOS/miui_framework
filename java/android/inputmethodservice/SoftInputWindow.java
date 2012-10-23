// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.inputmethodservice;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.*;

class SoftInputWindow extends Dialog {

    public SoftInputWindow(Context context, int i, android.view.KeyEvent.DispatcherState dispatcherstate) {
        super(context, i);
        mDispatcherState = dispatcherstate;
        initDockWindow();
    }

    private void initDockWindow() {
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        layoutparams.type = 2011;
        layoutparams.setTitle("InputMethod");
        layoutparams.gravity = 80;
        layoutparams.width = -1;
        getWindow().setAttributes(layoutparams);
        getWindow().setFlags(264, 266);
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent) {
        getWindow().getDecorView().getHitRect(mBounds);
        boolean flag;
        if(motionevent.isWithinBoundsNoHistory(mBounds.left, mBounds.top, -1 + mBounds.right, -1 + mBounds.bottom)) {
            flag = super.dispatchTouchEvent(motionevent);
        } else {
            MotionEvent motionevent1 = motionevent.clampNoHistory(mBounds.left, mBounds.top, -1 + mBounds.right, -1 + mBounds.bottom);
            flag = super.dispatchTouchEvent(motionevent1);
            motionevent1.recycle();
        }
        return flag;
    }

    public int getSize() {
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        int i;
        if(layoutparams.gravity == 48 || layoutparams.gravity == 80)
            i = ((android.view.ViewGroup.LayoutParams) (layoutparams)).height;
        else
            i = ((android.view.ViewGroup.LayoutParams) (layoutparams)).width;
        return i;
    }

    public void onWindowFocusChanged(boolean flag) {
        super.onWindowFocusChanged(flag);
        mDispatcherState.reset();
    }

    public void setGravity(int i) {
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        boolean flag;
        boolean flag1;
        if(layoutparams.gravity == 48 || layoutparams.gravity == 80)
            flag = true;
        else
            flag = false;
        layoutparams.gravity = i;
        if(layoutparams.gravity == 48 || layoutparams.gravity == 80)
            flag1 = true;
        else
            flag1 = false;
        if(flag != flag1) {
            int j = ((android.view.ViewGroup.LayoutParams) (layoutparams)).width;
            layoutparams.width = ((android.view.ViewGroup.LayoutParams) (layoutparams)).height;
            layoutparams.height = j;
            getWindow().setAttributes(layoutparams);
        }
    }

    public void setSize(int i) {
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        if(layoutparams.gravity == 48 || layoutparams.gravity == 80) {
            layoutparams.width = -1;
            layoutparams.height = i;
        } else {
            layoutparams.width = i;
            layoutparams.height = -1;
        }
        getWindow().setAttributes(layoutparams);
    }

    public void setToken(IBinder ibinder) {
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        layoutparams.token = ibinder;
        getWindow().setAttributes(layoutparams);
    }

    private final Rect mBounds = new Rect();
    final android.view.KeyEvent.DispatcherState mDispatcherState;
}
