.class public Landroid/widget/FrameLayout;
.super Landroid/view/ViewGroup;
.source "FrameLayout.java"


# annotations
.annotation runtime Landroid/widget/RemoteViews$RemoteView;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/FrameLayout$LayoutParams;
    }
.end annotation


# static fields
.field private static final DEFAULT_CHILD_GRAVITY:I = 0x33


# instance fields
.field private mForeground:Landroid/graphics/drawable/Drawable;
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "drawing"
    .end annotation
.end field

.field mForegroundBoundsChanged:Z

.field private mForegroundGravity:I
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "drawing"
    .end annotation
.end field

.field protected mForegroundInPadding:Z
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "drawing"
    .end annotation
.end field

.field private mForegroundPaddingBottom:I
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "padding"
    .end annotation
.end field

.field private mForegroundPaddingLeft:I
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "padding"
    .end annotation
.end field

.field private mForegroundPaddingRight:I
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "padding"
    .end annotation
.end field

.field private mForegroundPaddingTop:I
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "padding"
    .end annotation
.end field

.field private final mMatchParentChildren:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field mMeasureAllChildren:Z
    .annotation runtime Landroid/view/ViewDebug$ExportedProperty;
        category = "measurement"
    .end annotation
.end field

.field private final mOverlayBounds:Landroid/graphics/Rect;

.field private final mSelfBounds:Landroid/graphics/Rect;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 5
    .parameter "context"

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 93
    invoke-direct {p0, p1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V

    .line 60
    iput-boolean v1, p0, Landroid/widget/FrameLayout;->mMeasureAllChildren:Z

    .line 66
    iput v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingLeft:I

    .line 69
    iput v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingTop:I

    .line 72
    iput v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingRight:I

    .line 75
    iput v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingBottom:I

    .line 78
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/widget/FrameLayout;->mSelfBounds:Landroid/graphics/Rect;

    .line 79
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/widget/FrameLayout;->mOverlayBounds:Landroid/graphics/Rect;

    .line 81
    const/16 v0, 0x77

    iput v0, p0, Landroid/widget/FrameLayout;->mForegroundGravity:I

    .line 85
    iput-boolean v2, p0, Landroid/widget/FrameLayout;->mForegroundInPadding:Z

    .line 88
    iput-boolean v1, p0, Landroid/widget/FrameLayout;->mForegroundBoundsChanged:Z

    .line 90
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v2}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Landroid/widget/FrameLayout;->mMatchParentChildren:Ljava/util/ArrayList;

    .line 94
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 97
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 98
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 10
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 101
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 60
    iput-boolean v4, p0, Landroid/widget/FrameLayout;->mMeasureAllChildren:Z

    .line 66
    iput v4, p0, Landroid/widget/FrameLayout;->mForegroundPaddingLeft:I

    .line 69
    iput v4, p0, Landroid/widget/FrameLayout;->mForegroundPaddingTop:I

    .line 72
    iput v4, p0, Landroid/widget/FrameLayout;->mForegroundPaddingRight:I

    .line 75
    iput v4, p0, Landroid/widget/FrameLayout;->mForegroundPaddingBottom:I

    .line 78
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    iput-object v2, p0, Landroid/widget/FrameLayout;->mSelfBounds:Landroid/graphics/Rect;

    .line 79
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    iput-object v2, p0, Landroid/widget/FrameLayout;->mOverlayBounds:Landroid/graphics/Rect;

    .line 81
    const/16 v2, 0x77

    iput v2, p0, Landroid/widget/FrameLayout;->mForegroundGravity:I

    .line 85
    iput-boolean v5, p0, Landroid/widget/FrameLayout;->mForegroundInPadding:Z

    .line 88
    iput-boolean v4, p0, Landroid/widget/FrameLayout;->mForegroundBoundsChanged:Z

    .line 90
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, v5}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v2, p0, Landroid/widget/FrameLayout;->mMatchParentChildren:Ljava/util/ArrayList;

    .line 103
    sget-object v2, Lcom/android/internal/R$styleable;->FrameLayout:[I

    invoke-virtual {p1, p2, v2, p3, v4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 106
    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v2, 0x2

    iget v3, p0, Landroid/widget/FrameLayout;->mForegroundGravity:I

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    iput v2, p0, Landroid/widget/FrameLayout;->mForegroundGravity:I

    .line 109
    invoke-virtual {v0, v4}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 110
    .local v1, d:Landroid/graphics/drawable/Drawable;
    if-eqz v1, :cond_44

    .line 111
    invoke-virtual {p0, v1}, Landroid/widget/FrameLayout;->setForeground(Landroid/graphics/drawable/Drawable;)V

    .line 114
    :cond_44
    invoke-virtual {v0, v5, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_4d

    .line 115
    invoke-virtual {p0, v5}, Landroid/widget/FrameLayout;->setMeasureAllChildren(Z)V

    .line 118
    :cond_4d
    const/4 v2, 0x3

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    iput-boolean v2, p0, Landroid/widget/FrameLayout;->mForegroundInPadding:Z

    .line 121
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 122
    return-void
.end method

.method private getPaddingBottomWithForeground()I
    .registers 3

    .prologue
    .line 286
    iget-boolean v0, p0, Landroid/widget/FrameLayout;->mForegroundInPadding:Z

    if-eqz v0, :cond_d

    iget v0, p0, Landroid/view/View;->mPaddingBottom:I

    iget v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingBottom:I

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    :goto_c
    return v0

    :cond_d
    iget v0, p0, Landroid/view/View;->mPaddingBottom:I

    iget v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingBottom:I

    add-int/2addr v0, v1

    goto :goto_c
.end method

.method private getPaddingLeftWithForeground()I
    .registers 3

    .prologue
    .line 271
    iget-boolean v0, p0, Landroid/widget/FrameLayout;->mForegroundInPadding:Z

    if-eqz v0, :cond_d

    iget v0, p0, Landroid/view/View;->mPaddingLeft:I

    iget v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingLeft:I

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    :goto_c
    return v0

    :cond_d
    iget v0, p0, Landroid/view/View;->mPaddingLeft:I

    iget v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingLeft:I

    add-int/2addr v0, v1

    goto :goto_c
.end method

.method private getPaddingRightWithForeground()I
    .registers 3

    .prologue
    .line 276
    iget-boolean v0, p0, Landroid/widget/FrameLayout;->mForegroundInPadding:Z

    if-eqz v0, :cond_d

    iget v0, p0, Landroid/view/View;->mPaddingRight:I

    iget v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingRight:I

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    :goto_c
    return v0

    :cond_d
    iget v0, p0, Landroid/view/View;->mPaddingRight:I

    iget v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingRight:I

    add-int/2addr v0, v1

    goto :goto_c
.end method

.method private getPaddingTopWithForeground()I
    .registers 3

    .prologue
    .line 281
    iget-boolean v0, p0, Landroid/widget/FrameLayout;->mForegroundInPadding:Z

    if-eqz v0, :cond_d

    iget v0, p0, Landroid/view/View;->mPaddingTop:I

    iget v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingTop:I

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    :goto_c
    return v0

    :cond_d
    iget v0, p0, Landroid/view/View;->mPaddingTop:I

    iget v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingTop:I

    add-int/2addr v0, v1

    goto :goto_c
.end method


# virtual methods
.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .registers 3
    .parameter "p"

    .prologue
    .line 567
    instance-of v0, p1, Landroid/widget/FrameLayout$LayoutParams;

    return v0
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .registers 12
    .parameter "canvas"

    .prologue
    const/4 v2, 0x0

    .line 467
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->draw(Landroid/graphics/Canvas;)V

    .line 469
    iget-object v0, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_3e

    .line 470
    iget-object v6, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    .line 472
    .local v6, foreground:Landroid/graphics/drawable/Drawable;
    iget-boolean v0, p0, Landroid/widget/FrameLayout;->mForegroundBoundsChanged:Z

    if-eqz v0, :cond_3b

    .line 473
    iput-boolean v2, p0, Landroid/widget/FrameLayout;->mForegroundBoundsChanged:Z

    .line 474
    iget-object v3, p0, Landroid/widget/FrameLayout;->mSelfBounds:Landroid/graphics/Rect;

    .line 475
    .local v3, selfBounds:Landroid/graphics/Rect;
    iget-object v4, p0, Landroid/widget/FrameLayout;->mOverlayBounds:Landroid/graphics/Rect;

    .line 477
    .local v4, overlayBounds:Landroid/graphics/Rect;
    iget v0, p0, Landroid/view/View;->mRight:I

    iget v1, p0, Landroid/view/View;->mLeft:I

    sub-int v8, v0, v1

    .line 478
    .local v8, w:I
    iget v0, p0, Landroid/view/View;->mBottom:I

    iget v1, p0, Landroid/view/View;->mTop:I

    sub-int v7, v0, v1

    .line 480
    .local v7, h:I
    iget-boolean v0, p0, Landroid/widget/FrameLayout;->mForegroundInPadding:Z

    if-eqz v0, :cond_3f

    .line 481
    invoke-virtual {v3, v2, v2, v8, v7}, Landroid/graphics/Rect;->set(IIII)V

    .line 486
    :goto_27
    invoke-virtual {p0}, Landroid/widget/FrameLayout;->getResolvedLayoutDirection()I

    move-result v5

    .line 487
    .local v5, layoutDirection:I
    iget v0, p0, Landroid/widget/FrameLayout;->mForegroundGravity:I

    invoke-virtual {v6}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v1

    invoke-virtual {v6}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    invoke-static/range {v0 .. v5}, Landroid/view/Gravity;->apply(IIILandroid/graphics/Rect;Landroid/graphics/Rect;I)V

    .line 490
    invoke-virtual {v6, v4}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 493
    .end local v3           #selfBounds:Landroid/graphics/Rect;
    .end local v4           #overlayBounds:Landroid/graphics/Rect;
    .end local v5           #layoutDirection:I
    .end local v7           #h:I
    .end local v8           #w:I
    :cond_3b
    invoke-virtual {v6, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 495
    .end local v6           #foreground:Landroid/graphics/drawable/Drawable;
    :cond_3e
    return-void

    .line 483
    .restart local v3       #selfBounds:Landroid/graphics/Rect;
    .restart local v4       #overlayBounds:Landroid/graphics/Rect;
    .restart local v6       #foreground:Landroid/graphics/drawable/Drawable;
    .restart local v7       #h:I
    .restart local v8       #w:I
    :cond_3f
    iget v0, p0, Landroid/view/View;->mPaddingLeft:I

    iget v1, p0, Landroid/view/View;->mPaddingTop:I

    iget v2, p0, Landroid/view/View;->mPaddingRight:I

    sub-int v2, v8, v2

    iget v9, p0, Landroid/view/View;->mPaddingBottom:I

    sub-int v9, v7, v9

    invoke-virtual {v3, v0, v1, v2, v9}, Landroid/graphics/Rect;->set(IIII)V

    goto :goto_27
.end method

.method protected drawableStateChanged()V
    .registers 3

    .prologue
    .line 198
    invoke-super {p0}, Landroid/view/ViewGroup;->drawableStateChanged()V

    .line 199
    iget-object v0, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_18

    iget-object v0, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v0

    if-eqz v0, :cond_18

    .line 200
    iget-object v0, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0}, Landroid/widget/FrameLayout;->getDrawableState()[I

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 202
    :cond_18
    return-void
.end method

.method public gatherTransparentRegion(Landroid/graphics/Region;)Z
    .registers 4
    .parameter "region"

    .prologue
    .line 502
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->gatherTransparentRegion(Landroid/graphics/Region;)Z

    move-result v0

    .line 503
    .local v0, opaque:Z
    if-eqz p1, :cond_f

    iget-object v1, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_f

    .line 504
    iget-object v1, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v1, p1}, Landroid/widget/FrameLayout;->applyDrawableToTransparentRegion(Landroid/graphics/drawable/Drawable;Landroid/graphics/Region;)V

    .line 506
    :cond_f
    return v0
.end method

.method protected bridge synthetic generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .registers 2

    .prologue
    .line 56
    invoke-virtual {p0}, Landroid/widget/FrameLayout;->generateDefaultLayoutParams()Landroid/widget/FrameLayout$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method protected generateDefaultLayoutParams()Landroid/widget/FrameLayout$LayoutParams;
    .registers 3

    .prologue
    const/4 v1, -0x1

    .line 211
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v0, v1, v1}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    return-object v0
.end method

.method public bridge synthetic generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .registers 3
    .parameter "x0"

    .prologue
    .line 56
    invoke-virtual {p0, p1}, Landroid/widget/FrameLayout;->generateLayoutParams(Landroid/util/AttributeSet;)Landroid/widget/FrameLayout$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .registers 3
    .parameter "p"

    .prologue
    .line 572
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v0, p1}, Landroid/widget/FrameLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Landroid/widget/FrameLayout$LayoutParams;
    .registers 4
    .parameter "attrs"

    .prologue
    .line 554
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-virtual {p0}, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Landroid/widget/FrameLayout$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method public getConsiderGoneChildrenWhenMeasuring()Z
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 536
    invoke-virtual {p0}, Landroid/widget/FrameLayout;->getMeasureAllChildren()Z

    move-result v0

    return v0
.end method

.method public getForeground()Landroid/graphics/drawable/Drawable;
    .registers 2

    .prologue
    .line 267
    iget-object v0, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getForegroundGravity()I
    .registers 2

    .prologue
    .line 134
    iget v0, p0, Landroid/widget/FrameLayout;->mForegroundGravity:I

    return v0
.end method

.method public getMeasureAllChildren()Z
    .registers 2

    .prologue
    .line 546
    iget-boolean v0, p0, Landroid/widget/FrameLayout;->mMeasureAllChildren:Z

    return v0
.end method

.method public jumpDrawablesToCurrentState()V
    .registers 2

    .prologue
    .line 189
    invoke-super {p0}, Landroid/view/ViewGroup;->jumpDrawablesToCurrentState()V

    .line 190
    iget-object v0, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_c

    iget-object v0, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->jumpToCurrentState()V

    .line 191
    :cond_c
    return-void
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 3
    .parameter "event"

    .prologue
    .line 578
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 579
    const-class v0, Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 580
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .registers 3
    .parameter "info"

    .prologue
    .line 584
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 585
    const-class v0, Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    .line 586
    return-void
.end method

.method protected onLayout(ZIIII)V
    .registers 26
    .parameter "changed"
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    .line 388
    invoke-virtual/range {p0 .. p0}, Landroid/widget/FrameLayout;->getChildCount()I

    move-result v6

    .line 390
    .local v6, count:I
    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingLeftWithForeground()I

    move-result v13

    .line 391
    .local v13, parentLeft:I
    sub-int v18, p4, p2

    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingRightWithForeground()I

    move-result v19

    sub-int v14, v18, v19

    .line 393
    .local v14, parentRight:I
    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingTopWithForeground()I

    move-result v15

    .line 394
    .local v15, parentTop:I
    sub-int v18, p5, p3

    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingBottomWithForeground()I

    move-result v19

    sub-int v12, v18, v19

    .line 396
    .local v12, parentBottom:I
    const/16 v18, 0x1

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput-boolean v0, v1, Landroid/widget/FrameLayout;->mForegroundBoundsChanged:Z

    .line 398
    const/4 v9, 0x0

    .local v9, i:I
    :goto_25
    if-ge v9, v6, :cond_c7

    .line 399
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 400
    .local v3, child:Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getVisibility()I

    move-result v18

    const/16 v19, 0x8

    move/from16 v0, v18

    move/from16 v1, v19

    if-eq v0, v1, :cond_7a

    .line 401
    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v11

    check-cast v11, Landroid/widget/FrameLayout$LayoutParams;

    .line 403
    .local v11, lp:Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v17

    .line 404
    .local v17, width:I
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v8

    .line 409
    .local v8, height:I
    iget v7, v11, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 410
    .local v7, gravity:I
    const/16 v18, -0x1

    move/from16 v0, v18

    if-ne v7, v0, :cond_51

    .line 411
    const/16 v7, 0x33

    .line 414
    :cond_51
    invoke-virtual/range {p0 .. p0}, Landroid/widget/FrameLayout;->getResolvedLayoutDirection()I

    move-result v10

    .line 415
    .local v10, layoutDirection:I
    invoke-static {v7, v10}, Landroid/view/Gravity;->getAbsoluteGravity(II)I

    move-result v2

    .line 416
    .local v2, absoluteGravity:I
    and-int/lit8 v16, v7, 0x70

    .line 418
    .local v16, verticalGravity:I
    and-int/lit8 v18, v2, 0x7

    packed-switch v18, :pswitch_data_c8

    .line 430
    :pswitch_60
    iget v0, v11, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    move/from16 v18, v0

    add-int v4, v13, v18

    .line 433
    .local v4, childLeft:I
    :goto_66
    sparse-switch v16, :sswitch_data_d6

    .line 445
    iget v0, v11, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    move/from16 v18, v0

    add-int v5, v15, v18

    .line 448
    .local v5, childTop:I
    :goto_6f
    add-int v18, v4, v17

    add-int v19, v5, v8

    move/from16 v0, v18

    move/from16 v1, v19

    invoke-virtual {v3, v4, v5, v0, v1}, Landroid/view/View;->layout(IIII)V

    .line 398
    .end local v2           #absoluteGravity:I
    .end local v4           #childLeft:I
    .end local v5           #childTop:I
    .end local v7           #gravity:I
    .end local v8           #height:I
    .end local v10           #layoutDirection:I
    .end local v11           #lp:Landroid/widget/FrameLayout$LayoutParams;
    .end local v16           #verticalGravity:I
    .end local v17           #width:I
    :cond_7a
    add-int/lit8 v9, v9, 0x1

    goto :goto_25

    .line 420
    .restart local v2       #absoluteGravity:I
    .restart local v7       #gravity:I
    .restart local v8       #height:I
    .restart local v10       #layoutDirection:I
    .restart local v11       #lp:Landroid/widget/FrameLayout$LayoutParams;
    .restart local v16       #verticalGravity:I
    .restart local v17       #width:I
    :pswitch_7d
    iget v0, v11, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    move/from16 v18, v0

    add-int v4, v13, v18

    .line 421
    .restart local v4       #childLeft:I
    goto :goto_66

    .line 423
    .end local v4           #childLeft:I
    :pswitch_84
    sub-int v18, v14, v13

    sub-int v18, v18, v17

    div-int/lit8 v18, v18, 0x2

    add-int v18, v18, v13

    iget v0, v11, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    move/from16 v19, v0

    add-int v18, v18, v19

    iget v0, v11, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    move/from16 v19, v0

    sub-int v4, v18, v19

    .line 425
    .restart local v4       #childLeft:I
    goto :goto_66

    .line 427
    .end local v4           #childLeft:I
    :pswitch_99
    sub-int v18, v14, v17

    iget v0, v11, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    move/from16 v19, v0

    sub-int v4, v18, v19

    .line 428
    .restart local v4       #childLeft:I
    goto :goto_66

    .line 435
    :sswitch_a2
    iget v0, v11, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    move/from16 v18, v0

    add-int v5, v15, v18

    .line 436
    .restart local v5       #childTop:I
    goto :goto_6f

    .line 438
    .end local v5           #childTop:I
    :sswitch_a9
    sub-int v18, v12, v15

    sub-int v18, v18, v8

    div-int/lit8 v18, v18, 0x2

    add-int v18, v18, v15

    iget v0, v11, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    move/from16 v19, v0

    add-int v18, v18, v19

    iget v0, v11, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    move/from16 v19, v0

    sub-int v5, v18, v19

    .line 440
    .restart local v5       #childTop:I
    goto :goto_6f

    .line 442
    .end local v5           #childTop:I
    :sswitch_be
    sub-int v18, v12, v8

    iget v0, v11, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    move/from16 v19, v0

    sub-int v5, v18, v19

    .line 443
    .restart local v5       #childTop:I
    goto :goto_6f

    .line 451
    .end local v2           #absoluteGravity:I
    .end local v3           #child:Landroid/view/View;
    .end local v4           #childLeft:I
    .end local v5           #childTop:I
    .end local v7           #gravity:I
    .end local v8           #height:I
    .end local v10           #layoutDirection:I
    .end local v11           #lp:Landroid/widget/FrameLayout$LayoutParams;
    .end local v16           #verticalGravity:I
    .end local v17           #width:I
    :cond_c7
    return-void

    .line 418
    :pswitch_data_c8
    .packed-switch 0x1
        :pswitch_84
        :pswitch_60
        :pswitch_7d
        :pswitch_60
        :pswitch_99
    .end packed-switch

    .line 433
    :sswitch_data_d6
    .sparse-switch
        0x10 -> :sswitch_a9
        0x30 -> :sswitch_a2
        0x50 -> :sswitch_be
    .end sparse-switch
.end method

.method protected onMeasure(II)V
    .registers 20
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    .line 296
    invoke-virtual/range {p0 .. p0}, Landroid/widget/FrameLayout;->getChildCount()I

    move-result v10

    .line 298
    .local v10, count:I
    invoke-static/range {p1 .. p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    const/high16 v3, 0x4000

    if-ne v1, v3, :cond_14

    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    const/high16 v3, 0x4000

    if-eq v1, v3, :cond_82

    :cond_14
    const/16 v16, 0x1

    .line 301
    .local v16, measureMatchParentChildren:Z
    :goto_16
    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/widget/FrameLayout;->mMatchParentChildren:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 303
    const/4 v14, 0x0

    .line 304
    .local v14, maxHeight:I
    const/4 v15, 0x0

    .line 305
    .local v15, maxWidth:I
    const/4 v8, 0x0

    .line 307
    .local v8, childState:I
    const/4 v12, 0x0

    .local v12, i:I
    :goto_21
    if-ge v12, v10, :cond_85

    .line 308
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 309
    .local v2, child:Landroid/view/View;
    move-object/from16 v0, p0

    iget-boolean v1, v0, Landroid/widget/FrameLayout;->mMeasureAllChildren:Z

    if-nez v1, :cond_37

    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v1

    const/16 v3, 0x8

    if-eq v1, v3, :cond_7f

    .line 310
    :cond_37
    const/4 v4, 0x0

    const/4 v6, 0x0

    move-object/from16 v1, p0

    move/from16 v3, p1

    move/from16 v5, p2

    invoke-virtual/range {v1 .. v6}, Landroid/widget/FrameLayout;->measureChildWithMargins(Landroid/view/View;IIII)V

    .line 311
    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v13

    check-cast v13, Landroid/widget/FrameLayout$LayoutParams;

    .line 312
    .local v13, lp:Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual {v2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    iget v3, v13, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    add-int/2addr v1, v3

    iget v3, v13, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    add-int/2addr v1, v3

    invoke-static {v15, v1}, Ljava/lang/Math;->max(II)I

    move-result v15

    .line 314
    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v1

    iget v3, v13, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    add-int/2addr v1, v3

    iget v3, v13, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    add-int/2addr v1, v3

    invoke-static {v14, v1}, Ljava/lang/Math;->max(II)I

    move-result v14

    .line 316
    invoke-virtual {v2}, Landroid/view/View;->getMeasuredState()I

    move-result v1

    invoke-static {v8, v1}, Landroid/widget/FrameLayout;->combineMeasuredStates(II)I

    move-result v8

    .line 317
    if-eqz v16, :cond_7f

    .line 318
    iget v1, v13, Landroid/view/ViewGroup$LayoutParams;->width:I

    const/4 v3, -0x1

    if-eq v1, v3, :cond_78

    iget v1, v13, Landroid/view/ViewGroup$LayoutParams;->height:I

    const/4 v3, -0x1

    if-ne v1, v3, :cond_7f

    .line 320
    :cond_78
    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/widget/FrameLayout;->mMatchParentChildren:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 307
    .end local v13           #lp:Landroid/widget/FrameLayout$LayoutParams;
    :cond_7f
    add-int/lit8 v12, v12, 0x1

    goto :goto_21

    .line 298
    .end local v2           #child:Landroid/view/View;
    .end local v8           #childState:I
    .end local v12           #i:I
    .end local v14           #maxHeight:I
    .end local v15           #maxWidth:I
    .end local v16           #measureMatchParentChildren:Z
    :cond_82
    const/16 v16, 0x0

    goto :goto_16

    .line 327
    .restart local v8       #childState:I
    .restart local v12       #i:I
    .restart local v14       #maxHeight:I
    .restart local v15       #maxWidth:I
    .restart local v16       #measureMatchParentChildren:Z
    :cond_85
    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingLeftWithForeground()I

    move-result v1

    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingRightWithForeground()I

    move-result v3

    add-int/2addr v1, v3

    add-int/2addr v15, v1

    .line 328
    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingTopWithForeground()I

    move-result v1

    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingBottomWithForeground()I

    move-result v3

    add-int/2addr v1, v3

    add-int/2addr v14, v1

    .line 331
    invoke-virtual/range {p0 .. p0}, Landroid/widget/FrameLayout;->getSuggestedMinimumHeight()I

    move-result v1

    invoke-static {v14, v1}, Ljava/lang/Math;->max(II)I

    move-result v14

    .line 332
    invoke-virtual/range {p0 .. p0}, Landroid/widget/FrameLayout;->getSuggestedMinimumWidth()I

    move-result v1

    invoke-static {v15, v1}, Ljava/lang/Math;->max(II)I

    move-result v15

    .line 335
    invoke-virtual/range {p0 .. p0}, Landroid/widget/FrameLayout;->getForeground()Landroid/graphics/drawable/Drawable;

    move-result-object v11

    .line 336
    .local v11, drawable:Landroid/graphics/drawable/Drawable;
    if-eqz v11, :cond_bf

    .line 337
    invoke-virtual {v11}, Landroid/graphics/drawable/Drawable;->getMinimumHeight()I

    move-result v1

    invoke-static {v14, v1}, Ljava/lang/Math;->max(II)I

    move-result v14

    .line 338
    invoke-virtual {v11}, Landroid/graphics/drawable/Drawable;->getMinimumWidth()I

    move-result v1

    invoke-static {v15, v1}, Ljava/lang/Math;->max(II)I

    move-result v15

    .line 341
    :cond_bf
    move/from16 v0, p1

    invoke-static {v15, v0, v8}, Landroid/widget/FrameLayout;->resolveSizeAndState(III)I

    move-result v1

    shl-int/lit8 v3, v8, 0x10

    move/from16 v0, p2

    invoke-static {v14, v0, v3}, Landroid/widget/FrameLayout;->resolveSizeAndState(III)I

    move-result v3

    move-object/from16 v0, p0

    invoke-virtual {v0, v1, v3}, Landroid/widget/FrameLayout;->setMeasuredDimension(II)V

    .line 345
    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/widget/FrameLayout;->mMatchParentChildren:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v10

    .line 346
    const/4 v1, 0x1

    if-le v10, v1, :cond_164

    .line 347
    const/4 v12, 0x0

    :goto_de
    if-ge v12, v10, :cond_164

    .line 348
    move-object/from16 v0, p0

    iget-object v1, v0, Landroid/widget/FrameLayout;->mMatchParentChildren:Ljava/util/ArrayList;

    invoke-virtual {v1, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    .line 350
    .restart local v2       #child:Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v13

    check-cast v13, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 354
    .local v13, lp:Landroid/view/ViewGroup$MarginLayoutParams;
    iget v1, v13, Landroid/view/ViewGroup$LayoutParams;->width:I

    const/4 v3, -0x1

    if-ne v1, v3, :cond_134

    .line 355
    invoke-virtual/range {p0 .. p0}, Landroid/widget/FrameLayout;->getMeasuredWidth()I

    move-result v1

    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingLeftWithForeground()I

    move-result v3

    sub-int/2addr v1, v3

    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingRightWithForeground()I

    move-result v3

    sub-int/2addr v1, v3

    iget v3, v13, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    sub-int/2addr v1, v3

    iget v3, v13, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    sub-int/2addr v1, v3

    const/high16 v3, 0x4000

    invoke-static {v1, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v9

    .line 366
    .local v9, childWidthMeasureSpec:I
    :goto_10f
    iget v1, v13, Landroid/view/ViewGroup$LayoutParams;->height:I

    const/4 v3, -0x1

    if-ne v1, v3, :cond_14c

    .line 367
    invoke-virtual/range {p0 .. p0}, Landroid/widget/FrameLayout;->getMeasuredHeight()I

    move-result v1

    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingTopWithForeground()I

    move-result v3

    sub-int/2addr v1, v3

    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingBottomWithForeground()I

    move-result v3

    sub-int/2addr v1, v3

    iget v3, v13, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    sub-int/2addr v1, v3

    iget v3, v13, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    sub-int/2addr v1, v3

    const/high16 v3, 0x4000

    invoke-static {v1, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v7

    .line 378
    .local v7, childHeightMeasureSpec:I
    :goto_12e
    invoke-virtual {v2, v9, v7}, Landroid/view/View;->measure(II)V

    .line 347
    add-int/lit8 v12, v12, 0x1

    goto :goto_de

    .line 360
    .end local v7           #childHeightMeasureSpec:I
    .end local v9           #childWidthMeasureSpec:I
    :cond_134
    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingLeftWithForeground()I

    move-result v1

    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingRightWithForeground()I

    move-result v3

    add-int/2addr v1, v3

    iget v3, v13, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    add-int/2addr v1, v3

    iget v3, v13, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    add-int/2addr v1, v3

    iget v3, v13, Landroid/view/ViewGroup$LayoutParams;->width:I

    move/from16 v0, p1

    invoke-static {v0, v1, v3}, Landroid/widget/FrameLayout;->getChildMeasureSpec(III)I

    move-result v9

    .restart local v9       #childWidthMeasureSpec:I
    goto :goto_10f

    .line 372
    :cond_14c
    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingTopWithForeground()I

    move-result v1

    invoke-direct/range {p0 .. p0}, Landroid/widget/FrameLayout;->getPaddingBottomWithForeground()I

    move-result v3

    add-int/2addr v1, v3

    iget v3, v13, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    add-int/2addr v1, v3

    iget v3, v13, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    add-int/2addr v1, v3

    iget v3, v13, Landroid/view/ViewGroup$LayoutParams;->height:I

    move/from16 v0, p2

    invoke-static {v0, v1, v3}, Landroid/widget/FrameLayout;->getChildMeasureSpec(III)I

    move-result v7

    .restart local v7       #childHeightMeasureSpec:I
    goto :goto_12e

    .line 381
    .end local v2           #child:Landroid/view/View;
    .end local v7           #childHeightMeasureSpec:I
    .end local v9           #childWidthMeasureSpec:I
    .end local v13           #lp:Landroid/view/ViewGroup$MarginLayoutParams;
    :cond_164
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .registers 6
    .parameter "w"
    .parameter "h"
    .parameter "oldw"
    .parameter "oldh"

    .prologue
    .line 458
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/ViewGroup;->onSizeChanged(IIII)V

    .line 459
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/FrameLayout;->mForegroundBoundsChanged:Z

    .line 460
    return-void
.end method

.method public setForeground(Landroid/graphics/drawable/Drawable;)V
    .registers 6
    .parameter "drawable"

    .prologue
    const/4 v3, 0x0

    .line 225
    iget-object v1, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    if-eq v1, p1, :cond_5a

    .line 226
    iget-object v1, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_14

    .line 227
    iget-object v1, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 228
    iget-object v1, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v1}, Landroid/widget/FrameLayout;->unscheduleDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 231
    :cond_14
    iput-object p1, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    .line 232
    iput v3, p0, Landroid/widget/FrameLayout;->mForegroundPaddingLeft:I

    .line 233
    iput v3, p0, Landroid/widget/FrameLayout;->mForegroundPaddingTop:I

    .line 234
    iput v3, p0, Landroid/widget/FrameLayout;->mForegroundPaddingRight:I

    .line 235
    iput v3, p0, Landroid/widget/FrameLayout;->mForegroundPaddingBottom:I

    .line 237
    if-eqz p1, :cond_5b

    .line 238
    invoke-virtual {p0, v3}, Landroid/widget/FrameLayout;->setWillNotDraw(Z)V

    .line 239
    invoke-virtual {p1, p0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 240
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v1

    if-eqz v1, :cond_33

    .line 241
    invoke-virtual {p0}, Landroid/widget/FrameLayout;->getDrawableState()[I

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 243
    :cond_33
    iget v1, p0, Landroid/widget/FrameLayout;->mForegroundGravity:I

    const/16 v2, 0x77

    if-ne v1, v2, :cond_54

    .line 244
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 245
    .local v0, padding:Landroid/graphics/Rect;
    invoke-virtual {p1, v0}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    move-result v1

    if-eqz v1, :cond_54

    .line 246
    iget v1, v0, Landroid/graphics/Rect;->left:I

    iput v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingLeft:I

    .line 247
    iget v1, v0, Landroid/graphics/Rect;->top:I

    iput v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingTop:I

    .line 248
    iget v1, v0, Landroid/graphics/Rect;->right:I

    iput v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingRight:I

    .line 249
    iget v1, v0, Landroid/graphics/Rect;->bottom:I

    iput v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingBottom:I

    .line 255
    .end local v0           #padding:Landroid/graphics/Rect;
    :cond_54
    :goto_54
    invoke-virtual {p0}, Landroid/widget/FrameLayout;->requestLayout()V

    .line 256
    invoke-virtual {p0}, Landroid/widget/FrameLayout;->invalidate()V

    .line 258
    :cond_5a
    return-void

    .line 253
    :cond_5b
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Landroid/widget/FrameLayout;->setWillNotDraw(Z)V

    goto :goto_54
.end method

.method public setForegroundGravity(I)V
    .registers 6
    .parameter "foregroundGravity"
    .annotation runtime Landroid/view/RemotableViewMethod;
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 148
    iget v1, p0, Landroid/widget/FrameLayout;->mForegroundGravity:I

    if-eq v1, p1, :cond_41

    .line 149
    const v1, 0x800007

    and-int/2addr v1, p1

    if-nez v1, :cond_f

    .line 150
    const v1, 0x800003

    or-int/2addr p1, v1

    .line 153
    :cond_f
    and-int/lit8 v1, p1, 0x70

    if-nez v1, :cond_15

    .line 154
    or-int/lit8 p1, p1, 0x30

    .line 157
    :cond_15
    iput p1, p0, Landroid/widget/FrameLayout;->mForegroundGravity:I

    .line 160
    iget v1, p0, Landroid/widget/FrameLayout;->mForegroundGravity:I

    const/16 v2, 0x77

    if-ne v1, v2, :cond_42

    iget-object v1, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_42

    .line 161
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 162
    .local v0, padding:Landroid/graphics/Rect;
    iget-object v1, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v0}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    move-result v1

    if-eqz v1, :cond_3e

    .line 163
    iget v1, v0, Landroid/graphics/Rect;->left:I

    iput v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingLeft:I

    .line 164
    iget v1, v0, Landroid/graphics/Rect;->top:I

    iput v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingTop:I

    .line 165
    iget v1, v0, Landroid/graphics/Rect;->right:I

    iput v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingRight:I

    .line 166
    iget v1, v0, Landroid/graphics/Rect;->bottom:I

    iput v1, p0, Landroid/widget/FrameLayout;->mForegroundPaddingBottom:I

    .line 175
    .end local v0           #padding:Landroid/graphics/Rect;
    :cond_3e
    :goto_3e
    invoke-virtual {p0}, Landroid/widget/FrameLayout;->requestLayout()V

    .line 177
    :cond_41
    return-void

    .line 169
    :cond_42
    iput v3, p0, Landroid/widget/FrameLayout;->mForegroundPaddingLeft:I

    .line 170
    iput v3, p0, Landroid/widget/FrameLayout;->mForegroundPaddingTop:I

    .line 171
    iput v3, p0, Landroid/widget/FrameLayout;->mForegroundPaddingRight:I

    .line 172
    iput v3, p0, Landroid/widget/FrameLayout;->mForegroundPaddingBottom:I

    goto :goto_3e
.end method

.method public setMeasureAllChildren(Z)V
    .registers 2
    .parameter "measureAll"
    .annotation runtime Landroid/view/RemotableViewMethod;
    .end annotation

    .prologue
    .line 520
    iput-boolean p1, p0, Landroid/widget/FrameLayout;->mMeasureAllChildren:Z

    .line 521
    return-void
.end method

.method public shouldDelayChildPressedState()Z
    .registers 2

    .prologue
    .line 559
    const/4 v0, 0x0

    return v0
.end method

.method protected verifyDrawable(Landroid/graphics/drawable/Drawable;)Z
    .registers 3
    .parameter "who"

    .prologue
    .line 184
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->verifyDrawable(Landroid/graphics/drawable/Drawable;)Z

    move-result v0

    if-nez v0, :cond_a

    iget-object v0, p0, Landroid/widget/FrameLayout;->mForeground:Landroid/graphics/drawable/Drawable;

    if-ne p1, v0, :cond_c

    :cond_a
    const/4 v0, 0x1

    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method
