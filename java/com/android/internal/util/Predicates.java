// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import java.util.Arrays;
import java.util.Iterator;

// Referenced classes of package com.android.internal.util:
//            Predicate

public class Predicates {
    private static class NotPredicate
        implements Predicate {

        public boolean apply(Object obj) {
            boolean flag;
            if(!predicate.apply(obj))
                flag = true;
            else
                flag = false;
            return flag;
        }

        private final Predicate predicate;

        private NotPredicate(Predicate predicate1) {
            predicate = predicate1;
        }

    }

    private static class OrPredicate
        implements Predicate {

        public boolean apply(Object obj) {
            Iterator iterator = components.iterator();
_L4:
            if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
            if(!((Predicate)iterator.next()).apply(obj)) goto _L4; else goto _L3
_L3:
            boolean flag = true;
_L6:
            return flag;
_L2:
            flag = false;
            if(true) goto _L6; else goto _L5
_L5:
        }

        private final Iterable components;

        private OrPredicate(Iterable iterable) {
            components = iterable;
        }

    }

    private static class AndPredicate
        implements Predicate {

        public boolean apply(Object obj) {
            Iterator iterator = components.iterator();
_L4:
            if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
            if(((Predicate)iterator.next()).apply(obj)) goto _L4; else goto _L3
_L3:
            boolean flag = false;
_L6:
            return flag;
_L2:
            flag = true;
            if(true) goto _L6; else goto _L5
_L5:
        }

        private final Iterable components;

        private AndPredicate(Iterable iterable) {
            components = iterable;
        }

    }


    private Predicates() {
    }

    public static Predicate and(Iterable iterable) {
        return new AndPredicate(iterable);
    }

    public static transient Predicate and(Predicate apredicate[]) {
        return and(((Iterable) (Arrays.asList(apredicate))));
    }

    public static Predicate not(Predicate predicate) {
        return new NotPredicate(predicate);
    }

    public static Predicate or(Iterable iterable) {
        return new OrPredicate(iterable);
    }

    public static transient Predicate or(Predicate apredicate[]) {
        return or(((Iterable) (Arrays.asList(apredicate))));
    }
}
