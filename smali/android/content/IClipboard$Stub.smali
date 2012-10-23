.class public abstract Landroid/content/IClipboard$Stub;
.super Landroid/os/Binder;
.source "IClipboard.java"

# interfaces
.implements Landroid/content/IClipboard;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/IClipboard;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/content/IClipboard$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.content.IClipboard"

.field static final TRANSACTION_addPrimaryClipChangedListener:I = 0x5

.field static final TRANSACTION_getPrimaryClip:I = 0x2

.field static final TRANSACTION_getPrimaryClipDescription:I = 0x3

.field static final TRANSACTION_hasClipboardText:I = 0x7

.field static final TRANSACTION_hasPrimaryClip:I = 0x4

.field static final TRANSACTION_removePrimaryClipChangedListener:I = 0x6

.field static final TRANSACTION_setPrimaryClip:I = 0x1


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 20
    const-string v0, "android.content.IClipboard"

    invoke-virtual {p0, p0, v0}, Landroid/content/IClipboard$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 21
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/content/IClipboard;
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
    const-string v1, "android.content.IClipboard"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 32
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/content/IClipboard;

    if-eqz v1, :cond_13

    .line 33
    check-cast v0, Landroid/content/IClipboard;

    goto :goto_3

    .line 35
    :cond_13
    new-instance v0, Landroid/content/IClipboard$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/content/IClipboard$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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
    .registers 10
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
    const/4 v2, 0x0

    const/4 v3, 0x1

    .line 43
    sparse-switch p1, :sswitch_data_b2

    .line 129
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v3

    :goto_9
    return v3

    .line 47
    :sswitch_a
    const-string v2, "android.content.IClipboard"

    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_9

    .line 52
    :sswitch_10
    const-string v2, "android.content.IClipboard"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 54
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_2a

    .line 55
    sget-object v2, Landroid/content/ClipData;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v2, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ClipData;

    .line 60
    .local v0, _arg0:Landroid/content/ClipData;
    :goto_23
    invoke-virtual {p0, v0}, Landroid/content/IClipboard$Stub;->setPrimaryClip(Landroid/content/ClipData;)V

    .line 61
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 58
    .end local v0           #_arg0:Landroid/content/ClipData;
    :cond_2a
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/content/ClipData;
    goto :goto_23

    .line 66
    .end local v0           #_arg0:Landroid/content/ClipData;
    :sswitch_2c
    const-string v4, "android.content.IClipboard"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 68
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 69
    .local v0, _arg0:Ljava/lang/String;
    invoke-virtual {p0, v0}, Landroid/content/IClipboard$Stub;->getPrimaryClip(Ljava/lang/String;)Landroid/content/ClipData;

    move-result-object v1

    .line 70
    .local v1, _result:Landroid/content/ClipData;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 71
    if-eqz v1, :cond_45

    .line 72
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 73
    invoke-virtual {v1, p3, v3}, Landroid/content/ClipData;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_9

    .line 76
    :cond_45
    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 82
    .end local v0           #_arg0:Ljava/lang/String;
    .end local v1           #_result:Landroid/content/ClipData;
    :sswitch_49
    const-string v4, "android.content.IClipboard"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 83
    invoke-virtual {p0}, Landroid/content/IClipboard$Stub;->getPrimaryClipDescription()Landroid/content/ClipDescription;

    move-result-object v1

    .line 84
    .local v1, _result:Landroid/content/ClipDescription;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 85
    if-eqz v1, :cond_5e

    .line 86
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    .line 87
    invoke-virtual {v1, p3, v3}, Landroid/content/ClipDescription;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_9

    .line 90
    :cond_5e
    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 96
    .end local v1           #_result:Landroid/content/ClipDescription;
    :sswitch_62
    const-string v4, "android.content.IClipboard"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 97
    invoke-virtual {p0}, Landroid/content/IClipboard$Stub;->hasPrimaryClip()Z

    move-result v1

    .line 98
    .local v1, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 99
    if-eqz v1, :cond_71

    move v2, v3

    :cond_71
    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 104
    .end local v1           #_result:Z
    :sswitch_75
    const-string v2, "android.content.IClipboard"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 106
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v2

    invoke-static {v2}, Landroid/content/IOnPrimaryClipChangedListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/content/IOnPrimaryClipChangedListener;

    move-result-object v0

    .line 107
    .local v0, _arg0:Landroid/content/IOnPrimaryClipChangedListener;
    invoke-virtual {p0, v0}, Landroid/content/IClipboard$Stub;->addPrimaryClipChangedListener(Landroid/content/IOnPrimaryClipChangedListener;)V

    .line 108
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 113
    .end local v0           #_arg0:Landroid/content/IOnPrimaryClipChangedListener;
    :sswitch_89
    const-string v2, "android.content.IClipboard"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 115
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v2

    invoke-static {v2}, Landroid/content/IOnPrimaryClipChangedListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/content/IOnPrimaryClipChangedListener;

    move-result-object v0

    .line 116
    .restart local v0       #_arg0:Landroid/content/IOnPrimaryClipChangedListener;
    invoke-virtual {p0, v0}, Landroid/content/IClipboard$Stub;->removePrimaryClipChangedListener(Landroid/content/IOnPrimaryClipChangedListener;)V

    .line 117
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 122
    .end local v0           #_arg0:Landroid/content/IOnPrimaryClipChangedListener;
    :sswitch_9e
    const-string v4, "android.content.IClipboard"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 123
    invoke-virtual {p0}, Landroid/content/IClipboard$Stub;->hasClipboardText()Z

    move-result v1

    .line 124
    .restart local v1       #_result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 125
    if-eqz v1, :cond_ad

    move v2, v3

    :cond_ad
    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_9

    .line 43
    :sswitch_data_b2
    .sparse-switch
        0x1 -> :sswitch_10
        0x2 -> :sswitch_2c
        0x3 -> :sswitch_49
        0x4 -> :sswitch_62
        0x5 -> :sswitch_75
        0x6 -> :sswitch_89
        0x7 -> :sswitch_9e
        0x5f4e5446 -> :sswitch_a
    .end sparse-switch
.end method
