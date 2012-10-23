// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.net.Uri;
import android.os.*;

// Referenced classes of package android.database:
//            BulkCursorNative, CrossProcessCursor, CrossProcessCursorWrapper, CursorWindow, 
//            StaleDataException, BulkCursorDescriptor, Cursor, IContentObserver, 
//            ContentObserver

public final class CursorToBulkCursorAdaptor extends BulkCursorNative
    implements android.os.IBinder.DeathRecipient {
    private static final class ContentObserverProxy extends ContentObserver {

        public boolean deliverSelfNotifications() {
            return false;
        }

        public void onChange(boolean flag, Uri uri) {
            mRemote.onChange(flag, uri);
_L2:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public boolean unlinkToDeath(android.os.IBinder.DeathRecipient deathrecipient) {
            return mRemote.asBinder().unlinkToDeath(deathrecipient, 0);
        }

        protected IContentObserver mRemote;

        public ContentObserverProxy(IContentObserver icontentobserver, android.os.IBinder.DeathRecipient deathrecipient) {
            super(null);
            mRemote = icontentobserver;
            icontentobserver.asBinder().linkToDeath(deathrecipient, 0);
_L2:
            return;
            RemoteException remoteexception;
            remoteexception;
            if(true) goto _L2; else goto _L1
_L1:
        }
    }


    public CursorToBulkCursorAdaptor(Cursor cursor, IContentObserver icontentobserver, String s) {
        mLock = new Object();
        if(cursor instanceof CrossProcessCursor)
            mCursor = (CrossProcessCursor)cursor;
        else
            mCursor = new CrossProcessCursorWrapper(cursor);
        mProviderName = s;
        synchronized(mLock) {
            createAndRegisterObserverProxyLocked(icontentobserver);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void closeFilledWindowLocked() {
        if(mFilledWindow != null) {
            mFilledWindow.close();
            mFilledWindow = null;
        }
    }

    private void createAndRegisterObserverProxyLocked(IContentObserver icontentobserver) {
        if(mObserver != null) {
            throw new IllegalStateException("an observer is already registered");
        } else {
            mObserver = new ContentObserverProxy(icontentobserver, this);
            mCursor.registerContentObserver(mObserver);
            return;
        }
    }

    private void disposeLocked() {
        if(mCursor != null) {
            unregisterObserverProxyLocked();
            mCursor.close();
            mCursor = null;
        }
        closeFilledWindowLocked();
    }

    private void throwIfCursorIsClosed() {
        if(mCursor == null)
            throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        else
            return;
    }

    private void unregisterObserverProxyLocked() {
        if(mObserver != null) {
            mCursor.unregisterContentObserver(mObserver);
            mObserver.unlinkToDeath(this);
            mObserver = null;
        }
    }

    public void binderDied() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        disposeLocked();
        return;
    }

    public void close() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        disposeLocked();
        return;
    }

    public void deactivate() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mCursor != null) {
            unregisterObserverProxyLocked();
            mCursor.deactivate();
        }
        closeFilledWindowLocked();
        return;
    }

    public BulkCursorDescriptor getBulkCursorDescriptor() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfCursorIsClosed();
        BulkCursorDescriptor bulkcursordescriptor = new BulkCursorDescriptor();
        bulkcursordescriptor.cursor = this;
        bulkcursordescriptor.columnNames = mCursor.getColumnNames();
        bulkcursordescriptor.wantsAllOnMoveCalls = mCursor.getWantsAllOnMoveCalls();
        bulkcursordescriptor.count = mCursor.getCount();
        bulkcursordescriptor.window = mCursor.getWindow();
        if(bulkcursordescriptor.window != null)
            bulkcursordescriptor.window.acquireReference();
        return bulkcursordescriptor;
    }

    public Bundle getExtras() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfCursorIsClosed();
        Bundle bundle = mCursor.getExtras();
        return bundle;
    }

    public CursorWindow getWindow(int i) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfCursorIsClosed();
        if(mCursor.moveToPosition(i)) goto _L2; else goto _L1
_L1:
        CursorWindow cursorwindow;
        closeFilledWindowLocked();
        cursorwindow = null;
          goto _L3
_L2:
        cursorwindow = mCursor.getWindow();
        if(cursorwindow == null) goto _L5; else goto _L4
_L4:
        closeFilledWindowLocked();
_L6:
        if(cursorwindow != null)
            cursorwindow.acquireReference();
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
_L5:
        cursorwindow = mFilledWindow;
        if(cursorwindow == null) {
            mFilledWindow = new CursorWindow(mProviderName);
            cursorwindow = mFilledWindow;
        } else
        if(i < cursorwindow.getStartPosition() || i >= cursorwindow.getStartPosition() + cursorwindow.getNumRows())
            cursorwindow.clear();
        mCursor.fillWindow(i, cursorwindow);
        if(true) goto _L6; else goto _L3
_L3:
        return cursorwindow;
    }

    public void onMove(int i) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfCursorIsClosed();
        mCursor.onMove(mCursor.getPosition(), i);
        return;
    }

    public int requery(IContentObserver icontentobserver) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfCursorIsClosed();
        closeFilledWindowLocked();
        boolean flag;
        int i;
        try {
            flag = mCursor.requery();
        }
        catch(IllegalStateException illegalstateexception) {
            throw new IllegalStateException((new StringBuilder()).append(mProviderName).append(" Requery misuse db, mCursor isClosed:").append(mCursor.isClosed()).toString(), illegalstateexception);
        }
        if(flag) goto _L2; else goto _L1
_L1:
        i = -1;
          goto _L3
        Exception exception;
        exception;
        throw exception;
_L2:
        unregisterObserverProxyLocked();
        createAndRegisterObserverProxyLocked(icontentobserver);
        i = mCursor.getCount();
        obj;
        JVM INSTR monitorexit ;
_L3:
        return i;
    }

    public Bundle respond(Bundle bundle) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        throwIfCursorIsClosed();
        Bundle bundle1 = mCursor.respond(bundle);
        return bundle1;
    }

    private static final String TAG = "Cursor";
    private CrossProcessCursor mCursor;
    private CursorWindow mFilledWindow;
    private final Object mLock;
    private ContentObserverProxy mObserver;
    private final String mProviderName;
}
