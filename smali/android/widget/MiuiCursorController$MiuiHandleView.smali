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

.field private mHandleRange:I

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

    .line 848
    iput-object p1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->this$0:Landroid/widget/MiuiCursorController;

    .line 849
    invoke-virtual {p2}, Landroid/widget/Editor;->textview()Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {p0, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 840
    const/4 v1, -0x1

    iput v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffset:I

    .line 842
    iput-boolean v6, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionHasChanged:Z

    .line 882
    new-array v1, v2, [J

    iput-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetsTimes:[J

    .line 883
    new-array v1, v2, [I

    iput-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsets:[I

    .line 884
    iput v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    .line 885
    iput v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mNumberPreviousOffsets:I

    .line 850
    iput-object p2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    .line 851
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v1}, Landroid/widget/Editor;->textview()Landroid/widget/TextView;

    move-result-object v1

    iput-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    .line 852
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x60a0019

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v1

    float-to-int v1, v1

    div-int/lit8 v1, v1, 0x2

    iput v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHandleRange:I

    .line 853
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

    .line 854
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v1, v6}, Landroid/widget/PopupWindow;->setSplitTouchEnabled(Z)V

    .line 855
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v1, v5}, Landroid/widget/PopupWindow;->setClippingEnabled(Z)V

    .line 856
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    const/16 v2, 0x3ea

    invoke-virtual {v1, v2}, Landroid/widget/PopupWindow;->setWindowLayoutType(I)V

    .line 857
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v1, p0}, Landroid/widget/PopupWindow;->setContentView(Landroid/view/View;)V

    .line 859
    iput-object p3, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawableLtr:Landroid/graphics/drawable/Drawable;

    .line 860
    iput-object p4, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawableRtl:Landroid/graphics/drawable/Drawable;

    .line 862
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->updateDrawable()V

    .line 864
    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    .line 865
    .local v0, handleHeight:I
    const v1, -0x41666666

    int-to-float v2, v0

    mul-float/2addr v1, v2

    iput v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchOffsetY:F

    .line 866
    const v1, 0x3f333333

    int-to-float v2, v0

    mul-float/2addr v1, v2

    iput v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIdealVerticalOffset:F

    .line 867
    return-void
.end method

.method private addPositionToTouchUpFilter(I)V
    .registers 6
    .parameter "offset"

    .prologue
    .line 893
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    add-int/lit8 v0, v0, 0x1

    rem-int/lit8 v0, v0, 0x5

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    .line 894
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsets:[I

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    aput p1, v0, v1

    .line 895
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetsTimes:[J

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v2

    aput-wide v2, v0, v1

    .line 896
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mNumberPreviousOffsets:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mNumberPreviousOffsets:I

    .line 897
    return-void
.end method

.method private filterOnTouchUp()V
    .registers 10

    .prologue
    .line 900
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v3

    .line 901
    .local v3, now:J
    const/4 v0, 0x0

    .line 902
    .local v0, i:I
    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    .line 903
    .local v2, index:I
    iget v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mNumberPreviousOffsets:I

    const/4 v6, 0x5

    invoke-static {v5, v6}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 904
    .local v1, iMax:I
    :goto_e
    if-ge v0, v1, :cond_26

    iget-object v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetsTimes:[J

    aget-wide v5, v5, v2

    sub-long v5, v3, v5

    const-wide/16 v7, 0x96

    cmp-long v5, v5, v7

    if-gez v5, :cond_26

    .line 905
    add-int/lit8 v0, v0, 0x1

    .line 906
    iget v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetIndex:I

    sub-int/2addr v5, v0

    add-int/lit8 v5, v5, 0x5

    rem-int/lit8 v2, v5, 0x5

    goto :goto_e

    .line 909
    :cond_26
    if-lez v0, :cond_3e

    if-ge v0, v1, :cond_3e

    iget-object v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsetsTimes:[J

    aget-wide v5, v5, v2

    sub-long v5, v3, v5

    const-wide/16 v7, 0x15e

    cmp-long v5, v5, v7

    if-lez v5, :cond_3e

    .line 911
    iget-object v5, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffsets:[I

    aget v5, v5, v2

    const/4 v6, 0x0

    invoke-virtual {p0, v5, v6}, Landroid/widget/MiuiCursorController$MiuiHandleView;->positionAtCursorOffset(IZ)V

    .line 913
    :cond_3e
    return-void
.end method

.method private startTouchUpFilter(I)V
    .registers 3
    .parameter "offset"

    .prologue
    .line 888
    const/4 v0, 0x0

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mNumberPreviousOffsets:I

    .line 889
    invoke-direct {p0, p1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->addPositionToTouchUpFilter(I)V

    .line 890
    return-void
.end method


# virtual methods
.method protected dismiss()V
    .registers 2

    .prologue
    .line 958
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    .line 959
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 960
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onDetached()V

    .line 961
    return-void
.end method

.method public distance(FF)F
    .registers 5
    .parameter "x"
    .parameter "y"

    .prologue
    .line 929
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerX:I

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHotspotX:I

    add-int/2addr v0, v1

    int-to-float v0, v0

    sub-float/2addr v0, p1

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerY:I

    int-to-float v1, v1

    sub-float/2addr v1, p2

    mul-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    return v0
.end method

.method protected abstract getCurrentCursorOffset()I
.end method

.method public getHotspotLocationOnScreen([I)V
    .registers 5
    .parameter "location"

    .prologue
    .line 933
    const/4 v0, 0x0

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerX:I

    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHotspotX:I

    add-int/2addr v1, v2

    aput v1, p1, v0

    .line 934
    const/4 v0, 0x1

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerY:I

    aput v1, p1, v0

    .line 935
    return-void
.end method

.method protected abstract getHotspotX(Landroid/graphics/drawable/Drawable;Z)I
.end method

.method public hide()V
    .registers 2

    .prologue
    .line 969
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->dismiss()V

    .line 971
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0, p0}, Landroid/widget/Editor;->removePositionListenerSubscriber(Landroid/widget/Editor$TextViewPositionListener;)V

    .line 972
    return-void
.end method

.method public inRecRange(FF)Z
    .registers 9
    .parameter "x"
    .parameter "y"

    .prologue
    .line 921
    iget-object v3, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawableRtl:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    .line 922
    .local v0, height:I
    iget v3, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerX:I

    iget v4, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHotspotX:I

    add-int v1, v3, v4

    .line 923
    .local v1, mx:I
    iget v3, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerY:I

    div-int/lit8 v4, v0, 0x2

    add-int v2, v3, v4

    .line 924
    .local v2, my:I
    const-string v3, "MiuiCursorController"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "HandleCenter at x= "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " y="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "  and touch at x="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " y="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 925
    int-to-float v3, v1

    sub-float/2addr v3, p1

    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v3

    iget v4, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHandleRange:I

    int-to-float v4, v4

    cmpg-float v3, v3, v4

    if-gez v3, :cond_64

    int-to-float v3, v2

    sub-float/2addr v3, p2

    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v3

    div-int/lit8 v4, v0, 0x2

    int-to-float v4, v4

    cmpg-float v3, v3, v4

    if-gez v3, :cond_64

    const/4 v3, 0x1

    :goto_63
    return v3

    :cond_64
    const/4 v3, 0x0

    goto :goto_63
.end method

.method public invisible()V
    .registers 2

    .prologue
    .line 965
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 966
    return-void
.end method

.method public isDragging()Z
    .registers 2

    .prologue
    .line 1140
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    return v0
.end method

.method public isShowing()Z
    .registers 2

    .prologue
    .line 975
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result v0

    return v0
.end method

.method protected isVisible()Z
    .registers 4

    .prologue
    .line 984
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    if-eqz v0, :cond_6

    .line 985
    const/4 v0, 0x1

    .line 992
    :goto_5
    return v0

    .line 988
    :cond_6
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->isInBatchEditMode()Z

    move-result v0

    if-eqz v0, :cond_10

    .line 989
    const/4 v0, 0x0

    goto :goto_5

    .line 992
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

.method protected needShowHandle()Z
    .registers 2

    .prologue
    .line 979
    const/4 v0, 0x1

    return v0
.end method

.method public onDetached()V
    .registers 1

    .prologue
    .line 1147
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .registers 7
    .parameter "c"

    .prologue
    const/4 v4, 0x0

    .line 1083
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    iget v1, p0, Landroid/view/View;->mRight:I

    iget v2, p0, Landroid/view/View;->mLeft:I

    sub-int/2addr v1, v2

    iget v2, p0, Landroid/view/View;->mBottom:I

    iget v3, p0, Landroid/view/View;->mTop:I

    sub-int/2addr v2, v3

    invoke-virtual {v0, v4, v4, v1, v2}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 1084
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 1085
    return-void
.end method

.method onHandleMoved()V
    .registers 1

    .prologue
    .line 1144
    return-void
.end method

.method protected onMeasure(II)V
    .registers 5
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    .line 917
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->setMeasuredDimension(II)V

    .line 918
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 14
    .parameter "ev"

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 1089
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v9

    packed-switch v9, :pswitch_data_9a

    .line 1135
    :goto_9
    iget-object v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mCursorController:Landroid/widget/MiuiCursorController;

    invoke-virtual {v9, p0, p1}, Landroid/widget/MiuiCursorController;->onHandleTouchEvent(Landroid/widget/MiuiCursorController$MiuiHandleView;Landroid/view/MotionEvent;)Z

    .line 1136
    return v11

    .line 1091
    :pswitch_f
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getCurrentCursorOffset()I

    move-result v9

    invoke-direct {p0, v9}, Landroid/widget/MiuiCursorController$MiuiHandleView;->startTouchUpFilter(I)V

    .line 1092
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v9

    iget v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionX:I

    int-to-float v10, v10

    sub-float/2addr v9, v10

    iput v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetX:F

    .line 1093
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v9

    iget v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    int-to-float v10, v10

    sub-float/2addr v9, v10

    iput v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetY:F

    .line 1095
    iget-object v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v9}, Landroid/widget/Editor;->getPositionListenerPostion()J

    move-result-wide v4

    .line 1096
    .local v4, pos:J
    #calls: Landroid/widget/MiuiCursorController;->extractRangeStartFromLong(J)I
    invoke-static {v4, v5}, Landroid/widget/MiuiCursorController;->access$300(J)I

    move-result v9

    iput v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentX:I

    .line 1097
    #calls: Landroid/widget/MiuiCursorController;->extractRangeEndFromLong(J)I
    invoke-static {v4, v5}, Landroid/widget/MiuiCursorController;->access$400(J)I

    move-result v9

    iput v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    .line 1098
    iput-boolean v11, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    goto :goto_9

    .line 1103
    .end local v4           #pos:J
    :pswitch_3f
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v7

    .line 1104
    .local v7, rawX:F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v8

    .line 1107
    .local v8, rawY:F
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetY:F

    iget v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    int-to-float v10, v10

    sub-float v6, v9, v10

    .line 1108
    .local v6, previousVerticalOffset:F
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    int-to-float v9, v9

    sub-float v9, v8, v9

    iget v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    int-to-float v10, v10

    sub-float v0, v9, v10

    .line 1110
    .local v0, currentVerticalOffset:F
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIdealVerticalOffset:F

    cmpg-float v9, v6, v9

    if-gez v9, :cond_83

    .line 1111
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIdealVerticalOffset:F

    invoke-static {v0, v9}, Ljava/lang/Math;->min(FF)F

    move-result v3

    .line 1112
    .local v3, newVerticalOffset:F
    invoke-static {v3, v6}, Ljava/lang/Math;->max(FF)F

    move-result v3

    .line 1117
    :goto_68
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    int-to-float v9, v9

    add-float/2addr v9, v3

    iput v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetY:F

    .line 1119
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetX:F

    sub-float v9, v7, v9

    iget v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHotspotX:I

    int-to-float v10, v10

    add-float v1, v9, v10

    .line 1120
    .local v1, newPosX:F
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetY:F

    sub-float v9, v8, v9

    iget v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchOffsetY:F

    add-float v2, v9, v10

    .line 1122
    .local v2, newPosY:F
    invoke-virtual {p0, v1, v2}, Landroid/widget/MiuiCursorController$MiuiHandleView;->updatePosition(FF)V

    goto :goto_9

    .line 1114
    .end local v1           #newPosX:F
    .end local v2           #newPosY:F
    .end local v3           #newVerticalOffset:F
    :cond_83
    iget v9, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIdealVerticalOffset:F

    invoke-static {v0, v9}, Ljava/lang/Math;->max(FF)F

    move-result v3

    .line 1115
    .restart local v3       #newVerticalOffset:F
    invoke-static {v3, v6}, Ljava/lang/Math;->min(FF)F

    move-result v3

    goto :goto_68

    .line 1127
    .end local v0           #currentVerticalOffset:F
    .end local v3           #newVerticalOffset:F
    .end local v6           #previousVerticalOffset:F
    .end local v7           #rawX:F
    .end local v8           #rawY:F
    :pswitch_8e
    invoke-direct {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->filterOnTouchUp()V

    .line 1128
    iput-boolean v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    goto/16 :goto_9

    .line 1132
    :pswitch_95
    iput-boolean v10, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    goto/16 :goto_9

    .line 1089
    nop

    :pswitch_data_9a
    .packed-switch 0x0
        :pswitch_f
        :pswitch_8e
        :pswitch_3f
        :pswitch_95
    .end packed-switch
.end method

.method public positionAtCursorOffset(IZ)V
    .registers 4
    .parameter "offset"
    .parameter "parentScrolled"

    .prologue
    .line 1003
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    if-nez v0, :cond_e

    .line 1005
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->prepareCursorControllers()V

    .line 1016
    :cond_d
    :goto_d
    return-void

    .line 1009
    :cond_e
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffset:I

    if-ne p1, v0, :cond_14

    if-eqz p2, :cond_d

    .line 1010
    :cond_14
    invoke-virtual {p0, p1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->updateSelection(I)V

    .line 1011
    invoke-direct {p0, p1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->addPositionToTouchUpFilter(I)V

    .line 1012
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->updatePositionXY(IZ)V

    .line 1013
    iput p1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffset:I

    .line 1014
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionHasChanged:Z

    goto :goto_d
.end method

.method public setCursorController(Landroid/widget/MiuiCursorController;)V
    .registers 2
    .parameter "cc"

    .prologue
    .line 942
    iput-object p1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mCursorController:Landroid/widget/MiuiCursorController;

    .line 943
    return-void
.end method

.method public setType(I)V
    .registers 2
    .parameter "type"

    .prologue
    .line 938
    iput p1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mType:I

    .line 939
    return-void
.end method

.method public show()V
    .registers 4

    .prologue
    .line 946
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

    .line 948
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_27

    .line 955
    :goto_26
    return-void

    .line 950
    :cond_27
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    const/4 v1, 0x1

    invoke-virtual {v0, p0, v1}, Landroid/widget/Editor;->addPositionListenerSubscriber(Landroid/widget/Editor$TextViewPositionListener;Z)V

    .line 953
    const/4 v0, -0x1

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPreviousOffset:I

    .line 954
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getCurrentCursorOffset()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/widget/MiuiCursorController$MiuiHandleView;->positionAtCursorOffset(IZ)V

    goto :goto_26
.end method

.method protected updateDrawable()V
    .registers 4

    .prologue
    .line 870
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getCurrentCursorOffset()I

    move-result v1

    .line 871
    .local v1, offset:I
    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/text/Layout;->isRtlCharAt(I)Z

    move-result v0

    .line 872
    .local v0, isRtlCharAtOffset:Z
    if-eqz v0, :cond_1d

    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawableRtl:Landroid/graphics/drawable/Drawable;

    :goto_12
    iput-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    .line 873
    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v2, v0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getHotspotX(Landroid/graphics/drawable/Drawable;Z)I

    move-result v2

    iput v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHotspotX:I

    .line 874
    return-void

    .line 872
    :cond_1d
    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mDrawableLtr:Landroid/graphics/drawable/Drawable;

    goto :goto_12
.end method

.method protected abstract updatePosition(FF)V
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

    .line 1039
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

    .line 1041
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->getCurrentCursorOffset()I

    move-result v0

    invoke-virtual {p0, v0, p4}, Landroid/widget/MiuiCursorController$MiuiHandleView;->positionAtCursorOffset(IZ)V

    .line 1042
    if-nez p3, :cond_3e

    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionHasChanged:Z

    if-eqz v0, :cond_9d

    .line 1043
    :cond_3e
    iget-boolean v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mIsDragging:Z

    if-eqz v0, :cond_76

    .line 1045
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentX:I

    if-ne p1, v0, :cond_4a

    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    if-eq p2, v0, :cond_73

    .line 1046
    :cond_4a
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetX:F

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentX:I

    sub-int v1, p1, v1

    int-to-float v1, v1

    add-float/2addr v0, v1

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetX:F

    .line 1047
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetY:F

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    sub-int v1, p2, v1

    int-to-float v1, v1

    add-float/2addr v0, v1

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTouchToWindowOffsetY:F

    .line 1048
    iput p1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentX:I

    .line 1049
    iput p2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mLastParentY:I

    .line 1050
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->hasMagnifierController()Z

    move-result v0

    if-eqz v0, :cond_73

    .line 1051
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->getMagnifierController()Landroid/widget/MagnifierController;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/MagnifierController;->onParentChanged()V

    .line 1054
    :cond_73
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->onHandleMoved()V

    .line 1058
    :cond_76
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_af

    .line 1059
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionX:I

    add-int/2addr v0, p1

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerX:I

    .line 1060
    iget v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    add-int/2addr v0, p2

    iput v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerY:I

    .line 1061
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->needShowHandle()Z

    move-result v0

    if-eqz v0, :cond_9b

    .line 1062
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_a3

    .line 1063
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    iget v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerX:I

    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerY:I

    invoke-virtual {v0, v1, v2, v3, v3}, Landroid/widget/PopupWindow;->update(IIII)V

    .line 1075
    :cond_9b
    :goto_9b
    iput-boolean v4, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionHasChanged:Z

    .line 1078
    :cond_9d
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mCursorController:Landroid/widget/MiuiCursorController;

    invoke-virtual {v0}, Landroid/widget/MiuiCursorController;->updatePosition()V

    .line 1079
    return-void

    .line 1065
    :cond_a3
    iget-object v0, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainer:Landroid/widget/PopupWindow;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerX:I

    iget v3, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerY:I

    invoke-virtual {v0, v1, v4, v2, v3}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    goto :goto_9b

    .line 1070
    :cond_af
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_9b

    .line 1071
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$MiuiHandleView;->dismiss()V

    goto :goto_9b
.end method

.method protected updatePositionXY(IZ)V
    .registers 7
    .parameter "offset"
    .parameter "container"

    .prologue
    .line 1020
    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v0

    .line 1021
    .local v0, line:I
    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/text/Layout;->getPrimaryHorizontal(I)F

    move-result v2

    const/high16 v3, 0x3f00

    sub-float/2addr v2, v3

    iget v3, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mHotspotX:I

    int-to-float v3, v3

    sub-float/2addr v2, v3

    float-to-int v2, v2

    iput v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionX:I

    .line 1022
    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/text/Layout;->getLineBottom(I)I

    move-result v2

    iput v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    .line 1025
    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionX:I

    iget-object v3, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->viewportToContentHorizontalOffset()I

    move-result v3

    add-int/2addr v2, v3

    iput v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionX:I

    .line 1026
    iget v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    iget-object v3, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->viewportToContentVerticalOffset()I

    move-result v3

    add-int/2addr v2, v3

    iput v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    .line 1028
    if-eqz p2, :cond_5a

    .line 1029
    const/4 v2, 0x2

    new-array v1, v2, [I

    .line 1030
    .local v1, location:[I
    iget-object v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->getLocationOnScreen([I)V

    .line 1031
    const/4 v2, 0x0

    aget v2, v1, v2

    iget v3, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionX:I

    add-int/2addr v2, v3

    iput v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerX:I

    .line 1032
    const/4 v2, 0x1

    aget v2, v1, v2

    iget v3, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mPositionY:I

    add-int/2addr v2, v3

    iput v2, p0, Landroid/widget/MiuiCursorController$MiuiHandleView;->mContainerY:I

    .line 1034
    .end local v1           #location:[I
    :cond_5a
    return-void
.end method

.method protected abstract updateSelection(I)V
.end method
