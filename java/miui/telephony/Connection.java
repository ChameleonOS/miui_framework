// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.telephony;

import android.content.res.Resources;

public class Connection {

    public Connection() {
    }

    public static String getPresentationString(int i) {
        String s;
        if(i == PRESENTATION_RESTRICTED)
            s = Resources.getSystem().getString(0x60c003d);
        else
        if(i == PRESENTATION_PAYPHONE)
            s = Resources.getSystem().getString(0x60c003e);
        else
            s = Resources.getSystem().getString(0x60c003c);
        return s;
    }

    public static int PRESENTATION_ALLOWED = 1;
    public static int PRESENTATION_PAYPHONE = 4;
    public static int PRESENTATION_RESTRICTED = 2;
    public static int PRESENTATION_UNKNOWN = 3;

}
