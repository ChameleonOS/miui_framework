// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;

// Referenced classes of package android.database:
//            CrossProcessCursor, DataSetObservable, ContentObservable, CursorIndexOutOfBoundsException, 
//            CharArrayBuffer, DatabaseUtils, ContentObserver, CursorWindow, 
//            DataSetObserver

public abstract class AbstractCursor
    implements CrossProcessCursor {
    protected static class SelfContentObserver extends ContentObserver {

        public boolean deliverSelfNotifications() {
            return false;
        }

        public void onChange(boolean flag) {
            AbstractCursor abstractcursor = (AbstractCursor)mCursor.get();
            if(abstractcursor != null)
                abstractcursor.onChange(false);
        }

        WeakReference mCursor;

        public SelfContentObserver(AbstractCursor abstractcursor) {
            super(null);
            mCursor = new WeakReference(abstractcursor);
        }
    }


    public AbstractCursor() {
        mExtras = Bundle.EMPTY;
        mPos = -1;
        mRowIdColumnIndex = -1;
        mCurrentRowID = null;
        mUpdatedRows = new HashMap();
    }

    protected void checkPosition() {
        if(-1 == mPos || getCount() == mPos)
            throw new CursorIndexOutOfBoundsException(mPos, getCount());
        else
            return;
    }

    public void close() {
        mClosed = true;
        mContentObservable.unregisterAll();
        onDeactivateOrClose();
    }

    public void copyStringToBuffer(int i, CharArrayBuffer chararraybuffer) {
        String s = getString(i);
        if(s != null) {
            char ac[] = chararraybuffer.data;
            if(ac == null || ac.length < s.length())
                chararraybuffer.data = s.toCharArray();
            else
                s.getChars(0, s.length(), ac, 0);
            chararraybuffer.sizeCopied = s.length();
        } else {
            chararraybuffer.sizeCopied = 0;
        }
    }

    public void deactivate() {
        onDeactivateOrClose();
    }

    public void fillWindow(int i, CursorWindow cursorwindow) {
        DatabaseUtils.cursorFillWindow(this, i, cursorwindow);
    }

    protected void finalize() {
        if(mSelfObserver != null && mSelfObserverRegistered)
            mContentResolver.unregisterContentObserver(mSelfObserver);
    }

    public byte[] getBlob(int i) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    public int getColumnCount() {
        return getColumnNames().length;
    }

    public int getColumnIndex(String s) {
        String as[];
        int j;
        int k;
        int i = s.lastIndexOf('.');
        if(i != -1) {
            Exception exception = new Exception();
            Log.e("Cursor", (new StringBuilder()).append("requesting column name with table name -- ").append(s).toString(), exception);
            s = s.substring(i + 1);
        }
        as = getColumnNames();
        j = as.length;
        k = 0;
_L3:
        if(k >= j)
            break MISSING_BLOCK_LABEL_97;
        if(!as[k].equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        k++;
          goto _L3
        k = -1;
          goto _L1
    }

    public int getColumnIndexOrThrow(String s) {
        int i = getColumnIndex(s);
        if(i < 0)
            throw new IllegalArgumentException((new StringBuilder()).append("column '").append(s).append("' does not exist").toString());
        else
            return i;
    }

    public String getColumnName(int i) {
        return getColumnNames()[i];
    }

    public abstract String[] getColumnNames();

    public abstract int getCount();

    public abstract double getDouble(int i);

    public Bundle getExtras() {
        return mExtras;
    }

    public abstract float getFloat(int i);

    public abstract int getInt(int i);

    public abstract long getLong(int i);

    public Uri getNotificationUri() {
        return mNotifyUri;
    }

    public final int getPosition() {
        return mPos;
    }

    public abstract short getShort(int i);

    public abstract String getString(int i);

    public int getType(int i) {
        return 3;
    }

    protected Object getUpdatedField(int i) {
        return null;
    }

    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    public CursorWindow getWindow() {
        return null;
    }

    public final boolean isAfterLast() {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_2;
        if(getCount() != 0 && mPos != getCount())
            flag = false;
        return flag;
    }

    public final boolean isBeforeFirst() {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_2;
        if(getCount() != 0 && mPos != -1)
            flag = false;
        return flag;
    }

    public boolean isClosed() {
        return mClosed;
    }

    protected boolean isFieldUpdated(int i) {
        return false;
    }

    public final boolean isFirst() {
        boolean flag;
        if(mPos == 0 && getCount() != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isLast() {
        int i = getCount();
        boolean flag;
        if(mPos == i - 1 && i != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public abstract boolean isNull(int i);

    public final boolean move(int i) {
        return moveToPosition(i + mPos);
    }

    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    public final boolean moveToLast() {
        return moveToPosition(-1 + getCount());
    }

    public final boolean moveToNext() {
        return moveToPosition(1 + mPos);
    }

    public final boolean moveToPosition(int i) {
        boolean flag;
        int j;
        flag = false;
        j = getCount();
        if(i < j) goto _L2; else goto _L1
_L1:
        mPos = j;
_L4:
        return flag;
_L2:
        if(i < 0)
            mPos = -1;
        else
        if(i == mPos) {
            flag = true;
        } else {
            flag = onMove(mPos, i);
            if(!flag) {
                mPos = -1;
            } else {
                mPos = i;
                if(mRowIdColumnIndex != -1)
                    mCurrentRowID = Long.valueOf(getLong(mRowIdColumnIndex));
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final boolean moveToPrevious() {
        return moveToPosition(-1 + mPos);
    }

    protected void onChange(boolean flag) {
        Object obj = mSelfObserverLock;
        obj;
        JVM INSTR monitorenter ;
        mContentObservable.dispatchChange(flag, null);
        if(mNotifyUri != null && flag)
            mContentResolver.notifyChange(mNotifyUri, mSelfObserver);
        return;
    }

    protected void onDeactivateOrClose() {
        if(mSelfObserver != null) {
            mContentResolver.unregisterContentObserver(mSelfObserver);
            mSelfObserverRegistered = false;
        }
        mDataSetObservable.notifyInvalidated();
    }

    public boolean onMove(int i, int j) {
        return true;
    }

    public void registerContentObserver(ContentObserver contentobserver) {
        mContentObservable.registerObserver(contentobserver);
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver) {
        mDataSetObservable.registerObserver(datasetobserver);
    }

    public boolean requery() {
        if(mSelfObserver != null && !mSelfObserverRegistered) {
            mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
            mSelfObserverRegistered = true;
        }
        mDataSetObservable.notifyChanged();
        return true;
    }

    public Bundle respond(Bundle bundle) {
        return Bundle.EMPTY;
    }

    public void setExtras(Bundle bundle) {
        if(bundle == null)
            bundle = Bundle.EMPTY;
        mExtras = bundle;
    }

    public void setNotificationUri(ContentResolver contentresolver, Uri uri) {
        Object obj = mSelfObserverLock;
        obj;
        JVM INSTR monitorenter ;
        mNotifyUri = uri;
        mContentResolver = contentresolver;
        if(mSelfObserver != null)
            mContentResolver.unregisterContentObserver(mSelfObserver);
        mSelfObserver = new SelfContentObserver(this);
        mContentResolver.registerContentObserver(mNotifyUri, true, mSelfObserver);
        mSelfObserverRegistered = true;
        return;
    }

    public void unregisterContentObserver(ContentObserver contentobserver) {
        if(!mClosed)
            mContentObservable.unregisterObserver(contentobserver);
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver) {
        mDataSetObservable.unregisterObserver(datasetobserver);
    }

    private static final String TAG = "Cursor";
    protected boolean mClosed;
    private final ContentObservable mContentObservable = new ContentObservable();
    protected ContentResolver mContentResolver;
    protected Long mCurrentRowID;
    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    private Bundle mExtras;
    private Uri mNotifyUri;
    protected int mPos;
    protected int mRowIdColumnIndex;
    private ContentObserver mSelfObserver;
    private final Object mSelfObserverLock = new Object();
    private boolean mSelfObserverRegistered;
    protected HashMap mUpdatedRows;
}
