.class public abstract Landroid/app/ApplicationThreadNative;
.super Landroid/os/Binder;
.source "ApplicationThreadNative.java"

# interfaces
.implements Landroid/app/IApplicationThread;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 63
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 64
    const-string v0, "android.app.IApplicationThread"

    invoke-virtual {p0, p0, v0}, Landroid/app/ApplicationThreadNative;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 65
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/app/IApplicationThread;
    .registers 3
    .parameter "obj"

    .prologue
    .line 51
    if-nez p0, :cond_4

    .line 52
    const/4 v0, 0x0

    .line 60
    :cond_3
    :goto_3
    return-object v0

    .line 54
    :cond_4
    const-string v1, "android.app.IApplicationThread"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Landroid/app/IApplicationThread;

    .line 56
    .local v0, in:Landroid/app/IApplicationThread;
    if-nez v0, :cond_3

    .line 60
    new-instance v0, Landroid/app/ApplicationThreadProxy;

    .end local v0           #in:Landroid/app/IApplicationThread;
    invoke-direct {v0, p0}, Landroid/app/ApplicationThreadProxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 594
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 104
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
    .line 70
    packed-switch p1, :pswitch_data_74a

    .line 589
    :pswitch_3
    invoke-super/range {p0 .. p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v5

    :goto_7
    return v5

    .line 73
    :pswitch_8
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 74
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    .line 75
    .local v7, b:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_34

    const/16 v77, 0x1

    .line 76
    .local v77, finished:Z
    :goto_1b
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_37

    const/16 v98, 0x1

    .line 77
    .local v98, userLeaving:Z
    :goto_23
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v24

    .line 78
    .local v24, configChanges:I
    move-object/from16 v0, p0

    move/from16 v1, v77

    move/from16 v2, v98

    move/from16 v3, v24

    invoke-virtual {v0, v7, v1, v2, v3}, Landroid/app/ApplicationThreadNative;->schedulePauseActivity(Landroid/os/IBinder;ZZI)V

    .line 79
    const/4 v5, 0x1

    goto :goto_7

    .line 75
    .end local v24           #configChanges:I
    .end local v77           #finished:Z
    .end local v98           #userLeaving:Z
    :cond_34
    const/16 v77, 0x0

    goto :goto_1b

    .line 76
    .restart local v77       #finished:Z
    :cond_37
    const/16 v98, 0x0

    goto :goto_23

    .line 84
    .end local v7           #b:Landroid/os/IBinder;
    .end local v77           #finished:Z
    :pswitch_3a
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 85
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    .line 86
    .restart local v7       #b:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_5c

    const/16 v95, 0x1

    .line 87
    .local v95, show:Z
    :goto_4d
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v24

    .line 88
    .restart local v24       #configChanges:I
    move-object/from16 v0, p0

    move/from16 v1, v95

    move/from16 v2, v24

    invoke-virtual {v0, v7, v1, v2}, Landroid/app/ApplicationThreadNative;->scheduleStopActivity(Landroid/os/IBinder;ZI)V

    .line 89
    const/4 v5, 0x1

    goto :goto_7

    .line 86
    .end local v24           #configChanges:I
    .end local v95           #show:Z
    :cond_5c
    const/16 v95, 0x0

    goto :goto_4d

    .line 94
    .end local v7           #b:Landroid/os/IBinder;
    :pswitch_5f
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 95
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    .line 96
    .restart local v7       #b:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_7b

    const/16 v95, 0x1

    .line 97
    .restart local v95       #show:Z
    :goto_72
    move-object/from16 v0, p0

    move/from16 v1, v95

    invoke-virtual {v0, v7, v1}, Landroid/app/ApplicationThreadNative;->scheduleWindowVisibility(Landroid/os/IBinder;Z)V

    .line 98
    const/4 v5, 0x1

    goto :goto_7

    .line 96
    .end local v95           #show:Z
    :cond_7b
    const/16 v95, 0x0

    goto :goto_72

    .line 103
    .end local v7           #b:Landroid/os/IBinder;
    :pswitch_7e
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 104
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    .line 105
    .restart local v7       #b:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_9b

    const/16 v96, 0x1

    .line 106
    .local v96, sleeping:Z
    :goto_91
    move-object/from16 v0, p0

    move/from16 v1, v96

    invoke-virtual {v0, v7, v1}, Landroid/app/ApplicationThreadNative;->scheduleSleeping(Landroid/os/IBinder;Z)V

    .line 107
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 105
    .end local v96           #sleeping:Z
    :cond_9b
    const/16 v96, 0x0

    goto :goto_91

    .line 112
    .end local v7           #b:Landroid/os/IBinder;
    :pswitch_9e
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 113
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    .line 114
    .restart local v7       #b:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_bb

    const/16 v16, 0x1

    .line 115
    .local v16, isForward:Z
    :goto_b1
    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-virtual {v0, v7, v1}, Landroid/app/ApplicationThreadNative;->scheduleResumeActivity(Landroid/os/IBinder;Z)V

    .line 116
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 114
    .end local v16           #isForward:Z
    :cond_bb
    const/16 v16, 0x0

    goto :goto_b1

    .line 121
    .end local v7           #b:Landroid/os/IBinder;
    :pswitch_be
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 122
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    .line 123
    .restart local v7       #b:Landroid/os/IBinder;
    sget-object v5, Landroid/app/ResultInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->createTypedArrayList(Landroid/os/Parcelable$Creator;)Ljava/util/ArrayList;

    move-result-object v13

    .line 124
    .local v13, ri:Ljava/util/List;,"Ljava/util/List<Landroid/app/ResultInfo;>;"
    move-object/from16 v0, p0

    invoke-virtual {v0, v7, v13}, Landroid/app/ApplicationThreadNative;->scheduleSendResult(Landroid/os/IBinder;Ljava/util/List;)V

    .line 125
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 130
    .end local v7           #b:Landroid/os/IBinder;
    .end local v13           #ri:Ljava/util/List;,"Ljava/util/List<Landroid/app/ResultInfo;>;"
    :pswitch_d9
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 131
    sget-object v5, Landroid/content/Intent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/Intent;

    .line 132
    .local v6, intent:Landroid/content/Intent;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    .line 133
    .restart local v7       #b:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v8

    .line 134
    .local v8, ident:I
    sget-object v5, Landroid/content/pm/ActivityInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ActivityInfo;

    .line 135
    .local v9, info:Landroid/content/pm/ActivityInfo;
    sget-object v5, Landroid/content/res/Configuration;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/content/res/Configuration;

    .line 136
    .local v10, curConfig:Landroid/content/res/Configuration;
    sget-object v5, Landroid/content/res/CompatibilityInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroid/content/res/CompatibilityInfo;

    .line 137
    .local v11, compatInfo:Landroid/content/res/CompatibilityInfo;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;

    move-result-object v12

    .line 138
    .local v12, state:Landroid/os/Bundle;
    sget-object v5, Landroid/app/ResultInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->createTypedArrayList(Landroid/os/Parcelable$Creator;)Ljava/util/ArrayList;

    move-result-object v13

    .line 139
    .restart local v13       #ri:Ljava/util/List;,"Ljava/util/List<Landroid/app/ResultInfo;>;"
    sget-object v5, Landroid/content/Intent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->createTypedArrayList(Landroid/os/Parcelable$Creator;)Ljava/util/ArrayList;

    move-result-object v14

    .line 140
    .local v14, pi:Ljava/util/List;,"Ljava/util/List<Landroid/content/Intent;>;"
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_151

    const/4 v15, 0x1

    .line 141
    .local v15, notResumed:Z
    :goto_12b
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_153

    const/16 v16, 0x1

    .line 142
    .restart local v16       #isForward:Z
    :goto_133
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v17

    .line 143
    .local v17, profileName:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_156

    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v18

    .line 145
    .local v18, profileFd:Landroid/os/ParcelFileDescriptor;
    :goto_141
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_159

    const/16 v19, 0x1

    .local v19, autoStopProfiler:Z
    :goto_149
    move-object/from16 v5, p0

    .line 146
    invoke-virtual/range {v5 .. v19}, Landroid/app/ApplicationThreadNative;->scheduleLaunchActivity(Landroid/content/Intent;Landroid/os/IBinder;ILandroid/content/pm/ActivityInfo;Landroid/content/res/Configuration;Landroid/content/res/CompatibilityInfo;Landroid/os/Bundle;Ljava/util/List;Ljava/util/List;ZZLjava/lang/String;Landroid/os/ParcelFileDescriptor;Z)V

    .line 148
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 140
    .end local v15           #notResumed:Z
    .end local v16           #isForward:Z
    .end local v17           #profileName:Ljava/lang/String;
    .end local v18           #profileFd:Landroid/os/ParcelFileDescriptor;
    .end local v19           #autoStopProfiler:Z
    :cond_151
    const/4 v15, 0x0

    goto :goto_12b

    .line 141
    .restart local v15       #notResumed:Z
    :cond_153
    const/16 v16, 0x0

    goto :goto_133

    .line 143
    .restart local v16       #isForward:Z
    .restart local v17       #profileName:Ljava/lang/String;
    :cond_156
    const/16 v18, 0x0

    goto :goto_141

    .line 145
    .restart local v18       #profileFd:Landroid/os/ParcelFileDescriptor;
    :cond_159
    const/16 v19, 0x0

    goto :goto_149

    .line 153
    .end local v6           #intent:Landroid/content/Intent;
    .end local v7           #b:Landroid/os/IBinder;
    .end local v8           #ident:I
    .end local v9           #info:Landroid/content/pm/ActivityInfo;
    .end local v10           #curConfig:Landroid/content/res/Configuration;
    .end local v11           #compatInfo:Landroid/content/res/CompatibilityInfo;
    .end local v12           #state:Landroid/os/Bundle;
    .end local v13           #ri:Ljava/util/List;,"Ljava/util/List<Landroid/app/ResultInfo;>;"
    .end local v14           #pi:Ljava/util/List;,"Ljava/util/List<Landroid/content/Intent;>;"
    .end local v15           #notResumed:Z
    .end local v16           #isForward:Z
    .end local v17           #profileName:Ljava/lang/String;
    .end local v18           #profileFd:Landroid/os/ParcelFileDescriptor;
    :pswitch_15c
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 154
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    .line 155
    .restart local v7       #b:Landroid/os/IBinder;
    sget-object v5, Landroid/app/ResultInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->createTypedArrayList(Landroid/os/Parcelable$Creator;)Ljava/util/ArrayList;

    move-result-object v13

    .line 156
    .restart local v13       #ri:Ljava/util/List;,"Ljava/util/List<Landroid/app/ResultInfo;>;"
    sget-object v5, Landroid/content/Intent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->createTypedArrayList(Landroid/os/Parcelable$Creator;)Ljava/util/ArrayList;

    move-result-object v14

    .line 157
    .restart local v14       #pi:Ljava/util/List;,"Ljava/util/List<Landroid/content/Intent;>;"
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v24

    .line 158
    .restart local v24       #configChanges:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_1a4

    const/4 v15, 0x1

    .line 159
    .restart local v15       #notResumed:Z
    :goto_182
    const/16 v26, 0x0

    .line 160
    .local v26, config:Landroid/content/res/Configuration;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_194

    .line 161
    sget-object v5, Landroid/content/res/Configuration;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v26

    .end local v26           #config:Landroid/content/res/Configuration;
    check-cast v26, Landroid/content/res/Configuration;

    .restart local v26       #config:Landroid/content/res/Configuration;
    :cond_194
    move-object/from16 v20, p0

    move-object/from16 v21, v7

    move-object/from16 v22, v13

    move-object/from16 v23, v14

    move/from16 v25, v15

    .line 163
    invoke-virtual/range {v20 .. v26}, Landroid/app/ApplicationThreadNative;->scheduleRelaunchActivity(Landroid/os/IBinder;Ljava/util/List;Ljava/util/List;IZLandroid/content/res/Configuration;)V

    .line 164
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 158
    .end local v15           #notResumed:Z
    .end local v26           #config:Landroid/content/res/Configuration;
    :cond_1a4
    const/4 v15, 0x0

    goto :goto_182

    .line 169
    .end local v7           #b:Landroid/os/IBinder;
    .end local v13           #ri:Ljava/util/List;,"Ljava/util/List<Landroid/app/ResultInfo;>;"
    .end local v14           #pi:Ljava/util/List;,"Ljava/util/List<Landroid/content/Intent;>;"
    .end local v24           #configChanges:I
    :pswitch_1a6
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 170
    sget-object v5, Landroid/content/Intent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->createTypedArrayList(Landroid/os/Parcelable$Creator;)Ljava/util/ArrayList;

    move-result-object v14

    .line 171
    .restart local v14       #pi:Ljava/util/List;,"Ljava/util/List<Landroid/content/Intent;>;"
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    .line 172
    .restart local v7       #b:Landroid/os/IBinder;
    move-object/from16 v0, p0

    invoke-virtual {v0, v14, v7}, Landroid/app/ApplicationThreadNative;->scheduleNewIntent(Ljava/util/List;Landroid/os/IBinder;)V

    .line 173
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 178
    .end local v7           #b:Landroid/os/IBinder;
    .end local v14           #pi:Ljava/util/List;,"Ljava/util/List<Landroid/content/Intent;>;"
    :pswitch_1c1
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 179
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    .line 180
    .restart local v7       #b:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_1e4

    const/16 v78, 0x1

    .line 181
    .local v78, finishing:Z
    :goto_1d4
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v24

    .line 182
    .restart local v24       #configChanges:I
    move-object/from16 v0, p0

    move/from16 v1, v78

    move/from16 v2, v24

    invoke-virtual {v0, v7, v1, v2}, Landroid/app/ApplicationThreadNative;->scheduleDestroyActivity(Landroid/os/IBinder;ZI)V

    .line 183
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 180
    .end local v24           #configChanges:I
    .end local v78           #finishing:Z
    :cond_1e4
    const/16 v78, 0x0

    goto :goto_1d4

    .line 188
    .end local v7           #b:Landroid/os/IBinder;
    :pswitch_1e7
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 189
    sget-object v5, Landroid/content/Intent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/Intent;

    .line 190
    .restart local v6       #intent:Landroid/content/Intent;
    sget-object v5, Landroid/content/pm/ActivityInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ActivityInfo;

    .line 191
    .restart local v9       #info:Landroid/content/pm/ActivityInfo;
    sget-object v5, Landroid/content/res/CompatibilityInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroid/content/res/CompatibilityInfo;

    .line 192
    .restart local v11       #compatInfo:Landroid/content/res/CompatibilityInfo;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v31

    .line 193
    .local v31, resultCode:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v32

    .line 194
    .local v32, resultData:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;

    move-result-object v33

    .line 195
    .local v33, resultExtras:Landroid/os/Bundle;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_22e

    const/16 v34, 0x1

    .local v34, sync:Z
    :goto_220
    move-object/from16 v27, p0

    move-object/from16 v28, v6

    move-object/from16 v29, v9

    move-object/from16 v30, v11

    .line 196
    invoke-virtual/range {v27 .. v34}, Landroid/app/ApplicationThreadNative;->scheduleReceiver(Landroid/content/Intent;Landroid/content/pm/ActivityInfo;Landroid/content/res/CompatibilityInfo;ILjava/lang/String;Landroid/os/Bundle;Z)V

    .line 198
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 195
    .end local v34           #sync:Z
    :cond_22e
    const/16 v34, 0x0

    goto :goto_220

    .line 202
    .end local v6           #intent:Landroid/content/Intent;
    .end local v9           #info:Landroid/content/pm/ActivityInfo;
    .end local v11           #compatInfo:Landroid/content/res/CompatibilityInfo;
    .end local v31           #resultCode:I
    .end local v32           #resultData:Ljava/lang/String;
    .end local v33           #resultExtras:Landroid/os/Bundle;
    :pswitch_231
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 203
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v36

    .line 204
    .local v36, token:Landroid/os/IBinder;
    sget-object v5, Landroid/content/pm/ServiceInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ServiceInfo;

    .line 205
    .local v9, info:Landroid/content/pm/ServiceInfo;
    sget-object v5, Landroid/content/res/CompatibilityInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroid/content/res/CompatibilityInfo;

    .line 206
    .restart local v11       #compatInfo:Landroid/content/res/CompatibilityInfo;
    move-object/from16 v0, p0

    move-object/from16 v1, v36

    invoke-virtual {v0, v1, v9, v11}, Landroid/app/ApplicationThreadNative;->scheduleCreateService(Landroid/os/IBinder;Landroid/content/pm/ServiceInfo;Landroid/content/res/CompatibilityInfo;)V

    .line 207
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 211
    .end local v9           #info:Landroid/content/pm/ServiceInfo;
    .end local v11           #compatInfo:Landroid/content/res/CompatibilityInfo;
    .end local v36           #token:Landroid/os/IBinder;
    :pswitch_25a
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 212
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v36

    .line 213
    .restart local v36       #token:Landroid/os/IBinder;
    sget-object v5, Landroid/content/Intent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/Intent;

    .line 214
    .restart local v6       #intent:Landroid/content/Intent;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_283

    const/16 v92, 0x1

    .line 215
    .local v92, rebind:Z
    :goto_277
    move-object/from16 v0, p0

    move-object/from16 v1, v36

    move/from16 v2, v92

    invoke-virtual {v0, v1, v6, v2}, Landroid/app/ApplicationThreadNative;->scheduleBindService(Landroid/os/IBinder;Landroid/content/Intent;Z)V

    .line 216
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 214
    .end local v92           #rebind:Z
    :cond_283
    const/16 v92, 0x0

    goto :goto_277

    .line 220
    .end local v6           #intent:Landroid/content/Intent;
    .end local v36           #token:Landroid/os/IBinder;
    :pswitch_286
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 221
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v36

    .line 222
    .restart local v36       #token:Landroid/os/IBinder;
    sget-object v5, Landroid/content/Intent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/Intent;

    .line 223
    .restart local v6       #intent:Landroid/content/Intent;
    move-object/from16 v0, p0

    move-object/from16 v1, v36

    invoke-virtual {v0, v1, v6}, Landroid/app/ApplicationThreadNative;->scheduleUnbindService(Landroid/os/IBinder;Landroid/content/Intent;)V

    .line 224
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 229
    .end local v6           #intent:Landroid/content/Intent;
    .end local v36           #token:Landroid/os/IBinder;
    :pswitch_2a5
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 230
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v36

    .line 231
    .restart local v36       #token:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_2d8

    const/16 v37, 0x1

    .line 232
    .local v37, taskRemoved:Z
    :goto_2b8
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v38

    .line 233
    .local v38, startId:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v39

    .line 235
    .local v39, fl:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_2db

    .line 236
    sget-object v5, Landroid/content/Intent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v40

    check-cast v40, Landroid/content/Intent;

    .local v40, args:Landroid/content/Intent;
    :goto_2d0
    move-object/from16 v35, p0

    .line 240
    invoke-virtual/range {v35 .. v40}, Landroid/app/ApplicationThreadNative;->scheduleServiceArgs(Landroid/os/IBinder;ZIILandroid/content/Intent;)V

    .line 241
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 231
    .end local v37           #taskRemoved:Z
    .end local v38           #startId:I
    .end local v39           #fl:I
    .end local v40           #args:Landroid/content/Intent;
    :cond_2d8
    const/16 v37, 0x0

    goto :goto_2b8

    .line 238
    .restart local v37       #taskRemoved:Z
    .restart local v38       #startId:I
    .restart local v39       #fl:I
    :cond_2db
    const/16 v40, 0x0

    .restart local v40       #args:Landroid/content/Intent;
    goto :goto_2d0

    .line 246
    .end local v36           #token:Landroid/os/IBinder;
    .end local v37           #taskRemoved:Z
    .end local v38           #startId:I
    .end local v39           #fl:I
    .end local v40           #args:Landroid/content/Intent;
    :pswitch_2de
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 247
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v36

    .line 248
    .restart local v36       #token:Landroid/os/IBinder;
    move-object/from16 v0, p0

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Landroid/app/ApplicationThreadNative;->scheduleStopService(Landroid/os/IBinder;)V

    .line 249
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 254
    .end local v36           #token:Landroid/os/IBinder;
    :pswitch_2f3
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 255
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v42

    .line 256
    .local v42, packageName:Ljava/lang/String;
    sget-object v5, Landroid/content/pm/ApplicationInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ApplicationInfo;

    .line 258
    .local v9, info:Landroid/content/pm/ApplicationInfo;
    sget-object v5, Landroid/content/pm/ProviderInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->createTypedArrayList(Landroid/os/Parcelable$Creator;)Ljava/util/ArrayList;

    move-result-object v44

    .line 260
    .local v44, providers:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ProviderInfo;>;"
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_390

    new-instance v45, Landroid/content/ComponentName;

    move-object/from16 v0, v45

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Landroid/content/ComponentName;-><init>(Landroid/os/Parcel;)V

    .line 262
    .local v45, testName:Landroid/content/ComponentName;
    :goto_31f
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v17

    .line 263
    .restart local v17       #profileName:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_393

    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v18

    .line 265
    .restart local v18       #profileFd:Landroid/os/ParcelFileDescriptor;
    :goto_32d
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_396

    const/16 v19, 0x1

    .line 266
    .restart local v19       #autoStopProfiler:Z
    :goto_335
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;

    move-result-object v49

    .line 267
    .local v49, testArgs:Landroid/os/Bundle;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v71

    .line 268
    .local v71, binder:Landroid/os/IBinder;
    invoke-static/range {v71 .. v71}, Landroid/app/IInstrumentationWatcher$Stub;->asInterface(Landroid/os/IBinder;)Landroid/app/IInstrumentationWatcher;

    move-result-object v50

    .line 269
    .local v50, testWatcher:Landroid/app/IInstrumentationWatcher;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v51

    .line 270
    .local v51, testMode:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_399

    const/16 v52, 0x1

    .line 271
    .local v52, openGlTrace:Z
    :goto_34d
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_39c

    const/16 v53, 0x1

    .line 272
    .local v53, restrictedBackupMode:Z
    :goto_355
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_39f

    const/16 v54, 0x1

    .line 273
    .local v54, persistent:Z
    :goto_35d
    sget-object v5, Landroid/content/res/Configuration;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v26

    check-cast v26, Landroid/content/res/Configuration;

    .line 274
    .restart local v26       #config:Landroid/content/res/Configuration;
    sget-object v5, Landroid/content/res/CompatibilityInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroid/content/res/CompatibilityInfo;

    .line 275
    .restart local v11       #compatInfo:Landroid/content/res/CompatibilityInfo;
    const/4 v5, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->readHashMap(Ljava/lang/ClassLoader;)Ljava/util/HashMap;

    move-result-object v57

    .line 276
    .local v57, services:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/lang/String;Landroid/os/IBinder;>;"
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;

    move-result-object v58

    .local v58, coreSettings:Landroid/os/Bundle;
    move-object/from16 v41, p0

    move-object/from16 v43, v9

    move-object/from16 v46, v17

    move-object/from16 v47, v18

    move/from16 v48, v19

    move-object/from16 v55, v26

    move-object/from16 v56, v11

    .line 277
    invoke-virtual/range {v41 .. v58}, Landroid/app/ApplicationThreadNative;->bindApplication(Ljava/lang/String;Landroid/content/pm/ApplicationInfo;Ljava/util/List;Landroid/content/ComponentName;Ljava/lang/String;Landroid/os/ParcelFileDescriptor;ZLandroid/os/Bundle;Landroid/app/IInstrumentationWatcher;IZZZLandroid/content/res/Configuration;Landroid/content/res/CompatibilityInfo;Ljava/util/Map;Landroid/os/Bundle;)V

    .line 281
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 260
    .end local v11           #compatInfo:Landroid/content/res/CompatibilityInfo;
    .end local v17           #profileName:Ljava/lang/String;
    .end local v18           #profileFd:Landroid/os/ParcelFileDescriptor;
    .end local v19           #autoStopProfiler:Z
    .end local v26           #config:Landroid/content/res/Configuration;
    .end local v45           #testName:Landroid/content/ComponentName;
    .end local v49           #testArgs:Landroid/os/Bundle;
    .end local v50           #testWatcher:Landroid/app/IInstrumentationWatcher;
    .end local v51           #testMode:I
    .end local v52           #openGlTrace:Z
    .end local v53           #restrictedBackupMode:Z
    .end local v54           #persistent:Z
    .end local v57           #services:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/lang/String;Landroid/os/IBinder;>;"
    .end local v58           #coreSettings:Landroid/os/Bundle;
    .end local v71           #binder:Landroid/os/IBinder;
    :cond_390
    const/16 v45, 0x0

    goto :goto_31f

    .line 263
    .restart local v17       #profileName:Ljava/lang/String;
    .restart local v45       #testName:Landroid/content/ComponentName;
    :cond_393
    const/16 v18, 0x0

    goto :goto_32d

    .line 265
    .restart local v18       #profileFd:Landroid/os/ParcelFileDescriptor;
    :cond_396
    const/16 v19, 0x0

    goto :goto_335

    .line 270
    .restart local v19       #autoStopProfiler:Z
    .restart local v49       #testArgs:Landroid/os/Bundle;
    .restart local v50       #testWatcher:Landroid/app/IInstrumentationWatcher;
    .restart local v51       #testMode:I
    .restart local v71       #binder:Landroid/os/IBinder;
    :cond_399
    const/16 v52, 0x0

    goto :goto_34d

    .line 271
    .restart local v52       #openGlTrace:Z
    :cond_39c
    const/16 v53, 0x0

    goto :goto_355

    .line 272
    .restart local v53       #restrictedBackupMode:Z
    :cond_39f
    const/16 v54, 0x0

    goto :goto_35d

    .line 286
    .end local v9           #info:Landroid/content/pm/ApplicationInfo;
    .end local v17           #profileName:Ljava/lang/String;
    .end local v18           #profileFd:Landroid/os/ParcelFileDescriptor;
    .end local v19           #autoStopProfiler:Z
    .end local v42           #packageName:Ljava/lang/String;
    .end local v44           #providers:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ProviderInfo;>;"
    .end local v45           #testName:Landroid/content/ComponentName;
    .end local v49           #testArgs:Landroid/os/Bundle;
    .end local v50           #testWatcher:Landroid/app/IInstrumentationWatcher;
    .end local v51           #testMode:I
    .end local v52           #openGlTrace:Z
    .end local v53           #restrictedBackupMode:Z
    .end local v71           #binder:Landroid/os/IBinder;
    :pswitch_3a2
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 287
    invoke-virtual/range {p0 .. p0}, Landroid/app/ApplicationThreadNative;->scheduleExit()V

    .line 288
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 293
    :pswitch_3af
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 294
    invoke-virtual/range {p0 .. p0}, Landroid/app/ApplicationThreadNative;->scheduleSuicide()V

    .line 295
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 300
    :pswitch_3bc
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 301
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    .line 302
    .restart local v7       #b:Landroid/os/IBinder;
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Landroid/app/ApplicationThreadNative;->requestThumbnail(Landroid/os/IBinder;)V

    .line 303
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 308
    .end local v7           #b:Landroid/os/IBinder;
    :pswitch_3cf
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 309
    sget-object v5, Landroid/content/res/Configuration;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v26

    check-cast v26, Landroid/content/res/Configuration;

    .line 310
    .restart local v26       #config:Landroid/content/res/Configuration;
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/app/ApplicationThreadNative;->scheduleConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 311
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 315
    .end local v26           #config:Landroid/content/res/Configuration;
    :pswitch_3ea
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 316
    invoke-virtual/range {p0 .. p0}, Landroid/app/ApplicationThreadNative;->updateTimeZone()V

    .line 317
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 321
    :pswitch_3f7
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 322
    invoke-virtual/range {p0 .. p0}, Landroid/app/ApplicationThreadNative;->clearDnsCache()V

    .line 323
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 327
    :pswitch_404
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 328
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v91

    .line 329
    .local v91, proxy:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v87

    .line 330
    .local v87, port:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v75

    .line 331
    .local v75, exclList:Ljava/lang/String;
    move-object/from16 v0, p0

    move-object/from16 v1, v91

    move-object/from16 v2, v87

    move-object/from16 v3, v75

    invoke-virtual {v0, v1, v2, v3}, Landroid/app/ApplicationThreadNative;->setHttpProxy(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 332
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 336
    .end local v75           #exclList:Ljava/lang/String;
    .end local v87           #port:Ljava/lang/String;
    .end local v91           #proxy:Ljava/lang/String;
    :pswitch_425
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 337
    invoke-virtual/range {p0 .. p0}, Landroid/app/ApplicationThreadNative;->processInBackground()V

    .line 338
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 342
    :pswitch_432
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 343
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v76

    .line 344
    .local v76, fd:Landroid/os/ParcelFileDescriptor;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v93

    .line 345
    .local v93, service:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStringArray()[Ljava/lang/String;

    move-result-object v40

    .line 346
    .local v40, args:[Ljava/lang/String;
    if-eqz v76, :cond_457

    .line 347
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v5

    move-object/from16 v0, p0

    move-object/from16 v1, v93

    move-object/from16 v2, v40

    invoke-virtual {v0, v5, v1, v2}, Landroid/app/ApplicationThreadNative;->dumpService(Ljava/io/FileDescriptor;Landroid/os/IBinder;[Ljava/lang/String;)V

    .line 349
    :try_start_454
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_457
    .catch Ljava/io/IOException; {:try_start_454 .. :try_end_457} :catch_734

    .line 353
    :cond_457
    :goto_457
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 357
    .end local v40           #args:[Ljava/lang/String;
    .end local v76           #fd:Landroid/os/ParcelFileDescriptor;
    .end local v93           #service:Landroid/os/IBinder;
    :pswitch_45a
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 358
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v76

    .line 359
    .restart local v76       #fd:Landroid/os/ParcelFileDescriptor;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v93

    .line 360
    .restart local v93       #service:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStringArray()[Ljava/lang/String;

    move-result-object v40

    .line 361
    .restart local v40       #args:[Ljava/lang/String;
    if-eqz v76, :cond_47f

    .line 362
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v5

    move-object/from16 v0, p0

    move-object/from16 v1, v93

    move-object/from16 v2, v40

    invoke-virtual {v0, v5, v1, v2}, Landroid/app/ApplicationThreadNative;->dumpProvider(Ljava/io/FileDescriptor;Landroid/os/IBinder;[Ljava/lang/String;)V

    .line 364
    :try_start_47c
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_47f
    .catch Ljava/io/IOException; {:try_start_47c .. :try_end_47f} :catch_737

    .line 368
    :cond_47f
    :goto_47f
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 372
    .end local v40           #args:[Ljava/lang/String;
    .end local v76           #fd:Landroid/os/ParcelFileDescriptor;
    .end local v93           #service:Landroid/os/IBinder;
    :pswitch_482
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 373
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v5

    invoke-static {v5}, Landroid/content/IIntentReceiver$Stub;->asInterface(Landroid/os/IBinder;)Landroid/content/IIntentReceiver;

    move-result-object v60

    .line 375
    .local v60, receiver:Landroid/content/IIntentReceiver;
    sget-object v5, Landroid/content/Intent;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/Intent;

    .line 376
    .restart local v6       #intent:Landroid/content/Intent;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v31

    .line 377
    .restart local v31       #resultCode:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v63

    .line 378
    .local v63, dataStr:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;

    move-result-object v64

    .line 379
    .local v64, extras:Landroid/os/Bundle;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_4c3

    const/16 v65, 0x1

    .line 380
    .local v65, ordered:Z
    :goto_4af
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_4c6

    const/16 v66, 0x1

    .local v66, sticky:Z
    :goto_4b7
    move-object/from16 v59, p0

    move-object/from16 v61, v6

    move/from16 v62, v31

    .line 381
    invoke-virtual/range {v59 .. v66}, Landroid/app/ApplicationThreadNative;->scheduleRegisteredReceiver(Landroid/content/IIntentReceiver;Landroid/content/Intent;ILjava/lang/String;Landroid/os/Bundle;ZZ)V

    .line 383
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 379
    .end local v65           #ordered:Z
    .end local v66           #sticky:Z
    :cond_4c3
    const/16 v65, 0x0

    goto :goto_4af

    .line 380
    .restart local v65       #ordered:Z
    :cond_4c6
    const/16 v66, 0x0

    goto :goto_4b7

    .line 388
    .end local v6           #intent:Landroid/content/Intent;
    .end local v31           #resultCode:I
    .end local v60           #receiver:Landroid/content/IIntentReceiver;
    .end local v63           #dataStr:Ljava/lang/String;
    .end local v64           #extras:Landroid/os/Bundle;
    .end local v65           #ordered:Z
    :pswitch_4c9
    invoke-virtual/range {p0 .. p0}, Landroid/app/ApplicationThreadNative;->scheduleLowMemory()V

    .line 389
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 394
    :pswitch_4cf
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 395
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    .line 396
    .restart local v7       #b:Landroid/os/IBinder;
    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Landroid/app/ApplicationThreadNative;->scheduleActivityConfigurationChanged(Landroid/os/IBinder;)V

    .line 397
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 402
    .end local v7           #b:Landroid/os/IBinder;
    :pswitch_4e2
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 403
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_513

    const/16 v97, 0x1

    .line 404
    .local v97, start:Z
    :goto_4f1
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v89

    .line 405
    .local v89, profileType:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v85

    .line 406
    .local v85, path:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_516

    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v76

    .line 408
    .restart local v76       #fd:Landroid/os/ParcelFileDescriptor;
    :goto_503
    move-object/from16 v0, p0

    move/from16 v1, v97

    move-object/from16 v2, v85

    move-object/from16 v3, v76

    move/from16 v4, v89

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/app/ApplicationThreadNative;->profilerControl(ZLjava/lang/String;Landroid/os/ParcelFileDescriptor;I)V

    .line 409
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 403
    .end local v76           #fd:Landroid/os/ParcelFileDescriptor;
    .end local v85           #path:Ljava/lang/String;
    .end local v89           #profileType:I
    .end local v97           #start:Z
    :cond_513
    const/16 v97, 0x0

    goto :goto_4f1

    .line 406
    .restart local v85       #path:Ljava/lang/String;
    .restart local v89       #profileType:I
    .restart local v97       #start:Z
    :cond_516
    const/16 v76, 0x0

    goto :goto_503

    .line 414
    .end local v85           #path:Ljava/lang/String;
    .end local v89           #profileType:I
    .end local v97           #start:Z
    :pswitch_519
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 415
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v79

    .line 416
    .local v79, group:I
    move-object/from16 v0, p0

    move/from16 v1, v79

    invoke-virtual {v0, v1}, Landroid/app/ApplicationThreadNative;->setSchedulingGroup(I)V

    .line 417
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 422
    .end local v79           #group:I
    :pswitch_52e
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 423
    sget-object v5, Landroid/content/pm/ApplicationInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v69

    check-cast v69, Landroid/content/pm/ApplicationInfo;

    .line 424
    .local v69, appInfo:Landroid/content/pm/ApplicationInfo;
    sget-object v5, Landroid/content/res/CompatibilityInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroid/content/res/CompatibilityInfo;

    .line 425
    .restart local v11       #compatInfo:Landroid/content/res/CompatibilityInfo;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v70

    .line 426
    .local v70, backupMode:I
    move-object/from16 v0, p0

    move-object/from16 v1, v69

    move/from16 v2, v70

    invoke-virtual {v0, v1, v11, v2}, Landroid/app/ApplicationThreadNative;->scheduleCreateBackupAgent(Landroid/content/pm/ApplicationInfo;Landroid/content/res/CompatibilityInfo;I)V

    .line 427
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 432
    .end local v11           #compatInfo:Landroid/content/res/CompatibilityInfo;
    .end local v69           #appInfo:Landroid/content/pm/ApplicationInfo;
    .end local v70           #backupMode:I
    :pswitch_559
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 433
    sget-object v5, Landroid/content/pm/ApplicationInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v69

    check-cast v69, Landroid/content/pm/ApplicationInfo;

    .line 434
    .restart local v69       #appInfo:Landroid/content/pm/ApplicationInfo;
    sget-object v5, Landroid/content/res/CompatibilityInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroid/content/res/CompatibilityInfo;

    .line 435
    .restart local v11       #compatInfo:Landroid/content/res/CompatibilityInfo;
    move-object/from16 v0, p0

    move-object/from16 v1, v69

    invoke-virtual {v0, v1, v11}, Landroid/app/ApplicationThreadNative;->scheduleDestroyBackupAgent(Landroid/content/pm/ApplicationInfo;Landroid/content/res/CompatibilityInfo;)V

    .line 436
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 441
    .end local v11           #compatInfo:Landroid/content/res/CompatibilityInfo;
    .end local v69           #appInfo:Landroid/content/pm/ApplicationInfo;
    :pswitch_57e
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 442
    new-instance v82, Landroid/os/Debug$MemoryInfo;

    invoke-direct/range {v82 .. v82}, Landroid/os/Debug$MemoryInfo;-><init>()V

    .line 443
    .local v82, mi:Landroid/os/Debug$MemoryInfo;
    move-object/from16 v0, p0

    move-object/from16 v1, v82

    invoke-virtual {v0, v1}, Landroid/app/ApplicationThreadNative;->getMemoryInfo(Landroid/os/Debug$MemoryInfo;)V

    .line 444
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 445
    const/4 v5, 0x0

    move-object/from16 v0, v82

    move-object/from16 v1, p3

    invoke-virtual {v0, v1, v5}, Landroid/os/Debug$MemoryInfo;->writeToParcel(Landroid/os/Parcel;I)V

    .line 446
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 451
    .end local v82           #mi:Landroid/os/Debug$MemoryInfo;
    :pswitch_59f
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 452
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v73

    .line 453
    .local v73, cmd:I
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStringArray()[Ljava/lang/String;

    move-result-object v84

    .line 454
    .local v84, packages:[Ljava/lang/String;
    move-object/from16 v0, p0

    move/from16 v1, v73

    move-object/from16 v2, v84

    invoke-virtual {v0, v1, v2}, Landroid/app/ApplicationThreadNative;->dispatchPackageBroadcast(I[Ljava/lang/String;)V

    .line 455
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 460
    .end local v73           #cmd:I
    .end local v84           #packages:[Ljava/lang/String;
    :pswitch_5ba
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 461
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v83

    .line 462
    .local v83, msg:Ljava/lang/String;
    move-object/from16 v0, p0

    move-object/from16 v1, v83

    invoke-virtual {v0, v1}, Landroid/app/ApplicationThreadNative;->scheduleCrash(Ljava/lang/String;)V

    .line 463
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 468
    .end local v83           #msg:Ljava/lang/String;
    :pswitch_5cf
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 469
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_5fa

    const/16 v81, 0x1

    .line 470
    .local v81, managed:Z
    :goto_5de
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v85

    .line 471
    .restart local v85       #path:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_5fd

    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v76

    .line 473
    .restart local v76       #fd:Landroid/os/ParcelFileDescriptor;
    :goto_5ec
    move-object/from16 v0, p0

    move/from16 v1, v81

    move-object/from16 v2, v85

    move-object/from16 v3, v76

    invoke-virtual {v0, v1, v2, v3}, Landroid/app/ApplicationThreadNative;->dumpHeap(ZLjava/lang/String;Landroid/os/ParcelFileDescriptor;)V

    .line 474
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 469
    .end local v76           #fd:Landroid/os/ParcelFileDescriptor;
    .end local v81           #managed:Z
    .end local v85           #path:Ljava/lang/String;
    :cond_5fa
    const/16 v81, 0x0

    goto :goto_5de

    .line 471
    .restart local v81       #managed:Z
    .restart local v85       #path:Ljava/lang/String;
    :cond_5fd
    const/16 v76, 0x0

    goto :goto_5ec

    .line 478
    .end local v81           #managed:Z
    .end local v85           #path:Ljava/lang/String;
    :pswitch_600
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 479
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v76

    .line 480
    .restart local v76       #fd:Landroid/os/ParcelFileDescriptor;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v67

    .line 481
    .local v67, activity:Landroid/os/IBinder;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v88

    .line 482
    .local v88, prefix:Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStringArray()[Ljava/lang/String;

    move-result-object v40

    .line 483
    .restart local v40       #args:[Ljava/lang/String;
    if-eqz v76, :cond_62b

    .line 484
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v5

    move-object/from16 v0, p0

    move-object/from16 v1, v67

    move-object/from16 v2, v88

    move-object/from16 v3, v40

    invoke-virtual {v0, v5, v1, v2, v3}, Landroid/app/ApplicationThreadNative;->dumpActivity(Ljava/io/FileDescriptor;Landroid/os/IBinder;Ljava/lang/String;[Ljava/lang/String;)V

    .line 486
    :try_start_628
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_62b
    .catch Ljava/io/IOException; {:try_start_628 .. :try_end_62b} :catch_73a

    .line 490
    :cond_62b
    :goto_62b
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 494
    .end local v40           #args:[Ljava/lang/String;
    .end local v67           #activity:Landroid/os/IBinder;
    .end local v76           #fd:Landroid/os/ParcelFileDescriptor;
    .end local v88           #prefix:Ljava/lang/String;
    :pswitch_62e
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 495
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;

    move-result-object v94

    .line 496
    .local v94, settings:Landroid/os/Bundle;
    move-object/from16 v0, p0

    move-object/from16 v1, v94

    invoke-virtual {v0, v1}, Landroid/app/ApplicationThreadNative;->setCoreSettings(Landroid/os/Bundle;)V

    .line 497
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 501
    .end local v94           #settings:Landroid/os/Bundle;
    :pswitch_643
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 502
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v86

    .line 503
    .local v86, pkg:Ljava/lang/String;
    sget-object v5, Landroid/content/res/CompatibilityInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    move-object/from16 v0, p2

    invoke-interface {v5, v0}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v74

    check-cast v74, Landroid/content/res/CompatibilityInfo;

    .line 504
    .local v74, compat:Landroid/content/res/CompatibilityInfo;
    move-object/from16 v0, p0

    move-object/from16 v1, v86

    move-object/from16 v2, v74

    invoke-virtual {v0, v1, v2}, Landroid/app/ApplicationThreadNative;->updatePackageCompatibilityInfo(Ljava/lang/String;Landroid/content/res/CompatibilityInfo;)V

    .line 505
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 509
    .end local v74           #compat:Landroid/content/res/CompatibilityInfo;
    .end local v86           #pkg:Ljava/lang/String;
    :pswitch_664
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 510
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v80

    .line 511
    .local v80, level:I
    move-object/from16 v0, p0

    move/from16 v1, v80

    invoke-virtual {v0, v1}, Landroid/app/ApplicationThreadNative;->scheduleTrimMemory(I)V

    .line 512
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 517
    .end local v80           #level:I
    :pswitch_679
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 518
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v76

    .line 519
    .restart local v76       #fd:Landroid/os/ParcelFileDescriptor;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_6bd

    const/16 v72, 0x1

    .line 520
    .local v72, checkin:Z
    :goto_68c
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_6c0

    const/16 v68, 0x1

    .line 521
    .local v68, all:Z
    :goto_694
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStringArray()[Ljava/lang/String;

    move-result-object v40

    .line 522
    .restart local v40       #args:[Ljava/lang/String;
    const/16 v82, 0x0

    .line 523
    .restart local v82       #mi:Landroid/os/Debug$MemoryInfo;
    if-eqz v76, :cond_6af

    .line 525
    :try_start_69c
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v5

    move-object/from16 v0, p0

    move/from16 v1, v72

    move/from16 v2, v68

    move-object/from16 v3, v40

    invoke-virtual {v0, v5, v1, v2, v3}, Landroid/app/ApplicationThreadNative;->dumpMemInfo(Ljava/io/FileDescriptor;ZZ[Ljava/lang/String;)Landroid/os/Debug$MemoryInfo;
    :try_end_6ab
    .catchall {:try_start_69c .. :try_end_6ab} :catchall_6c3

    move-result-object v82

    .line 528
    :try_start_6ac
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_6af
    .catch Ljava/io/IOException; {:try_start_6ac .. :try_end_6af} :catch_73d

    .line 534
    :cond_6af
    :goto_6af
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 535
    const/4 v5, 0x0

    move-object/from16 v0, v82

    move-object/from16 v1, p3

    invoke-virtual {v0, v1, v5}, Landroid/os/Debug$MemoryInfo;->writeToParcel(Landroid/os/Parcel;I)V

    .line 536
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 519
    .end local v40           #args:[Ljava/lang/String;
    .end local v68           #all:Z
    .end local v72           #checkin:Z
    .end local v82           #mi:Landroid/os/Debug$MemoryInfo;
    :cond_6bd
    const/16 v72, 0x0

    goto :goto_68c

    .line 520
    .restart local v72       #checkin:Z
    :cond_6c0
    const/16 v68, 0x0

    goto :goto_694

    .line 527
    .restart local v40       #args:[Ljava/lang/String;
    .restart local v68       #all:Z
    .restart local v82       #mi:Landroid/os/Debug$MemoryInfo;
    :catchall_6c3
    move-exception v5

    .line 528
    :try_start_6c4
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_6c7
    .catch Ljava/io/IOException; {:try_start_6c4 .. :try_end_6c7} :catch_740

    .line 531
    :goto_6c7
    throw v5

    .line 541
    .end local v40           #args:[Ljava/lang/String;
    .end local v68           #all:Z
    .end local v72           #checkin:Z
    .end local v76           #fd:Landroid/os/ParcelFileDescriptor;
    .end local v82           #mi:Landroid/os/Debug$MemoryInfo;
    :pswitch_6c8
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 542
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v76

    .line 543
    .restart local v76       #fd:Landroid/os/ParcelFileDescriptor;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStringArray()[Ljava/lang/String;

    move-result-object v40

    .line 544
    .restart local v40       #args:[Ljava/lang/String;
    if-eqz v76, :cond_6e7

    .line 546
    :try_start_6d9
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v5

    move-object/from16 v0, p0

    move-object/from16 v1, v40

    invoke-virtual {v0, v5, v1}, Landroid/app/ApplicationThreadNative;->dumpGfxInfo(Ljava/io/FileDescriptor;[Ljava/lang/String;)V
    :try_end_6e4
    .catchall {:try_start_6d9 .. :try_end_6e4} :catchall_6ed

    .line 549
    :try_start_6e4
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_6e7
    .catch Ljava/io/IOException; {:try_start_6e4 .. :try_end_6e7} :catch_742

    .line 555
    :cond_6e7
    :goto_6e7
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 556
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 548
    :catchall_6ed
    move-exception v5

    .line 549
    :try_start_6ee
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_6f1
    .catch Ljava/io/IOException; {:try_start_6ee .. :try_end_6f1} :catch_744

    .line 552
    :goto_6f1
    throw v5

    .line 561
    .end local v40           #args:[Ljava/lang/String;
    .end local v76           #fd:Landroid/os/ParcelFileDescriptor;
    :pswitch_6f2
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 562
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readFileDescriptor()Landroid/os/ParcelFileDescriptor;

    move-result-object v76

    .line 563
    .restart local v76       #fd:Landroid/os/ParcelFileDescriptor;
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStringArray()[Ljava/lang/String;

    move-result-object v40

    .line 564
    .restart local v40       #args:[Ljava/lang/String;
    if-eqz v76, :cond_711

    .line 566
    :try_start_703
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v5

    move-object/from16 v0, p0

    move-object/from16 v1, v40

    invoke-virtual {v0, v5, v1}, Landroid/app/ApplicationThreadNative;->dumpDbInfo(Ljava/io/FileDescriptor;[Ljava/lang/String;)V
    :try_end_70e
    .catchall {:try_start_703 .. :try_end_70e} :catchall_717

    .line 569
    :try_start_70e
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_711
    .catch Ljava/io/IOException; {:try_start_70e .. :try_end_711} :catch_746

    .line 575
    :cond_711
    :goto_711
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 576
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 568
    :catchall_717
    move-exception v5

    .line 569
    :try_start_718
    invoke-virtual/range {v76 .. v76}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_71b
    .catch Ljava/io/IOException; {:try_start_718 .. :try_end_71b} :catch_748

    .line 572
    :goto_71b
    throw v5

    .line 581
    .end local v40           #args:[Ljava/lang/String;
    .end local v76           #fd:Landroid/os/ParcelFileDescriptor;
    :pswitch_71c
    const-string v5, "android.app.IApplicationThread"

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 582
    invoke-virtual/range {p2 .. p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v90

    .line 583
    .local v90, provider:Landroid/os/IBinder;
    move-object/from16 v0, p0

    move-object/from16 v1, v90

    invoke-virtual {v0, v1}, Landroid/app/ApplicationThreadNative;->unstableProviderDied(Landroid/os/IBinder;)V

    .line 584
    invoke-virtual/range {p3 .. p3}, Landroid/os/Parcel;->writeNoException()V

    .line 585
    const/4 v5, 0x1

    goto/16 :goto_7

    .line 350
    .end local v90           #provider:Landroid/os/IBinder;
    .restart local v40       #args:[Ljava/lang/String;
    .restart local v76       #fd:Landroid/os/ParcelFileDescriptor;
    .restart local v93       #service:Landroid/os/IBinder;
    :catch_734
    move-exception v5

    goto/16 :goto_457

    .line 365
    :catch_737
    move-exception v5

    goto/16 :goto_47f

    .line 487
    .end local v93           #service:Landroid/os/IBinder;
    .restart local v67       #activity:Landroid/os/IBinder;
    .restart local v88       #prefix:Ljava/lang/String;
    :catch_73a
    move-exception v5

    goto/16 :goto_62b

    .line 529
    .end local v67           #activity:Landroid/os/IBinder;
    .end local v88           #prefix:Ljava/lang/String;
    .restart local v68       #all:Z
    .restart local v72       #checkin:Z
    .restart local v82       #mi:Landroid/os/Debug$MemoryInfo;
    :catch_73d
    move-exception v5

    goto/16 :goto_6af

    :catch_740
    move-exception v20

    goto :goto_6c7

    .line 550
    .end local v68           #all:Z
    .end local v72           #checkin:Z
    .end local v82           #mi:Landroid/os/Debug$MemoryInfo;
    :catch_742
    move-exception v5

    goto :goto_6e7

    :catch_744
    move-exception v20

    goto :goto_6f1

    .line 570
    :catch_746
    move-exception v5

    goto :goto_711

    :catch_748
    move-exception v20

    goto :goto_71b

    .line 70
    :pswitch_data_74a
    .packed-switch 0x1
        :pswitch_8
        :pswitch_3
        :pswitch_3a
        :pswitch_5f
        :pswitch_9e
        :pswitch_be
        :pswitch_d9
        :pswitch_1a6
        :pswitch_1c1
        :pswitch_1e7
        :pswitch_231
        :pswitch_2de
        :pswitch_2f3
        :pswitch_3a2
        :pswitch_3bc
        :pswitch_3cf
        :pswitch_2a5
        :pswitch_3ea
        :pswitch_425
        :pswitch_25a
        :pswitch_286
        :pswitch_432
        :pswitch_482
        :pswitch_4c9
        :pswitch_4cf
        :pswitch_15c
        :pswitch_7e
        :pswitch_4e2
        :pswitch_519
        :pswitch_52e
        :pswitch_559
        :pswitch_57e
        :pswitch_3af
        :pswitch_59f
        :pswitch_5ba
        :pswitch_5cf
        :pswitch_600
        :pswitch_3f7
        :pswitch_404
        :pswitch_62e
        :pswitch_643
        :pswitch_664
        :pswitch_679
        :pswitch_6c8
        :pswitch_45a
        :pswitch_6f2
        :pswitch_71c
    .end packed-switch
.end method
