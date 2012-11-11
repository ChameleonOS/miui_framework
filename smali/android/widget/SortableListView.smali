.class public Landroid/widget/SortableListView;
.super Landroid/widget/ListView;
.source "SortableListView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/SortableListView$OnOrderChangedListener;
    }
.end annotation


# static fields
.field private static final ANIMATION_DURATION:I = 0xc8

.field private static final SCROLL_BOUND:F = 0.25f

.field private static final SCROLL_SPEED_MAX:I = 0x10

.field private static final SNAPSHOT_ALPHA:I = 0x99

.field private static final TAG:Ljava/lang/String; = "SortableListView"


# instance fields
.field private mDraggingFrom:I

.field private mDraggingItemHeight:I

.field private mDraggingItemWidth:I

.field private mDraggingTo:I

.field private mDraggingY:I

.field private mInterceptTouchForSorting:Z

.field private mItemUpperBound:I

.field private mOffsetYInDraggingItem:I

.field private mOnOrderChangedListener:Landroid/widget/SortableListView$OnOrderChangedListener;

.field private mOnTouchListener:Landroid/view/View$OnTouchListener;

.field private mScrollBound:I

.field private mScrollLowerBound:I

.field private mScrollUpperBound:I

.field private mSnapshot:Landroid/graphics/drawable/BitmapDrawable;

.field private mSnapshotBackgroundForOverUpperBound:Landroid/graphics/drawable/Drawable;

.field private mSnapshotShadow:Landroid/graphics/drawable/Drawable;

.field private mSnapshotShadowPaddingBottom:I

.field private mSnapshotShadowPaddingTop:I

.field private mTmpLocation:[I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/widget/SortableListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    const v0, 0x1010074

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/SortableListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 7
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    const/4 v1, -0x1

    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    iput v1, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    iput v1, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    iput v1, p0, Landroid/widget/SortableListView;->mItemUpperBound:I

    const/4 v1, 0x2

    new-array v1, v1, [I

    iput-object v1, p0, Landroid/widget/SortableListView;->mTmpLocation:[I

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x6020108

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/SortableListView;->mSnapshotShadow:Landroid/graphics/drawable/Drawable;

    iget-object v1, p0, Landroid/widget/SortableListView;->mSnapshotShadow:Landroid/graphics/drawable/Drawable;

    const/16 v2, 0x99

    invoke-virtual {v1, v2}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .local v0, padding:Landroid/graphics/Rect;
    iget-object v1, p0, Landroid/widget/SortableListView;->mSnapshotShadow:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v0}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    iget v1, v0, Landroid/graphics/Rect;->top:I

    iput v1, p0, Landroid/widget/SortableListView;->mSnapshotShadowPaddingTop:I

    iget v1, v0, Landroid/graphics/Rect;->bottom:I

    iput v1, p0, Landroid/widget/SortableListView;->mSnapshotShadowPaddingBottom:I

    new-instance v1, Landroid/widget/SortableListView$1;

    invoke-direct {v1, p0}, Landroid/widget/SortableListView$1;-><init>(Landroid/widget/SortableListView;)V

    iput-object v1, p0, Landroid/widget/SortableListView;->mOnTouchListener:Landroid/view/View$OnTouchListener;

    return-void
.end method

.method static synthetic access$000(Landroid/widget/SortableListView;)Landroid/widget/SortableListView$OnOrderChangedListener;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/SortableListView;->mOnOrderChangedListener:Landroid/widget/SortableListView$OnOrderChangedListener;

    return-object v0
.end method

.method static synthetic access$100(Landroid/widget/SortableListView;Landroid/view/MotionEvent;)I
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/widget/SortableListView;->getHittenItemPosition(Landroid/view/MotionEvent;)I

    move-result v0

    return v0
.end method

.method static synthetic access$1000(Landroid/widget/SortableListView;)Landroid/graphics/drawable/BitmapDrawable;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/SortableListView;->mSnapshot:Landroid/graphics/drawable/BitmapDrawable;

    return-object v0
.end method

.method static synthetic access$1002(Landroid/widget/SortableListView;Landroid/graphics/drawable/BitmapDrawable;)Landroid/graphics/drawable/BitmapDrawable;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Landroid/widget/SortableListView;->mSnapshot:Landroid/graphics/drawable/BitmapDrawable;

    return-object p1
.end method

.method static synthetic access$1100(Landroid/widget/SortableListView;)Landroid/graphics/drawable/Drawable;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/SortableListView;->mSnapshotBackgroundForOverUpperBound:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method static synthetic access$1200(Landroid/widget/SortableListView;)I
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Landroid/widget/SortableListView;->mSnapshotShadowPaddingTop:I

    return v0
.end method

.method static synthetic access$1300(Landroid/widget/SortableListView;)I
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Landroid/widget/SortableListView;->mSnapshotShadowPaddingBottom:I

    return v0
.end method

.method static synthetic access$1400(Landroid/widget/SortableListView;)Landroid/graphics/drawable/Drawable;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/SortableListView;->mSnapshotShadow:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method static synthetic access$1500(Landroid/widget/SortableListView;IIII)Landroid/view/animation/Animation;
    .registers 6
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"
    .parameter "x4"

    .prologue
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/widget/SortableListView;->createAnimation(IIII)Landroid/view/animation/Animation;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$202(Landroid/widget/SortableListView;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput p1, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    return p1
.end method

.method static synthetic access$302(Landroid/widget/SortableListView;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput p1, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    return p1
.end method

.method static synthetic access$400(Landroid/widget/SortableListView;)Z
    .registers 2
    .parameter "x0"

    .prologue
    iget-boolean v0, p0, Landroid/widget/SortableListView;->mInterceptTouchForSorting:Z

    return v0
.end method

.method static synthetic access$402(Landroid/widget/SortableListView;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-boolean p1, p0, Landroid/widget/SortableListView;->mInterceptTouchForSorting:Z

    return p1
.end method

.method static synthetic access$500(Landroid/widget/SortableListView;)I
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Landroid/widget/SortableListView;->mDraggingItemWidth:I

    return v0
.end method

.method static synthetic access$502(Landroid/widget/SortableListView;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput p1, p0, Landroid/widget/SortableListView;->mDraggingItemWidth:I

    return p1
.end method

.method static synthetic access$600(Landroid/widget/SortableListView;)I
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Landroid/widget/SortableListView;->mDraggingItemHeight:I

    return v0
.end method

.method static synthetic access$602(Landroid/widget/SortableListView;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput p1, p0, Landroid/widget/SortableListView;->mDraggingItemHeight:I

    return p1
.end method

.method static synthetic access$700(Landroid/widget/SortableListView;)[I
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/SortableListView;->mTmpLocation:[I

    return-object v0
.end method

.method static synthetic access$800(Landroid/widget/SortableListView;)I
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Landroid/widget/SortableListView;->mDraggingY:I

    return v0
.end method

.method static synthetic access$802(Landroid/widget/SortableListView;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput p1, p0, Landroid/widget/SortableListView;->mDraggingY:I

    return p1
.end method

.method static synthetic access$902(Landroid/widget/SortableListView;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput p1, p0, Landroid/widget/SortableListView;->mOffsetYInDraggingItem:I

    return p1
.end method

.method private createAnimation(IIII)Landroid/view/animation/Animation;
    .registers 10
    .parameter "fromX"
    .parameter "toX"
    .parameter "fromY"
    .parameter "toY"

    .prologue
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    int-to-float v1, p1

    int-to-float v2, p2

    int-to-float v3, p3

    int-to-float v4, p4

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    .local v0, result:Landroid/view/animation/Animation;
    const-wide/16 v1, 0xc8

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setFillAfter(Z)V

    return-object v0
.end method

.method private getHittenItemPosition(Landroid/view/MotionEvent;)I
    .registers 11
    .parameter "event"

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v3

    .local v3, x:F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v4

    .local v4, y:F
    invoke-virtual {p0}, Landroid/widget/SortableListView;->getFirstVisiblePosition()I

    move-result v0

    .local v0, firstPosition:I
    invoke-virtual {p0}, Landroid/widget/SortableListView;->getLastVisiblePosition()I

    move-result v1

    .local v1, i:I
    :goto_12
    if-lt v1, v0, :cond_53

    sub-int v5, v1, v0

    invoke-virtual {p0, v5}, Landroid/widget/SortableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .local v2, view:Landroid/view/View;
    if-eqz v2, :cond_50

    iget-object v5, p0, Landroid/widget/SortableListView;->mTmpLocation:[I

    invoke-virtual {v2, v5}, Landroid/view/View;->getLocationOnScreen([I)V

    iget-object v5, p0, Landroid/widget/SortableListView;->mTmpLocation:[I

    aget v5, v5, v7

    int-to-float v5, v5

    cmpg-float v5, v5, v3

    if-gtz v5, :cond_50

    iget-object v5, p0, Landroid/widget/SortableListView;->mTmpLocation:[I

    aget v5, v5, v7

    invoke-virtual {v2}, Landroid/view/View;->getWidth()I

    move-result v6

    add-int/2addr v5, v6

    int-to-float v5, v5

    cmpl-float v5, v5, v3

    if-ltz v5, :cond_50

    iget-object v5, p0, Landroid/widget/SortableListView;->mTmpLocation:[I

    aget v5, v5, v8

    int-to-float v5, v5

    cmpg-float v5, v5, v4

    if-gtz v5, :cond_50

    iget-object v5, p0, Landroid/widget/SortableListView;->mTmpLocation:[I

    aget v5, v5, v8

    invoke-virtual {v2}, Landroid/view/View;->getHeight()I

    move-result v6

    add-int/2addr v5, v6

    int-to-float v5, v5

    cmpl-float v5, v5, v4

    if-ltz v5, :cond_50

    .end local v1           #i:I
    .end local v2           #view:Landroid/view/View;
    :goto_4f
    return v1

    .restart local v1       #i:I
    .restart local v2       #view:Landroid/view/View;
    :cond_50
    add-int/lit8 v1, v1, -0x1

    goto :goto_12

    .end local v2           #view:Landroid/view/View;
    :cond_53
    const/4 v1, -0x1

    goto :goto_4f
.end method

.method private setViewAnimation(Landroid/view/View;Landroid/view/animation/Animation;)V
    .registers 3
    .parameter "view"
    .parameter "animation"

    .prologue
    if-nez p1, :cond_3

    :goto_2
    return-void

    :cond_3
    if-eqz p2, :cond_9

    invoke-virtual {p1, p2}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_2

    :cond_9
    invoke-virtual {p1}, Landroid/view/View;->clearAnimation()V

    goto :goto_2
.end method

.method private setViewAnimationByPisition(ILandroid/view/animation/Animation;)V
    .registers 4
    .parameter "position"
    .parameter "animation"

    .prologue
    invoke-virtual {p0}, Landroid/widget/SortableListView;->getFirstVisiblePosition()I

    move-result v0

    sub-int v0, p1, v0

    invoke-virtual {p0, v0}, Landroid/widget/SortableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Landroid/widget/SortableListView;->setViewAnimation(Landroid/view/View;Landroid/view/animation/Animation;)V

    return-void
.end method

.method private updateDraggingToPisition(I)V
    .registers 6
    .parameter "draggingTo"

    .prologue
    const/4 v3, 0x0

    iget v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    if-eq p1, v0, :cond_7

    if-gez p1, :cond_8

    :cond_7
    return-void

    :cond_8
    const-string v0, "SortableListView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "sort item from "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " To "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget v0, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    iget v1, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    invoke-static {v1, p1}, Ljava/lang/Math;->max(II)I

    move-result v1

    if-ge v0, v1, :cond_72

    :goto_37
    iget v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    if-le v0, p1, :cond_72

    iget v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    iget v1, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    if-le v0, v1, :cond_72

    const-string v0, "SortableListView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "item "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " set move down reverse animation"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    add-int/lit8 v1, v0, -0x1

    iput v1, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    iget v1, p0, Landroid/widget/SortableListView;->mDraggingItemHeight:I

    neg-int v1, v1

    invoke-direct {p0, v3, v3, v1, v3}, Landroid/widget/SortableListView;->createAnimation(IIII)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Landroid/widget/SortableListView;->setViewAnimationByPisition(ILandroid/view/animation/Animation;)V

    goto :goto_37

    :cond_72
    iget v0, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    iget v1, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    invoke-static {v1, p1}, Ljava/lang/Math;->min(II)I

    move-result v1

    if-le v0, v1, :cond_b6

    :goto_7c
    iget v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    if-ge v0, p1, :cond_b6

    iget v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    iget v1, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    if-ge v0, v1, :cond_b6

    const-string v0, "SortableListView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "item "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " set move up reverse animation"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    iget v1, p0, Landroid/widget/SortableListView;->mDraggingItemHeight:I

    invoke-direct {p0, v3, v3, v1, v3}, Landroid/widget/SortableListView;->createAnimation(IIII)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Landroid/widget/SortableListView;->setViewAnimationByPisition(ILandroid/view/animation/Animation;)V

    goto :goto_7c

    :cond_b6
    iget v0, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    iget v1, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    invoke-static {v1, p1}, Ljava/lang/Math;->max(II)I

    move-result v1

    if-ge v0, v1, :cond_f5

    :goto_c0
    iget v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    if-ge v0, p1, :cond_f5

    iget v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    iget v1, p0, Landroid/widget/SortableListView;->mDraggingItemHeight:I

    neg-int v1, v1

    invoke-direct {p0, v3, v3, v3, v1}, Landroid/widget/SortableListView;->createAnimation(IIII)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Landroid/widget/SortableListView;->setViewAnimationByPisition(ILandroid/view/animation/Animation;)V

    const-string v0, "SortableListView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "item "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " set move up animation"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_c0

    :cond_f5
    iget v0, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    iget v1, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    invoke-static {v1, p1}, Ljava/lang/Math;->min(II)I

    move-result v1

    if-le v0, v1, :cond_7

    :goto_ff
    iget v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    if-le v0, p1, :cond_7

    iget v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    iget v1, p0, Landroid/widget/SortableListView;->mDraggingItemHeight:I

    invoke-direct {p0, v3, v3, v3, v1}, Landroid/widget/SortableListView;->createAnimation(IIII)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Landroid/widget/SortableListView;->setViewAnimationByPisition(ILandroid/view/animation/Animation;)V

    const-string v0, "SortableListView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "item "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " set move down animation"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_ff
.end method


# virtual methods
.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .registers 7
    .parameter "canvas"

    .prologue
    const/4 v4, 0x0

    invoke-super {p0, p1}, Landroid/widget/ListView;->dispatchDraw(Landroid/graphics/Canvas;)V

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    if-ltz v2, :cond_85

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingY:I

    iget v3, p0, Landroid/widget/SortableListView;->mOffsetYInDraggingItem:I

    sub-int v1, v2, v3

    .local v1, offset:I
    invoke-virtual {p0}, Landroid/widget/SortableListView;->getHeaderViewsCount()I

    move-result v0

    .local v0, index:I
    invoke-virtual {p0}, Landroid/widget/SortableListView;->getFirstVisiblePosition()I

    move-result v2

    if-lt v0, v2, :cond_1e

    invoke-virtual {p0}, Landroid/widget/SortableListView;->getLastVisiblePosition()I

    move-result v2

    if-le v0, v2, :cond_22

    :cond_1e
    invoke-virtual {p0}, Landroid/widget/SortableListView;->getFirstVisiblePosition()I

    move-result v0

    :cond_22
    invoke-virtual {p0}, Landroid/widget/SortableListView;->getFirstVisiblePosition()I

    move-result v2

    sub-int/2addr v0, v2

    invoke-virtual {p0, v0}, Landroid/widget/SortableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getTop()I

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    invoke-virtual {p0}, Landroid/widget/SortableListView;->getCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p0}, Landroid/widget/SortableListView;->getFooterViewsCount()I

    move-result v3

    sub-int v0, v2, v3

    invoke-virtual {p0}, Landroid/widget/SortableListView;->getFirstVisiblePosition()I

    move-result v2

    if-lt v0, v2, :cond_4b

    invoke-virtual {p0}, Landroid/widget/SortableListView;->getLastVisiblePosition()I

    move-result v2

    if-le v0, v2, :cond_4f

    :cond_4b
    invoke-virtual {p0}, Landroid/widget/SortableListView;->getLastVisiblePosition()I

    move-result v0

    :cond_4f
    invoke-virtual {p0}, Landroid/widget/SortableListView;->getFirstVisiblePosition()I

    move-result v2

    sub-int/2addr v0, v2

    invoke-virtual {p0, v0}, Landroid/widget/SortableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getBottom()I

    move-result v2

    iget v3, p0, Landroid/widget/SortableListView;->mDraggingItemHeight:I

    sub-int/2addr v2, v3

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v1

    int-to-float v2, v1

    invoke-virtual {p1, v4, v2}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object v2, p0, Landroid/widget/SortableListView;->mSnapshotShadow:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    iget-object v2, p0, Landroid/widget/SortableListView;->mSnapshot:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v2, p1}, Landroid/graphics/drawable/BitmapDrawable;->draw(Landroid/graphics/Canvas;)V

    iget-object v2, p0, Landroid/widget/SortableListView;->mSnapshotBackgroundForOverUpperBound:Landroid/graphics/drawable/Drawable;

    if-eqz v2, :cond_80

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    iget v3, p0, Landroid/widget/SortableListView;->mItemUpperBound:I

    if-ge v2, v3, :cond_80

    iget-object v2, p0, Landroid/widget/SortableListView;->mSnapshotBackgroundForOverUpperBound:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    :cond_80
    neg-int v2, v1

    int-to-float v2, v2

    invoke-virtual {p1, v4, v2}, Landroid/graphics/Canvas;->translate(FF)V

    .end local v0           #index:I
    .end local v1           #offset:I
    :cond_85
    return-void
.end method

.method public getListenerForStartingSort()Landroid/view/View$OnTouchListener;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/widget/SortableListView;->mOnTouchListener:Landroid/view/View$OnTouchListener;

    return-object v0
.end method

.method obtainView(I[Z)Landroid/view/View;
    .registers 8
    .parameter "position"
    .parameter "isScrap"

    .prologue
    const/4 v4, 0x0

    invoke-super {p0, p1, p2}, Landroid/widget/ListView;->obtainView(I[Z)Landroid/view/View;

    move-result-object v1

    .local v1, view:Landroid/view/View;
    const/4 v0, 0x0

    .local v0, animation:Landroid/view/animation/Animation;
    iget v2, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    if-ne v2, p1, :cond_34

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingItemWidth:I

    iget v3, p0, Landroid/widget/SortableListView;->mDraggingItemWidth:I

    invoke-direct {p0, v2, v3, v4, v4}, Landroid/widget/SortableListView;->createAnimation(IIII)Landroid/view/animation/Animation;

    move-result-object v0

    const-string v2, "SortableListView"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "item "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " set move out animation"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_30
    :goto_30
    invoke-direct {p0, v1, v0}, Landroid/widget/SortableListView;->setViewAnimation(Landroid/view/View;Landroid/view/animation/Animation;)V

    return-object v1

    :cond_34
    iget v2, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    if-ge v2, p1, :cond_62

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    if-gt p1, v2, :cond_62

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingItemHeight:I

    neg-int v2, v2

    invoke-direct {p0, v4, v4, v4, v2}, Landroid/widget/SortableListView;->createAnimation(IIII)Landroid/view/animation/Animation;

    move-result-object v0

    const-string v2, "SortableListView"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "item "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " set move up animation"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_30

    :cond_62
    iget v2, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    if-le v2, p1, :cond_30

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    if-lt p1, v2, :cond_30

    iget v2, p0, Landroid/widget/SortableListView;->mDraggingItemHeight:I

    invoke-direct {p0, v4, v4, v4, v2}, Landroid/widget/SortableListView;->createAnimation(IIII)Landroid/view/animation/Animation;

    move-result-object v0

    const-string v2, "SortableListView"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "item "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " set move down animation"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_30
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 4
    .parameter "ev"

    .prologue
    const/4 v0, 0x1

    iget-boolean v1, p0, Landroid/widget/SortableListView;->mInterceptTouchForSorting:Z

    if-eqz v1, :cond_c

    invoke-virtual {p0, v0}, Landroid/widget/SortableListView;->requestDisallowInterceptTouchEvent(Z)V

    invoke-virtual {p0, p1}, Landroid/widget/SortableListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    :goto_b
    return v0

    :cond_c
    invoke-super {p0, p1}, Landroid/widget/ListView;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_b
.end method

.method protected onSizeChanged(IIII)V
    .registers 8
    .parameter "w"
    .parameter "h"
    .parameter "oldw"
    .parameter "oldh"

    .prologue
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ListView;->onSizeChanged(IIII)V

    const/4 v0, 0x1

    int-to-float v1, p2

    const/high16 v2, 0x3e80

    mul-float/2addr v1, v2

    float-to-int v1, v1

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    iput v0, p0, Landroid/widget/SortableListView;->mScrollBound:I

    iget v0, p0, Landroid/widget/SortableListView;->mScrollBound:I

    iput v0, p0, Landroid/widget/SortableListView;->mScrollUpperBound:I

    iget v0, p0, Landroid/widget/SortableListView;->mScrollBound:I

    sub-int v0, p2, v0

    iput v0, p0, Landroid/widget/SortableListView;->mScrollLowerBound:I

    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 11
    .parameter "ev"

    .prologue
    const/4 v8, -0x1

    iget-boolean v4, p0, Landroid/widget/SortableListView;->mInterceptTouchForSorting:Z

    if-nez v4, :cond_a

    invoke-super {p0, p1}, Landroid/widget/ListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v4

    :goto_9
    return v4

    :cond_a
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    and-int/lit16 v4, v4, 0xff

    packed-switch v4, :pswitch_data_ac

    :cond_13
    :goto_13
    :pswitch_13
    const/4 v4, 0x1

    goto :goto_9

    :pswitch_15
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    float-to-int v3, v4

    .local v3, y:I
    iget-boolean v4, p0, Landroid/widget/SortableListView;->mInterceptTouchForSorting:Z

    if-nez v4, :cond_22

    iget v4, p0, Landroid/widget/SortableListView;->mDraggingY:I

    if-eq v3, v4, :cond_13

    :cond_22
    invoke-direct {p0, p1}, Landroid/widget/SortableListView;->getHittenItemPosition(Landroid/view/MotionEvent;)I

    move-result v1

    .local v1, position:I
    invoke-virtual {p0}, Landroid/widget/SortableListView;->getHeaderViewsCount()I

    move-result v4

    if-lt v1, v4, :cond_37

    invoke-virtual {p0}, Landroid/widget/SortableListView;->getCount()I

    move-result v4

    invoke-virtual {p0}, Landroid/widget/SortableListView;->getFooterViewsCount()I

    move-result v5

    sub-int/2addr v4, v5

    if-le v1, v4, :cond_39

    :cond_37
    iget v1, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    :cond_39
    invoke-direct {p0, v1}, Landroid/widget/SortableListView;->updateDraggingToPisition(I)V

    iput v3, p0, Landroid/widget/SortableListView;->mDraggingY:I

    invoke-virtual {p0}, Landroid/widget/SortableListView;->invalidate()V

    const/4 v0, 0x0

    .local v0, delta:I
    iget v4, p0, Landroid/widget/SortableListView;->mScrollLowerBound:I

    if-le v3, v4, :cond_66

    iget v4, p0, Landroid/widget/SortableListView;->mScrollLowerBound:I

    sub-int/2addr v4, v3

    mul-int/lit8 v4, v4, 0x10

    iget v5, p0, Landroid/widget/SortableListView;->mScrollBound:I

    div-int v0, v4, v5

    :cond_4f
    :goto_4f
    if-eqz v0, :cond_13

    invoke-virtual {p0}, Landroid/widget/SortableListView;->getFirstVisiblePosition()I

    move-result v4

    sub-int v4, v1, v4

    invoke-virtual {p0, v4}, Landroid/widget/SortableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .local v2, v:Landroid/view/View;
    if-eqz v2, :cond_13

    invoke-virtual {v2}, Landroid/view/View;->getTop()I

    move-result v4

    add-int/2addr v4, v0

    invoke-virtual {p0, v1, v4}, Landroid/widget/SortableListView;->setSelectionFromTop(II)V

    goto :goto_13

    .end local v2           #v:Landroid/view/View;
    :cond_66
    iget v4, p0, Landroid/widget/SortableListView;->mScrollUpperBound:I

    if-ge v3, v4, :cond_4f

    iget v4, p0, Landroid/widget/SortableListView;->mScrollUpperBound:I

    sub-int/2addr v4, v3

    mul-int/lit8 v4, v4, 0x10

    iget v5, p0, Landroid/widget/SortableListView;->mScrollBound:I

    div-int v0, v4, v5

    goto :goto_4f

    .end local v0           #delta:I
    .end local v1           #position:I
    .end local v3           #y:I
    :pswitch_74
    iget v4, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    if-ltz v4, :cond_99

    iget-object v4, p0, Landroid/widget/SortableListView;->mOnOrderChangedListener:Landroid/widget/SortableListView$OnOrderChangedListener;

    if-eqz v4, :cond_a5

    iget v4, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    iget v5, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    if-eq v4, v5, :cond_a5

    iget v4, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    if-ltz v4, :cond_a5

    iget-object v4, p0, Landroid/widget/SortableListView;->mOnOrderChangedListener:Landroid/widget/SortableListView$OnOrderChangedListener;

    iget v5, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    invoke-virtual {p0}, Landroid/widget/SortableListView;->getHeaderViewsCount()I

    move-result v6

    sub-int/2addr v5, v6

    iget v6, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    invoke-virtual {p0}, Landroid/widget/SortableListView;->getHeaderViewsCount()I

    move-result v7

    sub-int/2addr v6, v7

    invoke-interface {v4, v5, v6}, Landroid/widget/SortableListView$OnOrderChangedListener;->OnOrderChanged(II)V

    :cond_99
    :goto_99
    const/4 v4, 0x0

    iput-boolean v4, p0, Landroid/widget/SortableListView;->mInterceptTouchForSorting:Z

    iput v8, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    iput v8, p0, Landroid/widget/SortableListView;->mDraggingTo:I

    invoke-virtual {p0}, Landroid/widget/SortableListView;->invalidate()V

    goto/16 :goto_13

    :cond_a5
    iget v4, p0, Landroid/widget/SortableListView;->mDraggingFrom:I

    const/4 v5, 0x0

    invoke-direct {p0, v4, v5}, Landroid/widget/SortableListView;->setViewAnimationByPisition(ILandroid/view/animation/Animation;)V

    goto :goto_99

    :pswitch_data_ac
    .packed-switch 0x1
        :pswitch_74
        :pswitch_15
        :pswitch_74
        :pswitch_13
        :pswitch_74
    .end packed-switch
.end method

.method public setItemUpperBound(ILandroid/graphics/drawable/Drawable;)V
    .registers 3
    .parameter "upper"
    .parameter "snapshotShadow"

    .prologue
    iput p1, p0, Landroid/widget/SortableListView;->mItemUpperBound:I

    iput-object p2, p0, Landroid/widget/SortableListView;->mSnapshotBackgroundForOverUpperBound:Landroid/graphics/drawable/Drawable;

    return-void
.end method

.method public setOnOrderChangedListener(Landroid/widget/SortableListView$OnOrderChangedListener;)V
    .registers 2
    .parameter "l"

    .prologue
    iput-object p1, p0, Landroid/widget/SortableListView;->mOnOrderChangedListener:Landroid/widget/SortableListView$OnOrderChangedListener;

    return-void
.end method
