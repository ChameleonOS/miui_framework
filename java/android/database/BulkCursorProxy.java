// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.os.*;

// Referenced classes of package android.database:
//            IBulkCursor, DatabaseUtils, CursorWindow, IContentObserver

final class BulkCursorProxy
    implements IBulkCursor {

    public BulkCursorProxy(IBinder ibinder) {
        mRemote = ibinder;
        mExtras = null;
    }

    public IBinder asBinder() {
        return mRemote;
    }

    public void close() throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.content.IBulkCursor");
        mRemote.transact(7, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public void deactivate() throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.content.IBulkCursor");
        mRemote.transact(2, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public Bundle getExtras() throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        if(mExtras != null)
            break MISSING_BLOCK_LABEL_55;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.content.IBulkCursor");
        mRemote.transact(5, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        mExtras = parcel1.readBundle();
        parcel.recycle();
        parcel1.recycle();
        return mExtras;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public CursorWindow getWindow(int i) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        CursorWindow cursorwindow;
        CursorWindow cursorwindow1;
        parcel.writeInterfaceToken("android.content.IBulkCursor");
        parcel.writeInt(i);
        mRemote.transact(1, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        cursorwindow = null;
        if(parcel1.readInt() != 1)
            break MISSING_BLOCK_LABEL_58;
        cursorwindow1 = CursorWindow.newFromParcel(parcel1);
        cursorwindow = cursorwindow1;
        parcel.recycle();
        parcel1.recycle();
        return cursorwindow;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public void onMove(int i) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.content.IBulkCursor");
        parcel.writeInt(i);
        mRemote.transact(4, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public int requery(IContentObserver icontentobserver) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        boolean flag;
        parcel.writeInterfaceToken("android.content.IBulkCursor");
        parcel.writeStrongInterface(icontentobserver);
        flag = mRemote.transact(3, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        if(flag) goto _L2; else goto _L1
_L1:
        int i = -1;
_L4:
        parcel.recycle();
        parcel1.recycle();
        return i;
_L2:
        i = parcel1.readInt();
        mExtras = parcel1.readBundle();
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public Bundle respond(Bundle bundle) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        Bundle bundle1;
        parcel.writeInterfaceToken("android.content.IBulkCursor");
        parcel.writeBundle(bundle);
        mRemote.transact(6, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        bundle1 = parcel1.readBundle();
        parcel.recycle();
        parcel1.recycle();
        return bundle1;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    private Bundle mExtras;
    private IBinder mRemote;
}
