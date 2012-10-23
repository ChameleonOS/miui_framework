.class public abstract Lcom/android/internal/policy/IFaceLockInterface$Stub;
.super Landroid/os/Binder;
.source "IFaceLockInterface.java"

# interfaces
.implements Lcom/android/internal/policy/IFaceLockInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/policy/IFaceLockInterface;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/policy/IFaceLockInterface$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "com.android.internal.policy.IFaceLockInterface"

.field static final TRANSACTION_registerCallback:I = 0x3

.field static final TRANSACTION_startUi:I = 0x1

.field static final TRANSACTION_stopUi:I = 0x2

.field static final TRANSACTION_unregisterCallback:I = 0x4


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 16
    const-string v0, "com.android.internal.policy.IFaceLockInterface"

    invoke-virtual {p0, p0, v0}, Lcom/android/internal/policy/IFaceLockInterface$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 17
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/android/internal/policy/IFaceLockInterface;
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
    const-string v1, "com.android.internal.policy.IFaceLockInterface"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 28
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Lcom/android/internal/policy/IFaceLockInterface;

    if-eqz v1, :cond_13

    .line 29
    check-cast v0, Lcom/android/internal/policy/IFaceLockInterface;

    goto :goto_3

    .line 31
    :cond_13
    new-instance v0, Lcom/android/internal/policy/IFaceLockInterface$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/android/internal/policy/IFaceLockInterface$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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
    .registers 13
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
    const/4 v7, 0x1

    .line 39
    sparse-switch p1, :sswitch_data_6e

    .line 91
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v7

    :goto_8
    return v7

    .line 43
    :sswitch_9
    const-string v0, "com.android.internal.policy.IFaceLockInterface"

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_8

    .line 48
    :sswitch_f
    const-string v0, "com.android.internal.policy.IFaceLockInterface"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 50
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    .line 52
    .local v1, _arg0:Landroid/os/IBinder;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 54
    .local v2, _arg1:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 56
    .local v3, _arg2:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    .line 58
    .local v4, _arg3:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    .line 60
    .local v5, _arg4:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_37

    move v6, v7

    .local v6, _arg5:Z
    :goto_2f
    move-object v0, p0

    .line 61
    invoke-virtual/range {v0 .. v6}, Lcom/android/internal/policy/IFaceLockInterface$Stub;->startUi(Landroid/os/IBinder;IIIIZ)V

    .line 62
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .line 60
    .end local v6           #_arg5:Z
    :cond_37
    const/4 v6, 0x0

    goto :goto_2f

    .line 67
    .end local v1           #_arg0:Landroid/os/IBinder;
    .end local v2           #_arg1:I
    .end local v3           #_arg2:I
    .end local v4           #_arg3:I
    .end local v5           #_arg4:I
    :sswitch_39
    const-string v0, "com.android.internal.policy.IFaceLockInterface"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 68
    invoke-virtual {p0}, Lcom/android/internal/policy/IFaceLockInterface$Stub;->stopUi()V

    .line 69
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .line 74
    :sswitch_45
    const-string v0, "com.android.internal.policy.IFaceLockInterface"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 76
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lcom/android/internal/policy/IFaceLockCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/policy/IFaceLockCallback;

    move-result-object v1

    .line 77
    .local v1, _arg0:Lcom/android/internal/policy/IFaceLockCallback;
    invoke-virtual {p0, v1}, Lcom/android/internal/policy/IFaceLockInterface$Stub;->registerCallback(Lcom/android/internal/policy/IFaceLockCallback;)V

    .line 78
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .line 83
    .end local v1           #_arg0:Lcom/android/internal/policy/IFaceLockCallback;
    :sswitch_59
    const-string v0, "com.android.internal.policy.IFaceLockInterface"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 85
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lcom/android/internal/policy/IFaceLockCallback$Stub;->asInterface(Landroid/os/IBinder;)Lcom/android/internal/policy/IFaceLockCallback;

    move-result-object v1

    .line 86
    .restart local v1       #_arg0:Lcom/android/internal/policy/IFaceLockCallback;
    invoke-virtual {p0, v1}, Lcom/android/internal/policy/IFaceLockInterface$Stub;->unregisterCallback(Lcom/android/internal/policy/IFaceLockCallback;)V

    .line 87
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .line 39
    nop

    :sswitch_data_6e
    .sparse-switch
        0x1 -> :sswitch_f
        0x2 -> :sswitch_39
        0x3 -> :sswitch_45
        0x4 -> :sswitch_59
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
