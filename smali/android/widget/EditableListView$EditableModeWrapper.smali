.class Landroid/widget/EditableListView$EditableModeWrapper;
.super Landroid/widget/AbsListView$MultiChoiceModeWrapper;
.source "EditableListView.java"

# interfaces
.implements Landroid/widget/EditableListView$EditableListViewListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/EditableListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "EditableModeWrapper"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/EditableListView;


# direct methods
.method constructor <init>(Landroid/widget/EditableListView;)V
    .registers 2
    .parameter

    .prologue
    .line 234
    iput-object p1, p0, Landroid/widget/EditableListView$EditableModeWrapper;->this$0:Landroid/widget/EditableListView;

    invoke-direct {p0, p1}, Landroid/widget/AbsListView$MultiChoiceModeWrapper;-><init>(Landroid/widget/AbsListView;)V

    return-void
.end method

.method private handleCheckedStateChanged(Landroid/view/ActionMode;)V
    .registers 3
    .parameter "mode"

    .prologue
    .line 238
    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeWrapper;->this$0:Landroid/widget/EditableListView;

    #getter for: Landroid/widget/EditableListView;->mIsUpdateBatchChecked:Z
    invoke-static {v0}, Landroid/widget/EditableListView;->access$100(Landroid/widget/EditableListView;)Z

    move-result v0

    if-nez v0, :cond_10

    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeWrapper;->this$0:Landroid/widget/EditableListView;

    #getter for: Landroid/widget/EditableListView;->mKeepEditModeIfNoItemChecked:Z
    invoke-static {v0}, Landroid/widget/EditableListView;->access$200(Landroid/widget/EditableListView;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 246
    :cond_10
    :goto_10
    return-void

    .line 243
    :cond_11
    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeWrapper;->this$0:Landroid/widget/EditableListView;

    invoke-virtual {v0}, Landroid/widget/EditableListView;->getCheckedItemCount()I

    move-result v0

    if-nez v0, :cond_10

    .line 244
    invoke-virtual {p1}, Landroid/view/ActionMode;->finish()V

    goto :goto_10
.end method


# virtual methods
.method public onBatchCheckedStateChanged(Landroid/view/ActionMode;Z)V
    .registers 4
    .parameter "mode"
    .parameter "checked"

    .prologue
    .line 261
    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeWrapper;->this$0:Landroid/widget/EditableListView;

    #getter for: Landroid/widget/EditableListView;->mMultiChoiceModeListener:Landroid/widget/EditableListView$EditableListViewListener;
    invoke-static {v0}, Landroid/widget/EditableListView;->access$400(Landroid/widget/EditableListView;)Landroid/widget/EditableListView$EditableListViewListener;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Landroid/widget/EditableListView$EditableListViewListener;->onBatchCheckedStateChanged(Landroid/view/ActionMode;Z)V

    .line 262
    invoke-direct {p0, p1}, Landroid/widget/EditableListView$EditableModeWrapper;->handleCheckedStateChanged(Landroid/view/ActionMode;)V

    .line 263
    return-void
.end method

.method public onItemCheckedStateChanged(Landroid/view/ActionMode;IJZ)V
    .registers 12
    .parameter "mode"
    .parameter "position"
    .parameter "id"
    .parameter "checked"

    .prologue
    .line 251
    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeWrapper;->this$0:Landroid/widget/EditableListView;

    #calls: Landroid/widget/EditableListView;->isValidPos(I)Z
    invoke-static {v0, p2}, Landroid/widget/EditableListView;->access$300(Landroid/widget/EditableListView;I)Z

    move-result v0

    if-nez v0, :cond_9

    .line 257
    :goto_8
    return-void

    .line 254
    :cond_9
    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeWrapper;->this$0:Landroid/widget/EditableListView;

    #getter for: Landroid/widget/EditableListView;->mMultiChoiceModeListener:Landroid/widget/EditableListView$EditableListViewListener;
    invoke-static {v0}, Landroid/widget/EditableListView;->access$400(Landroid/widget/EditableListView;)Landroid/widget/EditableListView$EditableListViewListener;

    move-result-object v0

    move-object v1, p1

    move v2, p2

    move-wide v3, p3

    move v5, p5

    invoke-interface/range {v0 .. v5}, Landroid/widget/EditableListView$EditableListViewListener;->onItemCheckedStateChanged(Landroid/view/ActionMode;IJZ)V

    .line 255
    invoke-direct {p0, p1}, Landroid/widget/EditableListView$EditableModeWrapper;->handleCheckedStateChanged(Landroid/view/ActionMode;)V

    .line 256
    iget-object v0, p0, Landroid/widget/EditableListView$EditableModeWrapper;->this$0:Landroid/widget/EditableListView;

    #calls: Landroid/widget/EditableListView;->updateOnScreenCheckedViews()V
    invoke-static {v0}, Landroid/widget/EditableListView;->access$500(Landroid/widget/EditableListView;)V

    goto :goto_8
.end method
