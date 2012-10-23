// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.net.Uri;
import android.os.*;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

// Referenced classes of package android.speech.tts:
//            TtsEngines, AudioPlaybackHandler, SynthesisRequest, SynthesisCallback, 
//            ITextToSpeechCallback, SilencePlaybackQueueItem, AudioPlaybackQueueItem, FileSynthesisCallback, 
//            AbstractSynthesisCallback, EventLogger, PlaybackSynthesisCallback

public abstract class TextToSpeechService extends Service {
    private class CallbackMap extends RemoteCallbackList {

        private ITextToSpeechCallback getCallbackFor(Object obj) {
            IBinder ibinder = (IBinder)obj;
            HashMap hashmap = mCallerToCallback;
            hashmap;
            JVM INSTR monitorenter ;
            ITextToSpeechCallback itexttospeechcallback = (ITextToSpeechCallback)mCallerToCallback.get(ibinder);
            return itexttospeechcallback;
        }

        public void dispatchOnDone(Object obj, String s) {
            ITextToSpeechCallback itexttospeechcallback = getCallbackFor(obj);
            if(itexttospeechcallback != null)
                try {
                    itexttospeechcallback.onDone(s);
                }
                catch(RemoteException remoteexception) {
                    Log.e("TextToSpeechService", (new StringBuilder()).append("Callback onDone failed: ").append(remoteexception).toString());
                }
        }

        public void dispatchOnError(Object obj, String s) {
            ITextToSpeechCallback itexttospeechcallback = getCallbackFor(obj);
            if(itexttospeechcallback != null)
                try {
                    itexttospeechcallback.onError(s);
                }
                catch(RemoteException remoteexception) {
                    Log.e("TextToSpeechService", (new StringBuilder()).append("Callback onError failed: ").append(remoteexception).toString());
                }
        }

        public void dispatchOnStart(Object obj, String s) {
            ITextToSpeechCallback itexttospeechcallback = getCallbackFor(obj);
            if(itexttospeechcallback != null)
                try {
                    itexttospeechcallback.onStart(s);
                }
                catch(RemoteException remoteexception) {
                    Log.e("TextToSpeechService", (new StringBuilder()).append("Callback onStart failed: ").append(remoteexception).toString());
                }
        }

        public void kill() {
            HashMap hashmap = mCallerToCallback;
            hashmap;
            JVM INSTR monitorenter ;
            mCallerToCallback.clear();
            super.kill();
            return;
        }

        public volatile void onCallbackDied(IInterface iinterface, Object obj) {
            onCallbackDied((ITextToSpeechCallback)iinterface, obj);
        }

        public void onCallbackDied(ITextToSpeechCallback itexttospeechcallback, Object obj) {
            IBinder ibinder = (IBinder)obj;
            synchronized(mCallerToCallback) {
                mCallerToCallback.remove(ibinder);
            }
            mSynthHandler.stopForApp(ibinder);
            return;
            exception;
            hashmap;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void setCallback(IBinder ibinder, ITextToSpeechCallback itexttospeechcallback) {
            HashMap hashmap = mCallerToCallback;
            hashmap;
            JVM INSTR monitorenter ;
            ITextToSpeechCallback itexttospeechcallback1;
            if(itexttospeechcallback != null) {
                register(itexttospeechcallback, ibinder);
                itexttospeechcallback1 = (ITextToSpeechCallback)mCallerToCallback.put(ibinder, itexttospeechcallback);
            } else {
                itexttospeechcallback1 = (ITextToSpeechCallback)mCallerToCallback.remove(ibinder);
            }
            if(itexttospeechcallback1 != null && itexttospeechcallback1 != itexttospeechcallback)
                unregister(itexttospeechcallback1);
            return;
        }

        private final HashMap mCallerToCallback;
        final TextToSpeechService this$0;

        private CallbackMap() {
            this$0 = TextToSpeechService.this;
            super();
            mCallerToCallback = new HashMap();
        }

    }

    private class SilenceSpeechItem extends SpeechItem {

        public boolean isValid() {
            return true;
        }

        protected int playImpl() {
            mAudioPlaybackHandler.enqueue(new SilencePlaybackQueueItem(this, getCallerIdentity(), mDuration));
            return 0;
        }

        protected void stopImpl() {
        }

        private final long mDuration;
        final TextToSpeechService this$0;

        public SilenceSpeechItem(Object obj, int i, int j, Bundle bundle, long l) {
            this$0 = TextToSpeechService.this;
            super(obj, i, j, bundle);
            mDuration = l;
        }
    }

    private class AudioSpeechItem extends SpeechItem {

        public boolean isValid() {
            return true;
        }

        protected int playImpl() {
            mAudioPlaybackHandler.enqueue(mItem);
            return 0;
        }

        protected void stopImpl() {
        }

        private final AudioPlaybackQueueItem mItem;
        final TextToSpeechService this$0;

        public AudioSpeechItem(Object obj, int i, int j, Bundle bundle, Uri uri) {
            this$0 = TextToSpeechService.this;
            super(obj, i, j, bundle);
            mItem = new AudioPlaybackQueueItem(this, getCallerIdentity(), TextToSpeechService.this, uri, getStreamType());
        }
    }

    private class SynthesisToFileSpeechItem extends SynthesisSpeechItem {

        private boolean checkFile(File file) {
            boolean flag;
            flag = false;
            try {
                if(file.exists()) {
                    Log.v("TextToSpeechService", (new StringBuilder()).append("File ").append(file).append(" exists, deleting.").toString());
                    if(!file.delete()) {
                        Log.e("TextToSpeechService", (new StringBuilder()).append("Failed to delete ").append(file).toString());
                        break MISSING_BLOCK_LABEL_184;
                    }
                }
                if(!file.createNewFile()) {
                    Log.e("TextToSpeechService", (new StringBuilder()).append("Can't create file ").append(file).toString());
                    break MISSING_BLOCK_LABEL_184;
                }
            }
            catch(IOException ioexception) {
                Log.e("TextToSpeechService", (new StringBuilder()).append("Can't use ").append(file).append(" due to exception ").append(ioexception).toString());
                break MISSING_BLOCK_LABEL_184;
            }
            if(!file.delete()) {
                Log.e("TextToSpeechService", (new StringBuilder()).append("Failed to delete ").append(file).toString());
                break MISSING_BLOCK_LABEL_184;
            }
            flag = true;
            return flag;
        }

        protected AbstractSynthesisCallback createSynthesisCallback() {
            return new FileSynthesisCallback(mFile);
        }

        public boolean isValid() {
            boolean flag;
            if(!super.isValid())
                flag = false;
            else
                flag = checkFile(mFile);
            return flag;
        }

        protected int playImpl() {
            dispatchOnStart();
            int i = super.playImpl();
            if(i == 0)
                dispatchOnDone();
            else
                dispatchOnError();
            return i;
        }

        private final File mFile;
        final TextToSpeechService this$0;

        public SynthesisToFileSpeechItem(Object obj, int i, int j, Bundle bundle, String s, File file) {
            this$0 = TextToSpeechService.this;
            super(obj, i, j, bundle, s);
            mFile = file;
        }
    }

    class SynthesisSpeechItem extends SpeechItem {

        private String getCountry() {
            String s;
            if(!hasLanguage())
                s = mDefaultLocale[1];
            else
                s = getStringParam("country", "");
            return s;
        }

        private int getPitch() {
            return getIntParam("pitch", 100);
        }

        private int getSpeechRate() {
            return getIntParam("rate", getDefaultSpeechRate());
        }

        private String getVariant() {
            String s;
            if(!hasLanguage())
                s = mDefaultLocale[2];
            else
                s = getStringParam("variant", "");
            return s;
        }

        private boolean hasLanguage() {
            boolean flag;
            if(!TextUtils.isEmpty(getStringParam("language", null)))
                flag = true;
            else
                flag = false;
            return flag;
        }

        private void setRequestParams(SynthesisRequest synthesisrequest) {
            synthesisrequest.setLanguage(getLanguage(), getCountry(), getVariant());
            synthesisrequest.setSpeechRate(getSpeechRate());
            synthesisrequest.setPitch(getPitch());
        }

        protected AbstractSynthesisCallback createSynthesisCallback() {
            return new PlaybackSynthesisCallback(getStreamType(), getVolume(), getPan(), mAudioPlaybackHandler, this, getCallerIdentity(), mEventLogger);
        }

        public String getLanguage() {
            return getStringParam("language", mDefaultLocale[0]);
        }

        public String getText() {
            return mText;
        }

        public boolean isValid() {
            boolean flag = false;
            if(mText == null)
                Log.wtf("TextToSpeechService", "Got null text");
            else
            if(mText.length() >= 4000)
                Log.w("TextToSpeechService", (new StringBuilder()).append("Text too long: ").append(mText.length()).append(" chars").toString());
            else
                flag = true;
            return flag;
        }

        protected int playImpl() {
            byte byte0;
            byte0 = -1;
            mEventLogger.onRequestProcessingStart();
            this;
            JVM INSTR monitorenter ;
            if(!isStopped())
                break MISSING_BLOCK_LABEL_24;
            this;
            JVM INSTR monitorexit ;
            break MISSING_BLOCK_LABEL_68;
            AbstractSynthesisCallback abstractsynthesiscallback;
            mSynthesisCallback = createSynthesisCallback();
            abstractsynthesiscallback = mSynthesisCallback;
            this;
            JVM INSTR monitorexit ;
            onSynthesizeText(mSynthesisRequest, abstractsynthesiscallback);
            if(abstractsynthesiscallback.isDone())
                byte0 = 0;
            break MISSING_BLOCK_LABEL_68;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            return byte0;
        }

        protected void stopImpl() {
            this;
            JVM INSTR monitorenter ;
            AbstractSynthesisCallback abstractsynthesiscallback = mSynthesisCallback;
            this;
            JVM INSTR monitorexit ;
            if(abstractsynthesiscallback != null) {
                abstractsynthesiscallback.stop();
                onStop();
            }
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private final String mDefaultLocale[];
        private final EventLogger mEventLogger;
        private AbstractSynthesisCallback mSynthesisCallback;
        private final SynthesisRequest mSynthesisRequest;
        private final String mText;
        final TextToSpeechService this$0;

        public SynthesisSpeechItem(Object obj, int i, int j, Bundle bundle, String s) {
            this$0 = TextToSpeechService.this;
            super(obj, i, j, bundle);
            mText = s;
            mSynthesisRequest = new SynthesisRequest(mText, super.mParams);
            mDefaultLocale = getSettingsLocale();
            setRequestParams(mSynthesisRequest);
            mEventLogger = new EventLogger(mSynthesisRequest, i, j, mPackageName);
        }
    }

    private abstract class SpeechItem
        implements UtteranceProgressDispatcher {

        public void dispatchOnDone() {
            String s = getUtteranceId();
            if(s != null)
                mCallbacks.dispatchOnDone(getCallerIdentity(), s);
        }

        public void dispatchOnError() {
            String s = getUtteranceId();
            if(s != null)
                mCallbacks.dispatchOnError(getCallerIdentity(), s);
        }

        public void dispatchOnStart() {
            String s = getUtteranceId();
            if(s != null)
                mCallbacks.dispatchOnStart(getCallerIdentity(), s);
        }

        public Object getCallerIdentity() {
            return mCallerIdentity;
        }

        public int getCallerPid() {
            return mCallerPid;
        }

        public int getCallerUid() {
            return mCallerUid;
        }

        protected float getFloatParam(String s, float f) {
            if(mParams != null)
                f = mParams.getFloat(s, f);
            return f;
        }

        protected int getIntParam(String s, int i) {
            if(mParams != null)
                i = mParams.getInt(s, i);
            return i;
        }

        public float getPan() {
            return getFloatParam("pan", 0.0F);
        }

        public int getStreamType() {
            return getIntParam("streamType", 3);
        }

        protected String getStringParam(String s, String s1) {
            if(mParams != null)
                s1 = mParams.getString(s, s1);
            return s1;
        }

        public String getUtteranceId() {
            return getStringParam("utteranceId", null);
        }

        public float getVolume() {
            return getFloatParam("volume", 1.0F);
        }

        /**
         * @deprecated Method isStopped is deprecated
         */

        protected boolean isStopped() {
            this;
            JVM INSTR monitorenter ;
            boolean flag = mStopped;
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception;
            exception;
            throw exception;
        }

        public abstract boolean isValid();

        public int play() {
            this;
            JVM INSTR monitorenter ;
            if(mStarted)
                throw new IllegalStateException("play() called twice");
            break MISSING_BLOCK_LABEL_24;
            Exception exception;
            exception;
            throw exception;
            mStarted = true;
            this;
            JVM INSTR monitorexit ;
            return playImpl();
        }

        protected abstract int playImpl();

        public void stop() {
            this;
            JVM INSTR monitorenter ;
            if(mStopped)
                throw new IllegalStateException("stop() called twice");
            break MISSING_BLOCK_LABEL_24;
            Exception exception;
            exception;
            throw exception;
            mStopped = true;
            this;
            JVM INSTR monitorexit ;
            stopImpl();
            return;
        }

        protected abstract void stopImpl();

        private final Object mCallerIdentity;
        private final int mCallerPid;
        private final int mCallerUid;
        protected final Bundle mParams;
        private boolean mStarted;
        private boolean mStopped;
        final TextToSpeechService this$0;

        public SpeechItem(Object obj, int i, int j, Bundle bundle) {
            this$0 = TextToSpeechService.this;
            super();
            mStarted = false;
            mStopped = false;
            mCallerIdentity = obj;
            mParams = bundle;
            mCallerUid = i;
            mCallerPid = j;
        }
    }

    static interface UtteranceProgressDispatcher {

        public abstract void dispatchOnDone();

        public abstract void dispatchOnError();

        public abstract void dispatchOnStart();
    }

    private class SynthHandler extends Handler {

        /**
         * @deprecated Method getCurrentSpeechItem is deprecated
         */

        private SpeechItem getCurrentSpeechItem() {
            this;
            JVM INSTR monitorenter ;
            SpeechItem speechitem = mCurrentSpeechItem;
            this;
            JVM INSTR monitorexit ;
            return speechitem;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method maybeRemoveCurrentSpeechItem is deprecated
         */

        private SpeechItem maybeRemoveCurrentSpeechItem(Object obj) {
            SpeechItem speechitem = null;
            this;
            JVM INSTR monitorenter ;
            if(mCurrentSpeechItem != null && mCurrentSpeechItem.getCallerIdentity() == obj) {
                speechitem = mCurrentSpeechItem;
                mCurrentSpeechItem = null;
            }
            this;
            JVM INSTR monitorexit ;
            return speechitem;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method setCurrentSpeechItem is deprecated
         */

        private SpeechItem setCurrentSpeechItem(SpeechItem speechitem) {
            this;
            JVM INSTR monitorenter ;
            SpeechItem speechitem1;
            speechitem1 = mCurrentSpeechItem;
            mCurrentSpeechItem = speechitem;
            this;
            JVM INSTR monitorexit ;
            return speechitem1;
            Exception exception;
            exception;
            throw exception;
        }

        public int enqueueSpeechItem(int i, final SpeechItem speechItem) {
            byte byte0 = -1;
            if(speechItem.isValid()) goto _L2; else goto _L1
_L1:
            speechItem.dispatchOnError();
_L5:
            return byte0;
_L2:
            if(i != 0) goto _L4; else goto _L3
_L3:
            stopForApp(speechItem.getCallerIdentity());
_L6:
            Message message = Message.obtain(this, new Runnable() {

                public void run() {
                    setCurrentSpeechItem(speechItem);
                    speechItem.play();
                    setCurrentSpeechItem(null);
                }

                final SynthHandler this$1;
                final SpeechItem val$speechItem;

                 {
                    this$1 = SynthHandler.this;
                    speechItem = speechitem;
                    super();
                }
            });
            message.obj = speechItem.getCallerIdentity();
            if(sendMessage(message)) {
                byte0 = 0;
            } else {
                Log.w("TextToSpeechService", "SynthThread has quit");
                speechItem.dispatchOnError();
            }
            if(true) goto _L5; else goto _L4
_L4:
            if(i == 2)
                stopAll();
              goto _L6
        }

        public boolean isSpeaking() {
            boolean flag;
            if(getCurrentSpeechItem() != null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void quit() {
            getLooper().quit();
            SpeechItem speechitem = setCurrentSpeechItem(null);
            if(speechitem != null)
                speechitem.stop();
        }

        public int stopAll() {
            SpeechItem speechitem = setCurrentSpeechItem(null);
            if(speechitem != null)
                speechitem.stop();
            removeCallbacksAndMessages(null);
            mAudioPlaybackHandler.stop();
            return 0;
        }

        public int stopForApp(Object obj) {
            byte byte0;
            if(obj == null) {
                byte0 = -1;
            } else {
                removeCallbacksAndMessages(obj);
                SpeechItem speechitem = maybeRemoveCurrentSpeechItem(obj);
                if(speechitem != null)
                    speechitem.stop();
                mAudioPlaybackHandler.stopForApp(obj);
                byte0 = 0;
            }
            return byte0;
        }

        private SpeechItem mCurrentSpeechItem;
        final TextToSpeechService this$0;


        public SynthHandler(Looper looper) {
            this$0 = TextToSpeechService.this;
            super(looper);
            mCurrentSpeechItem = null;
        }
    }

    private class SynthThread extends HandlerThread
        implements android.os.MessageQueue.IdleHandler {

        private void broadcastTtsQueueProcessingCompleted() {
            Intent intent = new Intent("android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED");
            sendBroadcast(intent);
        }

        protected void onLooperPrepared() {
            getLooper().getQueue().addIdleHandler(this);
        }

        public boolean queueIdle() {
            if(mFirstIdle)
                mFirstIdle = false;
            else
                broadcastTtsQueueProcessingCompleted();
            return true;
        }

        private boolean mFirstIdle;
        final TextToSpeechService this$0;

        public SynthThread() {
            this$0 = TextToSpeechService.this;
            super("SynthThread", 0);
            mFirstIdle = true;
        }
    }


    public TextToSpeechService() {
    }

    private int getDefaultSpeechRate() {
        return getSecureSettingInt("tts_default_rate", 100);
    }

    private int getSecureSettingInt(String s, int i) {
        return android.provider.Settings.Secure.getInt(getContentResolver(), s, i);
    }

    private String[] getSettingsLocale() {
        return TtsEngines.parseLocalePref(mEngineHelper.getLocalePrefForEngine(mPackageName));
    }

    public IBinder onBind(Intent intent) {
        ITextToSpeechService.Stub stub;
        if("android.intent.action.TTS_SERVICE".equals(intent.getAction()))
            stub = mBinder;
        else
            stub = null;
        return stub;
    }

    public void onCreate() {
        super.onCreate();
        SynthThread synththread = new SynthThread();
        synththread.start();
        mSynthHandler = new SynthHandler(synththread.getLooper());
        mAudioPlaybackHandler = new AudioPlaybackHandler();
        mAudioPlaybackHandler.start();
        mEngineHelper = new TtsEngines(this);
        mCallbacks = new CallbackMap();
        mPackageName = ((PackageItemInfo) (getApplicationInfo())).packageName;
        String as[] = getSettingsLocale();
        onLoadLanguage(as[0], as[1], as[2]);
    }

    public void onDestroy() {
        mSynthHandler.quit();
        mAudioPlaybackHandler.quit();
        mCallbacks.kill();
        super.onDestroy();
    }

    protected Set onGetFeaturesForLanguage(String s, String s1, String s2) {
        return null;
    }

    protected abstract String[] onGetLanguage();

    protected abstract int onIsLanguageAvailable(String s, String s1, String s2);

    protected abstract int onLoadLanguage(String s, String s1, String s2);

    protected abstract void onStop();

    protected abstract void onSynthesizeText(SynthesisRequest synthesisrequest, SynthesisCallback synthesiscallback);

    private static final boolean DBG = false;
    private static final int MAX_SPEECH_ITEM_CHAR_LENGTH = 4000;
    private static final String SYNTH_THREAD_NAME = "SynthThread";
    private static final String TAG = "TextToSpeechService";
    private AudioPlaybackHandler mAudioPlaybackHandler;
    private final ITextToSpeechService.Stub mBinder = new ITextToSpeechService.Stub() {

        private transient boolean checkNonNull(Object aobj[]) {
            int i;
            int j;
            i = aobj.length;
            j = 0;
_L3:
            if(j >= i)
                break MISSING_BLOCK_LABEL_28;
            if(aobj[j] != null) goto _L2; else goto _L1
_L1:
            boolean flag = false;
_L4:
            return flag;
_L2:
            j++;
              goto _L3
            flag = true;
              goto _L4
        }

        private String intern(String s) {
            return s.intern();
        }

        public String[] getFeaturesForLanguage(String s, String s1, String s2) {
            Set set = onGetFeaturesForLanguage(s, s1, s2);
            String as[];
            if(set != null) {
                as = new String[set.size()];
                set.toArray(as);
            } else {
                as = new String[0];
            }
            return as;
        }

        public String[] getLanguage() {
            return onGetLanguage();
        }

        public int isLanguageAvailable(String s, String s1, String s2) {
            Object aobj[] = new Object[1];
            aobj[0] = s;
            int i;
            if(!checkNonNull(aobj))
                i = -1;
            else
                i = onIsLanguageAvailable(s, s1, s2);
            return i;
        }

        public boolean isSpeaking() {
            boolean flag;
            if(mSynthHandler.isSpeaking() || mAudioPlaybackHandler.isSpeaking())
                flag = true;
            else
                flag = false;
            return flag;
        }

        public int loadLanguage(String s, String s1, String s2) {
            Object aobj[] = new Object[1];
            aobj[0] = s;
            int i;
            if(!checkNonNull(aobj))
                i = -1;
            else
                i = onLoadLanguage(s, s1, s2);
            return i;
        }

        public int playAudio(IBinder ibinder, Uri uri, int i, Bundle bundle) {
            Object aobj[] = new Object[3];
            aobj[0] = ibinder;
            aobj[1] = uri;
            aobj[2] = bundle;
            int j;
            if(!checkNonNull(aobj)) {
                j = -1;
            } else {
                AudioSpeechItem audiospeechitem = new AudioSpeechItem(ibinder, Binder.getCallingUid(), Binder.getCallingPid(), bundle, uri);
                j = mSynthHandler.enqueueSpeechItem(i, audiospeechitem);
            }
            return j;
        }

        public int playSilence(IBinder ibinder, long l, int i, Bundle bundle) {
            Object aobj[] = new Object[2];
            aobj[0] = ibinder;
            aobj[1] = bundle;
            int j;
            if(!checkNonNull(aobj)) {
                j = -1;
            } else {
                SilenceSpeechItem silencespeechitem = new SilenceSpeechItem(ibinder, Binder.getCallingUid(), Binder.getCallingPid(), bundle, l);
                j = mSynthHandler.enqueueSpeechItem(i, silencespeechitem);
            }
            return j;
        }

        public void setCallback(IBinder ibinder, ITextToSpeechCallback itexttospeechcallback) {
            Object aobj[] = new Object[1];
            aobj[0] = ibinder;
            if(checkNonNull(aobj))
                mCallbacks.setCallback(ibinder, itexttospeechcallback);
        }

        public int speak(IBinder ibinder, String s, int i, Bundle bundle) {
            Object aobj[] = new Object[3];
            aobj[0] = ibinder;
            aobj[1] = s;
            aobj[2] = bundle;
            int j;
            if(!checkNonNull(aobj)) {
                j = -1;
            } else {
                SynthesisSpeechItem synthesisspeechitem = new SynthesisSpeechItem(ibinder, Binder.getCallingUid(), Binder.getCallingPid(), bundle, s);
                j = mSynthHandler.enqueueSpeechItem(i, synthesisspeechitem);
            }
            return j;
        }

        public int stop(IBinder ibinder) {
            Object aobj[] = new Object[1];
            aobj[0] = ibinder;
            int i;
            if(!checkNonNull(aobj))
                i = -1;
            else
                i = mSynthHandler.stopForApp(ibinder);
            return i;
        }

        public int synthesizeToFile(IBinder ibinder, String s, String s1, Bundle bundle) {
            Object aobj[] = new Object[4];
            aobj[0] = ibinder;
            aobj[1] = s;
            aobj[2] = s1;
            aobj[3] = bundle;
            int i;
            if(!checkNonNull(aobj)) {
                i = -1;
            } else {
                File file = new File(s1);
                SynthesisToFileSpeechItem synthesistofilespeechitem = new SynthesisToFileSpeechItem(ibinder, Binder.getCallingUid(), Binder.getCallingPid(), bundle, s, file);
                i = mSynthHandler.enqueueSpeechItem(1, synthesistofilespeechitem);
            }
            return i;
        }

        final TextToSpeechService this$0;

             {
                this$0 = TextToSpeechService.this;
                super();
            }
    };
    private CallbackMap mCallbacks;
    private TtsEngines mEngineHelper;
    private String mPackageName;
    private SynthHandler mSynthHandler;






}
