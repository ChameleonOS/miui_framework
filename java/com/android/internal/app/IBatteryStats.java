// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.app;

import android.os.*;
import android.telephony.SignalStrength;

public interface IBatteryStats
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IBatteryStats {
        private static class Proxy
            implements IBatteryStats {

            public IBinder asBinder() {
                return mRemote;
            }

            public long getAwakeTimeBattery() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                mRemote.transact(41, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                return l;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public long getAwakeTimePlugged() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                mRemote.transact(42, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                return l;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "com.android.internal.app.IBatteryStats";
            }

            public byte[] getStatistics() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                byte abyte0[];
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                abyte0 = parcel1.createByteArray();
                parcel1.recycle();
                parcel.recycle();
                return abyte0;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteBluetoothOff() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                mRemote.transact(26, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteBluetoothOn() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                mRemote.transact(25, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteFullWifiLockAcquired(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                mRemote.transact(27, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteFullWifiLockAcquiredFromSource(WorkSource worksource) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(33, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteFullWifiLockReleased(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                mRemote.transact(28, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteFullWifiLockReleasedFromSource(WorkSource worksource) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(34, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteInputEvent() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteNetworkInterfaceType(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(39, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void notePhoneDataConnectionState(int i, boolean flag) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                mRemote.transact(18, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void notePhoneOff() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                mRemote.transact(16, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void notePhoneOn() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                mRemote.transact(15, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void notePhoneSignalStrength(SignalStrength signalstrength) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                if(signalstrength == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                signalstrength.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(17, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void notePhoneState(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                mRemote.transact(19, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteScanWifiLockAcquired(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                mRemote.transact(29, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteScanWifiLockAcquiredFromSource(WorkSource worksource) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(35, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteScanWifiLockReleased(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                mRemote.transact(30, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteScanWifiLockReleasedFromSource(WorkSource worksource) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(36, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteScreenBrightness(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteScreenOff() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteScreenOn() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteStartGps(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteStartSensor(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteStartWakelock(int i, int j, String s, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeString(s);
                parcel.writeInt(k);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteStartWakelockFromSource(WorkSource worksource, int i, String s, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_86;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                parcel.writeString(s);
                parcel.writeInt(j);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteStopGps(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteStopSensor(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteStopWakelock(int i, int j, String s, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeString(s);
                parcel.writeInt(k);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteStopWakelockFromSource(WorkSource worksource, int i, String s, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_86;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                parcel.writeString(s);
                parcel.writeInt(j);
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteUserActivity(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteWifiMulticastDisabled(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                mRemote.transact(32, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteWifiMulticastDisabledFromSource(WorkSource worksource) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(38, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteWifiMulticastEnabled(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                mRemote.transact(31, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteWifiMulticastEnabledFromSource(WorkSource worksource) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(37, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteWifiOff() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                mRemote.transact(21, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteWifiOn() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                mRemote.transact(20, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteWifiRunning(WorkSource worksource) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(22, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void noteWifiRunningChanged(WorkSource worksource, WorkSource worksource1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                if(worksource == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L3:
                if(worksource1 == null)
                    break MISSING_BLOCK_LABEL_98;
                parcel.writeInt(1);
                worksource1.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(23, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                parcel.writeInt(0);
                  goto _L4
            }

            public void noteWifiStopped(WorkSource worksource) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                if(worksource == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                worksource.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(24, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setBatteryState(int i, int j, int k, int l, int i1, int j1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.android.internal.app.IBatteryStats");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(l);
                parcel.writeInt(i1);
                parcel.writeInt(j1);
                mRemote.transact(40, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IBatteryStats asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("com.android.internal.app.IBatteryStats");
                if(iinterface != null && (iinterface instanceof IBatteryStats))
                    obj = (IBatteryStats)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IBatteryStats) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            boolean flag = true;
            i;
            JVM INSTR lookupswitch 43: default 360
        //                       1: 383
        //                       2: 408
        //                       3: 441
        //                       4: 474
        //                       5: 499
        //                       6: 524
        //                       7: 582
        //                       8: 640
        //                       9: 661
        //                       10: 682
        //                       11: 699
        //                       12: 720
        //                       13: 737
        //                       14: 754
        //                       15: 779
        //                       16: 796
        //                       17: 813
        //                       18: 859
        //                       19: 903
        //                       20: 924
        //                       21: 941
        //                       22: 958
        //                       23: 1004
        //                       24: 1079
        //                       25: 1125
        //                       26: 1142
        //                       27: 1159
        //                       28: 1180
        //                       29: 1201
        //                       30: 1222
        //                       31: 1243
        //                       32: 1264
        //                       33: 1285
        //                       34: 1331
        //                       35: 1377
        //                       36: 1423
        //                       37: 1469
        //                       38: 1515
        //                       39: 1561
        //                       40: 1586
        //                       41: 1627
        //                       42: 1652
        //                       1598968902: 374;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44
_L1:
            flag = super.onTransact(i, parcel, parcel1, j);
_L46:
            return flag;
_L44:
            parcel1.writeString("com.android.internal.app.IBatteryStats");
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            byte abyte0[] = getStatistics();
            parcel1.writeNoException();
            parcel1.writeByteArray(abyte0);
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteStartWakelock(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteStopWakelock(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteStartSensor(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteStopSensor(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            WorkSource worksource11;
            if(parcel.readInt() != 0)
                worksource11 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource11 = null;
            noteStartWakelockFromSource(worksource11, parcel.readInt(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            WorkSource worksource10;
            if(parcel.readInt() != 0)
                worksource10 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource10 = null;
            noteStopWakelockFromSource(worksource10, parcel.readInt(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteStartGps(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteStopGps(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteScreenOn();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteScreenBrightness(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteScreenOff();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteInputEvent();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteUserActivity(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            notePhoneOn();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            notePhoneOff();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            SignalStrength signalstrength;
            if(parcel.readInt() != 0)
                signalstrength = (SignalStrength)SignalStrength.CREATOR.createFromParcel(parcel);
            else
                signalstrength = null;
            notePhoneSignalStrength(signalstrength);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            int k = parcel.readInt();
            boolean flag1;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            notePhoneDataConnectionState(k, flag1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            notePhoneState(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteWifiOn();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteWifiOff();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            WorkSource worksource9;
            if(parcel.readInt() != 0)
                worksource9 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource9 = null;
            noteWifiRunning(worksource9);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            WorkSource worksource7;
            WorkSource worksource8;
            if(parcel.readInt() != 0)
                worksource7 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource7 = null;
            if(parcel.readInt() != 0)
                worksource8 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource8 = null;
            noteWifiRunningChanged(worksource7, worksource8);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            WorkSource worksource6;
            if(parcel.readInt() != 0)
                worksource6 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource6 = null;
            noteWifiStopped(worksource6);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteBluetoothOn();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteBluetoothOff();
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteFullWifiLockAcquired(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteFullWifiLockReleased(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L30:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteScanWifiLockAcquired(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L31:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteScanWifiLockReleased(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L32:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteWifiMulticastEnabled(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L33:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteWifiMulticastDisabled(parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L34:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            WorkSource worksource5;
            if(parcel.readInt() != 0)
                worksource5 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource5 = null;
            noteFullWifiLockAcquiredFromSource(worksource5);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L35:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            WorkSource worksource4;
            if(parcel.readInt() != 0)
                worksource4 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource4 = null;
            noteFullWifiLockReleasedFromSource(worksource4);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L36:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            WorkSource worksource3;
            if(parcel.readInt() != 0)
                worksource3 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource3 = null;
            noteScanWifiLockAcquiredFromSource(worksource3);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L37:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            WorkSource worksource2;
            if(parcel.readInt() != 0)
                worksource2 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource2 = null;
            noteScanWifiLockReleasedFromSource(worksource2);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L38:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            WorkSource worksource1;
            if(parcel.readInt() != 0)
                worksource1 = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource1 = null;
            noteWifiMulticastEnabledFromSource(worksource1);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L39:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            WorkSource worksource;
            if(parcel.readInt() != 0)
                worksource = (WorkSource)WorkSource.CREATOR.createFromParcel(parcel);
            else
                worksource = null;
            noteWifiMulticastDisabledFromSource(worksource);
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L40:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            noteNetworkInterfaceType(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L41:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            setBatteryState(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            continue; /* Loop/switch isn't completed */
_L42:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            long l1 = getAwakeTimeBattery();
            parcel1.writeNoException();
            parcel1.writeLong(l1);
            continue; /* Loop/switch isn't completed */
_L43:
            parcel.enforceInterface("com.android.internal.app.IBatteryStats");
            long l = getAwakeTimePlugged();
            parcel1.writeNoException();
            parcel1.writeLong(l);
            if(true) goto _L46; else goto _L45
_L45:
        }

        private static final String DESCRIPTOR = "com.android.internal.app.IBatteryStats";
        static final int TRANSACTION_getAwakeTimeBattery = 41;
        static final int TRANSACTION_getAwakeTimePlugged = 42;
        static final int TRANSACTION_getStatistics = 1;
        static final int TRANSACTION_noteBluetoothOff = 26;
        static final int TRANSACTION_noteBluetoothOn = 25;
        static final int TRANSACTION_noteFullWifiLockAcquired = 27;
        static final int TRANSACTION_noteFullWifiLockAcquiredFromSource = 33;
        static final int TRANSACTION_noteFullWifiLockReleased = 28;
        static final int TRANSACTION_noteFullWifiLockReleasedFromSource = 34;
        static final int TRANSACTION_noteInputEvent = 13;
        static final int TRANSACTION_noteNetworkInterfaceType = 39;
        static final int TRANSACTION_notePhoneDataConnectionState = 18;
        static final int TRANSACTION_notePhoneOff = 16;
        static final int TRANSACTION_notePhoneOn = 15;
        static final int TRANSACTION_notePhoneSignalStrength = 17;
        static final int TRANSACTION_notePhoneState = 19;
        static final int TRANSACTION_noteScanWifiLockAcquired = 29;
        static final int TRANSACTION_noteScanWifiLockAcquiredFromSource = 35;
        static final int TRANSACTION_noteScanWifiLockReleased = 30;
        static final int TRANSACTION_noteScanWifiLockReleasedFromSource = 36;
        static final int TRANSACTION_noteScreenBrightness = 11;
        static final int TRANSACTION_noteScreenOff = 12;
        static final int TRANSACTION_noteScreenOn = 10;
        static final int TRANSACTION_noteStartGps = 8;
        static final int TRANSACTION_noteStartSensor = 4;
        static final int TRANSACTION_noteStartWakelock = 2;
        static final int TRANSACTION_noteStartWakelockFromSource = 6;
        static final int TRANSACTION_noteStopGps = 9;
        static final int TRANSACTION_noteStopSensor = 5;
        static final int TRANSACTION_noteStopWakelock = 3;
        static final int TRANSACTION_noteStopWakelockFromSource = 7;
        static final int TRANSACTION_noteUserActivity = 14;
        static final int TRANSACTION_noteWifiMulticastDisabled = 32;
        static final int TRANSACTION_noteWifiMulticastDisabledFromSource = 38;
        static final int TRANSACTION_noteWifiMulticastEnabled = 31;
        static final int TRANSACTION_noteWifiMulticastEnabledFromSource = 37;
        static final int TRANSACTION_noteWifiOff = 21;
        static final int TRANSACTION_noteWifiOn = 20;
        static final int TRANSACTION_noteWifiRunning = 22;
        static final int TRANSACTION_noteWifiRunningChanged = 23;
        static final int TRANSACTION_noteWifiStopped = 24;
        static final int TRANSACTION_setBatteryState = 40;

        public Stub() {
            attachInterface(this, "com.android.internal.app.IBatteryStats");
        }
    }


    public abstract long getAwakeTimeBattery() throws RemoteException;

    public abstract long getAwakeTimePlugged() throws RemoteException;

    public abstract byte[] getStatistics() throws RemoteException;

    public abstract void noteBluetoothOff() throws RemoteException;

    public abstract void noteBluetoothOn() throws RemoteException;

    public abstract void noteFullWifiLockAcquired(int i) throws RemoteException;

    public abstract void noteFullWifiLockAcquiredFromSource(WorkSource worksource) throws RemoteException;

    public abstract void noteFullWifiLockReleased(int i) throws RemoteException;

    public abstract void noteFullWifiLockReleasedFromSource(WorkSource worksource) throws RemoteException;

    public abstract void noteInputEvent() throws RemoteException;

    public abstract void noteNetworkInterfaceType(String s, int i) throws RemoteException;

    public abstract void notePhoneDataConnectionState(int i, boolean flag) throws RemoteException;

    public abstract void notePhoneOff() throws RemoteException;

    public abstract void notePhoneOn() throws RemoteException;

    public abstract void notePhoneSignalStrength(SignalStrength signalstrength) throws RemoteException;

    public abstract void notePhoneState(int i) throws RemoteException;

    public abstract void noteScanWifiLockAcquired(int i) throws RemoteException;

    public abstract void noteScanWifiLockAcquiredFromSource(WorkSource worksource) throws RemoteException;

    public abstract void noteScanWifiLockReleased(int i) throws RemoteException;

    public abstract void noteScanWifiLockReleasedFromSource(WorkSource worksource) throws RemoteException;

    public abstract void noteScreenBrightness(int i) throws RemoteException;

    public abstract void noteScreenOff() throws RemoteException;

    public abstract void noteScreenOn() throws RemoteException;

    public abstract void noteStartGps(int i) throws RemoteException;

    public abstract void noteStartSensor(int i, int j) throws RemoteException;

    public abstract void noteStartWakelock(int i, int j, String s, int k) throws RemoteException;

    public abstract void noteStartWakelockFromSource(WorkSource worksource, int i, String s, int j) throws RemoteException;

    public abstract void noteStopGps(int i) throws RemoteException;

    public abstract void noteStopSensor(int i, int j) throws RemoteException;

    public abstract void noteStopWakelock(int i, int j, String s, int k) throws RemoteException;

    public abstract void noteStopWakelockFromSource(WorkSource worksource, int i, String s, int j) throws RemoteException;

    public abstract void noteUserActivity(int i, int j) throws RemoteException;

    public abstract void noteWifiMulticastDisabled(int i) throws RemoteException;

    public abstract void noteWifiMulticastDisabledFromSource(WorkSource worksource) throws RemoteException;

    public abstract void noteWifiMulticastEnabled(int i) throws RemoteException;

    public abstract void noteWifiMulticastEnabledFromSource(WorkSource worksource) throws RemoteException;

    public abstract void noteWifiOff() throws RemoteException;

    public abstract void noteWifiOn() throws RemoteException;

    public abstract void noteWifiRunning(WorkSource worksource) throws RemoteException;

    public abstract void noteWifiRunningChanged(WorkSource worksource, WorkSource worksource1) throws RemoteException;

    public abstract void noteWifiStopped(WorkSource worksource) throws RemoteException;

    public abstract void setBatteryState(int i, int j, int k, int l, int i1, int j1) throws RemoteException;
}
