// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.*;
import android.util.Log;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.telephony:
//            AdnRecord, IccFileHandler, IccUtils

public class AdnRecordLoader extends Handler {

    public AdnRecordLoader(IccFileHandler iccfilehandler) {
        super(Looper.getMainLooper());
        mFh = iccfilehandler;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        i;
        JVM INSTR tableswitch 1 5: default 40
    //                   1 322
    //                   2 434
    //                   3 573
    //                   4 81
    //                   5 274;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        if(userResponse != null && pendingExtLoads == 0) {
            AsyncResult.forMessage(userResponse).result = result;
            userResponse.sendToTarget();
            userResponse = null;
        }
_L8:
        return;
_L5:
        AsyncResult asyncresult4;
        AdnRecord adnrecord3;
        try {
            asyncresult4 = (AsyncResult)(AsyncResult)message.obj;
            adnrecord3 = (AdnRecord)(AdnRecord)asyncresult4.userObj;
            if(asyncresult4.exception != null)
                throw new RuntimeException("get EF record size failed", asyncresult4.exception);
            break; /* Loop/switch isn't completed */
        }
        catch(RuntimeException runtimeexception) {
            if(userResponse != null) {
                AsyncResult.forMessage(userResponse).exception = runtimeexception;
                userResponse.sendToTarget();
                userResponse = null;
            }
        }
        if(true) goto _L8; else goto _L7
_L7:
        int ai[] = (int[])(int[])asyncresult4.result;
        if(ai.length != 3 || recordNumber > ai[2])
            throw new RuntimeException("get wrong EF record size format", asyncresult4.exception);
        byte abyte2[] = adnrecord3.buildAdnString(ai[0]);
        if(abyte2 == null)
            throw new RuntimeException("wrong ADN format", asyncresult4.exception);
        mFh.updateEFLinearFixed(ef, recordNumber, abyte2, pin2, obtainMessage(5));
        pendingExtLoads = 1;
        continue; /* Loop/switch isn't completed */
_L6:
        AsyncResult asyncresult3 = (AsyncResult)(AsyncResult)message.obj;
        if(asyncresult3.exception != null)
            throw new RuntimeException("update EF adn record failed", asyncresult3.exception);
        pendingExtLoads = 0;
        result = null;
        continue; /* Loop/switch isn't completed */
_L2:
        AsyncResult asyncresult2 = (AsyncResult)(AsyncResult)message.obj;
        byte abyte1[] = (byte[])(byte[])asyncresult2.result;
        if(asyncresult2.exception != null)
            throw new RuntimeException("load failed", asyncresult2.exception);
        AdnRecord adnrecord2 = new AdnRecord(ef, recordNumber, abyte1);
        result = adnrecord2;
        if(adnrecord2.hasExtendedRecord()) {
            pendingExtLoads = 1;
            mFh.loadEFLinearFixed(extensionEF, adnrecord2.extRecord, obtainMessage(2, adnrecord2));
        }
        continue; /* Loop/switch isn't completed */
_L3:
        AsyncResult asyncresult1 = (AsyncResult)(AsyncResult)message.obj;
        byte abyte0[] = (byte[])(byte[])asyncresult1.result;
        AdnRecord adnrecord1 = (AdnRecord)(AdnRecord)asyncresult1.userObj;
        if(asyncresult1.exception != null)
            throw new RuntimeException("load failed", asyncresult1.exception);
        Log.d("RIL_AdnRecordLoader", (new StringBuilder()).append("ADN extension EF: 0x").append(Integer.toHexString(extensionEF)).append(":").append(adnrecord1.extRecord).append("\n").append(IccUtils.bytesToHexString(abyte0)).toString());
        adnrecord1.appendExtRecord(abyte0);
        pendingExtLoads = -1 + pendingExtLoads;
        continue; /* Loop/switch isn't completed */
_L4:
        ArrayList arraylist;
        int j;
        int k;
        AsyncResult asyncresult = (AsyncResult)(AsyncResult)message.obj;
        arraylist = (ArrayList)(ArrayList)asyncresult.result;
        if(asyncresult.exception != null)
            throw new RuntimeException("load failed", asyncresult.exception);
        adns = new ArrayList(arraylist.size());
        result = adns;
        pendingExtLoads = 0;
        j = 0;
        k = arraylist.size();
_L9:
        if(j >= k)
            continue; /* Loop/switch isn't completed */
        AdnRecord adnrecord = new AdnRecord(ef, j + 1, (byte[])arraylist.get(j));
        adns.add(adnrecord);
        if(adnrecord.hasExtendedRecord()) {
            pendingExtLoads = 1 + pendingExtLoads;
            mFh.loadEFLinearFixed(extensionEF, adnrecord.extRecord, obtainMessage(2, adnrecord));
        }
        j++;
          goto _L9
        if(true) goto _L1; else goto _L10
_L10:
    }

    public void loadAllFromEF(int i, int j, Message message) {
        ef = i;
        extensionEF = j;
        userResponse = message;
        mFh.loadEFLinearFixedAll(i, obtainMessage(3));
    }

    public void loadFromEF(int i, int j, int k, Message message) {
        ef = i;
        extensionEF = j;
        recordNumber = k;
        userResponse = message;
        mFh.loadEFLinearFixed(i, k, obtainMessage(1));
    }

    public void updateEF(AdnRecord adnrecord, int i, int j, int k, String s, Message message) {
        ef = i;
        extensionEF = j;
        recordNumber = k;
        userResponse = message;
        pin2 = s;
        mFh.getEFLinearRecordSize(i, obtainMessage(4, adnrecord));
    }

    static final int EVENT_ADN_LOAD_ALL_DONE = 3;
    static final int EVENT_ADN_LOAD_DONE = 1;
    static final int EVENT_EF_LINEAR_RECORD_SIZE_DONE = 4;
    static final int EVENT_EXT_RECORD_LOAD_DONE = 2;
    static final int EVENT_UPDATE_RECORD_DONE = 5;
    static final String LOG_TAG = "RIL_AdnRecordLoader";
    ArrayList adns;
    int ef;
    int extensionEF;
    private IccFileHandler mFh;
    int pendingExtLoads;
    String pin2;
    int recordNumber;
    Object result;
    Message userResponse;
}
