.class public final Lcom/android/internal/telephony/IccVmNotSupportedException;
.super Lcom/android/internal/telephony/IccException;
.source "IccVmNotSupportedException.java"


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Lcom/android/internal/telephony/IccException;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "s"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/IccException;-><init>(Ljava/lang/String;)V

    return-void
.end method
