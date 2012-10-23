// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media.audiofx;

import java.util.StringTokenizer;

// Referenced classes of package android.media.audiofx:
//            AudioEffect

public class EnvironmentalReverb extends AudioEffect {
    public static class Settings {

        public String toString() {
            return new String((new StringBuilder()).append("EnvironmentalReverb;roomLevel=").append(Short.toString(roomLevel)).append(";roomHFLevel=").append(Short.toString(roomHFLevel)).append(";decayTime=").append(Integer.toString(decayTime)).append(";decayHFRatio=").append(Short.toString(decayHFRatio)).append(";reflectionsLevel=").append(Short.toString(reflectionsLevel)).append(";reflectionsDelay=").append(Integer.toString(reflectionsDelay)).append(";reverbLevel=").append(Short.toString(reverbLevel)).append(";reverbDelay=").append(Integer.toString(reverbDelay)).append(";diffusion=").append(Short.toString(diffusion)).append(";density=").append(Short.toString(density)).toString());
        }

        public short decayHFRatio;
        public int decayTime;
        public short density;
        public short diffusion;
        public int reflectionsDelay;
        public short reflectionsLevel;
        public int reverbDelay;
        public short reverbLevel;
        public short roomHFLevel;
        public short roomLevel;

        public Settings() {
        }

        public Settings(String s) {
            StringTokenizer stringtokenizer;
            stringtokenizer = new StringTokenizer(s, "=;");
            stringtokenizer.countTokens();
            if(stringtokenizer.countTokens() != 21)
                throw new IllegalArgumentException((new StringBuilder()).append("settings: ").append(s).toString());
            String s1 = stringtokenizer.nextToken();
            if(!s1.equals("EnvironmentalReverb"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid settings for EnvironmentalReverb: ").append(s1).toString());
            try {
                s1 = stringtokenizer.nextToken();
                if(!s1.equals("roomLevel"))
                    throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s1).toString());
            }
            catch(NumberFormatException numberformatexception) {
                throw new IllegalArgumentException((new StringBuilder()).append("invalid value for key: ").append(s1).toString());
            }
            roomLevel = Short.parseShort(stringtokenizer.nextToken());
            String s2 = stringtokenizer.nextToken();
            if(!s2.equals("roomHFLevel"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s2).toString());
            roomHFLevel = Short.parseShort(stringtokenizer.nextToken());
            s2 = stringtokenizer.nextToken();
            if(!s2.equals("decayTime"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s2).toString());
            decayTime = Integer.parseInt(stringtokenizer.nextToken());
            s2 = stringtokenizer.nextToken();
            if(!s2.equals("decayHFRatio"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s2).toString());
            decayHFRatio = Short.parseShort(stringtokenizer.nextToken());
            s2 = stringtokenizer.nextToken();
            if(!s2.equals("reflectionsLevel"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s2).toString());
            reflectionsLevel = Short.parseShort(stringtokenizer.nextToken());
            s2 = stringtokenizer.nextToken();
            if(!s2.equals("reflectionsDelay"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s2).toString());
            reflectionsDelay = Integer.parseInt(stringtokenizer.nextToken());
            s2 = stringtokenizer.nextToken();
            if(!s2.equals("reverbLevel"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s2).toString());
            reverbLevel = Short.parseShort(stringtokenizer.nextToken());
            s2 = stringtokenizer.nextToken();
            if(!s2.equals("reverbDelay"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s2).toString());
            reverbDelay = Integer.parseInt(stringtokenizer.nextToken());
            s2 = stringtokenizer.nextToken();
            if(!s2.equals("diffusion"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s2).toString());
            diffusion = Short.parseShort(stringtokenizer.nextToken());
            s2 = stringtokenizer.nextToken();
            if(!s2.equals("density")) {
                throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s2).toString());
            } else {
                density = Short.parseShort(stringtokenizer.nextToken());
                return;
            }
        }
    }

    private class BaseParameterListener
        implements AudioEffect.OnParameterChangeListener {

        public void onParameterChange(AudioEffect audioeffect, int i, byte abyte0[], byte abyte1[]) {
            OnParameterChangeListener onparameterchangelistener;
            onparameterchangelistener = null;
            synchronized(mParamListenerLock) {
                if(mParamListener != null)
                    onparameterchangelistener = mParamListener;
            }
            if(onparameterchangelistener == null) goto _L2; else goto _L1
_L1:
            int j;
            int k;
            j = -1;
            k = -1;
            if(abyte0.length == 4)
                j = byteArrayToInt(abyte0, 0);
            if(abyte1.length != 2) goto _L4; else goto _L3
_L3:
            k = byteArrayToShort(abyte1, 0);
_L6:
            if(j != -1 && k != -1)
                onparameterchangelistener.onParameterChange(EnvironmentalReverb.this, i, j, k);
_L2:
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
_L4:
            if(abyte1.length == 4)
                k = byteArrayToInt(abyte1, 0);
            if(true) goto _L6; else goto _L5
_L5:
        }

        final EnvironmentalReverb this$0;

        private BaseParameterListener() {
            this$0 = EnvironmentalReverb.this;
            super();
        }

    }

    public static interface OnParameterChangeListener {

        public abstract void onParameterChange(EnvironmentalReverb environmentalreverb, int i, int j, int k);
    }


    public EnvironmentalReverb(int i, int j) throws IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_ENV_REVERB, EFFECT_TYPE_NULL, i, j);
        mParamListener = null;
        mBaseParamListener = null;
    }

    public short getDecayHFRatio() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[] = new byte[2];
        checkStatus(getParameter(3, abyte0));
        return byteArrayToShort(abyte0);
    }

    public int getDecayTime() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[] = new byte[4];
        checkStatus(getParameter(2, abyte0));
        return byteArrayToInt(abyte0);
    }

    public short getDensity() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[] = new byte[2];
        checkStatus(getParameter(9, abyte0));
        return byteArrayToShort(abyte0);
    }

    public short getDiffusion() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[] = new byte[2];
        checkStatus(getParameter(8, abyte0));
        return byteArrayToShort(abyte0);
    }

    public Settings getProperties() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[] = new byte[PROPERTY_SIZE];
        checkStatus(getParameter(10, abyte0));
        Settings settings = new Settings();
        settings.roomLevel = byteArrayToShort(abyte0, 0);
        settings.roomHFLevel = byteArrayToShort(abyte0, 2);
        settings.decayTime = byteArrayToInt(abyte0, 4);
        settings.decayHFRatio = byteArrayToShort(abyte0, 8);
        settings.reflectionsLevel = byteArrayToShort(abyte0, 10);
        settings.reflectionsDelay = byteArrayToInt(abyte0, 12);
        settings.reverbLevel = byteArrayToShort(abyte0, 16);
        settings.reverbDelay = byteArrayToInt(abyte0, 18);
        settings.diffusion = byteArrayToShort(abyte0, 22);
        settings.density = byteArrayToShort(abyte0, 24);
        return settings;
    }

    public int getReflectionsDelay() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[] = new byte[4];
        checkStatus(getParameter(5, abyte0));
        return byteArrayToInt(abyte0);
    }

    public short getReflectionsLevel() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[] = new byte[2];
        checkStatus(getParameter(4, abyte0));
        return byteArrayToShort(abyte0);
    }

    public int getReverbDelay() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[] = new byte[4];
        checkStatus(getParameter(7, abyte0));
        return byteArrayToInt(abyte0);
    }

    public short getReverbLevel() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[] = new byte[2];
        checkStatus(getParameter(6, abyte0));
        return byteArrayToShort(abyte0);
    }

    public short getRoomHFLevel() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[] = new byte[2];
        checkStatus(getParameter(1, abyte0));
        return byteArrayToShort(abyte0);
    }

    public short getRoomLevel() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[] = new byte[2];
        checkStatus(getParameter(0, abyte0));
        return byteArrayToShort(abyte0);
    }

    public void setDecayHFRatio(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(3, shortToByteArray(word0)));
    }

    public void setDecayTime(int i) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(2, intToByteArray(i)));
    }

    public void setDensity(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(9, shortToByteArray(word0)));
    }

    public void setDiffusion(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(8, shortToByteArray(word0)));
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

    public void setProperties(Settings settings) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[][] = new byte[10][];
        abyte0[0] = shortToByteArray(settings.roomLevel);
        abyte0[1] = shortToByteArray(settings.roomHFLevel);
        abyte0[2] = intToByteArray(settings.decayTime);
        abyte0[3] = shortToByteArray(settings.decayHFRatio);
        abyte0[4] = shortToByteArray(settings.reflectionsLevel);
        abyte0[5] = intToByteArray(settings.reflectionsDelay);
        abyte0[6] = shortToByteArray(settings.reverbLevel);
        abyte0[7] = intToByteArray(settings.reverbDelay);
        abyte0[8] = shortToByteArray(settings.diffusion);
        abyte0[9] = shortToByteArray(settings.density);
        checkStatus(setParameter(10, concatArrays(abyte0)));
    }

    public void setReflectionsDelay(int i) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(5, intToByteArray(i)));
    }

    public void setReflectionsLevel(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(4, shortToByteArray(word0)));
    }

    public void setReverbDelay(int i) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(7, intToByteArray(i)));
    }

    public void setReverbLevel(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(6, shortToByteArray(word0)));
    }

    public void setRoomHFLevel(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(1, shortToByteArray(word0)));
    }

    public void setRoomLevel(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(0, shortToByteArray(word0)));
    }

    public static final int PARAM_DECAY_HF_RATIO = 3;
    public static final int PARAM_DECAY_TIME = 2;
    public static final int PARAM_DENSITY = 9;
    public static final int PARAM_DIFFUSION = 8;
    private static final int PARAM_PROPERTIES = 10;
    public static final int PARAM_REFLECTIONS_DELAY = 5;
    public static final int PARAM_REFLECTIONS_LEVEL = 4;
    public static final int PARAM_REVERB_DELAY = 7;
    public static final int PARAM_REVERB_LEVEL = 6;
    public static final int PARAM_ROOM_HF_LEVEL = 1;
    public static final int PARAM_ROOM_LEVEL = 0;
    private static int PROPERTY_SIZE = 0;
    private static final String TAG = "EnvironmentalReverb";
    private BaseParameterListener mBaseParamListener;
    private OnParameterChangeListener mParamListener;
    private final Object mParamListenerLock = new Object();

    static  {
        PROPERTY_SIZE = 26;
    }


}
