.class Landroid/view/ViewRootImpl$1$1;
.super Ljava/lang/Object;
.source "ViewRootImpl.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/view/ViewRootImpl$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/view/ViewRootImpl$1;


# direct methods
.method constructor <init>(Landroid/view/ViewRootImpl$1;)V
    .registers 2
    .parameter

    .prologue
    .line 1965
    iput-object p1, p0, Landroid/view/ViewRootImpl$1$1;->this$1:Landroid/view/ViewRootImpl$1;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 5

    .prologue
    const/4 v3, 0x0

    .line 1968
    iget-object v0, p0, Landroid/view/ViewRootImpl$1$1;->this$1:Landroid/view/ViewRootImpl$1;

    iget-object v0, v0, Landroid/view/ViewRootImpl$1;->this$0:Landroid/view/ViewRootImpl;

    iget-object v0, v0, Landroid/view/ViewRootImpl;->mDirty:Landroid/graphics/Rect;

    iget-object v1, p0, Landroid/view/ViewRootImpl$1$1;->this$1:Landroid/view/ViewRootImpl$1;

    iget-object v1, v1, Landroid/view/ViewRootImpl$1;->this$0:Landroid/view/ViewRootImpl;

    iget v1, v1, Landroid/view/ViewRootImpl;->mWidth:I

    iget-object v2, p0, Landroid/view/ViewRootImpl$1$1;->this$1:Landroid/view/ViewRootImpl$1;

    iget-object v2, v2, Landroid/view/ViewRootImpl$1;->this$0:Landroid/view/ViewRootImpl;

    iget v2, v2, Landroid/view/ViewRootImpl;->mHeight:I

    invoke-virtual {v0, v3, v3, v1, v2}, Landroid/graphics/Rect;->set(IIII)V

    .line 1969
    iget-object v0, p0, Landroid/view/ViewRootImpl$1$1;->this$1:Landroid/view/ViewRootImpl$1;

    iget-object v0, v0, Landroid/view/ViewRootImpl$1;->this$0:Landroid/view/ViewRootImpl;

    invoke-virtual {v0}, Landroid/view/ViewRootImpl;->scheduleTraversals()V

    .line 1970
    return-void
.end method
