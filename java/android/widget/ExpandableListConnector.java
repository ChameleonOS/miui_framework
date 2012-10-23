// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.database.DataSetObserver;
import android.os.*;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;

// Referenced classes of package android.widget:
//            BaseAdapter, Filterable, ExpandableListAdapter, ExpandableListPosition, 
//            HeterogeneousExpandableList, Filter

class ExpandableListConnector extends BaseAdapter
    implements Filterable {
    public static class PositionMetadata {

        private static PositionMetadata getRecycledOrCreate() {
            ArrayList arraylist = sPool;
            arraylist;
            JVM INSTR monitorenter ;
            if(sPool.size() <= 0) goto _L2; else goto _L1
_L1:
            PositionMetadata positionmetadata = (PositionMetadata)sPool.remove(0);
            positionmetadata.resetState();
_L4:
            return positionmetadata;
_L2:
            positionmetadata = new PositionMetadata();
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        static PositionMetadata obtain(int i, int j, int k, int l, GroupMetadata groupmetadata, int i1) {
            PositionMetadata positionmetadata = getRecycledOrCreate();
            positionmetadata.position = ExpandableListPosition.obtain(j, k, l, i);
            positionmetadata.groupMetadata = groupmetadata;
            positionmetadata.groupInsertIndex = i1;
            return positionmetadata;
        }

        private void resetState() {
            if(position != null) {
                position.recycle();
                position = null;
            }
            groupMetadata = null;
            groupInsertIndex = 0;
        }

        public boolean isExpanded() {
            boolean flag;
            if(groupMetadata != null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void recycle() {
            resetState();
            ArrayList arraylist = sPool;
            arraylist;
            JVM INSTR monitorenter ;
            if(sPool.size() < 5)
                sPool.add(this);
            return;
        }

        private static final int MAX_POOL_SIZE = 5;
        private static ArrayList sPool = new ArrayList(5);
        public int groupInsertIndex;
        public GroupMetadata groupMetadata;
        public ExpandableListPosition position;


        private PositionMetadata() {
        }
    }

    static class GroupMetadata
        implements Parcelable, Comparable {

        static GroupMetadata obtain(int i, int j, int k, long l) {
            GroupMetadata groupmetadata = new GroupMetadata();
            groupmetadata.flPos = i;
            groupmetadata.lastChildFlPos = j;
            groupmetadata.gPos = k;
            groupmetadata.gId = l;
            return groupmetadata;
        }

        public int compareTo(GroupMetadata groupmetadata) {
            if(groupmetadata == null)
                throw new IllegalArgumentException();
            else
                return gPos - groupmetadata.gPos;
        }

        public volatile int compareTo(Object obj) {
            return compareTo((GroupMetadata)obj);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(flPos);
            parcel.writeInt(lastChildFlPos);
            parcel.writeInt(gPos);
            parcel.writeLong(gId);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.obtain(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        static final int REFRESH = -1;
        int flPos;
        long gId;
        int gPos;
        int lastChildFlPos;


        private GroupMetadata() {
        }
    }

    protected class MyDataSetObserver extends DataSetObserver {

        public void onChanged() {
            refreshExpGroupMetadataList(true, true);
            notifyDataSetChanged();
        }

        public void onInvalidated() {
            refreshExpGroupMetadataList(true, true);
            notifyDataSetInvalidated();
        }

        final ExpandableListConnector this$0;

        protected MyDataSetObserver() {
            this$0 = ExpandableListConnector.this;
            super();
        }
    }


    public ExpandableListConnector(ExpandableListAdapter expandablelistadapter) {
        mMaxExpGroupCount = 0x7fffffff;
        mExpGroupMetadataList = new ArrayList();
        setExpandableListAdapter(expandablelistadapter);
    }

    private void refreshExpGroupMetadataList(boolean flag, boolean flag1) {
        ArrayList arraylist = mExpGroupMetadataList;
        int i = arraylist.size();
        int j = 0;
        mTotalExpChildrenCount = 0;
        if(flag1) {
            boolean flag2 = false;
            for(int k1 = i - 1; k1 >= 0; k1--) {
                GroupMetadata groupmetadata1 = (GroupMetadata)arraylist.get(k1);
                int l1 = findGroupPosition(groupmetadata1.gId, groupmetadata1.gPos);
                if(l1 == groupmetadata1.gPos)
                    continue;
                if(l1 == -1) {
                    arraylist.remove(k1);
                    i--;
                }
                groupmetadata1.gPos = l1;
                if(!flag2)
                    flag2 = true;
            }

            if(flag2)
                Collections.sort(arraylist);
        }
        int k = 0;
        int l = 0;
        while(l < i)  {
            GroupMetadata groupmetadata = (GroupMetadata)arraylist.get(l);
            int i1;
            int j1;
            if(groupmetadata.lastChildFlPos == -1 || flag)
                i1 = mExpandableListAdapter.getChildrenCount(groupmetadata.gPos);
            else
                i1 = groupmetadata.lastChildFlPos - groupmetadata.flPos;
            mTotalExpChildrenCount = i1 + mTotalExpChildrenCount;
            j1 = j + (groupmetadata.gPos - k);
            k = groupmetadata.gPos;
            groupmetadata.flPos = j1;
            j = j1 + i1;
            groupmetadata.lastChildFlPos = j;
            l++;
        }
    }

    public boolean areAllItemsEnabled() {
        return mExpandableListAdapter.areAllItemsEnabled();
    }

    boolean collapseGroup(int i) {
        ExpandableListPosition expandablelistposition = ExpandableListPosition.obtain(2, i, -1, -1);
        PositionMetadata positionmetadata = getFlattenedPos(expandablelistposition);
        expandablelistposition.recycle();
        boolean flag;
        if(positionmetadata == null) {
            flag = false;
        } else {
            flag = collapseGroup(positionmetadata);
            positionmetadata.recycle();
        }
        return flag;
    }

    boolean collapseGroup(PositionMetadata positionmetadata) {
        boolean flag = false;
        if(positionmetadata.groupMetadata != null) {
            mExpGroupMetadataList.remove(positionmetadata.groupMetadata);
            refreshExpGroupMetadataList(false, false);
            notifyDataSetChanged();
            mExpandableListAdapter.onGroupCollapsed(positionmetadata.groupMetadata.gPos);
            flag = true;
        }
        return flag;
    }

    boolean expandGroup(int i) {
        ExpandableListPosition expandablelistposition = ExpandableListPosition.obtain(2, i, -1, -1);
        PositionMetadata positionmetadata = getFlattenedPos(expandablelistposition);
        expandablelistposition.recycle();
        boolean flag = expandGroup(positionmetadata);
        positionmetadata.recycle();
        return flag;
    }

    boolean expandGroup(PositionMetadata positionmetadata) {
        boolean flag;
        flag = false;
        if(positionmetadata.position.groupPos < 0)
            throw new RuntimeException("Need group");
        break MISSING_BLOCK_LABEL_22;
        if(mMaxExpGroupCount != 0 && positionmetadata.groupMetadata == null) {
            if(mExpGroupMetadataList.size() >= mMaxExpGroupCount) {
                GroupMetadata groupmetadata1 = (GroupMetadata)mExpGroupMetadataList.get(0);
                int i = mExpGroupMetadataList.indexOf(groupmetadata1);
                collapseGroup(groupmetadata1.gPos);
                if(positionmetadata.groupInsertIndex > i)
                    positionmetadata.groupInsertIndex = -1 + positionmetadata.groupInsertIndex;
            }
            GroupMetadata groupmetadata = GroupMetadata.obtain(-1, -1, positionmetadata.position.groupPos, mExpandableListAdapter.getGroupId(positionmetadata.position.groupPos));
            mExpGroupMetadataList.add(positionmetadata.groupInsertIndex, groupmetadata);
            refreshExpGroupMetadataList(false, false);
            notifyDataSetChanged();
            mExpandableListAdapter.onGroupExpanded(groupmetadata.gPos);
            flag = true;
        }
        return flag;
    }

    int findGroupPosition(long l, int i) {
        int j = mExpandableListAdapter.getGroupCount();
        if(j != 0) goto _L2; else goto _L1
_L1:
        int i2 = -1;
_L8:
        return i2;
_L2:
        int i1;
        long l1;
        int j1;
        int k1;
        boolean flag;
        ExpandableListAdapter expandablelistadapter;
        boolean flag1;
        boolean flag2;
        if(l == 0x8000000000000000L) {
            i2 = -1;
            continue; /* Loop/switch isn't completed */
        }
        int k = Math.max(0, i);
        i1 = Math.min(j - 1, k);
        l1 = 100L + SystemClock.uptimeMillis();
        j1 = i1;
        k1 = i1;
        flag = false;
        expandablelistadapter = getAdapter();
        if(expandablelistadapter == null) {
            i2 = -1;
            continue; /* Loop/switch isn't completed */
        }
_L6:
        if(SystemClock.uptimeMillis() > l1)
            break; /* Loop/switch isn't completed */
        if(expandablelistadapter.getGroupId(i1) == l) {
            i2 = i1;
            continue; /* Loop/switch isn't completed */
        }
        if(k1 == j - 1)
            flag1 = true;
        else
            flag1 = false;
        if(j1 == 0)
            flag2 = true;
        else
            flag2 = false;
        if(!flag1 || !flag2) goto _L4; else goto _L3
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        if(flag2 || flag && !flag1) {
            i1 = ++k1;
            flag = false;
        } else
        if(flag1 || !flag && !flag2) {
            i1 = --j1;
            flag = true;
        }
        if(true) goto _L6; else goto _L5
_L5:
        i2 = -1;
        if(true) goto _L8; else goto _L7
_L7:
    }

    ExpandableListAdapter getAdapter() {
        return mExpandableListAdapter;
    }

    public int getCount() {
        return mExpandableListAdapter.getGroupCount() + mTotalExpChildrenCount;
    }

    ArrayList getExpandedGroupMetadataList() {
        return mExpGroupMetadataList;
    }

    public Filter getFilter() {
        ExpandableListAdapter expandablelistadapter = getAdapter();
        Filter filter;
        if(expandablelistadapter instanceof Filterable)
            filter = ((Filterable)expandablelistadapter).getFilter();
        else
            filter = null;
        return filter;
    }

    PositionMetadata getFlattenedPos(ExpandableListPosition expandablelistposition) {
        ArrayList arraylist;
        int j;
        int k;
        PositionMetadata positionmetadata;
        arraylist = mExpGroupMetadataList;
        int i = arraylist.size();
        j = 0;
        k = i - 1;
        if(i != 0)
            break MISSING_BLOCK_LABEL_361;
        positionmetadata = PositionMetadata.obtain(expandablelistposition.groupPos, expandablelistposition.type, expandablelistposition.groupPos, expandablelistposition.childPos, null, 0);
_L5:
        return positionmetadata;
_L3:
        int l;
        GroupMetadata groupmetadata2;
        do {
label0:
            {
                if(j > k)
                    break MISSING_BLOCK_LABEL_219;
                l = j + (k - j) / 2;
                groupmetadata2 = (GroupMetadata)arraylist.get(l);
                if(expandablelistposition.groupPos <= groupmetadata2.gPos)
                    break label0;
                j = l + 1;
            }
        } while(true);
        if(expandablelistposition.groupPos >= groupmetadata2.gPos) goto _L2; else goto _L1
_L1:
        k = l - 1;
          goto _L3
_L2:
        if(expandablelistposition.groupPos != groupmetadata2.gPos) goto _L3; else goto _L4
_L4:
        if(expandablelistposition.type == 2)
            positionmetadata = PositionMetadata.obtain(groupmetadata2.flPos, expandablelistposition.type, expandablelistposition.groupPos, expandablelistposition.childPos, groupmetadata2, l);
        else
        if(expandablelistposition.type == 1)
            positionmetadata = PositionMetadata.obtain(1 + (groupmetadata2.flPos + expandablelistposition.childPos), expandablelistposition.type, expandablelistposition.groupPos, expandablelistposition.childPos, groupmetadata2, l);
        else
            positionmetadata = null;
          goto _L5
        if(expandablelistposition.type != 2)
            positionmetadata = null;
        else
        if(j > l) {
            GroupMetadata groupmetadata1 = (GroupMetadata)arraylist.get(j - 1);
            positionmetadata = PositionMetadata.obtain(groupmetadata1.lastChildFlPos + (expandablelistposition.groupPos - groupmetadata1.gPos), expandablelistposition.type, expandablelistposition.groupPos, expandablelistposition.childPos, null, j);
        } else
        if(k < l) {
            int i1 = k + 1;
            GroupMetadata groupmetadata = (GroupMetadata)arraylist.get(i1);
            positionmetadata = PositionMetadata.obtain(groupmetadata.flPos - (groupmetadata.gPos - expandablelistposition.groupPos), expandablelistposition.type, expandablelistposition.groupPos, expandablelistposition.childPos, null, i1);
        } else {
            positionmetadata = null;
        }
          goto _L5
        l = 0;
          goto _L3
    }

    public Object getItem(int i) {
        PositionMetadata positionmetadata = getUnflattenedPos(i);
        Object obj;
        if(positionmetadata.position.type == 2)
            obj = mExpandableListAdapter.getGroup(positionmetadata.position.groupPos);
        else
        if(positionmetadata.position.type == 1)
            obj = mExpandableListAdapter.getChild(positionmetadata.position.groupPos, positionmetadata.position.childPos);
        else
            throw new RuntimeException("Flat list position is of unknown type");
        positionmetadata.recycle();
        return obj;
    }

    public long getItemId(int i) {
        PositionMetadata positionmetadata = getUnflattenedPos(i);
        long l = mExpandableListAdapter.getGroupId(positionmetadata.position.groupPos);
        long l2;
        if(positionmetadata.position.type == 2)
            l2 = mExpandableListAdapter.getCombinedGroupId(l);
        else
        if(positionmetadata.position.type == 1) {
            long l1 = mExpandableListAdapter.getChildId(positionmetadata.position.groupPos, positionmetadata.position.childPos);
            l2 = mExpandableListAdapter.getCombinedChildId(l, l1);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        positionmetadata.recycle();
        return l2;
    }

    public int getItemViewType(int i) {
        PositionMetadata positionmetadata = getUnflattenedPos(i);
        ExpandableListPosition expandablelistposition = positionmetadata.position;
        int j;
        if(mExpandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousexpandablelist = (HeterogeneousExpandableList)mExpandableListAdapter;
            if(expandablelistposition.type == 2)
                j = heterogeneousexpandablelist.getGroupType(expandablelistposition.groupPos);
            else
                j = heterogeneousexpandablelist.getChildType(expandablelistposition.groupPos, expandablelistposition.childPos) + heterogeneousexpandablelist.getGroupTypeCount();
        } else
        if(expandablelistposition.type == 2)
            j = 0;
        else
            j = 1;
        positionmetadata.recycle();
        return j;
    }

    PositionMetadata getUnflattenedPos(int i) {
        ArrayList arraylist;
        int k;
        int l;
        PositionMetadata positionmetadata;
        arraylist = mExpGroupMetadataList;
        int j = arraylist.size();
        k = 0;
        l = j - 1;
        if(j != 0)
            break MISSING_BLOCK_LABEL_287;
        positionmetadata = PositionMetadata.obtain(i, 2, i, -1, null, 0);
_L3:
        return positionmetadata;
_L5:
        int i1;
        GroupMetadata groupmetadata2;
        do {
            if(k > l)
                break MISSING_BLOCK_LABEL_174;
            i1 = k + (l - k) / 2;
            groupmetadata2 = (GroupMetadata)arraylist.get(i1);
            if(i > groupmetadata2.lastChildFlPos) {
                k = i1 + 1;
            } else {
label0:
                {
                    if(i >= groupmetadata2.flPos)
                        break label0;
                    l = i1 - 1;
                }
            }
        } while(true);
        if(i != groupmetadata2.flPos) goto _L2; else goto _L1
_L1:
        positionmetadata = PositionMetadata.obtain(i, 2, groupmetadata2.gPos, -1, groupmetadata2, i1);
          goto _L3
_L2:
        if(i > groupmetadata2.lastChildFlPos) goto _L5; else goto _L4
_L4:
        int i2 = i - (1 + groupmetadata2.flPos);
        positionmetadata = PositionMetadata.obtain(i, 1, groupmetadata2.gPos, i2, groupmetadata2, i1);
          goto _L3
        int k1;
        int l1;
        if(k > i1) {
            GroupMetadata groupmetadata1 = (GroupMetadata)arraylist.get(k - 1);
            k1 = k;
            l1 = (i - groupmetadata1.lastChildFlPos) + groupmetadata1.gPos;
        } else
        if(l < i1) {
            int j1 = l + 1;
            GroupMetadata groupmetadata = (GroupMetadata)arraylist.get(j1);
            k1 = j1;
            l1 = groupmetadata.gPos - (groupmetadata.flPos - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        positionmetadata = PositionMetadata.obtain(i, 2, l1, -1, null, k1);
          goto _L3
        i1 = 0;
          goto _L5
    }

    public View getView(int i, View view, ViewGroup viewgroup) {
        boolean flag = true;
        PositionMetadata positionmetadata = getUnflattenedPos(i);
        View view1;
        if(positionmetadata.position.type == 2)
            view1 = mExpandableListAdapter.getGroupView(positionmetadata.position.groupPos, positionmetadata.isExpanded(), view, viewgroup);
        else
        if(positionmetadata.position.type == flag) {
            if(positionmetadata.groupMetadata.lastChildFlPos != i)
                flag = false;
            view1 = mExpandableListAdapter.getChildView(positionmetadata.position.groupPos, positionmetadata.position.childPos, flag, view, viewgroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        positionmetadata.recycle();
        return view1;
    }

    public int getViewTypeCount() {
        int i;
        if(mExpandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousexpandablelist = (HeterogeneousExpandableList)mExpandableListAdapter;
            i = heterogeneousexpandablelist.getGroupTypeCount() + heterogeneousexpandablelist.getChildTypeCount();
        } else {
            i = 2;
        }
        return i;
    }

    public boolean hasStableIds() {
        return mExpandableListAdapter.hasStableIds();
    }

    public boolean isEmpty() {
        ExpandableListAdapter expandablelistadapter = getAdapter();
        boolean flag;
        if(expandablelistadapter != null)
            flag = expandablelistadapter.isEmpty();
        else
            flag = true;
        return flag;
    }

    public boolean isEnabled(int i) {
        PositionMetadata positionmetadata = getUnflattenedPos(i);
        ExpandableListPosition expandablelistposition = positionmetadata.position;
        boolean flag;
        if(expandablelistposition.type == 1)
            flag = mExpandableListAdapter.isChildSelectable(expandablelistposition.groupPos, expandablelistposition.childPos);
        else
            flag = true;
        positionmetadata.recycle();
        return flag;
    }

    public boolean isGroupExpanded(int i) {
        int j = -1 + mExpGroupMetadataList.size();
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_43;
        if(((GroupMetadata)mExpGroupMetadataList.get(j)).gPos != i) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        j--;
          goto _L3
        flag = false;
          goto _L4
    }

    public void setExpandableListAdapter(ExpandableListAdapter expandablelistadapter) {
        if(mExpandableListAdapter != null)
            mExpandableListAdapter.unregisterDataSetObserver(mDataSetObserver);
        mExpandableListAdapter = expandablelistadapter;
        expandablelistadapter.registerDataSetObserver(mDataSetObserver);
    }

    void setExpandedGroupMetadataList(ArrayList arraylist) {
        if(arraylist != null && mExpandableListAdapter != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = mExpandableListAdapter.getGroupCount();
        for(int j = -1 + arraylist.size(); j >= 0; j--)
            if(((GroupMetadata)arraylist.get(j)).gPos >= i)
                continue; /* Loop/switch isn't completed */

        mExpGroupMetadataList = arraylist;
        refreshExpGroupMetadataList(true, false);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setMaxExpGroupCount(int i) {
        mMaxExpGroupCount = i;
    }

    private final DataSetObserver mDataSetObserver = new MyDataSetObserver();
    private ArrayList mExpGroupMetadataList;
    private ExpandableListAdapter mExpandableListAdapter;
    private int mMaxExpGroupCount;
    private int mTotalExpChildrenCount;

}
