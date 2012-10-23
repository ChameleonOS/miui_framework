.class public Landroid/app/MediaRouteActionProvider;
.super Landroid/view/ActionProvider;
.source "MediaRouteActionProvider.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/app/MediaRouteActionProvider$RouterCallback;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "MediaRouteActionProvider"


# instance fields
.field private mCallback:Landroid/app/MediaRouteActionProvider$RouterCallback;

.field private mContext:Landroid/content/Context;

.field private mExtendedSettingsListener:Landroid/view/View$OnClickListener;

.field private mMenuItem:Landroid/view/MenuItem;

.field private mRouteTypes:I

.field private mRouter:Landroid/media/MediaRouter;

.field private mView:Landroid/app/MediaRouteButton;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 44
    invoke-direct {p0, p1}, Landroid/view/ActionProvider;-><init>(Landroid/content/Context;)V

    .line 45
    iput-object p1, p0, Landroid/app/MediaRouteActionProvider;->mContext:Landroid/content/Context;

    .line 46
    const-string/jumbo v0, "media_router"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/MediaRouter;

    iput-object v0, p0, Landroid/app/MediaRouteActionProvider;->mRouter:Landroid/media/MediaRouter;

    .line 47
    new-instance v0, Landroid/app/MediaRouteActionProvider$RouterCallback;

    invoke-direct {v0, p0}, Landroid/app/MediaRouteActionProvider$RouterCallback;-><init>(Landroid/app/MediaRouteActionProvider;)V

    iput-object v0, p0, Landroid/app/MediaRouteActionProvider;->mCallback:Landroid/app/MediaRouteActionProvider$RouterCallback;

    .line 52
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/app/MediaRouteActionProvider;->setRouteTypes(I)V

    .line 53
    return-void
.end method

.method private getActivity()Landroid/app/Activity;
    .registers 4

    .prologue
    .line 109
    iget-object v0, p0, Landroid/app/MediaRouteActionProvider;->mContext:Landroid/content/Context;

    .line 110
    .local v0, context:Landroid/content/Context;
    :goto_2
    instance-of v1, v0, Landroid/content/ContextWrapper;

    if-eqz v1, :cond_11

    instance-of v1, v0, Landroid/app/Activity;

    if-nez v1, :cond_11

    .line 111
    check-cast v0, Landroid/content/ContextWrapper;

    .end local v0           #context:Landroid/content/Context;
    invoke-virtual {v0}, Landroid/content/ContextWrapper;->getBaseContext()Landroid/content/Context;

    move-result-object v0

    .restart local v0       #context:Landroid/content/Context;
    goto :goto_2

    .line 113
    :cond_11
    instance-of v1, v0, Landroid/app/Activity;

    if-nez v1, :cond_1d

    .line 114
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "The MediaRouteActionProvider\'s Context is not an Activity."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 118
    :cond_1d
    check-cast v0, Landroid/app/Activity;

    .end local v0           #context:Landroid/content/Context;
    return-object v0
.end method


# virtual methods
.method public isVisible()Z
    .registers 3

    .prologue
    const/4 v0, 0x1

    .line 135
    iget-object v1, p0, Landroid/app/MediaRouteActionProvider;->mRouter:Landroid/media/MediaRouter;

    invoke-virtual {v1}, Landroid/media/MediaRouter;->getRouteCount()I

    move-result v1

    if-le v1, v0, :cond_a

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public onCreateActionView()Landroid/view/View;
    .registers 3

    .prologue
    .line 71
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Use onCreateActionView(MenuItem) instead."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onCreateActionView(Landroid/view/MenuItem;)Landroid/view/View;
    .registers 4
    .parameter "item"

    .prologue
    .line 76
    iget-object v0, p0, Landroid/app/MediaRouteActionProvider;->mMenuItem:Landroid/view/MenuItem;

    if-nez v0, :cond_8

    iget-object v0, p0, Landroid/app/MediaRouteActionProvider;->mView:Landroid/app/MediaRouteButton;

    if-eqz v0, :cond_10

    .line 77
    :cond_8
    const-string v0, "MediaRouteActionProvider"

    const-string/jumbo v1, "onCreateActionView: this ActionProvider is already associated with a menu item. Don\'t reuse MediaRouteActionProvider instances! Abandoning the old one..."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 81
    :cond_10
    iput-object p1, p0, Landroid/app/MediaRouteActionProvider;->mMenuItem:Landroid/view/MenuItem;

    .line 82
    new-instance v0, Landroid/app/MediaRouteButton;

    iget-object v1, p0, Landroid/app/MediaRouteActionProvider;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/MediaRouteButton;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroid/app/MediaRouteActionProvider;->mView:Landroid/app/MediaRouteButton;

    .line 83
    iget-object v0, p0, Landroid/app/MediaRouteActionProvider;->mView:Landroid/app/MediaRouteButton;

    iget v1, p0, Landroid/app/MediaRouteActionProvider;->mRouteTypes:I

    invoke-virtual {v0, v1}, Landroid/app/MediaRouteButton;->setRouteTypes(I)V

    .line 84
    iget-object v0, p0, Landroid/app/MediaRouteActionProvider;->mView:Landroid/app/MediaRouteButton;

    iget-object v1, p0, Landroid/app/MediaRouteActionProvider;->mExtendedSettingsListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/app/MediaRouteButton;->setExtendedSettingsClickListener(Landroid/view/View$OnClickListener;)V

    .line 85
    iget-object v0, p0, Landroid/app/MediaRouteActionProvider;->mView:Landroid/app/MediaRouteButton;

    return-object v0
.end method

.method public onPerformDefaultAction()Z
    .registers 5

    .prologue
    .line 90
    invoke-direct {p0}, Landroid/app/MediaRouteActionProvider;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 92
    .local v1, fm:Landroid/app/FragmentManager;
    const-string v2, "android:MediaRouteChooserDialogFragment"

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    .line 95
    .local v0, dialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;
    if-eqz v0, :cond_1c

    .line 96
    const-string v2, "MediaRouteActionProvider"

    const-string/jumbo v3, "onPerformDefaultAction(): Chooser dialog already showing!"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 97
    const/4 v2, 0x0

    .line 104
    :goto_1b
    return v2

    .line 100
    :cond_1c
    new-instance v0, Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    .end local v0           #dialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;
    invoke-direct {v0}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;-><init>()V

    .line 101
    .restart local v0       #dialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;
    iget-object v2, p0, Landroid/app/MediaRouteActionProvider;->mExtendedSettingsListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->setExtendedSettingsClickListener(Landroid/view/View$OnClickListener;)V

    .line 102
    iget v2, p0, Landroid/app/MediaRouteActionProvider;->mRouteTypes:I

    invoke-virtual {v0, v2}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->setRouteTypes(I)V

    .line 103
    const-string v2, "android:MediaRouteChooserDialogFragment"

    invoke-virtual {v0, v1, v2}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 104
    const/4 v2, 0x1

    goto :goto_1b
.end method

.method public overridesItemVisibility()Z
    .registers 2

    .prologue
    .line 130
    const/4 v0, 0x1

    return v0
.end method

.method public setExtendedSettingsClickListener(Landroid/view/View$OnClickListener;)V
    .registers 3
    .parameter "listener"

    .prologue
    .line 122
    iput-object p1, p0, Landroid/app/MediaRouteActionProvider;->mExtendedSettingsListener:Landroid/view/View$OnClickListener;

    .line 123
    iget-object v0, p0, Landroid/app/MediaRouteActionProvider;->mView:Landroid/app/MediaRouteButton;

    if-eqz v0, :cond_b

    .line 124
    iget-object v0, p0, Landroid/app/MediaRouteActionProvider;->mView:Landroid/app/MediaRouteButton;

    invoke-virtual {v0, p1}, Landroid/app/MediaRouteButton;->setExtendedSettingsClickListener(Landroid/view/View$OnClickListener;)V

    .line 126
    :cond_b
    return-void
.end method

.method public setRouteTypes(I)V
    .registers 4
    .parameter "types"

    .prologue
    .line 56
    iget v0, p0, Landroid/app/MediaRouteActionProvider;->mRouteTypes:I

    if-ne v0, p1, :cond_5

    .line 67
    :cond_4
    :goto_4
    return-void

    .line 57
    :cond_5
    iget v0, p0, Landroid/app/MediaRouteActionProvider;->mRouteTypes:I

    if-eqz v0, :cond_10

    .line 58
    iget-object v0, p0, Landroid/app/MediaRouteActionProvider;->mRouter:Landroid/media/MediaRouter;

    iget-object v1, p0, Landroid/app/MediaRouteActionProvider;->mCallback:Landroid/app/MediaRouteActionProvider$RouterCallback;

    invoke-virtual {v0, v1}, Landroid/media/MediaRouter;->removeCallback(Landroid/media/MediaRouter$Callback;)V

    .line 60
    :cond_10
    iput p1, p0, Landroid/app/MediaRouteActionProvider;->mRouteTypes:I

    .line 61
    if-eqz p1, :cond_1b

    .line 62
    iget-object v0, p0, Landroid/app/MediaRouteActionProvider;->mRouter:Landroid/media/MediaRouter;

    iget-object v1, p0, Landroid/app/MediaRouteActionProvider;->mCallback:Landroid/app/MediaRouteActionProvider$RouterCallback;

    invoke-virtual {v0, p1, v1}, Landroid/media/MediaRouter;->addCallback(ILandroid/media/MediaRouter$Callback;)V

    .line 64
    :cond_1b
    iget-object v0, p0, Landroid/app/MediaRouteActionProvider;->mView:Landroid/app/MediaRouteButton;

    if-eqz v0, :cond_4

    .line 65
    iget-object v0, p0, Landroid/app/MediaRouteActionProvider;->mView:Landroid/app/MediaRouteButton;

    iget v1, p0, Landroid/app/MediaRouteActionProvider;->mRouteTypes:I

    invoke-virtual {v0, v1}, Landroid/app/MediaRouteButton;->setRouteTypes(I)V

    goto :goto_4
.end method
