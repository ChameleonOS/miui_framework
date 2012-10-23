.class public Lcom/android/internal/telephony/RestrictedState;
.super Ljava/lang/Object;
.source "RestrictedState.java"


# instance fields
.field private mCsEmergencyRestricted:Z

.field private mCsNormalRestricted:Z

.field private mPsRestricted:Z


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    .line 36
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 37
    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/RestrictedState;->setPsRestricted(Z)V

    .line 38
    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/RestrictedState;->setCsNormalRestricted(Z)V

    .line 39
    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/RestrictedState;->setCsEmergencyRestricted(Z)V

    .line 40
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 8
    .parameter "o"

    .prologue
    const/4 v3, 0x0

    .line 93
    :try_start_1
    move-object v0, p1

    check-cast v0, Lcom/android/internal/telephony/RestrictedState;

    move-object v2, v0
    :try_end_5
    .catch Ljava/lang/ClassCastException; {:try_start_1 .. :try_end_5} :catch_8

    .line 98
    .local v2, s:Lcom/android/internal/telephony/RestrictedState;
    if-nez p1, :cond_a

    .line 102
    .end local v2           #s:Lcom/android/internal/telephony/RestrictedState;
    :cond_7
    :goto_7
    return v3

    .line 94
    :catch_8
    move-exception v1

    .line 95
    .local v1, ex:Ljava/lang/ClassCastException;
    goto :goto_7

    .line 102
    .end local v1           #ex:Ljava/lang/ClassCastException;
    .restart local v2       #s:Lcom/android/internal/telephony/RestrictedState;
    :cond_a
    iget-boolean v4, p0, Lcom/android/internal/telephony/RestrictedState;->mPsRestricted:Z

    iget-boolean v5, v2, Lcom/android/internal/telephony/RestrictedState;->mPsRestricted:Z

    if-ne v4, v5, :cond_7

    iget-boolean v4, p0, Lcom/android/internal/telephony/RestrictedState;->mCsNormalRestricted:Z

    iget-boolean v5, v2, Lcom/android/internal/telephony/RestrictedState;->mCsNormalRestricted:Z

    if-ne v4, v5, :cond_7

    iget-boolean v4, p0, Lcom/android/internal/telephony/RestrictedState;->mCsEmergencyRestricted:Z

    iget-boolean v5, v2, Lcom/android/internal/telephony/RestrictedState;->mCsEmergencyRestricted:Z

    if-ne v4, v5, :cond_7

    const/4 v3, 0x1

    goto :goto_7
.end method

.method public isCsEmergencyRestricted()Z
    .registers 2

    .prologue
    .line 53
    iget-boolean v0, p0, Lcom/android/internal/telephony/RestrictedState;->mCsEmergencyRestricted:Z

    return v0
.end method

.method public isCsNormalRestricted()Z
    .registers 2

    .prologue
    .line 67
    iget-boolean v0, p0, Lcom/android/internal/telephony/RestrictedState;->mCsNormalRestricted:Z

    return v0
.end method

.method public isCsRestricted()Z
    .registers 2

    .prologue
    .line 85
    iget-boolean v0, p0, Lcom/android/internal/telephony/RestrictedState;->mCsNormalRestricted:Z

    if-eqz v0, :cond_a

    iget-boolean v0, p0, Lcom/android/internal/telephony/RestrictedState;->mCsEmergencyRestricted:Z

    if-eqz v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public isPsRestricted()Z
    .registers 2

    .prologue
    .line 81
    iget-boolean v0, p0, Lcom/android/internal/telephony/RestrictedState;->mPsRestricted:Z

    return v0
.end method

.method public setCsEmergencyRestricted(Z)V
    .registers 2
    .parameter "csEmergencyRestricted"

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/android/internal/telephony/RestrictedState;->mCsEmergencyRestricted:Z

    .line 47
    return-void
.end method

.method public setCsNormalRestricted(Z)V
    .registers 2
    .parameter "csNormalRestricted"

    .prologue
    .line 60
    iput-boolean p1, p0, Lcom/android/internal/telephony/RestrictedState;->mCsNormalRestricted:Z

    .line 61
    return-void
.end method

.method public setPsRestricted(Z)V
    .registers 2
    .parameter "psRestricted"

    .prologue
    .line 74
    iput-boolean p1, p0, Lcom/android/internal/telephony/RestrictedState;->mPsRestricted:Z

    .line 75
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 109
    const-string/jumbo v0, "none"

    .line 111
    .local v0, csString:Ljava/lang/String;
    iget-boolean v1, p0, Lcom/android/internal/telephony/RestrictedState;->mCsEmergencyRestricted:Z

    if-eqz v1, :cond_2d

    iget-boolean v1, p0, Lcom/android/internal/telephony/RestrictedState;->mCsNormalRestricted:Z

    if-eqz v1, :cond_2d

    .line 112
    const-string v0, "all"

    .line 119
    :cond_d
    :goto_d
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Restricted State CS: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " PS:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcom/android/internal/telephony/RestrictedState;->mPsRestricted:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 113
    :cond_2d
    iget-boolean v1, p0, Lcom/android/internal/telephony/RestrictedState;->mCsEmergencyRestricted:Z

    if-eqz v1, :cond_38

    iget-boolean v1, p0, Lcom/android/internal/telephony/RestrictedState;->mCsNormalRestricted:Z

    if-nez v1, :cond_38

    .line 114
    const-string v0, "emergency"

    goto :goto_d

    .line 115
    :cond_38
    iget-boolean v1, p0, Lcom/android/internal/telephony/RestrictedState;->mCsEmergencyRestricted:Z

    if-nez v1, :cond_d

    iget-boolean v1, p0, Lcom/android/internal/telephony/RestrictedState;->mCsNormalRestricted:Z

    if-eqz v1, :cond_d

    .line 116
    const-string/jumbo v0, "normal call"

    goto :goto_d
.end method
