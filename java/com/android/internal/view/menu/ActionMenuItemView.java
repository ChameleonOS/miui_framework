// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

// Referenced classes of package com.android.internal.view.menu:
//            MenuItemImpl

public class ActionMenuItemView extends TextView
    implements MenuView.ItemView, android.view.View.OnClickListener, android.view.View.OnLongClickListener, ActionMenuView.ActionMenuChildView {

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mAllowTextWithIcon = context.getResources().getBoolean(0x1110036);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.ActionMenuItemView, 0, 0);
        mMinWidth = typedarray.getDimensionPixelSize(0, 0);
        typedarray.recycle();
        setOnClickListener(this);
        setOnLongClickListener(this);
        mSavedPaddingLeft = -1;
    }

    private void updateTextButtonVisibility() {
        boolean flag = false;
        boolean flag1;
        CharSequence charsequence;
        if(!TextUtils.isEmpty(mTitle))
            flag1 = true;
        else
            flag1 = false;
        if(mIcon == null || mItemData.isForceShowText() || mItemData.showsTextAsAction() && (mAllowTextWithIcon || mExpandedFormat))
            flag = true;
        if(flag1 & flag)
            charsequence = mTitle;
        else
            charsequence = null;
        setText(charsequence);
    }

    public boolean dispatchHoverEvent(MotionEvent motionevent) {
        return onHoverEvent(motionevent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        onPopulateAccessibilityEvent(accessibilityevent);
        return true;
    }

    public MenuItemImpl getItemData() {
        return mItemData;
    }

    public boolean hasText() {
        boolean flag;
        if(!TextUtils.isEmpty(getText()))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void initialize(MenuItemImpl menuitemimpl, int i) {
        mItemData = menuitemimpl;
        setIcon(menuitemimpl.getIcon());
        setTitle(menuitemimpl.getTitleForItemView(this));
        setId(menuitemimpl.getItemId());
        int j;
        if(menuitemimpl.isVisible())
            j = 0;
        else
            j = 8;
        setVisibility(j);
        setEnabled(menuitemimpl.isEnabled());
    }

    public boolean needsDividerAfter() {
        return hasText();
    }

    public boolean needsDividerBefore() {
        boolean flag;
        if(hasText() && mItemData.getIcon() == null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void onClick(View view) {
        if(mItemInvoker != null)
            mItemInvoker.invokeItem(mItemData);
    }

    public boolean onLongClick(View view) {
        boolean flag = false;
        if(!hasText()) {
            int ai[] = new int[2];
            Rect rect = new Rect();
            getLocationOnScreen(ai);
            getWindowVisibleDisplayFrame(rect);
            Context context = getContext();
            int i = getWidth();
            int j = getHeight();
            int k = ai[1] + j / 2;
            int l = context.getResources().getDisplayMetrics().widthPixels;
            Toast toast = Toast.makeText(context, mItemData.getTitle(), 0);
            if(k < rect.height())
                toast.setGravity(53, l - ai[0] - i / 2, j);
            else
                toast.setGravity(81, 0, j);
            toast.show();
            flag = true;
        }
        return flag;
    }

    protected void onMeasure(int i, int j) {
        if(mSavedPaddingLeft >= 0)
            super.setPadding(mSavedPaddingLeft, getPaddingTop(), mSavedPaddingRight, getPaddingBottom());
        super.onMeasure(0, j);
        if(android.view.View.MeasureSpec.getMode(i) != 0) {
            int k = getMeasuredWidth();
            super.onMeasure(i, j);
            if(!hasText() && mIcon != null) {
                super.setPadding((getMeasuredWidth() - mIcon.getIntrinsicWidth()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            } else {
                int l = (getMeasuredWidth() - k) / 2;
                super.setPadding(l + super.mPaddingLeft, super.mPaddingTop, l + super.mPaddingRight, super.mPaddingBottom);
                super.onMeasure(i, j);
            }
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onPopulateAccessibilityEvent(accessibilityevent);
        CharSequence charsequence = getContentDescription();
        if(!TextUtils.isEmpty(charsequence))
            accessibilityevent.getText().add(charsequence);
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean flag) {
    }

    public void setChecked(boolean flag) {
    }

    public void setExpandedFormat(boolean flag) {
        if(mExpandedFormat != flag) {
            mExpandedFormat = flag;
            if(mItemData != null)
                mItemData.actionFormatChanged();
        }
    }

    public void setIcon(Drawable drawable) {
        mIcon = drawable;
        setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        updateTextButtonVisibility();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker iteminvoker) {
        mItemInvoker = iteminvoker;
    }

    public void setPadding(int i, int j, int k, int l) {
        mSavedPaddingLeft = i;
        mSavedPaddingRight = k;
        super.setPadding(i, j, k, l);
    }

    public void setShortcut(boolean flag, char c) {
    }

    public void setTitle(CharSequence charsequence) {
        mTitle = charsequence;
        setContentDescription(mTitle);
        updateTextButtonVisibility();
    }

    public boolean showsIcon() {
        return true;
    }

    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private Drawable mIcon;
    private MenuItemImpl mItemData;
    private MenuBuilder.ItemInvoker mItemInvoker;
    private int mMinWidth;
    private int mSavedPaddingLeft;
    private int mSavedPaddingRight;
    private CharSequence mTitle;
}
