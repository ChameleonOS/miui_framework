.class public abstract Landroid/os/ServiceManagerNative;
.super Landroid/os/Binder;
.source "ServiceManagerNative.java"

# interfaces
.implements Landroid/os/IServiceManager;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 48
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 49
    const-string v0, "android.os.IServiceManager"

    invoke-virtual {p0, p0, v0}, Landroid/os/ServiceManagerNative;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 50
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/os/IServiceManager;
    .registers 3
    .parameter "obj"

    .prologue
    .line 35
    if-nez p0, :cond_4

    .line 36
    const/4 v0, 0x0

    .line 44
    :cond_3
    :goto_3
    return-object v0

    .line 38
    :cond_4
    const-string v1, "android.os.IServiceManager"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Landroid/os/IServiceManager;

    .line 40
    .local v0, in:Landroid/os/IServiceManager;
    if-nez v0, :cond_3

    .line 44
    new-instance v0, Landroid/os/ServiceManagerProxy;

    .end local v0           #in:Landroid/os/IServiceManager;
    invoke-direct {v0, p0}, Landroid/os/ServiceManagerProxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 105
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 13
    .parameter "code"
    .parameter "data"
    .parameter "reply"
    .parameter "flags"

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 55
    packed-switch p1, :pswitch_data_64

    :goto_5
    :pswitch_5
    move v5, v6

    .line 100
    :goto_6
    return v5

    .line 57
    :pswitch_7
    :try_start_7
    const-string v7, "android.os.IServiceManager"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 58
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 59
    .local v3, name:Ljava/lang/String;
    invoke-virtual {p0, v3}, Landroid/os/ServiceManagerNative;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v4

    .line 60
    .local v4, service:Landroid/os/IBinder;
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    goto :goto_6

    .line 97
    .end local v3           #name:Ljava/lang/String;
    .end local v4           #service:Landroid/os/IBinder;
    :catch_18
    move-exception v5

    goto :goto_5

    .line 65
    :pswitch_1a
    const-string v7, "android.os.IServiceManager"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 66
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 67
    .restart local v3       #name:Ljava/lang/String;
    invoke-virtual {p0, v3}, Landroid/os/ServiceManagerNative;->checkService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v4

    .line 68
    .restart local v4       #service:Landroid/os/IBinder;
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    goto :goto_6

    .line 73
    .end local v3           #name:Ljava/lang/String;
    .end local v4           #service:Landroid/os/IBinder;
    :pswitch_2b
    const-string v7, "android.os.IServiceManager"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 74
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 75
    .restart local v3       #name:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    .line 76
    .restart local v4       #service:Landroid/os/IBinder;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v7

    if-eqz v7, :cond_43

    move v0, v5

    .line 77
    .local v0, allowIsolated:Z
    :goto_3f
    invoke-virtual {p0, v3, v4, v0}, Landroid/os/ServiceManagerNative;->addService(Ljava/lang/String;Landroid/os/IBinder;Z)V

    goto :goto_6

    .end local v0           #allowIsolated:Z
    :cond_43
    move v0, v6

    .line 76
    goto :goto_3f

    .line 82
    .end local v3           #name:Ljava/lang/String;
    .end local v4           #service:Landroid/os/IBinder;
    :pswitch_45
    const-string v7, "android.os.IServiceManager"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 83
    invoke-virtual {p0}, Landroid/os/ServiceManagerNative;->listServices()[Ljava/lang/String;

    move-result-object v2

    .line 84
    .local v2, list:[Ljava/lang/String;
    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeStringArray([Ljava/lang/String;)V

    goto :goto_6

    .line 89
    .end local v2           #list:[Ljava/lang/String;
    :pswitch_52
    const-string v7, "android.os.IServiceManager"

    invoke-virtual {p2, v7}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 90
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v7

    invoke-static {v7}, Landroid/os/IPermissionController$Stub;->asInterface(Landroid/os/IBinder;)Landroid/os/IPermissionController;

    move-result-object v1

    .line 93
    .local v1, controller:Landroid/os/IPermissionController;
    invoke-virtual {p0, v1}, Landroid/os/ServiceManagerNative;->setPermissionController(Landroid/os/IPermissionController;)V
    :try_end_62
    .catch Landroid/os/RemoteException; {:try_start_7 .. :try_end_62} :catch_18

    goto :goto_6

    .line 55
    nop

    :pswitch_data_64
    .packed-switch 0x1
        :pswitch_7
        :pswitch_1a
        :pswitch_2b
        :pswitch_45
        :pswitch_5
        :pswitch_52
    .end packed-switch
.end method
