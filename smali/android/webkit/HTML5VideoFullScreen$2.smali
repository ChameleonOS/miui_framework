.class Landroid/webkit/HTML5VideoFullScreen$2;
.super Ljava/lang/Object;
.source "HTML5VideoFullScreen.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnVideoSizeChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/HTML5VideoFullScreen;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/HTML5VideoFullScreen;


# direct methods
.method constructor <init>(Landroid/webkit/HTML5VideoFullScreen;)V
    .registers 2
    .parameter

    .prologue
    .line 118
    iput-object p1, p0, Landroid/webkit/HTML5VideoFullScreen$2;->this$0:Landroid/webkit/HTML5VideoFullScreen;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onVideoSizeChanged(Landroid/media/MediaPlayer;II)V
    .registers 7
    .parameter "mp"
    .parameter "width"
    .parameter "height"

    .prologue
    .line 121
    iget-object v0, p0, Landroid/webkit/HTML5VideoFullScreen$2;->this$0:Landroid/webkit/HTML5VideoFullScreen;

    invoke-virtual {p1}, Landroid/media/MediaPlayer;->getVideoWidth()I

    move-result v1

    #setter for: Landroid/webkit/HTML5VideoFullScreen;->mVideoWidth:I
    invoke-static {v0, v1}, Landroid/webkit/HTML5VideoFullScreen;->access$002(Landroid/webkit/HTML5VideoFullScreen;I)I

    .line 122
    iget-object v0, p0, Landroid/webkit/HTML5VideoFullScreen$2;->this$0:Landroid/webkit/HTML5VideoFullScreen;

    invoke-virtual {p1}, Landroid/media/MediaPlayer;->getVideoHeight()I

    move-result v1

    #setter for: Landroid/webkit/HTML5VideoFullScreen;->mVideoHeight:I
    invoke-static {v0, v1}, Landroid/webkit/HTML5VideoFullScreen;->access$102(Landroid/webkit/HTML5VideoFullScreen;I)I

    .line 123
    iget-object v0, p0, Landroid/webkit/HTML5VideoFullScreen$2;->this$0:Landroid/webkit/HTML5VideoFullScreen;

    #getter for: Landroid/webkit/HTML5VideoFullScreen;->mVideoWidth:I
    invoke-static {v0}, Landroid/webkit/HTML5VideoFullScreen;->access$000(Landroid/webkit/HTML5VideoFullScreen;)I

    move-result v0

    if-eqz v0, :cond_3b

    iget-object v0, p0, Landroid/webkit/HTML5VideoFullScreen$2;->this$0:Landroid/webkit/HTML5VideoFullScreen;

    #getter for: Landroid/webkit/HTML5VideoFullScreen;->mVideoHeight:I
    invoke-static {v0}, Landroid/webkit/HTML5VideoFullScreen;->access$100(Landroid/webkit/HTML5VideoFullScreen;)I

    move-result v0

    if-eqz v0, :cond_3b

    .line 124
    iget-object v0, p0, Landroid/webkit/HTML5VideoFullScreen$2;->this$0:Landroid/webkit/HTML5VideoFullScreen;

    #getter for: Landroid/webkit/HTML5VideoFullScreen;->mVideoSurfaceView:Landroid/webkit/HTML5VideoFullScreen$VideoSurfaceView;
    invoke-static {v0}, Landroid/webkit/HTML5VideoFullScreen;->access$600(Landroid/webkit/HTML5VideoFullScreen;)Landroid/webkit/HTML5VideoFullScreen$VideoSurfaceView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/HTML5VideoFullScreen$VideoSurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/HTML5VideoFullScreen$2;->this$0:Landroid/webkit/HTML5VideoFullScreen;

    #getter for: Landroid/webkit/HTML5VideoFullScreen;->mVideoWidth:I
    invoke-static {v1}, Landroid/webkit/HTML5VideoFullScreen;->access$000(Landroid/webkit/HTML5VideoFullScreen;)I

    move-result v1

    iget-object v2, p0, Landroid/webkit/HTML5VideoFullScreen$2;->this$0:Landroid/webkit/HTML5VideoFullScreen;

    #getter for: Landroid/webkit/HTML5VideoFullScreen;->mVideoHeight:I
    invoke-static {v2}, Landroid/webkit/HTML5VideoFullScreen;->access$100(Landroid/webkit/HTML5VideoFullScreen;)I

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/view/SurfaceHolder;->setFixedSize(II)V

    .line 126
    :cond_3b
    return-void
.end method
