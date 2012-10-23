// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;

import java.io.Closeable;

public abstract class SQLiteClosable
    implements Closeable {

    public SQLiteClosable() {
        mReferenceCount = 1;
    }

    public void acquireReference() {
        this;
        JVM INSTR monitorenter ;
        if(mReferenceCount <= 0)
            throw new IllegalStateException((new StringBuilder()).append("attempt to re-open an already-closed object: ").append(this).toString());
        break MISSING_BLOCK_LABEL_41;
        Exception exception;
        exception;
        throw exception;
        mReferenceCount = 1 + mReferenceCount;
        this;
        JVM INSTR monitorexit ;
    }

    public void close() {
        releaseReference();
    }

    protected abstract void onAllReferencesReleased();

    protected void onAllReferencesReleasedFromContainer() {
        onAllReferencesReleased();
    }

    public void releaseReference() {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        int i = -1 + mReferenceCount;
        mReferenceCount = i;
        if(i != 0)
            break MISSING_BLOCK_LABEL_32;
        flag = true;
_L1:
        this;
        JVM INSTR monitorexit ;
        if(flag)
            onAllReferencesReleased();
        return;
        flag = false;
          goto _L1
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void releaseReferenceFromContainer() {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        int i = -1 + mReferenceCount;
        mReferenceCount = i;
        if(i != 0)
            break MISSING_BLOCK_LABEL_32;
        flag = true;
_L1:
        this;
        JVM INSTR monitorexit ;
        if(flag)
            onAllReferencesReleasedFromContainer();
        return;
        flag = false;
          goto _L1
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private int mReferenceCount;
}
