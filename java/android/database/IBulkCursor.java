// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.os.*;

// Referenced classes of package android.database:
//            CursorWindow, IContentObserver

public interface IBulkCursor
    extends IInterface {

    public abstract void close() throws RemoteException;

    public abstract void deactivate() throws RemoteException;

    public abstract Bundle getExtras() throws RemoteException;

    public abstract CursorWindow getWindow(int i) throws RemoteException;

    public abstract void onMove(int i) throws RemoteException;

    public abstract int requery(IContentObserver icontentobserver) throws RemoteException;

    public abstract Bundle respond(Bundle bundle) throws RemoteException;

    public static final int CLOSE_TRANSACTION = 7;
    public static final int DEACTIVATE_TRANSACTION = 2;
    public static final int GET_CURSOR_WINDOW_TRANSACTION = 1;
    public static final int GET_EXTRAS_TRANSACTION = 5;
    public static final int ON_MOVE_TRANSACTION = 4;
    public static final int REQUERY_TRANSACTION = 3;
    public static final int RESPOND_TRANSACTION = 6;
    public static final String descriptor = "android.content.IBulkCursor";
}
