.class Landroid/widget/MiuiCursorController$InsertionPointCursorController$1;
.super Ljava/lang/Object;
.source "MiuiCursorController.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/MiuiCursorController$InsertionPointCursorController;-><init>(Landroid/widget/Editor;Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/MiuiCursorController$InsertionPointCursorController;


# direct methods
.method constructor <init>(Landroid/widget/MiuiCursorController$InsertionPointCursorController;)V
    .registers 2
    .parameter

    .prologue
    .line 353
    iput-object p1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController$1;->this$0:Landroid/widget/MiuiCursorController$InsertionPointCursorController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .registers 4
    .parameter "v"

    .prologue
    .line 356
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController$1;->this$0:Landroid/widget/MiuiCursorController$InsertionPointCursorController;

    iget-object v0, v0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController$1;->this$0:Landroid/widget/MiuiCursorController$InsertionPointCursorController;

    invoke-virtual {v0, p1, v1}, Landroid/widget/Editor;->handleFloatPanelClick(Landroid/view/View;Landroid/widget/MiuiCursorController;)V

    .line 357
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController$1;->this$0:Landroid/widget/MiuiCursorController$InsertionPointCursorController;

    #getter for: Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;
    invoke-static {v0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->access$100(Landroid/widget/MiuiCursorController$InsertionPointCursorController;)Landroid/widget/MiuiCursorController$FloatPanelViewController;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    .line 358
    return-void
.end method
