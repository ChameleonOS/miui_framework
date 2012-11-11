.class public Lcom/android/internal/app/MediaRouteChooserDialogFragment;
.super Landroid/app/DialogFragment;
.source "MediaRouteChooserDialogFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/app/MediaRouteChooserDialogFragment$1;,
        Lcom/android/internal/app/MediaRouteChooserDialogFragment$VolumeSliderChangeListener;,
        Lcom/android/internal/app/MediaRouteChooserDialogFragment$LauncherListener;,
        Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;,
        Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteComparator;,
        Lcom/android/internal/app/MediaRouteChooserDialogFragment$MediaRouterCallback;,
        Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;,
        Lcom/android/internal/app/MediaRouteChooserDialogFragment$ViewHolder;
    }
.end annotation


# static fields
.field public static final FRAGMENT_TAG:Ljava/lang/String; = "android:MediaRouteChooserDialogFragment"

.field private static final ITEM_LAYOUTS:[I = null

.field private static final TAG:Ljava/lang/String; = "MediaRouteChooserDialogFragment"


# instance fields
.field private mAdapter:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;

.field final mCallback:Lcom/android/internal/app/MediaRouteChooserDialogFragment$MediaRouterCallback;

.field final mComparator:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteComparator;

.field private mExtendedSettingsListener:Landroid/view/View$OnClickListener;

.field private mIgnoreCallbackVolumeChanges:Z

.field private mIgnoreSliderVolumeChanges:Z

.field private mInflater:Landroid/view/LayoutInflater;

.field private mLauncherListener:Lcom/android/internal/app/MediaRouteChooserDialogFragment$LauncherListener;

.field private mListView:Landroid/widget/ListView;

.field private mRouteTypes:I

.field mRouter:Landroid/media/MediaRouter;

.field private mVolumeIcon:Landroid/widget/ImageView;

.field private mVolumeSlider:Landroid/widget/SeekBar;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/4 v0, 0x5

    new-array v0, v0, [I

    fill-array-data v0, :array_a

    sput-object v0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->ITEM_LAYOUTS:[I

    return-void

    nop

    :array_a
    .array-data 0x4
        0x6bt 0x0t 0x9t 0x1t
        0x6at 0x0t 0x9t 0x1t
        0x67t 0x0t 0x9t 0x1t
        0x68t 0x0t 0x9t 0x1t
        0x69t 0x0t 0x9t 0x1t
    .end array-data
.end method

.method public constructor <init>()V
    .registers 3

    .prologue
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    new-instance v0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteComparator;

    invoke-direct {v0, p0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteComparator;-><init>(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)V

    iput-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mComparator:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteComparator;

    new-instance v0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$MediaRouterCallback;

    invoke-direct {v0, p0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment$MediaRouterCallback;-><init>(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)V

    iput-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mCallback:Lcom/android/internal/app/MediaRouteChooserDialogFragment$MediaRouterCallback;

    const/4 v0, 0x1

    const v1, 0x103012e

    invoke-virtual {p0, v0, v1}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->setStyle(II)V

    return-void
.end method

.method static synthetic access$000(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)I
    .registers 2
    .parameter "x0"

    .prologue
    iget v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouteTypes:I

    return v0
.end method

.method static synthetic access$100(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Landroid/widget/ListView;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mListView:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$200()[I
    .registers 1

    .prologue
    sget-object v0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->ITEM_LAYOUTS:[I

    return-object v0
.end method

.method static synthetic access$300(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Landroid/view/LayoutInflater;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mInflater:Landroid/view/LayoutInflater;

    return-object v0
.end method

.method static synthetic access$700(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mAdapter:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;

    return-object v0
.end method

.method static synthetic access$800(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Z
    .registers 2
    .parameter "x0"

    .prologue
    iget-boolean v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mIgnoreCallbackVolumeChanges:Z

    return v0
.end method

.method static synthetic access$802(Lcom/android/internal/app/MediaRouteChooserDialogFragment;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-boolean p1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mIgnoreCallbackVolumeChanges:Z

    return p1
.end method

.method static synthetic access$900(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Landroid/widget/SeekBar;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;

    return-object v0
.end method


# virtual methods
.method changeVolume(I)V
    .registers 6
    .parameter "newValue"

    .prologue
    iget-boolean v2, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mIgnoreSliderVolumeChanges:Z

    if-eqz v2, :cond_5

    :cond_4
    :goto_4
    return-void

    :cond_5
    iget-object v2, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouter:Landroid/media/MediaRouter;

    iget v3, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouteTypes:I

    invoke-virtual {v2, v3}, Landroid/media/MediaRouter;->getSelectedRoute(I)Landroid/media/MediaRouter$RouteInfo;

    move-result-object v1

    .local v1, selectedRoute:Landroid/media/MediaRouter$RouteInfo;
    invoke-virtual {v1}, Landroid/media/MediaRouter$RouteInfo;->getVolumeHandling()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_4

    invoke-virtual {v1}, Landroid/media/MediaRouter$RouteInfo;->getVolumeMax()I

    move-result v0

    .local v0, maxVolume:I
    const/4 v2, 0x0

    invoke-static {p1, v0}, Ljava/lang/Math;->min(II)I

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result p1

    invoke-virtual {v1, p1}, Landroid/media/MediaRouter$RouteInfo;->requestSetVolume(I)V

    goto :goto_4
.end method

.method public onAttach(Landroid/app/Activity;)V
    .registers 3
    .parameter "activity"

    .prologue
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onAttach(Landroid/app/Activity;)V

    const-string/jumbo v0, "media_router"

    invoke-virtual {p1, v0}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/MediaRouter;

    iput-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouter:Landroid/media/MediaRouter;

    return-void
.end method

.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .registers 5
    .parameter "savedInstanceState"

    .prologue
    new-instance v0, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;

    invoke-virtual {p0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {p0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->getTheme()I

    move-result v2

    invoke-direct {v0, p0, v1, v2}, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteChooserDialog;-><init>(Lcom/android/internal/app/MediaRouteChooserDialogFragment;Landroid/content/Context;I)V

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .registers 10
    .parameter "inflater"
    .parameter "container"
    .parameter "savedInstanceState"

    .prologue
    const/4 v5, 0x0

    iput-object p1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mInflater:Landroid/view/LayoutInflater;

    const v3, 0x1090066

    invoke-virtual {p1, v3, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .local v1, layout:Landroid/view/View;
    const v3, 0x10202db

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iput-object v3, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeIcon:Landroid/widget/ImageView;

    const v3, 0x10202dc

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/SeekBar;

    iput-object v3, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;

    invoke-virtual {p0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->updateVolume()V

    iget-object v3, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;

    new-instance v4, Lcom/android/internal/app/MediaRouteChooserDialogFragment$VolumeSliderChangeListener;

    invoke-direct {v4, p0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment$VolumeSliderChangeListener;-><init>(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)V

    invoke-virtual {v3, v4}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    iget-object v3, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mExtendedSettingsListener:Landroid/view/View$OnClickListener;

    if-eqz v3, :cond_40

    const v3, 0x10202dd

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .local v0, extendedSettingsButton:Landroid/view/View;
    invoke-virtual {v0, v5}, Landroid/view/View;->setVisibility(I)V

    iget-object v3, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mExtendedSettingsListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .end local v0           #extendedSettingsButton:Landroid/view/View;
    :cond_40
    const v3, 0x102000a

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    .local v2, list:Landroid/widget/ListView;
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setItemsCanFocus(Z)V

    new-instance v3, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;

    invoke-direct {v3, p0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;-><init>(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)V

    iput-object v3, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mAdapter:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    iget-object v3, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mAdapter:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    iput-object v2, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mListView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouter:Landroid/media/MediaRouter;

    iget v4, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouteTypes:I

    iget-object v5, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mCallback:Lcom/android/internal/app/MediaRouteChooserDialogFragment$MediaRouterCallback;

    invoke-virtual {v3, v4, v5}, Landroid/media/MediaRouter;->addCallback(ILandroid/media/MediaRouter$Callback;)V

    iget-object v3, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mAdapter:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;

    invoke-virtual {v3}, Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;->scrollToSelectedItem()V

    return-object v1
.end method

.method public onDetach()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    invoke-super {p0}, Landroid/app/DialogFragment;->onDetach()V

    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mLauncherListener:Lcom/android/internal/app/MediaRouteChooserDialogFragment$LauncherListener;

    if-eqz v0, :cond_d

    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mLauncherListener:Lcom/android/internal/app/MediaRouteChooserDialogFragment$LauncherListener;

    invoke-interface {v0, p0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment$LauncherListener;->onDetached(Lcom/android/internal/app/MediaRouteChooserDialogFragment;)V

    :cond_d
    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mAdapter:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;

    if-eqz v0, :cond_13

    iput-object v2, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mAdapter:Lcom/android/internal/app/MediaRouteChooserDialogFragment$RouteAdapter;

    :cond_13
    iput-object v2, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mInflater:Landroid/view/LayoutInflater;

    iget-object v0, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouter:Landroid/media/MediaRouter;

    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mCallback:Lcom/android/internal/app/MediaRouteChooserDialogFragment$MediaRouterCallback;

    invoke-virtual {v0, v1}, Landroid/media/MediaRouter;->removeCallback(Landroid/media/MediaRouter$Callback;)V

    iput-object v2, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouter:Landroid/media/MediaRouter;

    return-void
.end method

.method public onResume()V
    .registers 1

    .prologue
    invoke-super {p0}, Landroid/app/DialogFragment;->onResume()V

    return-void
.end method

.method public setExtendedSettingsClickListener(Landroid/view/View$OnClickListener;)V
    .registers 2
    .parameter "listener"

    .prologue
    iput-object p1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mExtendedSettingsListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method public setLauncherListener(Lcom/android/internal/app/MediaRouteChooserDialogFragment$LauncherListener;)V
    .registers 2
    .parameter "listener"

    .prologue
    iput-object p1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mLauncherListener:Lcom/android/internal/app/MediaRouteChooserDialogFragment$LauncherListener;

    return-void
.end method

.method public setRouteTypes(I)V
    .registers 2
    .parameter "types"

    .prologue
    iput p1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouteTypes:I

    return-void
.end method

.method updateVolume()V
    .registers 6

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouter:Landroid/media/MediaRouter;

    if-nez v1, :cond_7

    :goto_6
    return-void

    :cond_7
    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouter:Landroid/media/MediaRouter;

    iget v2, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mRouteTypes:I

    invoke-virtual {v1, v2}, Landroid/media/MediaRouter;->getSelectedRoute(I)Landroid/media/MediaRouter$RouteInfo;

    move-result-object v0

    .local v0, selectedRoute:Landroid/media/MediaRouter$RouteInfo;
    iget-object v2, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeIcon:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/media/MediaRouter$RouteInfo;->getPlaybackType()I

    move-result v1

    if-nez v1, :cond_37

    const v1, 0x10802a6

    :goto_1a
    invoke-virtual {v2, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    iput-boolean v3, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mIgnoreSliderVolumeChanges:Z

    invoke-virtual {v0}, Landroid/media/MediaRouter$RouteInfo;->getVolumeHandling()I

    move-result v1

    if-nez v1, :cond_3b

    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;

    invoke-virtual {v1, v3}, Landroid/widget/SeekBar;->setMax(I)V

    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;

    invoke-virtual {v1, v3}, Landroid/widget/SeekBar;->setProgress(I)V

    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;

    invoke-virtual {v1, v4}, Landroid/widget/SeekBar;->setEnabled(Z)V

    :goto_34
    iput-boolean v4, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mIgnoreSliderVolumeChanges:Z

    goto :goto_6

    :cond_37
    const v1, 0x1080315

    goto :goto_1a

    :cond_3b
    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;

    invoke-virtual {v1, v3}, Landroid/widget/SeekBar;->setEnabled(Z)V

    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;

    invoke-virtual {v0}, Landroid/media/MediaRouter$RouteInfo;->getVolumeMax()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/SeekBar;->setMax(I)V

    iget-object v1, p0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->mVolumeSlider:Landroid/widget/SeekBar;

    invoke-virtual {v0}, Landroid/media/MediaRouter$RouteInfo;->getVolume()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/SeekBar;->setProgress(I)V

    goto :goto_34
.end method
