// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.*;

public class TextProgressBar extends RelativeLayout
    implements android.widget.Chronometer.OnChronometerTickListener {

    public TextProgressBar(Context context) {
        super(context);
        mChronometer = null;
        mProgressBar = null;
        mDurationBase = -1L;
        mDuration = -1;
        mChronometerFollow = false;
        mChronometerGravity = 0;
    }

    public TextProgressBar(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mChronometer = null;
        mProgressBar = null;
        mDurationBase = -1L;
        mDuration = -1;
        mChronometerFollow = false;
        mChronometerGravity = 0;
    }

    public TextProgressBar(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mChronometer = null;
        mProgressBar = null;
        mDurationBase = -1L;
        mDuration = -1;
        mChronometerFollow = false;
        mChronometerGravity = 0;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams) {
        int j;
        super.addView(view, i, layoutparams);
        j = view.getId();
        if(j != 0x1020014 || !(view instanceof Chronometer)) goto _L2; else goto _L1
_L1:
        mChronometer = (Chronometer)view;
        mChronometer.setOnChronometerTickListener(this);
        boolean flag;
        if(layoutparams.width == -2)
            flag = true;
        else
            flag = false;
        mChronometerFollow = flag;
        mChronometerGravity = 0x800007 & mChronometer.getGravity();
_L4:
        return;
_L2:
        if(j == 0x102000d && (view instanceof ProgressBar))
            mProgressBar = (ProgressBar)view;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onChronometerTick(Chronometer chronometer) {
        if(mProgressBar == null)
            throw new RuntimeException("Expecting child ProgressBar with id 'android.R.id.progress'");
        long l = SystemClock.elapsedRealtime();
        if(l >= mDurationBase)
            mChronometer.stop();
        int i = (int)(mDurationBase - l);
        mProgressBar.setProgress(mDuration - i);
        if(mChronometerFollow) {
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)mProgressBar.getLayoutParams();
            int j = mProgressBar.getWidth() - (((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin);
            int k = (j * mProgressBar.getProgress()) / mProgressBar.getMax() + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin;
            int i1 = 0;
            int j1 = mChronometer.getWidth();
            int k1;
            int l1;
            if(mChronometerGravity == 5)
                i1 = -j1;
            else
            if(mChronometerGravity == 1)
                i1 = -(j1 / 2);
            k1 = k + i1;
            l1 = j - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin - j1;
            if(k1 < ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin)
                k1 = ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin;
            else
            if(k1 > l1)
                k1 = l1;
            ((android.widget.RelativeLayout.LayoutParams)mChronometer.getLayoutParams()).leftMargin = k1;
            mChronometer.requestLayout();
        }
    }

    public void setDurationBase(long l) {
        mDurationBase = l;
        if(mProgressBar == null || mChronometer == null)
            throw new RuntimeException("Expecting child ProgressBar with id 'android.R.id.progress' and Chronometer id 'android.R.id.text1'");
        mDuration = (int)(l - mChronometer.getBase());
        if(mDuration <= 0)
            mDuration = 1;
        mProgressBar.setMax(mDuration);
    }

    static final int CHRONOMETER_ID = 0x1020014;
    static final int PROGRESSBAR_ID = 0x102000d;
    public static final String TAG = "TextProgressBar";
    Chronometer mChronometer;
    boolean mChronometerFollow;
    int mChronometerGravity;
    int mDuration;
    long mDurationBase;
    ProgressBar mProgressBar;
}
