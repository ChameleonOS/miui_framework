// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony.cdma;

import android.os.Bundle;
import android.telephony.CellLocation;

public class CdmaCellLocation extends CellLocation {

    public CdmaCellLocation() {
        mBaseStationId = -1;
        mBaseStationLatitude = 0x7fffffff;
        mBaseStationLongitude = 0x7fffffff;
        mSystemId = -1;
        mNetworkId = -1;
        mBaseStationId = -1;
        mBaseStationLatitude = 0x7fffffff;
        mBaseStationLongitude = 0x7fffffff;
        mSystemId = -1;
        mNetworkId = -1;
    }

    public CdmaCellLocation(Bundle bundle) {
        mBaseStationId = -1;
        mBaseStationLatitude = 0x7fffffff;
        mBaseStationLongitude = 0x7fffffff;
        mSystemId = -1;
        mNetworkId = -1;
        mBaseStationId = bundle.getInt("baseStationId", mBaseStationId);
        mBaseStationLatitude = bundle.getInt("baseStationLatitude", mBaseStationLatitude);
        mBaseStationLongitude = bundle.getInt("baseStationLongitude", mBaseStationLongitude);
        mSystemId = bundle.getInt("systemId", mSystemId);
        mNetworkId = bundle.getInt("networkId", mNetworkId);
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
        CdmaCellLocation cdmacelllocation = (CdmaCellLocation)obj;
          goto _L1
_L2:
        return flag;
        ClassCastException classcastexception;
        classcastexception;
          goto _L2
_L1:
        if(obj != null && equalsHandlesNulls(Integer.valueOf(mBaseStationId), Integer.valueOf(cdmacelllocation.mBaseStationId)) && equalsHandlesNulls(Integer.valueOf(mBaseStationLatitude), Integer.valueOf(cdmacelllocation.mBaseStationLatitude)) && equalsHandlesNulls(Integer.valueOf(mBaseStationLongitude), Integer.valueOf(cdmacelllocation.mBaseStationLongitude)) && equalsHandlesNulls(Integer.valueOf(mSystemId), Integer.valueOf(cdmacelllocation.mSystemId)) && equalsHandlesNulls(Integer.valueOf(mNetworkId), Integer.valueOf(cdmacelllocation.mNetworkId)))
            flag = true;
          goto _L2
    }

    public void fillInNotifierBundle(Bundle bundle) {
        bundle.putInt("baseStationId", mBaseStationId);
        bundle.putInt("baseStationLatitude", mBaseStationLatitude);
        bundle.putInt("baseStationLongitude", mBaseStationLongitude);
        bundle.putInt("systemId", mSystemId);
        bundle.putInt("networkId", mNetworkId);
    }

    public int getBaseStationId() {
        return mBaseStationId;
    }

    public int getBaseStationLatitude() {
        return mBaseStationLatitude;
    }

    public int getBaseStationLongitude() {
        return mBaseStationLongitude;
    }

    public int getNetworkId() {
        return mNetworkId;
    }

    public int getSystemId() {
        return mSystemId;
    }

    public int hashCode() {
        return mBaseStationId ^ mBaseStationLatitude ^ mBaseStationLongitude ^ mSystemId ^ mNetworkId;
    }

    public boolean isEmpty() {
        boolean flag;
        if(mBaseStationId == -1 && mBaseStationLatitude == 0x7fffffff && mBaseStationLongitude == 0x7fffffff && mSystemId == -1 && mNetworkId == -1)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void setCellLocationData(int i, int j, int k) {
        mBaseStationId = i;
        mBaseStationLatitude = j;
        mBaseStationLongitude = k;
    }

    public void setCellLocationData(int i, int j, int k, int l, int i1) {
        mBaseStationId = i;
        mBaseStationLatitude = j;
        mBaseStationLongitude = k;
        mSystemId = l;
        mNetworkId = i1;
    }

    public void setStateInvalid() {
        mBaseStationId = -1;
        mBaseStationLatitude = 0x7fffffff;
        mBaseStationLongitude = 0x7fffffff;
        mSystemId = -1;
        mNetworkId = -1;
    }

    public String toString() {
        return (new StringBuilder()).append("[").append(mBaseStationId).append(",").append(mBaseStationLatitude).append(",").append(mBaseStationLongitude).append(",").append(mSystemId).append(",").append(mNetworkId).append("]").toString();
    }

    public static final int INVALID_LAT_LONG = 0x7fffffff;
    private int mBaseStationId;
    private int mBaseStationLatitude;
    private int mBaseStationLongitude;
    private int mNetworkId;
    private int mSystemId;
}
