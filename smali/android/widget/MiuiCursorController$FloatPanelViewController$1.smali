.class Landroid/widget/MiuiCursorController$FloatPanelViewController$1;
.super Ljava/lang/Object;
.source "MiuiCursorController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/widget/MiuiCursorController$FloatPanelViewController;


# direct methods
.method constructor <init>(Landroid/widget/MiuiCursorController$FloatPanelViewController;)V
    .registers 2
    .parameter

    .prologue
    .line 263
    iput-object p1, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController$1;->this$1:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 3

    .prologue
    .line 266
    const-string v0, "MiuiCursorController"

    const-string v1, ">>FloatPanelViewController to updatePosition for showAndUpdatePositionAsync"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 267
    iget-object v0, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController$1;->this$1:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    #calls: Landroid/widget/MiuiCursorController$FloatPanelViewController;->updatePosition()V
    invoke-static {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->access$000(Landroid/widget/MiuiCursorController$FloatPanelViewController;)V

    .line 268
    return-void
.end method
