.class public Lmiui/animation/DampingInterpolator;
.super Ljava/lang/Object;
.source "DampingInterpolator.java"

# interfaces
.implements Landroid/animation/TimeInterpolator;


# instance fields
.field private final mAtanValue:D

.field private final mFactor:F


# direct methods
.method public constructor <init>(F)V
    .registers 4
    .parameter "factor"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lmiui/animation/DampingInterpolator;->mFactor:F

    iget v0, p0, Lmiui/animation/DampingInterpolator;->mFactor:F

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->atan(D)D

    move-result-wide v0

    iput-wide v0, p0, Lmiui/animation/DampingInterpolator;->mAtanValue:D

    return-void
.end method


# virtual methods
.method public getInterpolation(F)F
    .registers 6
    .parameter "input"

    .prologue
    iget v0, p0, Lmiui/animation/DampingInterpolator;->mFactor:F

    mul-float/2addr v0, p1

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->atan(D)D

    move-result-wide v0

    iget-wide v2, p0, Lmiui/animation/DampingInterpolator;->mAtanValue:D

    div-double/2addr v0, v2

    double-to-float v0, v0

    return v0
.end method
