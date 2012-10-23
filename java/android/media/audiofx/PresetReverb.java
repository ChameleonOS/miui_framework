// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media.audiofx;

import java.util.StringTokenizer;

// Referenced classes of package android.media.audiofx:
//            AudioEffect

public class PresetReverb extends AudioEffect {
    public static class Settings {

        public String toString() {
            return new String((new StringBuilder()).append("PresetReverb;preset=").append(Short.toString(preset)).toString());
        }

        public short preset;

        public Settings() {
        }

        public Settings(String s) {
            StringTokenizer stringtokenizer;
            stringtokenizer = new StringTokenizer(s, "=;");
            stringtokenizer.countTokens();
            if(stringtokenizer.countTokens() != 3)
                throw new IllegalArgumentException((new StringBuilder()).append("settings: ").append(s).toString());
            String s1 = stringtokenizer.nextToken();
            if(!s1.equals("PresetReverb"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid settings for PresetReverb: ").append(s1).toString());
            try {
                s1 = stringtokenizer.nextToken();
                if(!s1.equals("preset"))
                    throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s1).toString());
            }
            catch(NumberFormatException numberformatexception) {
                throw new IllegalArgumentException((new StringBuilder()).append("invalid value for key: ").append(s1).toString());
            }
            preset = Short.parseShort(stringtokenizer.nextToken());
            return;
        }
    }

    private class BaseParameterListener
        implements AudioEffect.OnParameterChangeListener {

        public void onParameterChange(AudioEffect audioeffect, int i, byte abyte0[], byte abyte1[]) {
            OnParameterChangeListener onparameterchangelistener = null;
            synchronized(mParamListenerLock) {
                if(mParamListener != null)
                    onparameterchangelistener = mParamListener;
            }
            if(onparameterchangelistener != null) {
                int j = -1;
                short word0 = -1;
                if(abyte0.length == 4)
                    j = byteArrayToInt(abyte0, 0);
                if(abyte1.length == 2)
                    word0 = byteArrayToShort(abyte1, 0);
                if(j != -1 && word0 != -1)
                    onparameterchangelistener.onParameterChange(PresetReverb.this, i, j, word0);
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        final PresetReverb this$0;

        private BaseParameterListener() {
            this$0 = PresetReverb.this;
            super();
        }

    }

    public static interface OnParameterChangeListener {

        public abstract void onParameterChange(PresetReverb presetreverb, int i, int j, short word0);
    }


    public PresetReverb(int i, int j) throws IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_PRESET_REVERB, EFFECT_TYPE_NULL, i, j);
        mParamListener = null;
        mBaseParamListener = null;
    }

    public short getPreset() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short aword0[] = new short[1];
        checkStatus(getParameter(0, aword0));
        return aword0[0];
    }

    public Settings getProperties() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        Settings settings = new Settings();
        short aword0[] = new short[1];
        checkStatus(getParameter(0, aword0));
        settings.preset = aword0[0];
        return settings;
    }

    public void setParameterListener(OnParameterChangeListener onparameterchangelistener) {
        Object obj = mParamListenerLock;
        obj;
        JVM INSTR monitorenter ;
        if(mParamListener == null) {
            mParamListener = onparameterchangelistener;
            mBaseParamListener = new BaseParameterListener();
            super.setParameterListener(mBaseParamListener);
        }
        return;
    }

    public void setPreset(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(0, word0));
    }

    public void setProperties(Settings settings) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(0, settings.preset));
    }

    public static final int PARAM_PRESET = 0;
    public static final short PRESET_LARGEHALL = 5;
    public static final short PRESET_LARGEROOM = 3;
    public static final short PRESET_MEDIUMHALL = 4;
    public static final short PRESET_MEDIUMROOM = 2;
    public static final short PRESET_NONE = 0;
    public static final short PRESET_PLATE = 6;
    public static final short PRESET_SMALLROOM = 1;
    private static final String TAG = "PresetReverb";
    private BaseParameterListener mBaseParamListener;
    private OnParameterChangeListener mParamListener;
    private final Object mParamListenerLock = new Object();


}
