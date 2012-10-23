// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import com.android.internal.util.ArrayUtils;

class PackedIntVector {

    public PackedIntVector(int i) {
        mColumns = i;
        mRows = 0;
        mRowGapStart = 0;
        mRowGapLength = mRows;
        mValues = null;
        mValueGap = new int[i * 2];
    }

    private final void growBuffer() {
        int i = mColumns;
        int j = ArrayUtils.idealIntArraySize(i * (1 + size())) / i;
        int ai[] = new int[j * i];
        int ai1[] = mValueGap;
        int k = mRowGapStart;
        int l = mRows - (k + mRowGapLength);
        if(mValues != null) {
            System.arraycopy(mValues, 0, ai, 0, i * k);
            System.arraycopy(mValues, i * (mRows - l), ai, i * (j - l), l * i);
        }
        for(int i1 = 0; i1 < i; i1++) {
            if(ai1[i1] < k)
                continue;
            ai1[i1] = ai1[i1] + (j - mRows);
            if(ai1[i1] < k)
                ai1[i1] = k;
        }

        mRowGapLength = mRowGapLength + (j - mRows);
        mRows = j;
        mValues = ai;
    }

    private final void moveRowGapTo(int i) {
        if(i != mRowGapStart) {
            if(i > mRowGapStart) {
                int i2 = (i + mRowGapLength) - (mRowGapStart + mRowGapLength);
                int j2 = mColumns;
                int ai2[] = mValueGap;
                int ai3[] = mValues;
                int k2 = mRowGapStart + mRowGapLength;
                for(int l2 = k2; l2 < k2 + i2; l2++) {
                    int i3 = (l2 - k2) + mRowGapStart;
                    for(int j3 = 0; j3 < j2; j3++) {
                        int k3 = ai3[j3 + l2 * j2];
                        if(l2 >= ai2[j3])
                            k3 += ai2[j3 + j2];
                        if(i3 >= ai2[j3])
                            k3 -= ai2[j3 + j2];
                        ai3[j3 + i3 * j2] = k3;
                    }

                }

            } else {
                int j = mRowGapStart - i;
                int k = mColumns;
                int ai[] = mValueGap;
                int ai1[] = mValues;
                int l = mRowGapStart + mRowGapLength;
                for(int i1 = -1 + (i + j); i1 >= i; i1--) {
                    int j1 = (l + (i1 - i)) - j;
                    for(int k1 = 0; k1 < k; k1++) {
                        int l1 = ai1[k1 + i1 * k];
                        if(i1 >= ai[k1])
                            l1 += ai[k1 + k];
                        if(j1 >= ai[k1])
                            l1 -= ai[k1 + k];
                        ai1[k1 + j1 * k] = l1;
                    }

                }

            }
            mRowGapStart = i;
        }
    }

    private final void moveValueGapTo(int i, int j) {
        int ai[] = mValueGap;
        int ai1[] = mValues;
        int k = mColumns;
        if(j != ai[i]) {
            if(j > ai[i]) {
                for(int j1 = ai[i]; j1 < j; j1++) {
                    int k1 = i + j1 * k;
                    ai1[k1] = ai1[k1] + ai[i + k];
                }

            } else {
                for(int l = j; l < ai[i]; l++) {
                    int i1 = i + l * k;
                    ai1[i1] = ai1[i1] - ai[i + k];
                }

            }
            ai[i] = j;
        }
    }

    private void setValueInternal(int i, int j, int k) {
        if(i >= mRowGapStart)
            i += mRowGapLength;
        int ai[] = mValueGap;
        if(i >= ai[j])
            k -= ai[j + mColumns];
        mValues[j + i * mColumns] = k;
    }

    public void adjustValuesBelow(int i, int j, int k) {
        if((i | j) < 0 || i > size() || j >= width())
            throw new IndexOutOfBoundsException((new StringBuilder()).append(i).append(", ").append(j).toString());
        if(i >= mRowGapStart)
            i += mRowGapLength;
        moveValueGapTo(j, i);
        int ai[] = mValueGap;
        int l = j + mColumns;
        ai[l] = k + ai[l];
    }

    public void deleteAt(int i, int j) {
        if((i | j) < 0 || i + j > size()) {
            throw new IndexOutOfBoundsException((new StringBuilder()).append(i).append(", ").append(j).toString());
        } else {
            moveRowGapTo(i + j);
            mRowGapStart = mRowGapStart - j;
            mRowGapLength = j + mRowGapLength;
            return;
        }
    }

    public int getValue(int i, int j) {
        int k = mColumns;
        if((i | j) < 0 || i >= size() || j >= k)
            throw new IndexOutOfBoundsException((new StringBuilder()).append(i).append(", ").append(j).toString());
        if(i >= mRowGapStart)
            i += mRowGapLength;
        int l = mValues[j + i * k];
        int ai[] = mValueGap;
        if(i >= ai[j])
            l += ai[j + k];
        return l;
    }

    public void insertAt(int i, int ai[]) {
        if(i < 0 || i > size())
            throw new IndexOutOfBoundsException((new StringBuilder()).append("row ").append(i).toString());
        if(ai != null && ai.length < width())
            throw new IndexOutOfBoundsException((new StringBuilder()).append("value count ").append(ai.length).toString());
        moveRowGapTo(i);
        if(mRowGapLength == 0)
            growBuffer();
        mRowGapStart = 1 + mRowGapStart;
        mRowGapLength = -1 + mRowGapLength;
        if(ai == null) {
            for(int k = -1 + mColumns; k >= 0; k--)
                setValueInternal(i, k, 0);

        } else {
            for(int j = -1 + mColumns; j >= 0; j--)
                setValueInternal(i, j, ai[j]);

        }
    }

    public void setValue(int i, int j, int k) {
        if((i | j) < 0 || i >= size() || j >= mColumns)
            throw new IndexOutOfBoundsException((new StringBuilder()).append(i).append(", ").append(j).toString());
        if(i >= mRowGapStart)
            i += mRowGapLength;
        int ai[] = mValueGap;
        if(i >= ai[j])
            k -= ai[j + mColumns];
        mValues[j + i * mColumns] = k;
    }

    public int size() {
        return mRows - mRowGapLength;
    }

    public int width() {
        return mColumns;
    }

    private final int mColumns;
    private int mRowGapLength;
    private int mRowGapStart;
    private int mRows;
    private int mValueGap[];
    private int mValues[];
}
