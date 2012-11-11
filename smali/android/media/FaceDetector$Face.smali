.class public Landroid/media/FaceDetector$Face;
.super Ljava/lang/Object;
.source "FaceDetector.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/FaceDetector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Face"
.end annotation


# static fields
.field public static final CONFIDENCE_THRESHOLD:F = 0.4f

.field public static final EULER_X:I = 0x0

.field public static final EULER_Y:I = 0x1

.field public static final EULER_Z:I = 0x2


# instance fields
.field private mConfidence:F

.field private mEyesDist:F

.field private mMidPointX:F

.field private mMidPointY:F

.field private mPoseEulerX:F

.field private mPoseEulerY:F

.field private mPoseEulerZ:F

.field final synthetic this$0:Landroid/media/FaceDetector;


# direct methods
.method private constructor <init>(Landroid/media/FaceDetector;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/media/FaceDetector$Face;->this$0:Landroid/media/FaceDetector;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/media/FaceDetector;Landroid/media/FaceDetector$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/media/FaceDetector$Face;-><init>(Landroid/media/FaceDetector;)V

    return-void
.end method


# virtual methods
.method public confidence()F
    .registers 2

    .prologue
    iget v0, p0, Landroid/media/FaceDetector$Face;->mConfidence:F

    return v0
.end method

.method public eyesDistance()F
    .registers 2

    .prologue
    iget v0, p0, Landroid/media/FaceDetector$Face;->mEyesDist:F

    return v0
.end method

.method public getMidPoint(Landroid/graphics/PointF;)V
    .registers 4
    .parameter "point"

    .prologue
    iget v0, p0, Landroid/media/FaceDetector$Face;->mMidPointX:F

    iget v1, p0, Landroid/media/FaceDetector$Face;->mMidPointY:F

    invoke-virtual {p1, v0, v1}, Landroid/graphics/PointF;->set(FF)V

    return-void
.end method

.method public pose(I)F
    .registers 3
    .parameter "euler"

    .prologue
    if-nez p1, :cond_5

    iget v0, p0, Landroid/media/FaceDetector$Face;->mPoseEulerX:F

    :goto_4
    return v0

    :cond_5
    const/4 v0, 0x1

    if-ne p1, v0, :cond_b

    iget v0, p0, Landroid/media/FaceDetector$Face;->mPoseEulerY:F

    goto :goto_4

    :cond_b
    const/4 v0, 0x2

    if-ne p1, v0, :cond_11

    iget v0, p0, Landroid/media/FaceDetector$Face;->mPoseEulerZ:F

    goto :goto_4

    :cond_11
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0
.end method
