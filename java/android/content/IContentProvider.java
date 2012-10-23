// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// Referenced classes of package android.content:
//            OperationApplicationException, ContentProviderResult, ContentValues

public interface IContentProvider
    extends IInterface {

    public abstract ContentProviderResult[] applyBatch(ArrayList arraylist) throws RemoteException, OperationApplicationException;

    public abstract int bulkInsert(Uri uri, ContentValues acontentvalues[]) throws RemoteException;

    public abstract Bundle call(String s, String s1, Bundle bundle) throws RemoteException;

    public abstract ICancellationSignal createCancellationSignal() throws RemoteException;

    public abstract int delete(Uri uri, String s, String as[]) throws RemoteException;

    public abstract String[] getStreamTypes(Uri uri, String s) throws RemoteException;

    public abstract String getType(Uri uri) throws RemoteException;

    public abstract Uri insert(Uri uri, ContentValues contentvalues) throws RemoteException;

    public abstract AssetFileDescriptor openAssetFile(Uri uri, String s) throws RemoteException, FileNotFoundException;

    public abstract ParcelFileDescriptor openFile(Uri uri, String s) throws RemoteException, FileNotFoundException;

    public abstract AssetFileDescriptor openTypedAssetFile(Uri uri, String s, Bundle bundle) throws RemoteException, FileNotFoundException;

    public abstract Cursor query(Uri uri, String as[], String s, String as1[], String s1, ICancellationSignal icancellationsignal) throws RemoteException;

    public abstract int update(Uri uri, ContentValues contentvalues, String s, String as[]) throws RemoteException;

    public static final int APPLY_BATCH_TRANSACTION = 20;
    public static final int BULK_INSERT_TRANSACTION = 13;
    public static final int CALL_TRANSACTION = 21;
    public static final int CREATE_CANCELATION_SIGNAL_TRANSACTION = 24;
    public static final int DELETE_TRANSACTION = 4;
    public static final int GET_STREAM_TYPES_TRANSACTION = 22;
    public static final int GET_TYPE_TRANSACTION = 2;
    public static final int INSERT_TRANSACTION = 3;
    public static final int OPEN_ASSET_FILE_TRANSACTION = 15;
    public static final int OPEN_FILE_TRANSACTION = 14;
    public static final int OPEN_TYPED_ASSET_FILE_TRANSACTION = 23;
    public static final int QUERY_TRANSACTION = 1;
    public static final int UPDATE_TRANSACTION = 10;
    public static final String descriptor = "android.content.IContentProvider";
}
