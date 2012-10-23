// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media.audiofx;

import android.util.Log;

// Referenced classes of package android.media.audiofx:
//            AudioEffect

public class AutomaticGainControl extends AudioEffect {

    private AutomaticGainControl(int i) throws IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_AGC, EFFECT_TYPE_NULL, 0, i);
    }

    public static AutomaticGainControl create(int i) {
        AutomaticGainControl automaticgaincontrol = new AutomaticGainControl(i);
        automaticgaincontrol;
_L2:
        return automaticgaincontrol;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Log.w("AutomaticGainControl", (new StringBuilder()).append("not implemented on this device ").append(null).toString());
        break MISSING_BLOCK_LABEL_65;
        UnsupportedOperationException unsupportedoperationexception;
        unsupportedoperationexception;
        Log.w("AutomaticGainControl", "not enough resources");
        break MISSING_BLOCK_LABEL_65;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("AutomaticGainControl", "not enough memory");
_L3:
        automaticgaincontrol = null;
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
          goto _L3
    }

    public static boolean isAvailable() {
        return AudioEffect.isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AGC);
    }

    private static final String TAG = "AutomaticGainControl";
}
