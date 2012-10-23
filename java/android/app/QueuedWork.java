// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import java.util.concurrent.*;

public class QueuedWork {

    public QueuedWork() {
    }

    public static void add(Runnable runnable) {
        sPendingWorkFinishers.add(runnable);
    }

    public static boolean hasPendingWork() {
        boolean flag;
        if(!sPendingWorkFinishers.isEmpty())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static void remove(Runnable runnable) {
        sPendingWorkFinishers.remove(runnable);
    }

    public static ExecutorService singleThreadExecutor() {
        android/app/QueuedWork;
        JVM INSTR monitorenter ;
        if(sSingleThreadExecutor == null)
            sSingleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService executorservice = sSingleThreadExecutor;
        return executorservice;
    }

    public static void waitToFinish() {
        do {
            Runnable runnable = (Runnable)sPendingWorkFinishers.poll();
            if(runnable != null)
                runnable.run();
            else
                return;
        } while(true);
    }

    private static final ConcurrentLinkedQueue sPendingWorkFinishers = new ConcurrentLinkedQueue();
    private static ExecutorService sSingleThreadExecutor = null;

}
