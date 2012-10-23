.class public Landroid/graphics/TemporaryBuffer;
.super Ljava/lang/Object;
.source "TemporaryBuffer.java"


# static fields
.field private static sTemp:[C


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 48
    const/4 v0, 0x0

    sput-object v0, Landroid/graphics/TemporaryBuffer;->sTemp:[C

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 24
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static obtain(I)[C
    .registers 4
    .parameter "len"

    .prologue
    .line 28
    const-class v2, Landroid/graphics/TemporaryBuffer;

    monitor-enter v2

    .line 29
    :try_start_3
    sget-object v0, Landroid/graphics/TemporaryBuffer;->sTemp:[C

    .line 30
    .local v0, buf:[C
    const/4 v1, 0x0

    sput-object v1, Landroid/graphics/TemporaryBuffer;->sTemp:[C

    .line 31
    monitor-exit v2
    :try_end_9
    .catchall {:try_start_3 .. :try_end_9} :catchall_15

    .line 33
    if-eqz v0, :cond_e

    array-length v1, v0

    if-ge v1, p0, :cond_14

    .line 34
    :cond_e
    invoke-static {p0}, Lcom/android/internal/util/ArrayUtils;->idealCharArraySize(I)I

    move-result v1

    new-array v0, v1, [C

    .line 37
    :cond_14
    return-object v0

    .line 31
    .end local v0           #buf:[C
    :catchall_15
    move-exception v1

    :try_start_16
    monitor-exit v2
    :try_end_17
    .catchall {:try_start_16 .. :try_end_17} :catchall_15

    throw v1
.end method

.method public static recycle([C)V
    .registers 3
    .parameter "temp"

    .prologue
    .line 41
    array-length v0, p0

    const/16 v1, 0x3e8

    if-le v0, v1, :cond_6

    .line 46
    :goto_5
    return-void

    .line 43
    :cond_6
    const-class v1, Landroid/graphics/TemporaryBuffer;

    monitor-enter v1

    .line 44
    :try_start_9
    sput-object p0, Landroid/graphics/TemporaryBuffer;->sTemp:[C

    .line 45
    monitor-exit v1

    goto :goto_5

    :catchall_d
    move-exception v0

    monitor-exit v1
    :try_end_f
    .catchall {:try_start_9 .. :try_end_f} :catchall_d

    throw v0
.end method
