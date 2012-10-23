// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

public interface ExpandableListAdapter {

    public abstract boolean areAllItemsEnabled();

    public abstract Object getChild(int i, int j);

    public abstract long getChildId(int i, int j);

    public abstract View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup);

    public abstract int getChildrenCount(int i);

    public abstract long getCombinedChildId(long l, long l1);

    public abstract long getCombinedGroupId(long l);

    public abstract Object getGroup(int i);

    public abstract int getGroupCount();

    public abstract long getGroupId(int i);

    public abstract View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup);

    public abstract boolean hasStableIds();

    public abstract boolean isChildSelectable(int i, int j);

    public abstract boolean isEmpty();

    public abstract void onGroupCollapsed(int i);

    public abstract void onGroupExpanded(int i);

    public abstract void registerDataSetObserver(DataSetObserver datasetobserver);

    public abstract void unregisterDataSetObserver(DataSetObserver datasetobserver);
}
