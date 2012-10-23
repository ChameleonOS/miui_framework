// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.AndroidRuntimeException;
import android.util.Log;
import java.util.ArrayList;

// Referenced classes of package android.os:
//            Message, Binder, SystemClock, Handler

public class MessageQueue {
    public static interface IdleHandler {

        public abstract boolean queueIdle();
    }


    MessageQueue(boolean flag) {
        mQuitAllowed = flag;
        nativeInit();
    }

    private native void nativeDestroy();

    private native void nativeInit();

    private native void nativePollOnce(int i, int j);

    private native void nativeWake(int i);

    public final void addIdleHandler(IdleHandler idlehandler) {
        if(idlehandler == null)
            throw new NullPointerException("Can't add a null IdleHandler");
        this;
        JVM INSTR monitorenter ;
        mIdleHandlers.add(idlehandler);
        return;
    }

    final boolean enqueueMessage(Message message, long l) {
        boolean flag;
        flag = false;
        if(message.isInUse())
            throw new AndroidRuntimeException((new StringBuilder()).append(message).append(" This message is already in use.").toString());
        if(message.target == null)
            throw new AndroidRuntimeException("Message must have a target.");
        this;
        JVM INSTR monitorenter ;
        if(!mQuiting) goto _L2; else goto _L1
_L1:
        RuntimeException runtimeexception = new RuntimeException((new StringBuilder()).append(message.target).append(" sending message to a Handler on a dead thread").toString());
        Log.w("MessageQueue", runtimeexception.getMessage(), runtimeexception);
        this;
        JVM INSTR monitorexit ;
          goto _L3
_L2:
        Message message1;
        message.when = l;
        message1 = mMessages;
        if(message1 != null && l != 0L && l >= message1.when) goto _L5; else goto _L4
_L4:
        message.next = message1;
        mMessages = message;
        flag = mBlocked;
_L8:
        this;
        JVM INSTR monitorexit ;
        if(flag)
            nativeWake(mPtr);
        flag = true;
          goto _L3
_L5:
        if(mBlocked && message1.target == null && message.isAsynchronous())
            flag = true;
_L6:
        Message message2 = message1;
        message1 = message1.next;
        if(message1 == null || l < message1.when) {
            message.next = message1;
            message2.next = message;
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_255;
        Exception exception;
        exception;
        throw exception;
        if(!flag)
            continue; /* Loop/switch isn't completed */
        boolean flag1 = message1.isAsynchronous();
        if(flag1)
            flag = false;
        if(true) goto _L6; else goto _L3
_L3:
        return flag;
        if(true) goto _L8; else goto _L7
_L7:
    }

    final int enqueueSyncBarrier(long l) {
        this;
        JVM INSTR monitorenter ;
        int i = mNextBarrierToken;
        mNextBarrierToken = i + 1;
        Message message = Message.obtain();
        message.arg1 = i;
        Message message1 = null;
        Message message2 = mMessages;
        if(l != 0L)
            for(; message2 != null && message2.when <= l; message2 = message2.next)
                message1 = message2;

        if(message1 != null) {
            message.next = message2;
            message1.next = message;
        } else {
            message.next = message2;
            mMessages = message;
        }
        return i;
    }

    protected void finalize() throws Throwable {
        nativeDestroy();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    final boolean hasMessages(Handler handler, int i, Object obj) {
        boolean flag = false;
        if(handler != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        this;
        JVM INSTR monitorenter ;
        Message message = mMessages;
_L4:
        if(message != null) {
            if(message.target != handler || message.what != i || obj != null && message.obj != obj)
                break MISSING_BLOCK_LABEL_69;
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
        message = message.next;
          goto _L4
    }

    final boolean hasMessages(Handler handler, Runnable runnable, Object obj) {
        boolean flag = false;
        if(handler != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        this;
        JVM INSTR monitorenter ;
        Message message = mMessages;
_L4:
        if(message != null) {
            if(message.target != handler || message.callback != runnable || obj != null && message.obj != obj)
                break MISSING_BLOCK_LABEL_69;
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
        message = message.next;
          goto _L4
    }

    final Message next() {
        int i;
        int j;
        i = -1;
        j = 0;
_L8:
        if(j != 0)
            Binder.flushPendingCommands();
        nativePollOnce(mPtr, j);
        this;
        JVM INSTR monitorenter ;
        if(!mQuiting) goto _L2; else goto _L1
_L1:
        Message message1 = null;
          goto _L3
_L2:
        long l;
        Message message;
        l = SystemClock.uptimeMillis();
        message = null;
        message1 = mMessages;
        if(message1 != null && message1.target == null)
            do {
                message = message1;
                message1 = message1.next;
            } while(message1 != null && !message1.isAsynchronous());
        if(message1 == null)
            break MISSING_BLOCK_LABEL_358;
        if(l >= message1.when) goto _L5; else goto _L4
_L4:
        j = (int)Math.min(message1.when - l, 0x7fffffffL);
_L13:
        if(i < 0 && (mMessages == null || l < mMessages.when))
            i = mIdleHandlers.size();
        if(i > 0) goto _L7; else goto _L6
_L6:
        mBlocked = true;
          goto _L8
        Exception exception;
        exception;
        throw exception;
_L5:
        mBlocked = false;
        if(message != null)
            message.next = message1.next;
        else
            mMessages = message1.next;
        message1.next = null;
        message1.markInUse();
        this;
        JVM INSTR monitorexit ;
          goto _L3
_L7:
        if(mPendingIdleHandlers == null)
            mPendingIdleHandlers = new IdleHandler[Math.max(i, 4)];
        mPendingIdleHandlers = (IdleHandler[])mIdleHandlers.toArray(mPendingIdleHandlers);
        this;
        JVM INSTR monitorexit ;
        int k = 0;
_L11:
        IdleHandler idlehandler;
        boolean flag;
        if(k >= i)
            break MISSING_BLOCK_LABEL_348;
        idlehandler = mPendingIdleHandlers[k];
        mPendingIdleHandlers[k] = null;
        flag = false;
        boolean flag1 = idlehandler.queueIdle();
        flag = flag1;
_L12:
        if(flag) goto _L10; else goto _L9
_L9:
        this;
        JVM INSTR monitorenter ;
        mIdleHandlers.remove(idlehandler);
        this;
        JVM INSTR monitorexit ;
_L10:
        k++;
          goto _L11
        Throwable throwable;
        throwable;
        Log.wtf("MessageQueue", "IdleHandler threw exception", throwable);
          goto _L12
        Exception exception1;
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
        i = 0;
        j = 0;
          goto _L8
_L3:
        return message1;
        j = -1;
          goto _L13
    }

    final void quit() {
        if(!mQuitAllowed)
            throw new RuntimeException("Main thread not allowed to quit.");
        this;
        JVM INSTR monitorenter ;
        if(!mQuiting)
            break MISSING_BLOCK_LABEL_31;
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_54;
        mQuiting = true;
        this;
        JVM INSTR monitorexit ;
        nativeWake(mPtr);
        break MISSING_BLOCK_LABEL_54;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    final void removeCallbacksAndMessages(Handler handler, Object obj) {
        if(handler != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        this;
        JVM INSTR monitorenter ;
        Message message;
        Message message3;
        for(message = mMessages; message != null && message.target == handler && (obj == null || message.obj == obj); message = message3) {
            message3 = message.next;
            mMessages = message3;
            message.recycle();
        }

        while(message != null)  {
            Message message1 = message.next;
            Exception exception;
            if(message1 != null && message1.target == handler && (obj == null || message1.obj == obj)) {
                Message message2 = message1.next;
                message1.recycle();
                message.next = message2;
            } else {
                message = message1;
            }
        }
        break MISSING_BLOCK_LABEL_138;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
          goto _L1
    }

    public final void removeIdleHandler(IdleHandler idlehandler) {
        this;
        JVM INSTR monitorenter ;
        mIdleHandlers.remove(idlehandler);
        return;
    }

    final void removeMessages(Handler handler, int i, Object obj) {
        if(handler != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        this;
        JVM INSTR monitorenter ;
        Message message;
        Message message3;
        for(message = mMessages; message != null && message.target == handler && message.what == i && (obj == null || message.obj == obj); message = message3) {
            message3 = message.next;
            mMessages = message3;
            message.recycle();
        }

        while(message != null)  {
            Message message1 = message.next;
            Exception exception;
            if(message1 != null && message1.target == handler && message1.what == i && (obj == null || message1.obj == obj)) {
                Message message2 = message1.next;
                message1.recycle();
                message.next = message2;
            } else {
                message = message1;
            }
        }
        break MISSING_BLOCK_LABEL_158;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
          goto _L1
    }

    final void removeMessages(Handler handler, Runnable runnable, Object obj) {
        if(handler != null && runnable != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        this;
        JVM INSTR monitorenter ;
        Message message;
        Message message3;
        for(message = mMessages; message != null && message.target == handler && message.callback == runnable && (obj == null || message.obj == obj); message = message3) {
            message3 = message.next;
            mMessages = message3;
            message.recycle();
        }

        while(message != null)  {
            Message message1 = message.next;
            Exception exception;
            if(message1 != null && message1.target == handler && message1.callback == runnable && (obj == null || message1.obj == obj)) {
                Message message2 = message1.next;
                message1.recycle();
                message.next = message2;
            } else {
                message = message1;
            }
        }
        break MISSING_BLOCK_LABEL_162;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
          goto _L1
    }

    final void removeSyncBarrier(int i) {
        this;
        JVM INSTR monitorenter ;
        Message message;
        Message message1;
        message = null;
        for(message1 = mMessages; message1 != null && (message1.target != null || message1.arg1 != i); message1 = message1.next)
            message = message1;

        if(message1 == null)
            throw new IllegalStateException("The specified message queue synchronization  barrier token has not been posted or has already been removed.");
        break MISSING_BLOCK_LABEL_65;
        Exception exception;
        exception;
        throw exception;
        if(message == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        message.next = message1.next;
        flag = false;
_L3:
        message1.recycle();
        this;
        JVM INSTR monitorexit ;
        if(flag)
            nativeWake(mPtr);
        return;
_L2:
        Handler handler;
        mMessages = message1.next;
        if(mMessages == null)
            break MISSING_BLOCK_LABEL_132;
        handler = mMessages.target;
        if(handler == null)
            break MISSING_BLOCK_LABEL_138;
        flag = true;
          goto _L3
        flag = false;
          goto _L3
    }

    private boolean mBlocked;
    private final ArrayList mIdleHandlers = new ArrayList();
    Message mMessages;
    private int mNextBarrierToken;
    private IdleHandler mPendingIdleHandlers[];
    private int mPtr;
    private final boolean mQuitAllowed;
    private boolean mQuiting;
}
