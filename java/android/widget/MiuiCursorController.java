// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.*;
import android.text.method.PasswordTransformationMethod;
import android.text.method.WordIterator;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.*;
import java.util.ArrayList;

// Referenced classes of package android.widget:
//            Editor, TextView, PopupWindow, MagnifierController, 
//            FloatPanelView, LinearLayout, ImageView

public abstract class MiuiCursorController
    implements android.view.ViewTreeObserver.OnTouchModeChangeListener {
    class SelectionEndHandleView extends MiuiHandleView {

        public int getCurrentCursorOffset() {
            return super.mTextView.getSelectionEnd();
        }

        protected int getHotspotX(Drawable drawable, boolean flag) {
            int i;
            if(flag)
                i = (3 * drawable.getIntrinsicWidth()) / 4;
            else
                i = drawable.getIntrinsicWidth() / 4;
            return i;
        }

        public void updatePosition(float f, float f1) {
            int i = super.mTextView.getOffsetForPosition(f, f1);
            int j = super.mTextView.getSelectionStart();
            if(i <= j)
                i = Math.min(j + 1, super.mTextView.length());
            positionAtCursorOffset(i, false);
        }

        public void updateSelection(int i) {
            super.mEditor.setTextSelectionWrap(super.mTextView.getSelectionStart(), i);
            updateDrawable();
        }

        final MiuiCursorController this$0;

        public SelectionEndHandleView(Editor editor, Drawable drawable, Drawable drawable1) {
            this$0 = MiuiCursorController.this;
            super(editor, drawable, drawable1);
        }
    }

    class SelectionStartHandleView extends MiuiHandleView {

        public int getCurrentCursorOffset() {
            return super.mTextView.getSelectionStart();
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
            int i = super.mTextView.getOffsetForPosition(f, f1);
            int j = super.mTextView.getSelectionEnd();
            if(i >= j)
                i = Math.max(0, j - 1);
            positionAtCursorOffset(i, false);
        }

        public void updateSelection(int i) {
            super.mEditor.setTextSelectionWrap(i, super.mTextView.getSelectionEnd());
            updateDrawable();
        }

        final MiuiCursorController this$0;

        public SelectionStartHandleView(Editor editor, Drawable drawable, Drawable drawable1) {
            this$0 = MiuiCursorController.this;
            super(editor, drawable, drawable1);
        }
    }

    class MagnifierInsertionHandleView extends InsertionHandleView {

        public void hide() {
            if(canHide) {
                super.mEditor.removePositionListenerSubscriber(this);
            } else {
                Log.i("MiuiHandleView", "To hide the MagnifierInsertionHandleView, just delay");
                canHide = true;
                dismiss();
                hideAfterDelay(200);
            }
        }

        protected boolean needShowHandle() {
            return false;
        }

        public void show() {
            super.show();
            hideAfterDelay(3000);
            updatePositionXY(getCurrentCursorOffset(), true);
        }

        boolean canHide;
        final MiuiCursorController this$0;

        public MagnifierInsertionHandleView(Editor editor, Drawable drawable) {
            this$0 = MiuiCursorController.this;
            super(editor, drawable);
            canHide = false;
        }
    }

    class InsertionHandleView extends MiuiHandleView {

        private void removeHiderCallback() {
            if(mHider != null)
                super.mTextView.removeCallbacks(mHider);
        }

        public int getCurrentCursorOffset() {
            return super.mTextView.getSelectionStart();
        }

        protected int getHotspotX(Drawable drawable, boolean flag) {
            return drawable.getIntrinsicWidth() / 2;
        }

        protected void hideAfterDelay(int i) {
            removeHiderCallback();
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
            super.mTextView.postDelayed(mHider, i);
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
        //                       0 40
        //                       1 40
        //                       2 40
        //                       3 42;
               goto _L1 _L1 _L1 _L1 _L2
_L1:
            return flag;
_L2:
            hideAfterDelay(3000);
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void show() {
            super.show();
            hideAfterDelay(3000);
        }

        public void updatePosition(float f, float f1) {
            positionAtCursorOffset(super.mTextView.getOffsetForPosition(f, f1), false);
        }

        public void updateSelection(int i) {
            super.mEditor.setTextSelectionWrap(i, i);
        }

        protected static final int DELAY_BEFORE_HANDLE_FADES_OUT = 3000;
        protected static final int DELAY_WHEN_HANDLE_INVISIBLE = 200;
        private Runnable mHider;
        final MiuiCursorController this$0;

        public InsertionHandleView(Editor editor, Drawable drawable) {
            this$0 = MiuiCursorController.this;
            super(editor, drawable, drawable);
        }
    }

    abstract class MiuiHandleView extends View
        implements Editor.TextViewPositionListener {

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

        private void startTouchUpFilter(int i) {
            mNumberPreviousOffsets = 0;
            addPositionToTouchUpFilter(i);
        }

        protected void dismiss() {
            mIsDragging = false;
            mContainer.dismiss();
            onDetached();
        }

        public float distance(float f, float f1) {
            return Math.abs(((float)(mContainerX + mHotspotX) - f) * ((float)mContainerY - f1));
        }

        protected abstract int getCurrentCursorOffset();

        public void getHotspotLocationOnScreen(int ai[]) {
            ai[0] = mContainerX + mHotspotX;
            ai[1] = mContainerY;
        }

        protected abstract int getHotspotX(Drawable drawable, boolean flag);

        public void hide() {
            dismiss();
            mEditor.removePositionListenerSubscriber(this);
        }

        public boolean inRecRange(float f, float f1) {
            int i = mDrawableRtl.getIntrinsicHeight();
            int j = mContainerX + mHotspotX;
            int k = mContainerY + i / 2;
            Log.i("MiuiCursorController", (new StringBuilder()).append("HandleCenter at x= ").append(j).append(" y=").append(k).append("  and touch at x=").append(f).append(" y=").append(f1).toString());
            boolean flag;
            if(Math.abs((float)j - f) < (float)mHandleRange && Math.abs((float)k - f1) < (float)(i / 2))
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void invisible() {
            mContainer.dismiss();
        }

        public boolean isDragging() {
            return mIsDragging;
        }

        public boolean isShowing() {
            return mContainer.isShowing();
        }

        protected boolean isVisible() {
            boolean flag;
            if(mIsDragging)
                flag = true;
            else
            if(mTextView.isInBatchEditMode())
                flag = false;
            else
                flag = mEditor.isPositionVisibleWrap(mPositionX + mHotspotX, mPositionY);
            return flag;
        }

        protected boolean needShowHandle() {
            return true;
        }

        public void onDetached() {
        }

        protected void onDraw(Canvas canvas) {
            mDrawable.setBounds(0, 0, super.mRight - super.mLeft, super.mBottom - super.mTop);
            mDrawable.draw(canvas);
        }

        void onHandleMoved() {
        }

        protected void onMeasure(int i, int j) {
            setMeasuredDimension(mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
        }

        public boolean onTouchEvent(MotionEvent motionevent) {
            motionevent.getActionMasked();
            JVM INSTR tableswitch 0 3: default 36
        //                       0 48
        //                       1 246
        //                       2 119
        //                       3 258;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            mCursorController.onHandleTouchEvent(this, motionevent);
            return true;
_L2:
            startTouchUpFilter(getCurrentCursorOffset());
            mTouchToWindowOffsetX = motionevent.getRawX() - (float)mPositionX;
            mTouchToWindowOffsetY = motionevent.getRawY() - (float)mPositionY;
            long l = mEditor.getPositionListenerPostion();
            mLastParentX = MiuiCursorController.extractRangeStartFromLong(l);
            mLastParentY = MiuiCursorController.extractRangeEndFromLong(l);
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

        public void positionAtCursorOffset(int i, boolean flag) {
            if(mTextView.getLayout() != null) goto _L2; else goto _L1
_L1:
            mEditor.prepareCursorControllers();
_L4:
            return;
_L2:
            if(i != mPreviousOffset || flag) {
                updateSelection(i);
                addPositionToTouchUpFilter(i);
                updatePositionXY(i, false);
                mPreviousOffset = i;
                mPositionHasChanged = true;
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void setCursorController(MiuiCursorController miuicursorcontroller) {
            mCursorController = miuicursorcontroller;
        }

        public void setType(int i) {
            mType = i;
        }

        public void show() {
            Log.i("MiuiHandleView", (new StringBuilder()).append("HandleView [").append(mType).append("] is shown").toString());
            if(!isShowing()) {
                mEditor.addPositionListenerSubscriber(this, true);
                mPreviousOffset = -1;
                positionAtCursorOffset(getCurrentCursorOffset(), false);
            }
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

        protected abstract void updatePosition(float f, float f1);

        public void updatePosition(int i, int j, boolean flag, boolean flag1) {
            Log.i("MiuiHandleView", (new StringBuilder()).append("HandleView [").append(mType).append("] handle updatePosition called from PositionListener:").append(i).append("x").append(j).toString());
            positionAtCursorOffset(getCurrentCursorOffset(), flag1);
            if(!flag && !mPositionHasChanged) goto _L2; else goto _L1
_L1:
            if(mIsDragging) {
                if(i != mLastParentX || j != mLastParentY) {
                    mTouchToWindowOffsetX = mTouchToWindowOffsetX + (float)(i - mLastParentX);
                    mTouchToWindowOffsetY = mTouchToWindowOffsetY + (float)(j - mLastParentY);
                    mLastParentX = i;
                    mLastParentY = j;
                    if(mEditor.hasMagnifierController())
                        mEditor.getMagnifierController().onParentChanged();
                }
                onHandleMoved();
            }
            if(!isVisible()) goto _L4; else goto _L3
_L3:
            mContainerX = i + mPositionX;
            mContainerY = j + mPositionY;
            if(needShowHandle())
                if(isShowing())
                    mContainer.update(mContainerX, mContainerY, -1, -1);
                else
                    mContainer.showAtLocation(mTextView, 0, mContainerX, mContainerY);
_L6:
            mPositionHasChanged = false;
_L2:
            mCursorController.updatePosition();
            return;
_L4:
            if(isShowing())
                dismiss();
            if(true) goto _L6; else goto _L5
_L5:
        }

        protected void updatePositionXY(int i, boolean flag) {
            int j = mTextView.getLayout().getLineForOffset(i);
            mPositionX = (int)(mTextView.getLayout().getPrimaryHorizontal(i) - 0.5F - (float)mHotspotX);
            mPositionY = mTextView.getLayout().getLineBottom(j);
            mPositionX = mPositionX + mTextView.viewportToContentHorizontalOffset();
            mPositionY = mPositionY + mTextView.viewportToContentVerticalOffset();
            if(flag) {
                int ai[] = new int[2];
                mTextView.getLocationOnScreen(ai);
                mContainerX = ai[0] + mPositionX;
                mContainerY = ai[1] + mPositionY;
            }
        }

        protected abstract void updateSelection(int i);

        public static final int HANDLE_END = 2;
        public static final int HANDLE_INSERT = 0;
        public static final int HANDLE_START = 1;
        private static final int HISTORY_SIZE = 5;
        static final String TAG = "MiuiHandleView";
        private static final int TOUCH_UP_FILTER_DELAY_AFTER = 150;
        private static final int TOUCH_UP_FILTER_DELAY_BEFORE = 350;
        private final PopupWindow mContainer;
        private int mContainerX;
        private int mContainerY;
        private MiuiCursorController mCursorController;
        protected Drawable mDrawable;
        protected Drawable mDrawableLtr;
        protected Drawable mDrawableRtl;
        protected Editor mEditor;
        private int mHandleRange;
        private int mHotspotX;
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
        protected TextView mTextView;
        private float mTouchOffsetY;
        private float mTouchToWindowOffsetX;
        private float mTouchToWindowOffsetY;
        private int mType;
        final MiuiCursorController this$0;

        public MiuiHandleView(Editor editor, Drawable drawable, Drawable drawable1) {
            this$0 = MiuiCursorController.this;
            super(editor.textview().getContext());
            mPreviousOffset = -1;
            mPositionHasChanged = true;
            mPreviousOffsetIndex = 0;
            mNumberPreviousOffsets = 0;
            mEditor = editor;
            mTextView = mEditor.textview();
            mHandleRange = (int)mTextView.getContext().getResources().getDimension(0x60a0019) / 2;
            mContainer = new PopupWindow(mTextView.getContext(), null, mEditor.getSelectHandleWindowStyle());
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

    public static class SelectionModifierCursorController extends MiuiCursorController {

        public void addClipData(ClipboardManager clipboardmanager, ClipData clipdata, CharSequence charsequence) {
            if(clipdata == null) {
                clipboardmanager.setPrimaryClip(ClipData.newPlainText(null, charsequence));
            } else {
                ClipData clipdata1 = ClipData.newPlainText(null, charsequence);
                int i = Math.min(clipdata.getItemCount(), 2);
                for(int j = 0; j < i; j++)
                    clipdata1.addItem(clipdata.getItemAt(j));

                clipboardmanager.setPrimaryClip(clipdata1);
            }
        }

        public void computePanelPosition(int ai[]) {
            if(mStartHandle.isShowing()) {
                mStartHandle.getHotspotLocationOnScreen(mCoords1);
                mEndHandle.getHotspotLocationOnScreen(mCoords2);
            }
            ai[1] = mCoords1[1];
            if(mCoords1[1] == mCoords2[1]) {
                ai[0] = (mCoords1[0] + mCoords2[0]) / 2;
            } else {
                mTextView.getLocationOnScreen(mCoords);
                ai[0] = Math.max(mCoords[0] + mTextView.getWidth() / 2, mCoords1[0]);
            }
        }

        public int computePanelPositionOnBottom() {
            if(mStartHandle.isShowing()) {
                mEndHandle.getHotspotLocationOnScreen(mCoords2);
                mTextView.getLocationOnScreen(mCoords);
            }
            int i = mCoords[1] + mTextView.getHeight();
            int j = mContext.getResources().getDimensionPixelSize(0x60a0004);
            int k = j + mCoords2[1];
            if(mEndHandle.isShowing())
                i = Math.min(k, i + j);
            return i;
        }

        public int getMaxTouchOffset() {
            return mMaxTouchOffset;
        }

        public int getMinTouchOffset() {
            return mMinTouchOffset;
        }

        public void hide() {
            mStartHandle.hide();
            mEndHandle.hide();
            mPanel.hide();
            mIsShowing = false;
        }

        public boolean isSelectionStartDragged() {
            boolean flag;
            if(mStartHandle != null && mStartHandle.isDragging())
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean isShowing() {
            return mIsShowing;
        }

        public boolean onHandleTouchEvent(MiuiHandleView miuihandleview, MotionEvent motionevent) {
            motionevent.getActionMasked();
            JVM INSTR tableswitch 1 2: default 28
        //                       1 30
        //                       2 40;
               goto _L1 _L2 _L3
_L1:
            return false;
_L2:
            mPanel.showAndUpdatePositionAsync();
            continue; /* Loop/switch isn't completed */
_L3:
            if(mPanel.isShowing())
                mPanel.hide();
            if(true) goto _L1; else goto _L4
_L4:
        }

        public boolean onTouchEvent(MotionEvent motionevent) {
            boolean flag;
            int i;
            flag = false;
            i = motionevent.getActionMasked();
            if(mTouchOnHandle == null) goto _L2; else goto _L1
_L1:
            boolean flag1;
            mTouchOnHandle.onTouchEvent(motionevent);
            if(i == 1 || i == 3) {
                mTouchOnHandle = null;
                if(mTextView.getParent() != null)
                    mTextView.getParent().requestDisallowInterceptTouchEvent(false);
                Log.i("MiuiCursorController", "action UP or Cancel to stop moving event to HandleView");
            }
            flag1 = true;
_L8:
            return flag1;
_L2:
            if(isShowing() && i == 0) {
                float f2 = motionevent.getRawX();
                float f3 = motionevent.getRawY();
                boolean flag2 = mStartHandle.inRecRange(f2, f3);
                boolean flag3 = mEndHandle.inRecRange(f2, f3);
                Log.i("MiuiCursorController", (new StringBuilder()).append("Touch in handleview: startHandleView=").append(flag2).append(" endHandleView=").append(flag3).toString());
                if(flag2 && flag3) {
                    MiuiHandleView miuihandleview;
                    if(mStartHandle.distance(f2, f3) > mEndHandle.distance(f2, f3))
                        miuihandleview = mEndHandle;
                    else
                        miuihandleview = mStartHandle;
                    mTouchOnHandle = miuihandleview;
                } else
                if(flag2)
                    mTouchOnHandle = mStartHandle;
                else
                if(flag3)
                    mTouchOnHandle = mEndHandle;
                if(mTouchOnHandle != null) {
                    Log.i("MiuiCursorController", "Touch near handle and move event to HandleView");
                    if(mTextView.getParent() != null)
                        mTextView.getParent().requestDisallowInterceptTouchEvent(true);
                    mTouchOnHandle.onTouchEvent(motionevent);
                    flag1 = true;
                    continue; /* Loop/switch isn't completed */
                }
            }
            i;
            JVM INSTR tableswitch 0 6: default 344
        //                       0 394
        //                       1 558
        //                       2 344
        //                       3 344
        //                       4 344
        //                       5 469
        //                       6 469;
               goto _L3 _L4 _L5 _L3 _L3 _L3 _L6 _L6
_L5:
            break MISSING_BLOCK_LABEL_558;
_L3:
            break; /* Loop/switch isn't completed */
_L4:
            break; /* Loop/switch isn't completed */
_L9:
            if(mOwner.hasMagnifierController())
                flag = mOwner.getMagnifierController().onTouchEvent(motionevent);
            if(mOwner.hasInsertionController())
                mOwner.getInsertionController().onTouchEvent(motionevent);
            flag1 = flag;
            if(true) goto _L8; else goto _L7
_L7:
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            int i1 = mTextView.getOffsetForPosition(f, f1);
            mMaxTouchOffset = i1;
            mMinTouchOffset = i1;
            mOwner.startTextSelectionModeIfDouleTap(mPreviousTapUpTime, f, f1, mPreviousTapPositionX, mPreviousTapPositionY);
            mPreviousTapPositionX = f;
            mPreviousTapPositionY = f1;
              goto _L9
_L6:
            if(mContext.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct")) {
                int j = motionevent.getPointerCount();
                int k = 0;
                while(k < j)  {
                    int l = mTextView.getOffsetForPosition(motionevent.getX(k), motionevent.getY(k));
                    if(l < mMinTouchOffset)
                        mMinTouchOffset = l;
                    if(l > mMaxTouchOffset)
                        mMaxTouchOffset = l;
                    k++;
                }
            }
              goto _L9
            mOwner.onTapUpEvent();
            mPreviousTapUpTime = SystemClock.uptimeMillis();
              goto _L9
        }

        public void resetTouchOffsets() {
            mMaxTouchOffset = -1;
            mMinTouchOffset = -1;
        }

        public void setMinMaxOffset(int i) {
            mMaxTouchOffset = i;
            mMinTouchOffset = i;
        }

        public void show() {
            Log.i("MiuiCursorController", "SelectionModifierCursorController is shown");
            mTouchOnHandle = null;
            if(!mTextView.isInBatchEditMode()) {
                Log.i("MiuiCursorController", "SelectionModifierCursorController is shown and hide InsertionPointCursorController");
                mIsShowing = true;
                mStartHandle.show();
                mEndHandle.show();
                updatePosition();
                mPanel.showAndUpdatePositionAsync();
                mOwner.hideInsertionPointCursorControllerWrap();
                int ai[] = new int[3];
                ai[0] = 0x60b0015;
                ai[1] = 0x60b0016;
                ai[2] = 0x60b0017;
                int ai1[] = new int[2];
                ai1[0] = 0x60b001c;
                ai1[1] = 0x60b001d;
                ArrayList arraylist = mOwner.getFloatPanelShowHides(ai);
                mPanel.showHideButtons(ai, ai1, arraylist);
            }
        }

        public void updatePosition() {
            if(isShowing()) goto _L2; else goto _L1
_L1:
            return;
_L2:
            int i = mTextView.getSelectionStart();
            int j = mTextView.getSelectionEnd();
            if(i < 0 || j < 0) {
                Log.e("MiuiCursorController", "Update selection controller position called with no cursor");
                hide();
            } else
            if(i == j) {
                hide();
            } else {
                mStartHandle.positionAtCursorOffset(i, true);
                mEndHandle.positionAtCursorOffset(j, true);
                if(mStartHandle.isShowing() || mEndHandle.isShowing()) {
                    if(mPanel.isShowing() || mHideInvisiblePanel) {
                        mPanel.showAndUpdatePositionAsync();
                        mHideInvisiblePanel = false;
                    }
                } else
                if(mPanel.isShowing()) {
                    mPanel.hide();
                    mHideInvisiblePanel = true;
                }
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        private int mCoords[];
        private int mCoords1[];
        private int mCoords2[];
        private MiuiHandleView mEndHandle;
        boolean mHideInvisiblePanel;
        private boolean mIsShowing;
        private int mMaxTouchOffset;
        private int mMinTouchOffset;
        private FloatPanelViewController mPanel;
        private float mPreviousTapPositionX;
        private float mPreviousTapPositionY;
        private long mPreviousTapUpTime;
        private MiuiHandleView mStartHandle;
        private MiuiHandleView mTouchOnHandle;


        SelectionModifierCursorController(Editor editor, Context context) {
            super(editor, context);
            mPreviousTapUpTime = 0L;
            mCoords1 = new int[2];
            mCoords2 = new int[2];
            mCoords = new int[2];
            mHideInvisiblePanel = false;
            mStartHandle = initHandleView(mOwner, 1, this);
            mEndHandle = initHandleView(mOwner, 2, this);
            mPanel = createFloatPanelViewController(0x6030032);
            android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

                public void onClick(View view) {
                    mOwner.handleFloatPanelClick(view, SelectionModifierCursorController.this);
                    mPanel.hide();
                }

                final SelectionModifierCursorController this$0;

                 {
                    this$0 = SelectionModifierCursorController.this;
                    super();
                }
            };
            mPanel.setButtonOnClickListener(0x60b0015, onclicklistener);
            mPanel.setButtonOnClickListener(0x60b0016, onclicklistener);
            mPanel.setButtonOnClickListener(0x60b0017, onclicklistener);
            resetTouchOffsets();
        }
    }

    public static class InsertionPointCursorController extends MiuiCursorController {

        private void showInsertionPanel() {
            Log.i("MiuiCursorController", ">need InsertPanel, to show Panel and hide handle");
            mPanel.showAndUpdatePositionAsync();
            mHandle.invisible();
            mOwner.getSelectionController().setMinMaxOffset(mTextOffset);
        }

        public void computePanelPosition(int ai[]) {
            mHandle.getHotspotLocationOnScreen(ai);
        }

        public int computePanelPositionOnBottom() {
            mHandle.getHotspotLocationOnScreen(mCoords);
            return mCoords[1];
        }

        public void hide() {
            Log.i("MiuiCursorController", "InsertionPointCursorController is hidden including all panels and handle");
            mPanel.hide();
            mClipboardPanel.hide();
            mHandle.hide();
        }

        public boolean isShowing() {
            boolean flag;
            if(mHandle.isShowing() || mPanel.isShowing() || mClipboardPanel.isShowing())
                flag = true;
            else
                flag = false;
            return flag;
        }

        void onClipBoardPancelClick() {
            mClipboardPanel.hide();
        }

        public boolean onHandleTouchEvent(MiuiHandleView miuihandleview, MotionEvent motionevent) {
            motionevent.getActionMasked();
            JVM INSTR tableswitch 0 2: default 32
        //                       0 34
        //                       1 44
        //                       2 105;
               goto _L1 _L2 _L3 _L4
_L1:
            return false;
_L2:
            mPreviousDownTime = SystemClock.uptimeMillis();
            continue; /* Loop/switch isn't completed */
_L3:
            if(mPanel.isShowing() && SystemClock.uptimeMillis() - mPreviousDownTime <= (long)ViewConfiguration.getTapTimeout()) {
                mPanel.hide();
            } else {
                Log.i("MiuiCursorController", "InsertionPointCursorController onHandleTouchEvent() for ACTION_UP");
                if(mOwner.needInsertPanel())
                    showInsertionPanel();
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if(mPanel.isShowing())
                mPanel.hide();
            mHandle.onHandleMoved();
            if(true) goto _L1; else goto _L5
_L5:
        }

        public boolean onTouchEvent(MotionEvent motionevent) {
            motionevent.getActionMasked();
            JVM INSTR tableswitch 2 2: default 24
        //                       2 26;
               goto _L1 _L2
_L1:
            return false;
_L2:
            if(mPanel.isShowing())
                hide();
            if(true) goto _L1; else goto _L3
_L3:
        }

        void setupClipBoardPanel(ClipData clipdata, android.view.View.OnClickListener onclicklistener) {
            LinearLayout linearlayout = (LinearLayout)mClipboardPanel.getElement(0x60b001b);
            linearlayout.removeAllViews();
            int i = -1 + Math.min(3, clipdata.getItemCount());
            LayoutInflater layoutinflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
            for(int j = 0; j <= i; j++) {
                TextView textview = (TextView)layoutinflater.inflate(0x6030031, null);
                textview.setText(clipdata.getItemAt(j).coerceToText(mContext));
                textview.setOnClickListener(onclicklistener);
                linearlayout.addView(textview, new android.view.ViewGroup.LayoutParams(-1, -2));
                if(j != i) {
                    ImageView imageview = new ImageView(mContext);
                    imageview.setImageResource(0x602010c);
                    imageview.setScaleType(ImageView.ScaleType.FIT_XY);
                    linearlayout.addView(imageview, new android.view.ViewGroup.LayoutParams(-1, -2));
                }
            }

            mClipboardPanel.showAndUpdatePositionAsync();
        }

        public void show() {
            boolean flag = true;
            int ai[] = new int[4];
            ai[0] = 0x60b0019;
            ai[1] = 0x60b001a;
            ai[2] = 0x60b0017;
            ai[3] = 0x60b0018;
            int ai1[] = new int[3];
            ai1[0] = 0x60b001c;
            ai1[1] = 0x60b001d;
            ai1[2] = 0x60b001e;
            ArrayList arraylist = mOwner.getFloatPanelShowHides(ai);
            Log.i("MiuiCursorController", (new StringBuilder()).append("InsertionPointCursorController show:").append(arraylist.toString()).toString());
            mPanel.showHideButtons(ai, ai1, arraylist);
            Log.i("MiuiCursorController", "InsertionPointCursorController is shown with hidden panels and shown handle");
            mPanel.hide();
            mClipboardPanel.hide();
            int i = mTextView.getSelectionStart();
            boolean flag1;
            boolean flag2;
            if(i == mTextOffset || mTextView.length() <= 0)
                flag1 = flag;
            else
                flag1 = false;
            mTextOffset = i;
            if(mOwner.hasMagnifierController() && mOwner.getMagnifierController().isShowing())
                flag2 = flag;
            else
                flag2 = false;
            mHandle.show();
            if(flag1 && !flag2) {
                Log.i("MiuiCursorController", "Show InsertionPointCursorController in one shot context");
                if(mOwner.needInsertPanel() && mShowOnOneShot)
                    showInsertionPanel();
                else
                    mHandle.hide();
                if(mShowOnOneShot)
                    flag = false;
                mShowOnOneShot = flag;
            }
        }

        public void updatePosition() {
            mTextOffset = mTextView.getSelectionStart();
            if(mTextOffset >= 0) goto _L2; else goto _L1
_L1:
            Log.e("MiuiCursorController", "Update cursor controller position called with no cursor");
            hide();
_L4:
            return;
_L2:
            if(!mPanel.isShowing() && !mClipboardPanel.isShowing())
                mHandle.positionAtCursorOffset(mTextOffset, true);
            if(mPanel.isShowing())
                mPanel.showAndUpdatePositionAsync();
            if(mClipboardPanel.isShowing())
                mClipboardPanel.showAndUpdatePositionAsync();
            if(true) goto _L4; else goto _L3
_L3:
        }

        private FloatPanelViewController mClipboardPanel;
        private int mCoords[];
        private final MiuiHandleView mHandle;
        private FloatPanelViewController mPanel;
        private long mPreviousDownTime;
        boolean mShowOnOneShot;
        private int mTextOffset;


        InsertionPointCursorController(Editor editor, Context context) {
            super(editor, context);
            mCoords = new int[2];
            mShowOnOneShot = false;
            mHandle = initHandleView(mOwner, 0, this);
            mPanel = createFloatPanelViewController(0x6030033);
            mClipboardPanel = createFloatPanelViewController(0x6030030);
            android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

                public void onClick(View view) {
                    mOwner.handleFloatPanelClick(view, InsertionPointCursorController.this);
                    mPanel.hide();
                }

                final InsertionPointCursorController this$0;

                 {
                    this$0 = InsertionPointCursorController.this;
                    super();
                }
            };
            mPanel.setButtonOnClickListener(0x60b0019, onclicklistener);
            mPanel.setButtonOnClickListener(0x60b001a, onclicklistener);
            mPanel.setButtonOnClickListener(0x60b0017, onclicklistener);
            mPanel.setButtonOnClickListener(0x60b0018, onclicklistener);
        }
    }

    private class FloatPanelViewController {

        private void updatePosition() {
            int i;
            int k;
            int l;
            mController.computePanelPosition(mPos);
            i = mPos[0] - mContent.getWidth() / 2;
            int j = mPos[1] - mContent.getHeight() - mTextView.getLineHeight();
            if(j < mStatusBarHeight) {
                mContent.setArrow(true);
                j = mController.computePanelPositionOnBottom();
            } else {
                mContent.setArrow(false);
            }
            k = mDisplay.getWidth();
            l = mContent.getWidth() / 2;
            if(i >= 0) goto _L2; else goto _L1
_L1:
            l += i;
_L4:
            mContent.setArrowPos(l);
            mContainer.update(i, j, mContent.getWidth(), mContent.getHeight());
            return;
_L2:
            if(i + mContent.getWidth() > k)
                l += (i + mContent.getWidth()) - k;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public View getElement(int i) {
            return mContent.findViewById(i);
        }

        public void hide() {
            mContainer.dismiss();
        }

        public boolean isShowing() {
            return mContainer.isShowing();
        }

        public void setButtonOnClickListener(int i, android.view.View.OnClickListener onclicklistener) {
            View view = mContent.findViewById(i);
            if(view != null)
                view.setOnClickListener(onclicklistener);
            else
                Log.e("MiuiCursorController", (new StringBuilder()).append("FloatPanelView.setButtonHandler, could not find view, id:").append(i).toString());
        }

        public void show() {
            mController.computePanelPosition(mPos);
            mContainer.showAtLocation(mTextView, 0, mPos[0] - mContent.getWidth() / 2, mPos[1] - mContent.getHeight() - mTextView.getLineHeight());
            updatePosition();
        }

        public void showAndUpdatePositionAsync() {
            Log.i("MiuiCursorController", "FloatPanelViewController to showAndUpdatePositionAsync");
            if(!isShowing())
                show();
            mTextView.post(new Runnable() {

                public void run() {
                    Log.i("MiuiCursorController", ">>FloatPanelViewController to updatePosition for showAndUpdatePositionAsync");
                    updatePosition();
                }

                final FloatPanelViewController this$1;

                 {
                    this$1 = FloatPanelViewController.this;
                    super();
                }
            });
        }

        public void showElement(int i, boolean flag) {
            View view = mContent.findViewById(i);
            if(view != null) {
                int j;
                if(flag)
                    j = 0;
                else
                    j = 8;
                view.setVisibility(j);
            } else {
                Log.e("MiuiCursorController", (new StringBuilder()).append("FloatPanelView.showButton, could not find view, id:").append(i).toString());
            }
        }

        public void showHideButtons(int ai[], int ai1[], ArrayList arraylist) {
            if(!$assertionsDisabled && (ai.length != 1 + ai1.length || ai.length != arraylist.size()))
                throw new AssertionError();
            showElement(ai[0], ((Boolean)arraylist.get(0)).booleanValue());
            boolean flag;
            int i;
            if(!((Boolean)arraylist.get(0)).booleanValue())
                flag = true;
            else
                flag = false;
            i = 1;
            while(i < ai.length)  {
                Boolean boolean1 = (Boolean)arraylist.get(i);
                showElement(ai[i], boolean1.booleanValue());
                int j = ai1[i - 1];
                boolean flag1;
                if(!flag && boolean1.booleanValue())
                    flag1 = true;
                else
                    flag1 = false;
                showElement(j, flag1);
                if(flag && boolean1.booleanValue())
                    flag = false;
                i++;
            }
        }

        static final boolean $assertionsDisabled;
        private PopupWindow mContainer;
        private FloatPanelView mContent;
        private MiuiCursorController mController;
        private Display mDisplay;
        private int mPos[];
        private int mStatusBarHeight;
        final MiuiCursorController this$0;

        static  {
            boolean flag;
            if(!android/widget/MiuiCursorController.desiredAssertionStatus())
                flag = true;
            else
                flag = false;
            $assertionsDisabled = flag;
        }


        public FloatPanelViewController(MiuiCursorController miuicursorcontroller1, int i) {
            this$0 = MiuiCursorController.this;
            super();
            mPos = new int[2];
            mController = miuicursorcontroller1;
            mContainer = new PopupWindow(mContext, null, 0x10102c8);
            mContainer.setSplitTouchEnabled(true);
            mContainer.setWindowLayoutType(1002);
            mContent = (FloatPanelView)((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(i, null);
            mContainer.setContentView(mContent);
            mContainer.setWindowLayoutMode(-2, -2);
            mStatusBarHeight = mContext.getResources().getDimensionPixelSize(0x60a0000);
            mDisplay = ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay();
        }
    }


    MiuiCursorController(Editor editor, Context context) {
        mOwner = editor;
        mContext = context;
        mTextView = mOwner.textview();
    }

    static MiuiCursorController create(Editor editor, Context context, int i) {
        Object obj;
        if(i == 1)
            obj = new InsertionPointCursorController(editor, context);
        else
        if(i == 2)
            obj = new SelectionModifierCursorController(editor, context);
        else
            obj = null;
        return ((MiuiCursorController) (obj));
    }

    private static int extractRangeEndFromLong(long l) {
        return (int)(0xffffffffL & l);
    }

    private static int extractRangeStartFromLong(long l) {
        return (int)(l >>> 32);
    }

    public abstract void computePanelPosition(int ai[]);

    public abstract int computePanelPositionOnBottom();

    public FloatPanelViewController createFloatPanelViewController(int i) {
        return new FloatPanelViewController(this, i);
    }

    public int getMaxTouchOffset() {
        return 0;
    }

    public int getMinTouchOffset() {
        return -1;
    }

    public abstract void hide();

    MiuiHandleView initHandleView(Editor editor, int i, MiuiCursorController miuicursorcontroller) {
        Object obj = null;
        if(i == 0) {
            if(editor.hasMagnifierController())
                obj = new MagnifierInsertionHandleView(editor, mOwner.getSelectHandleCenterRes());
            else
                obj = new InsertionHandleView(editor, mOwner.getSelectHandleCenterRes());
        } else {
            Drawable drawable = mOwner.getSelectHandleRightRes();
            Drawable drawable1 = mOwner.getSelectHandleLeftRes();
            if(i == 1)
                obj = new SelectionStartHandleView(editor, drawable1, drawable);
            if(i == 2)
                obj = new SelectionEndHandleView(editor, drawable, drawable1);
        }
        if(obj == null) {
            Log.e("MiuiCursorController", "Failed to init handle view.");
        } else {
            ((MiuiHandleView) (obj)).setCursorController(miuicursorcontroller);
            ((MiuiHandleView) (obj)).setType(i);
        }
        return ((MiuiHandleView) (obj));
    }

    public boolean isSelectionStartDragged() {
        return false;
    }

    public abstract boolean isShowing();

    public void onDetached() {
    }

    public abstract boolean onHandleTouchEvent(MiuiHandleView miuihandleview, MotionEvent motionevent);

    public abstract boolean onTouchEvent(MotionEvent motionevent);

    public void onTouchModeChanged(boolean flag) {
        if(!flag)
            hide();
    }

    public void resetTouchOffsets() {
    }

    public boolean selectCurrentRange() {
        if(!(mTextView.getTransformationMethod() instanceof PasswordTransformationMethod)) goto _L2; else goto _L1
_L1:
        boolean flag = mOwner.selectAllWrap();
_L12:
        return flag;
_L2:
        int j;
        int k;
        int i = mTextView.getInputType();
        j = i & 0xf;
        k = i & 0xff0;
        if(j != 2 && j != 3 && j != 4 && k != 16 && k != 32 && k != 208 && k != 176) goto _L4; else goto _L3
_L3:
        flag = mOwner.selectAllWrap();
          goto _L5
_L4:
        int l;
        int i1;
        MiuiCursorController miuicursorcontroller = mOwner.getSelectionController();
        l = miuicursorcontroller.getMinTouchOffset();
        i1 = miuicursorcontroller.getMaxTouchOffset();
        if(l >= 0 && l <= mTextView.length()) goto _L7; else goto _L6
_L6:
        flag = false;
          goto _L5
_L7:
        if(i1 >= 0 && i1 <= mTextView.length()) goto _L9; else goto _L8
_L8:
        flag = false;
          goto _L5
_L9:
        CharSequence charsequence;
        URLSpan aurlspan[];
        charsequence = mTextView.getText();
        aurlspan = (URLSpan[])((Spanned)charsequence).getSpans(l, i1, android/text/style/URLSpan);
        if(aurlspan.length < 1) goto _L11; else goto _L10
_L10:
        int j1;
        int k1;
        URLSpan urlspan = aurlspan[0];
        j1 = ((Spanned)charsequence).getSpanStart(urlspan);
        k1 = ((Spanned)charsequence).getSpanEnd(urlspan);
_L13:
        Selection.setSelection((Spannable)charsequence, j1, k1);
        WordIterator worditerator;
        long l1;
        if(k1 > j1)
            flag = true;
        else
            flag = false;
_L5:
        if(true) goto _L12; else goto _L11
_L11:
        worditerator = mOwner.getWordIterator();
        worditerator.setCharSequence(charsequence, l, i1);
        j1 = worditerator.getBeginning(l);
        k1 = worditerator.getEnd(i1);
        if(j1 == -1 || k1 == -1)
            if(i1 == charsequence.length()) {
                j1 = i1 - 1;
                k1 = i1;
            } else {
                j1 = i1;
                k1 = i1 + 1;
            }
        if(j1 == k1) {
            l1 = mOwner.getCharRangeWrap(j1);
            j1 = extractRangeStartFromLong(l1);
            k1 = extractRangeEndFromLong(l1);
        }
          goto _L13
    }

    public void setMinMaxOffset(int i) {
    }

    public abstract void show();

    public abstract void updatePosition();

    public static final int INSERT_CURSOR_TYPE = 1;
    public static final String LOG_TAG = "MiuiCursorController";
    public static final int MAX_CLIP_DATA_NUMBER = 3;
    public static final int SELECT_CURSOR_TYPE = 2;
    protected Context mContext;
    protected Editor mOwner;
    protected TextView mTextView;


}
