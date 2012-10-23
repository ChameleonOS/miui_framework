.class public abstract Lmiui/net/IFirewall$Stub;
.super Landroid/os/Binder;
.source "IFirewall.java"

# interfaces
.implements Lmiui/net/IFirewall;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/net/IFirewall;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/net/IFirewall$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "miui.net.IFirewall"

.field static final TRANSACTION_addAccessControlPass:I = 0x5

.field static final TRANSACTION_addOneShotFlag:I = 0x8

.field static final TRANSACTION_checkAccessControlPass:I = 0x7

.field static final TRANSACTION_getOneShotFlag:I = 0x9

.field static final TRANSACTION_onDataConnected:I = 0x3

.field static final TRANSACTION_onDataDisconnected:I = 0x4

.field static final TRANSACTION_onStartUsingNetworkFeature:I = 0x1

.field static final TRANSACTION_onStopUsingNetworkFeature:I = 0x2

.field static final TRANSACTION_removeAccessControlPass:I = 0x6


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 18
    const-string/jumbo v0, "miui.net.IFirewall"

    invoke-virtual {p0, p0, v0}, Lmiui/net/IFirewall$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lmiui/net/IFirewall;
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
    const-string/jumbo v1, "miui.net.IFirewall"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 30
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_14

    instance-of v1, v0, Lmiui/net/IFirewall;

    if-eqz v1, :cond_14

    .line 31
    check-cast v0, Lmiui/net/IFirewall;

    goto :goto_3

    .line 33
    :cond_14
    new-instance v0, Lmiui/net/IFirewall$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lmiui/net/IFirewall$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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
    .registers 12
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
    const/4 v4, 0x0

    const/4 v5, 0x1

    .line 41
    sparse-switch p1, :sswitch_data_d8

    .line 146
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v5

    :goto_9
    return v5

    .line 45
    :sswitch_a
    const-string/jumbo v4, "miui.net.IFirewall"

    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_9

    .line 50
    :sswitch_11
    const-string/jumbo v4, "miui.net.IFirewall"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 52
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 54
    .local v0, _arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 56
    .local v1, _arg1:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 57
    .local v2, _arg2:I
    invoke-virtual {p0, v0, v1, v2}, Lmiui/net/IFirewall$Stub;->onStartUsingNetworkFeature(III)V

    .line 58
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 63
    .end local v0           #_arg0:I
    .end local v1           #_arg1:I
    .end local v2           #_arg2:I
    :sswitch_2a
    const-string/jumbo v4, "miui.net.IFirewall"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 65
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 67
    .restart local v0       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 69
    .restart local v1       #_arg1:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 70
    .restart local v2       #_arg2:I
    invoke-virtual {p0, v0, v1, v2}, Lmiui/net/IFirewall$Stub;->onStopUsingNetworkFeature(III)V

    .line 71
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 76
    .end local v0           #_arg0:I
    .end local v1           #_arg1:I
    .end local v2           #_arg2:I
    :sswitch_43
    const-string/jumbo v4, "miui.net.IFirewall"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 78
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 80
    .restart local v0       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 82
    .local v1, _arg1:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 83
    .local v2, _arg2:Ljava/lang/String;
    invoke-virtual {p0, v0, v1, v2}, Lmiui/net/IFirewall$Stub;->onDataConnected(ILjava/lang/String;Ljava/lang/String;)V

    .line 84
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 89
    .end local v0           #_arg0:I
    .end local v1           #_arg1:Ljava/lang/String;
    .end local v2           #_arg2:Ljava/lang/String;
    :sswitch_5c
    const-string/jumbo v4, "miui.net.IFirewall"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 91
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 93
    .restart local v0       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 94
    .restart local v1       #_arg1:Ljava/lang/String;
    invoke-virtual {p0, v0, v1}, Lmiui/net/IFirewall$Stub;->onDataDisconnected(ILjava/lang/String;)V

    .line 95
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 100
    .end local v0           #_arg0:I
    .end local v1           #_arg1:Ljava/lang/String;
    :sswitch_71
    const-string/jumbo v4, "miui.net.IFirewall"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 102
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 103
    .local v0, _arg0:Ljava/lang/String;
    invoke-virtual {p0, v0}, Lmiui/net/IFirewall$Stub;->addAccessControlPass(Ljava/lang/String;)V

    .line 104
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 109
    .end local v0           #_arg0:Ljava/lang/String;
    :sswitch_82
    const-string/jumbo v4, "miui.net.IFirewall"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 111
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 112
    .restart local v0       #_arg0:Ljava/lang/String;
    invoke-virtual {p0, v0}, Lmiui/net/IFirewall$Stub;->removeAccessControlPass(Ljava/lang/String;)V

    .line 113
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 118
    .end local v0           #_arg0:Ljava/lang/String;
    :sswitch_94
    const-string/jumbo v6, "miui.net.IFirewall"

    invoke-virtual {p2, v6}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 120
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 121
    .restart local v0       #_arg0:Ljava/lang/String;
    invoke-virtual {p0, v0}, Lmiui/net/IFirewall$Stub;->checkAccessControlPass(Ljava/lang/String;)Z

    move-result v3

    .line 122
    .local v3, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 123
    if-eqz v3, :cond_a8

    move v4, v5

    :cond_a8
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_9

    .line 128
    .end local v0           #_arg0:Ljava/lang/String;
    .end local v3           #_result:Z
    :sswitch_ad
    const-string/jumbo v4, "miui.net.IFirewall"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 130
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 131
    .local v0, _arg0:I
    invoke-virtual {p0, v0}, Lmiui/net/IFirewall$Stub;->addOneShotFlag(I)V

    .line 132
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 137
    .end local v0           #_arg0:I
    :sswitch_bf
    const-string/jumbo v6, "miui.net.IFirewall"

    invoke-virtual {p2, v6}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 139
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 140
    .restart local v0       #_arg0:I
    invoke-virtual {p0, v0}, Lmiui/net/IFirewall$Stub;->getOneShotFlag(I)Z

    move-result v3

    .line 141
    .restart local v3       #_result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 142
    if-eqz v3, :cond_d3

    move v4, v5

    :cond_d3
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_9

    .line 41
    :sswitch_data_d8
    .sparse-switch
        0x1 -> :sswitch_11
        0x2 -> :sswitch_2a
        0x3 -> :sswitch_43
        0x4 -> :sswitch_5c
        0x5 -> :sswitch_71
        0x6 -> :sswitch_82
        0x7 -> :sswitch_94
        0x8 -> :sswitch_ad
        0x9 -> :sswitch_bf
        0x5f4e5446 -> :sswitch_a
    .end sparse-switch
.end method
