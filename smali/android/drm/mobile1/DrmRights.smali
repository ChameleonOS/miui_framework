.class public Landroid/drm/mobile1/DrmRights;
.super Ljava/lang/Object;
.source "DrmRights.java"


# static fields
.field public static final DRM_PERMISSION_DISPLAY:I = 0x2

.field public static final DRM_PERMISSION_EXECUTE:I = 0x3

.field public static final DRM_PERMISSION_PLAY:I = 0x1

.field public static final DRM_PERMISSION_PRINT:I = 0x4

.field private static final JNI_DRM_FAILURE:I = -0x1

.field private static final JNI_DRM_SUCCESS:I


# instance fields
.field private roId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 130
    :try_start_0
    const-string v1, "drm1_jni"

    invoke-static {v1}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_5} :catch_6

    .line 135
    .local v0, ule:Ljava/lang/UnsatisfiedLinkError;
    :goto_5
    return-void

    .line 132
    .end local v0           #ule:Ljava/lang/UnsatisfiedLinkError;
    :catch_6
    move-exception v0

    .line 133
    .restart local v0       #ule:Ljava/lang/UnsatisfiedLinkError;
    sget-object v1, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v2, "WARNING: Could not load libdrm1_jni.so"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_5
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    .line 62
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 56
    const-string v0, ""

    iput-object v0, p0, Landroid/drm/mobile1/DrmRights;->roId:Ljava/lang/String;

    .line 63
    return-void
.end method

.method private native nativeConsumeRights(I)I
.end method

.method private native nativeGetConstraintInfo(ILandroid/drm/mobile1/DrmConstraintInfo;)I
.end method


# virtual methods
.method public consumeRights(I)Z
    .registers 4
    .parameter "permission"

    .prologue
    .line 94
    invoke-direct {p0, p1}, Landroid/drm/mobile1/DrmRights;->nativeConsumeRights(I)I

    move-result v0

    .line 96
    .local v0, res:I
    const/4 v1, -0x1

    if-ne v1, v0, :cond_9

    .line 97
    const/4 v1, 0x0

    .line 99
    :goto_8
    return v1

    :cond_9
    const/4 v1, 0x1

    goto :goto_8
.end method

.method public getConstraint(I)Landroid/drm/mobile1/DrmConstraintInfo;
    .registers 5
    .parameter "permission"

    .prologue
    .line 73
    new-instance v0, Landroid/drm/mobile1/DrmConstraintInfo;

    invoke-direct {v0}, Landroid/drm/mobile1/DrmConstraintInfo;-><init>()V

    .line 76
    .local v0, c:Landroid/drm/mobile1/DrmConstraintInfo;
    invoke-direct {p0, p1, v0}, Landroid/drm/mobile1/DrmRights;->nativeGetConstraintInfo(ILandroid/drm/mobile1/DrmConstraintInfo;)I

    move-result v1

    .line 78
    .local v1, res:I
    const/4 v2, -0x1

    if-ne v2, v1, :cond_d

    .line 79
    const/4 v0, 0x0

    .line 81
    .end local v0           #c:Landroid/drm/mobile1/DrmConstraintInfo;
    :cond_d
    return-object v0
.end method
