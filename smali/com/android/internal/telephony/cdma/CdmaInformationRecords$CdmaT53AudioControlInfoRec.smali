.class public Lcom/android/internal/telephony/cdma/CdmaInformationRecords$CdmaT53AudioControlInfoRec;
.super Ljava/lang/Object;
.source "CdmaInformationRecords.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/cdma/CdmaInformationRecords;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CdmaT53AudioControlInfoRec"
.end annotation


# instance fields
.field public downlink:B

.field public uplink:B


# direct methods
.method public constructor <init>(II)V
    .registers 4
    .parameter "uplink"
    .parameter "downlink"

    .prologue
    .line 250
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 251
    int-to-byte v0, p1

    iput-byte v0, p0, Lcom/android/internal/telephony/cdma/CdmaInformationRecords$CdmaT53AudioControlInfoRec;->uplink:B

    .line 252
    int-to-byte v0, p2

    iput-byte v0, p0, Lcom/android/internal/telephony/cdma/CdmaInformationRecords$CdmaT53AudioControlInfoRec;->downlink:B

    .line 253
    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 257
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "CdmaT53AudioControlInfoRec: { uplink: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-byte v1, p0, Lcom/android/internal/telephony/cdma/CdmaInformationRecords$CdmaT53AudioControlInfoRec;->uplink:B

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " downlink: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-byte v1, p0, Lcom/android/internal/telephony/cdma/CdmaInformationRecords$CdmaT53AudioControlInfoRec;->downlink:B

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
