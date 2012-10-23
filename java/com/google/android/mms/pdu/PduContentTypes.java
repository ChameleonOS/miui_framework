// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;


public class PduContentTypes {

    public PduContentTypes() {
    }

    static final String contentTypes[];

    static  {
        String as[] = new String[83];
        as[0] = "*/*";
        as[1] = "text/*";
        as[2] = "text/html";
        as[3] = "text/plain";
        as[4] = "text/x-hdml";
        as[5] = "text/x-ttml";
        as[6] = "text/x-vCalendar";
        as[7] = "text/x-vCard";
        as[8] = "text/vnd.wap.wml";
        as[9] = "text/vnd.wap.wmlscript";
        as[10] = "text/vnd.wap.wta-event";
        as[11] = "multipart/*";
        as[12] = "multipart/mixed";
        as[13] = "multipart/form-data";
        as[14] = "multipart/byterantes";
        as[15] = "multipart/alternative";
        as[16] = "application/*";
        as[17] = "application/java-vm";
        as[18] = "application/x-www-form-urlencoded";
        as[19] = "application/x-hdmlc";
        as[20] = "application/vnd.wap.wmlc";
        as[21] = "application/vnd.wap.wmlscriptc";
        as[22] = "application/vnd.wap.wta-eventc";
        as[23] = "application/vnd.wap.uaprof";
        as[24] = "application/vnd.wap.wtls-ca-certificate";
        as[25] = "application/vnd.wap.wtls-user-certificate";
        as[26] = "application/x-x509-ca-cert";
        as[27] = "application/x-x509-user-cert";
        as[28] = "image/*";
        as[29] = "image/gif";
        as[30] = "image/jpeg";
        as[31] = "image/tiff";
        as[32] = "image/png";
        as[33] = "image/vnd.wap.wbmp";
        as[34] = "application/vnd.wap.multipart.*";
        as[35] = "application/vnd.wap.multipart.mixed";
        as[36] = "application/vnd.wap.multipart.form-data";
        as[37] = "application/vnd.wap.multipart.byteranges";
        as[38] = "application/vnd.wap.multipart.alternative";
        as[39] = "application/xml";
        as[40] = "text/xml";
        as[41] = "application/vnd.wap.wbxml";
        as[42] = "application/x-x968-cross-cert";
        as[43] = "application/x-x968-ca-cert";
        as[44] = "application/x-x968-user-cert";
        as[45] = "text/vnd.wap.si";
        as[46] = "application/vnd.wap.sic";
        as[47] = "text/vnd.wap.sl";
        as[48] = "application/vnd.wap.slc";
        as[49] = "text/vnd.wap.co";
        as[50] = "application/vnd.wap.coc";
        as[51] = "application/vnd.wap.multipart.related";
        as[52] = "application/vnd.wap.sia";
        as[53] = "text/vnd.wap.connectivity-xml";
        as[54] = "application/vnd.wap.connectivity-wbxml";
        as[55] = "application/pkcs7-mime";
        as[56] = "application/vnd.wap.hashed-certificate";
        as[57] = "application/vnd.wap.signed-certificate";
        as[58] = "application/vnd.wap.cert-response";
        as[59] = "application/xhtml+xml";
        as[60] = "application/wml+xml";
        as[61] = "text/css";
        as[62] = "application/vnd.wap.mms-message";
        as[63] = "application/vnd.wap.rollover-certificate";
        as[64] = "application/vnd.wap.locc+wbxml";
        as[65] = "application/vnd.wap.loc+xml";
        as[66] = "application/vnd.syncml.dm+wbxml";
        as[67] = "application/vnd.syncml.dm+xml";
        as[68] = "application/vnd.syncml.notification";
        as[69] = "application/vnd.wap.xhtml+xml";
        as[70] = "application/vnd.wv.csp.cir";
        as[71] = "application/vnd.oma.dd+xml";
        as[72] = "application/vnd.oma.drm.message";
        as[73] = "application/vnd.oma.drm.content";
        as[74] = "application/vnd.oma.drm.rights+xml";
        as[75] = "application/vnd.oma.drm.rights+wbxml";
        as[76] = "application/vnd.wv.csp+xml";
        as[77] = "application/vnd.wv.csp+wbxml";
        as[78] = "application/vnd.syncml.ds.notification";
        as[79] = "audio/*";
        as[80] = "video/*";
        as[81] = "application/vnd.oma.dd2+xml";
        as[82] = "application/mikey";
        contentTypes = as;
    }
}
