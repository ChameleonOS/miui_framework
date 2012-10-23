.class Lcom/android/internal/util/StateMachine$SmHandler$HaltingState;
.super Lcom/android/internal/util/State;
.source "StateMachine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/util/StateMachine$SmHandler;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HaltingState"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/util/StateMachine$SmHandler;


# direct methods
.method private constructor <init>(Lcom/android/internal/util/StateMachine$SmHandler;)V
    .registers 2
    .parameter

    .prologue
    .line 723
    iput-object p1, p0, Lcom/android/internal/util/StateMachine$SmHandler$HaltingState;->this$0:Lcom/android/internal/util/StateMachine$SmHandler;

    invoke-direct {p0}, Lcom/android/internal/util/State;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/internal/util/StateMachine$SmHandler;Lcom/android/internal/util/StateMachine$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 723
    invoke-direct {p0, p1}, Lcom/android/internal/util/StateMachine$SmHandler$HaltingState;-><init>(Lcom/android/internal/util/StateMachine$SmHandler;)V

    return-void
.end method


# virtual methods
.method public processMessage(Landroid/os/Message;)Z
    .registers 3
    .parameter "msg"

    .prologue
    .line 726
    iget-object v0, p0, Lcom/android/internal/util/StateMachine$SmHandler$HaltingState;->this$0:Lcom/android/internal/util/StateMachine$SmHandler;

    #getter for: Lcom/android/internal/util/StateMachine$SmHandler;->mSm:Lcom/android/internal/util/StateMachine;
    invoke-static {v0}, Lcom/android/internal/util/StateMachine$SmHandler;->access$300(Lcom/android/internal/util/StateMachine$SmHandler;)Lcom/android/internal/util/StateMachine;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/android/internal/util/StateMachine;->haltedProcessMessage(Landroid/os/Message;)V

    .line 727
    const/4 v0, 0x1

    return v0
.end method
