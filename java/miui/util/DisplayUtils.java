// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;


public class DisplayUtils {

    private DisplayUtils() {
    }

    public static int[] getBestDensityOrder(int i) {
        int j = 1;
        int k = 0;
        int ai[];
label0:
        do {
label1:
            {
                if(k < DENSITIES.length) {
                    if(i != DENSITIES[k])
                        break label1;
                    j = 0;
                }
                ai = new int[j + DENSITIES.length];
                ai[0] = i;
                int l = j;
                int i1 = 1;
                for(; l < DENSITIES.length; l++)
                    if(i != DENSITIES[l]) {
                        int j1 = i1 + 1;
                        ai[i1] = DENSITIES[l];
                        i1 = j1;
                    }

                break label0;
            }
            k++;
        } while(true);
        return ai;
    }

    public static String getDensityName(int i) {
        i;
        JVM INSTR lookupswitch 5: default 52
    //                   0: 122
    //                   120: 99
    //                   160: 104
    //                   240: 110
    //                   320: 116;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        int j = -1 + DENSITIES.length;
        String s;
        for(int k = j - 1; k > 0; k--)
            if(Math.abs(DENSITIES[k] - i) < Math.abs(DENSITIES[j] - i))
                j = k;

        s = getDensityName(DENSITIES[j]);
          goto _L7
_L3:
        s = "ldpi";
_L9:
        return s;
_L4:
        s = "mdpi";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "hdpi";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "xhdpi";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "";
        continue; /* Loop/switch isn't completed */
_L7:
        if(true) goto _L9; else goto _L8
_L8:
    }

    public static String getDensitySuffix(int i) {
        String s = getDensityName(i);
        if(!s.equals(""))
            s = (new StringBuilder()).append("-").append(s).toString();
        return s;
    }

    public static String getDrawbleDensityFolder(int i) {
        return (new StringBuilder()).append("res/").append(getDrawbleDensityName(i)).append("/").toString();
    }

    public static String getDrawbleDensityName(int i) {
        return (new StringBuilder()).append("drawable").append(getDensitySuffix(i)).toString();
    }

    private static final int DENSITIES[];

    static  {
        int ai[] = new int[5];
        ai[0] = 320;
        ai[1] = 240;
        ai[2] = 160;
        ai[3] = 120;
        ai[4] = 0;
        DENSITIES = ai;
    }
}
