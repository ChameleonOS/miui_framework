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
import android.util.Singleton;
import java.util.List;

// Referenced classes of package android.app:
//            IActivityManager, ActivityManagerProxy, PendingIntent, ApplicationThreadNative, 
//            Notification

public abstract class ActivityManagerNative extends Binder
    implements IActivityManager {

    public ActivityManagerNative() {
        attachInterface(this, "android.app.IActivityManager");
    }

    public static IActivityManager asInterface(IBinder ibinder) {
        if(ibinder != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((IActivityManager) (obj));
_L2:
        obj = (IActivityManager)ibinder.queryLocalInterface("android.app.IActivityManager");
        if(obj == null)
            obj = new ActivityManagerProxy(ibinder);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static void broadcastStickyIntent(Intent intent, String s) {
        getDefault().broadcastIntent(null, intent, null, null, -1, null, null, null, false, true, Binder.getOrigCallingUser());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static IActivityManager getDefault() {
        return (IActivityManager)gDefault.get();
    }

    public static boolean isSystemReady() {
        if(!sSystemReady)
            sSystemReady = getDefault().testIsSystemReady();
        return sSystemReady;
    }

    public static void noteWakeupAlarm(PendingIntent pendingintent) {
        getDefault().noteWakeupAlarm(pendingintent.getTarget());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j) throws RemoteException {
        i;
        JVM INSTR tableswitch 1 152: default 624
    //                   1 5605
    //                   2 5641
    //                   3 638
    //                   4 5159
    //                   5 5179
    //                   6 624
    //                   7 624
    //                   8 624
    //                   9 624
    //                   10 624
    //                   11 1540
    //                   12 1748
    //                   13 1879
    //                   14 1921
    //                   15 2101
    //                   16 2163
    //                   17 2238
    //                   18 2274
    //                   19 2351
    //                   20 2375
    //                   21 2504
    //                   22 2551
    //                   23 2583
    //                   24 2968
    //                   25 3033
    //                   26 3125
    //                   27 3149
    //                   28 3215
    //                   29 3288
    //                   30 3427
    //                   31 3461
    //                   32 1624
    //                   33 3613
    //                   34 3653
    //                   35 3704
    //                   36 3897
    //                   37 3995
    //                   38 4044
    //                   39 624
    //                   40 5233
    //                   41 5253
    //                   42 5311
    //                   43 5375
    //                   44 4182
    //                   45 4247
    //                   46 4282
    //                   47 4311
    //                   48 3755
    //                   49 4403
    //                   50 4435
    //                   51 4727
    //                   52 4751
    //                   53 4833
    //                   54 4873
    //                   55 4982
    //                   56 5029
    //                   57 5413
    //                   58 5072
    //                   59 5799
    //                   60 2707
    //                   61 4146
    //                   62 2480
    //                   63 4467
    //                   64 4630
    //                   65 4657
    //                   66 5436
    //                   67 1429
    //                   68 5456
    //                   69 3539
    //                   70 4343
    //                   71 4371
    //                   72 4084
    //                   73 4779
    //                   74 3809
    //                   75 3057
    //                   76 5121
    //                   77 2884
    //                   78 4925
    //                   79 5867
    //                   80 5483
    //                   81 2794
    //                   82 2743
    //                   83 2912
    //                   84 5929
    //                   85 6149
    //                   86 5958
    //                   87 6063
    //                   88 6109
    //                   89 6129
    //                   90 6193
    //                   91 6251
    //                   92 6279
    //                   93 4692
    //                   94 624
    //                   95 6311
    //                   96 6432
    //                   97 6460
    //                   98 6484
    //                   99 6517
    //                   100 1223
    //                   101 6545
    //                   102 5681
    //                   103 5823
    //                   104 6581
    //                   105 839
    //                   106 1702
    //                   107 1041
    //                   108 2940
    //                   109 6623
    //                   110 5751
    //                   111 6643
    //                   112 6689
    //                   113 6736
    //                   114 6778
    //                   115 6814
    //                   116 6854
    //                   117 6886
    //                   118 6934
    //                   119 6984
    //                   120 7036
    //                   121 7228
    //                   122 7133
    //                   123 2456
    //                   124 7326
    //                   125 7354
    //                   126 7388
    //                   127 7420
    //                   128 7669
    //                   129 7715
    //                   130 7448
    //                   131 7523
    //                   132 7573
    //                   133 7623
    //                   134 7646
    //                   135 7761
    //                   136 7859
    //                   137 7891
    //                   138 7923
    //                   139 7977
    //                   140 5847
    //                   141 3372
    //                   142 3585
    //                   143 5891
    //                   144 5559
    //                   145 7494
    //                   146 7997
    //                   147 8047
    //                   148 5273
    //                   149 1656
    //                   150 8147
    //                   151 3515
    //                   152 7810;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L1 _L1 _L1 _L1 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L1 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67 _L68 _L69 _L70 _L71 _L72 _L73 _L74 _L75 _L76 _L77 _L78 _L79 _L80 _L81 _L82 _L83 _L84 _L85 _L86 _L87 _L88 _L1 _L89 _L90 _L91 _L92 _L93 _L94 _L95 _L96 _L97 _L98 _L99 _L100 _L101 _L102 _L103 _L104 _L105 _L106 _L107 _L108 _L109 _L110 _L111 _L112 _L113 _L114 _L115 _L116 _L117 _L118 _L119 _L120 _L121 _L122 _L123 _L124 _L125 _L126 _L127 _L128 _L129 _L130 _L131 _L132 _L133 _L134 _L135 _L136 _L137 _L138 _L139 _L140 _L141 _L142 _L143 _L144 _L145 _L146
_L1:
        boolean flag = super.onTransact(i, parcel, parcel1, j);
_L148:
        return flag;
_L4:
        parcel.enforceInterface("android.app.IActivityManager");
        IApplicationThread iapplicationthread11 = ApplicationThreadNative.asInterface(parcel.readStrongBinder());
        Intent intent12 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        String s30 = parcel.readString();
        IBinder ibinder39 = parcel.readStrongBinder();
        String s31 = parcel.readString();
        int k20 = parcel.readInt();
        int l20 = parcel.readInt();
        String s32 = parcel.readString();
        ParcelFileDescriptor parcelfiledescriptor4;
        Bundle bundle12;
        int i21;
        if(parcel.readInt() != 0)
            parcelfiledescriptor4 = parcel.readFileDescriptor();
        else
            parcelfiledescriptor4 = null;
        if(parcel.readInt() != 0)
            bundle12 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        else
            bundle12 = null;
        i21 = startActivity(iapplicationthread11, intent12, s30, ibinder39, s31, k20, l20, s32, parcelfiledescriptor4, bundle12);
        parcel1.writeNoException();
        parcel1.writeInt(i21);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L99:
        parcel.enforceInterface("android.app.IActivityManager");
        IApplicationThread iapplicationthread10 = ApplicationThreadNative.asInterface(parcel.readStrongBinder());
        Intent intent11 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        String s27 = parcel.readString();
        IBinder ibinder38 = parcel.readStrongBinder();
        String s28 = parcel.readString();
        int i20 = parcel.readInt();
        int j20 = parcel.readInt();
        String s29 = parcel.readString();
        ParcelFileDescriptor parcelfiledescriptor3;
        Bundle bundle11;
        IActivityManager.WaitResult waitresult;
        if(parcel.readInt() != 0)
            parcelfiledescriptor3 = parcel.readFileDescriptor();
        else
            parcelfiledescriptor3 = null;
        if(parcel.readInt() != 0)
            bundle11 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        else
            bundle11 = null;
        waitresult = startActivityAndWait(iapplicationthread10, intent11, s27, ibinder38, s28, i20, j20, s29, parcelfiledescriptor3, bundle11);
        parcel1.writeNoException();
        waitresult.writeToParcel(parcel1, 0);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L101:
        parcel.enforceInterface("android.app.IActivityManager");
        IApplicationThread iapplicationthread9 = ApplicationThreadNative.asInterface(parcel.readStrongBinder());
        Intent intent10 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        String s25 = parcel.readString();
        IBinder ibinder37 = parcel.readStrongBinder();
        String s26 = parcel.readString();
        int j19 = parcel.readInt();
        int k19 = parcel.readInt();
        Configuration configuration2 = (Configuration)Configuration.CREATOR.createFromParcel(parcel);
        Bundle bundle10;
        int l19;
        if(parcel.readInt() != 0)
            bundle10 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        else
            bundle10 = null;
        l19 = startActivityWithConfig(iapplicationthread9, intent10, s25, ibinder37, s26, j19, k19, configuration2, bundle10);
        parcel1.writeNoException();
        parcel1.writeInt(l19);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L94:
        parcel.enforceInterface("android.app.IActivityManager");
        IApplicationThread iapplicationthread8 = ApplicationThreadNative.asInterface(parcel.readStrongBinder());
        IntentSender intentsender = (IntentSender)IntentSender.CREATOR.createFromParcel(parcel);
        Intent intent9 = null;
        if(parcel.readInt() != 0)
            intent9 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        String s23 = parcel.readString();
        IBinder ibinder36 = parcel.readStrongBinder();
        String s24 = parcel.readString();
        int j18 = parcel.readInt();
        int k18 = parcel.readInt();
        int l18 = parcel.readInt();
        Bundle bundle9;
        int i19;
        if(parcel.readInt() != 0)
            bundle9 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        else
            bundle9 = null;
        i19 = startActivityIntentSender(iapplicationthread8, intentsender, intent9, s23, ibinder36, s24, j18, k18, l18, bundle9);
        parcel1.writeNoException();
        parcel1.writeInt(i19);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L62:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder35 = parcel.readStrongBinder();
        Intent intent8 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        Bundle bundle8;
        boolean flag50;
        int i18;
        if(parcel.readInt() != 0)
            bundle8 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        else
            bundle8 = null;
        flag50 = startNextMatchingActivity(ibinder35, intent8, bundle8);
        parcel1.writeNoException();
        if(flag50)
            i18 = 1;
        else
            i18 = 0;
        parcel1.writeInt(i18);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L7:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder34 = parcel.readStrongBinder();
        Intent intent7 = null;
        int k17 = parcel.readInt();
        if(parcel.readInt() != 0)
            intent7 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        boolean flag49 = finishActivity(ibinder34, k17, intent7);
        parcel1.writeNoException();
        int l17;
        if(flag49)
            l17 = 1;
        else
            l17 = 0;
        parcel1.writeInt(l17);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L28:
        parcel.enforceInterface("android.app.IActivityManager");
        finishSubActivity(parcel.readStrongBinder(), parcel.readString(), parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L143:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag48 = finishActivityAffinity(parcel.readStrongBinder());
        parcel1.writeNoException();
        int j17;
        if(flag48)
            j17 = 1;
        else
            j17 = 0;
        parcel1.writeInt(j17);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L100:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag47 = willActivityBeVisible(parcel.readStrongBinder());
        parcel1.writeNoException();
        int i17;
        if(flag47)
            i17 = 1;
        else
            i17 = 0;
        parcel1.writeInt(i17);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L8:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder32 = parcel.readStrongBinder();
        IApplicationThread iapplicationthread7;
        String s21;
        IBinder ibinder33;
        android.content.IIntentReceiver iintentreceiver1;
        IntentFilter intentfilter;
        String s22;
        Intent intent6;
        if(ibinder32 != null)
            iapplicationthread7 = ApplicationThreadNative.asInterface(ibinder32);
        else
            iapplicationthread7 = null;
        s21 = parcel.readString();
        ibinder33 = parcel.readStrongBinder();
        if(ibinder33 != null)
            iintentreceiver1 = android.content.IIntentReceiver.Stub.asInterface(ibinder33);
        else
            iintentreceiver1 = null;
        intentfilter = (IntentFilter)IntentFilter.CREATOR.createFromParcel(parcel);
        s22 = parcel.readString();
        intent6 = registerReceiver(iapplicationthread7, s21, iintentreceiver1, intentfilter, s22);
        parcel1.writeNoException();
        if(intent6 != null) {
            parcel1.writeInt(1);
            intent6.writeToParcel(parcel1, 0);
        } else {
            parcel1.writeInt(0);
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
_L9:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder31 = parcel.readStrongBinder();
        if(ibinder31 == null) {
            flag = true;
        } else {
            unregisterReceiver(android.content.IIntentReceiver.Stub.asInterface(ibinder31));
            parcel1.writeNoException();
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder29 = parcel.readStrongBinder();
        IApplicationThread iapplicationthread6;
        Intent intent5;
        String s18;
        IBinder ibinder30;
        android.content.IIntentReceiver iintentreceiver;
        int j16;
        String s19;
        Bundle bundle7;
        String s20;
        boolean flag45;
        boolean flag46;
        int k16;
        int l16;
        if(ibinder29 != null)
            iapplicationthread6 = ApplicationThreadNative.asInterface(ibinder29);
        else
            iapplicationthread6 = null;
        intent5 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        s18 = parcel.readString();
        ibinder30 = parcel.readStrongBinder();
        if(ibinder30 != null)
            iintentreceiver = android.content.IIntentReceiver.Stub.asInterface(ibinder30);
        else
            iintentreceiver = null;
        j16 = parcel.readInt();
        s19 = parcel.readString();
        bundle7 = parcel.readBundle();
        s20 = parcel.readString();
        if(parcel.readInt() != 0)
            flag45 = true;
        else
            flag45 = false;
        if(parcel.readInt() != 0)
            flag46 = true;
        else
            flag46 = false;
        k16 = parcel.readInt();
        l16 = broadcastIntent(iapplicationthread6, intent5, s18, iintentreceiver, j16, s19, bundle7, s20, flag45, flag46, k16);
        parcel1.writeNoException();
        parcel1.writeInt(l16);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L11:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder28 = parcel.readStrongBinder();
        IApplicationThread iapplicationthread5;
        if(ibinder28 != null)
            iapplicationthread5 = ApplicationThreadNative.asInterface(ibinder28);
        else
            iapplicationthread5 = null;
        unbroadcastIntent(iapplicationthread5, (Intent)Intent.CREATOR.createFromParcel(parcel), parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L12:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder27 = parcel.readStrongBinder();
        int i16 = parcel.readInt();
        String s17 = parcel.readString();
        Bundle bundle6 = parcel.readBundle();
        boolean flag44;
        if(parcel.readInt() != 0)
            flag44 = true;
        else
            flag44 = false;
        if(ibinder27 != null)
            finishReceiver(ibinder27, i16, s17, bundle6, flag44);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L13:
        parcel.enforceInterface("android.app.IActivityManager");
        IApplicationThread iapplicationthread4 = ApplicationThreadNative.asInterface(parcel.readStrongBinder());
        if(iapplicationthread4 != null)
            attachApplication(iapplicationthread4);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L14:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder26 = parcel.readStrongBinder();
        Configuration configuration1 = null;
        if(parcel.readInt() != 0)
            configuration1 = (Configuration)Configuration.CREATOR.createFromParcel(parcel);
        boolean flag43;
        if(parcel.readInt() != 0)
            flag43 = true;
        else
            flag43 = false;
        if(ibinder26 != null)
            activityIdle(ibinder26, configuration1, flag43);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L15:
        parcel.enforceInterface("android.app.IActivityManager");
        activityPaused(parcel.readStrongBinder());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L16:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder25 = parcel.readStrongBinder();
        Bundle bundle5 = parcel.readBundle();
        Bitmap bitmap1;
        CharSequence charsequence2;
        if(parcel.readInt() != 0)
            bitmap1 = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
        else
            bitmap1 = null;
        charsequence2 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        activityStopped(ibinder25, bundle5, bitmap1, charsequence2);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L117:
        parcel.enforceInterface("android.app.IActivityManager");
        activitySlept(parcel.readStrongBinder());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L57:
        parcel.enforceInterface("android.app.IActivityManager");
        activityDestroyed(parcel.readStrongBinder());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L17:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder24 = parcel.readStrongBinder();
        String s16;
        if(ibinder24 != null)
            s16 = getCallingPackage(ibinder24);
        else
            s16 = null;
        parcel1.writeNoException();
        parcel1.writeString(s16);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L18:
        parcel.enforceInterface("android.app.IActivityManager");
        ComponentName componentname3 = getCallingActivity(parcel.readStrongBinder());
        parcel1.writeNoException();
        ComponentName.writeToParcel(componentname3, parcel1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L19:
        parcel.enforceInterface("android.app.IActivityManager");
        int i15 = parcel.readInt();
        int j15 = parcel.readInt();
        IBinder ibinder23 = parcel.readStrongBinder();
        IThumbnailReceiver ithumbnailreceiver;
        List list5;
        int k15;
        if(ibinder23 != null)
            ithumbnailreceiver = IThumbnailReceiver.Stub.asInterface(ibinder23);
        else
            ithumbnailreceiver = null;
        list5 = getTasks(i15, j15, ithumbnailreceiver);
        parcel1.writeNoException();
        if(list5 != null)
            k15 = list5.size();
        else
            k15 = -1;
        parcel1.writeInt(k15);
        for(int l15 = 0; l15 < k15; l15++)
            ((ActivityManager.RunningTaskInfo)list5.get(l15)).writeToParcel(parcel1, 0);

        flag = true;
        continue; /* Loop/switch isn't completed */
_L55:
        parcel.enforceInterface("android.app.IActivityManager");
        List list4 = getRecentTasks(parcel.readInt(), parcel.readInt());
        parcel1.writeNoException();
        parcel1.writeTypedList(list4);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L77:
        parcel.enforceInterface("android.app.IActivityManager");
        ActivityManager.TaskThumbnails taskthumbnails = getTaskThumbnails(parcel.readInt());
        parcel1.writeNoException();
        if(taskthumbnails != null) {
            parcel1.writeInt(1);
            taskthumbnails.writeToParcel(parcel1, 0);
        } else {
            parcel1.writeInt(0);
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
_L76:
        parcel.enforceInterface("android.app.IActivityManager");
        List list3 = getServices(parcel.readInt(), parcel.readInt());
        parcel1.writeNoException();
        int k14;
        if(list3 != null)
            k14 = list3.size();
        else
            k14 = -1;
        parcel1.writeInt(k14);
        for(int l14 = 0; l14 < k14; l14++)
            ((ActivityManager.RunningServiceInfo)list3.get(l14)).writeToParcel(parcel1, 0);

        flag = true;
        continue; /* Loop/switch isn't completed */
_L72:
        parcel.enforceInterface("android.app.IActivityManager");
        List list2 = getProcessesInErrorState();
        parcel1.writeNoException();
        parcel1.writeTypedList(list2);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L78:
        parcel.enforceInterface("android.app.IActivityManager");
        List list1 = getRunningAppProcesses();
        parcel1.writeNoException();
        parcel1.writeTypedList(list1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L102:
        parcel.enforceInterface("android.app.IActivityManager");
        List list = getRunningExternalApplications();
        parcel1.writeNoException();
        parcel1.writeTypedList(list);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L20:
        parcel.enforceInterface("android.app.IActivityManager");
        int i14 = parcel.readInt();
        int j14 = parcel.readInt();
        Bundle bundle4;
        if(parcel.readInt() != 0)
            bundle4 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        else
            bundle4 = null;
        moveTaskToFront(i14, j14, bundle4);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L21:
        parcel.enforceInterface("android.app.IActivityManager");
        moveTaskToBack(parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L70:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder22 = parcel.readStrongBinder();
        boolean flag41;
        boolean flag42;
        int l13;
        if(parcel.readInt() != 0)
            flag41 = true;
        else
            flag41 = false;
        flag42 = moveActivityTaskToBack(ibinder22, flag41);
        parcel1.writeNoException();
        if(flag42)
            l13 = 1;
        else
            l13 = 0;
        parcel1.writeInt(l13);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L22:
        parcel.enforceInterface("android.app.IActivityManager");
        moveTaskBackwards(parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L23:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder21 = parcel.readStrongBinder();
        boolean flag40;
        int k13;
        if(parcel.readInt() != 0)
            flag40 = true;
        else
            flag40 = false;
        if(ibinder21 != null)
            k13 = getTaskForActivity(ibinder21, flag40);
        else
            k13 = -1;
        parcel1.writeNoException();
        parcel1.writeInt(k13);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L24:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder20 = parcel.readStrongBinder();
        Bitmap bitmap;
        CharSequence charsequence1;
        if(parcel.readInt() != 0)
            bitmap = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
        else
            bitmap = null;
        charsequence1 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        reportThumbnail(ibinder20, bitmap, charsequence1);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L25:
        parcel.enforceInterface("android.app.IActivityManager");
        IApplicationThread iapplicationthread3 = ApplicationThreadNative.asInterface(parcel.readStrongBinder());
        String s15 = parcel.readString();
        boolean flag39;
        IActivityManager.ContentProviderHolder contentproviderholder1;
        if(parcel.readInt() != 0)
            flag39 = true;
        else
            flag39 = false;
        contentproviderholder1 = getContentProvider(iapplicationthread3, s15, flag39);
        parcel1.writeNoException();
        if(contentproviderholder1 != null) {
            parcel1.writeInt(1);
            contentproviderholder1.writeToParcel(parcel1, 0);
        } else {
            parcel1.writeInt(0);
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
_L135:
        parcel.enforceInterface("android.app.IActivityManager");
        IActivityManager.ContentProviderHolder contentproviderholder = getContentProviderExternal(parcel.readString(), parcel.readStrongBinder());
        parcel1.writeNoException();
        if(contentproviderholder != null) {
            parcel1.writeInt(1);
            contentproviderholder.writeToParcel(parcel1, 0);
        } else {
            parcel1.writeInt(0);
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
_L26:
        parcel.enforceInterface("android.app.IActivityManager");
        publishContentProviders(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.createTypedArrayList(IActivityManager.ContentProviderHolder.CREATOR));
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L27:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag38 = refContentProvider(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt());
        parcel1.writeNoException();
        int j13;
        if(flag38)
            j13 = 1;
        else
            j13 = 0;
        parcel1.writeInt(j13);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L145:
        parcel.enforceInterface("android.app.IActivityManager");
        unstableProviderDied(parcel.readStrongBinder());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L64:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder19 = parcel.readStrongBinder();
        boolean flag37;
        if(parcel.readInt() != 0)
            flag37 = true;
        else
            flag37 = false;
        removeContentProvider(ibinder19, flag37);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L136:
        parcel.enforceInterface("android.app.IActivityManager");
        removeContentProviderExternal(parcel.readString(), parcel.readStrongBinder());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L29:
        parcel.enforceInterface("android.app.IActivityManager");
        PendingIntent pendingintent = getRunningServiceControlPanel((ComponentName)ComponentName.CREATOR.createFromParcel(parcel));
        parcel1.writeNoException();
        PendingIntent.writePendingIntentOrNullToParcel(pendingintent, parcel1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L30:
        parcel.enforceInterface("android.app.IActivityManager");
        ComponentName componentname2 = startService(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), (Intent)Intent.CREATOR.createFromParcel(parcel), parcel.readString());
        parcel1.writeNoException();
        ComponentName.writeToParcel(componentname2, parcel1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L31:
        parcel.enforceInterface("android.app.IActivityManager");
        int i13 = stopService(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), (Intent)Intent.CREATOR.createFromParcel(parcel), parcel.readString());
        parcel1.writeNoException();
        parcel1.writeInt(i13);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L43:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag36 = stopServiceToken(ComponentName.readFromParcel(parcel), parcel.readStrongBinder(), parcel.readInt());
        parcel1.writeNoException();
        int l12;
        if(flag36)
            l12 = 1;
        else
            l12 = 0;
        parcel1.writeInt(l12);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L69:
        parcel.enforceInterface("android.app.IActivityManager");
        ComponentName componentname1 = ComponentName.readFromParcel(parcel);
        IBinder ibinder18 = parcel.readStrongBinder();
        int k12 = parcel.readInt();
        Notification notification = null;
        if(parcel.readInt() != 0)
            notification = (Notification)Notification.CREATOR.createFromParcel(parcel);
        boolean flag35;
        if(parcel.readInt() != 0)
            flag35 = true;
        else
            flag35 = false;
        setServiceForeground(componentname1, ibinder18, k12, notification, flag35);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L32:
        parcel.enforceInterface("android.app.IActivityManager");
        IApplicationThread iapplicationthread2 = ApplicationThreadNative.asInterface(parcel.readStrongBinder());
        IBinder ibinder16 = parcel.readStrongBinder();
        Intent intent4 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        String s14 = parcel.readString();
        IBinder ibinder17 = parcel.readStrongBinder();
        int l11 = parcel.readInt();
        int i12 = parcel.readInt();
        int j12 = bindService(iapplicationthread2, ibinder16, intent4, s14, IServiceConnection.Stub.asInterface(ibinder17), l11, i12);
        parcel1.writeNoException();
        parcel1.writeInt(j12);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L33:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag34 = unbindService(IServiceConnection.Stub.asInterface(parcel.readStrongBinder()));
        parcel1.writeNoException();
        int k11;
        if(flag34)
            k11 = 1;
        else
            k11 = 0;
        parcel1.writeInt(k11);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L34:
        parcel.enforceInterface("android.app.IActivityManager");
        publishService(parcel.readStrongBinder(), (Intent)Intent.CREATOR.createFromParcel(parcel), parcel.readStrongBinder());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L67:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder15 = parcel.readStrongBinder();
        Intent intent3 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        boolean flag33;
        if(parcel.readInt() != 0)
            flag33 = true;
        else
            flag33 = false;
        unbindFinished(ibinder15, intent3, flag33);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L56:
        parcel.enforceInterface("android.app.IActivityManager");
        serviceDoneExecuting(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L39:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag32 = startInstrumentation(ComponentName.readFromParcel(parcel), parcel.readString(), parcel.readInt(), parcel.readBundle(), IInstrumentationWatcher.Stub.asInterface(parcel.readStrongBinder()));
        parcel1.writeNoException();
        int j11;
        if(flag32)
            j11 = 1;
        else
            j11 = 0;
        parcel1.writeInt(j11);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L40:
        parcel.enforceInterface("android.app.IActivityManager");
        finishInstrumentation(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readBundle());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L41:
        parcel.enforceInterface("android.app.IActivityManager");
        Configuration configuration = getConfiguration();
        parcel1.writeNoException();
        configuration.writeToParcel(parcel1, 0);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L42:
        parcel.enforceInterface("android.app.IActivityManager");
        updateConfiguration((Configuration)Configuration.CREATOR.createFromParcel(parcel));
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L65:
        parcel.enforceInterface("android.app.IActivityManager");
        setRequestedOrientation(parcel.readStrongBinder(), parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L66:
        parcel.enforceInterface("android.app.IActivityManager");
        int i11 = getRequestedOrientation(parcel.readStrongBinder());
        parcel1.writeNoException();
        parcel1.writeInt(i11);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L44:
        parcel.enforceInterface("android.app.IActivityManager");
        ComponentName componentname = getActivityClassForToken(parcel.readStrongBinder());
        parcel1.writeNoException();
        ComponentName.writeToParcel(componentname, parcel1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L45:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder14 = parcel.readStrongBinder();
        parcel1.writeNoException();
        parcel1.writeString(getPackageForToken(ibinder14));
        flag = true;
        continue; /* Loop/switch isn't completed */
_L58:
        parcel.enforceInterface("android.app.IActivityManager");
        int j10 = parcel.readInt();
        String s12 = parcel.readString();
        IBinder ibinder12 = parcel.readStrongBinder();
        String s13 = parcel.readString();
        int k10 = parcel.readInt();
        Intent aintent2[];
        String as2[];
        int l10;
        Bundle bundle3;
        IIntentSender iintentsender;
        IBinder ibinder13;
        if(parcel.readInt() != 0) {
            aintent2 = (Intent[])parcel.createTypedArray(Intent.CREATOR);
            as2 = parcel.createStringArray();
        } else {
            aintent2 = null;
            as2 = null;
        }
        l10 = parcel.readInt();
        if(parcel.readInt() != 0)
            bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        else
            bundle3 = null;
        iintentsender = getIntentSender(j10, s12, ibinder12, s13, k10, aintent2, as2, l10, bundle3);
        parcel1.writeNoException();
        if(iintentsender != null)
            ibinder13 = iintentsender.asBinder();
        else
            ibinder13 = null;
        parcel1.writeStrongBinder(ibinder13);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L59:
        parcel.enforceInterface("android.app.IActivityManager");
        cancelIntentSender(android.content.IIntentSender.Stub.asInterface(parcel.readStrongBinder()));
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L60:
        parcel.enforceInterface("android.app.IActivityManager");
        String s11 = getPackageForIntentSender(android.content.IIntentSender.Stub.asInterface(parcel.readStrongBinder()));
        parcel1.writeNoException();
        parcel1.writeString(s11);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L88:
        parcel.enforceInterface("android.app.IActivityManager");
        int i10 = getUidForIntentSender(android.content.IIntentSender.Stub.asInterface(parcel.readStrongBinder()));
        parcel1.writeNoException();
        parcel1.writeInt(i10);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L46:
        parcel.enforceInterface("android.app.IActivityManager");
        setProcessLimit(parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L47:
        parcel.enforceInterface("android.app.IActivityManager");
        int l9 = getProcessLimit();
        parcel1.writeNoException();
        parcel1.writeInt(l9);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L68:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder11 = parcel.readStrongBinder();
        int k9 = parcel.readInt();
        boolean flag31;
        if(parcel.readInt() != 0)
            flag31 = true;
        else
            flag31 = false;
        setProcessForeground(ibinder11, k9, flag31);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L48:
        parcel.enforceInterface("android.app.IActivityManager");
        int j9 = checkPermission(parcel.readString(), parcel.readInt(), parcel.readInt());
        parcel1.writeNoException();
        parcel1.writeInt(j9);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L49:
        parcel.enforceInterface("android.app.IActivityManager");
        int i9 = checkUriPermission((Uri)Uri.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readInt(), parcel.readInt());
        parcel1.writeNoException();
        parcel1.writeInt(i9);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L73:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag30 = clearApplicationUserData(parcel.readString(), android.content.pm.IPackageDataObserver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
        parcel1.writeNoException();
        int l8;
        if(flag30)
            l8 = 1;
        else
            l8 = 0;
        parcel1.writeInt(l8);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L50:
        parcel.enforceInterface("android.app.IActivityManager");
        grantUriPermission(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), parcel.readString(), (Uri)Uri.CREATOR.createFromParcel(parcel), parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L51:
        parcel.enforceInterface("android.app.IActivityManager");
        revokeUriPermission(ApplicationThreadNative.asInterface(parcel.readStrongBinder()), (Uri)Uri.CREATOR.createFromParcel(parcel), parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L53:
        parcel.enforceInterface("android.app.IActivityManager");
        IApplicationThread iapplicationthread1 = ApplicationThreadNative.asInterface(parcel.readStrongBinder());
        boolean flag29;
        if(parcel.readInt() != 0)
            flag29 = true;
        else
            flag29 = false;
        showWaitingForDebugger(iapplicationthread1, flag29);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L71:
        parcel.enforceInterface("android.app.IActivityManager");
        ActivityManager.MemoryInfo memoryinfo = new ActivityManager.MemoryInfo();
        getMemoryInfo(memoryinfo);
        parcel1.writeNoException();
        memoryinfo.writeToParcel(parcel1, 0);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L5:
        parcel.enforceInterface("android.app.IActivityManager");
        unhandledBack();
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L6:
        parcel.enforceInterface("android.app.IActivityManager");
        ParcelFileDescriptor parcelfiledescriptor2 = openContentUri(Uri.parse(parcel.readString()));
        parcel1.writeNoException();
        if(parcelfiledescriptor2 != null) {
            parcel1.writeInt(1);
            parcelfiledescriptor2.writeToParcel(parcel1, 1);
        } else {
            parcel1.writeInt(0);
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
_L35:
        parcel.enforceInterface("android.app.IActivityManager");
        goingToSleep();
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L36:
        parcel.enforceInterface("android.app.IActivityManager");
        wakingUp();
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L142:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag28;
        if(parcel.readInt() != 0)
            flag28 = true;
        else
            flag28 = false;
        setLockScreenShown(flag28);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L37:
        parcel.enforceInterface("android.app.IActivityManager");
        String s10 = parcel.readString();
        boolean flag26;
        boolean flag27;
        if(parcel.readInt() != 0)
            flag26 = true;
        else
            flag26 = false;
        if(parcel.readInt() != 0)
            flag27 = true;
        else
            flag27 = false;
        setDebugApp(s10, flag26, flag27);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L38:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag25;
        if(parcel.readInt() != 0)
            flag25 = true;
        else
            flag25 = false;
        setAlwaysFinish(flag25);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L52:
        parcel.enforceInterface("android.app.IActivityManager");
        setActivityController(IActivityController.Stub.asInterface(parcel.readStrongBinder()));
        flag = true;
        continue; /* Loop/switch isn't completed */
_L61:
        parcel.enforceInterface("android.app.IActivityManager");
        enterSafeMode();
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L63:
        parcel.enforceInterface("android.app.IActivityManager");
        noteWakeupAlarm(android.content.IIntentSender.Stub.asInterface(parcel.readStrongBinder()));
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L75:
        parcel.enforceInterface("android.app.IActivityManager");
        int ai[] = parcel.createIntArray();
        String s9 = parcel.readString();
        boolean flag23;
        boolean flag24;
        int k8;
        if(parcel.readInt() != 0)
            flag23 = true;
        else
            flag23 = false;
        flag24 = killPids(ai, s9, flag23);
        parcel1.writeNoException();
        if(flag24)
            k8 = 1;
        else
            k8 = 0;
        parcel1.writeInt(k8);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L138:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag22 = killProcessesBelowForeground(parcel.readString());
        parcel1.writeNoException();
        int j8;
        if(flag22)
            j8 = 1;
        else
            j8 = 0;
        parcel1.writeInt(j8);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L2:
        parcel.enforceInterface("android.app.IActivityManager");
        startRunning(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L3:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder10 = parcel.readStrongBinder();
        ApplicationErrorReport.CrashInfo crashinfo1 = new ApplicationErrorReport.CrashInfo(parcel);
        handleApplicationCrash(ibinder10, crashinfo1);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L96:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder9 = parcel.readStrongBinder();
        String s8 = parcel.readString();
        ApplicationErrorReport.CrashInfo crashinfo = new ApplicationErrorReport.CrashInfo(parcel);
        boolean flag21 = handleApplicationWtf(ibinder9, s8, crashinfo);
        parcel1.writeNoException();
        int i8;
        if(flag21)
            i8 = 1;
        else
            i8 = 0;
        parcel1.writeInt(i8);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L104:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder8 = parcel.readStrongBinder();
        int l7 = parcel.readInt();
        android.os.StrictMode.ViolationInfo violationinfo = new android.os.StrictMode.ViolationInfo(parcel);
        handleApplicationStrictModeViolation(ibinder8, l7, violationinfo);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L54:
        parcel.enforceInterface("android.app.IActivityManager");
        signalPersistentProcesses(parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L97:
        parcel.enforceInterface("android.app.IActivityManager");
        killBackgroundProcesses(parcel.readString());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L134:
        parcel.enforceInterface("android.app.IActivityManager");
        killAllBackgroundProcesses();
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L74:
        parcel.enforceInterface("android.app.IActivityManager");
        forceStopPackage(parcel.readString());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L137:
        parcel.enforceInterface("android.app.IActivityManager");
        ActivityManager.RunningAppProcessInfo runningappprocessinfo = new ActivityManager.RunningAppProcessInfo();
        getMyMemoryState(runningappprocessinfo);
        parcel1.writeNoException();
        runningappprocessinfo.writeToParcel(parcel1, 0);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L79:
        parcel.enforceInterface("android.app.IActivityManager");
        ConfigurationInfo configurationinfo = getDeviceConfigurationInfo();
        parcel1.writeNoException();
        configurationinfo.writeToParcel(parcel1, 0);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L81:
        parcel.enforceInterface("android.app.IActivityManager");
        String s6 = parcel.readString();
        boolean flag19;
        int j7;
        String s7;
        ParcelFileDescriptor parcelfiledescriptor1;
        boolean flag20;
        int k7;
        if(parcel.readInt() != 0)
            flag19 = true;
        else
            flag19 = false;
        j7 = parcel.readInt();
        s7 = parcel.readString();
        if(parcel.readInt() != 0)
            parcelfiledescriptor1 = parcel.readFileDescriptor();
        else
            parcelfiledescriptor1 = null;
        flag20 = profileControl(s6, flag19, s7, parcelfiledescriptor1, j7);
        parcel1.writeNoException();
        if(flag20)
            k7 = 1;
        else
            k7 = 0;
        parcel1.writeInt(k7);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L82:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag18 = shutdown(parcel.readInt());
        parcel1.writeNoException();
        int i7;
        if(flag18)
            i7 = 1;
        else
            i7 = 0;
        parcel1.writeInt(i7);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L83:
        parcel.enforceInterface("android.app.IActivityManager");
        stopAppSwitches();
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L84:
        parcel.enforceInterface("android.app.IActivityManager");
        resumeAppSwitches();
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L80:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder7 = peekService((Intent)Intent.CREATOR.createFromParcel(parcel), parcel.readString());
        parcel1.writeNoException();
        parcel1.writeStrongBinder(ibinder7);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L85:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag17 = bindBackupAgent((ApplicationInfo)ApplicationInfo.CREATOR.createFromParcel(parcel), parcel.readInt());
        parcel1.writeNoException();
        int l6;
        if(flag17)
            l6 = 1;
        else
            l6 = 0;
        parcel1.writeInt(l6);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L86:
        parcel.enforceInterface("android.app.IActivityManager");
        backupAgentCreated(parcel.readString(), parcel.readStrongBinder());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L87:
        parcel.enforceInterface("android.app.IActivityManager");
        unbindBackupAgent((ApplicationInfo)ApplicationInfo.CREATOR.createFromParcel(parcel));
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L89:
        parcel.enforceInterface("android.app.IActivityManager");
        int l5 = parcel.readInt();
        Intent intent2 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        String s4 = parcel.readString();
        IBinder ibinder6 = parcel.readStrongBinder();
        String s5 = parcel.readString();
        int i6 = parcel.readInt();
        int j6 = parcel.readInt();
        Bundle bundle2;
        int k6;
        if(parcel.readInt() != 0)
            bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        else
            bundle2 = null;
        k6 = startActivityInPackage(l5, intent2, s4, ibinder6, s5, i6, j6, bundle2);
        parcel1.writeNoException();
        parcel1.writeInt(k6);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L90:
        parcel.enforceInterface("android.app.IActivityManager");
        killApplicationWithUid(parcel.readString(), parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L91:
        parcel.enforceInterface("android.app.IActivityManager");
        closeSystemDialogs(parcel.readString());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L92:
        parcel.enforceInterface("android.app.IActivityManager");
        android.os.Debug.MemoryInfo amemoryinfo[] = getProcessMemoryInfo(parcel.createIntArray());
        parcel1.writeNoException();
        parcel1.writeTypedArray(amemoryinfo, 1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L93:
        parcel.enforceInterface("android.app.IActivityManager");
        killApplicationProcess(parcel.readString(), parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L95:
        parcel.enforceInterface("android.app.IActivityManager");
        overridePendingTransition(parcel.readStrongBinder(), parcel.readString(), parcel.readInt(), parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L98:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag16 = isUserAMonkey();
        parcel1.writeNoException();
        int k5;
        if(flag16)
            k5 = 1;
        else
            k5 = 0;
        parcel1.writeInt(k5);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L103:
        parcel.enforceInterface("android.app.IActivityManager");
        finishHeavyWeightApp();
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L105:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag15 = isImmersive(parcel.readStrongBinder());
        parcel1.writeNoException();
        int j5;
        if(flag15)
            j5 = 1;
        else
            j5 = 0;
        parcel1.writeInt(j5);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L106:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder5 = parcel.readStrongBinder();
        boolean flag14;
        if(parcel.readInt() == 1)
            flag14 = true;
        else
            flag14 = false;
        setImmersive(ibinder5, flag14);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L107:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag13 = isTopActivityImmersive();
        parcel1.writeNoException();
        int i5;
        if(flag13)
            i5 = 1;
        else
            i5 = 0;
        parcel1.writeInt(i5);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L108:
        parcel.enforceInterface("android.app.IActivityManager");
        crashApplication(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L109:
        parcel.enforceInterface("android.app.IActivityManager");
        String s3 = getProviderMimeType((Uri)Uri.CREATOR.createFromParcel(parcel));
        parcel1.writeNoException();
        parcel1.writeString(s3);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L110:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder4 = newUriPermissionOwner(parcel.readString());
        parcel1.writeNoException();
        parcel1.writeStrongBinder(ibinder4);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L111:
        parcel.enforceInterface("android.app.IActivityManager");
        grantUriPermissionFromOwner(parcel.readStrongBinder(), parcel.readInt(), parcel.readString(), (Uri)Uri.CREATOR.createFromParcel(parcel), parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L112:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder3 = parcel.readStrongBinder();
        if(parcel.readInt() != 0)
            Uri.CREATOR.createFromParcel(parcel);
        revokeUriPermissionFromOwner(ibinder3, null, parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L113:
        parcel.enforceInterface("android.app.IActivityManager");
        int l4 = checkGrantUriPermission(parcel.readInt(), parcel.readString(), (Uri)Uri.CREATOR.createFromParcel(parcel), parcel.readInt());
        parcel1.writeNoException();
        parcel1.writeInt(l4);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L114:
        parcel.enforceInterface("android.app.IActivityManager");
        String s1 = parcel.readString();
        boolean flag11;
        String s2;
        ParcelFileDescriptor parcelfiledescriptor;
        boolean flag12;
        int k4;
        if(parcel.readInt() != 0)
            flag11 = true;
        else
            flag11 = false;
        s2 = parcel.readString();
        if(parcel.readInt() != 0)
            parcelfiledescriptor = parcel.readFileDescriptor();
        else
            parcelfiledescriptor = null;
        flag12 = dumpHeap(s1, flag11, s2, parcelfiledescriptor);
        parcel1.writeNoException();
        if(flag12)
            k4 = 1;
        else
            k4 = 0;
        parcel1.writeInt(k4);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L116:
        parcel.enforceInterface("android.app.IActivityManager");
        int i4 = parcel.readInt();
        Intent aintent1[] = (Intent[])parcel.createTypedArray(Intent.CREATOR);
        String as1[] = parcel.createStringArray();
        IBinder ibinder2 = parcel.readStrongBinder();
        Bundle bundle1;
        int j4;
        if(parcel.readInt() != 0)
            bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        else
            bundle1 = null;
        j4 = startActivitiesInPackage(i4, aintent1, as1, ibinder2, bundle1);
        parcel1.writeNoException();
        parcel1.writeInt(j4);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L115:
        parcel.enforceInterface("android.app.IActivityManager");
        IApplicationThread iapplicationthread = ApplicationThreadNative.asInterface(parcel.readStrongBinder());
        Intent aintent[] = (Intent[])parcel.createTypedArray(Intent.CREATOR);
        String as[] = parcel.createStringArray();
        IBinder ibinder1 = parcel.readStrongBinder();
        Bundle bundle;
        int l3;
        if(parcel.readInt() != 0)
            bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        else
            bundle = null;
        l3 = startActivities(iapplicationthread, aintent, as, ibinder1, bundle);
        parcel1.writeNoException();
        parcel1.writeInt(l3);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L118:
        parcel.enforceInterface("android.app.IActivityManager");
        int k3 = getFrontActivityScreenCompatMode();
        parcel1.writeNoException();
        parcel1.writeInt(k3);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L119:
        parcel.enforceInterface("android.app.IActivityManager");
        int j3 = parcel.readInt();
        setFrontActivityScreenCompatMode(j3);
        parcel1.writeNoException();
        parcel1.writeInt(j3);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L120:
        parcel.enforceInterface("android.app.IActivityManager");
        int i3 = getPackageScreenCompatMode(parcel.readString());
        parcel1.writeNoException();
        parcel1.writeInt(i3);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L121:
        parcel.enforceInterface("android.app.IActivityManager");
        setPackageScreenCompatMode(parcel.readString(), parcel.readInt());
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L124:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag10 = switchUser(parcel.readInt());
        parcel1.writeNoException();
        int l2;
        if(flag10)
            l2 = 1;
        else
            l2 = 0;
        parcel1.writeInt(l2);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L139:
        parcel.enforceInterface("android.app.IActivityManager");
        UserInfo userinfo = getCurrentUser();
        parcel1.writeNoException();
        userinfo.writeToParcel(parcel1, 0);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L125:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag9 = removeSubTask(parcel.readInt(), parcel.readInt());
        parcel1.writeNoException();
        int k2;
        if(flag9)
            k2 = 1;
        else
            k2 = 0;
        parcel1.writeInt(k2);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L126:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag8 = removeTask(parcel.readInt(), parcel.readInt());
        parcel1.writeNoException();
        int j2;
        if(flag8)
            j2 = 1;
        else
            j2 = 0;
        parcel1.writeInt(j2);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L127:
        parcel.enforceInterface("android.app.IActivityManager");
        registerProcessObserver(IProcessObserver.Stub.asInterface(parcel.readStrongBinder()));
        flag = true;
        continue; /* Loop/switch isn't completed */
_L128:
        parcel.enforceInterface("android.app.IActivityManager");
        unregisterProcessObserver(IProcessObserver.Stub.asInterface(parcel.readStrongBinder()));
        flag = true;
        continue; /* Loop/switch isn't completed */
_L122:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag7 = getPackageAskScreenCompat(parcel.readString());
        parcel1.writeNoException();
        int i2;
        if(flag7)
            i2 = 1;
        else
            i2 = 0;
        parcel1.writeInt(i2);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L123:
        parcel.enforceInterface("android.app.IActivityManager");
        String s = parcel.readString();
        boolean flag6;
        if(parcel.readInt() != 0)
            flag6 = true;
        else
            flag6 = false;
        setPackageAskScreenCompat(s, flag6);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L129:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag5 = isIntentSenderTargetedToPackage(android.content.IIntentSender.Stub.asInterface(parcel.readStrongBinder()));
        parcel1.writeNoException();
        int l1;
        if(flag5)
            l1 = 1;
        else
            l1 = 0;
        parcel1.writeInt(l1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L146:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag4 = isIntentSenderAnActivity(android.content.IIntentSender.Stub.asInterface(parcel.readStrongBinder()));
        parcel1.writeNoException();
        int k1;
        if(flag4)
            k1 = 1;
        else
            k1 = 0;
        parcel1.writeInt(k1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L130:
        parcel.enforceInterface("android.app.IActivityManager");
        updatePersistentConfiguration((Configuration)Configuration.CREATOR.createFromParcel(parcel));
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L131:
        parcel.enforceInterface("android.app.IActivityManager");
        long al[] = getProcessPss(parcel.createIntArray());
        parcel1.writeNoException();
        parcel1.writeLongArray(al);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L132:
        parcel.enforceInterface("android.app.IActivityManager");
        CharSequence charsequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        boolean flag3;
        if(parcel.readInt() != 0)
            flag3 = true;
        else
            flag3 = false;
        showBootMessage(charsequence, flag3);
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L133:
        parcel.enforceInterface("android.app.IActivityManager");
        dismissKeyguardOnNextActivity();
        parcel1.writeNoException();
        flag = true;
        continue; /* Loop/switch isn't completed */
_L140:
        parcel.enforceInterface("android.app.IActivityManager");
        boolean flag2 = targetTaskAffinityMatchesActivity(parcel.readStrongBinder(), parcel.readString());
        parcel1.writeNoException();
        int j1;
        if(flag2)
            j1 = 1;
        else
            j1 = 0;
        parcel1.writeInt(j1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L141:
        parcel.enforceInterface("android.app.IActivityManager");
        IBinder ibinder = parcel.readStrongBinder();
        Intent intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
        int l = parcel.readInt();
        Intent intent1 = null;
        if(parcel.readInt() != 0)
            intent1 = (Intent)Intent.CREATOR.createFromParcel(parcel);
        boolean flag1 = navigateUpTo(ibinder, intent, l, intent1);
        parcel1.writeNoException();
        int i1;
        if(flag1)
            i1 = 1;
        else
            i1 = 0;
        parcel1.writeInt(i1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L144:
        parcel.enforceInterface("android.app.IActivityManager");
        int k = getLaunchedFromUid(parcel.readStrongBinder());
        parcel1.writeNoException();
        parcel1.writeInt(k);
        flag = true;
        if(true) goto _L148; else goto _L147
_L147:
    }

    private static final Singleton gDefault = new Singleton() {

        protected IActivityManager create() {
            return ActivityManagerNative.asInterface(ServiceManager.getService("activity"));
        }

        protected volatile Object create() {
            return create();
        }

    };
    static boolean sSystemReady = false;

}
