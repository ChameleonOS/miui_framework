.class public Lmiui/animation/ViewPropertyAnimator;
.super Landroid/animation/Animator;
.source "ViewPropertyAnimator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/animation/ViewPropertyAnimator$Builder;
    }
.end annotation


# static fields
.field public static final ALPHA:I = 0x200

.field public static final CURRENT_HALF_HEIGHT:F = 0.01f

.field public static final CURRENT_HALF_WIDTH:F = 0.0070f

.field public static final CURRENT_HEIGHT:F = 0.0080f

.field public static final CURRENT_HEIGHT_NEGATIVE:F = 0.0090f

.field public static final CURRENT_VALUE:F = 3.4028235E38f

.field public static final CURRENT_WIDTH:F = 0.0050f

.field public static final CURRENT_WIDTH_NEGATIVE:F = 0.0060f

#the value of this static final field might be set in the static constructor
.field private static final DISPLAY_METRICES_HEIGHT:I = 0x0

#the value of this static final field might be set in the static constructor
.field private static final DISPLAY_METRICES_WIDTH:I = 0x0

.field public static final NO_FINAL_VALUE:F = 1.4E-45f

.field public static final NO_FINAL_VISIBILITY:I = -0x1

.field public static final OUT_BOTTOM_SCREEN:F = 0.0020f

.field public static final OUT_LEFT_SCREEN:F = 0.0030f

.field public static final OUT_RIGHT_SCREEN:F = 0.0040f

.field public static final OUT_TOP_SCREEN:F = 0.0010f

.field public static final ROTATION:I = 0x10

.field public static final ROTATION_X:I = 0x20

.field public static final ROTATION_Y:I = 0x40

.field public static final SCALE_X:I = 0x4

.field public static final SCALE_Y:I = 0x8

.field public static final TRANSLATION_X:I = 0x1

.field public static final TRANSLATION_Y:I = 0x2

.field public static final X:I = 0x80

.field public static final Y:I = 0x100

.field private static final mAnimatorMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Object;",
            "Landroid/animation/Animator;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mAnimator:Landroid/animation/ValueAnimator;

.field private mFinalValue:F

.field private mFinalVisibility:I

.field private mFromValue:F

.field private mProperty:I

.field private mToValue:F

.field private mView:Landroid/view/View;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    sput v0, Lmiui/animation/ViewPropertyAnimator;->DISPLAY_METRICES_WIDTH:I

    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    sput v0, Lmiui/animation/ViewPropertyAnimator;->DISPLAY_METRICES_HEIGHT:I

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lmiui/animation/ViewPropertyAnimator;->mAnimatorMap:Ljava/util/HashMap;

    return-void
.end method

.method public constructor <init>(Landroid/view/View;IFF)V
    .registers 8
    .parameter "view"
    .parameter "property"
    .parameter "fromValue"
    .parameter "toValue"

    .prologue
    invoke-direct {p0}, Landroid/animation/Animator;-><init>()V

    const/4 v0, 0x1

    new-array v0, v0, [F

    const/4 v1, 0x0

    const/high16 v2, 0x3f80

    aput v2, v0, v1

    invoke-static {v0}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    move-result-object v0

    iput-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    const/4 v0, -0x1

    iput v0, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalVisibility:I

    const/4 v0, 0x1

    iput v0, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalValue:F

    iput-object p1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    iput p2, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    iput p3, p0, Lmiui/animation/ViewPropertyAnimator;->mFromValue:F

    iput p4, p0, Lmiui/animation/ViewPropertyAnimator;->mToValue:F

    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    new-instance v1, Lmiui/animation/ViewPropertyAnimator$1;

    invoke-direct {v1, p0}, Lmiui/animation/ViewPropertyAnimator$1;-><init>(Lmiui/animation/ViewPropertyAnimator;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    new-instance v1, Lmiui/animation/ViewPropertyAnimator$2;

    invoke-direct {v1, p0}, Lmiui/animation/ViewPropertyAnimator$2;-><init>(Lmiui/animation/ViewPropertyAnimator;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    return-void
.end method

.method static synthetic access$000(Lmiui/animation/ViewPropertyAnimator;)Landroid/view/View;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$100(Landroid/view/View;Landroid/animation/Animator;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-static {p0, p1}, Lmiui/animation/ViewPropertyAnimator;->setAnimator(Landroid/view/View;Landroid/animation/Animator;)V

    return-void
.end method

.method static synthetic access$200(Lmiui/animation/ViewPropertyAnimator;)V
    .registers 1
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Lmiui/animation/ViewPropertyAnimator;->setFinalValues()V

    return-void
.end method

.method static synthetic access$300(Lmiui/animation/ViewPropertyAnimator;)F
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Lmiui/animation/ViewPropertyAnimator;->mFromValue:F

    return v0
.end method

.method static synthetic access$400(Lmiui/animation/ViewPropertyAnimator;)F
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Lmiui/animation/ViewPropertyAnimator;->mToValue:F

    return v0
.end method

.method static synthetic access$500(Lmiui/animation/ViewPropertyAnimator;F)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Lmiui/animation/ViewPropertyAnimator;->setValue(F)V

    return-void
.end method

.method private calulateAnimatorValue(F)F
    .registers 9
    .parameter "value"

    .prologue
    const/high16 v6, 0x4000

    const/16 v5, 0x100

    const/16 v4, 0x80

    const/4 v3, 0x1

    const/4 v2, 0x2

    const v1, 0x3b449ba6

    cmpl-float v1, p1, v1

    if-nez v1, :cond_32

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    if-eq v1, v4, :cond_17

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    if-ne v1, v3, :cond_31

    :cond_17
    new-array v0, v2, [I

    .local v0, location:[I
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->getLocationOnScreen([I)V

    sget v1, Lmiui/animation/ViewPropertyAnimator;->DISPLAY_METRICES_WIDTH:I

    const/4 v2, 0x0

    aget v2, v0, v2

    sub-int/2addr v1, v2

    int-to-float p1, v1

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    if-ne v1, v4, :cond_31

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v1

    int-to-float v1, v1

    add-float/2addr p1, v1

    .end local v0           #location:[I
    :cond_31
    :goto_31
    return p1

    :cond_32
    const v1, 0x3b83126f

    cmpl-float v1, p1, v1

    if-nez v1, :cond_61

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    if-eq v1, v4, :cond_41

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    if-ne v1, v3, :cond_31

    :cond_41
    new-array v0, v2, [I

    .restart local v0       #location:[I
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->getLocationOnScreen([I)V

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {p0, v1}, Lmiui/animation/ViewPropertyAnimator;->getWidthOrMeasureWidth(Landroid/view/View;)F

    move-result v1

    const/4 v2, 0x0

    aget v2, v0, v2

    int-to-float v2, v2

    add-float/2addr v1, v2

    neg-float p1, v1

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    if-ne v1, v4, :cond_31

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLeft()I

    move-result v1

    int-to-float v1, v1

    add-float/2addr p1, v1

    goto :goto_31

    .end local v0           #location:[I
    :cond_61
    const v1, 0x3a83126f

    cmpl-float v1, p1, v1

    if-nez v1, :cond_8f

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    if-eq v1, v5, :cond_70

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    if-ne v1, v2, :cond_31

    :cond_70
    new-array v0, v2, [I

    .restart local v0       #location:[I
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->getLocationOnScreen([I)V

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-static {v1}, Lmiui/animation/ViewPropertyAnimator;->getHeightOrMeasureHeight(Landroid/view/View;)F

    move-result v1

    aget v2, v0, v3

    int-to-float v2, v2

    add-float/2addr v1, v2

    neg-float p1, v1

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    if-ne v1, v5, :cond_31

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v1

    int-to-float v1, v1

    add-float/2addr p1, v1

    goto :goto_31

    .end local v0           #location:[I
    :cond_8f
    const v1, 0x3b03126f

    cmpl-float v1, p1, v1

    if-nez v1, :cond_b9

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    if-eq v1, v5, :cond_9e

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    if-ne v1, v2, :cond_31

    :cond_9e
    new-array v0, v2, [I

    .restart local v0       #location:[I
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->getLocationOnScreen([I)V

    sget v1, Lmiui/animation/ViewPropertyAnimator;->DISPLAY_METRICES_HEIGHT:I

    aget v2, v0, v3

    sub-int/2addr v1, v2

    int-to-float p1, v1

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    if-ne v1, v5, :cond_31

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v1

    int-to-float v1, v1

    add-float/2addr p1, v1

    goto/16 :goto_31

    .end local v0           #location:[I
    :cond_b9
    const v1, 0x3c03126f

    cmpl-float v1, p1, v1

    if-nez v1, :cond_c8

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-static {v1}, Lmiui/animation/ViewPropertyAnimator;->getHeightOrMeasureHeight(Landroid/view/View;)F

    move-result p1

    goto/16 :goto_31

    :cond_c8
    const v1, 0x3ba3d70a

    cmpl-float v1, p1, v1

    if-nez v1, :cond_d7

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {p0, v1}, Lmiui/animation/ViewPropertyAnimator;->getWidthOrMeasureWidth(Landroid/view/View;)F

    move-result p1

    goto/16 :goto_31

    :cond_d7
    const v1, 0x3c1374bc

    cmpl-float v1, p1, v1

    if-nez v1, :cond_e7

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-static {v1}, Lmiui/animation/ViewPropertyAnimator;->getHeightOrMeasureHeight(Landroid/view/View;)F

    move-result v1

    neg-float p1, v1

    goto/16 :goto_31

    :cond_e7
    const v1, 0x3bc49ba6

    cmpl-float v1, p1, v1

    if-nez v1, :cond_f7

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {p0, v1}, Lmiui/animation/ViewPropertyAnimator;->getWidthOrMeasureWidth(Landroid/view/View;)F

    move-result v1

    neg-float p1, v1

    goto/16 :goto_31

    :cond_f7
    const v1, 0x3c23d70a

    cmpl-float v1, p1, v1

    if-nez v1, :cond_108

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-static {v1}, Lmiui/animation/ViewPropertyAnimator;->getHeightOrMeasureHeight(Landroid/view/View;)F

    move-result v1

    div-float p1, v1, v6

    goto/16 :goto_31

    :cond_108
    const v1, 0x3be56042

    cmpl-float v1, p1, v1

    if-nez v1, :cond_119

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {p0, v1}, Lmiui/animation/ViewPropertyAnimator;->getWidthOrMeasureWidth(Landroid/view/View;)F

    move-result v1

    div-float p1, v1, v6

    goto/16 :goto_31

    :cond_119
    const v1, 0x7f7fffff

    cmpl-float v1, p1, v1

    if-nez v1, :cond_31

    invoke-direct {p0}, Lmiui/animation/ViewPropertyAnimator;->getValue()F

    move-result p1

    goto/16 :goto_31
.end method

.method public static cancelAnimator(Landroid/view/View;)V
    .registers 3
    .parameter "view"

    .prologue
    sget-object v1, Lmiui/animation/ViewPropertyAnimator;->mAnimatorMap:Ljava/util/HashMap;

    invoke-virtual {v1, p0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Animator;

    .local v0, anim:Landroid/animation/Animator;
    if-eqz v0, :cond_d

    invoke-virtual {v0}, Landroid/animation/Animator;->cancel()V

    :cond_d
    return-void
.end method

.method public static getAnimator(Landroid/view/View;)Landroid/animation/Animator;
    .registers 2
    .parameter "view"

    .prologue
    sget-object v0, Lmiui/animation/ViewPropertyAnimator;->mAnimatorMap:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Animator;

    return-object v0
.end method

.method public static getHeightOrMeasureHeight(Landroid/view/View;)F
    .registers 4
    .parameter "view"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    move-result v0

    .local v0, height:I
    if-nez v0, :cond_16

    invoke-static {v2, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    invoke-static {v2, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    invoke-virtual {p0, v1, v2}, Landroid/view/View;->measure(II)V

    invoke-virtual {p0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    :cond_16
    int-to-float v1, v0

    return v1
.end method

.method private getValue()F
    .registers 3

    .prologue
    const/4 v0, 0x1

    .local v0, value:F
    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    sparse-switch v1, :sswitch_data_4e

    :goto_6
    return v0

    :sswitch_7
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getTranslationX()F

    move-result v0

    goto :goto_6

    :sswitch_e
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getTranslationY()F

    move-result v0

    goto :goto_6

    :sswitch_15
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getRotation()F

    move-result v0

    goto :goto_6

    :sswitch_1c
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getRotationX()F

    move-result v0

    goto :goto_6

    :sswitch_23
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getRotationY()F

    move-result v0

    goto :goto_6

    :sswitch_2a
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getScaleX()F

    move-result v0

    goto :goto_6

    :sswitch_31
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getScaleY()F

    move-result v0

    goto :goto_6

    :sswitch_38
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getX()F

    move-result v0

    goto :goto_6

    :sswitch_3f
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getY()F

    move-result v0

    goto :goto_6

    :sswitch_46
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getAlpha()F

    move-result v0

    goto :goto_6

    nop

    :sswitch_data_4e
    .sparse-switch
        0x1 -> :sswitch_7
        0x2 -> :sswitch_e
        0x4 -> :sswitch_2a
        0x8 -> :sswitch_31
        0x10 -> :sswitch_15
        0x20 -> :sswitch_1c
        0x40 -> :sswitch_23
        0x80 -> :sswitch_38
        0x100 -> :sswitch_3f
        0x200 -> :sswitch_46
    .end sparse-switch
.end method

.method public static of(Landroid/view/View;IFF)Lmiui/animation/ViewPropertyAnimator$Builder;
    .registers 6
    .parameter "view"
    .parameter "property"
    .parameter "fromValue"
    .parameter "toValue"

    .prologue
    new-instance v0, Lmiui/animation/ViewPropertyAnimator;

    invoke-direct {v0, p0, p1, p2, p3}, Lmiui/animation/ViewPropertyAnimator;-><init>(Landroid/view/View;IFF)V

    .local v0, anim:Lmiui/animation/ViewPropertyAnimator;
    new-instance v1, Lmiui/animation/ViewPropertyAnimator$Builder;

    invoke-direct {v1, v0}, Lmiui/animation/ViewPropertyAnimator$Builder;-><init>(Lmiui/animation/ViewPropertyAnimator;)V

    return-object v1
.end method

.method private static setAnimator(Landroid/view/View;Landroid/animation/Animator;)V
    .registers 3
    .parameter "view"
    .parameter "anim"

    .prologue
    if-eqz p1, :cond_8

    sget-object v0, Lmiui/animation/ViewPropertyAnimator;->mAnimatorMap:Ljava/util/HashMap;

    invoke-virtual {v0, p0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :goto_7
    return-void

    :cond_8
    sget-object v0, Lmiui/animation/ViewPropertyAnimator;->mAnimatorMap:Ljava/util/HashMap;

    invoke-virtual {v0, p0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_7
.end method

.method private setFinalValues()V
    .registers 3

    .prologue
    iget v0, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalVisibility:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_c

    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalVisibility:I

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    :cond_c
    iget v0, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalValue:F

    const/4 v1, 0x1

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_18

    iget v0, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalValue:F

    invoke-direct {p0, v0}, Lmiui/animation/ViewPropertyAnimator;->setValue(F)V

    :cond_18
    return-void
.end method

.method private setValue(F)V
    .registers 3
    .parameter "value"

    .prologue
    iget v0, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    sparse-switch v0, :sswitch_data_42

    :goto_5
    return-void

    :sswitch_6
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setTranslationX(F)V

    goto :goto_5

    :sswitch_c
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setTranslationY(F)V

    goto :goto_5

    :sswitch_12
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setRotation(F)V

    goto :goto_5

    :sswitch_18
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setRotationX(F)V

    goto :goto_5

    :sswitch_1e
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setRotationY(F)V

    goto :goto_5

    :sswitch_24
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setScaleX(F)V

    goto :goto_5

    :sswitch_2a
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setScaleY(F)V

    goto :goto_5

    :sswitch_30
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setX(F)V

    goto :goto_5

    :sswitch_36
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setY(F)V

    goto :goto_5

    :sswitch_3c
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->setAlpha(F)V

    goto :goto_5

    :sswitch_data_42
    .sparse-switch
        0x1 -> :sswitch_6
        0x2 -> :sswitch_c
        0x4 -> :sswitch_24
        0x8 -> :sswitch_2a
        0x10 -> :sswitch_12
        0x20 -> :sswitch_18
        0x40 -> :sswitch_1e
        0x80 -> :sswitch_30
        0x100 -> :sswitch_36
        0x200 -> :sswitch_3c
    .end sparse-switch
.end method

.method private setupValues()V
    .registers 2

    .prologue
    iget v0, p0, Lmiui/animation/ViewPropertyAnimator;->mFromValue:F

    invoke-direct {p0, v0}, Lmiui/animation/ViewPropertyAnimator;->calulateAnimatorValue(F)F

    move-result v0

    iput v0, p0, Lmiui/animation/ViewPropertyAnimator;->mFromValue:F

    iget v0, p0, Lmiui/animation/ViewPropertyAnimator;->mToValue:F

    invoke-direct {p0, v0}, Lmiui/animation/ViewPropertyAnimator;->calulateAnimatorValue(F)F

    move-result v0

    iput v0, p0, Lmiui/animation/ViewPropertyAnimator;->mToValue:F

    iget v0, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalValue:F

    invoke-direct {p0, v0}, Lmiui/animation/ViewPropertyAnimator;->calulateAnimatorValue(F)F

    move-result v0

    iput v0, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalValue:F

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->cancel()V

    return-void
.end method

.method public clone()Landroid/animation/Animator;
    .registers 3

    .prologue
    invoke-super {p0}, Landroid/animation/Animator;->clone()Landroid/animation/Animator;

    move-result-object v0

    check-cast v0, Lmiui/animation/ViewPropertyAnimator;

    .local v0, anim:Lmiui/animation/ViewPropertyAnimator;
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v1}, Landroid/animation/ValueAnimator;->clone()Landroid/animation/ValueAnimator;

    move-result-object v1

    iput-object v1, v0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    iput-object v1, v0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    iput v1, v0, Lmiui/animation/ViewPropertyAnimator;->mProperty:I

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mFromValue:F

    iput v1, v0, Lmiui/animation/ViewPropertyAnimator;->mFromValue:F

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mToValue:F

    iput v1, v0, Lmiui/animation/ViewPropertyAnimator;->mToValue:F

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalVisibility:I

    iput v1, v0, Lmiui/animation/ViewPropertyAnimator;->mFinalVisibility:I

    iget v1, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalValue:F

    iput v1, v0, Lmiui/animation/ViewPropertyAnimator;->mFinalValue:F

    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    invoke-virtual {p0}, Lmiui/animation/ViewPropertyAnimator;->clone()Landroid/animation/Animator;

    move-result-object v0

    return-object v0
.end method

.method public end()V
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->end()V

    return-void
.end method

.method public getDuration()J
    .registers 3

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->getDuration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getFinalValue()F
    .registers 2

    .prologue
    iget v0, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalValue:F

    return v0
.end method

.method public getFinalVisibility()I
    .registers 2

    .prologue
    iget v0, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalVisibility:I

    return v0
.end method

.method public getRepeatCount()I
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->getRepeatCount()I

    move-result v0

    return v0
.end method

.method public getRepeatMode()I
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->getRepeatMode()I

    move-result v0

    return v0
.end method

.method public getStartDelay()J
    .registers 3

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->getStartDelay()J

    move-result-wide v0

    return-wide v0
.end method

.method public getWidthOrMeasureWidth(Landroid/view/View;)F
    .registers 5
    .parameter "view"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v0

    .local v0, width:I
    if-nez v0, :cond_16

    invoke-static {v2, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v1

    invoke-static {v2, v2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    invoke-virtual {p1, v1, v2}, Landroid/view/View;->measure(II)V

    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    :cond_16
    int-to-float v1, v0

    return v1
.end method

.method public isRunning()Z
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->isRunning()Z

    move-result v0

    return v0
.end method

.method public setDuration(J)Landroid/animation/Animator;
    .registers 4
    .parameter "duration"

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0, p1, p2}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    return-object p0
.end method

.method public setFinalValue(F)V
    .registers 2
    .parameter "value"

    .prologue
    iput p1, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalValue:F

    return-void
.end method

.method public setFinalVisibility(I)V
    .registers 2
    .parameter "visibility"

    .prologue
    iput p1, p0, Lmiui/animation/ViewPropertyAnimator;->mFinalVisibility:I

    return-void
.end method

.method public setInterpolator(Landroid/animation/TimeInterpolator;)V
    .registers 3
    .parameter "value"

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0, p1}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    return-void
.end method

.method public setRepeatCount(I)V
    .registers 3
    .parameter "value"

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0, p1}, Landroid/animation/ValueAnimator;->setRepeatCount(I)V

    return-void
.end method

.method public setRepeatMode(I)V
    .registers 3
    .parameter "value"

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0, p1}, Landroid/animation/ValueAnimator;->setRepeatMode(I)V

    return-void
.end method

.method public setStartDelay(J)V
    .registers 4
    .parameter "startDelay"

    .prologue
    iget-object v0, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v0, p1, p2}, Landroid/animation/ValueAnimator;->setStartDelay(J)V

    return-void
.end method

.method public start()V
    .registers 4

    .prologue
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-static {v1}, Lmiui/animation/ViewPropertyAnimator;->cancelAnimator(Landroid/view/View;)V

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v0

    .local v0, animation:Landroid/view/animation/Animation;
    if-eqz v0, :cond_10

    invoke-virtual {v0}, Landroid/view/animation/Animation;->cancel()V

    :cond_10
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/ViewPropertyAnimator;->cancel()V

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-static {v1, p0}, Lmiui/animation/ViewPropertyAnimator;->setAnimator(Landroid/view/View;Landroid/animation/Animator;)V

    invoke-direct {p0}, Lmiui/animation/ViewPropertyAnimator;->setupValues()V

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-eqz v1, :cond_2f

    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mView:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    :cond_2f
    iget-object v1, p0, Lmiui/animation/ViewPropertyAnimator;->mAnimator:Landroid/animation/ValueAnimator;

    invoke-virtual {v1}, Landroid/animation/ValueAnimator;->start()V

    return-void
.end method
