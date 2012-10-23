// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.util.*;

public class RetryManager {
    private static class RetryRec {

        int mDelayTime;
        int mRandomizationTime;

        RetryRec(int i, int j) {
            mDelayTime = i;
            mRandomizationTime = j;
        }
    }


    public RetryManager() {
        mRetryArray = new ArrayList();
        rng = new Random();
    }

    private void log(String s) {
        Log.d("GSM", (new StringBuilder()).append("[RM] ").append(s).toString());
    }

    private int nextRandomizationTime(int i) {
        int j = ((RetryRec)mRetryArray.get(i)).mRandomizationTime;
        int k;
        if(j == 0)
            k = 0;
        else
            k = rng.nextInt(j);
        return k;
    }

    private Pair parseNonNegativeInt(String s, String s1) {
        Pair pair;
        try {
            int i = Integer.parseInt(s1);
            pair = new Pair(Boolean.valueOf(validateNonNegativeInt(s, i)), Integer.valueOf(i));
        }
        catch(NumberFormatException numberformatexception) {
            Log.e("GSM", (new StringBuilder()).append(s).append(" bad value: ").append(s1).toString(), numberformatexception);
            pair = new Pair(Boolean.valueOf(false), Integer.valueOf(0));
        }
        return pair;
    }

    private boolean validateNonNegativeInt(String s, int i) {
        boolean flag;
        if(i < 0) {
            Log.e("GSM", (new StringBuilder()).append(s).append(" bad value: is < 0").toString());
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    public boolean configure(int i, int j, int k) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_3;
        if(validateNonNegativeInt("maxRetryCount", i) && validateNonNegativeInt("retryTime", j) && validateNonNegativeInt("randomizationTime", k)) {
            mMaxRetryCount = i;
            resetRetryCount();
            mRetryArray.clear();
            mRetryArray.add(new RetryRec(j, k));
            flag = true;
        }
        return flag;
    }

    public boolean configure(String s) {
        int i;
        String as[];
        int j;
        if(s.startsWith("\"") && s.endsWith("\""))
            s = s.substring(1, -1 + s.length());
        mConfig = s;
        if(TextUtils.isEmpty(s))
            break MISSING_BLOCK_LABEL_500;
        i = 0;
        mMaxRetryCount = 0;
        resetRetryCount();
        mRetryArray.clear();
        as = s.split(",");
        j = 0;
_L9:
        if(j >= as.length) goto _L2; else goto _L1
_L1:
        String as1[];
        as1 = as[j].split("=", 2);
        as1[0] = as1[0].trim();
        if(as1.length <= 1) goto _L4; else goto _L3
_L3:
        as1[1] = as1[1].trim();
        if(!TextUtils.equals(as1[0], "default_randomization")) goto _L6; else goto _L5
_L5:
        Pair pair3 = parseNonNegativeInt(as1[0], as1[1]);
        if(((Boolean)pair3.first).booleanValue()) goto _L8; else goto _L7
_L7:
        boolean flag = false;
_L11:
        return flag;
_L8:
        i = ((Integer)pair3.second).intValue();
_L10:
        j++;
          goto _L9
_L6:
label0:
        {
            if(!TextUtils.equals(as1[0], "max_retries"))
                break MISSING_BLOCK_LABEL_267;
            if(!TextUtils.equals("infinite", as1[1]))
                break label0;
            mRetryForever = true;
        }
          goto _L10
        Pair pair2;
label1:
        {
            pair2 = parseNonNegativeInt(as1[0], as1[1]);
            if(((Boolean)pair2.first).booleanValue())
                break label1;
            flag = false;
        }
          goto _L11
        mMaxRetryCount = ((Integer)pair2.second).intValue();
          goto _L10
        Log.e("GSM", (new StringBuilder()).append("Unrecognized configuration name value pair: ").append(as[j]).toString());
        flag = false;
          goto _L11
_L4:
        RetryRec retryrec;
        Pair pair1;
        String as2[] = as[j].split(":", 2);
        as2[0] = as2[0].trim();
        retryrec = new RetryRec(0, 0);
        Pair pair = parseNonNegativeInt("delayTime", as2[0]);
        if(!((Boolean)pair.first).booleanValue()) {
            flag = false;
        } else {
label2:
            {
                retryrec.mDelayTime = ((Integer)pair.second).intValue();
                if(as2.length <= 1)
                    break MISSING_BLOCK_LABEL_461;
                as2[1] = as2[1].trim();
                pair1 = parseNonNegativeInt("randomizationTime", as2[1]);
                if(((Boolean)pair1.first).booleanValue())
                    break label2;
                flag = false;
            }
        }
          goto _L11
        retryrec.mRandomizationTime = ((Integer)pair1.second).intValue();
_L12:
        mRetryArray.add(retryrec);
          goto _L10
        retryrec.mRandomizationTime = i;
          goto _L12
_L2:
        if(mRetryArray.size() > mMaxRetryCount)
            mMaxRetryCount = mRetryArray.size();
        flag = true;
          goto _L11
        flag = false;
          goto _L11
    }

    public int getRetryCount() {
        log((new StringBuilder()).append("getRetryCount: ").append(mRetryCount).toString());
        return mRetryCount;
    }

    public int getRetryTimer() {
        int i;
        int j;
        if(mRetryCount < mRetryArray.size())
            i = mRetryCount;
        else
            i = -1 + mRetryArray.size();
        if(i >= 0 && i < mRetryArray.size())
            j = ((RetryRec)mRetryArray.get(i)).mDelayTime + nextRandomizationTime(i);
        else
            j = 0;
        log((new StringBuilder()).append("getRetryTimer: ").append(j).toString());
        return j;
    }

    public void increaseRetryCount() {
        mRetryCount = 1 + mRetryCount;
        if(mRetryCount > mMaxRetryCount)
            mRetryCount = mMaxRetryCount;
        log((new StringBuilder()).append("increaseRetryCount: ").append(mRetryCount).toString());
    }

    public boolean isRetryForever() {
        log((new StringBuilder()).append("isRetryForever: ").append(mRetryForever).toString());
        return mRetryForever;
    }

    public boolean isRetryNeeded() {
        boolean flag;
        if(mRetryForever || mRetryCount < mMaxRetryCount)
            flag = true;
        else
            flag = false;
        log((new StringBuilder()).append("isRetryNeeded: ").append(flag).toString());
        return flag;
    }

    public void resetRetryCount() {
        mRetryCount = 0;
        log((new StringBuilder()).append("resetRetryCount: ").append(mRetryCount).toString());
    }

    public void retryForeverUsingLastTimeout() {
        mRetryCount = mMaxRetryCount;
        mRetryForever = true;
        log((new StringBuilder()).append("retryForeverUsingLastTimeout: ").append(mRetryForever).append(", ").append(mRetryCount).toString());
    }

    public void setRetryCount(int i) {
        mRetryCount = i;
        if(mRetryCount > mMaxRetryCount)
            mRetryCount = mMaxRetryCount;
        if(mRetryCount < 0)
            mRetryCount = 0;
        log((new StringBuilder()).append("setRetryCount: ").append(mRetryCount).toString());
    }

    public void setRetryForever(boolean flag) {
        mRetryForever = flag;
        log((new StringBuilder()).append("setRetryForever: ").append(mRetryForever).toString());
    }

    public String toString() {
        String s = (new StringBuilder()).append("RetryManager: forever=").append(mRetryForever).append(", maxRetry=").append(mMaxRetryCount).append(", retry=").append(mRetryCount).append(",\n    ").append(mConfig).toString();
        for(Iterator iterator = mRetryArray.iterator(); iterator.hasNext();) {
            RetryRec retryrec = (RetryRec)iterator.next();
            s = (new StringBuilder()).append(s).append("\n    ").append(retryrec.mDelayTime).append(":").append(retryrec.mRandomizationTime).toString();
        }

        return s;
    }

    public static final boolean DBG = true;
    public static final String LOG_TAG = "GSM";
    public static final boolean VDBG;
    private String mConfig;
    private int mMaxRetryCount;
    private ArrayList mRetryArray;
    private int mRetryCount;
    private boolean mRetryForever;
    private Random rng;
}
