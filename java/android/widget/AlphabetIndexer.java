// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.database.Cursor;
import android.database.DataSetObserver;
import android.util.SparseIntArray;
import java.text.Collator;

// Referenced classes of package android.widget:
//            SectionIndexer

public class AlphabetIndexer extends DataSetObserver
    implements SectionIndexer {

    public AlphabetIndexer(Cursor cursor, int i, CharSequence charsequence) {
        mDataCursor = cursor;
        mColumnIndex = i;
        mAlphabet = charsequence;
        mAlphabetLength = charsequence.length();
        mAlphabetArray = new String[mAlphabetLength];
        for(int j = 0; j < mAlphabetLength; j++)
            mAlphabetArray[j] = Character.toString(mAlphabet.charAt(j));

        mAlphaMap = new SparseIntArray(mAlphabetLength);
        if(cursor != null)
            cursor.registerDataSetObserver(this);
        mCollator = Collator.getInstance();
        mCollator.setStrength(0);
    }

    protected int compare(String s, String s1) {
        String s2;
        if(s.length() == 0)
            s2 = " ";
        else
            s2 = s.substring(0, 1);
        return mCollator.compare(s2, s1);
    }

    public int getPositionForSection(int i) {
        SparseIntArray sparseintarray;
        Cursor cursor;
        int j;
        sparseintarray = mAlphaMap;
        cursor = mDataCursor;
        if(cursor == null || mAlphabet == null) {
            j = 0;
        } else {
label0:
            {
                if(i > 0)
                    break label0;
                j = 0;
            }
        }
_L2:
        return j;
        int l;
        int i1;
        int j1;
        int k1;
        char c;
        String s;
        int k = mAlphabetLength;
        if(i >= k)
            i = -1 + mAlphabetLength;
        l = cursor.getPosition();
        i1 = cursor.getCount();
        j1 = 0;
        k1 = i1;
        c = mAlphabet.charAt(i);
        s = Character.toString(c);
        j = sparseintarray.get(c, 0x80000000);
        if(0x80000000 == j)
            break MISSING_BLOCK_LABEL_126;
        if(j >= 0) goto _L2; else goto _L1
_L1:
        k1 = -j;
        if(i > 0) {
            int i2 = sparseintarray.get(mAlphabet.charAt(i - 1), 0x80000000);
            if(i2 != 0x80000000)
                j1 = Math.abs(i2);
        }
        j = (k1 + j1) / 2;
_L8:
        if(j >= k1) goto _L4; else goto _L3
_L3:
        String s1;
        cursor.moveToPosition(j);
        s1 = cursor.getString(mColumnIndex);
        if(s1 != null) goto _L6; else goto _L5
_L5:
        if(j != 0) goto _L7; else goto _L4
_L4:
        sparseintarray.put(c, j);
        cursor.moveToPosition(l);
          goto _L2
_L7:
        j--;
          goto _L8
_L6:
label1:
        {
            int l1 = compare(s1, s);
            if(l1 == 0)
                continue; /* Loop/switch isn't completed */
            if(l1 >= 0)
                break label1;
            j1 = j + 1;
            if(j1 < i1)
                break MISSING_BLOCK_LABEL_281;
            j = i1;
        }
          goto _L4
        k1 = j;
_L10:
        j = (j1 + k1) / 2;
          goto _L8
        if(j1 == j) goto _L4; else goto _L9
_L9:
        k1 = j;
          goto _L10
    }

    public int getSectionForPosition(int i) {
        String s;
        int k;
        int j = mDataCursor.getPosition();
        mDataCursor.moveToPosition(i);
        s = mDataCursor.getString(mColumnIndex);
        mDataCursor.moveToPosition(j);
        k = 0;
_L3:
        if(k >= mAlphabetLength)
            break MISSING_BLOCK_LABEL_91;
        if(compare(s, Character.toString(mAlphabet.charAt(k))) != 0) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        k++;
          goto _L3
        k = 0;
          goto _L1
    }

    public Object[] getSections() {
        return mAlphabetArray;
    }

    public void onChanged() {
        super.onChanged();
        mAlphaMap.clear();
    }

    public void onInvalidated() {
        super.onInvalidated();
        mAlphaMap.clear();
    }

    public void setCursor(Cursor cursor) {
        if(mDataCursor != null)
            mDataCursor.unregisterDataSetObserver(this);
        mDataCursor = cursor;
        if(cursor != null)
            mDataCursor.registerDataSetObserver(this);
        mAlphaMap.clear();
    }

    private SparseIntArray mAlphaMap;
    protected CharSequence mAlphabet;
    private String mAlphabetArray[];
    private int mAlphabetLength;
    private Collator mCollator;
    protected int mColumnIndex;
    protected Cursor mDataCursor;
}
