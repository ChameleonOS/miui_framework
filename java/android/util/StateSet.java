// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


public class StateSet {

    public StateSet() {
    }

    public static String dump(int ai[]) {
        StringBuilder stringbuilder;
        int i;
        int j;
        stringbuilder = new StringBuilder();
        i = ai.length;
        j = 0;
_L8:
        if(j >= i)
            break MISSING_BLOCK_LABEL_128;
        ai[j];
        JVM INSTR lookupswitch 5: default 72
    //                   16842908: 108
    //                   16842909: 78
    //                   16842910: 118
    //                   16842913: 98
    //                   16842919: 88;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L4:
        break MISSING_BLOCK_LABEL_118;
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break; /* Loop/switch isn't completed */
_L9:
        j++;
        if(true) goto _L8; else goto _L7
_L7:
        stringbuilder.append("W ");
          goto _L9
_L6:
        stringbuilder.append("P ");
          goto _L9
_L5:
        stringbuilder.append("S ");
          goto _L9
_L2:
        stringbuilder.append("F ");
          goto _L9
        stringbuilder.append("E ");
          goto _L9
        return stringbuilder.toString();
    }

    public static boolean isWildCard(int ai[]) {
        boolean flag = false;
        if(ai.length == 0 || ai[0] == 0)
            flag = true;
        return flag;
    }

    public static boolean stateSetMatches(int ai[], int i) {
        boolean flag;
        int j;
        int k;
        flag = true;
        j = ai.length;
        k = 0;
_L6:
        if(k >= j) goto _L2; else goto _L1
_L1:
        int l = ai[k];
        if(l != 0) goto _L3; else goto _L2
_L2:
        return flag;
_L3:
        if(l > 0) {
            if(i == l)
                break; /* Loop/switch isn't completed */
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        if(i != -l)
            break; /* Loop/switch isn't completed */
        flag = false;
        if(true) goto _L2; else goto _L4
_L4:
        k++;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static boolean stateSetMatches(int ai[], int ai1[]) {
        boolean flag = false;
        if(ai1 != null) goto _L2; else goto _L1
_L1:
        if(ai == null || isWildCard(ai))
            flag = true;
_L4:
        return flag;
_L2:
        int i = ai.length;
        int j = ai1.length;
        int k = 0;
        do {
label0:
            {
                if(k >= i)
                    break label0;
                int l = ai[k];
                if(l == 0) {
                    flag = true;
                    continue; /* Loop/switch isn't completed */
                }
                boolean flag1;
                boolean flag2;
                int i1;
                if(l > 0) {
                    flag1 = true;
                } else {
                    flag1 = false;
                    l = -l;
                }
                flag2 = false;
                i1 = 0;
                do {
                    if(i1 < j) {
                        int j1 = ai1[i1];
                        if(j1 == 0) {
                            if(flag1)
                                continue; /* Loop/switch isn't completed */
                        } else {
label1:
                            {
                                if(j1 != l)
                                    break label1;
                                if(!flag1)
                                    continue; /* Loop/switch isn't completed */
                                flag2 = true;
                            }
                        }
                    }
                    if(flag1 && !flag2)
                        continue; /* Loop/switch isn't completed */
                    k++;
                    if(true)
                        break;
                    i1++;
                } while(true);
            }
        } while(true);
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static int[] trimStateSet(int ai[], int i) {
        if(ai.length != i) {
            int ai1[] = new int[i];
            System.arraycopy(ai, 0, ai1, 0, i);
            ai = ai1;
        }
        return ai;
    }

    public static final int NOTHING[];
    public static final int WILD_CARD[] = new int[0];

    static  {
        int ai[] = new int[1];
        ai[0] = 0;
        NOTHING = ai;
    }
}
