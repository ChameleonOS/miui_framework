.class Landroid/speech/tts/TextToSpeechService$AudioSpeechItem;
.super Landroid/speech/tts/TextToSpeechService$SpeechItem;
.source "TextToSpeechService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/speech/tts/TextToSpeechService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AudioSpeechItem"
.end annotation


# instance fields
.field private final mItem:Landroid/speech/tts/AudioPlaybackQueueItem;

.field final synthetic this$0:Landroid/speech/tts/TextToSpeechService;


# direct methods
.method public constructor <init>(Landroid/speech/tts/TextToSpeechService;Ljava/lang/Object;IILandroid/os/Bundle;Landroid/net/Uri;)V
    .registers 13
    .parameter
    .parameter "callerIdentity"
    .parameter "callerUid"
    .parameter "callerPid"
    .parameter "params"
    .parameter "uri"

    .prologue
    .line 699
    iput-object p1, p0, Landroid/speech/tts/TextToSpeechService$AudioSpeechItem;->this$0:Landroid/speech/tts/TextToSpeechService;

    .line 700
    invoke-direct/range {p0 .. p5}, Landroid/speech/tts/TextToSpeechService$SpeechItem;-><init>(Landroid/speech/tts/TextToSpeechService;Ljava/lang/Object;IILandroid/os/Bundle;)V

    .line 701
    new-instance v0, Landroid/speech/tts/AudioPlaybackQueueItem;

    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$AudioSpeechItem;->getCallerIdentity()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$AudioSpeechItem;->getStreamType()I

    move-result v5

    move-object v1, p0

    move-object v3, p1

    move-object v4, p6

    invoke-direct/range {v0 .. v5}, Landroid/speech/tts/AudioPlaybackQueueItem;-><init>(Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;Ljava/lang/Object;Landroid/content/Context;Landroid/net/Uri;I)V

    iput-object v0, p0, Landroid/speech/tts/TextToSpeechService$AudioSpeechItem;->mItem:Landroid/speech/tts/AudioPlaybackQueueItem;

    .line 703
    return-void
.end method


# virtual methods
.method public isValid()Z
    .registers 2

    .prologue
    .line 707
    const/4 v0, 0x1

    return v0
.end method

.method protected playImpl()I
    .registers 3

    .prologue
    .line 712
    iget-object v0, p0, Landroid/speech/tts/TextToSpeechService$AudioSpeechItem;->this$0:Landroid/speech/tts/TextToSpeechService;

    #getter for: Landroid/speech/tts/TextToSpeechService;->mAudioPlaybackHandler:Landroid/speech/tts/AudioPlaybackHandler;
    invoke-static {v0}, Landroid/speech/tts/TextToSpeechService;->access$200(Landroid/speech/tts/TextToSpeechService;)Landroid/speech/tts/AudioPlaybackHandler;

    move-result-object v0

    iget-object v1, p0, Landroid/speech/tts/TextToSpeechService$AudioSpeechItem;->mItem:Landroid/speech/tts/AudioPlaybackQueueItem;

    invoke-virtual {v0, v1}, Landroid/speech/tts/AudioPlaybackHandler;->enqueue(Landroid/speech/tts/PlaybackQueueItem;)V

    .line 713
    const/4 v0, 0x0

    return v0
.end method

.method protected stopImpl()V
    .registers 1

    .prologue
    .line 719
    return-void
.end method
