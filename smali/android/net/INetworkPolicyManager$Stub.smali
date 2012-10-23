.class public abstract Landroid/net/INetworkPolicyManager$Stub;
.super Landroid/os/Binder;
.source "INetworkPolicyManager.java"

# interfaces
.implements Landroid/net/INetworkPolicyManager;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/INetworkPolicyManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/INetworkPolicyManager$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.net.INetworkPolicyManager"

.field static final TRANSACTION_getAppPolicy:I = 0x2

.field static final TRANSACTION_getAppsWithPolicy:I = 0x3

.field static final TRANSACTION_getNetworkPolicies:I = 0x8

.field static final TRANSACTION_getNetworkQuotaInfo:I = 0xc

.field static final TRANSACTION_getRestrictBackground:I = 0xb

.field static final TRANSACTION_isNetworkMetered:I = 0xd

.field static final TRANSACTION_isUidForeground:I = 0x4

.field static final TRANSACTION_registerListener:I = 0x5

.field static final TRANSACTION_setAppPolicy:I = 0x1

.field static final TRANSACTION_setNetworkPolicies:I = 0x7

.field static final TRANSACTION_setRestrictBackground:I = 0xa

.field static final TRANSACTION_snoozeLimit:I = 0x9

.field static final TRANSACTION_unregisterListener:I = 0x6


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 20
    const-string v0, "android.net.INetworkPolicyManager"

    invoke-virtual {p0, p0, v0}, Landroid/net/INetworkPolicyManager$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 21
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/net/INetworkPolicyManager;
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
    const-string v1, "android.net.INetworkPolicyManager"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 32
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/net/INetworkPolicyManager;

    if-eqz v1, :cond_13

    .line 33
    check-cast v0, Landroid/net/INetworkPolicyManager;

    goto :goto_3

    .line 35
    :cond_13
    new-instance v0, Landroid/net/INetworkPolicyManager$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/net/INetworkPolicyManager$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

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
    const/4 v3, 0x0

    const/4 v4, 0x1

    .line 43
    sparse-switch p1, :sswitch_data_148

    .line 194
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v4

    :goto_9
    return v4

    .line 47
    :sswitch_a
    const-string v3, "android.net.INetworkPolicyManager"

    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_9

    .line 52
    :sswitch_10
    const-string v3, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 54
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 56
    .local v0, _arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 57
    .local v1, _arg1:I
    invoke-virtual {p0, v0, v1}, Landroid/net/INetworkPolicyManager$Stub;->setAppPolicy(II)V

    .line 58
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 63
    .end local v0           #_arg0:I
    .end local v1           #_arg1:I
    :sswitch_24
    const-string v3, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 65
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 66
    .restart local v0       #_arg0:I
    invoke-virtual {p0, v0}, Landroid/net/INetworkPolicyManager$Stub;->getAppPolicy(I)I

    move-result v2

    .line 67
    .local v2, _result:I
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 68
    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 73
    .end local v0           #_arg0:I
    .end local v2           #_result:I
    :sswitch_38
    const-string v3, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 75
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 76
    .restart local v0       #_arg0:I
    invoke-virtual {p0, v0}, Landroid/net/INetworkPolicyManager$Stub;->getAppsWithPolicy(I)[I

    move-result-object v2

    .line 77
    .local v2, _result:[I
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 78
    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeIntArray([I)V

    goto :goto_9

    .line 83
    .end local v0           #_arg0:I
    .end local v2           #_result:[I
    :sswitch_4c
    const-string v5, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 85
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 86
    .restart local v0       #_arg0:I
    invoke-virtual {p0, v0}, Landroid/net/INetworkPolicyManager$Stub;->isUidForeground(I)Z

    move-result v2

    .line 87
    .local v2, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 88
    if-eqz v2, :cond_5f

    move v3, v4

    :cond_5f
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 93
    .end local v0           #_arg0:I
    .end local v2           #_result:Z
    :sswitch_63
    const-string v3, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 95
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v3

    invoke-static {v3}, Landroid/net/INetworkPolicyListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/net/INetworkPolicyListener;

    move-result-object v0

    .line 96
    .local v0, _arg0:Landroid/net/INetworkPolicyListener;
    invoke-virtual {p0, v0}, Landroid/net/INetworkPolicyManager$Stub;->registerListener(Landroid/net/INetworkPolicyListener;)V

    .line 97
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto :goto_9

    .line 102
    .end local v0           #_arg0:Landroid/net/INetworkPolicyListener;
    :sswitch_77
    const-string v3, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 104
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v3

    invoke-static {v3}, Landroid/net/INetworkPolicyListener$Stub;->asInterface(Landroid/os/IBinder;)Landroid/net/INetworkPolicyListener;

    move-result-object v0

    .line 105
    .restart local v0       #_arg0:Landroid/net/INetworkPolicyListener;
    invoke-virtual {p0, v0}, Landroid/net/INetworkPolicyManager$Stub;->unregisterListener(Landroid/net/INetworkPolicyListener;)V

    .line 106
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 111
    .end local v0           #_arg0:Landroid/net/INetworkPolicyListener;
    :sswitch_8c
    const-string v3, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 113
    sget-object v3, Landroid/net/NetworkPolicy;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->createTypedArray(Landroid/os/Parcelable$Creator;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/net/NetworkPolicy;

    .line 114
    .local v0, _arg0:[Landroid/net/NetworkPolicy;
    invoke-virtual {p0, v0}, Landroid/net/INetworkPolicyManager$Stub;->setNetworkPolicies([Landroid/net/NetworkPolicy;)V

    .line 115
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 120
    .end local v0           #_arg0:[Landroid/net/NetworkPolicy;
    :sswitch_a1
    const-string v3, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 121
    invoke-virtual {p0}, Landroid/net/INetworkPolicyManager$Stub;->getNetworkPolicies()[Landroid/net/NetworkPolicy;

    move-result-object v2

    .line 122
    .local v2, _result:[Landroid/net/NetworkPolicy;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 123
    invoke-virtual {p3, v2, v4}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    goto/16 :goto_9

    .line 128
    .end local v2           #_result:[Landroid/net/NetworkPolicy;
    :sswitch_b2
    const-string v3, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v3}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 130
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v3

    if-eqz v3, :cond_cd

    .line 131
    sget-object v3, Landroid/net/NetworkTemplate;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v3, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/NetworkTemplate;

    .line 136
    .local v0, _arg0:Landroid/net/NetworkTemplate;
    :goto_c5
    invoke-virtual {p0, v0}, Landroid/net/INetworkPolicyManager$Stub;->snoozeLimit(Landroid/net/NetworkTemplate;)V

    .line 137
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 134
    .end local v0           #_arg0:Landroid/net/NetworkTemplate;
    :cond_cd
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/net/NetworkTemplate;
    goto :goto_c5

    .line 142
    .end local v0           #_arg0:Landroid/net/NetworkTemplate;
    :sswitch_cf
    const-string v5, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 144
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_e3

    move v0, v4

    .line 145
    .local v0, _arg0:Z
    :goto_db
    invoke-virtual {p0, v0}, Landroid/net/INetworkPolicyManager$Stub;->setRestrictBackground(Z)V

    .line 146
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .end local v0           #_arg0:Z
    :cond_e3
    move v0, v3

    .line 144
    goto :goto_db

    .line 151
    :sswitch_e5
    const-string v5, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 152
    invoke-virtual {p0}, Landroid/net/INetworkPolicyManager$Stub;->getRestrictBackground()Z

    move-result v2

    .line 153
    .local v2, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 154
    if-eqz v2, :cond_f4

    move v3, v4

    :cond_f4
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_9

    .line 159
    .end local v2           #_result:Z
    :sswitch_f9
    const-string v5, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 161
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_11d

    .line 162
    sget-object v5, Landroid/net/NetworkState;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/NetworkState;

    .line 167
    .local v0, _arg0:Landroid/net/NetworkState;
    :goto_10c
    invoke-virtual {p0, v0}, Landroid/net/INetworkPolicyManager$Stub;->getNetworkQuotaInfo(Landroid/net/NetworkState;)Landroid/net/NetworkQuotaInfo;

    move-result-object v2

    .line 168
    .local v2, _result:Landroid/net/NetworkQuotaInfo;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 169
    if-eqz v2, :cond_11f

    .line 170
    invoke-virtual {p3, v4}, Landroid/os/Parcel;->writeInt(I)V

    .line 171
    invoke-virtual {v2, p3, v4}, Landroid/net/NetworkQuotaInfo;->writeToParcel(Landroid/os/Parcel;I)V

    goto/16 :goto_9

    .line 165
    .end local v0           #_arg0:Landroid/net/NetworkState;
    .end local v2           #_result:Landroid/net/NetworkQuotaInfo;
    :cond_11d
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/net/NetworkState;
    goto :goto_10c

    .line 174
    .restart local v2       #_result:Landroid/net/NetworkQuotaInfo;
    :cond_11f
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_9

    .line 180
    .end local v0           #_arg0:Landroid/net/NetworkState;
    .end local v2           #_result:Landroid/net/NetworkQuotaInfo;
    :sswitch_124
    const-string v5, "android.net.INetworkPolicyManager"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 182
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_146

    .line 183
    sget-object v5, Landroid/net/NetworkState;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/NetworkState;

    .line 188
    .restart local v0       #_arg0:Landroid/net/NetworkState;
    :goto_137
    invoke-virtual {p0, v0}, Landroid/net/INetworkPolicyManager$Stub;->isNetworkMetered(Landroid/net/NetworkState;)Z

    move-result v2

    .line 189
    .local v2, _result:Z
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 190
    if-eqz v2, :cond_141

    move v3, v4

    :cond_141
    invoke-virtual {p3, v3}, Landroid/os/Parcel;->writeInt(I)V

    goto/16 :goto_9

    .line 186
    .end local v0           #_arg0:Landroid/net/NetworkState;
    .end local v2           #_result:Z
    :cond_146
    const/4 v0, 0x0

    .restart local v0       #_arg0:Landroid/net/NetworkState;
    goto :goto_137

    .line 43
    :sswitch_data_148
    .sparse-switch
        0x1 -> :sswitch_10
        0x2 -> :sswitch_24
        0x3 -> :sswitch_38
        0x4 -> :sswitch_4c
        0x5 -> :sswitch_63
        0x6 -> :sswitch_77
        0x7 -> :sswitch_8c
        0x8 -> :sswitch_a1
        0x9 -> :sswitch_b2
        0xa -> :sswitch_cf
        0xb -> :sswitch_e5
        0xc -> :sswitch_f9
        0xd -> :sswitch_124
        0x5f4e5446 -> :sswitch_a
    .end sparse-switch
.end method
