.class public final Landroid/util/LocalLog;
.super Ljava/lang/Object;
.source "LocalLog.java"


# instance fields
.field private mLog:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mMaxLines:I

.field private mNow:Landroid/text/format/Time;


# direct methods
.method public constructor <init>(I)V
    .registers 3
    .parameter "maxLines"

    .prologue
    .line 36
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 37
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Landroid/util/LocalLog;->mLog:Ljava/util/LinkedList;

    .line 38
    iput p1, p0, Landroid/util/LocalLog;->mMaxLines:I

    .line 39
    new-instance v0, Landroid/text/format/Time;

    invoke-direct {v0}, Landroid/text/format/Time;-><init>()V

    iput-object v0, p0, Landroid/util/LocalLog;->mNow:Landroid/text/format/Time;

    .line 40
    return-void
.end method


# virtual methods
.method public declared-synchronized dump(Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .registers 7
    .parameter "fd"
    .parameter "pw"
    .parameter "args"

    .prologue
    .line 51
    monitor-enter p0

    :try_start_1
    iget-object v1, p0, Landroid/util/LocalLog;->mLog:Ljava/util/LinkedList;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/util/LinkedList;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v0

    .line 52
    .local v0, itr:Ljava/util/Iterator;,"Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_8
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1b

    .line 53
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {p2, v1}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V
    :try_end_17
    .catchall {:try_start_1 .. :try_end_17} :catchall_18

    goto :goto_8

    .line 51
    .end local v0           #itr:Ljava/util/Iterator;,"Ljava/util/Iterator<Ljava/lang/String;>;"
    :catchall_18
    move-exception v1

    monitor-exit p0

    throw v1

    .line 55
    .restart local v0       #itr:Ljava/util/Iterator;,"Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_1b
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized log(Ljava/lang/String;)V
    .registers 6
    .parameter "msg"

    .prologue
    .line 43
    monitor-enter p0

    :try_start_1
    iget v0, p0, Landroid/util/LocalLog;->mMaxLines:I

    if-lez v0, :cond_41

    .line 44
    iget-object v0, p0, Landroid/util/LocalLog;->mNow:Landroid/text/format/Time;

    invoke-virtual {v0}, Landroid/text/format/Time;->setToNow()V

    .line 45
    iget-object v0, p0, Landroid/util/LocalLog;->mLog:Ljava/util/LinkedList;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Landroid/util/LocalLog;->mNow:Landroid/text/format/Time;

    const-string v3, "%H:%M:%S"

    invoke-virtual {v2, v3}, Landroid/text/format/Time;->format(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " - "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 46
    :goto_2e
    iget-object v0, p0, Landroid/util/LocalLog;->mLog:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->size()I

    move-result v0

    iget v1, p0, Landroid/util/LocalLog;->mMaxLines:I

    if-le v0, v1, :cond_41

    iget-object v0, p0, Landroid/util/LocalLog;->mLog:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->remove()Ljava/lang/Object;
    :try_end_3d
    .catchall {:try_start_1 .. :try_end_3d} :catchall_3e

    goto :goto_2e

    .line 43
    :catchall_3e
    move-exception v0

    monitor-exit p0

    throw v0

    .line 48
    :cond_41
    monitor-exit p0

    return-void
.end method
