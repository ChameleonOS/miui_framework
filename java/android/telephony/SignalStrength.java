// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.os.*;
import android.util.Log;

public class SignalStrength
    implements Parcelable {

    public SignalStrength() {
        mGsmSignalStrength = 99;
        mGsmBitErrorRate = -1;
        mCdmaDbm = -1;
        mCdmaEcio = -1;
        mEvdoDbm = -1;
        mEvdoEcio = -1;
        mEvdoSnr = -1;
        mLteSignalStrength = -1;
        mLteRsrp = -1;
        mLteRsrq = -1;
        mLteRssnr = 0x7fffffff;
        mLteCqi = -1;
        isGsm = true;
    }

    public SignalStrength(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2, int k2, int l2, boolean flag) {
        mGsmSignalStrength = i;
        mGsmBitErrorRate = j;
        mCdmaDbm = k;
        mCdmaEcio = l;
        mEvdoDbm = i1;
        mEvdoEcio = j1;
        mEvdoSnr = k1;
        mLteSignalStrength = l1;
        mLteRsrp = i2;
        mLteRsrq = j2;
        mLteRssnr = k2;
        mLteCqi = l2;
        isGsm = flag;
    }

    public SignalStrength(int i, int j, int k, int l, int i1, int j1, int k1, 
            boolean flag) {
        this(i, j, k, l, i1, j1, k1, -1, -1, -1, 0x7fffffff, -1, flag);
    }

    public SignalStrength(Parcel parcel) {
        mGsmSignalStrength = parcel.readInt();
        mGsmBitErrorRate = parcel.readInt();
        mCdmaDbm = parcel.readInt();
        mCdmaEcio = parcel.readInt();
        mEvdoDbm = parcel.readInt();
        mEvdoEcio = parcel.readInt();
        mEvdoSnr = parcel.readInt();
        mLteSignalStrength = parcel.readInt();
        mLteRsrp = parcel.readInt();
        mLteRsrq = parcel.readInt();
        mLteRssnr = parcel.readInt();
        mLteCqi = parcel.readInt();
        boolean flag;
        if(parcel.readInt() != 0)
            flag = true;
        else
            flag = false;
        isGsm = flag;
    }

    public SignalStrength(SignalStrength signalstrength) {
        copyFrom(signalstrength);
    }

    private static void log(String s) {
        Log.w("SignalStrength", s);
    }

    public static SignalStrength newFromBundle(Bundle bundle) {
        SignalStrength signalstrength = new SignalStrength();
        signalstrength.setFromNotifierBundle(bundle);
        return signalstrength;
    }

    private void setFromNotifierBundle(Bundle bundle) {
        mGsmSignalStrength = bundle.getInt("GsmSignalStrength");
        mGsmBitErrorRate = bundle.getInt("GsmBitErrorRate");
        mCdmaDbm = bundle.getInt("CdmaDbm");
        mCdmaEcio = bundle.getInt("CdmaEcio");
        mEvdoDbm = bundle.getInt("EvdoDbm");
        mEvdoEcio = bundle.getInt("EvdoEcio");
        mEvdoSnr = bundle.getInt("EvdoSnr");
        mLteSignalStrength = bundle.getInt("LteSignalStrength");
        mLteRsrp = bundle.getInt("LteRsrp");
        mLteRsrq = bundle.getInt("LteRsrq");
        mLteRssnr = bundle.getInt("LteRssnr");
        mLteCqi = bundle.getInt("LteCqi");
        isGsm = bundle.getBoolean("isGsm");
    }

    protected void copyFrom(SignalStrength signalstrength) {
        mGsmSignalStrength = signalstrength.mGsmSignalStrength;
        mGsmBitErrorRate = signalstrength.mGsmBitErrorRate;
        mCdmaDbm = signalstrength.mCdmaDbm;
        mCdmaEcio = signalstrength.mCdmaEcio;
        mEvdoDbm = signalstrength.mEvdoDbm;
        mEvdoEcio = signalstrength.mEvdoEcio;
        mEvdoSnr = signalstrength.mEvdoSnr;
        mLteSignalStrength = signalstrength.mLteSignalStrength;
        mLteRsrp = signalstrength.mLteRsrp;
        mLteRsrq = signalstrength.mLteRsrq;
        mLteRssnr = signalstrength.mLteRssnr;
        mLteCqi = signalstrength.mLteCqi;
        isGsm = signalstrength.isGsm;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        SignalStrength signalstrength = (SignalStrength)obj;
          goto _L1
_L2:
        return flag;
        ClassCastException classcastexception;
        classcastexception;
          goto _L2
_L1:
        if(obj != null && mGsmSignalStrength == signalstrength.mGsmSignalStrength && mGsmBitErrorRate == signalstrength.mGsmBitErrorRate && mCdmaDbm == signalstrength.mCdmaDbm && mCdmaEcio == signalstrength.mCdmaEcio && mEvdoDbm == signalstrength.mEvdoDbm && mEvdoEcio == signalstrength.mEvdoEcio && mEvdoSnr == signalstrength.mEvdoSnr && mLteSignalStrength == signalstrength.mLteSignalStrength && mLteRsrp == signalstrength.mLteRsrp && mLteRsrq == signalstrength.mLteRsrq && mLteRssnr == signalstrength.mLteRssnr && mLteCqi == signalstrength.mLteCqi && isGsm == signalstrength.isGsm)
            flag = true;
          goto _L2
    }

    public void fillInNotifierBundle(Bundle bundle) {
        bundle.putInt("GsmSignalStrength", mGsmSignalStrength);
        bundle.putInt("GsmBitErrorRate", mGsmBitErrorRate);
        bundle.putInt("CdmaDbm", mCdmaDbm);
        bundle.putInt("CdmaEcio", mCdmaEcio);
        bundle.putInt("EvdoDbm", mEvdoDbm);
        bundle.putInt("EvdoEcio", mEvdoEcio);
        bundle.putInt("EvdoSnr", mEvdoSnr);
        bundle.putInt("LteSignalStrength", mLteSignalStrength);
        bundle.putInt("LteRsrp", mLteRsrp);
        bundle.putInt("LteRsrq", mLteRsrq);
        bundle.putInt("LteRssnr", mLteRssnr);
        bundle.putInt("LteCqi", mLteCqi);
        bundle.putBoolean("isGsm", Boolean.valueOf(isGsm).booleanValue());
    }

    public int getAsuLevel() {
        int k;
        if(isGsm) {
            if(mLteSignalStrength == -1 && mLteRsrp == -1 && mLteRsrq == -1 && mLteCqi == -1)
                k = getGsmAsuLevel();
            else
                k = getLteAsuLevel();
        } else {
            int i = getCdmaAsuLevel();
            int j = getEvdoAsuLevel();
            if(j == 0)
                k = i;
            else
            if(i == 0)
                k = j;
            else
            if(i < j)
                k = i;
            else
                k = j;
        }
        return k;
    }

    public int getCdmaAsuLevel() {
        int i = getCdmaDbm();
        int j = getCdmaEcio();
        byte byte0;
        byte byte1;
        byte byte2;
        if(i >= -75)
            byte0 = 16;
        else
        if(i >= -82)
            byte0 = 8;
        else
        if(i >= -90)
            byte0 = 4;
        else
        if(i >= -95)
            byte0 = 2;
        else
        if(i >= -100)
            byte0 = 1;
        else
            byte0 = 99;
        if(j >= -90)
            byte1 = 16;
        else
        if(j >= -100)
            byte1 = 8;
        else
        if(j >= -115)
            byte1 = 4;
        else
        if(j >= -130)
            byte1 = 2;
        else
        if(j >= -150)
            byte1 = 1;
        else
            byte1 = 99;
        if(byte0 < byte1)
            byte2 = byte0;
        else
            byte2 = byte1;
        return byte2;
    }

    public int getCdmaDbm() {
        return mCdmaDbm;
    }

    public int getCdmaEcio() {
        return mCdmaEcio;
    }

    public int getCdmaLevel() {
        int i = getCdmaDbm();
        int j = getCdmaEcio();
        byte byte0;
        byte byte1;
        byte byte2;
        if(i >= -75)
            byte0 = 4;
        else
        if(i >= -85)
            byte0 = 3;
        else
        if(i >= -95)
            byte0 = 2;
        else
        if(i >= -100)
            byte0 = 1;
        else
            byte0 = 0;
        if(j >= -90)
            byte1 = 4;
        else
        if(j >= -110)
            byte1 = 3;
        else
        if(j >= -130)
            byte1 = 2;
        else
        if(j >= -150)
            byte1 = 1;
        else
            byte1 = 0;
        if(byte0 < byte1)
            byte2 = byte0;
        else
            byte2 = byte1;
        return byte2;
    }

    public int getDbm() {
        int i;
        if(isGsm()) {
            if(mLteSignalStrength == -1 && mLteRsrp == -1 && mLteRsrq == -1 && mLteCqi == -1)
                i = getGsmDbm();
            else
                i = getLteDbm();
        } else {
            i = getCdmaDbm();
        }
        return i;
    }

    public int getEvdoAsuLevel() {
        int i = getEvdoDbm();
        int j = getEvdoSnr();
        byte byte0;
        byte byte1;
        byte byte2;
        if(i >= -65)
            byte0 = 16;
        else
        if(i >= -75)
            byte0 = 8;
        else
        if(i >= -85)
            byte0 = 4;
        else
        if(i >= -95)
            byte0 = 2;
        else
        if(i >= -105)
            byte0 = 1;
        else
            byte0 = 99;
        if(j >= 7)
            byte1 = 16;
        else
        if(j >= 6)
            byte1 = 8;
        else
        if(j >= 5)
            byte1 = 4;
        else
        if(j >= 3)
            byte1 = 2;
        else
        if(j >= 1)
            byte1 = 1;
        else
            byte1 = 99;
        if(byte0 < byte1)
            byte2 = byte0;
        else
            byte2 = byte1;
        return byte2;
    }

    public int getEvdoDbm() {
        return mEvdoDbm;
    }

    public int getEvdoEcio() {
        return mEvdoEcio;
    }

    public int getEvdoLevel() {
        int i = getEvdoDbm();
        int j = getEvdoSnr();
        byte byte0;
        byte byte1;
        byte byte2;
        if(i >= -65)
            byte0 = 4;
        else
        if(i >= -75)
            byte0 = 3;
        else
        if(i >= -90)
            byte0 = 2;
        else
        if(i >= -105)
            byte0 = 1;
        else
            byte0 = 0;
        if(j >= 7)
            byte1 = 4;
        else
        if(j >= 5)
            byte1 = 3;
        else
        if(j >= 3)
            byte1 = 2;
        else
        if(j >= 1)
            byte1 = 1;
        else
            byte1 = 0;
        if(byte0 < byte1)
            byte2 = byte0;
        else
            byte2 = byte1;
        return byte2;
    }

    public int getEvdoSnr() {
        return mEvdoSnr;
    }

    public int getGsmAsuLevel() {
        return getGsmSignalStrength();
    }

    public int getGsmBitErrorRate() {
        return mGsmBitErrorRate;
    }

    public int getGsmDbm() {
        int i = getGsmSignalStrength();
        int j;
        int k;
        if(i == 99)
            j = -1;
        else
            j = i;
        if(j != -1)
            k = -113 + j * 2;
        else
            k = -1;
        return k;
    }

    public int getGsmLevel() {
        int i = getGsmSignalStrength();
        int j;
        if(i <= 2 || i == 99)
            j = 0;
        else
        if(i >= 12)
            j = 4;
        else
        if(i >= 8)
            j = 3;
        else
        if(i >= 5)
            j = 2;
        else
            j = 1;
        return j;
    }

    public int getGsmSignalStrength() {
        return mGsmSignalStrength;
    }

    public int getLevel() {
        int k;
        if(isGsm) {
            if(mLteSignalStrength == -1 && mLteRsrp == -1 && mLteRsrq == -1 && mLteCqi == -1)
                k = getGsmLevel();
            else
                k = getLteLevel();
        } else {
            int i = getCdmaLevel();
            int j = getEvdoLevel();
            if(j == 0)
                k = getCdmaLevel();
            else
            if(i == 0)
                k = getEvdoLevel();
            else
            if(i < j)
                k = i;
            else
                k = j;
        }
        return k;
    }

    public int getLteAsuLevel() {
        int i = getLteDbm();
        int j;
        if(i <= -140)
            j = 0;
        else
        if(i >= -43)
            j = 97;
        else
            j = i + 140;
        return j;
    }

    public int getLteDbm() {
        return mLteRsrp;
    }

    public int getLteLevel() {
        byte byte0;
        byte byte1;
        int i;
        if(mLteRsrp == -1)
            byte0 = 0;
        else
        if(mLteRsrp >= -95)
            byte0 = 4;
        else
        if(mLteRsrp >= -105)
            byte0 = 3;
        else
        if(mLteRsrp >= -115)
            byte0 = 2;
        else
            byte0 = 1;
        if(mLteRssnr == 0x7fffffff)
            byte1 = 0;
        else
        if(mLteRssnr >= 45)
            byte1 = 4;
        else
        if(mLteRssnr >= 10)
            byte1 = 3;
        else
        if(mLteRssnr >= -30)
            byte1 = 2;
        else
            byte1 = 1;
        if(mLteRsrp == -1)
            i = byte1;
        else
        if(mLteRssnr == 0x7fffffff)
            i = byte0;
        else
        if(byte1 < byte0)
            i = byte1;
        else
            i = byte0;
        return i;
    }

    public int hashCode() {
        int i = 31 * mGsmSignalStrength + 31 * mGsmBitErrorRate + 31 * mCdmaDbm + 31 * mCdmaEcio + 31 * mEvdoDbm + 31 * mEvdoEcio + 31 * mEvdoSnr + 31 * mLteSignalStrength + 31 * mLteRsrp + 31 * mLteRsrq + 31 * mLteRssnr + 31 * mLteCqi;
        int j;
        if(isGsm)
            j = 1;
        else
            j = 0;
        return j + i;
    }

    public boolean isGsm() {
        return isGsm;
    }

    public String toString() {
        StringBuilder stringbuilder = (new StringBuilder()).append("SignalStrength: ").append(mGsmSignalStrength).append(" ").append(mGsmBitErrorRate).append(" ").append(mCdmaDbm).append(" ").append(mCdmaEcio).append(" ").append(mEvdoDbm).append(" ").append(mEvdoEcio).append(" ").append(mEvdoSnr).append(" ").append(mLteSignalStrength).append(" ").append(mLteRsrp).append(" ").append(mLteRsrq).append(" ").append(mLteRssnr).append(" ").append(mLteCqi).append(" ");
        String s;
        if(isGsm)
            s = "gsm|lte";
        else
            s = "cdma";
        return stringbuilder.append(s).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mGsmSignalStrength);
        parcel.writeInt(mGsmBitErrorRate);
        parcel.writeInt(mCdmaDbm);
        parcel.writeInt(mCdmaEcio);
        parcel.writeInt(mEvdoDbm);
        parcel.writeInt(mEvdoEcio);
        parcel.writeInt(mEvdoSnr);
        parcel.writeInt(mLteSignalStrength);
        parcel.writeInt(mLteRsrp);
        parcel.writeInt(mLteRsrq);
        parcel.writeInt(mLteRssnr);
        parcel.writeInt(mLteCqi);
        int j;
        if(isGsm)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SignalStrength createFromParcel(Parcel parcel) {
            return new SignalStrength(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SignalStrength[] newArray(int i) {
            return new SignalStrength[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final boolean DBG = false;
    public static final int INVALID_SNR = 0x7fffffff;
    private static final String LOG_TAG = "SignalStrength";
    public static final int NUM_SIGNAL_STRENGTH_BINS = 5;
    public static final int SIGNAL_STRENGTH_GOOD = 3;
    public static final int SIGNAL_STRENGTH_GREAT = 4;
    public static final int SIGNAL_STRENGTH_MODERATE = 2;
    public static final String SIGNAL_STRENGTH_NAMES[];
    public static final int SIGNAL_STRENGTH_NONE_OR_UNKNOWN = 0;
    public static final int SIGNAL_STRENGTH_POOR = 1;
    private boolean isGsm;
    private int mCdmaDbm;
    private int mCdmaEcio;
    private int mEvdoDbm;
    private int mEvdoEcio;
    private int mEvdoSnr;
    private int mGsmBitErrorRate;
    private int mGsmSignalStrength;
    private int mLteCqi;
    private int mLteRsrp;
    private int mLteRsrq;
    private int mLteRssnr;
    private int mLteSignalStrength;

    static  {
        String as[] = new String[5];
        as[0] = "none";
        as[1] = "poor";
        as[2] = "moderate";
        as[3] = "good";
        as[4] = "great";
        SIGNAL_STRENGTH_NAMES = as;
    }
}
