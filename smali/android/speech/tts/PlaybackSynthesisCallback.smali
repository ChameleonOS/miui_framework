.class Landroid/speech/tts/PlaybackSynthesisCallback;
.super Landroid/speech/tts/AbstractSynthesisCallback;
.source "PlaybackSynthesisCallback.java"


# static fields
.field private static final DBG:Z = false

.field private static final MIN_AUDIO_BUFFER_SIZE:I = 0x2000

.field private static final TAG:Ljava/lang/String; = "PlaybackSynthesisRequest"


# instance fields
.field private final mAudioTrackHandler:Landroid/speech/tts/AudioPlaybackHandler;

.field private final mCallerIdentity:Ljava/lang/Object;

.field private final mDispatcher:Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;

.field private volatile mDone:Z

.field private mItem:Landroid/speech/tts/SynthesisPlaybackQueueItem;

.field private final mLogger:Landroid/speech/tts/EventLogger;

.field private final mPan:F

.field private final mStateLock:Ljava/lang/Object;

.field private mStopped:Z

.field private final mStreamType:I

.field private final mVolume:F


# direct methods
.method constructor <init>(IFFLandroid/speech/tts/AudioPlaybackHandler;Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;Ljava/lang/Object;Landroid/speech/tts/EventLogger;)V
    .registers 10
    .parameter "streamType"
    .parameter "volume"
    .parameter "pan"
    .parameter "audioTrackHandler"
    .parameter "dispatcher"
    .parameter "callerIdentity"
    .parameter "logger"

    .prologue
    const/4 v1, 0x0

    invoke-direct {p0}, Landroid/speech/tts/AbstractSynthesisCallback;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mStateLock:Ljava/lang/Object;

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mItem:Landroid/speech/tts/SynthesisPlaybackQueueItem;

    iput-boolean v1, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mStopped:Z

    iput-boolean v1, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mDone:Z

    iput p1, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mStreamType:I

    iput p2, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mVolume:F

    iput p3, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mPan:F

    iput-object p4, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mAudioTrackHandler:Landroid/speech/tts/AudioPlaybackHandler;

    iput-object p5, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mDispatcher:Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;

    iput-object p6, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mCallerIdentity:Ljava/lang/Object;

    iput-object p7, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mLogger:Landroid/speech/tts/EventLogger;

    return-void
.end method


# virtual methods
.method public audioAvailable([BII)I
    .registers 11
    .parameter "buffer"
    .parameter "offset"
    .parameter "length"

    .prologue
    const/4 v3, 0x0

    const/4 v4, -0x1

    invoke-virtual {p0}, Landroid/speech/tts/PlaybackSynthesisCallback;->getMaxBufferSize()I

    move-result v5

    if-gt p3, v5, :cond_a

    if-gtz p3, :cond_29

    :cond_a
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "buffer is too large or of zero length ("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " bytes)"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    :cond_29
    const/4 v2, 0x0

    .local v2, item:Landroid/speech/tts/SynthesisPlaybackQueueItem;
    iget-object v5, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mStateLock:Ljava/lang/Object;

    monitor-enter v5

    :try_start_2d
    iget-object v6, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mItem:Landroid/speech/tts/SynthesisPlaybackQueueItem;

    if-eqz v6, :cond_35

    iget-boolean v6, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mStopped:Z

    if-eqz v6, :cond_38

    :cond_35
    monitor-exit v5

    move v3, v4

    :goto_37
    return v3

    :cond_38
    iget-object v2, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mItem:Landroid/speech/tts/SynthesisPlaybackQueueItem;

    monitor-exit v5
    :try_end_3b
    .catchall {:try_start_2d .. :try_end_3b} :catchall_49

    new-array v0, p3, [B

    .local v0, bufferCopy:[B
    invoke-static {p1, p2, v0, v3, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :try_start_40
    invoke-virtual {v2, v0}, Landroid/speech/tts/SynthesisPlaybackQueueItem;->put([B)V
    :try_end_43
    .catch Ljava/lang/InterruptedException; {:try_start_40 .. :try_end_43} :catch_4c

    iget-object v4, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mLogger:Landroid/speech/tts/EventLogger;

    invoke-virtual {v4}, Landroid/speech/tts/EventLogger;->onEngineDataReceived()V

    goto :goto_37

    .end local v0           #bufferCopy:[B
    :catchall_49
    move-exception v3

    :try_start_4a
    monitor-exit v5
    :try_end_4b
    .catchall {:try_start_4a .. :try_end_4b} :catchall_49

    throw v3

    .restart local v0       #bufferCopy:[B
    :catch_4c
    move-exception v1

    .local v1, ie:Ljava/lang/InterruptedException;
    move v3, v4

    goto :goto_37
.end method

.method public done()I
    .registers 6

    .prologue
    const/4 v1, -0x1

    const/4 v0, 0x0

    .local v0, item:Landroid/speech/tts/SynthesisPlaybackQueueItem;
    iget-object v2, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mStateLock:Ljava/lang/Object;

    monitor-enter v2

    :try_start_5
    iget-boolean v3, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mDone:Z

    if-eqz v3, :cond_12

    const-string v3, "PlaybackSynthesisRequest"

    const-string v4, "Duplicate call to done()"

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    monitor-exit v2

    :goto_11
    return v1

    :cond_12
    const/4 v3, 0x1

    iput-boolean v3, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mDone:Z

    iget-object v3, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mItem:Landroid/speech/tts/SynthesisPlaybackQueueItem;

    if-nez v3, :cond_1e

    monitor-exit v2

    goto :goto_11

    :catchall_1b
    move-exception v1

    monitor-exit v2
    :try_end_1d
    .catchall {:try_start_5 .. :try_end_1d} :catchall_1b

    throw v1

    :cond_1e
    :try_start_1e
    iget-object v0, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mItem:Landroid/speech/tts/SynthesisPlaybackQueueItem;

    monitor-exit v2
    :try_end_21
    .catchall {:try_start_1e .. :try_end_21} :catchall_1b

    invoke-virtual {v0}, Landroid/speech/tts/SynthesisPlaybackQueueItem;->done()V

    iget-object v1, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mLogger:Landroid/speech/tts/EventLogger;

    invoke-virtual {v1}, Landroid/speech/tts/EventLogger;->onEngineComplete()V

    const/4 v1, 0x0

    goto :goto_11
.end method

.method public error()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mLogger:Landroid/speech/tts/EventLogger;

    invoke-virtual {v0}, Landroid/speech/tts/EventLogger;->onError()V

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/speech/tts/PlaybackSynthesisCallback;->stopImpl(Z)V

    return-void
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
    iget-boolean v0, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mDone:Z

    return v0
.end method

.method public start(III)I
    .registers 16
    .parameter "sampleRateInHz"
    .parameter "audioFormat"
    .parameter "channelCount"

    .prologue
    const/4 v1, -0x1

    invoke-static {p3}, Landroid/speech/tts/BlockingAudioTrack;->getChannelConfig(I)I

    move-result v10

    .local v10, channelConfig:I
    if-nez v10, :cond_20

    const-string v2, "PlaybackSynthesisRequest"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unsupported number of channels :"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :goto_1f
    return v1

    :cond_20
    iget-object v11, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mStateLock:Ljava/lang/Object;

    monitor-enter v11

    :try_start_23
    iget-boolean v2, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mStopped:Z

    if-eqz v2, :cond_2c

    monitor-exit v11

    goto :goto_1f

    :catchall_29
    move-exception v1

    monitor-exit v11
    :try_end_2b
    .catchall {:try_start_23 .. :try_end_2b} :catchall_29

    throw v1

    :cond_2c
    :try_start_2c
    new-instance v0, Landroid/speech/tts/SynthesisPlaybackQueueItem;

    iget v1, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mStreamType:I

    iget v5, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mVolume:F

    iget v6, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mPan:F

    iget-object v7, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mDispatcher:Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;

    iget-object v8, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mCallerIdentity:Ljava/lang/Object;

    iget-object v9, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mLogger:Landroid/speech/tts/EventLogger;

    move v2, p1

    move v3, p2

    move v4, p3

    invoke-direct/range {v0 .. v9}, Landroid/speech/tts/SynthesisPlaybackQueueItem;-><init>(IIIIFFLandroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;Ljava/lang/Object;Landroid/speech/tts/EventLogger;)V

    .local v0, item:Landroid/speech/tts/SynthesisPlaybackQueueItem;
    iget-object v1, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mAudioTrackHandler:Landroid/speech/tts/AudioPlaybackHandler;

    invoke-virtual {v1, v0}, Landroid/speech/tts/AudioPlaybackHandler;->enqueue(Landroid/speech/tts/PlaybackQueueItem;)V

    iput-object v0, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mItem:Landroid/speech/tts/SynthesisPlaybackQueueItem;

    monitor-exit v11
    :try_end_48
    .catchall {:try_start_2c .. :try_end_48} :catchall_29

    const/4 v1, 0x0

    goto :goto_1f
.end method

.method stop()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/speech/tts/PlaybackSynthesisCallback;->stopImpl(Z)V

    return-void
.end method

.method stopImpl(Z)V
    .registers 6
    .parameter "wasError"

    .prologue
    iget-object v1, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mLogger:Landroid/speech/tts/EventLogger;

    invoke-virtual {v1}, Landroid/speech/tts/EventLogger;->onStopped()V

    iget-object v2, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mStateLock:Ljava/lang/Object;

    monitor-enter v2

    :try_start_8
    iget-boolean v1, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mStopped:Z

    if-eqz v1, :cond_16

    const-string v1, "PlaybackSynthesisRequest"

    const-string/jumbo v3, "stop() called twice"

    invoke-static {v1, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    monitor-exit v2

    :cond_15
    :goto_15
    return-void

    :cond_16
    iget-object v0, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mItem:Landroid/speech/tts/SynthesisPlaybackQueueItem;

    .local v0, item:Landroid/speech/tts/SynthesisPlaybackQueueItem;
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mStopped:Z

    monitor-exit v2
    :try_end_1c
    .catchall {:try_start_8 .. :try_end_1c} :catchall_22

    if-eqz v0, :cond_25

    invoke-virtual {v0, p1}, Landroid/speech/tts/SynthesisPlaybackQueueItem;->stop(Z)V

    goto :goto_15

    .end local v0           #item:Landroid/speech/tts/SynthesisPlaybackQueueItem;
    :catchall_22
    move-exception v1

    :try_start_23
    monitor-exit v2
    :try_end_24
    .catchall {:try_start_23 .. :try_end_24} :catchall_22

    throw v1

    .restart local v0       #item:Landroid/speech/tts/SynthesisPlaybackQueueItem;
    :cond_25
    iget-object v1, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mLogger:Landroid/speech/tts/EventLogger;

    invoke-virtual {v1}, Landroid/speech/tts/EventLogger;->onWriteData()V

    if-eqz p1, :cond_15

    iget-object v1, p0, Landroid/speech/tts/PlaybackSynthesisCallback;->mDispatcher:Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;

    invoke-interface {v1}, Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;->dispatchOnError()V

    goto :goto_15
.end method
