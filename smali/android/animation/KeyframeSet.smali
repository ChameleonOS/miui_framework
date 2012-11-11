.class Landroid/animation/KeyframeSet;
.super Ljava/lang/Object;
.source "KeyframeSet.java"


# instance fields
.field mEvaluator:Landroid/animation/TypeEvaluator;

.field mFirstKeyframe:Landroid/animation/Keyframe;

.field mInterpolator:Landroid/animation/TimeInterpolator;

.field mKeyframes:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/animation/Keyframe;",
            ">;"
        }
    .end annotation
.end field

.field mLastKeyframe:Landroid/animation/Keyframe;

.field mNumKeyframes:I


# direct methods
.method public varargs constructor <init>([Landroid/animation/Keyframe;)V
    .registers 4
    .parameter "keyframes"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    array-length v0, p1

    iput v0, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    iget-object v0, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-static {p1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    iget-object v0, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Keyframe;

    iput-object v0, p0, Landroid/animation/KeyframeSet;->mFirstKeyframe:Landroid/animation/Keyframe;

    iget-object v0, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    iget v1, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Keyframe;

    iput-object v0, p0, Landroid/animation/KeyframeSet;->mLastKeyframe:Landroid/animation/Keyframe;

    iget-object v0, p0, Landroid/animation/KeyframeSet;->mLastKeyframe:Landroid/animation/Keyframe;

    invoke-virtual {v0}, Landroid/animation/Keyframe;->getInterpolator()Landroid/animation/TimeInterpolator;

    move-result-object v0

    iput-object v0, p0, Landroid/animation/KeyframeSet;->mInterpolator:Landroid/animation/TimeInterpolator;

    return-void
.end method

.method public static varargs ofFloat([F)Landroid/animation/KeyframeSet;
    .registers 8
    .parameter "values"

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v4, 0x0

    array-length v2, p0

    .local v2, numKeyframes:I
    const/4 v3, 0x2

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    new-array v1, v3, [Landroid/animation/Keyframe$FloatKeyframe;

    .local v1, keyframes:[Landroid/animation/Keyframe$FloatKeyframe;
    if-ne v2, v6, :cond_27

    invoke-static {v5}, Landroid/animation/Keyframe;->ofFloat(F)Landroid/animation/Keyframe;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe$FloatKeyframe;

    aput-object v3, v1, v4

    const/high16 v3, 0x3f80

    aget v4, p0, v4

    invoke-static {v3, v4}, Landroid/animation/Keyframe;->ofFloat(FF)Landroid/animation/Keyframe;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe$FloatKeyframe;

    aput-object v3, v1, v6

    :cond_21
    new-instance v3, Landroid/animation/FloatKeyframeSet;

    invoke-direct {v3, v1}, Landroid/animation/FloatKeyframeSet;-><init>([Landroid/animation/Keyframe$FloatKeyframe;)V

    return-object v3

    :cond_27
    aget v3, p0, v4

    invoke-static {v5, v3}, Landroid/animation/Keyframe;->ofFloat(FF)Landroid/animation/Keyframe;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe$FloatKeyframe;

    aput-object v3, v1, v4

    const/4 v0, 0x1

    .local v0, i:I
    :goto_32
    if-ge v0, v2, :cond_21

    int-to-float v3, v0

    add-int/lit8 v4, v2, -0x1

    int-to-float v4, v4

    div-float/2addr v3, v4

    aget v4, p0, v0

    invoke-static {v3, v4}, Landroid/animation/Keyframe;->ofFloat(FF)Landroid/animation/Keyframe;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe$FloatKeyframe;

    aput-object v3, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_32
.end method

.method public static varargs ofInt([I)Landroid/animation/KeyframeSet;
    .registers 8
    .parameter "values"

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v4, 0x0

    array-length v2, p0

    .local v2, numKeyframes:I
    const/4 v3, 0x2

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    new-array v1, v3, [Landroid/animation/Keyframe$IntKeyframe;

    .local v1, keyframes:[Landroid/animation/Keyframe$IntKeyframe;
    if-ne v2, v6, :cond_27

    invoke-static {v5}, Landroid/animation/Keyframe;->ofInt(F)Landroid/animation/Keyframe;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe$IntKeyframe;

    aput-object v3, v1, v4

    const/high16 v3, 0x3f80

    aget v4, p0, v4

    invoke-static {v3, v4}, Landroid/animation/Keyframe;->ofInt(FI)Landroid/animation/Keyframe;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe$IntKeyframe;

    aput-object v3, v1, v6

    :cond_21
    new-instance v3, Landroid/animation/IntKeyframeSet;

    invoke-direct {v3, v1}, Landroid/animation/IntKeyframeSet;-><init>([Landroid/animation/Keyframe$IntKeyframe;)V

    return-object v3

    :cond_27
    aget v3, p0, v4

    invoke-static {v5, v3}, Landroid/animation/Keyframe;->ofInt(FI)Landroid/animation/Keyframe;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe$IntKeyframe;

    aput-object v3, v1, v4

    const/4 v0, 0x1

    .local v0, i:I
    :goto_32
    if-ge v0, v2, :cond_21

    int-to-float v3, v0

    add-int/lit8 v4, v2, -0x1

    int-to-float v4, v4

    div-float/2addr v3, v4

    aget v4, p0, v0

    invoke-static {v3, v4}, Landroid/animation/Keyframe;->ofInt(FI)Landroid/animation/Keyframe;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe$IntKeyframe;

    aput-object v3, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_32
.end method

.method public static varargs ofKeyframe([Landroid/animation/Keyframe;)Landroid/animation/KeyframeSet;
    .registers 9
    .parameter "keyframes"

    .prologue
    array-length v6, p0

    .local v6, numKeyframes:I
    const/4 v1, 0x0

    .local v1, hasFloat:Z
    const/4 v2, 0x0

    .local v2, hasInt:Z
    const/4 v3, 0x0

    .local v3, hasOther:Z
    const/4 v4, 0x0

    .local v4, i:I
    :goto_5
    if-ge v4, v6, :cond_1b

    aget-object v7, p0, v4

    instance-of v7, v7, Landroid/animation/Keyframe$FloatKeyframe;

    if-eqz v7, :cond_11

    const/4 v1, 0x1

    :goto_e
    add-int/lit8 v4, v4, 0x1

    goto :goto_5

    :cond_11
    aget-object v7, p0, v4

    instance-of v7, v7, Landroid/animation/Keyframe$IntKeyframe;

    if-eqz v7, :cond_19

    const/4 v2, 0x1

    goto :goto_e

    :cond_19
    const/4 v3, 0x1

    goto :goto_e

    :cond_1b
    if-eqz v1, :cond_35

    if-nez v2, :cond_35

    if-nez v3, :cond_35

    new-array v0, v6, [Landroid/animation/Keyframe$FloatKeyframe;

    .local v0, floatKeyframes:[Landroid/animation/Keyframe$FloatKeyframe;
    const/4 v4, 0x0

    :goto_24
    if-ge v4, v6, :cond_2f

    aget-object v7, p0, v4

    check-cast v7, Landroid/animation/Keyframe$FloatKeyframe;

    aput-object v7, v0, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_24

    :cond_2f
    new-instance v7, Landroid/animation/FloatKeyframeSet;

    invoke-direct {v7, v0}, Landroid/animation/FloatKeyframeSet;-><init>([Landroid/animation/Keyframe$FloatKeyframe;)V

    .end local v0           #floatKeyframes:[Landroid/animation/Keyframe$FloatKeyframe;
    :goto_34
    return-object v7

    :cond_35
    if-eqz v2, :cond_4f

    if-nez v1, :cond_4f

    if-nez v3, :cond_4f

    new-array v5, v6, [Landroid/animation/Keyframe$IntKeyframe;

    .local v5, intKeyframes:[Landroid/animation/Keyframe$IntKeyframe;
    const/4 v4, 0x0

    :goto_3e
    if-ge v4, v6, :cond_49

    aget-object v7, p0, v4

    check-cast v7, Landroid/animation/Keyframe$IntKeyframe;

    aput-object v7, v5, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_3e

    :cond_49
    new-instance v7, Landroid/animation/IntKeyframeSet;

    invoke-direct {v7, v5}, Landroid/animation/IntKeyframeSet;-><init>([Landroid/animation/Keyframe$IntKeyframe;)V

    goto :goto_34

    .end local v5           #intKeyframes:[Landroid/animation/Keyframe$IntKeyframe;
    :cond_4f
    new-instance v7, Landroid/animation/KeyframeSet;

    invoke-direct {v7, p0}, Landroid/animation/KeyframeSet;-><init>([Landroid/animation/Keyframe;)V

    goto :goto_34
.end method

.method public static varargs ofObject([Ljava/lang/Object;)Landroid/animation/KeyframeSet;
    .registers 8
    .parameter "values"

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v4, 0x0

    array-length v2, p0

    .local v2, numKeyframes:I
    const/4 v3, 0x2

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    new-array v1, v3, [Landroid/animation/Keyframe$ObjectKeyframe;

    .local v1, keyframes:[Landroid/animation/Keyframe$ObjectKeyframe;
    if-ne v2, v6, :cond_27

    invoke-static {v5}, Landroid/animation/Keyframe;->ofObject(F)Landroid/animation/Keyframe;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe$ObjectKeyframe;

    aput-object v3, v1, v4

    const/high16 v3, 0x3f80

    aget-object v4, p0, v4

    invoke-static {v3, v4}, Landroid/animation/Keyframe;->ofObject(FLjava/lang/Object;)Landroid/animation/Keyframe;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe$ObjectKeyframe;

    aput-object v3, v1, v6

    :cond_21
    new-instance v3, Landroid/animation/KeyframeSet;

    invoke-direct {v3, v1}, Landroid/animation/KeyframeSet;-><init>([Landroid/animation/Keyframe;)V

    return-object v3

    :cond_27
    aget-object v3, p0, v4

    invoke-static {v5, v3}, Landroid/animation/Keyframe;->ofObject(FLjava/lang/Object;)Landroid/animation/Keyframe;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe$ObjectKeyframe;

    aput-object v3, v1, v4

    const/4 v0, 0x1

    .local v0, i:I
    :goto_32
    if-ge v0, v2, :cond_21

    int-to-float v3, v0

    add-int/lit8 v4, v2, -0x1

    int-to-float v4, v4

    div-float/2addr v3, v4

    aget-object v4, p0, v0

    invoke-static {v3, v4}, Landroid/animation/Keyframe;->ofObject(FLjava/lang/Object;)Landroid/animation/Keyframe;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe$ObjectKeyframe;

    aput-object v3, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_32
.end method


# virtual methods
.method public clone()Landroid/animation/KeyframeSet;
    .registers 7

    .prologue
    iget-object v1, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    .local v1, keyframes:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/Keyframe;>;"
    iget-object v5, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v4

    .local v4, numKeyframes:I
    new-array v2, v4, [Landroid/animation/Keyframe;

    .local v2, newKeyframes:[Landroid/animation/Keyframe;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_b
    if-ge v0, v4, :cond_1c

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/animation/Keyframe;

    invoke-virtual {v5}, Landroid/animation/Keyframe;->clone()Landroid/animation/Keyframe;

    move-result-object v5

    aput-object v5, v2, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_b

    :cond_1c
    new-instance v3, Landroid/animation/KeyframeSet;

    invoke-direct {v3, v2}, Landroid/animation/KeyframeSet;-><init>([Landroid/animation/Keyframe;)V

    .local v3, newSet:Landroid/animation/KeyframeSet;
    return-object v3
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    invoke-virtual {p0}, Landroid/animation/KeyframeSet;->clone()Landroid/animation/KeyframeSet;

    move-result-object v0

    return-object v0
.end method

.method public getValue(F)Ljava/lang/Object;
    .registers 11
    .parameter "fraction"

    .prologue
    iget v6, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    const/4 v7, 0x2

    if-ne v6, v7, :cond_22

    iget-object v6, p0, Landroid/animation/KeyframeSet;->mInterpolator:Landroid/animation/TimeInterpolator;

    if-eqz v6, :cond_f

    iget-object v6, p0, Landroid/animation/KeyframeSet;->mInterpolator:Landroid/animation/TimeInterpolator;

    invoke-interface {v6, p1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result p1

    :cond_f
    iget-object v6, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    iget-object v7, p0, Landroid/animation/KeyframeSet;->mFirstKeyframe:Landroid/animation/Keyframe;

    invoke-virtual {v7}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v7

    iget-object v8, p0, Landroid/animation/KeyframeSet;->mLastKeyframe:Landroid/animation/Keyframe;

    invoke-virtual {v8}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v8

    invoke-interface {v6, p1, v7, v8}, Landroid/animation/TypeEvaluator;->evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    :goto_21
    return-object v6

    :cond_22
    const/4 v6, 0x0

    cmpg-float v6, p1, v6

    if-gtz v6, :cond_5a

    iget-object v6, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    const/4 v7, 0x1

    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe;

    .local v3, nextKeyframe:Landroid/animation/Keyframe;
    invoke-virtual {v3}, Landroid/animation/Keyframe;->getInterpolator()Landroid/animation/TimeInterpolator;

    move-result-object v1

    .local v1, interpolator:Landroid/animation/TimeInterpolator;
    if-eqz v1, :cond_3a

    invoke-interface {v1, p1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result p1

    :cond_3a
    iget-object v6, p0, Landroid/animation/KeyframeSet;->mFirstKeyframe:Landroid/animation/Keyframe;

    invoke-virtual {v6}, Landroid/animation/Keyframe;->getFraction()F

    move-result v4

    .local v4, prevFraction:F
    sub-float v6, p1, v4

    invoke-virtual {v3}, Landroid/animation/Keyframe;->getFraction()F

    move-result v7

    sub-float/2addr v7, v4

    div-float v2, v6, v7

    .local v2, intervalFraction:F
    iget-object v6, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    iget-object v7, p0, Landroid/animation/KeyframeSet;->mFirstKeyframe:Landroid/animation/Keyframe;

    invoke-virtual {v7}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v3}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v8

    invoke-interface {v6, v2, v7, v8}, Landroid/animation/TypeEvaluator;->evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    goto :goto_21

    .end local v1           #interpolator:Landroid/animation/TimeInterpolator;
    .end local v2           #intervalFraction:F
    .end local v3           #nextKeyframe:Landroid/animation/Keyframe;
    .end local v4           #prevFraction:F
    :cond_5a
    const/high16 v6, 0x3f80

    cmpl-float v6, p1, v6

    if-ltz v6, :cond_98

    iget-object v6, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    iget v7, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    add-int/lit8 v7, v7, -0x2

    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/animation/Keyframe;

    .local v5, prevKeyframe:Landroid/animation/Keyframe;
    iget-object v6, p0, Landroid/animation/KeyframeSet;->mLastKeyframe:Landroid/animation/Keyframe;

    invoke-virtual {v6}, Landroid/animation/Keyframe;->getInterpolator()Landroid/animation/TimeInterpolator;

    move-result-object v1

    .restart local v1       #interpolator:Landroid/animation/TimeInterpolator;
    if-eqz v1, :cond_78

    invoke-interface {v1, p1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result p1

    :cond_78
    invoke-virtual {v5}, Landroid/animation/Keyframe;->getFraction()F

    move-result v4

    .restart local v4       #prevFraction:F
    sub-float v6, p1, v4

    iget-object v7, p0, Landroid/animation/KeyframeSet;->mLastKeyframe:Landroid/animation/Keyframe;

    invoke-virtual {v7}, Landroid/animation/Keyframe;->getFraction()F

    move-result v7

    sub-float/2addr v7, v4

    div-float v2, v6, v7

    .restart local v2       #intervalFraction:F
    iget-object v6, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    invoke-virtual {v5}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v7

    iget-object v8, p0, Landroid/animation/KeyframeSet;->mLastKeyframe:Landroid/animation/Keyframe;

    invoke-virtual {v8}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v8

    invoke-interface {v6, v2, v7, v8}, Landroid/animation/TypeEvaluator;->evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    goto :goto_21

    .end local v1           #interpolator:Landroid/animation/TimeInterpolator;
    .end local v2           #intervalFraction:F
    .end local v4           #prevFraction:F
    .end local v5           #prevKeyframe:Landroid/animation/Keyframe;
    :cond_98
    iget-object v5, p0, Landroid/animation/KeyframeSet;->mFirstKeyframe:Landroid/animation/Keyframe;

    .restart local v5       #prevKeyframe:Landroid/animation/Keyframe;
    const/4 v0, 0x1

    .local v0, i:I
    :goto_9b
    iget v6, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    if-ge v0, v6, :cond_da

    iget-object v6, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/animation/Keyframe;

    .restart local v3       #nextKeyframe:Landroid/animation/Keyframe;
    invoke-virtual {v3}, Landroid/animation/Keyframe;->getFraction()F

    move-result v6

    cmpg-float v6, p1, v6

    if-gez v6, :cond_d6

    invoke-virtual {v3}, Landroid/animation/Keyframe;->getInterpolator()Landroid/animation/TimeInterpolator;

    move-result-object v1

    .restart local v1       #interpolator:Landroid/animation/TimeInterpolator;
    if-eqz v1, :cond_b9

    invoke-interface {v1, p1}, Landroid/animation/TimeInterpolator;->getInterpolation(F)F

    move-result p1

    :cond_b9
    invoke-virtual {v5}, Landroid/animation/Keyframe;->getFraction()F

    move-result v4

    .restart local v4       #prevFraction:F
    sub-float v6, p1, v4

    invoke-virtual {v3}, Landroid/animation/Keyframe;->getFraction()F

    move-result v7

    sub-float/2addr v7, v4

    div-float v2, v6, v7

    .restart local v2       #intervalFraction:F
    iget-object v6, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    invoke-virtual {v5}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v3}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v8

    invoke-interface {v6, v2, v7, v8}, Landroid/animation/TypeEvaluator;->evaluate(FLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    goto/16 :goto_21

    .end local v1           #interpolator:Landroid/animation/TimeInterpolator;
    .end local v2           #intervalFraction:F
    .end local v4           #prevFraction:F
    :cond_d6
    move-object v5, v3

    add-int/lit8 v0, v0, 0x1

    goto :goto_9b

    .end local v3           #nextKeyframe:Landroid/animation/Keyframe;
    :cond_da
    iget-object v6, p0, Landroid/animation/KeyframeSet;->mLastKeyframe:Landroid/animation/Keyframe;

    invoke-virtual {v6}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v6

    goto/16 :goto_21
.end method

.method public setEvaluator(Landroid/animation/TypeEvaluator;)V
    .registers 2
    .parameter "evaluator"

    .prologue
    iput-object p1, p0, Landroid/animation/KeyframeSet;->mEvaluator:Landroid/animation/TypeEvaluator;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 5

    .prologue
    const-string v1, " "

    .local v1, returnVal:Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_3
    iget v2, p0, Landroid/animation/KeyframeSet;->mNumKeyframes:I

    if-ge v0, v2, :cond_2d

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v2, p0, Landroid/animation/KeyframeSet;->mKeyframes:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/animation/Keyframe;

    invoke-virtual {v2}, Landroid/animation/Keyframe;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "  "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    :cond_2d
    return-object v1
.end method
