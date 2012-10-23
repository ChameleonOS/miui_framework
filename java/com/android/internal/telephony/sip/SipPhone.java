// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.sip;

import android.content.Context;
import android.media.AudioManager;
import android.net.LinkProperties;
import android.net.rtp.AudioGroup;
import android.net.sip.*;
import android.os.*;
import android.telephony.*;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.*;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

// Referenced classes of package com.android.internal.telephony.sip:
//            SipPhoneBase, SipConnectionBase, SipCallBase

public class SipPhone extends SipPhoneBase {
    private abstract class SipAudioCallAdapter extends android.net.sip.SipAudioCall.Listener {

        public void onCallBusy(SipAudioCall sipaudiocall) {
            onCallEnded(com.android.internal.telephony.Connection.DisconnectCause.BUSY);
        }

        public void onCallEnded(SipAudioCall sipaudiocall) {
            com.android.internal.telephony.Connection.DisconnectCause disconnectcause;
            if(sipaudiocall.isInCall())
                disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.NORMAL;
            else
                disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.INCOMING_MISSED;
            onCallEnded(disconnectcause);
        }

        protected abstract void onCallEnded(com.android.internal.telephony.Connection.DisconnectCause disconnectcause);

        public void onError(SipAudioCall sipaudiocall, int i, String s) {
            i;
            JVM INSTR tableswitch -12 -2: default 60
        //                       -12 105
        //                       -11 165
        //                       -10 145
        //                       -9 60
        //                       -8 155
        //                       -7 115
        //                       -6 125
        //                       -5 135
        //                       -4 60
        //                       -3 135
        //                       -2 175;
               goto _L1 _L2 _L3 _L4 _L1 _L5 _L6 _L7 _L8 _L1 _L8 _L9
_L1:
            Log.w("SipPhone", (new StringBuilder()).append("error: ").append(SipErrorCode.toString(i)).append(": ").append(s).toString());
            onError(com.android.internal.telephony.Connection.DisconnectCause.ERROR_UNSPECIFIED);
_L11:
            return;
_L2:
            onError(com.android.internal.telephony.Connection.DisconnectCause.SERVER_UNREACHABLE);
            continue; /* Loop/switch isn't completed */
_L6:
            onError(com.android.internal.telephony.Connection.DisconnectCause.NUMBER_UNREACHABLE);
            continue; /* Loop/switch isn't completed */
_L7:
            onError(com.android.internal.telephony.Connection.DisconnectCause.INVALID_NUMBER);
            continue; /* Loop/switch isn't completed */
_L8:
            onError(com.android.internal.telephony.Connection.DisconnectCause.TIMED_OUT);
            continue; /* Loop/switch isn't completed */
_L4:
            onError(com.android.internal.telephony.Connection.DisconnectCause.LOST_SIGNAL);
            continue; /* Loop/switch isn't completed */
_L5:
            onError(com.android.internal.telephony.Connection.DisconnectCause.INVALID_CREDENTIALS);
            continue; /* Loop/switch isn't completed */
_L3:
            onError(com.android.internal.telephony.Connection.DisconnectCause.OUT_OF_NETWORK);
            continue; /* Loop/switch isn't completed */
_L9:
            onError(com.android.internal.telephony.Connection.DisconnectCause.SERVER_ERROR);
            if(true) goto _L11; else goto _L10
_L10:
        }

        protected abstract void onError(com.android.internal.telephony.Connection.DisconnectCause disconnectcause);

        final SipPhone this$0;

        private SipAudioCallAdapter() {
            this$0 = SipPhone.this;
            super();
        }

    }

    private class SipConnection extends SipConnectionBase {

        void acceptCall() throws CallStateException {
            try {
                mSipAudioCall.answerCall(8);
                return;
            }
            catch(SipException sipexception) {
                throw new CallStateException((new StringBuilder()).append("acceptCall(): ").append(sipexception).toString());
            }
        }

        void changeOwner(SipCall sipcall) {
            mOwner = sipcall;
        }

        void dial() throws SipException {
            setState(com.android.internal.telephony.Call.State.DIALING);
            mSipAudioCall = mSipManager.makeAudioCall(mProfile, mPeer, null, 15);
            mSipAudioCall.setListener(mAdapter);
        }

        public String getAddress() {
            return mOriginalNumber;
        }

        AudioGroup getAudioGroup() {
            AudioGroup audiogroup;
            if(mSipAudioCall == null)
                audiogroup = null;
            else
                audiogroup = mSipAudioCall.getAudioGroup();
            return audiogroup;
        }

        public volatile Call getCall() {
            return getCall();
        }

        public SipCall getCall() {
            return mOwner;
        }

        public String getCnapName() {
            String s = mPeer.getDisplayName();
            if(TextUtils.isEmpty(s))
                s = null;
            return s;
        }

        boolean getMute() {
            boolean flag;
            if(mSipAudioCall == null)
                flag = false;
            else
                flag = mSipAudioCall.isMuted();
            return flag;
        }

        public int getNumberPresentation() {
            return Connection.PRESENTATION_ALLOWED;
        }

        protected Phone getPhone() {
            return mOwner.getPhone();
        }

        public com.android.internal.telephony.Call.State getState() {
            return mState;
        }

        public void hangup() throws CallStateException {
            com/android/internal/telephony/sip/SipPhone;
            JVM INSTR monitorenter ;
            Log.d("SipPhone", (new StringBuilder()).append("hangup conn: ").append(mPeer.getUriString()).append(": ").append(mState).append(": on phone ").append(getPhone().getPhoneName()).toString());
            if(mState.isAlive()) goto _L2; else goto _L1
_L1:
            com/android/internal/telephony/sip/SipPhone;
            JVM INSTR monitorexit ;
_L3:
            return;
_L2:
            SipAudioCall sipaudiocall = mSipAudioCall;
            if(sipaudiocall != null) {
                sipaudiocall.setListener(null);
                sipaudiocall.endCall();
            }
            SipAudioCallAdapter sipaudiocalladapter1;
            com.android.internal.telephony.Connection.DisconnectCause disconnectcause1;
            sipaudiocalladapter1 = mAdapter;
            if(mState != com.android.internal.telephony.Call.State.INCOMING && mState != com.android.internal.telephony.Call.State.WAITING)
                break MISSING_BLOCK_LABEL_228;
            disconnectcause1 = com.android.internal.telephony.Connection.DisconnectCause.INCOMING_REJECTED;
_L4:
            sipaudiocalladapter1.onCallEnded(disconnectcause1);
              goto _L3
            Exception exception;
            exception;
            throw exception;
            SipException sipexception;
            sipexception;
            throw new CallStateException((new StringBuilder()).append("hangup(): ").append(sipexception).toString());
            Exception exception1;
            exception1;
            SipAudioCallAdapter sipaudiocalladapter = mAdapter;
            com.android.internal.telephony.Connection.DisconnectCause disconnectcause;
            if(mState == com.android.internal.telephony.Call.State.INCOMING || mState == com.android.internal.telephony.Call.State.WAITING)
                disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.INCOMING_REJECTED;
            else
                disconnectcause = com.android.internal.telephony.Connection.DisconnectCause.LOCAL;
            sipaudiocalladapter.onCallEnded(disconnectcause);
            throw exception1;
            disconnectcause1 = com.android.internal.telephony.Connection.DisconnectCause.LOCAL;
              goto _L4
        }

        void hold() throws CallStateException {
            setState(com.android.internal.telephony.Call.State.HOLDING);
            try {
                mSipAudioCall.holdCall(15);
                return;
            }
            catch(SipException sipexception) {
                throw new CallStateException((new StringBuilder()).append("hold(): ").append(sipexception).toString());
            }
        }

        void initIncomingCall(SipAudioCall sipaudiocall, com.android.internal.telephony.Call.State state) {
            setState(state);
            mSipAudioCall = sipaudiocall;
            sipaudiocall.setListener(mAdapter);
            mIncoming = true;
        }

        public boolean isIncoming() {
            return mIncoming;
        }

        public void separate() throws CallStateException {
            com/android/internal/telephony/sip/SipPhone;
            JVM INSTR monitorenter ;
            SipCall sipcall;
            if(getPhone() != SipPhone.this)
                break MISSING_BLOCK_LABEL_71;
            sipcall = (SipCall)getBackgroundCall();
_L1:
            if(sipcall.getState() != com.android.internal.telephony.Call.State.IDLE)
                throw new CallStateException((new StringBuilder()).append("cannot put conn back to a call in non-idle state: ").append(sipcall.getState()).toString());
            break MISSING_BLOCK_LABEL_85;
            Exception exception;
            exception;
            throw exception;
            sipcall = (SipCall)getForegroundCall();
              goto _L1
            Log.d("SipPhone", (new StringBuilder()).append("separate conn: ").append(mPeer.getUriString()).append(" from ").append(mOwner).append(" back to ").append(sipcall).toString());
            Phone phone = getPhone();
            AudioGroup audiogroup = sipcall.getAudioGroup();
            sipcall.add(this);
            mSipAudioCall.setAudioGroup(audiogroup);
            phone.switchHoldingAndActive();
            SipCall sipcall1 = (SipCall)getForegroundCall();
            mSipAudioCall.startAudio();
            sipcall1.onConnectionStateChanged(this);
            com/android/internal/telephony/sip/SipPhone;
            JVM INSTR monitorexit ;
        }

        void setMute(boolean flag) {
            if(mSipAudioCall != null && flag != mSipAudioCall.isMuted())
                mSipAudioCall.toggleMute();
        }

        protected void setState(com.android.internal.telephony.Call.State state) {
            if(state != mState) {
                super.setState(state);
                mState = state;
            }
        }

        void unhold(AudioGroup audiogroup) throws CallStateException {
            mSipAudioCall.setAudioGroup(audiogroup);
            setState(com.android.internal.telephony.Call.State.ACTIVE);
            try {
                mSipAudioCall.continueCall(15);
                return;
            }
            catch(SipException sipexception) {
                throw new CallStateException((new StringBuilder()).append("unhold(): ").append(sipexception).toString());
            }
        }

        private SipAudioCallAdapter mAdapter = new SipAudioCallAdapter() {

            protected void onCallEnded(com.android.internal.telephony.Connection.DisconnectCause disconnectcause) {
                if(getDisconnectCause() != com.android.internal.telephony.Connection.DisconnectCause.LOCAL)
                    setDisconnectCause(disconnectcause);
                com/android/internal/telephony/sip/SipPhone;
                JVM INSTR monitorenter ;
                setState(com.android.internal.telephony.Call.State.DISCONNECTED);
                SipAudioCall sipaudiocall = mSipAudioCall;
                mSipAudioCall = null;
                String s1;
                if(sipaudiocall == null)
                    s1 = "";
                else
                    s1 = (new StringBuilder()).append(sipaudiocall.getState()).append(", ").toString();
                Log.d("SipPhone", (new StringBuilder()).append("--- connection ended: ").append(mPeer.getUriString()).append(": ").append(s1).append("cause: ").append(getDisconnectCause()).append(", on phone ").append(getPhone()).toString());
                if(sipaudiocall != null) {
                    sipaudiocall.setListener(null);
                    sipaudiocall.close();
                }
                mOwner.onConnectionEnded(SipConnection.this);
                return;
            }

            public void onCallEstablished(SipAudioCall sipaudiocall) {
                onChanged(sipaudiocall);
                if(mState == com.android.internal.telephony.Call.State.ACTIVE)
                    sipaudiocall.startAudio();
            }

            public void onCallHeld(SipAudioCall sipaudiocall) {
                onChanged(sipaudiocall);
                if(mState == com.android.internal.telephony.Call.State.HOLDING)
                    sipaudiocall.startAudio();
            }

            public void onChanged(SipAudioCall sipaudiocall) {
                com/android/internal/telephony/sip/SipPhone;
                JVM INSTR monitorenter ;
                com.android.internal.telephony.Call.State state = SipPhone.getCallStateFrom(sipaudiocall);
                if(mState != state) goto _L2; else goto _L1
_L2:
                if(state != com.android.internal.telephony.Call.State.INCOMING) goto _L4; else goto _L3
_L3:
                setState(mOwner.getState());
_L5:
                mOwner.onConnectionStateChanged(SipConnection.this);
                Log.v("SipPhone", (new StringBuilder()).append("+***+ connection state changed: ").append(mPeer.getUriString()).append(": ").append(mState).append(" on phone ").append(getPhone()).toString());
                  goto _L1
                Exception exception;
                exception;
                throw exception;
_L4:
                com.android.internal.telephony.Call.State state1;
                com.android.internal.telephony.Call.State state2;
                if(mOwner != ringingCall)
                    break MISSING_BLOCK_LABEL_219;
                state1 = ringingCall.getState();
                state2 = com.android.internal.telephony.Call.State.WAITING;
                if(state1 != state2)
                    break MISSING_BLOCK_LABEL_196;
                switchHoldingAndActive();
                foregroundCall.switchWith(ringingCall);
                setState(state);
                  goto _L5
                CallStateException callstateexception;
                callstateexception;
                onCallEnded(com.android.internal.telephony.Connection.DisconnectCause.LOCAL);
                com/android/internal/telephony/sip/SipPhone;
                JVM INSTR monitorexit ;
_L1:
            }

            protected void onError(com.android.internal.telephony.Connection.DisconnectCause disconnectcause) {
                Log.d("SipPhone", (new StringBuilder()).append("SIP error: ").append(disconnectcause).toString());
                onCallEnded(disconnectcause);
            }

            final SipConnection this$1;

                 {
                    this$1 = SipConnection.this;
                    super();
                }
        };
        private boolean mIncoming;
        private String mOriginalNumber;
        private SipCall mOwner;
        private SipProfile mPeer;
        private SipAudioCall mSipAudioCall;
        private com.android.internal.telephony.Call.State mState;
        final SipPhone this$0;




/*
        static SipAudioCall access$702(SipConnection sipconnection, SipAudioCall sipaudiocall) {
            sipconnection.mSipAudioCall = sipaudiocall;
            return sipaudiocall;
        }

*/



        public SipConnection(SipCall sipcall, SipProfile sipprofile) {
            this(sipcall, sipprofile, getUriString(sipprofile));
        }

        public SipConnection(SipCall sipcall, SipProfile sipprofile, String s) {
            this$0 = SipPhone.this;
            super(s);
            mState = com.android.internal.telephony.Call.State.IDLE;
            mIncoming = false;
            mOwner = sipcall;
            mPeer = sipprofile;
            mOriginalNumber = s;
        }
    }

    private class SipCall extends SipCallBase {

        private void add(SipConnection sipconnection) {
            SipCall sipcall = sipconnection.getCall();
            if(sipcall != this) {
                if(sipcall != null)
                    ((SipCallBase) (sipcall)).connections.remove(sipconnection);
                super.connections.add(sipconnection);
                sipconnection.changeOwner(this);
            }
        }

        private int convertDtmf(char c) {
            int i = c + -48;
            if(i >= 0 && i <= 9) goto _L2; else goto _L1
_L1:
            c;
            JVM INSTR lookupswitch 6: default 76
        //                       35: 108
        //                       42: 103
        //                       65: 114
        //                       66: 120
        //                       67: 126
        //                       68: 132;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
            throw new IllegalArgumentException((new StringBuilder()).append("invalid DTMF char: ").append(c).toString());
_L5:
            i = 10;
_L2:
            return i;
_L4:
            i = 11;
            continue; /* Loop/switch isn't completed */
_L6:
            i = 12;
            continue; /* Loop/switch isn't completed */
_L7:
            i = 13;
            continue; /* Loop/switch isn't completed */
_L8:
            i = 14;
            continue; /* Loop/switch isn't completed */
_L9:
            i = 15;
            if(true) goto _L2; else goto _L10
_L10:
        }

        private AudioGroup getAudioGroup() {
            AudioGroup audiogroup;
            if(super.connections.isEmpty())
                audiogroup = null;
            else
                audiogroup = ((SipConnection)super.connections.get(0)).getAudioGroup();
            return audiogroup;
        }

        private boolean isSpeakerOn() {
            return ((AudioManager)
// JavaClassFileOutputException: get_constant: invalid tag

        private void takeOver(SipCall sipcall) {
            super.connections = ((SipCallBase) (sipcall)).connections;
            super.state = ((Call) (sipcall)).state;
            for(Iterator iterator = super.connections.iterator(); iterator.hasNext(); ((SipConnection)(Connection)iterator.next()).changeOwner(this));
        }

        void acceptCall() throws CallStateException {
            if(this != ringingCall)
                throw new CallStateException("acceptCall() in a non-ringing call");
            if(super.connections.size() != 1) {
                throw new CallStateException("acceptCall() in a conf call");
            } else {
                ((SipConnection)super.connections.get(0)).acceptCall();
                return;
            }
        }

        Connection dial(String s) throws SipException {
            String s1 = s;
            if(!s1.contains("@")) {
                String s2 = Pattern.quote((new StringBuilder()).append(mProfile.getUserName()).append("@").toString());
                s1 = mProfile.getUriString().replaceFirst(s2, (new StringBuilder()).append(s1).append("@").toString());
            }
            SipConnection sipconnection;
            try {
                SipProfile sipprofile = (new Builder(s1)).build();
                sipconnection = new SipConnection(this, sipprofile, s);
                sipconnection.dial();
                super.connections.add(sipconnection);
                setState(com.android.internal.telephony.Call.State.DIALING);
            }
            catch(ParseException parseexception) {
                throw new SipException("dial", parseexception);
            }
            return sipconnection;
        }

        public List getConnections() {
            com/android/internal/telephony/sip/SipPhone;
            JVM INSTR monitorenter ;
            List list = super.connections;
            return list;
        }

        boolean getMute() {
            boolean flag = false;
            if(!super.connections.isEmpty())
                flag = ((SipConnection)super.connections.get(0)).getMute();
            return flag;
        }

        public Phone getPhone() {
            return SipPhone.this;
        }

        public void hangup() throws CallStateException {
            com/android/internal/telephony/sip/SipPhone;
            JVM INSTR monitorenter ;
            CallStateException callstateexception;
            Iterator iterator;
            if(!super.state.isAlive())
                break MISSING_BLOCK_LABEL_136;
            Log.d("Call", (new StringBuilder()).append("hang up call: ").append(getState()).append(": ").append(this).append(" on phone ").append(getPhone()).toString());
            setState(com.android.internal.telephony.Call.State.DISCONNECTING);
            callstateexception = null;
            iterator = super.connections.iterator();
_L1:
            Connection connection;
            if(!iterator.hasNext())
                break MISSING_BLOCK_LABEL_122;
            connection = (Connection)iterator.next();
            try {
                connection.hangup();
            }
            catch(CallStateException callstateexception1) {
                callstateexception = callstateexception1;
            }
              goto _L1
            if(callstateexception != null)
                throw callstateexception;
            break MISSING_BLOCK_LABEL_185;
            Exception exception;
            exception;
            throw exception;
            Log.d("Call", (new StringBuilder()).append("hang up dead call: ").append(getState()).append(": ").append(this).append(" on phone ").append(getPhone()).toString());
            com/android/internal/telephony/sip/SipPhone;
            JVM INSTR monitorexit ;
        }

        void hold() throws CallStateException {
            setState(com.android.internal.telephony.Call.State.HOLDING);
            for(Iterator iterator = super.connections.iterator(); iterator.hasNext(); ((SipConnection)(Connection)iterator.next()).hold());
            setAudioGroupMode();
        }

        void initIncomingCall(SipAudioCall sipaudiocall, boolean flag) {
            SipProfile sipprofile = sipaudiocall.getPeerProfile();
            SipConnection sipconnection = new SipConnection(this, sipprofile);
            super.connections.add(sipconnection);
            com.android.internal.telephony.Call.State state;
            if(flag)
                state = com.android.internal.telephony.Call.State.WAITING;
            else
                state = com.android.internal.telephony.Call.State.INCOMING;
            sipconnection.initIncomingCall(sipaudiocall, state);
            setState(state);
            notifyNewRingingConnectionP(sipconnection);
        }

        void merge(SipCall sipcall) throws CallStateException {
            AudioGroup audiogroup = getAudioGroup();
            Connection aconnection[] = (Connection[])((SipCallBase) (sipcall)).connections.toArray(new Connection[((SipCallBase) (sipcall)).connections.size()]);
            int i = aconnection.length;
            for(int j = 0; j < i; j++) {
                SipConnection sipconnection = (SipConnection)aconnection[j];
                add(sipconnection);
                if(sipconnection.getState() == com.android.internal.telephony.Call.State.HOLDING)
                    sipconnection.unhold(audiogroup);
            }

            sipcall.setState(com.android.internal.telephony.Call.State.IDLE);
        }

        void onConnectionEnded(SipConnection sipconnection) {
            if(super.state != com.android.internal.telephony.Call.State.DISCONNECTED) {
                boolean flag = true;
                Log.d("Call", (new StringBuilder()).append("---check connections: ").append(super.connections.size()).toString());
                Iterator iterator = super.connections.iterator();
                do {
                    if(!iterator.hasNext())
                        break;
                    Connection connection = (Connection)iterator.next();
                    Log.d("Call", (new StringBuilder()).append("   state=").append(connection.getState()).append(": ").append(connection).toString());
                    if(connection.getState() == com.android.internal.telephony.Call.State.DISCONNECTED)
                        continue;
                    flag = false;
                    break;
                } while(true);
                if(flag)
                    setState(com.android.internal.telephony.Call.State.DISCONNECTED);
            }
            notifyDisconnectP(sipconnection);
        }

        void onConnectionStateChanged(SipConnection sipconnection) {
            if(super.state != com.android.internal.telephony.Call.State.ACTIVE)
                setState(sipconnection.getState());
        }

        void rejectCall() throws CallStateException {
            hangup();
        }

        void reset() {
            super.connections.clear();
            setState(com.android.internal.telephony.Call.State.IDLE);
        }

        void sendDtmf(char c) {
            AudioGroup audiogroup = getAudioGroup();
            if(audiogroup != null)
                audiogroup.sendDtmf(convertDtmf(c));
        }

        void setAudioGroupMode() {
            AudioGroup audiogroup = getAudioGroup();
            if(audiogroup != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            int i;
            i = audiogroup.getMode();
            if(super.state != com.android.internal.telephony.Call.State.HOLDING)
                break; /* Loop/switch isn't completed */
            audiogroup.setMode(0);
_L4:
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(i);
            aobj[1] = Integer.valueOf(audiogroup.getMode());
            Log.d("Call", String.format("audioGroup mode change: %d --> %d", aobj));
            if(true) goto _L1; else goto _L3
_L3:
            if(getMute())
                audiogroup.setMode(1);
            else
            if(isSpeakerOn())
                audiogroup.setMode(3);
            else
                audiogroup.setMode(2);
              goto _L4
            if(true) goto _L1; else goto _L5
_L5:
        }

        void setMute(boolean flag) {
            for(Iterator iterator = super.connections.iterator(); iterator.hasNext(); ((SipConnection)(Connection)iterator.next()).setMute(flag));
        }

        protected void setState(com.android.internal.telephony.Call.State state) {
            if(super.state == state) goto _L2; else goto _L1
_L1:
            Log.v("Call", (new StringBuilder()).append("+***+ call state changed: ").append(super.state).append(" --> ").append(state).append(": ").append(this).append(": on phone ").append(getPhone()).append(" ").append(super.connections.size()).toString());
            if(state != com.android.internal.telephony.Call.State.ALERTING) goto _L4; else goto _L3
_L3:
            super.state = state;
            startRingbackTone();
_L6:
            super.state = state;
            updatePhoneState();
            notifyPreciseCallStateChanged();
_L2:
            return;
_L4:
            if(super.state == com.android.internal.telephony.Call.State.ALERTING)
                stopRingbackTone();
            if(true) goto _L6; else goto _L5
_L5:
        }

        void switchWith(SipCall sipcall) {
            com/android/internal/telephony/sip/SipPhone;
            JVM INSTR monitorenter ;
            SipCall sipcall1 = new SipCall();
            sipcall1.takeOver(this);
            takeOver(sipcall);
            sipcall.takeOver(sipcall1);
            return;
        }

        void unhold() throws CallStateException {
            setState(com.android.internal.telephony.Call.State.ACTIVE);
            AudioGroup audiogroup = new AudioGroup();
            for(Iterator iterator = super.connections.iterator(); iterator.hasNext(); ((SipConnection)(Connection)iterator.next()).unhold(audiogroup));
            setAudioGroupMode();
        }

        final SipPhone this$0;



        private SipCall() {
            this$0 = SipPhone.this;
            super();
        }

    }


    SipPhone(Context context, PhoneNotifier phonenotifier, SipProfile sipprofile) {
        super(context, phonenotifier);
        ringingCall = new SipCall();
        foregroundCall = new SipCall();
        backgroundCall = new SipCall();
        Log.d("SipPhone", (new StringBuilder()).append("new SipPhone: ").append(sipprofile.getUriString()).toString());
        ringingCall = new SipCall();
        foregroundCall = new SipCall();
        backgroundCall = new SipCall();
        mProfile = sipprofile;
        mSipManager = SipManager.newInstance(context);
    }

    private Connection dialInternal(String s) throws CallStateException {
        clearDisconnected();
        if(!canDial())
            throw new CallStateException("cannot dial in current state");
        if(foregroundCall.getState() == com.android.internal.telephony.Call.State.ACTIVE)
            switchHoldingAndActive();
        if(foregroundCall.getState() != com.android.internal.telephony.Call.State.IDLE)
            throw new CallStateException("cannot dial in current state");
        foregroundCall.setMute(false);
        Connection connection;
        try {
            connection = foregroundCall.dial(s);
        }
        catch(SipException sipexception) {
            Log.e("SipPhone", "dial()", sipexception);
            throw new CallStateException((new StringBuilder()).append("dial error: ").append(sipexception).toString());
        }
        return connection;
    }

    private static com.android.internal.telephony.Call.State getCallStateFrom(SipAudioCall sipaudiocall) {
        if(!sipaudiocall.isOnHold()) goto _L2; else goto _L1
_L1:
        com.android.internal.telephony.Call.State state = com.android.internal.telephony.Call.State.HOLDING;
_L4:
        return state;
_L2:
        int i = sipaudiocall.getState();
        switch(i) {
        case 1: // '\001'
        case 2: // '\002'
        default:
            Log.w("SipPhone", (new StringBuilder()).append("illegal connection state: ").append(i).toString());
            state = com.android.internal.telephony.Call.State.DISCONNECTED;
            break;

        case 0: // '\0'
            state = com.android.internal.telephony.Call.State.IDLE;
            break;

        case 3: // '\003'
        case 4: // '\004'
            state = com.android.internal.telephony.Call.State.INCOMING;
            break;

        case 5: // '\005'
            state = com.android.internal.telephony.Call.State.DIALING;
            break;

        case 6: // '\006'
            state = com.android.internal.telephony.Call.State.ALERTING;
            break;

        case 7: // '\007'
            state = com.android.internal.telephony.Call.State.DISCONNECTING;
            break;

        case 8: // '\b'
            state = com.android.internal.telephony.Call.State.ACTIVE;
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private String getSipDomain(SipProfile sipprofile) {
        String s = sipprofile.getSipDomain();
        if(s.endsWith(":5060"))
            s = s.substring(0, -5 + s.length());
        return s;
    }

    private String getUriString(SipProfile sipprofile) {
        return (new StringBuilder()).append(sipprofile.getUserName()).append("@").append(getSipDomain(sipprofile)).toString();
    }

    public void acceptCall() throws CallStateException {
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorenter ;
        if(ringingCall.getState() == com.android.internal.telephony.Call.State.INCOMING || ringingCall.getState() == com.android.internal.telephony.Call.State.WAITING) {
            Log.d("SipPhone", "acceptCall");
            ringingCall.setMute(false);
            ringingCall.acceptCall();
            return;
        } else {
            throw new CallStateException("phone not ringing");
        }
    }

    public volatile void activateCellBroadcastSms(int i, Message message) {
        super.activateCellBroadcastSms(i, message);
    }

    public boolean canConference() {
        return true;
    }

    public volatile boolean canDial() {
        return super.canDial();
    }

    public boolean canTake(Object obj) {
        boolean flag = false;
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorenter ;
        if((obj instanceof SipAudioCall) && !ringingCall.getState().isAlive()) goto _L2; else goto _L1
        Exception exception;
        exception;
        throw exception;
_L2:
        if(!foregroundCall.getState().isAlive() || !backgroundCall.getState().isAlive()) goto _L4; else goto _L3
_L3:
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorexit ;
          goto _L1
_L4:
        SipAudioCall sipaudiocall;
        sipaudiocall = (SipAudioCall)obj;
        Log.d("SipPhone", (new StringBuilder()).append("+++ taking call from: ").append(sipaudiocall.getPeerProfile().getUriString()).toString());
        if(!sipaudiocall.getLocalProfile().getUriString().equals(mProfile.getUriString())) goto _L6; else goto _L5
_L5:
        boolean flag1 = foregroundCall.getState().isAlive();
        ringingCall.initIncomingCall(sipaudiocall, flag1);
        if(sipaudiocall.getState() != 3) {
            Log.d("SipPhone", "    call cancelled !!");
            ringingCall.reset();
        }
        flag = true;
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception1;
        exception1;
        ringingCall.reset();
_L6:
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorexit ;
_L1:
        return flag;
    }

    public boolean canTransfer() {
        return false;
    }

    public void clearDisconnected() {
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorenter ;
        ringingCall.clearDisconnected();
        foregroundCall.clearDisconnected();
        backgroundCall.clearDisconnected();
        updatePhoneState();
        notifyPreciseCallStateChanged();
        return;
    }

    public void conference() throws CallStateException {
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorenter ;
        if(foregroundCall.getState() != com.android.internal.telephony.Call.State.ACTIVE || foregroundCall.getState() != com.android.internal.telephony.Call.State.ACTIVE)
            throw new CallStateException((new StringBuilder()).append("wrong state to merge calls: fg=").append(foregroundCall.getState()).append(", bg=").append(backgroundCall.getState()).toString());
        break MISSING_BLOCK_LABEL_85;
        Exception exception;
        exception;
        throw exception;
        foregroundCall.merge(backgroundCall);
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorexit ;
    }

    public void conference(Call call) throws CallStateException {
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorenter ;
        if(!(call instanceof SipCall))
            throw new CallStateException((new StringBuilder()).append("expect ").append(com/android/internal/telephony/sip/SipPhone$SipCall).append(", cannot merge with ").append(call.getClass()).toString());
        break MISSING_BLOCK_LABEL_58;
        Exception exception;
        exception;
        throw exception;
        foregroundCall.merge((SipCall)call);
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorexit ;
    }

    public Connection dial(String s) throws CallStateException {
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorenter ;
        Connection connection = dialInternal(s);
        return connection;
    }

    public volatile Connection dial(String s, UUSInfo uusinfo) throws CallStateException {
        return super.dial(s, uusinfo);
    }

    public volatile boolean disableDataConnectivity() {
        return super.disableDataConnectivity();
    }

    public volatile void disableLocationUpdates() {
        super.disableLocationUpdates();
    }

    public volatile boolean enableDataConnectivity() {
        return super.enableDataConnectivity();
    }

    public volatile void enableLocationUpdates() {
        super.enableLocationUpdates();
    }

    public boolean equals(SipPhone sipphone) {
        return getSipUri().equals(sipphone.getSipUri());
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(obj == this)
            flag = true;
        else
        if(!(obj instanceof SipPhone)) {
            flag = false;
        } else {
            SipPhone sipphone = (SipPhone)obj;
            flag = mProfile.getUriString().equals(sipphone.mProfile.getUriString());
        }
        return flag;
    }

    public void explicitCallTransfer() throws CallStateException {
    }

    public volatile void getAvailableNetworks(Message message) {
        super.getAvailableNetworks(message);
    }

    public Call getBackgroundCall() {
        return backgroundCall;
    }

    public volatile boolean getCallForwardingIndicator() {
        return super.getCallForwardingIndicator();
    }

    public volatile void getCallForwardingOption(int i, Message message) {
        super.getCallForwardingOption(i, message);
    }

    public void getCallWaiting(Message message) {
        AsyncResult.forMessage(message, null, null);
        message.sendToTarget();
    }

    public volatile void getCellBroadcastSmsConfig(Message message) {
        super.getCellBroadcastSmsConfig(message);
    }

    public volatile CellLocation getCellLocation() {
        return super.getCellLocation();
    }

    public volatile List getCurrentDataConnectionList() {
        return super.getCurrentDataConnectionList();
    }

    public volatile com.android.internal.telephony.Phone.DataActivityState getDataActivityState() {
        return super.getDataActivityState();
    }

    public volatile void getDataCallList(Message message) {
        super.getDataCallList(message);
    }

    public volatile com.android.internal.telephony.Phone.DataState getDataConnectionState() {
        return super.getDataConnectionState();
    }

    public volatile com.android.internal.telephony.Phone.DataState getDataConnectionState(String s) {
        return super.getDataConnectionState(s);
    }

    public volatile boolean getDataRoamingEnabled() {
        return super.getDataRoamingEnabled();
    }

    public volatile String getDeviceId() {
        return super.getDeviceId();
    }

    public volatile String getDeviceSvn() {
        return super.getDeviceSvn();
    }

    public volatile String getEsn() {
        return super.getEsn();
    }

    public Call getForegroundCall() {
        return foregroundCall;
    }

    public volatile IccCard getIccCard() {
        return super.getIccCard();
    }

    public volatile IccFileHandler getIccFileHandler() {
        return super.getIccFileHandler();
    }

    public volatile IccPhoneBookInterfaceManager getIccPhoneBookInterfaceManager() {
        return super.getIccPhoneBookInterfaceManager();
    }

    public volatile boolean getIccRecordsLoaded() {
        return super.getIccRecordsLoaded();
    }

    public volatile String getIccSerialNumber() {
        return super.getIccSerialNumber();
    }

    public volatile IccSmsInterfaceManager getIccSmsInterfaceManager() {
        return super.getIccSmsInterfaceManager();
    }

    public volatile String getImei() {
        return super.getImei();
    }

    public volatile String getLine1AlphaTag() {
        return super.getLine1AlphaTag();
    }

    public volatile String getLine1Number() {
        return super.getLine1Number();
    }

    public volatile LinkProperties getLinkProperties(String s) {
        return super.getLinkProperties(s);
    }

    public volatile String getMeid() {
        return super.getMeid();
    }

    public volatile boolean getMessageWaitingIndicator() {
        return super.getMessageWaitingIndicator();
    }

    public boolean getMute() {
        boolean flag;
        if(foregroundCall.getState().isAlive())
            flag = foregroundCall.getMute();
        else
            flag = backgroundCall.getMute();
        return flag;
    }

    public volatile void getNeighboringCids(Message message) {
        super.getNeighboringCids(message);
    }

    public void getOutgoingCallerIdDisplay(Message message) {
        AsyncResult.forMessage(message, null, null);
        message.sendToTarget();
    }

    public volatile List getPendingMmiCodes() {
        return super.getPendingMmiCodes();
    }

    public String getPhoneName() {
        return (new StringBuilder()).append("SIP:").append(getUriString(mProfile)).toString();
    }

    public volatile PhoneSubInfo getPhoneSubInfo() {
        return super.getPhoneSubInfo();
    }

    public volatile int getPhoneType() {
        return super.getPhoneType();
    }

    public Call getRingingCall() {
        return ringingCall;
    }

    public ServiceState getServiceState() {
        return super.getServiceState();
    }

    public volatile SignalStrength getSignalStrength() {
        return super.getSignalStrength();
    }

    public String getSipUri() {
        return mProfile.getUriString();
    }

    public volatile com.android.internal.telephony.Phone.State getState() {
        return super.getState();
    }

    public volatile String getSubscriberId() {
        return super.getSubscriberId();
    }

    public volatile String getVoiceMailAlphaTag() {
        return super.getVoiceMailAlphaTag();
    }

    public volatile String getVoiceMailNumber() {
        return super.getVoiceMailNumber();
    }

    public volatile boolean handleInCallMmiCommands(String s) throws CallStateException {
        return super.handleInCallMmiCommands(s);
    }

    public volatile boolean handlePinMmi(String s) {
        return super.handlePinMmi(s);
    }

    public volatile boolean isDataConnectivityPossible() {
        return super.isDataConnectivityPossible();
    }

    public volatile boolean needsOtaServiceProvisioning() {
        return super.needsOtaServiceProvisioning();
    }

    public volatile void notifyCallForwardingIndicator() {
        super.notifyCallForwardingIndicator();
    }

    public volatile void registerForRingbackTone(Handler handler, int i, Object obj) {
        super.registerForRingbackTone(handler, i, obj);
    }

    public volatile void registerForSuppServiceNotification(Handler handler, int i, Object obj) {
        super.registerForSuppServiceNotification(handler, i, obj);
    }

    public void rejectCall() throws CallStateException {
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorenter ;
        if(ringingCall.getState().isRinging()) {
            Log.d("SipPhone", "rejectCall");
            ringingCall.rejectCall();
            return;
        } else {
            throw new CallStateException("phone not ringing");
        }
    }

    public volatile void saveClirSetting(int i) {
        super.saveClirSetting(i);
    }

    public volatile void selectNetworkManually(OperatorInfo operatorinfo, Message message) {
        super.selectNetworkManually(operatorinfo, message);
    }

    public void sendBurstDtmf(String s) {
        Log.e("SipPhone", "[SipPhone] sendBurstDtmf() is a CDMA method");
    }

    public void sendDtmf(char c) {
        if(PhoneNumberUtils.is12Key(c)) goto _L2; else goto _L1
_L1:
        Log.e("SipPhone", (new StringBuilder()).append("sendDtmf called with invalid character '").append(c).append("'").toString());
_L4:
        return;
_L2:
        if(!foregroundCall.getState().isAlive())
            continue; /* Loop/switch isn't completed */
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorenter ;
        foregroundCall.sendDtmf(c);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public volatile void sendUssdResponse(String s) {
        super.sendUssdResponse(s);
    }

    public volatile void setCallForwardingOption(int i, int j, String s, int k, Message message) {
        super.setCallForwardingOption(i, j, s, k, message);
    }

    public void setCallWaiting(boolean flag, Message message) {
        Log.e("SipPhone", "call waiting not supported");
    }

    public volatile void setCellBroadcastSmsConfig(int ai[], Message message) {
        super.setCellBroadcastSmsConfig(ai, message);
    }

    public volatile void setDataRoamingEnabled(boolean flag) {
        super.setDataRoamingEnabled(flag);
    }

    public void setEchoSuppressionEnabled(boolean flag) {
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorenter ;
        foregroundCall.setAudioGroupMode();
        return;
    }

    public volatile void setLine1Number(String s, String s1, Message message) {
        super.setLine1Number(s, s1, message);
    }

    public void setMute(boolean flag) {
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorenter ;
        foregroundCall.setMute(flag);
        return;
    }

    public volatile void setNetworkSelectionModeAutomatic(Message message) {
        super.setNetworkSelectionModeAutomatic(message);
    }

    public volatile void setOnPostDialCharacter(Handler handler, int i, Object obj) {
        super.setOnPostDialCharacter(handler, i, obj);
    }

    public void setOutgoingCallerIdDisplay(int i, Message message) {
        AsyncResult.forMessage(message, null, null);
        message.sendToTarget();
    }

    public volatile void setRadioPower(boolean flag) {
        super.setRadioPower(flag);
    }

    public volatile void setVoiceMailNumber(String s, String s1, Message message) {
        super.setVoiceMailNumber(s, s1, message);
    }

    public void startDtmf(char c) {
        if(!PhoneNumberUtils.is12Key(c))
            Log.e("SipPhone", (new StringBuilder()).append("startDtmf called with invalid character '").append(c).append("'").toString());
        else
            sendDtmf(c);
    }

    public void stopDtmf() {
    }

    public void switchHoldingAndActive() throws CallStateException {
        Log.d("SipPhone", " ~~~~~~  switch fg and bg");
        com/android/internal/telephony/sip/SipPhone;
        JVM INSTR monitorenter ;
        foregroundCall.switchWith(backgroundCall);
        if(backgroundCall.getState().isAlive())
            backgroundCall.hold();
        if(foregroundCall.getState().isAlive())
            foregroundCall.unhold();
        return;
    }

    public volatile void unregisterForRingbackTone(Handler handler) {
        super.unregisterForRingbackTone(handler);
    }

    public volatile void unregisterForSuppServiceNotification(Handler handler) {
        super.unregisterForSuppServiceNotification(handler);
    }

    public volatile void updateServiceLocation() {
        super.updateServiceLocation();
    }

    private static final boolean DEBUG = true;
    private static final String LOG_TAG = "SipPhone";
    private static final int TIMEOUT_ANSWER_CALL = 8;
    private static final int TIMEOUT_HOLD_CALL = 15;
    private static final int TIMEOUT_MAKE_CALL = 15;
    private SipCall backgroundCall;
    private SipCall foregroundCall;
    private SipProfile mProfile;
    private SipManager mSipManager;
    private SipCall ringingCall;









}
