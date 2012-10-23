.class public Landroid/widget/GridLayout;
.super Landroid/view/ViewGroup;
.source "GridLayout.java"


# annotations
.annotation runtime Landroid/widget/RemoteViews$RemoteView;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/GridLayout$Alignment;,
        Landroid/widget/GridLayout$Spec;,
        Landroid/widget/GridLayout$Interval;,
        Landroid/widget/GridLayout$Bounds;,
        Landroid/widget/GridLayout$PackedMap;,
        Landroid/widget/GridLayout$Assoc;,
        Landroid/widget/GridLayout$MutableInt;,
        Landroid/widget/GridLayout$Arc;,
        Landroid/widget/GridLayout$LayoutParams;,
        Landroid/widget/GridLayout$Axis;
    }
.end annotation


# static fields
.field private static final ALIGNMENT_MODE:I = 0x6

.field public static final ALIGN_BOUNDS:I = 0x0

.field public static final ALIGN_MARGINS:I = 0x1

.field public static final BASELINE:Landroid/widget/GridLayout$Alignment; = null

.field public static final BOTTOM:Landroid/widget/GridLayout$Alignment; = null

.field private static final CAN_STRETCH:I = 0x2

.field public static final CENTER:Landroid/widget/GridLayout$Alignment; = null

.field private static final COLUMN_COUNT:I = 0x3

.field private static final COLUMN_ORDER_PRESERVED:I = 0x4

.field private static final DEFAULT_ALIGNMENT_MODE:I = 0x1

.field static final DEFAULT_CONTAINER_MARGIN:I = 0x0

.field private static final DEFAULT_COUNT:I = -0x80000000

.field private static final DEFAULT_ORDER_PRESERVED:Z = true

.field private static final DEFAULT_ORIENTATION:I = 0x0

.field private static final DEFAULT_USE_DEFAULT_MARGINS:Z = false

.field public static final END:Landroid/widget/GridLayout$Alignment; = null

.field public static final FILL:Landroid/widget/GridLayout$Alignment; = null

.field public static final HORIZONTAL:I = 0x0

.field private static final INFLEXIBLE:I = 0x0

.field private static final LEADING:Landroid/widget/GridLayout$Alignment; = null

.field public static final LEFT:Landroid/widget/GridLayout$Alignment; = null

.field static final MAX_SIZE:I = 0x186a0

.field private static final ORIENTATION:I = 0x0

.field public static final RIGHT:Landroid/widget/GridLayout$Alignment; = null

.field private static final ROW_COUNT:I = 0x1

.field private static final ROW_ORDER_PRESERVED:I = 0x2

.field public static final START:Landroid/widget/GridLayout$Alignment; = null

.field static final TAG:Ljava/lang/String; = null

.field public static final TOP:Landroid/widget/GridLayout$Alignment; = null

.field private static final TRAILING:Landroid/widget/GridLayout$Alignment; = null

.field public static final UNDEFINED:I = -0x80000000

.field static final UNDEFINED_ALIGNMENT:Landroid/widget/GridLayout$Alignment; = null

.field static final UNINITIALIZED_HASH:I = 0x0

.field private static final USE_DEFAULT_MARGINS:I = 0x5

.field public static final VERTICAL:I = 0x1


# instance fields
.field alignmentMode:I

.field defaultGap:I

.field final horizontalAxis:Landroid/widget/GridLayout$Axis;

.field lastLayoutParamsHashCode:I

.field orientation:I

.field useDefaultMargins:Z

.field final verticalAxis:Landroid/widget/GridLayout$Axis;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 211
    const-class v0, Landroid/widget/GridLayout;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroid/widget/GridLayout;->TAG:Ljava/lang/String;

    .line 2530
    new-instance v0, Landroid/widget/GridLayout$1;

    invoke-direct {v0}, Landroid/widget/GridLayout$1;-><init>()V

    sput-object v0, Landroid/widget/GridLayout;->UNDEFINED_ALIGNMENT:Landroid/widget/GridLayout$Alignment;

    .line 2546
    new-instance v0, Landroid/widget/GridLayout$2;

    invoke-direct {v0}, Landroid/widget/GridLayout$2;-><init>()V

    sput-object v0, Landroid/widget/GridLayout;->LEADING:Landroid/widget/GridLayout$Alignment;

    .line 2562
    new-instance v0, Landroid/widget/GridLayout$3;

    invoke-direct {v0}, Landroid/widget/GridLayout$3;-><init>()V

    sput-object v0, Landroid/widget/GridLayout;->TRAILING:Landroid/widget/GridLayout$Alignment;

    .line 2578
    sget-object v0, Landroid/widget/GridLayout;->LEADING:Landroid/widget/GridLayout$Alignment;

    sput-object v0, Landroid/widget/GridLayout;->TOP:Landroid/widget/GridLayout$Alignment;

    .line 2584
    sget-object v0, Landroid/widget/GridLayout;->TRAILING:Landroid/widget/GridLayout$Alignment;

    sput-object v0, Landroid/widget/GridLayout;->BOTTOM:Landroid/widget/GridLayout$Alignment;

    .line 2590
    sget-object v0, Landroid/widget/GridLayout;->LEADING:Landroid/widget/GridLayout$Alignment;

    sput-object v0, Landroid/widget/GridLayout;->START:Landroid/widget/GridLayout$Alignment;

    .line 2596
    sget-object v0, Landroid/widget/GridLayout;->TRAILING:Landroid/widget/GridLayout$Alignment;

    sput-object v0, Landroid/widget/GridLayout;->END:Landroid/widget/GridLayout$Alignment;

    .line 2616
    sget-object v0, Landroid/widget/GridLayout;->START:Landroid/widget/GridLayout$Alignment;

    sget-object v1, Landroid/widget/GridLayout;->END:Landroid/widget/GridLayout$Alignment;

    invoke-static {v0, v1}, Landroid/widget/GridLayout;->createSwitchingAlignment(Landroid/widget/GridLayout$Alignment;Landroid/widget/GridLayout$Alignment;)Landroid/widget/GridLayout$Alignment;

    move-result-object v0

    sput-object v0, Landroid/widget/GridLayout;->LEFT:Landroid/widget/GridLayout$Alignment;

    .line 2622
    sget-object v0, Landroid/widget/GridLayout;->END:Landroid/widget/GridLayout$Alignment;

    sget-object v1, Landroid/widget/GridLayout;->START:Landroid/widget/GridLayout$Alignment;

    invoke-static {v0, v1}, Landroid/widget/GridLayout;->createSwitchingAlignment(Landroid/widget/GridLayout$Alignment;Landroid/widget/GridLayout$Alignment;)Landroid/widget/GridLayout$Alignment;

    move-result-object v0

    sput-object v0, Landroid/widget/GridLayout;->RIGHT:Landroid/widget/GridLayout$Alignment;

    .line 2629
    new-instance v0, Landroid/widget/GridLayout$5;

    invoke-direct {v0}, Landroid/widget/GridLayout$5;-><init>()V

    sput-object v0, Landroid/widget/GridLayout;->CENTER:Landroid/widget/GridLayout$Alignment;

    .line 2648
    new-instance v0, Landroid/widget/GridLayout$6;

    invoke-direct {v0}, Landroid/widget/GridLayout$6;-><init>()V

    sput-object v0, Landroid/widget/GridLayout;->BASELINE:Landroid/widget/GridLayout$Alignment;

    .line 2708
    new-instance v0, Landroid/widget/GridLayout$7;

    invoke-direct {v0}, Landroid/widget/GridLayout$7;-><init>()V

    sput-object v0, Landroid/widget/GridLayout;->FILL:Landroid/widget/GridLayout$Alignment;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 278
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/widget/GridLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 279
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 270
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/GridLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 271
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 9
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 250
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 236
    new-instance v1, Landroid/widget/GridLayout$Axis;

    invoke-direct {v1, p0, v3, v4}, Landroid/widget/GridLayout$Axis;-><init>(Landroid/widget/GridLayout;ZLandroid/widget/GridLayout$1;)V

    iput-object v1, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    .line 237
    new-instance v1, Landroid/widget/GridLayout$Axis;

    invoke-direct {v1, p0, v2, v4}, Landroid/widget/GridLayout$Axis;-><init>(Landroid/widget/GridLayout;ZLandroid/widget/GridLayout$1;)V

    iput-object v1, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    .line 238
    iput v2, p0, Landroid/widget/GridLayout;->orientation:I

    .line 239
    iput-boolean v2, p0, Landroid/widget/GridLayout;->useDefaultMargins:Z

    .line 240
    iput v3, p0, Landroid/widget/GridLayout;->alignmentMode:I

    .line 242
    iput v2, p0, Landroid/widget/GridLayout;->lastLayoutParamsHashCode:I

    .line 251
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x1050045

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v1

    iput v1, p0, Landroid/widget/GridLayout;->defaultGap:I

    .line 252
    sget-object v1, Lcom/android/internal/R$styleable;->GridLayout:[I

    invoke-virtual {p1, p2, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 254
    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v1, 0x1

    const/high16 v2, -0x8000

    :try_start_32
    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    invoke-virtual {p0, v1}, Landroid/widget/GridLayout;->setRowCount(I)V

    .line 255
    const/4 v1, 0x3

    const/high16 v2, -0x8000

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    invoke-virtual {p0, v1}, Landroid/widget/GridLayout;->setColumnCount(I)V

    .line 256
    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    invoke-virtual {p0, v1}, Landroid/widget/GridLayout;->setOrientation(I)V

    .line 257
    const/4 v1, 0x5

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    invoke-virtual {p0, v1}, Landroid/widget/GridLayout;->setUseDefaultMargins(Z)V

    .line 258
    const/4 v1, 0x6

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    invoke-virtual {p0, v1}, Landroid/widget/GridLayout;->setAlignmentMode(I)V

    .line 259
    const/4 v1, 0x2

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    invoke-virtual {p0, v1}, Landroid/widget/GridLayout;->setRowOrderPreserved(Z)V

    .line 260
    const/4 v1, 0x4

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    invoke-virtual {p0, v1}, Landroid/widget/GridLayout;->setColumnOrderPreserved(Z)V
    :try_end_70
    .catchall {:try_start_32 .. :try_end_70} :catchall_74

    .line 262
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 264
    return-void

    .line 262
    :catchall_74
    move-exception v1

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    throw v1
.end method

.method static synthetic access$100(Ljava/lang/String;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 151
    invoke-static {p0}, Landroid/widget/GridLayout;->handleInvalidParams(Ljava/lang/String;)V

    return-void
.end method

.method static append([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 7
    .parameter
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;[TT;)[TT;"
        }
    .end annotation

    .prologue
    .local p0, a:[Ljava/lang/Object;,"[TT;"
    .local p1, b:[Ljava/lang/Object;,"[TT;"
    const/4 v4, 0x0

    .line 571
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v1

    array-length v2, p0

    array-length v3, p1

    add-int/2addr v2, v3

    invoke-static {v1, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/Object;

    move-object v0, v1

    check-cast v0, [Ljava/lang/Object;

    .line 572
    .local v0, result:[Ljava/lang/Object;,"[TT;"
    array-length v1, p0

    invoke-static {p0, v4, v0, v4, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 573
    array-length v1, p0

    array-length v2, p1

    invoke-static {p1, v4, v0, v1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 574
    return-object v0
.end method

.method static canStretch(I)Z
    .registers 2
    .parameter "flexibility"

    .prologue
    .line 2726
    and-int/lit8 v0, p0, 0x2

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method private checkLayoutParams(Landroid/widget/GridLayout$LayoutParams;Z)V
    .registers 11
    .parameter "lp"
    .parameter "horizontal"

    .prologue
    const/high16 v7, -0x8000

    .line 777
    if-eqz p2, :cond_7d

    const-string v2, "column"

    .line 778
    .local v2, groupName:Ljava/lang/String;
    :goto_6
    if-eqz p2, :cond_81

    iget-object v4, p1, Landroid/widget/GridLayout$LayoutParams;->columnSpec:Landroid/widget/GridLayout$Spec;

    .line 779
    .local v4, spec:Landroid/widget/GridLayout$Spec;
    :goto_a
    iget-object v3, v4, Landroid/widget/GridLayout$Spec;->span:Landroid/widget/GridLayout$Interval;

    .line 780
    .local v3, span:Landroid/widget/GridLayout$Interval;
    iget v5, v3, Landroid/widget/GridLayout$Interval;->min:I

    if-eq v5, v7, :cond_2a

    iget v5, v3, Landroid/widget/GridLayout$Interval;->min:I

    if-gez v5, :cond_2a

    .line 781
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " indices must be positive"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/widget/GridLayout;->handleInvalidParams(Ljava/lang/String;)V

    .line 783
    :cond_2a
    if-eqz p2, :cond_84

    iget-object v0, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    .line 784
    .local v0, axis:Landroid/widget/GridLayout$Axis;
    :goto_2e
    iget v1, v0, Landroid/widget/GridLayout$Axis;->definedCount:I

    .line 785
    .local v1, count:I
    if-eq v1, v7, :cond_7c

    .line 786
    iget v5, v3, Landroid/widget/GridLayout$Interval;->max:I

    if-le v5, v1, :cond_56

    .line 787
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " indices (start + span) mustn\'t exceed the "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " count"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/widget/GridLayout;->handleInvalidParams(Ljava/lang/String;)V

    .line 790
    :cond_56
    invoke-virtual {v3}, Landroid/widget/GridLayout$Interval;->size()I

    move-result v5

    if-le v5, v1, :cond_7c

    .line 791
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " span mustn\'t exceed the "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " count"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/widget/GridLayout;->handleInvalidParams(Ljava/lang/String;)V

    .line 794
    :cond_7c
    return-void

    .line 777
    .end local v0           #axis:Landroid/widget/GridLayout$Axis;
    .end local v1           #count:I
    .end local v2           #groupName:Ljava/lang/String;
    .end local v3           #span:Landroid/widget/GridLayout$Interval;
    .end local v4           #spec:Landroid/widget/GridLayout$Spec;
    :cond_7d
    const-string/jumbo v2, "row"

    goto :goto_6

    .line 778
    .restart local v2       #groupName:Ljava/lang/String;
    :cond_81
    iget-object v4, p1, Landroid/widget/GridLayout$LayoutParams;->rowSpec:Landroid/widget/GridLayout$Spec;

    goto :goto_a

    .line 783
    .restart local v3       #span:Landroid/widget/GridLayout$Interval;
    .restart local v4       #spec:Landroid/widget/GridLayout$Spec;
    :cond_84
    iget-object v0, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    goto :goto_2e
.end method

.method private static clip(Landroid/widget/GridLayout$Interval;ZI)I
    .registers 6
    .parameter "minorRange"
    .parameter "minorWasDefined"
    .parameter "count"

    .prologue
    .line 673
    invoke-virtual {p0}, Landroid/widget/GridLayout$Interval;->size()I

    move-result v1

    .line 674
    .local v1, size:I
    if-nez p2, :cond_7

    .line 678
    .end local v1           #size:I
    :goto_6
    return v1

    .line 677
    .restart local v1       #size:I
    :cond_7
    if-eqz p1, :cond_16

    iget v2, p0, Landroid/widget/GridLayout$Interval;->min:I

    invoke-static {v2, p2}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 678
    .local v0, min:I
    :goto_f
    sub-int v2, p2, v0

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v1

    goto :goto_6

    .line 677
    .end local v0           #min:I
    :cond_16
    const/4 v0, 0x0

    goto :goto_f
.end method

.method private computeLayoutParamsHashCode()I
    .registers 8

    .prologue
    .line 922
    const/4 v4, 0x1

    .line 923
    .local v4, result:I
    const/4 v2, 0x0

    .local v2, i:I
    invoke-virtual {p0}, Landroid/widget/GridLayout;->getChildCount()I

    move-result v0

    .local v0, N:I
    :goto_6
    if-ge v2, v0, :cond_26

    .line 924
    invoke-virtual {p0, v2}, Landroid/widget/GridLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 925
    .local v1, c:Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getVisibility()I

    move-result v5

    const/16 v6, 0x8

    if-ne v5, v6, :cond_17

    .line 923
    :goto_14
    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    .line 926
    :cond_17
    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Landroid/widget/GridLayout$LayoutParams;

    .line 927
    .local v3, lp:Landroid/widget/GridLayout$LayoutParams;
    mul-int/lit8 v5, v4, 0x1f

    invoke-virtual {v3}, Landroid/widget/GridLayout$LayoutParams;->hashCode()I

    move-result v6

    add-int v4, v5, v6

    goto :goto_14

    .line 929
    .end local v1           #c:Landroid/view/View;
    .end local v3           #lp:Landroid/widget/GridLayout$LayoutParams;
    :cond_26
    return v4
.end method

.method private consistencyCheck()V
    .registers 3

    .prologue
    .line 933
    iget v0, p0, Landroid/widget/GridLayout;->lastLayoutParamsHashCode:I

    if-nez v0, :cond_e

    .line 934
    invoke-direct {p0}, Landroid/widget/GridLayout;->validateLayoutParams()V

    .line 935
    invoke-direct {p0}, Landroid/widget/GridLayout;->computeLayoutParamsHashCode()I

    move-result v0

    iput v0, p0, Landroid/widget/GridLayout;->lastLayoutParamsHashCode:I

    .line 942
    :cond_d
    :goto_d
    return-void

    .line 936
    :cond_e
    iget v0, p0, Landroid/widget/GridLayout;->lastLayoutParamsHashCode:I

    invoke-direct {p0}, Landroid/widget/GridLayout;->computeLayoutParamsHashCode()I

    move-result v1

    if-eq v0, v1, :cond_d

    .line 937
    sget-object v0, Landroid/widget/GridLayout;->TAG:Ljava/lang/String;

    const-string v1, "The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 939
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateStructure()V

    .line 940
    invoke-direct {p0}, Landroid/widget/GridLayout;->consistencyCheck()V

    goto :goto_d
.end method

.method private static createSwitchingAlignment(Landroid/widget/GridLayout$Alignment;Landroid/widget/GridLayout$Alignment;)Landroid/widget/GridLayout$Alignment;
    .registers 3
    .parameter "ltr"
    .parameter "rtl"

    .prologue
    .line 2599
    new-instance v0, Landroid/widget/GridLayout$4;

    invoke-direct {v0, p0, p1}, Landroid/widget/GridLayout$4;-><init>(Landroid/widget/GridLayout$Alignment;Landroid/widget/GridLayout$Alignment;)V

    return-object v0
.end method

.method private drawLine(Landroid/graphics/Canvas;IIIILandroid/graphics/Paint;)V
    .registers 16
    .parameter "graphics"
    .parameter "x1"
    .parameter "y1"
    .parameter "x2"
    .parameter "y2"
    .parameter "paint"

    .prologue
    .line 827
    invoke-virtual {p0}, Landroid/widget/GridLayout;->getPaddingLeft()I

    move-result v6

    .line 828
    .local v6, dx:I
    invoke-virtual {p0}, Landroid/widget/GridLayout;->getPaddingTop()I

    move-result v7

    .line 829
    .local v7, dy:I
    invoke-virtual {p0}, Landroid/widget/GridLayout;->isLayoutRtl()Z

    move-result v0

    if-eqz v0, :cond_26

    .line 830
    invoke-virtual {p0}, Landroid/widget/GridLayout;->getWidth()I

    move-result v8

    .line 831
    .local v8, width:I
    sub-int v0, v8, v6

    sub-int/2addr v0, p2

    int-to-float v1, v0

    add-int v0, v7, p3

    int-to-float v2, v0

    sub-int v0, v8, v6

    sub-int/2addr v0, p4

    int-to-float v3, v0

    add-int v0, v7, p5

    int-to-float v4, v0

    move-object v0, p1

    move-object v5, p6

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 835
    .end local v8           #width:I
    :goto_25
    return-void

    .line 833
    :cond_26
    add-int v0, v6, p2

    int-to-float v1, v0

    add-int v0, v7, p3

    int-to-float v2, v0

    add-int v0, v6, p4

    int-to-float v3, v0

    add-int v0, v7, p5

    int-to-float v4, v0

    move-object v0, p1

    move-object v5, p6

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    goto :goto_25
.end method

.method private static fits([IIII)Z
    .registers 7
    .parameter "a"
    .parameter "value"
    .parameter "start"
    .parameter "end"

    .prologue
    const/4 v1, 0x0

    .line 650
    array-length v2, p0

    if-le p3, v2, :cond_5

    .line 658
    :cond_4
    :goto_4
    return v1

    .line 653
    :cond_5
    move v0, p2

    .local v0, i:I
    :goto_6
    if-ge v0, p3, :cond_f

    .line 654
    aget v2, p0, v0

    if-gt v2, p1, :cond_4

    .line 653
    add-int/lit8 v0, v0, 0x1

    goto :goto_6

    .line 658
    :cond_f
    const/4 v1, 0x1

    goto :goto_4
.end method

.method static getAlignment(IZ)Landroid/widget/GridLayout$Alignment;
    .registers 6
    .parameter "gravity"
    .parameter "horizontal"

    .prologue
    .line 578
    if-eqz p1, :cond_10

    const/4 v1, 0x7

    .line 579
    .local v1, mask:I
    :goto_3
    if-eqz p1, :cond_13

    const/4 v2, 0x0

    .line 580
    .local v2, shift:I
    :goto_6
    and-int v3, p0, v1

    shr-int v0, v3, v2

    .line 581
    .local v0, flags:I
    sparse-switch v0, :sswitch_data_32

    .line 595
    sget-object v3, Landroid/widget/GridLayout;->UNDEFINED_ALIGNMENT:Landroid/widget/GridLayout$Alignment;

    :goto_f
    return-object v3

    .line 578
    .end local v0           #flags:I
    .end local v1           #mask:I
    .end local v2           #shift:I
    :cond_10
    const/16 v1, 0x70

    goto :goto_3

    .line 579
    .restart local v1       #mask:I
    :cond_13
    const/4 v2, 0x4

    goto :goto_6

    .line 583
    .restart local v0       #flags:I
    .restart local v2       #shift:I
    :sswitch_15
    if-eqz p1, :cond_1a

    sget-object v3, Landroid/widget/GridLayout;->LEFT:Landroid/widget/GridLayout$Alignment;

    goto :goto_f

    :cond_1a
    sget-object v3, Landroid/widget/GridLayout;->TOP:Landroid/widget/GridLayout$Alignment;

    goto :goto_f

    .line 585
    :sswitch_1d
    if-eqz p1, :cond_22

    sget-object v3, Landroid/widget/GridLayout;->RIGHT:Landroid/widget/GridLayout$Alignment;

    goto :goto_f

    :cond_22
    sget-object v3, Landroid/widget/GridLayout;->BOTTOM:Landroid/widget/GridLayout$Alignment;

    goto :goto_f

    .line 587
    :sswitch_25
    sget-object v3, Landroid/widget/GridLayout;->FILL:Landroid/widget/GridLayout$Alignment;

    goto :goto_f

    .line 589
    :sswitch_28
    sget-object v3, Landroid/widget/GridLayout;->CENTER:Landroid/widget/GridLayout$Alignment;

    goto :goto_f

    .line 591
    :sswitch_2b
    sget-object v3, Landroid/widget/GridLayout;->START:Landroid/widget/GridLayout$Alignment;

    goto :goto_f

    .line 593
    :sswitch_2e
    sget-object v3, Landroid/widget/GridLayout;->END:Landroid/widget/GridLayout$Alignment;

    goto :goto_f

    .line 581
    nop

    :sswitch_data_32
    .sparse-switch
        0x1 -> :sswitch_28
        0x3 -> :sswitch_15
        0x5 -> :sswitch_1d
        0x7 -> :sswitch_25
        0x800003 -> :sswitch_2b
        0x800005 -> :sswitch_2e
    .end sparse-switch
.end method

.method private getDefaultMargin(Landroid/view/View;Landroid/widget/GridLayout$LayoutParams;ZZ)I
    .registers 13
    .parameter "c"
    .parameter "p"
    .parameter "horizontal"
    .parameter "leading"

    .prologue
    const/4 v1, 0x1

    const/4 v5, 0x0

    .line 612
    iget-boolean v6, p0, Landroid/widget/GridLayout;->useDefaultMargins:Z

    if-nez v6, :cond_7

    .line 621
    :goto_6
    return v5

    .line 615
    :cond_7
    if-eqz p3, :cond_27

    iget-object v4, p2, Landroid/widget/GridLayout$LayoutParams;->columnSpec:Landroid/widget/GridLayout$Spec;

    .line 616
    .local v4, spec:Landroid/widget/GridLayout$Spec;
    :goto_b
    if-eqz p3, :cond_2a

    iget-object v0, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    .line 617
    .local v0, axis:Landroid/widget/GridLayout$Axis;
    :goto_f
    iget-object v3, v4, Landroid/widget/GridLayout$Spec;->span:Landroid/widget/GridLayout$Interval;

    .line 618
    .local v3, span:Landroid/widget/GridLayout$Interval;
    if-eqz p3, :cond_2f

    invoke-virtual {p0}, Landroid/widget/GridLayout;->isLayoutRtl()Z

    move-result v6

    if-eqz v6, :cond_2f

    if-nez p4, :cond_2d

    move v2, v1

    .line 619
    .local v2, leading1:Z
    :goto_1c
    if-eqz v2, :cond_33

    iget v6, v3, Landroid/widget/GridLayout$Interval;->min:I

    if-nez v6, :cond_31

    .line 621
    .local v1, isAtEdge:Z
    :cond_22
    :goto_22
    invoke-direct {p0, p1, v1, p3, p4}, Landroid/widget/GridLayout;->getDefaultMargin(Landroid/view/View;ZZZ)I

    move-result v5

    goto :goto_6

    .line 615
    .end local v0           #axis:Landroid/widget/GridLayout$Axis;
    .end local v1           #isAtEdge:Z
    .end local v2           #leading1:Z
    .end local v3           #span:Landroid/widget/GridLayout$Interval;
    .end local v4           #spec:Landroid/widget/GridLayout$Spec;
    :cond_27
    iget-object v4, p2, Landroid/widget/GridLayout$LayoutParams;->rowSpec:Landroid/widget/GridLayout$Spec;

    goto :goto_b

    .line 616
    .restart local v4       #spec:Landroid/widget/GridLayout$Spec;
    :cond_2a
    iget-object v0, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    goto :goto_f

    .restart local v0       #axis:Landroid/widget/GridLayout$Axis;
    .restart local v3       #span:Landroid/widget/GridLayout$Interval;
    :cond_2d
    move v2, v5

    .line 618
    goto :goto_1c

    :cond_2f
    move v2, p4

    goto :goto_1c

    .restart local v2       #leading1:Z
    :cond_31
    move v1, v5

    .line 619
    goto :goto_22

    :cond_33
    iget v6, v3, Landroid/widget/GridLayout$Interval;->max:I

    invoke-virtual {v0}, Landroid/widget/GridLayout$Axis;->getCount()I

    move-result v7

    if-eq v6, v7, :cond_22

    move v1, v5

    goto :goto_22
.end method

.method private getDefaultMargin(Landroid/view/View;ZZ)I
    .registers 6
    .parameter "c"
    .parameter "horizontal"
    .parameter "leading"

    .prologue
    .line 601
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Landroid/widget/Space;

    if-ne v0, v1, :cond_a

    .line 602
    const/4 v0, 0x0

    .line 604
    :goto_9
    return v0

    :cond_a
    iget v0, p0, Landroid/widget/GridLayout;->defaultGap:I

    div-int/lit8 v0, v0, 0x2

    goto :goto_9
.end method

.method private getDefaultMargin(Landroid/view/View;ZZZ)I
    .registers 6
    .parameter "c"
    .parameter "isAtEdge"
    .parameter "horizontal"
    .parameter "leading"

    .prologue
    .line 608
    if-eqz p2, :cond_4

    const/4 v0, 0x0

    :goto_3
    return v0

    :cond_4
    invoke-direct {p0, p1, p3, p4}, Landroid/widget/GridLayout;->getDefaultMargin(Landroid/view/View;ZZ)I

    move-result v0

    goto :goto_3
.end method

.method private getMargin(Landroid/view/View;ZZ)I
    .registers 11
    .parameter "view"
    .parameter "horizontal"
    .parameter "leading"

    .prologue
    .line 633
    iget v5, p0, Landroid/widget/GridLayout;->alignmentMode:I

    const/4 v6, 0x1

    if-ne v5, v6, :cond_a

    .line 634
    invoke-virtual {p0, p1, p2, p3}, Landroid/widget/GridLayout;->getMargin1(Landroid/view/View;ZZ)I

    move-result v5

    .line 641
    :goto_9
    return v5

    .line 636
    :cond_a
    if-eqz p2, :cond_25

    iget-object v0, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    .line 637
    .local v0, axis:Landroid/widget/GridLayout$Axis;
    :goto_e
    if-eqz p3, :cond_28

    invoke-virtual {v0}, Landroid/widget/GridLayout$Axis;->getLeadingMargins()[I

    move-result-object v3

    .line 638
    .local v3, margins:[I
    :goto_14
    invoke-virtual {p0, p1}, Landroid/widget/GridLayout;->getLayoutParams(Landroid/view/View;)Landroid/widget/GridLayout$LayoutParams;

    move-result-object v2

    .line 639
    .local v2, lp:Landroid/widget/GridLayout$LayoutParams;
    if-eqz p2, :cond_2d

    iget-object v4, v2, Landroid/widget/GridLayout$LayoutParams;->columnSpec:Landroid/widget/GridLayout$Spec;

    .line 640
    .local v4, spec:Landroid/widget/GridLayout$Spec;
    :goto_1c
    if-eqz p3, :cond_30

    iget-object v5, v4, Landroid/widget/GridLayout$Spec;->span:Landroid/widget/GridLayout$Interval;

    iget v1, v5, Landroid/widget/GridLayout$Interval;->min:I

    .line 641
    .local v1, index:I
    :goto_22
    aget v5, v3, v1

    goto :goto_9

    .line 636
    .end local v0           #axis:Landroid/widget/GridLayout$Axis;
    .end local v1           #index:I
    .end local v2           #lp:Landroid/widget/GridLayout$LayoutParams;
    .end local v3           #margins:[I
    .end local v4           #spec:Landroid/widget/GridLayout$Spec;
    :cond_25
    iget-object v0, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    goto :goto_e

    .line 637
    .restart local v0       #axis:Landroid/widget/GridLayout$Axis;
    :cond_28
    invoke-virtual {v0}, Landroid/widget/GridLayout$Axis;->getTrailingMargins()[I

    move-result-object v3

    goto :goto_14

    .line 639
    .restart local v2       #lp:Landroid/widget/GridLayout$LayoutParams;
    .restart local v3       #margins:[I
    :cond_2d
    iget-object v4, v2, Landroid/widget/GridLayout$LayoutParams;->rowSpec:Landroid/widget/GridLayout$Spec;

    goto :goto_1c

    .line 640
    .restart local v4       #spec:Landroid/widget/GridLayout$Spec;
    :cond_30
    iget-object v5, v4, Landroid/widget/GridLayout$Spec;->span:Landroid/widget/GridLayout$Interval;

    iget v1, v5, Landroid/widget/GridLayout$Interval;->max:I

    goto :goto_22
.end method

.method private getMeasurement(Landroid/view/View;Z)I
    .registers 7
    .parameter "c"
    .parameter "horizontal"

    .prologue
    .line 1016
    if-eqz p2, :cond_1a

    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    .line 1017
    .local v1, result:I
    :goto_6
    invoke-virtual {p0}, Landroid/widget/GridLayout;->getLayoutMode()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_19

    .line 1018
    invoke-virtual {p1}, Landroid/view/View;->getOpticalInsets()Landroid/graphics/Insets;

    move-result-object v0

    .line 1019
    .local v0, insets:Landroid/graphics/Insets;
    if-eqz p2, :cond_1f

    iget v2, v0, Landroid/graphics/Insets;->left:I

    iget v3, v0, Landroid/graphics/Insets;->right:I

    add-int/2addr v2, v3

    :goto_18
    sub-int/2addr v1, v2

    .line 1021
    .end local v0           #insets:Landroid/graphics/Insets;
    .end local v1           #result:I
    :cond_19
    return v1

    .line 1016
    :cond_1a
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v1

    goto :goto_6

    .line 1019
    .restart local v0       #insets:Landroid/graphics/Insets;
    .restart local v1       #result:I
    :cond_1f
    iget v2, v0, Landroid/graphics/Insets;->top:I

    iget v3, v0, Landroid/graphics/Insets;->bottom:I

    add-int/2addr v2, v3

    goto :goto_18
.end method

.method private getTotalMargin(Landroid/view/View;Z)I
    .registers 5
    .parameter "child"
    .parameter "horizontal"

    .prologue
    .line 646
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/GridLayout;->getMargin(Landroid/view/View;ZZ)I

    move-result v0

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v1}, Landroid/widget/GridLayout;->getMargin(Landroid/view/View;ZZ)I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method private static handleInvalidParams(Ljava/lang/String;)V
    .registers 4
    .parameter "msg"

    .prologue
    .line 773
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ". "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private invalidateStructure()V
    .registers 2

    .prologue
    .line 740
    const/4 v0, 0x0

    iput v0, p0, Landroid/widget/GridLayout;->lastLayoutParamsHashCode:I

    .line 741
    iget-object v0, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v0}, Landroid/widget/GridLayout$Axis;->invalidateStructure()V

    .line 742
    iget-object v0, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v0}, Landroid/widget/GridLayout$Axis;->invalidateStructure()V

    .line 744
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateValues()V

    .line 745
    return-void
.end method

.method private invalidateValues()V
    .registers 2

    .prologue
    .line 750
    iget-object v0, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    if-eqz v0, :cond_12

    iget-object v0, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    if-eqz v0, :cond_12

    .line 751
    iget-object v0, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v0}, Landroid/widget/GridLayout$Axis;->invalidateValues()V

    .line 752
    iget-object v0, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v0}, Landroid/widget/GridLayout$Axis;->invalidateValues()V

    .line 754
    :cond_12
    return-void
.end method

.method static max2([II)I
    .registers 6
    .parameter "a"
    .parameter "valueIfEmpty"

    .prologue
    .line 562
    move v2, p1

    .line 563
    .local v2, result:I
    const/4 v1, 0x0

    .local v1, i:I
    array-length v0, p0

    .local v0, N:I
    :goto_3
    if-ge v1, v0, :cond_e

    .line 564
    aget v3, p0, v1

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 563
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 566
    :cond_e
    return v2
.end method

.method private measureChildWithMargins2(Landroid/view/View;IIII)V
    .registers 10
    .parameter "child"
    .parameter "parentWidthSpec"
    .parameter "parentHeightSpec"
    .parameter "childWidth"
    .parameter "childHeight"

    .prologue
    .line 948
    iget v2, p0, Landroid/view/View;->mPaddingLeft:I

    iget v3, p0, Landroid/view/View;->mPaddingRight:I

    add-int/2addr v2, v3

    const/4 v3, 0x1

    invoke-direct {p0, p1, v3}, Landroid/widget/GridLayout;->getTotalMargin(Landroid/view/View;Z)I

    move-result v3

    add-int/2addr v2, v3

    invoke-static {p2, v2, p4}, Landroid/widget/GridLayout;->getChildMeasureSpec(III)I

    move-result v1

    .line 950
    .local v1, childWidthSpec:I
    iget v2, p0, Landroid/view/View;->mPaddingTop:I

    iget v3, p0, Landroid/view/View;->mPaddingBottom:I

    add-int/2addr v2, v3

    const/4 v3, 0x0

    invoke-direct {p0, p1, v3}, Landroid/widget/GridLayout;->getTotalMargin(Landroid/view/View;Z)I

    move-result v3

    add-int/2addr v2, v3

    invoke-static {p3, v2, p5}, Landroid/widget/GridLayout;->getChildMeasureSpec(III)I

    move-result v0

    .line 952
    .local v0, childHeightSpec:I
    invoke-virtual {p1, v1, v0}, Landroid/view/View;->measure(II)V

    .line 953
    return-void
.end method

.method private measureChildrenWithMargins(IIZ)V
    .registers 26
    .parameter "widthSpec"
    .parameter "heightSpec"
    .parameter "firstPass"

    .prologue
    .line 956
    const/16 v17, 0x0

    .local v17, i:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getChildCount()I

    move-result v13

    .local v13, N:I
    :goto_6
    move/from16 v0, v17

    if-ge v0, v13, :cond_a7

    .line 957
    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/widget/GridLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 958
    .local v3, c:Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getVisibility()I

    move-result v2

    const/16 v4, 0x8

    if-ne v2, v4, :cond_1d

    .line 956
    :cond_1a
    :goto_1a
    add-int/lit8 v17, v17, 0x1

    goto :goto_6

    .line 959
    :cond_1d
    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/widget/GridLayout;->getLayoutParams(Landroid/view/View;)Landroid/widget/GridLayout$LayoutParams;

    move-result-object v19

    .line 960
    .local v19, lp:Landroid/widget/GridLayout$LayoutParams;
    if-eqz p3, :cond_37

    .line 961
    move-object/from16 v0, v19

    iget v6, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    move-object/from16 v0, v19

    iget v7, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    move-object/from16 v2, p0

    move/from16 v4, p1

    move/from16 v5, p2

    invoke-direct/range {v2 .. v7}, Landroid/widget/GridLayout;->measureChildWithMargins2(Landroid/view/View;IIII)V

    goto :goto_1a

    .line 963
    :cond_37
    move-object/from16 v0, p0

    iget v2, v0, Landroid/widget/GridLayout;->orientation:I

    if-nez v2, :cond_87

    const/16 v16, 0x1

    .line 964
    .local v16, horizontal:Z
    :goto_3f
    if-eqz v16, :cond_8a

    move-object/from16 v0, v19

    iget-object v0, v0, Landroid/widget/GridLayout$LayoutParams;->columnSpec:Landroid/widget/GridLayout$Spec;

    move-object/from16 v21, v0

    .line 965
    .local v21, spec:Landroid/widget/GridLayout$Spec;
    :goto_47
    move-object/from16 v0, v21

    iget-object v2, v0, Landroid/widget/GridLayout$Spec;->alignment:Landroid/widget/GridLayout$Alignment;

    sget-object v4, Landroid/widget/GridLayout;->FILL:Landroid/widget/GridLayout$Alignment;

    if-ne v2, v4, :cond_1a

    .line 966
    move-object/from16 v0, v21

    iget-object v0, v0, Landroid/widget/GridLayout$Spec;->span:Landroid/widget/GridLayout$Interval;

    move-object/from16 v20, v0

    .line 967
    .local v20, span:Landroid/widget/GridLayout$Interval;
    if-eqz v16, :cond_91

    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    .line 968
    .local v14, axis:Landroid/widget/GridLayout$Axis;
    :goto_5b
    invoke-virtual {v14}, Landroid/widget/GridLayout$Axis;->getLocations()[I

    move-result-object v18

    .line 969
    .local v18, locations:[I
    move-object/from16 v0, v20

    iget v2, v0, Landroid/widget/GridLayout$Interval;->max:I

    aget v2, v18, v2

    move-object/from16 v0, v20

    iget v4, v0, Landroid/widget/GridLayout$Interval;->min:I

    aget v4, v18, v4

    sub-int v15, v2, v4

    .line 970
    .local v15, cellSize:I
    move-object/from16 v0, p0

    move/from16 v1, v16

    invoke-direct {v0, v3, v1}, Landroid/widget/GridLayout;->getTotalMargin(Landroid/view/View;Z)I

    move-result v2

    sub-int v6, v15, v2

    .line 971
    .local v6, viewSize:I
    if-eqz v16, :cond_96

    .line 972
    move-object/from16 v0, v19

    iget v7, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    move-object/from16 v2, p0

    move/from16 v4, p1

    move/from16 v5, p2

    invoke-direct/range {v2 .. v7}, Landroid/widget/GridLayout;->measureChildWithMargins2(Landroid/view/View;IIII)V

    goto :goto_1a

    .line 963
    .end local v6           #viewSize:I
    .end local v14           #axis:Landroid/widget/GridLayout$Axis;
    .end local v15           #cellSize:I
    .end local v16           #horizontal:Z
    .end local v18           #locations:[I
    .end local v20           #span:Landroid/widget/GridLayout$Interval;
    .end local v21           #spec:Landroid/widget/GridLayout$Spec;
    :cond_87
    const/16 v16, 0x0

    goto :goto_3f

    .line 964
    .restart local v16       #horizontal:Z
    :cond_8a
    move-object/from16 v0, v19

    iget-object v0, v0, Landroid/widget/GridLayout$LayoutParams;->rowSpec:Landroid/widget/GridLayout$Spec;

    move-object/from16 v21, v0

    goto :goto_47

    .line 967
    .restart local v20       #span:Landroid/widget/GridLayout$Interval;
    .restart local v21       #spec:Landroid/widget/GridLayout$Spec;
    :cond_91
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    goto :goto_5b

    .line 974
    .restart local v6       #viewSize:I
    .restart local v14       #axis:Landroid/widget/GridLayout$Axis;
    .restart local v15       #cellSize:I
    .restart local v18       #locations:[I
    :cond_96
    move-object/from16 v0, v19

    iget v11, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    move-object/from16 v7, p0

    move-object v8, v3

    move/from16 v9, p1

    move/from16 v10, p2

    move v12, v6

    invoke-direct/range {v7 .. v12}, Landroid/widget/GridLayout;->measureChildWithMargins2(Landroid/view/View;IIII)V

    goto/16 :goto_1a

    .line 979
    .end local v3           #c:Landroid/view/View;
    .end local v6           #viewSize:I
    .end local v14           #axis:Landroid/widget/GridLayout$Axis;
    .end local v15           #cellSize:I
    .end local v16           #horizontal:Z
    .end local v18           #locations:[I
    .end local v19           #lp:Landroid/widget/GridLayout$LayoutParams;
    .end local v20           #span:Landroid/widget/GridLayout$Interval;
    .end local v21           #spec:Landroid/widget/GridLayout$Spec;
    :cond_a7
    return-void
.end method

.method private static procrusteanFill([IIII)V
    .registers 7
    .parameter "a"
    .parameter "start"
    .parameter "end"
    .parameter "value"

    .prologue
    .line 662
    array-length v0, p0

    .line 663
    .local v0, length:I
    invoke-static {p1, v0}, Ljava/lang/Math;->min(II)I

    move-result v1

    invoke-static {p2, v0}, Ljava/lang/Math;->min(II)I

    move-result v2

    invoke-static {p0, v1, v2, p3}, Ljava/util/Arrays;->fill([IIII)V

    .line 664
    return-void
.end method

.method private static setCellGroup(Landroid/widget/GridLayout$LayoutParams;IIII)V
    .registers 7
    .parameter "lp"
    .parameter "row"
    .parameter "rowSpan"
    .parameter "col"
    .parameter "colSpan"

    .prologue
    .line 667
    new-instance v0, Landroid/widget/GridLayout$Interval;

    add-int v1, p1, p2

    invoke-direct {v0, p1, v1}, Landroid/widget/GridLayout$Interval;-><init>(II)V

    invoke-virtual {p0, v0}, Landroid/widget/GridLayout$LayoutParams;->setRowSpecSpan(Landroid/widget/GridLayout$Interval;)V

    .line 668
    new-instance v0, Landroid/widget/GridLayout$Interval;

    add-int v1, p3, p4

    invoke-direct {v0, p3, v1}, Landroid/widget/GridLayout$Interval;-><init>(II)V

    invoke-virtual {p0, v0}, Landroid/widget/GridLayout$LayoutParams;->setColumnSpecSpan(Landroid/widget/GridLayout$Interval;)V

    .line 669
    return-void
.end method

.method public static spec(I)Landroid/widget/GridLayout$Spec;
    .registers 2
    .parameter "start"

    .prologue
    .line 2466
    const/4 v0, 0x1

    invoke-static {p0, v0}, Landroid/widget/GridLayout;->spec(II)Landroid/widget/GridLayout$Spec;

    move-result-object v0

    return-object v0
.end method

.method public static spec(II)Landroid/widget/GridLayout$Spec;
    .registers 3
    .parameter "start"
    .parameter "size"

    .prologue
    .line 2454
    sget-object v0, Landroid/widget/GridLayout;->UNDEFINED_ALIGNMENT:Landroid/widget/GridLayout$Alignment;

    invoke-static {p0, p1, v0}, Landroid/widget/GridLayout;->spec(IILandroid/widget/GridLayout$Alignment;)Landroid/widget/GridLayout$Spec;

    move-result-object v0

    return-object v0
.end method

.method public static spec(IILandroid/widget/GridLayout$Alignment;)Landroid/widget/GridLayout$Spec;
    .registers 9
    .parameter "start"
    .parameter "size"
    .parameter "alignment"

    .prologue
    .line 2427
    new-instance v0, Landroid/widget/GridLayout$Spec;

    const/high16 v1, -0x8000

    if-eq p0, v1, :cond_f

    const/4 v1, 0x1

    :goto_7
    const/4 v5, 0x0

    move v2, p0

    move v3, p1

    move-object v4, p2

    invoke-direct/range {v0 .. v5}, Landroid/widget/GridLayout$Spec;-><init>(ZIILandroid/widget/GridLayout$Alignment;Landroid/widget/GridLayout$1;)V

    return-object v0

    :cond_f
    const/4 v1, 0x0

    goto :goto_7
.end method

.method public static spec(ILandroid/widget/GridLayout$Alignment;)Landroid/widget/GridLayout$Spec;
    .registers 3
    .parameter "start"
    .parameter "alignment"

    .prologue
    .line 2441
    const/4 v0, 0x1

    invoke-static {p0, v0, p1}, Landroid/widget/GridLayout;->spec(IILandroid/widget/GridLayout$Alignment;)Landroid/widget/GridLayout$Spec;

    move-result-object v0

    return-object v0
.end method

.method private validateLayoutParams()V
    .registers 22

    .prologue
    .line 683
    move-object/from16 v0, p0

    iget v0, v0, Landroid/widget/GridLayout;->orientation:I

    move/from16 v19, v0

    if-nez v19, :cond_73

    const/4 v5, 0x1

    .line 684
    .local v5, horizontal:Z
    :goto_9
    if-eqz v5, :cond_75

    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    .line 685
    .local v3, axis:Landroid/widget/GridLayout$Axis;
    :goto_f
    iget v0, v3, Landroid/widget/GridLayout$Axis;->definedCount:I

    move/from16 v19, v0

    const/high16 v20, -0x8000

    move/from16 v0, v19

    move/from16 v1, v20

    if-eq v0, v1, :cond_7a

    iget v4, v3, Landroid/widget/GridLayout$Axis;->definedCount:I

    .line 687
    .local v4, count:I
    :goto_1d
    const/4 v8, 0x0

    .line 688
    .local v8, major:I
    const/4 v14, 0x0

    .line 689
    .local v14, minor:I
    new-array v13, v4, [I

    .line 691
    .local v13, maxSizes:[I
    const/4 v6, 0x0

    .local v6, i:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getChildCount()I

    move-result v2

    .local v2, N:I
    :goto_26
    if-ge v6, v2, :cond_af

    .line 692
    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Landroid/widget/GridLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v7

    check-cast v7, Landroid/widget/GridLayout$LayoutParams;

    .line 694
    .local v7, lp:Landroid/widget/GridLayout$LayoutParams;
    if-eqz v5, :cond_7c

    iget-object v11, v7, Landroid/widget/GridLayout$LayoutParams;->rowSpec:Landroid/widget/GridLayout$Spec;

    .line 695
    .local v11, majorSpec:Landroid/widget/GridLayout$Spec;
    :goto_38
    iget-object v9, v11, Landroid/widget/GridLayout$Spec;->span:Landroid/widget/GridLayout$Interval;

    .line 696
    .local v9, majorRange:Landroid/widget/GridLayout$Interval;
    iget-boolean v12, v11, Landroid/widget/GridLayout$Spec;->startDefined:Z

    .line 697
    .local v12, majorWasDefined:Z
    invoke-virtual {v9}, Landroid/widget/GridLayout$Interval;->size()I

    move-result v10

    .line 698
    .local v10, majorSpan:I
    if-eqz v12, :cond_44

    .line 699
    iget v8, v9, Landroid/widget/GridLayout$Interval;->min:I

    .line 702
    :cond_44
    if-eqz v5, :cond_7f

    iget-object v0, v7, Landroid/widget/GridLayout$LayoutParams;->columnSpec:Landroid/widget/GridLayout$Spec;

    move-object/from16 v17, v0

    .line 703
    .local v17, minorSpec:Landroid/widget/GridLayout$Spec;
    :goto_4a
    move-object/from16 v0, v17

    iget-object v15, v0, Landroid/widget/GridLayout$Spec;->span:Landroid/widget/GridLayout$Interval;

    .line 704
    .local v15, minorRange:Landroid/widget/GridLayout$Interval;
    move-object/from16 v0, v17

    iget-boolean v0, v0, Landroid/widget/GridLayout$Spec;->startDefined:Z

    move/from16 v18, v0

    .line 705
    .local v18, minorWasDefined:Z
    move/from16 v0, v18

    invoke-static {v15, v0, v4}, Landroid/widget/GridLayout;->clip(Landroid/widget/GridLayout$Interval;ZI)I

    move-result v16

    .line 706
    .local v16, minorSpan:I
    if-eqz v18, :cond_5e

    .line 707
    iget v14, v15, Landroid/widget/GridLayout$Interval;->min:I

    .line 710
    :cond_5e
    if-eqz v4, :cond_9c

    .line 712
    if-eqz v12, :cond_64

    if-nez v18, :cond_91

    .line 713
    :cond_64
    :goto_64
    add-int v19, v14, v16

    move/from16 v0, v19

    invoke-static {v13, v8, v14, v0}, Landroid/widget/GridLayout;->fits([IIII)Z

    move-result v19

    if-nez v19, :cond_91

    .line 714
    if-eqz v18, :cond_84

    .line 715
    add-int/lit8 v8, v8, 0x1

    goto :goto_64

    .line 683
    .end local v2           #N:I
    .end local v3           #axis:Landroid/widget/GridLayout$Axis;
    .end local v4           #count:I
    .end local v5           #horizontal:Z
    .end local v6           #i:I
    .end local v7           #lp:Landroid/widget/GridLayout$LayoutParams;
    .end local v8           #major:I
    .end local v9           #majorRange:Landroid/widget/GridLayout$Interval;
    .end local v10           #majorSpan:I
    .end local v11           #majorSpec:Landroid/widget/GridLayout$Spec;
    .end local v12           #majorWasDefined:Z
    .end local v13           #maxSizes:[I
    .end local v14           #minor:I
    .end local v15           #minorRange:Landroid/widget/GridLayout$Interval;
    .end local v16           #minorSpan:I
    .end local v17           #minorSpec:Landroid/widget/GridLayout$Spec;
    .end local v18           #minorWasDefined:Z
    :cond_73
    const/4 v5, 0x0

    goto :goto_9

    .line 684
    .restart local v5       #horizontal:Z
    :cond_75
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    goto :goto_f

    .line 685
    .restart local v3       #axis:Landroid/widget/GridLayout$Axis;
    :cond_7a
    const/4 v4, 0x0

    goto :goto_1d

    .line 694
    .restart local v2       #N:I
    .restart local v4       #count:I
    .restart local v6       #i:I
    .restart local v7       #lp:Landroid/widget/GridLayout$LayoutParams;
    .restart local v8       #major:I
    .restart local v13       #maxSizes:[I
    .restart local v14       #minor:I
    :cond_7c
    iget-object v11, v7, Landroid/widget/GridLayout$LayoutParams;->columnSpec:Landroid/widget/GridLayout$Spec;

    goto :goto_38

    .line 702
    .restart local v9       #majorRange:Landroid/widget/GridLayout$Interval;
    .restart local v10       #majorSpan:I
    .restart local v11       #majorSpec:Landroid/widget/GridLayout$Spec;
    .restart local v12       #majorWasDefined:Z
    :cond_7f
    iget-object v0, v7, Landroid/widget/GridLayout$LayoutParams;->rowSpec:Landroid/widget/GridLayout$Spec;

    move-object/from16 v17, v0

    goto :goto_4a

    .line 717
    .restart local v15       #minorRange:Landroid/widget/GridLayout$Interval;
    .restart local v16       #minorSpan:I
    .restart local v17       #minorSpec:Landroid/widget/GridLayout$Spec;
    .restart local v18       #minorWasDefined:Z
    :cond_84
    add-int v19, v14, v16

    move/from16 v0, v19

    if-gt v0, v4, :cond_8d

    .line 718
    add-int/lit8 v14, v14, 0x1

    goto :goto_64

    .line 720
    :cond_8d
    const/4 v14, 0x0

    .line 721
    add-int/lit8 v8, v8, 0x1

    goto :goto_64

    .line 726
    :cond_91
    add-int v19, v14, v16

    add-int v20, v8, v10

    move/from16 v0, v19

    move/from16 v1, v20

    invoke-static {v13, v14, v0, v1}, Landroid/widget/GridLayout;->procrusteanFill([IIII)V

    .line 729
    :cond_9c
    if-eqz v5, :cond_a9

    .line 730
    move/from16 v0, v16

    invoke-static {v7, v8, v10, v14, v0}, Landroid/widget/GridLayout;->setCellGroup(Landroid/widget/GridLayout$LayoutParams;IIII)V

    .line 735
    :goto_a3
    add-int v14, v14, v16

    .line 691
    add-int/lit8 v6, v6, 0x1

    goto/16 :goto_26

    .line 732
    :cond_a9
    move/from16 v0, v16

    invoke-static {v7, v14, v0, v8, v10}, Landroid/widget/GridLayout;->setCellGroup(Landroid/widget/GridLayout$LayoutParams;IIII)V

    goto :goto_a3

    .line 737
    .end local v7           #lp:Landroid/widget/GridLayout$LayoutParams;
    .end local v9           #majorRange:Landroid/widget/GridLayout$Interval;
    .end local v10           #majorSpan:I
    .end local v11           #majorSpec:Landroid/widget/GridLayout$Spec;
    .end local v12           #majorWasDefined:Z
    .end local v15           #minorRange:Landroid/widget/GridLayout$Interval;
    .end local v16           #minorSpan:I
    .end local v17           #minorSpec:Landroid/widget/GridLayout$Spec;
    .end local v18           #minorWasDefined:Z
    :cond_af
    return-void
.end method


# virtual methods
.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .registers 6
    .parameter "p"

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 798
    instance-of v3, p1, Landroid/widget/GridLayout$LayoutParams;

    if-nez v3, :cond_7

    .line 806
    :goto_6
    return v1

    :cond_7
    move-object v0, p1

    .line 801
    check-cast v0, Landroid/widget/GridLayout$LayoutParams;

    .line 803
    .local v0, lp:Landroid/widget/GridLayout$LayoutParams;
    invoke-direct {p0, v0, v2}, Landroid/widget/GridLayout;->checkLayoutParams(Landroid/widget/GridLayout$LayoutParams;Z)V

    .line 804
    invoke-direct {p0, v0, v1}, Landroid/widget/GridLayout;->checkLayoutParams(Landroid/widget/GridLayout$LayoutParams;Z)V

    move v1, v2

    .line 806
    goto :goto_6
.end method

.method protected bridge synthetic generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .registers 2

    .prologue
    .line 150
    invoke-virtual {p0}, Landroid/widget/GridLayout;->generateDefaultLayoutParams()Landroid/widget/GridLayout$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method protected generateDefaultLayoutParams()Landroid/widget/GridLayout$LayoutParams;
    .registers 2

    .prologue
    .line 811
    new-instance v0, Landroid/widget/GridLayout$LayoutParams;

    invoke-direct {v0}, Landroid/widget/GridLayout$LayoutParams;-><init>()V

    return-object v0
.end method

.method public bridge synthetic generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .registers 3
    .parameter "x0"

    .prologue
    .line 150
    invoke-virtual {p0, p1}, Landroid/widget/GridLayout;->generateLayoutParams(Landroid/util/AttributeSet;)Landroid/widget/GridLayout$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .registers 3
    .parameter "x0"

    .prologue
    .line 150
    invoke-virtual {p0, p1}, Landroid/widget/GridLayout;->generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/widget/GridLayout$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Landroid/widget/GridLayout$LayoutParams;
    .registers 4
    .parameter "attrs"

    .prologue
    .line 816
    new-instance v0, Landroid/widget/GridLayout$LayoutParams;

    invoke-virtual {p0}, Landroid/widget/GridLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Landroid/widget/GridLayout$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/widget/GridLayout$LayoutParams;
    .registers 3
    .parameter "p"

    .prologue
    .line 821
    new-instance v0, Landroid/widget/GridLayout$LayoutParams;

    invoke-direct {v0, p1}, Landroid/widget/GridLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    return-object v0
.end method

.method final getAlignment(Landroid/widget/GridLayout$Alignment;Z)Landroid/widget/GridLayout$Alignment;
    .registers 4
    .parameter "alignment"
    .parameter "horizontal"

    .prologue
    .line 1038
    sget-object v0, Landroid/widget/GridLayout;->UNDEFINED_ALIGNMENT:Landroid/widget/GridLayout$Alignment;

    if-eq p1, v0, :cond_5

    .end local p1
    :goto_4
    return-object p1

    .restart local p1
    :cond_5
    if-eqz p2, :cond_a

    sget-object p1, Landroid/widget/GridLayout;->START:Landroid/widget/GridLayout$Alignment;

    goto :goto_4

    :cond_a
    sget-object p1, Landroid/widget/GridLayout;->BASELINE:Landroid/widget/GridLayout$Alignment;

    goto :goto_4
.end method

.method public getAlignmentMode()I
    .registers 2

    .prologue
    .line 464
    iget v0, p0, Landroid/widget/GridLayout;->alignmentMode:I

    return v0
.end method

.method public getColumnCount()I
    .registers 2

    .prologue
    .line 386
    iget-object v0, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v0}, Landroid/widget/GridLayout$Axis;->getCount()I

    move-result v0

    return v0
.end method

.method final getLayoutParams(Landroid/view/View;)Landroid/widget/GridLayout$LayoutParams;
    .registers 3
    .parameter "c"

    .prologue
    .line 769
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/GridLayout$LayoutParams;

    return-object v0
.end method

.method getMargin1(Landroid/view/View;ZZ)I
    .registers 7
    .parameter "view"
    .parameter "horizontal"
    .parameter "leading"

    .prologue
    .line 625
    invoke-virtual {p0, p1}, Landroid/widget/GridLayout;->getLayoutParams(Landroid/view/View;)Landroid/widget/GridLayout$LayoutParams;

    move-result-object v0

    .line 626
    .local v0, lp:Landroid/widget/GridLayout$LayoutParams;
    if-eqz p2, :cond_16

    if-eqz p3, :cond_13

    iget v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    .line 629
    .local v1, margin:I
    :goto_a
    const/high16 v2, -0x8000

    if-ne v1, v2, :cond_12

    invoke-direct {p0, p1, v0, p2, p3}, Landroid/widget/GridLayout;->getDefaultMargin(Landroid/view/View;Landroid/widget/GridLayout$LayoutParams;ZZ)I

    move-result v1

    .end local v1           #margin:I
    :cond_12
    return v1

    .line 626
    :cond_13
    iget v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    goto :goto_a

    :cond_16
    if-eqz p3, :cond_1b

    iget v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    goto :goto_a

    :cond_1b
    iget v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    goto :goto_a
.end method

.method final getMeasurementIncludingMargin(Landroid/view/View;Z)I
    .registers 5
    .parameter "c"
    .parameter "horizontal"

    .prologue
    .line 1025
    invoke-virtual {p1}, Landroid/view/View;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_a

    .line 1026
    const/4 v0, 0x0

    .line 1028
    :goto_9
    return v0

    :cond_a
    invoke-direct {p0, p1, p2}, Landroid/widget/GridLayout;->getMeasurement(Landroid/view/View;Z)I

    move-result v0

    invoke-direct {p0, p1, p2}, Landroid/widget/GridLayout;->getTotalMargin(Landroid/view/View;Z)I

    move-result v1

    add-int/2addr v0, v1

    goto :goto_9
.end method

.method public getOrientation()I
    .registers 2

    .prologue
    .line 293
    iget v0, p0, Landroid/widget/GridLayout;->orientation:I

    return v0
.end method

.method public getRowCount()I
    .registers 2

    .prologue
    .line 353
    iget-object v0, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v0}, Landroid/widget/GridLayout$Axis;->getCount()I

    move-result v0

    return v0
.end method

.method public getUseDefaultMargins()Z
    .registers 2

    .prologue
    .line 417
    iget-boolean v0, p0, Landroid/widget/GridLayout;->useDefaultMargins:Z

    return v0
.end method

.method public isColumnOrderPreserved()Z
    .registers 2

    .prologue
    .line 534
    iget-object v0, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v0}, Landroid/widget/GridLayout$Axis;->isOrderPreserved()Z

    move-result v0

    return v0
.end method

.method public isRowOrderPreserved()Z
    .registers 2

    .prologue
    .line 498
    iget-object v0, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v0}, Landroid/widget/GridLayout$Axis;->isOrderPreserved()Z

    move-result v0

    return v0
.end method

.method protected onChildVisibilityChanged(Landroid/view/View;II)V
    .registers 5
    .parameter "child"
    .parameter "oldVisibility"
    .parameter "newVisibility"

    .prologue
    const/16 v0, 0x8

    .line 915
    invoke-super {p0, p1, p2, p3}, Landroid/view/ViewGroup;->onChildVisibilityChanged(Landroid/view/View;II)V

    .line 916
    if-eq p2, v0, :cond_9

    if-ne p3, v0, :cond_c

    .line 917
    :cond_9
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateStructure()V

    .line 919
    :cond_c
    return-void
.end method

.method protected onDebugDraw(Landroid/graphics/Canvas;)V
    .registers 24
    .parameter "canvas"

    .prologue
    .line 861
    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getHeight()I

    move-result v2

    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getPaddingTop()I

    move-result v3

    sub-int/2addr v2, v3

    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getPaddingBottom()I

    move-result v3

    sub-int v16, v2, v3

    .line 862
    .local v16, height:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getWidth()I

    move-result v2

    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getPaddingLeft()I

    move-result v3

    sub-int/2addr v2, v3

    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getPaddingRight()I

    move-result v3

    sub-int v19, v2, v3

    .line 864
    .local v19, width:I
    new-instance v8, Landroid/graphics/Paint;

    invoke-direct {v8}, Landroid/graphics/Paint;-><init>()V

    .line 865
    .local v8, paint:Landroid/graphics/Paint;
    sget-object v2, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v8, v2}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 866
    const/16 v2, 0x32

    const/16 v3, 0xff

    const/16 v5, 0xff

    const/16 v6, 0xff

    invoke-static {v2, v3, v5, v6}, Landroid/graphics/Color;->argb(IIII)I

    move-result v2

    invoke-virtual {v8, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 868
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    iget-object v0, v2, Landroid/widget/GridLayout$Axis;->locations:[I

    move-object/from16 v20, v0

    .line 869
    .local v20, xs:[I
    if-eqz v20, :cond_5e

    .line 870
    const/16 v17, 0x0

    .local v17, i:I
    move-object/from16 v0, v20

    array-length v0, v0

    move/from16 v18, v0

    .local v18, length:I
    :goto_48
    move/from16 v0, v17

    move/from16 v1, v18

    if-ge v0, v1, :cond_5e

    .line 871
    aget v4, v20, v17

    .line 872
    .local v4, x:I
    const/4 v5, 0x0

    add-int/lit8 v7, v16, -0x1

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move v6, v4

    invoke-direct/range {v2 .. v8}, Landroid/widget/GridLayout;->drawLine(Landroid/graphics/Canvas;IIIILandroid/graphics/Paint;)V

    .line 870
    add-int/lit8 v17, v17, 0x1

    goto :goto_48

    .line 876
    .end local v4           #x:I
    .end local v17           #i:I
    .end local v18           #length:I
    :cond_5e
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    iget-object v0, v2, Landroid/widget/GridLayout$Axis;->locations:[I

    move-object/from16 v21, v0

    .line 877
    .local v21, ys:[I
    if-eqz v21, :cond_86

    .line 878
    const/16 v17, 0x0

    .restart local v17       #i:I
    move-object/from16 v0, v21

    array-length v0, v0

    move/from16 v18, v0

    .restart local v18       #length:I
    :goto_6f
    move/from16 v0, v17

    move/from16 v1, v18

    if-ge v0, v1, :cond_86

    .line 879
    aget v12, v21, v17

    .line 880
    .local v12, y:I
    const/4 v11, 0x0

    add-int/lit8 v13, v19, -0x1

    move-object/from16 v9, p0

    move-object/from16 v10, p1

    move v14, v12

    move-object v15, v8

    invoke-direct/range {v9 .. v15}, Landroid/widget/GridLayout;->drawLine(Landroid/graphics/Canvas;IIIILandroid/graphics/Paint;)V

    .line 878
    add-int/lit8 v17, v17, 0x1

    goto :goto_6f

    .line 884
    .end local v12           #y:I
    .end local v17           #i:I
    .end local v18           #length:I
    :cond_86
    invoke-super/range {p0 .. p1}, Landroid/view/ViewGroup;->onDebugDraw(Landroid/graphics/Canvas;)V

    .line 885
    return-void
.end method

.method protected onDebugDrawMargins(Landroid/graphics/Canvas;)V
    .registers 13
    .parameter "canvas"

    .prologue
    const/4 v10, 0x0

    const/4 v9, 0x1

    .line 843
    new-instance v3, Landroid/widget/GridLayout$LayoutParams;

    invoke-direct {v3}, Landroid/widget/GridLayout$LayoutParams;-><init>()V

    .line 844
    .local v3, lp:Landroid/widget/GridLayout$LayoutParams;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_8
    invoke-virtual {p0}, Landroid/widget/GridLayout;->getChildCount()I

    move-result v4

    if-ge v1, v4, :cond_44

    .line 845
    invoke-virtual {p0, v1}, Landroid/widget/GridLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 846
    .local v0, c:Landroid/view/View;
    invoke-virtual {p0}, Landroid/widget/GridLayout;->getLayoutMode()I

    move-result v4

    if-ne v4, v9, :cond_41

    invoke-virtual {v0}, Landroid/view/View;->getOpticalInsets()Landroid/graphics/Insets;

    move-result-object v2

    .line 847
    .local v2, insets:Landroid/graphics/Insets;
    :goto_1c
    invoke-virtual {p0, v0, v9, v9}, Landroid/widget/GridLayout;->getMargin1(Landroid/view/View;ZZ)I

    move-result v4

    iget v5, v2, Landroid/graphics/Insets;->left:I

    sub-int/2addr v4, v5

    invoke-virtual {p0, v0, v10, v9}, Landroid/widget/GridLayout;->getMargin1(Landroid/view/View;ZZ)I

    move-result v5

    iget v6, v2, Landroid/graphics/Insets;->top:I

    sub-int/2addr v5, v6

    invoke-virtual {p0, v0, v9, v10}, Landroid/widget/GridLayout;->getMargin1(Landroid/view/View;ZZ)I

    move-result v6

    iget v7, v2, Landroid/graphics/Insets;->right:I

    sub-int/2addr v6, v7

    invoke-virtual {p0, v0, v10, v10}, Landroid/widget/GridLayout;->getMargin1(Landroid/view/View;ZZ)I

    move-result v7

    iget v8, v2, Landroid/graphics/Insets;->bottom:I

    sub-int/2addr v7, v8

    invoke-virtual {v3, v4, v5, v6, v7}, Landroid/widget/GridLayout$LayoutParams;->setMargins(IIII)V

    .line 852
    invoke-virtual {v3, v0, p1}, Landroid/widget/GridLayout$LayoutParams;->onDebugDraw(Landroid/view/View;Landroid/graphics/Canvas;)V

    .line 844
    add-int/lit8 v1, v1, 0x1

    goto :goto_8

    .line 846
    .end local v2           #insets:Landroid/graphics/Insets;
    :cond_41
    sget-object v2, Landroid/graphics/Insets;->NONE:Landroid/graphics/Insets;

    goto :goto_1c

    .line 854
    .end local v0           #c:Landroid/view/View;
    :cond_44
    return-void
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 3
    .parameter "event"

    .prologue
    .line 1144
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 1145
    const-class v0, Landroid/widget/GridLayout;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    .line 1146
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .registers 3
    .parameter "info"

    .prologue
    .line 1150
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 1151
    const-class v0, Landroid/widget/GridLayout;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    .line 1152
    return-void
.end method

.method protected onLayout(ZIIII)V
    .registers 59
    .parameter "changed"
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    .line 1058
    invoke-direct/range {p0 .. p0}, Landroid/widget/GridLayout;->consistencyCheck()V

    .line 1060
    sub-int v44, p4, p2

    .line 1061
    .local v44, targetWidth:I
    sub-int v43, p5, p3

    .line 1063
    .local v43, targetHeight:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getPaddingLeft()I

    move-result v35

    .line 1064
    .local v35, paddingLeft:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getPaddingTop()I

    move-result v37

    .line 1065
    .local v37, paddingTop:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getPaddingRight()I

    move-result v36

    .line 1066
    .local v36, paddingRight:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getPaddingBottom()I

    move-result v34

    .line 1068
    .local v34, paddingBottom:I
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    sub-int v6, v44, v35

    sub-int v6, v6, v36

    invoke-virtual {v3, v6}, Landroid/widget/GridLayout$Axis;->layout(I)V

    .line 1069
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    sub-int v6, v43, v37

    sub-int v6, v6, v34

    invoke-virtual {v3, v6}, Landroid/widget/GridLayout$Axis;->layout(I)V

    .line 1071
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v3}, Landroid/widget/GridLayout$Axis;->getLocations()[I

    move-result-object v26

    .line 1072
    .local v26, hLocations:[I
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v3}, Landroid/widget/GridLayout$Axis;->getLocations()[I

    move-result-object v47

    .line 1074
    .local v47, vLocations:[I
    const/16 v28, 0x0

    .local v28, i:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getChildCount()I

    move-result v12

    .local v12, N:I
    :goto_43
    move/from16 v0, v28

    if-ge v0, v12, :cond_1bb

    .line 1075
    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/widget/GridLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    .line 1076
    .local v4, c:Landroid/view/View;
    invoke-virtual {v4}, Landroid/view/View;->getVisibility()I

    move-result v3

    const/16 v6, 0x8

    if-ne v3, v6, :cond_5a

    .line 1074
    :goto_57
    add-int/lit8 v28, v28, 0x1

    goto :goto_43

    .line 1077
    :cond_5a
    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Landroid/widget/GridLayout;->getLayoutParams(Landroid/view/View;)Landroid/widget/GridLayout$LayoutParams;

    move-result-object v31

    .line 1078
    .local v31, lp:Landroid/widget/GridLayout$LayoutParams;
    move-object/from16 v0, v31

    iget-object v0, v0, Landroid/widget/GridLayout$LayoutParams;->columnSpec:Landroid/widget/GridLayout$Spec;

    move-object/from16 v20, v0

    .line 1079
    .local v20, columnSpec:Landroid/widget/GridLayout$Spec;
    move-object/from16 v0, v31

    iget-object v0, v0, Landroid/widget/GridLayout$LayoutParams;->rowSpec:Landroid/widget/GridLayout$Spec;

    move-object/from16 v40, v0

    .line 1081
    .local v40, rowSpec:Landroid/widget/GridLayout$Spec;
    move-object/from16 v0, v20

    iget-object v0, v0, Landroid/widget/GridLayout$Spec;->span:Landroid/widget/GridLayout$Interval;

    move-object/from16 v19, v0

    .line 1082
    .local v19, colSpan:Landroid/widget/GridLayout$Interval;
    move-object/from16 v0, v40

    iget-object v0, v0, Landroid/widget/GridLayout$Spec;->span:Landroid/widget/GridLayout$Interval;

    move-object/from16 v39, v0

    .line 1084
    .local v39, rowSpan:Landroid/widget/GridLayout$Interval;
    move-object/from16 v0, v19

    iget v3, v0, Landroid/widget/GridLayout$Interval;->min:I

    aget v49, v26, v3

    .line 1085
    .local v49, x1:I
    move-object/from16 v0, v39

    iget v3, v0, Landroid/widget/GridLayout$Interval;->min:I

    aget v51, v47, v3

    .line 1087
    .local v51, y1:I
    move-object/from16 v0, v19

    iget v3, v0, Landroid/widget/GridLayout$Interval;->max:I

    aget v50, v26, v3

    .line 1088
    .local v50, x2:I
    move-object/from16 v0, v39

    iget v3, v0, Landroid/widget/GridLayout$Interval;->max:I

    aget v52, v47, v3

    .line 1090
    .local v52, y2:I
    sub-int v18, v50, v49

    .line 1091
    .local v18, cellWidth:I
    sub-int v17, v52, v51

    .line 1093
    .local v17, cellHeight:I
    const/4 v3, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v3}, Landroid/widget/GridLayout;->getMeasurement(Landroid/view/View;Z)I

    move-result v33

    .line 1094
    .local v33, pWidth:I
    const/4 v3, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v3}, Landroid/widget/GridLayout;->getMeasurement(Landroid/view/View;Z)I

    move-result v32

    .line 1096
    .local v32, pHeight:I
    move-object/from16 v0, v20

    iget-object v3, v0, Landroid/widget/GridLayout$Spec;->alignment:Landroid/widget/GridLayout$Alignment;

    const/4 v6, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v6}, Landroid/widget/GridLayout;->getAlignment(Landroid/widget/GridLayout$Alignment;Z)Landroid/widget/GridLayout$Alignment;

    move-result-object v5

    .line 1097
    .local v5, hAlign:Landroid/widget/GridLayout$Alignment;
    move-object/from16 v0, v40

    iget-object v3, v0, Landroid/widget/GridLayout$Spec;->alignment:Landroid/widget/GridLayout$Alignment;

    const/4 v6, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v6}, Landroid/widget/GridLayout;->getAlignment(Landroid/widget/GridLayout$Alignment;Z)Landroid/widget/GridLayout$Alignment;

    move-result-object v9

    .line 1099
    .local v9, vAlign:Landroid/widget/GridLayout$Alignment;
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v3}, Landroid/widget/GridLayout$Axis;->getGroupBounds()Landroid/widget/GridLayout$PackedMap;

    move-result-object v3

    move/from16 v0, v28

    invoke-virtual {v3, v0}, Landroid/widget/GridLayout$PackedMap;->getValue(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/widget/GridLayout$Bounds;

    .line 1100
    .local v2, boundsX:Landroid/widget/GridLayout$Bounds;
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v3}, Landroid/widget/GridLayout$Axis;->getGroupBounds()Landroid/widget/GridLayout$PackedMap;

    move-result-object v3

    move/from16 v0, v28

    invoke-virtual {v3, v0}, Landroid/widget/GridLayout$PackedMap;->getValue(I)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Landroid/widget/GridLayout$Bounds;

    .line 1103
    .local v16, boundsY:Landroid/widget/GridLayout$Bounds;
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/widget/GridLayout$Bounds;->size(Z)I

    move-result v3

    sub-int v3, v18, v3

    invoke-virtual {v5, v4, v3}, Landroid/widget/GridLayout$Alignment;->getGravityOffset(Landroid/view/View;I)I

    move-result v24

    .line 1104
    .local v24, gravityOffsetX:I
    const/4 v3, 0x1

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Landroid/widget/GridLayout$Bounds;->size(Z)I

    move-result v3

    sub-int v3, v17, v3

    invoke-virtual {v9, v4, v3}, Landroid/widget/GridLayout$Alignment;->getGravityOffset(Landroid/view/View;I)I

    move-result v25

    .line 1106
    .local v25, gravityOffsetY:I
    const/4 v3, 0x1

    const/4 v6, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v3, v6}, Landroid/widget/GridLayout;->getMargin(Landroid/view/View;ZZ)I

    move-result v30

    .line 1107
    .local v30, leftMargin:I
    const/4 v3, 0x0

    const/4 v6, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v3, v6}, Landroid/widget/GridLayout;->getMargin(Landroid/view/View;ZZ)I

    move-result v45

    .line 1108
    .local v45, topMargin:I
    const/4 v3, 0x1

    const/4 v6, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v3, v6}, Landroid/widget/GridLayout;->getMargin(Landroid/view/View;ZZ)I

    move-result v38

    .line 1109
    .local v38, rightMargin:I
    const/4 v3, 0x0

    const/4 v6, 0x0

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v3, v6}, Landroid/widget/GridLayout;->getMargin(Landroid/view/View;ZZ)I

    move-result v15

    .line 1111
    .local v15, bottomMargin:I
    add-int v41, v30, v38

    .line 1112
    .local v41, sumMarginsX:I
    add-int v42, v45, v15

    .line 1115
    .local v42, sumMarginsY:I
    add-int v6, v33, v41

    const/4 v7, 0x1

    move-object/from16 v3, p0

    invoke-virtual/range {v2 .. v7}, Landroid/widget/GridLayout$Bounds;->getOffset(Landroid/widget/GridLayout;Landroid/view/View;Landroid/widget/GridLayout$Alignment;IZ)I

    move-result v13

    .line 1116
    .local v13, alignmentOffsetX:I
    add-int v10, v32, v42

    const/4 v11, 0x0

    move-object/from16 v6, v16

    move-object/from16 v7, p0

    move-object v8, v4

    invoke-virtual/range {v6 .. v11}, Landroid/widget/GridLayout$Bounds;->getOffset(Landroid/widget/GridLayout;Landroid/view/View;Landroid/widget/GridLayout$Alignment;IZ)I

    move-result v14

    .line 1118
    .local v14, alignmentOffsetY:I
    sub-int v3, v18, v41

    move/from16 v0, v33

    invoke-virtual {v5, v4, v0, v3}, Landroid/widget/GridLayout$Alignment;->getSizeInCell(Landroid/view/View;II)I

    move-result v48

    .line 1119
    .local v48, width:I
    sub-int v3, v17, v42

    move/from16 v0, v32

    invoke-virtual {v9, v4, v0, v3}, Landroid/widget/GridLayout$Alignment;->getSizeInCell(Landroid/view/View;II)I

    move-result v27

    .line 1121
    .local v27, height:I
    add-int v3, v49, v24

    add-int v23, v3, v13

    .line 1123
    .local v23, dx:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->isLayoutRtl()Z

    move-result v3

    if-nez v3, :cond_1af

    add-int v3, v35, v30

    add-int v21, v3, v23

    .line 1125
    .local v21, cx:I
    :goto_147
    add-int v3, v37, v51

    add-int v3, v3, v25

    add-int/2addr v3, v14

    add-int v22, v3, v45

    .line 1127
    .local v22, cy:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/GridLayout;->getLayoutMode()I

    move-result v3

    const/4 v6, 0x1

    if-ne v3, v6, :cond_1b8

    const/16 v46, 0x1

    .line 1128
    .local v46, useLayoutBounds:Z
    :goto_157
    if-eqz v46, :cond_17f

    .line 1129
    invoke-virtual {v4}, Landroid/view/View;->getOpticalInsets()Landroid/graphics/Insets;

    move-result-object v29

    .line 1130
    .local v29, insets:Landroid/graphics/Insets;
    move-object/from16 v0, v29

    iget v3, v0, Landroid/graphics/Insets;->left:I

    sub-int v21, v21, v3

    .line 1131
    move-object/from16 v0, v29

    iget v3, v0, Landroid/graphics/Insets;->top:I

    sub-int v22, v22, v3

    .line 1132
    move-object/from16 v0, v29

    iget v3, v0, Landroid/graphics/Insets;->left:I

    move-object/from16 v0, v29

    iget v6, v0, Landroid/graphics/Insets;->right:I

    add-int/2addr v3, v6

    add-int v48, v48, v3

    .line 1133
    move-object/from16 v0, v29

    iget v3, v0, Landroid/graphics/Insets;->top:I

    move-object/from16 v0, v29

    iget v6, v0, Landroid/graphics/Insets;->bottom:I

    add-int/2addr v3, v6

    add-int v27, v27, v3

    .line 1135
    .end local v29           #insets:Landroid/graphics/Insets;
    :cond_17f
    invoke-virtual {v4}, Landroid/view/View;->getMeasuredWidth()I

    move-result v3

    move/from16 v0, v48

    if-ne v0, v3, :cond_18f

    invoke-virtual {v4}, Landroid/view/View;->getMeasuredHeight()I

    move-result v3

    move/from16 v0, v27

    if-eq v0, v3, :cond_1a2

    .line 1136
    :cond_18f
    const/high16 v3, 0x4000

    move/from16 v0, v48

    invoke-static {v0, v3}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v3

    const/high16 v6, 0x4000

    move/from16 v0, v27

    invoke-static {v0, v6}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v6

    invoke-virtual {v4, v3, v6}, Landroid/view/View;->measure(II)V

    .line 1138
    :cond_1a2
    add-int v3, v21, v48

    add-int v6, v22, v27

    move/from16 v0, v21

    move/from16 v1, v22

    invoke-virtual {v4, v0, v1, v3, v6}, Landroid/view/View;->layout(IIII)V

    goto/16 :goto_57

    .line 1123
    .end local v21           #cx:I
    .end local v22           #cy:I
    .end local v46           #useLayoutBounds:Z
    :cond_1af
    sub-int v3, v44, v48

    sub-int v3, v3, v36

    sub-int v3, v3, v38

    sub-int v21, v3, v23

    goto :goto_147

    .line 1127
    .restart local v21       #cx:I
    .restart local v22       #cy:I
    :cond_1b8
    const/16 v46, 0x0

    goto :goto_157

    .line 1140
    .end local v2           #boundsX:Landroid/widget/GridLayout$Bounds;
    .end local v4           #c:Landroid/view/View;
    .end local v5           #hAlign:Landroid/widget/GridLayout$Alignment;
    .end local v9           #vAlign:Landroid/widget/GridLayout$Alignment;
    .end local v13           #alignmentOffsetX:I
    .end local v14           #alignmentOffsetY:I
    .end local v15           #bottomMargin:I
    .end local v16           #boundsY:Landroid/widget/GridLayout$Bounds;
    .end local v17           #cellHeight:I
    .end local v18           #cellWidth:I
    .end local v19           #colSpan:Landroid/widget/GridLayout$Interval;
    .end local v20           #columnSpec:Landroid/widget/GridLayout$Spec;
    .end local v21           #cx:I
    .end local v22           #cy:I
    .end local v23           #dx:I
    .end local v24           #gravityOffsetX:I
    .end local v25           #gravityOffsetY:I
    .end local v27           #height:I
    .end local v30           #leftMargin:I
    .end local v31           #lp:Landroid/widget/GridLayout$LayoutParams;
    .end local v32           #pHeight:I
    .end local v33           #pWidth:I
    .end local v38           #rightMargin:I
    .end local v39           #rowSpan:Landroid/widget/GridLayout$Interval;
    .end local v40           #rowSpec:Landroid/widget/GridLayout$Spec;
    .end local v41           #sumMarginsX:I
    .end local v42           #sumMarginsY:I
    .end local v45           #topMargin:I
    .end local v48           #width:I
    .end local v49           #x1:I
    .end local v50           #x2:I
    .end local v51           #y1:I
    .end local v52           #y2:I
    :cond_1bb
    return-void
.end method

.method protected onMeasure(II)V
    .registers 12
    .parameter "widthSpec"
    .parameter "heightSpec"

    .prologue
    const/4 v8, 0x0

    .line 983
    invoke-direct {p0}, Landroid/widget/GridLayout;->consistencyCheck()V

    .line 987
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateValues()V

    .line 989
    const/4 v6, 0x1

    invoke-direct {p0, p1, p2, v6}, Landroid/widget/GridLayout;->measureChildrenWithMargins(IIZ)V

    .line 994
    iget v6, p0, Landroid/widget/GridLayout;->orientation:I

    if-nez v6, :cond_52

    .line 995
    iget-object v6, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v6, p1}, Landroid/widget/GridLayout$Axis;->getMeasure(I)I

    move-result v5

    .line 996
    .local v5, width:I
    invoke-direct {p0, p1, p2, v8}, Landroid/widget/GridLayout;->measureChildrenWithMargins(IIZ)V

    .line 997
    iget-object v6, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v6, p2}, Landroid/widget/GridLayout$Axis;->getMeasure(I)I

    move-result v1

    .line 1004
    .local v1, height:I
    :goto_1e
    invoke-virtual {p0}, Landroid/widget/GridLayout;->getPaddingLeft()I

    move-result v6

    invoke-virtual {p0}, Landroid/widget/GridLayout;->getPaddingRight()I

    move-result v7

    add-int v0, v6, v7

    .line 1005
    .local v0, hPadding:I
    invoke-virtual {p0}, Landroid/widget/GridLayout;->getPaddingTop()I

    move-result v6

    invoke-virtual {p0}, Landroid/widget/GridLayout;->getPaddingBottom()I

    move-result v7

    add-int v4, v6, v7

    .line 1007
    .local v4, vPadding:I
    add-int v6, v0, v5

    invoke-virtual {p0}, Landroid/widget/GridLayout;->getSuggestedMinimumWidth()I

    move-result v7

    invoke-static {v6, v7}, Ljava/lang/Math;->max(II)I

    move-result v3

    .line 1008
    .local v3, measuredWidth:I
    add-int v6, v4, v1

    invoke-virtual {p0}, Landroid/widget/GridLayout;->getSuggestedMinimumHeight()I

    move-result v7

    invoke-static {v6, v7}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 1010
    .local v2, measuredHeight:I
    invoke-static {v3, p1, v8}, Landroid/widget/GridLayout;->resolveSizeAndState(III)I

    move-result v6

    invoke-static {v2, p2, v8}, Landroid/widget/GridLayout;->resolveSizeAndState(III)I

    move-result v7

    invoke-virtual {p0, v6, v7}, Landroid/widget/GridLayout;->setMeasuredDimension(II)V

    .line 1013
    return-void

    .line 999
    .end local v0           #hPadding:I
    .end local v1           #height:I
    .end local v2           #measuredHeight:I
    .end local v3           #measuredWidth:I
    .end local v4           #vPadding:I
    .end local v5           #width:I
    :cond_52
    iget-object v6, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v6, p2}, Landroid/widget/GridLayout$Axis;->getMeasure(I)I

    move-result v1

    .line 1000
    .restart local v1       #height:I
    invoke-direct {p0, p1, p2, v8}, Landroid/widget/GridLayout;->measureChildrenWithMargins(IIZ)V

    .line 1001
    iget-object v6, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v6, p1}, Landroid/widget/GridLayout$Axis;->getMeasure(I)I

    move-result v5

    .restart local v5       #width:I
    goto :goto_1e
.end method

.method protected onSetLayoutParams(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .registers 4
    .parameter "child"
    .parameter "layoutParams"

    .prologue
    .line 759
    invoke-super {p0, p1, p2}, Landroid/view/ViewGroup;->onSetLayoutParams(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 761
    invoke-virtual {p0, p2}, Landroid/widget/GridLayout;->checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z

    move-result v0

    if-nez v0, :cond_f

    .line 762
    const-string/jumbo v0, "supplied LayoutParams are of the wrong type"

    invoke-static {v0}, Landroid/widget/GridLayout;->handleInvalidParams(Ljava/lang/String;)V

    .line 765
    :cond_f
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateStructure()V

    .line 766
    return-void
.end method

.method protected onViewAdded(Landroid/view/View;)V
    .registers 2
    .parameter "child"

    .prologue
    .line 894
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onViewAdded(Landroid/view/View;)V

    .line 895
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateStructure()V

    .line 896
    return-void
.end method

.method protected onViewRemoved(Landroid/view/View;)V
    .registers 2
    .parameter "child"

    .prologue
    .line 903
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onViewRemoved(Landroid/view/View;)V

    .line 904
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateStructure()V

    .line 905
    return-void
.end method

.method public requestLayout()V
    .registers 1

    .prologue
    .line 1033
    invoke-super {p0}, Landroid/view/ViewGroup;->requestLayout()V

    .line 1034
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateValues()V

    .line 1035
    return-void
.end method

.method public setAlignmentMode(I)V
    .registers 2
    .parameter "alignmentMode"

    .prologue
    .line 483
    iput p1, p0, Landroid/widget/GridLayout;->alignmentMode:I

    .line 484
    invoke-virtual {p0}, Landroid/widget/GridLayout;->requestLayout()V

    .line 485
    return-void
.end method

.method public setColumnCount(I)V
    .registers 3
    .parameter "columnCount"

    .prologue
    .line 401
    iget-object v0, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v0, p1}, Landroid/widget/GridLayout$Axis;->setCount(I)V

    .line 402
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateStructure()V

    .line 403
    invoke-virtual {p0}, Landroid/widget/GridLayout;->requestLayout()V

    .line 404
    return-void
.end method

.method public setColumnOrderPreserved(Z)V
    .registers 3
    .parameter "columnOrderPreserved"

    .prologue
    .line 554
    iget-object v0, p0, Landroid/widget/GridLayout;->horizontalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v0, p1}, Landroid/widget/GridLayout$Axis;->setOrderPreserved(Z)V

    .line 555
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateStructure()V

    .line 556
    invoke-virtual {p0}, Landroid/widget/GridLayout;->requestLayout()V

    .line 557
    return-void
.end method

.method public setOrientation(I)V
    .registers 3
    .parameter "orientation"

    .prologue
    .line 333
    iget v0, p0, Landroid/widget/GridLayout;->orientation:I

    if-eq v0, p1, :cond_c

    .line 334
    iput p1, p0, Landroid/widget/GridLayout;->orientation:I

    .line 335
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateStructure()V

    .line 336
    invoke-virtual {p0}, Landroid/widget/GridLayout;->requestLayout()V

    .line 338
    :cond_c
    return-void
.end method

.method public setRowCount(I)V
    .registers 3
    .parameter "rowCount"

    .prologue
    .line 368
    iget-object v0, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v0, p1}, Landroid/widget/GridLayout$Axis;->setCount(I)V

    .line 369
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateStructure()V

    .line 370
    invoke-virtual {p0}, Landroid/widget/GridLayout;->requestLayout()V

    .line 371
    return-void
.end method

.method public setRowOrderPreserved(Z)V
    .registers 3
    .parameter "rowOrderPreserved"

    .prologue
    .line 518
    iget-object v0, p0, Landroid/widget/GridLayout;->verticalAxis:Landroid/widget/GridLayout$Axis;

    invoke-virtual {v0, p1}, Landroid/widget/GridLayout$Axis;->setOrderPreserved(Z)V

    .line 519
    invoke-direct {p0}, Landroid/widget/GridLayout;->invalidateStructure()V

    .line 520
    invoke-virtual {p0}, Landroid/widget/GridLayout;->requestLayout()V

    .line 521
    return-void
.end method

.method public setUseDefaultMargins(Z)V
    .registers 2
    .parameter "useDefaultMargins"

    .prologue
    .line 447
    iput-boolean p1, p0, Landroid/widget/GridLayout;->useDefaultMargins:Z

    .line 448
    invoke-virtual {p0}, Landroid/widget/GridLayout;->requestLayout()V

    .line 449
    return-void
.end method
