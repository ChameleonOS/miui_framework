.class public final Landroid/media/MediaFormat;
.super Ljava/lang/Object;
.source "MediaFormat.java"


# static fields
.field public static final KEY_AAC_PROFILE:Ljava/lang/String; = "aac-profile"

.field public static final KEY_BIT_RATE:Ljava/lang/String; = "bitrate"

.field public static final KEY_CHANNEL_COUNT:Ljava/lang/String; = "channel-count"

.field public static final KEY_CHANNEL_MASK:Ljava/lang/String; = "channel-mask"

.field public static final KEY_COLOR_FORMAT:Ljava/lang/String; = "color-format"

.field public static final KEY_DURATION:Ljava/lang/String; = "durationUs"

.field public static final KEY_FLAC_COMPRESSION_LEVEL:Ljava/lang/String; = "flac-compression-level"

.field public static final KEY_FRAME_RATE:Ljava/lang/String; = "frame-rate"

.field public static final KEY_HEIGHT:Ljava/lang/String; = "height"

.field public static final KEY_IS_ADTS:Ljava/lang/String; = "is-adts"

.field public static final KEY_I_FRAME_INTERVAL:Ljava/lang/String; = "i-frame-interval"

.field public static final KEY_MAX_INPUT_SIZE:Ljava/lang/String; = "max-input-size"

.field public static final KEY_MIME:Ljava/lang/String; = "mime"

.field public static final KEY_SAMPLE_RATE:Ljava/lang/String; = "sample-rate"

.field public static final KEY_SLICE_HEIGHT:Ljava/lang/String; = "slice-height"

.field public static final KEY_STRIDE:Ljava/lang/String; = "stride"

.field public static final KEY_WIDTH:Ljava/lang/String; = "width"


# instance fields
.field private mMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 173
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 174
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    .line 175
    return-void
.end method

.method constructor <init>(Ljava/util/Map;)V
    .registers 2
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 166
    .local p1, map:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 167
    iput-object p1, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    .line 168
    return-void
.end method

.method public static final createAudioFormat(Ljava/lang/String;II)Landroid/media/MediaFormat;
    .registers 5
    .parameter "mime"
    .parameter "sampleRate"
    .parameter "channelCount"

    .prologue
    .line 268
    new-instance v0, Landroid/media/MediaFormat;

    invoke-direct {v0}, Landroid/media/MediaFormat;-><init>()V

    .line 269
    .local v0, format:Landroid/media/MediaFormat;
    const-string/jumbo v1, "mime"

    invoke-virtual {v0, v1, p0}, Landroid/media/MediaFormat;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 270
    const-string/jumbo v1, "sample-rate"

    invoke-virtual {v0, v1, p1}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 271
    const-string v1, "channel-count"

    invoke-virtual {v0, v1, p2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 273
    return-object v0
.end method

.method public static final createVideoFormat(Ljava/lang/String;II)Landroid/media/MediaFormat;
    .registers 5
    .parameter "mime"
    .parameter "width"
    .parameter "height"

    .prologue
    .line 286
    new-instance v0, Landroid/media/MediaFormat;

    invoke-direct {v0}, Landroid/media/MediaFormat;-><init>()V

    .line 287
    .local v0, format:Landroid/media/MediaFormat;
    const-string/jumbo v1, "mime"

    invoke-virtual {v0, v1, p0}, Landroid/media/MediaFormat;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 288
    const-string/jumbo v1, "width"

    invoke-virtual {v0, v1, p1}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 289
    const-string v1, "height"

    invoke-virtual {v0, v1, p2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 291
    return-object v0
.end method


# virtual methods
.method public final containsKey(Ljava/lang/String;)Z
    .registers 3
    .parameter "name"

    .prologue
    .line 185
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public final getByteBuffer(Ljava/lang/String;)Ljava/nio/ByteBuffer;
    .registers 3
    .parameter "name"

    .prologue
    .line 220
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/nio/ByteBuffer;

    return-object v0
.end method

.method public final getFloat(Ljava/lang/String;)F
    .registers 3
    .parameter "name"

    .prologue
    .line 206
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    return v0
.end method

.method public final getInteger(Ljava/lang/String;)I
    .registers 3
    .parameter "name"

    .prologue
    .line 192
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public final getLong(Ljava/lang/String;)J
    .registers 4
    .parameter "name"

    .prologue
    .line 199
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    return-wide v0
.end method

.method getMap()Ljava/util/Map;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 178
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    return-object v0
.end method

.method public final getString(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .parameter "name"

    .prologue
    .line 213
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public final setByteBuffer(Ljava/lang/String;Ljava/nio/ByteBuffer;)V
    .registers 4
    .parameter "name"
    .parameter "bytes"

    .prologue
    .line 255
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 256
    return-void
.end method

.method public final setFloat(Ljava/lang/String;F)V
    .registers 5
    .parameter "name"
    .parameter "value"

    .prologue
    .line 241
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    new-instance v1, Ljava/lang/Float;

    invoke-direct {v1, p2}, Ljava/lang/Float;-><init>(F)V

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 242
    return-void
.end method

.method public final setInteger(Ljava/lang/String;I)V
    .registers 5
    .parameter "name"
    .parameter "value"

    .prologue
    .line 227
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    new-instance v1, Ljava/lang/Integer;

    invoke-direct {v1, p2}, Ljava/lang/Integer;-><init>(I)V

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 228
    return-void
.end method

.method public final setLong(Ljava/lang/String;J)V
    .registers 6
    .parameter "name"
    .parameter "value"

    .prologue
    .line 234
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    new-instance v1, Ljava/lang/Long;

    invoke-direct {v1, p2, p3}, Ljava/lang/Long;-><init>(J)V

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 235
    return-void
.end method

.method public final setString(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "name"
    .parameter "value"

    .prologue
    .line 248
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 249
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    .prologue
    .line 296
    iget-object v0, p0, Landroid/media/MediaFormat;->mMap:Ljava/util/Map;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
