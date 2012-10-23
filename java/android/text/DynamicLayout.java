// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.text.style.UpdateLayout;
import android.text.style.WrapTogetherSpan;
import com.android.internal.util.ArrayUtils;
import java.lang.ref.WeakReference;

// Referenced classes of package android.text:
//            Layout, StaticLayout, TextDirectionHeuristics, PackedIntVector, 
//            PackedObjectVector, TextPaint, Spannable, Spanned, 
//            TextUtils, TextDirectionHeuristic, TextWatcher, SpanWatcher, 
//            Editable

public class DynamicLayout extends Layout {
    private static class ChangeWatcher
        implements TextWatcher, SpanWatcher {

        private void reflow(CharSequence charsequence, int i, int j, int k) {
            DynamicLayout dynamiclayout = (DynamicLayout)mLayout.get();
            if(dynamiclayout == null) goto _L2; else goto _L1
_L1:
            dynamiclayout.reflow(charsequence, i, j, k);
_L4:
            return;
_L2:
            if(charsequence instanceof Spannable)
                ((Spannable)charsequence).removeSpan(this);
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k) {
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i, int j) {
            if(obj instanceof UpdateLayout)
                reflow(spannable, i, j - i, j - i);
        }

        public void onSpanChanged(Spannable spannable, Object obj, int i, int j, int k, int l) {
            if(obj instanceof UpdateLayout) {
                reflow(spannable, i, j - i, j - i);
                reflow(spannable, k, l - k, l - k);
            }
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i, int j) {
            if(obj instanceof UpdateLayout)
                reflow(spannable, i, j - i, j - i);
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k) {
            reflow(charsequence, i, j, k);
        }

        private WeakReference mLayout;

        public ChangeWatcher(DynamicLayout dynamiclayout) {
            mLayout = new WeakReference(dynamiclayout);
        }
    }


    public DynamicLayout(CharSequence charsequence, TextPaint textpaint, int i, Layout.Alignment alignment, float f, float f1, boolean flag) {
        this(charsequence, charsequence, textpaint, i, alignment, f, f1, flag);
    }

    public DynamicLayout(CharSequence charsequence, CharSequence charsequence1, TextPaint textpaint, int i, Layout.Alignment alignment, float f, float f1, 
            boolean flag) {
        this(charsequence, charsequence1, textpaint, i, alignment, f, f1, flag, null, 0);
    }

    public DynamicLayout(CharSequence charsequence, CharSequence charsequence1, TextPaint textpaint, int i, Layout.Alignment alignment, float f, float f1, 
            boolean flag, TextUtils.TruncateAt truncateat, int j) {
        this(charsequence, charsequence1, textpaint, i, alignment, TextDirectionHeuristics.FIRSTSTRONG_LTR, f, f1, flag, truncateat, j);
    }

    public DynamicLayout(CharSequence charsequence, CharSequence charsequence1, TextPaint textpaint, int i, Layout.Alignment alignment, TextDirectionHeuristic textdirectionheuristic, float f, 
            float f1, boolean flag, TextUtils.TruncateAt truncateat, int j) {
        Object obj;
        int ai[];
        Layout.Directions adirections[];
        android.graphics.Paint.FontMetricsInt fontmetricsint;
        int k;
        int l;
        if(truncateat == null)
            obj = charsequence1;
        else
        if(charsequence1 instanceof Spanned)
            obj = new Layout.SpannedEllipsizer(charsequence1);
        else
            obj = new Layout.Ellipsizer(charsequence1);
        super(((CharSequence) (obj)), textpaint, i, alignment, textdirectionheuristic, f, f1);
        mBase = charsequence;
        mDisplay = charsequence1;
        if(truncateat != null) {
            mInts = new PackedIntVector(5);
            mEllipsizedWidth = j;
            mEllipsizeAt = truncateat;
        } else {
            mInts = new PackedIntVector(3);
            mEllipsizedWidth = i;
            mEllipsizeAt = null;
        }
        mObjects = new PackedObjectVector(1);
        mIncludePad = flag;
        if(truncateat != null) {
            Layout.Ellipsizer ellipsizer = (Layout.Ellipsizer)getText();
            ellipsizer.mLayout = this;
            ellipsizer.mWidth = j;
            ellipsizer.mMethod = truncateat;
            mEllipsize = true;
        }
        if(truncateat != null) {
            ai = new int[5];
            ai[3] = 0x80000000;
        } else {
            ai = new int[3];
        }
        adirections = new Layout.Directions[1];
        adirections[0] = DIRS_ALL_LEFT_TO_RIGHT;
        fontmetricsint = textpaint.getFontMetricsInt();
        k = fontmetricsint.ascent;
        l = fontmetricsint.descent;
        ai[0] = 0x40000000;
        ai[1] = 0;
        ai[2] = l;
        mInts.insertAt(0, ai);
        ai[1] = l - k;
        mInts.insertAt(1, ai);
        mObjects.insertAt(0, adirections);
        reflow(charsequence, 0, 0, charsequence.length());
        if(charsequence instanceof Spannable) {
            if(mWatcher == null)
                mWatcher = new ChangeWatcher(this);
            Spannable spannable = (Spannable)charsequence;
            ChangeWatcher achangewatcher[] = (ChangeWatcher[])spannable.getSpans(0, spannable.length(), android/text/DynamicLayout$ChangeWatcher);
            for(int i1 = 0; i1 < achangewatcher.length; i1++)
                spannable.removeSpan(achangewatcher[i1]);

            spannable.setSpan(mWatcher, 0, charsequence.length(), 0x800012);
        }
    }

    private void addBlockAtOffset(int i) {
        int j = getLineForOffset(i);
        if(mBlockEndLines != null) goto _L2; else goto _L1
_L1:
        mBlockEndLines = new int[ArrayUtils.idealIntArraySize(1)];
        mBlockEndLines[mNumberOfBlocks] = j;
        mNumberOfBlocks = 1 + mNumberOfBlocks;
_L4:
        return;
_L2:
        if(j > mBlockEndLines[-1 + mNumberOfBlocks]) {
            if(mNumberOfBlocks == mBlockEndLines.length) {
                int ai[] = new int[ArrayUtils.idealIntArraySize(1 + mNumberOfBlocks)];
                System.arraycopy(mBlockEndLines, 0, ai, 0, mNumberOfBlocks);
                mBlockEndLines = ai;
            }
            mBlockEndLines[mNumberOfBlocks] = j;
            mNumberOfBlocks = 1 + mNumberOfBlocks;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void createBlocks() {
        int i = 400;
        mNumberOfBlocks = 0;
        CharSequence charsequence = mDisplay;
        do {
            int j = TextUtils.indexOf(charsequence, '\n', i);
            if(j < 0) {
                addBlockAtOffset(charsequence.length());
                mBlockIndices = new int[mBlockEndLines.length];
                for(int k = 0; k < mBlockEndLines.length; k++)
                    mBlockIndices[k] = -1;

                break;
            }
            addBlockAtOffset(j);
            i = j + 400;
        } while(true);
    }

    private void reflow(CharSequence charsequence, int i, int j, int k) {
        if(charsequence == mBase) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int l3;
        int j4;
        StaticLayout staticlayout;
        int k5;
        CharSequence charsequence1 = mDisplay;
        int l = charsequence1.length();
        int i1 = TextUtils.lastIndexOf(charsequence1, '\n', i - 1);
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        if(i1 < 0)
            j1 = 0;
        else
            j1 = i1 + 1;
        k1 = i - j1;
        l1 = j + k1;
        i2 = k + k1;
        j2 = i - k1;
        k2 = TextUtils.indexOf(charsequence1, '\n', j2 + i2);
        if(k2 < 0)
            l2 = l;
        else
            l2 = k2 + 1;
        i3 = l2 - (j2 + i2);
        j3 = l1 + i3;
        k3 = i2 + i3;
        if(charsequence1 instanceof Spanned) {
            Spanned spanned = (Spanned)charsequence1;
            boolean flag1;
            do {
                flag1 = false;
                int i8 = j2 + k3;
                Object aobj2[] = spanned.getSpans(j2, i8, android/text/style/WrapTogetherSpan);
                int j8 = 0;
                do {
                    int k8 = aobj2.length;
                    if(j8 >= k8)
                        break;
                    int l8 = spanned.getSpanStart(aobj2[j8]);
                    int i9 = spanned.getSpanEnd(aobj2[j8]);
                    if(l8 < j2) {
                        flag1 = true;
                        int k9 = j2 - l8;
                        j3 += k9;
                        k3 += k9;
                        j2 -= k9;
                    }
                    if(i9 > j2 + k3) {
                        flag1 = true;
                        int j9 = i9 - (j2 + k3);
                        j3 += j9;
                        k3 += j9;
                    }
                    j8++;
                } while(true);
            } while(flag1);
        }
        l3 = getLineForOffset(j2);
        int i4 = getLineTop(l3);
        j4 = getLineForOffset(j2 + j3);
        if(j2 + k3 == l)
            j4 = getLineCount();
        int k4 = getLineTop(j4);
        int l4 = getLineCount();
        boolean flag;
        int i5;
        TextPaint textpaint;
        int j5;
        TextDirectionHeuristic textdirectionheuristic;
        float f;
        float f1;
        float f2;
        TextUtils.TruncateAt truncateat;
        int l5;
        int i6;
        int j6;
        int ai[];
        Layout.Directions adirections[];
        int k6;
        if(j4 == l4)
            flag = true;
        else
            flag = false;
        synchronized(sLock) {
            staticlayout = sStaticLayout;
            sStaticLayout = null;
        }
        if(staticlayout == null)
            staticlayout = new StaticLayout(null);
        else
            staticlayout.prepare();
        i5 = j2 + k3;
        textpaint = getPaint();
        j5 = getWidth();
        textdirectionheuristic = getTextDirectionHeuristic();
        f = getSpacingMultiplier();
        f1 = getSpacingAdd();
        f2 = mEllipsizedWidth;
        truncateat = mEllipsizeAt;
        staticlayout.generate(charsequence1, j2, i5, textpaint, j5, textdirectionheuristic, f, f1, false, true, f2, truncateat);
        k5 = staticlayout.getLineCount();
        if(j2 + k3 != l && staticlayout.getLineStart(k5 - 1) == j2 + k3)
            k5--;
        mInts.deleteAt(l3, j4 - l3);
        mObjects.deleteAt(l3, j4 - l3);
        l5 = staticlayout.getLineTop(k5);
        i6 = 0;
        j6 = 0;
        if(mIncludePad && l3 == 0) {
            i6 = staticlayout.getTopPadding();
            mTopPadding = i6;
            l5 -= i6;
        }
        if(mIncludePad && flag) {
            j6 = staticlayout.getBottomPadding();
            mBottomPadding = j6;
            l5 += j6;
        }
        mInts.adjustValuesBelow(l3, 0, k3 - j3);
        mInts.adjustValuesBelow(l3, 1, l5 + (i4 - k4));
        if(mEllipsize) {
            ai = new int[5];
            ai[3] = 0x80000000;
        } else {
            ai = new int[3];
        }
        adirections = new Layout.Directions[1];
        k6 = 0;
        while(k6 < k5)  {
            int l6 = staticlayout.getLineStart(k6) | staticlayout.getParagraphDirection(k6) << 30;
            int i7;
            int j7;
            int k7;
            int l7;
            if(staticlayout.getLineContainsTab(k6))
                i7 = 0x20000000;
            else
                i7 = 0;
            ai[0] = i7 | l6;
            j7 = i4 + staticlayout.getLineTop(k6);
            if(k6 > 0)
                j7 -= i6;
            ai[1] = j7;
            k7 = staticlayout.getLineDescent(k6);
            l7 = k5 - 1;
            if(k6 == l7)
                k7 += j6;
            ai[2] = k7;
            adirections[0] = staticlayout.getLineDirections(k6);
            if(mEllipsize) {
                ai[3] = staticlayout.getEllipsisStart(k6);
                ai[4] = staticlayout.getEllipsisCount(k6);
            }
            mInts.insertAt(l3 + k6, ai);
            mObjects.insertAt(l3 + k6, adirections);
            k6++;
        }
        break MISSING_BLOCK_LABEL_911;
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
        updateBlocks(l3, j4 - 1, k5);
        Object aobj1[] = sLock;
        aobj1;
        JVM INSTR monitorenter ;
        sStaticLayout = staticlayout;
        staticlayout.finish();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int[] getBlockEndLines() {
        return mBlockEndLines;
    }

    public int[] getBlockIndices() {
        return mBlockIndices;
    }

    public int getBottomPadding() {
        return mBottomPadding;
    }

    public int getEllipsisCount(int i) {
        int j;
        if(mEllipsizeAt == null)
            j = 0;
        else
            j = mInts.getValue(i, 4);
        return j;
    }

    public int getEllipsisStart(int i) {
        int j;
        if(mEllipsizeAt == null)
            j = 0;
        else
            j = mInts.getValue(i, 3);
        return j;
    }

    public int getEllipsizedWidth() {
        return mEllipsizedWidth;
    }

    public boolean getLineContainsTab(int i) {
        boolean flag = false;
        if((0x20000000 & mInts.getValue(i, 0)) != 0)
            flag = true;
        return flag;
    }

    public int getLineCount() {
        return -1 + mInts.size();
    }

    public int getLineDescent(int i) {
        return mInts.getValue(i, 2);
    }

    public final Layout.Directions getLineDirections(int i) {
        return (Layout.Directions)mObjects.getValue(i, 0);
    }

    public int getLineStart(int i) {
        return 0x1fffffff & mInts.getValue(i, 0);
    }

    public int getLineTop(int i) {
        return mInts.getValue(i, 1);
    }

    public int getNumberOfBlocks() {
        return mNumberOfBlocks;
    }

    public int getParagraphDirection(int i) {
        return mInts.getValue(i, 0) >> 30;
    }

    public int getTopPadding() {
        return mTopPadding;
    }

    void setBlocksDataForTest(int ai[], int ai1[], int i) {
        mBlockEndLines = new int[ai.length];
        mBlockIndices = new int[ai1.length];
        System.arraycopy(ai, 0, mBlockEndLines, 0, ai.length);
        System.arraycopy(ai1, 0, mBlockIndices, 0, ai1.length);
        mNumberOfBlocks = i;
    }

    void updateBlocks(int i, int j, int k) {
        if(mBlockEndLines != null) goto _L2; else goto _L1
_L1:
        createBlocks();
_L10:
        return;
_L2:
        int l;
        int i1;
        int j1;
        l = -1;
        i1 = -1;
        j1 = 0;
_L7:
        if(j1 >= mNumberOfBlocks) goto _L4; else goto _L3
_L3:
        if(mBlockEndLines[j1] < i) goto _L6; else goto _L5
_L5:
        l = j1;
_L4:
        int k1 = l;
_L8:
        if(k1 < mNumberOfBlocks) {
            if(mBlockEndLines[k1] < j)
                break MISSING_BLOCK_LABEL_206;
            i1 = k1;
        }
        int l1 = mBlockEndLines[i1];
        int i2;
        boolean flag;
        boolean flag1;
        boolean flag2;
        int j2;
        int k2;
        int l2;
        if(l == 0)
            i2 = 0;
        else
            i2 = 1 + mBlockEndLines[l - 1];
        if(i > i2)
            flag = true;
        else
            flag = false;
        if(k > 0)
            flag1 = true;
        else
            flag1 = false;
        if(j < mBlockEndLines[i1])
            flag2 = true;
        else
            flag2 = false;
        j2 = 0;
        if(flag)
            j2 = 0 + 1;
        if(flag1)
            j2++;
        if(flag2)
            j2++;
        k2 = 1 + (i1 - l);
        l2 = (j2 + mNumberOfBlocks) - k2;
        if(l2 == 0) {
            mBlockEndLines[0] = 0;
            mBlockIndices[0] = -1;
            mNumberOfBlocks = 1;
        } else {
            int i3;
            if(l2 > mBlockEndLines.length) {
                int l3 = ArrayUtils.idealIntArraySize(l2);
                int ai1[] = new int[l3];
                int ai2[] = new int[l3];
                System.arraycopy(mBlockEndLines, 0, ai1, 0, l);
                System.arraycopy(mBlockIndices, 0, ai2, 0, l);
                System.arraycopy(mBlockEndLines, i1 + 1, ai1, l + j2, -1 + (mNumberOfBlocks - i1));
                System.arraycopy(mBlockIndices, i1 + 1, ai2, l + j2, -1 + (mNumberOfBlocks - i1));
                mBlockEndLines = ai1;
                mBlockIndices = ai2;
            } else {
                System.arraycopy(mBlockEndLines, i1 + 1, mBlockEndLines, l + j2, -1 + (mNumberOfBlocks - i1));
                System.arraycopy(mBlockIndices, i1 + 1, mBlockIndices, l + j2, -1 + (mNumberOfBlocks - i1));
            }
            mNumberOfBlocks = l2;
            i3 = k - (1 + (j - i));
            for(int j3 = l + j2; j3 < mNumberOfBlocks; j3++) {
                int ai[] = mBlockEndLines;
                ai[j3] = i3 + ai[j3];
            }

            int k3 = l;
            if(flag) {
                mBlockEndLines[k3] = i - 1;
                mBlockIndices[k3] = -1;
                k3++;
            }
            if(flag1) {
                mBlockEndLines[k3] = -1 + (i + k);
                mBlockIndices[k3] = -1;
                k3++;
            }
            if(flag2) {
                mBlockEndLines[k3] = l1 + i3;
                mBlockIndices[k3] = -1;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        j1++;
          goto _L7
        k1++;
          goto _L8
        if(true) goto _L10; else goto _L9
_L9:
    }

    private static final int BLOCK_MINIMUM_CHARACTER_LENGTH = 400;
    private static final int COLUMNS_ELLIPSIZE = 5;
    private static final int COLUMNS_NORMAL = 3;
    private static final int DESCENT = 2;
    private static final int DIR = 0;
    private static final int DIR_SHIFT = 30;
    private static final int ELLIPSIS_COUNT = 4;
    private static final int ELLIPSIS_START = 3;
    private static final int ELLIPSIS_UNDEFINED = 0x80000000;
    public static final int INVALID_BLOCK_INDEX = -1;
    private static final int PRIORITY = 128;
    private static final int START = 0;
    private static final int START_MASK = 0x1fffffff;
    private static final int TAB = 0;
    private static final int TAB_MASK = 0x20000000;
    private static final int TOP = 1;
    private static final Object sLock[] = new Object[0];
    private static StaticLayout sStaticLayout = new StaticLayout(null);
    private CharSequence mBase;
    private int mBlockEndLines[];
    private int mBlockIndices[];
    private int mBottomPadding;
    private CharSequence mDisplay;
    private boolean mEllipsize;
    private TextUtils.TruncateAt mEllipsizeAt;
    private int mEllipsizedWidth;
    private boolean mIncludePad;
    private PackedIntVector mInts;
    private int mNumberOfBlocks;
    private PackedObjectVector mObjects;
    private int mTopPadding;
    private ChangeWatcher mWatcher;


}
