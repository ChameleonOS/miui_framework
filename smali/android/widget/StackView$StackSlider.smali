.class Landroid/widget/StackView$StackSlider;
.super Ljava/lang/Object;
.source "StackView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/StackView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "StackSlider"
.end annotation


# static fields
.field static final BEGINNING_OF_STACK_MODE:I = 0x1

.field static final END_OF_STACK_MODE:I = 0x2

.field static final NORMAL_MODE:I


# instance fields
.field mMode:I

.field mView:Landroid/view/View;

.field mXProgress:F

.field mYProgress:F

.field final synthetic this$0:Landroid/widget/StackView;


# direct methods
.method public constructor <init>(Landroid/widget/StackView;)V
    .registers 3
    .parameter

    .prologue
    .line 900
    iput-object p1, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 898
    const/4 v0, 0x0

    iput v0, p0, Landroid/widget/StackView$StackSlider;->mMode:I

    .line 901
    return-void
.end method

.method public constructor <init>(Landroid/widget/StackView;Landroid/widget/StackView$StackSlider;)V
    .registers 4
    .parameter
    .parameter "copy"

    .prologue
    .line 903
    iput-object p1, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 898
    const/4 v0, 0x0

    iput v0, p0, Landroid/widget/StackView$StackSlider;->mMode:I

    .line 904
    iget-object v0, p2, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    iput-object v0, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    .line 905
    iget v0, p2, Landroid/widget/StackView$StackSlider;->mYProgress:F

    iput v0, p0, Landroid/widget/StackView$StackSlider;->mYProgress:F

    .line 906
    iget v0, p2, Landroid/widget/StackView$StackSlider;->mXProgress:F

    iput v0, p0, Landroid/widget/StackView$StackSlider;->mXProgress:F

    .line 907
    iget v0, p2, Landroid/widget/StackView$StackSlider;->mMode:I

    iput v0, p0, Landroid/widget/StackView$StackSlider;->mMode:I

    .line 908
    return-void
.end method

.method private cubic(F)F
    .registers 7
    .parameter "r"

    .prologue
    const/high16 v4, 0x4000

    .line 911
    mul-float v0, v4, p1

    const/high16 v1, 0x3f80

    sub-float/2addr v0, v1

    float-to-double v0, v0

    const-wide/high16 v2, 0x4008

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    const-wide/high16 v2, 0x3ff0

    add-double/2addr v0, v2

    double-to-float v0, v0

    div-float/2addr v0, v4

    return v0
.end method

.method private getDuration(ZF)F
    .registers 15
    .parameter "invert"
    .parameter "velocity"

    .prologue
    const/high16 v11, 0x43c8

    const/4 v4, 0x0

    const-wide/high16 v9, 0x4000

    .line 1043
    iget-object v5, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    if-eqz v5, :cond_77

    .line 1044
    iget-object v5, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Landroid/widget/StackView$LayoutParams;

    .line 1046
    .local v3, viewLp:Landroid/widget/StackView$LayoutParams;
    iget v5, v3, Landroid/widget/StackView$LayoutParams;->horizontalOffset:I

    int-to-double v5, v5

    invoke-static {v5, v6, v9, v10}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v5

    iget v7, v3, Landroid/widget/StackView$LayoutParams;->verticalOffset:I

    int-to-double v7, v7

    invoke-static {v7, v8, v9, v10}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v7

    add-double/2addr v5, v7

    invoke-static {v5, v6}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v5

    double-to-float v0, v5

    .line 1048
    .local v0, d:F
    iget-object v5, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mSlideAmount:I
    invoke-static {v5}, Landroid/widget/StackView;->access$200(Landroid/widget/StackView;)I

    move-result v5

    int-to-double v5, v5

    invoke-static {v5, v6, v9, v10}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v5

    const v7, 0x3ecccccd

    iget-object v8, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mSlideAmount:I
    invoke-static {v8}, Landroid/widget/StackView;->access$200(Landroid/widget/StackView;)I

    move-result v8

    int-to-float v8, v8

    mul-float/2addr v7, v8

    float-to-double v7, v7

    invoke-static {v7, v8, v9, v10}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v7

    add-double/2addr v5, v7

    invoke-static {v5, v6}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v5

    double-to-float v2, v5

    .line 1051
    .local v2, maxd:F
    cmpl-float v5, p2, v4

    if-nez v5, :cond_57

    .line 1052
    if-eqz p1, :cond_54

    const/high16 v4, 0x3f80

    div-float v5, v0, v2

    sub-float/2addr v4, v5

    :goto_51
    mul-float v1, v4, v11

    .line 1064
    .end local v0           #d:F
    .end local v2           #maxd:F
    .end local v3           #viewLp:Landroid/widget/StackView$LayoutParams;
    :cond_53
    :goto_53
    return v1

    .line 1052
    .restart local v0       #d:F
    .restart local v2       #maxd:F
    .restart local v3       #viewLp:Landroid/widget/StackView$LayoutParams;
    :cond_54
    div-float v4, v0, v2

    goto :goto_51

    .line 1054
    :cond_57
    if-eqz p1, :cond_6e

    invoke-static {p2}, Ljava/lang/Math;->abs(F)F

    move-result v5

    div-float v1, v0, v5

    .line 1056
    .local v1, duration:F
    :goto_5f
    const/high16 v5, 0x4248

    cmpg-float v5, v1, v5

    if-ltz v5, :cond_69

    cmpl-float v5, v1, v11

    if-lez v5, :cond_53

    .line 1058
    :cond_69
    invoke-direct {p0, p1, v4}, Landroid/widget/StackView$StackSlider;->getDuration(ZF)F

    move-result v1

    goto :goto_53

    .line 1054
    .end local v1           #duration:F
    :cond_6e
    sub-float v5, v2, v0

    invoke-static {p2}, Ljava/lang/Math;->abs(F)F

    move-result v6

    div-float v1, v5, v6

    goto :goto_5f

    .end local v0           #d:F
    .end local v2           #maxd:F
    .end local v3           #viewLp:Landroid/widget/StackView$LayoutParams;
    :cond_77
    move v1, v4

    .line 1064
    goto :goto_53
.end method

.method private highlightAlphaInterpolator(F)F
    .registers 7
    .parameter "r"

    .prologue
    const/high16 v4, 0x3f80

    const v3, 0x3f59999a

    .line 915
    const v0, 0x3ecccccd

    .line 916
    .local v0, pivot:F
    cmpg-float v1, p1, v0

    if-gez v1, :cond_14

    .line 917
    div-float v1, p1, v0

    invoke-direct {p0, v1}, Landroid/widget/StackView$StackSlider;->cubic(F)F

    move-result v1

    mul-float/2addr v1, v3

    .line 919
    :goto_13
    return v1

    :cond_14
    sub-float v1, p1, v0

    sub-float v2, v4, v0

    div-float/2addr v1, v2

    sub-float v1, v4, v1

    invoke-direct {p0, v1}, Landroid/widget/StackView$StackSlider;->cubic(F)F

    move-result v1

    mul-float/2addr v1, v3

    goto :goto_13
.end method

.method private rotationInterpolator(F)F
    .registers 5
    .parameter "r"

    .prologue
    .line 933
    const v0, 0x3e4ccccd

    .line 934
    .local v0, pivot:F
    cmpg-float v1, p1, v0

    if-gez v1, :cond_9

    .line 935
    const/4 v1, 0x0

    .line 937
    :goto_8
    return v1

    :cond_9
    sub-float v1, p1, v0

    const/high16 v2, 0x3f80

    sub-float/2addr v2, v0

    div-float/2addr v1, v2

    goto :goto_8
.end method

.method private viewAlphaInterpolator(F)F
    .registers 5
    .parameter "r"

    .prologue
    .line 924
    const v0, 0x3e99999a

    .line 925
    .local v0, pivot:F
    cmpl-float v1, p1, v0

    if-lez v1, :cond_e

    .line 926
    sub-float v1, p1, v0

    const/high16 v2, 0x3f80

    sub-float/2addr v2, v0

    div-float/2addr v1, v2

    .line 928
    :goto_d
    return v1

    :cond_e
    const/4 v1, 0x0

    goto :goto_d
.end method


# virtual methods
.method getDurationForNeutralPosition()F
    .registers 3

    .prologue
    .line 1027
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Landroid/widget/StackView$StackSlider;->getDuration(ZF)F

    move-result v0

    return v0
.end method

.method getDurationForNeutralPosition(F)F
    .registers 3
    .parameter "velocity"

    .prologue
    .line 1035
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1}, Landroid/widget/StackView$StackSlider;->getDuration(ZF)F

    move-result v0

    return v0
.end method

.method getDurationForOffscreenPosition()F
    .registers 3

    .prologue
    .line 1031
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Landroid/widget/StackView$StackSlider;->getDuration(ZF)F

    move-result v0

    return v0
.end method

.method getDurationForOffscreenPosition(F)F
    .registers 3
    .parameter "velocity"

    .prologue
    .line 1039
    const/4 v0, 0x1

    invoke-direct {p0, v0, p1}, Landroid/widget/StackView$StackSlider;->getDuration(ZF)F

    move-result v0

    return v0
.end method

.method public getXProgress()F
    .registers 2

    .prologue
    .line 1076
    iget v0, p0, Landroid/widget/StackView$StackSlider;->mXProgress:F

    return v0
.end method

.method public getYProgress()F
    .registers 2

    .prologue
    .line 1070
    iget v0, p0, Landroid/widget/StackView$StackSlider;->mYProgress:F

    return v0
.end method

.method setMode(I)V
    .registers 2
    .parameter "mode"

    .prologue
    .line 1023
    iput p1, p0, Landroid/widget/StackView$StackSlider;->mMode:I

    .line 1024
    return-void
.end method

.method setView(Landroid/view/View;)V
    .registers 2
    .parameter "v"

    .prologue
    .line 942
    iput-object p1, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    .line 943
    return-void
.end method

.method public setXProgress(F)V
    .registers 5
    .parameter "r"

    .prologue
    .line 1008
    const/high16 v2, 0x4000

    invoke-static {v2, p1}, Ljava/lang/Math;->min(FF)F

    move-result p1

    .line 1009
    const/high16 v2, -0x4000

    invoke-static {v2, p1}, Ljava/lang/Math;->max(FF)F

    move-result p1

    .line 1011
    iput p1, p0, Landroid/widget/StackView$StackSlider;->mXProgress:F

    .line 1013
    iget-object v2, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    if-nez v2, :cond_13

    .line 1020
    :goto_12
    return-void

    .line 1014
    :cond_13
    iget-object v2, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/StackView$LayoutParams;

    .line 1015
    .local v1, viewLp:Landroid/widget/StackView$LayoutParams;
    iget-object v2, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;
    invoke-static {v2}, Landroid/widget/StackView;->access$000(Landroid/widget/StackView;)Landroid/widget/ImageView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/StackView$LayoutParams;

    .line 1017
    .local v0, highlightLp:Landroid/widget/StackView$LayoutParams;
    const v2, 0x3e4ccccd

    mul-float/2addr p1, v2

    .line 1018
    iget-object v2, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mSlideAmount:I
    invoke-static {v2}, Landroid/widget/StackView;->access$200(Landroid/widget/StackView;)I

    move-result v2

    int-to-float v2, v2

    mul-float/2addr v2, p1

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/StackView$LayoutParams;->setHorizontalOffset(I)V

    .line 1019
    iget-object v2, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mSlideAmount:I
    invoke-static {v2}, Landroid/widget/StackView;->access$200(Landroid/widget/StackView;)I

    move-result v2

    int-to-float v2, v2

    mul-float/2addr v2, p1

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    invoke-virtual {v0, v2}, Landroid/widget/StackView$LayoutParams;->setHorizontalOffset(I)V

    goto :goto_12
.end method

.method public setYProgress(F)V
    .registers 14
    .parameter "r"

    .prologue
    const/4 v11, 0x0

    const/high16 v10, 0x42b4

    const v9, 0x3e4ccccd

    const/high16 v8, 0x3f80

    const/4 v7, 0x0

    .line 947
    invoke-static {v8, p1}, Ljava/lang/Math;->min(FF)F

    move-result p1

    .line 948
    invoke-static {v7, p1}, Ljava/lang/Math;->max(FF)F

    move-result p1

    .line 950
    iput p1, p0, Landroid/widget/StackView$StackSlider;->mYProgress:F

    .line 951
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    if-nez v4, :cond_18

    .line 1004
    :goto_17
    return-void

    .line 953
    :cond_18
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Landroid/widget/StackView$LayoutParams;

    .line 954
    .local v3, viewLp:Landroid/widget/StackView$LayoutParams;
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;
    invoke-static {v4}, Landroid/widget/StackView;->access$000(Landroid/widget/StackView;)Landroid/widget/ImageView;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/StackView$LayoutParams;

    .line 956
    .local v1, highlightLp:Landroid/widget/StackView$LayoutParams;
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mStackMode:I
    invoke-static {v4}, Landroid/widget/StackView;->access$100(Landroid/widget/StackView;)I

    move-result v4

    if-nez v4, :cond_cf

    const/4 v2, 0x1

    .line 960
    .local v2, stackDirection:I
    :goto_35
    iget v4, p0, Landroid/widget/StackView$StackSlider;->mYProgress:F

    invoke-static {v7, v4}, Ljava/lang/Float;->compare(FF)I

    move-result v4

    if-eqz v4, :cond_d2

    iget v4, p0, Landroid/widget/StackView$StackSlider;->mYProgress:F

    invoke-static {v8, v4}, Ljava/lang/Float;->compare(FF)I

    move-result v4

    if-eqz v4, :cond_d2

    .line 961
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getLayerType()I

    move-result v4

    if-nez v4, :cond_54

    .line 962
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    const/4 v5, 0x2

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    .line 970
    :cond_54
    :goto_54
    iget v4, p0, Landroid/widget/StackView$StackSlider;->mMode:I

    packed-switch v4, :pswitch_data_168

    goto :goto_17

    .line 972
    :pswitch_5a
    neg-float v4, p1

    int-to-float v5, v2

    mul-float/2addr v4, v5

    iget-object v5, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mSlideAmount:I
    invoke-static {v5}, Landroid/widget/StackView;->access$200(Landroid/widget/StackView;)I

    move-result v5

    int-to-float v5, v5

    mul-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/StackView$LayoutParams;->setVerticalOffset(I)V

    .line 973
    neg-float v4, p1

    int-to-float v5, v2

    mul-float/2addr v4, v5

    iget-object v5, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mSlideAmount:I
    invoke-static {v5}, Landroid/widget/StackView;->access$200(Landroid/widget/StackView;)I

    move-result v5

    int-to-float v5, v5

    mul-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v4

    invoke-virtual {v1, v4}, Landroid/widget/StackView$LayoutParams;->setVerticalOffset(I)V

    .line 974
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;
    invoke-static {v4}, Landroid/widget/StackView;->access$000(Landroid/widget/StackView;)Landroid/widget/ImageView;

    move-result-object v4

    invoke-direct {p0, p1}, Landroid/widget/StackView$StackSlider;->highlightAlphaInterpolator(F)F

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setAlpha(F)V

    .line 976
    sub-float v4, v8, p1

    invoke-direct {p0, v4}, Landroid/widget/StackView$StackSlider;->viewAlphaInterpolator(F)F

    move-result v0

    .line 980
    .local v0, alpha:F
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getAlpha()F

    move-result v4

    cmpl-float v4, v4, v7

    if-nez v4, :cond_e2

    cmpl-float v4, v0, v7

    if-eqz v4, :cond_e2

    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getVisibility()I

    move-result v4

    if-eqz v4, :cond_e2

    .line 981
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    invoke-virtual {v4, v11}, Landroid/view/View;->setVisibility(I)V

    .line 987
    :cond_ac
    :goto_ac
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    invoke-virtual {v4, v0}, Landroid/view/View;->setAlpha(F)V

    .line 988
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    int-to-float v5, v2

    mul-float/2addr v5, v10

    invoke-direct {p0, p1}, Landroid/widget/StackView$StackSlider;->rotationInterpolator(F)F

    move-result v6

    mul-float/2addr v5, v6

    invoke-virtual {v4, v5}, Landroid/view/View;->setRotationX(F)V

    .line 989
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;
    invoke-static {v4}, Landroid/widget/StackView;->access$000(Landroid/widget/StackView;)Landroid/widget/ImageView;

    move-result-object v4

    int-to-float v5, v2

    mul-float/2addr v5, v10

    invoke-direct {p0, p1}, Landroid/widget/StackView$StackSlider;->rotationInterpolator(F)F

    move-result v6

    mul-float/2addr v5, v6

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setRotationX(F)V

    goto/16 :goto_17

    .line 956
    .end local v0           #alpha:F
    .end local v2           #stackDirection:I
    :cond_cf
    const/4 v2, -0x1

    goto/16 :goto_35

    .line 965
    .restart local v2       #stackDirection:I
    :cond_d2
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getLayerType()I

    move-result v4

    if-eqz v4, :cond_54

    .line 966
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v4, v11, v5}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    goto/16 :goto_54

    .line 982
    .restart local v0       #alpha:F
    :cond_e2
    cmpl-float v4, v0, v7

    if-nez v4, :cond_ac

    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getAlpha()F

    move-result v4

    cmpl-float v4, v4, v7

    if-eqz v4, :cond_ac

    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    invoke-virtual {v4}, Landroid/view/View;->getVisibility()I

    move-result v4

    if-nez v4, :cond_ac

    .line 984
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->mView:Landroid/view/View;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    goto :goto_ac

    .line 992
    .end local v0           #alpha:F
    :pswitch_ff
    mul-float/2addr p1, v9

    .line 993
    neg-int v4, v2

    int-to-float v4, v4

    mul-float/2addr v4, p1

    iget-object v5, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mSlideAmount:I
    invoke-static {v5}, Landroid/widget/StackView;->access$200(Landroid/widget/StackView;)I

    move-result v5

    int-to-float v5, v5

    mul-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/StackView$LayoutParams;->setVerticalOffset(I)V

    .line 994
    neg-int v4, v2

    int-to-float v4, v4

    mul-float/2addr v4, p1

    iget-object v5, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mSlideAmount:I
    invoke-static {v5}, Landroid/widget/StackView;->access$200(Landroid/widget/StackView;)I

    move-result v5

    int-to-float v5, v5

    mul-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v4

    invoke-virtual {v1, v4}, Landroid/widget/StackView$LayoutParams;->setVerticalOffset(I)V

    .line 995
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;
    invoke-static {v4}, Landroid/widget/StackView;->access$000(Landroid/widget/StackView;)Landroid/widget/ImageView;

    move-result-object v4

    invoke-direct {p0, p1}, Landroid/widget/StackView$StackSlider;->highlightAlphaInterpolator(F)F

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setAlpha(F)V

    goto/16 :goto_17

    .line 998
    :pswitch_133
    sub-float v4, v8, p1

    mul-float p1, v4, v9

    .line 999
    int-to-float v4, v2

    mul-float/2addr v4, p1

    iget-object v5, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mSlideAmount:I
    invoke-static {v5}, Landroid/widget/StackView;->access$200(Landroid/widget/StackView;)I

    move-result v5

    int-to-float v5, v5

    mul-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/StackView$LayoutParams;->setVerticalOffset(I)V

    .line 1000
    int-to-float v4, v2

    mul-float/2addr v4, p1

    iget-object v5, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mSlideAmount:I
    invoke-static {v5}, Landroid/widget/StackView;->access$200(Landroid/widget/StackView;)I

    move-result v5

    int-to-float v5, v5

    mul-float/2addr v4, v5

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v4

    invoke-virtual {v1, v4}, Landroid/widget/StackView$LayoutParams;->setVerticalOffset(I)V

    .line 1001
    iget-object v4, p0, Landroid/widget/StackView$StackSlider;->this$0:Landroid/widget/StackView;

    #getter for: Landroid/widget/StackView;->mHighlight:Landroid/widget/ImageView;
    invoke-static {v4}, Landroid/widget/StackView;->access$000(Landroid/widget/StackView;)Landroid/widget/ImageView;

    move-result-object v4

    invoke-direct {p0, p1}, Landroid/widget/StackView$StackSlider;->highlightAlphaInterpolator(F)F

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setAlpha(F)V

    goto/16 :goto_17

    .line 970
    :pswitch_data_168
    .packed-switch 0x0
        :pswitch_5a
        :pswitch_133
        :pswitch_ff
    .end packed-switch
.end method
