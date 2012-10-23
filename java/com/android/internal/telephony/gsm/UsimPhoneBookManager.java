// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.gsm;

import android.os.*;
import android.util.Log;
import com.android.internal.telephony.*;
import java.util.*;

// Referenced classes of package com.android.internal.telephony.gsm:
//            SimTlv

public class UsimPhoneBookManager extends Handler
    implements IccConstants {
    private class PbrFile {

        void parseEf(SimTlv simtlv, Map map, int i) {
            int j = 0;
_L5:
            int k;
            k = simtlv.getTag();
            if(i == 169 && k == 202) {
                mEmailPresentInIap = true;
                mEmailTagNumberInIap = j;
            }
            k;
            JVM INSTR tableswitch 192 203: default 108
        //                       192 119
        //                       193 119
        //                       194 119
        //                       195 119
        //                       196 119
        //                       197 119
        //                       198 119
        //                       199 119
        //                       200 119
        //                       201 119
        //                       202 119
        //                       203 119;
               goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
            j++;
            if(!simtlv.nextObject())
                return;
              goto _L3
_L2:
            byte abyte0[] = simtlv.getData();
            int l = (0xff & abyte0[0]) << 8 | 0xff & abyte0[1];
            map.put(Integer.valueOf(k), Integer.valueOf(l));
            if(true) goto _L1; else goto _L3
_L3:
            if(true) goto _L5; else goto _L4
_L4:
        }

        void parseTag(SimTlv simtlv, int i) {
            HashMap hashmap = new HashMap();
_L6:
            int j = simtlv.getTag();
            j;
            JVM INSTR tableswitch 168 170: default 44
        //                       168 65
        //                       169 65
        //                       170 65;
               goto _L1 _L2 _L2 _L2
_L1:
            if(!simtlv.nextObject()) {
                mFileIds.put(Integer.valueOf(i), hashmap);
                return;
            }
              goto _L3
_L2:
            byte abyte0[] = simtlv.getData();
            parseEf(new SimTlv(abyte0, 0, abyte0.length), hashmap, j);
            if(true) goto _L1; else goto _L4
_L4:
_L3:
            if(true) goto _L6; else goto _L5
_L5:
        }

        HashMap mFileIds;
        final UsimPhoneBookManager this$0;

        PbrFile(ArrayList arraylist) {
            this$0 = UsimPhoneBookManager.this;
            super();
            mFileIds = new HashMap();
            int i = 0;
            for(Iterator iterator = arraylist.iterator(); iterator.hasNext();) {
                byte abyte0[] = (byte[])iterator.next();
                parseTag(new SimTlv(abyte0, 0, abyte0.length), i);
                i++;
            }

        }
    }


    public UsimPhoneBookManager(IccFileHandler iccfilehandler, AdnRecordCache adnrecordcache) {
        mLock = new Object();
        mEmailPresentInIap = false;
        mEmailTagNumberInIap = 0;
        mRefreshCache = false;
        mFh = iccfilehandler;
        mPhoneBookRecords = new ArrayList();
        mPbrFile = null;
        mIsPbrPresent = Boolean.valueOf(true);
        mAdnCache = adnrecordcache;
    }

    private void createPbrFile(ArrayList arraylist) {
        if(arraylist == null) {
            mPbrFile = null;
            mIsPbrPresent = Boolean.valueOf(false);
        } else {
            mPbrFile = new PbrFile(arraylist);
        }
    }

    private void log(String s) {
        Log.d("GSM", s);
    }

    private void readAdnFileAndWait(int i) {
        Map map = (Map)mPbrFile.mFileIds.get(Integer.valueOf(i));
        if(map != null && !map.isEmpty()) {
            int j = 0;
            if(map.containsKey(Integer.valueOf(194)))
                j = ((Integer)map.get(Integer.valueOf(194))).intValue();
            mAdnCache.requestLoadAllAdnLike(((Integer)map.get(Integer.valueOf(192))).intValue(), j, obtainMessage(2));
            try {
                mLock.wait();
            }
            catch(InterruptedException interruptedexception) {
                Log.e("GSM", "Interrupted Exception in readAdnFileAndWait");
            }
        }
    }

    private void readEmailFileAndWait(int i) {
        Map map;
        map = (Map)mPbrFile.mFileIds.get(Integer.valueOf(i));
        break MISSING_BLOCK_LABEL_18;
        while(true)  {
            do
                return;
            while(map == null || !map.containsKey(Integer.valueOf(202)));
            ((Integer)map.get(Integer.valueOf(202))).intValue();
            if(mEmailPresentInIap) {
                readIapFileAndWait(((Integer)map.get(Integer.valueOf(193))).intValue());
                if(mIapFileRecord == null) {
                    Log.e("GSM", "Error: IAP file is empty");
                    continue;
                }
            }
            mFh.loadEFLinearFixedAll(((Integer)map.get(Integer.valueOf(202))).intValue(), obtainMessage(4));
            try {
                mLock.wait();
            }
            catch(InterruptedException interruptedexception) {
                Log.e("GSM", "Interrupted Exception in readEmailFileAndWait");
            }
            if(mEmailFileRecord == null)
                Log.e("GSM", "Error: Email file is empty");
            else
                updatePhoneAdnRecord();
        }
    }

    private String readEmailRecord(int i) {
        byte abyte0[] = (byte[])mEmailFileRecord.get(i);
        String s = IccUtils.adnStringFieldToString(abyte0, 0, -2 + abyte0.length);
_L2:
        return s;
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        s = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void readIapFileAndWait(int i) {
        mFh.loadEFLinearFixedAll(i, obtainMessage(3));
        mLock.wait();
_L1:
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.e("GSM", "Interrupted Exception in readIapFileAndWait");
          goto _L1
    }

    private void readPbrFileAndWait() {
        mFh.loadEFLinearFixedAll(20272, obtainMessage(1));
        mLock.wait();
_L1:
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.e("GSM", "Interrupted Exception in readAdnFileAndWait");
          goto _L1
    }

    private void refreshCache() {
        if(mPbrFile != null) {
            mPhoneBookRecords.clear();
            int i = mPbrFile.mFileIds.size();
            int j = 0;
            while(j < i)  {
                readAdnFileAndWait(j);
                j++;
            }
        }
    }

    private void updatePhoneAdnRecord() {
        if(mEmailFileRecord != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = mPhoneBookRecords.size();
        if(mIapFileRecord == null) goto _L4; else goto _L3
_L3:
        int l = 0;
_L6:
        if(l >= i) goto _L4; else goto _L5
_L5:
        byte abyte0[] = (byte[])mIapFileRecord.get(l);
        int k;
        ArrayList arraylist;
        byte byte0 = abyte0[mEmailTagNumberInIap];
        if(byte0 != -1) {
            String as1[] = new String[1];
            as1[0] = readEmailRecord(byte0 - 1);
            AdnRecord adnrecord1 = (AdnRecord)mPhoneBookRecords.get(l);
            int j;
            IndexOutOfBoundsException indexoutofboundsexception1;
            if(adnrecord1 != null)
                adnrecord1.setEmails(as1);
            else
                adnrecord1 = new AdnRecord("", "", as1);
            mPhoneBookRecords.set(l, adnrecord1);
        }
        l++;
        if(true) goto _L6; else goto _L4
        indexoutofboundsexception1;
        Log.e("GSM", "Error: Improper ICC card: No IAP record for ADN, continuing");
_L4:
        j = mPhoneBookRecords.size();
        if(mEmailsForAdnRec == null)
            parseType1EmailFile(j);
        k = 0;
_L8:
        if(k >= i)
            continue; /* Loop/switch isn't completed */
        arraylist = (ArrayList)mEmailsForAdnRec.get(Integer.valueOf(k));
        IndexOutOfBoundsException indexoutofboundsexception;
        if(arraylist != null) {
            AdnRecord adnrecord = (AdnRecord)mPhoneBookRecords.get(k);
            String as[] = new String[arraylist.size()];
            System.arraycopy(((Object) (arraylist.toArray())), 0, as, 0, arraylist.size());
            adnrecord.setEmails(as);
            mPhoneBookRecords.set(k, adnrecord);
        }
        k++;
        if(true) goto _L8; else goto _L7
_L7:
        indexoutofboundsexception;
        if(true) goto _L1; else goto _L9
_L9:
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 37
    //                   2 96
    //                   3 166
    //                   4 232;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        AsyncResult asyncresult3 = (AsyncResult)message.obj;
        if(asyncresult3.exception == null)
            createPbrFile((ArrayList)asyncresult3.result);
        Object obj3 = mLock;
        obj3;
        JVM INSTR monitorenter ;
        mLock.notify();
        continue; /* Loop/switch isn't completed */
_L3:
        log("Loading USIM ADN records done");
        AsyncResult asyncresult2 = (AsyncResult)message.obj;
        if(asyncresult2.exception == null)
            mPhoneBookRecords.addAll((ArrayList)asyncresult2.result);
        Object obj2 = mLock;
        obj2;
        JVM INSTR monitorenter ;
        mLock.notify();
        continue; /* Loop/switch isn't completed */
_L4:
        log("Loading USIM IAP records done");
        AsyncResult asyncresult1 = (AsyncResult)message.obj;
        if(asyncresult1.exception == null)
            mIapFileRecord = (ArrayList)asyncresult1.result;
        Object obj1 = mLock;
        obj1;
        JVM INSTR monitorenter ;
        mLock.notify();
        continue; /* Loop/switch isn't completed */
_L5:
        log("Loading USIM Email records done");
        AsyncResult asyncresult = (AsyncResult)message.obj;
        if(asyncresult.exception == null)
            mEmailFileRecord = (ArrayList)asyncresult.result;
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        mLock.notify();
        if(true) goto _L1; else goto _L6
_L6:
    }

    public void invalidateCache() {
        mRefreshCache = true;
    }

    public ArrayList loadEfFilesFromUsim() {
        ArrayList arraylist = null;
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        if(!mPhoneBookRecords.isEmpty()) {
            if(mRefreshCache) {
                mRefreshCache = false;
                refreshCache();
            }
            arraylist = mPhoneBookRecords;
            break MISSING_BLOCK_LABEL_135;
        }
        if(!mIsPbrPresent.booleanValue())
            break MISSING_BLOCK_LABEL_135;
        break MISSING_BLOCK_LABEL_65;
        Exception exception;
        exception;
        throw exception;
        if(mPbrFile == null)
            readPbrFileAndWait();
        if(mPbrFile != null)
            break MISSING_BLOCK_LABEL_88;
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_135;
        int i = mPbrFile.mFileIds.size();
        for(int j = 0; j < i; j++) {
            readAdnFileAndWait(j);
            readEmailFileAndWait(j);
        }

        obj;
        JVM INSTR monitorexit ;
        arraylist = mPhoneBookRecords;
        return arraylist;
    }

    void parseType1EmailFile(int i) {
        int j;
        mEmailsForAdnRec = new HashMap();
        j = 0;
_L3:
        if(j >= i) goto _L2; else goto _L1
_L1:
        byte abyte0[] = (byte[])mEmailFileRecord.get(j);
        byte byte0 = abyte0[-1 + abyte0.length];
        IndexOutOfBoundsException indexoutofboundsexception;
        if(byte0 != -1) {
            String s = readEmailRecord(j);
            if(s != null && !s.equals("")) {
                ArrayList arraylist = (ArrayList)mEmailsForAdnRec.get(Integer.valueOf(byte0 - 1));
                if(arraylist == null)
                    arraylist = new ArrayList();
                arraylist.add(s);
                mEmailsForAdnRec.put(Integer.valueOf(byte0 - 1), arraylist);
            }
        }
        j++;
        if(true) goto _L3; else goto _L2
        indexoutofboundsexception;
        Log.e("GSM", "Error: Improper ICC card: No email record for ADN, continuing");
_L2:
    }

    public void reset() {
        mPhoneBookRecords.clear();
        mIapFileRecord = null;
        mEmailFileRecord = null;
        mPbrFile = null;
        mIsPbrPresent = Boolean.valueOf(true);
        mRefreshCache = false;
    }

    private static final boolean DBG = true;
    private static final int EVENT_EMAIL_LOAD_DONE = 4;
    private static final int EVENT_IAP_LOAD_DONE = 3;
    private static final int EVENT_PBR_LOAD_DONE = 1;
    private static final int EVENT_USIM_ADN_LOAD_DONE = 2;
    private static final String LOG_TAG = "GSM";
    private static final int USIM_EFAAS_TAG = 199;
    private static final int USIM_EFADN_TAG = 192;
    private static final int USIM_EFANR_TAG = 196;
    private static final int USIM_EFCCP1_TAG = 203;
    private static final int USIM_EFEMAIL_TAG = 202;
    private static final int USIM_EFEXT1_TAG = 194;
    private static final int USIM_EFGRP_TAG = 198;
    private static final int USIM_EFGSD_TAG = 200;
    private static final int USIM_EFIAP_TAG = 193;
    private static final int USIM_EFPBC_TAG = 197;
    private static final int USIM_EFSNE_TAG = 195;
    private static final int USIM_EFUID_TAG = 201;
    private static final int USIM_TYPE1_TAG = 168;
    private static final int USIM_TYPE2_TAG = 169;
    private static final int USIM_TYPE3_TAG = 170;
    private AdnRecordCache mAdnCache;
    private ArrayList mEmailFileRecord;
    private boolean mEmailPresentInIap;
    private int mEmailTagNumberInIap;
    private Map mEmailsForAdnRec;
    private IccFileHandler mFh;
    private ArrayList mIapFileRecord;
    private Boolean mIsPbrPresent;
    private Object mLock;
    private PbrFile mPbrFile;
    private ArrayList mPhoneBookRecords;
    private boolean mRefreshCache;


/*
    static boolean access$002(UsimPhoneBookManager usimphonebookmanager, boolean flag) {
        usimphonebookmanager.mEmailPresentInIap = flag;
        return flag;
    }

*/


/*
    static int access$102(UsimPhoneBookManager usimphonebookmanager, int i) {
        usimphonebookmanager.mEmailTagNumberInIap = i;
        return i;
    }

*/
}
