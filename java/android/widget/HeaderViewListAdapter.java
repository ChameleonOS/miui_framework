// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.widget:
//            WrapperListAdapter, Filterable, ListAdapter, Filter

public class HeaderViewListAdapter
    implements WrapperListAdapter, Filterable {

    public HeaderViewListAdapter(ArrayList arraylist, ArrayList arraylist1, ListAdapter listadapter) {
        mAdapter = listadapter;
        mIsFilterable = listadapter instanceof Filterable;
        boolean flag;
        if(arraylist == null)
            mHeaderViewInfos = EMPTY_INFO_LIST;
        else
            mHeaderViewInfos = arraylist;
        if(arraylist1 == null)
            mFooterViewInfos = EMPTY_INFO_LIST;
        else
            mFooterViewInfos = arraylist1;
        if(areAllListInfosSelectable(mHeaderViewInfos) && areAllListInfosSelectable(mFooterViewInfos))
            flag = true;
        else
            flag = false;
        mAreAllFixedViewsSelectable = flag;
    }

    private boolean areAllListInfosSelectable(ArrayList arraylist) {
        if(arraylist == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = arraylist.iterator();
_L5:
        if(!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        if(((ListView.FixedViewInfo)iterator.next()).isSelectable) goto _L5; else goto _L4
_L4:
        boolean flag = false;
_L7:
        return flag;
_L2:
        flag = true;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public boolean areAllItemsEnabled() {
        boolean flag = true;
        if(mAdapter != null && (!mAreAllFixedViewsSelectable || !mAdapter.areAllItemsEnabled()))
            flag = false;
        return flag;
    }

    public int getCount() {
        int i;
        if(mAdapter != null)
            i = getFootersCount() + getHeadersCount() + mAdapter.getCount();
        else
            i = getFootersCount() + getHeadersCount();
        return i;
    }

    public Filter getFilter() {
        Filter filter;
        if(mIsFilterable)
            filter = ((Filterable)mAdapter).getFilter();
        else
            filter = null;
        return filter;
    }

    public int getFootersCount() {
        return mFooterViewInfos.size();
    }

    public int getHeadersCount() {
        return mHeaderViewInfos.size();
    }

    public Object getItem(int i) {
        int j = getHeadersCount();
        if(i >= j) goto _L2; else goto _L1
_L1:
        Object obj = ((ListView.FixedViewInfo)mHeaderViewInfos.get(i)).data;
_L4:
        return obj;
_L2:
        int k = i - j;
        int l = 0;
        if(mAdapter != null) {
            l = mAdapter.getCount();
            if(k < l) {
                obj = mAdapter.getItem(k);
                continue; /* Loop/switch isn't completed */
            }
        }
        obj = ((ListView.FixedViewInfo)mFooterViewInfos.get(k - l)).data;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public long getItemId(int i) {
        int j = getHeadersCount();
        if(mAdapter == null || i < j) goto _L2; else goto _L1
_L1:
        int k = i - j;
        if(k >= mAdapter.getCount()) goto _L2; else goto _L3
_L3:
        long l = mAdapter.getItemId(k);
_L5:
        return l;
_L2:
        l = -1L;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public int getItemViewType(int i) {
        int j = getHeadersCount();
        if(mAdapter == null || i < j) goto _L2; else goto _L1
_L1:
        int l = i - j;
        if(l >= mAdapter.getCount()) goto _L2; else goto _L3
_L3:
        int k = mAdapter.getItemViewType(l);
_L5:
        return k;
_L2:
        k = -2;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public View getView(int i, View view, ViewGroup viewgroup) {
        int j = getHeadersCount();
        if(i >= j) goto _L2; else goto _L1
_L1:
        View view1 = ((ListView.FixedViewInfo)mHeaderViewInfos.get(i)).view;
_L4:
        return view1;
_L2:
        int k = i - j;
        int l = 0;
        if(mAdapter != null) {
            l = mAdapter.getCount();
            if(k < l) {
                view1 = mAdapter.getView(k, view, viewgroup);
                continue; /* Loop/switch isn't completed */
            }
        }
        view1 = ((ListView.FixedViewInfo)mFooterViewInfos.get(k - l)).view;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getViewTypeCount() {
        int i;
        if(mAdapter != null)
            i = mAdapter.getViewTypeCount();
        else
            i = 1;
        return i;
    }

    public ListAdapter getWrappedAdapter() {
        return mAdapter;
    }

    public boolean hasStableIds() {
        boolean flag;
        if(mAdapter != null)
            flag = mAdapter.hasStableIds();
        else
            flag = false;
        return flag;
    }

    public boolean isEmpty() {
        boolean flag;
        if(mAdapter == null || mAdapter.isEmpty())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isEnabled(int i) {
        int j = getHeadersCount();
        if(i >= j) goto _L2; else goto _L1
_L1:
        boolean flag = ((ListView.FixedViewInfo)mHeaderViewInfos.get(i)).isSelectable;
_L4:
        return flag;
_L2:
        int k = i - j;
        int l = 0;
        if(mAdapter != null) {
            l = mAdapter.getCount();
            if(k < l) {
                flag = mAdapter.isEnabled(k);
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = ((ListView.FixedViewInfo)mFooterViewInfos.get(k - l)).isSelectable;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver) {
        if(mAdapter != null)
            mAdapter.registerDataSetObserver(datasetobserver);
    }

    public boolean removeFooter(View view) {
        boolean flag;
        boolean flag1;
        int i;
        flag = true;
        flag1 = false;
        i = 0;
_L3:
        if(i >= mFooterViewInfos.size())
            break MISSING_BLOCK_LABEL_85;
        if(((ListView.FixedViewInfo)mFooterViewInfos.get(i)).view != view) goto _L2; else goto _L1
_L1:
        mFooterViewInfos.remove(i);
        if(areAllListInfosSelectable(mHeaderViewInfos) && areAllListInfosSelectable(mFooterViewInfos))
            flag1 = flag;
        mAreAllFixedViewsSelectable = flag1;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
    }

    public boolean removeHeader(View view) {
        boolean flag;
        boolean flag1;
        int i;
        flag = true;
        flag1 = false;
        i = 0;
_L3:
        if(i >= mHeaderViewInfos.size())
            break MISSING_BLOCK_LABEL_85;
        if(((ListView.FixedViewInfo)mHeaderViewInfos.get(i)).view != view) goto _L2; else goto _L1
_L1:
        mHeaderViewInfos.remove(i);
        if(areAllListInfosSelectable(mHeaderViewInfos) && areAllListInfosSelectable(mFooterViewInfos))
            flag1 = flag;
        mAreAllFixedViewsSelectable = flag1;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver) {
        if(mAdapter != null)
            mAdapter.unregisterDataSetObserver(datasetobserver);
    }

    static final ArrayList EMPTY_INFO_LIST = new ArrayList();
    private final ListAdapter mAdapter;
    boolean mAreAllFixedViewsSelectable;
    ArrayList mFooterViewInfos;
    ArrayList mHeaderViewInfos;
    private final boolean mIsFilterable;

}
