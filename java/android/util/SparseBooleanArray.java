// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import com.android.internal.util.ArrayUtils;

public class SparseBooleanArray
    implements Cloneable {

    public SparseBooleanArray() {
        this(10);
    }

    public SparseBooleanArray(int i) {
        int j = ArrayUtils.idealIntArraySize(i);
        mKeys = new int[j];
        mValues = new boolean[j];
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

    public void append(int i, boolean flag) {
        if(mSize != 0 && i <= mKeys[-1 + mSize]) {
            put(i, flag);
        } else {
            int j = mSize;
            if(j >= mKeys.length) {
                int k = ArrayUtils.idealIntArraySize(j + 1);
                int ai[] = new int[k];
                boolean aflag[] = new boolean[k];
                System.arraycopy(mKeys, 0, ai, 0, mKeys.length);
                System.arraycopy(mValues, 0, aflag, 0, mValues.length);
                mKeys = ai;
                mValues = aflag;
            }
            mKeys[j] = i;
            mValues[j] = flag;
            mSize = j + 1;
        }
    }

    public void clear() {
        mSize = 0;
    }

    public SparseBooleanArray clone() {
        SparseBooleanArray sparsebooleanarray = null;
        try {
            sparsebooleanarray = (SparseBooleanArray)super.clone();
            sparsebooleanarray.mKeys = (int[])mKeys.clone();
            sparsebooleanarray.mValues = (boolean[])mValues.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception) { }
        return sparsebooleanarray;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public void delete(int i) {
        int j = binarySearch(mKeys, 0, mSize, i);
        if(j >= 0) {
            System.arraycopy(mKeys, j + 1, mKeys, j, mSize - (j + 1));
            System.arraycopy(mValues, j + 1, mValues, j, mSize - (j + 1));
            mSize = -1 + mSize;
        }
    }

    public boolean get(int i) {
        return get(i, false);
    }

    public boolean get(int i, boolean flag) {
        int j = binarySearch(mKeys, 0, mSize, i);
        if(j >= 0)
            flag = mValues[j];
        return flag;
    }

    public int indexOfKey(int i) {
        return binarySearch(mKeys, 0, mSize, i);
    }

    public int indexOfValue(boolean flag) {
        int i = 0;
_L3:
        if(i >= mSize)
            break MISSING_BLOCK_LABEL_28;
        if(mValues[i] != flag) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i++;
          goto _L3
        i = -1;
          goto _L1
    }

    public int keyAt(int i) {
        return mKeys[i];
    }

    public void put(int i, boolean flag) {
        int j = binarySearch(mKeys, 0, mSize, i);
        if(j >= 0) {
            mValues[j] = flag;
        } else {
            int k = ~j;
            if(mSize >= mKeys.length) {
                int l = ArrayUtils.idealIntArraySize(1 + mSize);
                int ai[] = new int[l];
                boolean aflag[] = new boolean[l];
                System.arraycopy(mKeys, 0, ai, 0, mKeys.length);
                System.arraycopy(mValues, 0, aflag, 0, mValues.length);
                mKeys = ai;
                mValues = aflag;
            }
            if(mSize - k != 0) {
                System.arraycopy(mKeys, k, mKeys, k + 1, mSize - k);
                System.arraycopy(mValues, k, mValues, k + 1, mSize - k);
            }
            mKeys[k] = i;
            mValues[k] = flag;
            mSize = 1 + mSize;
        }
    }

    public int size() {
        return mSize;
    }

    public boolean valueAt(int i) {
        return mValues[i];
    }

    private int mKeys[];
    private int mSize;
    private boolean mValues[];
}
