// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;


public interface HeterogeneousExpandableList {

    public abstract int getChildType(int i, int j);

    public abstract int getChildTypeCount();

    public abstract int getGroupType(int i);

    public abstract int getGroupTypeCount();
}
