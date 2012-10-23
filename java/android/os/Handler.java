// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.Log;
import android.util.Printer;

// Referenced classes of package android.os:
//            Looper, Message, SystemClock, MessageQueue, 
//            IMessenger

public class Handler {
    private final class MessengerImpl extends IMessenger.Stub {

        public void send(Message message) {
            sendMessage(message);
        }

        final Handler this$0;

        private MessengerImpl() {
            this$0 = Handler.this;
            super();
        }

    }

    public static interface Callback {

        public abstract boolean handleMessage(Message message);
    }


    public Handler() {
        mLooper = Looper.myLooper();
        if(mLooper == null) {
            throw new RuntimeException("Can't create handler inside thread that has not called Looper.prepare()");
        } else {
            mQueue = mLooper.mQueue;
            mCallback = null;
            return;
        }
    }

    public Handler(Callback callback) {
        mLooper = Looper.myLooper();
        if(mLooper == null) {
            throw new RuntimeException("Can't create handler inside thread that has not called Looper.prepare()");
        } else {
            mQueue = mLooper.mQueue;
            mCallback = callback;
            return;
        }
    }

    public Handler(Looper looper) {
        mLooper = looper;
        mQueue = looper.mQueue;
        mCallback = null;
    }

    public Handler(Looper looper, Callback callback) {
        mLooper = looper;
        mQueue = looper.mQueue;
        mCallback = callback;
    }

    private static Message getPostMessage(Runnable runnable) {
        Message message = Message.obtain();
        message.callback = runnable;
        return message;
    }

    private static Message getPostMessage(Runnable runnable, Object obj) {
        Message message = Message.obtain();
        message.obj = obj;
        message.callback = runnable;
        return message;
    }

    private static void handleCallback(Message message) {
        message.callback.run();
    }

    public void dispatchMessage(Message message) {
        if(message.callback == null) goto _L2; else goto _L1
_L1:
        handleCallback(message);
_L4:
        return;
_L2:
        if(mCallback == null || !mCallback.handleMessage(message))
            handleMessage(message);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final void dump(Printer printer, String s) {
        printer.println((new StringBuilder()).append(s).append(this).append(" @ ").append(SystemClock.uptimeMillis()).toString());
        if(mLooper == null)
            printer.println((new StringBuilder()).append(s).append("looper uninitialized").toString());
        else
            mLooper.dump(printer, (new StringBuilder()).append(s).append("  ").toString());
    }

    final IMessenger getIMessenger() {
        MessageQueue messagequeue = mQueue;
        messagequeue;
        JVM INSTR monitorenter ;
        IMessenger imessenger;
        if(mMessenger != null) {
            imessenger = mMessenger;
        } else {
            mMessenger = new MessengerImpl();
            imessenger = mMessenger;
        }
        return imessenger;
    }

    public final Looper getLooper() {
        return mLooper;
    }

    public String getMessageName(Message message) {
        String s;
        if(message.callback != null)
            s = message.callback.getClass().getName();
        else
            s = (new StringBuilder()).append("0x").append(Integer.toHexString(message.what)).toString();
        return s;
    }

    public void handleMessage(Message message) {
    }

    public final boolean hasCallbacks(Runnable runnable) {
        return mQueue.hasMessages(this, runnable, null);
    }

    public final boolean hasMessages(int i) {
        return mQueue.hasMessages(this, i, null);
    }

    public final boolean hasMessages(int i, Object obj) {
        return mQueue.hasMessages(this, i, obj);
    }

    public final Message obtainMessage() {
        return Message.obtain(this);
    }

    public final Message obtainMessage(int i) {
        return Message.obtain(this, i);
    }

    public final Message obtainMessage(int i, int j, int k) {
        return Message.obtain(this, i, j, k);
    }

    public final Message obtainMessage(int i, int j, int k, Object obj) {
        return Message.obtain(this, i, j, k, obj);
    }

    public final Message obtainMessage(int i, Object obj) {
        return Message.obtain(this, i, obj);
    }

    public final boolean post(Runnable runnable) {
        return sendMessageDelayed(getPostMessage(runnable), 0L);
    }

    public final boolean postAtFrontOfQueue(Runnable runnable) {
        return sendMessageAtFrontOfQueue(getPostMessage(runnable));
    }

    public final boolean postAtTime(Runnable runnable, long l) {
        return sendMessageAtTime(getPostMessage(runnable), l);
    }

    public final boolean postAtTime(Runnable runnable, Object obj, long l) {
        return sendMessageAtTime(getPostMessage(runnable, obj), l);
    }

    public final boolean postDelayed(Runnable runnable, long l) {
        return sendMessageDelayed(getPostMessage(runnable), l);
    }

    public final void removeCallbacks(Runnable runnable) {
        mQueue.removeMessages(this, runnable, null);
    }

    public final void removeCallbacks(Runnable runnable, Object obj) {
        mQueue.removeMessages(this, runnable, obj);
    }

    public final void removeCallbacksAndMessages(Object obj) {
        mQueue.removeCallbacksAndMessages(this, obj);
    }

    public final void removeMessages(int i) {
        mQueue.removeMessages(this, i, null);
    }

    public final void removeMessages(int i, Object obj) {
        mQueue.removeMessages(this, i, obj);
    }

    public final boolean sendEmptyMessage(int i) {
        return sendEmptyMessageDelayed(i, 0L);
    }

    public final boolean sendEmptyMessageAtTime(int i, long l) {
        Message message = Message.obtain();
        message.what = i;
        return sendMessageAtTime(message, l);
    }

    public final boolean sendEmptyMessageDelayed(int i, long l) {
        Message message = Message.obtain();
        message.what = i;
        return sendMessageDelayed(message, l);
    }

    public final boolean sendMessage(Message message) {
        return sendMessageDelayed(message, 0L);
    }

    public final boolean sendMessageAtFrontOfQueue(Message message) {
        boolean flag = false;
        MessageQueue messagequeue = mQueue;
        if(messagequeue != null) {
            message.target = this;
            flag = messagequeue.enqueueMessage(message, 0L);
        } else {
            RuntimeException runtimeexception = new RuntimeException((new StringBuilder()).append(this).append(" sendMessageAtTime() called with no mQueue").toString());
            Log.w("Looper", runtimeexception.getMessage(), runtimeexception);
        }
        return flag;
    }

    public boolean sendMessageAtTime(Message message, long l) {
        boolean flag = false;
        MessageQueue messagequeue = mQueue;
        if(messagequeue != null) {
            message.target = this;
            flag = messagequeue.enqueueMessage(message, l);
        } else {
            RuntimeException runtimeexception = new RuntimeException((new StringBuilder()).append(this).append(" sendMessageAtTime() called with no mQueue").toString());
            Log.w("Looper", runtimeexception.getMessage(), runtimeexception);
        }
        return flag;
    }

    public final boolean sendMessageDelayed(Message message, long l) {
        if(l < 0L)
            l = 0L;
        return sendMessageAtTime(message, l + SystemClock.uptimeMillis());
    }

    public String toString() {
        return (new StringBuilder()).append("Handler (").append(getClass().getName()).append(") {").append(Integer.toHexString(System.identityHashCode(this))).append("}").toString();
    }

    private static final boolean FIND_POTENTIAL_LEAKS = false;
    private static final String TAG = "Handler";
    final Callback mCallback;
    final Looper mLooper;
    IMessenger mMessenger;
    final MessageQueue mQueue;
}
