// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

// Referenced classes of package android.media:
//            RingtoneManager

public class ExtraRingtone {

    public ExtraRingtone() {
    }

    public static String getRingtoneTitle(Context context, Uri uri, boolean flag) {
        String s = getTitle(context, uri, true);
        if(uri != null && flag && "settings".equals(uri.getAuthority())) {
            Object aobj[] = new Object[1];
            aobj[0] = s;
            s = context.getString(0x60c017d, aobj);
        }
        return s;
    }

    private static String getTitle(Context context, Uri uri, boolean flag) {
        Cursor cursor;
        ContentResolver contentresolver;
        String s;
        cursor = null;
        contentresolver = context.getContentResolver();
        s = null;
        if(uri == null) goto _L2; else goto _L1
_L1:
        String s2 = uri.getAuthority();
        if(!"settings".equals(s2)) goto _L4; else goto _L3
_L3:
        if(!flag) goto _L2; else goto _L5
_L5:
        String s1 = getTitle(context, RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri)), false);
_L11:
        return s1;
_L4:
        boolean flag1;
        flag1 = false;
        if("drm".equals(s2)) {
            cursor = contentresolver.query(uri, DRM_COLUMNS, null, null, null);
            flag1 = true;
        } else
        if("media".equals(s2)) {
            cursor = contentresolver.query(uri, MEDIA_COLUMNS, null, null, null);
            flag1 = true;
        }
        if(cursor == null) goto _L7; else goto _L6
_L6:
        if(cursor.getCount() != 1) goto _L7; else goto _L8
_L8:
        cursor.moveToFirst();
        s = cursor.getString(2);
        if(s == null)
            s = "";
_L9:
        if(cursor != null)
            cursor.close();
_L2:
        Exception exception;
        String s3;
        if(s == null)
            s = context.getString(0x60c0195);
        else
        if(s.length() == 0)
            s = context.getString(0x60c0197);
        s1 = s;
        continue; /* Loop/switch isn't completed */
_L7:
        if(!flag1)
            break MISSING_BLOCK_LABEL_192;
        s = "";
          goto _L9
        s3 = uri.getLastPathSegment();
        s = s3;
          goto _L9
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
        if(true) goto _L11; else goto _L10
_L10:
    }

    private static final String DRM_COLUMNS[];
    private static final String MEDIA_COLUMNS[];

    static  {
        String as[] = new String[3];
        as[0] = "_id";
        as[1] = "_data";
        as[2] = "title";
        MEDIA_COLUMNS = as;
        String as1[] = new String[3];
        as1[0] = "_id";
        as1[1] = "_data";
        as1[2] = "title";
        DRM_COLUMNS = as1;
    }
}
