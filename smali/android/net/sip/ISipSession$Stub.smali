.class public abstract Landroid/net/sip/ISipSession$Stub;
.super Landroid/os/Binder;
.source "ISipSession.java"

# interfaces
.implements Landroid/net/sip/ISipSession;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/sip/ISipSession;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/sip/ISipSession$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.net.sip.ISipSession"

.field static final TRANSACTION_answerCall:I = 0xb

.field static final TRANSACTION_changeCall:I = 0xd

.field static final TRANSACTION_endCall:I = 0xc

.field static final TRANSACTION_getCallId:I = 0x6

.field static final TRANSACTION_getLocalIp:I = 0x1

.field static final TRANSACTION_getLocalProfile:I = 0x2

.field static final TRANSACTION_getPeerProfile:I = 0x3

.field static final TRANSACTION_getState:I = 0x4

.field static final TRANSACTION_isInCall:I = 0x5

.field static final TRANSACTION_makeCall:I = 0xa

.field static final TRANSACTION_register:I = 0x8

.field static final TRANSACTION_setListener:I = 0x7

.field static final TRANSACTION_unregister:I = 0x9


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 20
    const-string v0, "android.net.sip.ISipSession"

    invoke-virtual {p0, p0, v0}, Landroid/net/sip/ISipSession$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 21
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/net/sip/ISipSession;
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
    const-string v1, "android.net.sip.ISipSession"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 32
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/net/sip/ISipSession;

    if-eqz v1, :cond_13

    .line 33
    check-cast v0, Landroid/net/sip/ISipSession;

    goto :goto_3

    .line 35
    :cond_13
    new-instance v0, Landroid/net/sip/ISipSession$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/net/sip/ISipSession$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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

    .line 43
    sparse-switch p1, :sswitch_data_114

    .line 183
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v5

    :goto_9
    return v5

    .line 47
    :sswitch_a
    const-string v4, "android.net.sip.ISipSession"

    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_9

    .line 52
    :sswitch_10
    const-string v4, "android.net.sip.ISipSession"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 53
    invoke-virtual {p0}, Landroid/net/sip/ISipSession$Stub;->getLocalIp()Ljava/lang/String;

    move-result-object v3

    .line 54
    .local v3, _result:Ljava/lang/String;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 55
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_9

    .line 60
    .end local v3           #_result:Ljava/lang/String;
    :sswitch_20
    const-string v6, "android.net.sip.ISipSession"

    invoke-virtual {p2, v6}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 61
    invoke-virtual {p0}, Landroid/net/sip/ISipSession$Stub;->getLocalProfile()Landroid/net/sip/SipProfile;

    move-result-object v3

    .line 62
    .local v3, _result:Landroid/net/sip/SipProfile;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 63
    if-eqz v3, :cond_35

    .line 64
    invoke-virtual {p3, v5}, Landroid/os/Parcel;->writeInt(I)V

    .line 65
    invoke-virtual {v3, p3, v5}, Landroid/net/sip/SipProfile;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_9

    .line 68
    :cond_35
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 74
    .end local v3           #_result:Landroid/net/sip/SipProfile;
    :sswitch_39
    const-string v6, "android.net.sip.ISipSession"

    invoke-virtual {p2, v6}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 75
    invoke-virtual {p0}, Landroid/net/sip/ISipSession$Stub;->getPeerProfile()Landroid/net/sip/SipProfile;

    move-result-object v3

    .line 76
    .restart local v3       #_result:Landroid/net/sip/SipProfile;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 77
    if-eqz v3, :cond_4e

    .line 78
    invoke-virtual {p3, v5}, Landroid/os/Parcel;->writeInt(I)V

    .line 79
    invoke-virtual {v3, p3, v5}, Landroid/net/sip/SipProfile;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_9

    .line 82
    :cond_4e
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 88
    .end local v3           #_result:Landroid/net/sip/SipProfile;
    :sswitch_52
    const-string v4, "android.net.sip.ISipSession"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 89
    invoke-virtual {p0}, Landroid/net/sip/ISipSession$Stub;->getState()I

    move-result v3

    .line 90
    .local v3, _result:I
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 91
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 96
    .end local v3           #_result:I
    :sswitch_62
    const-string v6, "android.net.sip.ISipSession"

    invoke-virtual {p2, v6}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 97
    invoke-virtual {p0}, Landroid/net/sip/ISipSession$Stub;->isInCall()Z

    move-result v3

    .line 98
    .local v3, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 99
    if-eqz v3, :cond_71

    move v4, v5

    :cond_71
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 104
    .end local v3           #_result:Z
    :sswitch_75
    const-string v4, "android.net.sip.ISipSession"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 105
    invoke-virtual {p0}, Landroid/net/sip/ISipSession$Stub;->getCallId()Ljava/lang/String;

    move-result-object v3

    .line 106
    .local v3, _result:Ljava/lang/String;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 107
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_9

    .line 112
    .end local v3           #_result:Ljava/lang/String;
    :sswitch_85
    const-string v4, "android.net.sip.ISipSession"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 114
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v4

    invoke-static {v4}, Landroid/net/sip/ISipSessionListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/net/sip/ISipSessionListener;

    move-result-object v0

    .line 115
    .local v0, _arg0:Landroid/net/sip/ISipSessionListener;
    invoke-virtual {p0, v0}, Landroid/net/sip/ISipSession$Stub;->setListener(Landroid/net/sip/ISipSessionListener;)V

    .line 116
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 121
    .end local v0           #_arg0:Landroid/net/sip/ISipSessionListener;
    :sswitch_9a
    const-string v4, "android.net.sip.ISipSession"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 123
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 124
    .local v0, _arg0:I
    invoke-virtual {p0, v0}, Landroid/net/sip/ISipSession$Stub;->register(I)V

    .line 125
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 130
    .end local v0           #_arg0:I
    :sswitch_ab
    const-string v4, "android.net.sip.ISipSession"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 131
    invoke-virtual {p0}, Landroid/net/sip/ISipSession$Stub;->unregister()V

    .line 132
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 137
    :sswitch_b8
    const-string v4, "android.net.sip.ISipSession"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 139
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_db

    .line 140
    sget-object v4, Landroid/net/sip/SipProfile;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v4, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/sip/SipProfile;

    .line 146
    .local v0, _arg0:Landroid/net/sip/SipProfile;
    :goto_cb
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 148
    .local v1, _arg1:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 149
    .local v2, _arg2:I
    invoke-virtual {p0, v0, v1, v2}, Landroid/net/sip/ISipSession$Stub;->makeCall(Landroid/net/sip/SipProfile;Ljava/lang/String;I)V

    .line 150
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 143
    .end local v0           #_arg0:Landroid/net/sip/SipProfile;
    .end local v1           #_arg1:Ljava/lang/String;
    .end local v2           #_arg2:I
    :cond_db
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/net/sip/SipProfile;
    goto :goto_cb

    .line 155
    .end local v0           #_arg0:Landroid/net/sip/SipProfile;
    :sswitch_dd
    const-string v4, "android.net.sip.ISipSession"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 157
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 159
    .local v0, _arg0:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 160
    .local v1, _arg1:I
    invoke-virtual {p0, v0, v1}, Landroid/net/sip/ISipSession$Stub;->answerCall(Ljava/lang/String;I)V

    .line 161
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 166
    .end local v0           #_arg0:Ljava/lang/String;
    .end local v1           #_arg1:I
    :sswitch_f2
    const-string v4, "android.net.sip.ISipSession"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 167
    invoke-virtual {p0}, Landroid/net/sip/ISipSession$Stub;->endCall()V

    .line 168
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 173
    :sswitch_ff
    const-string v4, "android.net.sip.ISipSession"

    invoke-virtual {p2, v4}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 175
    invoke-virtual {p2}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    .line 177
    .restart local v0       #_arg0:Ljava/lang/String;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 178
    .restart local v1       #_arg1:I
    invoke-virtual {p0, v0, v1}, Landroid/net/sip/ISipSession$Stub;->changeCall(Ljava/lang/String;I)V

    .line 179
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 43
    :sswitch_data_114
    .sparse-switch
        0x1 -> :sswitch_10
        0x2 -> :sswitch_20
        0x3 -> :sswitch_39
        0x4 -> :sswitch_52
        0x5 -> :sswitch_62
        0x6 -> :sswitch_75
        0x7 -> :sswitch_85
        0x8 -> :sswitch_9a
        0x9 -> :sswitch_ab
        0xa -> :sswitch_b8
        0xb -> :sswitch_dd
        0xc -> :sswitch_f2
        0xd -> :sswitch_ff
        0x5f4e5446 -> :sswitch_a
    .end sparse-switch
.end method
