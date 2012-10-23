.class public final Landroid/view/InputDevice$MotionRange;
.super Ljava/lang/Object;
.source "InputDevice.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/InputDevice;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "MotionRange"
.end annotation


# instance fields
.field private mAxis:I

.field private mFlat:F

.field private mFuzz:F

.field private mMax:F

.field private mMin:F

.field private mSource:I


# direct methods
.method private constructor <init>(IIFFFF)V
    .registers 7
    .parameter "axis"
    .parameter "source"
    .parameter "min"
    .parameter "max"
    .parameter "flat"
    .parameter "fuzz"

    .prologue
    .line 611
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 612
    iput p1, p0, Landroid/view/InputDevice$MotionRange;->mAxis:I

    .line 613
    iput p2, p0, Landroid/view/InputDevice$MotionRange;->mSource:I

    .line 614
    iput p3, p0, Landroid/view/InputDevice$MotionRange;->mMin:F

    .line 615
    iput p4, p0, Landroid/view/InputDevice$MotionRange;->mMax:F

    .line 616
    iput p5, p0, Landroid/view/InputDevice$MotionRange;->mFlat:F

    .line 617
    iput p6, p0, Landroid/view/InputDevice$MotionRange;->mFuzz:F

    .line 618
    return-void
.end method

.method synthetic constructor <init>(IIFFFFLandroid/view/InputDevice$1;)V
    .registers 8
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"
    .parameter "x4"
    .parameter "x5"
    .parameter "x6"

    .prologue
    .line 603
    invoke-direct/range {p0 .. p6}, Landroid/view/InputDevice$MotionRange;-><init>(IIFFFF)V

    return-void
.end method

.method static synthetic access$100(Landroid/view/InputDevice$MotionRange;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 603
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mAxis:I

    return v0
.end method

.method static synthetic access$200(Landroid/view/InputDevice$MotionRange;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 603
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mSource:I

    return v0
.end method

.method static synthetic access$400(Landroid/view/InputDevice$MotionRange;)F
    .registers 2
    .parameter "x0"

    .prologue
    .line 603
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mMin:F

    return v0
.end method

.method static synthetic access$500(Landroid/view/InputDevice$MotionRange;)F
    .registers 2
    .parameter "x0"

    .prologue
    .line 603
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mMax:F

    return v0
.end method

.method static synthetic access$600(Landroid/view/InputDevice$MotionRange;)F
    .registers 2
    .parameter "x0"

    .prologue
    .line 603
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mFlat:F

    return v0
.end method

.method static synthetic access$700(Landroid/view/InputDevice$MotionRange;)F
    .registers 2
    .parameter "x0"

    .prologue
    .line 603
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mFuzz:F

    return v0
.end method


# virtual methods
.method public getAxis()I
    .registers 2

    .prologue
    .line 625
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mAxis:I

    return v0
.end method

.method public getFlat()F
    .registers 2

    .prologue
    .line 669
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mFlat:F

    return v0
.end method

.method public getFuzz()F
    .registers 2

    .prologue
    .line 681
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mFuzz:F

    return v0
.end method

.method public getMax()F
    .registers 2

    .prologue
    .line 649
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mMax:F

    return v0
.end method

.method public getMin()F
    .registers 2

    .prologue
    .line 641
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mMin:F

    return v0
.end method

.method public getRange()F
    .registers 3

    .prologue
    .line 657
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mMax:F

    iget v1, p0, Landroid/view/InputDevice$MotionRange;->mMin:F

    sub-float/2addr v0, v1

    return v0
.end method

.method public getSource()I
    .registers 2

    .prologue
    .line 633
    iget v0, p0, Landroid/view/InputDevice$MotionRange;->mSource:I

    return v0
.end method
