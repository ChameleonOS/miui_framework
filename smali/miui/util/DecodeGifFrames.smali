.class Lmiui/util/DecodeGifFrames;
.super Landroid/os/Handler;
.source "DecodeGifImageHelper.java"


# static fields
.field private static final MESSAGE_WHAT_START:I = 0x1

.field protected static final TAG:Ljava/lang/String; = "DecodeGifFrames"


# instance fields
.field private mCallerHandler:Landroid/os/Handler;

.field mDecodeResult:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

.field private mGifSource:Lmiui/util/InputStreamLoader;

.field mHandlerThread:Landroid/os/HandlerThread;

.field private mMaxDecodeSize:J


# direct methods
.method public constructor <init>(Landroid/os/HandlerThread;Lmiui/util/InputStreamLoader;JLandroid/os/Handler;)V
    .registers 7
    .parameter "handlerThread"
    .parameter "gifSource"
    .parameter "maxDecodeSize"
    .parameter "callerHandler"

    .prologue
    invoke-virtual {p1}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lmiui/util/DecodeGifFrames;->mDecodeResult:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    iput-object p1, p0, Lmiui/util/DecodeGifFrames;->mHandlerThread:Landroid/os/HandlerThread;

    iput-wide p3, p0, Lmiui/util/DecodeGifFrames;->mMaxDecodeSize:J

    iput-object p2, p0, Lmiui/util/DecodeGifFrames;->mGifSource:Lmiui/util/InputStreamLoader;

    iput-object p5, p0, Lmiui/util/DecodeGifFrames;->mCallerHandler:Landroid/os/Handler;

    return-void
.end method

.method public static createInstance(Lmiui/util/InputStreamLoader;JLandroid/os/Handler;)Lmiui/util/DecodeGifFrames;
    .registers 10
    .parameter "gifSource"
    .parameter "maxDecodeSize"
    .parameter "callerHandler"

    .prologue
    new-instance v1, Landroid/os/HandlerThread;

    const-string v0, "handler thread to decode GIF frames"

    invoke-direct {v1, v0}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    .local v1, thread:Landroid/os/HandlerThread;
    invoke-virtual {v1}, Landroid/os/HandlerThread;->start()V

    new-instance v0, Lmiui/util/DecodeGifFrames;

    move-object v2, p0

    move-wide v3, p1

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lmiui/util/DecodeGifFrames;-><init>(Landroid/os/HandlerThread;Lmiui/util/InputStreamLoader;JLandroid/os/Handler;)V

    return-object v0
.end method


# virtual methods
.method public decode(I)V
    .registers 5
    .parameter "startFrame"

    .prologue
    iget-object v1, p0, Lmiui/util/DecodeGifFrames;->mDecodeResult:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    if-eqz v1, :cond_5

    :goto_4
    return-void

    :cond_5
    new-instance v1, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    invoke-direct {v1}, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;-><init>()V

    iput-object v1, p0, Lmiui/util/DecodeGifFrames;->mDecodeResult:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, p1, v2}, Lmiui/util/DecodeGifFrames;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    .local v0, msg:Landroid/os/Message;
    invoke-virtual {p0, v0}, Lmiui/util/DecodeGifFrames;->sendMessage(Landroid/os/Message;)Z

    goto :goto_4
.end method

.method public destroy()V
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/util/DecodeGifFrames;->mHandlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->quit()Z

    return-void
.end method

.method protected finalize()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    iget-object v0, p0, Lmiui/util/DecodeGifFrames;->mHandlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->quit()Z

    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    return-void
.end method

.method public getAndClearDecodeResult()Lmiui/util/DecodeGifImageHelper$GifDecodeResult;
    .registers 3

    .prologue
    iget-object v0, p0, Lmiui/util/DecodeGifFrames;->mDecodeResult:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    .local v0, result:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;
    const/4 v1, 0x0

    iput-object v1, p0, Lmiui/util/DecodeGifFrames;->mDecodeResult:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    return-object v0
.end method

.method public handleMessage(Landroid/os/Message;)V
    .registers 8
    .parameter "msg"

    .prologue
    const/4 v5, 0x1

    iget v2, p1, Landroid/os/Message;->what:I

    if-ne v2, v5, :cond_20

    iget v1, p1, Landroid/os/Message;->arg1:I

    .local v1, startFrame:I
    iget-object v2, p0, Lmiui/util/DecodeGifFrames;->mGifSource:Lmiui/util/InputStreamLoader;

    iget-wide v3, p0, Lmiui/util/DecodeGifFrames;->mMaxDecodeSize:J

    invoke-static {v2, v3, v4, v1}, Lmiui/util/DecodeGifImageHelper;->decode(Lmiui/util/InputStreamLoader;JI)Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    move-result-object v0

    .local v0, decodeResult:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;
    iget-object v2, p0, Lmiui/util/DecodeGifFrames;->mDecodeResult:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    iget-object v3, v0, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mGifDecoder:Lmiui/util/GifDecoder;

    iput-object v3, v2, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mGifDecoder:Lmiui/util/GifDecoder;

    iget-object v2, p0, Lmiui/util/DecodeGifFrames;->mDecodeResult:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    iget-boolean v3, v0, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mIsDecodeOk:Z

    iput-boolean v3, v2, Lmiui/util/DecodeGifImageHelper$GifDecodeResult;->mIsDecodeOk:Z

    iget-object v2, p0, Lmiui/util/DecodeGifFrames;->mCallerHandler:Landroid/os/Handler;

    invoke-virtual {v2, v5}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .end local v0           #decodeResult:Lmiui/util/DecodeGifImageHelper$GifDecodeResult;
    .end local v1           #startFrame:I
    :cond_20
    return-void
.end method
