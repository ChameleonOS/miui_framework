.class public final Landroid/media/MediaCodecInfo;
.super Ljava/lang/Object;
.source "MediaCodecInfo.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/media/MediaCodecInfo$CodecProfileLevel;,
        Landroid/media/MediaCodecInfo$CodecCapabilities;
    }
.end annotation


# instance fields
.field private mIndex:I


# direct methods
.method constructor <init>(I)V
    .registers 2
    .parameter "index"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroid/media/MediaCodecInfo;->mIndex:I

    return-void
.end method


# virtual methods
.method public final getCapabilitiesForType(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;
    .registers 3
    .parameter "type"

    .prologue
    iget v0, p0, Landroid/media/MediaCodecInfo;->mIndex:I

    invoke-static {v0, p1}, Landroid/media/MediaCodecList;->getCodecCapabilities(ILjava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;

    move-result-object v0

    return-object v0
.end method

.method public final getName()Ljava/lang/String;
    .registers 2

    .prologue
    iget v0, p0, Landroid/media/MediaCodecInfo;->mIndex:I

    invoke-static {v0}, Landroid/media/MediaCodecList;->getCodecName(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getSupportedTypes()[Ljava/lang/String;
    .registers 2

    .prologue
    iget v0, p0, Landroid/media/MediaCodecInfo;->mIndex:I

    invoke-static {v0}, Landroid/media/MediaCodecList;->getSupportedTypes(I)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final isEncoder()Z
    .registers 2

    .prologue
    iget v0, p0, Landroid/media/MediaCodecInfo;->mIndex:I

    invoke-static {v0}, Landroid/media/MediaCodecList;->isEncoder(I)Z

    move-result v0

    return v0
.end method
