.class public abstract Landroid/net/INetworkStatsService$Stub;
.super Landroid/os/Binder;
.source "INetworkStatsService.java"

# interfaces
.implements Landroid/net/INetworkStatsService;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/INetworkStatsService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/INetworkStatsService$Stub$Proxy;
    }
.end annotation


# static fields
.field private static final DESCRIPTOR:Ljava/lang/String; = "android.net.INetworkStatsService"

.field static final TRANSACTION_advisePersistThreshold:I = 0x8

.field static final TRANSACTION_forceUpdate:I = 0x7

.field static final TRANSACTION_getDataLayerSnapshotForUid:I = 0x3

.field static final TRANSACTION_getMobileIfaces:I = 0x4

.field static final TRANSACTION_getNetworkTotalBytes:I = 0x2

.field static final TRANSACTION_incrementOperationCount:I = 0x5

.field static final TRANSACTION_openSession:I = 0x1

.field static final TRANSACTION_setUidForeground:I = 0x6


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 16
    const-string v0, "android.net.INetworkStatsService"

    invoke-virtual {p0, p0, v0}, Landroid/net/INetworkStatsService$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 17
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Landroid/net/INetworkStatsService;
    .registers 3
    .parameter "obj"

    .prologue
    .line 24
    if-nez p0, :cond_4

    .line 25
    const/4 v0, 0x0

    .line 31
    :goto_3
    return-object v0

    .line 27
    :cond_4
    const-string v1, "android.net.INetworkStatsService"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 28
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_13

    instance-of v1, v0, Landroid/net/INetworkStatsService;

    if-eqz v1, :cond_13

    .line 29
    check-cast v0, Landroid/net/INetworkStatsService;

    goto :goto_3

    .line 31
    :cond_13
    new-instance v0, Landroid/net/INetworkStatsService$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Landroid/net/INetworkStatsService$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_3
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 1

    .prologue
    .line 35
    return-object p0
.end method

.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .registers 16
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

    const/4 v10, 0x1

    .line 39
    sparse-switch p1, :sswitch_data_ce

    .line 138
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v10

    :goto_9
    return v10

    .line 43
    :sswitch_a
    const-string v0, "android.net.INetworkStatsService"

    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_9

    .line 48
    :sswitch_10
    const-string v0, "android.net.INetworkStatsService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 49
    invoke-virtual {p0}, Landroid/net/INetworkStatsService$Stub;->openSession()Landroid/net/INetworkStatsSession;

    move-result-object v8

    .line 50
    .local v8, _result:Landroid/net/INetworkStatsSession;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 51
    if-eqz v8, :cond_26

    invoke-interface {v8}, Landroid/net/INetworkStatsSession;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    :goto_22
    invoke-virtual {p3, v0}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    goto :goto_9

    :cond_26
    const/4 v0, 0x0

    goto :goto_22

    .line 56
    .end local v8           #_result:Landroid/net/INetworkStatsSession;
    :sswitch_28
    const-string v0, "android.net.INetworkStatsService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 58
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_4f

    .line 59
    sget-object v0, Landroid/net/NetworkTemplate;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/NetworkTemplate;

    .line 65
    .local v1, _arg0:Landroid/net/NetworkTemplate;
    :goto_3b
    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v2

    .line 67
    .local v2, _arg1:J
    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    .local v4, _arg2:J
    move-object v0, p0

    .line 68
    invoke-virtual/range {v0 .. v5}, Landroid/net/INetworkStatsService$Stub;->getNetworkTotalBytes(Landroid/net/NetworkTemplate;JJ)J

    move-result-wide v8

    .line 69
    .local v8, _result:J
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 70
    invoke-virtual {p3, v8, v9}, Landroid/os/Parcel;->writeLong(J)V

    goto :goto_9

    .line 62
    .end local v1           #_arg0:Landroid/net/NetworkTemplate;
    .end local v2           #_arg1:J
    .end local v4           #_arg2:J
    .end local v8           #_result:J
    :cond_4f
    const/4 v1, 0x0

    .restart local v1       #_arg0:Landroid/net/NetworkTemplate;
    goto :goto_3b

    .line 75
    .end local v1           #_arg0:Landroid/net/NetworkTemplate;
    :sswitch_51
    const-string v0, "android.net.INetworkStatsService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 77
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 78
    .local v1, _arg0:I
    invoke-virtual {p0, v1}, Landroid/net/INetworkStatsService$Stub;->getDataLayerSnapshotForUid(I)Landroid/net/NetworkStats;

    move-result-object v8

    .line 79
    .local v8, _result:Landroid/net/NetworkStats;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 80
    if-eqz v8, :cond_6a

    .line 81
    invoke-virtual {p3, v10}, Landroid/os/Parcel;->writeInt(I)V

    .line 82
    invoke-virtual {v8, p3, v10}, Landroid/net/NetworkStats;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_9

    .line 85
    :cond_6a
    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_9

    .line 91
    .end local v1           #_arg0:I
    .end local v8           #_result:Landroid/net/NetworkStats;
    :sswitch_6e
    const-string v0, "android.net.INetworkStatsService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 92
    invoke-virtual {p0}, Landroid/net/INetworkStatsService$Stub;->getMobileIfaces()[Ljava/lang/String;

    move-result-object v8

    .line 93
    .local v8, _result:[Ljava/lang/String;
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    .line 94
    invoke-virtual {p3, v8}, Landroid/os/Parcel;->writeStringArray([Ljava/lang/String;)V

    goto :goto_9

    .line 99
    .end local v8           #_result:[Ljava/lang/String;
    :sswitch_7e
    const-string v0, "android.net.INetworkStatsService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 101
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 103
    .restart local v1       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 105
    .local v2, _arg1:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v4

    .line 106
    .local v4, _arg2:I
    invoke-virtual {p0, v1, v2, v4}, Landroid/net/INetworkStatsService$Stub;->incrementOperationCount(III)V

    .line 107
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 112
    .end local v1           #_arg0:I
    .end local v2           #_arg1:I
    .end local v4           #_arg2:I
    :sswitch_97
    const-string v0, "android.net.INetworkStatsService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 114
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 116
    .restart local v1       #_arg0:I
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_a7

    move v2, v10

    .line 117
    .local v2, _arg1:Z
    :cond_a7
    invoke-virtual {p0, v1, v2}, Landroid/net/INetworkStatsService$Stub;->setUidForeground(IZ)V

    .line 118
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 123
    .end local v1           #_arg0:I
    .end local v2           #_arg1:Z
    :sswitch_af
    const-string v0, "android.net.INetworkStatsService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 124
    invoke-virtual {p0}, Landroid/net/INetworkStatsService$Stub;->forceUpdate()V

    .line 125
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 130
    :sswitch_bc
    const-string v0, "android.net.INetworkStatsService"

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 132
    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v6

    .line 133
    .local v6, _arg0:J
    invoke-virtual {p0, v6, v7}, Landroid/net/INetworkStatsService$Stub;->advisePersistThreshold(J)V

    .line 134
    invoke-virtual {p3}, Landroid/os/Parcel;->writeNoException()V

    goto/16 :goto_9

    .line 39
    nop

    :sswitch_data_ce
    .sparse-switch
        0x1 -> :sswitch_10
        0x2 -> :sswitch_28
        0x3 -> :sswitch_51
        0x4 -> :sswitch_6e
        0x5 -> :sswitch_7e
        0x6 -> :sswitch_97
        0x7 -> :sswitch_af
        0x8 -> :sswitch_bc
        0x5f4e5446 -> :sswitch_a
    .end sparse-switch
.end method
