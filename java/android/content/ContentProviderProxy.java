// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.content.res.AssetFileDescriptor;
import android.database.*;
import android.net.Uri;
import android.os.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.content:
//            IContentProvider, OperationApplicationException, ContentProviderOperation, ContentProviderResult, 
//            ContentValues

final class ContentProviderProxy
    implements IContentProvider {

    public ContentProviderProxy(IBinder ibinder) {
        mRemote = ibinder;
    }

    public ContentProviderResult[] applyBatch(ArrayList arraylist) throws RemoteException, OperationApplicationException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.content.IContentProvider");
        parcel.writeInt(arraylist.size());
        for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); ((ContentProviderOperation)iterator.next()).writeToParcel(parcel, 0));
        break MISSING_BLOCK_LABEL_69;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
        ContentProviderResult acontentproviderresult[];
        mRemote.transact(20, parcel, parcel1, 0);
        DatabaseUtils.readExceptionWithOperationApplicationExceptionFromParcel(parcel1);
        acontentproviderresult = (ContentProviderResult[])parcel1.createTypedArray(ContentProviderResult.CREATOR);
        parcel.recycle();
        parcel1.recycle();
        return acontentproviderresult;
    }

    public IBinder asBinder() {
        return mRemote;
    }

    public int bulkInsert(Uri uri, ContentValues acontentvalues[]) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("android.content.IContentProvider");
        uri.writeToParcel(parcel, 0);
        parcel.writeTypedArray(acontentvalues, 0);
        mRemote.transact(13, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        i = parcel1.readInt();
        parcel.recycle();
        parcel1.recycle();
        return i;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public Bundle call(String s, String s1, Bundle bundle) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        Bundle bundle1;
        parcel.writeInterfaceToken("android.content.IContentProvider");
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeBundle(bundle);
        mRemote.transact(21, parcel, parcel1, 0);
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

    public ICancellationSignal createCancellationSignal() throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        ICancellationSignal icancellationsignal;
        parcel.writeInterfaceToken("android.content.IContentProvider");
        mRemote.transact(24, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        icancellationsignal = android.os.ICancellationSignal.Stub.asInterface(parcel1.readStrongBinder());
        parcel.recycle();
        parcel1.recycle();
        return icancellationsignal;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public int delete(Uri uri, String s, String as[]) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("android.content.IContentProvider");
        uri.writeToParcel(parcel, 0);
        parcel.writeString(s);
        parcel.writeStringArray(as);
        mRemote.transact(4, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        i = parcel1.readInt();
        parcel.recycle();
        parcel1.recycle();
        return i;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public String[] getStreamTypes(Uri uri, String s) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String as[];
        parcel.writeInterfaceToken("android.content.IContentProvider");
        uri.writeToParcel(parcel, 0);
        parcel.writeString(s);
        mRemote.transact(22, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        as = parcel1.createStringArray();
        parcel.recycle();
        parcel1.recycle();
        return as;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public String getType(Uri uri) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s;
        parcel.writeInterfaceToken("android.content.IContentProvider");
        uri.writeToParcel(parcel, 0);
        mRemote.transact(2, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        s = parcel1.readString();
        parcel.recycle();
        parcel1.recycle();
        return s;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public Uri insert(Uri uri, ContentValues contentvalues) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        Uri uri1;
        parcel.writeInterfaceToken("android.content.IContentProvider");
        uri.writeToParcel(parcel, 0);
        contentvalues.writeToParcel(parcel, 0);
        mRemote.transact(3, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        uri1 = (Uri)Uri.CREATOR.createFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return uri1;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String s) throws RemoteException, FileNotFoundException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.content.IContentProvider");
        uri.writeToParcel(parcel, 0);
        parcel.writeString(s);
        mRemote.transact(15, parcel, parcel1, 0);
        DatabaseUtils.readExceptionWithFileNotFoundExceptionFromParcel(parcel1);
        if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        AssetFileDescriptor assetfiledescriptor1 = (AssetFileDescriptor)AssetFileDescriptor.CREATOR.createFromParcel(parcel1);
        AssetFileDescriptor assetfiledescriptor = assetfiledescriptor1;
_L4:
        parcel.recycle();
        parcel1.recycle();
        return assetfiledescriptor;
_L2:
        assetfiledescriptor = null;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public ParcelFileDescriptor openFile(Uri uri, String s) throws RemoteException, FileNotFoundException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.content.IContentProvider");
        uri.writeToParcel(parcel, 0);
        parcel.writeString(s);
        mRemote.transact(14, parcel, parcel1, 0);
        DatabaseUtils.readExceptionWithFileNotFoundExceptionFromParcel(parcel1);
        if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        ParcelFileDescriptor parcelfiledescriptor1 = parcel1.readFileDescriptor();
        ParcelFileDescriptor parcelfiledescriptor = parcelfiledescriptor1;
_L4:
        parcel.recycle();
        parcel1.recycle();
        return parcelfiledescriptor;
_L2:
        parcelfiledescriptor = null;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public AssetFileDescriptor openTypedAssetFile(Uri uri, String s, Bundle bundle) throws RemoteException, FileNotFoundException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.content.IContentProvider");
        uri.writeToParcel(parcel, 0);
        parcel.writeString(s);
        parcel.writeBundle(bundle);
        mRemote.transact(23, parcel, parcel1, 0);
        DatabaseUtils.readExceptionWithFileNotFoundExceptionFromParcel(parcel1);
        if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        AssetFileDescriptor assetfiledescriptor1 = (AssetFileDescriptor)AssetFileDescriptor.CREATOR.createFromParcel(parcel1);
        AssetFileDescriptor assetfiledescriptor = assetfiledescriptor1;
_L4:
        parcel.recycle();
        parcel1.recycle();
        return assetfiledescriptor;
_L2:
        assetfiledescriptor = null;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1, ICancellationSignal icancellationsignal) throws RemoteException {
        BulkCursorToCursorAdaptor bulkcursortocursoradaptor;
        Parcel parcel;
        Parcel parcel1;
        bulkcursortocursoradaptor = new BulkCursorToCursorAdaptor();
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int k;
        parcel.writeInterfaceToken("android.content.IContentProvider");
        uri.writeToParcel(parcel, 0);
        int i = 0;
        if(as != null)
            i = as.length;
        parcel.writeInt(i);
        for(int j = 0; j < i; j++)
            parcel.writeString(as[j]);

        parcel.writeString(s);
        if(as1 == null)
            break MISSING_BLOCK_LABEL_280;
        k = as1.length;
_L7:
        parcel.writeInt(k);
        for(int l = 0; l < k; l++)
            parcel.writeString(as1[l]);

        parcel.writeString(s1);
        parcel.writeStrongBinder(bulkcursortocursoradaptor.getObserver().asBinder());
        if(icancellationsignal == null) goto _L2; else goto _L1
_L1:
        IBinder ibinder = icancellationsignal.asBinder();
_L5:
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(1, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        if(parcel1.readInt() == 0) goto _L4; else goto _L3
_L3:
        bulkcursortocursoradaptor.initialize((BulkCursorDescriptor)BulkCursorDescriptor.CREATOR.createFromParcel(parcel1));
_L6:
        parcel.recycle();
        parcel1.recycle();
        return bulkcursortocursoradaptor;
_L2:
        ibinder = null;
          goto _L5
_L4:
        bulkcursortocursoradaptor.close();
        bulkcursortocursoradaptor = null;
          goto _L6
        RemoteException remoteexception;
        remoteexception;
        bulkcursortocursoradaptor.close();
        throw remoteexception;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
        RuntimeException runtimeexception;
        runtimeexception;
        bulkcursortocursoradaptor.close();
        throw runtimeexception;
        k = 0;
          goto _L7
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[]) throws RemoteException {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("android.content.IContentProvider");
        uri.writeToParcel(parcel, 0);
        contentvalues.writeToParcel(parcel, 0);
        parcel.writeString(s);
        parcel.writeStringArray(as);
        mRemote.transact(10, parcel, parcel1, 0);
        DatabaseUtils.readExceptionFromParcel(parcel1);
        i = parcel1.readInt();
        parcel.recycle();
        parcel1.recycle();
        return i;
        Exception exception;
        exception;
        parcel.recycle();
        parcel1.recycle();
        throw exception;
    }

    private IBinder mRemote;
}
