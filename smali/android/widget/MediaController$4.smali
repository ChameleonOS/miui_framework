.class Landroid/widget/MediaController$4;
.super Ljava/lang/Object;
.source "MediaController.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    iput-object p1, p0, Landroid/widget/MediaController$4;->this$0:Landroid/widget/MediaController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .registers 4
    .parameter "v"

    .prologue
    iget-object v0, p0, Landroid/widget/MediaController$4;->this$0:Landroid/widget/MediaController;

    #calls: Landroid/widget/MediaController;->doPauseResume()V
    invoke-static {v0}, Landroid/widget/MediaController;->access$800(Landroid/widget/MediaController;)V

    iget-object v0, p0, Landroid/widget/MediaController$4;->this$0:Landroid/widget/MediaController;

    const/16 v1, 0xbb8

    invoke-virtual {v0, v1}, Landroid/widget/MediaController;->show(I)V

    return-void
.end method
