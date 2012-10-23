// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.*;
import java.lang.ref.WeakReference;

// Referenced classes of package android.widget:
//            FrameLayout

public class PopupWindow {
    private class PopupViewContainer extends FrameLayout {

        public boolean dispatchKeyEvent(KeyEvent keyevent) {
            boolean flag = true;
            if(keyevent.getKeyCode() != 4) goto _L2; else goto _L1
_L1:
            if(getKeyDispatcherState() != null) goto _L4; else goto _L3
_L3:
            flag = super.dispatchKeyEvent(keyevent);
_L6:
            return flag;
_L4:
            if(keyevent.getAction() == 0 && keyevent.getRepeatCount() == 0) {
                android.view.KeyEvent.DispatcherState dispatcherstate1 = getKeyDispatcherState();
                if(dispatcherstate1 != null)
                    dispatcherstate1.startTracking(keyevent, this);
                continue; /* Loop/switch isn't completed */
            }
            if(keyevent.getAction() == flag) {
                android.view.KeyEvent.DispatcherState dispatcherstate = getKeyDispatcherState();
                if(dispatcherstate != null && dispatcherstate.isTracking(keyevent) && !keyevent.isCanceled()) {
                    dismiss();
                    continue; /* Loop/switch isn't completed */
                }
            }
            flag = super.dispatchKeyEvent(keyevent);
            continue; /* Loop/switch isn't completed */
_L2:
            flag = super.dispatchKeyEvent(keyevent);
            if(true) goto _L6; else goto _L5
_L5:
        }

        public boolean dispatchTouchEvent(MotionEvent motionevent) {
            boolean flag;
            if(mTouchInterceptor != null && mTouchInterceptor.onTouch(this, motionevent))
                flag = true;
            else
                flag = super.dispatchTouchEvent(motionevent);
            return flag;
        }

        protected int[] onCreateDrawableState(int i) {
            int ai[];
            if(mAboveAnchor) {
                ai = super.onCreateDrawableState(i + 1);
                View.mergeDrawableStates(ai, PopupWindow.ABOVE_ANCHOR_STATE_SET);
            } else {
                ai = super.onCreateDrawableState(i);
            }
            return ai;
        }

        public boolean onTouchEvent(MotionEvent motionevent) {
            boolean flag = true;
            int i = (int)motionevent.getX();
            int j = (int)motionevent.getY();
            if(motionevent.getAction() == 0 && (i < 0 || i >= getWidth() || j < 0 || j >= getHeight()))
                dismiss();
            else
            if(motionevent.getAction() == 4)
                dismiss();
            else
                flag = super.onTouchEvent(motionevent);
            return flag;
        }

        public void sendAccessibilityEvent(int i) {
            if(mContentView != null)
                mContentView.sendAccessibilityEvent(i);
            else
                super.sendAccessibilityEvent(i);
        }

        private static final String TAG = "PopupWindow.PopupViewContainer";
        final PopupWindow this$0;

        public PopupViewContainer(Context context) {
            this$0 = PopupWindow.this;
            super(context);
        }
    }

    public static interface OnDismissListener {

        public abstract void onDismiss();
    }


    public PopupWindow() {
        this(((View) (null)), 0, 0);
    }

    public PopupWindow(int i, int j) {
        this(((View) (null)), i, j);
    }

    public PopupWindow(Context context) {
        this(context, ((AttributeSet) (null)));
    }

    public PopupWindow(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010076);
    }

    public PopupWindow(Context context, AttributeSet attributeset, int i) {
        this(context, attributeset, i, 0);
    }

    public PopupWindow(Context context, AttributeSet attributeset, int i, int j) {
        TypedArray typedarray;
        mInputMethodMode = 0;
        mSoftInputMode = 1;
        mTouchable = true;
        mOutsideTouchable = false;
        mClippingEnabled = true;
        mSplitTouchEnabled = -1;
        mAllowScrollingAnchorParent = true;
        mLayoutInsetDecor = false;
        mDrawingLocation = new int[2];
        mScreenLocation = new int[2];
        mTempRect = new Rect();
        mWindowLayoutType = 1000;
        mIgnoreCheekPress = false;
        mAnimationStyle = -1;
        mOnScrollChangedListener = new android.view.ViewTreeObserver.OnScrollChangedListener() {

            public void onScrollChanged() {
                View view;
                if(mAnchor != null)
                    view = (View)mAnchor.get();
                else
                    view = null;
                if(view != null && mPopupView != null) {
                    android.view.WindowManager.LayoutParams layoutparams = (android.view.WindowManager.LayoutParams)mPopupView.getLayoutParams();
                    updateAboveAnchor(findDropDownPosition(view, layoutparams, mAnchorXoff, mAnchorYoff));
                    update(layoutparams.x, layoutparams.y, -1, -1, true);
                }
            }

            final PopupWindow this$0;

             {
                this$0 = PopupWindow.this;
                super();
            }
        };
        mContext = context;
        mWindowManager = (WindowManager)context.getSystemService("window");
        typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.PopupWindow, i, j);
        mBackground = typedarray.getDrawable(0);
        int k = typedarray.getResourceId(1, -1);
        if(k == 0x10301ea)
            k = -1;
        mAnimationStyle = k;
        if(!(mBackground instanceof StateListDrawable)) goto _L2; else goto _L1
_L1:
        StateListDrawable statelistdrawable;
        int l;
        int i1;
        int j1;
        int k1;
        statelistdrawable = (StateListDrawable)mBackground;
        l = statelistdrawable.getStateDrawableIndex(ABOVE_ANCHOR_STATE_SET);
        i1 = statelistdrawable.getStateCount();
        j1 = -1;
        k1 = 0;
_L8:
        if(k1 >= i1) goto _L4; else goto _L3
_L3:
        if(k1 == l) goto _L6; else goto _L5
_L5:
        j1 = k1;
_L4:
        if(l != -1 && j1 != -1) {
            mAboveAnchorBackgroundDrawable = statelistdrawable.getStateDrawable(l);
            mBelowAnchorBackgroundDrawable = statelistdrawable.getStateDrawable(j1);
        } else {
            mBelowAnchorBackgroundDrawable = null;
            mAboveAnchorBackgroundDrawable = null;
        }
_L2:
        typedarray.recycle();
        return;
_L6:
        k1++;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public PopupWindow(View view) {
        this(view, 0, 0);
    }

    public PopupWindow(View view, int i, int j) {
        this(view, i, j, false);
    }

    public PopupWindow(View view, int i, int j, boolean flag) {
        mInputMethodMode = 0;
        mSoftInputMode = 1;
        mTouchable = true;
        mOutsideTouchable = false;
        mClippingEnabled = true;
        mSplitTouchEnabled = -1;
        mAllowScrollingAnchorParent = true;
        mLayoutInsetDecor = false;
        mDrawingLocation = new int[2];
        mScreenLocation = new int[2];
        mTempRect = new Rect();
        mWindowLayoutType = 1000;
        mIgnoreCheekPress = false;
        mAnimationStyle = -1;
        if(view != null) {
            mContext = view.getContext();
            mWindowManager = (WindowManager)mContext.getSystemService("window");
        }
        setContentView(view);
        setWidth(i);
        setHeight(j);
        setFocusable(flag);
    }

    private int computeAnimationResource() {
        int i;
        if(mAnimationStyle == -1) {
            if(mIsDropdown) {
                if(mAboveAnchor)
                    i = 0x10301e4;
                else
                    i = 0x10301e3;
            } else {
                i = 0;
            }
        } else {
            i = mAnimationStyle;
        }
        return i;
    }

    private int computeFlags(int i) {
        int j;
        j = i & 0xff797de7;
        if(mIgnoreCheekPress)
            j |= 0x8000;
        if(mFocusable) goto _L2; else goto _L1
_L1:
        j |= 8;
        if(mInputMethodMode == 1)
            j |= 0x20000;
_L4:
        if(!mTouchable)
            j |= 0x10;
        if(mOutsideTouchable)
            j |= 0x40000;
        if(!mClippingEnabled)
            j |= 0x200;
        if(isSplitTouchEnabled())
            j |= 0x800000;
        if(mLayoutInScreen)
            j |= 0x100;
        if(mLayoutInsetDecor)
            j |= 0x10000;
        if(mNotTouchModal)
            j |= 0x20;
        return j;
_L2:
        if(mInputMethodMode == 2)
            j |= 0x20000;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private android.view.WindowManager.LayoutParams createPopupLayout(IBinder ibinder) {
        android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams();
        layoutparams.gravity = 51;
        int i = mWidth;
        mLastWidth = i;
        layoutparams.width = i;
        int j = mHeight;
        mLastHeight = j;
        layoutparams.height = j;
        if(mBackground != null)
            layoutparams.format = mBackground.getOpacity();
        else
            layoutparams.format = -3;
        layoutparams.flags = computeFlags(layoutparams.flags);
        layoutparams.type = mWindowLayoutType;
        layoutparams.token = ibinder;
        layoutparams.softInputMode = mSoftInputMode;
        layoutparams.setTitle((new StringBuilder()).append("PopupWindow:").append(Integer.toHexString(hashCode())).toString());
        return layoutparams;
    }

    private boolean findDropDownPosition(View view, android.view.WindowManager.LayoutParams layoutparams, int i, int j) {
        int k = view.getHeight();
        view.getLocationInWindow(mDrawingLocation);
        layoutparams.x = i + mDrawingLocation[0];
        layoutparams.y = j + (k + mDrawingLocation[1]);
        boolean flag = false;
        layoutparams.gravity = 51;
        view.getLocationOnScreen(mScreenLocation);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int l = j + (k + mScreenLocation[1]);
        View view1 = view.getRootView();
        if(l + mPopupHeight > rect.bottom || (layoutparams.x + mPopupWidth) - view1.getWidth() > 0) {
            if(mAllowScrollingAnchorParent) {
                int l1 = view.getScrollX();
                int i2 = view.getScrollY();
                view.requestRectangleOnScreen(new Rect(l1, i2, i + (l1 + mPopupWidth), j + (i2 + mPopupHeight + view.getHeight())), true);
            }
            view.getLocationInWindow(mDrawingLocation);
            layoutparams.x = i + mDrawingLocation[0];
            layoutparams.y = j + (mDrawingLocation[1] + view.getHeight());
            view.getLocationOnScreen(mScreenLocation);
            int i1;
            int j1;
            int k1;
            if(rect.bottom - mScreenLocation[1] - view.getHeight() - j < mScreenLocation[1] - j - rect.top)
                flag = true;
            else
                flag = false;
            if(flag) {
                layoutparams.gravity = 83;
                layoutparams.y = j + (view1.getHeight() - mDrawingLocation[1]);
            } else {
                layoutparams.y = j + (mDrawingLocation[1] + view.getHeight());
            }
        }
        if(mClipToScreen) {
            i1 = rect.right - rect.left;
            j1 = layoutparams.x + ((android.view.ViewGroup.LayoutParams) (layoutparams)).width;
            if(j1 > i1)
                layoutparams.x = layoutparams.x - (j1 - i1);
            if(layoutparams.x < rect.left) {
                layoutparams.x = rect.left;
                layoutparams.width = Math.min(((android.view.ViewGroup.LayoutParams) (layoutparams)).width, i1);
            }
            if(flag) {
                k1 = (j + mScreenLocation[1]) - mPopupHeight;
                if(k1 < 0)
                    layoutparams.y = k1 + layoutparams.y;
            } else {
                layoutparams.y = Math.max(layoutparams.y, rect.top);
            }
        }
        layoutparams.gravity = 0x10000000 | layoutparams.gravity;
        return flag;
    }

    private void invokePopup(android.view.WindowManager.LayoutParams layoutparams) {
        if(mContext != null)
            layoutparams.packageName = mContext.getPackageName();
        mPopupView.setFitsSystemWindows(mLayoutInsetDecor);
        mWindowManager.addView(mPopupView, layoutparams);
    }

    private void preparePopup(android.view.WindowManager.LayoutParams layoutparams) {
        if(mContentView == null || mContext == null || mWindowManager == null)
            throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
        if(mBackground != null) {
            android.view.ViewGroup.LayoutParams layoutparams1 = mContentView.getLayoutParams();
            byte byte0 = -1;
            if(layoutparams1 != null && layoutparams1.height == -2)
                byte0 = -2;
            PopupViewContainer popupviewcontainer = new PopupViewContainer(mContext);
            FrameLayout.LayoutParams layoutparams2 = new FrameLayout.LayoutParams(-1, byte0);
            popupviewcontainer.setBackgroundDrawable(mBackground);
            popupviewcontainer.addView(mContentView, layoutparams2);
            mPopupView = popupviewcontainer;
        } else {
            mPopupView = mContentView;
        }
        mPopupWidth = ((android.view.ViewGroup.LayoutParams) (layoutparams)).width;
        mPopupHeight = ((android.view.ViewGroup.LayoutParams) (layoutparams)).height;
    }

    private void registerForScrollChanged(View view, int i, int j) {
        unregisterForScrollChanged();
        mAnchor = new WeakReference(view);
        ViewTreeObserver viewtreeobserver = view.getViewTreeObserver();
        if(viewtreeobserver != null)
            viewtreeobserver.addOnScrollChangedListener(mOnScrollChangedListener);
        mAnchorXoff = i;
        mAnchorYoff = j;
    }

    private void unregisterForScrollChanged() {
        WeakReference weakreference = mAnchor;
        View view = null;
        if(weakreference != null)
            view = (View)weakreference.get();
        if(view != null)
            view.getViewTreeObserver().removeOnScrollChangedListener(mOnScrollChangedListener);
        mAnchor = null;
    }

    private void update(View view, boolean flag, int i, int j, boolean flag1, int k, int l) {
        if(isShowing() && mContentView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag2;
        WeakReference weakreference = mAnchor;
        int i1;
        int j1;
        int k1;
        int l1;
        if(flag && (mAnchorXoff != i || mAnchorYoff != j))
            flag2 = true;
        else
            flag2 = false;
        if(weakreference != null && weakreference.get() == view && (!flag2 || mIsDropdown)) goto _L4; else goto _L3
_L3:
        registerForScrollChanged(view, i, j);
_L5:
        android.view.WindowManager.LayoutParams layoutparams = (android.view.WindowManager.LayoutParams)mPopupView.getLayoutParams();
        boolean flag3;
        if(flag1) {
            if(k == -1)
                k = mPopupWidth;
            else
                mPopupWidth = k;
            if(l == -1)
                l = mPopupHeight;
            else
                mPopupHeight = l;
        }
        i1 = layoutparams.x;
        j1 = layoutparams.y;
        if(flag)
            updateAboveAnchor(findDropDownPosition(view, layoutparams, i, j));
        else
            updateAboveAnchor(findDropDownPosition(view, layoutparams, mAnchorXoff, mAnchorYoff));
        k1 = layoutparams.x;
        l1 = layoutparams.y;
        if(i1 != layoutparams.x || j1 != layoutparams.y)
            flag3 = true;
        else
            flag3 = false;
        update(k1, l1, k, l, flag3);
        if(true) goto _L1; else goto _L4
_L4:
        if(flag2) {
            mAnchorXoff = i;
            mAnchorYoff = j;
        }
          goto _L5
    }

    private void updateAboveAnchor(boolean flag) {
        if(flag != mAboveAnchor) {
            mAboveAnchor = flag;
            if(mBackground != null)
                if(mAboveAnchorBackgroundDrawable != null) {
                    if(mAboveAnchor)
                        mPopupView.setBackgroundDrawable(mAboveAnchorBackgroundDrawable);
                    else
                        mPopupView.setBackgroundDrawable(mBelowAnchorBackgroundDrawable);
                } else {
                    mPopupView.refreshDrawableState();
                }
        }
    }

    public void dismiss() {
        if(!isShowing() || mPopupView == null)
            break MISSING_BLOCK_LABEL_92;
        mIsShowing = false;
        unregisterForScrollChanged();
        mWindowManager.removeViewImmediate(mPopupView);
        if(mPopupView != mContentView && (mPopupView instanceof ViewGroup))
            ((ViewGroup)mPopupView).removeView(mContentView);
        mPopupView = null;
        if(mOnDismissListener != null)
            mOnDismissListener.onDismiss();
        return;
        Exception exception;
        exception;
        if(mPopupView != mContentView && (mPopupView instanceof ViewGroup))
            ((ViewGroup)mPopupView).removeView(mContentView);
        mPopupView = null;
        if(mOnDismissListener != null)
            mOnDismissListener.onDismiss();
        throw exception;
    }

    public int getAnimationStyle() {
        return mAnimationStyle;
    }

    public Drawable getBackground() {
        return mBackground;
    }

    public View getContentView() {
        return mContentView;
    }

    public int getHeight() {
        return mHeight;
    }

    public int getInputMethodMode() {
        return mInputMethodMode;
    }

    public int getMaxAvailableHeight(View view) {
        return getMaxAvailableHeight(view, 0);
    }

    public int getMaxAvailableHeight(View view, int i) {
        return getMaxAvailableHeight(view, i, false);
    }

    public int getMaxAvailableHeight(View view, int i, boolean flag) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int ai[] = mDrawingLocation;
        view.getLocationOnScreen(ai);
        int j = rect.bottom;
        if(flag)
            j = view.getContext().getResources().getDisplayMetrics().heightPixels;
        int k = Math.max(j - (ai[1] + view.getHeight()) - i, i + (ai[1] - rect.top));
        if(mBackground != null) {
            mBackground.getPadding(mTempRect);
            k -= mTempRect.top + mTempRect.bottom;
        }
        return k;
    }

    public int getSoftInputMode() {
        return mSoftInputMode;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getWindowLayoutType() {
        return mWindowLayoutType;
    }

    public boolean isAboveAnchor() {
        return mAboveAnchor;
    }

    public boolean isClippingEnabled() {
        return mClippingEnabled;
    }

    public boolean isFocusable() {
        return mFocusable;
    }

    public boolean isLayoutInScreenEnabled() {
        return mLayoutInScreen;
    }

    public boolean isOutsideTouchable() {
        return mOutsideTouchable;
    }

    public boolean isShowing() {
        return mIsShowing;
    }

    public boolean isSplitTouchEnabled() {
        boolean flag = true;
        if(mSplitTouchEnabled >= 0 || mContext == null) goto _L2; else goto _L1
_L1:
        if(mContext.getApplicationInfo().targetSdkVersion < 11)
            flag = false;
_L4:
        return flag;
_L2:
        if(mSplitTouchEnabled != flag)
            flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean isTouchable() {
        return mTouchable;
    }

    void setAllowScrollingAnchorParent(boolean flag) {
        mAllowScrollingAnchorParent = flag;
    }

    public void setAnimationStyle(int i) {
        mAnimationStyle = i;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        mBackground = drawable;
    }

    public void setClipToScreenEnabled(boolean flag) {
        mClipToScreen = flag;
        boolean flag1;
        if(!flag)
            flag1 = true;
        else
            flag1 = false;
        setClippingEnabled(flag1);
    }

    public void setClippingEnabled(boolean flag) {
        mClippingEnabled = flag;
    }

    public void setContentView(View view) {
        if(!isShowing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mContentView = view;
        if(mContext == null && mContentView != null)
            mContext = mContentView.getContext();
        if(mWindowManager == null && mContentView != null)
            mWindowManager = (WindowManager)mContext.getSystemService("window");
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setFocusable(boolean flag) {
        mFocusable = flag;
    }

    public void setHeight(int i) {
        mHeight = i;
    }

    public void setIgnoreCheekPress() {
        mIgnoreCheekPress = true;
    }

    public void setInputMethodMode(int i) {
        mInputMethodMode = i;
    }

    public void setLayoutInScreenEnabled(boolean flag) {
        mLayoutInScreen = flag;
    }

    public void setLayoutInsetDecor(boolean flag) {
        mLayoutInsetDecor = flag;
    }

    public void setOnDismissListener(OnDismissListener ondismisslistener) {
        mOnDismissListener = ondismisslistener;
    }

    public void setOutsideTouchable(boolean flag) {
        mOutsideTouchable = flag;
    }

    public void setSoftInputMode(int i) {
        mSoftInputMode = i;
    }

    public void setSplitTouchEnabled(boolean flag) {
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        mSplitTouchEnabled = i;
    }

    public void setTouchInterceptor(android.view.View.OnTouchListener ontouchlistener) {
        mTouchInterceptor = ontouchlistener;
    }

    public void setTouchModal(boolean flag) {
        boolean flag1;
        if(!flag)
            flag1 = true;
        else
            flag1 = false;
        mNotTouchModal = flag1;
    }

    public void setTouchable(boolean flag) {
        mTouchable = flag;
    }

    public void setWidth(int i) {
        mWidth = i;
    }

    public void setWindowLayoutMode(int i, int j) {
        mWidthMode = i;
        mHeightMode = j;
    }

    public void setWindowLayoutType(int i) {
        mWindowLayoutType = i;
    }

    public void showAsDropDown(View view) {
        showAsDropDown(view, 0, 0);
    }

    public void showAsDropDown(View view, int i, int j) {
        if(!isShowing() && mContentView != null) {
            registerForScrollChanged(view, i, j);
            mIsShowing = true;
            mIsDropdown = true;
            android.view.WindowManager.LayoutParams layoutparams = createPopupLayout(view.getWindowToken());
            preparePopup(layoutparams);
            updateAboveAnchor(findDropDownPosition(view, layoutparams, i, j));
            if(mHeightMode < 0) {
                int l = mHeightMode;
                mLastHeight = l;
                layoutparams.height = l;
            }
            if(mWidthMode < 0) {
                int k = mWidthMode;
                mLastWidth = k;
                layoutparams.width = k;
            }
            layoutparams.windowAnimations = computeAnimationResource();
            invokePopup(layoutparams);
        }
    }

    public void showAtLocation(IBinder ibinder, int i, int j, int k) {
        if(!isShowing() && mContentView != null) {
            unregisterForScrollChanged();
            mIsShowing = true;
            mIsDropdown = false;
            android.view.WindowManager.LayoutParams layoutparams = createPopupLayout(ibinder);
            layoutparams.windowAnimations = computeAnimationResource();
            preparePopup(layoutparams);
            if(i == 0)
                i = 51;
            layoutparams.gravity = i;
            layoutparams.x = j;
            layoutparams.y = k;
            if(mHeightMode < 0) {
                int i1 = mHeightMode;
                mLastHeight = i1;
                layoutparams.height = i1;
            }
            if(mWidthMode < 0) {
                int l = mWidthMode;
                mLastWidth = l;
                layoutparams.width = l;
            }
            invokePopup(layoutparams);
        }
    }

    public void showAtLocation(View view, int i, int j, int k) {
        showAtLocation(view.getWindowToken(), i, j, k);
    }

    public void update() {
        if(isShowing() && mContentView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android.view.WindowManager.LayoutParams layoutparams = (android.view.WindowManager.LayoutParams)mPopupView.getLayoutParams();
        boolean flag = false;
        int i = computeAnimationResource();
        if(i != layoutparams.windowAnimations) {
            layoutparams.windowAnimations = i;
            flag = true;
        }
        int j = computeFlags(layoutparams.flags);
        if(j != layoutparams.flags) {
            layoutparams.flags = j;
            flag = true;
        }
        if(flag)
            mWindowManager.updateViewLayout(mPopupView, layoutparams);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void update(int i, int j) {
        android.view.WindowManager.LayoutParams layoutparams = (android.view.WindowManager.LayoutParams)mPopupView.getLayoutParams();
        update(layoutparams.x, layoutparams.y, i, j, false);
    }

    public void update(int i, int j, int k, int l) {
        update(i, j, k, l, false);
    }

    public void update(int i, int j, int k, int l, boolean flag) {
        if(k != -1) {
            mLastWidth = k;
            setWidth(k);
        }
        if(l != -1) {
            mLastHeight = l;
            setHeight(l);
        }
        if(isShowing() && mContentView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android.view.WindowManager.LayoutParams layoutparams = (android.view.WindowManager.LayoutParams)mPopupView.getLayoutParams();
        boolean flag1 = flag;
        int i1;
        int j1;
        int k1;
        int l1;
        if(mWidthMode < 0)
            i1 = mWidthMode;
        else
            i1 = mLastWidth;
        if(k != -1 && ((android.view.ViewGroup.LayoutParams) (layoutparams)).width != i1) {
            mLastWidth = i1;
            layoutparams.width = i1;
            flag1 = true;
        }
        if(mHeightMode < 0)
            j1 = mHeightMode;
        else
            j1 = mLastHeight;
        if(l != -1 && ((android.view.ViewGroup.LayoutParams) (layoutparams)).height != j1) {
            mLastHeight = j1;
            layoutparams.height = j1;
            flag1 = true;
        }
        if(layoutparams.x != i) {
            layoutparams.x = i;
            flag1 = true;
        }
        if(layoutparams.y != j) {
            layoutparams.y = j;
            flag1 = true;
        }
        k1 = computeAnimationResource();
        if(k1 != layoutparams.windowAnimations) {
            layoutparams.windowAnimations = k1;
            flag1 = true;
        }
        l1 = computeFlags(layoutparams.flags);
        if(l1 != layoutparams.flags) {
            layoutparams.flags = l1;
            flag1 = true;
        }
        if(flag1)
            mWindowManager.updateViewLayout(mPopupView, layoutparams);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void update(View view, int i, int j) {
        update(view, false, 0, 0, true, i, j);
    }

    public void update(View view, int i, int j, int k, int l) {
        update(view, true, i, j, true, k, l);
    }

    private static final int ABOVE_ANCHOR_STATE_SET[];
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    private boolean mAboveAnchor;
    private Drawable mAboveAnchorBackgroundDrawable;
    private boolean mAllowScrollingAnchorParent;
    private WeakReference mAnchor;
    private int mAnchorXoff;
    private int mAnchorYoff;
    private int mAnimationStyle;
    private Drawable mBackground;
    private Drawable mBelowAnchorBackgroundDrawable;
    private boolean mClipToScreen;
    private boolean mClippingEnabled;
    private View mContentView;
    private Context mContext;
    private int mDrawingLocation[];
    private boolean mFocusable;
    private int mHeight;
    private int mHeightMode;
    private boolean mIgnoreCheekPress;
    private int mInputMethodMode;
    private boolean mIsDropdown;
    private boolean mIsShowing;
    private int mLastHeight;
    private int mLastWidth;
    private boolean mLayoutInScreen;
    private boolean mLayoutInsetDecor;
    private boolean mNotTouchModal;
    private OnDismissListener mOnDismissListener;
    private android.view.ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener = new _cls1();
    private boolean mOutsideTouchable;
    private int mPopupHeight;
    private View mPopupView;
    private int mPopupWidth;
    private int mScreenLocation[];
    private int mSoftInputMode;
    private int mSplitTouchEnabled;
    private Rect mTempRect;
    private android.view.View.OnTouchListener mTouchInterceptor;
    private boolean mTouchable;
    private int mWidth;
    private int mWidthMode;
    private int mWindowLayoutType;
    private WindowManager mWindowManager;

    static  {
        int ai[] = new int[1];
        ai[0] = 0x10100aa;
        ABOVE_ANCHOR_STATE_SET = ai;
    }










}
