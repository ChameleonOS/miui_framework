.class public Landroid/os/OperationCanceledException;
.super Ljava/lang/RuntimeException;
.source "OperationCanceledException.java"


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 27
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/os/OperationCanceledException;-><init>(Ljava/lang/String;)V

    .line 28
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "message"

    .prologue
    .line 31
    if-eqz p1, :cond_6

    .end local p1
    :goto_2
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 32
    return-void

    .line 31
    .restart local p1
    :cond_6
    const-string p1, "The operation has been canceled."

    goto :goto_2
.end method
