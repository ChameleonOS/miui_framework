.class Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;
.super Ljava/lang/Object;
.source "IconMenuPresenter.java"

# interfaces
.implements Lcom/android/internal/view/menu/MenuPresenter$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/view/menu/IconMenuPresenter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "SubMenuPresenterCallback"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/view/menu/IconMenuPresenter;


# direct methods
.method constructor <init>(Lcom/android/internal/view/menu/IconMenuPresenter;)V
    .registers 2
    .parameter

    .prologue
    .line 176
    iput-object p1, p0, Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;->this$0:Lcom/android/internal/view/menu/IconMenuPresenter;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCloseMenu(Lcom/android/internal/view/menu/MenuBuilder;Z)V
    .registers 5
    .parameter "menu"
    .parameter "allMenusAreClosing"

    .prologue
    .line 179
    iget-object v0, p0, Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;->this$0:Lcom/android/internal/view/menu/IconMenuPresenter;

    const/4 v1, 0x0

    iput v1, v0, Lcom/android/internal/view/menu/IconMenuPresenter;->mOpenSubMenuId:I

    .line 180
    iget-object v0, p0, Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;->this$0:Lcom/android/internal/view/menu/IconMenuPresenter;

    iget-object v0, v0, Lcom/android/internal/view/menu/IconMenuPresenter;->mOpenSubMenu:Lcom/android/internal/view/menu/MenuDialogHelper;

    if-eqz v0, :cond_17

    .line 181
    iget-object v0, p0, Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;->this$0:Lcom/android/internal/view/menu/IconMenuPresenter;

    iget-object v0, v0, Lcom/android/internal/view/menu/IconMenuPresenter;->mOpenSubMenu:Lcom/android/internal/view/menu/MenuDialogHelper;

    invoke-virtual {v0}, Lcom/android/internal/view/menu/MenuDialogHelper;->dismiss()V

    .line 182
    iget-object v0, p0, Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;->this$0:Lcom/android/internal/view/menu/IconMenuPresenter;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/android/internal/view/menu/IconMenuPresenter;->mOpenSubMenu:Lcom/android/internal/view/menu/MenuDialogHelper;

    .line 184
    :cond_17
    return-void
.end method

.method public onOpenSubMenu(Lcom/android/internal/view/menu/MenuBuilder;)Z
    .registers 4
    .parameter "subMenu"

    .prologue
    .line 188
    if-eqz p1, :cond_10

    .line 189
    iget-object v0, p0, Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;->this$0:Lcom/android/internal/view/menu/IconMenuPresenter;

    check-cast p1, Lcom/android/internal/view/menu/SubMenuBuilder;

    .end local p1
    invoke-virtual {p1}, Lcom/android/internal/view/menu/SubMenuBuilder;->getItem()Landroid/view/MenuItem;

    move-result-object v1

    invoke-interface {v1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    iput v1, v0, Lcom/android/internal/view/menu/IconMenuPresenter;->mOpenSubMenuId:I

    .line 191
    :cond_10
    const/4 v0, 0x0

    return v0
.end method
