// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;


public interface SynthesisCallback {

    public abstract int audioAvailable(byte abyte0[], int i, int j);

    public abstract int done();

    public abstract void error();

    public abstract int getMaxBufferSize();

    public abstract int start(int i, int j, int k);
}
