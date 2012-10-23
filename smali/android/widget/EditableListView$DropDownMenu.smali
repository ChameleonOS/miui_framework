.class public Landroid/widget/EditableListView$DropDownMenu;
.super Ljava/lang/Object;
.source "EditableListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/EditableListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DropDownMenu"
.end annotation


# instance fields
.field private mButton:Landroid/widget/Button;

.field private mMenu:Landroid/view/Menu;

.field private mPopupMenu:Landroid/widget/PopupMenu;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/widget/Button;ILandroid/widget/PopupMenu$OnMenuItemClickListener;)V
    .registers 7
    .parameter "context"
    .parameter "button"
    .parameter "menuId"
    .parameter "listener"

    .prologue
    .line 378
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 379
    iput-object p2, p0, Landroid/widget/EditableListView$DropDownMenu;->mButton:Landroid/widget/Button;

    .line 380
    iget-object v0, p0, Landroid/widget/EditableListView$DropDownMenu;->mButton:Landroid/widget/Button;

    const v1, 0x602016b

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setBackgroundResource(I)V

    .line 381
    new-instance v0, Landroid/widget/PopupMenu;

    iget-object v1, p0, Landroid/widget/EditableListView$DropDownMenu;->mButton:Landroid/widget/Button;

    invoke-direct {v0, p1, v1}, Landroid/widget/PopupMenu;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v0, p0, Landroid/widget/EditableListView$DropDownMenu;->mPopupMenu:Landroid/widget/PopupMenu;

    .line 382
    iget-object v0, p0, Landroid/widget/EditableListView$DropDownMenu;->mPopupMenu:Landroid/widget/PopupMenu;

    invoke-virtual {v0}, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/EditableListView$DropDownMenu;->mMenu:Landroid/view/Menu;

    .line 383
    iget-object v0, p0, Landroid/widget/EditableListView$DropDownMenu;->mPopupMenu:Landroid/widget/PopupMenu;

    invoke-virtual {v0}, Landroid/widget/PopupMenu;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    iget-object v1, p0, Landroid/widget/EditableListView$DropDownMenu;->mMenu:Landroid/view/Menu;

    invoke-virtual {v0, p3, v1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 384
    iget-object v0, p0, Landroid/widget/EditableListView$DropDownMenu;->mPopupMenu:Landroid/widget/PopupMenu;

    invoke-virtual {v0, p4}, Landroid/widget/PopupMenu;->setOnMenuItemClickListener(Landroid/widget/PopupMenu$OnMenuItemClickListener;)V

    .line 385
    iget-object v0, p0, Landroid/widget/EditableListView$DropDownMenu;->mButton:Landroid/widget/Button;

    new-instance v1, Landroid/widget/EditableListView$DropDownMenu$1;

    invoke-direct {v1, p0}, Landroid/widget/EditableListView$DropDownMenu$1;-><init>(Landroid/widget/EditableListView$DropDownMenu;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 390
    return-void
.end method

.method static synthetic access$600(Landroid/widget/EditableListView$DropDownMenu;)Landroid/widget/PopupMenu;
    .registers 2
    .parameter "x0"

    .prologue
    .line 372
    iget-object v0, p0, Landroid/widget/EditableListView$DropDownMenu;->mPopupMenu:Landroid/widget/PopupMenu;

    return-object v0
.end method


# virtual methods
.method public findItem(I)Landroid/view/MenuItem;
    .registers 3
    .parameter "id"

    .prologue
    .line 393
    iget-object v0, p0, Landroid/widget/EditableListView$DropDownMenu;->mMenu:Landroid/view/Menu;

    invoke-interface {v0, p1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    return-object v0
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .registers 3
    .parameter "title"

    .prologue
    .line 397
    iget-object v0, p0, Landroid/widget/EditableListView$DropDownMenu;->mButton:Landroid/widget/Button;

    invoke-virtual {v0, p1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 398
    return-void
.end method
