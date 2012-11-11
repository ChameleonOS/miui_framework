.class public Lcom/android/internal/widget/WeightedLinearLayout;
.super Landroid/widget/LinearLayout;
.source "WeightedLinearLayout.java"


# instance fields
.field private mMajorWeightMax:F

.field private mMajorWeightMin:F

.field private mMinorWeightMax:F

.field private mMinorWeightMin:F


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 2
    .parameter "context"

    .prologue
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 6
    .parameter "context"
    .parameter "attrs"

    .prologue
    const/4 v2, 0x0

    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    sget-object v1, Lcom/android/internal/R$styleable;->WeightedLinearLayout:[I

    invoke-virtual {p1, p2, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v1, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    iput v1, p0, Lcom/android/internal/widget/WeightedLinearLayout;->mMajorWeightMin:F

    const/4 v1, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    iput v1, p0, Lcom/android/internal/widget/WeightedLinearLayout;->mMinorWeightMin:F

    const/4 v1, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    iput v1, p0, Lcom/android/internal/widget/WeightedLinearLayout;->mMajorWeightMax:F

    const/4 v1, 0x3

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    iput v1, p0, Lcom/android/internal/widget/WeightedLinearLayout;->mMinorWeightMax:F

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    return-void
.end method


# virtual methods
.method protected onMeasure(II)V
    .registers 16
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    const/4 v12, 0x0

    const/high16 v11, 0x4000

    invoke-virtual {p0}, Lcom/android/internal/widget/WeightedLinearLayout;->getContext()Landroid/content/Context;

    move-result-object v10

    invoke-virtual {v10}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    invoke-virtual {v10}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    .local v2, metrics:Landroid/util/DisplayMetrics;
    iget v3, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    .local v3, screenWidth:I
    iget v10, v2, Landroid/util/DisplayMetrics;->heightPixels:I

    if-ge v3, v10, :cond_49

    const/4 v0, 0x1

    .local v0, isPortrait:Z
    :goto_16
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v7

    .local v7, widthMode:I
    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->onMeasure(II)V

    invoke-virtual {p0}, Lcom/android/internal/widget/WeightedLinearLayout;->getMeasuredWidth()I

    move-result v6

    .local v6, width:I
    const/4 v1, 0x0

    .local v1, measure:Z
    invoke-static {v6, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result p1

    if-eqz v0, :cond_4b

    iget v9, p0, Lcom/android/internal/widget/WeightedLinearLayout;->mMinorWeightMin:F

    .local v9, widthWeightMin:F
    :goto_2a
    if-eqz v0, :cond_4e

    iget v8, p0, Lcom/android/internal/widget/WeightedLinearLayout;->mMinorWeightMax:F

    .local v8, widthWeightMax:F
    :goto_2e
    const/high16 v10, -0x8000

    if-ne v7, v10, :cond_43

    int-to-float v10, v3

    mul-float/2addr v10, v9

    float-to-int v5, v10

    .local v5, weightedMin:I
    int-to-float v10, v3

    mul-float/2addr v10, v9

    float-to-int v4, v10

    .local v4, weightedMax:I
    cmpl-float v10, v9, v12

    if-lez v10, :cond_51

    if-ge v6, v5, :cond_51

    invoke-static {v5, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result p1

    const/4 v1, 0x1

    .end local v4           #weightedMax:I
    .end local v5           #weightedMin:I
    :cond_43
    :goto_43
    if-eqz v1, :cond_48

    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->onMeasure(II)V

    :cond_48
    return-void

    .end local v0           #isPortrait:Z
    .end local v1           #measure:Z
    .end local v6           #width:I
    .end local v7           #widthMode:I
    .end local v8           #widthWeightMax:F
    .end local v9           #widthWeightMin:F
    :cond_49
    const/4 v0, 0x0

    goto :goto_16

    .restart local v0       #isPortrait:Z
    .restart local v1       #measure:Z
    .restart local v6       #width:I
    .restart local v7       #widthMode:I
    :cond_4b
    iget v9, p0, Lcom/android/internal/widget/WeightedLinearLayout;->mMajorWeightMin:F

    goto :goto_2a

    .restart local v9       #widthWeightMin:F
    :cond_4e
    iget v8, p0, Lcom/android/internal/widget/WeightedLinearLayout;->mMajorWeightMax:F

    goto :goto_2e

    .restart local v4       #weightedMax:I
    .restart local v5       #weightedMin:I
    .restart local v8       #widthWeightMax:F
    :cond_51
    cmpl-float v10, v8, v12

    if-lez v10, :cond_43

    if-le v6, v4, :cond_43

    invoke-static {v4, v11}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result p1

    const/4 v1, 0x1

    goto :goto_43
.end method
