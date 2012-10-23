.class public abstract Landroid/nfc/INfcAdapter$Stub;
.super Landroid/os/Binder;
.source "INfcAdapter.java"

# interfaces
.implements Landroid/nfc/INfcAdapter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/nfc/INfcAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/nfc/INfcAdapter$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.nfc.INfcAdapter"

.field static final TRANSACTION_disable:I = 0x4

.field static final TRANSACTION_disableNdefPush:I = 0x7

.field static final TRANSACTION_dispatch:I = 0xb

.field static final TRANSACTION_enable:I = 0x5

.field static final TRANSACTION_enableNdefPush:I = 0x6

.field static final TRANSACTION_getNfcAdapterExtrasInterface:I = 0x2

.field static final TRANSACTION_getNfcTagInterface:I = 0x1

.field static final TRANSACTION_getState:I = 0x3

.field static final TRANSACTION_isNdefPushEnabled:I = 0x8

.field static final TRANSACTION_setForegroundDispatch:I = 0x9

.field static final TRANSACTION_setNdefPushCallback:I = 0xa

.field static final TRANSACTION_setP2pModes:I = 0xc


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 18
    const-string v0, "android.nfc.INfcAdapter"

    invoke-virtual {p0, p0, v0}, Landroid/nfc/INfcAdapter$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/nfc/INfcAdapter;
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
    const-string v1, "android.nfc.INfcAdapter"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 30
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/nfc/INfcAdapter;

    if-eqz v1, :cond_13

    .line 31
    check-cast v0, Landroid/nfc/INfcAdapter;

    goto :goto_3

    .line 33
    :cond_13
    new-instance v0, Landroid/nfc/INfcAdapter$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/nfc/INfcAdapter$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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

    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 41
    sparse-switch p1, :sswitch_data_138

    .line 174
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v5

    :goto_a
    return v5

    .line 45
    :sswitch_b
    const-string v4, "android.nfc.INfcAdapter"

    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_a

    .line 50
    :sswitch_11
    const-string v6, "android.nfc.INfcAdapter"

    invoke-virtual {p2, v6}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 51
    invoke-virtual {p0}, Landroid/nfc/INfcAdapter$Stub;->getNfcTagInterface()Landroid/nfc/INfcTag;

    move-result-object v3

    .line 52
    .local v3, _result:Landroid/nfc/INfcTag;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 53
    if-eqz v3, :cond_23

    invoke-interface {v3}, Landroid/nfc/INfcTag;->asBinder()Landroid/os/IBinder;

    move-result-object v4

    :cond_23
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    goto :goto_a

    .line 58
    .end local v3           #_result:Landroid/nfc/INfcTag;
    :sswitch_27
    const-string v6, "android.nfc.INfcAdapter"

    invoke-virtual {p2, v6}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 60
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 61
    .local v0, _arg0:Ljava/lang/String;
    invoke-virtual {p0, v0}, Landroid/nfc/INfcAdapter$Stub;->getNfcAdapterExtrasInterface(Ljava/lang/String;)Landroid/nfc/INfcAdapterExtras;

    move-result-object v3

    .line 62
    .local v3, _result:Landroid/nfc/INfcAdapterExtras;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 63
    if-eqz v3, :cond_3d

    invoke-interface {v3}, Landroid/nfc/INfcAdapterExtras;->asBinder()Landroid/os/IBinder;

    move-result-object v4

    :cond_3d
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    goto :goto_a

    .line 68
    .end local v0           #_arg0:Ljava/lang/String;
    .end local v3           #_result:Landroid/nfc/INfcAdapterExtras;
    :sswitch_41
    const-string v4, "android.nfc.INfcAdapter"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 69
    invoke-virtual {p0}, Landroid/nfc/INfcAdapter$Stub;->getState()I

    move-result v3

    .line 70
    .local v3, _result:I
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 71
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_a

    .line 76
    .end local v3           #_result:I
    :sswitch_51
    const-string v4, "android.nfc.INfcAdapter"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 78
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_6b

    move v0, v5

    .line 79
    .local v0, _arg0:Z
    :goto_5d
    invoke-virtual {p0, v0}, Landroid/nfc/INfcAdapter$Stub;->disable(Z)Z

    move-result v3

    .line 80
    .local v3, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 81
    if-eqz v3, :cond_67

    move v6, v5

    :cond_67
    invoke-virtual {p3, v6}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_a

    .end local v0           #_arg0:Z
    .end local v3           #_result:Z
    :cond_6b
    move v0, v6

    .line 78
    goto :goto_5d

    .line 86
    :sswitch_6d
    const-string v4, "android.nfc.INfcAdapter"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 87
    invoke-virtual {p0}, Landroid/nfc/INfcAdapter$Stub;->enable()Z

    move-result v3

    .line 88
    .restart local v3       #_result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 89
    if-eqz v3, :cond_7c

    move v6, v5

    :cond_7c
    invoke-virtual {p3, v6}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_a

    .line 94
    .end local v3           #_result:Z
    :sswitch_80
    const-string v4, "android.nfc.INfcAdapter"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 95
    invoke-virtual {p0}, Landroid/nfc/INfcAdapter$Stub;->enableNdefPush()Z

    move-result v3

    .line 96
    .restart local v3       #_result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 97
    if-eqz v3, :cond_8f

    move v6, v5

    :cond_8f
    invoke-virtual {p3, v6}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_a

    .line 102
    .end local v3           #_result:Z
    :sswitch_94
    const-string v4, "android.nfc.INfcAdapter"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 103
    invoke-virtual {p0}, Landroid/nfc/INfcAdapter$Stub;->disableNdefPush()Z

    move-result v3

    .line 104
    .restart local v3       #_result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 105
    if-eqz v3, :cond_a3

    move v6, v5

    :cond_a3
    invoke-virtual {p3, v6}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_a

    .line 110
    .end local v3           #_result:Z
    :sswitch_a8
    const-string v4, "android.nfc.INfcAdapter"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 111
    invoke-virtual {p0}, Landroid/nfc/INfcAdapter$Stub;->isNdefPushEnabled()Z

    move-result v3

    .line 112
    .restart local v3       #_result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 113
    if-eqz v3, :cond_b7

    move v6, v5

    :cond_b7
    invoke-virtual {p3, v6}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_a

    .line 118
    .end local v3           #_result:Z
    :sswitch_bc
    const-string v4, "android.nfc.INfcAdapter"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 120
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_ed

    .line 121
    sget-object v4, Landroid/app/PendingIntent;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/PendingIntent;

    .line 127
    .local v0, _arg0:Landroid/app/PendingIntent;
    :goto_cf
    sget-object v4, Landroid/content/IntentFilter;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->createTypedArray(Landroid/os/Parcelable$Creator;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Landroid/content/IntentFilter;

    .line 129
    .local v1, _arg1:[Landroid/content/IntentFilter;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_ef

    .line 130
    sget-object v4, Landroid/nfc/TechListParcel;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/nfc/TechListParcel;

    .line 135
    .local v2, _arg2:Landroid/nfc/TechListParcel;
    :goto_e5
    invoke-virtual {p0, v0, v1, v2}, Landroid/nfc/INfcAdapter$Stub;->setForegroundDispatch(Landroid/app/PendingIntent;[Landroid/content/IntentFilter;Landroid/nfc/TechListParcel;)V

    .line 136
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_a

    .line 124
    .end local v0           #_arg0:Landroid/app/PendingIntent;
    .end local v1           #_arg1:[Landroid/content/IntentFilter;
    .end local v2           #_arg2:Landroid/nfc/TechListParcel;
    :cond_ed
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/app/PendingIntent;
    goto :goto_cf

    .line 133
    .restart local v1       #_arg1:[Landroid/content/IntentFilter;
    :cond_ef
    const/4 v2, 0x0

    .restart local v2       #_arg2:Landroid/nfc/TechListParcel;
    goto :goto_e5

    .line 141
    .end local v0           #_arg0:Landroid/app/PendingIntent;
    .end local v1           #_arg1:[Landroid/content/IntentFilter;
    .end local v2           #_arg2:Landroid/nfc/TechListParcel;
    :sswitch_f1
    const-string v4, "android.nfc.INfcAdapter"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 143
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Landroid/nfc/INdefPushCallback$Stub;->asInterface(Landroid/os/IBinder;)Landroid/nfc/INdefPushCallback;

    move-result-object v0

    .line 144
    .local v0, _arg0:Landroid/nfc/INdefPushCallback;
    invoke-virtual {p0, v0}, Landroid/nfc/INfcAdapter$Stub;->setNdefPushCallback(Landroid/nfc/INdefPushCallback;)V

    .line 145
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_a

    .line 150
    .end local v0           #_arg0:Landroid/nfc/INdefPushCallback;
    :sswitch_106
    const-string v4, "android.nfc.INfcAdapter"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 152
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_121

    .line 153
    sget-object v4, Landroid/nfc/Tag;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/nfc/Tag;

    .line 158
    .local v0, _arg0:Landroid/nfc/Tag;
    :goto_119
    invoke-virtual {p0, v0}, Landroid/nfc/INfcAdapter$Stub;->dispatch(Landroid/nfc/Tag;)V

    .line 159
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_a

    .line 156
    .end local v0           #_arg0:Landroid/nfc/Tag;
    :cond_121
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/nfc/Tag;
    goto :goto_119

    .line 164
    .end local v0           #_arg0:Landroid/nfc/Tag;
    :sswitch_123
    const-string v4, "android.nfc.INfcAdapter"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 166
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 168
    .local v0, _arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 169
    .local v1, _arg1:I
    invoke-virtual {p0, v0, v1}, Landroid/nfc/INfcAdapter$Stub;->setP2pModes(II)V

    .line 170
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_a

    .line 41
    :sswitch_data_138
    .sparse-switch
        0x1 -> :sswitch_11
        0x2 -> :sswitch_27
        0x3 -> :sswitch_41
        0x4 -> :sswitch_51
        0x5 -> :sswitch_6d
        0x6 -> :sswitch_80
        0x7 -> :sswitch_94
        0x8 -> :sswitch_a8
        0x9 -> :sswitch_bc
        0xa -> :sswitch_f1
        0xb -> :sswitch_106
        0xc -> :sswitch_123
        0x5f4e5446 -> :sswitch_b
    .end sparse-switch
.end method
