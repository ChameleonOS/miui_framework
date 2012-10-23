// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.net.ConnectivityManager;
import android.net.NetworkStats;
import android.os.*;
import android.telephony.SignalStrength;
import android.util.*;
import com.android.internal.net.NetworkStatsFactory;
import com.android.internal.util.JournaledFile;
import com.google.android.collect.Sets;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public final class BatteryStatsImpl extends BatteryStats {
    public final class Uid extends android.os.BatteryStats.Uid {
        public final class Pkg extends android.os.BatteryStats.Uid.Pkg
            implements Unpluggable {
            public final class Serv extends android.os.BatteryStats.Uid.Pkg.Serv
                implements Unpluggable {

                void detach() {
                    mUnpluggables.remove(this);
                }

                public BatteryStatsImpl getBatteryStats() {
                    return _fld0;
                }

                long getLaunchTimeToNowLocked(long l) {
                    long l1;
                    if(!mLaunched)
                        l1 = mLaunchedTime;
                    else
                        l1 = (l + mLaunchedTime) - mLaunchedSince;
                    return l1;
                }

                public int getLaunches(int i) {
                    if(i != 1) goto _L2; else goto _L1
_L1:
                    int j = mLastLaunches;
_L4:
                    return j;
_L2:
                    j = mLaunches;
                    if(i == 2)
                        j -= mLoadedLaunches;
                    else
                    if(i == 3)
                        j -= mUnpluggedLaunches;
                    if(true) goto _L4; else goto _L3
_L3:
                }

                public long getStartTime(long l, int i) {
                    if(i != 1) goto _L2; else goto _L1
_L1:
                    long l1 = mLastStartTime;
_L4:
                    return l1;
_L2:
                    l1 = getStartTimeToNowLocked(l);
                    if(i == 2)
                        l1 -= mLoadedStartTime;
                    else
                    if(i == 3)
                        l1 -= mUnpluggedStartTime;
                    if(true) goto _L4; else goto _L3
_L3:
                }

                long getStartTimeToNowLocked(long l) {
                    long l1;
                    if(!mRunning)
                        l1 = mStartTime;
                    else
                        l1 = (l + mStartTime) - mRunningSince;
                    return l1;
                }

                public int getStarts(int i) {
                    if(i != 1) goto _L2; else goto _L1
_L1:
                    int j = mLastStarts;
_L4:
                    return j;
_L2:
                    j = mStarts;
                    if(i == 2)
                        j -= mLoadedStarts;
                    else
                    if(i == 3)
                        j -= mUnpluggedStarts;
                    if(true) goto _L4; else goto _L3
_L3:
                }

                public void plug(long l, long l1) {
                }

                void readFromParcelLocked(Parcel parcel) {
                    boolean flag = true;
                    mStartTime = parcel.readLong();
                    mRunningSince = parcel.readLong();
                    boolean flag1;
                    if(parcel.readInt() != 0)
                        flag1 = flag;
                    else
                        flag1 = false;
                    mRunning = flag1;
                    mStarts = parcel.readInt();
                    mLaunchedTime = parcel.readLong();
                    mLaunchedSince = parcel.readLong();
                    if(parcel.readInt() == 0)
                        flag = false;
                    mLaunched = flag;
                    mLaunches = parcel.readInt();
                    mLoadedStartTime = parcel.readLong();
                    mLoadedStarts = parcel.readInt();
                    mLoadedLaunches = parcel.readInt();
                    mLastStartTime = 0L;
                    mLastStarts = 0;
                    mLastLaunches = 0;
                    mUnpluggedStartTime = parcel.readLong();
                    mUnpluggedStarts = parcel.readInt();
                    mUnpluggedLaunches = parcel.readInt();
                }

                public void startLaunchedLocked() {
                    if(!mLaunched) {
                        mLaunches = 1 + mLaunches;
                        mLaunchedSince = getBatteryUptimeLocked();
                        mLaunched = true;
                    }
                }

                public void startRunningLocked() {
                    if(!mRunning) {
                        mStarts = 1 + mStarts;
                        mRunningSince = getBatteryUptimeLocked();
                        mRunning = true;
                    }
                }

                public void stopLaunchedLocked() {
                    if(mLaunched) {
                        long l = getBatteryUptimeLocked() - mLaunchedSince;
                        if(l > 0L)
                            mLaunchedTime = l + mLaunchedTime;
                        else
                            mLaunches = -1 + mLaunches;
                        mLaunched = false;
                    }
                }

                public void stopRunningLocked() {
                    if(mRunning) {
                        long l = getBatteryUptimeLocked() - mRunningSince;
                        if(l > 0L)
                            mStartTime = l + mStartTime;
                        else
                            mStarts = -1 + mStarts;
                        mRunning = false;
                    }
                }

                public void unplug(long l, long l1) {
                    mUnpluggedStartTime = getStartTimeToNowLocked(l);
                    mUnpluggedStarts = mStarts;
                    mUnpluggedLaunches = mLaunches;
                }

                void writeToParcelLocked(Parcel parcel) {
                    int i = 1;
                    parcel.writeLong(mStartTime);
                    parcel.writeLong(mRunningSince);
                    int j;
                    if(mRunning)
                        j = i;
                    else
                        j = 0;
                    parcel.writeInt(j);
                    parcel.writeInt(mStarts);
                    parcel.writeLong(mLaunchedTime);
                    parcel.writeLong(mLaunchedSince);
                    if(!mLaunched)
                        i = 0;
                    parcel.writeInt(i);
                    parcel.writeInt(mLaunches);
                    parcel.writeLong(mLoadedStartTime);
                    parcel.writeInt(mLoadedStarts);
                    parcel.writeInt(mLoadedLaunches);
                    parcel.writeLong(mUnpluggedStartTime);
                    parcel.writeInt(mUnpluggedStarts);
                    parcel.writeInt(mUnpluggedLaunches);
                }

                int mLastLaunches;
                long mLastStartTime;
                int mLastStarts;
                boolean mLaunched;
                long mLaunchedSince;
                long mLaunchedTime;
                int mLaunches;
                int mLoadedLaunches;
                long mLoadedStartTime;
                int mLoadedStarts;
                boolean mRunning;
                long mRunningSince;
                long mStartTime;
                int mStarts;
                int mUnpluggedLaunches;
                long mUnpluggedStartTime;
                int mUnpluggedStarts;
                final Pkg this$2;

                Serv() {
                    this$2 = Pkg.this;
                    super(Pkg.this);
                    mUnpluggables.add(this);
                }
            }


            void detach() {
                mUnpluggables.remove(this);
            }

            public BatteryStatsImpl getBatteryStats() {
                return _fld0;
            }

            public Map getServiceStats() {
                return mServiceStats;
            }

            public int getWakeups(int i) {
                if(i != 1) goto _L2; else goto _L1
_L1:
                int j = mLastWakeups;
_L4:
                return j;
_L2:
                j = mWakeups;
                if(i == 2)
                    j -= mLoadedWakeups;
                else
                if(i == 3)
                    j -= mUnpluggedWakeups;
                if(true) goto _L4; else goto _L3
_L3:
            }

            public void incWakeupsLocked() {
                mWakeups = 1 + mWakeups;
            }

            final Serv newServiceStatsLocked() {
                return new Serv();
            }

            public void plug(long l, long l1) {
            }

            void readFromParcelLocked(Parcel parcel) {
                mWakeups = parcel.readInt();
                mLoadedWakeups = parcel.readInt();
                mLastWakeups = 0;
                mUnpluggedWakeups = parcel.readInt();
                int i = parcel.readInt();
                mServiceStats.clear();
                for(int j = 0; j < i; j++) {
                    String s = parcel.readString();
                    Serv serv = new Serv();
                    mServiceStats.put(s, serv);
                    serv.readFromParcelLocked(parcel);
                }

            }

            public void unplug(long l, long l1) {
                mUnpluggedWakeups = mWakeups;
            }

            void writeToParcelLocked(Parcel parcel) {
                parcel.writeInt(mWakeups);
                parcel.writeInt(mLoadedWakeups);
                parcel.writeInt(mUnpluggedWakeups);
                parcel.writeInt(mServiceStats.size());
                java.util.Map.Entry entry;
                for(Iterator iterator = mServiceStats.entrySet().iterator(); iterator.hasNext(); ((Serv)entry.getValue()).writeToParcelLocked(parcel)) {
                    entry = (java.util.Map.Entry)iterator.next();
                    parcel.writeString((String)entry.getKey());
                }

            }

            int mLastWakeups;
            int mLoadedWakeups;
            final HashMap mServiceStats = new HashMap();
            int mUnpluggedWakeups;
            int mWakeups;
            final Uid this$1;

            Pkg() {
                this$1 = Uid.this;
                super();
                mUnpluggables.add(this);
            }
        }

        public final class Proc extends android.os.BatteryStats.Uid.Proc
            implements Unpluggable {

            public void addCpuTimeLocked(int i, int j) {
                mUserTime = mUserTime + (long)i;
                mSystemTime = mSystemTime + (long)j;
            }

            public void addExcessiveCpu(long l, long l1) {
                if(mExcessivePower == null)
                    mExcessivePower = new ArrayList();
                android.os.BatteryStats.Uid.Proc.ExcessivePower excessivepower = new android.os.BatteryStats.Uid.Proc.ExcessivePower();
                excessivepower.type = 2;
                excessivepower.overTime = l;
                excessivepower.usedTime = l1;
                mExcessivePower.add(excessivepower);
            }

            public void addExcessiveWake(long l, long l1) {
                if(mExcessivePower == null)
                    mExcessivePower = new ArrayList();
                android.os.BatteryStats.Uid.Proc.ExcessivePower excessivepower = new android.os.BatteryStats.Uid.Proc.ExcessivePower();
                excessivepower.type = 1;
                excessivepower.overTime = l;
                excessivepower.usedTime = l1;
                mExcessivePower.add(excessivepower);
            }

            public void addForegroundTimeLocked(long l) {
                mForegroundTime = l + mForegroundTime;
            }

            public void addSpeedStepTimes(long al[]) {
                for(int i = 0; i < mSpeedBins.length && i < al.length; i++) {
                    if(al[i] == 0L)
                        continue;
                    SamplingCounter samplingcounter = mSpeedBins[i];
                    if(samplingcounter == null) {
                        SamplingCounter asamplingcounter[] = mSpeedBins;
                        samplingcounter = new SamplingCounter(mUnpluggables);
                        asamplingcounter[i] = samplingcounter;
                    }
                    samplingcounter.addCountAtomic(al[i]);
                }

            }

            public int countExcessivePowers() {
                int i;
                if(mExcessivePower != null)
                    i = mExcessivePower.size();
                else
                    i = 0;
                return i;
            }

            void detach() {
                mUnpluggables.remove(this);
                for(int i = 0; i < mSpeedBins.length; i++) {
                    SamplingCounter samplingcounter = mSpeedBins[i];
                    if(samplingcounter != null) {
                        mUnpluggables.remove(samplingcounter);
                        mSpeedBins[i] = null;
                    }
                }

            }

            public BatteryStatsImpl getBatteryStats() {
                return _fld0;
            }

            public android.os.BatteryStats.Uid.Proc.ExcessivePower getExcessivePower(int i) {
                android.os.BatteryStats.Uid.Proc.ExcessivePower excessivepower;
                if(mExcessivePower != null)
                    excessivepower = (android.os.BatteryStats.Uid.Proc.ExcessivePower)mExcessivePower.get(i);
                else
                    excessivepower = null;
                return excessivepower;
            }

            public long getForegroundTime(int i) {
                if(i != 1) goto _L2; else goto _L1
_L1:
                long l = mLastForegroundTime;
_L4:
                return l;
_L2:
                l = mForegroundTime;
                if(i == 2)
                    l -= mLoadedForegroundTime;
                else
                if(i == 3)
                    l -= mUnpluggedForegroundTime;
                if(true) goto _L4; else goto _L3
_L3:
            }

            public int getStarts(int i) {
                if(i != 1) goto _L2; else goto _L1
_L1:
                int j = mLastStarts;
_L4:
                return j;
_L2:
                j = mStarts;
                if(i == 2)
                    j -= mLoadedStarts;
                else
                if(i == 3)
                    j -= mUnpluggedStarts;
                if(true) goto _L4; else goto _L3
_L3:
            }

            public long getSystemTime(int i) {
                if(i != 1) goto _L2; else goto _L1
_L1:
                long l = mLastSystemTime;
_L4:
                return l;
_L2:
                l = mSystemTime;
                if(i == 2)
                    l -= mLoadedSystemTime;
                else
                if(i == 3)
                    l -= mUnpluggedSystemTime;
                if(true) goto _L4; else goto _L3
_L3:
            }

            public long getTimeAtCpuSpeedStep(int i, int j) {
                long l = 0L;
                if(i < mSpeedBins.length) {
                    SamplingCounter samplingcounter = mSpeedBins[i];
                    if(samplingcounter != null)
                        l = samplingcounter.getCountLocked(j);
                }
                return l;
            }

            public long getUserTime(int i) {
                if(i != 1) goto _L2; else goto _L1
_L1:
                long l = mLastUserTime;
_L4:
                return l;
_L2:
                l = mUserTime;
                if(i == 2)
                    l -= mLoadedUserTime;
                else
                if(i == 3)
                    l -= mUnpluggedUserTime;
                if(true) goto _L4; else goto _L3
_L3:
            }

            public void incStartsLocked() {
                mStarts = 1 + mStarts;
            }

            public void plug(long l, long l1) {
            }

            boolean readExcessivePowerFromParcelLocked(Parcel parcel) {
                boolean flag;
                int i;
                flag = true;
                i = parcel.readInt();
                if(i != 0) goto _L2; else goto _L1
_L1:
                mExcessivePower = null;
_L4:
                return flag;
_L2:
                if(i <= 10000)
                    break; /* Loop/switch isn't completed */
                Slog.w("BatteryStatsImpl", (new StringBuilder()).append("File corrupt: too many excessive power entries ").append(i).toString());
                flag = false;
                if(true) goto _L4; else goto _L3
_L3:
                mExcessivePower = new ArrayList();
                int j = 0;
                while(j < i)  {
                    android.os.BatteryStats.Uid.Proc.ExcessivePower excessivepower = new android.os.BatteryStats.Uid.Proc.ExcessivePower();
                    excessivepower.type = parcel.readInt();
                    excessivepower.overTime = parcel.readLong();
                    excessivepower.usedTime = parcel.readLong();
                    mExcessivePower.add(excessivepower);
                    j++;
                }
                if(true) goto _L4; else goto _L5
_L5:
            }

            void readFromParcelLocked(Parcel parcel) {
                mUserTime = parcel.readLong();
                mSystemTime = parcel.readLong();
                mForegroundTime = parcel.readLong();
                mStarts = parcel.readInt();
                mLoadedUserTime = parcel.readLong();
                mLoadedSystemTime = parcel.readLong();
                mLoadedForegroundTime = parcel.readLong();
                mLoadedStarts = parcel.readInt();
                mLastUserTime = 0L;
                mLastSystemTime = 0L;
                mLastForegroundTime = 0L;
                mLastStarts = 0;
                mUnpluggedUserTime = parcel.readLong();
                mUnpluggedSystemTime = parcel.readLong();
                mUnpluggedForegroundTime = parcel.readLong();
                mUnpluggedStarts = parcel.readInt();
                int i = parcel.readInt();
                int j = getCpuSpeedSteps();
                if(i >= j)
                    j = i;
                mSpeedBins = new SamplingCounter[j];
                for(int k = 0; k < i; k++)
                    if(parcel.readInt() != 0)
                        mSpeedBins[k] = new SamplingCounter(mUnpluggables, parcel);

                readExcessivePowerFromParcelLocked(parcel);
            }

            public void unplug(long l, long l1) {
                mUnpluggedUserTime = mUserTime;
                mUnpluggedSystemTime = mSystemTime;
                mUnpluggedStarts = mStarts;
                mUnpluggedForegroundTime = mForegroundTime;
            }

            void writeExcessivePowerToParcelLocked(Parcel parcel) {
                if(mExcessivePower == null) {
                    parcel.writeInt(0);
                } else {
                    int i = mExcessivePower.size();
                    parcel.writeInt(i);
                    int j = 0;
                    while(j < i)  {
                        android.os.BatteryStats.Uid.Proc.ExcessivePower excessivepower = (android.os.BatteryStats.Uid.Proc.ExcessivePower)mExcessivePower.get(j);
                        parcel.writeInt(excessivepower.type);
                        parcel.writeLong(excessivepower.overTime);
                        parcel.writeLong(excessivepower.usedTime);
                        j++;
                    }
                }
            }

            void writeToParcelLocked(Parcel parcel) {
                parcel.writeLong(mUserTime);
                parcel.writeLong(mSystemTime);
                parcel.writeLong(mForegroundTime);
                parcel.writeInt(mStarts);
                parcel.writeLong(mLoadedUserTime);
                parcel.writeLong(mLoadedSystemTime);
                parcel.writeLong(mLoadedForegroundTime);
                parcel.writeInt(mLoadedStarts);
                parcel.writeLong(mUnpluggedUserTime);
                parcel.writeLong(mUnpluggedSystemTime);
                parcel.writeLong(mUnpluggedForegroundTime);
                parcel.writeInt(mUnpluggedStarts);
                parcel.writeInt(mSpeedBins.length);
                int i = 0;
                while(i < mSpeedBins.length)  {
                    SamplingCounter samplingcounter = mSpeedBins[i];
                    if(samplingcounter != null) {
                        parcel.writeInt(1);
                        samplingcounter.writeToParcel(parcel);
                    } else {
                        parcel.writeInt(0);
                    }
                    i++;
                }
                writeExcessivePowerToParcelLocked(parcel);
            }

            ArrayList mExcessivePower;
            long mForegroundTime;
            long mLastForegroundTime;
            int mLastStarts;
            long mLastSystemTime;
            long mLastUserTime;
            long mLoadedForegroundTime;
            int mLoadedStarts;
            long mLoadedSystemTime;
            long mLoadedUserTime;
            SamplingCounter mSpeedBins[];
            int mStarts;
            long mSystemTime;
            long mUnpluggedForegroundTime;
            int mUnpluggedStarts;
            long mUnpluggedSystemTime;
            long mUnpluggedUserTime;
            long mUserTime;
            final Uid this$1;

            Proc() {
                this$1 = Uid.this;
                super();
                mUnpluggables.add(this);
                mSpeedBins = new SamplingCounter[getCpuSpeedSteps()];
            }
        }

        public final class Sensor extends android.os.BatteryStats.Uid.Sensor {

            private StopwatchTimer readTimerFromParcel(ArrayList arraylist, Parcel parcel) {
                StopwatchTimer stopwatchtimer;
                if(parcel.readInt() == 0) {
                    stopwatchtimer = null;
                } else {
                    ArrayList arraylist1 = (ArrayList)mSensorTimers.get(mHandle);
                    if(arraylist1 == null) {
                        arraylist1 = new ArrayList();
                        mSensorTimers.put(mHandle, arraylist1);
                    }
                    stopwatchtimer = new StopwatchTimer(Uid.this, 0, arraylist1, arraylist, parcel);
                }
                return stopwatchtimer;
            }

            public int getHandle() {
                return mHandle;
            }

            public volatile android.os.BatteryStats.Timer getSensorTime() {
                return getSensorTime();
            }

            public Timer getSensorTime() {
                return mTimer;
            }

            void readFromParcelLocked(ArrayList arraylist, Parcel parcel) {
                mTimer = readTimerFromParcel(arraylist, parcel);
            }

            boolean reset() {
                boolean flag = true;
                if(mTimer.reset(_fld0, flag))
                    mTimer = null;
                else
                    flag = false;
                return flag;
            }

            void writeToParcelLocked(Parcel parcel, long l) {
                Timer.writeTimerToParcel(parcel, mTimer, l);
            }

            final int mHandle;
            StopwatchTimer mTimer;
            final Uid this$1;

            public Sensor(int i) {
                this$1 = Uid.this;
                super();
                mHandle = i;
            }
        }

        public final class Wakelock extends android.os.BatteryStats.Uid.Wakelock {

            private StopwatchTimer readTimerFromParcel(int i, ArrayList arraylist, ArrayList arraylist1, Parcel parcel) {
                StopwatchTimer stopwatchtimer;
                if(parcel.readInt() == 0)
                    stopwatchtimer = null;
                else
                    stopwatchtimer = new StopwatchTimer(Uid.this, i, arraylist, arraylist1, parcel);
                return stopwatchtimer;
            }

            public volatile android.os.BatteryStats.Timer getWakeTime(int i) {
                return getWakeTime(i);
            }

            public Timer getWakeTime(int i) {
                i;
                JVM INSTR tableswitch 0 2: default 28
            //                           0 62
            //                           1 55
            //                           2 70;
                   goto _L1 _L2 _L3 _L4
_L1:
                throw new IllegalArgumentException((new StringBuilder()).append("type = ").append(i).toString());
_L3:
                StopwatchTimer stopwatchtimer = mTimerFull;
_L6:
                return stopwatchtimer;
_L2:
                stopwatchtimer = mTimerPartial;
                continue; /* Loop/switch isn't completed */
_L4:
                stopwatchtimer = mTimerWindow;
                if(true) goto _L6; else goto _L5
_L5:
            }

            void readFromParcelLocked(ArrayList arraylist, Parcel parcel) {
                mTimerPartial = readTimerFromParcel(0, mPartialTimers, arraylist, parcel);
                mTimerFull = readTimerFromParcel(1, mFullTimers, arraylist, parcel);
                mTimerWindow = readTimerFromParcel(2, mWindowTimers, arraylist, parcel);
            }

            boolean reset() {
                boolean flag = true;
                boolean flag1 = false;
                if(mTimerFull != null) {
                    boolean flag4;
                    if(!mTimerFull.reset(_fld0, false))
                        flag4 = flag;
                    else
                        flag4 = false;
                    flag1 = false | flag4;
                }
                if(mTimerPartial != null) {
                    boolean flag3;
                    if(!mTimerPartial.reset(_fld0, false))
                        flag3 = flag;
                    else
                        flag3 = false;
                    flag1 |= flag3;
                }
                if(mTimerWindow != null) {
                    boolean flag2;
                    if(!mTimerWindow.reset(_fld0, false))
                        flag2 = flag;
                    else
                        flag2 = false;
                    flag1 |= flag2;
                }
                if(!flag1) {
                    if(mTimerFull != null) {
                        mTimerFull.detach();
                        mTimerFull = null;
                    }
                    if(mTimerPartial != null) {
                        mTimerPartial.detach();
                        mTimerPartial = null;
                    }
                    if(mTimerWindow != null) {
                        mTimerWindow.detach();
                        mTimerWindow = null;
                    }
                }
                if(flag1)
                    flag = false;
                return flag;
            }

            void writeToParcelLocked(Parcel parcel, long l) {
                Timer.writeTimerToParcel(parcel, mTimerPartial, l);
                Timer.writeTimerToParcel(parcel, mTimerFull, l);
                Timer.writeTimerToParcel(parcel, mTimerWindow, l);
            }

            StopwatchTimer mTimerFull;
            StopwatchTimer mTimerPartial;
            StopwatchTimer mTimerWindow;
            final Uid this$1;

            public Wakelock() {
                this$1 = Uid.this;
                super();
            }
        }


        public long computeCurrentTcpBytesReceived() {
            long l = 0L;
            long l1 = getNetworkStatsDetailGroupedByUid().getTotal(null, mUid).rxBytes;
            long l2 = mCurrentTcpBytesReceived;
            if(mStartedTcpBytesReceived >= l)
                l = l1 - mStartedTcpBytesReceived;
            return l + l2;
        }

        public long computeCurrentTcpBytesSent() {
            long l = 0L;
            long l1 = getNetworkStatsDetailGroupedByUid().getTotal(null, mUid).txBytes;
            long l2 = mCurrentTcpBytesSent;
            if(mStartedTcpBytesSent >= l)
                l = l1 - mStartedTcpBytesSent;
            return l + l2;
        }

        public long getAudioTurnedOnTime(long l, int i) {
            long l1;
            if(mAudioTurnedOnTimer == null)
                l1 = 0L;
            else
                l1 = mAudioTurnedOnTimer.getTotalTimeLocked(l, i);
            return l1;
        }

        public BatteryStatsImpl getBatteryStats() {
            return BatteryStatsImpl.this;
        }

        public long getFullWifiLockTime(long l, int i) {
            long l1;
            if(mFullWifiLockTimer == null)
                l1 = 0L;
            else
                l1 = mFullWifiLockTimer.getTotalTimeLocked(l, i);
            return l1;
        }

        public Map getPackageStats() {
            return mPackageStats;
        }

        public Pkg getPackageStatsLocked(String s) {
            Pkg pkg = (Pkg)mPackageStats.get(s);
            if(pkg == null) {
                pkg = new Pkg();
                mPackageStats.put(s, pkg);
            }
            return pkg;
        }

        public SparseArray getPidStats() {
            return mPids;
        }

        public android.os.BatteryStats.Uid.Pid getPidStatsLocked(int i) {
            android.os.BatteryStats.Uid.Pid pid = (android.os.BatteryStats.Uid.Pid)mPids.get(i);
            if(pid == null) {
                pid = new android.os.BatteryStats.Uid.Pid(this);
                mPids.put(i, pid);
            }
            return pid;
        }

        public Map getProcessStats() {
            return mProcessStats;
        }

        public Proc getProcessStatsLocked(String s) {
            Proc proc = (Proc)mProcessStats.get(s);
            if(proc == null) {
                proc = new Proc();
                mProcessStats.put(s, proc);
            }
            return proc;
        }

        public long getScanWifiLockTime(long l, int i) {
            long l1;
            if(mScanWifiLockTimer == null)
                l1 = 0L;
            else
                l1 = mScanWifiLockTimer.getTotalTimeLocked(l, i);
            return l1;
        }

        public Map getSensorStats() {
            return mSensorStats;
        }

        public StopwatchTimer getSensorTimerLocked(int i, boolean flag) {
            Sensor sensor = (Sensor)mSensorStats.get(Integer.valueOf(i));
            if(sensor != null) goto _L2; else goto _L1
_L1:
            if(flag) goto _L4; else goto _L3
_L3:
            StopwatchTimer stopwatchtimer = null;
_L6:
            return stopwatchtimer;
_L4:
            sensor = new Sensor(i);
            mSensorStats.put(Integer.valueOf(i), sensor);
_L2:
            stopwatchtimer = sensor.mTimer;
            if(stopwatchtimer == null) {
                ArrayList arraylist = (ArrayList)mSensorTimers.get(i);
                if(arraylist == null) {
                    arraylist = new ArrayList();
                    mSensorTimers.put(i, arraylist);
                }
                stopwatchtimer = new StopwatchTimer(this, 3, arraylist, mUnpluggables);
                sensor.mTimer = stopwatchtimer;
            }
            if(true) goto _L6; else goto _L5
_L5:
        }

        public Pkg.Serv getServiceStatsLocked(String s, String s1) {
            Pkg pkg = getPackageStatsLocked(s);
            Pkg.Serv serv = (Pkg.Serv)pkg.mServiceStats.get(s1);
            if(serv == null) {
                serv = pkg.newServiceStatsLocked();
                pkg.mServiceStats.put(s1, serv);
            }
            return serv;
        }

        public long getTcpBytesReceived(int i) {
            if(i != 1) goto _L2; else goto _L1
_L1:
            long l = mLoadedTcpBytesReceived;
_L4:
            return l;
_L2:
            l = computeCurrentTcpBytesReceived();
            if(i == 3)
                l -= mTcpBytesReceivedAtLastUnplug;
            else
            if(i == 0)
                l += mLoadedTcpBytesReceived;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public long getTcpBytesSent(int i) {
            if(i != 1) goto _L2; else goto _L1
_L1:
            long l = mLoadedTcpBytesSent;
_L4:
            return l;
_L2:
            l = computeCurrentTcpBytesSent();
            if(i == 3)
                l -= mTcpBytesSentAtLastUnplug;
            else
            if(i == 0)
                l += mLoadedTcpBytesSent;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public int getUid() {
            return mUid;
        }

        public int getUserActivityCount(int i, int j) {
            int k;
            if(mUserActivityCounters == null)
                k = 0;
            else
                k = mUserActivityCounters[i].getCountLocked(j);
            return k;
        }

        public long getVideoTurnedOnTime(long l, int i) {
            long l1;
            if(mVideoTurnedOnTimer == null)
                l1 = 0L;
            else
                l1 = mVideoTurnedOnTimer.getTotalTimeLocked(l, i);
            return l1;
        }

        public StopwatchTimer getWakeTimerLocked(String s, int i) {
            Wakelock wakelock;
            wakelock = (Wakelock)mWakelockStats.get(s);
            if(wakelock == null) {
                int j = mWakelockStats.size();
                if(j > 30 && (mUid != 1000 || j > 50)) {
                    s = "*overflow*";
                    wakelock = (Wakelock)mWakelockStats.get(s);
                }
                if(wakelock == null) {
                    wakelock = new Wakelock();
                    mWakelockStats.put(s, wakelock);
                }
            }
            i;
            JVM INSTR tableswitch 0 2: default 116
        //                       0 144
        //                       1 193
        //                       2 242;
               goto _L1 _L2 _L3 _L4
_L1:
            throw new IllegalArgumentException((new StringBuilder()).append("type=").append(i).toString());
_L2:
            StopwatchTimer stopwatchtimer1;
            StopwatchTimer stopwatchtimer3 = wakelock.mTimerPartial;
            if(stopwatchtimer3 == null) {
                stopwatchtimer3 = new StopwatchTimer(this, 0, mPartialTimers, mUnpluggables);
                wakelock.mTimerPartial = stopwatchtimer3;
            }
            stopwatchtimer1 = stopwatchtimer3;
_L6:
            return stopwatchtimer1;
_L3:
            StopwatchTimer stopwatchtimer2 = wakelock.mTimerFull;
            if(stopwatchtimer2 == null) {
                stopwatchtimer2 = new StopwatchTimer(this, 1, mFullTimers, mUnpluggables);
                wakelock.mTimerFull = stopwatchtimer2;
            }
            stopwatchtimer1 = stopwatchtimer2;
            continue; /* Loop/switch isn't completed */
_L4:
            StopwatchTimer stopwatchtimer = wakelock.mTimerWindow;
            if(stopwatchtimer == null) {
                stopwatchtimer = new StopwatchTimer(this, 2, mWindowTimers, mUnpluggables);
                wakelock.mTimerWindow = stopwatchtimer;
            }
            stopwatchtimer1 = stopwatchtimer;
            if(true) goto _L6; else goto _L5
_L5:
        }

        public Map getWakelockStats() {
            return mWakelockStats;
        }

        public long getWifiMulticastTime(long l, int i) {
            long l1;
            if(mWifiMulticastTimer == null)
                l1 = 0L;
            else
                l1 = mWifiMulticastTimer.getTotalTimeLocked(l, i);
            return l1;
        }

        public long getWifiRunningTime(long l, int i) {
            long l1;
            if(mWifiRunningTimer == null)
                l1 = 0L;
            else
                l1 = mWifiRunningTimer.getTotalTimeLocked(l, i);
            return l1;
        }

        public boolean hasUserActivity() {
            boolean flag;
            if(mUserActivityCounters != null)
                flag = true;
            else
                flag = false;
            return flag;
        }

        void initUserActivityLocked() {
            mUserActivityCounters = new Counter[7];
            for(int i = 0; i < 7; i++)
                mUserActivityCounters[i] = new Counter(mUnpluggables);

        }

        public void noteAudioTurnedOffLocked() {
            if(mAudioTurnedOn) {
                mAudioTurnedOn = false;
                mAudioTurnedOnTimer.stopRunningLocked(BatteryStatsImpl.this);
            }
        }

        public void noteAudioTurnedOnLocked() {
            if(!mAudioTurnedOn) {
                mAudioTurnedOn = true;
                if(mAudioTurnedOnTimer == null)
                    mAudioTurnedOnTimer = new StopwatchTimer(this, 7, null, mUnpluggables);
                mAudioTurnedOnTimer.startRunningLocked(BatteryStatsImpl.this);
            }
        }

        public void noteFullWifiLockAcquiredLocked() {
            if(!mFullWifiLockOut) {
                mFullWifiLockOut = true;
                if(mFullWifiLockTimer == null)
                    mFullWifiLockTimer = new StopwatchTimer(this, 5, mFullWifiLockTimers, mUnpluggables);
                mFullWifiLockTimer.startRunningLocked(BatteryStatsImpl.this);
            }
        }

        public void noteFullWifiLockReleasedLocked() {
            if(mFullWifiLockOut) {
                mFullWifiLockOut = false;
                mFullWifiLockTimer.stopRunningLocked(BatteryStatsImpl.this);
            }
        }

        public void noteScanWifiLockAcquiredLocked() {
            if(!mScanWifiLockOut) {
                mScanWifiLockOut = true;
                if(mScanWifiLockTimer == null)
                    mScanWifiLockTimer = new StopwatchTimer(this, 6, mScanWifiLockTimers, mUnpluggables);
                mScanWifiLockTimer.startRunningLocked(BatteryStatsImpl.this);
            }
        }

        public void noteScanWifiLockReleasedLocked() {
            if(mScanWifiLockOut) {
                mScanWifiLockOut = false;
                mScanWifiLockTimer.stopRunningLocked(BatteryStatsImpl.this);
            }
        }

        public void noteStartGps() {
            StopwatchTimer stopwatchtimer = getSensorTimerLocked(-10000, true);
            if(stopwatchtimer != null)
                stopwatchtimer.startRunningLocked(BatteryStatsImpl.this);
        }

        public void noteStartSensor(int i) {
            StopwatchTimer stopwatchtimer = getSensorTimerLocked(i, true);
            if(stopwatchtimer != null)
                stopwatchtimer.startRunningLocked(BatteryStatsImpl.this);
        }

        public void noteStartWakeLocked(int i, String s, int j) {
            StopwatchTimer stopwatchtimer = getWakeTimerLocked(s, j);
            if(stopwatchtimer != null)
                stopwatchtimer.startRunningLocked(BatteryStatsImpl.this);
            if(i >= 0 && j == 0) {
                android.os.BatteryStats.Uid.Pid pid = getPidStatsLocked(i);
                if(pid.mWakeStart == 0L)
                    pid.mWakeStart = SystemClock.elapsedRealtime();
            }
        }

        public void noteStopGps() {
            StopwatchTimer stopwatchtimer = getSensorTimerLocked(-10000, false);
            if(stopwatchtimer != null)
                stopwatchtimer.stopRunningLocked(BatteryStatsImpl.this);
        }

        public void noteStopSensor(int i) {
            StopwatchTimer stopwatchtimer = getSensorTimerLocked(i, false);
            if(stopwatchtimer != null)
                stopwatchtimer.stopRunningLocked(BatteryStatsImpl.this);
        }

        public void noteStopWakeLocked(int i, String s, int j) {
            StopwatchTimer stopwatchtimer = getWakeTimerLocked(s, j);
            if(stopwatchtimer != null)
                stopwatchtimer.stopRunningLocked(BatteryStatsImpl.this);
            if(i >= 0 && j == 0) {
                android.os.BatteryStats.Uid.Pid pid = (android.os.BatteryStats.Uid.Pid)mPids.get(i);
                if(pid != null && pid.mWakeStart != 0L) {
                    pid.mWakeSum = pid.mWakeSum + (SystemClock.elapsedRealtime() - pid.mWakeStart);
                    pid.mWakeStart = 0L;
                }
            }
        }

        public void noteUserActivityLocked(int i) {
            if(mUserActivityCounters == null)
                initUserActivityLocked();
            if(i >= 0) goto _L2; else goto _L1
_L1:
            i = 0;
_L4:
            mUserActivityCounters[i].stepAtomic();
            return;
_L2:
            if(i >= 7)
                i = 6;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void noteVideoTurnedOffLocked() {
            if(mVideoTurnedOn) {
                mVideoTurnedOn = false;
                mVideoTurnedOnTimer.stopRunningLocked(BatteryStatsImpl.this);
            }
        }

        public void noteVideoTurnedOnLocked() {
            if(!mVideoTurnedOn) {
                mVideoTurnedOn = true;
                if(mVideoTurnedOnTimer == null)
                    mVideoTurnedOnTimer = new StopwatchTimer(this, 8, null, mUnpluggables);
                mVideoTurnedOnTimer.startRunningLocked(BatteryStatsImpl.this);
            }
        }

        public void noteWifiMulticastDisabledLocked() {
            if(mWifiMulticastEnabled) {
                mWifiMulticastEnabled = false;
                mWifiMulticastTimer.stopRunningLocked(BatteryStatsImpl.this);
            }
        }

        public void noteWifiMulticastEnabledLocked() {
            if(!mWifiMulticastEnabled) {
                mWifiMulticastEnabled = true;
                if(mWifiMulticastTimer == null)
                    mWifiMulticastTimer = new StopwatchTimer(this, 7, mWifiMulticastTimers, mUnpluggables);
                mWifiMulticastTimer.startRunningLocked(BatteryStatsImpl.this);
            }
        }

        public void noteWifiRunningLocked() {
            if(!mWifiRunning) {
                mWifiRunning = true;
                if(mWifiRunningTimer == null)
                    mWifiRunningTimer = new StopwatchTimer(this, 4, mWifiRunningTimers, mUnpluggables);
                mWifiRunningTimer.startRunningLocked(BatteryStatsImpl.this);
            }
        }

        public void noteWifiStoppedLocked() {
            if(mWifiRunning) {
                mWifiRunning = false;
                mWifiRunningTimer.stopRunningLocked(BatteryStatsImpl.this);
            }
        }

        void readFromParcelLocked(ArrayList arraylist, Parcel parcel) {
            int i = parcel.readInt();
            mWakelockStats.clear();
            for(int j = 0; j < i; j++) {
                String s2 = parcel.readString();
                Wakelock wakelock = new Wakelock();
                wakelock.readFromParcelLocked(arraylist, parcel);
                mWakelockStats.put(s2, wakelock);
            }

            int k = parcel.readInt();
            mSensorStats.clear();
            for(int l = 0; l < k; l++) {
                int j2 = parcel.readInt();
                Sensor sensor = new Sensor(j2);
                sensor.readFromParcelLocked(mUnpluggables, parcel);
                mSensorStats.put(Integer.valueOf(j2), sensor);
            }

            int i1 = parcel.readInt();
            mProcessStats.clear();
            for(int j1 = 0; j1 < i1; j1++) {
                String s1 = parcel.readString();
                Proc proc = new Proc();
                proc.readFromParcelLocked(parcel);
                mProcessStats.put(s1, proc);
            }

            int k1 = parcel.readInt();
            mPackageStats.clear();
            for(int l1 = 0; l1 < k1; l1++) {
                String s = parcel.readString();
                Pkg pkg = new Pkg();
                pkg.readFromParcelLocked(parcel);
                mPackageStats.put(s, pkg);
            }

            mLoadedTcpBytesReceived = parcel.readLong();
            mLoadedTcpBytesSent = parcel.readLong();
            mCurrentTcpBytesReceived = parcel.readLong();
            mCurrentTcpBytesSent = parcel.readLong();
            mTcpBytesReceivedAtLastUnplug = parcel.readLong();
            mTcpBytesSentAtLastUnplug = parcel.readLong();
            mWifiRunning = false;
            if(parcel.readInt() != 0)
                mWifiRunningTimer = new StopwatchTimer(this, 4, mWifiRunningTimers, mUnpluggables, parcel);
            else
                mWifiRunningTimer = null;
            mFullWifiLockOut = false;
            if(parcel.readInt() != 0)
                mFullWifiLockTimer = new StopwatchTimer(this, 5, mFullWifiLockTimers, mUnpluggables, parcel);
            else
                mFullWifiLockTimer = null;
            mScanWifiLockOut = false;
            if(parcel.readInt() != 0)
                mScanWifiLockTimer = new StopwatchTimer(this, 6, mScanWifiLockTimers, mUnpluggables, parcel);
            else
                mScanWifiLockTimer = null;
            mWifiMulticastEnabled = false;
            if(parcel.readInt() != 0)
                mWifiMulticastTimer = new StopwatchTimer(this, 7, mWifiMulticastTimers, mUnpluggables, parcel);
            else
                mWifiMulticastTimer = null;
            mAudioTurnedOn = false;
            if(parcel.readInt() != 0)
                mAudioTurnedOnTimer = new StopwatchTimer(this, 7, null, mUnpluggables, parcel);
            else
                mAudioTurnedOnTimer = null;
            mVideoTurnedOn = false;
            if(parcel.readInt() != 0)
                mVideoTurnedOnTimer = new StopwatchTimer(this, 8, null, mUnpluggables, parcel);
            else
                mVideoTurnedOnTimer = null;
            if(parcel.readInt() != 0) {
                mUserActivityCounters = new Counter[7];
                for(int i2 = 0; i2 < 7; i2++)
                    mUserActivityCounters[i2] = new Counter(mUnpluggables, parcel);

            } else {
                mUserActivityCounters = null;
            }
        }

        public void reportExcessiveCpuLocked(String s, long l, long l1) {
            Proc proc = getProcessStatsLocked(s);
            if(proc != null)
                proc.addExcessiveCpu(l, l1);
        }

        public void reportExcessiveWakeLocked(String s, long l, long l1) {
            Proc proc = getProcessStatsLocked(s);
            if(proc != null)
                proc.addExcessiveWake(l, l1);
        }

        boolean reset() {
            boolean flag = false;
            if(mWifiRunningTimer != null) {
                int k;
                boolean flag7;
                if(!mWifiRunningTimer.reset(BatteryStatsImpl.this, false))
                    flag7 = true;
                else
                    flag7 = false;
                flag = false | flag7 | mWifiRunning;
            }
            if(mFullWifiLockTimer != null) {
                boolean flag6;
                if(!mFullWifiLockTimer.reset(BatteryStatsImpl.this, false))
                    flag6 = true;
                else
                    flag6 = false;
                flag = flag | flag6 | mFullWifiLockOut;
            }
            if(mScanWifiLockTimer != null) {
                boolean flag5;
                if(!mScanWifiLockTimer.reset(BatteryStatsImpl.this, false))
                    flag5 = true;
                else
                    flag5 = false;
                flag = flag | flag5 | mScanWifiLockOut;
            }
            if(mWifiMulticastTimer != null) {
                boolean flag4;
                if(!mWifiMulticastTimer.reset(BatteryStatsImpl.this, false))
                    flag4 = true;
                else
                    flag4 = false;
                flag = flag | flag4 | mWifiMulticastEnabled;
            }
            if(mAudioTurnedOnTimer != null) {
                boolean flag3;
                if(!mAudioTurnedOnTimer.reset(BatteryStatsImpl.this, false))
                    flag3 = true;
                else
                    flag3 = false;
                flag = flag | flag3 | mAudioTurnedOn;
            }
            if(mVideoTurnedOnTimer != null) {
                boolean flag2;
                if(!mVideoTurnedOnTimer.reset(BatteryStatsImpl.this, false))
                    flag2 = true;
                else
                    flag2 = false;
                flag = flag | flag2 | mVideoTurnedOn;
            }
            mLoadedTcpBytesSent = 0L;
            mLoadedTcpBytesReceived = 0L;
            mCurrentTcpBytesSent = 0L;
            mCurrentTcpBytesReceived = 0L;
            if(mUserActivityCounters != null)
                for(k = 0; k < 7; k++)
                    mUserActivityCounters[k].reset(false);

            if(mWakelockStats.size() > 0) {
                for(Iterator iterator4 = mWakelockStats.entrySet().iterator(); iterator4.hasNext();)
                    if(((Wakelock)((java.util.Map.Entry)iterator4.next()).getValue()).reset())
                        iterator4.remove();
                    else
                        flag = true;

            }
            if(mSensorStats.size() > 0) {
                for(Iterator iterator3 = mSensorStats.entrySet().iterator(); iterator3.hasNext();)
                    if(((Sensor)((java.util.Map.Entry)iterator3.next()).getValue()).reset())
                        iterator3.remove();
                    else
                        flag = true;

            }
            if(mProcessStats.size() > 0) {
                for(Iterator iterator2 = mProcessStats.entrySet().iterator(); iterator2.hasNext(); ((Proc)((java.util.Map.Entry)iterator2.next()).getValue()).detach());
                mProcessStats.clear();
            }
            if(mPids.size() > 0) {
                for(int j = 0; !flag && j < mPids.size(); j++)
                    if(((android.os.BatteryStats.Uid.Pid)mPids.valueAt(j)).mWakeStart != 0L)
                        flag = true;

            }
            if(mPackageStats.size() > 0) {
                Iterator iterator = mPackageStats.entrySet().iterator();
                do {
                    if(!iterator.hasNext())
                        break;
                    Pkg pkg = (Pkg)((java.util.Map.Entry)iterator.next()).getValue();
                    pkg.detach();
                    if(pkg.mServiceStats.size() > 0) {
                        Iterator iterator1 = pkg.mServiceStats.entrySet().iterator();
                        while(iterator1.hasNext()) 
                            ((Pkg.Serv)((java.util.Map.Entry)iterator1.next()).getValue()).detach();
                    }
                } while(true);
                mPackageStats.clear();
            }
            mPids.clear();
            if(!flag) {
                if(mWifiRunningTimer != null)
                    mWifiRunningTimer.detach();
                if(mFullWifiLockTimer != null)
                    mFullWifiLockTimer.detach();
                if(mScanWifiLockTimer != null)
                    mScanWifiLockTimer.detach();
                if(mWifiMulticastTimer != null)
                    mWifiMulticastTimer.detach();
                if(mAudioTurnedOnTimer != null)
                    mAudioTurnedOnTimer.detach();
                if(mVideoTurnedOnTimer != null)
                    mVideoTurnedOnTimer.detach();
                if(mUserActivityCounters != null) {
                    for(int i = 0; i < 7; i++)
                        mUserActivityCounters[i].detach();

                }
            }
            boolean flag1;
            if(!flag)
                flag1 = true;
            else
                flag1 = false;
            return flag1;
        }

        void writeToParcelLocked(Parcel parcel, long l) {
            parcel.writeInt(mWakelockStats.size());
            java.util.Map.Entry entry3;
            for(Iterator iterator = mWakelockStats.entrySet().iterator(); iterator.hasNext(); ((Wakelock)entry3.getValue()).writeToParcelLocked(parcel, l)) {
                entry3 = (java.util.Map.Entry)iterator.next();
                parcel.writeString((String)entry3.getKey());
            }

            parcel.writeInt(mSensorStats.size());
            java.util.Map.Entry entry2;
            for(Iterator iterator1 = mSensorStats.entrySet().iterator(); iterator1.hasNext(); ((Sensor)entry2.getValue()).writeToParcelLocked(parcel, l)) {
                entry2 = (java.util.Map.Entry)iterator1.next();
                parcel.writeInt(((Integer)entry2.getKey()).intValue());
            }

            parcel.writeInt(mProcessStats.size());
            java.util.Map.Entry entry1;
            for(Iterator iterator2 = mProcessStats.entrySet().iterator(); iterator2.hasNext(); ((Proc)entry1.getValue()).writeToParcelLocked(parcel)) {
                entry1 = (java.util.Map.Entry)iterator2.next();
                parcel.writeString((String)entry1.getKey());
            }

            parcel.writeInt(mPackageStats.size());
            java.util.Map.Entry entry;
            for(Iterator iterator3 = mPackageStats.entrySet().iterator(); iterator3.hasNext(); ((Pkg)entry.getValue()).writeToParcelLocked(parcel)) {
                entry = (java.util.Map.Entry)iterator3.next();
                parcel.writeString((String)entry.getKey());
            }

            parcel.writeLong(mLoadedTcpBytesReceived);
            parcel.writeLong(mLoadedTcpBytesSent);
            parcel.writeLong(computeCurrentTcpBytesReceived());
            parcel.writeLong(computeCurrentTcpBytesSent());
            parcel.writeLong(mTcpBytesReceivedAtLastUnplug);
            parcel.writeLong(mTcpBytesSentAtLastUnplug);
            if(mWifiRunningTimer != null) {
                parcel.writeInt(1);
                mWifiRunningTimer.writeToParcel(parcel, l);
            } else {
                parcel.writeInt(0);
            }
            if(mFullWifiLockTimer != null) {
                parcel.writeInt(1);
                mFullWifiLockTimer.writeToParcel(parcel, l);
            } else {
                parcel.writeInt(0);
            }
            if(mScanWifiLockTimer != null) {
                parcel.writeInt(1);
                mScanWifiLockTimer.writeToParcel(parcel, l);
            } else {
                parcel.writeInt(0);
            }
            if(mWifiMulticastTimer != null) {
                parcel.writeInt(1);
                mWifiMulticastTimer.writeToParcel(parcel, l);
            } else {
                parcel.writeInt(0);
            }
            if(mAudioTurnedOnTimer != null) {
                parcel.writeInt(1);
                mAudioTurnedOnTimer.writeToParcel(parcel, l);
            } else {
                parcel.writeInt(0);
            }
            if(mVideoTurnedOnTimer != null) {
                parcel.writeInt(1);
                mVideoTurnedOnTimer.writeToParcel(parcel, l);
            } else {
                parcel.writeInt(0);
            }
            if(mUserActivityCounters != null) {
                parcel.writeInt(1);
                for(int i = 0; i < 7; i++)
                    mUserActivityCounters[i].writeToParcel(parcel);

            } else {
                parcel.writeInt(0);
            }
        }

        boolean mAudioTurnedOn;
        StopwatchTimer mAudioTurnedOnTimer;
        long mCurrentTcpBytesReceived;
        long mCurrentTcpBytesSent;
        boolean mFullWifiLockOut;
        StopwatchTimer mFullWifiLockTimer;
        long mLoadedTcpBytesReceived;
        long mLoadedTcpBytesSent;
        final HashMap mPackageStats = new HashMap();
        final SparseArray mPids = new SparseArray();
        final HashMap mProcessStats = new HashMap();
        boolean mScanWifiLockOut;
        StopwatchTimer mScanWifiLockTimer;
        final HashMap mSensorStats = new HashMap();
        long mStartedTcpBytesReceived;
        long mStartedTcpBytesSent;
        long mTcpBytesReceivedAtLastUnplug;
        long mTcpBytesSentAtLastUnplug;
        final int mUid;
        Counter mUserActivityCounters[];
        boolean mVideoTurnedOn;
        StopwatchTimer mVideoTurnedOnTimer;
        final HashMap mWakelockStats = new HashMap();
        boolean mWifiMulticastEnabled;
        StopwatchTimer mWifiMulticastTimer;
        boolean mWifiRunning;
        StopwatchTimer mWifiRunningTimer;
        final BatteryStatsImpl this$0;

        public Uid(int i) {
            this$0 = BatteryStatsImpl.this;
            super();
            mStartedTcpBytesReceived = -1L;
            mStartedTcpBytesSent = -1L;
            mUid = i;
            mWifiRunningTimer = new StopwatchTimer(this, 4, mWifiRunningTimers, mUnpluggables);
            mFullWifiLockTimer = new StopwatchTimer(this, 5, mFullWifiLockTimers, mUnpluggables);
            mScanWifiLockTimer = new StopwatchTimer(this, 6, mScanWifiLockTimers, mUnpluggables);
            mWifiMulticastTimer = new StopwatchTimer(this, 7, mWifiMulticastTimers, mUnpluggables);
            mAudioTurnedOnTimer = new StopwatchTimer(this, 7, null, mUnpluggables);
            mVideoTurnedOnTimer = new StopwatchTimer(this, 8, null, mUnpluggables);
        }
    }

    private class KernelWakelockStats {

        public int mCount;
        public long mTotalTime;
        public int mVersion;
        final BatteryStatsImpl this$0;

        KernelWakelockStats(int i, long l, int j) {
            this$0 = BatteryStatsImpl.this;
            super();
            mCount = i;
            mTotalTime = l;
            mVersion = j;
        }
    }

    public static final class StopwatchTimer extends Timer {

        private static void refreshTimersLocked(BatteryStatsImpl batterystatsimpl, ArrayList arraylist) {
            long l = batterystatsimpl.getBatteryRealtimeLocked(1000L * SystemClock.elapsedRealtime());
            int i = arraylist.size();
            for(int j = i - 1; j >= 0; j--) {
                StopwatchTimer stopwatchtimer = (StopwatchTimer)arraylist.get(j);
                long l1 = l - stopwatchtimer.mUpdateTime;
                if(l1 > 0L)
                    stopwatchtimer.mTotalTime = ((Timer) (stopwatchtimer)).mTotalTime + l1 / (long)i;
                stopwatchtimer.mUpdateTime = l;
            }

        }

        protected int computeCurrentCountLocked() {
            return super.mCount;
        }

        protected long computeRunTimeLocked(long l) {
            long l1 = 0L;
            if(mTimeout > l1 && l > mUpdateTime + mTimeout)
                l = mUpdateTime + mTimeout;
            long l2 = super.mTotalTime;
            if(mNesting > 0) {
                long l3 = l - mUpdateTime;
                int i;
                if(mTimerPool != null)
                    i = mTimerPool.size();
                else
                    i = 1;
                l1 = l3 / (long)i;
            }
            return l1 + l2;
        }

        void detach() {
            super.detach();
            if(mTimerPool != null)
                mTimerPool.remove(this);
        }

        boolean isRunningLocked() {
            boolean flag;
            if(mNesting > 0)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void logState(Printer printer, String s) {
            super.logState(printer, s);
            printer.println((new StringBuilder()).append(s).append("mNesting=").append(mNesting).append("mUpdateTime=").append(mUpdateTime).append(" mAcquireTime=").append(mAcquireTime).toString());
        }

        public void plug(long l, long l1) {
            if(mNesting > 0) {
                super.plug(l, l1);
                mUpdateTime = l1;
            }
        }

        void readSummaryFromParcelLocked(Parcel parcel) {
            super.readSummaryFromParcelLocked(parcel);
            mNesting = 0;
        }

        boolean reset(BatteryStatsImpl batterystatsimpl, boolean flag) {
            boolean flag1 = true;
            boolean flag2;
            if(mNesting <= 0)
                flag2 = flag1;
            else
                flag2 = false;
            if(!flag2 || !flag)
                flag1 = false;
            super.reset(batterystatsimpl, flag1);
            if(mNesting > 0)
                mUpdateTime = batterystatsimpl.getBatteryRealtimeLocked(1000L * SystemClock.elapsedRealtime());
            mAcquireTime = super.mTotalTime;
            return flag2;
        }

        void setTimeout(long l) {
            mTimeout = l;
        }

        void startRunningLocked(BatteryStatsImpl batterystatsimpl) {
            int i = mNesting;
            mNesting = i + 1;
            if(i == 0) {
                mUpdateTime = batterystatsimpl.getBatteryRealtimeLocked(1000L * SystemClock.elapsedRealtime());
                if(mTimerPool != null) {
                    refreshTimersLocked(batterystatsimpl, mTimerPool);
                    mTimerPool.add(this);
                }
                super.mCount = 1 + super.mCount;
                mAcquireTime = super.mTotalTime;
            }
        }

        void stopRunningLocked(BatteryStatsImpl batterystatsimpl) {
            if(mNesting != 0) goto _L2; else goto _L1
_L1:
            return;
_L2:
            int i = -1 + mNesting;
            mNesting = i;
            if(i == 0) {
                if(mTimerPool != null) {
                    refreshTimersLocked(batterystatsimpl, mTimerPool);
                    mTimerPool.remove(this);
                } else {
                    long l = batterystatsimpl.getBatteryRealtimeLocked(1000L * SystemClock.elapsedRealtime());
                    mNesting = 1;
                    super.mTotalTime = computeRunTimeLocked(l);
                    mNesting = 0;
                }
                if(super.mTotalTime == mAcquireTime)
                    super.mCount = -1 + super.mCount;
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void writeToParcel(Parcel parcel, long l) {
            super.writeToParcel(parcel, l);
            parcel.writeLong(mUpdateTime);
        }

        long mAcquireTime;
        boolean mInList;
        int mNesting;
        long mTimeout;
        final ArrayList mTimerPool;
        final Uid mUid;
        long mUpdateTime;

        StopwatchTimer(Uid uid, int i, ArrayList arraylist, ArrayList arraylist1) {
            super(i, arraylist1);
            mUid = uid;
            mTimerPool = arraylist;
        }

        StopwatchTimer(Uid uid, int i, ArrayList arraylist, ArrayList arraylist1, Parcel parcel) {
            super(i, arraylist1, parcel);
            mUid = uid;
            mTimerPool = arraylist;
            mUpdateTime = parcel.readLong();
        }
    }

    public static final class SamplingTimer extends Timer {

        protected int computeCurrentCountLocked() {
            int i = super.mCount;
            int j;
            if(mInDischarge && mTrackingReportedValues)
                j = mCurrentReportedCount - mUnpluggedReportedCount;
            else
                j = 0;
            return j + i;
        }

        protected long computeRunTimeLocked(long l) {
            long l1 = super.mTotalTime;
            long l2;
            if(mInDischarge && mTrackingReportedValues)
                l2 = mCurrentReportedTotalTime - mUnpluggedReportedTotalTime;
            else
                l2 = 0L;
            return l2 + l1;
        }

        public int getUpdateVersion() {
            return mUpdateVersion;
        }

        public void logState(Printer printer, String s) {
            super.logState(printer, s);
            printer.println((new StringBuilder()).append(s).append("mCurrentReportedCount=").append(mCurrentReportedCount).append(" mUnpluggedReportedCount=").append(mUnpluggedReportedCount).append(" mCurrentReportedTotalTime=").append(mCurrentReportedTotalTime).append(" mUnpluggedReportedTotalTime=").append(mUnpluggedReportedTotalTime).toString());
        }

        public void plug(long l, long l1) {
            super.plug(l, l1);
            mInDischarge = false;
        }

        void readSummaryFromParcelLocked(Parcel parcel) {
            boolean flag = true;
            super.readSummaryFromParcelLocked(parcel);
            long l = parcel.readLong();
            mCurrentReportedTotalTime = l;
            mUnpluggedReportedTotalTime = l;
            int i = parcel.readInt();
            mCurrentReportedCount = i;
            mUnpluggedReportedCount = i;
            if(parcel.readInt() != flag)
                flag = false;
            mTrackingReportedValues = flag;
        }

        boolean reset(BatteryStatsImpl batterystatsimpl, boolean flag) {
            super.reset(batterystatsimpl, flag);
            setStale();
            return true;
        }

        public void setStale() {
            mTrackingReportedValues = false;
            mUnpluggedReportedTotalTime = 0L;
            mUnpluggedReportedCount = 0;
        }

        public void setUpdateVersion(int i) {
            mUpdateVersion = i;
        }

        public void unplug(long l, long l1) {
            super.unplug(l, l1);
            if(mTrackingReportedValues) {
                mUnpluggedReportedTotalTime = mCurrentReportedTotalTime;
                mUnpluggedReportedCount = mCurrentReportedCount;
            }
            mInDischarge = true;
        }

        public void updateCurrentReportedCount(int i) {
            if(mInDischarge && mUnpluggedReportedCount == 0) {
                mUnpluggedReportedCount = i;
                mTrackingReportedValues = true;
            }
            mCurrentReportedCount = i;
        }

        public void updateCurrentReportedTotalTime(long l) {
            if(mInDischarge && mUnpluggedReportedTotalTime == 0L) {
                mUnpluggedReportedTotalTime = l;
                mTrackingReportedValues = true;
            }
            mCurrentReportedTotalTime = l;
        }

        void writeSummaryFromParcelLocked(Parcel parcel, long l) {
            super.writeSummaryFromParcelLocked(parcel, l);
            parcel.writeLong(mCurrentReportedTotalTime);
            parcel.writeInt(mCurrentReportedCount);
            int i;
            if(mTrackingReportedValues)
                i = 1;
            else
                i = 0;
            parcel.writeInt(i);
        }

        public void writeToParcel(Parcel parcel, long l) {
            super.writeToParcel(parcel, l);
            parcel.writeInt(mCurrentReportedCount);
            parcel.writeInt(mUnpluggedReportedCount);
            parcel.writeLong(mCurrentReportedTotalTime);
            parcel.writeLong(mUnpluggedReportedTotalTime);
            int i;
            if(mTrackingReportedValues)
                i = 1;
            else
                i = 0;
            parcel.writeInt(i);
        }

        int mCurrentReportedCount;
        long mCurrentReportedTotalTime;
        boolean mInDischarge;
        boolean mTrackingReportedValues;
        int mUnpluggedReportedCount;
        long mUnpluggedReportedTotalTime;
        int mUpdateVersion;

        SamplingTimer(ArrayList arraylist, boolean flag, Parcel parcel) {
            boolean flag1 = true;
            super(0, arraylist, parcel);
            mCurrentReportedCount = parcel.readInt();
            mUnpluggedReportedCount = parcel.readInt();
            mCurrentReportedTotalTime = parcel.readLong();
            mUnpluggedReportedTotalTime = parcel.readLong();
            if(parcel.readInt() != flag1)
                flag1 = false;
            mTrackingReportedValues = flag1;
            mInDischarge = flag;
        }

        SamplingTimer(ArrayList arraylist, boolean flag, boolean flag1) {
            super(0, arraylist);
            mTrackingReportedValues = flag1;
            mInDischarge = flag;
        }
    }

    public static abstract class Timer extends android.os.BatteryStats.Timer
        implements Unpluggable {

        public static void writeTimerToParcel(Parcel parcel, Timer timer, long l) {
            if(timer == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                timer.writeToParcel(parcel, l);
            }
        }

        protected abstract int computeCurrentCountLocked();

        protected abstract long computeRunTimeLocked(long l);

        void detach() {
            mUnpluggables.remove(this);
        }

        public int getCountLocked(int i) {
            if(i != 1) goto _L2; else goto _L1
_L1:
            int j = mLastCount;
_L4:
            return j;
_L2:
            j = computeCurrentCountLocked();
            if(i == 3)
                j -= mUnpluggedCount;
            else
            if(i != 0)
                j -= mLoadedCount;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public long getTotalTimeLocked(long l, int i) {
            if(i != 1) goto _L2; else goto _L1
_L1:
            long l1 = mLastTime;
_L4:
            return l1;
_L2:
            l1 = computeRunTimeLocked(l);
            if(i == 3)
                l1 -= mUnpluggedTime;
            else
            if(i != 0)
                l1 -= mLoadedTime;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void logState(Printer printer, String s) {
            printer.println((new StringBuilder()).append(s).append(" mCount=").append(mCount).append(" mLoadedCount=").append(mLoadedCount).append(" mLastCount=").append(mLastCount).append(" mUnpluggedCount=").append(mUnpluggedCount).toString());
            printer.println((new StringBuilder()).append(s).append("mTotalTime=").append(mTotalTime).append(" mLoadedTime=").append(mLoadedTime).toString());
            printer.println((new StringBuilder()).append(s).append("mLastTime=").append(mLastTime).append(" mUnpluggedTime=").append(mUnpluggedTime).toString());
        }

        public void plug(long l, long l1) {
            mTotalTime = computeRunTimeLocked(l1);
            mCount = computeCurrentCountLocked();
        }

        void readSummaryFromParcelLocked(Parcel parcel) {
            long l = 1000L * parcel.readLong();
            mLoadedTime = l;
            mTotalTime = l;
            mLastTime = 0L;
            mUnpluggedTime = mTotalTime;
            int i = parcel.readInt();
            mLoadedCount = i;
            mCount = i;
            mLastCount = 0;
            mUnpluggedCount = mCount;
        }

        boolean reset(BatteryStatsImpl batterystatsimpl, boolean flag) {
            mLastTime = 0L;
            mLoadedTime = 0L;
            mTotalTime = 0L;
            mLastCount = 0;
            mLoadedCount = 0;
            mCount = 0;
            if(flag)
                detach();
            return true;
        }

        public void unplug(long l, long l1) {
            mUnpluggedTime = computeRunTimeLocked(l1);
            mUnpluggedCount = mCount;
        }

        void writeSummaryFromParcelLocked(Parcel parcel, long l) {
            parcel.writeLong((500L + computeRunTimeLocked(l)) / 1000L);
            parcel.writeInt(mCount);
        }

        public void writeToParcel(Parcel parcel, long l) {
            parcel.writeInt(mCount);
            parcel.writeInt(mLoadedCount);
            parcel.writeInt(mUnpluggedCount);
            parcel.writeLong(computeRunTimeLocked(l));
            parcel.writeLong(mLoadedTime);
            parcel.writeLong(mUnpluggedTime);
        }

        int mCount;
        int mLastCount;
        long mLastTime;
        int mLoadedCount;
        long mLoadedTime;
        long mTotalTime;
        final int mType;
        final ArrayList mUnpluggables;
        int mUnpluggedCount;
        long mUnpluggedTime;

        Timer(int i, ArrayList arraylist) {
            mType = i;
            mUnpluggables = arraylist;
            arraylist.add(this);
        }

        Timer(int i, ArrayList arraylist, Parcel parcel) {
            mType = i;
            mUnpluggables = arraylist;
            mCount = parcel.readInt();
            mLoadedCount = parcel.readInt();
            mLastCount = 0;
            mUnpluggedCount = parcel.readInt();
            mTotalTime = parcel.readLong();
            mLoadedTime = parcel.readLong();
            mLastTime = 0L;
            mUnpluggedTime = parcel.readLong();
            arraylist.add(this);
        }
    }

    public static class SamplingCounter extends Counter {

        public void addCountAtomic(long l) {
            super.mCount.addAndGet((int)l);
        }

        SamplingCounter(ArrayList arraylist) {
            super(arraylist);
        }

        SamplingCounter(ArrayList arraylist, Parcel parcel) {
            super(arraylist, parcel);
        }
    }

    public static class Counter extends android.os.BatteryStats.Counter
        implements Unpluggable {

        public static void writeCounterToParcel(Parcel parcel, Counter counter) {
            if(counter == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                counter.writeToParcel(parcel);
            }
        }

        void detach() {
            mUnpluggables.remove(this);
        }

        public int getCountLocked(int i) {
            if(i != 1) goto _L2; else goto _L1
_L1:
            int j = mLastCount;
_L4:
            return j;
_L2:
            j = mCount.get();
            if(i == 3)
                j -= mUnpluggedCount;
            else
            if(i != 0)
                j -= mLoadedCount;
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void logState(Printer printer, String s) {
            printer.println((new StringBuilder()).append(s).append("mCount=").append(mCount.get()).append(" mLoadedCount=").append(mLoadedCount).append(" mLastCount=").append(mLastCount).append(" mUnpluggedCount=").append(mUnpluggedCount).append(" mPluggedCount=").append(mPluggedCount).toString());
        }

        public void plug(long l, long l1) {
            mPluggedCount = mCount.get();
        }

        void readSummaryFromParcelLocked(Parcel parcel) {
            mLoadedCount = parcel.readInt();
            mCount.set(mLoadedCount);
            mLastCount = 0;
            int i = mLoadedCount;
            mPluggedCount = i;
            mUnpluggedCount = i;
        }

        void reset(boolean flag) {
            mCount.set(0);
            mUnpluggedCount = 0;
            mPluggedCount = 0;
            mLastCount = 0;
            mLoadedCount = 0;
            if(flag)
                detach();
        }

        void stepAtomic() {
            mCount.incrementAndGet();
        }

        public void unplug(long l, long l1) {
            mUnpluggedCount = mPluggedCount;
            mCount.set(mPluggedCount);
        }

        void writeSummaryFromParcelLocked(Parcel parcel) {
            parcel.writeInt(mCount.get());
        }

        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(mCount.get());
            parcel.writeInt(mLoadedCount);
            parcel.writeInt(mUnpluggedCount);
        }

        final AtomicInteger mCount;
        int mLastCount;
        int mLoadedCount;
        int mPluggedCount;
        final ArrayList mUnpluggables;
        int mUnpluggedCount;

        Counter(ArrayList arraylist) {
            mCount = new AtomicInteger();
            mUnpluggables = arraylist;
            arraylist.add(this);
        }

        Counter(ArrayList arraylist, Parcel parcel) {
            mCount = new AtomicInteger();
            mUnpluggables = arraylist;
            mPluggedCount = parcel.readInt();
            mCount.set(mPluggedCount);
            mLoadedCount = parcel.readInt();
            mLastCount = 0;
            mUnpluggedCount = parcel.readInt();
            arraylist.add(this);
        }
    }

    public static interface Unpluggable {

        public abstract void plug(long l, long l1);

        public abstract void unplug(long l, long l1);
    }

    final class MyHandler extends Handler {

        public void handleMessage(Message message) {
            BatteryCallback batterycallback = mCallback;
            message.what;
            JVM INSTR tableswitch 1 2: default 36
        //                       1 37
        //                       2 50;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            if(batterycallback != null)
                batterycallback.batteryNeedsCpuUpdate();
            continue; /* Loop/switch isn't completed */
_L3:
            if(batterycallback != null) {
                boolean flag;
                if(message.arg1 != 0)
                    flag = true;
                else
                    flag = false;
                batterycallback.batteryPowerChanged(flag);
            }
            if(true) goto _L1; else goto _L4
_L4:
        }

        final BatteryStatsImpl this$0;

        MyHandler() {
            this$0 = BatteryStatsImpl.this;
            super();
        }
    }

    public static interface BatteryCallback {

        public abstract void batteryNeedsCpuUpdate();

        public abstract void batteryPowerChanged(boolean flag);
    }


    public BatteryStatsImpl() {
        mUidStats = new SparseArray();
        mPartialTimers = new ArrayList();
        mFullTimers = new ArrayList();
        mWindowTimers = new ArrayList();
        mSensorTimers = new SparseArray();
        mWifiRunningTimers = new ArrayList();
        mFullWifiLockTimers = new ArrayList();
        mScanWifiLockTimers = new ArrayList();
        mWifiMulticastTimers = new ArrayList();
        mLastPartialTimers = new ArrayList();
        mUnpluggables = new ArrayList();
        mHaveBatteryLevel = false;
        mRecordingHistory = true;
        mHistoryBuffer = Parcel.obtain();
        mHistoryLastWritten = new android.os.BatteryStats.HistoryItem();
        mHistoryLastLastWritten = new android.os.BatteryStats.HistoryItem();
        mHistoryReadTmp = new android.os.BatteryStats.HistoryItem();
        mHistoryBufferLastPos = -1;
        mHistoryOverflow = false;
        mLastHistoryTime = 0L;
        mHistoryCur = new android.os.BatteryStats.HistoryItem();
        mScreenBrightnessBin = -1;
        mScreenBrightnessTimer = new StopwatchTimer[5];
        mPhoneSignalStrengthBin = -1;
        mPhoneSignalStrengthBinRaw = -1;
        mPhoneSignalStrengthsTimer = new StopwatchTimer[5];
        mPhoneDataConnectionType = -1;
        mPhoneDataConnectionsTimer = new StopwatchTimer[16];
        mWifiOnUid = -1;
        mLastWriteTime = 0L;
        mMobileDataTx = new long[4];
        mMobileDataRx = new long[4];
        mTotalDataTx = new long[4];
        mTotalDataRx = new long[4];
        mBluetoothPingStart = -1;
        mPhoneServiceState = -1;
        mPhoneServiceStateRaw = -1;
        mPhoneSimStateRaw = -1;
        mKernelWakelockStats = new HashMap();
        mProcWakelocksName = new String[3];
        mProcWakelocksData = new long[3];
        mProcWakelockFileStats = new HashMap();
        mUidCache = new HashMap();
        mNetworkStatsFactory = new NetworkStatsFactory();
        mMobileIfaces = Sets.newHashSet();
        mChangedBufferStates = 0;
        mChangedStates = 0;
        mWifiFullLockNesting = 0;
        mWifiScanLockNesting = 0;
        mWifiMulticastNesting = 0;
        mPendingWrite = null;
        mWriteLock = new ReentrantLock();
        mFile = null;
        mHandler = null;
    }

    public BatteryStatsImpl(Parcel parcel) {
        mUidStats = new SparseArray();
        mPartialTimers = new ArrayList();
        mFullTimers = new ArrayList();
        mWindowTimers = new ArrayList();
        mSensorTimers = new SparseArray();
        mWifiRunningTimers = new ArrayList();
        mFullWifiLockTimers = new ArrayList();
        mScanWifiLockTimers = new ArrayList();
        mWifiMulticastTimers = new ArrayList();
        mLastPartialTimers = new ArrayList();
        mUnpluggables = new ArrayList();
        mHaveBatteryLevel = false;
        mRecordingHistory = true;
        mHistoryBuffer = Parcel.obtain();
        mHistoryLastWritten = new android.os.BatteryStats.HistoryItem();
        mHistoryLastLastWritten = new android.os.BatteryStats.HistoryItem();
        mHistoryReadTmp = new android.os.BatteryStats.HistoryItem();
        mHistoryBufferLastPos = -1;
        mHistoryOverflow = false;
        mLastHistoryTime = 0L;
        mHistoryCur = new android.os.BatteryStats.HistoryItem();
        mScreenBrightnessBin = -1;
        mScreenBrightnessTimer = new StopwatchTimer[5];
        mPhoneSignalStrengthBin = -1;
        mPhoneSignalStrengthBinRaw = -1;
        mPhoneSignalStrengthsTimer = new StopwatchTimer[5];
        mPhoneDataConnectionType = -1;
        mPhoneDataConnectionsTimer = new StopwatchTimer[16];
        mWifiOnUid = -1;
        mLastWriteTime = 0L;
        mMobileDataTx = new long[4];
        mMobileDataRx = new long[4];
        mTotalDataTx = new long[4];
        mTotalDataRx = new long[4];
        mBluetoothPingStart = -1;
        mPhoneServiceState = -1;
        mPhoneServiceStateRaw = -1;
        mPhoneSimStateRaw = -1;
        mKernelWakelockStats = new HashMap();
        mProcWakelocksName = new String[3];
        mProcWakelocksData = new long[3];
        mProcWakelockFileStats = new HashMap();
        mUidCache = new HashMap();
        mNetworkStatsFactory = new NetworkStatsFactory();
        mMobileIfaces = Sets.newHashSet();
        mChangedBufferStates = 0;
        mChangedStates = 0;
        mWifiFullLockNesting = 0;
        mWifiScanLockNesting = 0;
        mWifiMulticastNesting = 0;
        mPendingWrite = null;
        mWriteLock = new ReentrantLock();
        mFile = null;
        mHandler = null;
        clearHistoryLocked();
        readFromParcel(parcel);
    }

    public BatteryStatsImpl(String s) {
        mUidStats = new SparseArray();
        mPartialTimers = new ArrayList();
        mFullTimers = new ArrayList();
        mWindowTimers = new ArrayList();
        mSensorTimers = new SparseArray();
        mWifiRunningTimers = new ArrayList();
        mFullWifiLockTimers = new ArrayList();
        mScanWifiLockTimers = new ArrayList();
        mWifiMulticastTimers = new ArrayList();
        mLastPartialTimers = new ArrayList();
        mUnpluggables = new ArrayList();
        mHaveBatteryLevel = false;
        mRecordingHistory = true;
        mHistoryBuffer = Parcel.obtain();
        mHistoryLastWritten = new android.os.BatteryStats.HistoryItem();
        mHistoryLastLastWritten = new android.os.BatteryStats.HistoryItem();
        mHistoryReadTmp = new android.os.BatteryStats.HistoryItem();
        mHistoryBufferLastPos = -1;
        mHistoryOverflow = false;
        mLastHistoryTime = 0L;
        mHistoryCur = new android.os.BatteryStats.HistoryItem();
        mScreenBrightnessBin = -1;
        mScreenBrightnessTimer = new StopwatchTimer[5];
        mPhoneSignalStrengthBin = -1;
        mPhoneSignalStrengthBinRaw = -1;
        mPhoneSignalStrengthsTimer = new StopwatchTimer[5];
        mPhoneDataConnectionType = -1;
        mPhoneDataConnectionsTimer = new StopwatchTimer[16];
        mWifiOnUid = -1;
        mLastWriteTime = 0L;
        mMobileDataTx = new long[4];
        mMobileDataRx = new long[4];
        mTotalDataTx = new long[4];
        mTotalDataRx = new long[4];
        mBluetoothPingStart = -1;
        mPhoneServiceState = -1;
        mPhoneServiceStateRaw = -1;
        mPhoneSimStateRaw = -1;
        mKernelWakelockStats = new HashMap();
        mProcWakelocksName = new String[3];
        mProcWakelocksData = new long[3];
        mProcWakelockFileStats = new HashMap();
        mUidCache = new HashMap();
        mNetworkStatsFactory = new NetworkStatsFactory();
        mMobileIfaces = Sets.newHashSet();
        mChangedBufferStates = 0;
        mChangedStates = 0;
        mWifiFullLockNesting = 0;
        mWifiScanLockNesting = 0;
        mWifiMulticastNesting = 0;
        mPendingWrite = null;
        mWriteLock = new ReentrantLock();
        mFile = new JournaledFile(new File(s), new File((new StringBuilder()).append(s).append(".tmp").toString()));
        mHandler = new MyHandler();
        mStartCount = 1 + mStartCount;
        mScreenOnTimer = new StopwatchTimer(null, -1, null, mUnpluggables);
        for(int i = 0; i < 5; i++)
            mScreenBrightnessTimer[i] = new StopwatchTimer(null, -100 - i, null, mUnpluggables);

        mInputEventCounter = new Counter(mUnpluggables);
        mPhoneOnTimer = new StopwatchTimer(null, -2, null, mUnpluggables);
        for(int j = 0; j < 5; j++)
            mPhoneSignalStrengthsTimer[j] = new StopwatchTimer(null, -200 - j, null, mUnpluggables);

        mPhoneSignalScanningTimer = new StopwatchTimer(null, -199, null, mUnpluggables);
        for(int k = 0; k < 16; k++)
            mPhoneDataConnectionsTimer[k] = new StopwatchTimer(null, -300 - k, null, mUnpluggables);

        mWifiOnTimer = new StopwatchTimer(null, -3, null, mUnpluggables);
        mGlobalWifiRunningTimer = new StopwatchTimer(null, -4, null, mUnpluggables);
        mBluetoothOnTimer = new StopwatchTimer(null, -5, null, mUnpluggables);
        mAudioOnTimer = new StopwatchTimer(null, -6, null, mUnpluggables);
        mVideoOnTimer = new StopwatchTimer(null, -7, null, mUnpluggables);
        mOnBatteryInternal = false;
        mOnBattery = false;
        initTimes();
        mTrackBatteryPastUptime = 0L;
        mTrackBatteryPastRealtime = 0L;
        long l = 1000L * SystemClock.uptimeMillis();
        mTrackBatteryUptimeStart = l;
        mUptimeStart = l;
        long l1 = 1000L * SystemClock.elapsedRealtime();
        mTrackBatteryRealtimeStart = l1;
        mRealtimeStart = l1;
        mUnpluggedBatteryUptime = getBatteryUptimeLocked(mUptimeStart);
        mUnpluggedBatteryRealtime = getBatteryRealtimeLocked(mRealtimeStart);
        mDischargeStartLevel = 0;
        mDischargeUnplugLevel = 0;
        mDischargeCurrentLevel = 0;
        initDischarge();
        clearHistoryLocked();
    }

    private void doDataPlug(long al[], long l) {
        al[1] = al[3];
        al[3] = -1L;
    }

    private void doDataUnplug(long al[], long l) {
        al[3] = l;
    }

    private int fixPhoneServiceState(int i, int j) {
        if(mPhoneSimStateRaw == 1 && i == 1 && j > 0)
            i = 0;
        return i;
    }

    private int getCurrentBluetoothPingCount() {
        if(mBtHeadset == null) goto _L2; else goto _L1
_L1:
        List list = mBtHeadset.getConnectedDevices();
        if(list.size() <= 0) goto _L2; else goto _L3
_L3:
        int i = mBtHeadset.getBatteryUsageHint((BluetoothDevice)list.get(0));
_L5:
        return i;
_L2:
        i = -1;
        if(true) goto _L5; else goto _L4
_L4:
    }

    private long getCurrentRadioDataUptime() {
        long l = 0L;
        long l1;
        File file = new File("/sys/devices/virtual/net/rmnet0/awake_time_ms");
        if(!file.exists())
            break MISSING_BLOCK_LABEL_76;
        BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
        String s = bufferedreader.readLine();
        bufferedreader.close();
        l1 = Long.parseLong(s);
        l = l1 * 1000L;
        break MISSING_BLOCK_LABEL_76;
        IOException ioexception;
        ioexception;
        break MISSING_BLOCK_LABEL_76;
        NumberFormatException numberformatexception;
        numberformatexception;
        return l;
    }

    private NetworkStats getNetworkStatsDetailGroupedByUid() {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if(mNetworkDetailCache != null && mNetworkDetailCache.getElapsedRealtimeAge() <= 1000L)
            break MISSING_BLOCK_LABEL_76;
        mNetworkDetailCache = null;
        flag = SystemProperties.getBoolean("net.qtaguid_enabled", false);
        Exception exception;
        NetworkStats networkstats;
        if(flag)
            try {
                mNetworkDetailCache = mNetworkStatsFactory.readNetworkStatsDetail().groupedByUid();
            }
            catch(IllegalStateException illegalstateexception) {
                Log.wtf("BatteryStatsImpl", "problem reading network stats", illegalstateexception);
            }
            finally {
                this;
            }
        if(mNetworkDetailCache == null)
            mNetworkDetailCache = new NetworkStats(SystemClock.elapsedRealtime(), 0);
        networkstats = mNetworkDetailCache;
        return networkstats;
        throw exception;
    }

    private NetworkStats getNetworkStatsSummary() {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if(mNetworkSummaryCache != null && mNetworkSummaryCache.getElapsedRealtimeAge() <= 1000L)
            break MISSING_BLOCK_LABEL_73;
        mNetworkSummaryCache = null;
        flag = SystemProperties.getBoolean("net.qtaguid_enabled", false);
        Exception exception;
        NetworkStats networkstats;
        if(flag)
            try {
                mNetworkSummaryCache = mNetworkStatsFactory.readNetworkStatsSummaryDev();
            }
            catch(IllegalStateException illegalstateexception) {
                Log.wtf("BatteryStatsImpl", "problem reading network stats", illegalstateexception);
            }
            finally {
                this;
            }
        if(mNetworkSummaryCache == null)
            mNetworkSummaryCache = new NetworkStats(SystemClock.elapsedRealtime(), 0);
        networkstats = mNetworkSummaryCache;
        return networkstats;
        throw exception;
    }

    private long getTcpBytes(long l, long al[], int i) {
        long l1;
        if(i == 1)
            l1 = al[1];
        else
        if(i == 3) {
            if(al[3] < 0L)
                l1 = al[1];
            else
                l1 = l - al[3];
        } else
        if(i == 0)
            l1 = (l - al[2]) + al[0];
        else
            l1 = l - al[2];
        return l1;
    }

    private final Map parseProcWakelocks(byte abyte0[], int i) {
        int j;
        int l;
        j = 0;
        int k;
        for(k = 0; k < i && abyte0[k] != 10 && abyte0[k] != 0; k++);
        l = k + 1;
        int i1 = l;
        this;
        JVM INSTR monitorenter ;
        Map map;
        map = mProcWakelockFileStats;
        sKernelWakelockUpdateVersion = 1 + sKernelWakelockUpdateVersion;
          goto _L1
_L5:
        int k1;
        j1 = i1;
label0:
        {
            for(; j1 < i && abyte0[j1] != 10 && abyte0[j1] != 0; j1++);
            l = j1 + 1;
            if(l < i - 1) {
                as = mProcWakelocksName;
                al = mProcWakelocksData;
                k1 = i1;
                break label0;
            }
        }
          goto _L2
        exception;
        throw exception;
        kernelwakelockstats.mCount = l1;
        kernelwakelockstats.mTotalTime = l2;
        kernelwakelockstats.mVersion = sKernelWakelockUpdateVersion;
        j++;
        break MISSING_BLOCK_LABEL_433;
_L4:
        if(map.size() != j) {
            iterator = map.values().iterator();
            do {
                if(!iterator.hasNext())
                    break;
                if(((KernelWakelockStats)iterator.next()).mVersion != sKernelWakelockUpdateVersion)
                    iterator.remove();
            } while(true);
        }
        this;
        JVM INSTR monitorexit ;
          goto _L2
_L1:
        if(l >= i) goto _L4; else goto _L3
_L3:
        if(true) goto _L5; else goto _L2
_L2:
        return map;
        i1 = l;
          goto _L1
    }

    static byte[] readFully(FileInputStream fileinputstream) throws IOException {
        int i = 0;
        byte abyte0[] = new byte[fileinputstream.available()];
        do {
            int k;
            do {
                int j = fileinputstream.read(abyte0, i, abyte0.length - i);
                if(j <= 0)
                    return abyte0;
                i += j;
                k = fileinputstream.available();
            } while(k <= abyte0.length - i);
            byte abyte1[] = new byte[i + k];
            System.arraycopy(abyte0, 0, abyte1, 0, i);
            abyte0 = abyte1;
        } while(true);
    }

    private final Map readKernelWakelockStats() {
        Map map;
        byte abyte0[];
        map = null;
        abyte0 = new byte[8192];
        int i;
        FileInputStream fileinputstream = new FileInputStream("/proc/wakelocks");
        i = fileinputstream.read(abyte0);
        fileinputstream.close();
        if(i <= 0) goto _L2; else goto _L1
_L1:
        int j = 0;
_L6:
        if(j >= i) goto _L2; else goto _L3
_L3:
        byte byte0 = abyte0[j];
        if(byte0 != 0) goto _L5; else goto _L4
_L4:
        i = j;
_L2:
        map = parseProcWakelocks(abyte0, i);
_L7:
        return map;
_L5:
        j++;
          goto _L6
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
          goto _L7
        IOException ioexception;
        ioexception;
          goto _L7
    }

    private void readSummaryFromParcel(Parcel parcel) {
        int k1;
        int i = parcel.readInt();
        if(i != 61) {
            Slog.w("BatteryStats", (new StringBuilder()).append("readFromParcel: version got ").append(i).append(", expected ").append(61).append("; erasing old stats").toString());
        } else {
            readHistory(parcel, true);
            mStartCount = parcel.readInt();
            mBatteryUptime = parcel.readLong();
            mBatteryRealtime = parcel.readLong();
            mUptime = parcel.readLong();
            mRealtime = parcel.readLong();
            mDischargeUnplugLevel = parcel.readInt();
            mDischargeCurrentLevel = parcel.readInt();
            mLowDischargeAmountSinceCharge = parcel.readInt();
            mHighDischargeAmountSinceCharge = parcel.readInt();
            mDischargeAmountScreenOnSinceCharge = parcel.readInt();
            mDischargeAmountScreenOffSinceCharge = parcel.readInt();
            mStartCount = 1 + mStartCount;
            mScreenOn = false;
            mScreenOnTimer.readSummaryFromParcelLocked(parcel);
            for(int j = 0; j < 5; j++)
                mScreenBrightnessTimer[j].readSummaryFromParcelLocked(parcel);

            mInputEventCounter.readSummaryFromParcelLocked(parcel);
            mPhoneOn = false;
            mPhoneOnTimer.readSummaryFromParcelLocked(parcel);
            for(int k = 0; k < 5; k++)
                mPhoneSignalStrengthsTimer[k].readSummaryFromParcelLocked(parcel);

            mPhoneSignalScanningTimer.readSummaryFromParcelLocked(parcel);
            for(int l = 0; l < 16; l++)
                mPhoneDataConnectionsTimer[l].readSummaryFromParcelLocked(parcel);

            mWifiOn = false;
            mWifiOnTimer.readSummaryFromParcelLocked(parcel);
            mGlobalWifiRunning = false;
            mGlobalWifiRunningTimer.readSummaryFromParcelLocked(parcel);
            mBluetoothOn = false;
            mBluetoothOnTimer.readSummaryFromParcelLocked(parcel);
            int i1 = parcel.readInt();
            if(i1 > 10000) {
                Slog.w("BatteryStatsImpl", (new StringBuilder()).append("File corrupt: too many kernel wake locks ").append(i1).toString());
            } else {
label0:
                {
                    for(int j1 = 0; j1 < i1; j1++)
                        if(parcel.readInt() != 0)
                            getKernelWakelockTimerLocked(parcel.readString()).readSummaryFromParcelLocked(parcel);

                    sNumSpeedSteps = parcel.readInt();
                    k1 = parcel.readInt();
                    if(k1 <= 10000)
                        break label0;
                    Slog.w("BatteryStatsImpl", (new StringBuilder()).append("File corrupt: too many uids ").append(k1).toString());
                }
            }
        }
_L1:
        return;
        int l1 = 0;
_L5:
        Uid uid;
        int j3;
        if(l1 < k1) {
            int i2 = parcel.readInt();
            uid = new Uid(i2);
            mUidStats.put(i2, uid);
            uid.mWifiRunning = false;
            if(parcel.readInt() != 0)
                uid.mWifiRunningTimer.readSummaryFromParcelLocked(parcel);
            uid.mFullWifiLockOut = false;
            if(parcel.readInt() != 0)
                uid.mFullWifiLockTimer.readSummaryFromParcelLocked(parcel);
            uid.mScanWifiLockOut = false;
            if(parcel.readInt() != 0)
                uid.mScanWifiLockTimer.readSummaryFromParcelLocked(parcel);
            uid.mWifiMulticastEnabled = false;
            if(parcel.readInt() != 0)
                uid.mWifiMulticastTimer.readSummaryFromParcelLocked(parcel);
            uid.mAudioTurnedOn = false;
            if(parcel.readInt() != 0)
                uid.mAudioTurnedOnTimer.readSummaryFromParcelLocked(parcel);
            uid.mVideoTurnedOn = false;
            if(parcel.readInt() != 0)
                uid.mVideoTurnedOnTimer.readSummaryFromParcelLocked(parcel);
            if(parcel.readInt() != 0) {
                if(uid.mUserActivityCounters == null)
                    uid.initUserActivityLocked();
                for(int i7 = 0; i7 < 7; i7++)
                    uid.mUserActivityCounters[i7].readSummaryFromParcelLocked(parcel);

            }
            int j2 = parcel.readInt();
            if(j2 > 100) {
                Slog.w("BatteryStatsImpl", (new StringBuilder()).append("File corrupt: too many wake locks ").append(j2).toString());
            } else {
                for(int k2 = 0; k2 < j2; k2++) {
                    String s1 = parcel.readString();
                    if(parcel.readInt() != 0)
                        uid.getWakeTimerLocked(s1, 1).readSummaryFromParcelLocked(parcel);
                    if(parcel.readInt() != 0)
                        uid.getWakeTimerLocked(s1, 0).readSummaryFromParcelLocked(parcel);
                    if(parcel.readInt() != 0)
                        uid.getWakeTimerLocked(s1, 2).readSummaryFromParcelLocked(parcel);
                }

                int l2 = parcel.readInt();
                if(l2 > 1000) {
                    Slog.w("BatteryStatsImpl", (new StringBuilder()).append("File corrupt: too many sensors ").append(l2).toString());
                } else {
label1:
                    {
                        for(int i3 = 0; i3 < l2; i3++) {
                            int k6 = parcel.readInt();
                            if(parcel.readInt() != 0)
                                uid.getSensorTimerLocked(k6, true).readSummaryFromParcelLocked(parcel);
                        }

                        j3 = parcel.readInt();
                        if(j3 <= 1000)
                            break label1;
                        Slog.w("BatteryStatsImpl", (new StringBuilder()).append("File corrupt: too many processes ").append(j3).toString());
                    }
                }
            }
        }
          goto _L1
        int k3 = 0;
_L3:
        Uid.Proc proc;
        int i6;
label2:
        {
            if(k3 >= j3)
                break MISSING_BLOCK_LABEL_1120;
            proc = uid.getProcessStatsLocked(parcel.readString());
            long l6 = parcel.readLong();
            proc.mLoadedUserTime = l6;
            proc.mUserTime = l6;
            long l7 = parcel.readLong();
            proc.mLoadedSystemTime = l7;
            proc.mSystemTime = l7;
            int k5 = parcel.readInt();
            proc.mLoadedStarts = k5;
            proc.mStarts = k5;
            i6 = parcel.readInt();
            if(i6 <= 100)
                break label2;
            Slog.w("BatteryStatsImpl", (new StringBuilder()).append("File corrupt: too many speed bins ").append(i6).toString());
        }
          goto _L1
        proc.mSpeedBins = new SamplingCounter[i6];
        for(int j6 = 0; j6 < i6; j6++)
            if(parcel.readInt() != 0) {
                proc.mSpeedBins[j6] = new SamplingCounter(mUnpluggables);
                proc.mSpeedBins[j6].readSummaryFromParcelLocked(parcel);
            }

        if(!proc.readExcessivePowerFromParcelLocked(parcel)) goto _L1; else goto _L2
_L2:
        k3++;
          goto _L3
        int l3;
label3:
        {
            l3 = parcel.readInt();
            if(l3 <= 10000)
                break label3;
            Slog.w("BatteryStatsImpl", (new StringBuilder()).append("File corrupt: too many packages ").append(l3).toString());
        }
          goto _L1
        int i4 = 0;
_L4:
        String s;
        int k4;
label4:
        {
            if(i4 >= l3)
                break MISSING_BLOCK_LABEL_1348;
            s = parcel.readString();
            Uid.Pkg pkg = uid.getPackageStatsLocked(s);
            int j4 = parcel.readInt();
            pkg.mLoadedWakeups = j4;
            pkg.mWakeups = j4;
            k4 = parcel.readInt();
            if(k4 <= 1000)
                break label4;
            Slog.w("BatteryStatsImpl", (new StringBuilder()).append("File corrupt: too many services ").append(k4).toString());
        }
          goto _L1
        for(int l4 = 0; l4 < k4; l4++) {
            Uid.Pkg.Serv serv = uid.getServiceStatsLocked(s, parcel.readString());
            long l5 = parcel.readLong();
            serv.mLoadedStartTime = l5;
            serv.mStartTime = l5;
            int i5 = parcel.readInt();
            serv.mLoadedStarts = i5;
            serv.mStarts = i5;
            int j5 = parcel.readInt();
            serv.mLoadedLaunches = j5;
            serv.mLaunches = j5;
        }

        i4++;
          goto _L4
        uid.mLoadedTcpBytesReceived = parcel.readLong();
        uid.mLoadedTcpBytesSent = parcel.readLong();
        l1++;
          goto _L5
    }

    private void updateAllPhoneStateLocked(int i, int j, int k) {
        boolean flag = false;
        boolean flag1 = false;
        mPhoneServiceStateRaw = i;
        mPhoneSimStateRaw = j;
        mPhoneSignalStrengthBinRaw = k;
        if(j == 1 && i == 1 && k > 0)
            i = 0;
        if(i == 3)
            k = -1;
        else
        if(i != 0 && i == 1) {
            flag = true;
            k = 0;
            if(!mPhoneSignalScanningTimer.isRunningLocked()) {
                android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
                historyitem.states = 0x8000000 | historyitem.states;
                flag1 = true;
                mPhoneSignalScanningTimer.startRunningLocked(this);
            }
        }
        if(!flag && mPhoneSignalScanningTimer.isRunningLocked()) {
            android.os.BatteryStats.HistoryItem historyitem1 = mHistoryCur;
            historyitem1.states = 0xf7ffffff & historyitem1.states;
            flag1 = true;
            mPhoneSignalScanningTimer.stopRunningLocked(this);
        }
        if(mPhoneServiceState != i) {
            mHistoryCur.states = 0xfffff0ff & mHistoryCur.states | i << 8;
            flag1 = true;
            mPhoneServiceState = i;
        }
        if(mPhoneSignalStrengthBin != k) {
            if(mPhoneSignalStrengthBin >= 0)
                mPhoneSignalStrengthsTimer[mPhoneSignalStrengthBin].stopRunningLocked(this);
            if(k >= 0) {
                if(!mPhoneSignalStrengthsTimer[k].isRunningLocked())
                    mPhoneSignalStrengthsTimer[k].startRunningLocked(this);
                mHistoryCur.states = 0xffffff0f & mHistoryCur.states | k << 4;
                flag1 = true;
            } else {
                stopAllSignalStrengthTimersLocked(-1);
            }
            mPhoneSignalStrengthBin = k;
        }
        if(flag1)
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
    }

    void addHistoryBufferLocked(long l) {
        if(mHaveBatteryLevel && mRecordingHistory) {
label0:
            {
                long l1 = (l + mHistoryBaseTime) - mHistoryLastWritten.time;
                if(mHistoryBufferLastPos < 0 || mHistoryLastWritten.cmd != 1 || l1 >= 2000L || ((mHistoryLastWritten.states ^ mHistoryCur.states) & mChangedBufferStates) != 0)
                    break MISSING_BLOCK_LABEL_299;
                mHistoryBuffer.setDataSize(mHistoryBufferLastPos);
                mHistoryBuffer.setDataPosition(mHistoryBufferLastPos);
                mHistoryBufferLastPos = -1;
                if(mHistoryLastLastWritten.cmd != 1 || l1 >= 500L || !mHistoryLastLastWritten.same(mHistoryCur))
                    break label0;
                mHistoryLastWritten.setTo(mHistoryLastLastWritten);
                mHistoryLastLastWritten.cmd = 0;
            }
        }
_L3:
        return;
        mChangedBufferStates = mChangedBufferStates | mHistoryLastWritten.states ^ mHistoryCur.states;
        l = mHistoryLastWritten.time - mHistoryBaseTime;
        mHistoryLastWritten.setTo(mHistoryLastLastWritten);
_L4:
        int i = mHistoryBuffer.dataSize();
        if(i < 0x20000) goto _L2; else goto _L1
_L1:
        if(!mHistoryOverflow) {
            mHistoryOverflow = true;
            addHistoryBufferLocked(l, (byte)3);
        }
        if(mHistoryLastWritten.batteryLevel == mHistoryCur.batteryLevel && (i >= 0x24000 || (0x101c0000 & (mHistoryLastWritten.states ^ mHistoryCur.states)) == 0)) goto _L3; else goto _L2
_L2:
        addHistoryBufferLocked(l, (byte)1);
          goto _L3
        mChangedBufferStates = 0;
          goto _L4
    }

    void addHistoryBufferLocked(long l, byte byte0) {
        int i = 0;
        if(mIteratingHistory) {
            i = mHistoryBuffer.dataPosition();
            mHistoryBuffer.setDataPosition(mHistoryBuffer.dataSize());
        }
        mHistoryBufferLastPos = mHistoryBuffer.dataPosition();
        mHistoryLastLastWritten.setTo(mHistoryLastWritten);
        mHistoryLastWritten.setTo(l + mHistoryBaseTime, byte0, mHistoryCur);
        mHistoryLastWritten.writeDelta(mHistoryBuffer, mHistoryLastLastWritten);
        mLastHistoryTime = l;
        if(mIteratingHistory)
            mHistoryBuffer.setDataPosition(i);
    }

    void addHistoryRecordLocked(long l) {
        addHistoryBufferLocked(l);
    }

    void addHistoryRecordLocked(long l, byte byte0) {
        android.os.BatteryStats.HistoryItem historyitem = mHistoryCache;
        if(historyitem != null)
            mHistoryCache = historyitem.next;
        else
            historyitem = new android.os.BatteryStats.HistoryItem();
        historyitem.setTo(l + mHistoryBaseTime, byte0, mHistoryCur);
        addHistoryRecordLocked(historyitem);
    }

    void addHistoryRecordLocked(android.os.BatteryStats.HistoryItem historyitem) {
        mNumHistoryItems = 1 + mNumHistoryItems;
        historyitem.next = null;
        mHistoryLastEnd = mHistoryEnd;
        if(mHistoryEnd != null) {
            mHistoryEnd.next = historyitem;
            mHistoryEnd = historyitem;
        } else {
            mHistoryEnd = historyitem;
            mHistory = historyitem;
        }
    }

    void clearHistoryLocked() {
        mHistoryBaseTime = 0L;
        mLastHistoryTime = 0L;
        mHistoryBuffer.setDataSize(0);
        mHistoryBuffer.setDataPosition(0);
        mHistoryBuffer.setDataCapacity(0x10000);
        mHistoryLastLastWritten.cmd = 0;
        mHistoryLastWritten.cmd = 0;
        mHistoryBufferLastPos = -1;
        mHistoryOverflow = false;
    }

    public void commitPendingDataToDisk() {
        this;
        JVM INSTR monitorenter ;
        Parcel parcel;
        parcel = mPendingWrite;
        mPendingWrite = null;
        if(parcel != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
          goto _L3
_L2:
        mWriteLock.lock();
        this;
        JVM INSTR monitorexit ;
        FileOutputStream fileoutputstream = new FileOutputStream(mFile.chooseForWrite());
        fileoutputstream.write(parcel.marshall());
        fileoutputstream.flush();
        FileUtils.sync(fileoutputstream);
        fileoutputstream.close();
        mFile.commit();
        ReentrantLock reentrantlock;
        parcel.recycle();
        reentrantlock = mWriteLock;
_L4:
        reentrantlock.unlock();
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        IOException ioexception;
        ioexception;
        Slog.w("BatteryStats", "Error writing battery statistics", ioexception);
        mFile.rollback();
        parcel.recycle();
        reentrantlock = mWriteLock;
        if(true) goto _L4; else goto _L3
        Exception exception1;
        exception1;
        parcel.recycle();
        mWriteLock.unlock();
        throw exception1;
_L3:
    }

    public long computeBatteryRealtime(long l, int i) {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 38
    //                   1 53
    //                   2 62
    //                   3 72;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        long l1 = 0L;
_L7:
        return l1;
_L2:
        l1 = mBatteryRealtime + getBatteryRealtimeLocked(l);
        continue; /* Loop/switch isn't completed */
_L3:
        l1 = mBatteryLastRealtime;
        continue; /* Loop/switch isn't completed */
_L4:
        l1 = getBatteryRealtimeLocked(l);
        continue; /* Loop/switch isn't completed */
_L5:
        l1 = getBatteryRealtimeLocked(l) - mUnpluggedBatteryRealtime;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public long computeBatteryUptime(long l, int i) {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 38
    //                   1 53
    //                   2 62
    //                   3 72;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        long l1 = 0L;
_L7:
        return l1;
_L2:
        l1 = mBatteryUptime + getBatteryUptime(l);
        continue; /* Loop/switch isn't completed */
_L3:
        l1 = mBatteryLastUptime;
        continue; /* Loop/switch isn't completed */
_L4:
        l1 = getBatteryUptime(l);
        continue; /* Loop/switch isn't completed */
_L5:
        l1 = getBatteryUptimeLocked(l) - mUnpluggedBatteryUptime;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public long computeRealtime(long l, int i) {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 38
    //                   1 54
    //                   2 63
    //                   3 74;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        long l1 = 0L;
_L7:
        return l1;
_L2:
        l1 = mRealtime + (l - mRealtimeStart);
        continue; /* Loop/switch isn't completed */
_L3:
        l1 = mLastRealtime;
        continue; /* Loop/switch isn't completed */
_L4:
        l1 = l - mRealtimeStart;
        continue; /* Loop/switch isn't completed */
_L5:
        l1 = l - mTrackBatteryRealtimeStart;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public long computeUptime(long l, int i) {
        i;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 38
    //                   1 54
    //                   2 63
    //                   3 74;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        long l1 = 0L;
_L7:
        return l1;
_L2:
        l1 = mUptime + (l - mUptimeStart);
        continue; /* Loop/switch isn't completed */
_L3:
        l1 = mLastUptime;
        continue; /* Loop/switch isn't completed */
_L4:
        l1 = l - mUptimeStart;
        continue; /* Loop/switch isn't completed */
_L5:
        l1 = l - mTrackBatteryUptimeStart;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public int describeContents() {
        return 0;
    }

    public void distributeWorkLocked(int i) {
        Uid uid = (Uid)mUidStats.get(1010);
        if(uid != null) {
            long l = computeBatteryRealtime(1000L * SystemClock.elapsedRealtime(), i);
            for(Iterator iterator = uid.mProcessStats.values().iterator(); iterator.hasNext();) {
                Uid.Proc proc = (Uid.Proc)iterator.next();
                long l1 = getGlobalWifiRunningTime(l, i);
                int j = 0;
                while(j < mUidStats.size())  {
                    Uid uid1 = (Uid)mUidStats.valueAt(j);
                    if(uid1.mUid != 1010) {
                        long l2 = uid1.getWifiRunningTime(l, i);
                        if(l2 > 0L) {
                            Uid.Proc proc1 = uid1.getProcessStatsLocked("*wifi*");
                            long l3 = (l2 * proc.getUserTime(i)) / l1;
                            proc1.mUserTime = l3 + proc1.mUserTime;
                            proc.mUserTime = proc.mUserTime - l3;
                            long l4 = (l2 * proc.getSystemTime(i)) / l1;
                            proc1.mSystemTime = l4 + proc1.mSystemTime;
                            proc.mSystemTime = proc.mSystemTime - l4;
                            long l5 = (l2 * proc.getForegroundTime(i)) / l1;
                            proc1.mForegroundTime = l5 + proc1.mForegroundTime;
                            proc.mForegroundTime = proc.mForegroundTime - l5;
                            for(int k = 0; k < proc.mSpeedBins.length; k++) {
                                SamplingCounter samplingcounter = proc.mSpeedBins[k];
                                if(samplingcounter == null)
                                    continue;
                                long l6 = (l2 * (long)samplingcounter.getCountLocked(i)) / l1;
                                SamplingCounter samplingcounter1 = proc1.mSpeedBins[k];
                                if(samplingcounter1 == null) {
                                    ArrayList arraylist = mUnpluggables;
                                    samplingcounter1 = new SamplingCounter(arraylist);
                                    proc1.mSpeedBins[k] = samplingcounter1;
                                }
                                ((Counter) (samplingcounter1)).mCount.addAndGet((int)l6);
                                ((Counter) (samplingcounter)).mCount.addAndGet((int)(-l6));
                            }

                            l1 -= l2;
                        }
                    }
                    j++;
                }
            }

        }
    }

    public void doPlugLocked(long l, long l1) {
        for(int i = -1 + mUidStats.size(); i >= 0; i--) {
            Uid uid = (Uid)mUidStats.valueAt(i);
            if(uid.mStartedTcpBytesReceived >= 0L) {
                uid.mCurrentTcpBytesReceived = uid.computeCurrentTcpBytesReceived();
                uid.mStartedTcpBytesReceived = -1L;
            }
            if(uid.mStartedTcpBytesSent >= 0L) {
                uid.mCurrentTcpBytesSent = uid.computeCurrentTcpBytesSent();
                uid.mStartedTcpBytesSent = -1L;
            }
        }

        for(int j = -1 + mUnpluggables.size(); j >= 0; j--)
            ((Unpluggable)mUnpluggables.get(j)).plug(l, l1);

        NetworkStats networkstats = getNetworkStatsSummary();
        android.net.NetworkStats.Entry entry = networkstats.getTotal(null, mMobileIfaces);
        doDataPlug(mMobileDataRx, entry.rxBytes);
        doDataPlug(mMobileDataTx, entry.txBytes);
        android.net.NetworkStats.Entry entry1 = networkstats.getTotal(entry);
        doDataPlug(mTotalDataRx, entry1.rxBytes);
        doDataPlug(mTotalDataTx, entry1.txBytes);
        mRadioDataUptime = getRadioDataUptime();
        mRadioDataStart = -1L;
        mBluetoothPingCount = getBluetoothPingCount();
        mBluetoothPingStart = -1;
    }

    public void doUnplugLocked(long l, long l1) {
        android.net.NetworkStats.Entry entry = null;
        NetworkStats networkstats = getNetworkStatsDetailGroupedByUid();
        int i = networkstats.size();
        int j = 0;
        while(j < i)  {
            entry = networkstats.getValues(j, entry);
            Uid uid = (Uid)mUidStats.get(entry.uid);
            if(uid != null) {
                uid.mStartedTcpBytesReceived = entry.rxBytes;
                uid.mStartedTcpBytesSent = entry.txBytes;
                uid.mTcpBytesReceivedAtLastUnplug = uid.mCurrentTcpBytesReceived;
                uid.mTcpBytesSentAtLastUnplug = uid.mCurrentTcpBytesSent;
            }
            j++;
        }
        for(int k = -1 + mUnpluggables.size(); k >= 0; k--)
            ((Unpluggable)mUnpluggables.get(k)).unplug(l, l1);

        NetworkStats networkstats1 = getNetworkStatsSummary();
        android.net.NetworkStats.Entry entry1 = networkstats1.getTotal(entry, mMobileIfaces);
        doDataUnplug(mMobileDataRx, entry1.rxBytes);
        doDataUnplug(mMobileDataTx, entry1.txBytes);
        android.net.NetworkStats.Entry entry2 = networkstats1.getTotal(entry1);
        doDataUnplug(mTotalDataRx, entry2.rxBytes);
        doDataUnplug(mTotalDataTx, entry2.txBytes);
        mRadioDataStart = getCurrentRadioDataUptime();
        mRadioDataUptime = 0L;
        mBluetoothPingStart = getCurrentBluetoothPingCount();
        mBluetoothPingCount = 0;
    }

    public void dumpLocked(PrintWriter printwriter) {
        super.dumpLocked(printwriter);
    }

    public void finishAddingCpuLocked(int i, int j, int k, long al[]) {
        int l = mPartialTimers.size();
        if(i != 0) {
            int j2 = 0;
            for(int k2 = 0; k2 < l; k2++) {
                StopwatchTimer stopwatchtimer2 = (StopwatchTimer)mPartialTimers.get(k2);
                if(!stopwatchtimer2.mInList)
                    continue;
                Uid uid2 = stopwatchtimer2.mUid;
                if(uid2 != null && uid2.mUid != 1000)
                    j2++;
            }

            if(j2 != 0) {
                for(int l2 = 0; l2 < l; l2++) {
                    StopwatchTimer stopwatchtimer1 = (StopwatchTimer)mPartialTimers.get(l2);
                    if(!stopwatchtimer1.mInList)
                        continue;
                    Uid uid1 = stopwatchtimer1.mUid;
                    if(uid1 != null && uid1.mUid != 1000) {
                        int i3 = j / j2;
                        int j3 = k / j2;
                        j -= i3;
                        k -= j3;
                        j2--;
                        Uid.Proc proc1 = uid1.getProcessStatsLocked("*wakelock*");
                        proc1.addCpuTimeLocked(i3, j3);
                        proc1.addSpeedStepTimes(al);
                    }
                }

            }
            if(j != 0 || k != 0) {
                Uid uid = getUidStatsLocked(1000);
                if(uid != null) {
                    Uid.Proc proc = uid.getProcessStatsLocked("*lost*");
                    proc.addCpuTimeLocked(j, k);
                    proc.addSpeedStepTimes(al);
                }
            }
        }
        int i1 = mLastPartialTimers.size();
        boolean flag;
        int j1;
        if(l != i1)
            flag = true;
        else
            flag = false;
        j1 = 0;
        while(j1 < i1 && !flag)  {
            boolean flag1;
            if(mPartialTimers.get(j1) != mLastPartialTimers.get(j1))
                flag1 = true;
            else
                flag1 = false;
            flag |= flag1;
            j1++;
        }
        if(!flag) {
            for(int i2 = 0; i2 < i1; i2++)
                ((StopwatchTimer)mPartialTimers.get(i2)).mInList = true;

        } else {
            for(int k1 = 0; k1 < i1; k1++)
                ((StopwatchTimer)mLastPartialTimers.get(k1)).mInList = false;

            mLastPartialTimers.clear();
            for(int l1 = 0; l1 < l; l1++) {
                StopwatchTimer stopwatchtimer = (StopwatchTimer)mPartialTimers.get(l1);
                stopwatchtimer.mInList = true;
                mLastPartialTimers.add(stopwatchtimer);
            }

        }
    }

    public void finishIteratingHistoryLocked() {
        mIteratingHistory = false;
        mHistoryBuffer.setDataPosition(mHistoryBuffer.dataSize());
    }

    public void finishIteratingOldHistoryLocked() {
        mIteratingHistory = false;
        mHistoryBuffer.setDataPosition(mHistoryBuffer.dataSize());
    }

    public long getAwakeTimeBattery() {
        return computeBatteryUptime(getBatteryUptimeLocked(), 2);
    }

    public long getAwakeTimePlugged() {
        return 1000L * SystemClock.uptimeMillis() - getAwakeTimeBattery();
    }

    public long getBatteryRealtime(long l) {
        return getBatteryRealtimeLocked(l);
    }

    long getBatteryRealtimeLocked(long l) {
        long l1 = mTrackBatteryPastRealtime;
        if(mOnBatteryInternal)
            l1 += l - mTrackBatteryRealtimeStart;
        return l1;
    }

    public long getBatteryUptime(long l) {
        return getBatteryUptimeLocked(l);
    }

    long getBatteryUptimeLocked() {
        return getBatteryUptime(1000L * SystemClock.uptimeMillis());
    }

    long getBatteryUptimeLocked(long l) {
        long l1 = mTrackBatteryPastUptime;
        if(mOnBatteryInternal)
            l1 += l - mTrackBatteryUptimeStart;
        return l1;
    }

    public long getBluetoothOnTime(long l, int i) {
        return mBluetoothOnTimer.getTotalTimeLocked(l, i);
    }

    public int getBluetoothPingCount() {
        int i;
        if(mBluetoothPingStart == -1)
            i = mBluetoothPingCount;
        else
        if(mBtHeadset != null)
            i = getCurrentBluetoothPingCount() - mBluetoothPingStart;
        else
            i = 0;
        return i;
    }

    public int getCpuSpeedSteps() {
        return sNumSpeedSteps;
    }

    public int getDischargeAmountScreenOff() {
        this;
        JVM INSTR monitorenter ;
        int i = mDischargeAmountScreenOff;
        if(mOnBattery && !mScreenOn && mDischargeCurrentLevel < mDischargeScreenOffUnplugLevel)
            i += mDischargeScreenOffUnplugLevel - mDischargeCurrentLevel;
        return i;
    }

    public int getDischargeAmountScreenOffSinceCharge() {
        this;
        JVM INSTR monitorenter ;
        int i = mDischargeAmountScreenOffSinceCharge;
        if(mOnBattery && !mScreenOn && mDischargeCurrentLevel < mDischargeScreenOffUnplugLevel)
            i += mDischargeScreenOffUnplugLevel - mDischargeCurrentLevel;
        return i;
    }

    public int getDischargeAmountScreenOn() {
        this;
        JVM INSTR monitorenter ;
        int i = mDischargeAmountScreenOn;
        if(mOnBattery && mScreenOn && mDischargeCurrentLevel < mDischargeScreenOnUnplugLevel)
            i += mDischargeScreenOnUnplugLevel - mDischargeCurrentLevel;
        return i;
    }

    public int getDischargeAmountScreenOnSinceCharge() {
        this;
        JVM INSTR monitorenter ;
        int i = mDischargeAmountScreenOnSinceCharge;
        if(mOnBattery && mScreenOn && mDischargeCurrentLevel < mDischargeScreenOnUnplugLevel)
            i += mDischargeScreenOnUnplugLevel - mDischargeCurrentLevel;
        return i;
    }

    public int getDischargeCurrentLevel() {
        this;
        JVM INSTR monitorenter ;
        int i = getDischargeCurrentLevelLocked();
        return i;
    }

    public int getDischargeCurrentLevelLocked() {
        return mDischargeCurrentLevel;
    }

    public int getDischargeStartLevel() {
        this;
        JVM INSTR monitorenter ;
        int i = getDischargeStartLevelLocked();
        return i;
    }

    public int getDischargeStartLevelLocked() {
        return mDischargeUnplugLevel;
    }

    public long getGlobalWifiRunningTime(long l, int i) {
        return mGlobalWifiRunningTimer.getTotalTimeLocked(l, i);
    }

    public int getHighDischargeAmountSinceCharge() {
        this;
        JVM INSTR monitorenter ;
        int i = mHighDischargeAmountSinceCharge;
        if(mOnBattery && mDischargeCurrentLevel < mDischargeUnplugLevel)
            i += mDischargeUnplugLevel - mDischargeCurrentLevel;
        return i;
    }

    public long getHistoryBaseTime() {
        return mHistoryBaseTime;
    }

    public int getInputEventCount(int i) {
        return mInputEventCounter.getCountLocked(i);
    }

    public boolean getIsOnBattery() {
        return mOnBattery;
    }

    public Map getKernelWakelockStats() {
        return mKernelWakelockStats;
    }

    public SamplingTimer getKernelWakelockTimerLocked(String s) {
        SamplingTimer samplingtimer = (SamplingTimer)mKernelWakelockStats.get(s);
        if(samplingtimer == null) {
            samplingtimer = new SamplingTimer(mUnpluggables, mOnBatteryInternal, true);
            mKernelWakelockStats.put(s, samplingtimer);
        }
        return samplingtimer;
    }

    public int getLowDischargeAmountSinceCharge() {
        this;
        JVM INSTR monitorenter ;
        int i = mLowDischargeAmountSinceCharge;
        if(mOnBattery && mDischargeCurrentLevel < mDischargeUnplugLevel)
            i += -1 + (mDischargeUnplugLevel - mDischargeCurrentLevel);
        return i;
    }

    public long getMobileTcpBytesReceived(int i) {
        return getTcpBytes(getNetworkStatsSummary().getTotal(null, mMobileIfaces).rxBytes, mMobileDataRx, i);
    }

    public long getMobileTcpBytesSent(int i) {
        return getTcpBytes(getNetworkStatsSummary().getTotal(null, mMobileIfaces).txBytes, mMobileDataTx, i);
    }

    public boolean getNextHistoryLocked(android.os.BatteryStats.HistoryItem historyitem) {
        boolean flag = false;
        int i = mHistoryBuffer.dataPosition();
        if(i == 0)
            historyitem.clear();
        boolean flag1;
        if(i >= mHistoryBuffer.dataSize())
            flag1 = true;
        else
            flag1 = false;
        if(!flag1) {
            historyitem.readDelta(mHistoryBuffer);
            flag = true;
        }
        return flag;
    }

    public boolean getNextOldHistoryLocked(android.os.BatteryStats.HistoryItem historyitem) {
        boolean flag;
        boolean flag1;
        android.os.BatteryStats.HistoryItem historyitem1;
        flag = false;
        if(mHistoryBuffer.dataPosition() >= mHistoryBuffer.dataSize())
            flag1 = true;
        else
            flag1 = false;
        if(!flag1) {
            mHistoryReadTmp.readDelta(mHistoryBuffer);
            boolean flag2 = mReadOverflow;
            boolean flag3;
            if(mHistoryReadTmp.cmd == 3)
                flag3 = true;
            else
                flag3 = false;
            mReadOverflow = flag3 | flag2;
        }
        historyitem1 = mHistoryIterator;
        if(historyitem1 != null) goto _L2; else goto _L1
_L1:
        if(!mReadOverflow && !flag1)
            Slog.w("BatteryStatsImpl", "Old history ends before new history!");
_L4:
        return flag;
_L2:
        historyitem.setTo(historyitem1);
        mHistoryIterator = historyitem1.next;
        if(!mReadOverflow) {
            if(!flag1)
                break; /* Loop/switch isn't completed */
            Slog.w("BatteryStatsImpl", "New history ends before old history!");
        }
_L6:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
        if(historyitem.same(mHistoryReadTmp)) goto _L6; else goto _L5
_L5:
        long l = getHistoryBaseTime() + SystemClock.elapsedRealtime();
        PrintWriter printwriter = new PrintWriter(new LogWriter(5, "BatteryStatsImpl"));
        printwriter.println("Histories differ!");
        printwriter.println("Old history:");
        (new android.os.BatteryStats.HistoryPrinter()).printNextItem(printwriter, historyitem, l);
        printwriter.println("New history:");
        (new android.os.BatteryStats.HistoryPrinter()).printNextItem(printwriter, mHistoryReadTmp, l);
          goto _L6
    }

    public Uid.Pkg getPackageStatsLocked(int i, String s) {
        return getUidStatsLocked(i).getPackageStatsLocked(s);
    }

    public int getPhoneDataConnectionCount(int i, int j) {
        return mPhoneDataConnectionsTimer[i].getCountLocked(j);
    }

    public long getPhoneDataConnectionTime(int i, long l, int j) {
        return mPhoneDataConnectionsTimer[i].getTotalTimeLocked(l, j);
    }

    public long getPhoneOnTime(long l, int i) {
        return mPhoneOnTimer.getTotalTimeLocked(l, i);
    }

    public long getPhoneSignalScanningTime(long l, int i) {
        return mPhoneSignalScanningTimer.getTotalTimeLocked(l, i);
    }

    public int getPhoneSignalStrengthCount(int i, int j) {
        return mPhoneDataConnectionsTimer[i].getCountLocked(j);
    }

    public long getPhoneSignalStrengthTime(int i, long l, int j) {
        return mPhoneSignalStrengthsTimer[i].getTotalTimeLocked(l, j);
    }

    public Uid.Proc getProcessStatsLocked(int i, String s) {
        return getUidStatsLocked(i).getProcessStatsLocked(s);
    }

    public Uid.Proc getProcessStatsLocked(String s, int i) {
        int j;
        if(mUidCache.containsKey(s)) {
            j = ((Integer)mUidCache.get(s)).intValue();
        } else {
            j = Process.getUidForPid(i);
            mUidCache.put(s, Integer.valueOf(j));
        }
        return getUidStatsLocked(j).getProcessStatsLocked(s);
    }

    public long getProcessWakeTime(int i, int j, long l) {
        long l1 = 0L;
        Uid uid = (Uid)mUidStats.get(i);
        if(uid != null) {
            android.os.BatteryStats.Uid.Pid pid = (android.os.BatteryStats.Uid.Pid)uid.mPids.get(j);
            if(pid != null) {
                long l2 = pid.mWakeSum;
                if(pid.mWakeStart != l1)
                    l1 = l - pid.mWakeStart;
                l1 += l2;
            }
        }
        return l1;
    }

    public long getRadioDataUptime() {
        long l;
        if(mRadioDataStart == -1L)
            l = mRadioDataUptime;
        else
            l = getCurrentRadioDataUptime() - mRadioDataStart;
        return l;
    }

    public long getRadioDataUptimeMs() {
        return getRadioDataUptime() / 1000L;
    }

    public long getScreenBrightnessTime(int i, long l, int j) {
        return mScreenBrightnessTimer[i].getTotalTimeLocked(l, j);
    }

    public long getScreenOnTime(long l, int i) {
        return mScreenOnTimer.getTotalTimeLocked(l, i);
    }

    public Uid.Pkg.Serv getServiceStatsLocked(int i, String s, String s1) {
        return getUidStatsLocked(i).getServiceStatsLocked(s, s1);
    }

    public int getStartCount() {
        return mStartCount;
    }

    public long getTotalTcpBytesReceived(int i) {
        return getTcpBytes(getNetworkStatsSummary().getTotal(null).rxBytes, mTotalDataRx, i);
    }

    public long getTotalTcpBytesSent(int i) {
        return getTcpBytes(getNetworkStatsSummary().getTotal(null).txBytes, mTotalDataTx, i);
    }

    public SparseArray getUidStats() {
        return mUidStats;
    }

    public Uid getUidStatsLocked(int i) {
        Uid uid = (Uid)mUidStats.get(i);
        if(uid == null) {
            uid = new Uid(i);
            mUidStats.put(i, uid);
        }
        return uid;
    }

    public long getWifiOnTime(long l, int i) {
        return mWifiOnTimer.getTotalTimeLocked(l, i);
    }

    void initDischarge() {
        mLowDischargeAmountSinceCharge = 0;
        mHighDischargeAmountSinceCharge = 0;
        mDischargeAmountScreenOn = 0;
        mDischargeAmountScreenOnSinceCharge = 0;
        mDischargeAmountScreenOff = 0;
        mDischargeAmountScreenOffSinceCharge = 0;
    }

    void initTimes() {
        mTrackBatteryPastUptime = 0L;
        mBatteryRealtime = 0L;
        mTrackBatteryPastRealtime = 0L;
        mBatteryUptime = 0L;
        long l = 1000L * SystemClock.uptimeMillis();
        mTrackBatteryUptimeStart = l;
        mUptimeStart = l;
        long l1 = 1000L * SystemClock.elapsedRealtime();
        mTrackBatteryRealtimeStart = l1;
        mRealtimeStart = l1;
        mUnpluggedBatteryUptime = getBatteryUptimeLocked(mUptimeStart);
        mUnpluggedBatteryRealtime = getBatteryRealtimeLocked(mRealtimeStart);
    }

    public boolean isOnBattery() {
        return mOnBattery;
    }

    public boolean isScreenOn() {
        return mScreenOn;
    }

    public void noteAudioOffLocked(int i) {
        if(mAudioOn) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0xffbfffff & historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mAudioOn = false;
            mAudioOnTimer.stopRunningLocked(this);
        }
        getUidStatsLocked(i).noteAudioTurnedOffLocked();
    }

    public void noteAudioOnLocked(int i) {
        if(!mAudioOn) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x400000 | historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mAudioOn = true;
            mAudioOnTimer.startRunningLocked(this);
        }
        getUidStatsLocked(i).noteAudioTurnedOnLocked();
    }

    public void noteBluetoothOffLocked() {
        if(mBluetoothOn) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0xfffeffff & historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mBluetoothOn = false;
            mBluetoothOnTimer.stopRunningLocked(this);
        }
    }

    public void noteBluetoothOnLocked() {
        if(!mBluetoothOn) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x10000 | historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mBluetoothOn = true;
            mBluetoothOnTimer.startRunningLocked(this);
        }
    }

    public void noteFullWifiLockAcquiredFromSourceLocked(WorkSource worksource) {
        int i = worksource.size();
        for(int j = 0; j < i; j++)
            noteFullWifiLockAcquiredLocked(worksource.get(j));

    }

    public void noteFullWifiLockAcquiredLocked(int i) {
        if(mWifiFullLockNesting == 0) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x2000000 | historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
        }
        mWifiFullLockNesting = 1 + mWifiFullLockNesting;
        getUidStatsLocked(i).noteFullWifiLockAcquiredLocked();
    }

    public void noteFullWifiLockReleasedFromSourceLocked(WorkSource worksource) {
        int i = worksource.size();
        for(int j = 0; j < i; j++)
            noteFullWifiLockReleasedLocked(worksource.get(j));

    }

    public void noteFullWifiLockReleasedLocked(int i) {
        mWifiFullLockNesting = -1 + mWifiFullLockNesting;
        if(mWifiFullLockNesting == 0) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0xfdffffff & historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
        }
        getUidStatsLocked(i).noteFullWifiLockReleasedLocked();
    }

    public void noteInputEventAtomic() {
        mInputEventCounter.stepAtomic();
    }

    public void noteNetworkInterfaceTypeLocked(String s, int i) {
        if(ConnectivityManager.isNetworkTypeMobile(i))
            mMobileIfaces.add(s);
        else
            mMobileIfaces.remove(s);
    }

    public void notePhoneDataConnectionStateLocked(int i, boolean flag) {
        int j = 0;
        if(!flag) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1 14: default 76
    //                   1 158
    //                   2 153
    //                   3 163
    //                   4 168
    //                   5 173
    //                   6 178
    //                   7 184
    //                   8 190
    //                   9 196
    //                   10 202
    //                   11 208
    //                   12 214
    //                   13 220
    //                   14 226;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L3:
        j = 15;
_L2:
        if(mPhoneDataConnectionType != j) {
            mHistoryCur.states = 0xffff0fff & mHistoryCur.states | j << 12;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            if(mPhoneDataConnectionType >= 0)
                mPhoneDataConnectionsTimer[mPhoneDataConnectionType].stopRunningLocked(this);
            mPhoneDataConnectionType = j;
            mPhoneDataConnectionsTimer[j].startRunningLocked(this);
        }
        return;
_L5:
        j = 2;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 1;
        continue; /* Loop/switch isn't completed */
_L6:
        j = 3;
        continue; /* Loop/switch isn't completed */
_L7:
        j = 4;
        continue; /* Loop/switch isn't completed */
_L8:
        j = 5;
        continue; /* Loop/switch isn't completed */
_L9:
        j = 6;
        continue; /* Loop/switch isn't completed */
_L10:
        j = 7;
        continue; /* Loop/switch isn't completed */
_L11:
        j = 8;
        continue; /* Loop/switch isn't completed */
_L12:
        j = 9;
        continue; /* Loop/switch isn't completed */
_L13:
        j = 10;
        continue; /* Loop/switch isn't completed */
_L14:
        j = 11;
        continue; /* Loop/switch isn't completed */
_L15:
        j = 12;
        continue; /* Loop/switch isn't completed */
_L16:
        j = 13;
        continue; /* Loop/switch isn't completed */
_L17:
        j = 14;
        if(true) goto _L2; else goto _L18
_L18:
    }

    public void notePhoneOffLocked() {
        if(mPhoneOn) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0xfffbffff & historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mPhoneOn = false;
            mPhoneOnTimer.stopRunningLocked(this);
        }
    }

    public void notePhoneOnLocked() {
        if(!mPhoneOn) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x40000 | historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mPhoneOn = true;
            mPhoneOnTimer.startRunningLocked(this);
        }
    }

    public void notePhoneSignalStrengthLocked(SignalStrength signalstrength) {
        int i = signalstrength.getLevel();
        updateAllPhoneStateLocked(mPhoneServiceStateRaw, mPhoneSimStateRaw, i);
    }

    public void notePhoneStateLocked(int i, int j) {
        updateAllPhoneStateLocked(i, j, mPhoneSignalStrengthBinRaw);
    }

    public void noteProcessDiedLocked(int i, int j) {
        Uid uid = (Uid)mUidStats.get(i);
        if(uid != null)
            uid.mPids.remove(j);
    }

    public void noteScanWifiLockAcquiredFromSourceLocked(WorkSource worksource) {
        int i = worksource.size();
        for(int j = 0; j < i; j++)
            noteScanWifiLockAcquiredLocked(worksource.get(j));

    }

    public void noteScanWifiLockAcquiredLocked(int i) {
        if(mWifiScanLockNesting == 0) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x1000000 | historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
        }
        mWifiScanLockNesting = 1 + mWifiScanLockNesting;
        getUidStatsLocked(i).noteScanWifiLockAcquiredLocked();
    }

    public void noteScanWifiLockReleasedFromSourceLocked(WorkSource worksource) {
        int i = worksource.size();
        for(int j = 0; j < i; j++)
            noteScanWifiLockReleasedLocked(worksource.get(j));

    }

    public void noteScanWifiLockReleasedLocked(int i) {
        mWifiScanLockNesting = -1 + mWifiScanLockNesting;
        if(mWifiScanLockNesting == 0) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0xfeffffff & historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
        }
        getUidStatsLocked(i).noteScanWifiLockReleasedLocked();
    }

    public void noteScreenBrightnessLocked(int i) {
        int j = i / 51;
        if(j >= 0) goto _L2; else goto _L1
_L1:
        j = 0;
_L4:
        if(mScreenBrightnessBin != j) {
            mHistoryCur.states = 0xfffffff0 & mHistoryCur.states | j << 0;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            if(mScreenOn) {
                if(mScreenBrightnessBin >= 0)
                    mScreenBrightnessTimer[mScreenBrightnessBin].stopRunningLocked(this);
                mScreenBrightnessTimer[j].startRunningLocked(this);
            }
            mScreenBrightnessBin = j;
        }
        return;
_L2:
        if(j >= 5)
            j = 4;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void noteScreenOffLocked() {
        if(mScreenOn) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0xffefffff & historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mScreenOn = false;
            mScreenOnTimer.stopRunningLocked(this);
            if(mScreenBrightnessBin >= 0)
                mScreenBrightnessTimer[mScreenBrightnessBin].stopRunningLocked(this);
            noteStopWakeLocked(-1, -1, "dummy", 0);
            if(mOnBatteryInternal)
                updateDischargeScreenLevelsLocked(true, false);
        }
    }

    public void noteScreenOnLocked() {
        if(!mScreenOn) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x100000 | historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mScreenOn = true;
            mScreenOnTimer.startRunningLocked(this);
            if(mScreenBrightnessBin >= 0)
                mScreenBrightnessTimer[mScreenBrightnessBin].startRunningLocked(this);
            noteStartWakeLocked(-1, -1, "dummy", 0);
            if(mOnBatteryInternal)
                updateDischargeScreenLevelsLocked(false, true);
        }
    }

    public void noteStartGpsLocked(int i) {
        if(mGpsNesting == 0) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x10000000 | historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
        }
        mGpsNesting = 1 + mGpsNesting;
        getUidStatsLocked(i).noteStartGps();
    }

    public void noteStartSensorLocked(int i, int j) {
        if(mSensorNesting == 0) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x20000000 | historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
        }
        mSensorNesting = 1 + mSensorNesting;
        getUidStatsLocked(i).noteStartSensor(j);
    }

    public void noteStartWakeFromSourceLocked(WorkSource worksource, int i, String s, int j) {
        int k = worksource.size();
        for(int l = 0; l < k; l++)
            noteStartWakeLocked(worksource.get(l), i, s, j);

    }

    public void noteStartWakeLocked(int i, int j, String s, int k) {
        if(k == 0) {
            if(mWakeLockNesting == 0) {
                android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
                historyitem.states = 0x40000000 | historyitem.states;
                addHistoryRecordLocked(SystemClock.elapsedRealtime());
            }
            mWakeLockNesting = 1 + mWakeLockNesting;
        }
        if(i >= 0) {
            if(!mHandler.hasMessages(1)) {
                Message message = mHandler.obtainMessage(1);
                mHandler.sendMessageDelayed(message, 5000L);
            }
            getUidStatsLocked(i).noteStartWakeLocked(j, s, k);
        }
    }

    public void noteStopGpsLocked(int i) {
        mGpsNesting = -1 + mGpsNesting;
        if(mGpsNesting == 0) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0xefffffff & historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
        }
        getUidStatsLocked(i).noteStopGps();
    }

    public void noteStopSensorLocked(int i, int j) {
        mSensorNesting = -1 + mSensorNesting;
        if(mSensorNesting == 0) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0xdfffffff & historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
        }
        getUidStatsLocked(i).noteStopSensor(j);
    }

    public void noteStopWakeFromSourceLocked(WorkSource worksource, int i, String s, int j) {
        int k = worksource.size();
        for(int l = 0; l < k; l++)
            noteStopWakeLocked(worksource.get(l), i, s, j);

    }

    public void noteStopWakeLocked(int i, int j, String s, int k) {
        if(k == 0) {
            mWakeLockNesting = -1 + mWakeLockNesting;
            if(mWakeLockNesting == 0) {
                android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
                historyitem.states = 0xbfffffff & historyitem.states;
                addHistoryRecordLocked(SystemClock.elapsedRealtime());
            }
        }
        if(i >= 0) {
            if(!mHandler.hasMessages(1)) {
                Message message = mHandler.obtainMessage(1);
                mHandler.sendMessageDelayed(message, 5000L);
            }
            getUidStatsLocked(i).noteStopWakeLocked(j, s, k);
        }
    }

    public void noteUserActivityLocked(int i, int j) {
        getUidStatsLocked(i).noteUserActivityLocked(j);
    }

    public void noteVideoOffLocked(int i) {
        if(mVideoOn) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0xffdfffff & historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mVideoOn = false;
            mVideoOnTimer.stopRunningLocked(this);
        }
        getUidStatsLocked(i).noteVideoTurnedOffLocked();
    }

    public void noteVideoOnLocked(int i) {
        if(!mVideoOn) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x200000 | historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mVideoOn = true;
            mVideoOnTimer.startRunningLocked(this);
        }
        getUidStatsLocked(i).noteVideoTurnedOnLocked();
    }

    public void noteWifiMulticastDisabledFromSourceLocked(WorkSource worksource) {
        int i = worksource.size();
        for(int j = 0; j < i; j++)
            noteWifiMulticastDisabledLocked(worksource.get(j));

    }

    public void noteWifiMulticastDisabledLocked(int i) {
        mWifiMulticastNesting = -1 + mWifiMulticastNesting;
        if(mWifiMulticastNesting == 0) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0xff7fffff & historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
        }
        getUidStatsLocked(i).noteWifiMulticastDisabledLocked();
    }

    public void noteWifiMulticastEnabledFromSourceLocked(WorkSource worksource) {
        int i = worksource.size();
        for(int j = 0; j < i; j++)
            noteWifiMulticastEnabledLocked(worksource.get(j));

    }

    public void noteWifiMulticastEnabledLocked(int i) {
        if(mWifiMulticastNesting == 0) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x800000 | historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
        }
        mWifiMulticastNesting = 1 + mWifiMulticastNesting;
        getUidStatsLocked(i).noteWifiMulticastEnabledLocked();
    }

    public void noteWifiOffLocked() {
        if(mWifiOn) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0xfffdffff & historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mWifiOn = false;
            mWifiOnTimer.stopRunningLocked(this);
        }
        if(mWifiOnUid >= 0) {
            getUidStatsLocked(mWifiOnUid).noteWifiStoppedLocked();
            mWifiOnUid = -1;
        }
    }

    public void noteWifiOnLocked() {
        if(!mWifiOn) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x20000 | historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mWifiOn = true;
            mWifiOnTimer.startRunningLocked(this);
        }
    }

    public void noteWifiRunningChangedLocked(WorkSource worksource, WorkSource worksource1) {
        if(mGlobalWifiRunning) {
            int i = worksource.size();
            for(int j = 0; j < i; j++)
                getUidStatsLocked(worksource.get(j)).noteWifiStoppedLocked();

            int k = worksource1.size();
            for(int l = 0; l < k; l++)
                getUidStatsLocked(worksource1.get(l)).noteWifiRunningLocked();

        } else {
            Log.w("BatteryStatsImpl", "noteWifiRunningChangedLocked -- called while WIFI not running");
        }
    }

    public void noteWifiRunningLocked(WorkSource worksource) {
        if(!mGlobalWifiRunning) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x4000000 | historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mGlobalWifiRunning = true;
            mGlobalWifiRunningTimer.startRunningLocked(this);
            int i = worksource.size();
            for(int j = 0; j < i; j++)
                getUidStatsLocked(worksource.get(j)).noteWifiRunningLocked();

        } else {
            Log.w("BatteryStatsImpl", "noteWifiRunningLocked -- called while WIFI running");
        }
    }

    public void noteWifiStoppedLocked(WorkSource worksource) {
        if(mGlobalWifiRunning) {
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0xfbffffff & historyitem.states;
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
            mGlobalWifiRunning = false;
            mGlobalWifiRunningTimer.stopRunningLocked(this);
            int i = worksource.size();
            for(int j = 0; j < i; j++)
                getUidStatsLocked(worksource.get(j)).noteWifiStoppedLocked();

        } else {
            Log.w("BatteryStatsImpl", "noteWifiStoppedLocked -- called while WIFI not running");
        }
    }

    public void prepareForDumpLocked() {
        updateKernelWakelocksLocked();
    }

    public void readFromParcel(Parcel parcel) {
        readFromParcelLocked(parcel);
    }

    void readFromParcelLocked(Parcel parcel) {
        if(parcel.readInt() != 0xba757475)
            throw new ParcelFormatException("Bad magic number");
        readHistory(parcel, false);
        mStartCount = parcel.readInt();
        mBatteryUptime = parcel.readLong();
        mBatteryLastUptime = 0L;
        mBatteryRealtime = parcel.readLong();
        mBatteryLastRealtime = 0L;
        mScreenOn = false;
        mScreenOnTimer = new StopwatchTimer(null, -1, null, mUnpluggables, parcel);
        for(int i = 0; i < 5; i++)
            mScreenBrightnessTimer[i] = new StopwatchTimer(null, -100 - i, null, mUnpluggables, parcel);

        mInputEventCounter = new Counter(mUnpluggables, parcel);
        mPhoneOn = false;
        mPhoneOnTimer = new StopwatchTimer(null, -2, null, mUnpluggables, parcel);
        for(int j = 0; j < 5; j++)
            mPhoneSignalStrengthsTimer[j] = new StopwatchTimer(null, -200 - j, null, mUnpluggables, parcel);

        mPhoneSignalScanningTimer = new StopwatchTimer(null, -199, null, mUnpluggables, parcel);
        for(int k = 0; k < 16; k++)
            mPhoneDataConnectionsTimer[k] = new StopwatchTimer(null, -300 - k, null, mUnpluggables, parcel);

        mWifiOn = false;
        mWifiOnTimer = new StopwatchTimer(null, -2, null, mUnpluggables, parcel);
        mGlobalWifiRunning = false;
        mGlobalWifiRunningTimer = new StopwatchTimer(null, -2, null, mUnpluggables, parcel);
        mBluetoothOn = false;
        mBluetoothOnTimer = new StopwatchTimer(null, -2, null, mUnpluggables, parcel);
        mUptime = parcel.readLong();
        mUptimeStart = parcel.readLong();
        mLastUptime = 0L;
        mRealtime = parcel.readLong();
        mRealtimeStart = parcel.readLong();
        mLastRealtime = 0L;
        boolean flag;
        int l;
        if(parcel.readInt() != 0)
            flag = true;
        else
            flag = false;
        mOnBattery = flag;
        mOnBatteryInternal = false;
        mTrackBatteryPastUptime = parcel.readLong();
        mTrackBatteryUptimeStart = parcel.readLong();
        mTrackBatteryPastRealtime = parcel.readLong();
        mTrackBatteryRealtimeStart = parcel.readLong();
        mUnpluggedBatteryUptime = parcel.readLong();
        mUnpluggedBatteryRealtime = parcel.readLong();
        mDischargeUnplugLevel = parcel.readInt();
        mDischargeCurrentLevel = parcel.readInt();
        mLowDischargeAmountSinceCharge = parcel.readInt();
        mHighDischargeAmountSinceCharge = parcel.readInt();
        mDischargeAmountScreenOn = parcel.readInt();
        mDischargeAmountScreenOnSinceCharge = parcel.readInt();
        mDischargeAmountScreenOff = parcel.readInt();
        mDischargeAmountScreenOffSinceCharge = parcel.readInt();
        mLastWriteTime = parcel.readLong();
        mMobileDataRx[1] = parcel.readLong();
        mMobileDataRx[3] = -1L;
        mMobileDataTx[1] = parcel.readLong();
        mMobileDataTx[3] = -1L;
        mTotalDataRx[1] = parcel.readLong();
        mTotalDataRx[3] = -1L;
        mTotalDataTx[1] = parcel.readLong();
        mTotalDataTx[3] = -1L;
        mRadioDataUptime = parcel.readLong();
        mRadioDataStart = -1L;
        mBluetoothPingCount = parcel.readInt();
        mBluetoothPingStart = -1;
        mKernelWakelockStats.clear();
        l = parcel.readInt();
        for(int i1 = 0; i1 < l; i1++)
            if(parcel.readInt() != 0) {
                String s = parcel.readString();
                parcel.readInt();
                SamplingTimer samplingtimer = new SamplingTimer(mUnpluggables, mOnBattery, parcel);
                mKernelWakelockStats.put(s, samplingtimer);
            }

        mPartialTimers.clear();
        mFullTimers.clear();
        mWindowTimers.clear();
        mWifiRunningTimers.clear();
        mFullWifiLockTimers.clear();
        mScanWifiLockTimers.clear();
        mWifiMulticastTimers.clear();
        sNumSpeedSteps = parcel.readInt();
        int j1 = parcel.readInt();
        mUidStats.clear();
        for(int k1 = 0; k1 < j1; k1++) {
            int l1 = parcel.readInt();
            Uid uid = new Uid(l1);
            uid.readFromParcelLocked(mUnpluggables, parcel);
            mUidStats.append(l1, uid);
        }

    }

    void readHistory(Parcel parcel, boolean flag) {
        long l = parcel.readLong();
        mHistoryBuffer.setDataSize(0);
        mHistoryBuffer.setDataPosition(0);
        int i = parcel.readInt();
        int j = parcel.dataPosition();
        if(i >= 0x6c000)
            Slog.w("BatteryStatsImpl", (new StringBuilder()).append("File corrupt: history data buffer too large ").append(i).toString());
        else
        if((i & -4) != i) {
            Slog.w("BatteryStatsImpl", (new StringBuilder()).append("File corrupt: history data buffer not aligned ").append(i).toString());
        } else {
            mHistoryBuffer.appendFrom(parcel, j, i);
            parcel.setDataPosition(j + i);
        }
        if(flag)
            readOldHistory(parcel);
        mHistoryBaseTime = l;
        if(mHistoryBaseTime > 0L) {
            long l1 = SystemClock.elapsedRealtime();
            mHistoryBaseTime = 60000L + (mHistoryBaseTime - l1);
        }
    }

    public void readLocked() {
        if(mFile != null) goto _L2; else goto _L1
_L1:
        Slog.w("BatteryStats", "readLocked: no file associated with this instance");
_L4:
        return;
_L2:
        mUidStats.clear();
        File file = mFile.chooseForRead();
        if(!file.exists()) goto _L4; else goto _L3
_L3:
        FileInputStream fileinputstream = new FileInputStream(file);
        byte abyte0[] = readFully(fileinputstream);
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        fileinputstream.close();
        readSummaryFromParcel(parcel);
_L5:
        addHistoryBufferLocked(SystemClock.elapsedRealtime(), (byte)2);
          goto _L4
        IOException ioexception;
        ioexception;
        Slog.e("BatteryStats", "Error reading battery statistics", ioexception);
          goto _L5
    }

    void readOldHistory(Parcel parcel) {
    }

    public void removeUidStatsLocked(int i) {
        mUidStats.remove(i);
    }

    public void reportExcessiveCpuLocked(int i, String s, long l, long l1) {
        Uid uid = (Uid)mUidStats.get(i);
        if(uid != null)
            uid.reportExcessiveCpuLocked(s, l, l1);
    }

    public void reportExcessiveWakeLocked(int i, String s, long l, long l1) {
        Uid uid = (Uid)mUidStats.get(i);
        if(uid != null)
            uid.reportExcessiveWakeLocked(s, l, l1);
    }

    public void resetAllStatsLocked() {
        mStartCount = 0;
        initTimes();
        mScreenOnTimer.reset(this, false);
        for(int i = 0; i < 5; i++)
            mScreenBrightnessTimer[i].reset(this, false);

        mInputEventCounter.reset(false);
        mPhoneOnTimer.reset(this, false);
        mAudioOnTimer.reset(this, false);
        mVideoOnTimer.reset(this, false);
        for(int j = 0; j < 5; j++)
            mPhoneSignalStrengthsTimer[j].reset(this, false);

        mPhoneSignalScanningTimer.reset(this, false);
        for(int k = 0; k < 16; k++)
            mPhoneDataConnectionsTimer[k].reset(this, false);

        mWifiOnTimer.reset(this, false);
        mGlobalWifiRunningTimer.reset(this, false);
        mBluetoothOnTimer.reset(this, false);
        for(int l = 0; l < mUidStats.size(); l++)
            if(((Uid)mUidStats.valueAt(l)).reset()) {
                mUidStats.remove(mUidStats.keyAt(l));
                l--;
            }

        if(mKernelWakelockStats.size() > 0) {
            SamplingTimer samplingtimer;
            for(Iterator iterator = mKernelWakelockStats.values().iterator(); iterator.hasNext(); mUnpluggables.remove(samplingtimer))
                samplingtimer = (SamplingTimer)iterator.next();

            mKernelWakelockStats.clear();
        }
        initDischarge();
        clearHistoryLocked();
    }

    public void setBatteryState(int i, int j, int k, int l, int i1, int j1) {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        int k1;
        boolean flag1;
        android.os.BatteryStats.HistoryItem historyitem;
        android.os.BatteryStats.HistoryItem historyitem1;
        if(k != 0)
            flag = false;
        k1 = mHistoryCur.batteryStatus;
        if(mHaveBatteryLevel) goto _L2; else goto _L1
_L1:
        mHaveBatteryLevel = true;
        if(flag == mOnBattery)
            if(flag) {
                historyitem1 = mHistoryCur;
                historyitem1.states = 0xfff7ffff & historyitem1.states;
            } else {
                historyitem = mHistoryCur;
                historyitem.states = 0x80000 | historyitem.states;
            }
          goto _L3
_L2:
        if(flag) {
            mDischargeCurrentLevel = l;
            mRecordingHistory = true;
        }
        if(flag == mOnBattery) goto _L5; else goto _L4
_L4:
        mHistoryCur.batteryLevel = l;
        mHistoryCur.batteryStatus = i;
        mHistoryCur.batteryHealth = j;
        mHistoryCur.batteryPlugType = k;
        mHistoryCur.batteryTemperature = (char)i1;
        mHistoryCur.batteryVoltage = (char)j1;
        setOnBatteryLocked(flag, k1, l);
_L6:
        if(!flag && i == 5)
            mRecordingHistory = false;
        return;
        exception;
        throw exception;
_L5:
        flag1 = false;
        if(mHistoryCur.batteryLevel != l) {
            mHistoryCur.batteryLevel = l;
            flag1 = true;
        }
        if(mHistoryCur.batteryStatus != i) {
            mHistoryCur.batteryStatus = i;
            flag1 = true;
        }
        if(mHistoryCur.batteryHealth != j) {
            mHistoryCur.batteryHealth = j;
            flag1 = true;
        }
        if(mHistoryCur.batteryPlugType != k) {
            mHistoryCur.batteryPlugType = k;
            flag1 = true;
        }
        if(i1 >= 10 + mHistoryCur.batteryTemperature || i1 <= -10 + mHistoryCur.batteryTemperature) {
            mHistoryCur.batteryTemperature = (char)i1;
            flag1 = true;
        }
        if(j1 > 20 + mHistoryCur.batteryVoltage || j1 < -20 + mHistoryCur.batteryVoltage) {
            mHistoryCur.batteryVoltage = (char)j1;
            flag1 = true;
        }
        if(flag1)
            addHistoryRecordLocked(SystemClock.elapsedRealtime());
        if(true) goto _L6; else goto _L3
_L3:
        k1 = i;
        if(true) goto _L2; else goto _L7
_L7:
    }

    public void setBtHeadset(BluetoothHeadset bluetoothheadset) {
        if(bluetoothheadset != null && mBtHeadset == null && isOnBattery() && mBluetoothPingStart == -1)
            mBluetoothPingStart = getCurrentBluetoothPingCount();
        mBtHeadset = bluetoothheadset;
    }

    public void setCallback(BatteryCallback batterycallback) {
        mCallback = batterycallback;
    }

    public void setNumSpeedSteps(int i) {
        if(sNumSpeedSteps == 0)
            sNumSpeedSteps = i;
    }

    void setOnBattery(boolean flag, int i, int j) {
        this;
        JVM INSTR monitorenter ;
        setOnBatteryLocked(flag, i, j);
        return;
    }

    void setOnBatteryLocked(boolean flag, int i, int j) {
        boolean flag1 = false;
        Message message = mHandler.obtainMessage(2);
        int k;
        long l;
        long l1;
        long l2;
        if(flag)
            k = 1;
        else
            k = 0;
        message.arg1 = k;
        mHandler.sendMessage(message);
        mOnBatteryInternal = flag;
        mOnBattery = flag;
        l = 1000L * SystemClock.uptimeMillis();
        l1 = SystemClock.elapsedRealtime();
        l2 = l1 * 1000L;
        if(flag) {
            if(i == 5 || j >= 90 || mDischargeCurrentLevel < 20 && j >= 80) {
                flag1 = true;
                resetAllStatsLocked();
                mDischargeStartLevel = j;
            }
            updateKernelWakelocksLocked();
            mHistoryCur.batteryLevel = (byte)j;
            android.os.BatteryStats.HistoryItem historyitem1 = mHistoryCur;
            historyitem1.states = 0xfff7ffff & historyitem1.states;
            addHistoryRecordLocked(l1);
            mTrackBatteryUptimeStart = l;
            mTrackBatteryRealtimeStart = l2;
            mUnpluggedBatteryUptime = getBatteryUptimeLocked(l);
            mUnpluggedBatteryRealtime = getBatteryRealtimeLocked(l2);
            mDischargeUnplugLevel = j;
            mDischargeCurrentLevel = j;
            if(mScreenOn) {
                mDischargeScreenOnUnplugLevel = j;
                mDischargeScreenOffUnplugLevel = 0;
            } else {
                mDischargeScreenOnUnplugLevel = 0;
                mDischargeScreenOffUnplugLevel = j;
            }
            mDischargeAmountScreenOn = 0;
            mDischargeAmountScreenOff = 0;
            doUnplugLocked(mUnpluggedBatteryUptime, mUnpluggedBatteryRealtime);
        } else {
            updateKernelWakelocksLocked();
            mHistoryCur.batteryLevel = (byte)j;
            android.os.BatteryStats.HistoryItem historyitem = mHistoryCur;
            historyitem.states = 0x80000 | historyitem.states;
            addHistoryRecordLocked(l1);
            mTrackBatteryPastUptime = mTrackBatteryPastUptime + (l - mTrackBatteryUptimeStart);
            mTrackBatteryPastRealtime = mTrackBatteryPastRealtime + (l2 - mTrackBatteryRealtimeStart);
            mDischargeCurrentLevel = j;
            if(j < mDischargeUnplugLevel) {
                mLowDischargeAmountSinceCharge = mLowDischargeAmountSinceCharge + (-1 + (mDischargeUnplugLevel - j));
                mHighDischargeAmountSinceCharge = mHighDischargeAmountSinceCharge + (mDischargeUnplugLevel - j);
            }
            updateDischargeScreenLevelsLocked(mScreenOn, mScreenOn);
            doPlugLocked(getBatteryUptimeLocked(l), getBatteryRealtimeLocked(l2));
        }
        if((flag1 || 60000L + mLastWriteTime < l1) && mFile != null)
            writeAsyncLocked();
    }

    public void setRadioScanningTimeout(long l) {
        if(mPhoneSignalScanningTimer != null)
            mPhoneSignalScanningTimer.setTimeout(l);
    }

    public void shutdownLocked() {
        writeSyncLocked();
        mShuttingDown = true;
    }

    public int startAddingCpuLocked() {
        int i;
        i = 0;
        mHandler.removeMessages(1);
        if(!mScreenOn) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        int j;
        int k;
        j = mPartialTimers.size();
        if(j == 0) {
            mLastPartialTimers.clear();
            continue; /* Loop/switch isn't completed */
        }
        k = 0;
_L4:
        if(k < j) {
label0:
            {
                StopwatchTimer stopwatchtimer = (StopwatchTimer)mPartialTimers.get(k);
                if(!stopwatchtimer.mInList)
                    break label0;
                Uid uid = stopwatchtimer.mUid;
                if(uid == null || uid.mUid == 1000)
                    break label0;
                i = 50;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
        k++;
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    public boolean startIteratingHistoryLocked() {
        boolean flag = true;
        mHistoryBuffer.setDataPosition(0);
        mReadOverflow = false;
        mIteratingHistory = flag;
        if(mHistoryBuffer.dataSize() <= 0)
            flag = false;
        return flag;
    }

    public boolean startIteratingOldHistoryLocked() {
        boolean flag = true;
        mHistoryBuffer.setDataPosition(0);
        mHistoryReadTmp.clear();
        mReadOverflow = false;
        mIteratingHistory = flag;
        android.os.BatteryStats.HistoryItem historyitem = mHistory;
        mHistoryIterator = historyitem;
        if(historyitem == null)
            flag = false;
        return flag;
    }

    void stopAllSignalStrengthTimersLocked(int i) {
        int j = 0;
        while(j < 5)  {
            if(j != i)
                while(mPhoneSignalStrengthsTimer[j].isRunningLocked()) 
                    mPhoneSignalStrengthsTimer[j].stopRunningLocked(this);
            j++;
        }
    }

    void updateDischargeScreenLevelsLocked(boolean flag, boolean flag1) {
        if(flag) {
            int j = mDischargeScreenOnUnplugLevel - mDischargeCurrentLevel;
            if(j > 0) {
                mDischargeAmountScreenOn = j + mDischargeAmountScreenOn;
                mDischargeAmountScreenOnSinceCharge = j + mDischargeAmountScreenOnSinceCharge;
            }
        } else {
            int i = mDischargeScreenOffUnplugLevel - mDischargeCurrentLevel;
            if(i > 0) {
                mDischargeAmountScreenOff = i + mDischargeAmountScreenOff;
                mDischargeAmountScreenOffSinceCharge = i + mDischargeAmountScreenOffSinceCharge;
            }
        }
        if(flag1) {
            mDischargeScreenOnUnplugLevel = mDischargeCurrentLevel;
            mDischargeScreenOffUnplugLevel = 0;
        } else {
            mDischargeScreenOnUnplugLevel = 0;
            mDischargeScreenOffUnplugLevel = mDischargeCurrentLevel;
        }
    }

    public void updateKernelWakelocksLocked() {
        Map map = readKernelWakelockStats();
        if(map == null) {
            Slog.w("BatteryStatsImpl", "Couldn't get kernel wake lock stats");
        } else {
            SamplingTimer samplingtimer1;
            for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); samplingtimer1.setUpdateVersion(sKernelWakelockUpdateVersion)) {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                String s = (String)entry.getKey();
                KernelWakelockStats kernelwakelockstats = (KernelWakelockStats)entry.getValue();
                samplingtimer1 = (SamplingTimer)mKernelWakelockStats.get(s);
                if(samplingtimer1 == null) {
                    samplingtimer1 = new SamplingTimer(mUnpluggables, mOnBatteryInternal, true);
                    mKernelWakelockStats.put(s, samplingtimer1);
                }
                samplingtimer1.updateCurrentReportedCount(kernelwakelockstats.mCount);
                samplingtimer1.updateCurrentReportedTotalTime(kernelwakelockstats.mTotalTime);
            }

            if(map.size() != mKernelWakelockStats.size()) {
                Iterator iterator1 = mKernelWakelockStats.entrySet().iterator();
                while(iterator1.hasNext())  {
                    SamplingTimer samplingtimer = (SamplingTimer)((java.util.Map.Entry)iterator1.next()).getValue();
                    if(samplingtimer.getUpdateVersion() != sKernelWakelockUpdateVersion)
                        samplingtimer.setStale();
                }
            }
        }
    }

    public void writeAsyncLocked() {
        writeLocked(false);
    }

    void writeHistory(Parcel parcel, boolean flag) {
        parcel.writeLong(mHistoryBaseTime + mLastHistoryTime);
        parcel.writeInt(mHistoryBuffer.dataSize());
        parcel.appendFrom(mHistoryBuffer, 0, mHistoryBuffer.dataSize());
        if(flag)
            writeOldHistory(parcel);
    }

    void writeLocked(boolean flag) {
        if(mFile != null) goto _L2; else goto _L1
_L1:
        Slog.w("BatteryStats", "writeLocked: no file associated with this instance");
_L4:
        return;
_L2:
        if(!mShuttingDown) {
            Parcel parcel = Parcel.obtain();
            writeSummaryToParcel(parcel);
            mLastWriteTime = SystemClock.elapsedRealtime();
            if(mPendingWrite != null)
                mPendingWrite.recycle();
            mPendingWrite = parcel;
            if(flag)
                commitPendingDataToDisk();
            else
                (new Thread("BatteryStats-Write") {

                    public void run() {
                        Process.setThreadPriority(10);
                        commitPendingDataToDisk();
                    }

                    final BatteryStatsImpl this$0;

             {
                this$0 = BatteryStatsImpl.this;
                super(s);
            }
                }).start();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    void writeOldHistory(Parcel parcel) {
    }

    public void writeSummaryToParcel(Parcel parcel) {
        updateKernelWakelocksLocked();
        long l = 1000L * SystemClock.uptimeMillis();
        long l1 = 1000L * SystemClock.elapsedRealtime();
        long l2 = getBatteryUptimeLocked(l);
        long l3 = getBatteryRealtimeLocked(l1);
        parcel.writeInt(61);
        writeHistory(parcel, true);
        parcel.writeInt(mStartCount);
        parcel.writeLong(computeBatteryUptime(l, 0));
        parcel.writeLong(computeBatteryRealtime(l1, 0));
        parcel.writeLong(computeUptime(l, 0));
        parcel.writeLong(computeRealtime(l1, 0));
        parcel.writeInt(mDischargeUnplugLevel);
        parcel.writeInt(mDischargeCurrentLevel);
        parcel.writeInt(getLowDischargeAmountSinceCharge());
        parcel.writeInt(getHighDischargeAmountSinceCharge());
        parcel.writeInt(getDischargeAmountScreenOnSinceCharge());
        parcel.writeInt(getDischargeAmountScreenOffSinceCharge());
        mScreenOnTimer.writeSummaryFromParcelLocked(parcel, l3);
        for(int i = 0; i < 5; i++)
            mScreenBrightnessTimer[i].writeSummaryFromParcelLocked(parcel, l3);

        mInputEventCounter.writeSummaryFromParcelLocked(parcel);
        mPhoneOnTimer.writeSummaryFromParcelLocked(parcel, l3);
        for(int j = 0; j < 5; j++)
            mPhoneSignalStrengthsTimer[j].writeSummaryFromParcelLocked(parcel, l3);

        mPhoneSignalScanningTimer.writeSummaryFromParcelLocked(parcel, l3);
        for(int k = 0; k < 16; k++)
            mPhoneDataConnectionsTimer[k].writeSummaryFromParcelLocked(parcel, l3);

        mWifiOnTimer.writeSummaryFromParcelLocked(parcel, l3);
        mGlobalWifiRunningTimer.writeSummaryFromParcelLocked(parcel, l3);
        mBluetoothOnTimer.writeSummaryFromParcelLocked(parcel, l3);
        parcel.writeInt(mKernelWakelockStats.size());
        for(Iterator iterator = mKernelWakelockStats.entrySet().iterator(); iterator.hasNext();) {
            java.util.Map.Entry entry5 = (java.util.Map.Entry)iterator.next();
            if((Timer)entry5.getValue() != null) {
                parcel.writeInt(1);
                parcel.writeString((String)entry5.getKey());
                ((SamplingTimer)entry5.getValue()).writeSummaryFromParcelLocked(parcel, l3);
            } else {
                parcel.writeInt(0);
            }
        }

        parcel.writeInt(sNumSpeedSteps);
        int i1 = mUidStats.size();
        parcel.writeInt(i1);
        for(int j1 = 0; j1 < i1; j1++) {
            parcel.writeInt(mUidStats.keyAt(j1));
            Uid uid = (Uid)mUidStats.valueAt(j1);
            int i2;
            if(uid.mWifiRunningTimer != null) {
                parcel.writeInt(1);
                uid.mWifiRunningTimer.writeSummaryFromParcelLocked(parcel, l3);
            } else {
                parcel.writeInt(0);
            }
            if(uid.mFullWifiLockTimer != null) {
                parcel.writeInt(1);
                uid.mFullWifiLockTimer.writeSummaryFromParcelLocked(parcel, l3);
            } else {
                parcel.writeInt(0);
            }
            if(uid.mScanWifiLockTimer != null) {
                parcel.writeInt(1);
                uid.mScanWifiLockTimer.writeSummaryFromParcelLocked(parcel, l3);
            } else {
                parcel.writeInt(0);
            }
            if(uid.mWifiMulticastTimer != null) {
                parcel.writeInt(1);
                uid.mWifiMulticastTimer.writeSummaryFromParcelLocked(parcel, l3);
            } else {
                parcel.writeInt(0);
            }
            if(uid.mAudioTurnedOnTimer != null) {
                parcel.writeInt(1);
                uid.mAudioTurnedOnTimer.writeSummaryFromParcelLocked(parcel, l3);
            } else {
                parcel.writeInt(0);
            }
            if(uid.mVideoTurnedOnTimer != null) {
                parcel.writeInt(1);
                uid.mVideoTurnedOnTimer.writeSummaryFromParcelLocked(parcel, l3);
            } else {
                parcel.writeInt(0);
            }
            if(uid.mUserActivityCounters == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                int k1 = 0;
                while(k1 < 7)  {
                    uid.mUserActivityCounters[k1].writeSummaryFromParcelLocked(parcel);
                    k1++;
                }
            }
            i2 = uid.mWakelockStats.size();
            parcel.writeInt(i2);
            if(i2 > 0) {
                for(Iterator iterator5 = uid.mWakelockStats.entrySet().iterator(); iterator5.hasNext();) {
                    java.util.Map.Entry entry4 = (java.util.Map.Entry)iterator5.next();
                    parcel.writeString((String)entry4.getKey());
                    Uid.Wakelock wakelock = (Uid.Wakelock)entry4.getValue();
                    if(wakelock.mTimerFull != null) {
                        parcel.writeInt(1);
                        wakelock.mTimerFull.writeSummaryFromParcelLocked(parcel, l3);
                    } else {
                        parcel.writeInt(0);
                    }
                    if(wakelock.mTimerPartial != null) {
                        parcel.writeInt(1);
                        wakelock.mTimerPartial.writeSummaryFromParcelLocked(parcel, l3);
                    } else {
                        parcel.writeInt(0);
                    }
                    if(wakelock.mTimerWindow != null) {
                        parcel.writeInt(1);
                        wakelock.mTimerWindow.writeSummaryFromParcelLocked(parcel, l3);
                    } else {
                        parcel.writeInt(0);
                    }
                }

            }
            int j2 = uid.mSensorStats.size();
            parcel.writeInt(j2);
            if(j2 > 0) {
                for(Iterator iterator4 = uid.mSensorStats.entrySet().iterator(); iterator4.hasNext();) {
                    java.util.Map.Entry entry3 = (java.util.Map.Entry)iterator4.next();
                    parcel.writeInt(((Integer)entry3.getKey()).intValue());
                    Uid.Sensor sensor = (Uid.Sensor)entry3.getValue();
                    if(sensor.mTimer != null) {
                        parcel.writeInt(1);
                        sensor.mTimer.writeSummaryFromParcelLocked(parcel, l3);
                    } else {
                        parcel.writeInt(0);
                    }
                }

            }
            int k2 = uid.mProcessStats.size();
            parcel.writeInt(k2);
            if(k2 > 0) {
                Uid.Proc proc;
                for(Iterator iterator3 = uid.mProcessStats.entrySet().iterator(); iterator3.hasNext(); proc.writeExcessivePowerToParcelLocked(parcel)) {
                    java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator3.next();
                    parcel.writeString((String)entry2.getKey());
                    proc = (Uid.Proc)entry2.getValue();
                    parcel.writeLong(proc.mUserTime);
                    parcel.writeLong(proc.mSystemTime);
                    parcel.writeInt(proc.mStarts);
                    int k3 = proc.mSpeedBins.length;
                    parcel.writeInt(k3);
                    int i4 = 0;
                    while(i4 < k3)  {
                        if(proc.mSpeedBins[i4] != null) {
                            parcel.writeInt(1);
                            proc.mSpeedBins[i4].writeSummaryFromParcelLocked(parcel);
                        } else {
                            parcel.writeInt(0);
                        }
                        i4++;
                    }
                }

            }
            int i3 = uid.mPackageStats.size();
            parcel.writeInt(i3);
            if(i3 > 0) {
                Iterator iterator1 = uid.mPackageStats.entrySet().iterator();
                do {
                    if(!iterator1.hasNext())
                        break;
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                    parcel.writeString((String)entry.getKey());
                    Uid.Pkg pkg = (Uid.Pkg)entry.getValue();
                    parcel.writeInt(pkg.mWakeups);
                    int j3 = pkg.mServiceStats.size();
                    parcel.writeInt(j3);
                    if(j3 > 0) {
                        Iterator iterator2 = pkg.mServiceStats.entrySet().iterator();
                        while(iterator2.hasNext())  {
                            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator2.next();
                            parcel.writeString((String)entry1.getKey());
                            Uid.Pkg.Serv serv = (Uid.Pkg.Serv)entry1.getValue();
                            parcel.writeLong(serv.getStartTimeToNowLocked(l2));
                            parcel.writeInt(serv.mStarts);
                            parcel.writeInt(serv.mLaunches);
                        }
                    }
                } while(true);
            }
            parcel.writeLong(uid.getTcpBytesReceived(0));
            parcel.writeLong(uid.getTcpBytesSent(0));
        }

    }

    public void writeSyncLocked() {
        writeLocked(true);
    }

    public void writeToParcel(Parcel parcel, int i) {
        writeToParcelLocked(parcel, true, i);
    }

    void writeToParcelLocked(Parcel parcel, boolean flag, int i) {
        updateKernelWakelocksLocked();
        long l = 1000L * SystemClock.uptimeMillis();
        long l1 = 1000L * SystemClock.elapsedRealtime();
        long l2 = getBatteryUptimeLocked(l);
        long l3 = getBatteryRealtimeLocked(l1);
        parcel.writeInt(0xba757475);
        writeHistory(parcel, false);
        parcel.writeInt(mStartCount);
        parcel.writeLong(mBatteryUptime);
        parcel.writeLong(mBatteryRealtime);
        mScreenOnTimer.writeToParcel(parcel, l3);
        for(int j = 0; j < 5; j++)
            mScreenBrightnessTimer[j].writeToParcel(parcel, l3);

        mInputEventCounter.writeToParcel(parcel);
        mPhoneOnTimer.writeToParcel(parcel, l3);
        for(int k = 0; k < 5; k++)
            mPhoneSignalStrengthsTimer[k].writeToParcel(parcel, l3);

        mPhoneSignalScanningTimer.writeToParcel(parcel, l3);
        for(int i1 = 0; i1 < 16; i1++)
            mPhoneDataConnectionsTimer[i1].writeToParcel(parcel, l3);

        mWifiOnTimer.writeToParcel(parcel, l3);
        mGlobalWifiRunningTimer.writeToParcel(parcel, l3);
        mBluetoothOnTimer.writeToParcel(parcel, l3);
        parcel.writeLong(mUptime);
        parcel.writeLong(mUptimeStart);
        parcel.writeLong(mRealtime);
        parcel.writeLong(mRealtimeStart);
        int j1;
        if(mOnBattery)
            j1 = 1;
        else
            j1 = 0;
        parcel.writeInt(j1);
        parcel.writeLong(l2);
        parcel.writeLong(mTrackBatteryUptimeStart);
        parcel.writeLong(l3);
        parcel.writeLong(mTrackBatteryRealtimeStart);
        parcel.writeLong(mUnpluggedBatteryUptime);
        parcel.writeLong(mUnpluggedBatteryRealtime);
        parcel.writeInt(mDischargeUnplugLevel);
        parcel.writeInt(mDischargeCurrentLevel);
        parcel.writeInt(mLowDischargeAmountSinceCharge);
        parcel.writeInt(mHighDischargeAmountSinceCharge);
        parcel.writeInt(mDischargeAmountScreenOn);
        parcel.writeInt(mDischargeAmountScreenOnSinceCharge);
        parcel.writeInt(mDischargeAmountScreenOff);
        parcel.writeInt(mDischargeAmountScreenOffSinceCharge);
        parcel.writeLong(mLastWriteTime);
        parcel.writeLong(getMobileTcpBytesReceived(3));
        parcel.writeLong(getMobileTcpBytesSent(3));
        parcel.writeLong(getTotalTcpBytesReceived(3));
        parcel.writeLong(getTotalTcpBytesSent(3));
        parcel.writeLong(getRadioDataUptime());
        parcel.writeInt(getBluetoothPingCount());
        if(flag) {
            parcel.writeInt(mKernelWakelockStats.size());
            for(Iterator iterator = mKernelWakelockStats.entrySet().iterator(); iterator.hasNext();) {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                SamplingTimer samplingtimer = (SamplingTimer)entry.getValue();
                if(samplingtimer != null) {
                    parcel.writeInt(1);
                    parcel.writeString((String)entry.getKey());
                    Timer.writeTimerToParcel(parcel, samplingtimer, l3);
                } else {
                    parcel.writeInt(0);
                }
            }

        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(sNumSpeedSteps);
        if(flag) {
            int k1 = mUidStats.size();
            parcel.writeInt(k1);
            for(int i2 = 0; i2 < k1; i2++) {
                parcel.writeInt(mUidStats.keyAt(i2));
                ((Uid)mUidStats.valueAt(i2)).writeToParcelLocked(parcel, l3);
            }

        } else {
            parcel.writeInt(0);
        }
    }

    public void writeToParcelWithoutUids(Parcel parcel, int i) {
        writeToParcelLocked(parcel, false, i);
    }

    private static final String BATCHED_WAKELOCK_NAME = "*overflow*";
    private static final int BATTERY_PLUGGED_NONE = 0;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public BatteryStatsImpl createFromParcel(Parcel parcel) {
            return new BatteryStatsImpl(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public BatteryStatsImpl[] newArray(int i) {
            return new BatteryStatsImpl[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_HISTORY = false;
    static final long DELAY_UPDATE_WAKELOCKS = 5000L;
    private static final int MAGIC = 0xba757475;
    static final int MAX_HISTORY_BUFFER = 0x20000;
    private static final int MAX_HISTORY_ITEMS = 2000;
    static final int MAX_MAX_HISTORY_BUFFER = 0x24000;
    private static final int MAX_MAX_HISTORY_ITEMS = 3000;
    private static final int MAX_WAKELOCKS_PER_UID = 30;
    private static final int MAX_WAKELOCKS_PER_UID_IN_SYSTEM = 50;
    static final int MSG_REPORT_POWER_CHANGE = 2;
    static final int MSG_UPDATE_WAKELOCKS = 1;
    private static final int PROC_WAKELOCKS_FORMAT[];
    private static final String TAG = "BatteryStatsImpl";
    private static final boolean USE_OLD_HISTORY = false;
    private static final int VERSION = 61;
    private static int sKernelWakelockUpdateVersion = 0;
    private static int sNumSpeedSteps;
    boolean mAudioOn;
    StopwatchTimer mAudioOnTimer;
    long mBatteryLastRealtime;
    long mBatteryLastUptime;
    long mBatteryRealtime;
    long mBatteryUptime;
    boolean mBluetoothOn;
    StopwatchTimer mBluetoothOnTimer;
    private int mBluetoothPingCount;
    private int mBluetoothPingStart;
    BluetoothHeadset mBtHeadset;
    private BatteryCallback mCallback;
    int mChangedBufferStates;
    int mChangedStates;
    int mDischargeAmountScreenOff;
    int mDischargeAmountScreenOffSinceCharge;
    int mDischargeAmountScreenOn;
    int mDischargeAmountScreenOnSinceCharge;
    int mDischargeCurrentLevel;
    int mDischargeScreenOffUnplugLevel;
    int mDischargeScreenOnUnplugLevel;
    int mDischargeStartLevel;
    int mDischargeUnplugLevel;
    private final JournaledFile mFile;
    final ArrayList mFullTimers;
    final ArrayList mFullWifiLockTimers;
    boolean mGlobalWifiRunning;
    StopwatchTimer mGlobalWifiRunningTimer;
    int mGpsNesting;
    private final MyHandler mHandler;
    boolean mHaveBatteryLevel;
    int mHighDischargeAmountSinceCharge;
    android.os.BatteryStats.HistoryItem mHistory;
    long mHistoryBaseTime;
    final Parcel mHistoryBuffer;
    int mHistoryBufferLastPos;
    android.os.BatteryStats.HistoryItem mHistoryCache;
    final android.os.BatteryStats.HistoryItem mHistoryCur;
    android.os.BatteryStats.HistoryItem mHistoryEnd;
    private android.os.BatteryStats.HistoryItem mHistoryIterator;
    android.os.BatteryStats.HistoryItem mHistoryLastEnd;
    final android.os.BatteryStats.HistoryItem mHistoryLastLastWritten;
    final android.os.BatteryStats.HistoryItem mHistoryLastWritten;
    boolean mHistoryOverflow;
    final android.os.BatteryStats.HistoryItem mHistoryReadTmp;
    Counter mInputEventCounter;
    private boolean mIteratingHistory;
    private final HashMap mKernelWakelockStats;
    long mLastHistoryTime;
    final ArrayList mLastPartialTimers;
    long mLastRealtime;
    long mLastUptime;
    long mLastWriteTime;
    int mLowDischargeAmountSinceCharge;
    private long mMobileDataRx[];
    private long mMobileDataTx[];
    private HashSet mMobileIfaces;
    private NetworkStats mNetworkDetailCache;
    private final NetworkStatsFactory mNetworkStatsFactory;
    private NetworkStats mNetworkSummaryCache;
    int mNumHistoryItems;
    boolean mOnBattery;
    boolean mOnBatteryInternal;
    final ArrayList mPartialTimers;
    Parcel mPendingWrite;
    int mPhoneDataConnectionType;
    final StopwatchTimer mPhoneDataConnectionsTimer[];
    boolean mPhoneOn;
    StopwatchTimer mPhoneOnTimer;
    private int mPhoneServiceState;
    private int mPhoneServiceStateRaw;
    StopwatchTimer mPhoneSignalScanningTimer;
    int mPhoneSignalStrengthBin;
    int mPhoneSignalStrengthBinRaw;
    final StopwatchTimer mPhoneSignalStrengthsTimer[];
    private int mPhoneSimStateRaw;
    private final Map mProcWakelockFileStats;
    private final long mProcWakelocksData[];
    private final String mProcWakelocksName[];
    private long mRadioDataStart;
    private long mRadioDataUptime;
    private boolean mReadOverflow;
    long mRealtime;
    long mRealtimeStart;
    boolean mRecordingHistory;
    final ArrayList mScanWifiLockTimers;
    int mScreenBrightnessBin;
    final StopwatchTimer mScreenBrightnessTimer[];
    boolean mScreenOn;
    StopwatchTimer mScreenOnTimer;
    int mSensorNesting;
    final SparseArray mSensorTimers;
    boolean mShuttingDown;
    int mStartCount;
    private long mTotalDataRx[];
    private long mTotalDataTx[];
    long mTrackBatteryPastRealtime;
    long mTrackBatteryPastUptime;
    long mTrackBatteryRealtimeStart;
    long mTrackBatteryUptimeStart;
    private HashMap mUidCache;
    final SparseArray mUidStats;
    final ArrayList mUnpluggables;
    long mUnpluggedBatteryRealtime;
    long mUnpluggedBatteryUptime;
    long mUptime;
    long mUptimeStart;
    boolean mVideoOn;
    StopwatchTimer mVideoOnTimer;
    int mWakeLockNesting;
    int mWifiFullLockNesting;
    int mWifiMulticastNesting;
    final ArrayList mWifiMulticastTimers;
    boolean mWifiOn;
    StopwatchTimer mWifiOnTimer;
    int mWifiOnUid;
    final ArrayList mWifiRunningTimers;
    int mWifiScanLockNesting;
    final ArrayList mWindowTimers;
    final ReentrantLock mWriteLock;

    static  {
        int ai[] = new int[6];
        ai[0] = 4105;
        ai[1] = 8201;
        ai[2] = 9;
        ai[3] = 9;
        ai[4] = 9;
        ai[5] = 8201;
        PROC_WAKELOCKS_FORMAT = ai;
    }


}
