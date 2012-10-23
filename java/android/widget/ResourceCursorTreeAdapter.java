// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.*;

// Referenced classes of package android.widget:
//            CursorTreeAdapter

public abstract class ResourceCursorTreeAdapter extends CursorTreeAdapter {

    public ResourceCursorTreeAdapter(Context context, Cursor cursor, int i, int j) {
        this(context, cursor, i, i, j, j);
    }

    public ResourceCursorTreeAdapter(Context context, Cursor cursor, int i, int j, int k) {
        this(context, cursor, i, j, k, k);
    }

    public ResourceCursorTreeAdapter(Context context, Cursor cursor, int i, int j, int k, int l) {
        super(cursor, context);
        mCollapsedGroupLayout = i;
        mExpandedGroupLayout = j;
        mChildLayout = k;
        mLastChildLayout = l;
        mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public View newChildView(Context context, Cursor cursor, boolean flag, ViewGroup viewgroup) {
        LayoutInflater layoutinflater = mInflater;
        int i;
        if(flag)
            i = mLastChildLayout;
        else
            i = mChildLayout;
        return layoutinflater.inflate(i, viewgroup, false);
    }

    public View newGroupView(Context context, Cursor cursor, boolean flag, ViewGroup viewgroup) {
        LayoutInflater layoutinflater = mInflater;
        int i;
        if(flag)
            i = mExpandedGroupLayout;
        else
            i = mCollapsedGroupLayout;
        return layoutinflater.inflate(i, viewgroup, false);
    }

    private int mChildLayout;
    private int mCollapsedGroupLayout;
    private int mExpandedGroupLayout;
    private LayoutInflater mInflater;
    private int mLastChildLayout;
}
