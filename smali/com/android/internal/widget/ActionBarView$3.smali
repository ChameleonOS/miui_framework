.class Lcom/android/internal/widget/ActionBarView$3;
.super Ljava/lang/Object;
.source "ActionBarView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/widget/ActionBarView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/widget/ActionBarView;


# direct methods
.method constructor <init>(Lcom/android/internal/widget/ActionBarView;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Lcom/android/internal/widget/ActionBarView$3;->this$0:Lcom/android/internal/widget/ActionBarView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .registers 5
    .parameter "v"

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/ActionBarView$3;->this$0:Lcom/android/internal/widget/ActionBarView;

    iget-object v0, v0, Lcom/android/internal/widget/ActionBarView;->mWindowCallback:Landroid/view/Window$Callback;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/android/internal/widget/ActionBarView$3;->this$0:Lcom/android/internal/widget/ActionBarView;

    #getter for: Lcom/android/internal/widget/ActionBarView;->mLogoNavItem:Lcom/android/internal/view/menu/ActionMenuItem;
    invoke-static {v2}, Lcom/android/internal/widget/ActionBarView;->access$200(Lcom/android/internal/widget/ActionBarView;)Lcom/android/internal/view/menu/ActionMenuItem;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/view/Window$Callback;->onMenuItemSelected(ILandroid/view/MenuItem;)Z

    return-void
.end method
