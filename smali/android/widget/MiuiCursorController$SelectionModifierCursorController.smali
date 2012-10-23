.class public Landroid/widget/MiuiCursorController$SelectionModifierCursorController;
.super Landroid/widget/MiuiCursorController;
.source "MiuiCursorController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/MiuiCursorController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SelectionModifierCursorController"
.end annotation


# instance fields
.field private mCoords:[I

.field private mCoords1:[I

.field private mCoords2:[I

.field private mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

.field mHideInvisiblePanel:Z

.field private mIsShowing:Z

.field private mMaxTouchOffset:I

.field private mMinTouchOffset:I

.field private mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

.field private mPreviousTapPositionX:F

.field private mPreviousTapPositionY:F

.field private mPreviousTapUpTime:J

.field private mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

.field private mTouchOnHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;


# direct methods
.method constructor <init>(Landroid/widget/Editor;Landroid/content/Context;)V
    .registers 7
    .parameter "owner"
    .parameter "context"

    .prologue
    const/4 v3, 0x2

    .line 548
    invoke-direct {p0, p1, p2}, Landroid/widget/MiuiCursorController;-><init>(Landroid/widget/Editor;Landroid/content/Context;)V

    .line 534
    const-wide/16 v1, 0x0

    iput-wide v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapUpTime:J

    .line 538
    new-array v1, v3, [I

    iput-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords1:[I

    .line 539
    new-array v1, v3, [I

    iput-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords2:[I

    .line 541
    new-array v1, v3, [I

    iput-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords:[I

    .line 545
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mHideInvisiblePanel:Z

    .line 549
    iget-object v1, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    const/4 v2, 0x1

    invoke-virtual {p0, v1, v2, p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->initHandleView(Landroid/widget/Editor;ILandroid/widget/MiuiCursorController;)Landroid/widget/MiuiCursorController$MiuiHandleView;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    .line 550
    iget-object v1, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {p0, v1, v3, p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->initHandleView(Landroid/widget/Editor;ILandroid/widget/MiuiCursorController;)Landroid/widget/MiuiCursorController$MiuiHandleView;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    .line 551
    const v1, 0x6030032

    invoke-virtual {p0, v1}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->createFloatPanelViewController(I)Landroid/widget/MiuiCursorController$FloatPanelViewController;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    .line 552
    new-instance v0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController$1;

    invoke-direct {v0, p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController$1;-><init>(Landroid/widget/MiuiCursorController$SelectionModifierCursorController;)V

    .line 559
    .local v0, l:Landroid/view/View$OnClickListener;
    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b0015

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    .line 560
    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b0016

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    .line 561
    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b0017

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    .line 562
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->resetTouchOffsets()V

    .line 563
    return-void
.end method

.method static synthetic access$200(Landroid/widget/MiuiCursorController$SelectionModifierCursorController;)Landroid/widget/MiuiCursorController$FloatPanelViewController;
    .registers 2
    .parameter "x0"

    .prologue
    .line 524
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    return-object v0
.end method


# virtual methods
.method public addClipData(Landroid/content/ClipboardManager;Landroid/content/ClipData;Ljava/lang/CharSequence;)V
    .registers 9
    .parameter "clipboard"
    .parameter "data"
    .parameter "selected"

    .prologue
    const/4 v3, 0x0

    .line 797
    if-nez p2, :cond_b

    .line 798
    invoke-static {v3, p3}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    .line 807
    :goto_a
    return-void

    .line 800
    :cond_b
    invoke-static {v3, p3}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v2

    .line 801
    .local v2, newdata:Landroid/content/ClipData;
    invoke-virtual {p2}, Landroid/content/ClipData;->getItemCount()I

    move-result v3

    const/4 v4, 0x2

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 802
    .local v0, historyCount:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_19
    if-ge v1, v0, :cond_25

    .line 803
    invoke-virtual {p2, v1}, Landroid/content/ClipData;->getItemAt(I)Landroid/content/ClipData$Item;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/ClipData;->addItem(Landroid/content/ClipData$Item;)V

    .line 802
    add-int/lit8 v1, v1, 0x1

    goto :goto_19

    .line 805
    :cond_25
    invoke-virtual {p1, v2}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    goto :goto_a
.end method

.method public computePanelPosition([I)V
    .registers 6
    .parameter "pos"

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 587
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_18

    .line 588
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords1:[I

    invoke-virtual {v0, v1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getHotspotLocationOnScreen([I)V

    .line 589
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords2:[I

    invoke-virtual {v0, v1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getHotspotLocationOnScreen([I)V

    .line 591
    :cond_18
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords1:[I

    aget v0, v0, v3

    aput v0, p1, v3

    .line 593
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords1:[I

    aget v0, v0, v3

    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords2:[I

    aget v1, v1, v3

    if-ne v0, v1, :cond_36

    .line 594
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords1:[I

    aget v0, v0, v2

    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords2:[I

    aget v1, v1, v2

    add-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x2

    aput v0, p1, v2

    .line 599
    :goto_35
    return-void

    .line 596
    :cond_36
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords:[I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->getLocationOnScreen([I)V

    .line 597
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords:[I

    aget v0, v0, v2

    iget-object v1, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    add-int/2addr v0, v1

    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords1:[I

    aget v1, v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    aput v0, p1, v2

    goto :goto_35
.end method

.method public computePanelPositionOnBottom()I
    .registers 7

    .prologue
    const/4 v5, 0x1

    .line 603
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v3}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v3

    if-eqz v3, :cond_17

    .line 604
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    iget-object v4, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords2:[I

    invoke-virtual {v3, v4}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getHotspotLocationOnScreen([I)V

    .line 605
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    iget-object v4, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords:[I

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->getLocationOnScreen([I)V

    .line 607
    :cond_17
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords:[I

    aget v3, v3, v5

    iget-object v4, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getHeight()I

    move-result v4

    add-int v2, v3, v4

    .line 608
    .local v2, maxBottom:I
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x60a0004

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 610
    .local v1, handleHeight:I
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords2:[I

    aget v3, v3, v5

    add-int v0, v3, v1

    .line 611
    .local v0, endHandleBottom:I
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v3}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v3

    if-eqz v3, :cond_44

    add-int v3, v2, v1

    invoke-static {v0, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    .end local v2           #maxBottom:I
    :cond_44
    return v2
.end method

.method public getMaxTouchOffset()I
    .registers 2

    .prologue
    .line 768
    iget v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMaxTouchOffset:I

    return v0
.end method

.method public getMinTouchOffset()I
    .registers 2

    .prologue
    .line 764
    iget v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMinTouchOffset:I

    return v0
.end method

.method public hide()V
    .registers 2

    .prologue
    .line 616
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->hide()V

    .line 617
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->hide()V

    .line 618
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    .line 619
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mIsShowing:Z

    .line 620
    return-void
.end method

.method public isSelectionStartDragged()Z
    .registers 2

    .prologue
    .line 777
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    if-eqz v0, :cond_e

    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isDragging()Z

    move-result v0

    if-eqz v0, :cond_e

    const/4 v0, 0x1

    :goto_d
    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_d
.end method

.method public isShowing()Z
    .registers 2

    .prologue
    .line 623
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mIsShowing:Z

    return v0
.end method

.method public onHandleTouchEvent(Landroid/widget/MiuiCursorController$MiuiHandleView;Landroid/view/MotionEvent;)Z
    .registers 4
    .parameter "handle"
    .parameter "ev"

    .prologue
    .line 782
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    packed-switch v0, :pswitch_data_1e

    .line 793
    :cond_7
    :goto_7
    const/4 v0, 0x0

    return v0

    .line 784
    :pswitch_9
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    goto :goto_7

    .line 788
    :pswitch_f
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 789
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    goto :goto_7

    .line 782
    nop

    :pswitch_data_1e
    .packed-switch 0x1
        :pswitch_9
        :pswitch_f
    .end packed-switch
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 16
    .parameter "event"

    .prologue
    const/4 v1, 0x1

    .line 665
    const/4 v9, 0x0

    .line 667
    .local v9, handled:Z
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v7

    .line 669
    .local v7, action:I
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mTouchOnHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    if-eqz v0, :cond_32

    .line 670
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mTouchOnHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0, p1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 672
    if-eq v7, v1, :cond_14

    const/4 v0, 0x3

    if-ne v7, v0, :cond_30

    .line 673
    :cond_14
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mTouchOnHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    .line 674
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_29

    .line 675
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 677
    :cond_29
    const-string v0, "MiuiCursorController"

    const-string v2, "action UP or Cancel to stop moving event to HandleView"

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    :cond_30
    move v0, v1

    .line 760
    :goto_31
    return v0

    .line 684
    :cond_32
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_bc

    if-nez v7, :cond_bc

    .line 685
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v3

    .line 686
    .local v3, x:F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v4

    .line 687
    .local v4, y:F
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0, v3, v4}, Landroid/widget/MiuiCursorController$MiuiHandleView;->inRecRange(FF)Z

    move-result v13

    .line 688
    .local v13, si:Z
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0, v3, v4}, Landroid/widget/MiuiCursorController$MiuiHandleView;->inRecRange(FF)Z

    move-result v8

    .line 689
    .local v8, ei:Z
    const-string v0, "MiuiCursorController"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Touch in handleview: startHandleView="

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, " endHandleView="

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 691
    if-eqz v13, :cond_ae

    if-eqz v8, :cond_ae

    .line 692
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0, v3, v4}, Landroid/widget/MiuiCursorController$MiuiHandleView;->distance(FF)F

    move-result v0

    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v2, v3, v4}, Landroid/widget/MiuiCursorController$MiuiHandleView;->distance(FF)F

    move-result v2

    cmpl-float v0, v0, v2

    if-lez v0, :cond_ab

    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    :goto_86
    iput-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mTouchOnHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    .line 702
    :cond_88
    :goto_88
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mTouchOnHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    if-eqz v0, :cond_bc

    .line 703
    const-string v0, "MiuiCursorController"

    const-string v2, "Touch near handle and move event to HandleView"

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 704
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_a4

    .line 705
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    invoke-interface {v0, v1}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 707
    :cond_a4
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mTouchOnHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0, p1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move v0, v1

    .line 708
    goto :goto_31

    .line 692
    :cond_ab
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    goto :goto_86

    .line 695
    :cond_ae
    if-eqz v13, :cond_b5

    .line 696
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    iput-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mTouchOnHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    goto :goto_88

    .line 698
    :cond_b5
    if-eqz v8, :cond_88

    .line 699
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    iput-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mTouchOnHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    goto :goto_88

    .line 714
    .end local v3           #x:F
    .end local v4           #y:F
    .end local v8           #ei:Z
    .end local v13           #si:Z
    :cond_bc
    packed-switch v7, :pswitch_data_146

    .line 753
    :cond_bf
    :goto_bf
    :pswitch_bf
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->hasMagnifierController()Z

    move-result v0

    if-eqz v0, :cond_d1

    .line 754
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->getMagnifierController()Landroid/widget/MagnifierController;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/MagnifierController;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v9

    .line 756
    :cond_d1
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->hasInsertionController()Z

    move-result v0

    if-eqz v0, :cond_e2

    .line 757
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->getInsertionController()Landroid/widget/MiuiCursorController;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/MiuiCursorController;->onTouchEvent(Landroid/view/MotionEvent;)Z

    :cond_e2
    move v0, v9

    .line 760
    goto/16 :goto_31

    .line 716
    :pswitch_e5
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    .line 717
    .restart local v3       #x:F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    .line 719
    .restart local v4       #y:F
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0, v3, v4}, Landroid/widget/TextView;->getOffsetForPosition(FF)I

    move-result v0

    iput v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMaxTouchOffset:I

    iput v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMinTouchOffset:I

    .line 720
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    iget-wide v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapUpTime:J

    iget v5, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapPositionX:F

    iget v6, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapPositionY:F

    invoke-virtual/range {v0 .. v6}, Landroid/widget/Editor;->startTextSelectionModeIfDouleTap(JFFFF)V

    .line 721
    iput v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapPositionX:F

    .line 722
    iput v4, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapPositionY:F

    goto :goto_bf

    .line 729
    .end local v3           #x:F
    .end local v4           #y:F
    :pswitch_107
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const-string v1, "android.hardware.touchscreen.multitouch.distinct"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_bf

    .line 731
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v12

    .line 732
    .local v12, pointerCount:I
    const/4 v10, 0x0

    .local v10, index:I
    :goto_11a
    if-ge v10, v12, :cond_bf

    .line 733
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->getX(I)F

    move-result v1

    invoke-virtual {p1, v10}, Landroid/view/MotionEvent;->getY(I)F

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/widget/TextView;->getOffsetForPosition(FF)I

    move-result v11

    .line 734
    .local v11, offset:I
    iget v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMinTouchOffset:I

    if-ge v11, v0, :cond_130

    .line 735
    iput v11, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMinTouchOffset:I

    .line 736
    :cond_130
    iget v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMaxTouchOffset:I

    if-le v11, v0, :cond_136

    .line 737
    iput v11, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMaxTouchOffset:I

    .line 732
    :cond_136
    add-int/lit8 v10, v10, 0x1

    goto :goto_11a

    .line 743
    .end local v10           #index:I
    .end local v11           #offset:I
    .end local v12           #pointerCount:I
    :pswitch_139
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->onTapUpEvent()V

    .line 744
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapUpTime:J

    goto/16 :goto_bf

    .line 714
    :pswitch_data_146
    .packed-switch 0x0
        :pswitch_e5
        :pswitch_139
        :pswitch_bf
        :pswitch_bf
        :pswitch_bf
        :pswitch_107
        :pswitch_107
    .end packed-switch
.end method

.method public resetTouchOffsets()V
    .registers 2

    .prologue
    .line 772
    const/4 v0, -0x1

    iput v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMaxTouchOffset:I

    iput v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMinTouchOffset:I

    .line 773
    return-void
.end method

.method public setMinMaxOffset(I)V
    .registers 2
    .parameter "offset"

    .prologue
    .line 810
    iput p1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMaxTouchOffset:I

    iput p1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMinTouchOffset:I

    .line 811
    return-void
.end method

.method public show()V
    .registers 6

    .prologue
    .line 566
    const-string v3, "MiuiCursorController"

    const-string v4, "SelectionModifierCursorController is shown"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 567
    const/4 v3, 0x0

    iput-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mTouchOnHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    .line 569
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->isInBatchEditMode()Z

    move-result v3

    if-eqz v3, :cond_13

    .line 584
    :goto_12
    return-void

    .line 572
    :cond_13
    const-string v3, "MiuiCursorController"

    const-string v4, "SelectionModifierCursorController is shown and hide InsertionPointCursorController"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 573
    const/4 v3, 0x1

    iput-boolean v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mIsShowing:Z

    .line 574
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v3}, Landroid/widget/MiuiCursorController$MiuiHandleView;->show()V

    .line 575
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v3}, Landroid/widget/MiuiCursorController$MiuiHandleView;->show()V

    .line 576
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->updatePosition()V

    .line 578
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v3}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    .line 579
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v3}, Landroid/widget/Editor;->hideInsertionPointCursorControllerWrap()V

    .line 580
    const/4 v3, 0x3

    new-array v0, v3, [I

    fill-array-data v0, :array_4c

    .line 581
    .local v0, buttons:[I
    const/4 v3, 0x2

    new-array v1, v3, [I

    fill-array-data v1, :array_56

    .line 582
    .local v1, separators:[I
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v3, v0}, Landroid/widget/Editor;->getFloatPanelShowHides([I)Ljava/util/ArrayList;

    move-result-object v2

    .line 583
    .local v2, showHides:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/Boolean;>;"
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v3, v0, v1, v2}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showHideButtons([I[ILjava/util/ArrayList;)V

    goto :goto_12

    .line 580
    :array_4c
    .array-data 0x4
        0x15t 0x0t 0xbt 0x6t
        0x16t 0x0t 0xbt 0x6t
        0x17t 0x0t 0xbt 0x6t
    .end array-data

    .line 581
    :array_56
    .array-data 0x4
        0x1ct 0x0t 0xbt 0x6t
        0x1dt 0x0t 0xbt 0x6t
    .end array-data
.end method

.method public updatePosition()V
    .registers 5

    .prologue
    const/4 v3, 0x1

    .line 627
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->isShowing()Z

    move-result v2

    if-nez v2, :cond_8

    .line 662
    :cond_7
    :goto_7
    return-void

    .line 631
    :cond_8
    iget-object v2, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getSelectionStart()I

    move-result v1

    .line 632
    .local v1, selectionStart:I
    iget-object v2, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getSelectionEnd()I

    move-result v0

    .line 634
    .local v0, selectionEnd:I
    if-ltz v1, :cond_18

    if-gez v0, :cond_23

    .line 636
    :cond_18
    const-string v2, "MiuiCursorController"

    const-string v3, "Update selection controller position called with no cursor"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 637
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->hide()V

    goto :goto_7

    .line 642
    :cond_23
    if-ne v1, v0, :cond_29

    .line 643
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->hide()V

    goto :goto_7

    .line 647
    :cond_29
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v2, v1, v3}, Landroid/widget/MiuiCursorController$MiuiHandleView;->positionAtCursorOffset(IZ)V

    .line 648
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v2, v0, v3}, Landroid/widget/MiuiCursorController$MiuiHandleView;->positionAtCursorOffset(IZ)V

    .line 650
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v2}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v2

    if-nez v2, :cond_43

    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v2}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v2

    if-eqz v2, :cond_58

    .line 651
    :cond_43
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v2}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v2

    if-nez v2, :cond_4f

    iget-boolean v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mHideInvisiblePanel:Z

    if-eqz v2, :cond_7

    .line 652
    :cond_4f
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v2}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    .line 653
    const/4 v2, 0x0

    iput-boolean v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mHideInvisiblePanel:Z

    goto :goto_7

    .line 657
    :cond_58
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v2}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v2

    if-eqz v2, :cond_7

    .line 658
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v2}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    .line 659
    iput-boolean v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mHideInvisiblePanel:Z

    goto :goto_7
.end method
