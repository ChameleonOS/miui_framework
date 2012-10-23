// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;

// Referenced classes of package com.android.internal.telephony:
//            IccUtils, MiuiAdnUtils

public class AdnRecord
    implements Parcelable {

    public AdnRecord(int i, int j, String s, String s1) {
        alphaTag = null;
        number = null;
        extRecord = 255;
        efid = i;
        recordNumber = j;
        alphaTag = s;
        number = s1;
        emails = null;
    }

    public AdnRecord(int i, int j, String s, String s1, String as[]) {
        alphaTag = null;
        number = null;
        extRecord = 255;
        efid = i;
        recordNumber = j;
        alphaTag = s;
        number = s1;
        emails = as;
    }

    public AdnRecord(int i, int j, byte abyte0[]) {
        alphaTag = null;
        number = null;
        extRecord = 255;
        efid = i;
        recordNumber = j;
        parseRecord(abyte0);
    }

    public AdnRecord(String s, String s1) {
        this(0, 0, s, s1);
    }

    public AdnRecord(String s, String s1, String as[]) {
        this(0, 0, s, s1, as);
    }

    public AdnRecord(byte abyte0[]) {
        this(0, 0, abyte0);
    }

    private void parseRecord(byte abyte0[]) {
        alphaTag = IccUtils.adnStringFieldToString(abyte0, 0, -14 + abyte0.length);
        int i = -14 + abyte0.length;
        int j = 0xff & abyte0[i];
        number = PhoneNumberUtils.calledPartyBCDToString(abyte0, i + 1, j);
        extRecord = 0xff & abyte0[-1 + abyte0.length];
        emails = null;
_L1:
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("GSM", (new StringBuilder()).append("Error parsing AdnRecord - [").append(number).append(",").append(alphaTag).append(",").append(emails).append("]").toString(), runtimeexception);
        number = "";
        alphaTag = "";
        emails = null;
          goto _L1
    }

    private static boolean stringCompareNullEqualsEmpty(String s, String s1) {
        boolean flag;
        if(s == s1) {
            flag = true;
        } else {
            if(s == null)
                s = "";
            if(s1 == null)
                s1 = "";
            flag = s.equals(s1);
        }
        return flag;
    }

    public void appendExtRecord(byte abyte0[]) {
        try {
            if(abyte0.length == 13 && (3 & abyte0[0]) == 2 && (0xff & abyte0[1]) <= 10)
                number = (new StringBuilder()).append(number).append(PhoneNumberUtils.calledPartyBCDFragmentToString(abyte0, 2, 0xff & abyte0[1])).toString();
        }
        catch(RuntimeException runtimeexception) {
            Log.w("GSM", "Error parsing AdnRecord ext record", runtimeexception);
        }
    }

    public byte[] buildAdnString(int i) {
        int j;
        byte abyte0[];
        j = i - 14;
        abyte0 = new byte[i];
        for(int k = 0; k < i; k++)
            abyte0[k] = -1;

        if(!TextUtils.isEmpty(number)) goto _L2; else goto _L1
_L1:
        Log.w("GSM", "[buildAdnString] Empty dialing number");
_L4:
        return abyte0;
_L2:
        if(number.length() > 20) {
            Log.w("GSM", "[buildAdnString] Max length of dialing number is 20");
            abyte0 = null;
        } else
        if(alphaTag != null && alphaTag.length() > j) {
            Log.w("GSM", (new StringBuilder()).append("[buildAdnString] Max length of tag is ").append(j).toString());
            abyte0 = null;
        } else {
            byte abyte1[] = PhoneNumberUtils.numberToCalledPartyBCD(number);
            System.arraycopy(abyte1, 0, abyte0, j + 1, abyte1.length);
            abyte0[j + 0] = (byte)abyte1.length;
            abyte0[j + 12] = -1;
            abyte0[j + 13] = -1;
            if(!TextUtils.isEmpty(alphaTag))
                MiuiAdnUtils.encodeAlphaTag(abyte0, alphaTag, j);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int describeContents() {
        return 0;
    }

    public String getAlphaTag() {
        return alphaTag;
    }

    public String[] getEmails() {
        return emails;
    }

    public String getNumber() {
        return number;
    }

    public boolean hasExtendedRecord() {
        boolean flag;
        if(extRecord != 0 && extRecord != 255)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isEmpty() {
        boolean flag;
        if(TextUtils.isEmpty(alphaTag) && TextUtils.isEmpty(number) && emails == null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isEqual(AdnRecord adnrecord) {
        boolean flag;
        if(stringCompareNullEqualsEmpty(alphaTag, adnrecord.alphaTag) && stringCompareNullEqualsEmpty(number, adnrecord.number) && Arrays.equals(emails, adnrecord.emails))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void setEmails(String as[]) {
        emails = as;
    }

    public String toString() {
        return (new StringBuilder()).append("ADN Record '").append(alphaTag).append("' '").append(number).append(" ").append(emails).append("'").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(efid);
        parcel.writeInt(recordNumber);
        parcel.writeString(alphaTag);
        parcel.writeString(number);
        parcel.writeStringArray(emails);
    }

    static final int ADN_BCD_NUMBER_LENGTH = 0;
    static final int ADN_CAPABILITY_ID = 12;
    static final int ADN_DIALING_NUMBER_END = 11;
    static final int ADN_DIALING_NUMBER_START = 2;
    static final int ADN_EXTENSION_ID = 13;
    static final int ADN_TON_AND_NPI = 1;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AdnRecord createFromParcel(Parcel parcel) {
            return new AdnRecord(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readStringArray());
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public AdnRecord[] newArray(int i) {
            return new AdnRecord[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    static final int EXT_RECORD_LENGTH_BYTES = 13;
    static final int EXT_RECORD_TYPE_ADDITIONAL_DATA = 2;
    static final int EXT_RECORD_TYPE_MASK = 3;
    static final int FOOTER_SIZE_BYTES = 14;
    static final String LOG_TAG = "GSM";
    static final int MAX_EXT_CALLED_PARTY_LENGTH = 10;
    static final int MAX_NUMBER_SIZE_BYTES = 11;
    String alphaTag;
    int efid;
    String emails[];
    int extRecord;
    String number;
    int recordNumber;

}
