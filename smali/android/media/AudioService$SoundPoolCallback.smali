.class final Landroid/media/AudioService$SoundPoolCallback;
.super Ljava/lang/Object;
.source "AudioService.java"

# interfaces
.implements Landroid/media/SoundPool$OnLoadCompleteListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/AudioService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "SoundPoolCallback"
.end annotation


# instance fields
.field mLastSample:I

.field mStatus:I

.field final synthetic this$0:Landroid/media/AudioService;


# direct methods
.method private constructor <init>(Landroid/media/AudioService;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/media/AudioService$SoundPoolCallback;->this$0:Landroid/media/AudioService;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/media/AudioService;Landroid/media/AudioService$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/media/AudioService$SoundPoolCallback;-><init>(Landroid/media/AudioService;)V

    return-void
.end method


# virtual methods
.method public onLoadComplete(Landroid/media/SoundPool;II)V
    .registers 6
    .parameter "soundPool"
    .parameter "sampleId"
    .parameter "status"

    .prologue
    iget-object v0, p0, Landroid/media/AudioService$SoundPoolCallback;->this$0:Landroid/media/AudioService;

    #getter for: Landroid/media/AudioService;->mSoundEffectsLock:Ljava/lang/Object;
    invoke-static {v0}, Landroid/media/AudioService;->access$1500(Landroid/media/AudioService;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    if-eqz p3, :cond_b

    :try_start_9
    iput p3, p0, Landroid/media/AudioService$SoundPoolCallback;->mStatus:I

    :cond_b
    iget v0, p0, Landroid/media/AudioService$SoundPoolCallback;->mLastSample:I

    if-ne p2, v0, :cond_18

    iget-object v0, p0, Landroid/media/AudioService$SoundPoolCallback;->this$0:Landroid/media/AudioService;

    #getter for: Landroid/media/AudioService;->mSoundEffectsLock:Ljava/lang/Object;
    invoke-static {v0}, Landroid/media/AudioService;->access$1500(Landroid/media/AudioService;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->notify()V

    :cond_18
    monitor-exit v1

    return-void

    :catchall_1a
    move-exception v0

    monitor-exit v1
    :try_end_1c
    .catchall {:try_start_9 .. :try_end_1c} :catchall_1a

    throw v0
.end method

.method public setLastSample(I)V
    .registers 2
    .parameter "sample"

    .prologue
    iput p1, p0, Landroid/media/AudioService$SoundPoolCallback;->mLastSample:I

    return-void
.end method

.method public status()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/media/AudioService$SoundPoolCallback;->mStatus:I

    return v0
.end method
