// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.hardware.input.InputManager;
import android.os.SystemProperties;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.*;
import java.util.ArrayList;

public class PointerLocationView extends View
    implements android.hardware.input.InputManager.InputDeviceListener {
    private static final class FasterStringBuilder {

        private int reserve(int i) {
            int j = mLength;
            int k = i + mLength;
            char ac[] = mChars;
            int l = ac.length;
            if(k > l) {
                char ac1[] = new char[l * 2];
                System.arraycopy(ac, 0, ac1, 0, j);
                mChars = ac1;
            }
            return j;
        }

        public FasterStringBuilder append(float f, int i) {
            int j = 1;
            for(int k = 0; k < i; k++)
                j *= 10;

            float f1 = (float)(Math.rint(f * (float)j) / (double)j);
            append((int)f1);
            if(i != 0) {
                append(".");
                float f2 = Math.abs(f1);
                append((int)((float)((double)f2 - Math.floor(f2)) * (float)j), i);
            }
            return this;
        }

        public FasterStringBuilder append(int i) {
            return append(i, 0);
        }

        public FasterStringBuilder append(int i, int j) {
            boolean flag;
            if(i < 0)
                flag = true;
            else
                flag = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            i = -i;
            if(i >= 0) goto _L2; else goto _L3
_L3:
            append("-2147483648");
_L5:
            return this;
_L2:
            int k = reserve(11);
            char ac[] = mChars;
            if(i == 0) {
                k + 1;
                ac[k] = '0';
                mLength = 1 + mLength;
            } else {
                if(flag) {
                    int j2 = k + 1;
                    ac[k] = '-';
                    k = j2;
                }
                int l = 0x3b9aca00;
                int i1 = 10;
                int j1 = k;
                do {
                    if(i >= l)
                        break;
                    l /= 10;
                    if(--i1 < j) {
                        int i2 = j1 + 1;
                        ac[j1] = '0';
                        j1 = i2;
                    }
                } while(true);
                do {
                    int k1 = j1;
                    int l1 = i / l;
                    i -= l1 * l;
                    l /= 10;
                    j1 = k1 + 1;
                    ac[k1] = (char)(l1 + 48);
                } while(l != 0);
                mLength = j1;
            }
            if(true) goto _L5; else goto _L4
_L4:
        }

        public FasterStringBuilder append(String s) {
            int i = s.length();
            int j = reserve(i);
            s.getChars(0, i, mChars, j);
            mLength = i + mLength;
            return this;
        }

        public FasterStringBuilder clear() {
            mLength = 0;
            return this;
        }

        public String toString() {
            return new String(mChars, 0, mLength);
        }

        private char mChars[];
        private int mLength;

        public FasterStringBuilder() {
            mChars = new char[64];
        }
    }

    public static class PointerState {

        public void addTrace(float f, float f1) {
            int i = mTraceX.length;
            if(mTraceCount == i) {
                int j = i * 2;
                float af[] = new float[j];
                System.arraycopy(mTraceX, 0, af, 0, mTraceCount);
                mTraceX = af;
                float af1[] = new float[j];
                System.arraycopy(mTraceY, 0, af1, 0, mTraceCount);
                mTraceY = af1;
            }
            mTraceX[mTraceCount] = f;
            mTraceY[mTraceCount] = f1;
            mTraceCount = 1 + mTraceCount;
        }

        public void clearTrace() {
            mTraceCount = 0;
        }

        private android.view.VelocityTracker.Estimator mAltEstimator;
        private float mAltXVelocity;
        private float mAltYVelocity;
        private android.view.MotionEvent.PointerCoords mCoords;
        private boolean mCurDown;
        private android.view.VelocityTracker.Estimator mEstimator;
        private int mToolType;
        private int mTraceCount;
        private float mTraceX[];
        private float mTraceY[];
        private float mXVelocity;
        private float mYVelocity;





/*
        static float access$1002(PointerState pointerstate, float f) {
            pointerstate.mAltYVelocity = f;
            return f;
        }

*/


/*
        static boolean access$102(PointerState pointerstate, boolean flag) {
            pointerstate.mCurDown = flag;
            return flag;
        }

*/



/*
        static int access$1102(PointerState pointerstate, int i) {
            pointerstate.mToolType = i;
            return i;
        }

*/






/*
        static float access$502(PointerState pointerstate, float f) {
            pointerstate.mXVelocity = f;
            return f;
        }

*/



/*
        static float access$602(PointerState pointerstate, float f) {
            pointerstate.mYVelocity = f;
            return f;
        }

*/





/*
        static float access$902(PointerState pointerstate, float f) {
            pointerstate.mAltXVelocity = f;
            return f;
        }

*/

        public PointerState() {
            mTraceX = new float[32];
            mTraceY = new float[32];
            mCoords = new android.view.MotionEvent.PointerCoords();
            mEstimator = new android.view.VelocityTracker.Estimator();
            mAltEstimator = new android.view.VelocityTracker.Estimator();
        }
    }


    public PointerLocationView(Context context) {
        super(context);
        mPrintCoords = true;
        mReusableOvalRect = new RectF();
        setFocusableInTouchMode(true);
        mIm = (InputManager)context.getSystemService("input");
        mVC = ViewConfiguration.get(context);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(10F * getResources().getDisplayMetrics().density);
        mTextPaint.setARGB(255, 0, 0, 0);
        mTextBackgroundPaint.setAntiAlias(false);
        mTextBackgroundPaint.setARGB(128, 255, 255, 255);
        mTextLevelPaint.setAntiAlias(false);
        mTextLevelPaint.setARGB(192, 255, 0, 0);
        mPaint.setAntiAlias(true);
        mPaint.setARGB(255, 255, 255, 255);
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mPaint.setStrokeWidth(2.0F);
        mTargetPaint.setAntiAlias(false);
        mTargetPaint.setARGB(255, 0, 0, 192);
        mPathPaint.setAntiAlias(false);
        mPathPaint.setARGB(255, 0, 96, 255);
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mPaint.setStrokeWidth(1.0F);
        PointerState pointerstate = new PointerState();
        mPointers.add(pointerstate);
        mActivePointerId = 0;
        String s = SystemProperties.get("debug.velocitytracker.alt");
        if(s.length() != 0) {
            Log.d("Pointer", (new StringBuilder()).append("Comparing default velocity tracker strategy with ").append(s).toString());
            mAltVelocity = VelocityTracker.obtain(s);
        } else {
            mAltVelocity = null;
        }
    }

    private void drawOval(Canvas canvas, float f, float f1, float f2, float f3, float f4, Paint paint) {
        canvas.save(1);
        canvas.rotate((float)((double)(180F * f4) / 3.1415926535897931D), f, f1);
        mReusableOvalRect.left = f - f3 / 2.0F;
        mReusableOvalRect.right = f + f3 / 2.0F;
        mReusableOvalRect.top = f1 - f2 / 2.0F;
        mReusableOvalRect.bottom = f1 + f2 / 2.0F;
        canvas.drawOval(mReusableOvalRect, paint);
        canvas.restore();
    }

    private void logCoords(String s, int i, int j, android.view.MotionEvent.PointerCoords pointercoords, int k, int l, int i1) {
        i & 0xff;
        JVM INSTR tableswitch 0 10: default 64
    //                   0 376
    //                   1 384
    //                   2 392
    //                   3 400
    //                   4 408
    //                   5 416
    //                   6 444
    //                   7 472
    //                   8 496
    //                   9 480
    //                   10 488;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        String s1 = Integer.toString(i);
_L14:
        Log.i("Pointer", mText.clear().append(s).append(" id ").append(k + 1).append(": ").append(s1).append(" (").append(pointercoords.x, 3).append(", ").append(pointercoords.y, 3).append(") Pressure=").append(pointercoords.pressure, 3).append(" Size=").append(pointercoords.size, 3).append(" TouchMajor=").append(pointercoords.touchMajor, 3).append(" TouchMinor=").append(pointercoords.touchMinor, 3).append(" ToolMajor=").append(pointercoords.toolMajor, 3).append(" ToolMinor=").append(pointercoords.toolMinor, 3).append(" Orientation=").append((float)((double)(180F * pointercoords.orientation) / 3.1415926535897931D), 1).append("deg").append(" Tilt=").append((float)((double)(180F * pointercoords.getAxisValue(25)) / 3.1415926535897931D), 1).append("deg").append(" Distance=").append(pointercoords.getAxisValue(24), 1).append(" VScroll=").append(pointercoords.getAxisValue(9), 1).append(" HScroll=").append(pointercoords.getAxisValue(10), 1).append(" ToolType=").append(MotionEvent.toolTypeToString(l)).append(" ButtonState=").append(MotionEvent.buttonStateToString(i1)).toString());
        return;
_L2:
        s1 = "DOWN";
        continue; /* Loop/switch isn't completed */
_L3:
        s1 = "UP";
        continue; /* Loop/switch isn't completed */
_L4:
        s1 = "MOVE";
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = "CANCEL";
        continue; /* Loop/switch isn't completed */
_L6:
        s1 = "OUTSIDE";
        continue; /* Loop/switch isn't completed */
_L7:
        if(j == (0xff00 & i) >> 8)
            s1 = "DOWN";
        else
            s1 = "MOVE";
        continue; /* Loop/switch isn't completed */
_L8:
        if(j == (0xff00 & i) >> 8)
            s1 = "UP";
        else
            s1 = "MOVE";
        continue; /* Loop/switch isn't completed */
_L9:
        s1 = "HOVER MOVE";
        continue; /* Loop/switch isn't completed */
_L11:
        s1 = "HOVER ENTER";
        continue; /* Loop/switch isn't completed */
_L12:
        s1 = "HOVER EXIT";
        continue; /* Loop/switch isn't completed */
_L10:
        s1 = "SCROLL";
        if(true) goto _L14; else goto _L13
_L13:
    }

    private void logInputDeviceState(int i, String s) {
        InputDevice inputdevice = mIm.getInputDevice(i);
        if(inputdevice != null)
            Log.i("Pointer", (new StringBuilder()).append(s).append(": ").append(inputdevice).toString());
        else
            Log.i("Pointer", (new StringBuilder()).append(s).append(": ").append(i).toString());
    }

    private void logInputDevices() {
        int ai[] = InputDevice.getDeviceIds();
        for(int i = 0; i < ai.length; i++)
            logInputDeviceState(ai[i], "Device Enumerated");

    }

    private void logMotionEvent(String s, MotionEvent motionevent) {
        int i = motionevent.getAction();
        int j = motionevent.getHistorySize();
        int k = motionevent.getPointerCount();
        for(int l = 0; l < j; l++) {
            for(int k1 = 0; k1 < k; k1++) {
                int l1 = motionevent.getPointerId(k1);
                motionevent.getHistoricalPointerCoords(k1, l, mTempCoords);
                logCoords(s, i, k1, mTempCoords, l1, motionevent.getToolType(k1), motionevent.getButtonState());
            }

        }

        for(int i1 = 0; i1 < k; i1++) {
            int j1 = motionevent.getPointerId(i1);
            motionevent.getPointerCoords(i1, mTempCoords);
            logCoords(s, i, i1, mTempCoords, j1, motionevent.getToolType(i1), motionevent.getButtonState());
        }

    }

    private static boolean shouldLogKey(int i) {
        boolean flag = true;
        switch(i) {
        default:
            if(!KeyEvent.isGamepadButton(i) && !KeyEvent.isModifierKey(i))
                flag = false;
            // fall through

        case 19: // '\023'
        case 20: // '\024'
        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
            return flag;
        }
    }

    public void addPointerEvent(MotionEvent motionevent) {
        int i = motionevent.getAction();
        int j = mPointers.size();
        if(i == 0 || (i & 0xff) == 5) {
            int k = (0xff00 & i) >> 8;
            if(i == 0) {
                for(int k3 = 0; k3 < j; k3++) {
                    PointerState pointerstate4 = (PointerState)mPointers.get(k3);
                    pointerstate4.clearTrace();
                    pointerstate4.mCurDown = false;
                }

                mCurDown = true;
                mCurNumPointers = 0;
                mMaxNumPointers = 0;
                mVelocity.clear();
                if(mAltVelocity != null)
                    mAltVelocity.clear();
            }
            mCurNumPointers = 1 + mCurNumPointers;
            if(mMaxNumPointers < mCurNumPointers)
                mMaxNumPointers = mCurNumPointers;
            int l;
            for(l = motionevent.getPointerId(k); j <= l; j++) {
                PointerState pointerstate = new PointerState();
                mPointers.add(pointerstate);
            }

            if(mActivePointerId < 0 || !((PointerState)mPointers.get(mActivePointerId)).mCurDown)
                mActivePointerId = l;
            ((PointerState)mPointers.get(l)).mCurDown = true;
        }
        int i1 = motionevent.getPointerCount();
        mVelocity.addMovement(motionevent);
        mVelocity.computeCurrentVelocity(1);
        if(mAltVelocity != null) {
            mAltVelocity.addMovement(motionevent);
            mAltVelocity.computeCurrentVelocity(1);
        }
        int j1 = motionevent.getHistorySize();
        for(int k1 = 0; k1 < j1; k1++) {
            int i3 = 0;
            while(i3 < i1)  {
                int j3 = motionevent.getPointerId(i3);
                PointerState pointerstate3;
                android.view.MotionEvent.PointerCoords pointercoords1;
                if(mCurDown)
                    pointerstate3 = (PointerState)mPointers.get(j3);
                else
                    pointerstate3 = null;
                if(pointerstate3 != null)
                    pointercoords1 = pointerstate3.mCoords;
                else
                    pointercoords1 = mTempCoords;
                motionevent.getHistoricalPointerCoords(i3, k1, pointercoords1);
                if(mPrintCoords)
                    logCoords("Pointer", i, i3, pointercoords1, j3, motionevent.getToolType(i3), motionevent.getButtonState());
                if(pointerstate3 != null)
                    pointerstate3.addTrace(pointercoords1.x, pointercoords1.y);
                i3++;
            }
        }

        int l1 = 0;
        while(l1 < i1)  {
            int l2 = motionevent.getPointerId(l1);
            PointerState pointerstate2;
            android.view.MotionEvent.PointerCoords pointercoords;
            if(mCurDown)
                pointerstate2 = (PointerState)mPointers.get(l2);
            else
                pointerstate2 = null;
            if(pointerstate2 != null)
                pointercoords = pointerstate2.mCoords;
            else
                pointercoords = mTempCoords;
            motionevent.getPointerCoords(l1, pointercoords);
            if(mPrintCoords)
                logCoords("Pointer", i, l1, pointercoords, l2, motionevent.getToolType(l1), motionevent.getButtonState());
            if(pointerstate2 == null)
                continue;
            pointerstate2.addTrace(pointercoords.x, pointercoords.y);
            pointerstate2.mXVelocity = mVelocity.getXVelocity(l2);
            pointerstate2.mYVelocity = mVelocity.getYVelocity(l2);
            mVelocity.getEstimator(l2, pointerstate2.mEstimator);
            if(mAltVelocity != null) {
                pointerstate2.mAltXVelocity = mAltVelocity.getXVelocity(l2);
                pointerstate2.mAltYVelocity = mAltVelocity.getYVelocity(l2);
                mAltVelocity.getEstimator(l2, pointerstate2.mAltEstimator);
            }
            pointerstate2.mToolType = motionevent.getToolType(l1);
            l1++;
        }
        if(i == 1 || i == 3 || (i & 0xff) == 6) {
            int i2 = (0xff00 & i) >> 8;
            int j2 = motionevent.getPointerId(i2);
            PointerState pointerstate1 = (PointerState)mPointers.get(j2);
            pointerstate1.mCurDown = false;
            if(i == 1 || i == 3) {
                mCurDown = false;
                mCurNumPointers = 0;
            } else {
                mCurNumPointers = -1 + mCurNumPointers;
                if(mActivePointerId == j2) {
                    int k2;
                    if(i2 == 0)
                        k2 = 1;
                    else
                        k2 = 0;
                    mActivePointerId = motionevent.getPointerId(k2);
                }
                pointerstate1.addTrace((0.0F / 0.0F), (0.0F / 0.0F));
            }
        }
        invalidate();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mIm.registerInputDeviceListener(this, getHandler());
        logInputDevices();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mIm.unregisterInputDeviceListener(this);
    }

    protected void onDraw(Canvas canvas) {
        int i = getWidth();
        int j = i / 7;
        int k = 1 + -mTextMetrics.ascent;
        int l = mHeaderBottom;
        int i1 = mPointers.size();
        int j1;
        if(mActivePointerId >= 0) {
            PointerState pointerstate1 = (PointerState)mPointers.get(mActivePointerId);
            canvas.drawRect(0.0F, 0.0F, j - 1, l, mTextBackgroundPaint);
            canvas.drawText(mText.clear().append("P: ").append(mCurNumPointers).append(" / ").append(mMaxNumPointers).toString(), 1.0F, k, mTextPaint);
            int l2 = pointerstate1.mTraceCount;
            int k1;
            int l1;
            if(mCurDown && pointerstate1.mCurDown || l2 == 0) {
                canvas.drawRect(j, 0.0F, -1 + j * 2, l, mTextBackgroundPaint);
                canvas.drawText(mText.clear().append("X: ").append(pointerstate1.mCoords.x, 1).toString(), j + 1, k, mTextPaint);
                canvas.drawRect(j * 2, 0.0F, -1 + j * 3, l, mTextBackgroundPaint);
                canvas.drawText(mText.clear().append("Y: ").append(pointerstate1.mCoords.y, 1).toString(), 1 + j * 2, k, mTextPaint);
            } else {
                float f24 = pointerstate1.mTraceX[l2 - 1] - pointerstate1.mTraceX[0];
                float f25 = pointerstate1.mTraceY[l2 - 1] - pointerstate1.mTraceY[0];
                float f26 = j;
                float f27 = -1 + j * 2;
                float f28 = l;
                Paint paint2;
                float f29;
                float f30;
                float f31;
                Paint paint3;
                if(Math.abs(f24) < (float)mVC.getScaledTouchSlop())
                    paint2 = mTextBackgroundPaint;
                else
                    paint2 = mTextLevelPaint;
                canvas.drawRect(f26, 0.0F, f27, f28, paint2);
                canvas.drawText(mText.clear().append("dX: ").append(f24, 1).toString(), j + 1, k, mTextPaint);
                f29 = j * 2;
                f30 = -1 + j * 3;
                f31 = l;
                if(Math.abs(f25) < (float)mVC.getScaledTouchSlop())
                    paint3 = mTextBackgroundPaint;
                else
                    paint3 = mTextLevelPaint;
                canvas.drawRect(f29, 0.0F, f30, f31, paint3);
                canvas.drawText(mText.clear().append("dY: ").append(f25, 1).toString(), 1 + j * 2, k, mTextPaint);
            }
            canvas.drawRect(j * 3, 0.0F, -1 + j * 4, l, mTextBackgroundPaint);
            canvas.drawText(mText.clear().append("Xv: ").append(pointerstate1.mXVelocity, 3).toString(), 1 + j * 3, k, mTextPaint);
            canvas.drawRect(j * 4, 0.0F, -1 + j * 5, l, mTextBackgroundPaint);
            canvas.drawText(mText.clear().append("Yv: ").append(pointerstate1.mYVelocity, 3).toString(), 1 + j * 4, k, mTextPaint);
            canvas.drawRect(j * 5, 0.0F, -1 + j * 6, l, mTextBackgroundPaint);
            canvas.drawRect(j * 5, 0.0F, ((float)(j * 5) + pointerstate1.mCoords.pressure * (float)j) - 1.0F, l, mTextLevelPaint);
            canvas.drawText(mText.clear().append("Prs: ").append(pointerstate1.mCoords.pressure, 2).toString(), 1 + j * 5, k, mTextPaint);
            canvas.drawRect(j * 6, 0.0F, i, l, mTextBackgroundPaint);
            canvas.drawRect(j * 6, 0.0F, ((float)(j * 6) + pointerstate1.mCoords.size * (float)j) - 1.0F, l, mTextLevelPaint);
            canvas.drawText(mText.clear().append("Size: ").append(pointerstate1.mCoords.size, 2).toString(), 1 + j * 6, k, mTextPaint);
        }
        j1 = 0;
        while(j1 < i1)  {
            PointerState pointerstate = (PointerState)mPointers.get(j1);
            k1 = pointerstate.mTraceCount;
            float f = 0.0F;
            float f1 = 0.0F;
            boolean flag = false;
            boolean flag1 = false;
            mPaint.setARGB(255, 128, 255, 255);
            l1 = 0;
            while(l1 < k1)  {
                float f22 = pointerstate.mTraceX[l1];
                float f23 = pointerstate.mTraceY[l1];
                if(Float.isNaN(f22)) {
                    flag = false;
                } else {
                    if(flag) {
                        canvas.drawLine(f, f1, f22, f23, mPathPaint);
                        canvas.drawPoint(f, f1, mPaint);
                        flag1 = true;
                    }
                    f = f22;
                    f1 = f23;
                    flag = true;
                }
                l1++;
            }
            if(flag1) {
                mPaint.setARGB(128, 128, 0, 128);
                float f6 = pointerstate.mEstimator.estimateX(-0.08F);
                float f7 = pointerstate.mEstimator.estimateY(-0.08F);
                for(int j2 = -3; j2 <= 2; j2++) {
                    float f20 = pointerstate.mEstimator.estimateX(0.02F * (float)j2);
                    float f21 = pointerstate.mEstimator.estimateY(0.02F * (float)j2);
                    canvas.drawLine(f6, f7, f20, f21, mPaint);
                    f6 = f20;
                    f7 = f21;
                }

                mPaint.setARGB(255, 255, 64, 128);
                float f8 = 16F * pointerstate.mXVelocity;
                float f9 = 16F * pointerstate.mYVelocity;
                float f10 = f + f8;
                float f11 = f1 + f9;
                Paint paint = mPaint;
                canvas.drawLine(f, f1, f10, f11, paint);
                if(mAltVelocity != null) {
                    mPaint.setARGB(128, 0, 128, 128);
                    float f12 = pointerstate.mAltEstimator.estimateX(-0.08F);
                    float f13 = pointerstate.mAltEstimator.estimateY(-0.08F);
                    for(int k2 = -3; k2 <= 2; k2++) {
                        float f18 = pointerstate.mAltEstimator.estimateX(0.02F * (float)k2);
                        float f19 = pointerstate.mAltEstimator.estimateY(0.02F * (float)k2);
                        canvas.drawLine(f12, f13, f18, f19, mPaint);
                        f12 = f18;
                        f13 = f19;
                    }

                    mPaint.setARGB(255, 64, 255, 128);
                    float f14 = 16F * pointerstate.mAltXVelocity;
                    float f15 = 16F * pointerstate.mAltYVelocity;
                    float f16 = f + f14;
                    float f17 = f1 + f15;
                    Paint paint1 = mPaint;
                    canvas.drawLine(f, f1, f16, f17, paint1);
                }
            }
            if(mCurDown && pointerstate.mCurDown) {
                canvas.drawLine(0.0F, pointerstate.mCoords.y, getWidth(), pointerstate.mCoords.y, mTargetPaint);
                canvas.drawLine(pointerstate.mCoords.x, 0.0F, pointerstate.mCoords.x, getHeight(), mTargetPaint);
                int i2 = (int)(255F * pointerstate.mCoords.pressure);
                mPaint.setARGB(255, i2, 255, 255 - i2);
                canvas.drawPoint(pointerstate.mCoords.x, pointerstate.mCoords.y, mPaint);
                mPaint.setARGB(255, i2, 255 - i2, 128);
                drawOval(canvas, pointerstate.mCoords.x, pointerstate.mCoords.y, pointerstate.mCoords.touchMajor, pointerstate.mCoords.touchMinor, pointerstate.mCoords.orientation, mPaint);
                mPaint.setARGB(255, i2, 128, 255 - i2);
                drawOval(canvas, pointerstate.mCoords.x, pointerstate.mCoords.y, pointerstate.mCoords.toolMajor, pointerstate.mCoords.toolMinor, pointerstate.mCoords.orientation, mPaint);
                float f2 = 0.7F * pointerstate.mCoords.toolMajor;
                if(f2 < 20F)
                    f2 = 20F;
                mPaint.setARGB(255, i2, 255, 0);
                float f3 = (float)(Math.sin(pointerstate.mCoords.orientation) * (double)f2);
                float f4 = (float)(-Math.cos(pointerstate.mCoords.orientation) * (double)f2);
                float f5;
                if(pointerstate.mToolType == 2 || pointerstate.mToolType == 4)
                    canvas.drawLine(pointerstate.mCoords.x, pointerstate.mCoords.y, f3 + pointerstate.mCoords.x, f4 + pointerstate.mCoords.y, mPaint);
                else
                    canvas.drawLine(pointerstate.mCoords.x - f3, pointerstate.mCoords.y - f4, f3 + pointerstate.mCoords.x, f4 + pointerstate.mCoords.y, mPaint);
                f5 = (float)Math.sin(pointerstate.mCoords.getAxisValue(25));
                canvas.drawCircle(pointerstate.mCoords.x + f3 * f5, pointerstate.mCoords.y + f4 * f5, 3F, mPaint);
            }
            j1++;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent) {
        int i = motionevent.getSource();
        if((i & 2) != 0)
            addPointerEvent(motionevent);
        else
        if((i & 0x10) != 0)
            logMotionEvent("Joystick", motionevent);
        else
        if((i & 8) != 0)
            logMotionEvent("Position", motionevent);
        else
            logMotionEvent("Generic", motionevent);
        return true;
    }

    public void onInputDeviceAdded(int i) {
        logInputDeviceState(i, "Device Added");
    }

    public void onInputDeviceChanged(int i) {
        logInputDeviceState(i, "Device Changed");
    }

    public void onInputDeviceRemoved(int i) {
        logInputDeviceState(i, "Device Removed");
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        boolean flag;
        if(shouldLogKey(i)) {
            int j = keyevent.getRepeatCount();
            if(j == 0)
                Log.i("Pointer", (new StringBuilder()).append("Key Down: ").append(keyevent).toString());
            else
                Log.i("Pointer", (new StringBuilder()).append("Key Repeat #").append(j).append(": ").append(keyevent).toString());
            flag = true;
        } else {
            flag = super.onKeyDown(i, keyevent);
        }
        return flag;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        boolean flag;
        if(shouldLogKey(i)) {
            Log.i("Pointer", (new StringBuilder()).append("Key Up: ").append(keyevent).toString());
            flag = true;
        } else {
            flag = super.onKeyUp(i, keyevent);
        }
        return flag;
    }

    protected void onMeasure(int i, int j) {
        super.onMeasure(i, j);
        mTextPaint.getFontMetricsInt(mTextMetrics);
        mHeaderBottom = 2 + (-mTextMetrics.ascent + mTextMetrics.descent);
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        addPointerEvent(motionevent);
        if(motionevent.getAction() == 0 && !isFocused())
            requestFocus();
        return true;
    }

    public boolean onTrackballEvent(MotionEvent motionevent) {
        logMotionEvent("Trackball", motionevent);
        return true;
    }

    public void setPrintCoords(boolean flag) {
        mPrintCoords = flag;
    }

    private static final String ALT_STRATEGY_PROPERY_KEY = "debug.velocitytracker.alt";
    private static final String TAG = "Pointer";
    private final int ESTIMATE_FUTURE_POINTS = 2;
    private final float ESTIMATE_INTERVAL = 0.02F;
    private final int ESTIMATE_PAST_POINTS = 4;
    private int mActivePointerId;
    private final VelocityTracker mAltVelocity;
    private boolean mCurDown;
    private int mCurNumPointers;
    private int mHeaderBottom;
    private final InputManager mIm;
    private int mMaxNumPointers;
    private final Paint mPaint = new Paint();
    private final Paint mPathPaint = new Paint();
    private final ArrayList mPointers = new ArrayList();
    private boolean mPrintCoords;
    private RectF mReusableOvalRect;
    private final Paint mTargetPaint = new Paint();
    private final android.view.MotionEvent.PointerCoords mTempCoords = new android.view.MotionEvent.PointerCoords();
    private final FasterStringBuilder mText = new FasterStringBuilder();
    private final Paint mTextBackgroundPaint = new Paint();
    private final Paint mTextLevelPaint = new Paint();
    private final android.graphics.Paint.FontMetricsInt mTextMetrics = new android.graphics.Paint.FontMetricsInt();
    private final Paint mTextPaint = new Paint();
    private final ViewConfiguration mVC;
    private final VelocityTracker mVelocity = VelocityTracker.obtain();
}
