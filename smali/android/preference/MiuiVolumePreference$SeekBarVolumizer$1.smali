.class Landroid/preference/MiuiVolumePreference$SeekBarVolumizer$1;
.super Landroid/database/ContentObserver;
.source "MiuiVolumePreference.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;


# direct methods
.method constructor <init>(Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;Landroid/os/Handler;)V
    .registers 3
    .parameter
    .parameter "x0"

    .prologue
    .line 237
    iput-object p1, p0, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer$1;->this$1:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    invoke-direct {p0, p2}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    return-void
.end method


# virtual methods
.method public onChange(Z)V
    .registers 5
    .parameter "selfChange"

    .prologue
    .line 240
    invoke-super {p0, p1}, Landroid/database/ContentObserver;->onChange(Z)V

    .line 241
    iget-object v1, p0, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer$1;->this$1:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    #getter for: Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->mSeekBar:Landroid/widget/SeekBar;
    invoke-static {v1}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->access$000(Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;)Landroid/widget/SeekBar;

    move-result-object v1

    if-eqz v1, :cond_3e

    iget-object v1, p0, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer$1;->this$1:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    #getter for: Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->mAudioManager:Landroid/media/AudioManager;
    invoke-static {v1}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->access$100(Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;)Landroid/media/AudioManager;

    move-result-object v1

    if-eqz v1, :cond_3e

    .line 242
    iget-object v1, p0, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer$1;->this$1:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    #getter for: Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->mAudioManager:Landroid/media/AudioManager;
    invoke-static {v1}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->access$100(Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;)Landroid/media/AudioManager;

    move-result-object v1

    iget-object v2, p0, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer$1;->this$1:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    #getter for: Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->mStreamType:I
    invoke-static {v2}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->access$200(Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/media/AudioManager;->isStreamMute(I)Z

    move-result v1

    if-eqz v1, :cond_3f

    iget-object v1, p0, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer$1;->this$1:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    #getter for: Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->mAudioManager:Landroid/media/AudioManager;
    invoke-static {v1}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->access$100(Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;)Landroid/media/AudioManager;

    move-result-object v1

    iget-object v2, p0, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer$1;->this$1:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    #getter for: Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->mStreamType:I
    invoke-static {v2}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->access$200(Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/media/AudioManager;->getLastAudibleStreamVolume(I)I

    move-result v0

    .line 245
    .local v0, volume:I
    :goto_35
    iget-object v1, p0, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer$1;->this$1:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    #getter for: Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->mSeekBar:Landroid/widget/SeekBar;
    invoke-static {v1}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->access$000(Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;)Landroid/widget/SeekBar;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/widget/SeekBar;->setProgress(I)V

    .line 247
    .end local v0           #volume:I
    :cond_3e
    return-void

    .line 242
    :cond_3f
    iget-object v1, p0, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer$1;->this$1:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    #getter for: Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->mAudioManager:Landroid/media/AudioManager;
    invoke-static {v1}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->access$100(Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;)Landroid/media/AudioManager;

    move-result-object v1

    iget-object v2, p0, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer$1;->this$1:Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;

    #getter for: Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->mStreamType:I
    invoke-static {v2}, Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;->access$200(Landroid/preference/MiuiVolumePreference$SeekBarVolumizer;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v0

    goto :goto_35
.end method
