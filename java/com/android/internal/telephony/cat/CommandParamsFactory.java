// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.IccFileHandler;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.android.internal.telephony.cat:
//            IconLoader, ResultException, CommandDetails, CatLog, 
//            TextMessage, ComprehensionTlvTag, ValueParser, IconId, 
//            BIPClientParams, ResultCode, DisplayTextParams, Input, 
//            GetInputParams, ComprehensionTlv, LaunchBrowserMode, LaunchBrowserParams, 
//            Tone, PlayToneParams, CommandParams, Menu, 
//            ItemsIconId, PresentationType, SelectItemParams, CallSetupParams, 
//            RilMessageDecoder, BerTlv

class CommandParamsFactory extends Handler {

    private CommandParamsFactory(RilMessageDecoder rilmessagedecoder, IccFileHandler iccfilehandler) {
        mCmdParams = null;
        mIconLoadState = 0;
        mCaller = null;
        mCaller = rilmessagedecoder;
        mIconLoader = IconLoader.getInstance(this, iccfilehandler);
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    static CommandParamsFactory getInstance(RilMessageDecoder rilmessagedecoder, IccFileHandler iccfilehandler) {
        com/android/internal/telephony/cat/CommandParamsFactory;
        JVM INSTR monitorenter ;
        if(sInstance == null) goto _L2; else goto _L1
_L1:
        CommandParamsFactory commandparamsfactory = sInstance;
_L4:
        com/android/internal/telephony/cat/CommandParamsFactory;
        JVM INSTR monitorexit ;
        return commandparamsfactory;
_L2:
        if(iccfilehandler == null)
            break MISSING_BLOCK_LABEL_41;
        commandparamsfactory = new CommandParamsFactory(rilmessagedecoder, iccfilehandler);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        commandparamsfactory = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean processBIPClient(CommandDetails commanddetails, List list) throws ResultException {
        boolean flag = true;
        AppInterface.CommandType commandtype = AppInterface.CommandType.fromInt(commanddetails.typeOfCommand);
        if(commandtype != null)
            CatLog.d(this, (new StringBuilder()).append("process ").append(commandtype.name()).toString());
        TextMessage textmessage = new TextMessage();
        IconId iconid = null;
        boolean flag1 = false;
        ComprehensionTlv comprehensiontlv = searchForTag(ComprehensionTlvTag.ALPHA_ID, list);
        if(comprehensiontlv != null) {
            textmessage.text = ValueParser.retrieveAlphaId(comprehensiontlv);
            CatLog.d(this, (new StringBuilder()).append("alpha TLV text=").append(textmessage.text).toString());
            flag1 = true;
        }
        ComprehensionTlv comprehensiontlv1 = searchForTag(ComprehensionTlvTag.ICON_ID, list);
        if(comprehensiontlv1 != null) {
            iconid = ValueParser.retrieveIconId(comprehensiontlv1);
            textmessage.iconSelfExplanatory = iconid.selfExplanatory;
        }
        textmessage.responseNeeded = false;
        mCmdParams = new BIPClientParams(commanddetails, textmessage, flag1);
        if(iconid != null) {
            mIconLoadState = ((flag) ? 1 : 0);
            mIconLoader.loadIcon(iconid.recordNumber, obtainMessage(flag));
        } else {
            flag = false;
        }
        return flag;
    }

    private CommandDetails processCommandDetails(List list) {
        CommandDetails commanddetails;
        ComprehensionTlv comprehensiontlv;
        commanddetails = null;
        if(list == null)
            break MISSING_BLOCK_LABEL_28;
        comprehensiontlv = searchForTag(ComprehensionTlvTag.COMMAND_DETAILS, list);
        if(comprehensiontlv == null)
            break MISSING_BLOCK_LABEL_28;
        CommandDetails commanddetails1 = ValueParser.retrieveCommandDetails(comprehensiontlv);
        commanddetails = commanddetails1;
_L2:
        return commanddetails;
        ResultException resultexception;
        resultexception;
        CatLog.d(this, (new StringBuilder()).append("processCommandDetails: Failed to procees command details e=").append(resultexception).toString());
        if(true) goto _L2; else goto _L1
_L1:
    }

    private boolean processDisplayText(CommandDetails commanddetails, List list) throws ResultException {
        boolean flag = true;
        CatLog.d(this, "process DisplayText");
        TextMessage textmessage = new TextMessage();
        IconId iconid = null;
        ComprehensionTlv comprehensiontlv = searchForTag(ComprehensionTlvTag.TEXT_STRING, list);
        if(comprehensiontlv != null)
            textmessage.text = ValueParser.retrieveTextString(comprehensiontlv);
        if(textmessage.text == null)
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        if(searchForTag(ComprehensionTlvTag.IMMEDIATE_RESPONSE, list) != null)
            textmessage.responseNeeded = false;
        ComprehensionTlv comprehensiontlv1 = searchForTag(ComprehensionTlvTag.ICON_ID, list);
        if(comprehensiontlv1 != null) {
            iconid = ValueParser.retrieveIconId(comprehensiontlv1);
            textmessage.iconSelfExplanatory = iconid.selfExplanatory;
        }
        ComprehensionTlv comprehensiontlv2 = searchForTag(ComprehensionTlvTag.DURATION, list);
        if(comprehensiontlv2 != null)
            textmessage.duration = ValueParser.retrieveDuration(comprehensiontlv2);
        boolean flag1;
        boolean flag2;
        if((1 & commanddetails.commandQualifier) != 0)
            flag1 = flag;
        else
            flag1 = false;
        textmessage.isHighPriority = flag1;
        if((0x80 & commanddetails.commandQualifier) != 0)
            flag2 = flag;
        else
            flag2 = false;
        textmessage.userClear = flag2;
        mCmdParams = new DisplayTextParams(commanddetails, textmessage);
        if(iconid != null) {
            mIconLoadState = ((flag) ? 1 : 0);
            mIconLoader.loadIcon(iconid.recordNumber, obtainMessage(flag));
        } else {
            flag = false;
        }
        return flag;
    }

    private boolean processEventNotify(CommandDetails commanddetails, List list) throws ResultException {
        boolean flag = true;
        CatLog.d(this, "process EventNotify");
        TextMessage textmessage = new TextMessage();
        IconId iconid = null;
        textmessage.text = ValueParser.retrieveAlphaId(searchForTag(ComprehensionTlvTag.ALPHA_ID, list));
        ComprehensionTlv comprehensiontlv = searchForTag(ComprehensionTlvTag.ICON_ID, list);
        if(comprehensiontlv != null) {
            iconid = ValueParser.retrieveIconId(comprehensiontlv);
            textmessage.iconSelfExplanatory = iconid.selfExplanatory;
        }
        textmessage.responseNeeded = false;
        mCmdParams = new DisplayTextParams(commanddetails, textmessage);
        if(iconid != null) {
            mIconLoadState = ((flag) ? 1 : 0);
            mIconLoader.loadIcon(iconid.recordNumber, obtainMessage(flag));
        } else {
            flag = false;
        }
        return flag;
    }

    private boolean processGetInkey(CommandDetails commanddetails, List list) throws ResultException {
        boolean flag = true;
        CatLog.d(this, "process GetInkey");
        Input input = new Input();
        IconId iconid = null;
        ComprehensionTlv comprehensiontlv = searchForTag(ComprehensionTlvTag.TEXT_STRING, list);
        if(comprehensiontlv != null) {
            input.text = ValueParser.retrieveTextString(comprehensiontlv);
            ComprehensionTlv comprehensiontlv1 = searchForTag(ComprehensionTlvTag.ICON_ID, list);
            if(comprehensiontlv1 != null)
                iconid = ValueParser.retrieveIconId(comprehensiontlv1);
            ComprehensionTlv comprehensiontlv2 = searchForTag(ComprehensionTlvTag.DURATION, list);
            if(comprehensiontlv2 != null)
                input.duration = ValueParser.retrieveDuration(comprehensiontlv2);
            input.minLen = ((flag) ? 1 : 0);
            input.maxLen = ((flag) ? 1 : 0);
            boolean flag1;
            boolean flag2;
            boolean flag3;
            boolean flag4;
            if((1 & commanddetails.commandQualifier) == 0)
                flag1 = flag;
            else
                flag1 = false;
            input.digitOnly = flag1;
            if((2 & commanddetails.commandQualifier) != 0)
                flag2 = flag;
            else
                flag2 = false;
            input.ucs2 = flag2;
            if((4 & commanddetails.commandQualifier) != 0)
                flag3 = flag;
            else
                flag3 = false;
            input.yesNo = flag3;
            if((0x80 & commanddetails.commandQualifier) != 0)
                flag4 = flag;
            else
                flag4 = false;
            input.helpAvailable = flag4;
            input.echo = flag;
            mCmdParams = new GetInputParams(commanddetails, input);
            if(iconid != null) {
                mIconLoadState = ((flag) ? 1 : 0);
                mIconLoader.loadIcon(iconid.recordNumber, obtainMessage(flag));
            } else {
                flag = false;
            }
            return flag;
        } else {
            throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
        }
    }

    private boolean processGetInput(CommandDetails commanddetails, List list) throws ResultException {
        boolean flag = true;
        CatLog.d(this, "process GetInput");
        Input input = new Input();
        IconId iconid = null;
        ComprehensionTlv comprehensiontlv = searchForTag(ComprehensionTlvTag.TEXT_STRING, list);
        if(comprehensiontlv != null) {
            input.text = ValueParser.retrieveTextString(comprehensiontlv);
            ComprehensionTlv comprehensiontlv1 = searchForTag(ComprehensionTlvTag.RESPONSE_LENGTH, list);
            if(comprehensiontlv1 != null) {
                ComprehensionTlv comprehensiontlv2;
                ComprehensionTlv comprehensiontlv3;
                boolean flag1;
                boolean flag2;
                boolean flag3;
                boolean flag4;
                boolean flag5;
                try {
                    byte abyte0[] = comprehensiontlv1.getRawValue();
                    int i = comprehensiontlv1.getValueIndex();
                    input.minLen = 0xff & abyte0[i];
                    input.maxLen = 0xff & abyte0[i + 1];
                }
                catch(IndexOutOfBoundsException indexoutofboundsexception) {
                    throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                }
                comprehensiontlv2 = searchForTag(ComprehensionTlvTag.DEFAULT_TEXT, list);
                if(comprehensiontlv2 != null)
                    input.defaultText = ValueParser.retrieveTextString(comprehensiontlv2);
                comprehensiontlv3 = searchForTag(ComprehensionTlvTag.ICON_ID, list);
                if(comprehensiontlv3 != null)
                    iconid = ValueParser.retrieveIconId(comprehensiontlv3);
                if((1 & commanddetails.commandQualifier) == 0)
                    flag1 = flag;
                else
                    flag1 = false;
                input.digitOnly = flag1;
                if((2 & commanddetails.commandQualifier) != 0)
                    flag2 = flag;
                else
                    flag2 = false;
                input.ucs2 = flag2;
                if((4 & commanddetails.commandQualifier) == 0)
                    flag3 = flag;
                else
                    flag3 = false;
                input.echo = flag3;
                if((8 & commanddetails.commandQualifier) != 0)
                    flag4 = flag;
                else
                    flag4 = false;
                input.packed = flag4;
                if((0x80 & commanddetails.commandQualifier) != 0)
                    flag5 = flag;
                else
                    flag5 = false;
                input.helpAvailable = flag5;
                mCmdParams = new GetInputParams(commanddetails, input);
                if(iconid != null) {
                    mIconLoadState = ((flag) ? 1 : 0);
                    mIconLoader.loadIcon(iconid.recordNumber, obtainMessage(flag));
                } else {
                    flag = false;
                }
                return flag;
            } else {
                throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
            }
        } else {
            throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
        }
    }

    private boolean processLaunchBrowser(CommandDetails commanddetails, List list) throws ResultException {
        boolean flag;
        TextMessage textmessage;
        IconId iconid;
        String s;
        ComprehensionTlv comprehensiontlv;
        flag = true;
        CatLog.d(this, "process LaunchBrowser");
        textmessage = new TextMessage();
        iconid = null;
        s = null;
        comprehensiontlv = searchForTag(ComprehensionTlvTag.URL, list);
        if(comprehensiontlv == null) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        int i;
        int j;
        abyte0 = comprehensiontlv.getRawValue();
        i = comprehensiontlv.getValueIndex();
        j = comprehensiontlv.getLength();
        if(j <= 0) goto _L4; else goto _L3
_L3:
        String s1 = GsmAlphabet.gsm8BitUnpackedToString(abyte0, i, j);
        s = s1;
_L2:
        textmessage.text = ValueParser.retrieveAlphaId(searchForTag(ComprehensionTlvTag.ALPHA_ID, list));
        ComprehensionTlv comprehensiontlv1 = searchForTag(ComprehensionTlvTag.ICON_ID, list);
        if(comprehensiontlv1 != null) {
            iconid = ValueParser.retrieveIconId(comprehensiontlv1);
            textmessage.iconSelfExplanatory = iconid.selfExplanatory;
        }
        commanddetails.commandQualifier;
        JVM INSTR tableswitch 2 3: default 156
    //                   2 227
    //                   3 235;
           goto _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_235;
_L5:
        LaunchBrowserMode launchbrowsermode = LaunchBrowserMode.LAUNCH_IF_NOT_ALREADY_LAUNCHED;
_L8:
        mCmdParams = new LaunchBrowserParams(commanddetails, textmessage, s, launchbrowsermode);
        IndexOutOfBoundsException indexoutofboundsexception;
        if(iconid != null) {
            mIconLoadState = ((flag) ? 1 : 0);
            mIconLoader.loadIcon(iconid.recordNumber, obtainMessage(flag));
        } else {
            flag = false;
        }
        return flag;
_L4:
        s = null;
          goto _L2
        indexoutofboundsexception;
        throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
_L6:
        launchbrowsermode = LaunchBrowserMode.USE_EXISTING_BROWSER;
          goto _L8
        launchbrowsermode = LaunchBrowserMode.LAUNCH_NEW_BROWSER;
          goto _L8
    }

    private boolean processPlayTone(CommandDetails commanddetails, List list) throws ResultException {
        CatLog.d(this, "process PlayTone");
        Tone tone = null;
        TextMessage textmessage = new TextMessage();
        Duration duration = null;
        IconId iconid = null;
        ComprehensionTlv comprehensiontlv = searchForTag(ComprehensionTlvTag.TONE, list);
        boolean flag;
        boolean flag1;
        if(comprehensiontlv != null && comprehensiontlv.getLength() > 0) {
            ComprehensionTlv comprehensiontlv1;
            ComprehensionTlv comprehensiontlv2;
            ComprehensionTlv comprehensiontlv3;
            Tone tone1;
            try {
                tone1 = Tone.fromInt(comprehensiontlv.getRawValue()[comprehensiontlv.getValueIndex()]);
            }
            catch(IndexOutOfBoundsException indexoutofboundsexception) {
                throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            }
            tone = tone1;
        }
        comprehensiontlv1 = searchForTag(ComprehensionTlvTag.ALPHA_ID, list);
        if(comprehensiontlv1 != null)
            textmessage.text = ValueParser.retrieveAlphaId(comprehensiontlv1);
        comprehensiontlv2 = searchForTag(ComprehensionTlvTag.DURATION, list);
        if(comprehensiontlv2 != null)
            duration = ValueParser.retrieveDuration(comprehensiontlv2);
        comprehensiontlv3 = searchForTag(ComprehensionTlvTag.ICON_ID, list);
        if(comprehensiontlv3 != null) {
            iconid = ValueParser.retrieveIconId(comprehensiontlv3);
            textmessage.iconSelfExplanatory = iconid.selfExplanatory;
        }
        if((1 & commanddetails.commandQualifier) != 0)
            flag = true;
        else
            flag = false;
        textmessage.responseNeeded = false;
        mCmdParams = new PlayToneParams(commanddetails, textmessage, tone, duration, flag);
        if(iconid != null) {
            mIconLoadState = 1;
            mIconLoader.loadIcon(iconid.recordNumber, obtainMessage(1));
            flag1 = true;
        } else {
            flag1 = false;
        }
        return flag1;
    }

    private boolean processProvideLocalInfo(CommandDetails commanddetails, List list) throws ResultException {
        CatLog.d(this, "process ProvideLocalInfo");
        commanddetails.commandQualifier;
        JVM INSTR tableswitch 3 4: default 32
    //                   3 88
    //                   4 109;
           goto _L1 _L2 _L3
_L1:
        CatLog.d(this, (new StringBuilder()).append("PLI[").append(commanddetails.commandQualifier).append("] Command Not Supported").toString());
        mCmdParams = new CommandParams(commanddetails);
        throw new ResultException(ResultCode.BEYOND_TERMINAL_CAPABILITY);
_L2:
        CatLog.d(this, "PLI [DTTZ_SETTING]");
        mCmdParams = new CommandParams(commanddetails);
_L5:
        return false;
_L3:
        CatLog.d(this, "PLI [LANGUAGE_SETTING]");
        mCmdParams = new CommandParams(commanddetails);
        if(true) goto _L5; else goto _L4
_L4:
    }

    private boolean processRefresh(CommandDetails commanddetails, List list) {
        CatLog.d(this, "process Refresh");
        commanddetails.commandQualifier;
        JVM INSTR tableswitch 0 4: default 44
    //                   0 46
    //                   1 44
    //                   2 46
    //                   3 46
    //                   4 46;
           goto _L1 _L2 _L1 _L2 _L2 _L2
_L1:
        return false;
_L2:
        mCmdParams = new DisplayTextParams(commanddetails, null);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean processSelectItem(CommandDetails commanddetails, List list) throws ResultException {
        boolean flag;
        IconId iconid;
        ItemsIconId itemsiconid;
        flag = false;
        CatLog.d(this, "process SelectItem");
        Menu menu = new Menu();
        iconid = null;
        itemsiconid = null;
        Iterator iterator = list.iterator();
        ComprehensionTlv comprehensiontlv = searchForTag(ComprehensionTlvTag.ALPHA_ID, list);
        if(comprehensiontlv != null)
            menu.title = ValueParser.retrieveAlphaId(comprehensiontlv);
        do {
            ComprehensionTlv comprehensiontlv1 = searchForNextTag(ComprehensionTlvTag.ITEM, iterator);
            if(comprehensiontlv1 == null)
                break;
            menu.items.add(ValueParser.retrieveItem(comprehensiontlv1));
        } while(true);
        if(menu.items.size() == 0)
            throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
        ComprehensionTlv comprehensiontlv2 = searchForTag(ComprehensionTlvTag.ITEM_ID, list);
        if(comprehensiontlv2 != null)
            menu.defaultItem = -1 + ValueParser.retrieveItemId(comprehensiontlv2);
        ComprehensionTlv comprehensiontlv3 = searchForTag(ComprehensionTlvTag.ICON_ID, list);
        if(comprehensiontlv3 != null) {
            mIconLoadState = 1;
            iconid = ValueParser.retrieveIconId(comprehensiontlv3);
            menu.titleIconSelfExplanatory = iconid.selfExplanatory;
        }
        ComprehensionTlv comprehensiontlv4 = searchForTag(ComprehensionTlvTag.ITEM_ICON_ID_LIST, list);
        if(comprehensiontlv4 != null) {
            mIconLoadState = 2;
            itemsiconid = ValueParser.retrieveItemsIconId(comprehensiontlv4);
            menu.itemsIconSelfExplanatory = itemsiconid.selfExplanatory;
        }
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        if((1 & commanddetails.commandQualifier) != 0)
            flag1 = true;
        else
            flag1 = false;
        if(flag1)
            if((2 & commanddetails.commandQualifier) == 0)
                menu.presentationType = PresentationType.DATA_VALUES;
            else
                menu.presentationType = PresentationType.NAVIGATION_OPTIONS;
        if((4 & commanddetails.commandQualifier) != 0)
            flag2 = true;
        else
            flag2 = false;
        menu.softKeyPreferred = flag2;
        if((0x80 & commanddetails.commandQualifier) != 0)
            flag3 = true;
        else
            flag3 = false;
        menu.helpAvailable = flag3;
        if(iconid != null)
            flag4 = true;
        else
            flag4 = false;
        mCmdParams = new SelectItemParams(commanddetails, menu, flag4);
        mIconLoadState;
        JVM INSTR tableswitch 0 2: default 348
    //                   0 350
    //                   1 387
    //                   2 407;
           goto _L1 _L2 _L3 _L4
_L1:
        flag = true;
_L2:
        return flag;
_L3:
        mIconLoader.loadIcon(iconid.recordNumber, obtainMessage(1));
        continue; /* Loop/switch isn't completed */
_L4:
        int ai[] = itemsiconid.recordNumbers;
        if(iconid != null) {
            ai = new int[1 + itemsiconid.recordNumbers.length];
            ai[flag] = iconid.recordNumber;
            System.arraycopy(itemsiconid.recordNumbers, 0, ai, 1, itemsiconid.recordNumbers.length);
        }
        mIconLoader.loadIcons(ai, obtainMessage(1));
        if(true) goto _L1; else goto _L5
_L5:
    }

    private boolean processSetUpEventList(CommandDetails commanddetails, List list) {
        CatLog.d(this, "process SetUpEventList");
        return true;
    }

    private boolean processSetUpIdleModeText(CommandDetails commanddetails, List list) throws ResultException {
        boolean flag = true;
        CatLog.d(this, "process SetUpIdleModeText");
        TextMessage textmessage = new TextMessage();
        IconId iconid = null;
        ComprehensionTlv comprehensiontlv = searchForTag(ComprehensionTlvTag.TEXT_STRING, list);
        if(comprehensiontlv != null)
            textmessage.text = ValueParser.retrieveTextString(comprehensiontlv);
        if(textmessage.text != null) {
            ComprehensionTlv comprehensiontlv1 = searchForTag(ComprehensionTlvTag.ICON_ID, list);
            if(comprehensiontlv1 != null) {
                iconid = ValueParser.retrieveIconId(comprehensiontlv1);
                textmessage.iconSelfExplanatory = iconid.selfExplanatory;
            }
        }
        mCmdParams = new DisplayTextParams(commanddetails, textmessage);
        if(iconid != null) {
            mIconLoadState = ((flag) ? 1 : 0);
            mIconLoader.loadIcon(iconid.recordNumber, obtainMessage(flag));
        } else {
            flag = false;
        }
        return flag;
    }

    private boolean processSetupCall(CommandDetails commanddetails, List list) throws ResultException {
        int i = -1;
        CatLog.d(this, "process SetupCall");
        Iterator iterator = list.iterator();
        TextMessage textmessage = new TextMessage();
        TextMessage textmessage1 = new TextMessage();
        IconId iconid = null;
        IconId iconid1 = null;
        textmessage.text = ValueParser.retrieveAlphaId(searchForNextTag(ComprehensionTlvTag.ALPHA_ID, iterator));
        ComprehensionTlv comprehensiontlv = searchForTag(ComprehensionTlvTag.ICON_ID, list);
        if(comprehensiontlv != null) {
            iconid = ValueParser.retrieveIconId(comprehensiontlv);
            textmessage.iconSelfExplanatory = iconid.selfExplanatory;
        }
        ComprehensionTlv comprehensiontlv1 = searchForNextTag(ComprehensionTlvTag.ALPHA_ID, iterator);
        if(comprehensiontlv1 != null)
            textmessage1.text = ValueParser.retrieveAlphaId(comprehensiontlv1);
        ComprehensionTlv comprehensiontlv2 = searchForTag(ComprehensionTlvTag.ICON_ID, list);
        if(comprehensiontlv2 != null) {
            iconid1 = ValueParser.retrieveIconId(comprehensiontlv2);
            textmessage1.iconSelfExplanatory = iconid1.selfExplanatory;
        }
        mCmdParams = new CallSetupParams(commanddetails, textmessage, textmessage1);
        boolean flag;
        if(iconid != null || iconid1 != null) {
            mIconLoadState = 2;
            int ai[] = new int[2];
            int j;
            if(iconid != null)
                j = iconid.recordNumber;
            else
                j = i;
            ai[0] = j;
            if(iconid1 != null)
                i = iconid1.recordNumber;
            ai[1] = i;
            mIconLoader.loadIcons(ai, obtainMessage(1));
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    private ComprehensionTlv searchForNextTag(ComprehensionTlvTag comprehensiontlvtag, Iterator iterator) {
        int i = comprehensiontlvtag.value();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ComprehensionTlv comprehensiontlv = (ComprehensionTlv)iterator.next();
        if(comprehensiontlv.getTag() != i) goto _L4; else goto _L3
_L3:
        return comprehensiontlv;
_L2:
        comprehensiontlv = null;
        if(true) goto _L3; else goto _L5
_L5:
    }

    private ComprehensionTlv searchForTag(ComprehensionTlvTag comprehensiontlvtag, List list) {
        return searchForNextTag(comprehensiontlvtag, list.iterator());
    }

    private void sendCmdParams(ResultCode resultcode) {
        mCaller.sendMsgParamsDecoded(resultcode, mCmdParams);
    }

    private ResultCode setIcons(Object obj) {
        if(obj != null) goto _L2; else goto _L1
_L1:
        ResultCode resultcode = ResultCode.PRFRMD_ICON_NOT_DISPLAYED;
_L4:
        return resultcode;
_L2:
        switch(mIconLoadState) {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_63;
_L5:
        resultcode = ResultCode.OK;
        if(true) goto _L4; else goto _L3
_L3:
        mCmdParams.setIcon((Bitmap)obj);
          goto _L5
        Bitmap abitmap[] = (Bitmap[])(Bitmap[])obj;
        int i = abitmap.length;
        int j = 0;
        while(j < i)  {
            Bitmap bitmap = abitmap[j];
            mCmdParams.setIcon(bitmap);
            j++;
        }
          goto _L5
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        sendCmdParams(setIcons(message.obj));
        if(true) goto _L1; else goto _L3
_L3:
    }

    void make(BerTlv bertlv) {
        List list;
        CommandDetails commanddetails;
        AppInterface.CommandType commandtype;
        if(bertlv != null) {
            mCmdParams = null;
            mIconLoadState = 0;
            if(bertlv.getTag() != 208) {
                sendCmdParams(ResultCode.CMD_TYPE_NOT_UNDERSTOOD);
            } else {
                list = bertlv.getComprehensionTlvs();
                commanddetails = processCommandDetails(list);
                if(commanddetails == null) {
                    sendCmdParams(ResultCode.CMD_TYPE_NOT_UNDERSTOOD);
                } else {
label0:
                    {
                        commandtype = AppInterface.CommandType.fromInt(commanddetails.typeOfCommand);
                        if(commandtype != null)
                            break label0;
                        mCmdParams = new CommandParams(commanddetails);
                        sendCmdParams(ResultCode.BEYOND_TERMINAL_CAPABILITY);
                    }
                }
            }
        }
_L15:
        return;
        class _cls1 {

            static final int $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[];

            static  {
                $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType = new int[AppInterface.CommandType.values().length];
                NoSuchFieldError nosuchfielderror18;
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SET_UP_MENU.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SELECT_ITEM.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.DISPLAY_TEXT.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SET_UP_IDLE_MODE_TEXT.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.GET_INKEY.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.GET_INPUT.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_DTMF.ordinal()] = 7;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_SMS.ordinal()] = 8;
                }
                catch(NoSuchFieldError nosuchfielderror7) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_SS.ordinal()] = 9;
                }
                catch(NoSuchFieldError nosuchfielderror8) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_USSD.ordinal()] = 10;
                }
                catch(NoSuchFieldError nosuchfielderror9) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SET_UP_CALL.ordinal()] = 11;
                }
                catch(NoSuchFieldError nosuchfielderror10) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.REFRESH.ordinal()] = 12;
                }
                catch(NoSuchFieldError nosuchfielderror11) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.LAUNCH_BROWSER.ordinal()] = 13;
                }
                catch(NoSuchFieldError nosuchfielderror12) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.PLAY_TONE.ordinal()] = 14;
                }
                catch(NoSuchFieldError nosuchfielderror13) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.PROVIDE_LOCAL_INFORMATION.ordinal()] = 15;
                }
                catch(NoSuchFieldError nosuchfielderror14) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.OPEN_CHANNEL.ordinal()] = 16;
                }
                catch(NoSuchFieldError nosuchfielderror15) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.CLOSE_CHANNEL.ordinal()] = 17;
                }
                catch(NoSuchFieldError nosuchfielderror16) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.RECEIVE_DATA.ordinal()] = 18;
                }
                catch(NoSuchFieldError nosuchfielderror17) { }
                $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_DATA.ordinal()] = 19;
_L2:
                return;
                nosuchfielderror18;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.com.android.internal.telephony.cat.AppInterface.CommandType[commandtype.ordinal()];
        JVM INSTR tableswitch 1 19: default 196
    //                   1 269
    //                   2 296
    //                   3 307
    //                   4 318
    //                   5 329
    //                   6 340
    //                   7 351
    //                   8 351
    //                   9 351
    //                   10 351
    //                   11 362
    //                   12 373
    //                   13 386
    //                   14 397
    //                   15 408
    //                   16 419
    //                   17 419
    //                   18 419
    //                   19 419;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L8 _L8 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L14 _L14 _L14
_L1:
        mCmdParams = new CommandParams(commanddetails);
        sendCmdParams(ResultCode.BEYOND_TERMINAL_CAPABILITY);
          goto _L15
        ResultException resultexception;
        resultexception;
        CatLog.d(this, (new StringBuilder()).append("make: caught ResultException e=").append(resultexception).toString());
        mCmdParams = new CommandParams(commanddetails);
        sendCmdParams(resultexception.result());
          goto _L15
_L2:
        boolean flag2 = processSelectItem(commanddetails, list);
        boolean flag1 = flag2;
_L16:
        if(!flag1)
            sendCmdParams(ResultCode.OK);
          goto _L15
_L3:
        flag1 = processSelectItem(commanddetails, list);
          goto _L16
_L4:
        flag1 = processDisplayText(commanddetails, list);
          goto _L16
_L5:
        flag1 = processSetUpIdleModeText(commanddetails, list);
          goto _L16
_L6:
        flag1 = processGetInkey(commanddetails, list);
          goto _L16
_L7:
        flag1 = processGetInput(commanddetails, list);
          goto _L16
_L8:
        flag1 = processEventNotify(commanddetails, list);
          goto _L16
_L9:
        flag1 = processSetupCall(commanddetails, list);
          goto _L16
_L10:
        processRefresh(commanddetails, list);
        flag1 = false;
          goto _L16
_L11:
        flag1 = processLaunchBrowser(commanddetails, list);
          goto _L16
_L12:
        flag1 = processPlayTone(commanddetails, list);
          goto _L16
_L13:
        flag1 = processProvideLocalInfo(commanddetails, list);
          goto _L16
_L14:
        boolean flag = processBIPClient(commanddetails, list);
        flag1 = flag;
          goto _L16
    }

    static final int DTTZ_SETTING = 3;
    static final int LANGUAGE_SETTING = 4;
    static final int LOAD_MULTI_ICONS = 2;
    static final int LOAD_NO_ICON = 0;
    static final int LOAD_SINGLE_ICON = 1;
    static final int MSG_ID_LOAD_ICON_DONE = 1;
    static final int REFRESH_NAA_INIT = 3;
    static final int REFRESH_NAA_INIT_AND_FILE_CHANGE = 2;
    static final int REFRESH_NAA_INIT_AND_FULL_FILE_CHANGE = 0;
    static final int REFRESH_UICC_RESET = 4;
    private static CommandParamsFactory sInstance = null;
    private RilMessageDecoder mCaller;
    private CommandParams mCmdParams;
    private int mIconLoadState;
    private IconLoader mIconLoader;

}
