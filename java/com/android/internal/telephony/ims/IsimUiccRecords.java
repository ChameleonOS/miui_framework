// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.ims;

import android.os.AsyncResult;
import android.os.Handler;
import android.util.Log;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.gsm.SimTlv;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.android.internal.telephony.ims:
//            IsimRecords

public final class IsimUiccRecords
    implements IsimRecords {
    private class EfIsimDomainLoaded
        implements com.android.internal.telephony.IccRecords.IccRecordLoaded {

        public String getEfName() {
            return "EF_ISIM_DOMAIN";
        }

        public void onRecordLoaded(AsyncResult asyncresult) {
            byte abyte0[] = (byte[])(byte[])asyncresult.result;
            mIsimDomain = IsimUiccRecords.isimTlvToString(abyte0);
        }

        final IsimUiccRecords this$0;

        private EfIsimDomainLoaded() {
            this$0 = IsimUiccRecords.this;
            super();
        }

    }

    private class EfIsimImpuLoaded
        implements com.android.internal.telephony.IccRecords.IccRecordLoaded {

        public String getEfName() {
            return "EF_ISIM_IMPU";
        }

        public void onRecordLoaded(AsyncResult asyncresult) {
            ArrayList arraylist = (ArrayList)asyncresult.result;
            log((new StringBuilder()).append("EF_IMPU record count: ").append(arraylist.size()).toString());
            mIsimImpu = new String[arraylist.size()];
            int i = 0;
            for(Iterator iterator = arraylist.iterator(); iterator.hasNext();) {
                String s = IsimUiccRecords.isimTlvToString((byte[])iterator.next());
                String as[] = mIsimImpu;
                int j = i + 1;
                as[i] = s;
                i = j;
            }

        }

        final IsimUiccRecords this$0;

        private EfIsimImpuLoaded() {
            this$0 = IsimUiccRecords.this;
            super();
        }

    }

    private class EfIsimImpiLoaded
        implements com.android.internal.telephony.IccRecords.IccRecordLoaded {

        public String getEfName() {
            return "EF_ISIM_IMPI";
        }

        public void onRecordLoaded(AsyncResult asyncresult) {
            byte abyte0[] = (byte[])(byte[])asyncresult.result;
            mIsimImpi = IsimUiccRecords.isimTlvToString(abyte0);
        }

        final IsimUiccRecords this$0;

        private EfIsimImpiLoaded() {
            this$0 = IsimUiccRecords.this;
            super();
        }

    }


    public IsimUiccRecords() {
    }

    private static String isimTlvToString(byte abyte0[]) {
        SimTlv simtlv = new SimTlv(abyte0, 0, abyte0.length);
_L2:
        String s;
        if(simtlv.getTag() != 128)
            continue; /* Loop/switch isn't completed */
        s = new String(simtlv.getData(), Charset.forName("UTF-8"));
_L3:
        return s;
        if(simtlv.nextObject()) goto _L2; else goto _L1
_L1:
        Log.e("GSM", "[ISIM] can't find TLV tag in ISIM record, returning null");
        s = null;
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
    }

    public int fetchIsimRecords(IccFileHandler iccfilehandler, Handler handler) {
        iccfilehandler.loadEFTransparent(28418, handler.obtainMessage(100, new EfIsimImpiLoaded()));
        iccfilehandler.loadEFLinearFixedAll(28420, handler.obtainMessage(100, new EfIsimImpuLoaded()));
        iccfilehandler.loadEFTransparent(28419, handler.obtainMessage(100, new EfIsimDomainLoaded()));
        return 3;
    }

    public String getIsimDomain() {
        return mIsimDomain;
    }

    public String getIsimImpi() {
        return mIsimImpi;
    }

    public String[] getIsimImpu() {
        String as[];
        if(mIsimImpu != null)
            as = (String[])mIsimImpu.clone();
        else
            as = null;
        return as;
    }

    void log(String s) {
        Log.d("GSM", (new StringBuilder()).append("[ISIM] ").append(s).toString());
    }

    void loge(String s) {
        Log.e("GSM", (new StringBuilder()).append("[ISIM] ").append(s).toString());
    }

    private static final boolean DBG = true;
    private static final boolean DUMP_RECORDS = false;
    protected static final String LOG_TAG = "GSM";
    private static final int TAG_ISIM_VALUE = 128;
    private String mIsimDomain;
    private String mIsimImpi;
    private String mIsimImpu[];


/*
    static String access$002(IsimUiccRecords isimuiccrecords, String s) {
        isimuiccrecords.mIsimImpi = s;
        return s;
    }

*/




/*
    static String[] access$202(IsimUiccRecords isimuiccrecords, String as[]) {
        isimuiccrecords.mIsimImpu = as;
        return as;
    }

*/


/*
    static String access$302(IsimUiccRecords isimuiccrecords, String s) {
        isimuiccrecords.mIsimDomain = s;
        return s;
    }

*/
}
