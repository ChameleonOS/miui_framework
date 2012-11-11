.class abstract Landroid/speech/tts/PlaybackQueueItem;
.super Ljava/lang/Object;
.source "PlaybackQueueItem.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final mCallerIdentity:Ljava/lang/Object;

.field private final mDispatcher:Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;


# direct methods
.method constructor <init>(Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;Ljava/lang/Object;)V
    .registers 3
    .parameter "dispatcher"
    .parameter "callerIdentity"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/speech/tts/PlaybackQueueItem;->mDispatcher:Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;

    iput-object p2, p0, Landroid/speech/tts/PlaybackQueueItem;->mCallerIdentity:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method getCallerIdentity()Ljava/lang/Object;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/speech/tts/PlaybackQueueItem;->mCallerIdentity:Ljava/lang/Object;

    return-object v0
.end method

.method protected getDispatcher()Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/speech/tts/PlaybackQueueItem;->mDispatcher:Landroid/speech/tts/TextToSpeechService$UtteranceProgressDispatcher;

    return-object v0
.end method

.method public abstract run()V
.end method

.method abstract stop(Z)V
.end method
