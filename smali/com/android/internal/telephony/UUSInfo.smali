.class public Lcom/android/internal/telephony/UUSInfo;
.super Ljava/lang/Object;
.source "UUSInfo.java"


# static fields
.field public static final UUS_DCS_IA5c:I = 0x4

.field public static final UUS_DCS_OSIHLP:I = 0x1

.field public static final UUS_DCS_RMCF:I = 0x3

.field public static final UUS_DCS_USP:I = 0x0

.field public static final UUS_DCS_X244:I = 0x2

.field public static final UUS_TYPE1_IMPLICIT:I = 0x0

.field public static final UUS_TYPE1_NOT_REQUIRED:I = 0x2

.field public static final UUS_TYPE1_REQUIRED:I = 0x1

.field public static final UUS_TYPE2_NOT_REQUIRED:I = 0x4

.field public static final UUS_TYPE2_REQUIRED:I = 0x3

.field public static final UUS_TYPE3_NOT_REQUIRED:I = 0x6

.field public static final UUS_TYPE3_REQUIRED:I = 0x5


# instance fields
.field private uusData:[B

.field private uusDcs:I

.field private uusType:I


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcom/android/internal/telephony/UUSInfo;->uusType:I

    const/4 v0, 0x4

    iput v0, p0, Lcom/android/internal/telephony/UUSInfo;->uusDcs:I

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/internal/telephony/UUSInfo;->uusData:[B

    return-void
.end method

.method public constructor <init>(II[B)V
    .registers 4
    .parameter "uusType"
    .parameter "uusDcs"
    .parameter "uusData"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/android/internal/telephony/UUSInfo;->uusType:I

    iput p2, p0, Lcom/android/internal/telephony/UUSInfo;->uusDcs:I

    iput-object p3, p0, Lcom/android/internal/telephony/UUSInfo;->uusData:[B

    return-void
.end method


# virtual methods
.method public getDcs()I
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/telephony/UUSInfo;->uusDcs:I

    return v0
.end method

.method public getType()I
    .registers 2

    .prologue
    iget v0, p0, Lcom/android/internal/telephony/UUSInfo;->uusType:I

    return v0
.end method

.method public getUserData()[B
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/telephony/UUSInfo;->uusData:[B

    return-object v0
.end method

.method public setDcs(I)V
    .registers 2
    .parameter "uusDcs"

    .prologue
    iput p1, p0, Lcom/android/internal/telephony/UUSInfo;->uusDcs:I

    return-void
.end method

.method public setType(I)V
    .registers 2
    .parameter "uusType"

    .prologue
    iput p1, p0, Lcom/android/internal/telephony/UUSInfo;->uusType:I

    return-void
.end method

.method public setUserData([B)V
    .registers 2
    .parameter "uusData"

    .prologue
    iput-object p1, p0, Lcom/android/internal/telephony/UUSInfo;->uusData:[B

    return-void
.end method
