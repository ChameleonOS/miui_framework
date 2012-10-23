// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media.audiofx;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

// Referenced classes of package android.media.audiofx:
//            AudioEffect

public class Equalizer extends AudioEffect {
    public static class Settings {

        public String toString() {
            String s = new String((new StringBuilder()).append("Equalizer;curPreset=").append(Short.toString(curPreset)).append(";numBands=").append(Short.toString(numBands)).toString());
            for(int i = 0; i < numBands; i++)
                s = s.concat((new StringBuilder()).append(";band").append(i + 1).append("Level=").append(Short.toString(bandLevels[i])).toString());

            return s;
        }

        public short bandLevels[];
        public short curPreset;
        public short numBands;

        public Settings() {
            numBands = 0;
            bandLevels = null;
        }

        public Settings(String s) {
            StringTokenizer stringtokenizer;
            numBands = 0;
            bandLevels = null;
            stringtokenizer = new StringTokenizer(s, "=;");
            stringtokenizer.countTokens();
            if(stringtokenizer.countTokens() < 5)
                throw new IllegalArgumentException((new StringBuilder()).append("settings: ").append(s).toString());
            String s1 = stringtokenizer.nextToken();
            if(!s1.equals("Equalizer"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid settings for Equalizer: ").append(s1).toString());
            try {
                s1 = stringtokenizer.nextToken();
                if(!s1.equals("curPreset"))
                    throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s1).toString());
            }
            catch(NumberFormatException numberformatexception) {
                throw new IllegalArgumentException((new StringBuilder()).append("invalid value for key: ").append(s1).toString());
            }
            int i;
            curPreset = Short.parseShort(stringtokenizer.nextToken());
            String s2 = stringtokenizer.nextToken();
            if(!s2.equals("numBands"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s2).toString());
            numBands = Short.parseShort(stringtokenizer.nextToken());
            if(stringtokenizer.countTokens() != 2 * numBands)
                throw new IllegalArgumentException((new StringBuilder()).append("settings: ").append(s).toString());
            bandLevels = new short[numBands];
            i = 0;
_L1:
            if(i >= numBands)
                break MISSING_BLOCK_LABEL_403;
            String s3 = stringtokenizer.nextToken();
            if(!s3.equals((new StringBuilder()).append("band").append(i + 1).append("Level").toString()))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s3).toString());
            bandLevels[i] = Short.parseShort(stringtokenizer.nextToken());
            i++;
              goto _L1
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
            int l;
            j = -1;
            k = -1;
            l = -1;
            if(abyte0.length >= 4) {
                j = byteArrayToInt(abyte0, 0);
                if(abyte0.length >= 8)
                    k = byteArrayToInt(abyte0, 4);
            }
            if(abyte1.length != 2) goto _L4; else goto _L3
_L3:
            l = byteArrayToShort(abyte1, 0);
_L6:
            if(j != -1 && l != -1)
                onparameterchangelistener.onParameterChange(Equalizer.this, i, j, k, l);
_L2:
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
_L4:
            if(abyte1.length == 4)
                l = byteArrayToInt(abyte1, 0);
            if(true) goto _L6; else goto _L5
_L5:
        }

        final Equalizer this$0;

        private BaseParameterListener() {
            this$0 = Equalizer.this;
            super();
        }

    }

    public static interface OnParameterChangeListener {

        public abstract void onParameterChange(Equalizer equalizer, int i, int j, int k, int l);
    }


    public Equalizer(int i, int j) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_EQUALIZER, EFFECT_TYPE_NULL, i, j);
        mNumBands = 0;
        mParamListener = null;
        mBaseParamListener = null;
        if(j == 0)
            Log.w("Equalizer", "WARNING: attaching an Equalizer to global output mix is deprecated!");
        getNumberOfBands();
        mNumPresets = getNumberOfPresets();
        if(mNumPresets != 0) {
            mPresetNames = new String[mNumPresets];
            byte abyte0[] = new byte[32];
            int ai[] = new int[2];
            ai[0] = 8;
            int k = 0;
            while(k < mNumPresets)  {
                ai[1] = k;
                checkStatus(getParameter(ai, abyte0));
                int l;
                for(l = 0; abyte0[l] != 0; l++);
                try {
                    mPresetNames[k] = new String(abyte0, 0, l, "ISO-8859-1");
                }
                catch(UnsupportedEncodingException unsupportedencodingexception) {
                    Log.e("Equalizer", "preset name decode error");
                }
                k++;
            }
        }
    }

    public short getBand(int i) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int ai[] = new int[2];
        short aword0[] = new short[1];
        ai[0] = 5;
        ai[1] = i;
        checkStatus(getParameter(ai, aword0));
        return aword0[0];
    }

    public int[] getBandFreqRange(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int ai[] = new int[2];
        int ai1[] = new int[2];
        ai[0] = 4;
        ai[1] = word0;
        checkStatus(getParameter(ai, ai1));
        return ai1;
    }

    public short getBandLevel(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int ai[] = new int[2];
        short aword0[] = new short[1];
        ai[0] = 2;
        ai[1] = word0;
        checkStatus(getParameter(ai, aword0));
        return aword0[0];
    }

    public short[] getBandLevelRange() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short aword0[] = new short[2];
        checkStatus(getParameter(1, aword0));
        return aword0;
    }

    public int getCenterFreq(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int ai[] = new int[2];
        int ai1[] = new int[1];
        ai[0] = 3;
        ai[1] = word0;
        checkStatus(getParameter(ai, ai1));
        return ai1[0];
    }

    public short getCurrentPreset() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short aword0[] = new short[1];
        checkStatus(getParameter(6, aword0));
        return aword0[0];
    }

    public short getNumberOfBands() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short word0;
        if(mNumBands != 0) {
            word0 = mNumBands;
        } else {
            int ai[] = new int[1];
            ai[0] = 0;
            short aword0[] = new short[1];
            checkStatus(getParameter(ai, aword0));
            mNumBands = aword0[0];
            word0 = mNumBands;
        }
        return word0;
    }

    public short getNumberOfPresets() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short aword0[] = new short[1];
        checkStatus(getParameter(7, aword0));
        return aword0[0];
    }

    public String getPresetName(short word0) {
        String s;
        if(word0 >= 0 && word0 < mNumPresets)
            s = mPresetNames[word0];
        else
            s = "";
        return s;
    }

    public Settings getProperties() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte abyte0[] = new byte[4 + 2 * mNumBands];
        checkStatus(getParameter(9, abyte0));
        Settings settings = new Settings();
        settings.curPreset = byteArrayToShort(abyte0, 0);
        settings.numBands = byteArrayToShort(abyte0, 2);
        settings.bandLevels = new short[mNumBands];
        for(int i = 0; i < mNumBands; i++)
            settings.bandLevels[i] = byteArrayToShort(abyte0, 4 + i * 2);

        return settings;
    }

    public void setBandLevel(short word0, short word1) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int ai[] = new int[2];
        short aword0[] = new short[1];
        ai[0] = 2;
        ai[1] = word0;
        aword0[0] = word1;
        checkStatus(setParameter(ai, aword0));
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
        if(settings.numBands != settings.bandLevels.length || settings.numBands != mNumBands)
            throw new IllegalArgumentException((new StringBuilder()).append("settings invalid band count: ").append(settings.numBands).toString());
        byte abyte0[][] = new byte[2][];
        abyte0[0] = shortToByteArray(settings.curPreset);
        abyte0[1] = shortToByteArray(mNumBands);
        byte abyte1[] = concatArrays(abyte0);
        for(int i = 0; i < mNumBands; i++) {
            byte abyte2[][] = new byte[2][];
            abyte2[0] = abyte1;
            abyte2[1] = shortToByteArray(settings.bandLevels[i]);
            abyte1 = concatArrays(abyte2);
        }

        checkStatus(setParameter(9, abyte1));
    }

    public void usePreset(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(6, word0));
    }

    public static final int PARAM_BAND_FREQ_RANGE = 4;
    public static final int PARAM_BAND_LEVEL = 2;
    public static final int PARAM_CENTER_FREQ = 3;
    public static final int PARAM_CURRENT_PRESET = 6;
    public static final int PARAM_GET_BAND = 5;
    public static final int PARAM_GET_NUM_OF_PRESETS = 7;
    public static final int PARAM_GET_PRESET_NAME = 8;
    public static final int PARAM_LEVEL_RANGE = 1;
    public static final int PARAM_NUM_BANDS = 0;
    private static final int PARAM_PROPERTIES = 9;
    public static final int PARAM_STRING_SIZE_MAX = 32;
    private static final String TAG = "Equalizer";
    private BaseParameterListener mBaseParamListener;
    private short mNumBands;
    private int mNumPresets;
    private OnParameterChangeListener mParamListener;
    private final Object mParamListenerLock = new Object();
    private String mPresetNames[];


}
