// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.http;

import android.content.Context;
import android.util.Log;

public class ErrorStrings {

    private ErrorStrings() {
    }

    public static int getResource(int i) {
        int j = 0x1040112;
        i;
        JVM INSTR tableswitch -15 0: default 84
    //                   -15 195
    //                   -14 189
    //                   -13 183
    //                   -12 177
    //                   -11 171
    //                   -10 165
    //                   -9 159
    //                   -8 153
    //                   -7 147
    //                   -6 141
    //                   -5 135
    //                   -4 129
    //                   -3 123
    //                   -2 117
    //                   -1 109
    //                   0 111;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L16:
        break; /* Loop/switch isn't completed */
_L1:
        Log.w("Http", (new StringBuilder()).append("Using generic message for unknown error code: ").append(i).toString());
_L19:
        return j;
_L17:
        j = 0x1040111;
        continue; /* Loop/switch isn't completed */
_L15:
        j = 0x1040113;
        continue; /* Loop/switch isn't completed */
_L14:
        j = 0x1040114;
        continue; /* Loop/switch isn't completed */
_L13:
        j = 0x1040115;
        continue; /* Loop/switch isn't completed */
_L12:
        j = 0x1040116;
        continue; /* Loop/switch isn't completed */
_L11:
        j = 0x1040117;
        continue; /* Loop/switch isn't completed */
_L10:
        j = 0x1040118;
        continue; /* Loop/switch isn't completed */
_L9:
        j = 0x1040119;
        continue; /* Loop/switch isn't completed */
_L8:
        j = 0x104011a;
        continue; /* Loop/switch isn't completed */
_L7:
        j = 0x1040008;
        continue; /* Loop/switch isn't completed */
_L6:
        j = 0x104011b;
        continue; /* Loop/switch isn't completed */
_L5:
        j = 0x1040007;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 0x104011c;
        continue; /* Loop/switch isn't completed */
_L3:
        j = 0x104011d;
        continue; /* Loop/switch isn't completed */
_L2:
        j = 0x104011e;
        if(true) goto _L19; else goto _L18
_L18:
    }

    public static String getString(int i, Context context) {
        return context.getText(getResource(i)).toString();
    }

    private static final String LOGTAG = "Http";
}
