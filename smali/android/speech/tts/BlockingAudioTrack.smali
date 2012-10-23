.class Landroid/speech/tts/BlockingAudioTrack;
.super Ljava/lang/Object;
.source "BlockingAudioTrack.java"


# static fields
.field private static final DBG:Z = false

.field private static final MAX_PROGRESS_WAIT_MS:J = 0x9c4L

.field private static final MAX_SLEEP_TIME_MS:J = 0x9c4L

.field private static final MIN_AUDIO_BUFFER_SIZE:I = 0x2000

.field private static final MIN_SLEEP_TIME_MS:J = 0x14L

.field private static final TAG:Ljava/lang/String; = "TTS.BlockingAudioTrack"


# instance fields
.field private mAudioBufferSize:I

.field private final mAudioFormat:I

.field private mAudioTrack:Landroid/media/AudioTrack;

.field private final mAudioTrackLock:Ljava/lang/Object;

.field private final mBytesPerFrame:I

.field private mBytesWritten:I

.field private final mChannelCount:I

.field private mIsShortUtterance:Z

.field private final mPan:F

.field private final mSampleRateInHz:I

.field private volatile mStopped:Z

.field private final mStreamType:I

.field private final mVolume:F


# direct methods
.method constructor <init>(IIIIFF)V
    .registers 10
    .parameter "streamType"
    .parameter "sampleRate"
    .parameter "audioFormat"
    .parameter "channelCount"
    .parameter "volume"
    .parameter "pan"

    .prologue
    const/4 v2, 0x0

    .line 79
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 68
    iput v2, p0, Landroid/speech/tts/BlockingAudioTrack;->mBytesWritten:I

    .line 75
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrackLock:Ljava/lang/Object;

    .line 80
    iput p1, p0, Landroid/speech/tts/BlockingAudioTrack;->mStreamType:I

    .line 81
    iput p2, p0, Landroid/speech/tts/BlockingAudioTrack;->mSampleRateInHz:I

    .line 82
    iput p3, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioFormat:I

    .line 83
    iput p4, p0, Landroid/speech/tts/BlockingAudioTrack;->mChannelCount:I

    .line 84
    iput p5, p0, Landroid/speech/tts/BlockingAudioTrack;->mVolume:F

    .line 85
    iput p6, p0, Landroid/speech/tts/BlockingAudioTrack;->mPan:F

    .line 87
    iget v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioFormat:I

    invoke-static {v0}, Landroid/speech/tts/BlockingAudioTrack;->getBytesPerFrame(I)I

    move-result v0

    iget v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mChannelCount:I

    mul-int/2addr v0, v1

    iput v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mBytesPerFrame:I

    .line 88
    iput-boolean v2, p0, Landroid/speech/tts/BlockingAudioTrack;->mIsShortUtterance:Z

    .line 89
    iput v2, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioBufferSize:I

    .line 90
    iput v2, p0, Landroid/speech/tts/BlockingAudioTrack;->mBytesWritten:I

    .line 92
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrack:Landroid/media/AudioTrack;

    .line 93
    iput-boolean v2, p0, Landroid/speech/tts/BlockingAudioTrack;->mStopped:Z

    .line 94
    return-void
.end method

.method private blockUntilCompletion(Landroid/media/AudioTrack;)V
    .registers 16
    .parameter "audioTrack"

    .prologue
    const-wide/16 v4, 0x9c4

    .line 261
    iget v2, p0, Landroid/speech/tts/BlockingAudioTrack;->mBytesWritten:I

    iget v3, p0, Landroid/speech/tts/BlockingAudioTrack;->mBytesPerFrame:I

    div-int v10, v2, v3

    .line 263
    .local v10, lengthInFrames:I
    const/4 v11, -0x1

    .line 264
    .local v11, previousPosition:I
    const/4 v8, 0x0

    .line 265
    .local v8, currentPosition:I
    const-wide/16 v6, 0x0

    .line 268
    .local v6, blockedTimeMs:J
    :goto_c
    invoke-virtual {p1}, Landroid/media/AudioTrack;->getPlaybackHeadPosition()I

    move-result v8

    if-ge v8, v10, :cond_3b

    invoke-virtual {p1}, Landroid/media/AudioTrack;->getPlayState()I

    move-result v2

    const/4 v3, 0x3

    if-ne v2, v3, :cond_3b

    iget-boolean v2, p0, Landroid/speech/tts/BlockingAudioTrack;->mStopped:Z

    if-nez v2, :cond_3b

    .line 270
    sub-int v2, v10, v8

    mul-int/lit16 v2, v2, 0x3e8

    invoke-virtual {p1}, Landroid/media/AudioTrack;->getSampleRate()I

    move-result v3

    div-int/2addr v2, v3

    int-to-long v0, v2

    .line 272
    .local v0, estimatedTimeMs:J
    const-wide/16 v2, 0x14

    invoke-static/range {v0 .. v5}, Landroid/speech/tts/BlockingAudioTrack;->clip(JJJ)J

    move-result-wide v12

    .line 277
    .local v12, sleepTimeMs:J
    if-ne v8, v11, :cond_3c

    .line 280
    add-long/2addr v6, v12

    .line 282
    cmp-long v2, v6, v4

    if-lez v2, :cond_3e

    .line 283
    const-string v2, "TTS.BlockingAudioTrack"

    const-string v3, "Waited unsuccessfully for 2500ms for AudioTrack to make progress, Aborting"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 303
    .end local v0           #estimatedTimeMs:J
    .end local v12           #sleepTimeMs:J
    :cond_3b
    :goto_3b
    return-void

    .line 288
    .restart local v0       #estimatedTimeMs:J
    .restart local v12       #sleepTimeMs:J
    :cond_3c
    const-wide/16 v6, 0x0

    .line 290
    :cond_3e
    move v11, v8

    .line 298
    :try_start_3f
    invoke-static {v12, v13}, Ljava/lang/Thread;->sleep(J)V
    :try_end_42
    .catch Ljava/lang/InterruptedException; {:try_start_3f .. :try_end_42} :catch_43

    goto :goto_c

    .line 299
    :catch_43
    move-exception v9

    .line 300
    .local v9, ie:Ljava/lang/InterruptedException;
    goto :goto_3b
.end method

.method private blockUntilDone(Landroid/media/AudioTrack;)V
    .registers 3
    .parameter "audioTrack"

    .prologue
    .line 225
    iget v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mBytesWritten:I

    if-gtz v0, :cond_5

    .line 245
    :goto_4
    return-void

    .line 229
    :cond_5
    iget-boolean v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mIsShortUtterance:Z

    if-eqz v0, :cond_d

    .line 241
    invoke-direct {p0}, Landroid/speech/tts/BlockingAudioTrack;->blockUntilEstimatedCompletion()V

    goto :goto_4

    .line 243
    :cond_d
    invoke-direct {p0, p1}, Landroid/speech/tts/BlockingAudioTrack;->blockUntilCompletion(Landroid/media/AudioTrack;)V

    goto :goto_4
.end method

.method private blockUntilEstimatedCompletion()V
    .registers 6

    .prologue
    .line 248
    iget v3, p0, Landroid/speech/tts/BlockingAudioTrack;->mBytesWritten:I

    iget v4, p0, Landroid/speech/tts/BlockingAudioTrack;->mBytesPerFrame:I

    div-int v2, v3, v4

    .line 249
    .local v2, lengthInFrames:I
    mul-int/lit16 v3, v2, 0x3e8

    iget v4, p0, Landroid/speech/tts/BlockingAudioTrack;->mSampleRateInHz:I

    div-int/2addr v3, v4

    int-to-long v0, v3

    .line 254
    .local v0, estimatedTimeMs:J
    :try_start_c
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_f
    .catch Ljava/lang/InterruptedException; {:try_start_c .. :try_end_f} :catch_10

    .line 258
    :goto_f
    return-void

    .line 255
    :catch_10
    move-exception v3

    goto :goto_f
.end method

.method private static clip(FFF)F
    .registers 4
    .parameter "value"
    .parameter "min"
    .parameter "max"

    .prologue
    .line 335
    cmpl-float v0, p0, p2

    if-lez v0, :cond_5

    .end local p2
    :goto_4
    return p2

    .restart local p2
    :cond_5
    cmpg-float v0, p0, p1

    if-gez v0, :cond_b

    move p2, p1

    goto :goto_4

    :cond_b
    move p2, p0

    goto :goto_4
.end method

.method private static final clip(JJJ)J
    .registers 7
    .parameter "value"
    .parameter "min"
    .parameter "max"

    .prologue
    .line 323
    cmp-long v0, p0, p2

    if-gez v0, :cond_5

    .line 331
    .end local p2
    :goto_4
    return-wide p2

    .line 327
    .restart local p2
    :cond_5
    cmp-long v0, p0, p4

    if-lez v0, :cond_b

    move-wide p2, p4

    .line 328
    goto :goto_4

    :cond_b
    move-wide p2, p0

    .line 331
    goto :goto_4
.end method

.method private createStreamingAudioTrack()Landroid/media/AudioTrack;
    .registers 9

    .prologue
    const/4 v6, 0x1

    .line 193
    iget v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mChannelCount:I

    invoke-static {v1}, Landroid/speech/tts/BlockingAudioTrack;->getChannelConfig(I)I

    move-result v3

    .line 195
    .local v3, channelConfig:I
    iget v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mSampleRateInHz:I

    iget v2, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioFormat:I

    invoke-static {v1, v3, v2}, Landroid/media/AudioTrack;->getMinBufferSize(III)I

    move-result v7

    .line 197
    .local v7, minBufferSizeInBytes:I
    const/16 v1, 0x2000

    invoke-static {v1, v7}, Ljava/lang/Math;->max(II)I

    move-result v5

    .line 199
    .local v5, bufferSizeInBytes:I
    new-instance v0, Landroid/media/AudioTrack;

    iget v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mStreamType:I

    iget v2, p0, Landroid/speech/tts/BlockingAudioTrack;->mSampleRateInHz:I

    iget v4, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioFormat:I

    invoke-direct/range {v0 .. v6}, Landroid/media/AudioTrack;-><init>(IIIIII)V

    .line 201
    .local v0, audioTrack:Landroid/media/AudioTrack;
    invoke-virtual {v0}, Landroid/media/AudioTrack;->getState()I

    move-result v1

    if-eq v1, v6, :cond_32

    .line 202
    const-string v1, "TTS.BlockingAudioTrack"

    const-string v2, "Unable to create audio track."

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 203
    invoke-virtual {v0}, Landroid/media/AudioTrack;->release()V

    .line 204
    const/4 v0, 0x0

    .line 210
    .end local v0           #audioTrack:Landroid/media/AudioTrack;
    :goto_31
    return-object v0

    .line 207
    .restart local v0       #audioTrack:Landroid/media/AudioTrack;
    :cond_32
    iput v5, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioBufferSize:I

    .line 209
    iget v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mVolume:F

    iget v2, p0, Landroid/speech/tts/BlockingAudioTrack;->mPan:F

    invoke-static {v0, v1, v2}, Landroid/speech/tts/BlockingAudioTrack;->setupVolume(Landroid/media/AudioTrack;FF)V

    goto :goto_31
.end method

.method private static getBytesPerFrame(I)I
    .registers 3
    .parameter "audioFormat"

    .prologue
    const/4 v0, 0x2

    .line 214
    const/4 v1, 0x3

    if-ne p0, v1, :cond_6

    .line 215
    const/4 v0, 0x1

    .line 220
    :cond_5
    :goto_5
    return v0

    .line 216
    :cond_6
    if-eq p0, v0, :cond_5

    .line 220
    const/4 v0, -0x1

    goto :goto_5
.end method

.method static getChannelConfig(I)I
    .registers 2
    .parameter "channelCount"

    .prologue
    .line 157
    const/4 v0, 0x1

    if-ne p0, v0, :cond_5

    .line 158
    const/4 v0, 0x4

    .line 163
    :goto_4
    return v0

    .line 159
    :cond_5
    const/4 v0, 0x2

    if-ne p0, v0, :cond_b

    .line 160
    const/16 v0, 0xc

    goto :goto_4

    .line 163
    :cond_b
    const/4 v0, 0x0

    goto :goto_4
.end method

.method private static setupVolume(Landroid/media/AudioTrack;FF)V
    .registers 10
    .parameter "audioTrack"
    .parameter "volume"
    .parameter "pan"

    .prologue
    const/4 v6, 0x0

    const/high16 v5, 0x3f80

    .line 306
    invoke-static {p1, v6, v5}, Landroid/speech/tts/BlockingAudioTrack;->clip(FFF)F

    move-result v1

    .line 307
    .local v1, vol:F
    const/high16 v4, -0x4080

    invoke-static {p2, v4, v5}, Landroid/speech/tts/BlockingAudioTrack;->clip(FFF)F

    move-result v0

    .line 309
    .local v0, panning:F
    move v2, v1

    .line 310
    .local v2, volLeft:F
    move v3, v1

    .line 311
    .local v3, volRight:F
    cmpl-float v4, v0, v6

    if-lez v4, :cond_24

    .line 312
    sub-float v4, v5, v0

    mul-float/2addr v2, v4

    .line 317
    :cond_16
    :goto_16
    invoke-virtual {p0, v2, v3}, Landroid/media/AudioTrack;->setStereoVolume(FF)I

    move-result v4

    if-eqz v4, :cond_23

    .line 318
    const-string v4, "TTS.BlockingAudioTrack"

    const-string v5, "Failed to set volume"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 320
    :cond_23
    return-void

    .line 313
    :cond_24
    cmpg-float v4, v0, v6

    if-gez v4, :cond_16

    .line 314
    add-float v4, v5, v0

    mul-float/2addr v3, v4

    goto :goto_16
.end method

.method private static writeToAudioTrack(Landroid/media/AudioTrack;[B)I
    .registers 6
    .parameter "audioTrack"
    .parameter "bytes"

    .prologue
    .line 174
    invoke-virtual {p0}, Landroid/media/AudioTrack;->getPlayState()I

    move-result v2

    const/4 v3, 0x3

    if-eq v2, v3, :cond_a

    .line 176
    invoke-virtual {p0}, Landroid/media/AudioTrack;->play()V

    .line 179
    :cond_a
    const/4 v0, 0x0

    .line 180
    .local v0, count:I
    :goto_b
    array-length v2, p1

    if-ge v0, v2, :cond_15

    .line 183
    array-length v2, p1

    invoke-virtual {p0, p1, v0, v2}, Landroid/media/AudioTrack;->write([BII)I

    move-result v1

    .line 184
    .local v1, written:I
    if-gtz v1, :cond_16

    .line 189
    .end local v1           #written:I
    :cond_15
    return v0

    .line 187
    .restart local v1       #written:I
    :cond_16
    add-int/2addr v0, v1

    .line 188
    goto :goto_b
.end method


# virtual methods
.method getAudioLengthMs(I)J
    .registers 7
    .parameter "numBytes"

    .prologue
    .line 167
    iget v3, p0, Landroid/speech/tts/BlockingAudioTrack;->mBytesPerFrame:I

    div-int v2, p1, v3

    .line 168
    .local v2, unconsumedFrames:I
    mul-int/lit16 v3, v2, 0x3e8

    iget v4, p0, Landroid/speech/tts/BlockingAudioTrack;->mSampleRateInHz:I

    div-int/2addr v3, v4

    int-to-long v0, v3

    .line 170
    .local v0, estimatedTimeMs:J
    return-wide v0
.end method

.method public init()V
    .registers 4

    .prologue
    .line 97
    invoke-direct {p0}, Landroid/speech/tts/BlockingAudioTrack;->createStreamingAudioTrack()Landroid/media/AudioTrack;

    move-result-object v0

    .line 99
    .local v0, track:Landroid/media/AudioTrack;
    iget-object v2, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrackLock:Ljava/lang/Object;

    monitor-enter v2

    .line 100
    :try_start_7
    iput-object v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrack:Landroid/media/AudioTrack;

    .line 101
    monitor-exit v2

    .line 102
    return-void

    .line 101
    :catchall_b
    move-exception v1

    monitor-exit v2
    :try_end_d
    .catchall {:try_start_7 .. :try_end_d} :catchall_b

    throw v1
.end method

.method public stop()V
    .registers 3

    .prologue
    .line 105
    iget-object v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrackLock:Ljava/lang/Object;

    monitor-enter v1

    .line 106
    :try_start_3
    iget-object v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrack:Landroid/media/AudioTrack;

    if-eqz v0, :cond_c

    .line 107
    iget-object v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0}, Landroid/media/AudioTrack;->stop()V

    .line 109
    :cond_c
    monitor-exit v1
    :try_end_d
    .catchall {:try_start_3 .. :try_end_d} :catchall_11

    .line 110
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mStopped:Z

    .line 111
    return-void

    .line 109
    :catchall_11
    move-exception v0

    :try_start_12
    monitor-exit v1
    :try_end_13
    .catchall {:try_start_12 .. :try_end_13} :catchall_11

    throw v0
.end method

.method public waitAndRelease()V
    .registers 3

    .prologue
    .line 129
    iget v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mBytesWritten:I

    iget v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioBufferSize:I

    if-ge v0, v1, :cond_12

    iget-boolean v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mStopped:Z

    if-nez v0, :cond_12

    .line 135
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mIsShortUtterance:Z

    .line 136
    iget-object v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0}, Landroid/media/AudioTrack;->stop()V

    .line 140
    :cond_12
    iget-boolean v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mStopped:Z

    if-nez v0, :cond_1b

    .line 142
    iget-object v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-direct {p0, v0}, Landroid/speech/tts/BlockingAudioTrack;->blockUntilDone(Landroid/media/AudioTrack;)V

    .line 149
    :cond_1b
    iget-object v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrackLock:Ljava/lang/Object;

    monitor-enter v1

    .line 150
    :try_start_1e
    iget-object v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-virtual {v0}, Landroid/media/AudioTrack;->release()V

    .line 151
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrack:Landroid/media/AudioTrack;

    .line 152
    monitor-exit v1

    .line 153
    return-void

    .line 152
    :catchall_28
    move-exception v0

    monitor-exit v1
    :try_end_2a
    .catchall {:try_start_1e .. :try_end_2a} :catchall_28

    throw v0
.end method

.method public write([B)I
    .registers 4
    .parameter "data"

    .prologue
    .line 114
    iget-object v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrack:Landroid/media/AudioTrack;

    if-eqz v1, :cond_8

    iget-boolean v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mStopped:Z

    if-eqz v1, :cond_a

    .line 115
    :cond_8
    const/4 v0, -0x1

    .line 119
    :goto_9
    return v0

    .line 117
    :cond_a
    iget-object v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mAudioTrack:Landroid/media/AudioTrack;

    invoke-static {v1, p1}, Landroid/speech/tts/BlockingAudioTrack;->writeToAudioTrack(Landroid/media/AudioTrack;[B)I

    move-result v0

    .line 118
    .local v0, bytesWritten:I
    iget v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mBytesWritten:I

    add-int/2addr v1, v0

    iput v1, p0, Landroid/speech/tts/BlockingAudioTrack;->mBytesWritten:I

    goto :goto_9
.end method
