// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import com.android.internal.util.HexDump;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class SmsHeader {
    public static class MiscElt {

        public byte data[];
        public int id;

        public MiscElt() {
        }
    }

    public static class ConcatRef {

        public boolean isEightBits;
        public int msgCount;
        public int refNumber;
        public int seqNumber;

        public ConcatRef() {
        }
    }

    public static class PortAddrs {

        public boolean areEightBits;
        public int destPort;
        public int origPort;

        public PortAddrs() {
        }
    }


    public SmsHeader() {
        miscEltList = new ArrayList();
    }

    public static SmsHeader fromByteArray(byte abyte0[]) {
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
        SmsHeader smsheader = new SmsHeader();
        do {
            if(bytearrayinputstream.available() <= 0)
                break;
            int i = bytearrayinputstream.read();
            int j = bytearrayinputstream.read();
            switch(i) {
            default:
                MiscElt miscelt = new MiscElt();
                miscelt.id = i;
                miscelt.data = new byte[j];
                bytearrayinputstream.read(miscelt.data, 0, j);
                smsheader.miscEltList.add(miscelt);
                break;

            case 0: // '\0'
                ConcatRef concatref1 = new ConcatRef();
                concatref1.refNumber = bytearrayinputstream.read();
                concatref1.msgCount = bytearrayinputstream.read();
                concatref1.seqNumber = bytearrayinputstream.read();
                concatref1.isEightBits = true;
                if(concatref1.msgCount != 0 && concatref1.seqNumber != 0 && concatref1.seqNumber <= concatref1.msgCount)
                    smsheader.concatRef = concatref1;
                break;

            case 8: // '\b'
                ConcatRef concatref = new ConcatRef();
                concatref.refNumber = bytearrayinputstream.read() << 8 | bytearrayinputstream.read();
                concatref.msgCount = bytearrayinputstream.read();
                concatref.seqNumber = bytearrayinputstream.read();
                concatref.isEightBits = false;
                if(concatref.msgCount != 0 && concatref.seqNumber != 0 && concatref.seqNumber <= concatref.msgCount)
                    smsheader.concatRef = concatref;
                break;

            case 4: // '\004'
                PortAddrs portaddrs1 = new PortAddrs();
                portaddrs1.destPort = bytearrayinputstream.read();
                portaddrs1.origPort = bytearrayinputstream.read();
                portaddrs1.areEightBits = true;
                smsheader.portAddrs = portaddrs1;
                break;

            case 5: // '\005'
                PortAddrs portaddrs = new PortAddrs();
                portaddrs.destPort = bytearrayinputstream.read() << 8 | bytearrayinputstream.read();
                portaddrs.origPort = bytearrayinputstream.read() << 8 | bytearrayinputstream.read();
                portaddrs.areEightBits = false;
                smsheader.portAddrs = portaddrs;
                break;

            case 36: // '$'
                smsheader.languageShiftTable = bytearrayinputstream.read();
                break;

            case 37: // '%'
                smsheader.languageTable = bytearrayinputstream.read();
                break;
            }
        } while(true);
        return smsheader;
    }

    public static byte[] toByteArray(SmsHeader smsheader) {
        byte abyte0[];
        if(smsheader.portAddrs == null && smsheader.concatRef == null && smsheader.miscEltList.isEmpty() && smsheader.languageShiftTable == 0 && smsheader.languageTable == 0) {
            abyte0 = null;
        } else {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(140);
            ConcatRef concatref = smsheader.concatRef;
            PortAddrs portaddrs;
            if(concatref != null) {
                Iterator iterator;
                MiscElt miscelt;
                if(concatref.isEightBits) {
                    bytearrayoutputstream.write(0);
                    bytearrayoutputstream.write(3);
                    bytearrayoutputstream.write(concatref.refNumber);
                } else {
                    bytearrayoutputstream.write(8);
                    bytearrayoutputstream.write(4);
                    bytearrayoutputstream.write(concatref.refNumber >>> 8);
                    bytearrayoutputstream.write(0xff & concatref.refNumber);
                }
                bytearrayoutputstream.write(concatref.msgCount);
                bytearrayoutputstream.write(concatref.seqNumber);
            }
            portaddrs = smsheader.portAddrs;
            if(portaddrs != null)
                if(portaddrs.areEightBits) {
                    bytearrayoutputstream.write(4);
                    bytearrayoutputstream.write(2);
                    bytearrayoutputstream.write(portaddrs.destPort);
                    bytearrayoutputstream.write(portaddrs.origPort);
                } else {
                    bytearrayoutputstream.write(5);
                    bytearrayoutputstream.write(4);
                    bytearrayoutputstream.write(portaddrs.destPort >>> 8);
                    bytearrayoutputstream.write(0xff & portaddrs.destPort);
                    bytearrayoutputstream.write(portaddrs.origPort >>> 8);
                    bytearrayoutputstream.write(0xff & portaddrs.origPort);
                }
            if(smsheader.languageShiftTable != 0) {
                bytearrayoutputstream.write(36);
                bytearrayoutputstream.write(1);
                bytearrayoutputstream.write(smsheader.languageShiftTable);
            }
            if(smsheader.languageTable != 0) {
                bytearrayoutputstream.write(37);
                bytearrayoutputstream.write(1);
                bytearrayoutputstream.write(smsheader.languageTable);
            }
            for(iterator = smsheader.miscEltList.iterator(); iterator.hasNext(); bytearrayoutputstream.write(miscelt.data, 0, miscelt.data.length)) {
                miscelt = (MiscElt)iterator.next();
                bytearrayoutputstream.write(miscelt.id);
                bytearrayoutputstream.write(miscelt.data.length);
            }

            abyte0 = bytearrayoutputstream.toByteArray();
        }
        return abyte0;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("UserDataHeader ");
        stringbuilder.append("{ ConcatRef ");
        if(concatRef == null) {
            stringbuilder.append("unset");
        } else {
            stringbuilder.append((new StringBuilder()).append("{ refNumber=").append(concatRef.refNumber).toString());
            stringbuilder.append((new StringBuilder()).append(", msgCount=").append(concatRef.msgCount).toString());
            stringbuilder.append((new StringBuilder()).append(", seqNumber=").append(concatRef.seqNumber).toString());
            stringbuilder.append((new StringBuilder()).append(", isEightBits=").append(concatRef.isEightBits).toString());
            stringbuilder.append(" }");
        }
        stringbuilder.append(", PortAddrs ");
        if(portAddrs == null) {
            stringbuilder.append("unset");
        } else {
            stringbuilder.append((new StringBuilder()).append("{ destPort=").append(portAddrs.destPort).toString());
            stringbuilder.append((new StringBuilder()).append(", origPort=").append(portAddrs.origPort).toString());
            stringbuilder.append((new StringBuilder()).append(", areEightBits=").append(portAddrs.areEightBits).toString());
            stringbuilder.append(" }");
        }
        if(languageShiftTable != 0)
            stringbuilder.append((new StringBuilder()).append(", languageShiftTable=").append(languageShiftTable).toString());
        if(languageTable != 0)
            stringbuilder.append((new StringBuilder()).append(", languageTable=").append(languageTable).toString());
        for(Iterator iterator = miscEltList.iterator(); iterator.hasNext(); stringbuilder.append(" }")) {
            MiscElt miscelt = (MiscElt)iterator.next();
            stringbuilder.append(", MiscElt ");
            stringbuilder.append((new StringBuilder()).append("{ id=").append(miscelt.id).toString());
            stringbuilder.append((new StringBuilder()).append(", length=").append(miscelt.data.length).toString());
            stringbuilder.append((new StringBuilder()).append(", data=").append(HexDump.toHexString(miscelt.data)).toString());
        }

        stringbuilder.append(" }");
        return stringbuilder.toString();
    }

    public static final int ELT_ID_APPLICATION_PORT_ADDRESSING_16_BIT = 5;
    public static final int ELT_ID_APPLICATION_PORT_ADDRESSING_8_BIT = 4;
    public static final int ELT_ID_CHARACTER_SIZE_WVG_OBJECT = 25;
    public static final int ELT_ID_COMPRESSION_CONTROL = 22;
    public static final int ELT_ID_CONCATENATED_16_BIT_REFERENCE = 8;
    public static final int ELT_ID_CONCATENATED_8_BIT_REFERENCE = 0;
    public static final int ELT_ID_ENHANCED_VOICE_MAIL_INFORMATION = 35;
    public static final int ELT_ID_EXTENDED_OBJECT = 20;
    public static final int ELT_ID_EXTENDED_OBJECT_DATA_REQUEST_CMD = 26;
    public static final int ELT_ID_HYPERLINK_FORMAT_ELEMENT = 33;
    public static final int ELT_ID_LARGE_ANIMATION = 14;
    public static final int ELT_ID_LARGE_PICTURE = 16;
    public static final int ELT_ID_NATIONAL_LANGUAGE_LOCKING_SHIFT = 37;
    public static final int ELT_ID_NATIONAL_LANGUAGE_SINGLE_SHIFT = 36;
    public static final int ELT_ID_OBJECT_DISTR_INDICATOR = 23;
    public static final int ELT_ID_PREDEFINED_ANIMATION = 13;
    public static final int ELT_ID_PREDEFINED_SOUND = 11;
    public static final int ELT_ID_REPLY_ADDRESS_ELEMENT = 34;
    public static final int ELT_ID_REUSED_EXTENDED_OBJECT = 21;
    public static final int ELT_ID_RFC_822_EMAIL_HEADER = 32;
    public static final int ELT_ID_SMALL_ANIMATION = 15;
    public static final int ELT_ID_SMALL_PICTURE = 17;
    public static final int ELT_ID_SMSC_CONTROL_PARAMS = 6;
    public static final int ELT_ID_SPECIAL_SMS_MESSAGE_INDICATION = 1;
    public static final int ELT_ID_STANDARD_WVG_OBJECT = 24;
    public static final int ELT_ID_TEXT_FORMATTING = 10;
    public static final int ELT_ID_UDH_SOURCE_INDICATION = 7;
    public static final int ELT_ID_USER_DEFINED_SOUND = 12;
    public static final int ELT_ID_USER_PROMPT_INDICATOR = 19;
    public static final int ELT_ID_VARIABLE_PICTURE = 18;
    public static final int ELT_ID_WIRELESS_CTRL_MSG_PROTOCOL = 9;
    public static final int PORT_WAP_PUSH = 2948;
    public static final int PORT_WAP_WSP = 9200;
    public ConcatRef concatRef;
    public int languageShiftTable;
    public int languageTable;
    public ArrayList miscEltList;
    public PortAddrs portAddrs;
}
