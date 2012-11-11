.class public Landroid/media/RemoteControlClient;
.super Ljava/lang/Object;
.source "RemoteControlClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/media/RemoteControlClient$EventHandler;,
        Landroid/media/RemoteControlClient$MetadataEditor;
    }
.end annotation


# static fields
.field public static final DEFAULT_PLAYBACK_VOLUME:I = 0xf

.field public static final DEFAULT_PLAYBACK_VOLUME_HANDLING:I = 0x1

.field public static final FLAGS_KEY_MEDIA_NONE:I = 0x0

.field public static final FLAG_INFORMATION_REQUEST_ALBUM_ART:I = 0x8

.field public static final FLAG_INFORMATION_REQUEST_KEY_MEDIA:I = 0x2

.field public static final FLAG_INFORMATION_REQUEST_METADATA:I = 0x1

.field public static final FLAG_INFORMATION_REQUEST_PLAYSTATE:I = 0x4

.field public static final FLAG_KEY_MEDIA_FAST_FORWARD:I = 0x40

.field public static final FLAG_KEY_MEDIA_NEXT:I = 0x80

.field public static final FLAG_KEY_MEDIA_PAUSE:I = 0x10

.field public static final FLAG_KEY_MEDIA_PLAY:I = 0x4

.field public static final FLAG_KEY_MEDIA_PLAY_PAUSE:I = 0x8

.field public static final FLAG_KEY_MEDIA_PREVIOUS:I = 0x1

.field public static final FLAG_KEY_MEDIA_REWIND:I = 0x2

.field public static final FLAG_KEY_MEDIA_STOP:I = 0x20

.field private static final METADATA_KEYS_TYPE_LONG:[I = null

.field private static final METADATA_KEYS_TYPE_STRING:[I = null

.field private static final MSG_NEW_CURRENT_CLIENT_GEN:I = 0x6

.field private static final MSG_NEW_INTERNAL_CLIENT_GEN:I = 0x5

.field private static final MSG_PLUG_DISPLAY:I = 0x7

.field private static final MSG_REQUEST_ARTWORK:I = 0x4

.field private static final MSG_REQUEST_METADATA:I = 0x2

.field private static final MSG_REQUEST_PLAYBACK_STATE:I = 0x1

.field private static final MSG_REQUEST_TRANSPORTCONTROL:I = 0x3

.field private static final MSG_UNPLUG_DISPLAY:I = 0x8

.field public static final PLAYBACKINFO_INVALID_VALUE:I = -0x80000000

.field public static final PLAYBACKINFO_PLAYBACK_TYPE:I = 0x1

.field public static final PLAYBACKINFO_PLAYSTATE:I = 0xff

.field public static final PLAYBACKINFO_USES_STREAM:I = 0x5

.field public static final PLAYBACKINFO_VOLUME:I = 0x2

.field public static final PLAYBACKINFO_VOLUME_HANDLING:I = 0x4

.field public static final PLAYBACKINFO_VOLUME_MAX:I = 0x3

.field public static final PLAYBACK_TYPE_LOCAL:I = 0x0

.field private static final PLAYBACK_TYPE_MAX:I = 0x1

.field private static final PLAYBACK_TYPE_MIN:I = 0x0

.field public static final PLAYBACK_TYPE_REMOTE:I = 0x1

.field public static final PLAYBACK_VOLUME_FIXED:I = 0x0

.field public static final PLAYBACK_VOLUME_VARIABLE:I = 0x1

.field public static final PLAYSTATE_BUFFERING:I = 0x8

.field public static final PLAYSTATE_ERROR:I = 0x9

.field public static final PLAYSTATE_FAST_FORWARDING:I = 0x4

.field public static final PLAYSTATE_NONE:I = 0x0

.field public static final PLAYSTATE_PAUSED:I = 0x2

.field public static final PLAYSTATE_PLAYING:I = 0x3

.field public static final PLAYSTATE_REWINDING:I = 0x5

.field public static final PLAYSTATE_SKIPPING_BACKWARDS:I = 0x7

.field public static final PLAYSTATE_SKIPPING_FORWARDS:I = 0x6

.field public static final PLAYSTATE_STOPPED:I = 0x1

.field public static final RCSE_ID_UNREGISTERED:I = -0x1

.field private static final TAG:Ljava/lang/String; = "RemoteControlClient"

.field private static sService:Landroid/media/IAudioService;


# instance fields
.field private final ARTWORK_DEFAULT_SIZE:I

.field private final ARTWORK_INVALID_SIZE:I

.field private mArtwork:Landroid/graphics/Bitmap;

.field private mArtworkExpectedHeight:I

.field private mArtworkExpectedWidth:I

.field private final mCacheLock:Ljava/lang/Object;

.field private mCurrentClientGenId:I

.field private mEventHandler:Landroid/media/RemoteControlClient$EventHandler;

.field private final mIRCC:Landroid/media/IRemoteControlClient;

.field private mInternalClientGenId:I

.field private mMetadata:Landroid/os/Bundle;

.field private mPlaybackState:I

.field private mPlaybackStateChangeTimeMs:J

.field private mPlaybackStream:I

.field private mPlaybackType:I

.field private mPlaybackVolume:I

.field private mPlaybackVolumeHandling:I

.field private mPlaybackVolumeMax:I

.field private mRcDisplay:Landroid/media/IRemoteControlDisplay;

.field private final mRcMediaIntent:Landroid/app/PendingIntent;

.field private mRcseId:I

.field private mTransportControlFlags:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/16 v0, 0xb

    new-array v0, v0, [I

    fill-array-data v0, :array_12

    sput-object v0, Landroid/media/RemoteControlClient;->METADATA_KEYS_TYPE_STRING:[I

    const/4 v0, 0x3

    new-array v0, v0, [I

    fill-array-data v0, :array_2c

    sput-object v0, Landroid/media/RemoteControlClient;->METADATA_KEYS_TYPE_LONG:[I

    return-void

    :array_12
    .array-data 0x4
        0x1t 0x0t 0x0t 0x0t
        0xdt 0x0t 0x0t 0x0t
        0x7t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
        0x3t 0x0t 0x0t 0x0t
        0xft 0x0t 0x0t 0x0t
        0x4t 0x0t 0x0t 0x0t
        0x5t 0x0t 0x0t 0x0t
        0x6t 0x0t 0x0t 0x0t
        0x7t 0x0t 0x0t 0x0t
        0xbt 0x0t 0x0t 0x0t
    .end array-data

    :array_2c
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0xet 0x0t 0x0t 0x0t
        0x9t 0x0t 0x0t 0x0t
    .end array-data
.end method

.method public constructor <init>(Landroid/app/PendingIntent;)V
    .registers 8
    .parameter "mediaButtonIntent"

    .prologue
    const/16 v1, 0xf

    const/16 v5, 0x100

    const/4 v4, 0x0

    const/4 v3, -0x1

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput v4, p0, Landroid/media/RemoteControlClient;->mPlaybackType:I

    iput v1, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeMax:I

    iput v1, p0, Landroid/media/RemoteControlClient;->mPlaybackVolume:I

    const/4 v1, 0x1

    iput v1, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeHandling:I

    const/4 v1, 0x3

    iput v1, p0, Landroid/media/RemoteControlClient;->mPlaybackStream:I

    new-instance v1, Ljava/lang/Object;

    invoke-direct/range {v1 .. v1}, Ljava/lang/Object;-><init>()V

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    iput v4, p0, Landroid/media/RemoteControlClient;->mPlaybackState:I

    const-wide/16 v1, 0x0

    iput-wide v1, p0, Landroid/media/RemoteControlClient;->mPlaybackStateChangeTimeMs:J

    iput v5, p0, Landroid/media/RemoteControlClient;->ARTWORK_DEFAULT_SIZE:I

    iput v3, p0, Landroid/media/RemoteControlClient;->ARTWORK_INVALID_SIZE:I

    iput v5, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    iput v5, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    iput v4, p0, Landroid/media/RemoteControlClient;->mTransportControlFlags:I

    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mMetadata:Landroid/os/Bundle;

    iput v3, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    const/4 v1, -0x2

    iput v1, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    new-instance v1, Landroid/media/RemoteControlClient$1;

    invoke-direct {v1, p0}, Landroid/media/RemoteControlClient$1;-><init>(Landroid/media/RemoteControlClient;)V

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mIRCC:Landroid/media/IRemoteControlClient;

    iput v3, p0, Landroid/media/RemoteControlClient;->mRcseId:I

    iput-object p1, p0, Landroid/media/RemoteControlClient;->mRcMediaIntent:Landroid/app/PendingIntent;

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    .local v0, looper:Landroid/os/Looper;
    if-eqz v0, :cond_51

    new-instance v1, Landroid/media/RemoteControlClient$EventHandler;

    invoke-direct {v1, p0, p0, v0}, Landroid/media/RemoteControlClient$EventHandler;-><init>(Landroid/media/RemoteControlClient;Landroid/media/RemoteControlClient;Landroid/os/Looper;)V

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mEventHandler:Landroid/media/RemoteControlClient$EventHandler;

    :goto_50
    return-void

    :cond_51
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    if-eqz v0, :cond_5f

    new-instance v1, Landroid/media/RemoteControlClient$EventHandler;

    invoke-direct {v1, p0, p0, v0}, Landroid/media/RemoteControlClient$EventHandler;-><init>(Landroid/media/RemoteControlClient;Landroid/media/RemoteControlClient;Landroid/os/Looper;)V

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mEventHandler:Landroid/media/RemoteControlClient$EventHandler;

    goto :goto_50

    :cond_5f
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mEventHandler:Landroid/media/RemoteControlClient$EventHandler;

    const-string v1, "RemoteControlClient"

    const-string v2, "RemoteControlClient() couldn\'t find main application thread"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_50
.end method

.method public constructor <init>(Landroid/app/PendingIntent;Landroid/os/Looper;)V
    .registers 8
    .parameter "mediaButtonIntent"
    .parameter "looper"

    .prologue
    const/16 v0, 0xf

    const/16 v4, 0x100

    const/4 v3, 0x0

    const/4 v2, -0x1

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput v3, p0, Landroid/media/RemoteControlClient;->mPlaybackType:I

    iput v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeMax:I

    iput v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolume:I

    const/4 v0, 0x1

    iput v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeHandling:I

    const/4 v0, 0x3

    iput v0, p0, Landroid/media/RemoteControlClient;->mPlaybackStream:I

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    iput v3, p0, Landroid/media/RemoteControlClient;->mPlaybackState:I

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/media/RemoteControlClient;->mPlaybackStateChangeTimeMs:J

    iput v4, p0, Landroid/media/RemoteControlClient;->ARTWORK_DEFAULT_SIZE:I

    iput v2, p0, Landroid/media/RemoteControlClient;->ARTWORK_INVALID_SIZE:I

    iput v4, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    iput v4, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    iput v3, p0, Landroid/media/RemoteControlClient;->mTransportControlFlags:I

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Landroid/media/RemoteControlClient;->mMetadata:Landroid/os/Bundle;

    iput v2, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    const/4 v0, -0x2

    iput v0, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    new-instance v0, Landroid/media/RemoteControlClient$1;

    invoke-direct {v0, p0}, Landroid/media/RemoteControlClient$1;-><init>(Landroid/media/RemoteControlClient;)V

    iput-object v0, p0, Landroid/media/RemoteControlClient;->mIRCC:Landroid/media/IRemoteControlClient;

    iput v2, p0, Landroid/media/RemoteControlClient;->mRcseId:I

    iput-object p1, p0, Landroid/media/RemoteControlClient;->mRcMediaIntent:Landroid/app/PendingIntent;

    new-instance v0, Landroid/media/RemoteControlClient$EventHandler;

    invoke-direct {v0, p0, p0, p2}, Landroid/media/RemoteControlClient$EventHandler;-><init>(Landroid/media/RemoteControlClient;Landroid/media/RemoteControlClient;Landroid/os/Looper;)V

    iput-object v0, p0, Landroid/media/RemoteControlClient;->mEventHandler:Landroid/media/RemoteControlClient$EventHandler;

    return-void
.end method

.method static synthetic access$000()[I
    .registers 1

    .prologue
    sget-object v0, Landroid/media/RemoteControlClient;->METADATA_KEYS_TYPE_STRING:[I

    return-object v0
.end method

.method static synthetic access$100(I[I)Z
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-static {p0, p1}, Landroid/media/RemoteControlClient;->validTypeForKey(I[I)Z

    move-result v0

    return v0
.end method

.method static synthetic access$1000(Landroid/media/RemoteControlClient;)V
    .registers 1
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendMetadata_syncCacheLock()V

    return-void
.end method

.method static synthetic access$1100(Landroid/media/RemoteControlClient;)V
    .registers 1
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendArtwork_syncCacheLock()V

    return-void
.end method

.method static synthetic access$1300(Landroid/media/RemoteControlClient;)Landroid/media/RemoteControlClient$EventHandler;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/media/RemoteControlClient;->mEventHandler:Landroid/media/RemoteControlClient$EventHandler;

    return-object v0
.end method

.method static synthetic access$1400(Landroid/media/RemoteControlClient;)V
    .registers 1
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendPlaybackState_syncCacheLock()V

    return-void
.end method

.method static synthetic access$1500(Landroid/media/RemoteControlClient;)V
    .registers 1
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendTransportControlFlags_syncCacheLock()V

    return-void
.end method

.method static synthetic access$1600(Landroid/media/RemoteControlClient;Ljava/lang/Integer;II)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"

    .prologue
    invoke-direct {p0, p1, p2, p3}, Landroid/media/RemoteControlClient;->onNewInternalClientGen(Ljava/lang/Integer;II)V

    return-void
.end method

.method static synthetic access$1700(Landroid/media/RemoteControlClient;I)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/media/RemoteControlClient;->onNewCurrentClientGen(I)V

    return-void
.end method

.method static synthetic access$1800(Landroid/media/RemoteControlClient;Landroid/media/IRemoteControlDisplay;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/media/RemoteControlClient;->onPlugDisplay(Landroid/media/IRemoteControlDisplay;)V

    return-void
.end method

.method static synthetic access$1900(Landroid/media/RemoteControlClient;Landroid/media/IRemoteControlDisplay;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/media/RemoteControlClient;->onUnplugDisplay(Landroid/media/IRemoteControlDisplay;)V

    return-void
.end method

.method static synthetic access$200()[I
    .registers 1

    .prologue
    sget-object v0, Landroid/media/RemoteControlClient;->METADATA_KEYS_TYPE_LONG:[I

    return-object v0
.end method

.method static synthetic access$300(Landroid/media/RemoteControlClient;)I
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    return v0
.end method

.method static synthetic access$400(Landroid/media/RemoteControlClient;)I
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    return v0
.end method

.method static synthetic access$500(Landroid/media/RemoteControlClient;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    .registers 5
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"

    .prologue
    invoke-direct {p0, p1, p2, p3}, Landroid/media/RemoteControlClient;->scaleBitmapIfTooBig(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$600(Landroid/media/RemoteControlClient;)Ljava/lang/Object;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$702(Landroid/media/RemoteControlClient;Landroid/os/Bundle;)Landroid/os/Bundle;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Landroid/media/RemoteControlClient;->mMetadata:Landroid/os/Bundle;

    return-object p1
.end method

.method static synthetic access$800(Landroid/media/RemoteControlClient;)Landroid/graphics/Bitmap;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method static synthetic access$802(Landroid/media/RemoteControlClient;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    return-object p1
.end method

.method static synthetic access$900(Landroid/media/RemoteControlClient;)V
    .registers 1
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendMetadataWithArtwork_syncCacheLock()V

    return-void
.end method

.method private detachFromDisplay_syncCacheLock()V
    .registers 3

    .prologue
    const/4 v1, -0x1

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    iput v1, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    iput v1, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    return-void
.end method

.method private static getService()Landroid/media/IAudioService;
    .registers 2

    .prologue
    sget-object v1, Landroid/media/RemoteControlClient;->sService:Landroid/media/IAudioService;

    if-eqz v1, :cond_7

    sget-object v1, Landroid/media/RemoteControlClient;->sService:Landroid/media/IAudioService;

    .local v0, b:Landroid/os/IBinder;
    :goto_6
    return-object v1

    .end local v0           #b:Landroid/os/IBinder;
    :cond_7
    const-string v1, "audio"

    invoke-static {v1}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    .restart local v0       #b:Landroid/os/IBinder;
    invoke-static {v0}, Landroid/media/IAudioService$Stub;->asInterface(Landroid/os/IBinder;)Landroid/media/IAudioService;

    move-result-object v1

    sput-object v1, Landroid/media/RemoteControlClient;->sService:Landroid/media/IAudioService;

    sget-object v1, Landroid/media/RemoteControlClient;->sService:Landroid/media/IAudioService;

    goto :goto_6
.end method

.method private onNewCurrentClientGen(I)V
    .registers 4
    .parameter "clientGeneration"

    .prologue
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iput p1, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    monitor-exit v1

    return-void

    :catchall_7
    move-exception v0

    monitor-exit v1
    :try_end_9
    .catchall {:try_start_3 .. :try_end_9} :catchall_7

    throw v0
.end method

.method private onNewInternalClientGen(Ljava/lang/Integer;II)V
    .registers 6
    .parameter "clientGeneration"
    .parameter "artWidth"
    .parameter "artHeight"

    .prologue
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    if-lez p2, :cond_f

    iput p2, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    iput p3, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    :cond_f
    monitor-exit v1

    return-void

    :catchall_11
    move-exception v0

    monitor-exit v1
    :try_end_13
    .catchall {:try_start_3 .. :try_end_13} :catchall_11

    throw v0
.end method

.method private onPlugDisplay(Landroid/media/IRemoteControlDisplay;)V
    .registers 4
    .parameter "rcd"

    .prologue
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iput-object p1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    monitor-exit v1

    return-void

    :catchall_7
    move-exception v0

    monitor-exit v1
    :try_end_9
    .catchall {:try_start_3 .. :try_end_9} :catchall_7

    throw v0
.end method

.method private onUnplugDisplay(Landroid/media/IRemoteControlDisplay;)V
    .registers 5
    .parameter "rcd"

    .prologue
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget-object v0, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    if-eqz v0, :cond_22

    iget-object v0, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    invoke-interface {v0}, Landroid/media/IRemoteControlDisplay;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-interface {p1}, Landroid/media/IRemoteControlDisplay;->asBinder()Landroid/os/IBinder;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_22

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    const/16 v0, 0x100

    iput v0, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    const/16 v0, 0x100

    iput v0, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    :cond_22
    monitor-exit v1

    return-void

    :catchall_24
    move-exception v0

    monitor-exit v1
    :try_end_26
    .catchall {:try_start_3 .. :try_end_26} :catchall_24

    throw v0
.end method

.method private scaleBitmapIfTooBig(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    .registers 20
    .parameter "bitmap"
    .parameter "maxWidth"
    .parameter "maxHeight"

    .prologue
    if-eqz p1, :cond_63

    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v9

    .local v9, width:I
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    .local v2, height:I
    move/from16 v0, p2

    if-gt v9, v0, :cond_12

    move/from16 v0, p3

    if-le v2, v0, :cond_63

    :cond_12
    move/from16 v0, p2

    int-to-float v10, v0

    int-to-float v11, v9

    div-float/2addr v10, v11

    move/from16 v0, p3

    int-to-float v11, v0

    int-to-float v12, v2

    div-float/2addr v11, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->min(FF)F

    move-result v8

    .local v8, scale:F
    int-to-float v10, v9

    mul-float/2addr v10, v8

    invoke-static {v10}, Ljava/lang/Math;->round(F)I

    move-result v5

    .local v5, newWidth:I
    int-to-float v10, v2

    mul-float/2addr v10, v8

    invoke-static {v10}, Ljava/lang/Math;->round(F)I

    move-result v4

    .local v4, newHeight:I
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v3

    .local v3, newConfig:Landroid/graphics/Bitmap$Config;
    if-nez v3, :cond_34

    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    :cond_34
    invoke-static {v5, v4, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v6

    .local v6, outBitmap:Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v6}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .local v1, canvas:Landroid/graphics/Canvas;
    new-instance v7, Landroid/graphics/Paint;

    invoke-direct {v7}, Landroid/graphics/Paint;-><init>()V

    .local v7, paint:Landroid/graphics/Paint;
    const/4 v10, 0x1

    invoke-virtual {v7, v10}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    const/4 v10, 0x1

    invoke-virtual {v7, v10}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    const/4 v10, 0x0

    new-instance v11, Landroid/graphics/RectF;

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-virtual {v6}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v14

    int-to-float v14, v14

    invoke-virtual {v6}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v15

    int-to-float v15, v15

    invoke-direct {v11, v12, v13, v14, v15}, Landroid/graphics/RectF;-><init>(FFFF)V

    move-object/from16 v0, p1

    invoke-virtual {v1, v0, v10, v11, v7}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    move-object/from16 p1, v6

    .end local v1           #canvas:Landroid/graphics/Canvas;
    .end local v2           #height:I
    .end local v3           #newConfig:Landroid/graphics/Bitmap$Config;
    .end local v4           #newHeight:I
    .end local v5           #newWidth:I
    .end local v6           #outBitmap:Landroid/graphics/Bitmap;
    .end local v7           #paint:Landroid/graphics/Paint;
    .end local v8           #scale:F
    .end local v9           #width:I
    :cond_63
    return-object p1
.end method

.method private sendArtwork_syncCacheLock()V
    .registers 5

    .prologue
    iget v1, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    if-ne v1, v2, :cond_1f

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    if-eqz v1, :cond_1f

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    iget v2, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    iget v3, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    invoke-direct {p0, v1, v2, v3}, Landroid/media/RemoteControlClient;->scaleBitmapIfTooBig(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    :try_start_16
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    iget-object v3, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    invoke-interface {v1, v2, v3}, Landroid/media/IRemoteControlDisplay;->setArtwork(ILandroid/graphics/Bitmap;)V
    :try_end_1f
    .catch Landroid/os/RemoteException; {:try_start_16 .. :try_end_1f} :catch_20

    :cond_1f
    :goto_1f
    return-void

    :catch_20
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "RemoteControlClient"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error in sendArtwork(), dead display "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0}, Landroid/media/RemoteControlClient;->detachFromDisplay_syncCacheLock()V

    goto :goto_1f
.end method

.method private sendAudioServiceNewPlaybackInfo_syncCacheLock(II)V
    .registers 7
    .parameter "what"
    .parameter "value"

    .prologue
    iget v2, p0, Landroid/media/RemoteControlClient;->mRcseId:I

    const/4 v3, -0x1

    if-ne v2, v3, :cond_6

    :goto_5
    return-void

    :cond_6
    invoke-static {}, Landroid/media/RemoteControlClient;->getService()Landroid/media/IAudioService;

    move-result-object v1

    .local v1, service:Landroid/media/IAudioService;
    :try_start_a
    iget v2, p0, Landroid/media/RemoteControlClient;->mRcseId:I

    invoke-interface {v1, v2, p1, p2}, Landroid/media/IAudioService;->setPlaybackInfoForRcc(III)V
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_f} :catch_10

    goto :goto_5

    :catch_10
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-string v2, "RemoteControlClient"

    const-string v3, "Dead object in sendAudioServiceNewPlaybackInfo_syncCacheLock"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_5
.end method

.method private sendMetadataWithArtwork_syncCacheLock()V
    .registers 6

    .prologue
    iget v1, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    if-ne v1, v2, :cond_21

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    if-eqz v1, :cond_21

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    iget v2, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    iget v3, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    invoke-direct {p0, v1, v2, v3}, Landroid/media/RemoteControlClient;->scaleBitmapIfTooBig(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    :try_start_16
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    iget-object v3, p0, Landroid/media/RemoteControlClient;->mMetadata:Landroid/os/Bundle;

    iget-object v4, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    invoke-interface {v1, v2, v3, v4}, Landroid/media/IRemoteControlDisplay;->setAllMetadata(ILandroid/os/Bundle;Landroid/graphics/Bitmap;)V
    :try_end_21
    .catch Landroid/os/RemoteException; {:try_start_16 .. :try_end_21} :catch_22

    :cond_21
    :goto_21
    return-void

    :catch_22
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "RemoteControlClient"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error in setAllMetadata(), dead display "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0}, Landroid/media/RemoteControlClient;->detachFromDisplay_syncCacheLock()V

    goto :goto_21
.end method

.method private sendMetadata_syncCacheLock()V
    .registers 5

    .prologue
    iget v1, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    if-ne v1, v2, :cond_13

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    if-eqz v1, :cond_13

    :try_start_a
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    iget-object v3, p0, Landroid/media/RemoteControlClient;->mMetadata:Landroid/os/Bundle;

    invoke-interface {v1, v2, v3}, Landroid/media/IRemoteControlDisplay;->setMetadata(ILandroid/os/Bundle;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_13} :catch_14

    :cond_13
    :goto_13
    return-void

    :catch_14
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "RemoteControlClient"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error in sendPlaybackState(), dead display "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0}, Landroid/media/RemoteControlClient;->detachFromDisplay_syncCacheLock()V

    goto :goto_13
.end method

.method private sendPlaybackState_syncCacheLock()V
    .registers 7

    .prologue
    iget v1, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    if-ne v1, v2, :cond_15

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    if-eqz v1, :cond_15

    :try_start_a
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    iget v3, p0, Landroid/media/RemoteControlClient;->mPlaybackState:I

    iget-wide v4, p0, Landroid/media/RemoteControlClient;->mPlaybackStateChangeTimeMs:J

    invoke-interface {v1, v2, v3, v4, v5}, Landroid/media/IRemoteControlDisplay;->setPlaybackState(IIJ)V
    :try_end_15
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_15} :catch_16

    :cond_15
    :goto_15
    return-void

    :catch_16
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "RemoteControlClient"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error in setPlaybackState(), dead display "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0}, Landroid/media/RemoteControlClient;->detachFromDisplay_syncCacheLock()V

    goto :goto_15
.end method

.method private sendTransportControlFlags_syncCacheLock()V
    .registers 5

    .prologue
    iget v1, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    if-ne v1, v2, :cond_13

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    if-eqz v1, :cond_13

    :try_start_a
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    iget v3, p0, Landroid/media/RemoteControlClient;->mTransportControlFlags:I

    invoke-interface {v1, v2, v3}, Landroid/media/IRemoteControlDisplay;->setTransportControlFlags(II)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_13} :catch_14

    :cond_13
    :goto_13
    return-void

    :catch_14
    move-exception v0

    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "RemoteControlClient"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error in sendTransportControlFlags(), dead display "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-direct {p0}, Landroid/media/RemoteControlClient;->detachFromDisplay_syncCacheLock()V

    goto :goto_13
.end method

.method private static validTypeForKey(I[I)Z
    .registers 5
    .parameter "key"
    .parameter "validKeys"

    .prologue
    const/4 v1, 0x0

    .local v1, i:I
    :goto_1
    :try_start_1
    aget v2, p1, v1
    :try_end_3
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_1 .. :try_end_3} :catch_a

    if-ne p0, v2, :cond_7

    const/4 v2, 0x1

    :goto_6
    return v2

    :cond_7
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :catch_a
    move-exception v0

    .local v0, e:Ljava/lang/ArrayIndexOutOfBoundsException;
    const/4 v2, 0x0

    goto :goto_6
.end method


# virtual methods
.method public editMetadata(Z)Landroid/media/RemoteControlClient$MetadataEditor;
    .registers 7
    .parameter "startEmpty"

    .prologue
    const/4 v4, 0x0

    const/4 v2, 0x1

    const/4 v3, 0x0

    new-instance v0, Landroid/media/RemoteControlClient$MetadataEditor;

    invoke-direct {v0, p0, v4}, Landroid/media/RemoteControlClient$MetadataEditor;-><init>(Landroid/media/RemoteControlClient;Landroid/media/RemoteControlClient$1;)V

    .local v0, editor:Landroid/media/RemoteControlClient$MetadataEditor;
    if-eqz p1, :cond_18

    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    iput-object v1, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mEditorMetadata:Landroid/os/Bundle;

    iput-object v4, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mEditorArtwork:Landroid/graphics/Bitmap;

    iput-boolean v2, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mMetadataChanged:Z

    iput-boolean v2, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mArtworkChanged:Z

    :goto_17
    return-object v0

    :cond_18
    new-instance v1, Landroid/os/Bundle;

    iget-object v2, p0, Landroid/media/RemoteControlClient;->mMetadata:Landroid/os/Bundle;

    invoke-direct {v1, v2}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    iput-object v1, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mEditorMetadata:Landroid/os/Bundle;

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    iput-object v1, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mEditorArtwork:Landroid/graphics/Bitmap;

    iput-boolean v3, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mMetadataChanged:Z

    iput-boolean v3, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mArtworkChanged:Z

    goto :goto_17
.end method

.method public getIRemoteControlClient()Landroid/media/IRemoteControlClient;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/media/RemoteControlClient;->mIRCC:Landroid/media/IRemoteControlClient;

    return-object v0
.end method

.method public getIntPlaybackInformation(I)I
    .registers 6
    .parameter "what"

    .prologue
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    packed-switch p1, :pswitch_data_3a

    :try_start_6
    const-string v0, "RemoteControlClient"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getIntPlaybackInformation() unknown key "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    const/high16 v0, -0x8000

    monitor-exit v1

    :goto_21
    return v0

    :pswitch_22
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackType:I

    monitor-exit v1

    goto :goto_21

    :catchall_26
    move-exception v0

    monitor-exit v1
    :try_end_28
    .catchall {:try_start_6 .. :try_end_28} :catchall_26

    throw v0

    :pswitch_29
    :try_start_29
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolume:I

    monitor-exit v1

    goto :goto_21

    :pswitch_2d
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeMax:I

    monitor-exit v1

    goto :goto_21

    :pswitch_31
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackStream:I

    monitor-exit v1

    goto :goto_21

    :pswitch_35
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeHandling:I

    monitor-exit v1
    :try_end_38
    .catchall {:try_start_29 .. :try_end_38} :catchall_26

    goto :goto_21

    nop

    :pswitch_data_3a
    .packed-switch 0x1
        :pswitch_22
        :pswitch_29
        :pswitch_2d
        :pswitch_35
        :pswitch_31
    .end packed-switch
.end method

.method public getRcMediaIntent()Landroid/app/PendingIntent;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/media/RemoteControlClient;->mRcMediaIntent:Landroid/app/PendingIntent;

    return-object v0
.end method

.method public getRcseId()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/media/RemoteControlClient;->mRcseId:I

    return v0
.end method

.method public setPlaybackInformation(II)V
    .registers 7
    .parameter "what"
    .parameter "value"

    .prologue
    const/4 v0, 0x1

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    packed-switch p1, :pswitch_data_96

    :try_start_7
    const-string v0, "RemoteControlClient"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "setPlaybackInformation() ignoring unknown key "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_20
    :goto_20
    monitor-exit v1

    return-void

    :pswitch_22
    if-ltz p2, :cond_33

    if-gt p2, v0, :cond_33

    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackType:I

    if-eq v0, p2, :cond_20

    iput p2, p0, Landroid/media/RemoteControlClient;->mPlaybackType:I

    invoke-direct {p0, p1, p2}, Landroid/media/RemoteControlClient;->sendAudioServiceNewPlaybackInfo_syncCacheLock(II)V

    goto :goto_20

    :catchall_30
    move-exception v0

    monitor-exit v1
    :try_end_32
    .catchall {:try_start_7 .. :try_end_32} :catchall_30

    throw v0

    :cond_33
    :try_start_33
    const-string v0, "RemoteControlClient"

    const-string/jumbo v2, "using invalid value for PLAYBACKINFO_PLAYBACK_TYPE"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_20

    :pswitch_3c
    const/4 v0, -0x1

    if-le p2, v0, :cond_4d

    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeMax:I

    if-gt p2, v0, :cond_4d

    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolume:I

    if-eq v0, p2, :cond_20

    iput p2, p0, Landroid/media/RemoteControlClient;->mPlaybackVolume:I

    invoke-direct {p0, p1, p2}, Landroid/media/RemoteControlClient;->sendAudioServiceNewPlaybackInfo_syncCacheLock(II)V

    goto :goto_20

    :cond_4d
    const-string v0, "RemoteControlClient"

    const-string/jumbo v2, "using invalid value for PLAYBACKINFO_VOLUME"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_20

    :pswitch_56
    if-lez p2, :cond_62

    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeMax:I

    if-eq v0, p2, :cond_20

    iput p2, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeMax:I

    invoke-direct {p0, p1, p2}, Landroid/media/RemoteControlClient;->sendAudioServiceNewPlaybackInfo_syncCacheLock(II)V

    goto :goto_20

    :cond_62
    const-string v0, "RemoteControlClient"

    const-string/jumbo v2, "using invalid value for PLAYBACKINFO_VOLUME_MAX"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_20

    :pswitch_6b
    if-ltz p2, :cond_76

    invoke-static {}, Landroid/media/AudioSystem;->getNumStreamTypes()I

    move-result v0

    if-ge p2, v0, :cond_76

    iput p2, p0, Landroid/media/RemoteControlClient;->mPlaybackStream:I

    goto :goto_20

    :cond_76
    const-string v0, "RemoteControlClient"

    const-string/jumbo v2, "using invalid value for PLAYBACKINFO_USES_STREAM"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_20

    :pswitch_7f
    if-ltz p2, :cond_8d

    if-gt p2, v0, :cond_8d

    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeHandling:I

    if-eq v0, p2, :cond_20

    iput p2, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeHandling:I

    invoke-direct {p0, p1, p2}, Landroid/media/RemoteControlClient;->sendAudioServiceNewPlaybackInfo_syncCacheLock(II)V

    goto :goto_20

    :cond_8d
    const-string v0, "RemoteControlClient"

    const-string/jumbo v2, "using invalid value for PLAYBACKINFO_VOLUME_HANDLING"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_95
    .catchall {:try_start_33 .. :try_end_95} :catchall_30

    goto :goto_20

    :pswitch_data_96
    .packed-switch 0x1
        :pswitch_22
        :pswitch_3c
        :pswitch_56
        :pswitch_7f
        :pswitch_6b
    .end packed-switch
.end method

.method public setPlaybackState(I)V
    .registers 6
    .parameter "state"

    .prologue
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackState:I

    if-eq v0, p1, :cond_17

    iput p1, p0, Landroid/media/RemoteControlClient;->mPlaybackState:I

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    iput-wide v2, p0, Landroid/media/RemoteControlClient;->mPlaybackStateChangeTimeMs:J

    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendPlaybackState_syncCacheLock()V

    const/16 v0, 0xff

    invoke-direct {p0, v0, p1}, Landroid/media/RemoteControlClient;->sendAudioServiceNewPlaybackInfo_syncCacheLock(II)V

    :cond_17
    monitor-exit v1

    return-void

    :catchall_19
    move-exception v0

    monitor-exit v1
    :try_end_1b
    .catchall {:try_start_3 .. :try_end_1b} :catchall_19

    throw v0
.end method

.method public setRcseId(I)V
    .registers 2
    .parameter "id"

    .prologue
    iput p1, p0, Landroid/media/RemoteControlClient;->mRcseId:I

    return-void
.end method

.method public setTransportControlFlags(I)V
    .registers 4
    .parameter "transportControlFlags"

    .prologue
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iput p1, p0, Landroid/media/RemoteControlClient;->mTransportControlFlags:I

    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendTransportControlFlags_syncCacheLock()V

    monitor-exit v1

    return-void

    :catchall_a
    move-exception v0

    monitor-exit v1
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_a

    throw v0
.end method
