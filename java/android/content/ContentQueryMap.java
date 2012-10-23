// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import java.util.*;

// Referenced classes of package android.content:
//            ContentValues

public class ContentQueryMap extends Observable {

    public ContentQueryMap(Cursor cursor, String s, boolean flag, Handler handler) {
        mHandlerForUpdateNotifications = null;
        mKeepUpdated = false;
        mValues = null;
        mDirty = false;
        mCursor = cursor;
        mColumnNames = mCursor.getColumnNames();
        mKeyColumn = mCursor.getColumnIndexOrThrow(s);
        mHandlerForUpdateNotifications = handler;
        setKeepUpdated(flag);
        if(!flag)
            readCursorIntoCache(cursor);
    }

    /**
     * @deprecated Method readCursorIntoCache is deprecated
     */

    private void readCursorIntoCache(Cursor cursor) {
        this;
        JVM INSTR monitorenter ;
        int i;
        if(mValues == null)
            break MISSING_BLOCK_LABEL_133;
        i = mValues.size();
_L8:
        mValues = new HashMap(i);
_L6:
        if(!cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        ContentValues contentvalues;
        int j;
        contentvalues = new ContentValues();
        j = 0;
_L7:
        if(j >= mColumnNames.length) goto _L4; else goto _L3
_L3:
        if(j != mKeyColumn)
            contentvalues.put(mColumnNames[j], cursor.getString(j));
          goto _L5
_L4:
        mValues.put(cursor.getString(mKeyColumn), contentvalues);
          goto _L6
        Exception exception;
        exception;
        throw exception;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L5:
        j++;
          goto _L7
        i = 0;
          goto _L8
    }

    /**
     * @deprecated Method close is deprecated
     */

    public void close() {
        this;
        JVM INSTR monitorenter ;
        if(mContentObserver != null) {
            mCursor.unregisterContentObserver(mContentObserver);
            mContentObserver = null;
        }
        mCursor.close();
        mCursor = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize() throws Throwable {
        if(mCursor != null)
            close();
        super.finalize();
    }

    /**
     * @deprecated Method getRows is deprecated
     */

    public Map getRows() {
        this;
        JVM INSTR monitorenter ;
        Map map;
        if(mDirty)
            requery();
        map = mValues;
        this;
        JVM INSTR monitorexit ;
        return map;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getValues is deprecated
     */

    public ContentValues getValues(String s) {
        this;
        JVM INSTR monitorenter ;
        ContentValues contentvalues;
        if(mDirty)
            requery();
        contentvalues = (ContentValues)mValues.get(s);
        this;
        JVM INSTR monitorexit ;
        return contentvalues;
        Exception exception;
        exception;
        throw exception;
    }

    public void requery() {
        Cursor cursor = mCursor;
        if(cursor != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mDirty = false;
        if(cursor.requery()) {
            readCursorIntoCache(cursor);
            setChanged();
            notifyObservers();
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setKeepUpdated(boolean flag) {
        if(flag != mKeepUpdated) {
            mKeepUpdated = flag;
            if(!mKeepUpdated) {
                mCursor.unregisterContentObserver(mContentObserver);
                mContentObserver = null;
            } else {
                if(mHandlerForUpdateNotifications == null)
                    mHandlerForUpdateNotifications = new Handler();
                if(mContentObserver == null)
                    mContentObserver = new ContentObserver(mHandlerForUpdateNotifications) {

                        public void onChange(boolean flag1) {
                            if(countObservers() != 0)
                                requery();
                            else
                                mDirty = true;
                        }

                        final ContentQueryMap this$0;

             {
                this$0 = ContentQueryMap.this;
                super(handler);
            }
                    };
                mCursor.registerContentObserver(mContentObserver);
                mDirty = true;
            }
        }
    }

    private String mColumnNames[];
    private ContentObserver mContentObserver;
    private volatile Cursor mCursor;
    private boolean mDirty;
    private Handler mHandlerForUpdateNotifications;
    private boolean mKeepUpdated;
    private int mKeyColumn;
    private Map mValues;


/*
    static boolean access$002(ContentQueryMap contentquerymap, boolean flag) {
        contentquerymap.mDirty = flag;
        return flag;
    }

*/
}
