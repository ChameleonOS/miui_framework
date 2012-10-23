.class public final Landroid/media/MediaCodec$CryptoInfo;
.super Ljava/lang/Object;
.source "MediaCodec.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/MediaCodec;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "CryptoInfo"
.end annotation


# instance fields
.field public iv:[B

.field public key:[B

.field public mode:I

.field public numBytesOfClearData:[I

.field public numBytesOfEncryptedData:[I

.field public numSubSamples:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 347
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public set(I[I[I[B[BI)V
    .registers 7
    .parameter "newNumSubSamples"
    .parameter "newNumBytesOfClearData"
    .parameter "newNumBytesOfEncryptedData"
    .parameter "newKey"
    .parameter "newIV"
    .parameter "newMode"

    .prologue
    .line 355
    iput p1, p0, Landroid/media/MediaCodec$CryptoInfo;->numSubSamples:I

    .line 356
    iput-object p2, p0, Landroid/media/MediaCodec$CryptoInfo;->numBytesOfClearData:[I

    .line 357
    iput-object p3, p0, Landroid/media/MediaCodec$CryptoInfo;->numBytesOfEncryptedData:[I

    .line 358
    iput-object p4, p0, Landroid/media/MediaCodec$CryptoInfo;->key:[B

    .line 359
    iput-object p5, p0, Landroid/media/MediaCodec$CryptoInfo;->iv:[B

    .line 360
    iput p6, p0, Landroid/media/MediaCodec$CryptoInfo;->mode:I

    .line 361
    return-void
.end method
