.class Landroid/widget/MiuiCursorController$InsertionHandleView$1;
.super Ljava/lang/Object;
.source "MiuiCursorController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/MiuiCursorController$InsertionHandleView;->hideAfterDelay(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/widget/MiuiCursorController$InsertionHandleView;


# direct methods
.method constructor <init>(Landroid/widget/MiuiCursorController$InsertionHandleView;)V
    .registers 2
    .parameter

    .prologue
    .line 1120
    iput-object p1, p0, Landroid/widget/MiuiCursorController$InsertionHandleView$1;->this$1:Landroid/widget/MiuiCursorController$InsertionHandleView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    .prologue
    .line 1122
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionHandleView$1;->this$1:Landroid/widget/MiuiCursorController$InsertionHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$InsertionHandleView;->hide()V

    .line 1123
    return-void
.end method
