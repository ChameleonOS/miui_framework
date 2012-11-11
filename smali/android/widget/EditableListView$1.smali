.class Landroid/widget/EditableListView$1;
.super Ljava/lang/Object;
.source "EditableListView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/EditableListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/EditableListView;


# direct methods
.method constructor <init>(Landroid/widget/EditableListView;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/EditableListView$1;->this$0:Landroid/widget/EditableListView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
    .registers 7
    .parameter
    .parameter "view"
    .parameter "position"
    .parameter "id"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .local p1, parent:Landroid/widget/AdapterView;,"Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Landroid/widget/EditableListView$1;->this$0:Landroid/widget/EditableListView;

    #calls: Landroid/widget/EditableListView;->enterEditModeInner()V
    invoke-static {v0}, Landroid/widget/EditableListView;->access$000(Landroid/widget/EditableListView;)V

    const/4 v0, 0x1

    return v0
.end method
