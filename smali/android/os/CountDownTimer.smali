.class public abstract Landroid/os/CountDownTimer;
.super Ljava/lang/Object;
.source "CountDownTimer.java"


# static fields
.field private static final MSG:I = 0x1


# instance fields
.field private final mCountdownInterval:J

.field private mHandler:Landroid/os/Handler;

.field private final mMillisInFuture:J

.field private mStopTimeInFuture:J


# direct methods
.method public constructor <init>(JJ)V
    .registers 6
    .parameter "millisInFuture"
    .parameter "countDownInterval"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Landroid/os/CountDownTimer$1;

    invoke-direct {v0, p0}, Landroid/os/CountDownTimer$1;-><init>(Landroid/os/CountDownTimer;)V

    iput-object v0, p0, Landroid/os/CountDownTimer;->mHandler:Landroid/os/Handler;

    iput-wide p1, p0, Landroid/os/CountDownTimer;->mMillisInFuture:J

    iput-wide p3, p0, Landroid/os/CountDownTimer;->mCountdownInterval:J

    return-void
.end method

.method static synthetic access$000(Landroid/os/CountDownTimer;)J
    .registers 3
    .parameter "x0"

    .prologue
    iget-wide v0, p0, Landroid/os/CountDownTimer;->mStopTimeInFuture:J

    return-wide v0
.end method

.method static synthetic access$100(Landroid/os/CountDownTimer;)J
    .registers 3
    .parameter "x0"

    .prologue
    iget-wide v0, p0, Landroid/os/CountDownTimer;->mCountdownInterval:J

    return-wide v0
.end method


# virtual methods
.method public final cancel()V
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/os/CountDownTimer;->mHandler:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    return-void
.end method

.method public abstract onFinish()V
.end method

.method public abstract onTick(J)V
.end method

.method public final declared-synchronized start()Landroid/os/CountDownTimer;
    .registers 6

    .prologue
    monitor-enter p0

    :try_start_1
    iget-wide v1, p0, Landroid/os/CountDownTimer;->mMillisInFuture:J

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-gtz v1, :cond_f

    invoke-virtual {p0}, Landroid/os/CountDownTimer;->onFinish()V
    :try_end_c
    .catchall {:try_start_1 .. :try_end_c} :catchall_26

    move-object v0, p0

    .end local p0
    .local v0, this:Landroid/os/CountDownTimer;
    :goto_d
    monitor-exit p0

    return-object v0

    .end local v0           #this:Landroid/os/CountDownTimer;
    .restart local p0
    :cond_f
    :try_start_f
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v1

    iget-wide v3, p0, Landroid/os/CountDownTimer;->mMillisInFuture:J

    add-long/2addr v1, v3

    iput-wide v1, p0, Landroid/os/CountDownTimer;->mStopTimeInFuture:J

    iget-object v1, p0, Landroid/os/CountDownTimer;->mHandler:Landroid/os/Handler;

    iget-object v2, p0, Landroid/os/CountDownTimer;->mHandler:Landroid/os/Handler;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_24
    .catchall {:try_start_f .. :try_end_24} :catchall_26

    move-object v0, p0

    .end local p0
    .restart local v0       #this:Landroid/os/CountDownTimer;
    goto :goto_d

    .end local v0           #this:Landroid/os/CountDownTimer;
    .restart local p0
    :catchall_26
    move-exception v1

    monitor-exit p0

    throw v1
.end method
