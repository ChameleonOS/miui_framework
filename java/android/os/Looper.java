// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.*;

// Referenced classes of package android.os:
//            MessageQueue, Binder, Message, Handler, 
//            SystemClock

public class Looper {

    private Looper(boolean flag) {
        mQueue = new MessageQueue(flag);
        mRun = true;
    }

    public static Looper getMainLooper() {
        android/os/Looper;
        JVM INSTR monitorenter ;
        Looper looper = sMainLooper;
        return looper;
    }

    public static void loop() {
        Looper looper = myLooper();
        if(looper == null)
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        MessageQueue messagequeue = looper.mQueue;
        Binder.clearCallingIdentity();
        long l = Binder.clearCallingIdentity();
        do {
            Message message = messagequeue.next();
            if(message == null)
                return;
            Printer printer = looper.mLogging;
            if(printer != null)
                printer.println((new StringBuilder()).append(">>>>> Dispatching to ").append(message.target).append(" ").append(message.callback).append(": ").append(message.what).toString());
            message.target.dispatchMessage(message);
            if(printer != null)
                printer.println((new StringBuilder()).append("<<<<< Finished to ").append(message.target).append(" ").append(message.callback).toString());
            long l1 = Binder.clearCallingIdentity();
            if(l != l1)
                Log.wtf("Looper", (new StringBuilder()).append("Thread identity changed from 0x").append(Long.toHexString(l)).append(" to 0x").append(Long.toHexString(l1)).append(" while dispatching to ").append(message.target.getClass().getName()).append(" ").append(message.callback).append(" what=").append(message.what).toString());
            message.recycle();
        } while(true);
    }

    public static Looper myLooper() {
        return (Looper)sThreadLocal.get();
    }

    public static MessageQueue myQueue() {
        return myLooper().mQueue;
    }

    public static void prepare() {
        prepare(true);
    }

    private static void prepare(boolean flag) {
        if(sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        } else {
            sThreadLocal.set(new Looper(flag));
            return;
        }
    }

    public static void prepareMainLooper() {
        prepare(false);
        android/os/Looper;
        JVM INSTR monitorenter ;
        if(sMainLooper != null)
            throw new IllegalStateException("The main Looper has already been prepared.");
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        throw exception;
        sMainLooper = myLooper();
        android/os/Looper;
        JVM INSTR monitorexit ;
    }

    public void dump(Printer printer, String s) {
        Printer printer1;
        MessageQueue messagequeue;
        int i;
        printer1 = PrefixPrinter.create(printer, s);
        printer1.println(toString());
        printer1.println((new StringBuilder()).append("mRun=").append(mRun).toString());
        printer1.println((new StringBuilder()).append("mThread=").append(mThread).toString());
        StringBuilder stringbuilder = (new StringBuilder()).append("mQueue=");
        Object obj;
        long l;
        Message message;
        if(mQueue != null)
            obj = mQueue;
        else
            obj = "(null";
        printer1.println(stringbuilder.append(obj).toString());
        if(mQueue == null)
            break MISSING_BLOCK_LABEL_259;
        messagequeue = mQueue;
        messagequeue;
        JVM INSTR monitorenter ;
        l = SystemClock.uptimeMillis();
        message = mQueue.mMessages;
        i = 0;
        for(; message != null; message = message.next) {
            printer1.println((new StringBuilder()).append("  Message ").append(i).append(": ").append(message.toString(l)).toString());
            i++;
        }

        printer1.println((new StringBuilder()).append("(Total messages: ").append(i).append(")").toString());
        break MISSING_BLOCK_LABEL_259;
        Exception exception;
        exception;
        throw exception;
    }

    public MessageQueue getQueue() {
        return mQueue;
    }

    public Thread getThread() {
        return mThread;
    }

    public final int postSyncBarrier() {
        return mQueue.enqueueSyncBarrier(SystemClock.uptimeMillis());
    }

    public void quit() {
        mQueue.quit();
    }

    public final void removeSyncBarrier(int i) {
        mQueue.removeSyncBarrier(i);
    }

    public void setMessageLogging(Printer printer) {
        mLogging = printer;
    }

    public String toString() {
        return (new StringBuilder()).append("Looper{").append(Integer.toHexString(System.identityHashCode(this))).append("}").toString();
    }

    private static final String TAG = "Looper";
    private static Looper sMainLooper;
    static final ThreadLocal sThreadLocal = new ThreadLocal();
    private Printer mLogging;
    final MessageQueue mQueue;
    volatile boolean mRun;
    final Thread mThread = Thread.currentThread();

}
