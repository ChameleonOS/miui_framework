.class Landroid/hardware/GeomagneticField$LegendreTable;
.super Ljava/lang/Object;
.source "GeomagneticField.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/hardware/GeomagneticField;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "LegendreTable"
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field public final mP:[[F

.field public final mPDeriv:[[F


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 335
    const-class v0, Landroid/hardware/GeomagneticField;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_c

    const/4 v0, 0x1

    :goto_9
    sput-boolean v0, Landroid/hardware/GeomagneticField$LegendreTable;->$assertionsDisabled:Z

    return-void

    :cond_c
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public constructor <init>(IF)V
    .registers 13
    .parameter "maxN"
    .parameter "thetaRad"

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 351
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 356
    float-to-double v5, p2

    invoke-static {v5, v6}, Ljava/lang/Math;->cos(D)D

    move-result-wide v5

    double-to-float v0, v5

    .line 357
    .local v0, cos:F
    float-to-double v5, p2

    invoke-static {v5, v6}, Ljava/lang/Math;->sin(D)D

    move-result-wide v5

    double-to-float v4, v5

    .line 359
    .local v4, sin:F
    add-int/lit8 v5, p1, 0x1

    new-array v5, v5, [[F

    iput-object v5, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    .line 360
    add-int/lit8 v5, p1, 0x1

    new-array v5, v5, [[F

    iput-object v5, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mPDeriv:[[F

    .line 361
    iget-object v5, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    new-array v6, v9, [F

    const/high16 v7, 0x3f80

    aput v7, v6, v8

    aput-object v6, v5, v8

    .line 362
    iget-object v5, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mPDeriv:[[F

    new-array v6, v9, [F

    const/4 v7, 0x0

    aput v7, v6, v8

    aput-object v6, v5, v8

    .line 363
    const/4 v3, 0x1

    .local v3, n:I
    :goto_31
    if-gt v3, p1, :cond_111

    .line 364
    iget-object v5, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    add-int/lit8 v6, v3, 0x1

    new-array v6, v6, [F

    aput-object v6, v5, v3

    .line 365
    iget-object v5, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mPDeriv:[[F

    add-int/lit8 v6, v3, 0x1

    new-array v6, v6, [F

    aput-object v6, v5, v3

    .line 366
    const/4 v2, 0x0

    .local v2, m:I
    :goto_44
    if-gt v2, v3, :cond_10d

    .line 367
    if-ne v3, v2, :cond_79

    .line 368
    iget-object v5, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    aget-object v5, v5, v3

    iget-object v6, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    add-int/lit8 v7, v3, -0x1

    aget-object v6, v6, v7

    add-int/lit8 v7, v2, -0x1

    aget v6, v6, v7

    mul-float/2addr v6, v4

    aput v6, v5, v2

    .line 369
    iget-object v5, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mPDeriv:[[F

    aget-object v5, v5, v3

    iget-object v6, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    add-int/lit8 v7, v3, -0x1

    aget-object v6, v6, v7

    add-int/lit8 v7, v2, -0x1

    aget v6, v6, v7

    mul-float/2addr v6, v0

    iget-object v7, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mPDeriv:[[F

    add-int/lit8 v8, v3, -0x1

    aget-object v7, v7, v8

    add-int/lit8 v8, v2, -0x1

    aget v7, v7, v8

    mul-float/2addr v7, v4

    add-float/2addr v6, v7

    aput v6, v5, v2

    .line 366
    :goto_76
    add-int/lit8 v2, v2, 0x1

    goto :goto_44

    .line 371
    :cond_79
    if-eq v3, v9, :cond_7f

    add-int/lit8 v5, v3, -0x1

    if-ne v2, v5, :cond_a9

    .line 372
    :cond_7f
    iget-object v5, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    aget-object v5, v5, v3

    iget-object v6, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    add-int/lit8 v7, v3, -0x1

    aget-object v6, v6, v7

    aget v6, v6, v2

    mul-float/2addr v6, v0

    aput v6, v5, v2

    .line 373
    iget-object v5, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mPDeriv:[[F

    aget-object v5, v5, v3

    neg-float v6, v4

    iget-object v7, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    add-int/lit8 v8, v3, -0x1

    aget-object v7, v7, v8

    aget v7, v7, v2

    mul-float/2addr v6, v7

    iget-object v7, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mPDeriv:[[F

    add-int/lit8 v8, v3, -0x1

    aget-object v7, v7, v8

    aget v7, v7, v2

    mul-float/2addr v7, v0

    add-float/2addr v6, v7

    aput v6, v5, v2

    goto :goto_76

    .line 376
    :cond_a9
    sget-boolean v5, Landroid/hardware/GeomagneticField$LegendreTable;->$assertionsDisabled:Z

    if-nez v5, :cond_b9

    if-le v3, v9, :cond_b3

    add-int/lit8 v5, v3, -0x1

    if-lt v2, v5, :cond_b9

    :cond_b3
    new-instance v5, Ljava/lang/AssertionError;

    invoke-direct {v5}, Ljava/lang/AssertionError;-><init>()V

    throw v5

    .line 377
    :cond_b9
    add-int/lit8 v5, v3, -0x1

    add-int/lit8 v6, v3, -0x1

    mul-int/2addr v5, v6

    mul-int v6, v2, v2

    sub-int/2addr v5, v6

    int-to-float v5, v5

    mul-int/lit8 v6, v3, 0x2

    add-int/lit8 v6, v6, -0x1

    mul-int/lit8 v7, v3, 0x2

    add-int/lit8 v7, v7, -0x3

    mul-int/2addr v6, v7

    int-to-float v6, v6

    div-float v1, v5, v6

    .line 379
    .local v1, k:F
    iget-object v5, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    aget-object v5, v5, v3

    iget-object v6, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    add-int/lit8 v7, v3, -0x1

    aget-object v6, v6, v7

    aget v6, v6, v2

    mul-float/2addr v6, v0

    iget-object v7, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    add-int/lit8 v8, v3, -0x2

    aget-object v7, v7, v8

    aget v7, v7, v2

    mul-float/2addr v7, v1

    sub-float/2addr v6, v7

    aput v6, v5, v2

    .line 380
    iget-object v5, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mPDeriv:[[F

    aget-object v5, v5, v3

    neg-float v6, v4

    iget-object v7, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mP:[[F

    add-int/lit8 v8, v3, -0x1

    aget-object v7, v7, v8

    aget v7, v7, v2

    mul-float/2addr v6, v7

    iget-object v7, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mPDeriv:[[F

    add-int/lit8 v8, v3, -0x1

    aget-object v7, v7, v8

    aget v7, v7, v2

    mul-float/2addr v7, v0

    add-float/2addr v6, v7

    iget-object v7, p0, Landroid/hardware/GeomagneticField$LegendreTable;->mPDeriv:[[F

    add-int/lit8 v8, v3, -0x2

    aget-object v7, v7, v8

    aget v7, v7, v2

    mul-float/2addr v7, v1

    sub-float/2addr v6, v7

    aput v6, v5, v2

    goto/16 :goto_76

    .line 363
    .end local v1           #k:F
    :cond_10d
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_31

    .line 385
    .end local v2           #m:I
    :cond_111
    return-void
.end method
