.class Landroid/widget/ZoomButton$1;
.super Ljava/lang/Object;
.source "ZoomButton.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/ZoomButton;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/ZoomButton;


# direct methods
.method constructor <init>(Landroid/widget/ZoomButton;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/ZoomButton$1;->this$0:Landroid/widget/ZoomButton;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 4

    .prologue
    iget-object v0, p0, Landroid/widget/ZoomButton$1;->this$0:Landroid/widget/ZoomButton;

    invoke-virtual {v0}, Landroid/widget/ZoomButton;->hasOnClickListeners()Z

    move-result v0

    if-eqz v0, :cond_2c

    iget-object v0, p0, Landroid/widget/ZoomButton$1;->this$0:Landroid/widget/ZoomButton;

    #getter for: Landroid/widget/ZoomButton;->mIsInLongpress:Z
    invoke-static {v0}, Landroid/widget/ZoomButton;->access$000(Landroid/widget/ZoomButton;)Z

    move-result v0

    if-eqz v0, :cond_2c

    iget-object v0, p0, Landroid/widget/ZoomButton$1;->this$0:Landroid/widget/ZoomButton;

    invoke-virtual {v0}, Landroid/widget/ZoomButton;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_2c

    iget-object v0, p0, Landroid/widget/ZoomButton$1;->this$0:Landroid/widget/ZoomButton;

    invoke-virtual {v0}, Landroid/widget/ZoomButton;->callOnClick()Z

    iget-object v0, p0, Landroid/widget/ZoomButton$1;->this$0:Landroid/widget/ZoomButton;

    #getter for: Landroid/widget/ZoomButton;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Landroid/widget/ZoomButton;->access$200(Landroid/widget/ZoomButton;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Landroid/widget/ZoomButton$1;->this$0:Landroid/widget/ZoomButton;

    #getter for: Landroid/widget/ZoomButton;->mZoomSpeed:J
    invoke-static {v1}, Landroid/widget/ZoomButton;->access$100(Landroid/widget/ZoomButton;)J

    move-result-wide v1

    invoke-virtual {v0, p0, v1, v2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    :cond_2c
    return-void
.end method
