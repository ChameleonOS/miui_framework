// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.os.AsyncResult;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;

// Referenced classes of package com.android.internal.telephony:
//            AdnRecordCache, AdnRecord

public class AdnCacheManager {

    public AdnCacheManager(AdnRecordCache adnrecordcache) {
        mAdnCache = adnrecordcache;
    }

    public int getAdnCapacity() {
        return mAdnCapacity;
    }

    public int getFreeAdn() {
        return mFreeAdn;
    }

    public void handleAllAdnLikeLoaded(int i, ArrayList arraylist) {
        if(i == 20272) {
            mAdnCache.adnLikeFiles.put(28474, arraylist);
            mAdnCapacity = arraylist.size();
            Log.d("AdnCacheManager", (new StringBuilder()).append("ADN capacity is ").append(mAdnCapacity).toString());
        }
    }

    public void handleLoadAllAdnLike(int i, AsyncResult asyncresult) {
        if(i == 20272)
            i = 28474;
        mAdnCache.adnLikeFiles.put(i, (ArrayList)asyncresult.result);
        if(i != 28475 && i != 28489) {
            ArrayList arraylist = (ArrayList)(ArrayList)asyncresult.result;
            mAdnCapacity = arraylist.size();
            Log.d("AdnCacheManager", (new StringBuilder()).append("ADN capacity is ").append(mAdnCapacity).toString());
            for(int j = 0; j < arraylist.size(); j++)
                if(((AdnRecord)arraylist.get(j)).isEmpty())
                    mFreeAdn = 1 + mFreeAdn;

        }
    }

    public void handleNonExistentAdnRecord(int i) {
        if(i == 28474)
            mFreeAdn = 0;
    }

    public void handleUpdateAdnRecord(int i, AdnRecord adnrecord, AdnRecord adnrecord1) {
        if(!adnrecord1.isEmpty() || i != 28474) goto _L2; else goto _L1
_L1:
        mFreeAdn = -1 + mFreeAdn;
_L4:
        return;
_L2:
        if(adnrecord.isEmpty() && i == 28474)
            mFreeAdn = 1 + mFreeAdn;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void reset() {
        mFreeAdn = 0;
        mAdnCapacity = 0;
    }

    public static final String SERVICE_NAME = "miui.adnCacheManager";
    private static final String TAG = "AdnCacheManager";
    private AdnRecordCache mAdnCache;
    private int mAdnCapacity;
    private int mFreeAdn;
}
