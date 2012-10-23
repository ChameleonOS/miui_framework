// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.*;
import android.util.SparseArray;
import com.android.internal.telephony.gsm.UsimPhoneBookManager;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.android.internal.telephony:
//            IccConstants, AdnCacheManager, AdnRecord, AdnRecordLoader, 
//            IccFileHandler

public final class AdnRecordCache extends Handler
    implements IccConstants {

    public AdnRecordCache(IccFileHandler iccfilehandler) {
        adnLikeFiles = new SparseArray();
        adnLikeWaiters = new SparseArray();
        userWriteResponse = new SparseArray();
        mFh = iccfilehandler;
        mUsimPhoneBookManager = new UsimPhoneBookManager(mFh, this);
        mAdnCacheManager = new AdnCacheManager(this);
    }

    private void clearUserWriters() {
        int i = userWriteResponse.size();
        for(int j = 0; j < i; j++)
            sendErrorResponse((Message)userWriteResponse.valueAt(j), "AdnCace reset");

        userWriteResponse.clear();
    }

    private void clearWaiters() {
        int i = adnLikeWaiters.size();
        for(int j = 0; j < i; j++)
            notifyWaiters((ArrayList)adnLikeWaiters.valueAt(j), new AsyncResult(null, null, new RuntimeException("AdnCache reset")));

        adnLikeWaiters.clear();
    }

    private void notifyWaiters(ArrayList arraylist, AsyncResult asyncresult) {
        if(arraylist != null) {
            int i = 0;
            int j = arraylist.size();
            while(i < j)  {
                Message message = (Message)arraylist.get(i);
                AsyncResult.forMessage(message, asyncresult.result, asyncresult.exception);
                message.sendToTarget();
                i++;
            }
        }
    }

    private void sendErrorResponse(Message message, String s) {
        if(message != null) {
            RuntimeException runtimeexception = new RuntimeException(s);
            AsyncResult.forMessage(message).exception = runtimeexception;
            message.sendToTarget();
        }
    }

    int extensionEfForEf(int i) {
        char c = '\u6F4A';
        i;
        JVM INSTR lookupswitch 6: default 64
    //                   20272: 90
    //                   28474: 67
    //                   28475: 83
    //                   28480: 67
    //                   28489: 76
    //                   28615: 69;
           goto _L1 _L2 _L3 _L4 _L3 _L5 _L6
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        c = '\uFFFF';
_L8:
        return c;
_L6:
        c = '\u6FC8';
        continue; /* Loop/switch isn't completed */
_L5:
        c = '\u6F4C';
        continue; /* Loop/switch isn't completed */
_L4:
        c = '\u6F4B';
        continue; /* Loop/switch isn't completed */
_L2:
        c = '\0';
        if(true) goto _L8; else goto _L7
_L7:
    }

    public int getAdnCapacity() {
        return mAdnCacheManager.getAdnCapacity();
    }

    public int getFreeAdn() {
        return mAdnCacheManager.getFreeAdn();
    }

    public ArrayList getRecordsIfLoaded(int i) {
        return (ArrayList)adnLikeFiles.get(i);
    }

    public void handleMessage(Message message) {
        message.what;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 29
    //                   2 97;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        AsyncResult asyncresult1 = (AsyncResult)message.obj;
        int k = message.arg1;
        ArrayList arraylist = (ArrayList)adnLikeWaiters.get(k);
        adnLikeWaiters.delete(k);
        if(asyncresult1.exception == null)
            mAdnCacheManager.handleLoadAllAdnLike(k, asyncresult1);
        notifyWaiters(arraylist, asyncresult1);
        continue; /* Loop/switch isn't completed */
_L3:
        AsyncResult asyncresult = (AsyncResult)message.obj;
        int i = message.arg1;
        int j = message.arg2;
        AdnRecord adnrecord = (AdnRecord)(AdnRecord)asyncresult.userObj;
        if(asyncresult.exception == null) {
            ((ArrayList)adnLikeFiles.get(i)).set(j - 1, adnrecord);
            mUsimPhoneBookManager.invalidateCache();
        }
        Message message1 = (Message)userWriteResponse.get(i);
        userWriteResponse.delete(i);
        AsyncResult.forMessage(message1, null, asyncresult.exception);
        message1.sendToTarget();
        if(true) goto _L1; else goto _L4
_L4:
    }

    public void requestLoadAllAdnLike(int i, int j, Message message) {
        ArrayList arraylist;
        if(i == 20272)
            arraylist = mUsimPhoneBookManager.loadEfFilesFromUsim();
        else
            arraylist = getRecordsIfLoaded(i);
        if(arraylist == null) goto _L2; else goto _L1
_L1:
        if(message != null) {
            mAdnCacheManager.handleAllAdnLikeLoaded(i, arraylist);
            AsyncResult.forMessage(message).result = arraylist;
            message.sendToTarget();
        }
_L4:
        return;
_L2:
        ArrayList arraylist1 = (ArrayList)adnLikeWaiters.get(i);
        if(arraylist1 != null) {
            arraylist1.add(message);
        } else {
            ArrayList arraylist2 = new ArrayList();
            arraylist2.add(message);
            adnLikeWaiters.put(i, arraylist2);
            if(j < 0) {
                if(message != null) {
                    AsyncResult.forMessage(message).exception = new RuntimeException((new StringBuilder()).append("EF is not known ADN-like EF:").append(i).toString());
                    message.sendToTarget();
                }
            } else {
                (new AdnRecordLoader(mFh)).loadAllFromEF(i, j, obtainMessage(1, i, 0));
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void reset() {
        adnLikeFiles.clear();
        mUsimPhoneBookManager.reset();
        clearWaiters();
        clearUserWriters();
        mAdnCacheManager.reset();
    }

    public void updateAdnByIndex(int i, AdnRecord adnrecord, int j, String s, Message message) {
        int k = extensionEfForEf(i);
        if(k < 0)
            sendErrorResponse(message, (new StringBuilder()).append("EF is not known ADN-like EF:").append(i).toString());
        else
        if((Message)userWriteResponse.get(i) != null) {
            sendErrorResponse(message, (new StringBuilder()).append("Have pending update for EF:").append(i).toString());
        } else {
            userWriteResponse.put(i, message);
            (new AdnRecordLoader(mFh)).updateEF(adnrecord, i, k, j, s, obtainMessage(2, i, j, adnrecord));
        }
    }

    public void updateAdnBySearch(int i, AdnRecord adnrecord, AdnRecord adnrecord1, String s, Message message) {
        int j = extensionEfForEf(i);
        if(j >= 0) goto _L2; else goto _L1
_L1:
        sendErrorResponse(message, (new StringBuilder()).append("EF is not known ADN-like EF:").append(i).toString());
_L7:
        return;
_L2:
        ArrayList arraylist;
        if(i == 20272)
            arraylist = mUsimPhoneBookManager.loadEfFilesFromUsim();
        else
            arraylist = getRecordsIfLoaded(i);
        if(arraylist != null) goto _L4; else goto _L3
_L3:
        sendErrorResponse(message, (new StringBuilder()).append("Adn list not exist for EF:").append(i).toString());
          goto _L5
_L4:
        int k;
        int l;
        Iterator iterator;
        k = -1;
        l = 1;
        iterator = arraylist.iterator();
_L8:
label0:
        {
            if(iterator.hasNext()) {
                if(!adnrecord.isEqual((AdnRecord)iterator.next()))
                    break label0;
                k = l;
            }
            if(k == -1) {
                sendErrorResponse(message, (new StringBuilder()).append("Adn record don't exist for ").append(adnrecord).toString());
                mAdnCacheManager.handleNonExistentAdnRecord(i);
            } else {
                if(i == 20272) {
                    AdnRecord adnrecord2 = (AdnRecord)arraylist.get(k - 1);
                    i = adnrecord2.efid;
                    j = adnrecord2.extRecord;
                    k = adnrecord2.recordNumber;
                    adnrecord1.efid = i;
                    adnrecord1.extRecord = j;
                    adnrecord1.recordNumber = k;
                }
                mAdnCacheManager.handleUpdateAdnRecord(i, adnrecord, adnrecord1);
                if((Message)userWriteResponse.get(i) != null) {
                    sendErrorResponse(message, (new StringBuilder()).append("Have pending update for EF:").append(i).toString());
                } else {
                    userWriteResponse.put(i, message);
                    AdnRecordLoader adnrecordloader = new AdnRecordLoader(mFh);
                    Message message1 = obtainMessage(2, i, k, adnrecord1);
                    adnrecordloader.updateEF(adnrecord1, i, j, k, s, message1);
                }
            }
        }
_L5:
        if(true) goto _L7; else goto _L6
_L6:
        l++;
          goto _L8
    }

    static final int EVENT_LOAD_ALL_ADN_LIKE_DONE = 1;
    static final int EVENT_UPDATE_ADN_DONE = 2;
    SparseArray adnLikeFiles;
    SparseArray adnLikeWaiters;
    private AdnCacheManager mAdnCacheManager;
    private IccFileHandler mFh;
    private UsimPhoneBookManager mUsimPhoneBookManager;
    SparseArray userWriteResponse;
}
