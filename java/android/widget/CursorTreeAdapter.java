// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.database.*;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.widget:
//            BaseExpandableListAdapter, Filterable, CursorFilter, FilterQueryProvider, 
//            Filter

public abstract class CursorTreeAdapter extends BaseExpandableListAdapter
    implements Filterable, CursorFilter.CursorFilterClient {
    class MyCursorHelper {
        private class MyDataSetObserver extends DataSetObserver {

            public void onChanged() {
                mDataValid = true;
                notifyDataSetChanged();
            }

            public void onInvalidated() {
                mDataValid = false;
                notifyDataSetInvalidated();
            }

            final MyCursorHelper this$1;

            private MyDataSetObserver() {
                this$1 = MyCursorHelper.this;
                super();
            }

        }

        private class MyContentObserver extends ContentObserver {

            public boolean deliverSelfNotifications() {
                return true;
            }

            public void onChange(boolean flag) {
                if(mAutoRequery && mCursor != null)
                    mDataValid = mCursor.requery();
            }

            final MyCursorHelper this$1;

            public MyContentObserver() {
                this$1 = MyCursorHelper.this;
                super(mHandler);
            }
        }


        void changeCursor(Cursor cursor, boolean flag) {
            if(cursor != mCursor) {
                deactivate();
                mCursor = cursor;
                if(cursor != null) {
                    cursor.registerContentObserver(mContentObserver);
                    cursor.registerDataSetObserver(mDataSetObserver);
                    mRowIDColumn = cursor.getColumnIndex("_id");
                    mDataValid = true;
                    notifyDataSetChanged(flag);
                } else {
                    mRowIDColumn = -1;
                    mDataValid = false;
                    notifyDataSetInvalidated();
                }
            }
        }

        void deactivate() {
            if(mCursor != null) {
                mCursor.unregisterContentObserver(mContentObserver);
                mCursor.unregisterDataSetObserver(mDataSetObserver);
                mCursor.close();
                mCursor = null;
            }
        }

        int getCount() {
            int i;
            if(mDataValid && mCursor != null)
                i = mCursor.getCount();
            else
                i = 0;
            return i;
        }

        Cursor getCursor() {
            return mCursor;
        }

        long getId(int i) {
            long l = 0L;
            if(mDataValid && mCursor != null && mCursor.moveToPosition(i))
                l = mCursor.getLong(mRowIDColumn);
            return l;
        }

        boolean isValid() {
            boolean flag;
            if(mDataValid && mCursor != null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        Cursor moveTo(int i) {
            Cursor cursor;
            if(mDataValid && mCursor != null && mCursor.moveToPosition(i))
                cursor = mCursor;
            else
                cursor = null;
            return cursor;
        }

        private MyContentObserver mContentObserver;
        private Cursor mCursor;
        private MyDataSetObserver mDataSetObserver;
        private boolean mDataValid;
        private int mRowIDColumn;
        final CursorTreeAdapter this$0;



/*
        static boolean access$402(MyCursorHelper mycursorhelper, boolean flag) {
            mycursorhelper.mDataValid = flag;
            return flag;
        }

*/

        MyCursorHelper(Cursor cursor) {
            this$0 = CursorTreeAdapter.this;
            super();
            boolean flag;
            int i;
            if(cursor != null)
                flag = true;
            else
                flag = false;
            mCursor = cursor;
            mDataValid = flag;
            if(flag)
                i = cursor.getColumnIndex("_id");
            else
                i = -1;
            mRowIDColumn = i;
            mContentObserver = new MyContentObserver();
            mDataSetObserver = new MyDataSetObserver();
            if(flag) {
                cursor.registerContentObserver(mContentObserver);
                cursor.registerDataSetObserver(mDataSetObserver);
            }
        }
    }


    public CursorTreeAdapter(Cursor cursor, Context context) {
        init(cursor, context, true);
    }

    public CursorTreeAdapter(Cursor cursor, Context context, boolean flag) {
        init(cursor, context, flag);
    }

    private void init(Cursor cursor, Context context, boolean flag) {
        mContext = context;
        mHandler = new Handler();
        mAutoRequery = flag;
        mGroupCursorHelper = new MyCursorHelper(cursor);
        mChildrenCursorHelpers = new SparseArray();
    }

    /**
     * @deprecated Method releaseCursorHelpers is deprecated
     */

    private void releaseCursorHelpers() {
        this;
        JVM INSTR monitorenter ;
        for(int i = -1 + mChildrenCursorHelpers.size(); i >= 0; i--)
            ((MyCursorHelper)mChildrenCursorHelpers.valueAt(i)).deactivate();

        mChildrenCursorHelpers.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract void bindChildView(View view, Context context, Cursor cursor, boolean flag);

    protected abstract void bindGroupView(View view, Context context, Cursor cursor, boolean flag);

    public void changeCursor(Cursor cursor) {
        mGroupCursorHelper.changeCursor(cursor, true);
    }

    public volatile CharSequence convertToString(Cursor cursor) {
        return convertToString(cursor);
    }

    public String convertToString(Cursor cursor) {
        String s;
        if(cursor == null)
            s = "";
        else
            s = cursor.toString();
        return s;
    }

    /**
     * @deprecated Method deactivateChildrenCursorHelper is deprecated
     */

    void deactivateChildrenCursorHelper(int i) {
        this;
        JVM INSTR monitorenter ;
        MyCursorHelper mycursorhelper = getChildrenCursorHelper(i, true);
        mChildrenCursorHelpers.remove(i);
        mycursorhelper.deactivate();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public Cursor getChild(int i, int j) {
        return getChildrenCursorHelper(i, true).moveTo(j);
    }

    public volatile Object getChild(int i, int j) {
        return getChild(i, j);
    }

    public long getChildId(int i, int j) {
        return getChildrenCursorHelper(i, true).getId(j);
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup) {
        Cursor cursor = getChildrenCursorHelper(i, true).moveTo(j);
        if(cursor == null)
            throw new IllegalStateException("this should only be called when the cursor is valid");
        View view1;
        if(view == null)
            view1 = newChildView(mContext, cursor, flag, viewgroup);
        else
            view1 = view;
        bindChildView(view1, mContext, cursor, flag);
        return view1;
    }

    public int getChildrenCount(int i) {
        MyCursorHelper mycursorhelper = getChildrenCursorHelper(i, true);
        int j;
        if(mGroupCursorHelper.isValid() && mycursorhelper != null)
            j = mycursorhelper.getCount();
        else
            j = 0;
        return j;
    }

    protected abstract Cursor getChildrenCursor(Cursor cursor);

    /**
     * @deprecated Method getChildrenCursorHelper is deprecated
     */

    MyCursorHelper getChildrenCursorHelper(int i, boolean flag) {
        this;
        JVM INSTR monitorenter ;
        MyCursorHelper mycursorhelper = (MyCursorHelper)mChildrenCursorHelpers.get(i);
        if(mycursorhelper != null) goto _L2; else goto _L1
_L1:
        Cursor cursor = mGroupCursorHelper.moveTo(i);
        if(cursor != null) goto _L4; else goto _L3
_L3:
        MyCursorHelper mycursorhelper1 = null;
_L6:
        this;
        JVM INSTR monitorexit ;
        return mycursorhelper1;
_L4:
        mycursorhelper = new MyCursorHelper(getChildrenCursor(mGroupCursorHelper.getCursor()));
        mChildrenCursorHelpers.put(i, mycursorhelper);
_L2:
        mycursorhelper1 = mycursorhelper;
        if(true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public Cursor getCursor() {
        return mGroupCursorHelper.getCursor();
    }

    public Filter getFilter() {
        if(mCursorFilter == null)
            mCursorFilter = new CursorFilter(this);
        return mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return mFilterQueryProvider;
    }

    public Cursor getGroup(int i) {
        return mGroupCursorHelper.moveTo(i);
    }

    public volatile Object getGroup(int i) {
        return getGroup(i);
    }

    public int getGroupCount() {
        return mGroupCursorHelper.getCount();
    }

    public long getGroupId(int i) {
        return mGroupCursorHelper.getId(i);
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup) {
        Cursor cursor = mGroupCursorHelper.moveTo(i);
        if(cursor == null)
            throw new IllegalStateException("this should only be called when the cursor is valid");
        View view1;
        if(view == null)
            view1 = newGroupView(mContext, cursor, flag, viewgroup);
        else
            view1 = view;
        bindGroupView(view1, mContext, cursor, flag);
        return view1;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int i, int j) {
        return true;
    }

    protected abstract View newChildView(Context context, Cursor cursor, boolean flag, ViewGroup viewgroup);

    protected abstract View newGroupView(Context context, Cursor cursor, boolean flag, ViewGroup viewgroup);

    public void notifyDataSetChanged() {
        notifyDataSetChanged(true);
    }

    public void notifyDataSetChanged(boolean flag) {
        if(flag)
            releaseCursorHelpers();
        super.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated() {
        releaseCursorHelpers();
        super.notifyDataSetInvalidated();
    }

    public void onGroupCollapsed(int i) {
        deactivateChildrenCursorHelper(i);
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charsequence) {
        Cursor cursor;
        if(mFilterQueryProvider != null)
            cursor = mFilterQueryProvider.runQuery(charsequence);
        else
            cursor = mGroupCursorHelper.getCursor();
        return cursor;
    }

    public void setChildrenCursor(int i, Cursor cursor) {
        getChildrenCursorHelper(i, false).changeCursor(cursor, false);
    }

    public void setFilterQueryProvider(FilterQueryProvider filterqueryprovider) {
        mFilterQueryProvider = filterqueryprovider;
    }

    public void setGroupCursor(Cursor cursor) {
        mGroupCursorHelper.changeCursor(cursor, false);
    }

    private boolean mAutoRequery;
    SparseArray mChildrenCursorHelpers;
    private Context mContext;
    CursorFilter mCursorFilter;
    FilterQueryProvider mFilterQueryProvider;
    MyCursorHelper mGroupCursorHelper;
    private Handler mHandler;


}
