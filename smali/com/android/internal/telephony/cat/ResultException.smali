.class public Lcom/android/internal/telephony/cat/ResultException;
.super Lcom/android/internal/telephony/cat/CatException;
.source "ResultException.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/telephony/cat/ResultException$1;
    }
.end annotation


# instance fields
.field private mAdditionalInfo:I

.field private mExplanation:Ljava/lang/String;

.field private mResult:Lcom/android/internal/telephony/cat/ResultCode;


# direct methods
.method public constructor <init>(Lcom/android/internal/telephony/cat/ResultCode;)V
    .registers 5
    .parameter "result"

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/android/internal/telephony/cat/CatException;-><init>()V

    .line 36
    sget-object v0, Lcom/android/internal/telephony/cat/ResultException$1;->$SwitchMap$com$android$internal$telephony$cat$ResultCode:[I

    invoke-virtual {p1}, Lcom/android/internal/telephony/cat/ResultCode;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_38

    .line 50
    iput-object p1, p0, Lcom/android/internal/telephony/cat/ResultException;->mResult:Lcom/android/internal/telephony/cat/ResultCode;

    .line 51
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/internal/telephony/cat/ResultException;->mAdditionalInfo:I

    .line 52
    const-string v0, ""

    iput-object v0, p0, Lcom/android/internal/telephony/cat/ResultException;->mExplanation:Ljava/lang/String;

    .line 53
    return-void

    .line 45
    :pswitch_18
    new-instance v0, Ljava/lang/AssertionError;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "For result code, "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", additional information must be given!"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0

    .line 36
    nop

    :pswitch_data_38
    .packed-switch 0x1
        :pswitch_18
        :pswitch_18
        :pswitch_18
        :pswitch_18
        :pswitch_18
        :pswitch_18
        :pswitch_18
        :pswitch_18
    .end packed-switch
.end method

.method public constructor <init>(Lcom/android/internal/telephony/cat/ResultCode;I)V
    .registers 5
    .parameter "result"
    .parameter "additionalInfo"

    .prologue
    .line 61
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/cat/ResultException;-><init>(Lcom/android/internal/telephony/cat/ResultCode;)V

    .line 63
    if-gez p2, :cond_d

    .line 64
    new-instance v0, Ljava/lang/AssertionError;

    const-string v1, "Additional info must be greater than zero!"

    invoke-direct {v0, v1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0

    .line 68
    :cond_d
    iput p2, p0, Lcom/android/internal/telephony/cat/ResultException;->mAdditionalInfo:I

    .line 69
    return-void
.end method

.method public constructor <init>(Lcom/android/internal/telephony/cat/ResultCode;ILjava/lang/String;)V
    .registers 4
    .parameter "result"
    .parameter "additionalInfo"
    .parameter "explanation"

    .prologue
    .line 72
    invoke-direct {p0, p1, p2}, Lcom/android/internal/telephony/cat/ResultException;-><init>(Lcom/android/internal/telephony/cat/ResultCode;I)V

    .line 73
    iput-object p3, p0, Lcom/android/internal/telephony/cat/ResultException;->mExplanation:Ljava/lang/String;

    .line 74
    return-void
.end method

.method public constructor <init>(Lcom/android/internal/telephony/cat/ResultCode;Ljava/lang/String;)V
    .registers 3
    .parameter "result"
    .parameter "explanation"

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/cat/ResultException;-><init>(Lcom/android/internal/telephony/cat/ResultCode;)V

    .line 57
    iput-object p2, p0, Lcom/android/internal/telephony/cat/ResultException;->mExplanation:Ljava/lang/String;

    .line 58
    return-void
.end method


# virtual methods
.method public additionalInfo()I
    .registers 2

    .prologue
    .line 85
    iget v0, p0, Lcom/android/internal/telephony/cat/ResultException;->mAdditionalInfo:I

    return v0
.end method

.method public explanation()Ljava/lang/String;
    .registers 2

    .prologue
    .line 89
    iget-object v0, p0, Lcom/android/internal/telephony/cat/ResultException;->mExplanation:Ljava/lang/String;

    return-object v0
.end method

.method public hasAdditionalInfo()Z
    .registers 2

    .prologue
    .line 81
    iget v0, p0, Lcom/android/internal/telephony/cat/ResultException;->mAdditionalInfo:I

    if-ltz v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public result()Lcom/android/internal/telephony/cat/ResultCode;
    .registers 2

    .prologue
    .line 77
    iget-object v0, p0, Lcom/android/internal/telephony/cat/ResultException;->mResult:Lcom/android/internal/telephony/cat/ResultCode;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 94
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "result="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/cat/ResultException;->mResult:Lcom/android/internal/telephony/cat/ResultCode;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " additionalInfo="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/android/internal/telephony/cat/ResultException;->mAdditionalInfo:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " explantion="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/cat/ResultException;->mExplanation:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
