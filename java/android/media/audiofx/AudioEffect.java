// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media.audiofx;

import android.os.*;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class AudioEffect {
    private class NativeEventHandler extends Handler {

        public void handleMessage(Message message) {
            boolean flag = true;
            if(mAudioEffect != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            switch(message.what) {
            default:
                Log.e("AudioEffect-JAVA", (new StringBuilder()).append("handleMessage() Unknown event type: ").append(message.what).toString());
                break;

            case 1: // '\001'
                OnEnableStatusChangeListener onenablestatuschangelistener;
                synchronized(mListenerLock) {
                    onenablestatuschangelistener = mAudioEffect.mEnableStatusChangeListener;
                }
                if(onenablestatuschangelistener != null) {
                    AudioEffect audioeffect1 = mAudioEffect;
                    if(message.arg1 == 0)
                        flag = false;
                    onenablestatuschangelistener.onEnableStatusChange(audioeffect1, flag);
                }
                break;

            case 0: // '\0'
                OnControlStatusChangeListener oncontrolstatuschangelistener;
                synchronized(mListenerLock) {
                    oncontrolstatuschangelistener = mAudioEffect.mControlChangeStatusListener;
                }
                if(oncontrolstatuschangelistener != null) {
                    AudioEffect audioeffect = mAudioEffect;
                    if(message.arg1 == 0)
                        flag = false;
                    oncontrolstatuschangelistener.onControlStatusChange(audioeffect, flag);
                }
                break;

            case 2: // '\002'
                OnParameterChangeListener onparameterchangelistener;
                synchronized(mListenerLock) {
                    onparameterchangelistener = mAudioEffect.mParameterChangeListener;
                }
                if(onparameterchangelistener != null) {
                    int i = message.arg1;
                    byte abyte0[] = (byte[])(byte[])message.obj;
                    int j = byteArrayToInt(abyte0, 0);
                    int k = byteArrayToInt(abyte0, 4);
                    int l = byteArrayToInt(abyte0, 8);
                    byte abyte1[] = new byte[k];
                    byte abyte2[] = new byte[l];
                    System.arraycopy(abyte0, 12, abyte1, 0, k);
                    System.arraycopy(abyte0, i, abyte2, 0, l);
                    onparameterchangelistener.onParameterChange(mAudioEffect, j, abyte1, abyte2);
                }
                break;
            }
            continue; /* Loop/switch isn't completed */
            exception2;
            obj2;
            JVM INSTR monitorexit ;
            throw exception2;
            exception1;
            obj1;
            JVM INSTR monitorexit ;
            throw exception1;
            if(true) goto _L1; else goto _L3
_L3:
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private AudioEffect mAudioEffect;
        final AudioEffect this$0;

        public NativeEventHandler(AudioEffect audioeffect1, Looper looper) {
            this$0 = AudioEffect.this;
            super(looper);
            mAudioEffect = audioeffect1;
        }
    }

    public static interface OnParameterChangeListener {

        public abstract void onParameterChange(AudioEffect audioeffect, int i, byte abyte0[], byte abyte1[]);
    }

    public static interface OnControlStatusChangeListener {

        public abstract void onControlStatusChange(AudioEffect audioeffect, boolean flag);
    }

    public static interface OnEnableStatusChangeListener {

        public abstract void onEnableStatusChange(AudioEffect audioeffect, boolean flag);
    }

    public static class Descriptor {

        public String connectMode;
        public String implementor;
        public String name;
        public UUID type;
        public UUID uuid;

        public Descriptor() {
        }

        public Descriptor(String s, String s1, String s2, String s3, String s4) {
            type = UUID.fromString(s);
            uuid = UUID.fromString(s1);
            connectMode = s2;
            name = s3;
            implementor = s4;
        }
    }


    public AudioEffect(UUID uuid, UUID uuid1, int i, int j) throws IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        mState = 0;
        mStateLock = new Object();
        mEnableStatusChangeListener = null;
        mControlChangeStatusListener = null;
        mParameterChangeListener = null;
        mListenerLock = new Object();
        mNativeEventHandler = null;
        int ai[] = new int[1];
        Descriptor adescriptor[] = new Descriptor[1];
        int k = native_setup(new WeakReference(this), uuid.toString(), uuid1.toString(), i, j, ai, adescriptor);
        if(k != 0 && k != -2) {
            Log.e("AudioEffect-JAVA", (new StringBuilder()).append("Error code ").append(k).append(" when initializing AudioEffect.").toString());
            switch(k) {
            default:
                throw new RuntimeException((new StringBuilder()).append("Cannot initialize effect engine for type: ").append(uuid).append(" Error: ").append(k).toString());

            case -4: 
                throw new IllegalArgumentException((new StringBuilder()).append("Effect type: ").append(uuid).append(" not supported.").toString());

            case -5: 
                throw new UnsupportedOperationException("Effect library not loaded");
            }
        }
        mId = ai[0];
        mDescriptor = adescriptor[0];
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        mState = 1;
        return;
    }

    private void createNativeEventHandler() {
        Looper looper = Looper.myLooper();
        if(looper != null) {
            mNativeEventHandler = new NativeEventHandler(this, looper);
        } else {
            Looper looper1 = Looper.getMainLooper();
            if(looper1 != null)
                mNativeEventHandler = new NativeEventHandler(this, looper1);
            else
                mNativeEventHandler = null;
        }
    }

    public static boolean isEffectTypeAvailable(UUID uuid) {
        Descriptor adescriptor[];
        int i;
        adescriptor = queryEffects();
        i = 0;
_L3:
        if(i >= adescriptor.length)
            break MISSING_BLOCK_LABEL_35;
        if(!adescriptor[i].type.equals(uuid)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
    }

    public static boolean isError(int i) {
        boolean flag;
        if(i < 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private final native int native_command(int i, int j, byte abyte0[], int k, byte abyte1[]);

    private final native void native_finalize();

    private final native boolean native_getEnabled();

    private final native int native_getParameter(int i, byte abyte0[], int j, byte abyte1[]);

    private final native boolean native_hasControl();

    private static final native void native_init();

    private static native Object[] native_query_effects();

    private static native Object[] native_query_pre_processing(int i);

    private final native void native_release();

    private final native int native_setEnabled(boolean flag);

    private final native int native_setParameter(int i, byte abyte0[], int j, byte abyte1[]);

    private final native int native_setup(Object obj, String s, String s1, int i, int j, int ai[], Object aobj[]);

    private static void postEventFromNative(Object obj, int i, int j, int k, Object obj1) {
        AudioEffect audioeffect;
        audioeffect = (AudioEffect)((WeakReference)obj).get();
        break MISSING_BLOCK_LABEL_12;
        if(audioeffect != null && audioeffect.mNativeEventHandler != null) {
            Message message = audioeffect.mNativeEventHandler.obtainMessage(i, j, k, obj1);
            audioeffect.mNativeEventHandler.sendMessage(message);
        }
        return;
    }

    public static Descriptor[] queryEffects() {
        return (Descriptor[])(Descriptor[])native_query_effects();
    }

    public static Descriptor[] queryPreProcessings(int i) {
        return (Descriptor[])(Descriptor[])native_query_pre_processing(i);
    }

    public int byteArrayToInt(byte abyte0[]) {
        return byteArrayToInt(abyte0, 0);
    }

    public int byteArrayToInt(byte abyte0[], int i) {
        ByteBuffer bytebuffer = ByteBuffer.wrap(abyte0);
        bytebuffer.order(ByteOrder.nativeOrder());
        return bytebuffer.getInt(i);
    }

    public short byteArrayToShort(byte abyte0[]) {
        return byteArrayToShort(abyte0, 0);
    }

    public short byteArrayToShort(byte abyte0[], int i) {
        ByteBuffer bytebuffer = ByteBuffer.wrap(abyte0);
        bytebuffer.order(ByteOrder.nativeOrder());
        return bytebuffer.getShort(i);
    }

    public void checkState(String s) throws IllegalStateException {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(mState != 1)
            throw new IllegalStateException((new StringBuilder()).append(s).append(" called on uninitialized AudioEffect.").toString());
        break MISSING_BLOCK_LABEL_48;
        Exception exception;
        exception;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    public void checkStatus(int i) {
        if(isError(i))
            switch(i) {
            default:
                throw new RuntimeException("AudioEffect: set/get parameter error");

            case -4: 
                throw new IllegalArgumentException("AudioEffect: bad parameter value");

            case -5: 
                throw new UnsupportedOperationException("AudioEffect: invalid parameter operation");
            }
        else
            return;
    }

    public int command(int i, byte abyte0[], byte abyte1[]) throws IllegalStateException {
        checkState("command()");
        return native_command(i, abyte0.length, abyte0, abyte1.length, abyte1);
    }

    public transient byte[] concatArrays(byte abyte0[][]) {
        int i = 0;
        int j = abyte0.length;
        for(int k = 0; k < j; k++)
            i += abyte0[k].length;

        byte abyte1[] = new byte[i];
        int l = 0;
        int i1 = abyte0.length;
        for(int j1 = 0; j1 < i1; j1++) {
            byte abyte2[] = abyte0[j1];
            System.arraycopy(abyte2, 0, abyte1, l, abyte2.length);
            l += abyte2.length;
        }

        return abyte1;
    }

    protected void finalize() {
        native_finalize();
    }

    public Descriptor getDescriptor() throws IllegalStateException {
        checkState("getDescriptor()");
        return mDescriptor;
    }

    public boolean getEnabled() throws IllegalStateException {
        checkState("getEnabled()");
        return native_getEnabled();
    }

    public int getId() throws IllegalStateException {
        checkState("getId()");
        return mId;
    }

    public int getParameter(int i, byte abyte0[]) throws IllegalStateException {
        return getParameter(intToByteArray(i), abyte0);
    }

    public int getParameter(int i, int ai[]) throws IllegalStateException {
        int k;
        if(ai.length > 2) {
            k = -4;
        } else {
            byte abyte0[] = intToByteArray(i);
            byte abyte1[] = new byte[4 * ai.length];
            int j = getParameter(abyte0, abyte1);
            if(j == 4 || j == 8) {
                ai[0] = byteArrayToInt(abyte1);
                if(j == 8)
                    ai[1] = byteArrayToInt(abyte1, 4);
                k = j / 4;
            } else {
                k = -1;
            }
        }
        return k;
    }

    public int getParameter(int i, short aword0[]) throws IllegalStateException {
        int k;
        if(aword0.length > 2) {
            k = -4;
        } else {
            byte abyte0[] = intToByteArray(i);
            byte abyte1[] = new byte[2 * aword0.length];
            int j = getParameter(abyte0, abyte1);
            if(j == 2 || j == 4) {
                aword0[0] = byteArrayToShort(abyte1);
                if(j == 4)
                    aword0[1] = byteArrayToShort(abyte1, 2);
                k = j / 2;
            } else {
                k = -1;
            }
        }
        return k;
    }

    public int getParameter(byte abyte0[], byte abyte1[]) throws IllegalStateException {
        checkState("getParameter()");
        return native_getParameter(abyte0.length, abyte0, abyte1.length, abyte1);
    }

    public int getParameter(int ai[], byte abyte0[]) throws IllegalStateException {
        int i;
        if(ai.length > 2) {
            i = -4;
        } else {
            byte abyte1[] = intToByteArray(ai[0]);
            if(ai.length > 1) {
                byte abyte2[] = intToByteArray(ai[1]);
                byte abyte3[][] = new byte[2][];
                abyte3[0] = abyte1;
                abyte3[1] = abyte2;
                abyte1 = concatArrays(abyte3);
            }
            i = getParameter(abyte1, abyte0);
        }
        return i;
    }

    public int getParameter(int ai[], int ai1[]) throws IllegalStateException {
        int i;
        if(ai.length > 2 || ai1.length > 2) {
            i = -4;
        } else {
            byte abyte0[] = intToByteArray(ai[0]);
            if(ai.length > 1) {
                byte abyte2[] = intToByteArray(ai[1]);
                byte abyte3[][] = new byte[2][];
                abyte3[0] = abyte0;
                abyte3[1] = abyte2;
                abyte0 = concatArrays(abyte3);
            }
            byte abyte1[] = new byte[4 * ai1.length];
            int j = getParameter(abyte0, abyte1);
            if(j == 4 || j == 8) {
                ai1[0] = byteArrayToInt(abyte1);
                if(j == 8)
                    ai1[1] = byteArrayToInt(abyte1, 4);
                i = j / 4;
            } else {
                i = -1;
            }
        }
        return i;
    }

    public int getParameter(int ai[], short aword0[]) throws IllegalStateException {
        int i;
        if(ai.length > 2 || aword0.length > 2) {
            i = -4;
        } else {
            byte abyte0[] = intToByteArray(ai[0]);
            if(ai.length > 1) {
                byte abyte2[] = intToByteArray(ai[1]);
                byte abyte3[][] = new byte[2][];
                abyte3[0] = abyte0;
                abyte3[1] = abyte2;
                abyte0 = concatArrays(abyte3);
            }
            byte abyte1[] = new byte[2 * aword0.length];
            int j = getParameter(abyte0, abyte1);
            if(j == 2 || j == 4) {
                aword0[0] = byteArrayToShort(abyte1);
                if(j == 4)
                    aword0[1] = byteArrayToShort(abyte1, 2);
                i = j / 2;
            } else {
                i = -1;
            }
        }
        return i;
    }

    public boolean hasControl() throws IllegalStateException {
        checkState("hasControl()");
        return native_hasControl();
    }

    public byte[] intToByteArray(int i) {
        ByteBuffer bytebuffer = ByteBuffer.allocate(4);
        bytebuffer.order(ByteOrder.nativeOrder());
        bytebuffer.putInt(i);
        return bytebuffer.array();
    }

    public void release() {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        native_release();
        mState = 0;
        return;
    }

    public void setControlStatusListener(OnControlStatusChangeListener oncontrolstatuschangelistener) {
        synchronized(mListenerLock) {
            mControlChangeStatusListener = oncontrolstatuschangelistener;
        }
        if(oncontrolstatuschangelistener != null && mNativeEventHandler == null)
            createNativeEventHandler();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setEnableStatusListener(OnEnableStatusChangeListener onenablestatuschangelistener) {
        synchronized(mListenerLock) {
            mEnableStatusChangeListener = onenablestatuschangelistener;
        }
        if(onenablestatuschangelistener != null && mNativeEventHandler == null)
            createNativeEventHandler();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int setEnabled(boolean flag) throws IllegalStateException {
        checkState("setEnabled()");
        return native_setEnabled(flag);
    }

    public int setParameter(int i, int j) throws IllegalStateException {
        return setParameter(intToByteArray(i), intToByteArray(j));
    }

    public int setParameter(int i, short word0) throws IllegalStateException {
        return setParameter(intToByteArray(i), shortToByteArray(word0));
    }

    public int setParameter(int i, byte abyte0[]) throws IllegalStateException {
        return setParameter(intToByteArray(i), abyte0);
    }

    public int setParameter(byte abyte0[], byte abyte1[]) throws IllegalStateException {
        checkState("setParameter()");
        return native_setParameter(abyte0.length, abyte0, abyte1.length, abyte1);
    }

    public int setParameter(int ai[], byte abyte0[]) throws IllegalStateException {
        int i;
        if(ai.length > 2) {
            i = -4;
        } else {
            byte abyte1[] = intToByteArray(ai[0]);
            if(ai.length > 1) {
                byte abyte2[] = intToByteArray(ai[1]);
                byte abyte3[][] = new byte[2][];
                abyte3[0] = abyte1;
                abyte3[1] = abyte2;
                abyte1 = concatArrays(abyte3);
            }
            i = setParameter(abyte1, abyte0);
        }
        return i;
    }

    public int setParameter(int ai[], int ai1[]) throws IllegalStateException {
        int i;
        if(ai.length > 2 || ai1.length > 2) {
            i = -4;
        } else {
            byte abyte0[] = intToByteArray(ai[0]);
            if(ai.length > 1) {
                byte abyte4[] = intToByteArray(ai[1]);
                byte abyte5[][] = new byte[2][];
                abyte5[0] = abyte0;
                abyte5[1] = abyte4;
                abyte0 = concatArrays(abyte5);
            }
            byte abyte1[] = intToByteArray(ai1[0]);
            if(ai1.length > 1) {
                byte abyte2[] = intToByteArray(ai1[1]);
                byte abyte3[][] = new byte[2][];
                abyte3[0] = abyte1;
                abyte3[1] = abyte2;
                abyte1 = concatArrays(abyte3);
            }
            i = setParameter(abyte0, abyte1);
        }
        return i;
    }

    public int setParameter(int ai[], short aword0[]) throws IllegalStateException {
        int i;
        if(ai.length > 2 || aword0.length > 2) {
            i = -4;
        } else {
            byte abyte0[] = intToByteArray(ai[0]);
            if(ai.length > 1) {
                byte abyte4[] = intToByteArray(ai[1]);
                byte abyte5[][] = new byte[2][];
                abyte5[0] = abyte0;
                abyte5[1] = abyte4;
                abyte0 = concatArrays(abyte5);
            }
            byte abyte1[] = shortToByteArray(aword0[0]);
            if(aword0.length > 1) {
                byte abyte2[] = shortToByteArray(aword0[1]);
                byte abyte3[][] = new byte[2][];
                abyte3[0] = abyte1;
                abyte3[1] = abyte2;
                abyte1 = concatArrays(abyte3);
            }
            i = setParameter(abyte0, abyte1);
        }
        return i;
    }

    public void setParameterListener(OnParameterChangeListener onparameterchangelistener) {
        synchronized(mListenerLock) {
            mParameterChangeListener = onparameterchangelistener;
        }
        if(onparameterchangelistener != null && mNativeEventHandler == null)
            createNativeEventHandler();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public byte[] shortToByteArray(short word0) {
        ByteBuffer bytebuffer = ByteBuffer.allocate(2);
        bytebuffer.order(ByteOrder.nativeOrder());
        bytebuffer.putShort(word0);
        return bytebuffer.array();
    }

    public static final String ACTION_CLOSE_AUDIO_EFFECT_CONTROL_SESSION = "android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION";
    public static final String ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL = "android.media.action.DISPLAY_AUDIO_EFFECT_CONTROL_PANEL";
    public static final String ACTION_OPEN_AUDIO_EFFECT_CONTROL_SESSION = "android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION";
    public static final int ALREADY_EXISTS = -2;
    public static final int CONTENT_TYPE_GAME = 2;
    public static final int CONTENT_TYPE_MOVIE = 1;
    public static final int CONTENT_TYPE_MUSIC = 0;
    public static final int CONTENT_TYPE_VOICE = 3;
    public static final String EFFECT_AUXILIARY = "Auxiliary";
    public static final String EFFECT_INSERT = "Insert";
    public static final String EFFECT_PRE_PROCESSING = "Pre Processing";
    public static final UUID EFFECT_TYPE_AEC = UUID.fromString("7b491460-8d4d-11e0-bd61-0002a5d5c51b");
    public static final UUID EFFECT_TYPE_AGC = UUID.fromString("0a8abfe0-654c-11e0-ba26-0002a5d5c51b");
    public static final UUID EFFECT_TYPE_BASS_BOOST = UUID.fromString("0634f220-ddd4-11db-a0fc-0002a5d5c51b");
    public static final UUID EFFECT_TYPE_ENV_REVERB = UUID.fromString("c2e5d5f0-94bd-4763-9cac-4e234d06839e");
    public static final UUID EFFECT_TYPE_EQUALIZER = UUID.fromString("0bed4300-ddd6-11db-8f34-0002a5d5c51b");
    public static final UUID EFFECT_TYPE_NS = UUID.fromString("58b4b260-8e06-11e0-aa8e-0002a5d5c51b");
    public static final UUID EFFECT_TYPE_NULL = UUID.fromString("ec7178ec-e5e1-4432-a3f4-4657e6795210");
    public static final UUID EFFECT_TYPE_PRESET_REVERB = UUID.fromString("47382d60-ddd8-11db-bf3a-0002a5d5c51b");
    public static final UUID EFFECT_TYPE_VIRTUALIZER = UUID.fromString("37cc2c00-dddd-11db-8577-0002a5d5c51b");
    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -4;
    public static final int ERROR_DEAD_OBJECT = -7;
    public static final int ERROR_INVALID_OPERATION = -5;
    public static final int ERROR_NO_INIT = -3;
    public static final int ERROR_NO_MEMORY = -6;
    public static final String EXTRA_AUDIO_SESSION = "android.media.extra.AUDIO_SESSION";
    public static final String EXTRA_CONTENT_TYPE = "android.media.extra.CONTENT_TYPE";
    public static final String EXTRA_PACKAGE_NAME = "android.media.extra.PACKAGE_NAME";
    public static final int NATIVE_EVENT_CONTROL_STATUS = 0;
    public static final int NATIVE_EVENT_ENABLED_STATUS = 1;
    public static final int NATIVE_EVENT_PARAMETER_CHANGED = 2;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_UNINITIALIZED = 0;
    public static final int SUCCESS = 0;
    private static final String TAG = "AudioEffect-JAVA";
    private OnControlStatusChangeListener mControlChangeStatusListener;
    private Descriptor mDescriptor;
    private OnEnableStatusChangeListener mEnableStatusChangeListener;
    private int mId;
    private int mJniData;
    public final Object mListenerLock;
    private int mNativeAudioEffect;
    public NativeEventHandler mNativeEventHandler;
    private OnParameterChangeListener mParameterChangeListener;
    private int mState;
    private final Object mStateLock;

    static  {
        System.loadLibrary("audioeffect_jni");
        native_init();
    }



}
