.class public abstract Landroid/animation/Keyframe;
.super Ljava/lang/Object;
.source "Keyframe.java"

# interfaces
.implements Ljava/lang/Cloneable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/animation/Keyframe$FloatKeyframe;,
        Landroid/animation/Keyframe$IntKeyframe;,
        Landroid/animation/Keyframe$ObjectKeyframe;
    }
.end annotation


# instance fields
.field mFraction:F

.field mHasValue:Z

.field private mInterpolator:Landroid/animation/TimeInterpolator;

.field mValueType:Ljava/lang/Class;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 36
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 52
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/animation/Keyframe;->mInterpolator:Landroid/animation/TimeInterpolator;

    .line 59
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/animation/Keyframe;->mHasValue:Z

    .line 318
    return-void
.end method

.method public static ofFloat(F)Landroid/animation/Keyframe;
    .registers 2
    .parameter "fraction"

    .prologue
    .line 122
    new-instance v0, Landroid/animation/Keyframe$FloatKeyframe;

    invoke-direct {v0, p0}, Landroid/animation/Keyframe$FloatKeyframe;-><init>(F)V

    return-object v0
.end method

.method public static ofFloat(FF)Landroid/animation/Keyframe;
    .registers 3
    .parameter "fraction"
    .parameter "value"

    .prologue
    .line 106
    new-instance v0, Landroid/animation/Keyframe$FloatKeyframe;

    invoke-direct {v0, p0, p1}, Landroid/animation/Keyframe$FloatKeyframe;-><init>(FF)V

    return-object v0
.end method

.method public static ofInt(F)Landroid/animation/Keyframe;
    .registers 2
    .parameter "fraction"

    .prologue
    .line 90
    new-instance v0, Landroid/animation/Keyframe$IntKeyframe;

    invoke-direct {v0, p0}, Landroid/animation/Keyframe$IntKeyframe;-><init>(F)V

    return-object v0
.end method

.method public static ofInt(FI)Landroid/animation/Keyframe;
    .registers 3
    .parameter "fraction"
    .parameter "value"

    .prologue
    .line 74
    new-instance v0, Landroid/animation/Keyframe$IntKeyframe;

    invoke-direct {v0, p0, p1}, Landroid/animation/Keyframe$IntKeyframe;-><init>(FI)V

    return-object v0
.end method

.method public static ofObject(F)Landroid/animation/Keyframe;
    .registers 3
    .parameter "fraction"

    .prologue
    .line 154
    new-instance v0, Landroid/animation/Keyframe$ObjectKeyframe;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/animation/Keyframe$ObjectKeyframe;-><init>(FLjava/lang/Object;)V

    return-object v0
.end method

.method public static ofObject(FLjava/lang/Object;)Landroid/animation/Keyframe;
    .registers 3
    .parameter "fraction"
    .parameter "value"

    .prologue
    .line 138
    new-instance v0, Landroid/animation/Keyframe$ObjectKeyframe;

    invoke-direct {v0, p0, p1}, Landroid/animation/Keyframe$ObjectKeyframe;-><init>(FLjava/lang/Object;)V

    return-object v0
.end method


# virtual methods
.method public abstract clone()Landroid/animation/Keyframe;
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 36
    invoke-virtual {p0}, Landroid/animation/Keyframe;->clone()Landroid/animation/Keyframe;

    move-result-object v0

    return-object v0
.end method

.method public getFraction()F
    .registers 2

    .prologue
    .line 189
    iget v0, p0, Landroid/animation/Keyframe;->mFraction:F

    return v0
.end method

.method public getInterpolator()Landroid/animation/TimeInterpolator;
    .registers 2

    .prologue
    .line 209
    iget-object v0, p0, Landroid/animation/Keyframe;->mInterpolator:Landroid/animation/TimeInterpolator;

    return-object v0
.end method

.method public getType()Ljava/lang/Class;
    .registers 2

    .prologue
    .line 230
    iget-object v0, p0, Landroid/animation/Keyframe;->mValueType:Ljava/lang/Class;

    return-object v0
.end method

.method public abstract getValue()Ljava/lang/Object;
.end method

.method public hasValue()Z
    .registers 2

    .prologue
    .line 165
    iget-boolean v0, p0, Landroid/animation/Keyframe;->mHasValue:Z

    return v0
.end method

.method public setFraction(F)V
    .registers 2
    .parameter "fraction"

    .prologue
    .line 199
    iput p1, p0, Landroid/animation/Keyframe;->mFraction:F

    .line 200
    return-void
.end method

.method public setInterpolator(Landroid/animation/TimeInterpolator;)V
    .registers 2
    .parameter "interpolator"

    .prologue
    .line 219
    iput-object p1, p0, Landroid/animation/Keyframe;->mInterpolator:Landroid/animation/TimeInterpolator;

    .line 220
    return-void
.end method

.method public abstract setValue(Ljava/lang/Object;)V
.end method
