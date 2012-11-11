.class public Lcom/android/internal/view/menu/IconMenuPresenter;
.super Lcom/android/internal/view/menu/BaseMenuPresenter;
.source "IconMenuPresenter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;
    }
.end annotation


# static fields
.field private static final OPEN_SUBMENU_KEY:Ljava/lang/String; = "android:menu:icon:submenu"

.field private static final VIEWS_TAG:Ljava/lang/String; = "android:menu:icon"


# instance fields
.field private mMaxItems:I

.field private mMoreView:Lcom/android/internal/view/menu/IconMenuItemView;

.field mOpenSubMenu:Lcom/android/internal/view/menu/MenuDialogHelper;

.field mOpenSubMenuId:I

.field mSubMenuPresenterCallback:Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 5
    .parameter "context"

    .prologue
    new-instance v0, Landroid/view/ContextThemeWrapper;

    const v1, 0x10302ee

    invoke-direct {v0, p1, v1}, Landroid/view/ContextThemeWrapper;-><init>(Landroid/content/Context;I)V

    const v1, 0x1090046

    const v2, 0x1090045

    invoke-direct {p0, v0, v1, v2}, Lcom/android/internal/view/menu/BaseMenuPresenter;-><init>(Landroid/content/Context;II)V

    const/4 v0, -0x1

    iput v0, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMaxItems:I

    new-instance v0, Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;

    invoke-direct {v0, p0}, Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;-><init>(Lcom/android/internal/view/menu/IconMenuPresenter;)V

    iput-object v0, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mSubMenuPresenterCallback:Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;

    return-void
.end method


# virtual methods
.method protected addItemView(Landroid/view/View;I)V
    .registers 6
    .parameter "itemView"
    .parameter "childIndex"

    .prologue
    move-object v1, p1

    check-cast v1, Lcom/android/internal/view/menu/IconMenuItemView;

    .local v1, v:Lcom/android/internal/view/menu/IconMenuItemView;
    iget-object v0, p0, Lcom/android/internal/view/menu/BaseMenuPresenter;->mMenuView:Lcom/android/internal/view/menu/MenuView;

    check-cast v0, Lcom/android/internal/view/menu/IconMenuView;

    .local v0, parent:Lcom/android/internal/view/menu/IconMenuView;
    invoke-virtual {v1, v0}, Lcom/android/internal/view/menu/IconMenuItemView;->setIconMenuView(Lcom/android/internal/view/menu/IconMenuView;)V

    invoke-virtual {v1, v0}, Lcom/android/internal/view/menu/IconMenuItemView;->setItemInvoker(Lcom/android/internal/view/menu/MenuBuilder$ItemInvoker;)V

    invoke-virtual {v0}, Lcom/android/internal/view/menu/IconMenuView;->getItemBackgroundDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/android/internal/view/menu/IconMenuItemView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    invoke-super {p0, p1, p2}, Lcom/android/internal/view/menu/BaseMenuPresenter;->addItemView(Landroid/view/View;I)V

    return-void
.end method

.method public bindItemView(Lcom/android/internal/view/menu/MenuItemImpl;Lcom/android/internal/view/menu/MenuView$ItemView;)V
    .registers 6
    .parameter "item"
    .parameter "itemView"

    .prologue
    move-object v0, p2

    check-cast v0, Lcom/android/internal/view/menu/IconMenuItemView;

    .local v0, view:Lcom/android/internal/view/menu/IconMenuItemView;
    invoke-virtual {v0, p1}, Lcom/android/internal/view/menu/IconMenuItemView;->setItemData(Lcom/android/internal/view/menu/MenuItemImpl;)V

    invoke-virtual {p1, v0}, Lcom/android/internal/view/menu/MenuItemImpl;->getTitleForItemView(Lcom/android/internal/view/menu/MenuView$ItemView;)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {p1}, Lcom/android/internal/view/menu/MenuItemImpl;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/android/internal/view/menu/IconMenuItemView;->initialize(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;)V

    invoke-virtual {p1}, Lcom/android/internal/view/menu/MenuItemImpl;->isVisible()Z

    move-result v1

    if-eqz v1, :cond_2a

    const/4 v1, 0x0

    :goto_18
    invoke-virtual {v0, v1}, Lcom/android/internal/view/menu/IconMenuItemView;->setVisibility(I)V

    invoke-virtual {v0}, Lcom/android/internal/view/menu/IconMenuItemView;->isEnabled()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/internal/view/menu/IconMenuItemView;->setEnabled(Z)V

    invoke-virtual {v0}, Lcom/android/internal/view/menu/IconMenuItemView;->getTextAppropriateLayoutParams()Lcom/android/internal/view/menu/IconMenuView$LayoutParams;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/internal/view/menu/IconMenuItemView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    return-void

    :cond_2a
    const/16 v1, 0x8

    goto :goto_18
.end method

.method protected filterLeftoverView(Landroid/view/ViewGroup;I)Z
    .registers 5
    .parameter "parent"
    .parameter "childIndex"

    .prologue
    invoke-virtual {p1, p2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMoreView:Lcom/android/internal/view/menu/IconMenuItemView;

    if-eq v0, v1, :cond_d

    invoke-super {p0, p1, p2}, Lcom/android/internal/view/menu/BaseMenuPresenter;->filterLeftoverView(Landroid/view/ViewGroup;I)Z

    move-result v0

    :goto_c
    return v0

    :cond_d
    const/4 v0, 0x0

    goto :goto_c
.end method

.method public getNumActualItemsShown()I
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/view/menu/BaseMenuPresenter;->mMenuView:Lcom/android/internal/view/menu/MenuView;

    check-cast v0, Lcom/android/internal/view/menu/IconMenuView;

    invoke-virtual {v0}, Lcom/android/internal/view/menu/IconMenuView;->getNumActualItemsShown()I

    move-result v0

    return v0
.end method

.method public initForMenu(Landroid/content/Context;Lcom/android/internal/view/menu/MenuBuilder;)V
    .registers 4
    .parameter "context"
    .parameter "menu"

    .prologue
    invoke-super {p0, p1, p2}, Lcom/android/internal/view/menu/BaseMenuPresenter;->initForMenu(Landroid/content/Context;Lcom/android/internal/view/menu/MenuBuilder;)V

    const/4 v0, -0x1

    iput v0, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMaxItems:I

    return-void
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .registers 2
    .parameter "state"

    .prologue
    check-cast p1, Landroid/os/Bundle;

    .end local p1
    invoke-virtual {p0, p1}, Lcom/android/internal/view/menu/IconMenuPresenter;->restoreHierarchyState(Landroid/os/Bundle;)V

    return-void
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .registers 4

    .prologue
    iget-object v1, p0, Lcom/android/internal/view/menu/BaseMenuPresenter;->mMenuView:Lcom/android/internal/view/menu/MenuView;

    if-nez v1, :cond_6

    const/4 v0, 0x0

    :cond_5
    :goto_5
    return-object v0

    :cond_6
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .local v0, state:Landroid/os/Bundle;
    invoke-virtual {p0, v0}, Lcom/android/internal/view/menu/IconMenuPresenter;->saveHierarchyState(Landroid/os/Bundle;)V

    iget v1, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mOpenSubMenuId:I

    if-lez v1, :cond_5

    const-string v1, "android:menu:icon:submenu"

    iget v2, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mOpenSubMenuId:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    goto :goto_5
.end method

.method public onSubMenuSelected(Lcom/android/internal/view/menu/SubMenuBuilder;)Z
    .registers 4
    .parameter "subMenu"

    .prologue
    invoke-virtual {p1}, Lcom/android/internal/view/menu/SubMenuBuilder;->hasVisibleItems()Z

    move-result v1

    if-nez v1, :cond_8

    const/4 v1, 0x0

    :goto_7
    return v1

    :cond_8
    new-instance v0, Lcom/android/internal/view/menu/MenuDialogHelper;

    invoke-direct {v0, p1}, Lcom/android/internal/view/menu/MenuDialogHelper;-><init>(Lcom/android/internal/view/menu/MenuBuilder;)V

    .local v0, helper:Lcom/android/internal/view/menu/MenuDialogHelper;
    iget-object v1, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mSubMenuPresenterCallback:Lcom/android/internal/view/menu/IconMenuPresenter$SubMenuPresenterCallback;

    invoke-virtual {v0, v1}, Lcom/android/internal/view/menu/MenuDialogHelper;->setPresenterCallback(Lcom/android/internal/view/menu/MenuPresenter$Callback;)V

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/android/internal/view/menu/MenuDialogHelper;->show(Landroid/os/IBinder;)V

    iput-object v0, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mOpenSubMenu:Lcom/android/internal/view/menu/MenuDialogHelper;

    invoke-virtual {p1}, Lcom/android/internal/view/menu/SubMenuBuilder;->getItem()Landroid/view/MenuItem;

    move-result-object v1

    invoke-interface {v1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    iput v1, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mOpenSubMenuId:I

    invoke-super {p0, p1}, Lcom/android/internal/view/menu/BaseMenuPresenter;->onSubMenuSelected(Lcom/android/internal/view/menu/SubMenuBuilder;)Z

    const/4 v1, 0x1

    goto :goto_7
.end method

.method public restoreHierarchyState(Landroid/os/Bundle;)V
    .registers 7
    .parameter "inState"

    .prologue
    const-string v3, "android:menu:icon"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getSparseParcelableArray(Ljava/lang/String;)Landroid/util/SparseArray;

    move-result-object v2

    .local v2, viewStates:Landroid/util/SparseArray;,"Landroid/util/SparseArray<Landroid/os/Parcelable;>;"
    if-eqz v2, :cond_f

    iget-object v3, p0, Lcom/android/internal/view/menu/BaseMenuPresenter;->mMenuView:Lcom/android/internal/view/menu/MenuView;

    check-cast v3, Landroid/view/View;

    invoke-virtual {v3, v2}, Landroid/view/View;->restoreHierarchyState(Landroid/util/SparseArray;)V

    :cond_f
    const-string v3, "android:menu:icon:submenu"

    const/4 v4, 0x0

    invoke-virtual {p1, v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    .local v1, subMenuId:I
    if-lez v1, :cond_2d

    iget-object v3, p0, Lcom/android/internal/view/menu/BaseMenuPresenter;->mMenu:Lcom/android/internal/view/menu/MenuBuilder;

    if-eqz v3, :cond_2d

    iget-object v3, p0, Lcom/android/internal/view/menu/BaseMenuPresenter;->mMenu:Lcom/android/internal/view/menu/MenuBuilder;

    invoke-virtual {v3, v1}, Lcom/android/internal/view/menu/MenuBuilder;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .local v0, item:Landroid/view/MenuItem;
    if-eqz v0, :cond_2d

    invoke-interface {v0}, Landroid/view/MenuItem;->getSubMenu()Landroid/view/SubMenu;

    move-result-object v3

    check-cast v3, Lcom/android/internal/view/menu/SubMenuBuilder;

    invoke-virtual {p0, v3}, Lcom/android/internal/view/menu/IconMenuPresenter;->onSubMenuSelected(Lcom/android/internal/view/menu/SubMenuBuilder;)Z

    .end local v0           #item:Landroid/view/MenuItem;
    :cond_2d
    return-void
.end method

.method public saveHierarchyState(Landroid/os/Bundle;)V
    .registers 4
    .parameter "outState"

    .prologue
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    .local v0, viewStates:Landroid/util/SparseArray;,"Landroid/util/SparseArray<Landroid/os/Parcelable;>;"
    iget-object v1, p0, Lcom/android/internal/view/menu/BaseMenuPresenter;->mMenuView:Lcom/android/internal/view/menu/MenuView;

    if-eqz v1, :cond_10

    iget-object v1, p0, Lcom/android/internal/view/menu/BaseMenuPresenter;->mMenuView:Lcom/android/internal/view/menu/MenuView;

    check-cast v1, Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->saveHierarchyState(Landroid/util/SparseArray;)V

    :cond_10
    const-string v1, "android:menu:icon"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putSparseParcelableArray(Ljava/lang/String;Landroid/util/SparseArray;)V

    return-void
.end method

.method public shouldIncludeItem(ILcom/android/internal/view/menu/MenuItemImpl;)Z
    .registers 9
    .parameter "childIndex"
    .parameter "item"

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/android/internal/view/menu/BaseMenuPresenter;->mMenu:Lcom/android/internal/view/menu/MenuBuilder;

    invoke-virtual {v4}, Lcom/android/internal/view/menu/MenuBuilder;->getNonActionItems()Ljava/util/ArrayList;

    move-result-object v1

    .local v1, itemsToShow:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/view/menu/MenuItemImpl;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v4

    iget v5, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMaxItems:I

    if-ne v4, v5, :cond_14

    iget v4, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMaxItems:I

    if-lt p1, v4, :cond_1a

    :cond_14
    iget v4, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMaxItems:I

    add-int/lit8 v4, v4, -0x1

    if-ge p1, v4, :cond_24

    :cond_1a
    move v0, v2

    .local v0, fits:Z
    :goto_1b
    if-eqz v0, :cond_26

    invoke-virtual {p2}, Lcom/android/internal/view/menu/MenuItemImpl;->isActionButton()Z

    move-result v4

    if-nez v4, :cond_26

    :goto_23
    return v2

    .end local v0           #fits:Z
    :cond_24
    move v0, v3

    goto :goto_1b

    .restart local v0       #fits:Z
    :cond_26
    move v2, v3

    goto :goto_23
.end method

.method public updateMenuView(Z)V
    .registers 7
    .parameter "cleared"

    .prologue
    iget-object v1, p0, Lcom/android/internal/view/menu/BaseMenuPresenter;->mMenuView:Lcom/android/internal/view/menu/MenuView;

    check-cast v1, Lcom/android/internal/view/menu/IconMenuView;

    .local v1, menuView:Lcom/android/internal/view/menu/IconMenuView;
    iget v3, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMaxItems:I

    if-gez v3, :cond_e

    invoke-virtual {v1}, Lcom/android/internal/view/menu/IconMenuView;->getMaxItems()I

    move-result v3

    iput v3, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMaxItems:I

    :cond_e
    iget-object v3, p0, Lcom/android/internal/view/menu/BaseMenuPresenter;->mMenu:Lcom/android/internal/view/menu/MenuBuilder;

    invoke-virtual {v3}, Lcom/android/internal/view/menu/MenuBuilder;->getNonActionItems()Ljava/util/ArrayList;

    move-result-object v0

    .local v0, itemsToShow:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/android/internal/view/menu/MenuItemImpl;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v3

    iget v4, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMaxItems:I

    if-le v3, v4, :cond_50

    const/4 v2, 0x1

    .local v2, needsMore:Z
    :goto_1d
    invoke-super {p0, p1}, Lcom/android/internal/view/menu/BaseMenuPresenter;->updateMenuView(Z)V

    if-eqz v2, :cond_52

    iget-object v3, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMoreView:Lcom/android/internal/view/menu/IconMenuItemView;

    if-eqz v3, :cond_2e

    iget-object v3, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMoreView:Lcom/android/internal/view/menu/IconMenuItemView;

    invoke-virtual {v3}, Lcom/android/internal/view/menu/IconMenuItemView;->getParent()Landroid/view/ViewParent;

    move-result-object v3

    if-eq v3, v1, :cond_52

    :cond_2e
    iget-object v3, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMoreView:Lcom/android/internal/view/menu/IconMenuItemView;

    if-nez v3, :cond_41

    invoke-virtual {v1}, Lcom/android/internal/view/menu/IconMenuView;->createMoreItemView()Lcom/android/internal/view/menu/IconMenuItemView;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMoreView:Lcom/android/internal/view/menu/IconMenuItemView;

    iget-object v3, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMoreView:Lcom/android/internal/view/menu/IconMenuItemView;

    invoke-virtual {v1}, Lcom/android/internal/view/menu/IconMenuView;->getItemBackgroundDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/android/internal/view/menu/IconMenuItemView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    :cond_41
    iget-object v3, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMoreView:Lcom/android/internal/view/menu/IconMenuItemView;

    invoke-virtual {v1, v3}, Lcom/android/internal/view/menu/IconMenuView;->addView(Landroid/view/View;)V

    :cond_46
    :goto_46
    if-eqz v2, :cond_5e

    iget v3, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMaxItems:I

    add-int/lit8 v3, v3, -0x1

    :goto_4c
    invoke-virtual {v1, v3}, Lcom/android/internal/view/menu/IconMenuView;->setNumActualItemsShown(I)V

    return-void

    .end local v2           #needsMore:Z
    :cond_50
    const/4 v2, 0x0

    goto :goto_1d

    .restart local v2       #needsMore:Z
    :cond_52
    if-nez v2, :cond_46

    iget-object v3, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMoreView:Lcom/android/internal/view/menu/IconMenuItemView;

    if-eqz v3, :cond_46

    iget-object v3, p0, Lcom/android/internal/view/menu/IconMenuPresenter;->mMoreView:Lcom/android/internal/view/menu/IconMenuItemView;

    invoke-virtual {v1, v3}, Lcom/android/internal/view/menu/IconMenuView;->removeView(Landroid/view/View;)V

    goto :goto_46

    :cond_5e
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v3

    goto :goto_4c
.end method
