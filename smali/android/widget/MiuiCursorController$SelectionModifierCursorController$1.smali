.class Landroid/widget/MiuiCursorController$SelectionModifierCursorController$1;
.super Ljava/lang/Object;
.source "MiuiCursorController.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/MiuiCursorController$SelectionModifierCursorController;-><init>(Landroid/widget/Editor;Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/MiuiCursorController$SelectionModifierCursorController;


# direct methods
.method constructor <init>(Landroid/widget/MiuiCursorController$SelectionModifierCursorController;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController$1;->this$0:Landroid/widget/MiuiCursorController$SelectionModifierCursorController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .registers 4
    .parameter "v"

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController$1;->this$0:Landroid/widget/MiuiCursorController$SelectionModifierCursorController;

    iget-object v0, v0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController$1;->this$0:Landroid/widget/MiuiCursorController$SelectionModifierCursorController;

    invoke-virtual {v0, p1, v1}, Landroid/widget/Editor;->handleFloatPanelClick(Landroid/view/View;Landroid/widget/MiuiCursorController;)V

    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController$1;->this$0:Landroid/widget/MiuiCursorController$SelectionModifierCursorController;

    #getter for: Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;
    invoke-static {v0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->access$200(Landroid/widget/MiuiCursorController$SelectionModifierCursorController;)Landroid/widget/MiuiCursorController$FloatPanelViewController;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    return-void
.end method
