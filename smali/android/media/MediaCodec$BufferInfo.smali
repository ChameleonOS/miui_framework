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
    .line 124
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
    .line 127
    iput p1, p0, Landroid/media/MediaCodec$BufferInfo;->offset:I

    .line 128
    iput p2, p0, Landroid/media/MediaCodec$BufferInfo;->size:I

    .line 129
    iput-wide p3, p0, Landroid/media/MediaCodec$BufferInfo;->presentationTimeUs:J

    .line 130
    iput p5, p0, Landroid/media/MediaCodec$BufferInfo;->flags:I

    .line 131
    return-void
.end method
