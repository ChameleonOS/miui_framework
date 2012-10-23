// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

// Referenced classes of package android.widget:
//            ListView

public class SortableListView extends ListView {
    public static interface OnOrderChangedListener {

        public abstract void OnOrderChanged(int i, int j);
    }


    public SortableListView(Context context) {
        this(context, null);
    }

    public SortableListView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010074);
    }

    public SortableListView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mDraggingFrom = -1;
        mDraggingTo = -1;
        mItemUpperBound = -1;
        mTmpLocation = new int[2];
        mSnapshotShadow = context.getResources().getDrawable(0x6020108);
        mSnapshotShadow.setAlpha(153);
        Rect rect = new Rect();
        mSnapshotShadow.getPadding(rect);
        mSnapshotShadowPaddingTop = rect.top;
        mSnapshotShadowPaddingBottom = rect.bottom;
    }

    private Animation createAnimation(int i, int j, int k, int l) {
        TranslateAnimation translateanimation = new TranslateAnimation(i, j, k, l);
        translateanimation.setDuration(200L);
        translateanimation.setFillAfter(true);
        return translateanimation;
    }

    private int getHittenItemPosition(MotionEvent motionevent) {
        float f;
        float f1;
        int i;
        int j;
        f = motionevent.getRawX();
        f1 = motionevent.getRawY();
        i = getFirstVisiblePosition();
        j = getLastVisiblePosition();
_L3:
        if(j < i) goto _L2; else goto _L1
_L1:
        View view = getChildAt(j - i);
        if(view == null)
            continue; /* Loop/switch isn't completed */
        view.getLocationOnScreen(mTmpLocation);
        if((float)mTmpLocation[0] > f || (float)(mTmpLocation[0] + view.getWidth()) < f || (float)mTmpLocation[1] > f1 || (float)(mTmpLocation[1] + view.getHeight()) < f1)
            continue; /* Loop/switch isn't completed */
_L4:
        return j;
        j--;
          goto _L3
_L2:
        j = -1;
          goto _L4
    }

    private void setViewAnimation(View view, Animation animation) {
        if(view != null)
            if(animation != null)
                view.startAnimation(animation);
            else
                view.clearAnimation();
    }

    private void setViewAnimationByPisition(int i, Animation animation) {
        setViewAnimation(getChildAt(i - getFirstVisiblePosition()), animation);
    }

    private void updateDraggingToPisition(int i) {
        if(i != mDraggingTo && i >= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Log.d("SortableListView", (new StringBuilder()).append("sort item from ").append(mDraggingFrom).append(" To ").append(i).toString());
        if(mDraggingFrom < Math.max(mDraggingTo, i))
            while(mDraggingTo > i && mDraggingTo > mDraggingFrom)  {
                Log.d("SortableListView", (new StringBuilder()).append("item ").append(mDraggingTo).append(" set move down reverse animation").toString());
                int i1 = mDraggingTo;
                mDraggingTo = i1 - 1;
                setViewAnimationByPisition(i1, createAnimation(0, 0, -mDraggingItemHeight, 0));
            }
        if(mDraggingFrom > Math.min(mDraggingTo, i))
            while(mDraggingTo < i && mDraggingTo < mDraggingFrom)  {
                Log.d("SortableListView", (new StringBuilder()).append("item ").append(mDraggingTo).append(" set move up reverse animation").toString());
                int l = mDraggingTo;
                mDraggingTo = l + 1;
                setViewAnimationByPisition(l, createAnimation(0, 0, mDraggingItemHeight, 0));
            }
        if(mDraggingFrom < Math.max(mDraggingTo, i))
            while(mDraggingTo < i)  {
                int k = 1 + mDraggingTo;
                mDraggingTo = k;
                setViewAnimationByPisition(k, createAnimation(0, 0, 0, -mDraggingItemHeight));
                Log.d("SortableListView", (new StringBuilder()).append("item ").append(mDraggingTo).append(" set move up animation").toString());
            }
        if(mDraggingFrom > Math.min(mDraggingTo, i))
            while(mDraggingTo > i)  {
                int j = -1 + mDraggingTo;
                mDraggingTo = j;
                setViewAnimationByPisition(j, createAnimation(0, 0, 0, mDraggingItemHeight));
                Log.d("SortableListView", (new StringBuilder()).append("item ").append(mDraggingTo).append(" set move down animation").toString());
            }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if(mDraggingFrom >= 0) {
            int i = mDraggingY - mOffsetYInDraggingItem;
            int j = getHeaderViewsCount();
            if(j < getFirstVisiblePosition() || j > getLastVisiblePosition())
                j = getFirstVisiblePosition();
            int k = Math.max(i, getChildAt(j - getFirstVisiblePosition()).getTop());
            int l = (-1 + getCount()) - getFooterViewsCount();
            if(l < getFirstVisiblePosition() || l > getLastVisiblePosition())
                l = getLastVisiblePosition();
            int i1 = Math.min(k, getChildAt(l - getFirstVisiblePosition()).getBottom() - mDraggingItemHeight);
            canvas.translate(0.0F, i1);
            mSnapshotShadow.draw(canvas);
            mSnapshot.draw(canvas);
            if(mSnapshotBackgroundForOverUpperBound != null && mDraggingTo < mItemUpperBound)
                mSnapshotBackgroundForOverUpperBound.draw(canvas);
            canvas.translate(0.0F, -i1);
        }
    }

    public android.view.View.OnTouchListener getListenerForStartingSort() {
        return mOnTouchListener;
    }

    View obtainView(int i, boolean aflag[]) {
        View view;
        Animation animation;
        view = super.obtainView(i, aflag);
        animation = null;
        if(mDraggingFrom != i) goto _L2; else goto _L1
_L1:
        animation = createAnimation(mDraggingItemWidth, mDraggingItemWidth, 0, 0);
        Log.d("SortableListView", (new StringBuilder()).append("item ").append(i).append(" set move out animation").toString());
_L4:
        setViewAnimation(view, animation);
        return view;
_L2:
        if(mDraggingFrom < i && i <= mDraggingTo) {
            animation = createAnimation(0, 0, 0, -mDraggingItemHeight);
            Log.d("SortableListView", (new StringBuilder()).append("item ").append(i).append(" set move up animation").toString());
        } else
        if(mDraggingFrom > i && i >= mDraggingTo) {
            animation = createAnimation(0, 0, 0, mDraggingItemHeight);
            Log.d("SortableListView", (new StringBuilder()).append("item ").append(i).append(" set move down animation").toString());
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent) {
        boolean flag = true;
        if(mInterceptTouchForSorting) {
            requestDisallowInterceptTouchEvent(flag);
            onTouchEvent(motionevent);
        } else {
            flag = super.onInterceptTouchEvent(motionevent);
        }
        return flag;
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        super.onSizeChanged(i, j, k, l);
        mScrollBound = Math.max(1, (int)(0.25F * (float)j));
        mScrollUpperBound = mScrollBound;
        mScrollLowerBound = j - mScrollBound;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        if(mInterceptTouchForSorting) goto _L2; else goto _L1
_L1:
        boolean flag = super.onTouchEvent(motionevent);
_L4:
        return flag;
_L2:
        switch(0xff & motionevent.getAction()) {
        case 4: // '\004'
        default:
            break;

        case 2: // '\002'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
        case 3: // '\003'
        case 5: // '\005'
            break;
        }
        break MISSING_BLOCK_LABEL_227;
_L5:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
        int i = (int)motionevent.getY();
        if(mInterceptTouchForSorting || i != mDraggingY) {
            int j = getHittenItemPosition(motionevent);
            if(j < getHeaderViewsCount() || j > getCount() - getFooterViewsCount())
                j = mDraggingTo;
            updateDraggingToPisition(j);
            mDraggingY = i;
            invalidate();
            int k = 0;
            if(i > mScrollLowerBound)
                k = (16 * (mScrollLowerBound - i)) / mScrollBound;
            else
            if(i < mScrollUpperBound)
                k = (16 * (mScrollUpperBound - i)) / mScrollBound;
            if(k != 0) {
                View view = getChildAt(j - getFirstVisiblePosition());
                if(view != null)
                    setSelectionFromTop(j, k + view.getTop());
            }
        }
          goto _L5
        if(mDraggingFrom >= 0)
            if(mOnOrderChangedListener != null && mDraggingFrom != mDraggingTo && mDraggingTo >= 0)
                mOnOrderChangedListener.OnOrderChanged(mDraggingFrom - getHeaderViewsCount(), mDraggingTo - getHeaderViewsCount());
            else
                setViewAnimationByPisition(mDraggingFrom, null);
        mInterceptTouchForSorting = false;
        mDraggingFrom = -1;
        mDraggingTo = -1;
        invalidate();
          goto _L5
    }

    public void setItemUpperBound(int i, Drawable drawable) {
        mItemUpperBound = i;
        mSnapshotBackgroundForOverUpperBound = drawable;
    }

    public void setOnOrderChangedListener(OnOrderChangedListener onorderchangedlistener) {
        mOnOrderChangedListener = onorderchangedlistener;
    }

    private static final int ANIMATION_DURATION = 200;
    private static final float SCROLL_BOUND = 0.25F;
    private static final int SCROLL_SPEED_MAX = 16;
    private static final int SNAPSHOT_ALPHA = 153;
    private static final String TAG = "SortableListView";
    private int mDraggingFrom;
    private int mDraggingItemHeight;
    private int mDraggingItemWidth;
    private int mDraggingTo;
    private int mDraggingY;
    private boolean mInterceptTouchForSorting;
    private int mItemUpperBound;
    private int mOffsetYInDraggingItem;
    private OnOrderChangedListener mOnOrderChangedListener;
    private android.view.View.OnTouchListener mOnTouchListener = new android.view.View.OnTouchListener() {

        public boolean onTouch(View view, MotionEvent motionevent) {
            if(mOnOrderChangedListener != null && (0xff & motionevent.getAction()) == 0) {
                int j = getHittenItemPosition(motionevent);
                if(j >= 0) {
                    mDraggingFrom = j;
                    mDraggingTo = j;
                    mInterceptTouchForSorting = true;
                    View view1 = getChildAt(j - getFirstVisiblePosition());
                    mDraggingItemWidth = view1.getWidth();
                    mDraggingItemHeight = view1.getHeight();
                    getLocationOnScreen(mTmpLocation);
                    mDraggingY = (int)motionevent.getRawY() - mTmpLocation[1];
                    mOffsetYInDraggingItem = mDraggingY - view1.getTop();
                    Bitmap bitmap = Bitmap.createBitmap(mDraggingItemWidth, mDraggingItemHeight, android.graphics.Bitmap.Config.ARGB_8888);
                    view1.draw(new Canvas(bitmap));
                    mSnapshot = new BitmapDrawable(getResources(), bitmap);
                    mSnapshot.setAlpha(153);
                    mSnapshot.setBounds(view1.getLeft(), 0, view1.getRight(), mDraggingItemHeight);
                    if(mSnapshotBackgroundForOverUpperBound != null) {
                        mSnapshotBackgroundForOverUpperBound.setAlpha(153);
                        mSnapshotBackgroundForOverUpperBound.setBounds(view1.getLeft(), 0, view1.getRight(), mDraggingItemHeight);
                    }
                    mSnapshotShadow.setBounds(view1.getLeft(), -mSnapshotShadowPaddingTop, view1.getRight(), mDraggingItemHeight + mSnapshotShadowPaddingBottom);
                    view1.startAnimation(createAnimation(mDraggingItemWidth, mDraggingItemWidth, 0, 0));
                }
            }
            return mInterceptTouchForSorting;
        }

        final SortableListView this$0;

             {
                this$0 = SortableListView.this;
                super();
            }
    };
    private int mScrollBound;
    private int mScrollLowerBound;
    private int mScrollUpperBound;
    private BitmapDrawable mSnapshot;
    private Drawable mSnapshotBackgroundForOverUpperBound;
    private Drawable mSnapshotShadow;
    private int mSnapshotShadowPaddingBottom;
    private int mSnapshotShadowPaddingTop;
    private int mTmpLocation[];





/*
    static BitmapDrawable access$1002(SortableListView sortablelistview, BitmapDrawable bitmapdrawable) {
        sortablelistview.mSnapshot = bitmapdrawable;
        return bitmapdrawable;
    }

*/







/*
    static int access$202(SortableListView sortablelistview, int i) {
        sortablelistview.mDraggingFrom = i;
        return i;
    }

*/


/*
    static int access$302(SortableListView sortablelistview, int i) {
        sortablelistview.mDraggingTo = i;
        return i;
    }

*/



/*
    static boolean access$402(SortableListView sortablelistview, boolean flag) {
        sortablelistview.mInterceptTouchForSorting = flag;
        return flag;
    }

*/



/*
    static int access$502(SortableListView sortablelistview, int i) {
        sortablelistview.mDraggingItemWidth = i;
        return i;
    }

*/



/*
    static int access$602(SortableListView sortablelistview, int i) {
        sortablelistview.mDraggingItemHeight = i;
        return i;
    }

*/




/*
    static int access$802(SortableListView sortablelistview, int i) {
        sortablelistview.mDraggingY = i;
        return i;
    }

*/


/*
    static int access$902(SortableListView sortablelistview, int i) {
        sortablelistview.mOffsetYInDraggingItem = i;
        return i;
    }

*/
}
