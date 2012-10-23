.class public abstract Lmiui/net/ICloudManagerResponse$Stub;
.super Landroid/os/Binder;
.source "ICloudManagerResponse.java"

# interfaces
.implements Lmiui/net/ICloudManagerResponse;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/net/ICloudManagerResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/net/ICloudManagerResponse$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "miui.net.ICloudManagerResponse"

.field static final TRANSACTION_onError:I = 0x2

.field static final TRANSACTION_onResult:I = 0x1


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 18
    const-string/jumbo v0, "miui.net.ICloudManagerResponse"

    invoke-virtual {p0, p0, v0}, Lmiui/net/ICloudManagerResponse$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lmiui/net/ICloudManagerResponse;
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
    const-string/jumbo v1, "miui.net.ICloudManagerResponse"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 30
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_14

    instance-of v1, v0, Lmiui/net/ICloudManagerResponse;

    if-eqz v1, :cond_14

    .line 31
    check-cast v0, Lmiui/net/ICloudManagerResponse;

    goto :goto_3

    .line 33
    :cond_14
    new-instance v0, Lmiui/net/ICloudManagerResponse$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lmiui/net/ICloudManagerResponse$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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

    .line 41
    sparse-switch p1, :sswitch_data_3c

    .line 72
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v2

    :goto_8
    return v2

    .line 45
    :sswitch_9
    const-string/jumbo v3, "miui.net.ICloudManagerResponse"

    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_8

    .line 50
    :sswitch_10
    const-string/jumbo v3, "miui.net.ICloudManagerResponse"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 52
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    if-eqz v3, :cond_28

    .line 53
    sget-object v3, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v3, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Bundle;

    .line 58
    .local v0, _arg0:Landroid/os/Bundle;
    :goto_24
    invoke-virtual {p0, v0}, Lmiui/net/ICloudManagerResponse$Stub;->onResult(Landroid/os/Bundle;)V

    goto :goto_8

    .line 56
    .end local v0           #_arg0:Landroid/os/Bundle;
    :cond_28
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/os/Bundle;
    goto :goto_24

    .line 63
    .end local v0           #_arg0:Landroid/os/Bundle;
    :sswitch_2a
    const-string/jumbo v3, "miui.net.ICloudManagerResponse"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 65
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 67
    .local v0, _arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 68
    .local v1, _arg1:Ljava/lang/String;
    invoke-virtual {p0, v0, v1}, Lmiui/net/ICloudManagerResponse$Stub;->onError(ILjava/lang/String;)V

    goto :goto_8

    .line 41
    :sswitch_data_3c
    .sparse-switch
        0x1 -> :sswitch_10
        0x2 -> :sswitch_2a
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
