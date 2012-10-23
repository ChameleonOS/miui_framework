.class Landroid/app/MediaRouteActionProvider$RouterCallback;
.super Landroid/media/MediaRouter$SimpleCallback;
.source "MediaRouteActionProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/MediaRouteActionProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RouterCallback"
.end annotation


# instance fields
.field private mAp:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/app/MediaRouteActionProvider;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Landroid/app/MediaRouteActionProvider;)V
    .registers 3
    .parameter "ap"

    .prologue
    .line 141
    invoke-direct {p0}, Landroid/media/MediaRouter$SimpleCallback;-><init>()V

    .line 142
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Landroid/app/MediaRouteActionProvider$RouterCallback;->mAp:Ljava/lang/ref/WeakReference;

    .line 143
    return-void
.end method


# virtual methods
.method public onRouteAdded(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;)V
    .registers 5
    .parameter "router"
    .parameter "info"

    .prologue
    .line 147
    iget-object v1, p0, Landroid/app/MediaRouteActionProvider$RouterCallback;->mAp:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/MediaRouteActionProvider;

    .line 148
    .local v0, ap:Landroid/app/MediaRouteActionProvider;
    if-nez v0, :cond_e

    .line 149
    invoke-virtual {p1, p0}, Landroid/media/MediaRouter;->removeCallback(Landroid/media/MediaRouter$Callback;)V

    .line 154
    :goto_d
    return-void

    .line 153
    :cond_e
    invoke-virtual {v0}, Landroid/app/MediaRouteActionProvider;->refreshVisibility()V

    goto :goto_d
.end method

.method public onRouteRemoved(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;)V
    .registers 5
    .parameter "router"
    .parameter "info"

    .prologue
    .line 158
    iget-object v1, p0, Landroid/app/MediaRouteActionProvider$RouterCallback;->mAp:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/MediaRouteActionProvider;

    .line 159
    .local v0, ap:Landroid/app/MediaRouteActionProvider;
    if-nez v0, :cond_e

    .line 160
    invoke-virtual {p1, p0}, Landroid/media/MediaRouter;->removeCallback(Landroid/media/MediaRouter$Callback;)V

    .line 165
    :goto_d
    return-void

    .line 164
    :cond_e
    invoke-virtual {v0}, Landroid/app/MediaRouteActionProvider;->refreshVisibility()V

    goto :goto_d
.end method
