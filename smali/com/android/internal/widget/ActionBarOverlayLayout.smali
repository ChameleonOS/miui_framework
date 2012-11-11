.class public Lcom/android/internal/widget/ActionBarOverlayLayout;
.super Landroid/widget/FrameLayout;
.source "ActionBarOverlayLayout.java"


# static fields
.field static final mActionBarSizeAttr:[I


# instance fields
.field private mActionBar:Lcom/android/internal/app/ActionBarImpl;

.field private mActionBarBottom:Landroid/view/View;

.field private mActionBarHeight:I

.field private mActionBarTop:Landroid/view/View;

.field private mActionView:Lcom/android/internal/widget/ActionBarView;

.field private mContainerView:Lcom/android/internal/widget/ActionBarContainer;

.field private mContent:Landroid/view/View;

.field private mLastSystemUiVisibility:I

.field private mWindowVisibility:I

.field private final mZeroRect:Landroid/graphics/Rect;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x10102eb

    aput v2, v0, v1

    sput-object v0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarSizeAttr:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 4
    .parameter "context"

    .prologue
    const/4 v1, 0x0

    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput v1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mWindowVisibility:I

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0, v1, v1, v1, v1}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mZeroRect:Landroid/graphics/Rect;

    invoke-direct {p0, p1}, Lcom/android/internal/widget/ActionBarOverlayLayout;->init(Landroid/content/Context;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 5
    .parameter "context"
    .parameter "attrs"

    .prologue
    const/4 v1, 0x0

    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput v1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mWindowVisibility:I

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0, v1, v1, v1, v1}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mZeroRect:Landroid/graphics/Rect;

    invoke-direct {p0, p1}, Lcom/android/internal/widget/ActionBarOverlayLayout;->init(Landroid/content/Context;)V

    return-void
.end method

.method private applyInsets(Landroid/view/View;Landroid/graphics/Rect;ZZZZ)Z
    .registers 11
    .parameter "view"
    .parameter "insets"
    .parameter "left"
    .parameter "top"
    .parameter "bottom"
    .parameter "right"

    .prologue
    const/4 v0, 0x0

    .local v0, changed:Z
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/FrameLayout$LayoutParams;

    .local v1, lp:Landroid/widget/FrameLayout$LayoutParams;
    if-eqz p3, :cond_14

    iget v2, v1, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    iget v3, p2, Landroid/graphics/Rect;->left:I

    if-eq v2, v3, :cond_14

    const/4 v0, 0x1

    iget v2, p2, Landroid/graphics/Rect;->left:I

    iput v2, v1, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    :cond_14
    if-eqz p4, :cond_21

    iget v2, v1, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    iget v3, p2, Landroid/graphics/Rect;->top:I

    if-eq v2, v3, :cond_21

    const/4 v0, 0x1

    iget v2, p2, Landroid/graphics/Rect;->top:I

    iput v2, v1, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    :cond_21
    if-eqz p6, :cond_2e

    iget v2, v1, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    iget v3, p2, Landroid/graphics/Rect;->right:I

    if-eq v2, v3, :cond_2e

    const/4 v0, 0x1

    iget v2, p2, Landroid/graphics/Rect;->right:I

    iput v2, v1, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    :cond_2e
    if-eqz p5, :cond_3b

    iget v2, v1, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    iget v3, p2, Landroid/graphics/Rect;->bottom:I

    if-eq v2, v3, :cond_3b

    const/4 v0, 0x1

    iget v2, p2, Landroid/graphics/Rect;->bottom:I

    iput v2, v1, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    :cond_3b
    return v0
.end method

.method private init(Landroid/content/Context;)V
    .registers 6
    .parameter "context"

    .prologue
    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    sget-object v2, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarSizeAttr:[I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v0

    .local v0, ta:Landroid/content/res/TypedArray;
    invoke-virtual {v0, v3, v3}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v1

    iput v1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarHeight:I

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    return-void
.end method


# virtual methods
.method protected fitSystemWindows(Landroid/graphics/Rect;)Z
    .registers 13
    .parameter "insets"

    .prologue
    invoke-virtual {p0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->pullChildren()V

    invoke-virtual {p0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->getWindowSystemUiVisibility()I

    move-result v10

    .local v10, vis:I
    and-int/lit16 v0, v10, 0x100

    if-eqz v0, :cond_9c

    const/4 v8, 0x1

    .local v8, stable:Z
    :goto_c
    iget-object v1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarTop:Landroid/view/View;

    const/4 v3, 0x1

    const/4 v4, 0x1

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v2, p1

    invoke-direct/range {v0 .. v6}, Lcom/android/internal/widget/ActionBarOverlayLayout;->applyInsets(Landroid/view/View;Landroid/graphics/Rect;ZZZZ)Z

    move-result v7

    .local v7, changed:Z
    iget-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarBottom:Landroid/view/View;

    if-eqz v0, :cond_29

    iget-object v1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarBottom:Landroid/view/View;

    const/4 v3, 0x1

    const/4 v4, 0x0

    const/4 v5, 0x1

    const/4 v6, 0x1

    move-object v0, p0

    move-object v2, p1

    invoke-direct/range {v0 .. v6}, Lcom/android/internal/widget/ActionBarOverlayLayout;->applyInsets(Landroid/view/View;Landroid/graphics/Rect;ZZZZ)Z

    move-result v0

    or-int/2addr v7, v0

    :cond_29
    and-int/lit16 v0, v10, 0x600

    if-nez v0, :cond_9f

    iget-object v1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mContent:Landroid/view/View;

    const/4 v3, 0x1

    const/4 v4, 0x1

    const/4 v5, 0x1

    const/4 v6, 0x1

    move-object v0, p0

    move-object v2, p1

    invoke-direct/range {v0 .. v6}, Lcom/android/internal/widget/ActionBarOverlayLayout;->applyInsets(Landroid/view/View;Landroid/graphics/Rect;ZZZZ)Z

    move-result v0

    or-int/2addr v7, v0

    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Rect;->set(IIII)V

    :goto_41
    if-nez v8, :cond_4b

    iget-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarTop:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_52

    :cond_4b
    iget v0, p1, Landroid/graphics/Rect;->top:I

    iget v1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarHeight:I

    add-int/2addr v0, v1

    iput v0, p1, Landroid/graphics/Rect;->top:I

    :cond_52
    iget-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBar:Lcom/android/internal/app/ActionBarImpl;

    if-eqz v0, :cond_75

    iget-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBar:Lcom/android/internal/app/ActionBarImpl;

    invoke-virtual {v0}, Lcom/android/internal/app/ActionBarImpl;->hasNonEmbeddedTabs()Z

    move-result v0

    if-eqz v0, :cond_75

    iget-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarContainer;->getTabContainer()Landroid/view/View;

    move-result-object v9

    .local v9, tabs:Landroid/view/View;
    if-nez v8, :cond_6e

    if-eqz v9, :cond_75

    invoke-virtual {v9}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_75

    :cond_6e
    iget v0, p1, Landroid/graphics/Rect;->top:I

    iget v1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarHeight:I

    add-int/2addr v0, v1

    iput v0, p1, Landroid/graphics/Rect;->top:I

    .end local v9           #tabs:Landroid/view/View;
    :cond_75
    iget-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarView;->isSplitActionBar()Z

    move-result v0

    if-eqz v0, :cond_92

    if-nez v8, :cond_8b

    iget-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarBottom:Landroid/view/View;

    if-eqz v0, :cond_92

    iget-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarBottom:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_92

    :cond_8b
    iget v0, p1, Landroid/graphics/Rect;->bottom:I

    iget v1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarHeight:I

    add-int/2addr v0, v1

    iput v0, p1, Landroid/graphics/Rect;->bottom:I

    :cond_92
    if-eqz v7, :cond_97

    invoke-virtual {p0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->requestLayout()V

    :cond_97
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->fitSystemWindows(Landroid/graphics/Rect;)Z

    move-result v0

    return v0

    .end local v7           #changed:Z
    .end local v8           #stable:Z
    :cond_9c
    const/4 v8, 0x0

    goto/16 :goto_c

    .restart local v7       #changed:Z
    .restart local v8       #stable:Z
    :cond_9f
    iget-object v1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mContent:Landroid/view/View;

    iget-object v2, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mZeroRect:Landroid/graphics/Rect;

    const/4 v3, 0x1

    const/4 v4, 0x1

    const/4 v5, 0x1

    const/4 v6, 0x1

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Lcom/android/internal/widget/ActionBarOverlayLayout;->applyInsets(Landroid/view/View;Landroid/graphics/Rect;ZZZZ)Z

    move-result v0

    or-int/2addr v7, v0

    goto :goto_41
.end method

.method public onWindowSystemUiVisibilityChanged(I)V
    .registers 7
    .parameter "visible"

    .prologue
    const/4 v3, 0x1

    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onWindowSystemUiVisibilityChanged(I)V

    invoke-virtual {p0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->pullChildren()V

    iget v4, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mLastSystemUiVisibility:I

    xor-int v1, v4, p1

    .local v1, diff:I
    iput p1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mLastSystemUiVisibility:I

    and-int/lit8 v4, p1, 0x4

    if-nez v4, :cond_33

    move v0, v3

    .local v0, barVisible:Z
    :goto_12
    iget-object v4, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBar:Lcom/android/internal/app/ActionBarImpl;

    if-eqz v4, :cond_35

    iget-object v3, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBar:Lcom/android/internal/app/ActionBarImpl;

    invoke-virtual {v3}, Lcom/android/internal/app/ActionBarImpl;->isSystemShowing()Z

    move-result v2

    .local v2, wasVisible:Z
    :goto_1c
    iget-object v3, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBar:Lcom/android/internal/app/ActionBarImpl;

    if-eqz v3, :cond_27

    if-eqz v0, :cond_37

    iget-object v3, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBar:Lcom/android/internal/app/ActionBarImpl;

    invoke-virtual {v3}, Lcom/android/internal/app/ActionBarImpl;->showForSystem()V

    :cond_27
    :goto_27
    and-int/lit16 v3, v1, 0x100

    if-eqz v3, :cond_32

    iget-object v3, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBar:Lcom/android/internal/app/ActionBarImpl;

    if-eqz v3, :cond_32

    invoke-virtual {p0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->requestFitSystemWindows()V

    :cond_32
    return-void

    .end local v0           #barVisible:Z
    .end local v2           #wasVisible:Z
    :cond_33
    const/4 v0, 0x0

    goto :goto_12

    .restart local v0       #barVisible:Z
    :cond_35
    move v2, v3

    goto :goto_1c

    .restart local v2       #wasVisible:Z
    :cond_37
    iget-object v3, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBar:Lcom/android/internal/app/ActionBarImpl;

    invoke-virtual {v3}, Lcom/android/internal/app/ActionBarImpl;->hideForSystem()V

    goto :goto_27
.end method

.method protected onWindowVisibilityChanged(I)V
    .registers 3
    .parameter "visibility"

    .prologue
    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onWindowVisibilityChanged(I)V

    iput p1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mWindowVisibility:I

    iget-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBar:Lcom/android/internal/app/ActionBarImpl;

    if-eqz v0, :cond_e

    iget-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBar:Lcom/android/internal/app/ActionBarImpl;

    invoke-virtual {v0, p1}, Lcom/android/internal/app/ActionBarImpl;->setWindowVisibility(I)V

    :cond_e
    return-void
.end method

.method pullChildren()V
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mContent:Landroid/view/View;

    if-nez v0, :cond_35

    const v0, 0x1020002

    invoke-virtual {p0, v0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mContent:Landroid/view/View;

    const v0, 0x1020323

    invoke-virtual {p0, v0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarTop:Landroid/view/View;

    const v0, 0x102031e

    invoke-virtual {p0, v0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/internal/widget/ActionBarContainer;

    iput-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    const v0, 0x102031f

    invoke-virtual {p0, v0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/internal/widget/ActionBarView;

    iput-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionView:Lcom/android/internal/widget/ActionBarView;

    const v0, 0x1020321

    invoke-virtual {p0, v0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBarBottom:Landroid/view/View;

    :cond_35
    return-void
.end method

.method public setActionBar(Lcom/android/internal/app/ActionBarImpl;)V
    .registers 5
    .parameter "impl"

    .prologue
    iput-object p1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBar:Lcom/android/internal/app/ActionBarImpl;

    invoke-virtual {p0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_1b

    iget-object v1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mActionBar:Lcom/android/internal/app/ActionBarImpl;

    iget v2, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mWindowVisibility:I

    invoke-virtual {v1, v2}, Lcom/android/internal/app/ActionBarImpl;->setWindowVisibility(I)V

    iget v1, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mLastSystemUiVisibility:I

    if-eqz v1, :cond_1b

    iget v0, p0, Lcom/android/internal/widget/ActionBarOverlayLayout;->mLastSystemUiVisibility:I

    .local v0, newVis:I
    invoke-virtual {p0, v0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->onWindowSystemUiVisibilityChanged(I)V

    invoke-virtual {p0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->requestFitSystemWindows()V

    .end local v0           #newVis:I
    :cond_1b
    return-void
.end method

.method public setShowingForActionMode(Z)V
    .registers 4
    .parameter "showing"

    .prologue
    if-eqz p1, :cond_11

    invoke-virtual {p0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->getWindowSystemUiVisibility()I

    move-result v0

    and-int/lit16 v0, v0, 0x500

    const/16 v1, 0x500

    if-ne v0, v1, :cond_10

    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->setDisabledSystemUiVisibility(I)V

    :cond_10
    :goto_10
    return-void

    :cond_11
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->setDisabledSystemUiVisibility(I)V

    goto :goto_10
.end method
