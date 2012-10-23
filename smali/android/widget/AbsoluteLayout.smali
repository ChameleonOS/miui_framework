.class public Landroid/widget/AbsoluteLayout;
.super Landroid/view/ViewGroup;
.source "AbsoluteLayout.java"


# annotations
.annotation runtime Landroid/widget/RemoteViews$RemoteView;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/AbsoluteLayout$LayoutParams;
    }
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    .line 43
    invoke-direct {p0, p1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V

    .line 44
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 3
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 47
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 48
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 4
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    .line 52
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 53
    return-void
.end method


# virtual methods
.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .registers 3
    .parameter "p"

    .prologue
    .line 136
    instance-of v0, p1, Landroid/widget/AbsoluteLayout$LayoutParams;

    return v0
.end method

.method protected generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .registers 4

    .prologue
    const/4 v2, 0x0

    const/4 v1, -0x2

    .line 103
    new-instance v0, Landroid/widget/AbsoluteLayout$LayoutParams;

    invoke-direct {v0, v1, v1, v2, v2}, Landroid/widget/AbsoluteLayout$LayoutParams;-><init>(IIII)V

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .registers 4
    .parameter "attrs"

    .prologue
    .line 130
    new-instance v0, Landroid/widget/AbsoluteLayout$LayoutParams;

    invoke-virtual {p0}, Landroid/widget/AbsoluteLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Landroid/widget/AbsoluteLayout$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .registers 3
    .parameter "p"

    .prologue
    .line 141
    new-instance v0, Landroid/widget/AbsoluteLayout$LayoutParams;

    invoke-direct {v0, p1}, Landroid/widget/AbsoluteLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    return-object v0
.end method

.method protected onLayout(ZIIII)V
    .registers 14
    .parameter "changed"
    .parameter "l"
    .parameter "t"
    .parameter "r"
    .parameter "b"

    .prologue
    .line 109
    invoke-virtual {p0}, Landroid/widget/AbsoluteLayout;->getChildCount()I

    move-result v3

    .line 111
    .local v3, count:I
    const/4 v4, 0x0

    .local v4, i:I
    :goto_5
    if-ge v4, v3, :cond_35

    .line 112
    invoke-virtual {p0, v4}, Landroid/widget/AbsoluteLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 113
    .local v0, child:Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v6

    const/16 v7, 0x8

    if-eq v6, v7, :cond_32

    .line 115
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v5

    check-cast v5, Landroid/widget/AbsoluteLayout$LayoutParams;

    .line 118
    .local v5, lp:Landroid/widget/AbsoluteLayout$LayoutParams;
    iget v6, p0, Landroid/view/View;->mPaddingLeft:I

    iget v7, v5, Landroid/widget/AbsoluteLayout$LayoutParams;->x:I

    add-int v1, v6, v7

    .line 119
    .local v1, childLeft:I
    iget v6, p0, Landroid/view/View;->mPaddingTop:I

    iget v7, v5, Landroid/widget/AbsoluteLayout$LayoutParams;->y:I

    add-int v2, v6, v7

    .line 120
    .local v2, childTop:I
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v6

    add-int/2addr v6, v1

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v7

    add-int/2addr v7, v2

    invoke-virtual {v0, v1, v2, v6, v7}, Landroid/view/View;->layout(IIII)V

    .line 111
    .end local v1           #childLeft:I
    .end local v2           #childTop:I
    .end local v5           #lp:Landroid/widget/AbsoluteLayout$LayoutParams;
    :cond_32
    add-int/lit8 v4, v4, 0x1

    goto :goto_5

    .line 126
    .end local v0           #child:Landroid/view/View;
    :cond_35
    return-void
.end method

.method protected onMeasure(II)V
    .registers 14
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    const/4 v10, 0x0

    .line 57
    invoke-virtual {p0}, Landroid/widget/AbsoluteLayout;->getChildCount()I

    move-result v3

    .line 59
    .local v3, count:I
    const/4 v6, 0x0

    .line 60
    .local v6, maxHeight:I
    const/4 v7, 0x0

    .line 63
    .local v7, maxWidth:I
    invoke-virtual {p0, p1, p2}, Landroid/widget/AbsoluteLayout;->measureChildren(II)V

    .line 66
    const/4 v4, 0x0

    .local v4, i:I
    :goto_b
    if-ge v4, v3, :cond_3a

    .line 67
    invoke-virtual {p0, v4}, Landroid/widget/AbsoluteLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 68
    .local v0, child:Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v8

    const/16 v9, 0x8

    if-eq v8, v9, :cond_37

    .line 72
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v5

    check-cast v5, Landroid/widget/AbsoluteLayout$LayoutParams;

    .line 75
    .local v5, lp:Landroid/widget/AbsoluteLayout$LayoutParams;
    iget v8, v5, Landroid/widget/AbsoluteLayout$LayoutParams;->x:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v9

    add-int v2, v8, v9

    .line 76
    .local v2, childRight:I
    iget v8, v5, Landroid/widget/AbsoluteLayout$LayoutParams;->y:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v9

    add-int v1, v8, v9

    .line 78
    .local v1, childBottom:I
    invoke-static {v7, v2}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 79
    invoke-static {v6, v1}, Ljava/lang/Math;->max(II)I

    move-result v6

    .line 66
    .end local v1           #childBottom:I
    .end local v2           #childRight:I
    .end local v5           #lp:Landroid/widget/AbsoluteLayout$LayoutParams;
    :cond_37
    add-int/lit8 v4, v4, 0x1

    goto :goto_b

    .line 84
    .end local v0           #child:Landroid/view/View;
    :cond_3a
    iget v8, p0, Landroid/view/View;->mPaddingLeft:I

    iget v9, p0, Landroid/view/View;->mPaddingRight:I

    add-int/2addr v8, v9

    add-int/2addr v7, v8

    .line 85
    iget v8, p0, Landroid/view/View;->mPaddingTop:I

    iget v9, p0, Landroid/view/View;->mPaddingBottom:I

    add-int/2addr v8, v9

    add-int/2addr v6, v8

    .line 88
    invoke-virtual {p0}, Landroid/widget/AbsoluteLayout;->getSuggestedMinimumHeight()I

    move-result v8

    invoke-static {v6, v8}, Ljava/lang/Math;->max(II)I

    move-result v6

    .line 89
    invoke-virtual {p0}, Landroid/widget/AbsoluteLayout;->getSuggestedMinimumWidth()I

    move-result v8

    invoke-static {v7, v8}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 91
    invoke-static {v7, p1, v10}, Landroid/widget/AbsoluteLayout;->resolveSizeAndState(III)I

    move-result v8

    invoke-static {v6, p2, v10}, Landroid/widget/AbsoluteLayout;->resolveSizeAndState(III)I

    move-result v9

    invoke-virtual {p0, v8, v9}, Landroid/widget/AbsoluteLayout;->setMeasuredDimension(II)V

    .line 93
    return-void
.end method

.method public shouldDelayChildPressedState()Z
    .registers 2

    .prologue
    .line 146
    const/4 v0, 0x0

    return v0
.end method
