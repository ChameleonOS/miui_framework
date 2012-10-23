.class public Landroid/view/animation/DecelerateInterpolator;
.super Ljava/lang/Object;
.source "DecelerateInterpolator.java"

# interfaces
.implements Landroid/view/animation/Interpolator;


# instance fields
.field private mFactor:F


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 29
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 62
    const/high16 v0, 0x3f80

    iput v0, p0, Landroid/view/animation/DecelerateInterpolator;->mFactor:F

    .line 30
    return-void
.end method

.method public constructor <init>(F)V
    .registers 3
    .parameter "factor"

    .prologue
    .line 39
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 62
    const/high16 v0, 0x3f80

    iput v0, p0, Landroid/view/animation/DecelerateInterpolator;->mFactor:F

    .line 40
    iput p1, p0, Landroid/view/animation/DecelerateInterpolator;->mFactor:F

    .line 41
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 6
    .parameter "context"
    .parameter "attrs"

    .prologue
    const/high16 v2, 0x3f80

    .line 43
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 62
    iput v2, p0, Landroid/view/animation/DecelerateInterpolator;->mFactor:F

    .line 44
    sget-object v1, Lcom/android/internal/R$styleable;->DecelerateInterpolator:[I

    invoke-virtual {p1, p2, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 47
    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v1, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    iput v1, p0, Landroid/view/animation/DecelerateInterpolator;->mFactor:F

    .line 49
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 50
    return-void
.end method


# virtual methods
.method public getInterpolation(F)F
    .registers 9
    .parameter "input"

    .prologue
    const/high16 v3, 0x3f80

    .line 54
    iget v1, p0, Landroid/view/animation/DecelerateInterpolator;->mFactor:F

    cmpl-float v1, v1, v3

    if-nez v1, :cond_10

    .line 55
    sub-float v1, v3, p1

    sub-float v2, v3, p1

    mul-float/2addr v1, v2

    sub-float v0, v3, v1

    .line 59
    .local v0, result:F
    :goto_f
    return v0

    .line 57
    .end local v0           #result:F
    :cond_10
    const-wide/high16 v1, 0x3ff0

    sub-float/2addr v3, p1

    float-to-double v3, v3

    const/high16 v5, 0x4000

    iget v6, p0, Landroid/view/animation/DecelerateInterpolator;->mFactor:F

    mul-float/2addr v5, v6

    float-to-double v5, v5

    invoke-static {v3, v4, v5, v6}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v3

    sub-double/2addr v1, v3

    double-to-float v0, v1

    .restart local v0       #result:F
    goto :goto_f
.end method
