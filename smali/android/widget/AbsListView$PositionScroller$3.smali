.class Landroid/widget/AbsListView$PositionScroller$3;
.super Ljava/lang/Object;
.source "AbsListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/AbsListView$PositionScroller;->startWithOffset(III)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/widget/AbsListView$PositionScroller;

.field final synthetic val$duration:I

.field final synthetic val$position:I

.field final synthetic val$postOffset:I


# direct methods
.method constructor <init>(Landroid/widget/AbsListView$PositionScroller;III)V
    .registers 5
    .parameter
    .parameter
    .parameter
    .parameter

    .prologue
    .line 4485
    iput-object p1, p0, Landroid/widget/AbsListView$PositionScroller$3;->this$1:Landroid/widget/AbsListView$PositionScroller;

    iput p2, p0, Landroid/widget/AbsListView$PositionScroller$3;->val$position:I

    iput p3, p0, Landroid/widget/AbsListView$PositionScroller$3;->val$postOffset:I

    iput p4, p0, Landroid/widget/AbsListView$PositionScroller$3;->val$duration:I

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 5

    .prologue
    .line 4487
    iget-object v0, p0, Landroid/widget/AbsListView$PositionScroller$3;->this$1:Landroid/widget/AbsListView$PositionScroller;

    iget v1, p0, Landroid/widget/AbsListView$PositionScroller$3;->val$position:I

    iget v2, p0, Landroid/widget/AbsListView$PositionScroller$3;->val$postOffset:I

    iget v3, p0, Landroid/widget/AbsListView$PositionScroller$3;->val$duration:I

    invoke-virtual {v0, v1, v2, v3}, Landroid/widget/AbsListView$PositionScroller;->startWithOffset(III)V

    .line 4488
    return-void
.end method
