.class Landroid/webkit/ViewManager$ChildView$2;
.super Ljava/lang/Object;
.source "ViewManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/ViewManager$ChildView;->removeView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/webkit/ViewManager$ChildView;


# direct methods
.method constructor <init>(Landroid/webkit/ViewManager$ChildView;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/webkit/ViewManager$ChildView$2;->this$1:Landroid/webkit/ViewManager$ChildView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/webkit/ViewManager$ChildView$2;->this$1:Landroid/webkit/ViewManager$ChildView;

    #calls: Landroid/webkit/ViewManager$ChildView;->removeViewOnUIThread()V
    invoke-static {v0}, Landroid/webkit/ViewManager$ChildView;->access$500(Landroid/webkit/ViewManager$ChildView;)V

    return-void
.end method
