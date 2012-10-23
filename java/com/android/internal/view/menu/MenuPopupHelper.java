// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.*;
import android.widget.*;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.view.menu:
//            MenuPresenter, MenuBuilder, SubMenuBuilder, MenuItemImpl, 
//            MenuView, ListMenuItemView

public class MenuPopupHelper
    implements android.widget.AdapterView.OnItemClickListener, android.view.View.OnKeyListener, android.view.ViewTreeObserver.OnGlobalLayoutListener, android.widget.PopupWindow.OnDismissListener, android.view.View.OnAttachStateChangeListener, MenuPresenter {
    private class MenuAdapter extends BaseAdapter {

        void findExpandedIndex() {
            MenuItemImpl menuitemimpl;
            ArrayList arraylist;
            int i;
            int j;
            menuitemimpl = mMenu.getExpandedItem();
            if(menuitemimpl == null)
                break MISSING_BLOCK_LABEL_66;
            arraylist = mMenu.getNonActionItems();
            i = arraylist.size();
            j = 0;
_L3:
            if(j >= i)
                break MISSING_BLOCK_LABEL_66;
            if((MenuItemImpl)arraylist.get(j) != menuitemimpl) goto _L2; else goto _L1
_L1:
            mExpandedIndex = j;
_L4:
            return;
_L2:
            j++;
              goto _L3
            mExpandedIndex = -1;
              goto _L4
        }

        public int getCount() {
            ArrayList arraylist;
            int i;
            if(mOverflowOnly)
                arraylist = mAdapterMenu.getNonActionItems();
            else
                arraylist = mAdapterMenu.getVisibleItems();
            if(mExpandedIndex < 0)
                i = arraylist.size();
            else
                i = -1 + arraylist.size();
            return i;
        }

        public MenuItemImpl getItem(int i) {
            ArrayList arraylist;
            if(mOverflowOnly)
                arraylist = mAdapterMenu.getNonActionItems();
            else
                arraylist = mAdapterMenu.getVisibleItems();
            if(mExpandedIndex >= 0 && i >= mExpandedIndex)
                i++;
            return (MenuItemImpl)arraylist.get(i);
        }

        public volatile Object getItem(int i) {
            return getItem(i);
        }

        public long getItemId(int i) {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            if(view == null)
                view = mInflater.inflate(0x109007c, viewgroup, false);
            MenuView.ItemView itemview = (MenuView.ItemView)view;
            if(mForceShowIcon)
                ((ListMenuItemView)view).setForceShowIcon(true);
            itemview.initialize(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            findExpandedIndex();
            super.notifyDataSetChanged();
        }

        private MenuBuilder mAdapterMenu;
        private int mExpandedIndex;
        final MenuPopupHelper this$0;


        public MenuAdapter(MenuBuilder menubuilder) {
            this$0 = MenuPopupHelper.this;
            super();
            mExpandedIndex = -1;
            mAdapterMenu = menubuilder;
            findExpandedIndex();
        }
    }


    public MenuPopupHelper(Context context, MenuBuilder menubuilder) {
        this(context, menubuilder, null, false);
    }

    public MenuPopupHelper(Context context, MenuBuilder menubuilder, View view) {
        this(context, menubuilder, view, false);
    }

    public MenuPopupHelper(Context context, MenuBuilder menubuilder, View view, boolean flag) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mMenu = menubuilder;
        mOverflowOnly = flag;
        Resources resources = context.getResources();
        mPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(0x1050007));
        mAnchorView = view;
        menubuilder.addMenuPresenter(this);
    }

    private int measureContentWidth(ListAdapter listadapter) {
        int i = 0;
        View view = null;
        int j = 0;
        int k = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int l = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        int i1 = listadapter.getCount();
        for(int j1 = 0; j1 < i1; j1++) {
            int k1 = listadapter.getItemViewType(j1);
            if(k1 != j) {
                j = k1;
                view = null;
            }
            if(mMeasureParent == null)
                mMeasureParent = new FrameLayout(mContext);
            view = listadapter.getView(j1, view, mMeasureParent);
            view.measure(k, l);
            i = Math.max(i, view.getMeasuredWidth());
        }

        return i;
    }

    public boolean collapseItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl) {
        return false;
    }

    public void dismiss() {
        if(isShowing())
            mPopup.dismiss();
    }

    public boolean expandItemActionView(MenuBuilder menubuilder, MenuItemImpl menuitemimpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return 0;
    }

    public MenuView getMenuView(ViewGroup viewgroup) {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    public void initForMenu(Context context, MenuBuilder menubuilder) {
    }

    public boolean isShowing() {
        boolean flag;
        if(mPopup != null && mPopup.isShowing())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void onCloseMenu(MenuBuilder menubuilder, boolean flag) {
        if(menubuilder == mMenu) goto _L2; else goto _L1
_L1:
        return;
_L2:
        dismiss();
        if(mPresenterCallback != null)
            mPresenterCallback.onCloseMenu(menubuilder, flag);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void onDismiss() {
        mPopup = null;
        mMenu.close();
        if(mTreeObserver != null) {
            if(!mTreeObserver.isAlive())
                mTreeObserver = mAnchorView.getViewTreeObserver();
            mTreeObserver.removeGlobalOnLayoutListener(this);
            mTreeObserver = null;
        }
        mAnchorView.removeOnAttachStateChangeListener(this);
    }

    public void onGlobalLayout() {
        if(!isShowing()) goto _L2; else goto _L1
_L1:
        View view = mAnchorView;
        if(view != null && view.isShown()) goto _L4; else goto _L3
_L3:
        dismiss();
_L2:
        return;
_L4:
        if(isShowing())
            mPopup.show();
        if(true) goto _L2; else goto _L5
_L5:
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l) {
        MenuAdapter menuadapter = mAdapter;
        menuadapter.mAdapterMenu.performItemAction(menuadapter.getItem(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyevent) {
        boolean flag = true;
        if(keyevent.getAction() == flag && i == 82)
            dismiss();
        else
            flag = false;
        return flag;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder submenubuilder) {
        boolean flag = false;
        if(!submenubuilder.hasVisibleItems()) goto _L2; else goto _L1
_L1:
        MenuPopupHelper menupopuphelper;
        boolean flag1;
        int i;
        int j;
        menupopuphelper = new MenuPopupHelper(mContext, submenubuilder, mAnchorView, false);
        menupopuphelper.setCallback(mPresenterCallback);
        flag1 = false;
        i = submenubuilder.size();
        j = 0;
_L8:
        if(j >= i) goto _L4; else goto _L3
_L3:
        MenuItem menuitem = submenubuilder.getItem(j);
        if(!menuitem.isVisible() || menuitem.getIcon() == null) goto _L6; else goto _L5
_L5:
        flag1 = true;
_L4:
        menupopuphelper.setForceShowIcon(flag1);
        if(menupopuphelper.tryShow()) {
            if(mPresenterCallback != null)
                mPresenterCallback.onOpenSubMenu(submenubuilder);
            flag = true;
        }
_L2:
        return flag;
_L6:
        j++;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        if(mTreeObserver != null) {
            if(!mTreeObserver.isAlive())
                mTreeObserver = view.getViewTreeObserver();
            mTreeObserver.removeGlobalOnLayoutListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
    }

    public void setAnchorView(View view) {
        mAnchorView = view;
    }

    public void setCallback(MenuPresenter.Callback callback) {
        mPresenterCallback = callback;
    }

    public void setForceShowIcon(boolean flag) {
        mForceShowIcon = flag;
    }

    public void show() {
        if(!tryShow())
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        else
            return;
    }

    public boolean tryShow() {
        boolean flag = false;
        boolean flag1 = true;
        mPopup = new ListPopupWindow(mContext, null, 0x1010300);
        mPopup.setOnDismissListener(this);
        mPopup.setOnItemClickListener(this);
        mAdapter = new MenuAdapter(mMenu);
        mPopup.setAdapter(mAdapter);
        mPopup.setModal(flag1);
        View view = mAnchorView;
        if(view != null) {
            if(mTreeObserver == null)
                flag = flag1;
            mTreeObserver = view.getViewTreeObserver();
            if(flag)
                mTreeObserver.addOnGlobalLayoutListener(this);
            view.addOnAttachStateChangeListener(this);
            mPopup.setAnchorView(view);
            mPopup.setContentWidth(Math.min(measureContentWidth(mAdapter), mPopupMaxWidth));
            mPopup.setInputMethodMode(2);
            mPopup.show();
            mPopup.getListView().setOnKeyListener(this);
        } else {
            flag1 = false;
        }
        return flag1;
    }

    public void updateMenuView(boolean flag) {
        if(mAdapter != null)
            mAdapter.notifyDataSetChanged();
    }

    static final int ITEM_LAYOUT = 0x109007c;
    private static final String TAG = "MenuPopupHelper";
    private MenuAdapter mAdapter;
    private View mAnchorView;
    private Context mContext;
    boolean mForceShowIcon;
    private LayoutInflater mInflater;
    private ViewGroup mMeasureParent;
    private MenuBuilder mMenu;
    private boolean mOverflowOnly;
    private ListPopupWindow mPopup;
    private int mPopupMaxWidth;
    private MenuPresenter.Callback mPresenterCallback;
    private ViewTreeObserver mTreeObserver;



}
