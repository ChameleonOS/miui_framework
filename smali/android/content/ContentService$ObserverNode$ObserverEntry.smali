.class Landroid/content/ContentService$ObserverNode$ObserverEntry;
.super Ljava/lang/Object;
.source "ContentService.java"

# interfaces
.implements Landroid/os/IBinder$DeathRecipient;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/ContentService$ObserverNode;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ObserverEntry"
.end annotation


# instance fields
.field public final notifyForDescendents:Z

.field public final observer:Landroid/database/IContentObserver;

.field private final observersLock:Ljava/lang/Object;

.field public final pid:I

.field final synthetic this$0:Landroid/content/ContentService$ObserverNode;

.field public final uid:I


# direct methods
.method public constructor <init>(Landroid/content/ContentService$ObserverNode;Landroid/database/IContentObserver;ZLjava/lang/Object;II)V
    .registers 10
    .parameter
    .parameter "o"
    .parameter "n"
    .parameter "observersLock"
    .parameter "_uid"
    .parameter "_pid"

    .prologue
    .line 547
    iput-object p1, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->this$0:Landroid/content/ContentService$ObserverNode;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 548
    iput-object p4, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->observersLock:Ljava/lang/Object;

    .line 549
    iput-object p2, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->observer:Landroid/database/IContentObserver;

    .line 550
    iput p5, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->uid:I

    .line 551
    iput p6, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->pid:I

    .line 552
    iput-boolean p3, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->notifyForDescendents:Z

    .line 554
    :try_start_f
    iget-object v1, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->observer:Landroid/database/IContentObserver;

    invoke-interface {v1}, Landroid/database/IContentObserver;->asBinder()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v1, p0, v2}, Landroid/os/IBinder;->linkToDeath(Landroid/os/IBinder$DeathRecipient;I)V
    :try_end_19
    .catch Landroid/os/RemoteException; {:try_start_f .. :try_end_19} :catch_1a

    .line 558
    :goto_19
    return-void

    .line 555
    :catch_1a
    move-exception v0

    .line 556
    .local v0, e:Landroid/os/RemoteException;
    invoke-virtual {p0}, Landroid/content/ContentService$ObserverNode$ObserverEntry;->binderDied()V

    goto :goto_19
.end method


# virtual methods
.method public binderDied()V
    .registers 4

    .prologue
    .line 561
    iget-object v1, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->observersLock:Ljava/lang/Object;

    monitor-enter v1

    .line 562
    :try_start_3
    iget-object v0, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->this$0:Landroid/content/ContentService$ObserverNode;

    iget-object v2, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->observer:Landroid/database/IContentObserver;

    invoke-virtual {v0, v2}, Landroid/content/ContentService$ObserverNode;->removeObserverLocked(Landroid/database/IContentObserver;)Z

    .line 563
    monitor-exit v1

    .line 564
    return-void

    .line 563
    :catchall_c
    move-exception v0

    monitor-exit v1
    :try_end_e
    .catchall {:try_start_3 .. :try_end_e} :catchall_c

    throw v0
.end method

.method public dumpLocked(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/util/SparseIntArray;)V
    .registers 9
    .parameter "fd"
    .parameter "pw"
    .parameter "args"
    .parameter "name"
    .parameter "prefix"
    .parameter "pidCounts"

    .prologue
    .line 568
    iget v0, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->pid:I

    iget v1, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->pid:I

    invoke-virtual {p6, v1}, Landroid/util/SparseIntArray;->get(I)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p6, v0, v1}, Landroid/util/SparseIntArray;->put(II)V

    .line 569
    invoke-virtual {p2, p5}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    invoke-virtual {p2, p4}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, ": pid="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 570
    iget v0, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->pid:I

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(I)V

    const-string v0, " uid="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 571
    iget v0, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->uid:I

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(I)V

    const-string v0, " target="

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 572
    iget-object v0, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->observer:Landroid/database/IContentObserver;

    if-eqz v0, :cond_42

    iget-object v0, p0, Landroid/content/ContentService$ObserverNode$ObserverEntry;->observer:Landroid/database/IContentObserver;

    invoke-interface {v0}, Landroid/database/IContentObserver;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    :goto_36
    invoke-static {v0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 574
    return-void

    .line 572
    :cond_42
    const/4 v0, 0x0

    goto :goto_36
.end method
