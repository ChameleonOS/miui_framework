// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


// Referenced classes of package com.android.internal.telephony.cat:
//            CatResponseMessage

public interface AppInterface {
    public static final class CommandType extends Enum {

        public static CommandType fromInt(int i) {
            CommandType acommandtype[];
            int j;
            int k;
            acommandtype = values();
            j = acommandtype.length;
            k = 0;
_L3:
            CommandType commandtype;
            if(k >= j)
                break MISSING_BLOCK_LABEL_37;
            commandtype = acommandtype[k];
            if(commandtype.mValue != i) goto _L2; else goto _L1
_L1:
            return commandtype;
_L2:
            k++;
              goto _L3
            commandtype = null;
              goto _L1
        }

        public static CommandType valueOf(String s) {
            return (CommandType)Enum.valueOf(com/android/internal/telephony/cat/AppInterface$CommandType, s);
        }

        public static CommandType[] values() {
            return (CommandType[])$VALUES.clone();
        }

        public int value() {
            return mValue;
        }

        private static final CommandType $VALUES[];
        public static final CommandType CLOSE_CHANNEL;
        public static final CommandType DISPLAY_TEXT;
        public static final CommandType GET_INKEY;
        public static final CommandType GET_INPUT;
        public static final CommandType LAUNCH_BROWSER;
        public static final CommandType OPEN_CHANNEL;
        public static final CommandType PLAY_TONE;
        public static final CommandType PROVIDE_LOCAL_INFORMATION;
        public static final CommandType RECEIVE_DATA;
        public static final CommandType REFRESH;
        public static final CommandType SELECT_ITEM;
        public static final CommandType SEND_DATA;
        public static final CommandType SEND_DTMF;
        public static final CommandType SEND_SMS;
        public static final CommandType SEND_SS;
        public static final CommandType SEND_USSD;
        public static final CommandType SET_UP_CALL;
        public static final CommandType SET_UP_EVENT_LIST;
        public static final CommandType SET_UP_IDLE_MODE_TEXT;
        public static final CommandType SET_UP_MENU;
        private int mValue;

        static  {
            DISPLAY_TEXT = new CommandType("DISPLAY_TEXT", 0, 33);
            GET_INKEY = new CommandType("GET_INKEY", 1, 34);
            GET_INPUT = new CommandType("GET_INPUT", 2, 35);
            LAUNCH_BROWSER = new CommandType("LAUNCH_BROWSER", 3, 21);
            PLAY_TONE = new CommandType("PLAY_TONE", 4, 32);
            REFRESH = new CommandType("REFRESH", 5, 1);
            SELECT_ITEM = new CommandType("SELECT_ITEM", 6, 36);
            SEND_SS = new CommandType("SEND_SS", 7, 17);
            SEND_USSD = new CommandType("SEND_USSD", 8, 18);
            SEND_SMS = new CommandType("SEND_SMS", 9, 19);
            SEND_DTMF = new CommandType("SEND_DTMF", 10, 20);
            SET_UP_EVENT_LIST = new CommandType("SET_UP_EVENT_LIST", 11, 5);
            SET_UP_IDLE_MODE_TEXT = new CommandType("SET_UP_IDLE_MODE_TEXT", 12, 40);
            SET_UP_MENU = new CommandType("SET_UP_MENU", 13, 37);
            SET_UP_CALL = new CommandType("SET_UP_CALL", 14, 16);
            PROVIDE_LOCAL_INFORMATION = new CommandType("PROVIDE_LOCAL_INFORMATION", 15, 38);
            OPEN_CHANNEL = new CommandType("OPEN_CHANNEL", 16, 64);
            CLOSE_CHANNEL = new CommandType("CLOSE_CHANNEL", 17, 65);
            RECEIVE_DATA = new CommandType("RECEIVE_DATA", 18, 66);
            SEND_DATA = new CommandType("SEND_DATA", 19, 67);
            CommandType acommandtype[] = new CommandType[20];
            acommandtype[0] = DISPLAY_TEXT;
            acommandtype[1] = GET_INKEY;
            acommandtype[2] = GET_INPUT;
            acommandtype[3] = LAUNCH_BROWSER;
            acommandtype[4] = PLAY_TONE;
            acommandtype[5] = REFRESH;
            acommandtype[6] = SELECT_ITEM;
            acommandtype[7] = SEND_SS;
            acommandtype[8] = SEND_USSD;
            acommandtype[9] = SEND_SMS;
            acommandtype[10] = SEND_DTMF;
            acommandtype[11] = SET_UP_EVENT_LIST;
            acommandtype[12] = SET_UP_IDLE_MODE_TEXT;
            acommandtype[13] = SET_UP_MENU;
            acommandtype[14] = SET_UP_CALL;
            acommandtype[15] = PROVIDE_LOCAL_INFORMATION;
            acommandtype[16] = OPEN_CHANNEL;
            acommandtype[17] = CLOSE_CHANNEL;
            acommandtype[18] = RECEIVE_DATA;
            acommandtype[19] = SEND_DATA;
            $VALUES = acommandtype;
        }

        private CommandType(String s, int i, int j) {
            super(s, i);
            mValue = j;
        }
    }


    public abstract void onCmdResponse(CatResponseMessage catresponsemessage);

    public static final String CAT_CMD_ACTION = "android.intent.action.stk.command";
    public static final String CAT_SESSION_END_ACTION = "android.intent.action.stk.session_end";
}
