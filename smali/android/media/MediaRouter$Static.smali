.class Landroid/media/MediaRouter$Static;
.super Ljava/lang/Object;
.source "MediaRouter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/MediaRouter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Static"
.end annotation


# instance fields
.field final mAudioService:Landroid/media/IAudioService;

.field mBluetoothA2dpRoute:Landroid/media/MediaRouter$RouteInfo;

.field final mCallbacks:Ljava/util/concurrent/CopyOnWriteArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArrayList",
            "<",
            "Landroid/media/MediaRouter$CallbackInfo;",
            ">;"
        }
    .end annotation
.end field

.field final mCategories:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/media/MediaRouter$RouteCategory;",
            ">;"
        }
    .end annotation
.end field

.field final mCurRoutesInfo:Landroid/media/AudioRoutesInfo;

.field mDefaultAudio:Landroid/media/MediaRouter$RouteInfo;

.field final mHandler:Landroid/os/Handler;

.field final mResources:Landroid/content/res/Resources;

.field final mRoutes:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/media/MediaRouter$RouteInfo;",
            ">;"
        }
    .end annotation
.end field

.field final mRoutesObserver:Landroid/media/IAudioRoutesObserver$Stub;

.field mSelectedRoute:Landroid/media/MediaRouter$RouteInfo;

.field final mSystemCategory:Landroid/media/MediaRouter$RouteCategory;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .registers 7
    .parameter "appContext"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v1, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v1}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v1, p0, Landroid/media/MediaRouter$Static;->mCallbacks:Ljava/util/concurrent/CopyOnWriteArrayList;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroid/media/MediaRouter$Static;->mRoutes:Ljava/util/ArrayList;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroid/media/MediaRouter$Static;->mCategories:Ljava/util/ArrayList;

    new-instance v1, Landroid/media/AudioRoutesInfo;

    invoke-direct {v1}, Landroid/media/AudioRoutesInfo;-><init>()V

    iput-object v1, p0, Landroid/media/MediaRouter$Static;->mCurRoutesInfo:Landroid/media/AudioRoutesInfo;

    new-instance v1, Landroid/media/MediaRouter$Static$1;

    invoke-direct {v1, p0}, Landroid/media/MediaRouter$Static$1;-><init>(Landroid/media/MediaRouter$Static;)V

    iput-object v1, p0, Landroid/media/MediaRouter$Static;->mRoutesObserver:Landroid/media/IAudioRoutesObserver$Stub;

    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v1

    iput-object v1, p0, Landroid/media/MediaRouter$Static;->mResources:Landroid/content/res/Resources;

    new-instance v1, Landroid/os/Handler;

    invoke-virtual {p1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v1, p0, Landroid/media/MediaRouter$Static;->mHandler:Landroid/os/Handler;

    const-string v1, "audio"

    invoke-static {v1}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    .local v0, b:Landroid/os/IBinder;
    invoke-static {v0}, Landroid/media/IAudioService$Stub;->asInterface(Landroid/os/IBinder;)Landroid/media/IAudioService;

    move-result-object v1

    iput-object v1, p0, Landroid/media/MediaRouter$Static;->mAudioService:Landroid/media/IAudioService;

    new-instance v1, Landroid/media/MediaRouter$RouteCategory;

    const v2, 0x1040501

    const/4 v3, 0x1

    const/4 v4, 0x0

    invoke-direct {v1, v2, v3, v4}, Landroid/media/MediaRouter$RouteCategory;-><init>(IIZ)V

    iput-object v1, p0, Landroid/media/MediaRouter$Static;->mSystemCategory:Landroid/media/MediaRouter$RouteCategory;

    return-void
.end method


# virtual methods
.method startMonitoringRoutes(Landroid/content/Context;)V
    .registers 6
    .parameter "appContext"

    .prologue
    new-instance v1, Landroid/media/MediaRouter$RouteInfo;

    iget-object v2, p0, Landroid/media/MediaRouter$Static;->mSystemCategory:Landroid/media/MediaRouter$RouteCategory;

    invoke-direct {v1, v2}, Landroid/media/MediaRouter$RouteInfo;-><init>(Landroid/media/MediaRouter$RouteCategory;)V

    iput-object v1, p0, Landroid/media/MediaRouter$Static;->mDefaultAudio:Landroid/media/MediaRouter$RouteInfo;

    iget-object v1, p0, Landroid/media/MediaRouter$Static;->mDefaultAudio:Landroid/media/MediaRouter$RouteInfo;

    const v2, 0x10404fd

    iput v2, v1, Landroid/media/MediaRouter$RouteInfo;->mNameResId:I

    iget-object v1, p0, Landroid/media/MediaRouter$Static;->mDefaultAudio:Landroid/media/MediaRouter$RouteInfo;

    const/4 v2, 0x1

    iput v2, v1, Landroid/media/MediaRouter$RouteInfo;->mSupportedTypes:I

    iget-object v1, p0, Landroid/media/MediaRouter$Static;->mDefaultAudio:Landroid/media/MediaRouter$RouteInfo;

    invoke-static {v1}, Landroid/media/MediaRouter;->addRoute(Landroid/media/MediaRouter$RouteInfo;)V

    new-instance v1, Landroid/media/MediaRouter$VolumeChangeReceiver;

    invoke-direct {v1}, Landroid/media/MediaRouter$VolumeChangeReceiver;-><init>()V

    new-instance v2, Landroid/content/IntentFilter;

    const-string v3, "android.media.VOLUME_CHANGED_ACTION"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v1, v2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    const/4 v0, 0x0

    .local v0, newRoutes:Landroid/media/AudioRoutesInfo;
    :try_start_2a
    iget-object v1, p0, Landroid/media/MediaRouter$Static;->mAudioService:Landroid/media/IAudioService;

    iget-object v2, p0, Landroid/media/MediaRouter$Static;->mRoutesObserver:Landroid/media/IAudioRoutesObserver$Stub;

    invoke-interface {v1, v2}, Landroid/media/IAudioService;->startWatchingRoutes(Landroid/media/IAudioRoutesObserver;)Landroid/media/AudioRoutesInfo;
    :try_end_31
    .catch Landroid/os/RemoteException; {:try_start_2a .. :try_end_31} :catch_38

    move-result-object v0

    :goto_32
    if-eqz v0, :cond_37

    invoke-virtual {p0, v0}, Landroid/media/MediaRouter$Static;->updateRoutes(Landroid/media/AudioRoutesInfo;)V

    :cond_37
    return-void

    :catch_38
    move-exception v1

    goto :goto_32
.end method

.method updateRoutes(Landroid/media/AudioRoutesInfo;)V
    .registers 9
    .parameter "newRoutes"

    .prologue
    const/4 v6, 0x1

    iget v4, p1, Landroid/media/AudioRoutesInfo;->mMainType:I

    iget-object v5, p0, Landroid/media/MediaRouter$Static;->mCurRoutesInfo:Landroid/media/AudioRoutesInfo;

    iget v5, v5, Landroid/media/AudioRoutesInfo;->mMainType:I

    if-eq v4, v5, :cond_2b

    iget-object v4, p0, Landroid/media/MediaRouter$Static;->mCurRoutesInfo:Landroid/media/AudioRoutesInfo;

    iget v5, p1, Landroid/media/AudioRoutesInfo;->mMainType:I

    iput v5, v4, Landroid/media/AudioRoutesInfo;->mMainType:I

    iget v4, p1, Landroid/media/AudioRoutesInfo;->mMainType:I

    and-int/lit8 v4, v4, 0x2

    if-nez v4, :cond_1b

    iget v4, p1, Landroid/media/AudioRoutesInfo;->mMainType:I

    and-int/lit8 v4, v4, 0x1

    if-eqz v4, :cond_81

    :cond_1b
    const v3, 0x10404fe

    .local v3, name:I
    :goto_1e
    sget-object v4, Landroid/media/MediaRouter;->sStatic:Landroid/media/MediaRouter$Static;

    iget-object v4, v4, Landroid/media/MediaRouter$Static;->mDefaultAudio:Landroid/media/MediaRouter$RouteInfo;

    iput v3, v4, Landroid/media/MediaRouter$RouteInfo;->mNameResId:I

    sget-object v4, Landroid/media/MediaRouter;->sStatic:Landroid/media/MediaRouter$Static;

    iget-object v4, v4, Landroid/media/MediaRouter$Static;->mDefaultAudio:Landroid/media/MediaRouter$RouteInfo;

    invoke-static {v4}, Landroid/media/MediaRouter;->dispatchRouteChanged(Landroid/media/MediaRouter$RouteInfo;)V

    .end local v3           #name:I
    :cond_2b
    :try_start_2b
    iget-object v4, p0, Landroid/media/MediaRouter$Static;->mAudioService:Landroid/media/IAudioService;

    invoke-interface {v4}, Landroid/media/IAudioService;->isBluetoothA2dpOn()Z
    :try_end_30
    .catch Landroid/os/RemoteException; {:try_start_2b .. :try_end_30} :catch_99

    move-result v0

    .local v0, a2dpEnabled:Z
    :goto_31
    iget-object v4, p1, Landroid/media/AudioRoutesInfo;->mBluetoothName:Ljava/lang/CharSequence;

    iget-object v5, p0, Landroid/media/MediaRouter$Static;->mCurRoutesInfo:Landroid/media/AudioRoutesInfo;

    iget-object v5, v5, Landroid/media/AudioRoutesInfo;->mBluetoothName:Ljava/lang/CharSequence;

    invoke-static {v4, v5}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_6b

    iget-object v4, p0, Landroid/media/MediaRouter$Static;->mCurRoutesInfo:Landroid/media/AudioRoutesInfo;

    iget-object v5, p1, Landroid/media/AudioRoutesInfo;->mBluetoothName:Ljava/lang/CharSequence;

    iput-object v5, v4, Landroid/media/AudioRoutesInfo;->mBluetoothName:Ljava/lang/CharSequence;

    iget-object v4, p0, Landroid/media/MediaRouter$Static;->mCurRoutesInfo:Landroid/media/AudioRoutesInfo;

    iget-object v4, v4, Landroid/media/AudioRoutesInfo;->mBluetoothName:Ljava/lang/CharSequence;

    if-eqz v4, :cond_b5

    sget-object v4, Landroid/media/MediaRouter;->sStatic:Landroid/media/MediaRouter$Static;

    iget-object v4, v4, Landroid/media/MediaRouter$Static;->mBluetoothA2dpRoute:Landroid/media/MediaRouter$RouteInfo;

    if-nez v4, :cond_a3

    new-instance v2, Landroid/media/MediaRouter$RouteInfo;

    sget-object v4, Landroid/media/MediaRouter;->sStatic:Landroid/media/MediaRouter$Static;

    iget-object v4, v4, Landroid/media/MediaRouter$Static;->mSystemCategory:Landroid/media/MediaRouter$RouteCategory;

    invoke-direct {v2, v4}, Landroid/media/MediaRouter$RouteInfo;-><init>(Landroid/media/MediaRouter$RouteCategory;)V

    .local v2, info:Landroid/media/MediaRouter$RouteInfo;
    iget-object v4, p0, Landroid/media/MediaRouter$Static;->mCurRoutesInfo:Landroid/media/AudioRoutesInfo;

    iget-object v4, v4, Landroid/media/AudioRoutesInfo;->mBluetoothName:Ljava/lang/CharSequence;

    iput-object v4, v2, Landroid/media/MediaRouter$RouteInfo;->mName:Ljava/lang/CharSequence;

    iput v6, v2, Landroid/media/MediaRouter$RouteInfo;->mSupportedTypes:I

    sget-object v4, Landroid/media/MediaRouter;->sStatic:Landroid/media/MediaRouter$Static;

    iput-object v2, v4, Landroid/media/MediaRouter$Static;->mBluetoothA2dpRoute:Landroid/media/MediaRouter$RouteInfo;

    sget-object v4, Landroid/media/MediaRouter;->sStatic:Landroid/media/MediaRouter$Static;

    iget-object v4, v4, Landroid/media/MediaRouter$Static;->mBluetoothA2dpRoute:Landroid/media/MediaRouter$RouteInfo;

    invoke-static {v4}, Landroid/media/MediaRouter;->addRoute(Landroid/media/MediaRouter$RouteInfo;)V

    .end local v2           #info:Landroid/media/MediaRouter$RouteInfo;
    :cond_6b
    :goto_6b
    iget-object v4, p0, Landroid/media/MediaRouter$Static;->mBluetoothA2dpRoute:Landroid/media/MediaRouter$RouteInfo;

    if-eqz v4, :cond_80

    iget-object v4, p0, Landroid/media/MediaRouter$Static;->mCurRoutesInfo:Landroid/media/AudioRoutesInfo;

    iget v4, v4, Landroid/media/AudioRoutesInfo;->mMainType:I

    if-eqz v4, :cond_c8

    iget-object v4, p0, Landroid/media/MediaRouter$Static;->mSelectedRoute:Landroid/media/MediaRouter$RouteInfo;

    iget-object v5, p0, Landroid/media/MediaRouter$Static;->mBluetoothA2dpRoute:Landroid/media/MediaRouter$RouteInfo;

    if-ne v4, v5, :cond_c8

    iget-object v4, p0, Landroid/media/MediaRouter$Static;->mDefaultAudio:Landroid/media/MediaRouter$RouteInfo;

    invoke-static {v6, v4}, Landroid/media/MediaRouter;->selectRouteStatic(ILandroid/media/MediaRouter$RouteInfo;)V

    :cond_80
    :goto_80
    return-void

    .end local v0           #a2dpEnabled:Z
    :cond_81
    iget v4, p1, Landroid/media/AudioRoutesInfo;->mMainType:I

    and-int/lit8 v4, v4, 0x4

    if-eqz v4, :cond_8b

    const v3, 0x10404ff

    .restart local v3       #name:I
    goto :goto_1e

    .end local v3           #name:I
    :cond_8b
    iget v4, p1, Landroid/media/AudioRoutesInfo;->mMainType:I

    and-int/lit8 v4, v4, 0x8

    if-eqz v4, :cond_95

    const v3, 0x1040500

    .restart local v3       #name:I
    goto :goto_1e

    .end local v3           #name:I
    :cond_95
    const v3, 0x10404fd

    .restart local v3       #name:I
    goto :goto_1e

    .end local v3           #name:I
    :catch_99
    move-exception v1

    .local v1, e:Landroid/os/RemoteException;
    const-string v4, "MediaRouter"

    const-string v5, "Error querying Bluetooth A2DP state"

    invoke-static {v4, v5, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    const/4 v0, 0x0

    .restart local v0       #a2dpEnabled:Z
    goto :goto_31

    .end local v1           #e:Landroid/os/RemoteException;
    :cond_a3
    sget-object v4, Landroid/media/MediaRouter;->sStatic:Landroid/media/MediaRouter$Static;

    iget-object v4, v4, Landroid/media/MediaRouter$Static;->mBluetoothA2dpRoute:Landroid/media/MediaRouter$RouteInfo;

    iget-object v5, p0, Landroid/media/MediaRouter$Static;->mCurRoutesInfo:Landroid/media/AudioRoutesInfo;

    iget-object v5, v5, Landroid/media/AudioRoutesInfo;->mBluetoothName:Ljava/lang/CharSequence;

    iput-object v5, v4, Landroid/media/MediaRouter$RouteInfo;->mName:Ljava/lang/CharSequence;

    sget-object v4, Landroid/media/MediaRouter;->sStatic:Landroid/media/MediaRouter$Static;

    iget-object v4, v4, Landroid/media/MediaRouter$Static;->mBluetoothA2dpRoute:Landroid/media/MediaRouter$RouteInfo;

    invoke-static {v4}, Landroid/media/MediaRouter;->dispatchRouteChanged(Landroid/media/MediaRouter$RouteInfo;)V

    goto :goto_6b

    :cond_b5
    sget-object v4, Landroid/media/MediaRouter;->sStatic:Landroid/media/MediaRouter$Static;

    iget-object v4, v4, Landroid/media/MediaRouter$Static;->mBluetoothA2dpRoute:Landroid/media/MediaRouter$RouteInfo;

    if-eqz v4, :cond_6b

    sget-object v4, Landroid/media/MediaRouter;->sStatic:Landroid/media/MediaRouter$Static;

    iget-object v4, v4, Landroid/media/MediaRouter$Static;->mBluetoothA2dpRoute:Landroid/media/MediaRouter$RouteInfo;

    invoke-static {v4}, Landroid/media/MediaRouter;->removeRoute(Landroid/media/MediaRouter$RouteInfo;)V

    sget-object v4, Landroid/media/MediaRouter;->sStatic:Landroid/media/MediaRouter$Static;

    const/4 v5, 0x0

    iput-object v5, v4, Landroid/media/MediaRouter$Static;->mBluetoothA2dpRoute:Landroid/media/MediaRouter$RouteInfo;

    goto :goto_6b

    :cond_c8
    iget-object v4, p0, Landroid/media/MediaRouter$Static;->mCurRoutesInfo:Landroid/media/AudioRoutesInfo;

    iget v4, v4, Landroid/media/AudioRoutesInfo;->mMainType:I

    if-nez v4, :cond_80

    iget-object v4, p0, Landroid/media/MediaRouter$Static;->mSelectedRoute:Landroid/media/MediaRouter$RouteInfo;

    iget-object v5, p0, Landroid/media/MediaRouter$Static;->mDefaultAudio:Landroid/media/MediaRouter$RouteInfo;

    if-ne v4, v5, :cond_80

    if-eqz v0, :cond_80

    iget-object v4, p0, Landroid/media/MediaRouter$Static;->mBluetoothA2dpRoute:Landroid/media/MediaRouter$RouteInfo;

    invoke-static {v6, v4}, Landroid/media/MediaRouter;->selectRouteStatic(ILandroid/media/MediaRouter$RouteInfo;)V

    goto :goto_80
.end method
