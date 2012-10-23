.class public Lcom/android/internal/telephony/DataConnection$CallSetupException;
.super Ljava/lang/Exception;
.source "DataConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/DataConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallSetupException"
.end annotation


# instance fields
.field private mRetryOverride:I


# direct methods
.method constructor <init>(I)V
    .registers 3
    .parameter "retryOverride"

    .prologue
    .line 194
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 192
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/internal/telephony/DataConnection$CallSetupException;->mRetryOverride:I

    .line 195
    iput p1, p0, Lcom/android/internal/telephony/DataConnection$CallSetupException;->mRetryOverride:I

    .line 196
    return-void
.end method


# virtual methods
.method public getRetryOverride()I
    .registers 2

    .prologue
    .line 199
    iget v0, p0, Lcom/android/internal/telephony/DataConnection$CallSetupException;->mRetryOverride:I

    return v0
.end method
