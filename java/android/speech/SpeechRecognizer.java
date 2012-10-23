// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech;

import android.content.*;
import android.content.pm.PackageManager;
import android.os.*;
import android.text.TextUtils;
import android.util.Log;
import java.util.*;

// Referenced classes of package android.speech:
//            IRecognitionService, RecognitionListener

public class SpeechRecognizer {
    private class InternalListener extends IRecognitionListener.Stub {

        public void onBeginningOfSpeech() {
            Message.obtain(mInternalHandler, 1).sendToTarget();
        }

        public void onBufferReceived(byte abyte0[]) {
            Message.obtain(mInternalHandler, 2, abyte0).sendToTarget();
        }

        public void onEndOfSpeech() {
            Message.obtain(mInternalHandler, 3).sendToTarget();
        }

        public void onError(int i) {
            Message.obtain(mInternalHandler, 4, Integer.valueOf(i)).sendToTarget();
        }

        public void onEvent(int i, Bundle bundle) {
            Message.obtain(mInternalHandler, 9, i, i, bundle).sendToTarget();
        }

        public void onPartialResults(Bundle bundle) {
            Message.obtain(mInternalHandler, 7, bundle).sendToTarget();
        }

        public void onReadyForSpeech(Bundle bundle) {
            Message.obtain(mInternalHandler, 5, bundle).sendToTarget();
        }

        public void onResults(Bundle bundle) {
            Message.obtain(mInternalHandler, 6, bundle).sendToTarget();
        }

        public void onRmsChanged(float f) {
            Message.obtain(mInternalHandler, 8, Float.valueOf(f)).sendToTarget();
        }

        private static final int MSG_BEGINNING_OF_SPEECH = 1;
        private static final int MSG_BUFFER_RECEIVED = 2;
        private static final int MSG_END_OF_SPEECH = 3;
        private static final int MSG_ERROR = 4;
        private static final int MSG_ON_EVENT = 9;
        private static final int MSG_PARTIAL_RESULTS = 7;
        private static final int MSG_READY_FOR_SPEECH = 5;
        private static final int MSG_RESULTS = 6;
        private static final int MSG_RMS_CHANGED = 8;
        private final Handler mInternalHandler;
        private RecognitionListener mInternalListener;
        final SpeechRecognizer this$0;



/*
        static RecognitionListener access$1002(InternalListener internallistener, RecognitionListener recognitionlistener) {
            internallistener.mInternalListener = recognitionlistener;
            return recognitionlistener;
        }

*/

        private InternalListener() {
            this$0 = SpeechRecognizer.this;
            super();
            mInternalHandler = new Handler() {

                public void handleMessage(Message message) {
                    if(mInternalListener != null) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    switch(message.what) {
                    case 1: // '\001'
                        mInternalListener.onBeginningOfSpeech();
                        break;

                    case 2: // '\002'
                        mInternalListener.onBufferReceived((byte[])(byte[])message.obj);
                        break;

                    case 3: // '\003'
                        mInternalListener.onEndOfSpeech();
                        break;

                    case 4: // '\004'
                        mInternalListener.onError(((Integer)message.obj).intValue());
                        break;

                    case 5: // '\005'
                        mInternalListener.onReadyForSpeech((Bundle)message.obj);
                        break;

                    case 6: // '\006'
                        mInternalListener.onResults((Bundle)message.obj);
                        break;

                    case 7: // '\007'
                        mInternalListener.onPartialResults((Bundle)message.obj);
                        break;

                    case 8: // '\b'
                        mInternalListener.onRmsChanged(((Float)message.obj).floatValue());
                        break;

                    case 9: // '\t'
                        mInternalListener.onEvent(message.arg1, (Bundle)message.obj);
                        break;
                    }
                    if(true) goto _L1; else goto _L3
_L3:
                }

                final InternalListener this$1;

                 {
                    this$1 = InternalListener.this;
                    super();
                }
            };
        }

    }

    private class Connection
        implements ServiceConnection {

        public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
            mService = IRecognitionService.Stub.asInterface(ibinder);
            for(; !mPendingTasks.isEmpty(); mHandler.sendMessage((Message)mPendingTasks.poll()));
        }

        public void onServiceDisconnected(ComponentName componentname) {
            mService = null;
            mConnection = null;
            mPendingTasks.clear();
        }

        final SpeechRecognizer this$0;

        private Connection() {
            this$0 = SpeechRecognizer.this;
            super();
        }

    }


    private SpeechRecognizer(Context context, ComponentName componentname) {
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                message.what;
                JVM INSTR tableswitch 1 4: default 36
            //                           1 37
            //                           2 54
            //                           3 64
            //                           4 74;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                return;
_L2:
                handleStartListening((Intent)message.obj);
                continue; /* Loop/switch isn't completed */
_L3:
                handleStopMessage();
                continue; /* Loop/switch isn't completed */
_L4:
                handleCancelMessage();
                continue; /* Loop/switch isn't completed */
_L5:
                handleChangeListener((RecognitionListener)message.obj);
                if(true) goto _L1; else goto _L6
_L6:
            }

            final SpeechRecognizer this$0;

             {
                this$0 = SpeechRecognizer.this;
                super();
            }
        };
        mContext = context;
        mServiceComponent = componentname;
    }

    private static void checkIsCalledFromMainThread() {
        if(Looper.myLooper() != Looper.getMainLooper())
            throw new RuntimeException("SpeechRecognizer should be used only from the application's main thread");
        else
            return;
    }

    private boolean checkOpenConnection() {
        boolean flag;
        if(mService != null) {
            flag = true;
        } else {
            mListener.onError(5);
            Log.e("SpeechRecognizer", "not connected to the recognition service");
            flag = false;
        }
        return flag;
    }

    public static SpeechRecognizer createSpeechRecognizer(Context context) {
        return createSpeechRecognizer(context, null);
    }

    public static SpeechRecognizer createSpeechRecognizer(Context context, ComponentName componentname) {
        if(context == null) {
            throw new IllegalArgumentException("Context cannot be null)");
        } else {
            checkIsCalledFromMainThread();
            return new SpeechRecognizer(context, componentname);
        }
    }

    private void handleCancelMessage() {
        if(checkOpenConnection())
            try {
                mService.cancel(mListener);
            }
            catch(RemoteException remoteexception) {
                Log.e("SpeechRecognizer", "cancel() failed", remoteexception);
                mListener.onError(5);
            }
    }

    private void handleChangeListener(RecognitionListener recognitionlistener) {
        mListener.mInternalListener = recognitionlistener;
    }

    private void handleStartListening(Intent intent) {
        if(checkOpenConnection())
            try {
                mService.startListening(intent, mListener);
            }
            catch(RemoteException remoteexception) {
                Log.e("SpeechRecognizer", "startListening() failed", remoteexception);
                mListener.onError(5);
            }
    }

    private void handleStopMessage() {
        if(checkOpenConnection())
            try {
                mService.stopListening(mListener);
            }
            catch(RemoteException remoteexception) {
                Log.e("SpeechRecognizer", "stopListening() failed", remoteexception);
                mListener.onError(5);
            }
    }

    public static boolean isRecognitionAvailable(Context context) {
        boolean flag = false;
        List list = context.getPackageManager().queryIntentServices(new Intent("android.speech.RecognitionService"), 0);
        if(list != null && list.size() != 0)
            flag = true;
        return flag;
    }

    private void putMessage(Message message) {
        if(mService == null)
            mPendingTasks.offer(message);
        else
            mHandler.sendMessage(message);
    }

    public void cancel() {
        checkIsCalledFromMainThread();
        putMessage(Message.obtain(mHandler, 3));
    }

    public void destroy() {
        if(mConnection != null)
            mContext.unbindService(mConnection);
        mPendingTasks.clear();
        mService = null;
        mConnection = null;
        mListener.mInternalListener = null;
    }

    public void setRecognitionListener(RecognitionListener recognitionlistener) {
        checkIsCalledFromMainThread();
        putMessage(Message.obtain(mHandler, 4, recognitionlistener));
    }

    public void startListening(Intent intent) {
        if(intent == null)
            throw new IllegalArgumentException("intent must not be null");
        checkIsCalledFromMainThread();
        if(mConnection != null) goto _L2; else goto _L1
_L1:
        Intent intent1;
        mConnection = new Connection();
        intent1 = new Intent("android.speech.RecognitionService");
        if(mServiceComponent != null) goto _L4; else goto _L3
_L3:
        String s = android.provider.Settings.Secure.getString(mContext.getContentResolver(), "voice_recognition_service");
        if(!TextUtils.isEmpty(s)) goto _L6; else goto _L5
_L5:
        Log.e("SpeechRecognizer", "no selected voice recognition service");
        mListener.onError(5);
_L9:
        return;
_L6:
        intent1.setComponent(ComponentName.unflattenFromString(s));
_L7:
        if(mContext.bindService(intent1, mConnection, 1))
            break; /* Loop/switch isn't completed */
        Log.e("SpeechRecognizer", "bind to recognition service failed");
        mConnection = null;
        mService = null;
        mListener.onError(5);
        continue; /* Loop/switch isn't completed */
_L4:
        intent1.setComponent(mServiceComponent);
        if(true) goto _L7; else goto _L2
_L2:
        putMessage(Message.obtain(mHandler, 1, intent));
        if(true) goto _L9; else goto _L8
_L8:
    }

    public void stopListening() {
        checkIsCalledFromMainThread();
        putMessage(Message.obtain(mHandler, 2));
    }

    public static final String CONFIDENCE_SCORES = "confidence_scores";
    private static final boolean DBG = false;
    public static final int ERROR_AUDIO = 3;
    public static final int ERROR_CLIENT = 5;
    public static final int ERROR_INSUFFICIENT_PERMISSIONS = 9;
    public static final int ERROR_NETWORK = 2;
    public static final int ERROR_NETWORK_TIMEOUT = 1;
    public static final int ERROR_NO_MATCH = 7;
    public static final int ERROR_RECOGNIZER_BUSY = 8;
    public static final int ERROR_SERVER = 4;
    public static final int ERROR_SPEECH_TIMEOUT = 6;
    private static final int MSG_CANCEL = 3;
    private static final int MSG_CHANGE_LISTENER = 4;
    private static final int MSG_START = 1;
    private static final int MSG_STOP = 2;
    public static final String RESULTS_RECOGNITION = "results_recognition";
    private static final String TAG = "SpeechRecognizer";
    private Connection mConnection;
    private final Context mContext;
    private Handler mHandler;
    private final InternalListener mListener = new InternalListener();
    private final Queue mPendingTasks = new LinkedList();
    private IRecognitionService mService;
    private final ComponentName mServiceComponent;






/*
    static IRecognitionService access$502(SpeechRecognizer speechrecognizer, IRecognitionService irecognitionservice) {
        speechrecognizer.mService = irecognitionservice;
        return irecognitionservice;
    }

*/




/*
    static Connection access$802(SpeechRecognizer speechrecognizer, Connection connection) {
        speechrecognizer.mConnection = connection;
        return connection;
    }

*/
}
