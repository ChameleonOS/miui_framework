.class public Landroid/media/dolby/DolbyMobileAudioEffectClientAgent;
.super Ljava/lang/Object;
.source "DolbyMobileAudioEffectClientAgent.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bindToRemoteRunningService(Landroid/app/Activity;)V
    .registers 2
    .parameter "activity"

    .prologue
    return-void
.end method

.method public getDolyPresetCategory()I
    .registers 2

    .prologue
    const/4 v0, -0x1

    return v0
.end method

.method public registerCallback(Landroid/media/dolby/DolbyMobileClientCallbacks;)V
    .registers 2
    .parameter "cb"

    .prologue
    return-void
.end method

.method public setDolyPresetCategory(I)I
    .registers 3
    .parameter "presetCategory"

    .prologue
    const/4 v0, -0x1

    return v0
.end method

.method public unBindFromRemoteRunningService(Landroid/app/Activity;)V
    .registers 2
    .parameter "activity"

    .prologue
    return-void
.end method
