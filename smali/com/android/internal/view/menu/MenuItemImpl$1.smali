.class Lcom/android/internal/view/menu/MenuItemImpl$1;
.super Ljava/lang/Object;
.source "MenuItemImpl.java"

# interfaces
.implements Landroid/view/ActionProvider$VisibilityListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/internal/view/menu/MenuItemImpl;->setActionProvider(Landroid/view/ActionProvider;)Landroid/view/MenuItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/view/menu/MenuItemImpl;


# direct methods
.method constructor <init>(Lcom/android/internal/view/menu/MenuItemImpl;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Lcom/android/internal/view/menu/MenuItemImpl$1;->this$0:Lcom/android/internal/view/menu/MenuItemImpl;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionProviderVisibilityChanged(Z)V
    .registers 4
    .parameter "isVisible"

    .prologue
    iget-object v0, p0, Lcom/android/internal/view/menu/MenuItemImpl$1;->this$0:Lcom/android/internal/view/menu/MenuItemImpl;

    #getter for: Lcom/android/internal/view/menu/MenuItemImpl;->mMenu:Lcom/android/internal/view/menu/MenuBuilder;
    invoke-static {v0}, Lcom/android/internal/view/menu/MenuItemImpl;->access$000(Lcom/android/internal/view/menu/MenuItemImpl;)Lcom/android/internal/view/menu/MenuBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/view/menu/MenuItemImpl$1;->this$0:Lcom/android/internal/view/menu/MenuItemImpl;

    invoke-virtual {v0, v1}, Lcom/android/internal/view/menu/MenuBuilder;->onItemVisibleChanged(Lcom/android/internal/view/menu/MenuItemImpl;)V

    return-void
.end method
