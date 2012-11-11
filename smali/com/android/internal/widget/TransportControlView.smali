.class public Lcom/android/internal/widget/TransportControlView;
.super Landroid/widget/FrameLayout;
.source "TransportControlView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/android/internal/widget/LockScreenWidgetInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/widget/TransportControlView$SavedState;,
        Lcom/android/internal/widget/TransportControlView$Metadata;,
        Lcom/android/internal/widget/TransportControlView$IRemoteControlDisplayWeak;
    }
.end annotation


# static fields
.field protected static final DEBUG:Z = false

.field private static final DISPLAY_TIMEOUT_MS:I = 0x1388

.field private static final MAXDIM:I = 0x200

.field private static final MSG_SET_ARTWORK:I = 0x67

.field private static final MSG_SET_GENERATION_ID:I = 0x68

.field private static final MSG_SET_METADATA:I = 0x65

.field private static final MSG_SET_TRANSPORT_CONTROLS:I = 0x66

.field private static final MSG_UPDATE_STATE:I = 0x64

.field protected static final TAG:Ljava/lang/String; = "TransportControlView"


# instance fields
.field private mAlbumArt:Landroid/widget/ImageView;

.field private mAttached:Z

.field private mAudioManager:Landroid/media/AudioManager;

.field private mBtnNext:Landroid/widget/ImageView;

.field private mBtnPlay:Landroid/widget/ImageView;

.field private mBtnPrev:Landroid/widget/ImageView;

.field private mClientGeneration:I

.field private mClientIntent:Landroid/app/PendingIntent;

.field private mCurrentPlayState:I

.field private mHandler:Landroid/os/Handler;

.field private mIRCD:Lcom/android/internal/widget/TransportControlView$IRemoteControlDisplayWeak;

.field private mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

.field private mPopulateMetadataWhenAttached:Landroid/os/Bundle;

.field private mTrackTitle:Landroid/widget/TextView;

.field private mTransportControlFlags:I

.field private mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 6
    .parameter "context"
    .parameter "attrs"

    .prologue
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    new-instance v0, Lcom/android/internal/widget/TransportControlView$Metadata;

    invoke-direct {v0, p0}, Lcom/android/internal/widget/TransportControlView$Metadata;-><init>(Lcom/android/internal/widget/TransportControlView;)V

    iput-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mPopulateMetadataWhenAttached:Landroid/os/Bundle;

    new-instance v0, Lcom/android/internal/widget/TransportControlView$1;

    invoke-direct {v0, p0}, Lcom/android/internal/widget/TransportControlView$1;-><init>(Lcom/android/internal/widget/TransportControlView;)V

    iput-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mHandler:Landroid/os/Handler;

    const-string v0, "TransportControlView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Create TCV "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    new-instance v0, Landroid/media/AudioManager;

    iget-object v1, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/media/AudioManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mAudioManager:Landroid/media/AudioManager;

    const/4 v0, 0x0

    iput v0, p0, Lcom/android/internal/widget/TransportControlView;->mCurrentPlayState:I

    new-instance v0, Lcom/android/internal/widget/TransportControlView$IRemoteControlDisplayWeak;

    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView;->mHandler:Landroid/os/Handler;

    invoke-direct {v0, v1}, Lcom/android/internal/widget/TransportControlView$IRemoteControlDisplayWeak;-><init>(Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mIRCD:Lcom/android/internal/widget/TransportControlView$IRemoteControlDisplayWeak;

    return-void
.end method

.method static synthetic access$000(Lcom/android/internal/widget/TransportControlView;)I
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Lcom/android/internal/widget/TransportControlView;->mClientGeneration:I

    return v0
.end method

.method static synthetic access$002(Lcom/android/internal/widget/TransportControlView;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput p1, p0, Lcom/android/internal/widget/TransportControlView;->mClientGeneration:I

    return p1
.end method

.method static synthetic access$100(Lcom/android/internal/widget/TransportControlView;I)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/widget/TransportControlView;->updatePlayPauseState(I)V

    return-void
.end method

.method static synthetic access$200(Lcom/android/internal/widget/TransportControlView;Landroid/os/Bundle;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/widget/TransportControlView;->updateMetadata(Landroid/os/Bundle;)V

    return-void
.end method

.method static synthetic access$300(Lcom/android/internal/widget/TransportControlView;I)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Lcom/android/internal/widget/TransportControlView;->updateTransportControls(I)V

    return-void
.end method

.method static synthetic access$400(Lcom/android/internal/widget/TransportControlView;)Lcom/android/internal/widget/TransportControlView$Metadata;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    return-object v0
.end method

.method static synthetic access$600(Lcom/android/internal/widget/TransportControlView;)Landroid/widget/ImageView;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mAlbumArt:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$700(Lcom/android/internal/widget/TransportControlView;)Lcom/android/internal/widget/LockScreenWidgetCallback;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;

    return-object v0
.end method

.method static synthetic access$802(Lcom/android/internal/widget/TransportControlView;Landroid/app/PendingIntent;)Landroid/app/PendingIntent;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Lcom/android/internal/widget/TransportControlView;->mClientIntent:Landroid/app/PendingIntent;

    return-object p1
.end method

.method private getMdString(Landroid/os/Bundle;I)Ljava/lang/String;
    .registers 4
    .parameter "data"
    .parameter "id"

    .prologue
    invoke-static {p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private populateMetadata()V
    .registers 9

    .prologue
    const/16 v7, 0x21

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .local v1, sb:Ljava/lang/StringBuilder;
    const/4 v3, 0x0

    .local v3, trackTitleLength:I
    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    #getter for: Lcom/android/internal/widget/TransportControlView$Metadata;->trackTitle:Ljava/lang/String;
    invoke-static {v4}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$1000(Lcom/android/internal/widget/TransportControlView$Metadata;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_27

    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    #getter for: Lcom/android/internal/widget/TransportControlView$Metadata;->trackTitle:Ljava/lang/String;
    invoke-static {v4}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$1000(Lcom/android/internal/widget/TransportControlView$Metadata;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    #getter for: Lcom/android/internal/widget/TransportControlView$Metadata;->trackTitle:Ljava/lang/String;
    invoke-static {v4}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$1000(Lcom/android/internal/widget/TransportControlView$Metadata;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v3

    :cond_27
    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    #getter for: Lcom/android/internal/widget/TransportControlView$Metadata;->artist:Ljava/lang/String;
    invoke-static {v4}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$900(Lcom/android/internal/widget/TransportControlView$Metadata;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_47

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    if-eqz v4, :cond_3e

    const-string v4, " - "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_3e
    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    #getter for: Lcom/android/internal/widget/TransportControlView$Metadata;->artist:Ljava/lang/String;
    invoke-static {v4}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$900(Lcom/android/internal/widget/TransportControlView$Metadata;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_47
    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    #getter for: Lcom/android/internal/widget/TransportControlView$Metadata;->albumTitle:Ljava/lang/String;
    invoke-static {v4}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$1100(Lcom/android/internal/widget/TransportControlView$Metadata;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_67

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    if-eqz v4, :cond_5e

    const-string v4, " - "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_5e
    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    #getter for: Lcom/android/internal/widget/TransportControlView$Metadata;->albumTitle:Ljava/lang/String;
    invoke-static {v4}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$1100(Lcom/android/internal/widget/TransportControlView$Metadata;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_67
    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mTrackTitle:Landroid/widget/TextView;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    sget-object v6, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {v4, v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mTrackTitle:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    check-cast v2, Landroid/text/Spannable;

    .local v2, str:Landroid/text/Spannable;
    if-eqz v3, :cond_88

    new-instance v4, Landroid/text/style/ForegroundColorSpan;

    const/4 v5, -0x1

    invoke-direct {v4, v5}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    const/4 v5, 0x0

    invoke-interface {v2, v4, v5, v3, v7}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    add-int/lit8 v3, v3, 0x1

    :cond_88
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    if-le v4, v3, :cond_9d

    new-instance v4, Landroid/text/style/ForegroundColorSpan;

    const v5, 0x7fffffff

    invoke-direct {v4, v5}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v5

    invoke-interface {v2, v4, v3, v5, v7}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    :cond_9d
    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mAlbumArt:Landroid/widget/ImageView;

    iget-object v5, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    #getter for: Lcom/android/internal/widget/TransportControlView$Metadata;->bitmap:Landroid/graphics/Bitmap;
    invoke-static {v5}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$500(Lcom/android/internal/widget/TransportControlView$Metadata;)Landroid/graphics/Bitmap;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    iget v0, p0, Lcom/android/internal/widget/TransportControlView;->mTransportControlFlags:I

    .local v0, flags:I
    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mBtnPrev:Landroid/widget/ImageView;

    const/4 v5, 0x1

    invoke-static {v4, v0, v5}, Lcom/android/internal/widget/TransportControlView;->setVisibilityBasedOnFlag(Landroid/view/View;II)V

    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mBtnNext:Landroid/widget/ImageView;

    const/16 v5, 0x80

    invoke-static {v4, v0, v5}, Lcom/android/internal/widget/TransportControlView;->setVisibilityBasedOnFlag(Landroid/view/View;II)V

    iget-object v4, p0, Lcom/android/internal/widget/TransportControlView;->mBtnPlay:Landroid/widget/ImageView;

    const/16 v5, 0x3c

    invoke-static {v4, v0, v5}, Lcom/android/internal/widget/TransportControlView;->setVisibilityBasedOnFlag(Landroid/view/View;II)V

    iget v4, p0, Lcom/android/internal/widget/TransportControlView;->mCurrentPlayState:I

    invoke-direct {p0, v4}, Lcom/android/internal/widget/TransportControlView;->updatePlayPauseState(I)V

    return-void
.end method

.method private sendMediaButtonClick(I)V
    .registers 8
    .parameter "keyCode"

    .prologue
    const/4 v4, 0x0

    iget-object v3, p0, Lcom/android/internal/widget/TransportControlView;->mClientIntent:Landroid/app/PendingIntent;

    if-nez v3, :cond_e

    const-string v3, "TransportControlView"

    const-string/jumbo v4, "sendMediaButtonClick(): No client is currently registered"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :goto_d
    return-void

    :cond_e
    new-instance v2, Landroid/view/KeyEvent;

    invoke-direct {v2, v4, p1}, Landroid/view/KeyEvent;-><init>(II)V

    .local v2, keyEvent:Landroid/view/KeyEvent;
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.intent.action.MEDIA_BUTTON"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .local v1, intent:Landroid/content/Intent;
    const-string v3, "android.intent.extra.KEY_EVENT"

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    :try_start_1f
    iget-object v3, p0, Lcom/android/internal/widget/TransportControlView;->mClientIntent:Landroid/app/PendingIntent;

    invoke-virtual {p0}, Lcom/android/internal/widget/TransportControlView;->getContext()Landroid/content/Context;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5, v1}, Landroid/app/PendingIntent;->send(Landroid/content/Context;ILandroid/content/Intent;)V
    :try_end_29
    .catch Landroid/app/PendingIntent$CanceledException; {:try_start_1f .. :try_end_29} :catch_63

    :goto_29
    new-instance v2, Landroid/view/KeyEvent;

    .end local v2           #keyEvent:Landroid/view/KeyEvent;
    const/4 v3, 0x1

    invoke-direct {v2, v3, p1}, Landroid/view/KeyEvent;-><init>(II)V

    .restart local v2       #keyEvent:Landroid/view/KeyEvent;
    new-instance v1, Landroid/content/Intent;

    .end local v1           #intent:Landroid/content/Intent;
    const-string v3, "android.intent.action.MEDIA_BUTTON"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .restart local v1       #intent:Landroid/content/Intent;
    const-string v3, "android.intent.extra.KEY_EVENT"

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    :try_start_3b
    iget-object v3, p0, Lcom/android/internal/widget/TransportControlView;->mClientIntent:Landroid/app/PendingIntent;

    invoke-virtual {p0}, Lcom/android/internal/widget/TransportControlView;->getContext()Landroid/content/Context;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5, v1}, Landroid/app/PendingIntent;->send(Landroid/content/Context;ILandroid/content/Intent;)V
    :try_end_45
    .catch Landroid/app/PendingIntent$CanceledException; {:try_start_3b .. :try_end_45} :catch_46

    goto :goto_d

    :catch_46
    move-exception v0

    .local v0, e:Landroid/app/PendingIntent$CanceledException;
    const-string v3, "TransportControlView"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Error sending intent for media button up: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {v0}, Landroid/app/PendingIntent$CanceledException;->printStackTrace()V

    goto :goto_d

    .end local v0           #e:Landroid/app/PendingIntent$CanceledException;
    :catch_63
    move-exception v0

    .restart local v0       #e:Landroid/app/PendingIntent$CanceledException;
    const-string v3, "TransportControlView"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Error sending intent for media button down: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {v0}, Landroid/app/PendingIntent$CanceledException;->printStackTrace()V

    goto :goto_29
.end method

.method private static setVisibilityBasedOnFlag(Landroid/view/View;II)V
    .registers 4
    .parameter "view"
    .parameter "flags"
    .parameter "flag"

    .prologue
    and-int v0, p1, p2

    if-eqz v0, :cond_9

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V

    :goto_8
    return-void

    :cond_9
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroid/view/View;->setVisibility(I)V

    goto :goto_8
.end method

.method private updateMetadata(Landroid/os/Bundle;)V
    .registers 4
    .parameter "data"

    .prologue
    iget-boolean v0, p0, Lcom/android/internal/widget/TransportControlView;->mAttached:Z

    if-eqz v0, :cond_27

    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    const/16 v1, 0xd

    invoke-direct {p0, p1, v1}, Lcom/android/internal/widget/TransportControlView;->getMdString(Landroid/os/Bundle;I)Ljava/lang/String;

    move-result-object v1

    #setter for: Lcom/android/internal/widget/TransportControlView$Metadata;->artist:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$902(Lcom/android/internal/widget/TransportControlView$Metadata;Ljava/lang/String;)Ljava/lang/String;

    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    const/4 v1, 0x7

    invoke-direct {p0, p1, v1}, Lcom/android/internal/widget/TransportControlView;->getMdString(Landroid/os/Bundle;I)Ljava/lang/String;

    move-result-object v1

    #setter for: Lcom/android/internal/widget/TransportControlView$Metadata;->trackTitle:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$1002(Lcom/android/internal/widget/TransportControlView$Metadata;Ljava/lang/String;)Ljava/lang/String;

    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mMetadata:Lcom/android/internal/widget/TransportControlView$Metadata;

    const/4 v1, 0x1

    invoke-direct {p0, p1, v1}, Lcom/android/internal/widget/TransportControlView;->getMdString(Landroid/os/Bundle;I)Ljava/lang/String;

    move-result-object v1

    #setter for: Lcom/android/internal/widget/TransportControlView$Metadata;->albumTitle:Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/android/internal/widget/TransportControlView$Metadata;->access$1102(Lcom/android/internal/widget/TransportControlView$Metadata;Ljava/lang/String;)Ljava/lang/String;

    invoke-direct {p0}, Lcom/android/internal/widget/TransportControlView;->populateMetadata()V

    :goto_26
    return-void

    :cond_27
    iput-object p1, p0, Lcom/android/internal/widget/TransportControlView;->mPopulateMetadataWhenAttached:Landroid/os/Bundle;

    goto :goto_26
.end method

.method private updatePlayPauseState(I)V
    .registers 7
    .parameter "state"

    .prologue
    iget v3, p0, Lcom/android/internal/widget/TransportControlView;->mCurrentPlayState:I

    if-ne p1, v3, :cond_5

    :goto_4
    return-void

    :cond_5
    const/4 v2, 0x0

    .local v2, showIfHidden:Z
    sparse-switch p1, :sswitch_data_50

    const v1, 0x1080024

    .local v1, imageResId:I
    const v0, 0x104030e

    .local v0, imageDescId:I
    const/4 v2, 0x0

    :goto_10
    iget-object v3, p0, Lcom/android/internal/widget/TransportControlView;->mBtnPlay:Landroid/widget/ImageView;

    invoke-virtual {v3, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    iget-object v3, p0, Lcom/android/internal/widget/TransportControlView;->mBtnPlay:Landroid/widget/ImageView;

    invoke-virtual {p0}, Lcom/android/internal/widget/TransportControlView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    if-eqz v2, :cond_35

    iget-object v3, p0, Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;

    if-eqz v3, :cond_35

    iget-object v3, p0, Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;

    invoke-interface {v3, p0}, Lcom/android/internal/widget/LockScreenWidgetCallback;->isVisible(Landroid/view/View;)Z

    move-result v3

    if-nez v3, :cond_35

    iget-object v3, p0, Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;

    invoke-interface {v3, p0}, Lcom/android/internal/widget/LockScreenWidgetCallback;->requestShow(Landroid/view/View;)V

    :cond_35
    iput p1, p0, Lcom/android/internal/widget/TransportControlView;->mCurrentPlayState:I

    goto :goto_4

    .end local v0           #imageDescId:I
    .end local v1           #imageResId:I
    :sswitch_38
    const v1, 0x108008a

    .restart local v1       #imageResId:I
    const v0, 0x104030e

    .restart local v0       #imageDescId:I
    goto :goto_10

    .end local v0           #imageDescId:I
    .end local v1           #imageResId:I
    :sswitch_3f
    const v1, 0x1080023

    .restart local v1       #imageResId:I
    const v0, 0x104030d

    .restart local v0       #imageDescId:I
    const/4 v2, 0x1

    goto :goto_10

    .end local v0           #imageDescId:I
    .end local v1           #imageResId:I
    :sswitch_47
    const v1, 0x1080317

    .restart local v1       #imageResId:I
    const v0, 0x104030f

    .restart local v0       #imageDescId:I
    const/4 v2, 0x1

    goto :goto_10

    nop

    :sswitch_data_50
    .sparse-switch
        0x3 -> :sswitch_3f
        0x8 -> :sswitch_47
        0x9 -> :sswitch_38
    .end sparse-switch
.end method

.method private updateTransportControls(I)V
    .registers 2
    .parameter "transportControlFlags"

    .prologue
    iput p1, p0, Lcom/android/internal/widget/TransportControlView;->mTransportControlFlags:I

    return-void
.end method

.method private wasPlayingRecently(IJ)Z
    .registers 10
    .parameter "state"
    .parameter "stateChangeTimeMs"

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    packed-switch p1, :pswitch_data_34

    const-string v0, "TransportControlView"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unknown playback state "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " in wasPlayingRecently()"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v1

    :cond_24
    :goto_24
    :pswitch_24
    return v0

    :pswitch_25
    move v0, v1

    goto :goto_24

    :pswitch_27
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    sub-long/2addr v2, p2

    const-wide/16 v4, 0x1388

    cmp-long v2, v2, v4

    if-ltz v2, :cond_24

    move v0, v1

    goto :goto_24

    :pswitch_data_34
    .packed-switch 0x0
        :pswitch_25
        :pswitch_27
        :pswitch_27
        :pswitch_24
        :pswitch_24
        :pswitch_24
        :pswitch_24
        :pswitch_24
        :pswitch_24
        :pswitch_27
    .end packed-switch
.end method


# virtual methods
.method public onAttachedToWindow()V
    .registers 3

    .prologue
    invoke-super {p0}, Landroid/widget/FrameLayout;->onAttachedToWindow()V

    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mPopulateMetadataWhenAttached:Landroid/os/Bundle;

    if-eqz v0, :cond_f

    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mPopulateMetadataWhenAttached:Landroid/os/Bundle;

    invoke-direct {p0, v0}, Lcom/android/internal/widget/TransportControlView;->updateMetadata(Landroid/os/Bundle;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mPopulateMetadataWhenAttached:Landroid/os/Bundle;

    :cond_f
    iget-boolean v0, p0, Lcom/android/internal/widget/TransportControlView;->mAttached:Z

    if-nez v0, :cond_1a

    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mAudioManager:Landroid/media/AudioManager;

    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView;->mIRCD:Lcom/android/internal/widget/TransportControlView$IRemoteControlDisplayWeak;

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->registerRemoteControlDisplay(Landroid/media/IRemoteControlDisplay;)V

    :cond_1a
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/internal/widget/TransportControlView;->mAttached:Z

    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .registers 4
    .parameter "v"

    .prologue
    const/4 v0, -0x1

    .local v0, keyCode:I
    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView;->mBtnPrev:Landroid/widget/ImageView;

    if-ne p1, v1, :cond_17

    const/16 v0, 0x58

    :cond_7
    :goto_7
    const/4 v1, -0x1

    if-eq v0, v1, :cond_16

    invoke-direct {p0, v0}, Lcom/android/internal/widget/TransportControlView;->sendMediaButtonClick(I)V

    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;

    if-eqz v1, :cond_16

    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;

    invoke-interface {v1, p0}, Lcom/android/internal/widget/LockScreenWidgetCallback;->userActivity(Landroid/view/View;)V

    :cond_16
    return-void

    :cond_17
    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView;->mBtnNext:Landroid/widget/ImageView;

    if-ne p1, v1, :cond_1e

    const/16 v0, 0x57

    goto :goto_7

    :cond_1e
    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView;->mBtnPlay:Landroid/widget/ImageView;

    if-ne p1, v1, :cond_7

    const/16 v0, 0x55

    goto :goto_7
.end method

.method public onDetachedFromWindow()V
    .registers 3

    .prologue
    invoke-super {p0}, Landroid/widget/FrameLayout;->onDetachedFromWindow()V

    iget-boolean v0, p0, Lcom/android/internal/widget/TransportControlView;->mAttached:Z

    if-eqz v0, :cond_e

    iget-object v0, p0, Lcom/android/internal/widget/TransportControlView;->mAudioManager:Landroid/media/AudioManager;

    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView;->mIRCD:Lcom/android/internal/widget/TransportControlView$IRemoteControlDisplayWeak;

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->unregisterRemoteControlDisplay(Landroid/media/IRemoteControlDisplay;)V

    :cond_e
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/internal/widget/TransportControlView;->mAttached:Z

    return-void
.end method

.method public onFinishInflate()V
    .registers 9

    .prologue
    const/4 v7, 0x1

    invoke-super {p0}, Landroid/widget/FrameLayout;->onFinishInflate()V

    const v5, 0x1020016

    invoke-virtual {p0, v5}, Lcom/android/internal/widget/TransportControlView;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, p0, Lcom/android/internal/widget/TransportControlView;->mTrackTitle:Landroid/widget/TextView;

    iget-object v5, p0, Lcom/android/internal/widget/TransportControlView;->mTrackTitle:Landroid/widget/TextView;

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setSelected(Z)V

    const v5, 0x10202c7

    invoke-virtual {p0, v5}, Lcom/android/internal/widget/TransportControlView;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, p0, Lcom/android/internal/widget/TransportControlView;->mAlbumArt:Landroid/widget/ImageView;

    const v5, 0x10202c8

    invoke-virtual {p0, v5}, Lcom/android/internal/widget/TransportControlView;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, p0, Lcom/android/internal/widget/TransportControlView;->mBtnPrev:Landroid/widget/ImageView;

    const v5, 0x10202c9

    invoke-virtual {p0, v5}, Lcom/android/internal/widget/TransportControlView;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, p0, Lcom/android/internal/widget/TransportControlView;->mBtnPlay:Landroid/widget/ImageView;

    const v5, 0x10202ca

    invoke-virtual {p0, v5}, Lcom/android/internal/widget/TransportControlView;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, p0, Lcom/android/internal/widget/TransportControlView;->mBtnNext:Landroid/widget/ImageView;

    const/4 v5, 0x3

    new-array v1, v5, [Landroid/view/View;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/android/internal/widget/TransportControlView;->mBtnPrev:Landroid/widget/ImageView;

    aput-object v6, v1, v5

    iget-object v5, p0, Lcom/android/internal/widget/TransportControlView;->mBtnPlay:Landroid/widget/ImageView;

    aput-object v5, v1, v7

    const/4 v5, 0x2

    iget-object v6, p0, Lcom/android/internal/widget/TransportControlView;->mBtnNext:Landroid/widget/ImageView;

    aput-object v6, v1, v5

    .local v1, buttons:[Landroid/view/View;
    move-object v0, v1

    .local v0, arr$:[Landroid/view/View;
    array-length v3, v0

    .local v3, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_54
    if-ge v2, v3, :cond_5e

    aget-object v4, v0, v2

    .local v4, view:Landroid/view/View;
    invoke-virtual {v4, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_54

    .end local v4           #view:Landroid/view/View;
    :cond_5e
    return-void
.end method

.method protected onMeasure(II)V
    .registers 7
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->onMeasure(II)V

    const/16 v1, 0x200

    invoke-virtual {p0}, Lcom/android/internal/widget/TransportControlView;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/android/internal/widget/TransportControlView;->getHeight()I

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v0

    .local v0, dim:I
    return-void
.end method

.method public onRestoreInstanceState(Landroid/os/Parcelable;)V
    .registers 4
    .parameter "state"

    .prologue
    instance-of v1, p1, Lcom/android/internal/widget/TransportControlView$SavedState;

    if-nez v1, :cond_8

    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    :cond_7
    :goto_7
    return-void

    :cond_8
    move-object v0, p1

    check-cast v0, Lcom/android/internal/widget/TransportControlView$SavedState;

    .local v0, ss:Lcom/android/internal/widget/TransportControlView$SavedState;
    invoke-virtual {v0}, Lcom/android/internal/widget/TransportControlView$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-super {p0, v1}, Landroid/widget/FrameLayout;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    iget-boolean v1, v0, Lcom/android/internal/widget/TransportControlView$SavedState;->wasShowing:Z

    if-eqz v1, :cond_7

    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;

    if-eqz v1, :cond_7

    iget-object v1, p0, Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;

    invoke-interface {v1, p0}, Lcom/android/internal/widget/LockScreenWidgetCallback;->requestShow(Landroid/view/View;)V

    goto :goto_7
.end method

.method public onSaveInstanceState()Landroid/os/Parcelable;
    .registers 4

    .prologue
    invoke-super {p0}, Landroid/widget/FrameLayout;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    .local v1, superState:Landroid/os/Parcelable;
    new-instance v0, Lcom/android/internal/widget/TransportControlView$SavedState;

    invoke-direct {v0, v1}, Lcom/android/internal/widget/TransportControlView$SavedState;-><init>(Landroid/os/Parcelable;)V

    .local v0, ss:Lcom/android/internal/widget/TransportControlView$SavedState;
    iget-object v2, p0, Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;

    if-eqz v2, :cond_19

    iget-object v2, p0, Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;

    invoke-interface {v2, p0}, Lcom/android/internal/widget/LockScreenWidgetCallback;->isVisible(Landroid/view/View;)Z

    move-result v2

    if-eqz v2, :cond_19

    const/4 v2, 0x1

    :goto_16
    iput-boolean v2, v0, Lcom/android/internal/widget/TransportControlView$SavedState;->wasShowing:Z

    return-object v0

    :cond_19
    const/4 v2, 0x0

    goto :goto_16
.end method

.method public providesClock()Z
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public setCallback(Lcom/android/internal/widget/LockScreenWidgetCallback;)V
    .registers 2
    .parameter "callback"

    .prologue
    iput-object p1, p0, Lcom/android/internal/widget/TransportControlView;->mWidgetCallbacks:Lcom/android/internal/widget/LockScreenWidgetCallback;

    return-void
.end method
