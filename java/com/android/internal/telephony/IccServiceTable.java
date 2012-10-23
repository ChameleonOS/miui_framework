// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.util.Log;

public abstract class IccServiceTable {

    protected IccServiceTable(byte abyte0[]) {
        mServiceTable = abyte0;
    }

    protected abstract String getTag();

    protected abstract Object[] getValues();

    protected boolean isAvailable(int i) {
        int j = 1;
        int k = 0;
        int l = i / 8;
        if(l >= mServiceTable.length) {
            Log.e(getTag(), (new StringBuilder()).append("isAvailable for service ").append(i + 1).append(" fails, max service is ").append(8 * mServiceTable.length).toString());
        } else {
            int i1 = i % 8;
            if((mServiceTable[l] & j << i1) == 0)
                j = 0;
            k = j;
        }
        return k;
    }

    public String toString() {
        Object aobj[] = getValues();
        int i = mServiceTable.length;
        StringBuilder stringbuilder = (new StringBuilder(getTag())).append('[').append(i * 8).append("]={ ");
        boolean flag = false;
        for(int j = 0; j < i; j++) {
            byte byte0 = mServiceTable[j];
            int k = 0;
            while(k < 8)  {
                if((byte0 & 1 << k) != 0) {
                    int l;
                    if(flag)
                        stringbuilder.append(", ");
                    else
                        flag = true;
                    l = k + j * 8;
                    if(l < aobj.length)
                        stringbuilder.append(aobj[l]);
                    else
                        stringbuilder.append('#').append(l + 1);
                }
                k++;
            }
        }

        return stringbuilder.append(" }").toString();
    }

    protected final byte mServiceTable[];
}
