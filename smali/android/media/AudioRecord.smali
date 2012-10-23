.class public Landroid/media/AudioRecord;
.super Ljava/lang/Object;
.source "AudioRecord.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/media/AudioRecord$NativeEventHandler;,
        Landroid/media/AudioRecord$OnRecordPositionUpdateListener;
    }
.end annotation


# static fields
.field private static final AUDIORECORD_ERROR_SETUP_INVALIDCHANNELMASK:I = -0x11

.field private static final AUDIORECORD_ERROR_SETUP_INVALIDFORMAT:I = -0x12

.field private static final AUDIORECORD_ERROR_SETUP_INVALIDSOURCE:I = -0x13

.field private static final AUDIORECORD_ERROR_SETUP_NATIVEINITFAILED:I = -0x14

.field private static final AUDIORECORD_ERROR_SETUP_ZEROFRAMECOUNT:I = -0x10

.field public static final ERROR:I = -0x1

.field public static final ERROR_BAD_VALUE:I = -0x2

.field public static final ERROR_INVALID_OPERATION:I = -0x3

.field private static final NATIVE_EVENT_MARKER:I = 0x2

.field private static final NATIVE_EVENT_NEW_POS:I = 0x3

.field public static final RECORDSTATE_RECORDING:I = 0x3

.field public static final RECORDSTATE_STOPPED:I = 0x1

.field public static final STATE_INITIALIZED:I = 0x1

.field public static final STATE_UNINITIALIZED:I = 0x0

.field public static final SUCCESS:I = 0x0

.field private static final TAG:Ljava/lang/String; = "AudioRecord-Java"


# instance fields
.field private mAudioFormat:I

.field private mChannelConfiguration:I

.field private mChannelCount:I

.field private mChannels:I

.field private mEventHandler:Landroid/media/AudioRecord$NativeEventHandler;

.field private mInitializationLooper:Landroid/os/Looper;

.field private mNativeBufferSizeInBytes:I

.field private mNativeCallbackCookie:I

.field private mNativeRecorderInJavaObj:I

.field private mPositionListener:Landroid/media/AudioRecord$OnRecordPositionUpdateListener;

.field private final mPositionListenerLock:Ljava/lang/Object;

.field private mRecordSource:I

.field private mRecordingState:I

.field private final mRecordingStateLock:Ljava/lang/Object;

.field private mSampleRate:I

.field private mSessionId:I

.field private mState:I


# direct methods
.method public constructor <init>(IIIII)V
    .registers 15
    .parameter "audioSource"
    .parameter "sampleRateInHz"
    .parameter "channelConfig"
    .parameter "audioFormat"
    .parameter "bufferSizeInBytes"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 219
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 130
    const/16 v0, 0x5622

    iput v0, p0, Landroid/media/AudioRecord;->mSampleRate:I

    .line 134
    const/4 v0, 0x1

    iput v0, p0, Landroid/media/AudioRecord;->mChannelCount:I

    .line 138
    const/16 v0, 0x10

    iput v0, p0, Landroid/media/AudioRecord;->mChannels:I

    .line 142
    const/16 v0, 0x10

    iput v0, p0, Landroid/media/AudioRecord;->mChannelConfiguration:I

    .line 148
    const/4 v0, 0x2

    iput v0, p0, Landroid/media/AudioRecord;->mAudioFormat:I

    .line 152
    const/4 v0, 0x0

    iput v0, p0, Landroid/media/AudioRecord;->mRecordSource:I

    .line 156
    const/4 v0, 0x0

    iput v0, p0, Landroid/media/AudioRecord;->mState:I

    .line 160
    const/4 v0, 0x1

    iput v0, p0, Landroid/media/AudioRecord;->mRecordingState:I

    .line 164
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/media/AudioRecord;->mRecordingStateLock:Ljava/lang/Object;

    .line 171
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/media/AudioRecord;->mPositionListener:Landroid/media/AudioRecord$OnRecordPositionUpdateListener;

    .line 175
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/media/AudioRecord;->mPositionListenerLock:Ljava/lang/Object;

    .line 179
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/media/AudioRecord;->mEventHandler:Landroid/media/AudioRecord$NativeEventHandler;

    .line 183
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/media/AudioRecord;->mInitializationLooper:Landroid/os/Looper;

    .line 187
    const/4 v0, 0x0

    iput v0, p0, Landroid/media/AudioRecord;->mNativeBufferSizeInBytes:I

    .line 191
    const/4 v0, 0x0

    iput v0, p0, Landroid/media/AudioRecord;->mSessionId:I

    .line 220
    const/4 v0, 0x0

    iput v0, p0, Landroid/media/AudioRecord;->mState:I

    .line 221
    const/4 v0, 0x1

    iput v0, p0, Landroid/media/AudioRecord;->mRecordingState:I

    .line 224
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    iput-object v0, p0, Landroid/media/AudioRecord;->mInitializationLooper:Landroid/os/Looper;

    if-nez v0, :cond_4f

    .line 225
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    iput-object v0, p0, Landroid/media/AudioRecord;->mInitializationLooper:Landroid/os/Looper;

    .line 228
    :cond_4f
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/media/AudioRecord;->audioParamCheck(IIII)V

    .line 230
    invoke-direct {p0, p5}, Landroid/media/AudioRecord;->audioBuffSizeCheck(I)V

    .line 233
    const/4 v0, 0x1

    new-array v7, v0, [I

    .line 234
    .local v7, session:[I
    const/4 v0, 0x0

    const/4 v1, 0x0

    aput v1, v7, v0

    .line 237
    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iget v2, p0, Landroid/media/AudioRecord;->mRecordSource:I

    iget v3, p0, Landroid/media/AudioRecord;->mSampleRate:I

    iget v4, p0, Landroid/media/AudioRecord;->mChannels:I

    iget v5, p0, Landroid/media/AudioRecord;->mAudioFormat:I

    iget v6, p0, Landroid/media/AudioRecord;->mNativeBufferSizeInBytes:I

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Landroid/media/AudioRecord;->native_setup(Ljava/lang/Object;IIIII[I)I

    move-result v8

    .line 240
    .local v8, initResult:I
    if-eqz v8, :cond_8f

    .line 241
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Error code "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " when initializing native AudioRecord object."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/media/AudioRecord;->loge(Ljava/lang/String;)V

    .line 248
    :goto_8e
    return-void

    .line 245
    :cond_8f
    const/4 v0, 0x0

    aget v0, v7, v0

    iput v0, p0, Landroid/media/AudioRecord;->mSessionId:I

    .line 247
    const/4 v0, 0x1

    iput v0, p0, Landroid/media/AudioRecord;->mState:I

    goto :goto_8e
.end method

.method static synthetic access$000(Landroid/media/AudioRecord;)Ljava/lang/Object;
    .registers 2
    .parameter "x0"

    .prologue
    .line 46
    iget-object v0, p0, Landroid/media/AudioRecord;->mPositionListenerLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$100(Landroid/media/AudioRecord;)Landroid/media/AudioRecord$OnRecordPositionUpdateListener;
    .registers 2
    .parameter "x0"

    .prologue
    .line 46
    iget-object v0, p0, Landroid/media/AudioRecord;->mPositionListener:Landroid/media/AudioRecord$OnRecordPositionUpdateListener;

    return-object v0
.end method

.method private audioBuffSizeCheck(I)V
    .registers 7
    .parameter "audioBufferSize"

    .prologue
    const/4 v2, 0x1

    .line 330
    iget v3, p0, Landroid/media/AudioRecord;->mChannelCount:I

    iget v1, p0, Landroid/media/AudioRecord;->mAudioFormat:I

    const/4 v4, 0x3

    if-ne v1, v4, :cond_19

    move v1, v2

    :goto_9
    mul-int v0, v3, v1

    .line 332
    .local v0, frameSizeInBytes:I
    rem-int v1, p1, v0

    if-nez v1, :cond_11

    if-ge p1, v2, :cond_1b

    .line 333
    :cond_11
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Invalid audio buffer size."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 330
    .end local v0           #frameSizeInBytes:I
    :cond_19
    const/4 v1, 0x2

    goto :goto_9

    .line 336
    .restart local v0       #frameSizeInBytes:I
    :cond_1b
    iput p1, p0, Landroid/media/AudioRecord;->mNativeBufferSizeInBytes:I

    .line 337
    return-void
.end method

.method private audioParamCheck(IIII)V
    .registers 8
    .parameter "audioSource"
    .parameter "sampleRateInHz"
    .parameter "channelConfig"
    .parameter "audioFormat"

    .prologue
    const/4 v2, 0x2

    const/4 v1, 0x0

    .line 264
    if-ltz p1, :cond_a

    invoke-static {}, Landroid/media/MediaRecorder;->getAudioSourceMax()I

    move-result v0

    if-le p1, v0, :cond_12

    .line 266
    :cond_a
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid audio source."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 268
    :cond_12
    iput p1, p0, Landroid/media/AudioRecord;->mRecordSource:I

    .line 273
    const/16 v0, 0xfa0

    if-lt p2, v0, :cond_1d

    const v0, 0xbb80

    if-le p2, v0, :cond_36

    .line 274
    :cond_1d
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "Hz is not a supported sample rate."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 277
    :cond_36
    iput p2, p0, Landroid/media/AudioRecord;->mSampleRate:I

    .line 282
    iput p3, p0, Landroid/media/AudioRecord;->mChannelConfiguration:I

    .line 284
    sparse-switch p3, :sswitch_data_6c

    .line 297
    iput v1, p0, Landroid/media/AudioRecord;->mChannelCount:I

    .line 298
    iput v1, p0, Landroid/media/AudioRecord;->mChannels:I

    .line 299
    iput v1, p0, Landroid/media/AudioRecord;->mChannelConfiguration:I

    .line 300
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unsupported channel configuration."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 288
    :sswitch_4b
    const/4 v0, 0x1

    iput v0, p0, Landroid/media/AudioRecord;->mChannelCount:I

    .line 289
    const/16 v0, 0x10

    iput v0, p0, Landroid/media/AudioRecord;->mChannels:I

    .line 305
    :goto_52
    packed-switch p4, :pswitch_data_82

    .line 314
    iput v1, p0, Landroid/media/AudioRecord;->mAudioFormat:I

    .line 315
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unsupported sample encoding. Should be ENCODING_PCM_8BIT or ENCODING_PCM_16BIT."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 293
    :sswitch_5f
    iput v2, p0, Landroid/media/AudioRecord;->mChannelCount:I

    .line 294
    const/16 v0, 0xc

    iput v0, p0, Landroid/media/AudioRecord;->mChannels:I

    goto :goto_52

    .line 307
    :pswitch_66
    iput v2, p0, Landroid/media/AudioRecord;->mAudioFormat:I

    .line 318
    :goto_68
    return-void

    .line 311
    :pswitch_69
    iput p4, p0, Landroid/media/AudioRecord;->mAudioFormat:I

    goto :goto_68

    .line 284
    :sswitch_data_6c
    .sparse-switch
        0x1 -> :sswitch_4b
        0x2 -> :sswitch_4b
        0x3 -> :sswitch_5f
        0xc -> :sswitch_5f
        0x10 -> :sswitch_4b
    .end sparse-switch

    .line 305
    :pswitch_data_82
    .packed-switch 0x1
        :pswitch_66
        :pswitch_69
        :pswitch_69
    .end packed-switch
.end method

.method public static getMinBufferSize(III)I
    .registers 8
    .parameter "sampleRateInHz"
    .parameter "channelConfig"
    .parameter "audioFormat"

    .prologue
    const/4 v3, -0x1

    const/4 v2, -0x2

    .line 461
    const/4 v0, 0x0

    .line 462
    .local v0, channelCount:I
    sparse-switch p1, :sswitch_data_26

    .line 474
    const-string v3, "getMinBufferSize(): Invalid channel configuration."

    invoke-static {v3}, Landroid/media/AudioRecord;->loge(Ljava/lang/String;)V

    move v1, v2

    .line 492
    :cond_c
    :goto_c
    return v1

    .line 466
    :sswitch_d
    const/4 v0, 0x1

    .line 479
    :goto_e
    const/4 v4, 0x2

    if-eq p2, v4, :cond_1a

    .line 480
    const-string v3, "getMinBufferSize(): Invalid audio format."

    invoke-static {v3}, Landroid/media/AudioRecord;->loge(Ljava/lang/String;)V

    move v1, v2

    .line 481
    goto :goto_c

    .line 470
    :sswitch_18
    const/4 v0, 0x2

    .line 471
    goto :goto_e

    .line 484
    :cond_1a
    invoke-static {p0, v0, p2}, Landroid/media/AudioRecord;->native_get_min_buff_size(III)I

    move-result v1

    .line 485
    .local v1, size:I
    if-nez v1, :cond_22

    move v1, v2

    .line 486
    goto :goto_c

    .line 488
    :cond_22
    if-ne v1, v3, :cond_c

    move v1, v3

    .line 489
    goto :goto_c

    .line 462
    :sswitch_data_26
    .sparse-switch
        0x1 -> :sswitch_d
        0x2 -> :sswitch_d
        0x3 -> :sswitch_18
        0xc -> :sswitch_18
        0x10 -> :sswitch_d
    .end sparse-switch
.end method

.method private static logd(Ljava/lang/String;)V
    .registers 4
    .parameter "msg"

    .prologue
    .line 836
    const-string v0, "AudioRecord-Java"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[ android.media.AudioRecord ] "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 837
    return-void
.end method

.method private static loge(Ljava/lang/String;)V
    .registers 4
    .parameter "msg"

    .prologue
    .line 840
    const-string v0, "AudioRecord-Java"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "[ android.media.AudioRecord ] "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 841
    return-void
.end method

.method private final native native_finalize()V
.end method

.method private final native native_get_marker_pos()I
.end method

.method private static final native native_get_min_buff_size(III)I
.end method

.method private final native native_get_pos_update_period()I
.end method

.method private final native native_read_in_byte_array([BII)I
.end method

.method private final native native_read_in_direct_buffer(Ljava/lang/Object;I)I
.end method

.method private final native native_read_in_short_array([SII)I
.end method

.method private final native native_release()V
.end method

.method private final native native_set_marker_pos(I)I
.end method

.method private final native native_set_pos_update_period(I)I
.end method

.method private final native native_setup(Ljava/lang/Object;IIIII[I)I
.end method

.method private final native native_start(II)I
.end method

.method private final native native_stop()V
.end method

.method private static postEventFromNative(Ljava/lang/Object;IIILjava/lang/Object;)V
    .registers 8
    .parameter "audiorecord_ref"
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"
    .parameter "obj"

    .prologue
    .line 783
    check-cast p0, Ljava/lang/ref/WeakReference;

    .end local p0
    invoke-virtual {p0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/media/AudioRecord;

    .line 784
    .local v1, recorder:Landroid/media/AudioRecord;
    if-nez v1, :cond_b

    .line 794
    :cond_a
    :goto_a
    return-void

    .line 788
    :cond_b
    iget-object v2, v1, Landroid/media/AudioRecord;->mEventHandler:Landroid/media/AudioRecord$NativeEventHandler;

    if-eqz v2, :cond_a

    .line 789
    iget-object v2, v1, Landroid/media/AudioRecord;->mEventHandler:Landroid/media/AudioRecord$NativeEventHandler;

    invoke-virtual {v2, p1, p2, p3, p4}, Landroid/media/AudioRecord$NativeEventHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 791
    .local v0, m:Landroid/os/Message;
    iget-object v2, v1, Landroid/media/AudioRecord;->mEventHandler:Landroid/media/AudioRecord$NativeEventHandler;

    invoke-virtual {v2, v0}, Landroid/media/AudioRecord$NativeEventHandler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_a
.end method


# virtual methods
.method protected finalize()V
    .registers 1

    .prologue
    .line 359
    invoke-direct {p0}, Landroid/media/AudioRecord;->native_finalize()V

    .line 360
    return-void
.end method

.method public getAudioFormat()I
    .registers 2

    .prologue
    .line 386
    iget v0, p0, Landroid/media/AudioRecord;->mAudioFormat:I

    return v0
.end method

.method public getAudioSessionId()I
    .registers 2

    .prologue
    .line 502
    iget v0, p0, Landroid/media/AudioRecord;->mSessionId:I

    return v0
.end method

.method public getAudioSource()I
    .registers 2

    .prologue
    .line 378
    iget v0, p0, Landroid/media/AudioRecord;->mRecordSource:I

    return v0
.end method

.method public getChannelConfiguration()I
    .registers 2

    .prologue
    .line 395
    iget v0, p0, Landroid/media/AudioRecord;->mChannelConfiguration:I

    return v0
.end method

.method public getChannelCount()I
    .registers 2

    .prologue
    .line 402
    iget v0, p0, Landroid/media/AudioRecord;->mChannelCount:I

    return v0
.end method

.method public getNotificationMarkerPosition()I
    .registers 2

    .prologue
    .line 430
    invoke-direct {p0}, Landroid/media/AudioRecord;->native_get_marker_pos()I

    move-result v0

    return v0
.end method

.method public getPositionNotificationPeriod()I
    .registers 2

    .prologue
    .line 437
    invoke-direct {p0}, Landroid/media/AudioRecord;->native_get_pos_update_period()I

    move-result v0

    return v0
.end method

.method public getRecordingState()I
    .registers 2

    .prologue
    .line 423
    iget v0, p0, Landroid/media/AudioRecord;->mRecordingState:I

    return v0
.end method

.method public getSampleRate()I
    .registers 2

    .prologue
    .line 370
    iget v0, p0, Landroid/media/AudioRecord;->mSampleRate:I

    return v0
.end method

.method public getState()I
    .registers 2

    .prologue
    .line 414
    iget v0, p0, Landroid/media/AudioRecord;->mState:I

    return v0
.end method

.method public read(Ljava/nio/ByteBuffer;I)I
    .registers 5
    .parameter "audioBuffer"
    .parameter "sizeInBytes"

    .prologue
    .line 629
    iget v0, p0, Landroid/media/AudioRecord;->mState:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_7

    .line 630
    const/4 v0, -0x3

    .line 637
    :goto_6
    return v0

    .line 633
    :cond_7
    if-eqz p1, :cond_b

    if-gez p2, :cond_d

    .line 634
    :cond_b
    const/4 v0, -0x2

    goto :goto_6

    .line 637
    :cond_d
    invoke-direct {p0, p1, p2}, Landroid/media/AudioRecord;->native_read_in_direct_buffer(Ljava/lang/Object;I)I

    move-result v0

    goto :goto_6
.end method

.method public read([BII)I
    .registers 6
    .parameter "audioData"
    .parameter "offsetInBytes"
    .parameter "sizeInBytes"

    .prologue
    .line 581
    iget v0, p0, Landroid/media/AudioRecord;->mState:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_7

    .line 582
    const/4 v0, -0x3

    .line 590
    :goto_6
    return v0

    .line 585
    :cond_7
    if-eqz p1, :cond_12

    if-ltz p2, :cond_12

    if-ltz p3, :cond_12

    add-int v0, p2, p3

    array-length v1, p1

    if-le v0, v1, :cond_14

    .line 587
    :cond_12
    const/4 v0, -0x2

    goto :goto_6

    .line 590
    :cond_14
    invoke-direct {p0, p1, p2, p3}, Landroid/media/AudioRecord;->native_read_in_byte_array([BII)I

    move-result v0

    goto :goto_6
.end method

.method public read([SII)I
    .registers 6
    .parameter "audioData"
    .parameter "offsetInShorts"
    .parameter "sizeInShorts"

    .prologue
    .line 605
    iget v0, p0, Landroid/media/AudioRecord;->mState:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_7

    .line 606
    const/4 v0, -0x3

    .line 614
    :goto_6
    return v0

    .line 609
    :cond_7
    if-eqz p1, :cond_12

    if-ltz p2, :cond_12

    if-ltz p3, :cond_12

    add-int v0, p2, p3

    array-length v1, p1

    if-le v0, v1, :cond_14

    .line 611
    :cond_12
    const/4 v0, -0x2

    goto :goto_6

    .line 614
    :cond_14
    invoke-direct {p0, p1, p2, p3}, Landroid/media/AudioRecord;->native_read_in_short_array([SII)I

    move-result v0

    goto :goto_6
.end method

.method public release()V
    .registers 2

    .prologue
    .line 348
    :try_start_0
    invoke-virtual {p0}, Landroid/media/AudioRecord;->stop()V
    :try_end_3
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_3} :catch_a

    .line 352
    :goto_3
    invoke-direct {p0}, Landroid/media/AudioRecord;->native_release()V

    .line 353
    const/4 v0, 0x0

    iput v0, p0, Landroid/media/AudioRecord;->mState:I

    .line 354
    return-void

    .line 349
    :catch_a
    move-exception v0

    goto :goto_3
.end method

.method public setNotificationMarkerPosition(I)I
    .registers 3
    .parameter "markerInFrames"

    .prologue
    .line 691
    invoke-direct {p0, p1}, Landroid/media/AudioRecord;->native_set_marker_pos(I)I

    move-result v0

    return v0
.end method

.method public setPositionNotificationPeriod(I)I
    .registers 3
    .parameter "periodInFrames"

    .prologue
    .line 703
    invoke-direct {p0, p1}, Landroid/media/AudioRecord;->native_set_pos_update_period(I)I

    move-result v0

    return v0
.end method

.method public setRecordPositionUpdateListener(Landroid/media/AudioRecord$OnRecordPositionUpdateListener;)V
    .registers 3
    .parameter "listener"

    .prologue
    .line 650
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/media/AudioRecord;->setRecordPositionUpdateListener(Landroid/media/AudioRecord$OnRecordPositionUpdateListener;Landroid/os/Handler;)V

    .line 651
    return-void
.end method

.method public setRecordPositionUpdateListener(Landroid/media/AudioRecord$OnRecordPositionUpdateListener;Landroid/os/Handler;)V
    .registers 6
    .parameter "listener"
    .parameter "handler"

    .prologue
    .line 663
    iget-object v1, p0, Landroid/media/AudioRecord;->mPositionListenerLock:Ljava/lang/Object;

    monitor-enter v1

    .line 665
    :try_start_3
    iput-object p1, p0, Landroid/media/AudioRecord;->mPositionListener:Landroid/media/AudioRecord$OnRecordPositionUpdateListener;

    .line 667
    if-eqz p1, :cond_23

    .line 668
    if-eqz p2, :cond_16

    .line 669
    new-instance v0, Landroid/media/AudioRecord$NativeEventHandler;

    invoke-virtual {p2}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v0, p0, p0, v2}, Landroid/media/AudioRecord$NativeEventHandler;-><init>(Landroid/media/AudioRecord;Landroid/media/AudioRecord;Landroid/os/Looper;)V

    iput-object v0, p0, Landroid/media/AudioRecord;->mEventHandler:Landroid/media/AudioRecord$NativeEventHandler;

    .line 677
    :goto_14
    monitor-exit v1

    .line 679
    return-void

    .line 672
    :cond_16
    new-instance v0, Landroid/media/AudioRecord$NativeEventHandler;

    iget-object v2, p0, Landroid/media/AudioRecord;->mInitializationLooper:Landroid/os/Looper;

    invoke-direct {v0, p0, p0, v2}, Landroid/media/AudioRecord$NativeEventHandler;-><init>(Landroid/media/AudioRecord;Landroid/media/AudioRecord;Landroid/os/Looper;)V

    iput-object v0, p0, Landroid/media/AudioRecord;->mEventHandler:Landroid/media/AudioRecord$NativeEventHandler;

    goto :goto_14

    .line 677
    :catchall_20
    move-exception v0

    monitor-exit v1
    :try_end_22
    .catchall {:try_start_3 .. :try_end_22} :catchall_20

    throw v0

    .line 675
    :cond_23
    const/4 v0, 0x0

    :try_start_24
    iput-object v0, p0, Landroid/media/AudioRecord;->mEventHandler:Landroid/media/AudioRecord$NativeEventHandler;
    :try_end_26
    .catchall {:try_start_24 .. :try_end_26} :catchall_20

    goto :goto_14
.end method

.method public startRecording()V
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 514
    iget v0, p0, Landroid/media/AudioRecord;->mState:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_e

    .line 515
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "startRecording() called on an uninitialized AudioRecord."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 520
    :cond_e
    iget-object v1, p0, Landroid/media/AudioRecord;->mRecordingStateLock:Ljava/lang/Object;

    monitor-enter v1

    .line 521
    const/4 v0, 0x0

    const/4 v2, 0x0

    :try_start_13
    invoke-direct {p0, v0, v2}, Landroid/media/AudioRecord;->native_start(II)I

    move-result v0

    if-nez v0, :cond_1c

    .line 522
    const/4 v0, 0x3

    iput v0, p0, Landroid/media/AudioRecord;->mRecordingState:I

    .line 524
    :cond_1c
    monitor-exit v1

    .line 525
    return-void

    .line 524
    :catchall_1e
    move-exception v0

    monitor-exit v1
    :try_end_20
    .catchall {:try_start_13 .. :try_end_20} :catchall_1e

    throw v0
.end method

.method public startRecording(Landroid/media/MediaSyncEvent;)V
    .registers 5
    .parameter "syncEvent"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 536
    iget v0, p0, Landroid/media/AudioRecord;->mState:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_e

    .line 537
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "startRecording() called on an uninitialized AudioRecord."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 542
    :cond_e
    iget-object v1, p0, Landroid/media/AudioRecord;->mRecordingStateLock:Ljava/lang/Object;

    monitor-enter v1

    .line 543
    :try_start_11
    invoke-virtual {p1}, Landroid/media/MediaSyncEvent;->getType()I

    move-result v0

    invoke-virtual {p1}, Landroid/media/MediaSyncEvent;->getAudioSessionId()I

    move-result v2

    invoke-direct {p0, v0, v2}, Landroid/media/AudioRecord;->native_start(II)I

    move-result v0

    if-nez v0, :cond_22

    .line 544
    const/4 v0, 0x3

    iput v0, p0, Landroid/media/AudioRecord;->mRecordingState:I

    .line 546
    :cond_22
    monitor-exit v1

    .line 547
    return-void

    .line 546
    :catchall_24
    move-exception v0

    monitor-exit v1
    :try_end_26
    .catchall {:try_start_11 .. :try_end_26} :catchall_24

    throw v0
.end method

.method public stop()V
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 555
    iget v0, p0, Landroid/media/AudioRecord;->mState:I

    if-eq v0, v1, :cond_e

    .line 556
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "stop() called on an uninitialized AudioRecord."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 560
    :cond_e
    iget-object v1, p0, Landroid/media/AudioRecord;->mRecordingStateLock:Ljava/lang/Object;

    monitor-enter v1

    .line 561
    :try_start_11
    invoke-direct {p0}, Landroid/media/AudioRecord;->native_stop()V

    .line 562
    const/4 v0, 0x1

    iput v0, p0, Landroid/media/AudioRecord;->mRecordingState:I

    .line 563
    monitor-exit v1

    .line 564
    return-void

    .line 563
    :catchall_19
    move-exception v0

    monitor-exit v1
    :try_end_1b
    .catchall {:try_start_11 .. :try_end_1b} :catchall_19

    throw v0
.end method
