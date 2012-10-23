// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;


public class RestrictedState {

    public RestrictedState() {
        setPsRestricted(false);
        setCsNormalRestricted(false);
        setCsEmergencyRestricted(false);
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        RestrictedState restrictedstate = (RestrictedState)obj;
          goto _L1
_L2:
        return flag;
        ClassCastException classcastexception;
        classcastexception;
          goto _L2
_L1:
        if(obj != null && mPsRestricted == restrictedstate.mPsRestricted && mCsNormalRestricted == restrictedstate.mCsNormalRestricted && mCsEmergencyRestricted == restrictedstate.mCsEmergencyRestricted)
            flag = true;
          goto _L2
    }

    public boolean isCsEmergencyRestricted() {
        return mCsEmergencyRestricted;
    }

    public boolean isCsNormalRestricted() {
        return mCsNormalRestricted;
    }

    public boolean isCsRestricted() {
        boolean flag;
        if(mCsNormalRestricted && mCsEmergencyRestricted)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isPsRestricted() {
        return mPsRestricted;
    }

    public void setCsEmergencyRestricted(boolean flag) {
        mCsEmergencyRestricted = flag;
    }

    public void setCsNormalRestricted(boolean flag) {
        mCsNormalRestricted = flag;
    }

    public void setPsRestricted(boolean flag) {
        mPsRestricted = flag;
    }

    public String toString() {
        String s = "none";
        if(!mCsEmergencyRestricted || !mCsNormalRestricted) goto _L2; else goto _L1
_L1:
        s = "all";
_L4:
        return (new StringBuilder()).append("Restricted State CS: ").append(s).append(" PS:").append(mPsRestricted).toString();
_L2:
        if(mCsEmergencyRestricted && !mCsNormalRestricted)
            s = "emergency";
        else
        if(!mCsEmergencyRestricted && mCsNormalRestricted)
            s = "normal call";
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean mCsEmergencyRestricted;
    private boolean mCsNormalRestricted;
    private boolean mPsRestricted;
}
