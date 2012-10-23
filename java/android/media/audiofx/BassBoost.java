// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media.audiofx;

import android.util.Log;
import java.util.StringTokenizer;

// Referenced classes of package android.media.audiofx:
//            AudioEffect

public class BassBoost extends AudioEffect {
    public static class Settings {

        public String toString() {
            return new String((new StringBuilder()).append("BassBoost;strength=").append(Short.toString(strength)).toString());
        }

        public short strength;

        public Settings() {
        }

        public Settings(String s) {
            StringTokenizer stringtokenizer;
            stringtokenizer = new StringTokenizer(s, "=;");
            stringtokenizer.countTokens();
            if(stringtokenizer.countTokens() != 3)
                throw new IllegalArgumentException((new StringBuilder()).append("settings: ").append(s).toString());
            String s1 = stringtokenizer.nextToken();
            if(!s1.equals("BassBoost"))
                throw new IllegalArgumentException((new StringBuilder()).append("invalid settings for BassBoost: ").append(s1).toString());
            try {
                s1 = stringtokenizer.nextToken();
                if(!s1.equals("strength"))
                    throw new IllegalArgumentException((new StringBuilder()).append("invalid key name: ").append(s1).toString());
            }
            catch(NumberFormatException numberformatexception) {
                throw new IllegalArgumentException((new StringBuilder()).append("invalid value for key: ").append(s1).toString());
            }
            strength = Short.parseShort(stringtokenizer.nextToken());
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
                    onparameterchangelistener.onParameterChange(BassBoost.this, i, j, word0);
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        final BassBoost this$0;

        private BaseParameterListener() {
            this$0 = BassBoost.this;
            super();
        }

    }

    public static interface OnParameterChangeListener {

        public abstract void onParameterChange(BassBoost bassboost, int i, int j, short word0);
    }


    public BassBoost(int i, int j) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        boolean flag = true;
        super(EFFECT_TYPE_BASS_BOOST, EFFECT_TYPE_NULL, i, j);
        mStrengthSupported = false;
        mParamListener = null;
        mBaseParamListener = null;
        if(j == 0)
            Log.w("BassBoost", "WARNING: attaching a BassBoost to global output mix is deprecated!");
        int ai[] = new int[flag];
        checkStatus(getParameter(0, ai));
        if(ai[0] == 0)
            flag = false;
        mStrengthSupported = flag;
    }

    public Settings getProperties() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        Settings settings = new Settings();
        short aword0[] = new short[1];
        checkStatus(getParameter(1, aword0));
        settings.strength = aword0[0];
        return settings;
    }

    public short getRoundedStrength() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short aword0[] = new short[1];
        checkStatus(getParameter(1, aword0));
        return aword0[0];
    }

    public boolean getStrengthSupported() {
        return mStrengthSupported;
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
        checkStatus(setParameter(1, settings.strength));
    }

    public void setStrength(short word0) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(1, word0));
    }

    public static final int PARAM_STRENGTH = 1;
    public static final int PARAM_STRENGTH_SUPPORTED = 0;
    private static final String TAG = "BassBoost";
    private BaseParameterListener mBaseParamListener;
    private OnParameterChangeListener mParamListener;
    private final Object mParamListenerLock = new Object();
    private boolean mStrengthSupported;


}
