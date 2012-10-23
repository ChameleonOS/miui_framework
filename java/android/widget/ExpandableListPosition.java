// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import java.util.ArrayList;

// Referenced classes of package android.widget:
//            ExpandableListView

class ExpandableListPosition {

    private ExpandableListPosition() {
    }

    private static ExpandableListPosition getRecycledOrCreate() {
        ArrayList arraylist = sPool;
        arraylist;
        JVM INSTR monitorenter ;
        if(sPool.size() <= 0) goto _L2; else goto _L1
_L1:
        ExpandableListPosition expandablelistposition = (ExpandableListPosition)sPool.remove(0);
        expandablelistposition.resetState();
_L4:
        return expandablelistposition;
_L2:
        expandablelistposition = new ExpandableListPosition();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static ExpandableListPosition obtain(int i, int j, int k, int l) {
        ExpandableListPosition expandablelistposition = getRecycledOrCreate();
        expandablelistposition.type = i;
        expandablelistposition.groupPos = j;
        expandablelistposition.childPos = k;
        expandablelistposition.flatListPos = l;
        return expandablelistposition;
    }

    static ExpandableListPosition obtainChildPosition(int i, int j) {
        return obtain(1, i, j, 0);
    }

    static ExpandableListPosition obtainGroupPosition(int i) {
        return obtain(2, i, 0, 0);
    }

    static ExpandableListPosition obtainPosition(long l) {
        ExpandableListPosition expandablelistposition;
        if(l == 0xffffffffL) {
            expandablelistposition = null;
        } else {
            expandablelistposition = getRecycledOrCreate();
            expandablelistposition.groupPos = ExpandableListView.getPackedPositionGroup(l);
            if(ExpandableListView.getPackedPositionType(l) == 1) {
                expandablelistposition.type = 1;
                expandablelistposition.childPos = ExpandableListView.getPackedPositionChild(l);
            } else {
                expandablelistposition.type = 2;
            }
        }
        return expandablelistposition;
    }

    private void resetState() {
        groupPos = 0;
        childPos = 0;
        flatListPos = 0;
        type = 0;
    }

    long getPackedPosition() {
        long l;
        if(type == 1)
            l = ExpandableListView.getPackedPositionForChild(groupPos, childPos);
        else
            l = ExpandableListView.getPackedPositionForGroup(groupPos);
        return l;
    }

    public void recycle() {
        ArrayList arraylist = sPool;
        arraylist;
        JVM INSTR monitorenter ;
        if(sPool.size() < 5)
            sPool.add(this);
        return;
    }

    public static final int CHILD = 1;
    public static final int GROUP = 2;
    private static final int MAX_POOL_SIZE = 5;
    private static ArrayList sPool = new ArrayList(5);
    public int childPos;
    int flatListPos;
    public int groupPos;
    public int type;

}
