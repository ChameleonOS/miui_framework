.class public Landroid/net/NetworkIdentity;
.super Ljava/lang/Object;
.source "NetworkIdentity.java"


# static fields
.field public static final COMBINE_SUBTYPE_ENABLED:Z = true

.field public static final SUBTYPE_COMBINED:I = -0x1


# instance fields
.field final mNetworkId:Ljava/lang/String;

.field final mRoaming:Z

.field final mSubType:I

.field final mSubscriberId:Ljava/lang/String;

.field final mType:I


# direct methods
.method public constructor <init>(IILjava/lang/String;Ljava/lang/String;Z)V
    .registers 7
    .parameter "type"
    .parameter "subType"
    .parameter "subscriberId"
    .parameter "networkId"
    .parameter "roaming"

    .prologue
    .line 53
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput p1, p0, Landroid/net/NetworkIdentity;->mType:I

    .line 55
    const/4 v0, -0x1

    iput v0, p0, Landroid/net/NetworkIdentity;->mSubType:I

    .line 56
    iput-object p3, p0, Landroid/net/NetworkIdentity;->mSubscriberId:Ljava/lang/String;

    .line 57
    iput-object p4, p0, Landroid/net/NetworkIdentity;->mNetworkId:Ljava/lang/String;

    .line 58
    iput-boolean p5, p0, Landroid/net/NetworkIdentity;->mRoaming:Z

    .line 59
    return-void
.end method

.method public static buildNetworkIdentity(Landroid/content/Context;Landroid/net/NetworkState;)Landroid/net/NetworkIdentity;
    .registers 11
    .parameter "context"
    .parameter "state"

    .prologue
    .line 140
    iget-object v0, p1, Landroid/net/NetworkState;->networkInfo:Landroid/net/NetworkInfo;

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v1

    .line 141
    .local v1, type:I
    iget-object v0, p1, Landroid/net/NetworkState;->networkInfo:Landroid/net/NetworkInfo;

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtype()I

    move-result v2

    .line 146
    .local v2, subType:I
    const/4 v3, 0x0

    .line 147
    .local v3, subscriberId:Ljava/lang/String;
    const/4 v4, 0x0

    .line 148
    .local v4, networkId:Ljava/lang/String;
    const/4 v5, 0x0

    .line 150
    .local v5, roaming:Z
    invoke-static {v1}, Landroid/net/ConnectivityManager;->isNetworkTypeMobile(I)Z

    move-result v0

    if-eqz v0, :cond_33

    .line 151
    const-string/jumbo v0, "phone"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/telephony/TelephonyManager;

    .line 153
    .local v7, telephony:Landroid/telephony/TelephonyManager;
    invoke-virtual {v7}, Landroid/telephony/TelephonyManager;->isNetworkRoaming()Z

    move-result v5

    .line 154
    iget-object v0, p1, Landroid/net/NetworkState;->subscriberId:Ljava/lang/String;

    if-eqz v0, :cond_2e

    .line 155
    iget-object v3, p1, Landroid/net/NetworkState;->subscriberId:Ljava/lang/String;

    .line 171
    .end local v7           #telephony:Landroid/telephony/TelephonyManager;
    :cond_28
    :goto_28
    new-instance v0, Landroid/net/NetworkIdentity;

    invoke-direct/range {v0 .. v5}, Landroid/net/NetworkIdentity;-><init>(IILjava/lang/String;Ljava/lang/String;Z)V

    return-object v0

    .line 157
    .restart local v7       #telephony:Landroid/telephony/TelephonyManager;
    :cond_2e
    invoke-virtual {v7}, Landroid/telephony/TelephonyManager;->getSubscriberId()Ljava/lang/String;

    move-result-object v3

    goto :goto_28

    .line 160
    .end local v7           #telephony:Landroid/telephony/TelephonyManager;
    :cond_33
    const/4 v0, 0x1

    if-ne v1, v0, :cond_28

    .line 161
    iget-object v0, p1, Landroid/net/NetworkState;->networkId:Ljava/lang/String;

    if-eqz v0, :cond_3d

    .line 162
    iget-object v4, p1, Landroid/net/NetworkState;->networkId:Ljava/lang/String;

    goto :goto_28

    .line 164
    :cond_3d
    const-string/jumbo v0, "wifi"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/net/wifi/WifiManager;

    .line 166
    .local v8, wifi:Landroid/net/wifi/WifiManager;
    invoke-virtual {v8}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v6

    .line 167
    .local v6, info:Landroid/net/wifi/WifiInfo;
    if-eqz v6, :cond_51

    invoke-virtual {v6}, Landroid/net/wifi/WifiInfo;->getSSID()Ljava/lang/String;

    move-result-object v4

    :goto_50
    goto :goto_28

    :cond_51
    const/4 v4, 0x0

    goto :goto_50
.end method

.method public static scrubSubscriberId(Ljava/lang/String;)Ljava/lang/String;
    .registers 5
    .parameter "subscriberId"

    .prologue
    .line 125
    const-string v0, "eng"

    sget-object v1, Landroid/os/Build;->TYPE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 131
    .end local p0
    :goto_a
    return-object p0

    .line 127
    .restart local p0
    :cond_b
    if-eqz p0, :cond_2f

    .line 129
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v1, 0x0

    const/4 v2, 0x6

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "..."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_a

    .line 131
    :cond_2f
    const-string/jumbo p0, "null"

    goto :goto_a
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6
    .parameter "obj"

    .prologue
    const/4 v1, 0x0

    .line 68
    instance-of v2, p1, Landroid/net/NetworkIdentity;

    if-eqz v2, :cond_2f

    move-object v0, p1

    .line 69
    check-cast v0, Landroid/net/NetworkIdentity;

    .line 70
    .local v0, ident:Landroid/net/NetworkIdentity;
    iget v2, p0, Landroid/net/NetworkIdentity;->mType:I

    iget v3, v0, Landroid/net/NetworkIdentity;->mType:I

    if-ne v2, v3, :cond_2f

    iget v2, p0, Landroid/net/NetworkIdentity;->mSubType:I

    iget v3, v0, Landroid/net/NetworkIdentity;->mSubType:I

    if-ne v2, v3, :cond_2f

    iget-boolean v2, p0, Landroid/net/NetworkIdentity;->mRoaming:Z

    iget-boolean v3, v0, Landroid/net/NetworkIdentity;->mRoaming:Z

    if-ne v2, v3, :cond_2f

    iget-object v2, p0, Landroid/net/NetworkIdentity;->mSubscriberId:Ljava/lang/String;

    iget-object v3, v0, Landroid/net/NetworkIdentity;->mSubscriberId:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/android/internal/util/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2f

    iget-object v2, p0, Landroid/net/NetworkIdentity;->mNetworkId:Ljava/lang/String;

    iget-object v3, v0, Landroid/net/NetworkIdentity;->mNetworkId:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/android/internal/util/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2f

    const/4 v1, 0x1

    .line 74
    .end local v0           #ident:Landroid/net/NetworkIdentity;
    :cond_2f
    return v1
.end method

.method public getNetworkId()Ljava/lang/String;
    .registers 2

    .prologue
    .line 114
    iget-object v0, p0, Landroid/net/NetworkIdentity;->mNetworkId:Ljava/lang/String;

    return-object v0
.end method

.method public getRoaming()Z
    .registers 2

    .prologue
    .line 118
    iget-boolean v0, p0, Landroid/net/NetworkIdentity;->mRoaming:Z

    return v0
.end method

.method public getSubType()I
    .registers 2

    .prologue
    .line 106
    iget v0, p0, Landroid/net/NetworkIdentity;->mSubType:I

    return v0
.end method

.method public getSubscriberId()Ljava/lang/String;
    .registers 2

    .prologue
    .line 110
    iget-object v0, p0, Landroid/net/NetworkIdentity;->mSubscriberId:Ljava/lang/String;

    return-object v0
.end method

.method public getType()I
    .registers 2

    .prologue
    .line 102
    iget v0, p0, Landroid/net/NetworkIdentity;->mType:I

    return v0
.end method

.method public hashCode()I
    .registers 4

    .prologue
    .line 63
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget v2, p0, Landroid/net/NetworkIdentity;->mType:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget v2, p0, Landroid/net/NetworkIdentity;->mSubType:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Landroid/net/NetworkIdentity;->mSubscriberId:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-object v2, p0, Landroid/net/NetworkIdentity;->mNetworkId:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x4

    iget-boolean v2, p0, Landroid/net/NetworkIdentity;->mRoaming:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/android/internal/util/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 79
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 80
    .local v0, builder:Ljava/lang/StringBuilder;
    const-string/jumbo v1, "type="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/net/NetworkIdentity;->mType:I

    invoke-static {v2}, Landroid/net/ConnectivityManager;->getNetworkTypeName(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 81
    const-string v1, ", subType="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 83
    const-string v1, "COMBINED"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 89
    iget-object v1, p0, Landroid/net/NetworkIdentity;->mSubscriberId:Ljava/lang/String;

    if-eqz v1, :cond_34

    .line 90
    const-string v1, ", subscriberId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/net/NetworkIdentity;->mSubscriberId:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/NetworkIdentity;->scrubSubscriberId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 92
    :cond_34
    iget-object v1, p0, Landroid/net/NetworkIdentity;->mNetworkId:Ljava/lang/String;

    if-eqz v1, :cond_43

    .line 93
    const-string v1, ", networkId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/net/NetworkIdentity;->mNetworkId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 95
    :cond_43
    iget-boolean v1, p0, Landroid/net/NetworkIdentity;->mRoaming:Z

    if-eqz v1, :cond_4c

    .line 96
    const-string v1, ", ROAMING"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 98
    :cond_4c
    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
