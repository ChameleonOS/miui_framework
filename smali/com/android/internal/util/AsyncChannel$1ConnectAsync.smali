.class final Lcom/android/internal/util/AsyncChannel$1ConnectAsync;
.super Ljava/lang/Object;
.source "AsyncChannel.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/internal/util/AsyncChannel;->connect(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "ConnectAsync"
.end annotation


# instance fields
.field mDstClassName:Ljava/lang/String;

.field mDstPackageName:Ljava/lang/String;

.field mSrcCtx:Landroid/content/Context;

.field mSrcHdlr:Landroid/os/Handler;

.field final synthetic this$0:Lcom/android/internal/util/AsyncChannel;


# direct methods
.method constructor <init>(Lcom/android/internal/util/AsyncChannel;Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;)V
    .registers 6
    .parameter
    .parameter "srcContext"
    .parameter "srcHandler"
    .parameter "dstPackageName"
    .parameter "dstClassName"

    .prologue
    .line 320
    iput-object p1, p0, Lcom/android/internal/util/AsyncChannel$1ConnectAsync;->this$0:Lcom/android/internal/util/AsyncChannel;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 321
    iput-object p2, p0, Lcom/android/internal/util/AsyncChannel$1ConnectAsync;->mSrcCtx:Landroid/content/Context;

    .line 322
    iput-object p3, p0, Lcom/android/internal/util/AsyncChannel$1ConnectAsync;->mSrcHdlr:Landroid/os/Handler;

    .line 323
    iput-object p4, p0, Lcom/android/internal/util/AsyncChannel$1ConnectAsync;->mDstPackageName:Ljava/lang/String;

    .line 324
    iput-object p5, p0, Lcom/android/internal/util/AsyncChannel$1ConnectAsync;->mDstClassName:Ljava/lang/String;

    .line 325
    return-void
.end method


# virtual methods
.method public run()V
    .registers 7

    .prologue
    .line 329
    iget-object v1, p0, Lcom/android/internal/util/AsyncChannel$1ConnectAsync;->this$0:Lcom/android/internal/util/AsyncChannel;

    iget-object v2, p0, Lcom/android/internal/util/AsyncChannel$1ConnectAsync;->mSrcCtx:Landroid/content/Context;

    iget-object v3, p0, Lcom/android/internal/util/AsyncChannel$1ConnectAsync;->mSrcHdlr:Landroid/os/Handler;

    iget-object v4, p0, Lcom/android/internal/util/AsyncChannel$1ConnectAsync;->mDstPackageName:Ljava/lang/String;

    iget-object v5, p0, Lcom/android/internal/util/AsyncChannel$1ConnectAsync;->mDstClassName:Ljava/lang/String;

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/android/internal/util/AsyncChannel;->connectSrcHandlerToPackageSync(Landroid/content/Context;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 331
    .local v0, result:I
    iget-object v1, p0, Lcom/android/internal/util/AsyncChannel$1ConnectAsync;->this$0:Lcom/android/internal/util/AsyncChannel;

    #calls: Lcom/android/internal/util/AsyncChannel;->replyHalfConnected(I)V
    invoke-static {v1, v0}, Lcom/android/internal/util/AsyncChannel;->access$000(Lcom/android/internal/util/AsyncChannel;I)V

    .line 332
    return-void
.end method
