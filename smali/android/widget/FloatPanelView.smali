.class public Landroid/widget/FloatPanelView;
.super Landroid/widget/FrameLayout;
.source "FloatPanelView.java"


# instance fields
.field private mBottomOffset:I

.field private mIsArrowUp:Z

.field private mPos:I

.field private mTopOffset:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    .line 19
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 20
    invoke-direct {p0, p1}, Landroid/widget/FloatPanelView;->initArrowOffset(Landroid/content/Context;)V

    .line 21
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 3
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 24
    invoke-direct {p0, p1}, Landroid/widget/FloatPanelView;->initArrowOffset(Landroid/content/Context;)V

    .line 25
    return-void
.end method

.method private initArrowOffset(Landroid/content/Context;)V
    .registers 4
    .parameter "context"

    .prologue
    .line 28
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x60a0027

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    float-to-int v0, v0

    iput v0, p0, Landroid/widget/FloatPanelView;->mTopOffset:I

    .line 29
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x60a0028

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v0

    float-to-int v0, v0

    iput v0, p0, Landroid/widget/FloatPanelView;->mBottomOffset:I

    .line 30
    return-void
.end method


# virtual methods
.method protected onLayout(ZIIII)V
    .registers 15
    .parameter "changed"
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    const/16 v8, 0x8

    const/4 v6, 0x0

    .line 48
    invoke-super/range {p0 .. p5}, Landroid/widget/FrameLayout;->onLayout(ZIIII)V

    .line 49
    const v7, 0x60b001f

    invoke-virtual {p0, v7}, Landroid/widget/FloatPanelView;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 50
    .local v5, upArrow:Landroid/view/View;
    const v7, 0x60b0020

    invoke-virtual {p0, v7}, Landroid/widget/FloatPanelView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 51
    .local v1, downArrow:Landroid/view/View;
    const v7, 0x60b001b

    invoke-virtual {p0, v7}, Landroid/widget/FloatPanelView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 52
    .local v3, panel:Landroid/widget/LinearLayout;
    if-eqz v5, :cond_23

    if-eqz v1, :cond_23

    if-nez v3, :cond_2b

    .line 53
    :cond_23
    const-string v6, "FloatPanelView"

    const-string v7, "couldn\'t find view"

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 71
    :goto_2a
    return-void

    .line 57
    :cond_2b
    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    .line 58
    invoke-virtual {v1, v8}, Landroid/view/View;->setVisibility(I)V

    .line 59
    iget-boolean v7, p0, Landroid/widget/FloatPanelView;->mIsArrowUp:Z

    if-eqz v7, :cond_7a

    move-object v0, v5

    .line 60
    .local v0, arrow:Landroid/view/View;
    :goto_36
    iget-boolean v7, p0, Landroid/widget/FloatPanelView;->mIsArrowUp:Z

    if-eqz v7, :cond_7c

    move v4, v6

    .line 61
    .local v4, t:I
    :goto_3b
    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 62
    iget v7, p0, Landroid/widget/FloatPanelView;->mPos:I

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v8

    div-int/lit8 v8, v8, 0x2

    sub-int v2, v7, v8

    .line 63
    .local v2, l:I
    if-gez v2, :cond_85

    .line 64
    const/4 v2, 0x0

    .line 67
    :cond_4b
    :goto_4b
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    add-int/2addr v7, v2

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v8

    add-int/2addr v8, v4

    invoke-virtual {v0, v2, v4, v7, v8}, Landroid/view/View;->layout(IIII)V

    .line 69
    iget-boolean v7, p0, Landroid/widget/FloatPanelView;->mIsArrowUp:Z

    if-eqz v7, :cond_94

    invoke-virtual {v5}, Landroid/view/View;->getHeight()I

    move-result v6

    iget v7, p0, Landroid/widget/FloatPanelView;->mTopOffset:I

    sub-int v4, v6, v7

    .line 70
    :goto_64
    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getLeft()I

    move-result v6

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getLeft()I

    move-result v7

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getMeasuredWidth()I

    move-result v8

    add-int/2addr v7, v8

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getMeasuredHeight()I

    move-result v8

    add-int/2addr v8, v4

    invoke-virtual {v3, v6, v4, v7, v8}, Landroid/widget/LinearLayout;->layout(IIII)V

    goto :goto_2a

    .end local v0           #arrow:Landroid/view/View;
    .end local v2           #l:I
    .end local v4           #t:I
    :cond_7a
    move-object v0, v1

    .line 59
    goto :goto_36

    .line 60
    .restart local v0       #arrow:Landroid/view/View;
    :cond_7c
    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getMeasuredHeight()I

    move-result v7

    iget v8, p0, Landroid/widget/FloatPanelView;->mBottomOffset:I

    sub-int v4, v7, v8

    goto :goto_3b

    .line 65
    .restart local v2       #l:I
    .restart local v4       #t:I
    :cond_85
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    sub-int v7, p4, v7

    if-le v2, v7, :cond_4b

    .line 66
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    sub-int v2, p4, v7

    goto :goto_4b

    :cond_94
    move v4, v6

    .line 69
    goto :goto_64
.end method

.method public setArrow(Z)V
    .registers 3
    .parameter "isUp"

    .prologue
    .line 33
    iget-boolean v0, p0, Landroid/widget/FloatPanelView;->mIsArrowUp:Z

    if-eq p1, v0, :cond_9

    .line 34
    iput-boolean p1, p0, Landroid/widget/FloatPanelView;->mIsArrowUp:Z

    .line 35
    invoke-virtual {p0}, Landroid/widget/FloatPanelView;->requestLayout()V

    .line 37
    :cond_9
    return-void
.end method

.method public setArrowPos(I)V
    .registers 3
    .parameter "pos"

    .prologue
    .line 41
    iget v0, p0, Landroid/widget/FloatPanelView;->mPos:I

    if-eq p1, v0, :cond_9

    .line 42
    iput p1, p0, Landroid/widget/FloatPanelView;->mPos:I

    .line 43
    invoke-virtual {p0}, Landroid/widget/FloatPanelView;->requestLayout()V

    .line 45
    :cond_9
    return-void
.end method
