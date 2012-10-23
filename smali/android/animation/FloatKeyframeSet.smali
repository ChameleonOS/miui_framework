.class Landroid/animation/FloatKeyframeSet;
.super Landroid/animation/KeyframeSet;
.source "FloatKeyframeSet.java"


# instance fields
.field private deltaValue:F

.field private firstTime:Z

.field private firstValue:F

.field private lastValue:F


# direct methods
.method public varargs constructor <init>([Landroid/animation/Keyframe$FloatKeyframe;)V
    .registers 3
    .parameter "keyframes"

    .prologue
    .line 40
    invoke-direct {p0, p1}, Landroid/animation/KeyframeSet;-><init>([Landroid/animation/Keyframe;)V

    .line 37
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/animation/FloatKeyframeSet;->firstTime:Z

    .line 41
    return-void
.end method


# virtual methods
.method public clone()Landroid/animation/FloatKeyframeSet;
    .registers 7

    .prologue
    .line 50
    iget-object v1, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    .line 51
    .local v1, keyframes:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    iget-object v5, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 52
    .local v4, numKeyframes:I
    new-array v2, v4, [Landroid/animation/Keyframe$FloatKeyframe;

    .line 53
    .local v2, newKeyframes:[Landroid/animation/Keyframe$FloatKeyframe;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_b
    if-ge v0, v4, :cond_1e

    .line 54
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/animation/Keyframe;

    invoke-virtual {v5}, Landroid/animation/Keyframe;->clone()Landroid/animation/Keyframe;

    move-result-object v5

    check-cast v5, Landroid/animation/Keyframe$FloatKeyframe;

    aput-object v5, v2, v0

    .line 53
    add-int/lit8 v0, v0, 0x1

    goto :goto_b

    .line 56
    :cond_1e
    new-instance v3, Landroid/animation/FloatKeyframeSet;

    invoke-direct {v3, v2}, Landroid/animation/FloatKeyframeSet;-><init>([Landroid/animation/Keyframe$FloatKeyframe;)V

    .line 57
    .local v3, newSet:Landroid/animation/FloatKeyframeSet;
    return-object v3
.end method

.method public bridge synthetic clone()Landroid/animation/KeyframeSet;
    .registers 2

    .prologue
    .line 33
    invoke-virtual {p0}, Landroid/animation/FloatKeyframeSet;->clone()Landroid/animation/FloatKeyframeSet;

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
    .line 33
    invoke-virtual {p0}, Landroid/animation/FloatKeyframeSet;->clone()Landroid/animation/FloatKeyframeSet;

    move-result-object v0

    return-object v0
.end method

.method public getFloatValue(F)F
    .registers 15
    .parameter "fraction"

    .prologue
    const/4 v12, 0x1

    const/4 v11, 0x0

    .line 61
    iget v9, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    const/4 v10, 0x2

    if-ne v9, v10, :cond_5e

    .line 62
    iget-boolean v9, p0, Landroid/animation/FloatKeyframeSet;->firstTime:Z

    if-eqz v9, :cond_30

    .line 63
    iput-boolean v11, p0, Landroid/animation/FloatKeyframeSet;->firstTime:Z

    .line 64
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v9, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/animation/Keyframe$FloatKeyframe;

    invoke-virtual {v9}, Landroid/animation/Keyframe$FloatKeyframe;->getFloatValue()F

    move-result v9

    iput v9, p0, Landroid/animation/FloatKeyframeSet;->firstValue:F

    .line 65
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v9, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/animation/Keyframe$FloatKeyframe;

    invoke-virtual {v9}, Landroid/animation/Keyframe$FloatKeyframe;->getFloatValue()F

    move-result v9

    iput v9, p0, Landroid/animation/FloatKeyframeSet;->lastValue:F

    .line 66
    iget v9, p0, Landroid/animation/FloatKeyframeSet;->lastValue:F

    iget v10, p0, Landroid/animation/FloatKeyframeSet;->firstValue:F

    sub-float/2addr v9, v10

    iput v9, p0, Landroid/animation/FloatKeyframeSet;->deltaValue:F

    .line 68
    :cond_30
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mInterpolator:Landroid/animation/TimeInterpolator;

    if-eqz v9, :cond_3a

    .line 69
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mInterpolator:Landroid/animation/TimeInterpolator;

    invoke-interface {v9, p1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result p1

    .line 71
    :cond_3a
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    if-nez v9, :cond_45

    .line 72
    iget v9, p0, Landroid/animation/FloatKeyframeSet;->firstValue:F

    iget v10, p0, Landroid/animation/FloatKeyframeSet;->deltaValue:F

    mul-float/2addr v10, p1

    add-float/2addr v9, v10

    .line 130
    :goto_44
    return v9

    .line 74
    :cond_45
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    iget v10, p0, Landroid/animation/FloatKeyframeSet;->firstValue:F

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    iget v11, p0, Landroid/animation/FloatKeyframeSet;->lastValue:F

    invoke-static {v11}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    invoke-interface {v9, p1, v10, v11}, Landroid/animation/TypeEvaluator;->evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Number;

    invoke-virtual {v9}, Ljava/lang/Number;->floatValue()F

    move-result v9

    goto :goto_44

    .line 77
    :cond_5e
    const/4 v9, 0x0

    cmpg-float v9, p1, v9

    if-gtz v9, :cond_b1

    .line 78
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v9, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/animation/Keyframe$FloatKeyframe;

    .line 79
    .local v7, prevKeyframe:Landroid/animation/Keyframe$FloatKeyframe;
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v9, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/animation/Keyframe$FloatKeyframe;

    .line 80
    .local v4, nextKeyframe:Landroid/animation/Keyframe$FloatKeyframe;
    invoke-virtual {v7}, Landroid/animation/Keyframe$FloatKeyframe;->getFloatValue()F

    move-result v8

    .line 81
    .local v8, prevValue:F
    invoke-virtual {v4}, Landroid/animation/Keyframe$FloatKeyframe;->getFloatValue()F

    move-result v5

    .line 82
    .local v5, nextValue:F
    invoke-virtual {v7}, Landroid/animation/Keyframe$FloatKeyframe;->getFraction()F

    move-result v6

    .line 83
    .local v6, prevFraction:F
    invoke-virtual {v4}, Landroid/animation/Keyframe$FloatKeyframe;->getFraction()F

    move-result v3

    .line 84
    .local v3, nextFraction:F
    invoke-virtual {v4}, Landroid/animation/Keyframe$FloatKeyframe;->getInterpolator()Landroid/animation/TimeInterpolator;

    move-result-object v1

    .line 85
    .local v1, interpolator:Landroid/animation/TimeInterpolator;
    if-eqz v1, :cond_8d

    .line 86
    invoke-interface {v1, p1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result p1

    .line 88
    :cond_8d
    sub-float v9, p1, v6

    sub-float v10, v3, v6

    div-float v2, v9, v10

    .line 89
    .local v2, intervalFraction:F
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    if-nez v9, :cond_9c

    sub-float v9, v5, v8

    mul-float/2addr v9, v2

    add-float/2addr v9, v8

    goto :goto_44

    :cond_9c
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    invoke-interface {v9, v2, v10, v11}, Landroid/animation/TypeEvaluator;->evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Number;

    invoke-virtual {v9}, Ljava/lang/Number;->floatValue()F

    move-result v9

    goto :goto_44

    .line 93
    .end local v1           #interpolator:Landroid/animation/TimeInterpolator;
    .end local v2           #intervalFraction:F
    .end local v3           #nextFraction:F
    .end local v4           #nextKeyframe:Landroid/animation/Keyframe$FloatKeyframe;
    .end local v5           #nextValue:F
    .end local v6           #prevFraction:F
    .end local v7           #prevKeyframe:Landroid/animation/Keyframe$FloatKeyframe;
    .end local v8           #prevValue:F
    :cond_b1
    const/high16 v9, 0x3f80

    cmpl-float v9, p1, v9

    if-ltz v9, :cond_10f

    .line 94
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    iget v10, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    add-int/lit8 v10, v10, -0x2

    invoke-virtual {v9, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/animation/Keyframe$FloatKeyframe;

    .line 95
    .restart local v7       #prevKeyframe:Landroid/animation/Keyframe$FloatKeyframe;
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    iget v10, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    add-int/lit8 v10, v10, -0x1

    invoke-virtual {v9, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/animation/Keyframe$FloatKeyframe;

    .line 96
    .restart local v4       #nextKeyframe:Landroid/animation/Keyframe$FloatKeyframe;
    invoke-virtual {v7}, Landroid/animation/Keyframe$FloatKeyframe;->getFloatValue()F

    move-result v8

    .line 97
    .restart local v8       #prevValue:F
    invoke-virtual {v4}, Landroid/animation/Keyframe$FloatKeyframe;->getFloatValue()F

    move-result v5

    .line 98
    .restart local v5       #nextValue:F
    invoke-virtual {v7}, Landroid/animation/Keyframe$FloatKeyframe;->getFraction()F

    move-result v6

    .line 99
    .restart local v6       #prevFraction:F
    invoke-virtual {v4}, Landroid/animation/Keyframe$FloatKeyframe;->getFraction()F

    move-result v3

    .line 100
    .restart local v3       #nextFraction:F
    invoke-virtual {v4}, Landroid/animation/Keyframe$FloatKeyframe;->getInterpolator()Landroid/animation/TimeInterpolator;

    move-result-object v1

    .line 101
    .restart local v1       #interpolator:Landroid/animation/TimeInterpolator;
    if-eqz v1, :cond_e9

    .line 102
    invoke-interface {v1, p1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result p1

    .line 104
    :cond_e9
    sub-float v9, p1, v6

    sub-float v10, v3, v6

    div-float v2, v9, v10

    .line 105
    .restart local v2       #intervalFraction:F
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    if-nez v9, :cond_f9

    sub-float v9, v5, v8

    mul-float/2addr v9, v2

    add-float/2addr v9, v8

    goto/16 :goto_44

    :cond_f9
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    invoke-interface {v9, v2, v10, v11}, Landroid/animation/TypeEvaluator;->evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Number;

    invoke-virtual {v9}, Ljava/lang/Number;->floatValue()F

    move-result v9

    goto/16 :goto_44

    .line 110
    .end local v1           #interpolator:Landroid/animation/TimeInterpolator;
    .end local v2           #intervalFraction:F
    .end local v3           #nextFraction:F
    .end local v4           #nextKeyframe:Landroid/animation/Keyframe$FloatKeyframe;
    .end local v5           #nextValue:F
    .end local v6           #prevFraction:F
    .end local v7           #prevKeyframe:Landroid/animation/Keyframe$FloatKeyframe;
    .end local v8           #prevValue:F
    :cond_10f
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v9, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/animation/Keyframe$FloatKeyframe;

    .line 111
    .restart local v7       #prevKeyframe:Landroid/animation/Keyframe$FloatKeyframe;
    const/4 v0, 0x1

    .local v0, i:I
    :goto_118
    iget v9, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    if-ge v0, v9, :cond_173

    .line 112
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v9, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/animation/Keyframe$FloatKeyframe;

    .line 113
    .restart local v4       #nextKeyframe:Landroid/animation/Keyframe$FloatKeyframe;
    invoke-virtual {v4}, Landroid/animation/Keyframe$FloatKeyframe;->getFraction()F

    move-result v9

    cmpg-float v9, p1, v9

    if-gez v9, :cond_16f

    .line 114
    invoke-virtual {v4}, Landroid/animation/Keyframe$FloatKeyframe;->getInterpolator()Landroid/animation/TimeInterpolator;

    move-result-object v1

    .line 115
    .restart local v1       #interpolator:Landroid/animation/TimeInterpolator;
    if-eqz v1, :cond_136

    .line 116
    invoke-interface {v1, p1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result p1

    .line 118
    :cond_136
    invoke-virtual {v7}, Landroid/animation/Keyframe$FloatKeyframe;->getFraction()F

    move-result v9

    sub-float v9, p1, v9

    invoke-virtual {v4}, Landroid/animation/Keyframe$FloatKeyframe;->getFraction()F

    move-result v10

    invoke-virtual {v7}, Landroid/animation/Keyframe$FloatKeyframe;->getFraction()F

    move-result v11

    sub-float/2addr v10, v11

    div-float v2, v9, v10

    .line 120
    .restart local v2       #intervalFraction:F
    invoke-virtual {v7}, Landroid/animation/Keyframe$FloatKeyframe;->getFloatValue()F

    move-result v8

    .line 121
    .restart local v8       #prevValue:F
    invoke-virtual {v4}, Landroid/animation/Keyframe$FloatKeyframe;->getFloatValue()F

    move-result v5

    .line 122
    .restart local v5       #nextValue:F
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    if-nez v9, :cond_159

    sub-float v9, v5, v8

    mul-float/2addr v9, v2

    add-float/2addr v9, v8

    goto/16 :goto_44

    :cond_159
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    invoke-static {v8}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    invoke-interface {v9, v2, v10, v11}, Landroid/animation/TypeEvaluator;->evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Number;

    invoke-virtual {v9}, Ljava/lang/Number;->floatValue()F

    move-result v9

    goto/16 :goto_44

    .line 127
    .end local v1           #interpolator:Landroid/animation/TimeInterpolator;
    .end local v2           #intervalFraction:F
    .end local v5           #nextValue:F
    .end local v8           #prevValue:F
    :cond_16f
    move-object v7, v4

    .line 111
    add-int/lit8 v0, v0, 0x1

    goto :goto_118

    .line 130
    .end local v4           #nextKeyframe:Landroid/animation/Keyframe$FloatKeyframe;
    :cond_173
    iget-object v9, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    iget v10, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    add-int/lit8 v10, v10, -0x1

    invoke-virtual {v9, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/animation/Keyframe;

    invoke-virtual {v9}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Number;

    invoke-virtual {v9}, Ljava/lang/Number;->floatValue()F

    move-result v9

    goto/16 :goto_44
.end method

.method public getValue(F)Ljava/lang/Object;
    .registers 3
    .parameter "fraction"

    .prologue
    .line 45
    invoke-virtual {p0, p1}, Landroid/animation/FloatKeyframeSet;->getFloatValue(F)F

    move-result v0

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    return-object v0
.end method
