.class public abstract Landroid/widget/Filter;
.super Ljava/lang/Object;
.source "Filter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/Filter$1;,
        Landroid/widget/Filter$Delayer;,
        Landroid/widget/Filter$RequestArguments;,
        Landroid/widget/Filter$ResultsHandler;,
        Landroid/widget/Filter$RequestHandler;,
        Landroid/widget/Filter$FilterListener;,
        Landroid/widget/Filter$FilterResults;
    }
.end annotation


# static fields
.field private static final FILTER_TOKEN:I = -0x2f2f0ff3

.field private static final FINISH_TOKEN:I = -0x21524111

.field private static final LOG_TAG:Ljava/lang/String; = "Filter"

.field private static final THREAD_NAME:Ljava/lang/String; = "Filter"


# instance fields
.field private mDelayer:Landroid/widget/Filter$Delayer;

.field private final mLock:Ljava/lang/Object;

.field private mResultHandler:Landroid/os/Handler;

.field private mThreadHandler:Landroid/os/Handler;


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/widget/Filter;->mLock:Ljava/lang/Object;

    new-instance v0, Landroid/widget/Filter$ResultsHandler;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroid/widget/Filter$ResultsHandler;-><init>(Landroid/widget/Filter;Landroid/widget/Filter$1;)V

    iput-object v0, p0, Landroid/widget/Filter;->mResultHandler:Landroid/os/Handler;

    return-void
.end method

.method static synthetic access$200(Landroid/widget/Filter;)Landroid/os/Handler;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/Filter;->mResultHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$300(Landroid/widget/Filter;)Ljava/lang/Object;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/Filter;->mLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$400(Landroid/widget/Filter;)Landroid/os/Handler;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$402(Landroid/widget/Filter;Landroid/os/Handler;)Landroid/os/Handler;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;

    return-object p1
.end method


# virtual methods
.method public convertResultToString(Ljava/lang/Object;)Ljava/lang/CharSequence;
    .registers 3
    .parameter "resultValue"

    .prologue
    if-nez p1, :cond_5

    const-string v0, ""

    :goto_4
    return-object v0

    :cond_5
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_4
.end method

.method public final filter(Ljava/lang/CharSequence;)V
    .registers 3
    .parameter "constraint"

    .prologue
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/widget/Filter;->filter(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterListener;)V

    return-void
.end method

.method public final filter(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterListener;)V
    .registers 12
    .parameter "constraint"
    .parameter "listener"

    .prologue
    const/4 v5, 0x0

    iget-object v6, p0, Landroid/widget/Filter;->mLock:Ljava/lang/Object;

    monitor-enter v6

    :try_start_4
    iget-object v7, p0, Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;

    if-nez v7, :cond_1f

    new-instance v4, Landroid/os/HandlerThread;

    const-string v7, "Filter"

    const/16 v8, 0xa

    invoke-direct {v4, v7, v8}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;I)V

    .local v4, thread:Landroid/os/HandlerThread;
    invoke-virtual {v4}, Landroid/os/HandlerThread;->start()V

    new-instance v7, Landroid/widget/Filter$RequestHandler;

    invoke-virtual {v4}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v8

    invoke-direct {v7, p0, v8}, Landroid/widget/Filter$RequestHandler;-><init>(Landroid/widget/Filter;Landroid/os/Looper;)V

    iput-object v7, p0, Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;

    .end local v4           #thread:Landroid/os/HandlerThread;
    :cond_1f
    iget-object v7, p0, Landroid/widget/Filter;->mDelayer:Landroid/widget/Filter$Delayer;

    if-nez v7, :cond_57

    const-wide/16 v1, 0x0

    .local v1, delay:J
    :goto_25
    iget-object v7, p0, Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;

    const v8, -0x2f2f0ff3

    invoke-virtual {v7, v8}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    .local v3, message:Landroid/os/Message;
    new-instance v0, Landroid/widget/Filter$RequestArguments;

    const/4 v7, 0x0

    invoke-direct {v0, v7}, Landroid/widget/Filter$RequestArguments;-><init>(Landroid/widget/Filter$1;)V

    .local v0, args:Landroid/widget/Filter$RequestArguments;
    if-eqz p1, :cond_3a

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    :cond_3a
    iput-object v5, v0, Landroid/widget/Filter$RequestArguments;->constraint:Ljava/lang/CharSequence;

    iput-object p2, v0, Landroid/widget/Filter$RequestArguments;->listener:Landroid/widget/Filter$FilterListener;

    iput-object v0, v3, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget-object v5, p0, Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;

    const v7, -0x2f2f0ff3

    invoke-virtual {v5, v7}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v5, p0, Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;

    const v7, -0x21524111

    invoke-virtual {v5, v7}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v5, p0, Landroid/widget/Filter;->mThreadHandler:Landroid/os/Handler;

    invoke-virtual {v5, v3, v1, v2}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    monitor-exit v6

    return-void

    .end local v0           #args:Landroid/widget/Filter$RequestArguments;
    .end local v1           #delay:J
    .end local v3           #message:Landroid/os/Message;
    :cond_57
    iget-object v7, p0, Landroid/widget/Filter;->mDelayer:Landroid/widget/Filter$Delayer;

    invoke-interface {v7, p1}, Landroid/widget/Filter$Delayer;->getPostingDelay(Ljava/lang/CharSequence;)J

    move-result-wide v1

    goto :goto_25

    :catchall_5e
    move-exception v5

    monitor-exit v6
    :try_end_60
    .catchall {:try_start_4 .. :try_end_60} :catchall_5e

    throw v5
.end method

.method protected abstract performFiltering(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;
.end method

.method protected abstract publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V
.end method

.method public setDelayer(Landroid/widget/Filter$Delayer;)V
    .registers 4
    .parameter "delayer"

    .prologue
    iget-object v1, p0, Landroid/widget/Filter;->mLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_3
    iput-object p1, p0, Landroid/widget/Filter;->mDelayer:Landroid/widget/Filter$Delayer;

    monitor-exit v1

    return-void

    :catchall_7
    move-exception v0

    monitor-exit v1
    :try_end_9
    .catchall {:try_start_3 .. :try_end_9} :catchall_7

    throw v0
.end method
