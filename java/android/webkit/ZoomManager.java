// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.FloatMath;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.View;

// Referenced classes of package android.webkit:
//            WebViewClassic, WebSettingsClassic, ZoomControlEmbedded, ZoomControlExternal, 
//            CallbackProxy, ViewManager, WebView, ZoomControlBase

class ZoomManager {
    private class PostScale
        implements Runnable {

        public void run() {
            if(mWebView.getWebViewCore() != null) {
                float f = mActualScale;
                if(mWebView.getSettings().getUseWideViewPort() && mInPortraitMode && mInZoomOverviewBeforeSizeChange)
                    f = getZoomOverviewScale();
                setZoomScale(f, mUpdateTextWrap, true);
                updateZoomPicker();
            }
        }

        final boolean mInPortraitMode;
        final boolean mInZoomOverviewBeforeSizeChange;
        final boolean mUpdateTextWrap;
        final ZoomManager this$0;

        public PostScale(boolean flag, boolean flag1, boolean flag2) {
            this$0 = ZoomManager.this;
            super();
            mUpdateTextWrap = flag;
            mInZoomOverviewBeforeSizeChange = flag1;
            mInPortraitMode = flag2;
        }
    }

    private class ScaleDetectorListener
        implements android.view.ScaleGestureDetector.OnScaleGestureListener {

        public boolean handleScale(ScaleGestureDetector scalegesturedetector) {
            float f = scalegesturedetector.getScaleFactor() * mActualScale;
            boolean flag;
            float f1;
            if(isScaleOverLimits(f) || f < getZoomOverviewScale())
                flag = true;
            else
                flag = false;
            f1 = Math.max(computeScaleWithLimits(f), getZoomOverviewScale());
            if(mPinchToZoomAnimating || willScaleTriggerZoom(f1)) {
                mPinchToZoomAnimating = true;
                float f2;
                float f3;
                if(f1 > mActualScale)
                    f2 = Math.min(f1, 1.25F * mActualScale);
                else
                    f2 = Math.max(f1, 0.8F * mActualScale);
                f3 = computeScaleWithLimits(f2);
                if(Math.abs(f3 - mActualScale) >= ZoomManager.MINIMUM_SCALE_WITHOUT_JITTER) {
                    setZoomCenter(scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
                    setZoomScale(f3, false);
                    mWebView.invalidate();
                    flag = true;
                }
            }
            return flag;
        }

        public boolean isPanningOnly(ScaleGestureDetector scalegesturedetector) {
            float f = mFocusX;
            float f1 = mFocusY;
            mFocusX = scalegesturedetector.getFocusX();
            mFocusY = scalegesturedetector.getFocusY();
            float f2;
            float f3;
            boolean flag;
            if(f == 0.0F && f1 == 0.0F)
                f2 = 0.0F;
            else
                f2 = FloatMath.sqrt((mFocusX - f) * (mFocusX - f) + (mFocusY - f1) * (mFocusY - f1));
            mFocusMovementQueue.add(f2);
            f3 = (scalegesturedetector.getCurrentSpan() - scalegesturedetector.getPreviousSpan()) + mAccumulatedSpan;
            if(mFocusMovementQueue.getSum() > Math.abs(f3))
                flag = true;
            else
                flag = false;
            if(flag)
                mAccumulatedSpan = f3 + mAccumulatedSpan;
            else
                mAccumulatedSpan = 0.0F;
            return flag;
        }

        public boolean onScale(ScaleGestureDetector scalegesturedetector) {
            boolean flag;
            if(isPanningOnly(scalegesturedetector) || handleScale(scalegesturedetector)) {
                mFocusMovementQueue.clear();
                flag = true;
            } else {
                flag = false;
            }
            return flag;
        }

        public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector) {
            mInitialZoomOverview = false;
            dismissZoomPicker();
            mFocusMovementQueue.clear();
            mFocusX = scalegesturedetector.getFocusX();
            mFocusY = scalegesturedetector.getFocusY();
            mWebView.mViewManager.startZoom();
            mWebView.onPinchToZoomAnimationStart();
            mAccumulatedSpan = 0.0F;
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scalegesturedetector) {
            boolean flag = true;
            if(mPinchToZoomAnimating) {
                mPinchToZoomAnimating = false;
                mAnchorX = mWebView.viewToContentX((int)mZoomCenterX + mWebView.getScrollX());
                mAnchorY = mWebView.viewToContentY((int)mZoomCenterY + mWebView.getScrollY());
                boolean flag1;
                ZoomManager zoommanager;
                if(!canZoomOut() || (double)mActualScale <= 0.80000000000000004D * (double)mTextWrapScale)
                    flag1 = flag;
                else
                    flag1 = false;
                zoommanager = ZoomManager.this;
                if(!flag1 || mWebView.getSettings().getUseFixedViewport())
                    flag = false;
                zoommanager.refreshZoomScale(flag);
                mWebView.invalidate();
            }
            mWebView.mViewManager.endZoom();
            mWebView.onPinchToZoomAnimationEnd(scalegesturedetector);
        }

        private float mAccumulatedSpan;
        final ZoomManager this$0;

        private ScaleDetectorListener() {
            this$0 = ZoomManager.this;
            super();
        }

    }

    private class FocusMovementQueue {

        private void add(float f) {
            mSum = f + mSum;
            if(mSize < 5)
                mSize = 1 + mSize;
            else
                mSum = mSum - mQueue[mIndex];
            mQueue[mIndex] = f;
            mIndex = (1 + mIndex) % 5;
        }

        private void clear() {
            mSize = 0;
            mSum = 0.0F;
            mIndex = 0;
            for(int i = 0; i < 5; i++)
                mQueue[i] = 0.0F;

        }

        private float getSum() {
            return mSum;
        }

        private static final int QUEUE_CAPACITY = 5;
        private int mIndex;
        private float mQueue[];
        private int mSize;
        private float mSum;
        final ZoomManager this$0;




        FocusMovementQueue() {
            this$0 = ZoomManager.this;
            super();
            mQueue = new float[5];
            mSize = 0;
            mSum = 0.0F;
            mIndex = 0;
        }
    }


    public ZoomManager(WebViewClassic webviewclassic, CallbackProxy callbackproxy) {
        mMinZoomScaleFixed = true;
        mInitialZoomOverview = false;
        mInZoomOverview = false;
        mDoubleTapZoomFactor = 1.0F;
        mPinchToZoomAnimating = false;
        mHardwareAccelerated = false;
        mInHWAcceleratedZoom = false;
        mWebView = webviewclassic;
        mCallbackProxy = callbackproxy;
        setZoomOverviewWidth(980);
        mFocusMovementQueue = new FocusMovementQueue();
    }

    public static final boolean exceedsMinScaleIncrement(float f, float f1) {
        boolean flag;
        if(Math.abs(f - f1) >= MINIMUM_SCALE_INCREMENT)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private ZoomControlBase getCurrentZoomControl() {
        Object obj;
        if(mWebView.getSettings() != null && mWebView.getSettings().supportZoom()) {
            if(mWebView.getSettings().getBuiltInZoomControls()) {
                if(mEmbeddedZoomControl == null && mWebView.getSettings().getDisplayZoomControls())
                    mEmbeddedZoomControl = new ZoomControlEmbedded(this, mWebView);
                obj = mEmbeddedZoomControl;
            } else {
                if(mExternalZoomControl == null)
                    mExternalZoomControl = new ZoomControlExternal(mWebView);
                obj = mExternalZoomControl;
            }
        } else {
            obj = null;
        }
        return ((ZoomControlBase) (obj));
    }

    private void setDefaultZoomScale(float f) {
        float f1 = mDefaultScale;
        mDefaultScale = f;
        mInvDefaultScale = 1.0F / f;
        mDefaultMaxZoomScale = 4F * f;
        mDefaultMinZoomScale = 0.25F * f;
        if((double)f1 > 0.0D && (double)mMaxZoomScale > 0.0D)
            mMaxZoomScale = (f / f1) * mMaxZoomScale;
        else
            mMaxZoomScale = mDefaultMaxZoomScale;
        if((double)f1 > 0.0D && (double)mMinZoomScale > 0.0D)
            mMinZoomScale = (f / f1) * mMinZoomScale;
        else
            mMinZoomScale = mDefaultMinZoomScale;
        if(!exceedsMinScaleIncrement(mMinZoomScale, mMaxZoomScale))
            mMaxZoomScale = mMinZoomScale;
    }

    private void setZoomOverviewWidth(int i) {
        if(i == 0)
            mZoomOverviewWidth = 980;
        else
            mZoomOverviewWidth = i;
        mInvZoomOverviewWidth = 1.0F / (float)i;
    }

    private void setZoomScale(float f, boolean flag, boolean flag1) {
        boolean flag2;
        float f1;
        if(f < mMinZoomScale)
            flag2 = true;
        else
            flag2 = false;
        f1 = computeScaleWithLimits(f);
        if(flag2 && mMinZoomScale < mDefaultScale) {
            mInZoomOverview = true;
        } else {
            boolean flag3;
            if(!exceedsMinScaleIncrement(f1, getZoomOverviewScale()))
                flag3 = true;
            else
                flag3 = false;
            mInZoomOverview = flag3;
        }
        if(flag && !mWebView.getSettings().getUseFixedViewport())
            mTextWrapScale = f1;
        if(f1 != mActualScale || flag1) {
            float _tmp = mActualScale;
            float f2 = mInvActualScale;
            if(f1 != mActualScale && !mPinchToZoomAnimating)
                mCallbackProxy.onScaleChanged(mActualScale, f1);
            mActualScale = f1;
            mInvActualScale = 1.0F / f1;
            if(!mWebView.drawHistory() && !mInHWAcceleratedZoom) {
                int i = mWebView.getScrollX();
                int j = mWebView.getScrollY();
                float f3 = f1 * f2;
                float f4 = f3 * (float)i + (f3 - 1.0F) * mZoomCenterX;
                float f5 = f3 * (float)j + (f3 - 1.0F) * (mZoomCenterY - (float)mWebView.getTitleHeight());
                mWebView.mViewManager.scaleAll();
                int k = mWebView.pinLocX(Math.round(f4));
                int l = mWebView.pinLocY(Math.round(f5));
                if(!mWebView.updateScrollCoordinates(k, l))
                    mWebView.sendOurVisibleRect();
            }
            mWebView.sendViewSizeZoom(flag);
        }
    }

    private boolean setupZoomOverviewWidth(WebViewCore.DrawData drawdata, int i) {
        WebSettingsClassic websettingsclassic = mWebView.getSettings();
        int j = mZoomOverviewWidth;
        boolean flag;
        if(websettingsclassic.getUseWideViewPort()) {
            if(drawdata.mContentSize.x > 0)
                j = Math.min(WebViewClassic.sMaxViewportWidth, drawdata.mContentSize.x);
        } else {
            j = Math.round((float)i / mDefaultScale);
        }
        if(j != mZoomOverviewWidth) {
            setZoomOverviewWidth(j);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    private boolean zoom(float f) {
        boolean flag = false;
        mInitialZoomOverview = false;
        mWebView.switchOutDrawHistory();
        mZoomCenterX = 0.5F * (float)mWebView.getViewWidth();
        mZoomCenterY = 0.5F * (float)mWebView.getViewHeight();
        mAnchorX = mWebView.viewToContentX((int)mZoomCenterX + mWebView.getScrollX());
        mAnchorY = mWebView.viewToContentY((int)mZoomCenterY + mWebView.getScrollY());
        float f1 = f * mActualScale;
        if(!mWebView.getSettings().getUseFixedViewport())
            flag = true;
        return startZoomAnimation(f1, flag);
    }

    private void zoomToOverview() {
        boolean flag = false;
        if(mWebView.getScrollY() < mWebView.getTitleHeight())
            mWebView.updateScrollCoordinates(mWebView.getScrollX(), 0);
        float f = getZoomOverviewScale();
        if(!mWebView.getSettings().getUseFixedViewport())
            flag = true;
        startZoomAnimation(f, flag);
    }

    private void zoomToReadingLevel() {
        boolean flag = false;
        float f = getReadingLevelScale();
        int i = mWebView.getBlockLeftEdge(mAnchorX, mAnchorY, f);
        if(i != -1) {
            WebViewClassic webviewclassic = mWebView;
            int j;
            int k;
            if(i < 5)
                j = 0;
            else
                j = i - 5;
            k = webviewclassic.contentToViewX(j) - mWebView.getScrollX();
            if(k > 0) {
                mZoomCenterX = (f * (float)k) / (f - mActualScale);
            } else {
                mWebView.getWebView().scrollBy(k, 0);
                mZoomCenterX = 0.0F;
            }
        }
        if(!mWebView.getSettings().getUseFixedViewport())
            flag = true;
        startZoomAnimation(f, flag);
    }

    public void animateZoom(Canvas canvas) {
        mInitialZoomOverview = false;
        if(mZoomScale != 0.0F) goto _L2; else goto _L1
_L1:
        Log.w("webviewZoom", "A WebView is attempting to perform a fixed length zoom animation when no zoom is in progress");
        mInHWAcceleratedZoom = false;
_L4:
        return;
_L2:
        int i = (int)(SystemClock.uptimeMillis() - mZoomStart);
        float f;
        float f1;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        if(i < 175) {
            float f2 = (float)i / 175F;
            f = 1.0F / (mInvInitialZoomScale + f2 * (mInvFinalZoomScale - mInvInitialZoomScale));
            mWebView.invalidate();
        } else {
            f = mZoomScale;
            mZoomScale = 0.0F;
            mWebView.onFixedLengthZoomAnimationEnd();
        }
        f1 = f * mInvInitialZoomScale;
        j = -WebViewClassic.pinLoc(Math.round(f1 * ((float)mInitialScrollX + mZoomCenterX) - mZoomCenterX), mWebView.getViewWidth(), Math.round(f * (float)mWebView.getContentWidth())) + mWebView.getScrollX();
        k = mWebView.getTitleHeight();
        l = Math.round(f1 * (((float)mInitialScrollY + mZoomCenterY) - (float)k) - (mZoomCenterY - (float)k));
        if(l <= k)
            i1 = Math.max(l, 0);
        else
            i1 = k + WebViewClassic.pinLoc(l - k, mWebView.getViewHeight(), Math.round(f * (float)mWebView.getContentHeight()));
        j1 = -i1 + mWebView.getScrollY();
        if(mHardwareAccelerated) {
            mWebView.updateScrollCoordinates(mWebView.getScrollX() - j, mWebView.getScrollY() - j1);
            canvas.translate(j, j1);
            setZoomScale(f, false);
            if(mZoomScale == 0.0F) {
                mInHWAcceleratedZoom = false;
                mWebView.sendViewSizeZoom(false);
            }
        } else {
            canvas.translate(j, j1);
            canvas.scale(f, f);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final boolean canZoomIn() {
        boolean flag;
        if(mMaxZoomScale - mActualScale > MINIMUM_SCALE_INCREMENT)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean canZoomOut() {
        boolean flag;
        if(mActualScale - mMinZoomScale > MINIMUM_SCALE_INCREMENT)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final void clearDocumentAnchor() {
        mAnchorY = 0;
        mAnchorX = 0;
    }

    final float computeReadingLevelScale(float f) {
        return Math.max(mDisplayDensity * mDoubleTapZoomFactor, f + MIN_DOUBLE_TAP_SCALE_INCREMENT);
    }

    public final float computeScaleWithLimits(float f) {
        if(f >= mMinZoomScale) goto _L2; else goto _L1
_L1:
        f = mMinZoomScale;
_L4:
        return f;
_L2:
        if(f > mMaxZoomScale)
            f = mMaxZoomScale;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void dismissZoomPicker() {
        ZoomControlBase zoomcontrolbase = getCurrentZoomControl();
        if(zoomcontrolbase != null)
            zoomcontrolbase.hide();
    }

    public final float getDefaultMaxZoomScale() {
        return mDefaultMaxZoomScale;
    }

    public final float getDefaultMinZoomScale() {
        return mDefaultMinZoomScale;
    }

    public final float getDefaultScale() {
        return mDefaultScale;
    }

    public final int getDocumentAnchorX() {
        return mAnchorX;
    }

    public final int getDocumentAnchorY() {
        return mAnchorY;
    }

    public View getExternalZoomPicker() {
        ZoomControlBase zoomcontrolbase = getCurrentZoomControl();
        ZoomControlExternal.ExtendedZoomControls extendedzoomcontrols;
        if(zoomcontrolbase != null && zoomcontrolbase == mExternalZoomControl)
            extendedzoomcontrols = mExternalZoomControl.getControls();
        else
            extendedzoomcontrols = null;
        return extendedzoomcontrols;
    }

    public final float getInvDefaultScale() {
        return mInvDefaultScale;
    }

    public final float getInvScale() {
        return mInvActualScale;
    }

    public final float getMaxZoomScale() {
        return mMaxZoomScale;
    }

    public final float getMinZoomScale() {
        return mMinZoomScale;
    }

    public final float getReadingLevelScale() {
        return computeScaleWithLimits(computeReadingLevelScale(getZoomOverviewScale()));
    }

    public final float getScale() {
        return mActualScale;
    }

    public ScaleGestureDetector getScaleGestureDetector() {
        return mScaleDetector;
    }

    public final float getTextWrapScale() {
        return mTextWrapScale;
    }

    float getZoomOverviewScale() {
        return (float)mWebView.getViewWidth() * mInvZoomOverviewWidth;
    }

    public void handleDoubleTap(float f, float f1) {
        boolean flag = false;
        mInitialZoomOverview = false;
        WebSettingsClassic websettingsclassic = mWebView.getSettings();
        if(isDoubleTapEnabled()) {
            setZoomCenter(f, f1);
            mAnchorX = mWebView.viewToContentX((int)f + mWebView.getScrollX());
            mAnchorY = mWebView.viewToContentY((int)f1 + mWebView.getScrollY());
            websettingsclassic.setDoubleTapToastCount(0);
            dismissZoomPicker();
            float f2;
            if(websettingsclassic.getUseFixedViewport())
                f2 = Math.max(mActualScale, getReadingLevelScale());
            else
                f2 = mActualScale;
            if(!exceedsMinScaleIncrement(mActualScale, mTextWrapScale))
                flag = true;
            if(flag || mInZoomOverview)
                mTextWrapScale = f2;
            if(websettingsclassic.isNarrowColumnLayout() && exceedsMinScaleIncrement(mTextWrapScale, f2) && !flag && !mInZoomOverview) {
                mTextWrapScale = f2;
                refreshZoomScale(true);
            } else
            if(!mInZoomOverview && willScaleTriggerZoom(getZoomOverviewScale())) {
                if(mTextWrapScale > getReadingLevelScale()) {
                    mTextWrapScale = getReadingLevelScale();
                    refreshZoomScale(true);
                }
                zoomToOverview();
            } else {
                zoomToReadingLevel();
            }
        }
    }

    public void init(float f) {
        if(!$assertionsDisabled && f <= 0.0F) {
            throw new AssertionError();
        } else {
            mDisplayDensity = f;
            setDefaultZoomScale(f);
            mActualScale = f;
            mInvActualScale = 1.0F / f;
            mTextWrapScale = getReadingLevelScale();
            return;
        }
    }

    public void invokeZoomPicker() {
        ZoomControlBase zoomcontrolbase = getCurrentZoomControl();
        if(zoomcontrolbase != null)
            zoomcontrolbase.show();
    }

    public boolean isDoubleTapEnabled() {
        WebSettingsClassic websettingsclassic = mWebView.getSettings();
        boolean flag;
        if(websettingsclassic != null && websettingsclassic.getUseWideViewPort())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isFixedLengthAnimationInProgress() {
        boolean flag;
        if(mZoomScale != 0.0F || mInHWAcceleratedZoom)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isInZoomOverview() {
        return mInZoomOverview;
    }

    public boolean isPreventingWebkitUpdates() {
        return isZoomAnimating();
    }

    public final boolean isScaleOverLimits(float f) {
        boolean flag;
        if(f <= mMinZoomScale || f >= mMaxZoomScale)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isZoomAnimating() {
        boolean flag;
        if(isFixedLengthAnimationInProgress() || mPinchToZoomAnimating)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isZoomPickerVisible() {
        ZoomControlBase zoomcontrolbase = getCurrentZoomControl();
        boolean flag;
        if(zoomcontrolbase != null)
            flag = zoomcontrolbase.isVisible();
        else
            flag = false;
        return flag;
    }

    public final boolean isZoomScaleFixed() {
        boolean flag;
        if(mMinZoomScale >= mMaxZoomScale)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void keepZoomPickerVisible() {
        ZoomControlBase zoomcontrolbase = getCurrentZoomControl();
        if(zoomcontrolbase != null && zoomcontrolbase == mExternalZoomControl)
            zoomcontrolbase.show();
    }

    public void onFirstLayout(WebViewCore.DrawData drawdata) {
        if(!$assertionsDisabled && drawdata == null)
            throw new AssertionError();
        if(!$assertionsDisabled && drawdata.mViewState == null)
            throw new AssertionError();
        if(!$assertionsDisabled && mWebView.getSettings() == null)
            throw new AssertionError();
        WebViewCore.ViewState viewstate = drawdata.mViewState;
        updateZoomRange(viewstate, drawdata.mViewSize.x, drawdata.mMinPrefWidth);
        setupZoomOverviewWidth(drawdata, mWebView.getViewWidth());
        float f = getZoomOverviewScale();
        WebSettingsClassic websettingsclassic = mWebView.getSettings();
        if(!mMinZoomScaleFixed || websettingsclassic.getUseWideViewPort()) {
            float f1;
            boolean flag;
            if(mInitialScale > 0.0F)
                f1 = Math.min(mInitialScale, f);
            else
                f1 = f;
            mMinZoomScale = f1;
            mMaxZoomScale = Math.max(mMaxZoomScale, mMinZoomScale);
        }
        if(!mWebView.drawHistory()) {
            float f2;
            boolean flag1;
            if(mInitialScale > 0.0F)
                f2 = mInitialScale;
            else
            if(viewstate.mIsRestored || viewstate.mViewScale > 0.0F) {
                float f3;
                if(viewstate.mViewScale > 0.0F)
                    f2 = viewstate.mViewScale;
                else
                    f2 = f;
                if(viewstate.mTextWrapScale > 0.0F)
                    f3 = viewstate.mTextWrapScale;
                else
                    f3 = getReadingLevelScale();
                mTextWrapScale = f3;
            } else {
                f2 = f;
                if(!websettingsclassic.getUseWideViewPort() || !websettingsclassic.getLoadWithOverviewMode())
                    f2 = Math.max(mDefaultScale, f2);
                if(websettingsclassic.isNarrowColumnLayout() && websettingsclassic.getUseFixedViewport())
                    mTextWrapScale = getReadingLevelScale();
            }
            flag = false;
            if(!viewstate.mIsRestored) {
                if(websettingsclassic.getUseFixedViewport()) {
                    f2 = Math.max(f2, f);
                    mTextWrapScale = Math.max(mTextWrapScale, f);
                }
                flag = exceedsMinScaleIncrement(mTextWrapScale, f2);
            }
            if(websettingsclassic.getLoadWithOverviewMode() && !exceedsMinScaleIncrement(f2, f))
                flag1 = true;
            else
                flag1 = false;
            mInitialZoomOverview = flag1;
            setZoomScale(f2, flag);
            updateZoomPicker();
        }
    }

    public boolean onNewPicture(WebViewCore.DrawData drawdata) {
        boolean flag = true;
        boolean flag1 = setupZoomOverviewWidth(drawdata, mWebView.getViewWidth());
        float f = getZoomOverviewScale();
        WebSettingsClassic websettingsclassic = mWebView.getSettings();
        boolean flag2;
        boolean flag3;
        boolean flag4;
        if(flag1 && websettingsclassic.isNarrowColumnLayout() && websettingsclassic.getUseFixedViewport() && (mInitialZoomOverview || mInZoomOverview))
            if(exceedsMinScaleIncrement(mTextWrapScale, mDefaultScale) || exceedsMinScaleIncrement(f, mDefaultScale))
                mTextWrapScale = getReadingLevelScale();
            else
                mTextWrapScale = f;
        if(!mMinZoomScaleFixed || websettingsclassic.getUseWideViewPort()) {
            mMinZoomScale = f;
            mMaxZoomScale = Math.max(mMaxZoomScale, mMinZoomScale);
        }
        flag2 = exceedsMinScaleIncrement(f, mActualScale);
        if(f - mActualScale >= MINIMUM_SCALE_INCREMENT)
            flag3 = flag;
        else
            flag3 = false;
        if(mInZoomOverview && !exceedsMinScaleIncrement(f, mDefaultScale))
            flag4 = flag;
        else
            flag4 = false;
        if(!mWebView.drawHistory() && (flag3 && websettingsclassic.getUseWideViewPort() || (mInitialZoomOverview || flag4) && flag2 && flag1)) {
            mInitialZoomOverview = false;
            if(willScaleTriggerZoom(mTextWrapScale) || mWebView.getSettings().getUseFixedViewport())
                flag = false;
            setZoomScale(f, flag);
        } else {
            if(flag2)
                flag = false;
            mInZoomOverview = flag;
        }
        if(drawdata.mFirstLayoutForNonStandardLoad && websettingsclassic.getLoadWithOverviewMode())
            mInitialZoomOverview = mInZoomOverview;
        return flag2;
    }

    void onPageFinished(String s) {
        mInitialZoomOverview = false;
    }

    public void onSizeChanged(int i, int j, int k, int l) {
        boolean flag = true;
        if(!isFixedLengthAnimationInProgress()) {
            int j1 = mWebView.getVisibleTitleHeight();
            mZoomCenterX = 0.0F;
            mZoomCenterY = j1;
            mAnchorX = mWebView.viewToContentX(mWebView.getScrollX());
            mAnchorY = mWebView.viewToContentY(j1 + mWebView.getScrollY());
        }
        boolean flag1;
        if(!mMinZoomScaleFixed) {
            float f = mWebView.getViewWidth();
            WebView webview;
            boolean flag2;
            int i1;
            if(mWebView.drawHistory())
                i1 = mWebView.getHistoryPictureWidth();
            else
                i1 = mZoomOverviewWidth;
            mMinZoomScale = Math.min(1.0F, f / (float)i1);
            if(mInitialScale > 0.0F && mInitialScale < mMinZoomScale)
                mMinZoomScale = mInitialScale;
        }
        dismissZoomPicker();
        webview = mWebView.getWebView();
        if(i != k && !mWebView.getSettings().getUseFixedViewport())
            flag1 = flag;
        else
            flag1 = false;
        flag2 = mInZoomOverview;
        if(i >= k)
            flag = false;
        webview.post(new PostScale(flag1, flag2, flag));
    }

    public void refreshZoomScale(boolean flag) {
        setZoomScale(mActualScale, flag, true);
    }

    public void restoreZoomState(Bundle bundle) {
        mActualScale = bundle.getFloat("scale", 1.0F);
        mInvActualScale = 1.0F / mActualScale;
        mTextWrapScale = bundle.getFloat("textwrapScale", mActualScale);
        mInZoomOverview = bundle.getBoolean("overview");
    }

    public void saveZoomState(Bundle bundle) {
        bundle.putFloat("scale", mActualScale);
        bundle.putFloat("textwrapScale", mTextWrapScale);
        bundle.putBoolean("overview", mInZoomOverview);
    }

    public void setHardwareAccelerated() {
        mHardwareAccelerated = true;
    }

    public final void setInitialScaleInPercent(int i) {
        mInitialScale = 0.01F * (float)i;
    }

    public final void setZoomCenter(float f, float f1) {
        mZoomCenterX = f;
        mZoomCenterY = f1;
    }

    public void setZoomScale(float f, boolean flag) {
        setZoomScale(f, flag, false);
    }

    public boolean startZoomAnimation(float f, boolean flag) {
        boolean flag1 = true;
        mInitialZoomOverview = false;
        float f1 = mActualScale;
        mInitialScrollX = mWebView.getScrollX();
        mInitialScrollY = mWebView.getScrollY();
        if(!exceedsMinScaleIncrement(f, getReadingLevelScale()))
            f = getReadingLevelScale();
        setZoomScale(f, flag);
        if(f1 != mActualScale) {
            if(mHardwareAccelerated)
                mInHWAcceleratedZoom = flag1;
            mZoomStart = SystemClock.uptimeMillis();
            mInvInitialZoomScale = 1.0F / f1;
            mInvFinalZoomScale = 1.0F / mActualScale;
            mZoomScale = mActualScale;
            mWebView.onFixedLengthZoomAnimationStart();
            mWebView.invalidate();
        } else {
            flag1 = false;
        }
        return flag1;
    }

    public boolean supportsMultiTouchZoom() {
        return mSupportMultiTouch;
    }

    public boolean supportsPanDuringZoom() {
        return mAllowPanAndScale;
    }

    public void updateDefaultZoomDensity(float f) {
        if(!$assertionsDisabled && f <= 0.0F)
            throw new AssertionError();
        if(Math.abs(f - mDefaultScale) > MINIMUM_SCALE_INCREMENT) {
            float f1 = mDefaultScale;
            mDisplayDensity = f;
            setDefaultZoomScale(f);
            float f2;
            if((double)f1 > 0.0D)
                f2 = f / f1;
            else
                f2 = 1.0F;
            setZoomScale(f2 * mActualScale, true);
        }
    }

    public void updateDoubleTapZoom(int i) {
        boolean flag;
        float f;
        if(mTextWrapScale - mActualScale < 0.1F)
            flag = true;
        else
            flag = false;
        mDoubleTapZoomFactor = (float)i / 100F;
        mTextWrapScale = getReadingLevelScale();
        if(flag)
            f = mTextWrapScale;
        else
            f = Math.min(mTextWrapScale, mActualScale);
        setZoomScale(f, true, true);
    }

    public void updateMultiTouchSupport(Context context) {
        boolean flag = false;
        if(!$assertionsDisabled && mWebView.getSettings() == null)
            throw new AssertionError();
        WebSettingsClassic websettingsclassic = mWebView.getSettings();
        PackageManager packagemanager = context.getPackageManager();
        boolean flag1;
        if((packagemanager.hasSystemFeature("android.hardware.touchscreen.multitouch") || packagemanager.hasSystemFeature("android.hardware.faketouch.multitouch.distinct")) && websettingsclassic.supportZoom() && websettingsclassic.getBuiltInZoomControls())
            flag1 = true;
        else
            flag1 = false;
        mSupportMultiTouch = flag1;
        if(packagemanager.hasSystemFeature("android.hardware.touchscreen.multitouch.distinct") || packagemanager.hasSystemFeature("android.hardware.faketouch.multitouch.distinct"))
            flag = true;
        mAllowPanAndScale = flag;
        if(!mSupportMultiTouch || mScaleDetector != null) goto _L2; else goto _L1
_L1:
        mScaleDetector = new ScaleGestureDetector(context, new ScaleDetectorListener());
_L4:
        return;
_L2:
        if(!mSupportMultiTouch && mScaleDetector != null)
            mScaleDetector = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void updateZoomPicker() {
        ZoomControlBase zoomcontrolbase = getCurrentZoomControl();
        if(zoomcontrolbase != null)
            zoomcontrolbase.update();
    }

    public void updateZoomRange(WebViewCore.ViewState viewstate, int i, int j) {
        if(viewstate.mMinScale == 0.0F) {
            if(viewstate.mMobileSite) {
                if(j > Math.max(0, i)) {
                    mMinZoomScale = (float)i / (float)j;
                    mMinZoomScaleFixed = false;
                } else {
                    mMinZoomScale = viewstate.mDefaultScale;
                    mMinZoomScaleFixed = true;
                }
            } else {
                mMinZoomScale = mDefaultMinZoomScale;
                mMinZoomScaleFixed = false;
            }
        } else {
            mMinZoomScale = viewstate.mMinScale;
            mMinZoomScaleFixed = true;
        }
        if(viewstate.mMaxScale == 0.0F)
            mMaxZoomScale = mDefaultMaxZoomScale;
        else
            mMaxZoomScale = viewstate.mMaxScale;
    }

    public boolean willScaleTriggerZoom(float f) {
        return exceedsMinScaleIncrement(f, mActualScale);
    }

    public boolean zoomIn() {
        return zoom(1.25F);
    }

    public boolean zoomOut() {
        return zoom(0.8F);
    }

    static final boolean $assertionsDisabled = false;
    protected static final float DEFAULT_MAX_ZOOM_SCALE_FACTOR = 4F;
    protected static final float DEFAULT_MIN_ZOOM_SCALE_FACTOR = 0.25F;
    static final String LOGTAG = "webviewZoom";
    private static float MINIMUM_SCALE_INCREMENT = 0F;
    private static float MINIMUM_SCALE_WITHOUT_JITTER = 0F;
    private static float MIN_DOUBLE_TAP_SCALE_INCREMENT = 0F;
    private static final int ZOOM_ANIMATION_LENGTH = 175;
    private float mActualScale;
    private boolean mAllowPanAndScale;
    private int mAnchorX;
    private int mAnchorY;
    private final CallbackProxy mCallbackProxy;
    private float mDefaultMaxZoomScale;
    private float mDefaultMinZoomScale;
    private float mDefaultScale;
    private float mDisplayDensity;
    private float mDoubleTapZoomFactor;
    private ZoomControlEmbedded mEmbeddedZoomControl;
    private ZoomControlExternal mExternalZoomControl;
    private FocusMovementQueue mFocusMovementQueue;
    private float mFocusX;
    private float mFocusY;
    private boolean mHardwareAccelerated;
    private boolean mInHWAcceleratedZoom;
    private boolean mInZoomOverview;
    private float mInitialScale;
    private int mInitialScrollX;
    private int mInitialScrollY;
    private boolean mInitialZoomOverview;
    private float mInvActualScale;
    private float mInvDefaultScale;
    private float mInvFinalZoomScale;
    private float mInvInitialZoomScale;
    private float mInvZoomOverviewWidth;
    private float mMaxZoomScale;
    private float mMinZoomScale;
    private boolean mMinZoomScaleFixed;
    private boolean mPinchToZoomAnimating;
    private ScaleGestureDetector mScaleDetector;
    private boolean mSupportMultiTouch;
    private float mTextWrapScale;
    private final WebViewClassic mWebView;
    private float mZoomCenterX;
    private float mZoomCenterY;
    private int mZoomOverviewWidth;
    private float mZoomScale;
    private long mZoomStart;

    static  {
        boolean flag;
        if(!android/webkit/ZoomManager.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
        MIN_DOUBLE_TAP_SCALE_INCREMENT = 0.5F;
        MINIMUM_SCALE_INCREMENT = 0.007F;
        MINIMUM_SCALE_WITHOUT_JITTER = 0.007F;
    }



/*
    static boolean access$1002(ZoomManager zoommanager, boolean flag) {
        zoommanager.mPinchToZoomAnimating = flag;
        return flag;
    }

*/


/*
    static boolean access$102(ZoomManager zoommanager, boolean flag) {
        zoommanager.mInitialZoomOverview = flag;
        return flag;
    }

*/



/*
    static int access$1202(ZoomManager zoommanager, int i) {
        zoommanager.mAnchorX = i;
        return i;
    }

*/



/*
    static int access$1402(ZoomManager zoommanager, int i) {
        zoommanager.mAnchorY = i;
        return i;
    }

*/







/*
    static float access$402(ZoomManager zoommanager, float f) {
        zoommanager.mFocusX = f;
        return f;
    }

*/



/*
    static float access$502(ZoomManager zoommanager, float f) {
        zoommanager.mFocusY = f;
        return f;
    }

*/


}
