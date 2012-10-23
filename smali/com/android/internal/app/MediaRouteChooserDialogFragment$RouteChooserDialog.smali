.class Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;
.super Landroid/app/Dialog;
.source "MediaRouteChooserDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/app/MediaRouteChooserDialogFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "RouteChooserDialog"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;


# direct methods
.method public constructor <init>(Lcom/android/internal/app/MediaRouteChooserDialogFragment;Landroid/content/Context;I)V
    .registers 4
    .parameter
    .parameter "context"
    .parameter "theme"

    .prologue
    .line 622
    iput-object p1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    .line 623
    invoke-direct {p0, p2, p3}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 624
    return-void
.end method


# virtual methods
.method public onBackPressed()V
    .registers 2

    .prologue
    .line 628
    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    #getter for: Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mAdapter:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;
    invoke-static {v0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->access$700(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;

    move-result-object v0

    if-eqz v0, :cond_1e

    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    #getter for: Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mAdapter:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;
    invoke-static {v0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->access$700(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;->isGrouping()Z

    move-result v0

    if-eqz v0, :cond_1e

    .line 629
    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    #getter for: Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mAdapter:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;
    invoke-static {v0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->access$700(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;->finishGrouping()V

    .line 633
    :goto_1d
    return-void

    .line 631
    :cond_1e
    invoke-super {p0}, Landroid/app/Dialog;->onBackPressed()V

    goto :goto_1d
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .registers 6
    .parameter "keyCode"
    .parameter "event"

    .prologue
    const/4 v0, 0x1

    .line 636
    const/16 v1, 0x19

    if-ne p1, v1, :cond_24

    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    #getter for: Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;
    invoke-static {v1}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->access$900(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Landroid/widget/SeekBar;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/SeekBar;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_24

    .line 637
    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    iget-object v1, v1, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouter:Landroid/media/MediaRouter;

    iget-object v2, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    #getter for: Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouteTypes:I
    invoke-static {v2}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->access$000(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/media/MediaRouter;->getSelectedRoute(I)Landroid/media/MediaRouter$RouteInfo;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Landroid/media/MediaRouter$RouteInfo;->requestUpdateVolume(I)V

    .line 643
    :goto_23
    return v0

    .line 639
    :cond_24
    const/16 v1, 0x18

    if-ne p1, v1, :cond_46

    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    #getter for: Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;
    invoke-static {v1}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->access$900(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Landroid/widget/SeekBar;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/SeekBar;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_46

    .line 640
    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    iget-object v1, v1, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouter:Landroid/media/MediaRouter;

    iget-object v2, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    #getter for: Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouteTypes:I
    invoke-static {v2}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->access$000(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/media/MediaRouter;->getSelectedRoute(I)Landroid/media/MediaRouter$RouteInfo;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/media/MediaRouter$RouteInfo;->requestUpdateVolume(I)V

    goto :goto_23

    .line 643
    :cond_46
    invoke-super {p0, p1, p2}, Landroid/app/Dialog;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_23
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .registers 5
    .parameter "keyCode"
    .parameter "event"

    .prologue
    const/4 v0, 0x1

    .line 648
    const/16 v1, 0x19

    if-ne p1, v1, :cond_12

    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    #getter for: Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;
    invoke-static {v1}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->access$900(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Landroid/widget/SeekBar;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/SeekBar;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_12

    .line 653
    :cond_11
    :goto_11
    return v0

    .line 650
    :cond_12
    const/16 v1, 0x18

    if-ne p1, v1, :cond_22

    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;->this$0:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    #getter for: Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;
    invoke-static {v1}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->access$900(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Landroid/widget/SeekBar;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/SeekBar;->isEnabled()Z

    move-result v1

    if-nez v1, :cond_11

    .line 653
    :cond_22
    invoke-super {p0, p1, p2}, Landroid/app/Dialog;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_11
.end method
