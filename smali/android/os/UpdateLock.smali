.class public Landroid/os/UpdateLock;
.super Ljava/lang/Object;
.source "UpdateLock.java"


# static fields
.field private static final DEBUG:Z = false

.field public static final NOW_IS_CONVENIENT:Ljava/lang/String; = "nowisconvenient"

.field private static final TAG:Ljava/lang/String; = "UpdateLock"

.field public static final TIMESTAMP:Ljava/lang/String; = "timestamp"

.field public static final UPDATE_LOCK_CHANGED:Ljava/lang/String; = "android.os.UpdateLock.UPDATE_LOCK_CHANGED"

.field private static sService:Landroid/os/IUpdateLock;


# instance fields
.field mCount:I

.field mHeld:Z

.field mRefCounted:Z

.field final mTag:Ljava/lang/String;

.field mToken:Landroid/os/IBinder;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .registers 4
    .parameter "tag"

    .prologue
    const/4 v1, 0x0

    .line 75
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput v1, p0, Landroid/os/UpdateLock;->mCount:I

    .line 43
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/os/UpdateLock;->mRefCounted:Z

    .line 44
    iput-boolean v1, p0, Landroid/os/UpdateLock;->mHeld:Z

    .line 76
    iput-object p1, p0, Landroid/os/UpdateLock;->mTag:Ljava/lang/String;

    .line 77
    new-instance v0, Landroid/os/Binder;

    invoke-direct {v0}, Landroid/os/Binder;-><init>()V

    iput-object v0, p0, Landroid/os/UpdateLock;->mToken:Landroid/os/IBinder;

    .line 78
    return-void
.end method

.method private acquireLocked()V
    .registers 5

    .prologue
    .line 113
    iget-boolean v1, p0, Landroid/os/UpdateLock;->mRefCounted:Z

    if-eqz v1, :cond_c

    iget v1, p0, Landroid/os/UpdateLock;->mCount:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Landroid/os/UpdateLock;->mCount:I

    if-nez v1, :cond_1c

    .line 114
    :cond_c
    sget-object v1, Landroid/os/UpdateLock;->sService:Landroid/os/IUpdateLock;

    if-eqz v1, :cond_19

    .line 116
    :try_start_10
    sget-object v1, Landroid/os/UpdateLock;->sService:Landroid/os/IUpdateLock;

    iget-object v2, p0, Landroid/os/UpdateLock;->mToken:Landroid/os/IBinder;

    iget-object v3, p0, Landroid/os/UpdateLock;->mTag:Ljava/lang/String;

    invoke-interface {v1, v2, v3}, Landroid/os/IUpdateLock;->acquireUpdateLock(Landroid/os/IBinder;Ljava/lang/String;)V
    :try_end_19
    .catch Landroid/os/RemoteException; {:try_start_10 .. :try_end_19} :catch_1d

    .line 121
    :cond_19
    :goto_19
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/os/UpdateLock;->mHeld:Z

    .line 123
    :cond_1c
    return-void

    .line 117
    :catch_1d
    move-exception v0

    .line 118
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "UpdateLock"

    const-string v2, "Unable to contact service to acquire"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_19
.end method

.method private static checkService()V
    .registers 1

    .prologue
    .line 35
    sget-object v0, Landroid/os/UpdateLock;->sService:Landroid/os/IUpdateLock;

    if-nez v0, :cond_11

    .line 36
    const-string/jumbo v0, "updatelock"

    invoke-static {v0}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/os/IUpdateLock$Stub;->asInterface(Landroid/os/IBinder;)Landroid/os/IUpdateLock;

    move-result-object v0

    sput-object v0, Landroid/os/UpdateLock;->sService:Landroid/os/IUpdateLock;

    .line 39
    :cond_11
    return-void
.end method

.method private releaseLocked()V
    .registers 4

    .prologue
    .line 137
    iget-boolean v1, p0, Landroid/os/UpdateLock;->mRefCounted:Z

    if-eqz v1, :cond_c

    iget v1, p0, Landroid/os/UpdateLock;->mCount:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Landroid/os/UpdateLock;->mCount:I

    if-nez v1, :cond_1a

    .line 138
    :cond_c
    sget-object v1, Landroid/os/UpdateLock;->sService:Landroid/os/IUpdateLock;

    if-eqz v1, :cond_17

    .line 140
    :try_start_10
    sget-object v1, Landroid/os/UpdateLock;->sService:Landroid/os/IUpdateLock;

    iget-object v2, p0, Landroid/os/UpdateLock;->mToken:Landroid/os/IBinder;

    invoke-interface {v1, v2}, Landroid/os/IUpdateLock;->releaseUpdateLock(Landroid/os/IBinder;)V
    :try_end_17
    .catch Landroid/os/RemoteException; {:try_start_10 .. :try_end_17} :catch_26

    .line 145
    :cond_17
    :goto_17
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/os/UpdateLock;->mHeld:Z

    .line 147
    :cond_1a
    iget v1, p0, Landroid/os/UpdateLock;->mCount:I

    if-gez v1, :cond_2f

    .line 148
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "UpdateLock under-locked"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 141
    :catch_26
    move-exception v0

    .line 142
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "UpdateLock"

    const-string v2, "Unable to contact service to release"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_17

    .line 150
    .end local v0           #e:Landroid/os/RemoteException;
    :cond_2f
    return-void
.end method


# virtual methods
.method public acquire()V
    .registers 3

    .prologue
    .line 106
    invoke-static {}, Landroid/os/UpdateLock;->checkService()V

    .line 107
    iget-object v1, p0, Landroid/os/UpdateLock;->mToken:Landroid/os/IBinder;

    monitor-enter v1

    .line 108
    :try_start_6
    invoke-direct {p0}, Landroid/os/UpdateLock;->acquireLocked()V

    .line 109
    monitor-exit v1

    .line 110
    return-void

    .line 109
    :catchall_b
    move-exception v0

    monitor-exit v1
    :try_end_d
    .catchall {:try_start_6 .. :try_end_d} :catchall_b

    throw v0
.end method

.method protected finalize()V
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 154
    iget-object v2, p0, Landroid/os/UpdateLock;->mToken:Landroid/os/IBinder;

    monitor-enter v2

    .line 156
    :try_start_3
    iget-boolean v1, p0, Landroid/os/UpdateLock;->mHeld:Z

    if-eqz v1, :cond_15

    .line 157
    const-string v1, "UpdateLock"

    const-string v3, "UpdateLock finalized while still held"

    invoke-static {v1, v3}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_e
    .catchall {:try_start_3 .. :try_end_e} :catchall_20

    .line 159
    :try_start_e
    sget-object v1, Landroid/os/UpdateLock;->sService:Landroid/os/IUpdateLock;

    iget-object v3, p0, Landroid/os/UpdateLock;->mToken:Landroid/os/IBinder;

    invoke-interface {v1, v3}, Landroid/os/IUpdateLock;->releaseUpdateLock(Landroid/os/IBinder;)V
    :try_end_15
    .catchall {:try_start_e .. :try_end_15} :catchall_20
    .catch Landroid/os/RemoteException; {:try_start_e .. :try_end_15} :catch_17

    .line 164
    :cond_15
    :goto_15
    :try_start_15
    monitor-exit v2

    .line 165
    return-void

    .line 160
    :catch_17
    move-exception v0

    .line 161
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "UpdateLock"

    const-string v3, "Unable to contact service to release"

    invoke-static {v1, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_15

    .line 164
    .end local v0           #e:Landroid/os/RemoteException;
    :catchall_20
    move-exception v1

    monitor-exit v2
    :try_end_22
    .catchall {:try_start_15 .. :try_end_22} :catchall_20

    throw v1
.end method

.method public isHeld()Z
    .registers 3

    .prologue
    .line 94
    iget-object v1, p0, Landroid/os/UpdateLock;->mToken:Landroid/os/IBinder;

    monitor-enter v1

    .line 95
    :try_start_3
    iget-boolean v0, p0, Landroid/os/UpdateLock;->mHeld:Z

    monitor-exit v1

    return v0

    .line 96
    :catchall_7
    move-exception v0

    monitor-exit v1
    :try_end_9
    .catchall {:try_start_3 .. :try_end_9} :catchall_7

    throw v0
.end method

.method public release()V
    .registers 3

    .prologue
    .line 130
    invoke-static {}, Landroid/os/UpdateLock;->checkService()V

    .line 131
    iget-object v1, p0, Landroid/os/UpdateLock;->mToken:Landroid/os/IBinder;

    monitor-enter v1

    .line 132
    :try_start_6
    invoke-direct {p0}, Landroid/os/UpdateLock;->releaseLocked()V

    .line 133
    monitor-exit v1

    .line 134
    return-void

    .line 133
    :catchall_b
    move-exception v0

    monitor-exit v1
    :try_end_d
    .catchall {:try_start_6 .. :try_end_d} :catchall_b

    throw v0
.end method

.method public setReferenceCounted(Z)V
    .registers 2
    .parameter "isRefCounted"

    .prologue
    .line 87
    iput-boolean p1, p0, Landroid/os/UpdateLock;->mRefCounted:Z

    .line 88
    return-void
.end method
