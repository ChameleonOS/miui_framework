// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech;

import android.os.Bundle;

public interface RecognitionListener {

    public abstract void onBeginningOfSpeech();

    public abstract void onBufferReceived(byte abyte0[]);

    public abstract void onEndOfSpeech();

    public abstract void onError(int i);

    public abstract void onEvent(int i, Bundle bundle);

    public abstract void onPartialResults(Bundle bundle);

    public abstract void onReadyForSpeech(Bundle bundle);

    public abstract void onResults(Bundle bundle);

    public abstract void onRmsChanged(float f);
}
