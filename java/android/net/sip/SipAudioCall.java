// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.sip;

import android.content.Context;
import android.media.AudioManager;
import android.net.rtp.*;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

// Referenced classes of package android.net.sip:
//            SipSession, SimpleSessionDescription, SipErrorCode, SipException, 
//            SipManager, SipProfile

public class SipAudioCall {
    public static class Listener {

        public void onCallBusy(SipAudioCall sipaudiocall) {
            onChanged(sipaudiocall);
        }

        public void onCallEnded(SipAudioCall sipaudiocall) {
            onChanged(sipaudiocall);
        }

        public void onCallEstablished(SipAudioCall sipaudiocall) {
            onChanged(sipaudiocall);
        }

        public void onCallHeld(SipAudioCall sipaudiocall) {
            onChanged(sipaudiocall);
        }

        public void onCalling(SipAudioCall sipaudiocall) {
            onChanged(sipaudiocall);
        }

        public void onChanged(SipAudioCall sipaudiocall) {
        }

        public void onError(SipAudioCall sipaudiocall, int i, String s) {
        }

        public void onReadyToCall(SipAudioCall sipaudiocall) {
            onChanged(sipaudiocall);
        }

        public void onRinging(SipAudioCall sipaudiocall, SipProfile sipprofile) {
            onChanged(sipaudiocall);
        }

        public void onRingingBack(SipAudioCall sipaudiocall) {
            onChanged(sipaudiocall);
        }

        public Listener() {
        }
    }


    public SipAudioCall(Context context, SipProfile sipprofile) {
        mSessionId = System.currentTimeMillis();
        mInCall = false;
        mMuted = false;
        mHold = false;
        mErrorCode = 0;
        mContext = context;
        mLocalProfile = sipprofile;
        mWm = (WifiManager)context.getSystemService("wifi");
    }

    /**
     * @deprecated Method close is deprecated
     */

    private void close(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(!flag)
            break MISSING_BLOCK_LABEL_11;
        stopCall(true);
        mInCall = false;
        mHold = false;
        mSessionId = System.currentTimeMillis();
        mErrorCode = 0;
        mErrorMessage = null;
        if(mSipSession != null) {
            mSipSession.setListener(null);
            mSipSession = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private SimpleSessionDescription createAnswer(String s) {
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        SimpleSessionDescription simplesessiondescription1 = createOffer();
_L8:
        return simplesessiondescription1;
_L2:
        SimpleSessionDescription simplesessiondescription;
        AudioCodec audiocodec;
        SimpleSessionDescription.Media amedia[];
        int i;
        int j;
        simplesessiondescription = new SimpleSessionDescription(s);
        simplesessiondescription1 = new SimpleSessionDescription(mSessionId, getLocalIp());
        audiocodec = null;
        amedia = simplesessiondescription.getMedia();
        i = amedia.length;
        j = 0;
_L4:
        SimpleSessionDescription.Media media;
        if(j >= i)
            continue; /* Loop/switch isn't completed */
        media = amedia[j];
        if(audiocodec != null || media.getPort() <= 0 || !"audio".equals(media.getType()) || !"RTP/AVP".equals(media.getProtocol()))
            break; /* Loop/switch isn't completed */
        int ai[] = media.getRtpPayloadTypes();
        int i1 = ai.length;
        int j1 = 0;
label0:
        do {
label1:
            {
                if(j1 < i1) {
                    int j2 = ai[j1];
                    audiocodec = AudioCodec.getCodec(j2, media.getRtpmap(j2), media.getFmtp(j2));
                    if(audiocodec == null)
                        break label1;
                }
                if(audiocodec == null)
                    break; /* Loop/switch isn't completed */
                SimpleSessionDescription.Media media2 = simplesessiondescription1.newMedia("audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
                media2.setRtpPayload(audiocodec.type, audiocodec.rtpmap, audiocodec.fmtp);
                int ai1[] = media.getRtpPayloadTypes();
                int k1 = ai1.length;
                for(int l1 = 0; l1 < k1; l1++) {
                    int i2 = ai1[l1];
                    String s1 = media.getRtpmap(i2);
                    if(i2 != audiocodec.type && s1 != null && s1.startsWith("telephone-event"))
                        media2.setRtpPayload(i2, s1, media.getFmtp(i2));
                }

                break label0;
            }
            j1++;
        } while(true);
        if(media.getAttribute("recvonly") != null)
            simplesessiondescription1.setAttribute("sendonly", "");
        else
        if(media.getAttribute("sendonly") != null)
            simplesessiondescription1.setAttribute("recvonly", "");
        else
        if(simplesessiondescription.getAttribute("recvonly") != null)
            simplesessiondescription1.setAttribute("sendonly", "");
        else
        if(simplesessiondescription.getAttribute("sendonly") != null)
            simplesessiondescription1.setAttribute("recvonly", "");
_L5:
        j++;
        if(true) goto _L4; else goto _L3
_L3:
        SimpleSessionDescription.Media media1 = simplesessiondescription1.newMedia(media.getType(), 0, 1, media.getProtocol());
        String as[] = media.getFormats();
        int k = as.length;
        int l = 0;
        while(l < k)  {
            media1.setFormat(as[l], null);
            l++;
        }
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
        if(audiocodec != null) goto _L8; else goto _L7
_L7:
        throw new IllegalStateException("Reject SDP: no suitable codecs");
    }

    private SimpleSessionDescription createContinueOffer() {
        SimpleSessionDescription simplesessiondescription = new SimpleSessionDescription(mSessionId, getLocalIp());
        SimpleSessionDescription.Media media = simplesessiondescription.newMedia("audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
        AudioCodec audiocodec = mAudioStream.getCodec();
        media.setRtpPayload(audiocodec.type, audiocodec.rtpmap, audiocodec.fmtp);
        int i = mAudioStream.getDtmfType();
        if(i != -1)
            media.setRtpPayload(i, "telephone-event/8000", "0-15");
        return simplesessiondescription;
    }

    private SimpleSessionDescription createHoldOffer() {
        SimpleSessionDescription simplesessiondescription = createContinueOffer();
        simplesessiondescription.setAttribute("sendonly", "");
        return simplesessiondescription;
    }

    private SipSession.Listener createListener() {
        return new SipSession.Listener() {

            public void onCallBusy(SipSession sipsession) {
                Log.d(SipAudioCall.TAG, (new StringBuilder()).append("sip call busy: ").append(sipsession).toString());
                Listener listener = mListener;
                if(listener != null)
                    try {
                        listener.onCallBusy(SipAudioCall.this);
                    }
                    catch(Throwable throwable) {
                        Log.i(SipAudioCall.TAG, (new StringBuilder()).append("onCallBusy(): ").append(throwable).toString());
                    }
                close(false);
            }

            public void onCallChangeFailed(SipSession sipsession, int i, String s) {
                Listener listener;
                Log.d(SipAudioCall.TAG, (new StringBuilder()).append("sip call change failed: ").append(s).toString());
                mErrorCode = i;
                mErrorMessage = s;
                listener = mListener;
                if(listener == null)
                    break MISSING_BLOCK_LABEL_75;
                listener.onError(SipAudioCall.this, mErrorCode, s);
_L1:
                return;
                Throwable throwable;
                throwable;
                Log.i(SipAudioCall.TAG, (new StringBuilder()).append("onCallBusy(): ").append(throwable).toString());
                  goto _L1
            }

            public void onCallEnded(SipSession sipsession) {
                Log.d(SipAudioCall.TAG, (new StringBuilder()).append("sip call ended: ").append(sipsession).append(" mSipSession:").append(mSipSession).toString());
                if(sipsession != mTransferringSession) goto _L2; else goto _L1
_L1:
                mTransferringSession = null;
_L4:
                return;
_L2:
                if(mTransferringSession == null && sipsession == mSipSession) {
                    Listener listener = mListener;
                    if(listener != null)
                        try {
                            listener.onCallEnded(SipAudioCall.this);
                        }
                        catch(Throwable throwable) {
                            Log.i(SipAudioCall.TAG, (new StringBuilder()).append("onCallEnded(): ").append(throwable).toString());
                        }
                    close();
                }
                if(true) goto _L4; else goto _L3
_L3:
            }

            public void onCallEstablished(SipSession sipsession, String s) {
                mPeerSd = s;
                Log.v(SipAudioCall.TAG, (new StringBuilder()).append("onCallEstablished()").append(mPeerSd).toString());
                if(mTransferringSession == null || sipsession != mTransferringSession) goto _L2; else goto _L1
_L1:
                transferToNewSession();
_L4:
                return;
_L2:
                Listener listener;
                listener = mListener;
                if(listener == null)
                    continue; /* Loop/switch isn't completed */
                Throwable throwable;
                if(mHold) {
                    listener.onCallHeld(SipAudioCall.this);
                    continue; /* Loop/switch isn't completed */
                }
                try {
                    listener.onCallEstablished(SipAudioCall.this);
                }
                // Misplaced declaration of an exception variable
                catch(Throwable throwable) {
                    Log.i(SipAudioCall.TAG, (new StringBuilder()).append("onCallEstablished(): ").append(throwable).toString());
                }
                if(true) goto _L4; else goto _L3
_L3:
            }

            public void onCallTransferring(SipSession sipsession, String s) {
                Log.v(SipAudioCall.TAG, (new StringBuilder()).append("onCallTransferring mSipSession:").append(mSipSession).append(" newSession:").append(sipsession).toString());
                mTransferringSession = sipsession;
                if(s != null)
                    break MISSING_BLOCK_LABEL_77;
                sipsession.makeCall(sipsession.getPeerProfile(), createOffer().encode(), 15);
                break MISSING_BLOCK_LABEL_113;
                sipsession.answerCall(createAnswer(s).encode(), 5);
                break MISSING_BLOCK_LABEL_113;
                Throwable throwable;
                throwable;
                Log.e(SipAudioCall.TAG, "onCallTransferring()", throwable);
                sipsession.endCall();
            }

            public void onCalling(SipSession sipsession) {
                Listener listener;
                Log.d(SipAudioCall.TAG, (new StringBuilder()).append("calling... ").append(sipsession).toString());
                listener = mListener;
                if(listener == null)
                    break MISSING_BLOCK_LABEL_46;
                listener.onCalling(SipAudioCall.this);
_L1:
                return;
                Throwable throwable;
                throwable;
                Log.i(SipAudioCall.TAG, (new StringBuilder()).append("onCalling(): ").append(throwable).toString());
                  goto _L1
            }

            public void onError(SipSession sipsession, int i, String s) {
                SipAudioCall.this.onError(i, s);
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
                SipAudioCall sipaudiocall = SipAudioCall.this;
                sipaudiocall;
                JVM INSTR monitorenter ;
                if(mSipSession != null && mInCall && sipsession.getCallId().equals(mSipSession.getCallId())) goto _L2; else goto _L1
_L1:
                sipsession.endCall();
_L3:
                return;
_L2:
                String s1 = createAnswer(s).encode();
                mSipSession.answerCall(s1, 5);
_L4:
                sipaudiocall;
                JVM INSTR monitorexit ;
                  goto _L3
                Exception exception;
                exception;
                throw exception;
                Throwable throwable;
                throwable;
                Log.e(SipAudioCall.TAG, "onRinging()", throwable);
                sipsession.endCall();
                  goto _L4
            }

            public void onRingingBack(SipSession sipsession) {
                Listener listener;
                Log.d(SipAudioCall.TAG, (new StringBuilder()).append("sip call ringing back: ").append(sipsession).toString());
                listener = mListener;
                if(listener == null)
                    break MISSING_BLOCK_LABEL_46;
                listener.onRingingBack(SipAudioCall.this);
_L1:
                return;
                Throwable throwable;
                throwable;
                Log.i(SipAudioCall.TAG, (new StringBuilder()).append("onRingingBack(): ").append(throwable).toString());
                  goto _L1
            }

            final SipAudioCall this$0;

             {
                this$0 = SipAudioCall.this;
                super();
            }
        };
    }

    private SimpleSessionDescription createOffer() {
        SimpleSessionDescription simplesessiondescription = new SimpleSessionDescription(mSessionId, getLocalIp());
        AudioCodec.getCodecs();
        SimpleSessionDescription.Media media = simplesessiondescription.newMedia("audio", mAudioStream.getLocalPort(), 1, "RTP/AVP");
        AudioCodec aaudiocodec[] = AudioCodec.getCodecs();
        int i = aaudiocodec.length;
        for(int j = 0; j < i; j++) {
            AudioCodec audiocodec = aaudiocodec[j];
            media.setRtpPayload(audiocodec.type, audiocodec.rtpmap, audiocodec.fmtp);
        }

        media.setRtpPayload(127, "telephone-event/8000", "0-15");
        return simplesessiondescription;
    }

    private String getLocalIp() {
        return mSipSession.getLocalIp();
    }

    private SipProfile getPeerProfile(SipSession sipsession) {
        return sipsession.getPeerProfile();
    }

    private void grabWifiHighPerfLock() {
        if(mWifiHighPerfLock == null) {
            Log.v(TAG, "acquire wifi high perf lock");
            mWifiHighPerfLock = ((WifiManager)mContext.getSystemService("wifi")).createWifiLock(3, TAG);
            mWifiHighPerfLock.acquire();
        }
    }

    private boolean isSpeakerOn() {
        return ((AudioManager)mContext.getSystemService("audio")).isSpeakerphoneOn();
    }

    private boolean isWifiOn() {
        boolean flag;
        if(mWm.getConnectionInfo().getBSSID() == null)
            flag = false;
        else
            flag = true;
        return flag;
    }

    private void onError(int i, String s) {
        Log.d(TAG, (new StringBuilder()).append("sip session error: ").append(SipErrorCode.toString(i)).append(": ").append(s).toString());
        mErrorCode = i;
        mErrorMessage = s;
        Listener listener = mListener;
        if(listener != null)
            try {
                listener.onError(this, i, s);
            }
            catch(Throwable throwable) {
                Log.i(TAG, (new StringBuilder()).append("onError(): ").append(throwable).toString());
            }
        this;
        JVM INSTR monitorenter ;
        if(i == -10)
            break MISSING_BLOCK_LABEL_84;
        if(isInCall())
            break MISSING_BLOCK_LABEL_89;
        close(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void releaseWifiHighPerfLock() {
        if(mWifiHighPerfLock != null) {
            Log.v(TAG, "release wifi high perf lock");
            mWifiHighPerfLock.release();
            mWifiHighPerfLock = null;
        }
    }

    private void setAudioGroupMode() {
        AudioGroup audiogroup = getAudioGroup();
        if(audiogroup != null)
            if(mHold)
                audiogroup.setMode(0);
            else
            if(mMuted)
                audiogroup.setMode(1);
            else
            if(isSpeakerOn())
                audiogroup.setMode(3);
            else
                audiogroup.setMode(2);
    }

    /**
     * @deprecated Method startAudioInternal is deprecated
     */

    private void startAudioInternal() throws UnknownHostException {
        this;
        JVM INSTR monitorenter ;
        if(mPeerSd == null) {
            Log.v(TAG, "startAudioInternal() mPeerSd = null");
            throw new IllegalStateException("mPeerSd = null");
        }
        break MISSING_BLOCK_LABEL_35;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        SimpleSessionDescription simplesessiondescription;
        AudioStream audiostream;
        AudioCodec audiocodec;
        SimpleSessionDescription.Media amedia[];
        int i;
        int j;
        stopCall(false);
        mInCall = true;
        simplesessiondescription = new SimpleSessionDescription(mPeerSd);
        audiostream = mAudioStream;
        audiocodec = null;
        amedia = simplesessiondescription.getMedia();
        i = amedia.length;
        j = 0;
_L13:
        if(j >= i) goto _L2; else goto _L1
_L1:
        SimpleSessionDescription.Media media;
        int ai[];
        int k;
        int l;
        media = amedia[j];
        if(audiocodec != null || media.getPort() <= 0 || !"audio".equals(media.getType()) || !"RTP/AVP".equals(media.getProtocol()))
            break MISSING_BLOCK_LABEL_482;
        ai = media.getRtpPayloadTypes();
        k = ai.length;
        l = 0;
_L12:
        if(l >= k) goto _L4; else goto _L3
_L3:
        int l1 = ai[l];
        audiocodec = AudioCodec.getCodec(l1, media.getRtpmap(l1), media.getFmtp(l1));
        if(audiocodec == null) goto _L5; else goto _L4
_L4:
        int ai1[];
        int i1;
        int j1;
        if(audiocodec == null)
            break MISSING_BLOCK_LABEL_482;
        String s = media.getAddress();
        if(s == null)
            s = simplesessiondescription.getAddress();
        audiostream.associate(InetAddress.getByName(s), media.getPort());
        audiostream.setDtmfType(-1);
        audiostream.setCodec(audiocodec);
        ai1 = media.getRtpPayloadTypes();
        i1 = ai1.length;
        j1 = 0;
_L11:
        if(j1 >= i1) goto _L7; else goto _L6
_L6:
        int k1 = ai1[j1];
        String s1 = media.getRtpmap(k1);
        if(k1 != audiocodec.type && s1 != null && s1.startsWith("telephone-event"))
            audiostream.setDtmfType(k1);
          goto _L8
_L7:
        if(mHold)
            audiostream.setMode(0);
        else
        if(media.getAttribute("recvonly") != null)
            audiostream.setMode(1);
        else
        if(media.getAttribute("sendonly") != null)
            audiostream.setMode(2);
        else
        if(simplesessiondescription.getAttribute("recvonly") != null)
            audiostream.setMode(1);
        else
        if(simplesessiondescription.getAttribute("sendonly") != null)
            audiostream.setMode(2);
        else
            audiostream.setMode(0);
_L2:
        AudioGroup audiogroup;
        if(audiocodec == null)
            throw new IllegalStateException("Reject SDP: no suitable codecs");
        if(isWifiOn())
            grabWifiHighPerfLock();
        audiogroup = getAudioGroup();
        if(!mHold) goto _L10; else goto _L9
_L9:
        setAudioGroupMode();
        this;
        JVM INSTR monitorexit ;
        return;
_L10:
        if(audiogroup != null)
            break MISSING_BLOCK_LABEL_461;
        audiogroup = new AudioGroup();
        audiostream.join(audiogroup);
          goto _L9
_L8:
        j1++;
          goto _L11
_L5:
        l++;
          goto _L12
        j++;
          goto _L13
    }

    private void stopCall(boolean flag) {
        Log.d(TAG, "stop audiocall");
        releaseWifiHighPerfLock();
        if(mAudioStream != null) {
            mAudioStream.join(null);
            if(flag) {
                mAudioStream.release();
                mAudioStream = null;
            }
        }
    }

    private void throwSipException(Throwable throwable) throws SipException {
        if(throwable instanceof SipException)
            throw (SipException)throwable;
        else
            throw new SipException("", throwable);
    }

    /**
     * @deprecated Method transferToNewSession is deprecated
     */

    private void transferToNewSession() {
        this;
        JVM INSTR monitorenter ;
        SipSession sipsession = mTransferringSession;
        if(sipsession != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        SipSession sipsession1;
        sipsession1 = mSipSession;
        mSipSession = mTransferringSession;
        mTransferringSession = null;
        if(mAudioStream == null)
            break; /* Loop/switch isn't completed */
        mAudioStream.join(null);
_L4:
        if(sipsession1 != null)
            sipsession1.endCall();
        startAudio();
        if(true) goto _L1; else goto _L3
        Exception exception;
        exception;
        throw exception;
_L3:
        mAudioStream = new AudioStream(InetAddress.getByName(getLocalIp()));
          goto _L4
        Throwable throwable;
        throwable;
        Log.i(TAG, (new StringBuilder()).append("transferToNewSession(): ").append(throwable).toString());
          goto _L4
    }

    public void answerCall(int i) throws SipException {
        this;
        JVM INSTR monitorenter ;
        if(mSipSession == null)
            throw new SipException("No call to answer");
        break MISSING_BLOCK_LABEL_25;
        Exception exception;
        exception;
        throw exception;
        try {
            mAudioStream = new AudioStream(InetAddress.getByName(getLocalIp()));
            mSipSession.answerCall(createAnswer(mPeerSd).encode(), i);
        }
        catch(IOException ioexception) {
            throw new SipException("answerCall()", ioexception);
        }
        this;
        JVM INSTR monitorexit ;
    }

    public void attachCall(SipSession sipsession, String s) throws SipException {
        if(!SipManager.isVoipSupported(mContext))
            throw new SipException("VOIP API is not supported");
        this;
        JVM INSTR monitorenter ;
        mSipSession = sipsession;
        mPeerSd = s;
        Log.v(TAG, (new StringBuilder()).append("attachCall()").append(mPeerSd).toString());
        try {
            sipsession.setListener(createListener());
        }
        catch(Throwable throwable) {
            Log.e(TAG, "attachCall()", throwable);
            throwSipException(throwable);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void close() {
        close(true);
    }

    public void continueCall(int i) throws SipException {
        this;
        JVM INSTR monitorenter ;
        if(mHold) {
            mSipSession.changeCall(createContinueOffer().encode(), i);
            mHold = false;
            setAudioGroupMode();
        }
        return;
    }

    public void endCall() throws SipException {
        this;
        JVM INSTR monitorenter ;
        stopCall(true);
        mInCall = false;
        if(mSipSession != null)
            mSipSession.endCall();
        return;
    }

    public AudioGroup getAudioGroup() {
        this;
        JVM INSTR monitorenter ;
        if(mAudioGroup == null) goto _L2; else goto _L1
_L1:
        AudioGroup audiogroup1 = mAudioGroup;
          goto _L3
_L2:
        if(mAudioStream != null) goto _L5; else goto _L4
_L4:
        audiogroup1 = null;
_L6:
        this;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
_L5:
        AudioGroup audiogroup = mAudioStream.getGroup();
        audiogroup1 = audiogroup;
        if(true) goto _L6; else goto _L3
_L3:
        return audiogroup1;
    }

    public AudioStream getAudioStream() {
        this;
        JVM INSTR monitorenter ;
        AudioStream audiostream = mAudioStream;
        return audiostream;
    }

    public SipProfile getLocalProfile() {
        this;
        JVM INSTR monitorenter ;
        SipProfile sipprofile = mLocalProfile;
        return sipprofile;
    }

    public SipProfile getPeerProfile() {
        this;
        JVM INSTR monitorenter ;
        SipProfile sipprofile;
        if(mSipSession == null)
            sipprofile = null;
        else
            sipprofile = mSipSession.getPeerProfile();
        return sipprofile;
    }

    public SipSession getSipSession() {
        this;
        JVM INSTR monitorenter ;
        SipSession sipsession = mSipSession;
        return sipsession;
    }

    public int getState() {
        this;
        JVM INSTR monitorenter ;
        int i;
        if(mSipSession == null)
            i = 0;
        else
            i = mSipSession.getState();
        return i;
    }

    public void holdCall(int i) throws SipException {
        this;
        JVM INSTR monitorenter ;
        if(!mHold) {
            if(mSipSession == null)
                throw new SipException("Not in a call to hold call");
            break MISSING_BLOCK_LABEL_37;
        }
          goto _L1
        Exception exception;
        exception;
        throw exception;
        mSipSession.changeCall(createHoldOffer().encode(), i);
        mHold = true;
        setAudioGroupMode();
        this;
        JVM INSTR monitorexit ;
_L1:
    }

    public boolean isInCall() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mInCall;
        return flag;
    }

    public boolean isMuted() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mMuted;
        return flag;
    }

    public boolean isOnHold() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mHold;
        return flag;
    }

    public void makeCall(SipProfile sipprofile, SipSession sipsession, int i) throws SipException {
        if(!SipManager.isVoipSupported(mContext))
            throw new SipException("VOIP API is not supported");
        this;
        JVM INSTR monitorenter ;
        mSipSession = sipsession;
        try {
            mAudioStream = new AudioStream(InetAddress.getByName(getLocalIp()));
            sipsession.setListener(createListener());
            sipsession.makeCall(sipprofile, createOffer().encode(), i);
        }
        catch(IOException ioexception) {
            throw new SipException("makeCall()", ioexception);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void sendDtmf(int i) {
        sendDtmf(i, null);
    }

    public void sendDtmf(int i, Message message) {
        this;
        JVM INSTR monitorenter ;
        AudioGroup audiogroup = getAudioGroup();
        if(audiogroup != null && mSipSession != null && 8 == getState()) {
            Log.v(TAG, (new StringBuilder()).append("send DTMF: ").append(i).toString());
            audiogroup.sendDtmf(i);
        }
        if(message != null)
            message.sendToTarget();
        return;
    }

    public void setAudioGroup(AudioGroup audiogroup) {
        this;
        JVM INSTR monitorenter ;
        if(mAudioStream != null && mAudioStream.getGroup() != null)
            mAudioStream.join(audiogroup);
        mAudioGroup = audiogroup;
        return;
    }

    public void setListener(Listener listener) {
        setListener(listener, false);
    }

    public void setListener(Listener listener, boolean flag) {
label0:
        {
            mListener = listener;
            if(listener != null && flag)
                try {
                    if(mErrorCode == 0)
                        break label0;
                    listener.onError(this, mErrorCode, mErrorMessage);
                }
                catch(Throwable throwable) {
                    Log.e(TAG, "setListener()", throwable);
                }
        }
_L1:
        return;
label1:
        {
            if(!mInCall)
                break label1;
            if(mHold)
                listener.onCallHeld(this);
            else
                listener.onCallEstablished(this);
        }
          goto _L1
        getState();
        JVM INSTR tableswitch 0 6: default 164
    //                   0 128
    //                   1 164
    //                   2 164
    //                   3 136
    //                   4 164
    //                   5 148
    //                   6 156;
           goto _L2 _L3 _L2 _L2 _L4 _L2 _L5 _L6
_L2:
        if(true) goto _L1; else goto _L7
_L7:
_L3:
        listener.onReadyToCall(this);
          goto _L1
_L4:
        listener.onRinging(this, getPeerProfile());
          goto _L1
_L5:
        listener.onCalling(this);
          goto _L1
_L6:
        listener.onRingingBack(this);
          goto _L1
    }

    public void setSpeakerMode(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        ((AudioManager)mContext.getSystemService("audio")).setSpeakerphoneOn(flag);
        setAudioGroupMode();
        return;
    }

    public void startAudio() {
        startAudioInternal();
_L1:
        return;
        UnknownHostException unknownhostexception;
        unknownhostexception;
        onError(-7, unknownhostexception.getMessage());
          goto _L1
        Throwable throwable;
        throwable;
        onError(-4, throwable.getMessage());
          goto _L1
    }

    public void toggleMute() {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if(!mMuted)
            flag = true;
        else
            flag = false;
        mMuted = flag;
        setAudioGroupMode();
        return;
    }

    private static final boolean DONT_RELEASE_SOCKET = false;
    private static final boolean RELEASE_SOCKET = true;
    private static final int SESSION_TIMEOUT = 5;
    private static final String TAG = android/net/sip/SipAudioCall.getSimpleName();
    private static final int TRANSFER_TIMEOUT = 15;
    private AudioGroup mAudioGroup;
    private AudioStream mAudioStream;
    private Context mContext;
    private int mErrorCode;
    private String mErrorMessage;
    private boolean mHold;
    private boolean mInCall;
    private Listener mListener;
    private SipProfile mLocalProfile;
    private boolean mMuted;
    private String mPeerSd;
    private SipProfile mPendingCallRequest;
    private long mSessionId;
    private SipSession mSipSession;
    private SipSession mTransferringSession;
    private android.net.wifi.WifiManager.WifiLock mWifiHighPerfLock;
    private WifiManager mWm;






/*
    static int access$1002(SipAudioCall sipaudiocall, int i) {
        sipaudiocall.mErrorCode = i;
        return i;
    }

*/


/*
    static String access$1102(SipAudioCall sipaudiocall, String s) {
        sipaudiocall.mErrorMessage = s;
        return s;
    }

*/








/*
    static String access$502(SipAudioCall sipaudiocall, String s) {
        sipaudiocall.mPeerSd = s;
        return s;
    }

*/



/*
    static SipSession access$602(SipAudioCall sipaudiocall, SipSession sipsession) {
        sipaudiocall.mTransferringSession = sipsession;
        return sipsession;
    }

*/



}
