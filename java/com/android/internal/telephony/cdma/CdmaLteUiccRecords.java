// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cdma;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncResult;
import android.os.SystemProperties;
import android.util.Log;
import com.android.internal.telephony.*;
import com.android.internal.telephony.gsm.SIMRecords;
import com.android.internal.telephony.ims.IsimRecords;
import com.android.internal.telephony.ims.IsimUiccRecords;
import java.io.UnsupportedEncodingException;
import java.util.*;

public final class CdmaLteUiccRecords extends SIMRecords {
    private class EfCsimEprlLoaded
        implements com.android.internal.telephony.IccRecords.IccRecordLoaded {

        public String getEfName() {
            return "EF_CSIM_EPRL";
        }

        public void onRecordLoaded(AsyncResult asyncresult) {
            onGetCSimEprlDone(asyncresult);
        }

        final CdmaLteUiccRecords this$0;

        private EfCsimEprlLoaded() {
            this$0 = CdmaLteUiccRecords.this;
            super();
        }

    }

    private class EfCsimCdmaHomeLoaded
        implements com.android.internal.telephony.IccRecords.IccRecordLoaded {

        public String getEfName() {
            return "EF_CSIM_CDMAHOME";
        }

        public void onRecordLoaded(AsyncResult asyncresult) {
            ArrayList arraylist = (ArrayList)asyncresult.result;
            log((new StringBuilder()).append("CSIM_CDMAHOME data size=").append(arraylist.size()).toString());
            if(!arraylist.isEmpty()) {
                StringBuilder stringbuilder = new StringBuilder();
                StringBuilder stringbuilder1 = new StringBuilder();
                Iterator iterator = arraylist.iterator();
                do {
                    if(!iterator.hasNext())
                        break;
                    byte abyte0[] = (byte[])iterator.next();
                    if(abyte0.length == 5) {
                        int i = (0xff & abyte0[1]) << 8 | 0xff & abyte0[0];
                        int j = (0xff & abyte0[3]) << 8 | 0xff & abyte0[2];
                        stringbuilder.append(i).append(',');
                        stringbuilder1.append(j).append(',');
                    }
                } while(true);
                stringbuilder.setLength(-1 + stringbuilder.length());
                stringbuilder1.setLength(-1 + stringbuilder1.length());
                mHomeSystemId = stringbuilder.toString();
                mHomeNetworkId = stringbuilder1.toString();
            }
        }

        final CdmaLteUiccRecords this$0;

        private EfCsimCdmaHomeLoaded() {
            this$0 = CdmaLteUiccRecords.this;
            super();
        }

    }

    private class EfCsimImsimLoaded
        implements com.android.internal.telephony.IccRecords.IccRecordLoaded {

        public String getEfName() {
            return "EF_CSIM_IMSIM";
        }

        public void onRecordLoaded(AsyncResult asyncresult) {
            byte abyte0[] = (byte[])(byte[])asyncresult.result;
            log((new StringBuilder()).append("CSIM_IMSIM=").append(IccUtils.bytesToHexString(abyte0)).toString());
            boolean flag;
            if((0x80 & abyte0[7]) == 128)
                flag = true;
            else
                flag = false;
            if(flag) {
                int i = ((3 & abyte0[2]) << 8) + (0xff & abyte0[1]);
                int j = ((0xff & abyte0[5]) << 8 | 0xff & abyte0[4]) >> 6;
                int k = 0xf & abyte0[4] >> 2;
                if(k > 9)
                    k = 0;
                int l = (3 & abyte0[4]) << 8 | 0xff & abyte0[3];
                int i1 = adjstMinDigits(i);
                int j1 = adjstMinDigits(j);
                int k1 = adjstMinDigits(l);
                StringBuilder stringbuilder = new StringBuilder();
                Locale locale = Locale.US;
                Object aobj[] = new Object[1];
                aobj[0] = Integer.valueOf(i1);
                stringbuilder.append(String.format(locale, "%03d", aobj));
                Locale locale1 = Locale.US;
                Object aobj1[] = new Object[1];
                aobj1[0] = Integer.valueOf(j1);
                stringbuilder.append(String.format(locale1, "%03d", aobj1));
                Locale locale2 = Locale.US;
                Object aobj2[] = new Object[1];
                aobj2[0] = Integer.valueOf(k);
                stringbuilder.append(String.format(locale2, "%d", aobj2));
                Locale locale3 = Locale.US;
                Object aobj3[] = new Object[1];
                aobj3[0] = Integer.valueOf(k1);
                stringbuilder.append(String.format(locale3, "%03d", aobj3));
                mMin = stringbuilder.toString();
                log((new StringBuilder()).append("min present=").append(mMin).toString());
            } else {
                log("min not present");
            }
        }

        final CdmaLteUiccRecords this$0;

        private EfCsimImsimLoaded() {
            this$0 = CdmaLteUiccRecords.this;
            super();
        }

    }

    private class EfCsimMdnLoaded
        implements com.android.internal.telephony.IccRecords.IccRecordLoaded {

        public String getEfName() {
            return "EF_CSIM_MDN";
        }

        public void onRecordLoaded(AsyncResult asyncresult) {
            byte abyte0[] = (byte[])(byte[])asyncresult.result;
            log((new StringBuilder()).append("CSIM_MDN=").append(IccUtils.bytesToHexString(abyte0)).toString());
            int i = 0xf & abyte0[0];
            mMdn = IccUtils.cdmaBcdToString(abyte0, 1, i);
            log((new StringBuilder()).append("CSIM MDN=").append(mMdn).toString());
        }

        final CdmaLteUiccRecords this$0;

        private EfCsimMdnLoaded() {
            this$0 = CdmaLteUiccRecords.this;
            super();
        }

    }

    private class EfCsimSpnLoaded
        implements com.android.internal.telephony.IccRecords.IccRecordLoaded {

        public String getEfName() {
            return "EF_CSIM_SPN";
        }

        public void onRecordLoaded(AsyncResult asyncresult) {
            byte byte0;
            byte abyte1[];
            int j;
            byte abyte0[] = (byte[])(byte[])asyncresult.result;
            log((new StringBuilder()).append("CSIM_SPN=").append(IccUtils.bytesToHexString(abyte0)).toString());
            CdmaLteUiccRecords cdmalteuiccrecords = CdmaLteUiccRecords.this;
            boolean flag;
            int i;
            if((1 & abyte0[0]) != 0)
                flag = true;
            else
                flag = false;
            cdmalteuiccrecords.mCsimSpnDisplayCondition = flag;
            byte0 = abyte0[1];
            abyte0[2];
            abyte1 = new byte[32];
            if(abyte0.length < 32)
                i = abyte0.length;
            else
                i = 32;
            System.arraycopy(abyte0, 3, abyte1, 0, i);
            j = 0;
_L5:
            if(j < abyte1.length && (0xff & abyte1[j]) != 255) goto _L2; else goto _L1
_L1:
            if(j != 0) goto _L4; else goto _L3
_L3:
            "".append = asyncresult;
_L10:
            return;
_L2:
            j++;
              goto _L5
_L4:
            byte0;
            JVM INSTR tableswitch 0 9: default 216
        //                       0 304
        //                       1 216
        //                       2 361
        //                       3 361
        //                       4 386
        //                       5 216
        //                       6 216
        //                       7 216
        //                       8 304
        //                       9 361;
               goto _L6 _L7 _L6 _L8 _L8 _L9 _L6 _L6 _L6 _L7 _L8
_L9:
            break MISSING_BLOCK_LABEL_386;
_L6:
            try {
                log("SPN encoding not supported");
            }
            catch(Exception exception) {
                log((new StringBuilder()).append("spn decode error: ").append(exception).toString());
            }
_L11:
            log((new StringBuilder()).append("spn=").append(append).toString());
            log((new StringBuilder()).append("spnCondition=").append(mCsimSpnDisplayCondition).toString());
            SystemProperties.set("gsm.sim.operator.alpha", append);
              goto _L10
_L7:
            (new String(abyte1, 0, j, "ISO-8859-1")).append = asyncresult;
            break MISSING_BLOCK_LABEL_225;
_L8:
            GsmAlphabet.gsm7BitPackedToString(abyte1, 0, (j * 8) / 7).append = asyncresult;
              goto _L11
            (new String(abyte1, 0, j, "utf-16")).append = asyncresult;
              goto _L11
        }

        final CdmaLteUiccRecords this$0;

        private EfCsimSpnLoaded() {
            this$0 = CdmaLteUiccRecords.this;
            super();
        }

    }

    private class EfCsimLiLoaded
        implements com.android.internal.telephony.IccRecords.IccRecordLoaded {

        public String getEfName() {
            return "EF_CSIM_LI";
        }

        public void onRecordLoaded(AsyncResult asyncresult) {
            int i;
            mEFli = (byte[])(byte[])asyncresult.result;
            i = 0;
_L10:
            if(i >= mEFli.length)
                break MISSING_BLOCK_LABEL_303;
            mEFli[i + 1];
            JVM INSTR tableswitch 1 7: default 84
        //                       1 114
        //                       2 141
        //                       3 168
        //                       4 195
        //                       5 222
        //                       6 249
        //                       7 276;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L8:
            break MISSING_BLOCK_LABEL_276;
_L2:
            break; /* Loop/switch isn't completed */
_L1:
            mEFli[i] = 32;
            mEFli[i + 1] = 32;
_L11:
            i += 2;
            if(true) goto _L10; else goto _L9
_L9:
            mEFli[i] = 101;
            mEFli[i + 1] = 110;
              goto _L11
_L3:
            mEFli[i] = 102;
            mEFli[i + 1] = 114;
              goto _L11
_L4:
            mEFli[i] = 101;
            mEFli[i + 1] = 115;
              goto _L11
_L5:
            mEFli[i] = 106;
            mEFli[i + 1] = 97;
              goto _L11
_L6:
            mEFli[i] = 107;
            mEFli[i + 1] = 111;
              goto _L11
_L7:
            mEFli[i] = 122;
            mEFli[i + 1] = 104;
              goto _L11
            mEFli[i] = 104;
            mEFli[i + 1] = 101;
              goto _L11
            log((new StringBuilder()).append("EF_LI=").append(IccUtils.bytesToHexString(mEFli)).toString());
            return;
        }

        final CdmaLteUiccRecords this$0;

        private EfCsimLiLoaded() {
            this$0 = CdmaLteUiccRecords.this;
            super();
        }

    }

    private class EfPlLoaded
        implements com.android.internal.telephony.IccRecords.IccRecordLoaded {

        public String getEfName() {
            return "EF_PL";
        }

        public void onRecordLoaded(AsyncResult asyncresult) {
            mEFpl = (byte[])(byte[])asyncresult.result;
            log((new StringBuilder()).append("EF_PL=").append(IccUtils.bytesToHexString(mEFpl)).toString());
        }

        final CdmaLteUiccRecords this$0;

        private EfPlLoaded() {
            this$0 = CdmaLteUiccRecords.this;
            super();
        }

    }


    public CdmaLteUiccRecords(IccCard icccard, Context context, CommandsInterface commandsinterface) {
        super(icccard, context, commandsinterface);
        mEFpl = null;
        mEFli = null;
        mCsimSpnDisplayCondition = false;
    }

    private int adjstMinDigits(int i) {
        int j = i + 111;
        if(j % 10 == 0)
            j -= 10;
        if((j / 10) % 10 == 0)
            j -= 100;
        if((j / 100) % 10 == 0)
            j -= 1000;
        return j;
    }

    private String findBestLanguage(byte abyte0[]) {
        String as[] = super.mContext.getAssets().getLocales();
        if(abyte0 != null && as != null) goto _L2; else goto _L1
_L1:
        String s = null;
_L5:
        return s;
_L2:
        int i = 0;
_L7:
        if(i + 1 >= abyte0.length)
            break MISSING_BLOCK_LABEL_107;
        int j;
        s = new String(abyte0, i, 2, "ISO-8859-1");
        j = 0;
_L6:
        if(j >= as.length)
            break MISSING_BLOCK_LABEL_103;
        if(as[j] == null || as[j].length() < 2) goto _L4; else goto _L3
_L3:
        boolean flag = as[j].substring(0, 2).equals(s);
        if(flag) goto _L5; else goto _L4
_L4:
        j++;
          goto _L6
        if(true)
            break MISSING_BLOCK_LABEL_120;
        s = null;
          goto _L5
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        log("Failed to parse SIM language records");
        i += 2;
          goto _L7
    }

    private void onGetCSimEprlDone(AsyncResult asyncresult) {
        byte abyte0[] = (byte[])(byte[])asyncresult.result;
        log((new StringBuilder()).append("CSIM_EPRL=").append(IccUtils.bytesToHexString(abyte0)).toString());
        if(abyte0.length > 3)
            mPrlVersion = Integer.toString((0xff & abyte0[2]) << 8 | 0xff & abyte0[3]);
        log((new StringBuilder()).append("CSIM PRL version=").append(mPrlVersion).toString());
    }

    private void setLocaleFromCsim() {
        String s = findBestLanguage(mEFli);
        if(s == null)
            s = findBestLanguage(mEFpl);
        if(s != null) {
            String s1 = getIMSI();
            String s2 = null;
            if(s1 != null)
                s2 = MccTable.countryCodeForMcc(Integer.parseInt(s1.substring(0, 3)));
            log((new StringBuilder()).append("Setting locale to ").append(s).append("_").append(s2).toString());
            MccTable.setSystemLocale(super.mContext, s, s2);
        } else {
            log("No suitable CSIM selected locale");
        }
    }

    protected void fetchSimRecords() {
        super.recordsRequested = true;
        super.mCi.getIMSIForApp(super.mParentCard.getAid(), obtainMessage(3));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(12258, obtainMessage(4));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(28589, obtainMessage(9));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(12037, obtainMessage(100, new EfPlLoaded()));
        super.recordsToLoad = 1 + super.recordsToLoad;
        (new AdnRecordLoader(super.mFh)).loadFromEF(28480, 28490, 1, obtainMessage(10));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(28472, obtainMessage(17));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(28474, obtainMessage(100, new EfCsimLiLoaded()));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(28481, obtainMessage(100, new EfCsimSpnLoaded()));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFLinearFixed(28484, 1, obtainMessage(100, new EfCsimMdnLoaded()));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(28450, obtainMessage(100, new EfCsimImsimLoaded()));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFLinearFixedAll(28456, obtainMessage(100, new EfCsimCdmaHomeLoaded()));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.mFh.loadEFTransparent(28506, obtainMessage(100, new EfCsimEprlLoaded()));
        super.recordsToLoad = 1 + super.recordsToLoad;
        super.recordsToLoad = super.recordsToLoad + mIsimUiccRecords.fetchIsimRecords(super.mFh, this);
    }

    public boolean getCsimSpnDisplayCondition() {
        return mCsimSpnDisplayCondition;
    }

    public IsimRecords getIsimRecords() {
        return mIsimUiccRecords;
    }

    public String getMdn() {
        return mMdn;
    }

    public String getMin() {
        return mMin;
    }

    public String getNid() {
        return mHomeNetworkId;
    }

    public String getPrlVersion() {
        return mPrlVersion;
    }

    public String getSid() {
        return mHomeSystemId;
    }

    public boolean isProvisioned() {
        boolean flag = true;
        if(!SystemProperties.getBoolean("persist.radio.test-csim", false)) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(super.mParentCard == null)
            flag = false;
        else
        if(super.mParentCard.isApplicationOnIcc(com.android.internal.telephony.IccCardApplication.AppType.APPTYPE_CSIM) && (mMdn == null || mMin == null))
            flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected void log(String s) {
        Log.d("GSM", (new StringBuilder()).append("[CSIM] ").append(s).toString());
    }

    protected void loge(String s) {
        Log.e("GSM", (new StringBuilder()).append("[CSIM] ").append(s).toString());
    }

    protected void onAllRecordsLoaded() {
        setLocaleFromCsim();
        super.onAllRecordsLoaded();
    }

    protected void onRecordLoaded() {
        super.recordsToLoad = -1 + super.recordsToLoad;
        if(super.recordsToLoad != 0 || !super.recordsRequested) goto _L2; else goto _L1
_L1:
        onAllRecordsLoaded();
_L4:
        return;
_L2:
        if(super.recordsToLoad < 0) {
            Log.e("GSM", "SIMRecords: recordsToLoad <0, programmer error suspected");
            super.recordsToLoad = 0;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    boolean mCsimSpnDisplayCondition;
    private byte mEFli[];
    private byte mEFpl[];
    private String mHomeNetworkId;
    private String mHomeSystemId;
    private final IsimUiccRecords mIsimUiccRecords = new IsimUiccRecords();
    private String mMdn;
    private String mMin;
    private String mPrlVersion;



/*
    static byte[] access$002(CdmaLteUiccRecords cdmalteuiccrecords, byte abyte0[]) {
        cdmalteuiccrecords.mEFpl = abyte0;
        return abyte0;
    }

*/




/*
    static String access$1002(CdmaLteUiccRecords cdmalteuiccrecords, String s) {
        cdmalteuiccrecords.mMin = s;
        return s;
    }

*/


/*
    static byte[] access$102(CdmaLteUiccRecords cdmalteuiccrecords, byte abyte0[]) {
        cdmalteuiccrecords.mEFli = abyte0;
        return abyte0;
    }

*/


/*
    static String access$1102(CdmaLteUiccRecords cdmalteuiccrecords, String s) {
        cdmalteuiccrecords.mHomeSystemId = s;
        return s;
    }

*/


/*
    static String access$1202(CdmaLteUiccRecords cdmalteuiccrecords, String s) {
        cdmalteuiccrecords.mHomeNetworkId = s;
        return s;
    }

*/



/*
    static String access$202(CdmaLteUiccRecords cdmalteuiccrecords, String s) {
        cdmalteuiccrecords.spn = s;
        return s;
    }

*/


/*
    static String access$302(CdmaLteUiccRecords cdmalteuiccrecords, String s) {
        cdmalteuiccrecords.spn = s;
        return s;
    }

*/


/*
    static String access$402(CdmaLteUiccRecords cdmalteuiccrecords, String s) {
        cdmalteuiccrecords.spn = s;
        return s;
    }

*/


/*
    static String access$502(CdmaLteUiccRecords cdmalteuiccrecords, String s) {
        cdmalteuiccrecords.spn = s;
        return s;
    }

*/





/*
    static String access$802(CdmaLteUiccRecords cdmalteuiccrecords, String s) {
        cdmalteuiccrecords.mMdn = s;
        return s;
    }

*/

}
