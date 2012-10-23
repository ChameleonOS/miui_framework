// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import com.android.internal.util.ArrayUtils;

public class SparseLongArray
    implements Cloneable {

    public SparseLongArray() {
        this(10);
    }

    public SparseLongArray(int i) {
        int j = ArrayUtils.idealLongArraySize(i);
        mKeys = new int[j];
        mValues = new long[j];
        mSize = 0;
    }

    private static int binarySearch(int ai[], int i, int j, long l) {
        int k;
        k = i + j;
        for(int i1 = i - 1; k - i1 > 1;) {
            int j1 = (k + i1) / 2;
            if((long)ai[j1] < l)
                i1 = j1;
            else
                k = j1;
        }

        if(k != i + j) goto _L2; else goto _L1
_L1:
        k = -1 ^ i + j;
_L4:
        return k;
_L2:
        if((long)ai[k] != l)
            k = ~k;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void growKeyAndValueArrays(int i) {
        int j = ArrayUtils.idealLongArraySize(i);
        int ai[] = new int[j];
        long al[] = new long[j];
        System.arraycopy(mKeys, 0, ai, 0, mKeys.length);
        System.arraycopy(mValues, 0, al, 0, mValues.length);
        mKeys = ai;
        mValues = al;
    }

    public void append(int i, long l) {
        if(mSize != 0 && i <= mKeys[-1 + mSize]) {
            put(i, l);
        } else {
            int j = mSize;
            if(j >= mKeys.length)
                growKeyAndValueArrays(j + 1);
            mKeys[j] = i;
            mValues[j] = l;
            mSize = j + 1;
        }
    }

    public void clear() {
        mSize = 0;
    }

    public SparseLongArray clone() {
        SparseLongArray sparselongarray = null;
        try {
            sparselongarray = (SparseLongArray)super.clone();
            sparselongarray.mKeys = (int[])mKeys.clone();
            sparselongarray.mValues = (long[])mValues.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception) { }
        return sparselongarray;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public void delete(int i) {
        int j = binarySearch(mKeys, 0, mSize, i);
        if(j >= 0)
            removeAt(j);
    }

    public long get(int i) {
        return get(i, 0L);
    }

    public long get(int i, long l) {
        int j = binarySearch(mKeys, 0, mSize, i);
        if(j >= 0)
            l = mValues[j];
        return l;
    }

    public int indexOfKey(int i) {
        return binarySearch(mKeys, 0, mSize, i);
    }

    public int indexOfValue(long l) {
        int i = 0;
_L3:
        if(i >= mSize)
            break MISSING_BLOCK_LABEL_29;
        if(mValues[i] != l) goto _L2; else goto _L1
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

    public void put(int i, long l) {
        int j = binarySearch(mKeys, 0, mSize, i);
        if(j >= 0) {
            mValues[j] = l;
        } else {
            int k = ~j;
            if(mSize >= mKeys.length)
                growKeyAndValueArrays(1 + mSize);
            if(mSize - k != 0) {
                System.arraycopy(mKeys, k, mKeys, k + 1, mSize - k);
                System.arraycopy(mValues, k, mValues, k + 1, mSize - k);
            }
            mKeys[k] = i;
            mValues[k] = l;
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

    public long valueAt(int i) {
        return mValues[i];
    }

    private int mKeys[];
    private int mSize;
    private long mValues[];
}
