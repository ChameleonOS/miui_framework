// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.*;
import android.content.pm.*;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.*;
import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.android.internal.view.menu:
//            MenuItemImpl, MenuPresenter, SubMenuBuilder

public class MenuBuilder
    implements Menu {
    public static interface ItemInvoker {

        public abstract boolean invokeItem(MenuItemImpl menuitemimpl);
    }

    public static interface Callback {

        public abstract boolean onMenuItemSelected(MenuBuilder menubuilder, MenuItem menuitem);

        public abstract void onMenuModeChange(MenuBuilder menubuilder);
    }


    public MenuBuilder(Context context) {
        mDefaultShowAsAction = 0;
        mPreventDispatchingItemsChanged = false;
        mItemsChangedWhileDispatchPrevented = false;
        mOptionalIconsVisible = false;
        mIsClosing = false;
        mTempShortcutItemList = new ArrayList();
        mPresenters = new CopyOnWriteArrayList();
        mContext = context;
        mResources = context.getResources();
        mItems = new ArrayList();
        mVisibleItems = new ArrayList();
        mIsVisibleItemsStale = true;
        mActionItems = new ArrayList();
        mNonActionItems = new ArrayList();
        mIsActionItemsStale = true;
        setShortcutsVisibleInner(true);
    }

    private MenuItem addInternal(int i, int j, int k, CharSequence charsequence) {
        int l = getOrdering(k);
        MenuItemImpl menuitemimpl = new MenuItemImpl(this, i, j, k, l, charsequence, mDefaultShowAsAction);
        if(mCurrentMenuInfo != null)
            menuitemimpl.setMenuInfo(mCurrentMenuInfo);
        mItems.add(findInsertIndex(mItems, l), menuitemimpl);
        onItemsChanged(true);
        return menuitemimpl;
    }

    private void dispatchPresenterUpdate(boolean flag) {
        if(!mPresenters.isEmpty()) {
            stopDispatchingItemsChanged();
            for(Iterator iterator = mPresenters.iterator(); iterator.hasNext();) {
                WeakReference weakreference = (WeakReference)iterator.next();
                MenuPresenter menupresenter = (MenuPresenter)weakreference.get();
                if(menupresenter == null)
                    mPresenters.remove(weakreference);
                else
                    menupresenter.updateMenuView(flag);
            }

            startDispatchingItemsChanged();
        }
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        SparseArray sparsearray = bundle.getSparseParcelableArray("android:menu:presenters");
        if(sparsearray != null && !mPresenters.isEmpty()) {
            Iterator iterator = mPresenters.iterator();
            while(iterator.hasNext())  {
                WeakReference weakreference = (WeakReference)iterator.next();
                MenuPresenter menupresenter = (MenuPresenter)weakreference.get();
                if(menupresenter == null) {
                    mPresenters.remove(weakreference);
                } else {
                    int i = menupresenter.getId();
                    if(i > 0) {
                        Parcelable parcelable = (Parcelable)sparsearray.get(i);
                        if(parcelable != null)
                            menupresenter.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        if(!mPresenters.isEmpty()) {
            SparseArray sparsearray = new SparseArray();
            Iterator iterator = mPresenters.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                WeakReference weakreference = (WeakReference)iterator.next();
                MenuPresenter menupresenter = (MenuPresenter)weakreference.get();
                if(menupresenter == null) {
                    mPresenters.remove(weakreference);
                } else {
                    int i = menupresenter.getId();
                    if(i > 0) {
                        Parcelable parcelable = menupresenter.onSaveInstanceState();
                        if(parcelable != null)
                            sparsearray.put(i, parcelable);
                    }
                }
            } while(true);
            bundle.putSparseParcelableArray("android:menu:presenters", sparsearray);
        }
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder submenubuilder) {
        boolean flag;
        if(mPresenters.isEmpty()) {
            flag = false;
        } else {
            flag = false;
            Iterator iterator = mPresenters.iterator();
            while(iterator.hasNext())  {
                WeakReference weakreference = (WeakReference)iterator.next();
                MenuPresenter menupresenter = (MenuPresenter)weakreference.get();
                if(menupresenter == null)
                    mPresenters.remove(weakreference);
                else
                if(!flag)
                    flag = menupresenter.onSubMenuSelected(submenubuilder);
            }
        }
        return flag;
    }

    private static int findInsertIndex(ArrayList arraylist, int i) {
        int j = -1 + arraylist.size();
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_39;
        if(((MenuItemImpl)arraylist.get(j)).getOrdering() > i) goto _L2; else goto _L1
_L1:
        int k = j + 1;
_L4:
        return k;
_L2:
        j--;
          goto _L3
        k = 0;
          goto _L4
    }

    private static int getOrdering(int i) {
        int j = (0xffff0000 & i) >> 16;
        if(j < 0 || j >= sCategoryToOrder.length)
            throw new IllegalArgumentException("order does not contain a valid category.");
        else
            return sCategoryToOrder[j] << 16 | 0xffff & i;
    }

    private void removeItemAtInt(int i, boolean flag) {
        if(i >= 0 && i < mItems.size()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mItems.remove(i);
        if(flag)
            onItemsChanged(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void setHeaderInternal(int i, CharSequence charsequence, int j, Drawable drawable, View view) {
        Resources resources = getResources();
        if(view == null) goto _L2; else goto _L1
_L1:
        mHeaderView = view;
        mHeaderTitle = null;
        mHeaderIcon = null;
_L4:
        onItemsChanged(false);
        return;
_L2:
        if(i > 0)
            mHeaderTitle = resources.getText(i);
        else
        if(charsequence != null)
            mHeaderTitle = charsequence;
        if(j <= 0)
            break; /* Loop/switch isn't completed */
        mHeaderIcon = resources.getDrawable(j);
_L6:
        mHeaderView = null;
        if(true) goto _L4; else goto _L3
_L3:
        if(drawable == null) goto _L6; else goto _L5
_L5:
        mHeaderIcon = drawable;
          goto _L6
    }

    private void setShortcutsVisibleInner(boolean flag) {
        boolean flag1 = true;
        if(!flag || mResources.getConfiguration().keyboard == flag1 || !mResources.getBoolean(0x111002e))
            flag1 = false;
        mShortcutsVisible = flag1;
    }

    public MenuItem add(int i) {
        return addInternal(0, 0, 0, mResources.getString(i));
    }

    public MenuItem add(int i, int j, int k, int l) {
        return addInternal(i, j, k, mResources.getString(l));
    }

    public MenuItem add(int i, int j, int k, CharSequence charsequence) {
        return addInternal(i, j, k, charsequence);
    }

    public MenuItem add(CharSequence charsequence) {
        return addInternal(0, 0, 0, charsequence);
    }

    public int addIntentOptions(int i, int j, int k, ComponentName componentname, Intent aintent[], Intent intent, int l, 
            MenuItem amenuitem[]) {
        PackageManager packagemanager = mContext.getPackageManager();
        List list = packagemanager.queryIntentActivityOptions(componentname, aintent, intent, 0);
        int i1;
        int j1;
        if(list != null)
            i1 = list.size();
        else
            i1 = 0;
        if((l & 1) == 0)
            removeGroup(i);
        j1 = 0;
        while(j1 < i1)  {
            ResolveInfo resolveinfo = (ResolveInfo)list.get(j1);
            Intent intent1;
            Intent intent2;
            MenuItem menuitem;
            if(resolveinfo.specificIndex < 0)
                intent1 = intent;
            else
                intent1 = aintent[resolveinfo.specificIndex];
            intent2 = new Intent(intent1);
            intent2.setComponent(new ComponentName(((PackageItemInfo) (((ComponentInfo) (resolveinfo.activityInfo)).applicationInfo)).packageName, ((PackageItemInfo) (resolveinfo.activityInfo)).name));
            menuitem = add(i, j, k, resolveinfo.loadLabel(packagemanager)).setIcon(resolveinfo.loadIcon(packagemanager)).setIntent(intent2);
            if(amenuitem != null && resolveinfo.specificIndex >= 0)
                amenuitem[resolveinfo.specificIndex] = menuitem;
            j1++;
        }
        return i1;
    }

    public void addMenuPresenter(MenuPresenter menupresenter) {
        mPresenters.add(new WeakReference(menupresenter));
        menupresenter.initForMenu(mContext, this);
        mIsActionItemsStale = true;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, ((CharSequence) (mResources.getString(i))));
    }

    public SubMenu addSubMenu(int i, int j, int k, int l) {
        return addSubMenu(i, j, k, ((CharSequence) (mResources.getString(l))));
    }

    public SubMenu addSubMenu(int i, int j, int k, CharSequence charsequence) {
        MenuItemImpl menuitemimpl = (MenuItemImpl)addInternal(i, j, k, charsequence);
        SubMenuBuilder submenubuilder = new SubMenuBuilder(mContext, this, menuitemimpl);
        menuitemimpl.setSubMenu(submenubuilder);
        return submenubuilder;
    }

    public SubMenu addSubMenu(CharSequence charsequence) {
        return addSubMenu(0, 0, 0, charsequence);
    }

    public void changeMenuMode() {
        if(mCallback != null)
            mCallback.onMenuModeChange(this);
    }

    public void clear() {
        if(mExpandedItem != null)
            collapseItemActionView(mExpandedItem);
        mItems.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        mPreventDispatchingItemsChanged = false;
        mItemsChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        mHeaderIcon = null;
        mHeaderTitle = null;
        mHeaderView = null;
        onItemsChanged(false);
    }

    public void close() {
        close(true);
    }

    final void close(boolean flag) {
        if(!mIsClosing) {
            mIsClosing = true;
            for(Iterator iterator = mPresenters.iterator(); iterator.hasNext();) {
                WeakReference weakreference = (WeakReference)iterator.next();
                MenuPresenter menupresenter = (MenuPresenter)weakreference.get();
                if(menupresenter == null)
                    mPresenters.remove(weakreference);
                else
                    menupresenter.onCloseMenu(this, flag);
            }

            mIsClosing = false;
        }
    }

    public boolean collapseItemActionView(MenuItemImpl menuitemimpl) {
        if(!mPresenters.isEmpty() && mExpandedItem == menuitemimpl) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = false;
        stopDispatchingItemsChanged();
        Iterator iterator = mPresenters.iterator();
label0:
        do {
            MenuPresenter menupresenter;
            do {
                if(!iterator.hasNext())
                    break label0;
                WeakReference weakreference = (WeakReference)iterator.next();
                menupresenter = (MenuPresenter)weakreference.get();
                if(menupresenter != null)
                    break;
                mPresenters.remove(weakreference);
            } while(true);
            flag = menupresenter.collapseItemActionView(this, menuitemimpl);
        } while(!flag);
        startDispatchingItemsChanged();
        if(flag)
            mExpandedItem = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    boolean dispatchMenuItemSelected(MenuBuilder menubuilder, MenuItem menuitem) {
        boolean flag;
        if(mCallback != null && mCallback.onMenuItemSelected(menubuilder, menuitem))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean expandItemActionView(MenuItemImpl menuitemimpl) {
        if(!mPresenters.isEmpty()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = false;
        stopDispatchingItemsChanged();
        Iterator iterator = mPresenters.iterator();
label0:
        do {
            MenuPresenter menupresenter;
            do {
                if(!iterator.hasNext())
                    break label0;
                WeakReference weakreference = (WeakReference)iterator.next();
                menupresenter = (MenuPresenter)weakreference.get();
                if(menupresenter != null)
                    break;
                mPresenters.remove(weakreference);
            } while(true);
            flag = menupresenter.expandItemActionView(this, menuitemimpl);
        } while(!flag);
        startDispatchingItemsChanged();
        if(flag)
            mExpandedItem = menuitemimpl;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int findGroupIndex(int i) {
        return findGroupIndex(i, 0);
    }

    public int findGroupIndex(int i, int j) {
        int k;
        int l;
        k = size();
        if(j < 0)
            j = 0;
        l = j;
_L3:
        if(l >= k)
            break MISSING_BLOCK_LABEL_48;
        if(((MenuItemImpl)mItems.get(l)).getGroupId() != i) goto _L2; else goto _L1
_L1:
        return l;
_L2:
        l++;
          goto _L3
        l = -1;
          goto _L1
    }

    public MenuItem findItem(int i) {
        int j;
        int k;
        j = size();
        k = 0;
_L3:
        if(k >= j) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = (MenuItemImpl)mItems.get(k);
        if(((MenuItemImpl) (obj)).getItemId() != i) {
            if(!((MenuItemImpl) (obj)).hasSubMenu())
                continue; /* Loop/switch isn't completed */
            MenuItem menuitem = ((MenuItemImpl) (obj)).getSubMenu().findItem(i);
            if(menuitem == null)
                continue; /* Loop/switch isn't completed */
            obj = menuitem;
        }
_L4:
        return ((MenuItem) (obj));
        k++;
          goto _L3
_L2:
        obj = null;
          goto _L4
    }

    public int findItemIndex(int i) {
        int j;
        int k;
        j = size();
        k = 0;
_L3:
        if(k >= j)
            break MISSING_BLOCK_LABEL_38;
        if(((MenuItemImpl)mItems.get(k)).getItemId() != i) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        k++;
          goto _L3
        k = -1;
          goto _L1
    }

    MenuItemImpl findItemWithShortcutForKey(int i, KeyEvent keyevent) {
        MenuItemImpl menuitemimpl;
        ArrayList arraylist;
        menuitemimpl = null;
        arraylist = mTempShortcutItemList;
        arraylist.clear();
        findItemsWithShortcutForKey(arraylist, i, keyevent);
        if(!arraylist.isEmpty()) goto _L2; else goto _L1
_L1:
        return menuitemimpl;
_L2:
        int j;
        android.view.KeyCharacterMap.KeyData keydata;
        int k;
        boolean flag;
        int l;
        j = keyevent.getMetaState();
        keydata = new android.view.KeyCharacterMap.KeyData();
        keyevent.getKeyData(keydata);
        k = arraylist.size();
        if(k == 1) {
            menuitemimpl = (MenuItemImpl)arraylist.get(0);
            continue; /* Loop/switch isn't completed */
        }
        flag = isQwertyMode();
        l = 0;
_L4:
        if(l < k) {
label0:
            {
                MenuItemImpl menuitemimpl1 = (MenuItemImpl)arraylist.get(l);
                char c;
                if(flag)
                    c = menuitemimpl1.getAlphabeticShortcut();
                else
                    c = menuitemimpl1.getNumericShortcut();
                if((c != keydata.meta[0] || (j & 2) != 0) && (c != keydata.meta[2] || (j & 2) == 0) && (!flag || c != '\b' || i != 67))
                    break label0;
                menuitemimpl = menuitemimpl1;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
        l++;
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    void findItemsWithShortcutForKey(List list, int i, KeyEvent keyevent) {
        boolean flag = isQwertyMode();
        int j = keyevent.getMetaState();
        android.view.KeyCharacterMap.KeyData keydata = new android.view.KeyCharacterMap.KeyData();
        if(keyevent.getKeyData(keydata) || i == 67) {
            int k = mItems.size();
            int l = 0;
            while(l < k)  {
                MenuItemImpl menuitemimpl = (MenuItemImpl)mItems.get(l);
                if(menuitemimpl.hasSubMenu())
                    ((MenuBuilder)menuitemimpl.getSubMenu()).findItemsWithShortcutForKey(list, i, keyevent);
                char c;
                if(flag)
                    c = menuitemimpl.getAlphabeticShortcut();
                else
                    c = menuitemimpl.getNumericShortcut();
                if((j & 5) == 0 && c != 0 && (c == keydata.meta[0] || c == keydata.meta[2] || flag && c == '\b' && i == 67) && menuitemimpl.isEnabled())
                    list.add(menuitemimpl);
                l++;
            }
        }
    }

    public void flagActionItems() {
        if(mIsActionItemsStale) {
            boolean flag = false;
            for(Iterator iterator = mPresenters.iterator(); iterator.hasNext();) {
                WeakReference weakreference = (WeakReference)iterator.next();
                MenuPresenter menupresenter = (MenuPresenter)weakreference.get();
                if(menupresenter == null)
                    mPresenters.remove(weakreference);
                else
                    flag |= menupresenter.flagActionItems();
            }

            if(flag) {
                mActionItems.clear();
                mNonActionItems.clear();
                ArrayList arraylist = getVisibleItems();
                int i = arraylist.size();
                int j = 0;
                while(j < i)  {
                    MenuItemImpl menuitemimpl = (MenuItemImpl)arraylist.get(j);
                    if(menuitemimpl.isActionButton())
                        mActionItems.add(menuitemimpl);
                    else
                        mNonActionItems.add(menuitemimpl);
                    j++;
                }
            } else {
                mActionItems.clear();
                mNonActionItems.clear();
                mNonActionItems.addAll(getVisibleItems());
            }
            mIsActionItemsStale = false;
        }
    }

    ArrayList getActionItems() {
        flagActionItems();
        return mActionItems;
    }

    protected String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    public Context getContext() {
        return mContext;
    }

    public MenuItemImpl getExpandedItem() {
        return mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return mHeaderTitle;
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    public MenuItem getItem(int i) {
        return (MenuItem)mItems.get(i);
    }

    ArrayList getNonActionItems() {
        flagActionItems();
        return mNonActionItems;
    }

    boolean getOptionalIconsVisible() {
        return mOptionalIconsVisible;
    }

    Resources getResources() {
        return mResources;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    ArrayList getVisibleItems() {
        ArrayList arraylist;
        if(!mIsVisibleItemsStale) {
            arraylist = mVisibleItems;
        } else {
            mVisibleItems.clear();
            int i = mItems.size();
            for(int j = 0; j < i; j++) {
                MenuItemImpl menuitemimpl = (MenuItemImpl)mItems.get(j);
                if(menuitemimpl.isVisible())
                    mVisibleItems.add(menuitemimpl);
            }

            mIsVisibleItemsStale = false;
            mIsActionItemsStale = true;
            arraylist = mVisibleItems;
        }
        return arraylist;
    }

    public boolean hasVisibleItems() {
        int i;
        int j;
        i = size();
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_39;
        if(!((MenuItemImpl)mItems.get(j)).isVisible()) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j++;
          goto _L3
        flag = false;
          goto _L4
    }

    boolean isQwertyMode() {
        return mQwertyMode;
    }

    public boolean isShortcutKey(int i, KeyEvent keyevent) {
        boolean flag;
        if(findItemWithShortcutForKey(i, keyevent) != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isShortcutsVisible() {
        return mShortcutsVisible;
    }

    void onItemActionRequestChanged(MenuItemImpl menuitemimpl) {
        mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    void onItemVisibleChanged(MenuItemImpl menuitemimpl) {
        mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    void onItemsChanged(boolean flag) {
        if(!mPreventDispatchingItemsChanged) {
            if(flag) {
                mIsVisibleItemsStale = true;
                mIsActionItemsStale = true;
            }
            dispatchPresenterUpdate(flag);
        } else {
            mItemsChangedWhileDispatchPrevented = true;
        }
    }

    public boolean performIdentifierAction(int i, int j) {
        return performItemAction(findItem(i), j);
    }

    public boolean performItemAction(MenuItem menuitem, int i) {
        MenuItemImpl menuitemimpl = (MenuItemImpl)menuitem;
        if(menuitemimpl != null && menuitemimpl.isEnabled()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = menuitemimpl.invoke();
        ActionProvider actionprovider = menuitem.getActionProvider();
        boolean flag1;
        if(actionprovider != null && actionprovider.hasSubMenu())
            flag1 = true;
        else
            flag1 = false;
        if(menuitemimpl.hasCollapsibleActionView()) {
            flag |= menuitemimpl.expandActionView();
            if(flag)
                close(true);
        } else
        if(menuitemimpl.hasSubMenu() || flag1) {
            close(false);
            if(!menuitemimpl.hasSubMenu())
                menuitemimpl.setSubMenu(new SubMenuBuilder(getContext(), this, menuitemimpl));
            SubMenuBuilder submenubuilder = (SubMenuBuilder)menuitemimpl.getSubMenu();
            if(flag1)
                actionprovider.onPrepareSubMenu(submenubuilder);
            flag |= dispatchSubMenuSelected(submenubuilder);
            if(!flag)
                close(true);
        } else
        if((i & 1) == 0)
            close(true);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean performShortcut(int i, KeyEvent keyevent, int j) {
        MenuItemImpl menuitemimpl = findItemWithShortcutForKey(i, keyevent);
        boolean flag = false;
        if(menuitemimpl != null)
            flag = performItemAction(menuitemimpl, j);
        if((j & 2) != 0)
            close(true);
        return flag;
    }

    public void removeGroup(int i) {
        int j = findGroupIndex(i);
        if(j >= 0) {
            int k = mItems.size() - j;
            int l = 0;
            do {
                int i1 = l + 1;
                if(l >= k || ((MenuItemImpl)mItems.get(j)).getGroupId() != i)
                    break;
                removeItemAtInt(j, false);
                l = i1;
            } while(true);
            onItemsChanged(true);
        }
    }

    public void removeItem(int i) {
        removeItemAtInt(findItemIndex(i), true);
    }

    public void removeItemAt(int i) {
        removeItemAtInt(i, true);
    }

    public void removeMenuPresenter(MenuPresenter menupresenter) {
        Iterator iterator = mPresenters.iterator();
        do {
            if(!iterator.hasNext())
                break;
            WeakReference weakreference = (WeakReference)iterator.next();
            MenuPresenter menupresenter1 = (MenuPresenter)weakreference.get();
            if(menupresenter1 == null || menupresenter1 == menupresenter)
                mPresenters.remove(weakreference);
        } while(true);
    }

    public void restoreActionViewStates(Bundle bundle) {
        if(bundle != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        SparseArray sparsearray = bundle.getSparseParcelableArray(getActionViewStatesKey());
        int i = size();
        for(int j = 0; j < i; j++) {
            MenuItem menuitem1 = getItem(j);
            View view = menuitem1.getActionView();
            if(view != null && view.getId() != -1)
                view.restoreHierarchyState(sparsearray);
            if(menuitem1.hasSubMenu())
                ((SubMenuBuilder)menuitem1.getSubMenu()).restoreActionViewStates(bundle);
        }

        int k = bundle.getInt("android:menu:expandedactionview");
        if(k > 0) {
            MenuItem menuitem = findItem(k);
            if(menuitem != null)
                menuitem.expandActionView();
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void restorePresenterStates(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        SparseArray sparsearray = null;
        int i = size();
        for(int j = 0; j < i; j++) {
            MenuItem menuitem = getItem(j);
            View view = menuitem.getActionView();
            if(view != null && view.getId() != -1) {
                if(sparsearray == null)
                    sparsearray = new SparseArray();
                view.saveHierarchyState(sparsearray);
                if(menuitem.isActionViewExpanded())
                    bundle.putInt("android:menu:expandedactionview", menuitem.getItemId());
            }
            if(menuitem.hasSubMenu())
                ((SubMenuBuilder)menuitem.getSubMenu()).saveActionViewStates(bundle);
        }

        if(sparsearray != null)
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparsearray);
    }

    public void savePresenterStates(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    public void setCurrentMenuInfo(android.view.ContextMenu.ContextMenuInfo contextmenuinfo) {
        mCurrentMenuInfo = contextmenuinfo;
    }

    public MenuBuilder setDefaultShowAsAction(int i) {
        mDefaultShowAsAction = i;
        return this;
    }

    void setExclusiveItemChecked(MenuItem menuitem) {
        int i = menuitem.getGroupId();
        int j = mItems.size();
        int k = 0;
        do {
            if(k >= j)
                break;
            MenuItemImpl menuitemimpl = (MenuItemImpl)mItems.get(k);
            if(menuitemimpl.getGroupId() == i && menuitemimpl.isExclusiveCheckable() && menuitemimpl.isCheckable()) {
                boolean flag;
                if(menuitemimpl == menuitem)
                    flag = true;
                else
                    flag = false;
                menuitemimpl.setCheckedInt(flag);
            }
            k++;
        } while(true);
    }

    public void setGroupCheckable(int i, boolean flag, boolean flag1) {
        int j = mItems.size();
        for(int k = 0; k < j; k++) {
            MenuItemImpl menuitemimpl = (MenuItemImpl)mItems.get(k);
            if(menuitemimpl.getGroupId() == i) {
                menuitemimpl.setExclusiveCheckable(flag1);
                menuitemimpl.setCheckable(flag);
            }
        }

    }

    public void setGroupEnabled(int i, boolean flag) {
        int j = mItems.size();
        for(int k = 0; k < j; k++) {
            MenuItemImpl menuitemimpl = (MenuItemImpl)mItems.get(k);
            if(menuitemimpl.getGroupId() == i)
                menuitemimpl.setEnabled(flag);
        }

    }

    public void setGroupVisible(int i, boolean flag) {
        int j = mItems.size();
        boolean flag1 = false;
        for(int k = 0; k < j; k++) {
            MenuItemImpl menuitemimpl = (MenuItemImpl)mItems.get(k);
            if(menuitemimpl.getGroupId() == i && menuitemimpl.setVisibleInt(flag))
                flag1 = true;
        }

        if(flag1)
            onItemsChanged(true);
    }

    protected MenuBuilder setHeaderIconInt(int i) {
        setHeaderInternal(0, null, i, null, null);
        return this;
    }

    protected MenuBuilder setHeaderIconInt(Drawable drawable) {
        setHeaderInternal(0, null, 0, drawable, null);
        return this;
    }

    protected MenuBuilder setHeaderTitleInt(int i) {
        setHeaderInternal(i, null, 0, null, null);
        return this;
    }

    protected MenuBuilder setHeaderTitleInt(CharSequence charsequence) {
        setHeaderInternal(0, charsequence, 0, null, null);
        return this;
    }

    protected MenuBuilder setHeaderViewInt(View view) {
        setHeaderInternal(0, null, 0, null, view);
        return this;
    }

    void setOptionalIconsVisible(boolean flag) {
        mOptionalIconsVisible = flag;
    }

    public void setQwertyMode(boolean flag) {
        mQwertyMode = flag;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean flag) {
        if(mShortcutsVisible != flag) {
            setShortcutsVisibleInner(flag);
            onItemsChanged(false);
        }
    }

    public int size() {
        return mItems.size();
    }

    public void startDispatchingItemsChanged() {
        mPreventDispatchingItemsChanged = false;
        if(mItemsChangedWhileDispatchPrevented) {
            mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(true);
        }
    }

    public void stopDispatchingItemsChanged() {
        if(!mPreventDispatchingItemsChanged) {
            mPreventDispatchingItemsChanged = true;
            mItemsChangedWhileDispatchPrevented = false;
        }
    }

    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int sCategoryToOrder[];
    private ArrayList mActionItems;
    private Callback mCallback;
    private final Context mContext;
    private android.view.ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private int mDefaultShowAsAction;
    private MenuItemImpl mExpandedItem;
    private SparseArray mFrozenViewStates;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mIsActionItemsStale;
    private boolean mIsClosing;
    private boolean mIsVisibleItemsStale;
    private ArrayList mItems;
    private boolean mItemsChangedWhileDispatchPrevented;
    private ArrayList mNonActionItems;
    private boolean mOptionalIconsVisible;
    private CopyOnWriteArrayList mPresenters;
    private boolean mPreventDispatchingItemsChanged;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private ArrayList mTempShortcutItemList;
    private ArrayList mVisibleItems;

    static  {
        int ai[] = new int[6];
        ai[0] = 1;
        ai[1] = 4;
        ai[2] = 5;
        ai[3] = 3;
        ai[4] = 2;
        ai[5] = 0;
        sCategoryToOrder = ai;
    }
}
