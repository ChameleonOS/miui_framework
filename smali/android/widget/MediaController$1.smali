.class Landroid/widget/MediaController$1;
.super Ljava/lang/Object;
.source "MediaController.java"

# interfaces
.implements Landroid/view/View$OnLayoutChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/MediaController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/MediaController;


# direct methods
.method constructor <init>(Landroid/widget/MediaController;)V
    .registers 2
    .parameter

    .prologue
    .line 177
    iput-object p1, p0, Landroid/widget/MediaController$1;->this$0:Landroid/widget/MediaController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLayoutChange(Landroid/view/View;IIIIIIII)V
    .registers 13
    .parameter "v"
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"
    .parameter "oldLeft"
    .parameter "oldTop"
    .parameter "oldRight"
    .parameter "oldBottom"

    .prologue
    .line 181
    iget-object v0, p0, Landroid/widget/MediaController$1;->this$0:Landroid/widget/MediaController;

    #calls: Landroid/widget/MediaController;->updateFloatingWindowLayout()V
    invoke-static {v0}, Landroid/widget/MediaController;->access$000(Landroid/widget/MediaController;)V

    .line 182
    iget-object v0, p0, Landroid/widget/MediaController$1;->this$0:Landroid/widget/MediaController;

    #getter for: Landroid/widget/MediaController;->mShowing:Z
    invoke-static {v0}, Landroid/widget/MediaController;->access$100(Landroid/widget/MediaController;)Z

    move-result v0

    if-eqz v0, :cond_22

    .line 183
    iget-object v0, p0, Landroid/widget/MediaController$1;->this$0:Landroid/widget/MediaController;

    #getter for: Landroid/widget/MediaController;->mWindowManager:Landroid/view/WindowManager;
    invoke-static {v0}, Landroid/widget/MediaController;->access$400(Landroid/widget/MediaController;)Landroid/view/WindowManager;

    move-result-object v0

    iget-object v1, p0, Landroid/widget/MediaController$1;->this$0:Landroid/widget/MediaController;

    #getter for: Landroid/widget/MediaController;->mDecor:Landroid/view/View;
    invoke-static {v1}, Landroid/widget/MediaController;->access$200(Landroid/widget/MediaController;)Landroid/view/View;

    move-result-object v1

    iget-object v2, p0, Landroid/widget/MediaController$1;->this$0:Landroid/widget/MediaController;

    #getter for: Landroid/widget/MediaController;->mDecorLayoutParams:Landroid/view/WindowManager$LayoutParams;
    invoke-static {v2}, Landroid/widget/MediaController;->access$300(Landroid/widget/MediaController;)Landroid/view/WindowManager$LayoutParams;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/view/WindowManager;->updateViewLayout(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 185
    :cond_22
    return-void
.end method
