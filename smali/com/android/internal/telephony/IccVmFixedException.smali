.class public final Lcom/android/internal/telephony/IccVmFixedException;
.super Lcom/android/internal/telephony/IccException;
.source "IccVmFixedException.java"


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/android/internal/telephony/IccException;-><init>()V

    .line 26
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "s"

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/IccException;-><init>(Ljava/lang/String;)V

    .line 31
    return-void
.end method
