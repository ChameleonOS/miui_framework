.class public final Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;
.super Ljava/lang/Object;
.source "SmsBroadcastConfigInfo.java"


# instance fields
.field private fromCodeScheme:I

.field private fromServiceId:I

.field private selected:Z

.field private toCodeScheme:I

.field private toServiceId:I


# direct methods
.method public constructor <init>(IIIIZ)V
    .registers 6
    .parameter "fromId"
    .parameter "toId"
    .parameter "fromScheme"
    .parameter "toScheme"
    .parameter "selected"

    .prologue
    .line 48
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput p1, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->fromServiceId:I

    .line 50
    iput p2, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->toServiceId:I

    .line 51
    iput p3, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->fromCodeScheme:I

    .line 52
    iput p4, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->toCodeScheme:I

    .line 53
    iput-boolean p5, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->selected:Z

    .line 54
    return-void
.end method


# virtual methods
.method public getFromCodeScheme()I
    .registers 2

    .prologue
    .line 95
    iget v0, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->fromCodeScheme:I

    return v0
.end method

.method public getFromServiceId()I
    .registers 2

    .prologue
    .line 67
    iget v0, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->fromServiceId:I

    return v0
.end method

.method public getToCodeScheme()I
    .registers 2

    .prologue
    .line 109
    iget v0, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->toCodeScheme:I

    return v0
.end method

.method public getToServiceId()I
    .registers 2

    .prologue
    .line 81
    iget v0, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->toServiceId:I

    return v0
.end method

.method public isSelected()Z
    .registers 2

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->selected:Z

    return v0
.end method

.method public setFromCodeScheme(I)V
    .registers 2
    .parameter "fromCodeScheme"

    .prologue
    .line 88
    iput p1, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->fromCodeScheme:I

    .line 89
    return-void
.end method

.method public setFromServiceId(I)V
    .registers 2
    .parameter "fromServiceId"

    .prologue
    .line 60
    iput p1, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->fromServiceId:I

    .line 61
    return-void
.end method

.method public setSelected(Z)V
    .registers 2
    .parameter "selected"

    .prologue
    .line 116
    iput-boolean p1, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->selected:Z

    .line 117
    return-void
.end method

.method public setToCodeScheme(I)V
    .registers 2
    .parameter "toCodeScheme"

    .prologue
    .line 102
    iput p1, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->toCodeScheme:I

    .line 103
    return-void
.end method

.method public setToServiceId(I)V
    .registers 2
    .parameter "toServiceId"

    .prologue
    .line 74
    iput p1, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->toServiceId:I

    .line 75
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    const/16 v2, 0x2c

    .line 128
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "SmsBroadcastConfigInfo: Id ["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->fromServiceId:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->toServiceId:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "] Code ["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->fromCodeScheme:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->toCodeScheme:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "] "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v0, p0, Lcom/android/internal/telephony/gsm/SmsBroadcastConfigInfo;->selected:Z

    if-eqz v0, :cond_48

    const-string v0, "ENABLED"

    :goto_3f
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_48
    const-string v0, "DISABLED"

    goto :goto_3f
.end method
