// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.*;

// Referenced classes of package com.android.internal.view.menu:
//            MenuView, MenuBuilder, MenuItemImpl

public final class ExpandedMenuView extends ListView
    implements MenuBuilder.ItemInvoker, MenuView, android.widget.AdapterView.OnItemClickListener {

    public ExpandedMenuView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.MenuView, 0, 0);
        mAnimations = typedarray.getResourceId(0, 0);
        typedarray.recycle();
        setOnItemClickListener(this);
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

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l) {
        invokeItem((MenuItemImpl)getAdapter().getItem(i));
    }

    private int mAnimations;
    private MenuBuilder mMenu;
}
