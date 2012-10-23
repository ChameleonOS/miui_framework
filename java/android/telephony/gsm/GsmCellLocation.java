// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony.gsm;

import android.os.Bundle;
import android.telephony.CellLocation;

public class GsmCellLocation extends CellLocation {

    public GsmCellLocation() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
    }

    public GsmCellLocation(Bundle bundle) {
        mLac = bundle.getInt("lac", mLac);
        mCid = bundle.getInt("cid", mCid);
        mPsc = bundle.getInt("psc", mPsc);
    }

    private static boolean equalsHandlesNulls(Object obj, Object obj1) {
        boolean flag;
        if(obj == null) {
            if(obj1 == null)
                flag = true;
            else
                flag = false;
        } else {
            flag = obj.equals(obj1);
        }
        return flag;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        GsmCellLocation gsmcelllocation = (GsmCellLocation)obj;
          goto _L1
_L2:
        return flag;
        ClassCastException classcastexception;
        classcastexception;
          goto _L2
_L1:
        if(obj != null && equalsHandlesNulls(Integer.valueOf(mLac), Integer.valueOf(gsmcelllocation.mLac)) && equalsHandlesNulls(Integer.valueOf(mCid), Integer.valueOf(gsmcelllocation.mCid)) && equalsHandlesNulls(Integer.valueOf(mPsc), Integer.valueOf(gsmcelllocation.mPsc)))
            flag = true;
          goto _L2
    }

    public void fillInNotifierBundle(Bundle bundle) {
        bundle.putInt("lac", mLac);
        bundle.putInt("cid", mCid);
        bundle.putInt("psc", mPsc);
    }

    public int getCid() {
        return mCid;
    }

    public int getLac() {
        return mLac;
    }

    public int getPsc() {
        return mPsc;
    }

    public int hashCode() {
        return mLac ^ mCid;
    }

    public boolean isEmpty() {
        boolean flag;
        if(mLac == -1 && mCid == -1 && mPsc == -1)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void setLacAndCid(int i, int j) {
        mLac = i;
        mCid = j;
    }

    public void setPsc(int i) {
        mPsc = i;
    }

    public void setStateInvalid() {
        mLac = -1;
        mCid = -1;
        mPsc = -1;
    }

    public String toString() {
        return (new StringBuilder()).append("[").append(mLac).append(",").append(mCid).append(",").append(mPsc).append("]").toString();
    }

    private int mCid;
    private int mLac;
    private int mPsc;
}
