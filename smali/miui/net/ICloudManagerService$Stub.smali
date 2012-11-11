.class public abstract Lmiui/net/ICloudManagerService$Stub;
.super Landroid/os/Binder;
.source "ICloudManagerService.java"

# interfaces
.implements Lmiui/net/ICloudManagerService;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/net/ICloudManagerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/net/ICloudManagerService$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "miui.net.ICloudManagerService"

.field static final TRANSACTION_cancelNotification:I = 0x7

.field static final TRANSACTION_getActivatedPhone:I = 0x1

.field static final TRANSACTION_getActivatedStatus:I = 0x2

.field static final TRANSACTION_getFindDeviceToken:I = 0x6

.field static final TRANSACTION_getSmsGateway:I = 0x4

.field static final TRANSACTION_getSubSyncAutomatically:I = 0x3

.field static final TRANSACTION_getUserSecurity:I = 0x5


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    const-string/jumbo v0, "miui.net.ICloudManagerService"

    invoke-virtual {p0, p0, v0}, Lmiui/net/ICloudManagerService$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lmiui/net/ICloudManagerService;
    .registers 3
    .parameter "obj"

    .prologue
    if-nez p0, :cond_4

    const/4 v0, 0x0

    :goto_3
    return-object v0

    :cond_4
    const-string/jumbo v1, "miui.net.ICloudManagerService"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_14

    instance-of v1, v0, Lmiui/net/ICloudManagerService;

    if-eqz v1, :cond_14

    check-cast v0, Lmiui/net/ICloudManagerService;

    goto :goto_3

    :cond_14
    new-instance v0, Lmiui/net/ICloudManagerService$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lmiui/net/ICloudManagerService$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 10
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
    const/4 v3, 0x1

    sparse-switch p1, :sswitch_data_be

    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v3

    :goto_8
    return v3

    :sswitch_9
    const-string/jumbo v4, "miui.net.ICloudManagerService"

    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_8

    :sswitch_10
    const-string/jumbo v4, "miui.net.ICloudManagerService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lmiui/net/ICloudManagerResponse$Stub;->asInterface(Landroid/os/IBinder;)Lmiui/net/ICloudManagerResponse;

    move-result-object v0

    .local v0, _arg0:Lmiui/net/ICloudManagerResponse;
    invoke-virtual {p0, v0}, Lmiui/net/ICloudManagerService$Stub;->getActivatedPhone(Lmiui/net/ICloudManagerResponse;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .end local v0           #_arg0:Lmiui/net/ICloudManagerResponse;
    :sswitch_25
    const-string/jumbo v4, "miui.net.ICloudManagerService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lmiui/net/ICloudManagerResponse$Stub;->asInterface(Landroid/os/IBinder;)Lmiui/net/ICloudManagerResponse;

    move-result-object v0

    .restart local v0       #_arg0:Lmiui/net/ICloudManagerResponse;
    invoke-virtual {p0, v0}, Lmiui/net/ICloudManagerService$Stub;->getActivatedStatus(Lmiui/net/ICloudManagerResponse;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .end local v0           #_arg0:Lmiui/net/ICloudManagerResponse;
    :sswitch_3a
    const-string/jumbo v4, "miui.net.ICloudManagerService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_61

    sget-object v4, Landroid/accounts/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/accounts/Account;

    .local v0, _arg0:Landroid/accounts/Account;
    :goto_4e
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .local v1, _arg1:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lmiui/net/ICloudManagerResponse$Stub;->asInterface(Landroid/os/IBinder;)Lmiui/net/ICloudManagerResponse;

    move-result-object v2

    .local v2, _arg2:Lmiui/net/ICloudManagerResponse;
    invoke-virtual {p0, v0, v1, v2}, Lmiui/net/ICloudManagerService$Stub;->getSubSyncAutomatically(Landroid/accounts/Account;Ljava/lang/String;Lmiui/net/ICloudManagerResponse;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .end local v0           #_arg0:Landroid/accounts/Account;
    .end local v1           #_arg1:Ljava/lang/String;
    .end local v2           #_arg2:Lmiui/net/ICloudManagerResponse;
    :cond_61
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/accounts/Account;
    goto :goto_4e

    .end local v0           #_arg0:Landroid/accounts/Account;
    :sswitch_63
    const-string/jumbo v4, "miui.net.ICloudManagerService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lmiui/net/ICloudManagerResponse$Stub;->asInterface(Landroid/os/IBinder;)Lmiui/net/ICloudManagerResponse;

    move-result-object v0

    .local v0, _arg0:Lmiui/net/ICloudManagerResponse;
    invoke-virtual {p0, v0}, Lmiui/net/ICloudManagerService$Stub;->getSmsGateway(Lmiui/net/ICloudManagerResponse;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .end local v0           #_arg0:Lmiui/net/ICloudManagerResponse;
    :sswitch_78
    const-string/jumbo v4, "miui.net.ICloudManagerService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lmiui/net/ICloudManagerResponse$Stub;->asInterface(Landroid/os/IBinder;)Lmiui/net/ICloudManagerResponse;

    move-result-object v0

    .restart local v0       #_arg0:Lmiui/net/ICloudManagerResponse;
    invoke-virtual {p0, v0}, Lmiui/net/ICloudManagerService$Stub;->getUserSecurity(Lmiui/net/ICloudManagerResponse;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_8

    .end local v0           #_arg0:Lmiui/net/ICloudManagerResponse;
    :sswitch_8e
    const-string/jumbo v4, "miui.net.ICloudManagerService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lmiui/net/ICloudManagerResponse$Stub;->asInterface(Landroid/os/IBinder;)Lmiui/net/ICloudManagerResponse;

    move-result-object v0

    .restart local v0       #_arg0:Lmiui/net/ICloudManagerResponse;
    invoke-virtual {p0, v0}, Lmiui/net/ICloudManagerService$Stub;->getFindDeviceToken(Lmiui/net/ICloudManagerResponse;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_8

    .end local v0           #_arg0:Lmiui/net/ICloudManagerResponse;
    :sswitch_a4
    const-string/jumbo v4, "miui.net.ICloudManagerService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .local v0, _arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Lmiui/net/ICloudManagerResponse$Stub;->asInterface(Landroid/os/IBinder;)Lmiui/net/ICloudManagerResponse;

    move-result-object v1

    .local v1, _arg1:Lmiui/net/ICloudManagerResponse;
    invoke-virtual {p0, v0, v1}, Lmiui/net/ICloudManagerService$Stub;->cancelNotification(ILmiui/net/ICloudManagerResponse;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_8

    :sswitch_data_be
    .sparse-switch
        0x1 -> :sswitch_10
        0x2 -> :sswitch_25
        0x3 -> :sswitch_3a
        0x4 -> :sswitch_63
        0x5 -> :sswitch_78
        0x6 -> :sswitch_8e
        0x7 -> :sswitch_a4
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
