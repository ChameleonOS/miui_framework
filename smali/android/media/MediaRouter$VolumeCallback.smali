.class public abstract Landroid/media/MediaRouter$VolumeCallback;
.super Ljava/lang/Object;
.source "MediaRouter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/MediaRouter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "VolumeCallback"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 1654
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract onVolumeSetRequest(Landroid/media/MediaRouter$RouteInfo;I)V
.end method

.method public abstract onVolumeUpdateRequest(Landroid/media/MediaRouter$RouteInfo;I)V
.end method
