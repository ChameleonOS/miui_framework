.class Lcom/android/internal/widget/multiwaveview/Tweener;
.super Ljava/lang/Object;
.source "Tweener.java"


# static fields
.field private static final DEBUG:Z = false

.field private static final TAG:Ljava/lang/String; = "Tweener"

.field private static mCleanupListener:Landroid/animation/Animator$AnimatorListener;

.field private static sTweens:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Object;",
            "Lcom/android/internal/widget/multiwaveview/Tweener;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field animator:Landroid/animation/ObjectAnimator;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 38
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/android/internal/widget/multiwaveview/Tweener;->sTweens:Ljava/util/HashMap;

    .line 140
    new-instance v0, Lcom/android/internal/widget/multiwaveview/Tweener$1;

    invoke-direct {v0}, Lcom/android/internal/widget/multiwaveview/Tweener$1;-><init>()V

    sput-object v0, Lcom/android/internal/widget/multiwaveview/Tweener;->mCleanupListener:Landroid/animation/Animator$AnimatorListener;

    return-void
.end method

.method public constructor <init>(Landroid/animation/ObjectAnimator;)V
    .registers 2
    .parameter "anim"

    .prologue
    .line 40
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Lcom/android/internal/widget/multiwaveview/Tweener;->animator:Landroid/animation/ObjectAnimator;

    .line 42
    return-void
.end method

.method static synthetic access$000(Landroid/animation/Animator;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 33
    invoke-static {p0}, Lcom/android/internal/widget/multiwaveview/Tweener;->remove(Landroid/animation/Animator;)V

    return-void
.end method

.method private static remove(Landroid/animation/Animator;)V
    .registers 4
    .parameter "animator"

    .prologue
    .line 45
    sget-object v2, Lcom/android/internal/widget/multiwaveview/Tweener;->sTweens:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 46
    .local v1, iter:Ljava/util/Iterator;,"Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/Object;Lcom/android/internal/widget/multiwaveview/Tweener;>;>;"
    :cond_a
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_23

    .line 47
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 48
    .local v0, entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Ljava/lang/Object;Lcom/android/internal/widget/multiwaveview/Tweener;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/internal/widget/multiwaveview/Tweener;

    iget-object v2, v2, Lcom/android/internal/widget/multiwaveview/Tweener;->animator:Landroid/animation/ObjectAnimator;

    if-ne v2, p0, :cond_a

    .line 51
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    .line 55
    .end local v0           #entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Ljava/lang/Object;Lcom/android/internal/widget/multiwaveview/Tweener;>;"
    :cond_23
    return-void
.end method

.method private static varargs replace(Ljava/util/ArrayList;[Ljava/lang/Object;)V
    .registers 9
    .parameter
    .parameter "args"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/animation/PropertyValuesHolder;",
            ">;[",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .line 164
    .local p0, props:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/PropertyValuesHolder;>;"
    move-object v0, p1

    .local v0, arr$:[Ljava/lang/Object;
    array-length v3, v0

    .local v3, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_3
    if-ge v1, v3, :cond_32

    aget-object v2, v0, v1

    .line 165
    .local v2, killobject:Ljava/lang/Object;
    sget-object v5, Lcom/android/internal/widget/multiwaveview/Tweener;->sTweens:Ljava/util/HashMap;

    invoke-virtual {v5, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/internal/widget/multiwaveview/Tweener;

    .line 166
    .local v4, tween:Lcom/android/internal/widget/multiwaveview/Tweener;
    if-eqz v4, :cond_29

    .line 167
    iget-object v5, v4, Lcom/android/internal/widget/multiwaveview/Tweener;->animator:Landroid/animation/ObjectAnimator;

    invoke-virtual {v5}, Landroid/animation/ObjectAnimator;->cancel()V

    .line 168
    if-eqz p0, :cond_2c

    .line 169
    iget-object v6, v4, Lcom/android/internal/widget/multiwaveview/Tweener;->animator:Landroid/animation/ObjectAnimator;

    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v5

    new-array v5, v5, [Landroid/animation/PropertyValuesHolder;

    invoke-virtual {p0, v5}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Landroid/animation/PropertyValuesHolder;

    invoke-virtual {v6, v5}, Landroid/animation/ObjectAnimator;->setValues([Landroid/animation/PropertyValuesHolder;)V

    .line 164
    :cond_29
    :goto_29
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 172
    :cond_2c
    sget-object v5, Lcom/android/internal/widget/multiwaveview/Tweener;->sTweens:Ljava/util/HashMap;

    invoke-virtual {v5, v4}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_29

    .line 176
    .end local v2           #killobject:Ljava/lang/Object;
    .end local v4           #tween:Lcom/android/internal/widget/multiwaveview/Tweener;
    :cond_32
    return-void
.end method

.method public static reset()V
    .registers 1

    .prologue
    .line 160
    sget-object v0, Lcom/android/internal/widget/multiwaveview/Tweener;->sTweens:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 161
    return-void
.end method

.method public static varargs to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;
    .registers 22
    .parameter "object"
    .parameter "duration"
    .parameter "vars"

    .prologue
    .line 58
    const-wide/16 v3, 0x0

    .line 59
    .local v3, delay:J
    const/4 v12, 0x0

    .line 60
    .local v12, updateListener:Landroid/animation/ValueAnimator$AnimatorUpdateListener;
    const/4 v9, 0x0

    .line 61
    .local v9, listener:Landroid/animation/Animator$AnimatorListener;
    const/4 v7, 0x0

    .line 64
    .local v7, interpolator:Landroid/animation/TimeInterpolator;
    new-instance v10, Ljava/util/ArrayList;

    move-object/from16 v0, p3

    array-length v14, v0

    div-int/lit8 v14, v14, 0x2

    invoke-direct {v10, v14}, Ljava/util/ArrayList;-><init>(I)V

    .line 65
    .local v10, props:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/PropertyValuesHolder;>;"
    const/4 v6, 0x0

    .local v6, i:I
    :goto_10
    move-object/from16 v0, p3

    array-length v14, v0

    if-ge v6, v14, :cond_129

    .line 66
    aget-object v14, p3, v6

    instance-of v14, v14, Ljava/lang/String;

    if-nez v14, :cond_36

    .line 67
    new-instance v14, Ljava/lang/IllegalArgumentException;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "Key must be a string: "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    aget-object v16, p3, v6

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-direct {v14, v15}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 69
    :cond_36
    aget-object v8, p3, v6

    check-cast v8, Ljava/lang/String;

    .line 70
    .local v8, key:Ljava/lang/String;
    add-int/lit8 v14, v6, 0x1

    aget-object v13, p3, v14

    .line 71
    .local v13, value:Ljava/lang/Object;
    const-string/jumbo v14, "simultaneousTween"

    invoke-virtual {v14, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_4a

    .line 65
    .end local v13           #value:Ljava/lang/Object;
    :cond_47
    :goto_47
    add-int/lit8 v6, v6, 0x2

    goto :goto_10

    .line 73
    .restart local v13       #value:Ljava/lang/Object;
    :cond_4a
    const-string v14, "ease"

    invoke-virtual {v14, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_56

    move-object v7, v13

    .line 74
    check-cast v7, Landroid/animation/TimeInterpolator;

    goto :goto_47

    .line 75
    :cond_56
    const-string/jumbo v14, "onUpdate"

    invoke-virtual {v14, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-nez v14, :cond_68

    const-string/jumbo v14, "onUpdateListener"

    invoke-virtual {v14, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_6c

    :cond_68
    move-object v12, v13

    .line 76
    check-cast v12, Landroid/animation/ValueAnimator$AnimatorUpdateListener;

    goto :goto_47

    .line 77
    :cond_6c
    const-string/jumbo v14, "onComplete"

    invoke-virtual {v14, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-nez v14, :cond_7e

    const-string/jumbo v14, "onCompleteListener"

    invoke-virtual {v14, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_82

    :cond_7e
    move-object v9, v13

    .line 78
    check-cast v9, Landroid/animation/Animator$AnimatorListener;

    goto :goto_47

    .line 79
    :cond_82
    const-string v14, "delay"

    invoke-virtual {v14, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_91

    .line 80
    check-cast v13, Ljava/lang/Number;

    .end local v13           #value:Ljava/lang/Object;
    invoke-virtual {v13}, Ljava/lang/Number;->longValue()J

    move-result-wide v3

    goto :goto_47

    .line 81
    .restart local v13       #value:Ljava/lang/Object;
    :cond_91
    const-string/jumbo v14, "syncWith"

    invoke-virtual {v14, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-nez v14, :cond_47

    .line 83
    instance-of v14, v13, [F

    if-eqz v14, :cond_c1

    .line 84
    const/4 v14, 0x2

    new-array v15, v14, [F

    const/16 v16, 0x0

    move-object v14, v13

    check-cast v14, [F

    check-cast v14, [F

    const/16 v17, 0x0

    aget v14, v14, v17

    aput v14, v15, v16

    const/4 v14, 0x1

    check-cast v13, [F

    .end local v13           #value:Ljava/lang/Object;
    check-cast v13, [F

    const/16 v16, 0x1

    aget v16, v13, v16

    aput v16, v15, v14

    invoke-static {v8, v15}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_47

    .line 86
    .restart local v13       #value:Ljava/lang/Object;
    :cond_c1
    instance-of v14, v13, [I

    if-eqz v14, :cond_e9

    .line 87
    const/4 v14, 0x2

    new-array v15, v14, [I

    const/16 v16, 0x0

    move-object v14, v13

    check-cast v14, [I

    check-cast v14, [I

    const/16 v17, 0x0

    aget v14, v14, v17

    aput v14, v15, v16

    const/4 v14, 0x1

    check-cast v13, [I

    .end local v13           #value:Ljava/lang/Object;
    check-cast v13, [I

    const/16 v16, 0x1

    aget v16, v13, v16

    aput v16, v15, v14

    invoke-static {v8, v15}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_47

    .line 89
    .restart local v13       #value:Ljava/lang/Object;
    :cond_e9
    instance-of v14, v13, Ljava/lang/Number;

    if-eqz v14, :cond_102

    .line 90
    check-cast v13, Ljava/lang/Number;

    .end local v13           #value:Ljava/lang/Object;
    invoke-virtual {v13}, Ljava/lang/Number;->floatValue()F

    move-result v5

    .line 91
    .local v5, floatValue:F
    const/4 v14, 0x1

    new-array v14, v14, [F

    const/4 v15, 0x0

    aput v5, v14, v15

    invoke-static {v8, v14}, Landroid/animation/PropertyValuesHolder;->ofFloat(Ljava/lang/String;[F)Landroid/animation/PropertyValuesHolder;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_47

    .line 93
    .end local v5           #floatValue:F
    .restart local v13       #value:Ljava/lang/Object;
    :cond_102
    new-instance v14, Ljava/lang/IllegalArgumentException;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "Bad argument for key \""

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "\" with value "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v13}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-direct {v14, v15}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 99
    .end local v8           #key:Ljava/lang/String;
    .end local v13           #value:Ljava/lang/Object;
    :cond_129
    sget-object v14, Lcom/android/internal/widget/multiwaveview/Tweener;->sTweens:Ljava/util/HashMap;

    move-object/from16 v0, p0

    invoke-virtual {v14, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/android/internal/widget/multiwaveview/Tweener;

    .line 100
    .local v11, tween:Lcom/android/internal/widget/multiwaveview/Tweener;
    const/4 v2, 0x0

    .line 101
    .local v2, anim:Landroid/animation/ObjectAnimator;
    if-nez v11, :cond_177

    .line 102
    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v14

    new-array v14, v14, [Landroid/animation/PropertyValuesHolder;

    invoke-virtual {v10, v14}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v14

    check-cast v14, [Landroid/animation/PropertyValuesHolder;

    move-object/from16 v0, p0

    invoke-static {v0, v14}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    move-result-object v2

    .line 104
    new-instance v11, Lcom/android/internal/widget/multiwaveview/Tweener;

    .end local v11           #tween:Lcom/android/internal/widget/multiwaveview/Tweener;
    invoke-direct {v11, v2}, Lcom/android/internal/widget/multiwaveview/Tweener;-><init>(Landroid/animation/ObjectAnimator;)V

    .line 105
    .restart local v11       #tween:Lcom/android/internal/widget/multiwaveview/Tweener;
    sget-object v14, Lcom/android/internal/widget/multiwaveview/Tweener;->sTweens:Ljava/util/HashMap;

    move-object/from16 v0, p0

    invoke-virtual {v14, v0, v11}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 112
    :goto_154
    if-eqz v7, :cond_159

    .line 113
    invoke-virtual {v2, v7}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 117
    :cond_159
    invoke-virtual {v2, v3, v4}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    .line 118
    move-wide/from16 v0, p1

    invoke-virtual {v2, v0, v1}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 119
    if-eqz v12, :cond_169

    .line 120
    invoke-virtual {v2}, Landroid/animation/ObjectAnimator;->removeAllUpdateListeners()V

    .line 121
    invoke-virtual {v2, v12}, Landroid/animation/ObjectAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 123
    :cond_169
    if-eqz v9, :cond_171

    .line 124
    invoke-virtual {v2}, Landroid/animation/ObjectAnimator;->removeAllListeners()V

    .line 125
    invoke-virtual {v2, v9}, Landroid/animation/ObjectAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 127
    :cond_171
    sget-object v14, Lcom/android/internal/widget/multiwaveview/Tweener;->mCleanupListener:Landroid/animation/Animator$AnimatorListener;

    invoke-virtual {v2, v14}, Landroid/animation/ObjectAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 129
    return-object v11

    .line 108
    :cond_177
    sget-object v14, Lcom/android/internal/widget/multiwaveview/Tweener;->sTweens:Ljava/util/HashMap;

    move-object/from16 v0, p0

    invoke-virtual {v14, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/android/internal/widget/multiwaveview/Tweener;

    iget-object v2, v14, Lcom/android/internal/widget/multiwaveview/Tweener;->animator:Landroid/animation/ObjectAnimator;

    .line 109
    const/4 v14, 0x1

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    aput-object p0, v14, v15

    invoke-static {v10, v14}, Lcom/android/internal/widget/multiwaveview/Tweener;->replace(Ljava/util/ArrayList;[Ljava/lang/Object;)V

    goto :goto_154
.end method


# virtual methods
.method varargs from(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;
    .registers 6
    .parameter "object"
    .parameter "duration"
    .parameter "vars"

    .prologue
    .line 136
    invoke-static {p1, p2, p3, p4}, Lcom/android/internal/widget/multiwaveview/Tweener;->to(Ljava/lang/Object;J[Ljava/lang/Object;)Lcom/android/internal/widget/multiwaveview/Tweener;

    move-result-object v0

    return-object v0
.end method
