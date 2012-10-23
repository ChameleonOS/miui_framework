// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;


public interface SectionIndexer {

    public abstract int getPositionForSection(int i);

    public abstract int getSectionForPosition(int i);

    public abstract Object[] getSections();
}
