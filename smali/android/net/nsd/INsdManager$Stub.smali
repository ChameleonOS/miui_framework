.class public abstract Landroid/net/nsd/INsdManager$Stub;
.super Landroid/os/Binder;
.source "INsdManager.java"

# interfaces
.implements Landroid/net/nsd/INsdManager;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/nsd/INsdManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/nsd/INsdManager$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.net.nsd.INsdManager"

.field static final TRANSACTION_getMessenger:I = 0x1

.field static final TRANSACTION_setEnabled:I = 0x2


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 20
    const-string v0, "android.net.nsd.INsdManager"

    invoke-virtual {p0, p0, v0}, Landroid/net/nsd/INsdManager$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 21
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/net/nsd/INsdManager;
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
    const-string v1, "android.net.nsd.INsdManager"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 32
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/net/nsd/INsdManager;

    if-eqz v1, :cond_13

    .line 33
    check-cast v0, Landroid/net/nsd/INsdManager;

    goto :goto_3

    .line 35
    :cond_13
    new-instance v0, Landroid/net/nsd/INsdManager$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/net/nsd/INsdManager$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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
    .registers 9
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

    const/4 v2, 0x1

    .line 43
    sparse-switch p1, :sswitch_data_3c

    .line 74
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v2

    :goto_9
    return v2

    .line 47
    :sswitch_a
    const-string v3, "android.net.nsd.INsdManager"

    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_9

    .line 52
    :sswitch_10
    const-string v3, "android.net.nsd.INsdManager"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 53
    invoke-virtual {p0}, Landroid/net/nsd/INsdManager$Stub;->getMessenger()Landroid/os/Messenger;

    move-result-object v1

    .line 54
    .local v1, _result:Landroid/os/Messenger;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 55
    if-eqz v1, :cond_25

    .line 56
    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 57
    invoke-virtual {v1, p3, v2}, Landroid/os/Messenger;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_9

    .line 60
    :cond_25
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 66
    .end local v1           #_result:Landroid/os/Messenger;
    :sswitch_29
    const-string v3, "android.net.nsd.INsdManager"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 68
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    if-eqz v3, :cond_35

    move v0, v2

    .line 69
    .local v0, _arg0:Z
    :cond_35
    invoke-virtual {p0, v0}, Landroid/net/nsd/INsdManager$Stub;->setEnabled(Z)V

    .line 70
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 43
    :sswitch_data_3c
    .sparse-switch
        0x1 -> :sswitch_10
        0x2 -> :sswitch_29
        0x5f4e5446 -> :sswitch_a
    .end sparse-switch
.end method
