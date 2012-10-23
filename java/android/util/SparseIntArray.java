// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import com.android.internal.util.ArrayUtils;

public class SparseIntArray
    implements Cloneable {

    public SparseIntArray() {
        this(10);
    }

    public SparseIntArray(int i) {
        int j = ArrayUtils.idealIntArraySize(i);
        mKeys = new int[j];
        mValues = new int[j];
        mSize = 0;
    }

    private static int binarySearch(int ai[], int i, int j, int k) {
        int l;
        l = i + j;
        for(int i1 = i - 1; l - i1 > 1;) {
            int j1 = (l + i1) / 2;
            if(ai[j1] < k)
                i1 = j1;
            else
                l = j1;
        }

        if(l != i + j) goto _L2; else goto _L1
_L1:
        l = -1 ^ i + j;
_L4:
        return l;
_L2:
        if(ai[l] != k)
            l = ~l;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void append(int i, int j) {
        if(mSize != 0 && i <= mKeys[-1 + mSize]) {
            put(i, j);
        } else {
            int k = mSize;
            if(k >= mKeys.length) {
                int l = ArrayUtils.idealIntArraySize(k + 1);
                int ai[] = new int[l];
                int ai1[] = new int[l];
                System.arraycopy(mKeys, 0, ai, 0, mKeys.length);
                System.arraycopy(mValues, 0, ai1, 0, mValues.length);
                mKeys = ai;
                mValues = ai1;
            }
            mKeys[k] = i;
            mValues[k] = j;
            mSize = k + 1;
        }
    }

    public void clear() {
        mSize = 0;
    }

    public SparseIntArray clone() {
        SparseIntArray sparseintarray = null;
        try {
            sparseintarray = (SparseIntArray)super.clone();
            sparseintarray.mKeys = (int[])mKeys.clone();
            sparseintarray.mValues = (int[])mValues.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception) { }
        return sparseintarray;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public void delete(int i) {
        int j = binarySearch(mKeys, 0, mSize, i);
        if(j >= 0)
            removeAt(j);
    }

    public int get(int i) {
        return get(i, 0);
    }

    public int get(int i, int j) {
        int k = binarySearch(mKeys, 0, mSize, i);
        if(k >= 0)
            j = mValues[k];
        return j;
    }

    public int indexOfKey(int i) {
        return binarySearch(mKeys, 0, mSize, i);
    }

    public int indexOfValue(int i) {
        int j = 0;
_L3:
        if(j >= mSize)
            break MISSING_BLOCK_LABEL_28;
        if(mValues[j] != i) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        j++;
          goto _L3
        j = -1;
          goto _L1
    }

    public int keyAt(int i) {
        return mKeys[i];
    }

    public void put(int i, int j) {
        int k = binarySearch(mKeys, 0, mSize, i);
        if(k >= 0) {
            mValues[k] = j;
        } else {
            int l = ~k;
            if(mSize >= mKeys.length) {
                int i1 = ArrayUtils.idealIntArraySize(1 + mSize);
                int ai[] = new int[i1];
                int ai1[] = new int[i1];
                System.arraycopy(mKeys, 0, ai, 0, mKeys.length);
                System.arraycopy(mValues, 0, ai1, 0, mValues.length);
                mKeys = ai;
                mValues = ai1;
            }
            if(mSize - l != 0) {
                System.arraycopy(mKeys, l, mKeys, l + 1, mSize - l);
                System.arraycopy(mValues, l, mValues, l + 1, mSize - l);
            }
            mKeys[l] = i;
            mValues[l] = j;
            mSize = 1 + mSize;
        }
    }

    public void removeAt(int i) {
        System.arraycopy(mKeys, i + 1, mKeys, i, mSize - (i + 1));
        System.arraycopy(mValues, i + 1, mValues, i, mSize - (i + 1));
        mSize = -1 + mSize;
    }

    public int size() {
        return mSize;
    }

    public int valueAt(int i) {
        return mValues[i];
    }

    private int mKeys[];
    private int mSize;
    private int mValues[];
}
