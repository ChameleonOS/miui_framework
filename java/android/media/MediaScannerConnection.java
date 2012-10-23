// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.*;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;

// Referenced classes of package android.media:
//            IMediaScannerService

public class MediaScannerConnection
    implements ServiceConnection {
    static class ClientProxy
        implements MediaScannerConnectionClient {

        public void onMediaScannerConnected() {
            scanNextPath();
        }

        public void onScanCompleted(String s, Uri uri) {
            if(mClient != null)
                mClient.onScanCompleted(s, uri);
            scanNextPath();
        }

        void scanNextPath() {
            if(mNextPath >= mPaths.length) {
                mConnection.disconnect();
            } else {
                String s;
                if(mMimeTypes != null)
                    s = mMimeTypes[mNextPath];
                else
                    s = null;
                mConnection.scanFile(mPaths[mNextPath], s);
                mNextPath = 1 + mNextPath;
            }
        }

        final OnScanCompletedListener mClient;
        MediaScannerConnection mConnection;
        final String mMimeTypes[];
        int mNextPath;
        final String mPaths[];

        ClientProxy(String as[], String as1[], OnScanCompletedListener onscancompletedlistener) {
            mPaths = as;
            mMimeTypes = as1;
            mClient = onscancompletedlistener;
        }
    }

    public static interface MediaScannerConnectionClient
        extends OnScanCompletedListener {

        public abstract void onMediaScannerConnected();

        public abstract void onScanCompleted(String s, Uri uri);
    }

    public static interface OnScanCompletedListener {

        public abstract void onScanCompleted(String s, Uri uri);
    }


    public MediaScannerConnection(Context context, MediaScannerConnectionClient mediascannerconnectionclient) {
        mContext = context;
        mClient = mediascannerconnectionclient;
    }

    public static void scanFile(Context context, String as[], String as1[], OnScanCompletedListener onscancompletedlistener) {
        ClientProxy clientproxy = new ClientProxy(as, as1, onscancompletedlistener);
        MediaScannerConnection mediascannerconnection = new MediaScannerConnection(context, clientproxy);
        clientproxy.mConnection = mediascannerconnection;
        mediascannerconnection.connect();
    }

    public void connect() {
        this;
        JVM INSTR monitorenter ;
        if(!mConnected) {
            Intent intent = new Intent(android/media/IMediaScannerService.getName());
            mContext.bindService(intent, this, 1);
            mConnected = true;
        }
        return;
    }

    public void disconnect() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mConnected;
        if(flag) {
            Exception exception;
            try {
                mContext.unbindService(this);
            }
            catch(IllegalArgumentException illegalargumentexception) { }
            finally {
                this;
            }
            mConnected = false;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        throw exception;
    }

    /**
     * @deprecated Method isConnected is deprecated
     */

    public boolean isConnected() {
        this;
        JVM INSTR monitorenter ;
        if(mService == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mConnected;
        if(!flag1) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
        this;
        JVM INSTR monitorenter ;
        mService = IMediaScannerService.Stub.asInterface(ibinder);
        if(mService != null && mClient != null)
            mClient.onMediaScannerConnected();
        return;
    }

    public void onServiceDisconnected(ComponentName componentname) {
        this;
        JVM INSTR monitorenter ;
        mService = null;
        return;
    }

    public void scanFile(String s, String s1) {
        this;
        JVM INSTR monitorenter ;
        if(mService == null || !mConnected)
            throw new IllegalStateException("not connected to MediaScannerService");
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        throw exception;
        try {
            mService.requestScanFile(s, s1, mListener);
        }
        catch(RemoteException remoteexception) { }
        this;
        JVM INSTR monitorexit ;
    }

    private static final String TAG = "MediaScannerConnection";
    private MediaScannerConnectionClient mClient;
    private boolean mConnected;
    private Context mContext;
    private final IMediaScannerListener.Stub mListener = new IMediaScannerListener.Stub() {

        public void scanCompleted(String s, Uri uri) {
            MediaScannerConnectionClient mediascannerconnectionclient1 = mClient;
            if(mediascannerconnectionclient1 != null)
                mediascannerconnectionclient1.onScanCompleted(s, uri);
        }

        final MediaScannerConnection this$0;

             {
                this$0 = MediaScannerConnection.this;
                super();
            }
    };
    private IMediaScannerService mService;

}
