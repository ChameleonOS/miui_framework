.class Landroid/app/MediaRouteButton$MediaRouteCallback;
.super Landroid/media/MediaRouter$SimpleCallback;
.source "MediaRouteButton.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/MediaRouteButton;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MediaRouteCallback"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/app/MediaRouteButton;


# direct methods
.method private constructor <init>(Landroid/app/MediaRouteButton;)V
    .registers 2
    .parameter

    .prologue
    .line 357
    iput-object p1, p0, Landroid/app/MediaRouteButton$MediaRouteCallback;->this$0:Landroid/app/MediaRouteButton;

    invoke-direct {p0}, Landroid/media/MediaRouter$SimpleCallback;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/app/MediaRouteButton;Landroid/app/MediaRouteButton$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 357
    invoke-direct {p0, p1}, Landroid/app/MediaRouteButton$MediaRouteCallback;-><init>(Landroid/app/MediaRouteButton;)V

    return-void
.end method


# virtual methods
.method public onRouteAdded(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;)V
    .registers 4
    .parameter "router"
    .parameter "info"

    .prologue
    .line 370
    iget-object v0, p0, Landroid/app/MediaRouteButton$MediaRouteCallback;->this$0:Landroid/app/MediaRouteButton;

    invoke-virtual {v0}, Landroid/app/MediaRouteButton;->updateRouteCount()V

    .line 371
    return-void
.end method

.method public onRouteGrouped(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;Landroid/media/MediaRouter$RouteGroup;I)V
    .registers 6
    .parameter "router"
    .parameter "info"
    .parameter "group"
    .parameter "index"

    .prologue
    .line 381
    iget-object v0, p0, Landroid/app/MediaRouteButton$MediaRouteCallback;->this$0:Landroid/app/MediaRouteButton;

    invoke-virtual {v0}, Landroid/app/MediaRouteButton;->updateRouteCount()V

    .line 382
    return-void
.end method

.method public onRouteRemoved(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;)V
    .registers 4
    .parameter "router"
    .parameter "info"

    .prologue
    .line 375
    iget-object v0, p0, Landroid/app/MediaRouteButton$MediaRouteCallback;->this$0:Landroid/app/MediaRouteButton;

    invoke-virtual {v0}, Landroid/app/MediaRouteButton;->updateRouteCount()V

    .line 376
    return-void
.end method

.method public onRouteSelected(Landroid/media/MediaRouter;ILandroid/media/MediaRouter$RouteInfo;)V
    .registers 5
    .parameter "router"
    .parameter "type"
    .parameter "info"

    .prologue
    .line 360
    iget-object v0, p0, Landroid/app/MediaRouteButton$MediaRouteCallback;->this$0:Landroid/app/MediaRouteButton;

    invoke-virtual {v0}, Landroid/app/MediaRouteButton;->updateRemoteIndicator()V

    .line 361
    return-void
.end method

.method public onRouteUngrouped(Landroid/media/MediaRouter;Landroid/media/MediaRouter$RouteInfo;Landroid/media/MediaRouter$RouteGroup;)V
    .registers 5
    .parameter "router"
    .parameter "info"
    .parameter "group"

    .prologue
    .line 386
    iget-object v0, p0, Landroid/app/MediaRouteButton$MediaRouteCallback;->this$0:Landroid/app/MediaRouteButton;

    invoke-virtual {v0}, Landroid/app/MediaRouteButton;->updateRouteCount()V

    .line 387
    return-void
.end method

.method public onRouteUnselected(Landroid/media/MediaRouter;ILandroid/media/MediaRouter$RouteInfo;)V
    .registers 5
    .parameter "router"
    .parameter "type"
    .parameter "info"

    .prologue
    .line 365
    iget-object v0, p0, Landroid/app/MediaRouteButton$MediaRouteCallback;->this$0:Landroid/app/MediaRouteButton;

    invoke-virtual {v0}, Landroid/app/MediaRouteButton;->updateRemoteIndicator()V

    .line 366
    return-void
.end method
