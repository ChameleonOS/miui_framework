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
    .line 355
    const/16 v0, 0xb

    new-array v0, v0, [I

    fill-array-data v0, :array_12

    sput-object v0, Landroid/media/RemoteControlClient;->METADATA_KEYS_TYPE_STRING:[I

    .line 367
    const/4 v0, 0x3

    new-array v0, v0, [I

    fill-array-data v0, :array_2c

    sput-object v0, Landroid/media/RemoteControlClient;->METADATA_KEYS_TYPE_LONG:[I

    return-void

    .line 355
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

    .line 367
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

    .line 320
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 638
    iput v4, p0, Landroid/media/RemoteControlClient;->mPlaybackType:I

    .line 639
    iput v1, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeMax:I

    .line 640
    iput v1, p0, Landroid/media/RemoteControlClient;->mPlaybackVolume:I

    .line 641
    const/4 v1, 0x1

    iput v1, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeHandling:I

    .line 642
    const/4 v1, 0x3

    iput v1, p0, Landroid/media/RemoteControlClient;->mPlaybackStream:I

    .line 751
    new-instance v1, Ljava/lang/Object;

    invoke-direct/range {v1 .. v1}, Ljava/lang/Object;-><init>()V

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    .line 756
    iput v4, p0, Landroid/media/RemoteControlClient;->mPlaybackState:I

    .line 761
    const-wide/16 v1, 0x0

    iput-wide v1, p0, Landroid/media/RemoteControlClient;->mPlaybackStateChangeTimeMs:J

    .line 770
    iput v5, p0, Landroid/media/RemoteControlClient;->ARTWORK_DEFAULT_SIZE:I

    .line 771
    iput v3, p0, Landroid/media/RemoteControlClient;->ARTWORK_INVALID_SIZE:I

    .line 772
    iput v5, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    .line 773
    iput v5, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    .line 778
    iput v4, p0, Landroid/media/RemoteControlClient;->mTransportControlFlags:I

    .line 784
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mMetadata:Landroid/os/Bundle;

    .line 789
    iput v3, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    .line 796
    const/4 v1, -0x2

    iput v1, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    .line 828
    new-instance v1, Landroid/media/RemoteControlClient$1;

    invoke-direct {v1, p0}, Landroid/media/RemoteControlClient$1;-><init>(Landroid/media/RemoteControlClient;)V

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mIRCC:Landroid/media/IRemoteControlClient;

    .line 890
    iput v3, p0, Landroid/media/RemoteControlClient;->mRcseId:I

    .line 321
    iput-object p1, p0, Landroid/media/RemoteControlClient;->mRcMediaIntent:Landroid/app/PendingIntent;

    .line 324
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    .local v0, looper:Landroid/os/Looper;
    if-eqz v0, :cond_51

    .line 325
    new-instance v1, Landroid/media/RemoteControlClient$EventHandler;

    invoke-direct {v1, p0, p0, v0}, Landroid/media/RemoteControlClient$EventHandler;-><init>(Landroid/media/RemoteControlClient;Landroid/media/RemoteControlClient;Landroid/os/Looper;)V

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mEventHandler:Landroid/media/RemoteControlClient$EventHandler;

    .line 332
    :goto_50
    return-void

    .line 326
    :cond_51
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    if-eqz v0, :cond_5f

    .line 327
    new-instance v1, Landroid/media/RemoteControlClient$EventHandler;

    invoke-direct {v1, p0, p0, v0}, Landroid/media/RemoteControlClient$EventHandler;-><init>(Landroid/media/RemoteControlClient;Landroid/media/RemoteControlClient;Landroid/os/Looper;)V

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mEventHandler:Landroid/media/RemoteControlClient$EventHandler;

    goto :goto_50

    .line 329
    :cond_5f
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mEventHandler:Landroid/media/RemoteControlClient$EventHandler;

    .line 330
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

    .line 349
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 638
    iput v3, p0, Landroid/media/RemoteControlClient;->mPlaybackType:I

    .line 639
    iput v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeMax:I

    .line 640
    iput v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolume:I

    .line 641
    const/4 v0, 0x1

    iput v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeHandling:I

    .line 642
    const/4 v0, 0x3

    iput v0, p0, Landroid/media/RemoteControlClient;->mPlaybackStream:I

    .line 751
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    .line 756
    iput v3, p0, Landroid/media/RemoteControlClient;->mPlaybackState:I

    .line 761
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/media/RemoteControlClient;->mPlaybackStateChangeTimeMs:J

    .line 770
    iput v4, p0, Landroid/media/RemoteControlClient;->ARTWORK_DEFAULT_SIZE:I

    .line 771
    iput v2, p0, Landroid/media/RemoteControlClient;->ARTWORK_INVALID_SIZE:I

    .line 772
    iput v4, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    .line 773
    iput v4, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    .line 778
    iput v3, p0, Landroid/media/RemoteControlClient;->mTransportControlFlags:I

    .line 784
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Landroid/media/RemoteControlClient;->mMetadata:Landroid/os/Bundle;

    .line 789
    iput v2, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    .line 796
    const/4 v0, -0x2

    iput v0, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    .line 828
    new-instance v0, Landroid/media/RemoteControlClient$1;

    invoke-direct {v0, p0}, Landroid/media/RemoteControlClient$1;-><init>(Landroid/media/RemoteControlClient;)V

    iput-object v0, p0, Landroid/media/RemoteControlClient;->mIRCC:Landroid/media/IRemoteControlClient;

    .line 890
    iput v2, p0, Landroid/media/RemoteControlClient;->mRcseId:I

    .line 350
    iput-object p1, p0, Landroid/media/RemoteControlClient;->mRcMediaIntent:Landroid/app/PendingIntent;

    .line 352
    new-instance v0, Landroid/media/RemoteControlClient$EventHandler;

    invoke-direct {v0, p0, p0, p2}, Landroid/media/RemoteControlClient$EventHandler;-><init>(Landroid/media/RemoteControlClient;Landroid/media/RemoteControlClient;Landroid/os/Looper;)V

    iput-object v0, p0, Landroid/media/RemoteControlClient;->mEventHandler:Landroid/media/RemoteControlClient$EventHandler;

    .line 353
    return-void
.end method

.method static synthetic access$000()[I
    .registers 1

    .prologue
    .line 63
    sget-object v0, Landroid/media/RemoteControlClient;->METADATA_KEYS_TYPE_STRING:[I

    return-object v0
.end method

.method static synthetic access$100(I[I)Z
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 63
    invoke-static {p0, p1}, Landroid/media/RemoteControlClient;->validTypeForKey(I[I)Z

    move-result v0

    return v0
.end method

.method static synthetic access$1000(Landroid/media/RemoteControlClient;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 63
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendMetadata_syncCacheLock()V

    return-void
.end method

.method static synthetic access$1100(Landroid/media/RemoteControlClient;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 63
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendArtwork_syncCacheLock()V

    return-void
.end method

.method static synthetic access$1300(Landroid/media/RemoteControlClient;)Landroid/media/RemoteControlClient$EventHandler;
    .registers 2
    .parameter "x0"

    .prologue
    .line 63
    iget-object v0, p0, Landroid/media/RemoteControlClient;->mEventHandler:Landroid/media/RemoteControlClient$EventHandler;

    return-object v0
.end method

.method static synthetic access$1400(Landroid/media/RemoteControlClient;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 63
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendPlaybackState_syncCacheLock()V

    return-void
.end method

.method static synthetic access$1500(Landroid/media/RemoteControlClient;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 63
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
    .line 63
    invoke-direct {p0, p1, p2, p3}, Landroid/media/RemoteControlClient;->onNewInternalClientGen(Ljava/lang/Integer;II)V

    return-void
.end method

.method static synthetic access$1700(Landroid/media/RemoteControlClient;I)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 63
    invoke-direct {p0, p1}, Landroid/media/RemoteControlClient;->onNewCurrentClientGen(I)V

    return-void
.end method

.method static synthetic access$1800(Landroid/media/RemoteControlClient;Landroid/media/IRemoteControlDisplay;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 63
    invoke-direct {p0, p1}, Landroid/media/RemoteControlClient;->onPlugDisplay(Landroid/media/IRemoteControlDisplay;)V

    return-void
.end method

.method static synthetic access$1900(Landroid/media/RemoteControlClient;Landroid/media/IRemoteControlDisplay;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 63
    invoke-direct {p0, p1}, Landroid/media/RemoteControlClient;->onUnplugDisplay(Landroid/media/IRemoteControlDisplay;)V

    return-void
.end method

.method static synthetic access$200()[I
    .registers 1

    .prologue
    .line 63
    sget-object v0, Landroid/media/RemoteControlClient;->METADATA_KEYS_TYPE_LONG:[I

    return-object v0
.end method

.method static synthetic access$300(Landroid/media/RemoteControlClient;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 63
    iget v0, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    return v0
.end method

.method static synthetic access$400(Landroid/media/RemoteControlClient;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 63
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
    .line 63
    invoke-direct {p0, p1, p2, p3}, Landroid/media/RemoteControlClient;->scaleBitmapIfTooBig(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$600(Landroid/media/RemoteControlClient;)Ljava/lang/Object;
    .registers 2
    .parameter "x0"

    .prologue
    .line 63
    iget-object v0, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$702(Landroid/media/RemoteControlClient;Landroid/os/Bundle;)Landroid/os/Bundle;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 63
    iput-object p1, p0, Landroid/media/RemoteControlClient;->mMetadata:Landroid/os/Bundle;

    return-object p1
.end method

.method static synthetic access$800(Landroid/media/RemoteControlClient;)Landroid/graphics/Bitmap;
    .registers 2
    .parameter "x0"

    .prologue
    .line 63
    iget-object v0, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method static synthetic access$802(Landroid/media/RemoteControlClient;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 63
    iput-object p1, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    return-object p1
.end method

.method static synthetic access$900(Landroid/media/RemoteControlClient;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 63
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendMetadataWithArtwork_syncCacheLock()V

    return-void
.end method

.method private detachFromDisplay_syncCacheLock()V
    .registers 3

    .prologue
    const/4 v1, -0x1

    .line 969
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    .line 970
    iput v1, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    .line 971
    iput v1, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    .line 972
    return-void
.end method

.method private static getService()Landroid/media/IAudioService;
    .registers 2

    .prologue
    .line 1046
    sget-object v1, Landroid/media/RemoteControlClient;->sService:Landroid/media/IAudioService;

    if-eqz v1, :cond_7

    .line 1047
    sget-object v1, Landroid/media/RemoteControlClient;->sService:Landroid/media/IAudioService;

    .line 1051
    .local v0, b:Landroid/os/IBinder;
    :goto_6
    return-object v1

    .line 1049
    .end local v0           #b:Landroid/os/IBinder;
    :cond_7
    const-string v1, "audio"

    invoke-static {v1}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    .line 1050
    .restart local v0       #b:Landroid/os/IBinder;
    invoke-static {v0}, Landroid/media/IAudioService$Stub;->asInterface(Landroid/os/IBinder;)Landroid/media/IAudioService;

    move-result-object v1

    sput-object v1, Landroid/media/RemoteControlClient;->sService:Landroid/media/IAudioService;

    .line 1051
    sget-object v1, Landroid/media/RemoteControlClient;->sService:Landroid/media/IAudioService;

    goto :goto_6
.end method

.method private onNewCurrentClientGen(I)V
    .registers 4
    .parameter "clientGeneration"

    .prologue
    .line 1083
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1084
    :try_start_3
    iput p1, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    .line 1085
    monitor-exit v1

    .line 1086
    return-void

    .line 1085
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
    .line 1071
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1074
    :try_start_3
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    .line 1075
    if-lez p2, :cond_f

    .line 1076
    iput p2, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    .line 1077
    iput p3, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    .line 1079
    :cond_f
    monitor-exit v1

    .line 1080
    return-void

    .line 1079
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
    .line 1089
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1090
    :try_start_3
    iput-object p1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    .line 1091
    monitor-exit v1

    .line 1092
    return-void

    .line 1091
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
    .line 1095
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    .line 1096
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

    .line 1097
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    .line 1098
    const/16 v0, 0x100

    iput v0, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    .line 1099
    const/16 v0, 0x100

    iput v0, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    .line 1101
    :cond_22
    monitor-exit v1

    .line 1102
    return-void

    .line 1101
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
    .line 1118
    if-eqz p1, :cond_63

    .line 1119
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v9

    .line 1120
    .local v9, width:I
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    .line 1121
    .local v2, height:I
    move/from16 v0, p2

    if-gt v9, v0, :cond_12

    move/from16 v0, p3

    if-le v2, v0, :cond_63

    .line 1122
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

    .line 1123
    .local v8, scale:F
    int-to-float v10, v9

    mul-float/2addr v10, v8

    invoke-static {v10}, Ljava/lang/Math;->round(F)I

    move-result v5

    .line 1124
    .local v5, newWidth:I
    int-to-float v10, v2

    mul-float/2addr v10, v8

    invoke-static {v10}, Ljava/lang/Math;->round(F)I

    move-result v4

    .line 1125
    .local v4, newHeight:I
    invoke-virtual/range {p1 .. p1}, Landroid/graphics/Bitmap;->getConfig()Landroid/graphics/Bitmap$Config;

    move-result-object v3

    .line 1126
    .local v3, newConfig:Landroid/graphics/Bitmap$Config;
    if-nez v3, :cond_34

    .line 1127
    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    .line 1129
    :cond_34
    invoke-static {v5, v4, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v6

    .line 1130
    .local v6, outBitmap:Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v6}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 1131
    .local v1, canvas:Landroid/graphics/Canvas;
    new-instance v7, Landroid/graphics/Paint;

    invoke-direct {v7}, Landroid/graphics/Paint;-><init>()V

    .line 1132
    .local v7, paint:Landroid/graphics/Paint;
    const/4 v10, 0x1

    invoke-virtual {v7, v10}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 1133
    const/4 v10, 0x1

    invoke-virtual {v7, v10}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    .line 1134
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

    .line 1136
    move-object/from16 p1, v6

    .line 1139
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
    .line 1010
    iget v1, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    if-ne v1, v2, :cond_1f

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    if-eqz v1, :cond_1f

    .line 1014
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    iget v2, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    iget v3, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    invoke-direct {p0, v1, v2, v3}, Landroid/media/RemoteControlClient;->scaleBitmapIfTooBig(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    .line 1016
    :try_start_16
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    iget-object v3, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    invoke-interface {v1, v2, v3}, Landroid/media/IRemoteControlDisplay;->setArtwork(ILandroid/graphics/Bitmap;)V
    :try_end_1f
    .catch Landroid/os/RemoteException; {:try_start_16 .. :try_end_1f} :catch_20

    .line 1022
    :cond_1f
    :goto_1f
    return-void

    .line 1017
    :catch_20
    move-exception v0

    .line 1018
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

    .line 1019
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->detachFromDisplay_syncCacheLock()V

    goto :goto_1f
.end method

.method private sendAudioServiceNewPlaybackInfo_syncCacheLock(II)V
    .registers 7
    .parameter "what"
    .parameter "value"

    .prologue
    .line 1055
    iget v2, p0, Landroid/media/RemoteControlClient;->mRcseId:I

    const/4 v3, -0x1

    if-ne v2, v3, :cond_6

    .line 1065
    :goto_5
    return-void

    .line 1059
    :cond_6
    invoke-static {}, Landroid/media/RemoteControlClient;->getService()Landroid/media/IAudioService;

    move-result-object v1

    .line 1061
    .local v1, service:Landroid/media/IAudioService;
    :try_start_a
    iget v2, p0, Landroid/media/RemoteControlClient;->mRcseId:I

    invoke-interface {v1, v2, p1, p2}, Landroid/media/IAudioService;->setPlaybackInfoForRcc(III)V
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_f} :catch_10

    goto :goto_5

    .line 1062
    :catch_10
    move-exception v0

    .line 1063
    .local v0, e:Landroid/os/RemoteException;
    const-string v2, "RemoteControlClient"

    const-string v3, "Dead object in sendAudioServiceNewPlaybackInfo_syncCacheLock"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_5
.end method

.method private sendMetadataWithArtwork_syncCacheLock()V
    .registers 6

    .prologue
    .line 1025
    iget v1, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    if-ne v1, v2, :cond_21

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    if-eqz v1, :cond_21

    .line 1029
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    iget v2, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedWidth:I

    iget v3, p0, Landroid/media/RemoteControlClient;->mArtworkExpectedHeight:I

    invoke-direct {p0, v1, v2, v3}, Landroid/media/RemoteControlClient;->scaleBitmapIfTooBig(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    .line 1031
    :try_start_16
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    iget-object v3, p0, Landroid/media/RemoteControlClient;->mMetadata:Landroid/os/Bundle;

    iget-object v4, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    invoke-interface {v1, v2, v3, v4}, Landroid/media/IRemoteControlDisplay;->setAllMetadata(ILandroid/os/Bundle;Landroid/graphics/Bitmap;)V
    :try_end_21
    .catch Landroid/os/RemoteException; {:try_start_16 .. :try_end_21} :catch_22

    .line 1037
    :cond_21
    :goto_21
    return-void

    .line 1032
    :catch_22
    move-exception v0

    .line 1033
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

    .line 1034
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->detachFromDisplay_syncCacheLock()V

    goto :goto_21
.end method

.method private sendMetadata_syncCacheLock()V
    .registers 5

    .prologue
    .line 987
    iget v1, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    if-ne v1, v2, :cond_13

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    if-eqz v1, :cond_13

    .line 989
    :try_start_a
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    iget-object v3, p0, Landroid/media/RemoteControlClient;->mMetadata:Landroid/os/Bundle;

    invoke-interface {v1, v2, v3}, Landroid/media/IRemoteControlDisplay;->setMetadata(ILandroid/os/Bundle;)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_13} :catch_14

    .line 995
    :cond_13
    :goto_13
    return-void

    .line 990
    :catch_14
    move-exception v0

    .line 991
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

    .line 992
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->detachFromDisplay_syncCacheLock()V

    goto :goto_13
.end method

.method private sendPlaybackState_syncCacheLock()V
    .registers 7

    .prologue
    .line 975
    iget v1, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    if-ne v1, v2, :cond_15

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    if-eqz v1, :cond_15

    .line 977
    :try_start_a
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    iget v3, p0, Landroid/media/RemoteControlClient;->mPlaybackState:I

    iget-wide v4, p0, Landroid/media/RemoteControlClient;->mPlaybackStateChangeTimeMs:J

    invoke-interface {v1, v2, v3, v4, v5}, Landroid/media/IRemoteControlDisplay;->setPlaybackState(IIJ)V
    :try_end_15
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_15} :catch_16

    .line 984
    :cond_15
    :goto_15
    return-void

    .line 979
    :catch_16
    move-exception v0

    .line 980
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

    .line 981
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->detachFromDisplay_syncCacheLock()V

    goto :goto_15
.end method

.method private sendTransportControlFlags_syncCacheLock()V
    .registers 5

    .prologue
    .line 998
    iget v1, p0, Landroid/media/RemoteControlClient;->mCurrentClientGenId:I

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    if-ne v1, v2, :cond_13

    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    if-eqz v1, :cond_13

    .line 1000
    :try_start_a
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mRcDisplay:Landroid/media/IRemoteControlDisplay;

    iget v2, p0, Landroid/media/RemoteControlClient;->mInternalClientGenId:I

    iget v3, p0, Landroid/media/RemoteControlClient;->mTransportControlFlags:I

    invoke-interface {v1, v2, v3}, Landroid/media/IRemoteControlDisplay;->setTransportControlFlags(II)V
    :try_end_13
    .catch Landroid/os/RemoteException; {:try_start_a .. :try_end_13} :catch_14

    .line 1007
    :cond_13
    :goto_13
    return-void

    .line 1002
    :catch_14
    move-exception v0

    .line 1003
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

    .line 1004
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->detachFromDisplay_syncCacheLock()V

    goto :goto_13
.end method

.method private static validTypeForKey(I[I)Z
    .registers 5
    .parameter "key"
    .parameter "validKeys"

    .prologue
    .line 1151
    const/4 v1, 0x0

    .line 1152
    .local v1, i:I
    :goto_1
    :try_start_1
    aget v2, p1, v1
    :try_end_3
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_1 .. :try_end_3} :catch_a

    if-ne p0, v2, :cond_7

    .line 1153
    const/4 v2, 0x1

    .line 1157
    :goto_6
    return v2

    .line 1151
    :cond_7
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 1156
    :catch_a
    move-exception v0

    .line 1157
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

    .line 566
    new-instance v0, Landroid/media/RemoteControlClient$MetadataEditor;

    invoke-direct {v0, p0, v4}, Landroid/media/RemoteControlClient$MetadataEditor;-><init>(Landroid/media/RemoteControlClient;Landroid/media/RemoteControlClient$1;)V

    .line 567
    .local v0, editor:Landroid/media/RemoteControlClient$MetadataEditor;
    if-eqz p1, :cond_18

    .line 568
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    iput-object v1, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mEditorMetadata:Landroid/os/Bundle;

    .line 569
    iput-object v4, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mEditorArtwork:Landroid/graphics/Bitmap;

    .line 570
    iput-boolean v2, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mMetadataChanged:Z

    .line 571
    iput-boolean v2, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mArtworkChanged:Z

    .line 578
    :goto_17
    return-object v0

    .line 573
    :cond_18
    new-instance v1, Landroid/os/Bundle;

    iget-object v2, p0, Landroid/media/RemoteControlClient;->mMetadata:Landroid/os/Bundle;

    invoke-direct {v1, v2}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    iput-object v1, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mEditorMetadata:Landroid/os/Bundle;

    .line 574
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mArtwork:Landroid/graphics/Bitmap;

    iput-object v1, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mEditorArtwork:Landroid/graphics/Bitmap;

    .line 575
    iput-boolean v3, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mMetadataChanged:Z

    .line 576
    iput-boolean v3, v0, Landroid/media/RemoteControlClient$MetadataEditor;->mArtworkChanged:Z

    goto :goto_17
.end method

.method public getIRemoteControlClient()Landroid/media/IRemoteControlClient;
    .registers 2

    .prologue
    .line 822
    iget-object v0, p0, Landroid/media/RemoteControlClient;->mIRCC:Landroid/media/IRemoteControlClient;

    return-object v0
.end method

.method public getIntPlaybackInformation(I)I
    .registers 6
    .parameter "what"

    .prologue
    .line 729
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    .line 730
    packed-switch p1, :pswitch_data_3a

    .line 742
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

    .line 743
    const/high16 v0, -0x8000

    monitor-exit v1

    :goto_21
    return v0

    .line 732
    :pswitch_22
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackType:I

    monitor-exit v1

    goto :goto_21

    .line 745
    :catchall_26
    move-exception v0

    monitor-exit v1
    :try_end_28
    .catchall {:try_start_6 .. :try_end_28} :catchall_26

    throw v0

    .line 734
    :pswitch_29
    :try_start_29
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolume:I

    monitor-exit v1

    goto :goto_21

    .line 736
    :pswitch_2d
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeMax:I

    monitor-exit v1

    goto :goto_21

    .line 738
    :pswitch_31
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackStream:I

    monitor-exit v1

    goto :goto_21

    .line 740
    :pswitch_35
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeHandling:I

    monitor-exit v1
    :try_end_38
    .catchall {:try_start_29 .. :try_end_38} :catchall_26

    goto :goto_21

    .line 730
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
    .line 815
    iget-object v0, p0, Landroid/media/RemoteControlClient;->mRcMediaIntent:Landroid/app/PendingIntent;

    return-object v0
.end method

.method public getRcseId()I
    .registers 2

    .prologue
    .line 906
    iget v0, p0, Landroid/media/RemoteControlClient;->mRcseId:I

    return v0
.end method

.method public setPlaybackInformation(II)V
    .registers 7
    .parameter "what"
    .parameter "value"

    .prologue
    const/4 v0, 0x1

    .line 657
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    .line 658
    packed-switch p1, :pswitch_data_96

    .line 709
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

    .line 712
    :cond_20
    :goto_20
    monitor-exit v1

    .line 713
    return-void

    .line 660
    :pswitch_22
    if-ltz p2, :cond_33

    if-gt p2, v0, :cond_33

    .line 661
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackType:I

    if-eq v0, p2, :cond_20

    .line 662
    iput p2, p0, Landroid/media/RemoteControlClient;->mPlaybackType:I

    .line 663
    invoke-direct {p0, p1, p2}, Landroid/media/RemoteControlClient;->sendAudioServiceNewPlaybackInfo_syncCacheLock(II)V

    goto :goto_20

    .line 712
    :catchall_30
    move-exception v0

    monitor-exit v1
    :try_end_32
    .catchall {:try_start_7 .. :try_end_32} :catchall_30

    throw v0

    .line 666
    :cond_33
    :try_start_33
    const-string v0, "RemoteControlClient"

    const-string/jumbo v2, "using invalid value for PLAYBACKINFO_PLAYBACK_TYPE"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_20

    .line 670
    :pswitch_3c
    const/4 v0, -0x1

    if-le p2, v0, :cond_4d

    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeMax:I

    if-gt p2, v0, :cond_4d

    .line 671
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolume:I

    if-eq v0, p2, :cond_20

    .line 672
    iput p2, p0, Landroid/media/RemoteControlClient;->mPlaybackVolume:I

    .line 673
    invoke-direct {p0, p1, p2}, Landroid/media/RemoteControlClient;->sendAudioServiceNewPlaybackInfo_syncCacheLock(II)V

    goto :goto_20

    .line 676
    :cond_4d
    const-string v0, "RemoteControlClient"

    const-string/jumbo v2, "using invalid value for PLAYBACKINFO_VOLUME"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_20

    .line 680
    :pswitch_56
    if-lez p2, :cond_62

    .line 681
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeMax:I

    if-eq v0, p2, :cond_20

    .line 682
    iput p2, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeMax:I

    .line 683
    invoke-direct {p0, p1, p2}, Landroid/media/RemoteControlClient;->sendAudioServiceNewPlaybackInfo_syncCacheLock(II)V

    goto :goto_20

    .line 686
    :cond_62
    const-string v0, "RemoteControlClient"

    const-string/jumbo v2, "using invalid value for PLAYBACKINFO_VOLUME_MAX"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_20

    .line 690
    :pswitch_6b
    if-ltz p2, :cond_76

    invoke-static {}, Landroid/media/AudioSystem;->getNumStreamTypes()I

    move-result v0

    if-ge p2, v0, :cond_76

    .line 691
    iput p2, p0, Landroid/media/RemoteControlClient;->mPlaybackStream:I

    goto :goto_20

    .line 693
    :cond_76
    const-string v0, "RemoteControlClient"

    const-string/jumbo v2, "using invalid value for PLAYBACKINFO_USES_STREAM"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_20

    .line 697
    :pswitch_7f
    if-ltz p2, :cond_8d

    if-gt p2, v0, :cond_8d

    .line 698
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeHandling:I

    if-eq v0, p2, :cond_20

    .line 699
    iput p2, p0, Landroid/media/RemoteControlClient;->mPlaybackVolumeHandling:I

    .line 700
    invoke-direct {p0, p1, p2}, Landroid/media/RemoteControlClient;->sendAudioServiceNewPlaybackInfo_syncCacheLock(II)V

    goto :goto_20

    .line 703
    :cond_8d
    const-string v0, "RemoteControlClient"

    const-string/jumbo v2, "using invalid value for PLAYBACKINFO_VOLUME_HANDLING"

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_95
    .catchall {:try_start_33 .. :try_end_95} :catchall_30

    goto :goto_20

    .line 658
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
    .line 595
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    .line 596
    :try_start_3
    iget v0, p0, Landroid/media/RemoteControlClient;->mPlaybackState:I

    if-eq v0, p1, :cond_17

    .line 598
    iput p1, p0, Landroid/media/RemoteControlClient;->mPlaybackState:I

    .line 600
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    iput-wide v2, p0, Landroid/media/RemoteControlClient;->mPlaybackStateChangeTimeMs:J

    .line 603
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendPlaybackState_syncCacheLock()V

    .line 605
    const/16 v0, 0xff

    invoke-direct {p0, v0, p1}, Landroid/media/RemoteControlClient;->sendAudioServiceNewPlaybackInfo_syncCacheLock(II)V

    .line 607
    :cond_17
    monitor-exit v1

    .line 608
    return-void

    .line 607
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
    .line 899
    iput p1, p0, Landroid/media/RemoteControlClient;->mRcseId:I

    .line 900
    return-void
.end method

.method public setTransportControlFlags(I)V
    .registers 4
    .parameter "transportControlFlags"

    .prologue
    .line 623
    iget-object v1, p0, Landroid/media/RemoteControlClient;->mCacheLock:Ljava/lang/Object;

    monitor-enter v1

    .line 625
    :try_start_3
    iput p1, p0, Landroid/media/RemoteControlClient;->mTransportControlFlags:I

    .line 628
    invoke-direct {p0}, Landroid/media/RemoteControlClient;->sendTransportControlFlags_syncCacheLock()V

    .line 629
    monitor-exit v1

    .line 630
    return-void

    .line 629
    :catchall_a
    move-exception v0

    monitor-exit v1
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_a

    throw v0
.end method
