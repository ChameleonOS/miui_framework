.class Landroid/widget/AdapterViewFlipper$2;
.super Landroid/os/Handler;
.source "AdapterViewFlipper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/AdapterViewFlipper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/AdapterViewFlipper;


# direct methods
.method constructor <init>(Landroid/widget/AdapterViewFlipper;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/AdapterViewFlipper$2;->this$0:Landroid/widget/AdapterViewFlipper;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .registers 4
    .parameter "msg"

    .prologue
    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_12

    iget-object v0, p0, Landroid/widget/AdapterViewFlipper$2;->this$0:Landroid/widget/AdapterViewFlipper;

    #getter for: Landroid/widget/AdapterViewFlipper;->mRunning:Z
    invoke-static {v0}, Landroid/widget/AdapterViewFlipper;->access$300(Landroid/widget/AdapterViewFlipper;)Z

    move-result v0

    if-eqz v0, :cond_12

    iget-object v0, p0, Landroid/widget/AdapterViewFlipper$2;->this$0:Landroid/widget/AdapterViewFlipper;

    invoke-virtual {v0}, Landroid/widget/AdapterViewFlipper;->showNext()V

    :cond_12
    return-void
.end method
