.class public Landroid/os/BadParcelableException;
.super Landroid/util/AndroidRuntimeException;
.source "BadParcelableException.java"


# direct methods
.method public constructor <init>(Ljava/lang/Exception;)V
    .registers 2
    .parameter "cause"

    .prologue
    invoke-direct {p0, p1}, Landroid/util/AndroidRuntimeException;-><init>(Ljava/lang/Exception;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "msg"

    .prologue
    invoke-direct {p0, p1}, Landroid/util/AndroidRuntimeException;-><init>(Ljava/lang/String;)V

    return-void
.end method
