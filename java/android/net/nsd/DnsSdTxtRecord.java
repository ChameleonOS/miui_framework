// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.nsd;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class DnsSdTxtRecord
    implements Parcelable {

    public DnsSdTxtRecord() {
        mData = new byte[0];
    }

    public DnsSdTxtRecord(DnsSdTxtRecord dnssdtxtrecord) {
        if(dnssdtxtrecord != null && dnssdtxtrecord.mData != null)
            mData = (byte[])(byte[])dnssdtxtrecord.mData.clone();
    }

    public DnsSdTxtRecord(byte abyte0[]) {
        mData = (byte[])(byte[])abyte0.clone();
    }

    private String getKey(int i) {
        int j;
        byte byte0;
        int l;
        j = 0;
        for(int k = 0; k < i && j < mData.length; k++)
            j += 1 + mData[j];

        if(j >= mData.length)
            break MISSING_BLOCK_LABEL_105;
        byte0 = mData[j];
        l = 0;
_L3:
        if(l < byte0 && mData[1 + (j + l)] != 61) goto _L2; else goto _L1
_L1:
        String s = new String(mData, j + 1, l);
_L4:
        return s;
_L2:
        l++;
          goto _L3
        s = null;
          goto _L4
    }

    private byte[] getValue(int i) {
        int j;
        byte abyte0[];
        j = 0;
        abyte0 = null;
        for(int k = 0; k < i && j < mData.length; k++)
            j += 1 + mData[j];

        if(j >= mData.length) goto _L2; else goto _L1
_L1:
        byte byte0;
        int l;
        byte0 = mData[j];
        l = 0;
_L7:
        if(l >= byte0) goto _L2; else goto _L3
_L3:
        if(mData[1 + (j + l)] != 61) goto _L5; else goto _L4
_L4:
        abyte0 = new byte[-1 + (byte0 - l)];
        System.arraycopy(mData, 2 + (j + l), abyte0, 0, -1 + (byte0 - l));
_L2:
        return abyte0;
_L5:
        l++;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private byte[] getValue(String s) {
        int i = 0;
_L3:
        String s1;
        s1 = getKey(i);
        if(s1 == null)
            break MISSING_BLOCK_LABEL_36;
        if(s.compareToIgnoreCase(s1) != 0) goto _L2; else goto _L1
_L1:
        byte abyte0[] = getValue(i);
_L4:
        return abyte0;
_L2:
        i++;
          goto _L3
        abyte0 = null;
          goto _L4
    }

    private String getValueAsString(int i) {
        byte abyte0[] = getValue(i);
        String s;
        if(abyte0 != null)
            s = new String(abyte0);
        else
            s = null;
        return s;
    }

    private void insert(byte abyte0[], byte abyte1[], int i) {
        byte abyte2[] = mData;
        int j;
        int k;
        if(abyte1 != null)
            j = abyte1.length;
        else
            j = 0;
        k = 0;
        for(int l = 0; l < i && k < mData.length; l++)
            k += 0xff & 1 + mData[k];

        int i1 = j + abyte0.length;
        int j1;
        int k1;
        int l1;
        int i2;
        if(abyte1 != null)
            j1 = 1;
        else
            j1 = 0;
        k1 = i1 + j1;
        l1 = 1 + (k1 + abyte2.length);
        mData = new byte[l1];
        System.arraycopy(abyte2, 0, mData, 0, k);
        i2 = abyte2.length - k;
        System.arraycopy(abyte2, k, mData, l1 - i2, i2);
        mData[k] = (byte)k1;
        System.arraycopy(abyte0, 0, mData, k + 1, abyte0.length);
        if(abyte1 != null) {
            mData[k + 1 + abyte0.length] = 61;
            System.arraycopy(abyte1, 0, mData, 2 + (k + abyte0.length), j);
        }
    }

    public boolean contains(String s) {
        int i = 0;
_L3:
        String s1;
        s1 = getKey(i);
        if(s1 == null)
            break MISSING_BLOCK_LABEL_32;
        if(s.compareToIgnoreCase(s1) != 0) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(obj == this)
            flag = true;
        else
        if(!(obj instanceof DnsSdTxtRecord))
            flag = false;
        else
            flag = Arrays.equals(((DnsSdTxtRecord)obj).mData, mData);
        return flag;
    }

    public String get(String s) {
        byte abyte0[] = getValue(s);
        String s1;
        if(abyte0 != null)
            s1 = new String(abyte0);
        else
            s1 = null;
        return s1;
    }

    public byte[] getRawData() {
        return (byte[])(byte[])mData.clone();
    }

    public int hashCode() {
        return Arrays.hashCode(mData);
    }

    public int keyCount() {
        int i = 0;
        for(int j = 0; j < mData.length;) {
            j += 0xff & 1 + mData[j];
            i++;
        }

        return i;
    }

    public int remove(String s) {
        int i;
        int j;
        i = 0;
        j = 0;
_L3:
        byte byte0;
        if(i >= mData.length)
            break MISSING_BLOCK_LABEL_161;
        byte0 = mData[i];
        if(s.length() > byte0 || s.length() != byte0 && mData[1 + (i + s.length())] != 61 || s.compareToIgnoreCase(new String(mData, i + 1, s.length())) != 0) goto _L2; else goto _L1
_L1:
        byte abyte0[] = mData;
        mData = new byte[-1 + (abyte0.length - byte0)];
        System.arraycopy(abyte0, 0, mData, 0, i);
        System.arraycopy(abyte0, 1 + (i + byte0), mData, i, -1 + (abyte0.length - i - byte0));
_L4:
        return j;
_L2:
        i += 0xff & byte0 + 1;
        j++;
          goto _L3
        j = -1;
          goto _L4
    }

    public void set(String s, String s1) {
        byte abyte0[];
        int i;
        byte abyte1[];
        int j;
        if(s1 != null) {
            abyte0 = s1.getBytes();
            i = abyte0.length;
        } else {
            abyte0 = null;
            i = 0;
        }
        try {
            abyte1 = s.getBytes("US-ASCII");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new IllegalArgumentException("key should be US-ASCII");
        }
        for(j = 0; j < abyte1.length; j++)
            if(abyte1[j] == 61)
                throw new IllegalArgumentException("= is not a valid character in key");

        if(i + abyte1.length >= 255)
            throw new IllegalArgumentException("Key and Value length cannot exceed 255 bytes");
        int k = remove(s);
        if(k == -1)
            k = keyCount();
        insert(abyte1, abyte0, k);
    }

    public int size() {
        return mData.length;
    }

    public String toString() {
        String s = null;
        int i = 0;
        do {
            String s1 = getKey(i);
            if(s1 == null)
                break;
            String s2 = (new StringBuilder()).append("{").append(s1).toString();
            String s3 = getValueAsString(i);
            String s4;
            if(s3 != null)
                s4 = (new StringBuilder()).append(s2).append("=").append(s3).append("}").toString();
            else
                s4 = (new StringBuilder()).append(s2).append("}").toString();
            if(s == null)
                s = s4;
            else
                s = (new StringBuilder()).append(s).append(", ").append(s4).toString();
            i++;
        } while(true);
        if(s == null)
            s = "";
        return s;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(mData);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public DnsSdTxtRecord createFromParcel(Parcel parcel) {
            DnsSdTxtRecord dnssdtxtrecord = new DnsSdTxtRecord();
            parcel.readByteArray(dnssdtxtrecord.mData);
            return dnssdtxtrecord;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public DnsSdTxtRecord[] newArray(int i) {
            return new DnsSdTxtRecord[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final byte mSeperator = 61;
    private byte mData[];


}
