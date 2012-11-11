.class public Landroid/widget/EditableListView$EditableModeCallback;
.super Ljava/lang/Object;
.source "EditableListView.java"

# interfaces
.implements Landroid/widget/EditableListView$EditableListViewListener;
.implements Landroid/widget/PopupMenu$OnMenuItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/EditableListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditableModeCallback"
.end annotation


# instance fields
.field private mActionBarMenuId:I

.field private mActivity:Landroid/app/Activity;

.field private mEditableListView:Landroid/widget/EditableListView;

.field private mSelectionMenu:Landroid/widget/EditableListView$DropDownMenu;

.field private mSplitActionBarMenuId:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;Landroid/widget/EditableListView;)V
    .registers 4
    .parameter "activity"
    .parameter "editableListView"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/high16 v0, 0x60e

    iput v0, p0, Landroid/widget/EditableListView$EditableModeCallback;->mActionBarMenuId:I

    const v0, 0x60e0001

    iput v0, p0, Landroid/widget/EditableListView$EditableModeCallback;->mSplitActionBarMenuId:I

    iput-object p1, p0, Landroid/widget/EditableListView$EditableModeCallback;->mActivity:Landroid/app/Activity;

    iput-object p2, p0, Landroid/widget/EditableListView$EditableModeCallback;->mEditableListView:Landroid/widget/EditableListView;

    return-void
.end method

.method private updateSelectionMenu()V
    .registers 5

    .prologue
    iget-object v2, p0, Landroid/widget/EditableListView$EditableModeCallback;->mEditableListView:Landroid/widget/EditableListView;

    invoke-virtual {v2}, Landroid/widget/EditableListView;->getCheckedItemCount()I

    move-result v2

    invoke-virtual {p0, v2}, Landroid/widget/EditableListView$EditableModeCallback;->getTitle(I)Ljava/lang/String;

    move-result-object v1

    .local v1, title:Ljava/lang/String;
    iget-object v2, p0, Landroid/widget/EditableListView$EditableModeCallback;->mSelectionMenu:Landroid/widget/EditableListView$DropDownMenu;

    invoke-virtual {v2, v1}, Landroid/widget/EditableListView$DropDownMenu;->setTitle(Ljava/lang/CharSequence;)V

    iget-object v2, p0, Landroid/widget/EditableListView$EditableModeCallback;->mSelectionMenu:Landroid/widget/EditableListView$DropDownMenu;

    const v3, 0x60b0025

    invoke-virtual {v2, v3}, Landroid/widget/EditableListView$DropDownMenu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .local v0, item:Landroid/view/MenuItem;
    if-eqz v0, :cond_28

    iget-object v2, p0, Landroid/widget/EditableListView$EditableModeCallback;->mEditableListView:Landroid/widget/EditableListView;

    invoke-virtual {v2}, Landroid/widget/EditableListView;->isAllChecked()Z

    move-result v2

    if-eqz v2, :cond_29

    const v2, 0x60c0178

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    :cond_28
    :goto_28
    return-void

    :cond_29
    const v2, 0x60c0177

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    goto :goto_28
.end method


# virtual methods
.method public getTitle(I)Ljava/lang/String;
    .registers 7
    .parameter "count"

    .prologue
    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeCallback;->mActivity:Landroid/app/Activity;

    const v1, 0x60c0179

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onActionItemClicked(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z
    .registers 4
    .parameter "mode"
    .parameter "item"

    .prologue
    invoke-interface {p2}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_e

    :goto_7
    const/4 v0, 0x1

    return v0

    :pswitch_9
    invoke-virtual {p1}, Landroid/view/ActionMode;->finish()V

    goto :goto_7

    nop

    :pswitch_data_e
    .packed-switch 0x60b0024
        :pswitch_9
    .end packed-switch
.end method

.method public onBatchCheckedStateChanged(Landroid/view/ActionMode;Z)V
    .registers 3
    .parameter "mode"
    .parameter "checked"

    .prologue
    invoke-direct {p0}, Landroid/widget/EditableListView$EditableModeCallback;->updateSelectionMenu()V

    return-void
.end method

.method public onCreateActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .registers 9
    .parameter "mode"
    .parameter "menu"

    .prologue
    iget-object v2, p0, Landroid/widget/EditableListView$EditableModeCallback;->mActivity:Landroid/app/Activity;

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    const v3, 0x603001e

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .local v0, customView:Landroid/view/View;
    invoke-virtual {p1, v0}, Landroid/view/ActionMode;->setCustomView(Landroid/view/View;)V

    new-instance v3, Landroid/widget/EditableListView$DropDownMenu;

    iget-object v4, p0, Landroid/widget/EditableListView$EditableModeCallback;->mActivity:Landroid/app/Activity;

    const v2, 0x60b0002

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iget v5, p0, Landroid/widget/EditableListView$EditableModeCallback;->mActionBarMenuId:I

    invoke-direct {v3, v4, v2, v5, p0}, Landroid/widget/EditableListView$DropDownMenu;-><init>(Landroid/content/Context;Landroid/widget/Button;ILandroid/widget/PopupMenu$OnMenuItemClickListener;)V

    iput-object v3, p0, Landroid/widget/EditableListView$EditableModeCallback;->mSelectionMenu:Landroid/widget/EditableListView$DropDownMenu;

    iget-object v2, p0, Landroid/widget/EditableListView$EditableModeCallback;->mActivity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v1

    .local v1, inflater:Landroid/view/MenuInflater;
    iget v2, p0, Landroid/widget/EditableListView$EditableModeCallback;->mSplitActionBarMenuId:I

    invoke-virtual {v1, v2, p2}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    const/4 v2, 0x1

    return v2
.end method

.method public onDestroyActionMode(Landroid/view/ActionMode;)V
    .registers 3
    .parameter "mode"

    .prologue
    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeCallback;->mSelectionMenu:Landroid/widget/EditableListView$DropDownMenu;

    #getter for: Landroid/widget/EditableListView$DropDownMenu;->mPopupMenu:Landroid/widget/PopupMenu;
    invoke-static {v0}, Landroid/widget/EditableListView$DropDownMenu;->access$600(Landroid/widget/EditableListView$DropDownMenu;)Landroid/widget/PopupMenu;

    move-result-object v0

    if-eqz v0, :cond_11

    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeCallback;->mSelectionMenu:Landroid/widget/EditableListView$DropDownMenu;

    #getter for: Landroid/widget/EditableListView$DropDownMenu;->mPopupMenu:Landroid/widget/PopupMenu;
    invoke-static {v0}, Landroid/widget/EditableListView$DropDownMenu;->access$600(Landroid/widget/EditableListView$DropDownMenu;)Landroid/widget/PopupMenu;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/PopupMenu;->dismiss()V

    :cond_11
    return-void
.end method

.method public onItemCheckedStateChanged(Landroid/view/ActionMode;IJZ)V
    .registers 6
    .parameter "mode"
    .parameter "position"
    .parameter "id"
    .parameter "checked"

    .prologue
    invoke-direct {p0}, Landroid/widget/EditableListView$EditableModeCallback;->updateSelectionMenu()V

    return-void
.end method

.method public onMenuItemClick(Landroid/view/MenuItem;)Z
    .registers 3
    .parameter "item"

    .prologue
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_1e

    :goto_7
    const/4 v0, 0x1

    return v0

    :pswitch_9
    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeCallback;->mEditableListView:Landroid/widget/EditableListView;

    invoke-virtual {v0}, Landroid/widget/EditableListView;->isAllChecked()Z

    move-result v0

    if-eqz v0, :cond_17

    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeCallback;->mEditableListView:Landroid/widget/EditableListView;

    invoke-virtual {v0}, Landroid/widget/EditableListView;->checkNothing()V

    goto :goto_7

    :cond_17
    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeCallback;->mEditableListView:Landroid/widget/EditableListView;

    invoke-virtual {v0}, Landroid/widget/EditableListView;->checkAll()V

    goto :goto_7

    nop

    :pswitch_data_1e
    .packed-switch 0x60b0025
        :pswitch_9
    .end packed-switch
.end method

.method public onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .registers 4
    .parameter "mode"
    .parameter "menu"

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public setActionBarMenuId(I)V
    .registers 2
    .parameter "actionBarMenuId"

    .prologue
    iput p1, p0, Landroid/widget/EditableListView$EditableModeCallback;->mActionBarMenuId:I

    return-void
.end method

.method public setSplitActionBarMenuId(I)V
    .registers 2
    .parameter "splitActionBarMenuId"

    .prologue
    iput p1, p0, Landroid/widget/EditableListView$EditableModeCallback;->mSplitActionBarMenuId:I

    return-void
.end method
