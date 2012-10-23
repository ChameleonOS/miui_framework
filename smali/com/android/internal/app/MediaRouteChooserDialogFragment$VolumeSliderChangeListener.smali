.class Lcom/android/internal/app/MediaRouteChooserDialogFragment$VolumeSliderChangeListener;
.super Ljava/lang/Object;
.source "MediaRouteChooserDialogFragment.java"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/app/MediaRouteChooserDialogFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "VolumeSliderChangeListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;


# direct methods
.method constructor <init>(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)V
    .registers 2
    .parameter

    .prologue
    .line 665
    iput-object p1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$VolumeSliderChangeListener;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgressChanged(Landroid/widget/SeekBar;IZ)V
    .registers 5
    .parameter "seekBar"
    .parameter "progress"
    .parameter "fromUser"

    .prologue
    .line 669
    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$VolumeSliderChangeListener;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    invoke-virtual {v0, p2}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->changeVolume(I)V

    .line 670
    return-void
.end method

.method public onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .registers 4
    .parameter "seekBar"

    .prologue
    .line 674
    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$VolumeSliderChangeListener;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    const/4 v1, 0x1

    #setter for: Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mIgnoreCallbackVolumeChanges:Z
    invoke-static {v0, v1}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->access$802(Lcom/android/internal/app/MediaRouteChooserDialogFragment;Z)Z

    .line 675
    return-void
.end method

.method public onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .registers 4
    .parameter "seekBar"

    .prologue
    .line 679
    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$VolumeSliderChangeListener;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    const/4 v1, 0x0

    #setter for: Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mIgnoreCallbackVolumeChanges:Z
    invoke-static {v0, v1}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->access$802(Lcom/android/internal/app/MediaRouteChooserDialogFragment;Z)Z

    .line 680
    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$VolumeSliderChangeListener;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    invoke-virtual {v0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->updateVolume()V

    .line 681
    return-void
.end method
