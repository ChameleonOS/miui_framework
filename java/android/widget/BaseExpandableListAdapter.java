// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;

// Referenced classes of package android.widget:
//            ExpandableListAdapter, HeterogeneousExpandableList

public abstract class BaseExpandableListAdapter
    implements ExpandableListAdapter, HeterogeneousExpandableList {

    public BaseExpandableListAdapter() {
    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public int getChildType(int i, int j) {
        return 0;
    }

    public int getChildTypeCount() {
        return 1;
    }

    public long getCombinedChildId(long l, long l1) {
        return 0x8000000000000000L | (0x7fffffffL & l) << 32 | -1L & l1;
    }

    public long getCombinedGroupId(long l) {
        return (0x7fffffffL & l) << 32;
    }

    public int getGroupType(int i) {
        return 0;
    }

    public int getGroupTypeCount() {
        return 1;
    }

    public boolean isEmpty() {
        boolean flag;
        if(getGroupCount() == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
    }

    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
    }

    public void onGroupCollapsed(int i) {
    }

    public void onGroupExpanded(int i) {
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver) {
        mDataSetObservable.registerObserver(datasetobserver);
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver) {
        mDataSetObservable.unregisterObserver(datasetobserver);
    }

    private final DataSetObservable mDataSetObservable = new DataSetObservable();
}
