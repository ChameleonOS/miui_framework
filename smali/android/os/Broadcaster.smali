.class public Landroid/os/Broadcaster;
.super Ljava/lang/Object;
.source "Broadcaster.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/os/Broadcaster$1;,
        Landroid/os/Broadcaster$Registration;
    }
.end annotation


# instance fields
.field private mReg:Landroid/os/Broadcaster$Registration;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public broadcast(Landroid/os/Message;)V
    .registers 12
    .parameter "msg"

    .prologue
    monitor-enter p0

    :try_start_1
    iget-object v9, p0, Landroid/os/Broadcaster;->mReg:Landroid/os/Broadcaster$Registration;

    if-nez v9, :cond_7

    monitor-exit p0

    :goto_6
    return-void

    :cond_7
    iget v4, p1, Landroid/os/Message;->what:I

    .local v4, senderWhat:I
    iget-object v5, p0, Landroid/os/Broadcaster;->mReg:Landroid/os/Broadcaster$Registration;

    .local v5, start:Landroid/os/Broadcaster$Registration;
    move-object v3, v5

    .local v3, r:Landroid/os/Broadcaster$Registration;
    :cond_c
    iget v9, v3, Landroid/os/Broadcaster$Registration;->senderWhat:I

    if-lt v9, v4, :cond_2f

    :goto_10
    iget v9, v3, Landroid/os/Broadcaster$Registration;->senderWhat:I

    if-ne v9, v4, :cond_34

    iget-object v7, v3, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    .local v7, targets:[Landroid/os/Handler;
    iget-object v8, v3, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    .local v8, whats:[I
    array-length v2, v7

    .local v2, n:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1a
    if-ge v0, v2, :cond_34

    aget-object v6, v7, v0

    .local v6, target:Landroid/os/Handler;
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v1

    .local v1, m:Landroid/os/Message;
    invoke-virtual {v1, p1}, Landroid/os/Message;->copyFrom(Landroid/os/Message;)V

    aget v9, v8, v0

    iput v9, v1, Landroid/os/Message;->what:I

    invoke-virtual {v6, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_1a

    .end local v0           #i:I
    .end local v1           #m:Landroid/os/Message;
    .end local v2           #n:I
    .end local v6           #target:Landroid/os/Handler;
    .end local v7           #targets:[Landroid/os/Handler;
    .end local v8           #whats:[I
    :cond_2f
    iget-object v3, v3, Landroid/os/Broadcaster$Registration;->next:Landroid/os/Broadcaster$Registration;

    if-ne v3, v5, :cond_c

    goto :goto_10

    :cond_34
    monitor-exit p0

    goto :goto_6

    .end local v3           #r:Landroid/os/Broadcaster$Registration;
    .end local v4           #senderWhat:I
    .end local v5           #start:Landroid/os/Broadcaster$Registration;
    :catchall_36
    move-exception v9

    monitor-exit p0
    :try_end_38
    .catchall {:try_start_1 .. :try_end_38} :catchall_36

    throw v9
.end method

.method public cancelRequest(ILandroid/os/Handler;I)V
    .registers 14
    .parameter "senderWhat"
    .parameter "target"
    .parameter "targetWhat"

    .prologue
    monitor-enter p0

    :try_start_1
    iget-object v4, p0, Landroid/os/Broadcaster;->mReg:Landroid/os/Broadcaster$Registration;

    .local v4, start:Landroid/os/Broadcaster$Registration;
    move-object v2, v4

    .local v2, r:Landroid/os/Broadcaster$Registration;
    if-nez v2, :cond_8

    monitor-exit p0

    :goto_7
    return-void

    :cond_8
    iget v7, v2, Landroid/os/Broadcaster$Registration;->senderWhat:I

    if-lt v7, p1, :cond_55

    :goto_c
    iget v7, v2, Landroid/os/Broadcaster$Registration;->senderWhat:I

    if-ne v7, p1, :cond_50

    iget-object v5, v2, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    .local v5, targets:[Landroid/os/Handler;
    iget-object v6, v2, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    .local v6, whats:[I
    array-length v1, v5

    .local v1, oldLen:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_16
    if-ge v0, v1, :cond_50

    aget-object v7, v5, v0

    if-ne v7, p2, :cond_5a

    aget v7, v6, v0

    if-ne v7, p3, :cond_5a

    add-int/lit8 v7, v1, -0x1

    new-array v7, v7, [Landroid/os/Handler;

    iput-object v7, v2, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    add-int/lit8 v7, v1, -0x1

    new-array v7, v7, [I

    iput-object v7, v2, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    if-lez v0, :cond_3c

    const/4 v7, 0x0

    iget-object v8, v2, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    const/4 v9, 0x0

    invoke-static {v5, v7, v8, v9, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    const/4 v7, 0x0

    iget-object v8, v2, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    const/4 v9, 0x0

    invoke-static {v6, v7, v8, v9, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_3c
    sub-int v7, v1, v0

    add-int/lit8 v3, v7, -0x1

    .local v3, remainingLen:I
    if-eqz v3, :cond_50

    add-int/lit8 v7, v0, 0x1

    iget-object v8, v2, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    invoke-static {v5, v7, v8, v0, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/lit8 v7, v0, 0x1

    iget-object v8, v2, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    invoke-static {v6, v7, v8, v0, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .end local v0           #i:I
    .end local v1           #oldLen:I
    .end local v3           #remainingLen:I
    .end local v5           #targets:[Landroid/os/Handler;
    .end local v6           #whats:[I
    :cond_50
    monitor-exit p0

    goto :goto_7

    .end local v2           #r:Landroid/os/Broadcaster$Registration;
    .end local v4           #start:Landroid/os/Broadcaster$Registration;
    :catchall_52
    move-exception v7

    monitor-exit p0
    :try_end_54
    .catchall {:try_start_1 .. :try_end_54} :catchall_52

    throw v7

    .restart local v2       #r:Landroid/os/Broadcaster$Registration;
    .restart local v4       #start:Landroid/os/Broadcaster$Registration;
    :cond_55
    :try_start_55
    iget-object v2, v2, Landroid/os/Broadcaster$Registration;->next:Landroid/os/Broadcaster$Registration;
    :try_end_57
    .catchall {:try_start_55 .. :try_end_57} :catchall_52

    if-ne v2, v4, :cond_8

    goto :goto_c

    .restart local v0       #i:I
    .restart local v1       #oldLen:I
    .restart local v5       #targets:[Landroid/os/Handler;
    .restart local v6       #whats:[I
    :cond_5a
    add-int/lit8 v0, v0, 0x1

    goto :goto_16
.end method

.method public dumpRegistrations()V
    .registers 8

    .prologue
    monitor-enter p0

    :try_start_1
    iget-object v3, p0, Landroid/os/Broadcaster;->mReg:Landroid/os/Broadcaster$Registration;

    .local v3, start:Landroid/os/Broadcaster$Registration;
    sget-object v4, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Broadcaster "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " {"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    if-eqz v3, :cond_75

    move-object v2, v3

    .local v2, r:Landroid/os/Broadcaster$Registration;
    :cond_24
    sget-object v4, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "    senderWhat="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget v6, v2, Landroid/os/Broadcaster$Registration;->senderWhat:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    iget-object v4, v2, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    array-length v1, v4

    .local v1, n:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_42
    if-ge v0, v1, :cond_71

    sget-object v4, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "        ["

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, v2, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    aget v6, v6, v0

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "] "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, v2, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    aget-object v6, v6, v0

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_42

    :cond_71
    iget-object v2, v2, Landroid/os/Broadcaster$Registration;->next:Landroid/os/Broadcaster$Registration;

    if-ne v2, v3, :cond_24

    .end local v0           #i:I
    .end local v1           #n:I
    .end local v2           #r:Landroid/os/Broadcaster$Registration;
    :cond_75
    sget-object v4, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string/jumbo v5, "}"

    invoke-virtual {v4, v5}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    monitor-exit p0

    return-void

    .end local v3           #start:Landroid/os/Broadcaster$Registration;
    :catchall_7f
    move-exception v4

    monitor-exit p0
    :try_end_81
    .catchall {:try_start_1 .. :try_end_81} :catchall_7f

    throw v4
.end method

.method public request(ILandroid/os/Handler;I)V
    .registers 15
    .parameter "senderWhat"
    .parameter "target"
    .parameter "targetWhat"

    .prologue
    monitor-enter p0

    const/4 v4, 0x0

    .local v4, r:Landroid/os/Broadcaster$Registration;
    :try_start_2
    iget-object v8, p0, Landroid/os/Broadcaster;->mReg:Landroid/os/Broadcaster$Registration;

    if-nez v8, :cond_2b

    new-instance v5, Landroid/os/Broadcaster$Registration;

    const/4 v8, 0x0

    invoke-direct {v5, p0, v8}, Landroid/os/Broadcaster$Registration;-><init>(Landroid/os/Broadcaster;Landroid/os/Broadcaster$1;)V
    :try_end_c
    .catchall {:try_start_2 .. :try_end_c} :catchall_6b

    .end local v4           #r:Landroid/os/Broadcaster$Registration;
    .local v5, r:Landroid/os/Broadcaster$Registration;
    :try_start_c
    iput p1, v5, Landroid/os/Broadcaster$Registration;->senderWhat:I

    const/4 v8, 0x1

    new-array v8, v8, [Landroid/os/Handler;

    iput-object v8, v5, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    const/4 v8, 0x1

    new-array v8, v8, [I

    iput-object v8, v5, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    iget-object v8, v5, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    const/4 v9, 0x0

    aput-object p2, v8, v9

    iget-object v8, v5, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    const/4 v9, 0x0

    aput p3, v8, v9

    iput-object v5, p0, Landroid/os/Broadcaster;->mReg:Landroid/os/Broadcaster$Registration;

    iput-object v5, v5, Landroid/os/Broadcaster$Registration;->next:Landroid/os/Broadcaster$Registration;

    iput-object v5, v5, Landroid/os/Broadcaster$Registration;->prev:Landroid/os/Broadcaster$Registration;
    :try_end_28
    .catchall {:try_start_c .. :try_end_28} :catchall_a5

    move-object v4, v5

    .end local v5           #r:Landroid/os/Broadcaster$Registration;
    .restart local v4       #r:Landroid/os/Broadcaster$Registration;
    :goto_29
    :try_start_29
    monitor-exit p0

    :goto_2a
    return-void

    :cond_2b
    iget-object v7, p0, Landroid/os/Broadcaster;->mReg:Landroid/os/Broadcaster$Registration;

    .local v7, start:Landroid/os/Broadcaster$Registration;
    move-object v4, v7

    :cond_2e
    iget v8, v4, Landroid/os/Broadcaster$Registration;->senderWhat:I

    if-lt v8, p1, :cond_6e

    :goto_32
    iget v8, v4, Landroid/os/Broadcaster$Registration;->senderWhat:I

    if-eq v8, p1, :cond_73

    new-instance v6, Landroid/os/Broadcaster$Registration;

    const/4 v8, 0x0

    invoke-direct {v6, p0, v8}, Landroid/os/Broadcaster$Registration;-><init>(Landroid/os/Broadcaster;Landroid/os/Broadcaster$1;)V

    .local v6, reg:Landroid/os/Broadcaster$Registration;
    iput p1, v6, Landroid/os/Broadcaster$Registration;->senderWhat:I

    const/4 v8, 0x1

    new-array v8, v8, [Landroid/os/Handler;

    iput-object v8, v6, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    const/4 v8, 0x1

    new-array v8, v8, [I

    iput-object v8, v6, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    iput-object v4, v6, Landroid/os/Broadcaster$Registration;->next:Landroid/os/Broadcaster$Registration;

    iget-object v8, v4, Landroid/os/Broadcaster$Registration;->prev:Landroid/os/Broadcaster$Registration;

    iput-object v8, v6, Landroid/os/Broadcaster$Registration;->prev:Landroid/os/Broadcaster$Registration;

    iget-object v8, v4, Landroid/os/Broadcaster$Registration;->prev:Landroid/os/Broadcaster$Registration;

    iput-object v6, v8, Landroid/os/Broadcaster$Registration;->next:Landroid/os/Broadcaster$Registration;

    iput-object v6, v4, Landroid/os/Broadcaster$Registration;->prev:Landroid/os/Broadcaster$Registration;

    iget-object v8, p0, Landroid/os/Broadcaster;->mReg:Landroid/os/Broadcaster$Registration;

    if-ne v4, v8, :cond_60

    iget v8, v4, Landroid/os/Broadcaster$Registration;->senderWhat:I

    iget v9, v6, Landroid/os/Broadcaster$Registration;->senderWhat:I

    if-le v8, v9, :cond_60

    iput-object v6, p0, Landroid/os/Broadcaster;->mReg:Landroid/os/Broadcaster$Registration;

    :cond_60
    move-object v4, v6

    const/4 v1, 0x0

    .end local v6           #reg:Landroid/os/Broadcaster$Registration;
    .local v1, n:I
    :goto_62
    iget-object v8, v4, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    aput-object p2, v8, v1

    iget-object v8, v4, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    aput p3, v8, v1

    goto :goto_29

    .end local v1           #n:I
    .end local v7           #start:Landroid/os/Broadcaster$Registration;
    :catchall_6b
    move-exception v8

    :goto_6c
    monitor-exit p0
    :try_end_6d
    .catchall {:try_start_29 .. :try_end_6d} :catchall_6b

    throw v8

    .restart local v7       #start:Landroid/os/Broadcaster$Registration;
    :cond_6e
    :try_start_6e
    iget-object v4, v4, Landroid/os/Broadcaster$Registration;->next:Landroid/os/Broadcaster$Registration;

    if-ne v4, v7, :cond_2e

    goto :goto_32

    :cond_73
    iget-object v8, v4, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    array-length v1, v8

    .restart local v1       #n:I
    iget-object v2, v4, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    .local v2, oldTargets:[Landroid/os/Handler;
    iget-object v3, v4, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    .local v3, oldWhats:[I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_7b
    if-ge v0, v1, :cond_8a

    aget-object v8, v2, v0

    if-ne v8, p2, :cond_87

    aget v8, v3, v0

    if-ne v8, p3, :cond_87

    monitor-exit p0

    goto :goto_2a

    :cond_87
    add-int/lit8 v0, v0, 0x1

    goto :goto_7b

    :cond_8a
    add-int/lit8 v8, v1, 0x1

    new-array v8, v8, [Landroid/os/Handler;

    iput-object v8, v4, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    const/4 v8, 0x0

    iget-object v9, v4, Landroid/os/Broadcaster$Registration;->targets:[Landroid/os/Handler;

    const/4 v10, 0x0

    invoke-static {v2, v8, v9, v10, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/lit8 v8, v1, 0x1

    new-array v8, v8, [I

    iput-object v8, v4, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    const/4 v8, 0x0

    iget-object v9, v4, Landroid/os/Broadcaster$Registration;->targetWhats:[I

    const/4 v10, 0x0

    invoke-static {v3, v8, v9, v10, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
    :try_end_a4
    .catchall {:try_start_6e .. :try_end_a4} :catchall_6b

    goto :goto_62

    .end local v0           #i:I
    .end local v1           #n:I
    .end local v2           #oldTargets:[Landroid/os/Handler;
    .end local v3           #oldWhats:[I
    .end local v4           #r:Landroid/os/Broadcaster$Registration;
    .end local v7           #start:Landroid/os/Broadcaster$Registration;
    .restart local v5       #r:Landroid/os/Broadcaster$Registration;
    :catchall_a5
    move-exception v8

    move-object v4, v5

    .end local v5           #r:Landroid/os/Broadcaster$Registration;
    .restart local v4       #r:Landroid/os/Broadcaster$Registration;
    goto :goto_6c
.end method
