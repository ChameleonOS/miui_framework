// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.admin;

import android.content.ComponentName;
import android.os.*;
import java.util.List;

public interface IDevicePolicyManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IDevicePolicyManager {
        private static class Proxy
            implements IDevicePolicyManager {

            public IBinder asBinder() {
                return mRemote;
            }

            public List getActiveAdmins() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                java.util.ArrayList arraylist;
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                mRemote.transact(40, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(ComponentName.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean getCameraDisabled(ComponentName componentname) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(37, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getCurrentFailedPasswordAttempts() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                mRemote.transact(23, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public ComponentName getGlobalProxyAdmin() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                mRemote.transact(32, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ComponentName componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return componentname;
_L2:
                componentname = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInterfaceDescriptor() {
                return "android.app.admin.IDevicePolicyManager";
            }

            public int getMaximumFailedPasswordsForWipe(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(25, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public long getMaximumTimeToLock(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                long l;
                mRemote.transact(28, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                return l;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public long getPasswordExpiration(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                long l;
                mRemote.transact(21, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                return l;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public long getPasswordExpirationTimeout(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                long l;
                mRemote.transact(20, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                return l;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getPasswordHistoryLength(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(18, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getPasswordMinimumLength(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_64;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getPasswordMinimumLetters(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getPasswordMinimumLowerCase(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getPasswordMinimumNonLetter(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(16, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getPasswordMinimumNumeric(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getPasswordMinimumSymbols(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getPasswordMinimumUpperCase(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getPasswordQuality(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_64;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void getRemoveWarning(ComponentName componentname, RemoteCallback remotecallback) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                if(remotecallback == null)
                    break MISSING_BLOCK_LABEL_98;
                parcel.writeInt(1);
                remotecallback.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(42, parcel, parcel1, 0);
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

            public boolean getStorageEncryption(ComponentName componentname) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(34, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getStorageEncryptionStatus() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                mRemote.transact(35, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean hasGrantedPolicy(ComponentName componentname, int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_88;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(44, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                Exception exception;
                if(j == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isActivePasswordSufficient() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                mRemote.transact(22, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public boolean isAdminActive(ComponentName componentname) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(39, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                Exception exception;
                if(i == 0)
                    flag = false;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void lockNow() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
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

            public boolean packageHasActiveAdmins(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                parcel.writeString(s);
                mRemote.transact(41, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                if(i != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void removeActiveAdmin(ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_57;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(43, parcel, parcel1, 0);
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

            public void reportFailedPasswordAttempt() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                mRemote.transact(46, parcel, parcel1, 0);
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

            public void reportSuccessfulPasswordAttempt() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                mRemote.transact(47, parcel, parcel1, 0);
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

            public boolean resetPassword(String s, int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(26, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                if(j != 0)
                    flag = true;
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void setActiveAdmin(ComponentName componentname, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname != null) {
                    parcel.writeInt(1);
                    componentname.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_102;
                }
                  goto _L1
_L2:
                parcel.writeInt(i);
                mRemote.transact(38, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L1:
                parcel.writeInt(0);
                break MISSING_BLOCK_LABEL_102;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                while(!flag)  {
                    i = 0;
                    break;
                }
                  goto _L2
            }

            public void setActivePasswordState(int i, int j, int k, int l, int i1, int j1, int k1, 
                    int l1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                parcel.writeInt(l);
                parcel.writeInt(i1);
                parcel.writeInt(j1);
                parcel.writeInt(k1);
                parcel.writeInt(l1);
                mRemote.transact(45, parcel, parcel1, 0);
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

            public void setCameraDisabled(ComponentName componentname, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname != null) {
                    parcel.writeInt(1);
                    componentname.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_102;
                }
                  goto _L1
_L2:
                parcel.writeInt(i);
                mRemote.transact(36, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L1:
                parcel.writeInt(0);
                break MISSING_BLOCK_LABEL_102;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                while(!flag)  {
                    i = 0;
                    break;
                }
                  goto _L2
            }

            public ComponentName setGlobalProxy(ComponentName componentname, String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                ComponentName componentname1;
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(31, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_128;
                componentname1 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return componentname1;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                componentname1 = null;
                  goto _L4
            }

            public void setMaximumFailedPasswordsForWipe(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
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

            public void setMaximumTimeToLock(ComponentName componentname, long l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_73;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeLong(l);
                mRemote.transact(27, parcel, parcel1, 0);
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

            public void setPasswordExpirationTimeout(ComponentName componentname, long l) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_73;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeLong(l);
                mRemote.transact(19, parcel, parcel1, 0);
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

            public void setPasswordHistoryLength(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
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

            public void setPasswordMinimumLength(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(3, parcel, parcel1, 0);
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

            public void setPasswordMinimumLetters(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(9, parcel, parcel1, 0);
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

            public void setPasswordMinimumLowerCase(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
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

            public void setPasswordMinimumNonLetter(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(15, parcel, parcel1, 0);
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

            public void setPasswordMinimumNumeric(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(11, parcel, parcel1, 0);
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

            public void setPasswordMinimumSymbols(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_66;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(13, parcel, parcel1, 0);
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

            public void setPasswordMinimumUpperCase(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(5, parcel, parcel1, 0);
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

            public void setPasswordQuality(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_65;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                mRemote.transact(1, parcel, parcel1, 0);
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

            public int setStorageEncryption(ComponentName componentname, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
                if(componentname != null) {
                    parcel.writeInt(1);
                    componentname.writeToParcel(parcel, 0);
                    break MISSING_BLOCK_LABEL_111;
                }
                  goto _L1
_L2:
                int j;
                parcel.writeInt(i);
                mRemote.transact(33, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
_L1:
                parcel.writeInt(0);
                break MISSING_BLOCK_LABEL_111;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                while(!flag)  {
                    i = 0;
                    break;
                }
                  goto _L2
            }

            public void wipeData(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.app.admin.IDevicePolicyManager");
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

            private IBinder mRemote;

            Proxy(IBinder ibinder) {
                mRemote = ibinder;
            }
        }


        public static IDevicePolicyManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.app.admin.IDevicePolicyManager");
                if(iinterface != null && (iinterface instanceof IDevicePolicyManager))
                    obj = (IDevicePolicyManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IDevicePolicyManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 48: default 396
        //                       1: 422
        //                       2: 475
        //                       3: 532
        //                       4: 585
        //                       5: 642
        //                       6: 695
        //                       7: 752
        //                       8: 805
        //                       9: 862
        //                       10: 915
        //                       11: 972
        //                       12: 1025
        //                       13: 1082
        //                       14: 1135
        //                       15: 1192
        //                       16: 1245
        //                       17: 1302
        //                       18: 1355
        //                       19: 1412
        //                       20: 1465
        //                       21: 1522
        //                       22: 1579
        //                       23: 1621
        //                       24: 1649
        //                       25: 1702
        //                       26: 1759
        //                       27: 1809
        //                       28: 1862
        //                       29: 1919
        //                       30: 1939
        //                       31: 1963
        //                       32: 2047
        //                       33: 2094
        //                       34: 2169
        //                       35: 2240
        //                       36: 2268
        //                       37: 2335
        //                       38: 2406
        //                       39: 2473
        //                       40: 2544
        //                       41: 2572
        //                       42: 2618
        //                       43: 2696
        //                       44: 2745
        //                       45: 2820
        //                       46: 2872
        //                       47: 2892
        //                       1598968902: 410;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49
_L1:
            boolean flag = super.onTransact(i, parcel, parcel1, j);
_L51:
            return flag;
_L49:
            parcel1.writeString("android.app.admin.IDevicePolicyManager");
            flag = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname36;
            if(parcel.readInt() != 0)
                componentname36 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname36 = null;
            setPasswordQuality(componentname36, parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname35;
            int i6;
            if(parcel.readInt() != 0)
                componentname35 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname35 = null;
            i6 = getPasswordQuality(componentname35);
            parcel1.writeNoException();
            parcel1.writeInt(i6);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname34;
            if(parcel.readInt() != 0)
                componentname34 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname34 = null;
            setPasswordMinimumLength(componentname34, parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname33;
            int l5;
            if(parcel.readInt() != 0)
                componentname33 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname33 = null;
            l5 = getPasswordMinimumLength(componentname33);
            parcel1.writeNoException();
            parcel1.writeInt(l5);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname32;
            if(parcel.readInt() != 0)
                componentname32 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname32 = null;
            setPasswordMinimumUpperCase(componentname32, parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname31;
            int k5;
            if(parcel.readInt() != 0)
                componentname31 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname31 = null;
            k5 = getPasswordMinimumUpperCase(componentname31);
            parcel1.writeNoException();
            parcel1.writeInt(k5);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname30;
            if(parcel.readInt() != 0)
                componentname30 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname30 = null;
            setPasswordMinimumLowerCase(componentname30, parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname29;
            int j5;
            if(parcel.readInt() != 0)
                componentname29 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname29 = null;
            j5 = getPasswordMinimumLowerCase(componentname29);
            parcel1.writeNoException();
            parcel1.writeInt(j5);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname28;
            if(parcel.readInt() != 0)
                componentname28 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname28 = null;
            setPasswordMinimumLetters(componentname28, parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname27;
            int i5;
            if(parcel.readInt() != 0)
                componentname27 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname27 = null;
            i5 = getPasswordMinimumLetters(componentname27);
            parcel1.writeNoException();
            parcel1.writeInt(i5);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname26;
            if(parcel.readInt() != 0)
                componentname26 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname26 = null;
            setPasswordMinimumNumeric(componentname26, parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname25;
            int k4;
            if(parcel.readInt() != 0)
                componentname25 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname25 = null;
            k4 = getPasswordMinimumNumeric(componentname25);
            parcel1.writeNoException();
            parcel1.writeInt(k4);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname24;
            if(parcel.readInt() != 0)
                componentname24 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname24 = null;
            setPasswordMinimumSymbols(componentname24, parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname23;
            int j4;
            if(parcel.readInt() != 0)
                componentname23 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname23 = null;
            j4 = getPasswordMinimumSymbols(componentname23);
            parcel1.writeNoException();
            parcel1.writeInt(j4);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname22;
            if(parcel.readInt() != 0)
                componentname22 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname22 = null;
            setPasswordMinimumNonLetter(componentname22, parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname21;
            int i4;
            if(parcel.readInt() != 0)
                componentname21 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname21 = null;
            i4 = getPasswordMinimumNonLetter(componentname21);
            parcel1.writeNoException();
            parcel1.writeInt(i4);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname20;
            if(parcel.readInt() != 0)
                componentname20 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname20 = null;
            setPasswordHistoryLength(componentname20, parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname19;
            int k3;
            if(parcel.readInt() != 0)
                componentname19 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname19 = null;
            k3 = getPasswordHistoryLength(componentname19);
            parcel1.writeNoException();
            parcel1.writeInt(k3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname18;
            if(parcel.readInt() != 0)
                componentname18 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname18 = null;
            setPasswordExpirationTimeout(componentname18, parcel.readLong());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname17;
            long l4;
            if(parcel.readInt() != 0)
                componentname17 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname17 = null;
            l4 = getPasswordExpirationTimeout(componentname17);
            parcel1.writeNoException();
            parcel1.writeLong(l4);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname16;
            long l3;
            if(parcel.readInt() != 0)
                componentname16 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname16 = null;
            l3 = getPasswordExpiration(componentname16);
            parcel1.writeNoException();
            parcel1.writeLong(l3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            boolean flag10 = isActivePasswordSufficient();
            parcel1.writeNoException();
            int j3;
            if(flag10)
                j3 = 1;
            else
                j3 = 0;
            parcel1.writeInt(j3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            int i3 = getCurrentFailedPasswordAttempts();
            parcel1.writeNoException();
            parcel1.writeInt(i3);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname15;
            if(parcel.readInt() != 0)
                componentname15 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname15 = null;
            setMaximumFailedPasswordsForWipe(componentname15, parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname14;
            int k2;
            if(parcel.readInt() != 0)
                componentname14 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname14 = null;
            k2 = getMaximumFailedPasswordsForWipe(componentname14);
            parcel1.writeNoException();
            parcel1.writeInt(k2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            boolean flag9 = resetPassword(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            int j2;
            if(flag9)
                j2 = 1;
            else
                j2 = 0;
            parcel1.writeInt(j2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname13;
            if(parcel.readInt() != 0)
                componentname13 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname13 = null;
            setMaximumTimeToLock(componentname13, parcel.readLong());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname12;
            long l2;
            if(parcel.readInt() != 0)
                componentname12 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname12 = null;
            l2 = getMaximumTimeToLock(componentname12);
            parcel1.writeNoException();
            parcel1.writeLong(l2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L30:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            lockNow();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L31:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            wipeData(parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L32:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname10;
            ComponentName componentname11;
            if(parcel.readInt() != 0)
                componentname10 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname10 = null;
            componentname11 = setGlobalProxy(componentname10, parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            if(componentname11 != null) {
                parcel1.writeInt(1);
                componentname11.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L33:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname9 = getGlobalProxyAdmin();
            parcel1.writeNoException();
            if(componentname9 != null) {
                parcel1.writeInt(1);
                componentname9.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag = true;
            continue; /* Loop/switch isn't completed */
_L34:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname8;
            boolean flag8;
            int i2;
            if(parcel.readInt() != 0)
                componentname8 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname8 = null;
            if(parcel.readInt() != 0)
                flag8 = true;
            else
                flag8 = false;
            i2 = setStorageEncryption(componentname8, flag8);
            parcel1.writeNoException();
            parcel1.writeInt(i2);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L35:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname7;
            boolean flag7;
            int l1;
            if(parcel.readInt() != 0)
                componentname7 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname7 = null;
            flag7 = getStorageEncryption(componentname7);
            parcel1.writeNoException();
            if(flag7)
                l1 = 1;
            else
                l1 = 0;
            parcel1.writeInt(l1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L36:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            int k1 = getStorageEncryptionStatus();
            parcel1.writeNoException();
            parcel1.writeInt(k1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L37:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname6;
            boolean flag6;
            if(parcel.readInt() != 0)
                componentname6 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname6 = null;
            if(parcel.readInt() != 0)
                flag6 = true;
            else
                flag6 = false;
            setCameraDisabled(componentname6, flag6);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L38:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname5;
            boolean flag5;
            int j1;
            if(parcel.readInt() != 0)
                componentname5 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname5 = null;
            flag5 = getCameraDisabled(componentname5);
            parcel1.writeNoException();
            if(flag5)
                j1 = 1;
            else
                j1 = 0;
            parcel1.writeInt(j1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L39:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname4;
            boolean flag4;
            if(parcel.readInt() != 0)
                componentname4 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname4 = null;
            if(parcel.readInt() != 0)
                flag4 = true;
            else
                flag4 = false;
            setActiveAdmin(componentname4, flag4);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L40:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname3;
            boolean flag3;
            int i1;
            if(parcel.readInt() != 0)
                componentname3 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname3 = null;
            flag3 = isAdminActive(componentname3);
            parcel1.writeNoException();
            if(flag3)
                i1 = 1;
            else
                i1 = 0;
            parcel1.writeInt(i1);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L41:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            List list = getActiveAdmins();
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L42:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            boolean flag2 = packageHasActiveAdmins(parcel.readString());
            parcel1.writeNoException();
            int l;
            if(flag2)
                l = 1;
            else
                l = 0;
            parcel1.writeInt(l);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L43:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname2;
            RemoteCallback remotecallback;
            if(parcel.readInt() != 0)
                componentname2 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname2 = null;
            if(parcel.readInt() != 0)
                remotecallback = (RemoteCallback)RemoteCallback.CREATOR.createFromParcel(parcel);
            else
                remotecallback = null;
            getRemoveWarning(componentname2, remotecallback);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L44:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname1;
            if(parcel.readInt() != 0)
                componentname1 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname1 = null;
            removeActiveAdmin(componentname1);
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L45:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            ComponentName componentname;
            boolean flag1;
            int k;
            if(parcel.readInt() != 0)
                componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname = null;
            flag1 = hasGrantedPolicy(componentname, parcel.readInt());
            parcel1.writeNoException();
            if(flag1)
                k = 1;
            else
                k = 0;
            parcel1.writeInt(k);
            flag = true;
            continue; /* Loop/switch isn't completed */
_L46:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            setActivePasswordState(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L47:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            reportFailedPasswordAttempt();
            parcel1.writeNoException();
            flag = true;
            continue; /* Loop/switch isn't completed */
_L48:
            parcel.enforceInterface("android.app.admin.IDevicePolicyManager");
            reportSuccessfulPasswordAttempt();
            parcel1.writeNoException();
            flag = true;
            if(true) goto _L51; else goto _L50
_L50:
        }

        private static final String DESCRIPTOR = "android.app.admin.IDevicePolicyManager";
        static final int TRANSACTION_getActiveAdmins = 40;
        static final int TRANSACTION_getCameraDisabled = 37;
        static final int TRANSACTION_getCurrentFailedPasswordAttempts = 23;
        static final int TRANSACTION_getGlobalProxyAdmin = 32;
        static final int TRANSACTION_getMaximumFailedPasswordsForWipe = 25;
        static final int TRANSACTION_getMaximumTimeToLock = 28;
        static final int TRANSACTION_getPasswordExpiration = 21;
        static final int TRANSACTION_getPasswordExpirationTimeout = 20;
        static final int TRANSACTION_getPasswordHistoryLength = 18;
        static final int TRANSACTION_getPasswordMinimumLength = 4;
        static final int TRANSACTION_getPasswordMinimumLetters = 10;
        static final int TRANSACTION_getPasswordMinimumLowerCase = 8;
        static final int TRANSACTION_getPasswordMinimumNonLetter = 16;
        static final int TRANSACTION_getPasswordMinimumNumeric = 12;
        static final int TRANSACTION_getPasswordMinimumSymbols = 14;
        static final int TRANSACTION_getPasswordMinimumUpperCase = 6;
        static final int TRANSACTION_getPasswordQuality = 2;
        static final int TRANSACTION_getRemoveWarning = 42;
        static final int TRANSACTION_getStorageEncryption = 34;
        static final int TRANSACTION_getStorageEncryptionStatus = 35;
        static final int TRANSACTION_hasGrantedPolicy = 44;
        static final int TRANSACTION_isActivePasswordSufficient = 22;
        static final int TRANSACTION_isAdminActive = 39;
        static final int TRANSACTION_lockNow = 29;
        static final int TRANSACTION_packageHasActiveAdmins = 41;
        static final int TRANSACTION_removeActiveAdmin = 43;
        static final int TRANSACTION_reportFailedPasswordAttempt = 46;
        static final int TRANSACTION_reportSuccessfulPasswordAttempt = 47;
        static final int TRANSACTION_resetPassword = 26;
        static final int TRANSACTION_setActiveAdmin = 38;
        static final int TRANSACTION_setActivePasswordState = 45;
        static final int TRANSACTION_setCameraDisabled = 36;
        static final int TRANSACTION_setGlobalProxy = 31;
        static final int TRANSACTION_setMaximumFailedPasswordsForWipe = 24;
        static final int TRANSACTION_setMaximumTimeToLock = 27;
        static final int TRANSACTION_setPasswordExpirationTimeout = 19;
        static final int TRANSACTION_setPasswordHistoryLength = 17;
        static final int TRANSACTION_setPasswordMinimumLength = 3;
        static final int TRANSACTION_setPasswordMinimumLetters = 9;
        static final int TRANSACTION_setPasswordMinimumLowerCase = 7;
        static final int TRANSACTION_setPasswordMinimumNonLetter = 15;
        static final int TRANSACTION_setPasswordMinimumNumeric = 11;
        static final int TRANSACTION_setPasswordMinimumSymbols = 13;
        static final int TRANSACTION_setPasswordMinimumUpperCase = 5;
        static final int TRANSACTION_setPasswordQuality = 1;
        static final int TRANSACTION_setStorageEncryption = 33;
        static final int TRANSACTION_wipeData = 30;

        public Stub() {
            attachInterface(this, "android.app.admin.IDevicePolicyManager");
        }
    }


    public abstract List getActiveAdmins() throws RemoteException;

    public abstract boolean getCameraDisabled(ComponentName componentname) throws RemoteException;

    public abstract int getCurrentFailedPasswordAttempts() throws RemoteException;

    public abstract ComponentName getGlobalProxyAdmin() throws RemoteException;

    public abstract int getMaximumFailedPasswordsForWipe(ComponentName componentname) throws RemoteException;

    public abstract long getMaximumTimeToLock(ComponentName componentname) throws RemoteException;

    public abstract long getPasswordExpiration(ComponentName componentname) throws RemoteException;

    public abstract long getPasswordExpirationTimeout(ComponentName componentname) throws RemoteException;

    public abstract int getPasswordHistoryLength(ComponentName componentname) throws RemoteException;

    public abstract int getPasswordMinimumLength(ComponentName componentname) throws RemoteException;

    public abstract int getPasswordMinimumLetters(ComponentName componentname) throws RemoteException;

    public abstract int getPasswordMinimumLowerCase(ComponentName componentname) throws RemoteException;

    public abstract int getPasswordMinimumNonLetter(ComponentName componentname) throws RemoteException;

    public abstract int getPasswordMinimumNumeric(ComponentName componentname) throws RemoteException;

    public abstract int getPasswordMinimumSymbols(ComponentName componentname) throws RemoteException;

    public abstract int getPasswordMinimumUpperCase(ComponentName componentname) throws RemoteException;

    public abstract int getPasswordQuality(ComponentName componentname) throws RemoteException;

    public abstract void getRemoveWarning(ComponentName componentname, RemoteCallback remotecallback) throws RemoteException;

    public abstract boolean getStorageEncryption(ComponentName componentname) throws RemoteException;

    public abstract int getStorageEncryptionStatus() throws RemoteException;

    public abstract boolean hasGrantedPolicy(ComponentName componentname, int i) throws RemoteException;

    public abstract boolean isActivePasswordSufficient() throws RemoteException;

    public abstract boolean isAdminActive(ComponentName componentname) throws RemoteException;

    public abstract void lockNow() throws RemoteException;

    public abstract boolean packageHasActiveAdmins(String s) throws RemoteException;

    public abstract void removeActiveAdmin(ComponentName componentname) throws RemoteException;

    public abstract void reportFailedPasswordAttempt() throws RemoteException;

    public abstract void reportSuccessfulPasswordAttempt() throws RemoteException;

    public abstract boolean resetPassword(String s, int i) throws RemoteException;

    public abstract void setActiveAdmin(ComponentName componentname, boolean flag) throws RemoteException;

    public abstract void setActivePasswordState(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1) throws RemoteException;

    public abstract void setCameraDisabled(ComponentName componentname, boolean flag) throws RemoteException;

    public abstract ComponentName setGlobalProxy(ComponentName componentname, String s, String s1) throws RemoteException;

    public abstract void setMaximumFailedPasswordsForWipe(ComponentName componentname, int i) throws RemoteException;

    public abstract void setMaximumTimeToLock(ComponentName componentname, long l) throws RemoteException;

    public abstract void setPasswordExpirationTimeout(ComponentName componentname, long l) throws RemoteException;

    public abstract void setPasswordHistoryLength(ComponentName componentname, int i) throws RemoteException;

    public abstract void setPasswordMinimumLength(ComponentName componentname, int i) throws RemoteException;

    public abstract void setPasswordMinimumLetters(ComponentName componentname, int i) throws RemoteException;

    public abstract void setPasswordMinimumLowerCase(ComponentName componentname, int i) throws RemoteException;

    public abstract void setPasswordMinimumNonLetter(ComponentName componentname, int i) throws RemoteException;

    public abstract void setPasswordMinimumNumeric(ComponentName componentname, int i) throws RemoteException;

    public abstract void setPasswordMinimumSymbols(ComponentName componentname, int i) throws RemoteException;

    public abstract void setPasswordMinimumUpperCase(ComponentName componentname, int i) throws RemoteException;

    public abstract void setPasswordQuality(ComponentName componentname, int i) throws RemoteException;

    public abstract int setStorageEncryption(ComponentName componentname, boolean flag) throws RemoteException;

    public abstract void wipeData(int i) throws RemoteException;
}
