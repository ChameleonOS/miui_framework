.class final Landroid/widget/GridLayout$6;
.super Landroid/widget/GridLayout$Alignment;
.source "GridLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/GridLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 2648
    invoke-direct {p0}, Landroid/widget/GridLayout$Alignment;-><init>()V

    return-void
.end method


# virtual methods
.method public getAlignmentValue(Landroid/view/View;II)I
    .registers 6
    .parameter "view"
    .parameter "viewSize"
    .parameter "mode"

    .prologue
    .line 2656
    invoke-virtual {p1}, Landroid/view/View;->getBaseline()I

    move-result v0

    .line 2657
    .local v0, baseline:I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_a

    .line 2658
    const/high16 v0, -0x8000

    .line 2663
    .end local v0           #baseline:I
    :cond_9
    :goto_9
    return v0

    .line 2660
    .restart local v0       #baseline:I
    :cond_a
    const/4 v1, 0x1

    if-ne p3, v1, :cond_9

    .line 2661
    invoke-virtual {p1}, Landroid/view/View;->getOpticalInsets()Landroid/graphics/Insets;

    move-result-object v1

    iget v1, v1, Landroid/graphics/Insets;->top:I

    sub-int/2addr v0, v1

    goto :goto_9
.end method

.method public getBounds()Landroid/widget/GridLayout$Bounds;
    .registers 2

    .prologue
    .line 2669
    new-instance v0, Landroid/widget/GridLayout$6$1;

    invoke-direct {v0, p0}, Landroid/widget/GridLayout$6$1;-><init>(Landroid/widget/GridLayout$6;)V

    return-object v0
.end method

.method getGravityOffset(Landroid/view/View;I)I
    .registers 4
    .parameter "view"
    .parameter "cellDelta"

    .prologue
    .line 2651
    const/4 v0, 0x0

    return v0
.end method
