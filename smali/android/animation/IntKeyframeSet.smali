.class Landroid/animation/IntKeyframeSet;
.super Landroid/animation/KeyframeSet;
.source "IntKeyframeSet.java"


# instance fields
.field private deltaValue:I

.field private firstTime:Z

.field private firstValue:I

.field private lastValue:I


# direct methods
.method public varargs constructor <init>([Landroid/animation/Keyframe$IntKeyframe;)V
    .registers 3
    .parameter "keyframes"

    .prologue
    invoke-direct {p0, p1}, Landroid/animation/KeyframeSet;-><init>([Landroid/animation/Keyframe;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/animation/IntKeyframeSet;->firstTime:Z

    return-void
.end method


# virtual methods
.method public clone()Landroid/animation/IntKeyframeSet;
    .registers 7

    .prologue
    iget-object v1, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    .local v1, keyframes:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    iget-object v5, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v4

    .local v4, numKeyframes:I
    new-array v2, v4, [Landroid/animation/Keyframe$IntKeyframe;

    .local v2, newKeyframes:[Landroid/animation/Keyframe$IntKeyframe;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_b
    if-ge v0, v4, :cond_1e

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/animation/Keyframe;

    invoke-virtual {v5}, Landroid/animation/Keyframe;->clone()Landroid/animation/Keyframe;

    move-result-object v5

    check-cast v5, Landroid/animation/Keyframe$IntKeyframe;

    aput-object v5, v2, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_b

    :cond_1e
    new-instance v3, Landroid/animation/IntKeyframeSet;

    invoke-direct {v3, v2}, Landroid/animation/IntKeyframeSet;-><init>([Landroid/animation/Keyframe$IntKeyframe;)V

    .local v3, newSet:Landroid/animation/IntKeyframeSet;
    return-object v3
.end method

.method public bridge synthetic clone()Landroid/animation/KeyframeSet;
    .registers 2

    .prologue
    invoke-virtual {p0}, Landroid/animation/IntKeyframeSet;->clone()Landroid/animation/IntKeyframeSet;

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
    invoke-virtual {p0}, Landroid/animation/IntKeyframeSet;->clone()Landroid/animation/IntKeyframeSet;

    move-result-object v0

    return-object v0
.end method

.method public getIntValue(F)I
    .registers 15
    .parameter "fraction"

    .prologue
    const/4 v12, 0x1

    const/4 v11, 0x0

    iget v9, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    const/4 v10, 0x2

    if-ne v9, v10, :cond_60

    iget-boolean v9, p0, Landroid/animation/IntKeyframeSet;->firstTime:Z

    if-eqz v9, :cond_30

    iput-boolean v11, p0, Landroid/animation/IntKeyframeSet;->firstTime:Z

    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v9, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/animation/Keyframe$IntKeyframe;

    invoke-virtual {v9}, Landroid/animation/Keyframe$IntKeyframe;->getIntValue()I

    move-result v9

    iput v9, p0, Landroid/animation/IntKeyframeSet;->firstValue:I

    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v9, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/animation/Keyframe$IntKeyframe;

    invoke-virtual {v9}, Landroid/animation/Keyframe$IntKeyframe;->getIntValue()I

    move-result v9

    iput v9, p0, Landroid/animation/IntKeyframeSet;->lastValue:I

    iget v9, p0, Landroid/animation/IntKeyframeSet;->lastValue:I

    iget v10, p0, Landroid/animation/IntKeyframeSet;->firstValue:I

    sub-int/2addr v9, v10

    iput v9, p0, Landroid/animation/IntKeyframeSet;->deltaValue:I

    :cond_30
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mInterpolator:Landroid/animation/TimeInterpolator;

    if-eqz v9, :cond_3a

    iget-object v9, p0, Landroid/animation/KeyframeSet;->mInterpolator:Landroid/animation/TimeInterpolator;

    invoke-interface {v9, p1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result p1

    :cond_3a
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    if-nez v9, :cond_47

    iget v9, p0, Landroid/animation/IntKeyframeSet;->firstValue:I

    iget v10, p0, Landroid/animation/IntKeyframeSet;->deltaValue:I

    int-to-float v10, v10

    mul-float/2addr v10, p1

    float-to-int v10, v10

    add-int/2addr v9, v10

    :goto_46
    return v9

    :cond_47
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    iget v10, p0, Landroid/animation/IntKeyframeSet;->firstValue:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    iget v11, p0, Landroid/animation/IntKeyframeSet;->lastValue:I

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-interface {v9, p1, v10, v11}, Landroid/animation/TypeEvaluator;->evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Number;

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I

    move-result v9

    goto :goto_46

    :cond_60
    const/4 v9, 0x0

    cmpg-float v9, p1, v9

    if-gtz v9, :cond_b5

    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v9, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/animation/Keyframe$IntKeyframe;

    .local v7, prevKeyframe:Landroid/animation/Keyframe$IntKeyframe;
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v9, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/animation/Keyframe$IntKeyframe;

    .local v4, nextKeyframe:Landroid/animation/Keyframe$IntKeyframe;
    invoke-virtual {v7}, Landroid/animation/Keyframe$IntKeyframe;->getIntValue()I

    move-result v8

    .local v8, prevValue:I
    invoke-virtual {v4}, Landroid/animation/Keyframe$IntKeyframe;->getIntValue()I

    move-result v5

    .local v5, nextValue:I
    invoke-virtual {v7}, Landroid/animation/Keyframe$IntKeyframe;->getFraction()F

    move-result v6

    .local v6, prevFraction:F
    invoke-virtual {v4}, Landroid/animation/Keyframe$IntKeyframe;->getFraction()F

    move-result v3

    .local v3, nextFraction:F
    invoke-virtual {v4}, Landroid/animation/Keyframe$IntKeyframe;->getInterpolator()Landroid/animation/TimeInterpolator;

    move-result-object v1

    .local v1, interpolator:Landroid/animation/TimeInterpolator;
    if-eqz v1, :cond_8f

    invoke-interface {v1, p1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result p1

    :cond_8f
    sub-float v9, p1, v6

    sub-float v10, v3, v6

    div-float v2, v9, v10

    .local v2, intervalFraction:F
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    if-nez v9, :cond_a0

    sub-int v9, v5, v8

    int-to-float v9, v9

    mul-float/2addr v9, v2

    float-to-int v9, v9

    add-int/2addr v9, v8

    goto :goto_46

    :cond_a0
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-interface {v9, v2, v10, v11}, Landroid/animation/TypeEvaluator;->evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Number;

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I

    move-result v9

    goto :goto_46

    .end local v1           #interpolator:Landroid/animation/TimeInterpolator;
    .end local v2           #intervalFraction:F
    .end local v3           #nextFraction:F
    .end local v4           #nextKeyframe:Landroid/animation/Keyframe$IntKeyframe;
    .end local v5           #nextValue:I
    .end local v6           #prevFraction:F
    .end local v7           #prevKeyframe:Landroid/animation/Keyframe$IntKeyframe;
    .end local v8           #prevValue:I
    :cond_b5
    const/high16 v9, 0x3f80

    cmpl-float v9, p1, v9

    if-ltz v9, :cond_115

    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    iget v10, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    add-int/lit8 v10, v10, -0x2

    invoke-virtual {v9, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/animation/Keyframe$IntKeyframe;

    .restart local v7       #prevKeyframe:Landroid/animation/Keyframe$IntKeyframe;
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    iget v10, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    add-int/lit8 v10, v10, -0x1

    invoke-virtual {v9, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/animation/Keyframe$IntKeyframe;

    .restart local v4       #nextKeyframe:Landroid/animation/Keyframe$IntKeyframe;
    invoke-virtual {v7}, Landroid/animation/Keyframe$IntKeyframe;->getIntValue()I

    move-result v8

    .restart local v8       #prevValue:I
    invoke-virtual {v4}, Landroid/animation/Keyframe$IntKeyframe;->getIntValue()I

    move-result v5

    .restart local v5       #nextValue:I
    invoke-virtual {v7}, Landroid/animation/Keyframe$IntKeyframe;->getFraction()F

    move-result v6

    .restart local v6       #prevFraction:F
    invoke-virtual {v4}, Landroid/animation/Keyframe$IntKeyframe;->getFraction()F

    move-result v3

    .restart local v3       #nextFraction:F
    invoke-virtual {v4}, Landroid/animation/Keyframe$IntKeyframe;->getInterpolator()Landroid/animation/TimeInterpolator;

    move-result-object v1

    .restart local v1       #interpolator:Landroid/animation/TimeInterpolator;
    if-eqz v1, :cond_ed

    invoke-interface {v1, p1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result p1

    :cond_ed
    sub-float v9, p1, v6

    sub-float v10, v3, v6

    div-float v2, v9, v10

    .restart local v2       #intervalFraction:F
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    if-nez v9, :cond_ff

    sub-int v9, v5, v8

    int-to-float v9, v9

    mul-float/2addr v9, v2

    float-to-int v9, v9

    add-int/2addr v9, v8

    goto/16 :goto_46

    :cond_ff
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-interface {v9, v2, v10, v11}, Landroid/animation/TypeEvaluator;->evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Number;

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I

    move-result v9

    goto/16 :goto_46

    .end local v1           #interpolator:Landroid/animation/TimeInterpolator;
    .end local v2           #intervalFraction:F
    .end local v3           #nextFraction:F
    .end local v4           #nextKeyframe:Landroid/animation/Keyframe$IntKeyframe;
    .end local v5           #nextValue:I
    .end local v6           #prevFraction:F
    .end local v7           #prevKeyframe:Landroid/animation/Keyframe$IntKeyframe;
    .end local v8           #prevValue:I
    :cond_115
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v9, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/animation/Keyframe$IntKeyframe;

    .restart local v7       #prevKeyframe:Landroid/animation/Keyframe$IntKeyframe;
    const/4 v0, 0x1

    .local v0, i:I
    :goto_11e
    iget v9, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    if-ge v0, v9, :cond_17b

    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/animation/Keyframe$IntKeyframe;

    .restart local v4       #nextKeyframe:Landroid/animation/Keyframe$IntKeyframe;
    invoke-virtual {v4}, Landroid/animation/Keyframe$IntKeyframe;->getFraction()F

    move-result v9

    cmpg-float v9, p1, v9

    if-gez v9, :cond_177

    invoke-virtual {v4}, Landroid/animation/Keyframe$IntKeyframe;->getInterpolator()Landroid/animation/TimeInterpolator;

    move-result-object v1

    .restart local v1       #interpolator:Landroid/animation/TimeInterpolator;
    if-eqz v1, :cond_13c

    invoke-interface {v1, p1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result p1

    :cond_13c
    invoke-virtual {v7}, Landroid/animation/Keyframe$IntKeyframe;->getFraction()F

    move-result v9

    sub-float v9, p1, v9

    invoke-virtual {v4}, Landroid/animation/Keyframe$IntKeyframe;->getFraction()F

    move-result v10

    invoke-virtual {v7}, Landroid/animation/Keyframe$IntKeyframe;->getFraction()F

    move-result v11

    sub-float/2addr v10, v11

    div-float v2, v9, v10

    .restart local v2       #intervalFraction:F
    invoke-virtual {v7}, Landroid/animation/Keyframe$IntKeyframe;->getIntValue()I

    move-result v8

    .restart local v8       #prevValue:I
    invoke-virtual {v4}, Landroid/animation/Keyframe$IntKeyframe;->getIntValue()I

    move-result v5

    .restart local v5       #nextValue:I
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    if-nez v9, :cond_161

    sub-int v9, v5, v8

    int-to-float v9, v9

    mul-float/2addr v9, v2

    float-to-int v9, v9

    add-int/2addr v9, v8

    goto/16 :goto_46

    :cond_161
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-interface {v9, v2, v10, v11}, Landroid/animation/TypeEvaluator;->evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Number;

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I

    move-result v9

    goto/16 :goto_46

    .end local v1           #interpolator:Landroid/animation/TimeInterpolator;
    .end local v2           #intervalFraction:F
    .end local v5           #nextValue:I
    .end local v8           #prevValue:I
    :cond_177
    move-object v7, v4

    add-int/lit8 v0, v0, 0x1

    goto :goto_11e

    .end local v4           #nextKeyframe:Landroid/animation/Keyframe$IntKeyframe;
    :cond_17b
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    iget v10, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    add-int/lit8 v10, v10, -0x1

    invoke-virtual {v9, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/animation/Keyframe;

    invoke-virtual {v9}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Number;

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I

    move-result v9

    goto/16 :goto_46
.end method

.method public getValue(F)Ljava/lang/Object;
    .registers 3
    .parameter "fraction"

    .prologue
    invoke-virtual {p0, p1}, Landroid/animation/IntKeyframeSet;->getIntValue(F)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method
