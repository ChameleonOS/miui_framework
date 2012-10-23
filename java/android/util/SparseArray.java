// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import com.android.internal.util.ArrayUtils;

public class SparseArray
    implements Cloneable {

    public SparseArray() {
        this(10);
    }

    public SparseArray(int i) {
        mGarbage = false;
        int j = ArrayUtils.idealIntArraySize(i);
        mKeys = new int[j];
        mValues = new Object[j];
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

    private void gc() {
        int i = mSize;
        int j = 0;
        int ai[] = mKeys;
        Object aobj[] = mValues;
        for(int k = 0; k < i; k++) {
            Object obj = aobj[k];
            if(obj == DELETED)
                continue;
            if(k != j) {
                ai[j] = ai[k];
                aobj[j] = obj;
                aobj[k] = null;
            }
            j++;
        }

        mGarbage = false;
        mSize = j;
    }

    public void append(int i, Object obj) {
        if(mSize != 0 && i <= mKeys[-1 + mSize]) {
            put(i, obj);
        } else {
            if(mGarbage && mSize >= mKeys.length)
                gc();
            int j = mSize;
            if(j >= mKeys.length) {
                int k = ArrayUtils.idealIntArraySize(j + 1);
                int ai[] = new int[k];
                Object aobj[] = new Object[k];
                System.arraycopy(mKeys, 0, ai, 0, mKeys.length);
                System.arraycopy(((Object) (mValues)), 0, ((Object) (aobj)), 0, mValues.length);
                mKeys = ai;
                mValues = aobj;
            }
            mKeys[j] = i;
            mValues[j] = obj;
            mSize = j + 1;
        }
    }

    public void clear() {
        int i = mSize;
        Object aobj[] = mValues;
        for(int j = 0; j < i; j++)
            aobj[j] = null;

        mSize = 0;
        mGarbage = false;
    }

    public SparseArray clone() {
        SparseArray sparsearray = null;
        try {
            sparsearray = (SparseArray)super.clone();
            sparsearray.mKeys = (int[])mKeys.clone();
            sparsearray.mValues = (Object[])((Object []) (mValues)).clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception) { }
        return sparsearray;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public void delete(int i) {
        int j = binarySearch(mKeys, 0, mSize, i);
        if(j >= 0 && mValues[j] != DELETED) {
            mValues[j] = DELETED;
            mGarbage = true;
        }
    }

    public Object get(int i) {
        return get(i, null);
    }

    public Object get(int i, Object obj) {
        int j = binarySearch(mKeys, 0, mSize, i);
        if(j >= 0 && mValues[j] != DELETED)
            obj = mValues[j];
        return obj;
    }

    public int indexOfKey(int i) {
        if(mGarbage)
            gc();
        return binarySearch(mKeys, 0, mSize, i);
    }

    public int indexOfValue(Object obj) {
        int i;
        if(mGarbage)
            gc();
        i = 0;
_L3:
        if(i >= mSize)
            break MISSING_BLOCK_LABEL_39;
        if(mValues[i] != obj) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i++;
          goto _L3
        i = -1;
          goto _L1
    }

    public int keyAt(int i) {
        if(mGarbage)
            gc();
        return mKeys[i];
    }

    public void put(int i, Object obj) {
        int j = binarySearch(mKeys, 0, mSize, i);
        if(j >= 0) {
            mValues[j] = obj;
        } else {
            int k = ~j;
            if(k < mSize && mValues[k] == DELETED) {
                mKeys[k] = i;
                mValues[k] = obj;
            } else {
                if(mGarbage && mSize >= mKeys.length) {
                    gc();
                    k = -1 ^ binarySearch(mKeys, 0, mSize, i);
                }
                if(mSize >= mKeys.length) {
                    int l = ArrayUtils.idealIntArraySize(1 + mSize);
                    int ai[] = new int[l];
                    Object aobj[] = new Object[l];
                    System.arraycopy(mKeys, 0, ai, 0, mKeys.length);
                    System.arraycopy(((Object) (mValues)), 0, ((Object) (aobj)), 0, mValues.length);
                    mKeys = ai;
                    mValues = aobj;
                }
                if(mSize - k != 0) {
                    System.arraycopy(mKeys, k, mKeys, k + 1, mSize - k);
                    System.arraycopy(((Object) (mValues)), k, ((Object) (mValues)), k + 1, mSize - k);
                }
                mKeys[k] = i;
                mValues[k] = obj;
                mSize = 1 + mSize;
            }
        }
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        if(mValues[i] != DELETED) {
            mValues[i] = DELETED;
            mGarbage = true;
        }
    }

    public void setValueAt(int i, Object obj) {
        if(mGarbage)
            gc();
        mValues[i] = obj;
    }

    public int size() {
        if(mGarbage)
            gc();
        return mSize;
    }

    public Object valueAt(int i) {
        if(mGarbage)
            gc();
        return mValues[i];
    }

    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int mKeys[];
    private int mSize;
    private Object mValues[];

}
