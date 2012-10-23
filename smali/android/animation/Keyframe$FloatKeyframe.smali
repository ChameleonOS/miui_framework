.class Landroid/animation/Keyframe$FloatKeyframe;
.super Landroid/animation/Keyframe;
.source "Keyframe.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/animation/Keyframe;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "FloatKeyframe"
.end annotation


# instance fields
.field mValue:F


# direct methods
.method constructor <init>(F)V
    .registers 3
    .parameter "fraction"

    .prologue
    .line 331
    invoke-direct {p0}, Landroid/animation/Keyframe;-><init>()V

    .line 332
    iput p1, p0, Landroid/animation/Keyframe;->mFraction:F

    .line 333
    sget-object v0, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    iput-object v0, p0, Landroid/animation/Keyframe;->mValueType:Ljava/lang/Class;

    .line 334
    return-void
.end method

.method constructor <init>(FF)V
    .registers 4
    .parameter "fraction"
    .parameter "value"

    .prologue
    .line 324
    invoke-direct {p0}, Landroid/animation/Keyframe;-><init>()V

    .line 325
    iput p1, p0, Landroid/animation/Keyframe;->mFraction:F

    .line 326
    iput p2, p0, Landroid/animation/Keyframe$FloatKeyframe;->mValue:F

    .line 327
    sget-object v0, Ljava/lang/Float;->TYPE:Ljava/lang/Class;

    iput-object v0, p0, Landroid/animation/Keyframe;->mValueType:Ljava/lang/Class;

    .line 328
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/animation/Keyframe;->mHasValue:Z

    .line 329
    return-void
.end method


# virtual methods
.method public clone()Landroid/animation/Keyframe$FloatKeyframe;
    .registers 4

    .prologue
    .line 353
    new-instance v0, Landroid/animation/Keyframe$FloatKeyframe;

    invoke-virtual {p0}, Landroid/animation/Keyframe$FloatKeyframe;->getFraction()F

    move-result v1

    iget v2, p0, Landroid/animation/Keyframe$FloatKeyframe;->mValue:F

    invoke-direct {v0, v1, v2}, Landroid/animation/Keyframe$FloatKeyframe;-><init>(FF)V

    .line 354
    .local v0, kfClone:Landroid/animation/Keyframe$FloatKeyframe;
    invoke-virtual {p0}, Landroid/animation/Keyframe$FloatKeyframe;->getInterpolator()Landroid/animation/TimeInterpolator;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/animation/Keyframe$FloatKeyframe;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 355
    return-object v0
.end method

.method public bridge synthetic clone()Landroid/animation/Keyframe;
    .registers 2

    .prologue
    .line 318
    invoke-virtual {p0}, Landroid/animation/Keyframe$FloatKeyframe;->clone()Landroid/animation/Keyframe$FloatKeyframe;

    move-result-object v0

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
    .line 318
    invoke-virtual {p0}, Landroid/animation/Keyframe$FloatKeyframe;->clone()Landroid/animation/Keyframe$FloatKeyframe;

    move-result-object v0

    return-object v0
.end method

.method public getFloatValue()F
    .registers 2

    .prologue
    .line 337
    iget v0, p0, Landroid/animation/Keyframe$FloatKeyframe;->mValue:F

    return v0
.end method

.method public getValue()Ljava/lang/Object;
    .registers 2

    .prologue
    .line 341
    iget v0, p0, Landroid/animation/Keyframe$FloatKeyframe;->mValue:F

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    return-object v0
.end method

.method public setValue(Ljava/lang/Object;)V
    .registers 4
    .parameter "value"

    .prologue
    .line 345
    if-eqz p1, :cond_15

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Ljava/lang/Float;

    if-ne v0, v1, :cond_15

    .line 346
    check-cast p1, Ljava/lang/Float;

    .end local p1
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v0

    iput v0, p0, Landroid/animation/Keyframe$FloatKeyframe;->mValue:F

    .line 347
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/animation/Keyframe;->mHasValue:Z

    .line 349
    :cond_15
    return-void
.end method
