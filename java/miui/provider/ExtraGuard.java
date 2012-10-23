// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.provider;

import android.content.*;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

public final class ExtraGuard {

    public ExtraGuard() {
    }

    public static boolean checkApk(Context context, Uri uri) {
        boolean flag = false;
        if(uri != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        ContentResolver contentresolver;
        String s;
        String s1;
        contentresolver = context.getContentResolver();
        s = null;
        s1 = uri.getScheme();
        if(!"content".equals(s1)) goto _L4; else goto _L3
_L3:
        Cursor cursor = contentresolver.query(uri, null, null, null, null);
        if(cursor != null) {
            if(cursor.moveToFirst())
                s = cursor.getString(cursor.getColumnIndex("_data"));
            cursor.close();
        }
_L6:
        if(TextUtils.isEmpty(s))
            continue; /* Loop/switch isn't completed */
        int i;
        Uri uri1 = NATIVE_SCAN_URI;
        ContentValues contentvalues = new ContentValues();
        String as[] = new String[1];
        as[0] = s;
        i = contentresolver.update(uri1, contentvalues, null, as);
        boolean flag1;
        if(i != 2)
            flag1 = true;
        else
            flag1 = false;
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L4:
        if(s1 == null || "file".equals(s1))
            s = uri.getPath();
        if(true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        flag = true;
        if(true) goto _L1; else goto _L7
_L7:
    }

    public static boolean checkSms(Context context, String s, String s1) {
        boolean flag = true;
        int i;
        ContentResolver contentresolver = context.getContentResolver();
        Uri uri = SMS_CHECK_URI;
        ContentValues contentvalues = new ContentValues();
        String as[] = new String[2];
        as[0] = s;
        as[1] = s1;
        i = contentresolver.update(uri, contentvalues, null, as);
        if(i != 2)
            flag = false;
_L2:
        return flag;
        Exception exception;
        exception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final Uri NATIVE_SCAN_URI = Uri.parse("content://com.ijinshan.mguard.provider.MoSecurityProvider/Native_Scan");
    private static final int SMS_BLACK = 2;
    private static final Uri SMS_CHECK_URI = Uri.parse("content://com.ijinshan.mguard.provider.MoSecurityProvider/SmsCheck");
    private static final int SMS_WHITE = 1;
    private static final int VIRUS_BLACK = 2;
    private static final int VIRUS_GRAY = 3;
    private static final int VIRUS_WHITE = 1;

}
