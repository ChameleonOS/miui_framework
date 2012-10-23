// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.*;
import android.database.DataSetObserver;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.*;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.text.*;
import java.util.*;
import libcore.icu.LocaleData;

// Referenced classes of package android.widget:
//            FrameLayout, ListView, TextView, AbsListView, 
//            BaseAdapter

public class CalendarView extends FrameLayout {
    private class WeekView extends View {

        private void drawBackground(Canvas canvas) {
            if(mHasSelectedDay) {
                mDrawPaint.setColor(mSelectedWeekBackgroundColor);
                mTempRect.top = mWeekSeperatorLineWidth;
                mTempRect.bottom = mHeight;
                Rect rect = mTempRect;
                int i;
                if(mShowWeekNumber)
                    i = mWidth / mNumCells;
                else
                    i = 0;
                rect.left = i;
                mTempRect.right = -2 + mSelectedLeft;
                canvas.drawRect(mTempRect, mDrawPaint);
                mTempRect.left = 3 + mSelectedRight;
                mTempRect.right = mWidth;
                canvas.drawRect(mTempRect, mDrawPaint);
            }
        }

        private void drawSelectedDateVerticalBars(Canvas canvas) {
            if(mHasSelectedDay) {
                mSelectedDateVerticalBar.setBounds(mSelectedLeft - mSelectedDateVerticalBarWidth / 2, mWeekSeperatorLineWidth, mSelectedLeft + mSelectedDateVerticalBarWidth / 2, mHeight);
                mSelectedDateVerticalBar.draw(canvas);
                mSelectedDateVerticalBar.setBounds(mSelectedRight - mSelectedDateVerticalBarWidth / 2, mWeekSeperatorLineWidth, mSelectedRight + mSelectedDateVerticalBarWidth / 2, mHeight);
                mSelectedDateVerticalBar.draw(canvas);
            }
        }

        private void drawWeekNumbersAndDates(Canvas canvas) {
            int i = (int)((mDrawPaint.getTextSize() + (float)mHeight) / 2.0F) - mWeekSeperatorLineWidth;
            int j = mNumCells;
            mDrawPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
            mDrawPaint.setTextSize(mDateTextSize);
            int k = 0;
            int l = j * 2;
            if(mShowWeekNumber) {
                mDrawPaint.setColor(mWeekNumberColor);
                int k1 = mWidth / l;
                canvas.drawText(mDayNumbers[0], k1, i, mDrawPaint);
                k = 0 + 1;
            }
            while(k < j)  {
                Paint paint = mMonthNumDrawPaint;
                int i1;
                int j1;
                if(mFocusDay[k])
                    i1 = mFocusedMonthDateColor;
                else
                    i1 = mUnfocusedMonthDateColor;
                paint.setColor(i1);
                j1 = ((1 + k * 2) * mWidth) / l;
                canvas.drawText(mDayNumbers[k], j1, i, mMonthNumDrawPaint);
                k++;
            }
        }

        private void drawWeekSeparators(Canvas canvas) {
            int i = mListView.getFirstVisiblePosition();
            if(mListView.getChildAt(0).getTop() < 0)
                i++;
            if(i != mWeek) {
                mDrawPaint.setColor(mWeekSeparatorLineColor);
                mDrawPaint.setStrokeWidth(mWeekSeperatorLineWidth);
                float f;
                if(mShowWeekNumber)
                    f = mWidth / mNumCells;
                else
                    f = 0.0F;
                canvas.drawLine(f, 0.0F, mWidth, 0.0F, mDrawPaint);
            }
        }

        private void initilaizePaints() {
            mDrawPaint.setFakeBoldText(false);
            mDrawPaint.setAntiAlias(true);
            mDrawPaint.setStyle(android.graphics.Paint.Style.FILL);
            mMonthNumDrawPaint.setFakeBoldText(true);
            mMonthNumDrawPaint.setAntiAlias(true);
            mMonthNumDrawPaint.setStyle(android.graphics.Paint.Style.FILL);
            mMonthNumDrawPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
        }

        private void updateSelectionPositions() {
            if(mHasSelectedDay) {
                int i = mSelectedDay - mFirstDayOfWeek;
                if(i < 0)
                    i += 7;
                if(mShowWeekNumber)
                    i++;
                mSelectedLeft = (i * mWidth) / mNumCells;
                mSelectedRight = ((i + 1) * mWidth) / mNumCells;
            }
        }

        public boolean getDayFromLocation(float f, Calendar calendar) {
            boolean flag = false;
            int i;
            if(mShowWeekNumber)
                i = mWidth / mNumCells;
            else
                i = 0;
            if(f < (float)i || f > (float)mWidth) {
                calendar.clear();
            } else {
                int j = (int)(((f - (float)i) * (float)mDaysPerWeek) / (float)(mWidth - i));
                calendar.setTimeInMillis(mFirstDay.getTimeInMillis());
                calendar.add(5, j);
                flag = true;
            }
            return flag;
        }

        public Calendar getFirstDay() {
            return mFirstDay;
        }

        public int getMonthOfFirstWeekDay() {
            return mMonthOfFirstWeekDay;
        }

        public int getMonthOfLastWeekDay() {
            return mLastWeekDayMonth;
        }

        public void init(int i, int j, int k) {
            mSelectedDay = j;
            boolean flag;
            int l;
            int i1;
            int j1;
            if(mSelectedDay != -1)
                flag = true;
            else
                flag = false;
            mHasSelectedDay = flag;
            if(mShowWeekNumber)
                l = 1 + mDaysPerWeek;
            else
                l = mDaysPerWeek;
            mNumCells = l;
            mWeek = i;
            mTempDate.setTimeInMillis(mMinDate.getTimeInMillis());
            mTempDate.add(3, mWeek);
            mTempDate.setFirstDayOfWeek(mFirstDayOfWeek);
            mDayNumbers = new String[mNumCells];
            mFocusDay = new boolean[mNumCells];
            i1 = 0;
            if(mShowWeekNumber) {
                mDayNumbers[0] = Integer.toString(mTempDate.get(3));
                i1 = 0 + 1;
            }
            j1 = mFirstDayOfWeek - mTempDate.get(7);
            mTempDate.add(5, j1);
            mFirstDay = (Calendar)mTempDate.clone();
            mMonthOfFirstWeekDay = mTempDate.get(2);
            mHasUnfocusedDay = true;
            while(i1 < mNumCells)  {
                boolean flag1;
                boolean flag2;
                boolean flag3;
                if(mTempDate.get(2) == k)
                    flag1 = true;
                else
                    flag1 = false;
                mFocusDay[i1] = flag1;
                mHasFocusedDay = flag1 | mHasFocusedDay;
                flag2 = mHasUnfocusedDay;
                if(!flag1)
                    flag3 = true;
                else
                    flag3 = false;
                mHasUnfocusedDay = flag3 & flag2;
                if(mTempDate.before(mMinDate) || mTempDate.after(mMaxDate))
                    mDayNumbers[i1] = "";
                else
                    mDayNumbers[i1] = Integer.toString(mTempDate.get(5));
                mTempDate.add(5, 1);
                i1++;
            }
            if(mTempDate.get(5) == 1)
                mTempDate.add(5, -1);
            mLastWeekDayMonth = mTempDate.get(2);
            updateSelectionPositions();
        }

        protected void onDraw(Canvas canvas) {
            drawBackground(canvas);
            drawWeekNumbersAndDates(canvas);
            drawWeekSeparators(canvas);
            drawSelectedDateVerticalBars(canvas);
        }

        protected void onMeasure(int i, int j) {
            mHeight = (mListView.getHeight() - mListView.getPaddingTop() - mListView.getPaddingBottom()) / mShownWeekCount;
            setMeasuredDimension(android.view.View.MeasureSpec.getSize(i), mHeight);
        }

        protected void onSizeChanged(int i, int j, int k, int l) {
            mWidth = i;
            updateSelectionPositions();
        }

        private String mDayNumbers[];
        private final Paint mDrawPaint = new Paint();
        private Calendar mFirstDay;
        private boolean mFocusDay[];
        private boolean mHasFocusedDay;
        private boolean mHasSelectedDay;
        private boolean mHasUnfocusedDay;
        private int mHeight;
        private int mLastWeekDayMonth;
        private final Paint mMonthNumDrawPaint = new Paint();
        private int mMonthOfFirstWeekDay;
        private int mNumCells;
        private int mSelectedDay;
        private int mSelectedLeft;
        private int mSelectedRight;
        private final Rect mTempRect = new Rect();
        private int mWeek;
        private int mWidth;
        final CalendarView this$0;




        public WeekView(Context context) {
            this$0 = CalendarView.this;
            super(context);
            mMonthOfFirstWeekDay = -1;
            mLastWeekDayMonth = -1;
            mWeek = -1;
            mHasSelectedDay = false;
            mSelectedDay = -1;
            mSelectedLeft = -1;
            mSelectedRight = -1;
            initilaizePaints();
        }
    }

    /* member class not found */
    class WeeksAdapter {}

    private class ScrollStateRunnable
        implements Runnable {

        public void doScrollStateChange(AbsListView abslistview, int i) {
            mView = abslistview;
            mNewState = i;
            removeCallbacks(this);
            postDelayed(this, 40L);
        }

        public void run() {
            mCurrentScrollState = mNewState;
            if(mNewState != 0 || mPreviousScrollState == 0) goto _L2; else goto _L1
_L1:
            View view = mView.getChildAt(0);
            if(view != null) goto _L4; else goto _L3
_L3:
            return;
_L4:
            int i = view.getBottom() - mListScrollTopOffset;
            if(i > mListScrollTopOffset)
                if(mIsScrollingUp)
                    mView.smoothScrollBy(i - view.getHeight(), 500);
                else
                    mView.smoothScrollBy(i, 500);
_L2:
            mPreviousScrollState = mNewState;
            if(true) goto _L3; else goto _L5
_L5:
        }

        private int mNewState;
        private AbsListView mView;
        final CalendarView this$0;

        private ScrollStateRunnable() {
            this$0 = CalendarView.this;
            Object();
        }

    }

    public static interface OnDateChangeListener {

        public abstract void onSelectedDayChange(CalendarView calendarview, int i, int j, int k);
    }


    public CalendarView(Context context) {
        CalendarView(context, null);
    }

    public CalendarView(Context context, AttributeSet attributeset) {
        CalendarView(context, attributeset, 0);
    }

    public CalendarView(Context context, AttributeSet attributeset, int i) {
        FrameLayout(context, attributeset, 0);
        mListScrollTopOffset = 2;
        mWeekMinVisibleHeight = 12;
        mBottomBuffer = 20;
        mDaysPerWeek = 7;
        mFriction = 0.05F;
        mVelocityScale = 0.333F;
        mIsScrollingUp = false;
        mPreviousScrollState = 0;
        mCurrentScrollState = 0;
        mScrollStateChangedRunnable = new ScrollStateRunnable();
        mDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        setCurrentLocale(Locale.getDefault());
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.CalendarView, 0x101035d, 0);
        mShowWeekNumber = typedarray.getBoolean(1, true);
        mFirstDayOfWeek = typedarray.getInt(0, LocaleData.get(Locale.getDefault()).firstDayOfWeek.intValue());
        String s = typedarray.getString(2);
        if(TextUtils.isEmpty(s) || !parseDate(s, mMinDate))
            parseDate("01/01/1900", mMinDate);
        String s1 = typedarray.getString(3);
        if(TextUtils.isEmpty(s1) || !parseDate(s1, mMaxDate))
            parseDate("01/01/2100", mMaxDate);
        if(mMaxDate.before(mMinDate))
            throw new IllegalArgumentException("Max date cannot be before min date.");
        mShownWeekCount = typedarray.getInt(4, 6);
        mSelectedWeekBackgroundColor = typedarray.getColor(5, 0);
        mFocusedMonthDateColor = typedarray.getColor(6, 0);
        mUnfocusedMonthDateColor = typedarray.getColor(7, 0);
        mWeekSeparatorLineColor = typedarray.getColor(9, 0);
        mWeekNumberColor = typedarray.getColor(8, 0);
        mSelectedDateVerticalBar = typedarray.getDrawable(10);
        mDateTextAppearanceResId = typedarray.getResourceId(12, 0x1030046);
        updateDateTextSize();
        mWeekDayTextAppearanceResId = typedarray.getResourceId(11, -1);
        typedarray.recycle();
        android.util.DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        mWeekMinVisibleHeight = (int)TypedValue.applyDimension(1, 12F, displaymetrics);
        mListScrollTopOffset = (int)TypedValue.applyDimension(1, 2.0F, displaymetrics);
        mBottomBuffer = (int)TypedValue.applyDimension(1, 20F, displaymetrics);
        mSelectedDateVerticalBarWidth = (int)TypedValue.applyDimension(1, 6F, displaymetrics);
        mWeekSeperatorLineWidth = (int)TypedValue.applyDimension(1, 1.0F, displaymetrics);
        View view = ((LayoutInflater)super.mContext.getSystemService("layout_inflater")).inflate(0x109002e, null, false);
        addView(view);
        mListView = (ListView)findViewById(0x102000a);
        mDayNamesHeader = (ViewGroup)view.findViewById(0x1020267);
        mMonthName = (TextView)view.findViewById(0x1020266);
        setUpHeader();
        setUpListView();
        setUpAdapter();
        mTempDate.setTimeInMillis(System.currentTimeMillis());
        if(mTempDate.before(mMinDate))
            goTo(mMinDate, false, true, true);
        else
        if(mMaxDate.before(mTempDate))
            goTo(mMaxDate, false, true, true);
        else
            goTo(mTempDate, false, true, true);
        invalidate();
    }

    private Calendar getCalendarForLocale(Calendar calendar, Locale locale) {
        Calendar calendar1;
        if(calendar == null) {
            calendar1 = Calendar.getInstance(locale);
        } else {
            long l = calendar.getTimeInMillis();
            calendar1 = Calendar.getInstance(locale);
            calendar1.setTimeInMillis(l);
        }
        return calendar1;
    }

    private int getWeeksSinceMinDate(Calendar calendar) {
        if(calendar.before(mMinDate)) {
            throw new IllegalArgumentException((new StringBuilder()).append("fromDate: ").append(mMinDate.getTime()).append(" does not precede toDate: ").append(calendar.getTime()).toString());
        } else {
            long l = calendar.getTimeInMillis() + (long)calendar.getTimeZone().getOffset(calendar.getTimeInMillis());
            long l1 = mMinDate.getTimeInMillis() + (long)mMinDate.getTimeZone().getOffset(mMinDate.getTimeInMillis());
            return (int)((0x5265c00L * (long)(mMinDate.get(7) - mFirstDayOfWeek) + (l - l1)) / 0x240c8400L);
        }
    }

    private void goTo(Calendar calendar, boolean flag, boolean flag1, boolean flag2) {
        int i;
        int j;
        int k;
        if(calendar.before(mMinDate) || calendar.after(mMaxDate))
            throw new IllegalArgumentException((new StringBuilder()).append("Time not between ").append(mMinDate.getTime()).append(" and ").append(mMaxDate.getTime()).toString());
        i = mListView.getFirstVisiblePosition();
        View view = mListView.getChildAt(0);
        if(view != null && view.getTop() < 0)
            i++;
        j = -1 + (i + mShownWeekCount);
        if(view != null && view.getTop() > mBottomBuffer)
            j--;
        if(flag1)
            mAdapter.setSelectedDay(calendar);
        k = getWeeksSinceMinDate(calendar);
        if(k >= i && k <= j && !flag2) goto _L2; else goto _L1
_L1:
        mFirstDayOfMonth.setTimeInMillis(calendar.getTimeInMillis());
        mFirstDayOfMonth.set(5, 1);
        setMonthDisplayed(mFirstDayOfMonth);
        int l;
        if(mFirstDayOfMonth.before(mMinDate))
            l = 0;
        else
            l = getWeeksSinceMinDate(mFirstDayOfMonth);
        mPreviousScrollState = 2;
        if(flag) {
            mListView.smoothScrollToPositionFromTop(l, mListScrollTopOffset, 1000);
        } else {
            mListView.setSelectionFromTop(l, mListScrollTopOffset);
            onScrollStateChanged(mListView, 0);
        }
_L4:
        return;
_L2:
        if(flag1)
            setMonthDisplayed(calendar);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void invalidateAllWeekViews() {
        int i = mListView.getChildCount();
        for(int j = 0; j < i; j++)
            mListView.getChildAt(j).invalidate();

    }

    private boolean isSameDate(Calendar calendar, Calendar calendar1) {
        boolean flag = true;
        if(calendar.get(6) != calendar1.get(6) || calendar.get(flag) != calendar1.get(flag))
            flag = false;
        return flag;
    }

    private void onScroll(AbsListView abslistview, int i, int j, int k) {
        WeekView weekview = (WeekView)abslistview.getChildAt(0);
        if(weekview != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        long l;
        l = abslistview.getFirstVisiblePosition() * weekview.getHeight() - weekview.getBottom();
        if(l >= mPreviousScrollPosition)
            continue; /* Loop/switch isn't completed */
        mIsScrollingUp = true;
_L6:
        int i1;
        int j1;
        int k1;
        if(weekview.getBottom() < mWeekMinVisibleHeight)
            i1 = 1;
        else
            i1 = 0;
        if(mIsScrollingUp)
            weekview = (WeekView)abslistview.getChildAt(i1 + 2);
        else
        if(i1 != 0)
            weekview = (WeekView)abslistview.getChildAt(i1);
        if(mIsScrollingUp)
            j1 = weekview.getMonthOfFirstWeekDay();
        else
            j1 = weekview.getMonthOfLastWeekDay();
        if(mCurrentMonthDisplayed == 11 && j1 == 0)
            k1 = 1;
        else
        if(mCurrentMonthDisplayed == 0 && j1 == 11)
            k1 = -1;
        else
            k1 = j1 - mCurrentMonthDisplayed;
        if(!mIsScrollingUp && k1 > 0 || mIsScrollingUp && k1 < 0) {
            Calendar calendar = weekview.getFirstDay();
            if(mIsScrollingUp)
                calendar.add(5, -7);
            else
                calendar.add(5, 7);
            setMonthDisplayed(calendar);
        }
        mPreviousScrollPosition = l;
        mPreviousScrollState = mCurrentScrollState;
        if(true) goto _L1; else goto _L3
_L3:
        if(l <= mPreviousScrollPosition) goto _L5; else goto _L4
_L4:
        break MISSING_BLOCK_LABEL_195;
_L5:
        break; /* Loop/switch isn't completed */
        mIsScrollingUp = false;
          goto _L6
    }

    private void onScrollStateChanged(AbsListView abslistview, int i) {
        mScrollStateChangedRunnable.doScrollStateChange(abslistview, i);
    }

    private boolean parseDate(String s, Calendar calendar) {
        calendar.setTime(mDateFormat.parse(s));
        boolean flag = true;
_L2:
        return flag;
        ParseException parseexception;
        parseexception;
        Log.w(LOG_TAG, (new StringBuilder()).append("Date: ").append(s).append(" not in format: ").append("MM/dd/yyyy").toString());
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void setCurrentLocale(Locale locale) {
        if(!locale.equals(mCurrentLocale)) {
            mCurrentLocale = locale;
            mTempDate = getCalendarForLocale(mTempDate, locale);
            mFirstDayOfMonth = getCalendarForLocale(mFirstDayOfMonth, locale);
            mMinDate = getCalendarForLocale(mMinDate, locale);
            mMaxDate = getCalendarForLocale(mMaxDate, locale);
        }
    }

    private void setMonthDisplayed(Calendar calendar) {
        int i = calendar.get(2);
        if(mCurrentMonthDisplayed != i) {
            mCurrentMonthDisplayed = i;
            mAdapter.setFocusMonth(mCurrentMonthDisplayed);
            long l = calendar.getTimeInMillis();
            String s = DateUtils.formatDateRange(super.mContext, l, l, 52);
            mMonthName.setText(s);
            mMonthName.invalidate();
        }
    }

    private void setUpAdapter() {
        if(mAdapter == null) {
            mAdapter = new WeeksAdapter(getContext());
            mAdapter.registerDataSetObserver(new DataSetObserver() {

                public void onChanged() {
                    if(mOnDateChangeListener != null) {
                        Calendar calendar = mAdapter.getSelectedDay();
                        mOnDateChangeListener.onSelectedDayChange(CalendarView.this, calendar.get(1), calendar.get(2), calendar.get(5));
                    }
                }

                final CalendarView this$0;

             {
                this$0 = CalendarView.this;
                DataSetObserver();
            }
            });
            mListView.setAdapter(mAdapter);
        }
        mAdapter.notifyDataSetChanged();
    }

    private void setUpHeader() {
        mDayLabels = new String[mDaysPerWeek];
        int i = mFirstDayOfWeek;
        int j = mFirstDayOfWeek + mDaysPerWeek;
        while(i < j)  {
            int i1;
            if(i > 7)
                i1 = i - 7;
            else
                i1 = i;
            mDayLabels[i - mFirstDayOfWeek] = DateUtils.getDayOfWeekString(i1, 50);
            i++;
        }
        TextView textview = (TextView)mDayNamesHeader.getChildAt(0);
        int k;
        int l;
        if(mShowWeekNumber)
            textview.setVisibility(0);
        else
            textview.setVisibility(8);
        k = 1;
        l = mDayNamesHeader.getChildCount();
        while(k < l)  {
            TextView textview1 = (TextView)mDayNamesHeader.getChildAt(k);
            if(mWeekDayTextAppearanceResId > -1)
                textview1.setTextAppearance(super.mContext, mWeekDayTextAppearanceResId);
            if(k < 1 + mDaysPerWeek) {
                textview1.setText(mDayLabels[k - 1]);
                textview1.setVisibility(0);
            } else {
                textview1.setVisibility(8);
            }
            k++;
        }
        mDayNamesHeader.invalidate();
    }

    private void setUpListView() {
        mListView.setDivider(null);
        mListView.setItemsCanFocus(true);
        mListView.setVerticalScrollBarEnabled(false);
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {

            public void onScroll(AbsListView abslistview, int i, int j, int k) {
                CalendarView.this.onScroll(abslistview, i, j, k);
            }

            public void onScrollStateChanged(AbsListView abslistview, int i) {
                CalendarView.this.onScrollStateChanged(abslistview, i);
            }

            final CalendarView this$0;

             {
                this$0 = CalendarView.this;
                Object();
            }
        });
        mListView.setFriction(mFriction);
        mListView.setVelocityScale(mVelocityScale);
    }

    private void updateDateTextSize() {
        TypedArray typedarray = getContext().obtainStyledAttributes(mDateTextAppearanceResId, com.android.internal.R.styleable.TextAppearance);
        mDateTextSize = typedarray.getDimensionPixelSize(0, 14);
        typedarray.recycle();
    }

    public long getDate() {
        return WeeksAdapter.access._mth400(mAdapter).getTimeInMillis();
    }

    public int getDateTextAppearance() {
        return mDateTextAppearanceResId;
    }

    public int getFirstDayOfWeek() {
        return mFirstDayOfWeek;
    }

    public int getFocusedMonthDateColor() {
        return mFocusedMonthDateColor;
    }

    public long getMaxDate() {
        return mMaxDate.getTimeInMillis();
    }

    public long getMinDate() {
        return mMinDate.getTimeInMillis();
    }

    public Drawable getSelectedDateVerticalBar() {
        return mSelectedDateVerticalBar;
    }

    public int getSelectedWeekBackgroundColor() {
        return mSelectedWeekBackgroundColor;
    }

    public boolean getShowWeekNumber() {
        return mShowWeekNumber;
    }

    public int getShownWeekCount() {
        return mShownWeekCount;
    }

    public int getUnfocusedMonthDateColor() {
        return mFocusedMonthDateColor;
    }

    public int getWeekDayTextAppearance() {
        return mWeekDayTextAppearanceResId;
    }

    public int getWeekNumberColor() {
        return mWeekNumberColor;
    }

    public int getWeekSeparatorLineColor() {
        return mWeekSeparatorLineColor;
    }

    public boolean isEnabled() {
        return mListView.isEnabled();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/CalendarView.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/CalendarView.getName());
    }

    public void setDate(long l) {
        setDate(l, false, false);
    }

    public void setDate(long l, boolean flag, boolean flag1) {
        mTempDate.setTimeInMillis(l);
        if(!isSameDate(mTempDate, WeeksAdapter.access._mth400(mAdapter)))
            goTo(mTempDate, flag, true, flag1);
    }

    public void setDateTextAppearance(int i) {
        if(mDateTextAppearanceResId != i) {
            mDateTextAppearanceResId = i;
            updateDateTextSize();
            invalidateAllWeekViews();
        }
    }

    public void setEnabled(boolean flag) {
        mListView.setEnabled(flag);
    }

    public void setFirstDayOfWeek(int i) {
        if(mFirstDayOfWeek != i) {
            mFirstDayOfWeek = i;
            WeeksAdapter.access._mth500(mAdapter);
            mAdapter.notifyDataSetChanged();
            setUpHeader();
        }
    }

    public void setFocusedMonthDateColor(int i) {
        if(mFocusedMonthDateColor != i) {
            mFocusedMonthDateColor = i;
            int j = mListView.getChildCount();
            for(int k = 0; k < j; k++) {
                WeekView weekview = (WeekView)mListView.getChildAt(k);
                if(weekview.mHasFocusedDay)
                    weekview.invalidate();
            }

        }
    }

    public void setMaxDate(long l) {
        mTempDate.setTimeInMillis(l);
        if(!isSameDate(mTempDate, mMaxDate)) {
            mMaxDate.setTimeInMillis(l);
            WeeksAdapter.access._mth500(mAdapter);
            Calendar calendar = WeeksAdapter.access._mth400(mAdapter);
            if(calendar.after(mMaxDate))
                setDate(mMaxDate.getTimeInMillis());
            else
                goTo(calendar, false, true, false);
        }
    }

    public void setMinDate(long l) {
        mTempDate.setTimeInMillis(l);
        if(!isSameDate(mTempDate, mMinDate)) {
            mMinDate.setTimeInMillis(l);
            Calendar calendar = WeeksAdapter.access._mth400(mAdapter);
            if(calendar.before(mMinDate))
                mAdapter.setSelectedDay(mMinDate);
            WeeksAdapter.access._mth500(mAdapter);
            if(calendar.before(mMinDate))
                setDate(mTempDate.getTimeInMillis());
            else
                goTo(calendar, false, true, false);
        }
    }

    public void setOnDateChangeListener(OnDateChangeListener ondatechangelistener) {
        mOnDateChangeListener = ondatechangelistener;
    }

    public void setSelectedDateVerticalBar(int i) {
        setSelectedDateVerticalBar(getResources().getDrawable(i));
    }

    public void setSelectedDateVerticalBar(Drawable drawable) {
        if(mSelectedDateVerticalBar != drawable) {
            mSelectedDateVerticalBar = drawable;
            int i = mListView.getChildCount();
            for(int j = 0; j < i; j++) {
                WeekView weekview = (WeekView)mListView.getChildAt(j);
                if(weekview.mHasSelectedDay)
                    weekview.invalidate();
            }

        }
    }

    public void setSelectedWeekBackgroundColor(int i) {
        if(mSelectedWeekBackgroundColor != i) {
            mSelectedWeekBackgroundColor = i;
            int j = mListView.getChildCount();
            for(int k = 0; k < j; k++) {
                WeekView weekview = (WeekView)mListView.getChildAt(k);
                if(weekview.mHasSelectedDay)
                    weekview.invalidate();
            }

        }
    }

    public void setShowWeekNumber(boolean flag) {
        if(mShowWeekNumber != flag) {
            mShowWeekNumber = flag;
            mAdapter.notifyDataSetChanged();
            setUpHeader();
        }
    }

    public void setShownWeekCount(int i) {
        if(mShownWeekCount != i) {
            mShownWeekCount = i;
            invalidate();
        }
    }

    public void setUnfocusedMonthDateColor(int i) {
        if(mUnfocusedMonthDateColor != i) {
            mUnfocusedMonthDateColor = i;
            int j = mListView.getChildCount();
            for(int k = 0; k < j; k++) {
                WeekView weekview = (WeekView)mListView.getChildAt(k);
                if(weekview.mHasUnfocusedDay)
                    weekview.invalidate();
            }

        }
    }

    public void setWeekDayTextAppearance(int i) {
        if(mWeekDayTextAppearanceResId != i) {
            mWeekDayTextAppearanceResId = i;
            setUpHeader();
        }
    }

    public void setWeekNumberColor(int i) {
        if(mWeekNumberColor != i) {
            mWeekNumberColor = i;
            if(mShowWeekNumber)
                invalidateAllWeekViews();
        }
    }

    public void setWeekSeparatorLineColor(int i) {
        if(mWeekSeparatorLineColor != i) {
            mWeekSeparatorLineColor = i;
            invalidateAllWeekViews();
        }
    }

    private static final int ADJUSTMENT_SCROLL_DURATION = 500;
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final int DAYS_PER_WEEK = 7;
    private static final int DEFAULT_DATE_TEXT_SIZE = 14;
    private static final String DEFAULT_MAX_DATE = "01/01/2100";
    private static final String DEFAULT_MIN_DATE = "01/01/1900";
    private static final int DEFAULT_SHOWN_WEEK_COUNT = 6;
    private static final boolean DEFAULT_SHOW_WEEK_NUMBER = true;
    private static final int DEFAULT_WEEK_DAY_TEXT_APPEARANCE_RES_ID = -1;
    private static final int GOTO_SCROLL_DURATION = 1000;
    private static final String LOG_TAG = android/widget/CalendarView.getSimpleName();
    private static final long MILLIS_IN_DAY = 0x5265c00L;
    private static final long MILLIS_IN_WEEK = 0x240c8400L;
    private static final int SCROLL_CHANGE_DELAY = 40;
    private static final int SCROLL_HYST_WEEKS = 2;
    private static final int UNSCALED_BOTTOM_BUFFER = 20;
    private static final int UNSCALED_LIST_SCROLL_TOP_OFFSET = 2;
    private static final int UNSCALED_SELECTED_DATE_VERTICAL_BAR_WIDTH = 6;
    private static final int UNSCALED_WEEK_MIN_VISIBLE_HEIGHT = 12;
    private static final int UNSCALED_WEEK_SEPARATOR_LINE_WIDTH = 1;
    private WeeksAdapter mAdapter;
    private int mBottomBuffer;
    private Locale mCurrentLocale;
    private int mCurrentMonthDisplayed;
    private int mCurrentScrollState;
    private final DateFormat mDateFormat;
    private int mDateTextAppearanceResId;
    private int mDateTextSize;
    private String mDayLabels[];
    private ViewGroup mDayNamesHeader;
    private int mDaysPerWeek;
    private Calendar mFirstDayOfMonth;
    private int mFirstDayOfWeek;
    private int mFocusedMonthDateColor;
    private float mFriction;
    private boolean mIsScrollingUp;
    private int mListScrollTopOffset;
    private ListView mListView;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private TextView mMonthName;
    private OnDateChangeListener mOnDateChangeListener;
    private long mPreviousScrollPosition;
    private int mPreviousScrollState;
    private ScrollStateRunnable mScrollStateChangedRunnable;
    private Drawable mSelectedDateVerticalBar;
    private final int mSelectedDateVerticalBarWidth;
    private int mSelectedWeekBackgroundColor;
    private boolean mShowWeekNumber;
    private int mShownWeekCount;
    private Calendar mTempDate;
    private int mUnfocusedMonthDateColor;
    private float mVelocityScale;
    private int mWeekDayTextAppearanceResId;
    private int mWeekMinVisibleHeight;
    private int mWeekNumberColor;
    private int mWeekSeparatorLineColor;
    private final int mWeekSeperatorLineWidth;



/*
    static int access$1002(CalendarView calendarview, int i) {
        calendarview.mCurrentScrollState = i;
        return i;
    }

*/



/*
    static int access$1102(CalendarView calendarview, int i) {
        calendarview.mPreviousScrollState = i;
        return i;
    }

*/




/*
    static Context access$1402(CalendarView calendarview, Context context) {
        calendarview.mContext = context;
        return context;
    }

*/

























}
