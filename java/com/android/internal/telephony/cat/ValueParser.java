// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import com.android.internal.telephony.GsmAlphabet;
import com.android.internal.telephony.IccUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.android.internal.telephony.cat:
//            ResultException, ComprehensionTlv, ResultCode, CommandDetails, 
//            DeviceIdentities, Duration, IconId, Item, 
//            CatLog, ItemsIconId, TextAlignment, FontSize, 
//            TextAttribute, TextColor

abstract class ValueParser {

    ValueParser() {
    }

    static String retrieveAlphaId(ComprehensionTlv comprehensiontlv) throws ResultException {
        String s;
        if(comprehensiontlv != null) {
            byte abyte0[] = comprehensiontlv.getRawValue();
            int i = comprehensiontlv.getValueIndex();
            int j = comprehensiontlv.getLength();
            if(j != 0) {
                String s1;
                try {
                    s1 = IccUtils.adnStringFieldToString(abyte0, i, j);
                }
                catch(IndexOutOfBoundsException indexoutofboundsexception) {
                    throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                }
                s = s1;
            } else {
                s = "Defualt Message";
            }
        } else {
            s = "Defualt Message";
        }
        return s;
    }

    static CommandDetails retrieveCommandDetails(ComprehensionTlv comprehensiontlv) throws ResultException {
        CommandDetails commanddetails = new CommandDetails();
        byte abyte0[] = comprehensiontlv.getRawValue();
        int i = comprehensiontlv.getValueIndex();
        try {
            commanddetails.compRequired = comprehensiontlv.isComprehensionRequired();
            commanddetails.commandNumber = 0xff & abyte0[i];
            commanddetails.typeOfCommand = 0xff & abyte0[i + 1];
            commanddetails.commandQualifier = 0xff & abyte0[i + 2];
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
        return commanddetails;
    }

    static DeviceIdentities retrieveDeviceIdentities(ComprehensionTlv comprehensiontlv) throws ResultException {
        DeviceIdentities deviceidentities = new DeviceIdentities();
        byte abyte0[] = comprehensiontlv.getRawValue();
        int i = comprehensiontlv.getValueIndex();
        try {
            deviceidentities.sourceId = 0xff & abyte0[i];
            deviceidentities.destinationId = 0xff & abyte0[i + 1];
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception) {
            throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
        }
        return deviceidentities;
    }

    static Duration retrieveDuration(ComprehensionTlv comprehensiontlv) throws ResultException {
        Duration.TimeUnit _tmp = Duration.TimeUnit.SECOND;
        byte abyte0[] = comprehensiontlv.getRawValue();
        int i = comprehensiontlv.getValueIndex();
        Duration.TimeUnit timeunit;
        byte byte0;
        try {
            timeunit = Duration.TimeUnit.values()[0xff & abyte0[i]];
            byte0 = abyte0[i + 1];
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
        return new Duration(byte0 & 0xff, timeunit);
    }

    static IconId retrieveIconId(ComprehensionTlv comprehensiontlv) throws ResultException {
        IconId iconid;
        byte abyte0[];
        int i;
        int j;
        iconid = new IconId();
        abyte0 = comprehensiontlv.getRawValue();
        i = comprehensiontlv.getValueIndex();
        j = i + 1;
        boolean flag;
        if((0xff & abyte0[i]) != 0)
            break MISSING_BLOCK_LABEL_56;
        flag = true;
_L1:
        iconid.selfExplanatory = flag;
        iconid.recordNumber = 0xff & abyte0[j];
        return iconid;
        flag = false;
          goto _L1
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
    }

    static Item retrieveItem(ComprehensionTlv comprehensiontlv) throws ResultException {
        Item item = null;
        byte abyte0[] = comprehensiontlv.getRawValue();
        int i = comprehensiontlv.getValueIndex();
        int j = comprehensiontlv.getLength();
        if(j != 0) {
            int k = j - 1;
            try {
                item = new Item(0xff & abyte0[i], IccUtils.adnStringFieldToString(abyte0, i + 1, k));
            }
            catch(IndexOutOfBoundsException indexoutofboundsexception) {
                throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            }
        }
        return item;
    }

    static int retrieveItemId(ComprehensionTlv comprehensiontlv) throws ResultException {
        byte abyte0[] = comprehensiontlv.getRawValue();
        int i = comprehensiontlv.getValueIndex();
        byte byte0;
        try {
            byte0 = abyte0[i];
        }
        catch(IndexOutOfBoundsException indexoutofboundsexception) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
        return byte0 & 0xff;
    }

    static ItemsIconId retrieveItemsIconId(ComprehensionTlv comprehensiontlv) throws ResultException {
        ItemsIconId itemsiconid;
        byte abyte0[];
        int i;
        int j;
        int k;
        CatLog.d("ValueParser", "retrieveItemsIconId:");
        itemsiconid = new ItemsIconId();
        abyte0 = comprehensiontlv.getRawValue();
        i = comprehensiontlv.getValueIndex();
        j = -1 + comprehensiontlv.getLength();
        itemsiconid.recordNumbers = new int[j];
        k = i + 1;
        if((0xff & abyte0[i]) != 0) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L6:
        int l;
        itemsiconid.selfExplanatory = flag;
        l = 0;
_L5:
        if(l >= j) goto _L4; else goto _L3
_L3:
        int ai[] = itemsiconid.recordNumbers;
        int i1;
        int j1;
        i1 = l + 1;
        j1 = k + 1;
        ai[l] = abyte0[k];
        l = i1;
        k = j1;
          goto _L5
_L2:
        flag = false;
          goto _L6
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        k;
_L8:
        throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
_L4:
        return itemsiconid;
        IndexOutOfBoundsException indexoutofboundsexception1;
        indexoutofboundsexception1;
        if(true) goto _L8; else goto _L7
_L7:
    }

    static List retrieveTextAttribute(ComprehensionTlv comprehensiontlv) throws ResultException {
        ArrayList arraylist;
        byte abyte0[];
        int i;
        int j;
        arraylist = new ArrayList();
        abyte0 = comprehensiontlv.getRawValue();
        i = comprehensiontlv.getValueIndex();
        j = comprehensiontlv.getLength();
        if(j == 0) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        k = j / 4;
        l = 0;
_L6:
        if(l >= k) goto _L4; else goto _L3
_L3:
        int i1;
        int j1;
        int k1;
        int l1;
        TextAlignment textalignment;
        FontSize fontsize;
        i1 = 0xff & abyte0[i];
        j1 = 0xff & abyte0[i + 1];
        k1 = 0xff & abyte0[i + 2];
        l1 = 0xff & abyte0[i + 3];
        textalignment = TextAlignment.fromInt(k1 & 3);
        fontsize = FontSize.fromInt(3 & k1 >> 2);
        if(fontsize == null)
            fontsize = FontSize.NORMAL;
          goto _L5
_L10:
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        TextAttribute textattribute = new TextAttribute(i1, j1, textalignment, fontsize, flag, flag1, flag2, flag3, TextColor.fromInt(l1));
        arraylist.add(textattribute);
        l++;
        i += 4;
          goto _L6
_L12:
        flag = false;
          goto _L7
_L14:
        flag1 = false;
          goto _L8
_L16:
        flag2 = false;
          goto _L9
_L18:
        flag3 = false;
          goto _L10
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
_L2:
        arraylist = null;
_L4:
        return arraylist;
_L5:
        if((k1 & 0x10) == 0) goto _L12; else goto _L11
_L11:
        flag = true;
_L7:
        if((k1 & 0x20) == 0) goto _L14; else goto _L13
_L13:
        flag1 = true;
_L8:
        if((k1 & 0x40) == 0) goto _L16; else goto _L15
_L15:
        flag2 = true;
_L9:
        if((k1 & 0x80) == 0) goto _L18; else goto _L17
_L17:
        flag3 = true;
          goto _L10
    }

    static String retrieveTextString(ComprehensionTlv comprehensiontlv) throws ResultException {
        byte abyte0[] = comprehensiontlv.getRawValue();
        int i = comprehensiontlv.getValueIndex();
        int j = comprehensiontlv.getLength();
        String s1;
        if(j == 0) {
            s1 = null;
        } else {
            int k = j - 1;
            String s;
            try {
                byte byte0 = (byte)(0xc & abyte0[i]);
                if(byte0 == 0)
                    s = GsmAlphabet.gsm7BitPackedToString(abyte0, i + 1, (k * 8) / 7);
                else
                if(byte0 == 4)
                    s = GsmAlphabet.gsm8BitUnpackedToString(abyte0, i + 1, k);
                else
                if(byte0 == 8)
                    s = new String(abyte0, i + 1, k, "UTF-16");
                else
                    throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            }
            catch(IndexOutOfBoundsException indexoutofboundsexception) {
                throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            }
            catch(UnsupportedEncodingException unsupportedencodingexception) {
                throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            }
            s1 = s;
        }
        return s1;
    }
}
