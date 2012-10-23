// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

// Referenced classes of package com.android.internal.view.menu:
//            MenuItemImpl, IconMenuView

public final class IconMenuItemView extends TextView
    implements MenuView.ItemView {

    public IconMenuItemView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public IconMenuItemView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset);
        mPositionIconAvailable = new Rect();
        mPositionIconOutput = new Rect();
        if(sPrependShortcutLabel == null)
            sPrependShortcutLabel = getResources().getString(0x1040398);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.MenuView, i, 0);
        mDisabledAlpha = typedarray.getFloat(6, 0.8F);
        mTextAppearance = typedarray.getResourceId(1, -1);
        mTextAppearanceContext = context;
        typedarray.recycle();
    }

    private void positionIcon() {
        if(mIcon != null) {
            Rect rect = mPositionIconOutput;
            getLineBounds(0, rect);
            mPositionIconAvailable.set(0, 0, getWidth(), rect.top);
            int i = getResolvedLayoutDirection();
            Gravity.apply(19, mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight(), mPositionIconAvailable, mPositionIconOutput, i);
            mIcon.setBounds(mPositionIconOutput);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if(mItemData != null && mIcon != null) {
            boolean flag;
            Drawable drawable;
            int i;
            if(!mItemData.isEnabled() && (isPressed() || !isFocused()))
                flag = true;
            else
                flag = false;
            drawable = mIcon;
            if(flag)
                i = (int)(255F * mDisabledAlpha);
            else
                i = 255;
            drawable.setAlpha(i);
        }
    }

    public MenuItemImpl getItemData() {
        return mItemData;
    }

    IconMenuView.LayoutParams getTextAppropriateLayoutParams() {
        IconMenuView.LayoutParams layoutparams = (IconMenuView.LayoutParams)getLayoutParams();
        if(layoutparams == null)
            layoutparams = new IconMenuView.LayoutParams(-1, -1);
        layoutparams.desiredWidth = (int)Layout.getDesiredWidth(getText(), getPaint());
        return layoutparams;
    }

    public void initialize(MenuItemImpl menuitemimpl, int i) {
        mItemData = menuitemimpl;
        initialize(menuitemimpl.getTitleForItemView(this), menuitemimpl.getIcon());
        int j;
        if(menuitemimpl.isVisible())
            j = 0;
        else
            j = 8;
        setVisibility(j);
        setEnabled(menuitemimpl.isEnabled());
    }

    void initialize(CharSequence charsequence, Drawable drawable) {
        setClickable(true);
        setFocusable(true);
        if(mTextAppearance != -1)
            setTextAppearance(mTextAppearanceContext, mTextAppearance);
        setTitle(charsequence);
        setIcon(drawable);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        super.onLayout(flag, i, j, k, l);
        positionIcon();
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k) {
        super.onTextChanged(charsequence, i, j, k);
        setLayoutParams(getTextAppropriateLayoutParams());
    }

    public boolean performClick() {
        boolean flag = true;
        if(!super.performClick())
            if(mItemInvoker != null && mItemInvoker.invokeItem(mItemData))
                playSoundEffect(0);
            else
                flag = false;
        return flag;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    void setCaptionMode(boolean flag) {
        if(mItemData != null) {
            boolean flag1;
            Object obj;
            if(flag && mItemData.shouldShowShortcut())
                flag1 = true;
            else
                flag1 = false;
            mShortcutCaptionMode = flag1;
            obj = mItemData.getTitleForItemView(this);
            if(mShortcutCaptionMode) {
                if(mShortcutCaption == null)
                    mShortcutCaption = mItemData.getShortcutLabel();
                obj = mShortcutCaption;
            }
            setText(((CharSequence) (obj)));
        }
    }

    public void setCheckable(boolean flag) {
    }

    public void setChecked(boolean flag) {
    }

    public void setIcon(Drawable drawable) {
        mIcon = drawable;
        if(drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            setCompoundDrawables(null, drawable, null, null);
            setGravity(81);
            requestLayout();
        } else {
            setCompoundDrawables(null, null, null, null);
            setGravity(17);
        }
    }

    void setIconMenuView(IconMenuView iconmenuview) {
        mIconMenuView = iconmenuview;
    }

    public void setItemData(MenuItemImpl menuitemimpl) {
        mItemData = menuitemimpl;
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker iteminvoker) {
        mItemInvoker = iteminvoker;
    }

    public void setShortcut(boolean flag, char c) {
        if(mShortcutCaptionMode) {
            mShortcutCaption = null;
            setCaptionMode(true);
        }
    }

    public void setTitle(CharSequence charsequence) {
        if(!mShortcutCaptionMode) goto _L2; else goto _L1
_L1:
        setCaptionMode(true);
_L4:
        return;
_L2:
        if(charsequence != null)
            setText(charsequence);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if(mIconMenuView != null)
            mIconMenuView.markStaleChildren();
    }

    public boolean showsIcon() {
        return true;
    }

    private static final int NO_ALPHA = 255;
    private static String sPrependShortcutLabel;
    private float mDisabledAlpha;
    private Drawable mIcon;
    private IconMenuView mIconMenuView;
    private MenuItemImpl mItemData;
    private MenuBuilder.ItemInvoker mItemInvoker;
    private Rect mPositionIconAvailable;
    private Rect mPositionIconOutput;
    private String mShortcutCaption;
    private boolean mShortcutCaptionMode;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
}
