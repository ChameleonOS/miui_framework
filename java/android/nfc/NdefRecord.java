// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.charset.Charsets;
import java.util.*;

// Referenced classes of package android.nfc:
//            FormatException, NdefMessage

public final class NdefRecord
    implements Parcelable {

    public NdefRecord(short word0, byte abyte0[], byte abyte1[], byte abyte2[]) {
        if(abyte0 == null)
            abyte0 = EMPTY_BYTE_ARRAY;
        if(abyte1 == null)
            abyte1 = EMPTY_BYTE_ARRAY;
        if(abyte2 == null)
            abyte2 = EMPTY_BYTE_ARRAY;
        String s = validateTnf(word0, abyte0, abyte1, abyte2);
        if(s != null) {
            throw new IllegalArgumentException(s);
        } else {
            mTnf = word0;
            mType = abyte0;
            mId = abyte1;
            mPayload = abyte2;
            return;
        }
    }

    public NdefRecord(byte abyte0[]) throws FormatException {
        ByteBuffer bytebuffer = ByteBuffer.wrap(abyte0);
        NdefRecord andefrecord[] = parse(bytebuffer, true);
        if(bytebuffer.remaining() > 0) {
            throw new FormatException("data too long");
        } else {
            mTnf = andefrecord[0].mTnf;
            mType = andefrecord[0].mType;
            mId = andefrecord[0].mId;
            mPayload = andefrecord[0].mPayload;
            return;
        }
    }

    private static StringBuilder bytesToString(byte abyte0[]) {
        StringBuilder stringbuilder = new StringBuilder();
        int i = abyte0.length;
        for(int j = 0; j < i; j++) {
            byte byte0 = abyte0[j];
            Object aobj[] = new Object[1];
            aobj[0] = Byte.valueOf(byte0);
            stringbuilder.append(String.format("%02X", aobj));
        }

        return stringbuilder;
    }

    public static NdefRecord createApplicationRecord(String s) {
        if(s == null)
            throw new NullPointerException("packageName is null");
        if(s.length() == 0)
            throw new IllegalArgumentException("packageName is empty");
        else
            return new NdefRecord((short)4, RTD_ANDROID_APP, null, s.getBytes(Charsets.UTF_8));
    }

    public static NdefRecord createExternal(String s, String s1, byte abyte0[]) {
        if(s == null)
            throw new NullPointerException("domain is null");
        if(s1 == null)
            throw new NullPointerException("type is null");
        String s2 = s.trim().toLowerCase(Locale.US);
        String s3 = s1.trim().toLowerCase(Locale.US);
        if(s2.length() == 0)
            throw new IllegalArgumentException("domain is empty");
        if(s3.length() == 0) {
            throw new IllegalArgumentException("type is empty");
        } else {
            byte abyte1[] = s2.getBytes(Charsets.UTF_8);
            byte abyte2[] = s3.getBytes(Charsets.UTF_8);
            byte abyte3[] = new byte[1 + abyte1.length + abyte2.length];
            System.arraycopy(abyte1, 0, abyte3, 0, abyte1.length);
            abyte3[abyte1.length] = 58;
            System.arraycopy(abyte2, 0, abyte3, 1 + abyte1.length, abyte2.length);
            return new NdefRecord((short)4, abyte3, null, abyte0);
        }
    }

    public static NdefRecord createMime(String s, byte abyte0[]) {
        if(s == null)
            throw new NullPointerException("mimeType is null");
        String s1 = Intent.normalizeMimeType(s);
        if(s1.length() == 0)
            throw new IllegalArgumentException("mimeType is empty");
        int i = s1.indexOf('/');
        if(i == 0)
            throw new IllegalArgumentException("mimeType must have major type");
        if(i == -1 + s1.length())
            throw new IllegalArgumentException("mimeType must have minor type");
        else
            return new NdefRecord((short)2, s1.getBytes(Charsets.US_ASCII), null, abyte0);
    }

    public static NdefRecord createUri(Uri uri) {
        if(uri == null)
            throw new NullPointerException("uri is null");
        String s = uri.normalizeScheme().toString();
        if(s.length() == 0)
            throw new IllegalArgumentException("uri is empty");
        byte byte0 = 0;
        int i = 1;
        do {
label0:
            {
                if(i < URI_PREFIX_MAP.length) {
                    if(!s.startsWith(URI_PREFIX_MAP[i]))
                        break label0;
                    byte0 = (byte)i;
                    s = s.substring(URI_PREFIX_MAP[i].length());
                }
                byte abyte0[] = s.getBytes(Charsets.UTF_8);
                byte abyte1[] = new byte[1 + abyte0.length];
                abyte1[0] = byte0;
                System.arraycopy(abyte0, 0, abyte1, 1, abyte0.length);
                return new NdefRecord((short)1, RTD_URI, null, abyte1);
            }
            i++;
        } while(true);
    }

    public static NdefRecord createUri(String s) {
        return createUri(Uri.parse(s));
    }

    private static void ensureSanePayloadSize(long l) throws FormatException {
        if(l > 0xa00000L)
            throw new FormatException((new StringBuilder()).append("payload above max limit: ").append(l).append(" > ").append(0xa00000).toString());
        else
            return;
    }

    static NdefRecord[] parse(ByteBuffer bytebuffer, boolean flag) throws FormatException {
        ArrayList arraylist;
        byte abyte0[];
        byte abyte1[];
        arraylist = new ArrayList();
        abyte0 = null;
        abyte1 = null;
        ArrayList arraylist1;
        boolean flag1;
        short word0;
        boolean flag2;
        arraylist1 = new ArrayList();
        flag1 = false;
        word0 = -1;
        flag2 = false;
_L17:
        if(flag2) goto _L2; else goto _L1
_L1:
        byte byte0 = bytebuffer.get();
        if((byte0 & 0xffffff80) == 0) goto _L4; else goto _L3
_L3:
        boolean flag3 = true;
          goto _L5
_L10:
        short word1;
        word1 = (short)(byte0 & 7);
        if(!flag3 && arraylist.size() == 0 && !flag1 && !flag)
            throw new FormatException("expected MB flag");
          goto _L6
        BufferUnderflowException bufferunderflowexception;
        bufferunderflowexception;
        FormatException formatexception = new FormatException("expected more data", bufferunderflowexception);
        throw formatexception;
_L4:
        flag3 = false;
          goto _L5
_L19:
        flag2 = false;
          goto _L7
_L21:
        boolean flag4 = false;
          goto _L8
_L23:
        boolean flag5 = false;
          goto _L9
_L25:
        boolean flag6 = false;
          goto _L10
_L6:
        if(!flag3)
            break MISSING_BLOCK_LABEL_177;
        if(arraylist.size() != 0 && !flag)
            throw new FormatException("unexpected MB flag");
        int i;
        long l;
        int j;
        if(flag1 && flag6)
            throw new FormatException("unexpected IL flag in non-leading chunk");
        if(flag4 && flag2)
            throw new FormatException("unexpected ME flag in non-trailing chunk");
        if(flag1 && word1 != 6)
            throw new FormatException("expected TNF_UNCHANGED in non-leading chunk");
        if(!flag1 && word1 == 6)
            throw new FormatException("unexpected TNF_UNCHANGED in first chunk or unchunked record");
        i = 0xff & bytebuffer.get();
        if(flag5)
            l = 0xff & bytebuffer.get();
        else
            l = 0xffffffffL & (long)bytebuffer.getInt();
        if(!flag6) goto _L12; else goto _L11
_L11:
        j = 0xff & bytebuffer.get();
_L26:
        byte abyte2[];
        if(flag1 && i != 0)
            throw new FormatException("expected zero-length type in non-leading chunk");
        if(!flag1) {
            Iterator iterator;
            if(i > 0)
                abyte0 = new byte[i];
            else
                abyte0 = EMPTY_BYTE_ARRAY;
            if(j > 0)
                abyte1 = new byte[j];
            else
                abyte1 = EMPTY_BYTE_ARRAY;
            bytebuffer.get(abyte0);
            bytebuffer.get(abyte1);
        }
        ensureSanePayloadSize(l);
        if(l > 0L)
            abyte2 = new byte[(int)l];
        else
            abyte2 = EMPTY_BYTE_ARRAY;
        bytebuffer.get(abyte2);
        if(flag4 && !flag1) {
            arraylist1.clear();
            word0 = word1;
        }
          goto _L13
_L27:
        arraylist1.add(abyte2);
_L28:
        if(flag4 || !flag1) goto _L15; else goto _L14
_L14:
        long l1 = 0L;
        for(iterator = arraylist1.iterator(); iterator.hasNext();)
            l1 += ((byte[])iterator.next()).length;

        ensureSanePayloadSize(l1);
        abyte2 = new byte[(int)l1];
        int k = 0;
        for(Iterator iterator1 = arraylist1.iterator(); iterator1.hasNext();) {
            byte abyte3[] = (byte[])iterator1.next();
            int i1 = abyte3.length;
            System.arraycopy(abyte3, 0, abyte2, k, i1);
            k += abyte3.length;
        }

          goto _L16
_L30:
        flag1 = false;
        String s = validateTnf(word1, abyte0, abyte1, abyte2);
        if(s != null) {
            FormatException formatexception1 = new FormatException(s);
            throw formatexception1;
        }
        NdefRecord ndefrecord = new NdefRecord(word1, abyte0, abyte1, abyte2);
        arraylist.add(ndefrecord);
        if(!flag) goto _L17; else goto _L2
_L2:
        return (NdefRecord[])arraylist.toArray(new NdefRecord[arraylist.size()]);
_L5:
        if((byte0 & 0x40) == 0) goto _L19; else goto _L18
_L18:
        flag2 = true;
_L7:
        if((byte0 & 0x20) == 0) goto _L21; else goto _L20
_L20:
        flag4 = true;
_L8:
        if((byte0 & 0x10) == 0) goto _L23; else goto _L22
_L22:
        flag5 = true;
_L9:
        if((byte0 & 8) == 0) goto _L25; else goto _L24
_L24:
        flag6 = true;
          goto _L10
_L12:
        j = 0;
          goto _L26
_L13:
        if(!flag4 && !flag1) goto _L28; else goto _L27
_L16:
        word1 = word0;
_L15:
        if(!flag4) goto _L30; else goto _L29
_L29:
        flag1 = true;
          goto _L17
    }

    private Uri parseWktUri() {
        Uri uri = null;
        if(mPayload.length >= 2) goto _L2; else goto _L1
_L1:
        return uri;
_L2:
        int i = -1 & mPayload[0];
        if(i >= 0 && i < URI_PREFIX_MAP.length) {
            String s = URI_PREFIX_MAP[i];
            String s1 = new String(Arrays.copyOfRange(mPayload, 1, mPayload.length), Charsets.UTF_8);
            uri = Uri.parse((new StringBuilder()).append(s).append(s1).toString());
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private Uri toUri(boolean flag) {
        mTnf;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 40
    //                   2 36
    //                   3 136
    //                   4 160;
           goto _L1 _L2 _L1 _L3 _L4
_L1:
        Uri uri = null;
_L7:
        return uri;
_L2:
        if(!Arrays.equals(mType, RTD_SMART_POSTER) || flag)
            break MISSING_BLOCK_LABEL_112;
        NdefRecord andefrecord[];
        int i;
        int j;
        andefrecord = (new NdefMessage(mPayload)).getRecords();
        i = andefrecord.length;
        j = 0;
_L5:
        Uri uri1;
        if(j >= i)
            continue; /* Loop/switch isn't completed */
        uri1 = andefrecord[j].toUri(true);
        uri = uri1;
        if(uri != null)
            continue; /* Loop/switch isn't completed */
        j++;
          goto _L5
        if(Arrays.equals(mType, RTD_URI)) {
            uri = parseWktUri().normalizeScheme();
            continue; /* Loop/switch isn't completed */
        }
        continue; /* Loop/switch isn't completed */
_L3:
        uri = Uri.parse(new String(mType, Charsets.UTF_8)).normalizeScheme();
        continue; /* Loop/switch isn't completed */
_L4:
        if(flag)
            continue; /* Loop/switch isn't completed */
        uri = Uri.parse((new StringBuilder()).append("vnd.android.nfc://ext/").append(new String(mType, Charsets.US_ASCII)).toString());
        if(true) goto _L7; else goto _L6
_L6:
        FormatException formatexception;
        formatexception;
        if(true) goto _L1; else goto _L8
_L8:
    }

    static String validateTnf(short word0, byte abyte0[], byte abyte1[], byte abyte2[]) {
        String s = null;
        word0;
        JVM INSTR tableswitch 0 7: default 52
    //                   0 79
    //                   1 76
    //                   2 76
    //                   3 76
    //                   4 76
    //                   5 102
    //                   6 115
    //                   7 102;
           goto _L1 _L2 _L3 _L3 _L3 _L3 _L4 _L5 _L4
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        Object aobj[] = new Object[1];
        aobj[0] = Short.valueOf(word0);
        s = String.format("unexpected tnf value: 0x%02x", aobj);
_L7:
        return s;
_L2:
        if(abyte0.length != 0 || abyte1.length != 0 || abyte2.length != 0)
            s = "unexpected data in TNF_EMPTY record";
        continue; /* Loop/switch isn't completed */
_L4:
        if(abyte0.length != 0)
            s = "unexpected type field in TNF_UNKNOWN or TNF_RESERVEd record";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "unexpected TNF_UNCHANGED in first chunk or logical record";
        if(true) goto _L7; else goto _L6
_L6:
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(this != obj) goto _L2; else goto _L1
_L1:
        flag = true;
_L4:
        return flag;
_L2:
        if(obj != null && getClass() == obj.getClass()) {
            NdefRecord ndefrecord = (NdefRecord)obj;
            if(Arrays.equals(mId, ndefrecord.mId) && Arrays.equals(mPayload, ndefrecord.mPayload) && mTnf == ndefrecord.mTnf)
                flag = Arrays.equals(mType, ndefrecord.mType);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    int getByteLength() {
        int i = 3 + mType.length + mId.length + mPayload.length;
        boolean flag;
        boolean flag1;
        if(mPayload.length < 256)
            flag = true;
        else
            flag = false;
        if(mId.length > 0)
            flag1 = true;
        else
            flag1 = false;
        if(!flag)
            i += 3;
        if(flag1)
            i++;
        return i;
    }

    public byte[] getId() {
        return (byte[])mId.clone();
    }

    public byte[] getPayload() {
        return (byte[])mPayload.clone();
    }

    public short getTnf() {
        return mTnf;
    }

    public byte[] getType() {
        return (byte[])mType.clone();
    }

    public int hashCode() {
        return 31 * (31 * (31 * (31 + Arrays.hashCode(mId)) + Arrays.hashCode(mPayload)) + mTnf) + Arrays.hashCode(mType);
    }

    public byte[] toByteArray() {
        ByteBuffer bytebuffer = ByteBuffer.allocate(getByteLength());
        writeToByteBuffer(bytebuffer, true, true);
        return bytebuffer.array();
    }

    public String toMimeType() {
        mTnf;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 32
    //                   2 52;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_52;
_L1:
        String s = null;
_L5:
        return s;
_L2:
        if(!Arrays.equals(mType, RTD_TEXT)) goto _L1; else goto _L4
_L4:
        s = "text/plain";
          goto _L5
        s = Intent.normalizeMimeType(new String(mType, Charsets.US_ASCII));
          goto _L5
    }

    public String toString() {
        Object aobj[] = new Object[1];
        aobj[0] = Short.valueOf(mTnf);
        StringBuilder stringbuilder = new StringBuilder(String.format("NdefRecord tnf=%X", aobj));
        if(mType.length > 0)
            stringbuilder.append(" type=").append(bytesToString(mType));
        if(mId.length > 0)
            stringbuilder.append(" id=").append(bytesToString(mId));
        if(mPayload.length > 0)
            stringbuilder.append(" payload=").append(bytesToString(mPayload));
        return stringbuilder.toString();
    }

    public Uri toUri() {
        return toUri(false);
    }

    void writeToByteBuffer(ByteBuffer bytebuffer, boolean flag, boolean flag1) {
        byte byte0 = 0;
        boolean flag2;
        boolean flag3;
        byte byte1;
        byte byte2;
        int i;
        byte byte3;
        int j;
        if(mPayload.length < 256)
            flag2 = true;
        else
            flag2 = false;
        if(mId.length > 0)
            flag3 = true;
        else
            flag3 = false;
        if(flag)
            byte1 = -128;
        else
            byte1 = 0;
        if(flag1)
            byte2 = 64;
        else
            byte2 = 0;
        i = byte1 | byte2;
        if(flag2)
            byte3 = 16;
        else
            byte3 = 0;
        j = byte3 | i;
        if(flag3)
            byte0 = 8;
        bytebuffer.put((byte)(j | byte0 | mTnf));
        bytebuffer.put((byte)mType.length);
        if(flag2)
            bytebuffer.put((byte)mPayload.length);
        else
            bytebuffer.putInt(mPayload.length);
        if(flag3)
            bytebuffer.put((byte)mId.length);
        bytebuffer.put(mType);
        bytebuffer.put(mId);
        bytebuffer.put(mPayload);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mTnf);
        parcel.writeInt(mType.length);
        parcel.writeByteArray(mType);
        parcel.writeInt(mId.length);
        parcel.writeByteArray(mId);
        parcel.writeInt(mPayload.length);
        parcel.writeByteArray(mPayload);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NdefRecord createFromParcel(Parcel parcel) {
            short word0 = (short)parcel.readInt();
            byte abyte7[] = new byte[parcel.readInt()];
            parcel.readByteArray(abyte7);
            byte abyte8[] = new byte[parcel.readInt()];
            parcel.readByteArray(abyte8);
            byte abyte9[] = new byte[parcel.readInt()];
            parcel.readByteArray(abyte9);
            return new NdefRecord(word0, abyte7, abyte8, abyte9);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public NdefRecord[] newArray(int i) {
            return new NdefRecord[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final byte EMPTY_BYTE_ARRAY[] = new byte[0];
    private static final byte FLAG_CF = 32;
    private static final byte FLAG_IL = 8;
    private static final byte FLAG_MB = -128;
    private static final byte FLAG_ME = 64;
    private static final byte FLAG_SR = 16;
    private static final int MAX_PAYLOAD_SIZE = 0xa00000;
    public static final byte RTD_ALTERNATIVE_CARRIER[];
    public static final byte RTD_ANDROID_APP[] = "android.com:pkg".getBytes();
    public static final byte RTD_HANDOVER_CARRIER[];
    public static final byte RTD_HANDOVER_REQUEST[];
    public static final byte RTD_HANDOVER_SELECT[];
    public static final byte RTD_SMART_POSTER[];
    public static final byte RTD_TEXT[];
    public static final byte RTD_URI[];
    public static final short TNF_ABSOLUTE_URI = 3;
    public static final short TNF_EMPTY = 0;
    public static final short TNF_EXTERNAL_TYPE = 4;
    public static final short TNF_MIME_MEDIA = 2;
    public static final short TNF_RESERVED = 7;
    public static final short TNF_UNCHANGED = 6;
    public static final short TNF_UNKNOWN = 5;
    public static final short TNF_WELL_KNOWN = 1;
    private static final String URI_PREFIX_MAP[];
    private final byte mId[];
    private final byte mPayload[];
    private final short mTnf;
    private final byte mType[];

    static  {
        byte abyte0[] = new byte[1];
        abyte0[0] = 84;
        RTD_TEXT = abyte0;
        byte abyte1[] = new byte[1];
        abyte1[0] = 85;
        RTD_URI = abyte1;
        byte abyte2[] = new byte[2];
        abyte2[0] = 83;
        abyte2[1] = 112;
        RTD_SMART_POSTER = abyte2;
        byte abyte3[] = new byte[2];
        abyte3[0] = 97;
        abyte3[1] = 99;
        RTD_ALTERNATIVE_CARRIER = abyte3;
        byte abyte4[] = new byte[2];
        abyte4[0] = 72;
        abyte4[1] = 99;
        RTD_HANDOVER_CARRIER = abyte4;
        byte abyte5[] = new byte[2];
        abyte5[0] = 72;
        abyte5[1] = 114;
        RTD_HANDOVER_REQUEST = abyte5;
        byte abyte6[] = new byte[2];
        abyte6[0] = 72;
        abyte6[1] = 115;
        RTD_HANDOVER_SELECT = abyte6;
        String as[] = new String[35];
        as[0] = "";
        as[1] = "http://www.";
        as[2] = "https://www.";
        as[3] = "http://";
        as[4] = "https://";
        as[5] = "tel:";
        as[6] = "mailto:";
        as[7] = "ftp://anonymous:anonymous@";
        as[8] = "ftp://ftp.";
        as[9] = "ftps://";
        as[10] = "sftp://";
        as[11] = "smb://";
        as[12] = "nfs://";
        as[13] = "ftp://";
        as[14] = "dav://";
        as[15] = "news:";
        as[16] = "telnet://";
        as[17] = "imap:";
        as[18] = "rtsp://";
        as[19] = "urn:";
        as[20] = "pop:";
        as[21] = "sip:";
        as[22] = "sips:";
        as[23] = "tftp:";
        as[24] = "btspp://";
        as[25] = "btl2cap://";
        as[26] = "btgoep://";
        as[27] = "tcpobex://";
        as[28] = "irdaobex://";
        as[29] = "file://";
        as[30] = "urn:epc:id:";
        as[31] = "urn:epc:tag:";
        as[32] = "urn:epc:pat:";
        as[33] = "urn:epc:raw:";
        as[34] = "urn:epc:";
        URI_PREFIX_MAP = as;
    }
}
