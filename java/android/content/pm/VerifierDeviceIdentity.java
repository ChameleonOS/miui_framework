// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

public class VerifierDeviceIdentity
    implements Parcelable {

    public VerifierDeviceIdentity(long l) {
        mIdentity = l;
        mIdentityString = encodeBase32(l);
    }

    private VerifierDeviceIdentity(Parcel parcel) {
        long l = parcel.readLong();
        mIdentity = l;
        mIdentityString = encodeBase32(l);
    }


    private static final long decodeBase32(byte abyte0[]) throws IllegalArgumentException {
        long l;
        int i;
        int j;
        int k;
        l = 0L;
        i = 0;
        j = abyte0.length;
        k = 0;
_L5:
        byte byte0;
        int i1;
        if(k >= j)
            break MISSING_BLOCK_LABEL_214;
        byte0 = abyte0[k];
        if(65 <= byte0 && byte0 <= 90) {
            i1 = byte0 - 65;
        } else {
label0:
            {
                if(50 > byte0 || byte0 > 55)
                    break label0;
                i1 = byte0 - 24;
            }
        }
_L6:
        l = l << 5 | (long)i1;
        if(++i != 1) goto _L2; else goto _L1
_L1:
        if((i1 & 0xf) != i1)
            throw new IllegalArgumentException("illegal start character; will overflow");
          goto _L3
        if(byte0 != 45) goto _L4; else goto _L3
_L3:
        k++;
          goto _L5
_L4:
        if(97 <= byte0 && byte0 <= 122)
            i1 = byte0 - 97;
        else
        if(byte0 == 48)
            i1 = 14;
        else
        if(byte0 == 49)
            i1 = 8;
        else
            throw new IllegalArgumentException((new StringBuilder()).append("base base-32 character: ").append(byte0).toString());
          goto _L6
_L2:
        if(i <= 13) goto _L3; else goto _L7
_L7:
        throw new IllegalArgumentException("too long; should have 13 characters");
        if(i != 13)
            throw new IllegalArgumentException("too short; should have 13 characters");
        return l;
          goto _L6
    }

    private static final String encodeBase32(long l) {
        char ac[] = ENCODE;
        char ac1[] = new char[16];
        int i = ac1.length;
        for(int j = 0; j < 13; j++) {
            if(j > 0 && j % 4 == 1) {
                i--;
                ac1[i] = '-';
            }
            int k = (int)(31L & l);
            l >>>= 5;
            i--;
            ac1[i] = ac[k];
        }

        return String.valueOf(ac1);
    }

    public static VerifierDeviceIdentity generate() {
        return generate(((Random) (new SecureRandom())));
    }

    static VerifierDeviceIdentity generate(Random random) {
        return new VerifierDeviceIdentity(random.nextLong());
    }

    public static VerifierDeviceIdentity parse(String s) throws IllegalArgumentException {
        byte abyte0[];
        try {
            abyte0 = s.getBytes("US-ASCII");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new IllegalArgumentException("bad base-32 characters in input");
        }
        return new VerifierDeviceIdentity(decodeBase32(abyte0));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof VerifierDeviceIdentity) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        VerifierDeviceIdentity verifierdeviceidentity = (VerifierDeviceIdentity)obj;
        if(mIdentity == verifierdeviceidentity.mIdentity)
            flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int hashCode() {
        return (int)mIdentity;
    }

    public String toString() {
        return mIdentityString;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mIdentity);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VerifierDeviceIdentity createFromParcel(Parcel parcel) {
            return new VerifierDeviceIdentity(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public VerifierDeviceIdentity[] newArray(int i) {
            return new VerifierDeviceIdentity[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final char ENCODE[];
    private static final int GROUP_SIZE = 4;
    private static final int LONG_SIZE = 13;
    private static final char SEPARATOR = 45;
    private final long mIdentity;
    private final String mIdentityString;

    static  {
        char ac[] = new char[32];
        ac[0] = 'A';
        ac[1] = 'B';
        ac[2] = 'C';
        ac[3] = 'D';
        ac[4] = 'E';
        ac[5] = 'F';
        ac[6] = 'G';
        ac[7] = 'H';
        ac[8] = 'I';
        ac[9] = 'J';
        ac[10] = 'K';
        ac[11] = 'L';
        ac[12] = 'M';
        ac[13] = 'N';
        ac[14] = 'O';
        ac[15] = 'P';
        ac[16] = 'Q';
        ac[17] = 'R';
        ac[18] = 'S';
        ac[19] = 'T';
        ac[20] = 'U';
        ac[21] = 'V';
        ac[22] = 'W';
        ac[23] = 'X';
        ac[24] = 'Y';
        ac[25] = 'Z';
        ac[26] = '2';
        ac[27] = '3';
        ac[28] = '4';
        ac[29] = '5';
        ac[30] = '6';
        ac[31] = '7';
        ENCODE = ac;
    }
}
