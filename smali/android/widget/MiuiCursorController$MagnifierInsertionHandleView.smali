.class Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;
.super Landroid/widget/MiuiCursorController$InsertionHandleView;
.source "MiuiCursorController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/MiuiCursorController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MagnifierInsertionHandleView"
.end annotation


# instance fields
.field canHide:Z

.field final synthetic this$0:Landroid/widget/MiuiCursorController;


# direct methods
.method public constructor <init>(Landroid/widget/MiuiCursorController;Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;)V
    .registers 5
    .parameter
    .parameter "tv"
    .parameter "drawable"

    .prologue
    iput-object p1, p0, Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;->this$0:Landroid/widget/MiuiCursorController;

    invoke-direct {p0, p1, p2, p3}, Landroid/widget/MiuiCursorController$InsertionHandleView;-><init>(Landroid/widget/MiuiCursorController;Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;->canHide:Z

    return-void
.end method


# virtual methods
.method public hide()V
    .registers 3

    .prologue
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;->canHide:Z

    if-eqz v0, :cond_a

    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0, p0}, Landroid/widget/Editor;->removePositionListenerSubscriber(Landroid/widget/Editor$TextViewPositionListener;)V

    :goto_9
    return-void

    :cond_a
    const-string v0, "MiuiHandleView"

    const-string v1, "To hide the MagnifierInsertionHandleView, just delay"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;->canHide:Z

    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;->dismiss()V

    const/16 v0, 0xc8

    invoke-virtual {p0, v0}, Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;->hideAfterDelay(I)V

    goto :goto_9
.end method

.method protected needShowHandle()Z
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public show()V
    .registers 3

    .prologue
    invoke-super {p0}, Landroid/widget/MiuiCursorController$InsertionHandleView;->show()V

    const/16 v0, 0xbb8

    invoke-virtual {p0, v0}, Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;->hideAfterDelay(I)V

    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;->getCurrentCursorOffset()I

    move-result v0

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;->updatePositionXY(IZ)V

    return-void
.end method
