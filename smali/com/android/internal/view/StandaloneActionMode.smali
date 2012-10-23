.class public Lcom/android/internal/view/StandaloneActionMode;
.super Landroid/view/ActionMode;
.source "StandaloneActionMode.java"

# interfaces
.implements Lcom/android/internal/view/menu/MenuBuilder$Callback;


# instance fields
.field private mCallback:Landroid/view/ActionMode$Callback;

.field private mContext:Landroid/content/Context;

.field private mContextView:Lcom/android/internal/widget/ActionBarContextView;

.field private mCustomView:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private mFinished:Z

.field private mFocusable:Z

.field private mMenu:Lcom/android/internal/view/menu/MenuBuilder;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/android/internal/widget/ActionBarContextView;Landroid/view/ActionMode$Callback;Z)V
    .registers 7
    .parameter "context"
    .parameter "view"
    .parameter "callback"
    .parameter "isFocusable"

    .prologue
    .line 44
    invoke-direct {p0}, Landroid/view/ActionMode;-><init>()V

    .line 45
    iput-object p1, p0, Lcom/android/internal/view/StandaloneActionMode;->mContext:Landroid/content/Context;

    .line 46
    iput-object p2, p0, Lcom/android/internal/view/StandaloneActionMode;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    .line 47
    iput-object p3, p0, Lcom/android/internal/view/StandaloneActionMode;->mCallback:Landroid/view/ActionMode$Callback;

    .line 49
    new-instance v0, Lcom/android/internal/view/menu/MenuBuilder;

    invoke-direct {v0, p1}, Lcom/android/internal/view/menu/MenuBuilder;-><init>(Landroid/content/Context;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/android/internal/view/menu/MenuBuilder;->setDefaultShowAsAction(I)Lcom/android/internal/view/menu/MenuBuilder;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mMenu:Lcom/android/internal/view/menu/MenuBuilder;

    .line 50
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mMenu:Lcom/android/internal/view/menu/MenuBuilder;

    invoke-virtual {v0, p0}, Lcom/android/internal/view/menu/MenuBuilder;->setCallback(Lcom/android/internal/view/menu/MenuBuilder$Callback;)V

    .line 51
    iput-boolean p4, p0, Lcom/android/internal/view/StandaloneActionMode;->mFocusable:Z

    .line 52
    return-void
.end method


# virtual methods
.method public finish()V
    .registers 3

    .prologue
    .line 98
    iget-boolean v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mFinished:Z

    if-eqz v0, :cond_5

    .line 105
    :goto_4
    return-void

    .line 101
    :cond_5
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mFinished:Z

    .line 103
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/ActionBarContextView;->sendAccessibilityEvent(I)V

    .line 104
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mCallback:Landroid/view/ActionMode$Callback;

    invoke-interface {v0, p0}, Landroid/view/ActionMode$Callback;->onDestroyActionMode(Landroid/view/ActionMode;)V

    goto :goto_4
.end method

.method public getCustomView()Landroid/view/View;
    .registers 2

    .prologue
    .line 124
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mCustomView:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_d

    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mCustomView:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    :goto_c
    return-object v0

    :cond_d
    const/4 v0, 0x0

    goto :goto_c
.end method

.method public getMenu()Landroid/view/Menu;
    .registers 2

    .prologue
    .line 109
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mMenu:Lcom/android/internal/view/menu/MenuBuilder;

    return-object v0
.end method

.method public getMenuInflater()Landroid/view/MenuInflater;
    .registers 3

    .prologue
    .line 129
    new-instance v0, Landroid/view/MenuInflater;

    iget-object v1, p0, Lcom/android/internal/view/StandaloneActionMode;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/view/MenuInflater;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public getSubtitle()Ljava/lang/CharSequence;
    .registers 2

    .prologue
    .line 119
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarContextView;->getSubtitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .registers 2

    .prologue
    .line 114
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarContextView;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public invalidate()V
    .registers 3

    .prologue
    .line 93
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mCallback:Landroid/view/ActionMode$Callback;

    iget-object v1, p0, Lcom/android/internal/view/StandaloneActionMode;->mMenu:Lcom/android/internal/view/menu/MenuBuilder;

    invoke-interface {v0, p0, v1}, Landroid/view/ActionMode$Callback;->onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z

    .line 94
    return-void
.end method

.method public isTitleOptional()Z
    .registers 2

    .prologue
    .line 82
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarContextView;->isTitleOptional()Z

    move-result v0

    return v0
.end method

.method public isUiFocusable()Z
    .registers 2

    .prologue
    .line 157
    iget-boolean v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mFocusable:Z

    return v0
.end method

.method public onCloseMenu(Lcom/android/internal/view/menu/MenuBuilder;Z)V
    .registers 3
    .parameter "menu"
    .parameter "allMenusAreClosing"

    .prologue
    .line 137
    return-void
.end method

.method public onCloseSubMenu(Lcom/android/internal/view/menu/SubMenuBuilder;)V
    .registers 2
    .parameter "menu"

    .prologue
    .line 149
    return-void
.end method

.method public onMenuItemSelected(Lcom/android/internal/view/menu/MenuBuilder;Landroid/view/MenuItem;)Z
    .registers 4
    .parameter "menu"
    .parameter "item"

    .prologue
    .line 133
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mCallback:Landroid/view/ActionMode$Callback;

    invoke-interface {v0, p0, p2}, Landroid/view/ActionMode$Callback;->onActionItemClicked(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public onMenuModeChange(Lcom/android/internal/view/menu/MenuBuilder;)V
    .registers 3
    .parameter "menu"

    .prologue
    .line 152
    invoke-virtual {p0}, Lcom/android/internal/view/StandaloneActionMode;->invalidate()V

    .line 153
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarContextView;->showOverflowMenu()Z

    .line 154
    return-void
.end method

.method public onSubMenuSelected(Lcom/android/internal/view/menu/SubMenuBuilder;)Z
    .registers 5
    .parameter "subMenu"

    .prologue
    const/4 v2, 0x1

    .line 140
    invoke-virtual {p1}, Lcom/android/internal/view/menu/SubMenuBuilder;->hasVisibleItems()Z

    move-result v0

    if-nez v0, :cond_8

    .line 145
    :goto_7
    return v2

    .line 144
    :cond_8
    new-instance v0, Lcom/android/internal/view/menu/MenuPopupHelper;

    iget-object v1, p0, Lcom/android/internal/view/StandaloneActionMode;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, Lcom/android/internal/view/menu/MenuPopupHelper;-><init>(Landroid/content/Context;Lcom/android/internal/view/menu/MenuBuilder;)V

    invoke-virtual {v0}, Lcom/android/internal/view/menu/MenuPopupHelper;->show()V

    goto :goto_7
.end method

.method public setCustomView(Landroid/view/View;)V
    .registers 3
    .parameter "view"

    .prologue
    .line 87
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarContextView;->setCustomView(Landroid/view/View;)V

    .line 88
    if-eqz p1, :cond_f

    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    :goto_c
    iput-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mCustomView:Ljava/lang/ref/WeakReference;

    .line 89
    return-void

    .line 88
    :cond_f
    const/4 v0, 0x0

    goto :goto_c
.end method

.method public setSubtitle(I)V
    .registers 3
    .parameter "resId"

    .prologue
    .line 71
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mContext:Landroid/content/Context;

    invoke-virtual {v0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/internal/view/StandaloneActionMode;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 72
    return-void
.end method

.method public setSubtitle(Ljava/lang/CharSequence;)V
    .registers 3
    .parameter "subtitle"

    .prologue
    .line 61
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarContextView;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 62
    return-void
.end method

.method public setTitle(I)V
    .registers 3
    .parameter "resId"

    .prologue
    .line 66
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mContext:Landroid/content/Context;

    invoke-virtual {v0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/internal/view/StandaloneActionMode;->setTitle(Ljava/lang/CharSequence;)V

    .line 67
    return-void
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .registers 3
    .parameter "title"

    .prologue
    .line 56
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarContextView;->setTitle(Ljava/lang/CharSequence;)V

    .line 57
    return-void
.end method

.method public setTitleOptionalHint(Z)V
    .registers 3
    .parameter "titleOptional"

    .prologue
    .line 76
    invoke-super {p0, p1}, Landroid/view/ActionMode;->setTitleOptionalHint(Z)V

    .line 77
    iget-object v0, p0, Lcom/android/internal/view/StandaloneActionMode;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarContextView;->setTitleOptional(Z)V

    .line 78
    return-void
.end method
