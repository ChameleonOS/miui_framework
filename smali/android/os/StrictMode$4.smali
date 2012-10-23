.class final Landroid/os/StrictMode$4;
.super Ljava/lang/Thread;
.source "StrictMode.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/os/StrictMode;->dropboxViolationAsync(ILandroid/os/StrictMode$ViolationInfo;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$info:Landroid/os/StrictMode$ViolationInfo;

.field final synthetic val$violationMaskSubset:I


# direct methods
.method constructor <init>(Ljava/lang/String;ILandroid/os/StrictMode$ViolationInfo;)V
    .registers 4
    .parameter "x0"
    .parameter
    .parameter

    .prologue
    .line 1367
    iput p2, p0, Landroid/os/StrictMode$4;->val$violationMaskSubset:I

    iput-object p3, p0, Landroid/os/StrictMode$4;->val$info:Landroid/os/StrictMode$ViolationInfo;

    invoke-direct {p0, p1}, Ljava/lang/Thread;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 7

    .prologue
    .line 1369
    const/16 v3, 0xa

    invoke-static {v3}, Landroid/os/Process;->setThreadPriority(I)V

    .line 1371
    :try_start_5
    invoke-static {}, Landroid/app/ActivityManagerNative;->getDefault()Landroid/app/IActivityManager;

    move-result-object v0

    .line 1372
    .local v0, am:Landroid/app/IActivityManager;
    if-nez v0, :cond_39

    .line 1373
    const-string v3, "StrictMode"

    const-string v4, "No activity manager; failed to Dropbox violation."

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_12
    .catch Landroid/os/RemoteException; {:try_start_5 .. :try_end_12} :catch_45

    .line 1383
    .end local v0           #am:Landroid/app/IActivityManager;
    :goto_12
    invoke-static {}, Landroid/os/StrictMode;->access$1400()Ljava/util/concurrent/atomic/AtomicInteger;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    move-result v2

    .line 1384
    .local v2, outstanding:I
    invoke-static {}, Landroid/os/StrictMode;->access$800()Z

    move-result v3

    if-eqz v3, :cond_38

    const-string v3, "StrictMode"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Dropbox complete; in-flight="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1385
    :cond_38
    return-void

    .line 1375
    .end local v2           #outstanding:I
    .restart local v0       #am:Landroid/app/IActivityManager;
    :cond_39
    :try_start_39
    invoke-static {}, Lcom/android/internal/os/RuntimeInit;->getApplicationObject()Landroid/os/IBinder;

    move-result-object v3

    iget v4, p0, Landroid/os/StrictMode$4;->val$violationMaskSubset:I

    iget-object v5, p0, Landroid/os/StrictMode$4;->val$info:Landroid/os/StrictMode$ViolationInfo;

    invoke-interface {v0, v3, v4, v5}, Landroid/app/IActivityManager;->handleApplicationStrictModeViolation(Landroid/os/IBinder;ILandroid/os/StrictMode$ViolationInfo;)V
    :try_end_44
    .catch Landroid/os/RemoteException; {:try_start_39 .. :try_end_44} :catch_45

    goto :goto_12

    .line 1380
    .end local v0           #am:Landroid/app/IActivityManager;
    :catch_45
    move-exception v1

    .line 1381
    .local v1, e:Landroid/os/RemoteException;
    const-string v3, "StrictMode"

    const-string v4, "RemoteException handling StrictMode violation"

    invoke-static {v3, v4, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_12
.end method
