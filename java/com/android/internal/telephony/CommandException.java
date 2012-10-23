// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.util.Log;

public class CommandException extends RuntimeException {
    public static final class Error extends Enum {

        public static Error valueOf(String s) {
            return (Error)Enum.valueOf(com/android/internal/telephony/CommandException$Error, s);
        }

        public static Error[] values() {
            return (Error[])$VALUES.clone();
        }

        private static final Error $VALUES[];
        public static final Error FDN_CHECK_FAILURE;
        public static final Error GENERIC_FAILURE;
        public static final Error ILLEGAL_SIM_OR_ME;
        public static final Error INVALID_RESPONSE;
        public static final Error MODE_NOT_SUPPORTED;
        public static final Error OP_NOT_ALLOWED_BEFORE_REG_NW;
        public static final Error OP_NOT_ALLOWED_DURING_VOICE_CALL;
        public static final Error PASSWORD_INCORRECT;
        public static final Error RADIO_NOT_AVAILABLE;
        public static final Error REQUEST_NOT_SUPPORTED;
        public static final Error SIM_ABSENT;
        public static final Error SIM_PIN2;
        public static final Error SIM_PUK2;
        public static final Error SMS_FAIL_RETRY;
        public static final Error SUBSCRIPTION_NOT_AVAILABLE;

        static  {
            INVALID_RESPONSE = new Error("INVALID_RESPONSE", 0);
            RADIO_NOT_AVAILABLE = new Error("RADIO_NOT_AVAILABLE", 1);
            GENERIC_FAILURE = new Error("GENERIC_FAILURE", 2);
            PASSWORD_INCORRECT = new Error("PASSWORD_INCORRECT", 3);
            SIM_PIN2 = new Error("SIM_PIN2", 4);
            SIM_PUK2 = new Error("SIM_PUK2", 5);
            REQUEST_NOT_SUPPORTED = new Error("REQUEST_NOT_SUPPORTED", 6);
            OP_NOT_ALLOWED_DURING_VOICE_CALL = new Error("OP_NOT_ALLOWED_DURING_VOICE_CALL", 7);
            OP_NOT_ALLOWED_BEFORE_REG_NW = new Error("OP_NOT_ALLOWED_BEFORE_REG_NW", 8);
            SMS_FAIL_RETRY = new Error("SMS_FAIL_RETRY", 9);
            SIM_ABSENT = new Error("SIM_ABSENT", 10);
            SUBSCRIPTION_NOT_AVAILABLE = new Error("SUBSCRIPTION_NOT_AVAILABLE", 11);
            MODE_NOT_SUPPORTED = new Error("MODE_NOT_SUPPORTED", 12);
            FDN_CHECK_FAILURE = new Error("FDN_CHECK_FAILURE", 13);
            ILLEGAL_SIM_OR_ME = new Error("ILLEGAL_SIM_OR_ME", 14);
            Error aerror[] = new Error[15];
            aerror[0] = INVALID_RESPONSE;
            aerror[1] = RADIO_NOT_AVAILABLE;
            aerror[2] = GENERIC_FAILURE;
            aerror[3] = PASSWORD_INCORRECT;
            aerror[4] = SIM_PIN2;
            aerror[5] = SIM_PUK2;
            aerror[6] = REQUEST_NOT_SUPPORTED;
            aerror[7] = OP_NOT_ALLOWED_DURING_VOICE_CALL;
            aerror[8] = OP_NOT_ALLOWED_BEFORE_REG_NW;
            aerror[9] = SMS_FAIL_RETRY;
            aerror[10] = SIM_ABSENT;
            aerror[11] = SUBSCRIPTION_NOT_AVAILABLE;
            aerror[12] = MODE_NOT_SUPPORTED;
            aerror[13] = FDN_CHECK_FAILURE;
            aerror[14] = ILLEGAL_SIM_OR_ME;
            $VALUES = aerror;
        }

        private Error(String s, int i) {
            super(s, i);
        }
    }


    public CommandException(Error error) {
        super(error.toString());
        e = error;
    }

    public static CommandException fromRilErrno(int i) {
        i;
        JVM INSTR tableswitch -1 15: default 84
    //                   -1 127
    //                   0 122
    //                   1 141
    //                   2 155
    //                   3 169
    //                   4 183
    //                   5 197
    //                   6 211
    //                   7 84
    //                   8 225
    //                   9 239
    //                   10 253
    //                   11 267
    //                   12 281
    //                   13 295
    //                   14 309
    //                   15 323;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L1 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L1:
        CommandException commandexception;
        Log.e("GSM", (new StringBuilder()).append("Unrecognized RIL errno ").append(i).toString());
        commandexception = new CommandException(Error.INVALID_RESPONSE);
_L19:
        return commandexception;
_L3:
        commandexception = null;
        continue; /* Loop/switch isn't completed */
_L2:
        commandexception = new CommandException(Error.INVALID_RESPONSE);
        continue; /* Loop/switch isn't completed */
_L4:
        commandexception = new CommandException(Error.RADIO_NOT_AVAILABLE);
        continue; /* Loop/switch isn't completed */
_L5:
        commandexception = new CommandException(Error.GENERIC_FAILURE);
        continue; /* Loop/switch isn't completed */
_L6:
        commandexception = new CommandException(Error.PASSWORD_INCORRECT);
        continue; /* Loop/switch isn't completed */
_L7:
        commandexception = new CommandException(Error.SIM_PIN2);
        continue; /* Loop/switch isn't completed */
_L8:
        commandexception = new CommandException(Error.SIM_PUK2);
        continue; /* Loop/switch isn't completed */
_L9:
        commandexception = new CommandException(Error.REQUEST_NOT_SUPPORTED);
        continue; /* Loop/switch isn't completed */
_L10:
        commandexception = new CommandException(Error.OP_NOT_ALLOWED_DURING_VOICE_CALL);
        continue; /* Loop/switch isn't completed */
_L11:
        commandexception = new CommandException(Error.OP_NOT_ALLOWED_BEFORE_REG_NW);
        continue; /* Loop/switch isn't completed */
_L12:
        commandexception = new CommandException(Error.SMS_FAIL_RETRY);
        continue; /* Loop/switch isn't completed */
_L13:
        commandexception = new CommandException(Error.SIM_ABSENT);
        continue; /* Loop/switch isn't completed */
_L14:
        commandexception = new CommandException(Error.SUBSCRIPTION_NOT_AVAILABLE);
        continue; /* Loop/switch isn't completed */
_L15:
        commandexception = new CommandException(Error.MODE_NOT_SUPPORTED);
        continue; /* Loop/switch isn't completed */
_L16:
        commandexception = new CommandException(Error.FDN_CHECK_FAILURE);
        continue; /* Loop/switch isn't completed */
_L17:
        commandexception = new CommandException(Error.ILLEGAL_SIM_OR_ME);
        if(true) goto _L19; else goto _L18
_L18:
    }

    public Error getCommandError() {
        return e;
    }

    private Error e;
}
