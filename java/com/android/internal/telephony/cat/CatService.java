// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.*;
import com.android.internal.telephony.*;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.android.internal.telephony.cat:
//            AppInterface, RilMessageDecoder, CatLog, CommandDetails, 
//            ResultCode, Input, ComprehensionTlvTag, Duration, 
//            ResponseData, CatResponseMessage, SelectItemResponseData, CatCmdMessage, 
//            GetInkeyInputResponseData, CommandParams, TextMessage, DTTZResponseData, 
//            LanguageResponseData, LaunchBrowserParams, DisplayTextParams, CallSetupParams, 
//            BIPClientParams, RilMessage, Menu

public class CatService extends Handler
    implements AppInterface {

    private CatService(CommandsInterface commandsinterface, IccRecords iccrecords, Context context, IccFileHandler iccfilehandler, IccCard icccard) {
        mCurrntCmd = null;
        mMenuCmd = null;
        mMsgDecoder = null;
        mStkAppInstalled = false;
        if(commandsinterface == null || iccrecords == null || context == null || iccfilehandler == null || icccard == null) {
            throw new NullPointerException("Service: Input parameters must not be null");
        } else {
            mCmdIf = commandsinterface;
            mContext = context;
            mMsgDecoder = RilMessageDecoder.getInstance(this, iccfilehandler);
            mCmdIf.setOnCatSessionEnd(this, 1, null);
            mCmdIf.setOnCatProactiveCmd(this, 2, null);
            mCmdIf.setOnCatEvent(this, 3, null);
            mCmdIf.setOnCatCallSetUp(this, 4, null);
            mIccRecords = iccrecords;
            icccard.registerForReady(this, 7, null);
            mIccRecords.registerForRecordsLoaded(this, 20, null);
            mStkAppInstalled = isStkAppInstalled();
            CatLog.d(this, (new StringBuilder()).append("Running CAT service. STK app installed:").append(mStkAppInstalled).toString());
            return;
        }
    }

    private void encodeOptionalTags(CommandDetails commanddetails, ResultCode resultcode, Input input, ByteArrayOutputStream bytearrayoutputstream) {
        AppInterface.CommandType commandtype = AppInterface.CommandType.fromInt(commanddetails.typeOfCommand);
        if(commandtype == null) goto _L2; else goto _L1
_L1:
        class _cls1 {

            static final int $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[];
            static final int $SwitchMap$com$android$internal$telephony$cat$ResultCode[];

            static  {
                $SwitchMap$com$android$internal$telephony$cat$ResultCode = new int[ResultCode.values().length];
                NoSuchFieldError nosuchfielderror33;
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.HELP_INFO_REQUIRED.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.OK.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.PRFRMD_WITH_PARTIAL_COMPREHENSION.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.PRFRMD_WITH_MISSING_INFO.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.PRFRMD_WITH_ADDITIONAL_EFS_READ.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.PRFRMD_ICON_NOT_DISPLAYED.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.PRFRMD_MODIFIED_BY_NAA.ordinal()] = 7;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.PRFRMD_LIMITED_SERVICE.ordinal()] = 8;
                }
                catch(NoSuchFieldError nosuchfielderror7) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.PRFRMD_WITH_MODIFICATION.ordinal()] = 9;
                }
                catch(NoSuchFieldError nosuchfielderror8) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.PRFRMD_NAA_NOT_ACTIVE.ordinal()] = 10;
                }
                catch(NoSuchFieldError nosuchfielderror9) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.PRFRMD_TONE_NOT_PLAYED.ordinal()] = 11;
                }
                catch(NoSuchFieldError nosuchfielderror10) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.NO_RESPONSE_FROM_USER.ordinal()] = 12;
                }
                catch(NoSuchFieldError nosuchfielderror11) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.UICC_SESSION_TERM_BY_USER.ordinal()] = 13;
                }
                catch(NoSuchFieldError nosuchfielderror12) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.BACKWARD_MOVE_BY_USER.ordinal()] = 14;
                }
                catch(NoSuchFieldError nosuchfielderror13) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$ResultCode[ResultCode.USER_NOT_ACCEPT.ordinal()] = 15;
                }
                catch(NoSuchFieldError nosuchfielderror14) { }
                $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType = new int[AppInterface.CommandType.values().length];
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SET_UP_MENU.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror15) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.DISPLAY_TEXT.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror16) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.REFRESH.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror17) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SET_UP_IDLE_MODE_TEXT.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror18) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.PROVIDE_LOCAL_INFORMATION.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror19) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.LAUNCH_BROWSER.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror20) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SELECT_ITEM.ordinal()] = 7;
                }
                catch(NoSuchFieldError nosuchfielderror21) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.GET_INPUT.ordinal()] = 8;
                }
                catch(NoSuchFieldError nosuchfielderror22) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.GET_INKEY.ordinal()] = 9;
                }
                catch(NoSuchFieldError nosuchfielderror23) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_DTMF.ordinal()] = 10;
                }
                catch(NoSuchFieldError nosuchfielderror24) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_SMS.ordinal()] = 11;
                }
                catch(NoSuchFieldError nosuchfielderror25) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_SS.ordinal()] = 12;
                }
                catch(NoSuchFieldError nosuchfielderror26) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_USSD.ordinal()] = 13;
                }
                catch(NoSuchFieldError nosuchfielderror27) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.PLAY_TONE.ordinal()] = 14;
                }
                catch(NoSuchFieldError nosuchfielderror28) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SET_UP_CALL.ordinal()] = 15;
                }
                catch(NoSuchFieldError nosuchfielderror29) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.OPEN_CHANNEL.ordinal()] = 16;
                }
                catch(NoSuchFieldError nosuchfielderror30) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.CLOSE_CHANNEL.ordinal()] = 17;
                }
                catch(NoSuchFieldError nosuchfielderror31) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.RECEIVE_DATA.ordinal()] = 18;
                }
                catch(NoSuchFieldError nosuchfielderror32) { }
                $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_DATA.ordinal()] = 19;
_L2:
                return;
                nosuchfielderror33;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.com.android.internal.telephony.cat.AppInterface.CommandType[commandtype.ordinal()];
        JVM INSTR lookupswitch 2: default 48
    //                   5: 106
    //                   9: 72;
           goto _L3 _L4 _L5
_L3:
        CatLog.d(this, (new StringBuilder()).append("encodeOptionalTags() Unsupported Cmd details=").append(commanddetails).toString());
_L7:
        return;
_L5:
        if(resultcode.value() == ResultCode.NO_RESPONSE_FROM_USER.value() && input != null && input.duration != null)
            getInKeyResponse(bytearrayoutputstream, input);
        continue; /* Loop/switch isn't completed */
_L4:
        if(commanddetails.commandQualifier == 4 && resultcode.value() == ResultCode.OK.value())
            getPliResponse(bytearrayoutputstream);
        continue; /* Loop/switch isn't completed */
_L2:
        CatLog.d(this, (new StringBuilder()).append("encodeOptionalTags() bad Cmd details=").append(commanddetails).toString());
        if(true) goto _L7; else goto _L6
_L6:
    }

    private void eventDownload(int i, int j, int k, byte abyte0[], boolean flag) {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bytearrayoutputstream.write(214);
        bytearrayoutputstream.write(0);
        bytearrayoutputstream.write(0x80 | ComprehensionTlvTag.EVENT_LIST.value());
        bytearrayoutputstream.write(1);
        bytearrayoutputstream.write(i);
        bytearrayoutputstream.write(0x80 | ComprehensionTlvTag.DEVICE_IDENTITIES.value());
        bytearrayoutputstream.write(2);
        bytearrayoutputstream.write(j);
        bytearrayoutputstream.write(k);
        if(abyte0 != null) {
            int l = abyte0.length;
            for(int i1 = 0; i1 < l; i1++)
                bytearrayoutputstream.write(abyte0[i1]);

        }
        byte abyte1[] = bytearrayoutputstream.toByteArray();
        abyte1[1] = (byte)(-2 + abyte1.length);
        String s = IccUtils.bytesToHexString(abyte1);
        mCmdIf.sendEnvelope(s, null);
    }

    private void getInKeyResponse(ByteArrayOutputStream bytearrayoutputstream, Input input) {
        bytearrayoutputstream.write(ComprehensionTlvTag.DURATION.value());
        bytearrayoutputstream.write(2);
        Duration.TimeUnit _tmp = input.duration.timeUnit;
        bytearrayoutputstream.write(Duration.TimeUnit.SECOND.value());
        bytearrayoutputstream.write(input.duration.timeInterval);
    }

    public static AppInterface getInstance() {
        return getInstance(null, null, null, null, null);
    }

    public static CatService getInstance(CommandsInterface commandsinterface, IccRecords iccrecords, Context context, IccFileHandler iccfilehandler, IccCard icccard) {
        CatService catservice = null;
        Object obj = sInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        if(sInstance != null) goto _L2; else goto _L1
_L1:
        if(commandsinterface != null && iccrecords != null && context != null && iccfilehandler != null && icccard != null) goto _L4; else goto _L3
_L4:
        (new HandlerThread("Cat Telephony service")).start();
        sInstance = new CatService(commandsinterface, iccrecords, context, iccfilehandler, icccard);
        CatLog.d(sInstance, "NEW sInstance");
_L5:
        catservice = sInstance;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
_L2:
        if(iccrecords == null)
            break MISSING_BLOCK_LABEL_149;
        if(mIccRecords != iccrecords) {
            CatLog.d(sInstance, "Reinitialize the Service with SIMRecords");
            mIccRecords = iccrecords;
            mIccRecords.registerForRecordsLoaded(sInstance, 20, null);
            CatLog.d(sInstance, "sr changed reinitialize and return current sInstance");
            continue; /* Loop/switch isn't completed */
        }
        CatLog.d(sInstance, "Return current sInstance");
        if(true) goto _L5; else goto _L3
_L3:
        return catservice;
    }

    private void getPliResponse(ByteArrayOutputStream bytearrayoutputstream) {
        String s = SystemProperties.get("persist.sys.language");
        if(s != null) {
            bytearrayoutputstream.write(ComprehensionTlvTag.LANGUAGE.value());
            ResponseData.writeLength(bytearrayoutputstream, s.length());
            bytearrayoutputstream.write(s.getBytes(), 0, s.length());
        }
    }

    private void handleCmdResponse(CatResponseMessage catresponsemessage) {
        if(validateResponse(catresponsemessage)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        boolean flag;
        CommandDetails commanddetails;
        obj = null;
        flag = false;
        commanddetails = catresponsemessage.getCmdDetails();
        _cls1..SwitchMap.com.android.internal.telephony.cat.ResultCode[catresponsemessage.resCode.ordinal()];
        JVM INSTR tableswitch 1 15: default 104
    //                   1 107
    //                   2 109
    //                   3 109
    //                   4 109
    //                   5 109
    //                   6 109
    //                   7 109
    //                   8 109
    //                   9 109
    //                   10 109
    //                   11 109
    //                   12 351
    //                   13 351
    //                   14 351
    //                   15 351;
           goto _L1 _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L5 _L5 _L5 _L5
_L3:
        flag = true;
_L4:
        _cls1..SwitchMap.com.android.internal.telephony.cat.AppInterface.CommandType[AppInterface.CommandType.fromInt(commanddetails.typeOfCommand).ordinal()];
        JVM INSTR tableswitch 1 15: default 200
    //                   1 221
    //                   2 200
    //                   3 200
    //                   4 200
    //                   5 200
    //                   6 200
    //                   7 253
    //                   8 268
    //                   9 268
    //                   10 200
    //                   11 200
    //                   12 200
    //                   13 200
    //                   14 200
    //                   15 329;
           goto _L6 _L7 _L6 _L6 _L6 _L6 _L6 _L8 _L9 _L9 _L6 _L6 _L6 _L6 _L6 _L10
_L6:
        sendTerminalResponse(commanddetails, catresponsemessage.resCode, false, 0, ((ResponseData) (obj)));
        mCurrntCmd = null;
          goto _L1
_L7:
        boolean flag1;
        if(catresponsemessage.resCode == ResultCode.HELP_INFO_REQUIRED)
            flag1 = true;
        else
            flag1 = false;
        sendMenuSelection(catresponsemessage.usersMenuSelection, flag1);
          goto _L1
_L8:
        obj = new SelectItemResponseData(catresponsemessage.usersMenuSelection);
          goto _L6
_L9:
        Input input = mCurrntCmd.geInput();
        if(!input.yesNo) {
            if(!flag)
                obj = new GetInkeyInputResponseData(catresponsemessage.usersInput, input.ucs2, input.packed);
        } else {
            obj = new GetInkeyInputResponseData(catresponsemessage.usersYesNoSelection);
        }
          goto _L6
_L10:
        mCmdIf.handleCallSetupRequestFromSim(catresponsemessage.usersConfirm, null);
        mCurrntCmd = null;
          goto _L1
_L5:
        obj = null;
          goto _L6
    }

    private void handleCommand(CommandParams commandparams, boolean flag) {
        CatCmdMessage catcmdmessage;
        CatLog.d(this, commandparams.getCommandType().name());
        catcmdmessage = new CatCmdMessage(commandparams);
        _cls1..SwitchMap.com.android.internal.telephony.cat.AppInterface.CommandType[commandparams.getCommandType().ordinal()];
        JVM INSTR tableswitch 1 19: default 120
    //                   1 128
    //                   2 205
    //                   3 232
    //                   4 248
    //                   5 265
    //                   6 374
    //                   7 158
    //                   8 158
    //                   9 158
    //                   10 435
    //                   11 435
    //                   12 435
    //                   13 435
    //                   14 158
    //                   15 496
    //                   16 557
    //                   17 557
    //                   18 557
    //                   19 557;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L8 _L8 _L9 _L9 _L9 _L9 _L8 _L10 _L11 _L11 _L11 _L11
_L8:
        break; /* Loop/switch isn't completed */
_L1:
        CatLog.d(this, "Unsupported command");
_L12:
        return;
_L2:
        Intent intent;
        if(removeMenu(catcmdmessage.getMenu()))
            mMenuCmd = null;
        else
            mMenuCmd = catcmdmessage;
        sendTerminalResponse(commandparams.cmdDet, ResultCode.OK, false, 0, null);
_L13:
        mCurrntCmd = catcmdmessage;
        intent = new Intent("android.intent.action.stk.command");
        intent.putExtra("STK CMD", catcmdmessage);
        mContext.sendBroadcast(intent);
          goto _L12
_L3:
        if(!catcmdmessage.geTextMessage().responseNeeded)
            sendTerminalResponse(commandparams.cmdDet, ResultCode.OK, false, 0, null);
          goto _L13
_L4:
        commandparams.cmdDet.typeOfCommand = AppInterface.CommandType.SET_UP_IDLE_MODE_TEXT.value();
          goto _L13
_L5:
        sendTerminalResponse(commandparams.cmdDet, ResultCode.OK, false, 0, null);
          goto _L13
_L6:
        switch(commandparams.cmdDet.commandQualifier) {
        default:
            sendTerminalResponse(commandparams.cmdDet, ResultCode.OK, false, 0, null);
            break;

        case 3: // '\003'
            DTTZResponseData dttzresponsedata = new DTTZResponseData(null);
            sendTerminalResponse(commandparams.cmdDet, ResultCode.OK, false, 0, dttzresponsedata);
            break;

        case 4: // '\004'
            LanguageResponseData languageresponsedata = new LanguageResponseData(Locale.getDefault().getLanguage());
            sendTerminalResponse(commandparams.cmdDet, ResultCode.OK, false, 0, languageresponsedata);
            break;
        }
        if(true) goto _L12; else goto _L14
_L14:
_L7:
        if(((LaunchBrowserParams)commandparams).confirmMsg.text != null && ((LaunchBrowserParams)commandparams).confirmMsg.text.equals("Defualt Message")) {
            CharSequence charsequence2 = mContext.getText(0x10404f9);
            ((LaunchBrowserParams)commandparams).confirmMsg.text = charsequence2.toString();
        }
          goto _L13
_L9:
        if(((DisplayTextParams)commandparams).textMsg.text != null && ((DisplayTextParams)commandparams).textMsg.text.equals("Defualt Message")) {
            CharSequence charsequence1 = mContext.getText(0x10404f8);
            ((DisplayTextParams)commandparams).textMsg.text = charsequence1.toString();
        }
          goto _L13
_L10:
        if(((CallSetupParams)commandparams).confirmMsg.text != null && ((CallSetupParams)commandparams).confirmMsg.text.equals("Defualt Message")) {
            CharSequence charsequence = mContext.getText(0x10404fa);
            ((CallSetupParams)commandparams).confirmMsg.text = charsequence.toString();
        }
          goto _L13
_L11:
        BIPClientParams bipclientparams = (BIPClientParams)commandparams;
        if(bipclientparams.bHasAlphaId && bipclientparams.textMsg.text == null) {
            CatLog.d(this, (new StringBuilder()).append("cmd ").append(commandparams.getCommandType()).append(" with null alpha id").toString());
            if(flag)
                sendTerminalResponse(commandparams.cmdDet, ResultCode.OK, false, 0, null);
        } else {
label0:
            {
                if(mStkAppInstalled)
                    break label0;
                CatLog.d(this, "No STK application found.");
                if(!flag)
                    break label0;
                sendTerminalResponse(commandparams.cmdDet, ResultCode.BEYOND_TERMINAL_CAPABILITY, false, 0, null);
            }
        }
          goto _L12
        if(flag && (commandparams.getCommandType() == AppInterface.CommandType.CLOSE_CHANNEL || commandparams.getCommandType() == AppInterface.CommandType.RECEIVE_DATA || commandparams.getCommandType() == AppInterface.CommandType.SEND_DATA))
            sendTerminalResponse(commandparams.cmdDet, ResultCode.OK, false, 0, null);
          goto _L13
    }

    private void handleRilMsg(RilMessage rilmessage) {
        if(rilmessage != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch(rilmessage.mId) {
        case 4: // '\004'
        default:
            break;

        case 1: // '\001'
            handleSessionEnd();
            continue; /* Loop/switch isn't completed */

        case 3: // '\003'
            if(rilmessage.mResCode == ResultCode.OK) {
                CommandParams commandparams2 = (CommandParams)rilmessage.mData;
                if(commandparams2 != null)
                    handleCommand(commandparams2, false);
            }
            continue; /* Loop/switch isn't completed */

        case 2: // '\002'
            CommandParams commandparams1;
            try {
                commandparams1 = (CommandParams)rilmessage.mData;
            }
            catch(ClassCastException classcastexception) {
                CatLog.d(this, "Fail to parse proactive command");
                if(mCurrntCmd != null)
                    sendTerminalResponse(mCurrntCmd.mCmdDet, ResultCode.CMD_DATA_NOT_UNDERSTOOD, false, 0, null);
                continue; /* Loop/switch isn't completed */
            }
            if(commandparams1 != null)
                if(rilmessage.mResCode == ResultCode.OK)
                    handleCommand(commandparams1, true);
                else
                    sendTerminalResponse(commandparams1.cmdDet, rilmessage.mResCode, false, 0, null);
            continue; /* Loop/switch isn't completed */

        case 5: // '\005'
            CommandParams commandparams = (CommandParams)rilmessage.mData;
            if(commandparams != null)
                handleCommand(commandparams, false);
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void handleSessionEnd() {
        CatLog.d(this, "SESSION END");
        mCurrntCmd = mMenuCmd;
        Intent intent = new Intent("android.intent.action.stk.session_end");
        mContext.sendBroadcast(intent);
    }

    private boolean isStkAppInstalled() {
        boolean flag = false;
        Intent intent = new Intent("android.intent.action.stk.command");
        List list = mContext.getPackageManager().queryBroadcastReceivers(intent, 128);
        int i;
        if(list == null)
            i = 0;
        else
            i = list.size();
        if(i > 0)
            flag = true;
        return flag;
    }

    private boolean removeMenu(Menu menu) {
        boolean flag = true;
        if(menu.items.size() != flag) goto _L2; else goto _L1
_L1:
        Object obj = menu.items.get(0);
        if(obj != null) goto _L2; else goto _L3
_L3:
        return flag;
        NullPointerException nullpointerexception;
        nullpointerexception;
        CatLog.d(this, "Unable to get Menu's items size");
        continue; /* Loop/switch isn't completed */
_L2:
        flag = false;
        if(true) goto _L3; else goto _L4
_L4:
    }

    private void sendMenuSelection(int i, boolean flag) {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bytearrayoutputstream.write(211);
        bytearrayoutputstream.write(0);
        bytearrayoutputstream.write(0x80 | ComprehensionTlvTag.DEVICE_IDENTITIES.value());
        bytearrayoutputstream.write(2);
        bytearrayoutputstream.write(1);
        bytearrayoutputstream.write(129);
        bytearrayoutputstream.write(0x80 | ComprehensionTlvTag.ITEM_ID.value());
        bytearrayoutputstream.write(1);
        bytearrayoutputstream.write(i);
        if(flag) {
            bytearrayoutputstream.write(ComprehensionTlvTag.HELP_REQUEST.value());
            bytearrayoutputstream.write(0);
        }
        byte abyte0[] = bytearrayoutputstream.toByteArray();
        abyte0[1] = (byte)(-2 + abyte0.length);
        String s = IccUtils.bytesToHexString(abyte0);
        mCmdIf.sendEnvelope(s, null);
    }

    private void sendTerminalResponse(CommandDetails commanddetails, ResultCode resultcode, boolean flag, int i, ResponseData responsedata) {
        byte byte0 = 2;
        if(commanddetails != null) {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            Input input = null;
            if(mCurrntCmd != null)
                input = mCurrntCmd.geInput();
            int j = ComprehensionTlvTag.COMMAND_DETAILS.value();
            if(commanddetails.compRequired)
                j |= 0x80;
            bytearrayoutputstream.write(j);
            bytearrayoutputstream.write(3);
            bytearrayoutputstream.write(commanddetails.commandNumber);
            bytearrayoutputstream.write(commanddetails.typeOfCommand);
            bytearrayoutputstream.write(commanddetails.commandQualifier);
            bytearrayoutputstream.write(ComprehensionTlvTag.DEVICE_IDENTITIES.value());
            bytearrayoutputstream.write(byte0);
            bytearrayoutputstream.write(130);
            bytearrayoutputstream.write(129);
            bytearrayoutputstream.write(0x80 | ComprehensionTlvTag.RESULT.value());
            String s;
            if(!flag)
                byte0 = 1;
            bytearrayoutputstream.write(byte0);
            bytearrayoutputstream.write(resultcode.value());
            if(flag)
                bytearrayoutputstream.write(i);
            if(responsedata != null)
                responsedata.format(bytearrayoutputstream);
            else
                encodeOptionalTags(commanddetails, resultcode, input, bytearrayoutputstream);
            s = IccUtils.bytesToHexString(bytearrayoutputstream.toByteArray());
            mCmdIf.sendTerminalResponse(s, null);
        }
    }

    private boolean validateResponse(CatResponseMessage catresponsemessage) {
        boolean flag;
        if(mCurrntCmd != null)
            flag = catresponsemessage.cmdDet.compareTo(mCurrntCmd.mCmdDet);
        else
            flag = false;
        return flag;
    }

    public void dispose() {
        mIccRecords.unregisterForRecordsLoaded(this);
        mCmdIf.unSetOnCatSessionEnd(this);
        mCmdIf.unSetOnCatProactiveCmd(this);
        mCmdIf.unSetOnCatEvent(this);
        mCmdIf.unSetOnCatCallSetUp(this);
        removeCallbacksAndMessages(null);
    }

    protected void finalize() {
        CatLog.d(this, "Service finalized");
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 1 20: default 100
    //                   1 131
    //                   2 131
    //                   3 131
    //                   4 199
    //                   5 131
    //                   6 235
    //                   7 249
    //                   8 100
    //                   9 100
    //                   10 221
    //                   11 100
    //                   12 100
    //                   13 100
    //                   14 100
    //                   15 100
    //                   16 100
    //                   17 100
    //                   18 100
    //                   19 100
    //                   20 193;
           goto _L1 _L2 _L2 _L2 _L3 _L2 _L4 _L5 _L1 _L1 _L6 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L7
_L7:
        break; /* Loop/switch isn't completed */
_L1:
        throw new AssertionError((new StringBuilder()).append("Unrecognized CAT command: ").append(message.what).toString());
_L2:
        CatLog.d(this, "ril message arrived");
        String s = null;
        if(message.obj != null) {
            AsyncResult asyncresult = (AsyncResult)message.obj;
            if(asyncresult != null && asyncresult.result != null)
                try {
                    s = (String)asyncresult.result;
                }
                catch(ClassCastException classcastexception) {
                    continue; /* Loop/switch isn't completed */
                }
        }
        mMsgDecoder.sendStartDecodingMessageParams(new RilMessage(message.what, s));
_L9:
        return;
_L3:
        mMsgDecoder.sendStartDecodingMessageParams(new RilMessage(message.what, null));
        continue; /* Loop/switch isn't completed */
_L6:
        handleRilMsg((RilMessage)message.obj);
        continue; /* Loop/switch isn't completed */
_L4:
        handleCmdResponse((CatResponseMessage)message.obj);
        continue; /* Loop/switch isn't completed */
_L5:
        CatLog.d(this, "SIM ready. Reporting STK service running now...");
        mCmdIf.reportStkServiceIsRunning(null);
        if(true) goto _L9; else goto _L8
_L8:
    }

    /**
     * @deprecated Method onCmdResponse is deprecated
     */

    public void onCmdResponse(CatResponseMessage catresponsemessage) {
        this;
        JVM INSTR monitorenter ;
        if(catresponsemessage != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        obtainMessage(6, catresponsemessage).sendToTarget();
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static final int DEV_ID_DISPLAY = 2;
    private static final int DEV_ID_EARPIECE = 3;
    private static final int DEV_ID_KEYPAD = 1;
    private static final int DEV_ID_NETWORK = 131;
    private static final int DEV_ID_TERMINAL = 130;
    private static final int DEV_ID_UICC = 129;
    static final int MSG_ID_CALL_SETUP = 4;
    static final int MSG_ID_EVENT_NOTIFY = 3;
    private static final int MSG_ID_ICC_RECORDS_LOADED = 20;
    static final int MSG_ID_PROACTIVE_COMMAND = 2;
    static final int MSG_ID_REFRESH = 5;
    static final int MSG_ID_RESPONSE = 6;
    static final int MSG_ID_RIL_MSG_DECODED = 10;
    static final int MSG_ID_SESSION_END = 1;
    static final int MSG_ID_SIM_READY = 7;
    static final String STK_DEFAULT = "Defualt Message";
    private static IccRecords mIccRecords;
    private static CatService sInstance;
    private static final Object sInstanceLock = new Object();
    private CommandsInterface mCmdIf;
    private Context mContext;
    private CatCmdMessage mCurrntCmd;
    private CatCmdMessage mMenuCmd;
    private RilMessageDecoder mMsgDecoder;
    private boolean mStkAppInstalled;

}
