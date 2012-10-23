// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import com.android.internal.util.ArrayUtils;
import java.io.PrintStream;

class PackedObjectVector {

    public PackedObjectVector(int i) {
        mColumns = i;
        mRows = ArrayUtils.idealIntArraySize(0) / mColumns;
        mRowGapStart = 0;
        mRowGapLength = mRows;
        mValues = new Object[mRows * mColumns];
    }

    private void growBuffer() {
        int i = ArrayUtils.idealIntArraySize((1 + size()) * mColumns) / mColumns;
        Object aobj[] = new Object[i * mColumns];
        int j = mRows - (mRowGapStart + mRowGapLength);
        System.arraycopy(((Object) (mValues)), 0, ((Object) (aobj)), 0, mColumns * mRowGapStart);
        System.arraycopy(((Object) (mValues)), (mRows - j) * mColumns, ((Object) (aobj)), (i - j) * mColumns, j * mColumns);
        mRowGapLength = mRowGapLength + (i - mRows);
        mRows = i;
        mValues = aobj;
    }

    private void moveRowGapTo(int i) {
        if(i != mRowGapStart) {
            if(i > mRowGapStart) {
                int j1 = (i + mRowGapLength) - (mRowGapStart + mRowGapLength);
                for(int k1 = mRowGapStart + mRowGapLength; k1 < j1 + (mRowGapStart + mRowGapLength); k1++) {
                    int l1 = (k1 - (mRowGapStart + mRowGapLength)) + mRowGapStart;
                    for(int i2 = 0; i2 < mColumns; i2++) {
                        Object obj1 = mValues[i2 + k1 * mColumns];
                        mValues[i2 + l1 * mColumns] = obj1;
                    }

                }

            } else {
                int j = mRowGapStart - i;
                for(int k = -1 + (i + j); k >= i; k--) {
                    int l = ((k - i) + mRowGapStart + mRowGapLength) - j;
                    for(int i1 = 0; i1 < mColumns; i1++) {
                        Object obj = mValues[i1 + k * mColumns];
                        mValues[i1 + l * mColumns] = obj;
                    }

                }

            }
            mRowGapStart = i;
        }
    }

    public void deleteAt(int i, int j) {
        moveRowGapTo(i + j);
        mRowGapStart = mRowGapStart - j;
        mRowGapLength = j + mRowGapLength;
        if(mRowGapLength <= 2 * size());
    }

    public void dump() {
        for(int i = 0; i < mRows; i++) {
            int j = 0;
            while(j < mColumns)  {
                Object obj = mValues[j + i * mColumns];
                if(i < mRowGapStart || i >= mRowGapStart + mRowGapLength)
                    System.out.print((new StringBuilder()).append(obj).append(" ").toString());
                else
                    System.out.print((new StringBuilder()).append("(").append(obj).append(") ").toString());
                j++;
            }
            System.out.print(" << \n");
        }

        System.out.print("-----\n\n");
    }

    public Object getValue(int i, int j) {
        if(i >= mRowGapStart)
            i += mRowGapLength;
        return mValues[j + i * mColumns];
    }

    public void insertAt(int i, Object aobj[]) {
        moveRowGapTo(i);
        if(mRowGapLength == 0)
            growBuffer();
        mRowGapStart = 1 + mRowGapStart;
        mRowGapLength = -1 + mRowGapLength;
        if(aobj == null) {
            for(int k = 0; k < mColumns; k++)
                setValue(i, k, null);

        } else {
            for(int j = 0; j < mColumns; j++)
                setValue(i, j, aobj[j]);

        }
    }

    public void setValue(int i, int j, Object obj) {
        if(i >= mRowGapStart)
            i += mRowGapLength;
        mValues[j + i * mColumns] = obj;
    }

    public int size() {
        return mRows - mRowGapLength;
    }

    public int width() {
        return mColumns;
    }

    private int mColumns;
    private int mRowGapLength;
    private int mRowGapStart;
    private int mRows;
    private Object mValues[];
}
