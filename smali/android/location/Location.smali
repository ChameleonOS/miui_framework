.class public Landroid/location/Location;
.super Ljava/lang/Object;
.source "Location.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/location/Location;",
            ">;"
        }
    .end annotation
.end field

.field public static final FORMAT_DEGREES:I = 0x0

.field public static final FORMAT_MINUTES:I = 0x1

.field public static final FORMAT_SECONDS:I = 0x2


# instance fields
.field private mAccuracy:F

.field private mAltitude:D

.field private mBearing:F

.field private mDistance:F

.field private mExtras:Landroid/os/Bundle;

.field private mHasAccuracy:Z

.field private mHasAltitude:Z

.field private mHasBearing:Z

.field private mHasSpeed:Z

.field private mInitialBearing:F

.field private mLat1:D

.field private mLat2:D

.field private mLatitude:D

.field private mLon1:D

.field private mLon2:D

.field private mLongitude:D

.field private mProvider:Ljava/lang/String;

.field private mResults:[F

.field private mSpeed:F

.field private mTime:J


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/location/Location$1;

    invoke-direct {v0}, Landroid/location/Location$1;-><init>()V

    sput-object v0, Landroid/location/Location;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/location/Location;)V
    .registers 8
    .parameter "l"

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    const-wide/16 v2, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/location/Location;->mTime:J

    iput-wide v2, p0, Landroid/location/Location;->mLatitude:D

    iput-wide v2, p0, Landroid/location/Location;->mLongitude:D

    iput-boolean v5, p0, Landroid/location/Location;->mHasAltitude:Z

    iput-wide v2, p0, Landroid/location/Location;->mAltitude:D

    iput-boolean v5, p0, Landroid/location/Location;->mHasSpeed:Z

    iput v4, p0, Landroid/location/Location;->mSpeed:F

    iput-boolean v5, p0, Landroid/location/Location;->mHasBearing:Z

    iput v4, p0, Landroid/location/Location;->mBearing:F

    iput-boolean v5, p0, Landroid/location/Location;->mHasAccuracy:Z

    iput v4, p0, Landroid/location/Location;->mAccuracy:F

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/location/Location;->mExtras:Landroid/os/Bundle;

    iput-wide v2, p0, Landroid/location/Location;->mLat1:D

    iput-wide v2, p0, Landroid/location/Location;->mLon1:D

    iput-wide v2, p0, Landroid/location/Location;->mLat2:D

    iput-wide v2, p0, Landroid/location/Location;->mLon2:D

    iput v4, p0, Landroid/location/Location;->mDistance:F

    iput v4, p0, Landroid/location/Location;->mInitialBearing:F

    const/4 v0, 0x2

    new-array v0, v0, [F

    iput-object v0, p0, Landroid/location/Location;->mResults:[F

    invoke-virtual {p0, p1}, Landroid/location/Location;->set(Landroid/location/Location;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 8
    .parameter "provider"

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    const-wide/16 v2, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/location/Location;->mTime:J

    iput-wide v2, p0, Landroid/location/Location;->mLatitude:D

    iput-wide v2, p0, Landroid/location/Location;->mLongitude:D

    iput-boolean v5, p0, Landroid/location/Location;->mHasAltitude:Z

    iput-wide v2, p0, Landroid/location/Location;->mAltitude:D

    iput-boolean v5, p0, Landroid/location/Location;->mHasSpeed:Z

    iput v4, p0, Landroid/location/Location;->mSpeed:F

    iput-boolean v5, p0, Landroid/location/Location;->mHasBearing:Z

    iput v4, p0, Landroid/location/Location;->mBearing:F

    iput-boolean v5, p0, Landroid/location/Location;->mHasAccuracy:Z

    iput v4, p0, Landroid/location/Location;->mAccuracy:F

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/location/Location;->mExtras:Landroid/os/Bundle;

    iput-wide v2, p0, Landroid/location/Location;->mLat1:D

    iput-wide v2, p0, Landroid/location/Location;->mLon1:D

    iput-wide v2, p0, Landroid/location/Location;->mLat2:D

    iput-wide v2, p0, Landroid/location/Location;->mLon2:D

    iput v4, p0, Landroid/location/Location;->mDistance:F

    iput v4, p0, Landroid/location/Location;->mInitialBearing:F

    const/4 v0, 0x2

    new-array v0, v0, [F

    iput-object v0, p0, Landroid/location/Location;->mResults:[F

    iput-object p1, p0, Landroid/location/Location;->mProvider:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$002(Landroid/location/Location;J)J
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-wide p1, p0, Landroid/location/Location;->mTime:J

    return-wide p1
.end method

.method static synthetic access$1002(Landroid/location/Location;F)F
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput p1, p0, Landroid/location/Location;->mAccuracy:F

    return p1
.end method

.method static synthetic access$102(Landroid/location/Location;D)D
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-wide p1, p0, Landroid/location/Location;->mLatitude:D

    return-wide p1
.end method

.method static synthetic access$1102(Landroid/location/Location;Landroid/os/Bundle;)Landroid/os/Bundle;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Landroid/location/Location;->mExtras:Landroid/os/Bundle;

    return-object p1
.end method

.method static synthetic access$202(Landroid/location/Location;D)D
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-wide p1, p0, Landroid/location/Location;->mLongitude:D

    return-wide p1
.end method

.method static synthetic access$302(Landroid/location/Location;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-boolean p1, p0, Landroid/location/Location;->mHasAltitude:Z

    return p1
.end method

.method static synthetic access$402(Landroid/location/Location;D)D
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-wide p1, p0, Landroid/location/Location;->mAltitude:D

    return-wide p1
.end method

.method static synthetic access$502(Landroid/location/Location;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-boolean p1, p0, Landroid/location/Location;->mHasSpeed:Z

    return p1
.end method

.method static synthetic access$602(Landroid/location/Location;F)F
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput p1, p0, Landroid/location/Location;->mSpeed:F

    return p1
.end method

.method static synthetic access$702(Landroid/location/Location;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-boolean p1, p0, Landroid/location/Location;->mHasBearing:Z

    return p1
.end method

.method static synthetic access$802(Landroid/location/Location;F)F
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput p1, p0, Landroid/location/Location;->mBearing:F

    return p1
.end method

.method static synthetic access$902(Landroid/location/Location;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-boolean p1, p0, Landroid/location/Location;->mHasAccuracy:Z

    return p1
.end method

.method private static computeDistanceAndBearing(DDDD[F)V
    .registers 96
    .parameter "lat1"
    .parameter "lon1"
    .parameter "lat2"
    .parameter "lon2"
    .parameter "results"

    .prologue
    const/16 v12, 0x14

    .local v12, MAXITERS:I
    const-wide v75, 0x3f91df46a2529d39L

    mul-double p0, p0, v75

    const-wide v75, 0x3f91df46a2529d39L

    mul-double p4, p4, v75

    const-wide v75, 0x3f91df46a2529d39L

    mul-double p2, p2, v75

    const-wide v75, 0x3f91df46a2529d39L

    mul-double p6, p6, v75

    const-wide v17, 0x415854a640000000L

    .local v17, a:D
    const-wide v21, 0x41583fc4141bda51L

    .local v21, b:D
    sub-double v75, v17, v21

    div-double v44, v75, v17

    .local v44, f:D
    mul-double v75, v17, v17

    mul-double v77, v21, v21

    sub-double v75, v75, v77

    mul-double v77, v21, v21

    div-double v19, v75, v77

    .local v19, aSqMinusBSqOverBSq:D
    sub-double v10, p6, p2

    .local v10, L:D
    const-wide/16 v4, 0x0

    .local v4, A:D
    const-wide/high16 v75, 0x3ff0

    sub-double v75, v75, v44

    invoke-static/range {p0 .. p1}, Ljava/lang/Math;->tan(D)D

    move-result-wide v77

    mul-double v75, v75, v77

    invoke-static/range {v75 .. v76}, Ljava/lang/Math;->atan(D)D

    move-result-wide v13

    .local v13, U1:D
    const-wide/high16 v75, 0x3ff0

    sub-double v75, v75, v44

    invoke-static/range {p4 .. p5}, Ljava/lang/Math;->tan(D)D

    move-result-wide v77

    mul-double v75, v75, v77

    invoke-static/range {v75 .. v76}, Ljava/lang/Math;->atan(D)D

    move-result-wide v15

    .local v15, U2:D
    invoke-static {v13, v14}, Ljava/lang/Math;->cos(D)D

    move-result-wide v33

    .local v33, cosU1:D
    invoke-static/range {v15 .. v16}, Ljava/lang/Math;->cos(D)D

    move-result-wide v37

    .local v37, cosU2:D
    invoke-static {v13, v14}, Ljava/lang/Math;->sin(D)D

    move-result-wide v63

    .local v63, sinU1:D
    invoke-static/range {v15 .. v16}, Ljava/lang/Math;->sin(D)D

    move-result-wide v67

    .local v67, sinU2:D
    mul-double v35, v33, v37

    .local v35, cosU1cosU2:D
    mul-double v65, v63, v67

    .local v65, sinU1sinU2:D
    const-wide/16 v53, 0x0

    .local v53, sigma:D
    const-wide/16 v41, 0x0

    .local v41, deltaSigma:D
    const-wide/16 v31, 0x0

    .local v31, cosSqAlpha:D
    const-wide/16 v23, 0x0

    .local v23, cos2SM:D
    const-wide/16 v29, 0x0

    .local v29, cosSigma:D
    const-wide/16 v59, 0x0

    .local v59, sinSigma:D
    const-wide/16 v27, 0x0

    .local v27, cosLambda:D
    const-wide/16 v57, 0x0

    .local v57, sinLambda:D
    move-wide/from16 v49, v10

    .local v49, lambda:D
    const/16 v48, 0x0

    .local v48, iter:I
    :goto_7e
    move/from16 v0, v48

    if-ge v0, v12, :cond_184

    move-wide/from16 v51, v49

    .local v51, lambdaOrig:D
    invoke-static/range {v49 .. v50}, Ljava/lang/Math;->cos(D)D

    move-result-wide v27

    invoke-static/range {v49 .. v50}, Ljava/lang/Math;->sin(D)D

    move-result-wide v57

    mul-double v69, v37, v57

    .local v69, t1:D
    mul-double v75, v33, v67

    mul-double v77, v63, v37

    mul-double v77, v77, v27

    sub-double v71, v75, v77

    .local v71, t2:D
    mul-double v75, v69, v69

    mul-double v77, v71, v71

    add-double v61, v75, v77

    .local v61, sinSqSigma:D
    invoke-static/range {v61 .. v62}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v59

    mul-double v75, v35, v27

    add-double v29, v65, v75

    move-wide/from16 v0, v59

    move-wide/from16 v2, v29

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide v53

    const-wide/16 v75, 0x0

    cmpl-double v75, v59, v75

    if-nez v75, :cond_203

    const-wide/16 v55, 0x0

    .local v55, sinAlpha:D
    :goto_b4
    const-wide/high16 v75, 0x3ff0

    mul-double v77, v55, v55

    sub-double v31, v75, v77

    const-wide/16 v75, 0x0

    cmpl-double v75, v31, v75

    if-nez v75, :cond_209

    const-wide/16 v23, 0x0

    :goto_c2
    mul-double v73, v31, v19

    .local v73, uSquared:D
    const-wide/high16 v75, 0x3ff0

    const-wide/high16 v77, 0x40d0

    div-double v77, v73, v77

    const-wide/high16 v79, 0x40b0

    const-wide/high16 v81, -0x3f78

    const-wide/high16 v83, 0x4074

    const-wide v85, 0x4065e00000000000L

    mul-double v85, v85, v73

    sub-double v83, v83, v85

    mul-double v83, v83, v73

    add-double v81, v81, v83

    mul-double v81, v81, v73

    add-double v79, v79, v81

    mul-double v77, v77, v79

    add-double v4, v75, v77

    const-wide/high16 v75, 0x4090

    div-double v75, v73, v75

    const-wide/high16 v77, 0x4070

    const-wide/high16 v79, -0x3fa0

    const-wide v81, 0x4052800000000000L

    const-wide v83, 0x4047800000000000L

    mul-double v83, v83, v73

    sub-double v81, v81, v83

    mul-double v81, v81, v73

    add-double v79, v79, v81

    mul-double v79, v79, v73

    add-double v77, v77, v79

    mul-double v6, v75, v77

    .local v6, B:D
    const-wide/high16 v75, 0x4030

    div-double v75, v44, v75

    mul-double v75, v75, v31

    const-wide/high16 v77, 0x4010

    const-wide/high16 v79, 0x4010

    const-wide/high16 v81, 0x4008

    mul-double v81, v81, v31

    sub-double v79, v79, v81

    mul-double v79, v79, v44

    add-double v77, v77, v79

    mul-double v8, v75, v77

    .local v8, C:D
    mul-double v25, v23, v23

    .local v25, cos2SMSq:D
    mul-double v75, v6, v59

    const-wide/high16 v77, 0x4010

    div-double v77, v6, v77

    const-wide/high16 v79, -0x4010

    const-wide/high16 v81, 0x4000

    mul-double v81, v81, v25

    add-double v79, v79, v81

    mul-double v79, v79, v29

    const-wide/high16 v81, 0x4018

    div-double v81, v6, v81

    mul-double v81, v81, v23

    const-wide/high16 v83, -0x3ff8

    const-wide/high16 v85, 0x4010

    mul-double v85, v85, v59

    mul-double v85, v85, v59

    add-double v83, v83, v85

    mul-double v81, v81, v83

    const-wide/high16 v83, -0x3ff8

    const-wide/high16 v85, 0x4010

    mul-double v85, v85, v25

    add-double v83, v83, v85

    mul-double v81, v81, v83

    sub-double v79, v79, v81

    mul-double v77, v77, v79

    add-double v77, v77, v23

    mul-double v41, v75, v77

    const-wide/high16 v75, 0x3ff0

    sub-double v75, v75, v8

    mul-double v75, v75, v44

    mul-double v75, v75, v55

    mul-double v77, v8, v59

    mul-double v79, v8, v29

    const-wide/high16 v81, -0x4010

    const-wide/high16 v83, 0x4000

    mul-double v83, v83, v23

    mul-double v83, v83, v23

    add-double v81, v81, v83

    mul-double v79, v79, v81

    add-double v79, v79, v23

    mul-double v77, v77, v79

    add-double v77, v77, v53

    mul-double v75, v75, v77

    add-double v49, v10, v75

    sub-double v75, v49, v51

    div-double v39, v75, v49

    .local v39, delta:D
    invoke-static/range {v39 .. v40}, Ljava/lang/Math;->abs(D)D

    move-result-wide v75

    const-wide v77, 0x3d719799812dea11L

    cmpg-double v75, v75, v77

    if-gez v75, :cond_213

    .end local v6           #B:D
    .end local v8           #C:D
    .end local v25           #cos2SMSq:D
    .end local v39           #delta:D
    .end local v51           #lambdaOrig:D
    .end local v55           #sinAlpha:D
    .end local v61           #sinSqSigma:D
    .end local v69           #t1:D
    .end local v71           #t2:D
    .end local v73           #uSquared:D
    :cond_184
    mul-double v75, v21, v4

    sub-double v77, v53, v41

    mul-double v75, v75, v77

    move-wide/from16 v0, v75

    double-to-float v0, v0

    move/from16 v43, v0

    .local v43, distance:F
    const/16 v75, 0x0

    aput v43, p8, v75

    move-object/from16 v0, p8

    array-length v0, v0

    move/from16 v75, v0

    const/16 v76, 0x1

    move/from16 v0, v75

    move/from16 v1, v76

    if-le v0, v1, :cond_202

    mul-double v75, v37, v57

    mul-double v77, v33, v67

    mul-double v79, v63, v37

    mul-double v79, v79, v27

    sub-double v77, v77, v79

    invoke-static/range {v75 .. v78}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide v75

    move-wide/from16 v0, v75

    double-to-float v0, v0

    move/from16 v47, v0

    .local v47, initialBearing:F
    move/from16 v0, v47

    float-to-double v0, v0

    move-wide/from16 v75, v0

    const-wide v77, 0x404ca5dc1a63c1f8L

    mul-double v75, v75, v77

    move-wide/from16 v0, v75

    double-to-float v0, v0

    move/from16 v47, v0

    const/16 v75, 0x1

    aput v47, p8, v75

    move-object/from16 v0, p8

    array-length v0, v0

    move/from16 v75, v0

    const/16 v76, 0x2

    move/from16 v0, v75

    move/from16 v1, v76

    if-le v0, v1, :cond_202

    mul-double v75, v33, v57

    move-wide/from16 v0, v63

    neg-double v0, v0

    move-wide/from16 v77, v0

    mul-double v77, v77, v37

    mul-double v79, v33, v67

    mul-double v79, v79, v27

    add-double v77, v77, v79

    invoke-static/range {v75 .. v78}, Ljava/lang/Math;->atan2(DD)D

    move-result-wide v75

    move-wide/from16 v0, v75

    double-to-float v0, v0

    move/from16 v46, v0

    .local v46, finalBearing:F
    move/from16 v0, v46

    float-to-double v0, v0

    move-wide/from16 v75, v0

    const-wide v77, 0x404ca5dc1a63c1f8L

    mul-double v75, v75, v77

    move-wide/from16 v0, v75

    double-to-float v0, v0

    move/from16 v46, v0

    const/16 v75, 0x2

    aput v46, p8, v75

    .end local v46           #finalBearing:F
    .end local v47           #initialBearing:F
    :cond_202
    return-void

    .end local v43           #distance:F
    .restart local v51       #lambdaOrig:D
    .restart local v61       #sinSqSigma:D
    .restart local v69       #t1:D
    .restart local v71       #t2:D
    :cond_203
    mul-double v75, v35, v57

    div-double v55, v75, v59

    goto/16 :goto_b4

    .restart local v55       #sinAlpha:D
    :cond_209
    const-wide/high16 v75, 0x4000

    mul-double v75, v75, v65

    div-double v75, v75, v31

    sub-double v23, v29, v75

    goto/16 :goto_c2

    .restart local v6       #B:D
    .restart local v8       #C:D
    .restart local v25       #cos2SMSq:D
    .restart local v39       #delta:D
    .restart local v73       #uSquared:D
    :cond_213
    add-int/lit8 v48, v48, 0x1

    goto/16 :goto_7e
.end method

.method public static convert(Ljava/lang/String;)D
    .registers 22
    .parameter "coordinate"

    .prologue
    if-nez p0, :cond_a

    new-instance v17, Ljava/lang/NullPointerException;

    const-string v18, "coordinate"

    invoke-direct/range {v17 .. v18}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v17

    :cond_a
    const/4 v8, 0x0

    .local v8, negative:Z
    const/16 v17, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v17

    const/16 v18, 0x2d

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_28

    const/16 v17, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    const/4 v8, 0x1

    :cond_28
    new-instance v13, Ljava/util/StringTokenizer;

    const-string v17, ":"

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v13, v0, v1}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .local v13, st:Ljava/util/StringTokenizer;
    invoke-virtual {v13}, Ljava/util/StringTokenizer;->countTokens()I

    move-result v14

    .local v14, tokens:I
    const/16 v17, 0x1

    move/from16 v0, v17

    if-ge v14, v0, :cond_5a

    new-instance v17, Ljava/lang/IllegalArgumentException;

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "coordinate="

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v17

    :cond_5a
    :try_start_5a
    invoke-virtual {v13}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v3

    .local v3, degrees:Ljava/lang/String;
    const/16 v17, 0x1

    move/from16 v0, v17

    if-ne v14, v0, :cond_71

    invoke-static {v3}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v15

    .local v15, val:D
    if-eqz v8, :cond_6e

    neg-double v0, v15

    move-wide/from16 v17, v0

    :goto_6d
    return-wide v17

    :cond_6e
    move-wide/from16 v17, v15

    goto :goto_6d

    .end local v15           #val:D
    :cond_71
    invoke-virtual {v13}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v7

    .local v7, minutes:Ljava/lang/String;
    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    .local v2, deg:I
    const-wide/16 v10, 0x0

    .local v10, sec:D
    invoke-virtual {v13}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v17

    if-eqz v17, :cond_f1

    invoke-static {v7}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v17

    move/from16 v0, v17

    int-to-double v5, v0

    .local v5, min:D
    invoke-virtual {v13}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v12

    .local v12, seconds:Ljava/lang/String;
    invoke-static {v12}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v10

    .end local v12           #seconds:Ljava/lang/String;
    :goto_90
    if-eqz v8, :cond_f6

    const/16 v17, 0xb4

    move/from16 v0, v17

    if-ne v2, v0, :cond_f6

    const-wide/16 v17, 0x0

    cmpl-double v17, v5, v17

    if-nez v17, :cond_f6

    const-wide/16 v17, 0x0

    cmpl-double v17, v10, v17

    if-nez v17, :cond_f6

    const/4 v4, 0x1

    .local v4, isNegative180:Z
    :goto_a5
    int-to-double v0, v2

    move-wide/from16 v17, v0

    const-wide/16 v19, 0x0

    cmpg-double v17, v17, v19

    if-ltz v17, :cond_b6

    const/16 v17, 0xb3

    move/from16 v0, v17

    if-le v2, v0, :cond_f8

    if-nez v4, :cond_f8

    :cond_b6
    new-instance v17, Ljava/lang/IllegalArgumentException;

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "coordinate="

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v17
    :try_end_d3
    .catch Ljava/lang/NumberFormatException; {:try_start_5a .. :try_end_d3} :catch_d3

    .end local v2           #deg:I
    .end local v3           #degrees:Ljava/lang/String;
    .end local v4           #isNegative180:Z
    .end local v5           #min:D
    .end local v7           #minutes:Ljava/lang/String;
    .end local v10           #sec:D
    :catch_d3
    move-exception v9

    .local v9, nfe:Ljava/lang/NumberFormatException;
    new-instance v17, Ljava/lang/IllegalArgumentException;

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "coordinate="

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v17

    .end local v9           #nfe:Ljava/lang/NumberFormatException;
    .restart local v2       #deg:I
    .restart local v3       #degrees:Ljava/lang/String;
    .restart local v7       #minutes:Ljava/lang/String;
    .restart local v10       #sec:D
    :cond_f1
    :try_start_f1
    invoke-static {v7}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v5

    .restart local v5       #min:D
    goto :goto_90

    :cond_f6
    const/4 v4, 0x0

    goto :goto_a5

    .restart local v4       #isNegative180:Z
    :cond_f8
    const-wide/16 v17, 0x0

    cmpg-double v17, v5, v17

    if-ltz v17, :cond_107

    const-wide v17, 0x404d800000000000L

    cmpl-double v17, v5, v17

    if-lez v17, :cond_124

    :cond_107
    new-instance v17, Ljava/lang/IllegalArgumentException;

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "coordinate="

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v17

    :cond_124
    const-wide/16 v17, 0x0

    cmpg-double v17, v10, v17

    if-ltz v17, :cond_133

    const-wide v17, 0x404d800000000000L

    cmpl-double v17, v10, v17

    if-lez v17, :cond_150

    :cond_133
    new-instance v17, Ljava/lang/IllegalArgumentException;

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "coordinate="

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v17
    :try_end_150
    .catch Ljava/lang/NumberFormatException; {:try_start_f1 .. :try_end_150} :catch_d3

    :cond_150
    int-to-double v0, v2

    move-wide/from16 v17, v0

    const-wide v19, 0x40ac200000000000L

    mul-double v17, v17, v19

    const-wide/high16 v19, 0x404e

    mul-double v19, v19, v5

    add-double v17, v17, v19

    add-double v15, v17, v10

    .restart local v15       #val:D
    const-wide v17, 0x40ac200000000000L

    div-double v15, v15, v17

    if-eqz v8, :cond_170

    neg-double v0, v15

    move-wide/from16 v17, v0

    goto/16 :goto_6d

    :cond_170
    move-wide/from16 v17, v15

    goto/16 :goto_6d
.end method

.method public static convert(DI)Ljava/lang/String;
    .registers 14
    .parameter "coordinate"
    .parameter "outputType"

    .prologue
    const/16 v10, 0x3a

    const/4 v9, 0x1

    const-wide/high16 v7, 0x404e

    const/4 v6, 0x2

    const-wide v4, -0x3f99800000000000L

    cmpg-double v4, p0, v4

    if-ltz v4, :cond_1e

    const-wide v4, 0x4066800000000000L

    cmpl-double v4, p0, v4

    if-gtz v4, :cond_1e

    invoke-static {p0, p1}, Ljava/lang/Double;->isNaN(D)Z

    move-result v4

    if-eqz v4, :cond_37

    :cond_1e
    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "coordinate="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0, p1}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    :cond_37
    if-eqz p2, :cond_57

    if-eq p2, v9, :cond_57

    if-eq p2, v6, :cond_57

    new-instance v4, Ljava/lang/IllegalArgumentException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "outputType="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    :cond_57
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .local v3, sb:Ljava/lang/StringBuilder;
    const-wide/16 v4, 0x0

    cmpg-double v4, p0, v4

    if-gez v4, :cond_68

    const/16 v4, 0x2d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    neg-double p0, p0

    :cond_68
    new-instance v1, Ljava/text/DecimalFormat;

    const-string v4, "###.#####"

    invoke-direct {v1, v4}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .local v1, df:Ljava/text/DecimalFormat;
    if-eq p2, v9, :cond_73

    if-ne p2, v6, :cond_91

    :cond_73
    invoke-static {p0, p1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    double-to-int v0, v4

    .local v0, degrees:I
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    int-to-double v4, v0

    sub-double/2addr p0, v4

    mul-double/2addr p0, v7

    if-ne p2, v6, :cond_91

    invoke-static {p0, p1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v4

    double-to-int v2, v4

    .local v2, minutes:I
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    int-to-double v4, v2

    sub-double/2addr p0, v4

    mul-double/2addr p0, v7

    .end local v0           #degrees:I
    .end local v2           #minutes:I
    :cond_91
    invoke-virtual {v1, p0, p1}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method public static distanceBetween(DDDD[F)V
    .registers 11
    .parameter "startLatitude"
    .parameter "startLongitude"
    .parameter "endLatitude"
    .parameter "endLongitude"
    .parameter "results"

    .prologue
    if-eqz p8, :cond_6

    array-length v0, p8

    const/4 v1, 0x1

    if-ge v0, v1, :cond_f

    :cond_6
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "results is null or has length < 1"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_f
    invoke-static/range {p0 .. p8}, Landroid/location/Location;->computeDistanceAndBearing(DDDD[F)V

    return-void
.end method


# virtual methods
.method public bearingTo(Landroid/location/Location;)F
    .registers 12
    .parameter "dest"

    .prologue
    iget-object v9, p0, Landroid/location/Location;->mResults:[F

    monitor-enter v9

    :try_start_3
    iget-wide v0, p0, Landroid/location/Location;->mLatitude:D

    iget-wide v2, p0, Landroid/location/Location;->mLat1:D

    cmpl-double v0, v0, v2

    if-nez v0, :cond_23

    iget-wide v0, p0, Landroid/location/Location;->mLongitude:D

    iget-wide v2, p0, Landroid/location/Location;->mLon1:D

    cmpl-double v0, v0, v2

    if-nez v0, :cond_23

    iget-wide v0, p1, Landroid/location/Location;->mLatitude:D

    iget-wide v2, p0, Landroid/location/Location;->mLat2:D

    cmpl-double v0, v0, v2

    if-nez v0, :cond_23

    iget-wide v0, p1, Landroid/location/Location;->mLongitude:D

    iget-wide v2, p0, Landroid/location/Location;->mLon2:D

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_4e

    :cond_23
    iget-wide v0, p0, Landroid/location/Location;->mLatitude:D

    iget-wide v2, p0, Landroid/location/Location;->mLongitude:D

    iget-wide v4, p1, Landroid/location/Location;->mLatitude:D

    iget-wide v6, p1, Landroid/location/Location;->mLongitude:D

    iget-object v8, p0, Landroid/location/Location;->mResults:[F

    invoke-static/range {v0 .. v8}, Landroid/location/Location;->computeDistanceAndBearing(DDDD[F)V

    iget-wide v0, p0, Landroid/location/Location;->mLatitude:D

    iput-wide v0, p0, Landroid/location/Location;->mLat1:D

    iget-wide v0, p0, Landroid/location/Location;->mLongitude:D

    iput-wide v0, p0, Landroid/location/Location;->mLon1:D

    iget-wide v0, p1, Landroid/location/Location;->mLatitude:D

    iput-wide v0, p0, Landroid/location/Location;->mLat2:D

    iget-wide v0, p1, Landroid/location/Location;->mLongitude:D

    iput-wide v0, p0, Landroid/location/Location;->mLon2:D

    iget-object v0, p0, Landroid/location/Location;->mResults:[F

    const/4 v1, 0x0

    aget v0, v0, v1

    iput v0, p0, Landroid/location/Location;->mDistance:F

    iget-object v0, p0, Landroid/location/Location;->mResults:[F

    const/4 v1, 0x1

    aget v0, v0, v1

    iput v0, p0, Landroid/location/Location;->mInitialBearing:F

    :cond_4e
    iget v0, p0, Landroid/location/Location;->mInitialBearing:F

    monitor-exit v9

    return v0

    :catchall_52
    move-exception v0

    monitor-exit v9
    :try_end_54
    .catchall {:try_start_3 .. :try_end_54} :catchall_52

    throw v0
.end method

.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public distanceTo(Landroid/location/Location;)F
    .registers 12
    .parameter "dest"

    .prologue
    iget-object v9, p0, Landroid/location/Location;->mResults:[F

    monitor-enter v9

    :try_start_3
    iget-wide v0, p0, Landroid/location/Location;->mLatitude:D

    iget-wide v2, p0, Landroid/location/Location;->mLat1:D

    cmpl-double v0, v0, v2

    if-nez v0, :cond_23

    iget-wide v0, p0, Landroid/location/Location;->mLongitude:D

    iget-wide v2, p0, Landroid/location/Location;->mLon1:D

    cmpl-double v0, v0, v2

    if-nez v0, :cond_23

    iget-wide v0, p1, Landroid/location/Location;->mLatitude:D

    iget-wide v2, p0, Landroid/location/Location;->mLat2:D

    cmpl-double v0, v0, v2

    if-nez v0, :cond_23

    iget-wide v0, p1, Landroid/location/Location;->mLongitude:D

    iget-wide v2, p0, Landroid/location/Location;->mLon2:D

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_4e

    :cond_23
    iget-wide v0, p0, Landroid/location/Location;->mLatitude:D

    iget-wide v2, p0, Landroid/location/Location;->mLongitude:D

    iget-wide v4, p1, Landroid/location/Location;->mLatitude:D

    iget-wide v6, p1, Landroid/location/Location;->mLongitude:D

    iget-object v8, p0, Landroid/location/Location;->mResults:[F

    invoke-static/range {v0 .. v8}, Landroid/location/Location;->computeDistanceAndBearing(DDDD[F)V

    iget-wide v0, p0, Landroid/location/Location;->mLatitude:D

    iput-wide v0, p0, Landroid/location/Location;->mLat1:D

    iget-wide v0, p0, Landroid/location/Location;->mLongitude:D

    iput-wide v0, p0, Landroid/location/Location;->mLon1:D

    iget-wide v0, p1, Landroid/location/Location;->mLatitude:D

    iput-wide v0, p0, Landroid/location/Location;->mLat2:D

    iget-wide v0, p1, Landroid/location/Location;->mLongitude:D

    iput-wide v0, p0, Landroid/location/Location;->mLon2:D

    iget-object v0, p0, Landroid/location/Location;->mResults:[F

    const/4 v1, 0x0

    aget v0, v0, v1

    iput v0, p0, Landroid/location/Location;->mDistance:F

    iget-object v0, p0, Landroid/location/Location;->mResults:[F

    const/4 v1, 0x1

    aget v0, v0, v1

    iput v0, p0, Landroid/location/Location;->mInitialBearing:F

    :cond_4e
    iget v0, p0, Landroid/location/Location;->mDistance:F

    monitor-exit v9

    return v0

    :catchall_52
    move-exception v0

    monitor-exit v9
    :try_end_54
    .catchall {:try_start_3 .. :try_end_54} :catchall_52

    throw v0
.end method

.method public dump(Landroid/util/Printer;Ljava/lang/String;)V
    .registers 6
    .parameter "pw"
    .parameter "prefix"

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "mProvider="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/location/Location;->mProvider:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " mTime="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/location/Location;->mTime:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "mLatitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/location/Location;->mLatitude:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " mLongitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/location/Location;->mLongitude:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "mHasAltitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/location/Location;->mHasAltitude:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " mAltitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/location/Location;->mAltitude:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "mHasSpeed="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/location/Location;->mHasSpeed:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " mSpeed="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/location/Location;->mSpeed:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "mHasBearing="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/location/Location;->mHasBearing:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " mBearing="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/location/Location;->mBearing:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "mHasAccuracy="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/location/Location;->mHasAccuracy:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " mAccuracy="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/location/Location;->mAccuracy:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "mExtras="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/location/Location;->mExtras:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/util/Printer;->println(Ljava/lang/String;)V

    return-void
.end method

.method public getAccuracy()F
    .registers 2

    .prologue
    iget v0, p0, Landroid/location/Location;->mAccuracy:F

    return v0
.end method

.method public getAltitude()D
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/location/Location;->mAltitude:D

    return-wide v0
.end method

.method public getBearing()F
    .registers 2

    .prologue
    iget v0, p0, Landroid/location/Location;->mBearing:F

    return v0
.end method

.method public getExtras()Landroid/os/Bundle;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/location/Location;->mExtras:Landroid/os/Bundle;

    return-object v0
.end method

.method public getLatitude()D
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/location/Location;->mLatitude:D

    return-wide v0
.end method

.method public getLongitude()D
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/location/Location;->mLongitude:D

    return-wide v0
.end method

.method public getProvider()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/location/Location;->mProvider:Ljava/lang/String;

    return-object v0
.end method

.method public getSpeed()F
    .registers 2

    .prologue
    iget v0, p0, Landroid/location/Location;->mSpeed:F

    return v0
.end method

.method public getTime()J
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/location/Location;->mTime:J

    return-wide v0
.end method

.method public hasAccuracy()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/location/Location;->mHasAccuracy:Z

    return v0
.end method

.method public hasAltitude()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/location/Location;->mHasAltitude:Z

    return v0
.end method

.method public hasBearing()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/location/Location;->mHasBearing:Z

    return v0
.end method

.method public hasSpeed()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/location/Location;->mHasSpeed:Z

    return v0
.end method

.method public removeAccuracy()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    iput v0, p0, Landroid/location/Location;->mAccuracy:F

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/location/Location;->mHasAccuracy:Z

    return-void
.end method

.method public removeAltitude()V
    .registers 3

    .prologue
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/location/Location;->mAltitude:D

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/location/Location;->mHasAltitude:Z

    return-void
.end method

.method public removeBearing()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    iput v0, p0, Landroid/location/Location;->mBearing:F

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/location/Location;->mHasBearing:Z

    return-void
.end method

.method public removeSpeed()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    iput v0, p0, Landroid/location/Location;->mSpeed:F

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/location/Location;->mHasSpeed:Z

    return-void
.end method

.method public reset()V
    .registers 8

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    const-wide/16 v3, 0x0

    const/4 v2, 0x0

    iput-object v6, p0, Landroid/location/Location;->mProvider:Ljava/lang/String;

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/location/Location;->mTime:J

    iput-wide v3, p0, Landroid/location/Location;->mLatitude:D

    iput-wide v3, p0, Landroid/location/Location;->mLongitude:D

    iput-boolean v2, p0, Landroid/location/Location;->mHasAltitude:Z

    iput-wide v3, p0, Landroid/location/Location;->mAltitude:D

    iput-boolean v2, p0, Landroid/location/Location;->mHasSpeed:Z

    iput v5, p0, Landroid/location/Location;->mSpeed:F

    iput-boolean v2, p0, Landroid/location/Location;->mHasBearing:Z

    iput v5, p0, Landroid/location/Location;->mBearing:F

    iput-boolean v2, p0, Landroid/location/Location;->mHasAccuracy:Z

    iput v5, p0, Landroid/location/Location;->mAccuracy:F

    iput-object v6, p0, Landroid/location/Location;->mExtras:Landroid/os/Bundle;

    return-void
.end method

.method public set(Landroid/location/Location;)V
    .registers 4
    .parameter "l"

    .prologue
    iget-object v0, p1, Landroid/location/Location;->mProvider:Ljava/lang/String;

    iput-object v0, p0, Landroid/location/Location;->mProvider:Ljava/lang/String;

    iget-wide v0, p1, Landroid/location/Location;->mTime:J

    iput-wide v0, p0, Landroid/location/Location;->mTime:J

    iget-wide v0, p1, Landroid/location/Location;->mLatitude:D

    iput-wide v0, p0, Landroid/location/Location;->mLatitude:D

    iget-wide v0, p1, Landroid/location/Location;->mLongitude:D

    iput-wide v0, p0, Landroid/location/Location;->mLongitude:D

    iget-boolean v0, p1, Landroid/location/Location;->mHasAltitude:Z

    iput-boolean v0, p0, Landroid/location/Location;->mHasAltitude:Z

    iget-wide v0, p1, Landroid/location/Location;->mAltitude:D

    iput-wide v0, p0, Landroid/location/Location;->mAltitude:D

    iget-boolean v0, p1, Landroid/location/Location;->mHasSpeed:Z

    iput-boolean v0, p0, Landroid/location/Location;->mHasSpeed:Z

    iget v0, p1, Landroid/location/Location;->mSpeed:F

    iput v0, p0, Landroid/location/Location;->mSpeed:F

    iget-boolean v0, p1, Landroid/location/Location;->mHasBearing:Z

    iput-boolean v0, p0, Landroid/location/Location;->mHasBearing:Z

    iget v0, p1, Landroid/location/Location;->mBearing:F

    iput v0, p0, Landroid/location/Location;->mBearing:F

    iget-boolean v0, p1, Landroid/location/Location;->mHasAccuracy:Z

    iput-boolean v0, p0, Landroid/location/Location;->mHasAccuracy:Z

    iget v0, p1, Landroid/location/Location;->mAccuracy:F

    iput v0, p0, Landroid/location/Location;->mAccuracy:F

    iget-object v0, p1, Landroid/location/Location;->mExtras:Landroid/os/Bundle;

    if-nez v0, :cond_38

    const/4 v0, 0x0

    :goto_35
    iput-object v0, p0, Landroid/location/Location;->mExtras:Landroid/os/Bundle;

    return-void

    :cond_38
    new-instance v0, Landroid/os/Bundle;

    iget-object v1, p1, Landroid/location/Location;->mExtras:Landroid/os/Bundle;

    invoke-direct {v0, v1}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    goto :goto_35
.end method

.method public setAccuracy(F)V
    .registers 3
    .parameter "accuracy"

    .prologue
    iput p1, p0, Landroid/location/Location;->mAccuracy:F

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/location/Location;->mHasAccuracy:Z

    return-void
.end method

.method public setAltitude(D)V
    .registers 4
    .parameter "altitude"

    .prologue
    iput-wide p1, p0, Landroid/location/Location;->mAltitude:D

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/location/Location;->mHasAltitude:Z

    return-void
.end method

.method public setBearing(F)V
    .registers 4
    .parameter "bearing"

    .prologue
    const/high16 v1, 0x43b4

    :goto_2
    const/4 v0, 0x0

    cmpg-float v0, p1, v0

    if-gez v0, :cond_9

    add-float/2addr p1, v1

    goto :goto_2

    :cond_9
    :goto_9
    cmpl-float v0, p1, v1

    if-ltz v0, :cond_f

    sub-float/2addr p1, v1

    goto :goto_9

    :cond_f
    iput p1, p0, Landroid/location/Location;->mBearing:F

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/location/Location;->mHasBearing:Z

    return-void
.end method

.method public setExtras(Landroid/os/Bundle;)V
    .registers 3
    .parameter "extras"

    .prologue
    if-nez p1, :cond_6

    const/4 v0, 0x0

    :goto_3
    iput-object v0, p0, Landroid/location/Location;->mExtras:Landroid/os/Bundle;

    return-void

    :cond_6
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0, p1}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    goto :goto_3
.end method

.method public setLatitude(D)V
    .registers 3
    .parameter "latitude"

    .prologue
    iput-wide p1, p0, Landroid/location/Location;->mLatitude:D

    return-void
.end method

.method public setLongitude(D)V
    .registers 3
    .parameter "longitude"

    .prologue
    iput-wide p1, p0, Landroid/location/Location;->mLongitude:D

    return-void
.end method

.method public setProvider(Ljava/lang/String;)V
    .registers 2
    .parameter "provider"

    .prologue
    iput-object p1, p0, Landroid/location/Location;->mProvider:Ljava/lang/String;

    return-void
.end method

.method public setSpeed(F)V
    .registers 3
    .parameter "speed"

    .prologue
    iput p1, p0, Landroid/location/Location;->mSpeed:F

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/location/Location;->mHasSpeed:Z

    return-void
.end method

.method public setTime(J)V
    .registers 3
    .parameter "time"

    .prologue
    iput-wide p1, p0, Landroid/location/Location;->mTime:J

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Location[mProvider="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/location/Location;->mProvider:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mTime="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/location/Location;->mTime:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mLatitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/location/Location;->mLatitude:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mLongitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/location/Location;->mLongitude:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mHasAltitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/location/Location;->mHasAltitude:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mAltitude="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/location/Location;->mAltitude:D

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mHasSpeed="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/location/Location;->mHasSpeed:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mSpeed="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/location/Location;->mSpeed:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mHasBearing="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/location/Location;->mHasBearing:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mBearing="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/location/Location;->mBearing:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mHasAccuracy="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/location/Location;->mHasAccuracy:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mAccuracy="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/location/Location;->mAccuracy:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mExtras="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/location/Location;->mExtras:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 8
    .parameter "parcel"
    .parameter "flags"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    iget-object v0, p0, Landroid/location/Location;->mProvider:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-wide v3, p0, Landroid/location/Location;->mTime:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    iget-wide v3, p0, Landroid/location/Location;->mLatitude:D

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeDouble(D)V

    iget-wide v3, p0, Landroid/location/Location;->mLongitude:D

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeDouble(D)V

    iget-boolean v0, p0, Landroid/location/Location;->mHasAltitude:Z

    if-eqz v0, :cond_4f

    move v0, v1

    :goto_1b
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-wide v3, p0, Landroid/location/Location;->mAltitude:D

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeDouble(D)V

    iget-boolean v0, p0, Landroid/location/Location;->mHasSpeed:Z

    if-eqz v0, :cond_51

    move v0, v1

    :goto_28
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/location/Location;->mSpeed:F

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeFloat(F)V

    iget-boolean v0, p0, Landroid/location/Location;->mHasBearing:Z

    if-eqz v0, :cond_53

    move v0, v1

    :goto_35
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/location/Location;->mBearing:F

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeFloat(F)V

    iget-boolean v0, p0, Landroid/location/Location;->mHasAccuracy:Z

    if-eqz v0, :cond_55

    :goto_41
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/location/Location;->mAccuracy:F

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeFloat(F)V

    iget-object v0, p0, Landroid/location/Location;->mExtras:Landroid/os/Bundle;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeBundle(Landroid/os/Bundle;)V

    return-void

    :cond_4f
    move v0, v2

    goto :goto_1b

    :cond_51
    move v0, v2

    goto :goto_28

    :cond_53
    move v0, v2

    goto :goto_35

    :cond_55
    move v1, v2

    goto :goto_41
.end method
