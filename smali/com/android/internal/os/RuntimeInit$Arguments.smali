.class Lcom/android/internal/os/RuntimeInit$Arguments;
.super Ljava/lang/Object;
.source "RuntimeInit.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/os/RuntimeInit;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Arguments"
.end annotation


# instance fields
.field startArgs:[Ljava/lang/String;

.field startClass:Ljava/lang/String;


# direct methods
.method constructor <init>([Ljava/lang/String;)V
    .registers 2
    .parameter "args"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 380
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 381
    invoke-direct {p0, p1}, Lcom/android/internal/os/RuntimeInit$Arguments;->parseArgs([Ljava/lang/String;)V

    .line 382
    return-void
.end method

.method private parseArgs([Ljava/lang/String;)V
    .registers 8
    .parameter "args"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 389
    const/4 v1, 0x0

    .line 390
    .local v1, curArg:I
    :goto_1
    array-length v3, p1

    if-ge v1, v3, :cond_10

    .line 391
    aget-object v0, p1, v1

    .line 393
    .local v0, arg:Ljava/lang/String;
    const-string v3, "--"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1b

    .line 394
    add-int/lit8 v1, v1, 0x1

    .line 401
    .end local v0           #arg:Ljava/lang/String;
    :cond_10
    array-length v3, p1

    if-ne v1, v3, :cond_26

    .line 402
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Missing classname argument to RuntimeInit!"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 396
    .restart local v0       #arg:Ljava/lang/String;
    :cond_1b
    const-string v3, "--"

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_10

    .line 390
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 405
    .end local v0           #arg:Ljava/lang/String;
    :cond_26
    add-int/lit8 v2, v1, 0x1

    .end local v1           #curArg:I
    .local v2, curArg:I
    aget-object v3, p1, v1

    iput-object v3, p0, Lcom/android/internal/os/RuntimeInit$Arguments;->startClass:Ljava/lang/String;

    .line 406
    array-length v3, p1

    sub-int/2addr v3, v2

    new-array v3, v3, [Ljava/lang/String;

    iput-object v3, p0, Lcom/android/internal/os/RuntimeInit$Arguments;->startArgs:[Ljava/lang/String;

    .line 407
    iget-object v3, p0, Lcom/android/internal/os/RuntimeInit$Arguments;->startArgs:[Ljava/lang/String;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/android/internal/os/RuntimeInit$Arguments;->startArgs:[Ljava/lang/String;

    array-length v5, v5

    invoke-static {p1, v2, v3, v4, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 408
    return-void
.end method
