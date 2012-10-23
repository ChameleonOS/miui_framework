// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.telephony.PhoneNumberUtils;
import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.SmsAddress;

public class GsmSmsAddress extends SmsAddress {

    public GsmSmsAddress(byte abyte0[], int i, int j) {
        super.origBytes = new byte[j];
        System.arraycopy(abyte0, i, super.origBytes, 0, j);
        int k = 0xff & super.origBytes[0];
        int l = 0xff & super.origBytes[1];
        super.ton = 7 & l >> 4;
        if((l & 0x80) != 128)
            throw new RuntimeException("Invalid TOA - high bit must be set");
        if(isAlphanumeric()) {
            int j1 = (k * 4) / 7;
            super.address = GsmAlphabet.gsm7BitPackedToString(super.origBytes, 2, j1);
        } else {
            byte byte0 = super.origBytes[j - 1];
            if((k & 1) == 1) {
                byte abyte1[] = super.origBytes;
                int i1 = j - 1;
                abyte1[i1] = (byte)(0xf0 | abyte1[i1]);
            }
            super.address = PhoneNumberUtils.calledPartyBCDToString(super.origBytes, 1, j - 1);
            super.origBytes[j - 1] = byte0;
        }
    }

    public String getAddressString() {
        return super.address;
    }

    public boolean isAlphanumeric() {
        boolean flag;
        if(super.ton == 5)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isCphsVoiceMessageClear() {
        boolean flag;
        if(isCphsVoiceMessageIndicatorAddress() && (0xff & super.origBytes[2]) == 16)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isCphsVoiceMessageIndicatorAddress() {
        boolean flag = true;
        if((0xff & super.origBytes[0]) != 4 || !isAlphanumeric() || (0xf & super.origBytes[flag]) != 0)
            flag = false;
        return flag;
    }

    public boolean isCphsVoiceMessageSet() {
        boolean flag;
        if(isCphsVoiceMessageIndicatorAddress() && (0xff & super.origBytes[2]) == 17)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isNetworkSpecific() {
        boolean flag;
        if(super.ton == 3)
            flag = true;
        else
            flag = false;
        return flag;
    }

    static final int OFFSET_ADDRESS_LENGTH = 0;
    static final int OFFSET_ADDRESS_VALUE = 2;
    static final int OFFSET_TOA = 1;
}
