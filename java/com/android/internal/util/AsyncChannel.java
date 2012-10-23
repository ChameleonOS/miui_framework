// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import android.content.*;
import android.os.*;
import android.util.Slog;
import java.util.Stack;

// Referenced classes of package com.android.internal.util:
//            AsyncService

public class AsyncChannel {
    class AsyncChannelConnection
        implements ServiceConnection {

        public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
            mDstMessenger = new Messenger(ibinder);
            replyHalfConnected(0);
        }

        public void onServiceDisconnected(ComponentName componentname) {
            replyDisconnected(0);
        }

        final AsyncChannel this$0;

        AsyncChannelConnection() {
            this$0 = AsyncChannel.this;
            super();
        }
    }

    private static class SyncMessenger {
        private class SyncHandler extends Handler {

            public void handleMessage(Message message) {
                mResultMsg = Message.obtain();
                mResultMsg.copyFrom(message);
                Object obj = mLockObject;
                obj;
                JVM INSTR monitorenter ;
                mLockObject.notify();
                return;
            }

            private Object mLockObject;
            private Message mResultMsg;
            final SyncMessenger this$0;




/*
            static Message access$402(SyncHandler synchandler, Message message) {
                synchandler.mResultMsg = message;
                return message;
            }

*/

            private SyncHandler(Looper looper) {
                this$0 = SyncMessenger.this;
                super(looper);
                mLockObject = new Object();
            }

        }


        private static SyncMessenger obtain() {
            Stack stack = sStack;
            stack;
            JVM INSTR monitorenter ;
            SyncMessenger syncmessenger;
            if(sStack.isEmpty()) {
                syncmessenger = new SyncMessenger();
                StringBuilder stringbuilder = (new StringBuilder()).append("SyncHandler-");
                int i = sCount;
                sCount = i + 1;
                syncmessenger.mHandlerThread = new HandlerThread(stringbuilder.append(i).toString());
                syncmessenger.mHandlerThread.start();
                syncmessenger.getClass();
                syncmessenger.mHandler = syncmessenger. new SyncHandler(syncmessenger.mHandlerThread.getLooper());
                syncmessenger.mMessenger = new Messenger(syncmessenger.mHandler);
            } else {
                syncmessenger = (SyncMessenger)sStack.pop();
            }
            return syncmessenger;
        }

        private void recycle() {
            Stack stack = sStack;
            stack;
            JVM INSTR monitorenter ;
            sStack.push(this);
            return;
        }

        private static Message sendMessageSynchronously(Messenger messenger, Message message) {
            SyncMessenger syncmessenger;
            syncmessenger = obtain();
            if(messenger == null || message == null)
                break MISSING_BLOCK_LABEL_88;
            message.replyTo = syncmessenger.mMessenger;
            synchronized(syncmessenger.mHandler.mLockObject) {
                messenger.send(message);
                syncmessenger.mHandler.mLockObject.wait();
            }
_L1:
            Message message1 = syncmessenger.mHandler.mResultMsg;
            syncmessenger.recycle();
            return message1;
            exception;
            obj;
            JVM INSTR monitorexit ;
            try {
                throw exception;
            }
            catch(InterruptedException interruptedexception) {
                syncmessenger.mHandler.mResultMsg = null;
            }
            catch(RemoteException remoteexception) {
                syncmessenger.mHandler.mResultMsg = null;
            }
              goto _L1
            syncmessenger.mHandler.mResultMsg = null;
              goto _L1
        }

        private static int sCount = 0;
        private static Stack sStack = new Stack();
        private SyncHandler mHandler;
        private HandlerThread mHandlerThread;
        private Messenger mMessenger;



        private SyncMessenger() {
        }
    }


    public AsyncChannel() {
    }

    protected static String cmdToString(int i) {
        int j = i - 0x11000;
        String s;
        if(j >= 0 && j < sCmdToString.length)
            s = sCmdToString[j];
        else
            s = null;
        return s;
    }

    private static void log(String s) {
        Slog.d("AsyncChannel", s);
    }

    private void replyDisconnected(int i) {
        Message message = mSrcHandler.obtainMessage(0x11004);
        message.arg1 = i;
        message.obj = this;
        message.replyTo = mDstMessenger;
        mSrcHandler.sendMessage(message);
    }

    private void replyHalfConnected(int i) {
        Message message = mSrcHandler.obtainMessage(0x11000);
        message.arg1 = i;
        message.obj = this;
        message.replyTo = mDstMessenger;
        mSrcHandler.sendMessage(message);
    }

    public void connect(Context context, Handler handler, Handler handler1) {
        connect(context, handler, new Messenger(handler1));
    }

    public void connect(Context context, Handler handler, Messenger messenger) {
        connected(context, handler, messenger);
        replyHalfConnected(0);
    }

    public void connect(Context context, Handler handler, Class class1) {
        connect(context, handler, class1.getPackage().getName(), class1.getName());
    }

    public void connect(Context context, Handler handler, String s, String s1) {
        (new Thread(new _cls1ConnectAsync(context, handler, s, s1))).start();
    }

    public void connect(AsyncService asyncservice, Messenger messenger) {
        connect(((Context) (asyncservice)), asyncservice.getHandler(), messenger);
    }

    public int connectSrcHandlerToPackageSync(Context context, Handler handler, String s, String s1) {
        int i = 1;
        mConnection = new AsyncChannelConnection();
        mSrcContext = context;
        mSrcHandler = handler;
        mSrcMessenger = new Messenger(handler);
        mDstMessenger = null;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClassName(s, s1);
        if(context.bindService(intent, mConnection, i))
            i = 0;
        return i;
    }

    public int connectSync(Context context, Handler handler, Handler handler1) {
        return connectSync(context, handler, new Messenger(handler1));
    }

    public int connectSync(Context context, Handler handler, Messenger messenger) {
        connected(context, handler, messenger);
        return 0;
    }

    public void connected(Context context, Handler handler, Messenger messenger) {
        mSrcContext = context;
        mSrcHandler = handler;
        mSrcMessenger = new Messenger(mSrcHandler);
        mDstMessenger = messenger;
    }

    public void disconnect() {
        if(mConnection != null && mSrcContext != null)
            mSrcContext.unbindService(mConnection);
        if(mSrcHandler != null)
            replyDisconnected(0);
    }

    public void disconnected() {
        mSrcContext = null;
        mSrcHandler = null;
        mSrcMessenger = null;
        mDstMessenger = null;
        mConnection = null;
    }

    public int fullyConnectSync(Context context, Handler handler, Handler handler1) {
        int i = connectSync(context, handler, handler1);
        if(i == 0)
            i = sendMessageSynchronously(0x11001).arg1;
        return i;
    }

    public void replyToMessage(Message message, int i) {
        Message message1 = Message.obtain();
        message1.what = i;
        replyToMessage(message, message1);
    }

    public void replyToMessage(Message message, int i, int j) {
        Message message1 = Message.obtain();
        message1.what = i;
        message1.arg1 = j;
        replyToMessage(message, message1);
    }

    public void replyToMessage(Message message, int i, int j, int k) {
        Message message1 = Message.obtain();
        message1.what = i;
        message1.arg1 = j;
        message1.arg2 = k;
        replyToMessage(message, message1);
    }

    public void replyToMessage(Message message, int i, int j, int k, Object obj) {
        Message message1 = Message.obtain();
        message1.what = i;
        message1.arg1 = j;
        message1.arg2 = k;
        message1.obj = obj;
        replyToMessage(message, message1);
    }

    public void replyToMessage(Message message, int i, Object obj) {
        Message message1 = Message.obtain();
        message1.what = i;
        message1.obj = obj;
        replyToMessage(message, message1);
    }

    public void replyToMessage(Message message, Message message1) {
        message1.replyTo = mSrcMessenger;
        message.replyTo.send(message1);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        log((new StringBuilder()).append("TODO: handle replyToMessage RemoteException").append(remoteexception).toString());
        remoteexception.printStackTrace();
          goto _L1
    }

    public void sendMessage(int i) {
        Message message = Message.obtain();
        message.what = i;
        sendMessage(message);
    }

    public void sendMessage(int i, int j) {
        Message message = Message.obtain();
        message.what = i;
        message.arg1 = j;
        sendMessage(message);
    }

    public void sendMessage(int i, int j, int k) {
        Message message = Message.obtain();
        message.what = i;
        message.arg1 = j;
        message.arg2 = k;
        sendMessage(message);
    }

    public void sendMessage(int i, int j, int k, Object obj) {
        Message message = Message.obtain();
        message.what = i;
        message.arg1 = j;
        message.arg2 = k;
        message.obj = obj;
        sendMessage(message);
    }

    public void sendMessage(int i, Object obj) {
        Message message = Message.obtain();
        message.what = i;
        message.obj = obj;
        sendMessage(message);
    }

    public void sendMessage(Message message) {
        message.replyTo = mSrcMessenger;
        mDstMessenger.send(message);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        replyDisconnected(2);
          goto _L1
    }

    public Message sendMessageSynchronously(int i) {
        Message message = Message.obtain();
        message.what = i;
        return sendMessageSynchronously(message);
    }

    public Message sendMessageSynchronously(int i, int j) {
        Message message = Message.obtain();
        message.what = i;
        message.arg1 = j;
        return sendMessageSynchronously(message);
    }

    public Message sendMessageSynchronously(int i, int j, int k) {
        Message message = Message.obtain();
        message.what = i;
        message.arg1 = j;
        message.arg2 = k;
        return sendMessageSynchronously(message);
    }

    public Message sendMessageSynchronously(int i, int j, int k, Object obj) {
        Message message = Message.obtain();
        message.what = i;
        message.arg1 = j;
        message.arg2 = k;
        message.obj = obj;
        return sendMessageSynchronously(message);
    }

    public Message sendMessageSynchronously(int i, Object obj) {
        Message message = Message.obtain();
        message.what = i;
        message.obj = obj;
        return sendMessageSynchronously(message);
    }

    public Message sendMessageSynchronously(Message message) {
        return SyncMessenger.sendMessageSynchronously(mDstMessenger, message);
    }

    private static final int BASE = 0x11000;
    public static final int CMD_CHANNEL_DISCONNECT = 0x11003;
    public static final int CMD_CHANNEL_DISCONNECTED = 0x11004;
    public static final int CMD_CHANNEL_FULLY_CONNECTED = 0x11002;
    public static final int CMD_CHANNEL_FULL_CONNECTION = 0x11001;
    public static final int CMD_CHANNEL_HALF_CONNECTED = 0x11000;
    private static final int CMD_TO_STRING_COUNT = 5;
    private static final boolean DBG = false;
    public static final int STATUS_BINDING_UNSUCCESSFUL = 1;
    public static final int STATUS_FULL_CONNECTION_REFUSED_ALREADY_CONNECTED = 3;
    public static final int STATUS_SEND_UNSUCCESSFUL = 2;
    public static final int STATUS_SUCCESSFUL = 0;
    private static final String TAG = "AsyncChannel";
    private static String sCmdToString[];
    private AsyncChannelConnection mConnection;
    private Messenger mDstMessenger;
    private Context mSrcContext;
    private Handler mSrcHandler;
    private Messenger mSrcMessenger;

    static  {
        sCmdToString = new String[5];
        sCmdToString[0] = "CMD_CHANNEL_HALF_CONNECTED";
        sCmdToString[1] = "CMD_CHANNEL_FULL_CONNECTION";
        sCmdToString[2] = "CMD_CHANNEL_FULLY_CONNECTED";
        sCmdToString[3] = "CMD_CHANNEL_DISCONNECT";
        sCmdToString[4] = "CMD_CHANNEL_DISCONNECTED";
    }



/*
    static Messenger access$502(AsyncChannel asyncchannel, Messenger messenger) {
        asyncchannel.mDstMessenger = messenger;
        return messenger;
    }

*/


    private class _cls1ConnectAsync
        implements Runnable {

        public void run() {
            int i = connectSrcHandlerToPackageSync(mSrcCtx, mSrcHdlr, mDstPackageName, mDstClassName);
            replyHalfConnected(i);
        }

        String mDstClassName;
        String mDstPackageName;
        Context mSrcCtx;
        Handler mSrcHdlr;
        final AsyncChannel this$0;

        _cls1ConnectAsync(Context context, Handler handler, String s, String s1) {
            this$0 = AsyncChannel.this;
            super();
            mSrcCtx = context;
            mSrcHdlr = handler;
            mDstPackageName = s;
            mDstClassName = s1;
        }
    }

}
