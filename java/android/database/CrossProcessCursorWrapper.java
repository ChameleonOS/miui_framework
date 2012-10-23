// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;


// Referenced classes of package android.database:
//            CursorWrapper, CrossProcessCursor, DatabaseUtils, Cursor, 
//            CursorWindow

public class CrossProcessCursorWrapper extends CursorWrapper
    implements CrossProcessCursor {

    public CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public void fillWindow(int i, CursorWindow cursorwindow) {
        if(super.mCursor instanceof CrossProcessCursor)
            ((CrossProcessCursor)super.mCursor).fillWindow(i, cursorwindow);
        else
            DatabaseUtils.cursorFillWindow(super.mCursor, i, cursorwindow);
    }

    public CursorWindow getWindow() {
        CursorWindow cursorwindow;
        if(super.mCursor instanceof CrossProcessCursor)
            cursorwindow = ((CrossProcessCursor)super.mCursor).getWindow();
        else
            cursorwindow = null;
        return cursorwindow;
    }

    public boolean onMove(int i, int j) {
        boolean flag;
        if(super.mCursor instanceof CrossProcessCursor)
            flag = ((CrossProcessCursor)super.mCursor).onMove(i, j);
        else
            flag = true;
        return flag;
    }
}
