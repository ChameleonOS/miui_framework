// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.os.Handler;
import android.os.Message;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccUtils;
import com.android.internal.util.*;

// Referenced classes of package com.android.internal.telephony.cat:
//            CommandParamsFactory, ResultException, RilMessage, ResultCode, 
//            BerTlv, CatLog, CommandParams

class RilMessageDecoder extends StateMachine {
    private class StateCmdParamsReady extends State {

        public boolean processMessage(Message message) {
            if(message.what == 2) {
                mCurrentRilMessage.mResCode = ResultCode.fromInt(message.arg1);
                mCurrentRilMessage.mData = message.obj;
                sendCmdForExecution(mCurrentRilMessage);
                transitionTo(mStateStart);
            } else {
                CatLog.d(this, (new StringBuilder()).append("StateCmdParamsReady expecting CMD_PARAMS_READY=2 got ").append(message.what).toString());
                deferMessage(message);
            }
            return true;
        }

        final RilMessageDecoder this$0;

        private StateCmdParamsReady() {
            this$0 = RilMessageDecoder.this;
            super();
        }

    }

    private class StateStart extends State {

        public boolean processMessage(Message message) {
            if(message.what == 1) {
                if(decodeMessageParams((RilMessage)message.obj))
                    transitionTo(mStateCmdParamsReady);
            } else {
                CatLog.d(this, (new StringBuilder()).append("StateStart unexpected expecting START=1 got ").append(message.what).toString());
            }
            return true;
        }

        final RilMessageDecoder this$0;

        private StateStart() {
            this$0 = RilMessageDecoder.this;
            super();
        }

    }


    private RilMessageDecoder(Handler handler, IccFileHandler iccfilehandler) {
        super("RilMessageDecoder");
        mCmdParamsFactory = null;
        mCurrentRilMessage = null;
        mCaller = null;
        mStateStart = new StateStart();
        mStateCmdParamsReady = new StateCmdParamsReady();
        addState(mStateStart);
        addState(mStateCmdParamsReady);
        setInitialState(mStateStart);
        mCaller = handler;
        mCmdParamsFactory = CommandParamsFactory.getInstance(this, iccfilehandler);
    }

    private boolean decodeMessageParams(RilMessage rilmessage) {
        mCurrentRilMessage = rilmessage;
        rilmessage.mId;
        JVM INSTR tableswitch 1 5: default 44
    //                   1 48
    //                   2 71
    //                   3 71
    //                   4 48
    //                   5 71;
           goto _L1 _L2 _L3 _L3 _L2 _L3
_L1:
        boolean flag = false;
_L5:
        return flag;
_L2:
        mCurrentRilMessage.mResCode = ResultCode.OK;
        sendCmdForExecution(mCurrentRilMessage);
        flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        byte abyte0[];
        try {
            abyte0 = IccUtils.hexStringToBytes((String)rilmessage.mData);
        }
        catch(Exception exception) {
            CatLog.d(this, "decodeMessageParams dropping zombie messages");
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        mCmdParamsFactory.make(BerTlv.decode(abyte0));
        flag = true;
        continue; /* Loop/switch isn't completed */
        ResultException resultexception;
        resultexception;
        CatLog.d(this, (new StringBuilder()).append("decodeMessageParams: caught ResultException e=").append(resultexception).toString());
        mCurrentRilMessage.mResCode = resultexception.result();
        sendCmdForExecution(mCurrentRilMessage);
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static RilMessageDecoder getInstance(Handler handler, IccFileHandler iccfilehandler) {
        com/android/internal/telephony/cat/RilMessageDecoder;
        JVM INSTR monitorenter ;
        RilMessageDecoder rilmessagedecoder;
        if(sInstance == null) {
            sInstance = new RilMessageDecoder(handler, iccfilehandler);
            sInstance.start();
        }
        rilmessagedecoder = sInstance;
        com/android/internal/telephony/cat/RilMessageDecoder;
        JVM INSTR monitorexit ;
        return rilmessagedecoder;
        Exception exception;
        exception;
        throw exception;
    }

    private void sendCmdForExecution(RilMessage rilmessage) {
        mCaller.obtainMessage(10, new RilMessage(rilmessage)).sendToTarget();
    }

    public void sendMsgParamsDecoded(ResultCode resultcode, CommandParams commandparams) {
        Message message = obtainMessage(2);
        message.arg1 = resultcode.value();
        message.obj = commandparams;
        sendMessage(message);
    }

    public void sendStartDecodingMessageParams(RilMessage rilmessage) {
        Message message = obtainMessage(1);
        message.obj = rilmessage;
        sendMessage(message);
    }

    private static final int CMD_PARAMS_READY = 2;
    private static final int CMD_START = 1;
    private static RilMessageDecoder sInstance = null;
    private Handler mCaller;
    private CommandParamsFactory mCmdParamsFactory;
    private RilMessage mCurrentRilMessage;
    private StateCmdParamsReady mStateCmdParamsReady;
    private StateStart mStateStart;









}
