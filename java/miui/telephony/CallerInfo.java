// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.telephony;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.android.internal.telephony.Connection;
import java.io.ByteArrayInputStream;
import java.util.HashSet;

// Referenced classes of package miui.telephony:
//            ExtraCallerInfo

public class CallerInfo {

    public CallerInfo() {
    }

    public static com.android.internal.telephony.CallerInfo doSpNumberQuery(Context context, String s, com.android.internal.telephony.CallerInfo callerinfo) {
        Cursor cursor;
        if(TextUtils.isEmpty(s) || callerinfo.contactExists || callerinfo.extra.isSpNumber)
            break MISSING_BLOCK_LABEL_176;
        PhoneNumberUtils.PhoneNumber phonenumber = PhoneNumberUtils.PhoneNumber.parse(s);
        String s1 = phonenumber.getEffectiveNumber();
        phonenumber.recycle();
        ContentResolver contentresolver = context.getContentResolver();
        Uri uri = Uri.parse("content://yellowpage/sp");
        String as[] = SP_PROJECTION;
        String as1[] = new String[1];
        as1[0] = s1;
        cursor = contentresolver.query(uri, as, "addr=?", as1, null);
        if(cursor == null)
            break MISSING_BLOCK_LABEL_176;
        if(cursor.moveToFirst()) {
            callerinfo.extra.isSpNumber = true;
            callerinfo.extra.displayName = cursor.getString(0);
            byte abyte0[] = cursor.getBlob(1);
            if(abyte0 != null) {
                ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
                if(bytearrayinputstream != null) {
                    callerinfo.cachedPhoto = Drawable.createFromStream(bytearrayinputstream, s);
                    callerinfo.isCachedPhotoCurrent = true;
                }
            }
        }
        cursor.close();
        return callerinfo;
        Exception exception;
        exception;
        cursor.close();
        throw exception;
    }

    public static int getColumnIndex(Uri uri, String s, Cursor cursor) {
        String s1 = uri.toString();
        String s2 = s;
        int i;
        if(s1.startsWith("content://com.android.contacts/data/phones") || s1.startsWith("content://com.android.contacts/data"))
            if("number".equals(s))
                s2 = "data1";
            else
            if("type".equals(s))
                s2 = "data2";
            else
            if("label".equals(s))
                s2 = "data3";
            else
            if("normalized_number".equals(s))
                s2 = "data4";
        if(s2 != null)
            i = cursor.getColumnIndex(s2);
        else
            i = -1;
        return i;
    }

    public static int getPresentation(CharSequence charsequence) {
        int i;
        if(TextUtils.isEmpty(charsequence) || TextUtils.equals(charsequence, "-1"))
            i = Connection.PRESENTATION_UNKNOWN;
        else
        if(TextUtils.equals(charsequence, "-2"))
            i = Connection.PRESENTATION_RESTRICTED;
        else
        if(TextUtils.equals(charsequence, "-3"))
            i = Connection.PRESENTATION_PAYPHONE;
        else
            i = Connection.PRESENTATION_ALLOWED;
        return i;
    }

    public static void updateDisplayName(Context context, com.android.internal.telephony.CallerInfo callerinfo, Cursor cursor) {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        stringbuilder.append(callerinfo.name);
        if(cursor.getCount() <= 1) goto _L2; else goto _L1
_L1:
        int i = cursor.getColumnIndex("display_name");
        if(i == -1) goto _L2; else goto _L3
_L3:
        HashSet hashset;
        String s;
        hashset = new HashSet();
        hashset.add(callerinfo.name);
        s = context.getString(0x60c016c);
_L8:
        if(!cursor.moveToNext()) goto _L2; else goto _L4
_L4:
        String s1;
        s1 = cursor.getString(i);
        if(hashset.contains(s1))
            continue; /* Loop/switch isn't completed */
        if(hashset.size() < 3) goto _L6; else goto _L5
_L5:
        stringbuilder.append(' ').append(s).append(" ...");
_L2:
        callerinfo.extra.displayName = stringbuilder.toString();
        return;
_L6:
        stringbuilder.append(' ').append(s).append(' ').append(s1);
        hashset.add(s1);
        if(true) goto _L8; else goto _L7
_L7:
    }

    public static final String PAYPHONE_NUMBER = "-3";
    public static final String PRIVATE_NUMBER = "-2";
    private static final int SP_NAME_COLUMN = 0;
    private static final int SP_PHOTO_COLUMN = 1;
    private static final String SP_PROJECTION[];
    public static final String UNKNOWN_NUMBER = "-1";

    static  {
        String as[] = new String[2];
        as[0] = "name";
        as[1] = "photo";
        SP_PROJECTION = as;
    }
}
