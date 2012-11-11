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

    invoke-direct {p0, p1, p2}, Landroid/widget/MiuiCursorController;-><init>(Landroid/widget/Editor;Landroid/content/Context;)V

    const/4 v1, 0x2

    new-array v1, v1, [I

    iput-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mCoords:[I

    iput-boolean v2, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mShowOnOneShot:Z

    iget-object v1, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {p0, v1, v2, p0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->initHandleView(Landroid/widget/Editor;ILandroid/widget/MiuiCursorController;)Landroid/widget/MiuiCursorController$MiuiHandleView;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    const v1, 0x6030033

    invoke-virtual {p0, v1}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->createFloatPanelViewController(I)Landroid/widget/MiuiCursorController$FloatPanelViewController;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v1, 0x6030030

    invoke-virtual {p0, v1}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->createFloatPanelViewController(I)Landroid/widget/MiuiCursorController$FloatPanelViewController;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    new-instance v0, Landroid/widget/MiuiCursorController$InsertionPointCursorController$1;

    invoke-direct {v0, p0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController$1;-><init>(Landroid/widget/MiuiCursorController$InsertionPointCursorController;)V

    .local v0, l:Landroid/view/View$OnClickListener;
    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b0019

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b001a

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b0017

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v2, 0x60b0018

    invoke-virtual {v1, v2, v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V

    return-void
.end method

.method static synthetic access$100(Landroid/widget/MiuiCursorController$InsertionPointCursorController;)Landroid/widget/MiuiCursorController$FloatPanelViewController;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    return-object v0
.end method

.method private showInsertionPanel()V
    .registers 3

    .prologue
    const-string v0, "MiuiCursorController"

    const-string v1, ">need InsertPanel, to show Panel and hide handle"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->invisible()V

    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->getSelectionController()Landroid/widget/MiuiCursorController;

    move-result-object v0

    iget v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mTextOffset:I

    invoke-virtual {v0, v1}, Landroid/widget/MiuiCursorController;->setMinMaxOffset(I)V

    return-void
.end method


# virtual methods
.method public computePanelPosition([I)V
    .registers 3
    .parameter "pos"

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0, p1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getHotspotLocationOnScreen([I)V

    return-void
.end method

.method public computePanelPositionOnBottom()I
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mCoords:[I

    invoke-virtual {v0, v1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getHotspotLocationOnScreen([I)V

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mCoords:[I

    const/4 v1, 0x1

    aget v0, v0, v1

    return v0
.end method

.method public hide()V
    .registers 3

    .prologue
    const-string v0, "MiuiCursorController"

    const-string v1, "InsertionPointCursorController is hidden including all panels and handle"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->hide()V

    return-void
.end method

.method public isShowing()Z
    .registers 2

    .prologue
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
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    return-void
.end method

.method public onHandleTouchEvent(Landroid/widget/MiuiCursorController$MiuiHandleView;Landroid/view/MotionEvent;)Z
    .registers 7
    .parameter "handle"
    .parameter "ev"

    .prologue
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    packed-switch v0, :pswitch_data_54

    :cond_7
    :goto_7
    const/4 v0, 0x0

    return v0

    :pswitch_9
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPreviousDownTime:J

    goto :goto_7

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

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    goto :goto_7

    :cond_2e
    const-string v0, "MiuiCursorController"

    const-string v1, "InsertionPointCursorController onHandleTouchEvent() for ACTION_UP"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->needInsertPanel()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-direct {p0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->showInsertionPanel()V

    goto :goto_7

    :pswitch_41
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_4e

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    :cond_4e
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onHandleMoved()V

    goto :goto_7

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
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    packed-switch v0, :pswitch_data_16

    :cond_7
    :goto_7
    const/4 v0, 0x0

    return v0

    :pswitch_9
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->hide()V

    goto :goto_7

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

    iget-object v7, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    const v8, 0x60b001b

    invoke-virtual {v7, v8}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->getElement(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    .local v5, ll:Landroid/widget/LinearLayout;
    invoke-virtual {v5}, Landroid/widget/LinearLayout;->removeAllViews()V

    invoke-virtual {p1}, Landroid/content/ClipData;->getItemCount()I

    move-result v0

    .local v0, historyCount:I
    const/4 v7, 0x3

    invoke-static {v7, v0}, Ljava/lang/Math;->min(II)I

    move-result v7

    add-int/lit8 v3, v7, -0x1

    .local v3, lastIndex:I
    iget-object v7, p0, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    const-string v8, "layout_inflater"

    invoke-virtual {v7, v8}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/LayoutInflater;

    .local v4, layoutInflater:Landroid/view/LayoutInflater;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_26
    if-gt v1, v3, :cond_69

    const v7, 0x6030031

    const/4 v8, 0x0

    invoke-virtual {v4, v7, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .local v6, tv:Landroid/widget/TextView;
    invoke-virtual {p1, v1}, Landroid/content/ClipData;->getItemAt(I)Landroid/content/ClipData$Item;

    move-result-object v7

    iget-object v8, p0, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    invoke-virtual {v7, v8}, Landroid/content/ClipData$Item;->coerceToText(Landroid/content/Context;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    invoke-virtual {v6, p2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    new-instance v7, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v7, v10, v9}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v5, v6, v7}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    if-eq v1, v3, :cond_66

    new-instance v2, Landroid/widget/ImageView;

    iget-object v7, p0, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    invoke-direct {v2, v7}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .local v2, im:Landroid/widget/ImageView;
    const v7, 0x602010c

    invoke-virtual {v2, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    sget-object v7, Landroid/widget/ImageView$ScaleType;->FIT_XY:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v2, v7}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    new-instance v7, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v7, v10, v9}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v5, v2, v7}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .end local v2           #im:Landroid/widget/ImageView;
    :cond_66
    add-int/lit8 v1, v1, 0x1

    goto :goto_26

    .end local v6           #tv:Landroid/widget/TextView;
    :cond_69
    iget-object v7, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v7}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    return-void
.end method

.method public show()V
    .registers 12

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    const/4 v8, 0x4

    new-array v0, v8, [I

    fill-array-data v0, :array_a2

    .local v0, buttons:[I
    const/4 v8, 0x3

    new-array v4, v8, [I

    fill-array-data v4, :array_ae

    .local v4, separators:[I
    iget-object v8, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v8, v0}, Landroid/widget/Editor;->getFloatPanelShowHides([I)Ljava/util/ArrayList;

    move-result-object v5

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

    iget-object v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v8, v0, v4, v5}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showHideButtons([I[ILjava/util/ArrayList;)V

    const-string v8, "MiuiCursorController"

    const-string v9, "InsertionPointCursorController is shown with hidden panels and shown handle"

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v8}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    iget-object v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v8}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->hide()V

    iget-object v8, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v8}, Landroid/widget/TextView;->getSelectionStart()I

    move-result v2

    .local v2, offset:I
    iget v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mTextOffset:I

    if-eq v2, v8, :cond_58

    iget-object v8, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v8}, Landroid/widget/TextView;->length()I

    move-result v8

    if-gtz v8, :cond_96

    :cond_58
    move v3, v7

    .local v3, oneShot:Z
    :goto_59
    iput v2, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mTextOffset:I

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

    .local v1, isShowMag:Z
    :goto_70
    iget-object v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v8}, Landroid/widget/MiuiCursorController$MiuiHandleView;->show()V

    if-eqz v3, :cond_95

    if-nez v1, :cond_95

    const-string v8, "MiuiCursorController"

    const-string v9, "Show InsertionPointCursorController in one shot context"

    invoke-static {v8, v9}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v8, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v8}, Landroid/widget/Editor;->needInsertPanel()Z

    move-result v8

    if-eqz v8, :cond_9a

    iget-boolean v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mShowOnOneShot:Z

    if-eqz v8, :cond_9a

    invoke-direct {p0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->showInsertionPanel()V

    :goto_8f
    iget-boolean v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mShowOnOneShot:Z

    if-nez v8, :cond_a0

    :goto_93
    iput-boolean v7, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mShowOnOneShot:Z

    :cond_95
    return-void

    .end local v1           #isShowMag:Z
    .end local v3           #oneShot:Z
    :cond_96
    move v3, v6

    goto :goto_59

    .restart local v3       #oneShot:Z
    :cond_98
    move v1, v6

    goto :goto_70

    .restart local v1       #isShowMag:Z
    :cond_9a
    iget-object v8, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    invoke-virtual {v8}, Landroid/widget/MiuiCursorController$MiuiHandleView;->hide()V

    goto :goto_8f

    :cond_a0
    move v7, v6

    goto :goto_93

    :array_a2
    .array-data 0x4
        0x19t 0x0t 0xbt 0x6t
        0x1at 0x0t 0xbt 0x6t
        0x17t 0x0t 0xbt 0x6t
        0x18t 0x0t 0xbt 0x6t
    .end array-data

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
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getSelectionStart()I

    move-result v0

    iput v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mTextOffset:I

    iget v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mTextOffset:I

    if-gez v0, :cond_17

    const-string v0, "MiuiCursorController"

    const-string v1, "Update cursor controller position called with no cursor"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->hide()V

    :cond_16
    :goto_16
    return-void

    :cond_17
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-nez v0, :cond_2f

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-nez v0, :cond_2f

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mHandle:Landroid/widget/MiuiCursorController$MiuiHandleView;

    iget v1, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mTextOffset:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/widget/MiuiCursorController$MiuiHandleView;->positionAtCursorOffset(IZ)V

    :cond_2f
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_3c

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    :cond_3c
    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_16

    iget-object v0, p0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->mClipboardPanel:Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showAndUpdatePositionAsync()V

    goto :goto_16
.end method
