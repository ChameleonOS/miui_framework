// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.Log;
import java.util.HashMap;

public final class LatencyTimer {

    public LatencyTimer(int i, int j) {
        store = new HashMap();
        if(j == 0)
            j = 1;
        mScaleFactor = j;
        mSampleSize = i;
    }

    private long[] getArray(String s) {
        long al[];
        al = (long[])store.get(s);
        if(al != null)
            break MISSING_BLOCK_LABEL_77;
        HashMap hashmap = store;
        hashmap;
        JVM INSTR monitorenter ;
        al = (long[])store.get(s);
        if(al == null) {
            al = new long[1 + mSampleSize];
            store.put(s, al);
            al[mSampleSize] = 0L;
        }
        return al;
    }

    public void sample(String s, long l) {
        long al[] = getArray(s);
        int i = mSampleSize;
        long l1 = al[i];
        al[i] = 1L + l1;
        al[(int)l1] = l;
        if(al[mSampleSize] == (long)mSampleSize) {
            long l2 = 0L;
            int j = al.length;
            for(int k = 0; k < j; k++)
                l2 += al[k] / (long)mScaleFactor;

            al[mSampleSize] = 0L;
            Log.i("LatencyTimer", (new StringBuilder()).append(s).append(" average = ").append(l2 / (long)mSampleSize).toString());
        }
    }

    final String TAG = "LatencyTimer";
    final int mSampleSize;
    final int mScaleFactor;
    volatile HashMap store;
}
