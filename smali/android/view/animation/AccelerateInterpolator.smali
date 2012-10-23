.class public Landroid/view/animation/AccelerateInterpolator;
.super Ljava/lang/Object;
.source "AccelerateInterpolator.java"

# interfaces
.implements Landroid/view/animation/Interpolator;


# instance fields
.field private final mDoubleFactor:D

.field private final mFactor:F


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    .line 32
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 33
    const/high16 v0, 0x3f80

    iput v0, p0, Landroid/view/animation/AccelerateInterpolator;->mFactor:F

    .line 34
    const-wide/high16 v0, 0x4000

    iput-wide v0, p0, Landroid/view/animation/AccelerateInterpolator;->mDoubleFactor:D

    .line 35
    return-void
.end method

.method public constructor <init>(F)V
    .registers 4
    .parameter "factor"

    .prologue
    .line 45
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput p1, p0, Landroid/view/animation/AccelerateInterpolator;->mFactor:F

    .line 47
    const/high16 v0, 0x4000

    iget v1, p0, Landroid/view/animation/AccelerateInterpolator;->mFactor:F

    mul-float/2addr v0, v1

    float-to-double v0, v0

    iput-wide v0, p0, Landroid/view/animation/AccelerateInterpolator;->mDoubleFactor:D

    .line 48
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 6
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 50
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 51
    sget-object v1, Lcom/android/internal/R$styleable;->AccelerateInterpolator:[I

    invoke-virtual {p1, p2, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 54
    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v1, 0x0

    const/high16 v2, 0x3f80

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    iput v1, p0, Landroid/view/animation/AccelerateInterpolator;->mFactor:F

    .line 55
    const/high16 v1, 0x4000

    iget v2, p0, Landroid/view/animation/AccelerateInterpolator;->mFactor:F

    mul-float/2addr v1, v2

    float-to-double v1, v1

    iput-wide v1, p0, Landroid/view/animation/AccelerateInterpolator;->mDoubleFactor:D

    .line 57
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 58
    return-void
.end method


# virtual methods
.method public getInterpolation(F)F
    .registers 6
    .parameter "input"

    .prologue
    .line 61
    iget v0, p0, Landroid/view/animation/AccelerateInterpolator;->mFactor:F

    const/high16 v1, 0x3f80

    cmpl-float v0, v0, v1

    if-nez v0, :cond_b

    .line 62
    mul-float v0, p1, p1

    .line 64
    :goto_a
    return v0

    :cond_b
    float-to-double v0, p1

    iget-wide v2, p0, Landroid/view/animation/AccelerateInterpolator;->mDoubleFactor:D

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    double-to-float v0, v0

    goto :goto_a
.end method
