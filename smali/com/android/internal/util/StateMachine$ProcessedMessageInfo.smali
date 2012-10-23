.class public Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;
.super Ljava/lang/Object;
.source "StateMachine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/util/StateMachine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ProcessedMessageInfo"
.end annotation


# instance fields
.field private mInfo:Ljava/lang/String;

.field private mOrgState:Lcom/android/internal/util/State;

.field private mState:Lcom/android/internal/util/State;

.field private mTime:J

.field private mWhat:I


# direct methods
.method constructor <init>(Landroid/os/Message;Ljava/lang/String;Lcom/android/internal/util/State;Lcom/android/internal/util/State;)V
    .registers 5
    .parameter "msg"
    .parameter "info"
    .parameter "state"
    .parameter "orgState"

    .prologue
    .line 464
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 465
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->update(Landroid/os/Message;Ljava/lang/String;Lcom/android/internal/util/State;Lcom/android/internal/util/State;)V

    .line 466
    return-void
.end method


# virtual methods
.method public getInfo()Ljava/lang/String;
    .registers 2

    .prologue
    .line 500
    iget-object v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mInfo:Ljava/lang/String;

    return-object v0
.end method

.method public getOriginalState()Lcom/android/internal/util/State;
    .registers 2

    .prologue
    .line 514
    iget-object v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mOrgState:Lcom/android/internal/util/State;

    return-object v0
.end method

.method public getState()Lcom/android/internal/util/State;
    .registers 2

    .prologue
    .line 507
    iget-object v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mState:Lcom/android/internal/util/State;

    return-object v0
.end method

.method public getTime()J
    .registers 3

    .prologue
    .line 486
    iget-wide v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mTime:J

    return-wide v0
.end method

.method public getWhat()J
    .registers 3

    .prologue
    .line 493
    iget v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mWhat:I

    int-to-long v0, v0

    return-wide v0
.end method

.method public toString()Ljava/lang/String;
    .registers 6

    .prologue
    .line 522
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 523
    .local v1, sb:Ljava/lang/StringBuilder;
    const-string/jumbo v2, "time="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 524
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 525
    .local v0, c:Ljava/util/Calendar;
    iget-wide v2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mTime:J

    invoke-virtual {v0, v2, v3}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 526
    const-string v2, "%tm-%td %tH:%tM:%tS.%tL"

    const/4 v3, 0x6

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    const/4 v4, 0x1

    aput-object v0, v3, v4

    const/4 v4, 0x2

    aput-object v0, v3, v4

    const/4 v4, 0x3

    aput-object v0, v3, v4

    const/4 v4, 0x4

    aput-object v0, v3, v4

    const/4 v4, 0x5

    aput-object v0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 527
    const-string v2, " state="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 528
    iget-object v2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mState:Lcom/android/internal/util/State;

    if-nez v2, :cond_82

    const-string v2, "<null>"

    :goto_3d
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 529
    const-string v2, " orgState="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 530
    iget-object v2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mOrgState:Lcom/android/internal/util/State;

    if-nez v2, :cond_89

    const-string v2, "<null>"

    :goto_4b
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 531
    const-string v2, " what="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 532
    iget v2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mWhat:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 533
    const-string v2, "(0x"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 534
    iget v2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mWhat:I

    invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 535
    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 536
    iget-object v2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mInfo:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_7d

    .line 537
    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 538
    iget-object v2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mInfo:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 540
    :cond_7d
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 528
    :cond_82
    iget-object v2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mState:Lcom/android/internal/util/State;

    invoke-virtual {v2}, Lcom/android/internal/util/State;->getName()Ljava/lang/String;

    move-result-object v2

    goto :goto_3d

    .line 530
    :cond_89
    iget-object v2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mOrgState:Lcom/android/internal/util/State;

    invoke-virtual {v2}, Lcom/android/internal/util/State;->getName()Ljava/lang/String;

    move-result-object v2

    goto :goto_4b
.end method

.method public update(Landroid/os/Message;Ljava/lang/String;Lcom/android/internal/util/State;Lcom/android/internal/util/State;)V
    .registers 7
    .parameter "msg"
    .parameter "info"
    .parameter "state"
    .parameter "orgState"

    .prologue
    .line 475
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mTime:J

    .line 476
    iget v0, p1, Landroid/os/Message;->what:I

    iput v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mWhat:I

    .line 477
    iput-object p2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mInfo:Ljava/lang/String;

    .line 478
    iput-object p3, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mState:Lcom/android/internal/util/State;

    .line 479
    iput-object p4, p0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->mOrgState:Lcom/android/internal/util/State;

    .line 480
    return-void
.end method
