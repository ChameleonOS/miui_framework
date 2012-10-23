.class Lcom/android/internal/telephony/RetryManager$RetryRec;
.super Ljava/lang/Object;
.source "RetryManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/RetryManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RetryRec"
.end annotation


# instance fields
.field mDelayTime:I

.field mRandomizationTime:I


# direct methods
.method constructor <init>(II)V
    .registers 3
    .parameter "delayTime"
    .parameter "randomizationTime"

    .prologue
    .line 84
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 85
    iput p1, p0, Lcom/android/internal/telephony/RetryManager$RetryRec;->mDelayTime:I

    .line 86
    iput p2, p0, Lcom/android/internal/telephony/RetryManager$RetryRec;->mRandomizationTime:I

    .line 87
    return-void
.end method
