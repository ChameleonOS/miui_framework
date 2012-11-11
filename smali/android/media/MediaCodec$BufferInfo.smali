.class public final Landroid/media/MediaCodec$BufferInfo;
.super Ljava/lang/Object;
.source "MediaCodec.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/MediaCodec;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "BufferInfo"
.end annotation


# instance fields
.field public flags:I

.field public offset:I

.field public presentationTimeUs:J

.field public size:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public set(IIJI)V
    .registers 6
    .parameter "newOffset"
    .parameter "newSize"
    .parameter "newTimeUs"
    .parameter "newFlags"

    .prologue
    iput p1, p0, Landroid/media/MediaCodec$BufferInfo;->offset:I

    iput p2, p0, Landroid/media/MediaCodec$BufferInfo;->size:I

    iput-wide p3, p0, Landroid/media/MediaCodec$BufferInfo;->presentationTimeUs:J

    iput p5, p0, Landroid/media/MediaCodec$BufferInfo;->flags:I

    return-void
.end method
