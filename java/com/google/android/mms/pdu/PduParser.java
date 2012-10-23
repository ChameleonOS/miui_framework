// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import android.content.res.Resources;
import android.util.Log;
import com.google.android.mms.InvalidHeaderValueException;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

// Referenced classes of package com.google.android.mms.pdu:
//            PduHeaders, PduPart, PduContentTypes, CharacterSets, 
//            EncodedStringValue, PduBody, Base64, QuotedPrintable, 
//            SendReq, SendConf, NotificationInd, NotifyRespInd, 
//            RetrieveConf, DeliveryInd, AcknowledgeInd, ReadOrigInd, 
//            ReadRecInd, GenericPdu

public class PduParser {

    public PduParser(byte abyte0[]) {
        mPduDataStream = null;
        mHeaders = null;
        mBody = null;
        mPduDataStream = new ByteArrayInputStream(abyte0);
    }

    protected static boolean checkMandatoryHeader(PduHeaders pduheaders) {
        if(pduheaders != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        int i = pduheaders.getOctet(140);
        if(pduheaders.getOctet(141) == 0) {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        switch(i) {
        default:
            flag = false;
            continue; /* Loop/switch isn't completed */

        case 128: 
            if(pduheaders.getTextString(132) == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getEncodedStringValue(137) == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getTextString(152) == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            break;

        case 129: 
            if(pduheaders.getOctet(146) == 0) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getTextString(152) != null)
                break;
            flag = false;
            continue; /* Loop/switch isn't completed */

        case 130: 
            if(pduheaders.getTextString(131) == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(-1L == pduheaders.getLongInteger(136)) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getTextString(138) == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(-1L == pduheaders.getLongInteger(142)) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getTextString(152) != null)
                break;
            flag = false;
            continue; /* Loop/switch isn't completed */

        case 131: 
            if(pduheaders.getOctet(149) == 0) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getTextString(152) != null)
                break;
            flag = false;
            continue; /* Loop/switch isn't completed */

        case 132: 
            if(pduheaders.getTextString(132) == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(-1L != pduheaders.getLongInteger(133))
                break;
            flag = false;
            continue; /* Loop/switch isn't completed */

        case 134: 
            if(-1L == pduheaders.getLongInteger(133)) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getTextString(139) == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getOctet(149) == 0) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getEncodedStringValues(151) != null)
                break;
            flag = false;
            continue; /* Loop/switch isn't completed */

        case 133: 
            if(pduheaders.getTextString(152) != null)
                break;
            flag = false;
            continue; /* Loop/switch isn't completed */

        case 136: 
            if(-1L == pduheaders.getLongInteger(133)) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getEncodedStringValue(137) == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getTextString(139) == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getOctet(155) == 0) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getEncodedStringValues(151) != null)
                break;
            flag = false;
            continue; /* Loop/switch isn't completed */

        case 135: 
            if(pduheaders.getEncodedStringValue(137) == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getTextString(139) == null) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getOctet(155) == 0) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if(pduheaders.getEncodedStringValues(151) != null)
                break;
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static int checkPartPosition(PduPart pdupart) {
        int i;
        i = 1;
        if(!$assertionsDisabled && pdupart == null)
            throw new AssertionError();
        if(mTypeParam != null || mStartParam != null) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        if(mStartParam != null) {
            byte abyte1[] = pdupart.getContentId();
            if(abyte1 != null && i == Arrays.equals(mStartParam, abyte1)) {
                i = 0;
                continue; /* Loop/switch isn't completed */
            }
        }
        if(mTypeParam != null) {
            byte abyte0[] = pdupart.getContentType();
            if(abyte0 != null && i == Arrays.equals(mTypeParam, abyte0))
                i = 0;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected static int extractByteValue(ByteArrayInputStream bytearrayinputstream) {
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        int i = bytearrayinputstream.read();
        if(!$assertionsDisabled && -1 == i)
            throw new AssertionError();
        else
            return i & 0xff;
    }

    protected static byte[] getWapString(ByteArrayInputStream bytearrayinputstream, int i) {
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        int j = bytearrayinputstream.read();
        if(!$assertionsDisabled && -1 == j)
            throw new AssertionError();
        while(-1 != j && j != 0)  {
            if(i == 2) {
                if(isTokenCharacter(j))
                    bytearrayoutputstream.write(j);
            } else
            if(isText(j))
                bytearrayoutputstream.write(j);
            j = bytearrayinputstream.read();
            if(!$assertionsDisabled && -1 == j)
                throw new AssertionError();
        }
        byte abyte0[];
        if(bytearrayoutputstream.size() > 0)
            abyte0 = bytearrayoutputstream.toByteArray();
        else
            abyte0 = null;
        return abyte0;
    }

    protected static boolean isText(int i) {
        boolean flag = true;
        if((i < 32 || i > 126) && (i < 128 || i > 255)) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        switch(i) {
        case 11: // '\013'
        case 12: // '\f'
        default:
            flag = false;
            break;

        case 9: // '\t'
        case 10: // '\n'
        case 13: // '\r'
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected static boolean isTokenCharacter(int i) {
        boolean flag = false;
        if(i >= 33 && i <= 126) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        switch(i) {
        default:
            flag = true;
            break;

        case 34: // '"'
        case 40: // '('
        case 41: // ')'
        case 44: // ','
        case 47: // '/'
        case 58: // ':'
        case 59: // ';'
        case 60: // '<'
        case 61: // '='
        case 62: // '>'
        case 63: // '?'
        case 64: // '@'
        case 91: // '['
        case 92: // '\\'
        case 93: // ']'
        case 123: // '{'
        case 125: // '}'
            break;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static void log(String s) {
    }

    protected static byte[] parseContentType(ByteArrayInputStream bytearrayinputstream, HashMap hashmap) {
        int j;
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        bytearrayinputstream.mark(1);
        int i = bytearrayinputstream.read();
        if(!$assertionsDisabled && -1 == i)
            throw new AssertionError();
        bytearrayinputstream.reset();
        j = i & 0xff;
        if(j >= 32) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        byte abyte1[];
        int k = parseValueLength(bytearrayinputstream);
        int l = bytearrayinputstream.available();
        bytearrayinputstream.mark(1);
        int i1 = bytearrayinputstream.read();
        if(!$assertionsDisabled && -1 == i1)
            throw new AssertionError();
        bytearrayinputstream.reset();
        int j1 = i1 & 0xff;
        int l1;
        if(j1 >= 32 && j1 <= 127) {
            abyte0 = parseWapString(bytearrayinputstream, 0);
        } else {
label0:
            {
                if(j1 <= 127)
                    break label0;
                int k1 = parseShortInteger(bytearrayinputstream);
                if(k1 < PduContentTypes.contentTypes.length) {
                    abyte0 = PduContentTypes.contentTypes[k1].getBytes();
                } else {
                    bytearrayinputstream.reset();
                    abyte0 = parseWapString(bytearrayinputstream, 0);
                }
            }
        }
        l1 = k - (l - bytearrayinputstream.available());
        if(l1 > 0)
            parseContentTypeParams(bytearrayinputstream, hashmap, Integer.valueOf(l1));
        if(l1 >= 0)
            break MISSING_BLOCK_LABEL_278;
        Log.e("PduParser", "Corrupt MMS message");
        abyte1 = PduContentTypes.contentTypes[0].getBytes();
_L4:
        return abyte1;
        Log.e("PduParser", "Corrupt content-type");
        abyte1 = PduContentTypes.contentTypes[0].getBytes();
        continue; /* Loop/switch isn't completed */
_L2:
        if(j <= 127)
            abyte0 = parseWapString(bytearrayinputstream, 0);
        else
            abyte0 = PduContentTypes.contentTypes[parseShortInteger(bytearrayinputstream)].getBytes();
        abyte1 = abyte0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected static void parseContentTypeParams(ByteArrayInputStream bytearrayinputstream, HashMap hashmap, Integer integer) {
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        if(!$assertionsDisabled && integer.intValue() <= 0)
            throw new AssertionError();
        int i = bytearrayinputstream.available();
        int j = integer.intValue();
        do {
            if(j <= 0)
                break;
            int k = bytearrayinputstream.read();
            if(!$assertionsDisabled && -1 == k)
                throw new AssertionError();
            j--;
            switch(k) {
            default:
                byte abyte0[];
                int l;
                int i1;
                int j1;
                int k1;
                byte abyte1[];
                String s;
                UnsupportedEncodingException unsupportedencodingexception;
                int l1;
                byte abyte2[];
                int i2;
                int j2;
                byte abyte3[];
                int k2;
                int l2;
                byte abyte4[];
                if(-1 == skipWapValue(bytearrayinputstream, j))
                    Log.e("PduParser", "Corrupt Content-Type");
                else
                    j = 0;
                continue;

            case 131: 
            case 137: 
                bytearrayinputstream.mark(1);
                j2 = extractByteValue(bytearrayinputstream);
                bytearrayinputstream.reset();
                if(j2 > 127) {
                    l2 = parseShortInteger(bytearrayinputstream);
                    if(l2 < PduContentTypes.contentTypes.length) {
                        abyte4 = PduContentTypes.contentTypes[l2].getBytes();
                        hashmap.put(Integer.valueOf(131), abyte4);
                    }
                } else {
                    abyte3 = parseWapString(bytearrayinputstream, 0);
                    if(abyte3 != null && hashmap != null)
                        hashmap.put(Integer.valueOf(131), abyte3);
                }
                k2 = bytearrayinputstream.available();
                j = integer.intValue() - (i - k2);
                continue;

            case 138: 
            case 153: 
                abyte2 = parseWapString(bytearrayinputstream, 0);
                if(abyte2 != null && hashmap != null)
                    hashmap.put(Integer.valueOf(153), abyte2);
                i2 = bytearrayinputstream.available();
                j = integer.intValue() - (i - i2);
                continue;

            case 129: 
                bytearrayinputstream.mark(1);
                i1 = extractByteValue(bytearrayinputstream);
                bytearrayinputstream.reset();
                if(i1 > 32 && i1 < 127 || i1 == 0) {
                    abyte1 = parseWapString(bytearrayinputstream, 0);
                    try {
                        s = new String(abyte1);
                        l1 = CharacterSets.getMibEnumValue(s);
                        hashmap.put(Integer.valueOf(129), Integer.valueOf(l1));
                    }
                    // Misplaced declaration of an exception variable
                    catch(UnsupportedEncodingException unsupportedencodingexception) {
                        Log.e("PduParser", Arrays.toString(abyte1), unsupportedencodingexception);
                        hashmap.put(Integer.valueOf(129), Integer.valueOf(0));
                    }
                } else {
                    j1 = (int)parseIntegerValue(bytearrayinputstream);
                    if(hashmap != null)
                        hashmap.put(Integer.valueOf(129), Integer.valueOf(j1));
                }
                k1 = bytearrayinputstream.available();
                j = integer.intValue() - (i - k1);
                continue;

            case 133: 
            case 151: 
                abyte0 = parseWapString(bytearrayinputstream, 0);
                if(abyte0 != null && hashmap != null)
                    hashmap.put(Integer.valueOf(151), abyte0);
                l = bytearrayinputstream.available();
                j = integer.intValue() - (i - l);
                break;
            }
        } while(true);
        if(j != 0)
            Log.e("PduParser", "Corrupt Content-Type");
    }

    protected static EncodedStringValue parseEncodedStringValue(ByteArrayInputStream bytearrayinputstream) {
        EncodedStringValue encodedstringvalue;
        int i;
        int k;
        encodedstringvalue = null;
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        bytearrayinputstream.mark(1);
        i = 0;
        int j = bytearrayinputstream.read();
        if(!$assertionsDisabled && -1 == j)
            throw new AssertionError();
        k = j & 0xff;
        if(k != 0) goto _L2; else goto _L1
_L1:
        return encodedstringvalue;
_L2:
        byte abyte0[];
        bytearrayinputstream.reset();
        if(k < 32) {
            parseValueLength(bytearrayinputstream);
            i = parseShortInteger(bytearrayinputstream);
        }
        abyte0 = parseWapString(bytearrayinputstream, 0);
        if(i == 0)
            break MISSING_BLOCK_LABEL_113;
        EncodedStringValue encodedstringvalue2;
        encodedstringvalue2 = new EncodedStringValue(i, abyte0);
        break MISSING_BLOCK_LABEL_136;
        EncodedStringValue encodedstringvalue1 = new EncodedStringValue(abyte0);
        encodedstringvalue2 = encodedstringvalue1;
        break MISSING_BLOCK_LABEL_136;
        Exception exception;
        exception;
        continue; /* Loop/switch isn't completed */
        encodedstringvalue = encodedstringvalue2;
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected static long parseIntegerValue(ByteArrayInputStream bytearrayinputstream) {
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        bytearrayinputstream.mark(1);
        int i = bytearrayinputstream.read();
        if(!$assertionsDisabled && -1 == i)
            throw new AssertionError();
        bytearrayinputstream.reset();
        long l;
        if(i > 127)
            l = parseShortInteger(bytearrayinputstream);
        else
            l = parseLongInteger(bytearrayinputstream);
        return l;
    }

    protected static long parseLongInteger(ByteArrayInputStream bytearrayinputstream) {
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        int i = bytearrayinputstream.read();
        if(!$assertionsDisabled && -1 == i)
            throw new AssertionError();
        int j = i & 0xff;
        if(j > 8)
            throw new RuntimeException("Octet count greater than 8 and I can't represent that!");
        long l = 0L;
        for(int k = 0; k < j; k++) {
            int i1 = bytearrayinputstream.read();
            if(!$assertionsDisabled && -1 == i1)
                throw new AssertionError();
            l = (l << 8) + (long)(i1 & 0xff);
        }

        return l;
    }

    protected static boolean parsePartHeaders(ByteArrayInputStream bytearrayinputstream, PduPart pdupart, int i) {
        int j;
        int k;
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        if(!$assertionsDisabled && pdupart == null)
            throw new AssertionError();
        if(!$assertionsDisabled && i <= 0)
            throw new AssertionError();
        j = bytearrayinputstream.available();
        k = i;
_L11:
        if(k <= 0) goto _L2; else goto _L1
_L1:
        int l;
        l = bytearrayinputstream.read();
        if(!$assertionsDisabled && -1 == l)
            throw new AssertionError();
        k--;
        if(l <= 127) goto _L4; else goto _L3
_L3:
        l;
        JVM INSTR lookupswitch 4: default 148
    //                   142: 174
    //                   174: 236
    //                   192: 205
    //                   197: 236;
           goto _L5 _L6 _L7 _L8 _L7
_L5:
        if(-1 != skipWapValue(bytearrayinputstream, k)) goto _L10; else goto _L9
_L9:
        boolean flag;
        Log.e("PduParser", "Corrupt Part headers");
        flag = false;
_L16:
        return flag;
_L6:
        byte abyte3[] = parseWapString(bytearrayinputstream, 0);
        if(abyte3 != null)
            pdupart.setContentLocation(abyte3);
        k = i - (j - bytearrayinputstream.available());
          goto _L11
_L8:
        byte abyte2[] = parseWapString(bytearrayinputstream, 1);
        if(abyte2 != null)
            pdupart.setContentId(abyte2);
        k = i - (j - bytearrayinputstream.available());
          goto _L11
_L7:
        if(Resources.getSystem().getBoolean(0x1110031)) {
            int i1 = parseValueLength(bytearrayinputstream);
            bytearrayinputstream.mark(1);
            int j1 = bytearrayinputstream.available();
            int k1 = bytearrayinputstream.read();
            if(k1 == 128)
                pdupart.setContentDisposition(PduPart.DISPOSITION_FROM_DATA);
            else
            if(k1 == 129)
                pdupart.setContentDisposition(PduPart.DISPOSITION_ATTACHMENT);
            else
            if(k1 == 130) {
                pdupart.setContentDisposition(PduPart.DISPOSITION_INLINE);
            } else {
                bytearrayinputstream.reset();
                pdupart.setContentDisposition(parseWapString(bytearrayinputstream, 0));
            }
            if(j1 - bytearrayinputstream.available() < i1) {
                if(bytearrayinputstream.read() == 152)
                    pdupart.setFilename(parseWapString(bytearrayinputstream, 0));
                int l1 = bytearrayinputstream.available();
                if(j1 - l1 < i1) {
                    int i2 = i1 - (j1 - l1);
                    bytearrayinputstream.read(new byte[i2], 0, i2);
                }
            }
            k = i - (j - bytearrayinputstream.available());
        }
          goto _L11
_L10:
        k = 0;
          goto _L11
_L4:
        if(l < 32 || l > 127) goto _L13; else goto _L12
_L12:
        byte abyte0[] = parseWapString(bytearrayinputstream, 0);
        byte abyte1[] = parseWapString(bytearrayinputstream, 0);
        String s = new String(abyte0);
        if("Content-Transfer-Encoding".equalsIgnoreCase(s))
            pdupart.setContentTransferEncoding(abyte1);
        k = i - (j - bytearrayinputstream.available());
          goto _L11
_L13:
        if(-1 != skipWapValue(bytearrayinputstream, k)) goto _L15; else goto _L14
_L14:
        Log.e("PduParser", "Corrupt Part headers");
        flag = false;
          goto _L16
_L15:
        k = 0;
          goto _L11
_L2:
        if(k != 0) {
            Log.e("PduParser", "Corrupt Part headers");
            flag = false;
        } else {
            flag = true;
        }
          goto _L16
    }

    protected static PduBody parseParts(ByteArrayInputStream bytearrayinputstream) {
        if(bytearrayinputstream != null) goto _L2; else goto _L1
_L1:
        PduBody pdubody = null;
_L3:
        return pdubody;
_L2:
        int i;
        int j;
        i = parseUnsignedInt(bytearrayinputstream);
        pdubody = new PduBody();
        j = 0;
_L8:
        int l;
        PduPart pdupart;
        if(j < i) {
            int k = parseUnsignedInt(bytearrayinputstream);
            l = parseUnsignedInt(bytearrayinputstream);
            pdupart = new PduPart();
            int i1 = bytearrayinputstream.available();
            if(i1 <= 0) {
                pdubody = null;
            } else {
label0:
                {
                    HashMap hashmap = new HashMap();
                    byte abyte0[] = parseContentType(bytearrayinputstream, hashmap);
                    byte abyte1[];
                    Integer integer;
                    int j1;
                    if(abyte0 != null)
                        pdupart.setContentType(abyte0);
                    else
                        pdupart.setContentType(PduContentTypes.contentTypes[0].getBytes());
                    abyte1 = (byte[])(byte[])hashmap.get(Integer.valueOf(151));
                    if(abyte1 != null)
                        pdupart.setName(abyte1);
                    integer = (Integer)hashmap.get(Integer.valueOf(129));
                    if(integer != null)
                        pdupart.setCharset(integer.intValue());
                    j1 = k - (i1 - bytearrayinputstream.available());
                    if(j1 > 0) {
                        if(parsePartHeaders(bytearrayinputstream, pdupart, j1))
                            break label0;
                        pdubody = null;
                    } else {
                        if(j1 >= 0)
                            break label0;
                        pdubody = null;
                    }
                }
            }
        }
          goto _L3
        if(pdupart.getContentLocation() == null && pdupart.getName() == null && pdupart.getFilename() == null && pdupart.getContentId() == null)
            pdupart.setContentLocation(Long.toOctalString(System.currentTimeMillis()).getBytes());
        if(l <= 0) goto _L5; else goto _L4
_L4:
        byte abyte2[];
        String s;
        abyte2 = new byte[l];
        s = new String(pdupart.getContentType());
        bytearrayinputstream.read(abyte2, 0, l);
        if(!s.equalsIgnoreCase("application/vnd.wap.multipart.alternative")) goto _L7; else goto _L6
_L6:
        ByteArrayInputStream bytearrayinputstream1 = new ByteArrayInputStream(abyte2);
        pdupart = parseParts(bytearrayinputstream1).getPart(0);
_L5:
        byte abyte3[];
        String s1;
        if(checkPartPosition(pdupart) == 0)
            pdubody.addPart(0, pdupart);
        else
            pdubody.addPart(pdupart);
        j++;
          goto _L8
_L7:
label1:
        {
            abyte3 = pdupart.getContentTransferEncoding();
            if(abyte3 != null) {
                s1 = new String(abyte3);
                if(s1.equalsIgnoreCase("base64"))
                    abyte2 = Base64.decodeBase64(abyte2);
                else
                if(s1.equalsIgnoreCase("quoted-printable"))
                    abyte2 = QuotedPrintable.decodeQuotedPrintable(abyte2);
            }
            if(abyte2 != null)
                break label1;
            log("Decode part data error!");
            pdubody = null;
        }
          goto _L3
        pdupart.setData(abyte2);
          goto _L5
    }

    protected static int parseShortInteger(ByteArrayInputStream bytearrayinputstream) {
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        int i = bytearrayinputstream.read();
        if(!$assertionsDisabled && -1 == i)
            throw new AssertionError();
        else
            return i & 0x7f;
    }

    protected static int parseUnsignedInt(ByteArrayInputStream bytearrayinputstream) {
        int i;
        int j;
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        i = 0;
        j = bytearrayinputstream.read();
        if(j != -1) goto _L2; else goto _L1
_L1:
        int k = j;
_L4:
        return k;
_L2:
        while((j & 0x80) != 0)  {
            i = i << 7 | j & 0x7f;
            j = bytearrayinputstream.read();
            if(j == -1) {
                k = j;
                continue; /* Loop/switch isn't completed */
            }
        }
        k = i << 7 | j & 0x7f;
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected static int parseValueLength(ByteArrayInputStream bytearrayinputstream) {
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        int i = bytearrayinputstream.read();
        if(!$assertionsDisabled && -1 == i)
            throw new AssertionError();
        int j = i & 0xff;
        if(j > 30)
            if(j == 31)
                j = parseUnsignedInt(bytearrayinputstream);
            else
                throw new RuntimeException("Value length > LENGTH_QUOTE!");
        return j;
    }

    protected static byte[] parseWapString(ByteArrayInputStream bytearrayinputstream, int i) {
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        bytearrayinputstream.mark(1);
        int j = bytearrayinputstream.read();
        if(!$assertionsDisabled && -1 == j)
            throw new AssertionError();
        if(1 == i && 34 == j)
            bytearrayinputstream.mark(1);
        else
        if(i == 0 && 127 == j)
            bytearrayinputstream.mark(1);
        else
            bytearrayinputstream.reset();
        return getWapString(bytearrayinputstream, i);
    }

    protected static int skipWapValue(ByteArrayInputStream bytearrayinputstream, int i) {
        if(!$assertionsDisabled && bytearrayinputstream == null)
            throw new AssertionError();
        int j = bytearrayinputstream.read(new byte[i], 0, i);
        if(j < i)
            j = -1;
        return j;
    }

    public GenericPdu parse() {
        if(mPduDataStream != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((GenericPdu) (obj));
_L2:
        mHeaders = parseHeaders(mPduDataStream);
        if(mHeaders == null) {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        int i = mHeaders.getOctet(140);
        if(!checkMandatoryHeader(mHeaders)) {
            log("check mandatory headers failed!");
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        if(128 == i || 132 == i) {
            mBody = parseParts(mPduDataStream);
            if(mBody == null) {
                obj = null;
                continue; /* Loop/switch isn't completed */
            }
        }
        switch(i) {
        default:
            log("Parser doesn't support this message type in this version!");
            obj = null;
            break;

        case 128: 
            obj = new SendReq(mHeaders, mBody);
            break;

        case 129: 
            obj = new SendConf(mHeaders);
            break;

        case 130: 
            obj = new NotificationInd(mHeaders);
            break;

        case 131: 
            obj = new NotifyRespInd(mHeaders);
            break;

        case 132: 
            obj = new RetrieveConf(mHeaders, mBody);
            byte abyte0[] = ((RetrieveConf) (obj)).getContentType();
            if(abyte0 == null) {
                obj = null;
                break;
            }
            String s = new String(abyte0);
            if(!s.equals("application/vnd.wap.multipart.mixed") && !s.equals("application/vnd.wap.multipart.related") && !s.equals("application/vnd.wap.multipart.alternative"))
                if(s.equals("application/vnd.wap.multipart.alternative")) {
                    PduPart pdupart = mBody.getPart(0);
                    mBody.removeAll();
                    mBody.addPart(0, pdupart);
                } else {
                    obj = null;
                }
            break;

        case 134: 
            obj = new DeliveryInd(mHeaders);
            break;

        case 133: 
            obj = new AcknowledgeInd(mHeaders);
            break;

        case 136: 
            obj = new ReadOrigInd(mHeaders);
            break;

        case 135: 
            obj = new ReadRecInd(mHeaders);
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected PduHeaders parseHeaders(ByteArrayInputStream bytearrayinputstream) {
        if(bytearrayinputstream != null) goto _L2; else goto _L1
_L1:
        PduHeaders pduheaders = null;
_L69:
        return pduheaders;
_L2:
        boolean flag;
        flag = true;
        pduheaders = new PduHeaders();
_L22:
        int i;
        for(; flag && bytearrayinputstream.available() > 0; parseWapString(bytearrayinputstream, 0)) {
            bytearrayinputstream.mark(1);
            i = extractByteValue(bytearrayinputstream);
            if(i < 32 || i > 127)
                break MISSING_BLOCK_LABEL_67;
            bytearrayinputstream.reset();
        }

          goto _L3
        i;
        JVM INSTR tableswitch 129 191: default 336
    //                   129 824
    //                   130 824
    //                   131 695
    //                   132 1859
    //                   133 607
    //                   134 517
    //                   135 959
    //                   136 959
    //                   137 1073
    //                   138 1273
    //                   139 695
    //                   140 345
    //                   141 1500
    //                   142 607
    //                   143 517
    //                   144 517
    //                   145 517
    //                   146 517
    //                   147 760
    //                   148 517
    //                   149 517
    //                   150 760
    //                   151 824
    //                   152 695
    //                   153 517
    //                   154 760
    //                   155 517
    //                   156 517
    //                   157 959
    //                   158 695
    //                   159 607
    //                   160 1591
    //                   161 1697
    //                   162 517
    //                   163 517
    //                   164 1783
    //                   165 517
    //                   166 760
    //                   167 517
    //                   168 336
    //                   169 517
    //                   170 1801
    //                   171 517
    //                   172 1801
    //                   173 651
    //                   174 336
    //                   175 651
    //                   176 336
    //                   177 517
    //                   178 1850
    //                   179 651
    //                   180 517
    //                   181 760
    //                   182 760
    //                   183 695
    //                   184 695
    //                   185 695
    //                   186 517
    //                   187 517
    //                   188 517
    //                   189 695
    //                   190 695
    //                   191 517;
           goto _L4 _L5 _L5 _L6 _L7 _L8 _L9 _L10 _L10 _L11 _L12 _L6 _L13 _L14 _L8 _L9 _L9 _L9 _L9 _L15 _L9 _L9 _L15 _L5 _L6 _L9 _L15 _L9 _L9 _L10 _L6 _L8 _L16 _L17 _L9 _L9 _L18 _L9 _L15 _L9 _L4 _L9 _L19 _L9 _L19 _L20 _L4 _L20 _L4 _L9 _L21 _L20 _L9 _L15 _L15 _L6 _L6 _L6 _L9 _L9 _L9 _L6 _L6 _L9
_L4:
        log("Unknown header");
          goto _L22
_L13:
        int i2 = extractByteValue(bytearrayinputstream);
        switch(i2) {
        default:
            try {
                pduheaders.setOctet(i2, i);
                continue; /* Loop/switch isn't completed */
            }
            catch(InvalidHeaderValueException invalidheadervalueexception2) {
                log((new StringBuilder()).append("Set invalid Octet value: ").append(i2).append(" into the header filed: ").append(i).toString());
                pduheaders = null;
            }
            catch(RuntimeException runtimeexception18) {
                log((new StringBuilder()).append(i).append("is not Octet header field!").toString());
                pduheaders = null;
            }
            break;

        case 137: 
        case 138: 
        case 139: 
        case 140: 
        case 141: 
        case 142: 
        case 143: 
        case 144: 
        case 145: 
        case 146: 
        case 147: 
        case 148: 
        case 149: 
        case 150: 
        case 151: 
            pduheaders = null;
            break;
        }
        break; /* Loop/switch isn't completed */
        if(true) goto _L3; else goto _L23
_L3:
        if(true) goto _L24; else goto _L23
_L24:
        if(true) goto _L25; else goto _L23
_L25:
        if(true) goto _L26; else goto _L23
_L26:
        if(true) goto _L27; else goto _L23
_L27:
        if(true) goto _L28; else goto _L23
_L28:
        if(true) goto _L29; else goto _L23
_L29:
        if(true) goto _L30; else goto _L23
_L30:
        if(true) goto _L31; else goto _L23
_L31:
        if(true) goto _L32; else goto _L23
_L32:
        if(true) goto _L33; else goto _L23
_L33:
        if(true) goto _L34; else goto _L23
_L34:
        if(true) goto _L35; else goto _L23
_L35:
        if(true) goto _L36; else goto _L23
_L36:
        if(true) goto _L37; else goto _L23
_L37:
        if(true) goto _L38; else goto _L23
_L38:
        if(true) goto _L39; else goto _L23
_L39:
        if(true) goto _L40; else goto _L23
_L40:
        if(true) goto _L41; else goto _L23
_L41:
        if(true) goto _L42; else goto _L23
_L42:
        if(true) goto _L43; else goto _L23
_L43:
        if(true) goto _L44; else goto _L23
_L44:
        if(true) goto _L45; else goto _L23
_L45:
        if(true) goto _L46; else goto _L23
_L46:
        if(true) goto _L47; else goto _L23
_L47:
        if(true) goto _L48; else goto _L23
_L48:
        if(true) goto _L49; else goto _L23
_L49:
        if(true) goto _L50; else goto _L23
_L50:
        if(true) goto _L51; else goto _L23
_L51:
        if(true) goto _L52; else goto _L23
_L52:
        if(true) goto _L53; else goto _L23
_L53:
        if(true) goto _L54; else goto _L23
_L54:
        if(true) goto _L55; else goto _L23
_L55:
        if(true) goto _L56; else goto _L23
_L56:
        if(true) goto _L57; else goto _L23
_L57:
        if(true) goto _L58; else goto _L23
_L58:
        if(true)
            break; /* Loop/switch isn't completed */
_L23:
_L9:
        int k1 = extractByteValue(bytearrayinputstream);
        try {
            pduheaders.setOctet(k1, i);
            continue; /* Loop/switch isn't completed */
        }
        catch(InvalidHeaderValueException invalidheadervalueexception1) {
            log((new StringBuilder()).append("Set invalid Octet value: ").append(k1).append(" into the header filed: ").append(i).toString());
            pduheaders = null;
        }
        catch(RuntimeException runtimeexception17) {
            log((new StringBuilder()).append(i).append("is not Octet header field!").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L8:
        try {
            pduheaders.setLongInteger(parseLongInteger(bytearrayinputstream), i);
            continue; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception16) {
            log((new StringBuilder()).append(i).append("is not Long-Integer header field!").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L20:
        try {
            pduheaders.setLongInteger(parseIntegerValue(bytearrayinputstream), i);
            continue; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception15) {
            log((new StringBuilder()).append(i).append("is not Long-Integer header field!").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L6:
        byte abyte4[] = parseWapString(bytearrayinputstream, 0);
        if(abyte4 == null)
            continue; /* Loop/switch isn't completed */
        try {
            pduheaders.setTextString(abyte4, i);
            continue; /* Loop/switch isn't completed */
        }
        catch(NullPointerException nullpointerexception10) {
            log("null pointer error!");
            continue; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception14) {
            log((new StringBuilder()).append(i).append("is not Text-String header field!").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L15:
        EncodedStringValue encodedstringvalue3 = parseEncodedStringValue(bytearrayinputstream);
        if(encodedstringvalue3 == null)
            continue; /* Loop/switch isn't completed */
        try {
            pduheaders.setEncodedStringValue(encodedstringvalue3, i);
            continue; /* Loop/switch isn't completed */
        }
        catch(NullPointerException nullpointerexception9) {
            log("null pointer error!");
            continue; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception13) {
            log((new StringBuilder()).append(i).append("is not Encoded-String-Value header field!").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L5:
        EncodedStringValue encodedstringvalue2 = parseEncodedStringValue(bytearrayinputstream);
        if(encodedstringvalue2 == null)
            continue; /* Loop/switch isn't completed */
        byte abyte3[] = encodedstringvalue2.getTextString();
        if(abyte3 != null) {
            String s1 = new String(abyte3);
            int j1 = s1.indexOf("/");
            if(j1 > 0)
                s1 = s1.substring(0, j1);
            NullPointerException nullpointerexception8;
            try {
                encodedstringvalue2.setTextString(s1.getBytes());
            }
            catch(NullPointerException nullpointerexception7) {
                log("null pointer error!");
                pduheaders = null;
                break; /* Loop/switch isn't completed */
            }
        }
        try {
            pduheaders.appendEncodedStringValue(encodedstringvalue2, i);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch(NullPointerException nullpointerexception8) {
            log("null pointer error!");
            continue; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception12) {
            log((new StringBuilder()).append(i).append("is not Encoded-String-Value header field!").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L10:
        parseValueLength(bytearrayinputstream);
        int i1 = extractByteValue(bytearrayinputstream);
        long l1;
        long l2;
        try {
            l1 = parseLongInteger(bytearrayinputstream);
        }
        catch(RuntimeException runtimeexception10) {
            log((new StringBuilder()).append(i).append("is not Long-Integer header field!").toString());
            pduheaders = null;
            break; /* Loop/switch isn't completed */
        }
        l2 = l1;
        if(129 == i1)
            l2 += System.currentTimeMillis() / 1000L;
        try {
            pduheaders.setLongInteger(l2, i);
            continue; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception11) {
            log((new StringBuilder()).append(i).append("is not Long-Integer header field!").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L11:
        parseValueLength(bytearrayinputstream);
        EncodedStringValue encodedstringvalue1;
        if(128 == extractByteValue(bytearrayinputstream)) {
            encodedstringvalue1 = parseEncodedStringValue(bytearrayinputstream);
            if(encodedstringvalue1 != null) {
                byte abyte2[] = encodedstringvalue1.getTextString();
                if(abyte2 != null) {
                    String s = new String(abyte2);
                    int l = s.indexOf("/");
                    if(l > 0)
                        s = s.substring(0, l);
                    NullPointerException nullpointerexception4;
                    try {
                        encodedstringvalue1.setTextString(s.getBytes());
                    }
                    catch(NullPointerException nullpointerexception6) {
                        log("null pointer error!");
                        pduheaders = null;
                        break; /* Loop/switch isn't completed */
                    }
                }
            }
        } else {
            try {
                encodedstringvalue1 = new EncodedStringValue("insert-address-token".getBytes());
            }
            catch(NullPointerException nullpointerexception5) {
                log((new StringBuilder()).append(i).append("is not Encoded-String-Value header field!").toString());
                pduheaders = null;
                break; /* Loop/switch isn't completed */
            }
        }
        try {
            pduheaders.setEncodedStringValue(encodedstringvalue1, 137);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch(NullPointerException nullpointerexception4) {
            log("null pointer error!");
            continue; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception9) {
            log((new StringBuilder()).append(i).append("is not Encoded-String-Value header field!").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L12:
        int k;
        bytearrayinputstream.mark(1);
        k = extractByteValue(bytearrayinputstream);
        if(k < 128) goto _L60; else goto _L59
_L59:
        if(128 == k) {
            try {
                pduheaders.setTextString("personal".getBytes(), 138);
                continue; /* Loop/switch isn't completed */
            }
            catch(NullPointerException nullpointerexception3) {
                log("null pointer error!");
                continue; /* Loop/switch isn't completed */
            }
            catch(RuntimeException runtimeexception8) {
                log((new StringBuilder()).append(i).append("is not Text-String header field!").toString());
                pduheaders = null;
            }
            break; /* Loop/switch isn't completed */
        }
        if(129 != k) goto _L62; else goto _L61
_L61:
        pduheaders.setTextString("advertisement".getBytes(), 138);
        continue; /* Loop/switch isn't completed */
_L62:
        if(130 != k) goto _L64; else goto _L63
_L63:
        pduheaders.setTextString("informational".getBytes(), 138);
        continue; /* Loop/switch isn't completed */
_L64:
        if(131 == k)
            pduheaders.setTextString("auto".getBytes(), 138);
        continue; /* Loop/switch isn't completed */
_L60:
        bytearrayinputstream.reset();
        byte abyte1[] = parseWapString(bytearrayinputstream, 0);
        if(abyte1 == null)
            continue; /* Loop/switch isn't completed */
        try {
            pduheaders.setTextString(abyte1, 138);
            continue; /* Loop/switch isn't completed */
        }
        catch(NullPointerException nullpointerexception2) {
            log("null pointer error!");
            continue; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception7) {
            log((new StringBuilder()).append(i).append("is not Text-String header field!").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L14:
        int j = parseShortInteger(bytearrayinputstream);
        try {
            pduheaders.setOctet(j, 141);
            continue; /* Loop/switch isn't completed */
        }
        catch(InvalidHeaderValueException invalidheadervalueexception) {
            log((new StringBuilder()).append("Set invalid Octet value: ").append(j).append(" into the header filed: ").append(i).toString());
            pduheaders = null;
        }
        catch(RuntimeException runtimeexception6) {
            log((new StringBuilder()).append(i).append("is not Octet header field!").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L16:
        parseValueLength(bytearrayinputstream);
        EncodedStringValue encodedstringvalue;
        try {
            parseIntegerValue(bytearrayinputstream);
        }
        catch(RuntimeException runtimeexception4) {
            log((new StringBuilder()).append(i).append(" is not Integer-Value").toString());
            pduheaders = null;
            break; /* Loop/switch isn't completed */
        }
        encodedstringvalue = parseEncodedStringValue(bytearrayinputstream);
        if(encodedstringvalue == null)
            continue; /* Loop/switch isn't completed */
        try {
            pduheaders.setEncodedStringValue(encodedstringvalue, 160);
            continue; /* Loop/switch isn't completed */
        }
        catch(NullPointerException nullpointerexception1) {
            log("null pointer error!");
            continue; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception5) {
            log((new StringBuilder()).append(i).append("is not Encoded-String-Value header field!").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L17:
        parseValueLength(bytearrayinputstream);
        try {
            parseIntegerValue(bytearrayinputstream);
        }
        catch(RuntimeException runtimeexception2) {
            log((new StringBuilder()).append(i).append(" is not Integer-Value").toString());
            pduheaders = null;
            break; /* Loop/switch isn't completed */
        }
        try {
            pduheaders.setLongInteger(parseLongInteger(bytearrayinputstream), 161);
            continue; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception3) {
            log((new StringBuilder()).append(i).append("is not Long-Integer header field!").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L18:
        parseValueLength(bytearrayinputstream);
        extractByteValue(bytearrayinputstream);
        parseEncodedStringValue(bytearrayinputstream);
        continue; /* Loop/switch isn't completed */
_L19:
        parseValueLength(bytearrayinputstream);
        extractByteValue(bytearrayinputstream);
        try {
            parseIntegerValue(bytearrayinputstream);
            continue; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception1) {
            log((new StringBuilder()).append(i).append(" is not Integer-Value").toString());
            pduheaders = null;
        }
        break; /* Loop/switch isn't completed */
_L21:
        parseContentType(bytearrayinputstream, null);
        continue; /* Loop/switch isn't completed */
_L7:
        HashMap hashmap;
        byte abyte0[];
        hashmap = new HashMap();
        abyte0 = parseContentType(bytearrayinputstream, hashmap);
        if(abyte0 == null)
            break MISSING_BLOCK_LABEL_1890;
        pduheaders.setTextString(abyte0, 132);
_L66:
        mStartParam = (byte[])(byte[])hashmap.get(Integer.valueOf(153));
        mTypeParam = (byte[])(byte[])hashmap.get(Integer.valueOf(131));
        flag = false;
        continue; /* Loop/switch isn't completed */
        NullPointerException nullpointerexception;
        nullpointerexception;
        log("null pointer error!");
        if(true) goto _L66; else goto _L65
_L65:
        RuntimeException runtimeexception;
        runtimeexception;
        log((new StringBuilder()).append(i).append("is not Text-String header field!").toString());
        pduheaders = null;
        break; /* Loop/switch isn't completed */
        if(true) goto _L22; else goto _L67
_L67:
        if(true) goto _L69; else goto _L68
_L68:
    }

    static final boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final int END_STRING_FLAG = 0;
    private static final int LENGTH_QUOTE = 31;
    private static final boolean LOCAL_LOGV = false;
    private static final String LOG_TAG = "PduParser";
    private static final int LONG_INTEGER_LENGTH_MAX = 8;
    private static final int QUOTE = 127;
    private static final int QUOTED_STRING_FLAG = 34;
    private static final int SHORT_INTEGER_MAX = 127;
    private static final int SHORT_LENGTH_MAX = 30;
    private static final int TEXT_MAX = 127;
    private static final int TEXT_MIN = 32;
    private static final int THE_FIRST_PART = 0;
    private static final int THE_LAST_PART = 1;
    private static final int TYPE_QUOTED_STRING = 1;
    private static final int TYPE_TEXT_STRING = 0;
    private static final int TYPE_TOKEN_STRING = 2;
    private static byte mStartParam[] = null;
    private static byte mTypeParam[] = null;
    private PduBody mBody;
    private PduHeaders mHeaders;
    private ByteArrayInputStream mPduDataStream;

    static  {
        boolean flag;
        if(!com/google/android/mms/pdu/PduParser.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }
}
