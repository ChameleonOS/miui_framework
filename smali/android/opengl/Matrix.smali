.class public Landroid/opengl/Matrix;
.super Ljava/lang/Object;
.source "Matrix.java"


# static fields
.field private static final sTemp:[F


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/16 v0, 0x20

    new-array v0, v0, [F

    sput-object v0, Landroid/opengl/Matrix;->sTemp:[F

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static frustumM([FIFFFFFF)V
    .registers 19
    .parameter "m"
    .parameter "offset"
    .parameter "left"
    .parameter "right"
    .parameter "bottom"
    .parameter "top"
    .parameter "near"
    .parameter "far"

    .prologue
    cmpl-float v9, p2, p3

    if-nez v9, :cond_c

    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string v10, "left == right"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    :cond_c
    cmpl-float v9, p5, p4

    if-nez v9, :cond_19

    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v10, "top == bottom"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    :cond_19
    cmpl-float v9, p6, p7

    if-nez v9, :cond_26

    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v10, "near == far"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    :cond_26
    const/4 v9, 0x0

    cmpg-float v9, p6, v9

    if-gtz v9, :cond_34

    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v10, "near <= 0.0f"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    :cond_34
    const/4 v9, 0x0

    cmpg-float v9, p7, v9

    if-gtz v9, :cond_41

    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string v10, "far <= 0.0f"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    :cond_41
    const/high16 v9, 0x3f80

    sub-float v10, p3, p2

    div-float v6, v9, v10

    .local v6, r_width:F
    const/high16 v9, 0x3f80

    sub-float v10, p5, p4

    div-float v5, v9, v10

    .local v5, r_height:F
    const/high16 v9, 0x3f80

    sub-float v10, p6, p7

    div-float v4, v9, v10

    .local v4, r_depth:F
    const/high16 v9, 0x4000

    mul-float v10, p6, v6

    mul-float v7, v9, v10

    .local v7, x:F
    const/high16 v9, 0x4000

    mul-float v10, p6, v5

    mul-float v8, v9, v10

    .local v8, y:F
    const/high16 v9, 0x4000

    add-float v10, p3, p2

    mul-float/2addr v10, v6

    mul-float v0, v9, v10

    .local v0, A:F
    add-float v9, p5, p4

    mul-float v1, v9, v5

    .local v1, B:F
    add-float v9, p7, p6

    mul-float v2, v9, v4

    .local v2, C:F
    const/high16 v9, 0x4000

    mul-float v10, p7, p6

    mul-float/2addr v10, v4

    mul-float v3, v9, v10

    .local v3, D:F
    add-int/lit8 v9, p1, 0x0

    aput v7, p0, v9

    add-int/lit8 v9, p1, 0x5

    aput v8, p0, v9

    add-int/lit8 v9, p1, 0x8

    aput v0, p0, v9

    add-int/lit8 v9, p1, 0x9

    aput v1, p0, v9

    add-int/lit8 v9, p1, 0xa

    aput v2, p0, v9

    add-int/lit8 v9, p1, 0xe

    aput v3, p0, v9

    add-int/lit8 v9, p1, 0xb

    const/high16 v10, -0x4080

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x1

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x2

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x3

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x4

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x6

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x7

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0xc

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0xd

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0xf

    const/4 v10, 0x0

    aput v10, p0, v9

    return-void
.end method

.method public static invertM([FI[FI)Z
    .registers 65
    .parameter "mInv"
    .parameter "mInvOffset"
    .parameter "m"
    .parameter "mOffset"

    .prologue
    add-int/lit8 v58, p3, 0x0

    aget v42, p2, v58

    .local v42, src0:F
    add-int/lit8 v58, p3, 0x1

    aget v52, p2, v58

    .local v52, src4:F
    add-int/lit8 v58, p3, 0x2

    aget v56, p2, v58

    .local v56, src8:F
    add-int/lit8 v58, p3, 0x3

    aget v46, p2, v58

    .local v46, src12:F
    add-int/lit8 v58, p3, 0x4

    aget v43, p2, v58

    .local v43, src1:F
    add-int/lit8 v58, p3, 0x5

    aget v53, p2, v58

    .local v53, src5:F
    add-int/lit8 v58, p3, 0x6

    aget v57, p2, v58

    .local v57, src9:F
    add-int/lit8 v58, p3, 0x7

    aget v47, p2, v58

    .local v47, src13:F
    add-int/lit8 v58, p3, 0x8

    aget v50, p2, v58

    .local v50, src2:F
    add-int/lit8 v58, p3, 0x9

    aget v54, p2, v58

    .local v54, src6:F
    add-int/lit8 v58, p3, 0xa

    aget v44, p2, v58

    .local v44, src10:F
    add-int/lit8 v58, p3, 0xb

    aget v48, p2, v58

    .local v48, src14:F
    add-int/lit8 v58, p3, 0xc

    aget v51, p2, v58

    .local v51, src3:F
    add-int/lit8 v58, p3, 0xd

    aget v55, p2, v58

    .local v55, src7:F
    add-int/lit8 v58, p3, 0xe

    aget v45, p2, v58

    .local v45, src11:F
    add-int/lit8 v58, p3, 0xf

    aget v49, p2, v58

    .local v49, src15:F
    mul-float v0, v44, v49

    .local v0, atmp0:F
    mul-float v1, v45, v48

    .local v1, atmp1:F
    mul-float v4, v57, v49

    .local v4, atmp2:F
    mul-float v5, v45, v47

    .local v5, atmp3:F
    mul-float v6, v57, v48

    .local v6, atmp4:F
    mul-float v7, v44, v47

    .local v7, atmp5:F
    mul-float v8, v56, v49

    .local v8, atmp6:F
    mul-float v9, v45, v46

    .local v9, atmp7:F
    mul-float v10, v56, v48

    .local v10, atmp8:F
    mul-float v11, v44, v46

    .local v11, atmp9:F
    mul-float v2, v56, v47

    .local v2, atmp10:F
    mul-float v3, v57, v46

    .local v3, atmp11:F
    mul-float v58, v0, v53

    mul-float v59, v5, v54

    add-float v58, v58, v59

    mul-float v59, v6, v55

    add-float v58, v58, v59

    mul-float v59, v1, v53

    mul-float v60, v4, v54

    add-float v59, v59, v60

    mul-float v60, v7, v55

    add-float v59, v59, v60

    sub-float v25, v58, v59

    .local v25, dst0:F
    mul-float v58, v1, v52

    mul-float v59, v8, v54

    add-float v58, v58, v59

    mul-float v59, v11, v55

    add-float v58, v58, v59

    mul-float v59, v0, v52

    mul-float v60, v9, v54

    add-float v59, v59, v60

    mul-float v60, v10, v55

    add-float v59, v59, v60

    sub-float v26, v58, v59

    .local v26, dst1:F
    mul-float v58, v4, v52

    mul-float v59, v9, v53

    add-float v58, v58, v59

    mul-float v59, v2, v55

    add-float v58, v58, v59

    mul-float v59, v5, v52

    mul-float v60, v8, v53

    add-float v59, v59, v60

    mul-float v60, v3, v55

    add-float v59, v59, v60

    sub-float v33, v58, v59

    .local v33, dst2:F
    mul-float v58, v7, v52

    mul-float v59, v10, v53

    add-float v58, v58, v59

    mul-float v59, v3, v54

    add-float v58, v58, v59

    mul-float v59, v6, v52

    mul-float v60, v11, v53

    add-float v59, v59, v60

    mul-float v60, v2, v54

    add-float v59, v59, v60

    sub-float v34, v58, v59

    .local v34, dst3:F
    mul-float v58, v1, v43

    mul-float v59, v4, v50

    add-float v58, v58, v59

    mul-float v59, v7, v51

    add-float v58, v58, v59

    mul-float v59, v0, v43

    mul-float v60, v5, v50

    add-float v59, v59, v60

    mul-float v60, v6, v51

    add-float v59, v59, v60

    sub-float v35, v58, v59

    .local v35, dst4:F
    mul-float v58, v0, v42

    mul-float v59, v9, v50

    add-float v58, v58, v59

    mul-float v59, v10, v51

    add-float v58, v58, v59

    mul-float v59, v1, v42

    mul-float v60, v8, v50

    add-float v59, v59, v60

    mul-float v60, v11, v51

    add-float v59, v59, v60

    sub-float v36, v58, v59

    .local v36, dst5:F
    mul-float v58, v5, v42

    mul-float v59, v8, v43

    add-float v58, v58, v59

    mul-float v59, v3, v51

    add-float v58, v58, v59

    mul-float v59, v4, v42

    mul-float v60, v9, v43

    add-float v59, v59, v60

    mul-float v60, v2, v51

    add-float v59, v59, v60

    sub-float v37, v58, v59

    .local v37, dst6:F
    mul-float v58, v6, v42

    mul-float v59, v11, v43

    add-float v58, v58, v59

    mul-float v59, v2, v50

    add-float v58, v58, v59

    mul-float v59, v7, v42

    mul-float v60, v10, v43

    add-float v59, v59, v60

    mul-float v60, v3, v50

    add-float v59, v59, v60

    sub-float v38, v58, v59

    .local v38, dst7:F
    mul-float v12, v50, v55

    .local v12, btmp0:F
    mul-float v13, v51, v54

    .local v13, btmp1:F
    mul-float v16, v43, v55

    .local v16, btmp2:F
    mul-float v17, v51, v53

    .local v17, btmp3:F
    mul-float v18, v43, v54

    .local v18, btmp4:F
    mul-float v19, v50, v53

    .local v19, btmp5:F
    mul-float v20, v42, v55

    .local v20, btmp6:F
    mul-float v21, v51, v52

    .local v21, btmp7:F
    mul-float v22, v42, v54

    .local v22, btmp8:F
    mul-float v23, v50, v52

    .local v23, btmp9:F
    mul-float v14, v42, v53

    .local v14, btmp10:F
    mul-float v15, v43, v52

    .local v15, btmp11:F
    mul-float v58, v12, v47

    mul-float v59, v17, v48

    add-float v58, v58, v59

    mul-float v59, v18, v49

    add-float v58, v58, v59

    mul-float v59, v13, v47

    mul-float v60, v16, v48

    add-float v59, v59, v60

    mul-float v60, v19, v49

    add-float v59, v59, v60

    sub-float v39, v58, v59

    .local v39, dst8:F
    mul-float v58, v13, v46

    mul-float v59, v20, v48

    add-float v58, v58, v59

    mul-float v59, v23, v49

    add-float v58, v58, v59

    mul-float v59, v12, v46

    mul-float v60, v21, v48

    add-float v59, v59, v60

    mul-float v60, v22, v49

    add-float v59, v59, v60

    sub-float v40, v58, v59

    .local v40, dst9:F
    mul-float v58, v16, v46

    mul-float v59, v21, v47

    add-float v58, v58, v59

    mul-float v59, v14, v49

    add-float v58, v58, v59

    mul-float v59, v17, v46

    mul-float v60, v20, v47

    add-float v59, v59, v60

    mul-float v60, v15, v49

    add-float v59, v59, v60

    sub-float v27, v58, v59

    .local v27, dst10:F
    mul-float v58, v19, v46

    mul-float v59, v22, v47

    add-float v58, v58, v59

    mul-float v59, v15, v48

    add-float v58, v58, v59

    mul-float v59, v18, v46

    mul-float v60, v23, v47

    add-float v59, v59, v60

    mul-float v60, v14, v48

    add-float v59, v59, v60

    sub-float v28, v58, v59

    .local v28, dst11:F
    mul-float v58, v16, v44

    mul-float v59, v19, v45

    add-float v58, v58, v59

    mul-float v59, v13, v57

    add-float v58, v58, v59

    mul-float v59, v18, v45

    mul-float v60, v12, v57

    add-float v59, v59, v60

    mul-float v60, v17, v44

    add-float v59, v59, v60

    sub-float v29, v58, v59

    .local v29, dst12:F
    mul-float v58, v22, v45

    mul-float v59, v12, v56

    add-float v58, v58, v59

    mul-float v59, v21, v44

    add-float v58, v58, v59

    mul-float v59, v20, v44

    mul-float v60, v23, v45

    add-float v59, v59, v60

    mul-float v60, v13, v56

    add-float v59, v59, v60

    sub-float v30, v58, v59

    .local v30, dst13:F
    mul-float v58, v20, v57

    mul-float v59, v15, v45

    add-float v58, v58, v59

    mul-float v59, v17, v56

    add-float v58, v58, v59

    mul-float v59, v14, v45

    mul-float v60, v16, v56

    add-float v59, v59, v60

    mul-float v60, v21, v57

    add-float v59, v59, v60

    sub-float v31, v58, v59

    .local v31, dst14:F
    mul-float v58, v14, v44

    mul-float v59, v18, v56

    add-float v58, v58, v59

    mul-float v59, v23, v57

    add-float v58, v58, v59

    mul-float v59, v22, v57

    mul-float v60, v15, v44

    add-float v59, v59, v60

    mul-float v60, v19, v56

    add-float v59, v59, v60

    sub-float v32, v58, v59

    .local v32, dst15:F
    mul-float v58, v42, v25

    mul-float v59, v43, v26

    add-float v58, v58, v59

    mul-float v59, v50, v33

    add-float v58, v58, v59

    mul-float v59, v51, v34

    add-float v24, v58, v59

    .local v24, det:F
    const/16 v58, 0x0

    cmpl-float v58, v24, v58

    if-nez v58, :cond_1e7

    const/16 v58, 0x0

    :goto_1e6
    return v58

    :cond_1e7
    const/high16 v58, 0x3f80

    div-float v41, v58, v24

    .local v41, invdet:F
    mul-float v58, v25, v41

    aput v58, p0, p1

    add-int/lit8 v58, p1, 0x1

    mul-float v59, v26, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0x2

    mul-float v59, v33, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0x3

    mul-float v59, v34, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0x4

    mul-float v59, v35, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0x5

    mul-float v59, v36, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0x6

    mul-float v59, v37, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0x7

    mul-float v59, v38, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0x8

    mul-float v59, v39, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0x9

    mul-float v59, v40, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0xa

    mul-float v59, v27, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0xb

    mul-float v59, v28, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0xc

    mul-float v59, v29, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0xd

    mul-float v59, v30, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0xe

    mul-float v59, v31, v41

    aput v59, p0, v58

    add-int/lit8 v58, p1, 0xf

    mul-float v59, v32, v41

    aput v59, p0, v58

    const/16 v58, 0x1

    goto :goto_1e6
.end method

.method public static length(FFF)F
    .registers 5
    .parameter "x"
    .parameter "y"
    .parameter "z"

    .prologue
    mul-float v0, p0, p0

    mul-float v1, p1, p1

    add-float/2addr v0, v1

    mul-float v1, p2, p2

    add-float/2addr v0, v1

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    double-to-float v0, v0

    return v0
.end method

.method public static native multiplyMM([FI[FI[FI)V
.end method

.method public static native multiplyMV([FI[FI[FI)V
.end method

.method public static orthoM([FIFFFFFF)V
    .registers 19
    .parameter "m"
    .parameter "mOffset"
    .parameter "left"
    .parameter "right"
    .parameter "bottom"
    .parameter "top"
    .parameter "near"
    .parameter "far"

    .prologue
    cmpl-float v9, p2, p3

    if-nez v9, :cond_c

    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string v10, "left == right"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    :cond_c
    cmpl-float v9, p4, p5

    if-nez v9, :cond_18

    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string v10, "bottom == top"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    :cond_18
    cmpl-float v9, p6, p7

    if-nez v9, :cond_25

    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v10, "near == far"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    :cond_25
    const/high16 v9, 0x3f80

    sub-float v10, p3, p2

    div-float v2, v9, v10

    .local v2, r_width:F
    const/high16 v9, 0x3f80

    sub-float v10, p5, p4

    div-float v1, v9, v10

    .local v1, r_height:F
    const/high16 v9, 0x3f80

    sub-float v10, p7, p6

    div-float v0, v9, v10

    .local v0, r_depth:F
    const/high16 v9, 0x4000

    mul-float v6, v9, v2

    .local v6, x:F
    const/high16 v9, 0x4000

    mul-float v7, v9, v1

    .local v7, y:F
    const/high16 v9, -0x4000

    mul-float v8, v9, v0

    .local v8, z:F
    add-float v9, p3, p2

    neg-float v9, v9

    mul-float v3, v9, v2

    .local v3, tx:F
    add-float v9, p5, p4

    neg-float v9, v9

    mul-float v4, v9, v1

    .local v4, ty:F
    add-float v9, p7, p6

    neg-float v9, v9

    mul-float v5, v9, v0

    .local v5, tz:F
    add-int/lit8 v9, p1, 0x0

    aput v6, p0, v9

    add-int/lit8 v9, p1, 0x5

    aput v7, p0, v9

    add-int/lit8 v9, p1, 0xa

    aput v8, p0, v9

    add-int/lit8 v9, p1, 0xc

    aput v3, p0, v9

    add-int/lit8 v9, p1, 0xd

    aput v4, p0, v9

    add-int/lit8 v9, p1, 0xe

    aput v5, p0, v9

    add-int/lit8 v9, p1, 0xf

    const/high16 v10, 0x3f80

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x1

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x2

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x3

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x4

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x6

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x7

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x8

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0x9

    const/4 v10, 0x0

    aput v10, p0, v9

    add-int/lit8 v9, p1, 0xb

    const/4 v10, 0x0

    aput v10, p0, v9

    return-void
.end method

.method public static perspectiveM([FIFFFF)V
    .registers 14
    .parameter "m"
    .parameter "offset"
    .parameter "fovy"
    .parameter "aspect"
    .parameter "zNear"
    .parameter "zFar"

    .prologue
    const/high16 v7, 0x3f80

    const/4 v6, 0x0

    float-to-double v2, p2

    const-wide v4, 0x3f81df46a2529d39L

    mul-double/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Math;->tan(D)D

    move-result-wide v2

    double-to-float v2, v2

    div-float v0, v7, v2

    .local v0, f:F
    sub-float v2, p4, p5

    div-float v1, v7, v2

    .local v1, rangeReciprocal:F
    add-int/lit8 v2, p1, 0x0

    div-float v3, v0, p3

    aput v3, p0, v2

    add-int/lit8 v2, p1, 0x1

    aput v6, p0, v2

    add-int/lit8 v2, p1, 0x2

    aput v6, p0, v2

    add-int/lit8 v2, p1, 0x3

    aput v6, p0, v2

    add-int/lit8 v2, p1, 0x4

    aput v6, p0, v2

    add-int/lit8 v2, p1, 0x5

    aput v0, p0, v2

    add-int/lit8 v2, p1, 0x6

    aput v6, p0, v2

    add-int/lit8 v2, p1, 0x7

    aput v6, p0, v2

    add-int/lit8 v2, p1, 0x8

    aput v6, p0, v2

    add-int/lit8 v2, p1, 0x9

    aput v6, p0, v2

    add-int/lit8 v2, p1, 0xa

    add-float v3, p5, p4

    mul-float/2addr v3, v1

    aput v3, p0, v2

    add-int/lit8 v2, p1, 0xb

    const/high16 v3, -0x4080

    aput v3, p0, v2

    add-int/lit8 v2, p1, 0xc

    aput v6, p0, v2

    add-int/lit8 v2, p1, 0xd

    aput v6, p0, v2

    add-int/lit8 v2, p1, 0xe

    const/high16 v3, 0x4000

    mul-float/2addr v3, p5

    mul-float/2addr v3, p4

    mul-float/2addr v3, v1

    aput v3, p0, v2

    add-int/lit8 v2, p1, 0xf

    aput v6, p0, v2

    return-void
.end method

.method public static rotateM([FIFFFF)V
    .registers 13
    .parameter "m"
    .parameter "mOffset"
    .parameter "a"
    .parameter "x"
    .parameter "y"
    .parameter "z"

    .prologue
    sget-object v6, Landroid/opengl/Matrix;->sTemp:[F

    monitor-enter v6

    :try_start_3
    sget-object v0, Landroid/opengl/Matrix;->sTemp:[F

    const/4 v1, 0x0

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-static/range {v0 .. v5}, Landroid/opengl/Matrix;->setRotateM([FIFFFF)V

    sget-object v0, Landroid/opengl/Matrix;->sTemp:[F

    const/16 v1, 0x10

    sget-object v4, Landroid/opengl/Matrix;->sTemp:[F

    const/4 v5, 0x0

    move-object v2, p0

    move v3, p1

    invoke-static/range {v0 .. v5}, Landroid/opengl/Matrix;->multiplyMM([FI[FI[FI)V

    sget-object v0, Landroid/opengl/Matrix;->sTemp:[F

    const/16 v1, 0x10

    const/16 v2, 0x10

    invoke-static {v0, v1, p0, p1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    monitor-exit v6

    return-void

    :catchall_24
    move-exception v0

    monitor-exit v6
    :try_end_26
    .catchall {:try_start_3 .. :try_end_26} :catchall_24

    throw v0
.end method

.method public static rotateM([FI[FIFFFF)V
    .registers 15
    .parameter "rm"
    .parameter "rmOffset"
    .parameter "m"
    .parameter "mOffset"
    .parameter "a"
    .parameter "x"
    .parameter "y"
    .parameter "z"

    .prologue
    sget-object v6, Landroid/opengl/Matrix;->sTemp:[F

    monitor-enter v6

    :try_start_3
    sget-object v0, Landroid/opengl/Matrix;->sTemp:[F

    const/4 v1, 0x0

    move v2, p4

    move v3, p5

    move v4, p6

    move v5, p7

    invoke-static/range {v0 .. v5}, Landroid/opengl/Matrix;->setRotateM([FIFFFF)V

    sget-object v4, Landroid/opengl/Matrix;->sTemp:[F

    const/4 v5, 0x0

    move-object v0, p0

    move v1, p1

    move-object v2, p2

    move v3, p3

    invoke-static/range {v0 .. v5}, Landroid/opengl/Matrix;->multiplyMM([FI[FI[FI)V

    monitor-exit v6

    return-void

    :catchall_19
    move-exception v0

    monitor-exit v6
    :try_end_1b
    .catchall {:try_start_3 .. :try_end_1b} :catchall_19

    throw v0
.end method

.method public static scaleM([FIFFF)V
    .registers 9
    .parameter "m"
    .parameter "mOffset"
    .parameter "x"
    .parameter "y"
    .parameter "z"

    .prologue
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    const/4 v2, 0x4

    if-ge v0, v2, :cond_1c

    add-int v1, p1, v0

    .local v1, mi:I
    aget v2, p0, v1

    mul-float/2addr v2, p2

    aput v2, p0, v1

    add-int/lit8 v2, v1, 0x4

    aget v3, p0, v2

    mul-float/2addr v3, p3

    aput v3, p0, v2

    add-int/lit8 v2, v1, 0x8

    aget v3, p0, v2

    mul-float/2addr v3, p4

    aput v3, p0, v2

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .end local v1           #mi:I
    :cond_1c
    return-void
.end method

.method public static scaleM([FI[FIFFF)V
    .registers 12
    .parameter "sm"
    .parameter "smOffset"
    .parameter "m"
    .parameter "mOffset"
    .parameter "x"
    .parameter "y"
    .parameter "z"

    .prologue
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    const/4 v3, 0x4

    if-ge v0, v3, :cond_2a

    add-int v2, p1, v0

    .local v2, smi:I
    add-int v1, p3, v0

    .local v1, mi:I
    aget v3, p2, v1

    mul-float/2addr v3, p4

    aput v3, p0, v2

    add-int/lit8 v3, v2, 0x4

    add-int/lit8 v4, v1, 0x4

    aget v4, p2, v4

    mul-float/2addr v4, p5

    aput v4, p0, v3

    add-int/lit8 v3, v2, 0x8

    add-int/lit8 v4, v1, 0x8

    aget v4, p2, v4

    mul-float/2addr v4, p6

    aput v4, p0, v3

    add-int/lit8 v3, v2, 0xc

    add-int/lit8 v4, v1, 0xc

    aget v4, p2, v4

    aput v4, p0, v3

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .end local v1           #mi:I
    .end local v2           #smi:I
    :cond_2a
    return-void
.end method

.method public static setIdentityM([FI)V
    .registers 6
    .parameter "sm"
    .parameter "smOffset"

    .prologue
    const/16 v3, 0x10

    const/4 v0, 0x0

    .local v0, i:I
    :goto_3
    if-ge v0, v3, :cond_d

    add-int v1, p1, v0

    const/4 v2, 0x0

    aput v2, p0, v1

    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    :cond_d
    const/4 v0, 0x0

    :goto_e
    if-ge v0, v3, :cond_19

    add-int v1, p1, v0

    const/high16 v2, 0x3f80

    aput v2, p0, v1

    add-int/lit8 v0, v0, 0x5

    goto :goto_e

    :cond_19
    return-void
.end method

.method public static setLookAtM([FIFFFFFFFFF)V
    .registers 26
    .parameter "rm"
    .parameter "rmOffset"
    .parameter "eyeX"
    .parameter "eyeY"
    .parameter "eyeZ"
    .parameter "centerX"
    .parameter "centerY"
    .parameter "centerZ"
    .parameter "upX"
    .parameter "upY"
    .parameter "upZ"

    .prologue
    sub-float v1, p5, p2

    .local v1, fx:F
    sub-float v2, p6, p3

    .local v2, fy:F
    sub-float v3, p7, p4

    .local v3, fz:F
    const/high16 v12, 0x3f80

    invoke-static {v1, v2, v3}, Landroid/opengl/Matrix;->length(FFF)F

    move-result v13

    div-float v4, v12, v13

    .local v4, rlf:F
    mul-float/2addr v1, v4

    mul-float/2addr v2, v4

    mul-float/2addr v3, v4

    mul-float v12, v2, p10

    mul-float v13, v3, p9

    sub-float v6, v12, v13

    .local v6, sx:F
    mul-float v12, v3, p8

    mul-float v13, v1, p10

    sub-float v7, v12, v13

    .local v7, sy:F
    mul-float v12, v1, p9

    mul-float v13, v2, p8

    sub-float v8, v12, v13

    .local v8, sz:F
    const/high16 v12, 0x3f80

    invoke-static {v6, v7, v8}, Landroid/opengl/Matrix;->length(FFF)F

    move-result v13

    div-float v5, v12, v13

    .local v5, rls:F
    mul-float/2addr v6, v5

    mul-float/2addr v7, v5

    mul-float/2addr v8, v5

    mul-float v12, v7, v3

    mul-float v13, v8, v2

    sub-float v9, v12, v13

    .local v9, ux:F
    mul-float v12, v8, v1

    mul-float v13, v6, v3

    sub-float v10, v12, v13

    .local v10, uy:F
    mul-float v12, v6, v2

    mul-float v13, v7, v1

    sub-float v11, v12, v13

    .local v11, uz:F
    add-int/lit8 v12, p1, 0x0

    aput v6, p0, v12

    add-int/lit8 v12, p1, 0x1

    aput v9, p0, v12

    add-int/lit8 v12, p1, 0x2

    neg-float v13, v1

    aput v13, p0, v12

    add-int/lit8 v12, p1, 0x3

    const/4 v13, 0x0

    aput v13, p0, v12

    add-int/lit8 v12, p1, 0x4

    aput v7, p0, v12

    add-int/lit8 v12, p1, 0x5

    aput v10, p0, v12

    add-int/lit8 v12, p1, 0x6

    neg-float v13, v2

    aput v13, p0, v12

    add-int/lit8 v12, p1, 0x7

    const/4 v13, 0x0

    aput v13, p0, v12

    add-int/lit8 v12, p1, 0x8

    aput v8, p0, v12

    add-int/lit8 v12, p1, 0x9

    aput v11, p0, v12

    add-int/lit8 v12, p1, 0xa

    neg-float v13, v3

    aput v13, p0, v12

    add-int/lit8 v12, p1, 0xb

    const/4 v13, 0x0

    aput v13, p0, v12

    add-int/lit8 v12, p1, 0xc

    const/4 v13, 0x0

    aput v13, p0, v12

    add-int/lit8 v12, p1, 0xd

    const/4 v13, 0x0

    aput v13, p0, v12

    add-int/lit8 v12, p1, 0xe

    const/4 v13, 0x0

    aput v13, p0, v12

    add-int/lit8 v12, p1, 0xf

    const/high16 v13, 0x3f80

    aput v13, p0, v12

    move/from16 v0, p2

    neg-float v12, v0

    move/from16 v0, p3

    neg-float v13, v0

    move/from16 v0, p4

    neg-float v14, v0

    move/from16 v0, p1

    invoke-static {p0, v0, v12, v13, v14}, Landroid/opengl/Matrix;->translateM([FIFFF)V

    return-void
.end method

.method public static setRotateEulerM([FIFFF)V
    .registers 16
    .parameter "rm"
    .parameter "rmOffset"
    .parameter "x"
    .parameter "y"
    .parameter "z"

    .prologue
    const v8, 0x3c8efa35

    mul-float/2addr p2, v8

    const v8, 0x3c8efa35

    mul-float/2addr p3, v8

    const v8, 0x3c8efa35

    mul-float/2addr p4, v8

    float-to-double v8, p2

    invoke-static {v8, v9}, Ljava/lang/Math;->cos(D)D

    move-result-wide v8

    double-to-float v0, v8

    .local v0, cx:F
    float-to-double v8, p2

    invoke-static {v8, v9}, Ljava/lang/Math;->sin(D)D

    move-result-wide v8

    double-to-float v4, v8

    .local v4, sx:F
    float-to-double v8, p3

    invoke-static {v8, v9}, Ljava/lang/Math;->cos(D)D

    move-result-wide v8

    double-to-float v2, v8

    .local v2, cy:F
    float-to-double v8, p3

    invoke-static {v8, v9}, Ljava/lang/Math;->sin(D)D

    move-result-wide v8

    double-to-float v6, v8

    .local v6, sy:F
    float-to-double v8, p4

    invoke-static {v8, v9}, Ljava/lang/Math;->cos(D)D

    move-result-wide v8

    double-to-float v3, v8

    .local v3, cz:F
    float-to-double v8, p4

    invoke-static {v8, v9}, Ljava/lang/Math;->sin(D)D

    move-result-wide v8

    double-to-float v7, v8

    .local v7, sz:F
    mul-float v1, v0, v6

    .local v1, cxsy:F
    mul-float v5, v4, v6

    .local v5, sxsy:F
    add-int/lit8 v8, p1, 0x0

    mul-float v9, v2, v3

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0x1

    neg-float v9, v2

    mul-float/2addr v9, v7

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0x2

    aput v6, p0, v8

    add-int/lit8 v8, p1, 0x3

    const/4 v9, 0x0

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0x4

    mul-float v9, v1, v3

    mul-float v10, v0, v7

    add-float/2addr v9, v10

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0x5

    neg-float v9, v1

    mul-float/2addr v9, v7

    mul-float v10, v0, v3

    add-float/2addr v9, v10

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0x6

    neg-float v9, v4

    mul-float/2addr v9, v2

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0x7

    const/4 v9, 0x0

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0x8

    neg-float v9, v5

    mul-float/2addr v9, v3

    mul-float v10, v4, v7

    add-float/2addr v9, v10

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0x9

    mul-float v9, v5, v7

    mul-float v10, v4, v3

    add-float/2addr v9, v10

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0xa

    mul-float v9, v0, v2

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0xb

    const/4 v9, 0x0

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0xc

    const/4 v9, 0x0

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0xd

    const/4 v9, 0x0

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0xe

    const/4 v9, 0x0

    aput v9, p0, v8

    add-int/lit8 v8, p1, 0xf

    const/high16 v9, 0x3f80

    aput v9, p0, v8

    return-void
.end method

.method public static setRotateM([FIFFFF)V
    .registers 19
    .parameter "rm"
    .parameter "rmOffset"
    .parameter "a"
    .parameter "x"
    .parameter "y"
    .parameter "z"

    .prologue
    add-int/lit8 v11, p1, 0x3

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x7

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0xb

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0xc

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0xd

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0xe

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0xf

    const/high16 v12, 0x3f80

    aput v12, p0, v11

    const v11, 0x3c8efa35

    mul-float/2addr p2, v11

    float-to-double v11, p2

    invoke-static {v11, v12}, Ljava/lang/Math;->sin(D)D

    move-result-wide v11

    double-to-float v4, v11

    .local v4, s:F
    float-to-double v11, p2

    invoke-static {v11, v12}, Ljava/lang/Math;->cos(D)D

    move-result-wide v11

    double-to-float v0, v11

    .local v0, c:F
    const/high16 v11, 0x3f80

    cmpl-float v11, v11, p3

    if-nez v11, :cond_70

    const/4 v11, 0x0

    cmpl-float v11, v11, p4

    if-nez v11, :cond_70

    const/4 v11, 0x0

    cmpl-float v11, v11, p5

    if-nez v11, :cond_70

    add-int/lit8 v11, p1, 0x5

    aput v0, p0, v11

    add-int/lit8 v11, p1, 0xa

    aput v0, p0, v11

    add-int/lit8 v11, p1, 0x6

    aput v4, p0, v11

    add-int/lit8 v11, p1, 0x9

    neg-float v12, v4

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x1

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x2

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x4

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x8

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x0

    const/high16 v12, 0x3f80

    aput v12, p0, v11

    :goto_6f
    return-void

    :cond_70
    const/4 v11, 0x0

    cmpl-float v11, v11, p3

    if-nez v11, :cond_ac

    const/high16 v11, 0x3f80

    cmpl-float v11, v11, p4

    if-nez v11, :cond_ac

    const/4 v11, 0x0

    cmpl-float v11, v11, p5

    if-nez v11, :cond_ac

    add-int/lit8 v11, p1, 0x0

    aput v0, p0, v11

    add-int/lit8 v11, p1, 0xa

    aput v0, p0, v11

    add-int/lit8 v11, p1, 0x8

    aput v4, p0, v11

    add-int/lit8 v11, p1, 0x2

    neg-float v12, v4

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x1

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x4

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x6

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x9

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x5

    const/high16 v12, 0x3f80

    aput v12, p0, v11

    goto :goto_6f

    :cond_ac
    const/4 v11, 0x0

    cmpl-float v11, v11, p3

    if-nez v11, :cond_e8

    const/4 v11, 0x0

    cmpl-float v11, v11, p4

    if-nez v11, :cond_e8

    const/high16 v11, 0x3f80

    cmpl-float v11, v11, p5

    if-nez v11, :cond_e8

    add-int/lit8 v11, p1, 0x0

    aput v0, p0, v11

    add-int/lit8 v11, p1, 0x5

    aput v0, p0, v11

    add-int/lit8 v11, p1, 0x1

    aput v4, p0, v11

    add-int/lit8 v11, p1, 0x4

    neg-float v12, v4

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x2

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x6

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x8

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x9

    const/4 v12, 0x0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0xa

    const/high16 v12, 0x3f80

    aput v12, p0, v11

    goto :goto_6f

    :cond_e8
    invoke-static/range {p3 .. p5}, Landroid/opengl/Matrix;->length(FFF)F

    move-result v1

    .local v1, len:F
    const/high16 v11, 0x3f80

    cmpl-float v11, v11, v1

    if-eqz v11, :cond_fc

    const/high16 v11, 0x3f80

    div-float v3, v11, v1

    .local v3, recipLen:F
    mul-float p3, p3, v3

    mul-float p4, p4, v3

    mul-float p5, p5, v3

    .end local v3           #recipLen:F
    :cond_fc
    const/high16 v11, 0x3f80

    sub-float v2, v11, v0

    .local v2, nc:F
    mul-float v6, p3, p4

    .local v6, xy:F
    mul-float v8, p4, p5

    .local v8, yz:F
    mul-float v10, p5, p3

    .local v10, zx:F
    mul-float v5, p3, v4

    .local v5, xs:F
    mul-float v7, p4, v4

    .local v7, ys:F
    mul-float v9, p5, v4

    .local v9, zs:F
    add-int/lit8 v11, p1, 0x0

    mul-float v12, p3, p3

    mul-float/2addr v12, v2

    add-float/2addr v12, v0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x4

    mul-float v12, v6, v2

    sub-float/2addr v12, v9

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x8

    mul-float v12, v10, v2

    add-float/2addr v12, v7

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x1

    mul-float v12, v6, v2

    add-float/2addr v12, v9

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x5

    mul-float v12, p4, p4

    mul-float/2addr v12, v2

    add-float/2addr v12, v0

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x9

    mul-float v12, v8, v2

    sub-float/2addr v12, v5

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x2

    mul-float v12, v10, v2

    sub-float/2addr v12, v7

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0x6

    mul-float v12, v8, v2

    add-float/2addr v12, v5

    aput v12, p0, v11

    add-int/lit8 v11, p1, 0xa

    mul-float v12, p5, p5

    mul-float/2addr v12, v2

    add-float/2addr v12, v0

    aput v12, p0, v11

    goto/16 :goto_6f
.end method

.method public static translateM([FIFFF)V
    .registers 11
    .parameter "m"
    .parameter "mOffset"
    .parameter "x"
    .parameter "y"
    .parameter "z"

    .prologue
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    const/4 v2, 0x4

    if-ge v0, v2, :cond_1f

    add-int v1, p1, v0

    .local v1, mi:I
    add-int/lit8 v2, v1, 0xc

    aget v3, p0, v2

    aget v4, p0, v1

    mul-float/2addr v4, p2

    add-int/lit8 v5, v1, 0x4

    aget v5, p0, v5

    mul-float/2addr v5, p3

    add-float/2addr v4, v5

    add-int/lit8 v5, v1, 0x8

    aget v5, p0, v5

    mul-float/2addr v5, p4

    add-float/2addr v4, v5

    add-float/2addr v3, v4

    aput v3, p0, v2

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .end local v1           #mi:I
    :cond_1f
    return-void
.end method

.method public static translateM([FI[FIFFF)V
    .registers 13
    .parameter "tm"
    .parameter "tmOffset"
    .parameter "m"
    .parameter "mOffset"
    .parameter "x"
    .parameter "y"
    .parameter "z"

    .prologue
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    const/16 v3, 0xc

    if-ge v0, v3, :cond_10

    add-int v3, p1, v0

    add-int v4, p3, v0

    aget v4, p2, v4

    aput v4, p0, v3

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_10
    const/4 v0, 0x0

    :goto_11
    const/4 v3, 0x4

    if-ge v0, v3, :cond_33

    add-int v2, p1, v0

    .local v2, tmi:I
    add-int v1, p3, v0

    .local v1, mi:I
    add-int/lit8 v3, v2, 0xc

    aget v4, p2, v1

    mul-float/2addr v4, p4

    add-int/lit8 v5, v1, 0x4

    aget v5, p2, v5

    mul-float/2addr v5, p5

    add-float/2addr v4, v5

    add-int/lit8 v5, v1, 0x8

    aget v5, p2, v5

    mul-float/2addr v5, p6

    add-float/2addr v4, v5

    add-int/lit8 v5, v1, 0xc

    aget v5, p2, v5

    add-float/2addr v4, v5

    aput v4, p0, v3

    add-int/lit8 v0, v0, 0x1

    goto :goto_11

    .end local v1           #mi:I
    .end local v2           #tmi:I
    :cond_33
    return-void
.end method

.method public static transposeM([FI[FI)V
    .registers 8
    .parameter "mTrans"
    .parameter "mTransOffset"
    .parameter "m"
    .parameter "mOffset"

    .prologue
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    const/4 v2, 0x4

    if-ge v0, v2, :cond_2c

    mul-int/lit8 v2, v0, 0x4

    add-int v1, v2, p3

    .local v1, mBase:I
    add-int v2, v0, p1

    aget v3, p2, v1

    aput v3, p0, v2

    add-int/lit8 v2, v0, 0x4

    add-int/2addr v2, p1

    add-int/lit8 v3, v1, 0x1

    aget v3, p2, v3

    aput v3, p0, v2

    add-int/lit8 v2, v0, 0x8

    add-int/2addr v2, p1

    add-int/lit8 v3, v1, 0x2

    aget v3, p2, v3

    aput v3, p0, v2

    add-int/lit8 v2, v0, 0xc

    add-int/2addr v2, p1

    add-int/lit8 v3, v1, 0x3

    aget v3, p2, v3

    aput v3, p0, v2

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .end local v1           #mBase:I
    :cond_2c
    return-void
.end method
