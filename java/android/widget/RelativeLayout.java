// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.*;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.*;

public class RelativeLayout extends ViewGroup {
    private static class DependencyGraph {
        static class Node
            implements Poolable {

            static Node acquire(View view1) {
                Node node = (Node)sPool.acquire();
                node.view = view1;
                return node;
            }

            public Node getNextPoolable() {
                return mNext;
            }

            public volatile Object getNextPoolable() {
                return getNextPoolable();
            }

            public boolean isPooled() {
                return mIsPooled;
            }

            void release() {
                view = null;
                dependents.clear();
                dependencies.clear();
                sPool.release(this);
            }

            public void setNextPoolable(Node node) {
                mNext = node;
            }

            public volatile void setNextPoolable(Object obj) {
                setNextPoolable((Node)obj);
            }

            public void setPooled(boolean flag) {
                mIsPooled = flag;
            }

            private static final int POOL_LIMIT = 100;
            private static final Pool sPool = Pools.synchronizedPool(Pools.finitePool(new PoolableManager() {

                public volatile Poolable newInstance() {
                    return newInstance();
                }

                public Node newInstance() {
                    return new Node();
                }

                public volatile void onAcquired(Poolable poolable) {
                    onAcquired((Node)poolable);
                }

                public void onAcquired(Node node) {
                }

                public volatile void onReleased(Poolable poolable) {
                    onReleased((Node)poolable);
                }

                public void onReleased(Node node) {
                }

            }, 100));
            final SparseArray dependencies = new SparseArray();
            final HashMap dependents = new HashMap();
            private boolean mIsPooled;
            private Node mNext;
            View view;


            Node() {
            }
        }


        private static void appendViewId(Resources resources, Node node, StringBuilder stringbuilder) {
            if(node.view.getId() != -1)
                stringbuilder.append(resources.getResourceEntryName(node.view.getId()));
            else
                stringbuilder.append("NO_ID");
        }

        private ArrayDeque findRoots(int ai[]) {
            SparseArray sparsearray = mKeyNodes;
            ArrayList arraylist = mNodes;
            int i = arraylist.size();
            for(int j = 0; j < i; j++) {
                Node node3 = (Node)arraylist.get(j);
                node3.dependents.clear();
                node3.dependencies.clear();
            }

            for(int k = 0; k < i; k++) {
                Node node1 = (Node)arraylist.get(k);
                int ai1[] = ((LayoutParams)node1.view.getLayoutParams()).mRules;
                int i1 = ai.length;
                int j1 = 0;
                while(j1 < i1)  {
                    int k1 = ai1[ai[j1]];
                    if(k1 > 0) {
                        Node node2 = (Node)sparsearray.get(k1);
                        if(node2 != null && node2 != node1) {
                            node2.dependents.put(node1, this);
                            node1.dependencies.put(k1, node2);
                        }
                    }
                    j1++;
                }
            }

            ArrayDeque arraydeque = mRoots;
            arraydeque.clear();
            for(int l = 0; l < i; l++) {
                Node node = (Node)arraylist.get(l);
                if(node.dependencies.size() == 0)
                    arraydeque.addLast(node);
            }

            return arraydeque;
        }

        private static void printNode(Resources resources, Node node) {
            if(node.dependents.size() == 0) {
                printViewId(resources, node.view);
            } else {
                Iterator iterator = node.dependents.keySet().iterator();
                while(iterator.hasNext())  {
                    Node node1 = (Node)iterator.next();
                    StringBuilder stringbuilder = new StringBuilder();
                    appendViewId(resources, node, stringbuilder);
                    printdependents(resources, node1, stringbuilder);
                }
            }
        }

        static void printViewId(Resources resources, View view) {
            if(view.getId() != -1)
                Log.d("RelativeLayout", resources.getResourceEntryName(view.getId()));
            else
                Log.d("RelativeLayout", "NO_ID");
        }

        private static void printdependents(Resources resources, Node node, StringBuilder stringbuilder) {
            stringbuilder.append(" -> ");
            appendViewId(resources, node, stringbuilder);
            if(node.dependents.size() == 0) {
                Log.d("RelativeLayout", stringbuilder.toString());
            } else {
                Iterator iterator = node.dependents.keySet().iterator();
                while(iterator.hasNext()) 
                    printdependents(resources, (Node)iterator.next(), new StringBuilder(stringbuilder));
            }
        }

        void add(View view) {
            int i = view.getId();
            Node node = Node.acquire(view);
            if(i != -1)
                mKeyNodes.put(i, node);
            mNodes.add(node);
        }

        void clear() {
            ArrayList arraylist = mNodes;
            int i = arraylist.size();
            for(int j = 0; j < i; j++)
                ((Node)arraylist.get(j)).release();

            arraylist.clear();
            mKeyNodes.clear();
            mRoots.clear();
        }

        transient void getSortedViews(View aview[], int ai[]) {
            ArrayDeque arraydeque = findRoots(ai);
            int i = 0;
            do {
                Node node = (Node)arraydeque.pollLast();
                if(node == null)
                    break;
                View view = node.view;
                int j = view.getId();
                int k = i + 1;
                aview[i] = view;
                Iterator iterator = node.dependents.keySet().iterator();
                do {
                    if(!iterator.hasNext())
                        break;
                    Node node1 = (Node)iterator.next();
                    SparseArray sparsearray = node1.dependencies;
                    sparsearray.remove(j);
                    if(sparsearray.size() == 0)
                        arraydeque.add(node1);
                } while(true);
                i = k;
            } while(true);
            if(i < aview.length)
                throw new IllegalStateException("Circular dependencies cannot exist in RelativeLayout");
            else
                return;
        }

        transient void log(Resources resources, int ai[]) {
            for(Iterator iterator = findRoots(ai).iterator(); iterator.hasNext(); printNode(resources, (Node)iterator.next()));
        }

        private SparseArray mKeyNodes;
        private ArrayList mNodes;
        private ArrayDeque mRoots;


        private DependencyGraph() {
            mNodes = new ArrayList();
            mKeyNodes = new SparseArray();
            mRoots = new ArrayDeque();
        }

    }

    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {

        public void addRule(int i) {
            mRules[i] = -1;
        }

        public void addRule(int i, int j) {
            mRules[i] = j;
        }

        public String debug(String s) {
            return (new StringBuilder()).append(s).append("ViewGroup.LayoutParams={ width=").append(sizeToString(super.width)).append(", height=").append(sizeToString(super.height)).append(" }").toString();
        }

        public int[] getRules() {
            return mRules;
        }

        public boolean alignWithParent;
        private int mBottom;
        private int mLeft;
        private int mRight;
        private int mRules[];
        private int mTop;



/*
        static int access$102(LayoutParams layoutparams, int i) {
            layoutparams.mRight = i;
            return i;
        }

*/


/*
        static int access$112(LayoutParams layoutparams, int i) {
            int j = i + layoutparams.mRight;
            layoutparams.mRight = j;
            return j;
        }

*/



/*
        static int access$202(LayoutParams layoutparams, int i) {
            layoutparams.mBottom = i;
            return i;
        }

*/


/*
        static int access$212(LayoutParams layoutparams, int i) {
            int j = i + layoutparams.mBottom;
            layoutparams.mBottom = j;
            return j;
        }

*/



/*
        static int access$302(LayoutParams layoutparams, int i) {
            layoutparams.mLeft = i;
            return i;
        }

*/


/*
        static int access$312(LayoutParams layoutparams, int i) {
            int j = i + layoutparams.mLeft;
            layoutparams.mLeft = j;
            return j;
        }

*/



/*
        static int access$402(LayoutParams layoutparams, int i) {
            layoutparams.mTop = i;
            return i;
        }

*/


/*
        static int access$412(LayoutParams layoutparams, int i) {
            int j = i + layoutparams.mTop;
            layoutparams.mTop = j;
            return j;
        }

*/


        public LayoutParams(int i, int j) {
            super(i, j);
            mRules = new int[16];
        }

        public LayoutParams(Context context, AttributeSet attributeset) {
            TypedArray typedarray;
            int ai[];
            int i;
            int j;
            super(context, attributeset);
            mRules = new int[16];
            typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.RelativeLayout_Layout);
            ai = mRules;
            i = typedarray.getIndexCount();
            j = 0;
_L20:
            int k;
            if(j >= i)
                break MISSING_BLOCK_LABEL_495;
            k = typedarray.getIndex(j);
            k;
            JVM INSTR tableswitch 0 16: default 136
        //                       0 156
        //                       1 170
        //                       2 184
        //                       3 198
        //                       4 212
        //                       5 226
        //                       6 240
        //                       7 255
        //                       8 270
        //                       9 285
        //                       10 315
        //                       11 345
        //                       12 375
        //                       13 405
        //                       14 435
        //                       15 465
        //                       16 142;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L17:
            break MISSING_BLOCK_LABEL_465;
_L1:
            break; /* Loop/switch isn't completed */
_L18:
            break; /* Loop/switch isn't completed */
_L21:
            j++;
            if(true) goto _L20; else goto _L19
_L19:
            alignWithParent = typedarray.getBoolean(k, false);
              goto _L21
_L2:
            ai[0] = typedarray.getResourceId(k, 0);
              goto _L21
_L3:
            ai[1] = typedarray.getResourceId(k, 0);
              goto _L21
_L4:
            ai[2] = typedarray.getResourceId(k, 0);
              goto _L21
_L5:
            ai[3] = typedarray.getResourceId(k, 0);
              goto _L21
_L6:
            ai[4] = typedarray.getResourceId(k, 0);
              goto _L21
_L7:
            ai[5] = typedarray.getResourceId(k, 0);
              goto _L21
_L8:
            ai[6] = typedarray.getResourceId(k, 0);
              goto _L21
_L9:
            ai[7] = typedarray.getResourceId(k, 0);
              goto _L21
_L10:
            ai[8] = typedarray.getResourceId(k, 0);
              goto _L21
_L11:
            byte byte6;
            if(typedarray.getBoolean(k, false))
                byte6 = -1;
            else
                byte6 = 0;
            ai[9] = byte6;
              goto _L21
_L12:
            byte byte5;
            if(typedarray.getBoolean(k, false))
                byte5 = -1;
            else
                byte5 = 0;
            ai[10] = byte5;
              goto _L21
_L13:
            byte byte4;
            if(typedarray.getBoolean(k, false))
                byte4 = -1;
            else
                byte4 = 0;
            ai[11] = byte4;
              goto _L21
_L14:
            byte byte3;
            if(typedarray.getBoolean(k, false))
                byte3 = -1;
            else
                byte3 = 0;
            ai[12] = byte3;
              goto _L21
_L15:
            byte byte2;
            if(typedarray.getBoolean(k, false))
                byte2 = -1;
            else
                byte2 = 0;
            ai[13] = byte2;
              goto _L21
_L16:
            byte byte1;
            if(typedarray.getBoolean(k, false))
                byte1 = -1;
            else
                byte1 = 0;
            ai[14] = byte1;
              goto _L21
            byte byte0;
            if(typedarray.getBoolean(k, false))
                byte0 = -1;
            else
                byte0 = 0;
            ai[15] = byte0;
              goto _L21
            typedarray.recycle();
            return;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
            super(layoutparams);
            mRules = new int[16];
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginlayoutparams) {
            super(marginlayoutparams);
            mRules = new int[16];
        }
    }

    private class TopToBottomLeftToRightComparator
        implements Comparator {

        public int compare(View view, View view1) {
            int i = view.getTop() - view1.getTop();
            if(i == 0) {
                int j = view.getLeft() - view1.getLeft();
                if(j != 0) {
                    i = j;
                } else {
                    int k = view.getHeight() - view1.getHeight();
                    if(k != 0) {
                        i = k;
                    } else {
                        int l = view.getWidth() - view1.getWidth();
                        if(l != 0)
                            i = l;
                        else
                            i = 0;
                    }
                }
            }
            return i;
        }

        public volatile int compare(Object obj, Object obj1) {
            return compare((View)obj, (View)obj1);
        }

        final RelativeLayout this$0;

        private TopToBottomLeftToRightComparator() {
            this$0 = RelativeLayout.this;
            super();
        }

    }


    public RelativeLayout(Context context) {
        super(context);
        mBaselineView = null;
        mGravity = 51;
        mContentBounds = new Rect();
        mSelfBounds = new Rect();
        mTopToBottomLeftToRightSet = null;
        mSortedHorizontalChildren = new View[0];
        mSortedVerticalChildren = new View[0];
        mGraph = new DependencyGraph();
    }

    public RelativeLayout(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mBaselineView = null;
        mGravity = 51;
        mContentBounds = new Rect();
        mSelfBounds = new Rect();
        mTopToBottomLeftToRightSet = null;
        mSortedHorizontalChildren = new View[0];
        mSortedVerticalChildren = new View[0];
        mGraph = new DependencyGraph();
        initFromAttributes(context, attributeset);
    }

    public RelativeLayout(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mBaselineView = null;
        mGravity = 51;
        mContentBounds = new Rect();
        mSelfBounds = new Rect();
        mTopToBottomLeftToRightSet = null;
        mSortedHorizontalChildren = new View[0];
        mSortedVerticalChildren = new View[0];
        mGraph = new DependencyGraph();
        initFromAttributes(context, attributeset);
    }

    private void alignBaseline(View view, LayoutParams layoutparams) {
        int ai[] = layoutparams.getRules();
        int i = getRelatedViewBaseline(ai, 4);
        if(i != -1) {
            LayoutParams layoutparams2 = getRelatedViewParams(ai, 4);
            if(layoutparams2 != null) {
                int j = i + layoutparams2.mTop;
                int k = view.getBaseline();
                if(k != -1)
                    j -= k;
                int l = layoutparams.mBottom - layoutparams.mTop;
                layoutparams.mTop = j;
                layoutparams.mBottom = l + layoutparams.mTop;
            }
        }
        if(mBaselineView != null) goto _L2; else goto _L1
_L1:
        mBaselineView = view;
_L4:
        return;
_L2:
        LayoutParams layoutparams1 = (LayoutParams)mBaselineView.getLayoutParams();
        if(layoutparams.mTop < layoutparams1.mTop || layoutparams.mTop == layoutparams1.mTop && layoutparams.mLeft < layoutparams1.mLeft)
            mBaselineView = view;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void applyHorizontalSizeRules(LayoutParams layoutparams, int i) {
        int ai[] = layoutparams.getRules();
        layoutparams.mLeft = -1;
        layoutparams.mRight = -1;
        LayoutParams layoutparams1 = getRelatedViewParams(ai, 0);
        LayoutParams layoutparams2;
        LayoutParams layoutparams3;
        LayoutParams layoutparams4;
        if(layoutparams1 != null)
            layoutparams.mRight = layoutparams1.mLeft - (((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).leftMargin + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin);
        else
        if(layoutparams.alignWithParent && ai[0] != 0 && i >= 0)
            layoutparams.mRight = i - super.mPaddingRight - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin;
        layoutparams2 = getRelatedViewParams(ai, 1);
        if(layoutparams2 != null)
            layoutparams.mLeft = layoutparams2.mRight + (((android.view.ViewGroup.MarginLayoutParams) (layoutparams2)).rightMargin + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin);
        else
        if(layoutparams.alignWithParent && ai[1] != 0)
            layoutparams.mLeft = super.mPaddingLeft + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin;
        layoutparams3 = getRelatedViewParams(ai, 5);
        if(layoutparams3 != null)
            layoutparams.mLeft = layoutparams3.mLeft + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin;
        else
        if(layoutparams.alignWithParent && ai[5] != 0)
            layoutparams.mLeft = super.mPaddingLeft + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin;
        layoutparams4 = getRelatedViewParams(ai, 7);
        if(layoutparams4 != null)
            layoutparams.mRight = layoutparams4.mRight - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin;
        else
        if(layoutparams.alignWithParent && ai[7] != 0 && i >= 0)
            layoutparams.mRight = i - super.mPaddingRight - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin;
        if(ai[9] != 0)
            layoutparams.mLeft = super.mPaddingLeft + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin;
        if(ai[11] != 0 && i >= 0)
            layoutparams.mRight = i - super.mPaddingRight - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin;
    }

    private void applyVerticalSizeRules(LayoutParams layoutparams, int i) {
        int ai[] = layoutparams.getRules();
        layoutparams.mTop = -1;
        layoutparams.mBottom = -1;
        LayoutParams layoutparams1 = getRelatedViewParams(ai, 2);
        LayoutParams layoutparams2;
        LayoutParams layoutparams3;
        LayoutParams layoutparams4;
        if(layoutparams1 != null)
            layoutparams.mBottom = layoutparams1.mTop - (((android.view.ViewGroup.MarginLayoutParams) (layoutparams1)).topMargin + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin);
        else
        if(layoutparams.alignWithParent && ai[2] != 0 && i >= 0)
            layoutparams.mBottom = i - super.mPaddingBottom - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin;
        layoutparams2 = getRelatedViewParams(ai, 3);
        if(layoutparams2 != null)
            layoutparams.mTop = layoutparams2.mBottom + (((android.view.ViewGroup.MarginLayoutParams) (layoutparams2)).bottomMargin + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin);
        else
        if(layoutparams.alignWithParent && ai[3] != 0)
            layoutparams.mTop = super.mPaddingTop + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin;
        layoutparams3 = getRelatedViewParams(ai, 6);
        if(layoutparams3 != null)
            layoutparams.mTop = layoutparams3.mTop + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin;
        else
        if(layoutparams.alignWithParent && ai[6] != 0)
            layoutparams.mTop = super.mPaddingTop + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin;
        layoutparams4 = getRelatedViewParams(ai, 8);
        if(layoutparams4 != null)
            layoutparams.mBottom = layoutparams4.mBottom - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin;
        else
        if(layoutparams.alignWithParent && ai[8] != 0 && i >= 0)
            layoutparams.mBottom = i - super.mPaddingBottom - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin;
        if(ai[10] != 0)
            layoutparams.mTop = super.mPaddingTop + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin;
        if(ai[12] != 0 && i >= 0)
            layoutparams.mBottom = i - super.mPaddingBottom - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin;
        if(ai[4] != 0)
            mHasBaselineAlignedChild = true;
    }

    private void centerHorizontal(View view, LayoutParams layoutparams, int i) {
        int j = view.getMeasuredWidth();
        int k = (i - j) / 2;
        layoutparams.mLeft = k;
        layoutparams.mRight = k + j;
    }

    private void centerVertical(View view, LayoutParams layoutparams, int i) {
        int j = view.getMeasuredHeight();
        int k = (i - j) / 2;
        layoutparams.mTop = k;
        layoutparams.mBottom = k + j;
    }

    private int getChildMeasureSpec(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1) {
        int i2;
        int j2;
        int i3;
        i2 = 0;
        j2 = 0;
        int k2 = i;
        int l2 = j;
        if(k2 < 0)
            k2 = j1 + l;
        if(l2 < 0)
            l2 = l1 - k1 - i1;
        i3 = l2 - k2;
        if(i < 0 || j < 0) goto _L2; else goto _L1
_L1:
        i2 = 0x40000000;
        j2 = i3;
_L4:
        return android.view.View.MeasureSpec.makeMeasureSpec(j2, i2);
_L2:
        if(k >= 0) {
            i2 = 0x40000000;
            if(i3 >= 0)
                j2 = Math.min(i3, k);
            else
                j2 = k;
        } else
        if(k == -1) {
            i2 = 0x40000000;
            j2 = i3;
        } else
        if(k == -2)
            if(i3 >= 0) {
                i2 = 0x80000000;
                j2 = i3;
            } else {
                i2 = 0;
                j2 = 0;
            }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private View getRelatedView(int ai[], int i) {
        int j = ai[i];
        if(j == 0) goto _L2; else goto _L1
_L1:
        DependencyGraph.Node node = (DependencyGraph.Node)mGraph.mKeyNodes.get(j);
        if(node != null) goto _L4; else goto _L3
_L3:
        View view = null;
_L6:
        return view;
_L4:
        view = node.view;
        do {
            if(view.getVisibility() != 8)
                continue; /* Loop/switch isn't completed */
            int ai1[] = ((LayoutParams)view.getLayoutParams()).getRules();
            DependencyGraph.Node node1 = (DependencyGraph.Node)mGraph.mKeyNodes.get(ai1[i]);
            if(node1 == null) {
                view = null;
                continue; /* Loop/switch isn't completed */
            }
            view = node1.view;
        } while(true);
_L2:
        view = null;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private int getRelatedViewBaseline(int ai[], int i) {
        View view = getRelatedView(ai, i);
        int j;
        if(view != null)
            j = view.getBaseline();
        else
            j = -1;
        return j;
    }

    private LayoutParams getRelatedViewParams(int ai[], int i) {
        View view = getRelatedView(ai, i);
        LayoutParams layoutparams;
        if(view != null && (view.getLayoutParams() instanceof LayoutParams))
            layoutparams = (LayoutParams)view.getLayoutParams();
        else
            layoutparams = null;
        return layoutparams;
    }

    private void initFromAttributes(Context context, AttributeSet attributeset) {
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.RelativeLayout);
        mIgnoreGravity = typedarray.getResourceId(1, -1);
        mGravity = typedarray.getInt(0, mGravity);
        typedarray.recycle();
    }

    private void measureChild(View view, LayoutParams layoutparams, int i, int j) {
        view.measure(getChildMeasureSpec(layoutparams.mLeft, layoutparams.mRight, ((android.view.ViewGroup.LayoutParams) (layoutparams)).width, ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin, ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin, super.mPaddingLeft, super.mPaddingRight, i), getChildMeasureSpec(layoutparams.mTop, layoutparams.mBottom, ((android.view.ViewGroup.LayoutParams) (layoutparams)).height, ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin, ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).bottomMargin, super.mPaddingTop, super.mPaddingBottom, j));
    }

    private void measureChildHorizontal(View view, LayoutParams layoutparams, int i, int j) {
        int k = getChildMeasureSpec(layoutparams.mLeft, layoutparams.mRight, ((android.view.ViewGroup.LayoutParams) (layoutparams)).width, ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin, ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).rightMargin, super.mPaddingLeft, super.mPaddingRight, i);
        int l;
        if(((android.view.ViewGroup.LayoutParams) (layoutparams)).width == -1)
            l = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
        else
            l = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x80000000);
        view.measure(k, l);
    }

    private boolean positionChildHorizontal(View view, LayoutParams layoutparams, int i, boolean flag) {
        boolean flag1;
        int ai[];
        flag1 = true;
        ai = layoutparams.getRules();
        if(layoutparams.mLeft >= 0 || layoutparams.mRight < 0) goto _L2; else goto _L1
_L1:
        layoutparams.mLeft = layoutparams.mRight - view.getMeasuredWidth();
_L5:
        if(ai[11] == 0)
            flag1 = false;
_L7:
        return flag1;
_L2:
        if(layoutparams.mLeft < 0 || layoutparams.mRight >= 0) goto _L4; else goto _L3
_L3:
        layoutparams.mRight = layoutparams.mLeft + view.getMeasuredWidth();
          goto _L5
_L4:
        if(layoutparams.mLeft >= 0 || layoutparams.mRight >= 0) goto _L5; else goto _L6
_L6:
label0:
        {
            if(ai[13] == 0 && ai[14] == 0)
                break label0;
            if(!flag) {
                centerHorizontal(view, layoutparams, i);
            } else {
                layoutparams.mLeft = super.mPaddingLeft + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin;
                layoutparams.mRight = layoutparams.mLeft + view.getMeasuredWidth();
            }
        }
          goto _L7
        layoutparams.mLeft = super.mPaddingLeft + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).leftMargin;
        layoutparams.mRight = layoutparams.mLeft + view.getMeasuredWidth();
          goto _L5
    }

    private boolean positionChildVertical(View view, LayoutParams layoutparams, int i, boolean flag) {
        boolean flag1;
        int ai[];
        flag1 = true;
        ai = layoutparams.getRules();
        if(layoutparams.mTop >= 0 || layoutparams.mBottom < 0) goto _L2; else goto _L1
_L1:
        layoutparams.mTop = layoutparams.mBottom - view.getMeasuredHeight();
_L5:
        if(ai[12] == 0)
            flag1 = false;
_L7:
        return flag1;
_L2:
        if(layoutparams.mTop < 0 || layoutparams.mBottom >= 0) goto _L4; else goto _L3
_L3:
        layoutparams.mBottom = layoutparams.mTop + view.getMeasuredHeight();
          goto _L5
_L4:
        if(layoutparams.mTop >= 0 || layoutparams.mBottom >= 0) goto _L5; else goto _L6
_L6:
label0:
        {
            if(ai[13] == 0 && ai[15] == 0)
                break label0;
            if(!flag) {
                centerVertical(view, layoutparams, i);
            } else {
                layoutparams.mTop = super.mPaddingTop + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin;
                layoutparams.mBottom = layoutparams.mTop + view.getMeasuredHeight();
            }
        }
          goto _L7
        layoutparams.mTop = super.mPaddingTop + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams)).topMargin;
        layoutparams.mBottom = layoutparams.mTop + view.getMeasuredHeight();
          goto _L5
    }

    private void sortChildren() {
        int i = getChildCount();
        if(mSortedVerticalChildren.length != i)
            mSortedVerticalChildren = new View[i];
        if(mSortedHorizontalChildren.length != i)
            mSortedHorizontalChildren = new View[i];
        DependencyGraph dependencygraph = mGraph;
        dependencygraph.clear();
        for(int j = 0; j < i; j++)
            dependencygraph.add(getChildAt(j));

        dependencygraph.getSortedViews(mSortedVerticalChildren, RULES_VERTICAL);
        dependencygraph.getSortedViews(mSortedHorizontalChildren, RULES_HORIZONTAL);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return layoutparams instanceof LayoutParams;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        Iterator iterator;
        if(mTopToBottomLeftToRightSet == null)
            mTopToBottomLeftToRightSet = new TreeSet(new TopToBottomLeftToRightComparator());
        int i = 0;
        for(int j = getChildCount(); i < j; i++)
            mTopToBottomLeftToRightSet.add(getChildAt(i));

        iterator = mTopToBottomLeftToRightSet.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        View view = (View)iterator.next();
        if(view.getVisibility() != 0 || !view.dispatchPopulateAccessibilityEvent(accessibilityevent)) goto _L4; else goto _L3
_L3:
        boolean flag;
        mTopToBottomLeftToRightSet.clear();
        flag = true;
_L6:
        return flag;
_L2:
        mTopToBottomLeftToRightSet.clear();
        flag = false;
        if(true) goto _L6; else goto _L5
_L5:
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return generateLayoutParams(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams) {
        return new LayoutParams(layoutparams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset) {
        return new LayoutParams(getContext(), attributeset);
    }

    public int getBaseline() {
        int i;
        if(mBaselineView != null)
            i = mBaselineView.getBaseline();
        else
            i = super.getBaseline();
        return i;
    }

    public int getGravity() {
        return mGravity;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/RelativeLayout.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/RelativeLayout.getName());
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        int i1 = getChildCount();
        for(int j1 = 0; j1 < i1; j1++) {
            View view = getChildAt(j1);
            if(view.getVisibility() != 8) {
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                view.layout(layoutparams.mLeft, layoutparams.mTop, layoutparams.mRight, layoutparams.mBottom);
            }
        }

    }

    protected void onMeasure(int i, int j) {
        if(mDirtyHierarchy) {
            mDirtyHierarchy = false;
            sortChildren();
        }
        int k = -1;
        int l = -1;
        int i1 = 0;
        int j1 = 0;
        int k1 = android.view.View.MeasureSpec.getMode(i);
        int l1 = android.view.View.MeasureSpec.getMode(j);
        int i2 = android.view.View.MeasureSpec.getSize(i);
        int j2 = android.view.View.MeasureSpec.getSize(j);
        if(k1 != 0)
            k = i2;
        if(l1 != 0)
            l = j2;
        if(k1 == 0x40000000)
            i1 = k;
        if(l1 == 0x40000000)
            j1 = l;
        mHasBaselineAlignedChild = false;
        View view = null;
        int k2 = 0x800007 & mGravity;
        boolean flag;
        int l2;
        boolean flag1;
        int i3;
        int j3;
        int k3;
        int l3;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        View aview[];
        int i4;
        if(k2 != 3 && k2 != 0)
            flag = true;
        else
            flag = false;
        l2 = 0x70 & mGravity;
        if(l2 != 48 && l2 != 0)
            flag1 = true;
        else
            flag1 = false;
        i3 = 0x7fffffff;
        j3 = 0x7fffffff;
        k3 = 0x80000000;
        l3 = 0x80000000;
        flag2 = false;
        flag3 = false;
        if((flag || flag1) && mIgnoreGravity != -1)
            view = findViewById(mIgnoreGravity);
        if(k1 != 0x40000000)
            flag4 = true;
        else
            flag4 = false;
        if(l1 != 0x40000000)
            flag5 = true;
        else
            flag5 = false;
        aview = mSortedHorizontalChildren;
        i4 = aview.length;
        for(int j4 = 0; j4 < i4; j4++) {
            View view6 = aview[j4];
            if(view6.getVisibility() == 8)
                continue;
            LayoutParams layoutparams5 = (LayoutParams)view6.getLayoutParams();
            applyHorizontalSizeRules(layoutparams5, k);
            measureChildHorizontal(view6, layoutparams5, k, l);
            if(positionChildHorizontal(view6, layoutparams5, k, flag4))
                flag2 = true;
        }

        View aview1[] = mSortedVerticalChildren;
        int k4 = aview1.length;
        for(int l4 = 0; l4 < k4; l4++) {
            View view5 = aview1[l4];
            if(view5.getVisibility() == 8)
                continue;
            LayoutParams layoutparams4 = (LayoutParams)view5.getLayoutParams();
            applyVerticalSizeRules(layoutparams4, l);
            measureChild(view5, layoutparams4, k, l);
            if(positionChildVertical(view5, layoutparams4, l, flag5))
                flag3 = true;
            if(flag4) {
                int k10 = layoutparams4.mRight;
                i1 = Math.max(i1, k10);
            }
            if(flag5) {
                int j10 = layoutparams4.mBottom;
                j1 = Math.max(j1, j10);
            }
            if(view5 != view || flag1) {
                int k9 = layoutparams4.mLeft - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams4)).leftMargin;
                i3 = Math.min(i3, k9);
                int l9 = layoutparams4.mTop - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams4)).topMargin;
                j3 = Math.min(j3, l9);
            }
            if(view5 != view || flag) {
                int i10 = layoutparams4.mRight + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams4)).rightMargin;
                k3 = Math.max(k3, i10);
                l3 = Math.max(l3, layoutparams4.mBottom + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams4)).bottomMargin);
            }
        }

        if(mHasBaselineAlignedChild) {
            for(int k8 = 0; k8 < k4; k8++) {
                View view4 = getChildAt(k8);
                if(view4.getVisibility() == 8)
                    continue;
                LayoutParams layoutparams3 = (LayoutParams)view4.getLayoutParams();
                alignBaseline(view4, layoutparams3);
                if(view4 != view || flag1) {
                    int l8 = layoutparams3.mLeft - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams3)).leftMargin;
                    i3 = Math.min(i3, l8);
                    int i9 = layoutparams3.mTop - ((android.view.ViewGroup.MarginLayoutParams) (layoutparams3)).topMargin;
                    j3 = Math.min(j3, i9);
                }
                if(view4 != view || flag) {
                    int j9 = layoutparams3.mRight + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams3)).rightMargin;
                    k3 = Math.max(k3, j9);
                    l3 = Math.max(l3, layoutparams3.mBottom + ((android.view.ViewGroup.MarginLayoutParams) (layoutparams3)).bottomMargin);
                }
            }

        }
        if(flag4) {
            int j7 = i1 + super.mPaddingRight;
            if(super.mLayoutParams.width >= 0) {
                int j8 = super.mLayoutParams.width;
                j7 = Math.max(j7, j8);
            }
            int k7 = getSuggestedMinimumWidth();
            i1 = resolveSize(Math.max(j7, k7), i);
            if(flag2) {
                int l7 = 0;
                while(l7 < k4)  {
                    View view3 = getChildAt(l7);
                    if(view3.getVisibility() != 8) {
                        LayoutParams layoutparams2 = (LayoutParams)view3.getLayoutParams();
                        int ai1[] = layoutparams2.getRules();
                        if(ai1[13] != 0 || ai1[14] != 0)
                            centerHorizontal(view3, layoutparams2, i1);
                        else
                        if(ai1[11] != 0) {
                            int i8 = view3.getMeasuredWidth();
                            layoutparams2.mLeft = i1 - super.mPaddingRight - i8;
                            layoutparams2.mRight = i8 + layoutparams2.mLeft;
                        }
                    }
                    l7++;
                }
            }
        }
        if(flag5) {
            int i6 = j1 + super.mPaddingBottom;
            if(super.mLayoutParams.height >= 0) {
                int i7 = super.mLayoutParams.height;
                i6 = Math.max(i6, i7);
            }
            int j6 = getSuggestedMinimumHeight();
            j1 = resolveSize(Math.max(i6, j6), j);
            if(flag3) {
                int k6 = 0;
                while(k6 < k4)  {
                    View view2 = getChildAt(k6);
                    if(view2.getVisibility() != 8) {
                        LayoutParams layoutparams1 = (LayoutParams)view2.getLayoutParams();
                        int ai[] = layoutparams1.getRules();
                        if(ai[13] != 0 || ai[15] != 0)
                            centerVertical(view2, layoutparams1, j1);
                        else
                        if(ai[12] != 0) {
                            int l6 = view2.getMeasuredHeight();
                            layoutparams1.mTop = j1 - super.mPaddingBottom - l6;
                            layoutparams1.mBottom = l6 + layoutparams1.mTop;
                        }
                    }
                    k6++;
                }
            }
        }
        if(flag || flag1) {
            Rect rect = mSelfBounds;
            rect.set(super.mPaddingLeft, super.mPaddingTop, i1 - super.mPaddingRight, j1 - super.mPaddingBottom);
            Rect rect1 = mContentBounds;
            int i5 = getResolvedLayoutDirection();
            Gravity.apply(mGravity, k3 - i3, l3 - j3, rect, rect1, i5);
            int j5 = rect1.left - i3;
            int k5 = rect1.top - j3;
            if(j5 != 0 || k5 != 0) {
                for(int l5 = 0; l5 < k4; l5++) {
                    View view1 = getChildAt(l5);
                    if(view1.getVisibility() == 8 || view1 == view)
                        continue;
                    LayoutParams layoutparams = (LayoutParams)view1.getLayoutParams();
                    if(flag) {
                        int j = i + 
// JavaClassFileOutputException: get_constant: invalid tag

    public void requestLayout() {
        requestLayout();
        mDirtyHierarchy = true;
    }

    public void setGravity(int i) {
        if(mGravity != i) {
            if((0x800007 & i) == 0)
                i |= 0x800003;
            if((i & 0x70) == 0)
                i |= 0x30;
            mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int j = i & 0x800007;
        if((0x800007 & mGravity) != j) {
            mGravity = j | 0xff7ffff8 & mGravity;
            requestLayout();
        }
    }

    public void setIgnoreGravity(int i) {
        mIgnoreGravity = i;
    }

    public void setVerticalGravity(int i) {
        int j = i & 0x70;
        if((0x70 & mGravity) != j) {
            mGravity = j | 0xffffff8f & mGravity;
            requestLayout();
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public static final int ABOVE = 2;
    public static final int ALIGN_BASELINE = 4;
    public static final int ALIGN_BOTTOM = 8;
    public static final int ALIGN_LEFT = 5;
    public static final int ALIGN_PARENT_BOTTOM = 12;
    public static final int ALIGN_PARENT_LEFT = 9;
    public static final int ALIGN_PARENT_RIGHT = 11;
    public static final int ALIGN_PARENT_TOP = 10;
    public static final int ALIGN_RIGHT = 7;
    public static final int ALIGN_TOP = 6;
    public static final int BELOW = 3;
    public static final int CENTER_HORIZONTAL = 14;
    public static final int CENTER_IN_PARENT = 13;
    public static final int CENTER_VERTICAL = 15;
    private static final boolean DEBUG_GRAPH = false;
    public static final int LEFT_OF = 0;
    private static final String LOG_TAG = "RelativeLayout";
    public static final int RIGHT_OF = 1;
    private static final int RULES_HORIZONTAL[];
    private static final int RULES_VERTICAL[];
    public static final int TRUE = -1;
    private static final int VERB_COUNT = 16;
    private View mBaselineView;
    private final Rect mContentBounds;
    private boolean mDirtyHierarchy;
    private final DependencyGraph mGraph;
    private int mGravity;
    private boolean mHasBaselineAlignedChild;
    private int mIgnoreGravity;
    private final Rect mSelfBounds;
    private View mSortedHorizontalChildren[];
    private View mSortedVerticalChildren[];
    private SortedSet mTopToBottomLeftToRightSet;

    static  {
        int ai[] = new int[5];
        ai[0] = 2;
        ai[1] = 3;
        ai[2] = 4;
        ai[3] = 6;
        ai[4] = 8;
        RULES_VERTICAL = ai;
        int ai1[] = new int[4];
        ai1[0] = 0;
        ai1[1] = 1;
        ai1[2] = 5;
        ai1[3] = 7;
        RULES_HORIZONTAL = ai1;
    }
}
