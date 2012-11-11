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
    invoke-direct {p0}, Landroid/media/MediaRouter$SimpleCallback;-><init>()V

    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Landroid/app/MediaRouteActionProvider$RouterCallback;->mAp:Ljava/lang/ref/WeakReference;

    return-void
.end method


# virtual methods
.method public onRouteAdded(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;)V
    .registers 5
    .parameter "router"
    .parameter "info"

    .prologue
    iget-object v1, p0, Landroid/app/MediaRouteActionProvider$RouterCallback;->mAp:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/MediaRouteActionProvider;

    .local v0, ap:Landroid/app/MediaRouteActionProvider;
    if-nez v0, :cond_e

    invoke-virtual {p1, p0}, Landroid/media/MediaRouter;->removeCallback(Landroid/media/MediaRouter$Callback;)V

    :goto_d
    return-void

    :cond_e
    invoke-virtual {v0}, Landroid/app/MediaRouteActionProvider;->refreshVisibility()V

    goto :goto_d
.end method

.method public onRouteRemoved(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;)V
    .registers 5
    .parameter "router"
    .parameter "info"

    .prologue
    iget-object v1, p0, Landroid/app/MediaRouteActionProvider$RouterCallback;->mAp:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/MediaRouteActionProvider;

    .local v0, ap:Landroid/app/MediaRouteActionProvider;
    if-nez v0, :cond_e

    invoke-virtual {p1, p0}, Landroid/media/MediaRouter;->removeCallback(Landroid/media/MediaRouter$Callback;)V

    :goto_d
    return-void

    :cond_e
    invoke-virtual {v0}, Landroid/app/MediaRouteActionProvider;->refreshVisibility()V

    goto :goto_d
.end method
