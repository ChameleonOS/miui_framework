.class Landroid/widget/AdapterView$SelectionNotifier;
.super Ljava/lang/Object;
.source "AdapterView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/AdapterView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SelectionNotifier"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/AdapterView;


# direct methods
.method private constructor <init>(Landroid/widget/AdapterView;)V
    .registers 2
    .parameter

    .prologue
    .local p0, this:Landroid/widget/AdapterView$SelectionNotifier;,"Landroid/widget/AdapterView<TT;>.SelectionNotifier;"
    iput-object p1, p0, Landroid/widget/AdapterView$SelectionNotifier;->this$0:Landroid/widget/AdapterView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/widget/AdapterView;Landroid/widget/AdapterView$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .local p0, this:Landroid/widget/AdapterView$SelectionNotifier;,"Landroid/widget/AdapterView<TT;>.SelectionNotifier;"
    invoke-direct {p0, p1}, Landroid/widget/AdapterView$SelectionNotifier;-><init>(Landroid/widget/AdapterView;)V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 2

    .prologue
    .local p0, this:Landroid/widget/AdapterView$SelectionNotifier;,"Landroid/widget/AdapterView<TT;>.SelectionNotifier;"
    iget-object v0, p0, Landroid/widget/AdapterView$SelectionNotifier;->this$0:Landroid/widget/AdapterView;

    iget-boolean v0, v0, Landroid/widget/AdapterView;->mDataChanged:Z

    if-eqz v0, :cond_14

    iget-object v0, p0, Landroid/widget/AdapterView$SelectionNotifier;->this$0:Landroid/widget/AdapterView;

    invoke-virtual {v0}, Landroid/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v0

    if-eqz v0, :cond_13

    iget-object v0, p0, Landroid/widget/AdapterView$SelectionNotifier;->this$0:Landroid/widget/AdapterView;

    invoke-virtual {v0, p0}, Landroid/widget/AdapterView;->post(Ljava/lang/Runnable;)Z

    :cond_13
    :goto_13
    return-void

    :cond_14
    iget-object v0, p0, Landroid/widget/AdapterView$SelectionNotifier;->this$0:Landroid/widget/AdapterView;

    #calls: Landroid/widget/AdapterView;->fireOnSelected()V
    invoke-static {v0}, Landroid/widget/AdapterView;->access$200(Landroid/widget/AdapterView;)V

    iget-object v0, p0, Landroid/widget/AdapterView$SelectionNotifier;->this$0:Landroid/widget/AdapterView;

    #calls: Landroid/widget/AdapterView;->performAccessibilityActionsOnSelected()V
    invoke-static {v0}, Landroid/widget/AdapterView;->access$300(Landroid/widget/AdapterView;)V

    goto :goto_13
.end method
