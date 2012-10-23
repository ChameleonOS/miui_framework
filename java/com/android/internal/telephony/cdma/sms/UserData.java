// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma.sms;

import android.util.SparseIntArray;
import com.android.internal.telephony.SmsHeader;
import com.android.internal.util.HexDump;

public class UserData {

    public UserData() {
        msgEncodingSet = false;
    }

    public static byte[] stringToAscii(String s) {
        int i = s.length();
        byte abyte0[] = new byte[i];
        int j = 0;
        do {
            int k;
label0:
            {
                if(j < i) {
                    k = charToAscii.get(s.charAt(j), -1);
                    if(k != -1)
                        break label0;
                    abyte0 = null;
                }
                return abyte0;
            }
            abyte0[j] = (byte)k;
            j++;
        } while(true);
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("UserData ");
        StringBuilder stringbuilder1 = (new StringBuilder()).append("{ msgEncoding=");
        Object obj;
        if(msgEncodingSet)
            obj = Integer.valueOf(msgEncoding);
        else
            obj = "unset";
        stringbuilder.append(stringbuilder1.append(obj).toString());
        stringbuilder.append((new StringBuilder()).append(", msgType=").append(msgType).toString());
        stringbuilder.append((new StringBuilder()).append(", paddingBits=").append(paddingBits).toString());
        stringbuilder.append((new StringBuilder()).append(", numFields=").append(numFields).toString());
        stringbuilder.append((new StringBuilder()).append(", userDataHeader=").append(userDataHeader).toString());
        stringbuilder.append((new StringBuilder()).append(", payload='").append(HexDump.toHexString(payload)).append("'").toString());
        stringbuilder.append((new StringBuilder()).append(", payloadStr='").append(payloadStr).append("'").toString());
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }

    public static final int ASCII_CR_INDEX = 13;
    public static final char ASCII_MAP[];
    public static final int ASCII_MAP_BASE_INDEX = 32;
    public static final int ASCII_MAP_MAX_INDEX = 0;
    public static final int ASCII_NL_INDEX = 10;
    public static final int ENCODING_7BIT_ASCII = 2;
    public static final int ENCODING_GSM_7BIT_ALPHABET = 9;
    public static final int ENCODING_GSM_DCS = 10;
    public static final int ENCODING_IA5 = 3;
    public static final int ENCODING_IS91_EXTENDED_PROTOCOL = 1;
    public static final int ENCODING_KOREAN = 6;
    public static final int ENCODING_LATIN = 8;
    public static final int ENCODING_LATIN_HEBREW = 7;
    public static final int ENCODING_OCTET = 0;
    public static final int ENCODING_SHIFT_JIS = 5;
    public static final int ENCODING_UNICODE_16 = 4;
    public static final int IS91_MSG_TYPE_CLI = 132;
    public static final int IS91_MSG_TYPE_SHORT_MESSAGE = 133;
    public static final int IS91_MSG_TYPE_SHORT_MESSAGE_FULL = 131;
    public static final int IS91_MSG_TYPE_VOICEMAIL_STATUS = 130;
    public static final int PRINTABLE_ASCII_MIN_INDEX = 32;
    static final byte UNENCODABLE_7_BIT_CHAR = 32;
    public static final SparseIntArray charToAscii;
    public int msgEncoding;
    public boolean msgEncodingSet;
    public int msgType;
    public int numFields;
    public int paddingBits;
    public byte payload[];
    public String payloadStr;
    public SmsHeader userDataHeader;

    static  {
        char ac[] = new char[95];
        ac[0] = ' ';
        ac[1] = '!';
        ac[2] = '"';
        ac[3] = '#';
        ac[4] = '$';
        ac[5] = '%';
        ac[6] = '&';
        ac[7] = '\'';
        ac[8] = '(';
        ac[9] = ')';
        ac[10] = '*';
        ac[11] = '+';
        ac[12] = ',';
        ac[13] = '-';
        ac[14] = '.';
        ac[15] = '/';
        ac[16] = '0';
        ac[17] = '1';
        ac[18] = '2';
        ac[19] = '3';
        ac[20] = '4';
        ac[21] = '5';
        ac[22] = '6';
        ac[23] = '7';
        ac[24] = '8';
        ac[25] = '9';
        ac[26] = ':';
        ac[27] = ';';
        ac[28] = '<';
        ac[29] = '=';
        ac[30] = '>';
        ac[31] = '?';
        ac[32] = '@';
        ac[33] = 'A';
        ac[34] = 'B';
        ac[35] = 'C';
        ac[36] = 'D';
        ac[37] = 'E';
        ac[38] = 'F';
        ac[39] = 'G';
        ac[40] = 'H';
        ac[41] = 'I';
        ac[42] = 'J';
        ac[43] = 'K';
        ac[44] = 'L';
        ac[45] = 'M';
        ac[46] = 'N';
        ac[47] = 'O';
        ac[48] = 'P';
        ac[49] = 'Q';
        ac[50] = 'R';
        ac[51] = 'S';
        ac[52] = 'T';
        ac[53] = 'U';
        ac[54] = 'V';
        ac[55] = 'W';
        ac[56] = 'X';
        ac[57] = 'Y';
        ac[58] = 'Z';
        ac[59] = '[';
        ac[60] = '\\';
        ac[61] = ']';
        ac[62] = '^';
        ac[63] = '_';
        ac[64] = '`';
        ac[65] = 'a';
        ac[66] = 'b';
        ac[67] = 'c';
        ac[68] = 'd';
        ac[69] = 'e';
        ac[70] = 'f';
        ac[71] = 'g';
        ac[72] = 'h';
        ac[73] = 'i';
        ac[74] = 'j';
        ac[75] = 'k';
        ac[76] = 'l';
        ac[77] = 'm';
        ac[78] = 'n';
        ac[79] = 'o';
        ac[80] = 'p';
        ac[81] = 'q';
        ac[82] = 'r';
        ac[83] = 's';
        ac[84] = 't';
        ac[85] = 'u';
        ac[86] = 'v';
        ac[87] = 'w';
        ac[88] = 'x';
        ac[89] = 'y';
        ac[90] = 'z';
        ac[91] = '{';
        ac[92] = '|';
        ac[93] = '}';
        ac[94] = '~';
        ASCII_MAP = ac;
        charToAscii = new SparseIntArray();
        for(int i = 0; i < ASCII_MAP.length; i++)
            charToAscii.put(ASCII_MAP[i], i + 32);

        charToAscii.put(10, 10);
        charToAscii.put(13, 13);
        ASCII_MAP_MAX_INDEX = -1 + (32 + ASCII_MAP.length);
    }
}
