.class public Lcom/android/internal/util/State;
.super Ljava/lang/Object;
.source "State.java"

# interfaces
.implements Lcom/android/internal/util/IState;


# direct methods
.method protected constructor <init>()V
    .registers 1

    .prologue
    .line 31
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 32
    return-void
.end method


# virtual methods
.method public enter()V
    .registers 1

    .prologue
    .line 39
    return-void
.end method

.method public exit()V
    .registers 1

    .prologue
    .line 46
    return-void
.end method

.method public getName()Ljava/lang/String;
    .registers 4

    .prologue
    .line 70
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    .line 71
    .local v1, name:Ljava/lang/String;
    const/16 v2, 0x24

    invoke-virtual {v1, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v0

    .line 72
    .local v0, lastDollar:I
    add-int/lit8 v2, v0, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public processMessage(Landroid/os/Message;)Z
    .registers 3
    .parameter "msg"

    .prologue
    .line 53
    const/4 v0, 0x0

    return v0
.end method
