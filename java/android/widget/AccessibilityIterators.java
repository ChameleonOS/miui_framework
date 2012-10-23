// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;

// Referenced classes of package android.widget:
//            TextView

final class AccessibilityIterators {
    static class PageTextSegmentIterator extends LineTextSegmentIterator {

        public static PageTextSegmentIterator getInstance() {
            if(sPageInstance == null)
                sPageInstance = new PageTextSegmentIterator();
            return sPageInstance;
        }

        public int[] following(int i) {
            int ai[];
            ai = null;
            break MISSING_BLOCK_LABEL_2;
            if(super.mText.length() > 0 && i < super.mText.length() && mView.getGlobalVisibleRect(mTempRect)) {
                int j = Math.max(0, i);
                int k = super.mLayout.getLineForOffset(j);
                int l = super.mLayout.getLineTop(k) + (mTempRect.height() - mView.getTotalPaddingTop() - mView.getTotalPaddingBottom());
                int i1;
                if(l < super.mLayout.getLineTop(-1 + super.mLayout.getLineCount()))
                    i1 = -1 + super.mLayout.getLineForVertical(l);
                else
                    i1 = -1 + super.mLayout.getLineCount();
                ai = getRange(j, 1 + getLineEdgeIndex(i1, 1));
            }
            return ai;
        }

        public void initialize(TextView textview) {
            super.initialize((Spannable)textview.getIterableTextForAccessibility(), textview.getLayout());
            mView = textview;
        }

        public int[] preceding(int i) {
            int ai[];
            ai = null;
            break MISSING_BLOCK_LABEL_2;
            if(super.mText.length() > 0 && i > 0 && mView.getGlobalVisibleRect(mTempRect)) {
                int j = Math.min(super.mText.length(), i);
                int k = super.mLayout.getLineForOffset(j);
                int l = super.mLayout.getLineTop(k) - (mTempRect.height() - mView.getTotalPaddingTop() - mView.getTotalPaddingBottom());
                int i1;
                if(l > 0)
                    i1 = 1 + super.mLayout.getLineForVertical(l);
                else
                    i1 = 0;
                ai = getRange(getLineEdgeIndex(i1, -1), j);
            }
            return ai;
        }

        private static PageTextSegmentIterator sPageInstance;
        private final Rect mTempRect = new Rect();
        private TextView mView;

        PageTextSegmentIterator() {
        }
    }

    static class LineTextSegmentIterator extends android.view.AbstractTextSegmentIterator {

        public static LineTextSegmentIterator getInstance() {
            if(sLineInstance == null)
                sLineInstance = new LineTextSegmentIterator();
            return sLineInstance;
        }

        public int[] following(int i) {
            int ai[];
            ai = null;
            break MISSING_BLOCK_LABEL_2;
            while(true)  {
                do
                    return ai;
                while(super.mText.length() <= 0 || i >= super.mText.length());
                int k;
                if(i < 0) {
                    k = mLayout.getLineForOffset(0);
                } else {
                    int j = mLayout.getLineForOffset(i);
                    if(getLineEdgeIndex(j, -1) == i)
                        k = j;
                    else
                        k = j + 1;
                }
                if(k < mLayout.getLineCount())
                    ai = getRange(getLineEdgeIndex(k, -1), 1 + getLineEdgeIndex(k, 1));
            }
        }

        protected int getLineEdgeIndex(int i, int j) {
            int k;
            if(j * mLayout.getParagraphDirection(i) < 0)
                k = mLayout.getLineStart(i);
            else
                k = -1 + mLayout.getLineEnd(i);
            return k;
        }

        public void initialize(Spannable spannable, Layout layout) {
            super.mText = spannable.toString();
            mLayout = layout;
        }

        public int[] preceding(int i) {
            int ai[];
            ai = null;
            break MISSING_BLOCK_LABEL_2;
            while(true)  {
                do
                    return ai;
                while(super.mText.length() <= 0 || i <= 0);
                int k;
                if(i > super.mText.length()) {
                    k = mLayout.getLineForOffset(super.mText.length());
                } else {
                    int j = mLayout.getLineForOffset(i);
                    if(1 + getLineEdgeIndex(j, 1) == i)
                        k = j;
                    else
                        k = j - 1;
                }
                if(k >= 0)
                    ai = getRange(getLineEdgeIndex(k, -1), 1 + getLineEdgeIndex(k, 1));
            }
        }

        protected static final int DIRECTION_END = 1;
        protected static final int DIRECTION_START = -1;
        private static LineTextSegmentIterator sLineInstance;
        protected Layout mLayout;

        LineTextSegmentIterator() {
        }
    }


    AccessibilityIterators() {
    }
}
