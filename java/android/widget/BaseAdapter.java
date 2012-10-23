// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.widget:
//            ListAdapter, SpinnerAdapter

public abstract class BaseAdapter
    implements ListAdapter, SpinnerAdapter {

    public BaseAdapter() {
    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup) {
        return getView(i, view, viewgroup);
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isEmpty() {
        boolean flag;
        if(getCount() == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isEnabled(int i) {
        return true;
    }

    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
    }

    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver) {
        mDataSetObservable.registerObserver(datasetobserver);
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver) {
        mDataSetObservable.unregisterObserver(datasetobserver);
    }

    private final DataSetObservable mDataSetObservable = new DataSetObservable();
}
