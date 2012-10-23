// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


public abstract class Vibrator {

    public Vibrator() {
    }

    public abstract void cancel();

    public abstract boolean hasVibrator();

    public abstract void vibrate(long l);

    public abstract void vibrate(long al[], int i);

    public void vibrateEx(byte abyte0[]) {
    }
}
