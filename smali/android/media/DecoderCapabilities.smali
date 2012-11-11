.class public Landroid/media/DecoderCapabilities;
.super Ljava/lang/Object;
.source "DecoderCapabilities.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/media/DecoderCapabilities$AudioDecoder;,
        Landroid/media/DecoderCapabilities$VideoDecoder;
    }
.end annotation


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const-string/jumbo v0, "media_jni"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    invoke-static {}, Landroid/media/DecoderCapabilities;->native_init()V

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAudioDecoders()Ljava/util/List;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/media/DecoderCapabilities$AudioDecoder;",
            ">;"
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .local v0, decoderList:Ljava/util/List;,"Ljava/util/List<Landroid/media/DecoderCapabilities$AudioDecoder;>;"
    invoke-static {}, Landroid/media/DecoderCapabilities;->native_get_num_audio_decoders()I

    move-result v2

    .local v2, nDecoders:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_a
    if-ge v1, v2, :cond_1c

    invoke-static {}, Landroid/media/DecoderCapabilities$AudioDecoder;->values()[Landroid/media/DecoderCapabilities$AudioDecoder;

    move-result-object v3

    invoke-static {v1}, Landroid/media/DecoderCapabilities;->native_get_audio_decoder_type(I)I

    move-result v4

    aget-object v3, v3, v4

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_a

    :cond_1c
    return-object v0
.end method

.method public static getVideoDecoders()Ljava/util/List;
    .registers 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/media/DecoderCapabilities$VideoDecoder;",
            ">;"
        }
    .end annotation

    .prologue
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .local v0, decoderList:Ljava/util/List;,"Ljava/util/List<Landroid/media/DecoderCapabilities$VideoDecoder;>;"
    invoke-static {}, Landroid/media/DecoderCapabilities;->native_get_num_video_decoders()I

    move-result v2

    .local v2, nDecoders:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_a
    if-ge v1, v2, :cond_1c

    invoke-static {}, Landroid/media/DecoderCapabilities$VideoDecoder;->values()[Landroid/media/DecoderCapabilities$VideoDecoder;

    move-result-object v3

    invoke-static {v1}, Landroid/media/DecoderCapabilities;->native_get_video_decoder_type(I)I

    move-result v4

    aget-object v3, v3, v4

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_a

    :cond_1c
    return-object v0
.end method

.method private static final native native_get_audio_decoder_type(I)I
.end method

.method private static final native native_get_num_audio_decoders()I
.end method

.method private static final native native_get_num_video_decoders()I
.end method

.method private static final native native_get_video_decoder_type(I)I
.end method

.method private static final native native_init()V
.end method
