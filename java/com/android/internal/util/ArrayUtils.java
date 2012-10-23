// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import java.lang.reflect.Array;

public class ArrayUtils {

    private ArrayUtils() {
    }

    public static Object[] appendElement(Class class1, Object aobj[], Object obj) {
        int i;
        Object aobj1[];
        if(aobj != null) {
            i = aobj.length;
            aobj1 = (Object[])(Object[])Array.newInstance(class1, i + 1);
            System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj1)), 0, i);
        } else {
            i = 0;
            aobj1 = (Object[])(Object[])Array.newInstance(class1, 1);
        }
        aobj1[i] = obj;
        return aobj1;
    }

    public static int[] appendInt(int ai[], int i) {
        if(ai != null) goto _L2; else goto _L1
_L1:
        ai = new int[1];
        ai[0] = i;
_L4:
        return ai;
_L2:
        int j = ai.length;
        for(int k = 0; k < j; k++)
            if(ai[k] == i)
                continue; /* Loop/switch isn't completed */

        int ai1[] = new int[j + 1];
        System.arraycopy(ai, 0, ai1, 0, j);
        ai1[j] = i;
        ai = ai1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean contains(int ai[], int i) {
        int j;
        int k;
        j = ai.length;
        k = 0;
_L3:
        if(k >= j)
            break MISSING_BLOCK_LABEL_29;
        if(ai[k] != i) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        k++;
          goto _L3
        flag = false;
          goto _L4
    }

    public static boolean contains(Object aobj[], Object obj) {
        boolean flag;
        int i;
        int j;
        flag = true;
        i = aobj.length;
        j = 0;
_L3:
        Object obj1;
        if(j >= i)
            break MISSING_BLOCK_LABEL_50;
        obj1 = aobj[j];
        if(obj1 != null ? obj != null && obj1.equals(obj) : obj == null) goto _L2; else goto _L1
_L2:
        return flag;
_L1:
        j++;
          goto _L3
        flag = false;
          goto _L2
    }

    public static Object[] emptyArray(Class class1) {
        Object aobj[];
        if(class1 == java/lang/Object) {
            aobj = (Object[])EMPTY;
        } else {
            int i = (0x7fffffff & System.identityHashCode(class1) / 8) % 73;
            Object obj = sCache[i];
            if(obj == null || obj.getClass().getComponentType() != class1) {
                obj = Array.newInstance(class1, 0);
                sCache[i] = obj;
            }
            aobj = (Object[])(Object[])obj;
        }
        return aobj;
    }

    public static boolean equals(byte abyte0[], byte abyte1[], int i) {
        boolean flag = true;
        if(abyte0 != abyte1) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int j;
        if(abyte0 == null || abyte1 == null || abyte0.length < i || abyte1.length < i) {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        j = 0;
_L4:
        if(j < i) {
label0:
            {
                if(abyte0[j] == abyte1[j])
                    break label0;
                flag = false;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
        j++;
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    public static int idealBooleanArraySize(int i) {
        return idealByteArraySize(i);
    }

    public static int idealByteArraySize(int i) {
        int j = 4;
        do {
label0:
            {
                if(j < 32) {
                    if(i > -12 + (1 << j))
                        break label0;
                    i = -12 + (1 << j);
                }
                return i;
            }
            j++;
        } while(true);
    }

    public static int idealCharArraySize(int i) {
        return idealByteArraySize(i * 2) / 2;
    }

    public static int idealFloatArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    public static int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    public static int idealLongArraySize(int i) {
        return idealByteArraySize(i * 8) / 8;
    }

    public static int idealObjectArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    public static int idealShortArraySize(int i) {
        return idealByteArraySize(i * 2) / 2;
    }

    public static Object[] removeElement(Class class1, Object aobj[], Object obj) {
        int i;
        int j;
        if(aobj == null)
            break MISSING_BLOCK_LABEL_88;
        i = aobj.length;
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_88;
        if(aobj[j] != obj) goto _L2; else goto _L1
_L1:
        Object aobj1[];
        if(i == 1) {
            aobj1 = null;
        } else {
            aobj1 = (Object[])(Object[])Array.newInstance(class1, i - 1);
            System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj1)), 0, j);
            System.arraycopy(((Object) (aobj)), j + 1, ((Object) (aobj1)), j, -1 + (i - j));
        }
_L4:
        return aobj1;
_L2:
        j++;
          goto _L3
        aobj1 = aobj;
          goto _L4
    }

    public static int[] removeInt(int ai[], int i) {
        if(ai != null) goto _L2; else goto _L1
_L1:
        int ai1[] = null;
_L4:
        return ai1;
_L2:
        int j = ai.length;
        int k = 0;
        do {
            if(k >= j)
                break;
            if(ai[k] == i) {
                ai1 = new int[j - 1];
                if(k > 0)
                    System.arraycopy(ai, 0, ai1, 0, k);
                if(k < j - 1)
                    System.arraycopy(ai, k + 1, ai1, k, -1 + (j - k));
                continue; /* Loop/switch isn't completed */
            }
            k++;
        } while(true);
        ai1 = ai;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static long total(long al[]) {
        long l = 0L;
        int i = al.length;
        for(int j = 0; j < i; j++)
            l += al[j];

        return l;
    }

    private static final int CACHE_SIZE = 73;
    private static Object EMPTY[] = new Object[0];
    private static Object sCache[] = new Object[73];

}
