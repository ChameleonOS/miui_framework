// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

// Referenced classes of package android.app:
//            Activity

public class ExpandableListActivity extends Activity
    implements android.view.View.OnCreateContextMenuListener, android.widget.ExpandableListView.OnChildClickListener, android.widget.ExpandableListView.OnGroupCollapseListener, android.widget.ExpandableListView.OnGroupExpandListener {

    public ExpandableListActivity() {
        mFinishedStart = false;
    }

    private void ensureList() {
        if(mList == null)
            setContentView(0x1090001);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return mAdapter;
    }

    public ExpandableListView getExpandableListView() {
        ensureList();
        return mList;
    }

    public long getSelectedId() {
        return mList.getSelectedId();
    }

    public long getSelectedPosition() {
        return mList.getSelectedPosition();
    }

    public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l) {
        return false;
    }

    public void onContentChanged() {
        super.onContentChanged();
        View view = findViewById(0x1020004);
        mList = (ExpandableListView)findViewById(0x102000a);
        if(mList == null)
            throw new RuntimeException("Your content must have a ExpandableListView whose id attribute is 'android.R.id.list'");
        if(view != null)
            mList.setEmptyView(view);
        mList.setOnChildClickListener(this);
        mList.setOnGroupExpandListener(this);
        mList.setOnGroupCollapseListener(this);
        if(mFinishedStart)
            setListAdapter(mAdapter);
        mFinishedStart = true;
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo) {
    }

    public void onGroupCollapse(int i) {
    }

    public void onGroupExpand(int i) {
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        ensureList();
        super.onRestoreInstanceState(bundle);
    }

    public void setListAdapter(ExpandableListAdapter expandablelistadapter) {
        this;
        JVM INSTR monitorenter ;
        ensureList();
        mAdapter = expandablelistadapter;
        mList.setAdapter(expandablelistadapter);
        return;
    }

    public boolean setSelectedChild(int i, int j, boolean flag) {
        return mList.setSelectedChild(i, j, flag);
    }

    public void setSelectedGroup(int i) {
        mList.setSelectedGroup(i);
    }

    ExpandableListAdapter mAdapter;
    boolean mFinishedStart;
    ExpandableListView mList;
}
