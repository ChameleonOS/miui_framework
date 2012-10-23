.class Landroid/widget/EditableListView$DropDownMenu$1;
.super Ljava/lang/Object;
.source "EditableListView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/EditableListView$DropDownMenu;-><init>(Landroid/content/Context;Landroid/widget/Button;ILandroid/widget/PopupMenu$OnMenuItemClickListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/EditableListView$DropDownMenu;


# direct methods
.method constructor <init>(Landroid/widget/EditableListView$DropDownMenu;)V
    .registers 2
    .parameter

    .prologue
    .line 385
    iput-object p1, p0, Landroid/widget/EditableListView$DropDownMenu$1;->this$0:Landroid/widget/EditableListView$DropDownMenu;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .registers 3
    .parameter "v"

    .prologue
    .line 387
    iget-object v0, p0, Landroid/widget/EditableListView$DropDownMenu$1;->this$0:Landroid/widget/EditableListView$DropDownMenu;

    #getter for: Landroid/widget/EditableListView$DropDownMenu;->mPopupMenu:Landroid/widget/PopupMenu;
    invoke-static {v0}, Landroid/widget/EditableListView$DropDownMenu;->access$600(Landroid/widget/EditableListView$DropDownMenu;)Landroid/widget/PopupMenu;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/PopupMenu;->show()V

    .line 388
    return-void
.end method
