.class public abstract Landroid/net/sip/ISipService$Stub;
.super Landroid/os/Binder;
.source "ISipService.java"

# interfaces
.implements Landroid/net/sip/ISipService;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/sip/ISipService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/sip/ISipService$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.net.sip.ISipService"

.field static final TRANSACTION_close:I = 0x3

.field static final TRANSACTION_createSession:I = 0x7

.field static final TRANSACTION_getListOfProfiles:I = 0x9

.field static final TRANSACTION_getPendingSession:I = 0x8

.field static final TRANSACTION_isOpened:I = 0x4

.field static final TRANSACTION_isRegistered:I = 0x5

.field static final TRANSACTION_open:I = 0x1

.field static final TRANSACTION_open3:I = 0x2

.field static final TRANSACTION_setRegistrationListener:I = 0x6


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    const-string v0, "android.net.sip.ISipService"

    invoke-virtual {p0, p0, v0}, Landroid/net/sip/ISipService$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/net/sip/ISipService;
    .registers 3
    .parameter "obj"

    .prologue
    if-nez p0, :cond_4

    const/4 v0, 0x0

    :goto_3
    return-object v0

    :cond_4
    const-string v1, "android.net.sip.ISipService"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/net/sip/ISipService;

    if-eqz v1, :cond_13

    check-cast v0, Landroid/net/sip/ISipService;

    goto :goto_3

    :cond_13
    new-instance v0, Landroid/net/sip/ISipService$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/net/sip/ISipService$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
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
    const/4 v6, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x1

    sparse-switch p1, :sswitch_data_116

    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v5

    :goto_a
    return v5

    :sswitch_b
    const-string v4, "android.net.sip.ISipService"

    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_a

    :sswitch_11
    const-string v4, "android.net.sip.ISipService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_2b

    sget-object v4, Landroid/net/sip/SipProfile;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/sip/SipProfile;

    .local v0, _arg0:Landroid/net/sip/SipProfile;
    :goto_24
    invoke-virtual {p0, v0}, Landroid/net/sip/ISipService$Stub;->open(Landroid/net/sip/SipProfile;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_a

    .end local v0           #_arg0:Landroid/net/sip/SipProfile;
    :cond_2b
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/net/sip/SipProfile;
    goto :goto_24

    .end local v0           #_arg0:Landroid/net/sip/SipProfile;
    :sswitch_2d
    const-string v4, "android.net.sip.ISipService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_5d

    sget-object v4, Landroid/net/sip/SipProfile;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/sip/SipProfile;

    .restart local v0       #_arg0:Landroid/net/sip/SipProfile;
    :goto_40
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_5f

    sget-object v4, Landroid/app/PendingIntent;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/PendingIntent;

    .local v1, _arg1:Landroid/app/PendingIntent;
    :goto_4e
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Landroid/net/sip/ISipSessionListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/net/sip/ISipSessionListener;

    move-result-object v2

    .local v2, _arg2:Landroid/net/sip/ISipSessionListener;
    invoke-virtual {p0, v0, v1, v2}, Landroid/net/sip/ISipService$Stub;->open3(Landroid/net/sip/SipProfile;Landroid/app/PendingIntent;Landroid/net/sip/ISipSessionListener;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_a

    .end local v0           #_arg0:Landroid/net/sip/SipProfile;
    .end local v1           #_arg1:Landroid/app/PendingIntent;
    .end local v2           #_arg2:Landroid/net/sip/ISipSessionListener;
    :cond_5d
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/net/sip/SipProfile;
    goto :goto_40

    :cond_5f
    const/4 v1, 0x0

    .restart local v1       #_arg1:Landroid/app/PendingIntent;
    goto :goto_4e

    .end local v0           #_arg0:Landroid/net/sip/SipProfile;
    .end local v1           #_arg1:Landroid/app/PendingIntent;
    :sswitch_61
    const-string v4, "android.net.sip.ISipService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .local v0, _arg0:Ljava/lang/String;
    invoke-virtual {p0, v0}, Landroid/net/sip/ISipService$Stub;->close(Ljava/lang/String;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_a

    .end local v0           #_arg0:Ljava/lang/String;
    :sswitch_71
    const-string v6, "android.net.sip.ISipService"

    invoke-virtual {p2, v6}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .restart local v0       #_arg0:Ljava/lang/String;
    invoke-virtual {p0, v0}, Landroid/net/sip/ISipService$Stub;->isOpened(Ljava/lang/String;)Z

    move-result v3

    .local v3, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    if-eqz v3, :cond_84

    move v4, v5

    :cond_84
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_a

    .end local v0           #_arg0:Ljava/lang/String;
    .end local v3           #_result:Z
    :sswitch_88
    const-string v6, "android.net.sip.ISipService"

    invoke-virtual {p2, v6}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .restart local v0       #_arg0:Ljava/lang/String;
    invoke-virtual {p0, v0}, Landroid/net/sip/ISipService$Stub;->isRegistered(Ljava/lang/String;)Z

    move-result v3

    .restart local v3       #_result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    if-eqz v3, :cond_9b

    move v4, v5

    :cond_9b
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_a

    .end local v0           #_arg0:Ljava/lang/String;
    .end local v3           #_result:Z
    :sswitch_a0
    const-string v4, "android.net.sip.ISipService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .restart local v0       #_arg0:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Landroid/net/sip/ISipSessionListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/net/sip/ISipSessionListener;

    move-result-object v1

    .local v1, _arg1:Landroid/net/sip/ISipSessionListener;
    invoke-virtual {p0, v0, v1}, Landroid/net/sip/ISipService$Stub;->setRegistrationListener(Ljava/lang/String;Landroid/net/sip/ISipSessionListener;)V

    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_a

    .end local v0           #_arg0:Ljava/lang/String;
    .end local v1           #_arg1:Landroid/net/sip/ISipSessionListener;
    :sswitch_b9
    const-string v4, "android.net.sip.ISipService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_e6

    sget-object v4, Landroid/net/sip/SipProfile;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/sip/SipProfile;

    .local v0, _arg0:Landroid/net/sip/SipProfile;
    :goto_cc
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Landroid/net/sip/ISipSessionListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/net/sip/ISipSessionListener;

    move-result-object v1

    .restart local v1       #_arg1:Landroid/net/sip/ISipSessionListener;
    invoke-virtual {p0, v0, v1}, Landroid/net/sip/ISipService$Stub;->createSession(Landroid/net/sip/SipProfile;Landroid/net/sip/ISipSessionListener;)Landroid/net/sip/ISipSession;

    move-result-object v3

    .local v3, _result:Landroid/net/sip/ISipSession;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    if-eqz v3, :cond_e8

    invoke-interface {v3}, Landroid/net/sip/ISipSession;->asBinder()Landroid/os/IBinder;

    move-result-object v4

    :goto_e1
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    goto/16 :goto_a

    .end local v0           #_arg0:Landroid/net/sip/SipProfile;
    .end local v1           #_arg1:Landroid/net/sip/ISipSessionListener;
    .end local v3           #_result:Landroid/net/sip/ISipSession;
    :cond_e6
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/net/sip/SipProfile;
    goto :goto_cc

    .restart local v1       #_arg1:Landroid/net/sip/ISipSessionListener;
    .restart local v3       #_result:Landroid/net/sip/ISipSession;
    :cond_e8
    move-object v4, v6

    goto :goto_e1

    .end local v0           #_arg0:Landroid/net/sip/SipProfile;
    .end local v1           #_arg1:Landroid/net/sip/ISipSessionListener;
    .end local v3           #_result:Landroid/net/sip/ISipSession;
    :sswitch_ea
    const-string v4, "android.net.sip.ISipService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .local v0, _arg0:Ljava/lang/String;
    invoke-virtual {p0, v0}, Landroid/net/sip/ISipService$Stub;->getPendingSession(Ljava/lang/String;)Landroid/net/sip/ISipSession;

    move-result-object v3

    .restart local v3       #_result:Landroid/net/sip/ISipSession;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    if-eqz v3, :cond_100

    invoke-interface {v3}, Landroid/net/sip/ISipSession;->asBinder()Landroid/os/IBinder;

    move-result-object v6

    :cond_100
    invoke-virtual {p3, v6}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    goto/16 :goto_a

    .end local v0           #_arg0:Ljava/lang/String;
    .end local v3           #_result:Landroid/net/sip/ISipSession;
    :sswitch_105
    const-string v4, "android.net.sip.ISipService"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/net/sip/ISipService$Stub;->getListOfProfiles()[Landroid/net/sip/SipProfile;

    move-result-object v3

    .local v3, _result:[Landroid/net/sip/SipProfile;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    invoke-virtual {p3, v3, v5}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    goto/16 :goto_a

    :sswitch_data_116
    .sparse-switch
        0x1 -> :sswitch_11
        0x2 -> :sswitch_2d
        0x3 -> :sswitch_61
        0x4 -> :sswitch_71
        0x5 -> :sswitch_88
        0x6 -> :sswitch_a0
        0x7 -> :sswitch_b9
        0x8 -> :sswitch_ea
        0x9 -> :sswitch_105
        0x5f4e5446 -> :sswitch_b
    .end sparse-switch
.end method
