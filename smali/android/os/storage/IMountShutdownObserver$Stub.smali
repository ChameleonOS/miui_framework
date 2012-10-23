.class public abstract Landroid/os/storage/IMountShutdownObserver$Stub;
.super Landroid/os/Binder;
.source "IMountShutdownObserver.java"

# interfaces
.implements Landroid/os/storage/IMountShutdownObserver;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/storage/IMountShutdownObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/os/storage/IMountShutdownObserver$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "IMountShutdownObserver"

.field static final TRANSACTION_onShutDownComplete:I = 0x1


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 37
    const-string v0, "IMountShutdownObserver"

    invoke-virtual {p0, p0, v0}, Landroid/os/storage/IMountShutdownObserver$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 38
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/os/storage/IMountShutdownObserver;
    .registers 3
    .parameter "obj"

    .prologue
    .line 45
    if-nez p0, :cond_4

    .line 46
    const/4 v0, 0x0

    .line 52
    :goto_3
    return-object v0

    .line 48
    :cond_4
    const-string v1, "IMountShutdownObserver"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 49
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/os/storage/IMountShutdownObserver;

    if-eqz v1, :cond_13

    .line 50
    check-cast v0, Landroid/os/storage/IMountShutdownObserver;

    goto :goto_3

    .line 52
    :cond_13
    new-instance v0, Landroid/os/storage/IMountShutdownObserver$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/os/storage/IMountShutdownObserver$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 56
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 8
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
    const/4 v1, 0x1

    .line 62
    sparse-switch p1, :sswitch_data_20

    .line 76
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v1

    :goto_8
    return v1

    .line 64
    :sswitch_9
    const-string v2, "IMountShutdownObserver"

    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_8

    .line 68
    :sswitch_f
    const-string v2, "IMountShutdownObserver"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 70
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 71
    .local v0, statusCode:I
    invoke-virtual {p0, v0}, Landroid/os/storage/IMountShutdownObserver$Stub;->onShutDownComplete(I)V

    .line 72
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .line 62
    nop

    :sswitch_data_20
    .sparse-switch
        0x1 -> :sswitch_f
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
