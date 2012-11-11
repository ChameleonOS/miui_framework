.class Lmiui/view/VolumePanel$3;
.super Ljava/lang/Object;
.source "VolumePanel.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmiui/view/VolumePanel;->recreateIfNeeded()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lmiui/view/VolumePanel;


# direct methods
.method constructor <init>(Lmiui/view/VolumePanel;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Lmiui/view/VolumePanel$3;->this$0:Lmiui/view/VolumePanel;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .registers 4
    .parameter "dialog"

    .prologue
    iget-object v0, p0, Lmiui/view/VolumePanel$3;->this$0:Lmiui/view/VolumePanel;

    iget v0, v0, Lmiui/view/VolumePanel;->mRestoreRingVolume:I

    if-eqz v0, :cond_16

    iget-object v0, p0, Lmiui/view/VolumePanel$3;->this$0:Lmiui/view/VolumePanel;

    iget-object v0, v0, Lmiui/view/VolumePanel;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lmiui/view/VolumePanel$3;->this$0:Lmiui/view/VolumePanel;

    iget v1, v1, Lmiui/view/VolumePanel;->mRestoreRingVolume:I

    invoke-static {v0, v1}, Lmiui/util/AudioManagerHelper;->saveLastAudibleRingVolume(Landroid/content/Context;I)V

    iget-object v0, p0, Lmiui/view/VolumePanel$3;->this$0:Lmiui/view/VolumePanel;

    const/4 v1, 0x0

    iput v1, v0, Lmiui/view/VolumePanel;->mRestoreRingVolume:I

    :cond_16
    iget-object v0, p0, Lmiui/view/VolumePanel$3;->this$0:Lmiui/view/VolumePanel;

    const/4 v1, -0x1

    #setter for: Lmiui/view/VolumePanel;->mActiveStreamType:I
    invoke-static {v0, v1}, Lmiui/view/VolumePanel;->access$202(Lmiui/view/VolumePanel;I)I

    iget-object v0, p0, Lmiui/view/VolumePanel$3;->this$0:Lmiui/view/VolumePanel;

    #getter for: Lmiui/view/VolumePanel;->mAudioManager:Landroid/media/AudioManager;
    invoke-static {v0}, Lmiui/view/VolumePanel;->access$300(Lmiui/view/VolumePanel;)Landroid/media/AudioManager;

    move-result-object v0

    iget-object v1, p0, Lmiui/view/VolumePanel$3;->this$0:Lmiui/view/VolumePanel;

    #getter for: Lmiui/view/VolumePanel;->mActiveStreamType:I
    invoke-static {v1}, Lmiui/view/VolumePanel;->access$200(Lmiui/view/VolumePanel;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->forceVolumeControlStream(I)V

    return-void
.end method
