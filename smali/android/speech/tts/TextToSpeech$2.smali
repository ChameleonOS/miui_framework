.class Landroid/speech/tts/TextToSpeech$2;
.super Ljava/lang/Object;
.source "TextToSpeech.java"

# interfaces
.implements Landroid/speech/tts/TextToSpeech$Action;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/String;ILjava/util/HashMap;)I
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/speech/tts/TextToSpeech$Action",
        "<",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Landroid/speech/tts/TextToSpeech;

.field final synthetic val$params:Ljava/util/HashMap;

.field final synthetic val$queueMode:I

.field final synthetic val$text:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/speech/tts/TextToSpeech;Ljava/lang/String;ILjava/util/HashMap;)V
    .registers 5
    .parameter
    .parameter
    .parameter
    .parameter

    .prologue
    .line 815
    iput-object p1, p0, Landroid/speech/tts/TextToSpeech$2;->this$0:Landroid/speech/tts/TextToSpeech;

    iput-object p2, p0, Landroid/speech/tts/TextToSpeech$2;->val$text:Ljava/lang/String;

    iput p3, p0, Landroid/speech/tts/TextToSpeech$2;->val$queueMode:I

    iput-object p4, p0, Landroid/speech/tts/TextToSpeech$2;->val$params:Ljava/util/HashMap;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Landroid/speech/tts/ITextToSpeechService;)Ljava/lang/Integer;
    .registers 8
    .parameter "service"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 818
    iget-object v1, p0, Landroid/speech/tts/TextToSpeech$2;->this$0:Landroid/speech/tts/TextToSpeech;

    #getter for: Landroid/speech/tts/TextToSpeech;->mUtterances:Ljava/util/Map;
    invoke-static {v1}, Landroid/speech/tts/TextToSpeech;->access$400(Landroid/speech/tts/TextToSpeech;)Ljava/util/Map;

    move-result-object v1

    iget-object v2, p0, Landroid/speech/tts/TextToSpeech$2;->val$text:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    .line 819
    .local v0, utteranceUri:Landroid/net/Uri;
    if-eqz v0, :cond_29

    .line 820
    iget-object v1, p0, Landroid/speech/tts/TextToSpeech$2;->this$0:Landroid/speech/tts/TextToSpeech;

    #calls: Landroid/speech/tts/TextToSpeech;->getCallerIdentity()Landroid/os/IBinder;
    invoke-static {v1}, Landroid/speech/tts/TextToSpeech;->access$100(Landroid/speech/tts/TextToSpeech;)Landroid/os/IBinder;

    move-result-object v1

    iget v2, p0, Landroid/speech/tts/TextToSpeech$2;->val$queueMode:I

    iget-object v3, p0, Landroid/speech/tts/TextToSpeech$2;->this$0:Landroid/speech/tts/TextToSpeech;

    iget-object v4, p0, Landroid/speech/tts/TextToSpeech$2;->val$params:Ljava/util/HashMap;

    #calls: Landroid/speech/tts/TextToSpeech;->getParams(Ljava/util/HashMap;)Landroid/os/Bundle;
    invoke-static {v3, v4}, Landroid/speech/tts/TextToSpeech;->access$500(Landroid/speech/tts/TextToSpeech;Ljava/util/HashMap;)Landroid/os/Bundle;

    move-result-object v3

    invoke-interface {p1, v1, v0, v2, v3}, Landroid/speech/tts/ITextToSpeechService;->playAudio(Landroid/os/IBinder;Landroid/net/Uri;ILandroid/os/Bundle;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 823
    :goto_28
    return-object v1

    :cond_29
    iget-object v1, p0, Landroid/speech/tts/TextToSpeech$2;->this$0:Landroid/speech/tts/TextToSpeech;

    #calls: Landroid/speech/tts/TextToSpeech;->getCallerIdentity()Landroid/os/IBinder;
    invoke-static {v1}, Landroid/speech/tts/TextToSpeech;->access$100(Landroid/speech/tts/TextToSpeech;)Landroid/os/IBinder;

    move-result-object v1

    iget-object v2, p0, Landroid/speech/tts/TextToSpeech$2;->val$text:Ljava/lang/String;

    iget v3, p0, Landroid/speech/tts/TextToSpeech$2;->val$queueMode:I

    iget-object v4, p0, Landroid/speech/tts/TextToSpeech$2;->this$0:Landroid/speech/tts/TextToSpeech;

    iget-object v5, p0, Landroid/speech/tts/TextToSpeech$2;->val$params:Ljava/util/HashMap;

    #calls: Landroid/speech/tts/TextToSpeech;->getParams(Ljava/util/HashMap;)Landroid/os/Bundle;
    invoke-static {v4, v5}, Landroid/speech/tts/TextToSpeech;->access$500(Landroid/speech/tts/TextToSpeech;Ljava/util/HashMap;)Landroid/os/Bundle;

    move-result-object v4

    invoke-interface {p1, v1, v2, v3, v4}, Landroid/speech/tts/ITextToSpeechService;->speak(Landroid/os/IBinder;Ljava/lang/String;ILandroid/os/Bundle;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_28
.end method

.method public bridge synthetic run(Landroid/speech/tts/ITextToSpeechService;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 815
    invoke-virtual {p0, p1}, Landroid/speech/tts/TextToSpeech$2;->run(Landroid/speech/tts/ITextToSpeechService;)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method
