.class Landroid/speech/tts/FileSynthesisCallback;
.super Landroid/speech/tts/AbstractSynthesisCallback;
.source "FileSynthesisCallback.java"


# static fields
.field private static final DBG:Z = false

.field private static final MAX_AUDIO_BUFFER_SIZE:I = 0x2000

.field private static final TAG:Ljava/lang/String; = "FileSynthesisRequest"

.field private static final WAV_FORMAT_PCM:S = 0x1s

.field private static final WAV_HEADER_LENGTH:I = 0x2c


# instance fields
.field private mAudioFormat:I

.field private mChannelCount:I

.field private mDone:Z

.field private mFile:Ljava/io/RandomAccessFile;

.field private final mFileName:Ljava/io/File;

.field private mSampleRateInHz:I

.field private final mStateLock:Ljava/lang/Object;

.field private mStopped:Z


# direct methods
.method constructor <init>(Ljava/io/File;)V
    .registers 4
    .parameter "fileName"

    .prologue
    const/4 v1, 0x0

    invoke-direct {p0}, Landroid/speech/tts/AbstractSynthesisCallback;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/speech/tts/FileSynthesisCallback;->mStateLock:Ljava/lang/Object;

    iput-boolean v1, p0, Landroid/speech/tts/FileSynthesisCallback;->mStopped:Z

    iput-boolean v1, p0, Landroid/speech/tts/FileSynthesisCallback;->mDone:Z

    iput-object p1, p0, Landroid/speech/tts/FileSynthesisCallback;->mFileName:Ljava/io/File;

    return-void
.end method

.method private cleanUp()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/speech/tts/FileSynthesisCallback;->closeFileAndWidenPermissions()V

    iget-object v0, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;

    if-eqz v0, :cond_c

    iget-object v0, p0, Landroid/speech/tts/FileSynthesisCallback;->mFileName:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    :cond_c
    return-void
.end method

.method private closeFileAndWidenPermissions()V
    .registers 7

    .prologue
    :try_start_0
    iget-object v2, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;

    if-eqz v2, :cond_c

    iget-object v2, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;

    invoke-virtual {v2}, Ljava/io/RandomAccessFile;->close()V

    const/4 v2, 0x0

    iput-object v2, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_c} :catch_1a

    :cond_c
    :goto_c
    :try_start_c
    iget-object v2, p0, Landroid/speech/tts/FileSynthesisCallback;->mFileName:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x1b6

    const/4 v4, -0x1

    const/4 v5, -0x1

    invoke-static {v2, v3, v4, v5}, Landroid/os/FileUtils;->setPermissions(Ljava/lang/String;III)I
    :try_end_19
    .catch Ljava/lang/SecurityException; {:try_start_c .. :try_end_19} :catch_40

    :goto_19
    return-void

    :catch_1a
    move-exception v0

    .local v0, ex:Ljava/io/IOException;
    const-string v2, "FileSynthesisRequest"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to close "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/speech/tts/FileSynthesisCallback;->mFileName:Ljava/io/File;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_c

    .end local v0           #ex:Ljava/io/IOException;
    :catch_40
    move-exception v1

    .local v1, se:Ljava/lang/SecurityException;
    const-string v2, "FileSynthesisRequest"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Security exception setting rw permissions on : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroid/speech/tts/FileSynthesisCallback;->mFileName:Ljava/io/File;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_19
.end method

.method private makeWavHeader(IIII)[B
    .registers 14
    .parameter "sampleRateInHz"
    .parameter "audioFormat"
    .parameter "channelCount"
    .parameter "dataLength"

    .prologue
    const/4 v6, 0x1

    const/4 v8, 0x4

    const/4 v7, 0x3

    if-ne p2, v7, :cond_60

    move v5, v6

    .local v5, sampleSizeInBytes:I
    :goto_6
    mul-int v7, p1, v5

    mul-int v2, v7, p3

    .local v2, byteRate:I
    mul-int v7, v5, p3

    int-to-short v1, v7

    .local v1, blockAlign:S
    mul-int/lit8 v7, v5, 0x8

    int-to-short v0, v7

    .local v0, bitsPerSample:S
    const/16 v7, 0x2c

    new-array v4, v7, [B

    .local v4, headerBuf:[B
    invoke-static {v4}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v3

    .local v3, header:Ljava/nio/ByteBuffer;
    sget-object v7, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {v3, v7}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    new-array v7, v8, [B

    fill-array-data v7, :array_62

    invoke-virtual {v3, v7}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    add-int/lit8 v7, p4, 0x2c

    add-int/lit8 v7, v7, -0x8

    invoke-virtual {v3, v7}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    new-array v7, v8, [B

    fill-array-data v7, :array_68

    invoke-virtual {v3, v7}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    new-array v7, v8, [B

    fill-array-data v7, :array_6e

    invoke-virtual {v3, v7}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    const/16 v7, 0x10

    invoke-virtual {v3, v7}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    invoke-virtual {v3, v6}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    int-to-short v6, p3

    invoke-virtual {v3, v6}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    invoke-virtual {v3, p1}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    invoke-virtual {v3, v2}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    invoke-virtual {v3, v1}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    invoke-virtual {v3, v0}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    new-array v6, v8, [B

    fill-array-data v6, :array_74

    invoke-virtual {v3, v6}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    invoke-virtual {v3, p4}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    return-object v4

    .end local v0           #bitsPerSample:S
    .end local v1           #blockAlign:S
    .end local v2           #byteRate:I
    .end local v3           #header:Ljava/nio/ByteBuffer;
    .end local v4           #headerBuf:[B
    .end local v5           #sampleSizeInBytes:I
    :cond_60
    const/4 v5, 0x2

    goto :goto_6

    :array_62
    .array-data 0x1
        0x52t
        0x49t
        0x46t
        0x46t
    .end array-data

    :array_68
    .array-data 0x1
        0x57t
        0x41t
        0x56t
        0x45t
    .end array-data

    :array_6e
    .array-data 0x1
        0x66t
        0x6dt
        0x74t
        0x20t
    .end array-data

    :array_74
    .array-data 0x1
        0x64t
        0x61t
        0x74t
        0x61t
    .end array-data
.end method


# virtual methods
.method public audioAvailable([BII)I
    .registers 10
    .parameter "buffer"
    .parameter "offset"
    .parameter "length"

    .prologue
    const/4 v1, -0x1

    iget-object v2, p0, Landroid/speech/tts/FileSynthesisCallback;->mStateLock:Ljava/lang/Object;

    monitor-enter v2

    :try_start_4
    iget-boolean v3, p0, Landroid/speech/tts/FileSynthesisCallback;->mStopped:Z

    if-eqz v3, :cond_a

    monitor-exit v2

    :goto_9
    return v1

    :cond_a
    iget-object v3, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;

    if-nez v3, :cond_1a

    const-string v3, "FileSynthesisRequest"

    const-string v4, "File not open"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    monitor-exit v2

    goto :goto_9

    :catchall_17
    move-exception v1

    monitor-exit v2
    :try_end_19
    .catchall {:try_start_4 .. :try_end_19} :catchall_17

    throw v1

    :cond_1a
    :try_start_1a
    iget-object v3, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;

    invoke-virtual {v3, p1, p2, p3}, Ljava/io/RandomAccessFile;->write([BII)V
    :try_end_1f
    .catchall {:try_start_1a .. :try_end_1f} :catchall_17
    .catch Ljava/io/IOException; {:try_start_1a .. :try_end_1f} :catch_22

    const/4 v1, 0x0

    :try_start_20
    monitor-exit v2

    goto :goto_9

    :catch_22
    move-exception v0

    .local v0, ex:Ljava/io/IOException;
    const-string v3, "FileSynthesisRequest"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to write to "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Landroid/speech/tts/FileSynthesisCallback;->mFileName:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ": "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0}, Landroid/speech/tts/FileSynthesisCallback;->cleanUp()V

    monitor-exit v2
    :try_end_4b
    .catchall {:try_start_20 .. :try_end_4b} :catchall_17

    goto :goto_9
.end method

.method public done()I
    .registers 9

    .prologue
    const/4 v2, -0x1

    iget-object v3, p0, Landroid/speech/tts/FileSynthesisCallback;->mStateLock:Ljava/lang/Object;

    monitor-enter v3

    :try_start_4
    iget-boolean v4, p0, Landroid/speech/tts/FileSynthesisCallback;->mStopped:Z

    if-eqz v4, :cond_a

    monitor-exit v3

    :goto_9
    return v2

    :cond_a
    iget-object v4, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;

    if-nez v4, :cond_1a

    const-string v4, "FileSynthesisRequest"

    const-string v5, "File not open"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    monitor-exit v3

    goto :goto_9

    :catchall_17
    move-exception v2

    monitor-exit v3
    :try_end_19
    .catchall {:try_start_4 .. :try_end_19} :catchall_17

    throw v2

    :cond_1a
    :try_start_1a
    iget-object v4, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;

    const-wide/16 v5, 0x0

    invoke-virtual {v4, v5, v6}, Ljava/io/RandomAccessFile;->seek(J)V

    iget-object v4, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;

    invoke-virtual {v4}, Ljava/io/RandomAccessFile;->length()J

    move-result-wide v4

    const-wide/16 v6, 0x2c

    sub-long/2addr v4, v6

    long-to-int v0, v4

    .local v0, dataLength:I
    iget-object v4, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;

    iget v5, p0, Landroid/speech/tts/FileSynthesisCallback;->mSampleRateInHz:I

    iget v6, p0, Landroid/speech/tts/FileSynthesisCallback;->mAudioFormat:I

    iget v7, p0, Landroid/speech/tts/FileSynthesisCallback;->mChannelCount:I

    invoke-direct {p0, v5, v6, v7, v0}, Landroid/speech/tts/FileSynthesisCallback;->makeWavHeader(IIII)[B

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/io/RandomAccessFile;->write([B)V

    invoke-direct {p0}, Landroid/speech/tts/FileSynthesisCallback;->closeFileAndWidenPermissions()V

    const/4 v4, 0x1

    iput-boolean v4, p0, Landroid/speech/tts/FileSynthesisCallback;->mDone:Z
    :try_end_40
    .catchall {:try_start_1a .. :try_end_40} :catchall_17
    .catch Ljava/io/IOException; {:try_start_1a .. :try_end_40} :catch_43

    const/4 v2, 0x0

    :try_start_41
    monitor-exit v3

    goto :goto_9

    .end local v0           #dataLength:I
    :catch_43
    move-exception v1

    .local v1, ex:Ljava/io/IOException;
    const-string v4, "FileSynthesisRequest"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Failed to write to "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Landroid/speech/tts/FileSynthesisCallback;->mFileName:Ljava/io/File;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ": "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0}, Landroid/speech/tts/FileSynthesisCallback;->cleanUp()V

    monitor-exit v3
    :try_end_6c
    .catchall {:try_start_41 .. :try_end_6c} :catchall_17

    goto :goto_9
.end method

.method public error()V
    .registers 3

    .prologue
    iget-object v1, p0, Landroid/speech/tts/FileSynthesisCallback;->mStateLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    invoke-direct {p0}, Landroid/speech/tts/FileSynthesisCallback;->cleanUp()V

    monitor-exit v1

    return-void

    :catchall_8
    move-exception v0

    monitor-exit v1
    :try_end_a
    .catchall {:try_start_3 .. :try_end_a} :catchall_8

    throw v0
.end method

.method public getMaxBufferSize()I
    .registers 2

    .prologue
    const/16 v0, 0x2000

    return v0
.end method

.method isDone()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/speech/tts/FileSynthesisCallback;->mDone:Z

    return v0
.end method

.method public start(III)I
    .registers 10
    .parameter "sampleRateInHz"
    .parameter "audioFormat"
    .parameter "channelCount"

    .prologue
    const/4 v1, -0x1

    iget-object v2, p0, Landroid/speech/tts/FileSynthesisCallback;->mStateLock:Ljava/lang/Object;

    monitor-enter v2

    :try_start_4
    iget-boolean v3, p0, Landroid/speech/tts/FileSynthesisCallback;->mStopped:Z

    if-eqz v3, :cond_a

    monitor-exit v2

    :goto_9
    return v1

    :cond_a
    iget-object v3, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;

    if-eqz v3, :cond_1c

    invoke-direct {p0}, Landroid/speech/tts/FileSynthesisCallback;->cleanUp()V

    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v3, "FileSynthesisRequest.start() called twice"

    invoke-direct {v1, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :catchall_19
    move-exception v1

    monitor-exit v2
    :try_end_1b
    .catchall {:try_start_4 .. :try_end_1b} :catchall_19

    throw v1

    :cond_1c
    :try_start_1c
    iput p1, p0, Landroid/speech/tts/FileSynthesisCallback;->mSampleRateInHz:I

    iput p2, p0, Landroid/speech/tts/FileSynthesisCallback;->mAudioFormat:I

    iput p3, p0, Landroid/speech/tts/FileSynthesisCallback;->mChannelCount:I
    :try_end_22
    .catchall {:try_start_1c .. :try_end_22} :catchall_19

    :try_start_22
    new-instance v3, Ljava/io/RandomAccessFile;

    iget-object v4, p0, Landroid/speech/tts/FileSynthesisCallback;->mFileName:Ljava/io/File;

    const-string/jumbo v5, "rw"

    invoke-direct {v3, v4, v5}, Ljava/io/RandomAccessFile;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v3, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;

    iget-object v3, p0, Landroid/speech/tts/FileSynthesisCallback;->mFile:Ljava/io/RandomAccessFile;

    const/16 v4, 0x2c

    new-array v4, v4, [B

    invoke-virtual {v3, v4}, Ljava/io/RandomAccessFile;->write([B)V
    :try_end_37
    .catchall {:try_start_22 .. :try_end_37} :catchall_19
    .catch Ljava/io/IOException; {:try_start_22 .. :try_end_37} :catch_3a

    const/4 v1, 0x0

    :try_start_38
    monitor-exit v2

    goto :goto_9

    :catch_3a
    move-exception v0

    .local v0, ex:Ljava/io/IOException;
    const-string v3, "FileSynthesisRequest"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to open "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Landroid/speech/tts/FileSynthesisCallback;->mFileName:Ljava/io/File;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ": "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0}, Landroid/speech/tts/FileSynthesisCallback;->cleanUp()V

    monitor-exit v2
    :try_end_63
    .catchall {:try_start_38 .. :try_end_63} :catchall_19

    goto :goto_9
.end method

.method stop()V
    .registers 3

    .prologue
    iget-object v1, p0, Landroid/speech/tts/FileSynthesisCallback;->mStateLock:Ljava/lang/Object;

    monitor-enter v1

    const/4 v0, 0x1

    :try_start_4
    iput-boolean v0, p0, Landroid/speech/tts/FileSynthesisCallback;->mStopped:Z

    invoke-direct {p0}, Landroid/speech/tts/FileSynthesisCallback;->cleanUp()V

    monitor-exit v1

    return-void

    :catchall_b
    move-exception v0

    monitor-exit v1
    :try_end_d
    .catchall {:try_start_4 .. :try_end_d} :catchall_b

    throw v0
.end method
