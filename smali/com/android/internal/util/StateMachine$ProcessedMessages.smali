.class Lcom/android/internal/util/StateMachine$ProcessedMessages;
.super Ljava/lang/Object;
.source "StateMachine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/util/StateMachine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ProcessedMessages"
.end annotation


# static fields
.field private static final DEFAULT_SIZE:I = 0x14


# instance fields
.field private mCount:I

.field private mMaxSize:I

.field private mMessages:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mOldestIndex:I


# direct methods
.method private constructor <init>()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 567
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 559
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMessages:Ljava/util/Vector;

    .line 560
    const/16 v0, 0x14

    iput v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMaxSize:I

    .line 561
    iput v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mOldestIndex:I

    .line 562
    iput v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mCount:I

    .line 568
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/internal/util/StateMachine$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 555
    invoke-direct {p0}, Lcom/android/internal/util/StateMachine$ProcessedMessages;-><init>()V

    return-void
.end method


# virtual methods
.method add(Landroid/os/Message;Ljava/lang/String;Lcom/android/internal/util/State;Lcom/android/internal/util/State;)V
    .registers 8
    .parameter "msg"
    .parameter "messageInfo"
    .parameter "state"
    .parameter "orgState"

    .prologue
    .line 629
    iget v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mCount:I

    .line 630
    iget-object v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMessages:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->size()I

    move-result v1

    iget v2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMaxSize:I

    if-ge v1, v2, :cond_1b

    .line 631
    iget-object v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMessages:Ljava/util/Vector;

    new-instance v2, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;

    invoke-direct {v2, p1, p2, p3, p4}, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;-><init>(Landroid/os/Message;Ljava/lang/String;Lcom/android/internal/util/State;Lcom/android/internal/util/State;)V

    invoke-virtual {v1, v2}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 640
    :goto_1a
    return-void

    .line 633
    :cond_1b
    iget-object v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMessages:Ljava/util/Vector;

    iget v2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mOldestIndex:I

    invoke-virtual {v1, v2}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;

    .line 634
    .local v0, pmi:Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;
    iget v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mOldestIndex:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mOldestIndex:I

    .line 635
    iget v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mOldestIndex:I

    iget v2, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMaxSize:I

    if-lt v1, v2, :cond_34

    .line 636
    const/4 v1, 0x0

    iput v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mOldestIndex:I

    .line 638
    :cond_34
    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;->update(Landroid/os/Message;Ljava/lang/String;Lcom/android/internal/util/State;Lcom/android/internal/util/State;)V

    goto :goto_1a
.end method

.method cleanup()V
    .registers 2

    .prologue
    .line 599
    iget-object v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMessages:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 600
    return-void
.end method

.method count()I
    .registers 2

    .prologue
    .line 592
    iget v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mCount:I

    return v0
.end method

.method get(I)Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;
    .registers 4
    .parameter "index"

    .prologue
    .line 608
    iget v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mOldestIndex:I

    add-int v0, v1, p1

    .line 609
    .local v0, nextIndex:I
    iget v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMaxSize:I

    if-lt v0, v1, :cond_b

    .line 610
    iget v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMaxSize:I

    sub-int/2addr v0, v1

    .line 612
    :cond_b
    invoke-virtual {p0}, Lcom/android/internal/util/StateMachine$ProcessedMessages;->size()I

    move-result v1

    if-lt v0, v1, :cond_13

    .line 613
    const/4 v1, 0x0

    .line 615
    :goto_12
    return-object v1

    :cond_13
    iget-object v1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMessages:Ljava/util/Vector;

    invoke-virtual {v1, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/internal/util/StateMachine$ProcessedMessageInfo;

    goto :goto_12
.end method

.method setSize(I)V
    .registers 3
    .parameter "maxSize"

    .prologue
    .line 576
    iput p1, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMaxSize:I

    .line 577
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mCount:I

    .line 578
    iget-object v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMessages:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 579
    return-void
.end method

.method size()I
    .registers 2

    .prologue
    .line 585
    iget-object v0, p0, Lcom/android/internal/util/StateMachine$ProcessedMessages;->mMessages:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->size()I

    move-result v0

    return v0
.end method
