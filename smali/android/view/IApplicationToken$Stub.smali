.class public abstract Landroid/view/IApplicationToken$Stub;
.super Landroid/os/Binder;
.source "IApplicationToken.java"

# interfaces
.implements Landroid/view/IApplicationToken;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/IApplicationToken;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/IApplicationToken$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.view.IApplicationToken"

.field static final TRANSACTION_getKeyDispatchingTimeout:I = 0x5

.field static final TRANSACTION_keyDispatchingTimedOut:I = 0x4

.field static final TRANSACTION_windowsDrawn:I = 0x1

.field static final TRANSACTION_windowsGone:I = 0x3

.field static final TRANSACTION_windowsVisible:I = 0x2


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 16
    const-string v0, "android.view.IApplicationToken"

    invoke-virtual {p0, p0, v0}, Landroid/view/IApplicationToken$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 17
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/view/IApplicationToken;
    .registers 3
    .parameter "obj"

    .prologue
    .line 24
    if-nez p0, :cond_4

    .line 25
    const/4 v0, 0x0

    .line 31
    :goto_3
    return-object v0

    .line 27
    :cond_4
    const-string v1, "android.view.IApplicationToken"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 28
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/view/IApplicationToken;

    if-eqz v1, :cond_13

    .line 29
    check-cast v0, Landroid/view/IApplicationToken;

    goto :goto_3

    .line 31
    :cond_13
    new-instance v0, Landroid/view/IApplicationToken$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/view/IApplicationToken$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 35
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
    const/4 v3, 0x1

    .line 39
    sparse-switch p1, :sswitch_data_58

    .line 84
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v3

    :goto_8
    return v3

    .line 43
    :sswitch_9
    const-string v2, "android.view.IApplicationToken"

    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_8

    .line 48
    :sswitch_f
    const-string v2, "android.view.IApplicationToken"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 49
    invoke-virtual {p0}, Landroid/view/IApplicationToken$Stub;->windowsDrawn()V

    .line 50
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .line 55
    :sswitch_1b
    const-string v2, "android.view.IApplicationToken"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 56
    invoke-virtual {p0}, Landroid/view/IApplicationToken$Stub;->windowsVisible()V

    .line 57
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .line 62
    :sswitch_27
    const-string v2, "android.view.IApplicationToken"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 63
    invoke-virtual {p0}, Landroid/view/IApplicationToken$Stub;->windowsGone()V

    .line 64
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .line 69
    :sswitch_33
    const-string v2, "android.view.IApplicationToken"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 70
    invoke-virtual {p0}, Landroid/view/IApplicationToken$Stub;->keyDispatchingTimedOut()Z

    move-result v0

    .line 71
    .local v0, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 72
    if-eqz v0, :cond_46

    move v2, v3

    :goto_42
    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_8

    :cond_46
    const/4 v2, 0x0

    goto :goto_42

    .line 77
    .end local v0           #_result:Z
    :sswitch_48
    const-string v2, "android.view.IApplicationToken"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 78
    invoke-virtual {p0}, Landroid/view/IApplicationToken$Stub;->getKeyDispatchingTimeout()J

    move-result-wide v0

    .line 79
    .local v0, _result:J
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 80
    invoke-virtual {p3, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    goto :goto_8

    .line 39
    :sswitch_data_58
    .sparse-switch
        0x1 -> :sswitch_f
        0x2 -> :sswitch_1b
        0x3 -> :sswitch_27
        0x4 -> :sswitch_33
        0x5 -> :sswitch_48
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
