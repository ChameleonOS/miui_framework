// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.accounts.Account;
import android.app.*;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.database.*;
import android.net.Uri;
import android.os.*;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import dalvik.system.CloseGuard;
import java.io.*;
import java.util.*;

// Referenced classes of package android.content:
//            IContentService, SyncInfo, ContentProviderClient, OperationApplicationException, 
//            IContentProvider, Context, SyncStatusObserver, SyncAdapterType, 
//            SyncStatusInfo, ContentProviderResult, ContentValues

public abstract class ContentResolver {
    private final class ParcelFileDescriptorInner extends ParcelFileDescriptor {

        public void close() throws IOException {
            if(!mReleaseProviderFlag) {
                super.close();
                releaseProvider(mContentProvider);
                mReleaseProviderFlag = true;
            }
        }

        protected void finalize() throws Throwable {
            if(!mReleaseProviderFlag)
                close();
        }

        private final IContentProvider mContentProvider;
        private boolean mReleaseProviderFlag;
        final ContentResolver this$0;

        ParcelFileDescriptorInner(ParcelFileDescriptor parcelfiledescriptor, IContentProvider icontentprovider) {
            this$0 = ContentResolver.this;
            super(parcelfiledescriptor);
            mReleaseProviderFlag = false;
            mContentProvider = icontentprovider;
        }
    }

    private final class CursorWrapperInner extends CrossProcessCursorWrapper {

        public void close() {
            super.close();
            releaseProvider(mContentProvider);
            mProviderReleased = true;
            if(mCloseGuard != null)
                mCloseGuard.close();
        }

        protected void finalize() throws Throwable {
            if(mCloseGuard != null)
                mCloseGuard.warnIfOpen();
            if(!mProviderReleased && mContentProvider != null) {
                Log.w("CursorWrapperInner", "Cursor finalized without prior close()");
                releaseProvider(mContentProvider);
            }
            super.finalize();
            return;
            Exception exception;
            exception;
            super.finalize();
            throw exception;
        }

        public static final String TAG = "CursorWrapperInner";
        private final CloseGuard mCloseGuard = CloseGuard.get();
        private final IContentProvider mContentProvider;
        private boolean mProviderReleased;
        final ContentResolver this$0;

        CursorWrapperInner(Cursor cursor, IContentProvider icontentprovider) {
            this$0 = ContentResolver.this;
            super(cursor);
            mContentProvider = icontentprovider;
            mCloseGuard.open("close");
        }
    }

    public class OpenResourceIdResult {

        public int id;
        public Resources r;
        final ContentResolver this$0;

        public OpenResourceIdResult() {
            this$0 = ContentResolver.this;
            super();
        }
    }


    public ContentResolver(Context context) {
        mContext = context;
    }

    public static void addPeriodicSync(Account account, String s, Bundle bundle, long l) {
        validateSyncExtrasBundle(bundle);
        if(account == null)
            throw new IllegalArgumentException("account must not be null");
        if(s == null)
            throw new IllegalArgumentException("authority must not be null");
        if(bundle.getBoolean("force", false) || bundle.getBoolean("do_not_retry", false) || bundle.getBoolean("ignore_backoff", false) || bundle.getBoolean("ignore_settings", false) || bundle.getBoolean("initialize", false) || bundle.getBoolean("force", false) || bundle.getBoolean("expedited", false))
            throw new IllegalArgumentException("illegal extras were set");
        getContentService().addPeriodicSync(account, s, bundle, l);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static Object addStatusChangeListener(int i, final SyncStatusObserver callback) {
        if(callback == null)
            throw new IllegalArgumentException("you passed in a null callback");
        ISyncStatusObserver.Stub stub;
        try {
            stub = new ISyncStatusObserver.Stub() {

                public void onStatusChanged(int j) throws RemoteException {
                    callback.onStatusChanged(j);
                }

                final SyncStatusObserver val$callback;

             {
                callback = syncstatusobserver;
                super();
            }
            };
            getContentService().addStatusChangeListener(i, stub);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("the ContentService should always be reachable", remoteexception);
        }
        return stub;
    }

    public static void cancelSync(Account account, String s) {
        getContentService().cancelSync(account, s);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static IContentService getContentService() {
        IContentService icontentservice;
        if(sContentService != null) {
            icontentservice = sContentService;
        } else {
            sContentService = IContentService.Stub.asInterface(ServiceManager.getService("content"));
            icontentservice = sContentService;
        }
        return icontentservice;
    }

    public static SyncInfo getCurrentSync() {
        SyncInfo syncinfo;
        try {
            List list = getContentService().getCurrentSyncs();
            if(list.isEmpty())
                syncinfo = null;
            else
                syncinfo = (SyncInfo)list.get(0);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("the ContentService should always be reachable", remoteexception);
        }
        return syncinfo;
    }

    public static List getCurrentSyncs() {
        List list;
        try {
            list = getContentService().getCurrentSyncs();
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("the ContentService should always be reachable", remoteexception);
        }
        return list;
    }

    public static int getIsSyncable(Account account, String s) {
        int i;
        try {
            i = getContentService().getIsSyncable(account, s);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("the ContentService should always be reachable", remoteexception);
        }
        return i;
    }

    public static boolean getMasterSyncAutomatically() {
        boolean flag;
        try {
            flag = getContentService().getMasterSyncAutomatically();
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("the ContentService should always be reachable", remoteexception);
        }
        return flag;
    }

    public static List getPeriodicSyncs(Account account, String s) {
        if(account == null)
            throw new IllegalArgumentException("account must not be null");
        if(s == null)
            throw new IllegalArgumentException("authority must not be null");
        List list;
        try {
            list = getContentService().getPeriodicSyncs(account, s);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("the ContentService should always be reachable", remoteexception);
        }
        return list;
    }

    public static SyncAdapterType[] getSyncAdapterTypes() {
        SyncAdapterType asyncadaptertype[];
        try {
            asyncadaptertype = getContentService().getSyncAdapterTypes();
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("the ContentService should always be reachable", remoteexception);
        }
        return asyncadaptertype;
    }

    public static boolean getSyncAutomatically(Account account, String s) {
        boolean flag;
        try {
            flag = getContentService().getSyncAutomatically(account, s);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("the ContentService should always be reachable", remoteexception);
        }
        return flag;
    }

    public static SyncStatusInfo getSyncStatus(Account account, String s) {
        SyncStatusInfo syncstatusinfo;
        try {
            syncstatusinfo = getContentService().getSyncStatus(account, s);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("the ContentService should always be reachable", remoteexception);
        }
        return syncstatusinfo;
    }

    public static boolean isSyncActive(Account account, String s) {
        boolean flag;
        try {
            flag = getContentService().isSyncActive(account, s);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("the ContentService should always be reachable", remoteexception);
        }
        return flag;
    }

    public static boolean isSyncPending(Account account, String s) {
        boolean flag;
        try {
            flag = getContentService().isSyncPending(account, s);
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("the ContentService should always be reachable", remoteexception);
        }
        return flag;
    }

    private void maybeLogQueryToEventLog(long l, Uri uri, String as[], String s, String s1) {
        int i;
        StringBuilder stringbuilder;
        i = samplePercentForDuration(l);
        if(i < 100)
            synchronized(mRandom) {
                if(mRandom.nextInt(100) >= i)
                    break MISSING_BLOCK_LABEL_227;
            }
        stringbuilder = new StringBuilder(100);
        if(as != null) {
            for(int j = 0; j < as.length; j++) {
                if(j != 0)
                    stringbuilder.append('/');
                stringbuilder.append(as[j]);
            }

        }
        break MISSING_BLOCK_LABEL_111;
        exception;
        random;
        JVM INSTR monitorexit ;
        throw exception;
        String s2 = AppGlobals.getInitialPackage();
        Object aobj[] = new Object[7];
        aobj[0] = uri.toString();
        aobj[1] = stringbuilder.toString();
        if(s == null)
            s = "";
        aobj[2] = s;
        if(s1 == null)
            s1 = "";
        aobj[3] = s1;
        aobj[4] = Long.valueOf(l);
        if(s2 == null)
            s2 = "";
        aobj[5] = s2;
        aobj[6] = Integer.valueOf(i);
        EventLog.writeEvent(52002, aobj);
    }

    private void maybeLogUpdateToEventLog(long l, Uri uri, String s, String s1) {
        int i = samplePercentForDuration(l);
        if(i < 100)
            synchronized(mRandom) {
                if(mRandom.nextInt(100) >= i)
                    break MISSING_BLOCK_LABEL_147;
            }
        String s2 = AppGlobals.getInitialPackage();
        Object aobj[] = new Object[6];
        aobj[0] = uri.toString();
        aobj[1] = s;
        if(s1 == null)
            s1 = "";
        aobj[2] = s1;
        aobj[3] = Long.valueOf(l);
        if(s2 == null)
            s2 = "";
        aobj[4] = s2;
        aobj[5] = Integer.valueOf(i);
        EventLog.writeEvent(52003, aobj);
          goto _L1
        exception;
        random;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
    }

    public static int modeToMode(Uri uri, String s) throws FileNotFoundException {
        int i;
        if("r".equals(s))
            i = 0x10000000;
        else
        if("w".equals(s) || "wt".equals(s))
            i = 0x2c000000;
        else
        if("wa".equals(s))
            i = 0x2a000000;
        else
        if("rw".equals(s))
            i = 0x38000000;
        else
        if("rwt".equals(s))
            i = 0x3c000000;
        else
            throw new FileNotFoundException((new StringBuilder()).append("Bad mode for ").append(uri).append(": ").append(s).toString());
        return i;
    }

    public static void removePeriodicSync(Account account, String s, Bundle bundle) {
        validateSyncExtrasBundle(bundle);
        if(account == null)
            throw new IllegalArgumentException("account must not be null");
        if(s == null)
            throw new IllegalArgumentException("authority must not be null");
        try {
            getContentService().removePeriodicSync(account, s, bundle);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new RuntimeException("the ContentService should always be reachable", remoteexception);
        }
    }

    public static void removeStatusChangeListener(Object obj) {
        if(obj == null)
            throw new IllegalArgumentException("you passed in a null handle");
        getContentService().removeStatusChangeListener((ISyncStatusObserver.Stub)obj);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static void requestSync(Account account, String s, Bundle bundle) {
        validateSyncExtrasBundle(bundle);
        getContentService().requestSync(account, s, bundle);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private int samplePercentForDuration(long l) {
        int i;
        if(l >= 500L)
            i = 100;
        else
            i = 1 + (int)((100L * l) / 500L);
        return i;
    }

    public static void setIsSyncable(Account account, String s, int i) {
        getContentService().setIsSyncable(account, s, i);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static void setMasterSyncAutomatically(boolean flag) {
        getContentService().setMasterSyncAutomatically(flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static void setSyncAutomatically(Account account, String s, boolean flag) {
        getContentService().setSyncAutomatically(account, s, flag);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static void validateSyncExtrasBundle(Bundle bundle) {
        try {
            for(Iterator iterator = bundle.keySet().iterator(); iterator.hasNext();) {
                Object obj = bundle.get((String)iterator.next());
                if(obj != null && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Boolean) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof String) && !(obj instanceof Account))
                    throw new IllegalArgumentException((new StringBuilder()).append("unexpected value type: ").append(obj.getClass().getName()).toString());
            }

        }
        catch(IllegalArgumentException illegalargumentexception) {
            throw illegalargumentexception;
        }
        catch(RuntimeException runtimeexception) {
            throw new IllegalArgumentException("error unparceling Bundle", runtimeexception);
        }
    }

    public final ContentProviderClient acquireContentProviderClient(Uri uri) {
        IContentProvider icontentprovider = acquireProvider(uri);
        ContentProviderClient contentproviderclient;
        if(icontentprovider != null)
            contentproviderclient = new ContentProviderClient(this, icontentprovider, true);
        else
            contentproviderclient = null;
        return contentproviderclient;
    }

    public final ContentProviderClient acquireContentProviderClient(String s) {
        IContentProvider icontentprovider = acquireProvider(s);
        ContentProviderClient contentproviderclient;
        if(icontentprovider != null)
            contentproviderclient = new ContentProviderClient(this, icontentprovider, true);
        else
            contentproviderclient = null;
        return contentproviderclient;
    }

    protected IContentProvider acquireExistingProvider(Context context, String s) {
        return acquireProvider(context, s);
    }

    public final IContentProvider acquireExistingProvider(Uri uri) {
        IContentProvider icontentprovider;
        icontentprovider = null;
        break MISSING_BLOCK_LABEL_2;
        if("content".equals(uri.getScheme()) && uri.getAuthority() != null)
            icontentprovider = acquireExistingProvider(mContext, uri.getAuthority());
        return icontentprovider;
    }

    protected abstract IContentProvider acquireProvider(Context context, String s);

    public final IContentProvider acquireProvider(Uri uri) {
        IContentProvider icontentprovider;
        icontentprovider = null;
        break MISSING_BLOCK_LABEL_2;
        if("content".equals(uri.getScheme()) && uri.getAuthority() != null)
            icontentprovider = acquireProvider(mContext, uri.getAuthority());
        return icontentprovider;
    }

    public final IContentProvider acquireProvider(String s) {
        IContentProvider icontentprovider;
        if(s == null)
            icontentprovider = null;
        else
            icontentprovider = acquireProvider(mContext, s);
        return icontentprovider;
    }

    public final ContentProviderClient acquireUnstableContentProviderClient(Uri uri) {
        IContentProvider icontentprovider = acquireUnstableProvider(uri);
        ContentProviderClient contentproviderclient;
        if(icontentprovider != null)
            contentproviderclient = new ContentProviderClient(this, icontentprovider, false);
        else
            contentproviderclient = null;
        return contentproviderclient;
    }

    public final ContentProviderClient acquireUnstableContentProviderClient(String s) {
        IContentProvider icontentprovider = acquireUnstableProvider(s);
        ContentProviderClient contentproviderclient;
        if(icontentprovider != null)
            contentproviderclient = new ContentProviderClient(this, icontentprovider, false);
        else
            contentproviderclient = null;
        return contentproviderclient;
    }

    protected abstract IContentProvider acquireUnstableProvider(Context context, String s);

    public final IContentProvider acquireUnstableProvider(Uri uri) {
        IContentProvider icontentprovider;
        icontentprovider = null;
        break MISSING_BLOCK_LABEL_2;
        if("content".equals(uri.getScheme()) && uri.getAuthority() != null)
            icontentprovider = acquireUnstableProvider(mContext, uri.getAuthority());
        return icontentprovider;
    }

    public final IContentProvider acquireUnstableProvider(String s) {
        IContentProvider icontentprovider;
        if(s == null)
            icontentprovider = null;
        else
            icontentprovider = acquireUnstableProvider(mContext, s);
        return icontentprovider;
    }

    public ContentProviderResult[] applyBatch(String s, ArrayList arraylist) throws RemoteException, OperationApplicationException {
        ContentProviderClient contentproviderclient;
        contentproviderclient = acquireContentProviderClient(s);
        if(contentproviderclient == null)
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown authority ").append(s).toString());
        ContentProviderResult acontentproviderresult[] = contentproviderclient.applyBatch(arraylist);
        contentproviderclient.release();
        return acontentproviderresult;
        Exception exception;
        exception;
        contentproviderclient.release();
        throw exception;
    }

    public final int bulkInsert(Uri uri, ContentValues acontentvalues[]) {
        Exception exception;
        IContentProvider icontentprovider = acquireProvider(uri);
        if(icontentprovider == null)
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown URL ").append(uri).toString());
        int i;
        try {
            long l = SystemClock.uptimeMillis();
            i = icontentprovider.bulkInsert(uri, acontentvalues);
            maybeLogUpdateToEventLog(SystemClock.uptimeMillis() - l, uri, "bulkinsert", null);
        }
        catch(RemoteException remoteexception) {
            i = 0;
        }
        finally {
            releaseProvider(icontentprovider);
        }
        releaseProvider(icontentprovider);
        return i;
        throw exception;
    }

    public final Bundle call(Uri uri, String s, String s1, Bundle bundle) {
        IContentProvider icontentprovider;
        if(uri == null)
            throw new NullPointerException("uri == null");
        if(s == null)
            throw new NullPointerException("method == null");
        icontentprovider = acquireProvider(uri);
        if(icontentprovider == null)
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown URI ").append(uri).toString());
        Bundle bundle2 = icontentprovider.call(s, s1, bundle);
        Bundle bundle1 = bundle2;
_L2:
        releaseProvider(icontentprovider);
        return bundle1;
        RemoteException remoteexception;
        remoteexception;
        bundle1 = null;
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        releaseProvider(icontentprovider);
        throw exception;
    }

    public void cancelSync(Uri uri) {
        String s;
        if(uri != null)
            s = uri.getAuthority();
        else
            s = null;
        cancelSync(null, s);
    }

    public final int delete(Uri uri, String s, String as[]) {
        Exception exception;
        IContentProvider icontentprovider = acquireProvider(uri);
        if(icontentprovider == null)
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown URL ").append(uri).toString());
        int i;
        try {
            long l = SystemClock.uptimeMillis();
            i = icontentprovider.delete(uri, s, as);
            maybeLogUpdateToEventLog(SystemClock.uptimeMillis() - l, uri, "delete", s);
        }
        catch(RemoteException remoteexception) {
            i = -1;
        }
        finally {
            releaseProvider(icontentprovider);
        }
        releaseProvider(icontentprovider);
        return i;
        throw exception;
    }

    public OpenResourceIdResult getResourceId(Uri uri) throws FileNotFoundException {
        String s = uri.getAuthority();
        if(TextUtils.isEmpty(s))
            throw new FileNotFoundException((new StringBuilder()).append("No authority: ").append(uri).toString());
        Resources resources;
        List list;
        try {
            resources = mContext.getPackageManager().getResourcesForApplication(s);
        }
        catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) {
            throw new FileNotFoundException((new StringBuilder()).append("No package found for authority: ").append(uri).toString());
        }
        list = uri.getPathSegments();
        if(list == null)
            throw new FileNotFoundException((new StringBuilder()).append("No path: ").append(uri).toString());
        int i = list.size();
        int j;
        if(i == 1) {
            int k;
            try {
                k = Integer.parseInt((String)list.get(0));
            }
            catch(NumberFormatException numberformatexception) {
                throw new FileNotFoundException((new StringBuilder()).append("Single path segment is not a resource ID: ").append(uri).toString());
            }
            j = k;
        } else
        if(i == 2)
            j = resources.getIdentifier((String)list.get(1), (String)list.get(0), s);
        else
            throw new FileNotFoundException((new StringBuilder()).append("More than two path segments: ").append(uri).toString());
        if(j == 0) {
            throw new FileNotFoundException((new StringBuilder()).append("No resource found for: ").append(uri).toString());
        } else {
            OpenResourceIdResult openresourceidresult = new OpenResourceIdResult();
            openresourceidresult.r = resources;
            openresourceidresult.id = j;
            return openresourceidresult;
        }
    }

    public String[] getStreamTypes(Uri uri, String s) {
        String as[];
        IContentProvider icontentprovider;
        as = null;
        icontentprovider = acquireProvider(uri);
        if(icontentprovider != null) goto _L2; else goto _L1
_L1:
        return as;
_L2:
        String as1[] = icontentprovider.getStreamTypes(uri, s);
        as = as1;
_L4:
        releaseProvider(icontentprovider);
        if(true) goto _L1; else goto _L3
_L3:
        RemoteException remoteexception;
        remoteexception;
          goto _L4
        Exception exception;
        exception;
        releaseProvider(icontentprovider);
        throw exception;
    }

    public final String getType(Uri uri) {
        String s;
        IContentProvider icontentprovider;
        s = null;
        icontentprovider = acquireExistingProvider(uri);
        if(icontentprovider == null) goto _L2; else goto _L1
_L1:
        String s2 = icontentprovider.getType(uri);
        s = s2;
_L3:
        releaseProvider(icontentprovider);
_L5:
        return s;
        RemoteException remoteexception1;
        remoteexception1;
          goto _L3
        Exception exception2;
        exception2;
        Log.w("ContentResolver", (new StringBuilder()).append("Failed to get type for: ").append(uri).append(" (").append(exception2.getMessage()).append(")").toString());
          goto _L3
        Exception exception1;
        exception1;
        releaseProvider(icontentprovider);
        throw exception1;
_L2:
        if(!"content".equals(uri.getScheme())) goto _L5; else goto _L4
_L4:
        String s1 = ActivityManagerNative.getDefault().getProviderMimeType(uri);
        s = s1;
          goto _L5
        RemoteException remoteexception;
        remoteexception;
          goto _L5
        Exception exception;
        exception;
        Log.w("ContentResolver", (new StringBuilder()).append("Failed to get type for: ").append(uri).append(" (").append(exception.getMessage()).append(")").toString());
          goto _L5
    }

    public final Uri insert(Uri uri, ContentValues contentvalues) {
        IContentProvider icontentprovider;
        icontentprovider = acquireProvider(uri);
        if(icontentprovider == null)
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown URL ").append(uri).toString());
        Uri uri1;
        long l = SystemClock.uptimeMillis();
        uri1 = icontentprovider.insert(uri, contentvalues);
        maybeLogUpdateToEventLog(SystemClock.uptimeMillis() - l, uri, "insert", null);
        releaseProvider(icontentprovider);
_L2:
        return uri1;
        RemoteException remoteexception;
        remoteexception;
        releaseProvider(icontentprovider);
        uri1 = null;
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        releaseProvider(icontentprovider);
        throw exception;
    }

    public void notifyChange(Uri uri, ContentObserver contentobserver) {
        notifyChange(uri, contentobserver, true);
    }

    public void notifyChange(Uri uri, ContentObserver contentobserver, boolean flag) {
        IContentService icontentservice = getContentService();
        if(contentobserver != null) goto _L2; else goto _L1
_L1:
        android.database.IContentObserver icontentobserver1 = null;
_L8:
        if(contentobserver == null || !contentobserver.deliverSelfNotifications()) goto _L4; else goto _L3
_L3:
        boolean flag1 = true;
_L6:
        icontentservice.notifyChange(uri, icontentobserver1, flag1, flag);
          goto _L5
_L2:
        android.database.IContentObserver icontentobserver = contentobserver.getContentObserver();
        icontentobserver1 = icontentobserver;
        continue; /* Loop/switch isn't completed */
_L4:
        flag1 = false;
          goto _L6
        RemoteException remoteexception;
        remoteexception;
_L5:
        return;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public final AssetFileDescriptor openAssetFileDescriptor(Uri uri, String s) throws FileNotFoundException {
        AssetFileDescriptor assetfiledescriptor;
        String s1;
        assetfiledescriptor = null;
        s1 = uri.getScheme();
        if(!"android.resource".equals(s1)) goto _L2; else goto _L1
_L1:
        if(!"r".equals(s))
            throw new FileNotFoundException((new StringBuilder()).append("Can't write resources: ").append(uri).toString());
        OpenResourceIdResult openresourceidresult = getResourceId(uri);
        AssetFileDescriptor assetfiledescriptor4;
        try {
            assetfiledescriptor4 = openresourceidresult.r.openRawResourceFd(openresourceidresult.id);
        }
        catch(android.content.res.Resources.NotFoundException notfoundexception) {
            throw new FileNotFoundException((new StringBuilder()).append("Resource does not exist: ").append(uri).toString());
        }
        assetfiledescriptor = assetfiledescriptor4;
_L8:
        return assetfiledescriptor;
_L2:
        IContentProvider icontentprovider;
        IContentProvider icontentprovider1;
        if("file".equals(s1)) {
            assetfiledescriptor = new AssetFileDescriptor(ParcelFileDescriptor.open(new File(uri.getPath()), modeToMode(uri, s)), 0L, -1L);
            continue; /* Loop/switch isn't completed */
        }
        if("r".equals(s)) {
            assetfiledescriptor = openTypedAssetFileDescriptor(uri, "*/*", null);
            continue; /* Loop/switch isn't completed */
        }
        icontentprovider = acquireUnstableProvider(uri);
        if(icontentprovider == null)
            throw new FileNotFoundException((new StringBuilder()).append("No content provider: ").append(uri).toString());
        icontentprovider1 = null;
        AssetFileDescriptor assetfiledescriptor3 = icontentprovider.openAssetFile(uri, s);
        AssetFileDescriptor assetfiledescriptor2;
        assetfiledescriptor2 = assetfiledescriptor3;
        if(assetfiledescriptor2 != null)
            break; /* Loop/switch isn't completed */
        if(false)
            releaseProvider(null);
        if(icontentprovider == null)
            continue; /* Loop/switch isn't completed */
_L6:
        releaseUnstableProvider(icontentprovider);
        if(true) goto _L4; else goto _L3
_L4:
        DeadObjectException deadobjectexception;
        break; /* Loop/switch isn't completed */
        deadobjectexception;
        unstableProviderDied(icontentprovider);
        icontentprovider1 = acquireProvider(uri);
        if(icontentprovider1 == null)
            throw new FileNotFoundException((new StringBuilder()).append("No content provider: ").append(uri).toString());
        break MISSING_BLOCK_LABEL_375;
        RemoteException remoteexception;
        remoteexception;
        throw new FileNotFoundException((new StringBuilder()).append("Failed opening content provider: ").append(uri).toString());
        Exception exception;
        exception;
        if(icontentprovider1 != null)
            releaseProvider(icontentprovider1);
        if(icontentprovider != null)
            releaseUnstableProvider(icontentprovider);
        throw exception;
        AssetFileDescriptor assetfiledescriptor1 = icontentprovider1.openAssetFile(uri, s);
        assetfiledescriptor2 = assetfiledescriptor1;
        if(assetfiledescriptor2 != null) goto _L3; else goto _L5
_L5:
        if(icontentprovider1 != null)
            releaseProvider(icontentprovider1);
        if(icontentprovider == null) goto _L7; else goto _L6
_L7:
        break; /* Loop/switch isn't completed */
_L3:
        if(icontentprovider1 != null)
            break MISSING_BLOCK_LABEL_427;
        icontentprovider1 = acquireProvider(uri);
        releaseUnstableProvider(icontentprovider);
        ParcelFileDescriptorInner parcelfiledescriptorinner = new ParcelFileDescriptorInner(assetfiledescriptor2.getParcelFileDescriptor(), icontentprovider1);
        icontentprovider1 = null;
        assetfiledescriptor = new AssetFileDescriptor(parcelfiledescriptorinner, assetfiledescriptor2.getStartOffset(), assetfiledescriptor2.getDeclaredLength());
        if(false)
            releaseProvider(null);
        if(icontentprovider == null) goto _L8; else goto _L6
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        throw filenotfoundexception;
    }

    public final ParcelFileDescriptor openFileDescriptor(Uri uri, String s) throws FileNotFoundException {
        AssetFileDescriptor assetfiledescriptor = openAssetFileDescriptor(uri, s);
        if(assetfiledescriptor != null) goto _L2; else goto _L1
_L1:
        ParcelFileDescriptor parcelfiledescriptor = null;
_L4:
        return parcelfiledescriptor;
_L2:
        if(assetfiledescriptor.getDeclaredLength() >= 0L)
            break; /* Loop/switch isn't completed */
        parcelfiledescriptor = assetfiledescriptor.getParcelFileDescriptor();
        if(true) goto _L4; else goto _L3
_L3:
        try {
            assetfiledescriptor.close();
        }
        catch(IOException ioexception) { }
        throw new FileNotFoundException("Not a whole file");
    }

    public final InputStream openInputStream(Uri uri) throws FileNotFoundException {
        String s = uri.getScheme();
        Object obj;
        if("android.resource".equals(s)) {
            OpenResourceIdResult openresourceidresult = getResourceId(uri);
            InputStream inputstream;
            try {
                inputstream = openresourceidresult.r.openRawResource(openresourceidresult.id);
            }
            catch(android.content.res.Resources.NotFoundException notfoundexception) {
                throw new FileNotFoundException((new StringBuilder()).append("Resource does not exist: ").append(uri).toString());
            }
            obj = inputstream;
        } else
        if("file".equals(s)) {
            obj = new FileInputStream(uri.getPath());
        } else {
            AssetFileDescriptor assetfiledescriptor = openAssetFileDescriptor(uri, "r");
            if(assetfiledescriptor != null) {
                FileInputStream fileinputstream;
                FileInputStream fileinputstream1;
                try {
                    fileinputstream1 = assetfiledescriptor.createInputStream();
                }
                catch(IOException ioexception) {
                    throw new FileNotFoundException("Unable to create stream");
                }
                fileinputstream = fileinputstream1;
            } else {
                fileinputstream = null;
            }
            obj = fileinputstream;
        }
        return ((InputStream) (obj));
    }

    public final OutputStream openOutputStream(Uri uri) throws FileNotFoundException {
        return openOutputStream(uri, "w");
    }

    public final OutputStream openOutputStream(Uri uri, String s) throws FileNotFoundException {
        AssetFileDescriptor assetfiledescriptor = openAssetFileDescriptor(uri, s);
        if(assetfiledescriptor != null) {
            java.io.FileOutputStream fileoutputstream;
            java.io.FileOutputStream fileoutputstream1;
            try {
                fileoutputstream1 = assetfiledescriptor.createOutputStream();
            }
            catch(IOException ioexception) {
                throw new FileNotFoundException("Unable to create stream");
            }
            fileoutputstream = fileoutputstream1;
        } else {
            fileoutputstream = null;
        }
        return fileoutputstream;
    }

    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri, String s, Bundle bundle) throws FileNotFoundException {
        AssetFileDescriptor assetfiledescriptor;
        IContentProvider icontentprovider;
        IContentProvider icontentprovider1;
        assetfiledescriptor = null;
        icontentprovider = acquireUnstableProvider(uri);
        if(icontentprovider == null)
            throw new FileNotFoundException((new StringBuilder()).append("No content provider: ").append(uri).toString());
        icontentprovider1 = null;
        AssetFileDescriptor assetfiledescriptor3 = icontentprovider.openTypedAssetFile(uri, s, bundle);
        AssetFileDescriptor assetfiledescriptor2 = assetfiledescriptor3;
        if(assetfiledescriptor2 != null) goto _L2; else goto _L1
_L1:
        if(false)
            releaseProvider(null);
        if(icontentprovider == null) goto _L4; else goto _L3
_L3:
        releaseUnstableProvider(icontentprovider);
_L4:
        return assetfiledescriptor;
        DeadObjectException deadobjectexception;
        deadobjectexception;
        unstableProviderDied(icontentprovider);
        icontentprovider1 = acquireProvider(uri);
        if(icontentprovider1 == null)
            throw new FileNotFoundException((new StringBuilder()).append("No content provider: ").append(uri).toString());
        break MISSING_BLOCK_LABEL_199;
        RemoteException remoteexception;
        remoteexception;
        throw new FileNotFoundException((new StringBuilder()).append("Failed opening content provider: ").append(uri).toString());
        Exception exception;
        exception;
        if(icontentprovider1 != null)
            releaseProvider(icontentprovider1);
        if(icontentprovider != null)
            releaseUnstableProvider(icontentprovider);
        throw exception;
        AssetFileDescriptor assetfiledescriptor1 = icontentprovider1.openTypedAssetFile(uri, s, bundle);
        assetfiledescriptor2 = assetfiledescriptor1;
        if(assetfiledescriptor2 != null) goto _L2; else goto _L5
_L5:
        if(icontentprovider1 != null)
            releaseProvider(icontentprovider1);
        if(icontentprovider == null) goto _L4; else goto _L6
_L6:
        break; /* Loop/switch isn't completed */
_L2:
        if(icontentprovider1 != null)
            break MISSING_BLOCK_LABEL_252;
        icontentprovider1 = acquireProvider(uri);
        releaseUnstableProvider(icontentprovider);
        ParcelFileDescriptorInner parcelfiledescriptorinner = new ParcelFileDescriptorInner(assetfiledescriptor2.getParcelFileDescriptor(), icontentprovider1);
        icontentprovider1 = null;
        assetfiledescriptor = new AssetFileDescriptor(parcelfiledescriptorinner, assetfiledescriptor2.getStartOffset(), assetfiledescriptor2.getDeclaredLength());
        if(false)
            releaseProvider(null);
        if(icontentprovider == null) goto _L4; else goto _L3
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        throw filenotfoundexception;
    }

    public final Cursor query(Uri uri, String as[], String s, String as1[], String s1) {
        return query(uri, as, s, as1, s1, null);
    }

    public final Cursor query(Uri uri, String as[], String s, String as1[], String s1, CancellationSignal cancellationsignal) {
        IContentProvider icontentprovider = acquireUnstableProvider(uri);
        if(icontentprovider != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L6:
        return ((Cursor) (obj));
_L2:
        IContentProvider icontentprovider1 = null;
        long l;
        android.os.ICancellationSignal icancellationsignal;
        l = SystemClock.uptimeMillis();
        icancellationsignal = null;
        if(cancellationsignal != null) {
            cancellationsignal.throwIfCanceled();
            icancellationsignal = icontentprovider.createCancellationSignal();
            cancellationsignal.setRemote(icancellationsignal);
        }
        Cursor cursor1 = icontentprovider.query(uri, as, s, as1, s1, icancellationsignal);
        Cursor cursor = cursor1;
_L8:
        if(cursor != null) goto _L4; else goto _L3
_L3:
        obj = null;
        if(icontentprovider != null)
            releaseUnstableProvider(icontentprovider);
        if(icontentprovider1 == null) goto _L6; else goto _L5
_L5:
        releaseProvider(icontentprovider1);
        break; /* Loop/switch isn't completed */
        DeadObjectException deadobjectexception;
        deadobjectexception;
        IContentProvider icontentprovider2;
        unstableProviderDied(icontentprovider);
        icontentprovider2 = acquireProvider(uri);
        icontentprovider1 = icontentprovider2;
        if(icontentprovider1 != null)
            break MISSING_BLOCK_LABEL_159;
        obj = null;
        if(icontentprovider != null)
            releaseUnstableProvider(icontentprovider);
        if(icontentprovider1 == null) goto _L7; else goto _L5
_L7:
        break; /* Loop/switch isn't completed */
        android.os.ICancellationSignal icancellationsignal1 = icancellationsignal;
        cursor = icontentprovider1.query(uri, as, s, as1, s1, icancellationsignal1);
          goto _L8
_L4:
        cursor.getCount();
        maybeLogQueryToEventLog(SystemClock.uptimeMillis() - l, uri, as, s, s1);
        if(icontentprovider1 == null) goto _L10; else goto _L9
_L9:
        IContentProvider icontentprovider4 = icontentprovider1;
_L12:
        obj = new CursorWrapperInner(cursor, icontentprovider4);
        icontentprovider1 = null;
        if(icontentprovider != null)
            releaseUnstableProvider(icontentprovider);
        if(true) goto _L11; else goto _L5
_L11:
        break; /* Loop/switch isn't completed */
_L10:
        IContentProvider icontentprovider3 = acquireProvider(uri);
        icontentprovider4 = icontentprovider3;
          goto _L12
        RemoteException remoteexception;
        remoteexception;
        obj = null;
        if(icontentprovider != null)
            releaseUnstableProvider(icontentprovider);
        if(icontentprovider1 == null) goto _L6; else goto _L5
        Exception exception;
        exception;
        if(icontentprovider != null)
            releaseUnstableProvider(icontentprovider);
        if(icontentprovider1 != null)
            releaseProvider(icontentprovider1);
        throw exception;
    }

    public final void registerContentObserver(Uri uri, boolean flag, ContentObserver contentobserver) {
        getContentService().registerContentObserver(uri, flag, contentobserver.getContentObserver());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public abstract boolean releaseProvider(IContentProvider icontentprovider);

    public abstract boolean releaseUnstableProvider(IContentProvider icontentprovider);

    public void startSync(Uri uri, Bundle bundle) {
        Account account = null;
        if(bundle != null) {
            String s1 = bundle.getString("account");
            if(!TextUtils.isEmpty(s1))
                account = new Account(s1, "com.google");
            bundle.remove("account");
        }
        String s;
        if(uri != null)
            s = uri.getAuthority();
        else
            s = null;
        requestSync(account, s, bundle);
    }

    public final void unregisterContentObserver(ContentObserver contentobserver) {
        android.database.IContentObserver icontentobserver = contentobserver.releaseContentObserver();
        if(icontentobserver != null)
            getContentService().unregisterContentObserver(icontentobserver);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public abstract void unstableProviderDied(IContentProvider icontentprovider);

    public final int update(Uri uri, ContentValues contentvalues, String s, String as[]) {
        Exception exception;
        IContentProvider icontentprovider = acquireProvider(uri);
        if(icontentprovider == null)
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown URI ").append(uri).toString());
        int i;
        try {
            long l = SystemClock.uptimeMillis();
            i = icontentprovider.update(uri, contentvalues, s, as);
            maybeLogUpdateToEventLog(SystemClock.uptimeMillis() - l, uri, "update", s);
        }
        catch(RemoteException remoteexception) {
            i = -1;
        }
        finally {
            releaseProvider(icontentprovider);
        }
        releaseProvider(icontentprovider);
        return i;
        throw exception;
    }

    public static final String CONTENT_SERVICE_NAME = "content";
    public static final String CURSOR_DIR_BASE_TYPE = "vnd.android.cursor.dir";
    public static final String CURSOR_ITEM_BASE_TYPE = "vnd.android.cursor.item";
    public static final String SCHEME_ANDROID_RESOURCE = "android.resource";
    public static final String SCHEME_CONTENT = "content";
    public static final String SCHEME_FILE = "file";
    private static final int SLOW_THRESHOLD_MILLIS = 500;
    public static final int SYNC_ERROR_AUTHENTICATION = 2;
    public static final int SYNC_ERROR_CONFLICT = 5;
    public static final int SYNC_ERROR_INTERNAL = 8;
    public static final int SYNC_ERROR_IO = 3;
    public static final int SYNC_ERROR_PARSE = 4;
    public static final int SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS = 1;
    public static final int SYNC_ERROR_TOO_MANY_DELETIONS = 6;
    public static final int SYNC_ERROR_TOO_MANY_RETRIES = 7;
    public static final String SYNC_EXTRAS_ACCOUNT = "account";
    public static final String SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS = "discard_deletions";
    public static final String SYNC_EXTRAS_DO_NOT_RETRY = "do_not_retry";
    public static final String SYNC_EXTRAS_EXPEDITED = "expedited";
    public static final String SYNC_EXTRAS_FORCE = "force";
    public static final String SYNC_EXTRAS_IGNORE_BACKOFF = "ignore_backoff";
    public static final String SYNC_EXTRAS_IGNORE_SETTINGS = "ignore_settings";
    public static final String SYNC_EXTRAS_INITIALIZE = "initialize";
    public static final String SYNC_EXTRAS_MANUAL = "force";
    public static final String SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS = "deletions_override";
    public static final String SYNC_EXTRAS_UPLOAD = "upload";
    public static final int SYNC_OBSERVER_TYPE_ACTIVE = 4;
    public static final int SYNC_OBSERVER_TYPE_ALL = 0x7fffffff;
    public static final int SYNC_OBSERVER_TYPE_PENDING = 2;
    public static final int SYNC_OBSERVER_TYPE_SETTINGS = 1;
    public static final int SYNC_OBSERVER_TYPE_STATUS = 8;
    private static final String TAG = "ContentResolver";
    private static IContentService sContentService;
    private final Context mContext;
    private final Random mRandom = new Random();
}
