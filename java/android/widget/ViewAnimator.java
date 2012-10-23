// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

// Referenced classes of package android.widget:
//            FrameLayout

public class ViewAnimator extends FrameLayout {

    public ViewAnimator(Context context) {
        super(context);
        mWhichChild = 0;
        mFirstTime = true;
        mAnimateFirstTime = true;
        initViewAnimator(context, null);
    }

    public ViewAnimator(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mWhichChild = 0;
        mFirstTime = true;
        mAnimateFirstTime = true;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ViewAnimator);
        int i = typedarray.getResourceId(0, 0);
        if(i > 0)
            setInAnimation(context, i);
        int j = typedarray.getResourceId(1, 0);
        if(j > 0)
            setOutAnimation(context, j);
        setAnimateFirstView(typedarray.getBoolean(2, true));
        typedarray.recycle();
        initViewAnimator(context, attributeset);
    }

    private void initViewAnimator(Context context, AttributeSet attributeset) {
        if(attributeset == null) {
            super.mMeasureAllChildren = true;
        } else {
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.FrameLayout);
            setMeasureAllChildren(typedarray.getBoolean(1, true));
            typedarray.recycle();
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams) {
        super.addView(view, i, layoutparams);
        if(getChildCount() == 1)
            view.setVisibility(0);
        else
            view.setVisibility(8);
        if(i >= 0 && mWhichChild >= i)
            setDisplayedChild(1 + mWhichChild);
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
        return getChildAt(mWhichChild);
    }

    public int getDisplayedChild() {
        return mWhichChild;
    }

    public Animation getInAnimation() {
        return mInAnimation;
    }

    public Animation getOutAnimation() {
        return mOutAnimation;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/ViewAnimator.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/ViewAnimator.getName());
    }

    public void removeAllViews() {
        super.removeAllViews();
        mWhichChild = 0;
        mFirstTime = true;
    }

    public void removeView(View view) {
        int i = indexOfChild(view);
        if(i >= 0)
            removeViewAt(i);
    }

    public void removeViewAt(int i) {
        int j;
        super.removeViewAt(i);
        j = getChildCount();
        if(j != 0) goto _L2; else goto _L1
_L1:
        mWhichChild = 0;
        mFirstTime = true;
_L4:
        return;
_L2:
        if(mWhichChild >= j)
            setDisplayedChild(j - 1);
        else
        if(mWhichChild == i)
            setDisplayedChild(mWhichChild);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void removeViewInLayout(View view) {
        removeView(view);
    }

    public void removeViews(int i, int j) {
        super.removeViews(i, j);
        if(getChildCount() != 0) goto _L2; else goto _L1
_L1:
        mWhichChild = 0;
        mFirstTime = true;
_L4:
        return;
_L2:
        if(mWhichChild >= i && mWhichChild < i + j)
            setDisplayedChild(mWhichChild);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void removeViewsInLayout(int i, int j) {
        removeViews(i, j);
    }

    public void setAnimateFirstView(boolean flag) {
        mAnimateFirstTime = flag;
    }

    public void setDisplayedChild(int i) {
        boolean flag;
        flag = false;
        mWhichChild = i;
        if(i < getChildCount()) goto _L2; else goto _L1
_L1:
        mWhichChild = 0;
_L4:
        if(getFocusedChild() != null)
            flag = true;
        showOnly(mWhichChild);
        if(flag)
            requestFocus(2);
        return;
_L2:
        if(i < 0)
            mWhichChild = -1 + getChildCount();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setInAnimation(Context context, int i) {
        setInAnimation(AnimationUtils.loadAnimation(context, i));
    }

    public void setInAnimation(Animation animation) {
        mInAnimation = animation;
    }

    public void setOutAnimation(Context context, int i) {
        setOutAnimation(AnimationUtils.loadAnimation(context, i));
    }

    public void setOutAnimation(Animation animation) {
        mOutAnimation = animation;
    }

    public void showNext() {
        setDisplayedChild(1 + mWhichChild);
    }

    void showOnly(int i) {
        boolean flag;
        if(!mFirstTime || mAnimateFirstTime)
            flag = true;
        else
            flag = false;
        showOnly(i, flag);
    }

    void showOnly(int i, boolean flag) {
        int j = getChildCount();
        int k = 0;
        while(k < j)  {
            View view = getChildAt(k);
            if(k == i) {
                if(flag && mInAnimation != null)
                    view.startAnimation(mInAnimation);
                view.setVisibility(0);
                mFirstTime = false;
            } else {
                if(flag && mOutAnimation != null && view.getVisibility() == 0)
                    view.startAnimation(mOutAnimation);
                else
                if(view.getAnimation() == mInAnimation)
                    view.clearAnimation();
                view.setVisibility(8);
            }
            k++;
        }
    }

    public void showPrevious() {
        setDisplayedChild(-1 + mWhichChild);
    }

    boolean mAnimateFirstTime;
    boolean mFirstTime;
    Animation mInAnimation;
    Animation mOutAnimation;
    int mWhichChild;
}
