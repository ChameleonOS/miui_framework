// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.content.pm.*;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.os.*;
import java.io.FileDescriptor;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.app:
//            IApplicationThread, IInstrumentationWatcher

class ApplicationThreadProxy
    implements IApplicationThread {

    public ApplicationThreadProxy(IBinder ibinder) {
        mRemote = ibinder;
    }

    public final IBinder asBinder() {
        return mRemote;
    }

    public final void bindApplication(String s, ApplicationInfo applicationinfo, List list, ComponentName componentname, String s1, ParcelFileDescriptor parcelfiledescriptor, boolean flag, 
            Bundle bundle, IInstrumentationWatcher iinstrumentationwatcher, int i, boolean flag1, boolean flag2, boolean flag3, Configuration configuration, 
            CompatibilityInfo compatibilityinfo, Map map, Bundle bundle1) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeString(s);
        applicationinfo.writeToParcel(parcel, 0);
        parcel.writeTypedList(list);
        int j;
        int k;
        int l;
        int i1;
        if(componentname == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            componentname.writeToParcel(parcel, 0);
        }
        parcel.writeString(s1);
        if(parcelfiledescriptor != null) {
            parcel.writeInt(1);
            parcelfiledescriptor.writeToParcel(parcel, 1);
        } else {
            parcel.writeInt(0);
        }
        if(flag)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        parcel.writeBundle(bundle);
        parcel.writeStrongInterface(iinstrumentationwatcher);
        parcel.writeInt(i);
        if(flag1)
            k = 1;
        else
            k = 0;
        parcel.writeInt(k);
        if(flag2)
            l = 1;
        else
            l = 0;
        parcel.writeInt(l);
        if(flag3)
            i1 = 1;
        else
            i1 = 0;
        parcel.writeInt(i1);
        configuration.writeToParcel(parcel, 0);
        compatibilityinfo.writeToParcel(parcel, 0);
        parcel.writeMap(map);
        parcel.writeBundle(bundle1);
        mRemote.transact(13, parcel, null, 1);
        parcel.recycle();
    }

    public void clearDnsCache() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        mRemote.transact(38, parcel, null, 1);
        parcel.recycle();
    }

    public void dispatchPackageBroadcast(int i, String as[]) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeInt(i);
        parcel.writeStringArray(as);
        mRemote.transact(34, parcel, null, 1);
        parcel.recycle();
    }

    public void dumpActivity(FileDescriptor filedescriptor, IBinder ibinder, String s, String as[]) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeFileDescriptor(filedescriptor);
        parcel.writeStrongBinder(ibinder);
        parcel.writeString(s);
        parcel.writeStringArray(as);
        mRemote.transact(37, parcel, null, 1);
        parcel.recycle();
    }

    public void dumpDbInfo(FileDescriptor filedescriptor, String as[]) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeFileDescriptor(filedescriptor);
        parcel.writeStringArray(as);
        mRemote.transact(46, parcel, null, 1);
        parcel.recycle();
    }

    public void dumpGfxInfo(FileDescriptor filedescriptor, String as[]) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeFileDescriptor(filedescriptor);
        parcel.writeStringArray(as);
        mRemote.transact(44, parcel, null, 1);
        parcel.recycle();
    }

    public void dumpHeap(boolean flag, String s, ParcelFileDescriptor parcelfiledescriptor) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        parcel.writeString(s);
        if(parcelfiledescriptor != null) {
            parcel.writeInt(1);
            parcelfiledescriptor.writeToParcel(parcel, 1);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(36, parcel, null, 1);
        parcel.recycle();
    }

    public android.os.Debug.MemoryInfo dumpMemInfo(FileDescriptor filedescriptor, boolean flag, boolean flag1, String as[]) throws RemoteException {
        int i = 1;
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeFileDescriptor(filedescriptor);
        int j;
        android.os.Debug.MemoryInfo memoryinfo;
        if(flag)
            j = i;
        else
            j = 0;
        parcel.writeInt(j);
        if(!flag1)
            i = 0;
        parcel.writeInt(i);
        parcel.writeStringArray(as);
        mRemote.transact(43, parcel, parcel1, 0);
        parcel1.readException();
        memoryinfo = new android.os.Debug.MemoryInfo();
        memoryinfo.readFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
        return memoryinfo;
    }

    public void dumpProvider(FileDescriptor filedescriptor, IBinder ibinder, String as[]) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeFileDescriptor(filedescriptor);
        parcel.writeStrongBinder(ibinder);
        parcel.writeStringArray(as);
        mRemote.transact(45, parcel, null, 1);
        parcel.recycle();
    }

    public void dumpService(FileDescriptor filedescriptor, IBinder ibinder, String as[]) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeFileDescriptor(filedescriptor);
        parcel.writeStrongBinder(ibinder);
        parcel.writeStringArray(as);
        mRemote.transact(22, parcel, null, 1);
        parcel.recycle();
    }

    public void getMemoryInfo(android.os.Debug.MemoryInfo memoryinfo) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        mRemote.transact(32, parcel, parcel1, 0);
        parcel1.readException();
        memoryinfo.readFromParcel(parcel1);
        parcel.recycle();
        parcel1.recycle();
    }

    public void processInBackground() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        mRemote.transact(19, parcel, null, 1);
        parcel.recycle();
    }

    public void profilerControl(boolean flag, String s, ParcelFileDescriptor parcelfiledescriptor, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        int j;
        if(flag)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        parcel.writeInt(i);
        parcel.writeString(s);
        if(parcelfiledescriptor != null) {
            parcel.writeInt(1);
            parcelfiledescriptor.writeToParcel(parcel, 1);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(28, parcel, null, 1);
        parcel.recycle();
    }

    public final void requestThumbnail(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(15, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleActivityConfigurationChanged(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(25, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleBindService(IBinder ibinder, Intent intent, boolean flag) throws RemoteException {
        int i = 0;
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        intent.writeToParcel(parcel, 0);
        if(flag)
            i = 1;
        parcel.writeInt(i);
        mRemote.transact(20, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleConfigurationChanged(Configuration configuration) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        configuration.writeToParcel(parcel, 0);
        mRemote.transact(16, parcel, null, 1);
        parcel.recycle();
    }

    public void scheduleCrash(String s) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeString(s);
        mRemote.transact(35, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleCreateBackupAgent(ApplicationInfo applicationinfo, CompatibilityInfo compatibilityinfo, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        applicationinfo.writeToParcel(parcel, 0);
        compatibilityinfo.writeToParcel(parcel, 0);
        parcel.writeInt(i);
        mRemote.transact(30, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleCreateService(IBinder ibinder, ServiceInfo serviceinfo, CompatibilityInfo compatibilityinfo) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        serviceinfo.writeToParcel(parcel, 0);
        compatibilityinfo.writeToParcel(parcel, 0);
        mRemote.transact(11, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleDestroyActivity(IBinder ibinder, boolean flag, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        int j;
        if(flag)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        parcel.writeInt(i);
        mRemote.transact(9, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleDestroyBackupAgent(ApplicationInfo applicationinfo, CompatibilityInfo compatibilityinfo) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        applicationinfo.writeToParcel(parcel, 0);
        compatibilityinfo.writeToParcel(parcel, 0);
        mRemote.transact(31, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleExit() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        mRemote.transact(14, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleLaunchActivity(Intent intent, IBinder ibinder, int i, ActivityInfo activityinfo, Configuration configuration, CompatibilityInfo compatibilityinfo, Bundle bundle, 
            List list, List list1, boolean flag, boolean flag1, String s, ParcelFileDescriptor parcelfiledescriptor, boolean flag2) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        intent.writeToParcel(parcel, 0);
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        activityinfo.writeToParcel(parcel, 0);
        configuration.writeToParcel(parcel, 0);
        compatibilityinfo.writeToParcel(parcel, 0);
        parcel.writeBundle(bundle);
        parcel.writeTypedList(list);
        parcel.writeTypedList(list1);
        int j;
        int k;
        int l;
        if(flag)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        if(flag1)
            k = 1;
        else
            k = 0;
        parcel.writeInt(k);
        parcel.writeString(s);
        if(parcelfiledescriptor != null) {
            parcel.writeInt(1);
            parcelfiledescriptor.writeToParcel(parcel, 1);
        } else {
            parcel.writeInt(0);
        }
        if(flag2)
            l = 1;
        else
            l = 0;
        parcel.writeInt(l);
        mRemote.transact(7, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleLowMemory() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        mRemote.transact(24, parcel, null, 1);
        parcel.recycle();
    }

    public void scheduleNewIntent(List list, IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeTypedList(list);
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(8, parcel, null, 1);
        parcel.recycle();
    }

    public final void schedulePauseActivity(IBinder ibinder, boolean flag, boolean flag1, int i) throws RemoteException {
        int j = 0;
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        int k;
        if(flag)
            k = 1;
        else
            k = 0;
        parcel.writeInt(k);
        if(flag1)
            j = 1;
        parcel.writeInt(j);
        parcel.writeInt(i);
        mRemote.transact(1, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleReceiver(Intent intent, ActivityInfo activityinfo, CompatibilityInfo compatibilityinfo, int i, String s, Bundle bundle, boolean flag) throws RemoteException {
        int j = 0;
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        intent.writeToParcel(parcel, 0);
        activityinfo.writeToParcel(parcel, 0);
        compatibilityinfo.writeToParcel(parcel, 0);
        parcel.writeInt(i);
        parcel.writeString(s);
        parcel.writeBundle(bundle);
        if(flag)
            j = 1;
        parcel.writeInt(j);
        mRemote.transact(10, parcel, null, 1);
        parcel.recycle();
    }

    public void scheduleRegisteredReceiver(IIntentReceiver iintentreceiver, Intent intent, int i, String s, Bundle bundle, boolean flag, boolean flag1) throws RemoteException {
        int j = 0;
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(iintentreceiver.asBinder());
        intent.writeToParcel(parcel, 0);
        parcel.writeInt(i);
        parcel.writeString(s);
        parcel.writeBundle(bundle);
        int k;
        if(flag)
            k = 1;
        else
            k = 0;
        parcel.writeInt(k);
        if(flag1)
            j = 1;
        parcel.writeInt(j);
        mRemote.transact(23, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleRelaunchActivity(IBinder ibinder, List list, List list1, int i, boolean flag, Configuration configuration) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        parcel.writeTypedList(list);
        parcel.writeTypedList(list1);
        parcel.writeInt(i);
        int j;
        if(flag)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        if(configuration != null) {
            parcel.writeInt(1);
            configuration.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(26, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleResumeActivity(IBinder ibinder, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(5, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleSendResult(IBinder ibinder, List list) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        parcel.writeTypedList(list);
        mRemote.transact(6, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleServiceArgs(IBinder ibinder, boolean flag, int i, int j, Intent intent) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        int k;
        if(flag)
            k = 1;
        else
            k = 0;
        parcel.writeInt(k);
        parcel.writeInt(i);
        parcel.writeInt(j);
        if(intent != null) {
            parcel.writeInt(1);
            intent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        mRemote.transact(17, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleSleeping(IBinder ibinder, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(27, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleStopActivity(IBinder ibinder, boolean flag, int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        int j;
        if(flag)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        parcel.writeInt(i);
        mRemote.transact(3, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleStopService(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(12, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleSuicide() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        mRemote.transact(33, parcel, null, 1);
        parcel.recycle();
    }

    public void scheduleTrimMemory(int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeInt(i);
        mRemote.transact(42, parcel, null, 1);
    }

    public final void scheduleUnbindService(IBinder ibinder, Intent intent) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        intent.writeToParcel(parcel, 0);
        mRemote.transact(21, parcel, null, 1);
        parcel.recycle();
    }

    public final void scheduleWindowVisibility(IBinder ibinder, boolean flag) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        parcel.writeInt(i);
        mRemote.transact(4, parcel, null, 1);
        parcel.recycle();
    }

    public void setCoreSettings(Bundle bundle) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeBundle(bundle);
        mRemote.transact(40, parcel, null, 1);
    }

    public void setHttpProxy(String s, String s1, String s2) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeString(s);
        parcel.writeString(s1);
        parcel.writeString(s2);
        mRemote.transact(39, parcel, null, 1);
        parcel.recycle();
    }

    public void setSchedulingGroup(int i) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeInt(i);
        mRemote.transact(29, parcel, null, 1);
        parcel.recycle();
    }

    public void unstableProviderDied(IBinder ibinder) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeStrongBinder(ibinder);
        mRemote.transact(47, parcel, null, 1);
        parcel.recycle();
    }

    public void updatePackageCompatibilityInfo(String s, CompatibilityInfo compatibilityinfo) throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        parcel.writeString(s);
        compatibilityinfo.writeToParcel(parcel, 0);
        mRemote.transact(41, parcel, null, 1);
    }

    public void updateTimeZone() throws RemoteException {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("android.app.IApplicationThread");
        mRemote.transact(18, parcel, null, 1);
        parcel.recycle();
    }

    private final IBinder mRemote;
}
