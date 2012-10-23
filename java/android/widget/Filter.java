// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.os.*;
import android.util.Log;

public abstract class Filter {
    public static interface Delayer {

        public abstract long getPostingDelay(CharSequence charsequence);
    }

    private static class RequestArguments {

        CharSequence constraint;
        FilterListener listener;
        FilterResults results;

        private RequestArguments() {
        }

    }

    private class ResultsHandler extends Handler {

        public void handleMessage(Message message) {
            RequestArguments requestarguments = (RequestArguments)message.obj;
            publishResults(requestarguments.constraint, requestarguments.results);
            if(requestarguments.listener != null) {
                int i;
                if(requestarguments.results != null)
                    i = requestarguments.results.count;
                else
                    i = -1;
                requestarguments.listener.onFilterComplete(i);
            }
        }

        final Filter this$0;

        private ResultsHandler() {
            this$0 = Filter.this;
            super();
        }

    }

    private class RequestHandler extends Handler {

        public void handleMessage(Message message) {
            int i = message.what;
            i;
            JVM INSTR lookupswitch 2: default 32
        //                       -791613427: 33
        //                       -559038737: 227;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            RequestArguments requestarguments = (RequestArguments)message.obj;
            requestarguments.results = performFiltering(requestarguments.constraint);
            Message message2;
            message2 = mResultHandler.obtainMessage(i);
            message2.obj = requestarguments;
_L5:
            message2.sendToTarget();
            Object obj1 = mLock;
            obj1;
            JVM INSTR monitorenter ;
            if(mThreadHandler != null) {
                Message message3 = mThreadHandler.obtainMessage(0xdeadbeef);
                mThreadHandler.sendMessageDelayed(message3, 3000L);
            }
            continue; /* Loop/switch isn't completed */
            Exception exception1;
            exception1;
            requestarguments.results = new FilterResults();
            Log.w("Filter", "An exception occured during performFiltering()!", exception1);
            message2 = mResultHandler.obtainMessage(i);
            message2.obj = requestarguments;
            if(true) goto _L5; else goto _L4
_L4:
            Exception exception;
            exception;
            Message message1 = mResultHandler.obtainMessage(i);
            message1.obj = requestarguments;
            message1.sendToTarget();
            throw exception;
_L3:
            Object obj = mLock;
            obj;
            JVM INSTR monitorenter ;
            if(mThreadHandler != null) {
                mThreadHandler.getLooper().quit();
                mThreadHandler = null;
            }
            if(true) goto _L1; else goto _L6
_L6:
        }

        final Filter this$0;

        public RequestHandler(Looper looper) {
            this$0 = Filter.this;
            super(looper);
        }
    }

    public static interface FilterListener {

        public abstract void onFilterComplete(int i);
    }

    protected static class FilterResults {

        public int count;
        public Object values;

        public FilterResults() {
        }
    }


    public Filter() {
        mResultHandler = new ResultsHandler();
    }

    public CharSequence convertResultToString(Object obj) {
        String s;
        if(obj == null)
            s = "";
        else
            s = obj.toString();
        return s;
    }

    public final void filter(CharSequence charsequence) {
        filter(charsequence, null);
    }

    public final void filter(CharSequence charsequence, FilterListener filterlistener) {
        String s = null;
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mThreadHandler == null) {
            HandlerThread handlerthread = new HandlerThread("Filter", 10);
            handlerthread.start();
            mThreadHandler = new RequestHandler(handlerthread.getLooper());
        }
        long l;
        Message message;
        RequestArguments requestarguments;
        if(mDelayer == null)
            l = 0L;
        else
            l = mDelayer.getPostingDelay(charsequence);
        message = mThreadHandler.obtainMessage(0xd0d0f00d);
        requestarguments = new RequestArguments();
        if(charsequence != null)
            s = charsequence.toString();
        requestarguments.constraint = s;
        requestarguments.listener = filterlistener;
        message.obj = requestarguments;
        mThreadHandler.removeMessages(0xd0d0f00d);
        mThreadHandler.removeMessages(0xdeadbeef);
        mThreadHandler.sendMessageDelayed(message, l);
        return;
    }

    protected abstract FilterResults performFiltering(CharSequence charsequence);

    protected abstract void publishResults(CharSequence charsequence, FilterResults filterresults);

    public void setDelayer(Delayer delayer) {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        mDelayer = delayer;
        return;
    }

    private static final int FILTER_TOKEN = 0xd0d0f00d;
    private static final int FINISH_TOKEN = 0xdeadbeef;
    private static final String LOG_TAG = "Filter";
    private static final String THREAD_NAME = "Filter";
    private Delayer mDelayer;
    private final Object mLock = new Object();
    private Handler mResultHandler;
    private Handler mThreadHandler;





/*
    static Handler access$402(Filter filter1, Handler handler) {
        filter1.mThreadHandler = handler;
        return handler;
    }

*/
}
