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


# direct methods
.method constructor <init>(Landroid/widget/Editor;Landroid/content/Context;)V
    .registers 7
    .parameter "owner"
    .parameter "context"

    .prologue
    const/4 v3, 0x2

    .line 546
    invoke-direct {p0, p1, p2}, Landroid/widget/MiuiCursorController;-><init>(Landroid/widget/Editor;Landroid/content/Context;)V

    .line 532
    const-wide/16 v1, 0x0

    iput-wide v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapUpTime:J

    .line 536
    new-array v1, v3, [I

    iput-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords1:[I

    .line 537
    new-array v1, v3, [I

    iput-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords2:[I

    .line 539
    new-array v1, v3, [I

    iput-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords:[I

    .line 543
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mHideInvisiblePanel:Z

    .line 547
    iget-object v1, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    const/4 v2, 0x1

    invoke-virtual {p0, v1, v2, p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->initHandleView(Landroid/widget/Editor;ILandroid/widget/MiuiCursorController;)Landroid/widget/MiuiCursorController$MiuiHandleView;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    .line 548
    iget-object v1, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {p0, v1, v3, p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->initHandleView(Landroid/widget/Editor;ILandroid/widget/MiuiCursorController;)Landroid/widget/MiuiCursorController$MiuiHandleView;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    .line 549
    const v1, 0x6030032

    invoke-virtual {p0, v1}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->createFloatPanelViewController(I)Landroid/widget/MiuiCursorController$FloatPanelViewController;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    .line 550
    new-instance v0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController$1;

    invoke-direct {v0, p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController$1;-><init>(Landroid/widget/MiuiCursorController$SelectionModifierCursorController;)V

    .line 557
    .local v0, l:Landroid/view/View$OnClickListener;
    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b0015

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    .line 558
    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b0016

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    .line 559
    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b0017

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    .line 560
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->resetTouchOffsets()V

    .line 561
    return-void
.end method

.method static synthetic access$200(Landroid/widget/MiuiCursorController$SelectionModifierCursorController;)Landroid/widget/MiuiCursorController$FloatPanelViewController;
    .registers 2
    .parameter "x0"

    .prologue
    .line 523
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

    .line 748
    if-nez p2, :cond_b

    .line 749
    invoke-static {v3, p3}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    .line 758
    :goto_a
    return-void

    .line 751
    :cond_b
    invoke-static {v3, p3}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v2

    .line 752
    .local v2, newdata:Landroid/content/ClipData;
    invoke-virtual {p2}, Landroid/content/ClipData;->getItemCount()I

    move-result v3

    const/4 v4, 0x2

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 753
    .local v0, historyCount:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_19
    if-ge v1, v0, :cond_25

    .line 754
    invoke-virtual {p2, v1}, Landroid/content/ClipData;->getItemAt(I)Landroid/content/ClipData$Item;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/ClipData;->addItem(Landroid/content/ClipData$Item;)V

    .line 753
    add-int/lit8 v1, v1, 0x1

    goto :goto_19

    .line 756
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

    .line 584
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_18

    .line 585
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords1:[I

    invoke-virtual {v0, v1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getHotspotLocationOnScreen([I)V

    .line 586
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords2:[I

    invoke-virtual {v0, v1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getHotspotLocationOnScreen([I)V

    .line 588
    :cond_18
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords1:[I

    aget v0, v0, v3

    aput v0, p1, v3

    .line 590
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords1:[I

    aget v0, v0, v3

    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords2:[I

    aget v1, v1, v3

    if-ne v0, v1, :cond_36

    .line 591
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords1:[I

    aget v0, v0, v2

    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords2:[I

    aget v1, v1, v2

    add-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x2

    aput v0, p1, v2

    .line 596
    :goto_35
    return-void

    .line 593
    :cond_36
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords:[I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->getLocationOnScreen([I)V

    .line 594
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

    .line 600
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v3}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v3

    if-eqz v3, :cond_17

    .line 601
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    iget-object v4, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords2:[I

    invoke-virtual {v3, v4}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getHotspotLocationOnScreen([I)V

    .line 602
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    iget-object v4, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords:[I

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->getLocationOnScreen([I)V

    .line 604
    :cond_17
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords:[I

    aget v3, v3, v5

    iget-object v4, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getHeight()I

    move-result v4

    add-int v2, v3, v4

    .line 605
    .local v2, maxBottom:I
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x60a0004

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 607
    .local v1, handleHeight:I
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mCoords2:[I

    aget v3, v3, v5

    add-int v0, v3, v1

    .line 608
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
    .line 719
    iget v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMaxTouchOffset:I

    return v0
.end method

.method public getMinTouchOffset()I
    .registers 2

    .prologue
    .line 715
    iget v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMinTouchOffset:I

    return v0
.end method

.method public hide()V
    .registers 2

    .prologue
    .line 613
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->hide()V

    .line 614
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->hide()V

    .line 615
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    .line 616
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mIsShowing:Z

    .line 617
    return-void
.end method

.method public isSelectionStartDragged()Z
    .registers 2

    .prologue
    .line 728
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
    .line 620
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mIsShowing:Z

    return v0
.end method

.method public onHandleTouchEvent(Landroid/widget/MiuiCursorController$MiuiHandleView;Landroid/view/MotionEvent;)Z
    .registers 4
    .parameter "handle"
    .parameter "ev"

    .prologue
    .line 733
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    packed-switch v0, :pswitch_data_1e

    .line 744
    :cond_7
    :goto_7
    const/4 v0, 0x0

    return v0

    .line 735
    :pswitch_9
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    goto :goto_7

    .line 739
    :pswitch_f
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 740
    iget-object v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    goto :goto_7

    .line 733
    nop

    :pswitch_data_1e
    .packed-switch 0x1
        :pswitch_9
        :pswitch_f
    .end packed-switch
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 13
    .parameter "event"

    .prologue
    .line 662
    const/4 v7, 0x0

    .line 665
    .local v7, handled:Z
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    packed-switch v0, :pswitch_data_8e

    .line 704
    :cond_8
    :goto_8
    :pswitch_8
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->hasMagnifierController()Z

    move-result v0

    if-eqz v0, :cond_1a

    .line 705
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->getMagnifierController()Landroid/widget/MagnifierController;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/MagnifierController;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v7

    .line 707
    :cond_1a
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->hasInsertionController()Z

    move-result v0

    if-eqz v0, :cond_2b

    .line 708
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->getInsertionController()Landroid/widget/MiuiCursorController;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/MiuiCursorController;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 711
    :cond_2b
    return v7

    .line 667
    :pswitch_2c
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    .line 668
    .local v3, x:F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    .line 670
    .local v4, y:F
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0, v3, v4}, Landroid/widget/TextView;->getOffsetForPosition(FF)I

    move-result v0

    iput v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMaxTouchOffset:I

    iput v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMinTouchOffset:I

    .line 671
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    iget-wide v1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapUpTime:J

    iget v5, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapPositionX:F

    iget v6, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapPositionY:F

    invoke-virtual/range {v0 .. v6}, Landroid/widget/Editor;->startTextSelectionModeIfDouleTap(JFFFF)V

    .line 672
    iput v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapPositionX:F

    .line 673
    iput v4, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapPositionY:F

    goto :goto_8

    .line 680
    .end local v3           #x:F
    .end local v4           #y:F
    :pswitch_4e
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const-string v1, "android.hardware.touchscreen.multitouch.distinct"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 682
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v10

    .line 683
    .local v10, pointerCount:I
    const/4 v8, 0x0

    .local v8, index:I
    :goto_61
    if-ge v8, v10, :cond_8

    .line 684
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {p1, v8}, Landroid/view/MotionEvent;->getX(I)F

    move-result v1

    invoke-virtual {p1, v8}, Landroid/view/MotionEvent;->getY(I)F

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/widget/TextView;->getOffsetForPosition(FF)I

    move-result v9

    .line 685
    .local v9, offset:I
    iget v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMinTouchOffset:I

    if-ge v9, v0, :cond_77

    .line 686
    iput v9, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMinTouchOffset:I

    .line 687
    :cond_77
    iget v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMaxTouchOffset:I

    if-le v9, v0, :cond_7d

    .line 688
    iput v9, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMaxTouchOffset:I

    .line 683
    :cond_7d
    add-int/lit8 v8, v8, 0x1

    goto :goto_61

    .line 694
    .end local v8           #index:I
    .end local v9           #offset:I
    .end local v10           #pointerCount:I
    :pswitch_80
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->onTapUpEvent()V

    .line 695
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPreviousTapUpTime:J

    goto/16 :goto_8

    .line 665
    nop

    :pswitch_data_8e
    .packed-switch 0x0
        :pswitch_2c
        :pswitch_80
        :pswitch_8
        :pswitch_8
        :pswitch_8
        :pswitch_4e
        :pswitch_4e
    .end packed-switch
.end method

.method public resetTouchOffsets()V
    .registers 2

    .prologue
    .line 723
    const/4 v0, -0x1

    iput v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMaxTouchOffset:I

    iput v0, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMinTouchOffset:I

    .line 724
    return-void
.end method

.method public setMinMaxOffset(I)V
    .registers 2
    .parameter "offset"

    .prologue
    .line 761
    iput p1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMaxTouchOffset:I

    iput p1, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mMinTouchOffset:I

    .line 762
    return-void
.end method

.method public show()V
    .registers 6

    .prologue
    .line 564
    const-string v3, "MiuiCursorController"

    const-string v4, "SelectionModifierCursorController is shown"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 566
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->isInBatchEditMode()Z

    move-result v3

    if-eqz v3, :cond_10

    .line 581
    :goto_f
    return-void

    .line 569
    :cond_10
    const-string v3, "MiuiCursorController"

    const-string v4, "SelectionModifierCursorController is shown and hide InsertionPointCursorController"

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 570
    const/4 v3, 0x1

    iput-boolean v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mIsShowing:Z

    .line 571
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v3}, Landroid/widget/MiuiCursorController$MiuiHandleView;->show()V

    .line 572
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v3}, Landroid/widget/MiuiCursorController$MiuiHandleView;->show()V

    .line 573
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->updatePosition()V

    .line 575
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v3}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    .line 576
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v3}, Landroid/widget/Editor;->hideInsertionPointCursorControllerWrap()V

    .line 577
    const/4 v3, 0x3

    new-array v0, v3, [I

    fill-array-data v0, :array_4a

    .line 578
    .local v0, buttons:[I
    const/4 v3, 0x2

    new-array v1, v3, [I

    fill-array-data v1, :array_54

    .line 579
    .local v1, separators:[I
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v3, v0}, Landroid/widget/Editor;->getFloatPanelShowHides([I)Ljava/util/ArrayList;

    move-result-object v2

    .line 580
    .local v2, showHides:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/Boolean;>;"
    iget-object v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v3, v0, v1, v2}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showHideButtons([I[ILjava/util/ArrayList;)V

    goto :goto_f

    .line 577
    nop

    :array_4a
    .array-data 0x4
        0x15t 0x0t 0xbt 0x6t
        0x16t 0x0t 0xbt 0x6t
        0x17t 0x0t 0xbt 0x6t
    .end array-data

    .line 578
    :array_54
    .array-data 0x4
        0x1ct 0x0t 0xbt 0x6t
        0x1dt 0x0t 0xbt 0x6t
    .end array-data
.end method

.method public updatePosition()V
    .registers 5

    .prologue
    const/4 v3, 0x1

    .line 624
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->isShowing()Z

    move-result v2

    if-nez v2, :cond_8

    .line 659
    :cond_7
    :goto_7
    return-void

    .line 628
    :cond_8
    iget-object v2, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getSelectionStart()I

    move-result v1

    .line 629
    .local v1, selectionStart:I
    iget-object v2, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getSelectionEnd()I

    move-result v0

    .line 631
    .local v0, selectionEnd:I
    if-ltz v1, :cond_18

    if-gez v0, :cond_23

    .line 633
    :cond_18
    const-string v2, "MiuiCursorController"

    const-string v3, "Update selection controller position called with no cursor"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 634
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->hide()V

    goto :goto_7

    .line 639
    :cond_23
    if-ne v1, v0, :cond_29

    .line 640
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->hide()V

    goto :goto_7

    .line 644
    :cond_29
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v2, v1, v3}, Landroid/widget/MiuiCursorController$MiuiHandleView;->positionAtCursorOffset(IZ)V

    .line 645
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v2, v0, v3}, Landroid/widget/MiuiCursorController$MiuiHandleView;->positionAtCursorOffset(IZ)V

    .line 647
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mStartHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v2}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v2

    if-nez v2, :cond_43

    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mEndHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v2}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v2

    if-eqz v2, :cond_58

    .line 648
    :cond_43
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v2}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v2

    if-nez v2, :cond_4f

    iget-boolean v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mHideInvisiblePanel:Z

    if-eqz v2, :cond_7

    .line 649
    :cond_4f
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v2}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    .line 650
    const/4 v2, 0x0

    iput-boolean v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mHideInvisiblePanel:Z

    goto :goto_7

    .line 654
    :cond_58
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v2}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v2

    if-eqz v2, :cond_7

    .line 655
    iget-object v2, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v2}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    .line 656
    iput-boolean v3, p0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;->mHideInvisiblePanel:Z

    goto :goto_7
.end method
