// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.content.pm.ComponentInfo;
import android.content.pm.PathPermission;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.content:
//            ComponentCallbacks2, OperationApplicationException, ContentProviderResult, ContentProviderOperation, 
//            ContentResolver, ClipDescription, Context, IContentProvider, 
//            ContentValues, ContentProviderNative

public abstract class ContentProvider
    implements ComponentCallbacks2 {
    public static interface PipeDataWriter {

        public abstract void writeDataToPipe(ParcelFileDescriptor parcelfiledescriptor, Uri uri, String s, Bundle bundle, Object obj);
    }

    class Transport extends ContentProviderNative {

        private void enforceReadPermission(Uri uri) throws SecurityException {
            Context context;
            int i;
            int j;
            String s;
            context = getContext();
            i = Binder.getCallingPid();
            j = Binder.getCallingUid();
            s = null;
            if(j != mMyUid) goto _L2; else goto _L1
_L1:
            return;
_L2:
            String s2;
            if(!mExported)
                break; /* Loop/switch isn't completed */
            s2 = getReadPermission();
            if(s2 == null)
                break; /* Loop/switch isn't completed */
            if(context.checkPermission(s2, i, j) == 0)
                continue; /* Loop/switch isn't completed */
            s = s2;
            break; /* Loop/switch isn't completed */
            if(true) goto _L1; else goto _L3
_L3:
            boolean flag;
            PathPermission apathpermission[];
            String s3;
            int k;
            int l;
            PathPermission pathpermission;
            String s4;
            if(s2 == null)
                flag = true;
            else
                flag = false;
            apathpermission = getPathPermissions();
            if(apathpermission == null)
                continue; /* Loop/switch isn't completed */
            s3 = uri.getPath();
            k = apathpermission.length;
            l = 0;
            if(l >= k) goto _L5; else goto _L4
_L4:
            pathpermission = apathpermission[l];
            s4 = pathpermission.getReadPermission();
            if(s4 == null || !pathpermission.match(s3))
                continue; /* Loop/switch isn't completed */
            if(context.checkPermission(s4, i, j) == 0) goto _L1; else goto _L6
_L6:
            flag = false;
            s = s4;
            l++;
            break MISSING_BLOCK_LABEL_109;
_L5:
            if(flag) goto _L1; else goto _L7
_L7:
            if(context.checkUriPermission(uri, i, j, 1) == 0) goto _L1; else goto _L8
_L8:
            String s1;
            if(mExported)
                s1 = (new StringBuilder()).append(" requires ").append(s).append(", or grantUriPermission()").toString();
            else
                s1 = " requires the provider be exported, or grantUriPermission()";
            throw new SecurityException((new StringBuilder()).append("Permission Denial: reading ").append(getClass().getName()).append(" uri ").append(uri).append(" from pid=").append(i).append(", uid=").append(j).append(s1).toString());
        }

        private void enforceWritePermission(Uri uri) throws SecurityException {
            Context context;
            int i;
            int j;
            String s;
            context = getContext();
            i = Binder.getCallingPid();
            j = Binder.getCallingUid();
            s = null;
            if(j != mMyUid) goto _L2; else goto _L1
_L1:
            return;
_L2:
            String s2;
            if(!mExported)
                break; /* Loop/switch isn't completed */
            s2 = getWritePermission();
            if(s2 == null)
                break; /* Loop/switch isn't completed */
            if(context.checkPermission(s2, i, j) == 0)
                continue; /* Loop/switch isn't completed */
            s = s2;
            break; /* Loop/switch isn't completed */
            if(true) goto _L1; else goto _L3
_L3:
            boolean flag;
            PathPermission apathpermission[];
            String s3;
            int k;
            int l;
            PathPermission pathpermission;
            String s4;
            if(s2 == null)
                flag = true;
            else
                flag = false;
            apathpermission = getPathPermissions();
            if(apathpermission == null)
                continue; /* Loop/switch isn't completed */
            s3 = uri.getPath();
            k = apathpermission.length;
            l = 0;
            if(l >= k) goto _L5; else goto _L4
_L4:
            pathpermission = apathpermission[l];
            s4 = pathpermission.getWritePermission();
            if(s4 == null || !pathpermission.match(s3))
                continue; /* Loop/switch isn't completed */
            if(context.checkPermission(s4, i, j) == 0) goto _L1; else goto _L6
_L6:
            flag = false;
            s = s4;
            l++;
            break MISSING_BLOCK_LABEL_109;
_L5:
            if(flag) goto _L1; else goto _L7
_L7:
            if(context.checkUriPermission(uri, i, j, 2) == 0) goto _L1; else goto _L8
_L8:
            String s1;
            if(mExported)
                s1 = (new StringBuilder()).append(" requires ").append(s).append(", or grantUriPermission()").toString();
            else
                s1 = " requires the provider be exported, or grantUriPermission()";
            throw new SecurityException((new StringBuilder()).append("Permission Denial: writing ").append(getClass().getName()).append(" uri ").append(uri).append(" from pid=").append(i).append(", uid=").append(j).append(s1).toString());
        }

        public ContentProviderResult[] applyBatch(ArrayList arraylist) throws OperationApplicationException {
            Iterator iterator = arraylist.iterator();
            do {
                if(!iterator.hasNext())
                    break;
                ContentProviderOperation contentprovideroperation = (ContentProviderOperation)iterator.next();
                if(contentprovideroperation.isReadOperation())
                    enforceReadPermission(contentprovideroperation.getUri());
                if(contentprovideroperation.isWriteOperation())
                    enforceWritePermission(contentprovideroperation.getUri());
            } while(true);
            return ContentProvider.this.applyBatch(arraylist);
        }

        public int bulkInsert(Uri uri, ContentValues acontentvalues[]) {
            enforceWritePermission(uri);
            return ContentProvider.this.bulkInsert(uri, acontentvalues);
        }

        public Bundle call(String s, String s1, Bundle bundle) {
            return ContentProvider.this.call(s, s1, bundle);
        }

        public ICancellationSignal createCancellationSignal() throws RemoteException {
            return CancellationSignal.createTransport();
        }

        public int delete(Uri uri, String s, String as[]) {
            enforceWritePermission(uri);
            return ContentProvider.this.delete(uri, s, as);
        }

        ContentProvider getContentProvider() {
            return ContentProvider.this;
        }

        public String getProviderName() {
            return getContentProvider().getClass().getName();
        }

        public String[] getStreamTypes(Uri uri, String s) {
            return ContentProvider.this.getStreamTypes(uri, s);
        }

        public String getType(Uri uri) {
            return ContentProvider.this.getType(uri);
        }

        public Uri insert(Uri uri, ContentValues contentvalues) {
            enforceWritePermission(uri);
            return ContentProvider.this.insert(uri, contentvalues);
        }

        public AssetFileDescriptor openAssetFile(Uri uri, String s) throws FileNotFoundException {
            if(s != null && s.startsWith("rw"))
                enforceWritePermission(uri);
            else
                enforceReadPermission(uri);
            return ContentProvider.this.openAssetFile(uri, s);
        }

        public ParcelFileDescriptor openFile(Uri uri, String s) throws FileNotFoundException {
            if(s != null && s.startsWith("rw"))
                enforceWritePermission(uri);
            else
                enforceReadPermission(uri);
            return ContentProvider.this.openFile(uri, s);
        }

        public AssetFileDescriptor openTypedAssetFile(Uri uri, String s, Bundle bundle) throws FileNotFoundException {
            enforceReadPermission(uri);
            return ContentProvider.this.openTypedAssetFile(uri, s, bundle);
        }

        public Cursor query(Uri uri, String as[], String s, String as1[], String s1, ICancellationSignal icancellationsignal) {
            enforceReadPermission(uri);
            return ContentProvider.this.query(uri, as, s, as1, s1, CancellationSignal.fromTransport(icancellationsignal));
        }

        public int update(Uri uri, ContentValues contentvalues, String s, String as[]) {
            enforceWritePermission(uri);
            return ContentProvider.this.update(uri, contentvalues, s, as);
        }

        final ContentProvider this$0;

        Transport() {
            this$0 = ContentProvider.this;
            super();
        }
    }


    public ContentProvider() {
        mContext = null;
        mTransport = new Transport();
    }

    public ContentProvider(Context context, String s, String s1, PathPermission apathpermission[]) {
        mContext = null;
        mTransport = new Transport();
        mContext = context;
        mReadPermission = s;
        mWritePermission = s1;
        mPathPermissions = apathpermission;
    }

    public static ContentProvider coerceToLocalContentProvider(IContentProvider icontentprovider) {
        ContentProvider contentprovider;
        if(icontentprovider instanceof Transport)
            contentprovider = ((Transport)icontentprovider).getContentProvider();
        else
            contentprovider = null;
        return contentprovider;
    }

    public ContentProviderResult[] applyBatch(ArrayList arraylist) throws OperationApplicationException {
        int i = arraylist.size();
        ContentProviderResult acontentproviderresult[] = new ContentProviderResult[i];
        for(int j = 0; j < i; j++)
            acontentproviderresult[j] = ((ContentProviderOperation)arraylist.get(j)).apply(this, acontentproviderresult, j);

        return acontentproviderresult;
    }

    public void attachInfo(Context context, ProviderInfo providerinfo) {
        AsyncTask.init();
        if(mContext == null) {
            mContext = context;
            mMyUid = Process.myUid();
            if(providerinfo != null) {
                setReadPermission(providerinfo.readPermission);
                setWritePermission(providerinfo.writePermission);
                setPathPermissions(providerinfo.pathPermissions);
                mExported = ((ComponentInfo) (providerinfo)).exported;
            }
            onCreate();
        }
    }

    public int bulkInsert(Uri uri, ContentValues acontentvalues[]) {
        int i = acontentvalues.length;
        for(int j = 0; j < i; j++)
            insert(uri, acontentvalues[j]);

        return i;
    }

    public Bundle call(String s, String s1, Bundle bundle) {
        return null;
    }

    public abstract int delete(Uri uri, String s, String as[]);

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println("nothing to dump");
    }

    public final Context getContext() {
        return mContext;
    }

    public IContentProvider getIContentProvider() {
        return mTransport;
    }

    public final PathPermission[] getPathPermissions() {
        return mPathPermissions;
    }

    public final String getReadPermission() {
        return mReadPermission;
    }

    public String[] getStreamTypes(Uri uri, String s) {
        return null;
    }

    public abstract String getType(Uri uri);

    public final String getWritePermission() {
        return mWritePermission;
    }

    public abstract Uri insert(Uri uri, ContentValues contentvalues);

    protected boolean isTemporary() {
        return false;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public abstract boolean onCreate();

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String s) throws FileNotFoundException {
        ParcelFileDescriptor parcelfiledescriptor = openFile(uri, s);
        AssetFileDescriptor assetfiledescriptor;
        if(parcelfiledescriptor != null)
            assetfiledescriptor = new AssetFileDescriptor(parcelfiledescriptor, 0L, -1L);
        else
            assetfiledescriptor = null;
        return assetfiledescriptor;
    }

    public ParcelFileDescriptor openFile(Uri uri, String s) throws FileNotFoundException {
        throw new FileNotFoundException((new StringBuilder()).append("No files supported by provider at ").append(uri).toString());
    }

    protected final ParcelFileDescriptor openFileHelper(Uri uri, String s) throws FileNotFoundException {
        int i = 0;
        String as[] = new String[1];
        as[i] = "_data";
        Cursor cursor = query(uri, as, null, null, null);
        if(cursor != null)
            i = cursor.getCount();
        if(i != 1) {
            if(cursor != null)
                cursor.close();
            if(i == 0)
                throw new FileNotFoundException((new StringBuilder()).append("No entry for ").append(uri).toString());
            else
                throw new FileNotFoundException((new StringBuilder()).append("Multiple items at ").append(uri).toString());
        }
        cursor.moveToFirst();
        int j = cursor.getColumnIndex("_data");
        String s1;
        if(j >= 0)
            s1 = cursor.getString(j);
        else
            s1 = null;
        cursor.close();
        if(s1 == null) {
            throw new FileNotFoundException("Column _data not found.");
        } else {
            int k = ContentResolver.modeToMode(uri, s);
            return ParcelFileDescriptor.open(new File(s1), k);
        }
    }

    public ParcelFileDescriptor openPipeHelper(final Uri uri, final String mimeType, final Bundle opts, final Object args, final PipeDataWriter func) throws FileNotFoundException {
        ParcelFileDescriptor parcelfiledescriptor;
        try {
            final ParcelFileDescriptor fds[] = ParcelFileDescriptor.createPipe();
            (new AsyncTask() {

                protected transient Object doInBackground(Object aobj[]) {
                    func.writeDataToPipe(fds[1], uri, mimeType, opts, args);
                    try {
                        fds[1].close();
                    }
                    catch(IOException ioexception1) {
                        Log.w("ContentProvider", "Failure closing pipe", ioexception1);
                    }
                    return null;
                }

                final ContentProvider this$0;
                final Object val$args;
                final ParcelFileDescriptor val$fds[];
                final PipeDataWriter val$func;
                final String val$mimeType;
                final Bundle val$opts;
                final Uri val$uri;

             {
                this$0 = ContentProvider.this;
                func = pipedatawriter;
                fds = aparcelfiledescriptor;
                uri = uri1;
                mimeType = s;
                opts = bundle;
                args = obj;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])null);
            parcelfiledescriptor = fds[0];
        }
        catch(IOException ioexception) {
            throw new FileNotFoundException("failure making pipe");
        }
        return parcelfiledescriptor;
    }

    public AssetFileDescriptor openTypedAssetFile(Uri uri, String s, Bundle bundle) throws FileNotFoundException {
        AssetFileDescriptor assetfiledescriptor;
        if("*/*".equals(s)) {
            assetfiledescriptor = openAssetFile(uri, "r");
        } else {
            String s1 = getType(uri);
            if(s1 != null && ClipDescription.compareMimeTypes(s1, s))
                assetfiledescriptor = openAssetFile(uri, "r");
            else
                throw new FileNotFoundException((new StringBuilder()).append("Can't open ").append(uri).append(" as type ").append(s).toString());
        }
        return assetfiledescriptor;
    }

    public abstract Cursor query(Uri uri, String as[], String s, String as1[], String s1);

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1, CancellationSignal cancellationsignal) {
        return query(uri, as, s, as1, s1);
    }

    protected final void setPathPermissions(PathPermission apathpermission[]) {
        mPathPermissions = apathpermission;
    }

    protected final void setReadPermission(String s) {
        mReadPermission = s;
    }

    protected final void setWritePermission(String s) {
        mWritePermission = s;
    }

    public void shutdown() {
        Log.w("ContentProvider", "implement ContentProvider shutdown() to make sure all database connections are gracefully shutdown");
    }

    public abstract int update(Uri uri, ContentValues contentvalues, String s, String as[]);

    private static final String TAG = "ContentProvider";
    private Context mContext;
    private boolean mExported;
    private int mMyUid;
    private PathPermission mPathPermissions[];
    private String mReadPermission;
    private Transport mTransport;
    private String mWritePermission;


}
