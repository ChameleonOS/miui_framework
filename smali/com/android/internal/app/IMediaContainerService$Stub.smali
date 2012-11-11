.class public abstract Lcom/android/internal/app/IMediaContainerService$Stub;
.super Landroid/os/Binder;
.source "IMediaContainerService.java"

# interfaces
.implements Lcom/android/internal/app/IMediaContainerService;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/app/IMediaContainerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/app/IMediaContainerService$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "com.android.internal.app.IMediaContainerService"

.field static final TRANSACTION_calculateDirectorySize:I = 0x7

.field static final TRANSACTION_checkExternalFreeStorage:I = 0x5

.field static final TRANSACTION_checkInternalFreeStorage:I = 0x4

.field static final TRANSACTION_clearDirectory:I = 0x9

.field static final TRANSACTION_copyResource:I = 0x2

.field static final TRANSACTION_copyResourceToContainer:I = 0x1

.field static final TRANSACTION_getFileSystemStats:I = 0x8

.field static final TRANSACTION_getMinimalPackageInfo:I = 0x3

.field static final TRANSACTION_getObbInfo:I = 0x6


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    const-string v0, "com.android.internal.app.IMediaContainerService"

    invoke-virtual {p0, p0, v0}, Lcom/android/internal/app/IMediaContainerService$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/android/internal/app/IMediaContainerService;
    .registers 3
    .parameter "obj"

    .prologue
    if-nez p0, :cond_4

    const/4 v0, 0x0

    :goto_3
    return-object v0

    :cond_4
    const-string v1, "com.android.internal.app.IMediaContainerService"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Lcom/android/internal/app/IMediaContainerService;

    if-eqz v1, :cond_13

    check-cast v0, Lcom/android/internal/app/IMediaContainerService;

    goto :goto_3

    :cond_13
    new-instance v0, Lcom/android/internal/app/IMediaContainerService$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/android/internal/app/IMediaContainerService$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 17
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
    sparse-switch p1, :sswitch_data_184

    invoke-super/range {p0 .. p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v0

    :goto_7
    return v0

    :sswitch_8
    const-string v0, "com.android.internal.app.IMediaContainerService"

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    const/4 v0, 0x1

    goto :goto_7

    :sswitch_f
    const-string v0, "com.android.internal.app.IMediaContainerService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_4d

    sget-object v0, Landroid/net/Uri;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .local v1, _arg0:Landroid/net/Uri;
    :goto_22
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .local v2, _arg1:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .local v3, _arg2:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    .local v4, _arg3:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    .local v5, _arg4:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_4f

    const/4 v6, 0x1

    .local v6, _arg5:Z
    :goto_39
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_51

    const/4 v7, 0x1

    .local v7, _arg6:Z
    :goto_40
    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Lcom/android/internal/app/IMediaContainerService$Stub;->copyResourceToContainer(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;

    move-result-object v10

    .local v10, _result:Ljava/lang/String;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    invoke-virtual {p3, v10}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    const/4 v0, 0x1

    goto :goto_7

    .end local v1           #_arg0:Landroid/net/Uri;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v3           #_arg2:Ljava/lang/String;
    .end local v4           #_arg3:Ljava/lang/String;
    .end local v5           #_arg4:Ljava/lang/String;
    .end local v6           #_arg5:Z
    .end local v7           #_arg6:Z
    .end local v10           #_result:Ljava/lang/String;
    :cond_4d
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/net/Uri;
    goto :goto_22

    .restart local v2       #_arg1:Ljava/lang/String;
    .restart local v3       #_arg2:Ljava/lang/String;
    .restart local v4       #_arg3:Ljava/lang/String;
    .restart local v5       #_arg4:Ljava/lang/String;
    :cond_4f
    const/4 v6, 0x0

    goto :goto_39

    .restart local v6       #_arg5:Z
    :cond_51
    const/4 v7, 0x0

    goto :goto_40

    .end local v1           #_arg0:Landroid/net/Uri;
    .end local v2           #_arg1:Ljava/lang/String;
    .end local v3           #_arg2:Ljava/lang/String;
    .end local v4           #_arg3:Ljava/lang/String;
    .end local v5           #_arg4:Ljava/lang/String;
    .end local v6           #_arg5:Z
    :sswitch_53
    const-string v0, "com.android.internal.app.IMediaContainerService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_8f

    sget-object v0, Landroid/net/Uri;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .restart local v1       #_arg0:Landroid/net/Uri;
    :goto_66
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_91

    sget-object v0, Landroid/content/pm/ContainerEncryptionParams;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/pm/ContainerEncryptionParams;

    .local v2, _arg1:Landroid/content/pm/ContainerEncryptionParams;
    :goto_74
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_93

    sget-object v0, Landroid/os/ParcelFileDescriptor;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/os/ParcelFileDescriptor;

    .local v3, _arg2:Landroid/os/ParcelFileDescriptor;
    :goto_82
    invoke-virtual {p0, v1, v2, v3}, Lcom/android/internal/app/IMediaContainerService$Stub;->copyResource(Landroid/net/Uri;Landroid/content/pm/ContainerEncryptionParams;Landroid/os/ParcelFileDescriptor;)I

    move-result v10

    .local v10, _result:I
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    invoke-virtual {p3, v10}, Landroid/os/Parcel;->writeInt(I)V

    const/4 v0, 0x1

    goto/16 :goto_7

    .end local v1           #_arg0:Landroid/net/Uri;
    .end local v2           #_arg1:Landroid/content/pm/ContainerEncryptionParams;
    .end local v3           #_arg2:Landroid/os/ParcelFileDescriptor;
    .end local v10           #_result:I
    :cond_8f
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/net/Uri;
    goto :goto_66

    :cond_91
    const/4 v2, 0x0

    .restart local v2       #_arg1:Landroid/content/pm/ContainerEncryptionParams;
    goto :goto_74

    :cond_93
    const/4 v3, 0x0

    .restart local v3       #_arg2:Landroid/os/ParcelFileDescriptor;
    goto :goto_82

    .end local v1           #_arg0:Landroid/net/Uri;
    .end local v2           #_arg1:Landroid/content/pm/ContainerEncryptionParams;
    .end local v3           #_arg2:Landroid/os/ParcelFileDescriptor;
    :sswitch_95
    const-string v0, "com.android.internal.app.IMediaContainerService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .local v1, _arg0:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .local v2, _arg1:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v8

    .local v8, _arg2:J
    invoke-virtual {p0, v1, v2, v8, v9}, Lcom/android/internal/app/IMediaContainerService$Stub;->getMinimalPackageInfo(Ljava/lang/String;IJ)Landroid/content/pm/PackageInfoLite;

    move-result-object v10

    .local v10, _result:Landroid/content/pm/PackageInfoLite;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    if-eqz v10, :cond_ba

    const/4 v0, 0x1

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    const/4 v0, 0x1

    invoke-virtual {v10, p3, v0}, Landroid/content/pm/PackageInfoLite;->writeToParcel(Landroid/os/Parcel;I)V

    :goto_b7
    const/4 v0, 0x1

    goto/16 :goto_7

    :cond_ba
    const/4 v0, 0x0

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_b7

    .end local v1           #_arg0:Ljava/lang/String;
    .end local v2           #_arg1:I
    .end local v8           #_arg2:J
    .end local v10           #_result:Landroid/content/pm/PackageInfoLite;
    :sswitch_bf
    const-string v0, "com.android.internal.app.IMediaContainerService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_ed

    sget-object v0, Landroid/net/Uri;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .local v1, _arg0:Landroid/net/Uri;
    :goto_d2
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_ef

    const/4 v2, 0x1

    .local v2, _arg1:Z
    :goto_d9
    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v8

    .restart local v8       #_arg2:J
    invoke-virtual {p0, v1, v2, v8, v9}, Lcom/android/internal/app/IMediaContainerService$Stub;->checkInternalFreeStorage(Landroid/net/Uri;ZJ)Z

    move-result v10

    .local v10, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    if-eqz v10, :cond_f1

    const/4 v0, 0x1

    :goto_e7
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    const/4 v0, 0x1

    goto/16 :goto_7

    .end local v1           #_arg0:Landroid/net/Uri;
    .end local v2           #_arg1:Z
    .end local v8           #_arg2:J
    .end local v10           #_result:Z
    :cond_ed
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/net/Uri;
    goto :goto_d2

    :cond_ef
    const/4 v2, 0x0

    goto :goto_d9

    .restart local v2       #_arg1:Z
    .restart local v8       #_arg2:J
    .restart local v10       #_result:Z
    :cond_f1
    const/4 v0, 0x0

    goto :goto_e7

    .end local v1           #_arg0:Landroid/net/Uri;
    .end local v2           #_arg1:Z
    .end local v8           #_arg2:J
    .end local v10           #_result:Z
    :sswitch_f3
    const-string v0, "com.android.internal.app.IMediaContainerService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_11d

    sget-object v0, Landroid/net/Uri;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .restart local v1       #_arg0:Landroid/net/Uri;
    :goto_106
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_11f

    const/4 v2, 0x1

    .restart local v2       #_arg1:Z
    :goto_10d
    invoke-virtual {p0, v1, v2}, Lcom/android/internal/app/IMediaContainerService$Stub;->checkExternalFreeStorage(Landroid/net/Uri;Z)Z

    move-result v10

    .restart local v10       #_result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    if-eqz v10, :cond_121

    const/4 v0, 0x1

    :goto_117
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    const/4 v0, 0x1

    goto/16 :goto_7

    .end local v1           #_arg0:Landroid/net/Uri;
    .end local v2           #_arg1:Z
    .end local v10           #_result:Z
    :cond_11d
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/net/Uri;
    goto :goto_106

    :cond_11f
    const/4 v2, 0x0

    goto :goto_10d

    .restart local v2       #_arg1:Z
    .restart local v10       #_result:Z
    :cond_121
    const/4 v0, 0x0

    goto :goto_117

    .end local v1           #_arg0:Landroid/net/Uri;
    .end local v2           #_arg1:Z
    .end local v10           #_result:Z
    :sswitch_123
    const-string v0, "com.android.internal.app.IMediaContainerService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .local v1, _arg0:Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/android/internal/app/IMediaContainerService$Stub;->getObbInfo(Ljava/lang/String;)Landroid/content/res/ObbInfo;

    move-result-object v10

    .local v10, _result:Landroid/content/res/ObbInfo;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    if-eqz v10, :cond_140

    const/4 v0, 0x1

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    const/4 v0, 0x1

    invoke-virtual {v10, p3, v0}, Landroid/content/res/ObbInfo;->writeToParcel(Landroid/os/Parcel;I)V

    :goto_13d
    const/4 v0, 0x1

    goto/16 :goto_7

    :cond_140
    const/4 v0, 0x0

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_13d

    .end local v1           #_arg0:Ljava/lang/String;
    .end local v10           #_result:Landroid/content/res/ObbInfo;
    :sswitch_145
    const-string v0, "com.android.internal.app.IMediaContainerService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .restart local v1       #_arg0:Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/android/internal/app/IMediaContainerService$Stub;->calculateDirectorySize(Ljava/lang/String;)J

    move-result-wide v10

    .local v10, _result:J
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    invoke-virtual {p3, v10, v11}, Landroid/os/Parcel;->writeLong(J)V

    const/4 v0, 0x1

    goto/16 :goto_7

    .end local v1           #_arg0:Ljava/lang/String;
    .end local v10           #_result:J
    :sswitch_15b
    const-string v0, "com.android.internal.app.IMediaContainerService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .restart local v1       #_arg0:Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/android/internal/app/IMediaContainerService$Stub;->getFileSystemStats(Ljava/lang/String;)[J

    move-result-object v10

    .local v10, _result:[J
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    invoke-virtual {p3, v10}, Landroid/os/Parcel;->writeLongArray([J)V

    const/4 v0, 0x1

    goto/16 :goto_7

    .end local v1           #_arg0:Ljava/lang/String;
    .end local v10           #_result:[J
    :sswitch_171
    const-string v0, "com.android.internal.app.IMediaContainerService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .restart local v1       #_arg0:Ljava/lang/String;
    invoke-virtual {p0, v1}, Lcom/android/internal/app/IMediaContainerService$Stub;->clearDirectory(Ljava/lang/String;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    const/4 v0, 0x1

    goto/16 :goto_7

    nop

    :sswitch_data_184
    .sparse-switch
        0x1 -> :sswitch_f
        0x2 -> :sswitch_53
        0x3 -> :sswitch_95
        0x4 -> :sswitch_bf
        0x5 -> :sswitch_f3
        0x6 -> :sswitch_123
        0x7 -> :sswitch_145
        0x8 -> :sswitch_15b
        0x9 -> :sswitch_171
        0x5f4e5446 -> :sswitch_8
    .end sparse-switch
.end method
