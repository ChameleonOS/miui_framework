.class Landroid/widget/SortableListView$1;
.super Ljava/lang/Object;
.source "SortableListView.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/widget/SortableListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/SortableListView;


# direct methods
.method constructor <init>(Landroid/widget/SortableListView;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .registers 14
    .parameter "v"
    .parameter "event"

    .prologue
    const/16 v8, 0x99

    const/4 v7, 0x1

    const/4 v10, 0x0

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mOnOrderChangedListener:Landroid/widget/SortableListView$OnOrderChangedListener;
    invoke-static {v4}, Landroid/widget/SortableListView;->access$000(Landroid/widget/SortableListView;)Landroid/widget/SortableListView$OnOrderChangedListener;

    move-result-object v4

    if-eqz v4, :cond_125

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    and-int/lit16 v4, v4, 0xff

    if-nez v4, :cond_125

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #calls: Landroid/widget/SortableListView;->getHittenItemPosition(Landroid/view/MotionEvent;)I
    invoke-static {v4, p2}, Landroid/widget/SortableListView;->access$100(Landroid/widget/SortableListView;Landroid/view/MotionEvent;)I

    move-result v1

    .local v1, position:I
    if-ltz v1, :cond_125

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #setter for: Landroid/widget/SortableListView;->mDraggingFrom:I
    invoke-static {v4, v1}, Landroid/widget/SortableListView;->access$202(Landroid/widget/SortableListView;I)I

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #setter for: Landroid/widget/SortableListView;->mDraggingTo:I
    invoke-static {v4, v1}, Landroid/widget/SortableListView;->access$302(Landroid/widget/SortableListView;I)I

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #setter for: Landroid/widget/SortableListView;->mInterceptTouchForSorting:Z
    invoke-static {v4, v7}, Landroid/widget/SortableListView;->access$402(Landroid/widget/SortableListView;Z)Z

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    iget-object v5, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    invoke-virtual {v5}, Landroid/widget/SortableListView;->getFirstVisiblePosition()I

    move-result v5

    sub-int v5, v1, v5

    invoke-virtual {v4, v5}, Landroid/widget/SortableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .local v3, view:Landroid/view/View;
    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    invoke-virtual {v3}, Landroid/view/View;->getWidth()I

    move-result v5

    #setter for: Landroid/widget/SortableListView;->mDraggingItemWidth:I
    invoke-static {v4, v5}, Landroid/widget/SortableListView;->access$502(Landroid/widget/SortableListView;I)I

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    invoke-virtual {v3}, Landroid/view/View;->getHeight()I

    move-result v5

    #setter for: Landroid/widget/SortableListView;->mDraggingItemHeight:I
    invoke-static {v4, v5}, Landroid/widget/SortableListView;->access$602(Landroid/widget/SortableListView;I)I

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    iget-object v5, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mTmpLocation:[I
    invoke-static {v5}, Landroid/widget/SortableListView;->access$700(Landroid/widget/SortableListView;)[I

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/SortableListView;->getLocationOnScreen([I)V

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getRawY()F

    move-result v5

    float-to-int v5, v5

    iget-object v6, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mTmpLocation:[I
    invoke-static {v6}, Landroid/widget/SortableListView;->access$700(Landroid/widget/SortableListView;)[I

    move-result-object v6

    aget v6, v6, v7

    sub-int/2addr v5, v6

    #setter for: Landroid/widget/SortableListView;->mDraggingY:I
    invoke-static {v4, v5}, Landroid/widget/SortableListView;->access$802(Landroid/widget/SortableListView;I)I

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    iget-object v5, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mDraggingY:I
    invoke-static {v5}, Landroid/widget/SortableListView;->access$800(Landroid/widget/SortableListView;)I

    move-result v5

    invoke-virtual {v3}, Landroid/view/View;->getTop()I

    move-result v6

    sub-int/2addr v5, v6

    #setter for: Landroid/widget/SortableListView;->mOffsetYInDraggingItem:I
    invoke-static {v4, v5}, Landroid/widget/SortableListView;->access$902(Landroid/widget/SortableListView;I)I

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mDraggingItemWidth:I
    invoke-static {v4}, Landroid/widget/SortableListView;->access$500(Landroid/widget/SortableListView;)I

    move-result v4

    iget-object v5, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mDraggingItemHeight:I
    invoke-static {v5}, Landroid/widget/SortableListView;->access$600(Landroid/widget/SortableListView;)I

    move-result v5

    sget-object v6, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v4, v5, v6}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v2

    .local v2, snapshot:Landroid/graphics/Bitmap;
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, v2}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .local v0, canvas:Landroid/graphics/Canvas;
    invoke-virtual {v3, v0}, Landroid/view/View;->draw(Landroid/graphics/Canvas;)V

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    new-instance v5, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v6, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    invoke-virtual {v6}, Landroid/widget/SortableListView;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-direct {v5, v6, v2}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    #setter for: Landroid/widget/SortableListView;->mSnapshot:Landroid/graphics/drawable/BitmapDrawable;
    invoke-static {v4, v5}, Landroid/widget/SortableListView;->access$1002(Landroid/widget/SortableListView;Landroid/graphics/drawable/BitmapDrawable;)Landroid/graphics/drawable/BitmapDrawable;

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mSnapshot:Landroid/graphics/drawable/BitmapDrawable;
    invoke-static {v4}, Landroid/widget/SortableListView;->access$1000(Landroid/widget/SortableListView;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v4

    invoke-virtual {v4, v8}, Landroid/graphics/drawable/BitmapDrawable;->setAlpha(I)V

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mSnapshot:Landroid/graphics/drawable/BitmapDrawable;
    invoke-static {v4}, Landroid/widget/SortableListView;->access$1000(Landroid/widget/SortableListView;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v4

    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v5

    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v6

    iget-object v7, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mDraggingItemHeight:I
    invoke-static {v7}, Landroid/widget/SortableListView;->access$600(Landroid/widget/SortableListView;)I

    move-result v7

    invoke-virtual {v4, v5, v10, v6, v7}, Landroid/graphics/drawable/BitmapDrawable;->setBounds(IIII)V

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mSnapshotBackgroundForOverUpperBound:Landroid/graphics/drawable/Drawable;
    invoke-static {v4}, Landroid/widget/SortableListView;->access$1100(Landroid/widget/SortableListView;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    if-eqz v4, :cond_eb

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mSnapshotBackgroundForOverUpperBound:Landroid/graphics/drawable/Drawable;
    invoke-static {v4}, Landroid/widget/SortableListView;->access$1100(Landroid/widget/SortableListView;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v4, v8}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mSnapshotBackgroundForOverUpperBound:Landroid/graphics/drawable/Drawable;
    invoke-static {v4}, Landroid/widget/SortableListView;->access$1100(Landroid/widget/SortableListView;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v5

    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v6

    iget-object v7, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mDraggingItemHeight:I
    invoke-static {v7}, Landroid/widget/SortableListView;->access$600(Landroid/widget/SortableListView;)I

    move-result v7

    invoke-virtual {v4, v5, v10, v6, v7}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    :cond_eb
    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mSnapshotShadow:Landroid/graphics/drawable/Drawable;
    invoke-static {v4}, Landroid/widget/SortableListView;->access$1400(Landroid/widget/SortableListView;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v3}, Landroid/view/View;->getLeft()I

    move-result v5

    iget-object v6, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mSnapshotShadowPaddingTop:I
    invoke-static {v6}, Landroid/widget/SortableListView;->access$1200(Landroid/widget/SortableListView;)I

    move-result v6

    neg-int v6, v6

    invoke-virtual {v3}, Landroid/view/View;->getRight()I

    move-result v7

    iget-object v8, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mDraggingItemHeight:I
    invoke-static {v8}, Landroid/widget/SortableListView;->access$600(Landroid/widget/SortableListView;)I

    move-result v8

    iget-object v9, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mSnapshotShadowPaddingBottom:I
    invoke-static {v9}, Landroid/widget/SortableListView;->access$1300(Landroid/widget/SortableListView;)I

    move-result v9

    add-int/2addr v8, v9

    invoke-virtual {v4, v5, v6, v7, v8}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    iget-object v5, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mDraggingItemWidth:I
    invoke-static {v5}, Landroid/widget/SortableListView;->access$500(Landroid/widget/SortableListView;)I

    move-result v5

    iget-object v6, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mDraggingItemWidth:I
    invoke-static {v6}, Landroid/widget/SortableListView;->access$500(Landroid/widget/SortableListView;)I

    move-result v6

    #calls: Landroid/widget/SortableListView;->createAnimation(IIII)Landroid/view/animation/Animation;
    invoke-static {v4, v5, v6, v10, v10}, Landroid/widget/SortableListView;->access$1500(Landroid/widget/SortableListView;IIII)Landroid/view/animation/Animation;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .end local v0           #canvas:Landroid/graphics/Canvas;
    .end local v1           #position:I
    .end local v2           #snapshot:Landroid/graphics/Bitmap;
    .end local v3           #view:Landroid/view/View;
    :cond_125
    iget-object v4, p0, Landroid/widget/SortableListView$1;->this$0:Landroid/widget/SortableListView;

    #getter for: Landroid/widget/SortableListView;->mInterceptTouchForSorting:Z
    invoke-static {v4}, Landroid/widget/SortableListView;->access$400(Landroid/widget/SortableListView;)Z

    move-result v4

    return v4
.end method
