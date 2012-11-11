.class abstract Landroid/speech/tts/TextToSpeechService$SpeechItem;
.super Ljava/lang/Object;
.source "TextToSpeechService.java"

# interfaces
.implements Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/speech/tts/TextToSpeechService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "SpeechItem"
.end annotation


# instance fields
.field private final mCallerIdentity:Ljava/lang/Object;

.field private final mCallerPid:I

.field private final mCallerUid:I

.field protected final mParams:Landroid/os/Bundle;

.field private mStarted:Z

.field private mStopped:Z

.field final synthetic this$0:Landroid/speech/tts/TextToSpeechService;


# direct methods
.method public constructor <init>(Landroid/speech/tts/TextToSpeechService;Ljava/lang/Object;IILandroid/os/Bundle;)V
    .registers 7
    .parameter
    .parameter "caller"
    .parameter "callerUid"
    .parameter "callerPid"
    .parameter "params"

    .prologue
    const/4 v0, 0x0

    iput-object p1, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->this$0:Landroid/speech/tts/TextToSpeechService;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-boolean v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mStarted:Z

    iput-boolean v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mStopped:Z

    iput-object p2, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mCallerIdentity:Ljava/lang/Object;

    iput-object p5, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mParams:Landroid/os/Bundle;

    iput p3, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mCallerUid:I

    iput p4, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mCallerPid:I

    return-void
.end method


# virtual methods
.method public dispatchOnDone()V
    .registers 4

    .prologue
    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$SpeechItem;->getUtteranceId()Ljava/lang/String;

    move-result-object v0

    .local v0, utteranceId:Ljava/lang/String;
    if-eqz v0, :cond_13

    iget-object v1, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->this$0:Landroid/speech/tts/TextToSpeechService;

    #getter for: Landroid/speech/tts/TextToSpeechService;->mCallbacks:Landroid/speech/tts/TextToSpeechService$CallbackMap;
    invoke-static {v1}, Landroid/speech/tts/TextToSpeechService;->access$300(Landroid/speech/tts/TextToSpeechService;)Landroid/speech/tts/TextToSpeechService$CallbackMap;

    move-result-object v1

    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$SpeechItem;->getCallerIdentity()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Landroid/speech/tts/TextToSpeechService$CallbackMap;->dispatchOnDone(Ljava/lang/Object;Ljava/lang/String;)V

    :cond_13
    return-void
.end method

.method public dispatchOnError()V
    .registers 4

    .prologue
    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$SpeechItem;->getUtteranceId()Ljava/lang/String;

    move-result-object v0

    .local v0, utteranceId:Ljava/lang/String;
    if-eqz v0, :cond_13

    iget-object v1, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->this$0:Landroid/speech/tts/TextToSpeechService;

    #getter for: Landroid/speech/tts/TextToSpeechService;->mCallbacks:Landroid/speech/tts/TextToSpeechService$CallbackMap;
    invoke-static {v1}, Landroid/speech/tts/TextToSpeechService;->access$300(Landroid/speech/tts/TextToSpeechService;)Landroid/speech/tts/TextToSpeechService$CallbackMap;

    move-result-object v1

    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$SpeechItem;->getCallerIdentity()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Landroid/speech/tts/TextToSpeechService$CallbackMap;->dispatchOnError(Ljava/lang/Object;Ljava/lang/String;)V

    :cond_13
    return-void
.end method

.method public dispatchOnStart()V
    .registers 4

    .prologue
    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$SpeechItem;->getUtteranceId()Ljava/lang/String;

    move-result-object v0

    .local v0, utteranceId:Ljava/lang/String;
    if-eqz v0, :cond_13

    iget-object v1, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->this$0:Landroid/speech/tts/TextToSpeechService;

    #getter for: Landroid/speech/tts/TextToSpeechService;->mCallbacks:Landroid/speech/tts/TextToSpeechService$CallbackMap;
    invoke-static {v1}, Landroid/speech/tts/TextToSpeechService;->access$300(Landroid/speech/tts/TextToSpeechService;)Landroid/speech/tts/TextToSpeechService$CallbackMap;

    move-result-object v1

    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$SpeechItem;->getCallerIdentity()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Landroid/speech/tts/TextToSpeechService$CallbackMap;->dispatchOnStart(Ljava/lang/Object;Ljava/lang/String;)V

    :cond_13
    return-void
.end method

.method public getCallerIdentity()Ljava/lang/Object;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mCallerIdentity:Ljava/lang/Object;

    return-object v0
.end method

.method public getCallerPid()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mCallerPid:I

    return v0
.end method

.method public getCallerUid()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mCallerUid:I

    return v0
.end method

.method protected getFloatParam(Ljava/lang/String;F)F
    .registers 4
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    iget-object v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mParams:Landroid/os/Bundle;

    if-nez v0, :cond_5

    .end local p2
    :goto_4
    return p2

    .restart local p2
    :cond_5
    iget-object v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mParams:Landroid/os/Bundle;

    invoke-virtual {v0, p1, p2}, Landroid/os/Bundle;->getFloat(Ljava/lang/String;F)F

    move-result p2

    goto :goto_4
.end method

.method protected getIntParam(Ljava/lang/String;I)I
    .registers 4
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    iget-object v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mParams:Landroid/os/Bundle;

    if-nez v0, :cond_5

    .end local p2
    :goto_4
    return p2

    .restart local p2
    :cond_5
    iget-object v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mParams:Landroid/os/Bundle;

    invoke-virtual {v0, p1, p2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result p2

    goto :goto_4
.end method

.method public getPan()F
    .registers 3

    .prologue
    const-string/jumbo v0, "pan"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/speech/tts/TextToSpeechService$SpeechItem;->getFloatParam(Ljava/lang/String;F)F

    move-result v0

    return v0
.end method

.method public getStreamType()I
    .registers 3

    .prologue
    const-string/jumbo v0, "streamType"

    const/4 v1, 0x3

    invoke-virtual {p0, v0, v1}, Landroid/speech/tts/TextToSpeechService$SpeechItem;->getIntParam(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method protected getStringParam(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 4
    .parameter "key"
    .parameter "defaultValue"

    .prologue
    iget-object v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mParams:Landroid/os/Bundle;

    if-nez v0, :cond_5

    .end local p2
    :goto_4
    return-object p2

    .restart local p2
    :cond_5
    iget-object v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mParams:Landroid/os/Bundle;

    invoke-virtual {v0, p1, p2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    goto :goto_4
.end method

.method public getUtteranceId()Ljava/lang/String;
    .registers 3

    .prologue
    const-string/jumbo v0, "utteranceId"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/speech/tts/TextToSpeechService$SpeechItem;->getStringParam(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVolume()F
    .registers 3

    .prologue
    const-string/jumbo v0, "volume"

    const/high16 v1, 0x3f80

    invoke-virtual {p0, v0, v1}, Landroid/speech/tts/TextToSpeechService$SpeechItem;->getFloatParam(Ljava/lang/String;F)F

    move-result v0

    return v0
.end method

.method protected declared-synchronized isStopped()Z
    .registers 2

    .prologue
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mStopped:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public abstract isValid()Z
.end method

.method public play()I
    .registers 3

    .prologue
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mStarted:Z

    if-eqz v0, :cond_11

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "play() called twice"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :catchall_e
    move-exception v0

    monitor-exit p0
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_e

    throw v0

    :cond_11
    const/4 v0, 0x1

    :try_start_12
    iput-boolean v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mStarted:Z

    monitor-exit p0
    :try_end_15
    .catchall {:try_start_12 .. :try_end_15} :catchall_e

    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$SpeechItem;->playImpl()I

    move-result v0

    return v0
.end method

.method protected abstract playImpl()I
.end method

.method public stop()V
    .registers 3

    .prologue
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mStopped:Z

    if-eqz v0, :cond_11

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "stop() called twice"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :catchall_e
    move-exception v0

    monitor-exit p0
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_e

    throw v0

    :cond_11
    const/4 v0, 0x1

    :try_start_12
    iput-boolean v0, p0, Landroid/speech/tts/TextToSpeechService$SpeechItem;->mStopped:Z

    monitor-exit p0
    :try_end_15
    .catchall {:try_start_12 .. :try_end_15} :catchall_e

    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$SpeechItem;->stopImpl()V

    return-void
.end method

.method protected abstract stopImpl()V
.end method
