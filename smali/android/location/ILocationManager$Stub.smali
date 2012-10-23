.class public abstract Landroid/location/ILocationManager$Stub;
.super Landroid/os/Binder;
.source "ILocationManager.java"

# interfaces
.implements Landroid/location/ILocationManager;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/location/ILocationManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/location/ILocationManager$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.location.ILocationManager"

.field static final TRANSACTION_addGpsStatusListener:I = 0x9

.field static final TRANSACTION_addProximityAlert:I = 0xd

.field static final TRANSACTION_addTestProvider:I = 0x16

.field static final TRANSACTION_clearTestProviderEnabled:I = 0x1b

.field static final TRANSACTION_clearTestProviderLocation:I = 0x19

.field static final TRANSACTION_clearTestProviderStatus:I = 0x1d

.field static final TRANSACTION_geocoderIsPresent:I = 0x13

.field static final TRANSACTION_getAllProviders:I = 0x1

.field static final TRANSACTION_getBestProvider:I = 0x3

.field static final TRANSACTION_getFromLocation:I = 0x14

.field static final TRANSACTION_getFromLocationName:I = 0x15

.field static final TRANSACTION_getLastKnownLocation:I = 0x11

.field static final TRANSACTION_getProviderInfo:I = 0xf

.field static final TRANSACTION_getProviders:I = 0x2

.field static final TRANSACTION_isProviderEnabled:I = 0x10

.field static final TRANSACTION_locationCallbackFinished:I = 0xb

.field static final TRANSACTION_providerMeetsCriteria:I = 0x4

.field static final TRANSACTION_removeGpsStatusListener:I = 0xa

.field static final TRANSACTION_removeProximityAlert:I = 0xe

.field static final TRANSACTION_removeTestProvider:I = 0x17

.field static final TRANSACTION_removeUpdates:I = 0x7

.field static final TRANSACTION_removeUpdatesPI:I = 0x8

.field static final TRANSACTION_reportLocation:I = 0x12

.field static final TRANSACTION_requestLocationUpdates:I = 0x5

.field static final TRANSACTION_requestLocationUpdatesPI:I = 0x6

.field static final TRANSACTION_sendExtraCommand:I = 0xc

.field static final TRANSACTION_sendNiResponse:I = 0x1e

.field static final TRANSACTION_setTestProviderEnabled:I = 0x1a

.field static final TRANSACTION_setTestProviderLocation:I = 0x18

.field static final TRANSACTION_setTestProviderStatus:I = 0x1c


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 20
    const-string v0, "android.location.ILocationManager"

    invoke-virtual {p0, p0, v0}, Landroid/location/ILocationManager$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 21
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/location/ILocationManager;
    .registers 3
    .parameter "obj"

    .prologue
    .line 28
    if-nez p0, :cond_4

    .line 29
    const/4 v0, 0x0

    .line 35
    :goto_3
    return-object v0

    .line 31
    :cond_4
    const-string v1, "android.location.ILocationManager"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 32
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/location/ILocationManager;

    if-eqz v1, :cond_13

    .line 33
    check-cast v0, Landroid/location/ILocationManager;

    goto :goto_3

    .line 35
    :cond_13
    new-instance v0, Landroid/location/ILocationManager$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/location/ILocationManager$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 39
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 57
    .parameter "code"
    .parameter "data"
    .parameter "reply"
    .parameter "flags"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 43
    sparse-switch p1, :sswitch_data_566

    .line 518
    invoke-super/range {p0 .. p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v2

    :goto_7
    return v2

    .line 47
    :sswitch_8
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 48
    const/4 v2, 0x1

    goto :goto_7

    .line 52
    :sswitch_11
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 53
    invoke-virtual/range {p0 .. p0}, Landroid/location/ILocationManager$Stub;->getAllProviders()Ljava/util/List;

    move-result-object v51

    .line 54
    .local v51, _result:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 55
    move-object/from16 v0, p3

    move-object/from16 v1, v51

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeStringList(Ljava/util/List;)V

    .line 56
    const/4 v2, 0x1

    goto :goto_7

    .line 60
    .end local v51           #_result:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    :sswitch_28
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 62
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_58

    .line 63
    sget-object v2, Landroid/location/Criteria;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/location/Criteria;

    .line 69
    .local v3, _arg0:Landroid/location/Criteria;
    :goto_3f
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_5a

    const/4 v4, 0x1

    .line 70
    .local v4, _arg1:Z
    :goto_46
    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v4}, Landroid/location/ILocationManager$Stub;->getProviders(Landroid/location/Criteria;Z)Ljava/util/List;

    move-result-object v51

    .line 71
    .restart local v51       #_result:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 72
    move-object/from16 v0, p3

    move-object/from16 v1, v51

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeStringList(Ljava/util/List;)V

    .line 73
    const/4 v2, 0x1

    goto :goto_7

    .line 66
    .end local v3           #_arg0:Landroid/location/Criteria;
    .end local v4           #_arg1:Z
    .end local v51           #_result:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    :cond_58
    const/4 v3, 0x0

    .restart local v3       #_arg0:Landroid/location/Criteria;
    goto :goto_3f

    .line 69
    :cond_5a
    const/4 v4, 0x0

    goto :goto_46

    .line 77
    .end local v3           #_arg0:Landroid/location/Criteria;
    :sswitch_5c
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 79
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_8d

    .line 80
    sget-object v2, Landroid/location/Criteria;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/location/Criteria;

    .line 86
    .restart local v3       #_arg0:Landroid/location/Criteria;
    :goto_73
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_8f

    const/4 v4, 0x1

    .line 87
    .restart local v4       #_arg1:Z
    :goto_7a
    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v4}, Landroid/location/ILocationManager$Stub;->getBestProvider(Landroid/location/Criteria;Z)Ljava/lang/String;

    move-result-object v50

    .line 88
    .local v50, _result:Ljava/lang/String;
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 89
    move-object/from16 v0, p3

    move-object/from16 v1, v50

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 90
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 83
    .end local v3           #_arg0:Landroid/location/Criteria;
    .end local v4           #_arg1:Z
    .end local v50           #_result:Ljava/lang/String;
    :cond_8d
    const/4 v3, 0x0

    .restart local v3       #_arg0:Landroid/location/Criteria;
    goto :goto_73

    .line 86
    :cond_8f
    const/4 v4, 0x0

    goto :goto_7a

    .line 94
    .end local v3           #_arg0:Landroid/location/Criteria;
    :sswitch_91
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 96
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 98
    .local v3, _arg0:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_c0

    .line 99
    sget-object v2, Landroid/location/Criteria;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/location/Criteria;

    .line 104
    .local v4, _arg1:Landroid/location/Criteria;
    :goto_ac
    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v4}, Landroid/location/ILocationManager$Stub;->providerMeetsCriteria(Ljava/lang/String;Landroid/location/Criteria;)Z

    move-result v50

    .line 105
    .local v50, _result:Z
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 106
    if-eqz v50, :cond_c2

    const/4 v2, 0x1

    :goto_b8
    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 107
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 102
    .end local v4           #_arg1:Landroid/location/Criteria;
    .end local v50           #_result:Z
    :cond_c0
    const/4 v4, 0x0

    .restart local v4       #_arg1:Landroid/location/Criteria;
    goto :goto_ac

    .line 106
    .restart local v50       #_result:Z
    :cond_c2
    const/4 v2, 0x0

    goto :goto_b8

    .line 111
    .end local v3           #_arg0:Ljava/lang/String;
    .end local v4           #_arg1:Landroid/location/Criteria;
    .end local v50           #_result:Z
    :sswitch_c4
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 113
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 115
    .restart local v3       #_arg0:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_101

    .line 116
    sget-object v2, Landroid/location/Criteria;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/location/Criteria;

    .line 122
    .restart local v4       #_arg1:Landroid/location/Criteria;
    :goto_df
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v5

    .line 124
    .local v5, _arg2:J
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFloat()F

    move-result v7

    .line 126
    .local v7, _arg3:F
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_103

    const/4 v8, 0x1

    .line 128
    .local v8, _arg4:Z
    :goto_ee
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v2

    invoke-static {v2}, Landroid/location/ILocationListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/location/ILocationListener;

    move-result-object v9

    .local v9, _arg5:Landroid/location/ILocationListener;
    move-object/from16 v2, p0

    .line 129
    invoke-virtual/range {v2 .. v9}, Landroid/location/ILocationManager$Stub;->requestLocationUpdates(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/location/ILocationListener;)V

    .line 130
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 131
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 119
    .end local v4           #_arg1:Landroid/location/Criteria;
    .end local v5           #_arg2:J
    .end local v7           #_arg3:F
    .end local v8           #_arg4:Z
    .end local v9           #_arg5:Landroid/location/ILocationListener;
    :cond_101
    const/4 v4, 0x0

    .restart local v4       #_arg1:Landroid/location/Criteria;
    goto :goto_df

    .line 126
    .restart local v5       #_arg2:J
    .restart local v7       #_arg3:F
    :cond_103
    const/4 v8, 0x0

    goto :goto_ee

    .line 135
    .end local v3           #_arg0:Ljava/lang/String;
    .end local v4           #_arg1:Landroid/location/Criteria;
    .end local v5           #_arg2:J
    .end local v7           #_arg3:F
    :sswitch_105
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 137
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 139
    .restart local v3       #_arg0:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_14a

    .line 140
    sget-object v2, Landroid/location/Criteria;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/location/Criteria;

    .line 146
    .restart local v4       #_arg1:Landroid/location/Criteria;
    :goto_120
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v5

    .line 148
    .restart local v5       #_arg2:J
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFloat()F

    move-result v7

    .line 150
    .restart local v7       #_arg3:F
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_14c

    const/4 v8, 0x1

    .line 152
    .restart local v8       #_arg4:Z
    :goto_12f
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_14e

    .line 153
    sget-object v2, Landroid/app/PendingIntent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/app/PendingIntent;

    .local v9, _arg5:Landroid/app/PendingIntent;
    :goto_13f
    move-object/from16 v2, p0

    .line 158
    invoke-virtual/range {v2 .. v9}, Landroid/location/ILocationManager$Stub;->requestLocationUpdatesPI(Ljava/lang/String;Landroid/location/Criteria;JFZLandroid/app/PendingIntent;)V

    .line 159
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 160
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 143
    .end local v4           #_arg1:Landroid/location/Criteria;
    .end local v5           #_arg2:J
    .end local v7           #_arg3:F
    .end local v8           #_arg4:Z
    .end local v9           #_arg5:Landroid/app/PendingIntent;
    :cond_14a
    const/4 v4, 0x0

    .restart local v4       #_arg1:Landroid/location/Criteria;
    goto :goto_120

    .line 150
    .restart local v5       #_arg2:J
    .restart local v7       #_arg3:F
    :cond_14c
    const/4 v8, 0x0

    goto :goto_12f

    .line 156
    .restart local v8       #_arg4:Z
    :cond_14e
    const/4 v9, 0x0

    .restart local v9       #_arg5:Landroid/app/PendingIntent;
    goto :goto_13f

    .line 164
    .end local v3           #_arg0:Ljava/lang/String;
    .end local v4           #_arg1:Landroid/location/Criteria;
    .end local v5           #_arg2:J
    .end local v7           #_arg3:F
    .end local v8           #_arg4:Z
    .end local v9           #_arg5:Landroid/app/PendingIntent;
    :sswitch_150
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 166
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v2

    invoke-static {v2}, Landroid/location/ILocationListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/location/ILocationListener;

    move-result-object v3

    .line 167
    .local v3, _arg0:Landroid/location/ILocationListener;
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->removeUpdates(Landroid/location/ILocationListener;)V

    .line 168
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 169
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 173
    .end local v3           #_arg0:Landroid/location/ILocationListener;
    :sswitch_16a
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 175
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_18c

    .line 176
    sget-object v2, Landroid/app/PendingIntent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/app/PendingIntent;

    .line 181
    .local v3, _arg0:Landroid/app/PendingIntent;
    :goto_181
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->removeUpdatesPI(Landroid/app/PendingIntent;)V

    .line 182
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 183
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 179
    .end local v3           #_arg0:Landroid/app/PendingIntent;
    :cond_18c
    const/4 v3, 0x0

    .restart local v3       #_arg0:Landroid/app/PendingIntent;
    goto :goto_181

    .line 187
    .end local v3           #_arg0:Landroid/app/PendingIntent;
    :sswitch_18e
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 189
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v2

    invoke-static {v2}, Landroid/location/IGpsStatusListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/location/IGpsStatusListener;

    move-result-object v3

    .line 190
    .local v3, _arg0:Landroid/location/IGpsStatusListener;
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->addGpsStatusListener(Landroid/location/IGpsStatusListener;)Z

    move-result v50

    .line 191
    .restart local v50       #_result:Z
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 192
    if-eqz v50, :cond_1b1

    const/4 v2, 0x1

    :goto_1a9
    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 193
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 192
    :cond_1b1
    const/4 v2, 0x0

    goto :goto_1a9

    .line 197
    .end local v3           #_arg0:Landroid/location/IGpsStatusListener;
    .end local v50           #_result:Z
    :sswitch_1b3
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 199
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v2

    invoke-static {v2}, Landroid/location/IGpsStatusListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/location/IGpsStatusListener;

    move-result-object v3

    .line 200
    .restart local v3       #_arg0:Landroid/location/IGpsStatusListener;
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->removeGpsStatusListener(Landroid/location/IGpsStatusListener;)V

    .line 201
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 202
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 206
    .end local v3           #_arg0:Landroid/location/IGpsStatusListener;
    :sswitch_1cd
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 208
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v2

    invoke-static {v2}, Landroid/location/ILocationListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/location/ILocationListener;

    move-result-object v3

    .line 209
    .local v3, _arg0:Landroid/location/ILocationListener;
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->locationCallbackFinished(Landroid/location/ILocationListener;)V

    .line 210
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 211
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 215
    .end local v3           #_arg0:Landroid/location/ILocationListener;
    :sswitch_1e7
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 217
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 219
    .local v3, _arg0:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    .line 221
    .local v4, _arg1:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_228

    .line 222
    sget-object v2, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/os/Bundle;

    .line 227
    .local v5, _arg2:Landroid/os/Bundle;
    :goto_206
    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v4, v5}, Landroid/location/ILocationManager$Stub;->sendExtraCommand(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Z

    move-result v50

    .line 228
    .restart local v50       #_result:Z
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 229
    if-eqz v50, :cond_22a

    const/4 v2, 0x1

    :goto_212
    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 230
    if-eqz v5, :cond_22c

    .line 231
    const/4 v2, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 232
    const/4 v2, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v5, v0, v2}, Landroid/os/Bundle;->writeToParcel(Landroid/os/Parcel;I)V

    .line 237
    :goto_225
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 225
    .end local v5           #_arg2:Landroid/os/Bundle;
    .end local v50           #_result:Z
    :cond_228
    const/4 v5, 0x0

    .restart local v5       #_arg2:Landroid/os/Bundle;
    goto :goto_206

    .line 229
    .restart local v50       #_result:Z
    :cond_22a
    const/4 v2, 0x0

    goto :goto_212

    .line 235
    :cond_22c
    const/4 v2, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_225

    .line 241
    .end local v3           #_arg0:Ljava/lang/String;
    .end local v4           #_arg1:Ljava/lang/String;
    .end local v5           #_arg2:Landroid/os/Bundle;
    .end local v50           #_result:Z
    :sswitch_233
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 243
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v11

    .line 245
    .local v11, _arg0:D
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v13

    .line 247
    .local v13, _arg1:D
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFloat()F

    move-result v5

    .line 249
    .local v5, _arg2:F
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v16

    .line 251
    .local v16, _arg3:J
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_268

    .line 252
    sget-object v2, Landroid/app/PendingIntent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/app/PendingIntent;

    .local v8, _arg4:Landroid/app/PendingIntent;
    :goto_25a
    move-object/from16 v10, p0

    move v15, v5

    move-object/from16 v18, v8

    .line 257
    invoke-virtual/range {v10 .. v18}, Landroid/location/ILocationManager$Stub;->addProximityAlert(DDFJLandroid/app/PendingIntent;)V

    .line 258
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 259
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 255
    .end local v8           #_arg4:Landroid/app/PendingIntent;
    :cond_268
    const/4 v8, 0x0

    .restart local v8       #_arg4:Landroid/app/PendingIntent;
    goto :goto_25a

    .line 263
    .end local v5           #_arg2:F
    .end local v8           #_arg4:Landroid/app/PendingIntent;
    .end local v11           #_arg0:D
    .end local v13           #_arg1:D
    .end local v16           #_arg3:J
    :sswitch_26a
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 265
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_28c

    .line 266
    sget-object v2, Landroid/app/PendingIntent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/app/PendingIntent;

    .line 271
    .local v3, _arg0:Landroid/app/PendingIntent;
    :goto_281
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->removeProximityAlert(Landroid/app/PendingIntent;)V

    .line 272
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 273
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 269
    .end local v3           #_arg0:Landroid/app/PendingIntent;
    :cond_28c
    const/4 v3, 0x0

    .restart local v3       #_arg0:Landroid/app/PendingIntent;
    goto :goto_281

    .line 277
    .end local v3           #_arg0:Landroid/app/PendingIntent;
    :sswitch_28e
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 279
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 280
    .local v3, _arg0:Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->getProviderInfo(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v50

    .line 281
    .local v50, _result:Landroid/os/Bundle;
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 282
    if-eqz v50, :cond_2b5

    .line 283
    const/4 v2, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 284
    const/4 v2, 0x1

    move-object/from16 v0, v50

    move-object/from16 v1, p3

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->writeToParcel(Landroid/os/Parcel;I)V

    .line 289
    :goto_2b2
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 287
    :cond_2b5
    const/4 v2, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_2b2

    .line 293
    .end local v3           #_arg0:Ljava/lang/String;
    .end local v50           #_result:Landroid/os/Bundle;
    :sswitch_2bc
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 295
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 296
    .restart local v3       #_arg0:Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v50

    .line 297
    .local v50, _result:Z
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 298
    if-eqz v50, :cond_2db

    const/4 v2, 0x1

    :goto_2d3
    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 299
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 298
    :cond_2db
    const/4 v2, 0x0

    goto :goto_2d3

    .line 303
    .end local v3           #_arg0:Ljava/lang/String;
    .end local v50           #_result:Z
    :sswitch_2dd
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 305
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 306
    .restart local v3       #_arg0:Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v50

    .line 307
    .local v50, _result:Landroid/location/Location;
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 308
    if-eqz v50, :cond_304

    .line 309
    const/4 v2, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 310
    const/4 v2, 0x1

    move-object/from16 v0, v50

    move-object/from16 v1, p3

    invoke-virtual {v0, v1, v2}, Landroid/location/Location;->writeToParcel(Landroid/os/Parcel;I)V

    .line 315
    :goto_301
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 313
    :cond_304
    const/4 v2, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_301

    .line 319
    .end local v3           #_arg0:Ljava/lang/String;
    .end local v50           #_result:Landroid/location/Location;
    :sswitch_30b
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 321
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_334

    .line 322
    sget-object v2, Landroid/location/Location;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/location/Location;

    .line 328
    .local v3, _arg0:Landroid/location/Location;
    :goto_322
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_336

    const/4 v4, 0x1

    .line 329
    .local v4, _arg1:Z
    :goto_329
    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v4}, Landroid/location/ILocationManager$Stub;->reportLocation(Landroid/location/Location;Z)V

    .line 330
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 331
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 325
    .end local v3           #_arg0:Landroid/location/Location;
    .end local v4           #_arg1:Z
    :cond_334
    const/4 v3, 0x0

    .restart local v3       #_arg0:Landroid/location/Location;
    goto :goto_322

    .line 328
    :cond_336
    const/4 v4, 0x0

    goto :goto_329

    .line 335
    .end local v3           #_arg0:Landroid/location/Location;
    :sswitch_338
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 336
    invoke-virtual/range {p0 .. p0}, Landroid/location/ILocationManager$Stub;->geocoderIsPresent()Z

    move-result v50

    .line 337
    .local v50, _result:Z
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 338
    if-eqz v50, :cond_351

    const/4 v2, 0x1

    :goto_349
    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 339
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 338
    :cond_351
    const/4 v2, 0x0

    goto :goto_349

    .line 343
    .end local v50           #_result:Z
    :sswitch_353
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 345
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v11

    .line 347
    .restart local v11       #_arg0:D
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v13

    .line 349
    .restart local v13       #_arg1:D
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    .line 351
    .local v5, _arg2:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_39d

    .line 352
    sget-object v2, Landroid/location/GeocoderParams;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/location/GeocoderParams;

    .line 358
    .local v7, _arg3:Landroid/location/GeocoderParams;
    :goto_376
    new-instance v25, Ljava/util/ArrayList;

    invoke-direct/range {v25 .. v25}, Ljava/util/ArrayList;-><init>()V

    .local v25, _arg4:Ljava/util/List;,"Ljava/util/List<Landroid/location/Address;>;"
    move-object/from16 v18, p0

    move-wide/from16 v19, v11

    move-wide/from16 v21, v13

    move/from16 v23, v5

    move-object/from16 v24, v7

    .line 359
    invoke-virtual/range {v18 .. v25}, Landroid/location/ILocationManager$Stub;->getFromLocation(DDILandroid/location/GeocoderParams;Ljava/util/List;)Ljava/lang/String;

    move-result-object v50

    .line 360
    .local v50, _result:Ljava/lang/String;
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 361
    move-object/from16 v0, p3

    move-object/from16 v1, v50

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 362
    move-object/from16 v0, p3

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeTypedList(Ljava/util/List;)V

    .line 363
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 355
    .end local v7           #_arg3:Landroid/location/GeocoderParams;
    .end local v25           #_arg4:Ljava/util/List;,"Ljava/util/List<Landroid/location/Address;>;"
    .end local v50           #_result:Ljava/lang/String;
    :cond_39d
    const/4 v7, 0x0

    .restart local v7       #_arg3:Landroid/location/GeocoderParams;
    goto :goto_376

    .line 367
    .end local v5           #_arg2:I
    .end local v7           #_arg3:Landroid/location/GeocoderParams;
    .end local v11           #_arg0:D
    .end local v13           #_arg1:D
    :sswitch_39f
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 369
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 371
    .local v3, _arg0:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v13

    .line 373
    .restart local v13       #_arg1:D
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v5

    .line 375
    .local v5, _arg2:D
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v16

    .line 377
    .local v16, _arg3:D
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v34

    .line 379
    .local v34, _arg4:D
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v9

    .line 381
    .local v9, _arg5:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_3f7

    .line 382
    sget-object v2, Landroid/location/GeocoderParams;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v37

    check-cast v37, Landroid/location/GeocoderParams;

    .line 388
    .local v37, _arg6:Landroid/location/GeocoderParams;
    :goto_3ce
    new-instance v38, Ljava/util/ArrayList;

    invoke-direct/range {v38 .. v38}, Ljava/util/ArrayList;-><init>()V

    .local v38, _arg7:Ljava/util/List;,"Ljava/util/List<Landroid/location/Address;>;"
    move-object/from16 v26, p0

    move-object/from16 v27, v3

    move-wide/from16 v28, v13

    move-wide/from16 v30, v5

    move-wide/from16 v32, v16

    move/from16 v36, v9

    .line 389
    invoke-virtual/range {v26 .. v38}, Landroid/location/ILocationManager$Stub;->getFromLocationName(Ljava/lang/String;DDDDILandroid/location/GeocoderParams;Ljava/util/List;)Ljava/lang/String;

    move-result-object v50

    .line 390
    .restart local v50       #_result:Ljava/lang/String;
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 391
    move-object/from16 v0, p3

    move-object/from16 v1, v50

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 392
    move-object/from16 v0, p3

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeTypedList(Ljava/util/List;)V

    .line 393
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 385
    .end local v37           #_arg6:Landroid/location/GeocoderParams;
    .end local v38           #_arg7:Ljava/util/List;,"Ljava/util/List<Landroid/location/Address;>;"
    .end local v50           #_result:Ljava/lang/String;
    :cond_3f7
    const/16 v37, 0x0

    .restart local v37       #_arg6:Landroid/location/GeocoderParams;
    goto :goto_3ce

    .line 397
    .end local v3           #_arg0:Ljava/lang/String;
    .end local v5           #_arg2:D
    .end local v9           #_arg5:I
    .end local v13           #_arg1:D
    .end local v16           #_arg3:D
    .end local v34           #_arg4:D
    .end local v37           #_arg6:Landroid/location/GeocoderParams;
    :sswitch_3fa
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 399
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 401
    .restart local v3       #_arg0:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_459

    const/4 v4, 0x1

    .line 403
    .restart local v4       #_arg1:Z
    :goto_40c
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_45b

    const/4 v5, 0x1

    .line 405
    .local v5, _arg2:Z
    :goto_413
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_45d

    const/4 v7, 0x1

    .line 407
    .local v7, _arg3:Z
    :goto_41a
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_45f

    const/4 v8, 0x1

    .line 409
    .local v8, _arg4:Z
    :goto_421
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_461

    const/4 v9, 0x1

    .line 411
    .local v9, _arg5:Z
    :goto_428
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_463

    const/16 v37, 0x1

    .line 413
    .local v37, _arg6:Z
    :goto_430
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_466

    const/16 v47, 0x1

    .line 415
    .local v47, _arg7:Z
    :goto_438
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v48

    .line 417
    .local v48, _arg8:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v49

    .local v49, _arg9:I
    move-object/from16 v39, p0

    move-object/from16 v40, v3

    move/from16 v41, v4

    move/from16 v42, v5

    move/from16 v43, v7

    move/from16 v44, v8

    move/from16 v45, v9

    move/from16 v46, v37

    .line 418
    invoke-virtual/range {v39 .. v49}, Landroid/location/ILocationManager$Stub;->addTestProvider(Ljava/lang/String;ZZZZZZZII)V

    .line 419
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 420
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 401
    .end local v4           #_arg1:Z
    .end local v5           #_arg2:Z
    .end local v7           #_arg3:Z
    .end local v8           #_arg4:Z
    .end local v9           #_arg5:Z
    .end local v37           #_arg6:Z
    .end local v47           #_arg7:Z
    .end local v48           #_arg8:I
    .end local v49           #_arg9:I
    :cond_459
    const/4 v4, 0x0

    goto :goto_40c

    .line 403
    .restart local v4       #_arg1:Z
    :cond_45b
    const/4 v5, 0x0

    goto :goto_413

    .line 405
    .restart local v5       #_arg2:Z
    :cond_45d
    const/4 v7, 0x0

    goto :goto_41a

    .line 407
    .restart local v7       #_arg3:Z
    :cond_45f
    const/4 v8, 0x0

    goto :goto_421

    .line 409
    .restart local v8       #_arg4:Z
    :cond_461
    const/4 v9, 0x0

    goto :goto_428

    .line 411
    .restart local v9       #_arg5:Z
    :cond_463
    const/16 v37, 0x0

    goto :goto_430

    .line 413
    .restart local v37       #_arg6:Z
    :cond_466
    const/16 v47, 0x0

    goto :goto_438

    .line 424
    .end local v3           #_arg0:Ljava/lang/String;
    .end local v4           #_arg1:Z
    .end local v5           #_arg2:Z
    .end local v7           #_arg3:Z
    .end local v8           #_arg4:Z
    .end local v9           #_arg5:Z
    .end local v37           #_arg6:Z
    :sswitch_469
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 426
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 427
    .restart local v3       #_arg0:Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->removeTestProvider(Ljava/lang/String;)V

    .line 428
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 429
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 433
    .end local v3           #_arg0:Ljava/lang/String;
    :sswitch_47f
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 435
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 437
    .restart local v3       #_arg0:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_4a5

    .line 438
    sget-object v2, Landroid/location/Location;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/location/Location;

    .line 443
    .local v4, _arg1:Landroid/location/Location;
    :goto_49a
    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v4}, Landroid/location/ILocationManager$Stub;->setTestProviderLocation(Ljava/lang/String;Landroid/location/Location;)V

    .line 444
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 445
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 441
    .end local v4           #_arg1:Landroid/location/Location;
    :cond_4a5
    const/4 v4, 0x0

    .restart local v4       #_arg1:Landroid/location/Location;
    goto :goto_49a

    .line 449
    .end local v3           #_arg0:Ljava/lang/String;
    .end local v4           #_arg1:Landroid/location/Location;
    :sswitch_4a7
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 451
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 452
    .restart local v3       #_arg0:Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->clearTestProviderLocation(Ljava/lang/String;)V

    .line 453
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 454
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 458
    .end local v3           #_arg0:Ljava/lang/String;
    :sswitch_4bd
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 460
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 462
    .restart local v3       #_arg0:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_4da

    const/4 v4, 0x1

    .line 463
    .local v4, _arg1:Z
    :goto_4cf
    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v4}, Landroid/location/ILocationManager$Stub;->setTestProviderEnabled(Ljava/lang/String;Z)V

    .line 464
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 465
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 462
    .end local v4           #_arg1:Z
    :cond_4da
    const/4 v4, 0x0

    goto :goto_4cf

    .line 469
    .end local v3           #_arg0:Ljava/lang/String;
    :sswitch_4dc
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 471
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 472
    .restart local v3       #_arg0:Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->clearTestProviderEnabled(Ljava/lang/String;)V

    .line 473
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 474
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 478
    .end local v3           #_arg0:Ljava/lang/String;
    :sswitch_4f2
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 480
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 482
    .restart local v3       #_arg0:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    .line 484
    .local v4, _arg1:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_528

    .line 485
    sget-object v2, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v2, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/os/Bundle;

    .line 491
    .local v5, _arg2:Landroid/os/Bundle;
    :goto_511
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v16

    .local v16, _arg3:J
    move-object/from16 v18, p0

    move-object/from16 v19, v3

    move/from16 v20, v4

    move-object/from16 v21, v5

    move-wide/from16 v22, v16

    .line 492
    invoke-virtual/range {v18 .. v23}, Landroid/location/ILocationManager$Stub;->setTestProviderStatus(Ljava/lang/String;ILandroid/os/Bundle;J)V

    .line 493
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 494
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 488
    .end local v5           #_arg2:Landroid/os/Bundle;
    .end local v16           #_arg3:J
    :cond_528
    const/4 v5, 0x0

    .restart local v5       #_arg2:Landroid/os/Bundle;
    goto :goto_511

    .line 498
    .end local v3           #_arg0:Ljava/lang/String;
    .end local v4           #_arg1:I
    .end local v5           #_arg2:Landroid/os/Bundle;
    :sswitch_52a
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 500
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 501
    .restart local v3       #_arg0:Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/location/ILocationManager$Stub;->clearTestProviderStatus(Ljava/lang/String;)V

    .line 502
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 503
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 507
    .end local v3           #_arg0:Ljava/lang/String;
    :sswitch_540
    const-string v2, "android.location.ILocationManager"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 509
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 511
    .local v3, _arg0:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    .line 512
    .restart local v4       #_arg1:I
    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v4}, Landroid/location/ILocationManager$Stub;->sendNiResponse(II)Z

    move-result v50

    .line 513
    .local v50, _result:Z
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 514
    if-eqz v50, :cond_563

    const/4 v2, 0x1

    :goto_55b
    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 515
    const/4 v2, 0x1

    goto/16 :goto_7

    .line 514
    :cond_563
    const/4 v2, 0x0

    goto :goto_55b

    .line 43
    nop

    :sswitch_data_566
    .sparse-switch
        0x1 -> :sswitch_11
        0x2 -> :sswitch_28
        0x3 -> :sswitch_5c
        0x4 -> :sswitch_91
        0x5 -> :sswitch_c4
        0x6 -> :sswitch_105
        0x7 -> :sswitch_150
        0x8 -> :sswitch_16a
        0x9 -> :sswitch_18e
        0xa -> :sswitch_1b3
        0xb -> :sswitch_1cd
        0xc -> :sswitch_1e7
        0xd -> :sswitch_233
        0xe -> :sswitch_26a
        0xf -> :sswitch_28e
        0x10 -> :sswitch_2bc
        0x11 -> :sswitch_2dd
        0x12 -> :sswitch_30b
        0x13 -> :sswitch_338
        0x14 -> :sswitch_353
        0x15 -> :sswitch_39f
        0x16 -> :sswitch_3fa
        0x17 -> :sswitch_469
        0x18 -> :sswitch_47f
        0x19 -> :sswitch_4a7
        0x1a -> :sswitch_4bd
        0x1b -> :sswitch_4dc
        0x1c -> :sswitch_4f2
        0x1d -> :sswitch_52a
        0x1e -> :sswitch_540
        0x5f4e5446 -> :sswitch_8
    .end sparse-switch
.end method
