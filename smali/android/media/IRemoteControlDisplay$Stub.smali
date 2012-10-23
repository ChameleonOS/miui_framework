.class public abstract Landroid/media/IRemoteControlDisplay$Stub;
.super Landroid/os/Binder;
.source "IRemoteControlDisplay.java"

# interfaces
.implements Landroid/media/IRemoteControlDisplay;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/IRemoteControlDisplay;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/media/IRemoteControlDisplay$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.media.IRemoteControlDisplay"

.field static final TRANSACTION_setAllMetadata:I = 0x6

.field static final TRANSACTION_setArtwork:I = 0x5

.field static final TRANSACTION_setCurrentClientId:I = 0x1

.field static final TRANSACTION_setMetadata:I = 0x4

.field static final TRANSACTION_setPlaybackState:I = 0x2

.field static final TRANSACTION_setTransportControlFlags:I = 0x3


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 20
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 21
    const-string v0, "android.media.IRemoteControlDisplay"

    invoke-virtual {p0, p0, v0}, Landroid/media/IRemoteControlDisplay$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 22
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/media/IRemoteControlDisplay;
    .registers 3
    .parameter "obj"

    .prologue
    .line 29
    if-nez p0, :cond_4

    .line 30
    const/4 v0, 0x0

    .line 36
    :goto_3
    return-object v0

    .line 32
    :cond_4
    const-string v1, "android.media.IRemoteControlDisplay"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 33
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/media/IRemoteControlDisplay;

    if-eqz v1, :cond_13

    .line 34
    check-cast v0, Landroid/media/IRemoteControlDisplay;

    goto :goto_3

    .line 36
    :cond_13
    new-instance v0, Landroid/media/IRemoteControlDisplay$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/media/IRemoteControlDisplay$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 40
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
    const/4 v4, 0x1

    .line 44
    sparse-switch p1, :sswitch_data_c4

    .line 143
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v4

    :goto_8
    return v4

    .line 48
    :sswitch_9
    const-string v5, "android.media.IRemoteControlDisplay"

    invoke-virtual {p3, v5}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_8

    .line 53
    :sswitch_f
    const-string v5, "android.media.IRemoteControlDisplay"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 55
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 57
    .local v0, _arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_31

    .line 58
    sget-object v5, Landroid/app/PendingIntent;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/PendingIntent;

    .line 64
    .local v1, _arg1:Landroid/app/PendingIntent;
    :goto_26
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_33

    move v2, v4

    .line 65
    .local v2, _arg2:Z
    :goto_2d
    invoke-virtual {p0, v0, v1, v2}, Landroid/media/IRemoteControlDisplay$Stub;->setCurrentClientId(ILandroid/app/PendingIntent;Z)V

    goto :goto_8

    .line 61
    .end local v1           #_arg1:Landroid/app/PendingIntent;
    .end local v2           #_arg2:Z
    :cond_31
    const/4 v1, 0x0

    .restart local v1       #_arg1:Landroid/app/PendingIntent;
    goto :goto_26

    .line 64
    :cond_33
    const/4 v2, 0x0

    goto :goto_2d

    .line 70
    .end local v0           #_arg0:I
    .end local v1           #_arg1:Landroid/app/PendingIntent;
    :sswitch_35
    const-string v5, "android.media.IRemoteControlDisplay"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 72
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 74
    .restart local v0       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 76
    .local v1, _arg1:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v2

    .line 77
    .local v2, _arg2:J
    invoke-virtual {p0, v0, v1, v2, v3}, Landroid/media/IRemoteControlDisplay$Stub;->setPlaybackState(IIJ)V

    goto :goto_8

    .line 82
    .end local v0           #_arg0:I
    .end local v1           #_arg1:I
    .end local v2           #_arg2:J
    :sswitch_4a
    const-string v5, "android.media.IRemoteControlDisplay"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 84
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 86
    .restart local v0       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 87
    .restart local v1       #_arg1:I
    invoke-virtual {p0, v0, v1}, Landroid/media/IRemoteControlDisplay$Stub;->setTransportControlFlags(II)V

    goto :goto_8

    .line 92
    .end local v0           #_arg0:I
    .end local v1           #_arg1:I
    :sswitch_5b
    const-string v5, "android.media.IRemoteControlDisplay"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 94
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 96
    .restart local v0       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_76

    .line 97
    sget-object v5, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;

    .line 102
    .local v1, _arg1:Landroid/os/Bundle;
    :goto_72
    invoke-virtual {p0, v0, v1}, Landroid/media/IRemoteControlDisplay$Stub;->setMetadata(ILandroid/os/Bundle;)V

    goto :goto_8

    .line 100
    .end local v1           #_arg1:Landroid/os/Bundle;
    :cond_76
    const/4 v1, 0x0

    .restart local v1       #_arg1:Landroid/os/Bundle;
    goto :goto_72

    .line 107
    .end local v0           #_arg0:I
    .end local v1           #_arg1:Landroid/os/Bundle;
    :sswitch_78
    const-string v5, "android.media.IRemoteControlDisplay"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 109
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 111
    .restart local v0       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_94

    .line 112
    sget-object v5, Landroid/graphics/Bitmap;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/graphics/Bitmap;

    .line 117
    .local v1, _arg1:Landroid/graphics/Bitmap;
    :goto_8f
    invoke-virtual {p0, v0, v1}, Landroid/media/IRemoteControlDisplay$Stub;->setArtwork(ILandroid/graphics/Bitmap;)V

    goto/16 :goto_8

    .line 115
    .end local v1           #_arg1:Landroid/graphics/Bitmap;
    :cond_94
    const/4 v1, 0x0

    .restart local v1       #_arg1:Landroid/graphics/Bitmap;
    goto :goto_8f

    .line 122
    .end local v0           #_arg0:I
    .end local v1           #_arg1:Landroid/graphics/Bitmap;
    :sswitch_96
    const-string v5, "android.media.IRemoteControlDisplay"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 124
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 126
    .restart local v0       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_c0

    .line 127
    sget-object v5, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;

    .line 133
    .local v1, _arg1:Landroid/os/Bundle;
    :goto_ad
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_c2

    .line 134
    sget-object v5, Landroid/graphics/Bitmap;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/graphics/Bitmap;

    .line 139
    .local v2, _arg2:Landroid/graphics/Bitmap;
    :goto_bb
    invoke-virtual {p0, v0, v1, v2}, Landroid/media/IRemoteControlDisplay$Stub;->setAllMetadata(ILandroid/os/Bundle;Landroid/graphics/Bitmap;)V

    goto/16 :goto_8

    .line 130
    .end local v1           #_arg1:Landroid/os/Bundle;
    .end local v2           #_arg2:Landroid/graphics/Bitmap;
    :cond_c0
    const/4 v1, 0x0

    .restart local v1       #_arg1:Landroid/os/Bundle;
    goto :goto_ad

    .line 137
    :cond_c2
    const/4 v2, 0x0

    .restart local v2       #_arg2:Landroid/graphics/Bitmap;
    goto :goto_bb

    .line 44
    :sswitch_data_c4
    .sparse-switch
        0x1 -> :sswitch_f
        0x2 -> :sswitch_35
        0x3 -> :sswitch_4a
        0x4 -> :sswitch_5b
        0x5 -> :sswitch_78
        0x6 -> :sswitch_96
        0x5f4e5446 -> :sswitch_9
    .end sparse-switch
.end method
