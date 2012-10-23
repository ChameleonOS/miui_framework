// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.view.*;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.widget:
//            BaseExpandableListAdapter, TextView

public class SimpleExpandableListAdapter extends BaseExpandableListAdapter {

    public SimpleExpandableListAdapter(Context context, List list, int i, int j, String as[], int ai[], List list1, 
            int k, int l, String as1[], int ai1[]) {
        mGroupData = list;
        mExpandedGroupLayout = i;
        mCollapsedGroupLayout = j;
        mGroupFrom = as;
        mGroupTo = ai;
        mChildData = list1;
        mChildLayout = k;
        mLastChildLayout = l;
        mChildFrom = as1;
        mChildTo = ai1;
        mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public SimpleExpandableListAdapter(Context context, List list, int i, int j, String as[], int ai[], List list1, 
            int k, String as1[], int ai1[]) {
        this(context, list, i, j, as, ai, list1, k, k, as1, ai1);
    }

    public SimpleExpandableListAdapter(Context context, List list, int i, String as[], int ai[], List list1, int j, 
            String as1[], int ai1[]) {
        this(context, list, i, i, as, ai, list1, j, j, as1, ai1);
    }

    private void bindView(View view, Map map, String as[], int ai[]) {
        int i = ai.length;
        for(int j = 0; j < i; j++) {
            TextView textview = (TextView)view.findViewById(ai[j]);
            if(textview != null)
                textview.setText((String)map.get(as[j]));
        }

    }

    public Object getChild(int i, int j) {
        return ((List)mChildData.get(i)).get(j);
    }

    public long getChildId(int i, int j) {
        return (long)j;
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup) {
        View view1;
        if(view == null)
            view1 = newChildView(flag, viewgroup);
        else
            view1 = view;
        bindView(view1, (Map)((List)mChildData.get(i)).get(j), mChildFrom, mChildTo);
        return view1;
    }

    public int getChildrenCount(int i) {
        return ((List)mChildData.get(i)).size();
    }

    public Object getGroup(int i) {
        return mGroupData.get(i);
    }

    public int getGroupCount() {
        return mGroupData.size();
    }

    public long getGroupId(int i) {
        return (long)i;
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup) {
        View view1;
        if(view == null)
            view1 = newGroupView(flag, viewgroup);
        else
            view1 = view;
        bindView(view1, (Map)mGroupData.get(i), mGroupFrom, mGroupTo);
        return view1;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int i, int j) {
        return true;
    }

    public View newChildView(boolean flag, ViewGroup viewgroup) {
        LayoutInflater layoutinflater = mInflater;
        int i;
        if(flag)
            i = mLastChildLayout;
        else
            i = mChildLayout;
        return layoutinflater.inflate(i, viewgroup, false);
    }

    public View newGroupView(boolean flag, ViewGroup viewgroup) {
        LayoutInflater layoutinflater = mInflater;
        int i;
        if(flag)
            i = mExpandedGroupLayout;
        else
            i = mCollapsedGroupLayout;
        return layoutinflater.inflate(i, viewgroup, false);
    }

    private List mChildData;
    private String mChildFrom[];
    private int mChildLayout;
    private int mChildTo[];
    private int mCollapsedGroupLayout;
    private int mExpandedGroupLayout;
    private List mGroupData;
    private String mGroupFrom[];
    private int mGroupTo[];
    private LayoutInflater mInflater;
    private int mLastChildLayout;
}
