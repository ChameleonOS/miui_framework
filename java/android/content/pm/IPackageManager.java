// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.content.*;
import android.net.Uri;
import android.os.*;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.content.pm:
//            PermissionInfo, IPackageDataObserver, UserInfo, IPackageDeleteObserver, 
//            ActivityInfo, ApplicationInfo, ParceledListSlice, InstrumentationInfo, 
//            PackageInfo, IPackageStatsObserver, PermissionGroupInfo, ProviderInfo, 
//            ServiceInfo, FeatureInfo, VerifierDeviceIdentity, IPackageInstallObserver, 
//            ManifestDigest, ContainerEncryptionParams, IPackageMoveObserver, ResolveInfo

public interface IPackageManager
    extends IInterface {
    public static abstract class Stub extends Binder
        implements IPackageManager {
        private static class Proxy
            implements IPackageManager {

            public void addPackageToPreferred(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
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

            public boolean addPermission(PermissionInfo permissioninfo) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(permissioninfo == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                permissioninfo.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(17, parcel, parcel1, 0);
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

            public boolean addPermissionAsync(PermissionInfo permissioninfo) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(permissioninfo == null)
                    break MISSING_BLOCK_LABEL_76;
                parcel.writeInt(1);
                permissioninfo.writeToParcel(parcel, 0);
_L1:
                int i;
                mRemote.transact(75, parcel, parcel1, 0);
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

            public void addPreferredActivity(IntentFilter intentfilter, int i, ComponentName acomponentname[], ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(intentfilter == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                intentfilter.writeToParcel(parcel, 0);
_L3:
                parcel.writeInt(i);
                parcel.writeTypedArray(acomponentname, 0);
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_123;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(49, parcel, parcel1, 0);
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

            public IBinder asBinder() {
                return mRemote;
            }

            public String[] canonicalToCurrentPackageNames(String as[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as1[];
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeStringArray(as);
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                as1 = parcel1.createStringArray();
                parcel1.recycle();
                parcel.recycle();
                return as1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int checkPermission(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(15, parcel, parcel1, 0);
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

            public int checkSignatures(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(22, parcel, parcel1, 0);
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

            public int checkUidPermission(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(16, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int checkUidSignatures(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int k;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(23, parcel, parcel1, 0);
                parcel1.readException();
                k = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return k;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void clearApplicationUserData(String s, IPackageDataObserver ipackagedataobserver, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                if(ipackagedataobserver == null)
                    break MISSING_BLOCK_LABEL_81;
                ibinder = ipackagedataobserver.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(61, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void clearPackagePreferredActivities(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                mRemote.transact(51, parcel, parcel1, 0);
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

            public UserInfo createUser(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(78, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                UserInfo userinfo = (UserInfo)UserInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return userinfo;
_L2:
                userinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String[] currentToCanonicalPackageNames(String as[]) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as1[];
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeStringArray(as);
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                as1 = parcel1.createStringArray();
                parcel1.recycle();
                parcel.recycle();
                return as1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void deleteApplicationCacheFiles(String s, IPackageDataObserver ipackagedataobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                if(ipackagedataobserver == null)
                    break MISSING_BLOCK_LABEL_69;
                ibinder = ipackagedataobserver.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(60, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void deletePackage(String s, IPackageDeleteObserver ipackagedeleteobserver, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                if(ipackagedeleteobserver == null)
                    break MISSING_BLOCK_LABEL_81;
                ibinder = ipackagedeleteobserver.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(44, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void enterSafeMode() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                mRemote.transact(66, parcel, parcel1, 0);
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

            public void finishPackageInstall(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                mRemote.transact(42, parcel, parcel1, 0);
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

            public void freeStorage(long l, IntentSender intentsender) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeLong(l);
                if(intentsender == null)
                    break MISSING_BLOCK_LABEL_73;
                parcel.writeInt(1);
                intentsender.writeToParcel(parcel, 0);
_L1:
                mRemote.transact(59, parcel, parcel1, 0);
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

            public void freeStorageAndNotify(long l, IPackageDataObserver ipackagedataobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeLong(l);
                if(ipackagedataobserver == null)
                    break MISSING_BLOCK_LABEL_75;
                ibinder = ipackagedataobserver.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(58, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public ActivityInfo getActivityInfo(ComponentName componentname, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                ActivityInfo activityinfo;
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_128;
                activityinfo = (ActivityInfo)ActivityInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return activityinfo;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                activityinfo = null;
                  goto _L4
            }

            public List getAllPermissionGroups(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ArrayList arraylist;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(PermissionGroupInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getApplicationEnabledSetting(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(56, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public ApplicationInfo getApplicationInfo(String s, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ApplicationInfo applicationinfo = (ApplicationInfo)ApplicationInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return applicationinfo;
_L2:
                applicationinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getComponentEnabledSetting(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_75;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                int j;
                parcel.writeInt(i);
                mRemote.transact(54, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getInstallLocation() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                mRemote.transact(77, parcel, parcel1, 0);
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

            public ParceledListSlice getInstalledApplications(int i, String s, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                parcel.writeString(s);
                parcel.writeInt(j);
                mRemote.transact(34, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ParceledListSlice parceledlistslice = (ParceledListSlice)ParceledListSlice.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return parceledlistslice;
_L2:
                parceledlistslice = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public ParceledListSlice getInstalledPackages(int i, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                parcel.writeString(s);
                mRemote.transact(33, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ParceledListSlice parceledlistslice = (ParceledListSlice)ParceledListSlice.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return parceledlistslice;
_L2:
                parceledlistslice = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String getInstallerPackageName(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                mRemote.transact(45, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public InstrumentationInfo getInstrumentationInfo(ComponentName componentname, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                InstrumentationInfo instrumentationinfo;
                parcel.writeInt(i);
                mRemote.transact(39, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_113;
                instrumentationinfo = (InstrumentationInfo)InstrumentationInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return instrumentationinfo;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                instrumentationinfo = null;
                  goto _L4
            }

            public String getInterfaceDescriptor() {
                return "android.content.pm.IPackageManager";
            }

            public String getNameForUid(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                mRemote.transact(25, parcel, parcel1, 0);
                parcel1.readException();
                s = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int[] getPackageGids(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int ai[];
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                ai = parcel1.createIntArray();
                parcel1.recycle();
                parcel.recycle();
                return ai;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public PackageInfo getPackageInfo(String s, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                PackageInfo packageinfo = (PackageInfo)PackageInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return packageinfo;
_L2:
                packageinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void getPackageSizeInfo(String s, IPackageStatsObserver ipackagestatsobserver) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                if(ipackagestatsobserver == null)
                    break MISSING_BLOCK_LABEL_69;
                ibinder = ipackagestatsobserver.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                mRemote.transact(62, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getPackageUid(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                j = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return j;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String[] getPackagesForUid(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                mRemote.transact(24, parcel, parcel1, 0);
                parcel1.readException();
                as = parcel1.createStringArray();
                parcel1.recycle();
                parcel.recycle();
                return as;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public PermissionGroupInfo getPermissionGroupInfo(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                PermissionGroupInfo permissiongroupinfo = (PermissionGroupInfo)PermissionGroupInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return permissiongroupinfo;
_L2:
                permissiongroupinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public PermissionInfo getPermissionInfo(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                PermissionInfo permissioninfo = (PermissionInfo)PermissionInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return permissioninfo;
_L2:
                permissioninfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List getPersistentApplications(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ArrayList arraylist;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                mRemote.transact(35, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(ApplicationInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getPreferredActivities(List list, List list1, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                mRemote.transact(52, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.readTypedList(list, IntentFilter.CREATOR);
                parcel1.readTypedList(list1, ComponentName.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return i;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List getPreferredPackages(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ArrayList arraylist;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                mRemote.transact(48, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(PackageInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public ProviderInfo getProviderInfo(ComponentName componentname, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                ProviderInfo providerinfo;
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_128;
                providerinfo = (ProviderInfo)ProviderInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return providerinfo;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                providerinfo = null;
                  goto _L4
            }

            public ActivityInfo getReceiverInfo(ComponentName componentname, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                ActivityInfo activityinfo;
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_128;
                activityinfo = (ActivityInfo)ActivityInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return activityinfo;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                activityinfo = null;
                  goto _L4
            }

            public ServiceInfo getServiceInfo(ComponentName componentname, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                ServiceInfo serviceinfo;
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_128;
                serviceinfo = (ServiceInfo)ServiceInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return serviceinfo;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                serviceinfo = null;
                  goto _L4
            }

            public FeatureInfo[] getSystemAvailableFeatures() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                FeatureInfo afeatureinfo[];
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                mRemote.transact(64, parcel, parcel1, 0);
                parcel1.readException();
                afeatureinfo = (FeatureInfo[])parcel1.createTypedArray(FeatureInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return afeatureinfo;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String[] getSystemSharedLibraryNames() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String as[];
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                mRemote.transact(63, parcel, parcel1, 0);
                parcel1.readException();
                as = parcel1.createStringArray();
                parcel1.recycle();
                parcel.recycle();
                return as;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public int getUidForSharedUser(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                mRemote.transact(26, parcel, parcel1, 0);
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

            public UserInfo getUser(int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                mRemote.transact(86, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                UserInfo userinfo = (UserInfo)UserInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return userinfo;
_L2:
                userinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List getUsers() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ArrayList arraylist;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                mRemote.transact(85, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(UserInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public VerifierDeviceIdentity getVerifierDeviceIdentity() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                mRemote.transact(83, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                VerifierDeviceIdentity verifierdeviceidentity = (VerifierDeviceIdentity)VerifierDeviceIdentity.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return verifierdeviceidentity;
_L2:
                verifierdeviceidentity = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void grantPermission(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeString(s1);
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

            public boolean hasSystemFeature(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                mRemote.transact(65, parcel, parcel1, 0);
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

            public boolean hasSystemUidErrors() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                mRemote.transact(69, parcel, parcel1, 0);
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

            public void installPackage(Uri uri, IPackageInstallObserver ipackageinstallobserver, int i, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(uri == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
_L3:
                IBinder ibinder;
                if(ipackageinstallobserver == null)
                    break MISSING_BLOCK_LABEL_123;
                ibinder = ipackageinstallobserver.asBinder();
_L4:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeString(s);
                mRemote.transact(41, parcel, parcel1, 0);
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
                ibinder = null;
                  goto _L4
            }

            public void installPackageWithVerification(Uri uri, IPackageInstallObserver ipackageinstallobserver, int i, String s, Uri uri1, ManifestDigest manifestdigest, ContainerEncryptionParams containerencryptionparams) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(uri == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                uri.writeToParcel(parcel, 0);
_L9:
                if(ipackageinstallobserver == null) goto _L4; else goto _L3
_L3:
                IBinder ibinder = ipackageinstallobserver.asBinder();
_L10:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                parcel.writeString(s);
                if(uri1 == null) goto _L6; else goto _L5
_L5:
                parcel.writeInt(1);
                uri1.writeToParcel(parcel, 0);
_L11:
                if(manifestdigest == null) goto _L8; else goto _L7
_L7:
                parcel.writeInt(1);
                manifestdigest.writeToParcel(parcel, 0);
_L12:
                if(containerencryptionparams == null)
                    break MISSING_BLOCK_LABEL_204;
                parcel.writeInt(1);
                containerencryptionparams.writeToParcel(parcel, 0);
_L13:
                mRemote.transact(81, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
_L2:
                parcel.writeInt(0);
                  goto _L9
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
_L4:
                ibinder = null;
                  goto _L10
_L6:
                parcel.writeInt(0);
                  goto _L11
_L8:
                parcel.writeInt(0);
                  goto _L12
                parcel.writeInt(0);
                  goto _L13
            }

            public boolean isFirstBoot() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                mRemote.transact(84, parcel, parcel1, 0);
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

            public boolean isPermissionEnforced(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                mRemote.transact(88, parcel, parcel1, 0);
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

            public boolean isProtectedBroadcast(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                mRemote.transact(21, parcel, parcel1, 0);
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

            public boolean isSafeMode() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                mRemote.transact(67, parcel, parcel1, 0);
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

            public boolean isStorageLow() throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                mRemote.transact(89, parcel, parcel1, 0);
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

            public void movePackage(String s, IPackageMoveObserver ipackagemoveobserver, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IBinder ibinder;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                if(ipackagemoveobserver == null)
                    break MISSING_BLOCK_LABEL_81;
                ibinder = ipackagemoveobserver.asBinder();
_L1:
                parcel.writeStrongBinder(ibinder);
                parcel.writeInt(i);
                mRemote.transact(74, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                ibinder = null;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public String nextPackageToClean(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                String s1;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                mRemote.transact(73, parcel, parcel1, 0);
                parcel1.readException();
                s1 = parcel1.readString();
                parcel1.recycle();
                parcel.recycle();
                return s1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void performBootDexOpt() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                mRemote.transact(70, parcel, parcel1, 0);
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

            public boolean performDexOpt(String s) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                mRemote.transact(71, parcel, parcel1, 0);
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

            public List queryContentProviders(String s, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ArrayList arraylist;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(38, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(ProviderInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List queryInstrumentation(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ArrayList arraylist;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(40, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(InstrumentationInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List queryIntentActivities(Intent intent, String s, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(intent == null)
                    break MISSING_BLOCK_LABEL_98;
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L1:
                ArrayList arraylist;
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(28, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(ResolveInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List queryIntentActivityOptions(ComponentName componentname, Intent aintent[], String as[], Intent intent, String s, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(componentname == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L3:
                parcel.writeTypedArray(aintent, 0);
                parcel.writeStringArray(as);
                if(intent == null)
                    break MISSING_BLOCK_LABEL_156;
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L4:
                ArrayList arraylist;
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(29, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(ResolveInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
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

            public List queryIntentReceivers(Intent intent, String s, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(intent == null)
                    break MISSING_BLOCK_LABEL_98;
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L1:
                ArrayList arraylist;
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(30, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(ResolveInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List queryIntentServices(Intent intent, String s, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(intent == null)
                    break MISSING_BLOCK_LABEL_98;
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L1:
                ArrayList arraylist;
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(32, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(ResolveInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                parcel.writeInt(0);
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public List queryPermissionsByGroup(String s, int i) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ArrayList arraylist;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                mRemote.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                arraylist = parcel1.createTypedArrayList(PermissionInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return arraylist;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void querySyncProviders(List list, List list1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeStringList(list);
                parcel.writeTypedList(list1);
                mRemote.transact(37, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.readStringList(list);
                parcel1.readTypedList(list1, ProviderInfo.CREATOR);
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void removePackageFromPreferred(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
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

            public void removePermission(String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
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

            public boolean removeUser(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                mRemote.transact(79, parcel, parcel1, 0);
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

            public void replacePreferredActivity(IntentFilter intentfilter, int i, ComponentName acomponentname[], ComponentName componentname) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(intentfilter == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                intentfilter.writeToParcel(parcel, 0);
_L3:
                parcel.writeInt(i);
                parcel.writeTypedArray(acomponentname, 0);
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_123;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L4:
                mRemote.transact(50, parcel, parcel1, 0);
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

            public ProviderInfo resolveContentProvider(String s, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(36, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                ProviderInfo providerinfo = (ProviderInfo)ProviderInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return providerinfo;
_L2:
                providerinfo = null;
                if(true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public ResolveInfo resolveIntent(Intent intent, String s, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(intent == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L3:
                ResolveInfo resolveinfo;
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(27, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_135;
                resolveinfo = (ResolveInfo)ResolveInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return resolveinfo;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                resolveinfo = null;
                  goto _L4
            }

            public ResolveInfo resolveService(Intent intent, String s, int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(intent == null) goto _L2; else goto _L1
_L1:
                parcel.writeInt(1);
                intent.writeToParcel(parcel, 0);
_L3:
                ResolveInfo resolveinfo;
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(31, parcel, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0)
                    break MISSING_BLOCK_LABEL_135;
                resolveinfo = (ResolveInfo)ResolveInfo.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return resolveinfo;
_L2:
                parcel.writeInt(0);
                  goto _L3
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                resolveinfo = null;
                  goto _L4
            }

            public void revokePermission(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeString(s1);
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

            public void setApplicationEnabledSetting(String s, int i, int j, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(55, parcel, parcel1, 0);
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

            public void setComponentEnabledSetting(ComponentName componentname, int i, int j, int k) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(componentname == null)
                    break MISSING_BLOCK_LABEL_86;
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
_L1:
                parcel.writeInt(i);
                parcel.writeInt(j);
                parcel.writeInt(k);
                mRemote.transact(53, parcel, parcel1, 0);
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

            public boolean setInstallLocation(int i) throws RemoteException {
                boolean flag;
                Parcel parcel;
                Parcel parcel1;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                mRemote.transact(76, parcel, parcel1, 0);
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

            public void setInstallerPackageName(String s, String s1) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                parcel.writeString(s1);
                mRemote.transact(43, parcel, parcel1, 0);
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

            public void setPackageStoppedState(String s, boolean flag, int i) throws RemoteException {
                int j;
                Parcel parcel;
                Parcel parcel1;
                j = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                if(flag)
                    j = 1;
                parcel.writeInt(j);
                parcel.writeInt(i);
                mRemote.transact(57, parcel, parcel1, 0);
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

            public void setPermissionEnforced(String s, boolean flag) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeString(s);
                if(flag)
                    i = 1;
                parcel.writeInt(i);
                mRemote.transact(87, parcel, parcel1, 0);
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

            public void systemReady() throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                mRemote.transact(68, parcel, parcel1, 0);
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

            public void updateExternalMediaStatus(boolean flag, boolean flag1) throws RemoteException {
                int i;
                Parcel parcel;
                Parcel parcel1;
                i = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int j;
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                if(!flag)
                    break MISSING_BLOCK_LABEL_76;
                j = i;
_L1:
                parcel.writeInt(j);
                if(!flag1)
                    i = 0;
                parcel.writeInt(i);
                mRemote.transact(72, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                j = 0;
                  goto _L1
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public void updateUserName(int i, String s) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                parcel.writeString(s);
                mRemote.transact(80, parcel, parcel1, 0);
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

            public void verifyPendingInstall(int i, int j) throws RemoteException {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("android.content.pm.IPackageManager");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(82, parcel, parcel1, 0);
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


        public static IPackageManager asInterface(IBinder ibinder) {
            Object obj;
            if(ibinder == null) {
                obj = null;
            } else {
                IInterface iinterface = ibinder.queryLocalInterface("android.content.pm.IPackageManager");
                if(iinterface != null && (iinterface instanceof IPackageManager))
                    obj = (IPackageManager)iinterface;
                else
                    obj = new Proxy(ibinder);
            }
            return ((IPackageManager) (obj));
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
            i;
            JVM INSTR lookupswitch 90: default 732
        //                       1: 758
        //                       2: 817
        //                       3: 853
        //                       4: 885
        //                       5: 917
        //                       6: 949
        //                       7: 1004
        //                       8: 1040
        //                       9: 1095
        //                       10: 1127
        //                       11: 1186
        //                       12: 1270
        //                       13: 1354
        //                       14: 1438
        //                       15: 1522
        //                       16: 1558
        //                       17: 1594
        //                       18: 1665
        //                       19: 1689
        //                       20: 1717
        //                       21: 1745
        //                       22: 1791
        //                       23: 1827
        //                       24: 1863
        //                       25: 1895
        //                       26: 1927
        //                       27: 1959
        //                       28: 2047
        //                       29: 2116
        //                       30: 2236
        //                       31: 2305
        //                       32: 2393
        //                       33: 2462
        //                       34: 2517
        //                       35: 2576
        //                       36: 2608
        //                       37: 2667
        //                       38: 2718
        //                       39: 2758
        //                       40: 2838
        //                       41: 2874
        //                       42: 2938
        //                       43: 2962
        //                       44: 2990
        //                       45: 3025
        //                       46: 3057
        //                       47: 3081
        //                       48: 3105
        //                       49: 3137
        //                       50: 3237
        //                       51: 3337
        //                       52: 3361
        //                       53: 3427
        //                       54: 3488
        //                       55: 3549
        //                       56: 3585
        //                       57: 3621
        //                       58: 3671
        //                       59: 3702
        //                       60: 3759
        //                       61: 3790
        //                       62: 3825
        //                       63: 3856
        //                       64: 3884
        //                       65: 3913
        //                       66: 3959
        //                       67: 3979
        //                       68: 4021
        //                       69: 4041
        //                       70: 4083
        //                       71: 4103
        //                       72: 4149
        //                       73: 4205
        //                       74: 4237
        //                       75: 4272
        //                       76: 4343
        //                       77: 4389
        //                       78: 4417
        //                       79: 4472
        //                       80: 4518
        //                       81: 4546
        //                       82: 4709
        //                       83: 4737
        //                       84: 4784
        //                       85: 4826
        //                       86: 4854
        //                       87: 4905
        //                       88: 4951
        //                       89: 4997
        //                       1598968902: 746;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67 _L68 _L69 _L70 _L71 _L72 _L73 _L74 _L75 _L76 _L77 _L78 _L79 _L80 _L81 _L82 _L83 _L84 _L85 _L86 _L87 _L88 _L89 _L90 _L91
_L1:
            boolean flag1 = super.onTransact(i, parcel, parcel1, j);
_L93:
            return flag1;
_L91:
            parcel1.writeString("android.content.pm.IPackageManager");
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L2:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            PackageInfo packageinfo = getPackageInfo(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(packageinfo != null) {
                parcel1.writeInt(1);
                packageinfo.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L3:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            int l6 = getPackageUid(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(l6);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L4:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            int ai[] = getPackageGids(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeIntArray(ai);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L5:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            String as4[] = currentToCanonicalPackageNames(parcel.createStringArray());
            parcel1.writeNoException();
            parcel1.writeStringArray(as4);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L6:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            String as3[] = canonicalToCurrentPackageNames(parcel.createStringArray());
            parcel1.writeNoException();
            parcel1.writeStringArray(as3);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L7:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            PermissionInfo permissioninfo2 = getPermissionInfo(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            if(permissioninfo2 != null) {
                parcel1.writeInt(1);
                permissioninfo2.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L8:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            List list10 = queryPermissionsByGroup(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeTypedList(list10);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L9:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            PermissionGroupInfo permissiongroupinfo = getPermissionGroupInfo(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            if(permissiongroupinfo != null) {
                parcel1.writeInt(1);
                permissiongroupinfo.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L10:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            List list9 = getAllPermissionGroups(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeTypedList(list9);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L11:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ApplicationInfo applicationinfo = getApplicationInfo(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(applicationinfo != null) {
                parcel1.writeInt(1);
                applicationinfo.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L12:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ComponentName componentname9;
            ActivityInfo activityinfo1;
            if(parcel.readInt() != 0)
                componentname9 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname9 = null;
            activityinfo1 = getActivityInfo(componentname9, parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(activityinfo1 != null) {
                parcel1.writeInt(1);
                activityinfo1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L13:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ComponentName componentname8;
            ActivityInfo activityinfo;
            if(parcel.readInt() != 0)
                componentname8 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname8 = null;
            activityinfo = getReceiverInfo(componentname8, parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(activityinfo != null) {
                parcel1.writeInt(1);
                activityinfo.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L14:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ComponentName componentname7;
            ServiceInfo serviceinfo;
            if(parcel.readInt() != 0)
                componentname7 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname7 = null;
            serviceinfo = getServiceInfo(componentname7, parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(serviceinfo != null) {
                parcel1.writeInt(1);
                serviceinfo.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L15:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ComponentName componentname6;
            ProviderInfo providerinfo1;
            if(parcel.readInt() != 0)
                componentname6 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname6 = null;
            providerinfo1 = getProviderInfo(componentname6, parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(providerinfo1 != null) {
                parcel1.writeInt(1);
                providerinfo1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L16:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            int k6 = checkPermission(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(k6);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L17:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            int j6 = checkUidPermission(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(j6);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L18:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            PermissionInfo permissioninfo1;
            boolean flag16;
            int i6;
            if(parcel.readInt() != 0)
                permissioninfo1 = (PermissionInfo)PermissionInfo.CREATOR.createFromParcel(parcel);
            else
                permissioninfo1 = null;
            flag16 = addPermission(permissioninfo1);
            parcel1.writeNoException();
            if(flag16)
                i6 = 1;
            else
                i6 = 0;
            parcel1.writeInt(i6);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L19:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            removePermission(parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L20:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            grantPermission(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L21:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            revokePermission(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L22:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            boolean flag15 = isProtectedBroadcast(parcel.readString());
            parcel1.writeNoException();
            int l5;
            if(flag15)
                l5 = 1;
            else
                l5 = 0;
            parcel1.writeInt(l5);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L23:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            int k5 = checkSignatures(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(k5);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L24:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            int j5 = checkUidSignatures(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(j5);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L25:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            String as2[] = getPackagesForUid(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeStringArray(as2);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L26:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            String s5 = getNameForUid(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeString(s5);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L27:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            int i5 = getUidForSharedUser(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(i5);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L28:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            Intent intent5;
            ResolveInfo resolveinfo1;
            if(parcel.readInt() != 0)
                intent5 = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent5 = null;
            resolveinfo1 = resolveIntent(intent5, parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(resolveinfo1 != null) {
                parcel1.writeInt(1);
                resolveinfo1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L29:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            Intent intent4;
            List list8;
            if(parcel.readInt() != 0)
                intent4 = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent4 = null;
            list8 = queryIntentActivities(intent4, parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeTypedList(list8);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L30:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ComponentName componentname5;
            Intent aintent[];
            String as1[];
            Intent intent3;
            List list7;
            if(parcel.readInt() != 0)
                componentname5 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname5 = null;
            aintent = (Intent[])parcel.createTypedArray(Intent.CREATOR);
            as1 = parcel.createStringArray();
            if(parcel.readInt() != 0)
                intent3 = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent3 = null;
            list7 = queryIntentActivityOptions(componentname5, aintent, as1, intent3, parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeTypedList(list7);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L31:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            Intent intent2;
            List list6;
            if(parcel.readInt() != 0)
                intent2 = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent2 = null;
            list6 = queryIntentReceivers(intent2, parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeTypedList(list6);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L32:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            Intent intent1;
            ResolveInfo resolveinfo;
            if(parcel.readInt() != 0)
                intent1 = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent1 = null;
            resolveinfo = resolveService(intent1, parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(resolveinfo != null) {
                parcel1.writeInt(1);
                resolveinfo.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L33:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            Intent intent;
            List list5;
            if(parcel.readInt() != 0)
                intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent = null;
            list5 = queryIntentServices(intent, parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeTypedList(list5);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L34:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ParceledListSlice parceledlistslice1 = getInstalledPackages(parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            if(parceledlistslice1 != null) {
                parcel1.writeInt(1);
                parceledlistslice1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L35:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ParceledListSlice parceledlistslice = getInstalledApplications(parcel.readInt(), parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            if(parceledlistslice != null) {
                parcel1.writeInt(1);
                parceledlistslice.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L36:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            List list4 = getPersistentApplications(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeTypedList(list4);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L37:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ProviderInfo providerinfo = resolveContentProvider(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if(providerinfo != null) {
                parcel1.writeInt(1);
                providerinfo.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L38:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ArrayList arraylist2 = parcel.createStringArrayList();
            ArrayList arraylist3 = parcel.createTypedArrayList(ProviderInfo.CREATOR);
            querySyncProviders(arraylist2, arraylist3);
            parcel1.writeNoException();
            parcel1.writeStringList(arraylist2);
            parcel1.writeTypedList(arraylist3);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L39:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            List list3 = queryContentProviders(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeTypedList(list3);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L40:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ComponentName componentname4;
            InstrumentationInfo instrumentationinfo;
            if(parcel.readInt() != 0)
                componentname4 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname4 = null;
            instrumentationinfo = getInstrumentationInfo(componentname4, parcel.readInt());
            parcel1.writeNoException();
            if(instrumentationinfo != null) {
                parcel1.writeInt(1);
                instrumentationinfo.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L41:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            List list2 = queryInstrumentation(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeTypedList(list2);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L42:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            Uri uri2;
            if(parcel.readInt() != 0)
                uri2 = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri2 = null;
            installPackage(uri2, IPackageInstallObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L43:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            finishPackageInstall(parcel.readInt());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L44:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            setInstallerPackageName(parcel.readString(), parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L45:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            deletePackage(parcel.readString(), IPackageDeleteObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L46:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            String s4 = getInstallerPackageName(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s4);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L47:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            addPackageToPreferred(parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L48:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            removePackageFromPreferred(parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L49:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            List list1 = getPreferredPackages(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeTypedList(list1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L50:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            IntentFilter intentfilter1;
            int l4;
            ComponentName acomponentname1[];
            ComponentName componentname3;
            if(parcel.readInt() != 0)
                intentfilter1 = (IntentFilter)IntentFilter.CREATOR.createFromParcel(parcel);
            else
                intentfilter1 = null;
            l4 = parcel.readInt();
            acomponentname1 = (ComponentName[])parcel.createTypedArray(ComponentName.CREATOR);
            if(parcel.readInt() != 0)
                componentname3 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname3 = null;
            addPreferredActivity(intentfilter1, l4, acomponentname1, componentname3);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L51:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            IntentFilter intentfilter;
            int k4;
            ComponentName acomponentname[];
            ComponentName componentname2;
            if(parcel.readInt() != 0)
                intentfilter = (IntentFilter)IntentFilter.CREATOR.createFromParcel(parcel);
            else
                intentfilter = null;
            k4 = parcel.readInt();
            acomponentname = (ComponentName[])parcel.createTypedArray(ComponentName.CREATOR);
            if(parcel.readInt() != 0)
                componentname2 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname2 = null;
            replacePreferredActivity(intentfilter, k4, acomponentname, componentname2);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L52:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            clearPackagePreferredActivities(parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L53:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ArrayList arraylist = new ArrayList();
            ArrayList arraylist1 = new ArrayList();
            int j4 = getPreferredActivities(arraylist, arraylist1, parcel.readString());
            parcel1.writeNoException();
            parcel1.writeInt(j4);
            parcel1.writeTypedList(arraylist);
            parcel1.writeTypedList(arraylist1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L54:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ComponentName componentname1;
            if(parcel.readInt() != 0)
                componentname1 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname1 = null;
            setComponentEnabledSetting(componentname1, parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L55:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            ComponentName componentname;
            int i4;
            if(parcel.readInt() != 0)
                componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
            else
                componentname = null;
            i4 = getComponentEnabledSetting(componentname, parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(i4);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L56:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            setApplicationEnabledSetting(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L57:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            int k3 = getApplicationEnabledSetting(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(k3);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L58:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            String s3 = parcel.readString();
            boolean flag14;
            if(parcel.readInt() != 0)
                flag14 = true;
            else
                flag14 = false;
            setPackageStoppedState(s3, flag14, parcel.readInt());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L59:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            freeStorageAndNotify(parcel.readLong(), IPackageDataObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L60:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            long l3 = parcel.readLong();
            IntentSender intentsender;
            if(parcel.readInt() != 0)
                intentsender = (IntentSender)IntentSender.CREATOR.createFromParcel(parcel);
            else
                intentsender = null;
            freeStorage(l3, intentsender);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L61:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            deleteApplicationCacheFiles(parcel.readString(), IPackageDataObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L62:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            clearApplicationUserData(parcel.readString(), IPackageDataObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L63:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            getPackageSizeInfo(parcel.readString(), IPackageStatsObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L64:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            String as[] = getSystemSharedLibraryNames();
            parcel1.writeNoException();
            parcel1.writeStringArray(as);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L65:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            FeatureInfo afeatureinfo[] = getSystemAvailableFeatures();
            parcel1.writeNoException();
            parcel1.writeTypedArray(afeatureinfo, 1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L66:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            boolean flag13 = hasSystemFeature(parcel.readString());
            parcel1.writeNoException();
            int j3;
            if(flag13)
                j3 = 1;
            else
                j3 = 0;
            parcel1.writeInt(j3);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L67:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            enterSafeMode();
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L68:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            boolean flag12 = isSafeMode();
            parcel1.writeNoException();
            int i3;
            if(flag12)
                i3 = 1;
            else
                i3 = 0;
            parcel1.writeInt(i3);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L69:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            systemReady();
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L70:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            boolean flag11 = hasSystemUidErrors();
            parcel1.writeNoException();
            int l2;
            if(flag11)
                l2 = 1;
            else
                l2 = 0;
            parcel1.writeInt(l2);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L71:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            performBootDexOpt();
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L72:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            boolean flag10 = performDexOpt(parcel.readString());
            parcel1.writeNoException();
            int k2;
            if(flag10)
                k2 = 1;
            else
                k2 = 0;
            parcel1.writeInt(k2);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L73:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            boolean flag8;
            boolean flag9;
            if(parcel.readInt() != 0)
                flag8 = true;
            else
                flag8 = false;
            if(parcel.readInt() != 0)
                flag9 = true;
            else
                flag9 = false;
            updateExternalMediaStatus(flag8, flag9);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L74:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            String s2 = nextPackageToClean(parcel.readString());
            parcel1.writeNoException();
            parcel1.writeString(s2);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L75:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            movePackage(parcel.readString(), IPackageMoveObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L76:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            PermissionInfo permissioninfo;
            boolean flag7;
            int j2;
            if(parcel.readInt() != 0)
                permissioninfo = (PermissionInfo)PermissionInfo.CREATOR.createFromParcel(parcel);
            else
                permissioninfo = null;
            flag7 = addPermissionAsync(permissioninfo);
            parcel1.writeNoException();
            if(flag7)
                j2 = 1;
            else
                j2 = 0;
            parcel1.writeInt(j2);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L77:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            boolean flag6 = setInstallLocation(parcel.readInt());
            parcel1.writeNoException();
            int i2;
            if(flag6)
                i2 = 1;
            else
                i2 = 0;
            parcel1.writeInt(i2);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L78:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            int l1 = getInstallLocation();
            parcel1.writeNoException();
            parcel1.writeInt(l1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L79:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            UserInfo userinfo1 = createUser(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            if(userinfo1 != null) {
                parcel1.writeInt(1);
                userinfo1.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L80:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            boolean flag5 = removeUser(parcel.readInt());
            parcel1.writeNoException();
            int k1;
            if(flag5)
                k1 = 1;
            else
                k1 = 0;
            parcel1.writeInt(k1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L81:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            updateUserName(parcel.readInt(), parcel.readString());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L82:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            Uri uri;
            IPackageInstallObserver ipackageinstallobserver;
            int j1;
            String s1;
            Uri uri1;
            ManifestDigest manifestdigest;
            ContainerEncryptionParams containerencryptionparams;
            if(parcel.readInt() != 0)
                uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri = null;
            ipackageinstallobserver = IPackageInstallObserver.Stub.asInterface(parcel.readStrongBinder());
            j1 = parcel.readInt();
            s1 = parcel.readString();
            if(parcel.readInt() != 0)
                uri1 = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri1 = null;
            if(parcel.readInt() != 0)
                manifestdigest = (ManifestDigest)ManifestDigest.CREATOR.createFromParcel(parcel);
            else
                manifestdigest = null;
            if(parcel.readInt() != 0)
                containerencryptionparams = (ContainerEncryptionParams)ContainerEncryptionParams.CREATOR.createFromParcel(parcel);
            else
                containerencryptionparams = null;
            installPackageWithVerification(uri, ipackageinstallobserver, j1, s1, uri1, manifestdigest, containerencryptionparams);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L83:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            verifyPendingInstall(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L84:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            VerifierDeviceIdentity verifierdeviceidentity = getVerifierDeviceIdentity();
            parcel1.writeNoException();
            if(verifierdeviceidentity != null) {
                parcel1.writeInt(1);
                verifierdeviceidentity.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L85:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            boolean flag4 = isFirstBoot();
            parcel1.writeNoException();
            int i1;
            if(flag4)
                i1 = 1;
            else
                i1 = 0;
            parcel1.writeInt(i1);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L86:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            List list = getUsers();
            parcel1.writeNoException();
            parcel1.writeTypedList(list);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L87:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            UserInfo userinfo = getUser(parcel.readInt());
            parcel1.writeNoException();
            if(userinfo != null) {
                parcel1.writeInt(1);
                userinfo.writeToParcel(parcel1, 1);
            } else {
                parcel1.writeInt(0);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L88:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            String s = parcel.readString();
            boolean flag3;
            if(parcel.readInt() != 0)
                flag3 = true;
            else
                flag3 = false;
            setPermissionEnforced(s, flag3);
            parcel1.writeNoException();
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L89:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            boolean flag2 = isPermissionEnforced(parcel.readString());
            parcel1.writeNoException();
            int l;
            if(flag2)
                l = 1;
            else
                l = 0;
            parcel1.writeInt(l);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
_L90:
            parcel.enforceInterface("android.content.pm.IPackageManager");
            boolean flag = isStorageLow();
            parcel1.writeNoException();
            int k;
            if(flag)
                k = 1;
            else
                k = 0;
            parcel1.writeInt(k);
            flag1 = true;
            if(true) goto _L93; else goto _L92
_L92:
        }

        private static final String DESCRIPTOR = "android.content.pm.IPackageManager";
        static final int TRANSACTION_addPackageToPreferred = 46;
        static final int TRANSACTION_addPermission = 17;
        static final int TRANSACTION_addPermissionAsync = 75;
        static final int TRANSACTION_addPreferredActivity = 49;
        static final int TRANSACTION_canonicalToCurrentPackageNames = 5;
        static final int TRANSACTION_checkPermission = 15;
        static final int TRANSACTION_checkSignatures = 22;
        static final int TRANSACTION_checkUidPermission = 16;
        static final int TRANSACTION_checkUidSignatures = 23;
        static final int TRANSACTION_clearApplicationUserData = 61;
        static final int TRANSACTION_clearPackagePreferredActivities = 51;
        static final int TRANSACTION_createUser = 78;
        static final int TRANSACTION_currentToCanonicalPackageNames = 4;
        static final int TRANSACTION_deleteApplicationCacheFiles = 60;
        static final int TRANSACTION_deletePackage = 44;
        static final int TRANSACTION_enterSafeMode = 66;
        static final int TRANSACTION_finishPackageInstall = 42;
        static final int TRANSACTION_freeStorage = 59;
        static final int TRANSACTION_freeStorageAndNotify = 58;
        static final int TRANSACTION_getActivityInfo = 11;
        static final int TRANSACTION_getAllPermissionGroups = 9;
        static final int TRANSACTION_getApplicationEnabledSetting = 56;
        static final int TRANSACTION_getApplicationInfo = 10;
        static final int TRANSACTION_getComponentEnabledSetting = 54;
        static final int TRANSACTION_getInstallLocation = 77;
        static final int TRANSACTION_getInstalledApplications = 34;
        static final int TRANSACTION_getInstalledPackages = 33;
        static final int TRANSACTION_getInstallerPackageName = 45;
        static final int TRANSACTION_getInstrumentationInfo = 39;
        static final int TRANSACTION_getNameForUid = 25;
        static final int TRANSACTION_getPackageGids = 3;
        static final int TRANSACTION_getPackageInfo = 1;
        static final int TRANSACTION_getPackageSizeInfo = 62;
        static final int TRANSACTION_getPackageUid = 2;
        static final int TRANSACTION_getPackagesForUid = 24;
        static final int TRANSACTION_getPermissionGroupInfo = 8;
        static final int TRANSACTION_getPermissionInfo = 6;
        static final int TRANSACTION_getPersistentApplications = 35;
        static final int TRANSACTION_getPreferredActivities = 52;
        static final int TRANSACTION_getPreferredPackages = 48;
        static final int TRANSACTION_getProviderInfo = 14;
        static final int TRANSACTION_getReceiverInfo = 12;
        static final int TRANSACTION_getServiceInfo = 13;
        static final int TRANSACTION_getSystemAvailableFeatures = 64;
        static final int TRANSACTION_getSystemSharedLibraryNames = 63;
        static final int TRANSACTION_getUidForSharedUser = 26;
        static final int TRANSACTION_getUser = 86;
        static final int TRANSACTION_getUsers = 85;
        static final int TRANSACTION_getVerifierDeviceIdentity = 83;
        static final int TRANSACTION_grantPermission = 19;
        static final int TRANSACTION_hasSystemFeature = 65;
        static final int TRANSACTION_hasSystemUidErrors = 69;
        static final int TRANSACTION_installPackage = 41;
        static final int TRANSACTION_installPackageWithVerification = 81;
        static final int TRANSACTION_isFirstBoot = 84;
        static final int TRANSACTION_isPermissionEnforced = 88;
        static final int TRANSACTION_isProtectedBroadcast = 21;
        static final int TRANSACTION_isSafeMode = 67;
        static final int TRANSACTION_isStorageLow = 89;
        static final int TRANSACTION_movePackage = 74;
        static final int TRANSACTION_nextPackageToClean = 73;
        static final int TRANSACTION_performBootDexOpt = 70;
        static final int TRANSACTION_performDexOpt = 71;
        static final int TRANSACTION_queryContentProviders = 38;
        static final int TRANSACTION_queryInstrumentation = 40;
        static final int TRANSACTION_queryIntentActivities = 28;
        static final int TRANSACTION_queryIntentActivityOptions = 29;
        static final int TRANSACTION_queryIntentReceivers = 30;
        static final int TRANSACTION_queryIntentServices = 32;
        static final int TRANSACTION_queryPermissionsByGroup = 7;
        static final int TRANSACTION_querySyncProviders = 37;
        static final int TRANSACTION_removePackageFromPreferred = 47;
        static final int TRANSACTION_removePermission = 18;
        static final int TRANSACTION_removeUser = 79;
        static final int TRANSACTION_replacePreferredActivity = 50;
        static final int TRANSACTION_resolveContentProvider = 36;
        static final int TRANSACTION_resolveIntent = 27;
        static final int TRANSACTION_resolveService = 31;
        static final int TRANSACTION_revokePermission = 20;
        static final int TRANSACTION_setApplicationEnabledSetting = 55;
        static final int TRANSACTION_setComponentEnabledSetting = 53;
        static final int TRANSACTION_setInstallLocation = 76;
        static final int TRANSACTION_setInstallerPackageName = 43;
        static final int TRANSACTION_setPackageStoppedState = 57;
        static final int TRANSACTION_setPermissionEnforced = 87;
        static final int TRANSACTION_systemReady = 68;
        static final int TRANSACTION_updateExternalMediaStatus = 72;
        static final int TRANSACTION_updateUserName = 80;
        static final int TRANSACTION_verifyPendingInstall = 82;

        public Stub() {
            attachInterface(this, "android.content.pm.IPackageManager");
        }
    }


    public abstract void addPackageToPreferred(String s) throws RemoteException;

    public abstract boolean addPermission(PermissionInfo permissioninfo) throws RemoteException;

    public abstract boolean addPermissionAsync(PermissionInfo permissioninfo) throws RemoteException;

    public abstract void addPreferredActivity(IntentFilter intentfilter, int i, ComponentName acomponentname[], ComponentName componentname) throws RemoteException;

    public abstract String[] canonicalToCurrentPackageNames(String as[]) throws RemoteException;

    public abstract int checkPermission(String s, String s1) throws RemoteException;

    public abstract int checkSignatures(String s, String s1) throws RemoteException;

    public abstract int checkUidPermission(String s, int i) throws RemoteException;

    public abstract int checkUidSignatures(int i, int j) throws RemoteException;

    public abstract void clearApplicationUserData(String s, IPackageDataObserver ipackagedataobserver, int i) throws RemoteException;

    public abstract void clearPackagePreferredActivities(String s) throws RemoteException;

    public abstract UserInfo createUser(String s, int i) throws RemoteException;

    public abstract String[] currentToCanonicalPackageNames(String as[]) throws RemoteException;

    public abstract void deleteApplicationCacheFiles(String s, IPackageDataObserver ipackagedataobserver) throws RemoteException;

    public abstract void deletePackage(String s, IPackageDeleteObserver ipackagedeleteobserver, int i) throws RemoteException;

    public abstract void enterSafeMode() throws RemoteException;

    public abstract void finishPackageInstall(int i) throws RemoteException;

    public abstract void freeStorage(long l, IntentSender intentsender) throws RemoteException;

    public abstract void freeStorageAndNotify(long l, IPackageDataObserver ipackagedataobserver) throws RemoteException;

    public abstract ActivityInfo getActivityInfo(ComponentName componentname, int i, int j) throws RemoteException;

    public abstract List getAllPermissionGroups(int i) throws RemoteException;

    public abstract int getApplicationEnabledSetting(String s, int i) throws RemoteException;

    public abstract ApplicationInfo getApplicationInfo(String s, int i, int j) throws RemoteException;

    public abstract int getComponentEnabledSetting(ComponentName componentname, int i) throws RemoteException;

    public abstract int getInstallLocation() throws RemoteException;

    public abstract ParceledListSlice getInstalledApplications(int i, String s, int j) throws RemoteException;

    public abstract ParceledListSlice getInstalledPackages(int i, String s) throws RemoteException;

    public abstract String getInstallerPackageName(String s) throws RemoteException;

    public abstract InstrumentationInfo getInstrumentationInfo(ComponentName componentname, int i) throws RemoteException;

    public abstract String getNameForUid(int i) throws RemoteException;

    public abstract int[] getPackageGids(String s) throws RemoteException;

    public abstract PackageInfo getPackageInfo(String s, int i, int j) throws RemoteException;

    public abstract void getPackageSizeInfo(String s, IPackageStatsObserver ipackagestatsobserver) throws RemoteException;

    public abstract int getPackageUid(String s, int i) throws RemoteException;

    public abstract String[] getPackagesForUid(int i) throws RemoteException;

    public abstract PermissionGroupInfo getPermissionGroupInfo(String s, int i) throws RemoteException;

    public abstract PermissionInfo getPermissionInfo(String s, int i) throws RemoteException;

    public abstract List getPersistentApplications(int i) throws RemoteException;

    public abstract int getPreferredActivities(List list, List list1, String s) throws RemoteException;

    public abstract List getPreferredPackages(int i) throws RemoteException;

    public abstract ProviderInfo getProviderInfo(ComponentName componentname, int i, int j) throws RemoteException;

    public abstract ActivityInfo getReceiverInfo(ComponentName componentname, int i, int j) throws RemoteException;

    public abstract ServiceInfo getServiceInfo(ComponentName componentname, int i, int j) throws RemoteException;

    public abstract FeatureInfo[] getSystemAvailableFeatures() throws RemoteException;

    public abstract String[] getSystemSharedLibraryNames() throws RemoteException;

    public abstract int getUidForSharedUser(String s) throws RemoteException;

    public abstract UserInfo getUser(int i) throws RemoteException;

    public abstract List getUsers() throws RemoteException;

    public abstract VerifierDeviceIdentity getVerifierDeviceIdentity() throws RemoteException;

    public abstract void grantPermission(String s, String s1) throws RemoteException;

    public abstract boolean hasSystemFeature(String s) throws RemoteException;

    public abstract boolean hasSystemUidErrors() throws RemoteException;

    public abstract void installPackage(Uri uri, IPackageInstallObserver ipackageinstallobserver, int i, String s) throws RemoteException;

    public abstract void installPackageWithVerification(Uri uri, IPackageInstallObserver ipackageinstallobserver, int i, String s, Uri uri1, ManifestDigest manifestdigest, ContainerEncryptionParams containerencryptionparams) throws RemoteException;

    public abstract boolean isFirstBoot() throws RemoteException;

    public abstract boolean isPermissionEnforced(String s) throws RemoteException;

    public abstract boolean isProtectedBroadcast(String s) throws RemoteException;

    public abstract boolean isSafeMode() throws RemoteException;

    public abstract boolean isStorageLow() throws RemoteException;

    public abstract void movePackage(String s, IPackageMoveObserver ipackagemoveobserver, int i) throws RemoteException;

    public abstract String nextPackageToClean(String s) throws RemoteException;

    public abstract void performBootDexOpt() throws RemoteException;

    public abstract boolean performDexOpt(String s) throws RemoteException;

    public abstract List queryContentProviders(String s, int i, int j) throws RemoteException;

    public abstract List queryInstrumentation(String s, int i) throws RemoteException;

    public abstract List queryIntentActivities(Intent intent, String s, int i, int j) throws RemoteException;

    public abstract List queryIntentActivityOptions(ComponentName componentname, Intent aintent[], String as[], Intent intent, String s, int i, int j) throws RemoteException;

    public abstract List queryIntentReceivers(Intent intent, String s, int i, int j) throws RemoteException;

    public abstract List queryIntentServices(Intent intent, String s, int i, int j) throws RemoteException;

    public abstract List queryPermissionsByGroup(String s, int i) throws RemoteException;

    public abstract void querySyncProviders(List list, List list1) throws RemoteException;

    public abstract void removePackageFromPreferred(String s) throws RemoteException;

    public abstract void removePermission(String s) throws RemoteException;

    public abstract boolean removeUser(int i) throws RemoteException;

    public abstract void replacePreferredActivity(IntentFilter intentfilter, int i, ComponentName acomponentname[], ComponentName componentname) throws RemoteException;

    public abstract ProviderInfo resolveContentProvider(String s, int i, int j) throws RemoteException;

    public abstract ResolveInfo resolveIntent(Intent intent, String s, int i, int j) throws RemoteException;

    public abstract ResolveInfo resolveService(Intent intent, String s, int i, int j) throws RemoteException;

    public abstract void revokePermission(String s, String s1) throws RemoteException;

    public abstract void setApplicationEnabledSetting(String s, int i, int j, int k) throws RemoteException;

    public abstract void setComponentEnabledSetting(ComponentName componentname, int i, int j, int k) throws RemoteException;

    public abstract boolean setInstallLocation(int i) throws RemoteException;

    public abstract void setInstallerPackageName(String s, String s1) throws RemoteException;

    public abstract void setPackageStoppedState(String s, boolean flag, int i) throws RemoteException;

    public abstract void setPermissionEnforced(String s, boolean flag) throws RemoteException;

    public abstract void systemReady() throws RemoteException;

    public abstract void updateExternalMediaStatus(boolean flag, boolean flag1) throws RemoteException;

    public abstract void updateUserName(int i, String s) throws RemoteException;

    public abstract void verifyPendingInstall(int i, int j) throws RemoteException;
}
