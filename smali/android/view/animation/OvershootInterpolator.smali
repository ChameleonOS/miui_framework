.class public Landroid/view/animation/OvershootInterpolator;
.super Ljava/lang/Object;
.source "OvershootInterpolator.java"

# interfaces
.implements Landroid/view/animation/Interpolator;


# instance fields
.field private final mTension:F


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 30
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 31
    const/high16 v0, 0x4000

    iput v0, p0, Landroid/view/animation/OvershootInterpolator;->mTension:F

    .line 32
    return-void
.end method

.method public constructor <init>(F)V
    .registers 2
    .parameter "tension"

    .prologue
    .line 39
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput p1, p0, Landroid/view/animation/OvershootInterpolator;->mTension:F

    .line 41
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 6
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 43
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 44
    sget-object v1, Lcom/android/internal/R$styleable;->OvershootInterpolator:[I

    invoke-virtual {p1, p2, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 47
    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v1, 0x0

    const/high16 v2, 0x4000

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    iput v1, p0, Landroid/view/animation/OvershootInterpolator;->mTension:F

    .line 50
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 51
    return-void
.end method


# virtual methods
.method public getInterpolation(F)F
    .registers 6
    .parameter "t"

    .prologue
    const/high16 v3, 0x3f80

    .line 56
    sub-float/2addr p1, v3

    .line 57
    mul-float v0, p1, p1

    iget v1, p0, Landroid/view/animation/OvershootInterpolator;->mTension:F

    add-float/2addr v1, v3

    mul-float/2addr v1, p1

    iget v2, p0, Landroid/view/animation/OvershootInterpolator;->mTension:F

    add-float/2addr v1, v2

    mul-float/2addr v0, v1

    add-float/2addr v0, v3

    return v0
.end method
