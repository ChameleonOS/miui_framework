// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class LinearLayoutWithDefaultTouchRecepient extends LinearLayout {

    public LinearLayoutWithDefaultTouchRecepient(Context context) {
        super(context);
        mTempRect = new Rect();
    }

    public LinearLayoutWithDefaultTouchRecepient(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mTempRect = new Rect();
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent) {
        boolean flag;
        if(mDefaultTouchRecepient == null)
            flag = super.dispatchTouchEvent(motionevent);
        else
        if(super.dispatchTouchEvent(motionevent)) {
            flag = true;
        } else {
            mTempRect.set(0, 0, 0, 0);
            offsetRectIntoDescendantCoords(mDefaultTouchRecepient, mTempRect);
            motionevent.setLocation(motionevent.getX() + (float)mTempRect.left, motionevent.getY() + (float)mTempRect.top);
            flag = mDefaultTouchRecepient.dispatchTouchEvent(motionevent);
        }
        return flag;
    }

    public void setDefaultTouchRecepient(View view) {
        mDefaultTouchRecepient = view;
    }

    private View mDefaultTouchRecepient;
    private final Rect mTempRect;
}
