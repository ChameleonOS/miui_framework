// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.ExtractEditText;
import android.os.*;
import android.text.*;
import android.text.method.*;
import android.text.style.*;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.*;
import android.view.inputmethod.*;
import com.android.internal.util.ArrayUtils;
import com.android.internal.widget.EditableInputConnection;
import java.util.*;

// Referenced classes of package android.widget:
//            TextView, PopupWindow, MiuiCursorController, SpellChecker, 
//            MagnifierController, Toast, LinearLayout, ListView, 
//            AdapterView, BaseAdapter

public class Editor {
    private class PastePanelOnClickListener
        implements android.view.View.OnClickListener {

        public void onClick(View view) {
            TextView textview1 = (TextView)view;
            mTextView.replaceText_internal(mMin, mMax, textview1.getText());
            stopTextSelectionMode();
            ((MiuiCursorController.InsertionPointCursorController)mController).onClipBoardPancelClick();
        }

        private MiuiCursorController mController;
        private int mMax;
        private int mMin;
        final Editor this$0;

        PastePanelOnClickListener(MiuiCursorController miuicursorcontroller, int i, int j) {
            this$0 = Editor.this;
            super();
            mController = miuicursorcontroller;
            mMin = i;
            mMax = j;
        }
    }

    static class InputMethodState {

        int mBatchEditNesting;
        int mChangedDelta;
        int mChangedEnd;
        int mChangedStart;
        boolean mContentChanged;
        boolean mCursorChanged;
        Rect mCursorRectInWindow;
        final ExtractedText mExtractedText = new ExtractedText();
        ExtractedTextRequest mExtractedTextRequest;
        boolean mSelectionModeChanged;
        float mTmpOffset[];
        RectF mTmpRectF;

        InputMethodState() {
            mCursorRectInWindow = new Rect();
            mTmpRectF = new RectF();
            mTmpOffset = new float[2];
        }
    }

    static class InputContentType {

        boolean enterDown;
        Bundle extras;
        int imeActionId;
        CharSequence imeActionLabel;
        int imeOptions;
        TextView.OnEditorActionListener onEditorActionListener;
        String privateImeOptions;

        InputContentType() {
            imeOptions = 0;
        }
    }

    private static class ErrorPopup extends PopupWindow {

        private int getResourceId(int i, int j) {
            if(i == 0) {
                TypedArray typedarray = mView.getContext().obtainStyledAttributes(android.R.styleable.Theme);
                i = typedarray.getResourceId(j, 0);
                typedarray.recycle();
            }
            return i;
        }

        void fixDirection(boolean flag) {
            mAbove = flag;
            TextView textview1;
            int i;
            if(flag)
                mPopupInlineErrorAboveBackgroundId = getResourceId(mPopupInlineErrorAboveBackgroundId, 219);
            else
                mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId, 218);
            textview1 = mView;
            if(flag)
                i = mPopupInlineErrorAboveBackgroundId;
            else
                i = mPopupInlineErrorBackgroundId;
            textview1.setBackgroundResource(i);
        }

        public void update(int i, int j, int k, int l, boolean flag) {
            super.update(i, j, k, l, flag);
            boolean flag1 = isAboveAnchor();
            if(flag1 != mAbove)
                fixDirection(flag1);
        }

        private boolean mAbove;
        private int mPopupInlineErrorAboveBackgroundId;
        private int mPopupInlineErrorBackgroundId;
        private final TextView mView;

        ErrorPopup(TextView textview1, int i, int j) {
            super(textview1, i, j);
            mAbove = false;
            mPopupInlineErrorBackgroundId = 0;
            mPopupInlineErrorAboveBackgroundId = 0;
            mView = textview1;
            mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId, 218);
            mView.setBackgroundResource(mPopupInlineErrorBackgroundId);
        }
    }

    private class CorrectionHighlighter {

        private void invalidate(boolean flag) {
            if(mTextView.getLayout() != null) {
                if(mTempRectF == null)
                    mTempRectF = new RectF();
                mPath.computeBounds(mTempRectF, false);
                int i = mTextView.getCompoundPaddingLeft();
                int j = mTextView.getExtendedPaddingTop() + mTextView.getVerticalOffset(true);
                if(flag)
                    mTextView.postInvalidateOnAnimation(i + (int)mTempRectF.left, j + (int)mTempRectF.top, i + (int)mTempRectF.right, j + (int)mTempRectF.bottom);
                else
                    mTextView.postInvalidate((int)mTempRectF.left, (int)mTempRectF.top, (int)mTempRectF.right, (int)mTempRectF.bottom);
            }
        }

        private void stopAnimation() {
            mCorrectionHighlighter = null;
        }

        private boolean updatePaint() {
            long l = SystemClock.uptimeMillis() - mFadingStartTime;
            boolean flag;
            if(l > 400L) {
                flag = false;
            } else {
                float f = 1.0F - (float)l / 400F;
                int i = Color.alpha(mTextView.mHighlightColor);
                int j = (0xffffff & mTextView.mHighlightColor) + ((int)(f * (float)i) << 24);
                mPaint.setColor(j);
                flag = true;
            }
            return flag;
        }

        private boolean updatePath() {
            Layout layout = mTextView.getLayout();
            boolean flag;
            if(layout == null) {
                flag = false;
            } else {
                int i = mTextView.getText().length();
                int j = Math.min(i, mStart);
                int k = Math.min(i, mEnd);
                mPath.reset();
                layout.getSelectionPath(j, k, mPath);
                flag = true;
            }
            return flag;
        }

        public void draw(Canvas canvas, int i) {
            if(updatePath() && updatePaint()) {
                if(i != 0)
                    canvas.translate(0.0F, i);
                canvas.drawPath(mPath, mPaint);
                if(i != 0)
                    canvas.translate(0.0F, -i);
                invalidate(true);
            } else {
                stopAnimation();
                invalidate(false);
            }
        }

        public void highlight(CorrectionInfo correctioninfo) {
            mStart = correctioninfo.getOffset();
            mEnd = mStart + correctioninfo.getNewText().length();
            mFadingStartTime = SystemClock.uptimeMillis();
            if(mStart < 0 || mEnd < 0)
                stopAnimation();
        }

        private static final int FADE_OUT_DURATION = 400;
        private int mEnd;
        private long mFadingStartTime;
        private final Paint mPaint = new Paint(1);
        private final Path mPath = new Path();
        private int mStart;
        private RectF mTempRectF;
        final Editor this$0;


        public CorrectionHighlighter() {
            this$0 = Editor.this;
            super();
            mPaint.setCompatibilityScaling(mTextView.getResources().getCompatibilityInfo().applicationScale);
            mPaint.setStyle(android.graphics.Paint.Style.FILL);
        }
    }

    class SelectionModifierCursorController
        implements CursorController {

        private void initDrawables() {
            if(mSelectHandleLeft == null)
                mSelectHandleLeft = mTextView.getContext().getResources().getDrawable(mTextView.mTextSelectHandleLeftRes);
            if(mSelectHandleRight == null)
                mSelectHandleRight = mTextView.getContext().getResources().getDrawable(mTextView.mTextSelectHandleRightRes);
        }

        private void initHandles() {
            if(mStartHandle == null)
                mStartHandle = new SelectionStartHandleView(mSelectHandleLeft, mSelectHandleRight);
            if(mEndHandle == null)
                mEndHandle = new SelectionEndHandleView(mSelectHandleRight, mSelectHandleLeft);
            mStartHandle.show();
            mEndHandle.show();
            mStartHandle.showActionPopupWindow(200);
            mEndHandle.setActionPopupWindow(mStartHandle.getActionPopupWindow());
            hideInsertionPointCursorController();
        }

        private void updateMinAndMaxOffsets(MotionEvent motionevent) {
            int i = motionevent.getPointerCount();
            for(int j = 0; j < i; j++) {
                int k = mTextView.getOffsetForPosition(motionevent.getX(j), motionevent.getY(j));
                if(k < mMinTouchOffset)
                    mMinTouchOffset = k;
                if(k > mMaxTouchOffset)
                    mMaxTouchOffset = k;
            }

        }

        public int getMaxTouchOffset() {
            return mMaxTouchOffset;
        }

        public int getMinTouchOffset() {
            return mMinTouchOffset;
        }

        public void hide() {
            if(mStartHandle != null)
                mStartHandle.hide();
            if(mEndHandle != null)
                mEndHandle.hide();
        }

        public boolean isSelectionStartDragged() {
            boolean flag;
            if(mStartHandle != null && mStartHandle.isDragging())
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void onDetached() {
            mTextView.getViewTreeObserver().removeOnTouchModeChangeListener(this);
            if(mStartHandle != null)
                mStartHandle.onDetached();
            if(mEndHandle != null)
                mEndHandle.onDetached();
        }

        public void onTouchEvent(MotionEvent motionevent) {
            motionevent.getActionMasked();
            JVM INSTR tableswitch 0 6: default 48
        //                       0 49
        //                       1 340
        //                       2 266
        //                       3 48
        //                       4 48
        //                       5 237
        //                       6 237;
               goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L5
_L1:
            return;
_L2:
            float f3 = motionevent.getX();
            float f4 = motionevent.getY();
            int j = mTextView.getOffsetForPosition(f3, f4);
            mMaxTouchOffset = j;
            mMinTouchOffset = j;
            if(mGestureStayedInTapRegion && SystemClock.uptimeMillis() - mPreviousTapUpTime <= (long)ViewConfiguration.getDoubleTapTimeout()) {
                float f5 = f3 - mDownPositionX;
                float f6 = f4 - mDownPositionY;
                float f7 = f5 * f5 + f6 * f6;
                int k = ViewConfiguration.get(mTextView.getContext()).getScaledDoubleTapSlop();
                boolean flag;
                if(f7 < (float)(k * k))
                    flag = true;
                else
                    flag = false;
                if(flag && isPositionOnText(f3, f4)) {
                    startSelectionActionMode();
                    mDiscardNextActionUp = true;
                }
            }
            mDownPositionX = f3;
            mDownPositionY = f4;
            mGestureStayedInTapRegion = true;
            continue; /* Loop/switch isn't completed */
_L5:
            if(mTextView.getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct"))
                updateMinAndMaxOffsets(motionevent);
            continue; /* Loop/switch isn't completed */
_L4:
            if(mGestureStayedInTapRegion) {
                float f = motionevent.getX() - mDownPositionX;
                float f1 = motionevent.getY() - mDownPositionY;
                float f2 = f * f + f1 * f1;
                int i = ViewConfiguration.get(mTextView.getContext()).getScaledDoubleTapTouchSlop();
                if(f2 > (float)(i * i))
                    mGestureStayedInTapRegion = false;
            }
            continue; /* Loop/switch isn't completed */
_L3:
            mPreviousTapUpTime = SystemClock.uptimeMillis();
            if(true) goto _L1; else goto _L6
_L6:
        }

        public void onTouchModeChanged(boolean flag) {
            if(!flag)
                hide();
        }

        public void resetTouchOffsets() {
            mMaxTouchOffset = -1;
            mMinTouchOffset = -1;
        }

        public void show() {
            if(!mTextView.isInBatchEditMode()) {
                initDrawables();
                initHandles();
                hideInsertionPointCursorController();
            }
        }

        private static final int DELAY_BEFORE_REPLACE_ACTION = 200;
        private float mDownPositionX;
        private float mDownPositionY;
        private SelectionEndHandleView mEndHandle;
        private boolean mGestureStayedInTapRegion;
        private int mMaxTouchOffset;
        private int mMinTouchOffset;
        private long mPreviousTapUpTime;
        private SelectionStartHandleView mStartHandle;
        final Editor this$0;

        SelectionModifierCursorController() {
            this$0 = Editor.this;
            super();
            mPreviousTapUpTime = 0L;
            resetTouchOffsets();
        }
    }

    private class InsertionPointCursorController
        implements CursorController {

        private InsertionHandleView getHandle() {
            if(mSelectHandleCenter == null)
                mSelectHandleCenter = mTextView.getResources().getDrawable(mTextView.mTextSelectHandleRes);
            if(mHandle == null)
                mHandle = new InsertionHandleView(mSelectHandleCenter);
            return mHandle;
        }

        public void hide() {
            if(mHandle != null)
                mHandle.hide();
        }

        public void onDetached() {
            mTextView.getViewTreeObserver().removeOnTouchModeChangeListener(this);
            if(mHandle != null)
                mHandle.onDetached();
        }

        public void onTouchModeChanged(boolean flag) {
            if(!flag)
                hide();
        }

        public void show() {
            getHandle().show();
        }

        public void showWithActionPopup() {
            getHandle().showWithActionPopup();
        }

        private InsertionHandleView mHandle;
        final Editor this$0;

        private InsertionPointCursorController() {
            this$0 = Editor.this;
            super();
        }
    }

    private static interface CursorController
        extends android.view.ViewTreeObserver.OnTouchModeChangeListener {

        public abstract void hide();

        public abstract void onDetached();

        public abstract void show();
    }

    private class SelectionEndHandleView extends HandleView {

        public int getCurrentCursorOffset() {
            return mTextView.getSelectionEnd();
        }

        protected int getHotspotX(Drawable drawable, boolean flag) {
            int i;
            if(flag)
                i = (3 * drawable.getIntrinsicWidth()) / 4;
            else
                i = drawable.getIntrinsicWidth() / 4;
            return i;
        }

        public void setActionPopupWindow(ActionPopupWindow actionpopupwindow) {
            super.mActionPopupWindow = actionpopupwindow;
        }

        public void updatePosition(float f, float f1) {
            int i = mTextView.getOffsetForPosition(f, f1);
            int j = mTextView.getSelectionStart();
            if(i <= j)
                i = Math.min(j + 1, mTextView.getText().length());
            positionAtCursorOffset(i, false);
        }

        public void updateSelection(int i) {
            Selection.setSelection((Spannable)mTextView.getText(), mTextView.getSelectionStart(), i);
            updateDrawable();
        }

        final Editor this$0;

        public SelectionEndHandleView(Drawable drawable, Drawable drawable1) {
            this$0 = Editor.this;
            super(drawable, drawable1);
        }
    }

    private class SelectionStartHandleView extends HandleView {

        public ActionPopupWindow getActionPopupWindow() {
            return super.mActionPopupWindow;
        }

        public int getCurrentCursorOffset() {
            return mTextView.getSelectionStart();
        }

        protected int getHotspotX(Drawable drawable, boolean flag) {
            int i;
            if(flag)
                i = drawable.getIntrinsicWidth() / 4;
            else
                i = (3 * drawable.getIntrinsicWidth()) / 4;
            return i;
        }

        public void updatePosition(float f, float f1) {
            int i = mTextView.getOffsetForPosition(f, f1);
            int j = mTextView.getSelectionEnd();
            if(i >= j)
                i = Math.max(0, j - 1);
            positionAtCursorOffset(i, false);
        }

        public void updateSelection(int i) {
            Selection.setSelection((Spannable)mTextView.getText(), i, mTextView.getSelectionEnd());
            updateDrawable();
        }

        final Editor this$0;

        public SelectionStartHandleView(Drawable drawable, Drawable drawable1) {
            this$0 = Editor.this;
            super(drawable, drawable1);
        }
    }

    private class InsertionHandleView extends HandleView {

        private void hideAfterDelay() {
            if(mHider == null)
                mHider = new Runnable() {

                    public void run() {
                        hide();
                    }

                    final InsertionHandleView this$1;

                 {
                    this$1 = InsertionHandleView.this;
                    super();
                }
                };
            else
                removeHiderCallback();
            mTextView.postDelayed(mHider, 4000L);
        }

        private void removeHiderCallback() {
            if(mHider != null)
                mTextView.removeCallbacks(mHider);
        }

        public int getCurrentCursorOffset() {
            return mTextView.getSelectionStart();
        }

        protected int getHotspotX(Drawable drawable, boolean flag) {
            return drawable.getIntrinsicWidth() / 2;
        }

        public void onDetached() {
            super.onDetached();
            removeHiderCallback();
        }

        void onHandleMoved() {
            super.onHandleMoved();
            removeHiderCallback();
        }

        public boolean onTouchEvent(MotionEvent motionevent) {
            boolean flag = super.onTouchEvent(motionevent);
            motionevent.getActionMasked();
            JVM INSTR tableswitch 0 3: default 40
        //                       0 42
        //                       1 61
        //                       2 40
        //                       3 168;
               goto _L1 _L2 _L3 _L1 _L4
_L1:
            return flag;
_L2:
            mDownPositionX = motionevent.getRawX();
            mDownPositionY = motionevent.getRawY();
            continue; /* Loop/switch isn't completed */
_L3:
            if(!offsetHasBeenChanged()) {
                float f = mDownPositionX - motionevent.getRawX();
                float f1 = mDownPositionY - motionevent.getRawY();
                float f2 = f * f + f1 * f1;
                int i = ViewConfiguration.get(mTextView.getContext()).getScaledTouchSlop();
                if(f2 < (float)(i * i))
                    if(super.mActionPopupWindow != null && super.mActionPopupWindow.isShowing())
                        super.mActionPopupWindow.hide();
                    else
                        showWithActionPopup();
            }
            hideAfterDelay();
            continue; /* Loop/switch isn't completed */
_L4:
            hideAfterDelay();
            if(true) goto _L1; else goto _L5
_L5:
        }

        public void show() {
            super.show();
            if(SystemClock.uptimeMillis() - TextView.LAST_CUT_OR_COPY_TIME < 15000L)
                showActionPopupWindow(0);
            hideAfterDelay();
        }

        public void showWithActionPopup() {
            show();
            showActionPopupWindow(0);
        }

        public void updatePosition(float f, float f1) {
            positionAtCursorOffset(mTextView.getOffsetForPosition(f, f1), false);
        }

        public void updateSelection(int i) {
            Selection.setSelection((Spannable)mTextView.getText(), i);
        }

        private static final int DELAY_BEFORE_HANDLE_FADES_OUT = 4000;
        private static final int RECENT_CUT_COPY_DURATION = 15000;
        private float mDownPositionX;
        private float mDownPositionY;
        private Runnable mHider;
        final Editor this$0;

        public InsertionHandleView(Drawable drawable) {
            this$0 = Editor.this;
            super(drawable, drawable);
        }
    }

    private abstract class HandleView extends View
        implements TextViewPositionListener {

        private void addPositionToTouchUpFilter(int i) {
            mPreviousOffsetIndex = (1 + mPreviousOffsetIndex) % 5;
            mPreviousOffsets[mPreviousOffsetIndex] = i;
            mPreviousOffsetsTimes[mPreviousOffsetIndex] = SystemClock.uptimeMillis();
            mNumberPreviousOffsets = 1 + mNumberPreviousOffsets;
        }

        private void filterOnTouchUp() {
            long l = SystemClock.uptimeMillis();
            int i = 0;
            int j = mPreviousOffsetIndex;
            int k;
            for(k = Math.min(mNumberPreviousOffsets, 5); i < k && l - mPreviousOffsetsTimes[j] < 150L; j = (5 + (mPreviousOffsetIndex - i)) % 5)
                i++;

            if(i > 0 && i < k && l - mPreviousOffsetsTimes[j] > 350L)
                positionAtCursorOffset(mPreviousOffsets[j], false);
        }

        private boolean isVisible() {
            boolean flag;
            if(mIsDragging)
                flag = true;
            else
            if(mTextView.isInBatchEditMode())
                flag = false;
            else
                flag = isPositionVisible(mPositionX + mHotspotX, mPositionY);
            return flag;
        }

        private void startTouchUpFilter(int i) {
            mNumberPreviousOffsets = 0;
            addPositionToTouchUpFilter(i);
        }

        protected void dismiss() {
            mIsDragging = false;
            mContainer.dismiss();
            onDetached();
        }

        public abstract int getCurrentCursorOffset();

        protected abstract int getHotspotX(Drawable drawable, boolean flag);

        public void hide() {
            dismiss();
            getPositionListener().removeSubscriber(this);
        }

        protected void hideActionPopupWindow() {
            if(mActionPopupShower != null)
                mTextView.removeCallbacks(mActionPopupShower);
            if(mActionPopupWindow != null)
                mActionPopupWindow.hide();
        }

        public boolean isDragging() {
            return mIsDragging;
        }

        public boolean isShowing() {
            return mContainer.isShowing();
        }

        public boolean offsetHasBeenChanged() {
            boolean flag = true;
            if(mNumberPreviousOffsets <= flag)
                flag = false;
            return flag;
        }

        public void onDetached() {
            hideActionPopupWindow();
        }

        protected void onDraw(Canvas canvas) {
            mDrawable.setBounds(0, 0, super.mRight - super.mLeft, super.mBottom - super.mTop);
            mDrawable.draw(canvas);
        }

        void onHandleMoved() {
            hideActionPopupWindow();
        }

        protected void onMeasure(int i, int j) {
            setMeasuredDimension(mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
        }

        public boolean onTouchEvent(MotionEvent motionevent) {
            motionevent.getActionMasked();
            JVM INSTR tableswitch 0 3: default 36
        //                       0 38
        //                       1 233
        //                       2 109
        //                       3 245;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            return true;
_L2:
            startTouchUpFilter(getCurrentCursorOffset());
            mTouchToWindowOffsetX = motionevent.getRawX() - (float)mPositionX;
            mTouchToWindowOffsetY = motionevent.getRawY() - (float)mPositionY;
            PositionListener positionlistener = getPositionListener();
            mLastParentX = positionlistener.getPositionX();
            mLastParentY = positionlistener.getPositionY();
            mIsDragging = true;
            continue; /* Loop/switch isn't completed */
_L4:
            float f = motionevent.getRawX();
            float f1 = motionevent.getRawY();
            float f2 = mTouchToWindowOffsetY - (float)mLastParentY;
            float f3 = f1 - (float)mPositionY - (float)mLastParentY;
            float f4;
            if(f2 < mIdealVerticalOffset)
                f4 = Math.max(Math.min(f3, mIdealVerticalOffset), f2);
            else
                f4 = Math.min(Math.max(f3, mIdealVerticalOffset), f2);
            mTouchToWindowOffsetY = f4 + (float)mLastParentY;
            updatePosition((f - mTouchToWindowOffsetX) + (float)mHotspotX, (f1 - mTouchToWindowOffsetY) + mTouchOffsetY);
            continue; /* Loop/switch isn't completed */
_L3:
            filterOnTouchUp();
            mIsDragging = false;
            continue; /* Loop/switch isn't completed */
_L5:
            mIsDragging = false;
            if(true) goto _L1; else goto _L6
_L6:
        }

        protected void positionAtCursorOffset(int i, boolean flag) {
            Layout layout = mTextView.getLayout();
            if(layout != null) goto _L2; else goto _L1
_L1:
            prepareCursorControllers();
_L4:
            return;
_L2:
            boolean flag1;
            if(i != mPreviousOffset)
                flag1 = true;
            else
                flag1 = false;
            if(flag1 || flag) {
                if(flag1) {
                    updateSelection(i);
                    addPositionToTouchUpFilter(i);
                }
                int j = layout.getLineForOffset(i);
                mPositionX = (int)(layout.getPrimaryHorizontal(i) - 0.5F - (float)mHotspotX);
                mPositionY = layout.getLineBottom(j);
                mPositionX = mPositionX + mTextView.viewportToContentHorizontalOffset();
                mPositionY = mPositionY + mTextView.viewportToContentVerticalOffset();
                mPreviousOffset = i;
                mPositionHasChanged = true;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void show() {
            if(!isShowing()) {
                getPositionListener().addSubscriber(this, true);
                mPreviousOffset = -1;
                positionAtCursorOffset(getCurrentCursorOffset(), false);
                hideActionPopupWindow();
            }
        }

        void showActionPopupWindow(int i) {
            if(mActionPopupWindow == null)
                mActionPopupWindow = new ActionPopupWindow();
            if(mActionPopupShower == null)
                mActionPopupShower = new Runnable() {

                    public void run() {
                        mActionPopupWindow.show();
                    }

                    final HandleView this$1;

                 {
                    this$1 = HandleView.this;
                    super();
                }
                };
            else
                mTextView.removeCallbacks(mActionPopupShower);
            mTextView.postDelayed(mActionPopupShower, i);
        }

        protected void updateDrawable() {
            int i = getCurrentCursorOffset();
            boolean flag = mTextView.getLayout().isRtlCharAt(i);
            Drawable drawable;
            if(flag)
                drawable = mDrawableRtl;
            else
                drawable = mDrawableLtr;
            mDrawable = drawable;
            mHotspotX = getHotspotX(mDrawable, flag);
        }

        public abstract void updatePosition(float f, float f1);

        public void updatePosition(int i, int j, boolean flag, boolean flag1) {
            positionAtCursorOffset(getCurrentCursorOffset(), flag1);
            if(!flag && !mPositionHasChanged) goto _L2; else goto _L1
_L1:
            if(mIsDragging) {
                if(i != mLastParentX || j != mLastParentY) {
                    mTouchToWindowOffsetX = mTouchToWindowOffsetX + (float)(i - mLastParentX);
                    mTouchToWindowOffsetY = mTouchToWindowOffsetY + (float)(j - mLastParentY);
                    mLastParentX = i;
                    mLastParentY = j;
                }
                onHandleMoved();
            }
            if(!isVisible()) goto _L4; else goto _L3
_L3:
            int k = i + mPositionX;
            int l = j + mPositionY;
            if(isShowing())
                mContainer.update(k, l, -1, -1);
            else
                mContainer.showAtLocation(mTextView, 0, k, l);
_L6:
            mPositionHasChanged = false;
_L2:
            return;
_L4:
            if(isShowing())
                dismiss();
            if(true) goto _L6; else goto _L5
_L5:
        }

        protected abstract void updateSelection(int i);

        private static final int HISTORY_SIZE = 5;
        private static final int TOUCH_UP_FILTER_DELAY_AFTER = 150;
        private static final int TOUCH_UP_FILTER_DELAY_BEFORE = 350;
        private Runnable mActionPopupShower;
        protected ActionPopupWindow mActionPopupWindow;
        private final PopupWindow mContainer;
        protected Drawable mDrawable;
        protected Drawable mDrawableLtr;
        protected Drawable mDrawableRtl;
        protected int mHotspotX;
        private float mIdealVerticalOffset;
        private boolean mIsDragging;
        private int mLastParentX;
        private int mLastParentY;
        private int mNumberPreviousOffsets;
        private boolean mPositionHasChanged;
        private int mPositionX;
        private int mPositionY;
        private int mPreviousOffset;
        private int mPreviousOffsetIndex;
        private final int mPreviousOffsets[] = new int[5];
        private final long mPreviousOffsetsTimes[] = new long[5];
        private float mTouchOffsetY;
        private float mTouchToWindowOffsetX;
        private float mTouchToWindowOffsetY;
        final Editor this$0;

        public HandleView(Drawable drawable, Drawable drawable1) {
            this$0 = Editor.this;
            super(mTextView.getContext());
            mPreviousOffset = -1;
            mPositionHasChanged = true;
            mPreviousOffsetIndex = 0;
            mNumberPreviousOffsets = 0;
            mContainer = new PopupWindow(mTextView.getContext(), null, 0x10102c8);
            mContainer.setSplitTouchEnabled(true);
            mContainer.setClippingEnabled(false);
            mContainer.setWindowLayoutType(1002);
            mContainer.setContentView(this);
            mDrawableLtr = drawable;
            mDrawableRtl = drawable1;
            updateDrawable();
            int i = mDrawable.getIntrinsicHeight();
            mTouchOffsetY = -0.3F * (float)i;
            mIdealVerticalOffset = 0.7F * (float)i;
        }
    }

    private class ActionPopupWindow extends PinnedPopupWindow
        implements android.view.View.OnClickListener {

        protected int clipVertically(int i) {
            if(i < 0) {
                int j = getTextOffset();
                Layout layout = mTextView.getLayout();
                int k = layout.getLineForOffset(j);
                i = i + (layout.getLineBottom(k) - layout.getLineTop(k)) + super.mContentView.getMeasuredHeight() + mTextView.getResources().getDrawable(mTextView.mTextSelectHandleRes).getIntrinsicHeight();
            }
            return i;
        }

        protected void createPopupWindow() {
            super.mPopupWindow = new PopupWindow(mTextView.getContext(), null, 0x10102c8);
            super.mPopupWindow.setClippingEnabled(true);
        }

        protected int getTextOffset() {
            return (mTextView.getSelectionStart() + mTextView.getSelectionEnd()) / 2;
        }

        protected int getVerticalLocalPosition(int i) {
            return mTextView.getLayout().getLineTop(i) - super.mContentView.getMeasuredHeight();
        }

        protected void initContentView() {
            LinearLayout linearlayout = new LinearLayout(mTextView.getContext());
            linearlayout.setOrientation(0);
            super.mContentView = linearlayout;
            super.mContentView.setBackgroundResource(0x10805b7);
            LayoutInflater layoutinflater = (LayoutInflater)mTextView.getContext().getSystemService("layout_inflater");
            android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-2, -2);
            mPasteTextView = (TextView)layoutinflater.inflate(0x10900b4, null);
            mPasteTextView.setLayoutParams(layoutparams);
            super.mContentView.addView(mPasteTextView);
            mPasteTextView.setText(0x104000b);
            mPasteTextView.setOnClickListener(this);
            mReplaceTextView = (TextView)layoutinflater.inflate(0x10900b4, null);
            mReplaceTextView.setLayoutParams(layoutparams);
            super.mContentView.addView(mReplaceTextView);
            mReplaceTextView.setText(0x10403bd);
            mReplaceTextView.setOnClickListener(this);
        }

        public void onClick(View view) {
            if(view != mPasteTextView || !mTextView.canPaste()) goto _L2; else goto _L1
_L1:
            mTextView.onTextContextMenuItem(0x1020022);
            hide();
_L4:
            return;
_L2:
            if(view == mReplaceTextView) {
                int i = (mTextView.getSelectionStart() + mTextView.getSelectionEnd()) / 2;
                stopSelectionActionMode();
                Selection.setSelection((Spannable)mTextView.getText(), i);
                showSuggestions();
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void show() {
            int i = 0;
            boolean flag = mTextView.canPaste();
            boolean flag1;
            TextView textview1;
            int j;
            TextView textview2;
            if(mTextView.isSuggestionsEnabled() && isCursorInsideSuggestionSpan())
                flag1 = true;
            else
                flag1 = false;
            textview1 = mPasteTextView;
            if(flag)
                j = 0;
            else
                j = 8;
            textview1.setVisibility(j);
            textview2 = mReplaceTextView;
            if(!flag1)
                i = 8;
            textview2.setVisibility(i);
            if(flag || flag1)
                super.show();
        }

        private static final int POPUP_TEXT_LAYOUT = 0x10900b4;
        private TextView mPasteTextView;
        private TextView mReplaceTextView;
        final Editor this$0;

        private ActionPopupWindow() {
            this$0 = Editor.this;
            super();
        }

    }

    private class SelectionActionModeCallback
        implements android.view.ActionMode.Callback {

        public boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem) {
            boolean flag;
            if(mCustomSelectionActionModeCallback != null && mCustomSelectionActionModeCallback.onActionItemClicked(actionmode, menuitem))
                flag = true;
            else
                flag = mTextView.onTextContextMenuItem(menuitem.getItemId());
            return flag;
        }

        public boolean onCreateActionMode(ActionMode actionmode, Menu menu) {
            boolean flag;
            flag = false;
            TypedArray typedarray = mTextView.getContext().obtainStyledAttributes(com.android.internal.R.styleable.SelectionModeDrawables);
            boolean flag1 = mTextView.getContext().getResources().getBoolean(0x1110036);
            actionmode.setTitle(mTextView.getContext().getString(0x10403bf));
            actionmode.setSubtitle(null);
            actionmode.setTitleOptionalHint(true);
            int i = 0;
            if(!flag1)
                i = typedarray.getResourceId(3, 0);
            menu.add(0, 0x102001f, 0, 0x104000d).setIcon(i).setAlphabeticShortcut('a').setShowAsAction(6);
            if(mTextView.canCut())
                menu.add(0, 0x1020020, 0, 0x1040003).setIcon(typedarray.getResourceId(0, 0)).setAlphabeticShortcut('x').setShowAsAction(6);
            if(mTextView.canCopy())
                menu.add(0, 0x1020021, 0, 0x1040001).setIcon(typedarray.getResourceId(1, 0)).setAlphabeticShortcut('c').setShowAsAction(6);
            if(mTextView.canPaste())
                menu.add(0, 0x1020022, 0, 0x104000b).setIcon(typedarray.getResourceId(2, 0)).setAlphabeticShortcut('v').setShowAsAction(6);
            typedarray.recycle();
            break MISSING_BLOCK_LABEL_277;
            if((mCustomSelectionActionModeCallback == null || mCustomSelectionActionModeCallback.onCreateActionMode(actionmode, menu)) && (menu.hasVisibleItems() || actionmode.getCustomView() != null)) {
                getSelectionController().show();
                mTextView.setHasTransientState(true);
                flag = true;
            }
            return flag;
        }

        public void onDestroyActionMode(ActionMode actionmode) {
            if(mCustomSelectionActionModeCallback != null)
                mCustomSelectionActionModeCallback.onDestroyActionMode(actionmode);
            if(!mPreserveDetachedSelection) {
                Selection.setSelection((Spannable)mTextView.getText(), mTextView.getSelectionEnd());
                mTextView.setHasTransientState(false);
            }
            if(mSelectionModifierCursorController != null)
                mSelectionModifierCursorController.hide();
            mSelectionActionMode = null;
        }

        public boolean onPrepareActionMode(ActionMode actionmode, Menu menu) {
            boolean flag;
            if(mCustomSelectionActionModeCallback != null)
                flag = mCustomSelectionActionModeCallback.onPrepareActionMode(actionmode, menu);
            else
                flag = true;
            return flag;
        }

        final Editor this$0;

        private SelectionActionModeCallback() {
            this$0 = Editor.this;
            super();
        }

    }

    private class SuggestionsPopupWindow extends PinnedPopupWindow
        implements AdapterView.OnItemClickListener {
        private class SuggestionSpanComparator
            implements Comparator {

            public int compare(SuggestionSpan suggestionspan, SuggestionSpan suggestionspan1) {
                int i;
                boolean flag;
                int j;
                int k;
                i = -1;
                flag = false;
                j = suggestionspan.getFlags();
                k = suggestionspan1.getFlags();
                if(j == k) goto _L2; else goto _L1
_L1:
                boolean flag2;
                boolean flag3;
                boolean flag1;
                if((j & 1) != 0)
                    flag1 = true;
                else
                    flag1 = false;
                if((k & 1) != 0)
                    flag2 = true;
                else
                    flag2 = false;
                if((j & 2) != 0)
                    flag3 = true;
                else
                    flag3 = false;
                if((k & 2) != 0)
                    flag = true;
                if(!flag1 || flag3) goto _L4; else goto _L3
_L3:
                return i;
_L4:
                if(flag2 && !flag) {
                    i = 1;
                    continue; /* Loop/switch isn't completed */
                }
                if(flag3)
                    continue; /* Loop/switch isn't completed */
                if(flag) {
                    i = 1;
                    continue; /* Loop/switch isn't completed */
                }
_L2:
                i = ((Integer)mSpansLengths.get(suggestionspan)).intValue() - ((Integer)mSpansLengths.get(suggestionspan1)).intValue();
                if(true) goto _L3; else goto _L5
_L5:
            }

            public volatile int compare(Object obj, Object obj1) {
                return compare((SuggestionSpan)obj, (SuggestionSpan)obj1);
            }

            final SuggestionsPopupWindow this$1;

            private SuggestionSpanComparator() {
                this$1 = SuggestionsPopupWindow.this;
                super();
            }

        }

        private class SuggestionAdapter extends BaseAdapter {

            public int getCount() {
                return mNumberOfSuggestions;
            }

            public Object getItem(int i) {
                return mSuggestionInfos[i];
            }

            public long getItemId(int i) {
                return (long)i;
            }

            public View getView(int i, View view, ViewGroup viewgroup) {
                TextView textview1 = (TextView)view;
                if(textview1 == null)
                    textview1 = (TextView)mInflater.inflate(mTextView.mTextEditSuggestionItemLayout, viewgroup, false);
                SuggestionInfo suggestioninfo = mSuggestionInfos[i];
                textview1.setText(suggestioninfo.text);
                if(suggestioninfo.suggestionIndex == -1)
                    textview1.setCompoundDrawablesWithIntrinsicBounds(0x1080359, 0, 0, 0);
                else
                if(suggestioninfo.suggestionIndex == -2)
                    textview1.setCompoundDrawablesWithIntrinsicBounds(0x108035a, 0, 0, 0);
                else
                    textview1.setCompoundDrawables(null, null, null, null);
                return textview1;
            }

            private LayoutInflater mInflater;
            final SuggestionsPopupWindow this$1;

            private SuggestionAdapter() {
                this$1 = SuggestionsPopupWindow.this;
                super();
                mInflater = (LayoutInflater)mTextView.getContext().getSystemService("layout_inflater");
            }

        }

        private class SuggestionInfo {

            TextAppearanceSpan highlightSpan;
            int suggestionEnd;
            int suggestionIndex;
            SuggestionSpan suggestionSpan;
            int suggestionStart;
            SpannableStringBuilder text;
            final SuggestionsPopupWindow this$1;

            private SuggestionInfo() {
                this$1 = SuggestionsPopupWindow.this;
                super();
                text = new SpannableStringBuilder();
                highlightSpan = new TextAppearanceSpan(mTextView.getContext(), 0x1030118);
            }

        }

        private class CustomPopupWindow extends PopupWindow {

            public void dismiss() {
                super.dismiss();
                getPositionListener().removeSubscriber(SuggestionsPopupWindow.this);
                ((Spannable)mTextView.getText()).removeSpan(mSuggestionRangeSpan);
                mTextView.setCursorVisible(mCursorWasVisibleBeforeSuggestions);
                if(hasInsertionController())
                    getInsertionController().show();
            }

            final SuggestionsPopupWindow this$1;

            public CustomPopupWindow(Context context, int i) {
                this$1 = SuggestionsPopupWindow.this;
                super(context, null, i);
            }
        }


        private SuggestionSpan[] getSuggestionSpans() {
            int i = mTextView.getSelectionStart();
            Spannable spannable = (Spannable)mTextView.getText();
            SuggestionSpan asuggestionspan[] = (SuggestionSpan[])spannable.getSpans(i, i, android/text/style/SuggestionSpan);
            mSpansLengths.clear();
            int j = asuggestionspan.length;
            for(int k = 0; k < j; k++) {
                SuggestionSpan suggestionspan = asuggestionspan[k];
                int l = spannable.getSpanStart(suggestionspan);
                int i1 = spannable.getSpanEnd(suggestionspan);
                mSpansLengths.put(suggestionspan, Integer.valueOf(i1 - l));
            }

            Arrays.sort(asuggestionspan, mSuggestionSpanComparator);
            return asuggestionspan;
        }

        private void highlightTextDifferences(SuggestionInfo suggestioninfo, int i, int j) {
            Spannable spannable = (Spannable)mTextView.getText();
            int k = spannable.getSpanStart(suggestioninfo.suggestionSpan);
            int l = spannable.getSpanEnd(suggestioninfo.suggestionSpan);
            suggestioninfo.suggestionStart = k - i;
            suggestioninfo.suggestionEnd = suggestioninfo.suggestionStart + suggestioninfo.text.length();
            suggestioninfo.text.setSpan(suggestioninfo.highlightSpan, 0, suggestioninfo.text.length(), 33);
            String s = spannable.toString();
            suggestioninfo.text.insert(0, s.substring(i, k));
            suggestioninfo.text.append(s.substring(l, j));
        }

        private boolean updateSuggestions() {
            Spannable spannable;
            SuggestionSpan asuggestionspan[];
            int i;
            spannable = (Spannable)mTextView.getText();
            asuggestionspan = getSuggestionSpans();
            i = asuggestionspan.length;
            if(i != 0) goto _L2; else goto _L1
_L1:
            boolean flag = false;
_L9:
            return flag;
_L2:
            int j;
            int k;
            SuggestionSpan suggestionspan;
            int l;
            int i1;
            mNumberOfSuggestions = 0;
            j = mTextView.getText().length();
            k = 0;
            suggestionspan = null;
            l = 0;
            i1 = 0;
_L5:
            SuggestionSpan suggestionspan1;
            int j2;
            int k2;
            String as[];
            int l2;
            int i3;
            if(i1 >= i)
                break MISSING_BLOCK_LABEL_345;
            suggestionspan1 = asuggestionspan[i1];
            j2 = spannable.getSpanStart(suggestionspan1);
            k2 = spannable.getSpanEnd(suggestionspan1);
            j = Math.min(j2, j);
            k = Math.max(k2, k);
            if((2 & suggestionspan1.getFlags()) != 0)
                suggestionspan = suggestionspan1;
            if(i1 == 0)
                l = suggestionspan1.getUnderlineColor();
            as = suggestionspan1.getSuggestions();
            l2 = as.length;
            i3 = 0;
_L7:
            if(i3 >= l2) goto _L4; else goto _L3
_L3:
            String s;
            boolean flag1;
            int j3;
            s = as[i3];
            flag1 = false;
            j3 = 0;
_L6:
            if(j3 < mNumberOfSuggestions) {
                if(!mSuggestionInfos[j3].text.toString().equals(s))
                    break MISSING_BLOCK_LABEL_333;
                SuggestionSpan suggestionspan2 = mSuggestionInfos[j3].suggestionSpan;
                int k3 = spannable.getSpanStart(suggestionspan2);
                int l3 = spannable.getSpanEnd(suggestionspan2);
                if(j2 != k3 || k2 != l3)
                    break MISSING_BLOCK_LABEL_333;
                flag1 = true;
            }
            if(flag1)
                break MISSING_BLOCK_LABEL_339;
            SuggestionInfo suggestioninfo2 = mSuggestionInfos[mNumberOfSuggestions];
            suggestioninfo2.suggestionSpan = suggestionspan1;
            suggestioninfo2.suggestionIndex = i3;
            suggestioninfo2.text.replace(0, suggestioninfo2.text.length(), s);
            mNumberOfSuggestions = 1 + mNumberOfSuggestions;
            if(mNumberOfSuggestions != 5)
                break MISSING_BLOCK_LABEL_339;
            i1 = i;
_L4:
            i1++;
              goto _L5
            j3++;
              goto _L6
            i3++;
              goto _L7
            for(int j1 = 0; j1 < mNumberOfSuggestions; j1++)
                highlightTextDifferences(mSuggestionInfos[j1], j, k);

            if(suggestionspan != null) {
                int l1 = spannable.getSpanStart(suggestionspan);
                int i2 = spannable.getSpanEnd(suggestionspan);
                if(l1 >= 0 && i2 > l1) {
                    SuggestionInfo suggestioninfo1 = mSuggestionInfos[mNumberOfSuggestions];
                    suggestioninfo1.suggestionSpan = suggestionspan;
                    suggestioninfo1.suggestionIndex = -1;
                    suggestioninfo1.text.replace(0, suggestioninfo1.text.length(), mTextView.getContext().getString(0x10403c0));
                    suggestioninfo1.text.setSpan(suggestioninfo1.highlightSpan, 0, 0, 33);
                    mNumberOfSuggestions = 1 + mNumberOfSuggestions;
                }
            }
            SuggestionInfo suggestioninfo = mSuggestionInfos[mNumberOfSuggestions];
            suggestioninfo.suggestionSpan = null;
            suggestioninfo.suggestionIndex = -2;
            suggestioninfo.text.replace(0, suggestioninfo.text.length(), mTextView.getContext().getString(0x10403c1));
            suggestioninfo.text.setSpan(suggestioninfo.highlightSpan, 0, 0, 33);
            mNumberOfSuggestions = 1 + mNumberOfSuggestions;
            if(mSuggestionRangeSpan == null)
                mSuggestionRangeSpan = new SuggestionRangeSpan();
            if(l == 0) {
                mSuggestionRangeSpan.setBackgroundColor(mTextView.mHighlightColor);
            } else {
                int k1 = (int)(0.4F * (float)Color.alpha(l));
                mSuggestionRangeSpan.setBackgroundColor((0xffffff & l) + (k1 << 24));
            }
            spannable.setSpan(mSuggestionRangeSpan, j, k, 33);
            mSuggestionsAdapter.notifyDataSetChanged();
            flag = true;
            if(true) goto _L9; else goto _L8
_L8:
        }

        protected int clipVertically(int i) {
            int j = super.mContentView.getMeasuredHeight();
            return Math.min(i, mTextView.getResources().getDisplayMetrics().heightPixels - j);
        }

        protected void createPopupWindow() {
            super.mPopupWindow = new CustomPopupWindow(mTextView.getContext(), 0x1010373);
            super.mPopupWindow.setInputMethodMode(2);
            super.mPopupWindow.setFocusable(true);
            super.mPopupWindow.setClippingEnabled(false);
        }

        protected int getTextOffset() {
            return mTextView.getSelectionStart();
        }

        protected int getVerticalLocalPosition(int i) {
            return mTextView.getLayout().getLineBottom(i);
        }

        public void hide() {
            super.hide();
        }

        protected void initContentView() {
            ListView listview = new ListView(mTextView.getContext());
            mSuggestionsAdapter = new SuggestionAdapter();
            listview.setAdapter(mSuggestionsAdapter);
            listview.setOnItemClickListener(this);
            super.mContentView = listview;
            mSuggestionInfos = new SuggestionInfo[7];
            for(int i = 0; i < mSuggestionInfos.length; i++)
                mSuggestionInfos[i] = new SuggestionInfo();

        }

        public boolean isShowingUp() {
            return mIsShowingUp;
        }

        protected void measureContent() {
            DisplayMetrics displaymetrics = mTextView.getResources().getDisplayMetrics();
            int i = android.view.View.MeasureSpec.makeMeasureSpec(displaymetrics.widthPixels, 0x80000000);
            int j = android.view.View.MeasureSpec.makeMeasureSpec(displaymetrics.heightPixels, 0x80000000);
            int k = 0;
            View view = null;
            for(int l = 0; l < mNumberOfSuggestions; l++) {
                view = mSuggestionsAdapter.getView(l, view, super.mContentView);
                view.getLayoutParams().width = -2;
                view.measure(i, j);
                k = Math.max(k, view.getMeasuredWidth());
            }

            super.mContentView.measure(android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000), j);
            Drawable drawable = super.mPopupWindow.getBackground();
            if(drawable != null) {
                if(mTempRect == null)
                    mTempRect = new Rect();
                drawable.getPadding(mTempRect);
                k += mTempRect.left + mTempRect.right;
            }
            super.mPopupWindow.setWidth(k);
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l) {
            Editable editable;
            SuggestionInfo suggestioninfo;
            editable = (Editable)mTextView.getText();
            suggestioninfo = mSuggestionInfos[i];
            if(suggestioninfo.suggestionIndex != -2) goto _L2; else goto _L1
_L1:
            int i3 = editable.getSpanStart(mSuggestionRangeSpan);
            int j3 = editable.getSpanEnd(mSuggestionRangeSpan);
            if(i3 >= 0 && j3 > i3) {
                if(j3 < editable.length() && Character.isSpaceChar(editable.charAt(j3)) && (i3 == 0 || Character.isSpaceChar(editable.charAt(i3 - 1))))
                    j3++;
                mTextView.deleteText_internal(i3, j3);
            }
            hide();
_L4:
            return;
_L2:
            int j;
            int k;
            String s;
            j = editable.getSpanStart(suggestioninfo.suggestionSpan);
            k = editable.getSpanEnd(suggestioninfo.suggestionSpan);
            if(j < 0 || k <= j) {
                hide();
                continue; /* Loop/switch isn't completed */
            }
            s = editable.toString().substring(j, k);
            if(suggestioninfo.suggestionIndex != -1)
                break; /* Loop/switch isn't completed */
            Intent intent = new Intent("com.android.settings.USER_DICTIONARY_INSERT");
            intent.putExtra("word", s);
            intent.putExtra("locale", mTextView.getTextServicesLocale().toString());
            intent.setFlags(0x10000000 | intent.getFlags());
            mTextView.getContext().startActivity(intent);
            editable.removeSpan(suggestioninfo.suggestionSpan);
            Selection.setSelection(editable, k);
            updateSpellCheckSpans(j, k, false);
_L5:
            hide();
            if(true) goto _L4; else goto _L3
_L3:
            SuggestionSpan asuggestionspan[] = (SuggestionSpan[])editable.getSpans(j, k, android/text/style/SuggestionSpan);
            int i1 = asuggestionspan.length;
            int ai[] = new int[i1];
            int ai1[] = new int[i1];
            int ai2[] = new int[i1];
            for(int j1 = 0; j1 < i1; j1++) {
                SuggestionSpan suggestionspan = asuggestionspan[j1];
                ai[j1] = editable.getSpanStart(suggestionspan);
                ai1[j1] = editable.getSpanEnd(suggestionspan);
                ai2[j1] = editable.getSpanFlags(suggestionspan);
                int l2 = suggestionspan.getFlags();
                if((l2 & 2) > 0)
                    suggestionspan.setFlags(-2 & (l2 & -3));
            }

            int k1 = suggestioninfo.suggestionStart;
            int l1 = suggestioninfo.suggestionEnd;
            String s1 = suggestioninfo.text.subSequence(k1, l1).toString();
            mTextView.replaceText_internal(j, k, s1);
            if(!TextUtils.isEmpty(suggestioninfo.suggestionSpan.getNotificationTargetClassName())) {
                InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
                if(inputmethodmanager != null)
                    inputmethodmanager.notifySuggestionPicked(suggestioninfo.suggestionSpan, s, suggestioninfo.suggestionIndex);
            }
            suggestioninfo.suggestionSpan.getSuggestions()[suggestioninfo.suggestionIndex] = s;
            int i2 = s1.length() - (k - j);
            for(int j2 = 0; j2 < i1; j2++)
                if(ai[j2] <= j && ai1[j2] >= k)
                    mTextView.setSpan_internal(asuggestionspan[j2], ai[j2], i2 + ai1[j2], ai2[j2]);

            int k2 = k + i2;
            mTextView.setCursorPosition_internal(k2, k2);
              goto _L5
            if(true) goto _L4; else goto _L6
_L6:
        }

        public void onParentLostFocus() {
            mIsShowingUp = false;
        }

        public void show() {
            if((mTextView.getText() instanceof Editable) && updateSuggestions()) {
                mCursorWasVisibleBeforeSuggestions = mCursorVisible;
                mTextView.setCursorVisible(false);
                mIsShowingUp = true;
                super.show();
            }
        }

        private static final int ADD_TO_DICTIONARY = -1;
        private static final int DELETE_TEXT = -2;
        private static final int MAX_NUMBER_SUGGESTIONS = 5;
        private boolean mCursorWasVisibleBeforeSuggestions;
        private boolean mIsShowingUp;
        private int mNumberOfSuggestions;
        private final HashMap mSpansLengths = new HashMap();
        private SuggestionInfo mSuggestionInfos[];
        private final Comparator mSuggestionSpanComparator = new SuggestionSpanComparator();
        private SuggestionAdapter mSuggestionsAdapter;
        final Editor this$0;





        public SuggestionsPopupWindow() {
            this$0 = Editor.this;
            super();
            mIsShowingUp = false;
            mCursorWasVisibleBeforeSuggestions = mCursorVisible;
        }
    }

    private abstract class PinnedPopupWindow
        implements TextViewPositionListener {

        private void computeLocalPosition() {
            measureContent();
            int i = mContentView.getMeasuredWidth();
            int j = getTextOffset();
            mPositionX = (int)(mTextView.getLayout().getPrimaryHorizontal(j) - (float)i / 2.0F);
            mPositionX = mPositionX + mTextView.viewportToContentHorizontalOffset();
            mPositionY = getVerticalLocalPosition(mTextView.getLayout().getLineForOffset(j));
            mPositionY = mPositionY + mTextView.viewportToContentVerticalOffset();
        }

        private void updatePosition(int i, int j) {
            int k = i + mPositionX;
            int l = clipVertically(j + mPositionY);
            DisplayMetrics displaymetrics = mTextView.getResources().getDisplayMetrics();
            int i1 = mContentView.getMeasuredWidth();
            int j1 = Math.max(0, Math.min(displaymetrics.widthPixels - i1, k));
            if(isShowing())
                mPopupWindow.update(j1, l, -1, -1);
            else
                mPopupWindow.showAtLocation(mTextView, 0, j1, l);
        }

        protected abstract int clipVertically(int i);

        protected abstract void createPopupWindow();

        protected abstract int getTextOffset();

        protected abstract int getVerticalLocalPosition(int i);

        public void hide() {
            mPopupWindow.dismiss();
            getPositionListener().removeSubscriber(this);
        }

        protected abstract void initContentView();

        public boolean isShowing() {
            return mPopupWindow.isShowing();
        }

        protected void measureContent() {
            DisplayMetrics displaymetrics = mTextView.getResources().getDisplayMetrics();
            mContentView.measure(android.view.View.MeasureSpec.makeMeasureSpec(displaymetrics.widthPixels, 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(displaymetrics.heightPixels, 0x80000000));
        }

        public void show() {
            getPositionListener().addSubscriber(this, false);
            computeLocalPosition();
            PositionListener positionlistener = getPositionListener();
            updatePosition(positionlistener.getPositionX(), positionlistener.getPositionY());
        }

        public void updatePosition(int i, int j, boolean flag, boolean flag1) {
            if(isShowing() && isOffsetVisible(getTextOffset())) {
                if(flag1)
                    computeLocalPosition();
                updatePosition(i, j);
            } else {
                hide();
            }
        }

        protected ViewGroup mContentView;
        protected PopupWindow mPopupWindow;
        int mPositionX;
        int mPositionY;
        final Editor this$0;

        public PinnedPopupWindow() {
            this$0 = Editor.this;
            super();
            createPopupWindow();
            mPopupWindow.setWindowLayoutType(1002);
            mPopupWindow.setWidth(-2);
            mPopupWindow.setHeight(-2);
            initContentView();
            android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-2, -2);
            mContentView.setLayoutParams(layoutparams);
            mPopupWindow.setContentView(mContentView);
        }
    }

    private class PositionListener
        implements android.view.ViewTreeObserver.OnPreDrawListener {

        private void updatePosition() {
            mTextView.getLocationInWindow(mTempCoords);
            boolean flag;
            if(mTempCoords[0] != mPositionX || mTempCoords[1] != mPositionY)
                flag = true;
            else
                flag = false;
            mPositionHasChanged = flag;
            mPositionX = mTempCoords[0];
            mPositionY = mTempCoords[1];
        }

        public void addSubscriber(TextViewPositionListener textviewpositionlistener, boolean flag) {
            int i;
            int j;
            if(mNumberOfListeners == 0) {
                updatePosition();
                mTextView.getViewTreeObserver().addOnPreDrawListener(this);
            }
            i = -1;
            j = 0;
_L5:
            if(j >= 6) goto _L2; else goto _L1
_L1:
            TextViewPositionListener textviewpositionlistener1 = mPositionListeners[j];
            if(textviewpositionlistener1 != textviewpositionlistener) goto _L4; else goto _L3
_L3:
            return;
_L4:
            if(i < 0 && textviewpositionlistener1 == null)
                i = j;
            j++;
              goto _L5
_L2:
            mPositionListeners[i] = textviewpositionlistener;
            mCanMove[i] = flag;
            mNumberOfListeners = 1 + mNumberOfListeners;
              goto _L3
        }

        public int getPositionX() {
            return mPositionX;
        }

        public int getPositionY() {
            return mPositionY;
        }

        public boolean onPreDraw() {
            updatePosition();
            for(int i = 0; i < 6; i++) {
                if(!mPositionHasChanged && !mScrollHasChanged && !mCanMove[i])
                    continue;
                TextViewPositionListener textviewpositionlistener = mPositionListeners[i];
                if(textviewpositionlistener != null)
                    textviewpositionlistener.updatePosition(mPositionX, mPositionY, mPositionHasChanged, mScrollHasChanged);
            }

            mScrollHasChanged = false;
            return true;
        }

        public void onScrollChanged() {
            mScrollHasChanged = true;
        }

        public void removeSubscriber(TextViewPositionListener textviewpositionlistener) {
            int i = 0;
            do {
label0:
                {
                    if(i < 6) {
                        if(mPositionListeners[i] != textviewpositionlistener)
                            break label0;
                        mPositionListeners[i] = null;
                        mNumberOfListeners = -1 + mNumberOfListeners;
                    }
                    if(mNumberOfListeners == 0)
                        mTextView.getViewTreeObserver().removeOnPreDrawListener(this);
                    return;
                }
                i++;
            } while(true);
        }

        private final int MAXIMUM_NUMBER_OF_LISTENERS;
        private boolean mCanMove[];
        private int mNumberOfListeners;
        private boolean mPositionHasChanged;
        private TextViewPositionListener mPositionListeners[];
        private int mPositionX;
        private int mPositionY;
        private boolean mScrollHasChanged;
        final int mTempCoords[];
        final Editor this$0;

        private PositionListener() {
            this$0 = Editor.this;
            super();
            MAXIMUM_NUMBER_OF_LISTENERS = 6;
            mPositionListeners = new TextViewPositionListener[6];
            mCanMove = new boolean[6];
            mPositionHasChanged = true;
            mTempCoords = new int[2];
        }

    }

    private class EasyEditPopupWindow extends PinnedPopupWindow
        implements android.view.View.OnClickListener {

        protected int clipVertically(int i) {
            return i;
        }

        protected void createPopupWindow() {
            super.mPopupWindow = new PopupWindow(mTextView.getContext(), null, 0x10102c8);
            super.mPopupWindow.setInputMethodMode(2);
            super.mPopupWindow.setClippingEnabled(true);
        }

        protected int getTextOffset() {
            return ((Editable)mTextView.getText()).getSpanEnd(mEasyEditSpan);
        }

        protected int getVerticalLocalPosition(int i) {
            return mTextView.getLayout().getLineBottom(i);
        }

        protected void initContentView() {
            LinearLayout linearlayout = new LinearLayout(mTextView.getContext());
            linearlayout.setOrientation(0);
            super.mContentView = linearlayout;
            super.mContentView.setBackgroundResource(0x10805b8);
            LayoutInflater layoutinflater = (LayoutInflater)mTextView.getContext().getSystemService("layout_inflater");
            android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-2, -2);
            mDeleteTextView = (TextView)layoutinflater.inflate(0x10900b4, null);
            mDeleteTextView.setLayoutParams(layoutparams);
            mDeleteTextView.setText(0x10403be);
            mDeleteTextView.setOnClickListener(this);
            super.mContentView.addView(mDeleteTextView);
        }

        public void onClick(View view) {
            if(view == mDeleteTextView) {
                Editable editable = (Editable)mTextView.getText();
                int i = editable.getSpanStart(mEasyEditSpan);
                int j = editable.getSpanEnd(mEasyEditSpan);
                if(i >= 0 && j >= 0)
                    mTextView.deleteText_internal(i, j);
            }
        }

        public void setEasyEditSpan(EasyEditSpan easyeditspan) {
            mEasyEditSpan = easyeditspan;
        }

        private static final int POPUP_TEXT_LAYOUT = 0x10900b4;
        private TextView mDeleteTextView;
        private EasyEditSpan mEasyEditSpan;
        final Editor this$0;


        private EasyEditPopupWindow() {
            this$0 = Editor.this;
            super();
        }

    }

    class EasyEditSpanController
        implements SpanWatcher {

        public void hide() {
            if(mPopupWindow != null) {
                mPopupWindow.hide();
                mTextView.removeCallbacks(mHidePopup);
            }
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i, int j) {
            if(obj instanceof EasyEditSpan) {
                if(mPopupWindow == null) {
                    mPopupWindow = new EasyEditPopupWindow();
                    mHidePopup = new Runnable() {

                        public void run() {
                            hide();
                        }

                        final EasyEditSpanController this$1;

                 {
                    this$1 = EasyEditSpanController.this;
                    super();
                }
                    };
                }
                if(mPopupWindow.mEasyEditSpan != null)
                    spannable.removeSpan(mPopupWindow.mEasyEditSpan);
                mPopupWindow.setEasyEditSpan((EasyEditSpan)obj);
                break MISSING_BLOCK_LABEL_76;
            }
_L1:
            return;
            if(mTextView.getWindowVisibility() == 0 && mTextView.getLayout() != null && !extractedTextModeWillBeStarted()) {
                mPopupWindow.show();
                mTextView.removeCallbacks(mHidePopup);
                mTextView.postDelayed(mHidePopup, 3000L);
            }
              goto _L1
        }

        public void onSpanChanged(Spannable spannable, Object obj, int i, int j, int k, int l) {
            if(mPopupWindow != null && obj == mPopupWindow.mEasyEditSpan)
                spannable.removeSpan(mPopupWindow.mEasyEditSpan);
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i, int j) {
            if(mPopupWindow != null && obj == mPopupWindow.mEasyEditSpan)
                hide();
        }

        private static final int DISPLAY_TIMEOUT_MS = 3000;
        private Runnable mHidePopup;
        private EasyEditPopupWindow mPopupWindow;
        final Editor this$0;

        EasyEditSpanController() {
            this$0 = Editor.this;
            super();
        }
    }

    private static class DragLocalState {

        public int end;
        public TextView sourceTextView;
        public int start;

        public DragLocalState(TextView textview1, int i, int j) {
            sourceTextView = textview1;
            start = i;
            end = j;
        }
    }

    private class Blink extends Handler
        implements Runnable {

        void cancel() {
            if(!mCancelled) {
                removeCallbacks(this);
                mCancelled = true;
            }
        }

        public void run() {
            if(!mCancelled) goto _L2; else goto _L1
_L1:
            return;
_L2:
            removeCallbacks(this);
            if(shouldBlink()) {
                if(mTextView.getLayout() != null)
                    mTextView.invalidateCursorPath();
                postAtTime(this, 500L + SystemClock.uptimeMillis());
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        void uncancel() {
            mCancelled = false;
        }

        private boolean mCancelled;
        final Editor this$0;

        private Blink() {
            this$0 = Editor.this;
            super();
        }

    }

    static interface TextViewPositionListener {

        public abstract void updatePosition(int i, int j, boolean flag, boolean flag1);
    }


    Editor(TextView textview1) {
        mIsInTextSelectionMode = false;
        mInputType = 0;
        mCursorVisible = true;
        mShowSoftInputOnFocus = true;
        mTextView = textview1;
        mContext = textview1.getContext();
    }

    private boolean canSelectText() {
        boolean flag;
        if(hasSelectionController() && mTextView.getText().length() != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void chooseSize(PopupWindow popupwindow, CharSequence charsequence, TextView textview1) {
        int i = textview1.getPaddingLeft() + textview1.getPaddingRight();
        int j = textview1.getPaddingTop() + textview1.getPaddingBottom();
        int k = mTextView.getResources().getDimensionPixelSize(0x1050049);
        StaticLayout staticlayout = new StaticLayout(charsequence, textview1.getPaint(), k, android.text.Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
        float f = 0.0F;
        for(int l = 0; l < staticlayout.getLineCount(); l++)
            f = Math.max(f, staticlayout.getLineWidth(l));

        popupwindow.setWidth(i + (int)Math.ceil(f));
        popupwindow.setHeight(j + staticlayout.getHeight());
    }

    private void downgradeEasyCorrectionSpans() {
        CharSequence charsequence = mTextView.getText();
        if(charsequence instanceof Spannable) {
            Spannable spannable = (Spannable)charsequence;
            SuggestionSpan asuggestionspan[] = (SuggestionSpan[])spannable.getSpans(0, spannable.length(), android/text/style/SuggestionSpan);
            for(int i = 0; i < asuggestionspan.length; i++) {
                int j = asuggestionspan[i].getFlags();
                if((j & 1) != 0 && (j & 2) == 0) {
                    int k = j & -2;
                    asuggestionspan[i].setFlags(k);
                }
            }

        }
    }

    private void drawCursor(Canvas canvas, int i) {
        boolean flag;
        if(i != 0)
            flag = true;
        else
            flag = false;
        if(flag)
            canvas.translate(0.0F, i);
        for(int j = 0; j < mCursorCount; j++)
            mCursorDrawable[j].draw(canvas);

        if(flag)
            canvas.translate(0.0F, -i);
    }

    private void drawHardwareAccelerated(Canvas canvas, Layout layout, Path path, Paint paint, int i) {
        int j;
        int k;
        long l = layout.getLineRangeForDraw(canvas);
        j = TextUtils.unpackRangeStartFromLong(l);
        k = TextUtils.unpackRangeEndFromLong(l);
        if(k >= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int ai[];
        int ai1[];
        int i1;
        int j1;
        int k1;
        int l1;
        layout.drawBackground(canvas, path, paint, i, j, k);
        if(!(layout instanceof DynamicLayout))
            break MISSING_BLOCK_LABEL_515;
        if(mTextDisplayLists == null)
            mTextDisplayLists = new DisplayList[ArrayUtils.idealObjectArraySize(0)];
        DynamicLayout dynamiclayout = (DynamicLayout)layout;
        ai = dynamiclayout.getBlockEndLines();
        ai1 = dynamiclayout.getBlockIndices();
        i1 = dynamiclayout.getNumberOfBlocks();
        j1 = -1;
        k1 = 0;
        l1 = 0;
_L4:
        int i2;
        DisplayList displaylist;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        HardwareCanvas hardwarecanvas;
        int l3;
        int i4;
        if(l1 >= i1)
            continue; /* Loop/switch isn't completed */
        i2 = ai[l1];
        int j2 = ai1[l1];
        boolean flag;
        if(j2 == -1)
            flag = true;
        else
            flag = false;
        if(flag) {
            j2 = getAvailableDisplayListIndex(ai1, i1, k1);
            ai1[l1] = j2;
            k1 = j2 + 1;
        }
        displaylist = mTextDisplayLists[j2];
        if(displaylist == null) {
            DisplayList adisplaylist[] = mTextDisplayLists;
            displaylist = mTextView.getHardwareRenderer().createDisplayList((new StringBuilder()).append("Text ").append(j2).toString());
            adisplaylist[j2] = displaylist;
        } else
        if(flag)
            displaylist.invalidate();
        if(displaylist.isValid())
            break MISSING_BLOCK_LABEL_459;
        k2 = j1 + 1;
        l2 = layout.getLineTop(k2);
        i3 = layout.getLineBottom(i2);
        j3 = 0;
        k3 = mTextView.getWidth();
        if(mTextView.getHorizontallyScrolling()) {
            float f = 3.402823E+38F;
            float f1 = 1.401298E-45F;
            for(int j4 = k2; j4 <= i2; j4++) {
                float f2 = layout.getLineLeft(j4);
                f = Math.min(f, f2);
                float f3 = layout.getLineRight(j4);
                f1 = Math.max(f1, f3);
            }

            j3 = (int)f;
            k3 = (int)(0.5F + f1);
        }
        hardwarecanvas = displaylist.start();
        l3 = k3 - j3;
        i4 = i3 - l2;
        hardwarecanvas.setViewport(l3, i4);
        hardwarecanvas.onPreDraw(null);
        hardwarecanvas.translate(-j3, -l2);
        layout.drawText(hardwarecanvas, k2, i2);
        hardwarecanvas.onPostDraw();
        displaylist.end();
        displaylist.setLeftTopRightBottom(j3, l2, k3, i3);
        displaylist.setClipChildren(false);
        ((HardwareCanvas)canvas).drawDisplayList(displaylist, null, 0);
        j1 = i2;
        l1++;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        hardwarecanvas.onPostDraw();
        displaylist.end();
        displaylist.setLeftTopRightBottom(j3, l2, k3, i3);
        displaylist.setClipChildren(false);
        throw exception;
        layout.drawText(canvas, j, k);
        if(true) goto _L1; else goto _L5
_L5:
    }

    private boolean extractTextInternal(ExtractedTextRequest extractedtextrequest, int i, int j, int k, ExtractedText extractedtext) {
        boolean flag = false;
        CharSequence charsequence = mTextView.getText();
        if(charsequence != null) {
            if(i != -2) {
                int l = charsequence.length();
                int i1;
                if(i < 0) {
                    extractedtext.partialEndOffset = -1;
                    extractedtext.partialStartOffset = -1;
                    i = 0;
                    i1 = l;
                } else {
                    i1 = j + k;
                    if(charsequence instanceof Spanned) {
                        Spanned spanned = (Spanned)charsequence;
                        Object aobj[] = spanned.getSpans(i, i1, android/text/ParcelableSpan);
                        int j1 = aobj.length;
                        do {
                            if(j1 <= 0)
                                break;
                            j1--;
                            int k1 = spanned.getSpanStart(aobj[j1]);
                            if(k1 < i)
                                i = k1;
                            int l1 = spanned.getSpanEnd(aobj[j1]);
                            if(l1 > i1)
                                i1 = l1;
                        } while(true);
                    }
                    extractedtext.partialStartOffset = i;
                    extractedtext.partialEndOffset = i1 - k;
                    if(i > l)
                        i = l;
                    else
                    if(i < 0)
                        i = 0;
                    if(i1 > l)
                        i1 = l;
                    else
                    if(i1 < 0)
                        i1 = 0;
                }
                if((1 & extractedtextrequest.flags) != 0)
                    extractedtext.text = charsequence.subSequence(i, i1);
                else
                    extractedtext.text = TextUtils.substring(charsequence, i, i1);
            } else {
                extractedtext.partialStartOffset = 0;
                extractedtext.partialEndOffset = 0;
                extractedtext.text = "";
            }
            extractedtext.flags = 0;
            if(MetaKeyKeyListener.getMetaState(charsequence, 2048) != 0)
                extractedtext.flags = 2 | extractedtext.flags;
            if(mTextView.isSingleLine())
                extractedtext.flags = 1 | extractedtext.flags;
            extractedtext.startOffset = 0;
            extractedtext.selectionStart = mTextView.getSelectionStart();
            extractedtext.selectionEnd = mTextView.getSelectionEnd();
            flag = true;
        }
        return flag;
    }

    private boolean extractedTextModeWillBeStarted() {
        boolean flag = false;
        if(!(mTextView instanceof ExtractEditText)) {
            InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
            if(inputmethodmanager != null && inputmethodmanager.isFullscreenMode())
                flag = true;
        }
        return flag;
    }

    private int getAvailableDisplayListIndex(int ai[], int i, int j) {
        int k = mTextDisplayLists.length;
        int l = j;
label0:
        do {
            if(l < k) {
                boolean flag = false;
                int i1 = 0;
label1:
                do {
label2:
                    {
                        if(i1 < i) {
                            if(ai[i1] != l)
                                break label2;
                            flag = true;
                        }
                        if(!flag)
                            break label1;
                        l++;
                        continue label0;
                    }
                    i1++;
                } while(true);
            } else {
                DisplayList adisplaylist[] = new DisplayList[ArrayUtils.idealIntArraySize(k + 1)];
                System.arraycopy(mTextDisplayLists, 0, adisplaylist, 0, k);
                mTextDisplayLists = adisplaylist;
                l = k;
            }
            return l;
        } while(true);
    }

    private long getCharRange(int i) {
        int j = mTextView.getText().length();
        if(i + 1 >= j || !Character.isSurrogatePair(mTextView.getText().charAt(i), mTextView.getText().charAt(i + 1))) goto _L2; else goto _L1
_L1:
        long l = TextUtils.packRangeInLong(i, i + 2);
_L4:
        return l;
_L2:
        if(i < j) {
            l = TextUtils.packRangeInLong(i, i + 1);
            continue; /* Loop/switch isn't completed */
        }
        if(i - 2 >= 0) {
            char c = mTextView.getText().charAt(i - 1);
            if(Character.isSurrogatePair(mTextView.getText().charAt(i - 2), c)) {
                l = TextUtils.packRangeInLong(i - 2, i);
                continue; /* Loop/switch isn't completed */
            }
        }
        if(i - 1 >= 0)
            l = TextUtils.packRangeInLong(i - 1, i);
        else
            l = TextUtils.packRangeInLong(i, i);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private int getErrorX() {
        float f = mTextView.getResources().getDisplayMetrics().density;
        TextView.Drawables drawables = mTextView.mDrawables;
        int i = mTextView.getWidth() - mErrorPopup.getWidth() - mTextView.getPaddingRight();
        int j;
        if(drawables != null)
            j = drawables.mDrawableSizeRight;
        else
            j = 0;
        return (i - j / 2) + (int)(0.5F + 25F * f);
    }

    private int getErrorY() {
        int i = 0;
        int j = mTextView.getCompoundPaddingTop();
        int k = mTextView.getBottom() - mTextView.getTop() - mTextView.getCompoundPaddingBottom() - j;
        TextView.Drawables drawables = mTextView.mDrawables;
        int l;
        int i1;
        float f;
        if(drawables != null)
            l = drawables.mDrawableHeightRight;
        else
            l = 0;
        i1 = j + (k - l) / 2;
        f = mTextView.getResources().getDisplayMetrics().density;
        if(drawables != null)
            i = drawables.mDrawableHeightRight;
        return (i1 + i) - mTextView.getHeight() - (int)(0.5F + 2.0F * f);
    }

    private int getLastTapPosition() {
        if(mSelectionModifierCursorController == null) goto _L2; else goto _L1
_L1:
        int i = mSelectionModifierCursorController.getMinTouchOffset();
        if(i < 0) goto _L2; else goto _L3
_L3:
        if(i > mTextView.getText().length())
            i = mTextView.getText().length();
_L5:
        return i;
_L2:
        i = -1;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private long getLastTouchOffsets() {
        MiuiCursorController miuicursorcontroller = getSelectionController();
        return TextUtils.packRangeInLong(miuicursorcontroller.getMinTouchOffset(), miuicursorcontroller.getMaxTouchOffset());
    }

    private PositionListener getPositionListener() {
        if(mPositionListener == null)
            mPositionListener = new PositionListener();
        return mPositionListener;
    }

    private float getPrimaryHorizontal(Layout layout, Layout layout1, int i) {
        float f;
        if(TextUtils.isEmpty(layout.getText()) && layout1 != null && !TextUtils.isEmpty(layout1.getText()))
            f = layout1.getPrimaryHorizontal(i);
        else
            f = layout.getPrimaryHorizontal(i);
        return f;
    }

    private android.view.View.DragShadowBuilder getTextThumbnailBuilder(CharSequence charsequence) {
        TextView textview1 = (TextView)View.inflate(mTextView.getContext(), 0x10900b3, null);
        if(textview1 == null)
            throw new IllegalArgumentException("Unable to inflate text drag thumbnail");
        if(charsequence.length() > DRAG_SHADOW_MAX_TEXT_LENGTH)
            charsequence = charsequence.subSequence(0, DRAG_SHADOW_MAX_TEXT_LENGTH);
        textview1.setText(charsequence);
        textview1.setTextColor(mTextView.getTextColors());
        textview1.setTextAppearance(mTextView.getContext(), 16);
        textview1.setGravity(17);
        textview1.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        int i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        textview1.measure(i, i);
        textview1.layout(0, 0, textview1.getMeasuredWidth(), textview1.getMeasuredHeight());
        textview1.invalidate();
        return new android.view.View.DragShadowBuilder(textview1);
    }

    private boolean hasPasswordTransformationMethod() {
        return mTextView.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    private void hideCursorControllers() {
        if(mSuggestionsPopupWindow != null && !mSuggestionsPopupWindow.isShowingUp())
            mSuggestionsPopupWindow.hide();
        hideInsertionPointCursorController();
        stopSelectionActionMode();
    }

    private void hideError() {
        if(mErrorPopup != null && mErrorPopup.isShowing())
            mErrorPopup.dismiss();
        mShowErrorAfterAttach = false;
    }

    private void hideInsertionPointCursorController() {
        if(mInsertionPointCursorController != null)
            mInsertionPointCursorController.hide();
    }

    private void hideSpanControllers() {
        if(mEasyEditSpanController != null)
            mEasyEditSpanController.hide();
    }

    private boolean isCursorInsideEasyCorrectionSpan() {
        SuggestionSpan asuggestionspan[];
        int i;
        asuggestionspan = (SuggestionSpan[])((Spannable)mTextView.getText()).getSpans(mTextView.getSelectionStart(), mTextView.getSelectionEnd(), android/text/style/SuggestionSpan);
        i = 0;
_L3:
        if(i >= asuggestionspan.length)
            break MISSING_BLOCK_LABEL_65;
        if((1 & asuggestionspan[i].getFlags()) == 0) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
    }

    private boolean isCursorInsideSuggestionSpan() {
        boolean flag;
        CharSequence charsequence;
        flag = false;
        charsequence = mTextView.getText();
        break MISSING_BLOCK_LABEL_10;
        if((charsequence instanceof Spannable) && ((SuggestionSpan[])((Spannable)charsequence).getSpans(mTextView.getSelectionStart(), mTextView.getSelectionEnd(), android/text/style/SuggestionSpan)).length > 0)
            flag = true;
        return flag;
    }

    private boolean isOffsetVisible(int i) {
        Layout layout = mTextView.getLayout();
        int j = layout.getLineBottom(layout.getLineForOffset(i));
        return isPositionVisible((int)layout.getPrimaryHorizontal(i) + mTextView.viewportToContentHorizontalOffset(), j + mTextView.viewportToContentVerticalOffset());
    }

    private boolean isPositionOnText(float f, float f1) {
        boolean flag;
        Layout layout;
        flag = false;
        layout = mTextView.getLayout();
        if(layout != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = mTextView.getLineAtCoordinate(f1);
        float f2 = mTextView.convertToLocalHorizontalCoordinate(f);
        if(f2 >= layout.getLineLeft(i) && f2 <= layout.getLineRight(i))
            flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean isPositionVisible(int i, int j) {
        boolean flag = false;
        float af[] = TEMP_POSITION;
        af;
        JVM INSTR monitorenter ;
        float af1[];
        Object obj;
        af1 = TEMP_POSITION;
        af1[0] = i;
        af1[1] = j;
        obj = mTextView;
_L5:
        if(obj == null) goto _L2; else goto _L1
_L1:
        if(obj != mTextView) {
            af1[0] = af1[0] - (float)((View) (obj)).getScrollX();
            af1[1] = af1[1] - (float)((View) (obj)).getScrollY();
        }
        if(af1[0] >= 0.0F && af1[1] >= 0.0F && af1[0] <= (float)((View) (obj)).getWidth() && af1[1] <= (float)((View) (obj)).getHeight()) goto _L4; else goto _L3
_L4:
        if(!((View) (obj)).getMatrix().isIdentity())
            ((View) (obj)).getMatrix().mapPoints(af1);
        af1[0] = af1[0] + (float)((View) (obj)).getLeft();
        af1[1] = af1[1] + (float)((View) (obj)).getTop();
        android.view.ViewParent viewparent = ((View) (obj)).getParent();
        if(viewparent instanceof View)
            obj = (View)viewparent;
        else
            obj = null;
        if(true) goto _L5; else goto _L2
_L2:
        af;
        JVM INSTR monitorexit ;
        flag = true;
_L3:
        return flag;
    }

    private void resumeBlink() {
        if(mBlink != null) {
            mBlink.uncancel();
            makeBlink();
        }
    }

    private boolean selectCurrentWord() {
        if(canSelectText()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L14:
        return flag;
_L2:
        if(!hasPasswordTransformationMethod()) goto _L4; else goto _L3
_L3:
        flag = mTextView.selectAllText();
          goto _L5
_L4:
        int j;
        int k;
        int i = mTextView.getInputType();
        j = i & 0xf;
        k = i & 0xff0;
        if(j != 2 && j != 3 && j != 4 && k != 16 && k != 32 && k != 208 && k != 176) goto _L7; else goto _L6
_L6:
        flag = mTextView.selectAllText();
          goto _L5
_L7:
        int i1;
        int j1;
        long l = getLastTouchOffsets();
        i1 = TextUtils.unpackRangeStartFromLong(l);
        j1 = TextUtils.unpackRangeEndFromLong(l);
        if(i1 >= 0 && i1 < mTextView.getText().length()) goto _L9; else goto _L8
_L8:
        flag = false;
          goto _L5
_L9:
        if(j1 >= 0 && j1 < mTextView.getText().length()) goto _L11; else goto _L10
_L10:
        flag = false;
          goto _L5
_L11:
        URLSpan aurlspan[] = (URLSpan[])((Spanned)mTextView.getText()).getSpans(i1, j1, android/text/style/URLSpan);
        if(aurlspan.length < 1) goto _L13; else goto _L12
_L12:
        int k1;
        int l1;
        URLSpan urlspan = aurlspan[0];
        k1 = ((Spanned)mTextView.getText()).getSpanStart(urlspan);
        l1 = ((Spanned)mTextView.getText()).getSpanEnd(urlspan);
_L15:
        Selection.setSelection((Spannable)mTextView.getText(), k1, l1);
        WordIterator worditerator;
        long l2;
        if(l1 > k1)
            flag = true;
        else
            flag = false;
_L5:
        if(true) goto _L14; else goto _L13
_L13:
        worditerator = getWordIterator();
        worditerator.setCharSequence(mTextView.getText(), i1, j1);
        k1 = worditerator.getBeginning(i1);
        l1 = worditerator.getEnd(j1);
        if(k1 == -1 || l1 == -1 || k1 == l1) {
            l2 = getCharRange(i1);
            k1 = TextUtils.unpackRangeStartFromLong(l2);
            l1 = TextUtils.unpackRangeEndFromLong(l2);
        }
          goto _L15
    }

    private boolean shouldBlink() {
        boolean flag = false;
        if(isCursorVisible() && mTextView.isFocused()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = mTextView.getSelectionStart();
        if(i >= 0) {
            int j = mTextView.getSelectionEnd();
            if(j >= 0 && i == j)
                flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void showError() {
        if(mTextView.getWindowToken() == null) {
            mShowErrorAfterAttach = true;
        } else {
            if(mErrorPopup == null) {
                TextView textview2 = (TextView)LayoutInflater.from(mTextView.getContext()).inflate(0x10900bb, null);
                float f = mTextView.getResources().getDisplayMetrics().density;
                mErrorPopup = new ErrorPopup(textview2, (int)(0.5F + 200F * f), (int)(0.5F + 50F * f));
                mErrorPopup.setFocusable(false);
                mErrorPopup.setInputMethodMode(1);
            }
            TextView textview1 = (TextView)mErrorPopup.getContentView();
            chooseSize(mErrorPopup, mError, textview1);
            textview1.setText(mError);
            mErrorPopup.showAsDropDown(mTextView, getErrorX(), getErrorY());
            mErrorPopup.fixDirection(mErrorPopup.isAboveAnchor());
        }
    }

    private void suspendBlink() {
        if(mBlink != null)
            mBlink.cancel();
    }

    private boolean touchPositionIsInSelection() {
        boolean flag = false;
        int i = mTextView.getSelectionStart();
        int j = mTextView.getSelectionEnd();
        if(i != j) {
            if(i > j) {
                int i1 = i;
                i = j;
                j = i1;
                Selection.setSelection((Spannable)mTextView.getText(), i, j);
            }
            MiuiCursorController miuicursorcontroller = getSelectionController();
            int k = miuicursorcontroller.getMinTouchOffset();
            int l = miuicursorcontroller.getMaxTouchOffset();
            boolean flag1;
            if(k >= i && l < j)
                flag1 = true;
            else
                flag1 = false;
            flag = flag1;
        }
        return flag;
    }

    private void updateCursorPosition(int i, int j, int k, float f) {
        if(mCursorDrawable[i] == null)
            mCursorDrawable[i] = mTextView.getResources().getDrawable(mTextView.mCursorDrawableRes);
        if(mTempRect == null)
            mTempRect = new Rect();
        mCursorDrawable[i].getPadding(mTempRect);
        int l = mCursorDrawable[i].getIntrinsicWidth();
        int i1 = (int)Math.max(0.5F, f - 0.5F) - mTempRect.left;
        mCursorDrawable[i].setBounds(i1, j - mTempRect.top, i1 + l, k + mTempRect.bottom);
    }

    private void updateSpellCheckSpans(int i, int j, boolean flag) {
        if(mTextView.isTextEditable() && mTextView.isSuggestionsEnabled() && !(mTextView instanceof ExtractEditText)) {
            if(mSpellChecker == null && flag)
                mSpellChecker = new SpellChecker(mTextView);
            if(mSpellChecker != null)
                mSpellChecker.spellCheck(i, j);
        }
    }

    void addPositionListenerSubscriber(TextViewPositionListener textviewpositionlistener, boolean flag) {
        getPositionListener().addSubscriber(textviewpositionlistener, flag);
    }

    public void addSpanWatchers(Spannable spannable) {
        int i = spannable.length();
        if(mKeyListener != null)
            spannable.setSpan(mKeyListener, 0, i, 18);
        if(mEasyEditSpanController == null)
            mEasyEditSpanController = new EasyEditSpanController();
        spannable.setSpan(mEasyEditSpanController, 0, i, 18);
    }

    void adjustInputType(boolean flag, boolean flag1, boolean flag2, boolean flag3) {
        if((0xf & mInputType) != 1) goto _L2; else goto _L1
_L1:
        if(flag || flag1)
            mInputType = 0x80 | 0xfffff00f & mInputType;
        if(flag2)
            mInputType = 0xe0 | 0xfffff00f & mInputType;
_L4:
        return;
_L2:
        if((0xf & mInputType) == 2 && flag3)
            mInputType = 0x10 | 0xfffff00f & mInputType;
        if(true) goto _L4; else goto _L3
_L3:
    }

    boolean areSuggestionsShown() {
        boolean flag;
        if(mSuggestionsPopupWindow != null && mSuggestionsPopupWindow.isShowing())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void beginBatchEdit() {
        mInBatchEditControllers = true;
        InputMethodState inputmethodstate = mInputMethodState;
        if(inputmethodstate != null) {
            int i = 1 + inputmethodstate.mBatchEditNesting;
            inputmethodstate.mBatchEditNesting = i;
            if(i == 1) {
                inputmethodstate.mCursorChanged = false;
                inputmethodstate.mChangedDelta = 0;
                if(inputmethodstate.mContentChanged) {
                    inputmethodstate.mChangedStart = 0;
                    inputmethodstate.mChangedEnd = mTextView.getText().length();
                } else {
                    inputmethodstate.mChangedStart = -1;
                    inputmethodstate.mChangedEnd = -1;
                    inputmethodstate.mContentChanged = false;
                }
                mTextView.onBeginBatchEdit();
            }
        }
    }

    void createInputContentTypeIfNeeded() {
        if(mInputContentType == null)
            mInputContentType = new InputContentType();
    }

    void createInputMethodStateIfNeeded() {
        if(mInputMethodState == null)
            mInputMethodState = new InputMethodState();
    }

    public void endBatchEdit() {
        mInBatchEditControllers = false;
        InputMethodState inputmethodstate = mInputMethodState;
        if(inputmethodstate != null) {
            int i = -1 + inputmethodstate.mBatchEditNesting;
            inputmethodstate.mBatchEditNesting = i;
            if(i == 0)
                finishBatchEdit(inputmethodstate);
        }
    }

    void ensureEndedBatchEdit() {
        InputMethodState inputmethodstate = mInputMethodState;
        if(inputmethodstate != null && inputmethodstate.mBatchEditNesting != 0) {
            inputmethodstate.mBatchEditNesting = 0;
            finishBatchEdit(inputmethodstate);
        }
    }

    boolean extractText(ExtractedTextRequest extractedtextrequest, ExtractedText extractedtext) {
        return extractTextInternal(extractedtextrequest, -1, -1, -1, extractedtext);
    }

    void finishBatchEdit(InputMethodState inputmethodstate) {
        mTextView.onEndBatchEdit();
        if(!inputmethodstate.mContentChanged && !inputmethodstate.mSelectionModeChanged) goto _L2; else goto _L1
_L1:
        mTextView.updateAfterEdit();
        reportExtractedText();
_L4:
        return;
_L2:
        if(inputmethodstate.mCursorChanged)
            mTextView.invalidateCursor();
        if(true) goto _L4; else goto _L3
_L3:
    }

    boolean getButtonShowHides(boolean flag, int i) {
        boolean flag1 = true;
        i;
        JVM INSTR tableswitch 101384213 101384218: default 40
    //                   101384213 114
    //                   101384214 125
    //                   101384215 52
    //                   101384216 69
    //                   101384217 44
    //                   101384218 44;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L6
_L1:
        flag1 = false;
_L12:
        return flag1;
_L6:
        flag1 = canSelectText();
        continue; /* Loop/switch isn't completed */
_L4:
        SecurityException securityexception;
        boolean flag2;
        ClipboardManager clipboardmanager;
        int j;
        if(!flag || !mTextView.canPaste())
            flag1 = false;
        continue; /* Loop/switch isn't completed */
_L5:
        clipboardmanager = (ClipboardManager)mContext.getSystemService("clipboard");
        if(clipboardmanager.getPrimaryClip() == null) goto _L8; else goto _L7
_L7:
        j = clipboardmanager.getPrimaryClip().getItemCount();
        if(!flag || j <= 0)
            flag1 = false;
        continue; /* Loop/switch isn't completed */
_L2:
        flag1 = mTextView.canCopy();
        continue; /* Loop/switch isn't completed */
_L3:
        if(!flag) goto _L10; else goto _L9
_L9:
        flag2 = mTextView.canCut();
        if(flag2)
            continue; /* Loop/switch isn't completed */
_L10:
        flag1 = false;
        continue; /* Loop/switch isn't completed */
        securityexception;
        Log.e("Editor", securityexception.toString());
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L8:
        flag1 = false;
        if(true) goto _L12; else goto _L11
_L11:
    }

    long getCharRangeWrap(int i) {
        return getCharRange(i);
    }

    ArrayList getFloatPanelShowHides(int ai[]) {
        ArrayList arraylist = new ArrayList();
        Boolean boolean1 = Boolean.valueOf(mTextView.isTextEditable());
        int i = ai.length;
        for(int j = 0; j < i; j++) {
            int k = ai[j];
            arraylist.add(Boolean.valueOf(getButtonShowHides(boolean1.booleanValue(), k)));
        }

        return arraylist;
    }

    MiuiCursorController getInsertionController() {
        MiuiCursorController miuicursorcontroller;
        if(!mInsertionControllerEnabled) {
            miuicursorcontroller = null;
        } else {
            if(mInsertionPointCursorController == null) {
                mInsertionPointCursorController = MiuiCursorController.create(this, mContext, 1);
                mTextView.getViewTreeObserver().addOnTouchModeChangeListener(mInsertionPointCursorController);
            }
            miuicursorcontroller = mInsertionPointCursorController;
        }
        return miuicursorcontroller;
    }

    long getLastCutOrCopyTime() {
        TextView _tmp = mTextView;
        return TextView.LAST_CUT_OR_COPY_TIME;
    }

    MagnifierController getMagnifierController() {
        MagnifierController magnifiercontroller = null;
        if(hasMagnifierController()) {
            if(mMagnifierController == null)
                mMagnifierController = new MagnifierController(mContext, this);
            magnifiercontroller = mMagnifierController;
        }
        return magnifiercontroller;
    }

    long getPositionListenerPostion() {
        return TextUtils.packRangeInLong(getPositionListener().getPositionX(), getPositionListener().getPositionY());
    }

    Drawable getSelectHandleCenterRes() {
        if(mSelectHandleCenter == null)
            mSelectHandleCenter = mContext.getResources().getDrawable(mTextView.mTextSelectHandleRes);
        return mSelectHandleCenter;
    }

    Drawable getSelectHandleLeftRes() {
        if(mSelectHandleLeft == null)
            mSelectHandleLeft = mContext.getResources().getDrawable(mTextView.mTextSelectHandleLeftRes);
        return mSelectHandleLeft;
    }

    Drawable getSelectHandleRightRes() {
        if(mSelectHandleRight == null)
            mSelectHandleRight = mContext.getResources().getDrawable(mTextView.mTextSelectHandleRightRes);
        return mSelectHandleRight;
    }

    int getSelectHandleWindowStyle() {
        return 0x10102c8;
    }

    MiuiCursorController getSelectionController() {
        MiuiCursorController miuicursorcontroller;
        if(!mSelectionControllerEnabled) {
            miuicursorcontroller = null;
        } else {
            if(mSelectionModifierCursorController == null) {
                mSelectionModifierCursorController = MiuiCursorController.create(this, mContext, 2);
                mTextView.getViewTreeObserver().addOnTouchModeChangeListener(mSelectionModifierCursorController);
            }
            miuicursorcontroller = mSelectionModifierCursorController;
        }
        return miuicursorcontroller;
    }

    public WordIterator getWordIterator() {
        if(mWordIterator == null)
            mWordIterator = new WordIterator(mTextView.getTextServicesLocale());
        return mWordIterator;
    }

    void handleFloatPanelClick(View view, MiuiCursorController miuicursorcontroller) {
        int i;
        int j;
        ClipboardManager clipboardmanager;
        ClipData clipdata;
        i = 0;
        j = mTextView.length();
        if(mTextView.isFocused()) {
            int k = mTextView.getSelectionStart();
            int l = mTextView.getSelectionEnd();
            i = Math.max(0, Math.min(k, l));
            j = Math.max(0, Math.max(k, l));
        }
        clipboardmanager = (ClipboardManager)mContext.getSystemService("clipboard");
        clipdata = clipboardmanager.getPrimaryClip();
        view.getId();
        JVM INSTR tableswitch 101384213 101384218: default 128
    //                   101384213 306
    //                   101384214 358
    //                   101384215 198
    //                   101384216 273
    //                   101384217 129
    //                   101384218 153;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return;
_L6:
        if(mSelectionControllerEnabled && startTextSelectionMode())
            getSelectionController().show();
        continue; /* Loop/switch isn't completed */
_L7:
        if(mSelectionControllerEnabled) {
            Selection.setSelection((Spannable)mTextView.getText(), 0, mTextView.length());
            if(startTextSelectionMode())
                getSelectionController().show();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        CharSequence charsequence = null;
        if(clipdata.getItemCount() > 0)
            charsequence = clipdata.getItemAt(0).coerceToText(mContext);
        if(charsequence != null && charsequence.length() > 0) {
            Selection.setSelection((Spannable)mTextView.getText(), j);
            mTextView.replaceText_internal(i, j, charsequence);
            stopTextSelectionMode();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if(clipdata != null) {
            PastePanelOnClickListener pastepanelonclicklistener = new PastePanelOnClickListener(miuicursorcontroller, i, j);
            ((MiuiCursorController.InsertionPointCursorController)miuicursorcontroller).setupClipBoardPanel(clipdata, pastepanelonclicklistener);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        ((MiuiCursorController.SelectionModifierCursorController)miuicursorcontroller).addClipData(clipboardmanager, clipdata, mTextView.getTransformedText(i, j));
        stopTextSelectionMode();
        Toast.makeText(mContext, mContext.getResources().getString(0x1040396), 0).show();
        continue; /* Loop/switch isn't completed */
_L3:
        ((MiuiCursorController.SelectionModifierCursorController)miuicursorcontroller).addClipData(clipboardmanager, clipdata, mTextView.getTransformedText(i, j));
        stopTextSelectionMode();
        mTextView.deleteText_internal(i, j);
        Toast.makeText(mContext, mContext.getResources().getString(0x1040396), 0).show();
        if(true) goto _L1; else goto _L8
_L8:
    }

    boolean hasInsertionController() {
        return mInsertionControllerEnabled;
    }

    boolean hasMagnifierController() {
        boolean flag;
        if(MagnifierController.isMagnifierEnabled(mContext) && mInsertionControllerEnabled && mSelectionControllerEnabled)
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean hasSelectionController() {
        return mSelectionControllerEnabled;
    }

    void hideControllers() {
        hideCursorControllers();
        hideSpanControllers();
    }

    void hideInsertionPointCursorControllerWrap() {
        hideInsertionPointCursorController();
    }

    void invalidateTextDisplayList() {
        if(mTextDisplayLists != null) {
            for(int i = 0; i < mTextDisplayLists.length; i++)
                if(mTextDisplayLists[i] != null)
                    mTextDisplayLists[i].invalidate();

        }
    }

    void invalidateTextDisplayList(Layout layout, int i, int j) {
        if(mTextDisplayLists == null || !(layout instanceof DynamicLayout)) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        int ai[];
        int ai1[];
        int i1;
        int j1;
        k = layout.getLineForOffset(i);
        l = layout.getLineForOffset(j);
        DynamicLayout dynamiclayout = (DynamicLayout)layout;
        ai = dynamiclayout.getBlockEndLines();
        ai1 = dynamiclayout.getBlockIndices();
        i1 = dynamiclayout.getNumberOfBlocks();
        j1 = 0;
_L5:
        if(j1 < i1 && ai[j1] < k) goto _L4; else goto _L3
_L3:
        if(j1 < i1) {
            int k1 = ai1[j1];
            if(k1 != -1)
                mTextDisplayLists[k1].invalidate();
            if(ai[j1] < l)
                break MISSING_BLOCK_LABEL_123;
        }
_L2:
        return;
_L4:
        j1++;
          goto _L5
        j1++;
          goto _L3
    }

    boolean isCursorVisible() {
        boolean flag;
        if(mCursorVisible && mTextView.isTextEditable())
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isOffsetVisibleWrap(int i) {
        return isOffsetVisible(i);
    }

    boolean isPositionVisibleWrap(int i, int j) {
        return isPositionVisible(i, j);
    }

    void makeBlink() {
        if(!shouldBlink()) goto _L2; else goto _L1
_L1:
        mShowCursor = SystemClock.uptimeMillis();
        if(mBlink == null)
            mBlink = new Blink();
        mBlink.removeCallbacks(mBlink);
        mBlink.postAtTime(mBlink, 500L + mShowCursor);
_L4:
        return;
_L2:
        if(mBlink != null)
            mBlink.removeCallbacks(mBlink);
        if(true) goto _L4; else goto _L3
_L3:
    }

    boolean needInsertPanel() {
        boolean flag;
        if(!mIsInTextSelectionMode && (canSelectText() || mTextView.canPaste()))
            flag = true;
        else
            flag = false;
        return flag;
    }

    void onAttachedToWindow() {
        if(mShowErrorAfterAttach) {
            showError();
            mShowErrorAfterAttach = false;
        }
        mTemporaryDetach = false;
        ViewTreeObserver viewtreeobserver = mTextView.getViewTreeObserver();
        if(mInsertionPointCursorController != null)
            viewtreeobserver.addOnTouchModeChangeListener(mInsertionPointCursorController);
        if(mSelectionModifierCursorController != null) {
            mSelectionModifierCursorController.resetTouchOffsets();
            viewtreeobserver.addOnTouchModeChangeListener(mSelectionModifierCursorController);
        }
        updateSpellCheckSpans(0, mTextView.getText().length(), true);
        if(mTextView.hasTransientState() && mTextView.getSelectionStart() != mTextView.getSelectionEnd()) {
            mTextView.setHasTransientState(false);
            startSelectionActionMode();
        }
    }

    public void onCommitCorrection(CorrectionInfo correctioninfo) {
        if(mCorrectionHighlighter == null)
            mCorrectionHighlighter = new CorrectionHighlighter();
        else
            mCorrectionHighlighter.invalidate(false);
        mCorrectionHighlighter.highlight(correctioninfo);
    }

    void onDetachedFromWindow() {
        if(mError != null)
            hideError();
        if(mBlink != null)
            mBlink.removeCallbacks(mBlink);
        if(mInsertionPointCursorController != null)
            mInsertionPointCursorController.onDetached();
        if(mSelectionModifierCursorController != null)
            mSelectionModifierCursorController.onDetached();
        if(mShowSuggestionRunnable != null)
            mTextView.removeCallbacks(mShowSuggestionRunnable);
        invalidateTextDisplayList();
        if(mSpellChecker != null) {
            mSpellChecker.closeSession();
            mSpellChecker = null;
        }
        mPreserveDetachedSelection = true;
        hideControllers();
        mPreserveDetachedSelection = false;
        mTemporaryDetach = false;
    }

    void onDraw(Canvas canvas, Layout layout, Path path, Paint paint, int i) {
        int j = mTextView.getSelectionStart();
        int k = mTextView.getSelectionEnd();
        InputMethodState inputmethodstate = mInputMethodState;
        if(inputmethodstate != null && inputmethodstate.mBatchEditNesting == 0) {
            InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
            if(inputmethodmanager != null) {
                if(inputmethodmanager.isActive(mTextView)) {
                    boolean flag = false;
                    if(inputmethodstate.mContentChanged || inputmethodstate.mSelectionModeChanged)
                        flag = reportExtractedText();
                    if(!flag && path != null) {
                        int l = -1;
                        int i1 = -1;
                        if(mTextView.getText() instanceof Spannable) {
                            Spannable spannable = (Spannable)mTextView.getText();
                            l = EditableInputConnection.getComposingSpanStart(spannable);
                            i1 = EditableInputConnection.getComposingSpanEnd(spannable);
                        }
                        inputmethodmanager.updateSelection(mTextView, j, k, l, i1);
                    }
                }
                if(inputmethodmanager.isWatchingCursor(mTextView) && path != null) {
                    RectF rectf = inputmethodstate.mTmpRectF;
                    path.computeBounds(rectf, true);
                    float af[] = inputmethodstate.mTmpOffset;
                    inputmethodstate.mTmpOffset[1] = 0.0F;
                    af[0] = 0.0F;
                    canvas.getMatrix().mapPoints(inputmethodstate.mTmpOffset);
                    inputmethodstate.mTmpRectF.offset(inputmethodstate.mTmpOffset[0], inputmethodstate.mTmpOffset[1]);
                    inputmethodstate.mTmpRectF.offset(0.0F, i);
                    inputmethodstate.mCursorRectInWindow.set((int)(0.5D + (double)inputmethodstate.mTmpRectF.left), (int)(0.5D + (double)inputmethodstate.mTmpRectF.top), (int)(0.5D + (double)inputmethodstate.mTmpRectF.right), (int)(0.5D + (double)inputmethodstate.mTmpRectF.bottom));
                    inputmethodmanager.updateCursor(mTextView, inputmethodstate.mCursorRectInWindow.left, inputmethodstate.mCursorRectInWindow.top, inputmethodstate.mCursorRectInWindow.right, inputmethodstate.mCursorRectInWindow.bottom);
                }
            }
        }
        if(mCorrectionHighlighter != null)
            mCorrectionHighlighter.draw(canvas, i);
        if(path != null && j == k && mCursorCount > 0) {
            drawCursor(canvas, i);
            path = null;
        }
        if(mTextView.canHaveDisplayList() && canvas.isHardwareAccelerated())
            drawHardwareAccelerated(canvas, layout, path, paint, i);
        else
            layout.draw(canvas, path, paint, i);
    }

    void onDrop(DragEvent dragevent) {
        StringBuilder stringbuilder;
        int k;
        DragLocalState draglocalstate;
        boolean flag;
        stringbuilder = new StringBuilder("");
        ClipData clipdata = dragevent.getClipData();
        int i = clipdata.getItemCount();
        for(int j = 0; j < i; j++)
            stringbuilder.append(clipdata.getItemAt(j).coerceToStyledText(mTextView.getContext()));

        k = mTextView.getOffsetForPosition(dragevent.getX(), dragevent.getY());
        Object obj = dragevent.getLocalState();
        draglocalstate = null;
        if(obj instanceof DragLocalState)
            draglocalstate = (DragLocalState)obj;
        if(draglocalstate != null && draglocalstate.sourceTextView == mTextView)
            flag = true;
        else
            flag = false;
        if(!flag || k < draglocalstate.start || k >= draglocalstate.end) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int l = mTextView.getText().length();
        long l1 = mTextView.prepareSpacesAroundPaste(k, k, stringbuilder);
        int i1 = TextUtils.unpackRangeStartFromLong(l1);
        int j1 = TextUtils.unpackRangeEndFromLong(l1);
        Selection.setSelection((Spannable)mTextView.getText(), j1);
        mTextView.replaceText_internal(i1, j1, stringbuilder);
        if(flag) {
            int k1 = draglocalstate.start;
            int i2 = draglocalstate.end;
            if(j1 <= k1) {
                int l2 = mTextView.getText().length() - l;
                k1 += l2;
                i2 += l2;
            }
            mTextView.deleteText_internal(k1, i2);
            CharSequence charsequence = mTextView.getTransformedText(k1 - 1, k1 + 1);
            if((k1 == 0 || Character.isSpaceChar(charsequence.charAt(0))) && (k1 == mTextView.getText().length() || Character.isSpaceChar(charsequence.charAt(1)))) {
                int j2;
                TextView textview1;
                int k2;
                if(k1 == mTextView.getText().length())
                    j2 = k1 - 1;
                else
                    j2 = k1;
                textview1 = mTextView;
                k2 = j2 + 1;
                textview1.deleteText_internal(j2, k2);
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    void onFocusChanged(boolean flag, int i) {
        mShowCursor = SystemClock.uptimeMillis();
        ensureEndedBatchEdit();
        if(!flag) goto _L2; else goto _L1
_L1:
        int l = mTextView.getSelectionStart();
        int i1 = mTextView.getSelectionEnd();
        boolean flag1;
        boolean flag2;
        if(mSelectAllOnFocus && l == 0 && i1 == mTextView.getText().length())
            flag1 = true;
        else
            flag1 = false;
        if(mFrozenWithFocus && mTextView.hasSelection() && !flag1)
            flag2 = true;
        else
            flag2 = false;
        mCreatedWithASelection = flag2;
        if(!mFrozenWithFocus || l < 0 || i1 < 0) {
            int j1 = getLastTapPosition();
            if(j1 >= 0)
                Selection.setSelection((Spannable)mTextView.getText(), j1);
            MovementMethod movementmethod = mTextView.getMovementMethod();
            if(movementmethod != null)
                movementmethod.onTakeFocus(mTextView, (Spannable)mTextView.getText(), i);
            if(((mTextView instanceof ExtractEditText) || mSelectionMoved) && l >= 0 && i1 >= 0)
                Selection.setSelection((Spannable)mTextView.getText(), l, i1);
            if(mSelectAllOnFocus)
                mTextView.selectAllText();
            mTouchFocusSelected = true;
        }
        mFrozenWithFocus = false;
        mSelectionMoved = false;
        if(mError != null)
            showError();
        makeBlink();
_L4:
        return;
_L2:
        if(mError != null)
            hideError();
        mTextView.onEndBatchEdit();
        if(mTextView instanceof ExtractEditText) {
            int j = mTextView.getSelectionStart();
            int k = mTextView.getSelectionEnd();
            hideControllers();
            Selection.setSelection((Spannable)mTextView.getText(), j, k);
        } else {
            if(mTemporaryDetach)
                mPreserveDetachedSelection = true;
            hideControllers();
            if(mTemporaryDetach)
                mPreserveDetachedSelection = false;
            downgradeEasyCorrectionSpans();
        }
        if(mSelectionModifierCursorController != null)
            mSelectionModifierCursorController.resetTouchOffsets();
        if(true) goto _L4; else goto _L3
_L3:
    }

    void onLocaleChanged() {
        mWordIterator = null;
    }

    void onScreenStateChanged(int i) {
        i;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 32
    //                   1 25;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        resumeBlink();
        continue; /* Loop/switch isn't completed */
_L2:
        suspendBlink();
        if(true) goto _L1; else goto _L4
_L4:
    }

    void onScrollChanged() {
        if(mPositionListener != null)
            mPositionListener.onScrollChanged();
    }

    void onTapUpEvent() {
        if(!mDiscardNextActionUp)
            stopTextSelectionMode();
    }

    boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag = false;
        if(!hasSelectionController() || !getSelectionController().onTouchEvent(motionevent)) goto _L2; else goto _L1
_L1:
        flag = true;
_L4:
        return flag;
_L2:
        if(mShowSuggestionRunnable != null) {
            mTextView.removeCallbacks(mShowSuggestionRunnable);
            mShowSuggestionRunnable = null;
        }
        if(motionevent.getActionMasked() == 0) {
            mLastDownPositionX = motionevent.getX();
            mLastDownPositionY = motionevent.getY();
            mTouchFocusSelected = false;
            mIgnoreActionUpEvent = false;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    void onTouchUpEvent(MotionEvent motionevent) {
        boolean flag;
        CharSequence charsequence;
        int i;
        if(mSelectAllOnFocus && mTextView.didTouchFocusSelect())
            flag = true;
        else
            flag = false;
        hideControllers();
        charsequence = mTextView.getText();
        if(flag || charsequence.length() < 0) goto _L2; else goto _L1
_L1:
        i = mTextView.getOffsetForPosition(motionevent.getX(), motionevent.getY());
        Selection.setSelection((Spannable)charsequence, i);
        if(mSpellChecker != null)
            mSpellChecker.onSelectionChanged();
        if(extractedTextModeWillBeStarted()) goto _L2; else goto _L3
_L3:
        if(!isCursorInsideEasyCorrectionSpan()) goto _L5; else goto _L4
_L4:
        mShowSuggestionRunnable = new Runnable() {

            public void run() {
                showSuggestions();
            }

            final Editor this$0;

             {
                this$0 = Editor.this;
                super();
            }
        };
        mTextView.postDelayed(mShowSuggestionRunnable, ViewConfiguration.getDoubleTapTimeout());
_L2:
        return;
_L5:
        if(hasInsertionController())
            getInsertionController().show();
        if(true) goto _L2; else goto _L6
_L6:
    }

    void onWindowFocusChanged(boolean flag) {
        if(flag) {
            if(mBlink != null) {
                mBlink.uncancel();
                makeBlink();
            }
        } else {
            if(mBlink != null)
                mBlink.cancel();
            if(mInputContentType != null)
                mInputContentType.enterDown = false;
            hideControllers();
            if(mSuggestionsPopupWindow != null)
                mSuggestionsPopupWindow.onParentLostFocus();
            mTextView.onEndBatchEdit();
        }
    }

    public boolean performLongClick(boolean flag) {
        boolean flag1 = false;
        boolean flag2 = false;
        if(hasMagnifierController()) {
            Log.i("MiuiMagnifierController", "performLongClick to show MagnifierController");
            stopTextSelectionMode();
            getSelectionController().hide();
            getInsertionController().hide();
            getMagnifierController().show();
            getInsertionController().show();
            mDiscardNextActionUp = true;
            flag1 = true;
        }
        if(!flag1)
            if(mIsInTextSelectionMode && touchPositionIsInSelection()) {
                stopTextSelectionMode();
                flag1 = true;
            } else {
                stopTextSelectionMode();
                flag1 = startTextSelectionMode();
                flag2 = flag1;
            }
        if(flag2)
            mTextView.performHapticFeedback(0);
        if(flag1)
            mDiscardNextActionUp = true;
        return flag1;
    }

    void prepareCursorControllers() {
        boolean flag = true;
        boolean flag1 = false;
        android.view.ViewGroup.LayoutParams layoutparams = mTextView.getRootView().getLayoutParams();
        boolean flag2;
        boolean flag3;
        if(layoutparams instanceof android.view.WindowManager.LayoutParams) {
            android.view.WindowManager.LayoutParams layoutparams1 = (android.view.WindowManager.LayoutParams)layoutparams;
            if(layoutparams1.type < 1000 || layoutparams1.type > 1999)
                flag1 = flag;
            else
                flag1 = false;
        }
        if(flag1 && mTextView.getLayout() != null)
            flag2 = flag;
        else
            flag2 = false;
        if(flag2 && isCursorVisible())
            flag3 = flag;
        else
            flag3 = false;
        mInsertionControllerEnabled = flag3;
        if(!flag2 || !mTextView.textCanBeSelected())
            flag = false;
        mSelectionControllerEnabled = flag;
        if(!mInsertionControllerEnabled) {
            hideInsertionPointCursorController();
            if(mInsertionPointCursorController != null) {
                mInsertionPointCursorController.onDetached();
                mInsertionPointCursorController = null;
            }
        }
        if(!mSelectionControllerEnabled) {
            stopSelectionActionMode();
            if(mSelectionModifierCursorController != null) {
                mSelectionModifierCursorController.onDetached();
                mSelectionModifierCursorController = null;
            }
        }
        if(!hasMagnifierController())
            mMagnifierController = null;
    }

    void removePositionListenerSubscriber(TextViewPositionListener textviewpositionlistener) {
        getPositionListener().removeSubscriber(textviewpositionlistener);
    }

    boolean reportExtractedText() {
        InputMethodState inputmethodstate = mInputMethodState;
        if(inputmethodstate == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = inputmethodstate.mContentChanged;
        if(!flag1 && !inputmethodstate.mSelectionModeChanged) goto _L2; else goto _L3
_L3:
        ExtractedTextRequest extractedtextrequest;
        inputmethodstate.mContentChanged = false;
        inputmethodstate.mSelectionModeChanged = false;
        extractedtextrequest = inputmethodstate.mExtractedTextRequest;
        if(extractedtextrequest == null) goto _L2; else goto _L4
_L4:
        InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
        if(inputmethodmanager == null) goto _L2; else goto _L5
_L5:
        if(inputmethodstate.mChangedStart < 0 && !flag1)
            inputmethodstate.mChangedStart = -2;
        if(!extractTextInternal(extractedtextrequest, inputmethodstate.mChangedStart, inputmethodstate.mChangedEnd, inputmethodstate.mChangedDelta, inputmethodstate.mExtractedText)) goto _L2; else goto _L6
_L6:
        boolean flag;
        inputmethodmanager.updateExtractedText(mTextView, extractedtextrequest.token, inputmethodstate.mExtractedText);
        inputmethodstate.mChangedStart = -1;
        inputmethodstate.mChangedEnd = -1;
        inputmethodstate.mChangedDelta = 0;
        inputmethodstate.mContentChanged = false;
        flag = true;
_L8:
        return flag;
_L2:
        flag = false;
        if(true) goto _L8; else goto _L7
_L7:
    }

    boolean selectAllWrap() {
        return mTextView.selectAllText();
    }

    void sendOnTextChanged(int i, int j) {
        updateSpellCheckSpans(i, i + j, false);
        hideCursorControllers();
    }

    public void setError(CharSequence charsequence, Drawable drawable) {
        TextView.Drawables drawables;
        mError = TextUtils.stringOrSpannedString(charsequence);
        mErrorWasChanged = true;
        drawables = mTextView.mDrawables;
        if(drawables == null)
            break MISSING_BLOCK_LABEL_132;
        mTextView.getResolvedLayoutDirection();
        JVM INSTR tableswitch 1 1: default 52
    //                   1 109;
           goto _L1 _L2
_L1:
        mTextView.setCompoundDrawables(drawables.mDrawableLeft, drawables.mDrawableTop, drawable, drawables.mDrawableBottom);
_L3:
        if(mError == null) {
            if(mErrorPopup != null) {
                if(mErrorPopup.isShowing())
                    mErrorPopup.dismiss();
                mErrorPopup = null;
            }
        } else
        if(mTextView.isFocused())
            showError();
        return;
_L2:
        mTextView.setCompoundDrawables(drawable, drawables.mDrawableTop, drawables.mDrawableRight, drawables.mDrawableBottom);
          goto _L3
        mTextView.setCompoundDrawables(null, null, drawable, null);
          goto _L3
    }

    void setFrame() {
        if(mErrorPopup != null) {
            TextView textview1 = (TextView)mErrorPopup.getContentView();
            chooseSize(mErrorPopup, mError, textview1);
            mErrorPopup.update(mTextView, getErrorX(), getErrorY(), mErrorPopup.getWidth(), mErrorPopup.getHeight());
        }
    }

    void setTextSelection(int i) {
        Spannable spannable = (Spannable)mTextView.getText();
        int j = i;
        int k = i;
        int l = EditableInputConnection.getComposingSpanStart(spannable);
        int i1 = EditableInputConnection.getComposingSpanEnd(spannable);
        if(l >= 0 && i1 >= 0 && l != i1) {
            k = Math.max(l, i1);
            j = k;
        }
        Selection.setSelection((Spannable)mTextView.getText(), j, k);
    }

    void setTextSelectionWrap(int i, int j) {
        Selection.setSelection((Spannable)mTextView.getText(), i, j);
    }

    void showSuggestions() {
        if(mSuggestionsPopupWindow == null)
            mSuggestionsPopupWindow = new SuggestionsPopupWindow();
        hideControllers();
        mSuggestionsPopupWindow.show();
    }

    boolean startSelectionActionMode() {
        if(mSelectionActionMode == null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        if(!canSelectText() || !mTextView.requestFocus()) {
            Log.w("TextView", "TextView does not support text selection. Action mode cancelled.");
            flag = false;
        } else
        if(!mTextView.hasSelection() && !selectCurrentWord()) {
            flag = false;
        } else {
            boolean flag1 = extractedTextModeWillBeStarted();
            if(!flag1) {
                SelectionActionModeCallback selectionactionmodecallback = new SelectionActionModeCallback();
                mSelectionActionMode = mTextView.startActionMode(selectionactionmodecallback);
            }
            if(mSelectionActionMode != null || flag1)
                flag = true;
            else
                flag = false;
            if(flag && !mTextView.isTextSelectable() && mShowSoftInputOnFocus) {
                InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
                if(inputmethodmanager != null)
                    inputmethodmanager.showSoftInput(mTextView, 0, null);
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    boolean startTextSelectionMode() {
        boolean flag = false;
        if(mIsInTextSelectionMode) goto _L2; else goto _L1
_L1:
        if(hasSelectionController()) goto _L4; else goto _L3
_L3:
        Log.w("Editor", "TextView has no selection controller. Selection mode cancelled.");
_L2:
        return flag;
_L4:
        if(canSelectText() && mTextView.requestFocus())
            if(!mTextView.hasSelection() && !getSelectionController().selectCurrentRange()) {
                Log.i("Editor", "can not selection current range");
            } else {
                getSelectionController().show();
                mIsInTextSelectionMode = true;
                flag = true;
            }
        if(true) goto _L2; else goto _L5
_L5:
    }

    void startTextSelectionModeIfDouleTap(long l, float f, float f1, float f2, float f3) {
        if(SystemClock.uptimeMillis() - l <= (long)ViewConfiguration.getDoubleTapTimeout() && isPositionOnText(f, f1)) {
            float f4 = f - f2;
            float f5 = f1 - f3;
            float f6 = f4 * f4 + f5 * f5;
            int i = ViewConfiguration.get(mTextView.getContext()).getScaledTouchSlop();
            if(f6 < (float)(i * i) && startTextSelectionMode())
                mDiscardNextActionUp = true;
        }
    }

    void stopBlink() {
        if(mBlink != null)
            mBlink.removeCallbacks(mBlink);
    }

    protected void stopSelectionActionMode() {
        if(mSelectionActionMode != null)
            mSelectionActionMode.finish();
    }

    void stopTextSelectionMode() {
        if(mIsInTextSelectionMode) {
            Selection.setSelection((Spannable)mTextView.getText(), mTextView.getSelectionEnd());
            if(mSelectionModifierCursorController != null)
                mSelectionModifierCursorController.hide();
            mIsInTextSelectionMode = false;
        }
    }

    TextView textview() {
        return mTextView;
    }

    void updateCursorsPositions() {
        if(mTextView.mCursorDrawableRes != 0) goto _L2; else goto _L1
_L1:
        mCursorCount = 0;
_L4:
        return;
_L2:
        Layout layout = mTextView.getLayout();
        Layout layout1 = mTextView.getHintLayout();
        int i = mTextView.getSelectionStart();
        int j = layout.getLineForOffset(i);
        int k = layout.getLineTop(j);
        int l = layout.getLineTop(j + 1);
        int i1;
        int j1;
        if(layout.isLevelBoundary(i))
            i1 = 2;
        else
            i1 = 1;
        mCursorCount = i1;
        j1 = l;
        if(mCursorCount == 2)
            j1 = k + l >> 1;
        updateCursorPosition(0, k, j1, getPrimaryHorizontal(layout, layout1, i));
        if(mCursorCount == 2)
            updateCursorPosition(1, j1, l, layout.getSecondaryHorizontal(i));
        if(true) goto _L4; else goto _L3
_L3:
    }

    static final int BLINK = 500;
    private static int DRAG_SHADOW_MAX_TEXT_LENGTH = 0;
    static final int EXTRACT_NOTHING = -2;
    static final int EXTRACT_UNKNOWN = -1;
    private static final String TAG = "Editor";
    private static final float TEMP_POSITION[] = new float[2];
    Blink mBlink;
    private Context mContext;
    CorrectionHighlighter mCorrectionHighlighter;
    boolean mCreatedWithASelection;
    int mCursorCount;
    final Drawable mCursorDrawable[] = new Drawable[2];
    boolean mCursorVisible;
    android.view.ActionMode.Callback mCustomSelectionActionModeCallback;
    boolean mDiscardNextActionUp;
    private EasyEditSpanController mEasyEditSpanController;
    CharSequence mError;
    ErrorPopup mErrorPopup;
    boolean mErrorWasChanged;
    boolean mFrozenWithFocus;
    boolean mIgnoreActionUpEvent;
    boolean mInBatchEditControllers;
    InputContentType mInputContentType;
    InputMethodState mInputMethodState;
    int mInputType;
    boolean mInsertionControllerEnabled;
    MiuiCursorController mInsertionPointCursorController;
    private boolean mIsInTextSelectionMode;
    KeyListener mKeyListener;
    float mLastDownPositionX;
    float mLastDownPositionY;
    private MagnifierController mMagnifierController;
    private PositionListener mPositionListener;
    boolean mPreserveDetachedSelection;
    boolean mSelectAllOnFocus;
    private Drawable mSelectHandleCenter;
    private Drawable mSelectHandleLeft;
    private Drawable mSelectHandleRight;
    ActionMode mSelectionActionMode;
    boolean mSelectionControllerEnabled;
    MiuiCursorController mSelectionModifierCursorController;
    boolean mSelectionMoved;
    long mShowCursor;
    boolean mShowErrorAfterAttach;
    boolean mShowSoftInputOnFocus;
    Runnable mShowSuggestionRunnable;
    SpellChecker mSpellChecker;
    SuggestionRangeSpan mSuggestionRangeSpan;
    SuggestionsPopupWindow mSuggestionsPopupWindow;
    private Rect mTempRect;
    boolean mTemporaryDetach;
    DisplayList mTextDisplayLists[];
    boolean mTextIsSelectable;
    private TextView mTextView;
    boolean mTouchFocusSelected;
    WordIterator mWordIterator;

    static  {
        DRAG_SHADOW_MAX_TEXT_LENGTH = 20;
    }




/*
    static Rect access$1802(Editor editor, Rect rect) {
        editor.mTempRect = rect;
        return rect;
    }

*/






/*
    static Drawable access$2302(Editor editor, Drawable drawable) {
        editor.mSelectHandleCenter = drawable;
        return drawable;
    }

*/




/*
    static Drawable access$2502(Editor editor, Drawable drawable) {
        editor.mSelectHandleLeft = drawable;
        return drawable;
    }

*/



/*
    static Drawable access$2602(Editor editor, Drawable drawable) {
        editor.mSelectHandleRight = drawable;
        return drawable;
    }

*/





}
