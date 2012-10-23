.class public Lcom/android/internal/telephony/DataCallState;
.super Ljava/lang/Object;
.source "DataCallState.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/telephony/DataCallState$SetupResult;
    }
.end annotation


# instance fields
.field private final DBG:Z

.field private final LOG_TAG:Ljava/lang/String;

.field public active:I

.field public addresses:[Ljava/lang/String;

.field public cid:I

.field public dnses:[Ljava/lang/String;

.field public gateways:[Ljava/lang/String;

.field public ifname:Ljava/lang/String;

.field public status:I

.field public suggestedRetryTime:I

.field public type:Ljava/lang/String;

.field public version:I


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 37
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 38
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/internal/telephony/DataCallState;->DBG:Z

    .line 39
    const-string v0, "GSM"

    iput-object v0, p0, Lcom/android/internal/telephony/DataCallState;->LOG_TAG:Ljava/lang/String;

    .line 41
    iput v1, p0, Lcom/android/internal/telephony/DataCallState;->version:I

    .line 42
    iput v1, p0, Lcom/android/internal/telephony/DataCallState;->status:I

    .line 43
    iput v1, p0, Lcom/android/internal/telephony/DataCallState;->cid:I

    .line 44
    iput v1, p0, Lcom/android/internal/telephony/DataCallState;->active:I

    .line 45
    const-string v0, ""

    iput-object v0, p0, Lcom/android/internal/telephony/DataCallState;->type:Ljava/lang/String;

    .line 46
    const-string v0, ""

    iput-object v0, p0, Lcom/android/internal/telephony/DataCallState;->ifname:Ljava/lang/String;

    .line 47
    new-array v0, v1, [Ljava/lang/String;

    iput-object v0, p0, Lcom/android/internal/telephony/DataCallState;->addresses:[Ljava/lang/String;

    .line 48
    new-array v0, v1, [Ljava/lang/String;

    iput-object v0, p0, Lcom/android/internal/telephony/DataCallState;->dnses:[Ljava/lang/String;

    .line 49
    new-array v0, v1, [Ljava/lang/String;

    iput-object v0, p0, Lcom/android/internal/telephony/DataCallState;->gateways:[Ljava/lang/String;

    .line 50
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/internal/telephony/DataCallState;->suggestedRetryTime:I

    .line 55
    return-void
.end method


# virtual methods
.method public setLinkProperties(Landroid/net/LinkProperties;Z)Lcom/android/internal/telephony/DataCallState$SetupResult;
    .registers 21
    .parameter "linkProperties"
    .parameter "okToUseSystemPropertyDns"

    .prologue
    .line 114
    if-nez p1, :cond_62

    .line 115
    new-instance p1, Landroid/net/LinkProperties;

    .end local p1
    invoke-direct/range {p1 .. p1}, Landroid/net/LinkProperties;-><init>()V

    .line 119
    .restart local p1
    :goto_7
    move-object/from16 v0, p0

    iget v15, v0, Lcom/android/internal/telephony/DataCallState;->status:I

    sget-object v16, Lcom/android/internal/telephony/DataConnection$FailCause;->NONE:Lcom/android/internal/telephony/DataConnection$FailCause;

    invoke-virtual/range {v16 .. v16}, Lcom/android/internal/telephony/DataConnection$FailCause;->getErrorCode()I

    move-result v16

    move/from16 v0, v16

    if-ne v15, v0, :cond_2b0

    .line 120
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v16, "net."

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/DataCallState;->ifname:Ljava/lang/String;

    move-object/from16 v16, v0

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "."

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 124
    .local v12, propertyPrefix:Ljava/lang/String;
    :try_start_35
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/android/internal/telephony/DataCallState;->ifname:Ljava/lang/String;

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/net/LinkProperties;->setInterfaceName(Ljava/lang/String;)V

    .line 127
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/android/internal/telephony/DataCallState;->addresses:[Ljava/lang/String;

    if-eqz v15, :cond_137

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/android/internal/telephony/DataCallState;->addresses:[Ljava/lang/String;

    array-length v15, v15

    if-lez v15, :cond_137

    .line 128
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/internal/telephony/DataCallState;->addresses:[Ljava/lang/String;

    .local v4, arr$:[Ljava/lang/String;
    array-length v11, v4

    .local v11, len$:I
    const/4 v8, 0x0

    .local v8, i$:I
    :goto_51
    if-ge v8, v11, :cond_157

    aget-object v1, v4, v8

    .line 129
    .local v1, addr:Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 130
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z
    :try_end_5c
    .catch Ljava/net/UnknownHostException; {:try_start_35 .. :try_end_5c} :catch_c0

    move-result v15

    if-eqz v15, :cond_66

    .line 128
    :cond_5f
    :goto_5f
    add-int/lit8 v8, v8, 0x1

    goto :goto_51

    .line 117
    .end local v1           #addr:Ljava/lang/String;
    .end local v4           #arr$:[Ljava/lang/String;
    .end local v8           #i$:I
    .end local v11           #len$:I
    .end local v12           #propertyPrefix:Ljava/lang/String;
    :cond_62
    invoke-virtual/range {p1 .. p1}, Landroid/net/LinkProperties;->clear()V

    goto :goto_7

    .line 134
    .restart local v1       #addr:Ljava/lang/String;
    .restart local v4       #arr$:[Ljava/lang/String;
    .restart local v8       #i$:I
    .restart local v11       #len$:I
    .restart local v12       #propertyPrefix:Ljava/lang/String;
    :cond_66
    :try_start_66
    const-string v15, "/"

    invoke-virtual {v1, v15}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 135
    .local v3, ap:[Ljava/lang/String;
    array-length v15, v3

    const/16 v16, 0x2

    move/from16 v0, v16

    if-ne v15, v0, :cond_114

    .line 136
    const/4 v15, 0x0

    aget-object v1, v3, v15

    .line 137
    const/4 v15, 0x1

    aget-object v15, v3, v15

    invoke-static {v15}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_7c
    .catch Ljava/net/UnknownHostException; {:try_start_66 .. :try_end_7c} :catch_c0

    move-result v2

    .line 143
    .local v2, addrPrefixLen:I
    :goto_7d
    :try_start_7d
    invoke-static {v1}, Landroid/net/NetworkUtils;->numericToInetAddress(Ljava/lang/String;)Ljava/net/InetAddress;
    :try_end_80
    .catch Ljava/lang/IllegalArgumentException; {:try_start_7d .. :try_end_80} :catch_117
    .catch Ljava/net/UnknownHostException; {:try_start_7d .. :try_end_80} :catch_c0

    move-result-object v9

    .line 147
    .local v9, ia:Ljava/net/InetAddress;
    :try_start_81
    invoke-virtual {v9}, Ljava/net/InetAddress;->isAnyLocalAddress()Z

    move-result v15

    if-nez v15, :cond_5f

    .line 148
    if-nez v2, :cond_8f

    .line 150
    instance-of v15, v9, Ljava/net/Inet4Address;

    if-eqz v15, :cond_133

    const/16 v2, 0x20

    .line 152
    :cond_8f
    :goto_8f
    const-string v15, "GSM"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "addr/pl="

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, "/"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 153
    new-instance v10, Landroid/net/LinkAddress;

    invoke-direct {v10, v9, v2}, Landroid/net/LinkAddress;-><init>(Ljava/net/InetAddress;I)V

    .line 154
    .local v10, la:Landroid/net/LinkAddress;
    move-object/from16 v0, p1

    invoke-virtual {v0, v10}, Landroid/net/LinkProperties;->addLinkAddress(Landroid/net/LinkAddress;)V
    :try_end_bf
    .catch Ljava/net/UnknownHostException; {:try_start_81 .. :try_end_bf} :catch_c0

    goto :goto_5f

    .line 221
    .end local v1           #addr:Ljava/lang/String;
    .end local v2           #addrPrefixLen:I
    .end local v3           #ap:[Ljava/lang/String;
    .end local v4           #arr$:[Ljava/lang/String;
    .end local v8           #i$:I
    .end local v9           #ia:Ljava/net/InetAddress;
    .end local v10           #la:Landroid/net/LinkAddress;
    .end local v11           #len$:I
    :catch_c0
    move-exception v7

    .line 222
    .local v7, e:Ljava/net/UnknownHostException;
    const-string v15, "GSM"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v17, "setLinkProperties: UnknownHostException "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 223
    invoke-virtual {v7}, Ljava/net/UnknownHostException;->printStackTrace()V

    .line 224
    sget-object v13, Lcom/android/internal/telephony/DataCallState$SetupResult;->ERR_UnacceptableParameter:Lcom/android/internal/telephony/DataCallState$SetupResult;

    .line 235
    .end local v7           #e:Ljava/net/UnknownHostException;
    .end local v12           #propertyPrefix:Ljava/lang/String;
    .local v13, result:Lcom/android/internal/telephony/DataCallState$SetupResult;
    :goto_e1
    sget-object v15, Lcom/android/internal/telephony/DataCallState$SetupResult;->SUCCESS:Lcom/android/internal/telephony/DataCallState$SetupResult;

    if-eq v13, v15, :cond_113

    .line 237
    const-string v15, "GSM"

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v17, "setLinkProperties: error clearing LinkProperties status="

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/internal/telephony/DataCallState;->status:I

    move/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, " result="

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v15 .. v16}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 240
    invoke-virtual/range {p1 .. p1}, Landroid/net/LinkProperties;->clear()V

    .line 243
    :cond_113
    return-object v13

    .line 139
    .end local v13           #result:Lcom/android/internal/telephony/DataCallState$SetupResult;
    .restart local v1       #addr:Ljava/lang/String;
    .restart local v3       #ap:[Ljava/lang/String;
    .restart local v4       #arr$:[Ljava/lang/String;
    .restart local v8       #i$:I
    .restart local v11       #len$:I
    .restart local v12       #propertyPrefix:Ljava/lang/String;
    :cond_114
    const/4 v2, 0x0

    .restart local v2       #addrPrefixLen:I
    goto/16 :goto_7d

    .line 144
    :catch_117
    move-exception v7

    .line 145
    .local v7, e:Ljava/lang/IllegalArgumentException;
    :try_start_118
    new-instance v15, Ljava/net/UnknownHostException;

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "Non-numeric ip addr="

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-direct/range {v15 .. v16}, Ljava/net/UnknownHostException;-><init>(Ljava/lang/String;)V

    throw v15

    .line 150
    .end local v7           #e:Ljava/lang/IllegalArgumentException;
    .restart local v9       #ia:Ljava/net/InetAddress;
    :cond_133
    const/16 v2, 0x80

    goto/16 :goto_8f

    .line 158
    .end local v1           #addr:Ljava/lang/String;
    .end local v2           #addrPrefixLen:I
    .end local v3           #ap:[Ljava/lang/String;
    .end local v4           #arr$:[Ljava/lang/String;
    .end local v8           #i$:I
    .end local v9           #ia:Ljava/net/InetAddress;
    .end local v11           #len$:I
    :cond_137
    new-instance v15, Ljava/net/UnknownHostException;

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v17, "no address for ifname="

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/internal/telephony/DataCallState;->ifname:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-direct/range {v15 .. v16}, Ljava/net/UnknownHostException;-><init>(Ljava/lang/String;)V

    throw v15

    .line 162
    .restart local v4       #arr$:[Ljava/lang/String;
    .restart local v8       #i$:I
    .restart local v11       #len$:I
    :cond_157
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/android/internal/telephony/DataCallState;->dnses:[Ljava/lang/String;

    if-eqz v15, :cond_1a7

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/android/internal/telephony/DataCallState;->dnses:[Ljava/lang/String;

    array-length v15, v15

    if-lez v15, :cond_1a7

    .line 163
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/internal/telephony/DataCallState;->dnses:[Ljava/lang/String;

    array-length v11, v4

    const/4 v8, 0x0

    :goto_16a
    if-ge v8, v11, :cond_22c

    aget-object v1, v4, v8

    .line 164
    .restart local v1       #addr:Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 165
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z
    :try_end_175
    .catch Ljava/net/UnknownHostException; {:try_start_118 .. :try_end_175} :catch_c0

    move-result v15

    if-eqz v15, :cond_17b

    .line 163
    :cond_178
    :goto_178
    add-int/lit8 v8, v8, 0x1

    goto :goto_16a

    .line 168
    :cond_17b
    :try_start_17b
    invoke-static {v1}, Landroid/net/NetworkUtils;->numericToInetAddress(Ljava/lang/String;)Ljava/net/InetAddress;
    :try_end_17e
    .catch Ljava/lang/IllegalArgumentException; {:try_start_17b .. :try_end_17e} :catch_18b
    .catch Ljava/net/UnknownHostException; {:try_start_17b .. :try_end_17e} :catch_c0

    move-result-object v9

    .line 172
    .restart local v9       #ia:Ljava/net/InetAddress;
    :try_start_17f
    invoke-virtual {v9}, Ljava/net/InetAddress;->isAnyLocalAddress()Z

    move-result v15

    if-nez v15, :cond_178

    .line 173
    move-object/from16 v0, p1

    invoke-virtual {v0, v9}, Landroid/net/LinkProperties;->addDns(Ljava/net/InetAddress;)V

    goto :goto_178

    .line 169
    .end local v9           #ia:Ljava/net/InetAddress;
    :catch_18b
    move-exception v7

    .line 170
    .restart local v7       #e:Ljava/lang/IllegalArgumentException;
    new-instance v15, Ljava/net/UnknownHostException;

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "Non-numeric dns addr="

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-direct/range {v15 .. v16}, Ljava/net/UnknownHostException;-><init>(Ljava/lang/String;)V

    throw v15

    .line 176
    .end local v1           #addr:Ljava/lang/String;
    .end local v7           #e:Ljava/lang/IllegalArgumentException;
    :cond_1a7
    if-eqz p2, :cond_224

    .line 177
    const/4 v15, 0x2

    new-array v6, v15, [Ljava/lang/String;

    .line 178
    .local v6, dnsServers:[Ljava/lang/String;
    const/4 v15, 0x0

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, "dns1"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v16 .. v16}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    aput-object v16, v6, v15

    .line 179
    const/4 v15, 0x1

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v16

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, "dns2"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v16 .. v16}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    aput-object v16, v6, v15

    .line 180
    move-object v4, v6

    array-length v11, v4

    const/4 v8, 0x0

    :goto_1e7
    if-ge v8, v11, :cond_22c

    aget-object v5, v4, v8

    .line 181
    .local v5, dnsAddr:Ljava/lang/String;
    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    .line 182
    invoke-virtual {v5}, Ljava/lang/String;->isEmpty()Z
    :try_end_1f2
    .catch Ljava/net/UnknownHostException; {:try_start_17f .. :try_end_1f2} :catch_c0

    move-result v15

    if-eqz v15, :cond_1f8

    .line 180
    :cond_1f5
    :goto_1f5
    add-int/lit8 v8, v8, 0x1

    goto :goto_1e7

    .line 185
    :cond_1f8
    :try_start_1f8
    invoke-static {v5}, Landroid/net/NetworkUtils;->numericToInetAddress(Ljava/lang/String;)Ljava/net/InetAddress;
    :try_end_1fb
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1f8 .. :try_end_1fb} :catch_208
    .catch Ljava/net/UnknownHostException; {:try_start_1f8 .. :try_end_1fb} :catch_c0

    move-result-object v9

    .line 189
    .restart local v9       #ia:Ljava/net/InetAddress;
    :try_start_1fc
    invoke-virtual {v9}, Ljava/net/InetAddress;->isAnyLocalAddress()Z

    move-result v15

    if-nez v15, :cond_1f5

    .line 190
    move-object/from16 v0, p1

    invoke-virtual {v0, v9}, Landroid/net/LinkProperties;->addDns(Ljava/net/InetAddress;)V

    goto :goto_1f5

    .line 186
    .end local v9           #ia:Ljava/net/InetAddress;
    :catch_208
    move-exception v7

    .line 187
    .restart local v7       #e:Ljava/lang/IllegalArgumentException;
    new-instance v15, Ljava/net/UnknownHostException;

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "Non-numeric dns addr="

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-direct/range {v15 .. v16}, Ljava/net/UnknownHostException;-><init>(Ljava/lang/String;)V

    throw v15

    .line 194
    .end local v5           #dnsAddr:Ljava/lang/String;
    .end local v6           #dnsServers:[Ljava/lang/String;
    .end local v7           #e:Ljava/lang/IllegalArgumentException;
    :cond_224
    new-instance v15, Ljava/net/UnknownHostException;

    const-string v16, "Empty dns response and no system default dns"

    invoke-direct/range {v15 .. v16}, Ljava/net/UnknownHostException;-><init>(Ljava/lang/String;)V

    throw v15

    .line 198
    :cond_22c
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/android/internal/telephony/DataCallState;->gateways:[Ljava/lang/String;

    if-eqz v15, :cond_239

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/android/internal/telephony/DataCallState;->gateways:[Ljava/lang/String;

    array-length v15, v15

    if-nez v15, :cond_25c

    .line 199
    :cond_239
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v15, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "gw"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 200
    .local v14, sysGateways:Ljava/lang/String;
    if-eqz v14, :cond_273

    .line 201
    const-string v15, " "

    invoke-virtual {v14, v15}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/android/internal/telephony/DataCallState;->gateways:[Ljava/lang/String;

    .line 206
    .end local v14           #sysGateways:Ljava/lang/String;
    :cond_25c
    :goto_25c
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/internal/telephony/DataCallState;->gateways:[Ljava/lang/String;

    array-length v11, v4

    const/4 v8, 0x0

    :goto_262
    if-ge v8, v11, :cond_2ac

    aget-object v1, v4, v8

    .line 207
    .restart local v1       #addr:Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 208
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v15

    if-eqz v15, :cond_27b

    .line 206
    :cond_270
    :goto_270
    add-int/lit8 v8, v8, 0x1

    goto :goto_262

    .line 203
    .end local v1           #addr:Ljava/lang/String;
    .restart local v14       #sysGateways:Ljava/lang/String;
    :cond_273
    const/4 v15, 0x0

    new-array v15, v15, [Ljava/lang/String;

    move-object/from16 v0, p0

    iput-object v15, v0, Lcom/android/internal/telephony/DataCallState;->gateways:[Ljava/lang/String;
    :try_end_27a
    .catch Ljava/net/UnknownHostException; {:try_start_1fc .. :try_end_27a} :catch_c0

    goto :goto_25c

    .line 211
    .end local v14           #sysGateways:Ljava/lang/String;
    .restart local v1       #addr:Ljava/lang/String;
    :cond_27b
    :try_start_27b
    invoke-static {v1}, Landroid/net/NetworkUtils;->numericToInetAddress(Ljava/lang/String;)Ljava/net/InetAddress;
    :try_end_27e
    .catch Ljava/lang/IllegalArgumentException; {:try_start_27b .. :try_end_27e} :catch_290
    .catch Ljava/net/UnknownHostException; {:try_start_27b .. :try_end_27e} :catch_c0

    move-result-object v9

    .line 215
    .restart local v9       #ia:Ljava/net/InetAddress;
    :try_start_27f
    invoke-virtual {v9}, Ljava/net/InetAddress;->isAnyLocalAddress()Z

    move-result v15

    if-nez v15, :cond_270

    .line 216
    new-instance v15, Landroid/net/RouteInfo;

    invoke-direct {v15, v9}, Landroid/net/RouteInfo;-><init>(Ljava/net/InetAddress;)V

    move-object/from16 v0, p1

    invoke-virtual {v0, v15}, Landroid/net/LinkProperties;->addRoute(Landroid/net/RouteInfo;)V

    goto :goto_270

    .line 212
    .end local v9           #ia:Ljava/net/InetAddress;
    :catch_290
    move-exception v7

    .line 213
    .restart local v7       #e:Ljava/lang/IllegalArgumentException;
    new-instance v15, Ljava/net/UnknownHostException;

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "Non-numeric gateway addr="

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-direct/range {v15 .. v16}, Ljava/net/UnknownHostException;-><init>(Ljava/lang/String;)V

    throw v15

    .line 220
    .end local v1           #addr:Ljava/lang/String;
    .end local v7           #e:Ljava/lang/IllegalArgumentException;
    :cond_2ac
    sget-object v13, Lcom/android/internal/telephony/DataCallState$SetupResult;->SUCCESS:Lcom/android/internal/telephony/DataCallState$SetupResult;
    :try_end_2ae
    .catch Ljava/net/UnknownHostException; {:try_start_27f .. :try_end_2ae} :catch_c0

    .restart local v13       #result:Lcom/android/internal/telephony/DataCallState$SetupResult;
    goto/16 :goto_e1

    .line 227
    .end local v4           #arr$:[Ljava/lang/String;
    .end local v8           #i$:I
    .end local v11           #len$:I
    .end local v12           #propertyPrefix:Ljava/lang/String;
    .end local v13           #result:Lcom/android/internal/telephony/DataCallState$SetupResult;
    :cond_2b0
    move-object/from16 v0, p0

    iget v15, v0, Lcom/android/internal/telephony/DataCallState;->version:I

    const/16 v16, 0x4

    move/from16 v0, v16

    if-ge v15, v0, :cond_2be

    .line 228
    sget-object v13, Lcom/android/internal/telephony/DataCallState$SetupResult;->ERR_GetLastErrorFromRil:Lcom/android/internal/telephony/DataCallState$SetupResult;

    .restart local v13       #result:Lcom/android/internal/telephony/DataCallState$SetupResult;
    goto/16 :goto_e1

    .line 230
    .end local v13           #result:Lcom/android/internal/telephony/DataCallState$SetupResult;
    :cond_2be
    sget-object v13, Lcom/android/internal/telephony/DataCallState$SetupResult;->ERR_RilError:Lcom/android/internal/telephony/DataCallState$SetupResult;

    .restart local v13       #result:Lcom/android/internal/telephony/DataCallState$SetupResult;
    goto/16 :goto_e1
.end method

.method public toString()Ljava/lang/String;
    .registers 8

    .prologue
    .line 77
    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    .line 78
    .local v4, sb:Ljava/lang/StringBuffer;
    const-string v5, "DataCallState: {"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string/jumbo v6, "version="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    iget v6, p0, Lcom/android/internal/telephony/DataCallState;->version:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v6, " status="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    iget v6, p0, Lcom/android/internal/telephony/DataCallState;->status:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v6, " retry="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    iget v6, p0, Lcom/android/internal/telephony/DataCallState;->suggestedRetryTime:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v6, " cid="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    iget v6, p0, Lcom/android/internal/telephony/DataCallState;->cid:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v6, " active="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    iget v6, p0, Lcom/android/internal/telephony/DataCallState;->active:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v6, " type="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    iget-object v6, p0, Lcom/android/internal/telephony/DataCallState;->type:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v6, "\' ifname=\'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    iget-object v6, p0, Lcom/android/internal/telephony/DataCallState;->ifname:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 86
    const-string v5, "\' addresses=["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 87
    iget-object v1, p0, Lcom/android/internal/telephony/DataCallState;->addresses:[Ljava/lang/String;

    .local v1, arr$:[Ljava/lang/String;
    array-length v3, v1

    .local v3, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_68
    if-ge v2, v3, :cond_77

    aget-object v0, v1, v2

    .line 88
    .local v0, addr:Ljava/lang/String;
    invoke-virtual {v4, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 89
    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 87
    add-int/lit8 v2, v2, 0x1

    goto :goto_68

    .line 91
    .end local v0           #addr:Ljava/lang/String;
    :cond_77
    iget-object v5, p0, Lcom/android/internal/telephony/DataCallState;->addresses:[Ljava/lang/String;

    array-length v5, v5

    if-lez v5, :cond_85

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 92
    :cond_85
    const-string v5, "] dnses=["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 93
    iget-object v1, p0, Lcom/android/internal/telephony/DataCallState;->dnses:[Ljava/lang/String;

    array-length v3, v1

    const/4 v2, 0x0

    :goto_8e
    if-ge v2, v3, :cond_9d

    aget-object v0, v1, v2

    .line 94
    .restart local v0       #addr:Ljava/lang/String;
    invoke-virtual {v4, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 95
    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 93
    add-int/lit8 v2, v2, 0x1

    goto :goto_8e

    .line 97
    .end local v0           #addr:Ljava/lang/String;
    :cond_9d
    iget-object v5, p0, Lcom/android/internal/telephony/DataCallState;->dnses:[Ljava/lang/String;

    array-length v5, v5

    if-lez v5, :cond_ab

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 98
    :cond_ab
    const-string v5, "] gateways=["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 99
    iget-object v1, p0, Lcom/android/internal/telephony/DataCallState;->gateways:[Ljava/lang/String;

    array-length v3, v1

    const/4 v2, 0x0

    :goto_b4
    if-ge v2, v3, :cond_c3

    aget-object v0, v1, v2

    .line 100
    .restart local v0       #addr:Ljava/lang/String;
    invoke-virtual {v4, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 101
    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 99
    add-int/lit8 v2, v2, 0x1

    goto :goto_b4

    .line 103
    .end local v0           #addr:Ljava/lang/String;
    :cond_c3
    iget-object v5, p0, Lcom/android/internal/telephony/DataCallState;->gateways:[Ljava/lang/String;

    array-length v5, v5

    if-lez v5, :cond_d1

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 104
    :cond_d1
    const-string v5, "]}"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 105
    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    return-object v5
.end method
