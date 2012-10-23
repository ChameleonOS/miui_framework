// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;


// Referenced classes of package android.database:
//            AbstractCursor, StaleDataException, CursorWindow, CharArrayBuffer

public abstract class AbstractWindowedCursor extends AbstractCursor {

    public AbstractWindowedCursor() {
    }

    protected void checkPosition() {
        super.checkPosition();
        if(mWindow == null)
            throw new StaleDataException("Attempting to access a closed CursorWindow.Most probable cause: cursor is deactivated prior to calling this method.");
        else
            return;
    }

    protected void clearOrCreateWindow(String s) {
        if(mWindow == null)
            mWindow = new CursorWindow(s);
        else
            mWindow.clear();
    }

    protected void closeWindow() {
        if(mWindow != null) {
            mWindow.close();
            mWindow = null;
        }
    }

    public void copyStringToBuffer(int i, CharArrayBuffer chararraybuffer) {
        checkPosition();
        mWindow.copyStringToBuffer(super.mPos, i, chararraybuffer);
    }

    public byte[] getBlob(int i) {
        checkPosition();
        return mWindow.getBlob(super.mPos, i);
    }

    public double getDouble(int i) {
        checkPosition();
        return mWindow.getDouble(super.mPos, i);
    }

    public float getFloat(int i) {
        checkPosition();
        return mWindow.getFloat(super.mPos, i);
    }

    public int getInt(int i) {
        checkPosition();
        return mWindow.getInt(super.mPos, i);
    }

    public long getLong(int i) {
        checkPosition();
        return mWindow.getLong(super.mPos, i);
    }

    public short getShort(int i) {
        checkPosition();
        return mWindow.getShort(super.mPos, i);
    }

    public String getString(int i) {
        checkPosition();
        return mWindow.getString(super.mPos, i);
    }

    public int getType(int i) {
        checkPosition();
        return mWindow.getType(super.mPos, i);
    }

    public CursorWindow getWindow() {
        return mWindow;
    }

    public boolean hasWindow() {
        boolean flag;
        if(mWindow != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isBlob(int i) {
        boolean flag;
        if(getType(i) == 4)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isFloat(int i) {
        boolean flag;
        if(getType(i) == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isLong(int i) {
        boolean flag = true;
        if(getType(i) != flag)
            flag = false;
        return flag;
    }

    public boolean isNull(int i) {
        checkPosition();
        boolean flag;
        if(mWindow.getType(super.mPos, i) == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isString(int i) {
        boolean flag;
        if(getType(i) == 3)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected void onDeactivateOrClose() {
        super.onDeactivateOrClose();
        closeWindow();
    }

    public void setWindow(CursorWindow cursorwindow) {
        if(cursorwindow != mWindow) {
            closeWindow();
            mWindow = cursorwindow;
        }
    }

    protected CursorWindow mWindow;
}
