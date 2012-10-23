// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;


public class Pair {

    public Pair(Object obj, Object obj1) {
        first = obj;
        second = obj1;
    }

    public static Pair create(Object obj, Object obj1) {
        return new Pair(obj, obj1);
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(obj != this) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(!(obj instanceof Pair)) {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        Pair pair = (Pair)obj;
        if(!first.equals(pair.first) || !second.equals(pair.second))
            flag = false;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
        flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int hashCode() {
        return 31 * (527 + first.hashCode()) + second.hashCode();
    }

    public final Object first;
    public final Object second;
}
