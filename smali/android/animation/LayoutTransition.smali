.class public Landroid/animation/LayoutTransition;
.super Ljava/lang/Object;
.source "LayoutTransition.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/animation/LayoutTransition$TransitionListener;
    }
.end annotation


# static fields
.field public static final APPEARING:I = 0x2

.field public static final CHANGE_APPEARING:I = 0x0

.field public static final CHANGE_DISAPPEARING:I = 0x1

.field public static final CHANGING:I = 0x4

.field private static DEFAULT_DURATION:J = 0x0L

.field public static final DISAPPEARING:I = 0x3

.field private static final FLAG_APPEARING:I = 0x1

.field private static final FLAG_CHANGE_APPEARING:I = 0x4

.field private static final FLAG_CHANGE_DISAPPEARING:I = 0x8

.field private static final FLAG_CHANGING:I = 0x10

.field private static final FLAG_DISAPPEARING:I = 0x2

.field private static defaultChange:Landroid/animation/ObjectAnimator;

.field private static defaultChangeIn:Landroid/animation/ObjectAnimator;

.field private static defaultChangeOut:Landroid/animation/ObjectAnimator;

.field private static defaultFadeIn:Landroid/animation/ObjectAnimator;

.field private static defaultFadeOut:Landroid/animation/ObjectAnimator;


# instance fields
.field private final currentAppearingAnimations:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Landroid/view/View;",
            "Landroid/animation/Animator;",
            ">;"
        }
    .end annotation
.end field

.field private final currentChangingAnimations:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Landroid/view/View;",
            "Landroid/animation/Animator;",
            ">;"
        }
    .end annotation
.end field

.field private final currentDisappearingAnimations:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Landroid/view/View;",
            "Landroid/animation/Animator;",
            ">;"
        }
    .end annotation
.end field

.field private final layoutChangeListenerMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/view/View;",
            "Landroid/view/View$OnLayoutChangeListener;",
            ">;"
        }
    .end annotation
.end field

.field private mAnimateParentHierarchy:Z

.field private mAppearingAnim:Landroid/animation/Animator;

.field private mAppearingDelay:J

.field private mAppearingDuration:J

.field private mAppearingInterpolator:Landroid/animation/TimeInterpolator;

.field private mChangingAnim:Landroid/animation/Animator;

.field private mChangingAppearingAnim:Landroid/animation/Animator;

.field private mChangingAppearingDelay:J

.field private mChangingAppearingDuration:J

.field private mChangingAppearingInterpolator:Landroid/animation/TimeInterpolator;

.field private mChangingAppearingStagger:J

.field private mChangingDelay:J

.field private mChangingDisappearingAnim:Landroid/animation/Animator;

.field private mChangingDisappearingDelay:J

.field private mChangingDisappearingDuration:J

.field private mChangingDisappearingInterpolator:Landroid/animation/TimeInterpolator;

.field private mChangingDisappearingStagger:J

.field private mChangingDuration:J

.field private mChangingInterpolator:Landroid/animation/TimeInterpolator;

.field private mChangingStagger:J

.field private mDisappearingAnim:Landroid/animation/Animator;

.field private mDisappearingDelay:J

.field private mDisappearingDuration:J

.field private mDisappearingInterpolator:Landroid/animation/TimeInterpolator;

.field private mListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/animation/LayoutTransition$TransitionListener;",
            ">;"
        }
    .end annotation
.end field

.field private mTransitionTypes:I

.field private final pendingAnimations:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/view/View;",
            "Landroid/animation/Animator;",
            ">;"
        }
    .end annotation
.end field

.field private staggerDelay:J


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    const-wide/16 v0, 0x12c

    sput-wide v0, Landroid/animation/LayoutTransition;->DEFAULT_DURATION:J

    return-void
.end method

.method public constructor <init>()V
    .registers 15

    .prologue
    const/4 v13, 0x1

    const-wide/16 v11, 0x0

    const/4 v7, 0x0

    const/4 v10, 0x2

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v7, p0, Landroid/animation/LayoutTransition;->mDisappearingAnim:Landroid/animation/Animator;

    iput-object v7, p0, Landroid/animation/LayoutTransition;->mAppearingAnim:Landroid/animation/Animator;

    iput-object v7, p0, Landroid/animation/LayoutTransition;->mChangingAppearingAnim:Landroid/animation/Animator;

    iput-object v7, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingAnim:Landroid/animation/Animator;

    iput-object v7, p0, Landroid/animation/LayoutTransition;->mChangingAnim:Landroid/animation/Animator;

    sget-wide v8, Landroid/animation/LayoutTransition;->DEFAULT_DURATION:J

    iput-wide v8, p0, Landroid/animation/LayoutTransition;->mChangingAppearingDuration:J

    sget-wide v8, Landroid/animation/LayoutTransition;->DEFAULT_DURATION:J

    iput-wide v8, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingDuration:J

    sget-wide v8, Landroid/animation/LayoutTransition;->DEFAULT_DURATION:J

    iput-wide v8, p0, Landroid/animation/LayoutTransition;->mChangingDuration:J

    sget-wide v8, Landroid/animation/LayoutTransition;->DEFAULT_DURATION:J

    iput-wide v8, p0, Landroid/animation/LayoutTransition;->mAppearingDuration:J

    sget-wide v8, Landroid/animation/LayoutTransition;->DEFAULT_DURATION:J

    iput-wide v8, p0, Landroid/animation/LayoutTransition;->mDisappearingDuration:J

    sget-wide v8, Landroid/animation/LayoutTransition;->DEFAULT_DURATION:J

    iput-wide v8, p0, Landroid/animation/LayoutTransition;->mAppearingDelay:J

    iput-wide v11, p0, Landroid/animation/LayoutTransition;->mDisappearingDelay:J

    iput-wide v11, p0, Landroid/animation/LayoutTransition;->mChangingAppearingDelay:J

    sget-wide v8, Landroid/animation/LayoutTransition;->DEFAULT_DURATION:J

    iput-wide v8, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingDelay:J

    iput-wide v11, p0, Landroid/animation/LayoutTransition;->mChangingDelay:J

    iput-wide v11, p0, Landroid/animation/LayoutTransition;->mChangingAppearingStagger:J

    iput-wide v11, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingStagger:J

    iput-wide v11, p0, Landroid/animation/LayoutTransition;->mChangingStagger:J

    new-instance v6, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v6}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    iput-object v6, p0, Landroid/animation/LayoutTransition;->mAppearingInterpolator:Landroid/animation/TimeInterpolator;

    new-instance v6, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v6}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    iput-object v6, p0, Landroid/animation/LayoutTransition;->mDisappearingInterpolator:Landroid/animation/TimeInterpolator;

    new-instance v6, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v6}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    iput-object v6, p0, Landroid/animation/LayoutTransition;->mChangingAppearingInterpolator:Landroid/animation/TimeInterpolator;

    new-instance v6, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v6}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    iput-object v6, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingInterpolator:Landroid/animation/TimeInterpolator;

    new-instance v6, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v6}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    iput-object v6, p0, Landroid/animation/LayoutTransition;->mChangingInterpolator:Landroid/animation/TimeInterpolator;

    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    iput-object v6, p0, Landroid/animation/LayoutTransition;->pendingAnimations:Ljava/util/HashMap;

    new-instance v6, Ljava/util/LinkedHashMap;

    invoke-direct {v6}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v6, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    new-instance v6, Ljava/util/LinkedHashMap;

    invoke-direct {v6}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v6, p0, Landroid/animation/LayoutTransition;->currentAppearingAnimations:Ljava/util/LinkedHashMap;

    new-instance v6, Ljava/util/LinkedHashMap;

    invoke-direct {v6}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v6, p0, Landroid/animation/LayoutTransition;->currentDisappearingAnimations:Ljava/util/LinkedHashMap;

    new-instance v6, Ljava/util/HashMap;

    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    iput-object v6, p0, Landroid/animation/LayoutTransition;->layoutChangeListenerMap:Ljava/util/HashMap;

    const/16 v6, 0xf

    iput v6, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    iput-boolean v13, p0, Landroid/animation/LayoutTransition;->mAnimateParentHierarchy:Z

    sget-object v6, Landroid/animation/LayoutTransition;->defaultChangeIn:Landroid/animation/ObjectAnimator;

    if-nez v6, :cond_171

    const-string v6, "left"

    new-array v8, v10, [I

    fill-array-data v8, :array_186

    invoke-static {v6, v8}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    move-result-object v1

    .local v1, pvhLeft:Landroid/animation/PropertyValuesHolder;
    const-string/jumbo v6, "top"

    new-array v8, v10, [I

    fill-array-data v8, :array_18e

    invoke-static {v6, v8}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    move-result-object v5

    .local v5, pvhTop:Landroid/animation/PropertyValuesHolder;
    const-string/jumbo v6, "right"

    new-array v8, v10, [I

    fill-array-data v8, :array_196

    invoke-static {v6, v8}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    move-result-object v2

    .local v2, pvhRight:Landroid/animation/PropertyValuesHolder;
    const-string v6, "bottom"

    new-array v8, v10, [I

    fill-array-data v8, :array_19e

    invoke-static {v6, v8}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    move-result-object v0

    .local v0, pvhBottom:Landroid/animation/PropertyValuesHolder;
    const-string/jumbo v6, "scrollX"

    new-array v8, v10, [I

    fill-array-data v8, :array_1a6

    invoke-static {v6, v8}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    move-result-object v3

    .local v3, pvhScrollX:Landroid/animation/PropertyValuesHolder;
    const-string/jumbo v6, "scrollY"

    new-array v8, v10, [I

    fill-array-data v8, :array_1ae

    invoke-static {v6, v8}, Landroid/animation/PropertyValuesHolder;->ofInt(Ljava/lang/String;[I)Landroid/animation/PropertyValuesHolder;

    move-result-object v4

    .local v4, pvhScrollY:Landroid/animation/PropertyValuesHolder;
    move-object v6, v7

    check-cast v6, Ljava/lang/Object;

    const/4 v8, 0x6

    new-array v8, v8, [Landroid/animation/PropertyValuesHolder;

    const/4 v9, 0x0

    aput-object v1, v8, v9

    aput-object v5, v8, v13

    aput-object v2, v8, v10

    const/4 v9, 0x3

    aput-object v0, v8, v9

    const/4 v9, 0x4

    aput-object v3, v8, v9

    const/4 v9, 0x5

    aput-object v4, v8, v9

    invoke-static {v6, v8}, Landroid/animation/ObjectAnimator;->ofPropertyValuesHolder(Ljava/lang/Object;[Landroid/animation/PropertyValuesHolder;)Landroid/animation/ObjectAnimator;

    move-result-object v6

    sput-object v6, Landroid/animation/LayoutTransition;->defaultChangeIn:Landroid/animation/ObjectAnimator;

    sget-object v6, Landroid/animation/LayoutTransition;->defaultChangeIn:Landroid/animation/ObjectAnimator;

    sget-wide v8, Landroid/animation/LayoutTransition;->DEFAULT_DURATION:J

    invoke-virtual {v6, v8, v9}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    sget-object v6, Landroid/animation/LayoutTransition;->defaultChangeIn:Landroid/animation/ObjectAnimator;

    iget-wide v8, p0, Landroid/animation/LayoutTransition;->mChangingAppearingDelay:J

    invoke-virtual {v6, v8, v9}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    sget-object v6, Landroid/animation/LayoutTransition;->defaultChangeIn:Landroid/animation/ObjectAnimator;

    iget-object v8, p0, Landroid/animation/LayoutTransition;->mChangingAppearingInterpolator:Landroid/animation/TimeInterpolator;

    invoke-virtual {v6, v8}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    sget-object v6, Landroid/animation/LayoutTransition;->defaultChangeIn:Landroid/animation/ObjectAnimator;

    invoke-virtual {v6}, Landroid/animation/ObjectAnimator;->clone()Landroid/animation/ObjectAnimator;

    move-result-object v6

    sput-object v6, Landroid/animation/LayoutTransition;->defaultChangeOut:Landroid/animation/ObjectAnimator;

    sget-object v6, Landroid/animation/LayoutTransition;->defaultChangeOut:Landroid/animation/ObjectAnimator;

    iget-wide v8, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingDelay:J

    invoke-virtual {v6, v8, v9}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    sget-object v6, Landroid/animation/LayoutTransition;->defaultChangeOut:Landroid/animation/ObjectAnimator;

    iget-object v8, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingInterpolator:Landroid/animation/TimeInterpolator;

    invoke-virtual {v6, v8}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    sget-object v6, Landroid/animation/LayoutTransition;->defaultChangeIn:Landroid/animation/ObjectAnimator;

    invoke-virtual {v6}, Landroid/animation/ObjectAnimator;->clone()Landroid/animation/ObjectAnimator;

    move-result-object v6

    sput-object v6, Landroid/animation/LayoutTransition;->defaultChange:Landroid/animation/ObjectAnimator;

    sget-object v6, Landroid/animation/LayoutTransition;->defaultChange:Landroid/animation/ObjectAnimator;

    iget-wide v8, p0, Landroid/animation/LayoutTransition;->mChangingDelay:J

    invoke-virtual {v6, v8, v9}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    sget-object v6, Landroid/animation/LayoutTransition;->defaultChange:Landroid/animation/ObjectAnimator;

    iget-object v8, p0, Landroid/animation/LayoutTransition;->mChangingInterpolator:Landroid/animation/TimeInterpolator;

    invoke-virtual {v6, v8}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    const-string v6, "alpha"

    new-array v8, v10, [F

    fill-array-data v8, :array_1b6

    invoke-static {v7, v6, v8}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v6

    sput-object v6, Landroid/animation/LayoutTransition;->defaultFadeIn:Landroid/animation/ObjectAnimator;

    sget-object v6, Landroid/animation/LayoutTransition;->defaultFadeIn:Landroid/animation/ObjectAnimator;

    sget-wide v8, Landroid/animation/LayoutTransition;->DEFAULT_DURATION:J

    invoke-virtual {v6, v8, v9}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    sget-object v6, Landroid/animation/LayoutTransition;->defaultFadeIn:Landroid/animation/ObjectAnimator;

    iget-wide v8, p0, Landroid/animation/LayoutTransition;->mAppearingDelay:J

    invoke-virtual {v6, v8, v9}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    sget-object v6, Landroid/animation/LayoutTransition;->defaultFadeIn:Landroid/animation/ObjectAnimator;

    iget-object v8, p0, Landroid/animation/LayoutTransition;->mAppearingInterpolator:Landroid/animation/TimeInterpolator;

    invoke-virtual {v6, v8}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    const-string v6, "alpha"

    new-array v8, v10, [F

    fill-array-data v8, :array_1be

    invoke-static {v7, v6, v8}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v6

    sput-object v6, Landroid/animation/LayoutTransition;->defaultFadeOut:Landroid/animation/ObjectAnimator;

    sget-object v6, Landroid/animation/LayoutTransition;->defaultFadeOut:Landroid/animation/ObjectAnimator;

    sget-wide v7, Landroid/animation/LayoutTransition;->DEFAULT_DURATION:J

    invoke-virtual {v6, v7, v8}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    sget-object v6, Landroid/animation/LayoutTransition;->defaultFadeOut:Landroid/animation/ObjectAnimator;

    iget-wide v7, p0, Landroid/animation/LayoutTransition;->mDisappearingDelay:J

    invoke-virtual {v6, v7, v8}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    sget-object v6, Landroid/animation/LayoutTransition;->defaultFadeOut:Landroid/animation/ObjectAnimator;

    iget-object v7, p0, Landroid/animation/LayoutTransition;->mDisappearingInterpolator:Landroid/animation/TimeInterpolator;

    invoke-virtual {v6, v7}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .end local v0           #pvhBottom:Landroid/animation/PropertyValuesHolder;
    .end local v1           #pvhLeft:Landroid/animation/PropertyValuesHolder;
    .end local v2           #pvhRight:Landroid/animation/PropertyValuesHolder;
    .end local v3           #pvhScrollX:Landroid/animation/PropertyValuesHolder;
    .end local v4           #pvhScrollY:Landroid/animation/PropertyValuesHolder;
    .end local v5           #pvhTop:Landroid/animation/PropertyValuesHolder;
    :cond_171
    sget-object v6, Landroid/animation/LayoutTransition;->defaultChangeIn:Landroid/animation/ObjectAnimator;

    iput-object v6, p0, Landroid/animation/LayoutTransition;->mChangingAppearingAnim:Landroid/animation/Animator;

    sget-object v6, Landroid/animation/LayoutTransition;->defaultChangeOut:Landroid/animation/ObjectAnimator;

    iput-object v6, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingAnim:Landroid/animation/Animator;

    sget-object v6, Landroid/animation/LayoutTransition;->defaultChange:Landroid/animation/ObjectAnimator;

    iput-object v6, p0, Landroid/animation/LayoutTransition;->mChangingAnim:Landroid/animation/Animator;

    sget-object v6, Landroid/animation/LayoutTransition;->defaultFadeIn:Landroid/animation/ObjectAnimator;

    iput-object v6, p0, Landroid/animation/LayoutTransition;->mAppearingAnim:Landroid/animation/Animator;

    sget-object v6, Landroid/animation/LayoutTransition;->defaultFadeOut:Landroid/animation/ObjectAnimator;

    iput-object v6, p0, Landroid/animation/LayoutTransition;->mDisappearingAnim:Landroid/animation/Animator;

    return-void

    :array_186
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
    .end array-data

    :array_18e
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
    .end array-data

    :array_196
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
    .end array-data

    :array_19e
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
    .end array-data

    :array_1a6
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
    .end array-data

    :array_1ae
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x1t 0x0t 0x0t 0x0t
    .end array-data

    :array_1b6
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x80t 0x3ft
    .end array-data

    :array_1be
    .array-data 0x4
        0x0t 0x0t 0x80t 0x3ft
        0x0t 0x0t 0x0t 0x0t
    .end array-data
.end method

.method static synthetic access$000(Landroid/animation/LayoutTransition;)Ljava/util/HashMap;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/animation/LayoutTransition;->layoutChangeListenerMap:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$100(Landroid/animation/LayoutTransition;)Ljava/util/HashMap;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/animation/LayoutTransition;->pendingAnimations:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$1000(Landroid/animation/LayoutTransition;)Z
    .registers 2
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Landroid/animation/LayoutTransition;->hasListeners()Z

    move-result v0

    return v0
.end method

.method static synthetic access$1100(Landroid/animation/LayoutTransition;)Ljava/util/ArrayList;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$1200(Landroid/animation/LayoutTransition;)Ljava/util/LinkedHashMap;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/animation/LayoutTransition;->currentAppearingAnimations:Ljava/util/LinkedHashMap;

    return-object v0
.end method

.method static synthetic access$1300(Landroid/animation/LayoutTransition;)Ljava/util/LinkedHashMap;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/animation/LayoutTransition;->currentDisappearingAnimations:Ljava/util/LinkedHashMap;

    return-object v0
.end method

.method static synthetic access$200(Landroid/animation/LayoutTransition;)J
    .registers 3
    .parameter "x0"

    .prologue
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingAppearingDelay:J

    return-wide v0
.end method

.method static synthetic access$300(Landroid/animation/LayoutTransition;)J
    .registers 3
    .parameter "x0"

    .prologue
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->staggerDelay:J

    return-wide v0
.end method

.method static synthetic access$314(Landroid/animation/LayoutTransition;J)J
    .registers 5
    .parameter "x0"
    .parameter "x1"

    .prologue
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->staggerDelay:J

    add-long/2addr v0, p1

    iput-wide v0, p0, Landroid/animation/LayoutTransition;->staggerDelay:J

    return-wide v0
.end method

.method static synthetic access$400(Landroid/animation/LayoutTransition;)J
    .registers 3
    .parameter "x0"

    .prologue
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingAppearingStagger:J

    return-wide v0
.end method

.method static synthetic access$500(Landroid/animation/LayoutTransition;)J
    .registers 3
    .parameter "x0"

    .prologue
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingDelay:J

    return-wide v0
.end method

.method static synthetic access$600(Landroid/animation/LayoutTransition;)J
    .registers 3
    .parameter "x0"

    .prologue
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingStagger:J

    return-wide v0
.end method

.method static synthetic access$700(Landroid/animation/LayoutTransition;)J
    .registers 3
    .parameter "x0"

    .prologue
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingDelay:J

    return-wide v0
.end method

.method static synthetic access$800(Landroid/animation/LayoutTransition;)J
    .registers 3
    .parameter "x0"

    .prologue
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingStagger:J

    return-wide v0
.end method

.method static synthetic access$900(Landroid/animation/LayoutTransition;)Ljava/util/LinkedHashMap;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    return-object v0
.end method

.method private addChild(Landroid/view/ViewGroup;Landroid/view/View;Z)V
    .registers 11
    .parameter "parent"
    .parameter "child"
    .parameter "changesLayout"

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x4

    const/4 v4, 0x1

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getWindowVisibility()I

    move-result v3

    if-eqz v3, :cond_a

    :cond_9
    :goto_9
    return-void

    :cond_a
    iget v3, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v3, v3, 0x1

    if-ne v3, v4, :cond_14

    const/4 v3, 0x3

    invoke-virtual {p0, v3}, Landroid/animation/LayoutTransition;->cancel(I)V

    :cond_14
    if-eqz p3, :cond_23

    iget v3, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v3, v3, 0x4

    if-ne v3, v5, :cond_23

    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Landroid/animation/LayoutTransition;->cancel(I)V

    invoke-virtual {p0, v5}, Landroid/animation/LayoutTransition;->cancel(I)V

    :cond_23
    invoke-direct {p0}, Landroid/animation/LayoutTransition;->hasListeners()Z

    move-result v3

    if-eqz v3, :cond_4b

    iget v3, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v3, v3, 0x1

    if-ne v3, v4, :cond_4b

    iget-object v3, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    .local v2, listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/LayoutTransition$TransitionListener;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_3b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4b

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/animation/LayoutTransition$TransitionListener;

    .local v1, listener:Landroid/animation/LayoutTransition$TransitionListener;
    invoke-interface {v1, p0, p1, p2, v6}, Landroid/animation/LayoutTransition$TransitionListener;->startTransition(Landroid/animation/LayoutTransition;Landroid/view/ViewGroup;Landroid/view/View;I)V

    goto :goto_3b

    .end local v0           #i$:Ljava/util/Iterator;
    .end local v1           #listener:Landroid/animation/LayoutTransition$TransitionListener;
    .end local v2           #listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/LayoutTransition$TransitionListener;>;"
    :cond_4b
    if-eqz p3, :cond_56

    iget v3, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v3, v3, 0x4

    if-ne v3, v5, :cond_56

    invoke-direct {p0, p1, p2, v6}, Landroid/animation/LayoutTransition;->runChangeTransition(Landroid/view/ViewGroup;Landroid/view/View;I)V

    :cond_56
    iget v3, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v3, v3, 0x1

    if-ne v3, v4, :cond_9

    invoke-direct {p0, p1, p2}, Landroid/animation/LayoutTransition;->runAppearingTransition(Landroid/view/ViewGroup;Landroid/view/View;)V

    goto :goto_9
.end method

.method private hasListeners()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    if-eqz v0, :cond_e

    iget-object v0, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_e

    const/4 v0, 0x1

    :goto_d
    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_d
.end method

.method private removeChild(Landroid/view/ViewGroup;Landroid/view/View;Z)V
    .registers 11
    .parameter "parent"
    .parameter "child"
    .parameter "changesLayout"

    .prologue
    const/16 v6, 0x8

    const/4 v5, 0x3

    const/4 v4, 0x2

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getWindowVisibility()I

    move-result v3

    if-eqz v3, :cond_b

    :cond_a
    :goto_a
    return-void

    :cond_b
    iget v3, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v3, v3, 0x2

    if-ne v3, v4, :cond_14

    invoke-virtual {p0, v4}, Landroid/animation/LayoutTransition;->cancel(I)V

    :cond_14
    if-eqz p3, :cond_24

    iget v3, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v3, v3, 0x8

    if-ne v3, v6, :cond_24

    const/4 v3, 0x1

    invoke-virtual {p0, v3}, Landroid/animation/LayoutTransition;->cancel(I)V

    const/4 v3, 0x4

    invoke-virtual {p0, v3}, Landroid/animation/LayoutTransition;->cancel(I)V

    :cond_24
    invoke-direct {p0}, Landroid/animation/LayoutTransition;->hasListeners()Z

    move-result v3

    if-eqz v3, :cond_4c

    iget v3, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v3, v3, 0x2

    if-ne v3, v4, :cond_4c

    iget-object v3, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    .local v2, listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/LayoutTransition$TransitionListener;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_3c
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4c

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/animation/LayoutTransition$TransitionListener;

    .local v1, listener:Landroid/animation/LayoutTransition$TransitionListener;
    invoke-interface {v1, p0, p1, p2, v5}, Landroid/animation/LayoutTransition$TransitionListener;->startTransition(Landroid/animation/LayoutTransition;Landroid/view/ViewGroup;Landroid/view/View;I)V

    goto :goto_3c

    .end local v0           #i$:Ljava/util/Iterator;
    .end local v1           #listener:Landroid/animation/LayoutTransition$TransitionListener;
    .end local v2           #listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/LayoutTransition$TransitionListener;>;"
    :cond_4c
    if-eqz p3, :cond_57

    iget v3, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v3, v3, 0x8

    if-ne v3, v6, :cond_57

    invoke-direct {p0, p1, p2, v5}, Landroid/animation/LayoutTransition;->runChangeTransition(Landroid/view/ViewGroup;Landroid/view/View;I)V

    :cond_57
    iget v3, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v3, v3, 0x2

    if-ne v3, v4, :cond_a

    invoke-direct {p0, p1, p2}, Landroid/animation/LayoutTransition;->runDisappearingTransition(Landroid/view/ViewGroup;Landroid/view/View;)V

    goto :goto_a
.end method

.method private runAppearingTransition(Landroid/view/ViewGroup;Landroid/view/View;)V
    .registers 11
    .parameter "parent"
    .parameter "child"

    .prologue
    iget-object v5, p0, Landroid/animation/LayoutTransition;->currentDisappearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v5, p2}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/animation/Animator;

    .local v1, currentAnimation:Landroid/animation/Animator;
    if-eqz v1, :cond_d

    invoke-virtual {v1}, Landroid/animation/Animator;->cancel()V

    :cond_d
    iget-object v5, p0, Landroid/animation/LayoutTransition;->mAppearingAnim:Landroid/animation/Animator;

    if-nez v5, :cond_34

    invoke-direct {p0}, Landroid/animation/LayoutTransition;->hasListeners()Z

    move-result v5

    if-eqz v5, :cond_63

    iget-object v5, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/ArrayList;

    .local v4, listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/LayoutTransition$TransitionListener;>;"
    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :goto_23
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_63

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/animation/LayoutTransition$TransitionListener;

    .local v3, listener:Landroid/animation/LayoutTransition$TransitionListener;
    const/4 v5, 0x2

    invoke-interface {v3, p0, p1, p2, v5}, Landroid/animation/LayoutTransition$TransitionListener;->endTransition(Landroid/animation/LayoutTransition;Landroid/view/ViewGroup;Landroid/view/View;I)V

    goto :goto_23

    .end local v2           #i$:Ljava/util/Iterator;
    .end local v3           #listener:Landroid/animation/LayoutTransition$TransitionListener;
    .end local v4           #listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/LayoutTransition$TransitionListener;>;"
    :cond_34
    iget-object v5, p0, Landroid/animation/LayoutTransition;->mAppearingAnim:Landroid/animation/Animator;

    invoke-virtual {v5}, Landroid/animation/Animator;->clone()Landroid/animation/Animator;

    move-result-object v0

    .local v0, anim:Landroid/animation/Animator;
    invoke-virtual {v0, p2}, Landroid/animation/Animator;->setTarget(Ljava/lang/Object;)V

    iget-wide v5, p0, Landroid/animation/LayoutTransition;->mAppearingDelay:J

    invoke-virtual {v0, v5, v6}, Landroid/animation/Animator;->setStartDelay(J)V

    iget-wide v5, p0, Landroid/animation/LayoutTransition;->mAppearingDuration:J

    invoke-virtual {v0, v5, v6}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    instance-of v5, v0, Landroid/animation/ObjectAnimator;

    if-eqz v5, :cond_53

    move-object v5, v0

    check-cast v5, Landroid/animation/ObjectAnimator;

    const-wide/16 v6, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/animation/ObjectAnimator;->setCurrentPlayTime(J)V

    :cond_53
    new-instance v5, Landroid/animation/LayoutTransition$5;

    invoke-direct {v5, p0, p2, p1}, Landroid/animation/LayoutTransition$5;-><init>(Landroid/animation/LayoutTransition;Landroid/view/View;Landroid/view/ViewGroup;)V

    invoke-virtual {v0, v5}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    iget-object v5, p0, Landroid/animation/LayoutTransition;->currentAppearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v5, p2, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    .end local v0           #anim:Landroid/animation/Animator;
    :cond_63
    return-void
.end method

.method private runChangeTransition(Landroid/view/ViewGroup;Landroid/view/View;I)V
    .registers 24
    .parameter "parent"
    .parameter "newView"
    .parameter "changeReason"

    .prologue
    const/4 v5, 0x0

    .local v5, baseAnimator:Landroid/animation/Animator;
    const/4 v12, 0x0

    .local v12, parentAnimator:Landroid/animation/Animator;
    packed-switch p3, :pswitch_data_96

    const-wide/16 v6, 0x0

    .local v6, duration:J
    :goto_7
    if-nez v5, :cond_2b

    :cond_9
    :goto_9
    return-void

    .end local v6           #duration:J
    :pswitch_a
    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/animation/LayoutTransition;->mChangingAppearingAnim:Landroid/animation/Animator;

    move-object/from16 v0, p0

    iget-wide v6, v0, Landroid/animation/LayoutTransition;->mChangingAppearingDuration:J

    .restart local v6       #duration:J
    sget-object v12, Landroid/animation/LayoutTransition;->defaultChangeIn:Landroid/animation/ObjectAnimator;

    goto :goto_7

    .end local v6           #duration:J
    :pswitch_15
    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/animation/LayoutTransition;->mChangingDisappearingAnim:Landroid/animation/Animator;

    move-object/from16 v0, p0

    iget-wide v6, v0, Landroid/animation/LayoutTransition;->mChangingDisappearingDuration:J

    .restart local v6       #duration:J
    sget-object v12, Landroid/animation/LayoutTransition;->defaultChangeOut:Landroid/animation/ObjectAnimator;

    goto :goto_7

    .end local v6           #duration:J
    :pswitch_20
    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/animation/LayoutTransition;->mChangingAnim:Landroid/animation/Animator;

    move-object/from16 v0, p0

    iget-wide v6, v0, Landroid/animation/LayoutTransition;->mChangingDuration:J

    .restart local v6       #duration:J
    sget-object v12, Landroid/animation/LayoutTransition;->defaultChange:Landroid/animation/ObjectAnimator;

    goto :goto_7

    :cond_2b
    const-wide/16 v2, 0x0

    move-object/from16 v0, p0

    iput-wide v2, v0, Landroid/animation/LayoutTransition;->staggerDelay:J

    invoke-virtual/range {p1 .. p1}, Landroid/view/ViewGroup;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v18

    .local v18, observer:Landroid/view/ViewTreeObserver;
    invoke-virtual/range {v18 .. v18}, Landroid/view/ViewTreeObserver;->isAlive()Z

    move-result v2

    if-eqz v2, :cond_9

    invoke-virtual/range {p1 .. p1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v17

    .local v17, numChildren:I
    const/16 v16, 0x0

    .local v16, i:I
    :goto_41
    move/from16 v0, v16

    move/from16 v1, v17

    if-ge v0, v1, :cond_5f

    move-object/from16 v0, p1

    move/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v8

    .local v8, child:Landroid/view/View;
    move-object/from16 v0, p2

    if-eq v8, v0, :cond_5c

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move/from16 v4, p3

    invoke-direct/range {v2 .. v8}, Landroid/animation/LayoutTransition;->setupChangeAnimation(Landroid/view/ViewGroup;ILandroid/animation/Animator;JLandroid/view/View;)V

    :cond_5c
    add-int/lit8 v16, v16, 0x1

    goto :goto_41

    .end local v8           #child:Landroid/view/View;
    :cond_5f
    move-object/from16 v0, p0

    iget-boolean v2, v0, Landroid/animation/LayoutTransition;->mAnimateParentHierarchy:Z

    if-eqz v2, :cond_86

    move-object/from16 v15, p1

    .local v15, tempParent:Landroid/view/ViewGroup;
    :goto_67
    if-eqz v15, :cond_86

    invoke-virtual {v15}, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v19

    .local v19, parentParent:Landroid/view/ViewParent;
    move-object/from16 v0, v19

    instance-of v2, v0, Landroid/view/ViewGroup;

    if-eqz v2, :cond_84

    move-object/from16 v10, v19

    check-cast v10, Landroid/view/ViewGroup;

    move-object/from16 v9, p0

    move/from16 v11, p3

    move-wide v13, v6

    invoke-direct/range {v9 .. v15}, Landroid/animation/LayoutTransition;->setupChangeAnimation(Landroid/view/ViewGroup;ILandroid/animation/Animator;JLandroid/view/View;)V

    move-object/from16 v15, v19

    check-cast v15, Landroid/view/ViewGroup;

    goto :goto_67

    :cond_84
    const/4 v15, 0x0

    goto :goto_67

    .end local v15           #tempParent:Landroid/view/ViewGroup;
    .end local v19           #parentParent:Landroid/view/ViewParent;
    :cond_86
    new-instance v2, Landroid/animation/LayoutTransition$1;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v2, v0, v1}, Landroid/animation/LayoutTransition$1;-><init>(Landroid/animation/LayoutTransition;Landroid/view/ViewGroup;)V

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Landroid/view/ViewTreeObserver;->addOnPreDrawListener(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V

    goto/16 :goto_9

    :pswitch_data_96
    .packed-switch 0x2
        :pswitch_a
        :pswitch_15
        :pswitch_20
    .end packed-switch
.end method

.method private runDisappearingTransition(Landroid/view/ViewGroup;Landroid/view/View;)V
    .registers 12
    .parameter "parent"
    .parameter "child"

    .prologue
    iget-object v6, p0, Landroid/animation/LayoutTransition;->currentAppearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v6, p2}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/animation/Animator;

    .local v1, currentAnimation:Landroid/animation/Animator;
    if-eqz v1, :cond_d

    invoke-virtual {v1}, Landroid/animation/Animator;->cancel()V

    :cond_d
    iget-object v6, p0, Landroid/animation/LayoutTransition;->mDisappearingAnim:Landroid/animation/Animator;

    if-nez v6, :cond_34

    invoke-direct {p0}, Landroid/animation/LayoutTransition;->hasListeners()Z

    move-result v6

    if-eqz v6, :cond_67

    iget-object v6, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->clone()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/ArrayList;

    .local v4, listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/LayoutTransition$TransitionListener;>;"
    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :goto_23
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_67

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/animation/LayoutTransition$TransitionListener;

    .local v3, listener:Landroid/animation/LayoutTransition$TransitionListener;
    const/4 v6, 0x3

    invoke-interface {v3, p0, p1, p2, v6}, Landroid/animation/LayoutTransition$TransitionListener;->endTransition(Landroid/animation/LayoutTransition;Landroid/view/ViewGroup;Landroid/view/View;I)V

    goto :goto_23

    .end local v2           #i$:Ljava/util/Iterator;
    .end local v3           #listener:Landroid/animation/LayoutTransition$TransitionListener;
    .end local v4           #listeners:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/animation/LayoutTransition$TransitionListener;>;"
    :cond_34
    iget-object v6, p0, Landroid/animation/LayoutTransition;->mDisappearingAnim:Landroid/animation/Animator;

    invoke-virtual {v6}, Landroid/animation/Animator;->clone()Landroid/animation/Animator;

    move-result-object v0

    .local v0, anim:Landroid/animation/Animator;
    iget-wide v6, p0, Landroid/animation/LayoutTransition;->mDisappearingDelay:J

    invoke-virtual {v0, v6, v7}, Landroid/animation/Animator;->setStartDelay(J)V

    iget-wide v6, p0, Landroid/animation/LayoutTransition;->mDisappearingDuration:J

    invoke-virtual {v0, v6, v7}, Landroid/animation/Animator;->setDuration(J)Landroid/animation/Animator;

    invoke-virtual {v0, p2}, Landroid/animation/Animator;->setTarget(Ljava/lang/Object;)V

    invoke-virtual {p2}, Landroid/view/View;->getAlpha()F

    move-result v5

    .local v5, preAnimAlpha:F
    new-instance v6, Landroid/animation/LayoutTransition$6;

    invoke-direct {v6, p0, p2, v5, p1}, Landroid/animation/LayoutTransition$6;-><init>(Landroid/animation/LayoutTransition;Landroid/view/View;FLandroid/view/ViewGroup;)V

    invoke-virtual {v0, v6}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    instance-of v6, v0, Landroid/animation/ObjectAnimator;

    if-eqz v6, :cond_5f

    move-object v6, v0

    check-cast v6, Landroid/animation/ObjectAnimator;

    const-wide/16 v7, 0x0

    invoke-virtual {v6, v7, v8}, Landroid/animation/ObjectAnimator;->setCurrentPlayTime(J)V

    :cond_5f
    iget-object v6, p0, Landroid/animation/LayoutTransition;->currentDisappearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v6, p2, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    .end local v0           #anim:Landroid/animation/Animator;
    .end local v5           #preAnimAlpha:F
    :cond_67
    return-void
.end method

.method private setupChangeAnimation(Landroid/view/ViewGroup;ILandroid/animation/Animator;JLandroid/view/View;)V
    .registers 19
    .parameter "parent"
    .parameter "changeReason"
    .parameter "baseAnimator"
    .parameter "duration"
    .parameter "child"

    .prologue
    iget-object v2, p0, Landroid/animation/LayoutTransition;->layoutChangeListenerMap:Ljava/util/HashMap;

    move-object/from16 v0, p6

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_b

    :cond_a
    :goto_a
    return-void

    :cond_b
    invoke-virtual/range {p6 .. p6}, Landroid/view/View;->getWidth()I

    move-result v2

    if-nez v2, :cond_17

    invoke-virtual/range {p6 .. p6}, Landroid/view/View;->getHeight()I

    move-result v2

    if-eqz v2, :cond_a

    :cond_17
    invoke-virtual {p3}, Landroid/animation/Animator;->clone()Landroid/animation/Animator;

    move-result-object v3

    .local v3, anim:Landroid/animation/Animator;
    move-object/from16 v0, p6

    invoke-virtual {v3, v0}, Landroid/animation/Animator;->setTarget(Ljava/lang/Object;)V

    invoke-virtual {v3}, Landroid/animation/Animator;->setupStartValues()V

    iget-object v2, p0, Landroid/animation/LayoutTransition;->pendingAnimations:Ljava/util/HashMap;

    move-object/from16 v0, p6

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/animation/Animator;

    .local v10, currentAnimation:Landroid/animation/Animator;
    if-eqz v10, :cond_39

    invoke-virtual {v10}, Landroid/animation/Animator;->cancel()V

    iget-object v2, p0, Landroid/animation/LayoutTransition;->pendingAnimations:Ljava/util/HashMap;

    move-object/from16 v0, p6

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_39
    iget-object v2, p0, Landroid/animation/LayoutTransition;->pendingAnimations:Ljava/util/HashMap;

    move-object/from16 v0, p6

    invoke-virtual {v2, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v2, 0x2

    new-array v2, v2, [F

    fill-array-data v2, :array_86

    invoke-static {v2}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    move-result-object v2

    const-wide/16 v4, 0x64

    add-long v4, v4, p4

    invoke-virtual {v2, v4, v5}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    move-result-object v11

    .local v11, pendingAnimRemover:Landroid/animation/ValueAnimator;
    new-instance v2, Landroid/animation/LayoutTransition$2;

    move-object/from16 v0, p6

    invoke-direct {v2, p0, v0}, Landroid/animation/LayoutTransition$2;-><init>(Landroid/animation/LayoutTransition;Landroid/view/View;)V

    invoke-virtual {v11, v2}, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    invoke-virtual {v11}, Landroid/animation/ValueAnimator;->start()V

    new-instance v1, Landroid/animation/LayoutTransition$3;

    move-object v2, p0

    move v4, p2

    move-wide/from16 v5, p4

    move-object/from16 v7, p6

    move-object v8, p1

    invoke-direct/range {v1 .. v8}, Landroid/animation/LayoutTransition$3;-><init>(Landroid/animation/LayoutTransition;Landroid/animation/Animator;IJLandroid/view/View;Landroid/view/ViewGroup;)V

    .local v1, listener:Landroid/view/View$OnLayoutChangeListener;
    new-instance v4, Landroid/animation/LayoutTransition$4;

    move-object v5, p0

    move-object v6, p1

    move-object/from16 v7, p6

    move v8, p2

    move-object v9, v1

    invoke-direct/range {v4 .. v9}, Landroid/animation/LayoutTransition$4;-><init>(Landroid/animation/LayoutTransition;Landroid/view/ViewGroup;Landroid/view/View;ILandroid/view/View$OnLayoutChangeListener;)V

    invoke-virtual {v3, v4}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    move-object/from16 v0, p6

    invoke-virtual {v0, v1}, Landroid/view/View;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    iget-object v2, p0, Landroid/animation/LayoutTransition;->layoutChangeListenerMap:Ljava/util/HashMap;

    move-object/from16 v0, p6

    invoke-virtual {v2, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_a

    :array_86
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x80t 0x3ft
    .end array-data
.end method


# virtual methods
.method public addChild(Landroid/view/ViewGroup;Landroid/view/View;)V
    .registers 4
    .parameter "parent"
    .parameter "child"

    .prologue
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Landroid/animation/LayoutTransition;->addChild(Landroid/view/ViewGroup;Landroid/view/View;Z)V

    return-void
.end method

.method public addTransitionListener(Landroid/animation/LayoutTransition$TransitionListener;)V
    .registers 3
    .parameter "listener"

    .prologue
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    if-nez v0, :cond_b

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    :cond_b
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public cancel()V
    .registers 5

    .prologue
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->size()I

    move-result v3

    if-lez v3, :cond_2d

    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/LinkedHashMap;

    .local v1, currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :goto_18
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_28

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Animator;

    .local v0, anim:Landroid/animation/Animator;
    invoke-virtual {v0}, Landroid/animation/Animator;->cancel()V

    goto :goto_18

    .end local v0           #anim:Landroid/animation/Animator;
    :cond_28
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clear()V

    .end local v1           #currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    .end local v2           #i$:Ljava/util/Iterator;
    :cond_2d
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentAppearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->size()I

    move-result v3

    if-lez v3, :cond_5a

    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentAppearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/LinkedHashMap;

    .restart local v1       #currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .restart local v2       #i$:Ljava/util/Iterator;
    :goto_45
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_55

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Animator;

    .restart local v0       #anim:Landroid/animation/Animator;
    invoke-virtual {v0}, Landroid/animation/Animator;->end()V

    goto :goto_45

    .end local v0           #anim:Landroid/animation/Animator;
    :cond_55
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentAppearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clear()V

    .end local v1           #currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    .end local v2           #i$:Ljava/util/Iterator;
    :cond_5a
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentDisappearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->size()I

    move-result v3

    if-lez v3, :cond_87

    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentDisappearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/LinkedHashMap;

    .restart local v1       #currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .restart local v2       #i$:Ljava/util/Iterator;
    :goto_72
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_82

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Animator;

    .restart local v0       #anim:Landroid/animation/Animator;
    invoke-virtual {v0}, Landroid/animation/Animator;->end()V

    goto :goto_72

    .end local v0           #anim:Landroid/animation/Animator;
    :cond_82
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentDisappearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clear()V

    .end local v1           #currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    .end local v2           #i$:Ljava/util/Iterator;
    :cond_87
    return-void
.end method

.method public cancel(I)V
    .registers 6
    .parameter "transitionType"

    .prologue
    packed-switch p1, :pswitch_data_90

    :cond_3
    :goto_3
    return-void

    :pswitch_4
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->size()I

    move-result v3

    if-lez v3, :cond_3

    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/LinkedHashMap;

    .local v1, currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :goto_1c
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2c

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Animator;

    .local v0, anim:Landroid/animation/Animator;
    invoke-virtual {v0}, Landroid/animation/Animator;->cancel()V

    goto :goto_1c

    .end local v0           #anim:Landroid/animation/Animator;
    :cond_2c
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clear()V

    goto :goto_3

    .end local v1           #currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    .end local v2           #i$:Ljava/util/Iterator;
    :pswitch_32
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentAppearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->size()I

    move-result v3

    if-lez v3, :cond_3

    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentAppearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/LinkedHashMap;

    .restart local v1       #currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .restart local v2       #i$:Ljava/util/Iterator;
    :goto_4a
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_5a

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Animator;

    .restart local v0       #anim:Landroid/animation/Animator;
    invoke-virtual {v0}, Landroid/animation/Animator;->end()V

    goto :goto_4a

    .end local v0           #anim:Landroid/animation/Animator;
    :cond_5a
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentAppearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clear()V

    goto :goto_3

    .end local v1           #currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    .end local v2           #i$:Ljava/util/Iterator;
    :pswitch_60
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentDisappearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->size()I

    move-result v3

    if-lez v3, :cond_3

    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentDisappearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/LinkedHashMap;

    .restart local v1       #currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .restart local v2       #i$:Ljava/util/Iterator;
    :goto_78
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_88

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Animator;

    .restart local v0       #anim:Landroid/animation/Animator;
    invoke-virtual {v0}, Landroid/animation/Animator;->end()V

    goto :goto_78

    .end local v0           #anim:Landroid/animation/Animator;
    :cond_88
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentDisappearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clear()V

    goto/16 :goto_3

    nop

    :pswitch_data_90
    .packed-switch 0x0
        :pswitch_4
        :pswitch_4
        :pswitch_32
        :pswitch_60
        :pswitch_4
    .end packed-switch
.end method

.method public disableTransitionType(I)V
    .registers 3
    .parameter "transitionType"

    .prologue
    packed-switch p1, :pswitch_data_28

    :goto_3
    return-void

    :pswitch_4
    iget v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v0, v0, -0x2

    iput v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    goto :goto_3

    :pswitch_b
    iget v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    goto :goto_3

    :pswitch_12
    iget v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v0, v0, -0x5

    iput v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    goto :goto_3

    :pswitch_19
    iget v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v0, v0, -0x9

    iput v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    goto :goto_3

    :pswitch_20
    iget v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v0, v0, -0x11

    iput v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    goto :goto_3

    nop

    :pswitch_data_28
    .packed-switch 0x0
        :pswitch_12
        :pswitch_19
        :pswitch_4
        :pswitch_b
        :pswitch_20
    .end packed-switch
.end method

.method public enableTransitionType(I)V
    .registers 3
    .parameter "transitionType"

    .prologue
    packed-switch p1, :pswitch_data_28

    :goto_3
    return-void

    :pswitch_4
    iget v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    goto :goto_3

    :pswitch_b
    iget v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    goto :goto_3

    :pswitch_12
    iget v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    goto :goto_3

    :pswitch_19
    iget v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    or-int/lit8 v0, v0, 0x8

    iput v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    goto :goto_3

    :pswitch_20
    iget v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    or-int/lit8 v0, v0, 0x10

    iput v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    goto :goto_3

    nop

    :pswitch_data_28
    .packed-switch 0x0
        :pswitch_12
        :pswitch_19
        :pswitch_4
        :pswitch_b
        :pswitch_20
    .end packed-switch
.end method

.method public endChangingAnimations()V
    .registers 5

    .prologue
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/LinkedHashMap;

    .local v1, currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :goto_10
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_23

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Animator;

    .local v0, anim:Landroid/animation/Animator;
    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    invoke-virtual {v0}, Landroid/animation/Animator;->end()V

    goto :goto_10

    .end local v0           #anim:Landroid/animation/Animator;
    :cond_23
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clear()V

    return-void
.end method

.method public getAnimator(I)Landroid/animation/Animator;
    .registers 3
    .parameter "transitionType"

    .prologue
    packed-switch p1, :pswitch_data_14

    const/4 v0, 0x0

    :goto_4
    return-object v0

    :pswitch_5
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mChangingAppearingAnim:Landroid/animation/Animator;

    goto :goto_4

    :pswitch_8
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingAnim:Landroid/animation/Animator;

    goto :goto_4

    :pswitch_b
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mChangingAnim:Landroid/animation/Animator;

    goto :goto_4

    :pswitch_e
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mAppearingAnim:Landroid/animation/Animator;

    goto :goto_4

    :pswitch_11
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mDisappearingAnim:Landroid/animation/Animator;

    goto :goto_4

    :pswitch_data_14
    .packed-switch 0x0
        :pswitch_5
        :pswitch_8
        :pswitch_e
        :pswitch_11
        :pswitch_b
    .end packed-switch
.end method

.method public getDuration(I)J
    .registers 4
    .parameter "transitionType"

    .prologue
    packed-switch p1, :pswitch_data_16

    const-wide/16 v0, 0x0

    :goto_5
    return-wide v0

    :pswitch_6
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingAppearingDuration:J

    goto :goto_5

    :pswitch_9
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingDuration:J

    goto :goto_5

    :pswitch_c
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingDuration:J

    goto :goto_5

    :pswitch_f
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mAppearingDuration:J

    goto :goto_5

    :pswitch_12
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mDisappearingDuration:J

    goto :goto_5

    nop

    :pswitch_data_16
    .packed-switch 0x0
        :pswitch_6
        :pswitch_9
        :pswitch_f
        :pswitch_12
        :pswitch_c
    .end packed-switch
.end method

.method public getInterpolator(I)Landroid/animation/TimeInterpolator;
    .registers 3
    .parameter "transitionType"

    .prologue
    packed-switch p1, :pswitch_data_14

    const/4 v0, 0x0

    :goto_4
    return-object v0

    :pswitch_5
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mChangingAppearingInterpolator:Landroid/animation/TimeInterpolator;

    goto :goto_4

    :pswitch_8
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingInterpolator:Landroid/animation/TimeInterpolator;

    goto :goto_4

    :pswitch_b
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mChangingInterpolator:Landroid/animation/TimeInterpolator;

    goto :goto_4

    :pswitch_e
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mAppearingInterpolator:Landroid/animation/TimeInterpolator;

    goto :goto_4

    :pswitch_11
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mDisappearingInterpolator:Landroid/animation/TimeInterpolator;

    goto :goto_4

    :pswitch_data_14
    .packed-switch 0x0
        :pswitch_5
        :pswitch_8
        :pswitch_e
        :pswitch_11
        :pswitch_b
    .end packed-switch
.end method

.method public getStagger(I)J
    .registers 4
    .parameter "transitionType"

    .prologue
    packed-switch p1, :pswitch_data_10

    :pswitch_3
    const-wide/16 v0, 0x0

    :goto_5
    return-wide v0

    :pswitch_6
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingAppearingStagger:J

    goto :goto_5

    :pswitch_9
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingStagger:J

    goto :goto_5

    :pswitch_c
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingStagger:J

    goto :goto_5

    nop

    :pswitch_data_10
    .packed-switch 0x0
        :pswitch_6
        :pswitch_9
        :pswitch_3
        :pswitch_3
        :pswitch_c
    .end packed-switch
.end method

.method public getStartDelay(I)J
    .registers 4
    .parameter "transitionType"

    .prologue
    packed-switch p1, :pswitch_data_16

    const-wide/16 v0, 0x0

    :goto_5
    return-wide v0

    :pswitch_6
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingAppearingDelay:J

    goto :goto_5

    :pswitch_9
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingDelay:J

    goto :goto_5

    :pswitch_c
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mChangingDelay:J

    goto :goto_5

    :pswitch_f
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mAppearingDelay:J

    goto :goto_5

    :pswitch_12
    iget-wide v0, p0, Landroid/animation/LayoutTransition;->mDisappearingDelay:J

    goto :goto_5

    nop

    :pswitch_data_16
    .packed-switch 0x0
        :pswitch_6
        :pswitch_9
        :pswitch_f
        :pswitch_12
        :pswitch_c
    .end packed-switch
.end method

.method public getTransitionListeners()Ljava/util/List;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/animation/LayoutTransition$TransitionListener;",
            ">;"
        }
    .end annotation

    .prologue
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    return-object v0
.end method

.method public hideChild(Landroid/view/ViewGroup;Landroid/view/View;)V
    .registers 4
    .parameter "parent"
    .parameter "child"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Landroid/animation/LayoutTransition;->removeChild(Landroid/view/ViewGroup;Landroid/view/View;Z)V

    return-void
.end method

.method public hideChild(Landroid/view/ViewGroup;Landroid/view/View;I)V
    .registers 5
    .parameter "parent"
    .parameter "child"
    .parameter "newVisibility"

    .prologue
    const/16 v0, 0x8

    if-ne p3, v0, :cond_9

    const/4 v0, 0x1

    :goto_5
    invoke-direct {p0, p1, p2, v0}, Landroid/animation/LayoutTransition;->removeChild(Landroid/view/ViewGroup;Landroid/view/View;Z)V

    return-void

    :cond_9
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public isChangingLayout()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v0}, Ljava/util/LinkedHashMap;->size()I

    move-result v0

    if-lez v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public isRunning()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v0}, Ljava/util/LinkedHashMap;->size()I

    move-result v0

    if-gtz v0, :cond_18

    iget-object v0, p0, Landroid/animation/LayoutTransition;->currentAppearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v0}, Ljava/util/LinkedHashMap;->size()I

    move-result v0

    if-gtz v0, :cond_18

    iget-object v0, p0, Landroid/animation/LayoutTransition;->currentDisappearingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v0}, Ljava/util/LinkedHashMap;->size()I

    move-result v0

    if-lez v0, :cond_1a

    :cond_18
    const/4 v0, 0x1

    :goto_19
    return v0

    :cond_1a
    const/4 v0, 0x0

    goto :goto_19
.end method

.method public isTransitionTypeEnabled(I)Z
    .registers 6
    .parameter "transitionType"

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    packed-switch p1, :pswitch_data_36

    move v0, v1

    :cond_6
    :goto_6
    return v0

    :pswitch_7
    iget v2, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v2, v2, 0x1

    if-eq v2, v0, :cond_6

    move v0, v1

    goto :goto_6

    :pswitch_f
    iget v2, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v2, v2, 0x2

    const/4 v3, 0x2

    if-eq v2, v3, :cond_6

    move v0, v1

    goto :goto_6

    :pswitch_18
    iget v2, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v2, v2, 0x4

    const/4 v3, 0x4

    if-eq v2, v3, :cond_6

    move v0, v1

    goto :goto_6

    :pswitch_21
    iget v2, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v2, v2, 0x8

    const/16 v3, 0x8

    if-eq v2, v3, :cond_6

    move v0, v1

    goto :goto_6

    :pswitch_2b
    iget v2, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v2, v2, 0x10

    const/16 v3, 0x10

    if-eq v2, v3, :cond_6

    move v0, v1

    goto :goto_6

    nop

    :pswitch_data_36
    .packed-switch 0x0
        :pswitch_18
        :pswitch_21
        :pswitch_7
        :pswitch_f
        :pswitch_2b
    .end packed-switch
.end method

.method public layoutChange(Landroid/view/ViewGroup;)V
    .registers 4
    .parameter "parent"

    .prologue
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getWindowVisibility()I

    move-result v0

    if-eqz v0, :cond_7

    :cond_6
    :goto_6
    return-void

    :cond_7
    iget v0, p0, Landroid/animation/LayoutTransition;->mTransitionTypes:I

    and-int/lit8 v0, v0, 0x10

    const/16 v1, 0x10

    if-ne v0, v1, :cond_6

    invoke-virtual {p0}, Landroid/animation/LayoutTransition;->isRunning()Z

    move-result v0

    if-nez v0, :cond_6

    const/4 v0, 0x0

    const/4 v1, 0x4

    invoke-direct {p0, p1, v0, v1}, Landroid/animation/LayoutTransition;->runChangeTransition(Landroid/view/ViewGroup;Landroid/view/View;I)V

    goto :goto_6
.end method

.method public removeChild(Landroid/view/ViewGroup;Landroid/view/View;)V
    .registers 4
    .parameter "parent"
    .parameter "child"

    .prologue
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Landroid/animation/LayoutTransition;->removeChild(Landroid/view/ViewGroup;Landroid/view/View;Z)V

    return-void
.end method

.method public removeTransitionListener(Landroid/animation/LayoutTransition$TransitionListener;)V
    .registers 3
    .parameter "listener"

    .prologue
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    if-nez v0, :cond_5

    :goto_4
    return-void

    :cond_5
    iget-object v0, p0, Landroid/animation/LayoutTransition;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_4
.end method

.method public setAnimateParentHierarchy(Z)V
    .registers 2
    .parameter "animateParentHierarchy"

    .prologue
    iput-boolean p1, p0, Landroid/animation/LayoutTransition;->mAnimateParentHierarchy:Z

    return-void
.end method

.method public setAnimator(ILandroid/animation/Animator;)V
    .registers 3
    .parameter "transitionType"
    .parameter "animator"

    .prologue
    packed-switch p1, :pswitch_data_14

    :goto_3
    return-void

    :pswitch_4
    iput-object p2, p0, Landroid/animation/LayoutTransition;->mChangingAppearingAnim:Landroid/animation/Animator;

    goto :goto_3

    :pswitch_7
    iput-object p2, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingAnim:Landroid/animation/Animator;

    goto :goto_3

    :pswitch_a
    iput-object p2, p0, Landroid/animation/LayoutTransition;->mChangingAnim:Landroid/animation/Animator;

    goto :goto_3

    :pswitch_d
    iput-object p2, p0, Landroid/animation/LayoutTransition;->mAppearingAnim:Landroid/animation/Animator;

    goto :goto_3

    :pswitch_10
    iput-object p2, p0, Landroid/animation/LayoutTransition;->mDisappearingAnim:Landroid/animation/Animator;

    goto :goto_3

    nop

    :pswitch_data_14
    .packed-switch 0x0
        :pswitch_4
        :pswitch_7
        :pswitch_d
        :pswitch_10
        :pswitch_a
    .end packed-switch
.end method

.method public setDuration(IJ)V
    .registers 4
    .parameter "transitionType"
    .parameter "duration"

    .prologue
    packed-switch p1, :pswitch_data_14

    :goto_3
    return-void

    :pswitch_4
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mChangingAppearingDuration:J

    goto :goto_3

    :pswitch_7
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingDuration:J

    goto :goto_3

    :pswitch_a
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mChangingDuration:J

    goto :goto_3

    :pswitch_d
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mAppearingDuration:J

    goto :goto_3

    :pswitch_10
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mDisappearingDuration:J

    goto :goto_3

    nop

    :pswitch_data_14
    .packed-switch 0x0
        :pswitch_4
        :pswitch_7
        :pswitch_d
        :pswitch_10
        :pswitch_a
    .end packed-switch
.end method

.method public setDuration(J)V
    .registers 3
    .parameter "duration"

    .prologue
    iput-wide p1, p0, Landroid/animation/LayoutTransition;->mChangingAppearingDuration:J

    iput-wide p1, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingDuration:J

    iput-wide p1, p0, Landroid/animation/LayoutTransition;->mChangingDuration:J

    iput-wide p1, p0, Landroid/animation/LayoutTransition;->mAppearingDuration:J

    iput-wide p1, p0, Landroid/animation/LayoutTransition;->mDisappearingDuration:J

    return-void
.end method

.method public setInterpolator(ILandroid/animation/TimeInterpolator;)V
    .registers 3
    .parameter "transitionType"
    .parameter "interpolator"

    .prologue
    packed-switch p1, :pswitch_data_14

    :goto_3
    return-void

    :pswitch_4
    iput-object p2, p0, Landroid/animation/LayoutTransition;->mChangingAppearingInterpolator:Landroid/animation/TimeInterpolator;

    goto :goto_3

    :pswitch_7
    iput-object p2, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingInterpolator:Landroid/animation/TimeInterpolator;

    goto :goto_3

    :pswitch_a
    iput-object p2, p0, Landroid/animation/LayoutTransition;->mChangingInterpolator:Landroid/animation/TimeInterpolator;

    goto :goto_3

    :pswitch_d
    iput-object p2, p0, Landroid/animation/LayoutTransition;->mAppearingInterpolator:Landroid/animation/TimeInterpolator;

    goto :goto_3

    :pswitch_10
    iput-object p2, p0, Landroid/animation/LayoutTransition;->mDisappearingInterpolator:Landroid/animation/TimeInterpolator;

    goto :goto_3

    nop

    :pswitch_data_14
    .packed-switch 0x0
        :pswitch_4
        :pswitch_7
        :pswitch_d
        :pswitch_10
        :pswitch_a
    .end packed-switch
.end method

.method public setStagger(IJ)V
    .registers 4
    .parameter "transitionType"
    .parameter "duration"

    .prologue
    packed-switch p1, :pswitch_data_e

    :goto_3
    :pswitch_3
    return-void

    :pswitch_4
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mChangingAppearingStagger:J

    goto :goto_3

    :pswitch_7
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingStagger:J

    goto :goto_3

    :pswitch_a
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mChangingStagger:J

    goto :goto_3

    nop

    :pswitch_data_e
    .packed-switch 0x0
        :pswitch_4
        :pswitch_7
        :pswitch_3
        :pswitch_3
        :pswitch_a
    .end packed-switch
.end method

.method public setStartDelay(IJ)V
    .registers 4
    .parameter "transitionType"
    .parameter "delay"

    .prologue
    packed-switch p1, :pswitch_data_14

    :goto_3
    return-void

    :pswitch_4
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mChangingAppearingDelay:J

    goto :goto_3

    :pswitch_7
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mChangingDisappearingDelay:J

    goto :goto_3

    :pswitch_a
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mChangingDelay:J

    goto :goto_3

    :pswitch_d
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mAppearingDelay:J

    goto :goto_3

    :pswitch_10
    iput-wide p2, p0, Landroid/animation/LayoutTransition;->mDisappearingDelay:J

    goto :goto_3

    nop

    :pswitch_data_14
    .packed-switch 0x0
        :pswitch_4
        :pswitch_7
        :pswitch_d
        :pswitch_10
        :pswitch_a
    .end packed-switch
.end method

.method public showChild(Landroid/view/ViewGroup;Landroid/view/View;)V
    .registers 4
    .parameter "parent"
    .parameter "child"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Landroid/animation/LayoutTransition;->addChild(Landroid/view/ViewGroup;Landroid/view/View;Z)V

    return-void
.end method

.method public showChild(Landroid/view/ViewGroup;Landroid/view/View;I)V
    .registers 5
    .parameter "parent"
    .parameter "child"
    .parameter "oldVisibility"

    .prologue
    const/16 v0, 0x8

    if-ne p3, v0, :cond_9

    const/4 v0, 0x1

    :goto_5
    invoke-direct {p0, p1, p2, v0}, Landroid/animation/LayoutTransition;->addChild(Landroid/view/ViewGroup;Landroid/view/View;Z)V

    return-void

    :cond_9
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public startChangingAnimations()V
    .registers 7

    .prologue
    iget-object v3, p0, Landroid/animation/LayoutTransition;->currentChangingAnimations:Ljava/util/LinkedHashMap;

    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->clone()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/LinkedHashMap;

    .local v1, currentAnimCopy:Ljava/util/LinkedHashMap;,"Ljava/util/LinkedHashMap<Landroid/view/View;Landroid/animation/Animator;>;"
    invoke-virtual {v1}, Ljava/util/LinkedHashMap;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :goto_10
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2c

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/animation/Animator;

    .local v0, anim:Landroid/animation/Animator;
    instance-of v3, v0, Landroid/animation/ObjectAnimator;

    if-eqz v3, :cond_28

    move-object v3, v0

    check-cast v3, Landroid/animation/ObjectAnimator;

    const-wide/16 v4, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/animation/ObjectAnimator;->setCurrentPlayTime(J)V

    :cond_28
    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    goto :goto_10

    .end local v0           #anim:Landroid/animation/Animator;
    :cond_2c
    return-void
.end method
