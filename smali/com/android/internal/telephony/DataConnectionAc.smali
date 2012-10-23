.class public Lcom/android/internal/telephony/DataConnectionAc;
.super Lcom/android/internal/util/AsyncChannel;
.source "DataConnectionAc.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/telephony/DataConnectionAc$LinkPropertyChangeAction;
    }
.end annotation


# static fields
.field public static final BASE:I = 0x41000

.field private static final CMD_TO_STRING_COUNT:I = 0x1c

.field private static final DBG:Z = false

.field public static final REQ_ADD_APNCONTEXT:I = 0x41012

.field public static final REQ_GET_APNCONTEXT_LIST:I = 0x41016

.field public static final REQ_GET_APNSETTING:I = 0x41004

.field public static final REQ_GET_CID:I = 0x41002

.field public static final REQ_GET_LINK_CAPABILITIES:I = 0x4100a

.field public static final REQ_GET_LINK_PROPERTIES:I = 0x41006

.field public static final REQ_GET_RECONNECT_INTENT:I = 0x4101a

.field public static final REQ_GET_REFCOUNT:I = 0x41010

.field public static final REQ_IS_INACTIVE:I = 0x41000

.field public static final REQ_REMOVE_APNCONTEXT:I = 0x41014

.field public static final REQ_RESET:I = 0x4100e

.field public static final REQ_SET_LINK_PROPERTIES_HTTP_PROXY:I = 0x41008

.field public static final REQ_SET_RECONNECT_INTENT:I = 0x41018

.field public static final REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE:I = 0x4100c

.field public static final RSP_ADD_APNCONTEXT:I = 0x41013

.field public static final RSP_GET_APNCONTEXT_LIST:I = 0x41017

.field public static final RSP_GET_APNSETTING:I = 0x41005

.field public static final RSP_GET_CID:I = 0x41003

.field public static final RSP_GET_LINK_CAPABILITIES:I = 0x4100b

.field public static final RSP_GET_LINK_PROPERTIES:I = 0x41007

.field public static final RSP_GET_RECONNECT_INTENT:I = 0x4101b

.field public static final RSP_GET_REFCOUNT:I = 0x41011

.field public static final RSP_IS_INACTIVE:I = 0x41001

.field public static final RSP_REMOVE_APNCONTEXT:I = 0x41015

.field public static final RSP_RESET:I = 0x4100f

.field public static final RSP_SET_LINK_PROPERTIES_HTTP_PROXY:I = 0x41009

.field public static final RSP_SET_RECONNECT_INTENT:I = 0x41019

.field public static final RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE:I = 0x4100d

.field private static sCmdToString:[Ljava/lang/String;


# instance fields
.field public dataConnection:Lcom/android/internal/telephony/DataConnection;

.field private mLogTag:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 86
    const/16 v0, 0x1c

    new-array v0, v0, [Ljava/lang/String;

    sput-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    .line 88
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "REQ_IS_INACTIVE"

    aput-object v2, v0, v1

    .line 89
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/4 v1, 0x1

    const-string v2, "RSP_IS_INACTIVE"

    aput-object v2, v0, v1

    .line 90
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/4 v1, 0x2

    const-string v2, "REQ_GET_CID"

    aput-object v2, v0, v1

    .line 91
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/4 v1, 0x3

    const-string v2, "RSP_GET_CID"

    aput-object v2, v0, v1

    .line 92
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/4 v1, 0x4

    const-string v2, "REQ_GET_APNSETTING"

    aput-object v2, v0, v1

    .line 93
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/4 v1, 0x5

    const-string v2, "RSP_GET_APNSETTING"

    aput-object v2, v0, v1

    .line 94
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/4 v1, 0x6

    const-string v2, "REQ_GET_LINK_PROPERTIES"

    aput-object v2, v0, v1

    .line 95
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/4 v1, 0x7

    const-string v2, "RSP_GET_LINK_PROPERTIES"

    aput-object v2, v0, v1

    .line 96
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x8

    const-string v2, "REQ_SET_LINK_PROPERTIES_HTTP_PROXY"

    aput-object v2, v0, v1

    .line 98
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x9

    const-string v2, "RSP_SET_LINK_PROPERTIES_HTTP_PROXY"

    aput-object v2, v0, v1

    .line 100
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0xa

    const-string v2, "REQ_GET_LINK_CAPABILITIES"

    aput-object v2, v0, v1

    .line 101
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0xb

    const-string v2, "RSP_GET_LINK_CAPABILITIES"

    aput-object v2, v0, v1

    .line 102
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0xc

    const-string v2, "REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE"

    aput-object v2, v0, v1

    .line 104
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0xd

    const-string v2, "RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE"

    aput-object v2, v0, v1

    .line 106
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0xe

    const-string v2, "REQ_RESET"

    aput-object v2, v0, v1

    .line 107
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0xf

    const-string v2, "RSP_RESET"

    aput-object v2, v0, v1

    .line 108
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x10

    const-string v2, "REQ_GET_REFCOUNT"

    aput-object v2, v0, v1

    .line 109
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x11

    const-string v2, "RSP_GET_REFCOUNT"

    aput-object v2, v0, v1

    .line 110
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x12

    const-string v2, "REQ_ADD_APNCONTEXT"

    aput-object v2, v0, v1

    .line 111
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x13

    const-string v2, "RSP_ADD_APNCONTEXT"

    aput-object v2, v0, v1

    .line 112
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x14

    const-string v2, "REQ_REMOVE_APNCONTEXT"

    aput-object v2, v0, v1

    .line 113
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x15

    const-string v2, "RSP_REMOVE_APNCONTEXT"

    aput-object v2, v0, v1

    .line 114
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x16

    const-string v2, "REQ_GET_APNCONTEXT_LIST"

    aput-object v2, v0, v1

    .line 115
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x17

    const-string v2, "RSP_GET_APNCONTEXT_LIST"

    aput-object v2, v0, v1

    .line 116
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x18

    const-string v2, "REQ_SET_RECONNECT_INTENT"

    aput-object v2, v0, v1

    .line 117
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x19

    const-string v2, "RSP_SET_RECONNECT_INTENT"

    aput-object v2, v0, v1

    .line 118
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x1a

    const-string v2, "REQ_GET_RECONNECT_INTENT"

    aput-object v2, v0, v1

    .line 119
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    const/16 v1, 0x1b

    const-string v2, "RSP_GET_RECONNECT_INTENT"

    aput-object v2, v0, v1

    .line 120
    return-void
.end method

.method public constructor <init>(Lcom/android/internal/telephony/DataConnection;Ljava/lang/String;)V
    .registers 3
    .parameter "dc"
    .parameter "logTag"

    .prologue
    .line 150
    invoke-direct {p0}, Lcom/android/internal/util/AsyncChannel;-><init>()V

    .line 151
    iput-object p1, p0, Lcom/android/internal/telephony/DataConnectionAc;->dataConnection:Lcom/android/internal/telephony/DataConnection;

    .line 152
    iput-object p2, p0, Lcom/android/internal/telephony/DataConnectionAc;->mLogTag:Ljava/lang/String;

    .line 153
    return-void
.end method

.method protected static cmdToString(I)Ljava/lang/String;
    .registers 3
    .parameter "cmd"

    .prologue
    const v1, 0x41000

    .line 122
    sub-int/2addr p0, v1

    .line 123
    if-ltz p0, :cond_10

    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    array-length v0, v0

    if-ge p0, v0, :cond_10

    .line 124
    sget-object v0, Lcom/android/internal/telephony/DataConnectionAc;->sCmdToString:[Ljava/lang/String;

    aget-object v0, v0, p0

    .line 126
    :goto_f
    return-object v0

    :cond_10
    add-int v0, p0, v1

    invoke-static {v0}, Lcom/android/internal/util/AsyncChannel;->cmdToString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_f
.end method

.method private log(Ljava/lang/String;)V
    .registers 5
    .parameter "s"

    .prologue
    .line 589
    iget-object v0, p0, Lcom/android/internal/telephony/DataConnectionAc;->mLogTag:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "DataConnectionAc "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 590
    return-void
.end method


# virtual methods
.method public addApnContextSync(Lcom/android/internal/telephony/ApnContext;)V
    .registers 5
    .parameter "apnContext"

    .prologue
    .line 454
    const v1, 0x41012

    invoke-virtual {p0, v1, p1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 455
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_11

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x41013

    if-ne v1, v2, :cond_11

    .line 460
    :goto_10
    return-void

    .line 458
    :cond_11
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "addApnContext error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    goto :goto_10
.end method

.method public getApnListSync()Ljava/util/Collection;
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/internal/telephony/ApnContext;",
            ">;"
        }
    .end annotation

    .prologue
    .line 513
    const v1, 0x41016

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(I)Landroid/os/Message;

    move-result-object v0

    .line 514
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_15

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x41017

    if-ne v1, v2, :cond_15

    .line 516
    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->rspApnList(Landroid/os/Message;)Ljava/util/Collection;

    move-result-object v1

    .line 520
    :goto_14
    return-object v1

    .line 518
    :cond_15
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "getApnList error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    .line 520
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    goto :goto_14
.end method

.method public getApnSettingSync()Lcom/android/internal/telephony/ApnSetting;
    .registers 4

    .prologue
    .line 283
    const v1, 0x41004

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(I)Landroid/os/Message;

    move-result-object v0

    .line 284
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_15

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x41005

    if-ne v1, v2, :cond_15

    .line 285
    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->rspApnSetting(Landroid/os/Message;)Lcom/android/internal/telephony/ApnSetting;

    move-result-object v1

    .line 288
    :goto_14
    return-object v1

    .line 287
    :cond_15
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "getApnSetting error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    .line 288
    const/4 v1, 0x0

    goto :goto_14
.end method

.method public getCidSync()I
    .registers 4

    .prologue
    .line 213
    const v1, 0x41002

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(I)Landroid/os/Message;

    move-result-object v0

    .line 214
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_15

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x41003

    if-ne v1, v2, :cond_15

    .line 215
    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->rspCid(Landroid/os/Message;)I

    move-result v1

    .line 218
    :goto_14
    return v1

    .line 217
    :cond_15
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "rspCid error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    .line 218
    const/4 v1, -0x1

    goto :goto_14
.end method

.method public getLinkCapabilitiesSync()Landroid/net/LinkCapabilities;
    .registers 4

    .prologue
    .line 409
    const v1, 0x4100a

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(I)Landroid/os/Message;

    move-result-object v0

    .line 410
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_15

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x4100b

    if-ne v1, v2, :cond_15

    .line 411
    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->rspLinkCapabilities(Landroid/os/Message;)Landroid/net/LinkCapabilities;

    move-result-object v1

    .line 414
    :goto_14
    return-object v1

    .line 413
    :cond_15
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "getLinkCapabilities error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    .line 414
    const/4 v1, 0x0

    goto :goto_14
.end method

.method public getLinkPropertiesSync()Landroid/net/LinkProperties;
    .registers 4

    .prologue
    .line 319
    const v1, 0x41006

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(I)Landroid/os/Message;

    move-result-object v0

    .line 320
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_15

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x41007

    if-ne v1, v2, :cond_15

    .line 321
    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->rspLinkProperties(Landroid/os/Message;)Landroid/net/LinkProperties;

    move-result-object v1

    .line 324
    :goto_14
    return-object v1

    .line 323
    :cond_15
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "getLinkProperties error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    .line 324
    const/4 v1, 0x0

    goto :goto_14
.end method

.method public getReconnectIntentSync()Landroid/app/PendingIntent;
    .registers 4

    .prologue
    .line 573
    const v1, 0x4101a

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(I)Landroid/os/Message;

    move-result-object v0

    .line 574
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_15

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x4101b

    if-ne v1, v2, :cond_15

    .line 576
    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->rspReconnectIntent(Landroid/os/Message;)Landroid/app/PendingIntent;

    move-result-object v1

    .line 579
    :goto_14
    return-object v1

    .line 578
    :cond_15
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "getReconnectIntent error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    .line 579
    const/4 v1, 0x0

    goto :goto_14
.end method

.method public getRefCountSync()I
    .registers 4

    .prologue
    .line 247
    const v1, 0x41010

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(I)Landroid/os/Message;

    move-result-object v0

    .line 248
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_15

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x41011

    if-ne v1, v2, :cond_15

    .line 249
    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->rspRefCount(Landroid/os/Message;)I

    move-result v1

    .line 252
    :goto_14
    return v1

    .line 251
    :cond_15
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "rspRefCount error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    .line 252
    const/4 v1, -0x1

    goto :goto_14
.end method

.method public isInactiveSync()Z
    .registers 4

    .prologue
    .line 179
    const v1, 0x41000

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(I)Landroid/os/Message;

    move-result-object v0

    .line 180
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_15

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x41001

    if-ne v1, v2, :cond_15

    .line 181
    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->rspIsInactive(Landroid/os/Message;)Z

    move-result v1

    .line 184
    :goto_14
    return v1

    .line 183
    :cond_15
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "rspIsInactive error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    .line 184
    const/4 v1, 0x0

    goto :goto_14
.end method

.method public removeApnContextSync(Lcom/android/internal/telephony/ApnContext;)V
    .registers 5
    .parameter "apnContext"

    .prologue
    .line 477
    const v1, 0x41014

    invoke-virtual {p0, v1, p1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 478
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_11

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x41015

    if-ne v1, v2, :cond_11

    .line 483
    :goto_10
    return-void

    .line 481
    :cond_11
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "removeApnContext error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    goto :goto_10
.end method

.method public reqAddApnContext(Lcom/android/internal/telephony/ApnContext;)V
    .registers 4
    .parameter "apnContext"

    .prologue
    .line 444
    const v1, 0x41012

    invoke-virtual {p0, v1, p1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 446
    .local v0, response:Landroid/os/Message;
    return-void
.end method

.method public reqApnSetting()V
    .registers 2

    .prologue
    .line 261
    const v0, 0x41004

    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessage(I)V

    .line 263
    return-void
.end method

.method public reqCid()V
    .registers 2

    .prologue
    .line 193
    const v0, 0x41002

    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessage(I)V

    .line 195
    return-void
.end method

.method public reqGetApnList(Lcom/android/internal/telephony/ApnContext;)V
    .registers 4
    .parameter "apnContext"

    .prologue
    .line 490
    const v1, 0x41016

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(I)Landroid/os/Message;

    move-result-object v0

    .line 492
    .local v0, response:Landroid/os/Message;
    return-void
.end method

.method public reqGetReconnectIntent()V
    .registers 3

    .prologue
    .line 552
    const v1, 0x4101a

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(I)Landroid/os/Message;

    move-result-object v0

    .line 554
    .local v0, response:Landroid/os/Message;
    return-void
.end method

.method public reqIsInactive()V
    .registers 2

    .prologue
    .line 160
    const v0, 0x41000

    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessage(I)V

    .line 162
    return-void
.end method

.method public reqLinkCapabilities()V
    .registers 2

    .prologue
    .line 387
    const v0, 0x4100a

    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessage(I)V

    .line 389
    return-void
.end method

.method public reqLinkProperties()V
    .registers 2

    .prologue
    .line 297
    const v0, 0x41006

    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessage(I)V

    .line 299
    return-void
.end method

.method public reqRefCount()V
    .registers 2

    .prologue
    .line 227
    const v0, 0x41010

    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessage(I)V

    .line 229
    return-void
.end method

.method public reqRemomveApnContext(Lcom/android/internal/telephony/ApnContext;)V
    .registers 4
    .parameter "apnContext"

    .prologue
    .line 467
    const v1, 0x41014

    invoke-virtual {p0, v1, p1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 469
    .local v0, response:Landroid/os/Message;
    return-void
.end method

.method public reqReset()V
    .registers 2

    .prologue
    .line 423
    const v0, 0x4100e

    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessage(I)V

    .line 425
    return-void
.end method

.method public reqSetLinkPropertiesHttpProxy(Landroid/net/ProxyProperties;)V
    .registers 3
    .parameter "proxy"

    .prologue
    .line 333
    const v0, 0x41008

    invoke-virtual {p0, v0, p1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessage(ILjava/lang/Object;)V

    .line 335
    return-void
.end method

.method public reqSetReconnectIntent(Landroid/app/PendingIntent;)V
    .registers 4
    .parameter "intent"

    .prologue
    .line 529
    const v1, 0x41018

    invoke-virtual {p0, v1, p1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 531
    .local v0, response:Landroid/os/Message;
    return-void
.end method

.method public reqUpdateLinkPropertiesDataCallState(Lcom/android/internal/telephony/DataCallState;)V
    .registers 3
    .parameter "newState"

    .prologue
    .line 355
    const v0, 0x4100c

    invoke-virtual {p0, v0, p1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessage(ILjava/lang/Object;)V

    .line 357
    return-void
.end method

.method public resetSync()V
    .registers 4

    .prologue
    .line 431
    const v1, 0x4100e

    invoke-virtual {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(I)Landroid/os/Message;

    move-result-object v0

    .line 432
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_11

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x4100f

    if-ne v1, v2, :cond_11

    .line 437
    :goto_10
    return-void

    .line 435
    :cond_11
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "restSync error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    goto :goto_10
.end method

.method public rspApnList(Landroid/os/Message;)Ljava/util/Collection;
    .registers 3
    .parameter "response"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Message;",
            ")",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/internal/telephony/ApnContext;",
            ">;"
        }
    .end annotation

    .prologue
    .line 501
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/util/Collection;

    .line 502
    .local v0, retVal:Ljava/util/Collection;,"Ljava/util/Collection<Lcom/android/internal/telephony/ApnContext;>;"
    if-nez v0, :cond_b

    new-instance v0, Ljava/util/ArrayList;

    .end local v0           #retVal:Ljava/util/Collection;,"Ljava/util/Collection<Lcom/android/internal/telephony/ApnContext;>;"
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 503
    .restart local v0       #retVal:Ljava/util/Collection;,"Ljava/util/Collection<Lcom/android/internal/telephony/ApnContext;>;"
    :cond_b
    return-object v0
.end method

.method public rspApnSetting(Landroid/os/Message;)Lcom/android/internal/telephony/ApnSetting;
    .registers 3
    .parameter "response"

    .prologue
    .line 272
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/android/internal/telephony/ApnSetting;

    .line 274
    .local v0, retVal:Lcom/android/internal/telephony/ApnSetting;
    return-object v0
.end method

.method public rspCid(Landroid/os/Message;)I
    .registers 3
    .parameter "response"

    .prologue
    .line 204
    iget v0, p1, Landroid/os/Message;->arg1:I

    .line 206
    .local v0, retVal:I
    return v0
.end method

.method public rspIsInactive(Landroid/os/Message;)Z
    .registers 4
    .parameter "response"

    .prologue
    const/4 v0, 0x1

    .line 170
    iget v1, p1, Landroid/os/Message;->arg1:I

    if-ne v1, v0, :cond_6

    .line 172
    .local v0, retVal:Z
    :goto_5
    return v0

    .line 170
    .end local v0           #retVal:Z
    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public rspLinkCapabilities(Landroid/os/Message;)Landroid/net/LinkCapabilities;
    .registers 3
    .parameter "response"

    .prologue
    .line 398
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/net/LinkCapabilities;

    .line 400
    .local v0, retVal:Landroid/net/LinkCapabilities;
    return-object v0
.end method

.method public rspLinkProperties(Landroid/os/Message;)Landroid/net/LinkProperties;
    .registers 3
    .parameter "response"

    .prologue
    .line 308
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/net/LinkProperties;

    .line 310
    .local v0, retVal:Landroid/net/LinkProperties;
    return-object v0
.end method

.method public rspReconnectIntent(Landroid/os/Message;)Landroid/app/PendingIntent;
    .registers 3
    .parameter "response"

    .prologue
    .line 563
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/app/PendingIntent;

    .line 564
    .local v0, retVal:Landroid/app/PendingIntent;
    return-object v0
.end method

.method public rspRefCount(Landroid/os/Message;)I
    .registers 3
    .parameter "response"

    .prologue
    .line 238
    iget v0, p1, Landroid/os/Message;->arg1:I

    .line 240
    .local v0, retVal:I
    return v0
.end method

.method public rspUpdateLinkPropertiesDataCallState(Landroid/os/Message;)Lcom/android/internal/telephony/DataConnection$UpdateLinkPropertyResult;
    .registers 3
    .parameter "response"

    .prologue
    .line 360
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/android/internal/telephony/DataConnection$UpdateLinkPropertyResult;

    .line 362
    .local v0, retVal:Lcom/android/internal/telephony/DataConnection$UpdateLinkPropertyResult;
    return-object v0
.end method

.method public setLinkPropertiesHttpProxySync(Landroid/net/ProxyProperties;)V
    .registers 5
    .parameter "proxy"

    .prologue
    .line 341
    const v1, 0x41008

    invoke-virtual {p0, v1, p1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 343
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_11

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x41009

    if-ne v1, v2, :cond_11

    .line 348
    :goto_10
    return-void

    .line 346
    :cond_11
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "setLinkPropertiesHttpPoxy error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    goto :goto_10
.end method

.method public setReconnectIntentSync(Landroid/app/PendingIntent;)V
    .registers 5
    .parameter "intent"

    .prologue
    .line 539
    const v1, 0x41018

    invoke-virtual {p0, v1, p1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 540
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_11

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x41019

    if-ne v1, v2, :cond_11

    .line 545
    :goto_10
    return-void

    .line 543
    :cond_11
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "setReconnectIntent error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    goto :goto_10
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    .prologue
    .line 585
    iget-object v0, p0, Lcom/android/internal/telephony/DataConnectionAc;->dataConnection:Lcom/android/internal/telephony/DataConnection;

    invoke-virtual {v0}, Lcom/android/internal/telephony/DataConnection;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public updateLinkPropertiesDataCallStateSync(Lcom/android/internal/telephony/DataCallState;)Lcom/android/internal/telephony/DataConnection$UpdateLinkPropertyResult;
    .registers 5
    .parameter "newState"

    .prologue
    .line 371
    const v1, 0x4100c

    invoke-virtual {p0, v1, p1}, Lcom/android/internal/telephony/DataConnectionAc;->sendMessageSynchronously(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 373
    .local v0, response:Landroid/os/Message;
    if-eqz v0, :cond_15

    iget v1, v0, Landroid/os/Message;->what:I

    const v2, 0x4100d

    if-ne v1, v2, :cond_15

    .line 375
    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/DataConnectionAc;->rspUpdateLinkPropertiesDataCallState(Landroid/os/Message;)Lcom/android/internal/telephony/DataConnection$UpdateLinkPropertyResult;

    move-result-object v1

    .line 378
    :goto_14
    return-object v1

    .line 377
    :cond_15
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "getLinkProperties error response="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/android/internal/telephony/DataConnectionAc;->log(Ljava/lang/String;)V

    .line 378
    new-instance v1, Lcom/android/internal/telephony/DataConnection$UpdateLinkPropertyResult;

    new-instance v2, Landroid/net/LinkProperties;

    invoke-direct {v2}, Landroid/net/LinkProperties;-><init>()V

    invoke-direct {v1, v2}, Lcom/android/internal/telephony/DataConnection$UpdateLinkPropertyResult;-><init>(Landroid/net/LinkProperties;)V

    goto :goto_14
.end method
