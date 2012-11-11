.class Landroid/speech/tts/TextToSpeechService$SynthesisToFileSpeechItem;
.super Landroid/speech/tts/TextToSpeechService$SynthesisSpeechItem;
.source "TextToSpeechService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/speech/tts/TextToSpeechService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SynthesisToFileSpeechItem"
.end annotation


# instance fields
.field private final mFile:Ljava/io/File;

.field final synthetic this$0:Landroid/speech/tts/TextToSpeechService;


# direct methods
.method public constructor <init>(Landroid/speech/tts/TextToSpeechService;Ljava/lang/Object;IILandroid/os/Bundle;Ljava/lang/String;Ljava/io/File;)V
    .registers 8
    .parameter
    .parameter "callerIdentity"
    .parameter "callerUid"
    .parameter "callerPid"
    .parameter "params"
    .parameter "text"
    .parameter "file"

    .prologue
    iput-object p1, p0, Landroid/speech/tts/TextToSpeechService$SynthesisToFileSpeechItem;->this$0:Landroid/speech/tts/TextToSpeechService;

    invoke-direct/range {p0 .. p6}, Landroid/speech/tts/TextToSpeechService$SynthesisSpeechItem;-><init>(Landroid/speech/tts/TextToSpeechService;Ljava/lang/Object;IILandroid/os/Bundle;Ljava/lang/String;)V

    iput-object p7, p0, Landroid/speech/tts/TextToSpeechService$SynthesisToFileSpeechItem;->mFile:Ljava/io/File;

    return-void
.end method

.method private checkFile(Ljava/io/File;)Z
    .registers 7
    .parameter "file"

    .prologue
    const/4 v1, 0x0

    :try_start_1
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_44

    const-string v2, "TextToSpeechService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "File "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " exists, deleting."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    move-result v2

    if-nez v2, :cond_44

    const-string v2, "TextToSpeechService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to delete "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :goto_43
    return v1

    :cond_44
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    move-result v2

    if-nez v2, :cond_87

    const-string v2, "TextToSpeechService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Can\'t create file "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_62
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_62} :catch_63

    goto :goto_43

    :catch_63
    move-exception v0

    .local v0, e:Ljava/io/IOException;
    const-string v2, "TextToSpeechService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Can\'t use "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " due to exception "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_43

    .end local v0           #e:Ljava/io/IOException;
    :cond_87
    :try_start_87
    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    move-result v2

    if-nez v2, :cond_a6

    const-string v2, "TextToSpeechService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to delete "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_a5
    .catch Ljava/io/IOException; {:try_start_87 .. :try_end_a5} :catch_63

    goto :goto_43

    :cond_a6
    const/4 v1, 0x1

    goto :goto_43
.end method


# virtual methods
.method protected createSynthesisCallback()Landroid/speech/tts/AbstractSynthesisCallback;
    .registers 3

    .prologue
    new-instance v0, Landroid/speech/tts/FileSynthesisCallback;

    iget-object v1, p0, Landroid/speech/tts/TextToSpeechService$SynthesisToFileSpeechItem;->mFile:Ljava/io/File;

    invoke-direct {v0, v1}, Landroid/speech/tts/FileSynthesisCallback;-><init>(Ljava/io/File;)V

    return-object v0
.end method

.method public isValid()Z
    .registers 2

    .prologue
    invoke-super {p0}, Landroid/speech/tts/TextToSpeechService$SynthesisSpeechItem;->isValid()Z

    move-result v0

    if-nez v0, :cond_8

    const/4 v0, 0x0

    :goto_7
    return v0

    :cond_8
    iget-object v0, p0, Landroid/speech/tts/TextToSpeechService$SynthesisToFileSpeechItem;->mFile:Ljava/io/File;

    invoke-direct {p0, v0}, Landroid/speech/tts/TextToSpeechService$SynthesisToFileSpeechItem;->checkFile(Ljava/io/File;)Z

    move-result v0

    goto :goto_7
.end method

.method protected playImpl()I
    .registers 2

    .prologue
    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$SynthesisToFileSpeechItem;->dispatchOnStart()V

    invoke-super {p0}, Landroid/speech/tts/TextToSpeechService$SynthesisSpeechItem;->playImpl()I

    move-result v0

    .local v0, status:I
    if-nez v0, :cond_d

    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$SynthesisToFileSpeechItem;->dispatchOnDone()V

    :goto_c
    return v0

    :cond_d
    invoke-virtual {p0}, Landroid/speech/tts/TextToSpeechService$SynthesisToFileSpeechItem;->dispatchOnError()V

    goto :goto_c
.end method
