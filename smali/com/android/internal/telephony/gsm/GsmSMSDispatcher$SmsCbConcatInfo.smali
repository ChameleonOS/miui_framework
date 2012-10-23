.class final Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;
.super Ljava/lang/Object;
.source "GsmSMSDispatcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/gsm/GsmSMSDispatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "SmsCbConcatInfo"
.end annotation


# instance fields
.field private final mHeader:Lcom/android/internal/telephony/gsm/SmsCbHeader;

.field private final mLocation:Landroid/telephony/SmsCbLocation;


# direct methods
.method public constructor <init>(Lcom/android/internal/telephony/gsm/SmsCbHeader;Landroid/telephony/SmsCbLocation;)V
    .registers 3
    .parameter "header"
    .parameter "location"

    .prologue
    .line 329
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 330
    iput-object p1, p0, Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;->mHeader:Lcom/android/internal/telephony/gsm/SmsCbHeader;

    .line 331
    iput-object p2, p0, Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;->mLocation:Landroid/telephony/SmsCbLocation;

    .line 332
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6
    .parameter "obj"

    .prologue
    const/4 v1, 0x0

    .line 341
    instance-of v2, p1, Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;

    if-eqz v2, :cond_21

    move-object v0, p1

    .line 342
    check-cast v0, Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;

    .line 347
    .local v0, other:Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;
    iget-object v2, p0, Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;->mHeader:Lcom/android/internal/telephony/gsm/SmsCbHeader;

    invoke-virtual {v2}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getSerialNumber()I

    move-result v2

    iget-object v3, v0, Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;->mHeader:Lcom/android/internal/telephony/gsm/SmsCbHeader;

    invoke-virtual {v3}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getSerialNumber()I

    move-result v3

    if-ne v2, v3, :cond_21

    iget-object v2, p0, Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;->mLocation:Landroid/telephony/SmsCbLocation;

    iget-object v3, v0, Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;->mLocation:Landroid/telephony/SmsCbLocation;

    invoke-virtual {v2, v3}, Landroid/telephony/SmsCbLocation;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_21

    const/4 v1, 0x1

    .line 351
    .end local v0           #other:Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;
    :cond_21
    return v1
.end method

.method public hashCode()I
    .registers 3

    .prologue
    .line 336
    iget-object v0, p0, Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;->mHeader:Lcom/android/internal/telephony/gsm/SmsCbHeader;

    invoke-virtual {v0}, Lcom/android/internal/telephony/gsm/SmsCbHeader;->getSerialNumber()I

    move-result v0

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;->mLocation:Landroid/telephony/SmsCbLocation;

    invoke-virtual {v1}, Landroid/telephony/SmsCbLocation;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public matchesLocation(Ljava/lang/String;II)Z
    .registers 5
    .parameter "plmn"
    .parameter "lac"
    .parameter "cid"

    .prologue
    .line 365
    iget-object v0, p0, Lcom/android/internal/telephony/gsm/GsmSMSDispatcher$SmsCbConcatInfo;->mLocation:Landroid/telephony/SmsCbLocation;

    invoke-virtual {v0, p1, p2, p3}, Landroid/telephony/SmsCbLocation;->isInLocationArea(Ljava/lang/String;II)Z

    move-result v0

    return v0
.end method
