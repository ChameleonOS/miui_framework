// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import java.util.Iterator;

// Referenced classes of package android.database:
//            Cursor

public final class CursorJoiner
    implements Iterator, Iterable {
    public static final class Result extends Enum {

        public static Result valueOf(String s) {
            return (Result)Enum.valueOf(android/database/CursorJoiner$Result, s);
        }

        public static Result[] values() {
            return (Result[])$VALUES.clone();
        }

        private static final Result $VALUES[];
        public static final Result BOTH;
        public static final Result LEFT;
        public static final Result RIGHT;

        static  {
            RIGHT = new Result("RIGHT", 0);
            LEFT = new Result("LEFT", 1);
            BOTH = new Result("BOTH", 2);
            Result aresult[] = new Result[3];
            aresult[0] = RIGHT;
            aresult[1] = LEFT;
            aresult[2] = BOTH;
            $VALUES = aresult;
        }

        private Result(String s, int i) {
            super(s, i);
        }
    }


    public CursorJoiner(Cursor cursor, String as[], Cursor cursor1, String as1[]) {
        if(as.length != as1.length) {
            throw new IllegalArgumentException((new StringBuilder()).append("you must have the same number of columns on the left and right, ").append(as.length).append(" != ").append(as1.length).toString());
        } else {
            mCursorLeft = cursor;
            mCursorRight = cursor1;
            mCursorLeft.moveToFirst();
            mCursorRight.moveToFirst();
            mCompareResultIsValid = false;
            mColumnsLeft = buildColumnIndiciesArray(cursor, as);
            mColumnsRight = buildColumnIndiciesArray(cursor1, as1);
            mValues = new String[2 * mColumnsLeft.length];
            return;
        }
    }

    private int[] buildColumnIndiciesArray(Cursor cursor, String as[]) {
        int ai[] = new int[as.length];
        for(int i = 0; i < as.length; i++)
            ai[i] = cursor.getColumnIndexOrThrow(as[i]);

        return ai;
    }

    private static transient int compareStrings(String as[]) {
        byte byte0;
        int i;
        byte0 = -1;
        if(as.length % 2 != 0)
            throw new IllegalArgumentException("you must specify an even number of values");
        i = 0;
_L5:
        if(i >= as.length)
            break MISSING_BLOCK_LABEL_85;
        if(as[i] != null) goto _L2; else goto _L1
_L1:
        if(as[i + 1] != null) goto _L4; else goto _L3
_L3:
        i += 2;
          goto _L5
_L2:
        if(as[i + 1] != null) goto _L7; else goto _L6
_L6:
        byte0 = 1;
_L4:
        return byte0;
_L7:
        int j = as[i].compareTo(as[i + 1]);
        if(j == 0) goto _L3; else goto _L8
_L8:
        if(j >= 0)
            byte0 = 1;
          goto _L4
        byte0 = 0;
          goto _L4
    }

    private void incrementCursors() {
        if(!mCompareResultIsValid) goto _L2; else goto _L1
_L1:
        class _cls1 {

            static final int $SwitchMap$android$database$CursorJoiner$Result[];

            static  {
                $SwitchMap$android$database$CursorJoiner$Result = new int[Result.values().length];
                NoSuchFieldError nosuchfielderror2;
                try {
                    $SwitchMap$android$database$CursorJoiner$Result[Result.BOTH.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$android$database$CursorJoiner$Result[Result.LEFT.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                $SwitchMap$android$database$CursorJoiner$Result[Result.RIGHT.ordinal()] = 3;
_L2:
                return;
                nosuchfielderror2;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.android.database.CursorJoiner.Result[mCompareResult.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 76
    //                   2 50
    //                   3 63;
           goto _L3 _L4 _L5 _L6
_L3:
        mCompareResultIsValid = false;
_L2:
        return;
_L5:
        mCursorLeft.moveToNext();
        continue; /* Loop/switch isn't completed */
_L6:
        mCursorRight.moveToNext();
        continue; /* Loop/switch isn't completed */
_L4:
        mCursorLeft.moveToNext();
        mCursorRight.moveToNext();
        if(true) goto _L3; else goto _L7
_L7:
    }

    private static void populateValues(String as[], Cursor cursor, int ai[], int i) {
        if(!$assertionsDisabled && i != 0 && i != 1)
            throw new AssertionError();
        for(int j = 0; j < ai.length; j++)
            as[i + j * 2] = cursor.getString(ai[j]);

    }

    public boolean hasNext() {
        boolean flag = false;
        if(!mCompareResultIsValid) goto _L2; else goto _L1
_L1:
        _cls1..SwitchMap.android.database.CursorJoiner.Result[mCompareResult.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 78
    //                   2 106
    //                   3 135;
           goto _L3 _L4 _L5 _L6
_L3:
        throw new IllegalStateException((new StringBuilder()).append("bad value for mCompareResult, ").append(mCompareResult).toString());
_L4:
        if(!mCursorLeft.isLast() || !mCursorRight.isLast())
            flag = true;
_L8:
        return flag;
_L5:
        if(!mCursorLeft.isLast() || !mCursorRight.isAfterLast())
            flag = true;
        continue; /* Loop/switch isn't completed */
_L6:
        if(!mCursorLeft.isAfterLast() || !mCursorRight.isLast())
            flag = true;
        continue; /* Loop/switch isn't completed */
_L2:
        if(!mCursorLeft.isAfterLast() || !mCursorRight.isAfterLast())
            flag = true;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public Iterator iterator() {
        return this;
    }

    public Result next() {
        boolean flag;
        boolean flag1;
        if(!hasNext())
            throw new IllegalStateException("you must only call next() when hasNext() is true");
        incrementCursors();
        if(!$assertionsDisabled && !hasNext())
            throw new AssertionError();
        if(!mCursorLeft.isAfterLast())
            flag = true;
        else
            flag = false;
        if(!mCursorRight.isAfterLast())
            flag1 = true;
        else
            flag1 = false;
        if(!flag || !flag1) goto _L2; else goto _L1
_L1:
        populateValues(mValues, mCursorLeft, mColumnsLeft, 0);
        populateValues(mValues, mCursorRight, mColumnsRight, 1);
        compareStrings(mValues);
        JVM INSTR tableswitch -1 1: default 144
    //                   -1 164
    //                   0 174
    //                   1 184;
           goto _L3 _L4 _L5 _L6
_L3:
        mCompareResultIsValid = true;
        return mCompareResult;
_L4:
        mCompareResult = Result.LEFT;
        continue; /* Loop/switch isn't completed */
_L5:
        mCompareResult = Result.BOTH;
        continue; /* Loop/switch isn't completed */
_L6:
        mCompareResult = Result.RIGHT;
        continue; /* Loop/switch isn't completed */
_L2:
        if(flag) {
            mCompareResult = Result.LEFT;
        } else {
            if(!$assertionsDisabled && !flag1)
                throw new AssertionError();
            mCompareResult = Result.RIGHT;
        }
        if(true) goto _L3; else goto _L7
_L7:
    }

    public volatile Object next() {
        return next();
    }

    public void remove() {
        throw new UnsupportedOperationException("not implemented");
    }

    static final boolean $assertionsDisabled;
    private int mColumnsLeft[];
    private int mColumnsRight[];
    private Result mCompareResult;
    private boolean mCompareResultIsValid;
    private Cursor mCursorLeft;
    private Cursor mCursorRight;
    private String mValues[];

    static  {
        boolean flag;
        if(!android/database/CursorJoiner.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }
}
