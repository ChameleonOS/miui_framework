// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.net.Uri;
import android.os.Handler;

// Referenced classes of package android.database:
//            IContentObserver

public abstract class ContentObserver {
    private static final class Transport extends IContentObserver.Stub {

        public void onChange(boolean flag, Uri uri) {
            ContentObserver contentobserver = mContentObserver;
            if(contentobserver != null)
                contentobserver.dispatchChange(flag, uri);
        }

        public void releaseContentObserver() {
            mContentObserver = null;
        }

        private ContentObserver mContentObserver;

        public Transport(ContentObserver contentobserver) {
            mContentObserver = contentobserver;
        }
    }

    private final class NotificationRunnable
        implements Runnable {

        public void run() {
            onChange(mSelfChange, mUri);
        }

        private final boolean mSelfChange;
        private final Uri mUri;
        final ContentObserver this$0;

        public NotificationRunnable(boolean flag, Uri uri) {
            this$0 = ContentObserver.this;
            super();
            mSelfChange = flag;
            mUri = uri;
        }
    }


    public ContentObserver(Handler handler) {
        mHandler = handler;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public final void dispatchChange(boolean flag) {
        dispatchChange(flag, null);
    }

    public final void dispatchChange(boolean flag, Uri uri) {
        if(mHandler == null)
            onChange(flag, uri);
        else
            mHandler.post(new NotificationRunnable(flag, uri));
    }

    public IContentObserver getContentObserver() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(mTransport == null)
            mTransport = new Transport(this);
        Transport transport = mTransport;
        return transport;
    }

    public void onChange(boolean flag) {
    }

    public void onChange(boolean flag, Uri uri) {
        onChange(flag);
    }

    public IContentObserver releaseContentObserver() {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        Transport transport = mTransport;
        if(transport != null) {
            transport.releaseContentObserver();
            mTransport = null;
        }
        return transport;
    }

    Handler mHandler;
    private final Object mLock = new Object();
    private Transport mTransport;
}
