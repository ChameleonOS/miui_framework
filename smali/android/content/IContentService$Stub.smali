.class public abstract Landroid/content/IContentService$Stub;
.super Landroid/os/Binder;
.source "IContentService.java"

# interfaces
.implements Landroid/content/IContentService;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/IContentService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/content/IContentService$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.content.IContentService"

.field static final TRANSACTION_addPeriodicSync:I = 0x9

.field static final TRANSACTION_addStatusChangeListener:I = 0x14

.field static final TRANSACTION_cancelSync:I = 0x5

.field static final TRANSACTION_getCurrentSyncs:I = 0x10

.field static final TRANSACTION_getIsSyncable:I = 0xb

.field static final TRANSACTION_getMasterSyncAutomatically:I = 0xe

.field static final TRANSACTION_getPeriodicSyncs:I = 0x8

.field static final TRANSACTION_getSyncAdapterTypes:I = 0x11

.field static final TRANSACTION_getSyncAutomatically:I = 0x6

.field static final TRANSACTION_getSyncStatus:I = 0x12

.field static final TRANSACTION_isSyncActive:I = 0xf

.field static final TRANSACTION_isSyncPending:I = 0x13

.field static final TRANSACTION_notifyChange:I = 0x3

.field static final TRANSACTION_registerContentObserver:I = 0x1

.field static final TRANSACTION_removePeriodicSync:I = 0xa

.field static final TRANSACTION_removeStatusChangeListener:I = 0x15

.field static final TRANSACTION_requestSync:I = 0x4

.field static final TRANSACTION_setIsSyncable:I = 0xc

.field static final TRANSACTION_setMasterSyncAutomatically:I = 0xd

.field static final TRANSACTION_setSyncAutomatically:I = 0x7

.field static final TRANSACTION_unregisterContentObserver:I = 0x2


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 18
    const-string v0, "android.content.IContentService"

    invoke-virtual {p0, p0, v0}, Landroid/content/IContentService$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/content/IContentService;
    .registers 3
    .parameter "obj"

    .prologue
    .line 26
    if-nez p0, :cond_4

    .line 27
    const/4 v0, 0x0

    .line 33
    :goto_3
    return-object v0

    .line 29
    :cond_4
    const-string v1, "android.content.IContentService"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 30
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/content/IContentService;

    if-eqz v1, :cond_13

    .line 31
    check-cast v0, Landroid/content/IContentService;

    goto :goto_3

    .line 33
    :cond_13
    new-instance v0, Landroid/content/IContentService$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/content/IContentService$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 37
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 16
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
    const/4 v0, 0x0

    const/4 v9, 0x1

    .line 41
    sparse-switch p1, :sswitch_data_2fa

    .line 380
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v9

    :goto_9
    return v9

    .line 45
    :sswitch_a
    const-string v0, "android.content.IContentService"

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_9

    .line 50
    :sswitch_10
    const-string v10, "android.content.IContentService"

    invoke-virtual {p2, v10}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 52
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v10

    if-eqz v10, :cond_39

    .line 53
    sget-object v10, Landroid/net/Uri;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v10, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .line 59
    .local v1, _arg0:Landroid/net/Uri;
    :goto_23
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v10

    if-eqz v10, :cond_3b

    move v2, v9

    .line 61
    .local v2, _arg1:Z
    :goto_2a
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/database/IContentObserver$Stub;->asInterface(Landroid/os/IBinder;)Landroid/database/IContentObserver;

    move-result-object v3

    .line 62
    .local v3, _arg2:Landroid/database/IContentObserver;
    invoke-virtual {p0, v1, v2, v3}, Landroid/content/IContentService$Stub;->registerContentObserver(Landroid/net/Uri;ZLandroid/database/IContentObserver;)V

    .line 63
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 56
    .end local v1           #_arg0:Landroid/net/Uri;
    .end local v2           #_arg1:Z
    .end local v3           #_arg2:Landroid/database/IContentObserver;
    :cond_39
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/net/Uri;
    goto :goto_23

    :cond_3b
    move v2, v0

    .line 59
    goto :goto_2a

    .line 68
    .end local v1           #_arg0:Landroid/net/Uri;
    :sswitch_3d
    const-string v0, "android.content.IContentService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 70
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/database/IContentObserver$Stub;->asInterface(Landroid/os/IBinder;)Landroid/database/IContentObserver;

    move-result-object v1

    .line 71
    .local v1, _arg0:Landroid/database/IContentObserver;
    invoke-virtual {p0, v1}, Landroid/content/IContentService$Stub;->unregisterContentObserver(Landroid/database/IContentObserver;)V

    .line 72
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 77
    .end local v1           #_arg0:Landroid/database/IContentObserver;
    :sswitch_51
    const-string v10, "android.content.IContentService"

    invoke-virtual {p2, v10}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 79
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v10

    if-eqz v10, :cond_81

    .line 80
    sget-object v10, Landroid/net/Uri;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v10, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .line 86
    .local v1, _arg0:Landroid/net/Uri;
    :goto_64
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v10

    invoke-static {v10}, Landroid/database/IContentObserver$Stub;->asInterface(Landroid/os/IBinder;)Landroid/database/IContentObserver;

    move-result-object v2

    .line 88
    .local v2, _arg1:Landroid/database/IContentObserver;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v10

    if-eqz v10, :cond_83

    move v3, v9

    .line 90
    .local v3, _arg2:Z
    :goto_73
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v10

    if-eqz v10, :cond_85

    move v4, v9

    .line 91
    .local v4, _arg3:Z
    :goto_7a
    invoke-virtual {p0, v1, v2, v3, v4}, Landroid/content/IContentService$Stub;->notifyChange(Landroid/net/Uri;Landroid/database/IContentObserver;ZZ)V

    .line 92
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 83
    .end local v1           #_arg0:Landroid/net/Uri;
    .end local v2           #_arg1:Landroid/database/IContentObserver;
    .end local v3           #_arg2:Z
    .end local v4           #_arg3:Z
    :cond_81
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/net/Uri;
    goto :goto_64

    .restart local v2       #_arg1:Landroid/database/IContentObserver;
    :cond_83
    move v3, v0

    .line 88
    goto :goto_73

    .restart local v3       #_arg2:Z
    :cond_85
    move v4, v0

    .line 90
    goto :goto_7a

    .line 97
    .end local v1           #_arg0:Landroid/net/Uri;
    .end local v2           #_arg1:Landroid/database/IContentObserver;
    .end local v3           #_arg2:Z
    :sswitch_87
    const-string v0, "android.content.IContentService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 99
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_b4

    .line 100
    sget-object v0, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 106
    .local v1, _arg0:Landroid/accounts/Account;
    :goto_9a
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 108
    .local v2, _arg1:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_b6

    .line 109
    sget-object v0, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/os/Bundle;

    .line 114
    .local v3, _arg2:Landroid/os/Bundle;
    :goto_ac
    invoke-virtual {p0, v1, v2, v3}, Landroid/content/IContentService$Stub;->requestSync(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 115
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 103
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v3           #_arg2:Landroid/os/Bundle;
    :cond_b4
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/accounts/Account;
    goto :goto_9a

    .line 112
    .restart local v2       #_arg1:Ljava/lang/String;
    :cond_b6
    const/4 v3, 0x0

    .restart local v3       #_arg2:Landroid/os/Bundle;
    goto :goto_ac

    .line 120
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v3           #_arg2:Landroid/os/Bundle;
    :sswitch_b8
    const-string v0, "android.content.IContentService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 122
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_d7

    .line 123
    sget-object v0, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 129
    .restart local v1       #_arg0:Landroid/accounts/Account;
    :goto_cb
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 130
    .restart local v2       #_arg1:Ljava/lang/String;
    invoke-virtual {p0, v1, v2}, Landroid/content/IContentService$Stub;->cancelSync(Landroid/accounts/Account;Ljava/lang/String;)V

    .line 131
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 126
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    :cond_d7
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/accounts/Account;
    goto :goto_cb

    .line 136
    .end local v1           #_arg0:Landroid/accounts/Account;
    :sswitch_d9
    const-string v10, "android.content.IContentService"

    invoke-virtual {p2, v10}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 138
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v10

    if-eqz v10, :cond_ff

    .line 139
    sget-object v10, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v10, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 145
    .restart local v1       #_arg0:Landroid/accounts/Account;
    :goto_ec
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 146
    .restart local v2       #_arg1:Ljava/lang/String;
    invoke-virtual {p0, v1, v2}, Landroid/content/IContentService$Stub;->getSyncAutomatically(Landroid/accounts/Account;Ljava/lang/String;)Z

    move-result v6

    .line 147
    .local v6, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 148
    if-eqz v6, :cond_fa

    move v0, v9

    :cond_fa
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_9

    .line 142
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v6           #_result:Z
    :cond_ff
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/accounts/Account;
    goto :goto_ec

    .line 153
    .end local v1           #_arg0:Landroid/accounts/Account;
    :sswitch_101
    const-string v10, "android.content.IContentService"

    invoke-virtual {p2, v10}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 155
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v10

    if-eqz v10, :cond_127

    .line 156
    sget-object v10, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v10, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 162
    .restart local v1       #_arg0:Landroid/accounts/Account;
    :goto_114
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 164
    .restart local v2       #_arg1:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v10

    if-eqz v10, :cond_129

    move v3, v9

    .line 165
    .local v3, _arg2:Z
    :goto_11f
    invoke-virtual {p0, v1, v2, v3}, Landroid/content/IContentService$Stub;->setSyncAutomatically(Landroid/accounts/Account;Ljava/lang/String;Z)V

    .line 166
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 159
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v3           #_arg2:Z
    :cond_127
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/accounts/Account;
    goto :goto_114

    .restart local v2       #_arg1:Ljava/lang/String;
    :cond_129
    move v3, v0

    .line 164
    goto :goto_11f

    .line 171
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    :sswitch_12b
    const-string v0, "android.content.IContentService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 173
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_14e

    .line 174
    sget-object v0, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 180
    .restart local v1       #_arg0:Landroid/accounts/Account;
    :goto_13e
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 181
    .restart local v2       #_arg1:Ljava/lang/String;
    invoke-virtual {p0, v1, v2}, Landroid/content/IContentService$Stub;->getPeriodicSyncs(Landroid/accounts/Account;Ljava/lang/String;)Ljava/util/List;

    move-result-object v7

    .line 182
    .local v7, _result:Ljava/util/List;,"Ljava/util/List<Landroid/content/PeriodicSync;>;"
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 183
    invoke-virtual {p3, v7}, Landroid/os/Parcel;->writeTypedList(Ljava/util/List;)V

    goto/16 :goto_9

    .line 177
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v7           #_result:Ljava/util/List;,"Ljava/util/List<Landroid/content/PeriodicSync;>;"
    :cond_14e
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/accounts/Account;
    goto :goto_13e

    .line 188
    .end local v1           #_arg0:Landroid/accounts/Account;
    :sswitch_150
    const-string v0, "android.content.IContentService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 190
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_182

    .line 191
    sget-object v0, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 197
    .restart local v1       #_arg0:Landroid/accounts/Account;
    :goto_163
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 199
    .restart local v2       #_arg1:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_184

    .line 200
    sget-object v0, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/os/Bundle;

    .line 206
    .local v3, _arg2:Landroid/os/Bundle;
    :goto_175
    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    .local v4, _arg3:J
    move-object v0, p0

    .line 207
    invoke-virtual/range {v0 .. v5}, Landroid/content/IContentService$Stub;->addPeriodicSync(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;J)V

    .line 208
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 194
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v3           #_arg2:Landroid/os/Bundle;
    .end local v4           #_arg3:J
    :cond_182
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/accounts/Account;
    goto :goto_163

    .line 203
    .restart local v2       #_arg1:Ljava/lang/String;
    :cond_184
    const/4 v3, 0x0

    .restart local v3       #_arg2:Landroid/os/Bundle;
    goto :goto_175

    .line 213
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v3           #_arg2:Landroid/os/Bundle;
    :sswitch_186
    const-string v0, "android.content.IContentService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 215
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_1b3

    .line 216
    sget-object v0, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 222
    .restart local v1       #_arg0:Landroid/accounts/Account;
    :goto_199
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 224
    .restart local v2       #_arg1:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_1b5

    .line 225
    sget-object v0, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/os/Bundle;

    .line 230
    .restart local v3       #_arg2:Landroid/os/Bundle;
    :goto_1ab
    invoke-virtual {p0, v1, v2, v3}, Landroid/content/IContentService$Stub;->removePeriodicSync(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 231
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 219
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v3           #_arg2:Landroid/os/Bundle;
    :cond_1b3
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/accounts/Account;
    goto :goto_199

    .line 228
    .restart local v2       #_arg1:Ljava/lang/String;
    :cond_1b5
    const/4 v3, 0x0

    .restart local v3       #_arg2:Landroid/os/Bundle;
    goto :goto_1ab

    .line 236
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v3           #_arg2:Landroid/os/Bundle;
    :sswitch_1b7
    const-string v0, "android.content.IContentService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 238
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_1da

    .line 239
    sget-object v0, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 245
    .restart local v1       #_arg0:Landroid/accounts/Account;
    :goto_1ca
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 246
    .restart local v2       #_arg1:Ljava/lang/String;
    invoke-virtual {p0, v1, v2}, Landroid/content/IContentService$Stub;->getIsSyncable(Landroid/accounts/Account;Ljava/lang/String;)I

    move-result v6

    .line 247
    .local v6, _result:I
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 248
    invoke-virtual {p3, v6}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_9

    .line 242
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v6           #_result:I
    :cond_1da
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/accounts/Account;
    goto :goto_1ca

    .line 253
    .end local v1           #_arg0:Landroid/accounts/Account;
    :sswitch_1dc
    const-string v0, "android.content.IContentService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 255
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_1ff

    .line 256
    sget-object v0, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 262
    .restart local v1       #_arg0:Landroid/accounts/Account;
    :goto_1ef
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 264
    .restart local v2       #_arg1:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 265
    .local v3, _arg2:I
    invoke-virtual {p0, v1, v2, v3}, Landroid/content/IContentService$Stub;->setIsSyncable(Landroid/accounts/Account;Ljava/lang/String;I)V

    .line 266
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 259
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v3           #_arg2:I
    :cond_1ff
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/accounts/Account;
    goto :goto_1ef

    .line 271
    .end local v1           #_arg0:Landroid/accounts/Account;
    :sswitch_201
    const-string v10, "android.content.IContentService"

    invoke-virtual {p2, v10}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 273
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v10

    if-eqz v10, :cond_215

    move v1, v9

    .line 274
    .local v1, _arg0:Z
    :goto_20d
    invoke-virtual {p0, v1}, Landroid/content/IContentService$Stub;->setMasterSyncAutomatically(Z)V

    .line 275
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .end local v1           #_arg0:Z
    :cond_215
    move v1, v0

    .line 273
    goto :goto_20d

    .line 280
    :sswitch_217
    const-string v10, "android.content.IContentService"

    invoke-virtual {p2, v10}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 281
    invoke-virtual {p0}, Landroid/content/IContentService$Stub;->getMasterSyncAutomatically()Z

    move-result v6

    .line 282
    .local v6, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 283
    if-eqz v6, :cond_226

    move v0, v9

    :cond_226
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_9

    .line 288
    .end local v6           #_result:Z
    :sswitch_22b
    const-string v10, "android.content.IContentService"

    invoke-virtual {p2, v10}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 290
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v10

    if-eqz v10, :cond_251

    .line 291
    sget-object v10, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v10, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 297
    .local v1, _arg0:Landroid/accounts/Account;
    :goto_23e
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 298
    .restart local v2       #_arg1:Ljava/lang/String;
    invoke-virtual {p0, v1, v2}, Landroid/content/IContentService$Stub;->isSyncActive(Landroid/accounts/Account;Ljava/lang/String;)Z

    move-result v6

    .line 299
    .restart local v6       #_result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 300
    if-eqz v6, :cond_24c

    move v0, v9

    :cond_24c
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_9

    .line 294
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v6           #_result:Z
    :cond_251
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/accounts/Account;
    goto :goto_23e

    .line 305
    .end local v1           #_arg0:Landroid/accounts/Account;
    :sswitch_253
    const-string v0, "android.content.IContentService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 306
    invoke-virtual {p0}, Landroid/content/IContentService$Stub;->getCurrentSyncs()Ljava/util/List;

    move-result-object v8

    .line 307
    .local v8, _result:Ljava/util/List;,"Ljava/util/List<Landroid/content/SyncInfo;>;"
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 308
    invoke-virtual {p3, v8}, Landroid/os/Parcel;->writeTypedList(Ljava/util/List;)V

    goto/16 :goto_9

    .line 313
    .end local v8           #_result:Ljava/util/List;,"Ljava/util/List<Landroid/content/SyncInfo;>;"
    :sswitch_264
    const-string v0, "android.content.IContentService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 314
    invoke-virtual {p0}, Landroid/content/IContentService$Stub;->getSyncAdapterTypes()[Landroid/content/SyncAdapterType;

    move-result-object v6

    .line 315
    .local v6, _result:[Landroid/content/SyncAdapterType;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 316
    invoke-virtual {p3, v6, v9}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    goto/16 :goto_9

    .line 321
    .end local v6           #_result:[Landroid/content/SyncAdapterType;
    :sswitch_275
    const-string v10, "android.content.IContentService"

    invoke-virtual {p2, v10}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 323
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v10

    if-eqz v10, :cond_29d

    .line 324
    sget-object v10, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v10, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 330
    .restart local v1       #_arg0:Landroid/accounts/Account;
    :goto_288
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 331
    .restart local v2       #_arg1:Ljava/lang/String;
    invoke-virtual {p0, v1, v2}, Landroid/content/IContentService$Stub;->getSyncStatus(Landroid/accounts/Account;Ljava/lang/String;)Landroid/content/SyncStatusInfo;

    move-result-object v6

    .line 332
    .local v6, _result:Landroid/content/SyncStatusInfo;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 333
    if-eqz v6, :cond_29f

    .line 334
    invoke-virtual {p3, v9}, Landroid/os/Parcel;->writeInt(I)V

    .line 335
    invoke-virtual {v6, p3, v9}, Landroid/content/SyncStatusInfo;->writeToParcel(Landroid/os/Parcel;I)V

    goto/16 :goto_9

    .line 327
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v6           #_result:Landroid/content/SyncStatusInfo;
    :cond_29d
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/accounts/Account;
    goto :goto_288

    .line 338
    .restart local v2       #_arg1:Ljava/lang/String;
    .restart local v6       #_result:Landroid/content/SyncStatusInfo;
    :cond_29f
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_9

    .line 344
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v6           #_result:Landroid/content/SyncStatusInfo;
    :sswitch_2a4
    const-string v10, "android.content.IContentService"

    invoke-virtual {p2, v10}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 346
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v10

    if-eqz v10, :cond_2ca

    .line 347
    sget-object v10, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v10, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 353
    .restart local v1       #_arg0:Landroid/accounts/Account;
    :goto_2b7
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 354
    .restart local v2       #_arg1:Ljava/lang/String;
    invoke-virtual {p0, v1, v2}, Landroid/content/IContentService$Stub;->isSyncPending(Landroid/accounts/Account;Ljava/lang/String;)Z

    move-result v6

    .line 355
    .local v6, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 356
    if-eqz v6, :cond_2c5

    move v0, v9

    :cond_2c5
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_9

    .line 350
    .end local v1           #_arg0:Landroid/accounts/Account;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v6           #_result:Z
    :cond_2ca
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/accounts/Account;
    goto :goto_2b7

    .line 361
    .end local v1           #_arg0:Landroid/accounts/Account;
    :sswitch_2cc
    const-string v0, "android.content.IContentService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 363
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 365
    .local v1, _arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/content/ISyncStatusObserver$Stub;->asInterface(Landroid/os/IBinder;)Landroid/content/ISyncStatusObserver;

    move-result-object v2

    .line 366
    .local v2, _arg1:Landroid/content/ISyncStatusObserver;
    invoke-virtual {p0, v1, v2}, Landroid/content/IContentService$Stub;->addStatusChangeListener(ILandroid/content/ISyncStatusObserver;)V

    .line 367
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 372
    .end local v1           #_arg0:I
    .end local v2           #_arg1:Landroid/content/ISyncStatusObserver;
    :sswitch_2e5
    const-string v0, "android.content.IContentService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 374
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/content/ISyncStatusObserver$Stub;->asInterface(Landroid/os/IBinder;)Landroid/content/ISyncStatusObserver;

    move-result-object v1

    .line 375
    .local v1, _arg0:Landroid/content/ISyncStatusObserver;
    invoke-virtual {p0, v1}, Landroid/content/IContentService$Stub;->removeStatusChangeListener(Landroid/content/ISyncStatusObserver;)V

    .line 376
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 41
    :sswitch_data_2fa
    .sparse-switch
        0x1 -> :sswitch_10
        0x2 -> :sswitch_3d
        0x3 -> :sswitch_51
        0x4 -> :sswitch_87
        0x5 -> :sswitch_b8
        0x6 -> :sswitch_d9
        0x7 -> :sswitch_101
        0x8 -> :sswitch_12b
        0x9 -> :sswitch_150
        0xa -> :sswitch_186
        0xb -> :sswitch_1b7
        0xc -> :sswitch_1dc
        0xd -> :sswitch_201
        0xe -> :sswitch_217
        0xf -> :sswitch_22b
        0x10 -> :sswitch_253
        0x11 -> :sswitch_264
        0x12 -> :sswitch_275
        0x13 -> :sswitch_2a4
        0x14 -> :sswitch_2cc
        0x15 -> :sswitch_2e5
        0x5f4e5446 -> :sswitch_a
    .end sparse-switch
.end method
