.class public Landroid/media/audiofx/AudioEffect;
.super Ljava/lang/Object;
.source "AudioEffect.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/media/audiofx/AudioEffect$NativeEventHandler;,
        Landroid/media/audiofx/AudioEffect$OnParameterChangeListener;,
        Landroid/media/audiofx/AudioEffect$OnControlStatusChangeListener;,
        Landroid/media/audiofx/AudioEffect$OnEnableStatusChangeListener;,
        Landroid/media/audiofx/AudioEffect$Descriptor;
    }
.end annotation


# static fields
.field public static final ACTION_CLOSE_AUDIO_EFFECT_CONTROL_SESSION:Ljava/lang/String; = "android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION"

.field public static final ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL:Ljava/lang/String; = "android.media.action.DISPLAY_AUDIO_EFFECT_CONTROL_PANEL"

.field public static final ACTION_OPEN_AUDIO_EFFECT_CONTROL_SESSION:Ljava/lang/String; = "android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION"

.field public static final ALREADY_EXISTS:I = -0x2

.field public static final CONTENT_TYPE_GAME:I = 0x2

.field public static final CONTENT_TYPE_MOVIE:I = 0x1

.field public static final CONTENT_TYPE_MUSIC:I = 0x0

.field public static final CONTENT_TYPE_VOICE:I = 0x3

.field public static final EFFECT_AUXILIARY:Ljava/lang/String; = "Auxiliary"

.field public static final EFFECT_INSERT:Ljava/lang/String; = "Insert"

.field public static final EFFECT_PRE_PROCESSING:Ljava/lang/String; = "Pre Processing"

.field public static final EFFECT_TYPE_AEC:Ljava/util/UUID; = null

.field public static final EFFECT_TYPE_AGC:Ljava/util/UUID; = null

.field public static final EFFECT_TYPE_BASS_BOOST:Ljava/util/UUID; = null

.field public static final EFFECT_TYPE_ENV_REVERB:Ljava/util/UUID; = null

.field public static final EFFECT_TYPE_EQUALIZER:Ljava/util/UUID; = null

.field public static final EFFECT_TYPE_NS:Ljava/util/UUID; = null

.field public static final EFFECT_TYPE_NULL:Ljava/util/UUID; = null

.field public static final EFFECT_TYPE_PRESET_REVERB:Ljava/util/UUID; = null

.field public static final EFFECT_TYPE_VIRTUALIZER:Ljava/util/UUID; = null

.field public static final ERROR:I = -0x1

.field public static final ERROR_BAD_VALUE:I = -0x4

.field public static final ERROR_DEAD_OBJECT:I = -0x7

.field public static final ERROR_INVALID_OPERATION:I = -0x5

.field public static final ERROR_NO_INIT:I = -0x3

.field public static final ERROR_NO_MEMORY:I = -0x6

.field public static final EXTRA_AUDIO_SESSION:Ljava/lang/String; = "android.media.extra.AUDIO_SESSION"

.field public static final EXTRA_CONTENT_TYPE:Ljava/lang/String; = "android.media.extra.CONTENT_TYPE"

.field public static final EXTRA_PACKAGE_NAME:Ljava/lang/String; = "android.media.extra.PACKAGE_NAME"

.field public static final NATIVE_EVENT_CONTROL_STATUS:I = 0x0

.field public static final NATIVE_EVENT_ENABLED_STATUS:I = 0x1

.field public static final NATIVE_EVENT_PARAMETER_CHANGED:I = 0x2

.field public static final STATE_INITIALIZED:I = 0x1

.field public static final STATE_UNINITIALIZED:I = 0x0

.field public static final SUCCESS:I = 0x0

.field private static final TAG:Ljava/lang/String; = "AudioEffect-JAVA"


# instance fields
.field private mControlChangeStatusListener:Landroid/media/audiofx/AudioEffect$OnControlStatusChangeListener;

.field private mDescriptor:Landroid/media/audiofx/AudioEffect$Descriptor;

.field private mEnableStatusChangeListener:Landroid/media/audiofx/AudioEffect$OnEnableStatusChangeListener;

.field private mId:I

.field private mJniData:I

.field public final mListenerLock:Ljava/lang/Object;

.field private mNativeAudioEffect:I

.field public mNativeEventHandler:Landroid/media/audiofx/AudioEffect$NativeEventHandler;

.field private mParameterChangeListener:Landroid/media/audiofx/AudioEffect$OnParameterChangeListener;

.field private mState:I

.field private final mStateLock:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const-string v0, "audioeffect_jni"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    invoke-static {}, Landroid/media/audiofx/AudioEffect;->native_init()V

    const-string v0, "c2e5d5f0-94bd-4763-9cac-4e234d06839e"

    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Landroid/media/audiofx/AudioEffect;->EFFECT_TYPE_ENV_REVERB:Ljava/util/UUID;

    const-string v0, "47382d60-ddd8-11db-bf3a-0002a5d5c51b"

    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Landroid/media/audiofx/AudioEffect;->EFFECT_TYPE_PRESET_REVERB:Ljava/util/UUID;

    const-string v0, "0bed4300-ddd6-11db-8f34-0002a5d5c51b"

    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Landroid/media/audiofx/AudioEffect;->EFFECT_TYPE_EQUALIZER:Ljava/util/UUID;

    const-string v0, "0634f220-ddd4-11db-a0fc-0002a5d5c51b"

    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Landroid/media/audiofx/AudioEffect;->EFFECT_TYPE_BASS_BOOST:Ljava/util/UUID;

    const-string v0, "37cc2c00-dddd-11db-8577-0002a5d5c51b"

    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Landroid/media/audiofx/AudioEffect;->EFFECT_TYPE_VIRTUALIZER:Ljava/util/UUID;

    const-string v0, "0a8abfe0-654c-11e0-ba26-0002a5d5c51b"

    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Landroid/media/audiofx/AudioEffect;->EFFECT_TYPE_AGC:Ljava/util/UUID;

    const-string v0, "7b491460-8d4d-11e0-bd61-0002a5d5c51b"

    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Landroid/media/audiofx/AudioEffect;->EFFECT_TYPE_AEC:Ljava/util/UUID;

    const-string v0, "58b4b260-8e06-11e0-aa8e-0002a5d5c51b"

    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Landroid/media/audiofx/AudioEffect;->EFFECT_TYPE_NS:Ljava/util/UUID;

    const-string v0, "ec7178ec-e5e1-4432-a3f4-4657e6795210"

    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Landroid/media/audiofx/AudioEffect;->EFFECT_TYPE_NULL:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Ljava/util/UUID;Ljava/util/UUID;II)V
    .registers 15
    .parameter "type"
    .parameter "uuid"
    .parameter "priority"
    .parameter "audioSession"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/UnsupportedOperationException;,
            Ljava/lang/RuntimeException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v9, 0x0

    const/4 v1, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput v9, p0, Landroid/media/audiofx/AudioEffect;->mState:I

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/media/audiofx/AudioEffect;->mStateLock:Ljava/lang/Object;

    iput-object v1, p0, Landroid/media/audiofx/AudioEffect;->mEnableStatusChangeListener:Landroid/media/audiofx/AudioEffect$OnEnableStatusChangeListener;

    iput-object v1, p0, Landroid/media/audiofx/AudioEffect;->mControlChangeStatusListener:Landroid/media/audiofx/AudioEffect$OnControlStatusChangeListener;

    iput-object v1, p0, Landroid/media/audiofx/AudioEffect;->mParameterChangeListener:Landroid/media/audiofx/AudioEffect$OnParameterChangeListener;

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/media/audiofx/AudioEffect;->mListenerLock:Ljava/lang/Object;

    iput-object v1, p0, Landroid/media/audiofx/AudioEffect;->mNativeEventHandler:Landroid/media/audiofx/AudioEffect$NativeEventHandler;

    new-array v6, v2, [I

    .local v6, id:[I
    new-array v7, v2, [Landroid/media/audiofx/AudioEffect$Descriptor;

    .local v7, desc:[Landroid/media/audiofx/AudioEffect$Descriptor;
    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {p1}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v3

    move-object v0, p0

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v7}, Landroid/media/audiofx/AudioEffect;->native_setup(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;II[I[Ljava/lang/Object;)I

    move-result v8

    .local v8, initResult:I
    if-eqz v8, :cond_a6

    const/4 v0, -0x2

    if-eq v8, v0, :cond_a6

    const-string v0, "AudioEffect-JAVA"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Error code "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " when initializing AudioEffect."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    packed-switch v8, :pswitch_data_ba

    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Cannot initialize effect engine for type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_7f
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Effect type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " not supported."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_9e
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Effect library not loaded"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_a6
    aget v0, v6, v9

    iput v0, p0, Landroid/media/audiofx/AudioEffect;->mId:I

    aget-object v0, v7, v9

    iput-object v0, p0, Landroid/media/audiofx/AudioEffect;->mDescriptor:Landroid/media/audiofx/AudioEffect$Descriptor;

    iget-object v1, p0, Landroid/media/audiofx/AudioEffect;->mStateLock:Ljava/lang/Object;

    monitor-enter v1

    const/4 v0, 0x1

    :try_start_b2
    iput v0, p0, Landroid/media/audiofx/AudioEffect;->mState:I

    monitor-exit v1

    return-void

    :catchall_b6
    move-exception v0

    monitor-exit v1
    :try_end_b8
    .catchall {:try_start_b2 .. :try_end_b8} :catchall_b6

    throw v0

    nop

    :pswitch_data_ba
    .packed-switch -0x5
        :pswitch_9e
        :pswitch_7f
    .end packed-switch
.end method

.method static synthetic access$000(Landroid/media/audiofx/AudioEffect;)Landroid/media/audiofx/AudioEffect$OnEnableStatusChangeListener;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/media/audiofx/AudioEffect;->mEnableStatusChangeListener:Landroid/media/audiofx/AudioEffect$OnEnableStatusChangeListener;

    return-object v0
.end method

.method static synthetic access$100(Landroid/media/audiofx/AudioEffect;)Landroid/media/audiofx/AudioEffect$OnControlStatusChangeListener;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/media/audiofx/AudioEffect;->mControlChangeStatusListener:Landroid/media/audiofx/AudioEffect$OnControlStatusChangeListener;

    return-object v0
.end method

.method static synthetic access$200(Landroid/media/audiofx/AudioEffect;)Landroid/media/audiofx/AudioEffect$OnParameterChangeListener;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/media/audiofx/AudioEffect;->mParameterChangeListener:Landroid/media/audiofx/AudioEffect$OnParameterChangeListener;

    return-object v0
.end method

.method private createNativeEventHandler()V
    .registers 3

    .prologue
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    .local v0, looper:Landroid/os/Looper;
    if-eqz v0, :cond_e

    new-instance v1, Landroid/media/audiofx/AudioEffect$NativeEventHandler;

    invoke-direct {v1, p0, p0, v0}, Landroid/media/audiofx/AudioEffect$NativeEventHandler;-><init>(Landroid/media/audiofx/AudioEffect;Landroid/media/audiofx/AudioEffect;Landroid/os/Looper;)V

    iput-object v1, p0, Landroid/media/audiofx/AudioEffect;->mNativeEventHandler:Landroid/media/audiofx/AudioEffect$NativeEventHandler;

    :goto_d
    return-void

    :cond_e
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    if-eqz v0, :cond_1c

    new-instance v1, Landroid/media/audiofx/AudioEffect$NativeEventHandler;

    invoke-direct {v1, p0, p0, v0}, Landroid/media/audiofx/AudioEffect$NativeEventHandler;-><init>(Landroid/media/audiofx/AudioEffect;Landroid/media/audiofx/AudioEffect;Landroid/os/Looper;)V

    iput-object v1, p0, Landroid/media/audiofx/AudioEffect;->mNativeEventHandler:Landroid/media/audiofx/AudioEffect$NativeEventHandler;

    goto :goto_d

    :cond_1c
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/media/audiofx/AudioEffect;->mNativeEventHandler:Landroid/media/audiofx/AudioEffect$NativeEventHandler;

    goto :goto_d
.end method

.method public static isEffectTypeAvailable(Ljava/util/UUID;)Z
    .registers 4
    .parameter "type"

    .prologue
    invoke-static {}, Landroid/media/audiofx/AudioEffect;->queryEffects()[Landroid/media/audiofx/AudioEffect$Descriptor;

    move-result-object v0

    .local v0, desc:[Landroid/media/audiofx/AudioEffect$Descriptor;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_5
    array-length v2, v0

    if-ge v1, v2, :cond_17

    aget-object v2, v0, v1

    iget-object v2, v2, Landroid/media/audiofx/AudioEffect$Descriptor;->type:Ljava/util/UUID;

    invoke-virtual {v2, p0}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_14

    const/4 v2, 0x1

    :goto_13
    return v2

    :cond_14
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    :cond_17
    const/4 v2, 0x0

    goto :goto_13
.end method

.method public static isError(I)Z
    .registers 2
    .parameter "status"

    .prologue
    if-gez p0, :cond_4

    const/4 v0, 0x1

    :goto_3
    return v0

    :cond_4
    const/4 v0, 0x0

    goto :goto_3
.end method

.method private final native native_command(II[BI[B)I
.end method

.method private final native native_finalize()V
.end method

.method private final native native_getEnabled()Z
.end method

.method private final native native_getParameter(I[BI[B)I
.end method

.method private final native native_hasControl()Z
.end method

.method private static final native native_init()V
.end method

.method private static native native_query_effects()[Ljava/lang/Object;
.end method

.method private static native native_query_pre_processing(I)[Ljava/lang/Object;
.end method

.method private final native native_release()V
.end method

.method private final native native_setEnabled(Z)I
.end method

.method private final native native_setParameter(I[BI[B)I
.end method

.method private final native native_setup(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;II[I[Ljava/lang/Object;)I
.end method

.method private static postEventFromNative(Ljava/lang/Object;IIILjava/lang/Object;)V
    .registers 8
    .parameter "effect_ref"
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"
    .parameter "obj"

    .prologue
    check-cast p0, Ljava/lang/ref/WeakReference;

    .end local p0
    invoke-virtual {p0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/audiofx/AudioEffect;

    .local v0, effect:Landroid/media/audiofx/AudioEffect;
    if-nez v0, :cond_b

    :cond_a
    :goto_a
    return-void

    :cond_b
    iget-object v2, v0, Landroid/media/audiofx/AudioEffect;->mNativeEventHandler:Landroid/media/audiofx/AudioEffect$NativeEventHandler;

    if-eqz v2, :cond_a

    iget-object v2, v0, Landroid/media/audiofx/AudioEffect;->mNativeEventHandler:Landroid/media/audiofx/AudioEffect$NativeEventHandler;

    invoke-virtual {v2, p1, p2, p3, p4}, Landroid/media/audiofx/AudioEffect$NativeEventHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    .local v1, m:Landroid/os/Message;
    iget-object v2, v0, Landroid/media/audiofx/AudioEffect;->mNativeEventHandler:Landroid/media/audiofx/AudioEffect$NativeEventHandler;

    invoke-virtual {v2, v1}, Landroid/media/audiofx/AudioEffect$NativeEventHandler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_a
.end method

.method public static queryEffects()[Landroid/media/audiofx/AudioEffect$Descriptor;
    .registers 1

    .prologue
    invoke-static {}, Landroid/media/audiofx/AudioEffect;->native_query_effects()[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/media/audiofx/AudioEffect$Descriptor;

    check-cast v0, [Landroid/media/audiofx/AudioEffect$Descriptor;

    return-object v0
.end method

.method public static queryPreProcessings(I)[Landroid/media/audiofx/AudioEffect$Descriptor;
    .registers 2
    .parameter "audioSession"

    .prologue
    invoke-static {p0}, Landroid/media/audiofx/AudioEffect;->native_query_pre_processing(I)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/media/audiofx/AudioEffect$Descriptor;

    check-cast v0, [Landroid/media/audiofx/AudioEffect$Descriptor;

    return-object v0
.end method


# virtual methods
.method public byteArrayToInt([B)I
    .registers 3
    .parameter "valueBuf"

    .prologue
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/media/audiofx/AudioEffect;->byteArrayToInt([BI)I

    move-result v0

    return v0
.end method

.method public byteArrayToInt([BI)I
    .registers 5
    .parameter "valueBuf"
    .parameter "offset"

    .prologue
    invoke-static {p1}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    .local v0, converter:Ljava/nio/ByteBuffer;
    invoke-static {}, Ljava/nio/ByteOrder;->nativeOrder()Ljava/nio/ByteOrder;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    invoke-virtual {v0, p2}, Ljava/nio/ByteBuffer;->getInt(I)I

    move-result v1

    return v1
.end method

.method public byteArrayToShort([B)S
    .registers 3
    .parameter "valueBuf"

    .prologue
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/media/audiofx/AudioEffect;->byteArrayToShort([BI)S

    move-result v0

    return v0
.end method

.method public byteArrayToShort([BI)S
    .registers 5
    .parameter "valueBuf"
    .parameter "offset"

    .prologue
    invoke-static {p1}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    .local v0, converter:Ljava/nio/ByteBuffer;
    invoke-static {}, Ljava/nio/ByteOrder;->nativeOrder()Ljava/nio/ByteOrder;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    invoke-virtual {v0, p2}, Ljava/nio/ByteBuffer;->getShort(I)S

    move-result v1

    return v1
.end method

.method public checkState(Ljava/lang/String;)V
    .registers 6
    .parameter "methodName"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    iget-object v1, p0, Landroid/media/audiofx/AudioEffect;->mStateLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget v0, p0, Landroid/media/audiofx/AudioEffect;->mState:I

    const/4 v2, 0x1

    if-eq v0, v2, :cond_24

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " called on uninitialized AudioEffect."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :catchall_21
    move-exception v0

    monitor-exit v1
    :try_end_23
    .catchall {:try_start_3 .. :try_end_23} :catchall_21

    throw v0

    :cond_24
    :try_start_24
    monitor-exit v1
    :try_end_25
    .catchall {:try_start_24 .. :try_end_25} :catchall_21

    return-void
.end method

.method public checkStatus(I)V
    .registers 4
    .parameter "status"

    .prologue
    invoke-static {p1}, Landroid/media/audiofx/AudioEffect;->isError(I)Z

    move-result v0

    if-eqz v0, :cond_21

    packed-switch p1, :pswitch_data_22

    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "AudioEffect: set/get parameter error"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_11
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "AudioEffect: bad parameter value"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_19
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "AudioEffect: invalid parameter operation"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_21
    return-void

    :pswitch_data_22
    .packed-switch -0x5
        :pswitch_19
        :pswitch_11
    .end packed-switch
.end method

.method public command(I[B[B)I
    .registers 10
    .parameter "cmdCode"
    .parameter "command"
    .parameter "reply"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const-string v0, "command()"

    invoke-virtual {p0, v0}, Landroid/media/audiofx/AudioEffect;->checkState(Ljava/lang/String;)V

    array-length v2, p2

    array-length v4, p3

    move-object v0, p0

    move v1, p1

    move-object v3, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Landroid/media/audiofx/AudioEffect;->native_command(II[BI[B)I

    move-result v0

    return v0
.end method

.method public varargs concatArrays([[B)[B
    .registers 11
    .parameter "arrays"

    .prologue
    const/4 v4, 0x0

    .local v4, len:I
    move-object v1, p1

    .local v1, arr$:[[B
    array-length v5, v1

    .local v5, len$:I
    const/4 v3, 0x0

    .local v3, i$:I
    :goto_4
    if-ge v3, v5, :cond_d

    aget-object v0, v1, v3

    .local v0, a:[B
    array-length v7, v0

    add-int/2addr v4, v7

    add-int/lit8 v3, v3, 0x1

    goto :goto_4

    .end local v0           #a:[B
    :cond_d
    new-array v2, v4, [B

    .local v2, b:[B
    const/4 v6, 0x0

    .local v6, offs:I
    move-object v1, p1

    array-length v5, v1

    const/4 v3, 0x0

    :goto_13
    if-ge v3, v5, :cond_21

    aget-object v0, v1, v3

    .restart local v0       #a:[B
    const/4 v7, 0x0

    array-length v8, v0

    invoke-static {v0, v7, v2, v6, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    array-length v7, v0

    add-int/2addr v6, v7

    add-int/lit8 v3, v3, 0x1

    goto :goto_13

    .end local v0           #a:[B
    :cond_21
    return-object v2
.end method

.method protected finalize()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/media/audiofx/AudioEffect;->native_finalize()V

    return-void
.end method

.method public getDescriptor()Landroid/media/audiofx/AudioEffect$Descriptor;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const-string v0, "getDescriptor()"

    invoke-virtual {p0, v0}, Landroid/media/audiofx/AudioEffect;->checkState(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/media/audiofx/AudioEffect;->mDescriptor:Landroid/media/audiofx/AudioEffect$Descriptor;

    return-object v0
.end method

.method public getEnabled()Z
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const-string v0, "getEnabled()"

    invoke-virtual {p0, v0}, Landroid/media/audiofx/AudioEffect;->checkState(Ljava/lang/String;)V

    invoke-direct {p0}, Landroid/media/audiofx/AudioEffect;->native_getEnabled()Z

    move-result v0

    return v0
.end method

.method public getId()I
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const-string v0, "getId()"

    invoke-virtual {p0, v0}, Landroid/media/audiofx/AudioEffect;->checkState(Ljava/lang/String;)V

    iget v0, p0, Landroid/media/audiofx/AudioEffect;->mId:I

    return v0
.end method

.method public getParameter(I[B)I
    .registers 5
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    invoke-virtual {p0, p1}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v0

    .local v0, p:[B
    invoke-virtual {p0, v0, p2}, Landroid/media/audiofx/AudioEffect;->getParameter([B[B)I

    move-result v1

    return v1
.end method

.method public getParameter(I[I)I
    .registers 10
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/16 v6, 0x8

    const/4 v5, 0x4

    array-length v3, p2

    const/4 v4, 0x2

    if-le v3, v4, :cond_9

    const/4 v1, -0x4

    :goto_8
    return v1

    :cond_9
    invoke-virtual {p0, p1}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v0

    .local v0, p:[B
    array-length v3, p2

    mul-int/lit8 v3, v3, 0x4

    new-array v2, v3, [B

    .local v2, v:[B
    invoke-virtual {p0, v0, v2}, Landroid/media/audiofx/AudioEffect;->getParameter([B[B)I

    move-result v1

    .local v1, status:I
    if-eq v1, v5, :cond_1a

    if-ne v1, v6, :cond_2d

    :cond_1a
    const/4 v3, 0x0

    invoke-virtual {p0, v2}, Landroid/media/audiofx/AudioEffect;->byteArrayToInt([B)I

    move-result v4

    aput v4, p2, v3

    if-ne v1, v6, :cond_2a

    const/4 v3, 0x1

    invoke-virtual {p0, v2, v5}, Landroid/media/audiofx/AudioEffect;->byteArrayToInt([BI)I

    move-result v4

    aput v4, p2, v3

    :cond_2a
    div-int/lit8 v1, v1, 0x4

    goto :goto_8

    :cond_2d
    const/4 v1, -0x1

    goto :goto_8
.end method

.method public getParameter(I[S)I
    .registers 10
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x2

    array-length v3, p2

    if-le v3, v5, :cond_7

    const/4 v1, -0x4

    :goto_6
    return v1

    :cond_7
    invoke-virtual {p0, p1}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v0

    .local v0, p:[B
    array-length v3, p2

    mul-int/lit8 v3, v3, 0x2

    new-array v2, v3, [B

    .local v2, v:[B
    invoke-virtual {p0, v0, v2}, Landroid/media/audiofx/AudioEffect;->getParameter([B[B)I

    move-result v1

    .local v1, status:I
    if-eq v1, v5, :cond_18

    if-ne v1, v6, :cond_2b

    :cond_18
    const/4 v3, 0x0

    invoke-virtual {p0, v2}, Landroid/media/audiofx/AudioEffect;->byteArrayToShort([B)S

    move-result v4

    aput-short v4, p2, v3

    if-ne v1, v6, :cond_28

    const/4 v3, 0x1

    invoke-virtual {p0, v2, v5}, Landroid/media/audiofx/AudioEffect;->byteArrayToShort([BI)S

    move-result v4

    aput-short v4, p2, v3

    :cond_28
    div-int/lit8 v1, v1, 0x2

    goto :goto_6

    :cond_2b
    const/4 v1, -0x1

    goto :goto_6
.end method

.method public getParameter([B[B)I
    .registers 5
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const-string v0, "getParameter()"

    invoke-virtual {p0, v0}, Landroid/media/audiofx/AudioEffect;->checkState(Ljava/lang/String;)V

    array-length v0, p1

    array-length v1, p2

    invoke-direct {p0, v0, p1, v1, p2}, Landroid/media/audiofx/AudioEffect;->native_getParameter(I[BI[B)I

    move-result v0

    return v0
.end method

.method public getParameter([I[B)I
    .registers 9
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x0

    const/4 v3, 0x1

    array-length v2, p1

    if-le v2, v5, :cond_8

    const/4 v2, -0x4

    :goto_7
    return v2

    :cond_8
    aget v2, p1, v4

    invoke-virtual {p0, v2}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v0

    .local v0, p:[B
    array-length v2, p1

    if-le v2, v3, :cond_21

    aget v2, p1, v3

    invoke-virtual {p0, v2}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v1

    .local v1, p2:[B
    new-array v2, v5, [[B

    aput-object v0, v2, v4

    aput-object v1, v2, v3

    invoke-virtual {p0, v2}, Landroid/media/audiofx/AudioEffect;->concatArrays([[B)[B

    move-result-object v0

    .end local v1           #p2:[B
    :cond_21
    invoke-virtual {p0, v0, p2}, Landroid/media/audiofx/AudioEffect;->getParameter([B[B)I

    move-result v2

    goto :goto_7
.end method

.method public getParameter([I[I)I
    .registers 13
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/16 v9, 0x8

    const/4 v8, 0x4

    const/4 v7, 0x2

    const/4 v6, 0x0

    const/4 v5, 0x1

    array-length v4, p1

    if-gt v4, v7, :cond_c

    array-length v4, p2

    if-le v4, v7, :cond_e

    :cond_c
    const/4 v2, -0x4

    :goto_d
    return v2

    :cond_e
    aget v4, p1, v6

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v0

    .local v0, p:[B
    array-length v4, p1

    if-le v4, v5, :cond_27

    aget v4, p1, v5

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v1

    .local v1, p2:[B
    new-array v4, v7, [[B

    aput-object v0, v4, v6

    aput-object v1, v4, v5

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->concatArrays([[B)[B

    move-result-object v0

    .end local v1           #p2:[B
    :cond_27
    array-length v4, p2

    mul-int/lit8 v4, v4, 0x4

    new-array v3, v4, [B

    .local v3, v:[B
    invoke-virtual {p0, v0, v3}, Landroid/media/audiofx/AudioEffect;->getParameter([B[B)I

    move-result v2

    .local v2, status:I
    if-eq v2, v8, :cond_34

    if-ne v2, v9, :cond_45

    :cond_34
    invoke-virtual {p0, v3}, Landroid/media/audiofx/AudioEffect;->byteArrayToInt([B)I

    move-result v4

    aput v4, p2, v6

    if-ne v2, v9, :cond_42

    invoke-virtual {p0, v3, v8}, Landroid/media/audiofx/AudioEffect;->byteArrayToInt([BI)I

    move-result v4

    aput v4, p2, v5

    :cond_42
    div-int/lit8 v2, v2, 0x4

    goto :goto_d

    :cond_45
    const/4 v2, -0x1

    goto :goto_d
.end method

.method public getParameter([I[S)I
    .registers 12
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x0

    const/4 v6, 0x1

    const/4 v5, 0x2

    array-length v4, p1

    if-gt v4, v5, :cond_a

    array-length v4, p2

    if-le v4, v5, :cond_c

    :cond_a
    const/4 v2, -0x4

    :goto_b
    return v2

    :cond_c
    aget v4, p1, v7

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v0

    .local v0, p:[B
    array-length v4, p1

    if-le v4, v6, :cond_25

    aget v4, p1, v6

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v1

    .local v1, p2:[B
    new-array v4, v5, [[B

    aput-object v0, v4, v7

    aput-object v1, v4, v6

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->concatArrays([[B)[B

    move-result-object v0

    .end local v1           #p2:[B
    :cond_25
    array-length v4, p2

    mul-int/lit8 v4, v4, 0x2

    new-array v3, v4, [B

    .local v3, v:[B
    invoke-virtual {p0, v0, v3}, Landroid/media/audiofx/AudioEffect;->getParameter([B[B)I

    move-result v2

    .local v2, status:I
    if-eq v2, v5, :cond_32

    if-ne v2, v8, :cond_43

    :cond_32
    invoke-virtual {p0, v3}, Landroid/media/audiofx/AudioEffect;->byteArrayToShort([B)S

    move-result v4

    aput-short v4, p2, v7

    if-ne v2, v8, :cond_40

    invoke-virtual {p0, v3, v5}, Landroid/media/audiofx/AudioEffect;->byteArrayToShort([BI)S

    move-result v4

    aput-short v4, p2, v6

    :cond_40
    div-int/lit8 v2, v2, 0x2

    goto :goto_b

    :cond_43
    const/4 v2, -0x1

    goto :goto_b
.end method

.method public hasControl()Z
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const-string v0, "hasControl()"

    invoke-virtual {p0, v0}, Landroid/media/audiofx/AudioEffect;->checkState(Ljava/lang/String;)V

    invoke-direct {p0}, Landroid/media/audiofx/AudioEffect;->native_hasControl()Z

    move-result v0

    return v0
.end method

.method public intToByteArray(I)[B
    .registers 4
    .parameter "value"

    .prologue
    const/4 v1, 0x4

    invoke-static {v1}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    .local v0, converter:Ljava/nio/ByteBuffer;
    invoke-static {}, Ljava/nio/ByteOrder;->nativeOrder()Ljava/nio/ByteOrder;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v1

    return-object v1
.end method

.method public release()V
    .registers 3

    .prologue
    iget-object v1, p0, Landroid/media/audiofx/AudioEffect;->mStateLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    invoke-direct {p0}, Landroid/media/audiofx/AudioEffect;->native_release()V

    const/4 v0, 0x0

    iput v0, p0, Landroid/media/audiofx/AudioEffect;->mState:I

    monitor-exit v1

    return-void

    :catchall_b
    move-exception v0

    monitor-exit v1
    :try_end_d
    .catchall {:try_start_3 .. :try_end_d} :catchall_b

    throw v0
.end method

.method public setControlStatusListener(Landroid/media/audiofx/AudioEffect$OnControlStatusChangeListener;)V
    .registers 4
    .parameter "listener"

    .prologue
    iget-object v1, p0, Landroid/media/audiofx/AudioEffect;->mListenerLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iput-object p1, p0, Landroid/media/audiofx/AudioEffect;->mControlChangeStatusListener:Landroid/media/audiofx/AudioEffect$OnControlStatusChangeListener;

    monitor-exit v1
    :try_end_6
    .catchall {:try_start_3 .. :try_end_6} :catchall_10

    if-eqz p1, :cond_f

    iget-object v0, p0, Landroid/media/audiofx/AudioEffect;->mNativeEventHandler:Landroid/media/audiofx/AudioEffect$NativeEventHandler;

    if-nez v0, :cond_f

    invoke-direct {p0}, Landroid/media/audiofx/AudioEffect;->createNativeEventHandler()V

    :cond_f
    return-void

    :catchall_10
    move-exception v0

    :try_start_11
    monitor-exit v1
    :try_end_12
    .catchall {:try_start_11 .. :try_end_12} :catchall_10

    throw v0
.end method

.method public setEnableStatusListener(Landroid/media/audiofx/AudioEffect$OnEnableStatusChangeListener;)V
    .registers 4
    .parameter "listener"

    .prologue
    iget-object v1, p0, Landroid/media/audiofx/AudioEffect;->mListenerLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iput-object p1, p0, Landroid/media/audiofx/AudioEffect;->mEnableStatusChangeListener:Landroid/media/audiofx/AudioEffect$OnEnableStatusChangeListener;

    monitor-exit v1
    :try_end_6
    .catchall {:try_start_3 .. :try_end_6} :catchall_10

    if-eqz p1, :cond_f

    iget-object v0, p0, Landroid/media/audiofx/AudioEffect;->mNativeEventHandler:Landroid/media/audiofx/AudioEffect$NativeEventHandler;

    if-nez v0, :cond_f

    invoke-direct {p0}, Landroid/media/audiofx/AudioEffect;->createNativeEventHandler()V

    :cond_f
    return-void

    :catchall_10
    move-exception v0

    :try_start_11
    monitor-exit v1
    :try_end_12
    .catchall {:try_start_11 .. :try_end_12} :catchall_10

    throw v0
.end method

.method public setEnabled(Z)I
    .registers 3
    .parameter "enabled"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const-string/jumbo v0, "setEnabled()"

    invoke-virtual {p0, v0}, Landroid/media/audiofx/AudioEffect;->checkState(Ljava/lang/String;)V

    invoke-direct {p0, p1}, Landroid/media/audiofx/AudioEffect;->native_setEnabled(Z)I

    move-result v0

    return v0
.end method

.method public setParameter(II)I
    .registers 6
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    invoke-virtual {p0, p1}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v0

    .local v0, p:[B
    invoke-virtual {p0, p2}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v1

    .local v1, v:[B
    invoke-virtual {p0, v0, v1}, Landroid/media/audiofx/AudioEffect;->setParameter([B[B)I

    move-result v2

    return v2
.end method

.method public setParameter(IS)I
    .registers 6
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    invoke-virtual {p0, p1}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v0

    .local v0, p:[B
    invoke-virtual {p0, p2}, Landroid/media/audiofx/AudioEffect;->shortToByteArray(S)[B

    move-result-object v1

    .local v1, v:[B
    invoke-virtual {p0, v0, v1}, Landroid/media/audiofx/AudioEffect;->setParameter([B[B)I

    move-result v2

    return v2
.end method

.method public setParameter(I[B)I
    .registers 5
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    invoke-virtual {p0, p1}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v0

    .local v0, p:[B
    invoke-virtual {p0, v0, p2}, Landroid/media/audiofx/AudioEffect;->setParameter([B[B)I

    move-result v1

    return v1
.end method

.method public setParameter([B[B)I
    .registers 5
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const-string/jumbo v0, "setParameter()"

    invoke-virtual {p0, v0}, Landroid/media/audiofx/AudioEffect;->checkState(Ljava/lang/String;)V

    array-length v0, p1

    array-length v1, p2

    invoke-direct {p0, v0, p1, v1, p2}, Landroid/media/audiofx/AudioEffect;->native_setParameter(I[BI[B)I

    move-result v0

    return v0
.end method

.method public setParameter([I[B)I
    .registers 9
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x0

    const/4 v3, 0x1

    array-length v2, p1

    if-le v2, v5, :cond_8

    const/4 v2, -0x4

    :goto_7
    return v2

    :cond_8
    aget v2, p1, v4

    invoke-virtual {p0, v2}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v0

    .local v0, p:[B
    array-length v2, p1

    if-le v2, v3, :cond_21

    aget v2, p1, v3

    invoke-virtual {p0, v2}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v1

    .local v1, p2:[B
    new-array v2, v5, [[B

    aput-object v0, v2, v4

    aput-object v1, v2, v3

    invoke-virtual {p0, v2}, Landroid/media/audiofx/AudioEffect;->concatArrays([[B)[B

    move-result-object v0

    .end local v1           #p2:[B
    :cond_21
    invoke-virtual {p0, v0, p2}, Landroid/media/audiofx/AudioEffect;->setParameter([B[B)I

    move-result v2

    goto :goto_7
.end method

.method public setParameter([I[I)I
    .registers 11
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x0

    const/4 v5, 0x1

    array-length v4, p1

    if-gt v4, v7, :cond_9

    array-length v4, p2

    if-le v4, v7, :cond_b

    :cond_9
    const/4 v4, -0x4

    :goto_a
    return v4

    :cond_b
    aget v4, p1, v6

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v0

    .local v0, p:[B
    array-length v4, p1

    if-le v4, v5, :cond_24

    aget v4, p1, v5

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v1

    .local v1, p2:[B
    new-array v4, v7, [[B

    aput-object v0, v4, v6

    aput-object v1, v4, v5

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->concatArrays([[B)[B

    move-result-object v0

    .end local v1           #p2:[B
    :cond_24
    aget v4, p2, v6

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v2

    .local v2, v:[B
    array-length v4, p2

    if-le v4, v5, :cond_3d

    aget v4, p2, v5

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v3

    .local v3, v2:[B
    new-array v4, v7, [[B

    aput-object v2, v4, v6

    aput-object v3, v4, v5

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->concatArrays([[B)[B

    move-result-object v2

    .end local v3           #v2:[B
    :cond_3d
    invoke-virtual {p0, v0, v2}, Landroid/media/audiofx/AudioEffect;->setParameter([B[B)I

    move-result v4

    goto :goto_a
.end method

.method public setParameter([I[S)I
    .registers 11
    .parameter "param"
    .parameter "value"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x0

    const/4 v5, 0x1

    array-length v4, p1

    if-gt v4, v7, :cond_9

    array-length v4, p2

    if-le v4, v7, :cond_b

    :cond_9
    const/4 v4, -0x4

    :goto_a
    return v4

    :cond_b
    aget v4, p1, v6

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v0

    .local v0, p:[B
    array-length v4, p1

    if-le v4, v5, :cond_24

    aget v4, p1, v5

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->intToByteArray(I)[B

    move-result-object v1

    .local v1, p2:[B
    new-array v4, v7, [[B

    aput-object v0, v4, v6

    aput-object v1, v4, v5

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->concatArrays([[B)[B

    move-result-object v0

    .end local v1           #p2:[B
    :cond_24
    aget-short v4, p2, v6

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->shortToByteArray(S)[B

    move-result-object v2

    .local v2, v:[B
    array-length v4, p2

    if-le v4, v5, :cond_3d

    aget-short v4, p2, v5

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->shortToByteArray(S)[B

    move-result-object v3

    .local v3, v2:[B
    new-array v4, v7, [[B

    aput-object v2, v4, v6

    aput-object v3, v4, v5

    invoke-virtual {p0, v4}, Landroid/media/audiofx/AudioEffect;->concatArrays([[B)[B

    move-result-object v2

    .end local v3           #v2:[B
    :cond_3d
    invoke-virtual {p0, v0, v2}, Landroid/media/audiofx/AudioEffect;->setParameter([B[B)I

    move-result v4

    goto :goto_a
.end method

.method public setParameterListener(Landroid/media/audiofx/AudioEffect$OnParameterChangeListener;)V
    .registers 4
    .parameter "listener"

    .prologue
    iget-object v1, p0, Landroid/media/audiofx/AudioEffect;->mListenerLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iput-object p1, p0, Landroid/media/audiofx/AudioEffect;->mParameterChangeListener:Landroid/media/audiofx/AudioEffect$OnParameterChangeListener;

    monitor-exit v1
    :try_end_6
    .catchall {:try_start_3 .. :try_end_6} :catchall_10

    if-eqz p1, :cond_f

    iget-object v0, p0, Landroid/media/audiofx/AudioEffect;->mNativeEventHandler:Landroid/media/audiofx/AudioEffect$NativeEventHandler;

    if-nez v0, :cond_f

    invoke-direct {p0}, Landroid/media/audiofx/AudioEffect;->createNativeEventHandler()V

    :cond_f
    return-void

    :catchall_10
    move-exception v0

    :try_start_11
    monitor-exit v1
    :try_end_12
    .catchall {:try_start_11 .. :try_end_12} :catchall_10

    throw v0
.end method

.method public shortToByteArray(S)[B
    .registers 5
    .parameter "value"

    .prologue
    const/4 v2, 0x2

    invoke-static {v2}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    .local v0, converter:Ljava/nio/ByteBuffer;
    invoke-static {}, Ljava/nio/ByteOrder;->nativeOrder()Ljava/nio/ByteOrder;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    move v1, p1

    .local v1, sValue:S
    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v2

    return-object v2
.end method
