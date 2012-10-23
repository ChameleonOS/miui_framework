.class public Landroid/media/FaceDetector;
.super Ljava/lang/Object;
.source "FaceDetector.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/media/FaceDetector$1;,
        Landroid/media/FaceDetector$Face;
    }
.end annotation


# static fields
.field private static sInitialized:Z


# instance fields
.field private mBWBuffer:[B

.field private mDCR:I

.field private mFD:I

.field private mHeight:I

.field private mMaxFaces:I

.field private mSDK:I

.field private mWidth:I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 179
    const/4 v1, 0x0

    sput-boolean v1, Landroid/media/FaceDetector;->sInitialized:Z

    .line 181
    :try_start_3
    const-string v1, "FFTEm"

    invoke-static {v1}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 182
    invoke-static {}, Landroid/media/FaceDetector;->nativeClassInit()V

    .line 183
    const/4 v1, 0x1

    sput-boolean v1, Landroid/media/FaceDetector;->sInitialized:Z
    :try_end_e
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_3 .. :try_end_e} :catch_f

    .line 187
    .local v0, e:Ljava/lang/UnsatisfiedLinkError;
    :goto_e
    return-void

    .line 184
    .end local v0           #e:Ljava/lang/UnsatisfiedLinkError;
    :catch_f
    move-exception v0

    .line 185
    .restart local v0       #e:Ljava/lang/UnsatisfiedLinkError;
    const-string v1, "FFTEm"

    const-string v2, "face detection library not found!"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_e
.end method

.method public constructor <init>(III)V
    .registers 5
    .parameter "width"
    .parameter "height"
    .parameter "maxFaces"

    .prologue
    .line 113
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 114
    sget-boolean v0, Landroid/media/FaceDetector;->sInitialized:Z

    if-nez v0, :cond_8

    .line 122
    :goto_7
    return-void

    .line 117
    :cond_8
    invoke-direct {p0, p1, p2, p3}, Landroid/media/FaceDetector;->fft_initialize(III)I

    .line 118
    iput p1, p0, Landroid/media/FaceDetector;->mWidth:I

    .line 119
    iput p2, p0, Landroid/media/FaceDetector;->mHeight:I

    .line 120
    iput p3, p0, Landroid/media/FaceDetector;->mMaxFaces:I

    .line 121
    mul-int v0, p1, p2

    new-array v0, v0, [B

    iput-object v0, p0, Landroid/media/FaceDetector;->mBWBuffer:[B

    goto :goto_7
.end method

.method private native fft_destroy()V
.end method

.method private native fft_detect(Landroid/graphics/Bitmap;)I
.end method

.method private native fft_get_face(Landroid/media/FaceDetector$Face;I)V
.end method

.method private native fft_initialize(III)I
.end method

.method private static native nativeClassInit()V
.end method


# virtual methods
.method protected finalize()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 168
    invoke-direct {p0}, Landroid/media/FaceDetector;->fft_destroy()V

    .line 169
    return-void
.end method

.method public findFaces(Landroid/graphics/Bitmap;[Landroid/media/FaceDetector$Face;)I
    .registers 7
    .parameter "bitmap"
    .parameter "faces"

    .prologue
    .line 141
    sget-boolean v2, Landroid/media/FaceDetector;->sInitialized:Z

    if-nez v2, :cond_6

    .line 142
    const/4 v1, 0x0

    .line 161
    :cond_5
    return v1

    .line 144
    :cond_6
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    iget v3, p0, Landroid/media/FaceDetector;->mWidth:I

    if-ne v2, v3, :cond_16

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    iget v3, p0, Landroid/media/FaceDetector;->mHeight:I

    if-eq v2, v3, :cond_1e

    .line 145
    :cond_16
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "bitmap size doesn\'t match initialization"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 148
    :cond_1e
    array-length v2, p2

    iget v3, p0, Landroid/media/FaceDetector;->mMaxFaces:I

    if-ge v2, v3, :cond_2b

    .line 149
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "faces[] smaller than maxFaces"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 153
    :cond_2b
    invoke-direct {p0, p1}, Landroid/media/FaceDetector;->fft_detect(Landroid/graphics/Bitmap;)I

    move-result v1

    .line 154
    .local v1, numFaces:I
    iget v2, p0, Landroid/media/FaceDetector;->mMaxFaces:I

    if-lt v1, v2, :cond_35

    .line 155
    iget v1, p0, Landroid/media/FaceDetector;->mMaxFaces:I

    .line 156
    :cond_35
    const/4 v0, 0x0

    .local v0, i:I
    :goto_36
    if-ge v0, v1, :cond_5

    .line 157
    aget-object v2, p2, v0

    if-nez v2, :cond_44

    .line 158
    new-instance v2, Landroid/media/FaceDetector$Face;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v3}, Landroid/media/FaceDetector$Face;-><init>(Landroid/media/FaceDetector;Landroid/media/FaceDetector$1;)V

    aput-object v2, p2, v0

    .line 159
    :cond_44
    aget-object v2, p2, v0

    invoke-direct {p0, v2, v0}, Landroid/media/FaceDetector;->fft_get_face(Landroid/media/FaceDetector$Face;I)V

    .line 156
    add-int/lit8 v0, v0, 0x1

    goto :goto_36
.end method
