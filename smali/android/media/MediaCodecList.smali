.class public final Landroid/media/MediaCodecList;
.super Ljava/lang/Object;
.source "MediaCodecList.java"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 54
    const-string/jumbo v0, "media_jni"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 55
    invoke-static {}, Landroid/media/MediaCodecList;->native_init()V

    .line 56
    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 51
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static final native getCodecCapabilities(ILjava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;
.end method

.method public static final native getCodecCount()I
.end method

.method public static final getCodecInfoAt(I)Landroid/media/MediaCodecInfo;
    .registers 2
    .parameter "index"

    .prologue
    .line 33
    if-ltz p0, :cond_8

    invoke-static {}, Landroid/media/MediaCodecList;->getCodecCount()I

    move-result v0

    if-le p0, v0, :cond_e

    .line 34
    :cond_8
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 37
    :cond_e
    new-instance v0, Landroid/media/MediaCodecInfo;

    invoke-direct {v0, p0}, Landroid/media/MediaCodecInfo;-><init>(I)V

    return-object v0
.end method

.method static final native getCodecName(I)Ljava/lang/String;
.end method

.method static final native getSupportedTypes(I)[Ljava/lang/String;
.end method

.method static final native isEncoder(I)Z
.end method

.method private static final native native_init()V
.end method
