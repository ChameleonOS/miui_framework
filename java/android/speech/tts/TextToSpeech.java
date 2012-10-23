// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.content.*;
import android.net.Uri;
import android.os.*;
import android.text.TextUtils;
import android.util.Log;
import java.util.*;

// Referenced classes of package android.speech.tts:
//            TtsEngines, UtteranceProgressListener, ITextToSpeechService

public class TextToSpeech {
    public static class EngineInfo {

        public String toString() {
            return (new StringBuilder()).append("EngineInfo{name=").append(name).append("}").toString();
        }

        public int icon;
        public String label;
        public String name;
        public int priority;
        public boolean system;

        public EngineInfo() {
        }
    }

    private static interface Action {

        public abstract Object run(ITextToSpeechService itexttospeechservice) throws RemoteException;
    }

    private class Connection
        implements ServiceConnection {

        public void disconnect() {
            mContext.unbindService(this);
        }

        public IBinder getCallerIdentity() {
            return mCallback;
        }

        public void onServiceConnected(ComponentName componentname, IBinder ibinder) {
            Log.i("TextToSpeech", (new StringBuilder()).append("Connected to ").append(componentname).toString());
            Object obj = mStartLock;
            obj;
            JVM INSTR monitorenter ;
            if(mServiceConnection != null)
                mServiceConnection.disconnect();
            mServiceConnection = this;
            mService = ITextToSpeechService.Stub.asInterface(ibinder);
            try {
                mService.setCallback(getCallerIdentity(), mCallback);
                dispatchOnInit(0);
            }
            catch(RemoteException remoteexception) {
                Log.e("TextToSpeech", "Error connecting to service, setCallback() failed");
                dispatchOnInit(-1);
            }
            obj;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void onServiceDisconnected(ComponentName componentname) {
            Object obj = mStartLock;
            obj;
            JVM INSTR monitorenter ;
            mService = null;
            if(mServiceConnection == this)
                mServiceConnection = null;
            return;
        }

        public Object runAction(Action action, Object obj, String s, boolean flag) {
            Object obj1 = mStartLock;
            obj1;
            JVM INSTR monitorenter ;
            if(mService == null) {
                Log.w("TextToSpeech", (new StringBuilder()).append(s).append(" failed: not connected to TTS engine").toString());
            } else {
                Object obj2 = action.run(mService);
                obj = obj2;
            }
            break MISSING_BLOCK_LABEL_125;
            RemoteException remoteexception;
            remoteexception;
            Log.e("TextToSpeech", (new StringBuilder()).append(s).append(" failed").toString(), remoteexception);
            if(flag) {
                disconnect();
                initTts();
            }
            return obj;
        }

        private final ITextToSpeechCallback.Stub mCallback;
        private ITextToSpeechService mService;
        final TextToSpeech this$0;

        private Connection() {
            this$0 = TextToSpeech.this;
            super();
            mCallback = new ITextToSpeechCallback.Stub() {

                public void onDone(String s) {
                    UtteranceProgressListener utteranceprogresslistener = mUtteranceProgressListener;
                    if(utteranceprogresslistener != null)
                        utteranceprogresslistener.onDone(s);
                }

                public void onError(String s) {
                    UtteranceProgressListener utteranceprogresslistener = mUtteranceProgressListener;
                    if(utteranceprogresslistener != null)
                        utteranceprogresslistener.onError(s);
                }

                public void onStart(String s) {
                    UtteranceProgressListener utteranceprogresslistener = mUtteranceProgressListener;
                    if(utteranceprogresslistener != null)
                        utteranceprogresslistener.onStart(s);
                }

                final Connection this$1;

                 {
                    this$1 = Connection.this;
                    super();
                }
            };
        }

    }

    public class Engine {

        public static final String ACTION_CHECK_TTS_DATA = "android.speech.tts.engine.CHECK_TTS_DATA";
        public static final String ACTION_GET_SAMPLE_TEXT = "android.speech.tts.engine.GET_SAMPLE_TEXT";
        public static final String ACTION_INSTALL_TTS_DATA = "android.speech.tts.engine.INSTALL_TTS_DATA";
        public static final String ACTION_TTS_DATA_INSTALLED = "android.speech.tts.engine.TTS_DATA_INSTALLED";
        public static final int CHECK_VOICE_DATA_BAD_DATA = -1;
        public static final int CHECK_VOICE_DATA_FAIL = 0;
        public static final int CHECK_VOICE_DATA_MISSING_DATA = -2;
        public static final int CHECK_VOICE_DATA_MISSING_VOLUME = -3;
        public static final int CHECK_VOICE_DATA_PASS = 1;
        public static final String DEFAULT_ENGINE = "com.svox.pico";
        public static final float DEFAULT_PAN = 0F;
        public static final int DEFAULT_PITCH = 100;
        public static final int DEFAULT_RATE = 100;
        public static final int DEFAULT_STREAM = 3;
        public static final float DEFAULT_VOLUME = 1F;
        public static final String EXTRA_AVAILABLE_VOICES = "availableVoices";
        public static final String EXTRA_CHECK_VOICE_DATA_FOR = "checkVoiceDataFor";
        public static final String EXTRA_TTS_DATA_INSTALLED = "dataInstalled";
        public static final String EXTRA_UNAVAILABLE_VOICES = "unavailableVoices";
        public static final String EXTRA_VOICE_DATA_FILES = "dataFiles";
        public static final String EXTRA_VOICE_DATA_FILES_INFO = "dataFilesInfo";
        public static final String EXTRA_VOICE_DATA_ROOT_DIRECTORY = "dataRoot";
        public static final String INTENT_ACTION_TTS_SERVICE = "android.intent.action.TTS_SERVICE";
        public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
        public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
        public static final String KEY_PARAM_COUNTRY = "country";
        public static final String KEY_PARAM_ENGINE = "engine";
        public static final String KEY_PARAM_LANGUAGE = "language";
        public static final String KEY_PARAM_PAN = "pan";
        public static final String KEY_PARAM_PITCH = "pitch";
        public static final String KEY_PARAM_RATE = "rate";
        public static final String KEY_PARAM_STREAM = "streamType";
        public static final String KEY_PARAM_UTTERANCE_ID = "utteranceId";
        public static final String KEY_PARAM_VARIANT = "variant";
        public static final String KEY_PARAM_VOLUME = "volume";
        public static final String SERVICE_META_DATA = "android.speech.tts";
        public static final int USE_DEFAULTS;
        final TextToSpeech this$0;

        public Engine() {
            this$0 = TextToSpeech.this;
            super();
        }
    }

    public static interface OnUtteranceCompletedListener {

        public abstract void onUtteranceCompleted(String s);
    }

    public static interface OnInitListener {

        public abstract void onInit(int i);
    }


    public TextToSpeech(Context context, OnInitListener oninitlistener) {
        this(context, oninitlistener, null);
    }

    public TextToSpeech(Context context, OnInitListener oninitlistener, String s) {
        this(context, oninitlistener, s, null, true);
    }

    public TextToSpeech(Context context, OnInitListener oninitlistener, String s, String s1, boolean flag) {
        mStartLock = new Object();
        mParams = new Bundle();
        mCurrentEngine = null;
        mContext = context;
        mInitListener = oninitlistener;
        mRequestedEngine = s;
        mUseFallback = flag;
        mEarcons = new HashMap();
        mUtterances = new HashMap();
        mUtteranceProgressListener = null;
        mEnginesHelper = new TtsEngines(mContext);
        if(s1 != null)
            mPackageName = s1;
        else
            mPackageName = mContext.getPackageName();
        initTts();
    }

    private boolean connectToEngine(String s) {
        boolean flag = true;
        Connection connection = new Connection();
        Intent intent = new Intent("android.intent.action.TTS_SERVICE");
        intent.setPackage(s);
        if(!mContext.bindService(intent, connection, flag)) {
            Log.e("TextToSpeech", (new StringBuilder()).append("Failed to bind to ").append(s).toString());
            flag = false;
        } else {
            Log.i("TextToSpeech", (new StringBuilder()).append("Sucessfully bound to ").append(s).toString());
        }
        return flag;
    }

    private void copyFloatParam(Bundle bundle, HashMap hashmap, String s) {
        String s1;
        s1 = (String)hashmap.get(s);
        if(TextUtils.isEmpty(s1))
            break MISSING_BLOCK_LABEL_28;
        bundle.putFloat(s, Float.parseFloat(s1));
_L2:
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void copyIntParam(Bundle bundle, HashMap hashmap, String s) {
        String s1;
        s1 = (String)hashmap.get(s);
        if(TextUtils.isEmpty(s1))
            break MISSING_BLOCK_LABEL_28;
        bundle.putInt(s, Integer.parseInt(s1));
_L2:
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void copyStringParam(Bundle bundle, HashMap hashmap, String s) {
        String s1 = (String)hashmap.get(s);
        if(s1 != null)
            bundle.putString(s, s1);
    }

    private void dispatchOnInit(int i) {
        Object obj = mStartLock;
        obj;
        JVM INSTR monitorenter ;
        if(mInitListener != null) {
            mInitListener.onInit(i);
            mInitListener = null;
        }
        return;
    }

    private IBinder getCallerIdentity() {
        return mServiceConnection.getCallerIdentity();
    }

    private Bundle getParams(HashMap hashmap) {
        Bundle bundle;
        if(hashmap != null && !hashmap.isEmpty()) {
            bundle = new Bundle(mParams);
            copyIntParam(bundle, hashmap, "streamType");
            copyStringParam(bundle, hashmap, "utteranceId");
            copyFloatParam(bundle, hashmap, "volume");
            copyFloatParam(bundle, hashmap, "pan");
            copyStringParam(bundle, hashmap, "networkTts");
            copyStringParam(bundle, hashmap, "embeddedTts");
            if(!TextUtils.isEmpty(mCurrentEngine)) {
                Iterator iterator = hashmap.entrySet().iterator();
                do {
                    if(!iterator.hasNext())
                        break;
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    String s = (String)entry.getKey();
                    if(s != null && s.startsWith(mCurrentEngine))
                        bundle.putString(s, (String)entry.getValue());
                } while(true);
            }
        } else {
            bundle = mParams;
        }
        return bundle;
    }

    private int initTts() {
        int i = 0;
        if(mRequestedEngine == null) goto _L2; else goto _L1
_L1:
        if(!mEnginesHelper.isEngineInstalled(mRequestedEngine)) goto _L4; else goto _L3
_L3:
        if(!connectToEngine(mRequestedEngine)) goto _L6; else goto _L5
_L5:
        mCurrentEngine = mRequestedEngine;
_L8:
        return i;
_L6:
        if(!mUseFallback) {
            mCurrentEngine = null;
            dispatchOnInit(-1);
            i = -1;
            continue; /* Loop/switch isn't completed */
        }
          goto _L2
_L4:
        if(!mUseFallback) {
            Log.i("TextToSpeech", (new StringBuilder()).append("Requested engine not installed: ").append(mRequestedEngine).toString());
            mCurrentEngine = null;
            dispatchOnInit(-1);
            i = -1;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        String s = getDefaultEngine();
        if(s != null && !s.equals(mRequestedEngine) && connectToEngine(s)) {
            mCurrentEngine = s;
        } else {
            String s1 = mEnginesHelper.getHighestRankedEngineName();
            if(s1 != null && !s1.equals(mRequestedEngine) && !s1.equals(s) && connectToEngine(s1)) {
                mCurrentEngine = s1;
            } else {
                mCurrentEngine = null;
                dispatchOnInit(-1);
                i = -1;
            }
        }
        if(true) goto _L8; else goto _L7
_L7:
    }

    private Uri makeResourceUri(String s, int i) {
        return (new android.net.Uri.Builder()).scheme("android.resource").encodedAuthority(s).appendEncodedPath(String.valueOf(i)).build();
    }

    private Object runAction(Action action, Object obj, String s) {
        return runAction(action, obj, s, true);
    }

    private Object runAction(Action action, Object obj, String s, boolean flag) {
        Object obj1 = mStartLock;
        obj1;
        JVM INSTR monitorenter ;
        if(mServiceConnection == null)
            Log.w("TextToSpeech", (new StringBuilder()).append(s).append(" failed: not bound to TTS engine").toString());
        else
            obj = mServiceConnection.runAction(action, obj, s, flag);
        return obj;
    }

    private Object runActionNoReconnect(Action action, Object obj, String s) {
        return runAction(action, obj, s, false);
    }

    public int addEarcon(String s, String s1) {
        Object obj = mStartLock;
        obj;
        JVM INSTR monitorenter ;
        mEarcons.put(s, Uri.parse(s1));
        return 0;
    }

    public int addEarcon(String s, String s1, int i) {
        Object obj = mStartLock;
        obj;
        JVM INSTR monitorenter ;
        mEarcons.put(s, makeResourceUri(s1, i));
        return 0;
    }

    public int addSpeech(String s, String s1) {
        Object obj = mStartLock;
        obj;
        JVM INSTR monitorenter ;
        mUtterances.put(s, Uri.parse(s1));
        return 0;
    }

    public int addSpeech(String s, String s1, int i) {
        Object obj = mStartLock;
        obj;
        JVM INSTR monitorenter ;
        mUtterances.put(s, makeResourceUri(s1, i));
        return 0;
    }

    public boolean areDefaultsEnforced() {
        return false;
    }

    public String getCurrentEngine() {
        return mCurrentEngine;
    }

    public String getDefaultEngine() {
        return mEnginesHelper.getDefaultEngine();
    }

    public List getEngines() {
        return mEnginesHelper.getEngines();
    }

    public Set getFeatures(final Locale locale) {
        return (Set)runAction(new Action() {

            public volatile Object run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return run(itexttospeechservice);
            }

            public Set run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                String as[] = itexttospeechservice.getFeaturesForLanguage(locale.getISO3Language(), locale.getISO3Country(), locale.getVariant());
                HashSet hashset;
                if(as != null) {
                    hashset = new HashSet();
                    Collections.addAll(hashset, as);
                } else {
                    hashset = null;
                }
                return hashset;
            }

            final TextToSpeech this$0;
            final Locale val$locale;

             {
                this$0 = TextToSpeech.this;
                locale = locale1;
                super();
            }
        }, null, "getFeatures");
    }

    public Locale getLanguage() {
        return (Locale)runAction(new Action() {

            public volatile Object run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return run(itexttospeechservice);
            }

            public Locale run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                String as[] = itexttospeechservice.getLanguage();
                Locale locale;
                if(as != null && as.length == 3)
                    locale = new Locale(as[0], as[1], as[2]);
                else
                    locale = null;
                return locale;
            }

            final TextToSpeech this$0;

             {
                this$0 = TextToSpeech.this;
                super();
            }
        }, null, "getLanguage");
    }

    public int isLanguageAvailable(final Locale loc) {
        return ((Integer)runAction(new Action() {

            public Integer run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return Integer.valueOf(itexttospeechservice.isLanguageAvailable(loc.getISO3Language(), loc.getISO3Country(), loc.getVariant()));
            }

            public volatile Object run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return run(itexttospeechservice);
            }

            final TextToSpeech this$0;
            final Locale val$loc;

             {
                this$0 = TextToSpeech.this;
                loc = locale;
                super();
            }
        }, Integer.valueOf(-2), "isLanguageAvailable")).intValue();
    }

    public boolean isSpeaking() {
        return ((Boolean)runAction(new Action() {

            public Boolean run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return Boolean.valueOf(itexttospeechservice.isSpeaking());
            }

            public volatile Object run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return run(itexttospeechservice);
            }

            final TextToSpeech this$0;

             {
                this$0 = TextToSpeech.this;
                super();
            }
        }, Boolean.valueOf(false), "isSpeaking")).booleanValue();
    }

    public int playEarcon(final String earcon, final int queueMode, final HashMap params) {
        return ((Integer)runAction(new Action() {

            public Integer run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                Uri uri = (Uri)mEarcons.get(earcon);
                Integer integer;
                if(uri == null)
                    integer = Integer.valueOf(-1);
                else
                    integer = Integer.valueOf(itexttospeechservice.playAudio(getCallerIdentity(), uri, queueMode, getParams(params)));
                return integer;
            }

            public volatile Object run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return run(itexttospeechservice);
            }

            final TextToSpeech this$0;
            final String val$earcon;
            final HashMap val$params;
            final int val$queueMode;

             {
                this$0 = TextToSpeech.this;
                earcon = s;
                queueMode = i;
                params = hashmap;
                super();
            }
        }, Integer.valueOf(-1), "playEarcon")).intValue();
    }

    public int playSilence(final long durationInMs, final int queueMode, final HashMap params) {
        return ((Integer)runAction(new Action() {

            public Integer run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return Integer.valueOf(itexttospeechservice.playSilence(getCallerIdentity(), durationInMs, queueMode, getParams(params)));
            }

            public volatile Object run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return run(itexttospeechservice);
            }

            final TextToSpeech this$0;
            final long val$durationInMs;
            final HashMap val$params;
            final int val$queueMode;

             {
                this$0 = TextToSpeech.this;
                durationInMs = l;
                queueMode = i;
                params = hashmap;
                super();
            }
        }, Integer.valueOf(-1), "playSilence")).intValue();
    }

    public int setEngineByPackageName(String s) {
        mRequestedEngine = s;
        return initTts();
    }

    public int setLanguage(final Locale loc) {
        return ((Integer)runAction(new Action() {

            public Integer run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                Integer integer;
                if(loc == null) {
                    integer = Integer.valueOf(-2);
                } else {
                    String s = loc.getISO3Language();
                    String s1 = loc.getISO3Country();
                    String s2 = loc.getVariant();
                    int i = itexttospeechservice.loadLanguage(s, s1, s2);
                    if(i >= 0) {
                        if(i < 2) {
                            s2 = "";
                            if(i < 1)
                                s1 = "";
                        }
                        mParams.putString("language", s);
                        mParams.putString("country", s1);
                        mParams.putString("variant", s2);
                    }
                    integer = Integer.valueOf(i);
                }
                return integer;
            }

            public volatile Object run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return run(itexttospeechservice);
            }

            final TextToSpeech this$0;
            final Locale val$loc;

             {
                this$0 = TextToSpeech.this;
                loc = locale;
                super();
            }
        }, Integer.valueOf(-2), "setLanguage")).intValue();
    }

    public int setOnUtteranceCompletedListener(OnUtteranceCompletedListener onutterancecompletedlistener) {
        mUtteranceProgressListener = UtteranceProgressListener.from(onutterancecompletedlistener);
        return 0;
    }

    public int setOnUtteranceProgressListener(UtteranceProgressListener utteranceprogresslistener) {
        mUtteranceProgressListener = utteranceprogresslistener;
        return 0;
    }

    public int setPitch(float f) {
        int i;
        if(f <= 0.0F)
            break MISSING_BLOCK_LABEL_53;
        i = (int)(100F * f);
        if(i <= 0)
            break MISSING_BLOCK_LABEL_53;
        Object obj = mStartLock;
        obj;
        JVM INSTR monitorenter ;
        byte byte0;
        mParams.putInt("pitch", i);
        byte0 = 0;
        break MISSING_BLOCK_LABEL_56;
        byte0 = -1;
        return byte0;
    }

    public int setSpeechRate(float f) {
        int i;
        if(f <= 0.0F)
            break MISSING_BLOCK_LABEL_53;
        i = (int)(100F * f);
        if(i <= 0)
            break MISSING_BLOCK_LABEL_53;
        Object obj = mStartLock;
        obj;
        JVM INSTR monitorenter ;
        byte byte0;
        mParams.putInt("rate", i);
        byte0 = 0;
        break MISSING_BLOCK_LABEL_56;
        byte0 = -1;
        return byte0;
    }

    public void shutdown() {
        runActionNoReconnect(new Action() {

            public volatile Object run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return run(itexttospeechservice);
            }

            public Void run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                itexttospeechservice.setCallback(getCallerIdentity(), null);
                itexttospeechservice.stop(getCallerIdentity());
                mServiceConnection.disconnect();
                mServiceConnection = null;
                mCurrentEngine = null;
                return null;
            }

            final TextToSpeech this$0;

             {
                this$0 = TextToSpeech.this;
                super();
            }
        }, null, "shutdown");
    }

    public int speak(final String text, final int queueMode, final HashMap params) {
        return ((Integer)runAction(new Action() {

            public Integer run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                Uri uri = (Uri)mUtterances.get(text);
                Integer integer;
                if(uri != null)
                    integer = Integer.valueOf(itexttospeechservice.playAudio(getCallerIdentity(), uri, queueMode, getParams(params)));
                else
                    integer = Integer.valueOf(itexttospeechservice.speak(getCallerIdentity(), text, queueMode, getParams(params)));
                return integer;
            }

            public volatile Object run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return run(itexttospeechservice);
            }

            final TextToSpeech this$0;
            final HashMap val$params;
            final int val$queueMode;
            final String val$text;

             {
                this$0 = TextToSpeech.this;
                text = s;
                queueMode = i;
                params = hashmap;
                super();
            }
        }, Integer.valueOf(-1), "speak")).intValue();
    }

    public int stop() {
        return ((Integer)runAction(new Action() {

            public Integer run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return Integer.valueOf(itexttospeechservice.stop(getCallerIdentity()));
            }

            public volatile Object run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return run(itexttospeechservice);
            }

            final TextToSpeech this$0;

             {
                this$0 = TextToSpeech.this;
                super();
            }
        }, Integer.valueOf(-1), "stop")).intValue();
    }

    public int synthesizeToFile(final String text, final HashMap params, final String filename) {
        return ((Integer)runAction(new Action() {

            public Integer run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return Integer.valueOf(itexttospeechservice.synthesizeToFile(getCallerIdentity(), text, filename, getParams(params)));
            }

            public volatile Object run(ITextToSpeechService itexttospeechservice) throws RemoteException {
                return run(itexttospeechservice);
            }

            final TextToSpeech this$0;
            final String val$filename;
            final HashMap val$params;
            final String val$text;

             {
                this$0 = TextToSpeech.this;
                text = s;
                filename = s1;
                params = hashmap;
                super();
            }
        }, Integer.valueOf(-1), "synthesizeToFile")).intValue();
    }

    public static final String ACTION_TTS_QUEUE_PROCESSING_COMPLETED = "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED";
    public static final int ERROR = -1;
    public static final int LANG_AVAILABLE = 0;
    public static final int LANG_COUNTRY_AVAILABLE = 1;
    public static final int LANG_COUNTRY_VAR_AVAILABLE = 2;
    public static final int LANG_MISSING_DATA = -1;
    public static final int LANG_NOT_SUPPORTED = -2;
    public static final int QUEUE_ADD = 1;
    static final int QUEUE_DESTROY = 2;
    public static final int QUEUE_FLUSH = 0;
    public static final int SUCCESS = 0;
    private static final String TAG = "TextToSpeech";
    private final Context mContext;
    private volatile String mCurrentEngine;
    private final Map mEarcons;
    private final TtsEngines mEnginesHelper;
    private OnInitListener mInitListener;
    private final String mPackageName;
    private final Bundle mParams;
    private String mRequestedEngine;
    private Connection mServiceConnection;
    private final Object mStartLock;
    private final boolean mUseFallback;
    private volatile UtteranceProgressListener mUtteranceProgressListener;
    private final Map mUtterances;







/*
    static Connection access$202(TextToSpeech texttospeech, Connection connection) {
        texttospeech.mServiceConnection = connection;
        return connection;
    }

*/


/*
    static String access$302(TextToSpeech texttospeech, String s) {
        texttospeech.mCurrentEngine = s;
        return s;
    }

*/






}
