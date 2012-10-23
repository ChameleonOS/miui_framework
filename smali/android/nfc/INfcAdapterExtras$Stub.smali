.class public abstract Landroid/nfc/INfcAdapterExtras$Stub;
.super Landroid/os/Binder;
.source "INfcAdapterExtras.java"

# interfaces
.implements Landroid/nfc/INfcAdapterExtras;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/nfc/INfcAdapterExtras;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/nfc/INfcAdapterExtras$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.nfc.INfcAdapterExtras"

.field static final TRANSACTION_authenticate:I = 0x6

.field static final TRANSACTION_close:I = 0x2

.field static final TRANSACTION_getCardEmulationRoute:I = 0x4

.field static final TRANSACTION_open:I = 0x1

.field static final TRANSACTION_setCardEmulationRoute:I = 0x5

.field static final TRANSACTION_transceive:I = 0x3


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 18
    const-string v0, "android.nfc.INfcAdapterExtras"

    invoke-virtual {p0, p0, v0}, Landroid/nfc/INfcAdapterExtras$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/nfc/INfcAdapterExtras;
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
    const-string v1, "android.nfc.INfcAdapterExtras"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 30
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/nfc/INfcAdapterExtras;

    if-eqz v1, :cond_13

    .line 31
    check-cast v0, Landroid/nfc/INfcAdapterExtras;

    goto :goto_3

    .line 33
    :cond_13
    new-instance v0, Landroid/nfc/INfcAdapterExtras$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/nfc/INfcAdapterExtras$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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
    .registers 11
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
    const/4 v5, 0x0

    const/4 v3, 0x1

    .line 41
    sparse-switch p1, :sswitch_data_b2

    .line 135
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v3

    :goto_9
    return v3

    .line 45
    :sswitch_a
    const-string v4, "android.nfc.INfcAdapterExtras"

    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_9

    .line 50
    :sswitch_10
    const-string v4, "android.nfc.INfcAdapterExtras"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 52
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 54
    .local v0, _arg0:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    .line 55
    .local v1, _arg1:Landroid/os/IBinder;
    invoke-virtual {p0, v0, v1}, Landroid/nfc/INfcAdapterExtras$Stub;->open(Ljava/lang/String;Landroid/os/IBinder;)Landroid/os/Bundle;

    move-result-object v2

    .line 56
    .local v2, _result:Landroid/os/Bundle;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 57
    if-eqz v2, :cond_2d

    .line 58
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 59
    invoke-virtual {v2, p3, v3}, Landroid/os/Bundle;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_9

    .line 62
    :cond_2d
    invoke-virtual {p3, v5}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 68
    .end local v0           #_arg0:Ljava/lang/String;
    .end local v1           #_arg1:Landroid/os/IBinder;
    .end local v2           #_result:Landroid/os/Bundle;
    :sswitch_31
    const-string v4, "android.nfc.INfcAdapterExtras"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 70
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 72
    .restart local v0       #_arg0:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v1

    .line 73
    .restart local v1       #_arg1:Landroid/os/IBinder;
    invoke-virtual {p0, v0, v1}, Landroid/nfc/INfcAdapterExtras$Stub;->close(Ljava/lang/String;Landroid/os/IBinder;)Landroid/os/Bundle;

    move-result-object v2

    .line 74
    .restart local v2       #_result:Landroid/os/Bundle;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 75
    if-eqz v2, :cond_4e

    .line 76
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 77
    invoke-virtual {v2, p3, v3}, Landroid/os/Bundle;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_9

    .line 80
    :cond_4e
    invoke-virtual {p3, v5}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 86
    .end local v0           #_arg0:Ljava/lang/String;
    .end local v1           #_arg1:Landroid/os/IBinder;
    .end local v2           #_result:Landroid/os/Bundle;
    :sswitch_52
    const-string v4, "android.nfc.INfcAdapterExtras"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 88
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 90
    .restart local v0       #_arg0:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->createByteArray()[B

    move-result-object v1

    .line 91
    .local v1, _arg1:[B
    invoke-virtual {p0, v0, v1}, Landroid/nfc/INfcAdapterExtras$Stub;->transceive(Ljava/lang/String;[B)Landroid/os/Bundle;

    move-result-object v2

    .line 92
    .restart local v2       #_result:Landroid/os/Bundle;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 93
    if-eqz v2, :cond_6f

    .line 94
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 95
    invoke-virtual {v2, p3, v3}, Landroid/os/Bundle;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_9

    .line 98
    :cond_6f
    invoke-virtual {p3, v5}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 104
    .end local v0           #_arg0:Ljava/lang/String;
    .end local v1           #_arg1:[B
    .end local v2           #_result:Landroid/os/Bundle;
    :sswitch_73
    const-string v4, "android.nfc.INfcAdapterExtras"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 106
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 107
    .restart local v0       #_arg0:Ljava/lang/String;
    invoke-virtual {p0, v0}, Landroid/nfc/INfcAdapterExtras$Stub;->getCardEmulationRoute(Ljava/lang/String;)I

    move-result v2

    .line 108
    .local v2, _result:I
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 109
    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 114
    .end local v0           #_arg0:Ljava/lang/String;
    .end local v2           #_result:I
    :sswitch_87
    const-string v4, "android.nfc.INfcAdapterExtras"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 116
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 118
    .restart local v0       #_arg0:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 119
    .local v1, _arg1:I
    invoke-virtual {p0, v0, v1}, Landroid/nfc/INfcAdapterExtras$Stub;->setCardEmulationRoute(Ljava/lang/String;I)V

    .line 120
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 125
    .end local v0           #_arg0:Ljava/lang/String;
    .end local v1           #_arg1:I
    :sswitch_9c
    const-string v4, "android.nfc.INfcAdapterExtras"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 127
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 129
    .restart local v0       #_arg0:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->createByteArray()[B

    move-result-object v1

    .line 130
    .local v1, _arg1:[B
    invoke-virtual {p0, v0, v1}, Landroid/nfc/INfcAdapterExtras$Stub;->authenticate(Ljava/lang/String;[B)V

    .line 131
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 41
    nop

    :sswitch_data_b2
    .sparse-switch
        0x1 -> :sswitch_10
        0x2 -> :sswitch_31
        0x3 -> :sswitch_52
        0x4 -> :sswitch_73
        0x5 -> :sswitch_87
        0x6 -> :sswitch_9c
        0x5f4e5446 -> :sswitch_a
    .end sparse-switch
.end method
