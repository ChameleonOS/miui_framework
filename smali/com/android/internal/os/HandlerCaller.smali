.class public Lcom/android/internal/os/HandlerCaller;
.super Ljava/lang/Object;
.source "HandlerCaller.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/os/HandlerCaller$Callback;,
        Lcom/android/internal/os/HandlerCaller$MyHandler;,
        Lcom/android/internal/os/HandlerCaller$SomeArgs;
    }
.end annotation


# static fields
.field static final ARGS_POOL_MAX_SIZE:I = 0xa

.field private static final DEBUG:Z = false

.field private static final TAG:Ljava/lang/String; = "HandlerCaller"


# instance fields
.field mArgsPool:Lcom/android/internal/os/HandlerCaller$SomeArgs;

.field mArgsPoolSize:I

.field final mCallback:Lcom/android/internal/os/HandlerCaller$Callback;

.field public final mContext:Landroid/content/Context;

.field final mH:Landroid/os/Handler;

.field final mMainLooper:Landroid/os/Looper;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/os/Looper;Lcom/android/internal/os/HandlerCaller$Callback;)V
    .registers 6
    .parameter "context"
    .parameter "looper"
    .parameter "callback"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/internal/os/HandlerCaller;->mContext:Landroid/content/Context;

    iput-object p2, p0, Lcom/android/internal/os/HandlerCaller;->mMainLooper:Landroid/os/Looper;

    new-instance v0, Lcom/android/internal/os/HandlerCaller$MyHandler;

    iget-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mMainLooper:Landroid/os/Looper;

    invoke-direct {v0, p0, v1}, Lcom/android/internal/os/HandlerCaller$MyHandler;-><init>(Lcom/android/internal/os/HandlerCaller;Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    iput-object p3, p0, Lcom/android/internal/os/HandlerCaller;->mCallback:Lcom/android/internal/os/HandlerCaller$Callback;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/android/internal/os/HandlerCaller$Callback;)V
    .registers 5
    .parameter "context"
    .parameter "callback"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/internal/os/HandlerCaller;->mContext:Landroid/content/Context;

    invoke-virtual {p1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mMainLooper:Landroid/os/Looper;

    new-instance v0, Lcom/android/internal/os/HandlerCaller$MyHandler;

    iget-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mMainLooper:Landroid/os/Looper;

    invoke-direct {v0, p0, v1}, Lcom/android/internal/os/HandlerCaller$MyHandler;-><init>(Lcom/android/internal/os/HandlerCaller;Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    iput-object p2, p0, Lcom/android/internal/os/HandlerCaller;->mCallback:Lcom/android/internal/os/HandlerCaller$Callback;

    return-void
.end method


# virtual methods
.method public executeOrSendMessage(Landroid/os/Message;)V
    .registers 4
    .parameter "msg"

    .prologue
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mMainLooper:Landroid/os/Looper;

    if-ne v0, v1, :cond_11

    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mCallback:Lcom/android/internal/os/HandlerCaller$Callback;

    invoke-interface {v0, p1}, Lcom/android/internal/os/HandlerCaller$Callback;->executeMessage(Landroid/os/Message;)V

    invoke-virtual {p1}, Landroid/os/Message;->recycle()V

    :goto_10
    return-void

    :cond_11
    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_10
.end method

.method public hasMessages(I)Z
    .registers 3
    .parameter "what"

    .prologue
    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v0

    return v0
.end method

.method public obtainArgs()Lcom/android/internal/os/HandlerCaller$SomeArgs;
    .registers 4

    .prologue
    iget-object v2, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    monitor-enter v2

    :try_start_3
    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mArgsPool:Lcom/android/internal/os/HandlerCaller$SomeArgs;

    .local v0, args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    if-eqz v0, :cond_16

    iget-object v1, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->next:Lcom/android/internal/os/HandlerCaller$SomeArgs;

    iput-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mArgsPool:Lcom/android/internal/os/HandlerCaller$SomeArgs;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->next:Lcom/android/internal/os/HandlerCaller$SomeArgs;

    iget v1, p0, Lcom/android/internal/os/HandlerCaller;->mArgsPoolSize:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/android/internal/os/HandlerCaller;->mArgsPoolSize:I

    monitor-exit v2

    .end local v0           #args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    :goto_15
    return-object v0

    .restart local v0       #args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    :cond_16
    monitor-exit v2
    :try_end_17
    .catchall {:try_start_3 .. :try_end_17} :catchall_1d

    new-instance v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;

    .end local v0           #args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    invoke-direct {v0}, Lcom/android/internal/os/HandlerCaller$SomeArgs;-><init>()V

    goto :goto_15

    :catchall_1d
    move-exception v1

    :try_start_1e
    monitor-exit v2
    :try_end_1f
    .catchall {:try_start_1e .. :try_end_1f} :catchall_1d

    throw v1
.end method

.method public obtainMessage(I)Landroid/os/Message;
    .registers 3
    .parameter "what"

    .prologue
    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method public obtainMessageBO(IZLjava/lang/Object;)Landroid/os/Message;
    .registers 7
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"

    .prologue
    const/4 v1, 0x0

    iget-object v2, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    if-eqz p2, :cond_b

    const/4 v0, 0x1

    :goto_6
    invoke-virtual {v2, p1, v0, v1, p3}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    return-object v0

    :cond_b
    move v0, v1

    goto :goto_6
.end method

.method public obtainMessageBOO(IZLjava/lang/Object;Ljava/lang/Object;)Landroid/os/Message;
    .registers 9
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"
    .parameter "arg3"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/android/internal/os/HandlerCaller;->obtainArgs()Lcom/android/internal/os/HandlerCaller$SomeArgs;

    move-result-object v0

    .local v0, args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    iput-object p3, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg1:Ljava/lang/Object;

    iput-object p4, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg2:Ljava/lang/Object;

    iget-object v3, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    if-eqz p2, :cond_13

    const/4 v1, 0x1

    :goto_e
    invoke-virtual {v3, p1, v1, v2, v0}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    return-object v1

    :cond_13
    move v1, v2

    goto :goto_e
.end method

.method public obtainMessageI(II)Landroid/os/Message;
    .registers 5
    .parameter "what"
    .parameter "arg1"

    .prologue
    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p2, v1}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method public obtainMessageII(III)Landroid/os/Message;
    .registers 5
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"

    .prologue
    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v0, p1, p2, p3}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method public obtainMessageIIII(IIIII)Landroid/os/Message;
    .registers 9
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"
    .parameter "arg3"
    .parameter "arg4"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/android/internal/os/HandlerCaller;->obtainArgs()Lcom/android/internal/os/HandlerCaller$SomeArgs;

    move-result-object v0

    .local v0, args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    iput p2, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi1:I

    iput p3, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi2:I

    iput p4, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi3:I

    iput p5, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi4:I

    iget-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v1, p1, v2, v2, v0}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    return-object v1
.end method

.method public obtainMessageIIIIII(IIIIIII)Landroid/os/Message;
    .registers 11
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"
    .parameter "arg3"
    .parameter "arg4"
    .parameter "arg5"
    .parameter "arg6"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/android/internal/os/HandlerCaller;->obtainArgs()Lcom/android/internal/os/HandlerCaller$SomeArgs;

    move-result-object v0

    .local v0, args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    iput p2, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi1:I

    iput p3, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi2:I

    iput p4, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi3:I

    iput p5, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi4:I

    iput p6, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi5:I

    iput p7, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi6:I

    iget-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v1, p1, v2, v2, v0}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    return-object v1
.end method

.method public obtainMessageIIIIO(IIIIILjava/lang/Object;)Landroid/os/Message;
    .registers 10
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"
    .parameter "arg3"
    .parameter "arg4"
    .parameter "arg5"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/android/internal/os/HandlerCaller;->obtainArgs()Lcom/android/internal/os/HandlerCaller$SomeArgs;

    move-result-object v0

    .local v0, args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    iput-object p6, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg1:Ljava/lang/Object;

    iput p2, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi1:I

    iput p3, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi2:I

    iput p4, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi3:I

    iput p5, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->argi4:I

    iget-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v1, p1, v2, v2, v0}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    return-object v1
.end method

.method public obtainMessageIIO(IIILjava/lang/Object;)Landroid/os/Message;
    .registers 6
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"
    .parameter "arg3"

    .prologue
    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method public obtainMessageIIOO(IIILjava/lang/Object;Ljava/lang/Object;)Landroid/os/Message;
    .registers 8
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"
    .parameter "arg3"
    .parameter "arg4"

    .prologue
    invoke-virtual {p0}, Lcom/android/internal/os/HandlerCaller;->obtainArgs()Lcom/android/internal/os/HandlerCaller$SomeArgs;

    move-result-object v0

    .local v0, args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    iput-object p4, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg1:Ljava/lang/Object;

    iput-object p5, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg2:Ljava/lang/Object;

    iget-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v1, p1, p2, p3, v0}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    return-object v1
.end method

.method public obtainMessageIO(IILjava/lang/Object;)Landroid/os/Message;
    .registers 6
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"

    .prologue
    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p2, v1, p3}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method public obtainMessageIOO(IILjava/lang/Object;Ljava/lang/Object;)Landroid/os/Message;
    .registers 8
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"
    .parameter "arg3"

    .prologue
    invoke-virtual {p0}, Lcom/android/internal/os/HandlerCaller;->obtainArgs()Lcom/android/internal/os/HandlerCaller$SomeArgs;

    move-result-object v0

    .local v0, args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    iput-object p3, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg1:Ljava/lang/Object;

    iput-object p4, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg2:Ljava/lang/Object;

    iget-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    const/4 v2, 0x0

    invoke-virtual {v1, p1, p2, v2, v0}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    return-object v1
.end method

.method public obtainMessageO(ILjava/lang/Object;)Landroid/os/Message;
    .registers 5
    .parameter "what"
    .parameter "arg1"

    .prologue
    const/4 v1, 0x0

    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v0, p1, v1, v1, p2}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    return-object v0
.end method

.method public obtainMessageOO(ILjava/lang/Object;Ljava/lang/Object;)Landroid/os/Message;
    .registers 7
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/android/internal/os/HandlerCaller;->obtainArgs()Lcom/android/internal/os/HandlerCaller$SomeArgs;

    move-result-object v0

    .local v0, args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    iput-object p2, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg1:Ljava/lang/Object;

    iput-object p3, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg2:Ljava/lang/Object;

    iget-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v1, p1, v2, v2, v0}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    return-object v1
.end method

.method public obtainMessageOOO(ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroid/os/Message;
    .registers 8
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"
    .parameter "arg3"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/android/internal/os/HandlerCaller;->obtainArgs()Lcom/android/internal/os/HandlerCaller$SomeArgs;

    move-result-object v0

    .local v0, args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    iput-object p2, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg1:Ljava/lang/Object;

    iput-object p3, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg2:Ljava/lang/Object;

    iput-object p4, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg3:Ljava/lang/Object;

    iget-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v1, p1, v2, v2, v0}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    return-object v1
.end method

.method public obtainMessageOOOO(ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroid/os/Message;
    .registers 9
    .parameter "what"
    .parameter "arg1"
    .parameter "arg2"
    .parameter "arg3"
    .parameter "arg4"

    .prologue
    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/android/internal/os/HandlerCaller;->obtainArgs()Lcom/android/internal/os/HandlerCaller$SomeArgs;

    move-result-object v0

    .local v0, args:Lcom/android/internal/os/HandlerCaller$SomeArgs;
    iput-object p2, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg1:Ljava/lang/Object;

    iput-object p3, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg2:Ljava/lang/Object;

    iput-object p4, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg3:Ljava/lang/Object;

    iput-object p5, v0, Lcom/android/internal/os/HandlerCaller$SomeArgs;->arg4:Ljava/lang/Object;

    iget-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v1, p1, v2, v2, v0}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    return-object v1
.end method

.method public recycleArgs(Lcom/android/internal/os/HandlerCaller$SomeArgs;)V
    .registers 5
    .parameter "args"

    .prologue
    iget-object v1, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    monitor-enter v1

    :try_start_3
    iget v0, p0, Lcom/android/internal/os/HandlerCaller;->mArgsPoolSize:I

    const/16 v2, 0xa

    if-ge v0, v2, :cond_15

    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mArgsPool:Lcom/android/internal/os/HandlerCaller$SomeArgs;

    iput-object v0, p1, Lcom/android/internal/os/HandlerCaller$SomeArgs;->next:Lcom/android/internal/os/HandlerCaller$SomeArgs;

    iput-object p1, p0, Lcom/android/internal/os/HandlerCaller;->mArgsPool:Lcom/android/internal/os/HandlerCaller$SomeArgs;

    iget v0, p0, Lcom/android/internal/os/HandlerCaller;->mArgsPoolSize:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/android/internal/os/HandlerCaller;->mArgsPoolSize:I

    :cond_15
    monitor-exit v1

    return-void

    :catchall_17
    move-exception v0

    monitor-exit v1
    :try_end_19
    .catchall {:try_start_3 .. :try_end_19} :catchall_17

    throw v0
.end method

.method public removeMessages(I)V
    .registers 3
    .parameter "what"

    .prologue
    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->removeMessages(I)V

    return-void
.end method

.method public removeMessages(ILjava/lang/Object;)V
    .registers 4
    .parameter "what"
    .parameter "obj"

    .prologue
    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v0, p1, p2}, Landroid/os/Handler;->removeMessages(ILjava/lang/Object;)V

    return-void
.end method

.method public sendMessage(Landroid/os/Message;)V
    .registers 3
    .parameter "msg"

    .prologue
    iget-object v0, p0, Lcom/android/internal/os/HandlerCaller;->mH:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    return-void
.end method
