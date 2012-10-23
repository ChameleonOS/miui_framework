.class abstract Landroid/widget/MiuiCursorController$MiuiHandleView;
.super Landroid/view/View;
.source "MiuiCursorController.java"

# interfaces
.implements Landroid/widget/Editor$TextViewPositionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/MiuiCursorController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x400
    name = "MiuiHandleView"
.end annotation


# static fields
.field public static final HANDLE_END:I = 0x2

.field public static final HANDLE_INSERT:I = 0x0

.field public static final HANDLE_START:I = 0x1

.field private static final HISTORY_SIZE:I = 0x5

.field static final TAG:Ljava/lang/String; = "MiuiHandleView"

.field private static final TOUCH_UP_FILTER_DELAY_AFTER:I = 0x96

.field private static final TOUCH_UP_FILTER_DELAY_BEFORE:I = 0x15e


# instance fields
.field private final mContainer:Landroid/widget/PopupWindow;

.field private mContainerX:I

.field private mContainerY:I

.field private mCursorController:Landroid/widget/MiuiCursorController;

.field protected mDrawable:Landroid/graphics/drawable/Drawable;

.field protected mDrawableLtr:Landroid/graphics/drawable/Drawable;

.field protected mDrawableRtl:Landroid/graphics/drawable/Drawable;

.field protected mEditor:Landroid/widget/Editor;

.field private mHotspotX:I

.field private mIdealVerticalOffset:F

.field private mIsDragging:Z

.field private mLastParentX:I

.field private mLastParentY:I

.field private mNumberPreviousOffsets:I

.field private mPositionHasChanged:Z

.field private mPositionX:I

.field private mPositionY:I

.field private mPreviousOffset:I

.field private mPreviousOffsetIndex:I

.field private final mPreviousOffsets:[I

.field private final mPreviousOffsetsTimes:[J

.field protected mTextView:Landroid/widget/TextView;

.field private mTouchOffsetY:F

.field private mTouchToWindowOffsetX:F

.field private mTouchToWindowOffsetY:F

.field private mType:I

.field protected mVisible:Z

.field final synthetic this$0:Landroid/widget/MiuiCursorController;


# direct methods
.method public constructor <init>(Landroid/widget/MiuiCursorController;Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    .registers 12
    .parameter
    .parameter "editor"
    .parameter "drawableLtr"
    .parameter "drawableRtl"

    .prologue
    const/4 v2, 0x5

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 799
    iput-object p1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->this$0:Landroid/widget/MiuiCursorController;

    .line 800
    invoke-virtual {p2}, Landroid/widget/Editor;->textview()Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {p0, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 790
    const/4 v1, -0x1

    iput v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffset:I

    .line 792
    iput-boolean v6, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionHasChanged:Z

    .line 795
    iput-boolean v6, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mVisible:Z

    .line 832
    new-array v1, v2, [J

    iput-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetsTimes:[J

    .line 833
    new-array v1, v2, [I

    iput-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsets:[I

    .line 834
    iput v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    .line 835
    iput v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mNumberPreviousOffsets:I

    .line 801
    iput-object p2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    .line 802
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v1}, Landroid/widget/Editor;->textview()Landroid/widget/TextView;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    .line 803
    new-instance v1, Landroid/widget/PopupWindow;

    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v2

    const/4 v3, 0x0

    iget-object v4, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v4}, Landroid/widget/Editor;->getSelectHandleWindowStyle()I

    move-result v4

    invoke-direct {v1, v2, v3, v4}, Landroid/widget/PopupWindow;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    iput-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    .line 804
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v1, v6}, Landroid/widget/PopupWindow;->setSplitTouchEnabled(Z)V

    .line 805
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v1, v5}, Landroid/widget/PopupWindow;->setClippingEnabled(Z)V

    .line 806
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    const/16 v2, 0x3ea

    invoke-virtual {v1, v2}, Landroid/widget/PopupWindow;->setWindowLayoutType(I)V

    .line 807
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v1, p0}, Landroid/widget/PopupWindow;->setContentView(Landroid/view/View;)V

    .line 809
    iput-object p3, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawableLtr:Landroid/graphics/drawable/Drawable;

    .line 810
    iput-object p4, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawableRtl:Landroid/graphics/drawable/Drawable;

    .line 812
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->updateDrawable()V

    .line 814
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    .line 815
    .local v0, handleHeight:I
    const v1, -0x41666666

    int-to-float v2, v0

    mul-float/2addr v1, v2

    iput v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchOffsetY:F

    .line 816
    const v1, 0x3f333333

    int-to-float v2, v0

    mul-float/2addr v1, v2

    iput v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIdealVerticalOffset:F

    .line 817
    return-void
.end method

.method private addPositionToTouchUpFilter(I)V
    .registers 6
    .parameter "offset"

    .prologue
    .line 843
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    add-int/lit8 v0, v0, 0x1

    rem-int/lit8 v0, v0, 0x5

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    .line 844
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsets:[I

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    aput p1, v0, v1

    .line 845
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetsTimes:[J

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v2

    aput-wide v2, v0, v1

    .line 846
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mNumberPreviousOffsets:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mNumberPreviousOffsets:I

    .line 847
    return-void
.end method

.method private filterOnTouchUp()V
    .registers 10

    .prologue
    .line 850
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v3

    .line 851
    .local v3, now:J
    const/4 v0, 0x0

    .line 852
    .local v0, i:I
    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    .line 853
    .local v2, index:I
    iget v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mNumberPreviousOffsets:I

    const/4 v6, 0x5

    invoke-static {v5, v6}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 854
    .local v1, iMax:I
    :goto_e
    if-ge v0, v1, :cond_26

    iget-object v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetsTimes:[J

    aget-wide v5, v5, v2

    sub-long v5, v3, v5

    const-wide/16 v7, 0x96

    cmp-long v5, v5, v7

    if-gez v5, :cond_26

    .line 855
    add-int/lit8 v0, v0, 0x1

    .line 856
    iget v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    sub-int/2addr v5, v0

    add-int/lit8 v5, v5, 0x5

    rem-int/lit8 v2, v5, 0x5

    goto :goto_e

    .line 859
    :cond_26
    if-lez v0, :cond_3e

    if-ge v0, v1, :cond_3e

    iget-object v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetsTimes:[J

    aget-wide v5, v5, v2

    sub-long v5, v3, v5

    const-wide/16 v7, 0x15e

    cmp-long v5, v5, v7

    if-lez v5, :cond_3e

    .line 861
    iget-object v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsets:[I

    aget v5, v5, v2

    const/4 v6, 0x0

    invoke-virtual {p0, v5, v6}, Landroid/widget/MiuiCursorController$MiuiHandleView;->positionAtCursorOffset(IZ)V

    .line 863
    :cond_3e
    return-void
.end method

.method private isVisible()Z
    .registers 4

    .prologue
    .line 930
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    if-eqz v0, :cond_6

    .line 931
    const/4 v0, 0x1

    .line 938
    :goto_5
    return v0

    .line 934
    :cond_6
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->isInBatchEditMode()Z

    move-result v0

    if-eqz v0, :cond_10

    .line 935
    const/4 v0, 0x0

    goto :goto_5

    .line 938
    :cond_10
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionX:I

    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHotspotX:I

    add-int/2addr v1, v2

    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    invoke-virtual {v0, v1, v2}, Landroid/widget/Editor;->isPositionVisibleWrap(II)Z

    move-result v0

    goto :goto_5
.end method

.method private startTouchUpFilter(I)V
    .registers 3
    .parameter "offset"

    .prologue
    .line 838
    const/4 v0, 0x0

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mNumberPreviousOffsets:I

    .line 839
    invoke-direct {p0, p1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->addPositionToTouchUpFilter(I)V

    .line 840
    return-void
.end method


# virtual methods
.method protected dismiss()V
    .registers 2

    .prologue
    .line 909
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    .line 910
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 911
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onDetached()V

    .line 912
    return-void
.end method

.method public abstract getCurrentCursorOffset()I
.end method

.method public getHotspotLocationOnScreen([I)V
    .registers 5
    .parameter "location"

    .prologue
    .line 884
    const/4 v0, 0x0

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerX:I

    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHotspotX:I

    add-int/2addr v1, v2

    aput v1, p1, v0

    .line 885
    const/4 v0, 0x1

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerY:I

    aput v1, p1, v0

    .line 886
    return-void
.end method

.method protected abstract getHotspotX(Landroid/graphics/drawable/Drawable;Z)I
.end method

.method public hide()V
    .registers 2

    .prologue
    .line 915
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->dismiss()V

    .line 917
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0, p0}, Landroid/widget/Editor;->removePositionListenerSubscriber(Landroid/widget/Editor$TextViewPositionListener;)V

    .line 918
    return-void
.end method

.method public invisible()V
    .registers 2

    .prologue
    .line 879
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mVisible:Z

    .line 880
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 881
    return-void
.end method

.method public isDragging()Z
    .registers 2

    .prologue
    .line 1073
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    return v0
.end method

.method public isShowing()Z
    .registers 2

    .prologue
    .line 921
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result v0

    return v0
.end method

.method protected isVisibleWrap()Z
    .registers 2

    .prologue
    .line 925
    invoke-direct {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isVisible()Z

    move-result v0

    return v0
.end method

.method public offsetHasBeenChanged()Z
    .registers 3

    .prologue
    const/4 v0, 0x1

    .line 866
    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mNumberPreviousOffsets:I

    if-le v1, v0, :cond_6

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public onDetached()V
    .registers 1

    .prologue
    .line 1080
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .registers 7
    .parameter "c"

    .prologue
    const/4 v4, 0x0

    .line 1016
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    iget v1, p0, Landroid/view/View;->mRight:I

    iget v2, p0, Landroid/view/View;->mLeft:I

    sub-int/2addr v1, v2

    iget v2, p0, Landroid/view/View;->mBottom:I

    iget v3, p0, Landroid/view/View;->mTop:I

    sub-int/2addr v2, v3

    invoke-virtual {v0, v4, v4, v1, v2}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1017
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 1018
    return-void
.end method

.method onHandleMoved()V
    .registers 1

    .prologue
    .line 1077
    return-void
.end method

.method protected onMeasure(II)V
    .registers 5
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    .line 871
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->setMeasuredDimension(II)V

    .line 872
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 14
    .parameter "ev"

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 1022
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v9

    packed-switch v9, :pswitch_data_9a

    .line 1068
    :goto_9
    iget-object v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mCursorController:Landroid/widget/MiuiCursorController;

    invoke-virtual {v9, p0, p1}, Landroid/widget/MiuiCursorController;->onHandleTouchEvent(Landroid/widget/MiuiCursorController$MiuiHandleView;Landroid/view/MotionEvent;)Z

    .line 1069
    return v11

    .line 1024
    :pswitch_f
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getCurrentCursorOffset()I

    move-result v9

    invoke-direct {p0, v9}, Landroid/widget/MiuiCursorController$MiuiHandleView;->startTouchUpFilter(I)V

    .line 1025
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v9

    iget v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionX:I

    int-to-float v10, v10

    sub-float/2addr v9, v10

    iput v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetX:F

    .line 1026
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v9

    iget v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    int-to-float v10, v10

    sub-float/2addr v9, v10

    iput v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetY:F

    .line 1028
    iget-object v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v9}, Landroid/widget/Editor;->getPositionListenerPostion()J

    move-result-wide v4

    .line 1029
    .local v4, pos:J
    #calls: Landroid/widget/MiuiCursorController;->extractRangeStartFromLong(J)I
    invoke-static {v4, v5}, Landroid/widget/MiuiCursorController;->access$300(J)I

    move-result v9

    iput v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentX:I

    .line 1030
    #calls: Landroid/widget/MiuiCursorController;->extractRangeEndFromLong(J)I
    invoke-static {v4, v5}, Landroid/widget/MiuiCursorController;->access$400(J)I

    move-result v9

    iput v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    .line 1031
    iput-boolean v11, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    goto :goto_9

    .line 1036
    .end local v4           #pos:J
    :pswitch_3f
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v7

    .line 1037
    .local v7, rawX:F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v8

    .line 1040
    .local v8, rawY:F
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetY:F

    iget v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    int-to-float v10, v10

    sub-float v6, v9, v10

    .line 1041
    .local v6, previousVerticalOffset:F
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    int-to-float v9, v9

    sub-float v9, v8, v9

    iget v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    int-to-float v10, v10

    sub-float v0, v9, v10

    .line 1043
    .local v0, currentVerticalOffset:F
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIdealVerticalOffset:F

    cmpg-float v9, v6, v9

    if-gez v9, :cond_83

    .line 1044
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIdealVerticalOffset:F

    invoke-static {v0, v9}, Ljava/lang/Math;->min(FF)F

    move-result v3

    .line 1045
    .local v3, newVerticalOffset:F
    invoke-static {v3, v6}, Ljava/lang/Math;->max(FF)F

    move-result v3

    .line 1050
    :goto_68
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    int-to-float v9, v9

    add-float/2addr v9, v3

    iput v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetY:F

    .line 1052
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetX:F

    sub-float v9, v7, v9

    iget v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHotspotX:I

    int-to-float v10, v10

    add-float v1, v9, v10

    .line 1053
    .local v1, newPosX:F
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetY:F

    sub-float v9, v8, v9

    iget v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchOffsetY:F

    add-float v2, v9, v10

    .line 1055
    .local v2, newPosY:F
    invoke-virtual {p0, v1, v2}, Landroid/widget/MiuiCursorController$MiuiHandleView;->updatePosition(FF)V

    goto :goto_9

    .line 1047
    .end local v1           #newPosX:F
    .end local v2           #newPosY:F
    .end local v3           #newVerticalOffset:F
    :cond_83
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIdealVerticalOffset:F

    invoke-static {v0, v9}, Ljava/lang/Math;->max(FF)F

    move-result v3

    .line 1048
    .restart local v3       #newVerticalOffset:F
    invoke-static {v3, v6}, Ljava/lang/Math;->min(FF)F

    move-result v3

    goto :goto_68

    .line 1060
    .end local v0           #currentVerticalOffset:F
    .end local v3           #newVerticalOffset:F
    .end local v6           #previousVerticalOffset:F
    .end local v7           #rawX:F
    .end local v8           #rawY:F
    :pswitch_8e
    invoke-direct {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->filterOnTouchUp()V

    .line 1061
    iput-boolean v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    goto/16 :goto_9

    .line 1065
    :pswitch_95
    iput-boolean v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    goto/16 :goto_9

    .line 1022
    nop

    :pswitch_data_9a
    .packed-switch 0x0
        :pswitch_f
        :pswitch_8e
        :pswitch_3f
        :pswitch_95
    .end packed-switch
.end method

.method protected positionAtCursorOffset(IZ)V
    .registers 6
    .parameter "offset"
    .parameter "parentScrolled"

    .prologue
    .line 949
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    if-nez v1, :cond_e

    .line 951
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v1}, Landroid/widget/Editor;->prepareCursorControllers()V

    .line 970
    :cond_d
    :goto_d
    return-void

    .line 955
    :cond_e
    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffset:I

    if-ne p1, v1, :cond_14

    if-eqz p2, :cond_d

    .line 956
    :cond_14
    invoke-virtual {p0, p1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->updateSelection(I)V

    .line 957
    invoke-direct {p0, p1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->addPositionToTouchUpFilter(I)V

    .line 958
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v0

    .line 960
    .local v0, line:I
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroid/text/Layout;->getPrimaryHorizontal(I)F

    move-result v1

    const/high16 v2, 0x3f00

    sub-float/2addr v1, v2

    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHotspotX:I

    int-to-float v2, v2

    sub-float/2addr v1, v2

    float-to-int v1, v1

    iput v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionX:I

    .line 961
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/text/Layout;->getLineBottom(I)I

    move-result v1

    iput v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    .line 964
    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionX:I

    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->viewportToContentHorizontalOffset()I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionX:I

    .line 965
    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->viewportToContentVerticalOffset()I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    .line 967
    iput p1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffset:I

    .line 968
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionHasChanged:Z

    goto :goto_d
.end method

.method public setCursorController(Landroid/widget/MiuiCursorController;)V
    .registers 2
    .parameter "cc"

    .prologue
    .line 893
    iput-object p1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mCursorController:Landroid/widget/MiuiCursorController;

    .line 894
    return-void
.end method

.method public setType(I)V
    .registers 2
    .parameter "type"

    .prologue
    .line 889
    iput p1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mType:I

    .line 890
    return-void
.end method

.method public setVisible(Z)V
    .registers 2
    .parameter "visible"

    .prologue
    .line 875
    iput-boolean p1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mVisible:Z

    .line 876
    return-void
.end method

.method public show()V
    .registers 4

    .prologue
    .line 897
    const-string v0, "MiuiHandleView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "HandleView ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mType:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "] is shown"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 899
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_27

    .line 906
    :goto_26
    return-void

    .line 901
    :cond_27
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    const/4 v1, 0x1

    invoke-virtual {v0, p0, v1}, Landroid/widget/Editor;->addPositionListenerSubscriber(Landroid/widget/Editor$TextViewPositionListener;Z)V

    .line 904
    const/4 v0, -0x1

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffset:I

    .line 905
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getCurrentCursorOffset()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->positionAtCursorOffset(IZ)V

    goto :goto_26
.end method

.method protected updateDrawable()V
    .registers 4

    .prologue
    .line 820
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getCurrentCursorOffset()I

    move-result v1

    .line 821
    .local v1, offset:I
    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/text/Layout;->isRtlCharAt(I)Z

    move-result v0

    .line 822
    .local v0, isRtlCharAtOffset:Z
    if-eqz v0, :cond_1d

    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawableRtl:Landroid/graphics/drawable/Drawable;

    :goto_12
    iput-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    .line 823
    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v2, v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getHotspotX(Landroid/graphics/drawable/Drawable;Z)I

    move-result v2

    iput v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHotspotX:I

    .line 824
    return-void

    .line 822
    :cond_1d
    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawableLtr:Landroid/graphics/drawable/Drawable;

    goto :goto_12
.end method

.method public abstract updatePosition(FF)V
.end method

.method public updatePosition(IIZZ)V
    .registers 10
    .parameter "parentPositionX"
    .parameter "parentPositionY"
    .parameter "parentPositionChanged"
    .parameter "parentScrolled"

    .prologue
    const/4 v4, 0x0

    const/4 v3, -0x1

    .line 975
    const-string v0, "MiuiHandleView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "HandleView ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mType:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "] handle updatePosition called from PositionListener:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "x"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 976
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getCurrentCursorOffset()I

    move-result v0

    invoke-virtual {p0, v0, p4}, Landroid/widget/MiuiCursorController$MiuiHandleView;->positionAtCursorOffset(IZ)V

    .line 977
    if-nez p3, :cond_3e

    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionHasChanged:Z

    if-eqz v0, :cond_97

    .line 978
    :cond_3e
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    if-eqz v0, :cond_76

    .line 980
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentX:I

    if-ne p1, v0, :cond_4a

    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    if-eq p2, v0, :cond_73

    .line 981
    :cond_4a
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetX:F

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentX:I

    sub-int v1, p1, v1

    int-to-float v1, v1

    add-float/2addr v0, v1

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetX:F

    .line 982
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetY:F

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    sub-int v1, p2, v1

    int-to-float v1, v1

    add-float/2addr v0, v1

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetY:F

    .line 983
    iput p1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentX:I

    .line 984
    iput p2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    .line 985
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->hasMagnifierController()Z

    move-result v0

    if-eqz v0, :cond_73

    .line 986
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->getMagnifierController()Landroid/widget/MagnifierController;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/MagnifierController;->onParentChanged()V

    .line 989
    :cond_73
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onHandleMoved()V

    .line 992
    :cond_76
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isVisibleWrap()Z

    move-result v0

    if-eqz v0, :cond_ad

    .line 993
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionX:I

    add-int/2addr v0, p1

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerX:I

    .line 994
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    add-int/2addr v0, p2

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerY:I

    .line 995
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_9d

    .line 996
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerX:I

    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerY:I

    invoke-virtual {v0, v1, v2, v3, v3}, Landroid/widget/PopupWindow;->update(IIII)V

    .line 1009
    :cond_95
    :goto_95
    iput-boolean v4, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionHasChanged:Z

    .line 1011
    :cond_97
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mCursorController:Landroid/widget/MiuiCursorController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController;->updatePosition()V

    .line 1012
    return-void

    .line 998
    :cond_9d
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mVisible:Z

    if-eqz v0, :cond_95

    .line 999
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerX:I

    iget v3, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerY:I

    invoke-virtual {v0, v1, v4, v2, v3}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    goto :goto_95

    .line 1004
    :cond_ad
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_95

    .line 1005
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->dismiss()V

    goto :goto_95
.end method

.method protected abstract updateSelection(I)V
.end method
