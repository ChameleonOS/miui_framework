// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.Rect;
import java.util.*;

// Referenced classes of package android.view:
//            ViewGroup, View, ViewConfiguration

public class FocusFinder {
    private static final class SequentialFocusComparator
        implements Comparator {

        private void getRect(View view, Rect rect) {
            view.getDrawingRect(rect);
            mRoot.offsetDescendantRectToMyCoords(view, rect);
        }

        public int compare(View view, View view1) {
            int i = 0;
            if(view != view1) goto _L2; else goto _L1
_L1:
            return i;
_L2:
            getRect(view, mFirstRect);
            getRect(view1, mSecondRect);
            if(mFirstRect.top < mSecondRect.top)
                i = -1;
            else
            if(mFirstRect.top > mSecondRect.top)
                i = 1;
            else
            if(mFirstRect.left < mSecondRect.left)
                i = -1;
            else
            if(mFirstRect.left > mSecondRect.left)
                i = 1;
            else
            if(mFirstRect.bottom < mSecondRect.bottom)
                i = -1;
            else
            if(mFirstRect.bottom > mSecondRect.bottom)
                i = 1;
            else
            if(mFirstRect.right < mSecondRect.right)
                i = -1;
            else
            if(mFirstRect.right > mSecondRect.right)
                i = 1;
            if(true) goto _L1; else goto _L3
_L3:
        }

        public volatile int compare(Object obj, Object obj1) {
            return compare((View)obj, (View)obj1);
        }

        public void recycle() {
            mRoot = null;
        }

        public void setRoot(ViewGroup viewgroup) {
            mRoot = viewgroup;
        }

        private final Rect mFirstRect;
        private ViewGroup mRoot;
        private final Rect mSecondRect;

        private SequentialFocusComparator() {
            mFirstRect = new Rect();
            mSecondRect = new Rect();
        }

    }


    private FocusFinder() {
        mFocusedRect = new Rect();
        mOtherRect = new Rect();
        mBestCandidateRect = new Rect();
        mSequentialFocusComparator = new SequentialFocusComparator();
        mTempList = new ArrayList();
    }


    private View findNextAccessibilityFocus(ViewGroup viewgroup, View view, Rect rect, int i) {
        ArrayList arraylist = mTempList;
        View view1;
        arraylist.clear();
        viewgroup.addFocusables(arraylist, i, 2);
        view1 = findNextFocus(viewgroup, view, rect, i, arraylist);
        arraylist.clear();
        return view1;
        Exception exception;
        exception;
        arraylist.clear();
        throw exception;
    }

    private View findNextFocus(ViewGroup viewgroup, View view, Rect rect, int i) {
        View view1;
        if((i & 0x1000) != 4096)
            view1 = findNextInputFocus(viewgroup, view, rect, i);
        else
            view1 = findNextAccessibilityFocus(viewgroup, view, rect, i);
        return view1;
    }

    private View findNextFocus(ViewGroup viewgroup, View view, Rect rect, int i, ArrayList arraylist) {
        int j = i & 0xffffefff;
        if(view == null) goto _L2; else goto _L1
_L1:
        if(rect == null)
            rect = mFocusedRect;
        view.getFocusedRect(rect);
        viewgroup.offsetDescendantRectToMyCoords(view, rect);
_L9:
        j;
        JVM INSTR lookupswitch 6: default 92
    //                   1: 259
    //                   2: 259
    //                   17: 275
    //                   33: 275
    //                   66: 275
    //                   130: 275;
           goto _L3 _L4 _L4 _L5 _L5 _L5 _L5
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown direction: ").append(j).toString());
_L2:
        if(rect == null) {
            rect = mFocusedRect;
            switch(j) {
            case 1: // '\001'
                if(viewgroup.isLayoutRtl())
                    setFocusTopLeft(viewgroup, rect);
                else
                    setFocusBottomRight(viewgroup, rect);
                break;

            case 66: // 'B'
            case 130: 
                setFocusTopLeft(viewgroup, rect);
                break;

            case 2: // '\002'
                if(viewgroup.isLayoutRtl())
                    setFocusBottomRight(viewgroup, rect);
                else
                    setFocusTopLeft(viewgroup, rect);
                break;

            case 17: // '\021'
            case 33: // '!'
                setFocusBottomRight(viewgroup, rect);
                break;
            }
        }
          goto _L6
_L4:
        View view1 = findNextInputFocusInRelativeDirection(arraylist, viewgroup, view, rect, j);
_L7:
        return view1;
_L5:
        view1 = findNextInputFocusInAbsoluteDirection(arraylist, viewgroup, view, rect, j);
        if(true) goto _L7; else goto _L6
_L6:
        if(true) goto _L9; else goto _L8
_L8:
    }

    private View findNextInputFocus(ViewGroup viewgroup, View view, Rect rect, int i) {
        View view1;
        view1 = null;
        if(view != null)
            view1 = findNextUserSpecifiedInputFocus(viewgroup, view, i);
        if(view1 == null) goto _L2; else goto _L1
_L1:
        View view2 = view1;
_L4:
        return view2;
_L2:
        ArrayList arraylist = mTempList;
        View view3;
        arraylist.clear();
        viewgroup.addFocusables(arraylist, i);
        if(arraylist.isEmpty())
            break MISSING_BLOCK_LABEL_73;
        view3 = findNextFocus(viewgroup, view, rect, i, arraylist);
        view1 = view3;
        arraylist.clear();
        view2 = view1;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        arraylist.clear();
        throw exception;
    }

    private View findNextInputFocusInRelativeDirection(ArrayList arraylist, ViewGroup viewgroup, View view, Rect rect, int i) {
        mSequentialFocusComparator.setRoot(viewgroup);
        Collections.sort(arraylist, mSequentialFocusComparator);
        int j;
        mSequentialFocusComparator.recycle();
        j = arraylist.size();
        i;
        JVM INSTR tableswitch 1 2: default 52
    //                   1 93
    //                   2 80;
           goto _L1 _L2 _L3
_L1:
        View view1 = (View)arraylist.get(j - 1);
_L5:
        return view1;
        Exception exception;
        exception;
        mSequentialFocusComparator.recycle();
        throw exception;
_L3:
        view1 = getForwardFocusable(viewgroup, view, arraylist, j);
        continue; /* Loop/switch isn't completed */
_L2:
        view1 = getBackwardFocusable(viewgroup, view, arraylist, j);
        if(true) goto _L5; else goto _L4
_L4:
    }

    private View findNextUserSpecifiedInputFocus(ViewGroup viewgroup, View view, int i) {
        View view1 = view.findUserSetNextFocus(viewgroup, i);
        if(view1 == null || !view1.isFocusable() || view1.isInTouchMode() && !view1.isFocusableInTouchMode())
            view1 = null;
        return view1;
    }

    private static View getBackwardFocusable(ViewGroup viewgroup, View view, ArrayList arraylist, int i) {
        View view1;
        if(viewgroup.isLayoutRtl())
            view1 = getNextFocusable(view, arraylist, i);
        else
            view1 = getPreviousFocusable(view, arraylist, i);
        return view1;
    }

    private static View getForwardFocusable(ViewGroup viewgroup, View view, ArrayList arraylist, int i) {
        View view1;
        if(viewgroup.isLayoutRtl())
            view1 = getPreviousFocusable(view, arraylist, i);
        else
            view1 = getNextFocusable(view, arraylist, i);
        return view1;
    }

    public static FocusFinder getInstance() {
        return (FocusFinder)tlFocusFinder.get();
    }

    private static View getNextFocusable(View view, ArrayList arraylist, int i) {
        if(view == null) goto _L2; else goto _L1
_L1:
        int j = arraylist.lastIndexOf(view);
        if(j < 0 || j + 1 >= i) goto _L2; else goto _L3
_L3:
        View view1 = (View)arraylist.get(j + 1);
_L5:
        return view1;
_L2:
        if(!arraylist.isEmpty())
            view1 = (View)arraylist.get(0);
        else
            view1 = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static View getPreviousFocusable(View view, ArrayList arraylist, int i) {
        if(view == null) goto _L2; else goto _L1
_L1:
        int j = arraylist.indexOf(view);
        if(j <= 0) goto _L2; else goto _L3
_L3:
        View view1 = (View)arraylist.get(j - 1);
_L5:
        return view1;
_L2:
        if(!arraylist.isEmpty())
            view1 = (View)arraylist.get(i - 1);
        else
            view1 = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private boolean isTouchCandidate(int i, int j, Rect rect, int k) {
        boolean flag = true;
        k;
        JVM INSTR lookupswitch 4: default 48
    //                   17: 58
    //                   33: 121
    //                   66: 91
    //                   130: 151;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
_L2:
        if(rect.left > i || rect.top > j || j > rect.bottom)
            flag = false;
_L7:
        return flag;
_L4:
        if(rect.left < i || rect.top > j || j > rect.bottom)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        if(rect.top > j || rect.left > i || i > rect.right)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L5:
        if(rect.top < j || rect.left > i || i > rect.right)
            flag = false;
        if(true) goto _L7; else goto _L6
_L6:
    }

    static int majorAxisDistance(int i, Rect rect, Rect rect1) {
        return Math.max(0, majorAxisDistanceRaw(i, rect, rect1));
    }

    static int majorAxisDistanceRaw(int i, Rect rect, Rect rect1) {
        i;
        JVM INSTR lookupswitch 4: default 44
    //                   17: 54
    //                   33: 79
    //                   66: 66
    //                   130: 92;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
_L2:
        int j = rect.left - rect1.right;
_L7:
        return j;
_L4:
        j = rect1.left - rect.right;
        continue; /* Loop/switch isn't completed */
_L3:
        j = rect.top - rect1.bottom;
        continue; /* Loop/switch isn't completed */
_L5:
        j = rect1.top - rect.bottom;
        if(true) goto _L7; else goto _L6
_L6:
    }

    static int majorAxisDistanceToFarEdge(int i, Rect rect, Rect rect1) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i, rect, rect1));
    }

    static int majorAxisDistanceToFarEdgeRaw(int i, Rect rect, Rect rect1) {
        i;
        JVM INSTR lookupswitch 4: default 44
    //                   17: 54
    //                   33: 79
    //                   66: 66
    //                   130: 92;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
_L2:
        int j = rect.left - rect1.left;
_L7:
        return j;
_L4:
        j = rect1.right - rect.right;
        continue; /* Loop/switch isn't completed */
_L3:
        j = rect.top - rect1.top;
        continue; /* Loop/switch isn't completed */
_L5:
        j = rect1.bottom - rect.bottom;
        if(true) goto _L7; else goto _L6
_L6:
    }

    static int minorAxisDistance(int i, Rect rect, Rect rect1) {
        i;
        JVM INSTR lookupswitch 4: default 44
    //                   17: 54
    //                   33: 83
    //                   66: 54
    //                   130: 83;
           goto _L1 _L2 _L3 _L2 _L3
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
_L2:
        int j = Math.abs((rect.top + rect.height() / 2) - (rect1.top + rect1.height() / 2));
_L5:
        return j;
_L3:
        j = Math.abs((rect.left + rect.width() / 2) - (rect1.left + rect1.width() / 2));
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void setFocusBottomRight(ViewGroup viewgroup, Rect rect) {
        int i = viewgroup.getScrollY() + viewgroup.getHeight();
        int j = viewgroup.getScrollX() + viewgroup.getWidth();
        rect.set(j, i, j, i);
    }

    private void setFocusTopLeft(ViewGroup viewgroup, Rect rect) {
        int i = viewgroup.getScrollY();
        int j = viewgroup.getScrollX();
        rect.set(j, i, j, i);
    }

    boolean beamBeats(int i, Rect rect, Rect rect1, Rect rect2) {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = beamsOverlap(i, rect, rect1);
        if(!beamsOverlap(i, rect, rect2) && flag1) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if(isToDirectionOf(i, rect, rect2) && i != 17 && i != 66 && majorAxisDistance(i, rect, rect1) >= majorAxisDistanceToFarEdge(i, rect, rect2))
            flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    boolean beamsOverlap(int i, Rect rect, Rect rect1) {
        boolean flag = true;
        i;
        JVM INSTR lookupswitch 4: default 48
    //                   17: 58
    //                   33: 89
    //                   66: 58
    //                   130: 89;
           goto _L1 _L2 _L3 _L2 _L3
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
_L2:
        if(rect1.bottom < rect.top || rect1.top > rect.bottom)
            flag = false;
_L5:
        return flag;
_L3:
        if(rect1.right < rect.left || rect1.left > rect.right)
            flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public View findNearestTouchable(ViewGroup viewgroup, int i, int j, int k, int ai[]) {
        ArrayList arraylist;
        int l;
        View view;
        int i1;
        int j1;
        Rect rect;
        Rect rect1;
        int k1;
        arraylist = viewgroup.getTouchables();
        l = 0x7fffffff;
        view = null;
        i1 = arraylist.size();
        j1 = ViewConfiguration.get(((View) (viewgroup)).mContext).getScaledEdgeSlop();
        rect = new Rect();
        rect1 = mOtherRect;
        k1 = 0;
_L5:
        if(k1 >= i1) goto _L2; else goto _L1
_L1:
        View view1;
        view1 = (View)arraylist.get(k1);
        view1.getDrawingRect(rect1);
        viewgroup.offsetRectBetweenParentAndChild(view1, rect1, true, true);
        if(isTouchCandidate(i, j, rect1, k)) goto _L4; else goto _L3
_L3:
        k1++;
          goto _L5
_L4:
        int l1 = 0x7fffffff;
        k;
        JVM INSTR lookupswitch 4: default 156
    //                   17: 269
    //                   33: 293
    //                   66: 283
    //                   130: 307;
           goto _L6 _L7 _L8 _L9 _L10
_L6:
        break; /* Loop/switch isn't completed */
_L10:
        break MISSING_BLOCK_LABEL_307;
_L11:
        if(l1 < j1 && (view == null || rect.contains(rect1) || !rect1.contains(rect) && l1 < l)) {
            l = l1;
            view = view1;
            rect.set(rect1);
            switch(k) {
            case 17: // '\021'
                ai[0] = -l1;
                break;

            case 66: // 'B'
                ai[0] = l1;
                break;

            case 33: // '!'
                ai[1] = -l1;
                break;

            case 130: 
                ai[1] = l1;
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
          goto _L3
_L7:
        l1 = 1 + (i - rect1.right);
          goto _L11
_L9:
        l1 = rect1.left;
          goto _L11
_L8:
        l1 = 1 + (j - rect1.bottom);
          goto _L11
        l1 = rect1.top;
          goto _L11
_L2:
        return view;
        if(true) goto _L3; else goto _L12
_L12:
    }

    public final View findNextFocus(ViewGroup viewgroup, View view, int i) {
        return findNextFocus(viewgroup, view, null, i);
    }

    public View findNextFocusFromRect(ViewGroup viewgroup, Rect rect, int i) {
        mFocusedRect.set(rect);
        return findNextFocus(viewgroup, null, mFocusedRect, i);
    }

    View findNextInputFocusInAbsoluteDirection(ArrayList arraylist, ViewGroup viewgroup, View view, Rect rect, int i) {
        mBestCandidateRect.set(rect);
        int j;
        int k;
        switch(i) {
        case 17: // '\021'
            mBestCandidateRect.offset(1 + rect.width(), 0);
            continue;

        case 66: // 'B'
            mBestCandidateRect.offset(-(1 + rect.width()), 0);
            continue;

        case 33: // '!'
            mBestCandidateRect.offset(0, 1 + rect.height());
            continue;

        case 130: 
            mBestCandidateRect.offset(0, -(1 + rect.height()));
            continue;
        }
        break;
        do {
            View view1 = null;
            j = arraylist.size();
            k = 0;
            while(k < j)  {
                View view2 = (View)arraylist.get(k);
                if(view2 != view && view2 != viewgroup) {
                    view2.getDrawingRect(mOtherRect);
                    viewgroup.offsetDescendantRectToMyCoords(view2, mOtherRect);
                    if(isBetterCandidate(i, rect, mOtherRect, mBestCandidateRect)) {
                        mBestCandidateRect.set(mOtherRect);
                        view1 = view2;
                    }
                }
                k++;
            }
            return view1;
        } while(true);
    }

    int getWeightedDistanceFor(int i, int j) {
        return i * (i * 13) + j * j;
    }

    boolean isBetterCandidate(int i, Rect rect, Rect rect1, Rect rect2) {
        boolean flag = true;
        if(isCandidate(rect, rect1, i)) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if(isCandidate(rect, rect2, i) && !beamBeats(i, rect, rect1, rect2))
            if(beamBeats(i, rect, rect2, rect1))
                flag = false;
            else
            if(getWeightedDistanceFor(majorAxisDistance(i, rect, rect1), minorAxisDistance(i, rect, rect1)) >= getWeightedDistanceFor(majorAxisDistance(i, rect, rect2), minorAxisDistance(i, rect, rect2)))
                flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    boolean isCandidate(Rect rect, Rect rect1, int i) {
        boolean flag = true;
        i;
        JVM INSTR lookupswitch 4: default 48
    //                   17: 58
    //                   33: 139
    //                   66: 100
    //                   130: 178;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
_L2:
        if(rect.right <= rect1.right && rect.left < rect1.right || rect.left <= rect1.left)
            flag = false;
_L7:
        return flag;
_L4:
        if(rect.left >= rect1.left && rect.right > rect1.left || rect.right >= rect1.right)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        if(rect.bottom <= rect1.bottom && rect.top < rect1.bottom || rect.top <= rect1.top)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L5:
        if(rect.top >= rect1.top && rect.bottom > rect1.top || rect.bottom >= rect1.bottom)
            flag = false;
        if(true) goto _L7; else goto _L6
_L6:
    }

    boolean isToDirectionOf(int i, Rect rect, Rect rect1) {
        boolean flag = true;
        i;
        JVM INSTR lookupswitch 4: default 48
    //                   17: 58
    //                   33: 95
    //                   66: 78
    //                   130: 112;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
_L2:
        if(rect.left < rect1.right)
            flag = false;
_L7:
        return flag;
_L4:
        if(rect.right > rect1.left)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        if(rect.top < rect1.bottom)
            flag = false;
        continue; /* Loop/switch isn't completed */
_L5:
        if(rect.bottom > rect1.top)
            flag = false;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private static final ThreadLocal tlFocusFinder = new ThreadLocal() {

        protected FocusFinder initialValue() {
            return new FocusFinder();
        }

        protected volatile Object initialValue() {
            return initialValue();
        }

    };
    final Rect mBestCandidateRect;
    final Rect mFocusedRect;
    final Rect mOtherRect;
    final SequentialFocusComparator mSequentialFocusComparator;
    private final ArrayList mTempList;

}
