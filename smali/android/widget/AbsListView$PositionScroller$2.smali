.class Landroid/widget/AbsListView$PositionScroller$2;
.super Ljava/lang/Object;
.source "AbsListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/AbsListView$PositionScroller;->start(II)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/widget/AbsListView$PositionScroller;

.field final synthetic val$boundPosition:I

.field final synthetic val$position:I


# direct methods
.method constructor <init>(Landroid/widget/AbsListView$PositionScroller;II)V
    .registers 4
    .parameter
    .parameter
    .parameter

    .prologue
    .line 4395
    iput-object p1, p0, Landroid/widget/AbsListView$PositionScroller$2;->this$1:Landroid/widget/AbsListView$PositionScroller;

    iput p2, p0, Landroid/widget/AbsListView$PositionScroller$2;->val$position:I

    iput p3, p0, Landroid/widget/AbsListView$PositionScroller$2;->val$boundPosition:I

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 4

    .prologue
    .line 4397
    iget-object v0, p0, Landroid/widget/AbsListView$PositionScroller$2;->this$1:Landroid/widget/AbsListView$PositionScroller;

    iget v1, p0, Landroid/widget/AbsListView$PositionScroller$2;->val$position:I

    iget v2, p0, Landroid/widget/AbsListView$PositionScroller$2;->val$boundPosition:I

    invoke-virtual {v0, v1, v2}, Landroid/widget/AbsListView$PositionScroller;->start(II)V

    .line 4398
    return-void
.end method
