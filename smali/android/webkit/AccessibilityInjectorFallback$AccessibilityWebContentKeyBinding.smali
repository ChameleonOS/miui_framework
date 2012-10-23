.class final Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;
.super Ljava/lang/Object;
.source "AccessibilityInjectorFallback.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/AccessibilityInjectorFallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "AccessibilityWebContentKeyBinding"
.end annotation


# static fields
.field private static final ACTION_MASK:I = -0x1000000

.field private static final ACTION_OFFSET:I = 0x18

.field private static final FIRST_ARGUMENT_MASK:I = 0xff0000

.field private static final FIRST_ARGUMENT_OFFSET:I = 0x10

.field private static final KEY_CODE_MASK:J = 0xffffffffL

.field private static final KEY_CODE_OFFSET:I = 0x0

.field private static final MODIFIERS_MASK:J = 0xfffffff00000000L

.field private static final MODIFIERS_OFFSET:I = 0x20

.field private static final SECOND_ARGUMENT_MASK:I = 0xff00

.field private static final SECOND_ARGUMENT_OFFSET:I = 0x8

.field private static final THIRD_ARGUMENT_MASK:I = 0xff

.field private static final THIRD_ARGUMENT_OFFSET:I


# instance fields
.field private final mActionSequence:[I

.field private final mKeyCodeAndModifiers:J


# direct methods
.method public constructor <init>(J[I)V
    .registers 4
    .parameter "keyCodeAndModifiers"
    .parameter "actionSequence"

    .prologue
    .line 555
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 556
    iput-wide p1, p0, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->mKeyCodeAndModifiers:J

    .line 557
    iput-object p3, p0, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->mActionSequence:[I

    .line 558
    return-void
.end method


# virtual methods
.method public getAction(I)I
    .registers 3
    .parameter "index"

    .prologue
    .line 519
    iget-object v0, p0, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->mActionSequence:[I

    aget v0, v0, p1

    return v0
.end method

.method public getActionCode(I)I
    .registers 4
    .parameter "index"

    .prologue
    .line 526
    iget-object v0, p0, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->mActionSequence:[I

    aget v0, v0, p1

    const/high16 v1, -0x100

    and-int/2addr v0, v1

    shr-int/lit8 v0, v0, 0x18

    return v0
.end method

.method public getActionCount()I
    .registers 2

    .prologue
    .line 512
    iget-object v0, p0, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->mActionSequence:[I

    array-length v0, v0

    return v0
.end method

.method public getFirstArgument(I)I
    .registers 4
    .parameter "index"

    .prologue
    .line 533
    iget-object v0, p0, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->mActionSequence:[I

    aget v0, v0, p1

    const/high16 v1, 0xff

    and-int/2addr v0, v1

    shr-int/lit8 v0, v0, 0x10

    return v0
.end method

.method public getKeyCode()I
    .registers 5

    .prologue
    .line 498
    iget-wide v0, p0, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->mKeyCodeAndModifiers:J

    const-wide v2, 0xffffffffL

    and-long/2addr v0, v2

    const/4 v2, 0x0

    shr-long/2addr v0, v2

    long-to-int v0, v0

    return v0
.end method

.method public getModifiers()I
    .registers 5

    .prologue
    .line 505
    iget-wide v0, p0, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->mKeyCodeAndModifiers:J

    const-wide v2, 0xfffffff00000000L

    and-long/2addr v0, v2

    const/16 v2, 0x20

    shr-long/2addr v0, v2

    long-to-int v0, v0

    return v0
.end method

.method public getSecondArgument(I)I
    .registers 4
    .parameter "index"

    .prologue
    .line 540
    iget-object v0, p0, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->mActionSequence:[I

    aget v0, v0, p1

    const v1, 0xff00

    and-int/2addr v0, v1

    shr-int/lit8 v0, v0, 0x8

    return v0
.end method

.method public getThirdArgument(I)I
    .registers 3
    .parameter "index"

    .prologue
    .line 547
    iget-object v0, p0, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->mActionSequence:[I

    aget v0, v0, p1

    and-int/lit16 v0, v0, 0xff

    shr-int/lit8 v0, v0, 0x0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 5

    .prologue
    .line 562
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 563
    .local v0, builder:Ljava/lang/StringBuilder;
    const-string/jumbo v3, "modifiers: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 564
    invoke-virtual {p0}, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->getModifiers()I

    move-result v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 565
    const-string v3, ", keyCode: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 566
    invoke-virtual {p0}, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->getKeyCode()I

    move-result v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 567
    const-string v3, ", actions["

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 568
    const/4 v2, 0x0

    .local v2, i:I
    invoke-virtual {p0}, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->getActionCount()I

    move-result v1

    .local v1, count:I
    :goto_28
    if-ge v2, v1, :cond_6c

    .line 569
    const-string/jumbo v3, "{actionCode"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 570
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 571
    const-string v3, ": "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 572
    invoke-virtual {p0, v2}, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->getActionCode(I)I

    move-result v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 573
    const-string v3, ", firstArgument: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 574
    invoke-virtual {p0, v2}, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->getFirstArgument(I)I

    move-result v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 575
    const-string v3, ", secondArgument: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 576
    invoke-virtual {p0, v2}, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->getSecondArgument(I)I

    move-result v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 577
    const-string v3, ", thirdArgument: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 578
    invoke-virtual {p0, v2}, Landroid/webkit/AccessibilityInjectorFallback$AccessibilityWebContentKeyBinding;->getThirdArgument(I)I

    move-result v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 579
    const-string/jumbo v3, "}"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 568
    add-int/lit8 v2, v2, 0x1

    goto :goto_28

    .line 581
    :cond_6c
    const-string v3, "]"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 582
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method
