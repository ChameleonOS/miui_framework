.class public Landroid/media/CameraProfile;
.super Ljava/lang/Object;
.source "CameraProfile.java"


# static fields
.field public static final QUALITY_HIGH:I = 0x2

.field public static final QUALITY_LOW:I = 0x0

.field public static final QUALITY_MEDIUM:I = 0x1

.field private static final sCache:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "[I>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Landroid/media/CameraProfile;->sCache:Ljava/util/HashMap;

    const-string/jumbo v0, "media_jni"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    invoke-static {}, Landroid/media/CameraProfile;->native_init()V

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getImageEncodingQualityLevels(I)[I
    .registers 7
    .parameter "cameraId"

    .prologue
    invoke-static {p0}, Landroid/media/CameraProfile;->native_get_num_image_encoding_quality_levels(I)I

    move-result v2

    .local v2, nLevels:I
    const/4 v3, 0x3

    if-eq v2, v3, :cond_20

    new-instance v3, Ljava/lang/RuntimeException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unexpected Jpeg encoding quality levels "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    :cond_20
    new-array v1, v2, [I

    .local v1, levels:[I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_23
    if-ge v0, v2, :cond_2e

    invoke-static {p0, v0}, Landroid/media/CameraProfile;->native_get_image_encoding_quality_level(II)I

    move-result v3

    aput v3, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_23

    :cond_2e
    invoke-static {v1}, Ljava/util/Arrays;->sort([I)V

    return-object v1
.end method

.method public static getJpegEncodingQualityParameter(I)I
    .registers 5
    .parameter "quality"

    .prologue
    invoke-static {}, Landroid/hardware/Camera;->getNumberOfCameras()I

    move-result v2

    .local v2, numberOfCameras:I
    new-instance v0, Landroid/hardware/Camera$CameraInfo;

    invoke-direct {v0}, Landroid/hardware/Camera$CameraInfo;-><init>()V

    .local v0, cameraInfo:Landroid/hardware/Camera$CameraInfo;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_a
    if-ge v1, v2, :cond_1b

    invoke-static {v1, v0}, Landroid/hardware/Camera;->getCameraInfo(ILandroid/hardware/Camera$CameraInfo;)V

    iget v3, v0, Landroid/hardware/Camera$CameraInfo;->facing:I

    if-nez v3, :cond_18

    invoke-static {v1, p0}, Landroid/media/CameraProfile;->getJpegEncodingQualityParameter(II)I

    move-result v3

    :goto_17
    return v3

    :cond_18
    add-int/lit8 v1, v1, 0x1

    goto :goto_a

    :cond_1b
    const/4 v3, 0x0

    goto :goto_17
.end method

.method public static getJpegEncodingQualityParameter(II)I
    .registers 6
    .parameter "cameraId"
    .parameter "quality"

    .prologue
    if-ltz p1, :cond_5

    const/4 v1, 0x2

    if-le p1, v1, :cond_1e

    :cond_5
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unsupported quality level: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1e
    sget-object v2, Landroid/media/CameraProfile;->sCache:Ljava/util/HashMap;

    monitor-enter v2

    :try_start_21
    sget-object v1, Landroid/media/CameraProfile;->sCache:Ljava/util/HashMap;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [I

    .local v0, levels:[I
    if-nez v0, :cond_3c

    invoke-static {p0}, Landroid/media/CameraProfile;->getImageEncodingQualityLevels(I)[I

    move-result-object v0

    sget-object v1, Landroid/media/CameraProfile;->sCache:Ljava/util/HashMap;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3c
    aget v1, v0, p1

    monitor-exit v2

    return v1

    .end local v0           #levels:[I
    :catchall_40
    move-exception v1

    monitor-exit v2
    :try_end_42
    .catchall {:try_start_21 .. :try_end_42} :catchall_40

    throw v1
.end method

.method private static final native native_get_image_encoding_quality_level(II)I
.end method

.method private static final native native_get_num_image_encoding_quality_levels(I)I
.end method

.method private static final native native_init()V
.end method
