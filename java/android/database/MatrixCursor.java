// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.database:
//            AbstractCursor, CursorIndexOutOfBoundsException, DatabaseUtils

public class MatrixCursor extends AbstractCursor {
    public class RowBuilder {

        public RowBuilder add(Object obj) {
            if(index == endIndex) {
                throw new CursorIndexOutOfBoundsException("No more columns left.");
            } else {
                Object aobj[] = data;
                int i = index;
                index = i + 1;
                aobj[i] = obj;
                return this;
            }
        }

        private final int endIndex;
        private int index;
        final MatrixCursor this$0;

        RowBuilder(int i, int j) {
            this$0 = MatrixCursor.this;
            super();
            index = i;
            endIndex = j;
        }
    }


    public MatrixCursor(String as[]) {
        this(as, 16);
    }

    public MatrixCursor(String as[], int i) {
        rowCount = 0;
        columnNames = as;
        columnCount = as.length;
        if(i < 1)
            i = 1;
        data = new Object[i * columnCount];
    }

    private void addRow(ArrayList arraylist, int i) {
        int j = arraylist.size();
        if(j != columnCount)
            throw new IllegalArgumentException((new StringBuilder()).append("columnNames.length = ").append(columnCount).append(", columnValues.size() = ").append(j).toString());
        rowCount = 1 + rowCount;
        Object aobj[] = data;
        for(int k = 0; k < j; k++)
            aobj[i + k] = arraylist.get(k);

    }

    private void ensureCapacity(int i) {
        if(i > data.length) {
            Object aobj[] = data;
            int j = 2 * data.length;
            if(j < i)
                j = i;
            data = new Object[j];
            System.arraycopy(((Object) (aobj)), 0, ((Object) (data)), 0, aobj.length);
        }
    }

    private Object get(int i) {
        if(i < 0 || i >= columnCount)
            throw new CursorIndexOutOfBoundsException((new StringBuilder()).append("Requested column: ").append(i).append(", # of columns: ").append(columnCount).toString());
        if(super.mPos < 0)
            throw new CursorIndexOutOfBoundsException("Before first row.");
        if(super.mPos >= rowCount)
            throw new CursorIndexOutOfBoundsException("After last row.");
        else
            return data[i + super.mPos * columnCount];
    }

    public void addRow(Iterable iterable) {
        int i = rowCount * columnCount;
        int j = i + columnCount;
        ensureCapacity(j);
        if(iterable instanceof ArrayList) {
            addRow((ArrayList)iterable, i);
        } else {
            int k = i;
            Object aobj[] = data;
            for(Iterator iterator = iterable.iterator(); iterator.hasNext();) {
                Object obj = iterator.next();
                if(k == j)
                    throw new IllegalArgumentException("columnValues.size() > columnNames.length");
                int l = k + 1;
                aobj[k] = obj;
                k = l;
            }

            if(k != j)
                throw new IllegalArgumentException("columnValues.size() < columnNames.length");
            rowCount = 1 + rowCount;
        }
    }

    public void addRow(Object aobj[]) {
        if(aobj.length != columnCount) {
            throw new IllegalArgumentException((new StringBuilder()).append("columnNames.length = ").append(columnCount).append(", columnValues.length = ").append(aobj.length).toString());
        } else {
            int i = rowCount;
            rowCount = i + 1;
            int j = i * columnCount;
            ensureCapacity(j + columnCount);
            System.arraycopy(((Object) (aobj)), 0, ((Object) (data)), j, columnCount);
            return;
        }
    }

    public byte[] getBlob(int i) {
        return (byte[])(byte[])get(i);
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public int getCount() {
        return rowCount;
    }

    public double getDouble(int i) {
        Object obj = get(i);
        double d;
        if(obj == null)
            d = 0.0D;
        else
        if(obj instanceof Number)
            d = ((Number)obj).doubleValue();
        else
            d = Double.parseDouble(obj.toString());
        return d;
    }

    public float getFloat(int i) {
        Object obj = get(i);
        float f;
        if(obj == null)
            f = 0.0F;
        else
        if(obj instanceof Number)
            f = ((Number)obj).floatValue();
        else
            f = Float.parseFloat(obj.toString());
        return f;
    }

    public int getInt(int i) {
        Object obj = get(i);
        int j;
        if(obj == null)
            j = 0;
        else
        if(obj instanceof Number)
            j = ((Number)obj).intValue();
        else
            j = Integer.parseInt(obj.toString());
        return j;
    }

    public long getLong(int i) {
        Object obj = get(i);
        long l;
        if(obj == null)
            l = 0L;
        else
        if(obj instanceof Number)
            l = ((Number)obj).longValue();
        else
            l = Long.parseLong(obj.toString());
        return l;
    }

    public short getShort(int i) {
        Object obj = get(i);
        short word0;
        if(obj == null)
            word0 = 0;
        else
        if(obj instanceof Number)
            word0 = ((Number)obj).shortValue();
        else
            word0 = Short.parseShort(obj.toString());
        return word0;
    }

    public String getString(int i) {
        Object obj = get(i);
        String s;
        if(obj == null)
            s = null;
        else
            s = obj.toString();
        return s;
    }

    public int getType(int i) {
        return DatabaseUtils.getTypeOfObject(get(i));
    }

    public boolean isNull(int i) {
        boolean flag;
        if(get(i) == null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public RowBuilder newRow() {
        rowCount = 1 + rowCount;
        int i = rowCount * columnCount;
        ensureCapacity(i);
        return new RowBuilder(i - columnCount, i);
    }

    private final int columnCount;
    private final String columnNames[];
    private Object data[];
    private int rowCount;

}
