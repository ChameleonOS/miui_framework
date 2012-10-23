// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.test;


public interface SimulatedRadioControl {

    public abstract void pauseResponses();

    public abstract void progressConnectingCallState();

    public abstract void progressConnectingToActive();

    public abstract void resumeResponses();

    public abstract void setAutoProgressConnectingCall(boolean flag);

    public abstract void setNextCallFailCause(int i);

    public abstract void setNextDialFailImmediately(boolean flag);

    public abstract void shutdown();

    public abstract void triggerHangupAll();

    public abstract void triggerHangupBackground();

    public abstract void triggerHangupForeground();

    public abstract void triggerIncomingSMS(String s);

    public abstract void triggerIncomingUssd(String s, String s1);

    public abstract void triggerRing(String s);

    public abstract void triggerSsn(int i, int j);
}
