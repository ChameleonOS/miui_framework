// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.*;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.view.menu:
//            MenuView, IconMenuItemView, MenuBuilder, MenuItemImpl

public final class IconMenuView extends ViewGroup
    implements MenuBuilder.ItemInvoker, MenuView, Runnable {
    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {

        int bottom;
        int desiredWidth;
        int left;
        int maxNumItemsOnRow;
        int right;
        int top;

        public LayoutParams(int i, int j) {
            super(i, j);
        }

        public LayoutParams(Context context, AttributeSet attributeset) {
            super(context, attributeset);
        }
    }

    private static class SavedState extends android.view.View.BaseSavedState {

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(focusedPosition);
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
        int focusedPosition;


        private SavedState(Parcel parcel) {
            super(parcel);
            focusedPosition = parcel.readInt();
        }


        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            focusedPosition = i;
        }
    }


    public IconMenuView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mMenuBeingLongpressed = false;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.IconMenuView, 0, 0);
        mRowHeight = typedarray.getDimensionPixelSize(0, 64);
        mMaxRows = typedarray.getInt(1, 2);
        mMaxItems = typedarray.getInt(4, 6);
        mMaxItemsPerRow = typedarray.getInt(2, 3);
        mMoreIcon = typedarray.getDrawable(3);
        typedarray.recycle();
        TypedArray typedarray1 = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.MenuView, 0, 0);
        mItemBackground = typedarray1.getDrawable(5);
        mHorizontalDivider = typedarray1.getDrawable(2);
        mHorizontalDividerRects = new ArrayList();
        mVerticalDivider = typedarray1.getDrawable(3);
        mVerticalDividerRects = new ArrayList();
        mAnimations = typedarray1.getResourceId(0, 0);
        typedarray1.recycle();
        if(mHorizontalDivider != null) {
            mHorizontalDividerHeight = mHorizontalDivider.getIntrinsicHeight();
            if(mHorizontalDividerHeight == -1)
                mHorizontalDividerHeight = 1;
        }
        if(mVerticalDivider != null) {
            mVerticalDividerWidth = mVerticalDivider.getIntrinsicWidth();
            if(mVerticalDividerWidth == -1)
                mVerticalDividerWidth = 1;
        }
        mLayout = new int[mMaxRows];
        setWillNotDraw(false);
        setFocusableInTouchMode(true);
        setDescendantFocusability(0x40000);
    }

    private void calculateItemFittingMetadata(int i) {
        int j = mMaxItemsPerRow;
        int k = getChildCount();
        int l = 0;
label0:
        do {
            if(l < k) {
                LayoutParams layoutparams = (LayoutParams)getChildAt(l).getLayoutParams();
                layoutparams.maxNumItemsOnRow = 1;
                int i1 = j;
                do {
label1:
                    {
                        if(i1 > 0) {
                            if(layoutparams.desiredWidth >= i / i1)
                                break label1;
                            layoutparams.maxNumItemsOnRow = i1;
                        }
                        l++;
                        continue label0;
                    }
                    i1--;
                } while(true);
            }
            return;
        } while(true);
    }

    private boolean doItemsFit() {
        boolean flag;
        int i;
        int ai[];
        int j;
        int k;
        flag = true;
        i = 0;
        ai = mLayout;
        j = mLayoutNumRows;
        k = 0;
_L5:
        if(k >= j) goto _L2; else goto _L1
_L1:
        int l = ai[k];
        if(l != flag) goto _L4; else goto _L3
_L3:
        i++;
_L10:
        k++;
          goto _L5
_L4:
        int i1;
        int j1;
        i1 = l;
        j1 = i;
_L9:
        int k1;
        if(i1 <= 0)
            break; /* Loop/switch isn't completed */
        k1 = j1 + 1;
        if(((LayoutParams)getChildAt(j1).getLayoutParams()).maxNumItemsOnRow >= l) goto _L7; else goto _L6
_L6:
        flag = false;
_L2:
        return flag;
_L7:
        i1--;
        j1 = k1;
        if(true) goto _L9; else goto _L8
_L8:
        i = j1;
          goto _L10
    }

    private void layoutItems(int i) {
        int j = getChildCount();
        if(j != 0) goto _L2; else goto _L1
_L1:
        mLayoutNumRows = 0;
_L4:
        return;
_L2:
        int k = Math.min((int)Math.ceil((float)j / (float)mMaxItemsPerRow), mMaxRows);
_L6:
        if(k > mMaxRows) goto _L4; else goto _L3
_L3:
        layoutItemsUsingGravity(k, j);
        if(k >= j || doItemsFit()) goto _L4; else goto _L5
_L5:
        k++;
          goto _L6
    }

    private void layoutItemsUsingGravity(int i, int j) {
        int k = j / i;
        int l = i - j % i;
        int ai[] = mLayout;
        for(int i1 = 0; i1 < i; i1++) {
            ai[i1] = k;
            if(i1 >= l)
                ai[i1] = 1 + ai[i1];
        }

        mLayoutNumRows = i;
    }

    private void positionChildren(int i, int j) {
        if(mHorizontalDivider != null)
            mHorizontalDividerRects.clear();
        if(mVerticalDivider != null)
            mVerticalDividerRects.clear();
        int k = mLayoutNumRows;
        int l = k - 1;
        int ai[] = mLayout;
        int i1 = 0;
        LayoutParams layoutparams = null;
        float f = 0.0F;
        float f1 = (float)(j - mHorizontalDividerHeight * (k - 1)) / (float)k;
        for(int j1 = 0; j1 < k; j1++) {
            float f2 = 0.0F;
            float f3 = (float)(i - mVerticalDividerWidth * (-1 + ai[j1])) / (float)ai[j1];
            for(int k1 = 0; k1 < ai[j1]; k1++) {
                View view = getChildAt(i1);
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec((int)f3, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec((int)f1, 0x40000000));
                layoutparams = (LayoutParams)view.getLayoutParams();
                layoutparams.left = (int)f2;
                layoutparams.right = (int)(f2 + f3);
                layoutparams.top = (int)f;
                layoutparams.bottom = (int)(f + f1);
                float f4 = f2 + f3;
                i1++;
                if(mVerticalDivider != null)
                    mVerticalDividerRects.add(new Rect((int)f4, (int)f, (int)(f4 + (float)mVerticalDividerWidth), (int)(f + f1)));
                f2 = f4 + (float)mVerticalDividerWidth;
            }

            if(layoutparams != null)
                layoutparams.right = i;
            f += f1;
            if(mHorizontalDivider != null && j1 < l) {
                ArrayList arraylist = mHorizontalDividerRects;
                Rect rect = new Rect(0, (int)f, i, (int)(f + (float)mHorizontalDividerHeight));
                arraylist.add(rect);
                f += mHorizontalDividerHeight;
            }
        }

    }

    private void setChildrenCaptionMode(boolean flag) {
        mLastChildrenCaptionMode = flag;
        for(int i = -1 + getChildCount(); i >= 0; i--)
            ((IconMenuItemView)getChildAt(i)).setCaptionMode(flag);

    }

    private void setCycleShortcutCaptionMode(boolean flag) {
        if(!flag) {
            removeCallbacks(this);
            setChildrenCaptionMode(false);
            mMenuBeingLongpressed = false;
        } else {
            setChildrenCaptionMode(true);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return layoutparams instanceof LayoutParams;
    }

    IconMenuItemView createMoreItemView() {
        Context context = getContext();
        IconMenuItemView iconmenuitemview = (IconMenuItemView)LayoutInflater.from(context).inflate(0x1090045, null);
        iconmenuitemview.initialize(context.getResources().getText(0x1040397), mMoreIcon);
        iconmenuitemview.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view) {
                mMenu.changeMenuMode();
            }

            final IconMenuView this$0;

             {
                this$0 = IconMenuView.this;
                super();
            }
        });
        return iconmenuitemview;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent) {
        boolean flag = true;
        if(keyevent.getKeyCode() != 82) goto _L2; else goto _L1
_L1:
        if(keyevent.getAction() != 0 || keyevent.getRepeatCount() != 0) goto _L4; else goto _L3
_L3:
        removeCallbacks(this);
        postDelayed(this, ViewConfiguration.getLongPressTimeout());
_L2:
        flag = super.dispatchKeyEvent(keyevent);
_L6:
        return flag;
_L4:
        if(keyevent.getAction() != flag)
            continue; /* Loop/switch isn't completed */
        if(!mMenuBeingLongpressed)
            break; /* Loop/switch isn't completed */
        setCycleShortcutCaptionMode(false);
        if(true) goto _L6; else goto _L5
_L5:
        removeCallbacks(this);
        if(true) goto _L2; else goto _L7
_L7:
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return new LayoutParams(getContext(), attributeset);
    }

    Drawable getItemBackgroundDrawable() {
        return mItemBackground.getConstantState().newDrawable(getContext().getResources());
    }

    public int[] getLayout() {
        return mLayout;
    }

    public int getLayoutNumRows() {
        return mLayoutNumRows;
    }

    int getMaxItems() {
        return mMaxItems;
    }

    int getNumActualItemsShown() {
        return mNumActualItemsShown;
    }

    public int getWindowAnimations() {
        return mAnimations;
    }

    public void initialize(MenuBuilder menubuilder) {
        mMenu = menubuilder;
    }

    public boolean invokeItem(MenuItemImpl menuitemimpl) {
        return mMenu.performItemAction(menuitemimpl, 0);
    }

    void markStaleChildren() {
        if(!mHasStaleChildren) {
            mHasStaleChildren = true;
            requestLayout();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestFocus();
    }

    protected void onDetachedFromWindow() {
        setCycleShortcutCaptionMode(false);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        Drawable drawable = mHorizontalDivider;
        if(drawable != null) {
            ArrayList arraylist1 = mHorizontalDividerRects;
            for(int j = -1 + arraylist1.size(); j >= 0; j--) {
                drawable.setBounds((Rect)arraylist1.get(j));
                drawable.draw(canvas);
            }

        }
        Drawable drawable1 = mVerticalDivider;
        if(drawable1 != null) {
            ArrayList arraylist = mVerticalDividerRects;
            for(int i = -1 + arraylist.size(); i >= 0; i--) {
                drawable1.setBounds((Rect)arraylist.get(i));
                drawable1.draw(canvas);
            }

        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        for(int i1 = -1 + getChildCount(); i1 >= 0; i1--) {
            View view = getChildAt(i1);
            LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
            view.layout(layoutparams.left, layoutparams.top, layoutparams.right, layoutparams.bottom);
        }

    }

    protected void onMeasure(int i, int j) {
        int k = resolveSize(0x7fffffff, i);
        calculateItemFittingMetadata(k);
        layoutItems(k);
        int l = mLayoutNumRows;
        setMeasuredDimension(k, resolveSize(l * (mRowHeight + mHorizontalDividerHeight) - mHorizontalDividerHeight, j));
        if(l > 0)
            positionChildren(getMeasuredWidth(), getMeasuredHeight());
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedstate;
        savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if(savedstate.focusedPosition < getChildCount()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        View view = getChildAt(savedstate.focusedPosition);
        if(view != null)
            view.requestFocus();
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable;
        View view;
        int i;
        parcelable = super.onSaveInstanceState();
        view = getFocusedChild();
        i = -1 + getChildCount();
_L3:
        if(i < 0)
            break MISSING_BLOCK_LABEL_51;
        if(getChildAt(i) != view) goto _L2; else goto _L1
_L1:
        SavedState savedstate = new SavedState(parcelable, i);
_L4:
        return savedstate;
_L2:
        i--;
          goto _L3
        savedstate = new SavedState(parcelable, -1);
          goto _L4
    }

    public void onWindowFocusChanged(boolean flag) {
        if(!flag)
            setCycleShortcutCaptionMode(false);
        super.onWindowFocusChanged(flag);
    }

    public void run() {
        boolean flag = true;
        if(mMenuBeingLongpressed) {
            if(mLastChildrenCaptionMode)
                flag = false;
            setChildrenCaptionMode(flag);
        } else {
            mMenuBeingLongpressed = flag;
            setCycleShortcutCaptionMode(flag);
        }
        postDelayed(this, 1000L);
    }

    void setNumActualItemsShown(int i) {
        mNumActualItemsShown = i;
    }

    private static final int ITEM_CAPTION_CYCLE_DELAY = 1000;
    private int mAnimations;
    private boolean mHasStaleChildren;
    private Drawable mHorizontalDivider;
    private int mHorizontalDividerHeight;
    private ArrayList mHorizontalDividerRects;
    private Drawable mItemBackground;
    private boolean mLastChildrenCaptionMode;
    private int mLayout[];
    private int mLayoutNumRows;
    private int mMaxItems;
    private int mMaxItemsPerRow;
    private int mMaxRows;
    private MenuBuilder mMenu;
    private boolean mMenuBeingLongpressed;
    private Drawable mMoreIcon;
    private int mNumActualItemsShown;
    private int mRowHeight;
    private Drawable mVerticalDivider;
    private ArrayList mVerticalDividerRects;
    private int mVerticalDividerWidth;

}
