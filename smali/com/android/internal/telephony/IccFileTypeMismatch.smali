.class public Lcom/android/internal/telephony/IccFileTypeMismatch;
.super Lcom/android/internal/telephony/IccException;
.source "IccFileTypeMismatch.java"


# direct methods
.method public constructor <init>()V
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
