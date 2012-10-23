// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

// Referenced classes of package com.google.android.mms.pdu:
//            PduContentTypes, GenericPdu, EncodedStringValue, PduHeaders, 
//            SendReq, PduBody, PduPart

public class PduComposer {
    private class BufferStack {

        void copy() {
            arraycopy(toCopy.currentMessage.toByteArray(), 0, toCopy.currentPosition);
            toCopy = null;
        }

        PositionMarker mark() {
            PositionMarker positionmarker = new PositionMarker();
            positionmarker.c_pos = mPosition;
            positionmarker.currentStackSize = stackSize;
            return positionmarker;
        }

        void newbuf() {
            if(toCopy != null) {
                throw new RuntimeException("BUG: Invalid newbuf() before copy()");
            } else {
                LengthRecordNode lengthrecordnode = new LengthRecordNode();
                lengthrecordnode.currentMessage = mMessage;
                lengthrecordnode.currentPosition = mPosition;
                lengthrecordnode.next = stack;
                stack = lengthrecordnode;
                stackSize = 1 + stackSize;
                mMessage = new ByteArrayOutputStream();
                mPosition = 0;
                return;
            }
        }

        void pop() {
            ByteArrayOutputStream bytearrayoutputstream = mMessage;
            int i = mPosition;
            mMessage = stack.currentMessage;
            mPosition = stack.currentPosition;
            toCopy = stack;
            stack = stack.next;
            stackSize = -1 + stackSize;
            toCopy.currentMessage = bytearrayoutputstream;
            toCopy.currentPosition = i;
        }

        private LengthRecordNode stack;
        int stackSize;
        final PduComposer this$0;
        private LengthRecordNode toCopy;

        private BufferStack() {
            this$0 = PduComposer.this;
            super();
            stack = null;
            toCopy = null;
            stackSize = 0;
        }

    }

    private class PositionMarker {

        int getLength() {
            if(currentStackSize != mStack.stackSize)
                throw new RuntimeException("BUG: Invalid call to getLength()");
            else
                return mPosition - c_pos;
        }

        private int c_pos;
        private int currentStackSize;
        final PduComposer this$0;


/*
        static int access$402(PositionMarker positionmarker, int i) {
            positionmarker.c_pos = i;
            return i;
        }

*/


/*
        static int access$502(PositionMarker positionmarker, int i) {
            positionmarker.currentStackSize = i;
            return i;
        }

*/

        private PositionMarker() {
            this$0 = PduComposer.this;
            super();
        }

    }

    private static class LengthRecordNode {

        ByteArrayOutputStream currentMessage;
        public int currentPosition;
        public LengthRecordNode next;

        private LengthRecordNode() {
            currentMessage = null;
            currentPosition = 0;
            next = null;
        }

    }


    public PduComposer(Context context, GenericPdu genericpdu) {
        mMessage = null;
        mPdu = null;
        mPosition = 0;
        mStack = null;
        mPduHeader = null;
        mPdu = genericpdu;
        mResolver = context.getContentResolver();
        mPduHeader = genericpdu.getPduHeaders();
        mStack = new BufferStack();
        mMessage = new ByteArrayOutputStream();
        mPosition = 0;
    }

    private EncodedStringValue appendAddressType(EncodedStringValue encodedstringvalue) {
        EncodedStringValue encodedstringvalue2;
        int i = checkAddressType(encodedstringvalue.getString());
        encodedstringvalue2 = EncodedStringValue.copy(encodedstringvalue);
        if(1 == i)
            encodedstringvalue2.appendTextString("/TYPE=PLMN".getBytes());
        else
        if(3 == i)
            encodedstringvalue2.appendTextString("/TYPE=IPV4".getBytes());
        else
        if(4 == i)
            encodedstringvalue2.appendTextString("/TYPE=IPV6".getBytes());
        EncodedStringValue encodedstringvalue1 = encodedstringvalue2;
_L2:
        return encodedstringvalue1;
        NullPointerException nullpointerexception;
        nullpointerexception;
        encodedstringvalue1 = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private int appendHeader(int i) {
        i;
        JVM INSTR tableswitch 129 155: default 124
    //                   129 206
    //                   130 206
    //                   131 124
    //                   132 124
    //                   133 457
    //                   134 422
    //                   135 124
    //                   136 662
    //                   137 277
    //                   138 531
    //                   139 171
    //                   140 124
    //                   141 130
    //                   142 124
    //                   143 422
    //                   144 422
    //                   145 422
    //                   146 124
    //                   147 124
    //                   148 124
    //                   149 422
    //                   150 496
    //                   151 206
    //                   152 171
    //                   153 124
    //                   154 124
    //                   155 422;
           goto _L1 _L2 _L2 _L1 _L1 _L3 _L4 _L1 _L5 _L6 _L7 _L8 _L1 _L9 _L1 _L4 _L4 _L4 _L1 _L1 _L1 _L4 _L10 _L2 _L8 _L1 _L1 _L4
_L1:
        byte byte0 = 3;
_L11:
        return byte0;
_L9:
        appendOctet(i);
        int k1 = mPduHeader.getOctet(i);
        if(k1 == 0)
            appendShortInteger(18);
        else
            appendShortInteger(k1);
_L14:
        byte0 = 0;
          goto _L11
_L8:
        byte abyte1[] = mPduHeader.getTextString(i);
        if(abyte1 != null) goto _L13; else goto _L12
_L12:
        byte0 = 2;
          goto _L11
_L13:
        appendOctet(i);
        appendTextString(abyte1);
          goto _L14
_L2:
        EncodedStringValue aencodedstringvalue[] = mPduHeader.getEncodedStringValues(i);
        if(aencodedstringvalue != null) goto _L16; else goto _L15
_L15:
        byte0 = 2;
          goto _L11
_L16:
        int j1 = 0;
_L20:
        if(j1 >= aencodedstringvalue.length) goto _L14; else goto _L17
_L17:
        EncodedStringValue encodedstringvalue3 = appendAddressType(aencodedstringvalue[j1]);
        if(encodedstringvalue3 != null) goto _L19; else goto _L18
_L18:
        byte0 = 1;
          goto _L11
_L19:
        appendOctet(i);
        appendEncodedString(encodedstringvalue3);
        j1++;
          goto _L20
_L6:
        EncodedStringValue encodedstringvalue1;
        appendOctet(i);
        encodedstringvalue1 = mPduHeader.getEncodedStringValue(i);
        if(encodedstringvalue1 != null && !TextUtils.isEmpty(encodedstringvalue1.getString()) && !(new String(encodedstringvalue1.getTextString())).equals("insert-address-token")) goto _L22; else goto _L21
_L21:
        append(1);
        append(129);
          goto _L14
_L22:
        PositionMarker positionmarker1;
        EncodedStringValue encodedstringvalue2;
        mStack.newbuf();
        positionmarker1 = mStack.mark();
        append(128);
        encodedstringvalue2 = appendAddressType(encodedstringvalue1);
        if(encodedstringvalue2 != null) goto _L24; else goto _L23
_L23:
        byte0 = 1;
          goto _L11
_L24:
        appendEncodedString(encodedstringvalue2);
        int i1 = positionmarker1.getLength();
        mStack.pop();
        appendValueLength(i1);
        mStack.copy();
          goto _L14
_L4:
        int k = mPduHeader.getOctet(i);
        if(k != 0) goto _L26; else goto _L25
_L25:
        byte0 = 2;
          goto _L11
_L26:
        appendOctet(i);
        appendOctet(k);
          goto _L14
_L3:
        long l1 = mPduHeader.getLongInteger(i);
        if(-1L != l1) goto _L28; else goto _L27
_L27:
        byte0 = 2;
          goto _L11
_L28:
        appendOctet(i);
        appendDateValue(l1);
          goto _L14
_L10:
        EncodedStringValue encodedstringvalue = mPduHeader.getEncodedStringValue(i);
        if(encodedstringvalue != null) goto _L30; else goto _L29
_L29:
        byte0 = 2;
          goto _L11
_L30:
        appendOctet(i);
        appendEncodedString(encodedstringvalue);
          goto _L14
_L7:
        byte abyte0[] = mPduHeader.getTextString(i);
        if(abyte0 != null) goto _L32; else goto _L31
_L31:
        byte0 = 2;
          goto _L11
_L32:
        appendOctet(i);
        if(Arrays.equals(abyte0, "advertisement".getBytes()))
            appendOctet(129);
        else
        if(Arrays.equals(abyte0, "auto".getBytes()))
            appendOctet(131);
        else
        if(Arrays.equals(abyte0, "personal".getBytes()))
            appendOctet(128);
        else
        if(Arrays.equals(abyte0, "informational".getBytes()))
            appendOctet(130);
        else
            appendTextString(abyte0);
          goto _L14
_L5:
        long l = mPduHeader.getLongInteger(i);
        if(-1L != l) goto _L34; else goto _L33
_L33:
        byte0 = 2;
          goto _L11
_L34:
        appendOctet(i);
        mStack.newbuf();
        PositionMarker positionmarker = mStack.mark();
        append(129);
        appendLongInteger(l);
        int j = positionmarker.getLength();
        mStack.pop();
        appendValueLength(j);
        mStack.copy();
          goto _L14
    }

    protected static int checkAddressType(String s) {
        byte byte0 = 5;
        if(s != null) goto _L2; else goto _L1
_L1:
        return byte0;
_L2:
        if(s.matches("[0-9]{1,3}\\.{1}[0-9]{1,3}\\.{1}[0-9]{1,3}\\.{1}[0-9]{1,3}"))
            byte0 = 3;
        else
        if(s.matches("\\+?[0-9|\\.|\\-]+"))
            byte0 = 1;
        else
        if(s.matches("[a-zA-Z| ]*\\<{0,1}[a-zA-Z| ]+@{1}[a-zA-Z| ]+\\.{1}[a-zA-Z| ]+\\>{0,1}"))
            byte0 = 2;
        else
        if(s.matches("[a-fA-F]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}"))
            byte0 = 4;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private int makeAckInd() {
        int i;
        i = 1;
        if(mMessage == null) {
            mMessage = new ByteArrayOutputStream();
            mPosition = 0;
        }
        appendOctet(140);
        appendOctet(133);
        break MISSING_BLOCK_LABEL_39;
        if(appendHeader(152) == 0 && appendHeader(141) == 0) {
            appendHeader(145);
            i = 0;
        }
        return i;
    }

    private int makeMessageBody() {
        PositionMarker positionmarker;
        Integer integer;
        mStack.newbuf();
        positionmarker = mStack.mark();
        String s = new String(mPduHeader.getTextString(132));
        integer = (Integer)mContentTypeMap.get(s);
        if(integer != null) goto _L2; else goto _L1
_L1:
        int i = 1;
_L16:
        return i;
_L2:
        PduBody pdubody;
        appendShortInteger(integer.intValue());
        pdubody = ((SendReq)mPdu).getBody();
        if(pdubody == null || pdubody.getPartsNum() == 0) {
            appendUintvarInteger(0L);
            mStack.pop();
            mStack.copy();
            i = 0;
            continue; /* Loop/switch isn't completed */
        }
        PduPart pdupart1;
        byte abyte6[];
        pdupart1 = pdubody.getPart(0);
        abyte6 = pdupart1.getContentId();
        if(abyte6 == null) goto _L4; else goto _L3
_L3:
        appendOctet(138);
        if(60 != abyte6[0] || 62 != abyte6[-1 + abyte6.length]) goto _L6; else goto _L5
_L5:
        appendTextString(abyte6);
_L4:
        appendOctet(137);
        appendTextString(pdupart1.getContentType());
_L8:
        int k;
        int l;
        PduPart pdupart;
        int j = positionmarker.getLength();
        mStack.pop();
        appendValueLength(j);
        mStack.copy();
        k = pdubody.getPartsNum();
        appendUintvarInteger(k);
        l = 0;
          goto _L7
_L6:
        StringBuilder stringbuilder1 = (new StringBuilder()).append("<");
        String s3 = new String(abyte6);
        appendTextString(stringbuilder1.append(s3).append(">").toString());
          goto _L4
        arrayindexoutofboundsexception;
        arrayindexoutofboundsexception.printStackTrace();
          goto _L8
_L7:
        int k1;
        int l1;
        if(l >= k)
            break MISSING_BLOCK_LABEL_827;
        pdupart = pdubody.getPart(l);
        mStack.newbuf();
        PositionMarker positionmarker1 = mStack.mark();
        mStack.newbuf();
        PositionMarker positionmarker2 = mStack.mark();
        byte abyte0[] = pdupart.getContentType();
        ArrayIndexOutOfBoundsException arrayindexoutofboundsexception;
        if(abyte0 == null) {
            i = 1;
            continue; /* Loop/switch isn't completed */
        }
        HashMap hashmap = mContentTypeMap;
        String s1 = new String(abyte0);
        Integer integer1 = (Integer)hashmap.get(s1);
        byte abyte1[];
        if(integer1 == null)
            appendTextString(abyte0);
        else
            appendShortInteger(integer1.intValue());
        abyte1 = pdupart.getName();
        if(abyte1 == null) {
            abyte1 = pdupart.getFilename();
            if(abyte1 == null) {
                abyte1 = pdupart.getContentLocation();
                if(abyte1 == null) {
                    i = 1;
                    continue; /* Loop/switch isn't completed */
                }
            }
        }
        appendOctet(133);
        appendTextString(abyte1);
        int i1 = pdupart.getCharset();
        if(i1 != 0) {
            appendOctet(129);
            appendShortInteger(i1);
        }
        int j1 = positionmarker2.getLength();
        mStack.pop();
        appendValueLength(j1);
        mStack.copy();
        byte abyte2[] = pdupart.getContentId();
        if(abyte2 != null) {
            appendOctet(192);
            byte abyte3[];
            byte abyte4[];
            int j2;
            if(60 == abyte2[0] && 62 == abyte2[-1 + abyte2.length]) {
                appendQuotedString(abyte2);
            } else {
                StringBuilder stringbuilder = (new StringBuilder()).append("<");
                String s2 = new String(abyte2);
                appendQuotedString(stringbuilder.append(s2).append(">").toString());
            }
        }
        abyte3 = pdupart.getContentLocation();
        if(abyte3 != null) {
            appendOctet(142);
            appendTextString(abyte3);
        }
        k1 = positionmarker1.getLength();
        l1 = 0;
        abyte4 = pdupart.getData();
        if(abyte4 == null) goto _L10; else goto _L9
_L9:
        arraycopy(abyte4, 0, abyte4.length);
        l1 = abyte4.length;
_L12:
        j2 = positionmarker1.getLength() - k1;
        if(l1 != j2)
            throw new RuntimeException("BUG: Length sanity check failed");
        break MISSING_BLOCK_LABEL_793;
_L10:
        byte abyte5[];
        InputStream inputstream;
        abyte5 = new byte[1024];
        inputstream = mResolver.openInputStream(pdupart.getDataUri());
_L13:
        int i2 = inputstream.read(abyte5);
        if(i2 == -1) goto _L12; else goto _L11
_L11:
        mMessage.write(abyte5, 0, i2);
        mPosition = i2 + mPosition;
        l1 += i2;
          goto _L13
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        i = 1;
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        i = 1;
        continue; /* Loop/switch isn't completed */
        RuntimeException runtimeexception;
        runtimeexception;
        i = 1;
        continue; /* Loop/switch isn't completed */
        mStack.pop();
        appendUintvarInteger(k1);
        appendUintvarInteger(l1);
        mStack.copy();
        l++;
        if(true) goto _L7; else goto _L14
_L14:
        i = 0;
        if(true) goto _L16; else goto _L15
_L15:
    }

    private int makeNotifyResp() {
        int i;
        i = 1;
        if(mMessage == null) {
            mMessage = new ByteArrayOutputStream();
            mPosition = 0;
        }
        appendOctet(140);
        appendOctet(131);
        break MISSING_BLOCK_LABEL_39;
        if(appendHeader(152) == 0 && appendHeader(141) == 0 && appendHeader(149) == 0)
            i = 0;
        return i;
    }

    private int makeReadRecInd() {
        int i;
        i = 1;
        if(mMessage == null) {
            mMessage = new ByteArrayOutputStream();
            mPosition = 0;
        }
        appendOctet(140);
        appendOctet(135);
        break MISSING_BLOCK_LABEL_39;
        while(true)  {
            do
                return i;
            while(appendHeader(141) != 0 || appendHeader(139) != 0 || appendHeader(151) != 0 || appendHeader(137) != 0);
            appendHeader(133);
            if(appendHeader(155) == 0)
                i = 0;
        }
    }

    private int makeSendReqPdu() {
        int i;
        i = 1;
        if(mMessage == null) {
            mMessage = new ByteArrayOutputStream();
            mPosition = 0;
        }
        appendOctet(140);
        appendOctet(128);
        appendOctet(152);
        byte abyte0[] = mPduHeader.getTextString(152);
        if(abyte0 == null)
            throw new IllegalArgumentException("Transaction-ID is null.");
        appendTextString(abyte0);
        if(appendHeader(141) == 0) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        appendHeader(133);
        if(appendHeader(137) == 0) {
            boolean flag = false;
            if(appendHeader(151) != i)
                flag = true;
            if(appendHeader(130) != i)
                flag = true;
            if(appendHeader(129) != i)
                flag = true;
            if(flag) {
                appendHeader(150);
                appendHeader(138);
                appendHeader(136);
                appendHeader(143);
                appendHeader(134);
                appendHeader(144);
                appendOctet(132);
                i = makeMessageBody();
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected void append(int i) {
        mMessage.write(i);
        mPosition = 1 + mPosition;
    }

    protected void appendDateValue(long l) {
        appendLongInteger(l);
    }

    protected void appendEncodedString(EncodedStringValue encodedstringvalue) {
        if(!$assertionsDisabled && encodedstringvalue == null)
            throw new AssertionError();
        int i = encodedstringvalue.getCharacterSet();
        byte abyte0[] = encodedstringvalue.getTextString();
        if(abyte0 != null) {
            mStack.newbuf();
            PositionMarker positionmarker = mStack.mark();
            appendShortInteger(i);
            appendTextString(abyte0);
            int j = positionmarker.getLength();
            mStack.pop();
            appendValueLength(j);
            mStack.copy();
        }
    }

    protected void appendLongInteger(long l) {
        long l1 = l;
        int i;
        for(i = 0; l1 != 0L && i < 8; i++)
            l1 >>>= 8;

        appendShortLength(i);
        int j = 8 * (i - 1);
        for(int k = 0; k < i; k++) {
            append((int)(255L & l >>> j));
            j -= 8;
        }

    }

    protected void appendOctet(int i) {
        append(i);
    }

    protected void appendQuotedString(String s) {
        appendQuotedString(s.getBytes());
    }

    protected void appendQuotedString(byte abyte0[]) {
        append(34);
        arraycopy(abyte0, 0, abyte0.length);
        append(0);
    }

    protected void appendShortInteger(int i) {
        append(0xff & (i | 0x80));
    }

    protected void appendShortLength(int i) {
        append(i);
    }

    protected void appendTextString(String s) {
        appendTextString(s.getBytes());
    }

    protected void appendTextString(byte abyte0[]) {
        if((0xff & abyte0[0]) > 127)
            append(127);
        arraycopy(abyte0, 0, abyte0.length);
        append(0);
    }

    protected void appendUintvarInteger(long l) {
        long l1 = 127L;
        int i = 0;
        do {
            if(i >= 5 || l < l1) {
                for(; i > 0; i--)
                    append((int)(255L & (128L | 127L & l >>> i * 7)));

                break;
            }
            l1 = 127L | l1 << 7;
            i++;
        } while(true);
        append((int)(l & 127L));
    }

    protected void appendValueLength(long l) {
        if(l < 31L) {
            appendShortLength((int)l);
        } else {
            append(31);
            appendUintvarInteger(l);
        }
    }

    protected void arraycopy(byte abyte0[], int i, int j) {
        mMessage.write(abyte0, i, j);
        mPosition = j + mPosition;
    }

    public byte[] make() {
        byte abyte0[] = null;
        mPdu.getMessageType();
        JVM INSTR tableswitch 128 135: default 56
    //                   128 58
    //                   129 56
    //                   130 56
    //                   131 76
    //                   132 56
    //                   133 86
    //                   134 56
    //                   135 96;
           goto _L1 _L2 _L1 _L1 _L3 _L1 _L4 _L1 _L5
_L1:
        return abyte0;
_L2:
        if(makeSendReqPdu() != 0) goto _L1; else goto _L6
_L6:
        abyte0 = mMessage.toByteArray();
        break; /* Loop/switch isn't completed */
_L3:
        if(makeNotifyResp() == 0) goto _L6; else goto _L7
_L7:
        break; /* Loop/switch isn't completed */
_L4:
        if(makeAckInd() == 0) goto _L6; else goto _L8
_L8:
        break; /* Loop/switch isn't completed */
_L5:
        if(makeReadRecInd() == 0) goto _L6; else goto _L1
    }

    static final boolean $assertionsDisabled = false;
    private static final int END_STRING_FLAG = 0;
    private static final int LENGTH_QUOTE = 31;
    private static final int LONG_INTEGER_LENGTH_MAX = 8;
    private static final int PDU_COMPOSER_BLOCK_SIZE = 1024;
    private static final int PDU_COMPOSE_CONTENT_ERROR = 1;
    private static final int PDU_COMPOSE_FIELD_NOT_SET = 2;
    private static final int PDU_COMPOSE_FIELD_NOT_SUPPORTED = 3;
    private static final int PDU_COMPOSE_SUCCESS = 0;
    private static final int PDU_EMAIL_ADDRESS_TYPE = 2;
    private static final int PDU_IPV4_ADDRESS_TYPE = 3;
    private static final int PDU_IPV6_ADDRESS_TYPE = 4;
    private static final int PDU_PHONE_NUMBER_ADDRESS_TYPE = 1;
    private static final int PDU_UNKNOWN_ADDRESS_TYPE = 5;
    private static final int QUOTED_STRING_FLAG = 34;
    static final String REGEXP_EMAIL_ADDRESS_TYPE = "[a-zA-Z| ]*\\<{0,1}[a-zA-Z| ]+@{1}[a-zA-Z| ]+\\.{1}[a-zA-Z| ]+\\>{0,1}";
    static final String REGEXP_IPV4_ADDRESS_TYPE = "[0-9]{1,3}\\.{1}[0-9]{1,3}\\.{1}[0-9]{1,3}\\.{1}[0-9]{1,3}";
    static final String REGEXP_IPV6_ADDRESS_TYPE = "[a-fA-F]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}\\:{1}[a-fA-F0-9]{4}";
    static final String REGEXP_PHONE_NUMBER_ADDRESS_TYPE = "\\+?[0-9|\\.|\\-]+";
    private static final int SHORT_INTEGER_MAX = 127;
    static final String STRING_IPV4_ADDRESS_TYPE = "/TYPE=IPV4";
    static final String STRING_IPV6_ADDRESS_TYPE = "/TYPE=IPV6";
    static final String STRING_PHONE_NUMBER_ADDRESS_TYPE = "/TYPE=PLMN";
    private static final int TEXT_MAX = 127;
    private static HashMap mContentTypeMap;
    protected ByteArrayOutputStream mMessage;
    private GenericPdu mPdu;
    private PduHeaders mPduHeader;
    protected int mPosition;
    private final ContentResolver mResolver;
    private BufferStack mStack;

    static  {
        boolean flag;
        if(!com/google/android/mms/pdu/PduComposer.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
        mContentTypeMap = null;
        mContentTypeMap = new HashMap();
        for(int i = 0; i < PduContentTypes.contentTypes.length; i++)
            mContentTypeMap.put(PduContentTypes.contentTypes[i], Integer.valueOf(i));

    }

}
