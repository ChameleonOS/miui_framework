// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.*;
import android.util.AttributeSet;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.*;

// Referenced classes of package android.widget:
//            AdapterView, Advanceable, FrameLayout, RemoteViewsAdapter, 
//            Adapter

public abstract class AdapterViewAnimator extends AdapterView
    implements RemoteViewsAdapter.RemoteAdapterConnectionCallback, Advanceable {
    static class SavedState extends android.view.View.BaseSavedState {

        public String toString() {
            return (new StringBuilder()).append("AdapterViewAnimator.SavedState{ whichChild = ").append(whichChild).append(" }").toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(whichChild);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        int whichChild;


        private SavedState(Parcel parcel) {
            super(parcel);
            whichChild = parcel.readInt();
        }


        SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            whichChild = i;
        }
    }

    final class CheckForTap
        implements Runnable {

        public void run() {
            if(mTouchMode == 1) {
                View view = getCurrentView();
                showTapFeedback(view);
            }
        }

        final AdapterViewAnimator this$0;

        CheckForTap() {
            this$0 = AdapterViewAnimator.this;
            super();
        }
    }

    class ViewAndMetaData {

        int adapterPosition;
        long itemId;
        int relativeIndex;
        final AdapterViewAnimator this$0;
        View view;

        ViewAndMetaData(View view1, int i, int j, long l) {
            this$0 = AdapterViewAnimator.this;
            super();
            view = view1;
            relativeIndex = i;
            adapterPosition = j;
            itemId = l;
        }
    }


    public AdapterViewAnimator(Context context) {
        this(context, null);
    }

    public AdapterViewAnimator(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public AdapterViewAnimator(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mWhichChild = 0;
        mRestoreWhichChild = -1;
        mAnimateFirstTime = true;
        mActiveOffset = 0;
        mMaxNumActiveViews = 1;
        mViewsMap = new HashMap();
        mCurrentWindowStart = 0;
        mCurrentWindowEnd = -1;
        mCurrentWindowStartUnbounded = 0;
        mDeferNotifyDataSetChanged = false;
        mFirstTime = true;
        mLoopViews = true;
        mReferenceChildWidth = -1;
        mReferenceChildHeight = -1;
        mTouchMode = 0;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.AdapterViewAnimator, i, 0);
        int j = typedarray.getResourceId(0, 0);
        int k;
        if(j > 0)
            setInAnimation(context, j);
        else
            setInAnimation(getDefaultInAnimation());
        k = typedarray.getResourceId(1, 0);
        if(k > 0)
            setOutAnimation(context, k);
        else
            setOutAnimation(getDefaultOutAnimation());
        setAnimateFirstView(typedarray.getBoolean(2, true));
        mLoopViews = typedarray.getBoolean(3, false);
        typedarray.recycle();
        initViewAnimator();
    }

    private void addChild(View view) {
        addViewInLayout(view, -1, createOrReuseLayoutParams(view));
        if(mReferenceChildWidth == -1 || mReferenceChildHeight == -1) {
            int i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            view.measure(i, i);
            mReferenceChildWidth = view.getMeasuredWidth();
            mReferenceChildHeight = view.getMeasuredHeight();
        }
    }

    private ViewAndMetaData getMetaDataForChild(View view) {
        Iterator iterator = mViewsMap.values().iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ViewAndMetaData viewandmetadata = (ViewAndMetaData)iterator.next();
        if(viewandmetadata.view != view) goto _L4; else goto _L3
_L3:
        return viewandmetadata;
_L2:
        viewandmetadata = null;
        if(true) goto _L3; else goto _L5
_L5:
    }

    private void initViewAnimator() {
        mPreviousViews = new ArrayList();
    }

    private void measureChildren() {
        int i = getChildCount();
        int j = getMeasuredWidth() - super.mPaddingLeft - super.mPaddingRight;
        int k = getMeasuredHeight() - super.mPaddingTop - super.mPaddingBottom;
        for(int l = 0; l < i; l++)
            getChildAt(l).measure(android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000));

    }

    private void setDisplayedChild(int i, boolean flag) {
        if(mAdapter != null) {
            mWhichChild = i;
            boolean flag1;
            if(i >= getWindowSize()) {
                int k;
                if(mLoopViews)
                    k = 0;
                else
                    k = -1 + getWindowSize();
                mWhichChild = k;
            } else
            if(i < 0) {
                int j;
                if(mLoopViews)
                    j = -1 + getWindowSize();
                else
                    j = 0;
                mWhichChild = j;
            }
            if(getFocusedChild() != null)
                flag1 = true;
            else
                flag1 = false;
            showOnly(mWhichChild, flag);
            if(flag1)
                requestFocus(2);
        }
    }

    public void advance() {
        showNext();
    }

    void applyTransformForChildAtIndex(View view, int i) {
    }

    void cancelHandleClick() {
        View view = getCurrentView();
        if(view != null)
            hideTapFeedback(view);
        mTouchMode = 0;
    }

    void checkForAndHandleDataChanged() {
        if(super.mDataChanged)
            post(new Runnable() {

                public void run() {
                    handleDataChanged();
                    if(mWhichChild < getWindowSize()) goto _L2; else goto _L1
_L1:
                    mWhichChild = 0;
                    showOnly(mWhichChild, false);
_L4:
                    refreshChildren();
                    requestLayout();
                    return;
_L2:
                    if(mOldItemCount != getCount())
                        showOnly(mWhichChild, false);
                    if(true) goto _L4; else goto _L3
_L3:
                }

                final AdapterViewAnimator this$0;

             {
                this$0 = AdapterViewAnimator.this;
                super();
            }
            });
        super.mDataChanged = false;
    }

    void configureViewAnimator(int i, int j) {
        if(j <= i - 1);
        mMaxNumActiveViews = i;
        mActiveOffset = j;
        mPreviousViews.clear();
        mViewsMap.clear();
        removeAllViewsInLayout();
        mCurrentWindowStart = 0;
        mCurrentWindowEnd = -1;
    }

    android.view.ViewGroup.LayoutParams createOrReuseLayoutParams(View view) {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        android.view.ViewGroup.LayoutParams layoutparams1;
        if(layoutparams instanceof android.view.ViewGroup.LayoutParams)
            layoutparams1 = layoutparams;
        else
            layoutparams1 = new android.view.ViewGroup.LayoutParams(0, 0);
        return layoutparams1;
    }

    public void deferNotifyDataSetChanged() {
        mDeferNotifyDataSetChanged = true;
    }

    public void fyiWillBeAdvancedByHostKThx() {
    }

    public Adapter getAdapter() {
        return mAdapter;
    }

    public int getBaseline() {
        int i;
        if(getCurrentView() != null)
            i = getCurrentView().getBaseline();
        else
            i = super.getBaseline();
        return i;
    }

    public View getCurrentView() {
        return getViewAtRelativeIndex(mActiveOffset);
    }

    ObjectAnimator getDefaultInAnimation() {
        float af[] = new float[2];
        af[0] = 0.0F;
        af[1] = 1.0F;
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(null, "alpha", af);
        objectanimator.setDuration(200L);
        return objectanimator;
    }

    ObjectAnimator getDefaultOutAnimation() {
        float af[] = new float[2];
        af[0] = 1.0F;
        af[1] = 0.0F;
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(null, "alpha", af);
        objectanimator.setDuration(200L);
        return objectanimator;
    }

    public int getDisplayedChild() {
        return mWhichChild;
    }

    FrameLayout getFrameForChild() {
        return new FrameLayout(super.mContext);
    }

    public ObjectAnimator getInAnimation() {
        return mInAnimation;
    }

    int getNumActiveViews() {
        int i;
        if(mAdapter != null)
            i = Math.min(1 + getCount(), mMaxNumActiveViews);
        else
            i = mMaxNumActiveViews;
        return i;
    }

    public ObjectAnimator getOutAnimation() {
        return mOutAnimation;
    }

    public View getSelectedView() {
        return getViewAtRelativeIndex(mActiveOffset);
    }

    View getViewAtRelativeIndex(int i) {
        if(i < 0 || i > -1 + getNumActiveViews() || mAdapter == null) goto _L2; else goto _L1
_L1:
        int j = modulo(i + mCurrentWindowStartUnbounded, getWindowSize());
        if(mViewsMap.get(Integer.valueOf(j)) == null) goto _L2; else goto _L3
_L3:
        View view = ((ViewAndMetaData)mViewsMap.get(Integer.valueOf(j))).view;
_L5:
        return view;
_L2:
        view = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    int getWindowSize() {
        int i;
        if(mAdapter != null) {
            i = getCount();
            if(i <= getNumActiveViews() && mLoopViews)
                i *= mMaxNumActiveViews;
        } else {
            i = 0;
        }
        return i;
    }

    void hideTapFeedback(View view) {
        view.setPressed(false);
    }

    int modulo(int i, int j) {
        int k;
        if(j > 0)
            k = (j + i % j) % j;
        else
            k = 0;
        return k;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/AdapterViewAnimator.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/AdapterViewAnimator.getName());
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        checkForAndHandleDataChanged();
        int i1 = getChildCount();
        for(int j1 = 0; j1 < i1; j1++) {
            View view = getChildAt(j1);
            int k1 = super.mPaddingLeft + view.getMeasuredWidth();
            int l1 = super.mPaddingTop + view.getMeasuredHeight();
            view.layout(super.mPaddingLeft, super.mPaddingTop, k1, l1);
        }

    }

    protected void onMeasure(int i, int j) {
        int k = android.view.View.MeasureSpec.getSize(i);
        int l = android.view.View.MeasureSpec.getSize(j);
        int i1 = android.view.View.MeasureSpec.getMode(i);
        int j1 = android.view.View.MeasureSpec.getMode(j);
        boolean flag;
        if(mReferenceChildWidth != -1 && mReferenceChildHeight != -1)
            flag = true;
        else
            flag = false;
        if(j1 == 0) {
            if(flag)
                l = mReferenceChildHeight + super.mPaddingTop + super.mPaddingBottom;
            else
                l = 0;
        } else
        if(j1 == 0x80000000 && flag) {
            int k1 = mReferenceChildHeight + super.mPaddingTop + super.mPaddingBottom;
            if(k1 > l)
                l |= 0x1000000;
            else
                l = k1;
        }
        if(i1 == 0) {
            if(flag)
                k = mReferenceChildWidth + super.mPaddingLeft + super.mPaddingRight;
            else
                k = 0;
        } else
        if(j1 == 0x80000000 && flag) {
            int l1 = mReferenceChildWidth + super.mPaddingLeft + super.mPaddingRight;
            if(l1 > k)
                k |= 0x1000000;
            else
                k = l1;
        }
        setMeasuredDimension(k, l);
        measureChildren();
    }

    public boolean onRemoteAdapterConnected() {
        boolean flag = false;
        if(mRemoteViewsAdapter == mAdapter) goto _L2; else goto _L1
_L1:
        setAdapter(mRemoteViewsAdapter);
        if(mDeferNotifyDataSetChanged) {
            mRemoteViewsAdapter.notifyDataSetChanged();
            mDeferNotifyDataSetChanged = false;
        }
        if(mRestoreWhichChild > -1) {
            setDisplayedChild(mRestoreWhichChild, false);
            mRestoreWhichChild = -1;
        }
_L4:
        return flag;
_L2:
        if(mRemoteViewsAdapter != null) {
            mRemoteViewsAdapter.superNotifyDataSetChanged();
            flag = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onRemoteAdapterDisconnected() {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        mWhichChild = savedstate.whichChild;
        if(mRemoteViewsAdapter != null && mAdapter == null)
            mRestoreWhichChild = mWhichChild;
        else
            setDisplayedChild(mWhichChild, false);
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), mWhichChild);
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        int i;
        boolean flag;
        i = motionevent.getAction();
        flag = false;
        i;
        JVM INSTR tableswitch 0 6: default 52
    //                   0 54
    //                   1 123
    //                   2 52
    //                   3 225
    //                   4 52
    //                   5 52
    //                   6 52;
           goto _L1 _L2 _L3 _L1 _L4 _L1 _L1 _L1
_L1:
        return flag;
_L2:
        View view1 = getCurrentView();
        if(view1 != null && isTransformedTouchPointInView(motionevent.getX(), motionevent.getY(), view1, null)) {
            if(mPendingCheckForTap == null)
                mPendingCheckForTap = new CheckForTap();
            mTouchMode = 1;
            postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if(mTouchMode == 1) {
            final View v = getCurrentView();
            final ViewAndMetaData viewData = getMetaDataForChild(v);
            if(v != null && isTransformedTouchPointInView(motionevent.getX(), motionevent.getY(), v, null)) {
                Handler handler = getHandler();
                if(handler != null)
                    handler.removeCallbacks(mPendingCheckForTap);
                showTapFeedback(v);
                postDelayed(new Runnable() {

                    public void run() {
                        hideTapFeedback(v);
                        post(new Runnable() {

                            public void run() {
                                if(viewData != null)
                                    performItemClick(v, viewData.adapterPosition, viewData.itemId);
                                else
                                    performItemClick(v, 0, 0L);
                            }

                            final _cls1 this$1;

                     {
                        this$1 = _cls1.this;
                        super();
                    }
                        });
                    }

                    final AdapterViewAnimator this$0;
                    final View val$v;
                    final ViewAndMetaData val$viewData;

             {
                this$0 = AdapterViewAnimator.this;
                v = view;
                viewData = viewandmetadata;
                super();
            }
                }, ViewConfiguration.getPressedStateDuration());
                flag = true;
            }
        }
        mTouchMode = 0;
        continue; /* Loop/switch isn't completed */
_L4:
        View view = getCurrentView();
        if(view != null)
            hideTapFeedback(view);
        mTouchMode = 0;
        if(true) goto _L1; else goto _L5
_L5:
    }

    void refreshChildren() {
        if(mAdapter != null) {
            int i = mCurrentWindowStart;
            while(i <= mCurrentWindowEnd)  {
                int j = modulo(i, getWindowSize());
                int k = getCount();
                View view = mAdapter.getView(modulo(i, k), null, this);
                if(view.getImportantForAccessibility() == 0)
                    view.setImportantForAccessibility(1);
                if(mViewsMap.containsKey(Integer.valueOf(j))) {
                    FrameLayout framelayout = (FrameLayout)((ViewAndMetaData)mViewsMap.get(Integer.valueOf(j))).view;
                    if(view != null) {
                        framelayout.removeAllViewsInLayout();
                        framelayout.addView(view);
                    }
                }
                i++;
            }
        }
    }

    public void setAdapter(Adapter adapter) {
        if(mAdapter != null && mDataSetObserver != null)
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        mAdapter = adapter;
        checkFocus();
        if(mAdapter != null) {
            mDataSetObserver = new AdapterView.AdapterDataSetObserver(this);
            mAdapter.registerDataSetObserver(mDataSetObserver);
            super.mItemCount = mAdapter.getCount();
        }
        setFocusable(true);
        mWhichChild = 0;
        showOnly(mWhichChild, false);
    }

    public void setAnimateFirstView(boolean flag) {
        mAnimateFirstTime = flag;
    }

    public void setDisplayedChild(int i) {
        setDisplayedChild(i, true);
    }

    public void setInAnimation(ObjectAnimator objectanimator) {
        mInAnimation = objectanimator;
    }

    public void setInAnimation(Context context, int i) {
        setInAnimation((ObjectAnimator)AnimatorInflater.loadAnimator(context, i));
    }

    public void setOutAnimation(ObjectAnimator objectanimator) {
        mOutAnimation = objectanimator;
    }

    public void setOutAnimation(Context context, int i) {
        setOutAnimation((ObjectAnimator)AnimatorInflater.loadAnimator(context, i));
    }

    public void setRemoteViewsAdapter(Intent intent) {
        if(mRemoteViewsAdapter == null || !(new android.content.Intent.FilterComparison(intent)).equals(new android.content.Intent.FilterComparison(mRemoteViewsAdapter.getRemoteViewsServiceIntent()))) {
            mDeferNotifyDataSetChanged = false;
            mRemoteViewsAdapter = new RemoteViewsAdapter(getContext(), intent, this);
        }
    }

    public void setSelection(int i) {
        setDisplayedChild(i);
    }

    public void showNext() {
        setDisplayedChild(1 + mWhichChild);
    }

    void showOnly(int i, boolean flag) {
        if(mAdapter != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
label0:
        {
            int j = getCount();
            if(j == 0)
                continue; /* Loop/switch isn't completed */
            for(int k = 0; k < mPreviousViews.size(); k++) {
                View view3 = ((ViewAndMetaData)mViewsMap.get(mPreviousViews.get(k))).view;
                mViewsMap.remove(mPreviousViews.get(k));
                view3.clearAnimation();
                if(view3 instanceof ViewGroup)
                    ((ViewGroup)view3).removeAllViewsInLayout();
                applyTransformForChildAtIndex(view3, -1);
                removeViewInLayout(view3);
            }

            mPreviousViews.clear();
            int l = i - mActiveOffset;
            int i1 = -1 + (l + getNumActiveViews());
            int j1 = Math.max(0, l);
            int k1 = Math.min(j - 1, i1);
            if(mLoopViews) {
                j1 = l;
                k1 = i1;
            }
            int l1 = getWindowSize();
            int i2 = modulo(j1, l1);
            int j2 = getWindowSize();
            int k2 = modulo(k1, j2);
            boolean flag1 = false;
            if(i2 > k2)
                flag1 = true;
            for(Iterator iterator = mViewsMap.keySet().iterator(); iterator.hasNext();) {
                Integer integer = (Integer)iterator.next();
                boolean flag3 = false;
                if(!flag1 && (integer.intValue() < i2 || integer.intValue() > k2))
                    flag3 = true;
                else
                if(flag1 && integer.intValue() > k2 && integer.intValue() < i2)
                    flag3 = true;
                if(flag3) {
                    View view2 = ((ViewAndMetaData)mViewsMap.get(integer)).view;
                    int j5 = ((ViewAndMetaData)mViewsMap.get(integer)).relativeIndex;
                    mPreviousViews.add(integer);
                    transformViewForTransition(j5, -1, view2, flag);
                }
            }

            int l2 = mCurrentWindowStart;
            if(j1 == l2) {
                int i5 = mCurrentWindowEnd;
                if(k1 == i5 && l == mCurrentWindowStartUnbounded)
                    break label0;
            }
            int i3 = j1;
            while(i3 <= k1)  {
                int l3 = modulo(i3, getWindowSize());
                int i4;
                int j4;
                boolean flag2;
                if(mViewsMap.containsKey(Integer.valueOf(l3)))
                    i4 = ((ViewAndMetaData)mViewsMap.get(Integer.valueOf(l3))).relativeIndex;
                else
                    i4 = -1;
                j4 = i3 - l;
                if(mViewsMap.containsKey(Integer.valueOf(l3)) && !mPreviousViews.contains(Integer.valueOf(l3)))
                    flag2 = true;
                else
                    flag2 = false;
                if(flag2) {
                    View view1 = ((ViewAndMetaData)mViewsMap.get(Integer.valueOf(l3))).view;
                    ((ViewAndMetaData)mViewsMap.get(Integer.valueOf(l3))).relativeIndex = j4;
                    applyTransformForChildAtIndex(view1, j4);
                    transformViewForTransition(i4, j4, view1, flag);
                } else {
                    int k4 = modulo(i3, j);
                    View view = mAdapter.getView(k4, null, this);
                    long l4 = mAdapter.getItemId(k4);
                    FrameLayout framelayout = getFrameForChild();
                    if(view != null)
                        framelayout.addView(view);
                    mViewsMap.put(Integer.valueOf(l3), new ViewAndMetaData(framelayout, j4, k4, l4));
                    addChild(framelayout);
                    applyTransformForChildAtIndex(framelayout, j4);
                    transformViewForTransition(-1, j4, framelayout, flag);
                }
                ((ViewAndMetaData)mViewsMap.get(Integer.valueOf(l3))).view.bringToFront();
                i3++;
            }
            mCurrentWindowStart = j1;
            mCurrentWindowEnd = k1;
            mCurrentWindowStartUnbounded = l;
            if(mRemoteViewsAdapter != null) {
                int j3 = modulo(mCurrentWindowStart, j);
                int k3 = modulo(mCurrentWindowEnd, j);
                mRemoteViewsAdapter.setVisibleRangeHint(j3, k3);
            }
        }
        requestLayout();
        invalidate();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void showPrevious() {
        setDisplayedChild(-1 + mWhichChild);
    }

    void showTapFeedback(View view) {
        view.setPressed(true);
    }

    void transformViewForTransition(int i, int j, View view, boolean flag) {
        if(i != -1) goto _L2; else goto _L1
_L1:
        mInAnimation.setTarget(view);
        mInAnimation.start();
_L4:
        return;
_L2:
        if(j == -1) {
            mOutAnimation.setTarget(view);
            mOutAnimation.start();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final int DEFAULT_ANIMATION_DURATION = 200;
    private static final String TAG = "RemoteViewAnimator";
    static final int TOUCH_MODE_DOWN_IN_CURRENT_VIEW = 1;
    static final int TOUCH_MODE_HANDLED = 2;
    static final int TOUCH_MODE_NONE;
    int mActiveOffset;
    Adapter mAdapter;
    boolean mAnimateFirstTime;
    int mCurrentWindowEnd;
    int mCurrentWindowStart;
    int mCurrentWindowStartUnbounded;
    AdapterView.AdapterDataSetObserver mDataSetObserver;
    boolean mDeferNotifyDataSetChanged;
    boolean mFirstTime;
    ObjectAnimator mInAnimation;
    boolean mLoopViews;
    int mMaxNumActiveViews;
    ObjectAnimator mOutAnimation;
    private Runnable mPendingCheckForTap;
    ArrayList mPreviousViews;
    int mReferenceChildHeight;
    int mReferenceChildWidth;
    RemoteViewsAdapter mRemoteViewsAdapter;
    private int mRestoreWhichChild;
    private int mTouchMode;
    HashMap mViewsMap;
    int mWhichChild;

}
