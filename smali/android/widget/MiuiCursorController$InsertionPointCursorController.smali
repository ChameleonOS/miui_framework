.class public Landroid/widget/MiuiCursorController$InsertionPointCursorController;
.super Landroid/widget/MiuiCursorController;
.source "MiuiCursorController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/MiuiCursorController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InsertionPointCursorController"
.end annotation


# instance fields
.field private mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

.field private mCoords:[I

.field private final mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

.field private mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

.field private mPreviousDownTime:J

.field mShowOnOneShot:Z

.field private mTextOffset:I


# direct methods
.method constructor <init>(Landroid/widget/Editor;Landroid/content/Context;)V
    .registers 6
    .parameter "owner"
    .parameter "context"

    .prologue
    const/4 v2, 0x0

    .line 349
    invoke-direct {p0, p1, p2}, Landroid/widget/MiuiCursorController;-><init>(Landroid/widget/Editor;Landroid/content/Context;)V

    .line 346
    const/4 v1, 0x2

    new-array v1, v1, [I

    iput-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mCoords:[I

    .line 391
    iput-boolean v2, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mShowOnOneShot:Z

    .line 350
    iget-object v1, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {p0, v1, v2, p0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->initHandleView(Landroid/widget/Editor;ILandroid/widget/MiuiCursorController;)Landroid/widget/MiuiCursorController$MiuiHandleView;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    .line 351
    const v1, 0x6030033

    invoke-virtual {p0, v1}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->createFloatPanelViewController(I)Landroid/widget/MiuiCursorController$FloatPanelViewController;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    .line 352
    const v1, 0x6030030

    invoke-virtual {p0, v1}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->createFloatPanelViewController(I)Landroid/widget/MiuiCursorController$FloatPanelViewController;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    .line 353
    new-instance v0, Landroid/widget/MiuiCursorController$InsertionPointCursorController$1;

    invoke-direct {v0, p0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController$1;-><init>(Landroid/widget/MiuiCursorController$InsertionPointCursorController;)V

    .line 360
    .local v0, l:Landroid/view/View$OnClickListener;
    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b0019

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    .line 361
    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b001a

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    .line 362
    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b0017

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    .line 363
    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b0018

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    .line 364
    return-void
.end method

.method static synthetic access$100(Landroid/widget/MiuiCursorController$InsertionPointCursorController;)Landroid/widget/MiuiCursorController$FloatPanelViewController;
    .registers 2
    .parameter "x0"

    .prologue
    .line 337
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    return-object v0
.end method

.method private showInsertionPanel()V
    .registers 3

    .prologue
    .line 517
    const-string v0, "MiuiCursorController"

    const-string v1, ">need InsertPanel, to show Panel and hide handle"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 518
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    .line 519
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->invisible()V

    .line 520
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->getSelectionController()Landroid/widget/MiuiCursorController;

    move-result-object v0

    iget v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mTextOffset:I

    invoke-virtual {v0, v1}, Landroid/widget/MiuiCursorController;->setMinMaxOffset(I)V

    .line 521
    return-void
.end method


# virtual methods
.method public computePanelPosition([I)V
    .registers 3
    .parameter "pos"

    .prologue
    .line 461
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0, p1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getHotspotLocationOnScreen([I)V

    .line 462
    return-void
.end method

.method public computePanelPositionOnBottom()I
    .registers 3

    .prologue
    .line 467
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mCoords:[I

    invoke-virtual {v0, v1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getHotspotLocationOnScreen([I)V

    .line 468
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mCoords:[I

    const/4 v1, 0x1

    aget v0, v0, v1

    return v0
.end method

.method public hide()V
    .registers 3

    .prologue
    .line 428
    const-string v0, "MiuiCursorController"

    const-string v1, "InsertionPointCursorController is hidden including all panels and handle"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 429
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    .line 430
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    .line 431
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->hide()V

    .line 432
    return-void
.end method

.method public isShowing()Z
    .registers 2

    .prologue
    .line 435
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v0

    if-nez v0, :cond_18

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-nez v0, :cond_18

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_1a

    :cond_18
    const/4 v0, 0x1

    :goto_19
    return v0

    :cond_1a
    const/4 v0, 0x0

    goto :goto_19
.end method

.method onClipBoardPancelClick()V
    .registers 2

    .prologue
    .line 367
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    .line 368
    return-void
.end method

.method public onHandleTouchEvent(Landroid/widget/MiuiCursorController$MiuiHandleView;Landroid/view/MotionEvent;)Z
    .registers 7
    .parameter "handle"
    .parameter "ev"

    .prologue
    .line 487
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    packed-switch v0, :pswitch_data_54

    .line 514
    :cond_7
    :goto_7
    const/4 v0, 0x0

    return v0

    .line 489
    :pswitch_9
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPreviousDownTime:J

    goto :goto_7

    .line 493
    :pswitch_10
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_2e

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPreviousDownTime:J

    sub-long/2addr v0, v2

    invoke-static {}, Landroid/view/ViewConfiguration;->getTapTimeout()I

    move-result v2

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-gtz v0, :cond_2e

    .line 495
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    goto :goto_7

    .line 498
    :cond_2e
    const-string v0, "MiuiCursorController"

    const-string v1, "InsertionPointCursorController onHandleTouchEvent() for ACTION_UP"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 499
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->needInsertPanel()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 500
    invoke-direct {p0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->showInsertionPanel()V

    goto :goto_7

    .line 506
    :pswitch_41
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_4e

    .line 507
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    .line 510
    :cond_4e
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onHandleMoved()V

    goto :goto_7

    .line 487
    :pswitch_data_54
    .packed-switch 0x0
        :pswitch_9
        :pswitch_10
        :pswitch_41
    .end packed-switch
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 3
    .parameter "ev"

    .prologue
    .line 475
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    packed-switch v0, :pswitch_data_16

    .line 482
    :cond_7
    :goto_7
    const/4 v0, 0x0

    return v0

    .line 477
    :pswitch_9
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 478
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->hide()V

    goto :goto_7

    .line 475
    nop

    :pswitch_data_16
    .packed-switch 0x2
        :pswitch_9
    .end packed-switch
.end method

.method setupClipBoardPanel(Landroid/content/ClipData;Landroid/view/View$OnClickListener;)V
    .registers 14
    .parameter "clip"
    .parameter "l"

    .prologue
    const/4 v10, -0x1

    const/4 v9, -0x2

    .line 371
    iget-object v7, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v8, 0x60b001b

    invoke-virtual {v7, v8}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->getElement(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    .line 372
    .local v5, ll:Landroid/widget/LinearLayout;
    invoke-virtual {v5}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 373
    invoke-virtual {p1}, Landroid/content/ClipData;->getItemCount()I

    move-result v0

    .line 374
    .local v0, historyCount:I
    const/4 v7, 0x3

    invoke-static {v7, v0}, Ljava/lang/Math;->min(II)I

    move-result v7

    add-int/lit8 v3, v7, -0x1

    .line 375
    .local v3, lastIndex:I
    iget-object v7, p0, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    const-string v8, "layout_inflater"

    invoke-virtual {v7, v8}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/LayoutInflater;

    .line 376
    .local v4, layoutInflater:Landroid/view/LayoutInflater;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_26
    if-gt v1, v3, :cond_69

    .line 377
    const v7, 0x6030031

    const/4 v8, 0x0

    invoke-virtual {v4, v7, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 378
    .local v6, tv:Landroid/widget/TextView;
    invoke-virtual {p1, v1}, Landroid/content/ClipData;->getItemAt(I)Landroid/content/ClipData$Item;

    move-result-object v7

    iget-object v8, p0, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    invoke-virtual {v7, v8}, Landroid/content/ClipData$Item;->coerceToText(Landroid/content/Context;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 379
    invoke-virtual {v6, p2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 380
    new-instance v7, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v7, v10, v9}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v5, v6, v7}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 381
    if-eq v1, v3, :cond_66

    .line 382
    new-instance v2, Landroid/widget/ImageView;

    iget-object v7, p0, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    invoke-direct {v2, v7}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 383
    .local v2, im:Landroid/widget/ImageView;
    const v7, 0x602010c

    invoke-virtual {v2, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 384
    sget-object v7, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v2, v7}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 385
    new-instance v7, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v7, v10, v9}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v5, v2, v7}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 376
    .end local v2           #im:Landroid/widget/ImageView;
    :cond_66
    add-int/lit8 v1, v1, 0x1

    goto :goto_26

    .line 388
    .end local v6           #tv:Landroid/widget/TextView;
    :cond_69
    iget-object v7, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v7}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    .line 389
    return-void
.end method

.method public show()V
    .registers 12

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 394
    const/4 v8, 0x4

    new-array v0, v8, [I

    fill-array-data v0, :array_a2

    .line 398
    .local v0, buttons:[I
    const/4 v8, 0x3

    new-array v4, v8, [I

    fill-array-data v4, :array_ae

    .line 401
    .local v4, separators:[I
    iget-object v8, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v8, v0}, Landroid/widget/Editor;->getFloatPanelShowHides([I)Ljava/util/ArrayList;

    move-result-object v5

    .line 402
    .local v5, showHides:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/Boolean;>;"
    const-string v8, "MiuiCursorController"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "InsertionPointCursorController show:"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v5}, Ljava/util/ArrayList;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 403
    iget-object v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v8, v0, v4, v5}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showHideButtons([I[ILjava/util/ArrayList;)V

    .line 405
    const-string v8, "MiuiCursorController"

    const-string v9, "InsertionPointCursorController is shown with hidden panels and shown handle"

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 406
    iget-object v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v8}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    .line 407
    iget-object v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v8}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    .line 409
    iget-object v8, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v8}, Landroid/widget/TextView;->getSelectionStart()I

    move-result v2

    .line 410
    .local v2, offset:I
    iget v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mTextOffset:I

    if-eq v2, v8, :cond_58

    iget-object v8, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v8}, Landroid/widget/TextView;->length()I

    move-result v8

    if-gtz v8, :cond_96

    :cond_58
    move v3, v7

    .line 411
    .local v3, oneShot:Z
    :goto_59
    iput v2, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mTextOffset:I

    .line 413
    iget-object v8, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v8}, Landroid/widget/Editor;->hasMagnifierController()Z

    move-result v8

    if-eqz v8, :cond_98

    iget-object v8, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v8}, Landroid/widget/Editor;->getMagnifierController()Landroid/widget/MagnifierController;

    move-result-object v8

    invoke-virtual {v8}, Landroid/widget/MagnifierController;->isShowing()Z

    move-result v8

    if-eqz v8, :cond_98

    move v1, v7

    .line 414
    .local v1, isShowMag:Z
    :goto_70
    iget-object v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v8}, Landroid/widget/MiuiCursorController$MiuiHandleView;->show()V

    .line 415
    if-eqz v3, :cond_95

    if-nez v1, :cond_95

    .line 416
    const-string v8, "MiuiCursorController"

    const-string v9, "Show InsertionPointCursorController in one shot context"

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 417
    iget-object v8, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v8}, Landroid/widget/Editor;->needInsertPanel()Z

    move-result v8

    if-eqz v8, :cond_9a

    iget-boolean v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mShowOnOneShot:Z

    if-eqz v8, :cond_9a

    .line 418
    invoke-direct {p0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->showInsertionPanel()V

    .line 423
    :goto_8f
    iget-boolean v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mShowOnOneShot:Z

    if-nez v8, :cond_a0

    :goto_93
    iput-boolean v7, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mShowOnOneShot:Z

    .line 425
    :cond_95
    return-void

    .end local v1           #isShowMag:Z
    .end local v3           #oneShot:Z
    :cond_96
    move v3, v6

    .line 410
    goto :goto_59

    .restart local v3       #oneShot:Z
    :cond_98
    move v1, v6

    .line 413
    goto :goto_70

    .line 421
    .restart local v1       #isShowMag:Z
    :cond_9a
    iget-object v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v8}, Landroid/widget/MiuiCursorController$MiuiHandleView;->hide()V

    goto :goto_8f

    :cond_a0
    move v7, v6

    .line 423
    goto :goto_93

    .line 394
    :array_a2
    .array-data 0x4
        0x19t 0x0t 0xbt 0x6t
        0x1at 0x0t 0xbt 0x6t
        0x17t 0x0t 0xbt 0x6t
        0x18t 0x0t 0xbt 0x6t
    .end array-data

    .line 398
    :array_ae
    .array-data 0x4
        0x1ct 0x0t 0xbt 0x6t
        0x1dt 0x0t 0xbt 0x6t
        0x1et 0x0t 0xbt 0x6t
    .end array-data
.end method

.method public updatePosition()V
    .registers 4

    .prologue
    .line 439
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getSelectionStart()I

    move-result v0

    iput v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mTextOffset:I

    .line 441
    iget v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mTextOffset:I

    if-gez v0, :cond_17

    .line 443
    const-string v0, "MiuiCursorController"

    const-string v1, "Update cursor controller position called with no cursor"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 444
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->hide()V

    .line 457
    :cond_16
    :goto_16
    return-void

    .line 448
    :cond_17
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-nez v0, :cond_2f

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-nez v0, :cond_2f

    .line 449
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    iget v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mTextOffset:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/widget/MiuiCursorController$MiuiHandleView;->positionAtCursorOffset(IZ)V

    .line 451
    :cond_2f
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_3c

    .line 452
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    .line 454
    :cond_3c
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_16

    .line 455
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    goto :goto_16
.end method
