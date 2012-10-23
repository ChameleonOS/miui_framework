// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;


// Referenced classes of package android.database:
//            AbstractCursor, Cursor, DataSetObserver, ContentObserver

public class MergeCursor extends AbstractCursor {

    public MergeCursor(Cursor acursor[]) {
        mObserver = new DataSetObserver() {

            public void onChanged() {
                mPos = -1;
            }

            public void onInvalidated() {
                mPos = -1;
            }

            final MergeCursor this$0;

             {
                this$0 = MergeCursor.this;
                super();
            }
        };
        mCursors = acursor;
        mCursor = acursor[0];
        int i = 0;
        while(i < mCursors.length)  {
            if(mCursors[i] != null)
                mCursors[i].registerDataSetObserver(mObserver);
            i++;
        }
    }

    public void close() {
        int i = mCursors.length;
        int j = 0;
        while(j < i)  {
            if(mCursors[j] != null)
                mCursors[j].close();
            j++;
        }
        super.close();
    }

    public void deactivate() {
        int i = mCursors.length;
        for(int j = 0; j < i; j++)
            if(mCursors[j] != null)
                mCursors[j].deactivate();

        super.deactivate();
    }

    public byte[] getBlob(int i) {
        return mCursor.getBlob(i);
    }

    public String[] getColumnNames() {
        String as[];
        if(mCursor != null)
            as = mCursor.getColumnNames();
        else
            as = new String[0];
        return as;
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
        int k;
        int l;
        int i1;
        mCursor = null;
        k = 0;
        l = mCursors.length;
        i1 = 0;
_L5:
        if(i1 >= l) goto _L2; else goto _L1
_L1:
        if(mCursors[i1] != null) goto _L4; else goto _L3
_L3:
        i1++;
          goto _L5
_L4:
        if(j >= k + mCursors[i1].getCount())
            break MISSING_BLOCK_LABEL_93;
        mCursor = mCursors[i1];
_L2:
        boolean flag;
        if(mCursor != null)
            flag = mCursor.moveToPosition(j - k);
        else
            flag = false;
        return flag;
        k += mCursors[i1].getCount();
          goto _L3
    }

    public void registerContentObserver(ContentObserver contentobserver) {
        int i = mCursors.length;
        for(int j = 0; j < i; j++)
            if(mCursors[j] != null)
                mCursors[j].registerContentObserver(contentobserver);

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

    public void unregisterContentObserver(ContentObserver contentobserver) {
        int i = mCursors.length;
        for(int j = 0; j < i; j++)
            if(mCursors[j] != null)
                mCursors[j].unregisterContentObserver(contentobserver);

    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver) {
        int i = mCursors.length;
        for(int j = 0; j < i; j++)
            if(mCursors[j] != null)
                mCursors[j].unregisterDataSetObserver(datasetobserver);

    }

    private Cursor mCursor;
    private Cursor mCursors[];
    private DataSetObserver mObserver;
}
