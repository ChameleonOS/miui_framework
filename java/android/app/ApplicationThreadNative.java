// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.*;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.os.*;
import java.io.IOException;

// Referenced classes of package android.app:
//            IApplicationThread, ApplicationThreadProxy, ResultInfo

public abstract class ApplicationThreadNative extends Binder
    implements IApplicationThread {

    public ApplicationThreadNative() {
        attachInterface(this, "android.app.IApplicationThread");
    }

    public static IApplicationThread asInterface(IBinder ibinder) {
        if(ibinder != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((IApplicationThread) (obj));
_L2:
        obj = (IApplicationThread)ibinder.queryLocalInterface("android.app.IApplicationThread");
        if(obj == null)
            obj = new ApplicationThreadProxy(ibinder);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
        i;
        JVM INSTR tableswitch 1 47: default 204
    //                   1 218
    //                   2 204
    //                   3 286
    //                   4 336
    //                   5 420
    //                   6 462
    //                   7 489
    //                   8 796
    //                   9 823
    //                   10 873
    //                   11 979
    //                   12 1200
    //                   13 1220
    //                   14 1473
    //                   15 1505
    //                   16 1525
    //                   17 1113
    //                   18 1553
    //                   19 1613
    //                   20 1023
    //                   21 1081
    //                   22 1629
    //                   23 1735
    //                   24 1838
    //                   25 1848
    //                   26 698
    //                   27 378
    //                   28 1868
    //                   29 1939
    //                   30 1959
    //                   31 2003
    //                   32 2043
    //                   33 1489
    //                   34 2081
    //                   35 2105
    //                   36 2125
    //                   37 2188
    //                   38 1569
    //                   39 1585
    //                   40 2249
    //                   41 2269
    //                   42 2301
    //                   43 2321
    //                   44 2432
    //                   45 1682
    //                   46 2491
    //                   47 2550;
           goto _L1 _L2 _L1 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47
_L1:
        boolean flag = super.onTransact(i, parcel, parcel1, j);
_L49:
        return flag;
_L2:
        parcel.enforceInterface("android.app.IApplicationThread");
        IBinder ibinder12 = parcel.readStrongBinder();
        boolean flag23;
        boolean flag24;
        int i3;
        if(parcel.readInt() != 0)
            flag23 = true;
        else
            flag23 = false;
        if(parcel.readInt() != 0)
            flag24 = true;
        else
            flag24 = false;
        i3 = parcel.readInt();
        schedulePauseActivity(ibinder12, flag23, flag24, i3);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L3:
        parcel.enforceInterface("android.app.IApplicationThread");
        IBinder ibinder11 = parcel.readStrongBinder();
        boolean flag22;
        int l2;
        if(parcel.readInt() != 0)
            flag22 = true;
        else
            flag22 = false;
        l2 = parcel.readInt();
        scheduleStopActivity(ibinder11, flag22, l2);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L4:
        parcel.enforceInterface("android.app.IApplicationThread");
        IBinder ibinder10 = parcel.readStrongBinder();
        boolean flag21;
        if(parcel.readInt() != 0)
            flag21 = true;
        else
            flag21 = false;
        scheduleWindowVisibility(ibinder10, flag21);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L27:
        parcel.enforceInterface("android.app.IApplicationThread");
        IBinder ibinder9 = parcel.readStrongBinder();
        boolean flag20;
        if(parcel.readInt() != 0)
            flag20 = true;
        else
            flag20 = false;
        scheduleSleeping(ibinder9, flag20);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L5:
        parcel.enforceInterface("android.app.IApplicationThread");
        IBinder ibinder8 = parcel.readStrongBinder();
        boolean flag19;
        if(parcel.readInt() != 0)
            flag19 = true;
        else
            flag19 = false;
        scheduleResumeActivity(ibinder8, flag19);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L6:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleSendResult(parcel.readStrongBinder(), parcel.createTypedArrayList(ResultInfo.CREATOR));
        flag = true;
        continue; /* Loop/switch isn't completed */
_L7:
        parcel.enforceInterface("android.app.IApplicationThread");
        Intent intent4 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        IBinder ibinder7 = parcel.readStrongBinder();
        int k2 = parcel.readInt();
        ActivityInfo activityinfo1 = (ActivityInfo)ActivityInfo.CREATOR.createFromParcel(parcel);
        Configuration configuration2 = (Configuration)Configuration.CREATOR.createFromParcel(parcel);
        CompatibilityInfo compatibilityinfo2 = (CompatibilityInfo)CompatibilityInfo.CREATOR.createFromParcel(parcel);
        android.os.Bundle bundle4 = parcel.readBundle();
        java.util.ArrayList arraylist3 = parcel.createTypedArrayList(ResultInfo.CREATOR);
        java.util.ArrayList arraylist4 = parcel.createTypedArrayList(Intent.CREATOR);
        boolean flag16;
        boolean flag17;
        String s7;
        ParcelFileDescriptor parcelfiledescriptor9;
        boolean flag18;
        if(parcel.readInt() != 0)
            flag16 = true;
        else
            flag16 = false;
        if(parcel.readInt() != 0)
            flag17 = true;
        else
            flag17 = false;
        s7 = parcel.readString();
        if(parcel.readInt() != 0)
            parcelfiledescriptor9 = parcel.readFileDescriptor();
        else
            parcelfiledescriptor9 = null;
        if(parcel.readInt() != 0)
            flag18 = true;
        else
            flag18 = false;
        scheduleLaunchActivity(intent4, ibinder7, k2, activityinfo1, configuration2, compatibilityinfo2, bundle4, arraylist3, arraylist4, flag16, flag17, s7, parcelfiledescriptor9, flag18);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L26:
        parcel.enforceInterface("android.app.IApplicationThread");
        IBinder ibinder6 = parcel.readStrongBinder();
        java.util.ArrayList arraylist1 = parcel.createTypedArrayList(ResultInfo.CREATOR);
        java.util.ArrayList arraylist2 = parcel.createTypedArrayList(Intent.CREATOR);
        int j2 = parcel.readInt();
        boolean flag15;
        Configuration configuration1;
        if(parcel.readInt() != 0)
            flag15 = true;
        else
            flag15 = false;
        configuration1 = null;
        if(parcel.readInt() != 0)
            configuration1 = (Configuration)Configuration.CREATOR.createFromParcel(parcel);
        scheduleRelaunchActivity(ibinder6, arraylist1, arraylist2, j2, flag15, configuration1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L8:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleNewIntent(parcel.createTypedArrayList(Intent.CREATOR), parcel.readStrongBinder());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L9:
        parcel.enforceInterface("android.app.IApplicationThread");
        IBinder ibinder5 = parcel.readStrongBinder();
        boolean flag14;
        int i2;
        if(parcel.readInt() != 0)
            flag14 = true;
        else
            flag14 = false;
        i2 = parcel.readInt();
        scheduleDestroyActivity(ibinder5, flag14, i2);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L10:
        parcel.enforceInterface("android.app.IApplicationThread");
        Intent intent3 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        ActivityInfo activityinfo = (ActivityInfo)ActivityInfo.CREATOR.createFromParcel(parcel);
        CompatibilityInfo compatibilityinfo1 = (CompatibilityInfo)CompatibilityInfo.CREATOR.createFromParcel(parcel);
        int l1 = parcel.readInt();
        String s6 = parcel.readString();
        android.os.Bundle bundle3 = parcel.readBundle();
        boolean flag13;
        if(parcel.readInt() != 0)
            flag13 = true;
        else
            flag13 = false;
        scheduleReceiver(intent3, activityinfo, compatibilityinfo1, l1, s6, bundle3, flag13);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L11:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleCreateService(parcel.readStrongBinder(), (ServiceInfo)ServiceInfo.CREATOR.createFromParcel(parcel), (CompatibilityInfo)CompatibilityInfo.CREATOR.createFromParcel(parcel));
        flag = true;
        continue; /* Loop/switch isn't completed */
_L20:
        parcel.enforceInterface("android.app.IApplicationThread");
        IBinder ibinder4 = parcel.readStrongBinder();
        Intent intent2 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        boolean flag12;
        if(parcel.readInt() != 0)
            flag12 = true;
        else
            flag12 = false;
        scheduleBindService(ibinder4, intent2, flag12);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L21:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleUnbindService(parcel.readStrongBinder(), (Intent)Intent.CREATOR.createFromParcel(parcel));
        flag = true;
        continue; /* Loop/switch isn't completed */
_L17:
        parcel.enforceInterface("android.app.IApplicationThread");
        IBinder ibinder3 = parcel.readStrongBinder();
        boolean flag11;
        int j1;
        int k1;
        Intent intent1;
        if(parcel.readInt() != 0)
            flag11 = true;
        else
            flag11 = false;
        j1 = parcel.readInt();
        k1 = parcel.readInt();
        if(parcel.readInt() != 0)
            intent1 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        else
            intent1 = null;
        scheduleServiceArgs(ibinder3, flag11, j1, k1, intent1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L12:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleStopService(parcel.readStrongBinder());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L13:
        parcel.enforceInterface("android.app.IApplicationThread");
        String s4 = parcel.readString();
        ApplicationInfo applicationinfo = (ApplicationInfo)ApplicationInfo.CREATOR.createFromParcel(parcel);
        java.util.ArrayList arraylist = parcel.createTypedArrayList(ProviderInfo.CREATOR);
        ComponentName componentname;
        String s5;
        ParcelFileDescriptor parcelfiledescriptor8;
        boolean flag7;
        android.os.Bundle bundle1;
        IInstrumentationWatcher iinstrumentationwatcher;
        int i1;
        boolean flag8;
        boolean flag9;
        boolean flag10;
        Configuration configuration;
        CompatibilityInfo compatibilityinfo;
        java.util.HashMap hashmap;
        android.os.Bundle bundle2;
        if(parcel.readInt() != 0)
            componentname = new ComponentName(parcel);
        else
            componentname = null;
        s5 = parcel.readString();
        if(parcel.readInt() != 0)
            parcelfiledescriptor8 = parcel.readFileDescriptor();
        else
            parcelfiledescriptor8 = null;
        if(parcel.readInt() != 0)
            flag7 = true;
        else
            flag7 = false;
        bundle1 = parcel.readBundle();
        iinstrumentationwatcher = IInstrumentationWatcher.Stub.asInterface(parcel.readStrongBinder());
        i1 = parcel.readInt();
        if(parcel.readInt() != 0)
            flag8 = true;
        else
            flag8 = false;
        if(parcel.readInt() != 0)
            flag9 = true;
        else
            flag9 = false;
        if(parcel.readInt() != 0)
            flag10 = true;
        else
            flag10 = false;
        configuration = (Configuration)Configuration.CREATOR.createFromParcel(parcel);
        compatibilityinfo = (CompatibilityInfo)CompatibilityInfo.CREATOR.createFromParcel(parcel);
        hashmap = parcel.readHashMap(null);
        bundle2 = parcel.readBundle();
        bindApplication(s4, applicationinfo, arraylist, componentname, s5, parcelfiledescriptor8, flag7, bundle1, iinstrumentationwatcher, i1, flag8, flag9, flag10, configuration, compatibilityinfo, hashmap, bundle2);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L14:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleExit();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L33:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleSuicide();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L15:
        parcel.enforceInterface("android.app.IApplicationThread");
        requestThumbnail(parcel.readStrongBinder());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L16:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleConfigurationChanged((Configuration)Configuration.CREATOR.createFromParcel(parcel));
        flag = true;
        continue; /* Loop/switch isn't completed */
_L18:
        parcel.enforceInterface("android.app.IApplicationThread");
        updateTimeZone();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L38:
        parcel.enforceInterface("android.app.IApplicationThread");
        clearDnsCache();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L39:
        parcel.enforceInterface("android.app.IApplicationThread");
        setHttpProxy(parcel.readString(), parcel.readString(), parcel.readString());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L19:
        parcel.enforceInterface("android.app.IApplicationThread");
        processInBackground();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L22:
        parcel.enforceInterface("android.app.IApplicationThread");
        ParcelFileDescriptor parcelfiledescriptor7 = parcel.readFileDescriptor();
        IBinder ibinder2 = parcel.readStrongBinder();
        String as5[] = parcel.readStringArray();
        if(parcelfiledescriptor7 != null) {
            dumpService(parcelfiledescriptor7.getFileDescriptor(), ibinder2, as5);
            ParcelFileDescriptor parcelfiledescriptor;
            String as[];
            Exception exception;
            ParcelFileDescriptor parcelfiledescriptor1;
            String as1[];
            Exception exception1;
            ParcelFileDescriptor parcelfiledescriptor2;
            boolean flag1;
            boolean flag2;
            String as2[];
            android.os.Debug.MemoryInfo memoryinfo;
            Exception exception2;
            android.os.Debug.MemoryInfo memoryinfo1;
            ParcelFileDescriptor parcelfiledescriptor3;
            IBinder ibinder;
            String s;
            String as3[];
            boolean flag3;
            String s1;
            ParcelFileDescriptor parcelfiledescriptor4;
            android.os.Debug.MemoryInfo memoryinfo2;
            boolean flag4;
            int k;
            String s2;
            ParcelFileDescriptor parcelfiledescriptor5;
            android.content.IIntentReceiver iintentreceiver;
            Intent intent;
            int l;
            String s3;
            android.os.Bundle bundle;
            boolean flag5;
            boolean flag6;
            ParcelFileDescriptor parcelfiledescriptor6;
            IBinder ibinder1;
            String as4[];
            try {
                parcelfiledescriptor7.close();
            }
            catch(IOException ioexception8) { }
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
_L45:
        parcel.enforceInterface("android.app.IApplicationThread");
        parcelfiledescriptor6 = parcel.readFileDescriptor();
        ibinder1 = parcel.readStrongBinder();
        as4 = parcel.readStringArray();
        if(parcelfiledescriptor6 != null) {
            dumpProvider(parcelfiledescriptor6.getFileDescriptor(), ibinder1, as4);
            try {
                parcelfiledescriptor6.close();
            }
            catch(IOException ioexception7) { }
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
_L23:
        parcel.enforceInterface("android.app.IApplicationThread");
        iintentreceiver = android.content.IIntentReceiver.Stub.asInterface(parcel.readStrongBinder());
        intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
        l = parcel.readInt();
        s3 = parcel.readString();
        bundle = parcel.readBundle();
        if(parcel.readInt() != 0)
            flag5 = true;
        else
            flag5 = false;
        if(parcel.readInt() != 0)
            flag6 = true;
        else
            flag6 = false;
        scheduleRegisteredReceiver(iintentreceiver, intent, l, s3, bundle, flag5, flag6);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L24:
        scheduleLowMemory();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L25:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleActivityConfigurationChanged(parcel.readStrongBinder());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L28:
        parcel.enforceInterface("android.app.IApplicationThread");
        if(parcel.readInt() != 0)
            flag4 = true;
        else
            flag4 = false;
        k = parcel.readInt();
        s2 = parcel.readString();
        if(parcel.readInt() != 0)
            parcelfiledescriptor5 = parcel.readFileDescriptor();
        else
            parcelfiledescriptor5 = null;
        profilerControl(flag4, s2, parcelfiledescriptor5, k);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L29:
        parcel.enforceInterface("android.app.IApplicationThread");
        setSchedulingGroup(parcel.readInt());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L30:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleCreateBackupAgent((ApplicationInfo)ApplicationInfo.CREATOR.createFromParcel(parcel), (CompatibilityInfo)CompatibilityInfo.CREATOR.createFromParcel(parcel), parcel.readInt());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L31:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleDestroyBackupAgent((ApplicationInfo)ApplicationInfo.CREATOR.createFromParcel(parcel), (CompatibilityInfo)CompatibilityInfo.CREATOR.createFromParcel(parcel));
        flag = true;
        continue; /* Loop/switch isn't completed */
_L32:
        parcel.enforceInterface("android.app.IApplicationThread");
        memoryinfo2 = new android.os.Debug.MemoryInfo();
        getMemoryInfo(memoryinfo2);
        parcel1.writeNoException();
        memoryinfo2.writeToParcel(parcel1, 0);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L34:
        parcel.enforceInterface("android.app.IApplicationThread");
        dispatchPackageBroadcast(parcel.readInt(), parcel.readStringArray());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L35:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleCrash(parcel.readString());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L36:
        parcel.enforceInterface("android.app.IApplicationThread");
        if(parcel.readInt() != 0)
            flag3 = true;
        else
            flag3 = false;
        s1 = parcel.readString();
        if(parcel.readInt() != 0)
            parcelfiledescriptor4 = parcel.readFileDescriptor();
        else
            parcelfiledescriptor4 = null;
        dumpHeap(flag3, s1, parcelfiledescriptor4);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L37:
        parcel.enforceInterface("android.app.IApplicationThread");
        parcelfiledescriptor3 = parcel.readFileDescriptor();
        ibinder = parcel.readStrongBinder();
        s = parcel.readString();
        as3 = parcel.readStringArray();
        if(parcelfiledescriptor3 != null) {
            dumpActivity(parcelfiledescriptor3.getFileDescriptor(), ibinder, s, as3);
            try {
                parcelfiledescriptor3.close();
            }
            catch(IOException ioexception6) { }
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
_L40:
        parcel.enforceInterface("android.app.IApplicationThread");
        setCoreSettings(parcel.readBundle());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L41:
        parcel.enforceInterface("android.app.IApplicationThread");
        updatePackageCompatibilityInfo(parcel.readString(), (CompatibilityInfo)CompatibilityInfo.CREATOR.createFromParcel(parcel));
        flag = true;
        continue; /* Loop/switch isn't completed */
_L42:
        parcel.enforceInterface("android.app.IApplicationThread");
        scheduleTrimMemory(parcel.readInt());
        flag = true;
        continue; /* Loop/switch isn't completed */
_L43:
        parcel.enforceInterface("android.app.IApplicationThread");
        parcelfiledescriptor2 = parcel.readFileDescriptor();
        if(parcel.readInt() != 0)
            flag1 = true;
        else
            flag1 = false;
        if(parcel.readInt() != 0)
            flag2 = true;
        else
            flag2 = false;
        as2 = parcel.readStringArray();
        memoryinfo = null;
        if(parcelfiledescriptor2 == null)
            break MISSING_BLOCK_LABEL_2393;
        memoryinfo1 = dumpMemInfo(parcelfiledescriptor2.getFileDescriptor(), flag1, flag2, as2);
        memoryinfo = memoryinfo1;
        try {
            parcelfiledescriptor2.close();
        }
        catch(IOException ioexception5) { }
        parcel1.writeNoException();
        memoryinfo.writeToParcel(parcel1, 0);
        flag = true;
        continue; /* Loop/switch isn't completed */
        exception2;
        try {
            parcelfiledescriptor2.close();
        }
        catch(IOException ioexception4) { }
        throw exception2;
_L44:
        parcel.enforceInterface("android.app.IApplicationThread");
        parcelfiledescriptor1 = parcel.readFileDescriptor();
        as1 = parcel.readStringArray();
        if(parcelfiledescriptor1 == null)
            break MISSING_BLOCK_LABEL_2471;
        dumpGfxInfo(parcelfiledescriptor1.getFileDescriptor(), as1);
        try {
            parcelfiledescriptor1.close();
        }
        catch(IOException ioexception3) { }
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
        exception1;
        try {
            parcelfiledescriptor1.close();
        }
        catch(IOException ioexception2) { }
        throw exception1;
_L46:
        parcel.enforceInterface("android.app.IApplicationThread");
        parcelfiledescriptor = parcel.readFileDescriptor();
        as = parcel.readStringArray();
        if(parcelfiledescriptor == null)
            break MISSING_BLOCK_LABEL_2530;
        dumpDbInfo(parcelfiledescriptor.getFileDescriptor(), as);
        try {
            parcelfiledescriptor.close();
        }
        catch(IOException ioexception1) { }
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
        exception;
        try {
            parcelfiledescriptor.close();
        }
        catch(IOException ioexception) { }
        throw exception;
_L47:
        parcel.enforceInterface("android.app.IApplicationThread");
        unstableProviderDied(parcel.readStrongBinder());
        parcel1.writeNoException();
        flag = true;
        if(true) goto _L49; else goto _L48
_L48:
    }
}
