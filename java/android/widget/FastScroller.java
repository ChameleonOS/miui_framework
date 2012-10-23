// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.view.*;

// Referenced classes of package android.widget:
//            AbsListView, SectionIndexer, HeaderViewListAdapter, ExpandableListConnector, 
//            BaseAdapter, ExpandableListView, ListView

class FastScroller {
    public class ScrollFade
        implements Runnable {

        int getAlpha() {
            int i;
            if(getState() != 4) {
                i = 208;
            } else {
                long l = SystemClock.uptimeMillis();
                if(l > mStartTime + mFadeDuration)
                    i = 0;
                else
                    i = (int)(208L - (208L * (l - mStartTime)) / mFadeDuration);
            }
            return i;
        }

        public void run() {
            if(getState() != 4)
                startFade();
            else
            if(getAlpha() > 0)
                mList.invalidate();
            else
                setState(0);
        }

        void startFade() {
            mFadeDuration = 200L;
            mStartTime = SystemClock.uptimeMillis();
            setState(4);
        }

        static final int ALPHA_MAX = 208;
        static final long FADE_DURATION = 200L;
        long mFadeDuration;
        long mStartTime;
        final FastScroller this$0;

        public ScrollFade() {
            this$0 = FastScroller.this;
            super();
        }
    }


    public FastScroller(Context context, AbsListView abslistview) {
        mItemCount = -1;
        mHandler = new Handler();
        mList = abslistview;
        init(context);
    }

    private void cancelFling() {
        MotionEvent motionevent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0);
        mList.onTouchEvent(motionevent);
        motionevent.recycle();
    }

    private int getThumbPositionForListPosition(int i, int j, int k) {
        if(mSectionIndexer == null || mListAdapter == null)
            getSectionsFromIndexer();
        if(mSectionIndexer != null && mMatchDragPosition) goto _L2; else goto _L1
_L1:
        int l = (i * (mList.getHeight() - mThumbH)) / (k - j);
_L4:
        return l;
_L2:
        int i1 = i - mListOffset;
        if(i1 < 0) {
            l = 0;
        } else {
            int j1 = k - mListOffset;
            int k1 = mList.getHeight() - mThumbH;
            int l1 = mSectionIndexer.getSectionForPosition(i1);
            int i2 = mSectionIndexer.getPositionForSection(l1);
            int j2 = mSectionIndexer.getPositionForSection(l1 + 1);
            int k2 = mSections.length;
            int l2 = j2 - i2;
            View view = mList.getChildAt(0);
            float f;
            if(view == null)
                f = 0.0F;
            else
                f = (float)i1 + (float)(mList.getPaddingTop() - view.getTop()) / (float)view.getHeight();
            l = (int)((((f - (float)i2) / (float)l2 + (float)l1) / (float)k2) * (float)k1);
            if(i1 > 0 && i1 + j == j1) {
                View view1 = mList.getChildAt(j - 1);
                float f1 = (float)(mList.getHeight() - mList.getPaddingBottom() - view1.getTop()) / (float)view1.getHeight();
                l = (int)((float)l + f1 * (float)(k1 - l));
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void init(Context context) {
        boolean flag = true;
        TypedArray typedarray = context.getTheme().obtainStyledAttributes(ATTRS);
        useThumbDrawable(context, typedarray.getDrawable(flag));
        mTrackDrawable = typedarray.getDrawable(2);
        mOverlayDrawableLeft = typedarray.getDrawable(3);
        mOverlayDrawableRight = typedarray.getDrawable(4);
        mOverlayPosition = typedarray.getInt(5, 0);
        mScrollCompleted = flag;
        getSectionsFromIndexer();
        mOverlaySize = context.getResources().getDimensionPixelSize(0x1050013);
        mOverlayPos = new RectF();
        mScrollFade = new ScrollFade();
        mPaint = new Paint();
        mPaint.setAntiAlias(flag);
        mPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
        mPaint.setTextSize(mOverlaySize / 2);
        int i = typedarray.getColorStateList(0).getDefaultColor();
        mPaint.setColor(i);
        mPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        if(mList.getWidth() > 0 && mList.getHeight() > 0)
            onSizeChanged(mList.getWidth(), mList.getHeight(), 0, 0);
        mState = 0;
        refreshDrawableState();
        typedarray.recycle();
        mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        if(context.getApplicationInfo().targetSdkVersion < 11)
            flag = false;
        mMatchDragPosition = flag;
        setScrollbarPosition(mList.getVerticalScrollbarPosition());
    }

    private void refreshDrawableState() {
        int ai[];
        if(mState == 3)
            ai = PRESSED_STATES;
        else
            ai = DEFAULT_STATES;
        if(mThumbDrawable != null && mThumbDrawable.isStateful())
            mThumbDrawable.setState(ai);
        if(mTrackDrawable != null && mTrackDrawable.isStateful())
            mTrackDrawable.setState(ai);
    }

    private void resetThumbPos() {
        int i = mList.getWidth();
        mPosition;
        JVM INSTR tableswitch 0 2: default 40
    //                   0 51
    //                   1 73
    //                   2 51;
           goto _L1 _L2 _L3 _L2
_L1:
        mThumbDrawable.setAlpha(208);
        return;
_L2:
        mThumbDrawable.setBounds(i - mThumbW, 0, i, mThumbH);
        continue; /* Loop/switch isn't completed */
_L3:
        mThumbDrawable.setBounds(0, 0, mThumbW, mThumbH);
        if(true) goto _L1; else goto _L4
_L4:
    }

    private void useThumbDrawable(Context context, Drawable drawable) {
        mThumbDrawable = drawable;
        if(drawable instanceof NinePatchDrawable) {
            mThumbW = context.getResources().getDimensionPixelSize(0x1050014);
            mThumbH = context.getResources().getDimensionPixelSize(0x1050015);
        } else {
            mThumbW = drawable.getIntrinsicWidth();
            mThumbH = drawable.getIntrinsicHeight();
        }
        mChangedBounds = true;
    }

    void beginDrag() {
        setState(3);
        if(mListAdapter == null && mList != null)
            getSectionsFromIndexer();
        if(mList != null) {
            mList.requestDisallowInterceptTouchEvent(true);
            mList.reportScrollStateChange(1);
        }
        cancelFling();
    }

    void cancelPendingDrag() {
        mList.removeCallbacks(mDeferStartDrag);
        mPendingDrag = false;
    }

    public void draw(Canvas canvas) {
        if(mState != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int j;
        ScrollFade scrollfade;
        int k;
        i = mThumbY;
        j = mList.getWidth();
        scrollfade = mScrollFade;
        k = -1;
        if(mState != 4) goto _L4; else goto _L3
_L3:
        int l2;
        k = scrollfade.getAlpha();
        if(k < 104)
            mThumbDrawable.setAlpha(k * 2);
        l2 = 0;
        mPosition;
        JVM INSTR tableswitch 0 2: default 96
    //                   0 573
    //                   1 591
    //                   2 573;
           goto _L5 _L6 _L7 _L6
_L5:
        mThumbDrawable.setBounds(l2, 0, l2 + mThumbW, mThumbH);
        mChangedBounds = true;
_L4:
        if(mTrackDrawable != null) {
            Rect rect1 = mThumbDrawable.getBounds();
            int l1 = rect1.left;
            int i2 = (rect1.bottom - rect1.top) / 2;
            int j2 = mTrackDrawable.getIntrinsicWidth();
            int k2 = (l1 + mThumbW / 2) - j2 / 2;
            mTrackDrawable.setBounds(k2, i2, k2 + j2, mList.getHeight() - i2);
            mTrackDrawable.draw(canvas);
        }
        canvas.translate(0.0F, i);
        mThumbDrawable.draw(canvas);
        canvas.translate(0.0F, -i);
        if(mState != 3 || !mDrawOverlay)
            break MISSING_BLOCK_LABEL_648;
        if(mOverlayPosition != 1) goto _L9; else goto _L8
_L8:
        int j1;
        switch(mPosition) {
        default:
            j1 = Math.max(0, mThumbDrawable.getBounds().left - mThumbW - mOverlaySize);
            break;

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_613;
        }
_L10:
        int k1 = Math.max(0, Math.min(i + (mThumbH - mOverlaySize) / 2, mList.getHeight() - mOverlaySize));
        RectF rectf1 = mOverlayPos;
        rectf1.left = j1;
        rectf1.right = rectf1.left + (float)mOverlaySize;
        rectf1.top = k1;
        rectf1.bottom = rectf1.top + (float)mOverlaySize;
        if(mOverlayDrawable != null)
            mOverlayDrawable.setBounds((int)rectf1.left, (int)rectf1.top, (int)rectf1.right, (int)rectf1.bottom);
_L9:
        mOverlayDrawable.draw(canvas);
        Paint paint = mPaint;
        float f = paint.descent();
        RectF rectf = mOverlayPos;
        Rect rect = mTmpRect;
        mOverlayDrawable.getPadding(rect);
        int l = (rect.right - rect.left) / 2;
        int i1 = (rect.bottom - rect.top) / 2;
        canvas.drawText(mSectionText, (int)(rectf.left + rectf.right) / 2 - l, (float)((int)(rectf.bottom + rectf.top) / 2 + mOverlaySize / 4) - f - (float)i1, paint);
        continue; /* Loop/switch isn't completed */
_L6:
        l2 = j - (k * mThumbW) / 208;
          goto _L5
_L7:
        l2 = -mThumbW + (k * mThumbW) / 208;
          goto _L5
        j1 = Math.min(mThumbDrawable.getBounds().right + mThumbW, mList.getWidth() - mOverlaySize);
          goto _L10
        if(mState == 4)
            if(k == 0)
                setState(0);
            else
            if(mTrackDrawable != null)
                mList.invalidate(j - mThumbW, 0, j, mList.getHeight());
            else
                mList.invalidate(j - mThumbW, i, j, i + mThumbH);
        if(true) goto _L1; else goto _L11
_L11:
    }

    SectionIndexer getSectionIndexer() {
        return mSectionIndexer;
    }

    Object[] getSections() {
        if(mListAdapter == null && mList != null)
            getSectionsFromIndexer();
        return mSections;
    }

    void getSectionsFromIndexer() {
        Object obj;
        obj = mList.getAdapter();
        mSectionIndexer = null;
        if(obj instanceof HeaderViewListAdapter) {
            mListOffset = ((HeaderViewListAdapter)obj).getHeadersCount();
            obj = ((HeaderViewListAdapter)obj).getWrappedAdapter();
        }
        if(!(obj instanceof ExpandableListConnector)) goto _L2; else goto _L1
_L1:
        ExpandableListAdapter expandablelistadapter = ((ExpandableListConnector)obj).getAdapter();
        if(expandablelistadapter instanceof SectionIndexer) {
            mSectionIndexer = (SectionIndexer)expandablelistadapter;
            mListAdapter = (BaseAdapter)obj;
            mSections = mSectionIndexer.getSections();
        }
_L4:
        return;
_L2:
        if(obj instanceof SectionIndexer) {
            mListAdapter = (BaseAdapter)obj;
            mSectionIndexer = (SectionIndexer)obj;
            mSections = mSectionIndexer.getSections();
            if(mSections == null) {
                String as1[] = new String[1];
                as1[0] = " ";
                mSections = as1;
            }
        } else {
            mListAdapter = (BaseAdapter)obj;
            String as[] = new String[1];
            as[0] = " ";
            mSections = as;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getState() {
        return mState;
    }

    public int getWidth() {
        return mThumbW;
    }

    public boolean isAlwaysShowEnabled() {
        return mAlwaysShow;
    }

    boolean isPointInside(float f, float f1) {
        boolean flag;
        boolean flag1;
        flag = true;
        switch(mPosition) {
        default:
            if(f > (float)(mList.getWidth() - mThumbW))
                flag1 = flag;
            else
                flag1 = false;
            break;

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_90;
        }
_L1:
        if(!flag1 || mTrackDrawable == null && (f1 < (float)mThumbY || f1 > (float)(mThumbY + mThumbH)))
            flag = false;
        return flag;
        if(f < (float)mThumbW)
            flag1 = flag;
        else
            flag1 = false;
          goto _L1
    }

    boolean isVisible() {
        boolean flag;
        if(mState != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean onInterceptTouchEvent(MotionEvent motionevent) {
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 3: default 36
    //                   0 40
    //                   1 96
    //                   2 36
    //                   3 96;
           goto _L1 _L2 _L3 _L1 _L3
_L1:
        boolean flag = false;
_L5:
        return flag;
_L2:
        if(mState <= 0 || !isPointInside(motionevent.getX(), motionevent.getY()))
            continue; /* Loop/switch isn't completed */
        if(mList.isInScrollingContainer())
            break; /* Loop/switch isn't completed */
        beginDrag();
        flag = true;
        if(true) goto _L5; else goto _L4
_L4:
        mInitialTouchY = motionevent.getY();
        startPendingDrag();
        continue; /* Loop/switch isn't completed */
_L3:
        cancelPendingDrag();
        if(true) goto _L1; else goto _L6
_L6:
    }

    void onItemCountChanged(int i, int j) {
        if(mAlwaysShow)
            mLongList = true;
    }

    void onScroll(AbsListView abslistview, int i, int j, int k) {
        if(mItemCount != k && j > 0) {
            mItemCount = k;
            boolean flag;
            if(mItemCount / j >= MIN_PAGES)
                flag = true;
            else
                flag = false;
            mLongList = flag;
        }
        if(mAlwaysShow)
            mLongList = true;
        if(mLongList) goto _L2; else goto _L1
_L1:
        if(mState != 0)
            setState(0);
_L4:
        return;
_L2:
        if(k - j > 0 && mState != 3) {
            mThumbY = getThumbPositionForListPosition(i, j, k);
            if(mChangedBounds) {
                resetThumbPos();
                mChangedBounds = false;
            }
        }
        mScrollCompleted = true;
        if(i != mVisibleItem) {
            mVisibleItem = i;
            if(mState != 3) {
                setState(2);
                if(!mAlwaysShow)
                    mHandler.postDelayed(mScrollFade, 1500L);
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onSectionsChanged() {
        mListAdapter = null;
    }

    void onSizeChanged(int i, int j, int k, int l) {
        if(mThumbDrawable == null) goto _L2; else goto _L1
_L1:
        mPosition;
        JVM INSTR tableswitch 1 1: default 28
    //                   1 155;
           goto _L3 _L4
_L3:
        mThumbDrawable.setBounds(i - mThumbW, 0, i, mThumbH);
_L2:
        if(mOverlayPosition == 0) {
            RectF rectf = mOverlayPos;
            rectf.left = (i - mOverlaySize) / 2;
            rectf.right = rectf.left + (float)mOverlaySize;
            rectf.top = j / 10;
            rectf.bottom = rectf.top + (float)mOverlaySize;
            if(mOverlayDrawable != null)
                mOverlayDrawable.setBounds((int)rectf.left, (int)rectf.top, (int)rectf.right, (int)rectf.bottom);
        }
        return;
_L4:
        mThumbDrawable.setBounds(0, 0, mThumbW, mThumbH);
        if(true) goto _L2; else goto _L5
_L5:
    }

    boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag = false;
        if(mState != 0) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i;
        i = motionevent.getAction();
        if(i == 0) {
            if(isPointInside(motionevent.getX(), motionevent.getY()))
                if(!mList.isInScrollingContainer()) {
                    beginDrag();
                    flag = true;
                } else {
                    mInitialTouchY = motionevent.getY();
                    startPendingDrag();
                }
            continue; /* Loop/switch isn't completed */
        }
        if(i != 1) goto _L4; else goto _L3
_L3:
        if(!mPendingDrag) goto _L6; else goto _L5
_L5:
        int l;
        int i1;
        beginDrag();
        l = mList.getHeight();
        i1 = 10 + ((int)motionevent.getY() - mThumbH);
        if(i1 >= 0) goto _L8; else goto _L7
_L7:
        i1 = 0;
_L9:
        mThumbY = i1;
        scrollTo((float)mThumbY / (float)(l - mThumbH));
        cancelPendingDrag();
_L6:
        if(mState == 3) {
            if(mList != null) {
                mList.requestDisallowInterceptTouchEvent(false);
                mList.reportScrollStateChange(0);
            }
            setState(2);
            Handler handler = mHandler;
            handler.removeCallbacks(mScrollFade);
            if(!mAlwaysShow)
                handler.postDelayed(mScrollFade, 1000L);
            mList.invalidate();
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if(i1 + mThumbH > l)
            i1 = l - mThumbH;
        if(true) goto _L9; else goto _L4
_L4:
        if(i == 2) {
            if(mPendingDrag && Math.abs(motionevent.getY() - mInitialTouchY) > (float)mScaledTouchSlop) {
                setState(3);
                if(mListAdapter == null && mList != null)
                    getSectionsFromIndexer();
                if(mList != null) {
                    mList.requestDisallowInterceptTouchEvent(true);
                    mList.reportScrollStateChange(1);
                }
                cancelFling();
                cancelPendingDrag();
            }
            if(mState != 3)
                continue; /* Loop/switch isn't completed */
            int j = mList.getHeight();
            int k = 10 + ((int)motionevent.getY() - mThumbH);
            if(k < 0)
                k = 0;
            else
            if(k + mThumbH > j)
                k = j - mThumbH;
            if(Math.abs(mThumbY - k) < 2) {
                flag = true;
            } else {
                mThumbY = k;
                if(mScrollCompleted)
                    scrollTo((float)mThumbY / (float)(j - mThumbH));
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
        }
        if(i == 3)
            cancelPendingDrag();
        if(true) goto _L1; else goto _L10
_L10:
    }

    void scrollTo(float f) {
        int i;
        float f1;
        Object aobj[];
        i = mList.getCount();
        mScrollCompleted = false;
        f1 = 1.0F / (float)i / 8F;
        aobj = mSections;
        if(aobj == null || aobj.length <= 1) goto _L2; else goto _L1
_L1:
        int k;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        i1 = aobj.length;
        j1 = (int)(f * (float)i1);
        if(j1 >= i1)
            j1 = i1 - 1;
        k1 = j1;
        k = j1;
        l1 = mSectionIndexer.getPositionForSection(j1);
        i2 = i;
        j2 = l1;
        k2 = j1;
        l2 = j1 + 1;
        if(j1 < i1 - 1)
            i2 = mSectionIndexer.getPositionForSection(j1 + 1);
        if(i2 != l1) goto _L4; else goto _L3
_L3:
        if(j1 > 0) {
            j1--;
            j2 = mSectionIndexer.getPositionForSection(j1);
            int i3;
            if(j2 != l1) {
                k2 = j1;
                k = j1;
            } else {
                if(j1 != 0)
                    continue; /* Loop/switch isn't completed */
                k = 0;
            }
        }
_L4:
        for(i3 = l2 + 1; i3 < i1 && mSectionIndexer.getPositionForSection(i3) == i2;) {
            i3++;
            l2++;
        }

        break; /* Loop/switch isn't completed */
        if(true) goto _L3; else goto _L5
_L5:
        boolean flag;
        float f2 = (float)k2 / (float)i1;
        float f3 = (float)l2 / (float)i1;
        String s;
        int l;
        int j3;
        if(k2 == k1 && f - f2 < f1)
            j3 = j2;
        else
            j3 = j2 + (int)(((float)(i2 - j2) * (f - f2)) / (f3 - f2));
        if(j3 > i - 1)
            j3 = i - 1;
        if(mList instanceof ExpandableListView) {
            ExpandableListView expandablelistview1 = (ExpandableListView)mList;
            expandablelistview1.setSelectionFromTop(expandablelistview1.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(j3 + mListOffset)), 0);
        } else
        if(mList instanceof ListView)
            ((ListView)mList).setSelectionFromTop(j3 + mListOffset, 0);
        else
            mList.setSelection(j3 + mListOffset);
_L9:
        if(k < 0)
            break MISSING_BLOCK_LABEL_569;
        s = aobj[k].toString();
        mSectionText = s;
        if(s.length() == 1 && s.charAt(0) == ' ') goto _L7; else goto _L6
_L6:
        l = aobj.length;
        if(k >= l) goto _L7; else goto _L8
_L8:
        flag = true;
_L10:
        mDrawOverlay = flag;
_L11:
        return;
_L2:
        int j = (int)(f * (float)i);
        if(j > i - 1)
            j = i - 1;
        if(mList instanceof ExpandableListView) {
            ExpandableListView expandablelistview = (ExpandableListView)mList;
            expandablelistview.setSelectionFromTop(expandablelistview.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(j + mListOffset)), 0);
        } else
        if(mList instanceof ListView)
            ((ListView)mList).setSelectionFromTop(j + mListOffset, 0);
        else
            mList.setSelection(j + mListOffset);
        k = -1;
          goto _L9
_L7:
        flag = false;
          goto _L10
        mDrawOverlay = false;
          goto _L11
    }

    public void setAlwaysShow(boolean flag) {
        mAlwaysShow = flag;
        if(!flag) goto _L2; else goto _L1
_L1:
        mHandler.removeCallbacks(mScrollFade);
        setState(2);
_L4:
        return;
_L2:
        if(mState == 2)
            mHandler.postDelayed(mScrollFade, 1500L);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setScrollbarPosition(int i) {
        mPosition = i;
        i;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 33;
           goto _L1 _L2
_L1:
        mOverlayDrawable = mOverlayDrawableRight;
_L4:
        return;
_L2:
        mOverlayDrawable = mOverlayDrawableLeft;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setState(int i) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 46
    //                   1 36
    //                   2 67
    //                   3 79
    //                   4 93;
           goto _L1 _L2 _L1 _L3 _L4 _L5
_L1:
        mState = i;
        refreshDrawableState();
        return;
_L2:
        mHandler.removeCallbacks(mScrollFade);
        mList.invalidate();
        continue; /* Loop/switch isn't completed */
_L3:
        if(mState != 2)
            resetThumbPos();
_L4:
        mHandler.removeCallbacks(mScrollFade);
        continue; /* Loop/switch isn't completed */
_L5:
        int j = mList.getWidth();
        mList.invalidate(j - mThumbW, mThumbY, j, mThumbY + mThumbH);
        if(true) goto _L1; else goto _L6
_L6:
    }

    void startPendingDrag() {
        mPendingDrag = true;
        mList.postDelayed(mDeferStartDrag, 180L);
    }

    void stop() {
        setState(0);
    }

    private static final int ATTRS[];
    private static final int DEFAULT_STATES[] = new int[0];
    private static final int FADE_TIMEOUT = 1500;
    private static int MIN_PAGES = 0;
    private static final int OVERLAY_AT_THUMB = 1;
    private static final int OVERLAY_FLOATING = 0;
    private static final int OVERLAY_POSITION = 5;
    private static final int PENDING_DRAG_DELAY = 180;
    private static final int PRESSED_STATES[];
    private static final int PREVIEW_BACKGROUND_LEFT = 3;
    private static final int PREVIEW_BACKGROUND_RIGHT = 4;
    private static final int STATE_DRAGGING = 3;
    private static final int STATE_ENTER = 1;
    private static final int STATE_EXIT = 4;
    private static final int STATE_NONE = 0;
    private static final int STATE_VISIBLE = 2;
    private static final String TAG = "FastScroller";
    private static final int TEXT_COLOR = 0;
    private static final int THUMB_DRAWABLE = 1;
    private static final int TRACK_DRAWABLE = 2;
    private boolean mAlwaysShow;
    private boolean mChangedBounds;
    private final Runnable mDeferStartDrag = new Runnable() {

        public void run() {
            if(!mList.mIsAttached) goto _L2; else goto _L1
_L1:
            int i;
            int j;
            beginDrag();
            i = mList.getHeight();
            j = 10 + ((int)mInitialTouchY - mThumbH);
            if(j >= 0) goto _L4; else goto _L3
_L3:
            j = 0;
_L6:
            mThumbY = j;
            scrollTo((float)mThumbY / (float)(i - mThumbH));
_L2:
            mPendingDrag = false;
            return;
_L4:
            if(j + mThumbH > i)
                j = i - mThumbH;
            if(true) goto _L6; else goto _L5
_L5:
        }

        final FastScroller this$0;

             {
                this$0 = FastScroller.this;
                super();
            }
    };
    private boolean mDrawOverlay;
    private Handler mHandler;
    float mInitialTouchY;
    private int mItemCount;
    AbsListView mList;
    BaseAdapter mListAdapter;
    private int mListOffset;
    private boolean mLongList;
    private boolean mMatchDragPosition;
    private Drawable mOverlayDrawable;
    private Drawable mOverlayDrawableLeft;
    private Drawable mOverlayDrawableRight;
    private RectF mOverlayPos;
    private int mOverlayPosition;
    private int mOverlaySize;
    private Paint mPaint;
    boolean mPendingDrag;
    private int mPosition;
    private int mScaledTouchSlop;
    boolean mScrollCompleted;
    private ScrollFade mScrollFade;
    private SectionIndexer mSectionIndexer;
    private String mSectionText;
    private Object mSections[];
    private int mState;
    private Drawable mThumbDrawable;
    int mThumbH;
    int mThumbW;
    int mThumbY;
    private final Rect mTmpRect = new Rect();
    private Drawable mTrackDrawable;
    private int mVisibleItem;

    static  {
        MIN_PAGES = 4;
        int ai[] = new int[1];
        ai[0] = 0x10100a7;
        PRESSED_STATES = ai;
        int ai1[] = new int[6];
        ai1[0] = 0x1010359;
        ai1[1] = 0x1010336;
        ai1[2] = 0x1010339;
        ai1[3] = 0x1010337;
        ai1[4] = 0x1010338;
        ai1[5] = 0x101033a;
        ATTRS = ai1;
    }
}
