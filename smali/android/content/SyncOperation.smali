.class public Landroid/content/SyncOperation;
.super Ljava/lang/Object;
.source "SyncOperation.java"

# interfaces
.implements Ljava/lang/Comparable;


# instance fields
.field public final account:Landroid/accounts/Account;

.field public final allowParallelSyncs:Z

.field public authority:Ljava/lang/String;

.field public backoff:Ljava/lang/Long;

.field public delayUntil:J

.field public earliestRunTime:J

.field public effectiveRunTime:J

.field public expedited:Z

.field public extras:Landroid/os/Bundle;

.field public final key:Ljava/lang/String;

.field public pendingOperation:Landroid/content/SyncStorageEngine$PendingOperation;

.field public syncSource:I

.field public final userId:I


# direct methods
.method public constructor <init>(Landroid/accounts/Account;IILjava/lang/String;Landroid/os/Bundle;JJJZ)V
    .registers 18
    .parameter "account"
    .parameter "userId"
    .parameter "source"
    .parameter "authority"
    .parameter "extras"
    .parameter "delayInMs"
    .parameter "backoff"
    .parameter "delayUntil"
    .parameter "allowParallelSyncs"

    .prologue
    .line 43
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p1, p0, Landroid/content/SyncOperation;->account:Landroid/accounts/Account;

    .line 45
    iput p2, p0, Landroid/content/SyncOperation;->userId:I

    .line 46
    iput p3, p0, Landroid/content/SyncOperation;->syncSource:I

    .line 47
    iput-object p4, p0, Landroid/content/SyncOperation;->authority:Ljava/lang/String;

    .line 48
    move/from16 v0, p12

    iput-boolean v0, p0, Landroid/content/SyncOperation;->allowParallelSyncs:Z

    .line 49
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3, p5}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    iput-object v3, p0, Landroid/content/SyncOperation;->extras:Landroid/os/Bundle;

    .line 50
    const-string/jumbo v3, "upload"

    invoke-direct {p0, v3}, Landroid/content/SyncOperation;->removeFalseExtra(Ljava/lang/String;)V

    .line 51
    const-string v3, "force"

    invoke-direct {p0, v3}, Landroid/content/SyncOperation;->removeFalseExtra(Ljava/lang/String;)V

    .line 52
    const-string v3, "ignore_settings"

    invoke-direct {p0, v3}, Landroid/content/SyncOperation;->removeFalseExtra(Ljava/lang/String;)V

    .line 53
    const-string v3, "ignore_backoff"

    invoke-direct {p0, v3}, Landroid/content/SyncOperation;->removeFalseExtra(Ljava/lang/String;)V

    .line 54
    const-string v3, "do_not_retry"

    invoke-direct {p0, v3}, Landroid/content/SyncOperation;->removeFalseExtra(Ljava/lang/String;)V

    .line 55
    const-string v3, "discard_deletions"

    invoke-direct {p0, v3}, Landroid/content/SyncOperation;->removeFalseExtra(Ljava/lang/String;)V

    .line 56
    const-string v3, "expedited"

    invoke-direct {p0, v3}, Landroid/content/SyncOperation;->removeFalseExtra(Ljava/lang/String;)V

    .line 57
    const-string v3, "deletions_override"

    invoke-direct {p0, v3}, Landroid/content/SyncOperation;->removeFalseExtra(Ljava/lang/String;)V

    .line 58
    iput-wide p10, p0, Landroid/content/SyncOperation;->delayUntil:J

    .line 59
    invoke-static {p8, p9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iput-object v3, p0, Landroid/content/SyncOperation;->backoff:Ljava/lang/Long;

    .line 60
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v1

    .line 61
    .local v1, now:J
    const-wide/16 v3, 0x0

    cmp-long v3, p6, v3

    if-gez v3, :cond_60

    .line 62
    const/4 v3, 0x1

    iput-boolean v3, p0, Landroid/content/SyncOperation;->expedited:Z

    .line 63
    iput-wide v1, p0, Landroid/content/SyncOperation;->earliestRunTime:J

    .line 68
    :goto_56
    invoke-virtual {p0}, Landroid/content/SyncOperation;->updateEffectiveRunTime()V

    .line 69
    invoke-direct {p0}, Landroid/content/SyncOperation;->toKey()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Landroid/content/SyncOperation;->key:Ljava/lang/String;

    .line 70
    return-void

    .line 65
    :cond_60
    const/4 v3, 0x0

    iput-boolean v3, p0, Landroid/content/SyncOperation;->expedited:Z

    .line 66
    add-long v3, v1, p6

    iput-wide v3, p0, Landroid/content/SyncOperation;->earliestRunTime:J

    goto :goto_56
.end method

.method constructor <init>(Landroid/content/SyncOperation;)V
    .registers 4
    .parameter "other"

    .prologue
    .line 78
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 79
    iget-object v0, p1, Landroid/content/SyncOperation;->account:Landroid/accounts/Account;

    iput-object v0, p0, Landroid/content/SyncOperation;->account:Landroid/accounts/Account;

    .line 80
    iget v0, p1, Landroid/content/SyncOperation;->userId:I

    iput v0, p0, Landroid/content/SyncOperation;->userId:I

    .line 81
    iget v0, p1, Landroid/content/SyncOperation;->syncSource:I

    iput v0, p0, Landroid/content/SyncOperation;->syncSource:I

    .line 82
    iget-object v0, p1, Landroid/content/SyncOperation;->authority:Ljava/lang/String;

    iput-object v0, p0, Landroid/content/SyncOperation;->authority:Ljava/lang/String;

    .line 83
    new-instance v0, Landroid/os/Bundle;

    iget-object v1, p1, Landroid/content/SyncOperation;->extras:Landroid/os/Bundle;

    invoke-direct {v0, v1}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    iput-object v0, p0, Landroid/content/SyncOperation;->extras:Landroid/os/Bundle;

    .line 84
    iget-boolean v0, p1, Landroid/content/SyncOperation;->expedited:Z

    iput-boolean v0, p0, Landroid/content/SyncOperation;->expedited:Z

    .line 85
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/content/SyncOperation;->earliestRunTime:J

    .line 86
    iget-object v0, p1, Landroid/content/SyncOperation;->backoff:Ljava/lang/Long;

    iput-object v0, p0, Landroid/content/SyncOperation;->backoff:Ljava/lang/Long;

    .line 87
    iget-wide v0, p1, Landroid/content/SyncOperation;->delayUntil:J

    iput-wide v0, p0, Landroid/content/SyncOperation;->delayUntil:J

    .line 88
    iget-boolean v0, p1, Landroid/content/SyncOperation;->allowParallelSyncs:Z

    iput-boolean v0, p0, Landroid/content/SyncOperation;->allowParallelSyncs:Z

    .line 89
    invoke-virtual {p0}, Landroid/content/SyncOperation;->updateEffectiveRunTime()V

    .line 90
    invoke-direct {p0}, Landroid/content/SyncOperation;->toKey()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/content/SyncOperation;->key:Ljava/lang/String;

    .line 91
    return-void
.end method

.method public static extrasToStringBuilder(Landroid/os/Bundle;Ljava/lang/StringBuilder;)V
    .registers 6
    .parameter "bundle"
    .parameter "sb"

    .prologue
    .line 138
    const-string v2, "["

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 139
    invoke-virtual {p0}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_d
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_31

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 140
    .local v1, key:Ljava/lang/String;
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0, v1}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_d

    .line 142
    .end local v1           #key:Ljava/lang/String;
    :cond_31
    const-string v2, "]"

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 143
    return-void
.end method

.method private removeFalseExtra(Ljava/lang/String;)V
    .registers 4
    .parameter "extraName"

    .prologue
    .line 73
    iget-object v0, p0, Landroid/content/SyncOperation;->extras:Landroid/os/Bundle;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_e

    .line 74
    iget-object v0, p0, Landroid/content/SyncOperation;->extras:Landroid/os/Bundle;

    invoke-virtual {v0, p1}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    .line 76
    :cond_e
    return-void
.end method

.method private toKey()Ljava/lang/String;
    .registers 4

    .prologue
    .line 128
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 129
    .local v0, sb:Ljava/lang/StringBuilder;
    const-string v1, "authority: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/content/SyncOperation;->authority:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 130
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, " account {name="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/content/SyncOperation;->account:Landroid/accounts/Account;

    iget-object v2, v2, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", user="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/content/SyncOperation;->userId:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", type="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/content/SyncOperation;->account:Landroid/accounts/Account;

    iget-object v2, v2, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "}"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 132
    const-string v1, " extras: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 133
    iget-object v1, p0, Landroid/content/SyncOperation;->extras:Landroid/os/Bundle;

    invoke-static {v1, v0}, Landroid/content/SyncOperation;->extrasToStringBuilder(Landroid/os/Bundle;Ljava/lang/StringBuilder;)V

    .line 134
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public compareTo(Ljava/lang/Object;)I
    .registers 9
    .parameter "o"

    .prologue
    const/4 v2, 0x1

    const/4 v1, -0x1

    .line 154
    move-object v0, p1

    check-cast v0, Landroid/content/SyncOperation;

    .line 156
    .local v0, other:Landroid/content/SyncOperation;
    iget-boolean v3, p0, Landroid/content/SyncOperation;->expedited:Z

    iget-boolean v4, v0, Landroid/content/SyncOperation;->expedited:Z

    if-eq v3, v4, :cond_12

    .line 157
    iget-boolean v3, p0, Landroid/content/SyncOperation;->expedited:Z

    if-eqz v3, :cond_10

    .line 164
    :cond_f
    :goto_f
    return v1

    :cond_10
    move v1, v2

    .line 157
    goto :goto_f

    .line 160
    :cond_12
    iget-wide v3, p0, Landroid/content/SyncOperation;->effectiveRunTime:J

    iget-wide v5, v0, Landroid/content/SyncOperation;->effectiveRunTime:J

    cmp-long v3, v3, v5

    if-nez v3, :cond_1c

    .line 161
    const/4 v1, 0x0

    goto :goto_f

    .line 164
    :cond_1c
    iget-wide v3, p0, Landroid/content/SyncOperation;->effectiveRunTime:J

    iget-wide v5, v0, Landroid/content/SyncOperation;->effectiveRunTime:J

    cmp-long v3, v3, v5

    if-ltz v3, :cond_f

    move v1, v2

    goto :goto_f
.end method

.method public dump(Z)Ljava/lang/String;
    .registers 6
    .parameter "useOneLine"

    .prologue
    .line 98
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 99
    .local v0, sb:Ljava/lang/StringBuilder;
    iget-object v1, p0, Landroid/content/SyncOperation;->account:Landroid/accounts/Account;

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 100
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, " ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/content/SyncOperation;->account:Landroid/accounts/Account;

    iget-object v2, v2, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 101
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/content/SyncOperation;->authority:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 102
    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 103
    sget-object v1, Landroid/content/SyncStorageEngine;->SOURCES:[Ljava/lang/String;

    iget v2, p0, Landroid/content/SyncOperation;->syncSource:I

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 104
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ", earliestRunTime "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Landroid/content/SyncOperation;->earliestRunTime:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 105
    iget-boolean v1, p0, Landroid/content/SyncOperation;->expedited:Z

    if-eqz v1, :cond_73

    .line 106
    const-string v1, ", EXPEDITED"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 108
    :cond_73
    if-nez p1, :cond_8b

    iget-object v1, p0, Landroid/content/SyncOperation;->extras:Landroid/os/Bundle;

    invoke-virtual {v1}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_8b

    .line 109
    const-string v1, "\n    "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 110
    iget-object v1, p0, Landroid/content/SyncOperation;->extras:Landroid/os/Bundle;

    invoke-static {v1, v0}, Landroid/content/SyncOperation;->extrasToStringBuilder(Landroid/os/Bundle;Ljava/lang/StringBuilder;)V

    .line 112
    :cond_8b
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public ignoreBackoff()Z
    .registers 4

    .prologue
    .line 124
    iget-object v0, p0, Landroid/content/SyncOperation;->extras:Landroid/os/Bundle;

    const-string v1, "ignore_backoff"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isExpedited()Z
    .registers 4

    .prologue
    .line 120
    iget-object v0, p0, Landroid/content/SyncOperation;->extras:Landroid/os/Bundle;

    const-string v1, "expedited"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isInitialization()Z
    .registers 4

    .prologue
    .line 116
    iget-object v0, p0, Landroid/content/SyncOperation;->extras:Landroid/os/Bundle;

    const-string v1, "initialize"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    .prologue
    .line 94
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/content/SyncOperation;->dump(Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public updateEffectiveRunTime()V
    .registers 5

    .prologue
    .line 146
    invoke-virtual {p0}, Landroid/content/SyncOperation;->ignoreBackoff()Z

    move-result v0

    if-eqz v0, :cond_b

    iget-wide v0, p0, Landroid/content/SyncOperation;->earliestRunTime:J

    :goto_8
    iput-wide v0, p0, Landroid/content/SyncOperation;->effectiveRunTime:J

    .line 151
    return-void

    .line 146
    :cond_b
    iget-wide v0, p0, Landroid/content/SyncOperation;->earliestRunTime:J

    iget-wide v2, p0, Landroid/content/SyncOperation;->delayUntil:J

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    iget-object v2, p0, Landroid/content/SyncOperation;->backoff:Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    goto :goto_8
.end method
