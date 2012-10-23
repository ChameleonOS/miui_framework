// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.os:
//            Message, Handler, Process

public abstract class AsyncTask {
    private static class AsyncTaskResult {

        final Object mData[];
        final AsyncTask mTask;

        transient AsyncTaskResult(AsyncTask asynctask, Object aobj[]) {
            mTask = asynctask;
            mData = aobj;
        }
    }

    private static abstract class WorkerRunnable
        implements Callable {

        Object mParams[];

        private WorkerRunnable() {
        }

    }

    private static class InternalHandler extends Handler {

        public void handleMessage(Message message) {
            AsyncTaskResult asynctaskresult = (AsyncTaskResult)message.obj;
            message.what;
            JVM INSTR tableswitch 1 2: default 36
        //                       1 37
        //                       2 53;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            asynctaskresult.mTask.finish(asynctaskresult.mData[0]);
            continue; /* Loop/switch isn't completed */
_L3:
            asynctaskresult.mTask.onProgressUpdate(asynctaskresult.mData);
            if(true) goto _L1; else goto _L4
_L4:
        }

        private InternalHandler() {
        }

    }

    public static final class Status extends Enum {

        public static Status valueOf(String s) {
            return (Status)Enum.valueOf(android/os/AsyncTask$Status, s);
        }

        public static Status[] values() {
            return (Status[])$VALUES.clone();
        }

        private static final Status $VALUES[];
        public static final Status FINISHED;
        public static final Status PENDING;
        public static final Status RUNNING;

        static  {
            PENDING = new Status("PENDING", 0);
            RUNNING = new Status("RUNNING", 1);
            FINISHED = new Status("FINISHED", 2);
            Status astatus[] = new Status[3];
            astatus[0] = PENDING;
            astatus[1] = RUNNING;
            astatus[2] = FINISHED;
            $VALUES = astatus;
        }

        private Status(String s, int i) {
            super(s, i);
        }
    }

    private static class SerialExecutor
        implements Executor {

        /**
         * @deprecated Method execute is deprecated
         */

        public void execute(final Runnable r) {
            this;
            JVM INSTR monitorenter ;
            mTasks.offer(new Runnable() {

                public void run() {
                    r.run();
                    scheduleNext();
                    return;
                    Exception exception1;
                    exception1;
                    scheduleNext();
                    throw exception1;
                }

                final SerialExecutor this$0;
                final Runnable val$r;

                 {
                    this$0 = SerialExecutor.this;
                    r = runnable;
                    super();
                }
            });
            if(mActive == null)
                scheduleNext();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method scheduleNext is deprecated
         */

        protected void scheduleNext() {
            this;
            JVM INSTR monitorenter ;
            Runnable runnable = (Runnable)mTasks.poll();
            mActive = runnable;
            if(runnable != null)
                AsyncTask.THREAD_POOL_EXECUTOR.execute(mActive);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        Runnable mActive;
        final ArrayDeque mTasks;

        private SerialExecutor() {
            mTasks = new ArrayDeque();
        }

    }


    public AsyncTask() {
        mStatus = Status.PENDING;
        mFuture = new FutureTask(mWorker) {

            protected void done() {
                postResultIfNotInvoked(get());
_L1:
                return;
                InterruptedException interruptedexception;
                interruptedexception;
                Log.w("AsyncTask", interruptedexception);
                  goto _L1
                ExecutionException executionexception;
                executionexception;
                throw new RuntimeException("An error occured while executing doInBackground()", executionexception.getCause());
                CancellationException cancellationexception;
                cancellationexception;
                postResultIfNotInvoked(null);
                  goto _L1
            }

            final AsyncTask this$0;

             {
                this$0 = AsyncTask.this;
                super(callable);
            }
        };
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    private void finish(Object obj) {
        if(isCancelled())
            onCancelled(obj);
        else
            onPostExecute(obj);
        mStatus = Status.FINISHED;
    }

    public static void init() {
        sHandler.getLooper();
    }

    private Object postResult(Object obj) {
        InternalHandler internalhandler = sHandler;
        Object aobj[] = new Object[1];
        aobj[0] = obj;
        internalhandler.obtainMessage(1, new AsyncTaskResult(this, aobj)).sendToTarget();
        return obj;
    }

    private void postResultIfNotInvoked(Object obj) {
        if(!mTaskInvoked.get())
            postResult(obj);
    }

    public static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean flag) {
        mCancelled.set(true);
        return mFuture.cancel(flag);
    }

    protected transient abstract Object doInBackground(Object aobj[]);

    public final transient AsyncTask execute(Object aobj[]) {
        return executeOnExecutor(sDefaultExecutor, aobj);
    }

    public final transient AsyncTask executeOnExecutor(Executor executor, Object aobj[]) {
        if(mStatus == Status.PENDING) goto _L2; else goto _L1
_L1:
        class _cls4 {

            static final int $SwitchMap$android$os$AsyncTask$Status[];

            static  {
                $SwitchMap$android$os$AsyncTask$Status = new int[Status.values().length];
                NoSuchFieldError nosuchfielderror1;
                try {
                    $SwitchMap$android$os$AsyncTask$Status[Status.RUNNING.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                $SwitchMap$android$os$AsyncTask$Status[Status.FINISHED.ordinal()] = 2;
_L2:
                return;
                nosuchfielderror1;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls4..SwitchMap.android.os.AsyncTask.Status[mStatus.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 75
    //                   2 85;
           goto _L2 _L3 _L4
_L2:
        mStatus = Status.RUNNING;
        onPreExecute();
        mWorker.mParams = aobj;
        executor.execute(mFuture);
        return this;
_L3:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
_L4:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    public final Object get() throws InterruptedException, ExecutionException {
        return mFuture.get();
    }

    public final Object get(long l, TimeUnit timeunit) throws InterruptedException, ExecutionException, TimeoutException {
        return mFuture.get(l, timeunit);
    }

    public final Status getStatus() {
        return mStatus;
    }

    public final boolean isCancelled() {
        return mCancelled.get();
    }

    protected void onCancelled() {
    }

    protected void onCancelled(Object obj) {
        onCancelled();
    }

    protected void onPostExecute(Object obj) {
    }

    protected void onPreExecute() {
    }

    protected transient void onProgressUpdate(Object aobj[]) {
    }

    protected final transient void publishProgress(Object aobj[]) {
        if(!isCancelled())
            sHandler.obtainMessage(2, new AsyncTaskResult(this, aobj)).sendToTarget();
    }

    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor SERIAL_EXECUTOR;
    public static final Executor THREAD_POOL_EXECUTOR;
    private static volatile Executor sDefaultExecutor;
    private static final InternalHandler sHandler = new InternalHandler();
    private static final BlockingQueue sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final FutureTask mFuture;
    private volatile Status mStatus;
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    private final WorkerRunnable mWorker = new WorkerRunnable() {

        public Object call() throws Exception {
            mTaskInvoked.set(true);
            Process.setThreadPriority(10);
            return postResult(doInBackground(super.mParams));
        }

        final AsyncTask this$0;

             {
                this$0 = AsyncTask.this;
                super();
            }
    };

    static  {
        sThreadFactory = new ThreadFactory() {

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, (new StringBuilder()).append("AsyncTask #").append(mCount.getAndIncrement()).toString());
            }

            private final AtomicInteger mCount = new AtomicInteger(1);

        };
        sPoolWorkQueue = new LinkedBlockingQueue(10);
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        SERIAL_EXECUTOR = new SerialExecutor();
        sDefaultExecutor = SERIAL_EXECUTOR;
    }




}
