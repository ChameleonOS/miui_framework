.class public abstract Landroid/location/ICountryDetector$Stub;
.super Landroid/os/Binder;
.source "ICountryDetector.java"

# interfaces
.implements Landroid/location/ICountryDetector;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/location/ICountryDetector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/location/ICountryDetector$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.location.ICountryDetector"

.field static final TRANSACTION_addCountryListener:I = 0x2

.field static final TRANSACTION_detectCountry:I = 0x1

.field static final TRANSACTION_removeCountryListener:I = 0x3


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 20
    const-string v0, "android.location.ICountryDetector"

    invoke-virtual {p0, p0, v0}, Landroid/location/ICountryDetector$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 21
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/location/ICountryDetector;
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
    const-string v1, "android.location.ICountryDetector"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 32
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/location/ICountryDetector;

    if-eqz v1, :cond_13

    .line 33
    check-cast v0, Landroid/location/ICountryDetector;

    goto :goto_3

    .line 35
    :cond_13
    new-instance v0, Landroid/location/ICountryDetector$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/location/ICountryDetector$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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
    const/4 v2, 0x1

    .line 43
    sparse-switch p1, :sswitch_data_52

    .line 83
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v2

    :goto_8
    return v2

    .line 47
    :sswitch_9
    const-string v3, "android.location.ICountryDetector"

    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_8

    .line 52
    :sswitch_f
    const-string v3, "android.location.ICountryDetector"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 53
    invoke-virtual {p0}, Landroid/location/ICountryDetector$Stub;->detectCountry()Landroid/location/Country;

    move-result-object v1

    .line 54
    .local v1, _result:Landroid/location/Country;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 55
    if-eqz v1, :cond_24

    .line 56
    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 57
    invoke-virtual {v1, p3, v2}, Landroid/location/Country;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_8

    .line 60
    :cond_24
    const/4 v3, 0x0

    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_8

    .line 66
    .end local v1           #_result:Landroid/location/Country;
    :sswitch_29
    const-string v3, "android.location.ICountryDetector"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 68
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v3

    invoke-static {v3}, Landroid/location/ICountryListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/location/ICountryListener;

    move-result-object v0

    .line 69
    .local v0, _arg0:Landroid/location/ICountryListener;
    invoke-virtual {p0, v0}, Landroid/location/ICountryDetector$Stub;->addCountryListener(Landroid/location/ICountryListener;)V

    .line 70
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .line 75
    .end local v0           #_arg0:Landroid/location/ICountryListener;
    :sswitch_3d
    const-string v3, "android.location.ICountryDetector"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 77
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v3

    invoke-static {v3}, Landroid/location/ICountryListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/location/ICountryListener;

    move-result-object v0

    .line 78
    .restart local v0       #_arg0:Landroid/location/ICountryListener;
    invoke-virtual {p0, v0}, Landroid/location/ICountryDetector$Stub;->removeCountryListener(Landroid/location/ICountryListener;)V

    .line 79
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_8

    .line 43
    nop

    :sswitch_data_52
    .sparse-switch
        0x1 -> :sswitch_f
        0x2 -> :sswitch_29
        0x3 -> :sswitch_3d
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
