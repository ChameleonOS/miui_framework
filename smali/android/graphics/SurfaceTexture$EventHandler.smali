.class Landroid/graphics/SurfaceTexture$EventHandler;
.super Landroid/os/Handler;
.source "SurfaceTexture.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/graphics/SurfaceTexture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "EventHandler"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/graphics/SurfaceTexture;


# direct methods
.method public constructor <init>(Landroid/graphics/SurfaceTexture;Landroid/os/Looper;)V
    .registers 3
    .parameter
    .parameter "looper"

    .prologue
    iput-object p1, p0, Landroid/graphics/SurfaceTexture$EventHandler;->this$0:Landroid/graphics/SurfaceTexture;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 4
    .parameter "msg"

    .prologue
    iget-object v0, p0, Landroid/graphics/SurfaceTexture$EventHandler;->this$0:Landroid/graphics/SurfaceTexture;

    #getter for: Landroid/graphics/SurfaceTexture;->mOnFrameAvailableListener:Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;
    invoke-static {v0}, Landroid/graphics/SurfaceTexture;->access$000(Landroid/graphics/SurfaceTexture;)Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;

    move-result-object v0

    if-eqz v0, :cond_13

    iget-object v0, p0, Landroid/graphics/SurfaceTexture$EventHandler;->this$0:Landroid/graphics/SurfaceTexture;

    #getter for: Landroid/graphics/SurfaceTexture;->mOnFrameAvailableListener:Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;
    invoke-static {v0}, Landroid/graphics/SurfaceTexture;->access$000(Landroid/graphics/SurfaceTexture;)Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;

    move-result-object v0

    iget-object v1, p0, Landroid/graphics/SurfaceTexture$EventHandler;->this$0:Landroid/graphics/SurfaceTexture;

    invoke-interface {v0, v1}, Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;->onFrameAvailable(Landroid/graphics/SurfaceTexture;)V

    :cond_13
    return-void
.end method
