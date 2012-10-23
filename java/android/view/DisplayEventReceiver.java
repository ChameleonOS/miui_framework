// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import dalvik.system.CloseGuard;

public abstract class DisplayEventReceiver {

    public DisplayEventReceiver(Looper looper) {
        if(looper == null) {
            throw new IllegalArgumentException("looper must not be null");
        } else {
            mMessageQueue = looper.getQueue();
            mReceiverPtr = nativeInit(this, mMessageQueue);
            mCloseGuard.open("dispose");
            return;
        }
    }

    private void dispatchVsync(long l, int i) {
        onVsync(l, i);
    }

    private static native void nativeDispose(int i);

    private static native int nativeInit(DisplayEventReceiver displayeventreceiver, MessageQueue messagequeue);

    private static native void nativeScheduleVsync(int i);

    public void dispose() {
        if(mCloseGuard != null)
            mCloseGuard.close();
        if(mReceiverPtr != 0) {
            nativeDispose(mReceiverPtr);
            mReceiverPtr = 0;
        }
        mMessageQueue = null;
    }

    protected void finalize() throws Throwable {
        dispose();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void onVsync(long l, int i) {
    }

    public void scheduleVsync() {
        if(mReceiverPtr == 0)
            Log.w("DisplayEventReceiver", "Attempted to schedule a vertical sync pulse but the display event receiver has already been disposed.");
        else
            nativeScheduleVsync(mReceiverPtr);
    }

    private static final String TAG = "DisplayEventReceiver";
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private MessageQueue mMessageQueue;
    private int mReceiverPtr;
}
