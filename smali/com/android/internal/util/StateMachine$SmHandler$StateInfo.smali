.class Lcom/android/internal/util/StateMachine$SmHandler$StateInfo;
.super Ljava/lang/Object;
.source "StateMachine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/util/StateMachine$SmHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "StateInfo"
.end annotation


# instance fields
.field active:Z

.field parentStateInfo:Lcom/android/internal/util/StateMachine$SmHandler$StateInfo;

.field state:Lcom/android/internal/util/State;

.field final synthetic this$0:Lcom/android/internal/util/StateMachine$SmHandler;


# direct methods
.method private constructor <init>(Lcom/android/internal/util/StateMachine$SmHandler;)V
    .registers 2
    .parameter

    .prologue
    .line 686
    iput-object p1, p0, Lcom/android/internal/util/StateMachine$SmHandler$StateInfo;->this$0:Lcom/android/internal/util/StateMachine$SmHandler;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/internal/util/StateMachine$SmHandler;Lcom/android/internal/util/StateMachine$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 686
    invoke-direct {p0, p1}, Lcom/android/internal/util/StateMachine$SmHandler$StateInfo;-><init>(Lcom/android/internal/util/StateMachine$SmHandler;)V

    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 701
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "state="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/util/StateMachine$SmHandler$StateInfo;->state:Lcom/android/internal/util/State;

    invoke-virtual {v1}, Lcom/android/internal/util/State;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",active="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/android/internal/util/StateMachine$SmHandler$StateInfo;->active:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",parent="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v0, p0, Lcom/android/internal/util/StateMachine$SmHandler$StateInfo;->parentStateInfo:Lcom/android/internal/util/StateMachine$SmHandler$StateInfo;

    if-nez v0, :cond_38

    const-string/jumbo v0, "null"

    :goto_2f
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_38
    iget-object v0, p0, Lcom/android/internal/util/StateMachine$SmHandler$StateInfo;->parentStateInfo:Lcom/android/internal/util/StateMachine$SmHandler$StateInfo;

    iget-object v0, v0, Lcom/android/internal/util/StateMachine$SmHandler$StateInfo;->state:Lcom/android/internal/util/State;

    invoke-virtual {v0}, Lcom/android/internal/util/State;->getName()Ljava/lang/String;

    move-result-object v0

    goto :goto_2f
.end method
