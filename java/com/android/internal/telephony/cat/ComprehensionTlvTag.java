// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;


public final class ComprehensionTlvTag extends Enum {

    private ComprehensionTlvTag(String s, int i, int j) {
        super(s, i);
        mValue = j;
    }

    public static ComprehensionTlvTag fromInt(int i) {
        ComprehensionTlvTag acomprehensiontlvtag[];
        int j;
        int k;
        acomprehensiontlvtag = values();
        j = acomprehensiontlvtag.length;
        k = 0;
_L3:
        ComprehensionTlvTag comprehensiontlvtag;
        if(k >= j)
            break MISSING_BLOCK_LABEL_37;
        comprehensiontlvtag = acomprehensiontlvtag[k];
        if(comprehensiontlvtag.mValue != i) goto _L2; else goto _L1
_L1:
        return comprehensiontlvtag;
_L2:
        k++;
          goto _L3
        comprehensiontlvtag = null;
          goto _L1
    }

    public static ComprehensionTlvTag valueOf(String s) {
        return (ComprehensionTlvTag)Enum.valueOf(com/android/internal/telephony/cat/ComprehensionTlvTag, s);
    }

    public static ComprehensionTlvTag[] values() {
        return (ComprehensionTlvTag[])$VALUES.clone();
    }

    public int value() {
        return mValue;
    }

    private static final ComprehensionTlvTag $VALUES[];
    public static final ComprehensionTlvTag ADDRESS;
    public static final ComprehensionTlvTag ALPHA_ID;
    public static final ComprehensionTlvTag BROWSER_TERMINATION_CAUSE;
    public static final ComprehensionTlvTag COMMAND_DETAILS;
    public static final ComprehensionTlvTag DEFAULT_TEXT;
    public static final ComprehensionTlvTag DEVICE_IDENTITIES;
    public static final ComprehensionTlvTag DURATION;
    public static final ComprehensionTlvTag EVENT_LIST;
    public static final ComprehensionTlvTag FILE_LIST;
    public static final ComprehensionTlvTag HELP_REQUEST;
    public static final ComprehensionTlvTag ICON_ID;
    public static final ComprehensionTlvTag IMMEDIATE_RESPONSE;
    public static final ComprehensionTlvTag ITEM;
    public static final ComprehensionTlvTag ITEM_ICON_ID_LIST;
    public static final ComprehensionTlvTag ITEM_ID;
    public static final ComprehensionTlvTag LANGUAGE;
    public static final ComprehensionTlvTag RESPONSE_LENGTH;
    public static final ComprehensionTlvTag RESULT;
    public static final ComprehensionTlvTag SMS_TPDU;
    public static final ComprehensionTlvTag TEXT_ATTRIBUTE;
    public static final ComprehensionTlvTag TEXT_STRING;
    public static final ComprehensionTlvTag TONE;
    public static final ComprehensionTlvTag URL;
    public static final ComprehensionTlvTag USSD_STRING;
    private int mValue;

    static  {
        COMMAND_DETAILS = new ComprehensionTlvTag("COMMAND_DETAILS", 0, 1);
        DEVICE_IDENTITIES = new ComprehensionTlvTag("DEVICE_IDENTITIES", 1, 2);
        RESULT = new ComprehensionTlvTag("RESULT", 2, 3);
        DURATION = new ComprehensionTlvTag("DURATION", 3, 4);
        ALPHA_ID = new ComprehensionTlvTag("ALPHA_ID", 4, 5);
        ADDRESS = new ComprehensionTlvTag("ADDRESS", 5, 6);
        USSD_STRING = new ComprehensionTlvTag("USSD_STRING", 6, 10);
        SMS_TPDU = new ComprehensionTlvTag("SMS_TPDU", 7, 11);
        TEXT_STRING = new ComprehensionTlvTag("TEXT_STRING", 8, 13);
        TONE = new ComprehensionTlvTag("TONE", 9, 14);
        ITEM = new ComprehensionTlvTag("ITEM", 10, 15);
        ITEM_ID = new ComprehensionTlvTag("ITEM_ID", 11, 16);
        RESPONSE_LENGTH = new ComprehensionTlvTag("RESPONSE_LENGTH", 12, 17);
        FILE_LIST = new ComprehensionTlvTag("FILE_LIST", 13, 18);
        HELP_REQUEST = new ComprehensionTlvTag("HELP_REQUEST", 14, 21);
        DEFAULT_TEXT = new ComprehensionTlvTag("DEFAULT_TEXT", 15, 23);
        EVENT_LIST = new ComprehensionTlvTag("EVENT_LIST", 16, 25);
        ICON_ID = new ComprehensionTlvTag("ICON_ID", 17, 30);
        ITEM_ICON_ID_LIST = new ComprehensionTlvTag("ITEM_ICON_ID_LIST", 18, 31);
        IMMEDIATE_RESPONSE = new ComprehensionTlvTag("IMMEDIATE_RESPONSE", 19, 43);
        LANGUAGE = new ComprehensionTlvTag("LANGUAGE", 20, 45);
        URL = new ComprehensionTlvTag("URL", 21, 49);
        BROWSER_TERMINATION_CAUSE = new ComprehensionTlvTag("BROWSER_TERMINATION_CAUSE", 22, 52);
        TEXT_ATTRIBUTE = new ComprehensionTlvTag("TEXT_ATTRIBUTE", 23, 80);
        ComprehensionTlvTag acomprehensiontlvtag[] = new ComprehensionTlvTag[24];
        acomprehensiontlvtag[0] = COMMAND_DETAILS;
        acomprehensiontlvtag[1] = DEVICE_IDENTITIES;
        acomprehensiontlvtag[2] = RESULT;
        acomprehensiontlvtag[3] = DURATION;
        acomprehensiontlvtag[4] = ALPHA_ID;
        acomprehensiontlvtag[5] = ADDRESS;
        acomprehensiontlvtag[6] = USSD_STRING;
        acomprehensiontlvtag[7] = SMS_TPDU;
        acomprehensiontlvtag[8] = TEXT_STRING;
        acomprehensiontlvtag[9] = TONE;
        acomprehensiontlvtag[10] = ITEM;
        acomprehensiontlvtag[11] = ITEM_ID;
        acomprehensiontlvtag[12] = RESPONSE_LENGTH;
        acomprehensiontlvtag[13] = FILE_LIST;
        acomprehensiontlvtag[14] = HELP_REQUEST;
        acomprehensiontlvtag[15] = DEFAULT_TEXT;
        acomprehensiontlvtag[16] = EVENT_LIST;
        acomprehensiontlvtag[17] = ICON_ID;
        acomprehensiontlvtag[18] = ITEM_ICON_ID_LIST;
        acomprehensiontlvtag[19] = IMMEDIATE_RESPONSE;
        acomprehensiontlvtag[20] = LANGUAGE;
        acomprehensiontlvtag[21] = URL;
        acomprehensiontlvtag[22] = BROWSER_TERMINATION_CAUSE;
        acomprehensiontlvtag[23] = TEXT_ATTRIBUTE;
        $VALUES = acomprehensiontlvtag;
    }
}
