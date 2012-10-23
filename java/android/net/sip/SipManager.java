// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.sip;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.text.ParseException;

// Referenced classes of package android.net.sip:
//            SipException, ISipService, SipSession, SipProfile, 
//            SipAudioCall, ISipSession, SipRegistrationListener, ISipSessionListener, 
//            SipSessionAdapter

public class SipManager {
    private static class ListenerRelay extends SipSessionAdapter {

        private String getUri(ISipSession isipsession) {
            if(isipsession != null)
                break MISSING_BLOCK_LABEL_13;
            String s;
            s = mUri;
            break MISSING_BLOCK_LABEL_60;
            String s1 = isipsession.getLocalProfile().getUriString();
            s = s1;
            break MISSING_BLOCK_LABEL_60;
            Throwable throwable;
            throwable;
            Log.w("SipManager", (new StringBuilder()).append("getUri(): ").append(throwable).toString());
            s = null;
            return s;
        }

        public void onRegistering(ISipSession isipsession) {
            mListener.onRegistering(getUri(isipsession));
        }

        public void onRegistrationDone(ISipSession isipsession, int i) {
            long l = i;
            if(i > 0)
                l += System.currentTimeMillis();
            mListener.onRegistrationDone(getUri(isipsession), l);
        }

        public void onRegistrationFailed(ISipSession isipsession, int i, String s) {
            mListener.onRegistrationFailed(getUri(isipsession), i, s);
        }

        public void onRegistrationTimeout(ISipSession isipsession) {
            mListener.onRegistrationFailed(getUri(isipsession), -5, "registration timed out");
        }

        private SipRegistrationListener mListener;
        private String mUri;

        public ListenerRelay(SipRegistrationListener sipregistrationlistener, String s) {
            mListener = sipregistrationlistener;
            mUri = s;
        }
    }


    private SipManager(Context context) {
        mContext = context;
        createSipService();
    }

    public static Intent createIncomingCallBroadcast(String s, String s1) {
        Intent intent = new Intent();
        intent.putExtra("android:sipCallID", s);
        intent.putExtra("android:sipOfferSD", s1);
        return intent;
    }

    private static ISipSessionListener createRelay(SipRegistrationListener sipregistrationlistener, String s) {
        Object obj;
        if(sipregistrationlistener == null)
            obj = null;
        else
            obj = new ListenerRelay(sipregistrationlistener, s);
        return ((ISipSessionListener) (obj));
    }

    private void createSipService() {
        mSipService = ISipService.Stub.asInterface(ServiceManager.getService("sip"));
    }

    public static String getCallId(Intent intent) {
        return intent.getStringExtra("android:sipCallID");
    }

    public static String getOfferSessionDescription(Intent intent) {
        return intent.getStringExtra("android:sipOfferSD");
    }

    public static boolean isApiSupported(Context context) {
        return context.getPackageManager().hasSystemFeature("android.software.sip");
    }

    public static boolean isIncomingCallIntent(Intent intent) {
        boolean flag = false;
        if(intent != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        String s = getCallId(intent);
        String s1 = getOfferSessionDescription(intent);
        if(s != null && s1 != null)
            flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static boolean isSipWifiOnly(Context context) {
        return context.getResources().getBoolean(0x111002b);
    }

    public static boolean isVoipSupported(Context context) {
        boolean flag;
        if(context.getPackageManager().hasSystemFeature("android.software.sip.voip") && isApiSupported(context))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static SipManager newInstance(Context context) {
        SipManager sipmanager;
        if(isApiSupported(context))
            sipmanager = new SipManager(context);
        else
            sipmanager = null;
        return sipmanager;
    }

    public void close(String s) throws SipException {
        try {
            mSipService.close(s);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new SipException("close()", remoteexception);
        }
    }

    public SipSession createSipSession(SipProfile sipprofile, SipSession.Listener listener) throws SipException {
        ISipSession isipsession;
        try {
            isipsession = mSipService.createSession(sipprofile, null);
            if(isipsession == null)
                throw new SipException("Failed to create SipSession; network unavailable?");
        }
        catch(RemoteException remoteexception) {
            throw new SipException("createSipSession()", remoteexception);
        }
        SipSession sipsession = new SipSession(isipsession, listener);
        return sipsession;
    }

    public SipProfile[] getListOfProfiles() {
        SipProfile asipprofile1[] = mSipService.getListOfProfiles();
        SipProfile asipprofile[] = asipprofile1;
_L2:
        return asipprofile;
        RemoteException remoteexception;
        remoteexception;
        asipprofile = new SipProfile[0];
        if(true) goto _L2; else goto _L1
_L1:
    }

    public SipSession getSessionFor(Intent intent) throws SipException {
        SipSession sipsession;
        try {
            String s = getCallId(intent);
            ISipSession isipsession = mSipService.getPendingSession(s);
            if(isipsession == null)
                sipsession = null;
            else
                sipsession = new SipSession(isipsession);
        }
        catch(RemoteException remoteexception) {
            throw new SipException("getSessionFor()", remoteexception);
        }
        return sipsession;
    }

    public boolean isOpened(String s) throws SipException {
        boolean flag;
        try {
            flag = mSipService.isOpened(s);
        }
        catch(RemoteException remoteexception) {
            throw new SipException("isOpened()", remoteexception);
        }
        return flag;
    }

    public boolean isRegistered(String s) throws SipException {
        boolean flag;
        try {
            flag = mSipService.isRegistered(s);
        }
        catch(RemoteException remoteexception) {
            throw new SipException("isRegistered()", remoteexception);
        }
        return flag;
    }

    public SipAudioCall makeAudioCall(SipProfile sipprofile, SipProfile sipprofile1, SipAudioCall.Listener listener, int i) throws SipException {
        if(!isVoipSupported(mContext)) {
            throw new SipException("VOIP API is not supported");
        } else {
            SipAudioCall sipaudiocall = new SipAudioCall(mContext, sipprofile);
            sipaudiocall.setListener(listener);
            sipaudiocall.makeCall(sipprofile1, createSipSession(sipprofile, null), i);
            return sipaudiocall;
        }
    }

    public SipAudioCall makeAudioCall(String s, String s1, SipAudioCall.Listener listener, int i) throws SipException {
        if(!isVoipSupported(mContext))
            throw new SipException("VOIP API is not supported");
        SipAudioCall sipaudiocall;
        try {
            sipaudiocall = makeAudioCall((new SipProfile.Builder(s)).build(), (new SipProfile.Builder(s1)).build(), listener, i);
        }
        catch(ParseException parseexception) {
            throw new SipException("build SipProfile", parseexception);
        }
        return sipaudiocall;
    }

    public void open(SipProfile sipprofile) throws SipException {
        try {
            mSipService.open(sipprofile);
            return;
        }
        catch(RemoteException remoteexception) {
            throw new SipException("open()", remoteexception);
        }
    }

    public void open(SipProfile sipprofile, PendingIntent pendingintent, SipRegistrationListener sipregistrationlistener) throws SipException {
        if(pendingintent == null)
            throw new NullPointerException("incomingCallPendingIntent cannot be null");
        try {
            mSipService.open3(sipprofile, pendingintent, createRelay(sipregistrationlistener, sipprofile.getUriString()));
            return;
        }
        catch(RemoteException remoteexception) {
            throw new SipException("open()", remoteexception);
        }
    }

    public void register(SipProfile sipprofile, int i, SipRegistrationListener sipregistrationlistener) throws SipException {
        ISipSession isipsession;
        try {
            isipsession = mSipService.createSession(sipprofile, createRelay(sipregistrationlistener, sipprofile.getUriString()));
            if(isipsession == null)
                throw new SipException("SipService.createSession() returns null");
        }
        catch(RemoteException remoteexception) {
            throw new SipException("register()", remoteexception);
        }
        isipsession.register(i);
        return;
    }

    public void setRegistrationListener(String s, SipRegistrationListener sipregistrationlistener) throws SipException {
        try {
            mSipService.setRegistrationListener(s, createRelay(sipregistrationlistener, s));
            return;
        }
        catch(RemoteException remoteexception) {
            throw new SipException("setRegistrationListener()", remoteexception);
        }
    }

    public SipAudioCall takeAudioCall(Intent intent, SipAudioCall.Listener listener) throws SipException {
        String s1;
        ISipSession isipsession;
        if(intent == null)
            throw new SipException("Cannot retrieve session with null intent");
        String s = getCallId(intent);
        if(s == null)
            throw new SipException("Call ID missing in incoming call intent");
        s1 = getOfferSessionDescription(intent);
        if(s1 == null)
            throw new SipException("Session description missing in incoming call intent");
        try {
            isipsession = mSipService.getPendingSession(s);
            if(isipsession == null)
                throw new SipException("No pending session for the call");
        }
        catch(Throwable throwable) {
            throw new SipException("takeAudioCall()", throwable);
        }
        SipAudioCall sipaudiocall;
        sipaudiocall = new SipAudioCall(mContext, isipsession.getLocalProfile());
        sipaudiocall.attachCall(new SipSession(isipsession), s1);
        sipaudiocall.setListener(listener);
        return sipaudiocall;
    }

    public void unregister(SipProfile sipprofile, SipRegistrationListener sipregistrationlistener) throws SipException {
        ISipSession isipsession;
        try {
            isipsession = mSipService.createSession(sipprofile, createRelay(sipregistrationlistener, sipprofile.getUriString()));
            if(isipsession == null)
                throw new SipException("SipService.createSession() returns null");
        }
        catch(RemoteException remoteexception) {
            throw new SipException("unregister()", remoteexception);
        }
        isipsession.unregister();
        return;
    }

    public static final String ACTION_SIP_ADD_PHONE = "com.android.phone.SIP_ADD_PHONE";
    public static final String ACTION_SIP_INCOMING_CALL = "com.android.phone.SIP_INCOMING_CALL";
    public static final String ACTION_SIP_REMOVE_PHONE = "com.android.phone.SIP_REMOVE_PHONE";
    public static final String ACTION_SIP_SERVICE_UP = "android.net.sip.SIP_SERVICE_UP";
    public static final String EXTRA_CALL_ID = "android:sipCallID";
    public static final String EXTRA_LOCAL_URI = "android:localSipUri";
    public static final String EXTRA_OFFER_SD = "android:sipOfferSD";
    public static final int INCOMING_CALL_RESULT_CODE = 101;
    private static final String TAG = "SipManager";
    private Context mContext;
    private ISipService mSipService;
}
