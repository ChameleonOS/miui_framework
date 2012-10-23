// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

// Referenced classes of package android.widget:
//            LinearLayout, ImageButton, EditText, Scroller, 
//            TextView, Button

public class NumberPicker extends LinearLayout {
    class BeginSoftInputOnLongPressCommand
        implements Runnable {

        public void run() {
            showSoftInput();
            mIngonreMoveEvents = true;
        }

        final NumberPicker this$0;

        BeginSoftInputOnLongPressCommand() {
            this$0 = NumberPicker.this;
            super();
        }
    }

    public static class CustomEditText extends EditText {

        public void onEditorAction(int i) {
            super.onEditorAction(i);
            if(i == 6)
                clearFocus();
        }

        public CustomEditText(Context context, AttributeSet attributeset) {
            super(context, attributeset);
        }
    }

    class ChangeCurrentByOneFromLongPressCommand
        implements Runnable {

        private void setStep(boolean flag) {
            mIncrement = flag;
        }

        public void run() {
            changeValueByOne(mIncrement);
            postDelayed(this, mLongPressUpdateInterval);
        }

        private boolean mIncrement;
        final NumberPicker this$0;


        ChangeCurrentByOneFromLongPressCommand() {
            this$0 = NumberPicker.this;
            super();
        }
    }

    class SetSelectionCommand
        implements Runnable {

        public void run() {
            mInputText.setSelection(mSelectionStart, mSelectionEnd);
        }

        private int mSelectionEnd;
        private int mSelectionStart;
        final NumberPicker this$0;


/*
        static int access$602(SetSelectionCommand setselectioncommand, int i) {
            setselectioncommand.mSelectionStart = i;
            return i;
        }

*/


/*
        static int access$702(SetSelectionCommand setselectioncommand, int i) {
            setselectioncommand.mSelectionEnd = i;
            return i;
        }

*/

        SetSelectionCommand() {
            this$0 = NumberPicker.this;
            super();
        }
    }

    class InputTextFilter extends NumberKeyListener {

        public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l) {
            if(mDisplayedValues != null) goto _L2; else goto _L1
_L1:
            Object obj;
            CharSequence charsequence1 = filter(charsequence, i, j, spanned, k, l);
            if(charsequence1 == null)
                charsequence1 = charsequence.subSequence(i, j);
            obj = (new StringBuilder()).append(String.valueOf(spanned.subSequence(0, k))).append(charsequence1).append(spanned.subSequence(l, spanned.length())).toString();
            if(!"".equals(obj))
                if(getSelectedPos(((String) (obj))) > mMaxValue)
                    obj = "";
                else
                    obj = charsequence1;
_L4:
            return ((CharSequence) (obj));
_L2:
            String s = String.valueOf(charsequence.subSequence(i, j));
            if(TextUtils.isEmpty(s)) {
                obj = "";
                continue; /* Loop/switch isn't completed */
            }
            String s1 = (new StringBuilder()).append(String.valueOf(spanned.subSequence(0, k))).append(s).append(spanned.subSequence(l, spanned.length())).toString();
            String s2 = String.valueOf(s1).toLowerCase();
            String as[] = mDisplayedValues;
            int i1 = as.length;
            int j1 = 0;
            do {
                if(j1 >= i1)
                    break;
                String s3 = as[j1];
                if(s3.toLowerCase().startsWith(s2)) {
                    postSetSelectionCommand(s1.length(), s3.length());
                    obj = s3.subSequence(k, s3.length());
                    continue; /* Loop/switch isn't completed */
                }
                j1++;
            } while(true);
            obj = "";
            if(true) goto _L4; else goto _L3
_L3:
        }

        protected char[] getAcceptedChars() {
            return NumberPicker.DIGIT_CHARACTERS;
        }

        public int getInputType() {
            return 1;
        }

        final NumberPicker this$0;

        InputTextFilter() {
            this$0 = NumberPicker.this;
            super();
        }
    }

    public static interface Formatter {

        public abstract String format(int i);
    }

    public static interface OnScrollListener {

        public abstract void onScrollStateChange(NumberPicker numberpicker, int i);

        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;
    }

    public static interface OnValueChangeListener {

        public abstract void onValueChange(NumberPicker numberpicker, int i, int j);
    }


    public NumberPicker(Context context) {
        this(context, null);
    }

    public NumberPicker(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x10103c2);
    }

    public NumberPicker(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mLongPressUpdateInterval = 300L;
        mSelectorIndexToStringCache = new SparseArray();
        mSelectorIndices = new int[3];
        mInitialScrollOffset = 0x80000000;
        mScrollState = 0;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.NumberPicker, i, 0);
        int j = typedarray.getResourceId(1, 0x1090078);
        boolean flag;
        if(j != 0x1090078)
            flag = true;
        else
            flag = false;
        mHasSelectorWheel = flag;
        mSolidColor = typedarray.getColor(0, 0);
        mSelectionDivider = typedarray.getDrawable(2);
        mSelectionDividerHeight = typedarray.getDimensionPixelSize(3, (int)TypedValue.applyDimension(1, 2.0F, getResources().getDisplayMetrics()));
        mSelectionDividersDistance = typedarray.getDimensionPixelSize(4, (int)TypedValue.applyDimension(1, 48F, getResources().getDisplayMetrics()));
        mMinHeight = typedarray.getDimensionPixelSize(5, -1);
        mMaxHeight = typedarray.getDimensionPixelSize(6, -1);
        if(mMinHeight != -1 && mMaxHeight != -1 && mMinHeight > mMaxHeight)
            throw new IllegalArgumentException("minHeight > maxHeight");
        mMinWidth = typedarray.getDimensionPixelSize(7, -1);
        mMaxWidth = typedarray.getDimensionPixelSize(8, -1);
        if(mMinWidth != -1 && mMaxWidth != -1 && mMinWidth > mMaxWidth)
            throw new IllegalArgumentException("minWidth > maxWidth");
        boolean flag1;
        boolean flag2;
        android.view.View.OnClickListener onclicklistener;
        android.view.View.OnLongClickListener onlongclicklistener;
        EditText edittext;
        InputFilter ainputfilter[];
        ViewConfiguration viewconfiguration;
        Paint paint;
        if(mMaxWidth == -1)
            flag1 = true;
        else
            flag1 = false;
        mComputeMaxWidth = flag1;
        mVirtualButtonPressedDrawable = typedarray.getDrawable(9);
        typedarray.recycle();
        mPressedStateHelper = new PressedStateHelper();
        if(!mHasSelectorWheel)
            flag2 = true;
        else
            flag2 = false;
        setWillNotDraw(flag2);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(j, this, true);
        onclicklistener = new android.view.View.OnClickListener() {

            public void onClick(View view) {
                hideSoftInput();
                mInputText.clearFocus();
                if(view.getId() == 0x10202fb)
                    changeValueByOne(true);
                else
                    changeValueByOne(false);
            }

            final NumberPicker this$0;

             {
                this$0 = NumberPicker.this;
                super();
            }
        };
        onlongclicklistener = new android.view.View.OnLongClickListener() {

            public boolean onLongClick(View view) {
                hideSoftInput();
                mInputText.clearFocus();
                if(view.getId() == 0x10202fb)
                    postChangeCurrentByOneFromLongPress(true, 0L);
                else
                    postChangeCurrentByOneFromLongPress(false, 0L);
                return true;
            }

            final NumberPicker this$0;

             {
                this$0 = NumberPicker.this;
                super();
            }
        };
        if(!mHasSelectorWheel) {
            mIncrementButton = (ImageButton)findViewById(0x10202fb);
            mIncrementButton.setOnClickListener(onclicklistener);
            mIncrementButton.setOnLongClickListener(onlongclicklistener);
        } else {
            mIncrementButton = null;
        }
        if(!mHasSelectorWheel) {
            mDecrementButton = (ImageButton)findViewById(0x10202fd);
            mDecrementButton.setOnClickListener(onclicklistener);
            mDecrementButton.setOnLongClickListener(onlongclicklistener);
        } else {
            mDecrementButton = null;
        }
        mInputText = (EditText)findViewById(0x10202fc);
        mInputText.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            public void onFocusChange(View view, boolean flag3) {
                if(flag3) {
                    mInputText.selectAll();
                } else {
                    mInputText.setSelection(0, 0);
                    validateInputTextView(view);
                }
            }

            final NumberPicker this$0;

             {
                this$0 = NumberPicker.this;
                super();
            }
        });
        edittext = mInputText;
        ainputfilter = new InputFilter[1];
        ainputfilter[0] = new InputTextFilter();
        edittext.setFilters(ainputfilter);
        mInputText.setRawInputType(2);
        mInputText.setImeOptions(6);
        viewconfiguration = ViewConfiguration.get(context);
        mTouchSlop = viewconfiguration.getScaledTouchSlop();
        mMinimumFlingVelocity = viewconfiguration.getScaledMinimumFlingVelocity();
        mMaximumFlingVelocity = viewconfiguration.getScaledMaximumFlingVelocity() / 8;
        mTextSize = (int)mInputText.getTextSize();
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(android.graphics.Paint.Align.CENTER);
        paint.setTextSize(mTextSize);
        paint.setTypeface(mInputText.getTypeface());
        paint.setColor(mInputText.getTextColors().getColorForState(ENABLED_STATE_SET, -1));
        mSelectorWheelPaint = paint;
        mFlingScroller = new Scroller(getContext(), null, true);
        mAdjustScroller = new Scroller(getContext(), new DecelerateInterpolator(2.5F));
        updateInputTextView();
        if(getImportantForAccessibility() == 0)
            setImportantForAccessibility(1);
    }

    private void changeValueByOne(boolean flag) {
        if(mHasSelectorWheel) {
            mInputText.setVisibility(4);
            if(!moveToFinalScrollerPosition(mFlingScroller))
                moveToFinalScrollerPosition(mAdjustScroller);
            mPreviousScrollerY = 0;
            if(flag)
                mFlingScroller.startScroll(0, 0, 0, -mSelectorElementHeight, 300);
            else
                mFlingScroller.startScroll(0, 0, 0, mSelectorElementHeight, 300);
            invalidate();
        } else
        if(flag)
            setValueInternal(1 + mValue, true);
        else
            setValueInternal(-1 + mValue, true);
    }

    private void decrementSelectorIndices(int ai[]) {
        for(int i = -1 + ai.length; i > 0; i--)
            ai[i] = ai[i - 1];

        int j = -1 + ai[1];
        if(mWrapSelectorWheel && j < mMinValue)
            j = mMaxValue;
        ai[0] = j;
        ensureCachedScrollSelectorValue(j);
    }

    private void ensureCachedScrollSelectorValue(int i) {
        SparseArray sparsearray = mSelectorIndexToStringCache;
        if((String)sparsearray.get(i) == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        if(i >= mMinValue && i <= mMaxValue)
            break; /* Loop/switch isn't completed */
        s = "";
_L4:
        sparsearray.put(i, s);
        if(true) goto _L1; else goto _L3
_L3:
        if(mDisplayedValues != null) {
            int j = i - mMinValue;
            s = mDisplayedValues[j];
        } else {
            s = formatNumber(i);
        }
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    private boolean ensureScrollWheelAdjusted() {
        boolean flag = false;
        int i = mInitialScrollOffset - mCurrentScrollOffset;
        if(i != 0) {
            mPreviousScrollerY = 0;
            if(Math.abs(i) > mSelectorElementHeight / 2) {
                int j;
                if(i > 0)
                    j = -mSelectorElementHeight;
                else
                    j = mSelectorElementHeight;
                i += j;
            }
            mAdjustScroller.startScroll(0, 0, 0, i, 800);
            invalidate();
            flag = true;
        }
        return flag;
    }

    private void fling(int i) {
        mPreviousScrollerY = 0;
        if(i > 0)
            mFlingScroller.fling(0, 0, 0, i, 0, 0, 0, 0x7fffffff);
        else
            mFlingScroller.fling(0, 0x7fffffff, 0, i, 0, 0, 0, 0x7fffffff);
        invalidate();
    }

    private String formatNumber(int i) {
        String s;
        if(mFormatter != null)
            s = mFormatter.format(i);
        else
            s = String.valueOf(i);
        return s;
    }

    private int getSelectedPos(String s) {
        if(mDisplayedValues != null) goto _L2; else goto _L1
_L1:
        int l = Integer.parseInt(s);
        int j = l;
_L4:
        return j;
_L2:
        int i = 0;
        do {
            if(i >= mDisplayedValues.length)
                break;
            s = s.toLowerCase();
            if(mDisplayedValues[i].toLowerCase().startsWith(s)) {
                j = i + mMinValue;
                continue; /* Loop/switch isn't completed */
            }
            i++;
        } while(true);
        int k = Integer.parseInt(s);
        j = k;
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception1;
        numberformatexception1;
_L5:
        j = mMinValue;
        if(true) goto _L4; else goto _L3
_L3:
        NumberFormatException numberformatexception;
        numberformatexception;
          goto _L5
    }

    private int getWrappedSelectorIndex(int i) {
        if(i <= mMaxValue) goto _L2; else goto _L1
_L1:
        i = -1 + (mMinValue + (i - mMaxValue) % (mMaxValue - mMinValue));
_L4:
        return i;
_L2:
        if(i < mMinValue)
            i = 1 + (mMaxValue - (mMinValue - i) % (mMaxValue - mMinValue));
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void hideSoftInput() {
        InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
        if(inputmethodmanager != null && inputmethodmanager.isActive(mInputText)) {
            inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
            if(mHasSelectorWheel)
                mInputText.setVisibility(4);
        }
    }

    private void incrementSelectorIndices(int ai[]) {
        for(int i = 0; i < -1 + ai.length; i++)
            ai[i] = ai[i + 1];

        int j = 1 + ai[-2 + ai.length];
        if(mWrapSelectorWheel && j > mMaxValue)
            j = mMinValue;
        ai[-1 + ai.length] = j;
        ensureCachedScrollSelectorValue(j);
    }

    private void initializeFadingEdges() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength((super.mBottom - super.mTop - mTextSize) / 2);
    }

    private void initializeSelectorWheel() {
        initializeSelectorWheelIndices();
        int ai[] = mSelectorIndices;
        int i = ai.length * mTextSize;
        mSelectorTextGapHeight = (int)(0.5F + (float)(super.mBottom - super.mTop - i) / (float)ai.length);
        mSelectorElementHeight = mTextSize + mSelectorTextGapHeight;
        mInitialScrollOffset = (mInputText.getBaseline() + mInputText.getTop()) - 1 * mSelectorElementHeight;
        mCurrentScrollOffset = mInitialScrollOffset;
        updateInputTextView();
    }

    private void initializeSelectorWheelIndices() {
        mSelectorIndexToStringCache.clear();
        int ai[] = mSelectorIndices;
        int i = getValue();
        for(int j = 0; j < mSelectorIndices.length; j++) {
            int k = i + (j - 1);
            if(mWrapSelectorWheel)
                k = getWrappedSelectorIndex(k);
            ai[j] = k;
            ensureCachedScrollSelectorValue(ai[j]);
        }

    }

    private int makeMeasureSpec(int i, int j) {
        if(j != -1) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        int k = android.view.View.MeasureSpec.getSize(i);
        int l = android.view.View.MeasureSpec.getMode(i);
        switch(l) {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown measure mode: ").append(l).toString());

        case -2147483648: 
            i = android.view.View.MeasureSpec.makeMeasureSpec(Math.min(k, j), 0x40000000);
            break;

        case 0: // '\0'
            i = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
            break;

        case 1073741824: 
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean moveToFinalScrollerPosition(Scroller scroller) {
        boolean flag = true;
        scroller.forceFinished(flag);
        int i = scroller.getFinalY() - scroller.getCurrY();
        int j = (i + mCurrentScrollOffset) % mSelectorElementHeight;
        int k = mInitialScrollOffset - j;
        if(k != 0) {
            if(Math.abs(k) > mSelectorElementHeight / 2)
                if(k > 0)
                    k -= mSelectorElementHeight;
                else
                    k += mSelectorElementHeight;
            scrollBy(0, i + k);
        } else {
            flag = false;
        }
        return flag;
    }

    private void notifyChange(int i, int j) {
        if(mOnValueChangeListener != null)
            mOnValueChangeListener.onValueChange(this, i, mValue);
    }

    private void onScrollStateChange(int i) {
        if(mScrollState != i) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mScrollState = i;
        if(mOnScrollListener != null)
            mOnScrollListener.onScrollStateChange(this, i);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void onScrollerFinished(Scroller scroller) {
        if(scroller != mFlingScroller) goto _L2; else goto _L1
_L1:
        if(!ensureScrollWheelAdjusted())
            updateInputTextView();
        onScrollStateChange(0);
_L4:
        return;
_L2:
        if(mScrollState != 1)
            updateInputTextView();
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void postBeginSoftInputOnLongPressCommand() {
        if(mBeginSoftInputOnLongPressCommand == null)
            mBeginSoftInputOnLongPressCommand = new BeginSoftInputOnLongPressCommand();
        else
            removeCallbacks(mBeginSoftInputOnLongPressCommand);
        postDelayed(mBeginSoftInputOnLongPressCommand, ViewConfiguration.getLongPressTimeout());
    }

    private void postChangeCurrentByOneFromLongPress(boolean flag, long l) {
        if(mChangeCurrentByOneFromLongPressCommand == null)
            mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
        else
            removeCallbacks(mChangeCurrentByOneFromLongPressCommand);
        mChangeCurrentByOneFromLongPressCommand.setStep(flag);
        postDelayed(mChangeCurrentByOneFromLongPressCommand, l);
    }

    private void postSetSelectionCommand(int i, int j) {
        if(mSetSelectionCommand == null)
            mSetSelectionCommand = new SetSelectionCommand();
        else
            removeCallbacks(mSetSelectionCommand);
        mSetSelectionCommand.mSelectionStart = i;
        mSetSelectionCommand.mSelectionEnd = j;
        post(mSetSelectionCommand);
    }

    private void removeAllCallbacks() {
        if(mChangeCurrentByOneFromLongPressCommand != null)
            removeCallbacks(mChangeCurrentByOneFromLongPressCommand);
        if(mSetSelectionCommand != null)
            removeCallbacks(mSetSelectionCommand);
        if(mBeginSoftInputOnLongPressCommand != null)
            removeCallbacks(mBeginSoftInputOnLongPressCommand);
        mPressedStateHelper.cancel();
    }

    private void removeBeginSoftInputCommand() {
        if(mBeginSoftInputOnLongPressCommand != null)
            removeCallbacks(mBeginSoftInputOnLongPressCommand);
    }

    private void removeChangeCurrentByOneFromLongPress() {
        if(mChangeCurrentByOneFromLongPressCommand != null)
            removeCallbacks(mChangeCurrentByOneFromLongPressCommand);
    }

    private int resolveSizeAndStateRespectingMinSize(int i, int j, int k) {
        if(i != -1)
            j = resolveSizeAndState(Math.max(i, j), k, 0);
        return j;
    }

    private void setValueInternal(int i, boolean flag) {
        if(mValue != i) {
            int j;
            int k;
            if(mWrapSelectorWheel)
                j = getWrappedSelectorIndex(i);
            else
                j = Math.min(Math.max(i, mMinValue), mMaxValue);
            k = mValue;
            mValue = j;
            updateInputTextView();
            if(flag)
                notifyChange(k, j);
            initializeSelectorWheelIndices();
            invalidate();
        }
    }

    private void showSoftInput() {
        InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
        if(inputmethodmanager != null) {
            if(mHasSelectorWheel)
                mInputText.setVisibility(0);
            mInputText.requestFocus();
            inputmethodmanager.showSoftInput(mInputText, 0);
        }
    }

    private void tryComputeMaxWidth() {
        if(mComputeMaxWidth) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = 0;
        int l;
        if(mDisplayedValues == null) {
            float f1 = 0.0F;
            for(int i1 = 0; i1 <= 9; i1++) {
                float f2 = mSelectorWheelPaint.measureText(String.valueOf(i1));
                if(f2 > f1)
                    f1 = f2;
            }

            int j1 = 0;
            for(int k1 = mMaxValue; k1 > 0; k1 /= 10)
                j1++;

            i = (int)(f1 * (float)j1);
        } else {
            int j = mDisplayedValues.length;
            int k = 0;
            while(k < j)  {
                float f = mSelectorWheelPaint.measureText(mDisplayedValues[k]);
                if(f > (float)i)
                    i = (int)f;
                k++;
            }
        }
        l = i + (mInputText.getPaddingLeft() + mInputText.getPaddingRight());
        if(mMaxWidth != l) {
            if(l > mMinWidth)
                mMaxWidth = l;
            else
                mMaxWidth = mMinWidth;
            invalidate();
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean updateInputTextView() {
        String s;
        boolean flag;
        if(mDisplayedValues == null)
            s = formatNumber(mValue);
        else
            s = mDisplayedValues[mValue - mMinValue];
        if(!TextUtils.isEmpty(s) && !s.equals(mInputText.getText().toString())) {
            mInputText.setText(s);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    private void validateInputTextView(View view) {
        String s = String.valueOf(((TextView)view).getText());
        if(TextUtils.isEmpty(s))
            updateInputTextView();
        else
            setValueInternal(getSelectedPos(s.toString()), true);
    }

    public void addFocusables(ArrayList arraylist, int i, int j) {
        if((j & 2) == 2 && isAccessibilityFocusable())
            arraylist.add(this);
        else
            super.addFocusables(arraylist, i, j);
    }

    public void computeScroll() {
        Scroller scroller = mFlingScroller;
        if(!scroller.isFinished()) goto _L2; else goto _L1
_L1:
        scroller = mAdjustScroller;
        if(!scroller.isFinished()) goto _L2; else goto _L3
_L3:
        return;
_L2:
        scroller.computeScrollOffset();
        int i = scroller.getCurrY();
        if(mPreviousScrollerY == 0)
            mPreviousScrollerY = scroller.getStartY();
        scrollBy(0, i - mPreviousScrollerY);
        mPreviousScrollerY = i;
        if(scroller.isFinished())
            onScrollerFinished(scroller);
        else
            invalidate();
        if(true) goto _L3; else goto _L4
_L4:
    }

    protected boolean dispatchHoverEvent(MotionEvent motionevent) {
        if(mHasSelectorWheel) goto _L2; else goto _L1
_L1:
        boolean flag = super.dispatchHoverEvent(motionevent);
_L10:
        return flag;
_L2:
        if(!AccessibilityManager.getInstance(super.mContext).isEnabled()) goto _L4; else goto _L3
_L3:
        int j;
        AccessibilityNodeProviderImpl accessibilitynodeproviderimpl;
        int i = (int)motionevent.getY();
        int k;
        if(i < mTopSelectionDividerTop)
            j = 3;
        else
        if(i > mBottomSelectionDividerBottom)
            j = 1;
        else
            j = 2;
        k = motionevent.getActionMasked();
        accessibilitynodeproviderimpl = (AccessibilityNodeProviderImpl)getAccessibilityNodeProvider();
        k;
        JVM INSTR tableswitch 7 10: default 92
    //                   7 147
    //                   8 92
    //                   9 117
    //                   10 207;
           goto _L5 _L6 _L5 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_207;
_L5:
        break; /* Loop/switch isn't completed */
_L7:
        break; /* Loop/switch isn't completed */
_L4:
        flag = false;
        if(true) goto _L10; else goto _L9
_L9:
        accessibilitynodeproviderimpl.sendAccessibilityEventForVirtualView(j, 128);
        mLastHoveredChildVirtualViewId = j;
        accessibilitynodeproviderimpl.performAction(j, 64, null);
          goto _L4
_L6:
        if(mLastHoveredChildVirtualViewId != j && mLastHoveredChildVirtualViewId != -1) {
            accessibilitynodeproviderimpl.sendAccessibilityEventForVirtualView(mLastHoveredChildVirtualViewId, 256);
            accessibilitynodeproviderimpl.sendAccessibilityEventForVirtualView(j, 128);
            mLastHoveredChildVirtualViewId = j;
            accessibilitynodeproviderimpl.performAction(j, 64, null);
        }
          goto _L4
        accessibilitynodeproviderimpl.sendAccessibilityEventForVirtualView(j, 256);
        mLastHoveredChildVirtualViewId = -1;
          goto _L4
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 2: default 32
    //                   23: 38
    //                   66: 38;
           goto _L1 _L2 _L2
_L1:
        return super.dispatchKeyEvent(keyevent);
_L2:
        removeAllCallbacks();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent) {
        motionevent.getActionMasked();
        JVM INSTR tableswitch 1 3: default 32
    //                   1 38
    //                   2 32
    //                   3 38;
           goto _L1 _L2 _L1 _L2
_L1:
        return super.dispatchTouchEvent(motionevent);
_L2:
        removeAllCallbacks();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean dispatchTrackballEvent(MotionEvent motionevent) {
        motionevent.getActionMasked();
        JVM INSTR tableswitch 1 3: default 32
    //                   1 38
    //                   2 32
    //                   3 38;
           goto _L1 _L2 _L1 _L2
_L1:
        return super.dispatchTrackballEvent(motionevent);
_L2:
        removeAllCallbacks();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        Object obj;
        if(!mHasSelectorWheel) {
            obj = super.getAccessibilityNodeProvider();
        } else {
            if(mAccessibilityNodeProvider == null)
                mAccessibilityNodeProvider = new AccessibilityNodeProviderImpl();
            obj = mAccessibilityNodeProvider;
        }
        return ((AccessibilityNodeProvider) (obj));
    }

    protected float getBottomFadingEdgeStrength() {
        return 0.9F;
    }

    public String[] getDisplayedValues() {
        return mDisplayedValues;
    }

    public int getMaxValue() {
        return mMaxValue;
    }

    public int getMinValue() {
        return mMinValue;
    }

    public int getSolidColor() {
        return mSolidColor;
    }

    protected float getTopFadingEdgeStrength() {
        return 0.9F;
    }

    public int getValue() {
        return mValue;
    }

    public boolean getWrapSelectorWheel() {
        return mWrapSelectorWheel;
    }

    protected void onDetachedFromWindow() {
        removeAllCallbacks();
    }

    protected void onDraw(Canvas canvas) {
        if(mHasSelectorWheel) goto _L2; else goto _L1
_L1:
        super.onDraw(canvas);
_L4:
        return;
_L2:
        float f = (super.mRight - super.mLeft) / 2;
        float f1 = mCurrentScrollOffset;
        if(mVirtualButtonPressedDrawable != null && mScrollState == 0) {
            if(mDecrementVirtualButtonPressed) {
                mVirtualButtonPressedDrawable.setState(PRESSED_STATE_SET);
                mVirtualButtonPressedDrawable.setBounds(0, 0, super.mRight, mTopSelectionDividerTop);
                mVirtualButtonPressedDrawable.draw(canvas);
            }
            if(mIncrementVirtualButtonPressed) {
                mVirtualButtonPressedDrawable.setState(PRESSED_STATE_SET);
                mVirtualButtonPressedDrawable.setBounds(0, mBottomSelectionDividerBottom, super.mRight, super.mBottom);
                mVirtualButtonPressedDrawable.draw(canvas);
            }
        }
        int ai[] = mSelectorIndices;
        for(int i = 0; i < ai.length; i++) {
            int j1 = ai[i];
            String s = (String)mSelectorIndexToStringCache.get(j1);
            if(i != 1 || mInputText.getVisibility() != 0)
                canvas.drawText(s, f, f1, mSelectorWheelPaint);
            f1 += mSelectorElementHeight;
        }

        if(mSelectionDivider != null) {
            int j = mTopSelectionDividerTop;
            int k = j + mSelectionDividerHeight;
            mSelectionDivider.setBounds(0, j, super.mRight, k);
            mSelectionDivider.draw(canvas);
            int l = mBottomSelectionDividerBottom;
            int i1 = l - mSelectionDividerHeight;
            mSelectionDivider.setBounds(0, i1, super.mRight, l);
            mSelectionDivider.draw(canvas);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/NumberPicker.getName());
        accessibilityevent.setScrollable(true);
        accessibilityevent.setScrollY((mMinValue + mValue) * mSelectorElementHeight);
        accessibilityevent.setMaxScrollY((mMaxValue - mMinValue) * mSelectorElementHeight);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent) {
        boolean flag = true;
        if(mHasSelectorWheel && isEnabled()) goto _L2; else goto _L1
_L1:
        flag = false;
_L8:
        return flag;
_L2:
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 0: default 44
    //                   0 49;
           goto _L3 _L4
_L3:
        flag = false;
          goto _L5
_L4:
        removeAllCallbacks();
        mInputText.setVisibility(4);
        float f = motionevent.getY();
        mLastDownEventY = f;
        mLastDownOrMoveEventY = f;
        mLastDownEventTime = motionevent.getEventTime();
        mIngonreMoveEvents = false;
        mShowSoftInputOnTap = false;
        if(mLastDownEventY >= (float)mTopSelectionDividerTop) goto _L7; else goto _L6
_L6:
        if(mScrollState == 0)
            mPressedStateHelper.buttonPressDelayed(2);
_L9:
        getParent().requestDisallowInterceptTouchEvent(flag);
        if(!mFlingScroller.isFinished()) {
            mFlingScroller.forceFinished(flag);
            mAdjustScroller.forceFinished(flag);
            onScrollStateChange(0);
        } else
        if(!mAdjustScroller.isFinished()) {
            mFlingScroller.forceFinished(flag);
            mAdjustScroller.forceFinished(flag);
        } else
        if(mLastDownEventY < (float)mTopSelectionDividerTop) {
            hideSoftInput();
            postChangeCurrentByOneFromLongPress(false, ViewConfiguration.getLongPressTimeout());
        } else
        if(mLastDownEventY > (float)mBottomSelectionDividerBottom) {
            hideSoftInput();
            postChangeCurrentByOneFromLongPress(flag, ViewConfiguration.getLongPressTimeout());
        } else {
            mShowSoftInputOnTap = flag;
            postBeginSoftInputOnLongPressCommand();
        }
_L5:
        if(true) goto _L8; else goto _L7
_L7:
        if(mLastDownEventY > (float)mBottomSelectionDividerBottom && mScrollState == 0)
            mPressedStateHelper.buttonPressDelayed(flag);
          goto _L9
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        if(mHasSelectorWheel) goto _L2; else goto _L1
_L1:
        super.onLayout(flag, i, j, k, l);
_L4:
        return;
_L2:
        int i1 = getMeasuredWidth();
        int j1 = getMeasuredHeight();
        int k1 = mInputText.getMeasuredWidth();
        int l1 = mInputText.getMeasuredHeight();
        int i2 = (i1 - k1) / 2;
        int j2 = (j1 - l1) / 2;
        int k2 = i2 + k1;
        int l2 = j2 + l1;
        mInputText.layout(i2, j2, k2, l2);
        if(flag) {
            initializeSelectorWheel();
            initializeFadingEdges();
            mTopSelectionDividerTop = (getHeight() - mSelectionDividersDistance) / 2 - mSelectionDividerHeight;
            mBottomSelectionDividerBottom = mTopSelectionDividerTop + 2 * mSelectionDividerHeight + mSelectionDividersDistance;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void onMeasure(int i, int j) {
        if(!mHasSelectorWheel) {
            super.onMeasure(i, j);
        } else {
            super.onMeasure(makeMeasureSpec(i, mMaxWidth), makeMeasureSpec(j, mMaxHeight));
            setMeasuredDimension(resolveSizeAndStateRespectingMinSize(mMinWidth, getMeasuredWidth(), i), resolveSizeAndStateRespectingMinSize(mMinHeight, getMeasuredHeight(), j));
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        if(isEnabled() && mHasSelectorWheel) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        if(mVelocityTracker == null)
            mVelocityTracker = VelocityTracker.obtain();
        mVelocityTracker.addMovement(motionevent);
        switch(motionevent.getActionMasked()) {
        default:
            break;

        case 2: // '\002'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            break;
        }
        break MISSING_BLOCK_LABEL_150;
_L5:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
        if(!mIngonreMoveEvents) {
            float f = motionevent.getY();
            if(mScrollState != 1) {
                if((int)Math.abs(f - mLastDownEventY) > mTouchSlop) {
                    removeAllCallbacks();
                    onScrollStateChange(1);
                }
            } else {
                scrollBy(0, (int)(f - mLastDownOrMoveEventY));
                invalidate();
            }
            mLastDownOrMoveEventY = f;
        }
          goto _L5
        removeBeginSoftInputCommand();
        removeChangeCurrentByOneFromLongPress();
        mPressedStateHelper.cancel();
        VelocityTracker velocitytracker = mVelocityTracker;
        velocitytracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
        int i = (int)velocitytracker.getYVelocity();
        if(Math.abs(i) > mMinimumFlingVelocity) {
            fling(i);
            onScrollStateChange(2);
        } else {
            int j = (int)motionevent.getY();
            int k = (int)Math.abs((float)j - mLastDownEventY);
            long l = motionevent.getEventTime() - mLastDownEventTime;
            if(k <= mTouchSlop && l < (long)ViewConfiguration.getTapTimeout()) {
                if(mShowSoftInputOnTap) {
                    mShowSoftInputOnTap = false;
                    showSoftInput();
                } else {
                    int i1 = -1 + j / mSelectorElementHeight;
                    if(i1 > 0) {
                        changeValueByOne(true);
                        mPressedStateHelper.buttonTapped(1);
                    } else
                    if(i1 < 0) {
                        changeValueByOne(false);
                        mPressedStateHelper.buttonTapped(2);
                    }
                }
            } else {
                ensureScrollWheelAdjusted();
            }
            onScrollStateChange(0);
        }
        mVelocityTracker.recycle();
        mVelocityTracker = null;
          goto _L5
    }

    public void scrollBy(int i, int j) {
        int ai[] = mSelectorIndices;
        if(mWrapSelectorWheel || j <= 0 || ai[1] > mMinValue) goto _L2; else goto _L1
_L1:
        mCurrentScrollOffset = mInitialScrollOffset;
_L4:
        return;
_L2:
        if(mWrapSelectorWheel || j >= 0 || ai[1] < mMaxValue)
            break; /* Loop/switch isn't completed */
        mCurrentScrollOffset = mInitialScrollOffset;
        if(true) goto _L4; else goto _L3
_L3:
        mCurrentScrollOffset = j + mCurrentScrollOffset;
        do {
            if(mCurrentScrollOffset - mInitialScrollOffset <= mSelectorTextGapHeight)
                break;
            mCurrentScrollOffset = mCurrentScrollOffset - mSelectorElementHeight;
            decrementSelectorIndices(ai);
            setValueInternal(ai[1], true);
            if(!mWrapSelectorWheel && ai[1] <= mMinValue)
                mCurrentScrollOffset = mInitialScrollOffset;
        } while(true);
        while(mCurrentScrollOffset - mInitialScrollOffset < -mSelectorTextGapHeight)  {
            mCurrentScrollOffset = mCurrentScrollOffset + mSelectorElementHeight;
            incrementSelectorIndices(ai);
            setValueInternal(ai[1], true);
            if(!mWrapSelectorWheel && ai[1] >= mMaxValue)
                mCurrentScrollOffset = mInitialScrollOffset;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    public void setDisplayedValues(String as[]) {
        if(mDisplayedValues != as) {
            mDisplayedValues = as;
            if(mDisplayedValues != null)
                mInputText.setRawInputType(0x80001);
            else
                mInputText.setRawInputType(2);
            updateInputTextView();
            initializeSelectorWheelIndices();
            tryComputeMaxWidth();
        }
    }

    public void setEnabled(boolean flag) {
        super.setEnabled(flag);
        if(!mHasSelectorWheel)
            mIncrementButton.setEnabled(flag);
        if(!mHasSelectorWheel)
            mDecrementButton.setEnabled(flag);
        mInputText.setEnabled(flag);
    }

    public void setFormatter(Formatter formatter) {
        if(formatter != mFormatter) {
            mFormatter = formatter;
            initializeSelectorWheelIndices();
            updateInputTextView();
        }
    }

    public void setMaxValue(int i) {
        if(mMaxValue != i) {
            if(i < 0)
                throw new IllegalArgumentException("maxValue must be >= 0");
            mMaxValue = i;
            if(mMaxValue < mValue)
                mValue = mMaxValue;
            boolean flag;
            if(mMaxValue - mMinValue > mSelectorIndices.length)
                flag = true;
            else
                flag = false;
            setWrapSelectorWheel(flag);
            initializeSelectorWheelIndices();
            updateInputTextView();
            tryComputeMaxWidth();
            invalidate();
        }
    }

    public void setMinValue(int i) {
        if(mMinValue != i) {
            if(i < 0)
                throw new IllegalArgumentException("minValue must be >= 0");
            mMinValue = i;
            if(mMinValue > mValue)
                mValue = mMinValue;
            boolean flag;
            if(mMaxValue - mMinValue > mSelectorIndices.length)
                flag = true;
            else
                flag = false;
            setWrapSelectorWheel(flag);
            initializeSelectorWheelIndices();
            updateInputTextView();
            tryComputeMaxWidth();
            invalidate();
        }
    }

    public void setOnLongPressUpdateInterval(long l) {
        mLongPressUpdateInterval = l;
    }

    public void setOnScrollListener(OnScrollListener onscrolllistener) {
        mOnScrollListener = onscrolllistener;
    }

    public void setOnValueChangedListener(OnValueChangeListener onvaluechangelistener) {
        mOnValueChangeListener = onvaluechangelistener;
    }

    public void setValue(int i) {
        setValueInternal(i, false);
    }

    public void setWrapSelectorWheel(boolean flag) {
        boolean flag1;
        if(mMaxValue - mMinValue >= mSelectorIndices.length)
            flag1 = true;
        else
            flag1 = false;
        if((!flag || flag1) && flag != mWrapSelectorWheel)
            mWrapSelectorWheel = flag;
    }

    private static final int DEFAULT_LAYOUT_RESOURCE_ID = 0x1090078;
    private static final long DEFAULT_LONG_PRESS_UPDATE_INTERVAL = 300L;
    private static final char DIGIT_CHARACTERS[];
    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
    private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 8;
    private static final int SELECTOR_MIDDLE_ITEM_INDEX = 1;
    private static final int SELECTOR_WHEEL_ITEM_COUNT = 3;
    private static final int SIZE_UNSPECIFIED = -1;
    private static final int SNAP_SCROLL_DURATION = 300;
    private static final float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 0.9F;
    public static final Formatter TWO_DIGIT_FORMATTER = new Formatter() {

        public String format(int i) {
            mArgs[0] = Integer.valueOf(i);
            mBuilder.delete(0, mBuilder.length());
            mFmt.format("%02d", mArgs);
            return mFmt.toString();
        }

        final Object mArgs[] = new Object[1];
        final StringBuilder mBuilder = new StringBuilder();
        final java.util.Formatter mFmt;

             {
                mFmt = new java.util.Formatter(mBuilder, Locale.US);
            }
    };
    private static final int UNSCALED_DEFAULT_SELECTION_DIVIDERS_DISTANCE = 48;
    private static final int UNSCALED_DEFAULT_SELECTION_DIVIDER_HEIGHT = 2;
    private AccessibilityNodeProviderImpl mAccessibilityNodeProvider;
    private final Scroller mAdjustScroller;
    private BeginSoftInputOnLongPressCommand mBeginSoftInputOnLongPressCommand;
    private int mBottomSelectionDividerBottom;
    private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;
    private final boolean mComputeMaxWidth;
    private int mCurrentScrollOffset;
    private final ImageButton mDecrementButton;
    private boolean mDecrementVirtualButtonPressed;
    private String mDisplayedValues[];
    private final Scroller mFlingScroller;
    private Formatter mFormatter;
    private final boolean mHasSelectorWheel;
    private final ImageButton mIncrementButton;
    private boolean mIncrementVirtualButtonPressed;
    private boolean mIngonreMoveEvents;
    private int mInitialScrollOffset;
    private final EditText mInputText;
    private long mLastDownEventTime;
    private float mLastDownEventY;
    private float mLastDownOrMoveEventY;
    private int mLastHoveredChildVirtualViewId;
    private long mLongPressUpdateInterval;
    private final int mMaxHeight;
    private int mMaxValue;
    private int mMaxWidth;
    private int mMaximumFlingVelocity;
    private final int mMinHeight;
    private int mMinValue;
    private final int mMinWidth;
    private int mMinimumFlingVelocity;
    private OnScrollListener mOnScrollListener;
    private OnValueChangeListener mOnValueChangeListener;
    private final PressedStateHelper mPressedStateHelper;
    private int mPreviousScrollerY;
    private int mScrollState;
    private final Drawable mSelectionDivider;
    private final int mSelectionDividerHeight;
    private final int mSelectionDividersDistance;
    private int mSelectorElementHeight;
    private final SparseArray mSelectorIndexToStringCache;
    private final int mSelectorIndices[];
    private int mSelectorTextGapHeight;
    private final Paint mSelectorWheelPaint;
    private SetSelectionCommand mSetSelectionCommand;
    private boolean mShowSoftInputOnTap;
    private final int mSolidColor;
    private final int mTextSize;
    private int mTopSelectionDividerTop;
    private int mTouchSlop;
    private int mValue;
    private VelocityTracker mVelocityTracker;
    private final Drawable mVirtualButtonPressedDrawable;
    private boolean mWrapSelectorWheel;

    static  {
        char ac[] = new char[10];
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        DIGIT_CHARACTERS = ac;
    }








/*
    static boolean access$1302(NumberPicker numberpicker, boolean flag) {
        numberpicker.mIncrementVirtualButtonPressed = flag;
        return flag;
    }

*/


/*
    static boolean access$1380(NumberPicker numberpicker, int i) {
        boolean flag = (byte)(i ^ numberpicker.mIncrementVirtualButtonPressed);
        numberpicker.mIncrementVirtualButtonPressed = flag;
        return flag;
    }

*/






/*
    static boolean access$1702(NumberPicker numberpicker, boolean flag) {
        numberpicker.mDecrementVirtualButtonPressed = flag;
        return flag;
    }

*/


/*
    static boolean access$1780(NumberPicker numberpicker, int i) {
        boolean flag = (byte)(i ^ numberpicker.mDecrementVirtualButtonPressed);
        numberpicker.mDecrementVirtualButtonPressed = flag;
        return flag;
    }

*/













/*
    static boolean access$2802(NumberPicker numberpicker, boolean flag) {
        numberpicker.mIngonreMoveEvents = flag;
        return flag;
    }

*/









































}
