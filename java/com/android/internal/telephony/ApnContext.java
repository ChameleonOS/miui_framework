// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.android.internal.telephony:
//            ApnSetting, DataConnectionAc, DataConnection

public class ApnContext {

    public ApnContext(String s, String s1) {
        mWaitingApns = null;
        mApnType = s;
        mState = DataConnectionTracker.State.IDLE;
        setReason("dataEnabled");
        setRetryCount(0);
        mDataEnabled = new AtomicBoolean(false);
        mDependencyMet = new AtomicBoolean(true);
        mWaitingApnsPermanentFailureCountDown = new AtomicInteger(0);
        LOG_TAG = s1;
    }

    public void decWaitingApnsPermFailCount() {
        mWaitingApnsPermanentFailureCountDown.decrementAndGet();
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        printwriter.println((new StringBuilder()).append("ApnContext: ").append(toString()).toString());
    }

    /**
     * @deprecated Method getApnSetting is deprecated
     */

    public ApnSetting getApnSetting() {
        this;
        JVM INSTR monitorenter ;
        ApnSetting apnsetting = mApnSetting;
        this;
        JVM INSTR monitorexit ;
        return apnsetting;
        Exception exception;
        exception;
        throw exception;
    }

    public String getApnType() {
        return mApnType;
    }

    /**
     * @deprecated Method getDataConnection is deprecated
     */

    public DataConnection getDataConnection() {
        this;
        JVM INSTR monitorenter ;
        DataConnection dataconnection = mDataConnection;
        this;
        JVM INSTR monitorexit ;
        return dataconnection;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getDataConnectionAc is deprecated
     */

    public DataConnectionAc getDataConnectionAc() {
        this;
        JVM INSTR monitorenter ;
        DataConnectionAc dataconnectionac = mDataConnectionAc;
        this;
        JVM INSTR monitorexit ;
        return dataconnectionac;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getDependencyMet() {
        return mDependencyMet.get();
    }

    /**
     * @deprecated Method getNextWaitingApn is deprecated
     */

    public ApnSetting getNextWaitingApn() {
        this;
        JVM INSTR monitorenter ;
        ApnSetting apnsetting;
        ArrayList arraylist = mWaitingApns;
        apnsetting = null;
        if(arraylist != null && !arraylist.isEmpty())
            apnsetting = (ApnSetting)arraylist.get(0);
        this;
        JVM INSTR monitorexit ;
        return apnsetting;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getReason is deprecated
     */

    public String getReason() {
        this;
        JVM INSTR monitorenter ;
        String s = mReason;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getRetryCount is deprecated
     */

    public int getRetryCount() {
        this;
        JVM INSTR monitorenter ;
        int i = mRetryCount;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getState is deprecated
     */

    public DataConnectionTracker.State getState() {
        this;
        JVM INSTR monitorenter ;
        DataConnectionTracker.State state = mState;
        this;
        JVM INSTR monitorexit ;
        return state;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getWaitingApns is deprecated
     */

    public ArrayList getWaitingApns() {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = mWaitingApns;
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    public int getWaitingApnsPermFailCount() {
        return mWaitingApnsPermanentFailureCountDown.get();
    }

    public boolean isDisconnected() {
        DataConnectionTracker.State state = getState();
        boolean flag;
        if(state == DataConnectionTracker.State.IDLE || state == DataConnectionTracker.State.FAILED)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isEnabled() {
        return mDataEnabled.get();
    }

    public boolean isReady() {
        boolean flag;
        if(mDataEnabled.get() && mDependencyMet.get())
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected void log(String s) {
        Log.d(LOG_TAG, (new StringBuilder()).append("[ApnContext:").append(mApnType).append("] ").append(s).toString());
    }

    /**
     * @deprecated Method removeWaitingApn is deprecated
     */

    public void removeWaitingApn(ApnSetting apnsetting) {
        this;
        JVM INSTR monitorenter ;
        if(mWaitingApns != null)
            mWaitingApns.remove(apnsetting);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setApnSetting is deprecated
     */

    public void setApnSetting(ApnSetting apnsetting) {
        this;
        JVM INSTR monitorenter ;
        mApnSetting = apnsetting;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setDataConnection is deprecated
     */

    public void setDataConnection(DataConnection dataconnection) {
        this;
        JVM INSTR monitorenter ;
        log((new StringBuilder()).append("setDataConnection: old dc=").append(mDataConnection).append(" new dc=").append(dataconnection).append(" this=").append(this).toString());
        mDataConnection = dataconnection;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setDataConnectionAc is deprecated
     */

    public void setDataConnectionAc(DataConnectionAc dataconnectionac) {
        this;
        JVM INSTR monitorenter ;
        log((new StringBuilder()).append("setDataConnectionAc: old dcac=").append(mDataConnectionAc).append(" new dcac=").append(dataconnectionac).toString());
        if(dataconnectionac == null) goto _L2; else goto _L1
_L1:
        dataconnectionac.addApnContextSync(this);
_L4:
        mDataConnectionAc = dataconnectionac;
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if(mDataConnectionAc == null) goto _L4; else goto _L3
_L3:
        mDataConnectionAc.removeApnContextSync(this);
          goto _L4
        Exception exception;
        exception;
        throw exception;
    }

    public void setDependencyMet(boolean flag) {
        log((new StringBuilder()).append("set mDependencyMet as ").append(flag).append(" current state is ").append(mDependencyMet.get()).toString());
        mDependencyMet.set(flag);
    }

    public void setEnabled(boolean flag) {
        log((new StringBuilder()).append("set enabled as ").append(flag).append(", current state is ").append(mDataEnabled.get()).toString());
        mDataEnabled.set(flag);
    }

    /**
     * @deprecated Method setReason is deprecated
     */

    public void setReason(String s) {
        this;
        JVM INSTR monitorenter ;
        log((new StringBuilder()).append("set reason as ").append(s).append(",current state ").append(mState).toString());
        mReason = s;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setRetryCount is deprecated
     */

    public void setRetryCount(int i) {
        this;
        JVM INSTR monitorenter ;
        log((new StringBuilder()).append("setRetryCount: ").append(i).toString());
        mRetryCount = i;
        DataConnection dataconnection = mDataConnection;
        if(dataconnection != null)
            dataconnection.setRetryCount(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setState is deprecated
     */

    public void setState(DataConnectionTracker.State state) {
        this;
        JVM INSTR monitorenter ;
        log((new StringBuilder()).append("setState: ").append(state).append(", previous state:").append(mState).toString());
        mState = state;
        if(mState == DataConnectionTracker.State.FAILED && mWaitingApns != null)
            mWaitingApns.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setWaitingApns is deprecated
     */

    public void setWaitingApns(ArrayList arraylist) {
        this;
        JVM INSTR monitorenter ;
        mWaitingApns = arraylist;
        mWaitingApnsPermanentFailureCountDown.set(mWaitingApns.size());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String toString() {
        return (new StringBuilder()).append("{mApnType=").append(mApnType).append(" mState=").append(getState()).append(" mWaitingApns=").append(mWaitingApns).append(" mWaitingApnsPermanentFailureCountDown=").append(mWaitingApnsPermanentFailureCountDown).append(" mApnSetting=").append(mApnSetting).append(" mDataConnectionAc=").append(mDataConnectionAc).append(" mReason=").append(mReason).append(" mRetryCount=").append(mRetryCount).append(" mDataEnabled=").append(mDataEnabled).append(" mDependencyMet=").append(mDependencyMet).append("}").toString();
    }

    protected static final boolean DBG = true;
    public final String LOG_TAG;
    private ApnSetting mApnSetting;
    private final String mApnType;
    DataConnection mDataConnection;
    DataConnectionAc mDataConnectionAc;
    AtomicBoolean mDataEnabled;
    AtomicBoolean mDependencyMet;
    String mReason;
    int mRetryCount;
    private DataConnectionTracker.State mState;
    private ArrayList mWaitingApns;
    private AtomicInteger mWaitingApnsPermanentFailureCountDown;
}
