// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.sip;

import android.os.RemoteException;
import android.util.Log;

// Referenced classes of package android.net.sip:
//            ISipSession, ISipSessionListener, SipProfile

public final class SipSession {
    public static class Listener {

        public void onCallBusy(SipSession sipsession) {
        }

        public void onCallChangeFailed(SipSession sipsession, int i, String s) {
        }

        public void onCallEnded(SipSession sipsession) {
        }

        public void onCallEstablished(SipSession sipsession, String s) {
        }

        public void onCallTransferring(SipSession sipsession, String s) {
        }

        public void onCalling(SipSession sipsession) {
        }

        public void onError(SipSession sipsession, int i, String s) {
        }

        public void onRegistering(SipSession sipsession) {
        }

        public void onRegistrationDone(SipSession sipsession, int i) {
        }

        public void onRegistrationFailed(SipSession sipsession, int i, String s) {
        }

        public void onRegistrationTimeout(SipSession sipsession) {
        }

        public void onRinging(SipSession sipsession, SipProfile sipprofile, String s) {
        }

        public void onRingingBack(SipSession sipsession) {
        }

        public Listener() {
        }
    }

    public static class State {

        public static String toString(int i) {
            i;
            JVM INSTR tableswitch 0 9: default 56
        //                       0 61
        //                       1 67
        //                       2 73
        //                       3 79
        //                       4 85
        //                       5 91
        //                       6 97
        //                       7 103
        //                       8 109
        //                       9 115;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
            String s = "NOT_DEFINED";
_L13:
            return s;
_L2:
            s = "READY_TO_CALL";
            continue; /* Loop/switch isn't completed */
_L3:
            s = "REGISTERING";
            continue; /* Loop/switch isn't completed */
_L4:
            s = "DEREGISTERING";
            continue; /* Loop/switch isn't completed */
_L5:
            s = "INCOMING_CALL";
            continue; /* Loop/switch isn't completed */
_L6:
            s = "INCOMING_CALL_ANSWERING";
            continue; /* Loop/switch isn't completed */
_L7:
            s = "OUTGOING_CALL";
            continue; /* Loop/switch isn't completed */
_L8:
            s = "OUTGOING_CALL_RING_BACK";
            continue; /* Loop/switch isn't completed */
_L9:
            s = "OUTGOING_CALL_CANCELING";
            continue; /* Loop/switch isn't completed */
_L10:
            s = "IN_CALL";
            continue; /* Loop/switch isn't completed */
_L11:
            s = "PINGING";
            if(true) goto _L13; else goto _L12
_L12:
        }

        public static final int DEREGISTERING = 2;
        public static final int ENDING_CALL = 10;
        public static final int INCOMING_CALL = 3;
        public static final int INCOMING_CALL_ANSWERING = 4;
        public static final int IN_CALL = 8;
        public static final int NOT_DEFINED = 101;
        public static final int OUTGOING_CALL = 5;
        public static final int OUTGOING_CALL_CANCELING = 7;
        public static final int OUTGOING_CALL_RING_BACK = 6;
        public static final int PINGING = 9;
        public static final int READY_TO_CALL = 0;
        public static final int REGISTERING = 1;

        private State() {
        }
    }


    SipSession(ISipSession isipsession) {
        mSession = isipsession;
        if(isipsession == null)
            break MISSING_BLOCK_LABEL_23;
        isipsession.setListener(createListener());
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("SipSession.setListener(): ").append(remoteexception).toString());
          goto _L1
    }

    SipSession(ISipSession isipsession, Listener listener) {
        this(isipsession);
        setListener(listener);
    }

    private ISipSessionListener createListener() {
        return new ISipSessionListener.Stub() {

            public void onCallBusy(ISipSession isipsession) {
                if(mListener != null)
                    mListener.onCallBusy(SipSession.this);
            }

            public void onCallChangeFailed(ISipSession isipsession, int i, String s) {
                if(mListener != null)
                    mListener.onCallChangeFailed(SipSession.this, i, s);
            }

            public void onCallEnded(ISipSession isipsession) {
                if(mListener != null)
                    mListener.onCallEnded(SipSession.this);
            }

            public void onCallEstablished(ISipSession isipsession, String s) {
                if(mListener != null)
                    mListener.onCallEstablished(SipSession.this, s);
            }

            public void onCallTransferring(ISipSession isipsession, String s) {
                if(mListener != null)
                    mListener.onCallTransferring(new SipSession(isipsession, mListener), s);
            }

            public void onCalling(ISipSession isipsession) {
                if(mListener != null)
                    mListener.onCalling(SipSession.this);
            }

            public void onError(ISipSession isipsession, int i, String s) {
                if(mListener != null)
                    mListener.onError(SipSession.this, i, s);
            }

            public void onRegistering(ISipSession isipsession) {
                if(mListener != null)
                    mListener.onRegistering(SipSession.this);
            }

            public void onRegistrationDone(ISipSession isipsession, int i) {
                if(mListener != null)
                    mListener.onRegistrationDone(SipSession.this, i);
            }

            public void onRegistrationFailed(ISipSession isipsession, int i, String s) {
                if(mListener != null)
                    mListener.onRegistrationFailed(SipSession.this, i, s);
            }

            public void onRegistrationTimeout(ISipSession isipsession) {
                if(mListener != null)
                    mListener.onRegistrationTimeout(SipSession.this);
            }

            public void onRinging(ISipSession isipsession, SipProfile sipprofile, String s) {
                if(mListener != null)
                    mListener.onRinging(SipSession.this, sipprofile, s);
            }

            public void onRingingBack(ISipSession isipsession) {
                if(mListener != null)
                    mListener.onRingingBack(SipSession.this);
            }

            final SipSession this$0;

             {
                this$0 = SipSession.this;
                super();
            }
        };
    }

    public void answerCall(String s, int i) {
        mSession.answerCall(s, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("answerCall(): ").append(remoteexception).toString());
          goto _L1
    }

    public void changeCall(String s, int i) {
        mSession.changeCall(s, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("changeCall(): ").append(remoteexception).toString());
          goto _L1
    }

    public void endCall() {
        mSession.endCall();
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("endCall(): ").append(remoteexception).toString());
          goto _L1
    }

    public String getCallId() {
        String s1 = mSession.getCallId();
        String s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("getCallId(): ").append(remoteexception).toString());
        s = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getLocalIp() {
        String s1 = mSession.getLocalIp();
        String s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("getLocalIp(): ").append(remoteexception).toString());
        s = "127.0.0.1";
        if(true) goto _L2; else goto _L1
_L1:
    }

    public SipProfile getLocalProfile() {
        SipProfile sipprofile1 = mSession.getLocalProfile();
        SipProfile sipprofile = sipprofile1;
_L2:
        return sipprofile;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("getLocalProfile(): ").append(remoteexception).toString());
        sipprofile = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public SipProfile getPeerProfile() {
        SipProfile sipprofile1 = mSession.getPeerProfile();
        SipProfile sipprofile = sipprofile1;
_L2:
        return sipprofile;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("getPeerProfile(): ").append(remoteexception).toString());
        sipprofile = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    ISipSession getRealSession() {
        return mSession;
    }

    public int getState() {
        int j = mSession.getState();
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("getState(): ").append(remoteexception).toString());
        i = 101;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isInCall() {
        boolean flag1 = mSession.isInCall();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("isInCall(): ").append(remoteexception).toString());
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void makeCall(SipProfile sipprofile, String s, int i) {
        mSession.makeCall(sipprofile, s, i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("makeCall(): ").append(remoteexception).toString());
          goto _L1
    }

    public void register(int i) {
        mSession.register(i);
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("register(): ").append(remoteexception).toString());
          goto _L1
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }

    public void unregister() {
        mSession.unregister();
_L1:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("SipSession", (new StringBuilder()).append("unregister(): ").append(remoteexception).toString());
          goto _L1
    }

    private static final String TAG = "SipSession";
    private Listener mListener;
    private final ISipSession mSession;

}
