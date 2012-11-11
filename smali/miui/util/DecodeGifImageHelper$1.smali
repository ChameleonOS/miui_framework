.class Lmiui/util/DecodeGifImageHelper$1;
.super Landroid/os/Handler;
.source "DecodeGifImageHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmiui/util/DecodeGifImageHelper;->firstDecodeNextFrames()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lmiui/util/DecodeGifImageHelper;


# direct methods
.method constructor <init>(Lmiui/util/DecodeGifImageHelper;Landroid/os/Looper;)V
    .registers 3
    .parameter
    .parameter "x0"

    .prologue
    iput-object p1, p0, Lmiui/util/DecodeGifImageHelper$1;->this$0:Lmiui/util/DecodeGifImageHelper;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 4
    .parameter "msg"

    .prologue
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_1e

    :cond_5
    :goto_5
    return-void

    :pswitch_6
    iget-object v0, p0, Lmiui/util/DecodeGifImageHelper$1;->this$0:Lmiui/util/DecodeGifImageHelper;

    iget-object v1, p0, Lmiui/util/DecodeGifImageHelper$1;->this$0:Lmiui/util/DecodeGifImageHelper;

    #getter for: Lmiui/util/DecodeGifImageHelper;->mDecodeGifFrames:Lmiui/util/DecodeGifFrames;
    invoke-static {v1}, Lmiui/util/DecodeGifImageHelper;->access$000(Lmiui/util/DecodeGifImageHelper;)Lmiui/util/DecodeGifFrames;

    move-result-object v1

    invoke-virtual {v1}, Lmiui/util/DecodeGifFrames;->getAndClearDecodeResult()Lmiui/util/DecodeGifImageHelper$GifDecodeResult;

    move-result-object v1

    invoke-virtual {v0, v1}, Lmiui/util/DecodeGifImageHelper;->handleDecodeFramesResult(Lmiui/util/DecodeGifImageHelper$GifDecodeResult;)Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lmiui/util/DecodeGifImageHelper$1;->this$0:Lmiui/util/DecodeGifImageHelper;

    invoke-virtual {v0}, Lmiui/util/DecodeGifImageHelper;->decodeNextFrames()V

    goto :goto_5

    :pswitch_data_1e
    .packed-switch 0x1
        :pswitch_6
    .end packed-switch
.end method
