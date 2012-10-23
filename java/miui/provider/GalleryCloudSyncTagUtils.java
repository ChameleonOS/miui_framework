// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.provider;

import android.accounts.Account;
import android.content.*;
import android.database.Cursor;

// Referenced classes of package miui.provider:
//            GalleryCloudUtils

public class GalleryCloudSyncTagUtils {

    public GalleryCloudSyncTagUtils() {
    }

    public static long getSyncTag(Context context, Account account) {
        Object obj = sSyncTagLock;
        obj;
        JVM INSTR monitorenter ;
        Cursor cursor = null;
        long l1;
        cursor = getSyncTagCursorByAccount(context, account);
        if(cursor == null || !cursor.moveToNext())
            break MISSING_BLOCK_LABEL_55;
        l1 = cursor.getLong(0);
        long l;
        l = l1;
        if(cursor != null)
            cursor.close();
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_95;
        l = 1L;
        if(cursor != null)
            cursor.close();
        break MISSING_BLOCK_LABEL_95;
        Exception exception1;
        exception1;
        throw exception1;
        Exception exception;
        exception;
        if(cursor == null)
            break MISSING_BLOCK_LABEL_92;
        cursor.close();
        throw exception;
        return l;
    }

    private static Cursor getSyncTagCursorByAccount(Context context, Account account) {
        ContentResolver contentresolver = context.getContentResolver();
        android.net.Uri uri = GalleryCloudUtils.CLOUD_SETTING_URI;
        String as[] = new String[1];
        as[0] = "syncTag";
        return contentresolver.query(uri, as, (new StringBuilder()).append("accountName = '").append(account.name).append("' and ").append("accountType").append(" = '").append(account.type).append("'").toString(), null, null);
    }

    public static void insertAccountToDB(Context context, Account account) {
        Object obj = sSyncTagLock;
        obj;
        JVM INSTR monitorenter ;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("accountName", account.name);
        contentvalues.put("accountType", account.type);
        internalUpdateAccount(context, account, contentvalues);
        return;
    }

    private static void internalUpdateAccount(Context context, Account account, ContentValues contentvalues) {
        ContentResolver contentresolver;
        Cursor cursor;
        contentresolver = context.getContentResolver();
        cursor = null;
        cursor = getSyncTagCursorByAccount(context, account);
        if(cursor != null && cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        contentvalues.put("syncTag", Integer.valueOf(1));
        contentresolver.insert(GalleryCloudUtils.CLOUD_SETTING_URI, contentvalues);
_L8:
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
_L4:
        return;
_L2:
        if(contentvalues.containsKey("syncTag")) goto _L6; else goto _L5
_L5:
        if(cursor == null) goto _L4; else goto _L3
_L6:
        if(cursor.getLong(0) != contentvalues.getAsLong("syncTag").longValue())
            contentresolver.update(GalleryCloudUtils.CLOUD_SETTING_URI, contentvalues, null, null);
        if(true) goto _L8; else goto _L7
_L7:
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
    }

    public static void setSyncTag(Context context, Account account, Long long1) {
        Object obj = sSyncTagLock;
        obj;
        JVM INSTR monitorenter ;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("syncTag", long1);
        internalUpdateAccount(context, account, contentvalues);
        return;
    }

    private static final String TAG = "GalleryCloudSyncTagUtils";
    private static final Object sSyncTagLock = new Object();

}
