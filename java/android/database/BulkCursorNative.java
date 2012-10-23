// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.os.*;

// Referenced classes of package android.database:
//            IBulkCursor, BulkCursorProxy, DatabaseUtils, CursorWindow

public abstract class BulkCursorNative extends Binder
    implements IBulkCursor {

    public BulkCursorNative() {
        attachInterface(this, "android.content.IBulkCursor");
    }

    public static IBulkCursor asInterface(IBinder ibinder) {
        if(ibinder != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((IBulkCursor) (obj));
_L2:
        obj = (IBulkCursor)ibinder.queryLocalInterface("android.content.IBulkCursor");
        if(obj == null)
            obj = new BulkCursorProxy(ibinder);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
        boolean flag = true;
        i;
        JVM INSTR tableswitch 1 7: default 48
    //                   1 62
    //                   2 121
    //                   3 155
    //                   4 195
    //                   5 216
    //                   6 241
    //                   7 138;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L7:
        break MISSING_BLOCK_LABEL_241;
_L1:
        flag = super.onTransact(i, parcel, parcel1, j);
_L9:
        return flag;
_L2:
        CursorWindow cursorwindow;
        try {
            parcel.enforceInterface("android.content.IBulkCursor");
            cursorwindow = getWindow(parcel.readInt());
            parcel1.writeNoException();
            if(cursorwindow != null)
                break MISSING_BLOCK_LABEL_106;
            parcel1.writeInt(0);
        }
        catch(Exception exception) {
            DatabaseUtils.writeExceptionToParcel(parcel1, exception);
        }
          goto _L9
        parcel1.writeInt(1);
        cursorwindow.writeToParcel(parcel1, 1);
          goto _L9
_L3:
        parcel.enforceInterface("android.content.IBulkCursor");
        deactivate();
        parcel1.writeNoException();
          goto _L9
_L8:
        parcel.enforceInterface("android.content.IBulkCursor");
        close();
        parcel1.writeNoException();
          goto _L9
_L4:
        parcel.enforceInterface("android.content.IBulkCursor");
        int k = requery(IContentObserver.Stub.asInterface(parcel.readStrongBinder()));
        parcel1.writeNoException();
        parcel1.writeInt(k);
        parcel1.writeBundle(getExtras());
          goto _L9
_L5:
        parcel.enforceInterface("android.content.IBulkCursor");
        onMove(parcel.readInt());
        parcel1.writeNoException();
          goto _L9
_L6:
        parcel.enforceInterface("android.content.IBulkCursor");
        android.os.Bundle bundle1 = getExtras();
        parcel1.writeNoException();
        parcel1.writeBundle(bundle1);
          goto _L9
        parcel.enforceInterface("android.content.IBulkCursor");
        android.os.Bundle bundle = respond(parcel.readBundle());
        parcel1.writeNoException();
        parcel1.writeBundle(bundle);
          goto _L9
    }
}
