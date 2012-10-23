// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.content.res.Resources;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class L10nUtils {

    public L10nUtils() {
    }

    public static String getLocalisedString(int i) {
        String s;
        if(mStrings == null) {
            s = loadString(i);
        } else {
            SoftReference softreference = (SoftReference)mStrings.get(Integer.valueOf(i));
            boolean flag;
            if(softreference == null || softreference.get() == null)
                flag = true;
            else
                flag = false;
            if(flag)
                s = loadString(i);
            else
                s = (String)softreference.get();
        }
        return s;
    }

    private static String loadString(int i) {
        if(mStrings == null)
            mStrings = new HashMap(mIdsArray.length);
        String s = mApplicationContext.getResources().getString(mIdsArray[i]);
        mStrings.put(Integer.valueOf(i), new SoftReference(s));
        return s;
    }

    public static void setApplicationContext(Context context) {
        mApplicationContext = context.getApplicationContext();
    }

    private static Context mApplicationContext;
    private static int mIdsArray[];
    private static Map mStrings;

    static  {
        int ai[] = new int[57];
        ai[0] = 0x1040344;
        ai[1] = 0x1040345;
        ai[2] = 0x1040346;
        ai[3] = 0x1040347;
        ai[4] = 0x1040348;
        ai[5] = 0x1040349;
        ai[6] = 0x104034a;
        ai[7] = 0x104034b;
        ai[8] = 0x104034c;
        ai[9] = 0x104034d;
        ai[10] = 0x104034e;
        ai[11] = 0x104034f;
        ai[12] = 0x1040350;
        ai[13] = 0x1040351;
        ai[14] = 0x1040352;
        ai[15] = 0x1040353;
        ai[16] = 0x1040354;
        ai[17] = 0x1040355;
        ai[18] = 0x1040356;
        ai[19] = 0x1040357;
        ai[20] = 0x1040358;
        ai[21] = 0x1040359;
        ai[22] = 0x104035a;
        ai[23] = 0x104035b;
        ai[24] = 0x104035c;
        ai[25] = 0x104035d;
        ai[26] = 0x104035e;
        ai[27] = 0x104035f;
        ai[28] = 0x1040360;
        ai[29] = 0x1040361;
        ai[30] = 0x1040362;
        ai[31] = 0x1040363;
        ai[32] = 0x1040364;
        ai[33] = 0x1040365;
        ai[34] = 0x1040366;
        ai[35] = 0x1040367;
        ai[36] = 0x1040368;
        ai[37] = 0x1040369;
        ai[38] = 0x104036a;
        ai[39] = 0x104036b;
        ai[40] = 0x104036c;
        ai[41] = 0x104036d;
        ai[42] = 0x104036e;
        ai[43] = 0x104036f;
        ai[44] = 0x1040370;
        ai[45] = 0x1040371;
        ai[46] = 0x1040372;
        ai[47] = 0x1040373;
        ai[48] = 0x1040374;
        ai[49] = 0x1040375;
        ai[50] = 0x1040376;
        ai[51] = 0x1040377;
        ai[52] = 0x1040378;
        ai[53] = 0x1040379;
        ai[54] = 0x104037a;
        ai[55] = 0x104037b;
        ai[56] = 0x104037c;
        mIdsArray = ai;
    }
}
