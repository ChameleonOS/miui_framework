// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.content.res.AssetFileDescriptor;
import android.database.*;
import android.net.Uri;
import android.os.*;
import java.util.ArrayList;

// Referenced classes of package android.content:
//            IContentProvider, ContentProviderProxy, ContentValues, ContentProviderOperation

public abstract class ContentProviderNative extends Binder
    implements IContentProvider {

    public ContentProviderNative() {
        attachInterface(this, "android.content.IContentProvider");
    }

    public static IContentProvider asInterface(IBinder ibinder) {
        if(ibinder != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((IContentProvider) (obj));
_L2:
        obj = (IContentProvider)ibinder.queryLocalInterface("android.content.IContentProvider");
        if(obj == null)
            obj = new ContentProviderProxy(ibinder);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public IBinder asBinder() {
        return this;
    }

    public abstract String getProviderName();

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
        i;
        JVM INSTR tableswitch 1 24: default 112
    //                   1 126
    //                   2 352
    //                   3 392
    //                   4 578
    //                   5 112
    //                   6 112
    //                   7 112
    //                   8 112
    //                   9 112
    //                   10 626
    //                   11 112
    //                   12 112
    //                   13 444
    //                   14 686
    //                   15 746
    //                   16 112
    //                   17 112
    //                   18 112
    //                   19 112
    //                   20 494
    //                   21 806
    //                   22 846
    //                   23 890
    //                   24 954;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L1 _L1 _L1 _L1 _L6 _L1 _L1 _L7 _L8 _L9 _L1 _L1 _L1 _L1 _L10 _L11 _L12 _L13 _L14
_L1:
        boolean flag = super.onTransact(i, parcel, parcel1, j);
_L19:
        return flag;
_L3:
        parcel.enforceInterface("android.content.IContentProvider");
        String s = getType((Uri)Uri.CREATOR.createFromParcel(parcel));
        parcel1.writeNoException();
        parcel1.writeString(s);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L4:
        parcel.enforceInterface("android.content.IContentProvider");
        Uri uri = insert((Uri)Uri.CREATOR.createFromParcel(parcel), (ContentValues)ContentValues.CREATOR.createFromParcel(parcel));
        parcel1.writeNoException();
        Uri.writeToParcel(parcel1, uri);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L7:
        parcel.enforceInterface("android.content.IContentProvider");
        int k1 = bulkInsert((Uri)Uri.CREATOR.createFromParcel(parcel), (ContentValues[])parcel.createTypedArray(ContentValues.CREATOR));
        parcel1.writeNoException();
        parcel1.writeInt(k1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L10:
        parcel.enforceInterface("android.content.IContentProvider");
        int i1 = parcel.readInt();
        ArrayList arraylist = new ArrayList(i1);
        for(int j1 = 0; j1 < i1; j1++) {
            Object obj = ContentProviderOperation.CREATOR.createFromParcel(parcel);
            arraylist.add(j1, obj);
        }

        ContentProviderResult acontentproviderresult[] = applyBatch(arraylist);
        parcel1.writeNoException();
        parcel1.writeTypedArray(acontentproviderresult, 0);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L5:
        parcel.enforceInterface("android.content.IContentProvider");
        int l = delete((Uri)Uri.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readStringArray());
        parcel1.writeNoException();
        parcel1.writeInt(l);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L6:
        parcel.enforceInterface("android.content.IContentProvider");
        int k = update((Uri)Uri.CREATOR.createFromParcel(parcel), (ContentValues)ContentValues.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readStringArray());
        parcel1.writeNoException();
        parcel1.writeInt(k);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L8:
        parcel.enforceInterface("android.content.IContentProvider");
        ParcelFileDescriptor parcelfiledescriptor = openFile((Uri)Uri.CREATOR.createFromParcel(parcel), parcel.readString());
        parcel1.writeNoException();
        if(parcelfiledescriptor != null) {
            parcel1.writeInt(1);
            parcelfiledescriptor.writeToParcel(parcel1, 1);
        } else {
            parcel1.writeInt(0);
        }
          goto _L15
_L9:
        parcel.enforceInterface("android.content.IContentProvider");
        AssetFileDescriptor assetfiledescriptor1 = openAssetFile((Uri)Uri.CREATOR.createFromParcel(parcel), parcel.readString());
        parcel1.writeNoException();
        if(assetfiledescriptor1 != null) {
            parcel1.writeInt(1);
            assetfiledescriptor1.writeToParcel(parcel1, 1);
        } else {
            parcel1.writeInt(0);
        }
          goto _L16
_L11:
        parcel.enforceInterface("android.content.IContentProvider");
        android.os.Bundle bundle = call(parcel.readString(), parcel.readString(), parcel.readBundle());
        parcel1.writeNoException();
        parcel1.writeBundle(bundle);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L12:
        parcel.enforceInterface("android.content.IContentProvider");
        String as[] = getStreamTypes((Uri)Uri.CREATOR.createFromParcel(parcel), parcel.readString());
        parcel1.writeNoException();
        parcel1.writeStringArray(as);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L13:
        parcel.enforceInterface("android.content.IContentProvider");
        AssetFileDescriptor assetfiledescriptor = openTypedAssetFile((Uri)Uri.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readBundle());
        parcel1.writeNoException();
        if(assetfiledescriptor != null) {
            parcel1.writeInt(1);
            assetfiledescriptor.writeToParcel(parcel1, 1);
        } else {
            parcel1.writeInt(0);
        }
          goto _L17
_L14:
        parcel.enforceInterface("android.content.IContentProvider");
        ICancellationSignal icancellationsignal = createCancellationSignal();
        parcel1.writeNoException();
        parcel1.writeStrongBinder(icancellationsignal.asBinder());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L2:
        try {
            parcel.enforceInterface("android.content.IContentProvider");
            Uri uri1 = (Uri)Uri.CREATOR.createFromParcel(parcel);
            int l1 = parcel.readInt();
            String as1[] = null;
            if(l1 > 0) {
                as1 = new String[l1];
                for(int k2 = 0; k2 < l1; k2++)
                    as1[k2] = parcel.readString();

            }
            String s1 = parcel.readString();
            int i2 = parcel.readInt();
            String as2[] = null;
            if(i2 > 0) {
                as2 = new String[i2];
                for(int j2 = 0; j2 < i2; j2++)
                    as2[j2] = parcel.readString();

            }
            String s2 = parcel.readString();
            android.database.IContentObserver icontentobserver = android.database.IContentObserver.Stub.asInterface(parcel.readStrongBinder());
            android.database.Cursor cursor = query(uri1, as1, s1, as2, s2, android.os.ICancellationSignal.Stub.asInterface(parcel.readStrongBinder()));
            if(cursor != null) {
                BulkCursorDescriptor bulkcursordescriptor = (new CursorToBulkCursorAdaptor(cursor, icontentobserver, getProviderName())).getBulkCursorDescriptor();
                parcel1.writeNoException();
                parcel1.writeInt(1);
                bulkcursordescriptor.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeNoException();
                parcel1.writeInt(0);
            }
        }
        catch(Exception exception) {
            DatabaseUtils.writeExceptionToParcel(parcel1, exception);
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
_L15:
        flag = true;
        continue; /* Loop/switch isn't completed */
_L16:
        flag = true;
        continue; /* Loop/switch isn't completed */
_L17:
        flag = true;
        if(true) goto _L19; else goto _L18
_L18:
    }
}
