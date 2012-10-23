// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            RemoteException, ICancellationSignal, OperationCanceledException

public final class CancellationSignal {
    private static final class Transport extends ICancellationSignal.Stub {

        public void cancel() throws RemoteException {
            mCancellationSignal.cancel();
        }

        final CancellationSignal mCancellationSignal;

        private Transport() {
            mCancellationSignal = new CancellationSignal();
        }

    }

    public static interface OnCancelListener {

        public abstract void onCancel();
    }


    public CancellationSignal() {
    }

    public static ICancellationSignal createTransport() {
        return new Transport();
    }

    public static CancellationSignal fromTransport(ICancellationSignal icancellationsignal) {
        CancellationSignal cancellationsignal;
        if(icancellationsignal instanceof Transport)
            cancellationsignal = ((Transport)icancellationsignal).mCancellationSignal;
        else
            cancellationsignal = null;
        return cancellationsignal;
    }

    private void waitForCancelFinishedLocked() {
        while(mCancelInProgress) 
            try {
                wait();
            }
            catch(InterruptedException interruptedexception) { }
    }

    public void cancel() {
        this;
        JVM INSTR monitorenter ;
        if(!mIsCanceled)
            break MISSING_BLOCK_LABEL_14;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_114;
        OnCancelListener oncancellistener;
        ICancellationSignal icancellationsignal;
        mIsCanceled = true;
        mCancelInProgress = true;
        oncancellistener = mOnCancelListener;
        icancellationsignal = mRemote;
        this;
        JVM INSTR monitorexit ;
        if(oncancellistener == null)
            break MISSING_BLOCK_LABEL_46;
        oncancellistener.onCancel();
        Exception exception;
        Exception exception1;
        if(icancellationsignal != null)
            try {
                icancellationsignal.cancel();
            }
            catch(RemoteException remoteexception) { }
            finally {
                this;
            }
        this;
        JVM INSTR monitorenter ;
        mCancelInProgress = false;
        notifyAll();
        break MISSING_BLOCK_LABEL_114;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        mCancelInProgress = false;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception2;
        exception2;
        this;
        JVM INSTR monitorexit ;
        throw exception2;
    }

    public boolean isCanceled() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsCanceled;
        return flag;
    }

    public void setOnCancelListener(OnCancelListener oncancellistener) {
        this;
        JVM INSTR monitorenter ;
        waitForCancelFinishedLocked();
        if(mOnCancelListener == oncancellistener)
            break MISSING_BLOCK_LABEL_53;
        mOnCancelListener = oncancellistener;
        if(!mIsCanceled || oncancellistener == null)
            break MISSING_BLOCK_LABEL_53;
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
        oncancellistener.onCancel();
    }

    public void setRemote(ICancellationSignal icancellationsignal) {
        this;
        JVM INSTR monitorenter ;
        waitForCancelFinishedLocked();
        if(mRemote == icancellationsignal)
            break MISSING_BLOCK_LABEL_57;
        mRemote = icancellationsignal;
        if(!mIsCanceled || icancellationsignal == null)
            break MISSING_BLOCK_LABEL_57;
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
        try {
            icancellationsignal.cancel();
        }
        catch(RemoteException remoteexception) { }
    }

    public void throwIfCanceled() {
        if(isCanceled())
            throw new OperationCanceledException();
        else
            return;
    }

    private boolean mCancelInProgress;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;
    private ICancellationSignal mRemote;
}
