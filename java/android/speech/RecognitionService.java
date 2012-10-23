// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech;

import android.app.Service;
import android.content.Intent;
import android.os.*;
import android.util.Log;

// Referenced classes of package android.speech:
//            IRecognitionListener

public abstract class RecognitionService extends Service {
    private static class RecognitionServiceBinder extends IRecognitionService.Stub {

        public void cancel(IRecognitionListener irecognitionlistener) {
            if(mInternalService != null && mInternalService.checkPermissions(irecognitionlistener))
                mInternalService.mHandler.sendMessage(Message.obtain(mInternalService.mHandler, 3, irecognitionlistener));
        }

        public void clearReference() {
            mInternalService = null;
        }

        public void startListening(Intent intent, IRecognitionListener irecognitionlistener) {
            if(mInternalService != null && mInternalService.checkPermissions(irecognitionlistener)) {
                Handler handler = mInternalService.mHandler;
                Handler handler1 = mInternalService.mHandler;
                RecognitionService recognitionservice = mInternalService;
                recognitionservice.getClass();
                handler.sendMessage(Message.obtain(handler1, 1, recognitionservice. new StartListeningArgs(intent, irecognitionlistener)));
            }
        }

        public void stopListening(IRecognitionListener irecognitionlistener) {
            if(mInternalService != null && mInternalService.checkPermissions(irecognitionlistener))
                mInternalService.mHandler.sendMessage(Message.obtain(mInternalService.mHandler, 2, irecognitionlistener));
        }

        private RecognitionService mInternalService;

        public RecognitionServiceBinder(RecognitionService recognitionservice) {
            mInternalService = recognitionservice;
        }
    }

    public class Callback {

        public void beginningOfSpeech() throws RemoteException {
            mListener.onBeginningOfSpeech();
        }

        public void bufferReceived(byte abyte0[]) throws RemoteException {
            mListener.onBufferReceived(abyte0);
        }

        public void endOfSpeech() throws RemoteException {
            mListener.onEndOfSpeech();
        }

        public void error(int i) throws RemoteException {
            Message.obtain(mHandler, 4).sendToTarget();
            mListener.onError(i);
        }

        public void partialResults(Bundle bundle) throws RemoteException {
            mListener.onPartialResults(bundle);
        }

        public void readyForSpeech(Bundle bundle) throws RemoteException {
            mListener.onReadyForSpeech(bundle);
        }

        public void results(Bundle bundle) throws RemoteException {
            Message.obtain(mHandler, 4).sendToTarget();
            mListener.onResults(bundle);
        }

        public void rmsChanged(float f) throws RemoteException {
            mListener.onRmsChanged(f);
        }

        private final IRecognitionListener mListener;
        final RecognitionService this$0;


        private Callback(IRecognitionListener irecognitionlistener) {
            this$0 = RecognitionService.this;
            super();
            mListener = irecognitionlistener;
        }

    }

    private class StartListeningArgs {

        public final Intent mIntent;
        public final IRecognitionListener mListener;
        final RecognitionService this$0;

        public StartListeningArgs(Intent intent, IRecognitionListener irecognitionlistener) {
            this$0 = RecognitionService.this;
            super();
            mIntent = intent;
            mListener = irecognitionlistener;
        }
    }


    public RecognitionService() {
        mBinder = new RecognitionServiceBinder(this);
        mCurrentCallback = null;
    }

    private boolean checkPermissions(IRecognitionListener irecognitionlistener) {
        boolean flag;
        if(checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0) {
            flag = true;
        } else {
            try {
                Log.e("RecognitionService", "call for recognition service without RECORD_AUDIO permissions");
                irecognitionlistener.onError(9);
            }
            catch(RemoteException remoteexception) {
                Log.e("RecognitionService", "sending ERROR_INSUFFICIENT_PERMISSIONS message failed", remoteexception);
            }
            flag = false;
        }
        return flag;
    }

    private void dispatchCancel(IRecognitionListener irecognitionlistener) {
        if(mCurrentCallback != null)
            if(mCurrentCallback.mListener.asBinder() != irecognitionlistener.asBinder()) {
                Log.w("RecognitionService", "cancel called by client who did not call startListening - ignoring");
            } else {
                onCancel(mCurrentCallback);
                mCurrentCallback = null;
            }
    }

    private void dispatchClearCallback() {
        mCurrentCallback = null;
    }

    private void dispatchStartListening(Intent intent, IRecognitionListener irecognitionlistener) {
        if(mCurrentCallback == null) {
            mCurrentCallback = new Callback(irecognitionlistener);
            onStartListening(intent, mCurrentCallback);
        } else {
            try {
                irecognitionlistener.onError(8);
            }
            catch(RemoteException remoteexception) {
                Log.d("RecognitionService", "onError call from startListening failed");
            }
            Log.i("RecognitionService", "concurrent startListening received - ignoring this call");
        }
    }

    private void dispatchStopListening(IRecognitionListener irecognitionlistener) {
        try {
            if(mCurrentCallback == null) {
                irecognitionlistener.onError(5);
                Log.w("RecognitionService", "stopListening called with no preceding startListening - ignoring");
                break MISSING_BLOCK_LABEL_85;
            }
            if(mCurrentCallback.mListener.asBinder() != irecognitionlistener.asBinder()) {
                irecognitionlistener.onError(8);
                Log.w("RecognitionService", "stopListening called by other caller than startListening - ignoring");
                break MISSING_BLOCK_LABEL_85;
            }
        }
        catch(RemoteException remoteexception) {
            Log.d("RecognitionService", "onError call from stopListening failed");
            break MISSING_BLOCK_LABEL_85;
        }
        onStopListening(mCurrentCallback);
    }

    public final IBinder onBind(Intent intent) {
        return mBinder;
    }

    protected abstract void onCancel(Callback callback);

    public void onDestroy() {
        mCurrentCallback = null;
        mBinder.clearReference();
        super.onDestroy();
    }

    protected abstract void onStartListening(Intent intent, Callback callback);

    protected abstract void onStopListening(Callback callback);

    private static final boolean DBG = false;
    private static final int MSG_CANCEL = 3;
    private static final int MSG_RESET = 4;
    private static final int MSG_START_LISTENING = 1;
    private static final int MSG_STOP_LISTENING = 2;
    public static final String SERVICE_INTERFACE = "android.speech.RecognitionService";
    public static final String SERVICE_META_DATA = "android.speech";
    private static final String TAG = "RecognitionService";
    private RecognitionServiceBinder mBinder;
    private Callback mCurrentCallback;
    private final Handler mHandler = new Handler() {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 4: default 36
        //                       1 37
        //                       2 63
        //                       3 80
        //                       4 97;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            return;
_L2:
            StartListeningArgs startlisteningargs = (StartListeningArgs)message.obj;
            dispatchStartListening(startlisteningargs.mIntent, startlisteningargs.mListener);
            continue; /* Loop/switch isn't completed */
_L3:
            dispatchStopListening((IRecognitionListener)message.obj);
            continue; /* Loop/switch isn't completed */
_L4:
            dispatchCancel((IRecognitionListener)message.obj);
            continue; /* Loop/switch isn't completed */
_L5:
            dispatchClearCallback();
            if(true) goto _L1; else goto _L6
_L6:
        }

        final RecognitionService this$0;

             {
                this$0 = RecognitionService.this;
                super();
            }
    };






}
