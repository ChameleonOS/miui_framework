.class Landroid/widget/GridLayout$6$1;
.super Landroid/widget/GridLayout$Bounds;
.source "GridLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/GridLayout$6;->getBounds()Landroid/widget/GridLayout$Bounds;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private size:I

.field final synthetic this$0:Landroid/widget/GridLayout$6;


# direct methods
.method constructor <init>(Landroid/widget/GridLayout$6;)V
    .registers 3
    .parameter

    .prologue
    .line 2669
    iput-object p1, p0, Landroid/widget/GridLayout$6$1;->this$0:Landroid/widget/GridLayout$6;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/widget/GridLayout$Bounds;-><init>(Landroid/widget/GridLayout$1;)V

    return-void
.end method


# virtual methods
.method protected getOffset(Landroid/widget/GridLayout;Landroid/view/View;Landroid/widget/GridLayout$Alignment;IZ)I
    .registers 8
    .parameter "gl"
    .parameter "c"
    .parameter "a"
    .parameter "size"
    .parameter "hrz"

    .prologue
    .line 2697
    const/4 v0, 0x0

    invoke-super/range {p0 .. p5}, Landroid/widget/GridLayout$Bounds;->getOffset(Landroid/widget/GridLayout;Landroid/view/View;Landroid/widget/GridLayout$Alignment;IZ)I

    move-result v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method

.method protected include(II)V
    .registers 5
    .parameter "before"
    .parameter "after"

    .prologue
    .line 2686
    invoke-super {p0, p1, p2}, Landroid/widget/GridLayout$Bounds;->include(II)V

    .line 2687
    iget v0, p0, Landroid/widget/GridLayout$6$1;->size:I

    add-int v1, p1, p2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Landroid/widget/GridLayout$6$1;->size:I

    .line 2688
    return-void
.end method

.method protected reset()V
    .registers 2

    .prologue
    .line 2680
    invoke-super {p0}, Landroid/widget/GridLayout$Bounds;->reset()V

    .line 2681
    const/high16 v0, -0x8000

    iput v0, p0, Landroid/widget/GridLayout$6$1;->size:I

    .line 2682
    return-void
.end method

.method protected size(Z)I
    .registers 4
    .parameter "min"

    .prologue
    .line 2692
    invoke-super {p0, p1}, Landroid/widget/GridLayout$Bounds;->size(Z)I

    move-result v0

    iget v1, p0, Landroid/widget/GridLayout$6$1;->size:I

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    return v0
.end method
