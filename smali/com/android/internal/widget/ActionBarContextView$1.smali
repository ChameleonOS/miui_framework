.class Lcom/android/internal/widget/ActionBarContextView$1;
.super Ljava/lang/Object;
.source "ActionBarContextView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/internal/widget/ActionBarContextView;->initForMode(Landroid/view/ActionMode;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/widget/ActionBarContextView;

.field final synthetic val$mode:Landroid/view/ActionMode;


# direct methods
.method constructor <init>(Lcom/android/internal/widget/ActionBarContextView;Landroid/view/ActionMode;)V
    .registers 3
    .parameter
    .parameter

    .prologue
    .line 213
    iput-object p1, p0, Lcom/android/internal/widget/ActionBarContextView$1;->this$0:Lcom/android/internal/widget/ActionBarContextView;

    iput-object p2, p0, Lcom/android/internal/widget/ActionBarContextView$1;->val$mode:Landroid/view/ActionMode;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .registers 3
    .parameter "v"

    .prologue
    .line 215
    iget-object v0, p0, Lcom/android/internal/widget/ActionBarContextView$1;->val$mode:Landroid/view/ActionMode;

    invoke-virtual {v0}, Landroid/view/ActionMode;->finish()V

    .line 216
    return-void
.end method
