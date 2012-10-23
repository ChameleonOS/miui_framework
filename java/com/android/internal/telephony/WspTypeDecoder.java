// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import java.util.HashMap;

public class WspTypeDecoder {

    public WspTypeDecoder(byte abyte0[]) {
        wspData = abyte0;
    }

    private boolean decodeNoValue(int i) {
        boolean flag = true;
        if(wspData[i] == 0)
            dataLength = ((flag) ? 1 : 0);
        else
            flag = false;
        return flag;
    }

    private void expandWellKnownMimeType() {
        if(stringValue == null) {
            int i = (int)unsigned32bit;
            stringValue = (String)WELL_KNOWN_MIME_TYPES.get(Integer.valueOf(i));
        } else {
            unsigned32bit = -1L;
        }
    }

    private boolean readContentParameters(int i, int j, int k) {
        boolean flag;
        byte byte0;
        flag = false;
        if(j <= 0)
            break MISSING_BLOCK_LABEL_341;
        byte0 = wspData[i];
        if((byte0 & 0x80) != 0 || byte0 <= 31) goto _L2; else goto _L1
_L1:
        int l;
        String s;
        decodeTokenText(i);
        s = stringValue;
        l = 0 + dataLength;
_L6:
        int i1;
        int j1;
        String s1;
        int k1;
        String s2;
        if(decodeNoValue(i + l)) {
            k1 = l + dataLength;
            s2 = null;
        } else
        if(decodeIntegerValue(i + l)) {
            k1 = l + dataLength;
            int l1 = (int)unsigned32bit;
            if(l1 == 0)
                s2 = "";
            else
                s2 = String.valueOf(l1);
        } else {
            decodeTokenText(i + l);
            k1 = l + dataLength;
            s2 = stringValue;
            if(s2.startsWith("\""))
                s2 = s2.substring(1);
        }
        contentParameters.put(s, s2);
        flag = readContentParameters(i + k1, j - k1, k + k1);
_L4:
        return flag;
_L2:
        if(!decodeIntegerValue(i)) goto _L4; else goto _L3
_L3:
        l = 0 + dataLength;
        i1 = (int)unsigned32bit;
        s = (String)WELL_KNOWN_PARAMETERS.get(Integer.valueOf(i1));
        if(s == null)
            s = (new StringBuilder()).append("unassigned/0x").append(Long.toHexString(i1)).toString();
        if(i1 != 0) goto _L6; else goto _L5
_L5:
        if(decodeUintvarInteger(i + l)) {
            j1 = l + dataLength;
            s1 = String.valueOf(unsigned32bit);
            contentParameters.put(s, s1);
            flag = readContentParameters(i + j1, j - j1, k + j1);
        }
          goto _L4
        dataLength = k;
        flag = true;
          goto _L4
    }

    public boolean decodeConstrainedEncoding(int i) {
        boolean flag = true;
        if(decodeShortInteger(i) == flag)
            stringValue = null;
        else
            flag = decodeExtensionMedia(i);
        return flag;
    }

    public boolean decodeContentLength(int i) {
        return decodeIntegerValue(i);
    }

    public boolean decodeContentLocation(int i) {
        return decodeTextString(i);
    }

    public boolean decodeContentType(int i) {
        boolean flag;
        flag = true;
        contentParameters = new HashMap();
        if(decodeValueLength(i)) goto _L2; else goto _L1
_L1:
        flag = decodeConstrainedEncoding(i);
        if(flag)
            expandWellKnownMimeType();
          goto _L3
_L2:
        int j;
        int k;
        j = (int)unsigned32bit;
        k = getDecodedDataLength();
        if(decodeIntegerValue(i + k) != flag) goto _L5; else goto _L4
_L4:
        int i1;
        long l2;
        String s1;
        dataLength = k + dataLength;
        i1 = dataLength;
        stringValue = null;
        expandWellKnownMimeType();
        l2 = unsigned32bit;
        s1 = stringValue;
        if(!readContentParameters(i + dataLength, j - (dataLength - k), 0)) goto _L7; else goto _L6
_L6:
        dataLength = i1 + dataLength;
        unsigned32bit = l2;
        stringValue = s1;
          goto _L3
_L5:
        if(decodeExtensionMedia(i + k) != flag) goto _L9; else goto _L8
_L8:
        int l;
        long l1;
        String s;
        dataLength = k + dataLength;
        l = dataLength;
        expandWellKnownMimeType();
        l1 = unsigned32bit;
        s = stringValue;
        if(!readContentParameters(i + dataLength, j - (dataLength - k), 0)) goto _L9; else goto _L10
_L10:
        dataLength = l + dataLength;
        unsigned32bit = l1;
        stringValue = s;
          goto _L3
_L9:
        flag = false;
_L3:
        return flag;
        ArrayIndexOutOfBoundsException arrayindexoutofboundsexception;
        arrayindexoutofboundsexception;
        flag = false;
        continue; /* Loop/switch isn't completed */
_L7:
        flag = false;
        if(true) goto _L3; else goto _L11
_L11:
    }

    public boolean decodeExtensionMedia(int i) {
        boolean flag = false;
        int j = i;
        dataLength = 0;
        stringValue = null;
        int k = wspData.length;
        if(j < k)
            flag = true;
        for(; j < k && wspData[j] != 0; j++);
        dataLength = 1 + (j - i);
        stringValue = new String(wspData, i, -1 + dataLength);
        return flag;
    }

    public boolean decodeIntegerValue(int i) {
        boolean flag = true;
        if(decodeShortInteger(i) != flag)
            flag = decodeLongInteger(i);
        return flag;
    }

    public boolean decodeLongInteger(int i) {
        int j = 0xff & wspData[i];
        boolean flag;
        if(j > 30) {
            flag = false;
        } else {
            unsigned32bit = 0L;
            for(int k = 1; k <= j; k++)
                unsigned32bit = unsigned32bit << 8 | (long)(0xff & wspData[i + k]);

            dataLength = j + 1;
            flag = true;
        }
        return flag;
    }

    public boolean decodeShortInteger(int i) {
        boolean flag = true;
        if((0x80 & wspData[i]) == 0) {
            flag = false;
        } else {
            unsigned32bit = 0x7f & wspData[i];
            dataLength = ((flag) ? 1 : 0);
        }
        return flag;
    }

    public boolean decodeTextString(int i) {
        int j;
        for(j = i; wspData[j] != 0; j++);
        dataLength = 1 + (j - i);
        if(wspData[i] == 127)
            stringValue = new String(wspData, i + 1, -2 + dataLength);
        else
            stringValue = new String(wspData, i, -1 + dataLength);
        return true;
    }

    public boolean decodeTokenText(int i) {
        int j;
        for(j = i; wspData[j] != 0; j++);
        dataLength = 1 + (j - i);
        stringValue = new String(wspData, i, -1 + dataLength);
        return true;
    }

    public boolean decodeUintvarInteger(int i) {
        int j;
        j = i;
        unsigned32bit = 0L;
_L3:
        if((0x80 & wspData[j]) == 0)
            break MISSING_BLOCK_LABEL_59;
        if(j - i < 4) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        unsigned32bit = unsigned32bit << 7 | (long)(0x7f & wspData[j]);
        j++;
          goto _L3
        unsigned32bit = unsigned32bit << 7 | (long)(0x7f & wspData[j]);
        dataLength = 1 + (j - i);
        flag = true;
          goto _L4
    }

    public boolean decodeValueLength(int i) {
        boolean flag = true;
        if((0xff & wspData[i]) > 31)
            flag = false;
        else
        if(wspData[i] < 31) {
            unsigned32bit = wspData[i];
            dataLength = ((flag) ? 1 : 0);
        } else {
            decodeUintvarInteger(i + 1);
            dataLength = 1 + dataLength;
        }
        return flag;
    }

    public boolean decodeXWapApplicationId(int i) {
        boolean flag = true;
        if(decodeIntegerValue(i) == flag)
            stringValue = null;
        else
            flag = decodeTextString(i);
        return flag;
    }

    public boolean decodeXWapContentURI(int i) {
        return decodeTextString(i);
    }

    public boolean decodeXWapInitiatorURI(int i) {
        return decodeTextString(i);
    }

    public HashMap getContentParameters() {
        return contentParameters;
    }

    public int getDecodedDataLength() {
        return dataLength;
    }

    public long getValue32() {
        return unsigned32bit;
    }

    public String getValueString() {
        return stringValue;
    }

    public boolean seekXWapApplicationId(int i, int j) {
        boolean flag = false;
        int k = i;
label0:
        do {
label1:
            {
                if(k > j)
                    break label0;
                int l;
                int i1;
                try {
                    if(decodeIntegerValue(k)) {
                        if((int)getValue32() == 47) {
                            unsigned32bit = k + 1;
                            flag = true;
                            break label0;
                        }
                    } else
                    if(!decodeTextString(k))
                        break label0;
                    l = k + getDecodedDataLength();
                    if(l > j)
                        break label0;
                    byte byte0 = wspData[l];
                    if(byte0 >= 0 && byte0 <= 30) {
                        k = l + (1 + wspData[l]);
                        continue;
                    }
                    if(byte0 == 31) {
                        if(l + 1 >= j)
                            break label0;
                        int j1 = l + 1;
                        if(!decodeUintvarInteger(j1))
                            break label0;
                        k = j1 + getDecodedDataLength();
                        continue;
                    }
                    if(31 >= byte0 || byte0 > 127)
                        break label1;
                    if(!decodeTextString(l))
                        break label0;
                    i1 = getDecodedDataLength();
                }
                catch(ArrayIndexOutOfBoundsException arrayindexoutofboundsexception) {
                    break label0;
                }
                k = l + i1;
                continue;
            }
            k = l + 1;
        } while(true);
        return flag;
    }

    public static final String CONTENT_TYPE_B_MMS = "application/vnd.wap.mms-message";
    public static final String CONTENT_TYPE_B_PUSH_CO = "application/vnd.wap.coc";
    public static final String CONTENT_TYPE_B_PUSH_SYNCML_NOTI = "application/vnd.syncml.notification";
    public static final int PARAMETER_ID_X_WAP_APPLICATION_ID = 47;
    public static final int PDU_TYPE_CONFIRMED_PUSH = 7;
    public static final int PDU_TYPE_PUSH = 6;
    private static final int Q_VALUE = 0;
    private static final int WAP_PDU_LENGTH_QUOTE = 31;
    private static final int WAP_PDU_SHORT_LENGTH_MAX = 30;
    private static final HashMap WELL_KNOWN_MIME_TYPES;
    private static final HashMap WELL_KNOWN_PARAMETERS;
    HashMap contentParameters;
    int dataLength;
    String stringValue;
    long unsigned32bit;
    byte wspData[];

    static  {
        WELL_KNOWN_MIME_TYPES = new HashMap();
        WELL_KNOWN_PARAMETERS = new HashMap();
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(0), "*/*");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(1), "text/*");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(2), "text/html");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(3), "text/plain");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(4), "text/x-hdml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(5), "text/x-ttml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(6), "text/x-vCalendar");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(7), "text/x-vCard");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(8), "text/vnd.wap.wml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(9), "text/vnd.wap.wmlscript");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(10), "text/vnd.wap.wta-event");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(11), "multipart/*");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(12), "multipart/mixed");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(13), "multipart/form-data");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(14), "multipart/byterantes");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(15), "multipart/alternative");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(16), "application/*");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(17), "application/java-vm");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(18), "application/x-www-form-urlencoded");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(19), "application/x-hdmlc");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(20), "application/vnd.wap.wmlc");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(21), "application/vnd.wap.wmlscriptc");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(22), "application/vnd.wap.wta-eventc");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(23), "application/vnd.wap.uaprof");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(24), "application/vnd.wap.wtls-ca-certificate");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(25), "application/vnd.wap.wtls-user-certificate");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(26), "application/x-x509-ca-cert");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(27), "application/x-x509-user-cert");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(28), "image/*");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(29), "image/gif");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(30), "image/jpeg");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(31), "image/tiff");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(32), "image/png");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(33), "image/vnd.wap.wbmp");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(34), "application/vnd.wap.multipart.*");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(35), "application/vnd.wap.multipart.mixed");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(36), "application/vnd.wap.multipart.form-data");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(37), "application/vnd.wap.multipart.byteranges");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(38), "application/vnd.wap.multipart.alternative");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(39), "application/xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(40), "text/xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(41), "application/vnd.wap.wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(42), "application/x-x968-cross-cert");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(43), "application/x-x968-ca-cert");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(44), "application/x-x968-user-cert");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(45), "text/vnd.wap.si");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(46), "application/vnd.wap.sic");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(47), "text/vnd.wap.sl");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(48), "application/vnd.wap.slc");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(49), "text/vnd.wap.co");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(50), "application/vnd.wap.coc");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(51), "application/vnd.wap.multipart.related");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(52), "application/vnd.wap.sia");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(53), "text/vnd.wap.connectivity-xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(54), "application/vnd.wap.connectivity-wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(55), "application/pkcs7-mime");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(56), "application/vnd.wap.hashed-certificate");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(57), "application/vnd.wap.signed-certificate");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(58), "application/vnd.wap.cert-response");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(59), "application/xhtml+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(60), "application/wml+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(61), "text/css");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(62), "application/vnd.wap.mms-message");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(63), "application/vnd.wap.rollover-certificate");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(64), "application/vnd.wap.locc+wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(65), "application/vnd.wap.loc+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(66), "application/vnd.syncml.dm+wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(67), "application/vnd.syncml.dm+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(68), "application/vnd.syncml.notification");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(69), "application/vnd.wap.xhtml+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(70), "application/vnd.wv.csp.cir");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(71), "application/vnd.oma.dd+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(72), "application/vnd.oma.drm.message");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(73), "application/vnd.oma.drm.content");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(74), "application/vnd.oma.drm.rights+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(75), "application/vnd.oma.drm.rights+wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(76), "application/vnd.wv.csp+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(77), "application/vnd.wv.csp+wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(78), "application/vnd.syncml.ds.notification");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(79), "audio/*");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(80), "video/*");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(81), "application/vnd.oma.dd2+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(82), "application/mikey");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(83), "application/vnd.oma.dcd");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(84), "application/vnd.oma.dcdc");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(513), "application/vnd.uplanet.cacheop-wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(514), "application/vnd.uplanet.signal");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(515), "application/vnd.uplanet.alert-wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(516), "application/vnd.uplanet.list-wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(517), "application/vnd.uplanet.listcmd-wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(518), "application/vnd.uplanet.channel-wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(519), "application/vnd.uplanet.provisioning-status-uri");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(520), "x-wap.multipart/vnd.uplanet.header-set");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(521), "application/vnd.uplanet.bearer-choice-wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(522), "application/vnd.phonecom.mmc-wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(523), "application/vnd.nokia.syncset+wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(524), "image/x-up-wpng");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(768), "application/iota.mmc-wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(769), "application/iota.mmc-xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(770), "application/vnd.syncml+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(771), "application/vnd.syncml+wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(772), "text/vnd.wap.emn+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(773), "text/calendar");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(774), "application/vnd.omads-email+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(775), "application/vnd.omads-file+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(776), "application/vnd.omads-folder+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(777), "text/directory;profile=vCard");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(778), "application/vnd.wap.emn+wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(779), "application/vnd.nokia.ipdc-purchase-response");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(780), "application/vnd.motorola.screen3+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(781), "application/vnd.motorola.screen3+gzip");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(782), "application/vnd.cmcc.setting+wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(783), "application/vnd.cmcc.bombing+wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(784), "application/vnd.docomo.pf");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(785), "application/vnd.docomo.ub");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(786), "application/vnd.omaloc-supl-init");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(787), "application/vnd.oma.group-usage-list+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(788), "application/oma-directory+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(789), "application/vnd.docomo.pf2");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(790), "application/vnd.oma.drm.roap-trigger+wbxml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(791), "application/vnd.sbm.mid2");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(792), "application/vnd.wmf.bootstrap");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(793), "application/vnc.cmcc.dcd+xml");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(794), "application/vnd.sbm.cid");
        WELL_KNOWN_MIME_TYPES.put(Integer.valueOf(795), "application/vnd.oma.bcast.provisioningtrigger");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(0), "Q");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(1), "Charset");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(2), "Level");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(3), "Type");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(7), "Differences");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(8), "Padding");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(9), "Type");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(14), "Max-Age");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(16), "Secure");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(17), "SEC");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(18), "MAC");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(19), "Creation-date");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(20), "Modification-date");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(21), "Read-date");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(22), "Size");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(23), "Name");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(24), "Filename");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(25), "Start");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(26), "Start-info");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(27), "Comment");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(28), "Domain");
        WELL_KNOWN_PARAMETERS.put(Integer.valueOf(29), "Path");
    }
}
