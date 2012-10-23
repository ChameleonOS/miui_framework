// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

// Referenced classes of package com.android.internal.view.menu:
//            MenuItemImpl

public class ListMenuItemView extends LinearLayout
    implements MenuView.ItemView {

    public ListMenuItemView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.MenuView, i, 0);
        mBackground = typedarray.getDrawable(5);
        mTextAppearance = typedarray.getResourceId(1, -1);
        mPreserveIconSpacing = typedarray.getBoolean(7, false);
        mTextAppearanceContext = context;
        typedarray.recycle();
    }

    private LayoutInflater getInflater() {
        if(mInflater == null)
            mInflater = LayoutInflater.from(super.mContext);
        return mInflater;
    }

    private void insertCheckBox() {
        mCheckBox = (CheckBox)getInflater().inflate(0x1090060, this, false);
        addView(mCheckBox);
    }

    private void insertIconView() {
        mIconView = (ImageView)getInflater().inflate(0x1090061, this, false);
        addView(mIconView, 0);
    }

    private void insertRadioButton() {
        mRadioButton = (RadioButton)getInflater().inflate(0x1090063, this, false);
        addView(mRadioButton);
    }

    public MenuItemImpl getItemData() {
        return mItemData;
    }

    public void initialize(MenuItemImpl menuitemimpl, int i) {
        mItemData = menuitemimpl;
        mMenuType = i;
        int j;
        if(menuitemimpl.isVisible())
            j = 0;
        else
            j = 8;
        setVisibility(j);
        setTitle(menuitemimpl.getTitleForItemView(this));
        setCheckable(menuitemimpl.isCheckable());
        setShortcut(menuitemimpl.shouldShowShortcut(), menuitemimpl.getShortcut());
        setIcon(menuitemimpl.getIcon());
        setEnabled(menuitemimpl.isEnabled());
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(mBackground);
        mTitleView = (TextView)findViewById(0x1020016);
        if(mTextAppearance != -1)
            mTitleView.setTextAppearance(mTextAppearanceContext, mTextAppearance);
        mShortcutView = (TextView)findViewById(0x10202d2);
    }

    protected void onMeasure(int i, int j) {
        if(mIconView != null && mPreserveIconSpacing) {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            android.widget.LinearLayout.LayoutParams layoutparams1 = (android.widget.LinearLayout.LayoutParams)mIconView.getLayoutParams();
            if(layoutparams.height > 0 && ((android.view.ViewGroup.LayoutParams) (layoutparams1)).width <= 0)
                layoutparams1.width = layoutparams.height;
        }
        super.onMeasure(i, j);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean flag) {
        if(flag || mRadioButton != null || mCheckBox != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        Object obj1;
        if(mItemData.isExclusiveCheckable()) {
            if(mRadioButton == null)
                insertRadioButton();
            obj = mRadioButton;
            obj1 = mCheckBox;
        } else {
            if(mCheckBox == null)
                insertCheckBox();
            obj = mCheckBox;
            obj1 = mRadioButton;
        }
        if(flag) {
            ((CompoundButton) (obj)).setChecked(mItemData.isChecked());
            int i;
            if(flag)
                i = 0;
            else
                i = 8;
            if(((CompoundButton) (obj)).getVisibility() != i)
                ((CompoundButton) (obj)).setVisibility(i);
            if(obj1 != null && ((CompoundButton) (obj1)).getVisibility() != 8)
                ((CompoundButton) (obj1)).setVisibility(8);
        } else {
            if(mCheckBox != null)
                mCheckBox.setVisibility(8);
            if(mRadioButton != null)
                mRadioButton.setVisibility(8);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setChecked(boolean flag) {
        Object obj;
        if(mItemData.isExclusiveCheckable()) {
            if(mRadioButton == null)
                insertRadioButton();
            obj = mRadioButton;
        } else {
            if(mCheckBox == null)
                insertCheckBox();
            obj = mCheckBox;
        }
        ((CompoundButton) (obj)).setChecked(flag);
    }

    public void setForceShowIcon(boolean flag) {
        mForceShowIcon = flag;
        mPreserveIconSpacing = flag;
    }

    public void setIcon(Drawable drawable) {
        boolean flag;
        if(mItemData.shouldShowIcon() || mForceShowIcon)
            flag = true;
        else
            flag = false;
        break MISSING_BLOCK_LABEL_19;
        while(true)  {
            do
                return;
            while(!flag && !mPreserveIconSpacing || mIconView == null && drawable == null && !mPreserveIconSpacing);
            if(mIconView == null)
                insertIconView();
            if(drawable != null || mPreserveIconSpacing) {
                ImageView imageview = mIconView;
                if(!flag)
                    drawable = null;
                imageview.setImageDrawable(drawable);
                if(mIconView.getVisibility() != 0)
                    mIconView.setVisibility(0);
            } else {
                mIconView.setVisibility(8);
            }
        }
    }

    public void setShortcut(boolean flag, char c) {
        int i;
        if(flag && mItemData.shouldShowShortcut())
            i = 0;
        else
            i = 8;
        if(i == 0)
            mShortcutView.setText(mItemData.getShortcutLabel());
        if(mShortcutView.getVisibility() != i)
            mShortcutView.setVisibility(i);
    }

    public void setTitle(CharSequence charsequence) {
        if(charsequence == null) goto _L2; else goto _L1
_L1:
        mTitleView.setText(charsequence);
        if(mTitleView.getVisibility() != 0)
            mTitleView.setVisibility(0);
_L4:
        return;
_L2:
        if(mTitleView.getVisibility() != 8)
            mTitleView.setVisibility(8);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean showsIcon() {
        return mForceShowIcon;
    }

    private static final String TAG = "ListMenuItemView";
    private Drawable mBackground;
    private CheckBox mCheckBox;
    private boolean mForceShowIcon;
    private ImageView mIconView;
    private LayoutInflater mInflater;
    private MenuItemImpl mItemData;
    private int mMenuType;
    private boolean mPreserveIconSpacing;
    private RadioButton mRadioButton;
    private TextView mShortcutView;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
    private TextView mTitleView;
}
