.class public Lmiui/util/DecodeGifImageHelper;
.super Ljava/lang/Object;
.source "DecodeGifImageHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/util/DecodeGifImageHelper$GifFrame;,
        Lmiui/util/DecodeGifImageHelper$GifDecodeResult;
    }
.end annotation


# static fields
.field public static final MESSAGE_WHAT_DECODE_FRAMES:I = 0x1


# instance fields
.field public mDecodeFrameHandler:Landroid/os/Handler;

.field private mDecodeGifFrames:Lmiui/util/DecodeGifFrames;

.field public mDecodedAllFrames:Z

.field public mFrames:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lmiui/util/DecodeGifImageHelper$GifFrame;",
            ">;"
        }
    .end annotation
.end field

.field public mGifSource:Lmiui/util/InputStreamLoader;

.field public mMaxDecodeSize:J

.field private mMaxFrames:I

.field public mRealFrameCount:I


# direct methods
.method public constructor <init>()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const-wide/32 v0, 0x100000

    iput-wide v0, p0, Lmiui/util/DecodeGifImageHelper;->mMaxDecodeSize:J

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lmiui/util/DecodeGifImageHelper;->mFrames:Ljava/util/List;

    iput v2, p0, Lmiui/util/DecodeGifImageHelper;->mMaxFrames:I

    iput v2, p0, Lmiui/util/DecodeGifImageHelper;->mRealFrameCount:I

    iput-boolean v2, p0, Lmiui/util/DecodeGifImageHelper;->mDecodedAllFrames:Z

    return-void
.end method

.method static synthetic access$000(Lmiui/util/DecodeGifImageHelper;)Lmiui/util/DecodeGifFrames;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lmiui/util/DecodeGifImageHelper;->mDecodeGifFrames:Lmiui/util/DecodeGifFrames;

    return-object v0
.end method

.method private calcFrameIndex(I)I
    .registers 3
    .parameter "frameIndex"

    .prologue
    iget v0, p0, Lmiui/util/DecodeGifImageHelper;->mRealFrameCount:I

    if-nez v0, :cond_5

    .end local p1
    :goto_4
    return p1

    .restart local p1
    :cond_5
    iget v0, p0, Lmiui/util/DecodeGifImageHelper;->mRealFrameCount:I

    rem-int/2addr p1, v0

    goto :goto_4
.end method

.method public static decode(Lmiui/util/InputStreamLoader;JI)Lmiui/util/DecodeGifImageHelper$GifDecodeResult;
    .registers 10
    .parameter "gifSource"
    .parameter "maxDecodeSize"
    .parameter "startFrame"

    .prologue
    const/4 v4, 0x0

    new-instance v0, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    invoke-direct {v0}, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;-><init>()V

    .local v0, decodeResult:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;
    const/4 v5, 0x0

    iput-object v5, v0, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mGifDecoder:Lmiui/util/GifDecoder;

    iput-boolean v4, v0, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mIsDecodeOk:Z

    invoke-virtual {p0}, Lmiui/util/InputStreamLoader;->get()Ljava/io/InputStream;

    move-result-object v2

    .local v2, inputStream:Ljava/io/InputStream;
    if-eqz v2, :cond_29

    new-instance v5, Lmiui/util/GifDecoder;

    invoke-direct {v5}, Lmiui/util/GifDecoder;-><init>()V

    iput-object v5, v0, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mGifDecoder:Lmiui/util/GifDecoder;

    iget-object v1, v0, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mGifDecoder:Lmiui/util/GifDecoder;

    .local v1, gifDecoder:Lmiui/util/GifDecoder;
    invoke-virtual {v1, p3}, Lmiui/util/GifDecoder;->setStartFrame(I)V

    invoke-virtual {v1, p1, p2}, Lmiui/util/GifDecoder;->setMaxDecodeSize(J)V

    invoke-virtual {v1, v2}, Lmiui/util/GifDecoder;->read(Ljava/io/InputStream;)I

    move-result v3

    .local v3, status:I
    if-nez v3, :cond_27

    const/4 v4, 0x1

    :cond_27
    iput-boolean v4, v0, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mIsDecodeOk:Z

    .end local v1           #gifDecoder:Lmiui/util/GifDecoder;
    .end local v3           #status:I
    :cond_29
    invoke-virtual {p0}, Lmiui/util/InputStreamLoader;->close()V

    return-object v0
.end method

.method private getLastFrameIndex()I
    .registers 4

    .prologue
    iget-object v1, p0, Lmiui/util/DecodeGifImageHelper;->mFrames:Ljava/util/List;

    iget-object v2, p0, Lmiui/util/DecodeGifImageHelper;->mFrames:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lmiui/util/DecodeGifImageHelper$GifFrame;

    .local v0, lastFrame:Lmiui/util/DecodeGifImageHelper$GifFrame;
    iget v1, v0, Lmiui/util/DecodeGifImageHelper$GifFrame;->mIndex:I

    return v1
.end method


# virtual methods
.method public decodeFrom(I)Lmiui/util/DecodeGifImageHelper$GifDecodeResult;
    .registers 5
    .parameter "startFrame"

    .prologue
    iget-object v0, p0, Lmiui/util/DecodeGifImageHelper;->mGifSource:Lmiui/util/InputStreamLoader;

    iget-wide v1, p0, Lmiui/util/DecodeGifImageHelper;->mMaxDecodeSize:J

    invoke-static {v0, v1, v2, p1}, Lmiui/util/DecodeGifImageHelper;->decode(Lmiui/util/InputStreamLoader;JI)Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    move-result-object v0

    return-object v0
.end method

.method public decodeNextFrames()V
    .registers 8

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    const/4 v1, 0x0

    .local v1, shouldDecode:Z
    iget-object v5, p0, Lmiui/util/DecodeGifImageHelper;->mFrames:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v0

    .local v0, remainingFrames:I
    iget v5, p0, Lmiui/util/DecodeGifImageHelper;->mMaxFrames:I

    const/4 v6, 0x3

    if-gt v5, v6, :cond_26

    const/4 v5, 0x2

    if-gt v0, v5, :cond_24

    move v1, v3

    :goto_12
    if-eqz v1, :cond_23

    invoke-direct {p0}, Lmiui/util/DecodeGifImageHelper;->getLastFrameIndex()I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-direct {p0, v3}, Lmiui/util/DecodeGifImageHelper;->calcFrameIndex(I)I

    move-result v2

    .local v2, startFrame:I
    iget-object v3, p0, Lmiui/util/DecodeGifImageHelper;->mDecodeGifFrames:Lmiui/util/DecodeGifFrames;

    invoke-virtual {v3, v2}, Lmiui/util/DecodeGifFrames;->decode(I)V

    .end local v2           #startFrame:I
    :cond_23
    return-void

    :cond_24
    move v1, v4

    goto :goto_12

    :cond_26
    iget v5, p0, Lmiui/util/DecodeGifImageHelper;->mMaxFrames:I

    div-int/lit8 v5, v5, 0x2

    if-gt v0, v5, :cond_2e

    move v1, v3

    :goto_2d
    goto :goto_12

    :cond_2e
    move v1, v4

    goto :goto_2d
.end method

.method public destroy()V
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/util/DecodeGifImageHelper;->mDecodeGifFrames:Lmiui/util/DecodeGifFrames;

    if-eqz v0, :cond_9

    iget-object v0, p0, Lmiui/util/DecodeGifImageHelper;->mDecodeGifFrames:Lmiui/util/DecodeGifFrames;

    invoke-virtual {v0}, Lmiui/util/DecodeGifFrames;->destroy()V

    :cond_9
    return-void
.end method

.method public firstDecodeNextFrames()V
    .registers 5

    .prologue
    new-instance v0, Lmiui/util/DecodeGifImageHelper$1;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lmiui/util/DecodeGifImageHelper$1;-><init>(Lmiui/util/DecodeGifImageHelper;Landroid/os/Looper;)V

    iput-object v0, p0, Lmiui/util/DecodeGifImageHelper;->mDecodeFrameHandler:Landroid/os/Handler;

    iget-object v0, p0, Lmiui/util/DecodeGifImageHelper;->mGifSource:Lmiui/util/InputStreamLoader;

    iget-wide v1, p0, Lmiui/util/DecodeGifImageHelper;->mMaxDecodeSize:J

    iget-object v3, p0, Lmiui/util/DecodeGifImageHelper;->mDecodeFrameHandler:Landroid/os/Handler;

    invoke-static {v0, v1, v2, v3}, Lmiui/util/DecodeGifFrames;->createInstance(Lmiui/util/InputStreamLoader;JLandroid/os/Handler;)Lmiui/util/DecodeGifFrames;

    move-result-object v0

    iput-object v0, p0, Lmiui/util/DecodeGifImageHelper;->mDecodeGifFrames:Lmiui/util/DecodeGifFrames;

    iget-object v0, p0, Lmiui/util/DecodeGifImageHelper;->mFrames:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iput v0, p0, Lmiui/util/DecodeGifImageHelper;->mMaxFrames:I

    invoke-virtual {p0}, Lmiui/util/DecodeGifImageHelper;->decodeNextFrames()V

    return-void
.end method

.method public handleDecodeFramesResult(Lmiui/util/DecodeGifImageHelper$GifDecodeResult;)Z
    .registers 16
    .parameter "decodeResult"

    .prologue
    const/4 v8, 0x1

    const/4 v9, 0x0

    iget-boolean v10, p1, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mIsDecodeOk:Z

    if-eqz v10, :cond_a

    iget-object v10, p1, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mGifDecoder:Lmiui/util/GifDecoder;

    if-nez v10, :cond_c

    :cond_a
    move v8, v9

    :cond_b
    return v8

    :cond_c
    iget-object v5, p1, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mGifDecoder:Lmiui/util/GifDecoder;

    .local v5, gifDecoder:Lmiui/util/GifDecoder;
    const-string v10, "Thread#%d: decoded %d frames [%s] [%d]"

    const/4 v11, 0x4

    new-array v11, v11, [Ljava/lang/Object;

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/Thread;->getId()J

    move-result-wide v12

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v12

    aput-object v12, v11, v9

    iget-object v9, p1, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mGifDecoder:Lmiui/util/GifDecoder;

    invoke-virtual {v9}, Lmiui/util/GifDecoder;->getFrameCount()I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v11, v8

    const/4 v9, 0x2

    iget-boolean v12, p1, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mIsDecodeOk:Z

    invoke-static {v12}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v12

    aput-object v12, v11, v9

    const/4 v9, 0x3

    iget v12, p0, Lmiui/util/DecodeGifImageHelper;->mRealFrameCount:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v11, v9

    invoke-static {v10, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .local v7, text:Ljava/lang/String;
    const-string v9, "dumpFrameIndex"

    invoke-static {v9, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {v5}, Lmiui/util/GifDecoder;->isDecodeToTheEnd()Z

    move-result v9

    if-eqz v9, :cond_54

    invoke-virtual {v5}, Lmiui/util/GifDecoder;->getRealFrameCount()I

    move-result v9

    iput v9, p0, Lmiui/util/DecodeGifImageHelper;->mRealFrameCount:I

    :cond_54
    invoke-virtual {v5}, Lmiui/util/GifDecoder;->getFrameCount()I

    move-result v1

    .local v1, count:I
    if-lez v1, :cond_b

    invoke-direct {p0}, Lmiui/util/DecodeGifImageHelper;->getLastFrameIndex()I

    move-result v2

    .local v2, currentLastFrameIndex:I
    const/4 v6, 0x0

    .local v6, i:I
    :goto_5f
    if-ge v6, v1, :cond_b

    invoke-virtual {v5, v6}, Lmiui/util/GifDecoder;->getFrame(I)Landroid/graphics/Bitmap;

    move-result-object v0

    .local v0, bitmap:Landroid/graphics/Bitmap;
    invoke-virtual {v5, v6}, Lmiui/util/GifDecoder;->getDelay(I)I

    move-result v3

    .local v3, duration:I
    add-int/lit8 v9, v2, 0x1

    add-int/2addr v9, v6

    invoke-direct {p0, v9}, Lmiui/util/DecodeGifImageHelper;->calcFrameIndex(I)I

    move-result v4

    .local v4, frameIndex:I
    iget-object v9, p0, Lmiui/util/DecodeGifImageHelper;->mFrames:Ljava/util/List;

    new-instance v10, Lmiui/util/DecodeGifImageHelper$GifFrame;

    invoke-direct {v10, v0, v3, v4}, Lmiui/util/DecodeGifImageHelper$GifFrame;-><init>(Landroid/graphics/Bitmap;II)V

    invoke-interface {v9, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v6, v6, 0x1

    goto :goto_5f
.end method
