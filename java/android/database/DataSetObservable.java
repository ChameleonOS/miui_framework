// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import java.util.ArrayList;

// Referenced classes of package android.database:
//            Observable, DataSetObserver

public class DataSetObservable extends Observable {

    public DataSetObservable() {
    }

    public void notifyChanged() {
        ArrayList arraylist = super.mObservers;
        arraylist;
        JVM INSTR monitorenter ;
        for(int i = -1 + super.mObservers.size(); i >= 0; i--)
            ((DataSetObserver)super.mObservers.get(i)).onChanged();

        return;
    }

    public void notifyInvalidated() {
        ArrayList arraylist = super.mObservers;
        arraylist;
        JVM INSTR monitorenter ;
        for(int i = -1 + super.mObservers.size(); i >= 0; i--)
            ((DataSetObserver)super.mObservers.get(i)).onInvalidated();

        return;
    }
}
