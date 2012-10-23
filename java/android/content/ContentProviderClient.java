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
//            OperationApplicationException, IContentProvider, ContentResolver, ContentProvider, 
//            ContentProviderResult, ContentValues

public class ContentProviderClient {

    ContentProviderClient(ContentResolver contentresolver, IContentProvider icontentprovider, boolean flag) {
        mContentProvider = icontentprovider;
        mContentResolver = contentresolver;
        mStable = flag;
    }

    public ContentProviderResult[] applyBatch(ArrayList arraylist) throws RemoteException, OperationApplicationException {
        ContentProviderResult acontentproviderresult[];
        try {
            acontentproviderresult = mContentProvider.applyBatch(arraylist);
        }
        catch(DeadObjectException deadobjectexception) {
            if(!mStable)
                mContentResolver.unstableProviderDied(mContentProvider);
            throw deadobjectexception;
        }
        return acontentproviderresult;
    }

    public int bulkInsert(Uri uri, ContentValues acontentvalues[]) throws RemoteException {
        int i;
        try {
            i = mContentProvider.bulkInsert(uri, acontentvalues);
        }
        catch(DeadObjectException deadobjectexception) {
            if(!mStable)
                mContentResolver.unstableProviderDied(mContentProvider);
            throw deadobjectexception;
        }
        return i;
    }

    public int delete(Uri uri, String s, String as[]) throws RemoteException {
        int i;
        try {
            i = mContentProvider.delete(uri, s, as);
        }
        catch(DeadObjectException deadobjectexception) {
            if(!mStable)
                mContentResolver.unstableProviderDied(mContentProvider);
            throw deadobjectexception;
        }
        return i;
    }

    public ContentProvider getLocalContentProvider() {
        return ContentProvider.coerceToLocalContentProvider(mContentProvider);
    }

    public String[] getStreamTypes(Uri uri, String s) throws RemoteException {
        String as[];
        try {
            as = mContentProvider.getStreamTypes(uri, s);
        }
        catch(DeadObjectException deadobjectexception) {
            if(!mStable)
                mContentResolver.unstableProviderDied(mContentProvider);
            throw deadobjectexception;
        }
        return as;
    }

    public String getType(Uri uri) throws RemoteException {
        String s;
        try {
            s = mContentProvider.getType(uri);
        }
        catch(DeadObjectException deadobjectexception) {
            if(!mStable)
                mContentResolver.unstableProviderDied(mContentProvider);
            throw deadobjectexception;
        }
        return s;
    }

    public Uri insert(Uri uri, ContentValues contentvalues) throws RemoteException {
        Uri uri1;
        try {
            uri1 = mContentProvider.insert(uri, contentvalues);
        }
        catch(DeadObjectException deadobjectexception) {
            if(!mStable)
                mContentResolver.unstableProviderDied(mContentProvider);
            throw deadobjectexception;
        }
        return uri1;
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String s) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor assetfiledescriptor;
        try {
            assetfiledescriptor = mContentProvider.openAssetFile(uri, s);
        }
        catch(DeadObjectException deadobjectexception) {
            if(!mStable)
                mContentResolver.unstableProviderDied(mContentProvider);
            throw deadobjectexception;
        }
        return assetfiledescriptor;
    }

    public ParcelFileDescriptor openFile(Uri uri, String s) throws RemoteException, FileNotFoundException {
        ParcelFileDescriptor parcelfiledescriptor;
        try {
            parcelfiledescriptor = mContentProvider.openFile(uri, s);
        }
        catch(DeadObjectException deadobjectexception) {
            if(!mStable)
                mContentResolver.unstableProviderDied(mContentProvider);
            throw deadobjectexception;
        }
        return parcelfiledescriptor;
    }

    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri, String s, Bundle bundle) throws RemoteException, FileNotFoundException {
        AssetFileDescriptor assetfiledescriptor;
        try {
            assetfiledescriptor = mContentProvider.openTypedAssetFile(uri, s, bundle);
        }
        catch(DeadObjectException deadobjectexception) {
            if(!mStable)
                mContentResolver.unstableProviderDied(mContentProvider);
            throw deadobjectexception;
        }
        return assetfiledescriptor;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1) throws RemoteException {
        Cursor cursor;
        try {
            cursor = query(uri, as, s, as1, s1, null);
        }
        catch(DeadObjectException deadobjectexception) {
            if(!mStable)
                mContentResolver.unstableProviderDied(mContentProvider);
            throw deadobjectexception;
        }
        return cursor;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1, CancellationSignal cancellationsignal) throws RemoteException {
        android.os.ICancellationSignal icancellationsignal = null;
        if(cancellationsignal != null) {
            icancellationsignal = mContentProvider.createCancellationSignal();
            cancellationsignal.setRemote(icancellationsignal);
        }
        Cursor cursor;
        try {
            cursor = mContentProvider.query(uri, as, s, as1, s1, icancellationsignal);
        }
        catch(DeadObjectException deadobjectexception) {
            if(!mStable)
                mContentResolver.unstableProviderDied(mContentProvider);
            throw deadobjectexception;
        }
        return cursor;
    }

    public boolean release() {
        this;
        JVM INSTR monitorenter ;
        if(mReleased)
            throw new IllegalStateException("Already released");
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        throw exception;
        mReleased = true;
        if(!mStable) goto _L2; else goto _L1
_L1:
        boolean flag = mContentResolver.releaseProvider(mContentProvider);
        this;
        JVM INSTR monitorexit ;
          goto _L3
_L2:
        flag = mContentResolver.releaseUnstableProvider(mContentProvider);
        this;
        JVM INSTR monitorexit ;
_L3:
        return flag;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[]) throws RemoteException {
        int i;
        try {
            i = mContentProvider.update(uri, contentvalues, s, as);
        }
        catch(DeadObjectException deadobjectexception) {
            if(!mStable)
                mContentResolver.unstableProviderDied(mContentProvider);
            throw deadobjectexception;
        }
        return i;
    }

    private final IContentProvider mContentProvider;
    private final ContentResolver mContentResolver;
    private boolean mReleased;
    private final boolean mStable;
}
