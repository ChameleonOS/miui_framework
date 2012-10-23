// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.sip;


// Referenced classes of package android.net.sip:
//            ISipSession, SipProfile

public class SipSessionAdapter extends ISipSessionListener.Stub {

    public SipSessionAdapter() {
    }

    public void onCallBusy(ISipSession isipsession) {
    }

    public void onCallChangeFailed(ISipSession isipsession, int i, String s) {
    }

    public void onCallEnded(ISipSession isipsession) {
    }

    public void onCallEstablished(ISipSession isipsession, String s) {
    }

    public void onCallTransferring(ISipSession isipsession, String s) {
    }

    public void onCalling(ISipSession isipsession) {
    }

    public void onError(ISipSession isipsession, int i, String s) {
    }

    public void onRegistering(ISipSession isipsession) {
    }

    public void onRegistrationDone(ISipSession isipsession, int i) {
    }

    public void onRegistrationFailed(ISipSession isipsession, int i, String s) {
    }

    public void onRegistrationTimeout(ISipSession isipsession) {
    }

    public void onRinging(ISipSession isipsession, SipProfile sipprofile, String s) {
    }

    public void onRingingBack(ISipSession isipsession) {
    }
}
