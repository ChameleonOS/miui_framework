.class public abstract Lcom/android/internal/policy/IFaceLockCallback$Stub;
.super Landroid/os/Binder;
.source "IFaceLockCallback.java"

# interfaces
.implements Lcom/android/internal/policy/IFaceLockCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/policy/IFaceLockCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/policy/IFaceLockCallback$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "com.android.internal.policy.IFaceLockCallback"

.field static final TRANSACTION_cancel:I = 0x2

.field static final TRANSACTION_exposeFallback:I = 0x4

.field static final TRANSACTION_pokeWakelock:I = 0x5

.field static final TRANSACTION_reportFailedAttempt:I = 0x3

.field static final TRANSACTION_unlock:I = 0x1


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 16
    const-string v0, "com.android.internal.policy.IFaceLockCallback"

    invoke-virtual {p0, p0, v0}, Lcom/android/internal/policy/IFaceLockCallback$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 17
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/android/internal/policy/IFaceLockCallback;
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
    const-string v1, "com.android.internal.policy.IFaceLockCallback"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 28
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Lcom/android/internal/policy/IFaceLockCallback;

    if-eqz v1, :cond_13

    .line 29
    check-cast v0, Lcom/android/internal/policy/IFaceLockCallback;

    goto :goto_3

    .line 31
    :cond_13
    new-instance v0, Lcom/android/internal/policy/IFaceLockCallback$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/android/internal/policy/IFaceLockCallback$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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

    .line 39
    sparse-switch p1, :sswitch_data_40

    .line 79
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v1

    :goto_8
    return v1

    .line 43
    :sswitch_9
    const-string v2, "com.android.internal.policy.IFaceLockCallback"

    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_8

    .line 48
    :sswitch_f
    const-string v2, "com.android.internal.policy.IFaceLockCallback"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 49
    invoke-virtual {p0}, Lcom/android/internal/policy/IFaceLockCallback$Stub;->unlock()V

    goto :goto_8

    .line 54
    :sswitch_18
    const-string v2, "com.android.internal.policy.IFaceLockCallback"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 55
    invoke-virtual {p0}, Lcom/android/internal/policy/IFaceLockCallback$Stub;->cancel()V

    goto :goto_8

    .line 60
    :sswitch_21
    const-string v2, "com.android.internal.policy.IFaceLockCallback"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 61
    invoke-virtual {p0}, Lcom/android/internal/policy/IFaceLockCallback$Stub;->reportFailedAttempt()V

    goto :goto_8

    .line 66
    :sswitch_2a
    const-string v2, "com.android.internal.policy.IFaceLockCallback"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 67
    invoke-virtual {p0}, Lcom/android/internal/policy/IFaceLockCallback$Stub;->exposeFallback()V

    goto :goto_8

    .line 72
    :sswitch_33
    const-string v2, "com.android.internal.policy.IFaceLockCallback"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 74
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 75
    .local v0, _arg0:I
    invoke-virtual {p0, v0}, Lcom/android/internal/policy/IFaceLockCallback$Stub;->pokeWakelock(I)V

    goto :goto_8

    .line 39
    :sswitch_data_40
    .sparse-switch
        0x1 -> :sswitch_f
        0x2 -> :sswitch_18
        0x3 -> :sswitch_21
        0x4 -> :sswitch_2a
        0x5 -> :sswitch_33
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
