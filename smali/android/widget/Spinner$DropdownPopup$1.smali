.class Landroid/widget/Spinner$DropdownPopup$1;
.super Ljava/lang/Object;
.source "Spinner.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/Spinner$DropdownPopup;-><init>(Landroid/widget/Spinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/widget/Spinner$DropdownPopup;

.field final synthetic val$this$0:Landroid/widget/Spinner;


# direct methods
.method constructor <init>(Landroid/widget/Spinner$DropdownPopup;Landroid/widget/Spinner;)V
    .registers 3
    .parameter
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/Spinner$DropdownPopup$1;->this$1:Landroid/widget/Spinner$DropdownPopup;

    iput-object p2, p0, Landroid/widget/Spinner$DropdownPopup$1;->val$this$0:Landroid/widget/Spinner;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .registers 9
    .parameter "parent"
    .parameter "v"
    .parameter "position"
    .parameter "id"

    .prologue
    iget-object v0, p0, Landroid/widget/Spinner$DropdownPopup$1;->this$1:Landroid/widget/Spinner$DropdownPopup;

    iget-object v0, v0, Landroid/widget/Spinner$DropdownPopup;->this$0:Landroid/widget/Spinner;

    invoke-virtual {v0, p3}, Landroid/widget/Spinner;->setSelection(I)V

    iget-object v0, p0, Landroid/widget/Spinner$DropdownPopup$1;->this$1:Landroid/widget/Spinner$DropdownPopup;

    iget-object v0, v0, Landroid/widget/Spinner$DropdownPopup;->this$0:Landroid/widget/Spinner;

    iget-object v0, v0, Landroid/widget/AdapterView;->mOnItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    if-eqz v0, :cond_20

    iget-object v0, p0, Landroid/widget/Spinner$DropdownPopup$1;->this$1:Landroid/widget/Spinner$DropdownPopup;

    iget-object v0, v0, Landroid/widget/Spinner$DropdownPopup;->this$0:Landroid/widget/Spinner;

    iget-object v1, p0, Landroid/widget/Spinner$DropdownPopup$1;->this$1:Landroid/widget/Spinner$DropdownPopup;

    #getter for: Landroid/widget/Spinner$DropdownPopup;->mAdapter:Landroid/widget/ListAdapter;
    invoke-static {v1}, Landroid/widget/Spinner$DropdownPopup;->access$100(Landroid/widget/Spinner$DropdownPopup;)Landroid/widget/ListAdapter;

    move-result-object v1

    invoke-interface {v1, p3}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v1

    invoke-virtual {v0, p2, p3, v1, v2}, Landroid/widget/Spinner;->performItemClick(Landroid/view/View;IJ)Z

    :cond_20
    iget-object v0, p0, Landroid/widget/Spinner$DropdownPopup$1;->this$1:Landroid/widget/Spinner$DropdownPopup;

    invoke-virtual {v0}, Landroid/widget/Spinner$DropdownPopup;->dismiss()V

    return-void
.end method
