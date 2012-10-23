// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.google.android.mms.pdu;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public class PduPart {

    public PduPart() {
        mPartHeader = null;
        mUri = null;
        mPartData = null;
        mPartHeader = new HashMap();
    }

    public String generateLocation() {
        byte abyte0[] = (byte[])(byte[])mPartHeader.get(Integer.valueOf(151));
        if(abyte0 == null) {
            abyte0 = (byte[])(byte[])mPartHeader.get(Integer.valueOf(152));
            if(abyte0 == null)
                abyte0 = (byte[])(byte[])mPartHeader.get(Integer.valueOf(142));
        }
        String s;
        if(abyte0 == null) {
            byte abyte1[] = (byte[])(byte[])mPartHeader.get(Integer.valueOf(192));
            s = (new StringBuilder()).append("cid:").append(new String(abyte1)).toString();
        } else {
            s = new String(abyte0);
        }
        return s;
    }

    public int getCharset() {
        Integer integer = (Integer)mPartHeader.get(Integer.valueOf(129));
        int i;
        if(integer == null)
            i = 0;
        else
            i = integer.intValue();
        return i;
    }

    public byte[] getContentDisposition() {
        return (byte[])(byte[])mPartHeader.get(Integer.valueOf(197));
    }

    public byte[] getContentId() {
        return (byte[])(byte[])mPartHeader.get(Integer.valueOf(192));
    }

    public byte[] getContentLocation() {
        return (byte[])(byte[])mPartHeader.get(Integer.valueOf(142));
    }

    public byte[] getContentTransferEncoding() {
        return (byte[])(byte[])mPartHeader.get(Integer.valueOf(200));
    }

    public byte[] getContentType() {
        return (byte[])(byte[])mPartHeader.get(Integer.valueOf(145));
    }

    public byte[] getData() {
        byte abyte0[];
        if(mPartData == null) {
            abyte0 = null;
        } else {
            abyte0 = new byte[mPartData.length];
            System.arraycopy(mPartData, 0, abyte0, 0, mPartData.length);
        }
        return abyte0;
    }

    public Uri getDataUri() {
        return mUri;
    }

    public byte[] getFilename() {
        return (byte[])(byte[])mPartHeader.get(Integer.valueOf(152));
    }

    public byte[] getName() {
        return (byte[])(byte[])mPartHeader.get(Integer.valueOf(151));
    }

    public void setCharset(int i) {
        mPartHeader.put(Integer.valueOf(129), Integer.valueOf(i));
    }

    public void setContentDisposition(byte abyte0[]) {
        if(abyte0 == null) {
            throw new NullPointerException("null content-disposition");
        } else {
            mPartHeader.put(Integer.valueOf(197), abyte0);
            return;
        }
    }

    public void setContentId(byte abyte0[]) {
        if(abyte0 == null || abyte0.length == 0)
            throw new IllegalArgumentException("Content-Id may not be null or empty.");
        if(abyte0.length > 1 && (char)abyte0[0] == '<' && (char)abyte0[-1 + abyte0.length] == '>') {
            mPartHeader.put(Integer.valueOf(192), abyte0);
        } else {
            byte abyte1[] = new byte[2 + abyte0.length];
            abyte1[0] = 60;
            abyte1[-1 + abyte1.length] = 62;
            System.arraycopy(abyte0, 0, abyte1, 1, abyte0.length);
            mPartHeader.put(Integer.valueOf(192), abyte1);
        }
    }

    public void setContentLocation(byte abyte0[]) {
        if(abyte0 == null) {
            throw new NullPointerException("null content-location");
        } else {
            mPartHeader.put(Integer.valueOf(142), abyte0);
            return;
        }
    }

    public void setContentTransferEncoding(byte abyte0[]) {
        if(abyte0 == null) {
            throw new NullPointerException("null content-transfer-encoding");
        } else {
            mPartHeader.put(Integer.valueOf(200), abyte0);
            return;
        }
    }

    public void setContentType(byte abyte0[]) {
        if(abyte0 == null) {
            throw new NullPointerException("null content-type");
        } else {
            mPartHeader.put(Integer.valueOf(145), abyte0);
            return;
        }
    }

    public void setData(byte abyte0[]) {
        if(abyte0 != null) {
            mPartData = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, mPartData, 0, abyte0.length);
        }
    }

    public void setDataUri(Uri uri) {
        mUri = uri;
    }

    public void setFilename(byte abyte0[]) {
        if(abyte0 == null) {
            throw new NullPointerException("null content-id");
        } else {
            mPartHeader.put(Integer.valueOf(152), abyte0);
            return;
        }
    }

    public void setName(byte abyte0[]) {
        if(abyte0 == null) {
            throw new NullPointerException("null content-id");
        } else {
            mPartHeader.put(Integer.valueOf(151), abyte0);
            return;
        }
    }

    public static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding";
    static final byte DISPOSITION_ATTACHMENT[] = "attachment".getBytes();
    static final byte DISPOSITION_FROM_DATA[] = "from-data".getBytes();
    static final byte DISPOSITION_INLINE[] = "inline".getBytes();
    public static final String P_7BIT = "7bit";
    public static final String P_8BIT = "8bit";
    public static final String P_BASE64 = "base64";
    public static final String P_BINARY = "binary";
    public static final int P_CHARSET = 129;
    public static final int P_COMMENT = 155;
    public static final int P_CONTENT_DISPOSITION = 197;
    public static final int P_CONTENT_ID = 192;
    public static final int P_CONTENT_LOCATION = 142;
    public static final int P_CONTENT_TRANSFER_ENCODING = 200;
    public static final int P_CONTENT_TYPE = 145;
    public static final int P_CREATION_DATE = 147;
    public static final int P_CT_MR_TYPE = 137;
    public static final int P_DEP_COMMENT = 140;
    public static final int P_DEP_CONTENT_DISPOSITION = 174;
    public static final int P_DEP_DOMAIN = 141;
    public static final int P_DEP_FILENAME = 134;
    public static final int P_DEP_NAME = 133;
    public static final int P_DEP_PATH = 143;
    public static final int P_DEP_START = 138;
    public static final int P_DEP_START_INFO = 139;
    public static final int P_DIFFERENCES = 135;
    public static final int P_DISPOSITION_ATTACHMENT = 129;
    public static final int P_DISPOSITION_FROM_DATA = 128;
    public static final int P_DISPOSITION_INLINE = 130;
    public static final int P_DOMAIN = 156;
    public static final int P_FILENAME = 152;
    public static final int P_LEVEL = 130;
    public static final int P_MAC = 146;
    public static final int P_MAX_AGE = 142;
    public static final int P_MODIFICATION_DATE = 148;
    public static final int P_NAME = 151;
    public static final int P_PADDING = 136;
    public static final int P_PATH = 157;
    public static final int P_Q = 128;
    public static final String P_QUOTED_PRINTABLE = "quoted-printable";
    public static final int P_READ_DATE = 149;
    public static final int P_SEC = 145;
    public static final int P_SECURE = 144;
    public static final int P_SIZE = 150;
    public static final int P_START = 153;
    public static final int P_START_INFO = 154;
    public static final int P_TYPE = 131;
    private static final String TAG = "PduPart";
    private byte mPartData[];
    private Map mPartHeader;
    private Uri mUri;

}
