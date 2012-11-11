.class Lcom/android/internal/telephony/cat/PlayToneParams;
.super Lcom/android/internal/telephony/cat/CommandParams;
.source "CommandParams.java"


# instance fields
.field settings:Lcom/android/internal/telephony/cat/ToneSettings;

.field textMsg:Lcom/android/internal/telephony/cat/TextMessage;


# direct methods
.method constructor <init>(Lcom/android/internal/telephony/cat/CommandDetails;Lcom/android/internal/telephony/cat/TextMessage;Lcom/android/internal/telephony/cat/Tone;Lcom/android/internal/telephony/cat/Duration;Z)V
    .registers 7
    .parameter "cmdDet"
    .parameter "textMsg"
    .parameter "tone"
    .parameter "duration"
    .parameter "vibrate"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/telephony/cat/CommandParams;-><init>(Lcom/android/internal/telephony/cat/CommandDetails;)V

    iput-object p2, p0, Lcom/android/internal/telephony/cat/PlayToneParams;->textMsg:Lcom/android/internal/telephony/cat/TextMessage;

    new-instance v0, Lcom/android/internal/telephony/cat/ToneSettings;

    invoke-direct {v0, p4, p3, p5}, Lcom/android/internal/telephony/cat/ToneSettings;-><init>(Lcom/android/internal/telephony/cat/Duration;Lcom/android/internal/telephony/cat/Tone;Z)V

    iput-object v0, p0, Lcom/android/internal/telephony/cat/PlayToneParams;->settings:Lcom/android/internal/telephony/cat/ToneSettings;

    return-void
.end method


# virtual methods
.method setIcon(Landroid/graphics/Bitmap;)Z
    .registers 3
    .parameter "icon"

    .prologue
    if-eqz p1, :cond_c

    iget-object v0, p0, Lcom/android/internal/telephony/cat/PlayToneParams;->textMsg:Lcom/android/internal/telephony/cat/TextMessage;

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/android/internal/telephony/cat/PlayToneParams;->textMsg:Lcom/android/internal/telephony/cat/TextMessage;

    iput-object p1, v0, Lcom/android/internal/telephony/cat/TextMessage;->icon:Landroid/graphics/Bitmap;

    const/4 v0, 0x1

    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method
