// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;


// Referenced classes of package android.text:
//            Layout, Spannable, Spanned, NoCopySpan

public class Selection {
    private static final class END
        implements NoCopySpan {

        private END() {
        }

    }

    private static final class START
        implements NoCopySpan {

        private START() {
        }

    }

    public static interface PositionIterator {

        public abstract int following(int i);

        public abstract int preceding(int i);

        public static final int DONE = -1;
    }


    private Selection() {
    }

    private static int chooseHorizontal(Layout layout, int i, int j, int k) {
        if(layout.getLineForOffset(j) != layout.getLineForOffset(k)) goto _L2; else goto _L1
_L1:
        float f;
        float f1;
        f = layout.getPrimaryHorizontal(j);
        f1 = layout.getPrimaryHorizontal(k);
        if(i >= 0) goto _L4; else goto _L3
_L3:
        if(f >= f1)
            j = k;
_L6:
        return j;
_L4:
        if(f <= f1)
            j = k;
        continue; /* Loop/switch isn't completed */
_L2:
        if(layout.getParagraphDirection(layout.getLineForOffset(j)) == i)
            j = Math.max(j, k);
        else
            j = Math.min(j, k);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static boolean extendDown(Spannable spannable, Layout layout) {
        int i;
        int j;
        i = getSelectionEnd(spannable);
        j = layout.getLineForOffset(i);
        if(j >= -1 + layout.getLineCount()) goto _L2; else goto _L1
_L1:
        int k;
        if(layout.getParagraphDirection(j) == layout.getParagraphDirection(j + 1)) {
            float f = layout.getPrimaryHorizontal(i);
            k = layout.getOffsetForHorizontal(j + 1, f);
        } else {
            k = layout.getLineStart(j + 1);
        }
        extendSelection(spannable, k);
_L4:
        return true;
_L2:
        if(i != spannable.length())
            extendSelection(spannable, spannable.length());
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean extendLeft(Spannable spannable, Layout layout) {
        int i = getSelectionEnd(spannable);
        int j = layout.getOffsetToLeftOf(i);
        if(j != i)
            extendSelection(spannable, j);
        return true;
    }

    public static boolean extendRight(Spannable spannable, Layout layout) {
        int i = getSelectionEnd(spannable);
        int j = layout.getOffsetToRightOf(i);
        if(j != i)
            extendSelection(spannable, j);
        return true;
    }

    public static final void extendSelection(Spannable spannable, int i) {
        if(spannable.getSpanStart(SELECTION_END) != i)
            spannable.setSpan(SELECTION_END, i, i, 34);
    }

    public static boolean extendToLeftEdge(Spannable spannable, Layout layout) {
        extendSelection(spannable, findEdge(spannable, layout, -1));
        return true;
    }

    public static boolean extendToRightEdge(Spannable spannable, Layout layout) {
        extendSelection(spannable, findEdge(spannable, layout, 1));
        return true;
    }

    public static boolean extendUp(Spannable spannable, Layout layout) {
        int i;
        int j;
        i = getSelectionEnd(spannable);
        j = layout.getLineForOffset(i);
        if(j <= 0) goto _L2; else goto _L1
_L1:
        int k;
        if(layout.getParagraphDirection(j) == layout.getParagraphDirection(j - 1)) {
            float f = layout.getPrimaryHorizontal(i);
            k = layout.getOffsetForHorizontal(j - 1, f);
        } else {
            k = layout.getLineStart(j - 1);
        }
        extendSelection(spannable, k);
_L4:
        return true;
_L2:
        if(i != 0)
            extendSelection(spannable, 0);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static int findEdge(Spannable spannable, Layout layout, int i) {
        int j = layout.getLineForOffset(getSelectionEnd(spannable));
        if(i * layout.getParagraphDirection(j) >= 0) goto _L2; else goto _L1
_L1:
        int k = layout.getLineStart(j);
_L4:
        return k;
_L2:
        k = layout.getLineEnd(j);
        if(j != -1 + layout.getLineCount())
            k--;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final int getSelectionEnd(CharSequence charsequence) {
        int i;
        if(charsequence instanceof Spanned)
            i = ((Spanned)charsequence).getSpanStart(SELECTION_END);
        else
            i = -1;
        return i;
    }

    public static final int getSelectionStart(CharSequence charsequence) {
        int i;
        if(charsequence instanceof Spanned)
            i = ((Spanned)charsequence).getSpanStart(SELECTION_START);
        else
            i = -1;
        return i;
    }

    public static boolean moveDown(Spannable spannable, Layout layout) {
        boolean flag;
        int i;
        int j;
        flag = false;
        i = getSelectionStart(spannable);
        j = getSelectionEnd(spannable);
        if(i == j) goto _L2; else goto _L1
_L1:
        int i1 = Math.min(i, j);
        int j1 = Math.max(i, j);
        setSelection(spannable, j1);
        if(i1 != 0 || j1 != spannable.length())
            flag = true;
_L4:
        return flag;
_L2:
        int k = layout.getLineForOffset(j);
        if(k < -1 + layout.getLineCount()) {
            int l;
            if(layout.getParagraphDirection(k) == layout.getParagraphDirection(k + 1)) {
                float f = layout.getPrimaryHorizontal(j);
                l = layout.getOffsetForHorizontal(k + 1, f);
            } else {
                l = layout.getLineStart(k + 1);
            }
            setSelection(spannable, l);
            flag = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean moveLeft(Spannable spannable, Layout layout) {
        boolean flag = true;
        int i = getSelectionStart(spannable);
        int j = getSelectionEnd(spannable);
        if(i != j) {
            setSelection(spannable, chooseHorizontal(layout, -1, i, j));
        } else {
            int k = layout.getOffsetToLeftOf(j);
            if(k != j)
                setSelection(spannable, k);
            else
                flag = false;
        }
        return flag;
    }

    public static boolean moveRight(Spannable spannable, Layout layout) {
        boolean flag = true;
        int i = getSelectionStart(spannable);
        int j = getSelectionEnd(spannable);
        if(i != j) {
            setSelection(spannable, chooseHorizontal(layout, flag, i, j));
        } else {
            int k = layout.getOffsetToRightOf(j);
            if(k != j)
                setSelection(spannable, k);
            else
                flag = false;
        }
        return flag;
    }

    public static boolean moveToFollowing(Spannable spannable, PositionIterator positioniterator, boolean flag) {
        int i = positioniterator.following(getSelectionEnd(spannable));
        if(i != -1)
            if(flag)
                extendSelection(spannable, i);
            else
                setSelection(spannable, i);
        return true;
    }

    public static boolean moveToLeftEdge(Spannable spannable, Layout layout) {
        setSelection(spannable, findEdge(spannable, layout, -1));
        return true;
    }

    public static boolean moveToPreceding(Spannable spannable, PositionIterator positioniterator, boolean flag) {
        int i = positioniterator.preceding(getSelectionEnd(spannable));
        if(i != -1)
            if(flag)
                extendSelection(spannable, i);
            else
                setSelection(spannable, i);
        return true;
    }

    public static boolean moveToRightEdge(Spannable spannable, Layout layout) {
        setSelection(spannable, findEdge(spannable, layout, 1));
        return true;
    }

    public static boolean moveUp(Spannable spannable, Layout layout) {
        boolean flag;
        int i;
        int j;
        flag = false;
        i = getSelectionStart(spannable);
        j = getSelectionEnd(spannable);
        if(i == j) goto _L2; else goto _L1
_L1:
        int i1 = Math.min(i, j);
        int j1 = Math.max(i, j);
        setSelection(spannable, i1);
        if(i1 != 0 || j1 != spannable.length())
            flag = true;
_L4:
        return flag;
_L2:
        int k = layout.getLineForOffset(j);
        if(k > 0) {
            int l;
            if(layout.getParagraphDirection(k) == layout.getParagraphDirection(k - 1)) {
                float f = layout.getPrimaryHorizontal(j);
                l = layout.getOffsetForHorizontal(k - 1, f);
            } else {
                l = layout.getLineStart(k - 1);
            }
            setSelection(spannable, l);
            flag = true;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final void removeSelection(Spannable spannable) {
        spannable.removeSpan(SELECTION_START);
        spannable.removeSpan(SELECTION_END);
    }

    public static final void selectAll(Spannable spannable) {
        setSelection(spannable, 0, spannable.length());
    }

    public static final void setSelection(Spannable spannable, int i) {
        setSelection(spannable, i, i);
    }

    public static void setSelection(Spannable spannable, int i, int j) {
        int k = getSelectionStart(spannable);
        int l = getSelectionEnd(spannable);
        if(k != i || l != j) {
            spannable.setSpan(SELECTION_START, i, i, 546);
            spannable.setSpan(SELECTION_END, j, j, 34);
        }
    }

    public static final Object SELECTION_END = new END();
    public static final Object SELECTION_START = new START();

}
