.class public final Landroid/media/MediaExtractor;
.super Ljava/lang/Object;
.source "MediaExtractor.java"


# static fields
.field public static final SAMPLE_FLAG_ENCRYPTED:I = 0x2

.field public static final SAMPLE_FLAG_SYNC:I = 0x1

.field public static final SEEK_TO_CLOSEST_SYNC:I = 0x2

.field public static final SEEK_TO_NEXT_SYNC:I = 0x1

.field public static final SEEK_TO_PREVIOUS_SYNC:I


# instance fields
.field private mNativeContext:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const-string/jumbo v0, "media_jni"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    invoke-static {}, Landroid/media/MediaExtractor;->native_init()V

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-direct {p0}, Landroid/media/MediaExtractor;->native_setup()V

    return-void
.end method

.method private native getTrackFormatNative(I)Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end method

.method private final native native_finalize()V
.end method

.method private static final native native_init()V
.end method

.method private final native native_setup()V
.end method

.method private final native setDataSource(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
.end method


# virtual methods
.method public native advance()Z
.end method

.method protected finalize()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/media/MediaExtractor;->native_finalize()V

    return-void
.end method

.method public native getCachedDuration()J
.end method

.method public native getSampleCryptoInfo(Landroid/media/MediaCodec$CryptoInfo;)Z
.end method

.method public native getSampleFlags()I
.end method

.method public native getSampleTime()J
.end method

.method public native getSampleTrackIndex()I
.end method

.method public final native getTrackCount()I
.end method

.method public getTrackFormat(I)Landroid/media/MediaFormat;
    .registers 4
    .parameter "index"

    .prologue
    new-instance v0, Landroid/media/MediaFormat;

    invoke-direct {p0, p1}, Landroid/media/MediaExtractor;->getTrackFormatNative(I)Ljava/util/Map;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/media/MediaFormat;-><init>(Ljava/util/Map;)V

    return-object v0
.end method

.method public native hasCacheReachedEndOfStream()Z
.end method

.method public native readSampleData(Ljava/nio/ByteBuffer;I)I
.end method

.method public final native release()V
.end method

.method public native seekTo(JI)V
.end method

.method public native selectTrack(I)V
.end method

.method public final setDataSource(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;)V
    .registers 13
    .parameter "context"
    .parameter "uri"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/net/Uri;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .local p3, headers:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p2}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v8

    .local v8, scheme:Ljava/lang/String;
    if-eqz v8, :cond_e

    const-string v0, "file"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    :cond_e
    invoke-virtual {p2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/media/MediaExtractor;->setDataSource(Ljava/lang/String;)V

    :cond_15
    :goto_15
    return-void

    :cond_16
    const/4 v6, 0x0

    .local v6, fd:Landroid/content/res/AssetFileDescriptor;
    :try_start_17
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v7

    .local v7, resolver:Landroid/content/ContentResolver;
    const-string/jumbo v0, "r"

    invoke-virtual {v7, p2, v0}, Landroid/content/ContentResolver;->openAssetFileDescriptor(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    :try_end_21
    .catchall {:try_start_17 .. :try_end_21} :catchall_5d
    .catch Ljava/lang/SecurityException; {:try_start_17 .. :try_end_21} :catch_4f
    .catch Ljava/io/IOException; {:try_start_17 .. :try_end_21} :catch_64

    move-result-object v6

    if-nez v6, :cond_2a

    if-eqz v6, :cond_15

    :goto_26
    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->close()V

    goto :goto_15

    :cond_2a
    :try_start_2a
    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getDeclaredLength()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-gez v0, :cond_3e

    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/media/MediaExtractor;->setDataSource(Ljava/io/FileDescriptor;)V

    :goto_3b
    if-eqz v6, :cond_15

    goto :goto_26

    :cond_3e
    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v1

    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getStartOffset()J

    move-result-wide v2

    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getDeclaredLength()J

    move-result-wide v4

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Landroid/media/MediaExtractor;->setDataSource(Ljava/io/FileDescriptor;JJ)V
    :try_end_4e
    .catchall {:try_start_2a .. :try_end_4e} :catchall_5d
    .catch Ljava/lang/SecurityException; {:try_start_2a .. :try_end_4e} :catch_4f
    .catch Ljava/io/IOException; {:try_start_2a .. :try_end_4e} :catch_64

    goto :goto_3b

    .end local v7           #resolver:Landroid/content/ContentResolver;
    :catch_4f
    move-exception v0

    if-eqz v6, :cond_55

    :goto_52
    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->close()V

    :cond_55
    invoke-virtual {p2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p3}, Landroid/media/MediaExtractor;->setDataSource(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_15

    :catchall_5d
    move-exception v0

    if-eqz v6, :cond_63

    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->close()V

    :cond_63
    throw v0

    :catch_64
    move-exception v0

    if-eqz v6, :cond_55

    goto :goto_52
.end method

.method public final setDataSource(Ljava/io/FileDescriptor;)V
    .registers 8
    .parameter "fd"

    .prologue
    const-wide/16 v2, 0x0

    const-wide v4, 0x7ffffffffffffffL

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Landroid/media/MediaExtractor;->setDataSource(Ljava/io/FileDescriptor;JJ)V

    return-void
.end method

.method public final native setDataSource(Ljava/io/FileDescriptor;JJ)V
.end method

.method public final setDataSource(Ljava/lang/String;)V
    .registers 3
    .parameter "path"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, v0}, Landroid/media/MediaExtractor;->setDataSource(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V

    return-void
.end method

.method public final setDataSource(Ljava/lang/String;Ljava/util/Map;)V
    .registers 9
    .parameter "path"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, headers:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v3, 0x0

    .local v3, keys:[Ljava/lang/String;
    const/4 v4, 0x0

    .local v4, values:[Ljava/lang/String;
    if-eqz p2, :cond_38

    invoke-interface {p2}, Ljava/util/Map;->size()I

    move-result v5

    new-array v3, v5, [Ljava/lang/String;

    invoke-interface {p2}, Ljava/util/Map;->size()I

    move-result v5

    new-array v4, v5, [Ljava/lang/String;

    const/4 v1, 0x0

    .local v1, i:I
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, i$:Ljava/util/Iterator;
    :goto_19
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_38

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .local v0, entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    aput-object v5, v3, v1

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    aput-object v5, v4, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_19

    .end local v0           #entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1           #i:I
    .end local v2           #i$:Ljava/util/Iterator;
    :cond_38
    invoke-direct {p0, p1, v3, v4}, Landroid/media/MediaExtractor;->setDataSource(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V

    return-void
.end method

.method public native unselectTrack(I)V
.end method
