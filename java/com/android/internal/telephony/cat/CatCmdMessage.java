// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.android.internal.telephony.cat:
//            CommandDetails, TextMessage, Menu, Input, 
//            LaunchBrowserMode, ToneSettings, CommandParams, SelectItemParams, 
//            DisplayTextParams, GetInputParams, LaunchBrowserParams, PlayToneParams, 
//            CallSetupParams, BIPClientParams

public class CatCmdMessage
    implements Parcelable {
    public class CallSettings {

        public TextMessage callMsg;
        public TextMessage confirmMsg;
        final CatCmdMessage this$0;

        public CallSettings() {
            this$0 = CatCmdMessage.this;
            super();
        }
    }

    public class BrowserSettings {

        public LaunchBrowserMode mode;
        final CatCmdMessage this$0;
        public String url;

        public BrowserSettings() {
            this$0 = CatCmdMessage.this;
            super();
        }
    }


    public CatCmdMessage(Parcel parcel) {
        mBrowserSettings = null;
        mToneSettings = null;
        mCallSettings = null;
        mCmdDet = (CommandDetails)parcel.readParcelable(null);
        mTextMsg = (TextMessage)parcel.readParcelable(null);
        mMenu = (Menu)parcel.readParcelable(null);
        mInput = (Input)parcel.readParcelable(null);
        class _cls2 {

            static final int $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[];

            static  {
                $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType = new int[AppInterface.CommandType.values().length];
                NoSuchFieldError nosuchfielderror16;
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
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_DTMF.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_SMS.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_SS.ordinal()] = 7;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_USSD.ordinal()] = 8;
                }
                catch(NoSuchFieldError nosuchfielderror7) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.GET_INPUT.ordinal()] = 9;
                }
                catch(NoSuchFieldError nosuchfielderror8) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.GET_INKEY.ordinal()] = 10;
                }
                catch(NoSuchFieldError nosuchfielderror9) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.LAUNCH_BROWSER.ordinal()] = 11;
                }
                catch(NoSuchFieldError nosuchfielderror10) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.PLAY_TONE.ordinal()] = 12;
                }
                catch(NoSuchFieldError nosuchfielderror11) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SET_UP_CALL.ordinal()] = 13;
                }
                catch(NoSuchFieldError nosuchfielderror12) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.OPEN_CHANNEL.ordinal()] = 14;
                }
                catch(NoSuchFieldError nosuchfielderror13) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.CLOSE_CHANNEL.ordinal()] = 15;
                }
                catch(NoSuchFieldError nosuchfielderror14) { }
                try {
                    $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.RECEIVE_DATA.ordinal()] = 16;
                }
                catch(NoSuchFieldError nosuchfielderror15) { }
                $SwitchMap$com$android$internal$telephony$cat$AppInterface$CommandType[AppInterface.CommandType.SEND_DATA.ordinal()] = 17;
_L2:
                return;
                nosuchfielderror16;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls2..SwitchMap.com.android.internal.telephony.cat.AppInterface.CommandType[getCmdType().ordinal()];
        JVM INSTR tableswitch 11 13: default 104
    //                   11 105
    //                   12 146
    //                   13 161;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        mBrowserSettings = new BrowserSettings();
        mBrowserSettings.url = parcel.readString();
        mBrowserSettings.mode = LaunchBrowserMode.values()[parcel.readInt()];
        continue; /* Loop/switch isn't completed */
_L3:
        mToneSettings = (ToneSettings)parcel.readParcelable(null);
        continue; /* Loop/switch isn't completed */
_L4:
        mCallSettings = new CallSettings();
        mCallSettings.confirmMsg = (TextMessage)parcel.readParcelable(null);
        mCallSettings.callMsg = (TextMessage)parcel.readParcelable(null);
        if(true) goto _L1; else goto _L5
_L5:
    }

    CatCmdMessage(CommandParams commandparams) {
        mBrowserSettings = null;
        mToneSettings = null;
        mCallSettings = null;
        mCmdDet = commandparams.cmdDet;
        _cls2..SwitchMap.com.android.internal.telephony.cat.AppInterface.CommandType[getCmdType().ordinal()];
        JVM INSTR tableswitch 1 17: default 120
    //                   1 121
    //                   2 121
    //                   3 135
    //                   4 135
    //                   5 135
    //                   6 135
    //                   7 135
    //                   8 135
    //                   9 149
    //                   10 149
    //                   11 163
    //                   12 217
    //                   13 241
    //                   14 284
    //                   15 284
    //                   16 284
    //                   17 284;
           goto _L1 _L2 _L2 _L3 _L3 _L3 _L3 _L3 _L3 _L4 _L4 _L5 _L6 _L7 _L8 _L8 _L8 _L8
_L1:
        return;
_L2:
        mMenu = ((SelectItemParams)commandparams).menu;
        continue; /* Loop/switch isn't completed */
_L3:
        mTextMsg = ((DisplayTextParams)commandparams).textMsg;
        continue; /* Loop/switch isn't completed */
_L4:
        mInput = ((GetInputParams)commandparams).input;
        continue; /* Loop/switch isn't completed */
_L5:
        mTextMsg = ((LaunchBrowserParams)commandparams).confirmMsg;
        mBrowserSettings = new BrowserSettings();
        mBrowserSettings.url = ((LaunchBrowserParams)commandparams).url;
        mBrowserSettings.mode = ((LaunchBrowserParams)commandparams).mode;
        continue; /* Loop/switch isn't completed */
_L6:
        PlayToneParams playtoneparams = (PlayToneParams)commandparams;
        mToneSettings = playtoneparams.settings;
        mTextMsg = playtoneparams.textMsg;
        continue; /* Loop/switch isn't completed */
_L7:
        mCallSettings = new CallSettings();
        mCallSettings.confirmMsg = ((CallSetupParams)commandparams).confirmMsg;
        mCallSettings.callMsg = ((CallSetupParams)commandparams).callMsg;
        continue; /* Loop/switch isn't completed */
_L8:
        mTextMsg = ((BIPClientParams)commandparams).textMsg;
        if(true) goto _L1; else goto _L9
_L9:
    }

    public int describeContents() {
        return 0;
    }

    public Input geInput() {
        return mInput;
    }

    public TextMessage geTextMessage() {
        return mTextMsg;
    }

    public BrowserSettings getBrowserSettings() {
        return mBrowserSettings;
    }

    public CallSettings getCallSettings() {
        return mCallSettings;
    }

    public AppInterface.CommandType getCmdType() {
        return AppInterface.CommandType.fromInt(mCmdDet.typeOfCommand);
    }

    public Menu getMenu() {
        return mMenu;
    }

    public ToneSettings getToneSettings() {
        return mToneSettings;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(mCmdDet, 0);
        parcel.writeParcelable(mTextMsg, 0);
        parcel.writeParcelable(mMenu, 0);
        parcel.writeParcelable(mInput, 0);
        _cls2..SwitchMap.com.android.internal.telephony.cat.AppInterface.CommandType[getCmdType().ordinal()];
        JVM INSTR tableswitch 11 13: default 72
    //                   11 73
    //                   12 101
    //                   13 113;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        parcel.writeString(mBrowserSettings.url);
        parcel.writeInt(mBrowserSettings.mode.ordinal());
        continue; /* Loop/switch isn't completed */
_L3:
        parcel.writeParcelable(mToneSettings, 0);
        continue; /* Loop/switch isn't completed */
_L4:
        parcel.writeParcelable(mCallSettings.confirmMsg, 0);
        parcel.writeParcelable(mCallSettings.callMsg, 0);
        if(true) goto _L1; else goto _L5
_L5:
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CatCmdMessage createFromParcel(Parcel parcel) {
            return new CatCmdMessage(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public CatCmdMessage[] newArray(int i) {
            return new CatCmdMessage[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private BrowserSettings mBrowserSettings;
    private CallSettings mCallSettings;
    CommandDetails mCmdDet;
    private Input mInput;
    private Menu mMenu;
    private TextMessage mTextMsg;
    private ToneSettings mToneSettings;

}
