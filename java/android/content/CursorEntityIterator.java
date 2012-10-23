// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.database.Cursor;
import android.os.RemoteException;

// Referenced classes of package android.content:
//            EntityIterator, Entity

public abstract class CursorEntityIterator
    implements EntityIterator {

    public CursorEntityIterator(Cursor cursor) {
        mIsClosed = false;
        mCursor = cursor;
        mCursor.moveToFirst();
    }

    public final void close() {
        if(mIsClosed) {
            throw new IllegalStateException("closing when already closed");
        } else {
            mIsClosed = true;
            mCursor.close();
            return;
        }
    }

    public abstract Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException;

    public final boolean hasNext() {
        if(mIsClosed)
            throw new IllegalStateException("calling hasNext() when the iterator is closed");
        boolean flag;
        if(!mCursor.isAfterLast())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public Entity next() {
        if(mIsClosed)
            throw new IllegalStateException("calling next() when the iterator is closed");
        if(!hasNext())
            throw new IllegalStateException("you may only call next() if hasNext() is true");
        Entity entity;
        try {
            entity = getEntityAndIncrementCursor(mCursor);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("caught a remote exception, this process will die soon", remoteexception);
        }
        return entity;
    }

    public volatile Object next() {
        return next();
    }

    public void remove() {
        throw new UnsupportedOperationException("remove not supported by EntityIterators");
    }

    public final void reset() {
        if(mIsClosed) {
            throw new IllegalStateException("calling reset() when the iterator is closed");
        } else {
            mCursor.moveToFirst();
            return;
        }
    }

    private final Cursor mCursor;
    private boolean mIsClosed;
}
