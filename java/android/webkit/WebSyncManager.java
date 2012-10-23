// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.os.*;

// Referenced classes of package android.webkit:
//            WebViewDatabase

abstract class WebSyncManager
    implements Runnable {
    private class SyncHandler extends Handler {

        public void handleMessage(Message message) {
            if(message.what == 101) {
                syncFromRamToFlash();
                sendMessageDelayed(obtainMessage(101), WebSyncManager.SYNC_LATER_INTERVAL);
            }
        }

        final WebSyncManager this$0;

        private SyncHandler() {
            this$0 = WebSyncManager.this;
            super();
        }

    }


    protected WebSyncManager(Context context, String s) {
        mThreadName = s;
        if(context != null) {
            mSyncThread = new Thread(this);
            mSyncThread.setName(mThreadName);
            mSyncThread.start();
            return;
        } else {
            throw new IllegalStateException("WebSyncManager can't be created without context");
        }
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    protected void onSyncInit() {
    }

    public void resetSync() {
        if(mHandler != null) {
            mHandler.removeMessages(101);
            Message message = mHandler.obtainMessage(101);
            mHandler.sendMessageDelayed(message, SYNC_LATER_INTERVAL);
        }
    }

    public void run() {
        Looper.prepare();
        mHandler = new SyncHandler();
        onSyncInit();
        Process.setThreadPriority(10);
        Message message = mHandler.obtainMessage(101);
        mHandler.sendMessageDelayed(message, SYNC_LATER_INTERVAL);
        Looper.loop();
    }

    public void startSync() {
        if(mHandler != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = 1 + mStartSyncRefCount;
        mStartSyncRefCount = i;
        if(i == 1) {
            Message message = mHandler.obtainMessage(101);
            mHandler.sendMessageDelayed(message, SYNC_LATER_INTERVAL);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void stopSync() {
        if(mHandler != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = -1 + mStartSyncRefCount;
        mStartSyncRefCount = i;
        if(i == 0)
            mHandler.removeMessages(101);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void sync() {
        if(mHandler != null) {
            mHandler.removeMessages(101);
            Message message = mHandler.obtainMessage(101);
            mHandler.sendMessageDelayed(message, SYNC_NOW_INTERVAL);
        }
    }

    abstract void syncFromRamToFlash();

    protected static final String LOGTAG = "websync";
    private static int SYNC_LATER_INTERVAL = 0;
    private static final int SYNC_MESSAGE = 101;
    private static int SYNC_NOW_INTERVAL = 100;
    protected WebViewDatabase mDataBase;
    protected Handler mHandler;
    private int mStartSyncRefCount;
    private Thread mSyncThread;
    private String mThreadName;

    static  {
        SYNC_LATER_INTERVAL = 0x493e0;
    }

}
