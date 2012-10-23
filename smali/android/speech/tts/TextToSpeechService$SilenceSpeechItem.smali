.class Landroid/speech/tts/TextToSpeechService$SilenceSpeechItem;
.super Landroid/speech/tts/TextToSpeechService$SpeechItem;
.source "TextToSpeechService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/speech/tts/TextToSpeechService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SilenceSpeechItem"
.end annotation


# instance fields
.field private final mDuration:J

.field final synthetic this$0:Landroid/speech/tts/TextToSpeechService;


# direct methods
.method public constructor <init>(Landroid/speech/tts/TextToSpeechService;Ljava/lang/Object;IILandroid/os/Bundle;J)V
    .registers 8
    .parameter
    .parameter "callerIdentity"
    .parameter "callerUid"
    .parameter "callerPid"
    .parameter "params"
    .parameter "duration"

    .prologue
    .line 726
    iput-object p1, p0, Landroid/speech/tts/TextToSpeechService$SilenceSpeechItem;->this$0:Landroid/speech/tts/TextToSpeechService;

    .line 727
    invoke-direct/range {p0 .. p5}, Landroid/speech/tts/TextToSpeechService$SpeechItem;-><init>(Landroid/speech/tts/TextToSpeechService;Ljava/lang/Object;IILandroid/os/Bundle;)V

    .line 728
    iput-wide p6, p0, Landroid/speech/tts/TextToSpeechService$SilenceSpeechItem;->mDuration:J

    .line 729
    return-void
.end method


# virtual methods
.method public isValid()Z
    .registers 2

    .prologue
    .line 733
    const/4 v0, 0x1

    return v0
.end method

.method protected playImpl()I
    .registers 6

    .prologue
    .line 738
    iget-object v0, p0, Landroid/speech/tts/TextToSpeechService$SilenceSpeechItem;->this$0:Landroid/speech/tts/TextToSpeechService;

    #getter for: Landroid/speech/tts/TextToSpeechService;->mAudioPlaybackHandler:Landroid/speech/tts/AudioPlaybackHandler;
    invoke-static {v0}, Landroid/speech/tts/TextToSpeechService;->access$200(Landroid/speech/tts/TextToSpeechService;)Landroid/speech/tts/AudioPlaybackHandler;

    move-result-object v0

    new-instance v1, Landroid/speech/tts/SilencePlaybackQueueItem;

    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$SilenceSpeechItem;->getCallerIdentity()Ljava/lang/Object;

    move-result-object v2

    iget-wide v3, p0, Landroid/speech/tts/TextToSpeechService$SilenceSpeechItem;->mDuration:J

    invoke-direct {v1, p0, v2, v3, v4}, Landroid/speech/tts/SilencePlaybackQueueItem;-><init>(Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;Ljava/lang/Object;J)V

    invoke-virtual {v0, v1}, Landroid/speech/tts/AudioPlaybackHandler;->enqueue(Landroid/speech/tts/PlaybackQueueItem;)V

    .line 740
    const/4 v0, 0x0

    return v0
.end method

.method protected stopImpl()V
    .registers 1

    .prologue
    .line 746
    return-void
.end method
