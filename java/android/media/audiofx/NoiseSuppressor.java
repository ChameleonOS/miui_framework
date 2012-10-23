// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media.audiofx;

import android.util.Log;

// Referenced classes of package android.media.audiofx:
//            AudioEffect

public class NoiseSuppressor extends AudioEffect {

    private NoiseSuppressor(int i) throws IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_NS, EFFECT_TYPE_NULL, 0, i);
    }

    public static NoiseSuppressor create(int i) {
        NoiseSuppressor noisesuppressor = new NoiseSuppressor(i);
        noisesuppressor;
_L2:
        return noisesuppressor;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Log.w("NoiseSuppressor", (new StringBuilder()).append("not implemented on this device ").append(null).toString());
        break MISSING_BLOCK_LABEL_65;
        UnsupportedOperationException unsupportedoperationexception;
        unsupportedoperationexception;
        Log.w("NoiseSuppressor", "not enough resources");
        break MISSING_BLOCK_LABEL_65;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("NoiseSuppressor", "not enough memory");
_L3:
        noisesuppressor = null;
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
          goto _L3
    }

    public static boolean isAvailable() {
        return AudioEffect.isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS);
    }

    private static final String TAG = "NoiseSuppressor";
}
