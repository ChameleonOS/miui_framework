// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.collect;

import java.util.*;

public class Sets {

    public Sets() {
    }

    public static HashSet newHashSet() {
        return new HashSet();
    }

    public static transient HashSet newHashSet(Object aobj[]) {
        HashSet hashset = new HashSet(1 + (4 * aobj.length) / 3);
        Collections.addAll(hashset, aobj);
        return hashset;
    }

    public static SortedSet newSortedSet() {
        return new TreeSet();
    }

    public static transient SortedSet newSortedSet(Object aobj[]) {
        TreeSet treeset = new TreeSet();
        Collections.addAll(treeset, aobj);
        return treeset;
    }
}
