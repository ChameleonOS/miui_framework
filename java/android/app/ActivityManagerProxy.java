// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.*;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.*;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.app:
//            IActivityManager, IApplicationThread, IServiceConnection, PendingIntent, 
//            IThumbnailReceiver, IProcessObserver, IActivityController, Notification, 
//            IInstrumentationWatcher

class ActivityManagerProxy
    implements IActivityManager {

    public ActivityManagerProxy(IBinder ibinder) {
        mRemote = ibinder;
    }

    public void activityDestroyed(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(62, parcel, parcel1, 1);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void activityIdle(IBinder ibinder, Configuration configuration, boolean flag) throws RemoteException {
        int i = 0;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        if(configuration != null) {
            parcel.writeInt(1);
            configuration.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if(flag)
            i = 1;
        parcel.writeInt(i);
        mRemote.transact(18, parcel, parcel1, 1);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void activityPaused(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(19, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void activitySlept(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(123, parcel, parcel1, 1);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void activityStopped(IBinder ibinder, Bundle bundle, Bitmap bitmap, CharSequence charsequence) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeBundle(bundle);
        if(bitmap != null) {
            parcel.writeInt(1);
            bitmap.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        TextUtils.writeToParcel(charsequence, parcel, 0);
        mRemote.transact(20, parcel, parcel1, 1);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public IBinder asBinder() {
        return mRemote;
    }

    public void attachApplication(IApplicationThread iapplicationthread) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(iapplicationthread.asBinder());
        mRemote.transact(17, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void backupAgentCreated(String s, IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(91, parcel, parcel1, 0);
        parcel1.recycle();
        parcel.recycle();
    }

    public boolean bindBackupAgent(ApplicationInfo applicationinfo, int i) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        applicationinfo.writeToParcel(parcel, 0);
        parcel.writeInt(i);
        mRemote.transact(90, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel1.recycle();
        parcel.recycle();
        return flag;
    }

    public int bindService(IApplicationThread iapplicationthread, IBinder ibinder, Intent intent, String s, IServiceConnection iserviceconnection, int i, int j) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder1;
        int k;
        if(iapplicationthread != null)
            ibinder1 = iapplicationthread.asBinder();
        else
            ibinder1 = null;
        parcel.writeStrongBinder(ibinder1);
        parcel.writeStrongBinder(ibinder);
        intent.writeToParcel(parcel, 0);
        parcel.writeString(s);
        parcel.writeStrongBinder(iserviceconnection.asBinder());
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(36, parcel, parcel1, 0);
        parcel1.readException();
        k = parcel1.readInt();
        parcel.recycle();
        parcel1.recycle();
        return k;
    }

    public int broadcastIntent(IApplicationThread iapplicationthread, Intent intent, String s, IIntentReceiver iintentreceiver, int i, String s1, Bundle bundle, 
            String s2, boolean flag, boolean flag1, int j) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder;
        IBinder ibinder1;
        int k;
        int l;
        int i1;
        if(iapplicationthread != null)
            ibinder = iapplicationthread.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
        intent.writeToParcel(parcel, 0);
        parcel.writeString(s);
        if(iintentreceiver != null)
            ibinder1 = iintentreceiver.asBinder();
        else
            ibinder1 = null;
        parcel.writeStrongBinder(ibinder1);
        parcel.writeInt(i);
        parcel.writeString(s1);
        parcel.writeBundle(bundle);
        parcel.writeString(s2);
        if(flag)
            k = 1;
        else
            k = 0;
        parcel.writeInt(k);
        if(flag1)
            l = 1;
        else
            l = 0;
        parcel.writeInt(l);
        parcel.writeInt(j);
        mRemote.transact(14, parcel, parcel1, 0);
        parcel1.readException();
        i1 = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i1;
    }

    public void cancelIntentSender(IIntentSender iintentsender) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(iintentsender.asBinder());
        mRemote.transact(64, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public int checkGrantUriPermission(int i, String s, Uri uri, int j) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        parcel.writeString(s);
        uri.writeToParcel(parcel, 0);
        parcel.writeInt(j);
        mRemote.transact(119, parcel, parcel1, 0);
        parcel1.readException();
        int k = parcel1.readInt();
        parcel.recycle();
        parcel1.recycle();
        return k;
    }

    public int checkPermission(String s, int i, int j) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(53, parcel, parcel1, 0);
        parcel1.readException();
        int k = parcel1.readInt();
        parcel.recycle();
        parcel1.recycle();
        return k;
    }

    public int checkUriPermission(Uri uri, int i, int j, int k) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        uri.writeToParcel(parcel, 0);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeInt(k);
        mRemote.transact(54, parcel, parcel1, 0);
        parcel1.readException();
        int l = parcel1.readInt();
        parcel.recycle();
        parcel1.recycle();
        return l;
    }

    public boolean clearApplicationUserData(String s, IPackageDataObserver ipackagedataobserver, int i) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        parcel.writeStrongBinder(ipackagedataobserver.asBinder());
        parcel.writeInt(i);
        mRemote.transact(78, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public void closeSystemDialogs(String s) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        mRemote.transact(97, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void crashApplication(int i, int j, String s, String s1) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(s);
        parcel.writeString(s1);
        mRemote.transact(114, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void dismissKeyguardOnNextActivity() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(139, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public boolean dumpHeap(String s, boolean flag, String s1, ParcelFileDescriptor parcelfiledescriptor) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        int i;
        boolean flag1;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        parcel.writeString(s1);
        if(parcelfiledescriptor != null) {
            parcel.writeInt(1);
            parcelfiledescriptor.writeToParcel(parcel, 1);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(120, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag1 = true;
        else
            flag1 = false;
        parcel1.recycle();
        parcel.recycle();
        return flag1;
    }

    public void enterSafeMode() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(66, parcel, null, 0);
        parcel.recycle();
    }

    public boolean finishActivity(IBinder ibinder, int i, Intent intent) throws RemoteException {
        boolean flag = true;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        if(intent != null) {
            parcel.writeInt(flag);
            intent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(11, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() == 0)
            flag = false;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public boolean finishActivityAffinity(IBinder ibinder) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(149, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public void finishHeavyWeightApp() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(109, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void finishInstrumentation(IApplicationThread iapplicationthread, int i, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder;
        if(iapplicationthread != null)
            ibinder = iapplicationthread.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        parcel.writeBundle(bundle);
        mRemote.transact(45, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void finishReceiver(IBinder ibinder, int i, String s, Bundle bundle, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        parcel.writeString(s);
        parcel.writeBundle(bundle);
        int j;
        if(flag)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        mRemote.transact(16, parcel, parcel1, 1);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void finishSubActivity(IBinder ibinder, String s, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        parcel.writeInt(i);
        mRemote.transact(32, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void forceStopPackage(String s) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        mRemote.transact(79, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public ComponentName getActivityClassForToken(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(49, parcel, parcel1, 0);
        parcel1.readException();
        ComponentName componentname = ComponentName.readFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return componentname;
    }

    public ComponentName getCallingActivity(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(22, parcel, parcel1, 0);
        parcel1.readException();
        ComponentName componentname = ComponentName.readFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return componentname;
    }

    public String getCallingPackage(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(21, parcel, parcel1, 0);
        parcel1.readException();
        String s = parcel1.readString();
        parcel.recycle();
        parcel1.recycle();
        return s;
    }

    public Configuration getConfiguration() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(46, parcel, parcel1, 0);
        parcel1.readException();
        Configuration configuration = (Configuration)Configuration.CREATOR.createFromParcel(parcel1);
        parcel1.recycle();
        parcel.recycle();
        return configuration;
    }

    public IActivityManager.ContentProviderHolder getContentProvider(IApplicationThread iapplicationthread, String s, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder;
        int i;
        int j;
        IActivityManager.ContentProviderHolder contentproviderholder;
        if(iapplicationthread != null)
            ibinder = iapplicationthread.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(29, parcel, parcel1, 0);
        parcel1.readException();
        j = parcel1.readInt();
        contentproviderholder = null;
        if(j != 0)
            contentproviderholder = (IActivityManager.ContentProviderHolder)IActivityManager.ContentProviderHolder.CREATOR.createFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return contentproviderholder;
    }

    public IActivityManager.ContentProviderHolder getContentProviderExternal(String s, IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(141, parcel, parcel1, 0);
        parcel1.readException();
        int i = parcel1.readInt();
        IActivityManager.ContentProviderHolder contentproviderholder = null;
        if(i != 0)
            contentproviderholder = (IActivityManager.ContentProviderHolder)IActivityManager.ContentProviderHolder.CREATOR.createFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return contentproviderholder;
    }

    public UserInfo getCurrentUser() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(130, parcel, parcel1, 0);
        parcel1.readException();
        UserInfo userinfo = (UserInfo)UserInfo.CREATOR.createFromParcel(parcel1);
        parcel1.recycle();
        parcel.recycle();
        return userinfo;
    }

    public ConfigurationInfo getDeviceConfigurationInfo() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(84, parcel, parcel1, 0);
        parcel1.readException();
        ConfigurationInfo configurationinfo = (ConfigurationInfo)ConfigurationInfo.CREATOR.createFromParcel(parcel1);
        parcel1.recycle();
        parcel.recycle();
        return configurationinfo;
    }

    public int getFrontActivityScreenCompatMode() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(124, parcel, parcel1, 0);
        parcel1.readException();
        int i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
    }

    public IIntentSender getIntentSender(int i, String s, IBinder ibinder, String s1, int j, Intent aintent[], String as[], 
            int k, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        parcel.writeString(s);
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(j);
        IIntentSender iintentsender;
        if(aintent != null) {
            parcel.writeInt(1);
            parcel.writeTypedArray(aintent, 0);
            parcel.writeStringArray(as);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(k);
        if(bundle != null) {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(63, parcel, parcel1, 0);
        parcel1.readException();
        iintentsender = android.content.IIntentSender.Stub.asInterface(parcel1.readStrongBinder());
        parcel.recycle();
        parcel1.recycle();
        return iintentsender;
    }

    public int getLaunchedFromUid(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(150, parcel, parcel1, 0);
        parcel1.readException();
        int i = parcel1.readInt();
        parcel.recycle();
        parcel1.recycle();
        return i;
    }

    public void getMemoryInfo(ActivityManager.MemoryInfo memoryinfo) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(76, parcel, parcel1, 0);
        parcel1.readException();
        memoryinfo.readFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
    }

    public void getMyMemoryState(ActivityManager.RunningAppProcessInfo runningappprocessinfo) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(143, parcel, parcel1, 0);
        parcel1.readException();
        runningappprocessinfo.readFromParcel(parcel1);
        parcel1.recycle();
        parcel.recycle();
    }

    public boolean getPackageAskScreenCompat(String s) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        mRemote.transact(128, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel1.recycle();
        parcel.recycle();
        return flag;
    }

    public String getPackageForIntentSender(IIntentSender iintentsender) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(iintentsender.asBinder());
        mRemote.transact(65, parcel, parcel1, 0);
        parcel1.readException();
        String s = parcel1.readString();
        parcel.recycle();
        parcel1.recycle();
        return s;
    }

    public String getPackageForToken(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(50, parcel, parcel1, 0);
        parcel1.readException();
        String s = parcel1.readString();
        parcel.recycle();
        parcel1.recycle();
        return s;
    }

    public int getPackageScreenCompatMode(String s) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        mRemote.transact(126, parcel, parcel1, 0);
        parcel1.readException();
        int i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
    }

    public int getProcessLimit() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(52, parcel, parcel1, 0);
        parcel1.readException();
        int i = parcel1.readInt();
        parcel.recycle();
        parcel1.recycle();
        return i;
    }

    public android.os.Debug.MemoryInfo[] getProcessMemoryInfo(int ai[]) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeIntArray(ai);
        mRemote.transact(98, parcel, parcel1, 0);
        parcel1.readException();
        android.os.Debug.MemoryInfo amemoryinfo[] = (android.os.Debug.MemoryInfo[])parcel1.createTypedArray(android.os.Debug.MemoryInfo.CREATOR);
        parcel.recycle();
        parcel1.recycle();
        return amemoryinfo;
    }

    public long[] getProcessPss(int ai[]) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeIntArray(ai);
        mRemote.transact(137, parcel, parcel1, 0);
        parcel1.readException();
        long al[] = parcel1.createLongArray();
        parcel.recycle();
        parcel1.recycle();
        return al;
    }

    public List getProcessesInErrorState() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(77, parcel, parcel1, 0);
        parcel1.readException();
        ArrayList arraylist = parcel1.createTypedArrayList(ActivityManager.ProcessErrorStateInfo.CREATOR);
        parcel.recycle();
        parcel1.recycle();
        return arraylist;
    }

    public String getProviderMimeType(Uri uri) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        uri.writeToParcel(parcel, 0);
        mRemote.transact(115, parcel, parcel1, 0);
        parcel1.readException();
        String s = parcel1.readString();
        parcel.recycle();
        parcel1.recycle();
        return s;
    }

    public List getRecentTasks(int i, int j) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(60, parcel, parcel1, 0);
        parcel1.readException();
        ArrayList arraylist = parcel1.createTypedArrayList(ActivityManager.RecentTaskInfo.CREATOR);
        parcel.recycle();
        parcel1.recycle();
        return arraylist;
    }

    public int getRequestedOrientation(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(71, parcel, parcel1, 0);
        parcel1.readException();
        int i = parcel1.readInt();
        parcel.recycle();
        parcel1.recycle();
        return i;
    }

    public List getRunningAppProcesses() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(83, parcel, parcel1, 0);
        parcel1.readException();
        ArrayList arraylist = parcel1.createTypedArrayList(ActivityManager.RunningAppProcessInfo.CREATOR);
        parcel.recycle();
        parcel1.recycle();
        return arraylist;
    }

    public List getRunningExternalApplications() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(108, parcel, parcel1, 0);
        parcel1.readException();
        ArrayList arraylist = parcel1.createTypedArrayList(ApplicationInfo.CREATOR);
        parcel.recycle();
        parcel1.recycle();
        return arraylist;
    }

    public PendingIntent getRunningServiceControlPanel(ComponentName componentname) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        componentname.writeToParcel(parcel, 0);
        mRemote.transact(33, parcel, parcel1, 0);
        parcel1.readException();
        PendingIntent pendingintent = PendingIntent.readPendingIntentOrNullFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return pendingintent;
    }

    public List getServices(int i, int j) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(81, parcel, parcel1, 0);
        parcel1.readException();
        ArrayList arraylist = null;
        int k = parcel1.readInt();
        if(k >= 0) {
            arraylist = new ArrayList();
            for(; k > 0; k--)
                arraylist.add((ActivityManager.RunningServiceInfo)ActivityManager.RunningServiceInfo.CREATOR.createFromParcel(parcel1));

        }
        parcel.recycle();
        parcel1.recycle();
        return arraylist;
    }

    public int getTaskForActivity(IBinder ibinder, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        int i;
        int j;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(27, parcel, parcel1, 0);
        parcel1.readException();
        j = parcel1.readInt();
        parcel.recycle();
        parcel1.recycle();
        return j;
    }

    public ActivityManager.TaskThumbnails getTaskThumbnails(int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        mRemote.transact(82, parcel, parcel1, 0);
        parcel1.readException();
        ActivityManager.TaskThumbnails taskthumbnails = null;
        if(parcel1.readInt() != 0)
            taskthumbnails = (ActivityManager.TaskThumbnails)ActivityManager.TaskThumbnails.CREATOR.createFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return taskthumbnails;
    }

    public List getTasks(int i, int j, IThumbnailReceiver ithumbnailreceiver) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        parcel.writeInt(j);
        IBinder ibinder;
        ArrayList arraylist;
        int k;
        if(ithumbnailreceiver != null)
            ibinder = ithumbnailreceiver.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(23, parcel, parcel1, 0);
        parcel1.readException();
        arraylist = null;
        k = parcel1.readInt();
        if(k >= 0) {
            arraylist = new ArrayList();
            for(; k > 0; k--)
                arraylist.add((ActivityManager.RunningTaskInfo)ActivityManager.RunningTaskInfo.CREATOR.createFromParcel(parcel1));

        }
        parcel.recycle();
        parcel1.recycle();
        return arraylist;
    }

    public int getUidForIntentSender(IIntentSender iintentsender) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(iintentsender.asBinder());
        mRemote.transact(93, parcel, parcel1, 0);
        parcel1.readException();
        int i = parcel1.readInt();
        parcel.recycle();
        parcel1.recycle();
        return i;
    }

    public void goingToSleep() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(40, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void grantUriPermission(IApplicationThread iapplicationthread, String s, Uri uri, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(iapplicationthread.asBinder());
        parcel.writeString(s);
        uri.writeToParcel(parcel, 0);
        parcel.writeInt(i);
        mRemote.transact(55, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void grantUriPermissionFromOwner(IBinder ibinder, int i, String s, Uri uri, int j) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        parcel.writeString(s);
        uri.writeToParcel(parcel, 0);
        parcel.writeInt(j);
        mRemote.transact(55, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void handleApplicationCrash(IBinder ibinder, ApplicationErrorReport.CrashInfo crashinfo) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        crashinfo.writeToParcel(parcel, 0);
        mRemote.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
    }

    public void handleApplicationStrictModeViolation(IBinder ibinder, int i, android.os.StrictMode.ViolationInfo violationinfo) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        violationinfo.writeToParcel(parcel, 0);
        mRemote.transact(110, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
    }

    public boolean handleApplicationWtf(IBinder ibinder, String s, ApplicationErrorReport.CrashInfo crashinfo) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        crashinfo.writeToParcel(parcel, 0);
        mRemote.transact(102, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel1.recycle();
        parcel.recycle();
        return flag;
    }

    public boolean isImmersive(IBinder ibinder) throws RemoteException {
        boolean flag = true;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(111, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != flag)
            flag = false;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public boolean isIntentSenderAnActivity(IIntentSender iintentsender) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(iintentsender.asBinder());
        mRemote.transact(152, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public boolean isIntentSenderTargetedToPackage(IIntentSender iintentsender) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(iintentsender.asBinder());
        mRemote.transact(135, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public boolean isTopActivityImmersive() throws RemoteException {
        boolean flag = true;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(113, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != flag)
            flag = false;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public boolean isUserAMonkey() throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(104, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public void killAllBackgroundProcesses() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(140, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void killApplicationProcess(String s, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        parcel.writeInt(i);
        mRemote.transact(99, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void killApplicationWithUid(String s, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        parcel.writeInt(i);
        mRemote.transact(96, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void killBackgroundProcesses(String s) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        mRemote.transact(103, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public boolean killPids(int ai[], String s, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeIntArray(ai);
        parcel.writeString(s);
        int i;
        boolean flag1;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(80, parcel, parcel1, 0);
        if(parcel1.readInt() != 0)
            flag1 = true;
        else
            flag1 = false;
        parcel.recycle();
        parcel1.recycle();
        return flag1;
    }

    public boolean killProcessesBelowForeground(String s) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        mRemote.transact(144, parcel, parcel1, 0);
        if(parcel1.readInt() != 0)
            flag = true;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public boolean moveActivityTaskToBack(IBinder ibinder, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        int i;
        boolean flag1;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(75, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag1 = true;
        else
            flag1 = false;
        parcel.recycle();
        parcel1.recycle();
        return flag1;
    }

    public void moveTaskBackwards(int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        mRemote.transact(26, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void moveTaskToBack(int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        mRemote.transact(25, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void moveTaskToFront(int i, int j, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        parcel.writeInt(j);
        if(bundle != null) {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(24, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public boolean navigateUpTo(IBinder ibinder, Intent intent, int i, Intent intent1) throws RemoteException {
        boolean flag = true;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        intent.writeToParcel(parcel, 0);
        parcel.writeInt(i);
        if(intent1 != null) {
            parcel.writeInt(flag);
            intent1.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(147, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() == 0)
            flag = false;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public IBinder newUriPermissionOwner(String s) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        mRemote.transact(116, parcel, parcel1, 0);
        parcel1.readException();
        IBinder ibinder = parcel1.readStrongBinder();
        parcel.recycle();
        parcel1.recycle();
        return ibinder;
    }

    public void noteWakeupAlarm(IIntentSender iintentsender) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeStrongBinder(iintentsender.asBinder());
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(68, parcel, null, 0);
        parcel.recycle();
    }

    public ParcelFileDescriptor openContentUri(Uri uri) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        ParcelFileDescriptor parcelfiledescriptor = null;
        if(parcel1.readInt() != 0)
            parcelfiledescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return parcelfiledescriptor;
    }

    public void overridePendingTransition(IBinder ibinder, String s, int i, int j) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(101, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public IBinder peekService(Intent intent, String s) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        intent.writeToParcel(parcel, 0);
        parcel.writeString(s);
        mRemote.transact(85, parcel, parcel1, 0);
        parcel1.readException();
        IBinder ibinder = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return ibinder;
    }

    public boolean profileControl(String s, boolean flag, String s1, ParcelFileDescriptor parcelfiledescriptor, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        int j;
        boolean flag1;
        if(flag)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        parcel.writeInt(i);
        parcel.writeString(s1);
        if(parcelfiledescriptor != null) {
            parcel.writeInt(1);
            parcelfiledescriptor.writeToParcel(parcel, 1);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(86, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag1 = true;
        else
            flag1 = false;
        parcel1.recycle();
        parcel.recycle();
        return flag1;
    }

    public void publishContentProviders(IApplicationThread iapplicationthread, List list) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder;
        if(iapplicationthread != null)
            ibinder = iapplicationthread.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
        parcel.writeTypedList(list);
        mRemote.transact(30, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void publishService(IBinder ibinder, Intent intent, IBinder ibinder1) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        intent.writeToParcel(parcel, 0);
        parcel.writeStrongBinder(ibinder1);
        mRemote.transact(38, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public boolean refContentProvider(IBinder ibinder, int i, int j) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(31, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public void registerProcessObserver(IProcessObserver iprocessobserver) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder;
        if(iprocessobserver != null)
            ibinder = iprocessobserver.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(133, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public Intent registerReceiver(IApplicationThread iapplicationthread, String s, IIntentReceiver iintentreceiver, IntentFilter intentfilter, String s1) throws RemoteException {
        IBinder ibinder = null;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder1;
        Intent intent;
        if(iapplicationthread != null)
            ibinder1 = iapplicationthread.asBinder();
        else
            ibinder1 = null;
        parcel.writeStrongBinder(ibinder1);
        parcel.writeString(s);
        if(iintentreceiver != null)
            ibinder = iintentreceiver.asBinder();
        parcel.writeStrongBinder(ibinder);
        intentfilter.writeToParcel(parcel, 0);
        parcel.writeString(s1);
        mRemote.transact(12, parcel, parcel1, 0);
        parcel1.readException();
        intent = null;
        if(parcel1.readInt() != 0)
            intent = (Intent)Intent.CREATOR.createFromParcel(parcel1);
        parcel1.recycle();
        parcel.recycle();
        return intent;
    }

    public void removeContentProvider(IBinder ibinder, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(69, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void removeContentProviderExternal(String s, IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(142, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public boolean removeSubTask(int i, int j) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(131, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel1.recycle();
        parcel.recycle();
        return flag;
    }

    public boolean removeTask(int i, int j) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(132, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel1.recycle();
        parcel.recycle();
        return flag;
    }

    public void reportThumbnail(IBinder ibinder, Bitmap bitmap, CharSequence charsequence) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        if(bitmap != null) {
            parcel.writeInt(1);
            bitmap.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        TextUtils.writeToParcel(charsequence, parcel, 0);
        mRemote.transact(28, parcel, parcel1, 1);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void resumeAppSwitches() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(89, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
    }

    public void revokeUriPermission(IApplicationThread iapplicationthread, Uri uri, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(iapplicationthread.asBinder());
        uri.writeToParcel(parcel, 0);
        parcel.writeInt(i);
        mRemote.transact(56, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void revokeUriPermissionFromOwner(IBinder ibinder, Uri uri, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        if(uri != null) {
            parcel.writeInt(1);
            uri.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(i);
        mRemote.transact(56, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void serviceDoneExecuting(IBinder ibinder, int i, int j, int k) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeInt(k);
        mRemote.transact(61, parcel, parcel1, 1);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void setActivityController(IActivityController iactivitycontroller) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder;
        if(iactivitycontroller != null)
            ibinder = iactivitycontroller.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(57, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void setAlwaysFinish(boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(43, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void setDebugApp(String s, boolean flag, boolean flag1) throws RemoteException {
        int i = 1;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        int j;
        if(flag)
            j = i;
        else
            j = 0;
        parcel.writeInt(j);
        if(!flag1)
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(42, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void setFrontActivityScreenCompatMode(int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        mRemote.transact(125, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
    }

    public void setImmersive(IBinder ibinder, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(112, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void setLockScreenShown(boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(148, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void setPackageAskScreenCompat(String s, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(129, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
    }

    public void setPackageScreenCompatMode(String s, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        parcel.writeInt(i);
        mRemote.transact(127, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
    }

    public void setProcessForeground(IBinder ibinder, int i, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        int j;
        if(flag)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        mRemote.transact(73, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void setProcessLimit(int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        mRemote.transact(51, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void setRequestedOrientation(IBinder ibinder, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        mRemote.transact(70, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void setServiceForeground(ComponentName componentname, IBinder ibinder, int i, Notification notification, boolean flag) throws RemoteException {
        int j = 1;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        ComponentName.writeToParcel(componentname, parcel);
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        if(notification != null) {
            parcel.writeInt(j);
            notification.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        if(!flag)
            j = 0;
        parcel.writeInt(j);
        mRemote.transact(74, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void showBootMessage(CharSequence charsequence, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        TextUtils.writeToParcel(charsequence, parcel, 0);
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(138, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void showWaitingForDebugger(IApplicationThread iapplicationthread, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(iapplicationthread.asBinder());
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(58, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public boolean shutdown(int i) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        mRemote.transact(87, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel1.recycle();
        parcel.recycle();
        return flag;
    }

    public void signalPersistentProcesses(int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        mRemote.transact(59, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public int startActivities(IApplicationThread iapplicationthread, Intent aintent[], String as[], IBinder ibinder, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder1;
        int i;
        if(iapplicationthread != null)
            ibinder1 = iapplicationthread.asBinder();
        else
            ibinder1 = null;
        parcel.writeStrongBinder(ibinder1);
        parcel.writeTypedArray(aintent, 0);
        parcel.writeStringArray(as);
        parcel.writeStrongBinder(ibinder);
        if(bundle != null) {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(121, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
    }

    public int startActivitiesInPackage(int i, Intent aintent[], String as[], IBinder ibinder, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        parcel.writeTypedArray(aintent, 0);
        parcel.writeStringArray(as);
        parcel.writeStrongBinder(ibinder);
        int j;
        if(bundle != null) {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(122, parcel, parcel1, 0);
        parcel1.readException();
        j = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return j;
    }

    public int startActivity(IApplicationThread iapplicationthread, Intent intent, String s, IBinder ibinder, String s1, int i, int j, 
            String s2, ParcelFileDescriptor parcelfiledescriptor, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder1;
        int k;
        if(iapplicationthread != null)
            ibinder1 = iapplicationthread.asBinder();
        else
            ibinder1 = null;
        parcel.writeStrongBinder(ibinder1);
        intent.writeToParcel(parcel, 0);
        parcel.writeString(s);
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(s2);
        if(parcelfiledescriptor != null) {
            parcel.writeInt(1);
            parcelfiledescriptor.writeToParcel(parcel, 1);
        } else {
            parcel.writeInt(0);
        }
        if(bundle != null) {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        k = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return k;
    }

    public IActivityManager.WaitResult startActivityAndWait(IApplicationThread iapplicationthread, Intent intent, String s, IBinder ibinder, String s1, int i, int j, 
            String s2, ParcelFileDescriptor parcelfiledescriptor, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder1;
        IActivityManager.WaitResult waitresult;
        if(iapplicationthread != null)
            ibinder1 = iapplicationthread.asBinder();
        else
            ibinder1 = null;
        parcel.writeStrongBinder(ibinder1);
        intent.writeToParcel(parcel, 0);
        parcel.writeString(s);
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(s2);
        if(parcelfiledescriptor != null) {
            parcel.writeInt(1);
            parcelfiledescriptor.writeToParcel(parcel, 1);
        } else {
            parcel.writeInt(0);
        }
        if(bundle != null) {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(105, parcel, parcel1, 0);
        parcel1.readException();
        waitresult = (IActivityManager.WaitResult)IActivityManager.WaitResult.CREATOR.createFromParcel(parcel1);
        parcel1.recycle();
        parcel.recycle();
        return waitresult;
    }

    public int startActivityInPackage(int i, Intent intent, String s, IBinder ibinder, String s1, int j, int k, 
            Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        intent.writeToParcel(parcel, 0);
        parcel.writeString(s);
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(j);
        parcel.writeInt(k);
        int l;
        if(bundle != null) {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(95, parcel, parcel1, 0);
        parcel1.readException();
        l = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return l;
    }

    public int startActivityIntentSender(IApplicationThread iapplicationthread, IntentSender intentsender, Intent intent, String s, IBinder ibinder, String s1, int i, 
            int j, int k, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder1;
        int l;
        if(iapplicationthread != null)
            ibinder1 = iapplicationthread.asBinder();
        else
            ibinder1 = null;
        parcel.writeStrongBinder(ibinder1);
        intentsender.writeToParcel(parcel, 0);
        if(intent != null) {
            parcel.writeInt(1);
            intent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(s);
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeInt(k);
        if(bundle != null) {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(100, parcel, parcel1, 0);
        parcel1.readException();
        l = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return l;
    }

    public int startActivityWithConfig(IApplicationThread iapplicationthread, Intent intent, String s, IBinder ibinder, String s1, int i, int j, 
            Configuration configuration, Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder1;
        int k;
        if(iapplicationthread != null)
            ibinder1 = iapplicationthread.asBinder();
        else
            ibinder1 = null;
        parcel.writeStrongBinder(ibinder1);
        intent.writeToParcel(parcel, 0);
        parcel.writeString(s);
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        configuration.writeToParcel(parcel, 0);
        if(bundle != null) {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        k = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return k;
    }

    public boolean startInstrumentation(ComponentName componentname, String s, int i, Bundle bundle, IInstrumentationWatcher iinstrumentationwatcher) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        ComponentName.writeToParcel(componentname, parcel);
        parcel.writeString(s);
        parcel.writeInt(i);
        parcel.writeBundle(bundle);
        IBinder ibinder;
        if(iinstrumentationwatcher != null)
            ibinder = iinstrumentationwatcher.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(44, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel1.recycle();
        parcel.recycle();
        return flag;
    }

    public boolean startNextMatchingActivity(IBinder ibinder, Intent intent, Bundle bundle) throws RemoteException {
        boolean flag = true;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        intent.writeToParcel(parcel, 0);
        int i;
        if(bundle != null) {
            parcel.writeInt(flag);
            bundle.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(67, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        if(i == 0)
            flag = false;
        return flag;
    }

    public void startRunning(String s, String s1, String s2, String s3) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeString(s2);
        parcel.writeString(s3);
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public ComponentName startService(IApplicationThread iapplicationthread, Intent intent, String s) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder;
        ComponentName componentname;
        if(iapplicationthread != null)
            ibinder = iapplicationthread.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
        intent.writeToParcel(parcel, 0);
        parcel.writeString(s);
        mRemote.transact(34, parcel, parcel1, 0);
        parcel1.readException();
        componentname = ComponentName.readFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return componentname;
    }

    public void stopAppSwitches() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(88, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
    }

    public int stopService(IApplicationThread iapplicationthread, Intent intent, String s) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder;
        int i;
        if(iapplicationthread != null)
            ibinder = iapplicationthread.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
        intent.writeToParcel(parcel, 0);
        parcel.writeString(s);
        mRemote.transact(35, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
    }

    public boolean stopServiceToken(ComponentName componentname, IBinder ibinder, int i) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        ComponentName.writeToParcel(componentname, parcel);
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        mRemote.transact(48, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public boolean switchUser(int i) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeInt(i);
        mRemote.transact(130, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel1.recycle();
        parcel.recycle();
        return flag;
    }

    public boolean targetTaskAffinityMatchesActivity(IBinder ibinder, String s) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        mRemote.transact(146, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public boolean testIsSystemReady() {
        return true;
    }

    public void unbindBackupAgent(ApplicationInfo applicationinfo) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        applicationinfo.writeToParcel(parcel, 0);
        mRemote.transact(92, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
    }

    public void unbindFinished(IBinder ibinder, Intent intent, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        intent.writeToParcel(parcel, 0);
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(72, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public boolean unbindService(IServiceConnection iserviceconnection) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(iserviceconnection.asBinder());
        mRemote.transact(37, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    public void unbroadcastIntent(IApplicationThread iapplicationthread, Intent intent, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder;
        if(iapplicationthread != null)
            ibinder = iapplicationthread.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
        intent.writeToParcel(parcel, 0);
        parcel.writeInt(i);
        mRemote.transact(15, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void unhandledBack() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void unregisterProcessObserver(IProcessObserver iprocessobserver) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        IBinder ibinder;
        if(iprocessobserver != null)
            ibinder = iprocessobserver.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(134, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void unregisterReceiver(IIntentReceiver iintentreceiver) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(iintentreceiver.asBinder());
        mRemote.transact(13, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void unstableProviderDied(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(151, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void updateConfiguration(Configuration configuration) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        configuration.writeToParcel(parcel, 0);
        mRemote.transact(47, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void updatePersistentConfiguration(Configuration configuration) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        configuration.writeToParcel(parcel, 0);
        mRemote.transact(136, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public void wakingUp() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        mRemote.transact(41, parcel, parcel1, 0);
        parcel1.readException();
        parcel.recycle();
        parcel1.recycle();
    }

    public boolean willActivityBeVisible(IBinder ibinder) throws RemoteException {
        boolean flag = false;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IActivityManager");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(106, parcel, parcel1, 0);
        parcel1.readException();
        if(parcel1.readInt() != 0)
            flag = true;
        parcel.recycle();
        parcel1.recycle();
        return flag;
    }

    private IBinder mRemote;
}
