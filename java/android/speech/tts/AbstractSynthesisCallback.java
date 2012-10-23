// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;


// Referenced classes of package android.speech.tts:
//            SynthesisCallback

abstract class AbstractSynthesisCallback
    implements SynthesisCallback {

    AbstractSynthesisCallback() {
    }

    abstract boolean isDone();

    abstract void stop();
}
