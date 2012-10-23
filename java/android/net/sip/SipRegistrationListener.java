// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.sip;


public interface SipRegistrationListener {

    public abstract void onRegistering(String s);

    public abstract void onRegistrationDone(String s, long l);

    public abstract void onRegistrationFailed(String s, int i, String s1);
}
