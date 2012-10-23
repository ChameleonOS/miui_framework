// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view.menu;

import android.content.*;
import android.content.pm.*;
import android.content.res.Resources;
import android.view.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.android.internal.view.menu:
//            ActionMenuItem

public class ActionMenu
    implements Menu {

    public ActionMenu(Context context) {
        mContext = context;
        mItems = new ArrayList();
    }

    private int findItemIndex(int i) {
        ArrayList arraylist;
        int j;
        int k;
        arraylist = mItems;
        j = arraylist.size();
        k = 0;
_L3:
        if(k >= j)
            break MISSING_BLOCK_LABEL_44;
        if(((ActionMenuItem)arraylist.get(k)).getItemId() != i) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        k++;
          goto _L3
        k = -1;
          goto _L1
    }

    private ActionMenuItem findItemWithShortcut(int i, KeyEvent keyevent) {
        boolean flag;
        ArrayList arraylist;
        int j;
        int k;
        flag = mIsQwerty;
        arraylist = mItems;
        j = arraylist.size();
        k = 0;
_L3:
        ActionMenuItem actionmenuitem;
        if(k >= j)
            break MISSING_BLOCK_LABEL_76;
        actionmenuitem = (ActionMenuItem)arraylist.get(k);
        char c;
        if(flag)
            c = actionmenuitem.getAlphabeticShortcut();
        else
            c = actionmenuitem.getNumericShortcut();
        if(i != c) goto _L2; else goto _L1
_L1:
        return actionmenuitem;
_L2:
        k++;
          goto _L3
        actionmenuitem = null;
          goto _L1
    }

    public MenuItem add(int i) {
        return add(0, 0, 0, i);
    }

    public MenuItem add(int i, int j, int k, int l) {
        return add(i, j, k, ((CharSequence) (mContext.getResources().getString(l))));
    }

    public MenuItem add(int i, int j, int k, CharSequence charsequence) {
        ActionMenuItem actionmenuitem = new ActionMenuItem(getContext(), i, j, 0, k, charsequence);
        mItems.add(k, actionmenuitem);
        return actionmenuitem;
    }

    public MenuItem add(CharSequence charsequence) {
        return add(0, 0, 0, charsequence);
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

    public SubMenu addSubMenu(int i) {
        return null;
    }

    public SubMenu addSubMenu(int i, int j, int k, int l) {
        return null;
    }

    public SubMenu addSubMenu(int i, int j, int k, CharSequence charsequence) {
        return null;
    }

    public SubMenu addSubMenu(CharSequence charsequence) {
        return null;
    }

    public void clear() {
        mItems.clear();
    }

    public void close() {
    }

    public MenuItem findItem(int i) {
        return (MenuItem)mItems.get(findItemIndex(i));
    }

    public Context getContext() {
        return mContext;
    }

    public MenuItem getItem(int i) {
        return (MenuItem)mItems.get(i);
    }

    public boolean hasVisibleItems() {
        ArrayList arraylist;
        int i;
        int j;
        arraylist = mItems;
        i = arraylist.size();
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_43;
        if(!((ActionMenuItem)arraylist.get(j)).isVisible()) goto _L2; else goto _L1
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

    public boolean isShortcutKey(int i, KeyEvent keyevent) {
        boolean flag;
        if(findItemWithShortcut(i, keyevent) != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean performIdentifierAction(int i, int j) {
        int k = findItemIndex(i);
        boolean flag;
        if(k < 0)
            flag = false;
        else
            flag = ((ActionMenuItem)mItems.get(k)).invoke();
        return flag;
    }

    public boolean performShortcut(int i, KeyEvent keyevent, int j) {
        ActionMenuItem actionmenuitem = findItemWithShortcut(i, keyevent);
        boolean flag;
        if(actionmenuitem == null)
            flag = false;
        else
            flag = actionmenuitem.invoke();
        return flag;
    }

    public void removeGroup(int i) {
        ArrayList arraylist = mItems;
        int j = arraylist.size();
        for(int k = 0; k < j;)
            if(((ActionMenuItem)arraylist.get(k)).getGroupId() == i) {
                arraylist.remove(k);
                j--;
            } else {
                k++;
            }

    }

    public void removeItem(int i) {
        mItems.remove(findItemIndex(i));
    }

    public void setGroupCheckable(int i, boolean flag, boolean flag1) {
        ArrayList arraylist = mItems;
        int j = arraylist.size();
        for(int k = 0; k < j; k++) {
            ActionMenuItem actionmenuitem = (ActionMenuItem)arraylist.get(k);
            if(actionmenuitem.getGroupId() == i) {
                actionmenuitem.setCheckable(flag);
                actionmenuitem.setExclusiveCheckable(flag1);
            }
        }

    }

    public void setGroupEnabled(int i, boolean flag) {
        ArrayList arraylist = mItems;
        int j = arraylist.size();
        for(int k = 0; k < j; k++) {
            ActionMenuItem actionmenuitem = (ActionMenuItem)arraylist.get(k);
            if(actionmenuitem.getGroupId() == i)
                actionmenuitem.setEnabled(flag);
        }

    }

    public void setGroupVisible(int i, boolean flag) {
        ArrayList arraylist = mItems;
        int j = arraylist.size();
        for(int k = 0; k < j; k++) {
            ActionMenuItem actionmenuitem = (ActionMenuItem)arraylist.get(k);
            if(actionmenuitem.getGroupId() == i)
                actionmenuitem.setVisible(flag);
        }

    }

    public void setQwertyMode(boolean flag) {
        mIsQwerty = flag;
    }

    public int size() {
        return mItems.size();
    }

    private Context mContext;
    private boolean mIsQwerty;
    private ArrayList mItems;
}
