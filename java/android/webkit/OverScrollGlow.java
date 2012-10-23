// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import android.widget.OverScroller;

// Referenced classes of package android.webkit:
//            WebViewClassic, WebView

public class OverScrollGlow {

    public OverScrollGlow(WebViewClassic webviewclassic) {
        mHostView = webviewclassic;
        android.content.Context context = webviewclassic.getContext();
        mEdgeGlowTop = new EdgeEffect(context);
        mEdgeGlowBottom = new EdgeEffect(context);
        mEdgeGlowLeft = new EdgeEffect(context);
        mEdgeGlowRight = new EdgeEffect(context);
    }

    public void absorbGlow(int i, int j, int k, int l, int i1, int j1) {
        if(j1 > 0 || mHostView.getWebView().getOverScrollMode() == 0)
            if(j < 0 && l >= 0) {
                mEdgeGlowTop.onAbsorb((int)mHostView.mScroller.getCurrVelocity());
                if(!mEdgeGlowBottom.isFinished())
                    mEdgeGlowBottom.onRelease();
            } else
            if(j > j1 && l <= j1) {
                mEdgeGlowBottom.onAbsorb((int)mHostView.mScroller.getCurrVelocity());
                if(!mEdgeGlowTop.isFinished())
                    mEdgeGlowTop.onRelease();
            }
        if(i1 > 0)
            if(i < 0 && k >= 0) {
                mEdgeGlowLeft.onAbsorb((int)mHostView.mScroller.getCurrVelocity());
                if(!mEdgeGlowRight.isFinished())
                    mEdgeGlowRight.onRelease();
            } else
            if(i > i1 && k <= i1) {
                mEdgeGlowRight.onAbsorb((int)mHostView.mScroller.getCurrVelocity());
                if(!mEdgeGlowLeft.isFinished())
                    mEdgeGlowLeft.onRelease();
            }
    }

    public boolean drawEdgeGlows(Canvas canvas) {
        int i = mHostView.getScrollX();
        int j = mHostView.getScrollY();
        int k = mHostView.getWidth();
        int l = mHostView.getHeight();
        boolean flag = false;
        if(!mEdgeGlowTop.isFinished()) {
            int l1 = canvas.save();
            canvas.translate(i, mHostView.getVisibleTitleHeight() + Math.min(0, j));
            mEdgeGlowTop.setSize(k, l);
            flag = false | mEdgeGlowTop.draw(canvas);
            canvas.restoreToCount(l1);
        }
        if(!mEdgeGlowBottom.isFinished()) {
            int k1 = canvas.save();
            canvas.translate(i + -k, l + Math.max(mHostView.computeMaxScrollY(), j));
            canvas.rotate(180F, k, 0.0F);
            mEdgeGlowBottom.setSize(k, l);
            flag |= mEdgeGlowBottom.draw(canvas);
            canvas.restoreToCount(k1);
        }
        if(!mEdgeGlowLeft.isFinished()) {
            int j1 = canvas.save();
            canvas.rotate(270F);
            canvas.translate(-l - j, Math.min(0, i));
            mEdgeGlowLeft.setSize(l, k);
            flag |= mEdgeGlowLeft.draw(canvas);
            canvas.restoreToCount(j1);
        }
        if(!mEdgeGlowRight.isFinished()) {
            int i1 = canvas.save();
            canvas.rotate(90F);
            canvas.translate(j, -(k + Math.max(mHostView.computeMaxScrollX(), i)));
            mEdgeGlowRight.setSize(l, k);
            flag |= mEdgeGlowRight.draw(canvas);
            canvas.restoreToCount(i1);
        }
        return flag;
    }

    public boolean isAnimating() {
        boolean flag;
        if(!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished() || !mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void pullGlow(int i, int j, int k, int l, int i1, int j1) {
        if(k == mHostView.getScrollX() && l == mHostView.getScrollY()) {
            if(i1 > 0) {
                int l1 = k + mOverScrollDeltaX;
                if(l1 < 0) {
                    mEdgeGlowLeft.onPull((float)mOverScrollDeltaX / (float)mHostView.getWidth());
                    if(!mEdgeGlowRight.isFinished())
                        mEdgeGlowRight.onRelease();
                } else
                if(l1 > i1) {
                    mEdgeGlowRight.onPull((float)mOverScrollDeltaX / (float)mHostView.getWidth());
                    if(!mEdgeGlowLeft.isFinished())
                        mEdgeGlowLeft.onRelease();
                }
                mOverScrollDeltaX = 0;
            }
            if(j1 > 0 || mHostView.getWebView().getOverScrollMode() == 0) {
                int k1 = l + mOverScrollDeltaY;
                if(k1 < 0) {
                    mEdgeGlowTop.onPull((float)mOverScrollDeltaY / (float)mHostView.getHeight());
                    if(!mEdgeGlowBottom.isFinished())
                        mEdgeGlowBottom.onRelease();
                } else
                if(k1 > j1) {
                    mEdgeGlowBottom.onPull((float)mOverScrollDeltaY / (float)mHostView.getHeight());
                    if(!mEdgeGlowTop.isFinished())
                        mEdgeGlowTop.onRelease();
                }
                mOverScrollDeltaY = 0;
            }
        }
    }

    public void releaseAll() {
        mEdgeGlowTop.onRelease();
        mEdgeGlowBottom.onRelease();
        mEdgeGlowLeft.onRelease();
        mEdgeGlowRight.onRelease();
    }

    public void setOverScrollDeltas(int i, int j) {
        mOverScrollDeltaX = i;
        mOverScrollDeltaY = j;
    }

    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowLeft;
    private EdgeEffect mEdgeGlowRight;
    private EdgeEffect mEdgeGlowTop;
    private WebViewClassic mHostView;
    private int mOverScrollDeltaX;
    private int mOverScrollDeltaY;
}
