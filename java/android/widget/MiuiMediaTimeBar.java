// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

public class MiuiMediaTimeBar extends View {
    public static interface ScrubbingListener {

        public abstract void onScrubbingEnd(int i);

        public abstract void onScrubbingMove(int i);

        public abstract void onScrubbingStart();
    }


    public MiuiMediaTimeBar(Context context, ScrubbingListener scrubbinglistener) {
        super(context);
        if(scrubbinglistener == null) {
            throw new NullPointerException();
        } else {
            listener = scrubbinglistener;
            showTimes = true;
            showScrubber = true;
            progressBar = new Rect();
            playedBar = new Rect();
            progressPaint = new Paint();
            progressPaint.setColor(0xff808080);
            playedPaint = new Paint();
            playedPaint.setColor(-1);
            DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
            float f = 14F * displaymetrics.density;
            timeTextPaint = new Paint(1);
            timeTextPaint.setColor(0xffcecece);
            timeTextPaint.setTextSize(f);
            timeTextPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
            timeBounds = new Rect();
            timeTextPaint.getTextBounds("0:00:00", 0, 7, timeBounds);
            scrubber = BitmapFactory.decodeResource(getResources(), 0x60201d5);
            scrubberPadding = (int)(10F * displaymetrics.density);
            vPaddingInPx = (int)(30F * displaymetrics.density);
            return;
        }
    }

    private void clampScrubber() {
        int i = scrubber.getWidth() / 2;
        scrubberLeft = Math.min(progressBar.right - i, Math.max(progressBar.left - i, scrubberLeft));
    }

    private int getScrubberTime() {
        return (int)(((long)((scrubberLeft + scrubber.getWidth() / 2) - progressBar.left) * (long)totalTime) / (long)progressBar.width());
    }

    private boolean inScrubber(float f, float f1) {
        int i = scrubberLeft + scrubber.getWidth();
        int j = scrubberTop + scrubber.getHeight();
        boolean flag;
        if((float)(scrubberLeft - scrubberPadding) < f && f < (float)(i + scrubberPadding) && (float)(scrubberTop - scrubberPadding) < f1 && f1 < (float)(j + scrubberPadding))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private String stringForTime(long l) {
        int i = (int)l / 1000;
        int j = i % 60;
        int k = (i / 60) % 60;
        int i1 = i / 3600;
        String s;
        if(i1 > 0) {
            Object aobj1[] = new Object[3];
            aobj1[0] = Integer.valueOf(i1);
            aobj1[1] = Integer.valueOf(k);
            aobj1[2] = Integer.valueOf(j);
            s = String.format("%d:%02d:%02d", aobj1).toString();
        } else {
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(k);
            aobj[1] = Integer.valueOf(j);
            s = String.format("%02d:%02d", aobj).toString();
        }
        return s;
    }

    private void update() {
        playedBar.set(progressBar);
        if(totalTime > 0)
            playedBar.right = playedBar.left + (int)(((long)progressBar.width() * (long)currentTime) / (long)totalTime);
        else
            playedBar.right = progressBar.left;
        if(!scrubbing)
            scrubberLeft = playedBar.right - scrubber.getWidth() / 2;
        invalidate();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawRect(progressBar, progressPaint);
        canvas.drawRect(playedBar, playedPaint);
        if(showScrubber)
            canvas.drawBitmap(scrubber, scrubberLeft, scrubberTop, null);
        if(showTimes) {
            canvas.drawText(stringForTime(currentTime), timeBounds.width() / 2 + getPaddingLeft(), 1 + (timeBounds.height() + vPaddingInPx / 2 + scrubberPadding), timeTextPaint);
            canvas.drawText(stringForTime(totalTime), getWidth() - getPaddingRight() - timeBounds.width() / 2, 1 + (timeBounds.height() + vPaddingInPx / 2 + scrubberPadding), timeTextPaint);
        }
    }

    public int getBarHeight() {
        return timeBounds.height() + vPaddingInPx;
    }

    public int getPreferredHeight() {
        return timeBounds.height() + vPaddingInPx + scrubberPadding;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        int i1 = k - i;
        int j1 = l - j;
        if(!showTimes && !showScrubber) {
            progressBar.set(0, 0, i1, j1);
        } else {
            int k1 = scrubber.getWidth() / 3;
            if(showTimes)
                k1 += timeBounds.width();
            int l1 = (j1 + scrubberPadding) / 2;
            scrubberTop = 1 + (l1 - scrubber.getHeight() / 2);
            progressBar.set(k1 + getPaddingLeft(), l1, i1 - getPaddingRight() - k1, l1 + 4);
        }
        update();
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag = true;
        if(!showScrubber) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = (int)motionevent.getX();
        j = (int)motionevent.getY();
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 52
    //                   0 56
    //                   1 144
    //                   2 95;
           goto _L2 _L3 _L4 _L5
_L2:
        flag = false;
_L7:
        return flag;
_L3:
        if(!inScrubber(i, j)) goto _L2; else goto _L6
_L6:
        scrubbing = flag;
        scrubberCorrection = i - scrubberLeft;
        listener.onScrubbingStart();
          goto _L7
_L5:
        if(!scrubbing) goto _L2; else goto _L8
_L8:
        scrubberLeft = i - scrubberCorrection;
        clampScrubber();
        currentTime = getScrubberTime();
        listener.onScrubbingMove(currentTime);
        invalidate();
          goto _L7
_L4:
        if(!scrubbing) goto _L2; else goto _L9
_L9:
        listener.onScrubbingEnd(getScrubberTime());
        scrubbing = false;
          goto _L7
    }

    public void resetTime() {
        setTime(0, 0);
    }

    public void setShowScrubber(boolean flag) {
        showScrubber = flag;
        if(!flag && scrubbing) {
            listener.onScrubbingEnd(getScrubberTime());
            scrubbing = false;
        }
        requestLayout();
    }

    public void setShowTimes(boolean flag) {
        showTimes = flag;
        requestLayout();
    }

    public void setTime(int i, int j) {
        if(currentTime != i || totalTime != j) {
            currentTime = i;
            totalTime = j;
            update();
        }
    }

    private static final int SCRUBBER_PADDING_IN_DP = 10;
    private static final int TEXT_SIZE_IN_DP = 14;
    private static final int V_PADDING_IN_DP = 30;
    private int currentTime;
    private final ScrubbingListener listener;
    private final Rect playedBar;
    private final Paint playedPaint;
    private final Rect progressBar;
    private final Paint progressPaint;
    private final Bitmap scrubber;
    private int scrubberCorrection;
    private int scrubberLeft;
    private final int scrubberPadding;
    private int scrubberTop;
    private boolean scrubbing;
    private boolean showScrubber;
    private boolean showTimes;
    private final Rect timeBounds;
    private final Paint timeTextPaint;
    private int totalTime;
    private int vPaddingInPx;
}
