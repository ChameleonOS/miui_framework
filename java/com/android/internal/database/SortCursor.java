// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.database;

import android.database.*;
import android.util.Log;
import java.lang.reflect.Array;

public class SortCursor extends AbstractCursor {

    public SortCursor(Cursor acursor[], String s) {
        mRowNumCache = new int[64];
        mCursorCache = new int[64];
        mLastCacheHit = -1;
        mObserver = new DataSetObserver() ;
        mCursors = acursor;
        int i = mCursors.length;
        mSortColumns = new int[i];
        int j = 0;
        while(j < i)  {
            if(mCursors[j] != null) {
                mCursors[j].registerDataSetObserver(mObserver);
                mCursors[j].moveToFirst();
                mSortColumns[j] = mCursors[j].getColumnIndexOrThrow(s);
            }
            j++;
        }
        mCursor = null;
        String s1 = "";
        int k = 0;
        while(k < i)  {
            if(mCursors[k] != null && !mCursors[k].isAfterLast()) {
                String s2 = mCursors[k].getString(mSortColumns[k]);
                if(mCursor == null || s2.compareToIgnoreCase(s1) < 0) {
                    s1 = s2;
                    mCursor = mCursors[k];
                }
            }
            k++;
        }
        for(int l = -1 + mRowNumCache.length; l >= 0; l--)
            mRowNumCache[l] = -2;

        int ai[] = new int[2];
        ai[0] = 64;
        ai[1] = i;
        mCurRowNumCache = (int[][])Array.newInstance(Integer.TYPE, ai);
    }

    public void close() {
        int i = mCursors.length;
        int j = 0;
        while(j < i)  {
            if(mCursors[j] != null)
                mCursors[j].close();
            j++;
        }
    }

    public void deactivate() {
        int i = mCursors.length;
        int j = 0;
        while(j < i)  {
            if(mCursors[j] != null)
                mCursors[j].deactivate();
            j++;
        }
    }

    public byte[] getBlob(int i) {
        return mCursor.getBlob(i);
    }

    public String[] getColumnNames() {
        if(mCursor == null) goto _L2; else goto _L1
_L1:
        String as[] = mCursor.getColumnNames();
_L4:
        return as;
_L2:
        int i = mCursors.length;
        int j = 0;
        do {
            if(j >= i)
                break;
            if(mCursors[j] != null) {
                as = mCursors[j].getColumnNames();
                continue; /* Loop/switch isn't completed */
            }
            j++;
        } while(true);
        throw new IllegalStateException("No cursor that can return names");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getCount() {
        int i = 0;
        int j = mCursors.length;
        for(int k = 0; k < j; k++)
            if(mCursors[k] != null)
                i += mCursors[k].getCount();

        return i;
    }

    public double getDouble(int i) {
        return mCursor.getDouble(i);
    }

    public float getFloat(int i) {
        return mCursor.getFloat(i);
    }

    public int getInt(int i) {
        return mCursor.getInt(i);
    }

    public long getLong(int i) {
        return mCursor.getLong(i);
    }

    public short getShort(int i) {
        return mCursor.getShort(i);
    }

    public String getString(int i) {
        return mCursor.getString(i);
    }

    public int getType(int i) {
        return mCursor.getType(i);
    }

    public boolean isNull(int i) {
        return mCursor.isNull(i);
    }

    public boolean onMove(int i, int j) {
        boolean flag = true;
        if(i != j) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int k = j % 64;
        if(mRowNumCache[k] == j) {
            int k2 = mCursorCache[k];
            mCursor = mCursors[k2];
            if(mCursor == null) {
                Log.w("SortCursor", "onMove: cache results in a null cursor.");
                flag = false;
            } else {
                mCursor.moveToPosition(mCurRowNumCache[k][k2]);
                mLastCacheHit = k;
            }
            continue; /* Loop/switch isn't completed */
        }
        mCursor = null;
        int l = mCursors.length;
        if(mLastCacheHit >= 0) {
            int j2 = 0;
            while(j2 < l)  {
                if(mCursors[j2] != null)
                    mCursors[j2].moveToPosition(mCurRowNumCache[mLastCacheHit][j2]);
                j2++;
            }
        }
        if(j < i || i == -1) {
            int i1 = 0;
            while(i1 < l)  {
                if(mCursors[i1] != null)
                    mCursors[i1].moveToFirst();
                i1++;
            }
            i = 0;
        }
        if(i < 0)
            i = 0;
        int j1 = -1;
        int k1 = i;
label0:
        do {
label1:
            {
                if(k1 <= j) {
                    String s = "";
                    j1 = -1;
                    int i2 = 0;
                    while(i2 < l)  {
                        if(mCursors[i2] != null && !mCursors[i2].isAfterLast()) {
                            String s1 = mCursors[i2].getString(mSortColumns[i2]);
                            if(j1 < 0 || s1.compareToIgnoreCase(s) < 0) {
                                s = s1;
                                j1 = i2;
                            }
                        }
                        i2++;
                    }
                    if(k1 != j)
                        break label1;
                }
                mCursor = mCursors[j1];
                mRowNumCache[k] = j;
                mCursorCache[k] = j1;
                for(int l1 = 0; l1 < l; l1++)
                    if(mCursors[l1] != null)
                        mCurRowNumCache[k][l1] = mCursors[l1].getPosition();

                break label0;
            }
            if(mCursors[j1] != null)
                mCursors[j1].moveToNext();
            k1++;
        } while(true);
        mLastCacheHit = -1;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver) {
        int i = mCursors.length;
        for(int j = 0; j < i; j++)
            if(mCursors[j] != null)
                mCursors[j].registerDataSetObserver(datasetobserver);

    }

    public boolean requery() {
        int i;
        int j;
        i = mCursors.length;
        j = 0;
_L3:
        if(j >= i)
            break; /* Loop/switch isn't completed */
          goto _L1
_L5:
        j++;
        if(true) goto _L3; else goto _L2
_L1:
        if(mCursors[j] == null || mCursors[j].requery()) goto _L5; else goto _L4
_L4:
        boolean flag = false;
_L7:
        return flag;
_L2:
        flag = true;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver) {
        int i = mCursors.length;
        for(int j = 0; j < i; j++)
            if(mCursors[j] != null)
                mCursors[j].unregisterDataSetObserver(datasetobserver);

    }

    private static final String TAG = "SortCursor";
    private final int ROWCACHESIZE = 64;
    private int mCurRowNumCache[][];
    private Cursor mCursor;
    private int mCursorCache[];
    private Cursor mCursors[];
    private int mLastCacheHit;
    private DataSetObserver mObserver;
    private int mRowNumCache[];
    private int mSortColumns[];


/*
    static int access$002(SortCursor sortcursor, int i) {
        sortcursor.mPos = i;
        return i;
    }

*/


/*
    static int access$102(SortCursor sortcursor, int i) {
        sortcursor.mPos = i;
        return i;
    }

*/
}
