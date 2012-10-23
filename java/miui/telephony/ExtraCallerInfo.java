// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.telephony;

import android.content.Context;
import android.database.Cursor;
import com.android.internal.telephony.CallerInfo;

// Referenced classes of package miui.telephony:
//            CallerInfo

public class ExtraCallerInfo {

    public ExtraCallerInfo() {
    }

    public static ExtraCallerInfo getExtraCallerInfo(Context context, CallerInfo callerinfo, Cursor cursor) {
        ExtraCallerInfo extracallerinfo = callerinfo.extra;
        extracallerinfo.isSpNumber = false;
        extracallerinfo.company = null;
        int i = cursor.getColumnIndex("company");
        if(i != -1)
            extracallerinfo.company = cursor.getString(i);
        CallerInfo.updateDisplayName(context, callerinfo, cursor);
        return extracallerinfo;
    }

    public String company;
    public String displayName;
    public boolean isSpNumber;
}
