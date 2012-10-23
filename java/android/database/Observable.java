// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import java.util.ArrayList;

public abstract class Observable {

    public Observable() {
    }

    public void registerObserver(Object obj) {
        if(obj == null)
            throw new IllegalArgumentException("The observer is null.");
        ArrayList arraylist = mObservers;
        arraylist;
        JVM INSTR monitorenter ;
        if(mObservers.contains(obj))
            throw new IllegalStateException((new StringBuilder()).append("Observer ").append(obj).append(" is already registered.").toString());
        break MISSING_BLOCK_LABEL_69;
        Exception exception;
        exception;
        throw exception;
        mObservers.add(obj);
        arraylist;
        JVM INSTR monitorexit ;
    }

    public void unregisterAll() {
        ArrayList arraylist = mObservers;
        arraylist;
        JVM INSTR monitorenter ;
        mObservers.clear();
        return;
    }

    public void unregisterObserver(Object obj) {
        if(obj == null)
            throw new IllegalArgumentException("The observer is null.");
        ArrayList arraylist = mObservers;
        arraylist;
        JVM INSTR monitorenter ;
        int i;
        i = mObservers.indexOf(obj);
        if(i == -1)
            throw new IllegalStateException((new StringBuilder()).append("Observer ").append(obj).append(" was not registered.").toString());
        break MISSING_BLOCK_LABEL_75;
        Exception exception;
        exception;
        throw exception;
        mObservers.remove(i);
        arraylist;
        JVM INSTR monitorexit ;
    }

    protected final ArrayList mObservers = new ArrayList();
}
